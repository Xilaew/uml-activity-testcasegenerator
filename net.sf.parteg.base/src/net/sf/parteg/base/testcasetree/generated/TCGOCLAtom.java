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
 * A representation of the model object '<em><b>TCGOCL Atom</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.sf.parteg.base.testcasetree.generated.TCGOCLAtom#getElement <em>Element</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasetree.generated.TCGOCLAtom#getTcgParameter <em>Tcg Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.sf.parteg.base.testcasetree.generated.GeneratedPackage#getTCGOCLAtom()
 * @model
 * @generated
 */
public interface TCGOCLAtom extends TCGOCLExpression {
	/**
	 * Returns the value of the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element</em>' reference.
	 * @see #setElement(EObject)
	 * @see net.sf.parteg.base.testcasetree.generated.GeneratedPackage#getTCGOCLAtom_Element()
	 * @model
	 * @generated
	 */
	EObject getElement();

	/**
	 * Sets the value of the '{@link net.sf.parteg.base.testcasetree.generated.TCGOCLAtom#getElement <em>Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element</em>' reference.
	 * @see #getElement()
	 * @generated
	 */
	void setElement(EObject value);

	/**
	 * Returns the value of the '<em><b>Tcg Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tcg Parameter</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tcg Parameter</em>' reference.
	 * @see #setTcgParameter(EObject)
	 * @see net.sf.parteg.base.testcasetree.generated.GeneratedPackage#getTCGOCLAtom_TcgParameter()
	 * @model
	 * @generated
	 */
	EObject getTcgParameter();

	/**
	 * Sets the value of the '{@link net.sf.parteg.base.testcasetree.generated.TCGOCLAtom#getTcgParameter <em>Tcg Parameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tcg Parameter</em>' reference.
	 * @see #getTcgParameter()
	 * @generated
	 */
	void setTcgParameter(EObject value);

} // TCGOCLAtom
