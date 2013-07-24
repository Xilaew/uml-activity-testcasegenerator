/**
 */
package org.xilaew.atg.model.abstractTestCaseGraph.util;

import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.xilaew.atg.model.abstractTestCaseGraph.*;

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
 * @see org.xilaew.atg.model.abstractTestCaseGraph.AbstractTestCaseGraphPackage
 * @generated
 */
public class AbstractTestCaseGraphSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static AbstractTestCaseGraphPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractTestCaseGraphSwitch() {
		if (modelPackage == null) {
			modelPackage = AbstractTestCaseGraphPackage.eINSTANCE;
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
			case AbstractTestCaseGraphPackage.ABSTRACT_TCG_ELEMENT: {
				AbstractTCGElement abstractTCGElement = (AbstractTCGElement)theEObject;
				T result = caseAbstractTCGElement(abstractTCGElement);
				if (result == null) result = caseEModelElement(abstractTCGElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AbstractTestCaseGraphPackage.ABSTRACT_TCG_CONTAINER: {
				AbstractTCGContainer abstractTCGContainer = (AbstractTCGContainer)theEObject;
				T result = caseAbstractTCGContainer(abstractTCGContainer);
				if (result == null) result = caseAbstractTCGElement(abstractTCGContainer);
				if (result == null) result = caseEModelElement(abstractTCGContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AbstractTestCaseGraphPackage.ABSTRACT_TCG_NODE: {
				AbstractTCGNode abstractTCGNode = (AbstractTCGNode)theEObject;
				T result = caseAbstractTCGNode(abstractTCGNode);
				if (result == null) result = caseAbstractTCGElement(abstractTCGNode);
				if (result == null) result = caseEModelElement(abstractTCGNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AbstractTestCaseGraphPackage.ABSTRACT_TCG_EDGE: {
				AbstractTCGEdge abstractTCGEdge = (AbstractTCGEdge)theEObject;
				T result = caseAbstractTCGEdge(abstractTCGEdge);
				if (result == null) result = caseAbstractTCGElement(abstractTCGEdge);
				if (result == null) result = caseEModelElement(abstractTCGEdge);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AbstractTestCaseGraphPackage.ABSTRACT_TCG_REAL_NODE: {
				AbstractTCGRealNode abstractTCGRealNode = (AbstractTCGRealNode)theEObject;
				T result = caseAbstractTCGRealNode(abstractTCGRealNode);
				if (result == null) result = caseAbstractTCGNode(abstractTCGRealNode);
				if (result == null) result = caseAbstractTCGElement(abstractTCGRealNode);
				if (result == null) result = caseEModelElement(abstractTCGRealNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AbstractTestCaseGraphPackage.ABSTRACT_TCG_PSEUDO_NODE: {
				AbstractTCGPseudoNode abstractTCGPseudoNode = (AbstractTCGPseudoNode)theEObject;
				T result = caseAbstractTCGPseudoNode(abstractTCGPseudoNode);
				if (result == null) result = caseAbstractTCGNode(abstractTCGPseudoNode);
				if (result == null) result = caseAbstractTCGElement(abstractTCGPseudoNode);
				if (result == null) result = caseEModelElement(abstractTCGPseudoNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AbstractTestCaseGraphPackage.ABSTRACT_TCG_CONSTRAINT: {
				AbstractTCGConstraint abstractTCGConstraint = (AbstractTCGConstraint)theEObject;
				T result = caseAbstractTCGConstraint(abstractTCGConstraint);
				if (result == null) result = caseAbstractTCGElement(abstractTCGConstraint);
				if (result == null) result = caseEModelElement(abstractTCGConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
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

} //AbstractTestCaseGraphSwitch
