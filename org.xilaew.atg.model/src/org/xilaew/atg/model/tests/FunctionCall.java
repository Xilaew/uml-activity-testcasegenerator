/**
 */
package org.xilaew.atg.model.tests;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Function Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xilaew.atg.model.tests.FunctionCall#getName <em>Name</em>}</li>
 *   <li>{@link org.xilaew.atg.model.tests.FunctionCall#getParameters <em>Parameters</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xilaew.atg.model.tests.TestsPackage#getFunctionCall()
 * @model
 * @generated
 */
public interface FunctionCall extends EObject {
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
	 * @see org.xilaew.atg.model.tests.TestsPackage#getFunctionCall_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.xilaew.atg.model.tests.FunctionCall#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link org.xilaew.atg.model.tests.Value}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see org.xilaew.atg.model.tests.TestsPackage#getFunctionCall_Parameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<Value> getParameters();

} // FunctionCall
