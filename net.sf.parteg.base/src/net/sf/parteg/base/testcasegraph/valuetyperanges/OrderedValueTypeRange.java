package net.sf.parteg.base.testcasegraph.valuetyperanges;

import java.util.LinkedHashMap;
import java.util.Map;

import net.sf.parteg.base.testcasegraph.generated.TCGOCLAtom;
import net.sf.parteg.base.testcasegraph.generated.TCGOCLExpression;
import net.sf.parteg.base.testcasegraph.generated.TCGOCLOperation;
import net.sf.parteg.base.testcasegraph.helperclasses.TCGOCLExpressionHelperClass;
import net.sf.parteg.base.testcasegraph.valuetypes.OrderedValueType;
import net.sf.parteg.base.testcasegraph.valuetypes.ValueType;
import net.sf.parteg.core.structures.Pair;
import net.sf.parteg.core.testcase.TestCaseValidValue;

public class OrderedValueTypeRange<OVT extends OrderedValueType> extends ValueTypeRange {

	private OrderedValueType m_oMinValue;
	private OrderedValueType m_oMaxValue;
	private boolean m_bMinIncluded;
	private boolean m_bMaxIncluded;

	public OrderedValueTypeRange(
			OrderedValueType in_oMinValue,
			boolean in_bMinIncluded,
			OrderedValueType in_oMaxValue,
			boolean in_bMaxIncluded) {
		setMinValue(in_oMinValue);
		setMinIncluded(in_bMinIncluded);
		setMaxValue(in_oMaxValue);
		setMaxIncluded(in_bMaxIncluded);
	}
	
	public OrderedValueType getMinValue()
	{
		return m_oMinValue;
	}
	
	public void setMinValue(OrderedValueType in_oValue)
	{
		m_oMinValue = in_oValue;
	}
	
	public OrderedValueType getMaxValue()
	{
		return m_oMaxValue;
	}
	
	public void setMaxValue(OrderedValueType in_oValue)
	{
		m_oMaxValue = in_oValue;
	}
	
	public boolean isMinIncluded() {
		return m_bMinIncluded;
	}

	public void setMinIncluded(boolean minIncluded) {
		m_bMinIncluded = minIncluded;
	}

	public boolean isMaxIncluded() {
		return m_bMaxIncluded;
	}

	public void setMaxIncluded(boolean maxIncluded) {
		m_bMaxIncluded = maxIncluded;
	} 
	
	public boolean isRangeMinimum()
	{
		return m_oMinValue.isMinimum();
	}
	
	public boolean adaptRange(OrderedValueTypeRange<OVT> in_oRestrictingValueRange)
	{
		// change only if new value is more restricting
		if(getMinValue().compareTo(in_oRestrictingValueRange.getMinValue()) < 0)
		{
			setMinValue(in_oRestrictingValueRange.getMinValue());
			setMinIncluded(in_oRestrictingValueRange.isMinIncluded());
		}
		else if(getMinValue().compareTo(in_oRestrictingValueRange.getMinValue()) == 0)
		{
			setMinIncluded(isMinIncluded() && in_oRestrictingValueRange.isMinIncluded());
		}
		
		if(getMaxValue().compareTo(in_oRestrictingValueRange.getMaxValue()) > 0)
		{
			setMaxValue(in_oRestrictingValueRange.getMaxValue());
			setMaxIncluded(in_oRestrictingValueRange.isMaxIncluded());
		}
		else if(getMaxValue().compareTo(in_oRestrictingValueRange.getMaxValue()) == 0)
		{
			setMaxIncluded(isMaxIncluded() && in_oRestrictingValueRange.isMaxIncluded());
		}
		return !isEmpty();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean adaptRange(ValueTypeRange in_oOtherRange) {
		if(in_oOtherRange instanceof OrderedValueTypeRange)
			return adaptRange((OrderedValueTypeRange<OVT>) in_oOtherRange);
		return false;
	}

	@Override
	public ValueType getValidRandomValue() {
		OrderedValueType oMinVT = m_oMinValue;
		if(!isMinIncluded())
			oMinVT = oMinVT.getUpperValueMinDistance();
		OrderedValueType oMaxVT = m_oMaxValue;
		if(!isMaxIncluded())
			oMaxVT = oMaxVT.getLowerValueMinDistance();
		return m_oMinValue.getRandomValueBetween(oMinVT, oMaxVT);
	}
	
	@Override
	public ValueTypeRange clone() {
		OrderedValueTypeRange<OVT> oCopy = new OrderedValueTypeRange<OVT>(
				(OrderedValueType)getMinValue().clone(), isMinIncluded(), 
				(OrderedValueType)getMaxValue().clone(), isMaxIncluded());
		return oCopy;
	}

	@Override
	public void setRangeAccordingToRightSideOfExpression(
			TCGOCLExpression in_oExpression) throws Exception {

		if (in_oExpression instanceof TCGOCLOperation) {
			TCGOCLOperation oCallExp = (TCGOCLOperation) in_oExpression;
			// TODO : hack, dass m_nMinValue für Polymorphie des Typparameters missbraucht wird -> ändern!
			ValueType oValueOfExpression = m_oMinValue.createValueFromExpression(
					(TCGOCLExpression) oCallExp.getRight());
			if(oValueOfExpression != null) {
				setRange(oValueOfExpression, oCallExp.getOperationName());
			}
		} 
	}
	
	
	@Override
	public void setRangeAccordingToRightSideOfExpression(
			TCGOCLExpression in_oExpression,
			Map<TCGOCLAtom, TestCaseValidValue> in_colCurrentValueAssignment) throws Exception {

		if (in_oExpression instanceof TCGOCLOperation) {
			TCGOCLOperation oCallExp = (TCGOCLOperation) in_oExpression;
			// TODO : hack, dass m_nMinValue für Polymorphie des Typparameters missbraucht wird -> ändern!
			ValueType oValueOfExpression = m_oMinValue.createValueFromExpression(
					(TCGOCLExpression) oCallExp.getRight(),
					in_colCurrentValueAssignment);
			setRange(oValueOfExpression, oCallExp.getOperationName());
		} 
	}

	
	@Override
	/*
	 * This operation differs from the other two operations with the same name
	 * -> here, we also have to deal with value type ranges for other parameters
	 * -> the difference is that we have to deal with excluded boundary values
	 */
	public void setRangeAccordingToRightSideOfExpression(
			TCGOCLExpression in_oExpression,
			Map<TCGOCLAtom, TestCaseValidValue> in_colCurrentValueAssignment,
			Map<TCGOCLAtom, ValueTypeRange> in_colCurrentValueTypeRanges)
			throws Exception {
		
		// createValueFromExpression nur auf Atoms aufrufen
		OrderedValueTypeRange<OVT> oVTR = getRangeForExpression(
				in_oExpression, in_colCurrentValueAssignment, in_colCurrentValueTypeRanges);
		if(oVTR != null) {
			if(in_oExpression instanceof TCGOCLAtom) {
				setMaxIncluded(true);
				setMaxValue(oVTR.getMaxValue());
				setMinIncluded(true);
				setMinValue(oVTR.getMinValue());
			}
			else if(in_oExpression instanceof TCGOCLOperation) {
				TCGOCLOperation oOperation = (TCGOCLOperation)in_oExpression;
				if(oOperation.getOperationName().equals("<")) {
					setMaxIncluded(false);
					setMaxValue(oVTR.getMaxValue());										
				}
				if(oOperation.getOperationName().equals("<=") ||
						oOperation.getOperationName().equals("=")) {
					setMaxIncluded(true);
					setMaxValue(oVTR.getMaxValue());					
				}
				if(oOperation.getOperationName().equals("=") ||
						oOperation.getOperationName().equals(">=")) {
					setMinIncluded(true);
					setMinValue(oVTR.getMinValue());					
				}
				if(oOperation.getOperationName().equals(">")) {
					setMinIncluded(false);
					setMinValue(oVTR.getMinValue());					
				}
			}
		}
		else {
			// create empty valuetyperange
			getMinValue().setValue("1");
			getMaxValue().setValue("0");
		}
	}
	
	private void adaptValuesToTypeBoundaries() {
		if(getMaxValue().compareTo(getMaxValue().getVTMaximum()) > 0) {
			setMaxValue(getMaxValue().getVTMaximum());
			setMaxIncluded(true);
		}
		if(getMinValue().compareTo(getMinValue().getVTMinimum()) < 0) {
			setMinValue(getMinValue().getVTMinimum());
			setMinIncluded(true);
		}
	}

	@SuppressWarnings("unchecked")
	private OrderedValueTypeRange<OVT> getRangeForExpression(
			TCGOCLExpression in_oExpression,
			Map<TCGOCLAtom, TestCaseValidValue> in_colCurrentValueAssignment,
			Map<TCGOCLAtom, ValueTypeRange> in_colCurrentValueTypeRanges) throws Exception {
		
		// createValueFromExpression nur auf Atoms aufrufen
		if(in_oExpression instanceof TCGOCLAtom) {
			TCGOCLAtom oAtom = (TCGOCLAtom)in_oExpression;
			if(!(in_colCurrentValueTypeRanges.get(oAtom) instanceof OrderedValueTypeRange)) {
				return null;
			}
			OrderedValueTypeRange<OVT> oVTR = (OrderedValueTypeRange<OVT>)in_colCurrentValueTypeRanges.get(oAtom);
			if(oVTR == null) {
				ValueType oValueOfExpression = m_oMinValue.createValueFromExpression(
						in_oExpression, in_colCurrentValueAssignment);
				if(oValueOfExpression == null)
					return null;
				oVTR = (OrderedValueTypeRange<OVT>)ValueTypeRangeFactory.
					createValueTypeRangeForObject(in_oExpression);
				oVTR.setRange(oValueOfExpression, "=");				
			}
			return oVTR;
		}
		else if (in_oExpression instanceof TCGOCLOperation) {
			TCGOCLOperation oOperation = (TCGOCLOperation)in_oExpression;
			Map<TCGOCLAtom, Pair<ValueType, ValueType>> colAtomToValueRanges =
				new LinkedHashMap<TCGOCLAtom, Pair<ValueType, ValueType>>();
			for(TCGOCLAtom oAtom : in_colCurrentValueTypeRanges.keySet()) {
				if(!(in_colCurrentValueTypeRanges.get(oAtom) instanceof OrderedValueTypeRange)) {
					return null;
				}
				OrderedValueTypeRange oVTR = 
					(OrderedValueTypeRange)in_colCurrentValueTypeRanges.get(oAtom);
				OrderedValueType oMaxVT = oVTR.getMaxValue();
				if(!oVTR.isMaxIncluded())
					oMaxVT = oMaxVT.getLowerValueMinDistance();
				OrderedValueType oMinVT = oVTR.getMinValue();
				if(!oVTR.isMinIncluded())
					oMinVT = oMinVT.getUpperValueMinDistance();

				colAtomToValueRanges.put(oAtom, new Pair<ValueType, ValueType>(
						oMinVT, oMaxVT));
			}
			Pair<ValueType, ValueType> oValueTypePair = 
				m_oMinValue.createValueFromExpression(
						oOperation.getRight(), in_colCurrentValueAssignment, 
						colAtomToValueRanges);
			if(oValueTypePair != null) {
				OrderedValueType oFirstValue = (OrderedValueType)oValueTypePair.getFirst();
				OrderedValueType oSecondValue = (OrderedValueType)oValueTypePair.getSecond();
				OrderedValueTypeRange<OVT> oVTR = new OrderedValueTypeRange<OVT>(
						oFirstValue, true, oSecondValue, true);
	
				return oVTR;
			}
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void setRange(ValueType in_oValue, String in_sOperation)
	{
		OVT oValue = (OVT)in_oValue;
		if(in_sOperation.compareTo("<") == 0)
		{
			setMaxIncluded(false);
			setMaxValue(oValue);
		}
		else if(in_sOperation.compareTo("<=") == 0)
		{
			setMaxIncluded(true);
			setMaxValue(oValue);
		}
		else if(in_sOperation.compareTo("=") == 0)
		{
			setMinIncluded(true);
			setMinValue(oValue);
			setMaxIncluded(true);
			setMaxValue(oValue);
		}
		else if(in_sOperation.compareTo(">=") == 0)
		{
			setMinIncluded(true);
			setMinValue(oValue);
		}
		else if(in_sOperation.compareTo(">") == 0)
		{
			setMinIncluded(false);
			setMinValue(oValue);
		}
	}

	@Override
	public boolean isEmpty() {
		
		// min > max
		if(getMinValue().compareTo(getMaxValue()) > 0)
			return true;
		
		// min == max; one boundary excluded
		if(getMinValue().equals(getMaxValue()) &&
				(!isMinIncluded() || !isMaxIncluded()))
		{
			return true;
		}
		
		// min + min_dist == max; both boundaries excluded
		if((getMinValue().getUpperValueMinDistance().equals(getMaxValue())) &&
				!isMinIncluded() && !isMaxIncluded())
		{
			return true;
		}
		
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(ValueTypeRange other) {
		if(other instanceof OrderedValueTypeRange)
		{
			OrderedValueTypeRange<OVT> oOtherOrderedRange = (OrderedValueTypeRange<OVT>)other;
			if(getMinValue().equals(oOtherOrderedRange.getMinValue()) &&
					isMinIncluded() == oOtherOrderedRange.isMinIncluded() &&
					getMaxValue().equals(oOtherOrderedRange.getMaxValue()) &&
					isMaxIncluded() == oOtherOrderedRange.isMaxIncluded())
				return true;
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean contains(ValueTypeRange other) {
		if(other instanceof OrderedValueTypeRange)
		{
			OrderedValueTypeRange<OVT> oOtherOrderedRange = (OrderedValueTypeRange<OVT>)other;
			
			// TODO: eventuell die Grenzen und den minimalen Abstand mit in den Vergleich einbeziehen

			// own's values contain at least the elements of other
			if((((getMaxValue().equals(oOtherOrderedRange.getMaxValue())) && (isMaxIncluded() || !oOtherOrderedRange.isMaxIncluded())) ||
					(getMaxValue().compareTo(oOtherOrderedRange.getMaxValue()) > 0)) &&
					(((getMinValue().equals(oOtherOrderedRange.getMinValue())) && (isMinIncluded() || !oOtherOrderedRange.isMinIncluded())) ||
					(getMinValue().compareTo(oOtherOrderedRange.getMinValue()) < 0)))
				return true;
		}
		return false;
	}

	@Override
	public boolean adaptRange(String in_sSelectedTestValue) {
		// selected value is inside the actual value range
		if(((getMinValue().compareTo(in_sSelectedTestValue) < 0) ||
			(isMinIncluded() && getMinValue().compareTo(in_sSelectedTestValue) <= 0)) &&
			((getMaxValue().compareTo(in_sSelectedTestValue) > 0) ||
			(isMaxIncluded() && getMaxValue().compareTo(in_sSelectedTestValue) >= 0))) {
			// adapt value range
			setRange(in_sSelectedTestValue);
			return true;
		}
		return false;		
	}

	@Override
	public void setRange(String in_sSelectedTestValue) {
		OrderedValueType oMinOVT = getMinValue();
		oMinOVT.setValue(in_sSelectedTestValue);
		OrderedValueType oMaxOVT = getMaxValue();
		oMaxOVT.setValue(in_sSelectedTestValue);
		setMinValue(oMinOVT);
		setMinIncluded(true);
		setMaxValue(oMaxOVT);
		setMaxIncluded(true);
	}

	@Override
	public void adaptRangeToStaticConstraints() {
		adaptValuesToTypeBoundaries();
	}

}
