package net.sf.parteg.base.testcasegraph.helperclasses;

import java.util.ArrayList;
import java.util.List;

import net.sf.parteg.base.testcasegraph.generated.TCGIntermediateNode;
import net.sf.parteg.base.testcasegraph.generated.TCGNode;
import net.sf.parteg.base.testcasegraph.generated.TCGNodeType;
import net.sf.parteg.base.testcasegraph.generated.TCGRealNode;
import net.sf.parteg.base.testcasegraph.generated.TCGTransition;
import net.sf.parteg.base.testcasegraph.generated.TestCaseRegion;

public class TCGRegionHelperClass {

	public static boolean regionsAreInHierarchicalOrder(
			TestCaseRegion in_oRegion1,
			TestCaseRegion in_oRegion2)
	{
		if(in_oRegion1.equals(in_oRegion2))
			return true;
		if(compareToUpperRegion(in_oRegion1, in_oRegion1, in_oRegion2) == true)
			return true;
		if(compareToUpperRegion(in_oRegion2, in_oRegion2, in_oRegion1) == true)
			return true;
		return false;
	}
	
	private static boolean compareToUpperRegion(
			TestCaseRegion in_oCurrent,
			TestCaseRegion in_oRegion1,
			TestCaseRegion in_oRegion2) {
		TCGRealNode oNode = in_oCurrent.getContainer().getCompositeSuperState();
		if(oNode != null) {
			TestCaseRegion oTmp = oNode.getContainer();
			if(oTmp.equals(in_oRegion2))
				return true;
			if(!oTmp.equals(in_oRegion1)) {
				if(compareToUpperRegion(oTmp, in_oRegion1, in_oRegion2) == true)
					return true;
			}
		}
		return false;
	}
	
	public static List<TCGIntermediateNode> findInitialNodes(TestCaseRegion in_oRegion)
	{
		List<TCGIntermediateNode> colRetList = new ArrayList<TCGIntermediateNode>();
		for(TCGNode oNode : in_oRegion.getNodes()) {
			if(oNode instanceof TCGIntermediateNode) {
				TCGIntermediateNode oIntNode = (TCGIntermediateNode)oNode;
				// initial node
				if(oIntNode.getNodeType().equals(TCGNodeType.INITIAL)) {
					colRetList.add(oIntNode);
					continue;
				}
			}
		}
		return colRetList;
	}
	
	public static List<TCGIntermediateNode> findEntryNodes(TestCaseRegion in_oRegion)
	{
		List<TCGIntermediateNode> colRetList = new ArrayList<TCGIntermediateNode>();
		for(TCGNode oNode : in_oRegion.getNodes()) {
			for(TCGTransition oTransition : oNode.getIncomingTransitions()) {
				TCGNode oSourceNode = oTransition.getSourceNode();
				if(oSourceNode instanceof TCGIntermediateNode) {
					TCGIntermediateNode oIntNode = (TCGIntermediateNode)oSourceNode;
					if(oIntNode.getNodeType().equals(TCGNodeType.ENTRY) 
							&& !oIntNode.getContainer().equals(in_oRegion)) {
						colRetList.add(oIntNode);
					}
				}
			}
		}
		return colRetList;
	}
	
	public static List<TCGIntermediateNode> findInitialAndEntryNodes(TestCaseRegion in_oRegion)
	{
		List<TCGIntermediateNode> colRetList = new ArrayList<TCGIntermediateNode>();
		colRetList.addAll(findInitialNodes(in_oRegion));
		colRetList.addAll(findEntryNodes(in_oRegion));
		return colRetList;
		
//		// collect connection points
//		List<TCGIntermediateNode> colTmpNodes = new ArrayList<TCGIntermediateNode>();
//		colTmpNodes.addAll(in_oRegion.getContainer().getContainedConnectionPoints());
//		TCGRealNode oSuperState = in_oRegion.getContainer().getCompositeSuperState();
//		if(oSuperState != null) {
//			colTmpNodes.addAll(oSuperState.getContainedConnectionPoints());
//		}
//		for(TCGIntermediateNode oIntNode : colTmpNodes) {
//			for(TCGTransition oTransition : oIntNode.getOutgoingTransitions()) {
//				TCGNode oNode = oTransition.getTargetNode();
//				if(oNode instanceof TCGIntermediateNode) 
//					... region mit parameter vergleichen
//			}
//		}
	}
	
	public static List<TCGNode> findNodesWithOutOutgoingTransitions(
			TestCaseRegion in_oRegion)
	{
		List<TCGNode> colRetList = new ArrayList<TCGNode>();
		for(TCGNode oNode : in_oRegion.getNodes()) {
			if(TCGNodeHelperClass.getAllOutgoingTransitionsPlusCPR(oNode).isEmpty()) {
				colRetList.add(oNode);
			}
		}
		return colRetList;
	}

	public static List<TCGIntermediateNode> findDecisionNodes(
			TestCaseRegion in_oRegion)
	{
		List<TCGIntermediateNode> colRetValues = new ArrayList<TCGIntermediateNode>();
		for(TCGNode oNode : in_oRegion.getNodes()) {
			if(oNode instanceof TCGIntermediateNode) {
				if(((TCGIntermediateNode)oNode).getNodeType().equals(TCGNodeType.DECISION))
					colRetValues.add((TCGIntermediateNode)oNode);
			}
		}
		return colRetValues;
	}
	
}
