package net.sf.parteg.base.testcasegraph.valuetyperanges;

import java.util.Map;

import net.sf.parteg.base.testcasegraph.generated.TCGOCLAtom;
import net.sf.parteg.base.testcasegraph.generated.TCGOCLExpression;
import net.sf.parteg.base.testcasegraph.valuetypes.ValueType;
import net.sf.parteg.core.testcase.TestCaseValidValue;

public abstract class ValueTypeRange {

	
	/*
	 * returns a shallow copy - assumed that the concrete value are constant, this copy is deep  
	 */
	public abstract ValueTypeRange clone();

	
	// ***** operations for setting the range *****

	public abstract void adaptRangeToStaticConstraints();
	
	public abstract boolean adaptRange(ValueTypeRange in_oValueTypeRange);

	public abstract boolean adaptRange(String in_sSelectedTestValue);
	
	public abstract void setRange(ValueType in_oValue, String in_sOperationName);
	
	public abstract void setRange(String in_sSelectedTestValue);
	
	public abstract void setRangeAccordingToRightSideOfExpression(
			TCGOCLExpression in_oExpression) throws Exception;

	public abstract void setRangeAccordingToRightSideOfExpression(
			TCGOCLExpression in_oExpression,
			Map<TCGOCLAtom, TestCaseValidValue> in_colCurrentValueAssignment) throws Exception;

	public abstract void setRangeAccordingToRightSideOfExpression(
			TCGOCLExpression in_oExpression,
			Map<TCGOCLAtom, TestCaseValidValue> in_colCurrentValueAssignment,
			Map<TCGOCLAtom, ValueTypeRange> in_colCurrentValueTypeRanges) throws Exception;

	// ***** value operations *****
	
	public abstract ValueType getValidRandomValue();
	
	
	
	// ***** checks size - compares to other ranges
	
	/*
	 * returns true if there are no allowed elements remaining   
	 */
	public abstract boolean isEmpty();
	
	/*
	 * checks if this range and other are equal
	 */
	public abstract boolean equals(ValueTypeRange other);
	
	/*
	 * checks if both ranges are overlapping
	 */
	public boolean overlaps(ValueTypeRange other) {
		ValueTypeRange oTmp = this.clone();
		oTmp.adaptRange(other);
		return !oTmp.isEmpty();
	}
	
	/*
	 * returns true if this range contains other (not strictly!)
	 * this means: the set of all allowed elements of "this" is a super set of "other"
	 */
	public abstract boolean contains(ValueTypeRange other);

	
}
