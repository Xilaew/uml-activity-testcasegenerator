package net.sf.parteg.base.testcasegraph.systemstate;

import java.util.ArrayList;
import java.util.List;

import net.sf.parteg.base.runtime.generated.RuntimeState;
import net.sf.parteg.base.testcasegraph.generated.TCGElement;
import net.sf.parteg.base.testcasegraph.generated.TCGIntermediateNode;
import net.sf.parteg.base.testcasegraph.generated.TCGNode;
import net.sf.parteg.base.testcasegraph.generated.TCGNodeType;
import net.sf.parteg.base.testcasegraph.generated.TCGOCLAtom;
import net.sf.parteg.base.testcasegraph.generated.TCGOCLExpression;
import net.sf.parteg.base.testcasegraph.generated.TCGOCLIfThenElse;
import net.sf.parteg.base.testcasegraph.generated.TCGOCLOperation;
import net.sf.parteg.base.testcasegraph.generated.TCGRealNode;
import net.sf.parteg.base.testcasegraph.generated.TCGTransition;
import net.sf.parteg.base.testcasegraph.generated.TestCaseRegion;
import net.sf.parteg.base.testcasegraph.generated.VariableClassification;
import net.sf.parteg.base.testcasegraph.helperclasses.TCGRegionHelperClass;
import net.sf.parteg.base.testcasegraph.helperclasses.VariableReferencer;
import net.sf.parteg.base.testcasegraph.ocl.TestCaseGraphHelper;

import org.eclipse.emf.ecore.EObject;

public class CurrentStateNodeSelector {


	/**
	 * 
	 * @param in_oRuntimeState
	 * @param in_colConditionsToBeSatisfied
	 * @param in_oTCGHelper
	 * @param out_oSelectedNode
	 * @return true if the selected node is created without state creation in new region
	 */
	public boolean selectNodeToBeProcessed(RuntimeState in_oRuntimeState, 
			List<TCGOCLExpression> in_colConditionsToBeSatisfied,
			TestCaseGraphHelper in_oTCGHelper,
			List<TCGNode> out_oSelectedNodeList)
	{
		// prefer temporary nodes without a counterpart in the state machine
		for(TCGNode oNode : in_oRuntimeState.getAllActiveNodes())
		{
			// has no counterpart and is no initial node
			if(oNode.getOriginalNode() == null && 
					(oNode instanceof TCGRealNode || 
							!((TCGIntermediateNode)oNode).getNodeType().equals(TCGNodeType.INITIAL))) {
				out_oSelectedNodeList.add(oNode);
				return true;
			}
		}
		
		// no region in runtime state?
		if(in_oRuntimeState.getAllRegions().isEmpty())
		{
			System.err.println("Error in runtime state");
			return false;
		}
		
		if(!in_colConditionsToBeSatisfied.isEmpty())
		{
			// best solution: find a state that can reach a postcondition to solve this condition
			boolean bResult = findNodeForConditionToSatisfy(
					in_oRuntimeState, in_colConditionsToBeSatisfied, 
					in_oTCGHelper, out_oSelectedNodeList);
			if(!out_oSelectedNodeList.isEmpty()) {
				return bResult;
			}
		}
		
		// select node from regions (no initial node)
		for(TestCaseRegion oRegion : in_oRuntimeState.getAllRegions()) 
		{
			TCGNode oNode = in_oRuntimeState.getActiveNode(oRegion);
			if((oNode instanceof TCGRealNode || 
					!((TCGIntermediateNode)oNode).getNodeType().equals(TCGNodeType.INITIAL))) {
				out_oSelectedNodeList.add(oNode);
			}
		}
		if(!out_oSelectedNodeList.isEmpty())
			return true;

		// TODO weitere Optimierungen einbauen: 
//		Suche nach Bedingungen, die noch erfüllt werden müssen
//		Einbeziehung von bisher ungesetzten Regionen

		
		// temporary solution - do not return null!
		for(TestCaseRegion oRegion : in_oRuntimeState.getAllRegions()) 
		{
			out_oSelectedNodeList.add(in_oRuntimeState.getActiveNode(oRegion));
		}
		if(!out_oSelectedNodeList.isEmpty())
			return true;
		return false;
	}
	
	/**
	 * 
	 * @param in_oRuntimeState
	 * @param in_colConditionsToBeSatisfied
	 * @param in_oTCGHelper
	 * @param out_oSelectedNode
	 * @return true if the selected node is not newly added to runtime state in a new region 
	 */
	public boolean findNodeForConditionToSatisfy(RuntimeState in_oRuntimeState, 
			List<TCGOCLExpression> in_colConditionsToBeSatisfied,
			TestCaseGraphHelper in_oTCGHelper,
			List<TCGNode> out_oSelectedNodeList)
	{
		VariableReferencer oReferencer = in_oTCGHelper.getVariableReferencer();
		List<EObject> colReferencedVariables = new ArrayList<EObject>();
		boolean bFoundNodeInExistingRegion = true;
		
		for(TCGOCLExpression oExpression : in_colConditionsToBeSatisfied)
		{
			getPassiveDependentElements(oExpression, colReferencedVariables);
			for(EObject oObject : colReferencedVariables)
			{
				List<TCGElement> colElements = oReferencer.getValuesForKey(oObject);
				if(colElements != null) {
					// evaluate all found references
					for(TCGElement oElement : colElements)
					{
						TestCaseRegion oRegion = null;
						TCGRealNode oNode = null;
						TCGTransition oTransition = null;
						
						if(oElement instanceof TCGRealNode)
						{
							oNode = (TCGRealNode)oElement;
							oRegion = oNode.getContainer();
						}
						else if(oElement instanceof TCGTransition)
						{
							oTransition = (TCGTransition)oElement;
							oRegion = oTransition.getContainer();
						}
						
						// found matching region for expression						
						TCGNode oNewActiveNode = in_oRuntimeState.getActiveNode(oRegion);
						
						// is the found state included in the region of one active state or vice versa? 
						for(TCGNode oActiveNode : in_oRuntimeState.getAllActiveNodes()) {
							if(oActiveNode instanceof TCGRealNode)
								if(TCGRegionHelperClass.regionsAreInHierarchicalOrder(
										((TCGRealNode)oActiveNode).getContainer(), oRegion)) {
									oNewActiveNode = oActiveNode;
								}
						}
						
						// region has no active node in current state?
						if(oNewActiveNode == null)
						{
							bFoundNodeInExistingRegion = false;
							// select the node directly behind the transition
							if(oTransition != null)
							{
								oNewActiveNode = oTransition.getTargetNode();
							}
							else if(oNode != null)
							{
								oNewActiveNode = oNode;
							}
						}
						if(!out_oSelectedNodeList.contains(oNewActiveNode))
							out_oSelectedNodeList.add(oNewActiveNode);
					}
				}
			}
		}
		
		return bFoundNodeInExistingRegion;
	}
	
	public static void getPassiveDependentElements(
			TCGOCLExpression in_oExpression, 
			List<EObject> out_ReferencedVariables)
	{
		
		if(in_oExpression instanceof TCGOCLAtom)
		{
			TCGOCLAtom oAtom = (TCGOCLAtom)in_oExpression;
			if(oAtom.getClassification().equals(VariableClassification.PASSIVE_DEPENDENT))
				out_ReferencedVariables.add(oAtom.getElement());
		}
		else if(in_oExpression instanceof TCGOCLOperation)
		{
			TCGOCLOperation oOperation = (TCGOCLOperation)in_oExpression;
			getPassiveDependentElements(oOperation.getLeft(), out_ReferencedVariables);
			getPassiveDependentElements(oOperation.getRight(), out_ReferencedVariables);
		}
		else if(in_oExpression instanceof TCGOCLIfThenElse)
		{
			TCGOCLIfThenElse oIfThenElse = (TCGOCLIfThenElse)in_oExpression;
			getPassiveDependentElements(oIfThenElse.getCondition(), out_ReferencedVariables);
			getPassiveDependentElements(oIfThenElse.getThenExpression(), out_ReferencedVariables);
			getPassiveDependentElements(oIfThenElse.getElseExpression(), out_ReferencedVariables);			
		}
	}
}
