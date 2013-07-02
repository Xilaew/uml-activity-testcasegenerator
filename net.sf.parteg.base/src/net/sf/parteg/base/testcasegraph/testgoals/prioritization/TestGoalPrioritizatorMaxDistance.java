package net.sf.parteg.base.testcasegraph.testgoals.prioritization;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import net.sf.parteg.base.testcasegraph.config.ConfigurationTestPathSearchStrategy;
import net.sf.parteg.base.testcasegraph.config.ConfigurationTestGoalPrioritization.TestGoalPrioritization;
import net.sf.parteg.base.testcasegraph.generated.TCGNode;
import net.sf.parteg.base.testcasegraph.testgoals.TestGoalBase;

public class TestGoalPrioritizatorMaxDistance implements TestGoalPrioritizator {
	
	private TestGoalPrioritization m_oTestGoalPrioritization;
	
	public TestGoalPrioritizatorMaxDistance(TestGoalPrioritization in_oTestGoalPrioritization) {
		m_oTestGoalPrioritization = in_oTestGoalPrioritization;
	}

	public void sort(List<TestGoalBase> io_colGoals)
	{
		if(m_oTestGoalPrioritization.equals(
				TestGoalPrioritization.FAR_ELEMENTS_FIRST)) {
			for(TestGoalBase oGoal : io_colGoals) {
				oGoal.setPriority((double)((TCGNode)oGoal.getElement()).getMaxDistanceFromStart());
			}
			
			Collections.sort(io_colGoals, new Comparator<TestGoalBase> ()
				{
					@Override
					public int compare(TestGoalBase o1, TestGoalBase o2) {
						int nDistance1 = 0;
						int nDistance2 = 0;
						if(o1.getElement() instanceof TCGNode) {
							nDistance1 = getCurrentlyUsedDistance((TCGNode)o1.getElement());
						}
						if(o2.getElement() instanceof TCGNode) {
							nDistance2 = getCurrentlyUsedDistance((TCGNode)o2.getElement());
						}
						if(nDistance1 < nDistance2)
							return 1;
						else if(nDistance1 > nDistance2)
							return -1;
						return 0;
					}
				});
		}
		else if(m_oTestGoalPrioritization.equals(
				TestGoalPrioritization.FAR_ELEMENTS_LAST)) {
			for(TestGoalBase oGoal : io_colGoals) {
				oGoal.setPriority((double)((TCGNode)oGoal.getElement()).getMaxDistanceFromStart());
			}

			Collections.sort(io_colGoals, new Comparator<TestGoalBase> ()
					{
						@Override
						public int compare(TestGoalBase o1, TestGoalBase o2) {
							int nDistance1 = 0;
							int nDistance2 = 0;
							if(o1.getElement() instanceof TCGNode) {
								nDistance1 = getCurrentlyUsedDistance((TCGNode)o1.getElement());
							}
							if(o2.getElement() instanceof TCGNode) {
								nDistance2 = getCurrentlyUsedDistance((TCGNode)o2.getElement());
							}
							if(nDistance1 < nDistance2)
								return -1;
							else if(nDistance1 > nDistance2)
								return 1;
							return 0;
						}
					});
		}
	}
	
	private int getCurrentlyUsedDistance(TCGNode in_oNode) 
	{
		if(ConfigurationTestPathSearchStrategy.getTestPathSearchStrategy().equals(
				ConfigurationTestPathSearchStrategy.TestPathSearchStrategy.TRANSITIONS_TO_NEAR_NODES_FIRST)) {
			return in_oNode.getMinDistanceFromStart();
		}
		return in_oNode.getMaxDistanceFromStart();
	}
}
