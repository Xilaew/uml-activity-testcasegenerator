package net.sf.parteg.base.testcasetree.ocl.transformation;

import net.sf.parteg.base.testcasetree.generated.TCGNode;
import net.sf.parteg.base.testcasetree.generated.TCGTransition;

public class TestCaseGraphIterator {

	public static void run(TCGNode in_oNode, TestCaseGraphVisitor in_oVisitor)
	{
		in_oVisitor.check(in_oNode);
		for(TCGTransition oTransition : in_oNode.getOutgoingTransitions())
		{
			in_oVisitor.check(oTransition);
			run(oTransition.getTargetNode(), in_oVisitor);
		}		
	}
}
