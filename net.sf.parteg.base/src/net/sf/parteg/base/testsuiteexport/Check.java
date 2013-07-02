/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.sf.parteg.base.testsuiteexport;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Check</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.sf.parteg.base.testsuiteexport.Check#getSimpleExp <em>Simple Exp</em>}</li>
 *   <li>{@link net.sf.parteg.base.testsuiteexport.Check#getComplexExp <em>Complex Exp</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.sf.parteg.base.testsuiteexport.TestsuiteexportPackage#getCheck()
 * @model
 * @generated
 */
public interface Check extends Action {
	/**
	 * Returns the value of the '<em><b>Simple Exp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Simple Exp</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Simple Exp</em>' attribute.
	 * @see #setSimpleExp(String)
	 * @see net.sf.parteg.base.testsuiteexport.TestsuiteexportPackage#getCheck_SimpleExp()
	 * @model required="true"
	 * @generated
	 */
	String getSimpleExp();

	/**
	 * Sets the value of the '{@link net.sf.parteg.base.testsuiteexport.Check#getSimpleExp <em>Simple Exp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Simple Exp</em>' attribute.
	 * @see #getSimpleExp()
	 * @generated
	 */
	void setSimpleExp(String value);

	/**
	 * Returns the value of the '<em><b>Complex Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Complex Exp</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Complex Exp</em>' containment reference.
	 * @see #setComplexExp(Exp)
	 * @see net.sf.parteg.base.testsuiteexport.TestsuiteexportPackage#getCheck_ComplexExp()
	 * @model containment="true"
	 * @generated
	 */
	Exp getComplexExp();

	/**
	 * Sets the value of the '{@link net.sf.parteg.base.testsuiteexport.Check#getComplexExp <em>Complex Exp</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Complex Exp</em>' containment reference.
	 * @see #getComplexExp()
	 * @generated
	 */
	void setComplexExp(Exp value);

} // Check
