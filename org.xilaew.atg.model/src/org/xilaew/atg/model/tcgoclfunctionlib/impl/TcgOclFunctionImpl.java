/**
 */
package org.xilaew.atg.model.tcgoclfunctionlib.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.xilaew.atg.model.tcgoclfunctionlib.TcgOclFunction;
import org.xilaew.atg.model.tcgoclfunctionlib.TcgoclfunctionlibPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tcg Ocl Function</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.xilaew.atg.model.tcgoclfunctionlib.impl.TcgOclFunctionImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.xilaew.atg.model.tcgoclfunctionlib.impl.TcgOclFunctionImpl#getAmplLiteral <em>Ampl Literal</em>}</li>
 *   <li>{@link org.xilaew.atg.model.tcgoclfunctionlib.impl.TcgOclFunctionImpl#getOclLiteral <em>Ocl Literal</em>}</li>
 *   <li>{@link org.xilaew.atg.model.tcgoclfunctionlib.impl.TcgOclFunctionImpl#getAmplCloseLiteral <em>Ampl Close Literal</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TcgOclFunctionImpl extends MinimalEObjectImpl.Container implements TcgOclFunction {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getAmplLiteral() <em>Ampl Literal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAmplLiteral()
	 * @generated
	 * @ordered
	 */
	protected static final String AMPL_LITERAL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAmplLiteral() <em>Ampl Literal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAmplLiteral()
	 * @generated
	 * @ordered
	 */
	protected String amplLiteral = AMPL_LITERAL_EDEFAULT;

	/**
	 * The default value of the '{@link #getOclLiteral() <em>Ocl Literal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOclLiteral()
	 * @generated
	 * @ordered
	 */
	protected static final String OCL_LITERAL_EDEFAULT = "\"\"";

	/**
	 * The cached value of the '{@link #getOclLiteral() <em>Ocl Literal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOclLiteral()
	 * @generated
	 * @ordered
	 */
	protected String oclLiteral = OCL_LITERAL_EDEFAULT;

	/**
	 * The default value of the '{@link #getAmplCloseLiteral() <em>Ampl Close Literal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAmplCloseLiteral()
	 * @generated
	 * @ordered
	 */
	protected static final String AMPL_CLOSE_LITERAL_EDEFAULT = "\"\"";

	/**
	 * The cached value of the '{@link #getAmplCloseLiteral() <em>Ampl Close Literal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAmplCloseLiteral()
	 * @generated
	 * @ordered
	 */
	protected String amplCloseLiteral = AMPL_CLOSE_LITERAL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TcgOclFunctionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TcgoclfunctionlibPackage.Literals.TCG_OCL_FUNCTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TcgoclfunctionlibPackage.TCG_OCL_FUNCTION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAmplLiteral() {
		return amplLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAmplLiteral(String newAmplLiteral) {
		String oldAmplLiteral = amplLiteral;
		amplLiteral = newAmplLiteral;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TcgoclfunctionlibPackage.TCG_OCL_FUNCTION__AMPL_LITERAL, oldAmplLiteral, amplLiteral));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOclLiteral() {
		return oclLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOclLiteral(String newOclLiteral) {
		String oldOclLiteral = oclLiteral;
		oclLiteral = newOclLiteral;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TcgoclfunctionlibPackage.TCG_OCL_FUNCTION__OCL_LITERAL, oldOclLiteral, oclLiteral));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAmplCloseLiteral() {
		return amplCloseLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAmplCloseLiteral(String newAmplCloseLiteral) {
		String oldAmplCloseLiteral = amplCloseLiteral;
		amplCloseLiteral = newAmplCloseLiteral;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TcgoclfunctionlibPackage.TCG_OCL_FUNCTION__AMPL_CLOSE_LITERAL, oldAmplCloseLiteral, amplCloseLiteral));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TcgoclfunctionlibPackage.TCG_OCL_FUNCTION__NAME:
				return getName();
			case TcgoclfunctionlibPackage.TCG_OCL_FUNCTION__AMPL_LITERAL:
				return getAmplLiteral();
			case TcgoclfunctionlibPackage.TCG_OCL_FUNCTION__OCL_LITERAL:
				return getOclLiteral();
			case TcgoclfunctionlibPackage.TCG_OCL_FUNCTION__AMPL_CLOSE_LITERAL:
				return getAmplCloseLiteral();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TcgoclfunctionlibPackage.TCG_OCL_FUNCTION__NAME:
				setName((String)newValue);
				return;
			case TcgoclfunctionlibPackage.TCG_OCL_FUNCTION__AMPL_LITERAL:
				setAmplLiteral((String)newValue);
				return;
			case TcgoclfunctionlibPackage.TCG_OCL_FUNCTION__OCL_LITERAL:
				setOclLiteral((String)newValue);
				return;
			case TcgoclfunctionlibPackage.TCG_OCL_FUNCTION__AMPL_CLOSE_LITERAL:
				setAmplCloseLiteral((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case TcgoclfunctionlibPackage.TCG_OCL_FUNCTION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case TcgoclfunctionlibPackage.TCG_OCL_FUNCTION__AMPL_LITERAL:
				setAmplLiteral(AMPL_LITERAL_EDEFAULT);
				return;
			case TcgoclfunctionlibPackage.TCG_OCL_FUNCTION__OCL_LITERAL:
				setOclLiteral(OCL_LITERAL_EDEFAULT);
				return;
			case TcgoclfunctionlibPackage.TCG_OCL_FUNCTION__AMPL_CLOSE_LITERAL:
				setAmplCloseLiteral(AMPL_CLOSE_LITERAL_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case TcgoclfunctionlibPackage.TCG_OCL_FUNCTION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case TcgoclfunctionlibPackage.TCG_OCL_FUNCTION__AMPL_LITERAL:
				return AMPL_LITERAL_EDEFAULT == null ? amplLiteral != null : !AMPL_LITERAL_EDEFAULT.equals(amplLiteral);
			case TcgoclfunctionlibPackage.TCG_OCL_FUNCTION__OCL_LITERAL:
				return OCL_LITERAL_EDEFAULT == null ? oclLiteral != null : !OCL_LITERAL_EDEFAULT.equals(oclLiteral);
			case TcgoclfunctionlibPackage.TCG_OCL_FUNCTION__AMPL_CLOSE_LITERAL:
				return AMPL_CLOSE_LITERAL_EDEFAULT == null ? amplCloseLiteral != null : !AMPL_CLOSE_LITERAL_EDEFAULT.equals(amplCloseLiteral);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", amplLiteral: ");
		result.append(amplLiteral);
		result.append(", oclLiteral: ");
		result.append(oclLiteral);
		result.append(", amplCloseLiteral: ");
		result.append(amplCloseLiteral);
		result.append(')');
		return result.toString();
	}

} //TcgOclFunctionImpl
