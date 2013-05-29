/**
 */
package org.omg.spec.xmi._20110701.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>_20110701</b></em>' package.
 * <!-- end-user-doc -->
 * @generated
 */
public class _20110701Tests extends TestSuite {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(suite());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Test suite() {
		TestSuite suite = new _20110701Tests("_20110701 Tests");
		suite.addTestSuite(AddTest.class);
		suite.addTestSuite(AnyTest.class);
		suite.addTestSuite(DeleteTest.class);
		suite.addTestSuite(DifferenceTest.class);
		suite.addTestSuite(DocumentationTest.class);
		suite.addTestSuite(DocumentRootTest.class);
		suite.addTestSuite(ExtensionTest.class);
		suite.addTestSuite(ReplaceTest.class);
		suite.addTestSuite(TargetTypeTest.class);
		suite.addTestSuite(XMITest.class);
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public _20110701Tests(String name) {
		super(name);
	}

} //_20110701Tests
