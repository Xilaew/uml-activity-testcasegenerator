/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.sf.parteg.base.testcasetree.generated.impl;

import net.sf.parteg.base.testcasetree.generated.GeneratedPackage;
import net.sf.parteg.base.testcasetree.generated.TCGOCLExpression;
import net.sf.parteg.base.testcasetree.generated.TCGOCLIfThenElse;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TCGOCL If Then Else</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.sf.parteg.base.testcasetree.generated.impl.TCGOCLIfThenElseImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasetree.generated.impl.TCGOCLIfThenElseImpl#getThenExpression <em>Then Expression</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasetree.generated.impl.TCGOCLIfThenElseImpl#getElseExpression <em>Else Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TCGOCLIfThenElseImpl extends TCGOCLExpressionImpl implements TCGOCLIfThenElse {
	/**
	 * The cached value of the '{@link #getCondition() <em>Condition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCondition()
	 * @generated
	 * @ordered
	 */
	protected TCGOCLExpression condition;

	/**
	 * The cached value of the '{@link #getThenExpression() <em>Then Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThenExpression()
	 * @generated
	 * @ordered
	 */
	protected TCGOCLExpression thenExpression;

	/**
	 * The cached value of the '{@link #getElseExpression() <em>Else Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElseExpression()
	 * @generated
	 * @ordered
	 */
	protected TCGOCLExpression elseExpression;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TCGOCLIfThenElseImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeneratedPackage.Literals.TCGOCL_IF_THEN_ELSE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TCGOCLExpression getCondition() {
		if (condition != null && condition.eIsProxy()) {
			InternalEObject oldCondition = (InternalEObject)condition;
			condition = (TCGOCLExpression)eResolveProxy(oldCondition);
			if (condition != oldCondition) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GeneratedPackage.TCGOCL_IF_THEN_ELSE__CONDITION, oldCondition, condition));
			}
		}
		return condition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TCGOCLExpression basicGetCondition() {
		return condition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCondition(TCGOCLExpression newCondition) {
		TCGOCLExpression oldCondition = condition;
		condition = newCondition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedPackage.TCGOCL_IF_THEN_ELSE__CONDITION, oldCondition, condition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TCGOCLExpression getThenExpression() {
		if (thenExpression != null && thenExpression.eIsProxy()) {
			InternalEObject oldThenExpression = (InternalEObject)thenExpression;
			thenExpression = (TCGOCLExpression)eResolveProxy(oldThenExpression);
			if (thenExpression != oldThenExpression) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GeneratedPackage.TCGOCL_IF_THEN_ELSE__THEN_EXPRESSION, oldThenExpression, thenExpression));
			}
		}
		return thenExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TCGOCLExpression basicGetThenExpression() {
		return thenExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThenExpression(TCGOCLExpression newThenExpression) {
		TCGOCLExpression oldThenExpression = thenExpression;
		thenExpression = newThenExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedPackage.TCGOCL_IF_THEN_ELSE__THEN_EXPRESSION, oldThenExpression, thenExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TCGOCLExpression getElseExpression() {
		if (elseExpression != null && elseExpression.eIsProxy()) {
			InternalEObject oldElseExpression = (InternalEObject)elseExpression;
			elseExpression = (TCGOCLExpression)eResolveProxy(oldElseExpression);
			if (elseExpression != oldElseExpression) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GeneratedPackage.TCGOCL_IF_THEN_ELSE__ELSE_EXPRESSION, oldElseExpression, elseExpression));
			}
		}
		return elseExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TCGOCLExpression basicGetElseExpression() {
		return elseExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElseExpression(TCGOCLExpression newElseExpression) {
		TCGOCLExpression oldElseExpression = elseExpression;
		elseExpression = newElseExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedPackage.TCGOCL_IF_THEN_ELSE__ELSE_EXPRESSION, oldElseExpression, elseExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GeneratedPackage.TCGOCL_IF_THEN_ELSE__CONDITION:
				if (resolve) return getCondition();
				return basicGetCondition();
			case GeneratedPackage.TCGOCL_IF_THEN_ELSE__THEN_EXPRESSION:
				if (resolve) return getThenExpression();
				return basicGetThenExpression();
			case GeneratedPackage.TCGOCL_IF_THEN_ELSE__ELSE_EXPRESSION:
				if (resolve) return getElseExpression();
				return basicGetElseExpression();
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
			case GeneratedPackage.TCGOCL_IF_THEN_ELSE__CONDITION:
				setCondition((TCGOCLExpression)newValue);
				return;
			case GeneratedPackage.TCGOCL_IF_THEN_ELSE__THEN_EXPRESSION:
				setThenExpression((TCGOCLExpression)newValue);
				return;
			case GeneratedPackage.TCGOCL_IF_THEN_ELSE__ELSE_EXPRESSION:
				setElseExpression((TCGOCLExpression)newValue);
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
			case GeneratedPackage.TCGOCL_IF_THEN_ELSE__CONDITION:
				setCondition((TCGOCLExpression)null);
				return;
			case GeneratedPackage.TCGOCL_IF_THEN_ELSE__THEN_EXPRESSION:
				setThenExpression((TCGOCLExpression)null);
				return;
			case GeneratedPackage.TCGOCL_IF_THEN_ELSE__ELSE_EXPRESSION:
				setElseExpression((TCGOCLExpression)null);
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
			case GeneratedPackage.TCGOCL_IF_THEN_ELSE__CONDITION:
				return condition != null;
			case GeneratedPackage.TCGOCL_IF_THEN_ELSE__THEN_EXPRESSION:
				return thenExpression != null;
			case GeneratedPackage.TCGOCL_IF_THEN_ELSE__ELSE_EXPRESSION:
				return elseExpression != null;
		}
		return super.eIsSet(featureID);
	}

} //TCGOCLIfThenElseImpl
