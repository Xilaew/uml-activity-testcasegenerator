/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.sf.parteg.base.testsuiteexport;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see net.sf.parteg.base.testsuiteexport.TestsuiteexportFactory
 * @model kind="package"
 * @generated
 */
public interface TestsuiteexportPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "testsuiteexport";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "testsuiteexport";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "tse";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TestsuiteexportPackage eINSTANCE = net.sf.parteg.base.testsuiteexport.impl.TestsuiteexportPackageImpl.init();

	/**
	 * The meta object id for the '{@link net.sf.parteg.base.testsuiteexport.impl.TSImpl <em>TS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.sf.parteg.base.testsuiteexport.impl.TSImpl
	 * @see net.sf.parteg.base.testsuiteexport.impl.TestsuiteexportPackageImpl#getTS()
	 * @generated
	 */
	int TS = 0;

	/**
	 * The feature id for the '<em><b>Tc</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TS__TC = 0;

	/**
	 * The number of structural features of the '<em>TS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TS_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link net.sf.parteg.base.testsuiteexport.impl.TCImpl <em>TC</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.sf.parteg.base.testsuiteexport.impl.TCImpl
	 * @see net.sf.parteg.base.testsuiteexport.impl.TestsuiteexportPackageImpl#getTC()
	 * @generated
	 */
	int TC = 1;

	/**
	 * The feature id for the '<em><b>Define</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TC__DEFINE = 0;

	/**
	 * The feature id for the '<em><b>Assign</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TC__ASSIGN = 1;

	/**
	 * The feature id for the '<em><b>Action</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TC__ACTION = 2;

	/**
	 * The number of structural features of the '<em>TC</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TC_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link net.sf.parteg.base.testsuiteexport.impl.VariableImpl <em>Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.sf.parteg.base.testsuiteexport.impl.VariableImpl
	 * @see net.sf.parteg.base.testsuiteexport.impl.TestsuiteexportPackageImpl#getVariable()
	 * @generated
	 */
	int VARIABLE = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__TYPE = 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__VALUE = 2;

	/**
	 * The number of structural features of the '<em>Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link net.sf.parteg.base.testsuiteexport.impl.ActionImpl <em>Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.sf.parteg.base.testsuiteexport.impl.ActionImpl
	 * @see net.sf.parteg.base.testsuiteexport.impl.TestsuiteexportPackageImpl#getAction()
	 * @generated
	 */
	int ACTION = 5;

	/**
	 * The number of structural features of the '<em>Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link net.sf.parteg.base.testsuiteexport.impl.CallImpl <em>Call</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.sf.parteg.base.testsuiteexport.impl.CallImpl
	 * @see net.sf.parteg.base.testsuiteexport.impl.TestsuiteexportPackageImpl#getCall()
	 * @generated
	 */
	int CALL = 3;

	/**
	 * The feature id for the '<em><b>Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL__OBJECT = ACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Event</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL__EVENT = ACTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Param</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL__PARAM = ACTION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_FEATURE_COUNT = ACTION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link net.sf.parteg.base.testsuiteexport.impl.CheckImpl <em>Check</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.sf.parteg.base.testsuiteexport.impl.CheckImpl
	 * @see net.sf.parteg.base.testsuiteexport.impl.TestsuiteexportPackageImpl#getCheck()
	 * @generated
	 */
	int CHECK = 4;

	/**
	 * The feature id for the '<em><b>Simple Exp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK__SIMPLE_EXP = ACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Complex Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK__COMPLEX_EXP = ACTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Check</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK_FEATURE_COUNT = ACTION_FEATURE_COUNT + 2;


	/**
	 * The meta object id for the '{@link net.sf.parteg.base.testsuiteexport.impl.ExpImpl <em>Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.sf.parteg.base.testsuiteexport.impl.ExpImpl
	 * @see net.sf.parteg.base.testsuiteexport.impl.TestsuiteexportPackageImpl#getExp()
	 * @generated
	 */
	int EXP = 6;

	/**
	 * The number of structural features of the '<em>Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXP_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link net.sf.parteg.base.testsuiteexport.impl.AtomImpl <em>Atom</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.sf.parteg.base.testsuiteexport.impl.AtomImpl
	 * @see net.sf.parteg.base.testsuiteexport.impl.TestsuiteexportPackageImpl#getAtom()
	 * @generated
	 */
	int ATOM = 7;

	/**
	 * The feature id for the '<em><b>Exp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOM__EXP = EXP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Atom</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOM_FEATURE_COUNT = EXP_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link net.sf.parteg.base.testsuiteexport.impl.ComplexImpl <em>Complex</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.sf.parteg.base.testsuiteexport.impl.ComplexImpl
	 * @see net.sf.parteg.base.testsuiteexport.impl.TestsuiteexportPackageImpl#getComplex()
	 * @generated
	 */
	int COMPLEX = 8;

	/**
	 * The feature id for the '<em><b>Op</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX__OP = EXP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>First</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX__FIRST = EXP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Second</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX__SECOND = EXP_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Complex</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_FEATURE_COUNT = EXP_FEATURE_COUNT + 3;


	/**
	 * Returns the meta object for class '{@link net.sf.parteg.base.testsuiteexport.TS <em>TS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TS</em>'.
	 * @see net.sf.parteg.base.testsuiteexport.TS
	 * @generated
	 */
	EClass getTS();

	/**
	 * Returns the meta object for the containment reference list '{@link net.sf.parteg.base.testsuiteexport.TS#getTc <em>Tc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tc</em>'.
	 * @see net.sf.parteg.base.testsuiteexport.TS#getTc()
	 * @see #getTS()
	 * @generated
	 */
	EReference getTS_Tc();

	/**
	 * Returns the meta object for class '{@link net.sf.parteg.base.testsuiteexport.TC <em>TC</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TC</em>'.
	 * @see net.sf.parteg.base.testsuiteexport.TC
	 * @generated
	 */
	EClass getTC();

	/**
	 * Returns the meta object for the containment reference list '{@link net.sf.parteg.base.testsuiteexport.TC#getDefine <em>Define</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Define</em>'.
	 * @see net.sf.parteg.base.testsuiteexport.TC#getDefine()
	 * @see #getTC()
	 * @generated
	 */
	EReference getTC_Define();

	/**
	 * Returns the meta object for the containment reference list '{@link net.sf.parteg.base.testsuiteexport.TC#getAssign <em>Assign</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Assign</em>'.
	 * @see net.sf.parteg.base.testsuiteexport.TC#getAssign()
	 * @see #getTC()
	 * @generated
	 */
	EReference getTC_Assign();

	/**
	 * Returns the meta object for the containment reference list '{@link net.sf.parteg.base.testsuiteexport.TC#getAction <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Action</em>'.
	 * @see net.sf.parteg.base.testsuiteexport.TC#getAction()
	 * @see #getTC()
	 * @generated
	 */
	EReference getTC_Action();

	/**
	 * Returns the meta object for class '{@link net.sf.parteg.base.testsuiteexport.Variable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable</em>'.
	 * @see net.sf.parteg.base.testsuiteexport.Variable
	 * @generated
	 */
	EClass getVariable();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.parteg.base.testsuiteexport.Variable#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see net.sf.parteg.base.testsuiteexport.Variable#getName()
	 * @see #getVariable()
	 * @generated
	 */
	EAttribute getVariable_Name();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.parteg.base.testsuiteexport.Variable#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see net.sf.parteg.base.testsuiteexport.Variable#getType()
	 * @see #getVariable()
	 * @generated
	 */
	EAttribute getVariable_Type();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.parteg.base.testsuiteexport.Variable#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see net.sf.parteg.base.testsuiteexport.Variable#getValue()
	 * @see #getVariable()
	 * @generated
	 */
	EAttribute getVariable_Value();

	/**
	 * Returns the meta object for class '{@link net.sf.parteg.base.testsuiteexport.Call <em>Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Call</em>'.
	 * @see net.sf.parteg.base.testsuiteexport.Call
	 * @generated
	 */
	EClass getCall();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.parteg.base.testsuiteexport.Call#getObject <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Object</em>'.
	 * @see net.sf.parteg.base.testsuiteexport.Call#getObject()
	 * @see #getCall()
	 * @generated
	 */
	EAttribute getCall_Object();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.parteg.base.testsuiteexport.Call#getEvent <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Event</em>'.
	 * @see net.sf.parteg.base.testsuiteexport.Call#getEvent()
	 * @see #getCall()
	 * @generated
	 */
	EAttribute getCall_Event();

	/**
	 * Returns the meta object for the attribute list '{@link net.sf.parteg.base.testsuiteexport.Call#getParam <em>Param</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Param</em>'.
	 * @see net.sf.parteg.base.testsuiteexport.Call#getParam()
	 * @see #getCall()
	 * @generated
	 */
	EAttribute getCall_Param();

	/**
	 * Returns the meta object for class '{@link net.sf.parteg.base.testsuiteexport.Check <em>Check</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Check</em>'.
	 * @see net.sf.parteg.base.testsuiteexport.Check
	 * @generated
	 */
	EClass getCheck();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.parteg.base.testsuiteexport.Check#getSimpleExp <em>Simple Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Simple Exp</em>'.
	 * @see net.sf.parteg.base.testsuiteexport.Check#getSimpleExp()
	 * @see #getCheck()
	 * @generated
	 */
	EAttribute getCheck_SimpleExp();

	/**
	 * Returns the meta object for the containment reference '{@link net.sf.parteg.base.testsuiteexport.Check#getComplexExp <em>Complex Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Complex Exp</em>'.
	 * @see net.sf.parteg.base.testsuiteexport.Check#getComplexExp()
	 * @see #getCheck()
	 * @generated
	 */
	EReference getCheck_ComplexExp();

	/**
	 * Returns the meta object for class '{@link net.sf.parteg.base.testsuiteexport.Action <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action</em>'.
	 * @see net.sf.parteg.base.testsuiteexport.Action
	 * @generated
	 */
	EClass getAction();

	/**
	 * Returns the meta object for class '{@link net.sf.parteg.base.testsuiteexport.Exp <em>Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Exp</em>'.
	 * @see net.sf.parteg.base.testsuiteexport.Exp
	 * @generated
	 */
	EClass getExp();

	/**
	 * Returns the meta object for class '{@link net.sf.parteg.base.testsuiteexport.Atom <em>Atom</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Atom</em>'.
	 * @see net.sf.parteg.base.testsuiteexport.Atom
	 * @generated
	 */
	EClass getAtom();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.parteg.base.testsuiteexport.Atom#getExp <em>Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Exp</em>'.
	 * @see net.sf.parteg.base.testsuiteexport.Atom#getExp()
	 * @see #getAtom()
	 * @generated
	 */
	EAttribute getAtom_Exp();

	/**
	 * Returns the meta object for class '{@link net.sf.parteg.base.testsuiteexport.Complex <em>Complex</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Complex</em>'.
	 * @see net.sf.parteg.base.testsuiteexport.Complex
	 * @generated
	 */
	EClass getComplex();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.parteg.base.testsuiteexport.Complex#getOp <em>Op</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Op</em>'.
	 * @see net.sf.parteg.base.testsuiteexport.Complex#getOp()
	 * @see #getComplex()
	 * @generated
	 */
	EAttribute getComplex_Op();

	/**
	 * Returns the meta object for the containment reference '{@link net.sf.parteg.base.testsuiteexport.Complex#getFirst <em>First</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>First</em>'.
	 * @see net.sf.parteg.base.testsuiteexport.Complex#getFirst()
	 * @see #getComplex()
	 * @generated
	 */
	EReference getComplex_First();

	/**
	 * Returns the meta object for the containment reference '{@link net.sf.parteg.base.testsuiteexport.Complex#getSecond <em>Second</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Second</em>'.
	 * @see net.sf.parteg.base.testsuiteexport.Complex#getSecond()
	 * @see #getComplex()
	 * @generated
	 */
	EReference getComplex_Second();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TestsuiteexportFactory getTestsuiteexportFactory();

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
		 * The meta object literal for the '{@link net.sf.parteg.base.testsuiteexport.impl.TSImpl <em>TS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.sf.parteg.base.testsuiteexport.impl.TSImpl
		 * @see net.sf.parteg.base.testsuiteexport.impl.TestsuiteexportPackageImpl#getTS()
		 * @generated
		 */
		EClass TS = eINSTANCE.getTS();

		/**
		 * The meta object literal for the '<em><b>Tc</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TS__TC = eINSTANCE.getTS_Tc();

		/**
		 * The meta object literal for the '{@link net.sf.parteg.base.testsuiteexport.impl.TCImpl <em>TC</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.sf.parteg.base.testsuiteexport.impl.TCImpl
		 * @see net.sf.parteg.base.testsuiteexport.impl.TestsuiteexportPackageImpl#getTC()
		 * @generated
		 */
		EClass TC = eINSTANCE.getTC();

		/**
		 * The meta object literal for the '<em><b>Define</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TC__DEFINE = eINSTANCE.getTC_Define();

		/**
		 * The meta object literal for the '<em><b>Assign</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TC__ASSIGN = eINSTANCE.getTC_Assign();

		/**
		 * The meta object literal for the '<em><b>Action</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TC__ACTION = eINSTANCE.getTC_Action();

		/**
		 * The meta object literal for the '{@link net.sf.parteg.base.testsuiteexport.impl.VariableImpl <em>Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.sf.parteg.base.testsuiteexport.impl.VariableImpl
		 * @see net.sf.parteg.base.testsuiteexport.impl.TestsuiteexportPackageImpl#getVariable()
		 * @generated
		 */
		EClass VARIABLE = eINSTANCE.getVariable();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE__NAME = eINSTANCE.getVariable_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE__TYPE = eINSTANCE.getVariable_Type();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE__VALUE = eINSTANCE.getVariable_Value();

		/**
		 * The meta object literal for the '{@link net.sf.parteg.base.testsuiteexport.impl.CallImpl <em>Call</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.sf.parteg.base.testsuiteexport.impl.CallImpl
		 * @see net.sf.parteg.base.testsuiteexport.impl.TestsuiteexportPackageImpl#getCall()
		 * @generated
		 */
		EClass CALL = eINSTANCE.getCall();

		/**
		 * The meta object literal for the '<em><b>Object</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CALL__OBJECT = eINSTANCE.getCall_Object();

		/**
		 * The meta object literal for the '<em><b>Event</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CALL__EVENT = eINSTANCE.getCall_Event();

		/**
		 * The meta object literal for the '<em><b>Param</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CALL__PARAM = eINSTANCE.getCall_Param();

		/**
		 * The meta object literal for the '{@link net.sf.parteg.base.testsuiteexport.impl.CheckImpl <em>Check</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.sf.parteg.base.testsuiteexport.impl.CheckImpl
		 * @see net.sf.parteg.base.testsuiteexport.impl.TestsuiteexportPackageImpl#getCheck()
		 * @generated
		 */
		EClass CHECK = eINSTANCE.getCheck();

		/**
		 * The meta object literal for the '<em><b>Simple Exp</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CHECK__SIMPLE_EXP = eINSTANCE.getCheck_SimpleExp();

		/**
		 * The meta object literal for the '<em><b>Complex Exp</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHECK__COMPLEX_EXP = eINSTANCE.getCheck_ComplexExp();

		/**
		 * The meta object literal for the '{@link net.sf.parteg.base.testsuiteexport.impl.ActionImpl <em>Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.sf.parteg.base.testsuiteexport.impl.ActionImpl
		 * @see net.sf.parteg.base.testsuiteexport.impl.TestsuiteexportPackageImpl#getAction()
		 * @generated
		 */
		EClass ACTION = eINSTANCE.getAction();

		/**
		 * The meta object literal for the '{@link net.sf.parteg.base.testsuiteexport.impl.ExpImpl <em>Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.sf.parteg.base.testsuiteexport.impl.ExpImpl
		 * @see net.sf.parteg.base.testsuiteexport.impl.TestsuiteexportPackageImpl#getExp()
		 * @generated
		 */
		EClass EXP = eINSTANCE.getExp();

		/**
		 * The meta object literal for the '{@link net.sf.parteg.base.testsuiteexport.impl.AtomImpl <em>Atom</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.sf.parteg.base.testsuiteexport.impl.AtomImpl
		 * @see net.sf.parteg.base.testsuiteexport.impl.TestsuiteexportPackageImpl#getAtom()
		 * @generated
		 */
		EClass ATOM = eINSTANCE.getAtom();

		/**
		 * The meta object literal for the '<em><b>Exp</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATOM__EXP = eINSTANCE.getAtom_Exp();

		/**
		 * The meta object literal for the '{@link net.sf.parteg.base.testsuiteexport.impl.ComplexImpl <em>Complex</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.sf.parteg.base.testsuiteexport.impl.ComplexImpl
		 * @see net.sf.parteg.base.testsuiteexport.impl.TestsuiteexportPackageImpl#getComplex()
		 * @generated
		 */
		EClass COMPLEX = eINSTANCE.getComplex();

		/**
		 * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPLEX__OP = eINSTANCE.getComplex_Op();

		/**
		 * The meta object literal for the '<em><b>First</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPLEX__FIRST = eINSTANCE.getComplex_First();

		/**
		 * The meta object literal for the '<em><b>Second</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPLEX__SECOND = eINSTANCE.getComplex_Second();

	}

} //TestsuiteexportPackage
