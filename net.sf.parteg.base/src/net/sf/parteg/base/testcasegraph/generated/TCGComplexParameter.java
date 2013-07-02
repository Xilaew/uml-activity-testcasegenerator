/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.sf.parteg.base.testcasegraph.generated;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TCG Complex Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.sf.parteg.base.testcasegraph.generated.TCGComplexParameter#getParameter <em>Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.sf.parteg.base.testcasegraph.generated.GeneratedPackage#getTCGComplexParameter()
 * @model
 * @generated
 */
public interface TCGComplexParameter extends TCGParameter {
	/**
	 * Returns the value of the '<em><b>Parameter</b></em>' reference list.
	 * The list contents are of type {@link net.sf.parteg.base.testcasegraph.generated.TCGParameter}.
	 * It is bidirectional and its opposite is '{@link net.sf.parteg.base.testcasegraph.generated.TCGParameter#getContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter</em>' reference list.
	 * @see net.sf.parteg.base.testcasegraph.generated.GeneratedPackage#getTCGComplexParameter_Parameter()
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGParameter#getContainer
	 * @model opposite="container"
	 * @generated
	 */
	EList<TCGParameter> getParameter();

} // TCGComplexParameter
