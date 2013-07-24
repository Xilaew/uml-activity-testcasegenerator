/**
 */
package org.xilaew.atg.model.activityTestCaseGraph.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.xilaew.atg.model.activityTestCaseGraph.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ActivityTestCaseGraphFactoryImpl extends EFactoryImpl implements ActivityTestCaseGraphFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ActivityTestCaseGraphFactory init() {
		try {
			ActivityTestCaseGraphFactory theActivityTestCaseGraphFactory = (ActivityTestCaseGraphFactory)EPackage.Registry.INSTANCE.getEFactory(ActivityTestCaseGraphPackage.eNS_URI);
			if (theActivityTestCaseGraphFactory != null) {
				return theActivityTestCaseGraphFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ActivityTestCaseGraphFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivityTestCaseGraphFactoryImpl() {
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
			case ActivityTestCaseGraphPackage.TCG_ACTIVITY: return createTCGActivity();
			case ActivityTestCaseGraphPackage.TCG_ACTION: return createTCGAction();
			case ActivityTestCaseGraphPackage.TCG_CONTROL_FLOW: return createTCGControlFlow();
			case ActivityTestCaseGraphPackage.TCG_CONTROL_NODE: return createTCGControlNode();
			case ActivityTestCaseGraphPackage.TCG_STRUCTURED_ACTIVITY_NODE: return createTCGStructuredActivityNode();
			case ActivityTestCaseGraphPackage.TCG_VARIABLE: return createTCGVariable();
			case ActivityTestCaseGraphPackage.TCG_OBJECT_VARIABLE: return createTCGObjectVariable();
			case ActivityTestCaseGraphPackage.TCG_BASIC_VARIABLE: return createTCGBasicVariable();
			case ActivityTestCaseGraphPackage.TCGOCL_EXPRESSION: return createTCGOCLExpression();
			case ActivityTestCaseGraphPackage.TCGOCL_OPERATION_CALL_EXP: return createTCGOCLOperationCallExp();
			case ActivityTestCaseGraphPackage.TCGOCL_VARIABLE_CALL_EXP: return createTCGOCLVariableCallExp();
			case ActivityTestCaseGraphPackage.TCGOCL_LITERAL_EXP: return createTCGOCLLiteralExp();
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
			case ActivityTestCaseGraphPackage.TCG_BASIC_VARIABLE_TYPE:
				return createTCGBasicVariableTypeFromString(eDataType, initialValue);
			case ActivityTestCaseGraphPackage.TCGOCL_OPERATION_TYPE:
				return createTCGOCLOperationTypeFromString(eDataType, initialValue);
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
			case ActivityTestCaseGraphPackage.TCG_BASIC_VARIABLE_TYPE:
				return convertTCGBasicVariableTypeToString(eDataType, instanceValue);
			case ActivityTestCaseGraphPackage.TCGOCL_OPERATION_TYPE:
				return convertTCGOCLOperationTypeToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TCGActivity createTCGActivity() {
		TCGActivityImpl tcgActivity = new TCGActivityImpl();
		return tcgActivity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TCGAction createTCGAction() {
		TCGActionImpl tcgAction = new TCGActionImpl();
		return tcgAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TCGControlFlow createTCGControlFlow() {
		TCGControlFlowImpl tcgControlFlow = new TCGControlFlowImpl();
		return tcgControlFlow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TCGControlNode createTCGControlNode() {
		TCGControlNodeImpl tcgControlNode = new TCGControlNodeImpl();
		return tcgControlNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TCGStructuredActivityNode createTCGStructuredActivityNode() {
		TCGStructuredActivityNodeImpl tcgStructuredActivityNode = new TCGStructuredActivityNodeImpl();
		return tcgStructuredActivityNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TCGVariable createTCGVariable() {
		TCGVariableImpl tcgVariable = new TCGVariableImpl();
		return tcgVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TCGObjectVariable createTCGObjectVariable() {
		TCGObjectVariableImpl tcgObjectVariable = new TCGObjectVariableImpl();
		return tcgObjectVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TCGBasicVariable createTCGBasicVariable() {
		TCGBasicVariableImpl tcgBasicVariable = new TCGBasicVariableImpl();
		return tcgBasicVariable;
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
	public TCGOCLOperationCallExp createTCGOCLOperationCallExp() {
		TCGOCLOperationCallExpImpl tcgoclOperationCallExp = new TCGOCLOperationCallExpImpl();
		return tcgoclOperationCallExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TCGOCLVariableCallExp createTCGOCLVariableCallExp() {
		TCGOCLVariableCallExpImpl tcgoclVariableCallExp = new TCGOCLVariableCallExpImpl();
		return tcgoclVariableCallExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TCGOCLLiteralExp createTCGOCLLiteralExp() {
		TCGOCLLiteralExpImpl tcgoclLiteralExp = new TCGOCLLiteralExpImpl();
		return tcgoclLiteralExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TCGBasicVariableType createTCGBasicVariableType(String literal) {
		TCGBasicVariableType result = TCGBasicVariableType.get(literal);
		if (result == null) throw new IllegalArgumentException("The value '" + literal + "' is not a valid enumerator of '" + ActivityTestCaseGraphPackage.Literals.TCG_BASIC_VARIABLE_TYPE.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TCGBasicVariableType createTCGBasicVariableTypeFromString(EDataType eDataType, String initialValue) {
		return createTCGBasicVariableType(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTCGBasicVariableType(TCGBasicVariableType instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTCGBasicVariableTypeToString(EDataType eDataType, Object instanceValue) {
		return convertTCGBasicVariableType((TCGBasicVariableType)instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TCGOCLOperationType createTCGOCLOperationType(String literal) {
		TCGOCLOperationType result = TCGOCLOperationType.get(literal);
		if (result == null) throw new IllegalArgumentException("The value '" + literal + "' is not a valid enumerator of '" + ActivityTestCaseGraphPackage.Literals.TCGOCL_OPERATION_TYPE.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TCGOCLOperationType createTCGOCLOperationTypeFromString(EDataType eDataType, String initialValue) {
		return createTCGOCLOperationType(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTCGOCLOperationType(TCGOCLOperationType instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTCGOCLOperationTypeToString(EDataType eDataType, Object instanceValue) {
		return convertTCGOCLOperationType((TCGOCLOperationType)instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivityTestCaseGraphPackage getActivityTestCaseGraphPackage() {
		return (ActivityTestCaseGraphPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ActivityTestCaseGraphPackage getPackage() {
		return ActivityTestCaseGraphPackage.eINSTANCE;
	}

} //ActivityTestCaseGraphFactoryImpl
