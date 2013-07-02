package net.sf.parteg.base.testcasetree.constraints;

import net.sf.parteg.base.testcasetree.generated.TCGNode;
import net.sf.parteg.base.testcasetree.generated.TCGTransition;
import net.sf.parteg.base.testcasetree.generated.TestCaseGraph;

public class TestCaseGraphDepthConstraint implements TestCaseGraphConstraint {
	
	private TestCaseGraph m_oTestCaseGraph;
	private int m_nAllowedDepth;
	private int m_nActualDepth;
	
	public TestCaseGraphDepthConstraint(int in_nAllowedDepth, TestCaseGraph in_oTestCaseGraph)
	{
		m_nAllowedDepth = in_nAllowedDepth;
		m_oTestCaseGraph = in_oTestCaseGraph;
	}

	public boolean isFulfilled() {
		m_nActualDepth = 0;
		return isFulfilledHelper(m_oTestCaseGraph.getRoot());
	}
	
	private boolean isFulfilledHelper(TCGNode in_oTCGNode)
	{
		if(m_nActualDepth > m_nAllowedDepth)
		{
			return false;
		}
		for(TCGTransition oTransition : in_oTCGNode.getOutgoingTransitions())
		{
			++m_nActualDepth;
			if(isFulfilledHelper(oTransition.getTargetNode()) == false)
			{
				return false;
			}
			--m_nActualDepth;
		}
		return true;
	}
}
