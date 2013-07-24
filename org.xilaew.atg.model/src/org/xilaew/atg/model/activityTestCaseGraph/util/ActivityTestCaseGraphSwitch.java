/**
 */
package org.xilaew.atg.model.activityTestCaseGraph.util;

import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGConstraint;
import org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGContainer;
import org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGEdge;
import org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGElement;
import org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGNode;
import org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGPseudoNode;
import org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGRealNode;

import org.xilaew.atg.model.activityTestCaseGraph.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.xilaew.atg.model.activityTestCaseGraph.ActivityTestCaseGraphPackage
 * @generated
 */
public class ActivityTestCaseGraphSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ActivityTestCaseGraphPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivityTestCaseGraphSwitch() {
		if (modelPackage == null) {
			modelPackage = ActivityTestCaseGraphPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case ActivityTestCaseGraphPackage.TCG_ACTIVITY: {
				TCGActivity tcgActivity = (TCGActivity)theEObject;
				T result = caseTCGActivity(tcgActivity);
				if (result == null) result = caseAbstractTCGContainer(tcgActivity);
				if (result == null) result = caseAbstractTCGElement(tcgActivity);
				if (result == null) result = caseEModelElement(tcgActivity);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActivityTestCaseGraphPackage.TCG_ACTION: {
				TCGAction tcgAction = (TCGAction)theEObject;
				T result = caseTCGAction(tcgAction);
				if (result == null) result = caseAbstractTCGRealNode(tcgAction);
				if (result == null) result = caseAbstractTCGNode(tcgAction);
				if (result == null) result = caseAbstractTCGElement(tcgAction);
				if (result == null) result = caseEModelElement(tcgAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActivityTestCaseGraphPackage.TCG_CONTROL_FLOW: {
				TCGControlFlow tcgControlFlow = (TCGControlFlow)theEObject;
				T result = caseTCGControlFlow(tcgControlFlow);
				if (result == null) result = caseAbstractTCGEdge(tcgControlFlow);
				if (result == null) result = caseAbstractTCGElement(tcgControlFlow);
				if (result == null) result = caseEModelElement(tcgControlFlow);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActivityTestCaseGraphPackage.TCG_CONTROL_NODE: {
				TCGControlNode tcgControlNode = (TCGControlNode)theEObject;
				T result = caseTCGControlNode(tcgControlNode);
				if (result == null) result = caseAbstractTCGPseudoNode(tcgControlNode);
				if (result == null) result = caseAbstractTCGNode(tcgControlNode);
				if (result == null) result = caseAbstractTCGElement(tcgControlNode);
				if (result == null) result = caseEModelElement(tcgControlNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActivityTestCaseGraphPackage.TCG_STRUCTURED_ACTIVITY_NODE: {
				TCGStructuredActivityNode tcgStructuredActivityNode = (TCGStructuredActivityNode)theEObject;
				T result = caseTCGStructuredActivityNode(tcgStructuredActivityNode);
				if (result == null) result = caseAbstractTCGContainer(tcgStructuredActivityNode);
				if (result == null) result = caseAbstractTCGNode(tcgStructuredActivityNode);
				if (result == null) result = caseAbstractTCGElement(tcgStructuredActivityNode);
				if (result == null) result = caseEModelElement(tcgStructuredActivityNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActivityTestCaseGraphPackage.TCG_VARIABLE: {
				TCGVariable tcgVariable = (TCGVariable)theEObject;
				T result = caseTCGVariable(tcgVariable);
				if (result == null) result = caseAbstractTCGElement(tcgVariable);
				if (result == null) result = caseEModelElement(tcgVariable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActivityTestCaseGraphPackage.TCG_OBJECT_VARIABLE: {
				TCGObjectVariable tcgObjectVariable = (TCGObjectVariable)theEObject;
				T result = caseTCGObjectVariable(tcgObjectVariable);
				if (result == null) result = caseTCGVariable(tcgObjectVariable);
				if (result == null) result = caseAbstractTCGElement(tcgObjectVariable);
				if (result == null) result = caseEModelElement(tcgObjectVariable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActivityTestCaseGraphPackage.TCG_BASIC_VARIABLE: {
				TCGBasicVariable tcgBasicVariable = (TCGBasicVariable)theEObject;
				T result = caseTCGBasicVariable(tcgBasicVariable);
				if (result == null) result = caseTCGVariable(tcgBasicVariable);
				if (result == null) result = caseAbstractTCGElement(tcgBasicVariable);
				if (result == null) result = caseEModelElement(tcgBasicVariable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActivityTestCaseGraphPackage.TCGOCL_EXPRESSION: {
				TCGOCLExpression tcgoclExpression = (TCGOCLExpression)theEObject;
				T result = caseTCGOCLExpression(tcgoclExpression);
				if (result == null) result = caseAbstractTCGConstraint(tcgoclExpression);
				if (result == null) result = caseAbstractTCGElement(tcgoclExpression);
				if (result == null) result = caseEModelElement(tcgoclExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActivityTestCaseGraphPackage.TCGOCL_OPERATION_CALL_EXP: {
				TCGOCLOperationCallExp tcgoclOperationCallExp = (TCGOCLOperationCallExp)theEObject;
				T result = caseTCGOCLOperationCallExp(tcgoclOperationCallExp);
				if (result == null) result = caseTCGOCLExpression(tcgoclOperationCallExp);
				if (result == null) result = caseAbstractTCGConstraint(tcgoclOperationCallExp);
				if (result == null) result = caseAbstractTCGElement(tcgoclOperationCallExp);
				if (result == null) result = caseEModelElement(tcgoclOperationCallExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActivityTestCaseGraphPackage.TCGOCL_VARIABLE_CALL_EXP: {
				TCGOCLVariableCallExp tcgoclVariableCallExp = (TCGOCLVariableCallExp)theEObject;
				T result = caseTCGOCLVariableCallExp(tcgoclVariableCallExp);
				if (result == null) result = caseTCGOCLExpression(tcgoclVariableCallExp);
				if (result == null) result = caseAbstractTCGConstraint(tcgoclVariableCallExp);
				if (result == null) result = caseAbstractTCGElement(tcgoclVariableCallExp);
				if (result == null) result = caseEModelElement(tcgoclVariableCallExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActivityTestCaseGraphPackage.TCGOCL_LITERAL_EXP: {
				TCGOCLLiteralExp tcgoclLiteralExp = (TCGOCLLiteralExp)theEObject;
				T result = caseTCGOCLLiteralExp(tcgoclLiteralExp);
				if (result == null) result = caseTCGOCLExpression(tcgoclLiteralExp);
				if (result == null) result = caseAbstractTCGConstraint(tcgoclLiteralExp);
				if (result == null) result = caseAbstractTCGElement(tcgoclLiteralExp);
				if (result == null) result = caseEModelElement(tcgoclLiteralExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TCG Activity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TCG Activity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTCGActivity(TCGActivity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TCG Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TCG Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTCGAction(TCGAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TCG Control Flow</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TCG Control Flow</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTCGControlFlow(TCGControlFlow object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TCG Control Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TCG Control Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTCGControlNode(TCGControlNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TCG Structured Activity Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TCG Structured Activity Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTCGStructuredActivityNode(TCGStructuredActivityNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TCG Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TCG Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTCGVariable(TCGVariable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TCG Object Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TCG Object Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTCGObjectVariable(TCGObjectVariable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TCG Basic Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TCG Basic Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTCGBasicVariable(TCGBasicVariable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TCGOCL Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TCGOCL Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTCGOCLExpression(TCGOCLExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TCGOCL Operation Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TCGOCL Operation Call Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTCGOCLOperationCallExp(TCGOCLOperationCallExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TCGOCL Variable Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TCGOCL Variable Call Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTCGOCLVariableCallExp(TCGOCLVariableCallExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TCGOCL Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TCGOCL Literal Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTCGOCLLiteralExp(TCGOCLLiteralExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EModel Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EModel Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEModelElement(EModelElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract TCG Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract TCG Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractTCGElement(AbstractTCGElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract TCG Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract TCG Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractTCGContainer(AbstractTCGContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract TCG Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract TCG Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractTCGNode(AbstractTCGNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract TCG Real Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract TCG Real Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractTCGRealNode(AbstractTCGRealNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract TCG Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract TCG Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractTCGEdge(AbstractTCGEdge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract TCG Pseudo Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract TCG Pseudo Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractTCGPseudoNode(AbstractTCGPseudoNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract TCG Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract TCG Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractTCGConstraint(AbstractTCGConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //ActivityTestCaseGraphSwitch
