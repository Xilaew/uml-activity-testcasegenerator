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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TCG Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.sf.parteg.base.testcasetree.generated.impl.TCGNodeImpl#getName <em>Name</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasetree.generated.impl.TCGNodeImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasetree.generated.impl.TCGNodeImpl#getIncomingTransitions <em>Incoming Transitions</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasetree.generated.impl.TCGNodeImpl#getOutgoingTransitions <em>Outgoing Transitions</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasetree.generated.impl.TCGNodeImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasetree.generated.impl.TCGNodeImpl#getDistanceToRoot <em>Distance To Root</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasetree.generated.impl.TCGNodeImpl#isCorrespondsNegativeExpression <em>Corresponds Negative Expression</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasetree.generated.impl.TCGNodeImpl#getOriginalExpression <em>Original Expression</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasetree.generated.impl.TCGNodeImpl#getInvariant <em>Invariant</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasetree.generated.impl.TCGNodeImpl#getOrigonalNode <em>Origonal Node</em>}</li>
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
	 * The cached value of the '{@link #getCondition() <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCondition()
	 * @generated
	 * @ordered
	 */
	protected TCGOCLExpression condition;

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
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<TCGParameter> parameters;

	/**
	 * The default value of the '{@link #getDistanceToRoot() <em>Distance To Root</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDistanceToRoot()
	 * @generated
	 * @ordered
	 */
	protected static final long DISTANCE_TO_ROOT_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getDistanceToRoot() <em>Distance To Root</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDistanceToRoot()
	 * @generated
	 * @ordered
	 */
	protected long distanceToRoot = DISTANCE_TO_ROOT_EDEFAULT;

	/**
	 * The default value of the '{@link #isCorrespondsNegativeExpression() <em>Corresponds Negative Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCorrespondsNegativeExpression()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CORRESPONDS_NEGATIVE_EXPRESSION_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isCorrespondsNegativeExpression() <em>Corresponds Negative Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCorrespondsNegativeExpression()
	 * @generated
	 * @ordered
	 */
	protected boolean correspondsNegativeExpression = CORRESPONDS_NEGATIVE_EXPRESSION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOriginalExpression() <em>Original Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOriginalExpression()
	 * @generated
	 * @ordered
	 */
	protected EObject originalExpression;

	/**
	 * The cached value of the '{@link #getInvariant() <em>Invariant</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInvariant()
	 * @generated
	 * @ordered
	 */
	protected TCGOCLExpression invariant;

	/**
	 * The cached value of the '{@link #getOrigonalNode() <em>Origonal Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrigonalNode()
	 * @generated
	 * @ordered
	 */
	protected EObject origonalNode;

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
	public TCGOCLExpression getCondition() {
		return condition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCondition(TCGOCLExpression newCondition, NotificationChain msgs) {
		TCGOCLExpression oldCondition = condition;
		condition = newCondition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GeneratedPackage.TCG_NODE__CONDITION, oldCondition, newCondition);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCondition(TCGOCLExpression newCondition) {
		if (newCondition != condition) {
			NotificationChain msgs = null;
			if (condition != null)
				msgs = ((InternalEObject)condition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GeneratedPackage.TCG_NODE__CONDITION, null, msgs);
			if (newCondition != null)
				msgs = ((InternalEObject)newCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GeneratedPackage.TCG_NODE__CONDITION, null, msgs);
			msgs = basicSetCondition(newCondition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedPackage.TCG_NODE__CONDITION, newCondition, newCondition));
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
	public EList<TCGParameter> getParameters() {
		if (parameters == null) {
			parameters = new EObjectContainmentEList<TCGParameter>(TCGParameter.class, this, GeneratedPackage.TCG_NODE__PARAMETERS);
		}
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getDistanceToRoot() {
		return distanceToRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDistanceToRoot(long newDistanceToRoot) {
		long oldDistanceToRoot = distanceToRoot;
		distanceToRoot = newDistanceToRoot;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedPackage.TCG_NODE__DISTANCE_TO_ROOT, oldDistanceToRoot, distanceToRoot));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isCorrespondsNegativeExpression() {
		return correspondsNegativeExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCorrespondsNegativeExpression(boolean newCorrespondsNegativeExpression) {
		boolean oldCorrespondsNegativeExpression = correspondsNegativeExpression;
		correspondsNegativeExpression = newCorrespondsNegativeExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedPackage.TCG_NODE__CORRESPONDS_NEGATIVE_EXPRESSION, oldCorrespondsNegativeExpression, correspondsNegativeExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getOriginalExpression() {
		if (originalExpression != null && originalExpression.eIsProxy()) {
			InternalEObject oldOriginalExpression = (InternalEObject)originalExpression;
			originalExpression = eResolveProxy(oldOriginalExpression);
			if (originalExpression != oldOriginalExpression) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GeneratedPackage.TCG_NODE__ORIGINAL_EXPRESSION, oldOriginalExpression, originalExpression));
			}
		}
		return originalExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetOriginalExpression() {
		return originalExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOriginalExpression(EObject newOriginalExpression) {
		EObject oldOriginalExpression = originalExpression;
		originalExpression = newOriginalExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedPackage.TCG_NODE__ORIGINAL_EXPRESSION, oldOriginalExpression, originalExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TCGOCLExpression getInvariant() {
		if (invariant != null && invariant.eIsProxy()) {
			InternalEObject oldInvariant = (InternalEObject)invariant;
			invariant = (TCGOCLExpression)eResolveProxy(oldInvariant);
			if (invariant != oldInvariant) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GeneratedPackage.TCG_NODE__INVARIANT, oldInvariant, invariant));
			}
		}
		return invariant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TCGOCLExpression basicGetInvariant() {
		return invariant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInvariant(TCGOCLExpression newInvariant) {
		TCGOCLExpression oldInvariant = invariant;
		invariant = newInvariant;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedPackage.TCG_NODE__INVARIANT, oldInvariant, invariant));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getOrigonalNode() {
		if (origonalNode != null && origonalNode.eIsProxy()) {
			InternalEObject oldOrigonalNode = (InternalEObject)origonalNode;
			origonalNode = eResolveProxy(oldOrigonalNode);
			if (origonalNode != oldOrigonalNode) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GeneratedPackage.TCG_NODE__ORIGONAL_NODE, oldOrigonalNode, origonalNode));
			}
		}
		return origonalNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetOrigonalNode() {
		return origonalNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOrigonalNode(EObject newOrigonalNode) {
		EObject oldOrigonalNode = origonalNode;
		origonalNode = newOrigonalNode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedPackage.TCG_NODE__ORIGONAL_NODE, oldOrigonalNode, origonalNode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GeneratedPackage.TCG_NODE__CONDITION:
				return basicSetCondition(null, msgs);
			case GeneratedPackage.TCG_NODE__PARAMETERS:
				return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
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
			case GeneratedPackage.TCG_NODE__NAME:
				return getName();
			case GeneratedPackage.TCG_NODE__CONDITION:
				return getCondition();
			case GeneratedPackage.TCG_NODE__INCOMING_TRANSITIONS:
				return getIncomingTransitions();
			case GeneratedPackage.TCG_NODE__OUTGOING_TRANSITIONS:
				return getOutgoingTransitions();
			case GeneratedPackage.TCG_NODE__PARAMETERS:
				return getParameters();
			case GeneratedPackage.TCG_NODE__DISTANCE_TO_ROOT:
				return new Long(getDistanceToRoot());
			case GeneratedPackage.TCG_NODE__CORRESPONDS_NEGATIVE_EXPRESSION:
				return isCorrespondsNegativeExpression() ? Boolean.TRUE : Boolean.FALSE;
			case GeneratedPackage.TCG_NODE__ORIGINAL_EXPRESSION:
				if (resolve) return getOriginalExpression();
				return basicGetOriginalExpression();
			case GeneratedPackage.TCG_NODE__INVARIANT:
				if (resolve) return getInvariant();
				return basicGetInvariant();
			case GeneratedPackage.TCG_NODE__ORIGONAL_NODE:
				if (resolve) return getOrigonalNode();
				return basicGetOrigonalNode();
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
			case GeneratedPackage.TCG_NODE__CONDITION:
				setCondition((TCGOCLExpression)newValue);
				return;
			case GeneratedPackage.TCG_NODE__INCOMING_TRANSITIONS:
				getIncomingTransitions().clear();
				getIncomingTransitions().addAll((Collection<? extends TCGTransition>)newValue);
				return;
			case GeneratedPackage.TCG_NODE__OUTGOING_TRANSITIONS:
				getOutgoingTransitions().clear();
				getOutgoingTransitions().addAll((Collection<? extends TCGTransition>)newValue);
				return;
			case GeneratedPackage.TCG_NODE__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends TCGParameter>)newValue);
				return;
			case GeneratedPackage.TCG_NODE__DISTANCE_TO_ROOT:
				setDistanceToRoot(((Long)newValue).longValue());
				return;
			case GeneratedPackage.TCG_NODE__CORRESPONDS_NEGATIVE_EXPRESSION:
				setCorrespondsNegativeExpression(((Boolean)newValue).booleanValue());
				return;
			case GeneratedPackage.TCG_NODE__ORIGINAL_EXPRESSION:
				setOriginalExpression((EObject)newValue);
				return;
			case GeneratedPackage.TCG_NODE__INVARIANT:
				setInvariant((TCGOCLExpression)newValue);
				return;
			case GeneratedPackage.TCG_NODE__ORIGONAL_NODE:
				setOrigonalNode((EObject)newValue);
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
			case GeneratedPackage.TCG_NODE__CONDITION:
				setCondition((TCGOCLExpression)null);
				return;
			case GeneratedPackage.TCG_NODE__INCOMING_TRANSITIONS:
				getIncomingTransitions().clear();
				return;
			case GeneratedPackage.TCG_NODE__OUTGOING_TRANSITIONS:
				getOutgoingTransitions().clear();
				return;
			case GeneratedPackage.TCG_NODE__PARAMETERS:
				getParameters().clear();
				return;
			case GeneratedPackage.TCG_NODE__DISTANCE_TO_ROOT:
				setDistanceToRoot(DISTANCE_TO_ROOT_EDEFAULT);
				return;
			case GeneratedPackage.TCG_NODE__CORRESPONDS_NEGATIVE_EXPRESSION:
				setCorrespondsNegativeExpression(CORRESPONDS_NEGATIVE_EXPRESSION_EDEFAULT);
				return;
			case GeneratedPackage.TCG_NODE__ORIGINAL_EXPRESSION:
				setOriginalExpression((EObject)null);
				return;
			case GeneratedPackage.TCG_NODE__INVARIANT:
				setInvariant((TCGOCLExpression)null);
				return;
			case GeneratedPackage.TCG_NODE__ORIGONAL_NODE:
				setOrigonalNode((EObject)null);
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
			case GeneratedPackage.TCG_NODE__CONDITION:
				return condition != null;
			case GeneratedPackage.TCG_NODE__INCOMING_TRANSITIONS:
				return incomingTransitions != null && !incomingTransitions.isEmpty();
			case GeneratedPackage.TCG_NODE__OUTGOING_TRANSITIONS:
				return outgoingTransitions != null && !outgoingTransitions.isEmpty();
			case GeneratedPackage.TCG_NODE__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
			case GeneratedPackage.TCG_NODE__DISTANCE_TO_ROOT:
				return distanceToRoot != DISTANCE_TO_ROOT_EDEFAULT;
			case GeneratedPackage.TCG_NODE__CORRESPONDS_NEGATIVE_EXPRESSION:
				return correspondsNegativeExpression != CORRESPONDS_NEGATIVE_EXPRESSION_EDEFAULT;
			case GeneratedPackage.TCG_NODE__ORIGINAL_EXPRESSION:
				return originalExpression != null;
			case GeneratedPackage.TCG_NODE__INVARIANT:
				return invariant != null;
			case GeneratedPackage.TCG_NODE__ORIGONAL_NODE:
				return origonalNode != null;
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
		result.append(", distanceToRoot: ");
		result.append(distanceToRoot);
		result.append(", correspondsNegativeExpression: ");
		result.append(correspondsNegativeExpression);
		result.append(')');
		return result.toString();
	}

} //TCGNodeImpl
