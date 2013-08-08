/**
 */
package org.xilaew.atg.model.tcgoclfunctionlib.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.xilaew.atg.model.tcgoclfunctionlib.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TcgoclfunctionlibFactoryImpl extends EFactoryImpl implements TcgoclfunctionlibFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TcgoclfunctionlibFactory init() {
		try {
			TcgoclfunctionlibFactory theTcgoclfunctionlibFactory = (TcgoclfunctionlibFactory)EPackage.Registry.INSTANCE.getEFactory(TcgoclfunctionlibPackage.eNS_URI);
			if (theTcgoclfunctionlibFactory != null) {
				return theTcgoclfunctionlibFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new TcgoclfunctionlibFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TcgoclfunctionlibFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case TcgoclfunctionlibPackage.FUNCTION_LIBRARY: return createFunctionLibrary();
			case TcgoclfunctionlibPackage.TCG_OCL_FUNCTION: return createTcgOclFunction();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionLibrary createFunctionLibrary() {
		FunctionLibraryImpl functionLibrary = new FunctionLibraryImpl();
		return functionLibrary;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TcgOclFunction createTcgOclFunction() {
		TcgOclFunctionImpl tcgOclFunction = new TcgOclFunctionImpl();
		return tcgOclFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TcgoclfunctionlibPackage getTcgoclfunctionlibPackage() {
		return (TcgoclfunctionlibPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static TcgoclfunctionlibPackage getPackage() {
		return TcgoclfunctionlibPackage.eINSTANCE;
	}

} //TcgoclfunctionlibFactoryImpl
