package net.sf.parteg.base.testcasegraph.helperclasses;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import net.sf.parteg.base.testcasegraph.generated.GeneratedFactory;
import net.sf.parteg.base.testcasegraph.generated.TCGConjunction;
import net.sf.parteg.base.testcasegraph.generated.TCGDisjunctiveNormalForm;
import net.sf.parteg.base.testcasegraph.generated.TCGEvent;
import net.sf.parteg.base.testcasegraph.generated.TCGIntermediateNode;
import net.sf.parteg.base.testcasegraph.generated.TCGNode;
import net.sf.parteg.base.testcasegraph.generated.TCGNodeType;
import net.sf.parteg.base.testcasegraph.generated.TCGOCLExpression;
import net.sf.parteg.base.testcasegraph.generated.TCGRealNode;
import net.sf.parteg.base.testcasegraph.generated.TCGTransition;
import net.sf.parteg.base.testcasegraph.generated.TestCaseGraph;
import net.sf.parteg.base.testcasegraph.generated.TestCaseRegion;
import net.sf.parteg.base.testcasegraph.ocl.TestCaseGraphHelper;
import net.sf.parteg.core.structures.ObjectComparator;
import net.sf.parteg.core.structures.Pair;

import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.Trigger;
import org.eclipse.uml2.uml.Vertex;

public class TCGTransitionHelperClass {

	public static List<TCGNode> getPossibleSourceNodes(
			TCGTransition in_oTransition)
	{
		List<TCGNode> colRetNodes = new ArrayList<TCGNode>();
		TCGNode oOriginallyReferencedNode = in_oTransition.getSourceNode();
		if(oOriginallyReferencedNode instanceof TCGIntermediateNode) {
			TCGIntermediateNode oIntNode = (TCGIntermediateNode)oOriginallyReferencedNode;
			colRetNodes.add(oOriginallyReferencedNode);
			// connection point: add connection point references
			if(!oIntNode.getReferencedConnectionPointReferences().isEmpty()) {
				colRetNodes.addAll(oIntNode.getReferencedConnectionPointReferences());
			}
			// connection point reference: add connection points
			else if(!oIntNode.getReferencedConnectionPoints().isEmpty()) {
				colRetNodes.addAll(oIntNode.getReferencedConnectionPoints());
			}
		}
		else
			colRetNodes = TCGNodeHelperClass.getPossibleSubNodes(
				oOriginallyReferencedNode, in_oTransition.getEvents());
		return colRetNodes;
	}
	
	public static List<TCGNode> getTargetNodes(
			TCGTransition in_oTransition)
	{
		List<TCGNode> colTargetNodes = new ArrayList<TCGNode>();
		TCGNode oTargetNode = in_oTransition.getTargetNode();
		if(oTargetNode instanceof TCGRealNode) {
			TCGRealNode oRealTargetNode = (TCGRealNode)oTargetNode;
			TestCaseGraph oTCG = oRealTargetNode.getSubGraph();
			if(oTCG == null) {
				oTCG = oRealTargetNode.getReferencedSubmachine();
			}
			if(oTCG != null) {
				for(TestCaseRegion oRegion : oTCG.getRegions()) {
					colTargetNodes.addAll(TCGRegionHelperClass.findInitialNodes(oRegion));
				}
			}
		}
		else if(oTargetNode instanceof TCGIntermediateNode) {
//			TCGIntermediateNode oIntNode = (TCGIntermediateNode)oTargetNode;
			// TODO check if ALL outgoing transitions must be taken ...
//			if(oIntNode.isEntryNode()) {
//				for(TCGTransition oTransition : oIntNode.getOutgoingTransitions()) {
//					colTargetNodes.add(oTransition.getTargetNode());
//				}
//			}
		}
		if(colTargetNodes.isEmpty())
			colTargetNodes.add(oTargetNode);

		return colTargetNodes;
	}
	
	/**
	 * searches for all transitions that are outgoing transitions of super states
	 * of the source state of the parameter in_oTransition
	 * @param in_oTransition
	 * @return
	 */
	public static List<Transition> getCompositeStateSuperTransitionsTriggeredByTheSameEvent(
			Transition in_oTransition) {
		if(in_oTransition.getSource() instanceof State)
			return getOutgoingTransitionsOfSuperNodesTriggeredByEvent(
				((State)in_oTransition.getSource()), in_oTransition.getTriggers());
		else
			return new ArrayList<Transition>();
	}

	public static List<Transition> getContainedStateTransitionsTriggeredByTheSameEvent(
			Transition in_oTransition) {
		if(in_oTransition.getSource() instanceof State)
			return getOutgoingTransitionsOfContainedNodesTriggeredByEvent(
				((State)in_oTransition.getSource()), in_oTransition.getTriggers());
		else
			return new ArrayList<Transition>();		
	}
	
	public static List<Transition> getSourceStateTransitionsTriggeredByTheSameEvent(
			Transition in_oTransition) {
		List<Transition> colRetValue = new ArrayList<Transition>();
		Vertex oSource = in_oTransition.getSource();
		for(Transition oOutgoingTransition : oSource.getOutgoings()) {
			if(!oOutgoingTransition.equals(in_oTransition)) {
				if(bothTransitionsHaveOverlappingTrigger(in_oTransition, oOutgoingTransition))
					if(!colRetValue.contains(oOutgoingTransition))
						colRetValue.add(oOutgoingTransition);
			}
		}
		return colRetValue;
	}



	
	private static boolean bothTransitionsHaveOverlappingTrigger(
			Transition in_oTransition1, Transition in_oTransition2)
	{
		if(in_oTransition1.getTriggers().isEmpty() && in_oTransition2.getTriggers().isEmpty())
			return true;
		else {
			for(Trigger oFirstTrigger : in_oTransition1.getTriggers()) {
				for(Trigger oSecondTrigger : in_oTransition2.getTriggers()) {
					if(oFirstTrigger.getEvent() == null) {
						if(oSecondTrigger.getEvent() == null)
							return true;
					}
					else if(oFirstTrigger.getEvent().equals(oSecondTrigger.getEvent()))
						return true;
				}
			}
		}
		return false;
	}
	
	private static List<Transition> getOutgoingTransitionsOfSuperNodesTriggeredByEvent(
			State in_oState, List<Trigger> in_colTriggers) 
	{
		List<Transition> colTransitions = new ArrayList<Transition>();
		State oTmpState = in_oState.getContainer().getState();
		while(oTmpState != null) {
			for(Transition oTransition : oTmpState.getOutgoings()) {
				for(Trigger oOriginalTrigger : in_colTriggers) {
					for(Trigger oTrigger : oTransition.getTriggers()) {
						if(oTrigger.getEvent().equals(oOriginalTrigger.getEvent())) {
							colTransitions.add(oTransition);
						}
					}
				}
			}
			oTmpState = oTmpState.getContainer().getState();
		}
		return colTransitions;
	}
	
	private static List<Transition> getOutgoingTransitionsOfContainedNodesTriggeredByEvent(
			State in_oState, List<Trigger> in_colTriggers) 
	{
		List<Transition> colTransitions = new ArrayList<Transition>();
		List<State> colTmpStates = new ArrayList<State>();
		colTmpStates.add(in_oState);
		while(!colTmpStates.isEmpty()) {
			State oTmpState = colTmpStates.get(0);
			colTmpStates.remove(oTmpState);
			
			if(oTmpState.isComposite()) {
				for(Region oRegion : oTmpState.getRegions())
					for(Vertex oVertex: oRegion.getSubvertices())
						if(oVertex instanceof State)
							colTmpStates.add((State)oVertex);
			}
			if(oTmpState.isSubmachineState()) {
				for(Region oRegion : oTmpState.getSubmachine().getRegions())
					for(Vertex oVertex: oRegion.getSubvertices())
						if(oVertex instanceof State)
							colTmpStates.add((State)oVertex);				
			}
			
			if(!oTmpState.equals(in_oState)) {
				for(Transition oTransition : oTmpState.getOutgoings()) {
					for(Trigger oOriginalTrigger : in_colTriggers) {
						for(Trigger oTrigger : oTransition.getTriggers()) {
							if(oTrigger.getEvent().equals(oOriginalTrigger.getEvent())) {
								colTransitions.add(oTransition);
							}
						}
					}
				}
			}
		}

		return colTransitions;
	}
	
	public static boolean transitionHasNoEventTrigger(TCGTransition in_oTransition)
	{
		if(in_oTransition.getEvents().isEmpty())
			return true;
		
		for(TCGEvent oEvent : in_oTransition.getEvents()) {
			if(!oEvent.isDefaultEvent())
				return false;
		}
		return true;
	}
	
	public static TCGTransition createNewTransitionsBetweenNodeAndTransitionTarget(
			TestCaseGraphHelper in_oTCGHelper,
			TestCaseRegion in_oRegion,
			TCGNode in_oSourceNode,
			TCGTransition in_oOutgoingTransition) throws Exception 
	{
		TCGNode oTargetNode = in_oOutgoingTransition.getTargetNode();
		
		TCGTransition oTCGTransition1 = 
			in_oTCGHelper.addTransition(in_oSourceNode, oTargetNode);
		oTCGTransition1.getEvents().addAll(in_oOutgoingTransition.getEvents());
		oTCGTransition1.setPrecondition(
				TCGDisjunctiveNormalFormHelperClass.copyDNFDeep(
						in_oOutgoingTransition.getPrecondition()));
		oTCGTransition1.setPostcondition(
				TCGDisjunctiveNormalFormHelperClass.copyDNFDeep(
						in_oOutgoingTransition.getPostcondition()));
		oTCGTransition1.setCanBeProcessed(in_oOutgoingTransition.isCanBeProcessed());
		return oTCGTransition1;
	}
	
	public static TCGIntermediateNode createNewTransitionsAndIntermediateNodeBetween(
			TestCaseGraphHelper in_oTCGHelper,
			TestCaseRegion in_oRegion,
			TCGTransition in_oIncomingTransition,
			TCGTransition in_oOutgoingTransition) throws Exception
	{
		TCGNode oSourceNode = in_oIncomingTransition.getSourceNode();
		TCGNode oTargetNode = in_oOutgoingTransition.getTargetNode();
		
		TCGIntermediateNode oNewNode =
			in_oTCGHelper.addIntermediateNode(in_oRegion, TCGNodeType.UNKNOWN);
		
		TCGTransition oTCGTransition1 = 
			in_oTCGHelper.addTransition(oSourceNode, oNewNode);
		oTCGTransition1.getEvents().addAll(in_oIncomingTransition.getEvents());
		oTCGTransition1.setPrecondition(
				TCGDisjunctiveNormalFormHelperClass.copyDNFDeep(
						in_oIncomingTransition.getPrecondition()));
		oTCGTransition1.setPostcondition(
				TCGDisjunctiveNormalFormHelperClass.copyDNFDeep(
						in_oIncomingTransition.getPostcondition()));
		oTCGTransition1.setCanBeProcessed(in_oIncomingTransition.isCanBeProcessed());

		TCGTransition oTCGTransition2 = 
			in_oTCGHelper.addTransition(oNewNode, oTargetNode);
		oTCGTransition2.getEvents().addAll(in_oOutgoingTransition.getEvents());
		oTCGTransition2.setPrecondition(
				TCGDisjunctiveNormalFormHelperClass.copyDNFDeep(
						in_oOutgoingTransition.getPrecondition()));
		oTCGTransition2.setPostcondition(
				TCGDisjunctiveNormalFormHelperClass.copyDNFDeep(
						in_oOutgoingTransition.getPostcondition()));
		oTCGTransition2.setCanBeProcessed(in_oOutgoingTransition.isCanBeProcessed());
		
		return oNewNode;
	}


	public static List<TCGTransition> findResultingTransitions(
			TCGNode in_oNode,
			TCGEvent in_oEvent,
			TCGConjunction in_oConjunction)
	{
		List<TCGTransition> colTransitions = new ArrayList<TCGTransition>();
		// find outgoing transition
		for(TCGNode oNode : TCGNodeHelperClass.getAllSuperStatesIncludingThis(in_oNode)) {
			// nodes are returned according to inner-outer-transition-priority
			// if outgoing transitions for one node is already added, then don't 
			// add transitions for inner/outer nodes 
			if(!colTransitions.isEmpty()) {
				break;
			}
			for(TCGTransition oTransition : oNode.getOutgoingTransitions()) {
				if(oTransition.getEvents().isEmpty()) {
					if(transitionCanBeTriggeredByEventAndConjunction(oTransition, in_oEvent, null, in_oConjunction) &&
							oTransition.isCanBeProcessed())
						colTransitions.add(oTransition);
				}
				else {
					for(TCGEvent oEvent : oTransition.getEvents()) {
						if(transitionCanBeTriggeredByEventAndConjunction(oTransition, in_oEvent, oEvent, in_oConjunction) &&
								oTransition.isCanBeProcessed())
							colTransitions.add(oTransition);
					}
				}
			}
		}
		return colTransitions;
	}
	
	
	public static boolean transitionCanBeTriggeredByEventAndConjunction(
			TCGTransition in_oTransition,
			TCGEvent in_oEvent,
			TCGEvent in_oCompareEvent,
			TCGConjunction in_oConjunction)
	{
		if(TCGEventHelperClass.eventsAreEqual(in_oEvent, in_oCompareEvent) ||
				(in_oEvent == null && in_oCompareEvent.isDefaultEvent()))
		{
			// transition has no guard - event trigger is sufficient
			if(in_oTransition.getPrecondition() == null ||
					in_oTransition.getPrecondition().getConjunctions().isEmpty()) {
				return true;
			}
			// transition has guard but conjunction is null ...
			if(in_oConjunction == null)
				return false;
			
			// one of the required condition is satisfied by the transition guard
			for(TCGConjunction oPreConjunction : in_oTransition.getPrecondition().getConjunctions()) {
				// TODO : A - kritische Änderung! Checken! Überlappung von Ausdrücken braucht aber noch mehr!

				// check if the guard of the transition COULD be satisfied by in_oConjunction
				// this means that is does not necessarily have to ...
				// so the goal is to return all POSSIBLY activated transitions
				
				// in detail:
				// 1) in_oConjunction and oPreConjunction must not be contradicting
				List<TCGOCLExpression> colExpressions = new ArrayList<TCGOCLExpression>();
				colExpressions.addAll(in_oConjunction.getExpressions());
				colExpressions.addAll(oPreConjunction.getExpressions());
				if(TCGConjunctionHelperClass.conditionsInConjunctionAreContradicting(colExpressions).isEmpty()) {
					return true;
				}
				
				
//				System.out.println("### pre ### " +
//						TCGConjunctionHelperClass.toString(oPreConjunction));
//				System.out.println("### in ### " +
//						TCGConjunctionHelperClass.toString(in_oConjunction));
				// test goal condition can be part of the guard condition
				// vice versa: transition guard can be a part of the test goal condition
//				if(TCGDisjunctiveNormalFormHelperClass.firstConjunctionIsSatisfiedBySecondConjunction(
//						oPreConjunction, in_oConjunction, false) ||
//						TCGDisjunctiveNormalFormHelperClass.firstConjunctionIsSatisfiedBySecondConjunction(
//								in_oConjunction, oPreConjunction, false)) {
					
//					statt der angegebenen Bedingungen muss eine Bedingung eingebaut werden, sodass
//					die Conjunctions auf Überlappungen und nicht auf vollständiges Erfüllen geprüft werden
//					(oder? -> check nochmal FreightElevator)
//					-> alternativ:!!!
//					  -> bei zweitem Check muss guard nur die in guard enthaltenen Elemente aus
//					     test goal erfüllen ...aus 
					
//					System.out.println("### pre ### " +
//							TCGConjunctionHelperClass.toString(oPreConjunction));
//					System.out.println("### in ### " +
//							TCGConjunctionHelperClass.toString(in_oConjunction));
//					return true;
//				}
			}
		}
		return false;
	}
	
	public static List<TCGConjunction> findNonContradictingTransitionGuards(
			TCGNode in_oNode,
			TCGEvent in_oEvent,
			TCGConjunction in_oConjunction)
	{
		List<TCGConjunction> colRetValues = 
			new ArrayList<TCGConjunction>();
		// find outgoing transition
		for(TCGNode oNode : TCGNodeHelperClass.getAllSuperStatesIncludingThis(in_oNode)) {
			for(TCGTransition oTransition : oNode.getOutgoingTransitions()) {
				
				boolean bFoundEvent = false;
				for(TCGEvent oEvent : oTransition.getEvents()) {
					if(oEvent.equals(in_oEvent)) {
						bFoundEvent = true;
						break;
					}
				}
				
				// events are matching
				if((in_oEvent == null && oTransition.getEvents().isEmpty()) ||
						bFoundEvent) {
					
					colRetValues.addAll(getNonContradictingTransitionGuards(oTransition, in_oConjunction));
				}
			}
		}
		return colRetValues;
	}

	public static List<TCGConjunction> getNonContradictingTransitionGuards(
			TCGTransition in_oTransition, TCGConjunction in_oConjunction) {
		List<TCGConjunction> colRetValues = new ArrayList<TCGConjunction>();
		if(in_oTransition.getPrecondition() != null) {
			for(TCGConjunction oConjunction : in_oTransition.getPrecondition().getConjunctions()) {
				List<TCGOCLExpression> colExpressions = new ArrayList<TCGOCLExpression>();
				if(in_oConjunction != null) {
					colExpressions.addAll(in_oConjunction.getExpressions());
				}
				colExpressions.addAll(oConjunction.getExpressions());
				if(TCGConjunctionHelperClass.
						conditionsInConjunctionAreContradicting(colExpressions).isEmpty()) {
					colRetValues.add(oConjunction);
				}
			}
		}
		return colRetValues;
	}
	
	/*
	 * This method returns a list of pairs of remaining events and conditions
	 * for an inferior transition. The transition is inferior if other activated
	 * transition have a higher priority than it.
	 * The following cases need to be included:
	 * Superior transitions with
	 * - no trigger and no guard -> return set is empty
	 * - no trigger and guard -> all pairs have to include the negated guard
	 * - trigger and no guard -> do not allow this specific guard
	 * - trigger and guard -> do not allow this guard for this event
	 */
	public static Map<TCGEvent, TCGDisjunctiveNormalForm> 
		getRemainingActivationConditionForInferiorTransition(
			List<TCGTransition> in_colSuperiorTransitions,
			TCGTransition in_oInferiorTransition) {
		
		Map<TCGEvent, TCGDisjunctiveNormalForm> colRetValues = 
			new LinkedHashMap<TCGEvent, TCGDisjunctiveNormalForm>();
		List<TCGDisjunctiveNormalForm> colStaticNegatedGuards =
			new ArrayList<TCGDisjunctiveNormalForm>();
		
		boolean bSuperiorDefaultTransitionFound = false;
		for(TCGTransition oSuperiorTransition : in_colSuperiorTransitions) {
			if(transitionHasNoEventTrigger(oSuperiorTransition)) {
				// no guard
				if(TCGDisjunctiveNormalFormHelperClass.DNFIsEmpty(
						oSuperiorTransition.getPrecondition())) {
					bSuperiorDefaultTransitionFound = true;
				}
				// guard - negate it for each inferior transition
				else {
					colStaticNegatedGuards.add(
							TCGDisjunctiveNormalFormHelperClass.negateDNF(
									oSuperiorTransition.getPrecondition(), true));
				}
			}
		}
		if(bSuperiorDefaultTransitionFound == true) {
			return colRetValues;
		}
		
		// search for overlapping transition events
		for(TCGEvent oEvent : in_oInferiorTransition.getEvents()) {
			List<TCGTransition> colEventOverlappingTransitions =
				new ArrayList<TCGTransition>();
			for(TCGTransition oSuperiorTransition : in_colSuperiorTransitions) {
	
				if(ObjectComparator.contains(oSuperiorTransition.getEvents(), oEvent)) {
					colEventOverlappingTransitions.add(oSuperiorTransition);
				}
			}
			// no superior transition is triggered by the current event
			Pair<TCGEvent, TCGDisjunctiveNormalForm> oPair = 
				new Pair<TCGEvent, TCGDisjunctiveNormalForm>(
					oEvent, GeneratedFactory.eINSTANCE.createTCGDisjunctiveNormalForm());
			if(in_oInferiorTransition.getPrecondition() != null) {
				oPair.setSecond(TCGDisjunctiveNormalFormHelperClass.copyDNFDeep(
						in_oInferiorTransition.getPrecondition()));
			}
			if(colEventOverlappingTransitions.isEmpty()) {
				for(TCGDisjunctiveNormalForm oDNF : colStaticNegatedGuards) {
					oPair.setSecond(TCGDisjunctiveNormalFormHelperClass.connectTwoDNFWithAnd(
							oPair.getSecond(), oDNF));
				}
				TCGDisjunctiveNormalFormHelperClass.removeContradictingConjunctions(oPair.getSecond());
				if(!TCGDisjunctiveNormalFormHelperClass.DNFIsEmpty(oPair.getSecond()))
					colRetValues.put(oPair.getFirst(), oPair.getSecond());
			}
			// superior transition is triggered by the same event
			List<TCGDisjunctiveNormalForm> colEventDependentNegatedDisjunctions =
				new ArrayList<TCGDisjunctiveNormalForm>();
			colEventDependentNegatedDisjunctions.addAll(colStaticNegatedGuards);
			boolean bFoundTransitionWithoutGuard = false;
			for(TCGTransition oTransition : colEventOverlappingTransitions) {
				// no guard -> do not add this event at all
				if(TCGDisjunctiveNormalFormHelperClass.DNFIsEmpty(oTransition.getPrecondition())) {
					bFoundTransitionWithoutGuard = true;
				}
				// existing guard -> add this transition guard to the list of negated guard
				else {
					colEventDependentNegatedDisjunctions.add(
							TCGDisjunctiveNormalFormHelperClass.negateDNF(
									oTransition.getPrecondition(), true));
				}
			}
			// all superior transitions reference a guard condition
			if(bFoundTransitionWithoutGuard == false) {
				for(TCGDisjunctiveNormalForm oDNF : colEventDependentNegatedDisjunctions) {
					oPair.setSecond(TCGDisjunctiveNormalFormHelperClass.connectTwoDNFWithAnd(
							oPair.getSecond(), oDNF));
				}
				boolean bDetectedConjunctionListIsEmpty = oPair.getSecond().getConjunctions().isEmpty();
				TCGDisjunctiveNormalFormHelperClass.removeContradictingConjunctions(oPair.getSecond());
				// check if the removal of contradicting conjunctions completely cleared the conjunction set
				if(bDetectedConjunctionListIsEmpty == oPair.getSecond().getConjunctions().isEmpty())
					colRetValues.put(oPair.getFirst(), oPair.getSecond());
			}
		}
		return colRetValues;
	}
	
	public static List<TCGTransition> getOutgoingTransitionsOfStateExcludingUpToSuperState(
			TCGNode in_oSubNode,
			TCGNode in_oSuperNode) {
		
		List<TCGTransition> colTransitions = new ArrayList<TCGTransition>();
		
		TCGNode oTmpNode = in_oSubNode;
		
		while(!oTmpNode.equals(in_oSuperNode)) {
			colTransitions.addAll(oTmpNode.getOutgoingTransitions());
			oTmpNode = TCGNodeHelperClass.getSuperState(oTmpNode);
		}
		
		return colTransitions;		
	}
	
	/*
	 * global access method for restricted guard conditions
	 * 1) recompute for each call
	 * 2) use a cache
	 */
	public static Map<TCGEvent, TCGDisjunctiveNormalForm> 
		returnAvailableEventsAndGuardsForStateAndOutgoingTransition(
			TCGNode in_oSubNode,
			TCGTransition in_oOuterTransition) {
		Map<TCGEvent, TCGDisjunctiveNormalForm> colEventGuardPairs = 
			new LinkedHashMap<TCGEvent,TCGDisjunctiveNormalForm>();
		
		// transition is a direct outgoing transition of the state
		if(in_oSubNode.getOutgoingTransitions().contains(in_oOuterTransition)) {
			// nothing???
		}
		else {
			List<TCGTransition> colSuperiorTransitions =
				getOutgoingTransitionsOfStateExcludingUpToSuperState(
						in_oSubNode, in_oOuterTransition.getSourceNode());
			colEventGuardPairs = getRemainingActivationConditionForInferiorTransition(
					colSuperiorTransitions, in_oOuterTransition);
		}
		
		return colEventGuardPairs;
	}

	public static List<List<TCGTransition>> getIncomingCompoundTransition(
			TCGNode in_oIntNode) {
		List<List<TCGTransition>> colCompoundTransitions = new ArrayList<List<TCGTransition>>();
		
		// collect transition sequences until stop condition
		// -> then start creating compound transitions
		// stop condition:
		// the used transition is explicitly triggered or it is a decision node
		for(TCGTransition oIncomingTransition : in_oIntNode.getIncomingTransitions()) {
			// keep on searching ... not explicitly triggered and no decision node
			if(transitionHasNoEventTrigger(oIncomingTransition) &&
					!(oIncomingTransition.getSourceNode() instanceof TCGIntermediateNode &&
							((TCGIntermediateNode)oIncomingTransition.getSourceNode()).getNodeType().equals(TCGNodeType.DECISION))) {
				TCGNode oSourceNode = oIncomingTransition.getSourceNode();
				// recursion
				List<List<TCGTransition>> colTmpCompoundTransition =
						getIncomingCompoundTransition(oSourceNode);
				// add the current transition
				for(List<TCGTransition> compoundTransition : colTmpCompoundTransition) {
					compoundTransition.add(0, oIncomingTransition);
				}
				// add to the return set
				colCompoundTransitions.addAll(colTmpCompoundTransition);
			}
			else {
				// transition is explicitly triggered - this is the starting point for a compound transition
				List<TCGTransition> oCompoundTransition = new ArrayList<TCGTransition>();
				oCompoundTransition.add(oIncomingTransition);
				colCompoundTransitions.add(oCompoundTransition);
			}
		}
		
		return colCompoundTransitions;
	}

	public static List<TCGTransition> getDefaultTriggeredOutgoingTransitions(
			TCGNode in_oNode) {
		List<TCGTransition> colRetValues = new ArrayList<TCGTransition>();
		for(TCGTransition oTransition : in_oNode.getOutgoingTransitions()) {
			if(transitionHasNoEventTrigger(oTransition)) {
				colRetValues.add(oTransition);
			}
		}
		return colRetValues;
	}
			
	public static TCGTransition copyTransitionValuesToNewTransition(
			TestCaseGraphHelper in_oTCGHelper,
			TCGTransition in_oOriginalTransition,
			TCGNode in_oNewSourceNode,
			TCGNode in_oNewTargetNode) throws Exception {
		TCGTransition oTransitionCopy = in_oTCGHelper.addTransition(
				in_oNewSourceNode, in_oNewTargetNode);
		
		oTransitionCopy.setCanBeProcessed(in_oOriginalTransition.isCanBeProcessed());
		oTransitionCopy.setContainer(in_oOriginalTransition.getContainer());
		oTransitionCopy.setName(in_oOriginalTransition.getName());
		oTransitionCopy.setPostcondition(
				TCGDisjunctiveNormalFormHelperClass.copyDNFDeep(
						in_oOriginalTransition.getPostcondition()));
		oTransitionCopy.setPrecondition(
				TCGDisjunctiveNormalFormHelperClass.copyDNFDeep(
						in_oOriginalTransition.getPrecondition()));
		oTransitionCopy.getEvents().addAll(in_oOriginalTransition.getEvents());
		
		return oTransitionCopy;
	}
}
