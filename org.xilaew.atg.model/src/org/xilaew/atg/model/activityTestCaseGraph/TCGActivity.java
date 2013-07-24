/**
 */
package org.xilaew.atg.model.activityTestCaseGraph;

import org.eclipse.emf.common.util.EList;

import org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGContainer;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TCG Activity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xilaew.atg.model.activityTestCaseGraph.TCGActivity#getVariables <em>Variables</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xilaew.atg.model.activityTestCaseGraph.ActivityTestCaseGraphPackage#getTCGActivity()
 * @model
 * @generated
 */
public interface TCGActivity extends AbstractTCGContainer {
	/**
	 * Returns the value of the '<em><b>Variables</b></em>' containment reference list.
	 * The list contents are of type {@link org.xilaew.atg.model.activityTestCaseGraph.TCGVariable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variables</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variables</em>' containment reference list.
	 * @see org.xilaew.atg.model.activityTestCaseGraph.ActivityTestCaseGraphPackage#getTCGActivity_Variables()
	 * @model containment="true"
	 * @generated
	 */
	EList<TCGVariable> getVariables();

} // TCGActivity
