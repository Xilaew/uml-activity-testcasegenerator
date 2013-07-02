/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.sf.parteg.base.testcasetree.generated.impl;

import java.util.Collection;

import net.sf.parteg.base.testcasetree.generated.GeneratedPackage;
import net.sf.parteg.base.testcasetree.generated.TCGNode;
import net.sf.parteg.base.testcasetree.generated.TCGOCLExpression;
import net.sf.parteg.base.testcasetree.generated.TCGParameter;
import net.sf.parteg.base.testcasetree.generated.TCGTransition;
import net.sf.parteg.base.testcasetree.generated.TestCaseGraph;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Test Case Graph</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.sf.parteg.base.testcasetree.generated.impl.TestCaseGraphImpl#getRoot <em>Root</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasetree.generated.impl.TestCaseGraphImpl#getNodes <em>Nodes</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasetree.generated.impl.TestCaseGraphImpl#getTransitions <em>Transitions</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasetree.generated.impl.TestCaseGraphImpl#getConditions <em>Conditions</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasetree.generated.impl.TestCaseGraphImpl#getAttributes <em>Attributes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TestCaseGraphImpl extends EObjectImpl implements TestCaseGraph {
	/**
	 * The cached value of the '{@link #getRoot() <em>Root</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoot()
	 * @generated
	 * @ordered
	 */
	protected TCGNode root;

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
	 * The cached value of the '{@link #getConditions() <em>Conditions</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConditions()
	 * @generated
	 * @ordered
	 */
	protected EList<TCGOCLExpression> conditions;

	/**
	 * The cached value of the '{@link #getAttributes() <em>Attributes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributes()
	 * @generated
	 * @ordered
	 */
	protected EList<TCGParameter> attributes;

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
	public TCGNode getRoot() {
		if (root != null && root.eIsProxy()) {
			InternalEObject oldRoot = (InternalEObject)root;
			root = (TCGNode)eResolveProxy(oldRoot);
			if (root != oldRoot) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GeneratedPackage.TEST_CASE_GRAPH__ROOT, oldRoot, root));
			}
		}
		return root;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TCGNode basicGetRoot() {
		return root;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRoot(TCGNode newRoot) {
		TCGNode oldRoot = root;
		root = newRoot;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedPackage.TEST_CASE_GRAPH__ROOT, oldRoot, root));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TCGNode> getNodes() {
		if (nodes == null) {
			nodes = new EObjectContainmentEList<TCGNode>(TCGNode.class, this, GeneratedPackage.TEST_CASE_GRAPH__NODES);
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
			transitions = new EObjectContainmentEList<TCGTransition>(TCGTransition.class, this, GeneratedPackage.TEST_CASE_GRAPH__TRANSITIONS);
		}
		return transitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TCGOCLExpression> getConditions() {
		if (conditions == null) {
			conditions = new EObjectResolvingEList<TCGOCLExpression>(TCGOCLExpression.class, this, GeneratedPackage.TEST_CASE_GRAPH__CONDITIONS);
		}
		return conditions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TCGParameter> getAttributes() {
		if (attributes == null) {
			attributes = new EObjectContainmentEList<TCGParameter>(TCGParameter.class, this, GeneratedPackage.TEST_CASE_GRAPH__ATTRIBUTES);
		}
		return attributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GeneratedPackage.TEST_CASE_GRAPH__NODES:
				return ((InternalEList<?>)getNodes()).basicRemove(otherEnd, msgs);
			case GeneratedPackage.TEST_CASE_GRAPH__TRANSITIONS:
				return ((InternalEList<?>)getTransitions()).basicRemove(otherEnd, msgs);
			case GeneratedPackage.TEST_CASE_GRAPH__ATTRIBUTES:
				return ((InternalEList<?>)getAttributes()).basicRemove(otherEnd, msgs);
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
			case GeneratedPackage.TEST_CASE_GRAPH__ROOT:
				if (resolve) return getRoot();
				return basicGetRoot();
			case GeneratedPackage.TEST_CASE_GRAPH__NODES:
				return getNodes();
			case GeneratedPackage.TEST_CASE_GRAPH__TRANSITIONS:
				return getTransitions();
			case GeneratedPackage.TEST_CASE_GRAPH__CONDITIONS:
				return getConditions();
			case GeneratedPackage.TEST_CASE_GRAPH__ATTRIBUTES:
				return getAttributes();
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
			case GeneratedPackage.TEST_CASE_GRAPH__ROOT:
				setRoot((TCGNode)newValue);
				return;
			case GeneratedPackage.TEST_CASE_GRAPH__NODES:
				getNodes().clear();
				getNodes().addAll((Collection<? extends TCGNode>)newValue);
				return;
			case GeneratedPackage.TEST_CASE_GRAPH__TRANSITIONS:
				getTransitions().clear();
				getTransitions().addAll((Collection<? extends TCGTransition>)newValue);
				return;
			case GeneratedPackage.TEST_CASE_GRAPH__CONDITIONS:
				getConditions().clear();
				getConditions().addAll((Collection<? extends TCGOCLExpression>)newValue);
				return;
			case GeneratedPackage.TEST_CASE_GRAPH__ATTRIBUTES:
				getAttributes().clear();
				getAttributes().addAll((Collection<? extends TCGParameter>)newValue);
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
			case GeneratedPackage.TEST_CASE_GRAPH__ROOT:
				setRoot((TCGNode)null);
				return;
			case GeneratedPackage.TEST_CASE_GRAPH__NODES:
				getNodes().clear();
				return;
			case GeneratedPackage.TEST_CASE_GRAPH__TRANSITIONS:
				getTransitions().clear();
				return;
			case GeneratedPackage.TEST_CASE_GRAPH__CONDITIONS:
				getConditions().clear();
				return;
			case GeneratedPackage.TEST_CASE_GRAPH__ATTRIBUTES:
				getAttributes().clear();
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
			case GeneratedPackage.TEST_CASE_GRAPH__ROOT:
				return root != null;
			case GeneratedPackage.TEST_CASE_GRAPH__NODES:
				return nodes != null && !nodes.isEmpty();
			case GeneratedPackage.TEST_CASE_GRAPH__TRANSITIONS:
				return transitions != null && !transitions.isEmpty();
			case GeneratedPackage.TEST_CASE_GRAPH__CONDITIONS:
				return conditions != null && !conditions.isEmpty();
			case GeneratedPackage.TEST_CASE_GRAPH__ATTRIBUTES:
				return attributes != null && !attributes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TestCaseGraphImpl
