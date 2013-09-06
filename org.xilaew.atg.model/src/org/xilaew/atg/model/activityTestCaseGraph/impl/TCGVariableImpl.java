/**
 */
package org.xilaew.atg.model.activityTestCaseGraph.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.xilaew.atg.model.abstractTestCaseGraph.impl.AbstractTCGElementImpl;

import org.xilaew.atg.model.activityTestCaseGraph.ActivityTestCaseGraphPackage;
import org.xilaew.atg.model.activityTestCaseGraph.TCGOCLVariableCallExp;
import org.xilaew.atg.model.activityTestCaseGraph.TCGVariable;
import org.xilaew.atg.model.activityTestCaseGraph.TCGVariableUsage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TCG Variable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.xilaew.atg.model.activityTestCaseGraph.impl.TCGVariableImpl#getReferencedBy <em>Referenced By</em>}</li>
 *   <li>{@link org.xilaew.atg.model.activityTestCaseGraph.impl.TCGVariableImpl#isIsParameter <em>Is Parameter</em>}</li>
 *   <li>{@link org.xilaew.atg.model.activityTestCaseGraph.impl.TCGVariableImpl#getUsage <em>Usage</em>}</li>
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
	 * The default value of the '{@link #isIsParameter() <em>Is Parameter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsParameter()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_PARAMETER_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsParameter() <em>Is Parameter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsParameter()
	 * @generated
	 * @ordered
	 */
	protected boolean isParameter = IS_PARAMETER_EDEFAULT;

	/**
	 * The default value of the '{@link #getUsage() <em>Usage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsage()
	 * @generated
	 * @ordered
	 */
	protected static final TCGVariableUsage USAGE_EDEFAULT = TCGVariableUsage.IN_PARAMETER;

	/**
	 * The cached value of the '{@link #getUsage() <em>Usage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsage()
	 * @generated
	 * @ordered
	 */
	protected TCGVariableUsage usage = USAGE_EDEFAULT;

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
	public boolean isIsParameter() {
		return isParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsParameter(boolean newIsParameter) {
		boolean oldIsParameter = isParameter;
		isParameter = newIsParameter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActivityTestCaseGraphPackage.TCG_VARIABLE__IS_PARAMETER, oldIsParameter, isParameter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TCGVariableUsage getUsage() {
		return usage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUsage(TCGVariableUsage newUsage) {
		TCGVariableUsage oldUsage = usage;
		usage = newUsage == null ? USAGE_EDEFAULT : newUsage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActivityTestCaseGraphPackage.TCG_VARIABLE__USAGE, oldUsage, usage));
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
			case ActivityTestCaseGraphPackage.TCG_VARIABLE__IS_PARAMETER:
				return isIsParameter();
			case ActivityTestCaseGraphPackage.TCG_VARIABLE__USAGE:
				return getUsage();
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
			case ActivityTestCaseGraphPackage.TCG_VARIABLE__IS_PARAMETER:
				setIsParameter((Boolean)newValue);
				return;
			case ActivityTestCaseGraphPackage.TCG_VARIABLE__USAGE:
				setUsage((TCGVariableUsage)newValue);
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
			case ActivityTestCaseGraphPackage.TCG_VARIABLE__IS_PARAMETER:
				setIsParameter(IS_PARAMETER_EDEFAULT);
				return;
			case ActivityTestCaseGraphPackage.TCG_VARIABLE__USAGE:
				setUsage(USAGE_EDEFAULT);
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
			case ActivityTestCaseGraphPackage.TCG_VARIABLE__IS_PARAMETER:
				return isParameter != IS_PARAMETER_EDEFAULT;
			case ActivityTestCaseGraphPackage.TCG_VARIABLE__USAGE:
				return usage != USAGE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (isParameter: ");
		result.append(isParameter);
		result.append(", usage: ");
		result.append(usage);
		result.append(')');
		return result.toString();
	}

} //TCGVariableImpl
