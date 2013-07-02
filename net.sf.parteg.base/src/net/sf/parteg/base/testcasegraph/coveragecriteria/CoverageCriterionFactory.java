package net.sf.parteg.base.testcasegraph.coveragecriteria;

import net.sf.parteg.base.testcasegraph.config.ConfigurationCoverageCriteria;

public class CoverageCriterionFactory {

	public static ControlFlowOrientedCoverage createCoverageCriterion(
			ConfigurationCoverageCriteria.ControlFlowBasedCoverageCriterion in_oCoverageEnumValue)
	{
		ControlFlowOrientedCoverage oCoverageCriterion = null;
		if(in_oCoverageEnumValue.equals(
				ConfigurationCoverageCriteria.ControlFlowBasedCoverageCriterion.CONDITION_COVERAGE))
		{
			oCoverageCriterion = new ConditionCoverage();
		}
		else if(in_oCoverageEnumValue.equals(
				ConfigurationCoverageCriteria.ControlFlowBasedCoverageCriterion.DECISION_COVERAGE))
		{
			oCoverageCriterion = new DecisionCoverage();
		}
		else if(in_oCoverageEnumValue.equals(
				ConfigurationCoverageCriteria.ControlFlowBasedCoverageCriterion.MODIFIED_CONDITION_DECISION_COVERAGE))
		{
			oCoverageCriterion = new ModifiedConditionDecisionCoverage();
		}
		else if(in_oCoverageEnumValue.equals(
				ConfigurationCoverageCriteria.ControlFlowBasedCoverageCriterion.MULTIPLE_CONDITION_COVERAGE))
		{
			oCoverageCriterion = new MultipleConditionCoverage();
		}
		return oCoverageCriterion;
	}
}
