/**
 */
package org.xilaew.atg.model.abstractTestCaseGraph.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGContainer;
import org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGEdge;
import org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGNode;
import org.xilaew.atg.model.abstractTestCaseGraph.AbstractTestCaseGraphPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract TCG Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.xilaew.atg.model.abstractTestCaseGraph.impl.AbstractTCGContainerImpl#getNodes <em>Nodes</em>}</li>
 *   <li>{@link org.xilaew.atg.model.abstractTestCaseGraph.impl.AbstractTCGContainerImpl#getEdges <em>Edges</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AbstractTCGContainerImpl extends AbstractTCGElementImpl implements AbstractTCGContainer {
	/**
	 * The cached value of the '{@link #getNodes() <em>Nodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractTCGNode> nodes;

	/**
	 * The cached value of the '{@link #getEdges() <em>Edges</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEdges()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractTCGEdge> edges;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractTCGContainerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AbstractTestCaseGraphPackage.Literals.ABSTRACT_TCG_CONTAINER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractTCGNode> getNodes() {
		if (nodes == null) {
			nodes = new EObjectContainmentEList<AbstractTCGNode>(AbstractTCGNode.class, this, AbstractTestCaseGraphPackage.ABSTRACT_TCG_CONTAINER__NODES);
		}
		return nodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractTCGEdge> getEdges() {
		if (edges == null) {
			edges = new EObjectContainmentEList<AbstractTCGEdge>(AbstractTCGEdge.class, this, AbstractTestCaseGraphPackage.ABSTRACT_TCG_CONTAINER__EDGES);
		}
		return edges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AbstractTestCaseGraphPackage.ABSTRACT_TCG_CONTAINER__NODES:
				return ((InternalEList<?>)getNodes()).basicRemove(otherEnd, msgs);
			case AbstractTestCaseGraphPackage.ABSTRACT_TCG_CONTAINER__EDGES:
				return ((InternalEList<?>)getEdges()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AbstractTestCaseGraphPackage.ABSTRACT_TCG_CONTAINER__NODES:
				return getNodes();
			case AbstractTestCaseGraphPackage.ABSTRACT_TCG_CONTAINER__EDGES:
				return getEdges();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case AbstractTestCaseGraphPackage.ABSTRACT_TCG_CONTAINER__NODES:
				getNodes().clear();
				getNodes().addAll((Collection<? extends AbstractTCGNode>)newValue);
				return;
			case AbstractTestCaseGraphPackage.ABSTRACT_TCG_CONTAINER__EDGES:
				getEdges().clear();
				getEdges().addAll((Collection<? extends AbstractTCGEdge>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case AbstractTestCaseGraphPackage.ABSTRACT_TCG_CONTAINER__NODES:
				getNodes().clear();
				return;
			case AbstractTestCaseGraphPackage.ABSTRACT_TCG_CONTAINER__EDGES:
				getEdges().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case AbstractTestCaseGraphPackage.ABSTRACT_TCG_CONTAINER__NODES:
				return nodes != null && !nodes.isEmpty();
			case AbstractTestCaseGraphPackage.ABSTRACT_TCG_CONTAINER__EDGES:
				return edges != null && !edges.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //AbstractTCGContainerImpl
