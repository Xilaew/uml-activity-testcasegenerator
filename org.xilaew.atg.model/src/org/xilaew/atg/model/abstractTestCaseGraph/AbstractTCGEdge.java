/**
 */
package org.xilaew.atg.model.abstractTestCaseGraph;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract TCG Edge</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An Edge in a Graph. For Activitys this will be Controll Flows or Data Flows. In Statemachines this will be a Transition
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGEdge#getSource <em>Source</em>}</li>
 *   <li>{@link org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGEdge#getTarget <em>Target</em>}</li>
 *   <li>{@link org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGEdge#getGuard <em>Guard</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xilaew.atg.model.abstractTestCaseGraph.AbstractTestCaseGraphPackage#getAbstractTCGEdge()
 * @model
 * @generated
 */
public interface AbstractTCGEdge extends AbstractTCGElement {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGNode#getOutgoing <em>Outgoing</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(AbstractTCGNode)
	 * @see org.xilaew.atg.model.abstractTestCaseGraph.AbstractTestCaseGraphPackage#getAbstractTCGEdge_Source()
	 * @see org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGNode#getOutgoing
	 * @model opposite="outgoing" required="true"
	 * @generated
	 */
	AbstractTCGNode getSource();

	/**
	 * Sets the value of the '{@link org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGEdge#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(AbstractTCGNode value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGNode#getIncoming <em>Incoming</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(AbstractTCGNode)
	 * @see org.xilaew.atg.model.abstractTestCaseGraph.AbstractTestCaseGraphPackage#getAbstractTCGEdge_Target()
	 * @see org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGNode#getIncoming
	 * @model opposite="incoming" required="true"
	 * @generated
	 */
	AbstractTCGNode getTarget();

	/**
	 * Sets the value of the '{@link org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGEdge#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(AbstractTCGNode value);

	/**
	 * Returns the value of the '<em><b>Guard</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Guard</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Guard</em>' containment reference.
	 * @see #setGuard(AbstractTCGConstraint)
	 * @see org.xilaew.atg.model.abstractTestCaseGraph.AbstractTestCaseGraphPackage#getAbstractTCGEdge_Guard()
	 * @model containment="true"
	 * @generated
	 */
	AbstractTCGConstraint getGuard();

	/**
	 * Sets the value of the '{@link org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGEdge#getGuard <em>Guard</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Guard</em>' containment reference.
	 * @see #getGuard()
	 * @generated
	 */
	void setGuard(AbstractTCGConstraint value);

} // AbstractTCGEdge
