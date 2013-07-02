/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.sf.parteg.base.testcasegraph.generated.impl;

import java.util.Collection;

import net.sf.parteg.base.testcasegraph.generated.GeneratedPackage;
import net.sf.parteg.base.testcasegraph.generated.TCGDisjunctiveNormalForm;
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
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TCG Real Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.sf.parteg.base.testcasegraph.generated.impl.TCGRealNodeImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasegraph.generated.impl.TCGRealNodeImpl#getSubGraph <em>Sub Graph</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasegraph.generated.impl.TCGRealNodeImpl#getContainedConnectionPointReferences <em>Contained Connection Point References</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasegraph.generated.impl.TCGRealNodeImpl#getContainedConnectionPoints <em>Contained Connection Points</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasegraph.generated.impl.TCGRealNodeImpl#getContainer <em>Container</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TCGRealNodeImpl extends TCGNodeImpl implements TCGRealNode {
	/**
	 * The cached value of the '{@link #getCondition() <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCondition()
	 * @generated
	 * @ordered
	 */
	protected TCGDisjunctiveNormalForm condition;

	/**
	 * The cached value of the '{@link #getSubGraph() <em>Sub Graph</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubGraph()
	 * @generated
	 * @ordered
	 */
	protected TestCaseGraph subGraph;

	/**
	 * The cached value of the '{@link #getContainedConnectionPointReferences() <em>Contained Connection Point References</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContainedConnectionPointReferences()
	 * @generated
	 * @ordered
	 */
	protected EList<TCGIntermediateNode> containedConnectionPointReferences;

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
	 * The cached value of the '{@link #getContainer() <em>Container</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContainer()
	 * @generated
	 * @ordered
	 */
	protected TestCaseRegion container;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TCGRealNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeneratedPackage.Literals.TCG_REAL_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TCGDisjunctiveNormalForm getCondition() {
		return condition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCondition(TCGDisjunctiveNormalForm newCondition, NotificationChain msgs) {
		TCGDisjunctiveNormalForm oldCondition = condition;
		condition = newCondition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GeneratedPackage.TCG_REAL_NODE__CONDITION, oldCondition, newCondition);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCondition(TCGDisjunctiveNormalForm newCondition) {
		if (newCondition != condition) {
			NotificationChain msgs = null;
			if (condition != null)
				msgs = ((InternalEObject)condition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GeneratedPackage.TCG_REAL_NODE__CONDITION, null, msgs);
			if (newCondition != null)
				msgs = ((InternalEObject)newCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GeneratedPackage.TCG_REAL_NODE__CONDITION, null, msgs);
			msgs = basicSetCondition(newCondition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedPackage.TCG_REAL_NODE__CONDITION, newCondition, newCondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestCaseGraph getSubGraph() {
		if (subGraph != null && subGraph.eIsProxy()) {
			InternalEObject oldSubGraph = (InternalEObject)subGraph;
			subGraph = (TestCaseGraph)eResolveProxy(oldSubGraph);
			if (subGraph != oldSubGraph) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GeneratedPackage.TCG_REAL_NODE__SUB_GRAPH, oldSubGraph, subGraph));
			}
		}
		return subGraph;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestCaseGraph basicGetSubGraph() {
		return subGraph;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubGraph(TestCaseGraph newSubGraph) {
		TestCaseGraph oldSubGraph = subGraph;
		subGraph = newSubGraph;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedPackage.TCG_REAL_NODE__SUB_GRAPH, oldSubGraph, subGraph));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TCGIntermediateNode> getContainedConnectionPointReferences() {
		if (containedConnectionPointReferences == null) {
			containedConnectionPointReferences = new EObjectContainmentEList<TCGIntermediateNode>(TCGIntermediateNode.class, this, GeneratedPackage.TCG_REAL_NODE__CONTAINED_CONNECTION_POINT_REFERENCES);
		}
		return containedConnectionPointReferences;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TCGIntermediateNode> getContainedConnectionPoints() {
		if (containedConnectionPoints == null) {
			containedConnectionPoints = new EObjectContainmentEList<TCGIntermediateNode>(TCGIntermediateNode.class, this, GeneratedPackage.TCG_REAL_NODE__CONTAINED_CONNECTION_POINTS);
		}
		return containedConnectionPoints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestCaseRegion getContainer() {
		if (container != null && container.eIsProxy()) {
			InternalEObject oldContainer = (InternalEObject)container;
			container = (TestCaseRegion)eResolveProxy(oldContainer);
			if (container != oldContainer) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GeneratedPackage.TCG_REAL_NODE__CONTAINER, oldContainer, container));
			}
		}
		return container;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestCaseRegion basicGetContainer() {
		return container;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainer(TestCaseRegion newContainer) {
		TestCaseRegion oldContainer = container;
		container = newContainer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedPackage.TCG_REAL_NODE__CONTAINER, oldContainer, container));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GeneratedPackage.TCG_REAL_NODE__CONDITION:
				return basicSetCondition(null, msgs);
			case GeneratedPackage.TCG_REAL_NODE__CONTAINED_CONNECTION_POINT_REFERENCES:
				return ((InternalEList<?>)getContainedConnectionPointReferences()).basicRemove(otherEnd, msgs);
			case GeneratedPackage.TCG_REAL_NODE__CONTAINED_CONNECTION_POINTS:
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
			case GeneratedPackage.TCG_REAL_NODE__CONDITION:
				return getCondition();
			case GeneratedPackage.TCG_REAL_NODE__SUB_GRAPH:
				if (resolve) return getSubGraph();
				return basicGetSubGraph();
			case GeneratedPackage.TCG_REAL_NODE__CONTAINED_CONNECTION_POINT_REFERENCES:
				return getContainedConnectionPointReferences();
			case GeneratedPackage.TCG_REAL_NODE__CONTAINED_CONNECTION_POINTS:
				return getContainedConnectionPoints();
			case GeneratedPackage.TCG_REAL_NODE__CONTAINER:
				if (resolve) return getContainer();
				return basicGetContainer();
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
			case GeneratedPackage.TCG_REAL_NODE__CONDITION:
				setCondition((TCGDisjunctiveNormalForm)newValue);
				return;
			case GeneratedPackage.TCG_REAL_NODE__SUB_GRAPH:
				setSubGraph((TestCaseGraph)newValue);
				return;
			case GeneratedPackage.TCG_REAL_NODE__CONTAINED_CONNECTION_POINT_REFERENCES:
				getContainedConnectionPointReferences().clear();
				getContainedConnectionPointReferences().addAll((Collection<? extends TCGIntermediateNode>)newValue);
				return;
			case GeneratedPackage.TCG_REAL_NODE__CONTAINED_CONNECTION_POINTS:
				getContainedConnectionPoints().clear();
				getContainedConnectionPoints().addAll((Collection<? extends TCGIntermediateNode>)newValue);
				return;
			case GeneratedPackage.TCG_REAL_NODE__CONTAINER:
				setContainer((TestCaseRegion)newValue);
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
			case GeneratedPackage.TCG_REAL_NODE__CONDITION:
				setCondition((TCGDisjunctiveNormalForm)null);
				return;
			case GeneratedPackage.TCG_REAL_NODE__SUB_GRAPH:
				setSubGraph((TestCaseGraph)null);
				return;
			case GeneratedPackage.TCG_REAL_NODE__CONTAINED_CONNECTION_POINT_REFERENCES:
				getContainedConnectionPointReferences().clear();
				return;
			case GeneratedPackage.TCG_REAL_NODE__CONTAINED_CONNECTION_POINTS:
				getContainedConnectionPoints().clear();
				return;
			case GeneratedPackage.TCG_REAL_NODE__CONTAINER:
				setContainer((TestCaseRegion)null);
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
			case GeneratedPackage.TCG_REAL_NODE__CONDITION:
				return condition != null;
			case GeneratedPackage.TCG_REAL_NODE__SUB_GRAPH:
				return subGraph != null;
			case GeneratedPackage.TCG_REAL_NODE__CONTAINED_CONNECTION_POINT_REFERENCES:
				return containedConnectionPointReferences != null && !containedConnectionPointReferences.isEmpty();
			case GeneratedPackage.TCG_REAL_NODE__CONTAINED_CONNECTION_POINTS:
				return containedConnectionPoints != null && !containedConnectionPoints.isEmpty();
			case GeneratedPackage.TCG_REAL_NODE__CONTAINER:
				return container != null;
		}
		return super.eIsSet(featureID);
	}

} //TCGRealNodeImpl
