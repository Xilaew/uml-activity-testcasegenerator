/**
 */
package org.xilaew.atg.model.abstractTestCaseGraph;

import org.eclipse.emf.ecore.EModelElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract TCG Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Just a Superclass to have one common superclass for all Elements of a TestCaseGraph. 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGElement#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xilaew.atg.model.abstractTestCaseGraph.AbstractTestCaseGraphPackage#getAbstractTCGElement()
 * @model
 * @generated
 */
public interface AbstractTCGElement extends EModelElement {

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.xilaew.atg.model.abstractTestCaseGraph.AbstractTestCaseGraphPackage#getAbstractTCGElement_Name()
	 * @model default=""
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGElement#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);
} // AbstractTCGElement
