package tools;

import java.io.IOException;
import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
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
import org.eclipse.uml2.uml.Activity;
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

import data.ActivityPath;

import util.Messages;
import utility.OCLtoAMPLVisitor;

public class AMPLModelGenerator extends UMLPathsearch {

	public static String generateParameterVar(Parameter param, int pathLength) {
		String typeSpec = null;
		if (param.getType().toString().contains("Integer"))
			typeSpec = ": integer";
		if (param.getType().toString().contains("Boolean"))
			typeSpec = "in 0..1";
		if (param.getType().toString().contains("Real"))
			typeSpec = "";
		if (param.getType().toString().contains("UnlimitedNatural"))
			typeSpec = "";
		if (typeSpec != null)
			return "var " + param.getName() + "{0.." + (pathLength - 1) + "} "
					+ typeSpec + ";";
		else return "" ;
	}
	
	public static String generatePropertyVar(Property property, int pathLength){
		String typeSpec = null;
		if (property.getType().toString().contains("Integer"))
			typeSpec = ": integer";
		if (property.getType().toString().contains("Boolean"))
			typeSpec = "in 0..1";
		if (property.getType().toString().contains("Real"))
			typeSpec = "";
		if (property.getType().toString().contains("UnlimitedNatural"))
			typeSpec = "";
		if (typeSpec != null)
			return "var " + "self_" + property.getName() + "{0.." + (pathLength - 1) + "} "
					+ typeSpec + ";";
		else return "" ;
	}

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

			Constraint query = helper.createConstraint(
					ConstraintKind.INVARIANT, invariant);
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
			System.out
					.println(amplConverter
							.visitExpressionInOCL((org.eclipse.ocl.utilities.ExpressionInOCL<Classifier, Parameter>) query
									.getSpecification()));
			System.out.println(amplConverter.visitConstraint(query));
			// record success
		} catch (ParserException e) {
			// record failure to parse
			System.err.println(e.getLocalizedMessage());
			e.printStackTrace();
		}

	}

	public static void parseOCLOperationExpr(Classifier context,
			Operation operation, String invariant) {

		OCL<Package, Classifier, Operation, Property, EnumerationLiteral, Parameter, State, CallOperationAction, SendSignalAction, Constraint, Class, EObject> ocl;
		UMLEnvironmentFactory umlEnv = new UMLEnvironmentFactory();
		ocl = OCL.newInstance(umlEnv);

		// create an OCL helper object
		OCLHelper<Classifier, Operation, Property, Constraint> helper = ocl
				.createOCLHelper();

		try {
			// set the OCL context classifier
			helper.setOperationContext(context, operation);

			Constraint query = helper.createConstraint(
					ConstraintKind.POSTCONDITION, invariant);
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
			System.out.println(amplConverter
					.visitExpressionInOCL((ExpressionInOCL) query
							.getSpecification()));
			System.out.println(amplConverter.visitConstraint(query));
			// record success
		} catch (ParserException e) {
			// record failure to parse
			System.err.println(e.getLocalizedMessage());
			e.printStackTrace();
		}

	}
	
	public static void main(String[] args){
		readCmdArgs(args);
		
		Model model = (Model) load(inFile).get(0);
		
		Activity activity = null;
		
		activity = selectActivity(model);

		
		ActivityPath path = findPath(activity);
		
		path.getEdges().size();
	}
}
