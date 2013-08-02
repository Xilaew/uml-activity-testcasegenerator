/**
 */
package org.xilaew.atg.model.activityTestCaseGraph;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.xilaew.atg.model.abstractTestCaseGraph.AbstractTestCaseGraphPackage;

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
 * @see org.xilaew.atg.model.activityTestCaseGraph.ActivityTestCaseGraphFactory
 * @model kind="package"
 * @generated
 */
public interface ActivityTestCaseGraphPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "activityTestCaseGraph";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://org.xilaew.atg.model.activityTestCaseGraph";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.xilaew.atg.model.activityTestCaseGraph";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ActivityTestCaseGraphPackage eINSTANCE = org.xilaew.atg.model.activityTestCaseGraph.impl.ActivityTestCaseGraphPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.xilaew.atg.model.activityTestCaseGraph.impl.TCGActivityImpl <em>TCG Activity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xilaew.atg.model.activityTestCaseGraph.impl.TCGActivityImpl
	 * @see org.xilaew.atg.model.activityTestCaseGraph.impl.ActivityTestCaseGraphPackageImpl#getTCGActivity()
	 * @generated
	 */
	int TCG_ACTIVITY = 0;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_ACTIVITY__EANNOTATIONS = AbstractTestCaseGraphPackage.ABSTRACT_TCG_CONTAINER__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_ACTIVITY__NAME = AbstractTestCaseGraphPackage.ABSTRACT_TCG_CONTAINER__NAME;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_ACTIVITY__NODES = AbstractTestCaseGraphPackage.ABSTRACT_TCG_CONTAINER__NODES;

	/**
	 * The feature id for the '<em><b>Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_ACTIVITY__EDGES = AbstractTestCaseGraphPackage.ABSTRACT_TCG_CONTAINER__EDGES;

	/**
	 * The feature id for the '<em><b>Variables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_ACTIVITY__VARIABLES = AbstractTestCaseGraphPackage.ABSTRACT_TCG_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>TCG Activity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_ACTIVITY_FEATURE_COUNT = AbstractTestCaseGraphPackage.ABSTRACT_TCG_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get EAnnotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_ACTIVITY___GET_EANNOTATION__STRING = AbstractTestCaseGraphPackage.ABSTRACT_TCG_CONTAINER___GET_EANNOTATION__STRING;

	/**
	 * The number of operations of the '<em>TCG Activity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_ACTIVITY_OPERATION_COUNT = AbstractTestCaseGraphPackage.ABSTRACT_TCG_CONTAINER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.xilaew.atg.model.activityTestCaseGraph.impl.TCGActionImpl <em>TCG Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xilaew.atg.model.activityTestCaseGraph.impl.TCGActionImpl
	 * @see org.xilaew.atg.model.activityTestCaseGraph.impl.ActivityTestCaseGraphPackageImpl#getTCGAction()
	 * @generated
	 */
	int TCG_ACTION = 1;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_ACTION__EANNOTATIONS = AbstractTestCaseGraphPackage.ABSTRACT_TCG_REAL_NODE__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_ACTION__NAME = AbstractTestCaseGraphPackage.ABSTRACT_TCG_REAL_NODE__NAME;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_ACTION__OUTGOING = AbstractTestCaseGraphPackage.ABSTRACT_TCG_REAL_NODE__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_ACTION__INCOMING = AbstractTestCaseGraphPackage.ABSTRACT_TCG_REAL_NODE__INCOMING;

	/**
	 * The feature id for the '<em><b>Local Postconditions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_ACTION__LOCAL_POSTCONDITIONS = AbstractTestCaseGraphPackage.ABSTRACT_TCG_REAL_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>TCG Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_ACTION_FEATURE_COUNT = AbstractTestCaseGraphPackage.ABSTRACT_TCG_REAL_NODE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get EAnnotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_ACTION___GET_EANNOTATION__STRING = AbstractTestCaseGraphPackage.ABSTRACT_TCG_REAL_NODE___GET_EANNOTATION__STRING;

	/**
	 * The number of operations of the '<em>TCG Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_ACTION_OPERATION_COUNT = AbstractTestCaseGraphPackage.ABSTRACT_TCG_REAL_NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.xilaew.atg.model.activityTestCaseGraph.impl.TCGControlFlowImpl <em>TCG Control Flow</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xilaew.atg.model.activityTestCaseGraph.impl.TCGControlFlowImpl
	 * @see org.xilaew.atg.model.activityTestCaseGraph.impl.ActivityTestCaseGraphPackageImpl#getTCGControlFlow()
	 * @generated
	 */
	int TCG_CONTROL_FLOW = 2;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_CONTROL_FLOW__EANNOTATIONS = AbstractTestCaseGraphPackage.ABSTRACT_TCG_EDGE__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_CONTROL_FLOW__NAME = AbstractTestCaseGraphPackage.ABSTRACT_TCG_EDGE__NAME;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_CONTROL_FLOW__SOURCE = AbstractTestCaseGraphPackage.ABSTRACT_TCG_EDGE__SOURCE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_CONTROL_FLOW__TARGET = AbstractTestCaseGraphPackage.ABSTRACT_TCG_EDGE__TARGET;

	/**
	 * The feature id for the '<em><b>Guard</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_CONTROL_FLOW__GUARD = AbstractTestCaseGraphPackage.ABSTRACT_TCG_EDGE__GUARD;

	/**
	 * The number of structural features of the '<em>TCG Control Flow</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_CONTROL_FLOW_FEATURE_COUNT = AbstractTestCaseGraphPackage.ABSTRACT_TCG_EDGE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get EAnnotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_CONTROL_FLOW___GET_EANNOTATION__STRING = AbstractTestCaseGraphPackage.ABSTRACT_TCG_EDGE___GET_EANNOTATION__STRING;

	/**
	 * The number of operations of the '<em>TCG Control Flow</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_CONTROL_FLOW_OPERATION_COUNT = AbstractTestCaseGraphPackage.ABSTRACT_TCG_EDGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.xilaew.atg.model.activityTestCaseGraph.impl.TCGControlNodeImpl <em>TCG Control Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xilaew.atg.model.activityTestCaseGraph.impl.TCGControlNodeImpl
	 * @see org.xilaew.atg.model.activityTestCaseGraph.impl.ActivityTestCaseGraphPackageImpl#getTCGControlNode()
	 * @generated
	 */
	int TCG_CONTROL_NODE = 3;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_CONTROL_NODE__EANNOTATIONS = AbstractTestCaseGraphPackage.ABSTRACT_TCG_PSEUDO_NODE__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_CONTROL_NODE__NAME = AbstractTestCaseGraphPackage.ABSTRACT_TCG_PSEUDO_NODE__NAME;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_CONTROL_NODE__OUTGOING = AbstractTestCaseGraphPackage.ABSTRACT_TCG_PSEUDO_NODE__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_CONTROL_NODE__INCOMING = AbstractTestCaseGraphPackage.ABSTRACT_TCG_PSEUDO_NODE__INCOMING;

	/**
	 * The number of structural features of the '<em>TCG Control Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_CONTROL_NODE_FEATURE_COUNT = AbstractTestCaseGraphPackage.ABSTRACT_TCG_PSEUDO_NODE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get EAnnotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_CONTROL_NODE___GET_EANNOTATION__STRING = AbstractTestCaseGraphPackage.ABSTRACT_TCG_PSEUDO_NODE___GET_EANNOTATION__STRING;

	/**
	 * The number of operations of the '<em>TCG Control Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_CONTROL_NODE_OPERATION_COUNT = AbstractTestCaseGraphPackage.ABSTRACT_TCG_PSEUDO_NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.xilaew.atg.model.activityTestCaseGraph.impl.TCGVariableImpl <em>TCG Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xilaew.atg.model.activityTestCaseGraph.impl.TCGVariableImpl
	 * @see org.xilaew.atg.model.activityTestCaseGraph.impl.ActivityTestCaseGraphPackageImpl#getTCGVariable()
	 * @generated
	 */
	int TCG_VARIABLE = 4;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_VARIABLE__EANNOTATIONS = AbstractTestCaseGraphPackage.ABSTRACT_TCG_ELEMENT__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_VARIABLE__NAME = AbstractTestCaseGraphPackage.ABSTRACT_TCG_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Referenced By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_VARIABLE__REFERENCED_BY = AbstractTestCaseGraphPackage.ABSTRACT_TCG_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Parameter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_VARIABLE__IS_PARAMETER = AbstractTestCaseGraphPackage.ABSTRACT_TCG_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>TCG Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_VARIABLE_FEATURE_COUNT = AbstractTestCaseGraphPackage.ABSTRACT_TCG_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get EAnnotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_VARIABLE___GET_EANNOTATION__STRING = AbstractTestCaseGraphPackage.ABSTRACT_TCG_ELEMENT___GET_EANNOTATION__STRING;

	/**
	 * The number of operations of the '<em>TCG Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_VARIABLE_OPERATION_COUNT = AbstractTestCaseGraphPackage.ABSTRACT_TCG_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.xilaew.atg.model.activityTestCaseGraph.impl.TCGObjectVariableImpl <em>TCG Object Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xilaew.atg.model.activityTestCaseGraph.impl.TCGObjectVariableImpl
	 * @see org.xilaew.atg.model.activityTestCaseGraph.impl.ActivityTestCaseGraphPackageImpl#getTCGObjectVariable()
	 * @generated
	 */
	int TCG_OBJECT_VARIABLE = 5;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_OBJECT_VARIABLE__EANNOTATIONS = TCG_VARIABLE__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_OBJECT_VARIABLE__NAME = TCG_VARIABLE__NAME;

	/**
	 * The feature id for the '<em><b>Referenced By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_OBJECT_VARIABLE__REFERENCED_BY = TCG_VARIABLE__REFERENCED_BY;

	/**
	 * The feature id for the '<em><b>Is Parameter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_OBJECT_VARIABLE__IS_PARAMETER = TCG_VARIABLE__IS_PARAMETER;

	/**
	 * The feature id for the '<em><b>Fields</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_OBJECT_VARIABLE__FIELDS = TCG_VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>TCG Object Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_OBJECT_VARIABLE_FEATURE_COUNT = TCG_VARIABLE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get EAnnotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_OBJECT_VARIABLE___GET_EANNOTATION__STRING = TCG_VARIABLE___GET_EANNOTATION__STRING;

	/**
	 * The number of operations of the '<em>TCG Object Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_OBJECT_VARIABLE_OPERATION_COUNT = TCG_VARIABLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.xilaew.atg.model.activityTestCaseGraph.impl.TCGBasicVariableImpl <em>TCG Basic Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xilaew.atg.model.activityTestCaseGraph.impl.TCGBasicVariableImpl
	 * @see org.xilaew.atg.model.activityTestCaseGraph.impl.ActivityTestCaseGraphPackageImpl#getTCGBasicVariable()
	 * @generated
	 */
	int TCG_BASIC_VARIABLE = 6;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_BASIC_VARIABLE__EANNOTATIONS = TCG_VARIABLE__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_BASIC_VARIABLE__NAME = TCG_VARIABLE__NAME;

	/**
	 * The feature id for the '<em><b>Referenced By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_BASIC_VARIABLE__REFERENCED_BY = TCG_VARIABLE__REFERENCED_BY;

	/**
	 * The feature id for the '<em><b>Is Parameter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_BASIC_VARIABLE__IS_PARAMETER = TCG_VARIABLE__IS_PARAMETER;

	/**
	 * The feature id for the '<em><b>Variable Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_BASIC_VARIABLE__VARIABLE_TYPE = TCG_VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>TCG Basic Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_BASIC_VARIABLE_FEATURE_COUNT = TCG_VARIABLE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get EAnnotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_BASIC_VARIABLE___GET_EANNOTATION__STRING = TCG_VARIABLE___GET_EANNOTATION__STRING;

	/**
	 * The operation id for the '<em>Get Absolute Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_BASIC_VARIABLE___GET_ABSOLUTE_NAME = TCG_VARIABLE_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>TCG Basic Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_BASIC_VARIABLE_OPERATION_COUNT = TCG_VARIABLE_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.xilaew.atg.model.activityTestCaseGraph.impl.TCGOCLExpressionImpl <em>TCGOCL Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xilaew.atg.model.activityTestCaseGraph.impl.TCGOCLExpressionImpl
	 * @see org.xilaew.atg.model.activityTestCaseGraph.impl.ActivityTestCaseGraphPackageImpl#getTCGOCLExpression()
	 * @generated
	 */
	int TCGOCL_EXPRESSION = 7;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCGOCL_EXPRESSION__EANNOTATIONS = AbstractTestCaseGraphPackage.ABSTRACT_TCG_CONSTRAINT__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCGOCL_EXPRESSION__NAME = AbstractTestCaseGraphPackage.ABSTRACT_TCG_CONSTRAINT__NAME;

	/**
	 * The number of structural features of the '<em>TCGOCL Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCGOCL_EXPRESSION_FEATURE_COUNT = AbstractTestCaseGraphPackage.ABSTRACT_TCG_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get EAnnotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCGOCL_EXPRESSION___GET_EANNOTATION__STRING = AbstractTestCaseGraphPackage.ABSTRACT_TCG_CONSTRAINT___GET_EANNOTATION__STRING;

	/**
	 * The number of operations of the '<em>TCGOCL Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCGOCL_EXPRESSION_OPERATION_COUNT = AbstractTestCaseGraphPackage.ABSTRACT_TCG_CONSTRAINT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.xilaew.atg.model.activityTestCaseGraph.impl.TCGOCLOperationCallExpImpl <em>TCGOCL Operation Call Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xilaew.atg.model.activityTestCaseGraph.impl.TCGOCLOperationCallExpImpl
	 * @see org.xilaew.atg.model.activityTestCaseGraph.impl.ActivityTestCaseGraphPackageImpl#getTCGOCLOperationCallExp()
	 * @generated
	 */
	int TCGOCL_OPERATION_CALL_EXP = 8;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCGOCL_OPERATION_CALL_EXP__EANNOTATIONS = TCGOCL_EXPRESSION__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCGOCL_OPERATION_CALL_EXP__NAME = TCGOCL_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCGOCL_OPERATION_CALL_EXP__SOURCE = TCGOCL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCGOCL_OPERATION_CALL_EXP__ARGUMENTS = TCGOCL_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCGOCL_OPERATION_CALL_EXP__OPERATION = TCGOCL_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>TCGOCL Operation Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCGOCL_OPERATION_CALL_EXP_FEATURE_COUNT = TCGOCL_EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Get EAnnotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCGOCL_OPERATION_CALL_EXP___GET_EANNOTATION__STRING = TCGOCL_EXPRESSION___GET_EANNOTATION__STRING;

	/**
	 * The number of operations of the '<em>TCGOCL Operation Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCGOCL_OPERATION_CALL_EXP_OPERATION_COUNT = TCGOCL_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.xilaew.atg.model.activityTestCaseGraph.impl.TCGOCLVariableCallExpImpl <em>TCGOCL Variable Call Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xilaew.atg.model.activityTestCaseGraph.impl.TCGOCLVariableCallExpImpl
	 * @see org.xilaew.atg.model.activityTestCaseGraph.impl.ActivityTestCaseGraphPackageImpl#getTCGOCLVariableCallExp()
	 * @generated
	 */
	int TCGOCL_VARIABLE_CALL_EXP = 9;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCGOCL_VARIABLE_CALL_EXP__EANNOTATIONS = TCGOCL_EXPRESSION__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCGOCL_VARIABLE_CALL_EXP__NAME = TCGOCL_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCGOCL_VARIABLE_CALL_EXP__VARIABLE = TCGOCL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Pre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCGOCL_VARIABLE_CALL_EXP__IS_PRE = TCGOCL_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>TCGOCL Variable Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCGOCL_VARIABLE_CALL_EXP_FEATURE_COUNT = TCGOCL_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get EAnnotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCGOCL_VARIABLE_CALL_EXP___GET_EANNOTATION__STRING = TCGOCL_EXPRESSION___GET_EANNOTATION__STRING;

	/**
	 * The number of operations of the '<em>TCGOCL Variable Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCGOCL_VARIABLE_CALL_EXP_OPERATION_COUNT = TCGOCL_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.xilaew.atg.model.activityTestCaseGraph.impl.TCGOCLLiteralExpImpl <em>TCGOCL Literal Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xilaew.atg.model.activityTestCaseGraph.impl.TCGOCLLiteralExpImpl
	 * @see org.xilaew.atg.model.activityTestCaseGraph.impl.ActivityTestCaseGraphPackageImpl#getTCGOCLLiteralExp()
	 * @generated
	 */
	int TCGOCL_LITERAL_EXP = 10;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCGOCL_LITERAL_EXP__EANNOTATIONS = TCGOCL_EXPRESSION__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCGOCL_LITERAL_EXP__NAME = TCGOCL_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCGOCL_LITERAL_EXP__TYPE = TCGOCL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCGOCL_LITERAL_EXP__VALUE = TCGOCL_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>TCGOCL Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCGOCL_LITERAL_EXP_FEATURE_COUNT = TCGOCL_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get EAnnotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCGOCL_LITERAL_EXP___GET_EANNOTATION__STRING = TCGOCL_EXPRESSION___GET_EANNOTATION__STRING;

	/**
	 * The number of operations of the '<em>TCGOCL Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCGOCL_LITERAL_EXP_OPERATION_COUNT = TCGOCL_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.xilaew.atg.model.activityTestCaseGraph.TCGBasicVariableType <em>TCG Basic Variable Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xilaew.atg.model.activityTestCaseGraph.TCGBasicVariableType
	 * @see org.xilaew.atg.model.activityTestCaseGraph.impl.ActivityTestCaseGraphPackageImpl#getTCGBasicVariableType()
	 * @generated
	 */
	int TCG_BASIC_VARIABLE_TYPE = 11;

	/**
	 * The meta object id for the '{@link org.xilaew.atg.model.activityTestCaseGraph.TCGOCLOperationType <em>TCGOCL Operation Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xilaew.atg.model.activityTestCaseGraph.TCGOCLOperationType
	 * @see org.xilaew.atg.model.activityTestCaseGraph.impl.ActivityTestCaseGraphPackageImpl#getTCGOCLOperationType()
	 * @generated
	 */
	int TCGOCL_OPERATION_TYPE = 12;


	/**
	 * Returns the meta object for class '{@link org.xilaew.atg.model.activityTestCaseGraph.TCGActivity <em>TCG Activity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TCG Activity</em>'.
	 * @see org.xilaew.atg.model.activityTestCaseGraph.TCGActivity
	 * @generated
	 */
	EClass getTCGActivity();

	/**
	 * Returns the meta object for the containment reference list '{@link org.xilaew.atg.model.activityTestCaseGraph.TCGActivity#getVariables <em>Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Variables</em>'.
	 * @see org.xilaew.atg.model.activityTestCaseGraph.TCGActivity#getVariables()
	 * @see #getTCGActivity()
	 * @generated
	 */
	EReference getTCGActivity_Variables();

	/**
	 * Returns the meta object for class '{@link org.xilaew.atg.model.activityTestCaseGraph.TCGAction <em>TCG Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TCG Action</em>'.
	 * @see org.xilaew.atg.model.activityTestCaseGraph.TCGAction
	 * @generated
	 */
	EClass getTCGAction();

	/**
	 * Returns the meta object for the containment reference list '{@link org.xilaew.atg.model.activityTestCaseGraph.TCGAction#getLocalPostconditions <em>Local Postconditions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Local Postconditions</em>'.
	 * @see org.xilaew.atg.model.activityTestCaseGraph.TCGAction#getLocalPostconditions()
	 * @see #getTCGAction()
	 * @generated
	 */
	EReference getTCGAction_LocalPostconditions();

	/**
	 * Returns the meta object for class '{@link org.xilaew.atg.model.activityTestCaseGraph.TCGControlFlow <em>TCG Control Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TCG Control Flow</em>'.
	 * @see org.xilaew.atg.model.activityTestCaseGraph.TCGControlFlow
	 * @generated
	 */
	EClass getTCGControlFlow();

	/**
	 * Returns the meta object for class '{@link org.xilaew.atg.model.activityTestCaseGraph.TCGControlNode <em>TCG Control Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TCG Control Node</em>'.
	 * @see org.xilaew.atg.model.activityTestCaseGraph.TCGControlNode
	 * @generated
	 */
	EClass getTCGControlNode();

	/**
	 * Returns the meta object for class '{@link org.xilaew.atg.model.activityTestCaseGraph.TCGVariable <em>TCG Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TCG Variable</em>'.
	 * @see org.xilaew.atg.model.activityTestCaseGraph.TCGVariable
	 * @generated
	 */
	EClass getTCGVariable();

	/**
	 * Returns the meta object for the reference list '{@link org.xilaew.atg.model.activityTestCaseGraph.TCGVariable#getReferencedBy <em>Referenced By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Referenced By</em>'.
	 * @see org.xilaew.atg.model.activityTestCaseGraph.TCGVariable#getReferencedBy()
	 * @see #getTCGVariable()
	 * @generated
	 */
	EReference getTCGVariable_ReferencedBy();

	/**
	 * Returns the meta object for the attribute '{@link org.xilaew.atg.model.activityTestCaseGraph.TCGVariable#isIsParameter <em>Is Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Parameter</em>'.
	 * @see org.xilaew.atg.model.activityTestCaseGraph.TCGVariable#isIsParameter()
	 * @see #getTCGVariable()
	 * @generated
	 */
	EAttribute getTCGVariable_IsParameter();

	/**
	 * Returns the meta object for class '{@link org.xilaew.atg.model.activityTestCaseGraph.TCGObjectVariable <em>TCG Object Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TCG Object Variable</em>'.
	 * @see org.xilaew.atg.model.activityTestCaseGraph.TCGObjectVariable
	 * @generated
	 */
	EClass getTCGObjectVariable();

	/**
	 * Returns the meta object for the reference list '{@link org.xilaew.atg.model.activityTestCaseGraph.TCGObjectVariable#getFields <em>Fields</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Fields</em>'.
	 * @see org.xilaew.atg.model.activityTestCaseGraph.TCGObjectVariable#getFields()
	 * @see #getTCGObjectVariable()
	 * @generated
	 */
	EReference getTCGObjectVariable_Fields();

	/**
	 * Returns the meta object for class '{@link org.xilaew.atg.model.activityTestCaseGraph.TCGBasicVariable <em>TCG Basic Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TCG Basic Variable</em>'.
	 * @see org.xilaew.atg.model.activityTestCaseGraph.TCGBasicVariable
	 * @generated
	 */
	EClass getTCGBasicVariable();

	/**
	 * Returns the meta object for the attribute '{@link org.xilaew.atg.model.activityTestCaseGraph.TCGBasicVariable#getVariableType <em>Variable Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Variable Type</em>'.
	 * @see org.xilaew.atg.model.activityTestCaseGraph.TCGBasicVariable#getVariableType()
	 * @see #getTCGBasicVariable()
	 * @generated
	 */
	EAttribute getTCGBasicVariable_VariableType();

	/**
	 * Returns the meta object for the '{@link org.xilaew.atg.model.activityTestCaseGraph.TCGBasicVariable#getAbsoluteName() <em>Get Absolute Name</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Absolute Name</em>' operation.
	 * @see org.xilaew.atg.model.activityTestCaseGraph.TCGBasicVariable#getAbsoluteName()
	 * @generated
	 */
	EOperation getTCGBasicVariable__GetAbsoluteName();

	/**
	 * Returns the meta object for class '{@link org.xilaew.atg.model.activityTestCaseGraph.TCGOCLExpression <em>TCGOCL Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TCGOCL Expression</em>'.
	 * @see org.xilaew.atg.model.activityTestCaseGraph.TCGOCLExpression
	 * @generated
	 */
	EClass getTCGOCLExpression();

	/**
	 * Returns the meta object for class '{@link org.xilaew.atg.model.activityTestCaseGraph.TCGOCLOperationCallExp <em>TCGOCL Operation Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TCGOCL Operation Call Exp</em>'.
	 * @see org.xilaew.atg.model.activityTestCaseGraph.TCGOCLOperationCallExp
	 * @generated
	 */
	EClass getTCGOCLOperationCallExp();

	/**
	 * Returns the meta object for the containment reference '{@link org.xilaew.atg.model.activityTestCaseGraph.TCGOCLOperationCallExp#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Source</em>'.
	 * @see org.xilaew.atg.model.activityTestCaseGraph.TCGOCLOperationCallExp#getSource()
	 * @see #getTCGOCLOperationCallExp()
	 * @generated
	 */
	EReference getTCGOCLOperationCallExp_Source();

	/**
	 * Returns the meta object for the containment reference list '{@link org.xilaew.atg.model.activityTestCaseGraph.TCGOCLOperationCallExp#getArguments <em>Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Arguments</em>'.
	 * @see org.xilaew.atg.model.activityTestCaseGraph.TCGOCLOperationCallExp#getArguments()
	 * @see #getTCGOCLOperationCallExp()
	 * @generated
	 */
	EReference getTCGOCLOperationCallExp_Arguments();

	/**
	 * Returns the meta object for the attribute '{@link org.xilaew.atg.model.activityTestCaseGraph.TCGOCLOperationCallExp#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operation</em>'.
	 * @see org.xilaew.atg.model.activityTestCaseGraph.TCGOCLOperationCallExp#getOperation()
	 * @see #getTCGOCLOperationCallExp()
	 * @generated
	 */
	EAttribute getTCGOCLOperationCallExp_Operation();

	/**
	 * Returns the meta object for class '{@link org.xilaew.atg.model.activityTestCaseGraph.TCGOCLVariableCallExp <em>TCGOCL Variable Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TCGOCL Variable Call Exp</em>'.
	 * @see org.xilaew.atg.model.activityTestCaseGraph.TCGOCLVariableCallExp
	 * @generated
	 */
	EClass getTCGOCLVariableCallExp();

	/**
	 * Returns the meta object for the reference '{@link org.xilaew.atg.model.activityTestCaseGraph.TCGOCLVariableCallExp#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Variable</em>'.
	 * @see org.xilaew.atg.model.activityTestCaseGraph.TCGOCLVariableCallExp#getVariable()
	 * @see #getTCGOCLVariableCallExp()
	 * @generated
	 */
	EReference getTCGOCLVariableCallExp_Variable();

	/**
	 * Returns the meta object for the attribute '{@link org.xilaew.atg.model.activityTestCaseGraph.TCGOCLVariableCallExp#isIsPre <em>Is Pre</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Pre</em>'.
	 * @see org.xilaew.atg.model.activityTestCaseGraph.TCGOCLVariableCallExp#isIsPre()
	 * @see #getTCGOCLVariableCallExp()
	 * @generated
	 */
	EAttribute getTCGOCLVariableCallExp_IsPre();

	/**
	 * Returns the meta object for class '{@link org.xilaew.atg.model.activityTestCaseGraph.TCGOCLLiteralExp <em>TCGOCL Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TCGOCL Literal Exp</em>'.
	 * @see org.xilaew.atg.model.activityTestCaseGraph.TCGOCLLiteralExp
	 * @generated
	 */
	EClass getTCGOCLLiteralExp();

	/**
	 * Returns the meta object for the attribute '{@link org.xilaew.atg.model.activityTestCaseGraph.TCGOCLLiteralExp#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.xilaew.atg.model.activityTestCaseGraph.TCGOCLLiteralExp#getType()
	 * @see #getTCGOCLLiteralExp()
	 * @generated
	 */
	EAttribute getTCGOCLLiteralExp_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.xilaew.atg.model.activityTestCaseGraph.TCGOCLLiteralExp#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.xilaew.atg.model.activityTestCaseGraph.TCGOCLLiteralExp#getValue()
	 * @see #getTCGOCLLiteralExp()
	 * @generated
	 */
	EAttribute getTCGOCLLiteralExp_Value();

	/**
	 * Returns the meta object for enum '{@link org.xilaew.atg.model.activityTestCaseGraph.TCGBasicVariableType <em>TCG Basic Variable Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>TCG Basic Variable Type</em>'.
	 * @see org.xilaew.atg.model.activityTestCaseGraph.TCGBasicVariableType
	 * @generated
	 */
	EEnum getTCGBasicVariableType();

	/**
	 * Returns the meta object for enum '{@link org.xilaew.atg.model.activityTestCaseGraph.TCGOCLOperationType <em>TCGOCL Operation Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>TCGOCL Operation Type</em>'.
	 * @see org.xilaew.atg.model.activityTestCaseGraph.TCGOCLOperationType
	 * @generated
	 */
	EEnum getTCGOCLOperationType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ActivityTestCaseGraphFactory getActivityTestCaseGraphFactory();

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
		 * The meta object literal for the '{@link org.xilaew.atg.model.activityTestCaseGraph.impl.TCGActivityImpl <em>TCG Activity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xilaew.atg.model.activityTestCaseGraph.impl.TCGActivityImpl
		 * @see org.xilaew.atg.model.activityTestCaseGraph.impl.ActivityTestCaseGraphPackageImpl#getTCGActivity()
		 * @generated
		 */
		EClass TCG_ACTIVITY = eINSTANCE.getTCGActivity();

		/**
		 * The meta object literal for the '<em><b>Variables</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TCG_ACTIVITY__VARIABLES = eINSTANCE.getTCGActivity_Variables();

		/**
		 * The meta object literal for the '{@link org.xilaew.atg.model.activityTestCaseGraph.impl.TCGActionImpl <em>TCG Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xilaew.atg.model.activityTestCaseGraph.impl.TCGActionImpl
		 * @see org.xilaew.atg.model.activityTestCaseGraph.impl.ActivityTestCaseGraphPackageImpl#getTCGAction()
		 * @generated
		 */
		EClass TCG_ACTION = eINSTANCE.getTCGAction();

		/**
		 * The meta object literal for the '<em><b>Local Postconditions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TCG_ACTION__LOCAL_POSTCONDITIONS = eINSTANCE.getTCGAction_LocalPostconditions();

		/**
		 * The meta object literal for the '{@link org.xilaew.atg.model.activityTestCaseGraph.impl.TCGControlFlowImpl <em>TCG Control Flow</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xilaew.atg.model.activityTestCaseGraph.impl.TCGControlFlowImpl
		 * @see org.xilaew.atg.model.activityTestCaseGraph.impl.ActivityTestCaseGraphPackageImpl#getTCGControlFlow()
		 * @generated
		 */
		EClass TCG_CONTROL_FLOW = eINSTANCE.getTCGControlFlow();

		/**
		 * The meta object literal for the '{@link org.xilaew.atg.model.activityTestCaseGraph.impl.TCGControlNodeImpl <em>TCG Control Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xilaew.atg.model.activityTestCaseGraph.impl.TCGControlNodeImpl
		 * @see org.xilaew.atg.model.activityTestCaseGraph.impl.ActivityTestCaseGraphPackageImpl#getTCGControlNode()
		 * @generated
		 */
		EClass TCG_CONTROL_NODE = eINSTANCE.getTCGControlNode();

		/**
		 * The meta object literal for the '{@link org.xilaew.atg.model.activityTestCaseGraph.impl.TCGVariableImpl <em>TCG Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xilaew.atg.model.activityTestCaseGraph.impl.TCGVariableImpl
		 * @see org.xilaew.atg.model.activityTestCaseGraph.impl.ActivityTestCaseGraphPackageImpl#getTCGVariable()
		 * @generated
		 */
		EClass TCG_VARIABLE = eINSTANCE.getTCGVariable();

		/**
		 * The meta object literal for the '<em><b>Referenced By</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TCG_VARIABLE__REFERENCED_BY = eINSTANCE.getTCGVariable_ReferencedBy();

		/**
		 * The meta object literal for the '<em><b>Is Parameter</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TCG_VARIABLE__IS_PARAMETER = eINSTANCE.getTCGVariable_IsParameter();

		/**
		 * The meta object literal for the '{@link org.xilaew.atg.model.activityTestCaseGraph.impl.TCGObjectVariableImpl <em>TCG Object Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xilaew.atg.model.activityTestCaseGraph.impl.TCGObjectVariableImpl
		 * @see org.xilaew.atg.model.activityTestCaseGraph.impl.ActivityTestCaseGraphPackageImpl#getTCGObjectVariable()
		 * @generated
		 */
		EClass TCG_OBJECT_VARIABLE = eINSTANCE.getTCGObjectVariable();

		/**
		 * The meta object literal for the '<em><b>Fields</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TCG_OBJECT_VARIABLE__FIELDS = eINSTANCE.getTCGObjectVariable_Fields();

		/**
		 * The meta object literal for the '{@link org.xilaew.atg.model.activityTestCaseGraph.impl.TCGBasicVariableImpl <em>TCG Basic Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xilaew.atg.model.activityTestCaseGraph.impl.TCGBasicVariableImpl
		 * @see org.xilaew.atg.model.activityTestCaseGraph.impl.ActivityTestCaseGraphPackageImpl#getTCGBasicVariable()
		 * @generated
		 */
		EClass TCG_BASIC_VARIABLE = eINSTANCE.getTCGBasicVariable();

		/**
		 * The meta object literal for the '<em><b>Variable Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TCG_BASIC_VARIABLE__VARIABLE_TYPE = eINSTANCE.getTCGBasicVariable_VariableType();

		/**
		 * The meta object literal for the '<em><b>Get Absolute Name</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TCG_BASIC_VARIABLE___GET_ABSOLUTE_NAME = eINSTANCE.getTCGBasicVariable__GetAbsoluteName();

		/**
		 * The meta object literal for the '{@link org.xilaew.atg.model.activityTestCaseGraph.impl.TCGOCLExpressionImpl <em>TCGOCL Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xilaew.atg.model.activityTestCaseGraph.impl.TCGOCLExpressionImpl
		 * @see org.xilaew.atg.model.activityTestCaseGraph.impl.ActivityTestCaseGraphPackageImpl#getTCGOCLExpression()
		 * @generated
		 */
		EClass TCGOCL_EXPRESSION = eINSTANCE.getTCGOCLExpression();

		/**
		 * The meta object literal for the '{@link org.xilaew.atg.model.activityTestCaseGraph.impl.TCGOCLOperationCallExpImpl <em>TCGOCL Operation Call Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xilaew.atg.model.activityTestCaseGraph.impl.TCGOCLOperationCallExpImpl
		 * @see org.xilaew.atg.model.activityTestCaseGraph.impl.ActivityTestCaseGraphPackageImpl#getTCGOCLOperationCallExp()
		 * @generated
		 */
		EClass TCGOCL_OPERATION_CALL_EXP = eINSTANCE.getTCGOCLOperationCallExp();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TCGOCL_OPERATION_CALL_EXP__SOURCE = eINSTANCE.getTCGOCLOperationCallExp_Source();

		/**
		 * The meta object literal for the '<em><b>Arguments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TCGOCL_OPERATION_CALL_EXP__ARGUMENTS = eINSTANCE.getTCGOCLOperationCallExp_Arguments();

		/**
		 * The meta object literal for the '<em><b>Operation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TCGOCL_OPERATION_CALL_EXP__OPERATION = eINSTANCE.getTCGOCLOperationCallExp_Operation();

		/**
		 * The meta object literal for the '{@link org.xilaew.atg.model.activityTestCaseGraph.impl.TCGOCLVariableCallExpImpl <em>TCGOCL Variable Call Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xilaew.atg.model.activityTestCaseGraph.impl.TCGOCLVariableCallExpImpl
		 * @see org.xilaew.atg.model.activityTestCaseGraph.impl.ActivityTestCaseGraphPackageImpl#getTCGOCLVariableCallExp()
		 * @generated
		 */
		EClass TCGOCL_VARIABLE_CALL_EXP = eINSTANCE.getTCGOCLVariableCallExp();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TCGOCL_VARIABLE_CALL_EXP__VARIABLE = eINSTANCE.getTCGOCLVariableCallExp_Variable();

		/**
		 * The meta object literal for the '<em><b>Is Pre</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TCGOCL_VARIABLE_CALL_EXP__IS_PRE = eINSTANCE.getTCGOCLVariableCallExp_IsPre();

		/**
		 * The meta object literal for the '{@link org.xilaew.atg.model.activityTestCaseGraph.impl.TCGOCLLiteralExpImpl <em>TCGOCL Literal Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xilaew.atg.model.activityTestCaseGraph.impl.TCGOCLLiteralExpImpl
		 * @see org.xilaew.atg.model.activityTestCaseGraph.impl.ActivityTestCaseGraphPackageImpl#getTCGOCLLiteralExp()
		 * @generated
		 */
		EClass TCGOCL_LITERAL_EXP = eINSTANCE.getTCGOCLLiteralExp();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TCGOCL_LITERAL_EXP__TYPE = eINSTANCE.getTCGOCLLiteralExp_Type();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TCGOCL_LITERAL_EXP__VALUE = eINSTANCE.getTCGOCLLiteralExp_Value();

		/**
		 * The meta object literal for the '{@link org.xilaew.atg.model.activityTestCaseGraph.TCGBasicVariableType <em>TCG Basic Variable Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xilaew.atg.model.activityTestCaseGraph.TCGBasicVariableType
		 * @see org.xilaew.atg.model.activityTestCaseGraph.impl.ActivityTestCaseGraphPackageImpl#getTCGBasicVariableType()
		 * @generated
		 */
		EEnum TCG_BASIC_VARIABLE_TYPE = eINSTANCE.getTCGBasicVariableType();

		/**
		 * The meta object literal for the '{@link org.xilaew.atg.model.activityTestCaseGraph.TCGOCLOperationType <em>TCGOCL Operation Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xilaew.atg.model.activityTestCaseGraph.TCGOCLOperationType
		 * @see org.xilaew.atg.model.activityTestCaseGraph.impl.ActivityTestCaseGraphPackageImpl#getTCGOCLOperationType()
		 * @generated
		 */
		EEnum TCGOCL_OPERATION_TYPE = eINSTANCE.getTCGOCLOperationType();

	}

} //ActivityTestCaseGraphPackage
