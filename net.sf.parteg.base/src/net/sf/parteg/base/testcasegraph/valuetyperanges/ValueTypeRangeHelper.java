package net.sf.parteg.base.testcasegraph.valuetyperanges;


public class ValueTypeRangeHelper {

	public static boolean outerVTRangeContainsInnerVTRange(
			ValueTypeRange in_oOuterRange,
			ValueTypeRange in_oInnerRange,
			boolean in_bBoundariesMatchExactly)
	{
		// exception: inner class is empty
		if(in_oInnerRange.isEmpty())
			return false;
		
		if(in_bBoundariesMatchExactly == true) // exact matching
		{
			return in_oOuterRange.equals(in_oInnerRange);
		}
		else
		{
			return in_oOuterRange.contains(in_oInnerRange);
		}
	}
	
}
