/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.sf.parteg.base.testcasegraph.generated.validation;


/**
 * A sample validator interface for {@link net.sf.parteg.base.testcasegraph.generated.TCGEquivalenceClass}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface TCGEquivalenceClassValidator {
	boolean validate();

	boolean validateMinBorder(Double value);
	boolean validateMinIncluded(Boolean value);
	boolean validateMaxBorder(Double value);
	boolean validateMaxIncluded(Boolean value);
}