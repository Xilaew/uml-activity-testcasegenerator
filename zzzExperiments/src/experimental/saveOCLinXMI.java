package experimental;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.helper.ConstraintKind;
import org.eclipse.ocl.helper.OCLHelper;
import org.eclipse.ocl.uml.OCL;
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

public class saveOCLinXMI extends tools.AbstractTool {

	protected static Constraint parseOCLExpr(Classifier context,
			String invariant, ConstraintKind kind) {

		OCL ocl;
		UMLEnvironmentFactory umlEnv = new UMLEnvironmentFactory();
		ocl = OCL.newInstance(umlEnv);
		
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
	
	/**
	 * @param args
	 */
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
		Constraint c =  parseOCLExpr(class1, "x<>2", ConstraintKind.INVARIANT);
		class1.getOwnedRules().add(c);
		EList<EObject> content = new BasicEList<EObject>();
		content.add(model);
		save(content, outFile);
		
		// TODO Auto-generated method stub

	}

}
