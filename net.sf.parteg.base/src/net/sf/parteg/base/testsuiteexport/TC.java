/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.sf.parteg.base.testsuiteexport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TC</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.sf.parteg.base.testsuiteexport.TC#getDefine <em>Define</em>}</li>
 *   <li>{@link net.sf.parteg.base.testsuiteexport.TC#getAssign <em>Assign</em>}</li>
 *   <li>{@link net.sf.parteg.base.testsuiteexport.TC#getAction <em>Action</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.sf.parteg.base.testsuiteexport.TestsuiteexportPackage#getTC()
 * @model
 * @generated
 */
public interface TC extends EObject {
	/**
	 * Returns the value of the '<em><b>Define</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.parteg.base.testsuiteexport.Variable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Define</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Define</em>' containment reference list.
	 * @see net.sf.parteg.base.testsuiteexport.TestsuiteexportPackage#getTC_Define()
	 * @model containment="true"
	 * @generated
	 */
	EList<Variable> getDefine();

	/**
	 * Returns the value of the '<em><b>Assign</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.parteg.base.testsuiteexport.Variable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assign</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assign</em>' containment reference list.
	 * @see net.sf.parteg.base.testsuiteexport.TestsuiteexportPackage#getTC_Assign()
	 * @model containment="true"
	 * @generated
	 */
	EList<Variable> getAssign();

	/**
	 * Returns the value of the '<em><b>Action</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.parteg.base.testsuiteexport.Action}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Action</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action</em>' containment reference list.
	 * @see net.sf.parteg.base.testsuiteexport.TestsuiteexportPackage#getTC_Action()
	 * @model containment="true"
	 * @generated
	 */
	EList<Action> getAction();

} // TC
