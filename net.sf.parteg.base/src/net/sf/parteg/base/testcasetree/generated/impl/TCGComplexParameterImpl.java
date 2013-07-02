/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.sf.parteg.base.testcasetree.generated.impl;

import java.util.Collection;

import net.sf.parteg.base.testcasetree.generated.GeneratedPackage;
import net.sf.parteg.base.testcasetree.generated.TCGComplexParameter;
import net.sf.parteg.base.testcasetree.generated.TCGParameter;
import net.sf.parteg.base.testcasetree.generated.TCGTransition;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TCG Complex Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.sf.parteg.base.testcasetree.generated.impl.TCGComplexParameterImpl#getName <em>Name</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasetree.generated.impl.TCGComplexParameterImpl#getType <em>Type</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasetree.generated.impl.TCGComplexParameterImpl#getReference <em>Reference</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasetree.generated.impl.TCGComplexParameterImpl#getDefiningTransition <em>Defining Transition</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasetree.generated.impl.TCGComplexParameterImpl#getContainer <em>Container</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasetree.generated.impl.TCGComplexParameterImpl#getParameter <em>Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TCGComplexParameterImpl extends EObjectImpl implements TCGComplexParameter {
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
	 * The cached value of the '{@link #getParameter() <em>Parameter</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameter()
	 * @generated
	 * @ordered
	 */
	protected EList<TCGParameter> parameter;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TCGComplexParameterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeneratedPackage.Literals.TCG_COMPLEX_PARAMETER;
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
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedPackage.TCG_COMPLEX_PARAMETER__NAME, oldName, name));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GeneratedPackage.TCG_COMPLEX_PARAMETER__TYPE, oldType, type));
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
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedPackage.TCG_COMPLEX_PARAMETER__TYPE, oldType, type));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GeneratedPackage.TCG_COMPLEX_PARAMETER__REFERENCE, oldReference, reference));
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
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedPackage.TCG_COMPLEX_PARAMETER__REFERENCE, oldReference, reference));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GeneratedPackage.TCG_COMPLEX_PARAMETER__DEFINING_TRANSITION, oldDefiningTransition, definingTransition));
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
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedPackage.TCG_COMPLEX_PARAMETER__DEFINING_TRANSITION, oldDefiningTransition, definingTransition));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GeneratedPackage.TCG_COMPLEX_PARAMETER__CONTAINER, oldContainer, container));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GeneratedPackage.TCG_COMPLEX_PARAMETER__CONTAINER, oldContainer, newContainer);
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
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedPackage.TCG_COMPLEX_PARAMETER__CONTAINER, newContainer, newContainer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TCGParameter> getParameter() {
		if (parameter == null) {
			parameter = new EObjectWithInverseResolvingEList<TCGParameter>(TCGParameter.class, this, GeneratedPackage.TCG_COMPLEX_PARAMETER__PARAMETER, GeneratedPackage.TCG_PARAMETER__CONTAINER);
		}
		return parameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GeneratedPackage.TCG_COMPLEX_PARAMETER__CONTAINER:
				if (container != null)
					msgs = ((InternalEObject)container).eInverseRemove(this, GeneratedPackage.TCG_COMPLEX_PARAMETER__PARAMETER, TCGComplexParameter.class, msgs);
				return basicSetContainer((TCGComplexParameter)otherEnd, msgs);
			case GeneratedPackage.TCG_COMPLEX_PARAMETER__PARAMETER:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getParameter()).basicAdd(otherEnd, msgs);
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
			case GeneratedPackage.TCG_COMPLEX_PARAMETER__CONTAINER:
				return basicSetContainer(null, msgs);
			case GeneratedPackage.TCG_COMPLEX_PARAMETER__PARAMETER:
				return ((InternalEList<?>)getParameter()).basicRemove(otherEnd, msgs);
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
			case GeneratedPackage.TCG_COMPLEX_PARAMETER__NAME:
				return getName();
			case GeneratedPackage.TCG_COMPLEX_PARAMETER__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case GeneratedPackage.TCG_COMPLEX_PARAMETER__REFERENCE:
				if (resolve) return getReference();
				return basicGetReference();
			case GeneratedPackage.TCG_COMPLEX_PARAMETER__DEFINING_TRANSITION:
				if (resolve) return getDefiningTransition();
				return basicGetDefiningTransition();
			case GeneratedPackage.TCG_COMPLEX_PARAMETER__CONTAINER:
				if (resolve) return getContainer();
				return basicGetContainer();
			case GeneratedPackage.TCG_COMPLEX_PARAMETER__PARAMETER:
				return getParameter();
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
			case GeneratedPackage.TCG_COMPLEX_PARAMETER__NAME:
				setName((String)newValue);
				return;
			case GeneratedPackage.TCG_COMPLEX_PARAMETER__TYPE:
				setType((EObject)newValue);
				return;
			case GeneratedPackage.TCG_COMPLEX_PARAMETER__REFERENCE:
				setReference((EObject)newValue);
				return;
			case GeneratedPackage.TCG_COMPLEX_PARAMETER__DEFINING_TRANSITION:
				setDefiningTransition((TCGTransition)newValue);
				return;
			case GeneratedPackage.TCG_COMPLEX_PARAMETER__CONTAINER:
				setContainer((TCGComplexParameter)newValue);
				return;
			case GeneratedPackage.TCG_COMPLEX_PARAMETER__PARAMETER:
				getParameter().clear();
				getParameter().addAll((Collection<? extends TCGParameter>)newValue);
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
			case GeneratedPackage.TCG_COMPLEX_PARAMETER__NAME:
				setName(NAME_EDEFAULT);
				return;
			case GeneratedPackage.TCG_COMPLEX_PARAMETER__TYPE:
				setType((EObject)null);
				return;
			case GeneratedPackage.TCG_COMPLEX_PARAMETER__REFERENCE:
				setReference((EObject)null);
				return;
			case GeneratedPackage.TCG_COMPLEX_PARAMETER__DEFINING_TRANSITION:
				setDefiningTransition((TCGTransition)null);
				return;
			case GeneratedPackage.TCG_COMPLEX_PARAMETER__CONTAINER:
				setContainer((TCGComplexParameter)null);
				return;
			case GeneratedPackage.TCG_COMPLEX_PARAMETER__PARAMETER:
				getParameter().clear();
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
			case GeneratedPackage.TCG_COMPLEX_PARAMETER__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case GeneratedPackage.TCG_COMPLEX_PARAMETER__TYPE:
				return type != null;
			case GeneratedPackage.TCG_COMPLEX_PARAMETER__REFERENCE:
				return reference != null;
			case GeneratedPackage.TCG_COMPLEX_PARAMETER__DEFINING_TRANSITION:
				return definingTransition != null;
			case GeneratedPackage.TCG_COMPLEX_PARAMETER__CONTAINER:
				return container != null;
			case GeneratedPackage.TCG_COMPLEX_PARAMETER__PARAMETER:
				return parameter != null && !parameter.isEmpty();
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

} //TCGComplexParameterImpl
