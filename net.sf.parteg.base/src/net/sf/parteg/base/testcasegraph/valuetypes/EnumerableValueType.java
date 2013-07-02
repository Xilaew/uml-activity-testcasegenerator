package net.sf.parteg.base.testcasegraph.valuetypes;

import java.util.ArrayList;


public abstract class EnumerableValueType extends UnorderedValueType {

	// TODO: hier vielleicht die getPossibleValues() - operation aus UnorderedValueType reinschreiben
	// Konsequenz: Wir brauchen auch eine neue ValueTypeRange-Klasse
	
	@Override
	public ArrayList<UnorderedValueType> getRemainingValues(
			ArrayList<UnorderedValueType> in_colValues) {
		ArrayList<UnorderedValueType> colRemainingValues = new ArrayList<UnorderedValueType>();
		for(UnorderedValueType oPossibleValue : getPossibleValues())
		{
			boolean bFound = false;
			for(UnorderedValueType oValue : in_colValues) {
				if(oValue.equals(oPossibleValue)) {
					bFound = true;
				}
			}
			if(bFound == false) {
				colRemainingValues.add(oPossibleValue);
			}
		}
		return colRemainingValues;	
	}
	

	@Override
	public int compareTo(ValueType other) {
		if(this.equals(other))
			return 0;
		return 1;
	}
}
