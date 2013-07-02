/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.sf.parteg.base.testcasetree.generated.impl;

import java.util.Collection;

import net.sf.parteg.base.testcasetree.generated.GeneratedPackage;
import net.sf.parteg.base.testcasetree.generated.TCGEvent;
import net.sf.parteg.base.testcasetree.generated.TCGParameter;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TCG Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.sf.parteg.base.testcasetree.generated.impl.TCGEventImpl#getName <em>Name</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasetree.generated.impl.TCGEventImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasetree.generated.impl.TCGEventImpl#getEvent <em>Event</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasetree.generated.impl.TCGEventImpl#isDefaultEvent <em>Default Event</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TCGEventImpl extends EObjectImpl implements TCGEvent {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<TCGParameter> parameters;

	/**
	 * The cached value of the '{@link #getEvent() <em>Event</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEvent()
	 * @generated
	 * @ordered
	 */
	protected EObject event;

	/**
	 * The default value of the '{@link #isDefaultEvent() <em>Default Event</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDefaultEvent()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DEFAULT_EVENT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDefaultEvent() <em>Default Event</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDefaultEvent()
	 * @generated
	 * @ordered
	 */
	protected boolean defaultEvent = DEFAULT_EVENT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TCGEventImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeneratedPackage.Literals.TCG_EVENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedPackage.TCG_EVENT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TCGParameter> getParameters() {
		if (parameters == null) {
			parameters = new EObjectResolvingEList<TCGParameter>(TCGParameter.class, this, GeneratedPackage.TCG_EVENT__PARAMETERS);
		}
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getEvent() {
		if (event != null && event.eIsProxy()) {
			InternalEObject oldEvent = (InternalEObject)event;
			event = eResolveProxy(oldEvent);
			if (event != oldEvent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GeneratedPackage.TCG_EVENT__EVENT, oldEvent, event));
			}
		}
		return event;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetEvent() {
		return event;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEvent(EObject newEvent) {
		EObject oldEvent = event;
		event = newEvent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedPackage.TCG_EVENT__EVENT, oldEvent, event));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDefaultEvent() {
		return defaultEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultEvent(boolean newDefaultEvent) {
		boolean oldDefaultEvent = defaultEvent;
		defaultEvent = newDefaultEvent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedPackage.TCG_EVENT__DEFAULT_EVENT, oldDefaultEvent, defaultEvent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GeneratedPackage.TCG_EVENT__NAME:
				return getName();
			case GeneratedPackage.TCG_EVENT__PARAMETERS:
				return getParameters();
			case GeneratedPackage.TCG_EVENT__EVENT:
				if (resolve) return getEvent();
				return basicGetEvent();
			case GeneratedPackage.TCG_EVENT__DEFAULT_EVENT:
				return isDefaultEvent() ? Boolean.TRUE : Boolean.FALSE;
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
			case GeneratedPackage.TCG_EVENT__NAME:
				setName((String)newValue);
				return;
			case GeneratedPackage.TCG_EVENT__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends TCGParameter>)newValue);
				return;
			case GeneratedPackage.TCG_EVENT__EVENT:
				setEvent((EObject)newValue);
				return;
			case GeneratedPackage.TCG_EVENT__DEFAULT_EVENT:
				setDefaultEvent(((Boolean)newValue).booleanValue());
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
			case GeneratedPackage.TCG_EVENT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case GeneratedPackage.TCG_EVENT__PARAMETERS:
				getParameters().clear();
				return;
			case GeneratedPackage.TCG_EVENT__EVENT:
				setEvent((EObject)null);
				return;
			case GeneratedPackage.TCG_EVENT__DEFAULT_EVENT:
				setDefaultEvent(DEFAULT_EVENT_EDEFAULT);
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
			case GeneratedPackage.TCG_EVENT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case GeneratedPackage.TCG_EVENT__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
			case GeneratedPackage.TCG_EVENT__EVENT:
				return event != null;
			case GeneratedPackage.TCG_EVENT__DEFAULT_EVENT:
				return defaultEvent != DEFAULT_EVENT_EDEFAULT;
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
		result.append(" (name: ");
		result.append(name);
		result.append(", defaultEvent: ");
		result.append(defaultEvent);
		result.append(')');
		return result.toString();
	}

} //TCGEventImpl
