package net.sf.parteg.base.testcasetree.ocl.transformation;

import java.util.ArrayList;

import net.sf.parteg.base.testcasetree.generated.TCGNode;
import net.sf.parteg.base.testcasetree.generated.TCGParameter;
import net.sf.parteg.base.testcasetree.generated.TCGTransition;
import net.sf.parteg.base.testcasetree.ocl.TestCaseGraphHelper;

public class TestCaseGraphFindLeavesWithEmptyEqClassVisitor implements TestCaseGraphVisitor {

	private ArrayList<TCGNode> m_colNodesWithEmptyEquivalenceClasses;
	
	public TestCaseGraphFindLeavesWithEmptyEqClassVisitor()
	{
		m_colNodesWithEmptyEquivalenceClasses = new ArrayList<TCGNode>();
	}
	
	public ArrayList<TCGNode> getNodesWithEmptyEquivalenceClasses()
	{
		return m_colNodesWithEmptyEquivalenceClasses;
	}
	
	public void check(TCGNode in_oNode) {
		//if(in_oNode.getOutgoingTransitions().size() == 0)
		{
			for(TCGParameter oParameter : in_oNode.getParameters())
			{
				if(TestCaseGraphHelper.isEquivalenceClassEmpty(oParameter))
				{
					m_colNodesWithEmptyEquivalenceClasses.add(in_oNode);
					return;
				}
			}
		}
	}

	public void check(TCGTransition in_oTransition) {
		// do nothing
	}
}
