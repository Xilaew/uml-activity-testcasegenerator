package net.sf.parteg.base.testcasegraph.testgoals;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import net.sf.parteg.base.testcasegraph.generated.TCGElement;
import net.sf.parteg.base.testcasegraph.generated.TCGNode;
import net.sf.parteg.base.testcasegraph.generated.TCGTransition;


public class TestGoalManager {

	private List<TestGoalBase> m_colTestGoals;
	private Map<TCGElement, List<TestGoalBase>> m_colMappedTestGoals;
	
	public TestGoalManager() {
		m_colTestGoals = new ArrayList<TestGoalBase>();
		m_colMappedTestGoals = new LinkedHashMap<TCGElement, List<TestGoalBase>>();
	}
	
	public List<TestGoalBase> getTestGoals() {
		return m_colTestGoals;
	}

	public List<TestGoalBase> getTestGoals(TCGElement in_oReferencedElement) {
		List<TestGoalBase> colTestGoals = m_colMappedTestGoals.get(in_oReferencedElement);
		if(colTestGoals == null) {
			colTestGoals = new ArrayList<TestGoalBase>();
			m_colMappedTestGoals.put(in_oReferencedElement, colTestGoals);
		}
		return colTestGoals;
	}

	public void addTestGoal(TestGoalBase in_oTestGoal)
	{
		getTestGoals().add(in_oTestGoal);
		if(in_oTestGoal.getElement() instanceof TCGNode) {
			getTestGoals(in_oTestGoal.getElement()).add(in_oTestGoal);
		}
		else if(in_oTestGoal.getElement() instanceof TCGTransition) {
			TCGNode oNode = 
				(TCGNode)((TCGTransition)(in_oTestGoal.getElement())).getSourceNode();
			getTestGoals(oNode).add(in_oTestGoal);
		}
	}
	
	public void addAllTestGoals(List<? extends TestGoalBase> in_colTestGoals)
	{
		for(TestGoalBase oTestGoal : in_colTestGoals)
			addTestGoal(oTestGoal);
	}

	public int getNumberOfSatisfiedTestGoals()
	{
		int nCount = 0;
		for(TestGoalBase oTestGoal : getTestGoals())
		{
			if(oTestGoal.isSatisfied())
				++nCount;
		}
		return nCount;
	}
	
	public double getPercentageOfSatisfiedTestGoals()
	{
		double nCount = 0;
		for(TestGoalBase oTestGoal : getTestGoals())
		{
			if(oTestGoal.isSatisfied())
				++nCount;
		}
		return nCount / (double)getTestGoals().size();
	}
}
