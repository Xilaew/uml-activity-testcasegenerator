package net.sf.parteg.base.testcasetree.ocl.parser;

import net.sf.parteg.base.testcasetree.generated.TCGOCLExpression;
import net.sf.parteg.base.testcasetree.generated.TCGOCLOperation;

public class OCLTreeExpressionIterator {

	public static void run(TCGOCLExpression in_oExp, OCLTreeExpressionVisitor in_oVisitor)
	{
		in_oVisitor.check(in_oExp);
		if(in_oExp instanceof TCGOCLOperation)
		{
			TCGOCLOperation oOpExp = (TCGOCLOperation)in_oExp;
			run(oOpExp.getLeft(), in_oVisitor);
			run(oOpExp.getRight(), in_oVisitor);			
		}
	}
}
