/**
 */
package org.xilaew.atg.model.activityTestCaseGraph;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TCGOCL Variable Call Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xilaew.atg.model.activityTestCaseGraph.TCGOCLVariableCallExp#getVariable <em>Variable</em>}</li>
 *   <li>{@link org.xilaew.atg.model.activityTestCaseGraph.TCGOCLVariableCallExp#isIsPre <em>Is Pre</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xilaew.atg.model.activityTestCaseGraph.ActivityTestCaseGraphPackage#getTCGOCLVariableCallExp()
 * @model
 * @generated
 */
public interface TCGOCLVariableCallExp extends TCGOCLExpression {
	/**
	 * Returns the value of the '<em><b>Variable</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.xilaew.atg.model.activityTestCaseGraph.TCGVariable#getReferencedBy <em>Referenced By</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable</em>' reference.
	 * @see #setVariable(TCGVariable)
	 * @see org.xilaew.atg.model.activityTestCaseGraph.ActivityTestCaseGraphPackage#getTCGOCLVariableCallExp_Variable()
	 * @see org.xilaew.atg.model.activityTestCaseGraph.TCGVariable#getReferencedBy
	 * @model opposite="referencedBy" required="true"
	 * @generated
	 */
	TCGVariable getVariable();

	/**
	 * Sets the value of the '{@link org.xilaew.atg.model.activityTestCaseGraph.TCGOCLVariableCallExp#getVariable <em>Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable</em>' reference.
	 * @see #getVariable()
	 * @generated
	 */
	void setVariable(TCGVariable value);

	/**
	 * Returns the value of the '<em><b>Is Pre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Pre</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Pre</em>' attribute.
	 * @see #setIsPre(boolean)
	 * @see org.xilaew.atg.model.activityTestCaseGraph.ActivityTestCaseGraphPackage#getTCGOCLVariableCallExp_IsPre()
	 * @model
	 * @generated
	 */
	boolean isIsPre();

	/**
	 * Sets the value of the '{@link org.xilaew.atg.model.activityTestCaseGraph.TCGOCLVariableCallExp#isIsPre <em>Is Pre</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Pre</em>' attribute.
	 * @see #isIsPre()
	 * @generated
	 */
	void setIsPre(boolean value);

} // TCGOCLVariableCallExp
