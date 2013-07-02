/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.sf.parteg.base.testcasetree.generated;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TCG Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.sf.parteg.base.testcasetree.generated.TCGParameter#getName <em>Name</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasetree.generated.TCGParameter#getType <em>Type</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasetree.generated.TCGParameter#getReference <em>Reference</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasetree.generated.TCGParameter#getDefiningTransition <em>Defining Transition</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasetree.generated.TCGParameter#getContainer <em>Container</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.sf.parteg.base.testcasetree.generated.GeneratedPackage#getTCGParameter()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface TCGParameter extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see net.sf.parteg.base.testcasetree.generated.GeneratedPackage#getTCGParameter_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link net.sf.parteg.base.testcasetree.generated.TCGParameter#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(EObject)
	 * @see net.sf.parteg.base.testcasetree.generated.GeneratedPackage#getTCGParameter_Type()
	 * @model required="true"
	 * @generated
	 */
	EObject getType();

	/**
	 * Sets the value of the '{@link net.sf.parteg.base.testcasetree.generated.TCGParameter#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(EObject value);

	/**
	 * Returns the value of the '<em><b>Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reference</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reference</em>' reference.
	 * @see #setReference(EObject)
	 * @see net.sf.parteg.base.testcasetree.generated.GeneratedPackage#getTCGParameter_Reference()
	 * @model
	 * @generated
	 */
	EObject getReference();

	/**
	 * Sets the value of the '{@link net.sf.parteg.base.testcasetree.generated.TCGParameter#getReference <em>Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reference</em>' reference.
	 * @see #getReference()
	 * @generated
	 */
	void setReference(EObject value);

	/**
	 * Returns the value of the '<em><b>Defining Transition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Defining Transition</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Defining Transition</em>' reference.
	 * @see #setDefiningTransition(TCGTransition)
	 * @see net.sf.parteg.base.testcasetree.generated.GeneratedPackage#getTCGParameter_DefiningTransition()
	 * @model
	 * @generated
	 */
	TCGTransition getDefiningTransition();

	/**
	 * Sets the value of the '{@link net.sf.parteg.base.testcasetree.generated.TCGParameter#getDefiningTransition <em>Defining Transition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Defining Transition</em>' reference.
	 * @see #getDefiningTransition()
	 * @generated
	 */
	void setDefiningTransition(TCGTransition value);

	/**
	 * Returns the value of the '<em><b>Container</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link net.sf.parteg.base.testcasetree.generated.TCGComplexParameter#getParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Container</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Container</em>' reference.
	 * @see #setContainer(TCGComplexParameter)
	 * @see net.sf.parteg.base.testcasetree.generated.GeneratedPackage#getTCGParameter_Container()
	 * @see net.sf.parteg.base.testcasetree.generated.TCGComplexParameter#getParameter
	 * @model opposite="parameter"
	 * @generated
	 */
	TCGComplexParameter getContainer();

	/**
	 * Sets the value of the '{@link net.sf.parteg.base.testcasetree.generated.TCGParameter#getContainer <em>Container</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Container</em>' reference.
	 * @see #getContainer()
	 * @generated
	 */
	void setContainer(TCGComplexParameter value);

} // TCGParameter
