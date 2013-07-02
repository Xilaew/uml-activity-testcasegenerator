package net.sf.parteg.base.testcasegraph.ocl.transformation;

import net.sf.parteg.base.testcasegraph.generated.TCGNode;
import net.sf.parteg.base.testcasegraph.generated.TCGTransition;

public interface TestCaseGraphVisitor {

	public void check(TCGNode in_oNode);
	public void check(TCGTransition in_oTransition);
}
