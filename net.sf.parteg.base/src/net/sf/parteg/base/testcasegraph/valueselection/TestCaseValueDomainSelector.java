package net.sf.parteg.base.testcasegraph.valueselection;

import java.util.ArrayList;

import net.sf.parteg.base.testcasegraph.valuetyperanges.ValueTypeRange;
import net.sf.parteg.core.testcase.TestCaseValidValue;

public class TestCaseValueDomainSelector extends TestCaseValueSelector {

	public TestCaseValueDomainSelector(boolean in_bSelectValuesOnlyAtBoundaries)
	{
		super(in_bSelectValuesOnlyAtBoundaries, false);
	}
	
	@Override
	protected void selectValuesForValidDomain(
			ArrayList<TestCaseValidValue> io_colValues,
			ValueTypeRange in_oValueRange) 
	{
		TestCaseValueSelector.addRandomValuesForValidDomain(
				io_colValues, in_oValueRange);
		addBoundaryValuesForValidDomain(io_colValues, in_oValueRange);
	}

}
