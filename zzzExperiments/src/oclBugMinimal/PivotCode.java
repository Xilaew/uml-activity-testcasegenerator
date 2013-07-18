package oclBugMinimal;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.examples.pivot.OCL;
import org.eclipse.ocl.examples.pivot.helper.OCLHelper;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.internal.impl.PropertyImpl;

public class PivotCode {

	public static void main(String[] args) throws ParserException, IOException, org.eclipse.ocl.examples.pivot.ParserException {
		// Loading the Resource
		ResourceSet resourceSet = new ResourceSetImpl();
		org.eclipse.ocl.examples.pivot.OCL.initialize(resourceSet);
		org.eclipse.uml2.uml.resources.util.UMLResourcesUtil.init(resourceSet);
		//org.eclipse.ocl.examples.pivot.uml.UML2Pivot.initialize(resourceSet);
		org.eclipse.ocl.examples.pivot.model.OCLstdlib.install();
		org.eclipse.ocl.examples.pivot.delegate.OCLDelegateDomain.initialize(resourceSet);
		org.eclipse.ocl.examples.pivot.model.OCLstdlib.install();
		org.eclipse.ocl.examples.domain.utilities.StandaloneProjectMap.getAdapter(resourceSet);

		Resource resource = resourceSet.createResource(URI
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
		OCL ocl = OCL.newInstance();
		OCLHelper helper = ocl.createOCLHelper();
		helper.setInstanceContext(class1);
		helper.createInvariant("x>=5");

	}

}
