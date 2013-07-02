package net.sf.parteg.base.testcasegraph.testgeneration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import net.sf.parteg.base.runtime.generated.RuntimeState;
import net.sf.parteg.base.testcasegraph.config.Configuration;
import net.sf.parteg.base.testcasegraph.config.ConfigurationTestPathSearchStrategy;
import net.sf.parteg.base.testcasegraph.generated.GeneratedFactory;
import net.sf.parteg.base.testcasegraph.generated.TCGConjunction;
import net.sf.parteg.base.testcasegraph.generated.TCGDisjunctiveNormalForm;
import net.sf.parteg.base.testcasegraph.generated.TCGElement;
import net.sf.parteg.base.testcasegraph.generated.TCGEvent;
import net.sf.parteg.base.testcasegraph.generated.TCGNode;
import net.sf.parteg.base.testcasegraph.generated.TCGOCLAtom;
import net.sf.parteg.base.testcasegraph.generated.TCGOCLExpression;
import net.sf.parteg.base.testcasegraph.generated.TCGOCLOperation;
import net.sf.parteg.base.testcasegraph.generated.TCGParameter;
import net.sf.parteg.base.testcasegraph.generated.TCGRealNode;
import net.sf.parteg.base.testcasegraph.generated.TCGTransition;
import net.sf.parteg.base.testcasegraph.helperclasses.TCGConjunctionHelperClass;
import net.sf.parteg.base.testcasegraph.helperclasses.TCGDisjunctiveNormalFormHelperClass;
import net.sf.parteg.base.testcasegraph.helperclasses.TCGNodeHelperClass;
import net.sf.parteg.base.testcasegraph.helperclasses.TCGOCLExpressionHelperClass;
import net.sf.parteg.base.testcasegraph.helperclasses.TCGParameterHelperClass;
import net.sf.parteg.base.testcasegraph.helperclasses.TCGTransitionHelperClass;
import net.sf.parteg.base.testcasegraph.helperclasses.VariableReferencer;
import net.sf.parteg.base.testcasegraph.ocl.TestCaseGraphHelper;
import net.sf.parteg.base.testcasegraph.ocl.parser.OCLTreeExpressionIterator;
import net.sf.parteg.base.testcasegraph.ocl.parser.OCLTreeTCGOCLAtomCollectorVisitor;
import net.sf.parteg.base.testcasegraph.systemstate.CurrentStateNodeSelector;
import net.sf.parteg.base.testcasegraph.systemstate.StateConfiguration;
import net.sf.parteg.base.testcasegraph.testgoals.TestGoalBase;
import net.sf.parteg.base.testcasegraph.testgoals.TestGoalGuardConditions;
import net.sf.parteg.base.testcasegraph.testgoals.TestGoalTransitionSequence;
import net.sf.parteg.base.testcasegraph.testsuite.EventParameterInstance;
import net.sf.parteg.base.testcasegraph.testsuite.TestCase;
import net.sf.parteg.base.testcasegraph.testsuite.TransitionInstance;
import net.sf.parteg.base.testcasegraph.valueselection.TestCaseValueDomainBorderSelector;
import net.sf.parteg.base.testcasegraph.valueselection.TestCaseValueSelector;
import net.sf.parteg.base.testcasegraph.valuetyperanges.IndefinableValueTypeRange;
import net.sf.parteg.base.testcasegraph.valuetyperanges.OCLExpressionValueTypeRangeFactory;
import net.sf.parteg.base.testcasegraph.valuetyperanges.ValueTypeRange;
import net.sf.parteg.core.structures.ObjectComparator;
import net.sf.parteg.core.structures.Pair;
import net.sf.parteg.core.testcase.TestCaseValidValue;

import org.eclipse.emf.ecore.EObject;

public class TestCaseGeneratorRunner {

	// all information about the current search process
	private TestCaseGeneratorRunnerState m_oTestCaseRunnerState;
	// reference to the just created test case
	private TestCase m_oCreatedTestCase;
	
	private TestCaseGraphHelper m_oTCGHelper;
	
	
	public TestCaseGeneratorRunner(TestCaseGraphHelper in_oTCGHelper)
	{
		init();
		m_oTCGHelper = in_oTCGHelper;
	}
	
	
	private void init()	{
		m_oTestCaseRunnerState = new TestCaseGeneratorRunnerState();
		m_oCreatedTestCase = null;		
	}
	
	
	public RuntimeState getRuntimeState()
	{
		return m_oTestCaseRunnerState.getRuntimeState();
	}
	
	
	public void searchBackwardsFromNodeWithEventConditionConjunction(
			TCGNode in_oNode,
			TCGEvent in_oEventToBeTriggered,
			TCGDisjunctiveNormalForm in_oDNF,
			boolean in_bCreateConditionBasedTestGoal)
	{
		
		if(in_oDNF == null || in_oDNF.getConjunctions().isEmpty()) {
			searchBackwardsFromNodeWithEventConditionExpression(
					in_oNode, in_oEventToBeTriggered, null, 
					in_bCreateConditionBasedTestGoal);			
		}
		else {
			for(TCGConjunction oConjunction : in_oDNF.getConjunctions()) {
				// check the validity of the selected conjunction
//				if(isValidExpressionConjunction(oConjunction.getExpressions(), 
//						new HashMap<TCGOCLAtom, TestCaseValidValue>())) {
					searchBackwardsFromNodeWithEventConditionExpression(
							in_oNode, in_oEventToBeTriggered, oConjunction,
							in_bCreateConditionBasedTestGoal);
					if(getCreatedTestCase() != null)
						return;
//				}
			}
		}
	}

	/*
	 * check all possible value assignments for included expressions
	 */
	private boolean isValidExpressionConjunction(
			List<TCGOCLExpression> in_oConjunctionExpressions,
			Map<TCGOCLAtom, TestCaseValidValue> in_colTestValues) {
		
		boolean bRetValue = true;
		EXPR: for(TCGOCLExpression oExpression : in_oConjunctionExpressions) {
			OCLTreeTCGOCLAtomCollectorVisitor oAtomCollector =
				new OCLTreeTCGOCLAtomCollectorVisitor();
			OCLTreeExpressionIterator.run(oExpression, oAtomCollector);
			for(TCGOCLAtom oExpAtom : oAtomCollector.getExpressions()) {
				// identified atoms
				List<TCGOCLAtom> colExpAtoms = new ArrayList<TCGOCLAtom>();
				colExpAtoms.add(oExpAtom);
				// remaining expressions to evaluate
				List<TCGOCLExpression> colTmpExpressions = new ArrayList<TCGOCLExpression>();
				colTmpExpressions.addAll(in_oConjunctionExpressions);
				colTmpExpressions.remove(oExpression);
				
				ValueTypeRange oTmpVTR = 
					TCGOCLExpressionHelperClass.getValueTypeRangeForEventParameterInstance(
							colExpAtoms, colTmpExpressions, 
							new HashMap<TCGOCLAtom, ValueTypeRange>(),
							in_colTestValues,
							new ArrayList<TCGOCLExpression>());
				if(oTmpVTR instanceof IndefinableValueTypeRange) {
					bRetValue = false;
					break EXPR; // do not look further
				}
				
				// use the current test case values to check all other expressions
				TestCaseValueDomainBorderSelector oTmpSelector = 
					new TestCaseValueDomainBorderSelector(true, true);
				boolean bValidValueFound = false; // local search for valid values
				for(TestCaseValidValue oValue : oTmpSelector.selectValues(oTmpVTR)) {
					// save old value
					TestCaseValidValue oOldValue = in_colTestValues.get(oExpAtom); 
					in_colTestValues.put(oExpAtom, oValue);
					if(isValidExpressionConjunction(colTmpExpressions, in_colTestValues)) {
						bValidValueFound = true;
					}
					if(oOldValue == null)
						in_colTestValues.remove(oExpAtom);
					else
						in_colTestValues.put(oExpAtom, oOldValue);
				}
				if(!bValidValueFound) {
					bRetValue = false;
					break EXPR;					
				}
			}
		}
		// am Ende enthält in_colTestValues ein gültiges Wertetupel
		return bRetValue;
	}
	
	private void searchBackwardsFromNodeWithEventConditionExpression(
			TCGNode in_oNode,
			TCGEvent in_oEventToBeTriggered,
			TCGConjunction in_oConjunction,
			boolean in_bCreateConditionBasedTestGoal)
	{
		/* add postfix for the reaction of the system to the triggered event
		 * under the given conditions */
		
		/* idea: find several initial runner states
		   start evaluation from the last state
		   search its way forward along a predefined sequence of transitions
		   insert the original test goal
		   continue normal search process - also start with state history for backtracking */
		
		// define possible postfixes (only transitions) for the system behaviour
		List<TestCaseGeneratorRunnerState> colInitialRunnerStates = 
			addTargetTransitionAndStateForNodeAndEvent(
				in_oNode, in_oEventToBeTriggered, in_oConjunction);
		
		// try each of the given postfixes
		for(TestCaseGeneratorRunnerState oRunnerState : colInitialRunnerStates) {
			m_oTestCaseRunnerState = oRunnerState.copy();
			// determine last state
			TCGNode oStartNode = in_oNode;
			// a transition sequence was found?
			if(!m_oTestCaseRunnerState.getTestGoalsToSatisfy().isEmpty()) {
				TestGoalBase oTestGoal = m_oTestCaseRunnerState.getTestGoalsToSatisfy().get(0);
				if(oTestGoal instanceof TestGoalTransitionSequence) {
					TestGoalTransitionSequence oTestGoalTransitionSequence =
						(TestGoalTransitionSequence)oTestGoal;
					TCGNode oSequenceEndNode = oTestGoalTransitionSequence.getEndNode();
					if(oSequenceEndNode != null) {
						oStartNode = oSequenceEndNode;
					}
				}
			}
			m_oTestCaseRunnerState.getRuntimeState().setActiveNode(oStartNode);
			
			// create separate guard condition-based test goal
			if(in_bCreateConditionBasedTestGoal) {
				// create temporary modification of the original test goal
				TCGDisjunctiveNormalForm oModifiedDNF = 
					GeneratedFactory.eINSTANCE.createTCGDisjunctiveNormalForm();
				if(in_oConjunction != null)
					oModifiedDNF.getConjunctions().add(in_oConjunction);
				TestGoalGuardConditions oModifiedTestGoal =
					new TestGoalGuardConditions(in_oNode, in_oEventToBeTriggered,
							oModifiedDNF);
				m_oTestCaseRunnerState.getTestGoalsToSatisfy().add(oModifiedTestGoal);
			}
			
			// search backwards
			searchBackwardForEachPossibleSourceNode(oStartNode, in_oEventToBeTriggered);
			
			if(m_oCreatedTestCase != null) {
				return;
			}
		}
	}		
	

	private List<TestCaseGeneratorRunnerState> addTargetTransitionAndStateForNodeAndEvent(
			TCGNode in_oNode,
			TCGEvent in_oEvent,
			TCGConjunction in_oConjunction)
	{
		List<TestCaseGeneratorRunnerState> colRunnerStates =
			new ArrayList<TestCaseGeneratorRunnerState>();
		
		List<TCGTransition> colTransitions = TCGTransitionHelperClass.findResultingTransitions(
				in_oNode, in_oEvent, in_oConjunction);
		// create the missing part of the path until a new event is required
		
		// initial state - try this one if you find no other transitions
		TestCaseGeneratorRunnerState oRunnerState = new TestCaseGeneratorRunnerState();
//		colRunnerStates.add(oRunnerState);

		TCGNode oTargetNode = in_oNode;
		// only one transition is triggered -> prevent ambiguous test goals
		// the same holds if event and condition are null -> no transition could be found!
		if((colTransitions.size() == 1) || (in_oEvent == null && in_oConjunction == null)) {

			if(colTransitions.size() == 1) {
				TCGTransition oTransition = colTransitions.get(0);
				
				// add the current transition
				TestGoalTransitionSequence oTestGoal = new TestGoalTransitionSequence();
				oTestGoal.getTransitionSequence().add(
						new Pair<TCGNode, TCGTransition>(in_oNode, oTransition));
				oRunnerState.getTestGoalsToSatisfy().add(oTestGoal);
				colRunnerStates.add(oRunnerState);
	
				// search for further transitions
				if(oTransition != null) 
					oTargetNode = oTransition.getTargetNode();
			}
		
			colRunnerStates.addAll(
				addTargetTransitionAndStateForNodeAndEventHelper(
						oTargetNode, oRunnerState));
			Collections.sort(colRunnerStates, new Comparator<TestCaseGeneratorRunnerState>() {
				@Override
				public int compare(TestCaseGeneratorRunnerState o1,
						TestCaseGeneratorRunnerState o2) {
					TestGoalTransitionSequence colTransitions1 =
						(TestGoalTransitionSequence)o1.getTestGoalsToSatisfy().get(0);
					TestGoalTransitionSequence colTransitions2 =
						(TestGoalTransitionSequence)o2.getTestGoalsToSatisfy().get(0);
					
					Integer o1Length = colTransitions1.getTransitionSequence().size(); 
					Integer o2Length = colTransitions2.getTransitionSequence().size();
					return o2Length.compareTo(o1Length);
				}
			});
		}

		// just in case there are no possible extensions
		if(colTransitions.size() == 0) {
			if(colRunnerStates.isEmpty()) {
				colRunnerStates.add(oRunnerState);
			}
		}
		
		return colRunnerStates;
	}
	
	private List<TestCaseGeneratorRunnerState> addTargetTransitionAndStateForNodeAndEventHelper(
			TCGNode in_oTargetNode, 
			TestCaseGeneratorRunnerState in_oRunnerState) {
		
		List<TestCaseGeneratorRunnerState> colRetValues = 
			new ArrayList<TestCaseGeneratorRunnerState>();
		
		// create runner state for each outgoing default-triggered transition and all
		// their default-triggered subsequent transitions ...
		for(TCGTransition oTransition : TCGNodeHelperClass.getAllTransitionsWithoutTrigger(in_oTargetNode)) {
//			TransitionInstance oTransitionInstance = new TransitionInstance(oTransition);
			TestCaseGeneratorRunnerState oNewRunnerState = 
				new TestCaseGeneratorRunnerState();
			TestGoalTransitionSequence oTestGoal =
				new TestGoalTransitionSequence();
			// extend the new test goal with the elements from previously created test goals
			if(!in_oRunnerState.getTestGoalsToSatisfy().isEmpty()) {
				TestGoalTransitionSequence oOtherTestGoal =
					(TestGoalTransitionSequence)in_oRunnerState.getTestGoalsToSatisfy().get(0);
				oTestGoal.getTransitionSequence().addAll(oOtherTestGoal.getTransitionSequence());
			}
			oTestGoal.getTransitionSequence().add(
					new Pair<TCGNode, TCGTransition>(in_oTargetNode, oTransition));
			oNewRunnerState.getTestGoalsToSatisfy().add(oTestGoal);
//			oNewRunnerState.getCurrentTransitionPath().add(oTransitionInstance);
			
			if(!oTransition.getSourceNode().equals(oTransition.getTargetNode())) {
				colRetValues.addAll(
						addTargetTransitionAndStateForNodeAndEventHelper(
								oTransition.getTargetNode(), oNewRunnerState));
			}
			colRetValues.add(oNewRunnerState);
		}
		
		return colRetValues;
	}


//	private void addPossibleConditionsForSucceedingTransitions(
//			TCGNode in_oNode,
//			TCGEvent in_oEvent,
//			TCGConjunction in_oConjunction)
//	{
//		TCGTransition oTransition = TCGTransitionHelperClass.findResultingTransition(
//				in_oNode, in_oEvent, in_oConjunction);
//		// create the missing part of the path until a new event is required
//		TransitionInstance oTransitionInstance = null;
//		if(oTransition == null) {
//			// is there any non-contradicting conjunction??? 
//			List<TCGConjunction> colNonContradictingConjunctions =
//				TCGTransitionHelperClass.findNonContradictingConjunctions(
//					in_oNode, in_oEvent, in_oConjunction);
//			// not? then all are contradicting -> it must lead to the source node
//			if(colNonContradictingConjunctions.isEmpty()) {
//				oTransitionInstance = new TransitionInstance(in_oNode);
//				oTransitionInstance.setCalledEvent(in_oEvent);
//			}
//		}
//		else if(oTransition.isCanBeProcessed()) {
//			oTransitionInstance = new TransitionInstance(oTransition);
//		}
//		
//		if(oTransitionInstance != null) {
//			m_colCurrentTransitionPath.add(oTransitionInstance);
//			if(in_oConjunction != null)
//			{
//				oTransitionInstance.getUsedPreConditions().addAll(
//						in_oConjunction.getExpressions());
//			}
//			while(oTransition != null && !TCGNodeHelperClass.
//					getAllTransitionsWithoutTrigger(oTransition.getTargetNode()).isEmpty()) {
//				TCGNode oNewTargetNode = oTransition.getTargetNode();
//				// deal with special cases of node hierarchy
//				List<TCGNode> colTargetNodes = TCGTransitionHelperClass.getTargetNodes(oTransition);
//				if(colTargetNodes.size() == 1) {
//					oNewTargetNode = colTargetNodes.get(0);
//				}
//				// TODO parallele Subzustandsmaschinen beachten! - hier mehrere Unterknoten als Initialkonfiguration behandeln!
//				oTransition = TCGTransitionHelperClass.findResultingTransition(
//						oNewTargetNode, null, in_oConjunction);
//				if(oTransition != null) {
//					if(oTransition.isCanBeProcessed()) {
//						// add transition instance to path
//						oTransitionInstance = new TransitionInstance(oTransition);
//						m_colCurrentTransitionPath.add(0, oTransitionInstance);
//						
//						// add precondition
//						if(oTransition.getPrecondition() != null) {
//							for(TCGConjunction oPreConjunction : oTransition.getPrecondition().getConjunctions())	{
//								checken!
//								Eventuell die gefundenen Pfad rückwärts laufen und alle
//								guard und postconditions rückwärts auswerten!
//								includePreconditionInSearch(								
//										oPreConjunction.getExpressions());
//							}
//						}
//						
//						// add postcondition
//						if(oTransition.getPostcondition() != null) {
//							for(TCGConjunction oPostConjunction : oTransition.getPostcondition().getConjunctions())	{
//								oTransitionInstance.getUsedPostConditions().addAll(
//										oPostConjunction.getExpressions());
//							}
//						}
//					}
//				}
//			}
//		}
//	}
	
	
	public void searchBackwardsFromNode(TCGNode in_oNode)
	{
		// update the actual runtime state configuration
		RuntimeStateChangeLog oRuntimeStateChange = new RuntimeStateChangeLog(
				in_oNode, this);
		oRuntimeStateChange.executeRuntimeStateChange();
		
		// test case is complete: create test case and return
		if(getRuntimeState().isInitialState()) {
			if(currentTransitionPathIsATestCase()) {
				createTestCase();
				return;
			}
		}

		// check if the current search process is influenced by a given 
		// test goal (e.g. transition sequence) 
		boolean bNormalSearchAllowed = true;
		if(!m_oTestCaseRunnerState.getTestGoalsToSatisfy().isEmpty()) {
			TestGoalBase oTestGoalToSatisfy = m_oTestCaseRunnerState.getTestGoalsToSatisfy().get(0);
			if(oTestGoalToSatisfy instanceof TestGoalTransitionSequence) {
				TestGoalTransitionSequence oTestGoalToSatisfySpec =
					(TestGoalTransitionSequence)oTestGoalToSatisfy;
				Pair<TCGNode, TCGTransition> oPredefinedNodeTransitionPair =
					oTestGoalToSatisfySpec.getEndNodeTransitionPair();
				if(oPredefinedNodeTransitionPair != null) {
					// check if predefined transition is an incoming transition of the current node
					if(oPredefinedNodeTransitionPair.getSecond().getTargetNode().equals(in_oNode)) {
						// remove the last transition
						oTestGoalToSatisfySpec.getTransitionSequence().remove(
								oTestGoalToSatisfySpec.getTransitionSequence().size() - 1);
						
						searchBackwardsFromTransition(oPredefinedNodeTransitionPair);
						if(getCreatedTestCase() != null) // search was successful: test case created
							return;

						oTestGoalToSatisfySpec.getTransitionSequence().add(oPredefinedNodeTransitionPair);
					} 
					bNormalSearchAllowed = false;
				}
			}
		}

		
		// is it reasonable to continue the search (e.g. because of loops)?
		if(bNormalSearchAllowed && isReasonableToContinueSearch()) {

			// select a state of a transition that has to be evaluated further
			CurrentStateNodeSelector oSelector = new CurrentStateNodeSelector();
			List<TCGNode> oCurrentNodeList = new ArrayList<TCGNode>();
			
			// if last called event is default event then this transition is called immediately after the one to be searched for
			// exception: the current node is an initial node -> then search from other nodes
			// exception: the current node is a connection point -> choose from the connection point (references)
	
			// real node + last called is default -> same node
			// real node + last called is not default -> choose
			// initial node -> choose
			
			if((!m_oTestCaseRunnerState.isMostRecentCalledEventDefaultEvent() &&
					in_oNode instanceof TCGRealNode) || 
					(TCGNodeHelperClass.isTopmostInitialNode(in_oNode))) {
				oSelector.selectNodeToBeProcessed(
					m_oTestCaseRunnerState.getRuntimeState(), 
					m_oTestCaseRunnerState.getConditionsToBeSatisfied(), 
					m_oTCGHelper, oCurrentNodeList);
			}
			else {
				oCurrentNodeList.add(in_oNode);
			}
			
			// prioritize nodes - first work with the nodes far from initial node
			oCurrentNodeList = TCGNodeHelperClass.prioritizeNodeList(oCurrentNodeList, true);
			// think about it - if nothing can be found for the first node, then it is a dead end ...
			// optimum switch in config
			if(Configuration.getOptimisticSearch()) {
				// remove all nodes but the first
				while(oCurrentNodeList.size() > 1)
					oCurrentNodeList.remove(1);
			}
			for(TCGNode oCurrentNode : oCurrentNodeList) {

				// create pairs of transitions and their possible source nodes and prioritize
				// them using the minDistance of the source nodes
				List<Pair<TCGNode, TCGTransition>> colSourceNodeTransitionPairs =
					new ArrayList<Pair<TCGNode, TCGTransition>>();

				// collect pairs of transitions and their possible source nodes
				List<TCGTransition> colTransitions = 
					TCGNodeHelperClass.getIncomingTransitions(oCurrentNode);
				for(TCGTransition oTransition : colTransitions) {
					List<TCGNode> colNodes = TCGTransitionHelperClass.getPossibleSourceNodes(
							oTransition);
					for(TCGNode oPossibleSourceNode : colNodes) {
						colSourceNodeTransitionPairs.add(
								new Pair<TCGNode, TCGTransition>(oPossibleSourceNode, oTransition));
					}						
				}

				// prioritize transitions - see Configuration
				colSourceNodeTransitionPairs = 
					prioritizeSourceNodeTransitionPairList(colSourceNodeTransitionPairs);

				for(Pair<TCGNode, TCGTransition> oPair : colSourceNodeTransitionPairs) {
					// search ...
					searchBackwardsFromTransition(oPair);

					if(getCreatedTestCase() != null) // search was successful: test case created
						return;
				}
			}
		}
		oRuntimeStateChange.undoRuntimeStateChange();
	}
	

	private List<Pair<TCGNode, TCGTransition>> prioritizeSourceNodeTransitionPairList(
			List<Pair<TCGNode, TCGTransition>> in_colSourceNodeTransitionPair) 
	{
		List<Pair<TCGNode, TCGTransition>> colRetTransitions = 
			new ArrayList<Pair<TCGNode, TCGTransition>>();
		colRetTransitions.addAll(in_colSourceNodeTransitionPair);

		// sort corresponding to the initialDistance of the transition's source node 
		Collections.sort(colRetTransitions, 
			new Comparator<Pair<TCGNode, TCGTransition>>() {

				@Override
				public int compare(Pair<TCGNode, TCGTransition> o1, Pair<TCGNode, TCGTransition> o2) {
					if(ConfigurationTestPathSearchStrategy.getTestPathSearchStrategy().equals(
							ConfigurationTestPathSearchStrategy.TestPathSearchStrategy.TRANSITIONS_TO_NEAR_NODES_FIRST)) {
						if(o1.getFirst().getMinDistanceFromStart() < o2.getFirst().getMinDistanceFromStart()) {
							return -1;
						}
						else if(o1.getFirst().getMinDistanceFromStart() > o2.getFirst().getMinDistanceFromStart()) {
							return 1;
						}
					}
					else if(ConfigurationTestPathSearchStrategy.getTestPathSearchStrategy().equals(
							ConfigurationTestPathSearchStrategy.TestPathSearchStrategy.TRANSITIONS_TO_FAR_NODES_FIRST)) {
						if(o1.getFirst().getMaxDistanceFromStart() < o2.getFirst().getMaxDistanceFromStart()) {
							return 1;
						}
						else if(o1.getFirst().getMaxDistanceFromStart() > o2.getFirst().getMaxDistanceFromStart()) {
							return -1;
						}
					}
					return 0;
				}
			}
		);

		
		// prioritize transitions that satisfy some guard conditions
		if(!m_oTestCaseRunnerState.getConditionsToBeSatisfied().isEmpty()) {
			List<Pair<TCGNode, TCGTransition>> oTmpSortList = 
				new ArrayList<Pair<TCGNode, TCGTransition>>();
			VariableReferencer oReferencer = m_oTCGHelper.getVariableReferencer();
			List<EObject> colReferencedVariables = new ArrayList<EObject>();
			
			for(TCGOCLExpression oExpression : m_oTestCaseRunnerState.getConditionsToBeSatisfied()) {
				CurrentStateNodeSelector.getPassiveDependentElements(oExpression, colReferencedVariables);
				for(EObject oObject : colReferencedVariables)
				{
					List<TCGElement> colElements = oReferencer.getValuesForKey(oObject);
					if(colElements == null) {
//						System.err.println("no value for variableReferencer ???"); // no transition that influences this parameter
					}
					else {
						for(TCGElement oElement : colElements) {
							// if element is transition
							if(oElement instanceof TCGTransition) {
								// add all pairs whose second element is this transition
								for(Pair<TCGNode, TCGTransition> oPair : colRetTransitions) {
									if(oPair.getSecond().equals(oElement)) {
										oTmpSortList.add(oPair);
									}
								}
							}
						}
					}
				}
			}
			// sort identified elements to the front - but keep their order!
			// first: inverse-sort elements in oTmpSortList
			for(Pair<TCGNode, TCGTransition> oPair : colRetTransitions) {
				if(oTmpSortList.contains(oPair)) {
					oTmpSortList.remove(oPair);
					oTmpSortList.add(0, oPair);
				}
			}
			// second: move all elements of oTmpSortList to the front -> inverse sort order again
			for(Pair<TCGNode, TCGTransition> oPair : oTmpSortList) {
				colRetTransitions.remove(oPair);
				colRetTransitions.add(0, oPair);
			}
		}
		
		return colRetTransitions;
	}
	
	
	private void searchBackwardsFromTransition(
			Pair<TCGNode, TCGTransition> in_oPair)
	{
		// do nothing if transition cannot be processed - perhaps due to overriding super transitions
		if(!in_oPair.getSecond().isCanBeProcessed())
			return;

//		System.out.println("process transition from >" + in_oPair.getSecond().getSourceNode().getName() 
//				+ "< to >" + in_oPair.getSecond().getTargetNode().getName() + "<");
		
		ExpressionChangeLog oExpressionChangeLog = new ExpressionChangeLog();
		TCGDisjunctiveNormalForm oPostDNF = in_oPair.getSecond().getPostcondition();
		TCGConjunction oPostConjunction = GeneratedFactory.eINSTANCE.createTCGConjunction();
		
		if(!transformPreconditionAccordingToPostcondition(
				oExpressionChangeLog, oPostDNF, oPostConjunction)) {
			// conflict occurred ... return
			return;
		}

//		TODO AAA hier werden postconditions eingebunden
		List<LateEvaluationGroup> colOriginalLateEvaluationGroups =
			adaptLateEvaluationGroupsForPostcondition(oPostDNF);

		// select a conjunction of the guard condition and continue the search backwards
		searchBackwardForSourceNodeAndTransition(in_oPair, oPostConjunction);
		
		// undo all transformation changes triggered by postconditions
		if(getCreatedTestCase() == null) {
			oExpressionChangeLog.undoChanges(
					m_oTestCaseRunnerState.getConditionsToBeSatisfied());
			
			// remove all existing late evaluation groups and replace them with the saved ones
			m_oTestCaseRunnerState.getLateEvaluationGroups().clear();
			m_oTestCaseRunnerState.getLateEvaluationGroups().addAll(
					colOriginalLateEvaluationGroups);
		}
	}

	
	private List<LateEvaluationGroup> adaptLateEvaluationGroupsForPostcondition(
			TCGDisjunctiveNormalForm in_oPostDNF) {

		// save old list of late evaluation groups
		List<LateEvaluationGroup> colSaveLateEvaluationGroups =
			new ArrayList<LateEvaluationGroup>();
		for(LateEvaluationGroup oGroup : m_oTestCaseRunnerState.getLateEvaluationGroups()) {
			colSaveLateEvaluationGroups.add(oGroup.copy());
		}
		
		if(in_oPostDNF != null && !in_oPostDNF.getConjunctions().isEmpty()) {
			LateEvaluationGroup oNewGroup = new LateEvaluationGroup();
			// TODO: consider non-determinism in postconditions: several groups of groups for alternatives ???
			// TODO hack: only consider the first conjunction -> change!
			TCGConjunction oConjunction = in_oPostDNF.getConjunctions().get(0); 
			for(TCGOCLExpression oExpression : oConjunction.getExpressions()) {
				List<TCGOCLAtom> colChangeableParameters = 
					TCGOCLExpressionHelperClass.getPassiveDependentVariablesAndInputParameters(oExpression);
				// postconditions can never be added as conditions to be satisfied!
//				if(colChangeableParameters.size() == 1) {
//					// just one changeable parameter 
//					m_colConditionsToBeSatisfied.add(oExpression);
//				}
				// several changeable parameters
				// -> collect group for current expression list
				// no restriction for number of dependent variables - this is a postcondition!
				dealWithSeveralParametersInLateEvaluationGroup(
						oExpression, colChangeableParameters, 
						oNewGroup);
			}
	
			if(!oNewGroup.getLateSatisfiedConditions().isEmpty()) {
				boolean bRemoveUsedElementsToFindPostconditionFor = true;
				boolean bCreateNewGroupIfNoMatchingGroupFound = false;
				combineNewGroupWithExistingGroups(oNewGroup, 
						bRemoveUsedElementsToFindPostconditionFor,
						bCreateNewGroupIfNoMatchingGroupFound);
			}
		}
		
		return colSaveLateEvaluationGroups;
	}


	private boolean transformPreconditionAccordingToPostcondition(
			ExpressionChangeLog io_oExpressionChangeLog,
			TCGDisjunctiveNormalForm in_oPostDNF,
			TCGConjunction in_oPostConjunction) {
		
		// check postconditions of this transition: compare with all 
		// preconditions from m_colConditionsToBeSatisfied
		if(in_oPostDNF != null)
		{
			boolean bConflict = 
				transformPreConditionsWithPostCondition(
						in_oPostDNF, io_oExpressionChangeLog, in_oPostConjunction);
			if(bConflict == true) {
				return false;
			}
			io_oExpressionChangeLog.executeChanges(
					m_oTestCaseRunnerState.getConditionsToBeSatisfied());
			if(m_oTestCaseRunnerState.getConditionsToBeSatisfied().contains(null)) {
				System.err.println("null condition occured!");
			}
		}
		return true;
	}
	
	/*
	 * Select a conjunction of the precondition of the pair's second element.
	 * Continue the search backwards ...
	 */
	private void searchBackwardsFromEventAndPostcondition(
			Pair<TCGNode, TCGTransition> in_oPair,
			TCGEvent in_oEvent,
			TCGConjunction in_oPreconditionConjunction,
			TCGConjunction in_oUsedPostcondition) {
		
		if(in_oPreconditionConjunction != null) {
			// add static preconditions and those with mutually dependent elements
			List<LateEvaluationGroup> colSaveLateEvaluationGroups =
				includePreconditionInSearch(in_oPreconditionConjunction.getExpressions());
			
			// if the guard of the transition is true
			boolean bConstantPartsOfTheGuardAreAllTrue = 
				!(TCGConjunctionHelperClass.conjunctionContainsAnInfeasibleExpression(
					in_oPreconditionConjunction));

			// no contradictions found
			if(bConstantPartsOfTheGuardAreAllTrue &&
					TCGConjunctionHelperClass.conditionsInConjunctionAreContradicting(
					m_oTestCaseRunnerState.getConditionsToBeSatisfied()).isEmpty()) {
				
				TransitionInstance oTransitionInstance = null;
				if(in_oPair.getSecond() == null) { // no state change
					oTransitionInstance = new TransitionInstance(in_oPair.getFirst());
					oTransitionInstance.setCalledEvent(in_oEvent);
				} else {
					oTransitionInstance = new TransitionInstance(in_oPair.getSecond());
				}
					
				m_oTestCaseRunnerState.getCurrentTransitionPath().add(oTransitionInstance);			
				oTransitionInstance.getUsedPreConditions().addAll(
						in_oPreconditionConjunction.getExpressions());
				oTransitionInstance.getUsedPostConditions().addAll(
						in_oUsedPostcondition.getExpressions());
			
				// handle event
				//searchBackwardsFromEvent(in_oPair.getFirst(), in_oEvent);
				searchBackwardForEachPossibleSourceNode(in_oPair.getFirst(), in_oEvent);
				
				if(getCreatedTestCase() != null)
					return;

				m_oTestCaseRunnerState.getCurrentTransitionPath().remove(oTransitionInstance);
			}
			// remove static expressions and those with mutually dependent elements again
			excludePreconditionFromSearch(in_oPreconditionConjunction.getExpressions(),
					colSaveLateEvaluationGroups);
			
		} else {
			TransitionInstance oTransitionInstance = null;
			// transition or node as anchor for transition instance?
			if(in_oPair.getSecond() != null)
				oTransitionInstance = new TransitionInstance(in_oPair.getSecond());
			else
				oTransitionInstance = new TransitionInstance(in_oPair.getFirst());
			
			m_oTestCaseRunnerState.getCurrentTransitionPath().add(oTransitionInstance);			
			oTransitionInstance.getUsedPostConditions().addAll(
					in_oUsedPostcondition.getExpressions());
			//searchBackwardsFromEvent(in_oPair.getFirst(), in_oEvent);
			searchBackwardForEachPossibleSourceNode(in_oPair.getFirst(), in_oEvent);
			if(m_oCreatedTestCase != null)
				return;
			m_oTestCaseRunnerState.getCurrentTransitionPath().remove(oTransitionInstance);			
		}		
	}


	/*
	 * iterates over all possible source nodes of a transition and an event
	 */
	private void searchBackwardForSourceNodeAndTransition(
			Pair<TCGNode, TCGTransition> in_oPair,
//			TCGConjunction in_oPrecondition,
			TCGConjunction in_oPostCondition)
	{
		boolean bFirstTestGoalIsEmptyTransitionSequence = false;
		TestGoalGuardConditions oTestGuardGoal = null;
		TestGoalTransitionSequence oTestGoalToSatisfySpec = null;
		if(!m_oTestCaseRunnerState.getTestGoalsToSatisfy().isEmpty()) {
			int nIndexForGuardCondition = 0;
			TestGoalBase oTestGoalToSatisfy = m_oTestCaseRunnerState.getTestGoalsToSatisfy().get(0);
			if(oTestGoalToSatisfy instanceof TestGoalTransitionSequence) {
				nIndexForGuardCondition = 1;
				oTestGoalToSatisfySpec =
					(TestGoalTransitionSequence)oTestGoalToSatisfy;
				if(oTestGoalToSatisfySpec.getTransitionSequence().isEmpty()) {
					bFirstTestGoalIsEmptyTransitionSequence = true;
				}
			}
			if(m_oTestCaseRunnerState.getTestGoalsToSatisfy().size() > nIndexForGuardCondition) {
				TestGoalBase oSecondGoal = 
					m_oTestCaseRunnerState.getTestGoalsToSatisfy().get(nIndexForGuardCondition);
				if(oSecondGoal instanceof TestGoalGuardConditions) {
					oTestGuardGoal = (TestGoalGuardConditions)oSecondGoal;
				}
			}
		}

		// 0th case: the only remaining test goal is an empty transition sequence
		if(bFirstTestGoalIsEmptyTransitionSequence && oTestGuardGoal == null) {
			int nSize = m_oTestCaseRunnerState.getTestGoalsToSatisfy().size();
			m_oTestCaseRunnerState.getTestGoalsToSatisfy().remove(
					nSize - 1);
			
			searchBackwardForSourceNodeAndTransitionStandard(
					in_oPair, in_oPostCondition);

			// add used goals again
			m_oTestCaseRunnerState.getTestGoalsToSatisfy().add(
					oTestGuardGoal);
		}
		else {
			// first case:
			// the first goal to satisfy is an empty transition sequence
			// the second goal is a guard condition that has to be satisfied
			// -> satisfy the guard while traversing the first transition
			// -> of the following transition sequence
			if(bFirstTestGoalIsEmptyTransitionSequence && oTestGuardGoal != null) {
//				TCGConjunction oGuardConjunction = null;
//				if(!oTestGuardGoal.getDNFToBeSatisfied().getConjunctions().isEmpty()) {
//					oGuardConjunction = 
//						oTestGuardGoal.getDNFToBeSatisfied().getConjunctions().get(0);
//				}
//				if(TCGDisjunctiveNormalFormHelperClass.firstConjunctionIsSatisfiedByDNF(
//						oGuardConjunction, in_oPair.getSecond().getPrecondition(), false)) {
	
					// remove both guards
					int nSize = m_oTestCaseRunnerState.getTestGoalsToSatisfy().size();
					m_oTestCaseRunnerState.getTestGoalsToSatisfy().remove(
							nSize - 1);
					m_oTestCaseRunnerState.getTestGoalsToSatisfy().remove(
							nSize - 2);
	
//					searchBackwardsFromEventAndPostcondition(
//							in_oPair, oTestGuardGoal.getEventToBeCalled(), 
//							oGuardConjunction, in_oPostCondition);
					searchBackwardForSourceNodeAndTransitionGuardSelection(
							in_oPair, oTestGuardGoal.getEventToBeCalled(), 
							oTestGuardGoal.getDNFToBeSatisfied(), in_oPostCondition);
	
					// add used goals again
					m_oTestCaseRunnerState.getTestGoalsToSatisfy().add(
							oTestGoalToSatisfySpec);
					m_oTestCaseRunnerState.getTestGoalsToSatisfy().add(
							oTestGuardGoal);
//				}
			}
			else {
			// second case:
			// the first goal is a guard condition that has to be violated and
			// does not result in a state change
			// -> then continue traversing transitions
				if(oTestGoalToSatisfySpec == null && oTestGuardGoal != null) {
					// the correct target state already has been found while
					// initializing the TestCaseGeneratorRunner
					
//					TCGConjunction oGuardConjunction = null;
//					if(!oTestGuardGoal.getDNFToBeSatisfied().getConjunctions().isEmpty()) {
//						oGuardConjunction = 
//							oTestGuardGoal.getDNFToBeSatisfied().getConjunctions().get(0);
//					}
//					// transition source node is equal to test goal element
//					//if(in_oPair.getSecond().getSourceNode().equals(oTestGuardGoal.getElement()) ||
					
					// the predefined guard goal to satisfy on the way cannot be satisfied by a transition guard
//					if(!TCGDisjunctiveNormalFormHelperClass.firstConjunctionIsSatisfiedByDNF(
//						oGuardConjunction, in_oPair.getSecond().getPrecondition(), false)) {
//						// we have to pay attention to the case that the violated guard
//						// does not result in a state change
						in_oPair.setFirst(in_oPair.getSecond().getTargetNode());
						in_oPair.setSecond(null);
//					}
					int nSize = m_oTestCaseRunnerState.getTestGoalsToSatisfy().size();
					m_oTestCaseRunnerState.getTestGoalsToSatisfy().remove(
							nSize - 1);
					
//					searchBackwardsFromEventAndPostcondition(
//							in_oPair, oTestGuardGoal.getEventToBeCalled(), 
//							oGuardConjunction, in_oPostCondition);
					searchBackwardForSourceNodeAndTransitionGuardSelection(
							in_oPair, oTestGuardGoal.getEventToBeCalled(), 
							oTestGuardGoal.getDNFToBeSatisfied(), in_oPostCondition);
	
					// add used goals again
					m_oTestCaseRunnerState.getTestGoalsToSatisfy().add(
							oTestGuardGoal);
				}
				else {
					searchBackwardForSourceNodeAndTransitionStandard(
							in_oPair, in_oPostCondition);
				}
			}
		}
		
//		if(m_oTestCaseRunnerState.getTestGoalsToSatisfy().size() > 1) {
//
//			TestGoalBase oTestGoalToSatisfy = 
//				m_oTestCaseRunnerState.getTestGoalsToSatisfy().get(0);
//			if(oTestGoalToSatisfy instanceof TestGoalGuardConditions) {
//				TestGoalGuardConditions oTestGoalGuard = 
//					(TestGoalGuardConditions)oTestGoalToSatisfy;
//				// remove test goal from list
//				m_oTestCaseRunnerState.getTestGoalsToSatisfy().remove(
//						m_oTestCaseRunnerState.getTestGoalsToSatisfy().size() - 1);
//				
//				TCGConjunction oGuardConjunction = null;
//				if(!oTestGoalGuard.getDNFToBeSatisfied().getConjunctions().isEmpty()) {
//					oGuardConjunction = oTestGoalGuard.getDNFToBeSatisfied().getConjunctions().get(0);
//				}
//				
//				searchBackwardsFromEventAndPostcondition(
//						in_oPair, 
//						oTestGoalGuard.getEventToBeCalled(), 
//						oGuardConjunction,
//						in_oPostCondition);
//				
//				// add test goal again
//				m_oTestCaseRunnerState.getTestGoalsToSatisfy().add(
//						oTestGoalGuard);
//			} else if(oTestGoalToSatisfy instanceof TestGoalElements) {
//				TestGoalElements oTestGoalElement =
//					(TestGoalElements)oTestGoalToSatisfy;
//				boolean bTestGoalSatisfied = false;
//				// test goal references node: pair has to include this node
//				if(oTestGoalElement.getElement() instanceof TCGNode) {
//					if(oTestGoalElement.getElement().equals(in_oPair.getFirst())) {
//						bTestGoalSatisfied = true;
//					}
//				}
//				// test goal references transition: pair has to include this transition
//				if(oTestGoalElement.getElement() instanceof TCGTransition) {
//					if(oTestGoalElement.getElement().equals(in_oPair.getSecond())) {
//						bTestGoalSatisfied = true;
//					}
//				}
//				if(bTestGoalSatisfied) {
//					m_oTestCaseRunnerState.getTestGoalsToSatisfy().remove(
//							m_oTestCaseRunnerState.getTestGoalsToSatisfy().size() - 1);
//					
//					searchBackwardForSourceNodeAndTransitionStandard(
//							in_oPair, in_oPostCondition);
//					
//					// add test goal again
//					m_oTestCaseRunnerState.getTestGoalsToSatisfy().add(
//							oTestGoalElement);
//				}
//			} else if(oTestGoalToSatisfy instanceof TestGoalTransitionSequence) {
//				searchBackwardForSourceNodeAndTransitionStandard(
//						in_oPair, in_oPostCondition);				
//			}
//		} else {
//			searchBackwardForSourceNodeAndTransitionStandard(
//					in_oPair, in_oPostCondition);
//		}
	}
	
	private void searchBackwardForSourceNodeAndTransitionStandard(
			Pair<TCGNode, TCGTransition> in_oPair,
			TCGConjunction in_oPostCondition)
	{

		// standard search algorithm
		List<TCGEvent> colEvents = in_oPair.getSecond().getEvents();
		if(colEvents.isEmpty()) {
			searchBackwardForSourceNodeAndTransitionGuardSelection(
					in_oPair, null, in_oPair.getSecond().getPrecondition(), 
					in_oPostCondition);
			if(getCreatedTestCase() != null) // search was successful: test case created
				return;
		}
		else {
			for(TCGEvent oEvent : colEvents) {
				searchBackwardForSourceNodeAndTransitionGuardSelection(
						in_oPair, oEvent, in_oPair.getSecond().getPrecondition(),
						in_oPostCondition);
				if(getCreatedTestCase() != null) // search was successful: test case created
					return;
			}
		}
	}
	
		
	private void searchBackwardForSourceNodeAndTransitionGuardSelection(
			Pair<TCGNode, TCGTransition> in_oPair,
			TCGEvent in_oEvent,
			TCGDisjunctiveNormalForm in_oPreCondition,
			TCGConjunction in_oPostCondition)
	{
		// *** include precondition in search algorithm
//		TCGDisjunctiveNormalForm oPreDNF = in_oPair.getSecond().getPrecondition();
		TCGDisjunctiveNormalForm oPreDNF = in_oPreCondition;
		
		// insert restricted guard condition here
		if(Configuration.isInnerTransitionHasPriorityOverOuterTransition()) {
			if(in_oPair.getSecond() != null &&
					TCGNodeHelperClass.firstNodeIsSubStateOfSecondNode(
					in_oPair.getFirst(), in_oPair.getSecond().getSourceNode())) {
//				Hier entstehen widersprüchliche Bedingungen? Mit Beispiel-debug 167 testen!
				Map<TCGEvent, TCGDisjunctiveNormalForm> colAllowedEventToDNF =
					TCGTransitionHelperClass.returnAvailableEventsAndGuardsForStateAndOutgoingTransition(
						in_oPair.getFirst(), in_oPair.getSecond());
				// TODO : ### ObjectComparator durchziehen: nach "contains" suchen
				Object oRefObject = ObjectComparator.getEqualObject(colAllowedEventToDNF.keySet(), in_oEvent);
				if(oRefObject != null) {
					TCGEvent oRefEvent = (TCGEvent)oRefObject;
					boolean bBothDNFsAreNonEmpty = !(oPreDNF == null || oPreDNF.getConjunctions().isEmpty()) 
						&& !(colAllowedEventToDNF.get(oRefEvent) == null || colAllowedEventToDNF.get(oRefEvent).getConjunctions().isEmpty());
					oPreDNF = TCGDisjunctiveNormalFormHelperClass.connectTwoDNFWithAnd(
							oPreDNF, colAllowedEventToDNF.get(oRefEvent));
					TCGDisjunctiveNormalFormHelperClass.removeContradictingConjunctions(oPreDNF);
					// check if the removal of contradicting conjunctions completely cleared the conjunction set
					if(bBothDNFsAreNonEmpty == oPreDNF.getConjunctions().isEmpty())
						return;
//					oPreDNF = colAllowedEventToDNF.get(in_oEvent);
				}
				else
					return;
			}
		}

		// continue search for all conjunctions of the precondition (guard)
		if((oPreDNF != null) && (!oPreDNF.getConjunctions().isEmpty())) {
			for(TCGConjunction oPreConjunction : oPreDNF.getConjunctions()) {	
				searchBackwardsFromEventAndPostcondition(
						in_oPair, in_oEvent, oPreConjunction, in_oPostCondition);
			}
		}
		else {
			searchBackwardsFromEventAndPostcondition(
					in_oPair, in_oEvent, null, in_oPostCondition);			
		}
	}
		
	
	/*
	 * iterates over all possible source nodes of a transition and an event
	 */
	private void searchBackwardForEachPossibleSourceNode(
			TCGNode in_oNode, TCGEvent in_oEvent)
	{
		List<TCGEvent> colEvents = new ArrayList<TCGEvent>();
		if(in_oEvent != null)
			colEvents.add(in_oEvent);
		
		// select next node to process
		List<TCGNode> colNodes = null;
		if((!m_oTestCaseRunnerState.isMostRecentCalledEventDefaultEvent() &&
				in_oNode instanceof TCGRealNode) || 
				(TCGNodeHelperClass.isTopmostInitialNode(in_oNode))) {
			colNodes = TCGNodeHelperClass.getPossibleSubNodes(in_oNode, colEvents);
		}
		else {
			colNodes = new ArrayList<TCGNode>();
			colNodes.add(in_oNode);
		}
		
		NODE: for(TCGNode oPossibleSourceNode : colNodes) {

			if(Configuration.isInnerTransitionHasPriorityOverOuterTransition()) {
				// prevent the selection of subnodes with outgoing transitions that override the target transition
				List<TCGTransition> colSuperiorTransitions =
					TCGTransitionHelperClass.getOutgoingTransitionsOfStateExcludingUpToSuperState(
							oPossibleSourceNode, in_oNode);
				for(TCGTransition oTransition : colSuperiorTransitions) {
					if(ObjectComparator.contains(oTransition.getEvents(), in_oEvent))
						continue NODE;
				}
			}
			
			searchBackwardsFromEvent(oPossibleSourceNode, in_oEvent);
			if(getCreatedTestCase() != null) // search was successful: test case created
				return;
		}		
	}

	
	/*
	 * starts backtracking from a transition probably holding an event 
	 */
	private void searchBackwardsFromEvent(TCGNode in_oNode, TCGEvent in_oEvent) 
	{
		// handle expressions for events of transitions
		ExpressionChangeLog oExpressionChangeLog = new ExpressionChangeLog(); 
		ErrorClass eConversionSuccessful = convertEventsToEventInstances(
				in_oEvent, oExpressionChangeLog);
		
		if(eConversionSuccessful == ErrorClass.CONTRADICTION)
			return;
		
		// if successful: remove all expressions that are used for the new parameter instances
		if(eConversionSuccessful == ErrorClass.OK)
			oExpressionChangeLog.executeChanges(
					m_oTestCaseRunnerState.getConditionsToBeSatisfied());
			
		// search further backwards for the initial node
		searchBackwardsFromNode(in_oNode);
		
		// TODO: testen, wie Performanz aussieht, wenn "return" gelöscht wird
		// und die Referenzen aufgeräumt werden ...
		if(getCreatedTestCase() != null) // search was successful: test case created
			return;
		
		if(eConversionSuccessful == ErrorClass.OK)
			oExpressionChangeLog.undoChanges(
					m_oTestCaseRunnerState.getConditionsToBeSatisfied());
	}

	/*
	 * transform existing preconditions (from guards or operation preconditions)
	 * with postconditions to new conditions
	 */
	private boolean transformPreConditionsWithPostCondition(
			TCGDisjunctiveNormalForm in_oPostDNF,
			ExpressionChangeLog io_oExpressionChangeLog,
			TCGConjunction io_oPostConjunction)
	{
		for(TCGOCLExpression oPreCondition : m_oTestCaseRunnerState.getConditionsToBeSatisfied())
		{
			ArrayList<TCGOCLExpression> colTmpExpressions = new ArrayList<TCGOCLExpression>();
			TCGDisjunctiveNormalFormHelperClass.PrePostComparisonResult eResult = 
				TCGDisjunctiveNormalFormHelperClass.connectPreconditionAndASetOfPostconditions(
					oPreCondition, in_oPostDNF, colTmpExpressions, io_oPostConjunction);
			if(eResult == TCGDisjunctiveNormalFormHelperClass.PrePostComparisonResult.FOUND_CONFLICT)
				return true;
			
			// some preconditions could have been transformed via postconditions
			if(eResult == TCGDisjunctiveNormalFormHelperClass.PrePostComparisonResult.RESOLVED_CONDITION)
			{
				io_oExpressionChangeLog.getRemovedExpressions().add(oPreCondition);
				io_oExpressionChangeLog.getAddedExpressions().addAll(colTmpExpressions);
			}
		}
		return false;
	}
	
		
	/*
	 * returns true if the current transition sequence is a good test case
	 */
	private boolean currentTransitionPathIsATestCase() {
		return (TCGOCLExpressionHelperClass.getContainedExpressionsWithPassiveVariables(
				m_oTestCaseRunnerState.getConditionsToBeSatisfied()).isEmpty());
	}

	/*
	 * if parameter is not null:
	 * creates an event instance for the event,
	 * defines value ranges for event parameters based on the current expressions
	 */
	private ErrorClass convertEventsToEventInstances(
			TCGEvent in_oEvent,
			ExpressionChangeLog in_oExpressionChangeLog) 
	{
		try {
			if((in_oEvent == null) || 
					(in_oEvent.isDefaultEvent() == true) ||
					m_oTestCaseRunnerState.getCurrentTransitionPath().isEmpty())
				return ErrorClass.OK;
	
			// current transition instance
			TransitionInstance oTransitionInstance = 
				m_oTestCaseRunnerState.getCurrentTransitionPath().get(
						m_oTestCaseRunnerState.getCurrentTransitionPath().size() - 1);
	
			/*
			 * create new event parameter instances for all referenced parameters:
			 */
			for(TCGOCLExpression oOCLExp : m_oTestCaseRunnerState.getConditionsToBeSatisfied())
			{
				// TODO AAA hier die ganze Liste von Eingabeparametern abarbeiten!
	//			Object oObject = TCGOCLExpressionHelperClass.getInputParametersFromExpression(oOCLExp);
	//			if(oObject != null)
	//			{
//				if(TCGOCLExpressionHelperClass.getPassiveDependentVariablesAndInputParameters(oOCLExp).size() == 1) {
					for(Object oObject : TCGOCLExpressionHelperClass.getInputParametersFromExpression(oOCLExp)) {
						for(TCGParameter oTCGParameter : in_oEvent.getParameters())
						{
							TCGParameter oReferencedTCGParameter = 
								TCGParameterHelperClass.findParameterElementMatchingToReference(
										oTCGParameter, oTransitionInstance, oObject);
							// referenced parameter
							if(oReferencedTCGParameter != null)
							{
								ValueTypeRange oValueTypeRange = 
									OCLExpressionValueTypeRangeFactory.getValueTypeRangeForRightSideOfExpression(
										oReferencedTCGParameter, oOCLExp);
								if(oValueTypeRange == null)
									return ErrorClass.NOSOLUTION;
								
								// return contradiction if integer should be equal to a non-integer value
								if(TCGOCLExpressionHelperClass.isLastIntegerComputationWasIncorrect()) {
									if (oOCLExp instanceof TCGOCLOperation) {
										TCGOCLOperation oCallExp = (TCGOCLOperation) oOCLExp;
										if(oCallExp.getOperationName().equals("="))
											return ErrorClass.CONTRADICTION;
//										if(oCallExp.getOperationName().equals(">=")) {
//											oCallExp.setOperationName(">");
//										}
									}
								}
								
								boolean bAdaptationSuccessful = oTransitionInstance.adaptEventParameterValueRanges(
										oReferencedTCGParameter, oValueTypeRange);
								if(bAdaptationSuccessful) {
									// remember the elements that should not be considered from now on
									in_oExpressionChangeLog.getRemovedExpressions().add(oOCLExp);
								}
								else
									//return ErrorClass.NOSOLUTION;
									return ErrorClass.CONTRADICTION;
							}
						}
					}
				}
//			}
			
			if(Configuration.isSearchForMutualDependentInputParameters()) {
				/*
				 * create event parameter instances for later evaluated expressions
				 * - with a reference to the corresponding expression copy
				 */
				for(LateEvaluationGroup oGroup : m_oTestCaseRunnerState.getLateEvaluationGroups()) {
					
					List<TCGOCLAtom> colRemovedElements = new ArrayList<TCGOCLAtom>();
					for(TCGOCLAtom oAtom : oGroup.getElementsToFindPostconditionFor()) {
						for(TCGParameter oTCGParameter : in_oEvent.getParameters())
						{
							TCGParameter oReferencedTCGParameter = 
								TCGParameterHelperClass.findParameterElementMatchingToReference(
										oTCGParameter, oTransitionInstance, oAtom);
							// referenced parameter
							if(oReferencedTCGParameter != null)
							{
								// try to find matching eventparameterinstances and reuse them
								// TODO: check: klappt das immer?
								EventParameterInstance oEPInstance =
									oTransitionInstance.getInstanceForTCGParameter(oReferencedTCGParameter);
								
								// if not found: create a new one
								if(oEPInstance == null) {
									oEPInstance = new EventParameterInstance(oReferencedTCGParameter, oTransitionInstance); 
									oTransitionInstance.getParameterInstances().add(oEPInstance);
								}
								
								// remove the atom from the list of searched elements 
								colRemovedElements.add(oAtom);
								// establish a connection between the atom and the event parameter instance
								//oGroup.getAtomsToParameter().put(oAtom, oEPInstance);
								
								//wird bisher nie benutzt ...
								List<TCGOCLAtom> colReferencedAtoms = 
									oGroup.getParameterToAtoms().get(oEPInstance);
								if(colReferencedAtoms == null) {
									colReferencedAtoms = new ArrayList<TCGOCLAtom>();
									oGroup.getParameterToAtoms().put(oEPInstance, colReferencedAtoms);
								}
								colReferencedAtoms.add(oAtom);
							}
						}
					}
					oGroup.getElementsToFindPostconditionFor().removeAll(colRemovedElements);
				}
			}
	
			return ErrorClass.OK;
		}
		catch(Exception e) {
			return ErrorClass.NOSOLUTION;
		}
	}
	
	private void createTestCase()
	{
		if(!checkTestCaseIsValid()) {
			return;
		}
		
		m_oCreatedTestCase = new TestCase();
		
		m_oCreatedTestCase.getTransitionInstances().addAll(
				m_oTestCaseRunnerState.getCurrentTransitionPath());
		// current transition sequence is in wrong order -> reverse
		Collections.reverse(m_oCreatedTestCase.getTransitionInstances());
		// set unique naming to transition instances
		for(int i = 0; i < m_oCreatedTestCase.getTransitionInstances().size(); ++i)
		{
			TransitionInstance oTransitionInstance = 
				m_oCreatedTestCase.getTransitionInstances().get(i);
			oTransitionInstance.setName(String.valueOf(i));
		}
		m_oCreatedTestCase.getLateEvaluationGroups().addAll(
				m_oTestCaseRunnerState.getLateEvaluationGroups());
		m_oCreatedTestCase.connectTransitionInstances();
		m_oCreatedTestCase.createMissingParameterInstances();
	}
	
	// check if there can be dynamic values created from this test case
	private boolean checkTestCaseIsValid() {
		for(LateEvaluationGroup oGroup : m_oTestCaseRunnerState.getLateEvaluationGroups()) {
			List<EventParameterInstance> colEPIs = new ArrayList<EventParameterInstance>();
			colEPIs.addAll(oGroup.getParameterToAtoms().keySet());
			
			// ***
			// create combinations of testcasevalues for dynamic variables
//			TestCaseValueSelector.createDynamicValuesForLateParameterInstanceValues(oGroup, in_colEPIs, in_colCurrentValueAssignment, in_oValueSelector)
			
			List<Map<EventParameterInstance, TestCaseValidValue>> colEPI2Values = 
				TestCaseValueSelector.createDynamicValuesForLateParameterInstanceValues(
						oGroup, colEPIs,
						new LinkedHashMap<EventParameterInstance, TestCaseValidValue>(),
						new TestCaseValueDomainBorderSelector(true, true));
			
			if(colEPI2Values.isEmpty()) 
				return false;
		}
		return true;
	}


	public TestCase getCreatedTestCase()
	{
		return m_oCreatedTestCase;
	}
	
	private boolean isReasonableToContinueSearch()
	{
		boolean bRuntimeStateIsNoDeadend = true;
		for(TCGNode oNode : m_oTestCaseRunnerState.getRuntimeState().getAllActiveNodes()) {
			if(TCGNodeHelperClass.nodeCannotBeReached(oNode))
				bRuntimeStateIsNoDeadend = false;
		}
		// check the current runtime state and the conditions to be satisfied
		return bRuntimeStateIsNoDeadend && !historyHasRepetitions(); 
	}
	
	private boolean historyHasRepetitions()
	{
		// the direct successor may be the same state - for self transitions
		
		if(m_oTestCaseRunnerState.getStateConfigurationHistory().size() < 3)
			return false;
		// only compare to the newest added state
		StateConfiguration oNewStateConfiguration =
			m_oTestCaseRunnerState.getStateConfigurationHistory().get(
					m_oTestCaseRunnerState.getStateConfigurationHistory().size() - 1);

		for(int n = 1; n < m_oTestCaseRunnerState.getStateConfigurationHistory().size() - 1; ++n) {
			StateConfiguration oCurrentStateConfiguration =
				m_oTestCaseRunnerState.getStateConfigurationHistory().get(n);
			// runtime states equal?
			if(oCurrentStateConfiguration.isSubConfigurationOf(oNewStateConfiguration)) {
				return true;
			}
		}
		// found no matching state in history
		return false;
	}
	
	public List<StateConfiguration> getStateConfigurationHistory() {
		return m_oTestCaseRunnerState.getStateConfigurationHistory();
	}
	
	public List<TCGOCLExpression> getConditionsToBeSatisfied() {
		return m_oTestCaseRunnerState.getConditionsToBeSatisfied();
	}

//	TODO mehrere verschiedene expression handler definieren, die mit verschiedenen 
//	Arten von Ausdrücken umgehen können:
//		- keine/eine/mehrere dependent variablen
//		- komplexere OCL-Ausdrücke (collections, etc.)

	private List<LateEvaluationGroup> includePreconditionInSearch(
			List<TCGOCLExpression> in_colExpressions) {

		// save old list of late evaluation groups
		List<LateEvaluationGroup> colSaveLateEvaluationGroups =
			new ArrayList<LateEvaluationGroup>();
		for(LateEvaluationGroup oGroup : m_oTestCaseRunnerState.getLateEvaluationGroups()) {
			colSaveLateEvaluationGroups.add(oGroup.copy());
		}

		// define new late evaluation group
		LateEvaluationGroup oNewGroup = new LateEvaluationGroup();
		
		// collect the expressions with more than one dependent element and input parameter
		for(TCGOCLExpression oExpression : in_colExpressions) {
			// TODO : A input
			List<TCGOCLAtom> colChangeableParameters = 
				TCGOCLExpressionHelperClass.getPassiveDependentVariablesAndInputParameters(oExpression);
			if(colChangeableParameters.size() == 1) {
				// just one changeable parameter
				// test if the same expression already exists
				boolean bFound = false;
				for(TCGOCLExpression oPreCondition : m_oTestCaseRunnerState.getConditionsToBeSatisfied()) {
					if(oExpression.equals(oPreCondition) ||
							TCGOCLExpressionHelperClass.expressionsAreEqual(
							oExpression, oPreCondition)) {
						bFound = true;
					}
				}
				if(bFound == false)
					m_oTestCaseRunnerState.getConditionsToBeSatisfied().add(oExpression);
			}
			else if(colChangeableParameters.size() > 1) {
				// several changeable parameters
				// -> collect group for current expression list
				dealWithSeveralParametersInLateEvaluationGroup(
						oExpression, colChangeableParameters, 
						oNewGroup);
			}
		}
		
		// combine new group with existing ones ...
		if(!oNewGroup.getLateSatisfiedConditions().isEmpty()) {
			boolean bRemoveUsedElementsToFindPostconditionFor = false;
			boolean bCreateNewGroupIfNoMatchingGroupFound = true;
			combineNewGroupWithExistingGroups(oNewGroup, 
					bRemoveUsedElementsToFindPostconditionFor,
					bCreateNewGroupIfNoMatchingGroupFound);
		}
		
		return colSaveLateEvaluationGroups;
	}
	
	
	private void combineNewGroupWithExistingGroups(
			LateEvaluationGroup in_oNewGroup,
			boolean in_bRemoveUsedElementsToFindPostconditionFor,
			boolean in_bCreateNewGroupIfNoMatchingGroupFound) {
		
		// Combine new group with already existing groups:
		// If a new group references elements that are still open
		// for other groups, then all are combined into one.
		// in both directions: several existing can be combined with several new
		Map<LateEvaluationGroup, List<LateEvaluationGroup>> colExistingToNewGroups =
			new LinkedHashMap<LateEvaluationGroup, List<LateEvaluationGroup>>();
		List<LateEvaluationGroup> colNewToExistingGroups =
			new ArrayList<LateEvaluationGroup>();
		for(LateEvaluationGroup oExistingGroup : m_oTestCaseRunnerState.getLateEvaluationGroups()) {
			colExistingToNewGroups.put(oExistingGroup, new ArrayList<LateEvaluationGroup>());
		}
		
		// build up maps between new and old groups
		for(LateEvaluationGroup oExistingGroup : m_oTestCaseRunnerState.getLateEvaluationGroups()) {
			// compare all expressions of new group with the open references of all existing groups
			List<TCGOCLAtom> colFoundAtoms = new ArrayList<TCGOCLAtom>();
			boolean bAddedCombination = false;
			for(TCGOCLExpression oNewExpression : in_oNewGroup.getLateSatisfiedConditions()) {
				// find all atoms in the new expression
				OCLTreeTCGOCLAtomCollectorVisitor oVisitor =
					new OCLTreeTCGOCLAtomCollectorVisitor();
				OCLTreeExpressionIterator.run(oNewExpression, oVisitor);
				// compare elements of groups 
				for(TCGOCLAtom oNewAtom : oVisitor.getExpressions()) {
					for(TCGOCLAtom oExistingAtom : oExistingGroup.getElementsToFindPostconditionFor()) {
						// comparison
						if(oNewAtom.getElement().equals(oExistingAtom.getElement())) {
							colFoundAtoms.add(oExistingAtom);
							if(bAddedCombination == false) {
								colExistingToNewGroups.get(oExistingGroup).add(in_oNewGroup);
								colNewToExistingGroups.add(oExistingGroup);
								bAddedCombination = true;
							}
						}
					}
				}
			}
			if(in_bRemoveUsedElementsToFindPostconditionFor) {
				oExistingGroup.getElementsToFindPostconditionFor().
					removeAll(colFoundAtoms);
			}
		}
		
		// remove existing groups from list that are used for combination
		List<LateEvaluationGroup> colGroupsForCombinations =
			new ArrayList<LateEvaluationGroup>();
		for(LateEvaluationGroup oExistingGroup : m_oTestCaseRunnerState.getLateEvaluationGroups()) {
			if(!colExistingToNewGroups.get(oExistingGroup).isEmpty()) {
				colGroupsForCombinations.add(oExistingGroup);
			}
		}
		m_oTestCaseRunnerState.getLateEvaluationGroups().removeAll(
				colGroupsForCombinations);
		
		// add new group to list if not used for combination
		if(colNewToExistingGroups.isEmpty()) {
			if(in_bCreateNewGroupIfNoMatchingGroupFound) {
				m_oTestCaseRunnerState.getLateEvaluationGroups().add(in_oNewGroup);
			}
		}
		else {
			// combine remaining groups and add one combined group
			LateEvaluationGroup oNewGroupCombination = new LateEvaluationGroup();
			oNewGroupCombination.addGroupValues(in_oNewGroup);
			for(LateEvaluationGroup oMatchedGroup : colGroupsForCombinations) {
				oNewGroupCombination.addGroupValues(oMatchedGroup);
			}
			m_oTestCaseRunnerState.getLateEvaluationGroups().add(oNewGroupCombination);
		}
	}
	
	
	private void dealWithSeveralParametersInLateEvaluationGroup(
		TCGOCLExpression in_oExpression, 
		List<TCGOCLAtom> in_colChangeableParameters,
		LateEvaluationGroup in_oNewLateEvaluationGroup) {
		
//		List<LateEvaluationGroup> colGroupsToChange = new ArrayList<LateEvaluationGroup>();
		
//		// find groups that contain open references?
//		for(LateEvaluationGroup oGroup : in_colNewLateEvaluationGroups) {
//			ATOM: for(TCGOCLAtom oActualAtom : in_colChangeableParameters) {
//				for(TCGOCLAtom oExistingAtom : oGroup.getElementsToFindPostconditionFor()) {
//					if(oActualAtom.getElement().equals(oExistingAtom.getElement())) {
//						colGroupsToChange.add(oGroup);
//						break ATOM;						
//					}
//				}
//			}
//		}
		
//		// more than one group available? -> unite them
//		if(colGroupsToChange.size() > 1) {
//			LateEvaluationGroup oGroup = colGroupsToChange.get(0);
//			for(int i = 1; i < colGroupsToChange.size(); ++i) {
//				LateEvaluationGroup oOtherGroup = colGroupsToChange.get(i);
//				oGroup.addGroupValues(oOtherGroup);
//				in_colNewLateEvaluationGroups.remove(oOtherGroup);
//			}
//			colGroupsToChange.clear();
//			colGroupsToChange.add(oGroup);
//		}
//		
//		// no group available? -> create a new one
//		if(colGroupsToChange.isEmpty()) {
//			LateEvaluationGroup oGroup = new LateEvaluationGroup(); 
//			colGroupsToChange.add(oGroup);
//			in_colNewLateEvaluationGroups.add(oGroup);
//		}
		
		// add elements to group
		// we have to work with a separate copy
		Pair<TCGOCLExpression, List<TCGOCLAtom>> oPairCopy = 
			TCGOCLExpressionHelperClass.copyExpression(
					in_oExpression, in_colChangeableParameters);
		// add all elements to find a postcondition for
		in_oNewLateEvaluationGroup.getElementsToFindPostconditionFor().addAll(
				oPairCopy.getSecond());
		// add also the expression
		in_oNewLateEvaluationGroup.getLateSatisfiedConditions().add(
				oPairCopy.getFirst());
//					TCGOCLExpressionHelperClass.copyExpression(in_oExpression));
	}


	private void excludePreconditionFromSearch(
			List<TCGOCLExpression> in_colExpressions,
			List<LateEvaluationGroup> in_colOriginalLateEvaluationGroups) {

		// remove additional static preconditions
		m_oTestCaseRunnerState.getConditionsToBeSatisfied().removeAll(
				in_colExpressions);
		
		// remove all existing late evaluation groups and replace them with the saved ones
		m_oTestCaseRunnerState.getLateEvaluationGroups().clear();
		m_oTestCaseRunnerState.getLateEvaluationGroups().addAll(
				in_colOriginalLateEvaluationGroups);
	}
	
	
}

