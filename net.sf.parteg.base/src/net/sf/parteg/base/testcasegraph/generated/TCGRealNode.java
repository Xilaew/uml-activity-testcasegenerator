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
 * A representation of the model object '<em><b>TCG Real Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.sf.parteg.base.testcasegraph.generated.TCGRealNode#getCondition <em>Condition</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasegraph.generated.TCGRealNode#getSubGraph <em>Sub Graph</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasegraph.generated.TCGRealNode#getContainedConnectionPointReferences <em>Contained Connection Point References</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasegraph.generated.TCGRealNode#getContainedConnectionPoints <em>Contained Connection Points</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasegraph.generated.TCGRealNode#getContainer <em>Container</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.sf.parteg.base.testcasegraph.generated.GeneratedPackage#getTCGRealNode()
 * @model
 * @generated
 */
public interface TCGRealNode extends TCGNode {
	/**
	 * Returns the value of the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' containment reference.
	 * @see #setCondition(TCGDisjunctiveNormalForm)
	 * @see net.sf.parteg.base.testcasegraph.generated.GeneratedPackage#getTCGRealNode_Condition()
	 * @model containment="true"
	 * @generated
	 */
	TCGDisjunctiveNormalForm getCondition();

	/**
	 * Sets the value of the '{@link net.sf.parteg.base.testcasegraph.generated.TCGRealNode#getCondition <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' containment reference.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(TCGDisjunctiveNormalForm value);

	/**
	 * Returns the value of the '<em><b>Sub Graph</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Graph</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Graph</em>' reference.
	 * @see #setSubGraph(TestCaseGraph)
	 * @see net.sf.parteg.base.testcasegraph.generated.GeneratedPackage#getTCGRealNode_SubGraph()
	 * @model
	 * @generated
	 */
	TestCaseGraph getSubGraph();

	/**
	 * Sets the value of the '{@link net.sf.parteg.base.testcasegraph.generated.TCGRealNode#getSubGraph <em>Sub Graph</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sub Graph</em>' reference.
	 * @see #getSubGraph()
	 * @generated
	 */
	void setSubGraph(TestCaseGraph value);

	/**
	 * Returns the value of the '<em><b>Contained Connection Point References</b></em>' containment reference list.
	 * The list contents are of type {@link net.sf.parteg.base.testcasegraph.generated.TCGIntermediateNode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contained Connection Point References</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contained Connection Point References</em>' containment reference list.
	 * @see net.sf.parteg.base.testcasegraph.generated.GeneratedPackage#getTCGRealNode_ContainedConnectionPointReferences()
	 * @model containment="true"
	 * @generated
	 */
	EList<TCGIntermediateNode> getContainedConnectionPointReferences();

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
	 * @see net.sf.parteg.base.testcasegraph.generated.GeneratedPackage#getTCGRealNode_ContainedConnectionPoints()
	 * @model containment="true"
	 * @generated
	 */
	EList<TCGIntermediateNode> getContainedConnectionPoints();

	/**
	 * Returns the value of the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Container</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Container</em>' reference.
	 * @see #setContainer(TestCaseRegion)
	 * @see net.sf.parteg.base.testcasegraph.generated.GeneratedPackage#getTCGRealNode_Container()
	 * @model required="true"
	 * @generated
	 */
	TestCaseRegion getContainer();

	/**
	 * Sets the value of the '{@link net.sf.parteg.base.testcasegraph.generated.TCGRealNode#getContainer <em>Container</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Container</em>' reference.
	 * @see #getContainer()
	 * @generated
	 */
	void setContainer(TestCaseRegion value);

} // TCGRealNode
