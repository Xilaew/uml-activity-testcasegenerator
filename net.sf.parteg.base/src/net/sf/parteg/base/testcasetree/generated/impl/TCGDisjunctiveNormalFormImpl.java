/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.sf.parteg.base.testcasetree.generated.impl;

import java.util.Collection;

import net.sf.parteg.base.testcasetree.generated.GeneratedPackage;
import net.sf.parteg.base.testcasetree.generated.TCGConjunction;
import net.sf.parteg.base.testcasetree.generated.TCGDisjunctiveNormalForm;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TCG Disjunctive Normal Form</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.sf.parteg.base.testcasetree.generated.impl.TCGDisjunctiveNormalFormImpl#getConjunctions <em>Conjunctions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TCGDisjunctiveNormalFormImpl extends EObjectImpl implements TCGDisjunctiveNormalForm {
	/**
	 * The cached value of the '{@link #getConjunctions() <em>Conjunctions</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConjunctions()
	 * @generated
	 * @ordered
	 */
	protected EList<TCGConjunction> conjunctions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TCGDisjunctiveNormalFormImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeneratedPackage.Literals.TCG_DISJUNCTIVE_NORMAL_FORM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TCGConjunction> getConjunctions() {
		if (conjunctions == null) {
			conjunctions = new EObjectResolvingEList<TCGConjunction>(TCGConjunction.class, this, GeneratedPackage.TCG_DISJUNCTIVE_NORMAL_FORM__CONJUNCTIONS);
		}
		return conjunctions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GeneratedPackage.TCG_DISJUNCTIVE_NORMAL_FORM__CONJUNCTIONS:
				return getConjunctions();
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
			case GeneratedPackage.TCG_DISJUNCTIVE_NORMAL_FORM__CONJUNCTIONS:
				getConjunctions().clear();
				getConjunctions().addAll((Collection<? extends TCGConjunction>)newValue);
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
			case GeneratedPackage.TCG_DISJUNCTIVE_NORMAL_FORM__CONJUNCTIONS:
				getConjunctions().clear();
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
			case GeneratedPackage.TCG_DISJUNCTIVE_NORMAL_FORM__CONJUNCTIONS:
				return conjunctions != null && !conjunctions.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TCGDisjunctiveNormalFormImpl
