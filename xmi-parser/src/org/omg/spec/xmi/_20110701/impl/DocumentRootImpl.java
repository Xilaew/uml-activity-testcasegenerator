/**
 */
package org.omg.spec.xmi._20110701.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl;

import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

import org.omg.spec.xmi._20110701.Add;
import org.omg.spec.xmi._20110701.Delete;
import org.omg.spec.xmi._20110701.Difference;
import org.omg.spec.xmi._20110701.DocumentRoot;
import org.omg.spec.xmi._20110701.Documentation;
import org.omg.spec.xmi._20110701.Extension;
import org.omg.spec.xmi._20110701.Replace;
import org.omg.spec.xmi._20110701.XMI;
import org.omg.spec.xmi._20110701._20110701Package;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Document Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.omg.spec.xmi._20110701.impl.DocumentRootImpl#getMixed <em>Mixed</em>}</li>
 *   <li>{@link org.omg.spec.xmi._20110701.impl.DocumentRootImpl#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link org.omg.spec.xmi._20110701.impl.DocumentRootImpl#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link org.omg.spec.xmi._20110701.impl.DocumentRootImpl#getAdd <em>Add</em>}</li>
 *   <li>{@link org.omg.spec.xmi._20110701.impl.DocumentRootImpl#getDelete <em>Delete</em>}</li>
 *   <li>{@link org.omg.spec.xmi._20110701.impl.DocumentRootImpl#getDifference <em>Difference</em>}</li>
 *   <li>{@link org.omg.spec.xmi._20110701.impl.DocumentRootImpl#getDifference1 <em>Difference1</em>}</li>
 *   <li>{@link org.omg.spec.xmi._20110701.impl.DocumentRootImpl#getDocumentation <em>Documentation</em>}</li>
 *   <li>{@link org.omg.spec.xmi._20110701.impl.DocumentRootImpl#getDocumentation1 <em>Documentation1</em>}</li>
 *   <li>{@link org.omg.spec.xmi._20110701.impl.DocumentRootImpl#getExtension <em>Extension</em>}</li>
 *   <li>{@link org.omg.spec.xmi._20110701.impl.DocumentRootImpl#getExtension1 <em>Extension1</em>}</li>
 *   <li>{@link org.omg.spec.xmi._20110701.impl.DocumentRootImpl#getReplace <em>Replace</em>}</li>
 *   <li>{@link org.omg.spec.xmi._20110701.impl.DocumentRootImpl#getXMI <em>XMI</em>}</li>
 *   <li>{@link org.omg.spec.xmi._20110701.impl.DocumentRootImpl#getId <em>Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DocumentRootImpl extends EObjectImpl implements DocumentRoot {
	/**
	 * The cached value of the '{@link #getMixed() <em>Mixed</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMixed()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap mixed;

	/**
	 * The cached value of the '{@link #getXMLNSPrefixMap() <em>XMLNS Prefix Map</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXMLNSPrefixMap()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, String> xMLNSPrefixMap;

	/**
	 * The cached value of the '{@link #getXSISchemaLocation() <em>XSI Schema Location</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXSISchemaLocation()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, String> xSISchemaLocation;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DocumentRootImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return _20110701Package.Literals.DOCUMENT_ROOT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getMixed() {
		if (mixed == null) {
			mixed = new BasicFeatureMap(this, _20110701Package.DOCUMENT_ROOT__MIXED);
		}
		return mixed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<String, String> getXMLNSPrefixMap() {
		if (xMLNSPrefixMap == null) {
			xMLNSPrefixMap = new EcoreEMap<String,String>(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, _20110701Package.DOCUMENT_ROOT__XMLNS_PREFIX_MAP);
		}
		return xMLNSPrefixMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<String, String> getXSISchemaLocation() {
		if (xSISchemaLocation == null) {
			xSISchemaLocation = new EcoreEMap<String,String>(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, _20110701Package.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION);
		}
		return xSISchemaLocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Add getAdd() {
		return (Add)getMixed().get(_20110701Package.Literals.DOCUMENT_ROOT__ADD, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAdd(Add newAdd, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(_20110701Package.Literals.DOCUMENT_ROOT__ADD, newAdd, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAdd(Add newAdd) {
		((FeatureMap.Internal)getMixed()).set(_20110701Package.Literals.DOCUMENT_ROOT__ADD, newAdd);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Delete getDelete() {
		return (Delete)getMixed().get(_20110701Package.Literals.DOCUMENT_ROOT__DELETE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDelete(Delete newDelete, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(_20110701Package.Literals.DOCUMENT_ROOT__DELETE, newDelete, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDelete(Delete newDelete) {
		((FeatureMap.Internal)getMixed()).set(_20110701Package.Literals.DOCUMENT_ROOT__DELETE, newDelete);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Difference getDifference() {
		return (Difference)getMixed().get(_20110701Package.Literals.DOCUMENT_ROOT__DIFFERENCE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDifference(Difference newDifference, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(_20110701Package.Literals.DOCUMENT_ROOT__DIFFERENCE, newDifference, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDifference(Difference newDifference) {
		((FeatureMap.Internal)getMixed()).set(_20110701Package.Literals.DOCUMENT_ROOT__DIFFERENCE, newDifference);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Difference getDifference1() {
		return (Difference)getMixed().get(_20110701Package.Literals.DOCUMENT_ROOT__DIFFERENCE1, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDifference1(Difference newDifference1, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(_20110701Package.Literals.DOCUMENT_ROOT__DIFFERENCE1, newDifference1, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDifference1(Difference newDifference1) {
		((FeatureMap.Internal)getMixed()).set(_20110701Package.Literals.DOCUMENT_ROOT__DIFFERENCE1, newDifference1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Documentation getDocumentation() {
		return (Documentation)getMixed().get(_20110701Package.Literals.DOCUMENT_ROOT__DOCUMENTATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDocumentation(Documentation newDocumentation, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(_20110701Package.Literals.DOCUMENT_ROOT__DOCUMENTATION, newDocumentation, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDocumentation(Documentation newDocumentation) {
		((FeatureMap.Internal)getMixed()).set(_20110701Package.Literals.DOCUMENT_ROOT__DOCUMENTATION, newDocumentation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Documentation getDocumentation1() {
		return (Documentation)getMixed().get(_20110701Package.Literals.DOCUMENT_ROOT__DOCUMENTATION1, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDocumentation1(Documentation newDocumentation1, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(_20110701Package.Literals.DOCUMENT_ROOT__DOCUMENTATION1, newDocumentation1, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDocumentation1(Documentation newDocumentation1) {
		((FeatureMap.Internal)getMixed()).set(_20110701Package.Literals.DOCUMENT_ROOT__DOCUMENTATION1, newDocumentation1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Extension getExtension() {
		return (Extension)getMixed().get(_20110701Package.Literals.DOCUMENT_ROOT__EXTENSION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExtension(Extension newExtension, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(_20110701Package.Literals.DOCUMENT_ROOT__EXTENSION, newExtension, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExtension(Extension newExtension) {
		((FeatureMap.Internal)getMixed()).set(_20110701Package.Literals.DOCUMENT_ROOT__EXTENSION, newExtension);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Extension getExtension1() {
		return (Extension)getMixed().get(_20110701Package.Literals.DOCUMENT_ROOT__EXTENSION1, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExtension1(Extension newExtension1, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(_20110701Package.Literals.DOCUMENT_ROOT__EXTENSION1, newExtension1, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExtension1(Extension newExtension1) {
		((FeatureMap.Internal)getMixed()).set(_20110701Package.Literals.DOCUMENT_ROOT__EXTENSION1, newExtension1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Replace getReplace() {
		return (Replace)getMixed().get(_20110701Package.Literals.DOCUMENT_ROOT__REPLACE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetReplace(Replace newReplace, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(_20110701Package.Literals.DOCUMENT_ROOT__REPLACE, newReplace, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReplace(Replace newReplace) {
		((FeatureMap.Internal)getMixed()).set(_20110701Package.Literals.DOCUMENT_ROOT__REPLACE, newReplace);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XMI getXMI() {
		return (XMI)getMixed().get(_20110701Package.Literals.DOCUMENT_ROOT__XMI, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetXMI(XMI newXMI, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(_20110701Package.Literals.DOCUMENT_ROOT__XMI, newXMI, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setXMI(XMI newXMI) {
		((FeatureMap.Internal)getMixed()).set(_20110701Package.Literals.DOCUMENT_ROOT__XMI, newXMI);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, _20110701Package.DOCUMENT_ROOT__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case _20110701Package.DOCUMENT_ROOT__MIXED:
				return ((InternalEList<?>)getMixed()).basicRemove(otherEnd, msgs);
			case _20110701Package.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
				return ((InternalEList<?>)getXMLNSPrefixMap()).basicRemove(otherEnd, msgs);
			case _20110701Package.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
				return ((InternalEList<?>)getXSISchemaLocation()).basicRemove(otherEnd, msgs);
			case _20110701Package.DOCUMENT_ROOT__ADD:
				return basicSetAdd(null, msgs);
			case _20110701Package.DOCUMENT_ROOT__DELETE:
				return basicSetDelete(null, msgs);
			case _20110701Package.DOCUMENT_ROOT__DIFFERENCE:
				return basicSetDifference(null, msgs);
			case _20110701Package.DOCUMENT_ROOT__DIFFERENCE1:
				return basicSetDifference1(null, msgs);
			case _20110701Package.DOCUMENT_ROOT__DOCUMENTATION:
				return basicSetDocumentation(null, msgs);
			case _20110701Package.DOCUMENT_ROOT__DOCUMENTATION1:
				return basicSetDocumentation1(null, msgs);
			case _20110701Package.DOCUMENT_ROOT__EXTENSION:
				return basicSetExtension(null, msgs);
			case _20110701Package.DOCUMENT_ROOT__EXTENSION1:
				return basicSetExtension1(null, msgs);
			case _20110701Package.DOCUMENT_ROOT__REPLACE:
				return basicSetReplace(null, msgs);
			case _20110701Package.DOCUMENT_ROOT__XMI:
				return basicSetXMI(null, msgs);
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
			case _20110701Package.DOCUMENT_ROOT__MIXED:
				if (coreType) return getMixed();
				return ((FeatureMap.Internal)getMixed()).getWrapper();
			case _20110701Package.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
				if (coreType) return getXMLNSPrefixMap();
				else return getXMLNSPrefixMap().map();
			case _20110701Package.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
				if (coreType) return getXSISchemaLocation();
				else return getXSISchemaLocation().map();
			case _20110701Package.DOCUMENT_ROOT__ADD:
				return getAdd();
			case _20110701Package.DOCUMENT_ROOT__DELETE:
				return getDelete();
			case _20110701Package.DOCUMENT_ROOT__DIFFERENCE:
				return getDifference();
			case _20110701Package.DOCUMENT_ROOT__DIFFERENCE1:
				return getDifference1();
			case _20110701Package.DOCUMENT_ROOT__DOCUMENTATION:
				return getDocumentation();
			case _20110701Package.DOCUMENT_ROOT__DOCUMENTATION1:
				return getDocumentation1();
			case _20110701Package.DOCUMENT_ROOT__EXTENSION:
				return getExtension();
			case _20110701Package.DOCUMENT_ROOT__EXTENSION1:
				return getExtension1();
			case _20110701Package.DOCUMENT_ROOT__REPLACE:
				return getReplace();
			case _20110701Package.DOCUMENT_ROOT__XMI:
				return getXMI();
			case _20110701Package.DOCUMENT_ROOT__ID:
				return getId();
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
			case _20110701Package.DOCUMENT_ROOT__MIXED:
				((FeatureMap.Internal)getMixed()).set(newValue);
				return;
			case _20110701Package.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
				((EStructuralFeature.Setting)getXMLNSPrefixMap()).set(newValue);
				return;
			case _20110701Package.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
				((EStructuralFeature.Setting)getXSISchemaLocation()).set(newValue);
				return;
			case _20110701Package.DOCUMENT_ROOT__ADD:
				setAdd((Add)newValue);
				return;
			case _20110701Package.DOCUMENT_ROOT__DELETE:
				setDelete((Delete)newValue);
				return;
			case _20110701Package.DOCUMENT_ROOT__DIFFERENCE:
				setDifference((Difference)newValue);
				return;
			case _20110701Package.DOCUMENT_ROOT__DIFFERENCE1:
				setDifference1((Difference)newValue);
				return;
			case _20110701Package.DOCUMENT_ROOT__DOCUMENTATION:
				setDocumentation((Documentation)newValue);
				return;
			case _20110701Package.DOCUMENT_ROOT__DOCUMENTATION1:
				setDocumentation1((Documentation)newValue);
				return;
			case _20110701Package.DOCUMENT_ROOT__EXTENSION:
				setExtension((Extension)newValue);
				return;
			case _20110701Package.DOCUMENT_ROOT__EXTENSION1:
				setExtension1((Extension)newValue);
				return;
			case _20110701Package.DOCUMENT_ROOT__REPLACE:
				setReplace((Replace)newValue);
				return;
			case _20110701Package.DOCUMENT_ROOT__XMI:
				setXMI((XMI)newValue);
				return;
			case _20110701Package.DOCUMENT_ROOT__ID:
				setId((String)newValue);
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
			case _20110701Package.DOCUMENT_ROOT__MIXED:
				getMixed().clear();
				return;
			case _20110701Package.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
				getXMLNSPrefixMap().clear();
				return;
			case _20110701Package.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
				getXSISchemaLocation().clear();
				return;
			case _20110701Package.DOCUMENT_ROOT__ADD:
				setAdd((Add)null);
				return;
			case _20110701Package.DOCUMENT_ROOT__DELETE:
				setDelete((Delete)null);
				return;
			case _20110701Package.DOCUMENT_ROOT__DIFFERENCE:
				setDifference((Difference)null);
				return;
			case _20110701Package.DOCUMENT_ROOT__DIFFERENCE1:
				setDifference1((Difference)null);
				return;
			case _20110701Package.DOCUMENT_ROOT__DOCUMENTATION:
				setDocumentation((Documentation)null);
				return;
			case _20110701Package.DOCUMENT_ROOT__DOCUMENTATION1:
				setDocumentation1((Documentation)null);
				return;
			case _20110701Package.DOCUMENT_ROOT__EXTENSION:
				setExtension((Extension)null);
				return;
			case _20110701Package.DOCUMENT_ROOT__EXTENSION1:
				setExtension1((Extension)null);
				return;
			case _20110701Package.DOCUMENT_ROOT__REPLACE:
				setReplace((Replace)null);
				return;
			case _20110701Package.DOCUMENT_ROOT__XMI:
				setXMI((XMI)null);
				return;
			case _20110701Package.DOCUMENT_ROOT__ID:
				setId(ID_EDEFAULT);
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
			case _20110701Package.DOCUMENT_ROOT__MIXED:
				return mixed != null && !mixed.isEmpty();
			case _20110701Package.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
				return xMLNSPrefixMap != null && !xMLNSPrefixMap.isEmpty();
			case _20110701Package.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
				return xSISchemaLocation != null && !xSISchemaLocation.isEmpty();
			case _20110701Package.DOCUMENT_ROOT__ADD:
				return getAdd() != null;
			case _20110701Package.DOCUMENT_ROOT__DELETE:
				return getDelete() != null;
			case _20110701Package.DOCUMENT_ROOT__DIFFERENCE:
				return getDifference() != null;
			case _20110701Package.DOCUMENT_ROOT__DIFFERENCE1:
				return getDifference1() != null;
			case _20110701Package.DOCUMENT_ROOT__DOCUMENTATION:
				return getDocumentation() != null;
			case _20110701Package.DOCUMENT_ROOT__DOCUMENTATION1:
				return getDocumentation1() != null;
			case _20110701Package.DOCUMENT_ROOT__EXTENSION:
				return getExtension() != null;
			case _20110701Package.DOCUMENT_ROOT__EXTENSION1:
				return getExtension1() != null;
			case _20110701Package.DOCUMENT_ROOT__REPLACE:
				return getReplace() != null;
			case _20110701Package.DOCUMENT_ROOT__XMI:
				return getXMI() != null;
			case _20110701Package.DOCUMENT_ROOT__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
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
		result.append(" (mixed: ");
		result.append(mixed);
		result.append(", id: ");
		result.append(id);
		result.append(')');
		return result.toString();
	}

} //DocumentRootImpl
