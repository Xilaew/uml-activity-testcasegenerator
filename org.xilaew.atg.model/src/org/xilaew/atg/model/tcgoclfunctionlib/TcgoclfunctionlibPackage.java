/**
 */
package org.xilaew.atg.model.tcgoclfunctionlib;

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
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.xilaew.atg.model.tcgoclfunctionlib.TcgoclfunctionlibFactory
 * @model kind="package"
 * @generated
 */
public interface TcgoclfunctionlibPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "tcgoclfunctionlib";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://org.xilaew.atg.model.tcgoclfunctionlib";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.xilaew.atg.model.tcgoclfunctionlib";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TcgoclfunctionlibPackage eINSTANCE = org.xilaew.atg.model.tcgoclfunctionlib.impl.TcgoclfunctionlibPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.xilaew.atg.model.tcgoclfunctionlib.impl.FunctionLibraryImpl <em>Function Library</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xilaew.atg.model.tcgoclfunctionlib.impl.FunctionLibraryImpl
	 * @see org.xilaew.atg.model.tcgoclfunctionlib.impl.TcgoclfunctionlibPackageImpl#getFunctionLibrary()
	 * @generated
	 */
	int FUNCTION_LIBRARY = 0;

	/**
	 * The feature id for the '<em><b>Function</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_LIBRARY__FUNCTION = 0;

	/**
	 * The number of structural features of the '<em>Function Library</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_LIBRARY_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Function Library</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_LIBRARY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.xilaew.atg.model.tcgoclfunctionlib.impl.TcgOclFunctionImpl <em>Tcg Ocl Function</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xilaew.atg.model.tcgoclfunctionlib.impl.TcgOclFunctionImpl
	 * @see org.xilaew.atg.model.tcgoclfunctionlib.impl.TcgoclfunctionlibPackageImpl#getTcgOclFunction()
	 * @generated
	 */
	int TCG_OCL_FUNCTION = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_OCL_FUNCTION__NAME = 0;

	/**
	 * The feature id for the '<em><b>Ampl Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_OCL_FUNCTION__AMPL_LITERAL = 1;

	/**
	 * The feature id for the '<em><b>Ocl Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_OCL_FUNCTION__OCL_LITERAL = 2;

	/**
	 * The feature id for the '<em><b>Ampl Close Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_OCL_FUNCTION__AMPL_CLOSE_LITERAL = 3;

	/**
	 * The number of structural features of the '<em>Tcg Ocl Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_OCL_FUNCTION_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Tcg Ocl Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCG_OCL_FUNCTION_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link org.xilaew.atg.model.tcgoclfunctionlib.FunctionLibrary <em>Function Library</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Function Library</em>'.
	 * @see org.xilaew.atg.model.tcgoclfunctionlib.FunctionLibrary
	 * @generated
	 */
	EClass getFunctionLibrary();

	/**
	 * Returns the meta object for the containment reference list '{@link org.xilaew.atg.model.tcgoclfunctionlib.FunctionLibrary#getFunction <em>Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Function</em>'.
	 * @see org.xilaew.atg.model.tcgoclfunctionlib.FunctionLibrary#getFunction()
	 * @see #getFunctionLibrary()
	 * @generated
	 */
	EReference getFunctionLibrary_Function();

	/**
	 * Returns the meta object for class '{@link org.xilaew.atg.model.tcgoclfunctionlib.TcgOclFunction <em>Tcg Ocl Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tcg Ocl Function</em>'.
	 * @see org.xilaew.atg.model.tcgoclfunctionlib.TcgOclFunction
	 * @generated
	 */
	EClass getTcgOclFunction();

	/**
	 * Returns the meta object for the attribute '{@link org.xilaew.atg.model.tcgoclfunctionlib.TcgOclFunction#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.xilaew.atg.model.tcgoclfunctionlib.TcgOclFunction#getName()
	 * @see #getTcgOclFunction()
	 * @generated
	 */
	EAttribute getTcgOclFunction_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.xilaew.atg.model.tcgoclfunctionlib.TcgOclFunction#getAmplLiteral <em>Ampl Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ampl Literal</em>'.
	 * @see org.xilaew.atg.model.tcgoclfunctionlib.TcgOclFunction#getAmplLiteral()
	 * @see #getTcgOclFunction()
	 * @generated
	 */
	EAttribute getTcgOclFunction_AmplLiteral();

	/**
	 * Returns the meta object for the attribute '{@link org.xilaew.atg.model.tcgoclfunctionlib.TcgOclFunction#getOclLiteral <em>Ocl Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ocl Literal</em>'.
	 * @see org.xilaew.atg.model.tcgoclfunctionlib.TcgOclFunction#getOclLiteral()
	 * @see #getTcgOclFunction()
	 * @generated
	 */
	EAttribute getTcgOclFunction_OclLiteral();

	/**
	 * Returns the meta object for the attribute '{@link org.xilaew.atg.model.tcgoclfunctionlib.TcgOclFunction#getAmplCloseLiteral <em>Ampl Close Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ampl Close Literal</em>'.
	 * @see org.xilaew.atg.model.tcgoclfunctionlib.TcgOclFunction#getAmplCloseLiteral()
	 * @see #getTcgOclFunction()
	 * @generated
	 */
	EAttribute getTcgOclFunction_AmplCloseLiteral();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TcgoclfunctionlibFactory getTcgoclfunctionlibFactory();

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
		 * The meta object literal for the '{@link org.xilaew.atg.model.tcgoclfunctionlib.impl.FunctionLibraryImpl <em>Function Library</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xilaew.atg.model.tcgoclfunctionlib.impl.FunctionLibraryImpl
		 * @see org.xilaew.atg.model.tcgoclfunctionlib.impl.TcgoclfunctionlibPackageImpl#getFunctionLibrary()
		 * @generated
		 */
		EClass FUNCTION_LIBRARY = eINSTANCE.getFunctionLibrary();

		/**
		 * The meta object literal for the '<em><b>Function</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION_LIBRARY__FUNCTION = eINSTANCE.getFunctionLibrary_Function();

		/**
		 * The meta object literal for the '{@link org.xilaew.atg.model.tcgoclfunctionlib.impl.TcgOclFunctionImpl <em>Tcg Ocl Function</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xilaew.atg.model.tcgoclfunctionlib.impl.TcgOclFunctionImpl
		 * @see org.xilaew.atg.model.tcgoclfunctionlib.impl.TcgoclfunctionlibPackageImpl#getTcgOclFunction()
		 * @generated
		 */
		EClass TCG_OCL_FUNCTION = eINSTANCE.getTcgOclFunction();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TCG_OCL_FUNCTION__NAME = eINSTANCE.getTcgOclFunction_Name();

		/**
		 * The meta object literal for the '<em><b>Ampl Literal</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TCG_OCL_FUNCTION__AMPL_LITERAL = eINSTANCE.getTcgOclFunction_AmplLiteral();

		/**
		 * The meta object literal for the '<em><b>Ocl Literal</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TCG_OCL_FUNCTION__OCL_LITERAL = eINSTANCE.getTcgOclFunction_OclLiteral();

		/**
		 * The meta object literal for the '<em><b>Ampl Close Literal</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TCG_OCL_FUNCTION__AMPL_CLOSE_LITERAL = eINSTANCE.getTcgOclFunction_AmplCloseLiteral();

	}

} //TcgoclfunctionlibPackage
