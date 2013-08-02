/**
 */
package org.xilaew.atg.model.activityTestCaseGraph.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;

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
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.xilaew.atg.model.activityTestCaseGraph.ActivityTestCaseGraphPackage
 * @generated
 */
public class ActivityTestCaseGraphAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ActivityTestCaseGraphPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivityTestCaseGraphAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ActivityTestCaseGraphPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ActivityTestCaseGraphSwitch<Adapter> modelSwitch =
		new ActivityTestCaseGraphSwitch<Adapter>() {
			@Override
			public Adapter caseTCGActivity(TCGActivity object) {
				return createTCGActivityAdapter();
			}
			@Override
			public Adapter caseTCGAction(TCGAction object) {
				return createTCGActionAdapter();
			}
			@Override
			public Adapter caseTCGControlFlow(TCGControlFlow object) {
				return createTCGControlFlowAdapter();
			}
			@Override
			public Adapter caseTCGControlNode(TCGControlNode object) {
				return createTCGControlNodeAdapter();
			}
			@Override
			public Adapter caseTCGVariable(TCGVariable object) {
				return createTCGVariableAdapter();
			}
			@Override
			public Adapter caseTCGObjectVariable(TCGObjectVariable object) {
				return createTCGObjectVariableAdapter();
			}
			@Override
			public Adapter caseTCGBasicVariable(TCGBasicVariable object) {
				return createTCGBasicVariableAdapter();
			}
			@Override
			public Adapter caseTCGOCLExpression(TCGOCLExpression object) {
				return createTCGOCLExpressionAdapter();
			}
			@Override
			public Adapter caseTCGOCLOperationCallExp(TCGOCLOperationCallExp object) {
				return createTCGOCLOperationCallExpAdapter();
			}
			@Override
			public Adapter caseTCGOCLVariableCallExp(TCGOCLVariableCallExp object) {
				return createTCGOCLVariableCallExpAdapter();
			}
			@Override
			public Adapter caseTCGOCLLiteralExp(TCGOCLLiteralExp object) {
				return createTCGOCLLiteralExpAdapter();
			}
			@Override
			public Adapter caseEModelElement(EModelElement object) {
				return createEModelElementAdapter();
			}
			@Override
			public Adapter caseAbstractTCGElement(AbstractTCGElement object) {
				return createAbstractTCGElementAdapter();
			}
			@Override
			public Adapter caseAbstractTCGContainer(AbstractTCGContainer object) {
				return createAbstractTCGContainerAdapter();
			}
			@Override
			public Adapter caseAbstractTCGNode(AbstractTCGNode object) {
				return createAbstractTCGNodeAdapter();
			}
			@Override
			public Adapter caseAbstractTCGRealNode(AbstractTCGRealNode object) {
				return createAbstractTCGRealNodeAdapter();
			}
			@Override
			public Adapter caseAbstractTCGEdge(AbstractTCGEdge object) {
				return createAbstractTCGEdgeAdapter();
			}
			@Override
			public Adapter caseAbstractTCGPseudoNode(AbstractTCGPseudoNode object) {
				return createAbstractTCGPseudoNodeAdapter();
			}
			@Override
			public Adapter caseAbstractTCGConstraint(AbstractTCGConstraint object) {
				return createAbstractTCGConstraintAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.xilaew.atg.model.activityTestCaseGraph.TCGActivity <em>TCG Activity</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.xilaew.atg.model.activityTestCaseGraph.TCGActivity
	 * @generated
	 */
	public Adapter createTCGActivityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.xilaew.atg.model.activityTestCaseGraph.TCGAction <em>TCG Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.xilaew.atg.model.activityTestCaseGraph.TCGAction
	 * @generated
	 */
	public Adapter createTCGActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.xilaew.atg.model.activityTestCaseGraph.TCGControlFlow <em>TCG Control Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.xilaew.atg.model.activityTestCaseGraph.TCGControlFlow
	 * @generated
	 */
	public Adapter createTCGControlFlowAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.xilaew.atg.model.activityTestCaseGraph.TCGControlNode <em>TCG Control Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.xilaew.atg.model.activityTestCaseGraph.TCGControlNode
	 * @generated
	 */
	public Adapter createTCGControlNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.xilaew.atg.model.activityTestCaseGraph.TCGVariable <em>TCG Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.xilaew.atg.model.activityTestCaseGraph.TCGVariable
	 * @generated
	 */
	public Adapter createTCGVariableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.xilaew.atg.model.activityTestCaseGraph.TCGObjectVariable <em>TCG Object Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.xilaew.atg.model.activityTestCaseGraph.TCGObjectVariable
	 * @generated
	 */
	public Adapter createTCGObjectVariableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.xilaew.atg.model.activityTestCaseGraph.TCGBasicVariable <em>TCG Basic Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.xilaew.atg.model.activityTestCaseGraph.TCGBasicVariable
	 * @generated
	 */
	public Adapter createTCGBasicVariableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.xilaew.atg.model.activityTestCaseGraph.TCGOCLExpression <em>TCGOCL Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.xilaew.atg.model.activityTestCaseGraph.TCGOCLExpression
	 * @generated
	 */
	public Adapter createTCGOCLExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.xilaew.atg.model.activityTestCaseGraph.TCGOCLOperationCallExp <em>TCGOCL Operation Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.xilaew.atg.model.activityTestCaseGraph.TCGOCLOperationCallExp
	 * @generated
	 */
	public Adapter createTCGOCLOperationCallExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.xilaew.atg.model.activityTestCaseGraph.TCGOCLVariableCallExp <em>TCGOCL Variable Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.xilaew.atg.model.activityTestCaseGraph.TCGOCLVariableCallExp
	 * @generated
	 */
	public Adapter createTCGOCLVariableCallExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.xilaew.atg.model.activityTestCaseGraph.TCGOCLLiteralExp <em>TCGOCL Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.xilaew.atg.model.activityTestCaseGraph.TCGOCLLiteralExp
	 * @generated
	 */
	public Adapter createTCGOCLLiteralExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ecore.EModelElement <em>EModel Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ecore.EModelElement
	 * @generated
	 */
	public Adapter createEModelElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGElement <em>Abstract TCG Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGElement
	 * @generated
	 */
	public Adapter createAbstractTCGElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGContainer <em>Abstract TCG Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGContainer
	 * @generated
	 */
	public Adapter createAbstractTCGContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGNode <em>Abstract TCG Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGNode
	 * @generated
	 */
	public Adapter createAbstractTCGNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGRealNode <em>Abstract TCG Real Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGRealNode
	 * @generated
	 */
	public Adapter createAbstractTCGRealNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGEdge <em>Abstract TCG Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGEdge
	 * @generated
	 */
	public Adapter createAbstractTCGEdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGPseudoNode <em>Abstract TCG Pseudo Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGPseudoNode
	 * @generated
	 */
	public Adapter createAbstractTCGPseudoNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGConstraint <em>Abstract TCG Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGConstraint
	 * @generated
	 */
	public Adapter createAbstractTCGConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //ActivityTestCaseGraphAdapterFactory
