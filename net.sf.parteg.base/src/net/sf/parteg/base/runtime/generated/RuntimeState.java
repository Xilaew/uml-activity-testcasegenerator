/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.sf.parteg.base.runtime.generated;

import java.util.Collection;
import java.util.Set;

import net.sf.parteg.base.testcasegraph.generated.TCGNode;
import net.sf.parteg.base.testcasegraph.generated.TestCaseRegion;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Runtime State</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see net.sf.parteg.base.runtime.generated.GeneratedPackage#getRuntimeState()
 * @model
 * @generated
 */
public interface RuntimeState extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" regionRequired="true"
	 * @generated
	 */
	TCGNode getActiveNode(TestCaseRegion region);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model nodeRequired="true"
	 * @generated
	 */
	void setActiveNode(TCGNode node);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model nodeRequired="true"
	 * @generated
	 */
	void removeNodeFromState(TCGNode node);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated NOT
	 */
	Set<TestCaseRegion> getAllRegions();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated NOT
	 */
	Collection<TCGNode> getAllActiveNodes();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	boolean isInitialState();

} // RuntimeState
