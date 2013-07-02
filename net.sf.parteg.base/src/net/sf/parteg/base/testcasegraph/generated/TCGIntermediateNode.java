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
 * A representation of the model object '<em><b>TCG Intermediate Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.sf.parteg.base.testcasegraph.generated.TCGIntermediateNode#getReferencedConnectionPointReferences <em>Referenced Connection Point References</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasegraph.generated.TCGIntermediateNode#getReferencedConnectionPoints <em>Referenced Connection Points</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasegraph.generated.TCGIntermediateNode#getContainer <em>Container</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasegraph.generated.TCGIntermediateNode#getNodeType <em>Node Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.sf.parteg.base.testcasegraph.generated.GeneratedPackage#getTCGIntermediateNode()
 * @model
 * @generated
 */
public interface TCGIntermediateNode extends TCGNode {
	/**
	 * Returns the value of the '<em><b>Referenced Connection Point References</b></em>' reference list.
	 * The list contents are of type {@link net.sf.parteg.base.testcasegraph.generated.TCGIntermediateNode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referenced Connection Point References</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referenced Connection Point References</em>' reference list.
	 * @see net.sf.parteg.base.testcasegraph.generated.GeneratedPackage#getTCGIntermediateNode_ReferencedConnectionPointReferences()
	 * @model
	 * @generated
	 */
	EList<TCGIntermediateNode> getReferencedConnectionPointReferences();

	/**
	 * Returns the value of the '<em><b>Referenced Connection Points</b></em>' reference list.
	 * The list contents are of type {@link net.sf.parteg.base.testcasegraph.generated.TCGIntermediateNode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referenced Connection Points</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referenced Connection Points</em>' reference list.
	 * @see net.sf.parteg.base.testcasegraph.generated.GeneratedPackage#getTCGIntermediateNode_ReferencedConnectionPoints()
	 * @model
	 * @generated
	 */
	EList<TCGIntermediateNode> getReferencedConnectionPoints();

	/**
	 * Returns the value of the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Container</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Container</em>' reference.
	 * @see #setContainer(EObject)
	 * @see net.sf.parteg.base.testcasegraph.generated.GeneratedPackage#getTCGIntermediateNode_Container()
	 * @model
	 * @generated
	 */
	EObject getContainer();

	/**
	 * Sets the value of the '{@link net.sf.parteg.base.testcasegraph.generated.TCGIntermediateNode#getContainer <em>Container</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Container</em>' reference.
	 * @see #getContainer()
	 * @generated
	 */
	void setContainer(EObject value);

	/**
	 * Returns the value of the '<em><b>Node Type</b></em>' attribute.
	 * The default value is <code>"unknown"</code>.
	 * The literals are from the enumeration {@link net.sf.parteg.base.testcasegraph.generated.TCGNodeType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Node Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Node Type</em>' attribute.
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGNodeType
	 * @see #setNodeType(TCGNodeType)
	 * @see net.sf.parteg.base.testcasegraph.generated.GeneratedPackage#getTCGIntermediateNode_NodeType()
	 * @model default="unknown" required="true"
	 * @generated
	 */
	TCGNodeType getNodeType();

	/**
	 * Sets the value of the '{@link net.sf.parteg.base.testcasegraph.generated.TCGIntermediateNode#getNodeType <em>Node Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Node Type</em>' attribute.
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGNodeType
	 * @see #getNodeType()
	 * @generated
	 */
	void setNodeType(TCGNodeType value);

} // TCGIntermediateNode
