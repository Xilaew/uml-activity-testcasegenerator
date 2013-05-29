/**
 */
package org.omg.spec.xmi._20110701.impl;

import java.util.Collection;

import javax.xml.datatype.XMLGregorianCalendar;

import javax.xml.namespace.QName;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

import org.omg.spec.xmi._20110701.Documentation;
import org.omg.spec.xmi._20110701.Extension;
import org.omg.spec.xmi._20110701._20110701Package;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Documentation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.omg.spec.xmi._20110701.impl.DocumentationImpl#getGroup <em>Group</em>}</li>
 *   <li>{@link org.omg.spec.xmi._20110701.impl.DocumentationImpl#getContact <em>Contact</em>}</li>
 *   <li>{@link org.omg.spec.xmi._20110701.impl.DocumentationImpl#getExporter <em>Exporter</em>}</li>
 *   <li>{@link org.omg.spec.xmi._20110701.impl.DocumentationImpl#getExporterVersion <em>Exporter Version</em>}</li>
 *   <li>{@link org.omg.spec.xmi._20110701.impl.DocumentationImpl#getLongDescription <em>Long Description</em>}</li>
 *   <li>{@link org.omg.spec.xmi._20110701.impl.DocumentationImpl#getShortDescription <em>Short Description</em>}</li>
 *   <li>{@link org.omg.spec.xmi._20110701.impl.DocumentationImpl#getNotice <em>Notice</em>}</li>
 *   <li>{@link org.omg.spec.xmi._20110701.impl.DocumentationImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link org.omg.spec.xmi._20110701.impl.DocumentationImpl#getTimestamp <em>Timestamp</em>}</li>
 *   <li>{@link org.omg.spec.xmi._20110701.impl.DocumentationImpl#getExtension <em>Extension</em>}</li>
 *   <li>{@link org.omg.spec.xmi._20110701.impl.DocumentationImpl#getHref <em>Href</em>}</li>
 *   <li>{@link org.omg.spec.xmi._20110701.impl.DocumentationImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.omg.spec.xmi._20110701.impl.DocumentationImpl#getIdref <em>Idref</em>}</li>
 *   <li>{@link org.omg.spec.xmi._20110701.impl.DocumentationImpl#getLabel <em>Label</em>}</li>
 *   <li>{@link org.omg.spec.xmi._20110701.impl.DocumentationImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.omg.spec.xmi._20110701.impl.DocumentationImpl#getUuid <em>Uuid</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DocumentationImpl extends EObjectImpl implements Documentation {
	/**
	 * The cached value of the '{@link #getGroup() <em>Group</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGroup()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap group;

	/**
	 * The default value of the '{@link #getHref() <em>Href</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHref()
	 * @generated
	 * @ordered
	 */
	protected static final String HREF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHref() <em>Href</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHref()
	 * @generated
	 * @ordered
	 */
	protected String href = HREF_EDEFAULT;

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
	 * The default value of the '{@link #getIdref() <em>Idref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdref()
	 * @generated
	 * @ordered
	 */
	protected static final String IDREF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIdref() <em>Idref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdref()
	 * @generated
	 * @ordered
	 */
	protected String idref = IDREF_EDEFAULT;

	/**
	 * The default value of the '{@link #getLabel() <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected static final String LABEL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLabel() <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected String label = LABEL_EDEFAULT;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final QName TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected QName type = TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getUuid() <em>Uuid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUuid()
	 * @generated
	 * @ordered
	 */
	protected static final String UUID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUuid() <em>Uuid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUuid()
	 * @generated
	 * @ordered
	 */
	protected String uuid = UUID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DocumentationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return _20110701Package.Literals.DOCUMENTATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getGroup() {
		if (group == null) {
			group = new BasicFeatureMap(this, _20110701Package.DOCUMENTATION__GROUP);
		}
		return group;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getContact() {
		return getGroup().list(_20110701Package.Literals.DOCUMENTATION__CONTACT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getExporter() {
		return getGroup().list(_20110701Package.Literals.DOCUMENTATION__EXPORTER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getExporterVersion() {
		return getGroup().list(_20110701Package.Literals.DOCUMENTATION__EXPORTER_VERSION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getLongDescription() {
		return getGroup().list(_20110701Package.Literals.DOCUMENTATION__LONG_DESCRIPTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getShortDescription() {
		return getGroup().list(_20110701Package.Literals.DOCUMENTATION__SHORT_DESCRIPTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getNotice() {
		return getGroup().list(_20110701Package.Literals.DOCUMENTATION__NOTICE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getOwner() {
		return getGroup().list(_20110701Package.Literals.DOCUMENTATION__OWNER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<XMLGregorianCalendar> getTimestamp() {
		return getGroup().list(_20110701Package.Literals.DOCUMENTATION__TIMESTAMP);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Extension> getExtension() {
		return getGroup().list(_20110701Package.Literals.DOCUMENTATION__EXTENSION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getHref() {
		return href;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHref(String newHref) {
		String oldHref = href;
		href = newHref;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, _20110701Package.DOCUMENTATION__HREF, oldHref, href));
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
			eNotify(new ENotificationImpl(this, Notification.SET, _20110701Package.DOCUMENTATION__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIdref() {
		return idref;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdref(String newIdref) {
		String oldIdref = idref;
		idref = newIdref;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, _20110701Package.DOCUMENTATION__IDREF, oldIdref, idref));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLabel(String newLabel) {
		String oldLabel = label;
		label = newLabel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, _20110701Package.DOCUMENTATION__LABEL, oldLabel, label));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QName getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(QName newType) {
		QName oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, _20110701Package.DOCUMENTATION__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUuid() {
		return uuid;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUuid(String newUuid) {
		String oldUuid = uuid;
		uuid = newUuid;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, _20110701Package.DOCUMENTATION__UUID, oldUuid, uuid));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case _20110701Package.DOCUMENTATION__GROUP:
				return ((InternalEList<?>)getGroup()).basicRemove(otherEnd, msgs);
			case _20110701Package.DOCUMENTATION__EXTENSION:
				return ((InternalEList<?>)getExtension()).basicRemove(otherEnd, msgs);
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
			case _20110701Package.DOCUMENTATION__GROUP:
				if (coreType) return getGroup();
				return ((FeatureMap.Internal)getGroup()).getWrapper();
			case _20110701Package.DOCUMENTATION__CONTACT:
				return getContact();
			case _20110701Package.DOCUMENTATION__EXPORTER:
				return getExporter();
			case _20110701Package.DOCUMENTATION__EXPORTER_VERSION:
				return getExporterVersion();
			case _20110701Package.DOCUMENTATION__LONG_DESCRIPTION:
				return getLongDescription();
			case _20110701Package.DOCUMENTATION__SHORT_DESCRIPTION:
				return getShortDescription();
			case _20110701Package.DOCUMENTATION__NOTICE:
				return getNotice();
			case _20110701Package.DOCUMENTATION__OWNER:
				return getOwner();
			case _20110701Package.DOCUMENTATION__TIMESTAMP:
				return getTimestamp();
			case _20110701Package.DOCUMENTATION__EXTENSION:
				return getExtension();
			case _20110701Package.DOCUMENTATION__HREF:
				return getHref();
			case _20110701Package.DOCUMENTATION__ID:
				return getId();
			case _20110701Package.DOCUMENTATION__IDREF:
				return getIdref();
			case _20110701Package.DOCUMENTATION__LABEL:
				return getLabel();
			case _20110701Package.DOCUMENTATION__TYPE:
				return getType();
			case _20110701Package.DOCUMENTATION__UUID:
				return getUuid();
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
			case _20110701Package.DOCUMENTATION__GROUP:
				((FeatureMap.Internal)getGroup()).set(newValue);
				return;
			case _20110701Package.DOCUMENTATION__CONTACT:
				getContact().clear();
				getContact().addAll((Collection<? extends String>)newValue);
				return;
			case _20110701Package.DOCUMENTATION__EXPORTER:
				getExporter().clear();
				getExporter().addAll((Collection<? extends String>)newValue);
				return;
			case _20110701Package.DOCUMENTATION__EXPORTER_VERSION:
				getExporterVersion().clear();
				getExporterVersion().addAll((Collection<? extends String>)newValue);
				return;
			case _20110701Package.DOCUMENTATION__LONG_DESCRIPTION:
				getLongDescription().clear();
				getLongDescription().addAll((Collection<? extends String>)newValue);
				return;
			case _20110701Package.DOCUMENTATION__SHORT_DESCRIPTION:
				getShortDescription().clear();
				getShortDescription().addAll((Collection<? extends String>)newValue);
				return;
			case _20110701Package.DOCUMENTATION__NOTICE:
				getNotice().clear();
				getNotice().addAll((Collection<? extends String>)newValue);
				return;
			case _20110701Package.DOCUMENTATION__OWNER:
				getOwner().clear();
				getOwner().addAll((Collection<? extends String>)newValue);
				return;
			case _20110701Package.DOCUMENTATION__TIMESTAMP:
				getTimestamp().clear();
				getTimestamp().addAll((Collection<? extends XMLGregorianCalendar>)newValue);
				return;
			case _20110701Package.DOCUMENTATION__EXTENSION:
				getExtension().clear();
				getExtension().addAll((Collection<? extends Extension>)newValue);
				return;
			case _20110701Package.DOCUMENTATION__HREF:
				setHref((String)newValue);
				return;
			case _20110701Package.DOCUMENTATION__ID:
				setId((String)newValue);
				return;
			case _20110701Package.DOCUMENTATION__IDREF:
				setIdref((String)newValue);
				return;
			case _20110701Package.DOCUMENTATION__LABEL:
				setLabel((String)newValue);
				return;
			case _20110701Package.DOCUMENTATION__TYPE:
				setType((QName)newValue);
				return;
			case _20110701Package.DOCUMENTATION__UUID:
				setUuid((String)newValue);
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
			case _20110701Package.DOCUMENTATION__GROUP:
				getGroup().clear();
				return;
			case _20110701Package.DOCUMENTATION__CONTACT:
				getContact().clear();
				return;
			case _20110701Package.DOCUMENTATION__EXPORTER:
				getExporter().clear();
				return;
			case _20110701Package.DOCUMENTATION__EXPORTER_VERSION:
				getExporterVersion().clear();
				return;
			case _20110701Package.DOCUMENTATION__LONG_DESCRIPTION:
				getLongDescription().clear();
				return;
			case _20110701Package.DOCUMENTATION__SHORT_DESCRIPTION:
				getShortDescription().clear();
				return;
			case _20110701Package.DOCUMENTATION__NOTICE:
				getNotice().clear();
				return;
			case _20110701Package.DOCUMENTATION__OWNER:
				getOwner().clear();
				return;
			case _20110701Package.DOCUMENTATION__TIMESTAMP:
				getTimestamp().clear();
				return;
			case _20110701Package.DOCUMENTATION__EXTENSION:
				getExtension().clear();
				return;
			case _20110701Package.DOCUMENTATION__HREF:
				setHref(HREF_EDEFAULT);
				return;
			case _20110701Package.DOCUMENTATION__ID:
				setId(ID_EDEFAULT);
				return;
			case _20110701Package.DOCUMENTATION__IDREF:
				setIdref(IDREF_EDEFAULT);
				return;
			case _20110701Package.DOCUMENTATION__LABEL:
				setLabel(LABEL_EDEFAULT);
				return;
			case _20110701Package.DOCUMENTATION__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case _20110701Package.DOCUMENTATION__UUID:
				setUuid(UUID_EDEFAULT);
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
			case _20110701Package.DOCUMENTATION__GROUP:
				return group != null && !group.isEmpty();
			case _20110701Package.DOCUMENTATION__CONTACT:
				return !getContact().isEmpty();
			case _20110701Package.DOCUMENTATION__EXPORTER:
				return !getExporter().isEmpty();
			case _20110701Package.DOCUMENTATION__EXPORTER_VERSION:
				return !getExporterVersion().isEmpty();
			case _20110701Package.DOCUMENTATION__LONG_DESCRIPTION:
				return !getLongDescription().isEmpty();
			case _20110701Package.DOCUMENTATION__SHORT_DESCRIPTION:
				return !getShortDescription().isEmpty();
			case _20110701Package.DOCUMENTATION__NOTICE:
				return !getNotice().isEmpty();
			case _20110701Package.DOCUMENTATION__OWNER:
				return !getOwner().isEmpty();
			case _20110701Package.DOCUMENTATION__TIMESTAMP:
				return !getTimestamp().isEmpty();
			case _20110701Package.DOCUMENTATION__EXTENSION:
				return !getExtension().isEmpty();
			case _20110701Package.DOCUMENTATION__HREF:
				return HREF_EDEFAULT == null ? href != null : !HREF_EDEFAULT.equals(href);
			case _20110701Package.DOCUMENTATION__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case _20110701Package.DOCUMENTATION__IDREF:
				return IDREF_EDEFAULT == null ? idref != null : !IDREF_EDEFAULT.equals(idref);
			case _20110701Package.DOCUMENTATION__LABEL:
				return LABEL_EDEFAULT == null ? label != null : !LABEL_EDEFAULT.equals(label);
			case _20110701Package.DOCUMENTATION__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
			case _20110701Package.DOCUMENTATION__UUID:
				return UUID_EDEFAULT == null ? uuid != null : !UUID_EDEFAULT.equals(uuid);
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
		result.append(" (group: ");
		result.append(group);
		result.append(", href: ");
		result.append(href);
		result.append(", id: ");
		result.append(id);
		result.append(", idref: ");
		result.append(idref);
		result.append(", label: ");
		result.append(label);
		result.append(", type: ");
		result.append(type);
		result.append(", uuid: ");
		result.append(uuid);
		result.append(')');
		return result.toString();
	}

} //DocumentationImpl
