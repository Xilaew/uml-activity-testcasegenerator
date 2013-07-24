package tools;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.uml.ExpressionInOCL;
import org.eclipse.ocl.uml.OCL;
import org.eclipse.ocl.uml.OCL.Helper;
import org.eclipse.ocl.utilities.ASTNode;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Property;

public class OCLParser extends UMLPathsearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		readCmdArgs(args);
		Model model = (Model) load(inFile).get(0);
		Class umlClass = (Class) model.getOwnedMembers().get(0).getOwnedElements().get(0);
		Property umlProperty = (Property) umlClass.getOwnedAttributes().get(0);
		
		//initialize OCL stuff
		OCL ocl = OCL.newInstance();
		Helper helper = ocl.createOCLHelper();
		out(OCL.initialize(OCLParser.RESOURCE_SET));
		helper.setAttributeContext(umlClass, umlProperty);
		helper.setContext((Classifier) model.getOwnedMembers().get(0).getOwnedElements().get(0));
		out("The following elements are contained in the class:");
		out(model.getOwnedMembers().get(0).getOwnedElements().get(0).toString());
		out(helper.getEnvironment().getVariables().size()+"");
		out("Variables within the context:");
		for (Variable<Classifier, ?> v : helper.getEnvironment().getVariables()){
			out(v.toString());
			//out(v.getRepresentedParameter());
			//out(v.getName());
			//out(v.getType().toString());
			out(v.getClass().toString());
			//out(""+v.getTypeEndPosition());
			Iterator<EObject> it = v.eAllContents();
			while (it.hasNext()){
				out(it.next().getClass().toString());
			}

		}
		Constraint invariant = helper.createInvariant("x<5");
		Iterator<EObject> it = invariant.eAllContents();
		while (it.hasNext()){
			EObject o = it.next();
			out(o.getClass().toString());
			if ( o instanceof ASTNode ){
				out("found AST Node" + ((ASTNode) o).getStartPosition());
			}
		}
		out(invariant.toString());
		out(invariant.getSpecification().toString());
		ExpressionInOCL exp = (ExpressionInOCL) invariant.getSpecification();
		out(helper.getEnvironment().getVariables().size()+"");
		exp.getBodyExpression();
	}

}
