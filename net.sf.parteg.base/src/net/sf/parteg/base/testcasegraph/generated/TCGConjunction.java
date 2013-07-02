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
 * A representation of the model object '<em><b>TCG Conjunction</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.sf.parteg.base.testcasegraph.generated.TCGConjunction#getExpressions <em>Expressions</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasegraph.generated.TCGConjunction#isCanChangeValueIfOneExpressionChanges <em>Can Change Value If One Expression Changes</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasegraph.generated.TCGConjunction#isPositiveSubExpressionOfOriginal <em>Positive Sub Expression Of Original</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.sf.parteg.base.testcasegraph.generated.GeneratedPackage#getTCGConjunction()
 * @model
 * @generated
 */
public interface TCGConjunction extends EObject {
	/**
	 * Returns the value of the '<em><b>Expressions</b></em>' reference list.
	 * The list contents are of type {@link net.sf.parteg.base.testcasegraph.generated.TCGOCLExpression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expressions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expressions</em>' reference list.
	 * @see net.sf.parteg.base.testcasegraph.generated.GeneratedPackage#getTCGConjunction_Expressions()
	 * @model required="true"
	 * @generated
	 */
	EList<TCGOCLExpression> getExpressions();

	/**
	 * Returns the value of the '<em><b>Can Change Value If One Expression Changes</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Can Change Value If One Expression Changes</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Can Change Value If One Expression Changes</em>' attribute.
	 * @see #setCanChangeValueIfOneExpressionChanges(boolean)
	 * @see net.sf.parteg.base.testcasegraph.generated.GeneratedPackage#getTCGConjunction_CanChangeValueIfOneExpressionChanges()
	 * @model default="true" required="true"
	 * @generated
	 */
	boolean isCanChangeValueIfOneExpressionChanges();

	/**
	 * Sets the value of the '{@link net.sf.parteg.base.testcasegraph.generated.TCGConjunction#isCanChangeValueIfOneExpressionChanges <em>Can Change Value If One Expression Changes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Can Change Value If One Expression Changes</em>' attribute.
	 * @see #isCanChangeValueIfOneExpressionChanges()
	 * @generated
	 */
	void setCanChangeValueIfOneExpressionChanges(boolean value);

	/**
	 * Returns the value of the '<em><b>Positive Sub Expression Of Original</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Positive Sub Expression Of Original</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Positive Sub Expression Of Original</em>' attribute.
	 * @see #setPositiveSubExpressionOfOriginal(boolean)
	 * @see net.sf.parteg.base.testcasegraph.generated.GeneratedPackage#getTCGConjunction_PositiveSubExpressionOfOriginal()
	 * @model default="true" required="true"
	 * @generated
	 */
	boolean isPositiveSubExpressionOfOriginal();

	/**
	 * Sets the value of the '{@link net.sf.parteg.base.testcasegraph.generated.TCGConjunction#isPositiveSubExpressionOfOriginal <em>Positive Sub Expression Of Original</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Positive Sub Expression Of Original</em>' attribute.
	 * @see #isPositiveSubExpressionOfOriginal()
	 * @generated
	 */
	void setPositiveSubExpressionOfOriginal(boolean value);

} // TCGConjunction
