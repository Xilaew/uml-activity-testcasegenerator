/**
 */
package org.xilaew.atg.model.activityTestCaseGraph.impl;

import java.io.IOException;

import java.net.URL;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;

import org.xilaew.atg.model.abstractTestCaseGraph.AbstractTestCaseGraphPackage;

import org.xilaew.atg.model.activityTestCaseGraph.ActivityTestCaseGraphFactory;
import org.xilaew.atg.model.activityTestCaseGraph.ActivityTestCaseGraphPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ActivityTestCaseGraphPackageImpl extends EPackageImpl implements ActivityTestCaseGraphPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected String packageFilename = "activityTestCaseGraph.ecore";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tcgActivityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tcgActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tcgControlFlowEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tcgControlNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tcgVariableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tcgObjectVariableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tcgBasicVariableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tcgoclExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tcgoclOperationCallExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tcgoclVariableCallExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tcgoclLiteralExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum tcgBasicVariableTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum tcgoclOperationTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum tcgVariableUsageEEnum = null;

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
	 * @see org.xilaew.atg.model.activityTestCaseGraph.ActivityTestCaseGraphPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ActivityTestCaseGraphPackageImpl() {
		super(eNS_URI, ActivityTestCaseGraphFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ActivityTestCaseGraphPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @generated
	 */
	public static ActivityTestCaseGraphPackage init() {
		if (isInited) return (ActivityTestCaseGraphPackage)EPackage.Registry.INSTANCE.getEPackage(ActivityTestCaseGraphPackage.eNS_URI);

		// Obtain or create and register package
		ActivityTestCaseGraphPackageImpl theActivityTestCaseGraphPackage = (ActivityTestCaseGraphPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ActivityTestCaseGraphPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ActivityTestCaseGraphPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		AbstractTestCaseGraphPackage.eINSTANCE.eClass();

		// Load packages
		theActivityTestCaseGraphPackage.loadPackage();

		// Fix loaded packages
		theActivityTestCaseGraphPackage.fixPackageContents();

		// Mark meta-data to indicate it can't be changed
		theActivityTestCaseGraphPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ActivityTestCaseGraphPackage.eNS_URI, theActivityTestCaseGraphPackage);
		return theActivityTestCaseGraphPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTCGActivity() {
		if (tcgActivityEClass == null) {
			tcgActivityEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ActivityTestCaseGraphPackage.eNS_URI).getEClassifiers().get(0);
		}
		return tcgActivityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTCGActivity_Variables() {
        return (EReference)getTCGActivity().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTCGActivity_ClassName() {
        return (EAttribute)getTCGActivity().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTCGActivity_PackageName() {
        return (EAttribute)getTCGActivity().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTCGAction() {
		if (tcgActionEClass == null) {
			tcgActionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ActivityTestCaseGraphPackage.eNS_URI).getEClassifiers().get(1);
		}
		return tcgActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTCGAction_LocalPostconditions() {
        return (EReference)getTCGAction().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTCGControlFlow() {
		if (tcgControlFlowEClass == null) {
			tcgControlFlowEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ActivityTestCaseGraphPackage.eNS_URI).getEClassifiers().get(2);
		}
		return tcgControlFlowEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTCGControlNode() {
		if (tcgControlNodeEClass == null) {
			tcgControlNodeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ActivityTestCaseGraphPackage.eNS_URI).getEClassifiers().get(3);
		}
		return tcgControlNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTCGVariable() {
		if (tcgVariableEClass == null) {
			tcgVariableEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ActivityTestCaseGraphPackage.eNS_URI).getEClassifiers().get(4);
		}
		return tcgVariableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTCGVariable_ReferencedBy() {
        return (EReference)getTCGVariable().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTCGVariable_IsParameter() {
        return (EAttribute)getTCGVariable().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTCGVariable_Usage() {
        return (EAttribute)getTCGVariable().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTCGObjectVariable() {
		if (tcgObjectVariableEClass == null) {
			tcgObjectVariableEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ActivityTestCaseGraphPackage.eNS_URI).getEClassifiers().get(5);
		}
		return tcgObjectVariableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTCGObjectVariable_Fields() {
        return (EReference)getTCGObjectVariable().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTCGBasicVariable() {
		if (tcgBasicVariableEClass == null) {
			tcgBasicVariableEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ActivityTestCaseGraphPackage.eNS_URI).getEClassifiers().get(6);
		}
		return tcgBasicVariableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTCGBasicVariable_VariableType() {
        return (EAttribute)getTCGBasicVariable().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTCGBasicVariable__GetAbsoluteName() {
        return getTCGBasicVariable().getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTCGOCLExpression() {
		if (tcgoclExpressionEClass == null) {
			tcgoclExpressionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ActivityTestCaseGraphPackage.eNS_URI).getEClassifiers().get(8);
		}
		return tcgoclExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTCGOCLOperationCallExp() {
		if (tcgoclOperationCallExpEClass == null) {
			tcgoclOperationCallExpEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ActivityTestCaseGraphPackage.eNS_URI).getEClassifiers().get(9);
		}
		return tcgoclOperationCallExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTCGOCLOperationCallExp_Source() {
        return (EReference)getTCGOCLOperationCallExp().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTCGOCLOperationCallExp_Arguments() {
        return (EReference)getTCGOCLOperationCallExp().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTCGOCLOperationCallExp_Operation() {
        return (EAttribute)getTCGOCLOperationCallExp().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTCGOCLVariableCallExp() {
		if (tcgoclVariableCallExpEClass == null) {
			tcgoclVariableCallExpEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ActivityTestCaseGraphPackage.eNS_URI).getEClassifiers().get(10);
		}
		return tcgoclVariableCallExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTCGOCLVariableCallExp_Variable() {
        return (EReference)getTCGOCLVariableCallExp().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTCGOCLVariableCallExp_IsPre() {
        return (EAttribute)getTCGOCLVariableCallExp().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTCGOCLLiteralExp() {
		if (tcgoclLiteralExpEClass == null) {
			tcgoclLiteralExpEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(ActivityTestCaseGraphPackage.eNS_URI).getEClassifiers().get(12);
		}
		return tcgoclLiteralExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTCGOCLLiteralExp_Type() {
        return (EAttribute)getTCGOCLLiteralExp().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTCGOCLLiteralExp_Value() {
        return (EAttribute)getTCGOCLLiteralExp().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getTCGBasicVariableType() {
		if (tcgBasicVariableTypeEEnum == null) {
			tcgBasicVariableTypeEEnum = (EEnum)EPackage.Registry.INSTANCE.getEPackage(ActivityTestCaseGraphPackage.eNS_URI).getEClassifiers().get(7);
		}
		return tcgBasicVariableTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getTCGOCLOperationType() {
		if (tcgoclOperationTypeEEnum == null) {
			tcgoclOperationTypeEEnum = (EEnum)EPackage.Registry.INSTANCE.getEPackage(ActivityTestCaseGraphPackage.eNS_URI).getEClassifiers().get(11);
		}
		return tcgoclOperationTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getTCGVariableUsage() {
		if (tcgVariableUsageEEnum == null) {
			tcgVariableUsageEEnum = (EEnum)EPackage.Registry.INSTANCE.getEPackage(ActivityTestCaseGraphPackage.eNS_URI).getEClassifiers().get(13);
		}
		return tcgVariableUsageEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivityTestCaseGraphFactory getActivityTestCaseGraphFactory() {
		return (ActivityTestCaseGraphFactory)getEFactoryInstance();
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
			eClassifier.setInstanceClassName("org.xilaew.atg.model.activityTestCaseGraph." + eClassifier.getName());
			setGeneratedClassName(eClassifier);
		}
	}

} //ActivityTestCaseGraphPackageImpl
