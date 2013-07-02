/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.sf.parteg.base.testcasetree.generated;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TCG Primitive Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.sf.parteg.base.testcasetree.generated.TCGPrimitiveParameter#getEquivalenceClass <em>Equivalence Class</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.sf.parteg.base.testcasetree.generated.GeneratedPackage#getTCGPrimitiveParameter()
 * @model
 * @generated
 */
public interface TCGPrimitiveParameter extends TCGParameter {
	/**
	 * Returns the value of the '<em><b>Equivalence Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Equivalence Class</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Equivalence Class</em>' reference.
	 * @see #setEquivalenceClass(TCGEquivalenceClass)
	 * @see net.sf.parteg.base.testcasetree.generated.GeneratedPackage#getTCGPrimitiveParameter_EquivalenceClass()
	 * @model required="true"
	 * @generated
	 */
	TCGEquivalenceClass getEquivalenceClass();

	/**
	 * Sets the value of the '{@link net.sf.parteg.base.testcasetree.generated.TCGPrimitiveParameter#getEquivalenceClass <em>Equivalence Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Equivalence Class</em>' reference.
	 * @see #getEquivalenceClass()
	 * @generated
	 */
	void setEquivalenceClass(TCGEquivalenceClass value);

} // TCGPrimitiveParameter
