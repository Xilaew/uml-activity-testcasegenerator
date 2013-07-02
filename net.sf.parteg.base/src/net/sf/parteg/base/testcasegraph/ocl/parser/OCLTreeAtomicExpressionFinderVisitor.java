package net.sf.parteg.base.testcasegraph.ocl.parser;

import java.util.ArrayList;

import net.sf.parteg.base.testcasegraph.generated.TCGOCLExpression;
import net.sf.parteg.base.testcasegraph.generated.TCGOCLIfThenElse;
import net.sf.parteg.base.testcasegraph.generated.TCGOCLOperation;
import static net.sf.parteg.base.testcasegraph.helperclasses.TCGOCLExpressionHelperClass.isBooleanOperation;

public class OCLTreeAtomicExpressionFinderVisitor implements
		OCLTreeExpressionVisitor {

	private ArrayList<TCGOCLExpression> m_colExpressions;
	private TCGOCLExpression m_oWholeExpression;
	
	public OCLTreeAtomicExpressionFinderVisitor(TCGOCLExpression in_oWholeExpression) {
		m_colExpressions = new ArrayList<TCGOCLExpression>();
		m_oWholeExpression = in_oWholeExpression;
	}
	
	public ArrayList<TCGOCLExpression> getExpressions()
	{
		if(m_colExpressions.isEmpty())
		{
			ArrayList<TCGOCLExpression> colReturn = new ArrayList<TCGOCLExpression>();
			colReturn.add(m_oWholeExpression);
			return colReturn;
		}
		return m_colExpressions;
	}
	
	@Override
	public void check(TCGOCLExpression in_oExpression) {
		if(isBooleanOperation(in_oExpression))
		{
			// add simple boolean negations as atomar expression
			if(((TCGOCLOperation)in_oExpression).getOperationName().equals("not")) {
				TCGOCLExpression oNegatedExp = ((TCGOCLOperation)in_oExpression).getLeft(); 
				if(oNegatedExp == null)
					oNegatedExp = ((TCGOCLOperation)in_oExpression).getRight();
				if(!isBooleanOperation(oNegatedExp)) {
					m_colExpressions.add(in_oExpression);
				}
			}
			else {
				TCGOCLOperation oOperation = (TCGOCLOperation)in_oExpression;
				if(oOperation.getLeft() != null && !isBooleanOperation(oOperation.getLeft()))
						m_colExpressions.add(oOperation.getLeft());
					
				if(oOperation.getRight() != null && !isBooleanOperation(oOperation.getRight()))
						m_colExpressions.add(oOperation.getRight());
			}
		}
		else if(in_oExpression instanceof TCGOCLIfThenElse)
		{
			TCGOCLIfThenElse oIfThenElse = (TCGOCLIfThenElse)in_oExpression;
			if(!isBooleanOperation(oIfThenElse.getCondition()))
				m_colExpressions.add(oIfThenElse.getCondition());
			if(!isBooleanOperation(oIfThenElse.getThenExpression()))
				m_colExpressions.add(oIfThenElse.getThenExpression());
			if(!isBooleanOperation(oIfThenElse.getElseExpression()))
				m_colExpressions.add(oIfThenElse.getElseExpression());
		}
	}

}
