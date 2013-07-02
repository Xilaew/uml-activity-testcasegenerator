package net.sf.parteg.base.testcasegraph.helperclasses;

import org.eclipse.uml2.uml.Vertex;

public class UMLVertexHelperClass {

	public static String getFullName(Vertex in_oVertex)
	{
		return UMLRegionHelperClass.getFullName(in_oVertex.getContainer()) + "::" + in_oVertex.getName();
	}

}
