/**
 */
package org.xilaew.atg.model.abstractTestCaseGraph;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract TCG Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A Containter holding the Graph. in Statemachines it is a Region and for Activitys the Activity itself is the Container.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGContainer#getNodes <em>Nodes</em>}</li>
 *   <li>{@link org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGContainer#getEdges <em>Edges</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xilaew.atg.model.abstractTestCaseGraph.AbstractTestCaseGraphPackage#getAbstractTCGContainer()
 * @model
 * @generated
 */
public interface AbstractTCGContainer extends AbstractTCGElement {
	/**
	 * Returns the value of the '<em><b>Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGNode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nodes</em>' containment reference list.
	 * @see org.xilaew.atg.model.abstractTestCaseGraph.AbstractTestCaseGraphPackage#getAbstractTCGContainer_Nodes()
	 * @model containment="true"
	 * @generated
	 */
	EList<AbstractTCGNode> getNodes();

	/**
	 * Returns the value of the '<em><b>Edges</b></em>' containment reference list.
	 * The list contents are of type {@link org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGEdge}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Edges</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Edges</em>' containment reference list.
	 * @see org.xilaew.atg.model.abstractTestCaseGraph.AbstractTestCaseGraphPackage#getAbstractTCGContainer_Edges()
	 * @model containment="true"
	 * @generated
	 */
	EList<AbstractTCGEdge> getEdges();

} // AbstractTCGContainer
