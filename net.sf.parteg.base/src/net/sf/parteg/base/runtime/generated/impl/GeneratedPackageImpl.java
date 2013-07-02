/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.sf.parteg.base.runtime.generated.impl;

import net.sf.parteg.base.runtime.generated.GeneratedFactory;
import net.sf.parteg.base.runtime.generated.GeneratedPackage;
import net.sf.parteg.base.runtime.generated.RuntimeState;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GeneratedPackageImpl extends EPackageImpl implements GeneratedPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass runtimeStateEClass = null;
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
	 * @see net.sf.parteg.base.runtime.generated.GeneratedPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private GeneratedPackageImpl() {
		super(eNS_URI, GeneratedFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this
	 * model, and for any others upon which it depends.  Simple
	 * dependencies are satisfied by calling this method on all
	 * dependent packages before doing anything else.  This method drives
	 * initialization for interdependent packages directly, in parallel
	 * with this package, itself.
	 * <p>Of this package and its interdependencies, all packages which
	 * have not yet been registered by their URI values are first created
	 * and registered.  The packages are then initialized in two steps:
	 * meta-model objects for all of the packages are created before any
	 * are initialized, since one package's meta-model objects may refer to
	 * those of another.
	 * <p>Invocation of this method will not affect any packages that have
	 * already been initialized.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static GeneratedPackage init() {
		if (isInited) return (GeneratedPackage)EPackage.Registry.INSTANCE.getEPackage(GeneratedPackage.eNS_URI);

		// Obtain or create and register package
		GeneratedPackageImpl theGeneratedPackage = (GeneratedPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof GeneratedPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new GeneratedPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		net.sf.parteg.base.testcasegraph.generated.impl.GeneratedPackageImpl theGeneratedPackage_1 = (net.sf.parteg.base.testcasegraph.generated.impl.GeneratedPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(net.sf.parteg.base.testcasegraph.generated.GeneratedPackage.eNS_URI) instanceof net.sf.parteg.base.testcasegraph.generated.impl.GeneratedPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(net.sf.parteg.base.testcasegraph.generated.GeneratedPackage.eNS_URI) : net.sf.parteg.base.testcasegraph.generated.GeneratedPackage.eINSTANCE);

		// Create package meta-data objects
		theGeneratedPackage.createPackageContents();
		theGeneratedPackage_1.createPackageContents();

		// Initialize created meta-data
		theGeneratedPackage.initializePackageContents();
		theGeneratedPackage_1.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theGeneratedPackage.freeze();

		return theGeneratedPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRuntimeState() {
		return runtimeStateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeneratedFactory getGeneratedFactory() {
		return (GeneratedFactory)getEFactoryInstance();
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
		runtimeStateEClass = createEClass(RUNTIME_STATE);
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
		net.sf.parteg.base.testcasegraph.generated.GeneratedPackage theGeneratedPackage_1 = (net.sf.parteg.base.testcasegraph.generated.GeneratedPackage)EPackage.Registry.INSTANCE.getEPackage(net.sf.parteg.base.testcasegraph.generated.GeneratedPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(runtimeStateEClass, RuntimeState.class, "RuntimeState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		EOperation op = addEOperation(runtimeStateEClass, theGeneratedPackage_1.getTCGNode(), "getActiveNode", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theGeneratedPackage_1.getTestCaseRegion(), "region", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(runtimeStateEClass, null, "setActiveNode", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theGeneratedPackage_1.getTCGNode(), "node", 1, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(runtimeStateEClass, ecorePackage.getEBoolean(), "isInitialState", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(runtimeStateEClass, null, "removeNodeFromState", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theGeneratedPackage_1.getTCGNode(), "node", 1, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(runtimeStateEClass, theGeneratedPackage_1.getTestCaseRegion(), "getAllRegions", 0, -1, IS_UNIQUE, IS_ORDERED);

		addEOperation(runtimeStateEClass, theGeneratedPackage_1.getTCGNode(), "getAllActiveNodes", 0, -1, IS_UNIQUE, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //GeneratedPackageImpl
