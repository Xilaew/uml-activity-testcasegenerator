/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.sf.parteg.base.testsuiteexport.impl;

import net.sf.parteg.base.testsuiteexport.Check;
import net.sf.parteg.base.testsuiteexport.Exp;
import net.sf.parteg.base.testsuiteexport.TestsuiteexportPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Check</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.sf.parteg.base.testsuiteexport.impl.CheckImpl#getSimpleExp <em>Simple Exp</em>}</li>
 *   <li>{@link net.sf.parteg.base.testsuiteexport.impl.CheckImpl#getComplexExp <em>Complex Exp</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CheckImpl extends ActionImpl implements Check {
	/**
	 * The default value of the '{@link #getSimpleExp() <em>Simple Exp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSimpleExp()
	 * @generated
	 * @ordered
	 */
	protected static final String SIMPLE_EXP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSimpleExp() <em>Simple Exp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSimpleExp()
	 * @generated
	 * @ordered
	 */
	protected String simpleExp = SIMPLE_EXP_EDEFAULT;

	/**
	 * The cached value of the '{@link #getComplexExp() <em>Complex Exp</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComplexExp()
	 * @generated
	 * @ordered
	 */
	protected Exp complexExp;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CheckImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TestsuiteexportPackage.Literals.CHECK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSimpleExp() {
		return simpleExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSimpleExp(String newSimpleExp) {
		String oldSimpleExp = simpleExp;
		simpleExp = newSimpleExp;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TestsuiteexportPackage.CHECK__SIMPLE_EXP, oldSimpleExp, simpleExp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Exp getComplexExp() {
		return complexExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetComplexExp(Exp newComplexExp, NotificationChain msgs) {
		Exp oldComplexExp = complexExp;
		complexExp = newComplexExp;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TestsuiteexportPackage.CHECK__COMPLEX_EXP, oldComplexExp, newComplexExp);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComplexExp(Exp newComplexExp) {
		if (newComplexExp != complexExp) {
			NotificationChain msgs = null;
			if (complexExp != null)
				msgs = ((InternalEObject)complexExp).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TestsuiteexportPackage.CHECK__COMPLEX_EXP, null, msgs);
			if (newComplexExp != null)
				msgs = ((InternalEObject)newComplexExp).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TestsuiteexportPackage.CHECK__COMPLEX_EXP, null, msgs);
			msgs = basicSetComplexExp(newComplexExp, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TestsuiteexportPackage.CHECK__COMPLEX_EXP, newComplexExp, newComplexExp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TestsuiteexportPackage.CHECK__COMPLEX_EXP:
				return basicSetComplexExp(null, msgs);
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
			case TestsuiteexportPackage.CHECK__SIMPLE_EXP:
				return getSimpleExp();
			case TestsuiteexportPackage.CHECK__COMPLEX_EXP:
				return getComplexExp();
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
			case TestsuiteexportPackage.CHECK__SIMPLE_EXP:
				setSimpleExp((String)newValue);
				return;
			case TestsuiteexportPackage.CHECK__COMPLEX_EXP:
				setComplexExp((Exp)newValue);
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
			case TestsuiteexportPackage.CHECK__SIMPLE_EXP:
				setSimpleExp(SIMPLE_EXP_EDEFAULT);
				return;
			case TestsuiteexportPackage.CHECK__COMPLEX_EXP:
				setComplexExp((Exp)null);
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
			case TestsuiteexportPackage.CHECK__SIMPLE_EXP:
				return SIMPLE_EXP_EDEFAULT == null ? simpleExp != null : !SIMPLE_EXP_EDEFAULT.equals(simpleExp);
			case TestsuiteexportPackage.CHECK__COMPLEX_EXP:
				return complexExp != null;
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
		result.append(" (simpleExp: ");
		result.append(simpleExp);
		result.append(')');
		return result.toString();
	}

} //CheckImpl
