/**
 */
package org.omg.spec.xmi._20110701.tests;

import junit.textui.TestRunner;

import org.omg.spec.xmi._20110701.Add;
import org.omg.spec.xmi._20110701._20110701Factory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Add</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class AddTest extends DifferenceTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(AddTest.class);
	}

	/**
	 * Constructs a new Add test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AddTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Add test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Add getFixture() {
		return (Add)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(_20110701Factory.eINSTANCE.createAdd());
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

} //AddTest
