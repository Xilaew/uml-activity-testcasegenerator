/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.sf.parteg.base.testcasegraph.generated.impl;

import net.sf.parteg.base.testcasegraph.generated.*;
import net.sf.parteg.base.testcasegraph.generated.GeneratedFactory;
import net.sf.parteg.base.testcasegraph.generated.GeneratedPackage;
import net.sf.parteg.base.testcasegraph.generated.TCGComplexParameter;
import net.sf.parteg.base.testcasegraph.generated.TCGConjunction;
import net.sf.parteg.base.testcasegraph.generated.TCGDisjunctiveNormalForm;
import net.sf.parteg.base.testcasegraph.generated.TCGElement;
import net.sf.parteg.base.testcasegraph.generated.TCGEquivalenceClass;
import net.sf.parteg.base.testcasegraph.generated.TCGEvent;
import net.sf.parteg.base.testcasegraph.generated.TCGNode;
import net.sf.parteg.base.testcasegraph.generated.TCGOCLAtom;
import net.sf.parteg.base.testcasegraph.generated.TCGOCLExpression;
import net.sf.parteg.base.testcasegraph.generated.TCGOCLIfThenElse;
import net.sf.parteg.base.testcasegraph.generated.TCGOCLOperation;
import net.sf.parteg.base.testcasegraph.generated.TCGPrimitiveParameter;
import net.sf.parteg.base.testcasegraph.generated.TCGTransition;
import net.sf.parteg.base.testcasegraph.generated.TestCaseGraph;
import net.sf.parteg.base.testcasegraph.generated.TestCaseRegion;
import net.sf.parteg.base.testcasegraph.generated.VariableClassification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
public class GeneratedFactoryImpl extends EFactoryImpl implements GeneratedFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static GeneratedFactory init() {
		try {
			GeneratedFactory theGeneratedFactory = (GeneratedFactory)EPackage.Registry.INSTANCE.getEFactory("http://net.sf.parteg.base.testcasegraph.generated"); 
			if (theGeneratedFactory != null) {
				return theGeneratedFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new GeneratedFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeneratedFactoryImpl() {
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
			case GeneratedPackage.TCG_NODE: return createTCGNode();
			case GeneratedPackage.TCG_REAL_NODE: return createTCGRealNode();
			case GeneratedPackage.TCG_INTERMEDIATE_NODE: return createTCGIntermediateNode();
			case GeneratedPackage.TEST_CASE_REGION: return createTestCaseRegion();
			case GeneratedPackage.TEST_CASE_GRAPH: return createTestCaseGraph();
			case GeneratedPackage.TCG_TRANSITION: return createTCGTransition();
			case GeneratedPackage.TCG_EQUIVALENCE_CLASS: return createTCGEquivalenceClass();
			case GeneratedPackage.TCG_EVENT: return createTCGEvent();
			case GeneratedPackage.TCGOCL_EXPRESSION: return createTCGOCLExpression();
			case GeneratedPackage.TCG_CONJUNCTION: return createTCGConjunction();
			case GeneratedPackage.TCG_DISJUNCTIVE_NORMAL_FORM: return createTCGDisjunctiveNormalForm();
			case GeneratedPackage.TCGOCL_OPERATION: return createTCGOCLOperation();
			case GeneratedPackage.TCGOCL_ATOM: return createTCGOCLAtom();
			case GeneratedPackage.TCGOCL_IF_THEN_ELSE: return createTCGOCLIfThenElse();
			case GeneratedPackage.TCG_PRIMITIVE_PARAMETER: return createTCGPrimitiveParameter();
			case GeneratedPackage.TCG_COMPLEX_PARAMETER: return createTCGComplexParameter();
			case GeneratedPackage.TCG_ELEMENT: return createTCGElement();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case GeneratedPackage.VARIABLE_CLASSIFICATION:
				return createVariableClassificationFromString(eDataType, initialValue);
			case GeneratedPackage.TCG_NODE_TYPE:
				return createTCGNodeTypeFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case GeneratedPackage.VARIABLE_CLASSIFICATION:
				return convertVariableClassificationToString(eDataType, instanceValue);
			case GeneratedPackage.TCG_NODE_TYPE:
				return convertTCGNodeTypeToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TCGNode createTCGNode() {
		TCGNodeImpl tcgNode = new TCGNodeImpl();
		return tcgNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TCGRealNode createTCGRealNode() {
		TCGRealNodeImpl tcgRealNode = new TCGRealNodeImpl();
		return tcgRealNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TCGIntermediateNode createTCGIntermediateNode() {
		TCGIntermediateNodeImpl tcgIntermediateNode = new TCGIntermediateNodeImpl();
		return tcgIntermediateNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestCaseRegion createTestCaseRegion() {
		TestCaseRegionImpl testCaseRegion = new TestCaseRegionImpl();
		return testCaseRegion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestCaseGraph createTestCaseGraph() {
		TestCaseGraphImpl testCaseGraph = new TestCaseGraphImpl();
		return testCaseGraph;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TCGTransition createTCGTransition() {
		TCGTransitionImpl tcgTransition = new TCGTransitionImpl();
		return tcgTransition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TCGEquivalenceClass createTCGEquivalenceClass() {
		TCGEquivalenceClassImpl tcgEquivalenceClass = new TCGEquivalenceClassImpl();
		return tcgEquivalenceClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TCGEvent createTCGEvent() {
		TCGEventImpl tcgEvent = new TCGEventImpl();
		return tcgEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TCGOCLExpression createTCGOCLExpression() {
		TCGOCLExpressionImpl tcgoclExpression = new TCGOCLExpressionImpl();
		return tcgoclExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TCGConjunction createTCGConjunction() {
		TCGConjunctionImpl tcgConjunction = new TCGConjunctionImpl();
		return tcgConjunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TCGDisjunctiveNormalForm createTCGDisjunctiveNormalForm() {
		TCGDisjunctiveNormalFormImpl tcgDisjunctiveNormalForm = new TCGDisjunctiveNormalFormImpl();
		return tcgDisjunctiveNormalForm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TCGOCLOperation createTCGOCLOperation() {
		TCGOCLOperationImpl tcgoclOperation = new TCGOCLOperationImpl();
		return tcgoclOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TCGOCLAtom createTCGOCLAtom() {
		TCGOCLAtomImpl tcgoclAtom = new TCGOCLAtomImpl();
		return tcgoclAtom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TCGOCLIfThenElse createTCGOCLIfThenElse() {
		TCGOCLIfThenElseImpl tcgoclIfThenElse = new TCGOCLIfThenElseImpl();
		return tcgoclIfThenElse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TCGPrimitiveParameter createTCGPrimitiveParameter() {
		TCGPrimitiveParameterImpl tcgPrimitiveParameter = new TCGPrimitiveParameterImpl();
		return tcgPrimitiveParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TCGComplexParameter createTCGComplexParameter() {
		TCGComplexParameterImpl tcgComplexParameter = new TCGComplexParameterImpl();
		return tcgComplexParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TCGElement createTCGElement() {
		TCGElementImpl tcgElement = new TCGElementImpl();
		return tcgElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableClassification createVariableClassificationFromString(EDataType eDataType, String initialValue) {
		VariableClassification result = VariableClassification.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertVariableClassificationToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TCGNodeType createTCGNodeTypeFromString(EDataType eDataType, String initialValue) {
		TCGNodeType result = TCGNodeType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTCGNodeTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeneratedPackage getGeneratedPackage() {
		return (GeneratedPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static GeneratedPackage getPackage() {
		return GeneratedPackage.eINSTANCE;
	}

} //GeneratedFactoryImpl
