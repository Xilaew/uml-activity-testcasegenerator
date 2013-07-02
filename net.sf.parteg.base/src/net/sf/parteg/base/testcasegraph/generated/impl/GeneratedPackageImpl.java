/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.sf.parteg.base.testcasegraph.generated.impl;

import net.sf.parteg.base.testcasegraph.generated.GeneratedFactory;
import net.sf.parteg.base.testcasegraph.generated.GeneratedPackage;
import net.sf.parteg.base.testcasegraph.generated.TCGComplexParameter;
import net.sf.parteg.base.testcasegraph.generated.TCGConjunction;
import net.sf.parteg.base.testcasegraph.generated.TCGDisjunctiveNormalForm;
import net.sf.parteg.base.testcasegraph.generated.TCGElement;
import net.sf.parteg.base.testcasegraph.generated.TCGEquivalenceClass;
import net.sf.parteg.base.testcasegraph.generated.TCGEvent;
import net.sf.parteg.base.testcasegraph.generated.TCGIntermediateNode;
import net.sf.parteg.base.testcasegraph.generated.TCGNode;
import net.sf.parteg.base.testcasegraph.generated.TCGNodeType;
import net.sf.parteg.base.testcasegraph.generated.TCGOCLAtom;
import net.sf.parteg.base.testcasegraph.generated.TCGOCLExpression;
import net.sf.parteg.base.testcasegraph.generated.TCGOCLIfThenElse;
import net.sf.parteg.base.testcasegraph.generated.TCGOCLOperation;
import net.sf.parteg.base.testcasegraph.generated.TCGParameter;
import net.sf.parteg.base.testcasegraph.generated.TCGPrimitiveParameter;
import net.sf.parteg.base.testcasegraph.generated.TCGRealNode;
import net.sf.parteg.base.testcasegraph.generated.TCGTransition;
import net.sf.parteg.base.testcasegraph.generated.TestCaseGraph;
import net.sf.parteg.base.testcasegraph.generated.TestCaseRegion;
import net.sf.parteg.base.testcasegraph.generated.VariableClassification;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
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
	private EClass tcgNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tcgRealNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tcgIntermediateNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass testCaseRegionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass testCaseGraphEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tcgTransitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tcgEquivalenceClassEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tcgEventEClass = null;

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
	private EClass tcgConjunctionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tcgDisjunctiveNormalFormEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tcgoclOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tcgoclAtomEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tcgoclIfThenElseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tcgParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tcgPrimitiveParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tcgComplexParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tcgElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum variableClassificationEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum tcgNodeTypeEEnum = null;

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
	 * @see net.sf.parteg.base.testcasegraph.generated.GeneratedPackage#eNS_URI
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
		net.sf.parteg.base.runtime.generated.impl.GeneratedPackageImpl theGeneratedPackage_1 = (net.sf.parteg.base.runtime.generated.impl.GeneratedPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(net.sf.parteg.base.runtime.generated.GeneratedPackage.eNS_URI) instanceof net.sf.parteg.base.runtime.generated.impl.GeneratedPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(net.sf.parteg.base.runtime.generated.GeneratedPackage.eNS_URI) : net.sf.parteg.base.runtime.generated.GeneratedPackage.eINSTANCE);

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
	public EClass getTCGNode() {
		return tcgNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTCGNode_Name() {
		return (EAttribute)tcgNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTCGNode_IncomingTransitions() {
		return (EReference)tcgNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTCGNode_OutgoingTransitions() {
		return (EReference)tcgNodeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTCGNode_OriginalNode() {
		return (EReference)tcgNodeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTCGNode_UseAllTransitionsInParallel() {
		return (EAttribute)tcgNodeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTCGNode_ReferencedSubmachine() {
		return (EReference)tcgNodeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTCGNode_MinDistanceFromStart() {
		return (EAttribute)tcgNodeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTCGNode_MaxDistanceFromStart() {
		return (EAttribute)tcgNodeEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTCGRealNode() {
		return tcgRealNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTCGRealNode_Condition() {
		return (EReference)tcgRealNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTCGRealNode_SubGraph() {
		return (EReference)tcgRealNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTCGRealNode_ContainedConnectionPointReferences() {
		return (EReference)tcgRealNodeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTCGRealNode_ContainedConnectionPoints() {
		return (EReference)tcgRealNodeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTCGRealNode_Container() {
		return (EReference)tcgRealNodeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTCGIntermediateNode() {
		return tcgIntermediateNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTCGIntermediateNode_ReferencedConnectionPointReferences() {
		return (EReference)tcgIntermediateNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTCGIntermediateNode_ReferencedConnectionPoints() {
		return (EReference)tcgIntermediateNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTCGIntermediateNode_Container() {
		return (EReference)tcgIntermediateNodeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTCGIntermediateNode_NodeType() {
		return (EAttribute)tcgIntermediateNodeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTestCaseRegion() {
		return testCaseRegionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTestCaseRegion_Nodes() {
		return (EReference)testCaseRegionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTestCaseRegion_Transitions() {
		return (EReference)testCaseRegionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTestCaseRegion_Container() {
		return (EReference)testCaseRegionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTestCaseGraph() {
		return testCaseGraphEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTestCaseGraph_Regions() {
		return (EReference)testCaseGraphEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTestCaseGraph_CompositeSuperState() {
		return (EReference)testCaseGraphEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTestCaseGraph_ContainedConnectionPoints() {
		return (EReference)testCaseGraphEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTestCaseGraph_SubmachineStates() {
		return (EReference)testCaseGraphEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTCGTransition() {
		return tcgTransitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTCGTransition_Name() {
		return (EAttribute)tcgTransitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTCGTransition_SourceNode() {
		return (EReference)tcgTransitionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTCGTransition_TargetNode() {
		return (EReference)tcgTransitionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTCGTransition_Events() {
		return (EReference)tcgTransitionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTCGTransition_Precondition() {
		return (EReference)tcgTransitionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTCGTransition_Postcondition() {
		return (EReference)tcgTransitionEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTCGTransition_Container() {
		return (EReference)tcgTransitionEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTCGTransition_CanBeProcessed() {
		return (EAttribute)tcgTransitionEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTCGEquivalenceClass() {
		return tcgEquivalenceClassEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTCGEquivalenceClass_MinBorder() {
		return (EAttribute)tcgEquivalenceClassEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTCGEquivalenceClass_MinIncluded() {
		return (EAttribute)tcgEquivalenceClassEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTCGEquivalenceClass_MaxBorder() {
		return (EAttribute)tcgEquivalenceClassEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTCGEquivalenceClass_MaxIncluded() {
		return (EAttribute)tcgEquivalenceClassEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTCGEvent() {
		return tcgEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTCGEvent_Name() {
		return (EAttribute)tcgEventEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTCGEvent_Parameters() {
		return (EReference)tcgEventEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTCGEvent_Event() {
		return (EReference)tcgEventEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTCGEvent_DefaultEvent() {
		return (EAttribute)tcgEventEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTCGOCLExpression() {
		return tcgoclExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTCGOCLExpression_Classification() {
		return (EAttribute)tcgoclExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTCGOCLExpression_OclReference() {
		return (EReference)tcgoclExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTCGOCLExpression_Container() {
		return (EReference)tcgoclExpressionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTCGOCLExpression_PositiveAssignmentOfOriginal() {
		return (EAttribute)tcgoclExpressionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTCGOCLExpression_TransitionContext() {
		return (EReference)tcgoclExpressionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTCGConjunction() {
		return tcgConjunctionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTCGConjunction_Expressions() {
		return (EReference)tcgConjunctionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTCGConjunction_CanChangeValueIfOneExpressionChanges() {
		return (EAttribute)tcgConjunctionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTCGConjunction_PositiveSubExpressionOfOriginal() {
		return (EAttribute)tcgConjunctionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTCGDisjunctiveNormalForm() {
		return tcgDisjunctiveNormalFormEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTCGDisjunctiveNormalForm_Conjunctions() {
		return (EReference)tcgDisjunctiveNormalFormEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTCGDisjunctiveNormalForm_OriginalExpression() {
		return (EReference)tcgDisjunctiveNormalFormEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTCGDisjunctiveNormalForm_UseForTestGoals() {
		return (EAttribute)tcgDisjunctiveNormalFormEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTCGOCLOperation() {
		return tcgoclOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTCGOCLOperation_Left() {
		return (EReference)tcgoclOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTCGOCLOperation_Right() {
		return (EReference)tcgoclOperationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTCGOCLOperation_Operation() {
		return (EReference)tcgoclOperationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTCGOCLOperation_OperationName() {
		return (EAttribute)tcgoclOperationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTCGOCLAtom() {
		return tcgoclAtomEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTCGOCLAtom_Element() {
		return (EReference)tcgoclAtomEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTCGOCLAtom_TcgParameter() {
		return (EReference)tcgoclAtomEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTCGOCLIfThenElse() {
		return tcgoclIfThenElseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTCGOCLIfThenElse_Condition() {
		return (EReference)tcgoclIfThenElseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTCGOCLIfThenElse_ThenExpression() {
		return (EReference)tcgoclIfThenElseEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTCGOCLIfThenElse_ElseExpression() {
		return (EReference)tcgoclIfThenElseEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTCGParameter() {
		return tcgParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTCGParameter_Name() {
		return (EAttribute)tcgParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTCGParameter_ValueType() {
		return (EReference)tcgParameterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTCGParameter_Reference() {
		return (EReference)tcgParameterEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTCGParameter_Container() {
		return (EReference)tcgParameterEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTCGPrimitiveParameter() {
		return tcgPrimitiveParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTCGPrimitiveParameter_ValueTypeRange() {
		return (EReference)tcgPrimitiveParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTCGComplexParameter() {
		return tcgComplexParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTCGComplexParameter_Parameter() {
		return (EReference)tcgComplexParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTCGElement() {
		return tcgElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getVariableClassification() {
		return variableClassificationEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getTCGNodeType() {
		return tcgNodeTypeEEnum;
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
		tcgNodeEClass = createEClass(TCG_NODE);
		createEAttribute(tcgNodeEClass, TCG_NODE__NAME);
		createEReference(tcgNodeEClass, TCG_NODE__INCOMING_TRANSITIONS);
		createEReference(tcgNodeEClass, TCG_NODE__OUTGOING_TRANSITIONS);
		createEReference(tcgNodeEClass, TCG_NODE__ORIGINAL_NODE);
		createEAttribute(tcgNodeEClass, TCG_NODE__USE_ALL_TRANSITIONS_IN_PARALLEL);
		createEReference(tcgNodeEClass, TCG_NODE__REFERENCED_SUBMACHINE);
		createEAttribute(tcgNodeEClass, TCG_NODE__MIN_DISTANCE_FROM_START);
		createEAttribute(tcgNodeEClass, TCG_NODE__MAX_DISTANCE_FROM_START);

		tcgRealNodeEClass = createEClass(TCG_REAL_NODE);
		createEReference(tcgRealNodeEClass, TCG_REAL_NODE__CONDITION);
		createEReference(tcgRealNodeEClass, TCG_REAL_NODE__SUB_GRAPH);
		createEReference(tcgRealNodeEClass, TCG_REAL_NODE__CONTAINED_CONNECTION_POINT_REFERENCES);
		createEReference(tcgRealNodeEClass, TCG_REAL_NODE__CONTAINED_CONNECTION_POINTS);
		createEReference(tcgRealNodeEClass, TCG_REAL_NODE__CONTAINER);

		tcgIntermediateNodeEClass = createEClass(TCG_INTERMEDIATE_NODE);
		createEReference(tcgIntermediateNodeEClass, TCG_INTERMEDIATE_NODE__REFERENCED_CONNECTION_POINT_REFERENCES);
		createEReference(tcgIntermediateNodeEClass, TCG_INTERMEDIATE_NODE__REFERENCED_CONNECTION_POINTS);
		createEReference(tcgIntermediateNodeEClass, TCG_INTERMEDIATE_NODE__CONTAINER);
		createEAttribute(tcgIntermediateNodeEClass, TCG_INTERMEDIATE_NODE__NODE_TYPE);

		testCaseRegionEClass = createEClass(TEST_CASE_REGION);
		createEReference(testCaseRegionEClass, TEST_CASE_REGION__NODES);
		createEReference(testCaseRegionEClass, TEST_CASE_REGION__TRANSITIONS);
		createEReference(testCaseRegionEClass, TEST_CASE_REGION__CONTAINER);

		testCaseGraphEClass = createEClass(TEST_CASE_GRAPH);
		createEReference(testCaseGraphEClass, TEST_CASE_GRAPH__REGIONS);
		createEReference(testCaseGraphEClass, TEST_CASE_GRAPH__COMPOSITE_SUPER_STATE);
		createEReference(testCaseGraphEClass, TEST_CASE_GRAPH__CONTAINED_CONNECTION_POINTS);
		createEReference(testCaseGraphEClass, TEST_CASE_GRAPH__SUBMACHINE_STATES);

		tcgTransitionEClass = createEClass(TCG_TRANSITION);
		createEAttribute(tcgTransitionEClass, TCG_TRANSITION__NAME);
		createEReference(tcgTransitionEClass, TCG_TRANSITION__SOURCE_NODE);
		createEReference(tcgTransitionEClass, TCG_TRANSITION__TARGET_NODE);
		createEReference(tcgTransitionEClass, TCG_TRANSITION__EVENTS);
		createEReference(tcgTransitionEClass, TCG_TRANSITION__PRECONDITION);
		createEReference(tcgTransitionEClass, TCG_TRANSITION__POSTCONDITION);
		createEReference(tcgTransitionEClass, TCG_TRANSITION__CONTAINER);
		createEAttribute(tcgTransitionEClass, TCG_TRANSITION__CAN_BE_PROCESSED);

		tcgEquivalenceClassEClass = createEClass(TCG_EQUIVALENCE_CLASS);
		createEAttribute(tcgEquivalenceClassEClass, TCG_EQUIVALENCE_CLASS__MIN_BORDER);
		createEAttribute(tcgEquivalenceClassEClass, TCG_EQUIVALENCE_CLASS__MIN_INCLUDED);
		createEAttribute(tcgEquivalenceClassEClass, TCG_EQUIVALENCE_CLASS__MAX_BORDER);
		createEAttribute(tcgEquivalenceClassEClass, TCG_EQUIVALENCE_CLASS__MAX_INCLUDED);

		tcgEventEClass = createEClass(TCG_EVENT);
		createEAttribute(tcgEventEClass, TCG_EVENT__NAME);
		createEReference(tcgEventEClass, TCG_EVENT__PARAMETERS);
		createEReference(tcgEventEClass, TCG_EVENT__EVENT);
		createEAttribute(tcgEventEClass, TCG_EVENT__DEFAULT_EVENT);

		tcgoclExpressionEClass = createEClass(TCGOCL_EXPRESSION);
		createEAttribute(tcgoclExpressionEClass, TCGOCL_EXPRESSION__CLASSIFICATION);
		createEReference(tcgoclExpressionEClass, TCGOCL_EXPRESSION__OCL_REFERENCE);
		createEReference(tcgoclExpressionEClass, TCGOCL_EXPRESSION__CONTAINER);
		createEAttribute(tcgoclExpressionEClass, TCGOCL_EXPRESSION__POSITIVE_ASSIGNMENT_OF_ORIGINAL);
		createEReference(tcgoclExpressionEClass, TCGOCL_EXPRESSION__TRANSITION_CONTEXT);

		tcgConjunctionEClass = createEClass(TCG_CONJUNCTION);
		createEReference(tcgConjunctionEClass, TCG_CONJUNCTION__EXPRESSIONS);
		createEAttribute(tcgConjunctionEClass, TCG_CONJUNCTION__CAN_CHANGE_VALUE_IF_ONE_EXPRESSION_CHANGES);
		createEAttribute(tcgConjunctionEClass, TCG_CONJUNCTION__POSITIVE_SUB_EXPRESSION_OF_ORIGINAL);

		tcgDisjunctiveNormalFormEClass = createEClass(TCG_DISJUNCTIVE_NORMAL_FORM);
		createEReference(tcgDisjunctiveNormalFormEClass, TCG_DISJUNCTIVE_NORMAL_FORM__CONJUNCTIONS);
		createEReference(tcgDisjunctiveNormalFormEClass, TCG_DISJUNCTIVE_NORMAL_FORM__ORIGINAL_EXPRESSION);
		createEAttribute(tcgDisjunctiveNormalFormEClass, TCG_DISJUNCTIVE_NORMAL_FORM__USE_FOR_TEST_GOALS);

		tcgoclOperationEClass = createEClass(TCGOCL_OPERATION);
		createEReference(tcgoclOperationEClass, TCGOCL_OPERATION__LEFT);
		createEReference(tcgoclOperationEClass, TCGOCL_OPERATION__RIGHT);
		createEReference(tcgoclOperationEClass, TCGOCL_OPERATION__OPERATION);
		createEAttribute(tcgoclOperationEClass, TCGOCL_OPERATION__OPERATION_NAME);

		tcgoclAtomEClass = createEClass(TCGOCL_ATOM);
		createEReference(tcgoclAtomEClass, TCGOCL_ATOM__ELEMENT);
		createEReference(tcgoclAtomEClass, TCGOCL_ATOM__TCG_PARAMETER);

		tcgoclIfThenElseEClass = createEClass(TCGOCL_IF_THEN_ELSE);
		createEReference(tcgoclIfThenElseEClass, TCGOCL_IF_THEN_ELSE__CONDITION);
		createEReference(tcgoclIfThenElseEClass, TCGOCL_IF_THEN_ELSE__THEN_EXPRESSION);
		createEReference(tcgoclIfThenElseEClass, TCGOCL_IF_THEN_ELSE__ELSE_EXPRESSION);

		tcgParameterEClass = createEClass(TCG_PARAMETER);
		createEAttribute(tcgParameterEClass, TCG_PARAMETER__NAME);
		createEReference(tcgParameterEClass, TCG_PARAMETER__VALUE_TYPE);
		createEReference(tcgParameterEClass, TCG_PARAMETER__REFERENCE);
		createEReference(tcgParameterEClass, TCG_PARAMETER__CONTAINER);

		tcgPrimitiveParameterEClass = createEClass(TCG_PRIMITIVE_PARAMETER);
		createEReference(tcgPrimitiveParameterEClass, TCG_PRIMITIVE_PARAMETER__VALUE_TYPE_RANGE);

		tcgComplexParameterEClass = createEClass(TCG_COMPLEX_PARAMETER);
		createEReference(tcgComplexParameterEClass, TCG_COMPLEX_PARAMETER__PARAMETER);

		tcgElementEClass = createEClass(TCG_ELEMENT);

		// Create enums
		variableClassificationEEnum = createEEnum(VARIABLE_CLASSIFICATION);
		tcgNodeTypeEEnum = createEEnum(TCG_NODE_TYPE);
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
		tcgNodeEClass.getESuperTypes().add(this.getTCGElement());
		tcgRealNodeEClass.getESuperTypes().add(this.getTCGNode());
		tcgIntermediateNodeEClass.getESuperTypes().add(this.getTCGNode());
		tcgTransitionEClass.getESuperTypes().add(this.getTCGElement());
		tcgoclOperationEClass.getESuperTypes().add(this.getTCGOCLExpression());
		tcgoclAtomEClass.getESuperTypes().add(this.getTCGOCLExpression());
		tcgoclIfThenElseEClass.getESuperTypes().add(this.getTCGOCLExpression());
		tcgPrimitiveParameterEClass.getESuperTypes().add(this.getTCGParameter());
		tcgComplexParameterEClass.getESuperTypes().add(this.getTCGParameter());

		// Initialize classes and features; add operations and parameters
		initEClass(tcgNodeEClass, TCGNode.class, "TCGNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTCGNode_Name(), ecorePackage.getEString(), "name", null, 1, 1, TCGNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTCGNode_IncomingTransitions(), this.getTCGTransition(), null, "incomingTransitions", null, 0, -1, TCGNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTCGNode_OutgoingTransitions(), this.getTCGTransition(), null, "outgoingTransitions", null, 0, -1, TCGNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTCGNode_OriginalNode(), ecorePackage.getEObject(), null, "originalNode", null, 1, 1, TCGNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTCGNode_UseAllTransitionsInParallel(), ecorePackage.getEBoolean(), "useAllTransitionsInParallel", "false", 1, 1, TCGNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTCGNode_ReferencedSubmachine(), this.getTestCaseGraph(), null, "referencedSubmachine", null, 0, 1, TCGNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTCGNode_MinDistanceFromStart(), ecorePackage.getEInt(), "minDistanceFromStart", "-1", 1, 1, TCGNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTCGNode_MaxDistanceFromStart(), ecorePackage.getEInt(), "maxDistanceFromStart", "-1", 1, 1, TCGNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tcgRealNodeEClass, TCGRealNode.class, "TCGRealNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTCGRealNode_Condition(), this.getTCGDisjunctiveNormalForm(), null, "condition", null, 0, 1, TCGRealNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTCGRealNode_SubGraph(), this.getTestCaseGraph(), null, "subGraph", null, 0, 1, TCGRealNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTCGRealNode_ContainedConnectionPointReferences(), this.getTCGIntermediateNode(), null, "containedConnectionPointReferences", null, 0, -1, TCGRealNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTCGRealNode_ContainedConnectionPoints(), this.getTCGIntermediateNode(), null, "containedConnectionPoints", null, 0, -1, TCGRealNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTCGRealNode_Container(), this.getTestCaseRegion(), null, "container", null, 1, 1, TCGRealNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tcgIntermediateNodeEClass, TCGIntermediateNode.class, "TCGIntermediateNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTCGIntermediateNode_ReferencedConnectionPointReferences(), this.getTCGIntermediateNode(), null, "referencedConnectionPointReferences", null, 0, -1, TCGIntermediateNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTCGIntermediateNode_ReferencedConnectionPoints(), this.getTCGIntermediateNode(), null, "referencedConnectionPoints", null, 0, -1, TCGIntermediateNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTCGIntermediateNode_Container(), ecorePackage.getEObject(), null, "container", null, 0, 1, TCGIntermediateNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTCGIntermediateNode_NodeType(), this.getTCGNodeType(), "nodeType", "unknown", 1, 1, TCGIntermediateNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(testCaseRegionEClass, TestCaseRegion.class, "TestCaseRegion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTestCaseRegion_Nodes(), this.getTCGNode(), null, "nodes", null, 0, -1, TestCaseRegion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTestCaseRegion_Transitions(), this.getTCGTransition(), this.getTCGTransition_Container(), "transitions", null, 0, -1, TestCaseRegion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTestCaseRegion_Container(), this.getTestCaseGraph(), this.getTestCaseGraph_Regions(), "container", null, 1, 1, TestCaseRegion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(testCaseGraphEClass, TestCaseGraph.class, "TestCaseGraph", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTestCaseGraph_Regions(), this.getTestCaseRegion(), this.getTestCaseRegion_Container(), "regions", null, 0, -1, TestCaseGraph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTestCaseGraph_CompositeSuperState(), this.getTCGRealNode(), null, "compositeSuperState", null, 0, 1, TestCaseGraph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTestCaseGraph_ContainedConnectionPoints(), this.getTCGIntermediateNode(), null, "containedConnectionPoints", null, 0, -1, TestCaseGraph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTestCaseGraph_SubmachineStates(), this.getTCGRealNode(), null, "submachineStates", null, 0, -1, TestCaseGraph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tcgTransitionEClass, TCGTransition.class, "TCGTransition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTCGTransition_Name(), ecorePackage.getEString(), "name", null, 1, 1, TCGTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTCGTransition_SourceNode(), this.getTCGNode(), null, "sourceNode", null, 1, 1, TCGTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTCGTransition_TargetNode(), this.getTCGNode(), null, "targetNode", null, 1, 1, TCGTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTCGTransition_Events(), this.getTCGEvent(), null, "events", null, 0, -1, TCGTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTCGTransition_Precondition(), this.getTCGDisjunctiveNormalForm(), null, "precondition", null, 1, 1, TCGTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTCGTransition_Postcondition(), this.getTCGDisjunctiveNormalForm(), null, "postcondition", null, 1, 1, TCGTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTCGTransition_Container(), this.getTestCaseRegion(), this.getTestCaseRegion_Transitions(), "container", null, 1, 1, TCGTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTCGTransition_CanBeProcessed(), ecorePackage.getEBoolean(), "canBeProcessed", "true", 1, 1, TCGTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tcgEquivalenceClassEClass, TCGEquivalenceClass.class, "TCGEquivalenceClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTCGEquivalenceClass_MinBorder(), ecorePackage.getEDoubleObject(), "minBorder", null, 1, 1, TCGEquivalenceClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTCGEquivalenceClass_MinIncluded(), ecorePackage.getEBooleanObject(), "minIncluded", null, 1, 1, TCGEquivalenceClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTCGEquivalenceClass_MaxBorder(), ecorePackage.getEDoubleObject(), "maxBorder", null, 1, 1, TCGEquivalenceClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTCGEquivalenceClass_MaxIncluded(), ecorePackage.getEBooleanObject(), "maxIncluded", null, 1, 1, TCGEquivalenceClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tcgEventEClass, TCGEvent.class, "TCGEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTCGEvent_Name(), ecorePackage.getEString(), "name", null, 1, 1, TCGEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTCGEvent_Parameters(), this.getTCGParameter(), null, "parameters", null, 0, -1, TCGEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTCGEvent_Event(), ecorePackage.getEObject(), null, "event", null, 0, 1, TCGEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTCGEvent_DefaultEvent(), ecorePackage.getEBoolean(), "defaultEvent", "false", 1, 1, TCGEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(tcgEventEClass, ecorePackage.getEBoolean(), "equals", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "obj", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(tcgoclExpressionEClass, TCGOCLExpression.class, "TCGOCLExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTCGOCLExpression_Classification(), this.getVariableClassification(), "classification", null, 1, 1, TCGOCLExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTCGOCLExpression_OclReference(), ecorePackage.getEObject(), null, "oclReference", null, 0, 1, TCGOCLExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTCGOCLExpression_Container(), this.getTCGElement(), null, "container", null, 1, 1, TCGOCLExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTCGOCLExpression_PositiveAssignmentOfOriginal(), ecorePackage.getEBoolean(), "positiveAssignmentOfOriginal", "true", 1, 1, TCGOCLExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTCGOCLExpression_TransitionContext(), this.getTCGTransition(), null, "transitionContext", null, 0, 1, TCGOCLExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tcgConjunctionEClass, TCGConjunction.class, "TCGConjunction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTCGConjunction_Expressions(), this.getTCGOCLExpression(), null, "expressions", null, 1, -1, TCGConjunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTCGConjunction_CanChangeValueIfOneExpressionChanges(), ecorePackage.getEBoolean(), "canChangeValueIfOneExpressionChanges", "true", 1, 1, TCGConjunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTCGConjunction_PositiveSubExpressionOfOriginal(), ecorePackage.getEBoolean(), "positiveSubExpressionOfOriginal", "true", 1, 1, TCGConjunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tcgDisjunctiveNormalFormEClass, TCGDisjunctiveNormalForm.class, "TCGDisjunctiveNormalForm", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTCGDisjunctiveNormalForm_Conjunctions(), this.getTCGConjunction(), null, "conjunctions", null, 0, -1, TCGDisjunctiveNormalForm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTCGDisjunctiveNormalForm_OriginalExpression(), this.getTCGOCLExpression(), null, "originalExpression", null, 0, 1, TCGDisjunctiveNormalForm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTCGDisjunctiveNormalForm_UseForTestGoals(), ecorePackage.getEBoolean(), "useForTestGoals", "true", 1, 1, TCGDisjunctiveNormalForm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tcgoclOperationEClass, TCGOCLOperation.class, "TCGOCLOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTCGOCLOperation_Left(), this.getTCGOCLExpression(), null, "left", null, 0, 1, TCGOCLOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTCGOCLOperation_Right(), this.getTCGOCLExpression(), null, "right", null, 0, 1, TCGOCLOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTCGOCLOperation_Operation(), ecorePackage.getEObject(), null, "operation", null, 0, 1, TCGOCLOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTCGOCLOperation_OperationName(), ecorePackage.getEString(), "operationName", null, 0, 1, TCGOCLOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tcgoclAtomEClass, TCGOCLAtom.class, "TCGOCLAtom", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTCGOCLAtom_Element(), ecorePackage.getEObject(), null, "element", null, 0, 1, TCGOCLAtom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTCGOCLAtom_TcgParameter(), ecorePackage.getEObject(), null, "tcgParameter", null, 0, 1, TCGOCLAtom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tcgoclIfThenElseEClass, TCGOCLIfThenElse.class, "TCGOCLIfThenElse", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTCGOCLIfThenElse_Condition(), this.getTCGOCLExpression(), null, "condition", null, 1, 1, TCGOCLIfThenElse.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTCGOCLIfThenElse_ThenExpression(), this.getTCGOCLExpression(), null, "thenExpression", null, 1, 1, TCGOCLIfThenElse.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTCGOCLIfThenElse_ElseExpression(), this.getTCGOCLExpression(), null, "elseExpression", null, 1, 1, TCGOCLIfThenElse.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tcgParameterEClass, TCGParameter.class, "TCGParameter", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTCGParameter_Name(), ecorePackage.getEString(), "name", null, 1, 1, TCGParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTCGParameter_ValueType(), ecorePackage.getEObject(), null, "valueType", null, 1, 1, TCGParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTCGParameter_Reference(), ecorePackage.getEObject(), null, "reference", null, 0, 1, TCGParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTCGParameter_Container(), this.getTCGComplexParameter(), this.getTCGComplexParameter_Parameter(), "container", null, 0, 1, TCGParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tcgPrimitiveParameterEClass, TCGPrimitiveParameter.class, "TCGPrimitiveParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTCGPrimitiveParameter_ValueTypeRange(), ecorePackage.getEObject(), null, "valueTypeRange", null, 1, 1, TCGPrimitiveParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tcgComplexParameterEClass, TCGComplexParameter.class, "TCGComplexParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTCGComplexParameter_Parameter(), this.getTCGParameter(), this.getTCGParameter_Container(), "parameter", null, 0, -1, TCGComplexParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tcgElementEClass, TCGElement.class, "TCGElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Initialize enums and add enum literals
		initEEnum(variableClassificationEEnum, VariableClassification.class, "VariableClassification");
		addEEnumLiteral(variableClassificationEEnum, VariableClassification.ACTIVE_DEPENDENT);
		addEEnumLiteral(variableClassificationEEnum, VariableClassification.INDEPENDENT);
		addEEnumLiteral(variableClassificationEEnum, VariableClassification.INPUT_PARAMETER);
		addEEnumLiteral(variableClassificationEEnum, VariableClassification.PASSIVE_DEPENDENT);
		addEEnumLiteral(variableClassificationEEnum, VariableClassification.UNKNOWN);

		initEEnum(tcgNodeTypeEEnum, TCGNodeType.class, "TCGNodeType");
		addEEnumLiteral(tcgNodeTypeEEnum, TCGNodeType.UNKNOWN);
		addEEnumLiteral(tcgNodeTypeEEnum, TCGNodeType.TEMPORARY);
		addEEnumLiteral(tcgNodeTypeEEnum, TCGNodeType.INITIAL);
		addEEnumLiteral(tcgNodeTypeEEnum, TCGNodeType.ENTRY);
		addEEnumLiteral(tcgNodeTypeEEnum, TCGNodeType.EXIT);
		addEEnumLiteral(tcgNodeTypeEEnum, TCGNodeType.DECISION);

		// Create resource
		createResource(eNS_URI);
	}

} //GeneratedPackageImpl
