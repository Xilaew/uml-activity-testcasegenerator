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
 * A representation of the model object '<em><b>Test Case Graph</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.sf.parteg.base.testcasegraph.generated.TestCaseGraph#getRegions <em>Regions</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasegraph.generated.TestCaseGraph#getCompositeSuperState <em>Composite Super State</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasegraph.generated.TestCaseGraph#getContainedConnectionPoints <em>Contained Connection Points</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasegraph.generated.TestCaseGraph#getSubmachineStates <em>Submachine States</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.sf.parteg.base.testcasegraph.generated.GeneratedPackage#getTestCaseGraph()
 * @model
 * @generated
 */
public interface TestCaseGraph extends EObject {
	/**
	 * Returns the value of the '<em><b>Regions</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.parteg.base.testcasegraph.generated.TestCaseRegion}.
	 * It is bidirectional and its opposite is '{@link net.sf.parteg.base.testcasegraph.generated.TestCaseRegion#getContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Regions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Regions</em>' containment reference list.
	 * @see net.sf.parteg.base.testcasegraph.generated.GeneratedPackage#getTestCaseGraph_Regions()
	 * @see net.sf.parteg.base.testcasegraph.generated.TestCaseRegion#getContainer
	 * @model opposite="container" containment="true"
	 * @generated
	 */
	EList<TestCaseRegion> getRegions();

	/**
	 * Returns the value of the '<em><b>Composite Super State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Composite Super State</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Composite Super State</em>' reference.
	 * @see #setCompositeSuperState(TCGRealNode)
	 * @see net.sf.parteg.base.testcasegraph.generated.GeneratedPackage#getTestCaseGraph_CompositeSuperState()
	 * @model
	 * @generated
	 */
	TCGRealNode getCompositeSuperState();

	/**
	 * Sets the value of the '{@link net.sf.parteg.base.testcasegraph.generated.TestCaseGraph#getCompositeSuperState <em>Composite Super State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Composite Super State</em>' reference.
	 * @see #getCompositeSuperState()
	 * @generated
	 */
	void setCompositeSuperState(TCGRealNode value);

	/**
	 * Returns the value of the '<em><b>Contained Connection Points</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.parteg.base.testcasegraph.generated.TCGIntermediateNode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contained Connection Points</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contained Connection Points</em>' containment reference list.
	 * @see net.sf.parteg.base.testcasegraph.generated.GeneratedPackage#getTestCaseGraph_ContainedConnectionPoints()
	 * @model containment="true"
	 * @generated
	 */
	EList<TCGIntermediateNode> getContainedConnectionPoints();

	/**
	 * Returns the value of the '<em><b>Submachine States</b></em>' reference list.
	 * The list contents are of type {@link net.sf.parteg.base.testcasegraph.generated.TCGRealNode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Submachine States</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Submachine States</em>' reference list.
	 * @see net.sf.parteg.base.testcasegraph.generated.GeneratedPackage#getTestCaseGraph_SubmachineStates()
	 * @model
	 * @generated
	 */
	EList<TCGRealNode> getSubmachineStates();

} // TestCaseGraph
