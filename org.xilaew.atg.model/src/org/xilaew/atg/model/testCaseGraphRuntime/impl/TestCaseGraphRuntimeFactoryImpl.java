/**
 */
package org.xilaew.atg.model.testCaseGraphRuntime.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.xilaew.atg.model.testCaseGraphRuntime.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TestCaseGraphRuntimeFactoryImpl extends EFactoryImpl implements TestCaseGraphRuntimeFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TestCaseGraphRuntimeFactory init() {
		try {
			TestCaseGraphRuntimeFactory theTestCaseGraphRuntimeFactory = (TestCaseGraphRuntimeFactory)EPackage.Registry.INSTANCE.getEFactory(TestCaseGraphRuntimePackage.eNS_URI);
			if (theTestCaseGraphRuntimeFactory != null) {
				return theTestCaseGraphRuntimeFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new TestCaseGraphRuntimeFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestCaseGraphRuntimeFactoryImpl() {
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
			case TestCaseGraphRuntimePackage.PATH: return createPath();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Path createPath() {
		PathImpl path = new PathImpl();
		return path;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestCaseGraphRuntimePackage getTestCaseGraphRuntimePackage() {
		return (TestCaseGraphRuntimePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static TestCaseGraphRuntimePackage getPackage() {
		return TestCaseGraphRuntimePackage.eINSTANCE;
	}

} //TestCaseGraphRuntimeFactoryImpl
