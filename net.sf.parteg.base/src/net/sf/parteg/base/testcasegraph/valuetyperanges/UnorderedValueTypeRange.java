package net.sf.parteg.base.testcasegraph.valuetyperanges;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.sf.parteg.base.testcasegraph.generated.TCGOCLAtom;
import net.sf.parteg.base.testcasegraph.generated.TCGOCLExpression;
import net.sf.parteg.base.testcasegraph.generated.TCGOCLOperation;
import net.sf.parteg.base.testcasegraph.valuetypes.UnorderedValueType;
import net.sf.parteg.base.testcasegraph.valuetypes.ValueType;
import net.sf.parteg.core.testcase.TestCaseValidValue;

public class UnorderedValueTypeRange extends ValueTypeRange {

	// empty allowed values means: all values are allowed without the forbidden ones
	// if allowed values is not empty: resulting allowed values is allowed values without forbidden values
	private ArrayList<UnorderedValueType> m_colAllowedValues;
	private ArrayList<UnorderedValueType> m_colForbiddenValues;
	protected UnorderedValueType m_oReferenceValue;
	
	public UnorderedValueTypeRange(UnorderedValueType in_oReferenceValue)
	{
		m_oReferenceValue = in_oReferenceValue;
		m_colAllowedValues = new ArrayList<UnorderedValueType>();
		m_colForbiddenValues = new ArrayList<UnorderedValueType>();
	}
	
	public UnorderedValueType getReferenceValue() {
		return m_oReferenceValue;
	}
	
	public ArrayList<UnorderedValueType> getAllowedValues()
	{
		return m_colAllowedValues;
	}
	
	public boolean allowedValuesContainEqualObject(UnorderedValueType in_oObject)
	{
		for(UnorderedValueType oVT : getAllowedValues()) {
			if(oVT.equals(in_oObject))
				return true;
		}
		return false;
	}
	
	public ArrayList<UnorderedValueType> getForbiddenValues()
	{
		return m_colForbiddenValues;
	}

	public boolean forbiddenValuesContainEqualObject(UnorderedValueType in_oObject)
	{
		for(UnorderedValueType oVT : getForbiddenValues()) {
			if(oVT.equals(in_oObject))
				return true;
		}
		return false;
	}

	@Override
	public boolean adaptRange(ValueTypeRange in_oOtherRange) 
	{
		
		UnorderedValueTypeRange oOtherRange = (UnorderedValueTypeRange)in_oOtherRange;
		// own: everything is allowed
		if(getAllowedValues().isEmpty())
		{
			// other: everything is allowed
			if(oOtherRange.getAllowedValues().isEmpty())
			{
				// both value ranges have no enforced values -> unite all forbidden values
				for(UnorderedValueType oValue: oOtherRange.getForbiddenValues())
				{
					if(!forbiddenValuesContainEqualObject(oValue))
					{
						getForbiddenValues().add(oValue);
					}
				}
			} 
			else // allowed values are restricted to the given ones
			{
				for(UnorderedValueType oValue: oOtherRange.getAllowedValues())
				{
					// add all allowed values - forbidden ones of "this" are compared to later
					getAllowedValues().add(oValue);
				}
				for(UnorderedValueType oValue: oOtherRange.getForbiddenValues())
				{
					if(!forbiddenValuesContainEqualObject(oValue))
					{
						getForbiddenValues().add(oValue);
					}
				}
			}			
		}
		else // this: allowed values are restricted to the given ones
		{
			// other: everything except the forbidden is allowed
			if(oOtherRange.getAllowedValues().isEmpty())
			{
				// the other range could have negative values that influence the enforced values of this range
				for(UnorderedValueType oValue: oOtherRange.getForbiddenValues())
				{
					if(!forbiddenValuesContainEqualObject(oValue))
						getForbiddenValues().add(oValue);
				}
			} 
			else 
			{
				// both value ranges contain values from which one is Mr. Right -> intersection
				for(UnorderedValueType oValue : getAllowedValues())
				{
					if(!oOtherRange.allowedValuesContainEqualObject(oValue) ||
							oOtherRange.forbiddenValuesContainEqualObject(oValue))
					{
						getForbiddenValues().add(oValue);
					}
				}
				for(UnorderedValueType oValue : oOtherRange.getForbiddenValues())
				{
					if(!forbiddenValuesContainEqualObject(oValue)) {
						getForbiddenValues().add(oValue);
					}
				}
			}
		}
		
		return !isEmpty();
	}

	@Override
	public ValueType getValidRandomValue() {
		ValueType oValue = null;
		if(!getAllowedValues().isEmpty())
		{
			// TODO Zufall implementieren! 
			oValue = getAllowedValues().get(0);
		}
		return oValue;
	}

	@Override
	public ValueTypeRange clone() {
		UnorderedValueTypeRange oCopy = new UnorderedValueTypeRange(getReferenceValue());
		for(UnorderedValueType oVTR : getAllowedValues()) {
			oCopy.getAllowedValues().add((UnorderedValueType)oVTR.clone());
		}
		for(UnorderedValueType oVTR : getForbiddenValues()) {
			oCopy.getForbiddenValues().add((UnorderedValueType)oVTR.clone());
		}
		return oCopy;
	}

	@Override
	public void setRangeAccordingToRightSideOfExpression(
			TCGOCLExpression in_oExpression) throws Exception {

		TCGOCLExpression oValidExpression = null;
		if (in_oExpression instanceof TCGOCLOperation) {
			TCGOCLOperation oCallExp = (TCGOCLOperation) in_oExpression;
			// TODO : hack, dass Instanz des ValueTypes für Polymorphie des Typparameters missbraucht wird -> ändern!?!
			oValidExpression = oCallExp.getRight();
			if(oValidExpression == null) // again - workaround for "not"
				oValidExpression = oCallExp.getLeft();
		}
		else {
			oValidExpression = (TCGOCLAtom)in_oExpression;
		}
		
		ValueType oValueOfExpression = getReferenceValue().createValueFromExpression(
				oValidExpression);
		
		if(in_oExpression instanceof TCGOCLOperation) // =, <, >, <=, >=, <>, not ?
			setRange(oValueOfExpression, ((TCGOCLOperation)in_oExpression).getOperationName());
		else // simple boolean values
			setRange(oValueOfExpression, "=");
	}

	
	@Override
	public void setRangeAccordingToRightSideOfExpression(
			TCGOCLExpression in_oExpression,
			Map<TCGOCLAtom, TestCaseValidValue> in_colCurrentValueAssignment) throws Exception {
		
		TCGOCLExpression oValidExpression = null;
		if (in_oExpression instanceof TCGOCLOperation) {
			TCGOCLOperation oCallExp = (TCGOCLOperation) in_oExpression;
			// TODO : hack, dass Instanz des ValueTypes für Polymorphie des Typparameters missbraucht wird -> ändern!?!
			oValidExpression = oCallExp.getRight();
			if(oValidExpression == null) // again - workaround for "not"
				oValidExpression = oCallExp.getLeft();
		}
		else {
			oValidExpression = (TCGOCLAtom)in_oExpression;
		}
		
		ValueType oValueOfExpression = getReferenceValue().createValueFromExpression(
				oValidExpression, in_colCurrentValueAssignment);
		
		if(in_oExpression instanceof TCGOCLOperation) // =, <, >, <=, >=, <>, not ?
			setRange(oValueOfExpression, ((TCGOCLOperation)in_oExpression).getOperationName());
		else // simple boolean values
			setRange(oValueOfExpression, "=");
	}

	
	@Override
	public void setRange(ValueType in_oValue, String in_sOperationName) {
//		if(in_sOperationName == null) {
//			int x = 42;
//			++x;
//		}
		if(in_sOperationName.compareTo("=") == 0)
		{
			getAllowedValues().add((UnorderedValueType)in_oValue);
		} else {
			getForbiddenValues().add((UnorderedValueType)in_oValue);
		}		
	}

	public ArrayList<UnorderedValueType> intersectValueTypeLists(
			ArrayList<UnorderedValueType> in_colFirst,
			ArrayList<UnorderedValueType> in_colSecond)
	{
		ArrayList<UnorderedValueType> colIntersection = new ArrayList<UnorderedValueType>();
		for(UnorderedValueType oFirst : in_colFirst)
		{
			boolean bFound = false;
			for(UnorderedValueType oSecond : in_colSecond)
			{
				if(oFirst.equals(oSecond))
				{
					bFound = true;
				}
			}
			if(bFound == true)
			{
				colIntersection.add(oFirst);
			}
		}
		return colIntersection;
	}
	
	@Override
	public boolean isEmpty() 
	{
		if(getAllowedValues().isEmpty())
			return false;
		else {
			for(UnorderedValueType oVT : getAllowedValues()) {
				if(!forbiddenValuesContainEqualObject(oVT))
					return false;
			}
		}
		return true;
//		return getForbiddenValues().containsAll(getAllowedValues());
		
//		ArrayList<UnorderedValueType> colOwnAllowedValues = getAllowedValues();
//		if(colOwnAllowedValues.isEmpty())
//			colOwnAllowedValues = m_oReferenceValue.getRemainingValues(getForbiddenValues()); 
//
//		if(colOwnAllowedValues.isEmpty())
//		{
//			return true;
//		}
//		return false;
	}

	@Override
	public boolean equals(ValueTypeRange other) {
		if(other instanceof UnorderedValueTypeRange)
		{
			UnorderedValueTypeRange oOtherUnorderedRange = (UnorderedValueTypeRange)other;

			ArrayList<UnorderedValueType> colOwnAllowedValues = getAllowedValues();
			if(colOwnAllowedValues.isEmpty())
				colOwnAllowedValues = getReferenceValue().getRemainingValues(getForbiddenValues()); 
			
			ArrayList<UnorderedValueType> colOtherAllowedValues = oOtherUnorderedRange.getAllowedValues();
			if(colOtherAllowedValues.isEmpty())
				colOtherAllowedValues = getReferenceValue().getRemainingValues(
					oOtherUnorderedRange.getForbiddenValues());

			if(colOwnAllowedValues.size() != colOtherAllowedValues.size())
				return false;
			
			if(!firstCollectionContainsAllEqualsElementsOfSecondCollection(
					colOwnAllowedValues, colOtherAllowedValues))
				return false;
			
//			if(getAllowedValues().containsAll(oOtherUnorderedRange.getAllowedValues()) &&
//					getAllowedValues().size() == oOtherUnorderedRange.getAllowedValues().size() &&
//					getForbiddenValues().containsAll(oOtherUnorderedRange.getForbiddenValues()) &&
//					getForbiddenValues().size() == oOtherUnorderedRange.getForbiddenValues().size())
//				return true;
			
			return true;
		}
		return false;
	}

//	/*
//	 * moves the remaining elements of the forbidden elements to the allowed elements
//	 */
//	public void moveNegatedForbiddenValuesToAllowedValues()
//	{
//		for(UnorderedValueType oNegatedValue : m_oReferenceValue.getRemainingValues(getForbiddenValues()))
//		{
//			boolean bFound = false;
//			for(UnorderedValueType oAllowedValue : getAllowedValues())
//			{
//				if(oAllowedValue.equals(oNegatedValue))
//				{
//					bFound = true;
//				}
//			}
//			if(bFound == true)
//			{
//				getAllowedValues().add(oNegatedValue);
//			}
//		}
//	}
	
	@Override
	public boolean contains(ValueTypeRange other) {
		if(other instanceof UnorderedValueTypeRange)
		{
			UnorderedValueTypeRange oOtherUnorderedRange = (UnorderedValueTypeRange)other;
			
			// contains: the set of allowed values in this is a superset of the other's set of allowed values

			ArrayList<UnorderedValueType> colOwnAllowedValues = getAllowedValues();
			if(colOwnAllowedValues.isEmpty())
				colOwnAllowedValues = getReferenceValue().getRemainingValues(getForbiddenValues()); 
			
			ArrayList<UnorderedValueType> colOtherAllowedValues = oOtherUnorderedRange.getAllowedValues();
			if(colOtherAllowedValues.isEmpty())
				colOtherAllowedValues = getReferenceValue().getRemainingValues(
					oOtherUnorderedRange.getForbiddenValues());
			
			// checks if own's allowed values are a super set of other's allowed values
			if(!firstCollectionContainsAllEqualsElementsOfSecondCollection(
					colOwnAllowedValues, colOtherAllowedValues))
				return false;
			
			return true;
		}
		return false;
	}
	
	private static boolean firstCollectionContainsAllEqualsElementsOfSecondCollection(
			ArrayList<? extends ValueType> in_colFirstCollection,
			ArrayList<? extends ValueType> in_colSecondCollection)
	{
		for(ValueType oThisForbiddenValue : in_colSecondCollection)
		{
			boolean bFound = false;
			for(ValueType oOtherForbiddenValue : in_colFirstCollection)
			{
				if(oOtherForbiddenValue.equals(oThisForbiddenValue))
					bFound = true;
			}
			if(bFound == false)
				return false;
		}
		return true;
	}

	@Override
	public void setRangeAccordingToRightSideOfExpression(
			TCGOCLExpression in_oExpression,
			Map<TCGOCLAtom, TestCaseValidValue> in_colCurrentValueAssignment,
			Map<TCGOCLAtom, ValueTypeRange> in_colCurrentValueTypeRanges)
			throws Exception {
		
		// createValueFromExpression nur auf Atoms aufrufen
		UnorderedValueTypeRange oUOVTR = getRangeForExpression(
				in_oExpression, in_colCurrentValueAssignment, in_colCurrentValueTypeRanges);
		if(oUOVTR != null) {
			if(in_oExpression instanceof TCGOCLAtom) {
				getAllowedValues().clear();
				getAllowedValues().addAll(oUOVTR.getAllowedValues());
				getForbiddenValues().clear();
				getForbiddenValues().addAll(oUOVTR.getForbiddenValues());
			}
			else if(in_oExpression instanceof TCGOCLOperation) {
				TCGOCLOperation oOperation = (TCGOCLOperation)in_oExpression;
				if(oOperation.getOperationName().equals("=")) {
					getAllowedValues().clear();
					getAllowedValues().addAll(oUOVTR.getAllowedValues());
					getForbiddenValues().clear();
					getForbiddenValues().addAll(oUOVTR.getForbiddenValues());					
				}
				else {
					getAllowedValues().clear();
					getAllowedValues().addAll(oUOVTR.getForbiddenValues());
					getForbiddenValues().clear();
					getForbiddenValues().addAll(oUOVTR.getAllowedValues());					
				}
			}
		}
	}
	
	@SuppressWarnings("null")
	private UnorderedValueTypeRange getRangeForExpression(
			TCGOCLExpression in_oExpression,
			Map<TCGOCLAtom, TestCaseValidValue> in_colCurrentValueAssignment,
			Map<TCGOCLAtom, ValueTypeRange> in_colCurrentValueTypeRanges) throws Exception {
		
		// should always fail in execution
		Double o = null;
		o.intValue();
		return null;
		
		
//		// createValueFromExpression nur auf Atoms aufrufen
//		if(in_oExpression instanceof TCGOCLAtom) {
//			TCGOCLAtom oAtom = (TCGOCLAtom)in_oExpression;
//			UnorderedValueTypeRange oUOVTR = (UnorderedValueTypeRange)in_colCurrentValueTypeRanges.get(oAtom);
//			if(oUOVTR == null) {
//				ValueType oValueOfExpression = m_oReferenceValue.createValueFromExpression(
//						in_oExpression, in_colCurrentValueAssignment);
//				if(oValueOfExpression == null)
//					return null;
//				oUOVTR = (UnorderedValueTypeRange)ValueTypeRangeFactory.
//					createValueTypeRangeForObject(in_oExpression);
//				oUOVTR.setRange(oValueOfExpression, "=");				
//			}
//			return oUOVTR;
//		}
//		else if (in_oExpression instanceof TCGOCLOperation) {
//			TCGOCLOperation oOperation = (TCGOCLOperation)in_oExpression;
//			Map<TCGOCLAtom, Pair<ValueType, ValueType>> colAtomToValueRanges =
//				new LinkedHashMap<TCGOCLAtom, Pair<ValueType, ValueType>>();
//			for(TCGOCLAtom oAtom : in_colCurrentValueTypeRanges.keySet()) {
//				UnorderedValueTypeRange oUOVTR = 
//					(UnorderedValueTypeRange)in_colCurrentValueTypeRanges.get(oAtom);
//				UnorderedValueType oVT = 
//				OrderedValueType oMaxVT = oUOVTR.getMaxValue();
//				if(!oUOVTR.isMaxIncluded())
//					oMaxVT = oMaxVT.getLowerValueMinDistance();
//				OrderedValueType oMinVT = oUOVTR.getMinValue();
//				if(!oUOVTR.isMinIncluded())
//					oMinVT = oMinVT.getUpperValueMinDistance();
//
//				colAtomToValueRanges.put(oAtom, new Pair<ValueType, ValueType>(
//						oMinVT, oMaxVT));
//			}
//			Pair<ValueType, ValueType> oValueTypePair = 
//				m_oMinValue.createValueFromExpression(
//						oOperation.getRight(), in_colCurrentValueAssignment, 
//						colAtomToValueRanges);
//			if(oValueTypePair != null) {
//				OrderedValueType oFirstValue = (OrderedValueType)oValueTypePair.getFirst();
//				OrderedValueType oSecondValue = (OrderedValueType)oValueTypePair.getSecond();
//				OrderedValueTypeRange oVTR = new OrderedValueTypeRange<OVT>(
//						oFirstValue, true, oSecondValue, true);
//	
//				return oVTR;
//			}
//		}
//		return null;
	}

	@Override
	public boolean adaptRange(String in_sSelectedTestValue) {
		if(getAllowedValues().isEmpty()) {
			for(UnorderedValueType oUOVT : getForbiddenValues()) {
				if(oUOVT.equals(in_sSelectedTestValue)) {
					return false;
				}
			}
			setRange(in_sSelectedTestValue);
			return true;
		}
		else {
			boolean bDetected = false;
			for(UnorderedValueType oUOVT : getAllowedValues()) {
				// there is at least one matching value -> reduce all values to this one
				if(oUOVT.equals(in_sSelectedTestValue)) {
					bDetected = true;
				}
			}
			if(bDetected == true) {
				for(UnorderedValueType oUOVT : getForbiddenValues()) {
					// value is not forbidden
					if(oUOVT.equals(in_sSelectedTestValue)) {
						return false;
					}
				}
				setRange(in_sSelectedTestValue);
				return true;
			}
			return false;
		}
	}

	@Override
	public void setRange(String in_sSelectedTestValue) {
		if(getAllowedValues().isEmpty()) {
			// everything allowed? -> add one value to the allowed values
			UnorderedValueType oNewAllowed = (UnorderedValueType)m_oReferenceValue.clone();
			oNewAllowed.setValue(in_sSelectedTestValue);
			getAllowedValues().add(oNewAllowed);
		}
		else {
			// only the existing elements allowed: restrict this set 
			for(UnorderedValueType oUOVT : getAllowedValues()) {
				if(!oUOVT.equals(in_sSelectedTestValue)) {
					getForbiddenValues().add(oUOVT);
				}
			}
			if(getAllowedValues().isEmpty()) {
				UnorderedValueType oNewAllowed = (UnorderedValueType)m_oReferenceValue.clone();
				oNewAllowed.setValue(in_sSelectedTestValue);
				getAllowedValues().add(oNewAllowed);
			}
		}
		// if the value was already forbidden -> remove the reference
		List<UnorderedValueType> colValuesToBeRemoved =
			new ArrayList<UnorderedValueType>(); 
		for(UnorderedValueType oUOVT : getForbiddenValues()) {
			// value is not forbidden
			if(oUOVT.equals(in_sSelectedTestValue)) {
				colValuesToBeRemoved.add(oUOVT);
			}
		}
		getForbiddenValues().removeAll(colValuesToBeRemoved);
	}

	@Override
	public void adaptRangeToStaticConstraints() {
		// there are no static constraints for these types
	}
}
