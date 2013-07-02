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
 * A representation of the model object '<em><b>TCGOCL Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.sf.parteg.base.testcasetree.generated.TCGOCLExpression#getClassification <em>Classification</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasetree.generated.TCGOCLExpression#getOclReference <em>Ocl Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.sf.parteg.base.testcasetree.generated.GeneratedPackage#getTCGOCLExpression()
 * @model
 * @generated
 */
public interface TCGOCLExpression extends EObject {
	/**
	 * Returns the value of the '<em><b>Classification</b></em>' attribute.
	 * The literals are from the enumeration {@link net.sf.parteg.base.testcasetree.generated.VariableClassification}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Classification</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Classification</em>' attribute.
	 * @see net.sf.parteg.base.testcasetree.generated.VariableClassification
	 * @see #setClassification(VariableClassification)
	 * @see net.sf.parteg.base.testcasetree.generated.GeneratedPackage#getTCGOCLExpression_Classification()
	 * @model required="true"
	 * @generated
	 */
	VariableClassification getClassification();

	/**
	 * Sets the value of the '{@link net.sf.parteg.base.testcasetree.generated.TCGOCLExpression#getClassification <em>Classification</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Classification</em>' attribute.
	 * @see net.sf.parteg.base.testcasetree.generated.VariableClassification
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
	 * @see net.sf.parteg.base.testcasetree.generated.GeneratedPackage#getTCGOCLExpression_OclReference()
	 * @model
	 * @generated
	 */
	EObject getOclReference();

	/**
	 * Sets the value of the '{@link net.sf.parteg.base.testcasetree.generated.TCGOCLExpression#getOclReference <em>Ocl Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ocl Reference</em>' reference.
	 * @see #getOclReference()
	 * @generated
	 */
	void setOclReference(EObject value);

} // TCGOCLExpression
