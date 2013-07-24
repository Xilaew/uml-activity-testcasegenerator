/**
 */
package org.xilaew.atg.model.activityTestCaseGraph.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.xilaew.atg.model.activityTestCaseGraph.ActivityTestCaseGraphPackage;
import org.xilaew.atg.model.activityTestCaseGraph.TCGObjectVariable;
import org.xilaew.atg.model.activityTestCaseGraph.TCGVariable;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TCG Object Variable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.xilaew.atg.model.activityTestCaseGraph.impl.TCGObjectVariableImpl#getFields <em>Fields</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TCGObjectVariableImpl extends TCGVariableImpl implements TCGObjectVariable {
	/**
	 * The cached value of the '{@link #getFields() <em>Fields</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFields()
	 * @generated
	 * @ordered
	 */
	protected EList<TCGVariable> fields;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TCGObjectVariableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ActivityTestCaseGraphPackage.Literals.TCG_OBJECT_VARIABLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TCGVariable> getFields() {
		if (fields == null) {
			fields = new EObjectResolvingEList<TCGVariable>(TCGVariable.class, this, ActivityTestCaseGraphPackage.TCG_OBJECT_VARIABLE__FIELDS);
		}
		return fields;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ActivityTestCaseGraphPackage.TCG_OBJECT_VARIABLE__FIELDS:
				return getFields();
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
			case ActivityTestCaseGraphPackage.TCG_OBJECT_VARIABLE__FIELDS:
				getFields().clear();
				getFields().addAll((Collection<? extends TCGVariable>)newValue);
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
			case ActivityTestCaseGraphPackage.TCG_OBJECT_VARIABLE__FIELDS:
				getFields().clear();
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
			case ActivityTestCaseGraphPackage.TCG_OBJECT_VARIABLE__FIELDS:
				return fields != null && !fields.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TCGObjectVariableImpl
