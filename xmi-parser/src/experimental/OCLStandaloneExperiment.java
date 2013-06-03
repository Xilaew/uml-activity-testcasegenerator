/**
 * 
 */
package experimental;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.examples.extlibrary.EXTLibraryPackage;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.OCL;
import org.eclipse.ocl.examples.pivot.ParserException;
import org.eclipse.ocl.examples.pivot.helper.OCLHelper;
import org.eclipse.ocl.examples.pivot.utilities.PivotEnvironmentFactory;

import tools.AbstractTool;

/**
 * @author th51e0
 * 
 */
public class OCLStandaloneExperiment extends AbstractTool {

	/**
	 * @param args
	 * @throws ParserException
	 */
	public static void main(String[] args) throws ParserException {
		ResourceSet resourceSet = new ResourceSetImpl();
		org.eclipse.ocl.examples.pivot.OCL.initialize(resourceSet);
		org.eclipse.ocl.examples.pivot.uml.UML2Pivot.initialize(resourceSet);
		OCL ocl = OCL.newInstance(new PivotEnvironmentFactory());

		// create an OCL helper object
		OCLHelper helper = ocl
				.createOCLHelper(EXTLibraryPackage.Literals.LIBRARY);

		ExpressionInOCL invariant = helper
				.createInvariant("books->forAll(b1, b2 | b1 <> b2 implies b1.title <> b2.title)");

		ExpressionInOCL query = helper
				.createQuery("books->collect(b : Book | b.category)->asSet()");

		Iterator<EObject> it = invariant.eAllContents();
		while (it.hasNext()) {
			out(it.next().toString());
		}

	}

}
