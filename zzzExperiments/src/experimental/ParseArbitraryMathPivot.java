package experimental;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.ocl.examples.pivot.OCL;
import org.eclipse.ocl.examples.pivot.ParserException;
import org.eclipse.ocl.examples.pivot.Root;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.helper.OCLHelper;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.utilities.PivotEnvironmentFactory;
import org.eclipse.uml2.uml.CallOperationAction;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.SendSignalAction;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.resources.util.UMLResourcesUtil;

public class ParseArbitraryMathPivot {

	public static void main(String[] args) {
		OCL ocl;
		PivotEnvironmentFactory umlEnv = new PivotEnvironmentFactory();
		ocl = OCL.newInstance(umlEnv);
		// create an OCL helper object

		ResourceSet resourceSet = new ResourceSetImpl();
		org.eclipse.ocl.examples.pivot.OCL.initialize(resourceSet);
		org.eclipse.ocl.examples.pivot.uml.UML2Pivot.initialize(resourceSet);
		//UMLResourcesUtil.init(resourceSet); // MDT/UML2 4.0.0 (Juno)
		Resource resource = resourceSet.createResource(URI
				.createFileURI("../umlModels/AcademicProblems/model.uml"));
		try {
			resource.load(null);
		} catch (IOException ioe) {
			System.err.println(ioe.getMessage());
		}
		Root model = null;
		try {
		model = org.eclipse.ocl.examples.pivot.uml.UML2Pivot.importFromUML(new MetaModelManager(), "myPivot", resource);
		} catch (ParserException e1) {
			e1.printStackTrace();
		}
	    //Model model = (Model) resource.getContents().get(0);
		org.eclipse.ocl.examples.pivot.Package pivotPack = model.getNestedPackage().get(0);
	    //Package umlPackage = (Package) model.getPackagedElement("Package1");
	    //Type umlClas = (Type) umlPackage.getPackagedElement("TyrePump");
	    //org.eclipse.ocl.examples.pivot.Operation umlOp = umlClas.getOwnedOperation().get(0);
	    //System.out.println(umlOp==null?"did not work!":"did Work!");
		//OCLHelper helper = ocl.createOCLHelper(umlOp);
//		helper.setOperationContext(umlClas, umlOp);
//		try {
//			helper.createPostcondition("volume=5");
//		} catch (ParserException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}
}
