package data;

import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Element;

public interface ConstraintMap extends Map<Element, EList<Constraint>> {
	
	public static final ConstraintMap INSTANCE = new ConstraintMapImpl();
	
	void put(Element node, Constraint constraint);

}
