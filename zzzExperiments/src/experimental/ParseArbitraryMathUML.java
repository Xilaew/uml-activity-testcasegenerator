package experimental;

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
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.resources.util.UMLResourcesUtil;

public class ParseArbitraryMathUML {

	public static void main(String[] args) {
		OCL ocl;
		ocl = OCL.newInstance();
		Helper helper = ocl.createOCLHelper();

		ResourceSet resourceSet = new ResourceSetImpl();
		UMLResourcesUtil.init(resourceSet); // MDT/UML2 4.0.0 (Juno)
		Resource resource = resourceSet.createResource(URI
				.createFileURI("../umlModels/AcademicProblems/model.uml"));
		try {
			resource.load(null);
		} catch (IOException ioe) {
			System.err.println(ioe.getMessage());
		}
	    Model model = (Model) resource.getContents().get(0);
	    Package umlPackage = (Package) model.getPackagedElement("Package1");
	    Class umlClas = (Class) umlPackage.getPackagedElement("TyrePump");
	    Operation umlOp = umlClas.getOwnedOperation("pump", null, null);
	    System.out.println(umlOp==null?"did not work!":"did Work!");
		helper.setOperationContext(umlClas, umlOp);
		try {
			helper.createPostcondition("volume=5");
		} catch (ParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
