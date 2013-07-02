/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.sf.parteg.base.testcasegraph.generated;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TCG Primitive Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.sf.parteg.base.testcasegraph.generated.TCGPrimitiveParameter#getValueTypeRange <em>Value Type Range</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.sf.parteg.base.testcasegraph.generated.GeneratedPackage#getTCGPrimitiveParameter()
 * @model
 * @generated
 */
public interface TCGPrimitiveParameter extends TCGParameter {
	/**
	 * Returns the value of the '<em><b>Value Type Range</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value Type Range</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value Type Range</em>' reference.
	 * @see #setValueTypeRange(EObject)
	 * @see net.sf.parteg.base.testcasegraph.generated.GeneratedPackage#getTCGPrimitiveParameter_ValueTypeRange()
	 * @model required="true"
	 * @generated
	 */
	EObject getValueTypeRange();

	/**
	 * Sets the value of the '{@link net.sf.parteg.base.testcasegraph.generated.TCGPrimitiveParameter#getValueTypeRange <em>Value Type Range</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value Type Range</em>' reference.
	 * @see #getValueTypeRange()
	 * @generated
	 */
	void setValueTypeRange(EObject value);

} // TCGPrimitiveParameter
