package net.sf.parteg.base.testcasegraph.helperclasses;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import net.sf.parteg.base.testcasegraph.config.Configuration;
import net.sf.parteg.base.testcasegraph.config.ConfigurationTestPathSearchStrategy;
import net.sf.parteg.base.testcasegraph.generated.TCGEvent;
import net.sf.parteg.base.testcasegraph.generated.TCGIntermediateNode;
import net.sf.parteg.base.testcasegraph.generated.TCGNode;
import net.sf.parteg.base.testcasegraph.generated.TCGNodeType;
import net.sf.parteg.base.testcasegraph.generated.TCGRealNode;
import net.sf.parteg.base.testcasegraph.generated.TCGTransition;
import net.sf.parteg.base.testcasegraph.generated.TestCaseGraph;
import net.sf.parteg.base.testcasegraph.generated.TestCaseRegion;
import net.sf.parteg.base.testcasegraph.ocl.TestCaseGraphHelper;
import net.sf.parteg.core.structures.ObjectComparator;

import org.eclipse.uml2.uml.State;

public class TCGNodeHelperClass {

	public static List<TCGIntermediateNode> getInitialNodesOfState(TCGNode in_oCompositeNode) {
		List<TCGIntermediateNode> colIntNodes = new ArrayList<TCGIntermediateNode>();
		
		if(in_oCompositeNode instanceof TCGRealNode) {
			TCGRealNode oRealNode = (TCGRealNode)in_oCompositeNode;
			TestCaseGraph oSubGraph = oRealNode.getSubGraph();
			if(oSubGraph != null) {
				for(TestCaseRegion oRegion : oSubGraph.getRegions()) {
					for(TCGNode oNode : oRegion.getNodes()) {
						if(oNode instanceof TCGIntermediateNode) {
							TCGIntermediateNode oIntMedNode = (TCGIntermediateNode)oNode;
							if(oIntMedNode.getNodeType().equals(TCGNodeType.INITIAL)) {
								colIntNodes.add(oIntMedNode);
							}
						}
					}
				}
			}
		}
		return colIntNodes;
	}
	
	public static boolean firstNodeIsSubStateOfOrEqualToSecondNode(
			TCGNode in_oFirstNode, TCGNode in_oSecondNode) {
		
		return (in_oFirstNode.equals(in_oSecondNode)) ||
			firstNodeIsSubStateOfSecondNode(in_oFirstNode, in_oSecondNode);
	}

	
	public static boolean firstNodeIsSubStateOfSecondNode(
			TCGNode in_oFirstNode, TCGNode in_oSecondNode) {
		
		List<TCGNode> colTmpNodes = new ArrayList<TCGNode>();  
		TCGNode oTmpNode = TCGNodeHelperClass.getSuperState(in_oFirstNode);
		if(oTmpNode != null)
		colTmpNodes.add(oTmpNode);
		while(!colTmpNodes.isEmpty())
		{
			List<TCGNode> colTmpSuperNodes = new ArrayList<TCGNode>();
			for(TCGNode oNode : colTmpNodes)
			{
				if(oNode.equals(in_oSecondNode))
					return true;
				TCGNode oSuperNode = TCGNodeHelperClass.getSuperState(oNode);
				if(oSuperNode != null && !colTmpNodes.contains(oSuperNode)) {
					colTmpSuperNodes.add(oSuperNode);
				}
			}
			colTmpNodes = colTmpSuperNodes;
		}
		return false;
	}
	
	public static boolean nodeHasOutgoingTransitionTriggeredByEvent(
			TCGNode in_oNode, TCGEvent in_oEvent)
	{
		for(TCGTransition oTransition : in_oNode.getOutgoingTransitions())
		{
			for(TCGEvent oEvent : oTransition.getEvents()) {
				if((!oEvent.isDefaultEvent()) && (oEvent.equals(in_oEvent)))
					return true;
			}
		}
		return false;
	}
	
	// returns all transitions that are leading to this node (also via connection points, ...)
	public static List<TCGTransition> getAllIncomingTransitionsPlusCPR(TCGNode in_oNode)
	{
		List<TCGTransition> colRetValues = getIncomingTransitions(in_oNode);
		if(in_oNode instanceof TCGRealNode) {
			TCGRealNode oRealNode = (TCGRealNode)in_oNode;
			for(TCGIntermediateNode oConnectionPoint : oRealNode.getContainedConnectionPoints()) {
				if(oConnectionPoint.getNodeType().equals(TCGNodeType.ENTRY))
					colRetValues.addAll(oConnectionPoint.getIncomingTransitions());
			}
		}		
		
		return colRetValues;
	}

	// returns all transitions that are leaving from this node (also via connection points, ...)
	public static List<TCGTransition> getAllOutgoingTransitionsPlusCPR(TCGNode in_oNode)
	{
		List<TCGTransition> colRetValues = getOutgoingTransitions(in_oNode);
		if(in_oNode instanceof TCGRealNode) {
			TCGRealNode oRealNode = (TCGRealNode)in_oNode;
			for(TCGIntermediateNode oConnectionPoint : oRealNode.getContainedConnectionPoints()) {
				if(oConnectionPoint.getNodeType().equals(TCGNodeType.EXIT))
					colRetValues.addAll(oConnectionPoint.getIncomingTransitions());
			}
		}		
		
		return colRetValues;
	}

	
	public static List<TCGTransition> getIncomingTransitions(TCGNode in_oNode)
	{
		if(in_oNode instanceof TCGIntermediateNode &&
				((TCGIntermediateNode)in_oNode).getNodeType().equals(TCGNodeType.INITIAL)) {
			List<TCGTransition> colRetValues = new ArrayList<TCGTransition>();
			TCGIntermediateNode oNode = (TCGIntermediateNode)in_oNode;
			if(oNode.getNodeType().equals(TCGNodeType.INITIAL)) {
				
				TCGRealNode oSuperNode = getSuperState(oNode);
				if(oSuperNode != null) {
					colRetValues.addAll(oSuperNode.getIncomingTransitions());
				}
				else if(in_oNode instanceof TCGIntermediateNode) {
					for(TCGIntermediateNode oIntNode : ((TCGIntermediateNode)in_oNode).getReferencedConnectionPointReferences()) {
						colRetValues.addAll(oIntNode.getIncomingTransitions());
					}
				}
			}
			return colRetValues;
		} 
		else
			return in_oNode.getIncomingTransitions();
	}
	
	
	public static List<TCGTransition> getOutgoingTransitions(TCGNode in_oNode)
	{
		List<TCGTransition> colRetValues = new ArrayList<TCGTransition>();
		
		// add the outgoing transitions directly connected to the node
		colRetValues.addAll(in_oNode.getOutgoingTransitions());
		
		// add transitions of super states if they are triggered by a real event
		// if they are default-triggered then just add if node has no outgoing transitions
		if(in_oNode instanceof TCGRealNode) {
			TCGRealNode oNode = (TCGRealNode)in_oNode;
			boolean bNodeHasNoOutgoingTransitions = in_oNode.getOutgoingTransitions().isEmpty();
			
			// all super states (hierarchical)
			for(TCGRealNode oSuperNode : getSuperStates(oNode)) {
				for(TCGTransition oTransition : oSuperNode.getOutgoingTransitions()) {
					boolean bAllEventsAreDefault = true;
					
					for(TCGEvent oEvent : oTransition.getEvents()) {
						if(!oEvent.isDefaultEvent())
							bAllEventsAreDefault = false;
					}
					if(bAllEventsAreDefault) {
						if(bNodeHasNoOutgoingTransitions) 
							colRetValues.add(oTransition);
					}
					else
						colRetValues.add(oTransition);
				}
			}
		}
		
		// add connection point references
		else if(in_oNode instanceof TCGIntermediateNode) {
			for(TCGIntermediateNode oIntNode : ((TCGIntermediateNode)in_oNode).getReferencedConnectionPointReferences()) {
				colRetValues.addAll(oIntNode.getOutgoingTransitions());
			}
		}
		return colRetValues;
	}
		
	public static TestCaseGraph getContainingTestGraph(TCGNode in_oNode) {
		if(in_oNode instanceof TCGRealNode) {
			return ((TCGRealNode)in_oNode).getContainer().getContainer();
		}
		else {
			TCGIntermediateNode oNode = (TCGIntermediateNode)in_oNode;
			if(oNode == null) {
			}
			if(oNode.getContainer() instanceof TestCaseGraph) {
				return ((TestCaseGraph)oNode.getContainer());
			}
			else if(oNode.getContainer() instanceof TestCaseRegion) {
				return ((TestCaseRegion)oNode.getContainer()).getContainer();
			}
			else if(oNode.getContainer() instanceof TCGRealNode) {
				return ((TCGRealNode)oNode.getContainer()).getContainer().getContainer();
			}
		}
		return null;
	}
		
	public static TCGRealNode getSuperState(TCGNode in_oNode) {
		TestCaseGraph oTCG = getContainingTestGraph(in_oNode);
		if(oTCG != null)
			return oTCG.getCompositeSuperState();
		return null;
	}
	
	public static List<TCGRealNode> getSuperStates(TCGNode in_oNode) {
	
		List<TCGRealNode> colSuperStates = new ArrayList<TCGRealNode>();
		TCGRealNode oSuperNode = getSuperState(in_oNode);
		while(oSuperNode != null) {
			colSuperStates.add(0, oSuperNode);
			oSuperNode = getSuperState(oSuperNode);
		}
		return colSuperStates;
	}
		
	public static List<TCGNode> getAllSuperStatesIncludingThis(TCGNode in_oNode) 
	{
		List<TCGNode> colRetNodes = new ArrayList<TCGNode>();
		colRetNodes.addAll(getSuperStates(in_oNode));
		colRetNodes.add(in_oNode);
		// list is now from upper most node to lower most
		// -> reverse if inner nodes have priority
		if(Configuration.isInnerTransitionHasPriorityOverOuterTransition()) {
			Collections.reverse(colRetNodes);
		}
		return colRetNodes;
	}
		
	public static TestCaseRegion getContainingRegion(TCGNode in_oNode) {
		if(in_oNode instanceof TCGRealNode) {
			return ((TCGRealNode)in_oNode).getContainer();
		}
		else {
			TCGIntermediateNode oNode = (TCGIntermediateNode)in_oNode;
			if(oNode == null) {
			}
			if(oNode.getContainer() instanceof TestCaseGraph) {
				TCGRealNode oRetNode = ((TestCaseGraph)oNode.getContainer()).getCompositeSuperState();
				if(oRetNode != null)
					return oRetNode.getContainer();
			}
			else if(oNode.getContainer() instanceof TestCaseRegion) {
				return ((TestCaseRegion)oNode.getContainer());
			}
			else if(oNode.getContainer() instanceof TCGRealNode) {
				return ((TCGRealNode)oNode.getContainer()).getContainer();
			}
		}
		return null;
		
	}
	
	public static List<TCGNode> getPossibleSubNodes(
			TCGNode in_oNode,
			List<TCGEvent> in_colEvents) 
	{
		List<TCGNode> colSearchNodes = new ArrayList<TCGNode>();
		List<TCGNode> colSearchNewNodes = new ArrayList<TCGNode>();
		List<TCGNode> colRetNodes = new ArrayList<TCGNode>();
		
		boolean searchOnlyForEndNodes = false;
		if(in_colEvents.isEmpty())
			searchOnlyForEndNodes = true;
		else {
			for(TCGEvent oEvent : in_colEvents)
				if(oEvent.isDefaultEvent())
					searchOnlyForEndNodes = true;
		}
		
		colSearchNewNodes.add(in_oNode);
		if(nodeHasNoSubNodes(in_oNode))
			colRetNodes.add(in_oNode); // add to return value
		
		boolean bAddedNewElement = true;
		while(bAddedNewElement == true)
		{
			bAddedNewElement = false;
			List<TCGNode> colSearchNewestNodes = new ArrayList<TCGNode>();
			
			for(TCGNode oNode : colSearchNewNodes)
			{
				// check composite states
				if(oNode instanceof TCGRealNode) {
					TestCaseGraph oSubGraph = ((TCGRealNode)oNode).getSubGraph();
					if(oSubGraph != null)
					{
						for(TestCaseRegion oRegion : oSubGraph.getRegions())
						{
							// TODO Parallelität beachten !!! -> Knotenkombinationen!
							for(TCGNode oSubNode : oRegion.getNodes())
							{
//							if((!TCGNodeHelperClass.
//									nodeHasOutgoingTransitionTrigeredByEvent(
//											oSubNode, in_oEvent))
								if (oSubNode.getOriginalNode() instanceof State)
								{
									// only add the element if the input parameter events can be triggered from this node
									boolean bAddElement = 
										((searchOnlyForEndNodes == true && oSubNode.getOutgoingTransitions().isEmpty()) ||
										searchOnlyForEndNodes == false);
									// just return the nodes without any subnodes - search in the remaining nodes
									if(bAddElement) {
										if(nodeHasNoSubNodes(oSubNode))
											colRetNodes.add(oSubNode);	
										else 
											colSearchNewestNodes.add(oSubNode);
									}
	
									bAddedNewElement = true;
								}
							}
						}
					}
				}				
			}
			colSearchNodes.addAll(colSearchNewNodes);
			colSearchNewNodes = colSearchNewestNodes;
		}
		
//		// until now, the upper nodes are first
//		if(Configuration.getSearchInDeeperNodesFirst()) {
//			Collections.reverse(colRetNodes);
//		}
		return colRetNodes;
	}

	
	public static boolean nodeHasNoSubNodes(TCGNode in_oNode) {
		if(in_oNode instanceof TCGRealNode) {
			TCGRealNode oRN = (TCGRealNode)in_oNode;
			return oRN.getSubGraph() == null && oRN.getContainedConnectionPointReferences().isEmpty();
		}
		return true;
	}
	
	public static List<TCGNode> getAllSuperNodes(TCGNode in_oNode) 
	{
		List<TCGNode> out_colNodes = new ArrayList<TCGNode>();
		int nOldSize = -1;
		int nNewSize = 0;
		
		while(nNewSize != nOldSize) {
			nOldSize = nNewSize;
			TestCaseGraph oTCG = getContainingTestGraph(in_oNode);
			if(oTCG != null) {
				
				// check all super states
				TCGNode oNode = oTCG.getCompositeSuperState();
				if(!out_colNodes.contains(oNode) && oNode != null)
					out_colNodes.add(oNode);
				
				// check for referenced states (via connectionpointreferences)
				for(TCGIntermediateNode oConnectionNode : oTCG.getContainedConnectionPoints()) {
					for(TCGNode oConnectionPointReference : oConnectionNode.getReferencedConnectionPointReferences()) {
						if(!out_colNodes.contains(oConnectionPointReference)) {
							out_colNodes.add(oConnectionPointReference);
						}
					}
				}
			}
			nNewSize = out_colNodes.size();
		}
		return out_colNodes;
	}

	public static boolean isTopmostInitialNode(TCGNode in_oNode)
	{
		boolean bIsSuperInitialNode = false;
		if(in_oNode instanceof TCGIntermediateNode) {
			TCGIntermediateNode oInterNode = (TCGIntermediateNode)in_oNode;
			TestCaseGraph oTCG = TCGNodeHelperClass.getContainingTestGraph(oInterNode);
			if(oTCG != null) {
				if(oInterNode.getNodeType().equals(TCGNodeType.INITIAL) && 
						oTCG.getCompositeSuperState() == null)
					bIsSuperInitialNode = true;
			}
		}
		return bIsSuperInitialNode;
	}
	
	public static boolean nodeCannotBeReached(TCGNode in_oNode) {
		if(in_oNode instanceof TCGIntermediateNode) {
			if(((TCGIntermediateNode)in_oNode).getNodeType().equals(TCGNodeType.INITIAL))
				return false;
		}
		if(in_oNode.getIncomingTransitions().isEmpty())
			return true;
		
		boolean bFoundNoAccessibleTransition = true;
		for(TCGTransition oTransition : in_oNode.getIncomingTransitions()) {
			if(oTransition.isCanBeProcessed())
				bFoundNoAccessibleTransition = false;
		}
		return bFoundNoAccessibleTransition;
	}

	public static List<TCGNode> getAllSubNodesIncludingThis(TCGNode in_oSuperNode) {
		List<TCGNode> colRetValues = new ArrayList<TCGNode>();
		colRetValues.add(in_oSuperNode);
		colRetValues.addAll(getAllSubNodes(in_oSuperNode));
		return colRetValues;
	}

	
	public static List<TCGNode> getAllSubNodes(TCGNode in_oSuperNode) {
		List<TCGNode> colRetValues = new ArrayList<TCGNode>();
		
		if(in_oSuperNode instanceof TCGRealNode) {
			TCGRealNode oRealNode = (TCGRealNode)in_oSuperNode;
			TestCaseGraph oTCG = oRealNode.getSubGraph();
			if(oTCG != null) {
				for(TestCaseRegion oRegion : oTCG.getRegions()) {
					for(TCGNode oNode : oRegion.getNodes()) {
						if(oNode instanceof TCGRealNode) {
							if(((TCGRealNode)oNode).getSubGraph() != null) {
								colRetValues.addAll(getAllSubNodes(oNode));
							}
							else
								colRetValues.add(oNode);
						} else {
							colRetValues.add(oNode);
						}
					}
				}
			}
		}
		
		return colRetValues;
	}
	
	public static List<TCGTransition> getAllTransitionsWithoutTrigger(TCGNode in_oNode) {
		List<TCGTransition> colResult = new ArrayList<TCGTransition>();
		
		List<TCGTransition> colTmpTransitions = getAllOutgoingTransitionsPlusCPR(in_oNode);
		// add all outgoing transitions of initial nodes of the subregions
		for(TCGNode oNode : TCGNodeHelperClass.getInitialNodesOfState(in_oNode)) {
			colTmpTransitions.addAll(oNode.getOutgoingTransitions());
		}		
		
		for(TCGTransition oTransition : colTmpTransitions) {
			if(oTransition.getEvents().isEmpty()) {
				colResult.add(oTransition);
			}
			else {
				if(oTransition.getEvents().get(0).isDefaultEvent()) {
					colResult.add(oTransition);
				}
			}
		}
		
		return colResult;
	}
	
	public static List<TCGNode> prioritizeNodeList(
			List<TCGNode> io_colNodes,
			boolean in_bAscending) 
	{
		
		List<TCGNode> colNodes = new ArrayList<TCGNode>();
		colNodes.addAll(io_colNodes);
		
		// sort nodes so that the node with the highest distance is in front
		if(in_bAscending == true) {
			Collections.sort(colNodes, 
				new Comparator<TCGNode>() {
					@Override
					public int compare(TCGNode o1, TCGNode o2) {
						if(ConfigurationTestPathSearchStrategy.getTestPathSearchStrategy().equals(
								ConfigurationTestPathSearchStrategy.TestPathSearchStrategy.TRANSITIONS_TO_NEAR_NODES_FIRST)) {
							if(o1.getMinDistanceFromStart() < o2.getMinDistanceFromStart())
								return 1;
							if(o1.getMinDistanceFromStart() > o2.getMinDistanceFromStart())
								return -1;
						}
						else  if(ConfigurationTestPathSearchStrategy.getTestPathSearchStrategy().equals(
								ConfigurationTestPathSearchStrategy.TestPathSearchStrategy.TRANSITIONS_TO_FAR_NODES_FIRST)) {
							if(o1.getMaxDistanceFromStart() < o2.getMaxDistanceFromStart())
								return 1;
							if(o1.getMaxDistanceFromStart() > o2.getMaxDistanceFromStart())
								return -1;
						}
						return 0;
					}
				}
			);
		}
		else {
			Collections.sort(colNodes, 
					new Comparator<TCGNode>() {
						@Override
						public int compare(TCGNode o1, TCGNode o2) {
							if(ConfigurationTestPathSearchStrategy.getTestPathSearchStrategy().equals(
									ConfigurationTestPathSearchStrategy.TestPathSearchStrategy.TRANSITIONS_TO_NEAR_NODES_FIRST)) {
								if(o1.getMinDistanceFromStart() < o2.getMinDistanceFromStart())
									return -1;
								if(o1.getMinDistanceFromStart() > o2.getMinDistanceFromStart())
									return 1;
							}
							else if(ConfigurationTestPathSearchStrategy.getTestPathSearchStrategy().equals(
									ConfigurationTestPathSearchStrategy.TestPathSearchStrategy.TRANSITIONS_TO_FAR_NODES_FIRST)) {
								if(o1.getMaxDistanceFromStart() < o2.getMaxDistanceFromStart())
									return -1;
								if(o1.getMaxDistanceFromStart() > o2.getMaxDistanceFromStart())
									return 1;
							}
							return 0;
						}
					}
				);			
		}
		return colNodes;
	}
	
	public static List<TCGEvent> getTriggeringEventsForNode(TCGNode in_oNode) {
		List<TCGEvent> colEvents = new ArrayList<TCGEvent>();
		
		for(TCGTransition oTransition : getOutgoingTransitions(in_oNode)) {
			for(TCGEvent oEvent : oTransition.getEvents()) {
				//if(!colEvents.contains(oEvent)) {
				if(!ObjectComparator.contains(colEvents, oEvent)) {
					colEvents.add(oEvent);
				}
			}
		}
		
		return colEvents;
	}
	
	public static List<TCGNode> findNodesWithOutOutgoingTransitions(TCGNode in_oSuperNode) {
		if(in_oSuperNode instanceof TCGRealNode) {
			TCGRealNode oNode = (TCGRealNode)in_oSuperNode;
			if(oNode.getSubGraph() != null) {
				if(oNode.getSubGraph().getRegions().size() == 1) {
					// TODO configuration für parallele Substatemachines
					return TCGRegionHelperClass.findNodesWithOutOutgoingTransitions(
							oNode.getSubGraph().getRegions().get(0));
				}
			}
			else if(oNode.getReferencedSubmachine() != null) {
				// TODO referenzierte Zustandsmaschinen einbauen
			}
		}
		return new ArrayList<TCGNode>();
	}
	
	public static TCGNode copyNodeWithoutTransitions(
			TestCaseGraphHelper in_oTCGHelper,
			TCGNode in_oNode) {
		TCGNode oCopy = null;
		if(in_oNode instanceof TCGRealNode) {
			TCGRealNode oOriginal = (TCGRealNode)in_oNode;
			TCGRealNode oRealNode = in_oTCGHelper.addRealNode(oOriginal.getContainer());
			oRealNode.setCondition(
					TCGDisjunctiveNormalFormHelperClass.copyDNFDeep(oOriginal.getCondition()));
			oRealNode.setContainer(oOriginal.getContainer());
			oRealNode.setSubGraph(oOriginal.getSubGraph());
			oCopy = oRealNode;
		}
		else if(in_oNode instanceof TCGIntermediateNode) {
			TCGIntermediateNode oOriginal = (TCGIntermediateNode)in_oNode;
			TCGIntermediateNode oIntNode =
				in_oTCGHelper.addIntermediateNode(
						oOriginal.getContainer(), oOriginal.getNodeType());
//			oIntNode.setContainer(oOriginal.getContainer());
//			oIntNode.setNodeType(oOriginal.getNodeType());
			oIntNode.getReferencedConnectionPointReferences().addAll(
					oOriginal.getReferencedConnectionPointReferences());
			oIntNode.getReferencedConnectionPoints().addAll(
					oOriginal.getReferencedConnectionPoints());
			oCopy = oIntNode;
		}
		
		if(oCopy != null) {
			oCopy.setMaxDistanceFromStart(in_oNode.getMaxDistanceFromStart());
			oCopy.setMinDistanceFromStart(in_oNode.getMinDistanceFromStart());
			oCopy.setName(in_oNode.getName());
			oCopy.setOriginalNode(in_oNode.getOriginalNode());
			oCopy.setReferencedSubmachine(in_oNode.getReferencedSubmachine());
			oCopy.setUseAllTransitionsInParallel(in_oNode.isUseAllTransitionsInParallel());
		}
		return oCopy;
	}
}

