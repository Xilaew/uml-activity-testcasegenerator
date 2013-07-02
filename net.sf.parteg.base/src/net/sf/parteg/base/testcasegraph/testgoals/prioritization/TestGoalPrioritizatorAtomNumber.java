package net.sf.parteg.base.testcasegraph.testgoals.prioritization;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import net.sf.parteg.base.testcasegraph.config.ConfigurationTestGoalPrioritization.TestGoalPrioritization;
import net.sf.parteg.base.testcasegraph.generated.TCGConjunction;
import net.sf.parteg.base.testcasegraph.testgoals.TestGoalBase;
import net.sf.parteg.base.testcasegraph.testgoals.TestGoalComparator;
import net.sf.parteg.base.testcasegraph.testgoals.TestGoalGuardConditions;

public class TestGoalPrioritizatorAtomNumber implements TestGoalPrioritizator {

	private TestGoalPrioritization m_oTestGoalPrioritization;
	
	public TestGoalPrioritizatorAtomNumber(TestGoalPrioritization in_oTestGoalPrioritization) {
		m_oTestGoalPrioritization = in_oTestGoalPrioritization;
	}
	
	public void sort(List<TestGoalBase> io_colGoals)
	{
		HashMap<TestGoalBase, Double> colGoalsAtomNumber = 
			new HashMap<TestGoalBase, Double>();
		// measure branching factor
		for(TestGoalBase oTestGoal : io_colGoals) {
			Double nAtomNumber = 0.0;
			if(oTestGoal instanceof TestGoalGuardConditions) {
				TestGoalGuardConditions oGoalGuard = (TestGoalGuardConditions)oTestGoal;
				nAtomNumber = 0.0;
				
				// collect branching factor of transition's target node
				if(!oGoalGuard.getDNFToBeSatisfied().getConjunctions().isEmpty()) {
					for(TCGConjunction oConjunction : oGoalGuard.getDNFToBeSatisfied().getConjunctions()) {
						Integer nLocalAtomNumber = oConjunction.getExpressions().size();
						nAtomNumber += nLocalAtomNumber;
					}
					nAtomNumber /= Double.valueOf(
							(double)oGoalGuard.getDNFToBeSatisfied().getConjunctions().size());
				}
			}
			oTestGoal.setPriority(nAtomNumber);
			colGoalsAtomNumber.put(oTestGoal, nAtomNumber);
		}
		if(m_oTestGoalPrioritization.equals(TestGoalPrioritization.MANY_ATOMS_FIRST))
		{
			Collections.sort(io_colGoals, 
					new TestGoalComparator(colGoalsAtomNumber, false));
		}
		else if(m_oTestGoalPrioritization.equals(TestGoalPrioritization.MANY_ATOMS_LAST))
		{
			Collections.sort(io_colGoals, 
					new TestGoalComparator(colGoalsAtomNumber, true));			
		}
	}
}
