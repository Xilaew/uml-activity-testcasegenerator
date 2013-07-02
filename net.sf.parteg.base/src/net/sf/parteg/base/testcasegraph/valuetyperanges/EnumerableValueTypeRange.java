package net.sf.parteg.base.testcasegraph.valuetyperanges;

import net.sf.parteg.base.testcasegraph.valuetypes.EnumerableValueType;
import net.sf.parteg.base.testcasegraph.valuetypes.UnorderedValueType;
import net.sf.parteg.base.testcasegraph.valuetypes.ValueType;

public class EnumerableValueTypeRange<EVT extends EnumerableValueType> extends UnorderedValueTypeRange {

	public EnumerableValueTypeRange(UnorderedValueType in_oReferenceValue)
	{
		super(in_oReferenceValue);
	}
	
	@Override
	public ValueTypeRange clone() {
		EnumerableValueTypeRange<EVT> oCopy = new EnumerableValueTypeRange<EVT>(getReferenceValue());
		for(UnorderedValueType oVTR : getAllowedValues()) {
			oCopy.getAllowedValues().add((UnorderedValueType)oVTR.clone());
		}
		for(UnorderedValueType oVTR : getForbiddenValues()) {
			oCopy.getForbiddenValues().add((UnorderedValueType)oVTR.clone());
		}
		return oCopy;
	}

	@Override
	public boolean isEmpty() 
	{
		EnumerableValueType oVT = (EnumerableValueType)getReferenceValue();
		if(!getAllowedValues().isEmpty())
			return getForbiddenValues().containsAll(getAllowedValues());
		else
			return getForbiddenValues().containsAll(oVT.getPossibleValues());
	}
	
	@Override
	public boolean adaptRange(ValueTypeRange in_oOtherRange) {
		if(super.adaptRange(in_oOtherRange) == true)
		{
			if(!getForbiddenValues().isEmpty())
			{
				// TODO check if forbidden elements all possible elements of the type
	//			for(EVT oValue : )
			}
			return true;
		}
		return false;
	}
	
	@Override
	public ValueType getValidRandomValue() {
		ValueType oValue = null;
		if(!getAllowedValues().isEmpty())
		{
			oValue = getAllowedValues().get(0);
		}
		else
		{
			oValue = getReferenceValue().getRemainingValues(getForbiddenValues()).get(0);
		}
		return oValue;
	}	
}
