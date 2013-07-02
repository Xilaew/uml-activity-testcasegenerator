/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.sf.parteg.base.testsuiteexport;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Complex</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.sf.parteg.base.testsuiteexport.Complex#getOp <em>Op</em>}</li>
 *   <li>{@link net.sf.parteg.base.testsuiteexport.Complex#getFirst <em>First</em>}</li>
 *   <li>{@link net.sf.parteg.base.testsuiteexport.Complex#getSecond <em>Second</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.sf.parteg.base.testsuiteexport.TestsuiteexportPackage#getComplex()
 * @model
 * @generated
 */
public interface Complex extends Exp {
	/**
	 * Returns the value of the '<em><b>Op</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Op</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Op</em>' attribute.
	 * @see #setOp(String)
	 * @see net.sf.parteg.base.testsuiteexport.TestsuiteexportPackage#getComplex_Op()
	 * @model required="true"
	 * @generated
	 */
	String getOp();

	/**
	 * Sets the value of the '{@link net.sf.parteg.base.testsuiteexport.Complex#getOp <em>Op</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Op</em>' attribute.
	 * @see #getOp()
	 * @generated
	 */
	void setOp(String value);

	/**
	 * Returns the value of the '<em><b>First</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>First</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>First</em>' containment reference.
	 * @see #setFirst(Exp)
	 * @see net.sf.parteg.base.testsuiteexport.TestsuiteexportPackage#getComplex_First()
	 * @model containment="true"
	 * @generated
	 */
	Exp getFirst();

	/**
	 * Sets the value of the '{@link net.sf.parteg.base.testsuiteexport.Complex#getFirst <em>First</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>First</em>' containment reference.
	 * @see #getFirst()
	 * @generated
	 */
	void setFirst(Exp value);

	/**
	 * Returns the value of the '<em><b>Second</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Second</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Second</em>' containment reference.
	 * @see #setSecond(Exp)
	 * @see net.sf.parteg.base.testsuiteexport.TestsuiteexportPackage#getComplex_Second()
	 * @model containment="true"
	 * @generated
	 */
	Exp getSecond();

	/**
	 * Sets the value of the '{@link net.sf.parteg.base.testsuiteexport.Complex#getSecond <em>Second</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Second</em>' containment reference.
	 * @see #getSecond()
	 * @generated
	 */
	void setSecond(Exp value);

} // Complex
