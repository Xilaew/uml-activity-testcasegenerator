/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.sf.parteg.base.testcasetree.generated;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TCG Transition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.sf.parteg.base.testcasetree.generated.TCGTransition#getName <em>Name</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasetree.generated.TCGTransition#getSourceNode <em>Source Node</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasetree.generated.TCGTransition#getTargetNode <em>Target Node</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasetree.generated.TCGTransition#getEvent <em>Event</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasetree.generated.TCGTransition#getPrecondition <em>Precondition</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasetree.generated.TCGTransition#getPostcondition <em>Postcondition</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.sf.parteg.base.testcasetree.generated.GeneratedPackage#getTCGTransition()
 * @model
 * @generated
 */
public interface TCGTransition extends TCGElement {
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
	 * @see net.sf.parteg.base.testcasetree.generated.GeneratedPackage#getTCGTransition_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link net.sf.parteg.base.testcasetree.generated.TCGTransition#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Source Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Node</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Node</em>' reference.
	 * @see #setSourceNode(TCGNode)
	 * @see net.sf.parteg.base.testcasetree.generated.GeneratedPackage#getTCGTransition_SourceNode()
	 * @model required="true"
	 * @generated
	 */
	TCGNode getSourceNode();

	/**
	 * Sets the value of the '{@link net.sf.parteg.base.testcasetree.generated.TCGTransition#getSourceNode <em>Source Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Node</em>' reference.
	 * @see #getSourceNode()
	 * @generated
	 */
	void setSourceNode(TCGNode value);

	/**
	 * Returns the value of the '<em><b>Target Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Node</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Node</em>' reference.
	 * @see #setTargetNode(TCGNode)
	 * @see net.sf.parteg.base.testcasetree.generated.GeneratedPackage#getTCGTransition_TargetNode()
	 * @model required="true"
	 * @generated
	 */
	TCGNode getTargetNode();

	/**
	 * Sets the value of the '{@link net.sf.parteg.base.testcasetree.generated.TCGTransition#getTargetNode <em>Target Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Node</em>' reference.
	 * @see #getTargetNode()
	 * @generated
	 */
	void setTargetNode(TCGNode value);

	/**
	 * Returns the value of the '<em><b>Event</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event</em>' containment reference.
	 * @see #setEvent(TCGEvent)
	 * @see net.sf.parteg.base.testcasetree.generated.GeneratedPackage#getTCGTransition_Event()
	 * @model containment="true" required="true"
	 * @generated
	 */
	TCGEvent getEvent();

	/**
	 * Sets the value of the '{@link net.sf.parteg.base.testcasetree.generated.TCGTransition#getEvent <em>Event</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Event</em>' containment reference.
	 * @see #getEvent()
	 * @generated
	 */
	void setEvent(TCGEvent value);

	/**
	 * Returns the value of the '<em><b>Precondition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Precondition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Precondition</em>' containment reference.
	 * @see #setPrecondition(TCGDisjunctiveNormalForm)
	 * @see net.sf.parteg.base.testcasetree.generated.GeneratedPackage#getTCGTransition_Precondition()
	 * @model containment="true" required="true"
	 * @generated
	 */
	TCGDisjunctiveNormalForm getPrecondition();

	/**
	 * Sets the value of the '{@link net.sf.parteg.base.testcasetree.generated.TCGTransition#getPrecondition <em>Precondition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Precondition</em>' containment reference.
	 * @see #getPrecondition()
	 * @generated
	 */
	void setPrecondition(TCGDisjunctiveNormalForm value);

	/**
	 * Returns the value of the '<em><b>Postcondition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Postcondition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Postcondition</em>' containment reference.
	 * @see #setPostcondition(TCGDisjunctiveNormalForm)
	 * @see net.sf.parteg.base.testcasetree.generated.GeneratedPackage#getTCGTransition_Postcondition()
	 * @model containment="true" required="true"
	 * @generated
	 */
	TCGDisjunctiveNormalForm getPostcondition();

	/**
	 * Sets the value of the '{@link net.sf.parteg.base.testcasetree.generated.TCGTransition#getPostcondition <em>Postcondition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Postcondition</em>' containment reference.
	 * @see #getPostcondition()
	 * @generated
	 */
	void setPostcondition(TCGDisjunctiveNormalForm value);

} // TCGTransition
