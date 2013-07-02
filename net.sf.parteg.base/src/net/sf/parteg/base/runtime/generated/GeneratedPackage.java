/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.sf.parteg.base.runtime.generated;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see net.sf.parteg.base.runtime.generated.GeneratedFactory
 * @model kind="package"
 * @generated
 */
public interface GeneratedPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "generated";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://net.sf.parteg.base.runtime.generated";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "net.sf.parteg.base.runtime.generated";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GeneratedPackage eINSTANCE = net.sf.parteg.base.runtime.generated.impl.GeneratedPackageImpl.init();

	/**
	 * The meta object id for the '{@link net.sf.parteg.base.runtime.generated.impl.RuntimeStateImpl <em>Runtime State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.sf.parteg.base.runtime.generated.impl.RuntimeStateImpl
	 * @see net.sf.parteg.base.runtime.generated.impl.GeneratedPackageImpl#getRuntimeState()
	 * @generated
	 */
	int RUNTIME_STATE = 0;

	/**
	 * The number of structural features of the '<em>Runtime State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNTIME_STATE_FEATURE_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link net.sf.parteg.base.runtime.generated.RuntimeState <em>Runtime State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Runtime State</em>'.
	 * @see net.sf.parteg.base.runtime.generated.RuntimeState
	 * @generated
	 */
	EClass getRuntimeState();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	GeneratedFactory getGeneratedFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link net.sf.parteg.base.runtime.generated.impl.RuntimeStateImpl <em>Runtime State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.sf.parteg.base.runtime.generated.impl.RuntimeStateImpl
		 * @see net.sf.parteg.base.runtime.generated.impl.GeneratedPackageImpl#getRuntimeState()
		 * @generated
		 */
		EClass RUNTIME_STATE = eINSTANCE.getRuntimeState();

	}

} //GeneratedPackage
