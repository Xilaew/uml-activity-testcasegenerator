package net.sf.parteg.base.testcasegraph.testgoals.prioritization;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import net.sf.parteg.base.testcasegraph.config.ConfigurationTestGoalPrioritization.TestGoalPrioritization;
import net.sf.parteg.base.testcasegraph.generated.TCGConjunction;
import net.sf.parteg.base.testcasegraph.generated.TCGNode;
import net.sf.parteg.base.testcasegraph.generated.TCGTransition;
import net.sf.parteg.base.testcasegraph.helperclasses.TCGNodeHelperClass;
import net.sf.parteg.base.testcasegraph.helperclasses.TCGTransitionHelperClass;
import net.sf.parteg.base.testcasegraph.testgoals.TestGoalBase;
import net.sf.parteg.base.testcasegraph.testgoals.TestGoalComparator;
import net.sf.parteg.base.testcasegraph.testgoals.TestGoalGuardConditions;

public class TestGoalPrioritizatorBranching implements TestGoalPrioritizator {

	private TestGoalPrioritization m_oTestGoalPrioritization;
	
	public TestGoalPrioritizatorBranching(TestGoalPrioritization in_oTestGoalPrioritization) {
		m_oTestGoalPrioritization = in_oTestGoalPrioritization;
	}
	
	public void sort(List<TestGoalBase> io_colGoals)
	{
		HashMap<TestGoalBase, Double> colGoalsBranchingFactor = 
			new HashMap<TestGoalBase, Double>();
		// measure branching factor
		for(TestGoalBase oTestGoal : io_colGoals) {
			Double nBranchingFactor = 1.0;
			if(oTestGoal instanceof TestGoalGuardConditions) {
				TestGoalGuardConditions oGoalGuard = (TestGoalGuardConditions)oTestGoal;
				nBranchingFactor = 0.0;
				TCGNode oBranchingNode = (TCGNode)oGoalGuard.getElement();
				
				// collect branching factor of transition's target node
				if(oGoalGuard.getDNFToBeSatisfied().getConjunctions().isEmpty()) {
					List<TCGTransition> colTransitions = TCGTransitionHelperClass.findResultingTransitions(
							oBranchingNode, oGoalGuard.getEventToBeCalled(), null);
					if(!colTransitions.isEmpty()) {
						oBranchingNode = colTransitions.get(0).getTargetNode();
					}
					nBranchingFactor = getBranchingFactor(oBranchingNode);
				}
				else {
					for(TCGConjunction oConjunction : oGoalGuard.getDNFToBeSatisfied().getConjunctions()) {
						oBranchingNode = (TCGNode)oGoalGuard.getElement();
						List<TCGTransition> colTransitions = TCGTransitionHelperClass.findResultingTransitions(
								oBranchingNode, oGoalGuard.getEventToBeCalled(), oConjunction);
						if(!colTransitions.isEmpty()) {
							oBranchingNode = colTransitions.get(0).getTargetNode();
						}
						Double nBranching = getBranchingFactor(oBranchingNode);
						nBranchingFactor += nBranching;
					}
					nBranchingFactor /= Double.valueOf(
							(double)oGoalGuard.getDNFToBeSatisfied().getConjunctions().size());
				}
			}
			else {
				TCGNode oBranchingNode = (TCGNode)oTestGoal.getElement();
				nBranchingFactor = getBranchingFactor(oBranchingNode);
			}
			oTestGoal.setPriority(nBranchingFactor);
			colGoalsBranchingFactor.put(oTestGoal, nBranchingFactor);
		}
		if(m_oTestGoalPrioritization.equals(TestGoalPrioritization.HIGH_BRANCHING_FACTOR_FIRST))
		{
			Collections.sort(io_colGoals, 
					new TestGoalComparator(colGoalsBranchingFactor, false));
		}
		else if(m_oTestGoalPrioritization.equals(TestGoalPrioritization.HIGH_BRANCHING_FACTOR_LAST))
		{
			Collections.sort(io_colGoals, 
					new TestGoalComparator(colGoalsBranchingFactor, true));			
		}
	}
	
	private Double getBranchingFactor(TCGNode in_oNode) {
		return Double.valueOf((double)TCGNodeHelperClass.
				getAllOutgoingTransitionsPlusCPR(in_oNode).size()) /
			Double.valueOf((double)TCGNodeHelperClass.
				getAllIncomingTransitionsPlusCPR(in_oNode).size());
//		return Double.valueOf((double)in_oNode.getOutgoingTransitions().size()) /
//			Double.valueOf((double)in_oNode.getIncomingTransitions().size());
	}
}
