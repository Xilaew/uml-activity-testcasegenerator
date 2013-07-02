package net.sf.parteg.base.testcasegraph.helperclasses;

import org.eclipse.uml2.uml.Region;

public class UMLRegionHelperClass {

	public static String getFullName(Region in_oRegion)
	{
		if(in_oRegion.getState() != null)
			return UMLVertexHelperClass.getFullName(in_oRegion.getState()) + "::" + in_oRegion.getName();
		if(in_oRegion.getStateMachine() != null)
			return in_oRegion.getStateMachine().getName() + "::" + in_oRegion.getName();
		return "";
	}

}
