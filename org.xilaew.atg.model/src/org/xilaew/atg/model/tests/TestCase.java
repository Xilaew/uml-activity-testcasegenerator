/**
 */
package org.xilaew.atg.model.tests;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Test Case</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xilaew.atg.model.tests.TestCase#getSut <em>Sut</em>}</li>
 *   <li>{@link org.xilaew.atg.model.tests.TestCase#getInitValues <em>Init Values</em>}</li>
 *   <li>{@link org.xilaew.atg.model.tests.TestCase#getFunction <em>Function</em>}</li>
 *   <li>{@link org.xilaew.atg.model.tests.TestCase#getTestForValue <em>Test For Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xilaew.atg.model.tests.TestsPackage#getTestCase()
 * @model
 * @generated
 */
public interface TestCase extends EObject {
	/**
	 * Returns the value of the '<em><b>Sut</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sut</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sut</em>' containment reference.
	 * @see #setSut(SUT)
	 * @see org.xilaew.atg.model.tests.TestsPackage#getTestCase_Sut()
	 * @model containment="true"
	 * @generated
	 */
	SUT getSut();

	/**
	 * Sets the value of the '{@link org.xilaew.atg.model.tests.TestCase#getSut <em>Sut</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sut</em>' containment reference.
	 * @see #getSut()
	 * @generated
	 */
	void setSut(SUT value);

	/**
	 * Returns the value of the '<em><b>Init Values</b></em>' containment reference list.
	 * The list contents are of type {@link org.xilaew.atg.model.tests.Value}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Init Values</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Init Values</em>' containment reference list.
	 * @see org.xilaew.atg.model.tests.TestsPackage#getTestCase_InitValues()
	 * @model containment="true"
	 * @generated
	 */
	EList<Value> getInitValues();

	/**
	 * Returns the value of the '<em><b>Function</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Function</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Function</em>' containment reference.
	 * @see #setFunction(FunctionCall)
	 * @see org.xilaew.atg.model.tests.TestsPackage#getTestCase_Function()
	 * @model containment="true"
	 * @generated
	 */
	FunctionCall getFunction();

	/**
	 * Sets the value of the '{@link org.xilaew.atg.model.tests.TestCase#getFunction <em>Function</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Function</em>' containment reference.
	 * @see #getFunction()
	 * @generated
	 */
	void setFunction(FunctionCall value);

	/**
	 * Returns the value of the '<em><b>Test For Value</b></em>' containment reference list.
	 * The list contents are of type {@link org.xilaew.atg.model.tests.Value}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Test For Value</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Test For Value</em>' containment reference list.
	 * @see org.xilaew.atg.model.tests.TestsPackage#getTestCase_TestForValue()
	 * @model containment="true"
	 * @generated
	 */
	EList<Value> getTestForValue();

} // TestCase
