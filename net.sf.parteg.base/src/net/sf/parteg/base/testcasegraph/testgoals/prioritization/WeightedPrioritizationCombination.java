package net.sf.parteg.base.testcasegraph.testgoals.prioritization;

import net.sf.parteg.base.testcasegraph.config.ConfigurationTestGoalPrioritization.TestGoalPrioritization;

public class WeightedPrioritizationCombination {

	private TestGoalPrioritization m_oFirstPrioritization;
	private Double m_nFirstFactor;
	private TestGoalPrioritization m_oSecondPrioritization;
	private Double m_nSecondFactor;
	
	public WeightedPrioritizationCombination() {
		m_oFirstPrioritization = TestGoalPrioritization.RANDOM;
		m_nFirstFactor = 0.0;
		m_oSecondPrioritization = TestGoalPrioritization.RANDOM;
		m_nSecondFactor = 0.0;
	}
	
	public void setFirstPrioritization(TestGoalPrioritization in_oValue) {
		m_oFirstPrioritization = in_oValue;
	}
	public void setFirstFactor(Double in_nValue) {
		m_nFirstFactor = in_nValue;
	}
	public void setSecondPrioritization(TestGoalPrioritization in_oValue) {
		m_oSecondPrioritization = in_oValue;
	}
	public void setSecondFactor(Double in_nValue) {
		m_nSecondFactor = in_nValue;
	}
	
	
	public TestGoalPrioritization getFirstPrioritization() {
		return m_oFirstPrioritization;
	}
	public Double getFirstFactor() {
		return m_nFirstFactor;
	}
	public TestGoalPrioritization getSecondPrioritization() {
		return m_oSecondPrioritization;
	}
	public Double getSecondFactor() {
		return m_nSecondFactor;
	}
	
}
