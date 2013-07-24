/**
 */
package org.xilaew.atg.model.activityTestCaseGraph.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGConstraint;

import org.xilaew.atg.model.abstractTestCaseGraph.impl.AbstractTCGRealNodeImpl;

import org.xilaew.atg.model.activityTestCaseGraph.ActivityTestCaseGraphPackage;
import org.xilaew.atg.model.activityTestCaseGraph.TCGAction;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TCG Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.xilaew.atg.model.activityTestCaseGraph.impl.TCGActionImpl#getLocalPostconditions <em>Local Postconditions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TCGActionImpl extends AbstractTCGRealNodeImpl implements TCGAction {
	/**
	 * The cached value of the '{@link #getLocalPostconditions() <em>Local Postconditions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocalPostconditions()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractTCGConstraint> localPostconditions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TCGActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ActivityTestCaseGraphPackage.Literals.TCG_ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractTCGConstraint> getLocalPostconditions() {
		if (localPostconditions == null) {
			localPostconditions = new EObjectContainmentEList<AbstractTCGConstraint>(AbstractTCGConstraint.class, this, ActivityTestCaseGraphPackage.TCG_ACTION__LOCAL_POSTCONDITIONS);
		}
		return localPostconditions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ActivityTestCaseGraphPackage.TCG_ACTION__LOCAL_POSTCONDITIONS:
				return ((InternalEList<?>)getLocalPostconditions()).basicRemove(otherEnd, msgs);
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
			case ActivityTestCaseGraphPackage.TCG_ACTION__LOCAL_POSTCONDITIONS:
				return getLocalPostconditions();
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
			case ActivityTestCaseGraphPackage.TCG_ACTION__LOCAL_POSTCONDITIONS:
				getLocalPostconditions().clear();
				getLocalPostconditions().addAll((Collection<? extends AbstractTCGConstraint>)newValue);
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
			case ActivityTestCaseGraphPackage.TCG_ACTION__LOCAL_POSTCONDITIONS:
				getLocalPostconditions().clear();
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
			case ActivityTestCaseGraphPackage.TCG_ACTION__LOCAL_POSTCONDITIONS:
				return localPostconditions != null && !localPostconditions.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TCGActionImpl
