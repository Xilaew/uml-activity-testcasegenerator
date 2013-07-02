/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.sf.parteg.base.testcasegraph.generated.util;

import net.sf.parteg.base.testcasegraph.generated.*;
import net.sf.parteg.base.testcasegraph.generated.GeneratedPackage;
import net.sf.parteg.base.testcasegraph.generated.TCGComplexParameter;
import net.sf.parteg.base.testcasegraph.generated.TCGConjunction;
import net.sf.parteg.base.testcasegraph.generated.TCGDisjunctiveNormalForm;
import net.sf.parteg.base.testcasegraph.generated.TCGElement;
import net.sf.parteg.base.testcasegraph.generated.TCGEquivalenceClass;
import net.sf.parteg.base.testcasegraph.generated.TCGEvent;
import net.sf.parteg.base.testcasegraph.generated.TCGNode;
import net.sf.parteg.base.testcasegraph.generated.TCGOCLAtom;
import net.sf.parteg.base.testcasegraph.generated.TCGOCLExpression;
import net.sf.parteg.base.testcasegraph.generated.TCGOCLIfThenElse;
import net.sf.parteg.base.testcasegraph.generated.TCGOCLOperation;
import net.sf.parteg.base.testcasegraph.generated.TCGParameter;
import net.sf.parteg.base.testcasegraph.generated.TCGPrimitiveParameter;
import net.sf.parteg.base.testcasegraph.generated.TCGTransition;
import net.sf.parteg.base.testcasegraph.generated.TestCaseGraph;
import net.sf.parteg.base.testcasegraph.generated.TestCaseRegion;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see net.sf.parteg.base.testcasegraph.generated.GeneratedPackage
 * @generated
 */
public class GeneratedAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static GeneratedPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeneratedAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = GeneratedPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GeneratedSwitch<Adapter> modelSwitch =
		new GeneratedSwitch<Adapter>() {
			@Override
			public Adapter caseTCGNode(TCGNode object) {
				return createTCGNodeAdapter();
			}
			@Override
			public Adapter caseTCGRealNode(TCGRealNode object) {
				return createTCGRealNodeAdapter();
			}
			@Override
			public Adapter caseTCGIntermediateNode(TCGIntermediateNode object) {
				return createTCGIntermediateNodeAdapter();
			}
			@Override
			public Adapter caseTestCaseRegion(TestCaseRegion object) {
				return createTestCaseRegionAdapter();
			}
			@Override
			public Adapter caseTestCaseGraph(TestCaseGraph object) {
				return createTestCaseGraphAdapter();
			}
			@Override
			public Adapter caseTCGTransition(TCGTransition object) {
				return createTCGTransitionAdapter();
			}
			@Override
			public Adapter caseTCGEquivalenceClass(TCGEquivalenceClass object) {
				return createTCGEquivalenceClassAdapter();
			}
			@Override
			public Adapter caseTCGEvent(TCGEvent object) {
				return createTCGEventAdapter();
			}
			@Override
			public Adapter caseTCGOCLExpression(TCGOCLExpression object) {
				return createTCGOCLExpressionAdapter();
			}
			@Override
			public Adapter caseTCGConjunction(TCGConjunction object) {
				return createTCGConjunctionAdapter();
			}
			@Override
			public Adapter caseTCGDisjunctiveNormalForm(TCGDisjunctiveNormalForm object) {
				return createTCGDisjunctiveNormalFormAdapter();
			}
			@Override
			public Adapter caseTCGOCLOperation(TCGOCLOperation object) {
				return createTCGOCLOperationAdapter();
			}
			@Override
			public Adapter caseTCGOCLAtom(TCGOCLAtom object) {
				return createTCGOCLAtomAdapter();
			}
			@Override
			public Adapter caseTCGOCLIfThenElse(TCGOCLIfThenElse object) {
				return createTCGOCLIfThenElseAdapter();
			}
			@Override
			public Adapter caseTCGParameter(TCGParameter object) {
				return createTCGParameterAdapter();
			}
			@Override
			public Adapter caseTCGPrimitiveParameter(TCGPrimitiveParameter object) {
				return createTCGPrimitiveParameterAdapter();
			}
			@Override
			public Adapter caseTCGComplexParameter(TCGComplexParameter object) {
				return createTCGComplexParameterAdapter();
			}
			@Override
			public Adapter caseTCGElement(TCGElement object) {
				return createTCGElementAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link net.sf.parteg.base.testcasegraph.generated.TCGNode <em>TCG Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGNode
	 * @generated
	 */
	public Adapter createTCGNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.parteg.base.testcasegraph.generated.TCGRealNode <em>TCG Real Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGRealNode
	 * @generated
	 */
	public Adapter createTCGRealNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.parteg.base.testcasegraph.generated.TCGIntermediateNode <em>TCG Intermediate Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGIntermediateNode
	 * @generated
	 */
	public Adapter createTCGIntermediateNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.parteg.base.testcasegraph.generated.TestCaseRegion <em>Test Case Region</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.parteg.base.testcasegraph.generated.TestCaseRegion
	 * @generated
	 */
	public Adapter createTestCaseRegionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.parteg.base.testcasegraph.generated.TestCaseGraph <em>Test Case Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.parteg.base.testcasegraph.generated.TestCaseGraph
	 * @generated
	 */
	public Adapter createTestCaseGraphAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.parteg.base.testcasegraph.generated.TCGTransition <em>TCG Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGTransition
	 * @generated
	 */
	public Adapter createTCGTransitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.parteg.base.testcasegraph.generated.TCGEquivalenceClass <em>TCG Equivalence Class</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGEquivalenceClass
	 * @generated
	 */
	public Adapter createTCGEquivalenceClassAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.parteg.base.testcasegraph.generated.TCGEvent <em>TCG Event</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGEvent
	 * @generated
	 */
	public Adapter createTCGEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.parteg.base.testcasegraph.generated.TCGOCLExpression <em>TCGOCL Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGOCLExpression
	 * @generated
	 */
	public Adapter createTCGOCLExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.parteg.base.testcasegraph.generated.TCGConjunction <em>TCG Conjunction</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGConjunction
	 * @generated
	 */
	public Adapter createTCGConjunctionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.parteg.base.testcasegraph.generated.TCGDisjunctiveNormalForm <em>TCG Disjunctive Normal Form</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGDisjunctiveNormalForm
	 * @generated
	 */
	public Adapter createTCGDisjunctiveNormalFormAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.parteg.base.testcasegraph.generated.TCGOCLOperation <em>TCGOCL Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGOCLOperation
	 * @generated
	 */
	public Adapter createTCGOCLOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.parteg.base.testcasegraph.generated.TCGOCLAtom <em>TCGOCL Atom</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGOCLAtom
	 * @generated
	 */
	public Adapter createTCGOCLAtomAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.parteg.base.testcasegraph.generated.TCGOCLIfThenElse <em>TCGOCL If Then Else</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGOCLIfThenElse
	 * @generated
	 */
	public Adapter createTCGOCLIfThenElseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.parteg.base.testcasegraph.generated.TCGParameter <em>TCG Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGParameter
	 * @generated
	 */
	public Adapter createTCGParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.parteg.base.testcasegraph.generated.TCGPrimitiveParameter <em>TCG Primitive Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGPrimitiveParameter
	 * @generated
	 */
	public Adapter createTCGPrimitiveParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.parteg.base.testcasegraph.generated.TCGComplexParameter <em>TCG Complex Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGComplexParameter
	 * @generated
	 */
	public Adapter createTCGComplexParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.sf.parteg.base.testcasegraph.generated.TCGElement <em>TCG Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.sf.parteg.base.testcasegraph.generated.TCGElement
	 * @generated
	 */
	public Adapter createTCGElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //GeneratedAdapterFactory
