package net.sf.parteg.base.testcasegraph.testgoals;

import net.sf.parteg.base.testcasegraph.generated.TCGElement;
import net.sf.parteg.base.testcasegraph.ocl.TestCaseGraphHelper;
import net.sf.parteg.base.testcasegraph.testsuite.TestCase;
import net.sf.parteg.base.testcasegraph.testsuite.TransitionInstance;

public abstract class TestGoalBase {

	// is the test goal satisfied?
	protected boolean m_bSatisfied;
	private Double m_nPriority;
	
	public abstract TCGElement getElement();

	public TestGoalBase()
	{
		m_bSatisfied = false;
	}
	
	public boolean isSatisfied()
	{
		return m_bSatisfied;
	}
	
	public void setSatisfied(boolean in_bSatisfied)
	{
		m_bSatisfied = in_bSatisfied;
	}
	
	public abstract boolean checkSatisfactionByTestCase(TestCase in_oTestCase);

	public abstract boolean checkSatisfactionByTransitionInstance(
			TransitionInstance in_oTransitionInstance);

	public abstract boolean containsNoCondition();
	
	public abstract boolean testCaseGenerationAllowed();
	
	public abstract TestCase createTestCase(TestCaseGraphHelper in_oTCGHelper);
	
	public Double getPriority() {
		return m_nPriority;
	}
	
	public void setPriority(Double in_nPriority) {
		m_nPriority = in_nPriority;
	}
}