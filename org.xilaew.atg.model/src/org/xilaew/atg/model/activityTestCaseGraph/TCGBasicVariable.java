/**
 */
package org.xilaew.atg.model.activityTestCaseGraph;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TCG Basic Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * represents either int,boolean or float variables
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xilaew.atg.model.activityTestCaseGraph.TCGBasicVariable#getVariableType <em>Variable Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xilaew.atg.model.activityTestCaseGraph.ActivityTestCaseGraphPackage#getTCGBasicVariable()
 * @model
 * @generated
 */
public interface TCGBasicVariable extends TCGVariable {
	/**
	 * Returns the value of the '<em><b>Variable Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.xilaew.atg.model.activityTestCaseGraph.TCGBasicVariableType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable Type</em>' attribute.
	 * @see org.xilaew.atg.model.activityTestCaseGraph.TCGBasicVariableType
	 * @see #setVariableType(TCGBasicVariableType)
	 * @see org.xilaew.atg.model.activityTestCaseGraph.ActivityTestCaseGraphPackage#getTCGBasicVariable_VariableType()
	 * @model required="true"
	 * @generated
	 */
	TCGBasicVariableType getVariableType();

	/**
	 * Sets the value of the '{@link org.xilaew.atg.model.activityTestCaseGraph.TCGBasicVariable#getVariableType <em>Variable Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable Type</em>' attribute.
	 * @see org.xilaew.atg.model.activityTestCaseGraph.TCGBasicVariableType
	 * @see #getVariableType()
	 * @generated
	 */
	void setVariableType(TCGBasicVariableType value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	void getAbsoluteName();

} // TCGBasicVariable
