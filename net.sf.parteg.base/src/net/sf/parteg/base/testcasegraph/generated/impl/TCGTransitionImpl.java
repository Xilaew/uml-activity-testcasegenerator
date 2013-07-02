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
import net.sf.parteg.base.testcasegraph.generated.TCGEvent;
import net.sf.parteg.base.testcasegraph.generated.TCGNode;
import net.sf.parteg.base.testcasegraph.generated.TCGTransition;

import net.sf.parteg.base.testcasegraph.generated.TestCaseRegion;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TCG Transition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.sf.parteg.base.testcasegraph.generated.impl.TCGTransitionImpl#getName <em>Name</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasegraph.generated.impl.TCGTransitionImpl#getSourceNode <em>Source Node</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasegraph.generated.impl.TCGTransitionImpl#getTargetNode <em>Target Node</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasegraph.generated.impl.TCGTransitionImpl#getEvents <em>Events</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasegraph.generated.impl.TCGTransitionImpl#getPrecondition <em>Precondition</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasegraph.generated.impl.TCGTransitionImpl#getPostcondition <em>Postcondition</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasegraph.generated.impl.TCGTransitionImpl#getContainer <em>Container</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasegraph.generated.impl.TCGTransitionImpl#isCanBeProcessed <em>Can Be Processed</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TCGTransitionImpl extends TCGElementImpl implements TCGTransition {
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
	 * The cached value of the '{@link #getSourceNode() <em>Source Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceNode()
	 * @generated
	 * @ordered
	 */
	protected TCGNode sourceNode;

	/**
	 * The cached value of the '{@link #getTargetNode() <em>Target Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetNode()
	 * @generated
	 * @ordered
	 */
	protected TCGNode targetNode;

	/**
	 * The cached value of the '{@link #getEvents() <em>Events</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEvents()
	 * @generated
	 * @ordered
	 */
	protected EList<TCGEvent> events;

	/**
	 * The cached value of the '{@link #getPrecondition() <em>Precondition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrecondition()
	 * @generated
	 * @ordered
	 */
	protected TCGDisjunctiveNormalForm precondition;

	/**
	 * The cached value of the '{@link #getPostcondition() <em>Postcondition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPostcondition()
	 * @generated
	 * @ordered
	 */
	protected TCGDisjunctiveNormalForm postcondition;

	/**
	 * The default value of the '{@link #isCanBeProcessed() <em>Can Be Processed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCanBeProcessed()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CAN_BE_PROCESSED_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isCanBeProcessed() <em>Can Be Processed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCanBeProcessed()
	 * @generated
	 * @ordered
	 */
	protected boolean canBeProcessed = CAN_BE_PROCESSED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TCGTransitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeneratedPackage.Literals.TCG_TRANSITION;
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
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedPackage.TCG_TRANSITION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TCGNode getSourceNode() {
		if (sourceNode != null && sourceNode.eIsProxy()) {
			InternalEObject oldSourceNode = (InternalEObject)sourceNode;
			sourceNode = (TCGNode)eResolveProxy(oldSourceNode);
			if (sourceNode != oldSourceNode) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GeneratedPackage.TCG_TRANSITION__SOURCE_NODE, oldSourceNode, sourceNode));
			}
		}
		return sourceNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TCGNode basicGetSourceNode() {
		return sourceNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceNode(TCGNode newSourceNode) {
		TCGNode oldSourceNode = sourceNode;
		sourceNode = newSourceNode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedPackage.TCG_TRANSITION__SOURCE_NODE, oldSourceNode, sourceNode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TCGNode getTargetNode() {
		if (targetNode != null && targetNode.eIsProxy()) {
			InternalEObject oldTargetNode = (InternalEObject)targetNode;
			targetNode = (TCGNode)eResolveProxy(oldTargetNode);
			if (targetNode != oldTargetNode) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GeneratedPackage.TCG_TRANSITION__TARGET_NODE, oldTargetNode, targetNode));
			}
		}
		return targetNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TCGNode basicGetTargetNode() {
		return targetNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetNode(TCGNode newTargetNode) {
		TCGNode oldTargetNode = targetNode;
		targetNode = newTargetNode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedPackage.TCG_TRANSITION__TARGET_NODE, oldTargetNode, targetNode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TCGEvent> getEvents() {
		if (events == null) {
			events = new EObjectResolvingEList<TCGEvent>(TCGEvent.class, this, GeneratedPackage.TCG_TRANSITION__EVENTS);
		}
		return events;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TCGDisjunctiveNormalForm getPrecondition() {
		return precondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPrecondition(TCGDisjunctiveNormalForm newPrecondition, NotificationChain msgs) {
		TCGDisjunctiveNormalForm oldPrecondition = precondition;
		precondition = newPrecondition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GeneratedPackage.TCG_TRANSITION__PRECONDITION, oldPrecondition, newPrecondition);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrecondition(TCGDisjunctiveNormalForm newPrecondition) {
		if (newPrecondition != precondition) {
			NotificationChain msgs = null;
			if (precondition != null)
				msgs = ((InternalEObject)precondition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GeneratedPackage.TCG_TRANSITION__PRECONDITION, null, msgs);
			if (newPrecondition != null)
				msgs = ((InternalEObject)newPrecondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GeneratedPackage.TCG_TRANSITION__PRECONDITION, null, msgs);
			msgs = basicSetPrecondition(newPrecondition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedPackage.TCG_TRANSITION__PRECONDITION, newPrecondition, newPrecondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TCGDisjunctiveNormalForm getPostcondition() {
		return postcondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPostcondition(TCGDisjunctiveNormalForm newPostcondition, NotificationChain msgs) {
		TCGDisjunctiveNormalForm oldPostcondition = postcondition;
		postcondition = newPostcondition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GeneratedPackage.TCG_TRANSITION__POSTCONDITION, oldPostcondition, newPostcondition);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPostcondition(TCGDisjunctiveNormalForm newPostcondition) {
		if (newPostcondition != postcondition) {
			NotificationChain msgs = null;
			if (postcondition != null)
				msgs = ((InternalEObject)postcondition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GeneratedPackage.TCG_TRANSITION__POSTCONDITION, null, msgs);
			if (newPostcondition != null)
				msgs = ((InternalEObject)newPostcondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GeneratedPackage.TCG_TRANSITION__POSTCONDITION, null, msgs);
			msgs = basicSetPostcondition(newPostcondition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedPackage.TCG_TRANSITION__POSTCONDITION, newPostcondition, newPostcondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestCaseRegion getContainer() {
		if (eContainerFeatureID != GeneratedPackage.TCG_TRANSITION__CONTAINER) return null;
		return (TestCaseRegion)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContainer(TestCaseRegion newContainer, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newContainer, GeneratedPackage.TCG_TRANSITION__CONTAINER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainer(TestCaseRegion newContainer) {
		if (newContainer != eInternalContainer() || (eContainerFeatureID != GeneratedPackage.TCG_TRANSITION__CONTAINER && newContainer != null)) {
			if (EcoreUtil.isAncestor(this, newContainer))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newContainer != null)
				msgs = ((InternalEObject)newContainer).eInverseAdd(this, GeneratedPackage.TEST_CASE_REGION__TRANSITIONS, TestCaseRegion.class, msgs);
			msgs = basicSetContainer(newContainer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedPackage.TCG_TRANSITION__CONTAINER, newContainer, newContainer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isCanBeProcessed() {
		return canBeProcessed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCanBeProcessed(boolean newCanBeProcessed) {
		boolean oldCanBeProcessed = canBeProcessed;
		canBeProcessed = newCanBeProcessed;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedPackage.TCG_TRANSITION__CAN_BE_PROCESSED, oldCanBeProcessed, canBeProcessed));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GeneratedPackage.TCG_TRANSITION__CONTAINER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetContainer((TestCaseRegion)otherEnd, msgs);
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
			case GeneratedPackage.TCG_TRANSITION__PRECONDITION:
				return basicSetPrecondition(null, msgs);
			case GeneratedPackage.TCG_TRANSITION__POSTCONDITION:
				return basicSetPostcondition(null, msgs);
			case GeneratedPackage.TCG_TRANSITION__CONTAINER:
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
			case GeneratedPackage.TCG_TRANSITION__CONTAINER:
				return eInternalContainer().eInverseRemove(this, GeneratedPackage.TEST_CASE_REGION__TRANSITIONS, TestCaseRegion.class, msgs);
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
			case GeneratedPackage.TCG_TRANSITION__NAME:
				return getName();
			case GeneratedPackage.TCG_TRANSITION__SOURCE_NODE:
				if (resolve) return getSourceNode();
				return basicGetSourceNode();
			case GeneratedPackage.TCG_TRANSITION__TARGET_NODE:
				if (resolve) return getTargetNode();
				return basicGetTargetNode();
			case GeneratedPackage.TCG_TRANSITION__EVENTS:
				return getEvents();
			case GeneratedPackage.TCG_TRANSITION__PRECONDITION:
				return getPrecondition();
			case GeneratedPackage.TCG_TRANSITION__POSTCONDITION:
				return getPostcondition();
			case GeneratedPackage.TCG_TRANSITION__CONTAINER:
				return getContainer();
			case GeneratedPackage.TCG_TRANSITION__CAN_BE_PROCESSED:
				return isCanBeProcessed() ? Boolean.TRUE : Boolean.FALSE;
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
			case GeneratedPackage.TCG_TRANSITION__NAME:
				setName((String)newValue);
				return;
			case GeneratedPackage.TCG_TRANSITION__SOURCE_NODE:
				setSourceNode((TCGNode)newValue);
				return;
			case GeneratedPackage.TCG_TRANSITION__TARGET_NODE:
				setTargetNode((TCGNode)newValue);
				return;
			case GeneratedPackage.TCG_TRANSITION__EVENTS:
				getEvents().clear();
				getEvents().addAll((Collection<? extends TCGEvent>)newValue);
				return;
			case GeneratedPackage.TCG_TRANSITION__PRECONDITION:
				setPrecondition((TCGDisjunctiveNormalForm)newValue);
				return;
			case GeneratedPackage.TCG_TRANSITION__POSTCONDITION:
				setPostcondition((TCGDisjunctiveNormalForm)newValue);
				return;
			case GeneratedPackage.TCG_TRANSITION__CONTAINER:
				setContainer((TestCaseRegion)newValue);
				return;
			case GeneratedPackage.TCG_TRANSITION__CAN_BE_PROCESSED:
				setCanBeProcessed(((Boolean)newValue).booleanValue());
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
			case GeneratedPackage.TCG_TRANSITION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case GeneratedPackage.TCG_TRANSITION__SOURCE_NODE:
				setSourceNode((TCGNode)null);
				return;
			case GeneratedPackage.TCG_TRANSITION__TARGET_NODE:
				setTargetNode((TCGNode)null);
				return;
			case GeneratedPackage.TCG_TRANSITION__EVENTS:
				getEvents().clear();
				return;
			case GeneratedPackage.TCG_TRANSITION__PRECONDITION:
				setPrecondition((TCGDisjunctiveNormalForm)null);
				return;
			case GeneratedPackage.TCG_TRANSITION__POSTCONDITION:
				setPostcondition((TCGDisjunctiveNormalForm)null);
				return;
			case GeneratedPackage.TCG_TRANSITION__CONTAINER:
				setContainer((TestCaseRegion)null);
				return;
			case GeneratedPackage.TCG_TRANSITION__CAN_BE_PROCESSED:
				setCanBeProcessed(CAN_BE_PROCESSED_EDEFAULT);
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
			case GeneratedPackage.TCG_TRANSITION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case GeneratedPackage.TCG_TRANSITION__SOURCE_NODE:
				return sourceNode != null;
			case GeneratedPackage.TCG_TRANSITION__TARGET_NODE:
				return targetNode != null;
			case GeneratedPackage.TCG_TRANSITION__EVENTS:
				return events != null && !events.isEmpty();
			case GeneratedPackage.TCG_TRANSITION__PRECONDITION:
				return precondition != null;
			case GeneratedPackage.TCG_TRANSITION__POSTCONDITION:
				return postcondition != null;
			case GeneratedPackage.TCG_TRANSITION__CONTAINER:
				return getContainer() != null;
			case GeneratedPackage.TCG_TRANSITION__CAN_BE_PROCESSED:
				return canBeProcessed != CAN_BE_PROCESSED_EDEFAULT;
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
		result.append(", canBeProcessed: ");
		result.append(canBeProcessed);
		result.append(')');
		return result.toString();
	}

} //TCGTransitionImpl
