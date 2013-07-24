/**
 */
package org.xilaew.atg.model.activityTestCaseGraph;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TCGOCL Literal Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xilaew.atg.model.activityTestCaseGraph.TCGOCLLiteralExp#getType <em>Type</em>}</li>
 *   <li>{@link org.xilaew.atg.model.activityTestCaseGraph.TCGOCLLiteralExp#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xilaew.atg.model.activityTestCaseGraph.ActivityTestCaseGraphPackage#getTCGOCLLiteralExp()
 * @model
 * @generated
 */
public interface TCGOCLLiteralExp extends TCGOCLExpression {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.xilaew.atg.model.activityTestCaseGraph.TCGBasicVariableType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see org.xilaew.atg.model.activityTestCaseGraph.TCGBasicVariableType
	 * @see #setType(TCGBasicVariableType)
	 * @see org.xilaew.atg.model.activityTestCaseGraph.ActivityTestCaseGraphPackage#getTCGOCLLiteralExp_Type()
	 * @model
	 * @generated
	 */
	TCGBasicVariableType getType();

	/**
	 * Sets the value of the '{@link org.xilaew.atg.model.activityTestCaseGraph.TCGOCLLiteralExp#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see org.xilaew.atg.model.activityTestCaseGraph.TCGBasicVariableType
	 * @see #getType()
	 * @generated
	 */
	void setType(TCGBasicVariableType value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * the value of the literal is stored as a float. Depending on the type it has either to be interpreted:
	 * as boolean 0=false, 1=true, everything else = undefined;
	 * as integer only the integral part of value is evaluatet e.g. 4.989=>4; 2.000=>2 (those are the normal typecasting rules)
	 * as float you can guess that one.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(float)
	 * @see org.xilaew.atg.model.activityTestCaseGraph.ActivityTestCaseGraphPackage#getTCGOCLLiteralExp_Value()
	 * @model
	 * @generated
	 */
	float getValue();

	/**
	 * Sets the value of the '{@link org.xilaew.atg.model.activityTestCaseGraph.TCGOCLLiteralExp#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(float value);

} // TCGOCLLiteralExp
