package net.sf.parteg.base.testcasegraph.testsuite;

import java.util.ArrayList;

import net.sf.parteg.base.testcasegraph.generated.TCGEvent;
import net.sf.parteg.base.testcasegraph.generated.TCGParameter;
import net.sf.parteg.base.testcasegraph.testgeneration.LateEvaluationGroup;
import net.sf.parteg.base.testcasegraph.testgoals.TestGoalBase;

public class TestCase {

	private ArrayList<TransitionInstance> m_colTransitionInstances;
	private ArrayList<LateEvaluationGroup> m_colLateEvaluationGroups;
	
	// constructor
	public TestCase()
	{
		m_colTransitionInstances = new ArrayList<TransitionInstance>();
		m_colLateEvaluationGroups = new ArrayList<LateEvaluationGroup>();
	}
	
	// getter
	public ArrayList<TransitionInstance> getTransitionInstances() {
		return m_colTransitionInstances;
	}
	
	public ArrayList<LateEvaluationGroup> getLateEvaluationGroups() {
		return m_colLateEvaluationGroups;
	}
	
	public boolean checkSatisfactionOfTestGoal(TestGoalBase in_oTestGoal)
	{
		return in_oTestGoal.checkSatisfactionByTestCase(this);
	}
	
	public ArrayList<EventParameterInstance> getAllParameterInstances()
	{
		ArrayList<EventParameterInstance> colParameterInstances = 
			new ArrayList<EventParameterInstance>();
		
		for(TransitionInstance oTransitionInstance : m_colTransitionInstances)
		{
			colParameterInstances.addAll(oTransitionInstance.getParameterInstances());
		}
		
		return colParameterInstances;
	}
	
	/*
	 * has the effect of connecting transition instances
	 * result: a double-linked list
	 */
	public void connectTransitionInstances()
	{
		for(int i = 1; i < m_colTransitionInstances.size(); ++i)
		{
			m_colTransitionInstances.get(i).setPrecedingTransitionInstance(
					m_colTransitionInstances.get(i-1));
			
			m_colTransitionInstances.get(i-1).setSucceedingTransitionInstance(
					m_colTransitionInstances.get(i));
		}
	}
	
	/*
	 * adds missing parameter instances
	 * if there are no conditions on parameter instances and
	 * there are, consequently, no parameter instances: create default values
	 */
	public void createMissingParameterInstances()
	{
		for(TransitionInstance oTransitionInstance : m_colTransitionInstances)
		{
			TCGEvent oEvent = oTransitionInstance.getCalledEvent();
			if((oEvent != null) && 
				(oEvent.getParameters() != null) &&
				!(oEvent.getParameters().isEmpty()))
			{
				for(TCGParameter oParameter : oEvent.getParameters())
				{
					boolean bFound = false;
					for(EventParameterInstance oEPInstance : oTransitionInstance.getParameterInstances())
					{
						if(oParameter.equals(oEPInstance.getSuperParameter()))
						{
							bFound = true;
							break;
						}
					}
					if(bFound == false)
					{
						EventParameterInstance oEPInstance = 
							new EventParameterInstance(oParameter, oTransitionInstance);
						oTransitionInstance.getParameterInstances().add(oEPInstance);
					}
				}
			}
		}
	}
}
