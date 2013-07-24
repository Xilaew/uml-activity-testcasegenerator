/**
 */
package org.xilaew.atg.model.activityTestCaseGraph;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TCGOCL Operation Call Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xilaew.atg.model.activityTestCaseGraph.TCGOCLOperationCallExp#getSource <em>Source</em>}</li>
 *   <li>{@link org.xilaew.atg.model.activityTestCaseGraph.TCGOCLOperationCallExp#getArguments <em>Arguments</em>}</li>
 *   <li>{@link org.xilaew.atg.model.activityTestCaseGraph.TCGOCLOperationCallExp#getOperation <em>Operation</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xilaew.atg.model.activityTestCaseGraph.ActivityTestCaseGraphPackage#getTCGOCLOperationCallExp()
 * @model
 * @generated
 */
public interface TCGOCLOperationCallExp extends TCGOCLExpression {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' containment reference.
	 * @see #setSource(TCGOCLExpression)
	 * @see org.xilaew.atg.model.activityTestCaseGraph.ActivityTestCaseGraphPackage#getTCGOCLOperationCallExp_Source()
	 * @model containment="true"
	 * @generated
	 */
	TCGOCLExpression getSource();

	/**
	 * Sets the value of the '{@link org.xilaew.atg.model.activityTestCaseGraph.TCGOCLOperationCallExp#getSource <em>Source</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' containment reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(TCGOCLExpression value);

	/**
	 * Returns the value of the '<em><b>Arguments</b></em>' containment reference list.
	 * The list contents are of type {@link org.xilaew.atg.model.activityTestCaseGraph.TCGOCLExpression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Arguments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Arguments</em>' containment reference list.
	 * @see org.xilaew.atg.model.activityTestCaseGraph.ActivityTestCaseGraphPackage#getTCGOCLOperationCallExp_Arguments()
	 * @model containment="true"
	 * @generated
	 */
	EList<TCGOCLExpression> getArguments();

	/**
	 * Returns the value of the '<em><b>Operation</b></em>' attribute.
	 * The literals are from the enumeration {@link org.xilaew.atg.model.activityTestCaseGraph.TCGOCLOperationType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation</em>' attribute.
	 * @see org.xilaew.atg.model.activityTestCaseGraph.TCGOCLOperationType
	 * @see #setOperation(TCGOCLOperationType)
	 * @see org.xilaew.atg.model.activityTestCaseGraph.ActivityTestCaseGraphPackage#getTCGOCLOperationCallExp_Operation()
	 * @model required="true"
	 * @generated
	 */
	TCGOCLOperationType getOperation();

	/**
	 * Sets the value of the '{@link org.xilaew.atg.model.activityTestCaseGraph.TCGOCLOperationCallExp#getOperation <em>Operation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation</em>' attribute.
	 * @see org.xilaew.atg.model.activityTestCaseGraph.TCGOCLOperationType
	 * @see #getOperation()
	 * @generated
	 */
	void setOperation(TCGOCLOperationType value);

} // TCGOCLOperationCallExp
