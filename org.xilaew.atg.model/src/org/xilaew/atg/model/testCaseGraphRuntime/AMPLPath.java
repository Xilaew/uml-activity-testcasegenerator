/**
 */
package org.xilaew.atg.model.testCaseGraphRuntime;

import org.eclipse.emf.ecore.EObject;

import org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGEdge;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>AMPL Path</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xilaew.atg.model.testCaseGraphRuntime.AMPLPath#getEdges <em>Edges</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xilaew.atg.model.testCaseGraphRuntime.TestCaseGraphRuntimePackage#getAMPLPath()
 * @model
 * @generated
 */
public interface AMPLPath extends EObject {
	/**
	 * Returns the value of the '<em><b>Edges</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Edges</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Edges</em>' reference.
	 * @see #setEdges(AbstractTCGEdge)
	 * @see org.xilaew.atg.model.testCaseGraphRuntime.TestCaseGraphRuntimePackage#getAMPLPath_Edges()
	 * @model
	 * @generated
	 */
	AbstractTCGEdge getEdges();

	/**
	 * Sets the value of the '{@link org.xilaew.atg.model.testCaseGraphRuntime.AMPLPath#getEdges <em>Edges</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Edges</em>' reference.
	 * @see #getEdges()
	 * @generated
	 */
	void setEdges(AbstractTCGEdge value);

} // AMPLPath
