/**
 */
package org.omg.spec.xmi._20110701.tests;

import junit.textui.TestRunner;

import org.omg.spec.xmi._20110701.Replace;
import org.omg.spec.xmi._20110701._20110701Factory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Replace</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ReplaceTest extends DifferenceTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ReplaceTest.class);
	}

	/**
	 * Constructs a new Replace test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReplaceTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Replace test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Replace getFixture() {
		return (Replace)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(_20110701Factory.eINSTANCE.createReplace());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //ReplaceTest
