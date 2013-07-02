/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.sf.parteg.base.testcasegraph.generated.impl;

import java.util.Collection;

import net.sf.parteg.base.testcasegraph.generated.GeneratedPackage;
import net.sf.parteg.base.testcasegraph.generated.TCGConjunction;
import net.sf.parteg.base.testcasegraph.generated.TCGDisjunctiveNormalForm;

import net.sf.parteg.base.testcasegraph.generated.TCGOCLExpression;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TCG Disjunctive Normal Form</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.sf.parteg.base.testcasegraph.generated.impl.TCGDisjunctiveNormalFormImpl#getConjunctions <em>Conjunctions</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasegraph.generated.impl.TCGDisjunctiveNormalFormImpl#getOriginalExpression <em>Original Expression</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasegraph.generated.impl.TCGDisjunctiveNormalFormImpl#isUseForTestGoals <em>Use For Test Goals</em>}</li>
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
	 * The cached value of the '{@link #getOriginalExpression() <em>Original Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOriginalExpression()
	 * @generated
	 * @ordered
	 */
	protected TCGOCLExpression originalExpression;

	/**
	 * The default value of the '{@link #isUseForTestGoals() <em>Use For Test Goals</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUseForTestGoals()
	 * @generated
	 * @ordered
	 */
	protected static final boolean USE_FOR_TEST_GOALS_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isUseForTestGoals() <em>Use For Test Goals</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUseForTestGoals()
	 * @generated
	 * @ordered
	 */
	protected boolean useForTestGoals = USE_FOR_TEST_GOALS_EDEFAULT;

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
	public TCGOCLExpression getOriginalExpression() {
		if (originalExpression != null && originalExpression.eIsProxy()) {
			InternalEObject oldOriginalExpression = (InternalEObject)originalExpression;
			originalExpression = (TCGOCLExpression)eResolveProxy(oldOriginalExpression);
			if (originalExpression != oldOriginalExpression) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GeneratedPackage.TCG_DISJUNCTIVE_NORMAL_FORM__ORIGINAL_EXPRESSION, oldOriginalExpression, originalExpression));
			}
		}
		return originalExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TCGOCLExpression basicGetOriginalExpression() {
		return originalExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOriginalExpression(TCGOCLExpression newOriginalExpression) {
		TCGOCLExpression oldOriginalExpression = originalExpression;
		originalExpression = newOriginalExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedPackage.TCG_DISJUNCTIVE_NORMAL_FORM__ORIGINAL_EXPRESSION, oldOriginalExpression, originalExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isUseForTestGoals() {
		return useForTestGoals;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUseForTestGoals(boolean newUseForTestGoals) {
		boolean oldUseForTestGoals = useForTestGoals;
		useForTestGoals = newUseForTestGoals;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedPackage.TCG_DISJUNCTIVE_NORMAL_FORM__USE_FOR_TEST_GOALS, oldUseForTestGoals, useForTestGoals));
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
			case GeneratedPackage.TCG_DISJUNCTIVE_NORMAL_FORM__ORIGINAL_EXPRESSION:
				if (resolve) return getOriginalExpression();
				return basicGetOriginalExpression();
			case GeneratedPackage.TCG_DISJUNCTIVE_NORMAL_FORM__USE_FOR_TEST_GOALS:
				return isUseForTestGoals() ? Boolean.TRUE : Boolean.FALSE;
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
			case GeneratedPackage.TCG_DISJUNCTIVE_NORMAL_FORM__ORIGINAL_EXPRESSION:
				setOriginalExpression((TCGOCLExpression)newValue);
				return;
			case GeneratedPackage.TCG_DISJUNCTIVE_NORMAL_FORM__USE_FOR_TEST_GOALS:
				setUseForTestGoals(((Boolean)newValue).booleanValue());
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
			case GeneratedPackage.TCG_DISJUNCTIVE_NORMAL_FORM__ORIGINAL_EXPRESSION:
				setOriginalExpression((TCGOCLExpression)null);
				return;
			case GeneratedPackage.TCG_DISJUNCTIVE_NORMAL_FORM__USE_FOR_TEST_GOALS:
				setUseForTestGoals(USE_FOR_TEST_GOALS_EDEFAULT);
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
			case GeneratedPackage.TCG_DISJUNCTIVE_NORMAL_FORM__ORIGINAL_EXPRESSION:
				return originalExpression != null;
			case GeneratedPackage.TCG_DISJUNCTIVE_NORMAL_FORM__USE_FOR_TEST_GOALS:
				return useForTestGoals != USE_FOR_TEST_GOALS_EDEFAULT;
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
		result.append(" (useForTestGoals: ");
		result.append(useForTestGoals);
		result.append(')');
		return result.toString();
	}

} //TCGDisjunctiveNormalFormImpl
