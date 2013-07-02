package net.sf.parteg.base.testcasegraph.testgeneration;

import java.util.ArrayList;
import java.util.List;

import net.sf.parteg.base.runtime.generated.GeneratedFactory;
import net.sf.parteg.base.runtime.generated.RuntimeState;
import net.sf.parteg.base.testcasegraph.generated.TCGEvent;
import net.sf.parteg.base.testcasegraph.generated.TCGNode;
import net.sf.parteg.base.testcasegraph.generated.TCGOCLExpression;
import net.sf.parteg.base.testcasegraph.systemstate.StateConfiguration;
import net.sf.parteg.base.testcasegraph.testgoals.TestGoalBase;
import net.sf.parteg.base.testcasegraph.testsuite.TransitionInstance;

public class TestCaseGeneratorRunnerState {

	// list of groups of expressions and event parameter instances
	// for later evaluation and determination of concrete test input values
	private List<LateEvaluationGroup> m_colLateEvaluationGroups;
	// contains all conditions that must be satisfied - basis for all transformations
	private List<TCGOCLExpression> m_colConditionsToBeSatisfied;
	// ordered sequence of transitions: the current path backwards
	private List<TransitionInstance> m_colCurrentTransitionPath;
	// describes the current runtime state as a mapping from regions to activated states
	private RuntimeState m_oRuntimeState;
	// a list of all the currently visited runtime states of
	// TCGRealNodes including the conditions to be satisfied  
	private List<StateConfiguration> m_colStateConfigurationHistory;
	// test goals that must be evaluated first!!!
	// e.g. a list of transitions that should be traversed without taking 
	// other transitions into account -> used for identified postfixes
	private List<TestGoalBase> m_colTestGoalsToSatisfy;
	
	public TestCaseGeneratorRunnerState() {
		m_colLateEvaluationGroups = new ArrayList<LateEvaluationGroup>();
		m_colConditionsToBeSatisfied = new ArrayList<TCGOCLExpression>();
		m_colCurrentTransitionPath = new ArrayList<TransitionInstance>();
		m_oRuntimeState = GeneratedFactory.eINSTANCE.createRuntimeState();
		m_colStateConfigurationHistory = new ArrayList<StateConfiguration>();
		m_colTestGoalsToSatisfy = new ArrayList<TestGoalBase>();
	}

	public TestCaseGeneratorRunnerState copy() {
		TestCaseGeneratorRunnerState oCopy = new TestCaseGeneratorRunnerState();
		// shallow copy - just the reference to the existing conditions
		oCopy.getConditionsToBeSatisfied().addAll(getConditionsToBeSatisfied());
		// shallow copy - just the reference to the transition instances 
		oCopy.getCurrentTransitionPath().addAll(getCurrentTransitionPath());
		// deep copy - evaluation groups are changing
		for(LateEvaluationGroup oLateEvaluationGroup : getLateEvaluationGroups()) {
			oCopy.getLateEvaluationGroups().add(oLateEvaluationGroup.copy());
		}
		// shallow copy - just references to regions and nodes
		for(TCGNode oNode : getRuntimeState().getAllActiveNodes()) {
			oCopy.getRuntimeState().setActiveNode(oNode);
		}
		// shallow history - state configurations are not changed
		oCopy.getStateConfigurationHistory().addAll(getStateConfigurationHistory());
		// shallow copy - test goals do not change anymore
		oCopy.getTestGoalsToSatisfy().addAll(getTestGoalsToSatisfy());
		return oCopy;
	}
	
	public List<LateEvaluationGroup> getLateEvaluationGroups() {
		return m_colLateEvaluationGroups;
	}

	public List<TCGOCLExpression> getConditionsToBeSatisfied() {
		return m_colConditionsToBeSatisfied;
	}

	public List<TransitionInstance> getCurrentTransitionPath() {
		return m_colCurrentTransitionPath;
	}

	public RuntimeState getRuntimeState() {
		return m_oRuntimeState;
	}

	public List<StateConfiguration> getStateConfigurationHistory() {
		return m_colStateConfigurationHistory;
	}

	public List<TestGoalBase> getTestGoalsToSatisfy() {
		return m_colTestGoalsToSatisfy;
	}
	
	public boolean isMostRecentCalledEventDefaultEvent() {
		if(!getCurrentTransitionPath().isEmpty()) {
			TCGEvent oEvent = getCurrentTransitionPath()
				.get(getCurrentTransitionPath().size() - 1).getCalledEvent();
			if(oEvent == null || oEvent.isDefaultEvent())
				return true;
		}
		return false;
		
	}
	
	
}
