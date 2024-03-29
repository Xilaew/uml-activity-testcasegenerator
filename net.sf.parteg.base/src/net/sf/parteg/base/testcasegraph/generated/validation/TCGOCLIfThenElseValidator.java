/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.sf.parteg.base.testcasegraph.generated.validation;

import net.sf.parteg.base.testcasegraph.generated.TCGOCLExpression;

/**
 * A sample validator interface for {@link net.sf.parteg.base.testcasegraph.generated.TCGOCLIfThenElse}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface TCGOCLIfThenElseValidator {
	boolean validate();

	boolean validateCondition(TCGOCLExpression value);
	boolean validateThenExpression(TCGOCLExpression value);
	boolean validateElseExpression(TCGOCLExpression value);
}
