package net.sf.parteg.base.testcasetree.actions;

import net.sf.parteg.base.testcasetree.generated.TCGNode;
import net.sf.parteg.base.testcasetree.ocl.TestCaseGraphHelper;



public class TestCaseGraphAddNodeAction implements TestCaseGraphAction {

	private TCGNode m_oOldSourceNode;
	private TCGNode m_oNewTargetNode;
	private TestCaseGraphHelper m_oTestCaseGraphHelper;

	public TestCaseGraphAddNodeAction(TestCaseGraphHelper in_oTestCaseGraphHelper,
			TCGNode in_oOldSourceNode)
	{
		m_oTestCaseGraphHelper = in_oTestCaseGraphHelper;
		m_oOldSourceNode = in_oOldSourceNode;
		m_oNewTargetNode = null;
	}
	
	public TCGNode getNode()
	{
		return m_oNewTargetNode;
	}
	
	public void execute() 
	{
		m_oNewTargetNode = m_oTestCaseGraphHelper.addNode();
		m_oTestCaseGraphHelper.addTransition(m_oOldSourceNode, m_oNewTargetNode);
		m_oNewTargetNode.setDistanceToRoot(m_oOldSourceNode.getDistanceToRoot() + 1);
	}

	public void reverse() {
		m_oTestCaseGraphHelper.removeNode(m_oNewTargetNode);
	}

}
