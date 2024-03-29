/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.sf.parteg.base.testcasegraph.generated.validation;

import net.sf.parteg.base.testcasegraph.generated.TCGNode;
import net.sf.parteg.base.testcasegraph.generated.TCGOCLExpression;
import net.sf.parteg.base.testcasegraph.generated.TCGParameter;
import net.sf.parteg.base.testcasegraph.generated.TCGRealNode;
import net.sf.parteg.base.testcasegraph.generated.TCGTransition;
import net.sf.parteg.base.testcasegraph.generated.TestCaseRegion;

import org.eclipse.emf.common.util.EList;

/**
 * A sample validator interface for {@link net.sf.parteg.base.testcasegraph.generated.TestCaseGraph}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface TestCaseGraphValidator {
	boolean validate();

	boolean validateRegions(EList<TestCaseRegion> value);

	boolean validateCompositeSuperState(TCGRealNode value);

	boolean validateSuperState(TCGNode value);

	boolean validateSuperStates(EList<TCGNode> value);

	boolean validateContainedConnectionPoints(EList<TCGNode> value);

	boolean validateSubmachineStates(EList<TCGNode> value);

	boolean validateConnectionnodes(EList<TCGNode> value);

	boolean validateRoot(TCGNode value);
	boolean validateNodes(EList<TCGNode> value);
	boolean validateTransitions(EList<TCGTransition> value);
	boolean validateConditions(EList<TCGOCLExpression> value);
	boolean validateAttributes(EList<TCGParameter> value);
}
