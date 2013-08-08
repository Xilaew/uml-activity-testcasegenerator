/**
 */
package org.xilaew.atg.model.testCaseGraphRuntime;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGEdge;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Path</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xilaew.atg.model.testCaseGraphRuntime.Path#getEdges <em>Edges</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xilaew.atg.model.testCaseGraphRuntime.TestCaseGraphRuntimePackage#getPath()
 * @model
 * @generated
 */
public interface Path extends EObject {
	/**
	 * Returns the value of the '<em><b>Edges</b></em>' reference list.
	 * The list contents are of type {@link org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGEdge}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Edges</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Edges</em>' reference list.
	 * @see org.xilaew.atg.model.testCaseGraphRuntime.TestCaseGraphRuntimePackage#getPath_Edges()
	 * @model
	 * @generated
	 */
	EList<AbstractTCGEdge> getEdges();

} // Path
