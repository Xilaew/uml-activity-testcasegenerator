package net.sf.parteg.base.testcasegraph.ocl.parser;

import net.sf.parteg.base.testcasegraph.generated.TCGOCLExpression;

public interface OCLTreeExpressionVisitor {

	public void check(TCGOCLExpression in_oExpression);
	
}
