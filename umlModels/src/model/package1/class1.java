/**
 */
package model.package1;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>class1</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link model.package1.class1#getAttribute1 <em>Attribute1</em>}</li>
 * </ul>
 * </p>
 *
 * @see model.package1.Package1Package#getclass1()
 * @model
 * @generated
 */
public interface class1 extends EObject {
	/**
	 * Returns the value of the '<em><b>Attribute1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute1</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute1</em>' reference.
	 * @see #setAttribute1(type1)
	 * @see model.package1.Package1Package#getclass1_Attribute1()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	type1 getAttribute1();

	/**
	 * Sets the value of the '{@link model.package1.class1#getAttribute1 <em>Attribute1</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attribute1</em>' reference.
	 * @see #getAttribute1()
	 * @generated
	 */
	void setAttribute1(type1 value);

} // class1
