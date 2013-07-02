package net.sf.parteg.base.testcasegraph.config;

import java.util.HashMap;
import java.util.LinkedHashMap;

import net.sf.parteg.base.testcasegraph.testgoals.prioritization.HierarchicalPrioritizationCombination;
import net.sf.parteg.base.testcasegraph.testgoals.prioritization.WeightedPrioritizationCombination;
import net.sf.parteg.core.output.PrioritizationStatistics;

public class ConfigurationTestGoalPrioritization {

	// test goal priorizitation
	public enum TestGoalPrioritization
	{
		RANDOM,
		FAR_ELEMENTS_FIRST,
		FAR_ELEMENTS_LAST,
		HIGH_BRANCHING_FACTOR_FIRST,
		HIGH_BRANCHING_FACTOR_LAST,
		MANY_ATOMS_FIRST,
		MANY_ATOMS_LAST,
		HIGH_POSITIVE_ATOMS_RATIO_FIRST,
		HIGH_POSITIVE_ATOMS_RATIO_LAST,
		HIERARCHICAL_COMBINATION,
		WEIGHTED_COMBINATION
	}

	private static HashMap<String, TestGoalPrioritization> sm_colName2TestGoalPrioritization = getDefaultTestGoalPrioritizations();
	private static TestGoalPrioritization sm_oTestGoalPriorizitation = TestGoalPrioritization.FAR_ELEMENTS_FIRST;
	private static PrioritizationStatistics sm_PrioritizationsStatistics = null;

	private static HashMap<String, TestGoalPrioritization> getDefaultTestGoalPrioritizations() {
		HashMap<String, TestGoalPrioritization> colResultValue =
			new LinkedHashMap<String, TestGoalPrioritization>();
		colResultValue.put("Random", 
				TestGoalPrioritization.RANDOM);
		colResultValue.put("Far Elements First", 
				TestGoalPrioritization.FAR_ELEMENTS_FIRST);
		colResultValue.put("Far Elements Last", 
				TestGoalPrioritization.FAR_ELEMENTS_LAST);
		colResultValue.put("High Branching Factor First", 
				TestGoalPrioritization.HIGH_BRANCHING_FACTOR_FIRST);
		colResultValue.put("High Branching Factor Last", 
				TestGoalPrioritization.HIGH_BRANCHING_FACTOR_LAST);
		colResultValue.put("Many Atomar Conditions First", 
				TestGoalPrioritization.MANY_ATOMS_FIRST);
		colResultValue.put("Many Atomar Conditions Last", 
				TestGoalPrioritization.MANY_ATOMS_LAST);
		colResultValue.put("High Positive Atoms Ratio First", 
				TestGoalPrioritization.HIGH_POSITIVE_ATOMS_RATIO_FIRST);
		colResultValue.put("High Positive Atoms Ratio Last", 
				TestGoalPrioritization.HIGH_POSITIVE_ATOMS_RATIO_LAST);
	
		return colResultValue;
	}

	public static PrioritizationStatistics getPrioritizationStatistics()
	{
		if(sm_PrioritizationsStatistics == null)
			sm_PrioritizationsStatistics = new PrioritizationStatistics();
		return sm_PrioritizationsStatistics;
	}

	public static TestGoalPrioritization getTestGoalPrioritization()
	{
		return sm_oTestGoalPriorizitation;
	}

	public static HashMap<String, TestGoalPrioritization> getTestGoalPrioritizations() {
		return sm_colName2TestGoalPrioritization;
	}

	public static void setTestGoalPrioritization(TestGoalPrioritization in_oTGP)
	{
		sm_oTestGoalPriorizitation = in_oTGP;
	}

	public static void setPrioritizationStatistics(PrioritizationStatistics in_oValue)
	{
		sm_PrioritizationsStatistics = in_oValue;
	}

	private static HierarchicalPrioritizationCombination sm_oHierarchicalPrioritizationCombination;
	private static WeightedPrioritizationCombination sm_oWeightedPrioritizationCombination;

	public static HierarchicalPrioritizationCombination getHierarchicalPrioritizationCombination() {
		return sm_oHierarchicalPrioritizationCombination;
	}

	public static WeightedPrioritizationCombination getWeightedPrioritizationCombination() {
		return sm_oWeightedPrioritizationCombination;
	}

	public static void setHierarchicalPrioritizationCombination(
			HierarchicalPrioritizationCombination in_oValue) {
		sm_oHierarchicalPrioritizationCombination = in_oValue;
	}

}
