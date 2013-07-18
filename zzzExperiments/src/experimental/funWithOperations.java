package experimental;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.uml.OCL;
import org.eclipse.ocl.uml.UMLEnvironmentFactory;
import org.eclipse.ocl.uml.OCL.Helper;
import org.eclipse.ocl.uml.OCLExpression;
import org.eclipse.ocl.uml.internal.OCLFactoryImpl;
import org.eclipse.ocl.utilities.OCLFactory;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.util.UMLUtil;

import tools.UMLPathsearch;


public class funWithOperations extends UMLPathsearch{
	
	
	public static void main(String[] args) {
		//readCmdArgs(args);

		// read Model
		Model model = (Model) load("testdata/funWithOperations.uml").get(0);
		out("ModelName: " + model.getName()); //$NON-NLS-1$

		Class myComponent = (Class) model.getPackagedElement("MyComponent");
		out(myComponent.toString());
		Operation operation = myComponent.getOperation("operation1", null, null);
		out(operation.toString());
		EList<Constraint> constraints = operation.getPostconditions();
//		Model model = (Model) load("testdata/ElevatorControl.uml").get(0);
//
//
//	Class myComponent = (Class) ((org.eclipse.uml2.uml.Package) model.getPackagedElement("elevatorControl")).getOwnedMember("Elevator");
//out(myComponent.toString());
//		Operation operation = myComponent.getOperation("insertWeight", null, null);
////		out(operation.toString());
//		EList<Constraint> constraints = operation.getPostconditions();
//		for(Constraint c : constraints){
//			out(c.toString()+((LiteralString) c.getSpecification()).getValue());
//		}
//		for(Constraint c : constraints){
//			String oclExp = (((LiteralString) c.getSpecification()).getValue());
//			parse(oclExp , myComponent, operation);
//			out("parsed "+oclExp);
//		}

		
		
		for(Constraint c : constraints){
			out(c.toString()+((OpaqueExpression) c.getSpecification()).getBodies().get(0));
		}
		for(Constraint c : constraints){
			String oclExp = ((OpaqueExpression) c.getSpecification()).getBodies().get(0);
			parse(oclExp , myComponent, operation);
			out("parsed "+oclExp);
		}
	}
	
	
	private static OCLExpression parse(String string, Class myComponent,
			Operation operation) {
		OCLExpression result = null;
		OCL ocl = org.eclipse.ocl.uml.OCL.newInstance(
				new UMLEnvironmentFactory(
						myComponent.eResource().getResourceSet())); 
		Helper helper = ocl.createOCLHelper();
		helper.setOperationContext(myComponent, operation);
		for ( Variable<Classifier, ?> var : helper.getEnvironment().getVariables()){
			out(var.getRepresentedParameter()!=null ? var.getRepresentedParameter().toString() : var.getName());
		}
		try {
			//out(helper.getEnvironment().lookup("in").getRepresentedParameter()+"");
			helper.setValidating(false);
			result = helper.createQuery(string);
		} catch (ParserException e) {
			// TODO Auto-generated catch block
			out(e.getDiagnostic().getMessage());
			e.printStackTrace();
		}
		return result;
		
	}

}
