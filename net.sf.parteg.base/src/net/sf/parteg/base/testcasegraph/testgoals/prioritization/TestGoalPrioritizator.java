package net.sf.parteg.base.testcasegraph.testgoals.prioritization;

import java.util.List;

import net.sf.parteg.base.testcasegraph.testgoals.TestGoalBase;

public interface TestGoalPrioritizator {

	public void sort(List<TestGoalBase> io_colGoals);
}
