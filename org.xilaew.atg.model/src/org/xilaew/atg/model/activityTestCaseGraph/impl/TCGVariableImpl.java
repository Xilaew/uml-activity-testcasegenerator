/**
 */
package org.xilaew.atg.model.activityTestCaseGraph.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.xilaew.atg.model.abstractTestCaseGraph.impl.AbstractTCGElementImpl;

import org.xilaew.atg.model.activityTestCaseGraph.ActivityTestCaseGraphPackage;
import org.xilaew.atg.model.activityTestCaseGraph.TCGOCLVariableCallExp;
import org.xilaew.atg.model.activityTestCaseGraph.TCGVariable;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TCG Variable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.xilaew.atg.model.activityTestCaseGraph.impl.TCGVariableImpl#getReferencedBy <em>Referenced By</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TCGVariableImpl extends AbstractTCGElementImpl implements TCGVariable {
	/**
	 * The cached value of the '{@link #getReferencedBy() <em>Referenced By</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferencedBy()
	 * @generated
	 * @ordered
	 */
	protected EList<TCGOCLVariableCallExp> referencedBy;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TCGVariableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ActivityTestCaseGraphPackage.Literals.TCG_VARIABLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TCGOCLVariableCallExp> getReferencedBy() {
		if (referencedBy == null) {
			referencedBy = new EObjectWithInverseResolvingEList<TCGOCLVariableCallExp>(TCGOCLVariableCallExp.class, this, ActivityTestCaseGraphPackage.TCG_VARIABLE__REFERENCED_BY, ActivityTestCaseGraphPackage.TCGOCL_VARIABLE_CALL_EXP__VARIABLE);
		}
		return referencedBy;
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
			case ActivityTestCaseGraphPackage.TCG_VARIABLE__REFERENCED_BY:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getReferencedBy()).basicAdd(otherEnd, msgs);
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
			case ActivityTestCaseGraphPackage.TCG_VARIABLE__REFERENCED_BY:
				return ((InternalEList<?>)getReferencedBy()).basicRemove(otherEnd, msgs);
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
			case ActivityTestCaseGraphPackage.TCG_VARIABLE__REFERENCED_BY:
				return getReferencedBy();
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
			case ActivityTestCaseGraphPackage.TCG_VARIABLE__REFERENCED_BY:
				getReferencedBy().clear();
				getReferencedBy().addAll((Collection<? extends TCGOCLVariableCallExp>)newValue);
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
			case ActivityTestCaseGraphPackage.TCG_VARIABLE__REFERENCED_BY:
				getReferencedBy().clear();
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
			case ActivityTestCaseGraphPackage.TCG_VARIABLE__REFERENCED_BY:
				return referencedBy != null && !referencedBy.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TCGVariableImpl
