package net.sf.parteg.base.testcasegraph.valuetypes;

import java.util.ArrayList;

public abstract class UnorderedValueType extends ValueType {

	public abstract ArrayList<UnorderedValueType> getPossibleValues();

	public abstract ArrayList<UnorderedValueType> getRemainingValues(
			ArrayList<UnorderedValueType> in_colValues);
	
	public abstract boolean equals(String in_sSelectedTestValue);
}
