package oclBugMinimal;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.uml.OCL;
import org.eclipse.ocl.uml.OCL.Helper;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.internal.impl.PropertyImpl;
import org.eclipse.uml2.uml.resources.util.UMLResourcesUtil;

public class Code {

	public static void main(String[] args) throws ParserException, IOException {
		// Loading the Resource
		ResourceSet RESOURCE_SET = new ResourceSetImpl();
		UMLResourcesUtil.init(RESOURCE_SET); // MDT/UML2 4.0.0 (Juno)
		Resource resource = RESOURCE_SET.createResource(URI
				.createFileURI("src/oclBugMinimal/Model.uml"));
		resource.load(null);

		// navigating through the model finding context elements
		Model model = (Model) resource.getContents().get(0);
		Class class1 = (Class) model.getPackagedElement("Class1");

		for (Property p : class1.getOwnedAttributes()) {
			//p.getType();
			((PropertyImpl) p).basicGetType(); // THIS CAUSES THE ERROR
		}

		// Try parsing a simple ocl constraint
		OCL ocl = OCL.newInstance(RESOURCE_SET);
		Helper helper = ocl.createOCLHelper();
		helper.setContext(class1);
		helper.createInvariant("x>=5");

	}

}
