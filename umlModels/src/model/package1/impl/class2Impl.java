/**
 */
package model.package1.impl;

import model.package1.Package1Package;
import model.package1.class2;
import model.package1.type2;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>class2</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link model.package1.impl.class2Impl#getAttribute2 <em>Attribute2</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class class2Impl extends class1Impl implements class2 {
	/**
	 * The cached value of the '{@link #getAttribute2() <em>Attribute2</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttribute2()
	 * @generated
	 * @ordered
	 */
	protected type2 attribute2;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected class2Impl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Package1Package.Literals.CLASS2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public type2 getAttribute2() {
		if (attribute2 != null && attribute2.eIsProxy()) {
			InternalEObject oldAttribute2 = (InternalEObject)attribute2;
			attribute2 = (type2)eResolveProxy(oldAttribute2);
			if (attribute2 != oldAttribute2) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Package1Package.CLASS2__ATTRIBUTE2, oldAttribute2, attribute2));
			}
		}
		return attribute2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public type2 basicGetAttribute2() {
		return attribute2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttribute2(type2 newAttribute2) {
		type2 oldAttribute2 = attribute2;
		attribute2 = newAttribute2;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Package1Package.CLASS2__ATTRIBUTE2, oldAttribute2, attribute2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Package1Package.CLASS2__ATTRIBUTE2:
				if (resolve) return getAttribute2();
				return basicGetAttribute2();
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
			case Package1Package.CLASS2__ATTRIBUTE2:
				setAttribute2((type2)newValue);
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
			case Package1Package.CLASS2__ATTRIBUTE2:
				setAttribute2((type2)null);
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
			case Package1Package.CLASS2__ATTRIBUTE2:
				return attribute2 != null;
		}
		return super.eIsSet(featureID);
	}

} //class2Impl
