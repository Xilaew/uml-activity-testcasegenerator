package net.sf.parteg.base.testcasegraph.helperclasses;

import java.util.ArrayList;
import java.util.List;

import net.sf.parteg.base.testcasegraph.generated.TCGIntermediateNode;
import net.sf.parteg.base.testcasegraph.generated.TCGNode;
import net.sf.parteg.base.testcasegraph.generated.TCGNodeType;
import net.sf.parteg.base.testcasegraph.generated.TCGRealNode;
import net.sf.parteg.base.testcasegraph.generated.TCGTransition;
import net.sf.parteg.base.testcasegraph.generated.TestCaseGraph;
import net.sf.parteg.base.testcasegraph.generated.TestCaseRegion;

public class BasicDistanceSetter {

	private TestCaseGraph m_oTCG;
	
	public BasicDistanceSetter(TestCaseGraph in_oTestCaseGraph)
	{
		m_oTCG = in_oTestCaseGraph;
	}
	
	// iterates over all elements and counts...
	public void act()
	{
		// the codes of both search routines are alike ... hope for performance benefit 
		
		for(TestCaseRegion oRegion : m_oTCG.getRegions()) {
			searchForMinDistanceInRegion(oRegion, 0);
		}
		
		List<TCGNode> colVisitedNodes = new ArrayList<TCGNode>();
		for(TestCaseRegion oRegion : m_oTCG.getRegions()) {
			searchForMaxDistanceInRegion(oRegion, 0, colVisitedNodes);
		}

		
	}
	
	private int searchForMinDistanceInRegion(TestCaseRegion in_oRegion, int in_nInitialCounter)
	{
		// find initial node or init pseudo states
		List<TCGIntermediateNode> colInitialNodes = 
			TCGRegionHelperClass.findInitialAndEntryNodes(in_oRegion);
		
		int nCounter = 0;
		// depth-first search
		for(TCGNode oNode : colInitialNodes) {
			if(oNode.getMinDistanceFromStart() == -1)
				oNode.setMinDistanceFromStart(in_nInitialCounter);
			
			for(TCGTransition oTransition : oNode.getOutgoingTransitions()) {
				int nCurrentCounter = searchForMinDistanceFromNode(
						oTransition.getTargetNode(), in_nInitialCounter + 1);
				if(nCurrentCounter > nCounter)
					nCounter = nCurrentCounter;
			}
		}

		// count ... and return the current counter for the outer regions 
		return nCounter;
	}
	
	private int searchForMinDistanceFromNode(
			TCGNode in_oNode, 
			int in_nCounter) 
	{
		if(in_oNode.getMinDistanceFromStart() != -1 && 
				in_oNode.getMinDistanceFromStart() < in_nCounter)
			return in_nCounter;
		
		int nMaxCounter = 0;
		in_oNode.setMinDistanceFromStart(in_nCounter);
		
		if(in_oNode instanceof TCGIntermediateNode) {
			TCGIntermediateNode oIntNode = (TCGIntermediateNode)in_oNode;
			if(oIntNode.getNodeType().equals(TCGNodeType.ENTRY)) {
				// determining the super state
				TCGRealNode oSuperNode = null;
				if(oIntNode.getContainer() instanceof TCGRealNode)
					oSuperNode = (TCGRealNode)oIntNode.getContainer();
				else if(oIntNode.getContainer() instanceof TestCaseRegion) {
					TestCaseRegion oRegion = (TestCaseRegion)oIntNode.getContainer();
					if(oRegion.getContainer() != null)
						oSuperNode = (TCGRealNode)oRegion.getContainer().getCompositeSuperState();
				}
				int nRealNodeCounter = searchForMinDistanceFromNode(
						oSuperNode, in_nCounter);
				return Math.max(in_nCounter, nRealNodeCounter);
			}
			// stop at exit nodes
			if(oIntNode.getNodeType().equals(TCGNodeType.EXIT)) {
				return in_nCounter + 1;
			}
		}
		// in_oNode could have changed value
		if(in_oNode instanceof TCGRealNode) {
			TCGRealNode oRealNode = (TCGRealNode)in_oNode;
			TestCaseGraph oSubGraph = oRealNode.getSubGraph();
			if(oSubGraph != null) {
				for(TestCaseRegion oRegion : oSubGraph.getRegions()) {
					int nRegionCounter = searchForMinDistanceInRegion(
							oRegion, in_nCounter);
					if(nRegionCounter > nMaxCounter)
						nMaxCounter = nRegionCounter;
				}
			}
				
			TestCaseGraph oRefSubGraph = oRealNode.getReferencedSubmachine();
			if(oRefSubGraph != null) {
				System.err.println("BasicDistanceSetter does not support referenced submachines");
			}
		}
		
		// collect outgoing transitions of the node it self and of all its exit nodes
		List<TCGTransition> colOutTransitions = new ArrayList<TCGTransition>();
		colOutTransitions.addAll(in_oNode.getOutgoingTransitions());
		if(in_oNode instanceof TCGRealNode) {
			for(TCGIntermediateNode oSubNode : ((TCGRealNode)in_oNode).getContainedConnectionPoints()) {
				if(oSubNode.getNodeType().equals(TCGNodeType.EXIT))
					colOutTransitions.addAll(oSubNode.getOutgoingTransitions());
			}
		}
		
		for(TCGTransition oTrans : colOutTransitions) {
			int nCurrentCounter = searchForMinDistanceFromNode(
					oTrans.getTargetNode(), in_nCounter + 1);
			if(nCurrentCounter > nMaxCounter)
				nMaxCounter = nCurrentCounter;
		}
		
		// return max value
		return nMaxCounter;
	}
	
	private int searchForMaxDistanceInRegion(
			TestCaseRegion in_oRegion, 
			int in_nInitialCounter,
			List<TCGNode> in_colVisitedNodes)
	{
		// find initial node or init pseudo states
		List<TCGIntermediateNode> colInitialNodes = TCGRegionHelperClass.findInitialAndEntryNodes(in_oRegion);
		
		int nCounter = 0;
		// depth-first search
		for(TCGNode oNode : colInitialNodes) {
			if(oNode.getMaxDistanceFromStart() == -1)
				oNode.setMaxDistanceFromStart(in_nInitialCounter);
			
			for(TCGTransition oTransition : oNode.getOutgoingTransitions()) {
				int nCurrentCounter = searchForMaxDistanceFromNode(
						oTransition.getTargetNode(), in_nInitialCounter + 1,
						in_colVisitedNodes);
				if(nCurrentCounter > nCounter)
					nCounter = nCurrentCounter;
			}
		}

		// count ... and return the current counter for the outer regions 
		return nCounter;
	}
	
	private int searchForMaxDistanceFromNode(
			TCGNode in_oNode, 
			int in_nCounter,
			List<TCGNode> in_colVisitedNodes) 
	{
		if(in_colVisitedNodes.contains(in_oNode) ||
				(in_oNode.getMaxDistanceFromStart() != -1 && 
						in_oNode.getMaxDistanceFromStart() > in_nCounter))
			return in_nCounter;
	
		int nMaxCounter = 0;
		in_oNode.setMaxDistanceFromStart(in_nCounter);
		in_colVisitedNodes.add(in_oNode);
		
		if(in_oNode instanceof TCGIntermediateNode) {
			TCGIntermediateNode oIntNode = (TCGIntermediateNode)in_oNode;
			if(oIntNode.getNodeType().equals(TCGNodeType.ENTRY)) {
				int nRealNodeCounter = searchForMaxDistanceFromNode(
						(TCGRealNode)oIntNode.getContainer(), in_nCounter,
						in_colVisitedNodes);
				in_colVisitedNodes.remove(in_oNode);
				return Math.max(in_nCounter, nRealNodeCounter);
			}
			// stop at exit nodes
			if(oIntNode.getNodeType().equals(TCGNodeType.EXIT)) {
				in_colVisitedNodes.remove(in_oNode);
				return in_nCounter + 1;
			}
		}
		// in_oNode could have changed value
		if(in_oNode instanceof TCGRealNode) {
			TCGRealNode oRealNode = (TCGRealNode)in_oNode;
			TestCaseGraph oSubGraph = oRealNode.getSubGraph();
			if(oSubGraph != null) {
				for(TestCaseRegion oRegion : oSubGraph.getRegions()) {
					int nRegionCounter = searchForMaxDistanceInRegion(
							oRegion, in_nCounter, in_colVisitedNodes);
					if(nRegionCounter > nMaxCounter)
						nMaxCounter = nRegionCounter;
				}
			}
				
			TestCaseGraph oRefSubGraph = oRealNode.getReferencedSubmachine();
			if(oRefSubGraph != null) {
				System.err.println("BasicDistanceSetter does not support referenced submachines");
			}
		}
		
		// collect outgoing transitions of the node it self and of all its exit nodes
		List<TCGTransition> colOutTransitions = new ArrayList<TCGTransition>();
		colOutTransitions.addAll(in_oNode.getOutgoingTransitions());
		if(in_oNode instanceof TCGRealNode) {
			for(TCGIntermediateNode oSubNode : ((TCGRealNode)in_oNode).getContainedConnectionPoints()) {
				if(oSubNode.getNodeType().equals(TCGNodeType.EXIT))
					colOutTransitions.addAll(oSubNode.getOutgoingTransitions());
			}
		}
		
		if(in_nCounter < nMaxCounter)
			in_nCounter = nMaxCounter;
		
		for(TCGTransition oTrans : colOutTransitions) {
			int nCurrentCounter = searchForMaxDistanceFromNode(
					oTrans.getTargetNode(), in_nCounter + 1,
					in_colVisitedNodes);
			if(nCurrentCounter > nMaxCounter)
				nMaxCounter = nCurrentCounter;
		}
		
		in_colVisitedNodes.remove(in_oNode);
		
		// return max value
		return nMaxCounter;
	}
	
//	private int searchForMaxDistanceInRegion(TestCaseRegion in_oRegion, 
//			int in_nInitialCounter,
//			List<TCGNode> in_colVisitedNodes)
//	{
//		// find initial node or init pseudo states
//		List<TCGIntermediateNode> colInitialNodes = TCGRegionHelperClass.findInitialAndEntryNodes(in_oRegion);
//		
//		int nCounter = 0;
//		// depth-first search
//		for(TCGNode oNode : colInitialNodes) {
//			int nCurrentCounter = searchForMaxDistanceFromNode(
//					oNode, in_nInitialCounter, in_colVisitedNodes);
//			if(nCurrentCounter < nCounter)
//				nCounter = nCurrentCounter;
//		}
//
//		// count ... and return the current counter for the outer regions 
//		return nCounter;
//	}
//	
//	private int searchForMaxDistanceFromNode(
//			TCGNode in_oNode, 
//			int in_nCounter,
//			List<TCGNode> in_colVisitedNodes)
//	{
//		if(in_colVisitedNodes.contains(in_oNode) ||
//				(in_oNode.getMaxDistanceFromStart() != -1 && 
//						in_oNode.getMaxDistanceFromStart() > in_nCounter))
//			return in_nCounter;
//			
//		int nMaxCounter = 0;
//		in_oNode.setMaxDistanceFromStart(in_nCounter);
//		in_colVisitedNodes.add(in_oNode);
//		
//		// collect outgoing transitions of the node it self and of all its exit nodes
//		List<TCGTransition> colOutTransitions = new ArrayList<TCGTransition>();
//		colOutTransitions.addAll(in_oNode.getOutgoingTransitions());
//		if(in_oNode instanceof TCGRealNode) {
//			for(TCGIntermediateNode oSubNode : ((TCGRealNode)in_oNode).getContainedConnectionPoints()) {
//				if(oSubNode.getNodeType().equals(TCGNodeType.EXIT))
//					colOutTransitions.addAll(oSubNode.getOutgoingTransitions());
//			}
//		}
//		
//		for(TCGTransition oTrans : colOutTransitions) {
//			int nCounter = in_nCounter;
//			TCGNode oTargetNode = oTrans.getTargetNode();
//			if(oTargetNode instanceof TCGIntermediateNode) {
//				TCGIntermediateNode oIntNode = (TCGIntermediateNode)oTargetNode;
//				if(oIntNode.getNodeType().equals(TCGNodeType.ENTRY)) {
//					oIntNode.setMaxDistanceFromStart(nCounter + 1);
//					oTargetNode = (TCGRealNode)oIntNode.getContainer();
//				}
//				// stop at exit nodes
//				if(oIntNode.getNodeType().equals(TCGNodeType.EXIT)) {
//					oIntNode.setMaxDistanceFromStart(nCounter + 1);
//					continue;
//				}
//
//			}
//			if(oTargetNode instanceof TCGRealNode) {
//				TCGRealNode oRealNode = (TCGRealNode)oTargetNode;
//				TestCaseGraph oSubGraph = oRealNode.getSubGraph();
//				if(oSubGraph != null) {
//					for(TestCaseRegion oRegion : oSubGraph.getRegions()) {
//						int nRegionCounter = searchForMaxDistanceInRegion(
//								oRegion, in_nCounter + 1, in_colVisitedNodes);
//						if(nRegionCounter > nCounter)
//							nCounter = nRegionCounter;
//					}
//					
//					// do not forget the exit nodes -> continue searching from them
//					for(TCGIntermediateNode oExitNode : oRealNode.getContainedConnectionPoints()) {
//						if(oExitNode.getNodeType().equals(TCGNodeType.EXIT)) {
//							int nCurrentCounter = searchForMaxDistanceFromNode(
//									oExitNode, ++nCounter, in_colVisitedNodes);
//							if(nCurrentCounter > nMaxCounter)
//								nMaxCounter = nCurrentCounter;							
//						}
//					}
//				}
//					
//				TestCaseGraph oRefSubGraph = oRealNode.getReferencedSubmachine();
//				if(oRefSubGraph != null) {
//					System.err.println("BasicDistanceSetter does not support referenced submachines");
//				}
//			}
//			if(nCounter < nMaxCounter)
//				nCounter = nMaxCounter;
//			int nCurrentCounter = searchForMaxDistanceFromNode(
//					oTargetNode, ++nCounter, in_colVisitedNodes);
//			if(nCurrentCounter > nMaxCounter)
//				nMaxCounter = nCurrentCounter;
//		}
//		
//		in_colVisitedNodes.remove(in_oNode);
//		
//		// return max value
//		return nMaxCounter;			
//	}

	
	// check if the minDistance of all nodes has been set and
	// write to System.err otherwise ...
	public void check() {
		checkTCG(m_oTCG);
	}
	
	private void checkTCG(TestCaseGraph in_oTCG) 
	{
		for(TestCaseRegion oRegion : in_oTCG.getRegions()) {
			checkRegion(oRegion);
		}
		for(TCGNode oNode : in_oTCG.getContainedConnectionPoints()) {
			checkNode(oNode);
		}			
	}
	
	private void checkRegion(TestCaseRegion in_oRegion) 
	{
		for(TCGNode oNode : in_oRegion.getNodes()) {
			checkNode(oNode);
		}
	}
	
	private void checkNode(TCGNode in_oNode) {
//		System.out.println(
//				"minDist=" + in_oNode.getMinDistanceFromStart()
//				+ "maxDist=" + in_oNode.getMaxDistanceFromStart()
//				+ " for node >" + in_oNode.getName() + "<");
		
		if(in_oNode.getMinDistanceFromStart() == -1) {
			System.err.println("min distance == -1 for node >"
					+ in_oNode.getName() + "<");
		}
		if(in_oNode.getMaxDistanceFromStart() == -1) {
			System.err.println("max distance == -1 for node >"
					+ in_oNode.getName() + "<");
		}
		if(in_oNode.getMinDistanceFromStart() > in_oNode.getMaxDistanceFromStart()) {
			System.err.println("min distance ("
					+ in_oNode.getMinDistanceFromStart()
					+ ") is higher than max distance ("
					+ in_oNode.getMaxDistanceFromStart() 
					+ ") for node >"
					+ in_oNode.getName() + "<");
		}
		if(in_oNode instanceof TCGRealNode) {
			TCGRealNode oRealNode = (TCGRealNode)in_oNode;
			List<TCGNode> colNodes = new ArrayList<TCGNode>();
			colNodes.addAll(oRealNode.getContainedConnectionPoints());
			colNodes.addAll(oRealNode.getContainedConnectionPointReferences());
			for(TCGNode oNode : colNodes) {
				checkNode(oNode);
			}
			if(oRealNode.getSubGraph() != null)
				checkTCG(oRealNode.getSubGraph());
			if(oRealNode.getReferencedSubmachine() != null)
				checkTCG(oRealNode.getReferencedSubmachine());
		}
	}
}
