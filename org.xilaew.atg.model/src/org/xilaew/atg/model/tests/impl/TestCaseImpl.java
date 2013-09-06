/**
 */
package org.xilaew.atg.model.tests.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.xilaew.atg.model.tests.FunctionCall;
import org.xilaew.atg.model.tests.TestCase;
import org.xilaew.atg.model.tests.TestsPackage;
import org.xilaew.atg.model.tests.Value;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Test Case</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.xilaew.atg.model.tests.impl.TestCaseImpl#getInitValues <em>Init Values</em>}</li>
 *   <li>{@link org.xilaew.atg.model.tests.impl.TestCaseImpl#getFunction <em>Function</em>}</li>
 *   <li>{@link org.xilaew.atg.model.tests.impl.TestCaseImpl#getTestForValue <em>Test For Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TestCaseImpl extends MinimalEObjectImpl.Container implements TestCase {
	/**
	 * The cached value of the '{@link #getInitValues() <em>Init Values</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitValues()
	 * @generated
	 * @ordered
	 */
	protected EList<Value> initValues;

	/**
	 * The cached value of the '{@link #getFunction() <em>Function</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFunction()
	 * @generated
	 * @ordered
	 */
	protected FunctionCall function;

	/**
	 * The cached value of the '{@link #getTestForValue() <em>Test For Value</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTestForValue()
	 * @generated
	 * @ordered
	 */
	protected EList<Value> testForValue;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TestCaseImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TestsPackage.Literals.TEST_CASE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Value> getInitValues() {
		if (initValues == null) {
			initValues = new EObjectContainmentEList<Value>(Value.class, this, TestsPackage.TEST_CASE__INIT_VALUES);
		}
		return initValues;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionCall getFunction() {
		return function;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFunction(FunctionCall newFunction, NotificationChain msgs) {
		FunctionCall oldFunction = function;
		function = newFunction;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TestsPackage.TEST_CASE__FUNCTION, oldFunction, newFunction);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFunction(FunctionCall newFunction) {
		if (newFunction != function) {
			NotificationChain msgs = null;
			if (function != null)
				msgs = ((InternalEObject)function).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TestsPackage.TEST_CASE__FUNCTION, null, msgs);
			if (newFunction != null)
				msgs = ((InternalEObject)newFunction).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TestsPackage.TEST_CASE__FUNCTION, null, msgs);
			msgs = basicSetFunction(newFunction, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TestsPackage.TEST_CASE__FUNCTION, newFunction, newFunction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Value> getTestForValue() {
		if (testForValue == null) {
			testForValue = new EObjectContainmentEList<Value>(Value.class, this, TestsPackage.TEST_CASE__TEST_FOR_VALUE);
		}
		return testForValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TestsPackage.TEST_CASE__INIT_VALUES:
				return ((InternalEList<?>)getInitValues()).basicRemove(otherEnd, msgs);
			case TestsPackage.TEST_CASE__FUNCTION:
				return basicSetFunction(null, msgs);
			case TestsPackage.TEST_CASE__TEST_FOR_VALUE:
				return ((InternalEList<?>)getTestForValue()).basicRemove(otherEnd, msgs);
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
			case TestsPackage.TEST_CASE__INIT_VALUES:
				return getInitValues();
			case TestsPackage.TEST_CASE__FUNCTION:
				return getFunction();
			case TestsPackage.TEST_CASE__TEST_FOR_VALUE:
				return getTestForValue();
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
			case TestsPackage.TEST_CASE__INIT_VALUES:
				getInitValues().clear();
				getInitValues().addAll((Collection<? extends Value>)newValue);
				return;
			case TestsPackage.TEST_CASE__FUNCTION:
				setFunction((FunctionCall)newValue);
				return;
			case TestsPackage.TEST_CASE__TEST_FOR_VALUE:
				getTestForValue().clear();
				getTestForValue().addAll((Collection<? extends Value>)newValue);
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
			case TestsPackage.TEST_CASE__INIT_VALUES:
				getInitValues().clear();
				return;
			case TestsPackage.TEST_CASE__FUNCTION:
				setFunction((FunctionCall)null);
				return;
			case TestsPackage.TEST_CASE__TEST_FOR_VALUE:
				getTestForValue().clear();
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
			case TestsPackage.TEST_CASE__INIT_VALUES:
				return initValues != null && !initValues.isEmpty();
			case TestsPackage.TEST_CASE__FUNCTION:
				return function != null;
			case TestsPackage.TEST_CASE__TEST_FOR_VALUE:
				return testForValue != null && !testForValue.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TestCaseImpl
