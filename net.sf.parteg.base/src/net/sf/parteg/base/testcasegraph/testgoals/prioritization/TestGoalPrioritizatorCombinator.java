package net.sf.parteg.base.testcasegraph.testgoals.prioritization;

import java.util.ArrayList;
import java.util.List;

import net.sf.parteg.base.testcasegraph.testgoals.TestGoalBase;

public class TestGoalPrioritizatorCombinator implements TestGoalPrioritizator {

	private TestGoalPrioritizator m_oPrimaryPrioritizator;
	private TestGoalPrioritizator m_oSecondaryPrioritizator;
	
	public TestGoalPrioritizatorCombinator(
			TestGoalPrioritizator in_oPrimaryPrioritizator,
			TestGoalPrioritizator in_oSecondaryPrioritizator)
	{
		m_oPrimaryPrioritizator = in_oPrimaryPrioritizator;
		m_oSecondaryPrioritizator = in_oSecondaryPrioritizator;
	}
	
	@Override
	public void sort(List<TestGoalBase> io_colGoals) {
		m_oPrimaryPrioritizator.sort(io_colGoals);
		List<List<TestGoalBase>> colGoalGroups = 
			splitIntoGroupOfEqualPriority(io_colGoals);
		for(List<TestGoalBase> oGoalGroup : colGoalGroups) {
			m_oSecondaryPrioritizator.sort(oGoalGroup);
		}
		uniteGroups(io_colGoals, colGoalGroups);
	}

	private List<List<TestGoalBase>> splitIntoGroupOfEqualPriority(
			List<TestGoalBase> io_colGoals)
	{
		List<List<TestGoalBase>> colRetValue = new ArrayList<List<TestGoalBase>>();
		Double oCurrentPriority = null;
		List<TestGoalBase> colCurrentGroup = null;
		for(TestGoalBase oTestGoal : io_colGoals) {
			if(!oTestGoal.getPriority().equals(oCurrentPriority)) {
				oCurrentPriority = oTestGoal.getPriority();
				colCurrentGroup = new ArrayList<TestGoalBase>();
				colRetValue.add(colCurrentGroup);
			}
			colCurrentGroup.add(oTestGoal);
		}
		return colRetValue;
	}
	
	private void uniteGroups(List<TestGoalBase> io_colGoals, 
			List<List<TestGoalBase>> in_colGroups) {
		io_colGoals.clear();
		for(List<TestGoalBase> oGroup : in_colGroups) {
			io_colGoals.addAll(oGroup);
		}
	}
}
