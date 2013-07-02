package net.sf.parteg.base.testcasegraph.testgoals.prioritization;

import net.sf.parteg.base.testcasegraph.config.ConfigurationTestGoalPrioritization.TestGoalPrioritization;

public class TestGoalPrioritizatorFactory {

	public static TestGoalPrioritizator getPrioritizator(
			TestGoalPrioritization in_oPrioritization) {
		
		if(in_oPrioritization.equals(TestGoalPrioritization.RANDOM)) {
			return new TestGoalPrioritizatorRandom();
		}
		else if(in_oPrioritization.equals(TestGoalPrioritization.FAR_ELEMENTS_FIRST) ||
				in_oPrioritization.equals(TestGoalPrioritization.FAR_ELEMENTS_LAST)) {
			return new TestGoalPrioritizatorMaxDistance(in_oPrioritization);
		}
		else if(in_oPrioritization.equals(TestGoalPrioritization.HIGH_BRANCHING_FACTOR_FIRST) ||
				in_oPrioritization.equals(TestGoalPrioritization.HIGH_BRANCHING_FACTOR_LAST)) {
			return new TestGoalPrioritizatorBranching(in_oPrioritization);
		}
		else if(in_oPrioritization.equals(TestGoalPrioritization.MANY_ATOMS_FIRST) ||
				in_oPrioritization.equals(TestGoalPrioritization.MANY_ATOMS_LAST)) {
			return new TestGoalPrioritizatorAtomNumber(in_oPrioritization);
		}
		else if(in_oPrioritization.equals(TestGoalPrioritization.HIGH_POSITIVE_ATOMS_RATIO_FIRST) ||
				in_oPrioritization.equals(TestGoalPrioritization.HIGH_POSITIVE_ATOMS_RATIO_LAST)) {
			return new TestGoalPrioritizatorPositiveAtoms(in_oPrioritization);
		}
		
		return new TestGoalPrioritizatorRandom();
	}
	
}
