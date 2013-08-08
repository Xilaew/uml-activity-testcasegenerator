/**
 */
package org.xilaew.atg.model.tcgoclfunctionlib;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Function Library</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xilaew.atg.model.tcgoclfunctionlib.FunctionLibrary#getFunction <em>Function</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xilaew.atg.model.tcgoclfunctionlib.TcgoclfunctionlibPackage#getFunctionLibrary()
 * @model
 * @generated
 */
public interface FunctionLibrary extends EObject {
	/**
	 * Returns the value of the '<em><b>Function</b></em>' containment reference list.
	 * The list contents are of type {@link org.xilaew.atg.model.tcgoclfunctionlib.TcgOclFunction}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Function</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Function</em>' containment reference list.
	 * @see org.xilaew.atg.model.tcgoclfunctionlib.TcgoclfunctionlibPackage#getFunctionLibrary_Function()
	 * @model containment="true" keys="oclLiteral"
	 * @generated
	 */
	EList<TcgOclFunction> getFunction();

} // FunctionLibrary
