/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.sf.parteg.base.testcasegraph.generated.impl;

import java.util.Collection;

import net.sf.parteg.base.testcasegraph.generated.GeneratedPackage;
import net.sf.parteg.base.testcasegraph.generated.TCGConjunction;
import net.sf.parteg.base.testcasegraph.generated.TCGOCLExpression;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TCG Conjunction</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.sf.parteg.base.testcasegraph.generated.impl.TCGConjunctionImpl#getExpressions <em>Expressions</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasegraph.generated.impl.TCGConjunctionImpl#isCanChangeValueIfOneExpressionChanges <em>Can Change Value If One Expression Changes</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasegraph.generated.impl.TCGConjunctionImpl#isPositiveSubExpressionOfOriginal <em>Positive Sub Expression Of Original</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TCGConjunctionImpl extends EObjectImpl implements TCGConjunction {
	/**
	 * The cached value of the '{@link #getExpressions() <em>Expressions</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpressions()
	 * @generated
	 * @ordered
	 */
	protected EList<TCGOCLExpression> expressions;

	/**
	 * The default value of the '{@link #isCanChangeValueIfOneExpressionChanges() <em>Can Change Value If One Expression Changes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCanChangeValueIfOneExpressionChanges()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CAN_CHANGE_VALUE_IF_ONE_EXPRESSION_CHANGES_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isCanChangeValueIfOneExpressionChanges() <em>Can Change Value If One Expression Changes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCanChangeValueIfOneExpressionChanges()
	 * @generated
	 * @ordered
	 */
	protected boolean canChangeValueIfOneExpressionChanges = CAN_CHANGE_VALUE_IF_ONE_EXPRESSION_CHANGES_EDEFAULT;

	/**
	 * The default value of the '{@link #isPositiveSubExpressionOfOriginal() <em>Positive Sub Expression Of Original</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPositiveSubExpressionOfOriginal()
	 * @generated
	 * @ordered
	 */
	protected static final boolean POSITIVE_SUB_EXPRESSION_OF_ORIGINAL_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isPositiveSubExpressionOfOriginal() <em>Positive Sub Expression Of Original</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPositiveSubExpressionOfOriginal()
	 * @generated
	 * @ordered
	 */
	protected boolean positiveSubExpressionOfOriginal = POSITIVE_SUB_EXPRESSION_OF_ORIGINAL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TCGConjunctionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeneratedPackage.Literals.TCG_CONJUNCTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TCGOCLExpression> getExpressions() {
		if (expressions == null) {
			expressions = new EObjectResolvingEList<TCGOCLExpression>(TCGOCLExpression.class, this, GeneratedPackage.TCG_CONJUNCTION__EXPRESSIONS);
		}
		return expressions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isCanChangeValueIfOneExpressionChanges() {
		return canChangeValueIfOneExpressionChanges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCanChangeValueIfOneExpressionChanges(boolean newCanChangeValueIfOneExpressionChanges) {
		boolean oldCanChangeValueIfOneExpressionChanges = canChangeValueIfOneExpressionChanges;
		canChangeValueIfOneExpressionChanges = newCanChangeValueIfOneExpressionChanges;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedPackage.TCG_CONJUNCTION__CAN_CHANGE_VALUE_IF_ONE_EXPRESSION_CHANGES, oldCanChangeValueIfOneExpressionChanges, canChangeValueIfOneExpressionChanges));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isPositiveSubExpressionOfOriginal() {
		return positiveSubExpressionOfOriginal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPositiveSubExpressionOfOriginal(boolean newPositiveSubExpressionOfOriginal) {
		boolean oldPositiveSubExpressionOfOriginal = positiveSubExpressionOfOriginal;
		positiveSubExpressionOfOriginal = newPositiveSubExpressionOfOriginal;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedPackage.TCG_CONJUNCTION__POSITIVE_SUB_EXPRESSION_OF_ORIGINAL, oldPositiveSubExpressionOfOriginal, positiveSubExpressionOfOriginal));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GeneratedPackage.TCG_CONJUNCTION__EXPRESSIONS:
				return getExpressions();
			case GeneratedPackage.TCG_CONJUNCTION__CAN_CHANGE_VALUE_IF_ONE_EXPRESSION_CHANGES:
				return isCanChangeValueIfOneExpressionChanges() ? Boolean.TRUE : Boolean.FALSE;
			case GeneratedPackage.TCG_CONJUNCTION__POSITIVE_SUB_EXPRESSION_OF_ORIGINAL:
				return isPositiveSubExpressionOfOriginal() ? Boolean.TRUE : Boolean.FALSE;
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
			case GeneratedPackage.TCG_CONJUNCTION__EXPRESSIONS:
				getExpressions().clear();
				getExpressions().addAll((Collection<? extends TCGOCLExpression>)newValue);
				return;
			case GeneratedPackage.TCG_CONJUNCTION__CAN_CHANGE_VALUE_IF_ONE_EXPRESSION_CHANGES:
				setCanChangeValueIfOneExpressionChanges(((Boolean)newValue).booleanValue());
				return;
			case GeneratedPackage.TCG_CONJUNCTION__POSITIVE_SUB_EXPRESSION_OF_ORIGINAL:
				setPositiveSubExpressionOfOriginal(((Boolean)newValue).booleanValue());
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
			case GeneratedPackage.TCG_CONJUNCTION__EXPRESSIONS:
				getExpressions().clear();
				return;
			case GeneratedPackage.TCG_CONJUNCTION__CAN_CHANGE_VALUE_IF_ONE_EXPRESSION_CHANGES:
				setCanChangeValueIfOneExpressionChanges(CAN_CHANGE_VALUE_IF_ONE_EXPRESSION_CHANGES_EDEFAULT);
				return;
			case GeneratedPackage.TCG_CONJUNCTION__POSITIVE_SUB_EXPRESSION_OF_ORIGINAL:
				setPositiveSubExpressionOfOriginal(POSITIVE_SUB_EXPRESSION_OF_ORIGINAL_EDEFAULT);
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
			case GeneratedPackage.TCG_CONJUNCTION__EXPRESSIONS:
				return expressions != null && !expressions.isEmpty();
			case GeneratedPackage.TCG_CONJUNCTION__CAN_CHANGE_VALUE_IF_ONE_EXPRESSION_CHANGES:
				return canChangeValueIfOneExpressionChanges != CAN_CHANGE_VALUE_IF_ONE_EXPRESSION_CHANGES_EDEFAULT;
			case GeneratedPackage.TCG_CONJUNCTION__POSITIVE_SUB_EXPRESSION_OF_ORIGINAL:
				return positiveSubExpressionOfOriginal != POSITIVE_SUB_EXPRESSION_OF_ORIGINAL_EDEFAULT;
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
		result.append(" (canChangeValueIfOneExpressionChanges: ");
		result.append(canChangeValueIfOneExpressionChanges);
		result.append(", positiveSubExpressionOfOriginal: ");
		result.append(positiveSubExpressionOfOriginal);
		result.append(')');
		return result.toString();
	}

} //TCGConjunctionImpl
