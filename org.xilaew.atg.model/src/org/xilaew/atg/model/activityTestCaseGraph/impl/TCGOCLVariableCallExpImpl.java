/**
 */
package org.xilaew.atg.model.activityTestCaseGraph.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.xilaew.atg.model.activityTestCaseGraph.ActivityTestCaseGraphPackage;
import org.xilaew.atg.model.activityTestCaseGraph.TCGOCLVariableCallExp;
import org.xilaew.atg.model.activityTestCaseGraph.TCGVariable;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TCGOCL Variable Call Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.xilaew.atg.model.activityTestCaseGraph.impl.TCGOCLVariableCallExpImpl#getVariable <em>Variable</em>}</li>
 *   <li>{@link org.xilaew.atg.model.activityTestCaseGraph.impl.TCGOCLVariableCallExpImpl#isIsPre <em>Is Pre</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TCGOCLVariableCallExpImpl extends TCGOCLExpressionImpl implements TCGOCLVariableCallExp {
	/**
	 * The cached value of the '{@link #getVariable() <em>Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariable()
	 * @generated
	 * @ordered
	 */
	protected TCGVariable variable;

	/**
	 * The default value of the '{@link #isIsPre() <em>Is Pre</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsPre()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_PRE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsPre() <em>Is Pre</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsPre()
	 * @generated
	 * @ordered
	 */
	protected boolean isPre = IS_PRE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TCGOCLVariableCallExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ActivityTestCaseGraphPackage.Literals.TCGOCL_VARIABLE_CALL_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TCGVariable getVariable() {
		if (variable != null && variable.eIsProxy()) {
			InternalEObject oldVariable = (InternalEObject)variable;
			variable = (TCGVariable)eResolveProxy(oldVariable);
			if (variable != oldVariable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ActivityTestCaseGraphPackage.TCGOCL_VARIABLE_CALL_EXP__VARIABLE, oldVariable, variable));
			}
		}
		return variable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TCGVariable basicGetVariable() {
		return variable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVariable(TCGVariable newVariable, NotificationChain msgs) {
		TCGVariable oldVariable = variable;
		variable = newVariable;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ActivityTestCaseGraphPackage.TCGOCL_VARIABLE_CALL_EXP__VARIABLE, oldVariable, newVariable);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVariable(TCGVariable newVariable) {
		if (newVariable != variable) {
			NotificationChain msgs = null;
			if (variable != null)
				msgs = ((InternalEObject)variable).eInverseRemove(this, ActivityTestCaseGraphPackage.TCG_VARIABLE__REFERENCED_BY, TCGVariable.class, msgs);
			if (newVariable != null)
				msgs = ((InternalEObject)newVariable).eInverseAdd(this, ActivityTestCaseGraphPackage.TCG_VARIABLE__REFERENCED_BY, TCGVariable.class, msgs);
			msgs = basicSetVariable(newVariable, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActivityTestCaseGraphPackage.TCGOCL_VARIABLE_CALL_EXP__VARIABLE, newVariable, newVariable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsPre() {
		return isPre;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsPre(boolean newIsPre) {
		boolean oldIsPre = isPre;
		isPre = newIsPre;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActivityTestCaseGraphPackage.TCGOCL_VARIABLE_CALL_EXP__IS_PRE, oldIsPre, isPre));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ActivityTestCaseGraphPackage.TCGOCL_VARIABLE_CALL_EXP__VARIABLE:
				if (variable != null)
					msgs = ((InternalEObject)variable).eInverseRemove(this, ActivityTestCaseGraphPackage.TCG_VARIABLE__REFERENCED_BY, TCGVariable.class, msgs);
				return basicSetVariable((TCGVariable)otherEnd, msgs);
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
			case ActivityTestCaseGraphPackage.TCGOCL_VARIABLE_CALL_EXP__VARIABLE:
				return basicSetVariable(null, msgs);
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
			case ActivityTestCaseGraphPackage.TCGOCL_VARIABLE_CALL_EXP__VARIABLE:
				if (resolve) return getVariable();
				return basicGetVariable();
			case ActivityTestCaseGraphPackage.TCGOCL_VARIABLE_CALL_EXP__IS_PRE:
				return isIsPre();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ActivityTestCaseGraphPackage.TCGOCL_VARIABLE_CALL_EXP__VARIABLE:
				setVariable((TCGVariable)newValue);
				return;
			case ActivityTestCaseGraphPackage.TCGOCL_VARIABLE_CALL_EXP__IS_PRE:
				setIsPre((Boolean)newValue);
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
			case ActivityTestCaseGraphPackage.TCGOCL_VARIABLE_CALL_EXP__VARIABLE:
				setVariable((TCGVariable)null);
				return;
			case ActivityTestCaseGraphPackage.TCGOCL_VARIABLE_CALL_EXP__IS_PRE:
				setIsPre(IS_PRE_EDEFAULT);
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
			case ActivityTestCaseGraphPackage.TCGOCL_VARIABLE_CALL_EXP__VARIABLE:
				return variable != null;
			case ActivityTestCaseGraphPackage.TCGOCL_VARIABLE_CALL_EXP__IS_PRE:
				return isPre != IS_PRE_EDEFAULT;
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
		result.append(" (isPre: ");
		result.append(isPre);
		result.append(')');
		return result.toString();
	}

} //TCGOCLVariableCallExpImpl
