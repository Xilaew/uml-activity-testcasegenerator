/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.sf.parteg.base.testcasetree.generated;

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
 * @see net.sf.parteg.base.testcasetree.generated.GeneratedFactory
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
	String eNS_URI = "http://net.sf.parteg.base.testcasetree.generated";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "net.sf.parteg.base.testcasetree.generated";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GeneratedPackage eINSTANCE = net.sf.parteg.base.testcasetree.generated.impl.GeneratedPackageImpl.init();

	/**
	 * The meta object id for the '{@link net.sf.parteg.base.testcasetree.generated.impl.TCGElementImpl <em>TCG Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.sf.parteg.base.testcasetree.generated.impl.TCGElementImpl
	 * @see net.sf.parteg.base.testcasetree.generated.impl.GeneratedPackageImpl#getTCGElement()
	 * @generated
	 */
	int TCG_ELEMENT = 14;

	/**
	 * The number of structural features of the '<em>TCG Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_ELEMENT_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link net.sf.parteg.base.testcasetree.generated.impl.TCGNodeImpl <em>TCG Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.sf.parteg.base.testcasetree.generated.impl.TCGNodeImpl
	 * @see net.sf.parteg.base.testcasetree.generated.impl.GeneratedPackageImpl#getTCGNode()
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
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_NODE__CONDITION = TCG_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Incoming Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_NODE__INCOMING_TRANSITIONS = TCG_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Outgoing Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_NODE__OUTGOING_TRANSITIONS = TCG_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_NODE__PARAMETERS = TCG_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Distance To Root</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_NODE__DISTANCE_TO_ROOT = TCG_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Corresponds Negative Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_NODE__CORRESPONDS_NEGATIVE_EXPRESSION = TCG_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Original Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_NODE__ORIGINAL_EXPRESSION = TCG_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Invariant</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_NODE__INVARIANT = TCG_ELEMENT_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Origonal Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_NODE__ORIGONAL_NODE = TCG_ELEMENT_FEATURE_COUNT + 9;

	/**
	 * The number of structural features of the '<em>TCG Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_NODE_FEATURE_COUNT = TCG_ELEMENT_FEATURE_COUNT + 10;

	/**
	 * The meta object id for the '{@link net.sf.parteg.base.testcasetree.generated.impl.TestCaseGraphImpl <em>Test Case Graph</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.sf.parteg.base.testcasetree.generated.impl.TestCaseGraphImpl
	 * @see net.sf.parteg.base.testcasetree.generated.impl.GeneratedPackageImpl#getTestCaseGraph()
	 * @generated
	 */
	int TEST_CASE_GRAPH = 1;

	/**
	 * The feature id for the '<em><b>Root</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_CASE_GRAPH__ROOT = 0;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_CASE_GRAPH__NODES = 1;

	/**
	 * The feature id for the '<em><b>Transitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_CASE_GRAPH__TRANSITIONS = 2;

	/**
	 * The feature id for the '<em><b>Conditions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_CASE_GRAPH__CONDITIONS = 3;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_CASE_GRAPH__ATTRIBUTES = 4;

	/**
	 * The number of structural features of the '<em>Test Case Graph</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_CASE_GRAPH_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link net.sf.parteg.base.testcasetree.generated.impl.TCGTransitionImpl <em>TCG Transition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.sf.parteg.base.testcasetree.generated.impl.TCGTransitionImpl
	 * @see net.sf.parteg.base.testcasetree.generated.impl.GeneratedPackageImpl#getTCGTransition()
	 * @generated
	 */
	int TCG_TRANSITION = 2;

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
	 * The feature id for the '<em><b>Event</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_TRANSITION__EVENT = TCG_ELEMENT_FEATURE_COUNT + 3;

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
	 * The number of structural features of the '<em>TCG Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_TRANSITION_FEATURE_COUNT = TCG_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link net.sf.parteg.base.testcasetree.generated.impl.TCGEquivalenceClassImpl <em>TCG Equivalence Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.sf.parteg.base.testcasetree.generated.impl.TCGEquivalenceClassImpl
	 * @see net.sf.parteg.base.testcasetree.generated.impl.GeneratedPackageImpl#getTCGEquivalenceClass()
	 * @generated
	 */
	int TCG_EQUIVALENCE_CLASS = 3;

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
	 * The meta object id for the '{@link net.sf.parteg.base.testcasetree.generated.impl.TCGEventImpl <em>TCG Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.sf.parteg.base.testcasetree.generated.impl.TCGEventImpl
	 * @see net.sf.parteg.base.testcasetree.generated.impl.GeneratedPackageImpl#getTCGEvent()
	 * @generated
	 */
	int TCG_EVENT = 4;

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
	 * The meta object id for the '{@link net.sf.parteg.base.testcasetree.generated.impl.TCGOCLExpressionImpl <em>TCGOCL Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.sf.parteg.base.testcasetree.generated.impl.TCGOCLExpressionImpl
	 * @see net.sf.parteg.base.testcasetree.generated.impl.GeneratedPackageImpl#getTCGOCLExpression()
	 * @generated
	 */
	int TCGOCL_EXPRESSION = 5;

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
	 * The number of structural features of the '<em>TCGOCL Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCGOCL_EXPRESSION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link net.sf.parteg.base.testcasetree.generated.impl.TCGConjunctionImpl <em>TCG Conjunction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.sf.parteg.base.testcasetree.generated.impl.TCGConjunctionImpl
	 * @see net.sf.parteg.base.testcasetree.generated.impl.GeneratedPackageImpl#getTCGConjunction()
	 * @generated
	 */
	int TCG_CONJUNCTION = 6;

	/**
	 * The feature id for the '<em><b>Expressions</b></em>' containment reference list.
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
	 * The meta object id for the '{@link net.sf.parteg.base.testcasetree.generated.impl.TCGDisjunctiveNormalFormImpl <em>TCG Disjunctive Normal Form</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.sf.parteg.base.testcasetree.generated.impl.TCGDisjunctiveNormalFormImpl
	 * @see net.sf.parteg.base.testcasetree.generated.impl.GeneratedPackageImpl#getTCGDisjunctiveNormalForm()
	 * @generated
	 */
	int TCG_DISJUNCTIVE_NORMAL_FORM = 7;

	/**
	 * The feature id for the '<em><b>Conjunctions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_DISJUNCTIVE_NORMAL_FORM__CONJUNCTIONS = 0;

	/**
	 * The number of structural features of the '<em>TCG Disjunctive Normal Form</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_DISJUNCTIVE_NORMAL_FORM_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link net.sf.parteg.base.testcasetree.generated.impl.TCGOCLOperationImpl <em>TCGOCL Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.sf.parteg.base.testcasetree.generated.impl.TCGOCLOperationImpl
	 * @see net.sf.parteg.base.testcasetree.generated.impl.GeneratedPackageImpl#getTCGOCLOperation()
	 * @generated
	 */
	int TCGOCL_OPERATION = 8;

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
	 * The meta object id for the '{@link net.sf.parteg.base.testcasetree.generated.impl.TCGOCLAtomImpl <em>TCGOCL Atom</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.sf.parteg.base.testcasetree.generated.impl.TCGOCLAtomImpl
	 * @see net.sf.parteg.base.testcasetree.generated.impl.GeneratedPackageImpl#getTCGOCLAtom()
	 * @generated
	 */
	int TCGOCL_ATOM = 9;

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
	 * The meta object id for the '{@link net.sf.parteg.base.testcasetree.generated.impl.TCGOCLIfThenElseImpl <em>TCGOCL If Then Else</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.sf.parteg.base.testcasetree.generated.impl.TCGOCLIfThenElseImpl
	 * @see net.sf.parteg.base.testcasetree.generated.impl.GeneratedPackageImpl#getTCGOCLIfThenElse()
	 * @generated
	 */
	int TCGOCL_IF_THEN_ELSE = 10;

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
	 * The meta object id for the '{@link net.sf.parteg.base.testcasetree.generated.TCGParameter <em>TCG Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.sf.parteg.base.testcasetree.generated.TCGParameter
	 * @see net.sf.parteg.base.testcasetree.generated.impl.GeneratedPackageImpl#getTCGParameter()
	 * @generated
	 */
	int TCG_PARAMETER = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_PARAMETER__NAME = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_PARAMETER__TYPE = 1;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_PARAMETER__REFERENCE = 2;

	/**
	 * The feature id for the '<em><b>Defining Transition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_PARAMETER__DEFINING_TRANSITION = 3;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_PARAMETER__CONTAINER = 4;

	/**
	 * The number of structural features of the '<em>TCG Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_PARAMETER_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link net.sf.parteg.base.testcasetree.generated.impl.TCGPrimitiveParameterImpl <em>TCG Primitive Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.sf.parteg.base.testcasetree.generated.impl.TCGPrimitiveParameterImpl
	 * @see net.sf.parteg.base.testcasetree.generated.impl.GeneratedPackageImpl#getTCGPrimitiveParameter()
	 * @generated
	 */
	int TCG_PRIMITIVE_PARAMETER = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_PRIMITIVE_PARAMETER__NAME = TCG_PARAMETER__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_PRIMITIVE_PARAMETER__TYPE = TCG_PARAMETER__TYPE;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_PRIMITIVE_PARAMETER__REFERENCE = TCG_PARAMETER__REFERENCE;

	/**
	 * The feature id for the '<em><b>Defining Transition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_PRIMITIVE_PARAMETER__DEFINING_TRANSITION = TCG_PARAMETER__DEFINING_TRANSITION;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_PRIMITIVE_PARAMETER__CONTAINER = TCG_PARAMETER__CONTAINER;

	/**
	 * The feature id for the '<em><b>Equivalence Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_PRIMITIVE_PARAMETER__EQUIVALENCE_CLASS = TCG_PARAMETER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>TCG Primitive Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_PRIMITIVE_PARAMETER_FEATURE_COUNT = TCG_PARAMETER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link net.sf.parteg.base.testcasetree.generated.impl.TCGComplexParameterImpl <em>TCG Complex Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.sf.parteg.base.testcasetree.generated.impl.TCGComplexParameterImpl
	 * @see net.sf.parteg.base.testcasetree.generated.impl.GeneratedPackageImpl#getTCGComplexParameter()
	 * @generated
	 */
	int TCG_COMPLEX_PARAMETER = 13;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_COMPLEX_PARAMETER__NAME = TCG_PARAMETER__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_COMPLEX_PARAMETER__TYPE = TCG_PARAMETER__TYPE;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_COMPLEX_PARAMETER__REFERENCE = TCG_PARAMETER__REFERENCE;

	/**
	 * The feature id for the '<em><b>Defining Transition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_COMPLEX_PARAMETER__DEFINING_TRANSITION = TCG_PARAMETER__DEFINING_TRANSITION;

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
	 * The meta object id for the '{@link net.sf.parteg.base.testcasetree.generated.VariableClassification <em>Variable Classification</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.sf.parteg.base.testcasetree.generated.VariableClassification
	 * @see net.sf.parteg.base.testcasetree.generated.impl.GeneratedPackageImpl#getVariableClassification()
	 * @generated
	 */
	int VARIABLE_CLASSIFICATION = 15;


	/**
	 * Returns the meta object for class '{@link net.sf.parteg.base.testcasetree.generated.TCGNode <em>TCG Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TCG Node</em>'.
	 * @see net.sf.parteg.base.testcasetree.generated.TCGNode
	 * @generated
	 */
	EClass getTCGNode();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.parteg.base.testcasetree.generated.TCGNode#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see net.sf.parteg.base.testcasetree.generated.TCGNode#getName()
	 * @see #getTCGNode()
	 * @generated
	 */
	EAttribute getTCGNode_Name();

	/**
	 * Returns the meta object for the containment reference '{@link net.sf.parteg.base.testcasetree.generated.TCGNode#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see net.sf.parteg.base.testcasetree.generated.TCGNode#getCondition()
	 * @see #getTCGNode()
	 * @generated
	 */
	EReference getTCGNode_Condition();

	/**
	 * Returns the meta object for the reference list '{@link net.sf.parteg.base.testcasetree.generated.TCGNode#getIncomingTransitions <em>Incoming Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Incoming Transitions</em>'.
	 * @see net.sf.parteg.base.testcasetree.generated.TCGNode#getIncomingTransitions()
	 * @see #getTCGNode()
	 * @generated
	 */
	EReference getTCGNode_IncomingTransitions();

	/**
	 * Returns the meta object for the reference list '{@link net.sf.parteg.base.testcasetree.generated.TCGNode#getOutgoingTransitions <em>Outgoing Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outgoing Transitions</em>'.
	 * @see net.sf.parteg.base.testcasetree.generated.TCGNode#getOutgoingTransitions()
	 * @see #getTCGNode()
	 * @generated
	 */
	EReference getTCGNode_OutgoingTransitions();

	/**
	 * Returns the meta object for the containment reference list '{@link net.sf.parteg.base.testcasetree.generated.TCGNode#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see net.sf.parteg.base.testcasetree.generated.TCGNode#getParameters()
	 * @see #getTCGNode()
	 * @generated
	 */
	EReference getTCGNode_Parameters();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.parteg.base.testcasetree.generated.TCGNode#getDistanceToRoot <em>Distance To Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Distance To Root</em>'.
	 * @see net.sf.parteg.base.testcasetree.generated.TCGNode#getDistanceToRoot()
	 * @see #getTCGNode()
	 * @generated
	 */
	EAttribute getTCGNode_DistanceToRoot();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.parteg.base.testcasetree.generated.TCGNode#isCorrespondsNegativeExpression <em>Corresponds Negative Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Corresponds Negative Expression</em>'.
	 * @see net.sf.parteg.base.testcasetree.generated.TCGNode#isCorrespondsNegativeExpression()
	 * @see #getTCGNode()
	 * @generated
	 */
	EAttribute getTCGNode_CorrespondsNegativeExpression();

	/**
	 * Returns the meta object for the reference '{@link net.sf.parteg.base.testcasetree.generated.TCGNode#getOriginalExpression <em>Original Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Original Expression</em>'.
	 * @see net.sf.parteg.base.testcasetree.generated.TCGNode#getOriginalExpression()
	 * @see #getTCGNode()
	 * @generated
	 */
	EReference getTCGNode_OriginalExpression();

	/**
	 * Returns the meta object for the reference '{@link net.sf.parteg.base.testcasetree.generated.TCGNode#getInvariant <em>Invariant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Invariant</em>'.
	 * @see net.sf.parteg.base.testcasetree.generated.TCGNode#getInvariant()
	 * @see #getTCGNode()
	 * @generated
	 */
	EReference getTCGNode_Invariant();

	/**
	 * Returns the meta object for the reference '{@link net.sf.parteg.base.testcasetree.generated.TCGNode#getOrigonalNode <em>Origonal Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Origonal Node</em>'.
	 * @see net.sf.parteg.base.testcasetree.generated.TCGNode#getOrigonalNode()
	 * @see #getTCGNode()
	 * @generated
	 */
	EReference getTCGNode_OrigonalNode();

	/**
	 * Returns the meta object for class '{@link net.sf.parteg.base.testcasetree.generated.TestCaseGraph <em>Test Case Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Test Case Graph</em>'.
	 * @see net.sf.parteg.base.testcasetree.generated.TestCaseGraph
	 * @generated
	 */
	EClass getTestCaseGraph();

	/**
	 * Returns the meta object for the reference '{@link net.sf.parteg.base.testcasetree.generated.TestCaseGraph#getRoot <em>Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Root</em>'.
	 * @see net.sf.parteg.base.testcasetree.generated.TestCaseGraph#getRoot()
	 * @see #getTestCaseGraph()
	 * @generated
	 */
	EReference getTestCaseGraph_Root();

	/**
	 * Returns the meta object for the containment reference list '{@link net.sf.parteg.base.testcasetree.generated.TestCaseGraph#getNodes <em>Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Nodes</em>'.
	 * @see net.sf.parteg.base.testcasetree.generated.TestCaseGraph#getNodes()
	 * @see #getTestCaseGraph()
	 * @generated
	 */
	EReference getTestCaseGraph_Nodes();

	/**
	 * Returns the meta object for the containment reference list '{@link net.sf.parteg.base.testcasetree.generated.TestCaseGraph#getTransitions <em>Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Transitions</em>'.
	 * @see net.sf.parteg.base.testcasetree.generated.TestCaseGraph#getTransitions()
	 * @see #getTestCaseGraph()
	 * @generated
	 */
	EReference getTestCaseGraph_Transitions();

	/**
	 * Returns the meta object for the reference list '{@link net.sf.parteg.base.testcasetree.generated.TestCaseGraph#getConditions <em>Conditions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Conditions</em>'.
	 * @see net.sf.parteg.base.testcasetree.generated.TestCaseGraph#getConditions()
	 * @see #getTestCaseGraph()
	 * @generated
	 */
	EReference getTestCaseGraph_Conditions();

	/**
	 * Returns the meta object for the containment reference list '{@link net.sf.parteg.base.testcasetree.generated.TestCaseGraph#getAttributes <em>Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Attributes</em>'.
	 * @see net.sf.parteg.base.testcasetree.generated.TestCaseGraph#getAttributes()
	 * @see #getTestCaseGraph()
	 * @generated
	 */
	EReference getTestCaseGraph_Attributes();

	/**
	 * Returns the meta object for class '{@link net.sf.parteg.base.testcasetree.generated.TCGTransition <em>TCG Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TCG Transition</em>'.
	 * @see net.sf.parteg.base.testcasetree.generated.TCGTransition
	 * @generated
	 */
	EClass getTCGTransition();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.parteg.base.testcasetree.generated.TCGTransition#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see net.sf.parteg.base.testcasetree.generated.TCGTransition#getName()
	 * @see #getTCGTransition()
	 * @generated
	 */
	EAttribute getTCGTransition_Name();

	/**
	 * Returns the meta object for the reference '{@link net.sf.parteg.base.testcasetree.generated.TCGTransition#getSourceNode <em>Source Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source Node</em>'.
	 * @see net.sf.parteg.base.testcasetree.generated.TCGTransition#getSourceNode()
	 * @see #getTCGTransition()
	 * @generated
	 */
	EReference getTCGTransition_SourceNode();

	/**
	 * Returns the meta object for the reference '{@link net.sf.parteg.base.testcasetree.generated.TCGTransition#getTargetNode <em>Target Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Node</em>'.
	 * @see net.sf.parteg.base.testcasetree.generated.TCGTransition#getTargetNode()
	 * @see #getTCGTransition()
	 * @generated
	 */
	EReference getTCGTransition_TargetNode();

	/**
	 * Returns the meta object for the containment reference '{@link net.sf.parteg.base.testcasetree.generated.TCGTransition#getEvent <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Event</em>'.
	 * @see net.sf.parteg.base.testcasetree.generated.TCGTransition#getEvent()
	 * @see #getTCGTransition()
	 * @generated
	 */
	EReference getTCGTransition_Event();

	/**
	 * Returns the meta object for the containment reference '{@link net.sf.parteg.base.testcasetree.generated.TCGTransition#getPrecondition <em>Precondition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Precondition</em>'.
	 * @see net.sf.parteg.base.testcasetree.generated.TCGTransition#getPrecondition()
	 * @see #getTCGTransition()
	 * @generated
	 */
	EReference getTCGTransition_Precondition();

	/**
	 * Returns the meta object for the containment reference '{@link net.sf.parteg.base.testcasetree.generated.TCGTransition#getPostcondition <em>Postcondition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Postcondition</em>'.
	 * @see net.sf.parteg.base.testcasetree.generated.TCGTransition#getPostcondition()
	 * @see #getTCGTransition()
	 * @generated
	 */
	EReference getTCGTransition_Postcondition();

	/**
	 * Returns the meta object for class '{@link net.sf.parteg.base.testcasetree.generated.TCGEquivalenceClass <em>TCG Equivalence Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TCG Equivalence Class</em>'.
	 * @see net.sf.parteg.base.testcasetree.generated.TCGEquivalenceClass
	 * @generated
	 */
	EClass getTCGEquivalenceClass();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.parteg.base.testcasetree.generated.TCGEquivalenceClass#getMinBorder <em>Min Border</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min Border</em>'.
	 * @see net.sf.parteg.base.testcasetree.generated.TCGEquivalenceClass#getMinBorder()
	 * @see #getTCGEquivalenceClass()
	 * @generated
	 */
	EAttribute getTCGEquivalenceClass_MinBorder();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.parteg.base.testcasetree.generated.TCGEquivalenceClass#getMinIncluded <em>Min Included</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min Included</em>'.
	 * @see net.sf.parteg.base.testcasetree.generated.TCGEquivalenceClass#getMinIncluded()
	 * @see #getTCGEquivalenceClass()
	 * @generated
	 */
	EAttribute getTCGEquivalenceClass_MinIncluded();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.parteg.base.testcasetree.generated.TCGEquivalenceClass#getMaxBorder <em>Max Border</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Border</em>'.
	 * @see net.sf.parteg.base.testcasetree.generated.TCGEquivalenceClass#getMaxBorder()
	 * @see #getTCGEquivalenceClass()
	 * @generated
	 */
	EAttribute getTCGEquivalenceClass_MaxBorder();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.parteg.base.testcasetree.generated.TCGEquivalenceClass#getMaxIncluded <em>Max Included</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Included</em>'.
	 * @see net.sf.parteg.base.testcasetree.generated.TCGEquivalenceClass#getMaxIncluded()
	 * @see #getTCGEquivalenceClass()
	 * @generated
	 */
	EAttribute getTCGEquivalenceClass_MaxIncluded();

	/**
	 * Returns the meta object for class '{@link net.sf.parteg.base.testcasetree.generated.TCGEvent <em>TCG Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TCG Event</em>'.
	 * @see net.sf.parteg.base.testcasetree.generated.TCGEvent
	 * @generated
	 */
	EClass getTCGEvent();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.parteg.base.testcasetree.generated.TCGEvent#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see net.sf.parteg.base.testcasetree.generated.TCGEvent#getName()
	 * @see #getTCGEvent()
	 * @generated
	 */
	EAttribute getTCGEvent_Name();

	/**
	 * Returns the meta object for the reference list '{@link net.sf.parteg.base.testcasetree.generated.TCGEvent#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Parameters</em>'.
	 * @see net.sf.parteg.base.testcasetree.generated.TCGEvent#getParameters()
	 * @see #getTCGEvent()
	 * @generated
	 */
	EReference getTCGEvent_Parameters();

	/**
	 * Returns the meta object for the reference '{@link net.sf.parteg.base.testcasetree.generated.TCGEvent#getEvent <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Event</em>'.
	 * @see net.sf.parteg.base.testcasetree.generated.TCGEvent#getEvent()
	 * @see #getTCGEvent()
	 * @generated
	 */
	EReference getTCGEvent_Event();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.parteg.base.testcasetree.generated.TCGEvent#isDefaultEvent <em>Default Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default Event</em>'.
	 * @see net.sf.parteg.base.testcasetree.generated.TCGEvent#isDefaultEvent()
	 * @see #getTCGEvent()
	 * @generated
	 */
	EAttribute getTCGEvent_DefaultEvent();

	/**
	 * Returns the meta object for class '{@link net.sf.parteg.base.testcasetree.generated.TCGOCLExpression <em>TCGOCL Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TCGOCL Expression</em>'.
	 * @see net.sf.parteg.base.testcasetree.generated.TCGOCLExpression
	 * @generated
	 */
	EClass getTCGOCLExpression();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.parteg.base.testcasetree.generated.TCGOCLExpression#getClassification <em>Classification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Classification</em>'.
	 * @see net.sf.parteg.base.testcasetree.generated.TCGOCLExpression#getClassification()
	 * @see #getTCGOCLExpression()
	 * @generated
	 */
	EAttribute getTCGOCLExpression_Classification();

	/**
	 * Returns the meta object for the reference '{@link net.sf.parteg.base.testcasetree.generated.TCGOCLExpression#getOclReference <em>Ocl Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ocl Reference</em>'.
	 * @see net.sf.parteg.base.testcasetree.generated.TCGOCLExpression#getOclReference()
	 * @see #getTCGOCLExpression()
	 * @generated
	 */
	EReference getTCGOCLExpression_OclReference();

	/**
	 * Returns the meta object for class '{@link net.sf.parteg.base.testcasetree.generated.TCGConjunction <em>TCG Conjunction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TCG Conjunction</em>'.
	 * @see net.sf.parteg.base.testcasetree.generated.TCGConjunction
	 * @generated
	 */
	EClass getTCGConjunction();

	/**
	 * Returns the meta object for the containment reference list '{@link net.sf.parteg.base.testcasetree.generated.TCGConjunction#getExpressions <em>Expressions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Expressions</em>'.
	 * @see net.sf.parteg.base.testcasetree.generated.TCGConjunction#getExpressions()
	 * @see #getTCGConjunction()
	 * @generated
	 */
	EReference getTCGConjunction_Expressions();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.parteg.base.testcasetree.generated.TCGConjunction#isCanChangeValueIfOneExpressionChanges <em>Can Change Value If One Expression Changes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Can Change Value If One Expression Changes</em>'.
	 * @see net.sf.parteg.base.testcasetree.generated.TCGConjunction#isCanChangeValueIfOneExpressionChanges()
	 * @see #getTCGConjunction()
	 * @generated
	 */
	EAttribute getTCGConjunction_CanChangeValueIfOneExpressionChanges();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.parteg.base.testcasetree.generated.TCGConjunction#isPositiveSubExpressionOfOriginal <em>Positive Sub Expression Of Original</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Positive Sub Expression Of Original</em>'.
	 * @see net.sf.parteg.base.testcasetree.generated.TCGConjunction#isPositiveSubExpressionOfOriginal()
	 * @see #getTCGConjunction()
	 * @generated
	 */
	EAttribute getTCGConjunction_PositiveSubExpressionOfOriginal();

	/**
	 * Returns the meta object for class '{@link net.sf.parteg.base.testcasetree.generated.TCGDisjunctiveNormalForm <em>TCG Disjunctive Normal Form</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TCG Disjunctive Normal Form</em>'.
	 * @see net.sf.parteg.base.testcasetree.generated.TCGDisjunctiveNormalForm
	 * @generated
	 */
	EClass getTCGDisjunctiveNormalForm();

	/**
	 * Returns the meta object for the reference list '{@link net.sf.parteg.base.testcasetree.generated.TCGDisjunctiveNormalForm#getConjunctions <em>Conjunctions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Conjunctions</em>'.
	 * @see net.sf.parteg.base.testcasetree.generated.TCGDisjunctiveNormalForm#getConjunctions()
	 * @see #getTCGDisjunctiveNormalForm()
	 * @generated
	 */
	EReference getTCGDisjunctiveNormalForm_Conjunctions();

	/**
	 * Returns the meta object for class '{@link net.sf.parteg.base.testcasetree.generated.TCGOCLOperation <em>TCGOCL Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TCGOCL Operation</em>'.
	 * @see net.sf.parteg.base.testcasetree.generated.TCGOCLOperation
	 * @generated
	 */
	EClass getTCGOCLOperation();

	/**
	 * Returns the meta object for the reference '{@link net.sf.parteg.base.testcasetree.generated.TCGOCLOperation#getLeft <em>Left</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Left</em>'.
	 * @see net.sf.parteg.base.testcasetree.generated.TCGOCLOperation#getLeft()
	 * @see #getTCGOCLOperation()
	 * @generated
	 */
	EReference getTCGOCLOperation_Left();

	/**
	 * Returns the meta object for the reference '{@link net.sf.parteg.base.testcasetree.generated.TCGOCLOperation#getRight <em>Right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Right</em>'.
	 * @see net.sf.parteg.base.testcasetree.generated.TCGOCLOperation#getRight()
	 * @see #getTCGOCLOperation()
	 * @generated
	 */
	EReference getTCGOCLOperation_Right();

	/**
	 * Returns the meta object for the reference '{@link net.sf.parteg.base.testcasetree.generated.TCGOCLOperation#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Operation</em>'.
	 * @see net.sf.parteg.base.testcasetree.generated.TCGOCLOperation#getOperation()
	 * @see #getTCGOCLOperation()
	 * @generated
	 */
	EReference getTCGOCLOperation_Operation();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.parteg.base.testcasetree.generated.TCGOCLOperation#getOperationName <em>Operation Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operation Name</em>'.
	 * @see net.sf.parteg.base.testcasetree.generated.TCGOCLOperation#getOperationName()
	 * @see #getTCGOCLOperation()
	 * @generated
	 */
	EAttribute getTCGOCLOperation_OperationName();

	/**
	 * Returns the meta object for class '{@link net.sf.parteg.base.testcasetree.generated.TCGOCLAtom <em>TCGOCL Atom</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TCGOCL Atom</em>'.
	 * @see net.sf.parteg.base.testcasetree.generated.TCGOCLAtom
	 * @generated
	 */
	EClass getTCGOCLAtom();

	/**
	 * Returns the meta object for the reference '{@link net.sf.parteg.base.testcasetree.generated.TCGOCLAtom#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Element</em>'.
	 * @see net.sf.parteg.base.testcasetree.generated.TCGOCLAtom#getElement()
	 * @see #getTCGOCLAtom()
	 * @generated
	 */
	EReference getTCGOCLAtom_Element();

	/**
	 * Returns the meta object for the reference '{@link net.sf.parteg.base.testcasetree.generated.TCGOCLAtom#getTcgParameter <em>Tcg Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Tcg Parameter</em>'.
	 * @see net.sf.parteg.base.testcasetree.generated.TCGOCLAtom#getTcgParameter()
	 * @see #getTCGOCLAtom()
	 * @generated
	 */
	EReference getTCGOCLAtom_TcgParameter();

	/**
	 * Returns the meta object for class '{@link net.sf.parteg.base.testcasetree.generated.TCGOCLIfThenElse <em>TCGOCL If Then Else</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TCGOCL If Then Else</em>'.
	 * @see net.sf.parteg.base.testcasetree.generated.TCGOCLIfThenElse
	 * @generated
	 */
	EClass getTCGOCLIfThenElse();

	/**
	 * Returns the meta object for the reference '{@link net.sf.parteg.base.testcasetree.generated.TCGOCLIfThenElse#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Condition</em>'.
	 * @see net.sf.parteg.base.testcasetree.generated.TCGOCLIfThenElse#getCondition()
	 * @see #getTCGOCLIfThenElse()
	 * @generated
	 */
	EReference getTCGOCLIfThenElse_Condition();

	/**
	 * Returns the meta object for the reference '{@link net.sf.parteg.base.testcasetree.generated.TCGOCLIfThenElse#getThenExpression <em>Then Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Then Expression</em>'.
	 * @see net.sf.parteg.base.testcasetree.generated.TCGOCLIfThenElse#getThenExpression()
	 * @see #getTCGOCLIfThenElse()
	 * @generated
	 */
	EReference getTCGOCLIfThenElse_ThenExpression();

	/**
	 * Returns the meta object for the reference '{@link net.sf.parteg.base.testcasetree.generated.TCGOCLIfThenElse#getElseExpression <em>Else Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Else Expression</em>'.
	 * @see net.sf.parteg.base.testcasetree.generated.TCGOCLIfThenElse#getElseExpression()
	 * @see #getTCGOCLIfThenElse()
	 * @generated
	 */
	EReference getTCGOCLIfThenElse_ElseExpression();

	/**
	 * Returns the meta object for class '{@link net.sf.parteg.base.testcasetree.generated.TCGParameter <em>TCG Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TCG Parameter</em>'.
	 * @see net.sf.parteg.base.testcasetree.generated.TCGParameter
	 * @generated
	 */
	EClass getTCGParameter();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.parteg.base.testcasetree.generated.TCGParameter#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see net.sf.parteg.base.testcasetree.generated.TCGParameter#getName()
	 * @see #getTCGParameter()
	 * @generated
	 */
	EAttribute getTCGParameter_Name();

	/**
	 * Returns the meta object for the reference '{@link net.sf.parteg.base.testcasetree.generated.TCGParameter#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see net.sf.parteg.base.testcasetree.generated.TCGParameter#getType()
	 * @see #getTCGParameter()
	 * @generated
	 */
	EReference getTCGParameter_Type();

	/**
	 * Returns the meta object for the reference '{@link net.sf.parteg.base.testcasetree.generated.TCGParameter#getReference <em>Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Reference</em>'.
	 * @see net.sf.parteg.base.testcasetree.generated.TCGParameter#getReference()
	 * @see #getTCGParameter()
	 * @generated
	 */
	EReference getTCGParameter_Reference();

	/**
	 * Returns the meta object for the reference '{@link net.sf.parteg.base.testcasetree.generated.TCGParameter#getDefiningTransition <em>Defining Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Defining Transition</em>'.
	 * @see net.sf.parteg.base.testcasetree.generated.TCGParameter#getDefiningTransition()
	 * @see #getTCGParameter()
	 * @generated
	 */
	EReference getTCGParameter_DefiningTransition();

	/**
	 * Returns the meta object for the reference '{@link net.sf.parteg.base.testcasetree.generated.TCGParameter#getContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Container</em>'.
	 * @see net.sf.parteg.base.testcasetree.generated.TCGParameter#getContainer()
	 * @see #getTCGParameter()
	 * @generated
	 */
	EReference getTCGParameter_Container();

	/**
	 * Returns the meta object for class '{@link net.sf.parteg.base.testcasetree.generated.TCGPrimitiveParameter <em>TCG Primitive Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TCG Primitive Parameter</em>'.
	 * @see net.sf.parteg.base.testcasetree.generated.TCGPrimitiveParameter
	 * @generated
	 */
	EClass getTCGPrimitiveParameter();

	/**
	 * Returns the meta object for the reference '{@link net.sf.parteg.base.testcasetree.generated.TCGPrimitiveParameter#getEquivalenceClass <em>Equivalence Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Equivalence Class</em>'.
	 * @see net.sf.parteg.base.testcasetree.generated.TCGPrimitiveParameter#getEquivalenceClass()
	 * @see #getTCGPrimitiveParameter()
	 * @generated
	 */
	EReference getTCGPrimitiveParameter_EquivalenceClass();

	/**
	 * Returns the meta object for class '{@link net.sf.parteg.base.testcasetree.generated.TCGComplexParameter <em>TCG Complex Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TCG Complex Parameter</em>'.
	 * @see net.sf.parteg.base.testcasetree.generated.TCGComplexParameter
	 * @generated
	 */
	EClass getTCGComplexParameter();

	/**
	 * Returns the meta object for the reference list '{@link net.sf.parteg.base.testcasetree.generated.TCGComplexParameter#getParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Parameter</em>'.
	 * @see net.sf.parteg.base.testcasetree.generated.TCGComplexParameter#getParameter()
	 * @see #getTCGComplexParameter()
	 * @generated
	 */
	EReference getTCGComplexParameter_Parameter();

	/**
	 * Returns the meta object for class '{@link net.sf.parteg.base.testcasetree.generated.TCGElement <em>TCG Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TCG Element</em>'.
	 * @see net.sf.parteg.base.testcasetree.generated.TCGElement
	 * @generated
	 */
	EClass getTCGElement();

	/**
	 * Returns the meta object for enum '{@link net.sf.parteg.base.testcasetree.generated.VariableClassification <em>Variable Classification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Variable Classification</em>'.
	 * @see net.sf.parteg.base.testcasetree.generated.VariableClassification
	 * @generated
	 */
	EEnum getVariableClassification();

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
		 * The meta object literal for the '{@link net.sf.parteg.base.testcasetree.generated.impl.TCGNodeImpl <em>TCG Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.sf.parteg.base.testcasetree.generated.impl.TCGNodeImpl
		 * @see net.sf.parteg.base.testcasetree.generated.impl.GeneratedPackageImpl#getTCGNode()
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
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TCG_NODE__CONDITION = eINSTANCE.getTCGNode_Condition();

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
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TCG_NODE__PARAMETERS = eINSTANCE.getTCGNode_Parameters();

		/**
		 * The meta object literal for the '<em><b>Distance To Root</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TCG_NODE__DISTANCE_TO_ROOT = eINSTANCE.getTCGNode_DistanceToRoot();

		/**
		 * The meta object literal for the '<em><b>Corresponds Negative Expression</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TCG_NODE__CORRESPONDS_NEGATIVE_EXPRESSION = eINSTANCE.getTCGNode_CorrespondsNegativeExpression();

		/**
		 * The meta object literal for the '<em><b>Original Expression</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TCG_NODE__ORIGINAL_EXPRESSION = eINSTANCE.getTCGNode_OriginalExpression();

		/**
		 * The meta object literal for the '<em><b>Invariant</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TCG_NODE__INVARIANT = eINSTANCE.getTCGNode_Invariant();

		/**
		 * The meta object literal for the '<em><b>Origonal Node</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TCG_NODE__ORIGONAL_NODE = eINSTANCE.getTCGNode_OrigonalNode();

		/**
		 * The meta object literal for the '{@link net.sf.parteg.base.testcasetree.generated.impl.TestCaseGraphImpl <em>Test Case Graph</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.sf.parteg.base.testcasetree.generated.impl.TestCaseGraphImpl
		 * @see net.sf.parteg.base.testcasetree.generated.impl.GeneratedPackageImpl#getTestCaseGraph()
		 * @generated
		 */
		EClass TEST_CASE_GRAPH = eINSTANCE.getTestCaseGraph();

		/**
		 * The meta object literal for the '<em><b>Root</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST_CASE_GRAPH__ROOT = eINSTANCE.getTestCaseGraph_Root();

		/**
		 * The meta object literal for the '<em><b>Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST_CASE_GRAPH__NODES = eINSTANCE.getTestCaseGraph_Nodes();

		/**
		 * The meta object literal for the '<em><b>Transitions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST_CASE_GRAPH__TRANSITIONS = eINSTANCE.getTestCaseGraph_Transitions();

		/**
		 * The meta object literal for the '<em><b>Conditions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST_CASE_GRAPH__CONDITIONS = eINSTANCE.getTestCaseGraph_Conditions();

		/**
		 * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST_CASE_GRAPH__ATTRIBUTES = eINSTANCE.getTestCaseGraph_Attributes();

		/**
		 * The meta object literal for the '{@link net.sf.parteg.base.testcasetree.generated.impl.TCGTransitionImpl <em>TCG Transition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.sf.parteg.base.testcasetree.generated.impl.TCGTransitionImpl
		 * @see net.sf.parteg.base.testcasetree.generated.impl.GeneratedPackageImpl#getTCGTransition()
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
		 * The meta object literal for the '<em><b>Event</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TCG_TRANSITION__EVENT = eINSTANCE.getTCGTransition_Event();

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
		 * The meta object literal for the '{@link net.sf.parteg.base.testcasetree.generated.impl.TCGEquivalenceClassImpl <em>TCG Equivalence Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.sf.parteg.base.testcasetree.generated.impl.TCGEquivalenceClassImpl
		 * @see net.sf.parteg.base.testcasetree.generated.impl.GeneratedPackageImpl#getTCGEquivalenceClass()
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
		 * The meta object literal for the '{@link net.sf.parteg.base.testcasetree.generated.impl.TCGEventImpl <em>TCG Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.sf.parteg.base.testcasetree.generated.impl.TCGEventImpl
		 * @see net.sf.parteg.base.testcasetree.generated.impl.GeneratedPackageImpl#getTCGEvent()
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
		 * The meta object literal for the '{@link net.sf.parteg.base.testcasetree.generated.impl.TCGOCLExpressionImpl <em>TCGOCL Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.sf.parteg.base.testcasetree.generated.impl.TCGOCLExpressionImpl
		 * @see net.sf.parteg.base.testcasetree.generated.impl.GeneratedPackageImpl#getTCGOCLExpression()
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
		 * The meta object literal for the '{@link net.sf.parteg.base.testcasetree.generated.impl.TCGConjunctionImpl <em>TCG Conjunction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.sf.parteg.base.testcasetree.generated.impl.TCGConjunctionImpl
		 * @see net.sf.parteg.base.testcasetree.generated.impl.GeneratedPackageImpl#getTCGConjunction()
		 * @generated
		 */
		EClass TCG_CONJUNCTION = eINSTANCE.getTCGConjunction();

		/**
		 * The meta object literal for the '<em><b>Expressions</b></em>' containment reference list feature.
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
		 * The meta object literal for the '{@link net.sf.parteg.base.testcasetree.generated.impl.TCGDisjunctiveNormalFormImpl <em>TCG Disjunctive Normal Form</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.sf.parteg.base.testcasetree.generated.impl.TCGDisjunctiveNormalFormImpl
		 * @see net.sf.parteg.base.testcasetree.generated.impl.GeneratedPackageImpl#getTCGDisjunctiveNormalForm()
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
		 * The meta object literal for the '{@link net.sf.parteg.base.testcasetree.generated.impl.TCGOCLOperationImpl <em>TCGOCL Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.sf.parteg.base.testcasetree.generated.impl.TCGOCLOperationImpl
		 * @see net.sf.parteg.base.testcasetree.generated.impl.GeneratedPackageImpl#getTCGOCLOperation()
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
		 * The meta object literal for the '{@link net.sf.parteg.base.testcasetree.generated.impl.TCGOCLAtomImpl <em>TCGOCL Atom</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.sf.parteg.base.testcasetree.generated.impl.TCGOCLAtomImpl
		 * @see net.sf.parteg.base.testcasetree.generated.impl.GeneratedPackageImpl#getTCGOCLAtom()
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
		 * The meta object literal for the '{@link net.sf.parteg.base.testcasetree.generated.impl.TCGOCLIfThenElseImpl <em>TCGOCL If Then Else</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.sf.parteg.base.testcasetree.generated.impl.TCGOCLIfThenElseImpl
		 * @see net.sf.parteg.base.testcasetree.generated.impl.GeneratedPackageImpl#getTCGOCLIfThenElse()
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
		 * The meta object literal for the '{@link net.sf.parteg.base.testcasetree.generated.TCGParameter <em>TCG Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.sf.parteg.base.testcasetree.generated.TCGParameter
		 * @see net.sf.parteg.base.testcasetree.generated.impl.GeneratedPackageImpl#getTCGParameter()
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
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TCG_PARAMETER__TYPE = eINSTANCE.getTCGParameter_Type();

		/**
		 * The meta object literal for the '<em><b>Reference</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TCG_PARAMETER__REFERENCE = eINSTANCE.getTCGParameter_Reference();

		/**
		 * The meta object literal for the '<em><b>Defining Transition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TCG_PARAMETER__DEFINING_TRANSITION = eINSTANCE.getTCGParameter_DefiningTransition();

		/**
		 * The meta object literal for the '<em><b>Container</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TCG_PARAMETER__CONTAINER = eINSTANCE.getTCGParameter_Container();

		/**
		 * The meta object literal for the '{@link net.sf.parteg.base.testcasetree.generated.impl.TCGPrimitiveParameterImpl <em>TCG Primitive Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.sf.parteg.base.testcasetree.generated.impl.TCGPrimitiveParameterImpl
		 * @see net.sf.parteg.base.testcasetree.generated.impl.GeneratedPackageImpl#getTCGPrimitiveParameter()
		 * @generated
		 */
		EClass TCG_PRIMITIVE_PARAMETER = eINSTANCE.getTCGPrimitiveParameter();

		/**
		 * The meta object literal for the '<em><b>Equivalence Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TCG_PRIMITIVE_PARAMETER__EQUIVALENCE_CLASS = eINSTANCE.getTCGPrimitiveParameter_EquivalenceClass();

		/**
		 * The meta object literal for the '{@link net.sf.parteg.base.testcasetree.generated.impl.TCGComplexParameterImpl <em>TCG Complex Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.sf.parteg.base.testcasetree.generated.impl.TCGComplexParameterImpl
		 * @see net.sf.parteg.base.testcasetree.generated.impl.GeneratedPackageImpl#getTCGComplexParameter()
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
		 * The meta object literal for the '{@link net.sf.parteg.base.testcasetree.generated.impl.TCGElementImpl <em>TCG Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.sf.parteg.base.testcasetree.generated.impl.TCGElementImpl
		 * @see net.sf.parteg.base.testcasetree.generated.impl.GeneratedPackageImpl#getTCGElement()
		 * @generated
		 */
		EClass TCG_ELEMENT = eINSTANCE.getTCGElement();

		/**
		 * The meta object literal for the '{@link net.sf.parteg.base.testcasetree.generated.VariableClassification <em>Variable Classification</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.sf.parteg.base.testcasetree.generated.VariableClassification
		 * @see net.sf.parteg.base.testcasetree.generated.impl.GeneratedPackageImpl#getVariableClassification()
		 * @generated
		 */
		EEnum VARIABLE_CLASSIFICATION = eINSTANCE.getVariableClassification();

	}

} //GeneratedPackage
