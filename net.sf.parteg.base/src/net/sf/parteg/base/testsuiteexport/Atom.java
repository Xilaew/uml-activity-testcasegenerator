/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.sf.parteg.base.testsuiteexport;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Atom</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.sf.parteg.base.testsuiteexport.Atom#getExp <em>Exp</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.sf.parteg.base.testsuiteexport.TestsuiteexportPackage#getAtom()
 * @model
 * @generated
 */
public interface Atom extends Exp {
	/**
	 * Returns the value of the '<em><b>Exp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exp</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exp</em>' attribute.
	 * @see #setExp(String)
	 * @see net.sf.parteg.base.testsuiteexport.TestsuiteexportPackage#getAtom_Exp()
	 * @model required="true"
	 * @generated
	 */
	String getExp();

	/**
	 * Sets the value of the '{@link net.sf.parteg.base.testsuiteexport.Atom#getExp <em>Exp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exp</em>' attribute.
	 * @see #getExp()
	 * @generated
	 */
	void setExp(String value);

} // Atom
