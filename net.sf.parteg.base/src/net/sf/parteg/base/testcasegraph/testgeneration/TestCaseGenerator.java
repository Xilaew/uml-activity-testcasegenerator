package net.sf.parteg.base.testcasegraph.testgeneration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import net.sf.parteg.base.testcasegraph.config.Configuration;
import net.sf.parteg.base.testcasegraph.config.ConfigurationTestGoalPrioritization;
import net.sf.parteg.base.testcasegraph.generated.TCGNode;
import net.sf.parteg.base.testcasegraph.helperclasses.TCGNodeHelperClass;
import net.sf.parteg.base.testcasegraph.ocl.TestCaseGraphHelper;
import net.sf.parteg.base.testcasegraph.testgoals.TestGoalBase;
import net.sf.parteg.base.testcasegraph.testsuite.TestCase;
import net.sf.parteg.base.testcasegraph.testsuite.TestSuite;
import net.sf.parteg.base.testcasegraph.testsuite.TransitionInstance;

public class TestCaseGenerator {

	private TestCaseGraphHelper m_oTCGHelper;
	private TestSuite m_oTestSuite;
	private HashMap<TestGoalBase, ArrayList<TestCase>> m_colTestGoalsToTestCases;
	private HashMap<TestCase, ArrayList<TestGoalBase>> m_colTestCasesToTestGoals;
	
	public TestCaseGenerator(
		TestCaseGraphHelper in_oTCGHelper) {
		m_oTCGHelper = in_oTCGHelper;
		m_oTestSuite = new TestSuite();
		m_colTestGoalsToTestCases = new LinkedHashMap<TestGoalBase, ArrayList<TestCase>>();
		m_colTestCasesToTestGoals = new LinkedHashMap<TestCase, ArrayList<TestGoalBase>>();
	}
	
	/*
	 * creates a test cases for each defined test goal
	 */
	public void createTestCases()
	{
		int i = 0;

		if(Configuration.getLoggerlevel() == Configuration.LoggerLevel.MAXIMUM) {
//			m_oTCGHelper.getLogger().getFormattedOutput().appendln("### Test Case Creation");
//			System.out.println("number of test goals: " + m_oTCGHelper.getTestGoalMgr().getTestGoals().size());
		}
		
		// create test cases for each goal
		for(TestGoalBase oTestGoal : m_oTCGHelper.getTestGoalMgr().getTestGoals())
		{
			if(Configuration.getLoggerlevel() == Configuration.LoggerLevel.MAXIMUM) {
				System.out.println(" ... " + ++i + ". test goal");
				System.out.flush();
			}
			// test goal still not satisfied?
			if(oTestGoal.isSatisfied() == false) {
			
//				if(i == 66) {
//					int x = 42;
//					++x;
////					createTestCaseForTestGoal(oTestGoal);
//				}

				// ### create test case ###
//				if(m_oTestSuite.getTestCases().size() == 17) {
//					int x = 42;
//					++x;
//				}
				createTestCaseForTestGoal(oTestGoal);
//				if(m_oTestSuite.getTestCases().size() == 18) {
//					int x = 42;
//					++x;
//				}
				
			}
			else {				
			}
		}
		
//		// log - before clean up
//		int nNumberOfCreatedTestCases = m_oTestSuite.getTestCases().size();
//		int nNumberOfCreatedEventCalls = m_oTestSuite.getTotalNumberOfEventCalls();
//		// clean up test suite
		removeEmptyTestCases();
		if(Configuration.isPostOptimizationEnabled())
			removeRedundantTestCases();
//		// log - after clean up		
//		int nNumberOfRemainingTestCases = m_oTestSuite.getTestCases().size(); 
//		int nNumberOfRemainingEventCalls = m_oTestSuite.getTotalNumberOfEventCalls();
//
//		writeStatisticsAndLogger(nNumberOfTestGoalsSatisfiedBeforeCreation,
//				nNumberOfCreatedTestCases, nNumberOfCreatedEventCalls,
//				nNumberOfRemainingTestCases, nNumberOfRemainingEventCalls);

	}
	
	private void writeStatisticsAndLogger(
			int in_nNumberOfTestGoalsSatisfiedBeforeCreation,
			int in_nNumberOfCreatedTestCases,
			int in_nNumberOfCreatedEventCalls, 
			int in_nNumberOfRemainingTestCases,
			int in_nNumberOfRemainingEventCalls) {
		
		ConfigurationTestGoalPrioritization.getPrioritizationStatistics().addTestSuiteTestCases(
				(double)in_nNumberOfRemainingTestCases);
		ConfigurationTestGoalPrioritization.getPrioritizationStatistics().addTestSuiteSystemCalls(
				(double)in_nNumberOfRemainingEventCalls);
		ConfigurationTestGoalPrioritization.getPrioritizationStatistics().addCreationEarlySatisfiedTestGoals(
				(double)in_nNumberOfTestGoalsSatisfiedBeforeCreation);
		
		if(Configuration.getLoggerlevel() == Configuration.LoggerLevel.MAXIMUM) {
			m_oTCGHelper.getLogger().getFormattedOutput().appendln("    " + in_nNumberOfTestGoalsSatisfiedBeforeCreation
					+ " test goals were already satisfied before a test case for them could be created");			
			m_oTCGHelper.getLogger().getFormattedOutput().appendln("    " + in_nNumberOfCreatedTestCases
					+ " test cases were created");			
			m_oTCGHelper.getLogger().getFormattedOutput().appendln("    " + in_nNumberOfRemainingTestCases
					+ " remain after post-optimization");			
			m_oTCGHelper.getLogger().getFormattedOutput().appendln("    " + in_nNumberOfCreatedEventCalls
					+ " event calls were created");			
			m_oTCGHelper.getLogger().getFormattedOutput().appendln("    " + in_nNumberOfRemainingEventCalls
					+ " remain after post-optimization");			
		}		
	}

	/*
	 * return if a test case was created for the test goal
	 */
	private boolean createTestCaseForTestGoal(TestGoalBase in_oTestGoal)
	{
		if(in_oTestGoal.testCaseGenerationAllowed()) {
			
			TestCase oTestCase = in_oTestGoal.createTestCase(m_oTCGHelper);
			
			if(oTestCase != null)
			{
				m_oTestSuite.getTestCases().add(oTestCase);
//				if(!oTestCase.checkSatisfactionOfTestGoal(in_oTestGoal)) {
//					in_oTestGoal.setSatisfied(true);
//					addTestGoalTestCaseCombination(in_oTestGoal, oTestCase);						
//				}
				checkSatisfiedTestGoalsAccordingToTestCase(oTestCase);
				// overall check did not detect this test goal satisfaction 
//				if(!in_oTestGoal.isSatisfied()) {
//					in_oTestGoal.setSatisfied(true);
//					addTestGoalTestCaseCombination(in_oTestGoal, oTestCase);
//				}
				return true;
			}
		}
		return false;
	}
	
	private void checkSatisfiedTestGoalsAccordingToTestCase(TestCase in_oTestCase)
	{
//		// comparison: compare each test goal to each transition instance of the test case
//		for(TestGoalBase oTestGoal : m_oTCGHelper.getTestGoalMgr().getTestGoals())
//		{
//			if(in_oTestCase.checkSatisfactionOfTestGoal(oTestGoal))
//			{
//				oTestGoal.setSatisfied(true);
//				addTestGoalTestCaseCombination(oTestGoal, in_oTestCase);
//			}
//		}

		// faster approach: compare only the test goals whose base element
		// is the source node of the current transition instance
		for(int i = 0; i < in_oTestCase.getTransitionInstances().size(); ++i) {
			TransitionInstance oTransitionInstance = in_oTestCase.getTransitionInstances().get(i);
//			TCGNode oSourceNode = oTransitionInstance.getSourceNode();
			TCGNode oSourceNode = oTransitionInstance.findLastVisitedNodeContainedOrEqualToCurrentNode();
			checkSatisfactionForNodeAndTransitionInstance( 
					oTransitionInstance, oSourceNode, in_oTestCase);
			checkSatisfactionForNodeAndTransitionInstance( 
					oTransitionInstance, oTransitionInstance.getTargetNode(), in_oTestCase);
		}
	}
	
	private void checkSatisfactionForNodeAndTransitionInstance(
			TransitionInstance in_oTransitionInstance,
			TCGNode in_oNode,
			TestCase in_oTestCase) {
		
//		for(TCGNode oNode : TCGNodeHelperClass.getAllSubNodesIncludingThis(in_oNode)) {
		for(TCGNode oNode : TCGNodeHelperClass.getAllSuperStatesIncludingThis(in_oNode)) {
			for(TestGoalBase oTestGoal : m_oTCGHelper.getTestGoalMgr().getTestGoals(oNode)) {
				if(oTestGoal.checkSatisfactionByTransitionInstance(in_oTransitionInstance)) {
					oTestGoal.setSatisfied(true);
					addTestGoalTestCaseCombination(oTestGoal, in_oTestCase);						
				}
			}				
		}		
	}
	
	public void removeEmptyTestCases()
	{
		ArrayList<TestCase> colRedundantTestCases = new ArrayList<TestCase>(); 
		for(TestCase oTestCase : m_oTestSuite.getTestCases())
		{
			if(oTestCase.getTransitionInstances().isEmpty())
				colRedundantTestCases.add(oTestCase);
		}
		m_oTestSuite.getTestCases().removeAll(colRedundantTestCases);
	}
	
	/*
	 * this operation identifies the sets of test goals that are satisfied
	 * by each test case and eliminates the test cases whose test goals are 
	 * completely satisfied by other test cases 
	 */
	public void removeRedundantTestCases()
	{
		ArrayList<TestCase> colRedundantTestCases = new ArrayList<TestCase>(); 
		// check for each test case if all its test goals are satisfied by 
		// more than one test case: if true, then eliminate
		for(TestCase oTestCase : m_oTestSuite.getTestCases())
		{
			boolean bAllTestGoalsAreRedundant = true;
			for(TestGoalBase oTestGoal : m_colTestCasesToTestGoals.get(oTestCase))
			{
				/* check only size == 1:
				 * if size > 2 then this test case is redundant
				 * size < 1 is impossible 
				 */ 
				if(m_colTestGoalsToTestCases.get(oTestGoal).size() == 1)
					bAllTestGoalsAreRedundant = false;
			}
			if(bAllTestGoalsAreRedundant == true)
			{
				// remove references to test case from hash maps
				// -> subsequent checks keep at least one test case for each test goal!
				colRedundantTestCases.add(oTestCase);
				for(TestGoalBase oTestGoal : m_colTestCasesToTestGoals.get(oTestCase))
				{
					m_colTestGoalsToTestCases.get(oTestGoal).remove(oTestCase);
				}
			}
		}
		
		// remove all redundant test cases
		m_oTestSuite.getTestCases().removeAll(colRedundantTestCases);
	}
	
	public TestSuite getTestSuite()
	{
		return m_oTestSuite;
	}
	
	private void addTestGoalTestCaseCombination(
			TestGoalBase in_oTestGoal,
			TestCase in_oTestCase)
	{
		// add a reference from the test goal to a test case - for optimization
		ArrayList<TestCase> colTestCases = m_colTestGoalsToTestCases.get(in_oTestGoal);
		if(colTestCases == null)
		{
			colTestCases = new ArrayList<TestCase>();
			m_colTestGoalsToTestCases.put(in_oTestGoal, colTestCases);
		}
		if(!colTestCases.contains(in_oTestCase))
			colTestCases.add(in_oTestCase);
		
		// add a reference from the test case to all test goals - for optimization
		ArrayList<TestGoalBase> colTestGoals = m_colTestCasesToTestGoals.get(in_oTestCase);
		if(colTestGoals == null)
		{
			colTestGoals = new ArrayList<TestGoalBase>();
			m_colTestCasesToTestGoals.put(in_oTestCase, colTestGoals);
		}	
		if(!colTestGoals.contains(in_oTestGoal))
			colTestGoals.add(in_oTestGoal);
	}
}
