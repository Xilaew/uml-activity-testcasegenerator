package net.sf.parteg.base.testcasegraph.helperclasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import net.sf.parteg.base.testcasegraph.config.Configuration;
import net.sf.parteg.base.testcasegraph.generated.TCGDisjunctiveNormalForm;
import net.sf.parteg.base.testcasegraph.generated.TCGEvent;
import net.sf.parteg.base.testcasegraph.generated.TCGIntermediateNode;
import net.sf.parteg.base.testcasegraph.generated.TCGNode;
import net.sf.parteg.base.testcasegraph.generated.TCGRealNode;
import net.sf.parteg.base.testcasegraph.generated.TCGTransition;
import net.sf.parteg.base.testcasegraph.generated.TestCaseGraph;
import net.sf.parteg.base.testcasegraph.generated.TestCaseRegion;
import net.sf.parteg.base.testcasegraph.ocl.TestCaseGraphHelper;

public class TestCaseGraphFlattener {

	// the value of this attribute determines if we use state composition
	// or push down the region to one state machine
	private boolean m_bUseStateComposition;
	private TestCaseGraphHelper m_oTCGHelper;
	private List<TCGRealNode> m_AlreadyFlattenedRealNodes;

	private class TransitionCreationInformationContainer {
		public Map<TCGEvent, TCGDisjunctiveNormalForm> m_colEventToDNF;
		public TestCaseRegion m_oRegion;
		public TCGNode m_oNode;
		public TCGTransition m_oTransition;
		public TransitionCreationInformationContainer(
				Map<TCGEvent, TCGDisjunctiveNormalForm> in_colEventToDNF,
				TestCaseRegion in_oRegion,
				TCGNode in_oInnerNode,
				TCGTransition in_oTransition) {
			m_colEventToDNF = in_colEventToDNF;
			m_oRegion = in_oRegion;
			m_oNode = in_oInnerNode;
			m_oTransition = in_oTransition;			
		}
	}
	
	public TestCaseGraphFlattener(
			boolean in_bUseStateComposition,
			TestCaseGraphHelper in_oTCGHelper) {
		m_bUseStateComposition = in_bUseStateComposition;
		m_oTCGHelper = in_oTCGHelper;
		m_AlreadyFlattenedRealNodes = new ArrayList<TCGRealNode>();
	}
	
	
	public void flattenTestCaseGraph() throws Exception
	{
		flattenTestCaseGraph(m_oTCGHelper.getTestCaseGraph());
	}
	
	private void flattenTestCaseGraph(
			TestCaseGraph in_oTCG) throws Exception
	{
		if(m_bUseStateComposition == true) {
			composeStatesOfRegionsInTestCaseGraph(in_oTCG);
		}
		
		for(TestCaseRegion oRegion : in_oTCG.getRegions()) {
			flattenRegion(oRegion);
		}		
	}
	
	private void flattenRegion(TestCaseRegion in_oRegion) throws Exception
	{
		List<TCGRealNode> colRealNodes = new ArrayList<TCGRealNode>();
		boolean bOneStateWasFlattened = true;
		while(bOneStateWasFlattened) {
			bOneStateWasFlattened = false;
			for(TCGNode oNode : in_oRegion.getNodes()) {
				if(oNode instanceof TCGRealNode) {
					TCGRealNode oRealNode = (TCGRealNode)oNode; 
					if(!m_AlreadyFlattenedRealNodes.contains(oRealNode)) {
						if(flattenRealNode(oRealNode)) {
							m_AlreadyFlattenedRealNodes.add(oRealNode);
							colRealNodes.add(oRealNode);
							bOneStateWasFlattened = true;
							break;
						}
					}
				}
			}
		}
		for(TCGRealNode oRealNode : colRealNodes) {
			m_oTCGHelper.removeRealNode(oRealNode);			
		}
	}
	
	private boolean flattenRealNode(TCGRealNode in_oRealNode) throws Exception
	{
		boolean bNodeIsFlattened = false;
		TestCaseGraph oTCG = in_oRealNode.getSubGraph();
		if(oTCG != null) {
			bNodeIsFlattened = true;
			// first recursively flatten the contained state machine
			flattenTestCaseGraph(oTCG);
			
			// TODO also care for multiple regions! pull them to the upper-most state machine 
			
			// then embed the flattened state machine
			
			
			// 1) create transitions for connectionpoints
			createDirectConnectionsForConnectionPoints(in_oRealNode);
			removeAllConnectionPoints(in_oRealNode);

			// 2) create transitions for connectionpointreferences
			// TODO implement for referenced state machines (watch out for recursion)

			// 3) create transitions for incoming transitions
			createDirectConnectionsForIncomingTransitions(in_oRealNode);
			removeAllInitialNodes(in_oRealNode);
			
			// 4) create (multiple) transitions for outgoing transitions
			createDirectConnectionsForOutgoingTransitions(in_oRealNode);

			// 5) move all contained states and transitions of the regions to the upper region
			moveAllContainedRegionStatesTransitionsToUpperRegion(in_oRealNode);
		}
		return bNodeIsFlattened;
	}

	private void moveAllContainedRegionStatesTransitionsToUpperRegion(TCGRealNode in_oRealNode)
	{
		TestCaseGraph oTCG = in_oRealNode.getSubGraph();
		if(oTCG != null) {
			
			List<TCGNode> colNodes = new ArrayList<TCGNode>();
			List<TCGTransition> colTransitions = new ArrayList<TCGTransition>();
			for(TestCaseRegion oRegion : oTCG.getRegions()) {
				colNodes.addAll(oRegion.getNodes());
				colTransitions.addAll(oRegion.getTransitions());
			}
			
			// change regions for nodes
			for(TCGNode oNode : colNodes) {
				in_oRealNode.getContainer().getNodes().add(oNode);
				if(oNode instanceof TCGRealNode) {
					((TCGRealNode)oNode).setContainer(in_oRealNode.getContainer());
				}
				else if(oNode instanceof TCGIntermediateNode) {
					((TCGIntermediateNode)oNode).setContainer(in_oRealNode.getContainer());
				}
			}
			
			// change regions for transitions
			in_oRealNode.getContainer().getTransitions().addAll(colTransitions);
			for(TCGTransition oTransition : colTransitions) {
				oTransition.setContainer(in_oRealNode.getContainer());
			}
		}
	}
	
	private void createDirectConnectionsForConnectionPoints(TCGRealNode in_oRealNode) throws Exception
	{
		for(TCGIntermediateNode oIntNode : in_oRealNode.getContainedConnectionPoints()) {
			for(TCGTransition oIncomingTransition : oIntNode.getIncomingTransitions()) {
				for(TCGTransition oOutgoingTransition : oIntNode.getOutgoingTransitions()) {
					
					TCGTransitionHelperClass.
						createNewTransitionsAndIntermediateNodeBetween(
							m_oTCGHelper,
							in_oRealNode.getContainer(),
							oIncomingTransition,
							oOutgoingTransition);
				}
			}
		}
	}
	
	private void removeAllConnectionPoints(TCGRealNode in_oRealNode) throws Exception
	{
		while(!in_oRealNode.getContainedConnectionPoints().isEmpty()) {
			TCGIntermediateNode oNode = in_oRealNode.getContainedConnectionPoints().get(0);
			m_oTCGHelper.removeIntermediateNode(oNode);
		}
	}
	
	private void createDirectConnectionsForIncomingTransitions(TCGRealNode in_oRealNode) throws Exception
	{
		TestCaseGraph oTCG = in_oRealNode.getSubGraph();
		if(oTCG != null) {
			for(TCGTransition oIncomingTransition : in_oRealNode.getIncomingTransitions()) {
				for(TestCaseRegion oRegion : oTCG.getRegions()) {
					for(TCGIntermediateNode oIntNode : TCGRegionHelperClass.findInitialNodes(oRegion)) {
						if(oIntNode.getOutgoingTransitions().size() != 1) {
							System.err.println("error: initial node with wrong number of outgoing transitions: "
									+ oIntNode.getOutgoingTransitions().size());
						}
						else {
							TCGTransitionHelperClass.
							createNewTransitionsAndIntermediateNodeBetween(
									m_oTCGHelper,
									in_oRealNode.getContainer(),
									oIncomingTransition,
									oIntNode.getOutgoingTransitions().get(0));
						}
					}
				}
			}
		}
	}

	private void removeAllInitialNodes(TCGRealNode in_oRealNode) throws Exception {
		TestCaseGraph oTCG = in_oRealNode.getSubGraph();
		if(oTCG != null) {
			List<TCGIntermediateNode> colInitialNodes = new ArrayList<TCGIntermediateNode>();
			for(TestCaseRegion oRegion : oTCG.getRegions()) {
				colInitialNodes.addAll(TCGRegionHelperClass.findInitialNodes(oRegion));
			}
			for(TCGIntermediateNode oIntNode : colInitialNodes) {
				m_oTCGHelper.removeIntermediateNode(oIntNode);
			}
		}
	}
	
	private void createDirectConnectionsForOutgoingTransitions(TCGRealNode in_oOuterNode) throws Exception
	{
		List<TransitionCreationInformationContainer> colTransitionInformations =
			new ArrayList<TransitionCreationInformationContainer>();
		TestCaseGraph oTCG = in_oOuterNode.getSubGraph();
		if(oTCG != null) {
			
			// connections for super-transitions with real event
			for(TCGTransition oTransition : in_oOuterNode.getOutgoingTransitions()) {
				if(!oTransition.getEvents().isEmpty() &&
						!oTransition.getEvents().get(0).isDefaultEvent()) {
					for(TestCaseRegion oRegion : oTCG.getRegions()) {
						for(TCGNode oInnerNode : oRegion.getNodes()) {
							// only connect real nodes!
							if(oInnerNode instanceof TCGRealNode) {
								
								if(Configuration.isInnerTransitionHasPriorityOverOuterTransition()) {
									if(oInnerNode.getName().endsWith("WAITING_FOR_TRAIN_TO_REACH_STANDSTILL") &&
//									if(oInnerNode.getName().endsWith("WAITING_FOR_ACK_OF_UNREACHABLE_LTO") &&
											oTransition.getTargetNode().getName() != null &&
											oTransition.getTargetNode().getName().endsWith("fail")) {
									}
									Map<TCGEvent, TCGDisjunctiveNormalForm> colEventGuardCombinations = 
										TCGTransitionHelperClass.
											returnAvailableEventsAndGuardsForStateAndOutgoingTransition(oInnerNode, oTransition);
									if(!colEventGuardCombinations.keySet().isEmpty()) {
										colTransitionInformations.add(
												new TransitionCreationInformationContainer(
														colEventGuardCombinations, oRegion,
														oInnerNode, oTransition));
									}
								}
								else {
									colTransitionInformations.add(
											new TransitionCreationInformationContainer(
													null, oRegion,
													oInnerNode, oTransition));
								}
							}
						}
					}					
				}
			}
			
			// connections for default transitions (only from states without outgoing transitions)
			for(TestCaseRegion oRegion : oTCG.getRegions()) {
				List<TCGNode> colEndNodes = new ArrayList<TCGNode>();
				colEndNodes.addAll(TCGRegionHelperClass.findNodesWithOutOutgoingTransitions(oRegion));
				
				for(TCGTransition oTransition : in_oOuterNode.getOutgoingTransitions()) {
					// default transitions are only triggered from final states
					if(TCGTransitionHelperClass.transitionHasNoEventTrigger(oTransition)) {
						for(TCGNode oNode : colEndNodes) {
							colTransitionInformations.add(
									new TransitionCreationInformationContainer(
											null, oRegion,
											oNode, oTransition));
						}
					}
				}
			}
		}
		
		// add all the transitions for the collected information
		for(TransitionCreationInformationContainer oTrans : colTransitionInformations) {
			TCGTransition oNewTransition = 
				TCGTransitionHelperClass.
					createNewTransitionsBetweenNodeAndTransitionTarget(
							m_oTCGHelper, oTrans.m_oRegion, 
							oTrans.m_oNode, oTrans.m_oTransition);
			if(oTrans.m_colEventToDNF != null) {
				oNewTransition.getEvents().clear();
				oNewTransition.setPrecondition(null);
				for(Entry<TCGEvent, TCGDisjunctiveNormalForm> oEntry : oTrans.m_colEventToDNF.entrySet()) {
					oNewTransition.getEvents().add(oEntry.getKey());
					// TODO: each transition should hold a map of event to guard
					// instead of just separate event and guard 
					if(oNewTransition.getPrecondition() == null) {
						oNewTransition.setPrecondition(oEntry.getValue());
					}
				}
			}
		}
	}
	
	private void composeStatesOfRegionsInTestCaseGraph(TestCaseGraph in_oTCG)
	{
		// TODO implement!
	}
}
