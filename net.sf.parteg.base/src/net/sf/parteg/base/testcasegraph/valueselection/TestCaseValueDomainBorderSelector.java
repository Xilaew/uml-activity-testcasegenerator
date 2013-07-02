package net.sf.parteg.base.testcasegraph.valueselection;

import java.util.ArrayList;

import net.sf.parteg.base.testcasegraph.valuetyperanges.ValueTypeRange;
import net.sf.parteg.core.testcase.TestCaseValidValue;

public class TestCaseValueDomainBorderSelector extends TestCaseValueSelector {

	public TestCaseValueDomainBorderSelector(
			boolean in_bSelectValuesOnlyAtBoundaries,
			boolean in_bSelectValuesAlsoAtAbsoluteBoundaries)
	{
		super(in_bSelectValuesOnlyAtBoundaries,
				in_bSelectValuesAlsoAtAbsoluteBoundaries);
	}
	
	@Override
	protected void selectValuesForValidDomain(
			ArrayList<TestCaseValidValue> io_colValues,
			ValueTypeRange in_oVTRange)
	{
		addBoundaryValuesForValidDomain(io_colValues, in_oVTRange);
	}
	
}
