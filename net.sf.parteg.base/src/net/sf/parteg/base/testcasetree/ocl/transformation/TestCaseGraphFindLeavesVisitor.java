package net.sf.parteg.base.testcasetree.ocl.transformation;

import java.util.ArrayList;

import net.sf.parteg.base.testcasetree.generated.TCGNode;
import net.sf.parteg.base.testcasetree.generated.TCGTransition;


public class TestCaseGraphFindLeavesVisitor implements TestCaseGraphVisitor {

	private ArrayList<TCGNode> m_colLeaves;
	
	public TestCaseGraphFindLeavesVisitor()
	{
		m_colLeaves = new ArrayList<TCGNode>();
	}
	
	public ArrayList<TCGNode> getLeaves()
	{
		return m_colLeaves;
	}
	
	public void check(TCGNode in_oNode) {
		if(in_oNode.getOutgoingTransitions().size() == 0)
			m_colLeaves.add(in_oNode);
	}

	public void check(TCGTransition in_oTransition) {
		// do nothing
	}

}
