/**
 */
package model.package1;

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
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see model.package1.Package1Factory
 * @model kind="package"
 * @generated
 */
public interface Package1Package extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "package1";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///model/package1.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "model.package1";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Package1Package eINSTANCE = model.package1.impl.Package1PackageImpl.init();

	/**
	 * The meta object id for the '{@link model.package1.impl.class1Impl <em>class1</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.package1.impl.class1Impl
	 * @see model.package1.impl.Package1PackageImpl#getclass1()
	 * @generated
	 */
	int CLASS1 = 0;

	/**
	 * The feature id for the '<em><b>Attribute1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS1__ATTRIBUTE1 = 0;

	/**
	 * The number of structural features of the '<em>class1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS1_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>class1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS1_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link model.package1.impl.type1Impl <em>type1</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.package1.impl.type1Impl
	 * @see model.package1.impl.Package1PackageImpl#gettype1()
	 * @generated
	 */
	int TYPE1 = 1;

	/**
	 * The number of structural features of the '<em>type1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE1_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>type1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE1_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link model.package1.impl.class1_testActivityImpl <em>class1 test Activity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.package1.impl.class1_testActivityImpl
	 * @see model.package1.impl.Package1PackageImpl#getclass1_testActivity()
	 * @generated
	 */
	int CLASS1_TEST_ACTIVITY = 2;

	/**
	 * The number of structural features of the '<em>class1 test Activity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS1_TEST_ACTIVITY_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>class1 test Activity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS1_TEST_ACTIVITY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link model.package1.impl.class2Impl <em>class2</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.package1.impl.class2Impl
	 * @see model.package1.impl.Package1PackageImpl#getclass2()
	 * @generated
	 */
	int CLASS2 = 3;

	/**
	 * The feature id for the '<em><b>Attribute1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS2__ATTRIBUTE1 = CLASS1__ATTRIBUTE1;

	/**
	 * The feature id for the '<em><b>Attribute2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS2__ATTRIBUTE2 = CLASS1_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>class2</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS2_FEATURE_COUNT = CLASS1_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>class2</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS2_OPERATION_COUNT = CLASS1_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link model.package1.impl.type2Impl <em>type2</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.package1.impl.type2Impl
	 * @see model.package1.impl.Package1PackageImpl#gettype2()
	 * @generated
	 */
	int TYPE2 = 4;

	/**
	 * The number of structural features of the '<em>type2</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE2_FEATURE_COUNT = TYPE1_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>type2</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE2_OPERATION_COUNT = TYPE1_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link model.package1.class1 <em>class1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>class1</em>'.
	 * @see model.package1.class1
	 * @generated
	 */
	EClass getclass1();

	/**
	 * Returns the meta object for the reference '{@link model.package1.class1#getAttribute1 <em>Attribute1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Attribute1</em>'.
	 * @see model.package1.class1#getAttribute1()
	 * @see #getclass1()
	 * @generated
	 */
	EReference getclass1_Attribute1();

	/**
	 * Returns the meta object for class '{@link model.package1.type1 <em>type1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>type1</em>'.
	 * @see model.package1.type1
	 * @generated
	 */
	EClass gettype1();

	/**
	 * Returns the meta object for class '{@link model.package1.class1_testActivity <em>class1 test Activity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>class1 test Activity</em>'.
	 * @see model.package1.class1_testActivity
	 * @generated
	 */
	EClass getclass1_testActivity();

	/**
	 * Returns the meta object for class '{@link model.package1.class2 <em>class2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>class2</em>'.
	 * @see model.package1.class2
	 * @generated
	 */
	EClass getclass2();

	/**
	 * Returns the meta object for the reference '{@link model.package1.class2#getAttribute2 <em>Attribute2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Attribute2</em>'.
	 * @see model.package1.class2#getAttribute2()
	 * @see #getclass2()
	 * @generated
	 */
	EReference getclass2_Attribute2();

	/**
	 * Returns the meta object for class '{@link model.package1.type2 <em>type2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>type2</em>'.
	 * @see model.package1.type2
	 * @generated
	 */
	EClass gettype2();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	Package1Factory getPackage1Factory();

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
		 * The meta object literal for the '{@link model.package1.impl.class1Impl <em>class1</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.package1.impl.class1Impl
		 * @see model.package1.impl.Package1PackageImpl#getclass1()
		 * @generated
		 */
		EClass CLASS1 = eINSTANCE.getclass1();

		/**
		 * The meta object literal for the '<em><b>Attribute1</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS1__ATTRIBUTE1 = eINSTANCE.getclass1_Attribute1();

		/**
		 * The meta object literal for the '{@link model.package1.impl.type1Impl <em>type1</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.package1.impl.type1Impl
		 * @see model.package1.impl.Package1PackageImpl#gettype1()
		 * @generated
		 */
		EClass TYPE1 = eINSTANCE.gettype1();

		/**
		 * The meta object literal for the '{@link model.package1.impl.class1_testActivityImpl <em>class1 test Activity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.package1.impl.class1_testActivityImpl
		 * @see model.package1.impl.Package1PackageImpl#getclass1_testActivity()
		 * @generated
		 */
		EClass CLASS1_TEST_ACTIVITY = eINSTANCE.getclass1_testActivity();

		/**
		 * The meta object literal for the '{@link model.package1.impl.class2Impl <em>class2</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.package1.impl.class2Impl
		 * @see model.package1.impl.Package1PackageImpl#getclass2()
		 * @generated
		 */
		EClass CLASS2 = eINSTANCE.getclass2();

		/**
		 * The meta object literal for the '<em><b>Attribute2</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS2__ATTRIBUTE2 = eINSTANCE.getclass2_Attribute2();

		/**
		 * The meta object literal for the '{@link model.package1.impl.type2Impl <em>type2</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.package1.impl.type2Impl
		 * @see model.package1.impl.Package1PackageImpl#gettype2()
		 * @generated
		 */
		EClass TYPE2 = eINSTANCE.gettype2();

	}

} //Package1Package
