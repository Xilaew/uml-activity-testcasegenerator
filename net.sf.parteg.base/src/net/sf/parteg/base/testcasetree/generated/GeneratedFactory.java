/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.sf.parteg.base.testcasetree.generated;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see net.sf.parteg.base.testcasetree.generated.GeneratedPackage
 * @generated
 */
public interface GeneratedFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GeneratedFactory eINSTANCE = net.sf.parteg.base.testcasetree.generated.impl.GeneratedFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>TCG Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>TCG Node</em>'.
	 * @generated
	 */
	TCGNode createTCGNode();

	/**
	 * Returns a new object of class '<em>Test Case Graph</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Test Case Graph</em>'.
	 * @generated
	 */
	TestCaseGraph createTestCaseGraph();

	/**
	 * Returns a new object of class '<em>TCG Transition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>TCG Transition</em>'.
	 * @generated
	 */
	TCGTransition createTCGTransition();

	/**
	 * Returns a new object of class '<em>TCG Equivalence Class</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>TCG Equivalence Class</em>'.
	 * @generated
	 */
	TCGEquivalenceClass createTCGEquivalenceClass();

	/**
	 * Returns a new object of class '<em>TCG Event</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>TCG Event</em>'.
	 * @generated
	 */
	TCGEvent createTCGEvent();

	/**
	 * Returns a new object of class '<em>TCGOCL Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>TCGOCL Expression</em>'.
	 * @generated
	 */
	TCGOCLExpression createTCGOCLExpression();

	/**
	 * Returns a new object of class '<em>TCG Conjunction</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>TCG Conjunction</em>'.
	 * @generated
	 */
	TCGConjunction createTCGConjunction();

	/**
	 * Returns a new object of class '<em>TCG Disjunctive Normal Form</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>TCG Disjunctive Normal Form</em>'.
	 * @generated
	 */
	TCGDisjunctiveNormalForm createTCGDisjunctiveNormalForm();

	/**
	 * Returns a new object of class '<em>TCGOCL Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>TCGOCL Operation</em>'.
	 * @generated
	 */
	TCGOCLOperation createTCGOCLOperation();

	/**
	 * Returns a new object of class '<em>TCGOCL Atom</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>TCGOCL Atom</em>'.
	 * @generated
	 */
	TCGOCLAtom createTCGOCLAtom();

	/**
	 * Returns a new object of class '<em>TCGOCL If Then Else</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>TCGOCL If Then Else</em>'.
	 * @generated
	 */
	TCGOCLIfThenElse createTCGOCLIfThenElse();

	/**
	 * Returns a new object of class '<em>TCG Primitive Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>TCG Primitive Parameter</em>'.
	 * @generated
	 */
	TCGPrimitiveParameter createTCGPrimitiveParameter();

	/**
	 * Returns a new object of class '<em>TCG Complex Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>TCG Complex Parameter</em>'.
	 * @generated
	 */
	TCGComplexParameter createTCGComplexParameter();

	/**
	 * Returns a new object of class '<em>TCG Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>TCG Element</em>'.
	 * @generated
	 */
	TCGElement createTCGElement();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	GeneratedPackage getGeneratedPackage();

} //GeneratedFactory
