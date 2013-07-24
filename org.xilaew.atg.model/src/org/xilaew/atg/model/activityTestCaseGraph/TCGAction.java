/**
 */
package org.xilaew.atg.model.activityTestCaseGraph;

import org.eclipse.emf.common.util.EList;

import org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGConstraint;
import org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGRealNode;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TCG Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xilaew.atg.model.activityTestCaseGraph.TCGAction#getLocalPostconditions <em>Local Postconditions</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xilaew.atg.model.activityTestCaseGraph.ActivityTestCaseGraphPackage#getTCGAction()
 * @model
 * @generated
 */
public interface TCGAction extends AbstractTCGRealNode {
	/**
	 * Returns the value of the '<em><b>Local Postconditions</b></em>' containment reference list.
	 * The list contents are of type {@link org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGConstraint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Local Postconditions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Local Postconditions</em>' containment reference list.
	 * @see org.xilaew.atg.model.activityTestCaseGraph.ActivityTestCaseGraphPackage#getTCGAction_LocalPostconditions()
	 * @model containment="true"
	 * @generated
	 */
	EList<AbstractTCGConstraint> getLocalPostconditions();

} // TCGAction
