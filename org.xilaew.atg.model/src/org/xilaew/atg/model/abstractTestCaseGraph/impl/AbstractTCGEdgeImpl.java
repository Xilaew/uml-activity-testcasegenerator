/**
 */
package org.xilaew.atg.model.abstractTestCaseGraph.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGConstraint;
import org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGEdge;
import org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGNode;
import org.xilaew.atg.model.abstractTestCaseGraph.AbstractTestCaseGraphPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract TCG Edge</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.xilaew.atg.model.abstractTestCaseGraph.impl.AbstractTCGEdgeImpl#getSource <em>Source</em>}</li>
 *   <li>{@link org.xilaew.atg.model.abstractTestCaseGraph.impl.AbstractTCGEdgeImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.xilaew.atg.model.abstractTestCaseGraph.impl.AbstractTCGEdgeImpl#getGuard <em>Guard</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AbstractTCGEdgeImpl extends AbstractTCGElementImpl implements AbstractTCGEdge {
	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected AbstractTCGNode source;

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected AbstractTCGNode target;

	/**
	 * The cached value of the '{@link #getGuard() <em>Guard</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGuard()
	 * @generated
	 * @ordered
	 */
	protected AbstractTCGConstraint guard;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractTCGEdgeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AbstractTestCaseGraphPackage.Literals.ABSTRACT_TCG_EDGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractTCGNode getSource() {
		if (source != null && source.eIsProxy()) {
			InternalEObject oldSource = (InternalEObject)source;
			source = (AbstractTCGNode)eResolveProxy(oldSource);
			if (source != oldSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AbstractTestCaseGraphPackage.ABSTRACT_TCG_EDGE__SOURCE, oldSource, source));
			}
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractTCGNode basicGetSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSource(AbstractTCGNode newSource, NotificationChain msgs) {
		AbstractTCGNode oldSource = source;
		source = newSource;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AbstractTestCaseGraphPackage.ABSTRACT_TCG_EDGE__SOURCE, oldSource, newSource);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(AbstractTCGNode newSource) {
		if (newSource != source) {
			NotificationChain msgs = null;
			if (source != null)
				msgs = ((InternalEObject)source).eInverseRemove(this, AbstractTestCaseGraphPackage.ABSTRACT_TCG_NODE__OUTGOING, AbstractTCGNode.class, msgs);
			if (newSource != null)
				msgs = ((InternalEObject)newSource).eInverseAdd(this, AbstractTestCaseGraphPackage.ABSTRACT_TCG_NODE__OUTGOING, AbstractTCGNode.class, msgs);
			msgs = basicSetSource(newSource, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AbstractTestCaseGraphPackage.ABSTRACT_TCG_EDGE__SOURCE, newSource, newSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractTCGNode getTarget() {
		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject)target;
			target = (AbstractTCGNode)eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AbstractTestCaseGraphPackage.ABSTRACT_TCG_EDGE__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractTCGNode basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTarget(AbstractTCGNode newTarget, NotificationChain msgs) {
		AbstractTCGNode oldTarget = target;
		target = newTarget;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AbstractTestCaseGraphPackage.ABSTRACT_TCG_EDGE__TARGET, oldTarget, newTarget);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(AbstractTCGNode newTarget) {
		if (newTarget != target) {
			NotificationChain msgs = null;
			if (target != null)
				msgs = ((InternalEObject)target).eInverseRemove(this, AbstractTestCaseGraphPackage.ABSTRACT_TCG_NODE__INCOMING, AbstractTCGNode.class, msgs);
			if (newTarget != null)
				msgs = ((InternalEObject)newTarget).eInverseAdd(this, AbstractTestCaseGraphPackage.ABSTRACT_TCG_NODE__INCOMING, AbstractTCGNode.class, msgs);
			msgs = basicSetTarget(newTarget, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AbstractTestCaseGraphPackage.ABSTRACT_TCG_EDGE__TARGET, newTarget, newTarget));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractTCGConstraint getGuard() {
		return guard;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGuard(AbstractTCGConstraint newGuard, NotificationChain msgs) {
		AbstractTCGConstraint oldGuard = guard;
		guard = newGuard;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AbstractTestCaseGraphPackage.ABSTRACT_TCG_EDGE__GUARD, oldGuard, newGuard);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGuard(AbstractTCGConstraint newGuard) {
		if (newGuard != guard) {
			NotificationChain msgs = null;
			if (guard != null)
				msgs = ((InternalEObject)guard).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AbstractTestCaseGraphPackage.ABSTRACT_TCG_EDGE__GUARD, null, msgs);
			if (newGuard != null)
				msgs = ((InternalEObject)newGuard).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AbstractTestCaseGraphPackage.ABSTRACT_TCG_EDGE__GUARD, null, msgs);
			msgs = basicSetGuard(newGuard, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AbstractTestCaseGraphPackage.ABSTRACT_TCG_EDGE__GUARD, newGuard, newGuard));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AbstractTestCaseGraphPackage.ABSTRACT_TCG_EDGE__SOURCE:
				if (source != null)
					msgs = ((InternalEObject)source).eInverseRemove(this, AbstractTestCaseGraphPackage.ABSTRACT_TCG_NODE__OUTGOING, AbstractTCGNode.class, msgs);
				return basicSetSource((AbstractTCGNode)otherEnd, msgs);
			case AbstractTestCaseGraphPackage.ABSTRACT_TCG_EDGE__TARGET:
				if (target != null)
					msgs = ((InternalEObject)target).eInverseRemove(this, AbstractTestCaseGraphPackage.ABSTRACT_TCG_NODE__INCOMING, AbstractTCGNode.class, msgs);
				return basicSetTarget((AbstractTCGNode)otherEnd, msgs);
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
			case AbstractTestCaseGraphPackage.ABSTRACT_TCG_EDGE__SOURCE:
				return basicSetSource(null, msgs);
			case AbstractTestCaseGraphPackage.ABSTRACT_TCG_EDGE__TARGET:
				return basicSetTarget(null, msgs);
			case AbstractTestCaseGraphPackage.ABSTRACT_TCG_EDGE__GUARD:
				return basicSetGuard(null, msgs);
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
			case AbstractTestCaseGraphPackage.ABSTRACT_TCG_EDGE__SOURCE:
				if (resolve) return getSource();
				return basicGetSource();
			case AbstractTestCaseGraphPackage.ABSTRACT_TCG_EDGE__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
			case AbstractTestCaseGraphPackage.ABSTRACT_TCG_EDGE__GUARD:
				return getGuard();
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
			case AbstractTestCaseGraphPackage.ABSTRACT_TCG_EDGE__SOURCE:
				setSource((AbstractTCGNode)newValue);
				return;
			case AbstractTestCaseGraphPackage.ABSTRACT_TCG_EDGE__TARGET:
				setTarget((AbstractTCGNode)newValue);
				return;
			case AbstractTestCaseGraphPackage.ABSTRACT_TCG_EDGE__GUARD:
				setGuard((AbstractTCGConstraint)newValue);
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
			case AbstractTestCaseGraphPackage.ABSTRACT_TCG_EDGE__SOURCE:
				setSource((AbstractTCGNode)null);
				return;
			case AbstractTestCaseGraphPackage.ABSTRACT_TCG_EDGE__TARGET:
				setTarget((AbstractTCGNode)null);
				return;
			case AbstractTestCaseGraphPackage.ABSTRACT_TCG_EDGE__GUARD:
				setGuard((AbstractTCGConstraint)null);
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
			case AbstractTestCaseGraphPackage.ABSTRACT_TCG_EDGE__SOURCE:
				return source != null;
			case AbstractTestCaseGraphPackage.ABSTRACT_TCG_EDGE__TARGET:
				return target != null;
			case AbstractTestCaseGraphPackage.ABSTRACT_TCG_EDGE__GUARD:
				return guard != null;
		}
		return super.eIsSet(featureID);
	}

} //AbstractTCGEdgeImpl
