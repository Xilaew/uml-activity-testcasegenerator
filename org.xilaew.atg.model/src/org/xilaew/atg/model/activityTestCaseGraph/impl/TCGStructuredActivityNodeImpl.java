/**
 */
package org.xilaew.atg.model.activityTestCaseGraph.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGEdge;
import org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGNode;
import org.xilaew.atg.model.abstractTestCaseGraph.AbstractTestCaseGraphPackage;

import org.xilaew.atg.model.abstractTestCaseGraph.impl.AbstractTCGContainerImpl;

import org.xilaew.atg.model.activityTestCaseGraph.ActivityTestCaseGraphPackage;
import org.xilaew.atg.model.activityTestCaseGraph.TCGStructuredActivityNode;
import org.xilaew.atg.model.activityTestCaseGraph.TCGVariable;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TCG Structured Activity Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.xilaew.atg.model.activityTestCaseGraph.impl.TCGStructuredActivityNodeImpl#getOutgoing <em>Outgoing</em>}</li>
 *   <li>{@link org.xilaew.atg.model.activityTestCaseGraph.impl.TCGStructuredActivityNodeImpl#getIncoming <em>Incoming</em>}</li>
 *   <li>{@link org.xilaew.atg.model.activityTestCaseGraph.impl.TCGStructuredActivityNodeImpl#getVariables <em>Variables</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TCGStructuredActivityNodeImpl extends AbstractTCGContainerImpl implements TCGStructuredActivityNode {
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
	 * The cached value of the '{@link #getVariables() <em>Variables</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariables()
	 * @generated
	 * @ordered
	 */
	protected EList<TCGVariable> variables;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TCGStructuredActivityNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ActivityTestCaseGraphPackage.Literals.TCG_STRUCTURED_ACTIVITY_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractTCGEdge> getOutgoing() {
		if (outgoing == null) {
			outgoing = new EObjectWithInverseResolvingEList<AbstractTCGEdge>(AbstractTCGEdge.class, this, ActivityTestCaseGraphPackage.TCG_STRUCTURED_ACTIVITY_NODE__OUTGOING, AbstractTestCaseGraphPackage.ABSTRACT_TCG_EDGE__SOURCE);
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
			incoming = new EObjectWithInverseResolvingEList<AbstractTCGEdge>(AbstractTCGEdge.class, this, ActivityTestCaseGraphPackage.TCG_STRUCTURED_ACTIVITY_NODE__INCOMING, AbstractTestCaseGraphPackage.ABSTRACT_TCG_EDGE__TARGET);
		}
		return incoming;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TCGVariable> getVariables() {
		if (variables == null) {
			variables = new EObjectContainmentEList<TCGVariable>(TCGVariable.class, this, ActivityTestCaseGraphPackage.TCG_STRUCTURED_ACTIVITY_NODE__VARIABLES);
		}
		return variables;
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
			case ActivityTestCaseGraphPackage.TCG_STRUCTURED_ACTIVITY_NODE__OUTGOING:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutgoing()).basicAdd(otherEnd, msgs);
			case ActivityTestCaseGraphPackage.TCG_STRUCTURED_ACTIVITY_NODE__INCOMING:
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
			case ActivityTestCaseGraphPackage.TCG_STRUCTURED_ACTIVITY_NODE__OUTGOING:
				return ((InternalEList<?>)getOutgoing()).basicRemove(otherEnd, msgs);
			case ActivityTestCaseGraphPackage.TCG_STRUCTURED_ACTIVITY_NODE__INCOMING:
				return ((InternalEList<?>)getIncoming()).basicRemove(otherEnd, msgs);
			case ActivityTestCaseGraphPackage.TCG_STRUCTURED_ACTIVITY_NODE__VARIABLES:
				return ((InternalEList<?>)getVariables()).basicRemove(otherEnd, msgs);
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
			case ActivityTestCaseGraphPackage.TCG_STRUCTURED_ACTIVITY_NODE__OUTGOING:
				return getOutgoing();
			case ActivityTestCaseGraphPackage.TCG_STRUCTURED_ACTIVITY_NODE__INCOMING:
				return getIncoming();
			case ActivityTestCaseGraphPackage.TCG_STRUCTURED_ACTIVITY_NODE__VARIABLES:
				return getVariables();
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
			case ActivityTestCaseGraphPackage.TCG_STRUCTURED_ACTIVITY_NODE__OUTGOING:
				getOutgoing().clear();
				getOutgoing().addAll((Collection<? extends AbstractTCGEdge>)newValue);
				return;
			case ActivityTestCaseGraphPackage.TCG_STRUCTURED_ACTIVITY_NODE__INCOMING:
				getIncoming().clear();
				getIncoming().addAll((Collection<? extends AbstractTCGEdge>)newValue);
				return;
			case ActivityTestCaseGraphPackage.TCG_STRUCTURED_ACTIVITY_NODE__VARIABLES:
				getVariables().clear();
				getVariables().addAll((Collection<? extends TCGVariable>)newValue);
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
			case ActivityTestCaseGraphPackage.TCG_STRUCTURED_ACTIVITY_NODE__OUTGOING:
				getOutgoing().clear();
				return;
			case ActivityTestCaseGraphPackage.TCG_STRUCTURED_ACTIVITY_NODE__INCOMING:
				getIncoming().clear();
				return;
			case ActivityTestCaseGraphPackage.TCG_STRUCTURED_ACTIVITY_NODE__VARIABLES:
				getVariables().clear();
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
			case ActivityTestCaseGraphPackage.TCG_STRUCTURED_ACTIVITY_NODE__OUTGOING:
				return outgoing != null && !outgoing.isEmpty();
			case ActivityTestCaseGraphPackage.TCG_STRUCTURED_ACTIVITY_NODE__INCOMING:
				return incoming != null && !incoming.isEmpty();
			case ActivityTestCaseGraphPackage.TCG_STRUCTURED_ACTIVITY_NODE__VARIABLES:
				return variables != null && !variables.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == AbstractTCGNode.class) {
			switch (derivedFeatureID) {
				case ActivityTestCaseGraphPackage.TCG_STRUCTURED_ACTIVITY_NODE__OUTGOING: return AbstractTestCaseGraphPackage.ABSTRACT_TCG_NODE__OUTGOING;
				case ActivityTestCaseGraphPackage.TCG_STRUCTURED_ACTIVITY_NODE__INCOMING: return AbstractTestCaseGraphPackage.ABSTRACT_TCG_NODE__INCOMING;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == AbstractTCGNode.class) {
			switch (baseFeatureID) {
				case AbstractTestCaseGraphPackage.ABSTRACT_TCG_NODE__OUTGOING: return ActivityTestCaseGraphPackage.TCG_STRUCTURED_ACTIVITY_NODE__OUTGOING;
				case AbstractTestCaseGraphPackage.ABSTRACT_TCG_NODE__INCOMING: return ActivityTestCaseGraphPackage.TCG_STRUCTURED_ACTIVITY_NODE__INCOMING;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //TCGStructuredActivityNodeImpl
