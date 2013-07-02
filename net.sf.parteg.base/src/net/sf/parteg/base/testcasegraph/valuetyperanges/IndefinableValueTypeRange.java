package net.sf.parteg.base.testcasegraph.valuetyperanges;

import java.util.Map;

import net.sf.parteg.base.testcasegraph.generated.TCGOCLAtom;
import net.sf.parteg.base.testcasegraph.generated.TCGOCLExpression;
import net.sf.parteg.base.testcasegraph.valuetypes.ValueType;
import net.sf.parteg.core.testcase.TestCaseValidValue;

public class IndefinableValueTypeRange extends ValueTypeRange {

	@Override
	public boolean adaptRange(ValueTypeRange in_oOtherRange) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public ValueType getValidRandomValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setRange(ValueType in_oValue, String in_sOperationName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setRangeAccordingToRightSideOfExpression(
			TCGOCLExpression in_oExpression) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void setRangeAccordingToRightSideOfExpression(
			TCGOCLExpression in_oExpression,
			Map<TCGOCLAtom, TestCaseValidValue> in_colCurrentValueAssignment) throws Exception {
		
	}

	@Override
	public ValueTypeRange clone() {
		return new IndefinableValueTypeRange();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean equals(ValueTypeRange other) {
//		if(other instanceof IndefinableValueTypeRange)
//			return true;
		return false;
	}

	@Override
	public boolean contains(ValueTypeRange other) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setRangeAccordingToRightSideOfExpression(
			TCGOCLExpression in_oExpression,
			Map<TCGOCLAtom, TestCaseValidValue> in_colCurrentValueAssignment,
			Map<TCGOCLAtom, ValueTypeRange> in_colCurrentValueTypeRanges)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean adaptRange(String in_sSelectedTestValue) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setRange(String in_sSelectedTestValue) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void adaptRangeToStaticConstraints() {
		// TODO Auto-generated method stub
		
	}
}
