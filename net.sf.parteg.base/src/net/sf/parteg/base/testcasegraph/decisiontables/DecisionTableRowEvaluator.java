package net.sf.parteg.base.testcasegraph.decisiontables;

import net.sf.parteg.base.testcasegraph.generated.TCGOCLExpression;
import net.sf.parteg.base.testcasegraph.generated.TCGOCLIfThenElse;
import net.sf.parteg.base.testcasegraph.generated.TCGOCLOperation;

public class DecisionTableRowEvaluator {

	public static Boolean evaluateExpressionWithValueAssignment(
			TCGOCLExpression in_oExpression, 
			DecisionTableExpressionValueSelection in_oRow)
	{
		Boolean bValue = in_oRow.get(in_oExpression);
		if(bValue != null)
			return bValue; 
		
		if(in_oExpression instanceof TCGOCLOperation)
		{
			TCGOCLOperation oOperation = (TCGOCLOperation)in_oExpression;
			if(oOperation.getOperationName().equals("and"))
			{
				bValue = evaluateExpressionWithValueAssignment(oOperation.getLeft(), in_oRow) &&
					evaluateExpressionWithValueAssignment(oOperation.getRight(), in_oRow);
				in_oRow.put(in_oExpression, bValue);
				return bValue;
			}
			if(oOperation.getOperationName().equals("or"))
			{
				bValue = evaluateExpressionWithValueAssignment(oOperation.getLeft(), in_oRow) ||
					evaluateExpressionWithValueAssignment(oOperation.getRight(), in_oRow);
				in_oRow.put(in_oExpression, bValue);
				return bValue;
			}
			if(oOperation.getOperationName().equals("not"))
			{
				TCGOCLExpression oNegatedExp = oOperation.getLeft();
				if(oNegatedExp == null) {
					oNegatedExp = oOperation.getRight();
				}
				bValue = !evaluateExpressionWithValueAssignment(oNegatedExp, in_oRow);
				in_oRow.put(in_oExpression, bValue);
				return bValue;
			}
		}
		else if(in_oExpression instanceof TCGOCLIfThenElse)
		{
			TCGOCLIfThenElse oIfThenElse = (TCGOCLIfThenElse)in_oExpression;
			if(evaluateExpressionWithValueAssignment(oIfThenElse.getCondition(), in_oRow))
			{
				bValue = evaluateExpressionWithValueAssignment(oIfThenElse.getThenExpression(), in_oRow);
				in_oRow.put(in_oExpression, bValue);
				return bValue;
			}
			else
			{
				bValue = evaluateExpressionWithValueAssignment(oIfThenElse.getElseExpression(), in_oRow);
				in_oRow.put(in_oExpression, bValue);
				return bValue;
			}
		}
		return true; // default value for boolean atoms
	}
	
}
