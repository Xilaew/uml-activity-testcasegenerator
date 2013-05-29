package tools;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.uml.ExpressionInOCL;
import org.eclipse.ocl.uml.OCL;
import org.eclipse.ocl.uml.OCL.Helper;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Model;

public class OCLParser extends UMLPathsearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		readCmdArgs(args);
		OCL ocl = OCL.newInstance();
		Helper helper = ocl.createOCLHelper();
		Model model = (Model) load(inFile).get(0);
		//Activity act = selectActivity(model);
		helper.setContext((Classifier) model.getOwnedMembers().get(0).getOwnedElements().get(0));
		out(model.getOwnedMembers().get(0).getOwnedElements().get(0).toString());
		out(helper.getEnvironment().getVariables().size()+"");
		for (Variable<Classifier, ?> v : helper.getEnvironment().getVariables()){
			out(v.toString());
			//out(v.getRepresentedParameter());
			out(v.getName());
			out(v.getType().toString());
			out(""+v.getTypeEndPosition());
			Iterator<EObject> it = v.eAllContents();
			while (it.hasNext()){
				out(it.next().getClass().toString());
			}

		}
		Constraint invariant = helper.createInvariant("self.x<5");
		Iterator<EObject> it = invariant.eAllContents();
		while (it.hasNext()){
			out(it.next().getClass().toString());
		}
		out(invariant.toString());
		out(invariant.getSpecification().toString());
		ExpressionInOCL exp = (ExpressionInOCL) invariant.getSpecification();
		out(helper.getEnvironment().getVariables().size()+"");
		exp.getBodyExpression();
	}

}
