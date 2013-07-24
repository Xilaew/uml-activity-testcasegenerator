/**
 */
package org.xilaew.atg.model.activityTestCaseGraph.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.xilaew.atg.model.activityTestCaseGraph.ActivityTestCaseGraphPackage;
import org.xilaew.atg.model.activityTestCaseGraph.TCGOCLExpression;
import org.xilaew.atg.model.activityTestCaseGraph.TCGOCLOperationCallExp;
import org.xilaew.atg.model.activityTestCaseGraph.TCGOCLOperationType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TCGOCL Operation Call Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.xilaew.atg.model.activityTestCaseGraph.impl.TCGOCLOperationCallExpImpl#getSource <em>Source</em>}</li>
 *   <li>{@link org.xilaew.atg.model.activityTestCaseGraph.impl.TCGOCLOperationCallExpImpl#getArguments <em>Arguments</em>}</li>
 *   <li>{@link org.xilaew.atg.model.activityTestCaseGraph.impl.TCGOCLOperationCallExpImpl#getOperation <em>Operation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TCGOCLOperationCallExpImpl extends TCGOCLExpressionImpl implements TCGOCLOperationCallExp {
	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected TCGOCLExpression source;

	/**
	 * The cached value of the '{@link #getArguments() <em>Arguments</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArguments()
	 * @generated
	 * @ordered
	 */
	protected EList<TCGOCLExpression> arguments;

	/**
	 * The default value of the '{@link #getOperation() <em>Operation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperation()
	 * @generated
	 * @ordered
	 */
	protected static final TCGOCLOperationType OPERATION_EDEFAULT = TCGOCLOperationType.MULTIPLICATION;

	/**
	 * The cached value of the '{@link #getOperation() <em>Operation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperation()
	 * @generated
	 * @ordered
	 */
	protected TCGOCLOperationType operation = OPERATION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TCGOCLOperationCallExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ActivityTestCaseGraphPackage.Literals.TCGOCL_OPERATION_CALL_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TCGOCLExpression getSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSource(TCGOCLExpression newSource, NotificationChain msgs) {
		TCGOCLExpression oldSource = source;
		source = newSource;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ActivityTestCaseGraphPackage.TCGOCL_OPERATION_CALL_EXP__SOURCE, oldSource, newSource);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(TCGOCLExpression newSource) {
		if (newSource != source) {
			NotificationChain msgs = null;
			if (source != null)
				msgs = ((InternalEObject)source).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ActivityTestCaseGraphPackage.TCGOCL_OPERATION_CALL_EXP__SOURCE, null, msgs);
			if (newSource != null)
				msgs = ((InternalEObject)newSource).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ActivityTestCaseGraphPackage.TCGOCL_OPERATION_CALL_EXP__SOURCE, null, msgs);
			msgs = basicSetSource(newSource, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActivityTestCaseGraphPackage.TCGOCL_OPERATION_CALL_EXP__SOURCE, newSource, newSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TCGOCLExpression> getArguments() {
		if (arguments == null) {
			arguments = new EObjectContainmentEList<TCGOCLExpression>(TCGOCLExpression.class, this, ActivityTestCaseGraphPackage.TCGOCL_OPERATION_CALL_EXP__ARGUMENTS);
		}
		return arguments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TCGOCLOperationType getOperation() {
		return operation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOperation(TCGOCLOperationType newOperation) {
		TCGOCLOperationType oldOperation = operation;
		operation = newOperation == null ? OPERATION_EDEFAULT : newOperation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActivityTestCaseGraphPackage.TCGOCL_OPERATION_CALL_EXP__OPERATION, oldOperation, operation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ActivityTestCaseGraphPackage.TCGOCL_OPERATION_CALL_EXP__SOURCE:
				return basicSetSource(null, msgs);
			case ActivityTestCaseGraphPackage.TCGOCL_OPERATION_CALL_EXP__ARGUMENTS:
				return ((InternalEList<?>)getArguments()).basicRemove(otherEnd, msgs);
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
			case ActivityTestCaseGraphPackage.TCGOCL_OPERATION_CALL_EXP__SOURCE:
				return getSource();
			case ActivityTestCaseGraphPackage.TCGOCL_OPERATION_CALL_EXP__ARGUMENTS:
				return getArguments();
			case ActivityTestCaseGraphPackage.TCGOCL_OPERATION_CALL_EXP__OPERATION:
				return getOperation();
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
			case ActivityTestCaseGraphPackage.TCGOCL_OPERATION_CALL_EXP__SOURCE:
				setSource((TCGOCLExpression)newValue);
				return;
			case ActivityTestCaseGraphPackage.TCGOCL_OPERATION_CALL_EXP__ARGUMENTS:
				getArguments().clear();
				getArguments().addAll((Collection<? extends TCGOCLExpression>)newValue);
				return;
			case ActivityTestCaseGraphPackage.TCGOCL_OPERATION_CALL_EXP__OPERATION:
				setOperation((TCGOCLOperationType)newValue);
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
			case ActivityTestCaseGraphPackage.TCGOCL_OPERATION_CALL_EXP__SOURCE:
				setSource((TCGOCLExpression)null);
				return;
			case ActivityTestCaseGraphPackage.TCGOCL_OPERATION_CALL_EXP__ARGUMENTS:
				getArguments().clear();
				return;
			case ActivityTestCaseGraphPackage.TCGOCL_OPERATION_CALL_EXP__OPERATION:
				setOperation(OPERATION_EDEFAULT);
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
			case ActivityTestCaseGraphPackage.TCGOCL_OPERATION_CALL_EXP__SOURCE:
				return source != null;
			case ActivityTestCaseGraphPackage.TCGOCL_OPERATION_CALL_EXP__ARGUMENTS:
				return arguments != null && !arguments.isEmpty();
			case ActivityTestCaseGraphPackage.TCGOCL_OPERATION_CALL_EXP__OPERATION:
				return operation != OPERATION_EDEFAULT;
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
		result.append(" (operation: ");
		result.append(operation);
		result.append(')');
		return result.toString();
	}

} //TCGOCLOperationCallExpImpl
