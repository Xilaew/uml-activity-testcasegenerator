/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.sf.parteg.base.testcasetree.generated.impl;

import net.sf.parteg.base.testcasetree.generated.GeneratedPackage;
import net.sf.parteg.base.testcasetree.generated.TCGComplexParameter;
import net.sf.parteg.base.testcasetree.generated.TCGEquivalenceClass;
import net.sf.parteg.base.testcasetree.generated.TCGPrimitiveParameter;
import net.sf.parteg.base.testcasetree.generated.TCGTransition;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TCG Primitive Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.sf.parteg.base.testcasetree.generated.impl.TCGPrimitiveParameterImpl#getName <em>Name</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasetree.generated.impl.TCGPrimitiveParameterImpl#getType <em>Type</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasetree.generated.impl.TCGPrimitiveParameterImpl#getReference <em>Reference</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasetree.generated.impl.TCGPrimitiveParameterImpl#getDefiningTransition <em>Defining Transition</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasetree.generated.impl.TCGPrimitiveParameterImpl#getContainer <em>Container</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasetree.generated.impl.TCGPrimitiveParameterImpl#getEquivalenceClass <em>Equivalence Class</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TCGPrimitiveParameterImpl extends EObjectImpl implements TCGPrimitiveParameter {
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
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected EObject type;

	/**
	 * The cached value of the '{@link #getReference() <em>Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReference()
	 * @generated
	 * @ordered
	 */
	protected EObject reference;

	/**
	 * The cached value of the '{@link #getDefiningTransition() <em>Defining Transition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefiningTransition()
	 * @generated
	 * @ordered
	 */
	protected TCGTransition definingTransition;

	/**
	 * The cached value of the '{@link #getContainer() <em>Container</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContainer()
	 * @generated
	 * @ordered
	 */
	protected TCGComplexParameter container;

	/**
	 * The cached value of the '{@link #getEquivalenceClass() <em>Equivalence Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEquivalenceClass()
	 * @generated
	 * @ordered
	 */
	protected TCGEquivalenceClass equivalenceClass;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TCGPrimitiveParameterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeneratedPackage.Literals.TCG_PRIMITIVE_PARAMETER;
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
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedPackage.TCG_PRIMITIVE_PARAMETER__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getType() {
		if (type != null && type.eIsProxy()) {
			InternalEObject oldType = (InternalEObject)type;
			type = eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GeneratedPackage.TCG_PRIMITIVE_PARAMETER__TYPE, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(EObject newType) {
		EObject oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedPackage.TCG_PRIMITIVE_PARAMETER__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getReference() {
		if (reference != null && reference.eIsProxy()) {
			InternalEObject oldReference = (InternalEObject)reference;
			reference = eResolveProxy(oldReference);
			if (reference != oldReference) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GeneratedPackage.TCG_PRIMITIVE_PARAMETER__REFERENCE, oldReference, reference));
			}
		}
		return reference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetReference() {
		return reference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReference(EObject newReference) {
		EObject oldReference = reference;
		reference = newReference;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedPackage.TCG_PRIMITIVE_PARAMETER__REFERENCE, oldReference, reference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TCGTransition getDefiningTransition() {
		if (definingTransition != null && definingTransition.eIsProxy()) {
			InternalEObject oldDefiningTransition = (InternalEObject)definingTransition;
			definingTransition = (TCGTransition)eResolveProxy(oldDefiningTransition);
			if (definingTransition != oldDefiningTransition) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GeneratedPackage.TCG_PRIMITIVE_PARAMETER__DEFINING_TRANSITION, oldDefiningTransition, definingTransition));
			}
		}
		return definingTransition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TCGTransition basicGetDefiningTransition() {
		return definingTransition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefiningTransition(TCGTransition newDefiningTransition) {
		TCGTransition oldDefiningTransition = definingTransition;
		definingTransition = newDefiningTransition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedPackage.TCG_PRIMITIVE_PARAMETER__DEFINING_TRANSITION, oldDefiningTransition, definingTransition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TCGComplexParameter getContainer() {
		if (container != null && container.eIsProxy()) {
			InternalEObject oldContainer = (InternalEObject)container;
			container = (TCGComplexParameter)eResolveProxy(oldContainer);
			if (container != oldContainer) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GeneratedPackage.TCG_PRIMITIVE_PARAMETER__CONTAINER, oldContainer, container));
			}
		}
		return container;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TCGComplexParameter basicGetContainer() {
		return container;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContainer(TCGComplexParameter newContainer, NotificationChain msgs) {
		TCGComplexParameter oldContainer = container;
		container = newContainer;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GeneratedPackage.TCG_PRIMITIVE_PARAMETER__CONTAINER, oldContainer, newContainer);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainer(TCGComplexParameter newContainer) {
		if (newContainer != container) {
			NotificationChain msgs = null;
			if (container != null)
				msgs = ((InternalEObject)container).eInverseRemove(this, GeneratedPackage.TCG_COMPLEX_PARAMETER__PARAMETER, TCGComplexParameter.class, msgs);
			if (newContainer != null)
				msgs = ((InternalEObject)newContainer).eInverseAdd(this, GeneratedPackage.TCG_COMPLEX_PARAMETER__PARAMETER, TCGComplexParameter.class, msgs);
			msgs = basicSetContainer(newContainer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedPackage.TCG_PRIMITIVE_PARAMETER__CONTAINER, newContainer, newContainer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TCGEquivalenceClass getEquivalenceClass() {
		if (equivalenceClass != null && equivalenceClass.eIsProxy()) {
			InternalEObject oldEquivalenceClass = (InternalEObject)equivalenceClass;
			equivalenceClass = (TCGEquivalenceClass)eResolveProxy(oldEquivalenceClass);
			if (equivalenceClass != oldEquivalenceClass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GeneratedPackage.TCG_PRIMITIVE_PARAMETER__EQUIVALENCE_CLASS, oldEquivalenceClass, equivalenceClass));
			}
		}
		return equivalenceClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TCGEquivalenceClass basicGetEquivalenceClass() {
		return equivalenceClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEquivalenceClass(TCGEquivalenceClass newEquivalenceClass) {
		TCGEquivalenceClass oldEquivalenceClass = equivalenceClass;
		equivalenceClass = newEquivalenceClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedPackage.TCG_PRIMITIVE_PARAMETER__EQUIVALENCE_CLASS, oldEquivalenceClass, equivalenceClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GeneratedPackage.TCG_PRIMITIVE_PARAMETER__CONTAINER:
				if (container != null)
					msgs = ((InternalEObject)container).eInverseRemove(this, GeneratedPackage.TCG_COMPLEX_PARAMETER__PARAMETER, TCGComplexParameter.class, msgs);
				return basicSetContainer((TCGComplexParameter)otherEnd, msgs);
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
			case GeneratedPackage.TCG_PRIMITIVE_PARAMETER__CONTAINER:
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
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GeneratedPackage.TCG_PRIMITIVE_PARAMETER__NAME:
				return getName();
			case GeneratedPackage.TCG_PRIMITIVE_PARAMETER__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case GeneratedPackage.TCG_PRIMITIVE_PARAMETER__REFERENCE:
				if (resolve) return getReference();
				return basicGetReference();
			case GeneratedPackage.TCG_PRIMITIVE_PARAMETER__DEFINING_TRANSITION:
				if (resolve) return getDefiningTransition();
				return basicGetDefiningTransition();
			case GeneratedPackage.TCG_PRIMITIVE_PARAMETER__CONTAINER:
				if (resolve) return getContainer();
				return basicGetContainer();
			case GeneratedPackage.TCG_PRIMITIVE_PARAMETER__EQUIVALENCE_CLASS:
				if (resolve) return getEquivalenceClass();
				return basicGetEquivalenceClass();
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
			case GeneratedPackage.TCG_PRIMITIVE_PARAMETER__NAME:
				setName((String)newValue);
				return;
			case GeneratedPackage.TCG_PRIMITIVE_PARAMETER__TYPE:
				setType((EObject)newValue);
				return;
			case GeneratedPackage.TCG_PRIMITIVE_PARAMETER__REFERENCE:
				setReference((EObject)newValue);
				return;
			case GeneratedPackage.TCG_PRIMITIVE_PARAMETER__DEFINING_TRANSITION:
				setDefiningTransition((TCGTransition)newValue);
				return;
			case GeneratedPackage.TCG_PRIMITIVE_PARAMETER__CONTAINER:
				setContainer((TCGComplexParameter)newValue);
				return;
			case GeneratedPackage.TCG_PRIMITIVE_PARAMETER__EQUIVALENCE_CLASS:
				setEquivalenceClass((TCGEquivalenceClass)newValue);
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
			case GeneratedPackage.TCG_PRIMITIVE_PARAMETER__NAME:
				setName(NAME_EDEFAULT);
				return;
			case GeneratedPackage.TCG_PRIMITIVE_PARAMETER__TYPE:
				setType((EObject)null);
				return;
			case GeneratedPackage.TCG_PRIMITIVE_PARAMETER__REFERENCE:
				setReference((EObject)null);
				return;
			case GeneratedPackage.TCG_PRIMITIVE_PARAMETER__DEFINING_TRANSITION:
				setDefiningTransition((TCGTransition)null);
				return;
			case GeneratedPackage.TCG_PRIMITIVE_PARAMETER__CONTAINER:
				setContainer((TCGComplexParameter)null);
				return;
			case GeneratedPackage.TCG_PRIMITIVE_PARAMETER__EQUIVALENCE_CLASS:
				setEquivalenceClass((TCGEquivalenceClass)null);
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
			case GeneratedPackage.TCG_PRIMITIVE_PARAMETER__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case GeneratedPackage.TCG_PRIMITIVE_PARAMETER__TYPE:
				return type != null;
			case GeneratedPackage.TCG_PRIMITIVE_PARAMETER__REFERENCE:
				return reference != null;
			case GeneratedPackage.TCG_PRIMITIVE_PARAMETER__DEFINING_TRANSITION:
				return definingTransition != null;
			case GeneratedPackage.TCG_PRIMITIVE_PARAMETER__CONTAINER:
				return container != null;
			case GeneratedPackage.TCG_PRIMITIVE_PARAMETER__EQUIVALENCE_CLASS:
				return equivalenceClass != null;
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
		result.append(')');
		return result.toString();
	}

} //TCGPrimitiveParameterImpl
