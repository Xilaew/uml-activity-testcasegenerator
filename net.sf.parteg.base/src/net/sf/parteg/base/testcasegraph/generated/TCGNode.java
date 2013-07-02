/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.sf.parteg.base.testcasegraph.generated;

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
 *   <li>{@link net.sf.parteg.base.testcasegraph.generated.TCGNode#getName <em>Name</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasegraph.generated.TCGNode#getIncomingTransitions <em>Incoming Transitions</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasegraph.generated.TCGNode#getOutgoingTransitions <em>Outgoing Transitions</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasegraph.generated.TCGNode#getOriginalNode <em>Original Node</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasegraph.generated.TCGNode#isUseAllTransitionsInParallel <em>Use All Transitions In Parallel</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasegraph.generated.TCGNode#getReferencedSubmachine <em>Referenced Submachine</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasegraph.generated.TCGNode#getMinDistanceFromStart <em>Min Distance From Start</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasegraph.generated.TCGNode#getMaxDistanceFromStart <em>Max Distance From Start</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.sf.parteg.base.testcasegraph.generated.GeneratedPackage#getTCGNode()
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
	 * @see net.sf.parteg.base.testcasegraph.generated.GeneratedPackage#getTCGNode_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link net.sf.parteg.base.testcasegraph.generated.TCGNode#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Incoming Transitions</b></em>' reference list.
	 * The list contents are of type {@link net.sf.parteg.base.testcasegraph.generated.TCGTransition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incoming Transitions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incoming Transitions</em>' reference list.
	 * @see net.sf.parteg.base.testcasegraph.generated.GeneratedPackage#getTCGNode_IncomingTransitions()
	 * @model
	 * @generated
	 */
	EList<TCGTransition> getIncomingTransitions();

	/**
	 * Returns the value of the '<em><b>Outgoing Transitions</b></em>' reference list.
	 * The list contents are of type {@link net.sf.parteg.base.testcasegraph.generated.TCGTransition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outgoing Transitions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoing Transitions</em>' reference list.
	 * @see net.sf.parteg.base.testcasegraph.generated.GeneratedPackage#getTCGNode_OutgoingTransitions()
	 * @model
	 * @generated
	 */
	EList<TCGTransition> getOutgoingTransitions();

	/**
	 * Returns the value of the '<em><b>Original Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Original Node</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Original Node</em>' reference.
	 * @see #setOriginalNode(EObject)
	 * @see net.sf.parteg.base.testcasegraph.generated.GeneratedPackage#getTCGNode_OriginalNode()
	 * @model required="true"
	 * @generated
	 */
	EObject getOriginalNode();

	/**
	 * Sets the value of the '{@link net.sf.parteg.base.testcasegraph.generated.TCGNode#getOriginalNode <em>Original Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Original Node</em>' reference.
	 * @see #getOriginalNode()
	 * @generated
	 */
	void setOriginalNode(EObject value);

	/**
	 * Returns the value of the '<em><b>Use All Transitions In Parallel</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Use All Transitions In Parallel</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Use All Transitions In Parallel</em>' attribute.
	 * @see #setUseAllTransitionsInParallel(boolean)
	 * @see net.sf.parteg.base.testcasegraph.generated.GeneratedPackage#getTCGNode_UseAllTransitionsInParallel()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isUseAllTransitionsInParallel();

	/**
	 * Sets the value of the '{@link net.sf.parteg.base.testcasegraph.generated.TCGNode#isUseAllTransitionsInParallel <em>Use All Transitions In Parallel</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Use All Transitions In Parallel</em>' attribute.
	 * @see #isUseAllTransitionsInParallel()
	 * @generated
	 */
	void setUseAllTransitionsInParallel(boolean value);

	/**
	 * Returns the value of the '<em><b>Referenced Submachine</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referenced Submachine</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referenced Submachine</em>' reference.
	 * @see #setReferencedSubmachine(TestCaseGraph)
	 * @see net.sf.parteg.base.testcasegraph.generated.GeneratedPackage#getTCGNode_ReferencedSubmachine()
	 * @model
	 * @generated
	 */
	TestCaseGraph getReferencedSubmachine();

	/**
	 * Sets the value of the '{@link net.sf.parteg.base.testcasegraph.generated.TCGNode#getReferencedSubmachine <em>Referenced Submachine</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referenced Submachine</em>' reference.
	 * @see #getReferencedSubmachine()
	 * @generated
	 */
	void setReferencedSubmachine(TestCaseGraph value);

	/**
	 * Returns the value of the '<em><b>Min Distance From Start</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Min Distance From Start</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Min Distance From Start</em>' attribute.
	 * @see #setMinDistanceFromStart(int)
	 * @see net.sf.parteg.base.testcasegraph.generated.GeneratedPackage#getTCGNode_MinDistanceFromStart()
	 * @model default="-1" required="true"
	 * @generated
	 */
	int getMinDistanceFromStart();

	/**
	 * Sets the value of the '{@link net.sf.parteg.base.testcasegraph.generated.TCGNode#getMinDistanceFromStart <em>Min Distance From Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Distance From Start</em>' attribute.
	 * @see #getMinDistanceFromStart()
	 * @generated
	 */
	void setMinDistanceFromStart(int value);

	/**
	 * Returns the value of the '<em><b>Max Distance From Start</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Distance From Start</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Distance From Start</em>' attribute.
	 * @see #setMaxDistanceFromStart(int)
	 * @see net.sf.parteg.base.testcasegraph.generated.GeneratedPackage#getTCGNode_MaxDistanceFromStart()
	 * @model default="-1" required="true"
	 * @generated
	 */
	int getMaxDistanceFromStart();

	/**
	 * Sets the value of the '{@link net.sf.parteg.base.testcasegraph.generated.TCGNode#getMaxDistanceFromStart <em>Max Distance From Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Distance From Start</em>' attribute.
	 * @see #getMaxDistanceFromStart()
	 * @generated
	 */
	void setMaxDistanceFromStart(int value);


} // TCGNode
