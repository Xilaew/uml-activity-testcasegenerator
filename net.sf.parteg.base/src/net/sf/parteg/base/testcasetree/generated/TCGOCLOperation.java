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
 * A representation of the model object '<em><b>TCGOCL Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.sf.parteg.base.testcasetree.generated.TCGOCLOperation#getLeft <em>Left</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasetree.generated.TCGOCLOperation#getRight <em>Right</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasetree.generated.TCGOCLOperation#getOperation <em>Operation</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasetree.generated.TCGOCLOperation#getOperationName <em>Operation Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.sf.parteg.base.testcasetree.generated.GeneratedPackage#getTCGOCLOperation()
 * @model
 * @generated
 */
public interface TCGOCLOperation extends TCGOCLExpression {
	/**
	 * Returns the value of the '<em><b>Left</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Left</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left</em>' reference.
	 * @see #setLeft(TCGOCLExpression)
	 * @see net.sf.parteg.base.testcasetree.generated.GeneratedPackage#getTCGOCLOperation_Left()
	 * @model
	 * @generated
	 */
	TCGOCLExpression getLeft();

	/**
	 * Sets the value of the '{@link net.sf.parteg.base.testcasetree.generated.TCGOCLOperation#getLeft <em>Left</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left</em>' reference.
	 * @see #getLeft()
	 * @generated
	 */
	void setLeft(TCGOCLExpression value);

	/**
	 * Returns the value of the '<em><b>Right</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Right</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right</em>' reference.
	 * @see #setRight(TCGOCLExpression)
	 * @see net.sf.parteg.base.testcasetree.generated.GeneratedPackage#getTCGOCLOperation_Right()
	 * @model
	 * @generated
	 */
	TCGOCLExpression getRight();

	/**
	 * Sets the value of the '{@link net.sf.parteg.base.testcasetree.generated.TCGOCLOperation#getRight <em>Right</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right</em>' reference.
	 * @see #getRight()
	 * @generated
	 */
	void setRight(TCGOCLExpression value);

	/**
	 * Returns the value of the '<em><b>Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation</em>' reference.
	 * @see #setOperation(EObject)
	 * @see net.sf.parteg.base.testcasetree.generated.GeneratedPackage#getTCGOCLOperation_Operation()
	 * @model
	 * @generated
	 */
	EObject getOperation();

	/**
	 * Sets the value of the '{@link net.sf.parteg.base.testcasetree.generated.TCGOCLOperation#getOperation <em>Operation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation</em>' reference.
	 * @see #getOperation()
	 * @generated
	 */
	void setOperation(EObject value);

	/**
	 * Returns the value of the '<em><b>Operation Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operation Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation Name</em>' attribute.
	 * @see #setOperationName(String)
	 * @see net.sf.parteg.base.testcasetree.generated.GeneratedPackage#getTCGOCLOperation_OperationName()
	 * @model
	 * @generated
	 */
	String getOperationName();

	/**
	 * Sets the value of the '{@link net.sf.parteg.base.testcasetree.generated.TCGOCLOperation#getOperationName <em>Operation Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation Name</em>' attribute.
	 * @see #getOperationName()
	 * @generated
	 */
	void setOperationName(String value);

} // TCGOCLOperation
