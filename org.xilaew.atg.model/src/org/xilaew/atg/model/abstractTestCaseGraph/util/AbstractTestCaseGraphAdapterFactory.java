/**
 */
package org.xilaew.atg.model.abstractTestCaseGraph.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;

import org.xilaew.atg.model.abstractTestCaseGraph.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.xilaew.atg.model.abstractTestCaseGraph.AbstractTestCaseGraphPackage
 * @generated
 */
public class AbstractTestCaseGraphAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static AbstractTestCaseGraphPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractTestCaseGraphAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = AbstractTestCaseGraphPackage.eINSTANCE;
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
	protected AbstractTestCaseGraphSwitch<Adapter> modelSwitch =
		new AbstractTestCaseGraphSwitch<Adapter>() {
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
			public Adapter caseAbstractTCGEdge(AbstractTCGEdge object) {
				return createAbstractTCGEdgeAdapter();
			}
			@Override
			public Adapter caseAbstractTCGRealNode(AbstractTCGRealNode object) {
				return createAbstractTCGRealNodeAdapter();
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
			public Adapter caseEModelElement(EModelElement object) {
				return createEModelElementAdapter();
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

} //AbstractTestCaseGraphAdapterFactory
