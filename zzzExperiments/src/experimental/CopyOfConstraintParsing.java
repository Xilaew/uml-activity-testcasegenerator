package experimental;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.uml.OCL;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.helper.ConstraintKind;
import org.eclipse.ocl.helper.OCLHelper;
import org.eclipse.ocl.uml.ExpressionInOCL;
import org.eclipse.ocl.uml.OCL.Helper;
import org.eclipse.ocl.uml.OperationCallExp;
import org.eclipse.ocl.uml.PropertyCallExp;
import org.eclipse.ocl.uml.UMLEnvironmentFactory;
import org.eclipse.ocl.utilities.Visitor;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.AggregationKind;
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

public class CopyOfConstraintParsing extends UMLPathsearch {

	public static void parseOCLExpr(Classifier context, String invariant) {

		OCL ocl;
		UMLEnvironmentFactory umlEnv = new UMLEnvironmentFactory();
		ocl = OCL.newInstance(umlEnv);

		// create an OCL helper object
		Helper helper = ocl
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

		OCL ocl;
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

	protected static Operation adaptVariables(Class containingClass,
			Activity activity) {
		out(activity.getName());
		for (Parameter p : activity.getOwnedParameters()) {
			Property prop = containingClass.createOwnedAttribute(p.getName(), p.getType());
			prop.setAggregation(AggregationKind.COMPOSITE_LITERAL);
			out("converting " + p.getName() + " into Attribute");
			// p.destroy();
		}
		return containingClass.createOwnedOperation(activity.getName(), null,
				null);
	}
	
	protected static Operation adaptVariables2(Activity activity){
		out(activity.getName());
		for (Parameter p:activity.getOwnedParameters()){
			out("converting "+p.getName()+" into Attribute");
			activity.createOwnedAttribute(p.getName(), p.getType());
			p.destroy();
		}
		Parameter p = (Parameter) activity.getOwnedMember("return");
		activity.createOwnedAttribute(p.getName(), p.getType());
		p.destroy();
		return activity.createOwnedOperation(activity.getName(), null, null);
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
		Activity activity = (Activity) class1.getOwnedBehaviors().get(0);
		out(activity.toString());
		//Operation operation = adaptVariables(class1,activity);
		//out(operation.toString());
		for(Property p : class1.getOwnedAttributes()){
			out(p.toString());
			//out(p.getType().toString());
		}
		CopyOfConstraintParsing.parseOCLExpr(class1, "x<2");
		try {
			//Activity activity = selectActivity(model);
			//Operation operation = class1.getOwnedOperations().get(0);
			//Operation operation = adaptVariables2(activity);
			//ConstraintParsing.parseOCLOperationExpr(class1, operation, "return=false");
			//ConstraintParsing.parseOCLOperationExpr(activity, operation, "classAtribute=activityAtribute");
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		// a.parseOCLExpr(simpleDecision,"a<10");
	}

}
