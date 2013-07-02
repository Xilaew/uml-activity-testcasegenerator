/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.sf.parteg.base.testcasegraph.generated.impl;

import net.sf.parteg.base.testcasegraph.generated.GeneratedPackage;
import net.sf.parteg.base.testcasegraph.generated.TCGEquivalenceClass;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TCG Equivalence Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.sf.parteg.base.testcasegraph.generated.impl.TCGEquivalenceClassImpl#getMinBorder <em>Min Border</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasegraph.generated.impl.TCGEquivalenceClassImpl#getMinIncluded <em>Min Included</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasegraph.generated.impl.TCGEquivalenceClassImpl#getMaxBorder <em>Max Border</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasegraph.generated.impl.TCGEquivalenceClassImpl#getMaxIncluded <em>Max Included</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TCGEquivalenceClassImpl extends EObjectImpl implements TCGEquivalenceClass {
	/**
	 * The default value of the '{@link #getMinBorder() <em>Min Border</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinBorder()
	 * @generated
	 * @ordered
	 */
	protected static final Double MIN_BORDER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMinBorder() <em>Min Border</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinBorder()
	 * @generated
	 * @ordered
	 */
	protected Double minBorder = MIN_BORDER_EDEFAULT;

	/**
	 * The default value of the '{@link #getMinIncluded() <em>Min Included</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinIncluded()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean MIN_INCLUDED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMinIncluded() <em>Min Included</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinIncluded()
	 * @generated
	 * @ordered
	 */
	protected Boolean minIncluded = MIN_INCLUDED_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxBorder() <em>Max Border</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxBorder()
	 * @generated
	 * @ordered
	 */
	protected static final Double MAX_BORDER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMaxBorder() <em>Max Border</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxBorder()
	 * @generated
	 * @ordered
	 */
	protected Double maxBorder = MAX_BORDER_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxIncluded() <em>Max Included</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxIncluded()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean MAX_INCLUDED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMaxIncluded() <em>Max Included</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxIncluded()
	 * @generated
	 * @ordered
	 */
	protected Boolean maxIncluded = MAX_INCLUDED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TCGEquivalenceClassImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeneratedPackage.Literals.TCG_EQUIVALENCE_CLASS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Double getMinBorder() {
		return minBorder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinBorder(Double newMinBorder) {
		Double oldMinBorder = minBorder;
		minBorder = newMinBorder;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedPackage.TCG_EQUIVALENCE_CLASS__MIN_BORDER, oldMinBorder, minBorder));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getMinIncluded() {
		return minIncluded;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinIncluded(Boolean newMinIncluded) {
		Boolean oldMinIncluded = minIncluded;
		minIncluded = newMinIncluded;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedPackage.TCG_EQUIVALENCE_CLASS__MIN_INCLUDED, oldMinIncluded, minIncluded));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Double getMaxBorder() {
		return maxBorder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxBorder(Double newMaxBorder) {
		Double oldMaxBorder = maxBorder;
		maxBorder = newMaxBorder;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedPackage.TCG_EQUIVALENCE_CLASS__MAX_BORDER, oldMaxBorder, maxBorder));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getMaxIncluded() {
		return maxIncluded;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxIncluded(Boolean newMaxIncluded) {
		Boolean oldMaxIncluded = maxIncluded;
		maxIncluded = newMaxIncluded;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedPackage.TCG_EQUIVALENCE_CLASS__MAX_INCLUDED, oldMaxIncluded, maxIncluded));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GeneratedPackage.TCG_EQUIVALENCE_CLASS__MIN_BORDER:
				return getMinBorder();
			case GeneratedPackage.TCG_EQUIVALENCE_CLASS__MIN_INCLUDED:
				return getMinIncluded();
			case GeneratedPackage.TCG_EQUIVALENCE_CLASS__MAX_BORDER:
				return getMaxBorder();
			case GeneratedPackage.TCG_EQUIVALENCE_CLASS__MAX_INCLUDED:
				return getMaxIncluded();
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
			case GeneratedPackage.TCG_EQUIVALENCE_CLASS__MIN_BORDER:
				setMinBorder((Double)newValue);
				return;
			case GeneratedPackage.TCG_EQUIVALENCE_CLASS__MIN_INCLUDED:
				setMinIncluded((Boolean)newValue);
				return;
			case GeneratedPackage.TCG_EQUIVALENCE_CLASS__MAX_BORDER:
				setMaxBorder((Double)newValue);
				return;
			case GeneratedPackage.TCG_EQUIVALENCE_CLASS__MAX_INCLUDED:
				setMaxIncluded((Boolean)newValue);
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
			case GeneratedPackage.TCG_EQUIVALENCE_CLASS__MIN_BORDER:
				setMinBorder(MIN_BORDER_EDEFAULT);
				return;
			case GeneratedPackage.TCG_EQUIVALENCE_CLASS__MIN_INCLUDED:
				setMinIncluded(MIN_INCLUDED_EDEFAULT);
				return;
			case GeneratedPackage.TCG_EQUIVALENCE_CLASS__MAX_BORDER:
				setMaxBorder(MAX_BORDER_EDEFAULT);
				return;
			case GeneratedPackage.TCG_EQUIVALENCE_CLASS__MAX_INCLUDED:
				setMaxIncluded(MAX_INCLUDED_EDEFAULT);
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
			case GeneratedPackage.TCG_EQUIVALENCE_CLASS__MIN_BORDER:
				return MIN_BORDER_EDEFAULT == null ? minBorder != null : !MIN_BORDER_EDEFAULT.equals(minBorder);
			case GeneratedPackage.TCG_EQUIVALENCE_CLASS__MIN_INCLUDED:
				return MIN_INCLUDED_EDEFAULT == null ? minIncluded != null : !MIN_INCLUDED_EDEFAULT.equals(minIncluded);
			case GeneratedPackage.TCG_EQUIVALENCE_CLASS__MAX_BORDER:
				return MAX_BORDER_EDEFAULT == null ? maxBorder != null : !MAX_BORDER_EDEFAULT.equals(maxBorder);
			case GeneratedPackage.TCG_EQUIVALENCE_CLASS__MAX_INCLUDED:
				return MAX_INCLUDED_EDEFAULT == null ? maxIncluded != null : !MAX_INCLUDED_EDEFAULT.equals(maxIncluded);
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
		result.append(" (minBorder: ");
		result.append(minBorder);
		result.append(", minIncluded: ");
		result.append(minIncluded);
		result.append(", maxBorder: ");
		result.append(maxBorder);
		result.append(", maxIncluded: ");
		result.append(maxIncluded);
		result.append(')');
		return result.toString();
	}

} //TCGEquivalenceClassImpl
