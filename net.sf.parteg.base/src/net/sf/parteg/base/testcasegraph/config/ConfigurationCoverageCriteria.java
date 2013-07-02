package net.sf.parteg.base.testcasegraph.config;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class ConfigurationCoverageCriteria {

	public enum BoundaryBasedCoverageCriterion
	{
		RANDOM,
		MULTI_DIMENSIONAL_AT_BOUNDARIES,
		MULTI_DIMENSIONAL
	}

	public enum ControlFlowBasedCoverageCriterion
	{
		PSEUDOSTATE_COVERAGE,
		STATE_COVERAGE,
		TRANSITION_COVERAGE,
		CONDITION_COVERAGE,
		DECISION_COVERAGE,
		MULTIPLE_CONDITION_COVERAGE,
		MODIFIED_CONDITION_DECISION_COVERAGE
	}

	// transition-based coverage criterion
	private static ControlFlowBasedCoverageCriterion sm_eTransitionBasedCoverageCriterion =
		ControlFlowBasedCoverageCriterion.TRANSITION_COVERAGE;
	
	// boundary-based coverage criterion
	private static BoundaryBasedCoverageCriterion sm_eBoundaryBasedCoverageCriterion = 
		BoundaryBasedCoverageCriterion.MULTI_DIMENSIONAL;

	private static HashMap<String, BoundaryBasedCoverageCriterion> m_colName2BoundaryCoverage = getDefaultBoundarybasedCoverageCriteria();
	private static HashMap<String, ControlFlowBasedCoverageCriterion> m_colName2ControlFlowCoverage = getDefaultControlFlowCoverageCriteria();

	public static HashMap<String, BoundaryBasedCoverageCriterion> getBoundaryBasedCoverageCriteria() {
		return m_colName2BoundaryCoverage;
	}

	public static BoundaryBasedCoverageCriterion getBoundaryBasedCoverageCriterion() {
		return sm_eBoundaryBasedCoverageCriterion;
	}
	
	public static void setControlFlowBasedCoverageCriterion(
			ControlFlowBasedCoverageCriterion in_eTransitionBasedCoverageCriterion) {
		sm_eTransitionBasedCoverageCriterion = in_eTransitionBasedCoverageCriterion;
	}

	public static void setBoundaryBasedCoverageCriterion(
			BoundaryBasedCoverageCriterion in_eBoundaryBasedCoverageCriterion) {
		sm_eBoundaryBasedCoverageCriterion = in_eBoundaryBasedCoverageCriterion;
	}
	

	public static HashMap<String, ControlFlowBasedCoverageCriterion> getControlFlowBasedCoverageCriteria() {
		return m_colName2ControlFlowCoverage;
	}

	public static ControlFlowBasedCoverageCriterion getControlFlowBasedCoverageCriterion() {
		return sm_eTransitionBasedCoverageCriterion;
	}

	private static HashMap<String, BoundaryBasedCoverageCriterion> getDefaultBoundarybasedCoverageCriteria()
	{
		HashMap<String, BoundaryBasedCoverageCriterion> colResultValue = 
			new LinkedHashMap<String, BoundaryBasedCoverageCriterion>();
		colResultValue.put("Random Value Selection", 
				BoundaryBasedCoverageCriterion.RANDOM);
		colResultValue.put("Multi Dimensional at Boundaries - MD_0", 
				BoundaryBasedCoverageCriterion.MULTI_DIMENSIONAL_AT_BOUNDARIES);
		colResultValue.put("Multi Dimensional - MD_1", 
				BoundaryBasedCoverageCriterion.MULTI_DIMENSIONAL);
		return colResultValue;
	}

	private static HashMap<String, ControlFlowBasedCoverageCriterion> getDefaultControlFlowCoverageCriteria()
	{
		HashMap<String, ControlFlowBasedCoverageCriterion> colResultValue = 
			new LinkedHashMap<String, ControlFlowBasedCoverageCriterion>();
		colResultValue.put("All-Pseudostates", 
				ControlFlowBasedCoverageCriterion.PSEUDOSTATE_COVERAGE);
		colResultValue.put("All-States", 
				ControlFlowBasedCoverageCriterion.STATE_COVERAGE);
		colResultValue.put("All-Transitions", 
				ControlFlowBasedCoverageCriterion.TRANSITION_COVERAGE);
		colResultValue.put("Decision Coverage", 
				ControlFlowBasedCoverageCriterion.DECISION_COVERAGE);
		colResultValue.put("Modified Condition / Decision Coverage (MC/DC)", 
				ControlFlowBasedCoverageCriterion.MODIFIED_CONDITION_DECISION_COVERAGE);
		colResultValue.put("Multiple Condition Coverage", 
				ControlFlowBasedCoverageCriterion.MULTIPLE_CONDITION_COVERAGE);
		return colResultValue;
	}

}
