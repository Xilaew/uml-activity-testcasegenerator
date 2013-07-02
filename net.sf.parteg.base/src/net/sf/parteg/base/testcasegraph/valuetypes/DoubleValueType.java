package net.sf.parteg.base.testcasegraph.valuetypes;

import java.util.Map;
import java.util.Random;

import net.sf.parteg.base.testcasegraph.generated.TCGOCLAtom;
import net.sf.parteg.base.testcasegraph.generated.TCGOCLExpression;
import net.sf.parteg.base.testcasegraph.helperclasses.TCGOCLExpressionHelperClass;
import net.sf.parteg.core.structures.Pair;
import net.sf.parteg.core.testcase.TestCaseValidValue;

public class DoubleValueType extends OrderedValueType {

	private Double m_oValue;
	private static Double sm_oBorderDistance = 0.1;
	private static Double sm_oAbsoluteMinimumBorder = -Double.MAX_VALUE;
	private static Double sm_oAbsoluteMaximumBorder = Double.MAX_VALUE;
	private static DoubleValueType sm_oBorderDistanceVT = 
		new DoubleValueType(sm_oBorderDistance);
	private static DoubleValueType sm_oMinimumVT = 
		new DoubleValueType(sm_oAbsoluteMinimumBorder);
	private static DoubleValueType sm_oMaximumVT = 
		new DoubleValueType(sm_oAbsoluteMaximumBorder);
	
	
	public static void setMinimum(Double in_nValue) {
		sm_oAbsoluteMinimumBorder = in_nValue;
		sm_oMinimumVT = new DoubleValueType(sm_oAbsoluteMinimumBorder);
	}
	public static void setMaximum(Double in_nValue) {
		sm_oAbsoluteMaximumBorder = in_nValue;
		sm_oMaximumVT = new DoubleValueType(sm_oAbsoluteMaximumBorder);
	}
	
	public static DoubleValueType getMinimumValue()
	{
		return sm_oMinimumVT;
	}
	
	public static DoubleValueType getMaximumValue()
	{
		return sm_oMaximumVT;
	}
	
	public DoubleValueType(Double in_oValue)
	{
		m_oValue = in_oValue;
	}

	public DoubleValueType(double in_nValue)
	{
		m_oValue = new Double(in_nValue);
	}

	@Override
	public OrderedValueType getLowerValueMinDistance() {
		return new DoubleValueType(m_oValue - sm_oBorderDistance);
	}

	@Override
	public OrderedValueType getUpperValueMinDistance() {
		return new DoubleValueType(m_oValue + sm_oBorderDistance);
	}

	public Double getValue() {
		return m_oValue;
	}

	@Override
	public OrderedValueType getRandomValueBetween(OrderedValueType in_oLower,
			OrderedValueType in_oHigher) {
		Random oRnd = new Random();
		// derive random value between higher and lower
		Double nNumber = new Double(0.0);
		Double nMin = ((DoubleValueType)in_oLower).getValue();
		if(nMin.compareTo(-Double.MAX_VALUE) <= 0)
			nMin = -Double.MAX_VALUE;
		if(nMin.compareTo(Double.MAX_VALUE) >= 0)
			nMin = Double.MAX_VALUE;
		Double nMax = ((DoubleValueType)in_oHigher).getValue();
		if(nMax.compareTo(-Double.MAX_VALUE) <= 0)
			nMax = -Double.MAX_VALUE;
		if(nMax.compareTo(Double.MAX_VALUE) >= 0)
			nMax = Double.MAX_VALUE;
		
		// first case: (upper value > 0) and (lower value < 0)
		if(nMax.compareTo(0.0) > 0 && nMin.compareTo(0.0) < 0) {
			// divide both values by 2
			nMin = nMin / 2.0;
			nMax = nMax / 2.0;
			// compute random distance value between and add offset
			nNumber = (oRnd.nextDouble() * (nMax - nMin)) + nMin;
			// multiply with max 2 (randomly)
			nNumber = 1.99 * oRnd.nextDouble() * nNumber;
		}
		// second case: else
		else {
			nNumber = nMin + (oRnd.nextDouble() * (nMax - nMin));
		}
		return new DoubleValueType(nNumber);
	}

	public OrderedValueType createValueFromExpression(
			TCGOCLExpression in_oExpression) throws Exception {
		Double oResult = TCGOCLExpressionHelperClass.getDoubleValue(in_oExpression);
		if(oResult != null)
			return new DoubleValueType(oResult);
		return null;
	}
	
	public OrderedValueType createValueFromExpression(
			TCGOCLExpression in_oExpression,
			Map<TCGOCLAtom, TestCaseValidValue> in_colCurrentValueAssignment) throws Exception {
		Double oValue = TCGOCLExpressionHelperClass.getDoubleValue(
				in_oExpression, in_colCurrentValueAssignment);
		if(oValue != null)
			return new DoubleValueType(oValue);
		return null;
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

	
	public String toString() {
		return m_oValue.toString();
	}
	
	@Override
	public ValueType clone() {
		return new DoubleValueType(m_oValue.doubleValue());
	}

	@Override
	public boolean equals(Object other) {
		if(other instanceof DoubleValueType)
		{
			return m_oValue.equals(((DoubleValueType)other).getValue());
		}
		return false;
	}

	@Override
	public int compareTo(ValueType other) {
		if(other instanceof DoubleValueType)
		{
			return m_oValue.compareTo(((DoubleValueType)other).getValue());
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
		if(in_oOtherValueType instanceof DoubleValueType) {
			DoubleValueType oOtherDoubleVT = (DoubleValueType)in_oOtherValueType;
			if(in_sOperator.equals("+")) {
				return new DoubleValueType(getValue().doubleValue() +
						oOtherDoubleVT.getValue().doubleValue());
			}
			else if(in_sOperator.equals("-")) {
				return new DoubleValueType(getValue().doubleValue() -
						oOtherDoubleVT.getValue().doubleValue());				
			}
			else if(in_sOperator.equals("*")) {
				return new DoubleValueType(getValue().doubleValue() *
						oOtherDoubleVT.getValue().doubleValue());
			}
			else if(in_sOperator.equals("/")) {
				return new DoubleValueType(getValue().doubleValue() /
						oOtherDoubleVT.getValue().doubleValue());
			}
		}
		return null;
	}

	@Override
	public int compareTo(String in_sSelectedTestValue) {
		double nSelectedValue = Double.parseDouble(in_sSelectedTestValue);
		return m_oValue.compareTo(nSelectedValue);
	}

	@Override
	public void setValue(String in_sSelectedTestValue) {
		m_oValue = Double.parseDouble(in_sSelectedTestValue);
	}

	@Override
	public int compareTo(OrderedValueType in_oValueType) {
		return m_oValue.compareTo(((DoubleValueType)in_oValueType).getValue());
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
