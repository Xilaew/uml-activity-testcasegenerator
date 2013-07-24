/**
 */
package org.xilaew.atg.model.activityTestCaseGraph;

import org.eclipse.emf.common.util.EList;

import org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TCG Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A general Class representing Properties, References or local Variables inside the Activity and Structured Activity Nodes.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xilaew.atg.model.activityTestCaseGraph.TCGVariable#getReferencedBy <em>Referenced By</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xilaew.atg.model.activityTestCaseGraph.ActivityTestCaseGraphPackage#getTCGVariable()
 * @model
 * @generated
 */
public interface TCGVariable extends AbstractTCGElement {
	/**
	 * Returns the value of the '<em><b>Referenced By</b></em>' reference list.
	 * The list contents are of type {@link org.xilaew.atg.model.activityTestCaseGraph.TCGOCLVariableCallExp}.
	 * It is bidirectional and its opposite is '{@link org.xilaew.atg.model.activityTestCaseGraph.TCGOCLVariableCallExp#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referenced By</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referenced By</em>' reference list.
	 * @see org.xilaew.atg.model.activityTestCaseGraph.ActivityTestCaseGraphPackage#getTCGVariable_ReferencedBy()
	 * @see org.xilaew.atg.model.activityTestCaseGraph.TCGOCLVariableCallExp#getVariable
	 * @model opposite="variable"
	 * @generated
	 */
	EList<TCGOCLVariableCallExp> getReferencedBy();

} // TCGVariable
