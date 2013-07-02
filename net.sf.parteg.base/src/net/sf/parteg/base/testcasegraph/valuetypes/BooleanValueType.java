package net.sf.parteg.base.testcasegraph.valuetypes;

import java.util.ArrayList;
import java.util.Map;

import net.sf.parteg.base.testcasegraph.generated.TCGOCLAtom;
import net.sf.parteg.base.testcasegraph.generated.TCGOCLExpression;
import net.sf.parteg.base.testcasegraph.helperclasses.TCGOCLExpressionHelperClass;
import net.sf.parteg.core.structures.Pair;
import net.sf.parteg.core.testcase.TestCaseValidValue;

public class BooleanValueType extends EnumerableValueType {

	private static ArrayList<UnorderedValueType> m_colPossibleValues = initPossibleValues();
	private Boolean m_oValue;
	
	private static ArrayList<UnorderedValueType> initPossibleValues()
	{
		ArrayList<UnorderedValueType> colValues = new ArrayList<UnorderedValueType>();
		colValues.add(new BooleanValueType(true));
		colValues.add(new BooleanValueType(false));
		return colValues;
	}

	public BooleanValueType(Boolean in_oValue)
	{
		m_oValue = in_oValue;
	}

	public BooleanValueType(boolean in_bValue)
	{
		m_oValue = new Boolean(in_bValue);
	}

	@Override
	public ArrayList<UnorderedValueType> getPossibleValues() {
		return m_colPossibleValues;
	}
	
	public Boolean getValue()
	{
		return m_oValue;
	}
	
	public ValueType createValueFromExpression(
			TCGOCLExpression in_oExpression) throws Exception {
		Boolean oResult = TCGOCLExpressionHelperClass.getBooleanValueIfNegative(in_oExpression);
		if(oResult != null)
			return new BooleanValueType(oResult);
		return null;
	}
	
	public ValueType createValueFromExpression(
			TCGOCLExpression in_oExpression,
			Map<TCGOCLAtom, TestCaseValidValue> in_colCurrentValueAssignment) throws Exception {
		return new BooleanValueType(
				TCGOCLExpressionHelperClass.getBooleanValue(
						in_oExpression, in_colCurrentValueAssignment));		
	}

	
	@Override
	public ValueType clone() {
		return new BooleanValueType(m_oValue.booleanValue());
	}

	
	@Override
	public boolean equals(Object other) {
		if(other instanceof BooleanValueType)
		{
			return m_oValue.equals(((BooleanValueType)other).getValue());
		}
		return false;
	}
	
	@Override
	public String toString()
	{
		//return m_oValue ? "true" : "false";
		return m_oValue.toString();
	}

	@Override
	public Pair<ValueType, ValueType> createValueFromExpression(
			TCGOCLExpression in_oExpression,
			Map<TCGOCLAtom, TestCaseValidValue> in_colCurrentValueAssignment,
			Map<TCGOCLAtom, Pair<ValueType, ValueType>> in_colCurrentValueRanges)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setValue(String in_sSelectedTestValue) {
		m_oValue = Boolean.parseBoolean(in_sSelectedTestValue);
	}

	@Override
	public boolean equals(String in_sSelectedTestValue) {
		return m_oValue.equals(Boolean.parseBoolean(in_sSelectedTestValue));
	}
}
