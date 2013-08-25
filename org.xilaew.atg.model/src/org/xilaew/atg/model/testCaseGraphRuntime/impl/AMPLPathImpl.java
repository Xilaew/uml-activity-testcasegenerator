/**
 */
package org.xilaew.atg.model.testCaseGraphRuntime.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGEdge;

import org.xilaew.atg.model.testCaseGraphRuntime.AMPLPath;
import org.xilaew.atg.model.testCaseGraphRuntime.TestCaseGraphRuntimePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>AMPL Path</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.xilaew.atg.model.testCaseGraphRuntime.impl.AMPLPathImpl#getEdges <em>Edges</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AMPLPathImpl extends MinimalEObjectImpl.Container implements AMPLPath {
	/**
	 * The cached value of the '{@link #getEdges() <em>Edges</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEdges()
	 * @generated
	 * @ordered
	 */
	protected AbstractTCGEdge edges;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AMPLPathImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TestCaseGraphRuntimePackage.Literals.AMPL_PATH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractTCGEdge getEdges() {
		if (edges != null && edges.eIsProxy()) {
			InternalEObject oldEdges = (InternalEObject)edges;
			edges = (AbstractTCGEdge)eResolveProxy(oldEdges);
			if (edges != oldEdges) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TestCaseGraphRuntimePackage.AMPL_PATH__EDGES, oldEdges, edges));
			}
		}
		return edges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractTCGEdge basicGetEdges() {
		return edges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEdges(AbstractTCGEdge newEdges) {
		AbstractTCGEdge oldEdges = edges;
		edges = newEdges;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TestCaseGraphRuntimePackage.AMPL_PATH__EDGES, oldEdges, edges));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TestCaseGraphRuntimePackage.AMPL_PATH__EDGES:
				if (resolve) return getEdges();
				return basicGetEdges();
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
			case TestCaseGraphRuntimePackage.AMPL_PATH__EDGES:
				setEdges((AbstractTCGEdge)newValue);
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
			case TestCaseGraphRuntimePackage.AMPL_PATH__EDGES:
				setEdges((AbstractTCGEdge)null);
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
			case TestCaseGraphRuntimePackage.AMPL_PATH__EDGES:
				return edges != null;
		}
		return super.eIsSet(featureID);
	}

} //AMPLPathImpl
