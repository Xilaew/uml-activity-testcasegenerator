/**
 */
package org.xilaew.atg.model.abstractTestCaseGraph;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.xilaew.atg.model.abstractTestCaseGraph.AbstractTestCaseGraphFactory
 * @model kind="package"
 * @generated
 */
public interface AbstractTestCaseGraphPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "abstractTestCaseGraph";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://org.xilaew.atg.model.abstractTestCaseGraph";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.xilaew.atg.model.abstractTestCaseGraph";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AbstractTestCaseGraphPackage eINSTANCE = org.xilaew.atg.model.abstractTestCaseGraph.impl.AbstractTestCaseGraphPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.xilaew.atg.model.abstractTestCaseGraph.impl.AbstractTCGElementImpl <em>Abstract TCG Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xilaew.atg.model.abstractTestCaseGraph.impl.AbstractTCGElementImpl
	 * @see org.xilaew.atg.model.abstractTestCaseGraph.impl.AbstractTestCaseGraphPackageImpl#getAbstractTCGElement()
	 * @generated
	 */
	int ABSTRACT_TCG_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TCG_ELEMENT__EANNOTATIONS = EcorePackage.EMODEL_ELEMENT__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TCG_ELEMENT__NAME = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Abstract TCG Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TCG_ELEMENT_FEATURE_COUNT = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get EAnnotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TCG_ELEMENT___GET_EANNOTATION__STRING = EcorePackage.EMODEL_ELEMENT___GET_EANNOTATION__STRING;

	/**
	 * The number of operations of the '<em>Abstract TCG Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TCG_ELEMENT_OPERATION_COUNT = EcorePackage.EMODEL_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.xilaew.atg.model.abstractTestCaseGraph.impl.AbstractTCGContainerImpl <em>Abstract TCG Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xilaew.atg.model.abstractTestCaseGraph.impl.AbstractTCGContainerImpl
	 * @see org.xilaew.atg.model.abstractTestCaseGraph.impl.AbstractTestCaseGraphPackageImpl#getAbstractTCGContainer()
	 * @generated
	 */
	int ABSTRACT_TCG_CONTAINER = 1;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TCG_CONTAINER__EANNOTATIONS = ABSTRACT_TCG_ELEMENT__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TCG_CONTAINER__NAME = ABSTRACT_TCG_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TCG_CONTAINER__NODES = ABSTRACT_TCG_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TCG_CONTAINER__EDGES = ABSTRACT_TCG_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Abstract TCG Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TCG_CONTAINER_FEATURE_COUNT = ABSTRACT_TCG_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get EAnnotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TCG_CONTAINER___GET_EANNOTATION__STRING = ABSTRACT_TCG_ELEMENT___GET_EANNOTATION__STRING;

	/**
	 * The number of operations of the '<em>Abstract TCG Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TCG_CONTAINER_OPERATION_COUNT = ABSTRACT_TCG_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.xilaew.atg.model.abstractTestCaseGraph.impl.AbstractTCGNodeImpl <em>Abstract TCG Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xilaew.atg.model.abstractTestCaseGraph.impl.AbstractTCGNodeImpl
	 * @see org.xilaew.atg.model.abstractTestCaseGraph.impl.AbstractTestCaseGraphPackageImpl#getAbstractTCGNode()
	 * @generated
	 */
	int ABSTRACT_TCG_NODE = 2;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TCG_NODE__EANNOTATIONS = ABSTRACT_TCG_ELEMENT__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TCG_NODE__NAME = ABSTRACT_TCG_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TCG_NODE__OUTGOING = ABSTRACT_TCG_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TCG_NODE__INCOMING = ABSTRACT_TCG_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Abstract TCG Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TCG_NODE_FEATURE_COUNT = ABSTRACT_TCG_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get EAnnotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TCG_NODE___GET_EANNOTATION__STRING = ABSTRACT_TCG_ELEMENT___GET_EANNOTATION__STRING;

	/**
	 * The number of operations of the '<em>Abstract TCG Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TCG_NODE_OPERATION_COUNT = ABSTRACT_TCG_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.xilaew.atg.model.abstractTestCaseGraph.impl.AbstractTCGEdgeImpl <em>Abstract TCG Edge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xilaew.atg.model.abstractTestCaseGraph.impl.AbstractTCGEdgeImpl
	 * @see org.xilaew.atg.model.abstractTestCaseGraph.impl.AbstractTestCaseGraphPackageImpl#getAbstractTCGEdge()
	 * @generated
	 */
	int ABSTRACT_TCG_EDGE = 3;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TCG_EDGE__EANNOTATIONS = ABSTRACT_TCG_ELEMENT__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TCG_EDGE__NAME = ABSTRACT_TCG_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TCG_EDGE__SOURCE = ABSTRACT_TCG_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TCG_EDGE__TARGET = ABSTRACT_TCG_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Guard</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TCG_EDGE__GUARD = ABSTRACT_TCG_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Abstract TCG Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TCG_EDGE_FEATURE_COUNT = ABSTRACT_TCG_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Get EAnnotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TCG_EDGE___GET_EANNOTATION__STRING = ABSTRACT_TCG_ELEMENT___GET_EANNOTATION__STRING;

	/**
	 * The number of operations of the '<em>Abstract TCG Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TCG_EDGE_OPERATION_COUNT = ABSTRACT_TCG_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.xilaew.atg.model.abstractTestCaseGraph.impl.AbstractTCGRealNodeImpl <em>Abstract TCG Real Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xilaew.atg.model.abstractTestCaseGraph.impl.AbstractTCGRealNodeImpl
	 * @see org.xilaew.atg.model.abstractTestCaseGraph.impl.AbstractTestCaseGraphPackageImpl#getAbstractTCGRealNode()
	 * @generated
	 */
	int ABSTRACT_TCG_REAL_NODE = 4;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TCG_REAL_NODE__EANNOTATIONS = ABSTRACT_TCG_NODE__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TCG_REAL_NODE__NAME = ABSTRACT_TCG_NODE__NAME;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TCG_REAL_NODE__OUTGOING = ABSTRACT_TCG_NODE__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TCG_REAL_NODE__INCOMING = ABSTRACT_TCG_NODE__INCOMING;

	/**
	 * The number of structural features of the '<em>Abstract TCG Real Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TCG_REAL_NODE_FEATURE_COUNT = ABSTRACT_TCG_NODE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get EAnnotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TCG_REAL_NODE___GET_EANNOTATION__STRING = ABSTRACT_TCG_NODE___GET_EANNOTATION__STRING;

	/**
	 * The number of operations of the '<em>Abstract TCG Real Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TCG_REAL_NODE_OPERATION_COUNT = ABSTRACT_TCG_NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.xilaew.atg.model.abstractTestCaseGraph.impl.AbstractTCGPseudoNodeImpl <em>Abstract TCG Pseudo Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xilaew.atg.model.abstractTestCaseGraph.impl.AbstractTCGPseudoNodeImpl
	 * @see org.xilaew.atg.model.abstractTestCaseGraph.impl.AbstractTestCaseGraphPackageImpl#getAbstractTCGPseudoNode()
	 * @generated
	 */
	int ABSTRACT_TCG_PSEUDO_NODE = 5;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TCG_PSEUDO_NODE__EANNOTATIONS = ABSTRACT_TCG_NODE__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TCG_PSEUDO_NODE__NAME = ABSTRACT_TCG_NODE__NAME;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TCG_PSEUDO_NODE__OUTGOING = ABSTRACT_TCG_NODE__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TCG_PSEUDO_NODE__INCOMING = ABSTRACT_TCG_NODE__INCOMING;

	/**
	 * The number of structural features of the '<em>Abstract TCG Pseudo Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TCG_PSEUDO_NODE_FEATURE_COUNT = ABSTRACT_TCG_NODE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get EAnnotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TCG_PSEUDO_NODE___GET_EANNOTATION__STRING = ABSTRACT_TCG_NODE___GET_EANNOTATION__STRING;

	/**
	 * The number of operations of the '<em>Abstract TCG Pseudo Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TCG_PSEUDO_NODE_OPERATION_COUNT = ABSTRACT_TCG_NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.xilaew.atg.model.abstractTestCaseGraph.impl.AbstractTCGConstraintImpl <em>Abstract TCG Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xilaew.atg.model.abstractTestCaseGraph.impl.AbstractTCGConstraintImpl
	 * @see org.xilaew.atg.model.abstractTestCaseGraph.impl.AbstractTestCaseGraphPackageImpl#getAbstractTCGConstraint()
	 * @generated
	 */
	int ABSTRACT_TCG_CONSTRAINT = 6;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TCG_CONSTRAINT__EANNOTATIONS = ABSTRACT_TCG_ELEMENT__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TCG_CONSTRAINT__NAME = ABSTRACT_TCG_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>Abstract TCG Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TCG_CONSTRAINT_FEATURE_COUNT = ABSTRACT_TCG_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get EAnnotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TCG_CONSTRAINT___GET_EANNOTATION__STRING = ABSTRACT_TCG_ELEMENT___GET_EANNOTATION__STRING;

	/**
	 * The number of operations of the '<em>Abstract TCG Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TCG_CONSTRAINT_OPERATION_COUNT = ABSTRACT_TCG_ELEMENT_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGElement <em>Abstract TCG Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract TCG Element</em>'.
	 * @see org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGElement
	 * @generated
	 */
	EClass getAbstractTCGElement();

	/**
	 * Returns the meta object for the attribute '{@link org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGElement#getName()
	 * @see #getAbstractTCGElement()
	 * @generated
	 */
	EAttribute getAbstractTCGElement_Name();

	/**
	 * Returns the meta object for class '{@link org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGContainer <em>Abstract TCG Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract TCG Container</em>'.
	 * @see org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGContainer
	 * @generated
	 */
	EClass getAbstractTCGContainer();

	/**
	 * Returns the meta object for the containment reference list '{@link org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGContainer#getNodes <em>Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Nodes</em>'.
	 * @see org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGContainer#getNodes()
	 * @see #getAbstractTCGContainer()
	 * @generated
	 */
	EReference getAbstractTCGContainer_Nodes();

	/**
	 * Returns the meta object for the containment reference list '{@link org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGContainer#getEdges <em>Edges</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Edges</em>'.
	 * @see org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGContainer#getEdges()
	 * @see #getAbstractTCGContainer()
	 * @generated
	 */
	EReference getAbstractTCGContainer_Edges();

	/**
	 * Returns the meta object for class '{@link org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGNode <em>Abstract TCG Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract TCG Node</em>'.
	 * @see org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGNode
	 * @generated
	 */
	EClass getAbstractTCGNode();

	/**
	 * Returns the meta object for the reference list '{@link org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGNode#getOutgoing <em>Outgoing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outgoing</em>'.
	 * @see org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGNode#getOutgoing()
	 * @see #getAbstractTCGNode()
	 * @generated
	 */
	EReference getAbstractTCGNode_Outgoing();

	/**
	 * Returns the meta object for the reference list '{@link org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGNode#getIncoming <em>Incoming</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Incoming</em>'.
	 * @see org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGNode#getIncoming()
	 * @see #getAbstractTCGNode()
	 * @generated
	 */
	EReference getAbstractTCGNode_Incoming();

	/**
	 * Returns the meta object for class '{@link org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGEdge <em>Abstract TCG Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract TCG Edge</em>'.
	 * @see org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGEdge
	 * @generated
	 */
	EClass getAbstractTCGEdge();

	/**
	 * Returns the meta object for the reference '{@link org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGEdge#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGEdge#getSource()
	 * @see #getAbstractTCGEdge()
	 * @generated
	 */
	EReference getAbstractTCGEdge_Source();

	/**
	 * Returns the meta object for the reference '{@link org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGEdge#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGEdge#getTarget()
	 * @see #getAbstractTCGEdge()
	 * @generated
	 */
	EReference getAbstractTCGEdge_Target();

	/**
	 * Returns the meta object for the containment reference '{@link org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGEdge#getGuard <em>Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Guard</em>'.
	 * @see org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGEdge#getGuard()
	 * @see #getAbstractTCGEdge()
	 * @generated
	 */
	EReference getAbstractTCGEdge_Guard();

	/**
	 * Returns the meta object for class '{@link org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGRealNode <em>Abstract TCG Real Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract TCG Real Node</em>'.
	 * @see org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGRealNode
	 * @generated
	 */
	EClass getAbstractTCGRealNode();

	/**
	 * Returns the meta object for class '{@link org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGPseudoNode <em>Abstract TCG Pseudo Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract TCG Pseudo Node</em>'.
	 * @see org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGPseudoNode
	 * @generated
	 */
	EClass getAbstractTCGPseudoNode();

	/**
	 * Returns the meta object for class '{@link org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGConstraint <em>Abstract TCG Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract TCG Constraint</em>'.
	 * @see org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGConstraint
	 * @generated
	 */
	EClass getAbstractTCGConstraint();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	AbstractTestCaseGraphFactory getAbstractTestCaseGraphFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.xilaew.atg.model.abstractTestCaseGraph.impl.AbstractTCGElementImpl <em>Abstract TCG Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xilaew.atg.model.abstractTestCaseGraph.impl.AbstractTCGElementImpl
		 * @see org.xilaew.atg.model.abstractTestCaseGraph.impl.AbstractTestCaseGraphPackageImpl#getAbstractTCGElement()
		 * @generated
		 */
		EClass ABSTRACT_TCG_ELEMENT = eINSTANCE.getAbstractTCGElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_TCG_ELEMENT__NAME = eINSTANCE.getAbstractTCGElement_Name();

		/**
		 * The meta object literal for the '{@link org.xilaew.atg.model.abstractTestCaseGraph.impl.AbstractTCGContainerImpl <em>Abstract TCG Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xilaew.atg.model.abstractTestCaseGraph.impl.AbstractTCGContainerImpl
		 * @see org.xilaew.atg.model.abstractTestCaseGraph.impl.AbstractTestCaseGraphPackageImpl#getAbstractTCGContainer()
		 * @generated
		 */
		EClass ABSTRACT_TCG_CONTAINER = eINSTANCE.getAbstractTCGContainer();

		/**
		 * The meta object literal for the '<em><b>Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_TCG_CONTAINER__NODES = eINSTANCE.getAbstractTCGContainer_Nodes();

		/**
		 * The meta object literal for the '<em><b>Edges</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_TCG_CONTAINER__EDGES = eINSTANCE.getAbstractTCGContainer_Edges();

		/**
		 * The meta object literal for the '{@link org.xilaew.atg.model.abstractTestCaseGraph.impl.AbstractTCGNodeImpl <em>Abstract TCG Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xilaew.atg.model.abstractTestCaseGraph.impl.AbstractTCGNodeImpl
		 * @see org.xilaew.atg.model.abstractTestCaseGraph.impl.AbstractTestCaseGraphPackageImpl#getAbstractTCGNode()
		 * @generated
		 */
		EClass ABSTRACT_TCG_NODE = eINSTANCE.getAbstractTCGNode();

		/**
		 * The meta object literal for the '<em><b>Outgoing</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_TCG_NODE__OUTGOING = eINSTANCE.getAbstractTCGNode_Outgoing();

		/**
		 * The meta object literal for the '<em><b>Incoming</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_TCG_NODE__INCOMING = eINSTANCE.getAbstractTCGNode_Incoming();

		/**
		 * The meta object literal for the '{@link org.xilaew.atg.model.abstractTestCaseGraph.impl.AbstractTCGEdgeImpl <em>Abstract TCG Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xilaew.atg.model.abstractTestCaseGraph.impl.AbstractTCGEdgeImpl
		 * @see org.xilaew.atg.model.abstractTestCaseGraph.impl.AbstractTestCaseGraphPackageImpl#getAbstractTCGEdge()
		 * @generated
		 */
		EClass ABSTRACT_TCG_EDGE = eINSTANCE.getAbstractTCGEdge();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_TCG_EDGE__SOURCE = eINSTANCE.getAbstractTCGEdge_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_TCG_EDGE__TARGET = eINSTANCE.getAbstractTCGEdge_Target();

		/**
		 * The meta object literal for the '<em><b>Guard</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_TCG_EDGE__GUARD = eINSTANCE.getAbstractTCGEdge_Guard();

		/**
		 * The meta object literal for the '{@link org.xilaew.atg.model.abstractTestCaseGraph.impl.AbstractTCGRealNodeImpl <em>Abstract TCG Real Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xilaew.atg.model.abstractTestCaseGraph.impl.AbstractTCGRealNodeImpl
		 * @see org.xilaew.atg.model.abstractTestCaseGraph.impl.AbstractTestCaseGraphPackageImpl#getAbstractTCGRealNode()
		 * @generated
		 */
		EClass ABSTRACT_TCG_REAL_NODE = eINSTANCE.getAbstractTCGRealNode();

		/**
		 * The meta object literal for the '{@link org.xilaew.atg.model.abstractTestCaseGraph.impl.AbstractTCGPseudoNodeImpl <em>Abstract TCG Pseudo Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xilaew.atg.model.abstractTestCaseGraph.impl.AbstractTCGPseudoNodeImpl
		 * @see org.xilaew.atg.model.abstractTestCaseGraph.impl.AbstractTestCaseGraphPackageImpl#getAbstractTCGPseudoNode()
		 * @generated
		 */
		EClass ABSTRACT_TCG_PSEUDO_NODE = eINSTANCE.getAbstractTCGPseudoNode();

		/**
		 * The meta object literal for the '{@link org.xilaew.atg.model.abstractTestCaseGraph.impl.AbstractTCGConstraintImpl <em>Abstract TCG Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xilaew.atg.model.abstractTestCaseGraph.impl.AbstractTCGConstraintImpl
		 * @see org.xilaew.atg.model.abstractTestCaseGraph.impl.AbstractTestCaseGraphPackageImpl#getAbstractTCGConstraint()
		 * @generated
		 */
		EClass ABSTRACT_TCG_CONSTRAINT = eINSTANCE.getAbstractTCGConstraint();

	}

} //AbstractTestCaseGraphPackage
