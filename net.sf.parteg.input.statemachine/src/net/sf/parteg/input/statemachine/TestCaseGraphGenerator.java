package net.sf.parteg.input.statemachine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import net.sf.parteg.base.testcasegraph.config.Configuration;
import net.sf.parteg.base.testcasegraph.generated.GeneratedFactory;
import net.sf.parteg.base.testcasegraph.generated.TCGEvent;
import net.sf.parteg.base.testcasegraph.generated.TCGIntermediateNode;
import net.sf.parteg.base.testcasegraph.generated.TCGNode;
import net.sf.parteg.base.testcasegraph.generated.TCGNodeType;
import net.sf.parteg.base.testcasegraph.generated.TCGRealNode;
import net.sf.parteg.base.testcasegraph.generated.TCGTransition;
import net.sf.parteg.base.testcasegraph.generated.TestCaseGraph;
import net.sf.parteg.base.testcasegraph.generated.TestCaseRegion;
import net.sf.parteg.base.testcasegraph.helperclasses.SystemModelHelper;
import net.sf.parteg.base.testcasegraph.helperclasses.TCGDisjunctiveNormalFormHelperClass;
import net.sf.parteg.base.testcasegraph.helperclasses.TCGEventHelperClass;
import net.sf.parteg.base.testcasegraph.helperclasses.TCGTransitionHelperClass;
import net.sf.parteg.base.testcasegraph.helperclasses.UMLVertexHelperClass;
import net.sf.parteg.base.testcasegraph.ocl.TestCaseGraphHelper;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.uml2.uml.BehavioralFeature;
import org.eclipse.uml2.uml.ConnectionPointReference;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Event;
import org.eclipse.uml2.uml.FunctionBehavior;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.PseudostateKind;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.Trigger;
import org.eclipse.uml2.uml.Vertex;
import org.eclipse.uml2.uml.resource.UMLResource;

public class TestCaseGraphGenerator {

	private StateMachine m_oStateMachine;
	private TestCaseGraphHelper m_oTCGHelper;
	// helper constructs
	private HashMap<Vertex, TCGNode> m_colVertex2Node;
	private Integer m_nTmpNodeCounter;
	private HashMap<Event, TCGEvent> m_colEventMapping;
	
	public TestCaseGraphGenerator(StateMachine in_oStateMachine)
	{
		m_oStateMachine = in_oStateMachine;
		m_colVertex2Node = new LinkedHashMap<Vertex, TCGNode>();
		m_nTmpNodeCounter = 0;
		m_colEventMapping = new LinkedHashMap<Event, TCGEvent>();
	}
	
	/* for state machine:
	 * copy all states; copy transitions, add additional nodes and arcs,
	 * add events with parameters and add test goals
	 */
	public TestCaseGraphHelper createTestCaseGraph() throws Exception
	{
		@SuppressWarnings({"unused"})  
		URI oURI = URIConverter.URI_MAP.get(URI.createURI("pathmap:/UML_LIBRARIES/"));
		URIConverter.URI_MAP.get(URI.createURI(UMLResource.PROFILES_PATHMAP));
		
		m_oTCGHelper = new TestCaseGraphHelper(); 
		List<Region> colStateMachineRegions = new ArrayList<Region>();
		
		// copy all states
		copyAllStates(colStateMachineRegions);

		// copy all transitions
		copyAllTransitions(colStateMachineRegions);

		if(Configuration.getTransformInitialAndFinalStates()) {
			// convert test case graph:
			// 1) all initial nodes of substatemachines are converted into connectionpoints
			getTestCaseGraphHelper().replaceInitialNodesWithConnectionPoints();
			// 2) all final states are converted into states with an outgoing transition to a connectionnode
			getTestCaseGraphHelper().replaceFinalStatesWithConnectionPoints();
		}
		
		// split up decision nodes corresponding to their incoming transitions
		// after splitting, each decision node has exactly one incoming transition
		if(Configuration.getSplitUpDecisionNodes()) {
			getTestCaseGraphHelper().splitUpDecisionNodes();
		}
		
		// should the state machine be flattened?
		if(Configuration.getFlattenStateMachineWithStateComposition()) {
			getTestCaseGraphHelper().flattenStateMachine(true);
		}
		
		// create hashmap from each referenced variable to the element that references it
		getTestCaseGraphHelper().createVariableReferences();
		
		getTestCaseGraphHelper().createAttributeToGetterReferences(m_oStateMachine);
		
		// configure the nodes of the testcasegraph (distance to initial node, etc.)
		getTestCaseGraphHelper().setDistancesToInit();
		
		// sanity check on the graph
		getTestCaseGraphHelper().doSanityCheck();
		
		return getTestCaseGraphHelper();		
	}
	
	/*
	 * copy all states of the state machine into the test case graph
	 */ 
	private void copyAllStates(List<Region> in_colStateMachineRegions)
	{
		// copy also connectionpoints and connectionpointreferences
		copyAllConnectionPoints(m_oStateMachine,
				m_oTCGHelper.getTestCaseGraph());
		
		for(Region oRegion  : m_oStateMachine.getRegions())
		{
			copyAllStatesForRegion(oRegion, 
					m_oTCGHelper.getTestCaseGraph().getRegions(),
					in_colStateMachineRegions,
					new HashMap<StateMachine, TestCaseGraph>());
		}
	}
	
	private void copyAllStatesForRegion(
			Region in_oRegion, 
			List<TestCaseRegion> in_colRegions,
			List<Region> io_colStateMachineRegions,
			HashMap<StateMachine, TestCaseGraph> io_colSubmachineMapping)
	{
		// reference all used regions for adding the transitions
		if(!io_colStateMachineRegions.contains(in_oRegion)) {
			io_colStateMachineRegions.add(in_oRegion);
		
			TestCaseRegion oTCRegion = GeneratedFactory.eINSTANCE.createTestCaseRegion();
			in_colRegions.add(oTCRegion);
			for(Vertex oVertex : in_oRegion.getSubvertices())
			{
				if(oVertex instanceof State)
				{
					TCGRealNode oTCGRealNode = m_oTCGHelper.addRealNode(oTCRegion);
					oTCGRealNode.setName(UMLVertexHelperClass.getFullName(oVertex));
					m_colVertex2Node.put(oVertex, oTCGRealNode);
					oTCGRealNode.setOriginalNode(oVertex); // used for event parameter instances
					
					// handle state invariants
					addStateInvariant((State)oVertex, oTCGRealNode,
							Configuration.getSplitInequationsBeforeTestGoalDefinition());
					
					// copy also states from composite states and submachine states
					State oState = (State)oVertex;
					if(!oState.getRegions().isEmpty())
					{
						oTCGRealNode.setSubGraph(GeneratedFactory.eINSTANCE.createTestCaseGraph());
						oTCGRealNode.getSubGraph().setCompositeSuperState(oTCGRealNode);
						for(Region oRegion : oState.getRegions())
						{
							copyAllStatesForRegion(oRegion, oTCGRealNode.getSubGraph().getRegions(),
									io_colStateMachineRegions, io_colSubmachineMapping);
						}
						copyAllConnectionPointsAndReferences(oState, oTCGRealNode);
					} else if(oState.getSubmachine() != null)
					{
						// was the submachine already copied? Then just reference it.
						TestCaseGraph oReferencedTCG = io_colSubmachineMapping.get(oState.getSubmachine());
						if(oReferencedTCG != null)
						{
							oTCGRealNode.setSubGraph(oReferencedTCG);
	//						oReferencedTCG.getSuperStates().add(oTCGNode);
							oReferencedTCG.setCompositeSuperState(oTCGRealNode);
							copyAllConnectionPointsAndReferences(oState, oTCGRealNode);
						} else 
						{
							oTCGRealNode.setSubGraph(GeneratedFactory.eINSTANCE.createTestCaseGraph());
	//						oTCGNode.getSubGraph().getSuperStates().add(oTCGNode);
							oTCGRealNode.getSubGraph().setCompositeSuperState(oTCGRealNode);
							io_colSubmachineMapping.put(oState.getSubmachine(), oTCGRealNode.getSubGraph());
							copyAllConnectionPoints(oState.getSubmachine(), oTCGRealNode.getSubGraph());
							copyAllConnectionPointsAndReferences(oState, oTCGRealNode);
							for(Region oRegion : oState.getSubmachine().getRegions())
							{
								copyAllStatesForRegion(oRegion, oTCGRealNode.getSubGraph().getRegions(),
										io_colStateMachineRegions, io_colSubmachineMapping);
							}					
						}
					}
				} 
				else // oVertex instanceof Pseudostate
				{
					Pseudostate oPseudostate = (Pseudostate)oVertex;
					
					// do not copy pseudo states here ...
					if(!(oPseudostate.getKind().equals(PseudostateKind.ENTRY_POINT_LITERAL) ||
							oPseudostate.getKind().equals(PseudostateKind.EXIT_POINT_LITERAL))) {
						TCGIntermediateNode oTCGIntermediateNode = 
							m_oTCGHelper.addIntermediateNode(oTCRegion, TCGNodeType.UNKNOWN);
						oTCGIntermediateNode.setName(UMLVertexHelperClass.getFullName(oPseudostate));
						m_colVertex2Node.put(oPseudostate, oTCGIntermediateNode);
		
						oTCGIntermediateNode.setOriginalNode(null);
						if(oPseudostate.getKind().equals(PseudostateKind.INITIAL_LITERAL)) {
							oTCGIntermediateNode.setNodeType(TCGNodeType.INITIAL);
						}
						else if(oPseudostate.getKind().equals(PseudostateKind.CHOICE_LITERAL) ||
								oPseudostate.getKind().equals(PseudostateKind.JUNCTION_LITERAL)) {
							oTCGIntermediateNode.setNodeType(TCGNodeType.DECISION);
						}
					}
				}
			}
		}
	}
	
	/*
	 * just copy the connection points - the connection point references are contained
	 * in the referencing super state
	 */
	private void copyAllConnectionPoints(StateMachine in_oStateMachine,
			TestCaseGraph in_oTCG)
	{
		for(Pseudostate oPseudoState : in_oStateMachine.getConnectionPoints())
		{
			TCGIntermediateNode oNode = GeneratedFactory.eINSTANCE.createTCGIntermediateNode();
			oNode.setOriginalNode(null); // is pseudostate
			oNode.setUseAllTransitionsInParallel(true);
			oNode.setContainer(in_oTCG);
			in_oTCG.getContainedConnectionPoints().add(oNode);
			m_colVertex2Node.put(oPseudoState, oNode);
			if(oPseudoState.getKind().equals(PseudostateKind.ENTRY_POINT_LITERAL)) {
				oNode.setNodeType(TCGNodeType.ENTRY);
			}
			else if(oPseudoState.getKind().equals(PseudostateKind.EXIT_POINT_LITERAL)) {
				oNode.setNodeType(TCGNodeType.EXIT);
			}
		}		
	}
	
	/*
	 * copy the connection points and the connection point references 
	 */
	private void copyAllConnectionPointsAndReferences(
			State in_oState,
			TCGRealNode in_oNode)
	{
		// first case: composite state - contains connectionpoints and connectionpointreferences
		if(!in_oState.getRegions().isEmpty())
		{
			List<Pseudostate> colPseudoStates = new ArrayList<Pseudostate>();
			colPseudoStates.addAll(in_oState.getConnectionPoints());
			// hack for incompatibilities of TopCased Editor
			for(Region oRegion : in_oState.getRegions()) {
				for(Vertex oVertex : oRegion.getSubvertices()) {
					if(oVertex instanceof Pseudostate) {
						Pseudostate oTmpPs = (Pseudostate)oVertex;
						if(oTmpPs.getKind().equals(PseudostateKind.ENTRY_POINT_LITERAL) ||
								oTmpPs.getKind().equals(PseudostateKind.EXIT_POINT_LITERAL)) {
							colPseudoStates.add(oTmpPs);
						}
					}
				}
			}
			
			// create nodes for the connectionpoints
//			for(Pseudostate oPseudoState : in_oState.getConnectionPoints()) {
			for(Pseudostate oPseudoState : colPseudoStates) {
				TCGIntermediateNode oNode = GeneratedFactory.eINSTANCE.createTCGIntermediateNode();
				oNode.setOriginalNode(null);
				oNode.setUseAllTransitionsInParallel(true);
				in_oNode.getContainedConnectionPoints().add(oNode);
				oNode.setContainer(in_oNode);
				m_colVertex2Node.put(oPseudoState, oNode);
				if(oPseudoState.getKind().equals(PseudostateKind.ENTRY_POINT_LITERAL)) {
					oNode.setNodeType(TCGNodeType.ENTRY);
				}
				else if(oPseudoState.getKind().equals(PseudostateKind.EXIT_POINT_LITERAL)) {
					oNode.setNodeType(TCGNodeType.EXIT);
				}
			}
			// create connectionpointreferences that reference the connectionpoints
			// the following part should be unused - no connectionpointreferences are used for composite states 
			for(ConnectionPointReference oCPR : in_oState.getConnections())
			{
				TCGIntermediateNode oNode = GeneratedFactory.eINSTANCE.createTCGIntermediateNode();
				in_oNode.getContainedConnectionPoints().add(oNode);
				oNode.setContainer(in_oNode);
				m_colVertex2Node.put(oCPR, oNode);
				for(Pseudostate oPseudoState : oCPR.getEntries())
				{
					connectConnectionPointAndReference(oPseudoState, oNode);
				}	
				for(Pseudostate oPseudoState : oCPR.getExits())
				{
					connectConnectionPointAndReference(oPseudoState, oNode);
				}	
			}
		}
		
		// second case: submachine state - contains just the connectionpointreferences
		if(in_oState.getSubmachine() != null)
		{
			for(ConnectionPointReference oCPR : in_oState.getConnections())
			{
				TCGIntermediateNode oNode = GeneratedFactory.eINSTANCE.createTCGIntermediateNode();
				in_oNode.getContainedConnectionPointReferences().add(oNode);
				oNode.setContainer(in_oNode);
				m_colVertex2Node.put(oCPR, oNode);				
				for(Pseudostate oPseudoState : oCPR.getEntries())
				{
					connectConnectionPointAndReference(oPseudoState, oNode);
				}	
				for(Pseudostate oPseudoState : oCPR.getExits())
				{
					connectConnectionPointAndReference(oPseudoState, oNode);
				}	
			}
		}
	}
	
	private void connectConnectionPointAndReference(Pseudostate in_oPseudoState, TCGIntermediateNode in_oConnectionPointReference) {
		TCGIntermediateNode oReferencedNode = (TCGIntermediateNode)m_colVertex2Node.get(in_oPseudoState);
		in_oConnectionPointReference.getReferencedConnectionPoints().add(oReferencedNode);
		oReferencedNode.getReferencedConnectionPointReferences().add(in_oConnectionPointReference);		
	}
	
	/*
	 * copy all transitions of the state machine to the test case graph
	 */
	private void copyAllTransitions(List<Region> in_colStateMachineRegions)
	throws Exception
	{
		for(Region oRegion : in_colStateMachineRegions) {
			for(Transition oTransition : oRegion.getTransitions()) {
				
				List<Event> colEvents = new ArrayList<Event>();
				for(Trigger oTrigger : oTransition.getTriggers()) {
					colEvents.add(oTrigger.getEvent());
				}
				boolean bAddTransition = true;
				List<String> colAdditionalGuardNegations = new ArrayList<String>(); 
				
				if(Configuration.getEnforceUnambiguousGuardsAndEvents()) {

					// collect all interfering transitions
					List<Transition> colInterferingTransitionsWithTheSameTrigger =
						new ArrayList<Transition>();
					//if(Configuration.getEnforceUnambiguousGuards()) {
					// check guards of outgoing transitions of the same source node
					
					// just remove conflicts with super transitions statically - look at the paper! 
					
//					for(Transition oInterferingTransition : 
//						TCGTransitionHelperClass.getSourceStateTransitionsTriggeredByTheSameEvent(oTransition)) {
//						// do not add transition with guard "else"
//						String sGuard = SystemModelHelper.getTransitionGuard(oInterferingTransition);
//						if(!sGuard.equals("else"))
//							colInterferingTransitionsWithTheSameTrigger.add(oInterferingTransition);
//					}
					//}				
					boolean bEventsExisting = false;
					// check super transitions only if this transition is not default-triggered 
					if(!colEvents.isEmpty()) {
						bEventsExisting = true;
						// if: outer transition has priority over inner transition
						// then: modify inner transitions
						// else: decide separately within the test generation process 
						if(!Configuration.isInnerTransitionHasPriorityOverOuterTransition()) {
							// check guards of outgoing transitions of super states
							colInterferingTransitionsWithTheSameTrigger.addAll( 
								TCGTransitionHelperClass.getCompositeStateSuperTransitionsTriggeredByTheSameEvent(oTransition));
						}
//						else {
//							// check guards of outgoing transitions of super states
//							colInterferingTransitionsWithTheSameTrigger.addAll( 
//								TCGTransitionHelperClass.getContainedStateTransitionsTriggeredByTheSameEvent(oTransition));							
//						}
					}
					for(Transition oInterferingTransition : colInterferingTransitionsWithTheSameTrigger) {
						if(oInterferingTransition.getGuard() == null || 
								oInterferingTransition.getGuard().getSpecification() == null) {
							for(Trigger oInterferingTrigger : oInterferingTransition.getTriggers()) {
								colEvents.remove(oInterferingTrigger.getEvent());
							}
						}
						else {
							// conjunct the negated guard of the super transition
							String sGuard = SystemModelHelper.getTransitionGuard(oInterferingTransition);
							// if guard of super transition is "else" -> resolve it!
							if(sGuard.equals("else")) {
								sGuard = createElseGuardCondition(oInterferingTransition);
							}
	
							sGuard = "not (" + sGuard + ")";
							colAdditionalGuardNegations.add(sGuard);
						}
					}
					// there were events previously - now, they are removed -> mark transition!
					if(bEventsExisting && colEvents.isEmpty()) {
						bAddTransition = false;
						for(Trigger oTrigger : oTransition.getTriggers()) {
							colEvents.add(oTrigger.getEvent());
						}						
					}
				}

				// should transitions be splitted so that each has at most one event?
				if(Configuration.getSplitUpTransitionsToOneEventLimit() &&
						colEvents.size() > 1) {
					for(Event oEvent : colEvents) {
						List<Event> colTmpEvents = new ArrayList<Event>();
						colTmpEvents.add(oEvent);
						copyTransition(
								oTransition, colTmpEvents, 
								colAdditionalGuardNegations, bAddTransition);
					}
				}
				else {
					copyTransition(
							oTransition, colEvents, 
							colAdditionalGuardNegations, bAddTransition);
				}
			}
		}
	}
	
	private void copyTransition(
			Transition in_oTransition,
			List<Event> in_colEvents,
			List<String> in_colAdditionGuardConditions,
			boolean in_bAddTransition) throws Exception
	{
		// add transition
		TCGTransition oTCGTransition = m_oTCGHelper.addTransition(
				m_colVertex2Node.get(in_oTransition.getSource()),
				m_colVertex2Node.get(in_oTransition.getTarget()));
		
		// include transition event
		addEvents(in_oTransition, oTCGTransition, in_colEvents);
		
		// include transition guard: add as precondition
		addTransitionGuard(in_oTransition, oTCGTransition,
				in_colAdditionGuardConditions,
				Configuration.getSplitInequationsBeforeTestGoalDefinition());
		
		// include pre-/postconditions of referenced effects
		addEffectPreAndPostcondition(in_oTransition, oTCGTransition,
				Configuration.getSplitInequationsBeforeTestGoalDefinition());
		
		if(!in_bAddTransition) {
			oTCGTransition.setCanBeProcessed(false);
			m_oTCGHelper.getLogger().getFormattedOutput().appendln(
					"warning: transition cannot be processed due to event overriding: >"
					 + oTCGTransition.toString() + "<");
			m_oTCGHelper.getLogger().getFormattedOutput().appendln(
					"   from " + oTCGTransition.getSourceNode().getName());
			m_oTCGHelper.getLogger().getFormattedOutput().appendln(
					"   to   " + oTCGTransition.getTargetNode().getName());
			m_oTCGHelper.getLogger().getFormattedOutput().appendln(
					"   triggered by events:");
			for(TCGEvent oEvent : oTCGTransition.getEvents()) {
				m_oTCGHelper.getLogger().getFormattedOutput().appendln(
					"      " + oEvent.getName());
			}
		}
	}
	
	public TestCaseGraphHelper getTestCaseGraphHelper()
	{
		if(m_oTCGHelper == null)
			m_oTCGHelper = new TestCaseGraphHelper();
		return m_oTCGHelper;
	}


	/*
	 * adds event information and a default event if the source node is a State Node 
	 */
	private void addEvents(
			Transition in_oTransition, 
			TCGTransition in_oActualTCGTransition,
			List<Event> in_colEvents)
	{
		// determine the effect of the transition - select their parameters for event
		Operation oTransitionEffect = null;
		if(in_oTransition.getEffect() != null &&
				in_oTransition.getEffect() instanceof FunctionBehavior) {
			BehavioralFeature oFeature = ((FunctionBehavior)in_oTransition.getEffect()).getSpecification();
			if(oFeature instanceof Operation) {
				oTransitionEffect = (Operation)oFeature;
			}
		}
		
		// decision if there are unique event instances or several copies ...
		// impact e.g. on conflict checks for test goal generation -> may result in multiple definitions of the same parameter
		//boolean bUsedUniqueEventInstances = false;
		boolean bUsedUniqueEventInstances = true;
		
		if(in_oTransition.getSource() instanceof State) {
			TCGEvent oUsedEvent = null;
			// add triggering event
			if(in_colEvents.isEmpty()) {
				if(bUsedUniqueEventInstances) oUsedEvent = m_colEventMapping.get(null);
				if(oUsedEvent == null) {
					oUsedEvent = TCGEventHelperClass.createTCGEvent(null, true);
					if(bUsedUniqueEventInstances) m_colEventMapping.put(null, oUsedEvent);
				}
				in_oActualTCGTransition.getEvents().add(oUsedEvent);
				TCGEventHelperClass.createMatchingForAllParameters(
						oTransitionEffect, oUsedEvent, in_oActualTCGTransition);
			}
			else {
				for(Event oEvent : in_colEvents) {
					if(bUsedUniqueEventInstances) oUsedEvent = m_colEventMapping.get(oEvent);
					if(oUsedEvent == null) {
						oUsedEvent = TCGEventHelperClass.createTCGEvent(oEvent, true);
						if(bUsedUniqueEventInstances) m_colEventMapping.put(oEvent, oUsedEvent);
					}
					in_oActualTCGTransition.getEvents().add(oUsedEvent);
					TCGEventHelperClass.createMatchingForAllParameters(
							oTransitionEffect, oUsedEvent, in_oActualTCGTransition);
				}
			}
		}
	}
	
	private void addTransitionGuard(
			Transition in_oTransition,
			TCGTransition in_oActualTCGTransition,
			List<String> in_colNegatedGuardStrings,
			boolean in_bSplitInequationsBeforeTestGoalDefinition)
	throws Exception
	{
		// guard condition
		String sGuard = SystemModelHelper.getTransitionGuard(in_oTransition);
		
		//for(TCGEvent oEvent : in_oActualTCGTransition.getEvents()) {
		TCGEvent oEvent = null;
		if(!in_oActualTCGTransition.getEvents().isEmpty())
			oEvent = in_oActualTCGTransition.getEvents().get(0);
		
		// corresponding namespace (of corresponding operation)
		Namespace oNamespace = SystemModelHelper.getNamespaceForEvent(
				(in_oTransition.getSource().getContainer() != null ? in_oTransition.getSource() : in_oTransition.getTarget()), 
				TCGEventHelperClass.getEventOfTCGEvent(oEvent),
				in_oTransition);
		org.eclipse.uml2.uml.Class oContextClass = Configuration.getContextClassForVertex(
				(in_oTransition.getSource().getContainer() != null ? in_oTransition.getSource() : in_oTransition.getTarget()));
		
		boolean bIsElseGuard = sGuard.equals("else");
		if(bIsElseGuard) {
			sGuard = createElseGuardCondition(in_oTransition);
		}
		
		for(String sAdditionalNegatedGuard : in_colNegatedGuardStrings) {
			if(!sGuard.isEmpty())
				sGuard = "(" + sGuard + ") and (" + sAdditionalNegatedGuard + ")";
			else
				sGuard = sAdditionalNegatedGuard;
		}
		
		in_oActualTCGTransition.setPrecondition(
				TCGDisjunctiveNormalFormHelperClass.getDNFForCondition(
						sGuard, oNamespace, oContextClass,
						Configuration.getOCLGuardId(), 
						in_bSplitInequationsBeforeTestGoalDefinition));
		if(bIsElseGuard) {
			// mark the else-guard so that no complex test goals are created for it
			in_oActualTCGTransition.getPrecondition().setUseForTestGoals(
					Configuration.getUseElseForTestGoals());
		}
		
		// add information if transition can be active at all (e.g. if there is a contradicting guard)
		if(TCGDisjunctiveNormalFormHelperClass.
				allConjunctionsRemovedBecauseOfInfeasibility(
						in_oActualTCGTransition.getPrecondition())) {
			in_oActualTCGTransition.setCanBeProcessed(false);
		}
	}
	
	private String createElseGuardCondition(Transition in_oTransition) throws Exception
	{
		StringBuffer sElseGuard = new StringBuffer();
		// find all other outgoing transitions
		Vertex oSourceState = in_oTransition.getSource();
		for(Transition oOutgoingTransition : oSourceState.getOutgoings()) {
			
			// only consider transitions that are not the current one (in_oTransition)
			if(oOutgoingTransition.equals(in_oTransition)) {
				continue;
			}
			
			// transition has to have the same trigger as the original transition!
			if(oOutgoingTransition.getTriggers().isEmpty()) {
				if(!in_oTransition.getTriggers().isEmpty()) {
					continue;
				}
			}
			else {
				if(in_oTransition.getTriggers().isEmpty()) {
					continue;
				}
				else {
					boolean bOverlap = false;
					// check overlapping of trigger events
					for(Trigger oOutgoingTrigger : oOutgoingTransition.getTriggers()) {
						for(Trigger oInTrigger : in_oTransition.getTriggers()) {
							if(oOutgoingTrigger.getEvent().equals(oInTrigger.getEvent()))
								bOverlap = true;
						}
					}
					if(bOverlap == false)
						continue;
				}
			}
			
			// model validation: no other empty guard and no other "else"
			String sOutgoingGuard = ((LiteralString)oOutgoingTransition.getGuard().getSpecification()).getValue(); 
			if(sOutgoingGuard.compareTo("else") == 0) {
				throw new Exception("too many else conditions from node >" + oSourceState.getQualifiedName() + "<");
			}
			else if(sOutgoingGuard.isEmpty()) {
				throw new Exception("one empty guard and one else guard together are not allowed from node >" + oSourceState.getQualifiedName() + "<");
			}
			
			// negate all other guards of transitions triggered by the same event and conjoin them at the else-guard
			if(sElseGuard.length() > 0) {
				sElseGuard.append(" and ");
			}
			sElseGuard.append("not (");
			sElseGuard.append(sOutgoingGuard);
			sElseGuard.append(")");
		}
		
		return sElseGuard.toString();
	}
	
	private void addStateInvariant(
			State in_oOriginalState,
			TCGRealNode in_oTCGNode,
			boolean in_bSplitInequationsBeforeTestGoalDefinition)
	{
		// guard condition
		String sGuard = SystemModelHelper.getStateInvariant(in_oOriginalState);
		// corresponding namespace
		org.eclipse.uml2.uml.Class oNamespace = 
			Configuration.getContextClassForVertex(in_oOriginalState);

		in_oTCGNode.setCondition(
				TCGDisjunctiveNormalFormHelperClass.getDNFForCondition(
						sGuard, oNamespace, oNamespace,
						Configuration.getOCLGuardId(), 
						in_bSplitInequationsBeforeTestGoalDefinition));		
	}
	
	private void addEffectPreAndPostcondition(
			Transition in_oTransition,
			TCGTransition in_oActualTCGTransition,
			boolean in_bSplitInequationsBeforeTestGoalDefinition)
	throws Exception
	{
		Operation oBehavior = TestCaseGraphHelper.getContextEffectSpecification(in_oTransition);
		org.eclipse.uml2.uml.Class oContextClass = Configuration.getContextClassForVertex(
				(in_oTransition.getSource().getContainer() != null ? in_oTransition.getSource() : in_oTransition.getTarget()));

		if(oBehavior != null)
		{
			// actual TCGTransition was already used for event or guard?
			// -> create new transition!
			if(!in_oActualTCGTransition.getEvents().isEmpty() ||
					(in_oActualTCGTransition.getPrecondition() != null))
			{
				in_oActualTCGTransition = 
					m_oTCGHelper.insertTransitionBetweenTransitionAndTargetNode(
							in_oActualTCGTransition);
				in_oActualTCGTransition.getSourceNode().setName(getTemporaryNodeName());
			}
			
			// add the precondition of the referenced operation
			if(oBehavior.getPreconditions() != null)
			{
				// TODO alle angegebenen preconditions übernehmen
				//for(Constraint oPreConstraint : oBehavior.getPreconditions())
				if(!oBehavior.getPreconditions().isEmpty())
				{
					Constraint oPreConstraint = oBehavior.getPreconditions().get(0);
					String sPreExpression = 
						SystemModelHelper.getConstraintSpecification(oPreConstraint);
					in_oActualTCGTransition.setPrecondition(
							TCGDisjunctiveNormalFormHelperClass.getDNFForCondition(
									sPreExpression, oBehavior, oContextClass,
									Configuration.getOCLPreId(), 
									in_bSplitInequationsBeforeTestGoalDefinition));
				}
			}

			// add the postcondition of the referenced operation
			if(oBehavior.getPostconditions() != null)
			{
				if(!oBehavior.getPostconditions().isEmpty())
				{
					Constraint oPostConstraint = oBehavior.getPostconditions().get(0);
					String sPostExpression = 
						SystemModelHelper.getConstraintSpecification(oPostConstraint);
					in_oActualTCGTransition.setPostcondition(
							TCGDisjunctiveNormalFormHelperClass.getDNFForCondition(
									sPostExpression, oBehavior, oContextClass,
									Configuration.getOCLPostId(), 
									in_bSplitInequationsBeforeTestGoalDefinition));
				}
			}
		}
	}
		

	

	
	private String getTemporaryNodeName()
	{
		return "tmp" + ++m_nTmpNodeCounter;
	}
	

}
