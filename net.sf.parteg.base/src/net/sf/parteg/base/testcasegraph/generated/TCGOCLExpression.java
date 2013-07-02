/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.sf.parteg.base.testcasegraph.generated;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TCGOCL Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.sf.parteg.base.testcasegraph.generated.TCGOCLExpression#getClassification <em>Classification</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasegraph.generated.TCGOCLExpression#getOclReference <em>Ocl Reference</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasegraph.generated.TCGOCLExpression#getContainer <em>Container</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasegraph.generated.TCGOCLExpression#isPositiveAssignmentOfOriginal <em>Positive Assignment Of Original</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasegraph.generated.TCGOCLExpression#getTransitionContext <em>Transition Context</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.sf.parteg.base.testcasegraph.generated.GeneratedPackage#getTCGOCLExpression()
 * @model
 * @generated
 */
public interface TCGOCLExpression extends EObject {
	/**
	 * Returns the value of the '<em><b>Classification</b></em>' attribute.
	 * The literals are from the enumeration {@link net.sf.parteg.base.testcasegraph.generated.VariableClassification}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Classification</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Classification</em>' attribute.
	 * @see net.sf.parteg.base.testcasegraph.generated.VariableClassification
	 * @see #setClassification(VariableClassification)
	 * @see net.sf.parteg.base.testcasegraph.generated.GeneratedPackage#getTCGOCLExpression_Classification()
	 * @model required="true"
	 * @generated
	 */
	VariableClassification getClassification();

	/**
	 * Sets the value of the '{@link net.sf.parteg.base.testcasegraph.generated.TCGOCLExpression#getClassification <em>Classification</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Classification</em>' attribute.
	 * @see net.sf.parteg.base.testcasegraph.generated.VariableClassification
	 * @see #getClassification()
	 * @generated
	 */
	void setClassification(VariableClassification value);

	/**
	 * Returns the value of the '<em><b>Ocl Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ocl Reference</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ocl Reference</em>' reference.
	 * @see #setOclReference(EObject)
	 * @see net.sf.parteg.base.testcasegraph.generated.GeneratedPackage#getTCGOCLExpression_OclReference()
	 * @model
	 * @generated
	 */
	EObject getOclReference();

	/**
	 * Sets the value of the '{@link net.sf.parteg.base.testcasegraph.generated.TCGOCLExpression#getOclReference <em>Ocl Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ocl Reference</em>' reference.
	 * @see #getOclReference()
	 * @generated
	 */
	void setOclReference(EObject value);

	/**
	 * Returns the value of the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Container</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Container</em>' reference.
	 * @see #setContainer(TCGElement)
	 * @see net.sf.parteg.base.testcasegraph.generated.GeneratedPackage#getTCGOCLExpression_Container()
	 * @model required="true"
	 * @generated
	 */
	TCGElement getContainer();

	/**
	 * Sets the value of the '{@link net.sf.parteg.base.testcasegraph.generated.TCGOCLExpression#getContainer <em>Container</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Container</em>' reference.
	 * @see #getContainer()
	 * @generated
	 */
	void setContainer(TCGElement value);

	/**
	 * Returns the value of the '<em><b>Positive Assignment Of Original</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Positive Assignment Of Original</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Positive Assignment Of Original</em>' attribute.
	 * @see #setPositiveAssignmentOfOriginal(boolean)
	 * @see net.sf.parteg.base.testcasegraph.generated.GeneratedPackage#getTCGOCLExpression_PositiveAssignmentOfOriginal()
	 * @model default="true" required="true"
	 * @generated
	 */
	boolean isPositiveAssignmentOfOriginal();

	/**
	 * Sets the value of the '{@link net.sf.parteg.base.testcasegraph.generated.TCGOCLExpression#isPositiveAssignmentOfOriginal <em>Positive Assignment Of Original</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Positive Assignment Of Original</em>' attribute.
	 * @see #isPositiveAssignmentOfOriginal()
	 * @generated
	 */
	void setPositiveAssignmentOfOriginal(boolean value);

	/**
	 * Returns the value of the '<em><b>Transition Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transition Context</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transition Context</em>' reference.
	 * @see #setTransitionContext(TCGTransition)
	 * @see net.sf.parteg.base.testcasegraph.generated.GeneratedPackage#getTCGOCLExpression_TransitionContext()
	 * @model
	 * @generated
	 */
	TCGTransition getTransitionContext();

	/**
	 * Sets the value of the '{@link net.sf.parteg.base.testcasegraph.generated.TCGOCLExpression#getTransitionContext <em>Transition Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transition Context</em>' reference.
	 * @see #getTransitionContext()
	 * @generated
	 */
	void setTransitionContext(TCGTransition value);

} // TCGOCLExpression
