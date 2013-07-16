package org.eclipse.atg.model;

import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Namespace;

public class UMLHelper {
	public static Namespace getNamespace(NamedElement umlElement){
		Namespace ns = umlElement.getNamespace();
		if (ns == null){
			ns=getNamespace((NamedElement) umlElement.getOwner());
		}
		return ns;
	}

}
