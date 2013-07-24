/**
 */
package org.xilaew.atg.model.activityTestCaseGraph;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TCG Object Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * is used to represent complex variables like sets or instances of other objects.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xilaew.atg.model.activityTestCaseGraph.TCGObjectVariable#getFields <em>Fields</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xilaew.atg.model.activityTestCaseGraph.ActivityTestCaseGraphPackage#getTCGObjectVariable()
 * @model
 * @generated
 */
public interface TCGObjectVariable extends TCGVariable {
	/**
	 * Returns the value of the '<em><b>Fields</b></em>' reference list.
	 * The list contents are of type {@link org.xilaew.atg.model.activityTestCaseGraph.TCGVariable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fields</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fields</em>' reference list.
	 * @see org.xilaew.atg.model.activityTestCaseGraph.ActivityTestCaseGraphPackage#getTCGObjectVariable_Fields()
	 * @model required="true"
	 * @generated
	 */
	EList<TCGVariable> getFields();

} // TCGObjectVariable
