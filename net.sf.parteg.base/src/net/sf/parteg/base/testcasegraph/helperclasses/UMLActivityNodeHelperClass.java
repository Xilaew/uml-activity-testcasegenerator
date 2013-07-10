package net.sf.parteg.base.testcasegraph.helperclasses;

import org.eclipse.uml2.uml.ActivityNode;

public class UMLActivityNodeHelperClass {

	public static String getFullName(ActivityNode in_oActivityNode)
	{
		return UMLActivityHelperClass.getFullName(in_oActivityNode.getActivity()) + "::" + in_oActivityNode.getName();
	}

}
