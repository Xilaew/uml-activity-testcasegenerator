/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.sf.parteg.base.testcasegraph.generated.impl;

import java.util.Collection;

import net.sf.parteg.base.testcasegraph.generated.GeneratedPackage;
import net.sf.parteg.base.testcasegraph.generated.TCGIntermediateNode;
import net.sf.parteg.base.testcasegraph.generated.TCGRealNode;
import net.sf.parteg.base.testcasegraph.generated.TestCaseGraph;
import net.sf.parteg.base.testcasegraph.generated.TestCaseRegion;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Test Case Graph</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.sf.parteg.base.testcasegraph.generated.impl.TestCaseGraphImpl#getRegions <em>Regions</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasegraph.generated.impl.TestCaseGraphImpl#getCompositeSuperState <em>Composite Super State</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasegraph.generated.impl.TestCaseGraphImpl#getContainedConnectionPoints <em>Contained Connection Points</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasegraph.generated.impl.TestCaseGraphImpl#getSubmachineStates <em>Submachine States</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TestCaseGraphImpl extends EObjectImpl implements TestCaseGraph {
	/**
	 * The cached value of the '{@link #getRegions() <em>Regions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRegions()
	 * @generated
	 * @ordered
	 */
	protected EList<TestCaseRegion> regions;

	/**
	 * The cached value of the '{@link #getCompositeSuperState() <em>Composite Super State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompositeSuperState()
	 * @generated
	 * @ordered
	 */
	protected TCGRealNode compositeSuperState;

	/**
	 * The cached value of the '{@link #getContainedConnectionPoints() <em>Contained Connection Points</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContainedConnectionPoints()
	 * @generated
	 * @ordered
	 */
	protected EList<TCGIntermediateNode> containedConnectionPoints;

	/**
	 * The cached value of the '{@link #getSubmachineStates() <em>Submachine States</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubmachineStates()
	 * @generated
	 * @ordered
	 */
	protected EList<TCGRealNode> submachineStates;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TestCaseGraphImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeneratedPackage.Literals.TEST_CASE_GRAPH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TestCaseRegion> getRegions() {
		if (regions == null) {
			regions = new EObjectContainmentWithInverseEList<TestCaseRegion>(TestCaseRegion.class, this, GeneratedPackage.TEST_CASE_GRAPH__REGIONS, GeneratedPackage.TEST_CASE_REGION__CONTAINER);
		}
		return regions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TCGRealNode getCompositeSuperState() {
		if (compositeSuperState != null && compositeSuperState.eIsProxy()) {
			InternalEObject oldCompositeSuperState = (InternalEObject)compositeSuperState;
			compositeSuperState = (TCGRealNode)eResolveProxy(oldCompositeSuperState);
			if (compositeSuperState != oldCompositeSuperState) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GeneratedPackage.TEST_CASE_GRAPH__COMPOSITE_SUPER_STATE, oldCompositeSuperState, compositeSuperState));
			}
		}
		return compositeSuperState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TCGRealNode basicGetCompositeSuperState() {
		return compositeSuperState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompositeSuperState(TCGRealNode newCompositeSuperState) {
		TCGRealNode oldCompositeSuperState = compositeSuperState;
		compositeSuperState = newCompositeSuperState;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedPackage.TEST_CASE_GRAPH__COMPOSITE_SUPER_STATE, oldCompositeSuperState, compositeSuperState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TCGIntermediateNode> getContainedConnectionPoints() {
		if (containedConnectionPoints == null) {
			containedConnectionPoints = new EObjectContainmentEList<TCGIntermediateNode>(TCGIntermediateNode.class, this, GeneratedPackage.TEST_CASE_GRAPH__CONTAINED_CONNECTION_POINTS);
		}
		return containedConnectionPoints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TCGRealNode> getSubmachineStates() {
		if (submachineStates == null) {
			submachineStates = new EObjectResolvingEList<TCGRealNode>(TCGRealNode.class, this, GeneratedPackage.TEST_CASE_GRAPH__SUBMACHINE_STATES);
		}
		return submachineStates;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GeneratedPackage.TEST_CASE_GRAPH__REGIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getRegions()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GeneratedPackage.TEST_CASE_GRAPH__REGIONS:
				return ((InternalEList<?>)getRegions()).basicRemove(otherEnd, msgs);
			case GeneratedPackage.TEST_CASE_GRAPH__CONTAINED_CONNECTION_POINTS:
				return ((InternalEList<?>)getContainedConnectionPoints()).basicRemove(otherEnd, msgs);
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
			case GeneratedPackage.TEST_CASE_GRAPH__REGIONS:
				return getRegions();
			case GeneratedPackage.TEST_CASE_GRAPH__COMPOSITE_SUPER_STATE:
				if (resolve) return getCompositeSuperState();
				return basicGetCompositeSuperState();
			case GeneratedPackage.TEST_CASE_GRAPH__CONTAINED_CONNECTION_POINTS:
				return getContainedConnectionPoints();
			case GeneratedPackage.TEST_CASE_GRAPH__SUBMACHINE_STATES:
				return getSubmachineStates();
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
			case GeneratedPackage.TEST_CASE_GRAPH__REGIONS:
				getRegions().clear();
				getRegions().addAll((Collection<? extends TestCaseRegion>)newValue);
				return;
			case GeneratedPackage.TEST_CASE_GRAPH__COMPOSITE_SUPER_STATE:
				setCompositeSuperState((TCGRealNode)newValue);
				return;
			case GeneratedPackage.TEST_CASE_GRAPH__CONTAINED_CONNECTION_POINTS:
				getContainedConnectionPoints().clear();
				getContainedConnectionPoints().addAll((Collection<? extends TCGIntermediateNode>)newValue);
				return;
			case GeneratedPackage.TEST_CASE_GRAPH__SUBMACHINE_STATES:
				getSubmachineStates().clear();
				getSubmachineStates().addAll((Collection<? extends TCGRealNode>)newValue);
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
			case GeneratedPackage.TEST_CASE_GRAPH__REGIONS:
				getRegions().clear();
				return;
			case GeneratedPackage.TEST_CASE_GRAPH__COMPOSITE_SUPER_STATE:
				setCompositeSuperState((TCGRealNode)null);
				return;
			case GeneratedPackage.TEST_CASE_GRAPH__CONTAINED_CONNECTION_POINTS:
				getContainedConnectionPoints().clear();
				return;
			case GeneratedPackage.TEST_CASE_GRAPH__SUBMACHINE_STATES:
				getSubmachineStates().clear();
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
			case GeneratedPackage.TEST_CASE_GRAPH__REGIONS:
				return regions != null && !regions.isEmpty();
			case GeneratedPackage.TEST_CASE_GRAPH__COMPOSITE_SUPER_STATE:
				return compositeSuperState != null;
			case GeneratedPackage.TEST_CASE_GRAPH__CONTAINED_CONNECTION_POINTS:
				return containedConnectionPoints != null && !containedConnectionPoints.isEmpty();
			case GeneratedPackage.TEST_CASE_GRAPH__SUBMACHINE_STATES:
				return submachineStates != null && !submachineStates.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TestCaseGraphImpl
