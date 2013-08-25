/**
 */
package org.xilaew.atg.model.testCaseGraphRuntime.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.xilaew.atg.model.abstractTestCaseGraph.AbstractTestCaseGraphPackage;

import org.xilaew.atg.model.testCaseGraphRuntime.AMPLPath;
import org.xilaew.atg.model.testCaseGraphRuntime.Path;
import org.xilaew.atg.model.testCaseGraphRuntime.TestCaseGraphRuntimeFactory;
import org.xilaew.atg.model.testCaseGraphRuntime.TestCaseGraphRuntimePackage;
import org.xilaew.atg.model.testCaseGraphRuntime.indexSet;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TestCaseGraphRuntimePackageImpl extends EPackageImpl implements TestCaseGraphRuntimePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pathEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass amplPathEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass indexSetEClass = null;

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
	 * @see org.xilaew.atg.model.testCaseGraphRuntime.TestCaseGraphRuntimePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private TestCaseGraphRuntimePackageImpl() {
		super(eNS_URI, TestCaseGraphRuntimeFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link TestCaseGraphRuntimePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static TestCaseGraphRuntimePackage init() {
		if (isInited) return (TestCaseGraphRuntimePackage)EPackage.Registry.INSTANCE.getEPackage(TestCaseGraphRuntimePackage.eNS_URI);

		// Obtain or create and register package
		TestCaseGraphRuntimePackageImpl theTestCaseGraphRuntimePackage = (TestCaseGraphRuntimePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof TestCaseGraphRuntimePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new TestCaseGraphRuntimePackageImpl());

		isInited = true;

		// Initialize simple dependencies
		AbstractTestCaseGraphPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theTestCaseGraphRuntimePackage.createPackageContents();

		// Initialize created meta-data
		theTestCaseGraphRuntimePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theTestCaseGraphRuntimePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(TestCaseGraphRuntimePackage.eNS_URI, theTestCaseGraphRuntimePackage);
		return theTestCaseGraphRuntimePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPath() {
		return pathEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPath_Edges() {
		return (EReference)pathEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAMPLPath() {
		return amplPathEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAMPLPath_Edges() {
		return (EReference)amplPathEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getindexSet() {
		return indexSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestCaseGraphRuntimeFactory getTestCaseGraphRuntimeFactory() {
		return (TestCaseGraphRuntimeFactory)getEFactoryInstance();
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
		pathEClass = createEClass(PATH);
		createEReference(pathEClass, PATH__EDGES);

		amplPathEClass = createEClass(AMPL_PATH);
		createEReference(amplPathEClass, AMPL_PATH__EDGES);

		indexSetEClass = createEClass(INDEX_SET);
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

		// Obtain other dependent packages
		AbstractTestCaseGraphPackage theAbstractTestCaseGraphPackage = (AbstractTestCaseGraphPackage)EPackage.Registry.INSTANCE.getEPackage(AbstractTestCaseGraphPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(pathEClass, Path.class, "Path", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPath_Edges(), theAbstractTestCaseGraphPackage.getAbstractTCGEdge(), null, "edges", null, 0, -1, Path.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(amplPathEClass, AMPLPath.class, "AMPLPath", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAMPLPath_Edges(), theAbstractTestCaseGraphPackage.getAbstractTCGEdge(), null, "edges", null, 0, 1, AMPLPath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(indexSetEClass, indexSet.class, "indexSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //TestCaseGraphRuntimePackageImpl
