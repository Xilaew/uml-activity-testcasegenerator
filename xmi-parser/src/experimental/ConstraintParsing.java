package experimental;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.OCL;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.helper.ConstraintKind;
import org.eclipse.ocl.helper.OCLHelper;
import org.eclipse.ocl.uml.ExpressionInOCL;
import org.eclipse.ocl.uml.OperationCallExp;
import org.eclipse.ocl.uml.PropertyCallExp;
import org.eclipse.ocl.uml.UMLEnvironmentFactory;
import org.eclipse.ocl.utilities.Visitor;
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

import tools.UMLPathsearch;
import utility.OCLtoAMPLVisitor;

public class ConstraintParsing extends UMLPathsearch {

	public static void parseOCLExpr(Classifier context, String invariant) {

		OCL<Package, Classifier, Operation, Property, EnumerationLiteral, Parameter, State, CallOperationAction, SendSignalAction, Constraint, Class, EObject> ocl;
		UMLEnvironmentFactory umlEnv = new UMLEnvironmentFactory();
		ocl = OCL.newInstance(umlEnv);

		// create an OCL helper object
		OCLHelper<Classifier, Operation, Property, Constraint> helper = ocl
				.createOCLHelper();

		try {
			// set the OCL context classifier
			helper.setContext(context);

			Constraint query = helper
					.createConstraint(ConstraintKind.INVARIANT, invariant);
			// OCLExpression<EClassifier> exp = helper.createQuery("test");

			Iterator<EObject> it = query.eAllContents();
			while (it.hasNext()) {
				EObject o = it.next();
				out(o.toString());
				out(o.getClass().toString());
				out(";");
				if (o instanceof OperationCallExp) {
					out(((OperationCallExp) o).getReferredOperation()
							.toString() + ";");
				}
				if (o instanceof PropertyCallExp) {
					out(((PropertyCallExp) o).getReferredProperty().toString()
							+ ";");
				}

			}
			Visitor<String, Classifier, Operation, Property, EnumerationLiteral, Parameter, State, CallOperationAction, SendSignalAction, Constraint> amplConverter = new OCLtoAMPLVisitor<Classifier, EnumerationLiteral, Parameter, State, CallOperationAction, SendSignalAction>();
			System.out.println(amplConverter.visitExpressionInOCL((org.eclipse.ocl.utilities.ExpressionInOCL<Classifier, Parameter>) query.getSpecification()));
			System.out.println(amplConverter.visitConstraint(query));
			// record success
		} catch (ParserException e) {
			// record failure to parse
			System.err.println(e.getLocalizedMessage());
			e.printStackTrace();
		}

	}
	public static void parseOCLOperationExpr(Classifier context,Operation operation, String invariant) {

		OCL<Package, Classifier, Operation, Property, EnumerationLiteral, Parameter, State, CallOperationAction, SendSignalAction, Constraint, Class, EObject> ocl;
		UMLEnvironmentFactory umlEnv = new UMLEnvironmentFactory();
		ocl = OCL.newInstance(umlEnv);

		// create an OCL helper object
		OCLHelper<Classifier, Operation, Property, Constraint> helper = ocl
				.createOCLHelper();

		try {
			// set the OCL context classifier
			helper.setOperationContext(context, operation);

			Constraint query = helper
					.createConstraint(ConstraintKind.POSTCONDITION, invariant);
			// OCLExpression<EClassifier> exp = helper.createQuery("test");

			Iterator<EObject> it = query.eAllContents();
			while (it.hasNext()) {
				EObject o = it.next();
				out(o.toString());
				out(o.getClass().toString());
				out(";");
				if (o instanceof OperationCallExp) {
					out(((OperationCallExp) o).getReferredOperation()
							.toString() + ";");
				}
				if (o instanceof PropertyCallExp) {
					out(((PropertyCallExp) o).getReferredProperty().toString()
							+ ";");
				}
			}
			Visitor<String, Classifier, Operation, Property, EnumerationLiteral, Parameter, State, CallOperationAction, SendSignalAction, Constraint> amplConverter = new OCLtoAMPLVisitor<Classifier, EnumerationLiteral, Parameter, State, CallOperationAction, SendSignalAction>();
			System.out.println(amplConverter.visitExpressionInOCL((ExpressionInOCL)query.getSpecification()));
			System.out.println(amplConverter.visitConstraint(query));
			// record success
		} catch (ParserException e) {
			// record failure to parse
			System.err.println(e.getLocalizedMessage());
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		readCmdArgs(args);

		// read Model
		Model model = (Model) load(inFile).get(0);
		out("ModelName: " + model.getName()); //$NON-NLS-1$

		Package package1 = model.getNestedPackage("Package1");
		out(package1.toString());
		Class class1 = (Class) package1.getPackagedElement("Class1");
		out(class1.toString());
		ConstraintParsing.parseOCLExpr(class1, "x<2");
		try {
			//Activity activity = selectActivity(model);
			Operation operation = class1.getOwnedOperations().get(0);
			ConstraintParsing.parseOCLOperationExpr(class1, operation, "a=2*x@pre");
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		// a.parseOCLExpr(simpleDecision,"a<10");
	}

}
