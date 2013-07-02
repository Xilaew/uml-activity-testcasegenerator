/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.sf.parteg.base.runtime.generated;

import net.sf.parteg.base.testcasegraph.generated.TCGNode;
import net.sf.parteg.base.testcasegraph.generated.TestCaseRegion;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see net.sf.parteg.base.runtime.generated.GeneratedPackage#getState()
 * @model
 * @generated
 */
public interface State extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" regionRequired="true"
	 * @generated
	 */
	TCGNode getActiveState(TestCaseRegion region);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model regionRequired="true" stateRequired="true"
	 * @generated
	 */
	void setActiveState(TestCaseRegion region, TCGNode state);

} // State
