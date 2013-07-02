package net.sf.parteg.base.testcasegraph.testgoals.prioritization;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import net.sf.parteg.base.testcasegraph.testgoals.TestGoalBase;

public class TestGoalPrioritizatorRandom implements TestGoalPrioritizator {

	public void sort(List<TestGoalBase> io_colGoals)
	{
		Random oRandom = new Random(
				(long)(Math.random() * Integer.MAX_VALUE));
		Collections.shuffle(io_colGoals, oRandom);
		for(TestGoalBase oGoal : io_colGoals) {
			oGoal.setPriority(1.0);
		}
	}
}
