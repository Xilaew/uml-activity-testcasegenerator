/**
 */
package org.omg.spec.xmi._20110701.tests;

import junit.textui.TestRunner;

import org.omg.spec.xmi._20110701.Delete;
import org.omg.spec.xmi._20110701._20110701Factory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Delete</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class DeleteTest extends DifferenceTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(DeleteTest.class);
	}

	/**
	 * Constructs a new Delete test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeleteTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Delete test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Delete getFixture() {
		return (Delete)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(_20110701Factory.eINSTANCE.createDelete());
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

} //DeleteTest
