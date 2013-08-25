/**
 */
package org.xilaew.atg.model.testCaseGraphRuntime;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.xilaew.atg.model.testCaseGraphRuntime.TestCaseGraphRuntimePackage
 * @generated
 */
public interface TestCaseGraphRuntimeFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TestCaseGraphRuntimeFactory eINSTANCE = org.xilaew.atg.model.testCaseGraphRuntime.impl.TestCaseGraphRuntimeFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Path</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Path</em>'.
	 * @generated
	 */
	Path createPath();

	/**
	 * Returns a new object of class '<em>AMPL Path</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>AMPL Path</em>'.
	 * @generated
	 */
	AMPLPath createAMPLPath();

	/**
	 * Returns a new object of class '<em>index Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>index Set</em>'.
	 * @generated
	 */
	indexSet createindexSet();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	TestCaseGraphRuntimePackage getTestCaseGraphRuntimePackage();

} //TestCaseGraphRuntimeFactory
