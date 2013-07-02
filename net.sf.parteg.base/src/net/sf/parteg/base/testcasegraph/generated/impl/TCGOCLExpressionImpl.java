/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.sf.parteg.base.testcasegraph.generated.impl;

import net.sf.parteg.base.testcasegraph.generated.GeneratedPackage;
import net.sf.parteg.base.testcasegraph.generated.TCGElement;
import net.sf.parteg.base.testcasegraph.generated.TCGOCLExpression;
import net.sf.parteg.base.testcasegraph.generated.TCGTransition;
import net.sf.parteg.base.testcasegraph.generated.VariableClassification;

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
 *   <li>{@link net.sf.parteg.base.testcasegraph.generated.impl.TCGOCLExpressionImpl#getClassification <em>Classification</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasegraph.generated.impl.TCGOCLExpressionImpl#getOclReference <em>Ocl Reference</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasegraph.generated.impl.TCGOCLExpressionImpl#getContainer <em>Container</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasegraph.generated.impl.TCGOCLExpressionImpl#isPositiveAssignmentOfOriginal <em>Positive Assignment Of Original</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasegraph.generated.impl.TCGOCLExpressionImpl#getTransitionContext <em>Transition Context</em>}</li>
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
	 * The cached value of the '{@link #getContainer() <em>Container</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContainer()
	 * @generated
	 * @ordered
	 */
	protected TCGElement container;

	/**
	 * The default value of the '{@link #isPositiveAssignmentOfOriginal() <em>Positive Assignment Of Original</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPositiveAssignmentOfOriginal()
	 * @generated
	 * @ordered
	 */
	protected static final boolean POSITIVE_ASSIGNMENT_OF_ORIGINAL_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isPositiveAssignmentOfOriginal() <em>Positive Assignment Of Original</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPositiveAssignmentOfOriginal()
	 * @generated
	 * @ordered
	 */
	protected boolean positiveAssignmentOfOriginal = POSITIVE_ASSIGNMENT_OF_ORIGINAL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTransitionContext() <em>Transition Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransitionContext()
	 * @generated
	 * @ordered
	 */
	protected TCGTransition transitionContext;

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
	public TCGElement getContainer() {
		if (container != null && container.eIsProxy()) {
			InternalEObject oldContainer = (InternalEObject)container;
			container = (TCGElement)eResolveProxy(oldContainer);
			if (container != oldContainer) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GeneratedPackage.TCGOCL_EXPRESSION__CONTAINER, oldContainer, container));
			}
		}
		return container;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TCGElement basicGetContainer() {
		return container;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainer(TCGElement newContainer) {
		TCGElement oldContainer = container;
		container = newContainer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedPackage.TCGOCL_EXPRESSION__CONTAINER, oldContainer, container));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isPositiveAssignmentOfOriginal() {
		return positiveAssignmentOfOriginal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPositiveAssignmentOfOriginal(boolean newPositiveAssignmentOfOriginal) {
		boolean oldPositiveAssignmentOfOriginal = positiveAssignmentOfOriginal;
		positiveAssignmentOfOriginal = newPositiveAssignmentOfOriginal;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedPackage.TCGOCL_EXPRESSION__POSITIVE_ASSIGNMENT_OF_ORIGINAL, oldPositiveAssignmentOfOriginal, positiveAssignmentOfOriginal));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TCGTransition getTransitionContext() {
		if (transitionContext != null && transitionContext.eIsProxy()) {
			InternalEObject oldTransitionContext = (InternalEObject)transitionContext;
			transitionContext = (TCGTransition)eResolveProxy(oldTransitionContext);
			if (transitionContext != oldTransitionContext) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GeneratedPackage.TCGOCL_EXPRESSION__TRANSITION_CONTEXT, oldTransitionContext, transitionContext));
			}
		}
		return transitionContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TCGTransition basicGetTransitionContext() {
		return transitionContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransitionContext(TCGTransition newTransitionContext) {
		TCGTransition oldTransitionContext = transitionContext;
		transitionContext = newTransitionContext;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedPackage.TCGOCL_EXPRESSION__TRANSITION_CONTEXT, oldTransitionContext, transitionContext));
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
			case GeneratedPackage.TCGOCL_EXPRESSION__CONTAINER:
				if (resolve) return getContainer();
				return basicGetContainer();
			case GeneratedPackage.TCGOCL_EXPRESSION__POSITIVE_ASSIGNMENT_OF_ORIGINAL:
				return isPositiveAssignmentOfOriginal() ? Boolean.TRUE : Boolean.FALSE;
			case GeneratedPackage.TCGOCL_EXPRESSION__TRANSITION_CONTEXT:
				if (resolve) return getTransitionContext();
				return basicGetTransitionContext();
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
			case GeneratedPackage.TCGOCL_EXPRESSION__CONTAINER:
				setContainer((TCGElement)newValue);
				return;
			case GeneratedPackage.TCGOCL_EXPRESSION__POSITIVE_ASSIGNMENT_OF_ORIGINAL:
				setPositiveAssignmentOfOriginal(((Boolean)newValue).booleanValue());
				return;
			case GeneratedPackage.TCGOCL_EXPRESSION__TRANSITION_CONTEXT:
				setTransitionContext((TCGTransition)newValue);
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
			case GeneratedPackage.TCGOCL_EXPRESSION__CONTAINER:
				setContainer((TCGElement)null);
				return;
			case GeneratedPackage.TCGOCL_EXPRESSION__POSITIVE_ASSIGNMENT_OF_ORIGINAL:
				setPositiveAssignmentOfOriginal(POSITIVE_ASSIGNMENT_OF_ORIGINAL_EDEFAULT);
				return;
			case GeneratedPackage.TCGOCL_EXPRESSION__TRANSITION_CONTEXT:
				setTransitionContext((TCGTransition)null);
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
			case GeneratedPackage.TCGOCL_EXPRESSION__CONTAINER:
				return container != null;
			case GeneratedPackage.TCGOCL_EXPRESSION__POSITIVE_ASSIGNMENT_OF_ORIGINAL:
				return positiveAssignmentOfOriginal != POSITIVE_ASSIGNMENT_OF_ORIGINAL_EDEFAULT;
			case GeneratedPackage.TCGOCL_EXPRESSION__TRANSITION_CONTEXT:
				return transitionContext != null;
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
		result.append(", positiveAssignmentOfOriginal: ");
		result.append(positiveAssignmentOfOriginal);
		result.append(')');
		return result.toString();
	}

} //TCGOCLExpressionImpl
