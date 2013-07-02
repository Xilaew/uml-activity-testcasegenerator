package net.sf.parteg.base.testcasetree.eventtree;

import java.util.ArrayList;

import net.sf.parteg.base.testcasetree.Configuration;
import net.sf.parteg.base.testcasetree.generated.TCGComplexParameter;
import net.sf.parteg.base.testcasetree.generated.TCGEvent;
import net.sf.parteg.base.testcasetree.generated.TCGNode;
import net.sf.parteg.base.testcasetree.generated.TCGParameter;
import net.sf.parteg.base.testcasetree.generated.TCGPrimitiveParameter;
import net.sf.parteg.base.testcasetree.generated.TCGTransition;
import net.sf.parteg.base.testcasetree.ocl.TestCaseGraphHelper;

public class EventTree {

	private EventNode m_oRoot;
	private ArrayList<EventNode> m_colEventNodes;
	private TestCaseGraphHelper m_oTestCaseGraphHelper;
	
	public EventTree(TestCaseGraphHelper in_oTestCaseGraphHelper)
	{
		m_oTestCaseGraphHelper = in_oTestCaseGraphHelper;
		m_colEventNodes = new ArrayList<EventNode>();
		m_oRoot = new EventNode();
		buildUpEventTree(in_oTestCaseGraphHelper.getTestCaseGraph().getRoot(), m_oRoot);
		assembleArcsFromSameNodeWithSameEvent(m_oRoot);
		// check if all parameters of a node are negative - if not complete -> delete
		if(Configuration.isCompletenessForGeneratedPartitions())
		{
			// if something was deleted then re-build the whole tree
			if(combineMatchingPartitions(m_oRoot))
			{
				m_colEventNodes = new ArrayList<EventNode>();
				m_oRoot = new EventNode();
				buildUpEventTree(in_oTestCaseGraphHelper.getTestCaseGraph().getRoot(), m_oRoot);
				assembleArcsFromSameNodeWithSameEvent(m_oRoot);
			}
		}
	}
	
	public EventNode getRoot()
	{
		return m_oRoot;
	}
	
	public ArrayList<EventNode> getEventNodes()
	{
		return m_colEventNodes;
	}

	/**
	 * returns all nodes that are below or on equal level of in_oEventNode 
	 * @param in_oEventNode
	 * @return
	 */
	public ArrayList<TCGNode> getSubTCGNodesFrom(EventNode in_oEventNode)
	{
		ArrayList<TCGNode> colTCGNodes = new ArrayList<TCGNode>();
		colTCGNodes.addAll(in_oEventNode.getLeafNodes());
		for(EventArc oArc : in_oEventNode.getOutgoingArcs())
		{
			EventNode oTargetNode = oArc.getTargetNode();
			colTCGNodes.addAll(getSubTCGNodesFrom(oTargetNode));
		}
		return colTCGNodes;
	}
	
	private void buildUpEventTree(TCGNode in_oTCTNode, EventNode in_oNode)
	{
		//m_colEventNodes.add(in_oNode);

		// check for leaves
		if(in_oTCTNode.getOutgoingTransitions().isEmpty())
		{
			in_oNode.getLeafNodes().add(in_oTCTNode);
			if(!m_colEventNodes.contains(in_oNode))
				m_colEventNodes.add(in_oNode);
		}
		
		// check for events
		for(TCGTransition oTransition : in_oTCTNode.getOutgoingTransitions())
		{
			EventNode oNode = in_oNode;
			TCGEvent oEvent = oTransition.getEvent();
			if(oEvent != null)
			{
				if(!oEvent.isDefaultEvent()){
					EventArc oArc = new EventArc(oEvent);
					in_oNode.getOutgoingArcs().add(oArc);
					oNode = new EventNode();
					oArc.setTargetNode(oNode);
				}
			}
			buildUpEventTree(oTransition.getTargetNode(), oNode);
		}
	}
	
	private void assembleArcsFromSameNodeWithSameEvent(EventNode io_oNode)
	{
		ArrayList<EventArc> colArcs = new ArrayList<EventArc>();
		for(int i = 0; i < io_oNode.getOutgoingArcs().size(); ++i)
		{
			EventArc oEventArc1 = io_oNode.getOutgoingArcs().get(i);
			for(int j = i+1; j < io_oNode.getOutgoingArcs().size(); ++j)
			{
				EventArc oEventArc2 = io_oNode.getOutgoingArcs().get(j);
				boolean bMatch = false;
				if(oEventArc1.getReferencedEvent().isDefaultEvent() &&
						oEventArc2.getReferencedEvent().isDefaultEvent())
				{
					bMatch = true;
				}
				else if((!oEventArc1.getReferencedEvent().isDefaultEvent() && 
						!oEventArc2.getReferencedEvent().isDefaultEvent()) &&
						(oEventArc1.getReferencedEvent().getEvent().equals(
							oEventArc2.getReferencedEvent().getEvent())))
				{
					bMatch = true;
				}
				
				if(bMatch == true)
				{
					EventNode oEventNode1 = oEventArc1.getTargetNode();
					EventNode oEventNode2 = oEventArc2.getTargetNode();
					// add all referenced leaves from 1 to 2
					for(TCGNode oNode : oEventNode1.getLeafNodes())
					{
						oEventNode2.getLeafNodes().add(oNode);
					}
					// add all following arcs from 1 to 2
					for(EventArc oArc : oEventNode1.getOutgoingArcs())
					{
						oEventNode2.getOutgoingArcs().add(oArc);
					}
					// remember arc for deletion
					colArcs.add(oEventArc1);
					break;
				}
			}
			// recursion
			if(!(colArcs.contains(oEventArc1)))
			{
				assembleArcsFromSameNodeWithSameEvent(oEventArc1.getTargetNode());
			}
		}
		for(EventArc oArc : colArcs)
		{
			io_oNode.getOutgoingArcs().remove(oArc);
			getEventNodes().remove(oArc.getTargetNode());
		}
	}
	
	private boolean combineMatchingPartitions(EventNode in_oNode)
	{
		ArrayList<TCGNode> colNodesToBeDeleted = new ArrayList<TCGNode>();
		for(TCGNode oTCGSuperNode : in_oNode.getLeafNodes())
		{
			for(TCGNode oTCGSubNode : getSubTCGNodesFrom(in_oNode))
			{
				/**
				 * 1) nodes are not equal
				 * 2) if comparison successful -> delete super node -> sub node is not already deleted 
				 * 3.a) super node has only a false subset of the sub node's parameters
				 * 3.b) for those parameters the conditions of the super node are included in the
				 *      conditions of the sub node
				 */
				if((!oTCGSuperNode.equals(oTCGSubNode)) && 
						(!colNodesToBeDeleted.contains(oTCGSubNode)) &&
						parameterSetsInSuperNodeJustCompleteTheParametersInSubNode(oTCGSuperNode, oTCGSubNode))
				{
					completeParameterSetsInSubNodeWithTheParametersInSuperNode(oTCGSuperNode, oTCGSubNode);
					colNodesToBeDeleted.add(oTCGSuperNode);
				}
			}
		}

		boolean bRet = colNodesToBeDeleted.size() > 0;

		for(EventArc oEventArc : in_oNode.getOutgoingArcs())
		{
			EventNode oEventNode = oEventArc.getTargetNode();
			bRet = bRet || combineMatchingPartitions(oEventNode);
		}
		
		for(TCGNode oNode : colNodesToBeDeleted)
		{
			m_oTestCaseGraphHelper.removeNode(oNode);
		}
		return bRet;
	}
	
	/**
	 * 
	 * @param in_oTCGSuperNode
	 * @param in_oTCGSubNode
	 * @return
	 */
	private boolean parameterSetsInSuperNodeJustCompleteTheParametersInSubNode(TCGNode in_oTCGSuperNode, TCGNode in_oTCGSubNode)
	{
		if(in_oTCGSuperNode.getParameters().size() > in_oTCGSubNode.getParameters().size())
			return false;
		// iterate over parameters of super node
		for(TCGParameter oSuperParameter : in_oTCGSuperNode.getParameters())
		{
			TCGParameter oSubParameter = null;
			// iterate over parameters of sub node
			for(TCGParameter oParameter : in_oTCGSubNode.getParameters())
			{
				if(oParameter.getReference().equals(oSuperParameter.getReference()))
				{
					oSubParameter = oParameter;
					break;
				}
			}
			if(oSubParameter == null)
				return false;
			else
			{
				if(isSuperBoundaryIncludedInSubBoundary(oSuperParameter, oSubParameter) == false)
					return false;
				
						
				// TODO : noch einschließen, ob die Grenzen enthalten sind oder nicht!
//				if((oSuperParameter.getEquivalenceClass().getMaxBorder().compareTo(oSubParameter.getEquivalenceClass().getMaxBorder()) >= 0) &&
//						(oSuperParameter.getEquivalenceClass().getMinBorder().compareTo(oSubParameter.getEquivalenceClass().getMinBorder()) <= 0))
//				{
//				}
//				else
//					return false;
			}
		}
		return true;	
	}
	
	private boolean isSuperBoundaryIncludedInSubBoundary(TCGParameter in_oSuperParameter, TCGParameter in_oSubParameter)
	{
		if(in_oSuperParameter instanceof TCGPrimitiveParameter)
		{
			return isSuperBoundaryIncludedInSubBoundary((TCGPrimitiveParameter) in_oSuperParameter, (TCGPrimitiveParameter) in_oSubParameter);
		}
		else if(in_oSuperParameter instanceof TCGComplexParameter)
		{
			return isSuperBoundaryIncludedInSubBoundary((TCGComplexParameter) in_oSuperParameter, (TCGComplexParameter) in_oSubParameter);
		}
		return false;
	}
	
	/*
	 * boundary check for complex parameters
	 */
	private boolean isSuperBoundaryIncludedInSubBoundary(TCGComplexParameter in_oSuperParameter, TCGComplexParameter in_oSubParameter)
	{
		for(TCGParameter oSuperSubParameter : in_oSuperParameter.getParameter())
		{
			for(TCGParameter oSubSubParameter : in_oSubParameter.getParameter())
			{
				if(oSuperSubParameter.getReference().equals(oSubSubParameter.getReference())) // gleiches Sub-Attribut der Parameter 
				{
					if(isSuperBoundaryIncludedInSubBoundary(oSuperSubParameter, oSubSubParameter) == false)
					{
						return false;
					}
					break;
				}
			}
		}
		return true;
	}
	
	/*
	 * boundary check for primitive parameters
	 */
	private boolean isSuperBoundaryIncludedInSubBoundary(TCGPrimitiveParameter in_oSuperParameter, TCGPrimitiveParameter in_oSubParameter)
	{
		boolean bMaxBordersOfSuperIsIncludedInSub = 
			(((in_oSuperParameter.getEquivalenceClass().getMaxBorder().compareTo(in_oSubParameter.getEquivalenceClass().getMaxBorder()) == 0) &&
			(!in_oSuperParameter.getEquivalenceClass().getMaxIncluded() || in_oSubParameter.getEquivalenceClass().getMaxIncluded())) ||
			(in_oSuperParameter.getEquivalenceClass().getMaxBorder().compareTo(in_oSubParameter.getEquivalenceClass().getMaxBorder()) < 0));
		boolean bMinBordersOfSuperIsIncludedInSub = 
			(((in_oSuperParameter.getEquivalenceClass().getMinBorder().compareTo(in_oSubParameter.getEquivalenceClass().getMinBorder()) == 0) &&
			(!in_oSuperParameter.getEquivalenceClass().getMinIncluded() || in_oSubParameter.getEquivalenceClass().getMinIncluded())) ||
			(in_oSuperParameter.getEquivalenceClass().getMinBorder().compareTo(in_oSubParameter.getEquivalenceClass().getMinBorder()) > 0));

		// if at least one boundary-inclusion is violated -> return false
		if(bMaxBordersOfSuperIsIncludedInSub && bMinBordersOfSuperIsIncludedInSub)
			return true;
		return false;
	}
	
	private void completeParameterSetsInSubNodeWithTheParametersInSuperNode(TCGNode in_oTCGSuperNode, TCGNode in_oTCGSubNode)
	{
		// iterate over parameters of super node
		for(TCGParameter oFirstParameter : in_oTCGSuperNode.getParameters())
		{
			TCGParameter oSecondParameter = null;
			// iterate over parameters of sub node
			for(TCGParameter oParameter : in_oTCGSubNode.getParameters())
			{
				if(oParameter.getReference().equals(oFirstParameter.getReference()))
				{
					oSecondParameter = oParameter;
					break;
				}
			}
			if(oSecondParameter == null)
				System.err.println("error in completeParameterSetsInSubNodeWithTheParametersInSuperNode");
			else
			{
				completeBoundarySets(oFirstParameter, oSecondParameter);
			}
		}
	}
	
	private void completeBoundarySets(TCGParameter in_oFirstParameter, TCGParameter in_oSecondParameter)
	{
		if(in_oFirstParameter instanceof TCGPrimitiveParameter)
		{
			completeBoundarySets((TCGPrimitiveParameter) in_oFirstParameter, (TCGPrimitiveParameter) in_oSecondParameter);
		}
		else if(in_oFirstParameter instanceof TCGComplexParameter)
		{
			completeBoundarySets((TCGComplexParameter) in_oFirstParameter, (TCGComplexParameter) in_oSecondParameter);
		}
	}
	
	/*
	 * complete boundary sets for complex parameters
	 */
	private void completeBoundarySets(TCGComplexParameter in_oFirstParameter, TCGComplexParameter in_oSecondParameter)
	{
		for(TCGParameter oSuperSubParameter : in_oFirstParameter.getParameter())
		{
			for(TCGParameter oSubSubParameter : in_oSecondParameter.getParameter())
			{
				if(oSuperSubParameter.getName().equals(oSubSubParameter.getName())) // gleiches Sub-Attribut der Parameter 
				{
					completeBoundarySets(oSuperSubParameter, oSubSubParameter);
					break;
				}
			}
		}
	}

	/*
	 * complete boundary set for primitive parameters
	 */
	private void completeBoundarySets(TCGPrimitiveParameter in_oFirstParameter, TCGPrimitiveParameter in_oSecondParameter)
	{
		// do both parameter sets complete each other?
		// both have one undefined boundary, each, and match at the other boundaries		
		if((in_oFirstParameter.getEquivalenceClass().getMaxBorder().compareTo(Configuration.getUpperDomainBoundary()) == 0) &&
				(in_oSecondParameter.getEquivalenceClass().getMinBorder().compareTo(Configuration.getLowerDomainBoundary()) == 0) &&
				(in_oFirstParameter.getEquivalenceClass().getMinBorder().compareTo(in_oSecondParameter.getEquivalenceClass().getMaxBorder()) < 0))
		{
			in_oSecondParameter.getEquivalenceClass().setMinBorder(in_oFirstParameter.getEquivalenceClass().getMinBorder().doubleValue());
			in_oSecondParameter.getEquivalenceClass().setMinIncluded(in_oFirstParameter.getEquivalenceClass().getMinIncluded());
		}
		else if((in_oSecondParameter.getEquivalenceClass().getMaxBorder().compareTo(Configuration.getUpperDomainBoundary()) == 0) &&
				(in_oFirstParameter.getEquivalenceClass().getMinBorder().compareTo(Configuration.getLowerDomainBoundary()) == 0) &&
				(in_oSecondParameter.getEquivalenceClass().getMinBorder().compareTo(in_oFirstParameter.getEquivalenceClass().getMaxBorder()) < 0))
		{
			in_oSecondParameter.getEquivalenceClass().setMaxBorder(in_oFirstParameter.getEquivalenceClass().getMaxBorder().doubleValue());
			in_oSecondParameter.getEquivalenceClass().setMaxIncluded(in_oFirstParameter.getEquivalenceClass().getMaxIncluded());
		}
	}
	
}
