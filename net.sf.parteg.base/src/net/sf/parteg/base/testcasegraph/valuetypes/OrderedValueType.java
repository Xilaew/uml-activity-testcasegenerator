package net.sf.parteg.base.testcasegraph.valuetypes;


public abstract class OrderedValueType extends ValueType {

	/*
	 * returns an upper value with a certain minimum distance
	 */
	public abstract OrderedValueType getUpperValueMinDistance(); 

	/*
	 * returns a lower value with a certain minimum distance
	 */
	public abstract OrderedValueType getLowerValueMinDistance(); 
	
	public abstract OrderedValueType getMinDistance();
	
	public abstract OrderedValueType getCombinedValueType(
			OrderedValueType in_oOtherValueType,
			String in_sOperator);
	
	public abstract OrderedValueType getVTMaximum();

	public abstract OrderedValueType getVTMinimum();

	public abstract OrderedValueType getRandomValueBetween(
			OrderedValueType in_oLower, OrderedValueType in_oHigher);

	public abstract int compareTo(OrderedValueType in_oValueType);
	
	public abstract int compareTo(String in_sSelectedTestValue);

	public boolean isMinimum() {
		return compareTo(getVTMinimum()) == 0;
	}
	
	public boolean isMaximum() {
		return compareTo(getVTMaximum()) == 0;		
	}	
}
