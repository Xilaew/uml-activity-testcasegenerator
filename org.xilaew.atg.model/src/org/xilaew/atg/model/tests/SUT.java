/**
 */
package org.xilaew.atg.model.tests;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SUT</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xilaew.atg.model.tests.SUT#getName <em>Name</em>}</li>
 *   <li>{@link org.xilaew.atg.model.tests.SUT#isObject <em>Object</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xilaew.atg.model.tests.TestsPackage#getSUT()
 * @model
 * @generated
 */
public interface SUT extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.xilaew.atg.model.tests.TestsPackage#getSUT_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.xilaew.atg.model.tests.SUT#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Object</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Object</em>' attribute.
	 * @see #setObject(boolean)
	 * @see org.xilaew.atg.model.tests.TestsPackage#getSUT_Object()
	 * @model
	 * @generated
	 */
	boolean isObject();

	/**
	 * Sets the value of the '{@link org.xilaew.atg.model.tests.SUT#isObject <em>Object</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Object</em>' attribute.
	 * @see #isObject()
	 * @generated
	 */
	void setObject(boolean value);

} // SUT
