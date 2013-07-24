/**
 */
package org.xilaew.atg.model.abstractTestCaseGraph.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.xilaew.atg.model.abstractTestCaseGraph.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AbstractTestCaseGraphFactoryImpl extends EFactoryImpl implements AbstractTestCaseGraphFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AbstractTestCaseGraphFactory init() {
		try {
			AbstractTestCaseGraphFactory theAbstractTestCaseGraphFactory = (AbstractTestCaseGraphFactory)EPackage.Registry.INSTANCE.getEFactory(AbstractTestCaseGraphPackage.eNS_URI);
			if (theAbstractTestCaseGraphFactory != null) {
				return theAbstractTestCaseGraphFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new AbstractTestCaseGraphFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractTestCaseGraphFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case AbstractTestCaseGraphPackage.ABSTRACT_TCG_ELEMENT: return createAbstractTCGElement();
			case AbstractTestCaseGraphPackage.ABSTRACT_TCG_CONTAINER: return createAbstractTCGContainer();
			case AbstractTestCaseGraphPackage.ABSTRACT_TCG_NODE: return createAbstractTCGNode();
			case AbstractTestCaseGraphPackage.ABSTRACT_TCG_EDGE: return createAbstractTCGEdge();
			case AbstractTestCaseGraphPackage.ABSTRACT_TCG_REAL_NODE: return createAbstractTCGRealNode();
			case AbstractTestCaseGraphPackage.ABSTRACT_TCG_PSEUDO_NODE: return createAbstractTCGPseudoNode();
			case AbstractTestCaseGraphPackage.ABSTRACT_TCG_CONSTRAINT: return createAbstractTCGConstraint();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractTCGElement createAbstractTCGElement() {
		AbstractTCGElementImpl abstractTCGElement = new AbstractTCGElementImpl();
		return abstractTCGElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractTCGContainer createAbstractTCGContainer() {
		AbstractTCGContainerImpl abstractTCGContainer = new AbstractTCGContainerImpl();
		return abstractTCGContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractTCGNode createAbstractTCGNode() {
		AbstractTCGNodeImpl abstractTCGNode = new AbstractTCGNodeImpl();
		return abstractTCGNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractTCGEdge createAbstractTCGEdge() {
		AbstractTCGEdgeImpl abstractTCGEdge = new AbstractTCGEdgeImpl();
		return abstractTCGEdge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractTCGRealNode createAbstractTCGRealNode() {
		AbstractTCGRealNodeImpl abstractTCGRealNode = new AbstractTCGRealNodeImpl();
		return abstractTCGRealNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractTCGPseudoNode createAbstractTCGPseudoNode() {
		AbstractTCGPseudoNodeImpl abstractTCGPseudoNode = new AbstractTCGPseudoNodeImpl();
		return abstractTCGPseudoNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractTCGConstraint createAbstractTCGConstraint() {
		AbstractTCGConstraintImpl abstractTCGConstraint = new AbstractTCGConstraintImpl();
		return abstractTCGConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractTestCaseGraphPackage getAbstractTestCaseGraphPackage() {
		return (AbstractTestCaseGraphPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static AbstractTestCaseGraphPackage getPackage() {
		return AbstractTestCaseGraphPackage.eINSTANCE;
	}

} //AbstractTestCaseGraphFactoryImpl
