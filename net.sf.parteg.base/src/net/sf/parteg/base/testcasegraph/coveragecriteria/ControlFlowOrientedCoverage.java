package net.sf.parteg.base.testcasegraph.coveragecriteria;

import java.util.ArrayList;
import java.util.List;

import net.sf.parteg.base.testcasegraph.config.ConfigurationCoverageCriteria;
import net.sf.parteg.base.testcasegraph.generated.TCGDisjunctiveNormalForm;
import net.sf.parteg.base.testcasegraph.helperclasses.TCGDisjunctiveNormalFormHelperClass;
import net.sf.parteg.base.testcasegraph.helperclasses.TCGEventHelperClass;
import net.sf.parteg.base.testcasegraph.testgoals.TestGoalBase;
import net.sf.parteg.base.testcasegraph.testgoals.TestGoalGuardConditions;

public abstract class ControlFlowOrientedCoverage {

	/*
	 * creates several conjunctions corresponding to the expressions for the test goals
	 */
	public abstract ArrayList<TCGDisjunctiveNormalForm> createDNFsForTestGoals(
			TCGDisjunctiveNormalForm in_oOriginalDNF);
	
	
	
	public boolean testGoalIsAlreadySatisfiedInSetOfGoals(
			TestGoalGuardConditions in_oTestGoal,
			List<TestGoalBase> in_colTestGoals,
			boolean in_bBoundariesMatchExactly)
	{
		for(TestGoalBase oTestGoalFromSet : in_colTestGoals)
		{
			if(oTestGoalFromSet.getElement().equals(in_oTestGoal.getElement()))
			{
				if(oTestGoalFromSet instanceof TestGoalGuardConditions)
				{
					TestGoalGuardConditions oTestGoalEventFromSet = (TestGoalGuardConditions)oTestGoalFromSet;
					
					if(TCGEventHelperClass.eventsAreEqual(
							in_oTestGoal.getEventToBeCalled(),
							oTestGoalEventFromSet.getEventToBeCalled()) &&
						TCGDisjunctiveNormalFormHelperClass.firstDNFIsSatisfiedBySecondDNF(
							in_oTestGoal.getDNFToBeSatisfied(), 
							oTestGoalEventFromSet.getDNFToBeSatisfied(),
							in_bBoundariesMatchExactly))
					{
						return true;
					}
				}
			}
		}
		return false;
	}



	public static boolean isControlFlowOrientedCoverage(
			ConfigurationCoverageCriteria.ControlFlowBasedCoverageCriterion in_oCoverageEnumValue) {
		return 
			in_oCoverageEnumValue.equals(
					ConfigurationCoverageCriteria.ControlFlowBasedCoverageCriterion.TRANSITION_COVERAGE) ||
			in_oCoverageEnumValue.equals(
					ConfigurationCoverageCriteria.ControlFlowBasedCoverageCriterion.CONDITION_COVERAGE) ||
			in_oCoverageEnumValue.equals(
					ConfigurationCoverageCriteria.ControlFlowBasedCoverageCriterion.DECISION_COVERAGE) ||
			in_oCoverageEnumValue.equals(
					ConfigurationCoverageCriteria.ControlFlowBasedCoverageCriterion.MODIFIED_CONDITION_DECISION_COVERAGE) ||
			in_oCoverageEnumValue.equals(
					ConfigurationCoverageCriteria.ControlFlowBasedCoverageCriterion.MULTIPLE_CONDITION_COVERAGE);
	}
		
}
