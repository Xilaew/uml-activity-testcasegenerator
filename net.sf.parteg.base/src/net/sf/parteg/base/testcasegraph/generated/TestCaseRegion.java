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
 * A representation of the model object '<em><b>Test Case Region</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.sf.parteg.base.testcasegraph.generated.TestCaseRegion#getNodes <em>Nodes</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasegraph.generated.TestCaseRegion#getTransitions <em>Transitions</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasegraph.generated.TestCaseRegion#getContainer <em>Container</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.sf.parteg.base.testcasegraph.generated.GeneratedPackage#getTestCaseRegion()
 * @model
 * @generated
 */
public interface TestCaseRegion extends EObject {
	/**
	 * Returns the value of the '<em><b>Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.parteg.base.testcasegraph.generated.TCGNode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nodes</em>' containment reference list.
	 * @see net.sf.parteg.base.testcasegraph.generated.GeneratedPackage#getTestCaseRegion_Nodes()
	 * @model containment="true"
	 * @generated
	 */
	EList<TCGNode> getNodes();

	/**
	 * Returns the value of the '<em><b>Transitions</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.parteg.base.testcasegraph.generated.TCGTransition}.
	 * It is bidirectional and its opposite is '{@link net.sf.parteg.base.testcasegraph.generated.TCGTransition#getContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transitions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transitions</em>' containment reference list.
	 * @see net.sf.parteg.base.testcasegraph.generated.GeneratedPackage#getTestCaseRegion_Transitions()
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGTransition#getContainer
	 * @model opposite="container" containment="true"
	 * @generated
	 */
	EList<TCGTransition> getTransitions();

	/**
	 * Returns the value of the '<em><b>Container</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link net.sf.parteg.base.testcasegraph.generated.TestCaseGraph#getRegions <em>Regions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Container</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Container</em>' container reference.
	 * @see #setContainer(TestCaseGraph)
	 * @see net.sf.parteg.base.testcasegraph.generated.GeneratedPackage#getTestCaseRegion_Container()
	 * @see net.sf.parteg.base.testcasegraph.generated.TestCaseGraph#getRegions
	 * @model opposite="regions" required="true" transient="false"
	 * @generated
	 */
	TestCaseGraph getContainer();

	/**
	 * Sets the value of the '{@link net.sf.parteg.base.testcasegraph.generated.TestCaseRegion#getContainer <em>Container</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Container</em>' container reference.
	 * @see #getContainer()
	 * @generated
	 */
	void setContainer(TestCaseGraph value);

} // TestCaseRegion
