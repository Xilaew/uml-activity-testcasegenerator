package net.sf.parteg.base.testcasetree.ocl.parser;

import net.sf.parteg.base.testcasetree.generated.TCGOCLExpression;

public interface OCLTreeExpressionVisitor {

	public void check(TCGOCLExpression in_oExpression);
	
}
