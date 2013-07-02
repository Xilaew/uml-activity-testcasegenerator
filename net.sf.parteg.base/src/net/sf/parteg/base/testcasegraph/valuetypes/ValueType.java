package net.sf.parteg.base.testcasegraph.valuetypes;

import java.util.Map;

import net.sf.parteg.base.testcasegraph.generated.TCGOCLAtom;
import net.sf.parteg.base.testcasegraph.generated.TCGOCLExpression;
import net.sf.parteg.core.structures.Pair;
import net.sf.parteg.core.testcase.TestCaseValidValue;

public abstract class ValueType implements Comparable<ValueType> {

	public abstract ValueType clone();
	
	public abstract String toString();
	
	public abstract boolean equals(Object other);
	
	public abstract int compareTo(ValueType other);
	
	public abstract ValueType createValueFromExpression(
			TCGOCLExpression in_oExpression) throws Exception;
	
	public abstract ValueType createValueFromExpression(
			TCGOCLExpression in_oExpression,
			Map<TCGOCLAtom, TestCaseValidValue> in_colCurrentValueAssignment) 
		throws Exception;	

	public abstract Pair<ValueType, ValueType> createValueFromExpression(
			TCGOCLExpression in_oExpression,
			Map<TCGOCLAtom, TestCaseValidValue> in_colCurrentValueAssignment,
			Map<TCGOCLAtom, Pair<ValueType, ValueType>> in_colCurrentValueRanges) 
		throws Exception;	

	public abstract void setValue(String in_sSelectedTestValue);

}
