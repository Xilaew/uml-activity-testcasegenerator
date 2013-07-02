/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.sf.parteg.base.testcasetree.generated.impl;

import net.sf.parteg.base.testcasetree.generated.GeneratedPackage;
import net.sf.parteg.base.testcasetree.generated.TCGOCLExpression;
import net.sf.parteg.base.testcasetree.generated.VariableClassification;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TCGOCL Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.sf.parteg.base.testcasetree.generated.impl.TCGOCLExpressionImpl#getClassification <em>Classification</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasetree.generated.impl.TCGOCLExpressionImpl#getOclReference <em>Ocl Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TCGOCLExpressionImpl extends EObjectImpl implements TCGOCLExpression {
	/**
	 * The default value of the '{@link #getClassification() <em>Classification</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassification()
	 * @generated
	 * @ordered
	 */
	protected static final VariableClassification CLASSIFICATION_EDEFAULT = VariableClassification.ACTIVE_DEPENDENT;

	/**
	 * The cached value of the '{@link #getClassification() <em>Classification</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassification()
	 * @generated
	 * @ordered
	 */
	protected VariableClassification classification = CLASSIFICATION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOclReference() <em>Ocl Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOclReference()
	 * @generated
	 * @ordered
	 */
	protected EObject oclReference;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TCGOCLExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeneratedPackage.Literals.TCGOCL_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableClassification getClassification() {
		return classification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClassification(VariableClassification newClassification) {
		VariableClassification oldClassification = classification;
		classification = newClassification == null ? CLASSIFICATION_EDEFAULT : newClassification;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedPackage.TCGOCL_EXPRESSION__CLASSIFICATION, oldClassification, classification));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getOclReference() {
		if (oclReference != null && oclReference.eIsProxy()) {
			InternalEObject oldOclReference = (InternalEObject)oclReference;
			oclReference = eResolveProxy(oldOclReference);
			if (oclReference != oldOclReference) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GeneratedPackage.TCGOCL_EXPRESSION__OCL_REFERENCE, oldOclReference, oclReference));
			}
		}
		return oclReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetOclReference() {
		return oclReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOclReference(EObject newOclReference) {
		EObject oldOclReference = oclReference;
		oclReference = newOclReference;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedPackage.TCGOCL_EXPRESSION__OCL_REFERENCE, oldOclReference, oclReference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GeneratedPackage.TCGOCL_EXPRESSION__CLASSIFICATION:
				return getClassification();
			case GeneratedPackage.TCGOCL_EXPRESSION__OCL_REFERENCE:
				if (resolve) return getOclReference();
				return basicGetOclReference();
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
			case GeneratedPackage.TCGOCL_EXPRESSION__CLASSIFICATION:
				setClassification((VariableClassification)newValue);
				return;
			case GeneratedPackage.TCGOCL_EXPRESSION__OCL_REFERENCE:
				setOclReference((EObject)newValue);
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
			case GeneratedPackage.TCGOCL_EXPRESSION__CLASSIFICATION:
				setClassification(CLASSIFICATION_EDEFAULT);
				return;
			case GeneratedPackage.TCGOCL_EXPRESSION__OCL_REFERENCE:
				setOclReference((EObject)null);
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
			case GeneratedPackage.TCGOCL_EXPRESSION__CLASSIFICATION:
				return classification != CLASSIFICATION_EDEFAULT;
			case GeneratedPackage.TCGOCL_EXPRESSION__OCL_REFERENCE:
				return oclReference != null;
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
		result.append(" (classification: ");
		result.append(classification);
		result.append(')');
		return result.toString();
	}

} //TCGOCLExpressionImpl
