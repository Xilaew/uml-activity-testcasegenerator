/**
 */
package org.xilaew.atg.model.abstractTestCaseGraph;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.xilaew.atg.model.abstractTestCaseGraph.AbstractTestCaseGraphPackage
 * @generated
 */
public interface AbstractTestCaseGraphFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AbstractTestCaseGraphFactory eINSTANCE = org.xilaew.atg.model.abstractTestCaseGraph.impl.AbstractTestCaseGraphFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Abstract TCG Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Abstract TCG Element</em>'.
	 * @generated
	 */
	AbstractTCGElement createAbstractTCGElement();

	/**
	 * Returns a new object of class '<em>Abstract TCG Container</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Abstract TCG Container</em>'.
	 * @generated
	 */
	AbstractTCGContainer createAbstractTCGContainer();

	/**
	 * Returns a new object of class '<em>Abstract TCG Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Abstract TCG Node</em>'.
	 * @generated
	 */
	AbstractTCGNode createAbstractTCGNode();

	/**
	 * Returns a new object of class '<em>Abstract TCG Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Abstract TCG Edge</em>'.
	 * @generated
	 */
	AbstractTCGEdge createAbstractTCGEdge();

	/**
	 * Returns a new object of class '<em>Abstract TCG Real Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Abstract TCG Real Node</em>'.
	 * @generated
	 */
	AbstractTCGRealNode createAbstractTCGRealNode();

	/**
	 * Returns a new object of class '<em>Abstract TCG Pseudo Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Abstract TCG Pseudo Node</em>'.
	 * @generated
	 */
	AbstractTCGPseudoNode createAbstractTCGPseudoNode();

	/**
	 * Returns a new object of class '<em>Abstract TCG Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Abstract TCG Constraint</em>'.
	 * @generated
	 */
	AbstractTCGConstraint createAbstractTCGConstraint();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	AbstractTestCaseGraphPackage getAbstractTestCaseGraphPackage();

} //AbstractTestCaseGraphFactory
