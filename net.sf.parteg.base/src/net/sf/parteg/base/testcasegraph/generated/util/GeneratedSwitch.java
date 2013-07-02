/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.sf.parteg.base.testcasegraph.generated.util;

import java.util.List;

import net.sf.parteg.base.testcasegraph.generated.*;
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
import net.sf.parteg.base.testcasegraph.generated.TCGParameter;
import net.sf.parteg.base.testcasegraph.generated.TCGPrimitiveParameter;
import net.sf.parteg.base.testcasegraph.generated.TCGTransition;
import net.sf.parteg.base.testcasegraph.generated.TestCaseGraph;
import net.sf.parteg.base.testcasegraph.generated.TestCaseRegion;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

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
 * @see net.sf.parteg.base.testcasegraph.generated.GeneratedPackage
 * @generated
 */
public class GeneratedSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static GeneratedPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeneratedSwitch() {
		if (modelPackage == null) {
			modelPackage = GeneratedPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case GeneratedPackage.TCG_NODE: {
				TCGNode tcgNode = (TCGNode)theEObject;
				T result = caseTCGNode(tcgNode);
				if (result == null) result = caseTCGElement(tcgNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedPackage.TCG_REAL_NODE: {
				TCGRealNode tcgRealNode = (TCGRealNode)theEObject;
				T result = caseTCGRealNode(tcgRealNode);
				if (result == null) result = caseTCGNode(tcgRealNode);
				if (result == null) result = caseTCGElement(tcgRealNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedPackage.TCG_INTERMEDIATE_NODE: {
				TCGIntermediateNode tcgIntermediateNode = (TCGIntermediateNode)theEObject;
				T result = caseTCGIntermediateNode(tcgIntermediateNode);
				if (result == null) result = caseTCGNode(tcgIntermediateNode);
				if (result == null) result = caseTCGElement(tcgIntermediateNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedPackage.TEST_CASE_REGION: {
				TestCaseRegion testCaseRegion = (TestCaseRegion)theEObject;
				T result = caseTestCaseRegion(testCaseRegion);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedPackage.TEST_CASE_GRAPH: {
				TestCaseGraph testCaseGraph = (TestCaseGraph)theEObject;
				T result = caseTestCaseGraph(testCaseGraph);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedPackage.TCG_TRANSITION: {
				TCGTransition tcgTransition = (TCGTransition)theEObject;
				T result = caseTCGTransition(tcgTransition);
				if (result == null) result = caseTCGElement(tcgTransition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedPackage.TCG_EQUIVALENCE_CLASS: {
				TCGEquivalenceClass tcgEquivalenceClass = (TCGEquivalenceClass)theEObject;
				T result = caseTCGEquivalenceClass(tcgEquivalenceClass);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedPackage.TCG_EVENT: {
				TCGEvent tcgEvent = (TCGEvent)theEObject;
				T result = caseTCGEvent(tcgEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedPackage.TCGOCL_EXPRESSION: {
				TCGOCLExpression tcgoclExpression = (TCGOCLExpression)theEObject;
				T result = caseTCGOCLExpression(tcgoclExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedPackage.TCG_CONJUNCTION: {
				TCGConjunction tcgConjunction = (TCGConjunction)theEObject;
				T result = caseTCGConjunction(tcgConjunction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedPackage.TCG_DISJUNCTIVE_NORMAL_FORM: {
				TCGDisjunctiveNormalForm tcgDisjunctiveNormalForm = (TCGDisjunctiveNormalForm)theEObject;
				T result = caseTCGDisjunctiveNormalForm(tcgDisjunctiveNormalForm);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedPackage.TCGOCL_OPERATION: {
				TCGOCLOperation tcgoclOperation = (TCGOCLOperation)theEObject;
				T result = caseTCGOCLOperation(tcgoclOperation);
				if (result == null) result = caseTCGOCLExpression(tcgoclOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedPackage.TCGOCL_ATOM: {
				TCGOCLAtom tcgoclAtom = (TCGOCLAtom)theEObject;
				T result = caseTCGOCLAtom(tcgoclAtom);
				if (result == null) result = caseTCGOCLExpression(tcgoclAtom);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedPackage.TCGOCL_IF_THEN_ELSE: {
				TCGOCLIfThenElse tcgoclIfThenElse = (TCGOCLIfThenElse)theEObject;
				T result = caseTCGOCLIfThenElse(tcgoclIfThenElse);
				if (result == null) result = caseTCGOCLExpression(tcgoclIfThenElse);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedPackage.TCG_PARAMETER: {
				TCGParameter tcgParameter = (TCGParameter)theEObject;
				T result = caseTCGParameter(tcgParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedPackage.TCG_PRIMITIVE_PARAMETER: {
				TCGPrimitiveParameter tcgPrimitiveParameter = (TCGPrimitiveParameter)theEObject;
				T result = caseTCGPrimitiveParameter(tcgPrimitiveParameter);
				if (result == null) result = caseTCGParameter(tcgPrimitiveParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedPackage.TCG_COMPLEX_PARAMETER: {
				TCGComplexParameter tcgComplexParameter = (TCGComplexParameter)theEObject;
				T result = caseTCGComplexParameter(tcgComplexParameter);
				if (result == null) result = caseTCGParameter(tcgComplexParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedPackage.TCG_ELEMENT: {
				TCGElement tcgElement = (TCGElement)theEObject;
				T result = caseTCGElement(tcgElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TCG Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TCG Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTCGNode(TCGNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TCG Real Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TCG Real Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTCGRealNode(TCGRealNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TCG Intermediate Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TCG Intermediate Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTCGIntermediateNode(TCGIntermediateNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Test Case Region</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Test Case Region</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTestCaseRegion(TestCaseRegion object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Test Case Graph</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Test Case Graph</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTestCaseGraph(TestCaseGraph object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TCG Transition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TCG Transition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTCGTransition(TCGTransition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TCG Equivalence Class</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TCG Equivalence Class</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTCGEquivalenceClass(TCGEquivalenceClass object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TCG Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TCG Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTCGEvent(TCGEvent object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>TCG Conjunction</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TCG Conjunction</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTCGConjunction(TCGConjunction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TCG Disjunctive Normal Form</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TCG Disjunctive Normal Form</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTCGDisjunctiveNormalForm(TCGDisjunctiveNormalForm object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TCGOCL Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TCGOCL Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTCGOCLOperation(TCGOCLOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TCGOCL Atom</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TCGOCL Atom</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTCGOCLAtom(TCGOCLAtom object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TCGOCL If Then Else</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TCGOCL If Then Else</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTCGOCLIfThenElse(TCGOCLIfThenElse object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TCG Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TCG Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTCGParameter(TCGParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TCG Primitive Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TCG Primitive Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTCGPrimitiveParameter(TCGPrimitiveParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TCG Complex Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TCG Complex Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTCGComplexParameter(TCGComplexParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TCG Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TCG Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTCGElement(TCGElement object) {
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
	public T defaultCase(EObject object) {
		return null;
	}

} //GeneratedSwitch
