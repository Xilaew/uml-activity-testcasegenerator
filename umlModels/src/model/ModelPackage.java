/**
 */
package model;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

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
 * @see model.ModelFactory
 * @model kind="package"
 * @generated
 */
public interface ModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "model";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///model.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "model";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModelPackage eINSTANCE = model.impl.ModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link model.impl.testActivityImpl <em>test Activity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.testActivityImpl
	 * @see model.impl.ModelPackageImpl#gettestActivity()
	 * @generated
	 */
	int TEST_ACTIVITY = 0;

	/**
	 * The number of structural features of the '<em>test Activity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_ACTIVITY_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>test Activity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_ACTIVITY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link model.impl.Activity1Impl <em>Activity1</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.Activity1Impl
	 * @see model.impl.ModelPackageImpl#getActivity1()
	 * @generated
	 */
	int ACTIVITY1 = 1;

	/**
	 * The number of structural features of the '<em>Activity1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY1_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Activity1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY1_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link model.testActivity <em>test Activity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>test Activity</em>'.
	 * @see model.testActivity
	 * @generated
	 */
	EClass gettestActivity();

	/**
	 * Returns the meta object for class '{@link model.Activity1 <em>Activity1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Activity1</em>'.
	 * @see model.Activity1
	 * @generated
	 */
	EClass getActivity1();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ModelFactory getModelFactory();

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
		 * The meta object literal for the '{@link model.impl.testActivityImpl <em>test Activity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.testActivityImpl
		 * @see model.impl.ModelPackageImpl#gettestActivity()
		 * @generated
		 */
		EClass TEST_ACTIVITY = eINSTANCE.gettestActivity();

		/**
		 * The meta object literal for the '{@link model.impl.Activity1Impl <em>Activity1</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.Activity1Impl
		 * @see model.impl.ModelPackageImpl#getActivity1()
		 * @generated
		 */
		EClass ACTIVITY1 = eINSTANCE.getActivity1();

	}

} //ModelPackage
