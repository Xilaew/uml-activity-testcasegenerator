package net.sf.parteg.base.testcasegraph.helperclasses;

import java.util.List;

import net.sf.parteg.base.testcasegraph.generated.TCGConjunction;
import net.sf.parteg.base.testcasegraph.generated.TCGDisjunctiveNormalForm;
import net.sf.parteg.base.testcasegraph.generated.TCGElement;
import net.sf.parteg.base.testcasegraph.generated.TCGNode;
import net.sf.parteg.base.testcasegraph.generated.TCGOCLAtom;
import net.sf.parteg.base.testcasegraph.generated.TCGOCLExpression;
import net.sf.parteg.base.testcasegraph.generated.TCGOCLIfThenElse;
import net.sf.parteg.base.testcasegraph.generated.TCGOCLOperation;
import net.sf.parteg.base.testcasegraph.generated.TCGRealNode;
import net.sf.parteg.base.testcasegraph.generated.TCGTransition;
import net.sf.parteg.base.testcasegraph.generated.TestCaseGraph;
import net.sf.parteg.base.testcasegraph.generated.TestCaseRegion;
import net.sf.parteg.core.structures.MapElementToList;

import org.eclipse.emf.ecore.EObject;

public class VariableReferencer extends MapElementToList<EObject, TCGElement> {

	public void createVariableReferences(TestCaseGraph in_oGraph, List<TestCaseGraph> in_colTCGs)
	{
		if(in_oGraph != null && !in_colTCGs.contains(in_oGraph))
		{
			in_colTCGs.add(in_oGraph);
			for(TestCaseRegion oRegion : in_oGraph.getRegions())
			{
				for(TCGTransition oTransition : oRegion.getTransitions())
				{
					createVariableReferences(oTransition.getPostcondition(), oTransition);
				}
				for(TCGNode oNode : oRegion.getNodes())
				{
					if(oNode instanceof TCGRealNode)
					createVariableReferences(((TCGRealNode)oNode).getSubGraph(), in_colTCGs);
				}
			}
		}
	}
	
	private void createVariableReferences(TCGDisjunctiveNormalForm in_oDNF, TCGTransition in_oTransition)
	{
		if(in_oDNF != null)
		{
			for(TCGConjunction oConjunction : in_oDNF.getConjunctions())
			{
				for(TCGOCLExpression oExpression : oConjunction.getExpressions())
				{
					createVariableReferences(oExpression, in_oTransition);				
				}
			}
		}
	}

	private void createVariableReferences(TCGOCLExpression in_oExpression, TCGTransition in_oTransition)
	{
		if(in_oExpression instanceof TCGOCLAtom)
		{
			TCGOCLAtom oAtom = (TCGOCLAtom)in_oExpression;
			// adding the reference from the atom to the containing transition
			add(oAtom.getElement(), in_oTransition);
		}
		else if(in_oExpression instanceof TCGOCLOperation)
		{
			TCGOCLOperation oOperation = (TCGOCLOperation)in_oExpression;
			createVariableReferences(oOperation.getLeft(), in_oTransition);
			createVariableReferences(oOperation.getRight(), in_oTransition);
		}
		else if(in_oExpression instanceof TCGOCLIfThenElse)
		{
			TCGOCLIfThenElse oIfThenElse = (TCGOCLIfThenElse)in_oExpression;
			createVariableReferences(oIfThenElse.getCondition(), in_oTransition);
			createVariableReferences(oIfThenElse.getElseExpression(), in_oTransition);
			createVariableReferences(oIfThenElse.getThenExpression(), in_oTransition);
		}
	}
}
