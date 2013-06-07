package experimental;

import java.util.Iterator;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.examples.extlibrary.EXTLibraryPackage;
import org.eclipse.ocl.OCL;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.helper.ConstraintKind;
import org.eclipse.ocl.helper.OCLHelper;
import org.eclipse.ocl.uml.OperationCallExp;
import org.eclipse.ocl.uml.PropertyCallExp;
import org.eclipse.ocl.uml.UMLEnvironmentFactory;
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

import tools.UMLPathsearch;
import experiment.LibTest;

public class ConstraintParsing extends UMLPathsearch {

	boolean valid;
	Constraint query = null;

	public void parseOCLExpr(Classifier context, String invariant) {

		OCL<Package, Classifier, Operation, Property, EnumerationLiteral, Parameter, State, CallOperationAction, SendSignalAction, Constraint, Class, EObject> ocl;
		UMLEnvironmentFactory ecoreEnv = new UMLEnvironmentFactory();
		ocl = OCL.newInstance(ecoreEnv);

		// create an OCL helper object
		OCLHelper<Classifier, Operation, Property, Constraint> helper = ocl
				.createOCLHelper();

		try {
			// set the OCL context classifier
			helper.setContext(context);

			query = helper
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
			// record success
			valid = true;
		} catch (ParserException e) {
			// record failure to parse
			valid = false;
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

		ConstraintParsing a = new ConstraintParsing();

		a.parseOCLExpr(class1, "x<2");
		// a.parseOCLExpr(simpleDecision,"a<10");
	}

}
