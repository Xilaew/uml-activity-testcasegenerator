/**
 */
package org.omg.spec.xmi._20110701;

import java.math.BigInteger;

import java.util.List;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Add</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.omg.spec.xmi._20110701.Add#getAddition <em>Addition</em>}</li>
 *   <li>{@link org.omg.spec.xmi._20110701.Add#getPosition <em>Position</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.omg.spec.xmi._20110701._20110701Package#getAdd()
 * @model extendedMetaData="name='Add' kind='elementOnly'"
 * @generated
 */
public interface Add extends Difference {
	/**
	 * Returns the value of the '<em><b>Addition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Addition</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Addition</em>' attribute.
	 * @see #setAddition(List)
	 * @see org.omg.spec.xmi._20110701._20110701Package#getAdd_Addition()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.IDREFS" many="false"
	 *        extendedMetaData="kind='attribute' name='addition'"
	 * @generated
	 */
	List<String> getAddition();

	/**
	 * Sets the value of the '{@link org.omg.spec.xmi._20110701.Add#getAddition <em>Addition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Addition</em>' attribute.
	 * @see #getAddition()
	 * @generated
	 */
	void setAddition(List<String> value);

	/**
	 * Returns the value of the '<em><b>Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Position</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Position</em>' attribute.
	 * @see #setPosition(BigInteger)
	 * @see org.omg.spec.xmi._20110701._20110701Package#getAdd_Position()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Integer"
	 *        extendedMetaData="kind='attribute' name='position'"
	 * @generated
	 */
	BigInteger getPosition();

	/**
	 * Sets the value of the '{@link org.omg.spec.xmi._20110701.Add#getPosition <em>Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Position</em>' attribute.
	 * @see #getPosition()
	 * @generated
	 */
	void setPosition(BigInteger value);

} // Add
