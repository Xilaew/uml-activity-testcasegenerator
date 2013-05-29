/**
 */
package org.omg.spec.xmi._20110701;

import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Document Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.omg.spec.xmi._20110701.DocumentRoot#getMixed <em>Mixed</em>}</li>
 *   <li>{@link org.omg.spec.xmi._20110701.DocumentRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link org.omg.spec.xmi._20110701.DocumentRoot#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link org.omg.spec.xmi._20110701.DocumentRoot#getAdd <em>Add</em>}</li>
 *   <li>{@link org.omg.spec.xmi._20110701.DocumentRoot#getDelete <em>Delete</em>}</li>
 *   <li>{@link org.omg.spec.xmi._20110701.DocumentRoot#getDifference <em>Difference</em>}</li>
 *   <li>{@link org.omg.spec.xmi._20110701.DocumentRoot#getDifference1 <em>Difference1</em>}</li>
 *   <li>{@link org.omg.spec.xmi._20110701.DocumentRoot#getDocumentation <em>Documentation</em>}</li>
 *   <li>{@link org.omg.spec.xmi._20110701.DocumentRoot#getDocumentation1 <em>Documentation1</em>}</li>
 *   <li>{@link org.omg.spec.xmi._20110701.DocumentRoot#getExtension <em>Extension</em>}</li>
 *   <li>{@link org.omg.spec.xmi._20110701.DocumentRoot#getExtension1 <em>Extension1</em>}</li>
 *   <li>{@link org.omg.spec.xmi._20110701.DocumentRoot#getReplace <em>Replace</em>}</li>
 *   <li>{@link org.omg.spec.xmi._20110701.DocumentRoot#getXMI <em>XMI</em>}</li>
 *   <li>{@link org.omg.spec.xmi._20110701.DocumentRoot#getId <em>Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.omg.spec.xmi._20110701._20110701Package#getDocumentRoot()
 * @model extendedMetaData="name='' kind='mixed'"
 * @generated
 */
public interface DocumentRoot extends EObject {
	/**
	 * Returns the value of the '<em><b>Mixed</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mixed</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mixed</em>' attribute list.
	 * @see org.omg.spec.xmi._20110701._20110701Package#getDocumentRoot_Mixed()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='elementWildcard' name=':mixed'"
	 * @generated
	 */
	FeatureMap getMixed();

	/**
	 * Returns the value of the '<em><b>XMLNS Prefix Map</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link java.lang.String},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>XMLNS Prefix Map</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>XMLNS Prefix Map</em>' map.
	 * @see org.omg.spec.xmi._20110701._20110701Package#getDocumentRoot_XMLNSPrefixMap()
	 * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EString>" transient="true"
	 *        extendedMetaData="kind='attribute' name='xmlns:prefix'"
	 * @generated
	 */
	EMap<String, String> getXMLNSPrefixMap();

	/**
	 * Returns the value of the '<em><b>XSI Schema Location</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link java.lang.String},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>XSI Schema Location</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>XSI Schema Location</em>' map.
	 * @see org.omg.spec.xmi._20110701._20110701Package#getDocumentRoot_XSISchemaLocation()
	 * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EString>" transient="true"
	 *        extendedMetaData="kind='attribute' name='xsi:schemaLocation'"
	 * @generated
	 */
	EMap<String, String> getXSISchemaLocation();

	/**
	 * Returns the value of the '<em><b>Add</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Add</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Add</em>' containment reference.
	 * @see #setAdd(Add)
	 * @see org.omg.spec.xmi._20110701._20110701Package#getDocumentRoot_Add()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='Add' namespace='##targetNamespace'"
	 * @generated
	 */
	Add getAdd();

	/**
	 * Sets the value of the '{@link org.omg.spec.xmi._20110701.DocumentRoot#getAdd <em>Add</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Add</em>' containment reference.
	 * @see #getAdd()
	 * @generated
	 */
	void setAdd(Add value);

	/**
	 * Returns the value of the '<em><b>Delete</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Delete</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Delete</em>' containment reference.
	 * @see #setDelete(Delete)
	 * @see org.omg.spec.xmi._20110701._20110701Package#getDocumentRoot_Delete()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='Delete' namespace='##targetNamespace'"
	 * @generated
	 */
	Delete getDelete();

	/**
	 * Sets the value of the '{@link org.omg.spec.xmi._20110701.DocumentRoot#getDelete <em>Delete</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Delete</em>' containment reference.
	 * @see #getDelete()
	 * @generated
	 */
	void setDelete(Delete value);

	/**
	 * Returns the value of the '<em><b>Difference</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Difference</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Difference</em>' containment reference.
	 * @see #setDifference(Difference)
	 * @see org.omg.spec.xmi._20110701._20110701Package#getDocumentRoot_Difference()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='difference' namespace='##targetNamespace'"
	 * @generated
	 */
	Difference getDifference();

	/**
	 * Sets the value of the '{@link org.omg.spec.xmi._20110701.DocumentRoot#getDifference <em>Difference</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Difference</em>' containment reference.
	 * @see #getDifference()
	 * @generated
	 */
	void setDifference(Difference value);

	/**
	 * Returns the value of the '<em><b>Difference1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Difference1</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Difference1</em>' containment reference.
	 * @see #setDifference1(Difference)
	 * @see org.omg.spec.xmi._20110701._20110701Package#getDocumentRoot_Difference1()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='Difference' namespace='##targetNamespace'"
	 * @generated
	 */
	Difference getDifference1();

	/**
	 * Sets the value of the '{@link org.omg.spec.xmi._20110701.DocumentRoot#getDifference1 <em>Difference1</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Difference1</em>' containment reference.
	 * @see #getDifference1()
	 * @generated
	 */
	void setDifference1(Difference value);

	/**
	 * Returns the value of the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Documentation</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Documentation</em>' containment reference.
	 * @see #setDocumentation(Documentation)
	 * @see org.omg.spec.xmi._20110701._20110701Package#getDocumentRoot_Documentation()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='documentation' namespace='##targetNamespace'"
	 * @generated
	 */
	Documentation getDocumentation();

	/**
	 * Sets the value of the '{@link org.omg.spec.xmi._20110701.DocumentRoot#getDocumentation <em>Documentation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Documentation</em>' containment reference.
	 * @see #getDocumentation()
	 * @generated
	 */
	void setDocumentation(Documentation value);

	/**
	 * Returns the value of the '<em><b>Documentation1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Documentation1</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Documentation1</em>' containment reference.
	 * @see #setDocumentation1(Documentation)
	 * @see org.omg.spec.xmi._20110701._20110701Package#getDocumentRoot_Documentation1()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='Documentation' namespace='##targetNamespace'"
	 * @generated
	 */
	Documentation getDocumentation1();

	/**
	 * Sets the value of the '{@link org.omg.spec.xmi._20110701.DocumentRoot#getDocumentation1 <em>Documentation1</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Documentation1</em>' containment reference.
	 * @see #getDocumentation1()
	 * @generated
	 */
	void setDocumentation1(Documentation value);

	/**
	 * Returns the value of the '<em><b>Extension</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extension</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extension</em>' containment reference.
	 * @see #setExtension(Extension)
	 * @see org.omg.spec.xmi._20110701._20110701Package#getDocumentRoot_Extension()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='extension' namespace='##targetNamespace'"
	 * @generated
	 */
	Extension getExtension();

	/**
	 * Sets the value of the '{@link org.omg.spec.xmi._20110701.DocumentRoot#getExtension <em>Extension</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extension</em>' containment reference.
	 * @see #getExtension()
	 * @generated
	 */
	void setExtension(Extension value);

	/**
	 * Returns the value of the '<em><b>Extension1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extension1</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extension1</em>' containment reference.
	 * @see #setExtension1(Extension)
	 * @see org.omg.spec.xmi._20110701._20110701Package#getDocumentRoot_Extension1()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='Extension' namespace='##targetNamespace'"
	 * @generated
	 */
	Extension getExtension1();

	/**
	 * Sets the value of the '{@link org.omg.spec.xmi._20110701.DocumentRoot#getExtension1 <em>Extension1</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extension1</em>' containment reference.
	 * @see #getExtension1()
	 * @generated
	 */
	void setExtension1(Extension value);

	/**
	 * Returns the value of the '<em><b>Replace</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Replace</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Replace</em>' containment reference.
	 * @see #setReplace(Replace)
	 * @see org.omg.spec.xmi._20110701._20110701Package#getDocumentRoot_Replace()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='Replace' namespace='##targetNamespace'"
	 * @generated
	 */
	Replace getReplace();

	/**
	 * Sets the value of the '{@link org.omg.spec.xmi._20110701.DocumentRoot#getReplace <em>Replace</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Replace</em>' containment reference.
	 * @see #getReplace()
	 * @generated
	 */
	void setReplace(Replace value);

	/**
	 * Returns the value of the '<em><b>XMI</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>XMI</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>XMI</em>' containment reference.
	 * @see #setXMI(XMI)
	 * @see org.omg.spec.xmi._20110701._20110701Package#getDocumentRoot_XMI()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='XMI' namespace='##targetNamespace'"
	 * @generated
	 */
	XMI getXMI();

	/**
	 * Sets the value of the '{@link org.omg.spec.xmi._20110701.DocumentRoot#getXMI <em>XMI</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>XMI</em>' containment reference.
	 * @see #getXMI()
	 * @generated
	 */
	void setXMI(XMI value);

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see org.omg.spec.xmi._20110701._20110701Package#getDocumentRoot_Id()
	 * @model id="true" dataType="org.eclipse.emf.ecore.xml.type.ID"
	 *        extendedMetaData="kind='attribute' name='id' namespace='##targetNamespace'"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link org.omg.spec.xmi._20110701.DocumentRoot#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

} // DocumentRoot
