/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.sf.parteg.base.testsuiteexport.impl;

import java.util.Collection;

import net.sf.parteg.base.testsuiteexport.Action;
import net.sf.parteg.base.testsuiteexport.TC;
import net.sf.parteg.base.testsuiteexport.TestsuiteexportPackage;
import net.sf.parteg.base.testsuiteexport.Variable;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TC</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.sf.parteg.base.testsuiteexport.impl.TCImpl#getDefine <em>Define</em>}</li>
 *   <li>{@link net.sf.parteg.base.testsuiteexport.impl.TCImpl#getAssign <em>Assign</em>}</li>
 *   <li>{@link net.sf.parteg.base.testsuiteexport.impl.TCImpl#getAction <em>Action</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TCImpl extends EObjectImpl implements TC {
	/**
	 * The cached value of the '{@link #getDefine() <em>Define</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefine()
	 * @generated
	 * @ordered
	 */
	protected EList<Variable> define;

	/**
	 * The cached value of the '{@link #getAssign() <em>Assign</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssign()
	 * @generated
	 * @ordered
	 */
	protected EList<Variable> assign;

	/**
	 * The cached value of the '{@link #getAction() <em>Action</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAction()
	 * @generated
	 * @ordered
	 */
	protected EList<Action> action;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TCImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TestsuiteexportPackage.Literals.TC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Variable> getDefine() {
		if (define == null) {
			define = new EObjectContainmentEList<Variable>(Variable.class, this, TestsuiteexportPackage.TC__DEFINE);
		}
		return define;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Variable> getAssign() {
		if (assign == null) {
			assign = new EObjectContainmentEList<Variable>(Variable.class, this, TestsuiteexportPackage.TC__ASSIGN);
		}
		return assign;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Action> getAction() {
		if (action == null) {
			action = new EObjectContainmentEList<Action>(Action.class, this, TestsuiteexportPackage.TC__ACTION);
		}
		return action;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TestsuiteexportPackage.TC__DEFINE:
				return ((InternalEList<?>)getDefine()).basicRemove(otherEnd, msgs);
			case TestsuiteexportPackage.TC__ASSIGN:
				return ((InternalEList<?>)getAssign()).basicRemove(otherEnd, msgs);
			case TestsuiteexportPackage.TC__ACTION:
				return ((InternalEList<?>)getAction()).basicRemove(otherEnd, msgs);
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
			case TestsuiteexportPackage.TC__DEFINE:
				return getDefine();
			case TestsuiteexportPackage.TC__ASSIGN:
				return getAssign();
			case TestsuiteexportPackage.TC__ACTION:
				return getAction();
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
			case TestsuiteexportPackage.TC__DEFINE:
				getDefine().clear();
				getDefine().addAll((Collection<? extends Variable>)newValue);
				return;
			case TestsuiteexportPackage.TC__ASSIGN:
				getAssign().clear();
				getAssign().addAll((Collection<? extends Variable>)newValue);
				return;
			case TestsuiteexportPackage.TC__ACTION:
				getAction().clear();
				getAction().addAll((Collection<? extends Action>)newValue);
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
			case TestsuiteexportPackage.TC__DEFINE:
				getDefine().clear();
				return;
			case TestsuiteexportPackage.TC__ASSIGN:
				getAssign().clear();
				return;
			case TestsuiteexportPackage.TC__ACTION:
				getAction().clear();
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
			case TestsuiteexportPackage.TC__DEFINE:
				return define != null && !define.isEmpty();
			case TestsuiteexportPackage.TC__ASSIGN:
				return assign != null && !assign.isEmpty();
			case TestsuiteexportPackage.TC__ACTION:
				return action != null && !action.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TCImpl
