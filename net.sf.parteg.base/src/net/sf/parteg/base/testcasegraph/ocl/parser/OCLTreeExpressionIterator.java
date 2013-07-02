package net.sf.parteg.base.testcasegraph.ocl.parser;

import net.sf.parteg.base.testcasegraph.generated.TCGOCLExpression;
import net.sf.parteg.base.testcasegraph.generated.TCGOCLIfThenElse;
import net.sf.parteg.base.testcasegraph.generated.TCGOCLOperation;

public class OCLTreeExpressionIterator {

	public static void run(TCGOCLExpression in_oExp, OCLTreeExpressionVisitor in_oVisitor)
	{
		if(in_oExp != null) {
			in_oVisitor.check(in_oExp);
			if(in_oExp instanceof TCGOCLOperation)
			{
				TCGOCLOperation oOpExp = (TCGOCLOperation)in_oExp;
				if(oOpExp.getLeft() != null)
					run(oOpExp.getLeft(), in_oVisitor);
				if(oOpExp.getRight() != null)
					run(oOpExp.getRight(), in_oVisitor);			
			} 
			else if(in_oExp instanceof TCGOCLIfThenElse) {
				TCGOCLIfThenElse oIfThenElseExp = (TCGOCLIfThenElse)in_oExp;
				if(oIfThenElseExp.getCondition() != null)
					run(oIfThenElseExp.getCondition(), in_oVisitor);
				if(oIfThenElseExp.getThenExpression() != null)
					run(oIfThenElseExp.getThenExpression(), in_oVisitor);			
				if(oIfThenElseExp.getElseExpression() != null)
					run(oIfThenElseExp.getElseExpression(), in_oVisitor);							
			}
		}
	}
}
