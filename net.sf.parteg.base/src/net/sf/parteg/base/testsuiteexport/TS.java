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
 * A representation of the model object '<em><b>TS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.sf.parteg.base.testsuiteexport.TS#getTc <em>Tc</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.sf.parteg.base.testsuiteexport.TestsuiteexportPackage#getTS()
 * @model
 * @generated
 */
public interface TS extends EObject {
	/**
	 * Returns the value of the '<em><b>Tc</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.parteg.base.testsuiteexport.TC}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tc</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tc</em>' containment reference list.
	 * @see net.sf.parteg.base.testsuiteexport.TestsuiteexportPackage#getTS_Tc()
	 * @model containment="true"
	 * @generated
	 */
	EList<TC> getTc();

} // TS
