package tools;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.OCL;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.helper.ConstraintKind;
import org.eclipse.ocl.helper.OCLHelper;
import org.eclipse.ocl.uml.ExpressionInOCL;
import org.eclipse.ocl.uml.OperationCallExp;
import org.eclipse.ocl.uml.PropertyCallExp;
import org.eclipse.ocl.uml.UMLEnvironmentFactory;
import org.eclipse.ocl.utilities.Visitor;
import org.eclipse.uml2.uml.Action;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.CallOperationAction;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.ControlFlow;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.SendSignalAction;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.internal.impl.TypedElementImpl;

import data.ActivityPath;
import data.ConstraintMap;

import util.Messages;
import utility.OCLtoAMPLVisitor;

public class AMPLModelGenerator extends UMLPathsearch {

	static UMLEnvironmentFactory umlEnv = new UMLEnvironmentFactory();
	static OCL<Package, Classifier, Operation, Property, EnumerationLiteral, Parameter, State, CallOperationAction, SendSignalAction, Constraint, Class, EObject> ocl = OCL
			.newInstance(umlEnv);

	protected static String generateParameterVar(Parameter param, int pathLength) {
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
			return "var " + param.getName() + "{0.." + (pathLength) + "} "
					+ typeSpec + ";";
		else
			return "";
	}

	protected static Operation adaptVariables(Class containingClass,
			Activity activity) {
		out(activity.getName());
		for (Parameter p : activity.getOwnedParameters()) {
			// XXX do not use getType(). it will cause the OCL parser to crash.
			// Instead cast to TypedElementImpl and call basicGetType()
			Property prop = containingClass.createOwnedAttribute(p.getName(),
					((TypedElementImpl) p).basicGetType());
			out("converting " + p.getName() + " into Attribute");
		}
		return containingClass.createOwnedOperation(activity.getName(), null,
				null);
	}

	protected static String generatePropertyVar(Property property,
			int pathLength) {
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
			return "var " + "self_" + property.getName() + "{0.."
					+ (pathLength) + "} " + typeSpec + ";";
		else
			return "";
	}

	protected static Constraint parseOCLExpr(Classifier context,
			String invariant) {

		return parseOCLExpr(context, invariant, ConstraintKind.INVARIANT);
	}

	protected static Constraint parseOCLExpr(Classifier context,
			String invariant, ConstraintKind kind) {

		// create an OCL helper object
		OCLHelper<Classifier, Operation, Property, Constraint> helper = ocl
				.createOCLHelper();
		Constraint query;
		try {
			// set the OCL context classifier
			helper.setContext(context);

			query = helper.createConstraint(kind, invariant);
		} catch (ParserException e) {
			// record failure to parse
			System.err.println(e.getLocalizedMessage());
			e.printStackTrace();
			query = null;
		}
		return query;
	}

	protected static Constraint parseOCLOperationExpr(Classifier context,
			Operation operation, String invariant) {
		Constraint ret;
		OCLHelper<Classifier, Operation, Property, Constraint> helper = ocl
				.createOCLHelper();

		try {
			// set the OCL context classifier
			helper.setOperationContext(context, operation);
			// actually parse the expression
			ret = helper.createConstraint(ConstraintKind.POSTCONDITION,
					invariant);
		} catch (ParserException e) {
			// record failure to parse
			System.err.println(e.getLocalizedMessage());
			e.printStackTrace();
			ret = null;
		}
		return ret;
	}

	public static void main(String[] args) {
		readCmdArgs(args);

		// initialize some necessary Helpers and Variables
		int pathLength = 0;
		PrintWriter out = null;
		try {
			out = new PrintWriter(new FileWriter(outFile));
		} catch (IOException e) {
			err(Messages.getString("ErrorMessage.COULD_NOT_OPEN_FILE"));
			System.exit(-1);
		}
		OCLtoAMPLVisitor<Classifier, EnumerationLiteral, Parameter, State, CallOperationAction, SendSignalAction> amplConverter = new OCLtoAMPLVisitor<Classifier, EnumerationLiteral, Parameter, State, CallOperationAction, SendSignalAction>();
		List<String> amplConstraints = new ArrayList<String>();
		List<Constraint> oclConstraints = new ArrayList<Constraint>();
		Model model = (Model) load(inFile).get(0);

		// Navigate through the Model and retrive relevant Elements
		out("the Context of oure OCL parsing: ");
		Activity activity = null;
		activity = selectActivity(model);
		fillConstraintMap(activity);
		out("activitys parameters: " + activity.getOwnedParameters().toString());
		Class containingClass = (Class) activity.eContainer();
		out("containingClass: " + containingClass.toString());
		Operation operation = adaptVariables(containingClass, activity);
		out("operation: " + operation.toString());

		// find Control Flow Path
		ActivityPath path = findPath(activity);

		int guardCounter = 0;
		int actionCounter = 0;
		pathLength = 0;
		for (ControlFlow cf : path.getEdges()) {
			ValueSpecification guard = cf.getGuard();
			ActivityNode a = cf.getTarget();
			out(cf.getGuard() + "");
			if (guard != null) {
				String oclString = "";
				for (String s : ((OpaqueExpression) guard).getBodies()) {
					oclString = oclString.concat(s);
				}
				out(oclString);
				out("the Constraint To parse #######################");
				out(oclString);
				out("the Constraint To parse #######################");
				Constraint c = parseOCLExpr(containingClass, oclString);
				oclConstraints.add(c);
				amplConverter.setVariableIndex(pathLength);
				String s = amplConverter.visitConstraint(c);
				out(s);
				amplConstraints.add("s.t. guard"+guardCounter++ +" : "+ s + ";");
			}
			if (a instanceof Action) {
				EList<Constraint> constraints = ConstraintMap.INSTANCE.get(a);
				if (constraints != null) {
					pathLength++;
					out("found constraints:");
					for (Constraint c : constraints) {
						out(c.toString());
						out(c.getSpecification().toString());
						String oclString = "";
						for (String s : ((OpaqueExpression) c
								.getSpecification()).getBodies()) {
							oclString = oclString.concat(s);
						}
						out("the Constraint To parse #######################");
						out(oclString);
						out("the Constraint To parse #######################");
						Constraint c1 = parseOCLOperationExpr(containingClass,
								operation, oclString);
						oclConstraints.add(c1);
						amplConverter.setVariableIndex(pathLength);
						String s = amplConverter.visitConstraint(c1);
						out(s);
						amplConstraints.add("s.t. action" + actionCounter++ +" : "+ s +";");
					}
				}
			}
		}
		// write necessary Variable Definitions into the AMPL Model File
		for (Parameter p : activity.getOwnedParameters()) {
			out.println(generateParameterVar(p, pathLength));
		}
		for (Property f : ((Class) activity.getOwner()).getOwnedAttributes()) {
			out.println(generatePropertyVar(f, pathLength));
		}
		for (String ampl : amplConstraints ){
			out.println(ampl);
		}

		out.close();
	}
}
