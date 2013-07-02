/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.sf.parteg.base.testcasegraph.generated;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TCG Transition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.sf.parteg.base.testcasegraph.generated.TCGTransition#getName <em>Name</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasegraph.generated.TCGTransition#getSourceNode <em>Source Node</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasegraph.generated.TCGTransition#getTargetNode <em>Target Node</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasegraph.generated.TCGTransition#getEvents <em>Events</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasegraph.generated.TCGTransition#getPrecondition <em>Precondition</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasegraph.generated.TCGTransition#getPostcondition <em>Postcondition</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasegraph.generated.TCGTransition#getContainer <em>Container</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasegraph.generated.TCGTransition#isCanBeProcessed <em>Can Be Processed</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.sf.parteg.base.testcasegraph.generated.GeneratedPackage#getTCGTransition()
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
	 * @see net.sf.parteg.base.testcasegraph.generated.GeneratedPackage#getTCGTransition_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link net.sf.parteg.base.testcasegraph.generated.TCGTransition#getName <em>Name</em>}' attribute.
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
	 * @see net.sf.parteg.base.testcasegraph.generated.GeneratedPackage#getTCGTransition_SourceNode()
	 * @model required="true"
	 * @generated
	 */
	TCGNode getSourceNode();

	/**
	 * Sets the value of the '{@link net.sf.parteg.base.testcasegraph.generated.TCGTransition#getSourceNode <em>Source Node</em>}' reference.
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
	 * @see net.sf.parteg.base.testcasegraph.generated.GeneratedPackage#getTCGTransition_TargetNode()
	 * @model required="true"
	 * @generated
	 */
	TCGNode getTargetNode();

	/**
	 * Sets the value of the '{@link net.sf.parteg.base.testcasegraph.generated.TCGTransition#getTargetNode <em>Target Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Node</em>' reference.
	 * @see #getTargetNode()
	 * @generated
	 */
	void setTargetNode(TCGNode value);

	/**
	 * Returns the value of the '<em><b>Events</b></em>' reference list.
	 * The list contents are of type {@link net.sf.parteg.base.testcasegraph.generated.TCGEvent}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Events</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Events</em>' reference list.
	 * @see net.sf.parteg.base.testcasegraph.generated.GeneratedPackage#getTCGTransition_Events()
	 * @model
	 * @generated
	 */
	EList<TCGEvent> getEvents();

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
	 * @see net.sf.parteg.base.testcasegraph.generated.GeneratedPackage#getTCGTransition_Precondition()
	 * @model containment="true" required="true"
	 * @generated
	 */
	TCGDisjunctiveNormalForm getPrecondition();

	/**
	 * Sets the value of the '{@link net.sf.parteg.base.testcasegraph.generated.TCGTransition#getPrecondition <em>Precondition</em>}' containment reference.
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
	 * @see net.sf.parteg.base.testcasegraph.generated.GeneratedPackage#getTCGTransition_Postcondition()
	 * @model containment="true" required="true"
	 * @generated
	 */
	TCGDisjunctiveNormalForm getPostcondition();

	/**
	 * Sets the value of the '{@link net.sf.parteg.base.testcasegraph.generated.TCGTransition#getPostcondition <em>Postcondition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Postcondition</em>' containment reference.
	 * @see #getPostcondition()
	 * @generated
	 */
	void setPostcondition(TCGDisjunctiveNormalForm value);

	/**
	 * Returns the value of the '<em><b>Container</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link net.sf.parteg.base.testcasegraph.generated.TestCaseRegion#getTransitions <em>Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Container</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Container</em>' container reference.
	 * @see #setContainer(TestCaseRegion)
	 * @see net.sf.parteg.base.testcasegraph.generated.GeneratedPackage#getTCGTransition_Container()
	 * @see net.sf.parteg.base.testcasegraph.generated.TestCaseRegion#getTransitions
	 * @model opposite="transitions" required="true" transient="false"
	 * @generated
	 */
	TestCaseRegion getContainer();

	/**
	 * Sets the value of the '{@link net.sf.parteg.base.testcasegraph.generated.TCGTransition#getContainer <em>Container</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Container</em>' container reference.
	 * @see #getContainer()
	 * @generated
	 */
	void setContainer(TestCaseRegion value);

	/**
	 * Returns the value of the '<em><b>Can Be Processed</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Can Be Processed</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Can Be Processed</em>' attribute.
	 * @see #setCanBeProcessed(boolean)
	 * @see net.sf.parteg.base.testcasegraph.generated.GeneratedPackage#getTCGTransition_CanBeProcessed()
	 * @model default="true" required="true"
	 * @generated
	 */
	boolean isCanBeProcessed();

	/**
	 * Sets the value of the '{@link net.sf.parteg.base.testcasegraph.generated.TCGTransition#isCanBeProcessed <em>Can Be Processed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Can Be Processed</em>' attribute.
	 * @see #isCanBeProcessed()
	 * @generated
	 */
	void setCanBeProcessed(boolean value);

} // TCGTransition
