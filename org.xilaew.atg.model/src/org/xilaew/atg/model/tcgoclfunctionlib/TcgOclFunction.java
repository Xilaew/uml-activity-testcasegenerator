/**
 */
package org.xilaew.atg.model.tcgoclfunctionlib;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tcg Ocl Function</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xilaew.atg.model.tcgoclfunctionlib.TcgOclFunction#getName <em>Name</em>}</li>
 *   <li>{@link org.xilaew.atg.model.tcgoclfunctionlib.TcgOclFunction#getAmplLiteral <em>Ampl Literal</em>}</li>
 *   <li>{@link org.xilaew.atg.model.tcgoclfunctionlib.TcgOclFunction#getOclLiteral <em>Ocl Literal</em>}</li>
 *   <li>{@link org.xilaew.atg.model.tcgoclfunctionlib.TcgOclFunction#getAmplCloseLiteral <em>Ampl Close Literal</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xilaew.atg.model.tcgoclfunctionlib.TcgoclfunctionlibPackage#getTcgOclFunction()
 * @model
 * @generated
 */
public interface TcgOclFunction extends EObject {
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
	 * @see org.xilaew.atg.model.tcgoclfunctionlib.TcgoclfunctionlibPackage#getTcgOclFunction_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.xilaew.atg.model.tcgoclfunctionlib.TcgOclFunction#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Ampl Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ampl Literal</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ampl Literal</em>' attribute.
	 * @see #setAmplLiteral(String)
	 * @see org.xilaew.atg.model.tcgoclfunctionlib.TcgoclfunctionlibPackage#getTcgOclFunction_AmplLiteral()
	 * @model
	 * @generated
	 */
	String getAmplLiteral();

	/**
	 * Sets the value of the '{@link org.xilaew.atg.model.tcgoclfunctionlib.TcgOclFunction#getAmplLiteral <em>Ampl Literal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ampl Literal</em>' attribute.
	 * @see #getAmplLiteral()
	 * @generated
	 */
	void setAmplLiteral(String value);

	/**
	 * Returns the value of the '<em><b>Ocl Literal</b></em>' attribute.
	 * The default value is <code>"\"\""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ocl Literal</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ocl Literal</em>' attribute.
	 * @see #setOclLiteral(String)
	 * @see org.xilaew.atg.model.tcgoclfunctionlib.TcgoclfunctionlibPackage#getTcgOclFunction_OclLiteral()
	 * @model default="\"\""
	 * @generated
	 */
	String getOclLiteral();

	/**
	 * Sets the value of the '{@link org.xilaew.atg.model.tcgoclfunctionlib.TcgOclFunction#getOclLiteral <em>Ocl Literal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ocl Literal</em>' attribute.
	 * @see #getOclLiteral()
	 * @generated
	 */
	void setOclLiteral(String value);

	/**
	 * Returns the value of the '<em><b>Ampl Close Literal</b></em>' attribute.
	 * The default value is <code>"\"\""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ampl Close Literal</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ampl Close Literal</em>' attribute.
	 * @see #setAmplCloseLiteral(String)
	 * @see org.xilaew.atg.model.tcgoclfunctionlib.TcgoclfunctionlibPackage#getTcgOclFunction_AmplCloseLiteral()
	 * @model default="\"\""
	 * @generated
	 */
	String getAmplCloseLiteral();

	/**
	 * Sets the value of the '{@link org.xilaew.atg.model.tcgoclfunctionlib.TcgOclFunction#getAmplCloseLiteral <em>Ampl Close Literal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ampl Close Literal</em>' attribute.
	 * @see #getAmplCloseLiteral()
	 * @generated
	 */
	void setAmplCloseLiteral(String value);

} // TcgOclFunction
