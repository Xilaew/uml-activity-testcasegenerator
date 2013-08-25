/**
 */
package org.xilaew.atg.model.tests;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Test Suite</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A collection of test cases.
 * for Activity test case generator a test suite is intended to contain always the same SUT as well as the same function. And the Values referenced as paramters, initValues or testforValues should change from test case to testcase.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xilaew.atg.model.tests.TestSuite#getTests <em>Tests</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xilaew.atg.model.tests.TestsPackage#getTestSuite()
 * @model
 * @generated
 */
public interface TestSuite extends EObject {
	/**
	 * Returns the value of the '<em><b>Tests</b></em>' containment reference list.
	 * The list contents are of type {@link org.xilaew.atg.model.tests.TestCase}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tests</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tests</em>' containment reference list.
	 * @see org.xilaew.atg.model.tests.TestsPackage#getTestSuite_Tests()
	 * @model containment="true"
	 * @generated
	 */
	EList<TestCase> getTests();

} // TestSuite
