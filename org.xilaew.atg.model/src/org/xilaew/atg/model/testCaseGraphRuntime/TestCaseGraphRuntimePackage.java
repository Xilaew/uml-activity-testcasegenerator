/**
 */
package org.xilaew.atg.model.testCaseGraphRuntime;

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
 * @see org.xilaew.atg.model.testCaseGraphRuntime.TestCaseGraphRuntimeFactory
 * @model kind="package"
 * @generated
 */
public interface TestCaseGraphRuntimePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "testCaseGraphRuntime";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://org.xilaew.atg.model.TestCaseGraphRuntime";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.xilaew.atg.model.TestCaseGraphRuntime";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TestCaseGraphRuntimePackage eINSTANCE = org.xilaew.atg.model.testCaseGraphRuntime.impl.TestCaseGraphRuntimePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.xilaew.atg.model.testCaseGraphRuntime.impl.PathImpl <em>Path</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xilaew.atg.model.testCaseGraphRuntime.impl.PathImpl
	 * @see org.xilaew.atg.model.testCaseGraphRuntime.impl.TestCaseGraphRuntimePackageImpl#getPath()
	 * @generated
	 */
	int PATH = 0;

	/**
	 * The feature id for the '<em><b>Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH__EDGES = 0;

	/**
	 * The number of structural features of the '<em>Path</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Path</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link org.xilaew.atg.model.testCaseGraphRuntime.Path <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Path</em>'.
	 * @see org.xilaew.atg.model.testCaseGraphRuntime.Path
	 * @generated
	 */
	EClass getPath();

	/**
	 * Returns the meta object for the reference list '{@link org.xilaew.atg.model.testCaseGraphRuntime.Path#getEdges <em>Edges</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Edges</em>'.
	 * @see org.xilaew.atg.model.testCaseGraphRuntime.Path#getEdges()
	 * @see #getPath()
	 * @generated
	 */
	EReference getPath_Edges();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TestCaseGraphRuntimeFactory getTestCaseGraphRuntimeFactory();

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
		 * The meta object literal for the '{@link org.xilaew.atg.model.testCaseGraphRuntime.impl.PathImpl <em>Path</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xilaew.atg.model.testCaseGraphRuntime.impl.PathImpl
		 * @see org.xilaew.atg.model.testCaseGraphRuntime.impl.TestCaseGraphRuntimePackageImpl#getPath()
		 * @generated
		 */
		EClass PATH = eINSTANCE.getPath();

		/**
		 * The meta object literal for the '<em><b>Edges</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATH__EDGES = eINSTANCE.getPath_Edges();

	}

} //TestCaseGraphRuntimePackage
