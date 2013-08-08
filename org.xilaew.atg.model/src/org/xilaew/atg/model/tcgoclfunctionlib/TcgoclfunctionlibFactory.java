/**
 */
package org.xilaew.atg.model.tcgoclfunctionlib;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.xilaew.atg.model.tcgoclfunctionlib.TcgoclfunctionlibPackage
 * @generated
 */
public interface TcgoclfunctionlibFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TcgoclfunctionlibFactory eINSTANCE = org.xilaew.atg.model.tcgoclfunctionlib.impl.TcgoclfunctionlibFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Function Library</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Function Library</em>'.
	 * @generated
	 */
	FunctionLibrary createFunctionLibrary();

	/**
	 * Returns a new object of class '<em>Tcg Ocl Function</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tcg Ocl Function</em>'.
	 * @generated
	 */
	TcgOclFunction createTcgOclFunction();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	TcgoclfunctionlibPackage getTcgoclfunctionlibPackage();

} //TcgoclfunctionlibFactory
