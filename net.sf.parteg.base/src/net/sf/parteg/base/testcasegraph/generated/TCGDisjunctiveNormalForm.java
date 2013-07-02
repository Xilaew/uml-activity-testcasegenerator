/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.sf.parteg.base.testcasegraph.generated;

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
 *   <li>{@link net.sf.parteg.base.testcasegraph.generated.TCGDisjunctiveNormalForm#getConjunctions <em>Conjunctions</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasegraph.generated.TCGDisjunctiveNormalForm#getOriginalExpression <em>Original Expression</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasegraph.generated.TCGDisjunctiveNormalForm#isUseForTestGoals <em>Use For Test Goals</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.sf.parteg.base.testcasegraph.generated.GeneratedPackage#getTCGDisjunctiveNormalForm()
 * @model
 * @generated
 */
public interface TCGDisjunctiveNormalForm extends EObject {
	/**
	 * Returns the value of the '<em><b>Conjunctions</b></em>' reference list.
	 * The list contents are of type {@link net.sf.parteg.base.testcasegraph.generated.TCGConjunction}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Conjunctions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Conjunctions</em>' reference list.
	 * @see net.sf.parteg.base.testcasegraph.generated.GeneratedPackage#getTCGDisjunctiveNormalForm_Conjunctions()
	 * @model
	 * @generated
	 */
	EList<TCGConjunction> getConjunctions();

	/**
	 * Returns the value of the '<em><b>Original Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Original Expression</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Original Expression</em>' reference.
	 * @see #setOriginalExpression(TCGOCLExpression)
	 * @see net.sf.parteg.base.testcasegraph.generated.GeneratedPackage#getTCGDisjunctiveNormalForm_OriginalExpression()
	 * @model
	 * @generated
	 */
	TCGOCLExpression getOriginalExpression();

	/**
	 * Sets the value of the '{@link net.sf.parteg.base.testcasegraph.generated.TCGDisjunctiveNormalForm#getOriginalExpression <em>Original Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Original Expression</em>' reference.
	 * @see #getOriginalExpression()
	 * @generated
	 */
	void setOriginalExpression(TCGOCLExpression value);

	/**
	 * Returns the value of the '<em><b>Use For Test Goals</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Use For Test Goals</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Use For Test Goals</em>' attribute.
	 * @see #setUseForTestGoals(boolean)
	 * @see net.sf.parteg.base.testcasegraph.generated.GeneratedPackage#getTCGDisjunctiveNormalForm_UseForTestGoals()
	 * @model default="true" required="true"
	 * @generated
	 */
	boolean isUseForTestGoals();

	/**
	 * Sets the value of the '{@link net.sf.parteg.base.testcasegraph.generated.TCGDisjunctiveNormalForm#isUseForTestGoals <em>Use For Test Goals</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Use For Test Goals</em>' attribute.
	 * @see #isUseForTestGoals()
	 * @generated
	 */
	void setUseForTestGoals(boolean value);

} // TCGDisjunctiveNormalForm
