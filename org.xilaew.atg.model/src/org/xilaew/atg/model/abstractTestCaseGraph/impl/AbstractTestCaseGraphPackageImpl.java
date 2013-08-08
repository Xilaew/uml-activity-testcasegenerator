/**
 */
package org.xilaew.atg.model.abstractTestCaseGraph.impl;

import java.io.IOException;

import java.net.URL;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;

import org.xilaew.atg.model.abstractTestCaseGraph.AbstractTestCaseGraphFactory;
import org.xilaew.atg.model.abstractTestCaseGraph.AbstractTestCaseGraphPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AbstractTestCaseGraphPackageImpl extends EPackageImpl implements AbstractTestCaseGraphPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected String packageFilename = "abstractTestCaseGraph.ecore";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractTCGElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractTCGContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractTCGNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractTCGEdgeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractTCGRealNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractTCGPseudoNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractTCGConstraintEClass = null;

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
	 * @see org.xilaew.atg.model.abstractTestCaseGraph.AbstractTestCaseGraphPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private AbstractTestCaseGraphPackageImpl() {
		super(eNS_URI, AbstractTestCaseGraphFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link AbstractTestCaseGraphPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @generated
	 */
	public static AbstractTestCaseGraphPackage init() {
		if (isInited) return (AbstractTestCaseGraphPackage)EPackage.Registry.INSTANCE.getEPackage(AbstractTestCaseGraphPackage.eNS_URI);

		// Obtain or create and register package
		AbstractTestCaseGraphPackageImpl theAbstractTestCaseGraphPackage = (AbstractTestCaseGraphPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof AbstractTestCaseGraphPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new AbstractTestCaseGraphPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();

		// Load packages
		theAbstractTestCaseGraphPackage.loadPackage();

		// Fix loaded packages
		theAbstractTestCaseGraphPackage.fixPackageContents();

		// Mark meta-data to indicate it can't be changed
		theAbstractTestCaseGraphPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(AbstractTestCaseGraphPackage.eNS_URI, theAbstractTestCaseGraphPackage);
		return theAbstractTestCaseGraphPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractTCGElement() {
		if (abstractTCGElementEClass == null) {
			abstractTCGElementEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AbstractTestCaseGraphPackage.eNS_URI).getEClassifiers().get(0);
		}
		return abstractTCGElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractTCGElement_Name() {
        return (EAttribute)getAbstractTCGElement().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractTCGContainer() {
		if (abstractTCGContainerEClass == null) {
			abstractTCGContainerEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AbstractTestCaseGraphPackage.eNS_URI).getEClassifiers().get(1);
		}
		return abstractTCGContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractTCGContainer_Nodes() {
        return (EReference)getAbstractTCGContainer().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractTCGContainer_Edges() {
        return (EReference)getAbstractTCGContainer().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractTCGContainer_InitialNode() {
        return (EReference)getAbstractTCGContainer().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractTCGNode() {
		if (abstractTCGNodeEClass == null) {
			abstractTCGNodeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AbstractTestCaseGraphPackage.eNS_URI).getEClassifiers().get(2);
		}
		return abstractTCGNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractTCGNode_Outgoing() {
        return (EReference)getAbstractTCGNode().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractTCGNode_Incoming() {
        return (EReference)getAbstractTCGNode().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractTCGEdge() {
		if (abstractTCGEdgeEClass == null) {
			abstractTCGEdgeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AbstractTestCaseGraphPackage.eNS_URI).getEClassifiers().get(3);
		}
		return abstractTCGEdgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractTCGEdge_Source() {
        return (EReference)getAbstractTCGEdge().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractTCGEdge_Target() {
        return (EReference)getAbstractTCGEdge().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractTCGEdge_Guard() {
        return (EReference)getAbstractTCGEdge().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractTCGRealNode() {
		if (abstractTCGRealNodeEClass == null) {
			abstractTCGRealNodeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AbstractTestCaseGraphPackage.eNS_URI).getEClassifiers().get(4);
		}
		return abstractTCGRealNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractTCGPseudoNode() {
		if (abstractTCGPseudoNodeEClass == null) {
			abstractTCGPseudoNodeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AbstractTestCaseGraphPackage.eNS_URI).getEClassifiers().get(5);
		}
		return abstractTCGPseudoNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractTCGConstraint() {
		if (abstractTCGConstraintEClass == null) {
			abstractTCGConstraintEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(AbstractTestCaseGraphPackage.eNS_URI).getEClassifiers().get(6);
		}
		return abstractTCGConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractTestCaseGraphFactory getAbstractTestCaseGraphFactory() {
		return (AbstractTestCaseGraphFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isLoaded = false;

	/**
	 * Laods the package and any sub-packages from their serialized form.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void loadPackage() {
		if (isLoaded) return;
		isLoaded = true;

		URL url = getClass().getResource(packageFilename);
		if (url == null) {
			throw new RuntimeException("Missing serialized package: " + packageFilename);
		}
		URI uri = URI.createURI(url.toString());
		Resource resource = new EcoreResourceFactoryImpl().createResource(uri);
		try {
			resource.load(null);
		}
		catch (IOException exception) {
			throw new WrappedException(exception);
		}
		initializeFromLoadedEPackage(this, (EPackage)resource.getContents().get(0));
		createResource(eNS_URI);
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isFixed = false;

	/**
	 * Fixes up the loaded package, to make it appear as if it had been programmatically built.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void fixPackageContents() {
		if (isFixed) return;
		isFixed = true;
		fixEClassifiers();
	}

	/**
	 * Sets the instance class on the given classifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void fixInstanceClass(EClassifier eClassifier) {
		if (eClassifier.getInstanceClassName() == null) {
			eClassifier.setInstanceClassName("org.xilaew.atg.model.abstractTestCaseGraph." + eClassifier.getName());
			setGeneratedClassName(eClassifier);
		}
	}

} //AbstractTestCaseGraphPackageImpl
