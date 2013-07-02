package net.sf.parteg.base.testcasetree.ocl;

import net.sf.parteg.base.testcasetree.ocl.transformation.CoverageCriteria;

public class TCTConfiguration {

	// selected coverage criterion
	private static CoverageCriteria sm_coverage = CoverageCriteria.ModifiedConditionDecisionCoverage;

	public static CoverageCriteria getCoverage() {
		return sm_coverage;
	}

	public static void setCoverage(CoverageCriteria in_oCoverage) {
		sm_coverage = in_oCoverage;
	}
}
