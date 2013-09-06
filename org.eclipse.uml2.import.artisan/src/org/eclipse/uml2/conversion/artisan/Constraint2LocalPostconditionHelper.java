/**
 * 
 */
package org.eclipse.uml2.conversion.artisan;

import java.util.Iterator;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Action;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.ValueSpecification;

/**
 * @author th51e0
 * 
 */
public class Constraint2LocalPostconditionHelper {

	public static Package convert(Package _package) {
		Iterator<EObject> it = _package.eAllContents();
		EList<Element> todelete = new BasicEList<Element>();
		while (it.hasNext()) {
			EObject o = it.next();
			if (o instanceof Constraint) {
				Constraint c = (Constraint) o;
				String specString = "";
				if (c.getSpecification() instanceof OpaqueExpression) {
					for (String s : ((OpaqueExpression) c.getSpecification())
							.getBodies()) {
						specString = specString.concat(s);
					}
				}
				if (c.getSpecification() instanceof LiteralString){
					specString = ((LiteralString)c.getSpecification()).getValue();
				}
				int i = 0;
				for (Element e : c.getConstrainedElements()) {
					if (e instanceof Action) {
						Action a = (Action) e;
						ValueSpecification spec = a.createLocalPostcondition(
								"convertedPostcondition" + i++)
								.createSpecification(null, null,
										org.eclipse.uml2.uml.UMLPackage.Literals.LITERAL_STRING);
						System.out.println(spec);
						((LiteralString) spec).setValue(specString);
						todelete.add(c);
					}
				}
			}
		}
		while (!todelete.isEmpty()){
			((Constraint)todelete.get(0)).destroy();
			todelete.remove(0);
		}
		return null;
	}

}
