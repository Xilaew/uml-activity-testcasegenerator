/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.sf.parteg.base.testcasegraph.generated.impl;

import java.util.Collection;

import net.sf.parteg.base.testcasegraph.generated.GeneratedPackage;
import net.sf.parteg.base.testcasegraph.generated.TCGNode;
import net.sf.parteg.base.testcasegraph.generated.TCGTransition;
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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Test Case Region</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.sf.parteg.base.testcasegraph.generated.impl.TestCaseRegionImpl#getNodes <em>Nodes</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasegraph.generated.impl.TestCaseRegionImpl#getTransitions <em>Transitions</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasegraph.generated.impl.TestCaseRegionImpl#getContainer <em>Container</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TestCaseRegionImpl extends EObjectImpl implements TestCaseRegion {
	/**
	 * The cached value of the '{@link #getNodes() <em>Nodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<TCGNode> nodes;

	/**
	 * The cached value of the '{@link #getTransitions() <em>Transitions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransitions()
	 * @generated
	 * @ordered
	 */
	protected EList<TCGTransition> transitions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TestCaseRegionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeneratedPackage.Literals.TEST_CASE_REGION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TCGNode> getNodes() {
		if (nodes == null) {
			nodes = new EObjectContainmentEList<TCGNode>(TCGNode.class, this, GeneratedPackage.TEST_CASE_REGION__NODES);
		}
		return nodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TCGTransition> getTransitions() {
		if (transitions == null) {
			transitions = new EObjectContainmentWithInverseEList<TCGTransition>(TCGTransition.class, this, GeneratedPackage.TEST_CASE_REGION__TRANSITIONS, GeneratedPackage.TCG_TRANSITION__CONTAINER);
		}
		return transitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestCaseGraph getContainer() {
		if (eContainerFeatureID != GeneratedPackage.TEST_CASE_REGION__CONTAINER) return null;
		return (TestCaseGraph)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContainer(TestCaseGraph newContainer, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newContainer, GeneratedPackage.TEST_CASE_REGION__CONTAINER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainer(TestCaseGraph newContainer) {
		if (newContainer != eInternalContainer() || (eContainerFeatureID != GeneratedPackage.TEST_CASE_REGION__CONTAINER && newContainer != null)) {
			if (EcoreUtil.isAncestor(this, newContainer))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newContainer != null)
				msgs = ((InternalEObject)newContainer).eInverseAdd(this, GeneratedPackage.TEST_CASE_GRAPH__REGIONS, TestCaseGraph.class, msgs);
			msgs = basicSetContainer(newContainer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedPackage.TEST_CASE_REGION__CONTAINER, newContainer, newContainer));
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
			case GeneratedPackage.TEST_CASE_REGION__TRANSITIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getTransitions()).basicAdd(otherEnd, msgs);
			case GeneratedPackage.TEST_CASE_REGION__CONTAINER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetContainer((TestCaseGraph)otherEnd, msgs);
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
			case GeneratedPackage.TEST_CASE_REGION__NODES:
				return ((InternalEList<?>)getNodes()).basicRemove(otherEnd, msgs);
			case GeneratedPackage.TEST_CASE_REGION__TRANSITIONS:
				return ((InternalEList<?>)getTransitions()).basicRemove(otherEnd, msgs);
			case GeneratedPackage.TEST_CASE_REGION__CONTAINER:
				return basicSetContainer(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID) {
			case GeneratedPackage.TEST_CASE_REGION__CONTAINER:
				return eInternalContainer().eInverseRemove(this, GeneratedPackage.TEST_CASE_GRAPH__REGIONS, TestCaseGraph.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GeneratedPackage.TEST_CASE_REGION__NODES:
				return getNodes();
			case GeneratedPackage.TEST_CASE_REGION__TRANSITIONS:
				return getTransitions();
			case GeneratedPackage.TEST_CASE_REGION__CONTAINER:
				return getContainer();
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
			case GeneratedPackage.TEST_CASE_REGION__NODES:
				getNodes().clear();
				getNodes().addAll((Collection<? extends TCGNode>)newValue);
				return;
			case GeneratedPackage.TEST_CASE_REGION__TRANSITIONS:
				getTransitions().clear();
				getTransitions().addAll((Collection<? extends TCGTransition>)newValue);
				return;
			case GeneratedPackage.TEST_CASE_REGION__CONTAINER:
				setContainer((TestCaseGraph)newValue);
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
			case GeneratedPackage.TEST_CASE_REGION__NODES:
				getNodes().clear();
				return;
			case GeneratedPackage.TEST_CASE_REGION__TRANSITIONS:
				getTransitions().clear();
				return;
			case GeneratedPackage.TEST_CASE_REGION__CONTAINER:
				setContainer((TestCaseGraph)null);
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
			case GeneratedPackage.TEST_CASE_REGION__NODES:
				return nodes != null && !nodes.isEmpty();
			case GeneratedPackage.TEST_CASE_REGION__TRANSITIONS:
				return transitions != null && !transitions.isEmpty();
			case GeneratedPackage.TEST_CASE_REGION__CONTAINER:
				return getContainer() != null;
		}
		return super.eIsSet(featureID);
	}

} //TestCaseRegionImpl
