package net.sf.parteg.base.testcasegraph.helperclasses;

public class TypeNameHelperClass {

	public static boolean isBooleanTypeName(String in_sName)
	{
		if(in_sName.equals("bool") || in_sName.equals("boolean") || in_sName.equals("Boolean")) {
			return true;
		}
		return false;
	}
}
