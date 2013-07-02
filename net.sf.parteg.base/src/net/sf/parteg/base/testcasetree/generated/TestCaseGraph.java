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
 * A representation of the model object '<em><b>Test Case Graph</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.sf.parteg.base.testcasetree.generated.TestCaseGraph#getRoot <em>Root</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasetree.generated.TestCaseGraph#getNodes <em>Nodes</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasetree.generated.TestCaseGraph#getTransitions <em>Transitions</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasetree.generated.TestCaseGraph#getConditions <em>Conditions</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasetree.generated.TestCaseGraph#getAttributes <em>Attributes</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.sf.parteg.base.testcasetree.generated.GeneratedPackage#getTestCaseGraph()
 * @model
 * @generated
 */
public interface TestCaseGraph extends EObject {
	/**
	 * Returns the value of the '<em><b>Root</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Root</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Root</em>' reference.
	 * @see #setRoot(TCGNode)
	 * @see net.sf.parteg.base.testcasetree.generated.GeneratedPackage#getTestCaseGraph_Root()
	 * @model required="true"
	 * @generated
	 */
	TCGNode getRoot();

	/**
	 * Sets the value of the '{@link net.sf.parteg.base.testcasetree.generated.TestCaseGraph#getRoot <em>Root</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Root</em>' reference.
	 * @see #getRoot()
	 * @generated
	 */
	void setRoot(TCGNode value);

	/**
	 * Returns the value of the '<em><b>Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.parteg.base.testcasetree.generated.TCGNode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nodes</em>' containment reference list.
	 * @see net.sf.parteg.base.testcasetree.generated.GeneratedPackage#getTestCaseGraph_Nodes()
	 * @model containment="true"
	 * @generated
	 */
	EList<TCGNode> getNodes();

	/**
	 * Returns the value of the '<em><b>Transitions</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.parteg.base.testcasetree.generated.TCGTransition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transitions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transitions</em>' containment reference list.
	 * @see net.sf.parteg.base.testcasetree.generated.GeneratedPackage#getTestCaseGraph_Transitions()
	 * @model containment="true"
	 * @generated
	 */
	EList<TCGTransition> getTransitions();

	/**
	 * Returns the value of the '<em><b>Conditions</b></em>' reference list.
	 * The list contents are of type {@link net.sf.parteg.base.testcasetree.generated.TCGOCLExpression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Conditions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Conditions</em>' reference list.
	 * @see net.sf.parteg.base.testcasetree.generated.GeneratedPackage#getTestCaseGraph_Conditions()
	 * @model
	 * @generated
	 */
	EList<TCGOCLExpression> getConditions();

	/**
	 * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.parteg.base.testcasetree.generated.TCGParameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attributes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attributes</em>' containment reference list.
	 * @see net.sf.parteg.base.testcasetree.generated.GeneratedPackage#getTestCaseGraph_Attributes()
	 * @model containment="true"
	 * @generated
	 */
	EList<TCGParameter> getAttributes();

} // TestCaseGraph
