/**
 */
package org.xilaew.atg.model.tcgoclfunctionlib.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.xilaew.atg.model.tcgoclfunctionlib.FunctionLibrary;
import org.xilaew.atg.model.tcgoclfunctionlib.TcgOclFunction;
import org.xilaew.atg.model.tcgoclfunctionlib.TcgoclfunctionlibFactory;
import org.xilaew.atg.model.tcgoclfunctionlib.TcgoclfunctionlibPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TcgoclfunctionlibPackageImpl extends EPackageImpl implements TcgoclfunctionlibPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass functionLibraryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tcgOclFunctionEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.xilaew.atg.model.tcgoclfunctionlib.TcgoclfunctionlibPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private TcgoclfunctionlibPackageImpl() {
		super(eNS_URI, TcgoclfunctionlibFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link TcgoclfunctionlibPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static TcgoclfunctionlibPackage init() {
		if (isInited) return (TcgoclfunctionlibPackage)EPackage.Registry.INSTANCE.getEPackage(TcgoclfunctionlibPackage.eNS_URI);

		// Obtain or create and register package
		TcgoclfunctionlibPackageImpl theTcgoclfunctionlibPackage = (TcgoclfunctionlibPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof TcgoclfunctionlibPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new TcgoclfunctionlibPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theTcgoclfunctionlibPackage.createPackageContents();

		// Initialize created meta-data
		theTcgoclfunctionlibPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theTcgoclfunctionlibPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(TcgoclfunctionlibPackage.eNS_URI, theTcgoclfunctionlibPackage);
		return theTcgoclfunctionlibPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFunctionLibrary() {
		return functionLibraryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunctionLibrary_Function() {
		return (EReference)functionLibraryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTcgOclFunction() {
		return tcgOclFunctionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTcgOclFunction_Name() {
		return (EAttribute)tcgOclFunctionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTcgOclFunction_AmplLiteral() {
		return (EAttribute)tcgOclFunctionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTcgOclFunction_OclLiteral() {
		return (EAttribute)tcgOclFunctionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTcgOclFunction_AmplCloseLiteral() {
		return (EAttribute)tcgOclFunctionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TcgoclfunctionlibFactory getTcgoclfunctionlibFactory() {
		return (TcgoclfunctionlibFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		functionLibraryEClass = createEClass(FUNCTION_LIBRARY);
		createEReference(functionLibraryEClass, FUNCTION_LIBRARY__FUNCTION);

		tcgOclFunctionEClass = createEClass(TCG_OCL_FUNCTION);
		createEAttribute(tcgOclFunctionEClass, TCG_OCL_FUNCTION__NAME);
		createEAttribute(tcgOclFunctionEClass, TCG_OCL_FUNCTION__AMPL_LITERAL);
		createEAttribute(tcgOclFunctionEClass, TCG_OCL_FUNCTION__OCL_LITERAL);
		createEAttribute(tcgOclFunctionEClass, TCG_OCL_FUNCTION__AMPL_CLOSE_LITERAL);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(functionLibraryEClass, FunctionLibrary.class, "FunctionLibrary", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFunctionLibrary_Function(), this.getTcgOclFunction(), null, "function", null, 0, -1, FunctionLibrary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getFunctionLibrary_Function().getEKeys().add(this.getTcgOclFunction_OclLiteral());

		initEClass(tcgOclFunctionEClass, TcgOclFunction.class, "TcgOclFunction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTcgOclFunction_Name(), ecorePackage.getEString(), "name", null, 0, 1, TcgOclFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTcgOclFunction_AmplLiteral(), ecorePackage.getEString(), "amplLiteral", null, 0, 1, TcgOclFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTcgOclFunction_OclLiteral(), ecorePackage.getEString(), "oclLiteral", "\"\"", 0, 1, TcgOclFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTcgOclFunction_AmplCloseLiteral(), ecorePackage.getEString(), "amplCloseLiteral", "\"\"", 0, 1, TcgOclFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //TcgoclfunctionlibPackageImpl
