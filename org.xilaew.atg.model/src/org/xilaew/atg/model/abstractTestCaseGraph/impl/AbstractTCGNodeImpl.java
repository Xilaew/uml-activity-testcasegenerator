/**
 */
package org.xilaew.atg.model.abstractTestCaseGraph.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGEdge;
import org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGNode;
import org.xilaew.atg.model.abstractTestCaseGraph.AbstractTestCaseGraphPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract TCG Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.xilaew.atg.model.abstractTestCaseGraph.impl.AbstractTCGNodeImpl#getOutgoing <em>Outgoing</em>}</li>
 *   <li>{@link org.xilaew.atg.model.abstractTestCaseGraph.impl.AbstractTCGNodeImpl#getIncoming <em>Incoming</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AbstractTCGNodeImpl extends AbstractTCGElementImpl implements AbstractTCGNode {
	/**
	 * The cached value of the '{@link #getOutgoing() <em>Outgoing</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutgoing()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractTCGEdge> outgoing;

	/**
	 * The cached value of the '{@link #getIncoming() <em>Incoming</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncoming()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractTCGEdge> incoming;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractTCGNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AbstractTestCaseGraphPackage.Literals.ABSTRACT_TCG_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractTCGEdge> getOutgoing() {
		if (outgoing == null) {
			outgoing = new EObjectWithInverseResolvingEList<AbstractTCGEdge>(AbstractTCGEdge.class, this, AbstractTestCaseGraphPackage.ABSTRACT_TCG_NODE__OUTGOING, AbstractTestCaseGraphPackage.ABSTRACT_TCG_EDGE__SOURCE);
		}
		return outgoing;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractTCGEdge> getIncoming() {
		if (incoming == null) {
			incoming = new EObjectWithInverseResolvingEList<AbstractTCGEdge>(AbstractTCGEdge.class, this, AbstractTestCaseGraphPackage.ABSTRACT_TCG_NODE__INCOMING, AbstractTestCaseGraphPackage.ABSTRACT_TCG_EDGE__TARGET);
		}
		return incoming;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AbstractTestCaseGraphPackage.ABSTRACT_TCG_NODE__OUTGOING:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutgoing()).basicAdd(otherEnd, msgs);
			case AbstractTestCaseGraphPackage.ABSTRACT_TCG_NODE__INCOMING:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIncoming()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AbstractTestCaseGraphPackage.ABSTRACT_TCG_NODE__OUTGOING:
				return ((InternalEList<?>)getOutgoing()).basicRemove(otherEnd, msgs);
			case AbstractTestCaseGraphPackage.ABSTRACT_TCG_NODE__INCOMING:
				return ((InternalEList<?>)getIncoming()).basicRemove(otherEnd, msgs);
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
			case AbstractTestCaseGraphPackage.ABSTRACT_TCG_NODE__OUTGOING:
				return getOutgoing();
			case AbstractTestCaseGraphPackage.ABSTRACT_TCG_NODE__INCOMING:
				return getIncoming();
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
			case AbstractTestCaseGraphPackage.ABSTRACT_TCG_NODE__OUTGOING:
				getOutgoing().clear();
				getOutgoing().addAll((Collection<? extends AbstractTCGEdge>)newValue);
				return;
			case AbstractTestCaseGraphPackage.ABSTRACT_TCG_NODE__INCOMING:
				getIncoming().clear();
				getIncoming().addAll((Collection<? extends AbstractTCGEdge>)newValue);
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
			case AbstractTestCaseGraphPackage.ABSTRACT_TCG_NODE__OUTGOING:
				getOutgoing().clear();
				return;
			case AbstractTestCaseGraphPackage.ABSTRACT_TCG_NODE__INCOMING:
				getIncoming().clear();
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
			case AbstractTestCaseGraphPackage.ABSTRACT_TCG_NODE__OUTGOING:
				return outgoing != null && !outgoing.isEmpty();
			case AbstractTestCaseGraphPackage.ABSTRACT_TCG_NODE__INCOMING:
				return incoming != null && !incoming.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //AbstractTCGNodeImpl
