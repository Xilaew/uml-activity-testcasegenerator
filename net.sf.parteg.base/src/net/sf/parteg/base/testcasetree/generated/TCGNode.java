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
 * A representation of the model object '<em><b>TCG Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.sf.parteg.base.testcasetree.generated.TCGNode#getName <em>Name</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasetree.generated.TCGNode#getCondition <em>Condition</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasetree.generated.TCGNode#getIncomingTransitions <em>Incoming Transitions</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasetree.generated.TCGNode#getOutgoingTransitions <em>Outgoing Transitions</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasetree.generated.TCGNode#getParameters <em>Parameters</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasetree.generated.TCGNode#getDistanceToRoot <em>Distance To Root</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasetree.generated.TCGNode#isCorrespondsNegativeExpression <em>Corresponds Negative Expression</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasetree.generated.TCGNode#getOriginalExpression <em>Original Expression</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasetree.generated.TCGNode#getInvariant <em>Invariant</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasetree.generated.TCGNode#getOrigonalNode <em>Origonal Node</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.sf.parteg.base.testcasetree.generated.GeneratedPackage#getTCGNode()
 * @model
 * @generated
 */
public interface TCGNode extends TCGElement {
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
	 * @see net.sf.parteg.base.testcasetree.generated.GeneratedPackage#getTCGNode_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link net.sf.parteg.base.testcasetree.generated.TCGNode#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' containment reference.
	 * @see #setCondition(TCGOCLExpression)
	 * @see net.sf.parteg.base.testcasetree.generated.GeneratedPackage#getTCGNode_Condition()
	 * @model containment="true"
	 * @generated
	 */
	TCGOCLExpression getCondition();

	/**
	 * Sets the value of the '{@link net.sf.parteg.base.testcasetree.generated.TCGNode#getCondition <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' containment reference.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(TCGOCLExpression value);

	/**
	 * Returns the value of the '<em><b>Incoming Transitions</b></em>' reference list.
	 * The list contents are of type {@link net.sf.parteg.base.testcasetree.generated.TCGTransition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incoming Transitions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incoming Transitions</em>' reference list.
	 * @see net.sf.parteg.base.testcasetree.generated.GeneratedPackage#getTCGNode_IncomingTransitions()
	 * @model
	 * @generated
	 */
	EList<TCGTransition> getIncomingTransitions();

	/**
	 * Returns the value of the '<em><b>Outgoing Transitions</b></em>' reference list.
	 * The list contents are of type {@link net.sf.parteg.base.testcasetree.generated.TCGTransition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outgoing Transitions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoing Transitions</em>' reference list.
	 * @see net.sf.parteg.base.testcasetree.generated.GeneratedPackage#getTCGNode_OutgoingTransitions()
	 * @model
	 * @generated
	 */
	EList<TCGTransition> getOutgoingTransitions();

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.parteg.base.testcasetree.generated.TCGParameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see net.sf.parteg.base.testcasetree.generated.GeneratedPackage#getTCGNode_Parameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<TCGParameter> getParameters();

	/**
	 * Returns the value of the '<em><b>Distance To Root</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Distance To Root</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Distance To Root</em>' attribute.
	 * @see #setDistanceToRoot(long)
	 * @see net.sf.parteg.base.testcasetree.generated.GeneratedPackage#getTCGNode_DistanceToRoot()
	 * @model required="true"
	 * @generated
	 */
	long getDistanceToRoot();

	/**
	 * Sets the value of the '{@link net.sf.parteg.base.testcasetree.generated.TCGNode#getDistanceToRoot <em>Distance To Root</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Distance To Root</em>' attribute.
	 * @see #getDistanceToRoot()
	 * @generated
	 */
	void setDistanceToRoot(long value);

	/**
	 * Returns the value of the '<em><b>Corresponds Negative Expression</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Corresponds Negative Expression</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Corresponds Negative Expression</em>' attribute.
	 * @see #setCorrespondsNegativeExpression(boolean)
	 * @see net.sf.parteg.base.testcasetree.generated.GeneratedPackage#getTCGNode_CorrespondsNegativeExpression()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isCorrespondsNegativeExpression();

	/**
	 * Sets the value of the '{@link net.sf.parteg.base.testcasetree.generated.TCGNode#isCorrespondsNegativeExpression <em>Corresponds Negative Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Corresponds Negative Expression</em>' attribute.
	 * @see #isCorrespondsNegativeExpression()
	 * @generated
	 */
	void setCorrespondsNegativeExpression(boolean value);

	/**
	 * Returns the value of the '<em><b>Original Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Original Expression</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Original Expression</em>' reference.
	 * @see #setOriginalExpression(EObject)
	 * @see net.sf.parteg.base.testcasetree.generated.GeneratedPackage#getTCGNode_OriginalExpression()
	 * @model
	 * @generated
	 */
	EObject getOriginalExpression();

	/**
	 * Sets the value of the '{@link net.sf.parteg.base.testcasetree.generated.TCGNode#getOriginalExpression <em>Original Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Original Expression</em>' reference.
	 * @see #getOriginalExpression()
	 * @generated
	 */
	void setOriginalExpression(EObject value);

	/**
	 * Returns the value of the '<em><b>Invariant</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Invariant</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Invariant</em>' reference.
	 * @see #setInvariant(TCGOCLExpression)
	 * @see net.sf.parteg.base.testcasetree.generated.GeneratedPackage#getTCGNode_Invariant()
	 * @model
	 * @generated
	 */
	TCGOCLExpression getInvariant();

	/**
	 * Sets the value of the '{@link net.sf.parteg.base.testcasetree.generated.TCGNode#getInvariant <em>Invariant</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Invariant</em>' reference.
	 * @see #getInvariant()
	 * @generated
	 */
	void setInvariant(TCGOCLExpression value);

	/**
	 * Returns the value of the '<em><b>Origonal Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Origonal Node</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Origonal Node</em>' reference.
	 * @see #setOrigonalNode(EObject)
	 * @see net.sf.parteg.base.testcasetree.generated.GeneratedPackage#getTCGNode_OrigonalNode()
	 * @model required="true"
	 * @generated
	 */
	EObject getOrigonalNode();

	/**
	 * Sets the value of the '{@link net.sf.parteg.base.testcasetree.generated.TCGNode#getOrigonalNode <em>Origonal Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Origonal Node</em>' reference.
	 * @see #getOrigonalNode()
	 * @generated
	 */
	void setOrigonalNode(EObject value);

} // TCGNode
