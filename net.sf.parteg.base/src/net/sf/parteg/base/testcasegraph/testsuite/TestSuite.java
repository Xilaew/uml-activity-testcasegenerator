package net.sf.parteg.base.testcasegraph.testsuite;

import java.util.ArrayList;


public class TestSuite {

	private ArrayList<TestCase> m_colTestCases;
	
	public TestSuite()
	{
		m_colTestCases = new ArrayList<TestCase>();
	}

	public ArrayList<TestCase> getTestCases() {
		return m_colTestCases;
	}
	
	public Integer getTotalNumberOfEventCalls()
	{
		Integer nTotalNumberOfEventCalls = 0;
		for(TestCase oTestCase : getTestCases()) {
			for(TransitionInstance oTransitionInstance : oTestCase.getTransitionInstances()) {
				if(oTransitionInstance.getCalledEvent() != null &&
						!oTransitionInstance.getCalledEvent().isDefaultEvent()) {
					++nTotalNumberOfEventCalls;
				}
			}
		}
		return nTotalNumberOfEventCalls;
	}
}
