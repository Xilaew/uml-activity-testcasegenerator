/**
 */
package model.package1.impl;

import model.package1.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Package1FactoryImpl extends EFactoryImpl implements Package1Factory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Package1Factory init() {
		try {
			Package1Factory thePackage1Factory = (Package1Factory)EPackage.Registry.INSTANCE.getEFactory(Package1Package.eNS_URI);
			if (thePackage1Factory != null) {
				return thePackage1Factory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new Package1FactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Package1FactoryImpl() {
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
			case Package1Package.CLASS1: return createclass1();
			case Package1Package.TYPE1: return createtype1();
			case Package1Package.CLASS1_TEST_ACTIVITY: return createclass1_testActivity();
			case Package1Package.CLASS2: return createclass2();
			case Package1Package.TYPE2: return createtype2();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public class1 createclass1() {
		class1Impl class1 = new class1Impl();
		return class1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public type1 createtype1() {
		type1Impl type1 = new type1Impl();
		return type1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public class1_testActivity createclass1_testActivity() {
		class1_testActivityImpl class1_testActivity = new class1_testActivityImpl();
		return class1_testActivity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public class2 createclass2() {
		class2Impl class2 = new class2Impl();
		return class2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public type2 createtype2() {
		type2Impl type2 = new type2Impl();
		return type2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Package1Package getPackage1Package() {
		return (Package1Package)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static Package1Package getPackage() {
		return Package1Package.eINSTANCE;
	}

} //Package1FactoryImpl
