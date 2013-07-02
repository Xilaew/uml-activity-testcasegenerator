/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.sf.parteg.base.runtime.generated;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see net.sf.parteg.base.runtime.generated.GeneratedPackage
 * @generated
 */
public interface GeneratedFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GeneratedFactory eINSTANCE = net.sf.parteg.base.runtime.generated.impl.GeneratedFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Runtime State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Runtime State</em>'.
	 * @generated
	 */
	RuntimeState createRuntimeState();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	GeneratedPackage getGeneratedPackage();

} //GeneratedFactory
