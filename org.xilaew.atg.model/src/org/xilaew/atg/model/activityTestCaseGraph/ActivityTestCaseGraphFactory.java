/**
 */
package org.xilaew.atg.model.activityTestCaseGraph;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.xilaew.atg.model.activityTestCaseGraph.ActivityTestCaseGraphPackage
 * @generated
 */
public interface ActivityTestCaseGraphFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ActivityTestCaseGraphFactory eINSTANCE = org.xilaew.atg.model.activityTestCaseGraph.impl.ActivityTestCaseGraphFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>TCG Activity</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>TCG Activity</em>'.
	 * @generated
	 */
	TCGActivity createTCGActivity();

	/**
	 * Returns a new object of class '<em>TCG Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>TCG Action</em>'.
	 * @generated
	 */
	TCGAction createTCGAction();

	/**
	 * Returns a new object of class '<em>TCG Control Flow</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>TCG Control Flow</em>'.
	 * @generated
	 */
	TCGControlFlow createTCGControlFlow();

	/**
	 * Returns a new object of class '<em>TCG Control Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>TCG Control Node</em>'.
	 * @generated
	 */
	TCGControlNode createTCGControlNode();

	/**
	 * Returns a new object of class '<em>TCG Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>TCG Variable</em>'.
	 * @generated
	 */
	TCGVariable createTCGVariable();

	/**
	 * Returns a new object of class '<em>TCG Object Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>TCG Object Variable</em>'.
	 * @generated
	 */
	TCGObjectVariable createTCGObjectVariable();

	/**
	 * Returns a new object of class '<em>TCG Basic Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>TCG Basic Variable</em>'.
	 * @generated
	 */
	TCGBasicVariable createTCGBasicVariable();

	/**
	 * Returns a new object of class '<em>TCGOCL Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>TCGOCL Expression</em>'.
	 * @generated
	 */
	TCGOCLExpression createTCGOCLExpression();

	/**
	 * Returns a new object of class '<em>TCGOCL Operation Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>TCGOCL Operation Call Exp</em>'.
	 * @generated
	 */
	TCGOCLOperationCallExp createTCGOCLOperationCallExp();

	/**
	 * Returns a new object of class '<em>TCGOCL Variable Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>TCGOCL Variable Call Exp</em>'.
	 * @generated
	 */
	TCGOCLVariableCallExp createTCGOCLVariableCallExp();

	/**
	 * Returns a new object of class '<em>TCGOCL Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>TCGOCL Literal Exp</em>'.
	 * @generated
	 */
	TCGOCLLiteralExp createTCGOCLLiteralExp();

	/**
	 * Returns an instance of data type '<em>TCG Basic Variable Type</em>' corresponding the given literal.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal a literal of the data type.
	 * @return a new instance value of the data type.
	 * @generated
	 */
	TCGBasicVariableType createTCGBasicVariableType(String literal);

	/**
	 * Returns a literal representation of an instance of data type '<em>TCG Basic Variable Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param instanceValue an instance value of the data type.
	 * @return a literal representation of the instance value.
	 * @generated
	 */
	String convertTCGBasicVariableType(TCGBasicVariableType instanceValue);

	/**
	 * Returns an instance of data type '<em>TCGOCL Operation Type</em>' corresponding the given literal.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal a literal of the data type.
	 * @return a new instance value of the data type.
	 * @generated
	 */
	TCGOCLOperationType createTCGOCLOperationType(String literal);

	/**
	 * Returns a literal representation of an instance of data type '<em>TCGOCL Operation Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param instanceValue an instance value of the data type.
	 * @return a literal representation of the instance value.
	 * @generated
	 */
	String convertTCGOCLOperationType(TCGOCLOperationType instanceValue);

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ActivityTestCaseGraphPackage getActivityTestCaseGraphPackage();

} //ActivityTestCaseGraphFactory
