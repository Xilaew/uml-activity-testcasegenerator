package experimental;

import java.io.IOException;

import org.eclipse.uml2.uml.Package;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.resources.util.UMLResourcesUtil;

public class UMLExperiment {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Package model = load(URI.createFileURI("./src/My_someActivitys.uml"));
		System.out.println(model.getLabel());
		for (org.eclipse.uml2.uml.Package p : model.getNestedPackages()) {
			System.out.println(p.getLabel() + p.getName());
			for (Element e : p.allOwnedElements()) {
				if (e instanceof Activity) {
					System.out.println("\t" + e.toString());
					for (Element k : e.allOwnedElements()) {
						System.out.println("\t\t" + k.toString());
					}
				}
			}
		}

	}

	protected static Model createModel(String name) {
		Model model = UMLFactory.eINSTANCE.createModel();
		model.setName(name);

		return model;
	}

	protected static void save(org.eclipse.uml2.uml.Package package_, URI uri) {
		ResourceSet resourceSet = new ResourceSetImpl();
		UMLResourcesUtil.init(resourceSet); // MDT/UML2 4.0.0 (Juno)
		Resource resource = resourceSet.createResource(uri);
		resource.getContents().add(package_);

		try {
			resource.save(null);

		} catch (IOException ioe) {
			System.err.println(ioe.getMessage());
		}
	}

	protected static Package load(URI uri) {
		ResourceSet resourceSet = new ResourceSetImpl();
		UMLResourcesUtil.init(resourceSet); // MDT/UML2 4.0.0 (Juno)
		Resource resource = resourceSet.createResource(uri);
		try {
			resource.load(null);
		} catch (IOException ioe) {
			System.err.println(ioe.getMessage());
		}
		System.out.println(resource.getContents().size());
		return (Package) resource.getContents().get(0);
	}

}
