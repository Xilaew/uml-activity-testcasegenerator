package net.sf.parteg.base.testcasegraph.valueselection;

import java.util.ArrayList;

import net.sf.parteg.base.testcasegraph.valuetyperanges.ValueTypeRange;
import net.sf.parteg.core.testcase.TestCaseValidValue;

public class TestCaseValueRandomSelector extends TestCaseValueSelector {

	public TestCaseValueRandomSelector(boolean in_bSelectValuesAlsoAtAbsoluteBoundaries)
	{
		super(false, in_bSelectValuesAlsoAtAbsoluteBoundaries);
	}
	
	@Override
	protected void selectValuesForValidDomain(
			ArrayList<TestCaseValidValue> io_colValues,
			ValueTypeRange in_oValueRange)
	{
		TestCaseValueSelector.addRandomValuesForValidDomain(
				io_colValues, in_oValueRange);
	}
}
