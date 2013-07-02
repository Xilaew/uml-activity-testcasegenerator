package net.sf.parteg.base.testcasegraph.testgoals;

import java.util.Comparator;
import java.util.HashMap;

public class TestGoalComparator implements Comparator<TestGoalBase>
{
	HashMap<TestGoalBase, Double> m_colGoalsCompare;
	boolean m_bLowCompareValueFirst;
	
	public TestGoalComparator(
			HashMap<TestGoalBase, Double> in_colGoalsCompare,
			boolean in_bLowCompareValueFirst)
	{
		m_colGoalsCompare = in_colGoalsCompare;
		m_bLowCompareValueFirst = in_bLowCompareValueFirst;
	}
	
	@Override
	public int compare(TestGoalBase o1, TestGoalBase o2) {
		if(m_colGoalsCompare.get(o1) < m_colGoalsCompare.get(o2)) {
			if(m_bLowCompareValueFirst) 
				return -1;
			else
				return 1;
		}
		if(m_colGoalsCompare.get(o1) > m_colGoalsCompare.get(o2)) {
			if(m_bLowCompareValueFirst) 
				return 1;
			else
				return -1;
		}
		return 0;
	}
}
