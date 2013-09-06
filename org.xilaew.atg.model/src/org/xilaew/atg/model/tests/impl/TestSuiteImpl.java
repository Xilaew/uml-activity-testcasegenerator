/**
 */
package org.xilaew.atg.model.tests.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.xilaew.atg.model.tests.SUT;
import org.xilaew.atg.model.tests.TestCase;
import org.xilaew.atg.model.tests.TestSuite;
import org.xilaew.atg.model.tests.TestsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Test Suite</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.xilaew.atg.model.tests.impl.TestSuiteImpl#getTests <em>Tests</em>}</li>
 *   <li>{@link org.xilaew.atg.model.tests.impl.TestSuiteImpl#getSut <em>Sut</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TestSuiteImpl extends MinimalEObjectImpl.Container implements TestSuite {
	/**
	 * The cached value of the '{@link #getTests() <em>Tests</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTests()
	 * @generated
	 * @ordered
	 */
	protected EList<TestCase> tests;

	/**
	 * The cached value of the '{@link #getSut() <em>Sut</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSut()
	 * @generated
	 * @ordered
	 */
	protected EList<SUT> sut;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TestSuiteImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TestsPackage.Literals.TEST_SUITE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TestCase> getTests() {
		if (tests == null) {
			tests = new EObjectContainmentEList<TestCase>(TestCase.class, this, TestsPackage.TEST_SUITE__TESTS);
		}
		return tests;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SUT> getSut() {
		if (sut == null) {
			sut = new EObjectContainmentEList<SUT>(SUT.class, this, TestsPackage.TEST_SUITE__SUT);
		}
		return sut;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TestsPackage.TEST_SUITE__TESTS:
				return ((InternalEList<?>)getTests()).basicRemove(otherEnd, msgs);
			case TestsPackage.TEST_SUITE__SUT:
				return ((InternalEList<?>)getSut()).basicRemove(otherEnd, msgs);
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
			case TestsPackage.TEST_SUITE__TESTS:
				return getTests();
			case TestsPackage.TEST_SUITE__SUT:
				return getSut();
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
			case TestsPackage.TEST_SUITE__TESTS:
				getTests().clear();
				getTests().addAll((Collection<? extends TestCase>)newValue);
				return;
			case TestsPackage.TEST_SUITE__SUT:
				getSut().clear();
				getSut().addAll((Collection<? extends SUT>)newValue);
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
			case TestsPackage.TEST_SUITE__TESTS:
				getTests().clear();
				return;
			case TestsPackage.TEST_SUITE__SUT:
				getSut().clear();
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
			case TestsPackage.TEST_SUITE__TESTS:
				return tests != null && !tests.isEmpty();
			case TestsPackage.TEST_SUITE__SUT:
				return sut != null && !sut.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TestSuiteImpl
