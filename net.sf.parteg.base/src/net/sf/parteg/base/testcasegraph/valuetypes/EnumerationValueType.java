package net.sf.parteg.base.testcasegraph.valuetypes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.sf.parteg.base.testcasegraph.generated.TCGOCLAtom;
import net.sf.parteg.base.testcasegraph.generated.TCGOCLExpression;
import net.sf.parteg.base.testcasegraph.helperclasses.TCGOCLExpressionHelperClass;
import net.sf.parteg.core.structures.Pair;
import net.sf.parteg.core.testcase.TestCaseValidValue;

public class EnumerationValueType extends EnumerableValueType {

	private ArrayList<UnorderedValueType> m_colPossibleValues;
	private String m_sValue;
	
	public EnumerationValueType(List<String> in_colValues) {
		m_colPossibleValues = new ArrayList<UnorderedValueType>();
		for(String sEnum : in_colValues) {
			m_colPossibleValues.add(new EnumerationValueType(sEnum));
		}
	}
	
	public EnumerationValueType(String in_oEnumValue) {
		m_sValue = in_oEnumValue;
	}
	
	public String getValue() {
		return m_sValue;
	}
	
	@Override
	public ValueType clone() {
		return new EnumerationValueType(getValue());
	}

	@Override
	public ArrayList<UnorderedValueType> getPossibleValues() {
		return m_colPossibleValues;
	}

	@Override
	public ValueType createValueFromExpression(TCGOCLExpression in_oExpression)
			throws Exception {
		String sResult = TCGOCLExpressionHelperClass.getEnumStringValue(in_oExpression);
		if(sResult != null)
			return new EnumerationValueType(sResult);
		return null;
	}

	@Override
	public ValueType createValueFromExpression(
			TCGOCLExpression in_oExpression,
			Map<TCGOCLAtom, TestCaseValidValue> in_colCurrentValueAssignment)
			throws Exception {
		return new EnumerationValueType(
				TCGOCLExpressionHelperClass.getEnumStringValue(
						in_oExpression, in_colCurrentValueAssignment));
	}

	@Override
	public boolean equals(Object other) {
		if(other instanceof EnumerationValueType)
		{
			return (m_sValue.equals(((EnumerationValueType)other).getValue()));
		}
		return false;
	}

	@Override
	public String toString()
	{
		return m_sValue;
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
		m_sValue = new String(in_sSelectedTestValue);
	}

	@Override
	public boolean equals(String in_sSelectedTestValue) {
		return m_sValue.equals(in_sSelectedTestValue);
	}
}
