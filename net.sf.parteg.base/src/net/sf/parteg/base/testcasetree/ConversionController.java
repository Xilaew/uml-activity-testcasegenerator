package net.sf.parteg.base.testcasetree;

import java.util.ArrayList;

import net.sf.parteg.base.testcasetree.eventtree.EventNode;
import net.sf.parteg.base.testcasetree.eventtree.EventTree;
import net.sf.parteg.base.testcasetree.generated.TCGEquivalenceClass;
import net.sf.parteg.base.testcasetree.generated.TCGNode;
import net.sf.parteg.base.testcasetree.generated.TCGParameter;
import net.sf.parteg.base.testcasetree.generated.TCGPrimitiveParameter;
import net.sf.parteg.base.testcasetree.generated.TestCaseGraph;
import net.sf.parteg.base.testcasetree.helperclasses.TCGNodeHelperClass;
import net.sf.parteg.base.testcasetree.helperclasses.TCGParameterHelperClass;
import net.sf.parteg.base.testcasetree.ocl.TCTConfiguration;
import net.sf.parteg.base.testcasetree.ocl.TestCaseGraphHelper;
import net.sf.parteg.base.testcasetree.ocl.transformation.CoverageCriteria;
import net.sf.parteg.base.testcasetree.ocl.parser.OCLParser;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.uml.OCLExpression;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Event;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.PseudostateKind;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.Transition;

public class ConversionController {

	private final StateMachine m_oStateMachine;
	private TestCaseGraphHelper m_oTestCaseGraphHelper;
	
	public ConversionController(final StateMachine in_oStateMachine)
	{
		m_oStateMachine = in_oStateMachine;
		m_oTestCaseGraphHelper = new TestCaseGraphHelper();
	}
	
	public TestCaseGraphHelper getTestCaseGraphHelper()
	{
		return m_oTestCaseGraphHelper;
	}
	
	public TestCaseGraph getTestCaseGraph()
	{
		return m_oTestCaseGraphHelper.getTestCaseGraph();
	}
	
	public void saveTreeToFiles()
	{
		m_oTestCaseGraphHelper.saveTreeToFiles();
	}
	
	/**
	 * here the whole conversion process starts
	 * @throws Exception
	 */
	public void convertStateMachine() throws Exception
	{
		SystemModelState oSMState = new SystemModelState(m_oTestCaseGraphHelper.getHistory(), SystemModelHelper.findInitState(m_oStateMachine));
		convertVertex(oSMState, m_oTestCaseGraphHelper.getRoot());
	}
	
	/**
	 * 
	 * @param in_oSMState
	 * @param in_oTCGNode
	 * @throws Exception
	 */
	private void convertVertex(SystemModelState in_oSMState, TCGNode in_oTCGNode) throws Exception
	{
		// transition coverage - state already visited?
		if(Configuration.getTransitionBasedCoverageCriterion().equals(Configuration.TransitionBasedCoverageCriterion.TRANSITION_COVERAGE))
			if(m_oTestCaseGraphHelper.getHistory().isSystemStateVisited(in_oSMState))
				return;
		// state coverage - state already visited?
//		if(Configuration.getTransitionBasedCoverageCriterion().equals(Configuration.TransitionBasedCoverageCriterion.STATE_COVERAGE))
//			if(m_oTestCaseGraphHelper.getHistory().isSystemStateVisited(in_oSMState))
//				return;
		
		// remember visited states
		m_oTestCaseGraphHelper.getHistory().addVisitedState(in_oSMState);
		
		// check if one of the state of the current system model state is a pseudo state -> handle this first!
		// TODO können durch ein Event mehrere pseudo states erreicht werden
		Pseudostate oPseudostate = in_oSMState.returnContainedPseudoState();
		if(oPseudostate != null) {
			convertPseudoState(in_oSMState, oPseudostate, in_oTCGNode);
		} else {
			convertState(in_oSMState, in_oTCGNode);
		}
		
		// no circles - remove visited state again -> all paths to this node should be allowed
		m_oTestCaseGraphHelper.getHistory().removeVisitedState(in_oSMState);		
	}
	
	/*
	 * PseudoStates können nicht auf Events reagieren - wesentlicher Unterschied zu States!
	 * trotzdem sollen die guard conditions weiterhin betrachtet werden.
	 */
	private void convertPseudoState(
			SystemModelState in_oSMState,
			Pseudostate in_oPseudostate,
			TCGNode in_oTCGNode) throws Exception
	{
		if(in_oPseudostate.getKind().equals(PseudostateKind.CHOICE_LITERAL) ||
				in_oPseudostate.getKind().equals(PseudostateKind.JUNCTION_LITERAL))
		{
			// get outgoing transitions
			EList<Transition> colTransitions = in_oPseudostate.getOutgoings();
			
			// set name of the passed state
			in_oTCGNode.setName(in_oSMState.getName() + "_" + String.valueOf(m_oTestCaseGraphHelper.getTestCaseGraph().getNodes().size()));
			
			org.eclipse.uml2.uml.Class oContextClass = Configuration.getContextClassForVertex(in_oPseudostate);
			boolean bAnyTransitionAllowed = false;
			
			for(Transition oSMTransition : colTransitions)
			{
				// new vertex is not allowed if target vertex is already existing 
				if(!(Configuration.getTransitionBasedCoverageCriterion().equals(Configuration.TransitionBasedCoverageCriterion.STATE_COVERAGE) &&
						m_oTestCaseGraphHelper.getHistory().vertexHasEverBeenVisited(oSMTransition.getTarget())))
				{
					OCLExpression oExpression = OCLParser.parseCondition(
							SystemModelHelper.getTransitionGuard(oSMTransition), 
							oContextClass, Configuration.getOCLGuardId());
					// guard conditions verarbeiten, aber das event nicht separat erzeugen
					ArrayList<TCGNode> colNodes = m_oTestCaseGraphHelper.createTCGPartFromExpressionForCallEvent(
							oExpression, in_oTCGNode, null, oContextClass, false);
					
					for(TCGNode oNewTCGNode : colNodes) 
					{
						bAnyTransitionAllowed = true;
						if(oNewTCGNode.isCorrespondsNegativeExpression())
						{
							// guard condition prevented this arc to be executed - retry from original node
							TCGNodeHelperClass.setInvariantForTCGNode(oSMTransition.getSource(),
									oContextClass, oNewTCGNode);
							convertVertex(in_oSMState, oNewTCGNode);
						}
					}

					// ### change the state history only for a real change of state
					
					m_oTestCaseGraphHelper.getHistory().markTransitionAsAlreadyUsed(oSMTransition);
					// exchange current system state - keep track of the current states across several regions
					in_oSMState = new SystemModelState(m_oTestCaseGraphHelper.getHistory(), in_oSMState);
					in_oSMState.exchangeVertices(oSMTransition.getSource(), oSMTransition.getTarget());
					
					for(TCGNode oNewTCGNode : colNodes) 
					{
						bAnyTransitionAllowed = true;
						if(!oNewTCGNode.isCorrespondsNegativeExpression())
						{
							// add further nodes to TestCaseGraph (for each method)
							convertMethod(in_oSMState, oSMTransition, oNewTCGNode, oContextClass);
						}
					}
					
					m_oTestCaseGraphHelper.getHistory().unmarkTransitionAsAlreadyUsed(oSMTransition);				
					in_oSMState = m_oTestCaseGraphHelper.getHistory().getCurrentSystemModelState();
				}
			}
			// target of transition from pseudo state is not allowed -> also remove node for pseudo state 
			if(bAnyTransitionAllowed == false)
			{
				m_oTestCaseGraphHelper.removeNode(in_oTCGNode);
			}
		}
	}
	
	/**
	 * calls convertEvent for all available events
	 * @param in_oSMState
	 * @param in_oTCGNode
	 * @throws Exception
	 */
	private void convertState(SystemModelState in_oSMState, TCGNode in_oTCGNode) throws Exception
	{
		// get outgoing transitions
		ArrayList<Transition> colTransitions = SystemModelHelper.getOutgoingTransitions(in_oSMState);
		
		// set name of the passed state
		in_oTCGNode.setName(in_oSMState.getName() + "_" + String.valueOf(m_oTestCaseGraphHelper.getTestCaseGraph().getNodes().size()));
		
		// get all the events that trigger transitions outgoing from the passed node
		ArrayList<Event> colEvents = SystemModelHelper.getEvents(colTransitions);
		
		// iterate through all events that trigger at least one outgoing transition of in_oSMState
		for(Event oEvent : colEvents)
		{
			convertEvent(in_oSMState, oEvent, colTransitions, in_oTCGNode);
		}
	}

	/**
	 * calls convertMethod and is called by convertState
	 * @param in_oSMState
	 * @param in_oEvent
	 * @param in_colTransitions
	 * @param in_oTCGNode
	 * @throws Exception
	 */
	private void convertEvent(SystemModelState in_oSMState, 
			Event in_oEvent, 
			ArrayList<Transition> in_colTransitions, 
			TCGNode in_oTCGNode) throws Exception
	{
		// increase counter for state machine path length
		m_oTestCaseGraphHelper.incActualStateMachineDepth();
		
		// iterate over all passed transitions
		for(Transition oSMTransition : in_colTransitions)
		{
			// use transition only if it is triggered by in_oEvent and 
			// if it is a default outgoing transition (event == null) of a super state then all sub-regions must be in final state
			// coverage criteria allow this transition
			// new vertex is not allowed if target vertex is already existing 
			if(SystemModelHelper.isEventTriggeringTransition(in_oEvent, oSMTransition) &&
					(in_oSMState.ifSourceSuperStateThenAllSubFinal(oSMTransition) || in_oEvent != null) &&
					transitionAllowedForCoverageCriterion(oSMTransition) &&
					!(Configuration.getTransitionBasedCoverageCriterion().equals(Configuration.TransitionBasedCoverageCriterion.STATE_COVERAGE) &&
							m_oTestCaseGraphHelper.getHistory().vertexHasEverBeenVisited(oSMTransition.getTarget())))
			{

				/*
				 * evaluate the expression of the guard condition
				 * split up the expression depending on the boolean operators
				 * bring expression to normal form
				 */
				//org.eclipse.uml2.uml.Class oContextClass = Configuration.getContextClass(in_oSMState.getSystemState().getContainer().getStateMachine());
				org.eclipse.uml2.uml.Class oContextClass = Configuration.getContextClassForVertex(oSMTransition.getSource());
				Namespace oNamespace = SystemModelHelper.getNamespaceForEvent(
						oSMTransition.getSource(), in_oEvent);

				OCLExpression oExpression = OCLParser.parseCondition(
						SystemModelHelper.getTransitionGuard(oSMTransition), 
						oNamespace, Configuration.getOCLGuardId());
				ArrayList<TCGNode> colNodes = m_oTestCaseGraphHelper.createTCGPartFromExpressionForCallEvent(
						oExpression, in_oTCGNode, in_oEvent, oContextClass, true);

				if(!Configuration.getTransitionBasedCoverageCriterion().equals(Configuration.TransitionBasedCoverageCriterion.STATE_COVERAGE))
				{
					// check all newly generated nodes
					for(TCGNode oNewTCGNode : colNodes) 
					{
						if(oNewTCGNode.isCorrespondsNegativeExpression())
						{
							// guard condition prevented this arc to be executed - retry from original node
							TCGNodeHelperClass.setInvariantForTCGNode(oSMTransition.getSource(),
									oContextClass, oNewTCGNode);
							convertVertex(in_oSMState, oNewTCGNode);
						}
					}
				}
				
				// ### change the state history only for a real change of state

				m_oTestCaseGraphHelper.getHistory().markTransitionAsAlreadyUsed(oSMTransition);
				// exchange current system state - keep track of the current states across several regions
				in_oSMState = new SystemModelState(m_oTestCaseGraphHelper.getHistory(), in_oSMState);
				in_oSMState.exchangeVertices(oSMTransition.getSource(), oSMTransition.getTarget());

				// state coverage: do not execute transitions that lead to an already visited state
				if(!(Configuration.getTransitionBasedCoverageCriterion().equals(Configuration.TransitionBasedCoverageCriterion.STATE_COVERAGE) &&
						m_oTestCaseGraphHelper.getHistory().isSystemStateVisited(in_oSMState)))
				{
					for(TCGNode oNewTCGNode : colNodes) 
					{
						if(!oNewTCGNode.isCorrespondsNegativeExpression())
						{
							// add further nodes to TestCaseGraph (for each method)
							convertMethod(in_oSMState, oSMTransition, oNewTCGNode, oContextClass);
						}
					}
				}
				m_oTestCaseGraphHelper.getHistory().unmarkTransitionAsAlreadyUsed(oSMTransition);				
				in_oSMState = m_oTestCaseGraphHelper.getHistory().getCurrentSystemModelState();
			}
		}
		// decrease counter for statemachine path length
		m_oTestCaseGraphHelper.decActualStateMachineDepth();
	}
	
	private boolean transitionAllowedForCoverageCriterion(Transition in_oTransition)
	{
		// state coverage oder transition coverage: 
		if(Configuration.getTransitionBasedCoverageCriterion().equals(Configuration.TransitionBasedCoverageCriterion.STATE_COVERAGE))
		{
			return true;
		}
		else if (Configuration.getTransitionBasedCoverageCriterion().equals(Configuration.TransitionBasedCoverageCriterion.TRANSITION_COVERAGE))
		{
			return !m_oTestCaseGraphHelper.getHistory().transitionHasEverBeenVisited(in_oTransition);
		}
		// stop after one loop: do not execute outgoing transitions of an already twice visited state
		else if(Configuration.getTransitionBasedCoverageCriterion().equals(Configuration.TransitionBasedCoverageCriterion.STOP_AFTER_ONE_LOOP_COVERAGE))
		{
			if(!m_oTestCaseGraphHelper.getHistory().sourceOfTransitionBelongsToTransitionWhichIsMarkedAsAlreadyUsed(in_oTransition))
				return true;					
		}
		// stop if one transition in the same path should be executed twice
		else if(Configuration.getTransitionBasedCoverageCriterion().equals(Configuration.TransitionBasedCoverageCriterion.ALL_ONE_LOOP_PATHS_COVERAGE))
		{
			if(!m_oTestCaseGraphHelper.getHistory().transitionIsMarkedAsAlreadyUsed(in_oTransition))
				return true;					
		}
		return false;
	}
	
	/**
	 * calls convertState and is called by convertEvent
	 * @param in_oSMState
	 * @param in_oTransition
	 * @param in_oBehavior
	 * @param in_oTCGNode
	 * @throws Exception
	 */
	private void convertMethod(
			SystemModelState in_oSMState, 
			Transition in_oTransition, 
			TCGNode in_oTCGNode,
			org.eclipse.uml2.uml.Class in_oContextClass) throws Exception
	{
		// find operation corresponding to the current context
		Operation oOperation = TestCaseGraphHelper.getContextEffectSpecification(in_oTransition);
		
		if(oOperation != null)
		{
			// handle preconditions
			convertOperationPrePostcondition(in_oTCGNode, oOperation, 
					in_oSMState, in_oContextClass, in_oTransition);
		}
		else
		{
			// TODO: zusätzliche nodes in tree einbauen auch wenn Transition keinen Effekt hat?
			TCGNodeHelperClass.setInvariantForTCGNode(in_oTransition.getTarget(),
					in_oContextClass, in_oTCGNode);
			convertVertex(in_oSMState, in_oTCGNode);
		}
	}

	/**
	 * handles the conversion of operations preconditions
	 * @param in_oNode
	 * @param in_oOperation
	 * @param in_oSMState
	 * @throws Exception
	 */
	private void convertOperationPrePostcondition(
			TCGNode in_oNode, 
			Operation in_oOperation, 
			SystemModelState in_oSMState,
			org.eclipse.uml2.uml.Class in_oContextClass,
			Transition in_oTransition) throws Exception
	{
		// handle preconditions
		if(in_oOperation.getPreconditions().isEmpty())
		{
			convertOperationPostcondition(in_oNode, in_oOperation, in_oSMState, 
					in_oContextClass, in_oTransition);
		}
		else
		{
			for(Constraint oPreConstraint : in_oOperation.getPreconditions())
			{
				String sPreExpression = SystemModelHelper.getConstraintSpecification(oPreConstraint);
				OCLExpression oExpression = OCLParser.parseCondition(
						sPreExpression, in_oOperation, Configuration.getOCLGuardId());
				ArrayList<TCGNode> colPreNodes = m_oTestCaseGraphHelper.createTCGPartFromExpressionForPrecondition(
						oExpression, in_oNode, in_oOperation, in_oContextClass);
				for(TCGNode oNewTCGNode : colPreNodes)
				{
					// handle postconditions
					convertOperationPostcondition(oNewTCGNode, in_oOperation, in_oSMState, 
							in_oContextClass, in_oTransition);
				}
			}
		}
	}
	
	/**
	 * handles the conversion of operations postconditions
	 * @param in_oNode
	 * @param in_oOperation
	 * @param in_oSMState
	 * @throws Exception
	 */
	private void convertOperationPostcondition(
			TCGNode in_oNode, 
			Operation in_oOperation, 
			SystemModelState in_oSMState,
			org.eclipse.uml2.uml.Class in_oContextClass,
			Transition in_oTransition) throws Exception
	{
		// handle postconditions
		if(in_oOperation.getPostconditions().isEmpty())
		{
			TCGNodeHelperClass.setInvariantForTCGNode(
					in_oTransition.getTarget(),
					in_oContextClass, in_oNode);
			convertVertex(in_oSMState, in_oNode);
		}
		else
		{
			for(Constraint oPostConstraint : in_oOperation.getPostconditions())
			{
				String sPostExpression = SystemModelHelper.getConstraintSpecification(oPostConstraint);
				OCLExpression oPostExpression = OCLParser.parseCondition(
						sPostExpression, in_oOperation, Configuration.getOCLGuardId());
				ArrayList<TCGNode> colPostNodes = m_oTestCaseGraphHelper.createTCGPartFromExpressionForPostcondition(
						oPostExpression, in_oNode, in_oOperation, in_oContextClass);
				for(TCGNode oPostTCGNode : colPostNodes)
				{
					TCGNodeHelperClass.setInvariantForTCGNode(
							in_oTransition.getTarget(),
							in_oContextClass, oPostTCGNode);
					convertVertex(in_oSMState, oPostTCGNode);
				}
			}
		}
	}
	

	// checks if the state machine satisfies basic static criteria
	public void checkStateMachineValidity() throws Exception
	{
		SystemModelHelper.isSystemModelValid(m_oStateMachine);
	}

	// remove all leaves whose paths are covered by other paths 
	public void minimizeTestCaseTree()
	{
		/**
		 * neuer Ansatz:
		 * TestCaseTree wird in EventTree umgewandelt, in dem nur noch
		 * die Ereignisse und Referenzen auf Leaves im TestCaseTree zu finden sind.
		 * Diese Struktur erspart das aufwändige Vergleichen der Event-ketten.
		 * Zu jedem Blatt muss nur der entsprechende Teilbaum untersucht werden
		 * 
		 * Nein! -> Problem: neue Pfade für den nichtdeterministischen Fall möglich!?!
		 */
		EventTree oEventTree = new EventTree(m_oTestCaseGraphHelper); 
		
		// Knoten, die durch gleiche Sequenzen von Ereignissen erreicht werden 
		ArrayList<TCGNode> colDeleteNodes = new ArrayList<TCGNode>();
		for(EventNode oEventNode : oEventTree.getEventNodes())
		{
			ArrayList<TCGNode> colSubNodes = oEventTree.getSubTCGNodesFrom(oEventNode);
			for(TCGNode oSuperNode : oEventNode.getLeafNodes())
			{
				for(TCGNode oSubNode : colSubNodes)
				{
					// all boundaries of super node are equal or enforced in sub node (depends on coverage criteria)
					if((!colDeleteNodes.contains(oSubNode)) &&
						(!oSuperNode.equals(oSubNode)) &&
						(conditionBordersOfSuperNodeContainThoseInSubNode(oSuperNode, oSubNode)))
					{
							colDeleteNodes.add(oSuperNode);
					}
				}
				// compare super node to sub node
				for(TCGNode oSubNode : oEventNode.getLeafNodes())
				{
					// decision coverage needs just one negation per original expression
					// additional decisions are thrown away if we need incomplete partitions
					// or if we satisfy DecisionCoverage
					if((!colDeleteNodes.contains(oSubNode)) &&
						isSubNodeExpressionComprisesSuperNodeExpression(oSuperNode, oSubNode)) 
					{
							colDeleteNodes.add(oSuperNode);
					}
				}
			}
		}

		for(TCGNode oNode : colDeleteNodes)
			m_oTestCaseGraphHelper.removeNode(oNode);						
	}

	private boolean isSubNodeExpressionComprisesSuperNodeExpression(TCGNode in_oSuperNode, TCGNode in_oSubNode)
	{
		if(!in_oSuperNode.equals(in_oSubNode))
		{
			//(!Configuration.isCompletenessForGeneratedPartitions() || 

			// two negative expressions for decision coverage?
			if((TCTConfiguration.getCoverage() == CoverageCriteria.DecisionCoverage) &&
				(in_oSuperNode.isCorrespondsNegativeExpression() && in_oSubNode.isCorrespondsNegativeExpression())) 
				return true;
			
			if(TCTConfiguration.getCoverage() == CoverageCriteria.StatementCoverage)
			{
				if(in_oSuperNode.getOriginalExpression() != null &&
					in_oSubNode.getOriginalExpression() != null)
					if(in_oSuperNode.getOriginalExpression().equals(in_oSubNode.getOriginalExpression()))
						return true;
			}
			
//			// two positive expressions originating from the same expression
//			// iterate over parameters of first node
//			for(TCGParameter oFirstParameter : in_oSuperNode.getParameters())
//			{
//				TCGParameter oSecondParameter = null;
//				// iterate over parameters of second node
//				for(TCGParameter oParameter : in_oSubNode.getParameters())
//				{
//					if(oParameter.getReference().equals(oFirstParameter.getReference()))
//					{
//						oSecondParameter = oParameter;
//						break;
//					}
//				}
//				if(oSecondParameter == null)
//					return false;
//				else
//				{
//					// one parameter's boundaries do not comprise the boundaries of the second one
//					// and
//					// the boundary values of both are not the same and there are not originating from the
//					// same expression (e.g. "<" and ">" for "<>")
//					if(!outerEquivalenceClassContainsInnerClass(
//							oFirstParameter.getEquivalenceClass(), oSecondParameter.getEquivalenceClass(), 
//							Configuration.isCompletenessForGeneratedPartitions() == true) &&
//							(Configuration.isCompletenessForGeneratedPartitions() && 
//									oFirstParameter.getEquivalenceClass().))
//						return false;
//				}
//			}
//			return true;
		}
		return false;
	}
	
	private boolean conditionBordersOfSuperNodeContainThoseInSubNode(
			TCGNode in_oSuperNode, TCGNode in_oSubNode)
	{
		// iterate over parameters of first node
		for(TCGParameter oFirstParameter : in_oSuperNode.getParameters())
		{
			TCGParameter oSecondParameter = null;
			// iterate over parameters of second node
			for(TCGParameter oParameter : in_oSubNode.getParameters())
			{
				if(oParameter.getReference().equals(oFirstParameter.getReference()))
				{
					oSecondParameter = oParameter;
					break;
				}
			}
			if(oSecondParameter == null)
				return false;
			else
			{
				if(!outerEquivalenceClassContainsInnerClass(oFirstParameter, oSecondParameter, 
						Configuration.isCompletenessForGeneratedPartitions() == true))
					return false;
			}
		}
		return true;
	}
	
	public static boolean outerEquivalenceClassContainsInnerClass(
			TCGParameter in_oOuterParameter,
			TCGParameter in_oInnerParameter,
			boolean in_bBoundariesMatchExactly)
	{
		ArrayList<TCGPrimitiveParameter> colOuterPars = 
			TCGParameterHelperClass.collectContainedPrimitiveParameters(in_oOuterParameter);
		ArrayList<TCGPrimitiveParameter> colInnerPars = 
			TCGParameterHelperClass.collectContainedPrimitiveParameters(in_oInnerParameter);
		for(TCGPrimitiveParameter oOuterPar : colOuterPars)
		{
			for(TCGPrimitiveParameter oInnerPar : colInnerPars)
			{
				if(oInnerPar.getReference().equals(oOuterPar.getReference()))
				{
					if(!outerEquivalenceClassContainsInnerClass(oOuterPar.getEquivalenceClass(),
							oInnerPar.getEquivalenceClass(), in_bBoundariesMatchExactly))
					{
						return false;
					}
				}
			}
		}
		return true;
	}
	
	public static boolean outerEquivalenceClassContainsInnerClass(
			TCGEquivalenceClass in_oOuterEqClass,
			TCGEquivalenceClass in_oInnerEqClass,
			boolean in_bBoundariesMatchExactly)
	{
		// exception: inner class is empty
		if(TestCaseGraphHelper.isEquivalenceClassEmpty(in_oInnerEqClass))
			return false;
		
		if(in_bBoundariesMatchExactly == true) // exact matching
		{
			if((in_oOuterEqClass.getMaxBorder().compareTo(in_oInnerEqClass.getMaxBorder()) == 0 &&
					(in_oOuterEqClass.getMaxIncluded() == in_oInnerEqClass.getMaxIncluded()) &&
					(in_oOuterEqClass.getMinBorder().compareTo(in_oInnerEqClass.getMinBorder()) == 0) &&
					(in_oOuterEqClass.getMinIncluded() == in_oInnerEqClass.getMinIncluded())))
				return true;
		}
		else
		{
			// TODO: eventuell die Grenzen und den minimalen Abstand mit in den Vergleich einbeziehen
			if((((in_oOuterEqClass.getMaxBorder().compareTo(in_oInnerEqClass.getMaxBorder()) == 0) && (in_oOuterEqClass.getMaxIncluded() || !in_oInnerEqClass.getMaxIncluded())) ||
					(in_oOuterEqClass.getMaxBorder().compareTo(in_oInnerEqClass.getMaxBorder()) > 0)) &&
					(((in_oOuterEqClass.getMinBorder().compareTo(in_oInnerEqClass.getMinBorder()) == 0) && (in_oOuterEqClass.getMinIncluded() || !in_oInnerEqClass.getMinIncluded())) ||
					(in_oOuterEqClass.getMinBorder().compareTo(in_oInnerEqClass.getMinBorder()) < 0)))
				return true;
			
		}
		return false;
	}
}
