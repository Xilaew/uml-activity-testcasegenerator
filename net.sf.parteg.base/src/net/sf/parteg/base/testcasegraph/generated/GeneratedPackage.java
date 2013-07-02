/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.sf.parteg.base.testcasegraph.generated;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see net.sf.parteg.base.testcasegraph.generated.GeneratedFactory
 * @model kind="package"
 * @generated
 */
public interface GeneratedPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "generated";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://net.sf.parteg.base.testcasegraph.generated";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "net.sf.parteg.base.testcasegraph.generated";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GeneratedPackage eINSTANCE = net.sf.parteg.base.testcasegraph.generated.impl.GeneratedPackageImpl.init();

	/**
	 * The meta object id for the '{@link net.sf.parteg.base.testcasegraph.generated.impl.TCGElementImpl <em>TCG Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.sf.parteg.base.testcasegraph.generated.impl.TCGElementImpl
	 * @see net.sf.parteg.base.testcasegraph.generated.impl.GeneratedPackageImpl#getTCGElement()
	 * @generated
	 */
	int TCG_ELEMENT = 17;

	/**
	 * The number of structural features of the '<em>TCG Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_ELEMENT_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link net.sf.parteg.base.testcasegraph.generated.impl.TCGNodeImpl <em>TCG Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.sf.parteg.base.testcasegraph.generated.impl.TCGNodeImpl
	 * @see net.sf.parteg.base.testcasegraph.generated.impl.GeneratedPackageImpl#getTCGNode()
	 * @generated
	 */
	int TCG_NODE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_NODE__NAME = TCG_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Incoming Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_NODE__INCOMING_TRANSITIONS = TCG_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Outgoing Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_NODE__OUTGOING_TRANSITIONS = TCG_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Original Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_NODE__ORIGINAL_NODE = TCG_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Use All Transitions In Parallel</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_NODE__USE_ALL_TRANSITIONS_IN_PARALLEL = TCG_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Referenced Submachine</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_NODE__REFERENCED_SUBMACHINE = TCG_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Min Distance From Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_NODE__MIN_DISTANCE_FROM_START = TCG_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Max Distance From Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_NODE__MAX_DISTANCE_FROM_START = TCG_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>TCG Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_NODE_FEATURE_COUNT = TCG_ELEMENT_FEATURE_COUNT + 8;

	/**
	 * The meta object id for the '{@link net.sf.parteg.base.testcasegraph.generated.impl.TCGRealNodeImpl <em>TCG Real Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.sf.parteg.base.testcasegraph.generated.impl.TCGRealNodeImpl
	 * @see net.sf.parteg.base.testcasegraph.generated.impl.GeneratedPackageImpl#getTCGRealNode()
	 * @generated
	 */
	int TCG_REAL_NODE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_REAL_NODE__NAME = TCG_NODE__NAME;

	/**
	 * The feature id for the '<em><b>Incoming Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_REAL_NODE__INCOMING_TRANSITIONS = TCG_NODE__INCOMING_TRANSITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_REAL_NODE__OUTGOING_TRANSITIONS = TCG_NODE__OUTGOING_TRANSITIONS;

	/**
	 * The feature id for the '<em><b>Original Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_REAL_NODE__ORIGINAL_NODE = TCG_NODE__ORIGINAL_NODE;

	/**
	 * The feature id for the '<em><b>Use All Transitions In Parallel</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_REAL_NODE__USE_ALL_TRANSITIONS_IN_PARALLEL = TCG_NODE__USE_ALL_TRANSITIONS_IN_PARALLEL;

	/**
	 * The feature id for the '<em><b>Referenced Submachine</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_REAL_NODE__REFERENCED_SUBMACHINE = TCG_NODE__REFERENCED_SUBMACHINE;

	/**
	 * The feature id for the '<em><b>Min Distance From Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_REAL_NODE__MIN_DISTANCE_FROM_START = TCG_NODE__MIN_DISTANCE_FROM_START;

	/**
	 * The feature id for the '<em><b>Max Distance From Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_REAL_NODE__MAX_DISTANCE_FROM_START = TCG_NODE__MAX_DISTANCE_FROM_START;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_REAL_NODE__CONDITION = TCG_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Sub Graph</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_REAL_NODE__SUB_GRAPH = TCG_NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Contained Connection Point References</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_REAL_NODE__CONTAINED_CONNECTION_POINT_REFERENCES = TCG_NODE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Contained Connection Points</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_REAL_NODE__CONTAINED_CONNECTION_POINTS = TCG_NODE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_REAL_NODE__CONTAINER = TCG_NODE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>TCG Real Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_REAL_NODE_FEATURE_COUNT = TCG_NODE_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link net.sf.parteg.base.testcasegraph.generated.impl.TCGIntermediateNodeImpl <em>TCG Intermediate Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.sf.parteg.base.testcasegraph.generated.impl.TCGIntermediateNodeImpl
	 * @see net.sf.parteg.base.testcasegraph.generated.impl.GeneratedPackageImpl#getTCGIntermediateNode()
	 * @generated
	 */
	int TCG_INTERMEDIATE_NODE = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_INTERMEDIATE_NODE__NAME = TCG_NODE__NAME;

	/**
	 * The feature id for the '<em><b>Incoming Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_INTERMEDIATE_NODE__INCOMING_TRANSITIONS = TCG_NODE__INCOMING_TRANSITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_INTERMEDIATE_NODE__OUTGOING_TRANSITIONS = TCG_NODE__OUTGOING_TRANSITIONS;

	/**
	 * The feature id for the '<em><b>Original Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_INTERMEDIATE_NODE__ORIGINAL_NODE = TCG_NODE__ORIGINAL_NODE;

	/**
	 * The feature id for the '<em><b>Use All Transitions In Parallel</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_INTERMEDIATE_NODE__USE_ALL_TRANSITIONS_IN_PARALLEL = TCG_NODE__USE_ALL_TRANSITIONS_IN_PARALLEL;

	/**
	 * The feature id for the '<em><b>Referenced Submachine</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_INTERMEDIATE_NODE__REFERENCED_SUBMACHINE = TCG_NODE__REFERENCED_SUBMACHINE;

	/**
	 * The feature id for the '<em><b>Min Distance From Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_INTERMEDIATE_NODE__MIN_DISTANCE_FROM_START = TCG_NODE__MIN_DISTANCE_FROM_START;

	/**
	 * The feature id for the '<em><b>Max Distance From Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_INTERMEDIATE_NODE__MAX_DISTANCE_FROM_START = TCG_NODE__MAX_DISTANCE_FROM_START;

	/**
	 * The feature id for the '<em><b>Referenced Connection Point References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_INTERMEDIATE_NODE__REFERENCED_CONNECTION_POINT_REFERENCES = TCG_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Referenced Connection Points</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_INTERMEDIATE_NODE__REFERENCED_CONNECTION_POINTS = TCG_NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_INTERMEDIATE_NODE__CONTAINER = TCG_NODE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Node Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_INTERMEDIATE_NODE__NODE_TYPE = TCG_NODE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>TCG Intermediate Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_INTERMEDIATE_NODE_FEATURE_COUNT = TCG_NODE_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link net.sf.parteg.base.testcasegraph.generated.impl.TestCaseRegionImpl <em>Test Case Region</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.sf.parteg.base.testcasegraph.generated.impl.TestCaseRegionImpl
	 * @see net.sf.parteg.base.testcasegraph.generated.impl.GeneratedPackageImpl#getTestCaseRegion()
	 * @generated
	 */
	int TEST_CASE_REGION = 3;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_CASE_REGION__NODES = 0;

	/**
	 * The feature id for the '<em><b>Transitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_CASE_REGION__TRANSITIONS = 1;

	/**
	 * The feature id for the '<em><b>Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_CASE_REGION__CONTAINER = 2;

	/**
	 * The number of structural features of the '<em>Test Case Region</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_CASE_REGION_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link net.sf.parteg.base.testcasegraph.generated.impl.TestCaseGraphImpl <em>Test Case Graph</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.sf.parteg.base.testcasegraph.generated.impl.TestCaseGraphImpl
	 * @see net.sf.parteg.base.testcasegraph.generated.impl.GeneratedPackageImpl#getTestCaseGraph()
	 * @generated
	 */
	int TEST_CASE_GRAPH = 4;

	/**
	 * The feature id for the '<em><b>Regions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_CASE_GRAPH__REGIONS = 0;

	/**
	 * The feature id for the '<em><b>Composite Super State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_CASE_GRAPH__COMPOSITE_SUPER_STATE = 1;

	/**
	 * The feature id for the '<em><b>Contained Connection Points</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_CASE_GRAPH__CONTAINED_CONNECTION_POINTS = 2;

	/**
	 * The feature id for the '<em><b>Submachine States</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_CASE_GRAPH__SUBMACHINE_STATES = 3;

	/**
	 * The number of structural features of the '<em>Test Case Graph</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_CASE_GRAPH_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link net.sf.parteg.base.testcasegraph.generated.impl.TCGTransitionImpl <em>TCG Transition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.sf.parteg.base.testcasegraph.generated.impl.TCGTransitionImpl
	 * @see net.sf.parteg.base.testcasegraph.generated.impl.GeneratedPackageImpl#getTCGTransition()
	 * @generated
	 */
	int TCG_TRANSITION = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_TRANSITION__NAME = TCG_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_TRANSITION__SOURCE_NODE = TCG_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Target Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_TRANSITION__TARGET_NODE = TCG_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Events</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_TRANSITION__EVENTS = TCG_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Precondition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_TRANSITION__PRECONDITION = TCG_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Postcondition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_TRANSITION__POSTCONDITION = TCG_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_TRANSITION__CONTAINER = TCG_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Can Be Processed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_TRANSITION__CAN_BE_PROCESSED = TCG_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>TCG Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_TRANSITION_FEATURE_COUNT = TCG_ELEMENT_FEATURE_COUNT + 8;

	/**
	 * The meta object id for the '{@link net.sf.parteg.base.testcasegraph.generated.impl.TCGEquivalenceClassImpl <em>TCG Equivalence Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.sf.parteg.base.testcasegraph.generated.impl.TCGEquivalenceClassImpl
	 * @see net.sf.parteg.base.testcasegraph.generated.impl.GeneratedPackageImpl#getTCGEquivalenceClass()
	 * @generated
	 */
	int TCG_EQUIVALENCE_CLASS = 6;

	/**
	 * The feature id for the '<em><b>Min Border</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_EQUIVALENCE_CLASS__MIN_BORDER = 0;

	/**
	 * The feature id for the '<em><b>Min Included</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_EQUIVALENCE_CLASS__MIN_INCLUDED = 1;

	/**
	 * The feature id for the '<em><b>Max Border</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_EQUIVALENCE_CLASS__MAX_BORDER = 2;

	/**
	 * The feature id for the '<em><b>Max Included</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_EQUIVALENCE_CLASS__MAX_INCLUDED = 3;

	/**
	 * The number of structural features of the '<em>TCG Equivalence Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_EQUIVALENCE_CLASS_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link net.sf.parteg.base.testcasegraph.generated.impl.TCGEventImpl <em>TCG Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.sf.parteg.base.testcasegraph.generated.impl.TCGEventImpl
	 * @see net.sf.parteg.base.testcasegraph.generated.impl.GeneratedPackageImpl#getTCGEvent()
	 * @generated
	 */
	int TCG_EVENT = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_EVENT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_EVENT__PARAMETERS = 1;

	/**
	 * The feature id for the '<em><b>Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_EVENT__EVENT = 2;

	/**
	 * The feature id for the '<em><b>Default Event</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_EVENT__DEFAULT_EVENT = 3;

	/**
	 * The number of structural features of the '<em>TCG Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_EVENT_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link net.sf.parteg.base.testcasegraph.generated.impl.TCGOCLExpressionImpl <em>TCGOCL Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.sf.parteg.base.testcasegraph.generated.impl.TCGOCLExpressionImpl
	 * @see net.sf.parteg.base.testcasegraph.generated.impl.GeneratedPackageImpl#getTCGOCLExpression()
	 * @generated
	 */
	int TCGOCL_EXPRESSION = 8;

	/**
	 * The feature id for the '<em><b>Classification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCGOCL_EXPRESSION__CLASSIFICATION = 0;

	/**
	 * The feature id for the '<em><b>Ocl Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCGOCL_EXPRESSION__OCL_REFERENCE = 1;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCGOCL_EXPRESSION__CONTAINER = 2;

	/**
	 * The feature id for the '<em><b>Positive Assignment Of Original</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCGOCL_EXPRESSION__POSITIVE_ASSIGNMENT_OF_ORIGINAL = 3;

	/**
	 * The feature id for the '<em><b>Transition Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCGOCL_EXPRESSION__TRANSITION_CONTEXT = 4;

	/**
	 * The number of structural features of the '<em>TCGOCL Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCGOCL_EXPRESSION_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link net.sf.parteg.base.testcasegraph.generated.impl.TCGConjunctionImpl <em>TCG Conjunction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.sf.parteg.base.testcasegraph.generated.impl.TCGConjunctionImpl
	 * @see net.sf.parteg.base.testcasegraph.generated.impl.GeneratedPackageImpl#getTCGConjunction()
	 * @generated
	 */
	int TCG_CONJUNCTION = 9;

	/**
	 * The feature id for the '<em><b>Expressions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_CONJUNCTION__EXPRESSIONS = 0;

	/**
	 * The feature id for the '<em><b>Can Change Value If One Expression Changes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_CONJUNCTION__CAN_CHANGE_VALUE_IF_ONE_EXPRESSION_CHANGES = 1;

	/**
	 * The feature id for the '<em><b>Positive Sub Expression Of Original</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_CONJUNCTION__POSITIVE_SUB_EXPRESSION_OF_ORIGINAL = 2;

	/**
	 * The number of structural features of the '<em>TCG Conjunction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_CONJUNCTION_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link net.sf.parteg.base.testcasegraph.generated.impl.TCGDisjunctiveNormalFormImpl <em>TCG Disjunctive Normal Form</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.sf.parteg.base.testcasegraph.generated.impl.TCGDisjunctiveNormalFormImpl
	 * @see net.sf.parteg.base.testcasegraph.generated.impl.GeneratedPackageImpl#getTCGDisjunctiveNormalForm()
	 * @generated
	 */
	int TCG_DISJUNCTIVE_NORMAL_FORM = 10;

	/**
	 * The feature id for the '<em><b>Conjunctions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_DISJUNCTIVE_NORMAL_FORM__CONJUNCTIONS = 0;

	/**
	 * The feature id for the '<em><b>Original Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_DISJUNCTIVE_NORMAL_FORM__ORIGINAL_EXPRESSION = 1;

	/**
	 * The feature id for the '<em><b>Use For Test Goals</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_DISJUNCTIVE_NORMAL_FORM__USE_FOR_TEST_GOALS = 2;

	/**
	 * The number of structural features of the '<em>TCG Disjunctive Normal Form</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_DISJUNCTIVE_NORMAL_FORM_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link net.sf.parteg.base.testcasegraph.generated.impl.TCGOCLOperationImpl <em>TCGOCL Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.sf.parteg.base.testcasegraph.generated.impl.TCGOCLOperationImpl
	 * @see net.sf.parteg.base.testcasegraph.generated.impl.GeneratedPackageImpl#getTCGOCLOperation()
	 * @generated
	 */
	int TCGOCL_OPERATION = 11;

	/**
	 * The feature id for the '<em><b>Classification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCGOCL_OPERATION__CLASSIFICATION = TCGOCL_EXPRESSION__CLASSIFICATION;

	/**
	 * The feature id for the '<em><b>Ocl Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCGOCL_OPERATION__OCL_REFERENCE = TCGOCL_EXPRESSION__OCL_REFERENCE;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCGOCL_OPERATION__CONTAINER = TCGOCL_EXPRESSION__CONTAINER;

	/**
	 * The feature id for the '<em><b>Positive Assignment Of Original</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCGOCL_OPERATION__POSITIVE_ASSIGNMENT_OF_ORIGINAL = TCGOCL_EXPRESSION__POSITIVE_ASSIGNMENT_OF_ORIGINAL;

	/**
	 * The feature id for the '<em><b>Transition Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCGOCL_OPERATION__TRANSITION_CONTEXT = TCGOCL_EXPRESSION__TRANSITION_CONTEXT;

	/**
	 * The feature id for the '<em><b>Left</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCGOCL_OPERATION__LEFT = TCGOCL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Right</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCGOCL_OPERATION__RIGHT = TCGOCL_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCGOCL_OPERATION__OPERATION = TCGOCL_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Operation Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCGOCL_OPERATION__OPERATION_NAME = TCGOCL_EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>TCGOCL Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCGOCL_OPERATION_FEATURE_COUNT = TCGOCL_EXPRESSION_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link net.sf.parteg.base.testcasegraph.generated.impl.TCGOCLAtomImpl <em>TCGOCL Atom</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.sf.parteg.base.testcasegraph.generated.impl.TCGOCLAtomImpl
	 * @see net.sf.parteg.base.testcasegraph.generated.impl.GeneratedPackageImpl#getTCGOCLAtom()
	 * @generated
	 */
	int TCGOCL_ATOM = 12;

	/**
	 * The feature id for the '<em><b>Classification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCGOCL_ATOM__CLASSIFICATION = TCGOCL_EXPRESSION__CLASSIFICATION;

	/**
	 * The feature id for the '<em><b>Ocl Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCGOCL_ATOM__OCL_REFERENCE = TCGOCL_EXPRESSION__OCL_REFERENCE;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCGOCL_ATOM__CONTAINER = TCGOCL_EXPRESSION__CONTAINER;

	/**
	 * The feature id for the '<em><b>Positive Assignment Of Original</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCGOCL_ATOM__POSITIVE_ASSIGNMENT_OF_ORIGINAL = TCGOCL_EXPRESSION__POSITIVE_ASSIGNMENT_OF_ORIGINAL;

	/**
	 * The feature id for the '<em><b>Transition Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCGOCL_ATOM__TRANSITION_CONTEXT = TCGOCL_EXPRESSION__TRANSITION_CONTEXT;

	/**
	 * The feature id for the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCGOCL_ATOM__ELEMENT = TCGOCL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Tcg Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCGOCL_ATOM__TCG_PARAMETER = TCGOCL_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>TCGOCL Atom</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCGOCL_ATOM_FEATURE_COUNT = TCGOCL_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link net.sf.parteg.base.testcasegraph.generated.impl.TCGOCLIfThenElseImpl <em>TCGOCL If Then Else</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.sf.parteg.base.testcasegraph.generated.impl.TCGOCLIfThenElseImpl
	 * @see net.sf.parteg.base.testcasegraph.generated.impl.GeneratedPackageImpl#getTCGOCLIfThenElse()
	 * @generated
	 */
	int TCGOCL_IF_THEN_ELSE = 13;

	/**
	 * The feature id for the '<em><b>Classification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCGOCL_IF_THEN_ELSE__CLASSIFICATION = TCGOCL_EXPRESSION__CLASSIFICATION;

	/**
	 * The feature id for the '<em><b>Ocl Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCGOCL_IF_THEN_ELSE__OCL_REFERENCE = TCGOCL_EXPRESSION__OCL_REFERENCE;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCGOCL_IF_THEN_ELSE__CONTAINER = TCGOCL_EXPRESSION__CONTAINER;

	/**
	 * The feature id for the '<em><b>Positive Assignment Of Original</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCGOCL_IF_THEN_ELSE__POSITIVE_ASSIGNMENT_OF_ORIGINAL = TCGOCL_EXPRESSION__POSITIVE_ASSIGNMENT_OF_ORIGINAL;

	/**
	 * The feature id for the '<em><b>Transition Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCGOCL_IF_THEN_ELSE__TRANSITION_CONTEXT = TCGOCL_EXPRESSION__TRANSITION_CONTEXT;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCGOCL_IF_THEN_ELSE__CONDITION = TCGOCL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Then Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCGOCL_IF_THEN_ELSE__THEN_EXPRESSION = TCGOCL_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Else Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCGOCL_IF_THEN_ELSE__ELSE_EXPRESSION = TCGOCL_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>TCGOCL If Then Else</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCGOCL_IF_THEN_ELSE_FEATURE_COUNT = TCGOCL_EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link net.sf.parteg.base.testcasegraph.generated.TCGParameter <em>TCG Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGParameter
	 * @see net.sf.parteg.base.testcasegraph.generated.impl.GeneratedPackageImpl#getTCGParameter()
	 * @generated
	 */
	int TCG_PARAMETER = 14;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_PARAMETER__NAME = 0;

	/**
	 * The feature id for the '<em><b>Value Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_PARAMETER__VALUE_TYPE = 1;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_PARAMETER__REFERENCE = 2;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_PARAMETER__CONTAINER = 3;

	/**
	 * The number of structural features of the '<em>TCG Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_PARAMETER_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link net.sf.parteg.base.testcasegraph.generated.impl.TCGPrimitiveParameterImpl <em>TCG Primitive Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.sf.parteg.base.testcasegraph.generated.impl.TCGPrimitiveParameterImpl
	 * @see net.sf.parteg.base.testcasegraph.generated.impl.GeneratedPackageImpl#getTCGPrimitiveParameter()
	 * @generated
	 */
	int TCG_PRIMITIVE_PARAMETER = 15;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_PRIMITIVE_PARAMETER__NAME = TCG_PARAMETER__NAME;

	/**
	 * The feature id for the '<em><b>Value Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_PRIMITIVE_PARAMETER__VALUE_TYPE = TCG_PARAMETER__VALUE_TYPE;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_PRIMITIVE_PARAMETER__REFERENCE = TCG_PARAMETER__REFERENCE;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_PRIMITIVE_PARAMETER__CONTAINER = TCG_PARAMETER__CONTAINER;

	/**
	 * The feature id for the '<em><b>Value Type Range</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_PRIMITIVE_PARAMETER__VALUE_TYPE_RANGE = TCG_PARAMETER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>TCG Primitive Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_PRIMITIVE_PARAMETER_FEATURE_COUNT = TCG_PARAMETER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link net.sf.parteg.base.testcasegraph.generated.impl.TCGComplexParameterImpl <em>TCG Complex Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.sf.parteg.base.testcasegraph.generated.impl.TCGComplexParameterImpl
	 * @see net.sf.parteg.base.testcasegraph.generated.impl.GeneratedPackageImpl#getTCGComplexParameter()
	 * @generated
	 */
	int TCG_COMPLEX_PARAMETER = 16;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_COMPLEX_PARAMETER__NAME = TCG_PARAMETER__NAME;

	/**
	 * The feature id for the '<em><b>Value Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_COMPLEX_PARAMETER__VALUE_TYPE = TCG_PARAMETER__VALUE_TYPE;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_COMPLEX_PARAMETER__REFERENCE = TCG_PARAMETER__REFERENCE;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_COMPLEX_PARAMETER__CONTAINER = TCG_PARAMETER__CONTAINER;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_COMPLEX_PARAMETER__PARAMETER = TCG_PARAMETER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>TCG Complex Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_COMPLEX_PARAMETER_FEATURE_COUNT = TCG_PARAMETER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link net.sf.parteg.base.testcasegraph.generated.VariableClassification <em>Variable Classification</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.sf.parteg.base.testcasegraph.generated.VariableClassification
	 * @see net.sf.parteg.base.testcasegraph.generated.impl.GeneratedPackageImpl#getVariableClassification()
	 * @generated
	 */
	int VARIABLE_CLASSIFICATION = 18;


	/**
	 * The meta object id for the '{@link net.sf.parteg.base.testcasegraph.generated.TCGNodeType <em>TCG Node Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGNodeType
	 * @see net.sf.parteg.base.testcasegraph.generated.impl.GeneratedPackageImpl#getTCGNodeType()
	 * @generated
	 */
	int TCG_NODE_TYPE = 19;


	/**
	 * Returns the meta object for class '{@link net.sf.parteg.base.testcasegraph.generated.TCGNode <em>TCG Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TCG Node</em>'.
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGNode
	 * @generated
	 */
	EClass getTCGNode();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.parteg.base.testcasegraph.generated.TCGNode#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGNode#getName()
	 * @see #getTCGNode()
	 * @generated
	 */
	EAttribute getTCGNode_Name();

	/**
	 * Returns the meta object for the reference list '{@link net.sf.parteg.base.testcasegraph.generated.TCGNode#getIncomingTransitions <em>Incoming Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Incoming Transitions</em>'.
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGNode#getIncomingTransitions()
	 * @see #getTCGNode()
	 * @generated
	 */
	EReference getTCGNode_IncomingTransitions();

	/**
	 * Returns the meta object for the reference list '{@link net.sf.parteg.base.testcasegraph.generated.TCGNode#getOutgoingTransitions <em>Outgoing Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outgoing Transitions</em>'.
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGNode#getOutgoingTransitions()
	 * @see #getTCGNode()
	 * @generated
	 */
	EReference getTCGNode_OutgoingTransitions();

	/**
	 * Returns the meta object for the reference '{@link net.sf.parteg.base.testcasegraph.generated.TCGNode#getOriginalNode <em>Original Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Original Node</em>'.
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGNode#getOriginalNode()
	 * @see #getTCGNode()
	 * @generated
	 */
	EReference getTCGNode_OriginalNode();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.parteg.base.testcasegraph.generated.TCGNode#isUseAllTransitionsInParallel <em>Use All Transitions In Parallel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Use All Transitions In Parallel</em>'.
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGNode#isUseAllTransitionsInParallel()
	 * @see #getTCGNode()
	 * @generated
	 */
	EAttribute getTCGNode_UseAllTransitionsInParallel();

	/**
	 * Returns the meta object for the reference '{@link net.sf.parteg.base.testcasegraph.generated.TCGNode#getReferencedSubmachine <em>Referenced Submachine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referenced Submachine</em>'.
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGNode#getReferencedSubmachine()
	 * @see #getTCGNode()
	 * @generated
	 */
	EReference getTCGNode_ReferencedSubmachine();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.parteg.base.testcasegraph.generated.TCGNode#getMinDistanceFromStart <em>Min Distance From Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min Distance From Start</em>'.
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGNode#getMinDistanceFromStart()
	 * @see #getTCGNode()
	 * @generated
	 */
	EAttribute getTCGNode_MinDistanceFromStart();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.parteg.base.testcasegraph.generated.TCGNode#getMaxDistanceFromStart <em>Max Distance From Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Distance From Start</em>'.
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGNode#getMaxDistanceFromStart()
	 * @see #getTCGNode()
	 * @generated
	 */
	EAttribute getTCGNode_MaxDistanceFromStart();

	/**
	 * Returns the meta object for class '{@link net.sf.parteg.base.testcasegraph.generated.TCGRealNode <em>TCG Real Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TCG Real Node</em>'.
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGRealNode
	 * @generated
	 */
	EClass getTCGRealNode();

	/**
	 * Returns the meta object for the containment reference '{@link net.sf.parteg.base.testcasegraph.generated.TCGRealNode#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGRealNode#getCondition()
	 * @see #getTCGRealNode()
	 * @generated
	 */
	EReference getTCGRealNode_Condition();

	/**
	 * Returns the meta object for the reference '{@link net.sf.parteg.base.testcasegraph.generated.TCGRealNode#getSubGraph <em>Sub Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Sub Graph</em>'.
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGRealNode#getSubGraph()
	 * @see #getTCGRealNode()
	 * @generated
	 */
	EReference getTCGRealNode_SubGraph();

	/**
	 * Returns the meta object for the containment reference list '{@link net.sf.parteg.base.testcasegraph.generated.TCGRealNode#getContainedConnectionPointReferences <em>Contained Connection Point References</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Contained Connection Point References</em>'.
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGRealNode#getContainedConnectionPointReferences()
	 * @see #getTCGRealNode()
	 * @generated
	 */
	EReference getTCGRealNode_ContainedConnectionPointReferences();

	/**
	 * Returns the meta object for the containment reference list '{@link net.sf.parteg.base.testcasegraph.generated.TCGRealNode#getContainedConnectionPoints <em>Contained Connection Points</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Contained Connection Points</em>'.
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGRealNode#getContainedConnectionPoints()
	 * @see #getTCGRealNode()
	 * @generated
	 */
	EReference getTCGRealNode_ContainedConnectionPoints();

	/**
	 * Returns the meta object for the reference '{@link net.sf.parteg.base.testcasegraph.generated.TCGRealNode#getContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Container</em>'.
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGRealNode#getContainer()
	 * @see #getTCGRealNode()
	 * @generated
	 */
	EReference getTCGRealNode_Container();

	/**
	 * Returns the meta object for class '{@link net.sf.parteg.base.testcasegraph.generated.TCGIntermediateNode <em>TCG Intermediate Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TCG Intermediate Node</em>'.
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGIntermediateNode
	 * @generated
	 */
	EClass getTCGIntermediateNode();

	/**
	 * Returns the meta object for the reference list '{@link net.sf.parteg.base.testcasegraph.generated.TCGIntermediateNode#getReferencedConnectionPointReferences <em>Referenced Connection Point References</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Referenced Connection Point References</em>'.
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGIntermediateNode#getReferencedConnectionPointReferences()
	 * @see #getTCGIntermediateNode()
	 * @generated
	 */
	EReference getTCGIntermediateNode_ReferencedConnectionPointReferences();

	/**
	 * Returns the meta object for the reference list '{@link net.sf.parteg.base.testcasegraph.generated.TCGIntermediateNode#getReferencedConnectionPoints <em>Referenced Connection Points</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Referenced Connection Points</em>'.
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGIntermediateNode#getReferencedConnectionPoints()
	 * @see #getTCGIntermediateNode()
	 * @generated
	 */
	EReference getTCGIntermediateNode_ReferencedConnectionPoints();

	/**
	 * Returns the meta object for the reference '{@link net.sf.parteg.base.testcasegraph.generated.TCGIntermediateNode#getContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Container</em>'.
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGIntermediateNode#getContainer()
	 * @see #getTCGIntermediateNode()
	 * @generated
	 */
	EReference getTCGIntermediateNode_Container();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.parteg.base.testcasegraph.generated.TCGIntermediateNode#getNodeType <em>Node Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Node Type</em>'.
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGIntermediateNode#getNodeType()
	 * @see #getTCGIntermediateNode()
	 * @generated
	 */
	EAttribute getTCGIntermediateNode_NodeType();

	/**
	 * Returns the meta object for class '{@link net.sf.parteg.base.testcasegraph.generated.TestCaseRegion <em>Test Case Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Test Case Region</em>'.
	 * @see net.sf.parteg.base.testcasegraph.generated.TestCaseRegion
	 * @generated
	 */
	EClass getTestCaseRegion();

	/**
	 * Returns the meta object for the containment reference list '{@link net.sf.parteg.base.testcasegraph.generated.TestCaseRegion#getNodes <em>Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Nodes</em>'.
	 * @see net.sf.parteg.base.testcasegraph.generated.TestCaseRegion#getNodes()
	 * @see #getTestCaseRegion()
	 * @generated
	 */
	EReference getTestCaseRegion_Nodes();

	/**
	 * Returns the meta object for the containment reference list '{@link net.sf.parteg.base.testcasegraph.generated.TestCaseRegion#getTransitions <em>Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Transitions</em>'.
	 * @see net.sf.parteg.base.testcasegraph.generated.TestCaseRegion#getTransitions()
	 * @see #getTestCaseRegion()
	 * @generated
	 */
	EReference getTestCaseRegion_Transitions();

	/**
	 * Returns the meta object for the container reference '{@link net.sf.parteg.base.testcasegraph.generated.TestCaseRegion#getContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Container</em>'.
	 * @see net.sf.parteg.base.testcasegraph.generated.TestCaseRegion#getContainer()
	 * @see #getTestCaseRegion()
	 * @generated
	 */
	EReference getTestCaseRegion_Container();

	/**
	 * Returns the meta object for class '{@link net.sf.parteg.base.testcasegraph.generated.TestCaseGraph <em>Test Case Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Test Case Graph</em>'.
	 * @see net.sf.parteg.base.testcasegraph.generated.TestCaseGraph
	 * @generated
	 */
	EClass getTestCaseGraph();

	/**
	 * Returns the meta object for the containment reference list '{@link net.sf.parteg.base.testcasegraph.generated.TestCaseGraph#getRegions <em>Regions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Regions</em>'.
	 * @see net.sf.parteg.base.testcasegraph.generated.TestCaseGraph#getRegions()
	 * @see #getTestCaseGraph()
	 * @generated
	 */
	EReference getTestCaseGraph_Regions();

	/**
	 * Returns the meta object for the reference '{@link net.sf.parteg.base.testcasegraph.generated.TestCaseGraph#getCompositeSuperState <em>Composite Super State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Composite Super State</em>'.
	 * @see net.sf.parteg.base.testcasegraph.generated.TestCaseGraph#getCompositeSuperState()
	 * @see #getTestCaseGraph()
	 * @generated
	 */
	EReference getTestCaseGraph_CompositeSuperState();

	/**
	 * Returns the meta object for the containment reference list '{@link net.sf.parteg.base.testcasegraph.generated.TestCaseGraph#getContainedConnectionPoints <em>Contained Connection Points</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Contained Connection Points</em>'.
	 * @see net.sf.parteg.base.testcasegraph.generated.TestCaseGraph#getContainedConnectionPoints()
	 * @see #getTestCaseGraph()
	 * @generated
	 */
	EReference getTestCaseGraph_ContainedConnectionPoints();

	/**
	 * Returns the meta object for the reference list '{@link net.sf.parteg.base.testcasegraph.generated.TestCaseGraph#getSubmachineStates <em>Submachine States</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Submachine States</em>'.
	 * @see net.sf.parteg.base.testcasegraph.generated.TestCaseGraph#getSubmachineStates()
	 * @see #getTestCaseGraph()
	 * @generated
	 */
	EReference getTestCaseGraph_SubmachineStates();

	/**
	 * Returns the meta object for class '{@link net.sf.parteg.base.testcasegraph.generated.TCGTransition <em>TCG Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TCG Transition</em>'.
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGTransition
	 * @generated
	 */
	EClass getTCGTransition();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.parteg.base.testcasegraph.generated.TCGTransition#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGTransition#getName()
	 * @see #getTCGTransition()
	 * @generated
	 */
	EAttribute getTCGTransition_Name();

	/**
	 * Returns the meta object for the reference '{@link net.sf.parteg.base.testcasegraph.generated.TCGTransition#getSourceNode <em>Source Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source Node</em>'.
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGTransition#getSourceNode()
	 * @see #getTCGTransition()
	 * @generated
	 */
	EReference getTCGTransition_SourceNode();

	/**
	 * Returns the meta object for the reference '{@link net.sf.parteg.base.testcasegraph.generated.TCGTransition#getTargetNode <em>Target Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Node</em>'.
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGTransition#getTargetNode()
	 * @see #getTCGTransition()
	 * @generated
	 */
	EReference getTCGTransition_TargetNode();

	/**
	 * Returns the meta object for the reference list '{@link net.sf.parteg.base.testcasegraph.generated.TCGTransition#getEvents <em>Events</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Events</em>'.
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGTransition#getEvents()
	 * @see #getTCGTransition()
	 * @generated
	 */
	EReference getTCGTransition_Events();

	/**
	 * Returns the meta object for the containment reference '{@link net.sf.parteg.base.testcasegraph.generated.TCGTransition#getPrecondition <em>Precondition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Precondition</em>'.
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGTransition#getPrecondition()
	 * @see #getTCGTransition()
	 * @generated
	 */
	EReference getTCGTransition_Precondition();

	/**
	 * Returns the meta object for the containment reference '{@link net.sf.parteg.base.testcasegraph.generated.TCGTransition#getPostcondition <em>Postcondition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Postcondition</em>'.
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGTransition#getPostcondition()
	 * @see #getTCGTransition()
	 * @generated
	 */
	EReference getTCGTransition_Postcondition();

	/**
	 * Returns the meta object for the container reference '{@link net.sf.parteg.base.testcasegraph.generated.TCGTransition#getContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Container</em>'.
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGTransition#getContainer()
	 * @see #getTCGTransition()
	 * @generated
	 */
	EReference getTCGTransition_Container();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.parteg.base.testcasegraph.generated.TCGTransition#isCanBeProcessed <em>Can Be Processed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Can Be Processed</em>'.
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGTransition#isCanBeProcessed()
	 * @see #getTCGTransition()
	 * @generated
	 */
	EAttribute getTCGTransition_CanBeProcessed();

	/**
	 * Returns the meta object for class '{@link net.sf.parteg.base.testcasegraph.generated.TCGEquivalenceClass <em>TCG Equivalence Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TCG Equivalence Class</em>'.
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGEquivalenceClass
	 * @generated
	 */
	EClass getTCGEquivalenceClass();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.parteg.base.testcasegraph.generated.TCGEquivalenceClass#getMinBorder <em>Min Border</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min Border</em>'.
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGEquivalenceClass#getMinBorder()
	 * @see #getTCGEquivalenceClass()
	 * @generated
	 */
	EAttribute getTCGEquivalenceClass_MinBorder();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.parteg.base.testcasegraph.generated.TCGEquivalenceClass#getMinIncluded <em>Min Included</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min Included</em>'.
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGEquivalenceClass#getMinIncluded()
	 * @see #getTCGEquivalenceClass()
	 * @generated
	 */
	EAttribute getTCGEquivalenceClass_MinIncluded();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.parteg.base.testcasegraph.generated.TCGEquivalenceClass#getMaxBorder <em>Max Border</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Border</em>'.
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGEquivalenceClass#getMaxBorder()
	 * @see #getTCGEquivalenceClass()
	 * @generated
	 */
	EAttribute getTCGEquivalenceClass_MaxBorder();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.parteg.base.testcasegraph.generated.TCGEquivalenceClass#getMaxIncluded <em>Max Included</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Included</em>'.
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGEquivalenceClass#getMaxIncluded()
	 * @see #getTCGEquivalenceClass()
	 * @generated
	 */
	EAttribute getTCGEquivalenceClass_MaxIncluded();

	/**
	 * Returns the meta object for class '{@link net.sf.parteg.base.testcasegraph.generated.TCGEvent <em>TCG Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TCG Event</em>'.
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGEvent
	 * @generated
	 */
	EClass getTCGEvent();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.parteg.base.testcasegraph.generated.TCGEvent#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGEvent#getName()
	 * @see #getTCGEvent()
	 * @generated
	 */
	EAttribute getTCGEvent_Name();

	/**
	 * Returns the meta object for the reference list '{@link net.sf.parteg.base.testcasegraph.generated.TCGEvent#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Parameters</em>'.
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGEvent#getParameters()
	 * @see #getTCGEvent()
	 * @generated
	 */
	EReference getTCGEvent_Parameters();

	/**
	 * Returns the meta object for the reference '{@link net.sf.parteg.base.testcasegraph.generated.TCGEvent#getEvent <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Event</em>'.
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGEvent#getEvent()
	 * @see #getTCGEvent()
	 * @generated
	 */
	EReference getTCGEvent_Event();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.parteg.base.testcasegraph.generated.TCGEvent#isDefaultEvent <em>Default Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default Event</em>'.
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGEvent#isDefaultEvent()
	 * @see #getTCGEvent()
	 * @generated
	 */
	EAttribute getTCGEvent_DefaultEvent();

	/**
	 * Returns the meta object for class '{@link net.sf.parteg.base.testcasegraph.generated.TCGOCLExpression <em>TCGOCL Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TCGOCL Expression</em>'.
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGOCLExpression
	 * @generated
	 */
	EClass getTCGOCLExpression();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.parteg.base.testcasegraph.generated.TCGOCLExpression#getClassification <em>Classification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Classification</em>'.
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGOCLExpression#getClassification()
	 * @see #getTCGOCLExpression()
	 * @generated
	 */
	EAttribute getTCGOCLExpression_Classification();

	/**
	 * Returns the meta object for the reference '{@link net.sf.parteg.base.testcasegraph.generated.TCGOCLExpression#getOclReference <em>Ocl Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ocl Reference</em>'.
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGOCLExpression#getOclReference()
	 * @see #getTCGOCLExpression()
	 * @generated
	 */
	EReference getTCGOCLExpression_OclReference();

	/**
	 * Returns the meta object for the reference '{@link net.sf.parteg.base.testcasegraph.generated.TCGOCLExpression#getContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Container</em>'.
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGOCLExpression#getContainer()
	 * @see #getTCGOCLExpression()
	 * @generated
	 */
	EReference getTCGOCLExpression_Container();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.parteg.base.testcasegraph.generated.TCGOCLExpression#isPositiveAssignmentOfOriginal <em>Positive Assignment Of Original</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Positive Assignment Of Original</em>'.
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGOCLExpression#isPositiveAssignmentOfOriginal()
	 * @see #getTCGOCLExpression()
	 * @generated
	 */
	EAttribute getTCGOCLExpression_PositiveAssignmentOfOriginal();

	/**
	 * Returns the meta object for the reference '{@link net.sf.parteg.base.testcasegraph.generated.TCGOCLExpression#getTransitionContext <em>Transition Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Transition Context</em>'.
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGOCLExpression#getTransitionContext()
	 * @see #getTCGOCLExpression()
	 * @generated
	 */
	EReference getTCGOCLExpression_TransitionContext();

	/**
	 * Returns the meta object for class '{@link net.sf.parteg.base.testcasegraph.generated.TCGConjunction <em>TCG Conjunction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TCG Conjunction</em>'.
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGConjunction
	 * @generated
	 */
	EClass getTCGConjunction();

	/**
	 * Returns the meta object for the reference list '{@link net.sf.parteg.base.testcasegraph.generated.TCGConjunction#getExpressions <em>Expressions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Expressions</em>'.
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGConjunction#getExpressions()
	 * @see #getTCGConjunction()
	 * @generated
	 */
	EReference getTCGConjunction_Expressions();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.parteg.base.testcasegraph.generated.TCGConjunction#isCanChangeValueIfOneExpressionChanges <em>Can Change Value If One Expression Changes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Can Change Value If One Expression Changes</em>'.
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGConjunction#isCanChangeValueIfOneExpressionChanges()
	 * @see #getTCGConjunction()
	 * @generated
	 */
	EAttribute getTCGConjunction_CanChangeValueIfOneExpressionChanges();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.parteg.base.testcasegraph.generated.TCGConjunction#isPositiveSubExpressionOfOriginal <em>Positive Sub Expression Of Original</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Positive Sub Expression Of Original</em>'.
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGConjunction#isPositiveSubExpressionOfOriginal()
	 * @see #getTCGConjunction()
	 * @generated
	 */
	EAttribute getTCGConjunction_PositiveSubExpressionOfOriginal();

	/**
	 * Returns the meta object for class '{@link net.sf.parteg.base.testcasegraph.generated.TCGDisjunctiveNormalForm <em>TCG Disjunctive Normal Form</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TCG Disjunctive Normal Form</em>'.
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGDisjunctiveNormalForm
	 * @generated
	 */
	EClass getTCGDisjunctiveNormalForm();

	/**
	 * Returns the meta object for the reference list '{@link net.sf.parteg.base.testcasegraph.generated.TCGDisjunctiveNormalForm#getConjunctions <em>Conjunctions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Conjunctions</em>'.
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGDisjunctiveNormalForm#getConjunctions()
	 * @see #getTCGDisjunctiveNormalForm()
	 * @generated
	 */
	EReference getTCGDisjunctiveNormalForm_Conjunctions();

	/**
	 * Returns the meta object for the reference '{@link net.sf.parteg.base.testcasegraph.generated.TCGDisjunctiveNormalForm#getOriginalExpression <em>Original Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Original Expression</em>'.
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGDisjunctiveNormalForm#getOriginalExpression()
	 * @see #getTCGDisjunctiveNormalForm()
	 * @generated
	 */
	EReference getTCGDisjunctiveNormalForm_OriginalExpression();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.parteg.base.testcasegraph.generated.TCGDisjunctiveNormalForm#isUseForTestGoals <em>Use For Test Goals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Use For Test Goals</em>'.
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGDisjunctiveNormalForm#isUseForTestGoals()
	 * @see #getTCGDisjunctiveNormalForm()
	 * @generated
	 */
	EAttribute getTCGDisjunctiveNormalForm_UseForTestGoals();

	/**
	 * Returns the meta object for class '{@link net.sf.parteg.base.testcasegraph.generated.TCGOCLOperation <em>TCGOCL Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TCGOCL Operation</em>'.
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGOCLOperation
	 * @generated
	 */
	EClass getTCGOCLOperation();

	/**
	 * Returns the meta object for the reference '{@link net.sf.parteg.base.testcasegraph.generated.TCGOCLOperation#getLeft <em>Left</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Left</em>'.
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGOCLOperation#getLeft()
	 * @see #getTCGOCLOperation()
	 * @generated
	 */
	EReference getTCGOCLOperation_Left();

	/**
	 * Returns the meta object for the reference '{@link net.sf.parteg.base.testcasegraph.generated.TCGOCLOperation#getRight <em>Right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Right</em>'.
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGOCLOperation#getRight()
	 * @see #getTCGOCLOperation()
	 * @generated
	 */
	EReference getTCGOCLOperation_Right();

	/**
	 * Returns the meta object for the reference '{@link net.sf.parteg.base.testcasegraph.generated.TCGOCLOperation#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Operation</em>'.
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGOCLOperation#getOperation()
	 * @see #getTCGOCLOperation()
	 * @generated
	 */
	EReference getTCGOCLOperation_Operation();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.parteg.base.testcasegraph.generated.TCGOCLOperation#getOperationName <em>Operation Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operation Name</em>'.
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGOCLOperation#getOperationName()
	 * @see #getTCGOCLOperation()
	 * @generated
	 */
	EAttribute getTCGOCLOperation_OperationName();

	/**
	 * Returns the meta object for class '{@link net.sf.parteg.base.testcasegraph.generated.TCGOCLAtom <em>TCGOCL Atom</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TCGOCL Atom</em>'.
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGOCLAtom
	 * @generated
	 */
	EClass getTCGOCLAtom();

	/**
	 * Returns the meta object for the reference '{@link net.sf.parteg.base.testcasegraph.generated.TCGOCLAtom#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Element</em>'.
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGOCLAtom#getElement()
	 * @see #getTCGOCLAtom()
	 * @generated
	 */
	EReference getTCGOCLAtom_Element();

	/**
	 * Returns the meta object for the reference '{@link net.sf.parteg.base.testcasegraph.generated.TCGOCLAtom#getTcgParameter <em>Tcg Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Tcg Parameter</em>'.
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGOCLAtom#getTcgParameter()
	 * @see #getTCGOCLAtom()
	 * @generated
	 */
	EReference getTCGOCLAtom_TcgParameter();

	/**
	 * Returns the meta object for class '{@link net.sf.parteg.base.testcasegraph.generated.TCGOCLIfThenElse <em>TCGOCL If Then Else</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TCGOCL If Then Else</em>'.
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGOCLIfThenElse
	 * @generated
	 */
	EClass getTCGOCLIfThenElse();

	/**
	 * Returns the meta object for the reference '{@link net.sf.parteg.base.testcasegraph.generated.TCGOCLIfThenElse#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Condition</em>'.
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGOCLIfThenElse#getCondition()
	 * @see #getTCGOCLIfThenElse()
	 * @generated
	 */
	EReference getTCGOCLIfThenElse_Condition();

	/**
	 * Returns the meta object for the reference '{@link net.sf.parteg.base.testcasegraph.generated.TCGOCLIfThenElse#getThenExpression <em>Then Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Then Expression</em>'.
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGOCLIfThenElse#getThenExpression()
	 * @see #getTCGOCLIfThenElse()
	 * @generated
	 */
	EReference getTCGOCLIfThenElse_ThenExpression();

	/**
	 * Returns the meta object for the reference '{@link net.sf.parteg.base.testcasegraph.generated.TCGOCLIfThenElse#getElseExpression <em>Else Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Else Expression</em>'.
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGOCLIfThenElse#getElseExpression()
	 * @see #getTCGOCLIfThenElse()
	 * @generated
	 */
	EReference getTCGOCLIfThenElse_ElseExpression();

	/**
	 * Returns the meta object for class '{@link net.sf.parteg.base.testcasegraph.generated.TCGParameter <em>TCG Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TCG Parameter</em>'.
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGParameter
	 * @generated
	 */
	EClass getTCGParameter();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.parteg.base.testcasegraph.generated.TCGParameter#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGParameter#getName()
	 * @see #getTCGParameter()
	 * @generated
	 */
	EAttribute getTCGParameter_Name();

	/**
	 * Returns the meta object for the reference '{@link net.sf.parteg.base.testcasegraph.generated.TCGParameter#getValueType <em>Value Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Value Type</em>'.
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGParameter#getValueType()
	 * @see #getTCGParameter()
	 * @generated
	 */
	EReference getTCGParameter_ValueType();

	/**
	 * Returns the meta object for the reference '{@link net.sf.parteg.base.testcasegraph.generated.TCGParameter#getReference <em>Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Reference</em>'.
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGParameter#getReference()
	 * @see #getTCGParameter()
	 * @generated
	 */
	EReference getTCGParameter_Reference();

	/**
	 * Returns the meta object for the reference '{@link net.sf.parteg.base.testcasegraph.generated.TCGParameter#getContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Container</em>'.
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGParameter#getContainer()
	 * @see #getTCGParameter()
	 * @generated
	 */
	EReference getTCGParameter_Container();

	/**
	 * Returns the meta object for class '{@link net.sf.parteg.base.testcasegraph.generated.TCGPrimitiveParameter <em>TCG Primitive Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TCG Primitive Parameter</em>'.
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGPrimitiveParameter
	 * @generated
	 */
	EClass getTCGPrimitiveParameter();

	/**
	 * Returns the meta object for the reference '{@link net.sf.parteg.base.testcasegraph.generated.TCGPrimitiveParameter#getValueTypeRange <em>Value Type Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Value Type Range</em>'.
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGPrimitiveParameter#getValueTypeRange()
	 * @see #getTCGPrimitiveParameter()
	 * @generated
	 */
	EReference getTCGPrimitiveParameter_ValueTypeRange();

	/**
	 * Returns the meta object for class '{@link net.sf.parteg.base.testcasegraph.generated.TCGComplexParameter <em>TCG Complex Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TCG Complex Parameter</em>'.
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGComplexParameter
	 * @generated
	 */
	EClass getTCGComplexParameter();

	/**
	 * Returns the meta object for the reference list '{@link net.sf.parteg.base.testcasegraph.generated.TCGComplexParameter#getParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Parameter</em>'.
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGComplexParameter#getParameter()
	 * @see #getTCGComplexParameter()
	 * @generated
	 */
	EReference getTCGComplexParameter_Parameter();

	/**
	 * Returns the meta object for class '{@link net.sf.parteg.base.testcasegraph.generated.TCGElement <em>TCG Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TCG Element</em>'.
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGElement
	 * @generated
	 */
	EClass getTCGElement();

	/**
	 * Returns the meta object for enum '{@link net.sf.parteg.base.testcasegraph.generated.VariableClassification <em>Variable Classification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Variable Classification</em>'.
	 * @see net.sf.parteg.base.testcasegraph.generated.VariableClassification
	 * @generated
	 */
	EEnum getVariableClassification();

	/**
	 * Returns the meta object for enum '{@link net.sf.parteg.base.testcasegraph.generated.TCGNodeType <em>TCG Node Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>TCG Node Type</em>'.
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGNodeType
	 * @generated
	 */
	EEnum getTCGNodeType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	GeneratedFactory getGeneratedFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link net.sf.parteg.base.testcasegraph.generated.impl.TCGNodeImpl <em>TCG Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.sf.parteg.base.testcasegraph.generated.impl.TCGNodeImpl
		 * @see net.sf.parteg.base.testcasegraph.generated.impl.GeneratedPackageImpl#getTCGNode()
		 * @generated
		 */
		EClass TCG_NODE = eINSTANCE.getTCGNode();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TCG_NODE__NAME = eINSTANCE.getTCGNode_Name();

		/**
		 * The meta object literal for the '<em><b>Incoming Transitions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TCG_NODE__INCOMING_TRANSITIONS = eINSTANCE.getTCGNode_IncomingTransitions();

		/**
		 * The meta object literal for the '<em><b>Outgoing Transitions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TCG_NODE__OUTGOING_TRANSITIONS = eINSTANCE.getTCGNode_OutgoingTransitions();

		/**
		 * The meta object literal for the '<em><b>Original Node</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TCG_NODE__ORIGINAL_NODE = eINSTANCE.getTCGNode_OriginalNode();

		/**
		 * The meta object literal for the '<em><b>Use All Transitions In Parallel</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TCG_NODE__USE_ALL_TRANSITIONS_IN_PARALLEL = eINSTANCE.getTCGNode_UseAllTransitionsInParallel();

		/**
		 * The meta object literal for the '<em><b>Referenced Submachine</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TCG_NODE__REFERENCED_SUBMACHINE = eINSTANCE.getTCGNode_ReferencedSubmachine();

		/**
		 * The meta object literal for the '<em><b>Min Distance From Start</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TCG_NODE__MIN_DISTANCE_FROM_START = eINSTANCE.getTCGNode_MinDistanceFromStart();

		/**
		 * The meta object literal for the '<em><b>Max Distance From Start</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TCG_NODE__MAX_DISTANCE_FROM_START = eINSTANCE.getTCGNode_MaxDistanceFromStart();

		/**
		 * The meta object literal for the '{@link net.sf.parteg.base.testcasegraph.generated.impl.TCGRealNodeImpl <em>TCG Real Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.sf.parteg.base.testcasegraph.generated.impl.TCGRealNodeImpl
		 * @see net.sf.parteg.base.testcasegraph.generated.impl.GeneratedPackageImpl#getTCGRealNode()
		 * @generated
		 */
		EClass TCG_REAL_NODE = eINSTANCE.getTCGRealNode();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TCG_REAL_NODE__CONDITION = eINSTANCE.getTCGRealNode_Condition();

		/**
		 * The meta object literal for the '<em><b>Sub Graph</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TCG_REAL_NODE__SUB_GRAPH = eINSTANCE.getTCGRealNode_SubGraph();

		/**
		 * The meta object literal for the '<em><b>Contained Connection Point References</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TCG_REAL_NODE__CONTAINED_CONNECTION_POINT_REFERENCES = eINSTANCE.getTCGRealNode_ContainedConnectionPointReferences();

		/**
		 * The meta object literal for the '<em><b>Contained Connection Points</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TCG_REAL_NODE__CONTAINED_CONNECTION_POINTS = eINSTANCE.getTCGRealNode_ContainedConnectionPoints();

		/**
		 * The meta object literal for the '<em><b>Container</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TCG_REAL_NODE__CONTAINER = eINSTANCE.getTCGRealNode_Container();

		/**
		 * The meta object literal for the '{@link net.sf.parteg.base.testcasegraph.generated.impl.TCGIntermediateNodeImpl <em>TCG Intermediate Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.sf.parteg.base.testcasegraph.generated.impl.TCGIntermediateNodeImpl
		 * @see net.sf.parteg.base.testcasegraph.generated.impl.GeneratedPackageImpl#getTCGIntermediateNode()
		 * @generated
		 */
		EClass TCG_INTERMEDIATE_NODE = eINSTANCE.getTCGIntermediateNode();

		/**
		 * The meta object literal for the '<em><b>Referenced Connection Point References</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TCG_INTERMEDIATE_NODE__REFERENCED_CONNECTION_POINT_REFERENCES = eINSTANCE.getTCGIntermediateNode_ReferencedConnectionPointReferences();

		/**
		 * The meta object literal for the '<em><b>Referenced Connection Points</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TCG_INTERMEDIATE_NODE__REFERENCED_CONNECTION_POINTS = eINSTANCE.getTCGIntermediateNode_ReferencedConnectionPoints();

		/**
		 * The meta object literal for the '<em><b>Container</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TCG_INTERMEDIATE_NODE__CONTAINER = eINSTANCE.getTCGIntermediateNode_Container();

		/**
		 * The meta object literal for the '<em><b>Node Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TCG_INTERMEDIATE_NODE__NODE_TYPE = eINSTANCE.getTCGIntermediateNode_NodeType();

		/**
		 * The meta object literal for the '{@link net.sf.parteg.base.testcasegraph.generated.impl.TestCaseRegionImpl <em>Test Case Region</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.sf.parteg.base.testcasegraph.generated.impl.TestCaseRegionImpl
		 * @see net.sf.parteg.base.testcasegraph.generated.impl.GeneratedPackageImpl#getTestCaseRegion()
		 * @generated
		 */
		EClass TEST_CASE_REGION = eINSTANCE.getTestCaseRegion();

		/**
		 * The meta object literal for the '<em><b>Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST_CASE_REGION__NODES = eINSTANCE.getTestCaseRegion_Nodes();

		/**
		 * The meta object literal for the '<em><b>Transitions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST_CASE_REGION__TRANSITIONS = eINSTANCE.getTestCaseRegion_Transitions();

		/**
		 * The meta object literal for the '<em><b>Container</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST_CASE_REGION__CONTAINER = eINSTANCE.getTestCaseRegion_Container();

		/**
		 * The meta object literal for the '{@link net.sf.parteg.base.testcasegraph.generated.impl.TestCaseGraphImpl <em>Test Case Graph</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.sf.parteg.base.testcasegraph.generated.impl.TestCaseGraphImpl
		 * @see net.sf.parteg.base.testcasegraph.generated.impl.GeneratedPackageImpl#getTestCaseGraph()
		 * @generated
		 */
		EClass TEST_CASE_GRAPH = eINSTANCE.getTestCaseGraph();

		/**
		 * The meta object literal for the '<em><b>Regions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST_CASE_GRAPH__REGIONS = eINSTANCE.getTestCaseGraph_Regions();

		/**
		 * The meta object literal for the '<em><b>Composite Super State</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST_CASE_GRAPH__COMPOSITE_SUPER_STATE = eINSTANCE.getTestCaseGraph_CompositeSuperState();

		/**
		 * The meta object literal for the '<em><b>Contained Connection Points</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST_CASE_GRAPH__CONTAINED_CONNECTION_POINTS = eINSTANCE.getTestCaseGraph_ContainedConnectionPoints();

		/**
		 * The meta object literal for the '<em><b>Submachine States</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST_CASE_GRAPH__SUBMACHINE_STATES = eINSTANCE.getTestCaseGraph_SubmachineStates();

		/**
		 * The meta object literal for the '{@link net.sf.parteg.base.testcasegraph.generated.impl.TCGTransitionImpl <em>TCG Transition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.sf.parteg.base.testcasegraph.generated.impl.TCGTransitionImpl
		 * @see net.sf.parteg.base.testcasegraph.generated.impl.GeneratedPackageImpl#getTCGTransition()
		 * @generated
		 */
		EClass TCG_TRANSITION = eINSTANCE.getTCGTransition();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TCG_TRANSITION__NAME = eINSTANCE.getTCGTransition_Name();

		/**
		 * The meta object literal for the '<em><b>Source Node</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TCG_TRANSITION__SOURCE_NODE = eINSTANCE.getTCGTransition_SourceNode();

		/**
		 * The meta object literal for the '<em><b>Target Node</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TCG_TRANSITION__TARGET_NODE = eINSTANCE.getTCGTransition_TargetNode();

		/**
		 * The meta object literal for the '<em><b>Events</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TCG_TRANSITION__EVENTS = eINSTANCE.getTCGTransition_Events();

		/**
		 * The meta object literal for the '<em><b>Precondition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TCG_TRANSITION__PRECONDITION = eINSTANCE.getTCGTransition_Precondition();

		/**
		 * The meta object literal for the '<em><b>Postcondition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TCG_TRANSITION__POSTCONDITION = eINSTANCE.getTCGTransition_Postcondition();

		/**
		 * The meta object literal for the '<em><b>Container</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TCG_TRANSITION__CONTAINER = eINSTANCE.getTCGTransition_Container();

		/**
		 * The meta object literal for the '<em><b>Can Be Processed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TCG_TRANSITION__CAN_BE_PROCESSED = eINSTANCE.getTCGTransition_CanBeProcessed();

		/**
		 * The meta object literal for the '{@link net.sf.parteg.base.testcasegraph.generated.impl.TCGEquivalenceClassImpl <em>TCG Equivalence Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.sf.parteg.base.testcasegraph.generated.impl.TCGEquivalenceClassImpl
		 * @see net.sf.parteg.base.testcasegraph.generated.impl.GeneratedPackageImpl#getTCGEquivalenceClass()
		 * @generated
		 */
		EClass TCG_EQUIVALENCE_CLASS = eINSTANCE.getTCGEquivalenceClass();

		/**
		 * The meta object literal for the '<em><b>Min Border</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TCG_EQUIVALENCE_CLASS__MIN_BORDER = eINSTANCE.getTCGEquivalenceClass_MinBorder();

		/**
		 * The meta object literal for the '<em><b>Min Included</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TCG_EQUIVALENCE_CLASS__MIN_INCLUDED = eINSTANCE.getTCGEquivalenceClass_MinIncluded();

		/**
		 * The meta object literal for the '<em><b>Max Border</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TCG_EQUIVALENCE_CLASS__MAX_BORDER = eINSTANCE.getTCGEquivalenceClass_MaxBorder();

		/**
		 * The meta object literal for the '<em><b>Max Included</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TCG_EQUIVALENCE_CLASS__MAX_INCLUDED = eINSTANCE.getTCGEquivalenceClass_MaxIncluded();

		/**
		 * The meta object literal for the '{@link net.sf.parteg.base.testcasegraph.generated.impl.TCGEventImpl <em>TCG Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.sf.parteg.base.testcasegraph.generated.impl.TCGEventImpl
		 * @see net.sf.parteg.base.testcasegraph.generated.impl.GeneratedPackageImpl#getTCGEvent()
		 * @generated
		 */
		EClass TCG_EVENT = eINSTANCE.getTCGEvent();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TCG_EVENT__NAME = eINSTANCE.getTCGEvent_Name();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TCG_EVENT__PARAMETERS = eINSTANCE.getTCGEvent_Parameters();

		/**
		 * The meta object literal for the '<em><b>Event</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TCG_EVENT__EVENT = eINSTANCE.getTCGEvent_Event();

		/**
		 * The meta object literal for the '<em><b>Default Event</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TCG_EVENT__DEFAULT_EVENT = eINSTANCE.getTCGEvent_DefaultEvent();

		/**
		 * The meta object literal for the '{@link net.sf.parteg.base.testcasegraph.generated.impl.TCGOCLExpressionImpl <em>TCGOCL Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.sf.parteg.base.testcasegraph.generated.impl.TCGOCLExpressionImpl
		 * @see net.sf.parteg.base.testcasegraph.generated.impl.GeneratedPackageImpl#getTCGOCLExpression()
		 * @generated
		 */
		EClass TCGOCL_EXPRESSION = eINSTANCE.getTCGOCLExpression();

		/**
		 * The meta object literal for the '<em><b>Classification</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TCGOCL_EXPRESSION__CLASSIFICATION = eINSTANCE.getTCGOCLExpression_Classification();

		/**
		 * The meta object literal for the '<em><b>Ocl Reference</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TCGOCL_EXPRESSION__OCL_REFERENCE = eINSTANCE.getTCGOCLExpression_OclReference();

		/**
		 * The meta object literal for the '<em><b>Container</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TCGOCL_EXPRESSION__CONTAINER = eINSTANCE.getTCGOCLExpression_Container();

		/**
		 * The meta object literal for the '<em><b>Positive Assignment Of Original</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TCGOCL_EXPRESSION__POSITIVE_ASSIGNMENT_OF_ORIGINAL = eINSTANCE.getTCGOCLExpression_PositiveAssignmentOfOriginal();

		/**
		 * The meta object literal for the '<em><b>Transition Context</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TCGOCL_EXPRESSION__TRANSITION_CONTEXT = eINSTANCE.getTCGOCLExpression_TransitionContext();

		/**
		 * The meta object literal for the '{@link net.sf.parteg.base.testcasegraph.generated.impl.TCGConjunctionImpl <em>TCG Conjunction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.sf.parteg.base.testcasegraph.generated.impl.TCGConjunctionImpl
		 * @see net.sf.parteg.base.testcasegraph.generated.impl.GeneratedPackageImpl#getTCGConjunction()
		 * @generated
		 */
		EClass TCG_CONJUNCTION = eINSTANCE.getTCGConjunction();

		/**
		 * The meta object literal for the '<em><b>Expressions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TCG_CONJUNCTION__EXPRESSIONS = eINSTANCE.getTCGConjunction_Expressions();

		/**
		 * The meta object literal for the '<em><b>Can Change Value If One Expression Changes</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TCG_CONJUNCTION__CAN_CHANGE_VALUE_IF_ONE_EXPRESSION_CHANGES = eINSTANCE.getTCGConjunction_CanChangeValueIfOneExpressionChanges();

		/**
		 * The meta object literal for the '<em><b>Positive Sub Expression Of Original</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TCG_CONJUNCTION__POSITIVE_SUB_EXPRESSION_OF_ORIGINAL = eINSTANCE.getTCGConjunction_PositiveSubExpressionOfOriginal();

		/**
		 * The meta object literal for the '{@link net.sf.parteg.base.testcasegraph.generated.impl.TCGDisjunctiveNormalFormImpl <em>TCG Disjunctive Normal Form</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.sf.parteg.base.testcasegraph.generated.impl.TCGDisjunctiveNormalFormImpl
		 * @see net.sf.parteg.base.testcasegraph.generated.impl.GeneratedPackageImpl#getTCGDisjunctiveNormalForm()
		 * @generated
		 */
		EClass TCG_DISJUNCTIVE_NORMAL_FORM = eINSTANCE.getTCGDisjunctiveNormalForm();

		/**
		 * The meta object literal for the '<em><b>Conjunctions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TCG_DISJUNCTIVE_NORMAL_FORM__CONJUNCTIONS = eINSTANCE.getTCGDisjunctiveNormalForm_Conjunctions();

		/**
		 * The meta object literal for the '<em><b>Original Expression</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TCG_DISJUNCTIVE_NORMAL_FORM__ORIGINAL_EXPRESSION = eINSTANCE.getTCGDisjunctiveNormalForm_OriginalExpression();

		/**
		 * The meta object literal for the '<em><b>Use For Test Goals</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TCG_DISJUNCTIVE_NORMAL_FORM__USE_FOR_TEST_GOALS = eINSTANCE.getTCGDisjunctiveNormalForm_UseForTestGoals();

		/**
		 * The meta object literal for the '{@link net.sf.parteg.base.testcasegraph.generated.impl.TCGOCLOperationImpl <em>TCGOCL Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.sf.parteg.base.testcasegraph.generated.impl.TCGOCLOperationImpl
		 * @see net.sf.parteg.base.testcasegraph.generated.impl.GeneratedPackageImpl#getTCGOCLOperation()
		 * @generated
		 */
		EClass TCGOCL_OPERATION = eINSTANCE.getTCGOCLOperation();

		/**
		 * The meta object literal for the '<em><b>Left</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TCGOCL_OPERATION__LEFT = eINSTANCE.getTCGOCLOperation_Left();

		/**
		 * The meta object literal for the '<em><b>Right</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TCGOCL_OPERATION__RIGHT = eINSTANCE.getTCGOCLOperation_Right();

		/**
		 * The meta object literal for the '<em><b>Operation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TCGOCL_OPERATION__OPERATION = eINSTANCE.getTCGOCLOperation_Operation();

		/**
		 * The meta object literal for the '<em><b>Operation Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TCGOCL_OPERATION__OPERATION_NAME = eINSTANCE.getTCGOCLOperation_OperationName();

		/**
		 * The meta object literal for the '{@link net.sf.parteg.base.testcasegraph.generated.impl.TCGOCLAtomImpl <em>TCGOCL Atom</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.sf.parteg.base.testcasegraph.generated.impl.TCGOCLAtomImpl
		 * @see net.sf.parteg.base.testcasegraph.generated.impl.GeneratedPackageImpl#getTCGOCLAtom()
		 * @generated
		 */
		EClass TCGOCL_ATOM = eINSTANCE.getTCGOCLAtom();

		/**
		 * The meta object literal for the '<em><b>Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TCGOCL_ATOM__ELEMENT = eINSTANCE.getTCGOCLAtom_Element();

		/**
		 * The meta object literal for the '<em><b>Tcg Parameter</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TCGOCL_ATOM__TCG_PARAMETER = eINSTANCE.getTCGOCLAtom_TcgParameter();

		/**
		 * The meta object literal for the '{@link net.sf.parteg.base.testcasegraph.generated.impl.TCGOCLIfThenElseImpl <em>TCGOCL If Then Else</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.sf.parteg.base.testcasegraph.generated.impl.TCGOCLIfThenElseImpl
		 * @see net.sf.parteg.base.testcasegraph.generated.impl.GeneratedPackageImpl#getTCGOCLIfThenElse()
		 * @generated
		 */
		EClass TCGOCL_IF_THEN_ELSE = eINSTANCE.getTCGOCLIfThenElse();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TCGOCL_IF_THEN_ELSE__CONDITION = eINSTANCE.getTCGOCLIfThenElse_Condition();

		/**
		 * The meta object literal for the '<em><b>Then Expression</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TCGOCL_IF_THEN_ELSE__THEN_EXPRESSION = eINSTANCE.getTCGOCLIfThenElse_ThenExpression();

		/**
		 * The meta object literal for the '<em><b>Else Expression</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TCGOCL_IF_THEN_ELSE__ELSE_EXPRESSION = eINSTANCE.getTCGOCLIfThenElse_ElseExpression();

		/**
		 * The meta object literal for the '{@link net.sf.parteg.base.testcasegraph.generated.TCGParameter <em>TCG Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.sf.parteg.base.testcasegraph.generated.TCGParameter
		 * @see net.sf.parteg.base.testcasegraph.generated.impl.GeneratedPackageImpl#getTCGParameter()
		 * @generated
		 */
		EClass TCG_PARAMETER = eINSTANCE.getTCGParameter();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TCG_PARAMETER__NAME = eINSTANCE.getTCGParameter_Name();

		/**
		 * The meta object literal for the '<em><b>Value Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TCG_PARAMETER__VALUE_TYPE = eINSTANCE.getTCGParameter_ValueType();

		/**
		 * The meta object literal for the '<em><b>Reference</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TCG_PARAMETER__REFERENCE = eINSTANCE.getTCGParameter_Reference();

		/**
		 * The meta object literal for the '<em><b>Container</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TCG_PARAMETER__CONTAINER = eINSTANCE.getTCGParameter_Container();

		/**
		 * The meta object literal for the '{@link net.sf.parteg.base.testcasegraph.generated.impl.TCGPrimitiveParameterImpl <em>TCG Primitive Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.sf.parteg.base.testcasegraph.generated.impl.TCGPrimitiveParameterImpl
		 * @see net.sf.parteg.base.testcasegraph.generated.impl.GeneratedPackageImpl#getTCGPrimitiveParameter()
		 * @generated
		 */
		EClass TCG_PRIMITIVE_PARAMETER = eINSTANCE.getTCGPrimitiveParameter();

		/**
		 * The meta object literal for the '<em><b>Value Type Range</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TCG_PRIMITIVE_PARAMETER__VALUE_TYPE_RANGE = eINSTANCE.getTCGPrimitiveParameter_ValueTypeRange();

		/**
		 * The meta object literal for the '{@link net.sf.parteg.base.testcasegraph.generated.impl.TCGComplexParameterImpl <em>TCG Complex Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.sf.parteg.base.testcasegraph.generated.impl.TCGComplexParameterImpl
		 * @see net.sf.parteg.base.testcasegraph.generated.impl.GeneratedPackageImpl#getTCGComplexParameter()
		 * @generated
		 */
		EClass TCG_COMPLEX_PARAMETER = eINSTANCE.getTCGComplexParameter();

		/**
		 * The meta object literal for the '<em><b>Parameter</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TCG_COMPLEX_PARAMETER__PARAMETER = eINSTANCE.getTCGComplexParameter_Parameter();

		/**
		 * The meta object literal for the '{@link net.sf.parteg.base.testcasegraph.generated.impl.TCGElementImpl <em>TCG Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.sf.parteg.base.testcasegraph.generated.impl.TCGElementImpl
		 * @see net.sf.parteg.base.testcasegraph.generated.impl.GeneratedPackageImpl#getTCGElement()
		 * @generated
		 */
		EClass TCG_ELEMENT = eINSTANCE.getTCGElement();

		/**
		 * The meta object literal for the '{@link net.sf.parteg.base.testcasegraph.generated.VariableClassification <em>Variable Classification</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.sf.parteg.base.testcasegraph.generated.VariableClassification
		 * @see net.sf.parteg.base.testcasegraph.generated.impl.GeneratedPackageImpl#getVariableClassification()
		 * @generated
		 */
		EEnum VARIABLE_CLASSIFICATION = eINSTANCE.getVariableClassification();

		/**
		 * The meta object literal for the '{@link net.sf.parteg.base.testcasegraph.generated.TCGNodeType <em>TCG Node Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.sf.parteg.base.testcasegraph.generated.TCGNodeType
		 * @see net.sf.parteg.base.testcasegraph.generated.impl.GeneratedPackageImpl#getTCGNodeType()
		 * @generated
		 */
		EEnum TCG_NODE_TYPE = eINSTANCE.getTCGNodeType();

	}

} //GeneratedPackage
