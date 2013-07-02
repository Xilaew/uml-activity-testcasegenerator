package net.sf.parteg.base.testcasegraph.helperclasses;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.parteg.base.testcasegraph.generated.TCGIntermediateNode;
import net.sf.parteg.base.testcasegraph.generated.TCGNode;
import net.sf.parteg.base.testcasegraph.generated.TCGRealNode;
import net.sf.parteg.base.testcasegraph.generated.TCGTransition;
import net.sf.parteg.base.testcasegraph.generated.TestCaseGraph;
import net.sf.parteg.base.testcasegraph.generated.TestCaseRegion;
import net.sf.parteg.base.testcasegraph.ocl.TestCaseGraphHelper;

public class DecisionNodeSplitter {

	private TestCaseGraphHelper m_oTCGHelper; 
	
	public DecisionNodeSplitter(
			TestCaseGraphHelper in_oTCGHelper)
	{
		m_oTCGHelper = in_oTCGHelper;
	}
	
	public void splitNodes() throws Exception
	{
		splitNodes(m_oTCGHelper.getTestCaseGraph());
	}
	
	private void splitNodes(TestCaseGraph in_oTCG) throws Exception
	{
		for(TestCaseRegion oRegion : in_oTCG.getRegions()) {
			splitNodes(oRegion);
		}				
	}
	
	private void splitNodes(TestCaseRegion in_oRegion) throws Exception
	{
		List<TCGIntermediateNode> colIntermediateNodes =
			TCGRegionHelperClass.findDecisionNodes(in_oRegion);

		//for(TCGIntermediateNode oIntNode : colIntermediateNodes) {
		while(!colIntermediateNodes.isEmpty()) {
			TCGIntermediateNode oIntNode = colIntermediateNodes.get(0); 
			// split up decision nodes
			splitNodes(oIntNode, colIntermediateNodes);
			colIntermediateNodes.remove(oIntNode);
		}

		// recursion ...
		List<TCGNode> colNodes = new ArrayList<TCGNode>();
		colNodes.addAll(in_oRegion.getNodes());
		for(TCGNode oNode : colNodes) {
			if(oNode instanceof TCGRealNode) {
				TCGRealNode oRealNode = (TCGRealNode)oNode;
				TestCaseGraph oTCG = oRealNode.getSubGraph();
				if(oTCG == null)
					oTCG = oRealNode.getReferencedSubmachine();
				if(oTCG != null) {
					splitNodes(oTCG);
				}
			}
		}
	}
	
	private void splitNodes(
			TCGIntermediateNode in_oIntNode,
			List<TCGIntermediateNode> in_colOtherDecisionNodes) throws Exception
	{
		// get all incoming compound transitions
		List<List<TCGTransition>> colCompoundTransitions =
			TCGTransitionHelperClass.getIncomingCompoundTransition(in_oIntNode);
		
		// list of all visited target states - they are removed afterwards
		Set<TCGNode> colDispensableNodes = new HashSet<TCGNode>();

		List<Map<TCGNode, TCGNode>> colCompoundTransitionNodeCopies =
			new ArrayList<Map<TCGNode,TCGNode>>();
		Map<Map<TCGNode, TCGNode>, List<TCGTransition>> colTransitionsMarkedToCopy =
			new LinkedHashMap<Map<TCGNode,TCGNode>, List<TCGTransition>>();

		// create all the node copies for each compound transition
		for(List<TCGTransition> compoundTransition : colCompoundTransitions) {
			Map<TCGNode, TCGNode> colOriginalToCopy = new LinkedHashMap<TCGNode, TCGNode>(); 
			for(TCGTransition oCurrentTransition : compoundTransition) {
				TCGNode oNodeToDuplicate = oCurrentTransition.getTargetNode(); 
				
				// mark the visited target node
				colDispensableNodes.add(oNodeToDuplicate);
				
				// create a copy of the referenced target node
				TCGNode oCopy = TCGNodeHelperClass.copyNodeWithoutTransitions(
						m_oTCGHelper, oNodeToDuplicate);
				colOriginalToCopy.put(oNodeToDuplicate, oCopy);
				if(!oNodeToDuplicate.equals(in_oIntNode) &&
						in_colOtherDecisionNodes.contains(oNodeToDuplicate) &&
						oCopy instanceof TCGIntermediateNode) {
					in_colOtherDecisionNodes.add((TCGIntermediateNode)oCopy);
				}
			}
			colCompoundTransitionNodeCopies.add(colOriginalToCopy);

			// collect all the transitions to create copies for
			List<TCGTransition> colMarkedTransitions = new ArrayList<TCGTransition>();
			colTransitionsMarkedToCopy.put(colOriginalToCopy, colMarkedTransitions);
			// mark all transitions of the compound transition
			colTransitionsMarkedToCopy.get(colOriginalToCopy).addAll(compoundTransition);
			// if the set of incoming transitions does not contain a transition of the
			// found compound transition - then add all outgoing transitions
			for(TCGNode oOriginalNode : colOriginalToCopy.keySet()) {
				boolean bContainsElementOfCompound = false;
				for(TCGTransition oOutgoingTransition : oOriginalNode.getOutgoingTransitions()) {
					if(compoundTransition.contains(oOutgoingTransition))
						bContainsElementOfCompound = true;
				}
				if(bContainsElementOfCompound == false)
					colTransitionsMarkedToCopy.get(colOriginalToCopy).addAll(
							oOriginalNode.getOutgoingTransitions());
//				for(TCGTransition oIncomingTransition : oOriginalNode.getIncomingTransitions()) {
//					colTransitionsMarkedToCopy.get(colOriginalToCopy).add(oIncomingTransition);
//				}
			}
		}
		
		// create the transition copies
		for(Map<TCGNode, TCGNode> colOriginalToCopy : colCompoundTransitionNodeCopies) {
			for(TCGNode oOriginalNode : colOriginalToCopy.keySet()) {
				// copy all outgoing transitions
				for(TCGTransition oOutgoingTransition : oOriginalNode.getOutgoingTransitions()) {
					if(colTransitionsMarkedToCopy.get(colOriginalToCopy).contains(oOutgoingTransition)) {
						TCGNode oTargetNode = colOriginalToCopy.get(oOutgoingTransition.getTargetNode());
						if(oTargetNode == null)
							oTargetNode = oOutgoingTransition.getTargetNode();
						TCGTransitionHelperClass.copyTransitionValuesToNewTransition(
								m_oTCGHelper, oOutgoingTransition, 
								colOriginalToCopy.get(oOriginalNode), oTargetNode);
					}
				}
				// copy all triggered or referenced incoming transitions
				for(TCGTransition oIncomingTransition : oOriginalNode.getIncomingTransitions()) {
					//if(!TCGTransitionHelperClass.transitionHasNoEventTrigger(oIncomingTransition) ||
					if(colTransitionsMarkedToCopy.get(colOriginalToCopy).contains(oIncomingTransition)) {
						TCGTransitionHelperClass.copyTransitionValuesToNewTransition(
								m_oTCGHelper, oIncomingTransition, 
								oIncomingTransition.getSourceNode(), colOriginalToCopy.get(oOriginalNode));
					}
				}
			}			
		}
//			
//			// copy all the transitions on the node copies
//			for(TCGTransition oCurrentTransition : compoundTransition) {
//				
//				// copy all outgoing transitions
//				for(TCGTransition oOutgoingTransition : oNodeToDuplicate.getOutgoingTransitions()) {
//					TCGTransitionHelperClass.copyTransitionValuesToNewTransition(
//							m_oTCGHelper, oOutgoingTransition, 
//							oCopy, oOutgoingTransition.getTargetNode());
//				}
//				
//				// copy all triggered incoming transitions
//				for(TCGTransition oIncomingTransition : oNodeToDuplicate.getIncomingTransitions()) {
//					if(!TCGTransitionHelperClass.transitionHasNoEventTrigger(oIncomingTransition)) {
//						TCGTransitionHelperClass.copyTransitionValuesToNewTransition(
//								m_oTCGHelper, oIncomingTransition, 
//								oIncomingTransition.getSourceNode(), oCopy);
//					}
//				}
//				
//				// copy the current transition if it is not triggered
//				if(TCGTransitionHelperClass.transitionHasNoEventTrigger(oCurrentTransition)) {
//					TCGTransitionHelperClass.copyTransitionValuesToNewTransition(
//							m_oTCGHelper, oCurrentTransition, 
//							oCurrentTransition.getSourceNode(), oCopy);
//				}				
//			}
//		}
		
		// remove all the copied nodes 
		for(TCGNode oDispensableNode : colDispensableNodes) {
			m_oTCGHelper.removeNode(oDispensableNode);
		}
	}
	
		
		
		
//		for(TCGTransition oIncomingTransition : in_oIntNode.getIncomingTransitions()) {
//			
//			// copy decision node
//			TCGIntermediateNode oNewNode =
//				m_oTCGHelper.addIntermediateNode(
//						TCGNodeHelperClass.getContainingRegion(in_oIntNode));
//			oNewNode.setName(in_oIntNode.getName());
//			oNewNode.setOriginalNode(in_oIntNode.getOriginalNode());
//			oNewNode.setNodeType(in_oIntNode.getNodeType());
//
//			// copy first transition
//			TCGNode oSourceNode = oIncomingTransition.getSourceNode();
//			TCGTransition oTCGTransition1 = 
//				m_oTCGHelper.addTransition(oSourceNode, oNewNode);
//			oTCGTransition1.getEvents().addAll(oIncomingTransition.getEvents());
//			oTCGTransition1.setPrecondition(
//					TCGDisjunctiveNormalFormHelperClass.copyDNFDeep(
//							oIncomingTransition.getPrecondition()));
//			oTCGTransition1.setPostcondition(
//					TCGDisjunctiveNormalFormHelperClass.copyDNFDeep(
//							oIncomingTransition.getPostcondition()));
//			oTCGTransition1.setCanBeProcessed(oIncomingTransition.isCanBeProcessed());
//			
//			// copy incoming compound transitions
//
//			// for each outgoing transition: add one outgoing transition to the new decision node 
//			for(TCGTransition oOutgoingTransition : in_oIntNode.getOutgoingTransitions()) {
//				TCGNode oTargetNode = oOutgoingTransition.getTargetNode();
//				TCGTransition oTCGTransition2 = 
//					m_oTCGHelper.addTransition(oNewNode, oTargetNode);
//				oTCGTransition2.getEvents().addAll(oOutgoingTransition.getEvents());
//				oTCGTransition2.setPrecondition(
//						TCGDisjunctiveNormalFormHelperClass.copyDNFDeep(
//								oOutgoingTransition.getPrecondition()));
//				oTCGTransition2.setPostcondition(
//						TCGDisjunctiveNormalFormHelperClass.copyDNFDeep(
//								oOutgoingTransition.getPostcondition()));
//				oTCGTransition2.setCanBeProcessed(oOutgoingTransition.isCanBeProcessed());				
//			}
//		}
//	}
}
