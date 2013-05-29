/**
 */
package org.omg.spec.xmi._20110701;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.omg.spec.xmi._20110701._20110701Factory
 * @model kind="package"
 * @generated
 */
public interface _20110701Package extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "_20110701";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.omg.org/spec/XMI/20110701";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "_20110701";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	_20110701Package eINSTANCE = org.omg.spec.xmi._20110701.impl._20110701PackageImpl.init();

	/**
	 * The meta object id for the '{@link org.omg.spec.xmi._20110701.impl.DifferenceImpl <em>Difference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.spec.xmi._20110701.impl.DifferenceImpl
	 * @see org.omg.spec.xmi._20110701.impl._20110701PackageImpl#getDifference()
	 * @generated
	 */
	int DIFFERENCE = 3;

	/**
	 * The feature id for the '<em><b>Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIFFERENCE__GROUP = 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIFFERENCE__TARGET = 1;

	/**
	 * The feature id for the '<em><b>Difference</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIFFERENCE__DIFFERENCE = 2;

	/**
	 * The feature id for the '<em><b>Container</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIFFERENCE__CONTAINER = 3;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIFFERENCE__EXTENSION = 4;

	/**
	 * The feature id for the '<em><b>Container1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIFFERENCE__CONTAINER1 = 5;

	/**
	 * The feature id for the '<em><b>Href</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIFFERENCE__HREF = 6;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIFFERENCE__ID = 7;

	/**
	 * The feature id for the '<em><b>Idref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIFFERENCE__IDREF = 8;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIFFERENCE__LABEL = 9;

	/**
	 * The feature id for the '<em><b>Target1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIFFERENCE__TARGET1 = 10;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIFFERENCE__TYPE = 11;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIFFERENCE__UUID = 12;

	/**
	 * The number of structural features of the '<em>Difference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIFFERENCE_FEATURE_COUNT = 13;

	/**
	 * The meta object id for the '{@link org.omg.spec.xmi._20110701.impl.AddImpl <em>Add</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.spec.xmi._20110701.impl.AddImpl
	 * @see org.omg.spec.xmi._20110701.impl._20110701PackageImpl#getAdd()
	 * @generated
	 */
	int ADD = 0;

	/**
	 * The feature id for the '<em><b>Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD__GROUP = DIFFERENCE__GROUP;

	/**
	 * The feature id for the '<em><b>Target</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD__TARGET = DIFFERENCE__TARGET;

	/**
	 * The feature id for the '<em><b>Difference</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD__DIFFERENCE = DIFFERENCE__DIFFERENCE;

	/**
	 * The feature id for the '<em><b>Container</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD__CONTAINER = DIFFERENCE__CONTAINER;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD__EXTENSION = DIFFERENCE__EXTENSION;

	/**
	 * The feature id for the '<em><b>Container1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD__CONTAINER1 = DIFFERENCE__CONTAINER1;

	/**
	 * The feature id for the '<em><b>Href</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD__HREF = DIFFERENCE__HREF;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD__ID = DIFFERENCE__ID;

	/**
	 * The feature id for the '<em><b>Idref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD__IDREF = DIFFERENCE__IDREF;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD__LABEL = DIFFERENCE__LABEL;

	/**
	 * The feature id for the '<em><b>Target1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD__TARGET1 = DIFFERENCE__TARGET1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD__TYPE = DIFFERENCE__TYPE;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD__UUID = DIFFERENCE__UUID;

	/**
	 * The feature id for the '<em><b>Addition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD__ADDITION = DIFFERENCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD__POSITION = DIFFERENCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Add</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_FEATURE_COUNT = DIFFERENCE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.omg.spec.xmi._20110701.impl.AnyImpl <em>Any</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.spec.xmi._20110701.impl.AnyImpl
	 * @see org.omg.spec.xmi._20110701.impl._20110701PackageImpl#getAny()
	 * @generated
	 */
	int ANY = 1;

	/**
	 * The feature id for the '<em><b>Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY__GROUP = 0;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY__ANY = 1;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY__ANY_ATTRIBUTE = 2;

	/**
	 * The number of structural features of the '<em>Any</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.omg.spec.xmi._20110701.impl.DeleteImpl <em>Delete</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.spec.xmi._20110701.impl.DeleteImpl
	 * @see org.omg.spec.xmi._20110701.impl._20110701PackageImpl#getDelete()
	 * @generated
	 */
	int DELETE = 2;

	/**
	 * The feature id for the '<em><b>Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE__GROUP = DIFFERENCE__GROUP;

	/**
	 * The feature id for the '<em><b>Target</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE__TARGET = DIFFERENCE__TARGET;

	/**
	 * The feature id for the '<em><b>Difference</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE__DIFFERENCE = DIFFERENCE__DIFFERENCE;

	/**
	 * The feature id for the '<em><b>Container</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE__CONTAINER = DIFFERENCE__CONTAINER;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE__EXTENSION = DIFFERENCE__EXTENSION;

	/**
	 * The feature id for the '<em><b>Container1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE__CONTAINER1 = DIFFERENCE__CONTAINER1;

	/**
	 * The feature id for the '<em><b>Href</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE__HREF = DIFFERENCE__HREF;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE__ID = DIFFERENCE__ID;

	/**
	 * The feature id for the '<em><b>Idref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE__IDREF = DIFFERENCE__IDREF;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE__LABEL = DIFFERENCE__LABEL;

	/**
	 * The feature id for the '<em><b>Target1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE__TARGET1 = DIFFERENCE__TARGET1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE__TYPE = DIFFERENCE__TYPE;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE__UUID = DIFFERENCE__UUID;

	/**
	 * The number of structural features of the '<em>Delete</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_FEATURE_COUNT = DIFFERENCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.omg.spec.xmi._20110701.impl.DocumentationImpl <em>Documentation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.spec.xmi._20110701.impl.DocumentationImpl
	 * @see org.omg.spec.xmi._20110701.impl._20110701PackageImpl#getDocumentation()
	 * @generated
	 */
	int DOCUMENTATION = 4;

	/**
	 * The feature id for the '<em><b>Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENTATION__GROUP = 0;

	/**
	 * The feature id for the '<em><b>Contact</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENTATION__CONTACT = 1;

	/**
	 * The feature id for the '<em><b>Exporter</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENTATION__EXPORTER = 2;

	/**
	 * The feature id for the '<em><b>Exporter Version</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENTATION__EXPORTER_VERSION = 3;

	/**
	 * The feature id for the '<em><b>Long Description</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENTATION__LONG_DESCRIPTION = 4;

	/**
	 * The feature id for the '<em><b>Short Description</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENTATION__SHORT_DESCRIPTION = 5;

	/**
	 * The feature id for the '<em><b>Notice</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENTATION__NOTICE = 6;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENTATION__OWNER = 7;

	/**
	 * The feature id for the '<em><b>Timestamp</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENTATION__TIMESTAMP = 8;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENTATION__EXTENSION = 9;

	/**
	 * The feature id for the '<em><b>Href</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENTATION__HREF = 10;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENTATION__ID = 11;

	/**
	 * The feature id for the '<em><b>Idref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENTATION__IDREF = 12;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENTATION__LABEL = 13;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENTATION__TYPE = 14;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENTATION__UUID = 15;

	/**
	 * The number of structural features of the '<em>Documentation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENTATION_FEATURE_COUNT = 16;

	/**
	 * The meta object id for the '{@link org.omg.spec.xmi._20110701.impl.DocumentRootImpl <em>Document Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.spec.xmi._20110701.impl.DocumentRootImpl
	 * @see org.omg.spec.xmi._20110701.impl._20110701PackageImpl#getDocumentRoot()
	 * @generated
	 */
	int DOCUMENT_ROOT = 5;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__MIXED = 0;

	/**
	 * The feature id for the '<em><b>XMLNS Prefix Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__XMLNS_PREFIX_MAP = 1;

	/**
	 * The feature id for the '<em><b>XSI Schema Location</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__XSI_SCHEMA_LOCATION = 2;

	/**
	 * The feature id for the '<em><b>Add</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__ADD = 3;

	/**
	 * The feature id for the '<em><b>Delete</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__DELETE = 4;

	/**
	 * The feature id for the '<em><b>Difference</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__DIFFERENCE = 5;

	/**
	 * The feature id for the '<em><b>Difference1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__DIFFERENCE1 = 6;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__DOCUMENTATION = 7;

	/**
	 * The feature id for the '<em><b>Documentation1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__DOCUMENTATION1 = 8;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__EXTENSION = 9;

	/**
	 * The feature id for the '<em><b>Extension1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__EXTENSION1 = 10;

	/**
	 * The feature id for the '<em><b>Replace</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__REPLACE = 11;

	/**
	 * The feature id for the '<em><b>XMI</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__XMI = 12;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__ID = 13;

	/**
	 * The number of structural features of the '<em>Document Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT_FEATURE_COUNT = 14;

	/**
	 * The meta object id for the '{@link org.omg.spec.xmi._20110701.impl.ExtensionImpl <em>Extension</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.spec.xmi._20110701.impl.ExtensionImpl
	 * @see org.omg.spec.xmi._20110701.impl._20110701PackageImpl#getExtension()
	 * @generated
	 */
	int EXTENSION = 6;

	/**
	 * The feature id for the '<em><b>Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION__GROUP = 0;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION__ANY = 1;

	/**
	 * The feature id for the '<em><b>Extender</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION__EXTENDER = 2;

	/**
	 * The feature id for the '<em><b>Extender ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION__EXTENDER_ID = 3;

	/**
	 * The feature id for the '<em><b>Href</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION__HREF = 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION__ID = 5;

	/**
	 * The feature id for the '<em><b>Idref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION__IDREF = 6;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION__LABEL = 7;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION__TYPE = 8;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION__UUID = 9;

	/**
	 * The number of structural features of the '<em>Extension</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_FEATURE_COUNT = 10;

	/**
	 * The meta object id for the '{@link org.omg.spec.xmi._20110701.impl.ReplaceImpl <em>Replace</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.spec.xmi._20110701.impl.ReplaceImpl
	 * @see org.omg.spec.xmi._20110701.impl._20110701PackageImpl#getReplace()
	 * @generated
	 */
	int REPLACE = 7;

	/**
	 * The feature id for the '<em><b>Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACE__GROUP = DIFFERENCE__GROUP;

	/**
	 * The feature id for the '<em><b>Target</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACE__TARGET = DIFFERENCE__TARGET;

	/**
	 * The feature id for the '<em><b>Difference</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACE__DIFFERENCE = DIFFERENCE__DIFFERENCE;

	/**
	 * The feature id for the '<em><b>Container</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACE__CONTAINER = DIFFERENCE__CONTAINER;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACE__EXTENSION = DIFFERENCE__EXTENSION;

	/**
	 * The feature id for the '<em><b>Container1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACE__CONTAINER1 = DIFFERENCE__CONTAINER1;

	/**
	 * The feature id for the '<em><b>Href</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACE__HREF = DIFFERENCE__HREF;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACE__ID = DIFFERENCE__ID;

	/**
	 * The feature id for the '<em><b>Idref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACE__IDREF = DIFFERENCE__IDREF;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACE__LABEL = DIFFERENCE__LABEL;

	/**
	 * The feature id for the '<em><b>Target1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACE__TARGET1 = DIFFERENCE__TARGET1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACE__TYPE = DIFFERENCE__TYPE;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACE__UUID = DIFFERENCE__UUID;

	/**
	 * The feature id for the '<em><b>Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACE__POSITION = DIFFERENCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Replacement</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACE__REPLACEMENT = DIFFERENCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Replace</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACE_FEATURE_COUNT = DIFFERENCE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.omg.spec.xmi._20110701.impl.TargetTypeImpl <em>Target Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.spec.xmi._20110701.impl.TargetTypeImpl
	 * @see org.omg.spec.xmi._20110701.impl._20110701PackageImpl#getTargetType()
	 * @generated
	 */
	int TARGET_TYPE = 8;

	/**
	 * The feature id for the '<em><b>Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_TYPE__GROUP = 0;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_TYPE__ANY = 1;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_TYPE__ANY_ATTRIBUTE = 2;

	/**
	 * The number of structural features of the '<em>Target Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_TYPE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.omg.spec.xmi._20110701.impl.XMIImpl <em>XMI</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.spec.xmi._20110701.impl.XMIImpl
	 * @see org.omg.spec.xmi._20110701.impl._20110701PackageImpl#getXMI()
	 * @generated
	 */
	int XMI = 9;

	/**
	 * The feature id for the '<em><b>Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMI__GROUP = 0;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMI__ANY = 1;

	/**
	 * The feature id for the '<em><b>Href</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMI__HREF = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMI__ID = 3;

	/**
	 * The feature id for the '<em><b>Idref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMI__IDREF = 4;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMI__LABEL = 5;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMI__TYPE = 6;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMI__UUID = 7;

	/**
	 * The number of structural features of the '<em>XMI</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMI_FEATURE_COUNT = 8;


	/**
	 * Returns the meta object for class '{@link org.omg.spec.xmi._20110701.Add <em>Add</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Add</em>'.
	 * @see org.omg.spec.xmi._20110701.Add
	 * @generated
	 */
	EClass getAdd();

	/**
	 * Returns the meta object for the attribute '{@link org.omg.spec.xmi._20110701.Add#getAddition <em>Addition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Addition</em>'.
	 * @see org.omg.spec.xmi._20110701.Add#getAddition()
	 * @see #getAdd()
	 * @generated
	 */
	EAttribute getAdd_Addition();

	/**
	 * Returns the meta object for the attribute '{@link org.omg.spec.xmi._20110701.Add#getPosition <em>Position</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Position</em>'.
	 * @see org.omg.spec.xmi._20110701.Add#getPosition()
	 * @see #getAdd()
	 * @generated
	 */
	EAttribute getAdd_Position();

	/**
	 * Returns the meta object for class '{@link org.omg.spec.xmi._20110701.Any <em>Any</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Any</em>'.
	 * @see org.omg.spec.xmi._20110701.Any
	 * @generated
	 */
	EClass getAny();

	/**
	 * Returns the meta object for the attribute list '{@link org.omg.spec.xmi._20110701.Any#getGroup <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Group</em>'.
	 * @see org.omg.spec.xmi._20110701.Any#getGroup()
	 * @see #getAny()
	 * @generated
	 */
	EAttribute getAny_Group();

	/**
	 * Returns the meta object for the attribute list '{@link org.omg.spec.xmi._20110701.Any#getAny <em>Any</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any</em>'.
	 * @see org.omg.spec.xmi._20110701.Any#getAny()
	 * @see #getAny()
	 * @generated
	 */
	EAttribute getAny_Any();

	/**
	 * Returns the meta object for the attribute list '{@link org.omg.spec.xmi._20110701.Any#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see org.omg.spec.xmi._20110701.Any#getAnyAttribute()
	 * @see #getAny()
	 * @generated
	 */
	EAttribute getAny_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link org.omg.spec.xmi._20110701.Delete <em>Delete</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Delete</em>'.
	 * @see org.omg.spec.xmi._20110701.Delete
	 * @generated
	 */
	EClass getDelete();

	/**
	 * Returns the meta object for class '{@link org.omg.spec.xmi._20110701.Difference <em>Difference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Difference</em>'.
	 * @see org.omg.spec.xmi._20110701.Difference
	 * @generated
	 */
	EClass getDifference();

	/**
	 * Returns the meta object for the attribute list '{@link org.omg.spec.xmi._20110701.Difference#getGroup <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Group</em>'.
	 * @see org.omg.spec.xmi._20110701.Difference#getGroup()
	 * @see #getDifference()
	 * @generated
	 */
	EAttribute getDifference_Group();

	/**
	 * Returns the meta object for the containment reference list '{@link org.omg.spec.xmi._20110701.Difference#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Target</em>'.
	 * @see org.omg.spec.xmi._20110701.Difference#getTarget()
	 * @see #getDifference()
	 * @generated
	 */
	EReference getDifference_Target();

	/**
	 * Returns the meta object for the containment reference list '{@link org.omg.spec.xmi._20110701.Difference#getDifference <em>Difference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Difference</em>'.
	 * @see org.omg.spec.xmi._20110701.Difference#getDifference()
	 * @see #getDifference()
	 * @generated
	 */
	EReference getDifference_Difference();

	/**
	 * Returns the meta object for the containment reference list '{@link org.omg.spec.xmi._20110701.Difference#getContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Container</em>'.
	 * @see org.omg.spec.xmi._20110701.Difference#getContainer()
	 * @see #getDifference()
	 * @generated
	 */
	EReference getDifference_Container();

	/**
	 * Returns the meta object for the containment reference list '{@link org.omg.spec.xmi._20110701.Difference#getExtension <em>Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Extension</em>'.
	 * @see org.omg.spec.xmi._20110701.Difference#getExtension()
	 * @see #getDifference()
	 * @generated
	 */
	EReference getDifference_Extension();

	/**
	 * Returns the meta object for the attribute '{@link org.omg.spec.xmi._20110701.Difference#getContainer1 <em>Container1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Container1</em>'.
	 * @see org.omg.spec.xmi._20110701.Difference#getContainer1()
	 * @see #getDifference()
	 * @generated
	 */
	EAttribute getDifference_Container1();

	/**
	 * Returns the meta object for the attribute '{@link org.omg.spec.xmi._20110701.Difference#getHref <em>Href</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Href</em>'.
	 * @see org.omg.spec.xmi._20110701.Difference#getHref()
	 * @see #getDifference()
	 * @generated
	 */
	EAttribute getDifference_Href();

	/**
	 * Returns the meta object for the attribute '{@link org.omg.spec.xmi._20110701.Difference#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.omg.spec.xmi._20110701.Difference#getId()
	 * @see #getDifference()
	 * @generated
	 */
	EAttribute getDifference_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.omg.spec.xmi._20110701.Difference#getIdref <em>Idref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Idref</em>'.
	 * @see org.omg.spec.xmi._20110701.Difference#getIdref()
	 * @see #getDifference()
	 * @generated
	 */
	EAttribute getDifference_Idref();

	/**
	 * Returns the meta object for the attribute '{@link org.omg.spec.xmi._20110701.Difference#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label</em>'.
	 * @see org.omg.spec.xmi._20110701.Difference#getLabel()
	 * @see #getDifference()
	 * @generated
	 */
	EAttribute getDifference_Label();

	/**
	 * Returns the meta object for the attribute '{@link org.omg.spec.xmi._20110701.Difference#getTarget1 <em>Target1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target1</em>'.
	 * @see org.omg.spec.xmi._20110701.Difference#getTarget1()
	 * @see #getDifference()
	 * @generated
	 */
	EAttribute getDifference_Target1();

	/**
	 * Returns the meta object for the attribute '{@link org.omg.spec.xmi._20110701.Difference#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.omg.spec.xmi._20110701.Difference#getType()
	 * @see #getDifference()
	 * @generated
	 */
	EAttribute getDifference_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.omg.spec.xmi._20110701.Difference#getUuid <em>Uuid</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uuid</em>'.
	 * @see org.omg.spec.xmi._20110701.Difference#getUuid()
	 * @see #getDifference()
	 * @generated
	 */
	EAttribute getDifference_Uuid();

	/**
	 * Returns the meta object for class '{@link org.omg.spec.xmi._20110701.Documentation <em>Documentation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Documentation</em>'.
	 * @see org.omg.spec.xmi._20110701.Documentation
	 * @generated
	 */
	EClass getDocumentation();

	/**
	 * Returns the meta object for the attribute list '{@link org.omg.spec.xmi._20110701.Documentation#getGroup <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Group</em>'.
	 * @see org.omg.spec.xmi._20110701.Documentation#getGroup()
	 * @see #getDocumentation()
	 * @generated
	 */
	EAttribute getDocumentation_Group();

	/**
	 * Returns the meta object for the attribute list '{@link org.omg.spec.xmi._20110701.Documentation#getContact <em>Contact</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Contact</em>'.
	 * @see org.omg.spec.xmi._20110701.Documentation#getContact()
	 * @see #getDocumentation()
	 * @generated
	 */
	EAttribute getDocumentation_Contact();

	/**
	 * Returns the meta object for the attribute list '{@link org.omg.spec.xmi._20110701.Documentation#getExporter <em>Exporter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Exporter</em>'.
	 * @see org.omg.spec.xmi._20110701.Documentation#getExporter()
	 * @see #getDocumentation()
	 * @generated
	 */
	EAttribute getDocumentation_Exporter();

	/**
	 * Returns the meta object for the attribute list '{@link org.omg.spec.xmi._20110701.Documentation#getExporterVersion <em>Exporter Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Exporter Version</em>'.
	 * @see org.omg.spec.xmi._20110701.Documentation#getExporterVersion()
	 * @see #getDocumentation()
	 * @generated
	 */
	EAttribute getDocumentation_ExporterVersion();

	/**
	 * Returns the meta object for the attribute list '{@link org.omg.spec.xmi._20110701.Documentation#getLongDescription <em>Long Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Long Description</em>'.
	 * @see org.omg.spec.xmi._20110701.Documentation#getLongDescription()
	 * @see #getDocumentation()
	 * @generated
	 */
	EAttribute getDocumentation_LongDescription();

	/**
	 * Returns the meta object for the attribute list '{@link org.omg.spec.xmi._20110701.Documentation#getShortDescription <em>Short Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Short Description</em>'.
	 * @see org.omg.spec.xmi._20110701.Documentation#getShortDescription()
	 * @see #getDocumentation()
	 * @generated
	 */
	EAttribute getDocumentation_ShortDescription();

	/**
	 * Returns the meta object for the attribute list '{@link org.omg.spec.xmi._20110701.Documentation#getNotice <em>Notice</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Notice</em>'.
	 * @see org.omg.spec.xmi._20110701.Documentation#getNotice()
	 * @see #getDocumentation()
	 * @generated
	 */
	EAttribute getDocumentation_Notice();

	/**
	 * Returns the meta object for the attribute list '{@link org.omg.spec.xmi._20110701.Documentation#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Owner</em>'.
	 * @see org.omg.spec.xmi._20110701.Documentation#getOwner()
	 * @see #getDocumentation()
	 * @generated
	 */
	EAttribute getDocumentation_Owner();

	/**
	 * Returns the meta object for the attribute list '{@link org.omg.spec.xmi._20110701.Documentation#getTimestamp <em>Timestamp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Timestamp</em>'.
	 * @see org.omg.spec.xmi._20110701.Documentation#getTimestamp()
	 * @see #getDocumentation()
	 * @generated
	 */
	EAttribute getDocumentation_Timestamp();

	/**
	 * Returns the meta object for the containment reference list '{@link org.omg.spec.xmi._20110701.Documentation#getExtension <em>Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Extension</em>'.
	 * @see org.omg.spec.xmi._20110701.Documentation#getExtension()
	 * @see #getDocumentation()
	 * @generated
	 */
	EReference getDocumentation_Extension();

	/**
	 * Returns the meta object for the attribute '{@link org.omg.spec.xmi._20110701.Documentation#getHref <em>Href</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Href</em>'.
	 * @see org.omg.spec.xmi._20110701.Documentation#getHref()
	 * @see #getDocumentation()
	 * @generated
	 */
	EAttribute getDocumentation_Href();

	/**
	 * Returns the meta object for the attribute '{@link org.omg.spec.xmi._20110701.Documentation#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.omg.spec.xmi._20110701.Documentation#getId()
	 * @see #getDocumentation()
	 * @generated
	 */
	EAttribute getDocumentation_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.omg.spec.xmi._20110701.Documentation#getIdref <em>Idref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Idref</em>'.
	 * @see org.omg.spec.xmi._20110701.Documentation#getIdref()
	 * @see #getDocumentation()
	 * @generated
	 */
	EAttribute getDocumentation_Idref();

	/**
	 * Returns the meta object for the attribute '{@link org.omg.spec.xmi._20110701.Documentation#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label</em>'.
	 * @see org.omg.spec.xmi._20110701.Documentation#getLabel()
	 * @see #getDocumentation()
	 * @generated
	 */
	EAttribute getDocumentation_Label();

	/**
	 * Returns the meta object for the attribute '{@link org.omg.spec.xmi._20110701.Documentation#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.omg.spec.xmi._20110701.Documentation#getType()
	 * @see #getDocumentation()
	 * @generated
	 */
	EAttribute getDocumentation_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.omg.spec.xmi._20110701.Documentation#getUuid <em>Uuid</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uuid</em>'.
	 * @see org.omg.spec.xmi._20110701.Documentation#getUuid()
	 * @see #getDocumentation()
	 * @generated
	 */
	EAttribute getDocumentation_Uuid();

	/**
	 * Returns the meta object for class '{@link org.omg.spec.xmi._20110701.DocumentRoot <em>Document Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Document Root</em>'.
	 * @see org.omg.spec.xmi._20110701.DocumentRoot
	 * @generated
	 */
	EClass getDocumentRoot();

	/**
	 * Returns the meta object for the attribute list '{@link org.omg.spec.xmi._20110701.DocumentRoot#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see org.omg.spec.xmi._20110701.DocumentRoot#getMixed()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_Mixed();

	/**
	 * Returns the meta object for the map '{@link org.omg.spec.xmi._20110701.DocumentRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
	 * @see org.omg.spec.xmi._20110701.DocumentRoot#getXMLNSPrefixMap()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XMLNSPrefixMap();

	/**
	 * Returns the meta object for the map '{@link org.omg.spec.xmi._20110701.DocumentRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XSI Schema Location</em>'.
	 * @see org.omg.spec.xmi._20110701.DocumentRoot#getXSISchemaLocation()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XSISchemaLocation();

	/**
	 * Returns the meta object for the containment reference '{@link org.omg.spec.xmi._20110701.DocumentRoot#getAdd <em>Add</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Add</em>'.
	 * @see org.omg.spec.xmi._20110701.DocumentRoot#getAdd()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Add();

	/**
	 * Returns the meta object for the containment reference '{@link org.omg.spec.xmi._20110701.DocumentRoot#getDelete <em>Delete</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Delete</em>'.
	 * @see org.omg.spec.xmi._20110701.DocumentRoot#getDelete()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Delete();

	/**
	 * Returns the meta object for the containment reference '{@link org.omg.spec.xmi._20110701.DocumentRoot#getDifference <em>Difference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Difference</em>'.
	 * @see org.omg.spec.xmi._20110701.DocumentRoot#getDifference()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Difference();

	/**
	 * Returns the meta object for the containment reference '{@link org.omg.spec.xmi._20110701.DocumentRoot#getDifference1 <em>Difference1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Difference1</em>'.
	 * @see org.omg.spec.xmi._20110701.DocumentRoot#getDifference1()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Difference1();

	/**
	 * Returns the meta object for the containment reference '{@link org.omg.spec.xmi._20110701.DocumentRoot#getDocumentation <em>Documentation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Documentation</em>'.
	 * @see org.omg.spec.xmi._20110701.DocumentRoot#getDocumentation()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Documentation();

	/**
	 * Returns the meta object for the containment reference '{@link org.omg.spec.xmi._20110701.DocumentRoot#getDocumentation1 <em>Documentation1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Documentation1</em>'.
	 * @see org.omg.spec.xmi._20110701.DocumentRoot#getDocumentation1()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Documentation1();

	/**
	 * Returns the meta object for the containment reference '{@link org.omg.spec.xmi._20110701.DocumentRoot#getExtension <em>Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Extension</em>'.
	 * @see org.omg.spec.xmi._20110701.DocumentRoot#getExtension()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Extension();

	/**
	 * Returns the meta object for the containment reference '{@link org.omg.spec.xmi._20110701.DocumentRoot#getExtension1 <em>Extension1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Extension1</em>'.
	 * @see org.omg.spec.xmi._20110701.DocumentRoot#getExtension1()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Extension1();

	/**
	 * Returns the meta object for the containment reference '{@link org.omg.spec.xmi._20110701.DocumentRoot#getReplace <em>Replace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Replace</em>'.
	 * @see org.omg.spec.xmi._20110701.DocumentRoot#getReplace()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Replace();

	/**
	 * Returns the meta object for the containment reference '{@link org.omg.spec.xmi._20110701.DocumentRoot#getXMI <em>XMI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>XMI</em>'.
	 * @see org.omg.spec.xmi._20110701.DocumentRoot#getXMI()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XMI();

	/**
	 * Returns the meta object for the attribute '{@link org.omg.spec.xmi._20110701.DocumentRoot#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.omg.spec.xmi._20110701.DocumentRoot#getId()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_Id();

	/**
	 * Returns the meta object for class '{@link org.omg.spec.xmi._20110701.Extension <em>Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Extension</em>'.
	 * @see org.omg.spec.xmi._20110701.Extension
	 * @generated
	 */
	EClass getExtension();

	/**
	 * Returns the meta object for the attribute list '{@link org.omg.spec.xmi._20110701.Extension#getGroup <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Group</em>'.
	 * @see org.omg.spec.xmi._20110701.Extension#getGroup()
	 * @see #getExtension()
	 * @generated
	 */
	EAttribute getExtension_Group();

	/**
	 * Returns the meta object for the attribute list '{@link org.omg.spec.xmi._20110701.Extension#getAny <em>Any</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any</em>'.
	 * @see org.omg.spec.xmi._20110701.Extension#getAny()
	 * @see #getExtension()
	 * @generated
	 */
	EAttribute getExtension_Any();

	/**
	 * Returns the meta object for the attribute '{@link org.omg.spec.xmi._20110701.Extension#getExtender <em>Extender</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Extender</em>'.
	 * @see org.omg.spec.xmi._20110701.Extension#getExtender()
	 * @see #getExtension()
	 * @generated
	 */
	EAttribute getExtension_Extender();

	/**
	 * Returns the meta object for the attribute '{@link org.omg.spec.xmi._20110701.Extension#getExtenderID <em>Extender ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Extender ID</em>'.
	 * @see org.omg.spec.xmi._20110701.Extension#getExtenderID()
	 * @see #getExtension()
	 * @generated
	 */
	EAttribute getExtension_ExtenderID();

	/**
	 * Returns the meta object for the attribute '{@link org.omg.spec.xmi._20110701.Extension#getHref <em>Href</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Href</em>'.
	 * @see org.omg.spec.xmi._20110701.Extension#getHref()
	 * @see #getExtension()
	 * @generated
	 */
	EAttribute getExtension_Href();

	/**
	 * Returns the meta object for the attribute '{@link org.omg.spec.xmi._20110701.Extension#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.omg.spec.xmi._20110701.Extension#getId()
	 * @see #getExtension()
	 * @generated
	 */
	EAttribute getExtension_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.omg.spec.xmi._20110701.Extension#getIdref <em>Idref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Idref</em>'.
	 * @see org.omg.spec.xmi._20110701.Extension#getIdref()
	 * @see #getExtension()
	 * @generated
	 */
	EAttribute getExtension_Idref();

	/**
	 * Returns the meta object for the attribute '{@link org.omg.spec.xmi._20110701.Extension#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label</em>'.
	 * @see org.omg.spec.xmi._20110701.Extension#getLabel()
	 * @see #getExtension()
	 * @generated
	 */
	EAttribute getExtension_Label();

	/**
	 * Returns the meta object for the attribute '{@link org.omg.spec.xmi._20110701.Extension#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.omg.spec.xmi._20110701.Extension#getType()
	 * @see #getExtension()
	 * @generated
	 */
	EAttribute getExtension_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.omg.spec.xmi._20110701.Extension#getUuid <em>Uuid</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uuid</em>'.
	 * @see org.omg.spec.xmi._20110701.Extension#getUuid()
	 * @see #getExtension()
	 * @generated
	 */
	EAttribute getExtension_Uuid();

	/**
	 * Returns the meta object for class '{@link org.omg.spec.xmi._20110701.Replace <em>Replace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Replace</em>'.
	 * @see org.omg.spec.xmi._20110701.Replace
	 * @generated
	 */
	EClass getReplace();

	/**
	 * Returns the meta object for the attribute '{@link org.omg.spec.xmi._20110701.Replace#getPosition <em>Position</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Position</em>'.
	 * @see org.omg.spec.xmi._20110701.Replace#getPosition()
	 * @see #getReplace()
	 * @generated
	 */
	EAttribute getReplace_Position();

	/**
	 * Returns the meta object for the attribute '{@link org.omg.spec.xmi._20110701.Replace#getReplacement <em>Replacement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Replacement</em>'.
	 * @see org.omg.spec.xmi._20110701.Replace#getReplacement()
	 * @see #getReplace()
	 * @generated
	 */
	EAttribute getReplace_Replacement();

	/**
	 * Returns the meta object for class '{@link org.omg.spec.xmi._20110701.TargetType <em>Target Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Target Type</em>'.
	 * @see org.omg.spec.xmi._20110701.TargetType
	 * @generated
	 */
	EClass getTargetType();

	/**
	 * Returns the meta object for the attribute list '{@link org.omg.spec.xmi._20110701.TargetType#getGroup <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Group</em>'.
	 * @see org.omg.spec.xmi._20110701.TargetType#getGroup()
	 * @see #getTargetType()
	 * @generated
	 */
	EAttribute getTargetType_Group();

	/**
	 * Returns the meta object for the attribute list '{@link org.omg.spec.xmi._20110701.TargetType#getAny <em>Any</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any</em>'.
	 * @see org.omg.spec.xmi._20110701.TargetType#getAny()
	 * @see #getTargetType()
	 * @generated
	 */
	EAttribute getTargetType_Any();

	/**
	 * Returns the meta object for the attribute list '{@link org.omg.spec.xmi._20110701.TargetType#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see org.omg.spec.xmi._20110701.TargetType#getAnyAttribute()
	 * @see #getTargetType()
	 * @generated
	 */
	EAttribute getTargetType_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link org.omg.spec.xmi._20110701.XMI <em>XMI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XMI</em>'.
	 * @see org.omg.spec.xmi._20110701.XMI
	 * @generated
	 */
	EClass getXMI();

	/**
	 * Returns the meta object for the attribute list '{@link org.omg.spec.xmi._20110701.XMI#getGroup <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Group</em>'.
	 * @see org.omg.spec.xmi._20110701.XMI#getGroup()
	 * @see #getXMI()
	 * @generated
	 */
	EAttribute getXMI_Group();

	/**
	 * Returns the meta object for the attribute list '{@link org.omg.spec.xmi._20110701.XMI#getAny <em>Any</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any</em>'.
	 * @see org.omg.spec.xmi._20110701.XMI#getAny()
	 * @see #getXMI()
	 * @generated
	 */
	EAttribute getXMI_Any();

	/**
	 * Returns the meta object for the attribute '{@link org.omg.spec.xmi._20110701.XMI#getHref <em>Href</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Href</em>'.
	 * @see org.omg.spec.xmi._20110701.XMI#getHref()
	 * @see #getXMI()
	 * @generated
	 */
	EAttribute getXMI_Href();

	/**
	 * Returns the meta object for the attribute '{@link org.omg.spec.xmi._20110701.XMI#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.omg.spec.xmi._20110701.XMI#getId()
	 * @see #getXMI()
	 * @generated
	 */
	EAttribute getXMI_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.omg.spec.xmi._20110701.XMI#getIdref <em>Idref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Idref</em>'.
	 * @see org.omg.spec.xmi._20110701.XMI#getIdref()
	 * @see #getXMI()
	 * @generated
	 */
	EAttribute getXMI_Idref();

	/**
	 * Returns the meta object for the attribute '{@link org.omg.spec.xmi._20110701.XMI#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label</em>'.
	 * @see org.omg.spec.xmi._20110701.XMI#getLabel()
	 * @see #getXMI()
	 * @generated
	 */
	EAttribute getXMI_Label();

	/**
	 * Returns the meta object for the attribute '{@link org.omg.spec.xmi._20110701.XMI#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.omg.spec.xmi._20110701.XMI#getType()
	 * @see #getXMI()
	 * @generated
	 */
	EAttribute getXMI_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.omg.spec.xmi._20110701.XMI#getUuid <em>Uuid</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uuid</em>'.
	 * @see org.omg.spec.xmi._20110701.XMI#getUuid()
	 * @see #getXMI()
	 * @generated
	 */
	EAttribute getXMI_Uuid();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	_20110701Factory get_20110701Factory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.omg.spec.xmi._20110701.impl.AddImpl <em>Add</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.spec.xmi._20110701.impl.AddImpl
		 * @see org.omg.spec.xmi._20110701.impl._20110701PackageImpl#getAdd()
		 * @generated
		 */
		EClass ADD = eINSTANCE.getAdd();

		/**
		 * The meta object literal for the '<em><b>Addition</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADD__ADDITION = eINSTANCE.getAdd_Addition();

		/**
		 * The meta object literal for the '<em><b>Position</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADD__POSITION = eINSTANCE.getAdd_Position();

		/**
		 * The meta object literal for the '{@link org.omg.spec.xmi._20110701.impl.AnyImpl <em>Any</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.spec.xmi._20110701.impl.AnyImpl
		 * @see org.omg.spec.xmi._20110701.impl._20110701PackageImpl#getAny()
		 * @generated
		 */
		EClass ANY = eINSTANCE.getAny();

		/**
		 * The meta object literal for the '<em><b>Group</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANY__GROUP = eINSTANCE.getAny_Group();

		/**
		 * The meta object literal for the '<em><b>Any</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANY__ANY = eINSTANCE.getAny_Any();

		/**
		 * The meta object literal for the '<em><b>Any Attribute</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANY__ANY_ATTRIBUTE = eINSTANCE.getAny_AnyAttribute();

		/**
		 * The meta object literal for the '{@link org.omg.spec.xmi._20110701.impl.DeleteImpl <em>Delete</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.spec.xmi._20110701.impl.DeleteImpl
		 * @see org.omg.spec.xmi._20110701.impl._20110701PackageImpl#getDelete()
		 * @generated
		 */
		EClass DELETE = eINSTANCE.getDelete();

		/**
		 * The meta object literal for the '{@link org.omg.spec.xmi._20110701.impl.DifferenceImpl <em>Difference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.spec.xmi._20110701.impl.DifferenceImpl
		 * @see org.omg.spec.xmi._20110701.impl._20110701PackageImpl#getDifference()
		 * @generated
		 */
		EClass DIFFERENCE = eINSTANCE.getDifference();

		/**
		 * The meta object literal for the '<em><b>Group</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIFFERENCE__GROUP = eINSTANCE.getDifference_Group();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIFFERENCE__TARGET = eINSTANCE.getDifference_Target();

		/**
		 * The meta object literal for the '<em><b>Difference</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIFFERENCE__DIFFERENCE = eINSTANCE.getDifference_Difference();

		/**
		 * The meta object literal for the '<em><b>Container</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIFFERENCE__CONTAINER = eINSTANCE.getDifference_Container();

		/**
		 * The meta object literal for the '<em><b>Extension</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIFFERENCE__EXTENSION = eINSTANCE.getDifference_Extension();

		/**
		 * The meta object literal for the '<em><b>Container1</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIFFERENCE__CONTAINER1 = eINSTANCE.getDifference_Container1();

		/**
		 * The meta object literal for the '<em><b>Href</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIFFERENCE__HREF = eINSTANCE.getDifference_Href();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIFFERENCE__ID = eINSTANCE.getDifference_Id();

		/**
		 * The meta object literal for the '<em><b>Idref</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIFFERENCE__IDREF = eINSTANCE.getDifference_Idref();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIFFERENCE__LABEL = eINSTANCE.getDifference_Label();

		/**
		 * The meta object literal for the '<em><b>Target1</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIFFERENCE__TARGET1 = eINSTANCE.getDifference_Target1();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIFFERENCE__TYPE = eINSTANCE.getDifference_Type();

		/**
		 * The meta object literal for the '<em><b>Uuid</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIFFERENCE__UUID = eINSTANCE.getDifference_Uuid();

		/**
		 * The meta object literal for the '{@link org.omg.spec.xmi._20110701.impl.DocumentationImpl <em>Documentation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.spec.xmi._20110701.impl.DocumentationImpl
		 * @see org.omg.spec.xmi._20110701.impl._20110701PackageImpl#getDocumentation()
		 * @generated
		 */
		EClass DOCUMENTATION = eINSTANCE.getDocumentation();

		/**
		 * The meta object literal for the '<em><b>Group</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENTATION__GROUP = eINSTANCE.getDocumentation_Group();

		/**
		 * The meta object literal for the '<em><b>Contact</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENTATION__CONTACT = eINSTANCE.getDocumentation_Contact();

		/**
		 * The meta object literal for the '<em><b>Exporter</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENTATION__EXPORTER = eINSTANCE.getDocumentation_Exporter();

		/**
		 * The meta object literal for the '<em><b>Exporter Version</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENTATION__EXPORTER_VERSION = eINSTANCE.getDocumentation_ExporterVersion();

		/**
		 * The meta object literal for the '<em><b>Long Description</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENTATION__LONG_DESCRIPTION = eINSTANCE.getDocumentation_LongDescription();

		/**
		 * The meta object literal for the '<em><b>Short Description</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENTATION__SHORT_DESCRIPTION = eINSTANCE.getDocumentation_ShortDescription();

		/**
		 * The meta object literal for the '<em><b>Notice</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENTATION__NOTICE = eINSTANCE.getDocumentation_Notice();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENTATION__OWNER = eINSTANCE.getDocumentation_Owner();

		/**
		 * The meta object literal for the '<em><b>Timestamp</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENTATION__TIMESTAMP = eINSTANCE.getDocumentation_Timestamp();

		/**
		 * The meta object literal for the '<em><b>Extension</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENTATION__EXTENSION = eINSTANCE.getDocumentation_Extension();

		/**
		 * The meta object literal for the '<em><b>Href</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENTATION__HREF = eINSTANCE.getDocumentation_Href();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENTATION__ID = eINSTANCE.getDocumentation_Id();

		/**
		 * The meta object literal for the '<em><b>Idref</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENTATION__IDREF = eINSTANCE.getDocumentation_Idref();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENTATION__LABEL = eINSTANCE.getDocumentation_Label();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENTATION__TYPE = eINSTANCE.getDocumentation_Type();

		/**
		 * The meta object literal for the '<em><b>Uuid</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENTATION__UUID = eINSTANCE.getDocumentation_Uuid();

		/**
		 * The meta object literal for the '{@link org.omg.spec.xmi._20110701.impl.DocumentRootImpl <em>Document Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.spec.xmi._20110701.impl.DocumentRootImpl
		 * @see org.omg.spec.xmi._20110701.impl._20110701PackageImpl#getDocumentRoot()
		 * @generated
		 */
		EClass DOCUMENT_ROOT = eINSTANCE.getDocumentRoot();

		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_ROOT__MIXED = eINSTANCE.getDocumentRoot_Mixed();

		/**
		 * The meta object literal for the '<em><b>XMLNS Prefix Map</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__XMLNS_PREFIX_MAP = eINSTANCE.getDocumentRoot_XMLNSPrefixMap();

		/**
		 * The meta object literal for the '<em><b>XSI Schema Location</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__XSI_SCHEMA_LOCATION = eINSTANCE.getDocumentRoot_XSISchemaLocation();

		/**
		 * The meta object literal for the '<em><b>Add</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__ADD = eINSTANCE.getDocumentRoot_Add();

		/**
		 * The meta object literal for the '<em><b>Delete</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__DELETE = eINSTANCE.getDocumentRoot_Delete();

		/**
		 * The meta object literal for the '<em><b>Difference</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__DIFFERENCE = eINSTANCE.getDocumentRoot_Difference();

		/**
		 * The meta object literal for the '<em><b>Difference1</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__DIFFERENCE1 = eINSTANCE.getDocumentRoot_Difference1();

		/**
		 * The meta object literal for the '<em><b>Documentation</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__DOCUMENTATION = eINSTANCE.getDocumentRoot_Documentation();

		/**
		 * The meta object literal for the '<em><b>Documentation1</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__DOCUMENTATION1 = eINSTANCE.getDocumentRoot_Documentation1();

		/**
		 * The meta object literal for the '<em><b>Extension</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__EXTENSION = eINSTANCE.getDocumentRoot_Extension();

		/**
		 * The meta object literal for the '<em><b>Extension1</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__EXTENSION1 = eINSTANCE.getDocumentRoot_Extension1();

		/**
		 * The meta object literal for the '<em><b>Replace</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__REPLACE = eINSTANCE.getDocumentRoot_Replace();

		/**
		 * The meta object literal for the '<em><b>XMI</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__XMI = eINSTANCE.getDocumentRoot_XMI();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_ROOT__ID = eINSTANCE.getDocumentRoot_Id();

		/**
		 * The meta object literal for the '{@link org.omg.spec.xmi._20110701.impl.ExtensionImpl <em>Extension</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.spec.xmi._20110701.impl.ExtensionImpl
		 * @see org.omg.spec.xmi._20110701.impl._20110701PackageImpl#getExtension()
		 * @generated
		 */
		EClass EXTENSION = eINSTANCE.getExtension();

		/**
		 * The meta object literal for the '<em><b>Group</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTENSION__GROUP = eINSTANCE.getExtension_Group();

		/**
		 * The meta object literal for the '<em><b>Any</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTENSION__ANY = eINSTANCE.getExtension_Any();

		/**
		 * The meta object literal for the '<em><b>Extender</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTENSION__EXTENDER = eINSTANCE.getExtension_Extender();

		/**
		 * The meta object literal for the '<em><b>Extender ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTENSION__EXTENDER_ID = eINSTANCE.getExtension_ExtenderID();

		/**
		 * The meta object literal for the '<em><b>Href</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTENSION__HREF = eINSTANCE.getExtension_Href();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTENSION__ID = eINSTANCE.getExtension_Id();

		/**
		 * The meta object literal for the '<em><b>Idref</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTENSION__IDREF = eINSTANCE.getExtension_Idref();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTENSION__LABEL = eINSTANCE.getExtension_Label();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTENSION__TYPE = eINSTANCE.getExtension_Type();

		/**
		 * The meta object literal for the '<em><b>Uuid</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTENSION__UUID = eINSTANCE.getExtension_Uuid();

		/**
		 * The meta object literal for the '{@link org.omg.spec.xmi._20110701.impl.ReplaceImpl <em>Replace</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.spec.xmi._20110701.impl.ReplaceImpl
		 * @see org.omg.spec.xmi._20110701.impl._20110701PackageImpl#getReplace()
		 * @generated
		 */
		EClass REPLACE = eINSTANCE.getReplace();

		/**
		 * The meta object literal for the '<em><b>Position</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REPLACE__POSITION = eINSTANCE.getReplace_Position();

		/**
		 * The meta object literal for the '<em><b>Replacement</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REPLACE__REPLACEMENT = eINSTANCE.getReplace_Replacement();

		/**
		 * The meta object literal for the '{@link org.omg.spec.xmi._20110701.impl.TargetTypeImpl <em>Target Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.spec.xmi._20110701.impl.TargetTypeImpl
		 * @see org.omg.spec.xmi._20110701.impl._20110701PackageImpl#getTargetType()
		 * @generated
		 */
		EClass TARGET_TYPE = eINSTANCE.getTargetType();

		/**
		 * The meta object literal for the '<em><b>Group</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TARGET_TYPE__GROUP = eINSTANCE.getTargetType_Group();

		/**
		 * The meta object literal for the '<em><b>Any</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TARGET_TYPE__ANY = eINSTANCE.getTargetType_Any();

		/**
		 * The meta object literal for the '<em><b>Any Attribute</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TARGET_TYPE__ANY_ATTRIBUTE = eINSTANCE.getTargetType_AnyAttribute();

		/**
		 * The meta object literal for the '{@link org.omg.spec.xmi._20110701.impl.XMIImpl <em>XMI</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.spec.xmi._20110701.impl.XMIImpl
		 * @see org.omg.spec.xmi._20110701.impl._20110701PackageImpl#getXMI()
		 * @generated
		 */
		EClass XMI = eINSTANCE.getXMI();

		/**
		 * The meta object literal for the '<em><b>Group</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XMI__GROUP = eINSTANCE.getXMI_Group();

		/**
		 * The meta object literal for the '<em><b>Any</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XMI__ANY = eINSTANCE.getXMI_Any();

		/**
		 * The meta object literal for the '<em><b>Href</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XMI__HREF = eINSTANCE.getXMI_Href();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XMI__ID = eINSTANCE.getXMI_Id();

		/**
		 * The meta object literal for the '<em><b>Idref</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XMI__IDREF = eINSTANCE.getXMI_Idref();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XMI__LABEL = eINSTANCE.getXMI_Label();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XMI__TYPE = eINSTANCE.getXMI_Type();

		/**
		 * The meta object literal for the '<em><b>Uuid</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XMI__UUID = eINSTANCE.getXMI_Uuid();

	}

} //_20110701Package
