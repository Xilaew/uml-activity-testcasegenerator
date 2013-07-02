/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.sf.parteg.base.testcasegraph.generated.impl;

import net.sf.parteg.base.testcasegraph.generated.GeneratedPackage;
import net.sf.parteg.base.testcasegraph.generated.TCGOCLAtom;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TCGOCL Atom</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.sf.parteg.base.testcasegraph.generated.impl.TCGOCLAtomImpl#getElement <em>Element</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasegraph.generated.impl.TCGOCLAtomImpl#getTcgParameter <em>Tcg Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TCGOCLAtomImpl extends TCGOCLExpressionImpl implements TCGOCLAtom {
	/**
	 * The cached value of the '{@link #getElement() <em>Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElement()
	 * @generated
	 * @ordered
	 */
	protected EObject element;

	/**
	 * The cached value of the '{@link #getTcgParameter() <em>Tcg Parameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTcgParameter()
	 * @generated
	 * @ordered
	 */
	protected EObject tcgParameter;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TCGOCLAtomImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeneratedPackage.Literals.TCGOCL_ATOM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getElement() {
		if (element != null && element.eIsProxy()) {
			InternalEObject oldElement = (InternalEObject)element;
			element = eResolveProxy(oldElement);
			if (element != oldElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GeneratedPackage.TCGOCL_ATOM__ELEMENT, oldElement, element));
			}
		}
		return element;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetElement() {
		return element;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElement(EObject newElement) {
		EObject oldElement = element;
		element = newElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedPackage.TCGOCL_ATOM__ELEMENT, oldElement, element));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getTcgParameter() {
		if (tcgParameter != null && tcgParameter.eIsProxy()) {
			InternalEObject oldTcgParameter = (InternalEObject)tcgParameter;
			tcgParameter = eResolveProxy(oldTcgParameter);
			if (tcgParameter != oldTcgParameter) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GeneratedPackage.TCGOCL_ATOM__TCG_PARAMETER, oldTcgParameter, tcgParameter));
			}
		}
		return tcgParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetTcgParameter() {
		return tcgParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTcgParameter(EObject newTcgParameter) {
		EObject oldTcgParameter = tcgParameter;
		tcgParameter = newTcgParameter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedPackage.TCGOCL_ATOM__TCG_PARAMETER, oldTcgParameter, tcgParameter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GeneratedPackage.TCGOCL_ATOM__ELEMENT:
				if (resolve) return getElement();
				return basicGetElement();
			case GeneratedPackage.TCGOCL_ATOM__TCG_PARAMETER:
				if (resolve) return getTcgParameter();
				return basicGetTcgParameter();
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
			case GeneratedPackage.TCGOCL_ATOM__ELEMENT:
				setElement((EObject)newValue);
				return;
			case GeneratedPackage.TCGOCL_ATOM__TCG_PARAMETER:
				setTcgParameter((EObject)newValue);
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
			case GeneratedPackage.TCGOCL_ATOM__ELEMENT:
				setElement((EObject)null);
				return;
			case GeneratedPackage.TCGOCL_ATOM__TCG_PARAMETER:
				setTcgParameter((EObject)null);
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
			case GeneratedPackage.TCGOCL_ATOM__ELEMENT:
				return element != null;
			case GeneratedPackage.TCGOCL_ATOM__TCG_PARAMETER:
				return tcgParameter != null;
		}
		return super.eIsSet(featureID);
	}

} //TCGOCLAtomImpl
