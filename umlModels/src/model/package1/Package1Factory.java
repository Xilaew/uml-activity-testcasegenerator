/**
 */
package model.package1;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see model.package1.Package1Package
 * @generated
 */
public interface Package1Factory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Package1Factory eINSTANCE = model.package1.impl.Package1FactoryImpl.init();

	/**
	 * Returns a new object of class '<em>class1</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>class1</em>'.
	 * @generated
	 */
	class1 createclass1();

	/**
	 * Returns a new object of class '<em>type1</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>type1</em>'.
	 * @generated
	 */
	type1 createtype1();

	/**
	 * Returns a new object of class '<em>class1 test Activity</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>class1 test Activity</em>'.
	 * @generated
	 */
	class1_testActivity createclass1_testActivity();

	/**
	 * Returns a new object of class '<em>class2</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>class2</em>'.
	 * @generated
	 */
	class2 createclass2();

	/**
	 * Returns a new object of class '<em>type2</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>type2</em>'.
	 * @generated
	 */
	type2 createtype2();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	Package1Package getPackage1Package();

} //Package1Factory
