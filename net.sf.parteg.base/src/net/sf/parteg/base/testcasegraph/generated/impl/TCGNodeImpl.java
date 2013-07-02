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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TCG Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.sf.parteg.base.testcasegraph.generated.impl.TCGNodeImpl#getName <em>Name</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasegraph.generated.impl.TCGNodeImpl#getIncomingTransitions <em>Incoming Transitions</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasegraph.generated.impl.TCGNodeImpl#getOutgoingTransitions <em>Outgoing Transitions</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasegraph.generated.impl.TCGNodeImpl#getOriginalNode <em>Original Node</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasegraph.generated.impl.TCGNodeImpl#isUseAllTransitionsInParallel <em>Use All Transitions In Parallel</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasegraph.generated.impl.TCGNodeImpl#getReferencedSubmachine <em>Referenced Submachine</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasegraph.generated.impl.TCGNodeImpl#getMinDistanceFromStart <em>Min Distance From Start</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasegraph.generated.impl.TCGNodeImpl#getMaxDistanceFromStart <em>Max Distance From Start</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TCGNodeImpl extends TCGElementImpl implements TCGNode {
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
	 * The cached value of the '{@link #getIncomingTransitions() <em>Incoming Transitions</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncomingTransitions()
	 * @generated
	 * @ordered
	 */
	protected EList<TCGTransition> incomingTransitions;

	/**
	 * The cached value of the '{@link #getOutgoingTransitions() <em>Outgoing Transitions</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutgoingTransitions()
	 * @generated
	 * @ordered
	 */
	protected EList<TCGTransition> outgoingTransitions;

	/**
	 * The cached value of the '{@link #getOriginalNode() <em>Original Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOriginalNode()
	 * @generated
	 * @ordered
	 */
	protected EObject originalNode;

	/**
	 * The default value of the '{@link #isUseAllTransitionsInParallel() <em>Use All Transitions In Parallel</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUseAllTransitionsInParallel()
	 * @generated
	 * @ordered
	 */
	protected static final boolean USE_ALL_TRANSITIONS_IN_PARALLEL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isUseAllTransitionsInParallel() <em>Use All Transitions In Parallel</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUseAllTransitionsInParallel()
	 * @generated
	 * @ordered
	 */
	protected boolean useAllTransitionsInParallel = USE_ALL_TRANSITIONS_IN_PARALLEL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getReferencedSubmachine() <em>Referenced Submachine</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferencedSubmachine()
	 * @generated
	 * @ordered
	 */
	protected TestCaseGraph referencedSubmachine;

	/**
	 * The default value of the '{@link #getMinDistanceFromStart() <em>Min Distance From Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinDistanceFromStart()
	 * @generated
	 * @ordered
	 */
	protected static final int MIN_DISTANCE_FROM_START_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getMinDistanceFromStart() <em>Min Distance From Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinDistanceFromStart()
	 * @generated
	 * @ordered
	 */
	protected int minDistanceFromStart = MIN_DISTANCE_FROM_START_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxDistanceFromStart() <em>Max Distance From Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxDistanceFromStart()
	 * @generated
	 * @ordered
	 */
	protected static final int MAX_DISTANCE_FROM_START_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getMaxDistanceFromStart() <em>Max Distance From Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxDistanceFromStart()
	 * @generated
	 * @ordered
	 */
	protected int maxDistanceFromStart = MAX_DISTANCE_FROM_START_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TCGNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeneratedPackage.Literals.TCG_NODE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedPackage.TCG_NODE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TCGTransition> getIncomingTransitions() {
		if (incomingTransitions == null) {
			incomingTransitions = new EObjectResolvingEList<TCGTransition>(TCGTransition.class, this, GeneratedPackage.TCG_NODE__INCOMING_TRANSITIONS);
		}
		return incomingTransitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TCGTransition> getOutgoingTransitions() {
		if (outgoingTransitions == null) {
			outgoingTransitions = new EObjectResolvingEList<TCGTransition>(TCGTransition.class, this, GeneratedPackage.TCG_NODE__OUTGOING_TRANSITIONS);
		}
		return outgoingTransitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getOriginalNode() {
		if (originalNode != null && originalNode.eIsProxy()) {
			InternalEObject oldOriginalNode = (InternalEObject)originalNode;
			originalNode = eResolveProxy(oldOriginalNode);
			if (originalNode != oldOriginalNode) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GeneratedPackage.TCG_NODE__ORIGINAL_NODE, oldOriginalNode, originalNode));
			}
		}
		return originalNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetOriginalNode() {
		return originalNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOriginalNode(EObject newOriginalNode) {
		EObject oldOriginalNode = originalNode;
		originalNode = newOriginalNode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedPackage.TCG_NODE__ORIGINAL_NODE, oldOriginalNode, originalNode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isUseAllTransitionsInParallel() {
		return useAllTransitionsInParallel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUseAllTransitionsInParallel(boolean newUseAllTransitionsInParallel) {
		boolean oldUseAllTransitionsInParallel = useAllTransitionsInParallel;
		useAllTransitionsInParallel = newUseAllTransitionsInParallel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedPackage.TCG_NODE__USE_ALL_TRANSITIONS_IN_PARALLEL, oldUseAllTransitionsInParallel, useAllTransitionsInParallel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestCaseGraph getReferencedSubmachine() {
		if (referencedSubmachine != null && referencedSubmachine.eIsProxy()) {
			InternalEObject oldReferencedSubmachine = (InternalEObject)referencedSubmachine;
			referencedSubmachine = (TestCaseGraph)eResolveProxy(oldReferencedSubmachine);
			if (referencedSubmachine != oldReferencedSubmachine) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GeneratedPackage.TCG_NODE__REFERENCED_SUBMACHINE, oldReferencedSubmachine, referencedSubmachine));
			}
		}
		return referencedSubmachine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestCaseGraph basicGetReferencedSubmachine() {
		return referencedSubmachine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferencedSubmachine(TestCaseGraph newReferencedSubmachine) {
		TestCaseGraph oldReferencedSubmachine = referencedSubmachine;
		referencedSubmachine = newReferencedSubmachine;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedPackage.TCG_NODE__REFERENCED_SUBMACHINE, oldReferencedSubmachine, referencedSubmachine));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMinDistanceFromStart() {
		return minDistanceFromStart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinDistanceFromStart(int newMinDistanceFromStart) {
		int oldMinDistanceFromStart = minDistanceFromStart;
		minDistanceFromStart = newMinDistanceFromStart;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedPackage.TCG_NODE__MIN_DISTANCE_FROM_START, oldMinDistanceFromStart, minDistanceFromStart));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMaxDistanceFromStart() {
		return maxDistanceFromStart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxDistanceFromStart(int newMaxDistanceFromStart) {
		int oldMaxDistanceFromStart = maxDistanceFromStart;
		maxDistanceFromStart = newMaxDistanceFromStart;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedPackage.TCG_NODE__MAX_DISTANCE_FROM_START, oldMaxDistanceFromStart, maxDistanceFromStart));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GeneratedPackage.TCG_NODE__NAME:
				return getName();
			case GeneratedPackage.TCG_NODE__INCOMING_TRANSITIONS:
				return getIncomingTransitions();
			case GeneratedPackage.TCG_NODE__OUTGOING_TRANSITIONS:
				return getOutgoingTransitions();
			case GeneratedPackage.TCG_NODE__ORIGINAL_NODE:
				if (resolve) return getOriginalNode();
				return basicGetOriginalNode();
			case GeneratedPackage.TCG_NODE__USE_ALL_TRANSITIONS_IN_PARALLEL:
				return isUseAllTransitionsInParallel() ? Boolean.TRUE : Boolean.FALSE;
			case GeneratedPackage.TCG_NODE__REFERENCED_SUBMACHINE:
				if (resolve) return getReferencedSubmachine();
				return basicGetReferencedSubmachine();
			case GeneratedPackage.TCG_NODE__MIN_DISTANCE_FROM_START:
				return new Integer(getMinDistanceFromStart());
			case GeneratedPackage.TCG_NODE__MAX_DISTANCE_FROM_START:
				return new Integer(getMaxDistanceFromStart());
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
			case GeneratedPackage.TCG_NODE__NAME:
				setName((String)newValue);
				return;
			case GeneratedPackage.TCG_NODE__INCOMING_TRANSITIONS:
				getIncomingTransitions().clear();
				getIncomingTransitions().addAll((Collection<? extends TCGTransition>)newValue);
				return;
			case GeneratedPackage.TCG_NODE__OUTGOING_TRANSITIONS:
				getOutgoingTransitions().clear();
				getOutgoingTransitions().addAll((Collection<? extends TCGTransition>)newValue);
				return;
			case GeneratedPackage.TCG_NODE__ORIGINAL_NODE:
				setOriginalNode((EObject)newValue);
				return;
			case GeneratedPackage.TCG_NODE__USE_ALL_TRANSITIONS_IN_PARALLEL:
				setUseAllTransitionsInParallel(((Boolean)newValue).booleanValue());
				return;
			case GeneratedPackage.TCG_NODE__REFERENCED_SUBMACHINE:
				setReferencedSubmachine((TestCaseGraph)newValue);
				return;
			case GeneratedPackage.TCG_NODE__MIN_DISTANCE_FROM_START:
				setMinDistanceFromStart(((Integer)newValue).intValue());
				return;
			case GeneratedPackage.TCG_NODE__MAX_DISTANCE_FROM_START:
				setMaxDistanceFromStart(((Integer)newValue).intValue());
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
			case GeneratedPackage.TCG_NODE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case GeneratedPackage.TCG_NODE__INCOMING_TRANSITIONS:
				getIncomingTransitions().clear();
				return;
			case GeneratedPackage.TCG_NODE__OUTGOING_TRANSITIONS:
				getOutgoingTransitions().clear();
				return;
			case GeneratedPackage.TCG_NODE__ORIGINAL_NODE:
				setOriginalNode((EObject)null);
				return;
			case GeneratedPackage.TCG_NODE__USE_ALL_TRANSITIONS_IN_PARALLEL:
				setUseAllTransitionsInParallel(USE_ALL_TRANSITIONS_IN_PARALLEL_EDEFAULT);
				return;
			case GeneratedPackage.TCG_NODE__REFERENCED_SUBMACHINE:
				setReferencedSubmachine((TestCaseGraph)null);
				return;
			case GeneratedPackage.TCG_NODE__MIN_DISTANCE_FROM_START:
				setMinDistanceFromStart(MIN_DISTANCE_FROM_START_EDEFAULT);
				return;
			case GeneratedPackage.TCG_NODE__MAX_DISTANCE_FROM_START:
				setMaxDistanceFromStart(MAX_DISTANCE_FROM_START_EDEFAULT);
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
			case GeneratedPackage.TCG_NODE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case GeneratedPackage.TCG_NODE__INCOMING_TRANSITIONS:
				return incomingTransitions != null && !incomingTransitions.isEmpty();
			case GeneratedPackage.TCG_NODE__OUTGOING_TRANSITIONS:
				return outgoingTransitions != null && !outgoingTransitions.isEmpty();
			case GeneratedPackage.TCG_NODE__ORIGINAL_NODE:
				return originalNode != null;
			case GeneratedPackage.TCG_NODE__USE_ALL_TRANSITIONS_IN_PARALLEL:
				return useAllTransitionsInParallel != USE_ALL_TRANSITIONS_IN_PARALLEL_EDEFAULT;
			case GeneratedPackage.TCG_NODE__REFERENCED_SUBMACHINE:
				return referencedSubmachine != null;
			case GeneratedPackage.TCG_NODE__MIN_DISTANCE_FROM_START:
				return minDistanceFromStart != MIN_DISTANCE_FROM_START_EDEFAULT;
			case GeneratedPackage.TCG_NODE__MAX_DISTANCE_FROM_START:
				return maxDistanceFromStart != MAX_DISTANCE_FROM_START_EDEFAULT;
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
		result.append(", useAllTransitionsInParallel: ");
		result.append(useAllTransitionsInParallel);
		result.append(", minDistanceFromStart: ");
		result.append(minDistanceFromStart);
		result.append(", maxDistanceFromStart: ");
		result.append(maxDistanceFromStart);
		result.append(')');
		return result.toString();
	}

} //TCGNodeImpl
