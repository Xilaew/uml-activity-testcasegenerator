/**
 */
package org.xilaew.atg.model.activityTestCaseGraph;

import org.eclipse.emf.common.util.EList;

import org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGContainer;
import org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGNode;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TCG Structured Activity Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xilaew.atg.model.activityTestCaseGraph.TCGStructuredActivityNode#getVariables <em>Variables</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xilaew.atg.model.activityTestCaseGraph.ActivityTestCaseGraphPackage#getTCGStructuredActivityNode()
 * @model
 * @generated
 */
public interface TCGStructuredActivityNode extends AbstractTCGContainer, AbstractTCGNode {
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
	 * @see org.xilaew.atg.model.activityTestCaseGraph.ActivityTestCaseGraphPackage#getTCGStructuredActivityNode_Variables()
	 * @model containment="true"
	 * @generated
	 */
	EList<TCGVariable> getVariables();

} // TCGStructuredActivityNode
