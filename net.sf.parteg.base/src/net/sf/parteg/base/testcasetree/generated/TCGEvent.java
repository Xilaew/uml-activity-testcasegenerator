/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.sf.parteg.base.testcasetree.generated;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TCG Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.sf.parteg.base.testcasetree.generated.TCGEvent#getName <em>Name</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasetree.generated.TCGEvent#getParameters <em>Parameters</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasetree.generated.TCGEvent#getEvent <em>Event</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasetree.generated.TCGEvent#isDefaultEvent <em>Default Event</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.sf.parteg.base.testcasetree.generated.GeneratedPackage#getTCGEvent()
 * @model
 * @generated
 */
public interface TCGEvent extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see net.sf.parteg.base.testcasetree.generated.GeneratedPackage#getTCGEvent_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link net.sf.parteg.base.testcasetree.generated.TCGEvent#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' reference list.
	 * The list contents are of type {@link net.sf.parteg.base.testcasetree.generated.TCGParameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' reference list.
	 * @see net.sf.parteg.base.testcasetree.generated.GeneratedPackage#getTCGEvent_Parameters()
	 * @model
	 * @generated
	 */
	EList<TCGParameter> getParameters();

	/**
	 * Returns the value of the '<em><b>Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event</em>' reference.
	 * @see #setEvent(EObject)
	 * @see net.sf.parteg.base.testcasetree.generated.GeneratedPackage#getTCGEvent_Event()
	 * @model
	 * @generated
	 */
	EObject getEvent();

	/**
	 * Sets the value of the '{@link net.sf.parteg.base.testcasetree.generated.TCGEvent#getEvent <em>Event</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Event</em>' reference.
	 * @see #getEvent()
	 * @generated
	 */
	void setEvent(EObject value);

	/**
	 * Returns the value of the '<em><b>Default Event</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Event</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Event</em>' attribute.
	 * @see #setDefaultEvent(boolean)
	 * @see net.sf.parteg.base.testcasetree.generated.GeneratedPackage#getTCGEvent_DefaultEvent()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isDefaultEvent();

	/**
	 * Sets the value of the '{@link net.sf.parteg.base.testcasetree.generated.TCGEvent#isDefaultEvent <em>Default Event</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Event</em>' attribute.
	 * @see #isDefaultEvent()
	 * @generated
	 */
	void setDefaultEvent(boolean value);

} // TCGEvent
