/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.sf.parteg.base.testcasetree.generated;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TCG Disjunctive Normal Form</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.sf.parteg.base.testcasetree.generated.TCGDisjunctiveNormalForm#getConjunctions <em>Conjunctions</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.sf.parteg.base.testcasetree.generated.GeneratedPackage#getTCGDisjunctiveNormalForm()
 * @model
 * @generated
 */
public interface TCGDisjunctiveNormalForm extends EObject {
	/**
	 * Returns the value of the '<em><b>Conjunctions</b></em>' reference list.
	 * The list contents are of type {@link net.sf.parteg.base.testcasetree.generated.TCGConjunction}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Conjunctions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Conjunctions</em>' reference list.
	 * @see net.sf.parteg.base.testcasetree.generated.GeneratedPackage#getTCGDisjunctiveNormalForm_Conjunctions()
	 * @model
	 * @generated
	 */
	EList<TCGConjunction> getConjunctions();

} // TCGDisjunctiveNormalForm
