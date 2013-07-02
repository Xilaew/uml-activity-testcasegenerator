package net.sf.parteg.base.testcasetree.ocl.transformation;

import net.sf.parteg.base.testcasetree.generated.TCGNode;
import net.sf.parteg.base.testcasetree.generated.TCGTransition;

public interface TestCaseGraphVisitor {

	public void check(TCGNode in_oNode);
	public void check(TCGTransition in_oTransition);
}
