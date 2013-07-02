package net.sf.parteg.base.testcasegraph.valuetypes;

import java.util.Map;
import java.util.Random;

import net.sf.parteg.base.testcasegraph.generated.TCGOCLAtom;
import net.sf.parteg.base.testcasegraph.generated.TCGOCLExpression;
import net.sf.parteg.base.testcasegraph.helperclasses.TCGOCLExpressionHelperClass;
import net.sf.parteg.core.structures.Pair;
import net.sf.parteg.core.testcase.TestCaseValidValue;

public class IntegerValueType extends OrderedValueType {

	private Integer m_oValue;
	private static Integer sm_oBorderDistance = 1;
	private static Integer sm_oAbsoluteMinimumBorder = Integer.MIN_VALUE;
	private static Integer sm_oAbsoluteMaximumBorder = Integer.MAX_VALUE;
	private static IntegerValueType sm_oBorderDistanceVT = 
		new IntegerValueType(sm_oBorderDistance);
	private static IntegerValueType sm_oMinimumVT = 
		new IntegerValueType(sm_oAbsoluteMinimumBorder);
	private static IntegerValueType sm_oMaximumVT = 
		new IntegerValueType(sm_oAbsoluteMaximumBorder);
	
	public static void setMinimum(Integer in_nValue) {
		sm_oAbsoluteMinimumBorder = in_nValue;
		sm_oMinimumVT = new IntegerValueType(sm_oAbsoluteMinimumBorder);
	}
	public static void setMaximum(Integer in_nValue) {
		sm_oAbsoluteMaximumBorder = in_nValue;
		sm_oMaximumVT = new IntegerValueType(sm_oAbsoluteMaximumBorder);
	}
	
	public static IntegerValueType getMinimumValue()
	{
		return sm_oMinimumVT;
	}
	
	public static IntegerValueType getMaximumValue()
	{
		return sm_oMaximumVT;
	}
	
	public IntegerValueType(Integer in_oValue)
	{
		m_oValue = in_oValue;
	}

	public IntegerValueType(int in_nValue)
	{
		m_oValue = new Integer(in_nValue);
	}

	
	@Override
	public ValueType clone() {
		return new IntegerValueType(m_oValue.intValue());
	}

	@Override
	public OrderedValueType getLowerValueMinDistance() {
		return new IntegerValueType(m_oValue - sm_oBorderDistance);
	}

	@Override
	public OrderedValueType getUpperValueMinDistance() {
		return new IntegerValueType(m_oValue + sm_oBorderDistance);
	}

	public Integer getValue() {
		return m_oValue;
	}

	@Override
	public OrderedValueType getRandomValueBetween(
			OrderedValueType in_oLower,
			OrderedValueType in_oHigher) {
		Random oRnd = new Random();
		// derive random value between higher and lower
		Double nNumber = new Double(0.0);
		// first case: (upper value > 0) and (lower value < 0)
		if(((IntegerValueType)in_oHigher).getValue().compareTo(0) > 0 &&
				((IntegerValueType)in_oLower).getValue().compareTo(0) < 0) {
			// divide both values by 2
			Double nMin = ((IntegerValueType)in_oLower).getValue() / 2.0;
			Double nMax = ((IntegerValueType)in_oHigher).getValue() / 2.0;
			// compute random distance value between and add offset
			nNumber = (oRnd.nextDouble() * (nMax - nMin)) + nMin;
			// multiply with max 2 (randomly)
			nNumber = 1.99 * oRnd.nextDouble() * nNumber;
		}
		// second case: else
		else {
			nNumber = ((IntegerValueType)in_oLower).getValue() + 
				(oRnd.nextDouble() * (((IntegerValueType)in_oHigher).getValue() - ((IntegerValueType)in_oLower).getValue()));
		}
		return new IntegerValueType(nNumber.intValue());
	}

	public OrderedValueType createValueFromExpression(
			TCGOCLExpression in_oExpression) throws Exception {
		TCGOCLExpressionHelperClass.setLastIntegerComputationWasIncorrect(false);
		Integer oResult = TCGOCLExpressionHelperClass.getIntegerValue(in_oExpression);
		if(oResult != null)
			return new IntegerValueType(oResult);
		return null;
	}
	
	public OrderedValueType createValueFromExpression(
			TCGOCLExpression in_oExpression,
			Map<TCGOCLAtom, TestCaseValidValue> in_colCurrentValueAssignment) throws Exception {
		TCGOCLExpressionHelperClass.setLastIntegerComputationWasIncorrect(false);
		Integer oValue = TCGOCLExpressionHelperClass.getIntegerValue(
				in_oExpression, in_colCurrentValueAssignment);
		if(oValue != null)
			return new IntegerValueType(oValue);
		else
			return null;
	}
	
	
	@Override
	public Pair<ValueType, ValueType> 
		createValueFromExpression(TCGOCLExpression in_oExpression,
			Map<TCGOCLAtom, TestCaseValidValue> in_colCurrentValueAssignment,
			Map<TCGOCLAtom, Pair<ValueType, ValueType>> in_colCurrentValueRanges)
			throws Exception {
		TCGOCLExpressionHelperClass.setLastIntegerComputationWasIncorrect(false);
		Pair<Integer, Integer> oValuePair =
			TCGOCLExpressionHelperClass.getIntegerValuePair(
					in_oExpression, in_colCurrentValueAssignment,
					in_colCurrentValueRanges);
		if(oValuePair != null)
			return new Pair<ValueType, ValueType>(
					new IntegerValueType(oValuePair.getFirst()),
					new IntegerValueType(oValuePair.getSecond()));
		else
			return null;
	}

		
	public String toString()
	{
		return m_oValue.toString();
	}

	@Override
	public boolean equals(Object other) {
		if(other instanceof IntegerValueType)
		{
			return m_oValue.equals(((IntegerValueType)other).getValue());
		}
		return false;
	}

	@Override
	public int compareTo(ValueType other) {
		if(other instanceof IntegerValueType)
		{
			return m_oValue.compareTo(((IntegerValueType)other).getValue());
		}
		return 1;		
	}

	@Override
	public OrderedValueType getMinDistance() {
		return sm_oBorderDistanceVT;
	}
	
	@Override
	public OrderedValueType getCombinedValueType(
			OrderedValueType in_oOtherValueType,
			String in_sOperator) {
		if(in_oOtherValueType instanceof IntegerValueType) {
			IntegerValueType oOtherIntVT = (IntegerValueType)in_oOtherValueType;
			if(in_sOperator.equals("+")) {
				return new IntegerValueType(getValue().intValue() +
						oOtherIntVT.getValue().intValue());
			}
			else if(in_sOperator.equals("-")) {
				return new IntegerValueType(getValue().intValue() -
						oOtherIntVT.getValue().intValue());				
			}
			else if(in_sOperator.equals("*")) {
				return new IntegerValueType(getValue().intValue() *
						oOtherIntVT.getValue().intValue());
			}
			else if(in_sOperator.equals("/")) {
				return new IntegerValueType(getValue().intValue() /
						oOtherIntVT.getValue().intValue());
			}
		}
		return null;
	}
	
	
	@Override
	public int compareTo(String in_sSelectedTestValue) {
		int nSelectedValue = Integer.parseInt(in_sSelectedTestValue);
		return m_oValue.compareTo(nSelectedValue); 
	}
	
	@Override
	public void setValue(String in_sSelectedTestValue) {
		m_oValue = Integer.parseInt(in_sSelectedTestValue);
	}

	@Override
	public int compareTo(OrderedValueType in_oValueType) {
		return m_oValue.compareTo(((IntegerValueType)in_oValueType).getValue());
	}
	
	@Override
	public OrderedValueType getVTMaximum() {
		return getMaximumValue();
	}
	
	@Override
	public OrderedValueType getVTMinimum() {
		return getMinimumValue();
	}
}
