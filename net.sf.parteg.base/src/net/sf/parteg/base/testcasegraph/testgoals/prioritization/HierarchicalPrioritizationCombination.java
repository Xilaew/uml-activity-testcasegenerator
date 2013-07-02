package net.sf.parteg.base.testcasegraph.testgoals.prioritization;

import net.sf.parteg.base.testcasegraph.config.ConfigurationTestGoalPrioritization.TestGoalPrioritization;

public class HierarchicalPrioritizationCombination {
	
	private TestGoalPrioritization m_oPrimaryPrioritization;
	private TestGoalPrioritization m_oSecondaryPrioritization;
	
	public HierarchicalPrioritizationCombination() {
		m_oPrimaryPrioritization = TestGoalPrioritization.RANDOM;
		m_oSecondaryPrioritization = TestGoalPrioritization.RANDOM;
	}
	
	public void setPrimaryPrioritization(TestGoalPrioritization in_oValue) {
		m_oPrimaryPrioritization = in_oValue;
	}
	
	public void setSecondaryPrioritization(TestGoalPrioritization in_oValue) {
		m_oSecondaryPrioritization = in_oValue;
	}
	
	public TestGoalPrioritization getPrimaryPrioritization() {
		return m_oPrimaryPrioritization;
	}
	public TestGoalPrioritization getSecondaryPrioritization() {
		return m_oSecondaryPrioritization;
	}
}
