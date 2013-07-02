/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.sf.parteg.base.testcasetree.generated;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TCGOCL If Then Else</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.sf.parteg.base.testcasetree.generated.TCGOCLIfThenElse#getCondition <em>Condition</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasetree.generated.TCGOCLIfThenElse#getThenExpression <em>Then Expression</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasetree.generated.TCGOCLIfThenElse#getElseExpression <em>Else Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.sf.parteg.base.testcasetree.generated.GeneratedPackage#getTCGOCLIfThenElse()
 * @model
 * @generated
 */
public interface TCGOCLIfThenElse extends TCGOCLExpression {
	/**
	 * Returns the value of the '<em><b>Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' reference.
	 * @see #setCondition(TCGOCLExpression)
	 * @see net.sf.parteg.base.testcasetree.generated.GeneratedPackage#getTCGOCLIfThenElse_Condition()
	 * @model required="true"
	 * @generated
	 */
	TCGOCLExpression getCondition();

	/**
	 * Sets the value of the '{@link net.sf.parteg.base.testcasetree.generated.TCGOCLIfThenElse#getCondition <em>Condition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' reference.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(TCGOCLExpression value);

	/**
	 * Returns the value of the '<em><b>Then Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Then Expression</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Then Expression</em>' reference.
	 * @see #setThenExpression(TCGOCLExpression)
	 * @see net.sf.parteg.base.testcasetree.generated.GeneratedPackage#getTCGOCLIfThenElse_ThenExpression()
	 * @model required="true"
	 * @generated
	 */
	TCGOCLExpression getThenExpression();

	/**
	 * Sets the value of the '{@link net.sf.parteg.base.testcasetree.generated.TCGOCLIfThenElse#getThenExpression <em>Then Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Then Expression</em>' reference.
	 * @see #getThenExpression()
	 * @generated
	 */
	void setThenExpression(TCGOCLExpression value);

	/**
	 * Returns the value of the '<em><b>Else Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Else Expression</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Else Expression</em>' reference.
	 * @see #setElseExpression(TCGOCLExpression)
	 * @see net.sf.parteg.base.testcasetree.generated.GeneratedPackage#getTCGOCLIfThenElse_ElseExpression()
	 * @model required="true"
	 * @generated
	 */
	TCGOCLExpression getElseExpression();

	/**
	 * Sets the value of the '{@link net.sf.parteg.base.testcasetree.generated.TCGOCLIfThenElse#getElseExpression <em>Else Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Else Expression</em>' reference.
	 * @see #getElseExpression()
	 * @generated
	 */
	void setElseExpression(TCGOCLExpression value);

} // TCGOCLIfThenElse
