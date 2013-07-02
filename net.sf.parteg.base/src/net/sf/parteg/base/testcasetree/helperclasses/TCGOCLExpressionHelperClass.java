package net.sf.parteg.base.testcasetree.helperclasses;

import java.util.ArrayList;

import net.sf.parteg.base.testcasetree.generated.TCGOCLAtom;
import net.sf.parteg.base.testcasetree.generated.TCGOCLExpression;
import net.sf.parteg.base.testcasetree.generated.TCGOCLIfThenElse;
import net.sf.parteg.base.testcasetree.generated.TCGOCLOperation;
import net.sf.parteg.base.testcasetree.generated.VariableClassification;
import net.sf.parteg.base.testcasetree.ocl.parser.TCGOCLVariableClassificator;

import org.eclipse.emf.ecore.EObject;


public class TCGOCLExpressionHelperClass {

	public static boolean conditionContainsReferenceToObject(
			TCGOCLExpression in_oOCLExpression,
			EObject in_oReferencedObject)
	{
		if(in_oOCLExpression instanceof TCGOCLAtom)
		{
			return ((TCGOCLAtom)in_oOCLExpression).getElement().equals(in_oReferencedObject);
		}
		else if(in_oOCLExpression instanceof TCGOCLOperation)
		{
			TCGOCLOperation oOpExp = (TCGOCLOperation)in_oOCLExpression;
			return conditionContainsReferenceToObject(oOpExp.getLeft(), in_oReferencedObject) ||
				conditionContainsReferenceToObject(oOpExp.getRight(), in_oReferencedObject);
		}
		else if(in_oOCLExpression instanceof TCGOCLIfThenElse)
		{
			TCGOCLIfThenElse oIfThenElseExp = (TCGOCLIfThenElse)in_oOCLExpression;
			return conditionContainsReferenceToObject(oIfThenElseExp.getCondition(), in_oReferencedObject) ||
				conditionContainsReferenceToObject(oIfThenElseExp.getThenExpression(), in_oReferencedObject) ||
				conditionContainsReferenceToObject(oIfThenElseExp.getElseExpression(), in_oReferencedObject);
		}
		return false;
	}
	
	public static ArrayList<TCGOCLExpression> getContainedExpressionsWithActiveVariables(
			ArrayList<TCGOCLExpression> in_colExpressions)
	{
		ArrayList<TCGOCLExpression> oRetValues = new ArrayList<TCGOCLExpression>();
		for(TCGOCLExpression oExp : in_colExpressions)
		{
			if(expressionContainsActiveDependentVariables(oExp))
				oRetValues.add(oExp);
		}
		return oRetValues;
	}

	public static boolean expressionContainsActiveDependentVariables(
			TCGOCLExpression in_oExpression)
	{
		return getVariableOfType(
				in_oExpression, VariableClassification.ACTIVE_DEPENDENT) != null;
	}
	
	public static TCGOCLExpression getVariableOfType(
			TCGOCLExpression in_oExpression,
			VariableClassification in_oClassification)
	{
		TCGOCLVariableClassificator oClassificator = 
			new TCGOCLVariableClassificator(in_oExpression);
		return oClassificator.getClassifiedElementInExpression(
				in_oClassification);		
	}
	
}
