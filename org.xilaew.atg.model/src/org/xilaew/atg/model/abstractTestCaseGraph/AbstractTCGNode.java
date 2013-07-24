/**
 */
package org.xilaew.atg.model.abstractTestCaseGraph;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract TCG Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A node in a Graph. For statemachines this might represent the States, for Activitys it could represent Actions
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGNode#getOutgoing <em>Outgoing</em>}</li>
 *   <li>{@link org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGNode#getIncoming <em>Incoming</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xilaew.atg.model.abstractTestCaseGraph.AbstractTestCaseGraphPackage#getAbstractTCGNode()
 * @model
 * @generated
 */
public interface AbstractTCGNode extends AbstractTCGElement {
	/**
	 * Returns the value of the '<em><b>Outgoing</b></em>' reference list.
	 * The list contents are of type {@link org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGEdge}.
	 * It is bidirectional and its opposite is '{@link org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGEdge#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outgoing</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoing</em>' reference list.
	 * @see org.xilaew.atg.model.abstractTestCaseGraph.AbstractTestCaseGraphPackage#getAbstractTCGNode_Outgoing()
	 * @see org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGEdge#getSource
	 * @model opposite="source"
	 * @generated
	 */
	EList<AbstractTCGEdge> getOutgoing();

	/**
	 * Returns the value of the '<em><b>Incoming</b></em>' reference list.
	 * The list contents are of type {@link org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGEdge}.
	 * It is bidirectional and its opposite is '{@link org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGEdge#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incoming</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incoming</em>' reference list.
	 * @see org.xilaew.atg.model.abstractTestCaseGraph.AbstractTestCaseGraphPackage#getAbstractTCGNode_Incoming()
	 * @see org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGEdge#getTarget
	 * @model opposite="target"
	 * @generated
	 */
	EList<AbstractTCGEdge> getIncoming();

} // AbstractTCGNode
