/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.sf.parteg.base.testcasegraph.generated.impl;

import java.util.Collection;

import net.sf.parteg.base.testcasegraph.generated.GeneratedPackage;
import net.sf.parteg.base.testcasegraph.generated.TCGIntermediateNode;
import net.sf.parteg.base.testcasegraph.generated.TCGNodeType;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TCG Intermediate Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.sf.parteg.base.testcasegraph.generated.impl.TCGIntermediateNodeImpl#getReferencedConnectionPointReferences <em>Referenced Connection Point References</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasegraph.generated.impl.TCGIntermediateNodeImpl#getReferencedConnectionPoints <em>Referenced Connection Points</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasegraph.generated.impl.TCGIntermediateNodeImpl#getContainer <em>Container</em>}</li>
 *   <li>{@link net.sf.parteg.base.testcasegraph.generated.impl.TCGIntermediateNodeImpl#getNodeType <em>Node Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TCGIntermediateNodeImpl extends TCGNodeImpl implements TCGIntermediateNode {
	/**
	 * The cached value of the '{@link #getReferencedConnectionPointReferences() <em>Referenced Connection Point References</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferencedConnectionPointReferences()
	 * @generated
	 * @ordered
	 */
	protected EList<TCGIntermediateNode> referencedConnectionPointReferences;

	/**
	 * The cached value of the '{@link #getReferencedConnectionPoints() <em>Referenced Connection Points</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferencedConnectionPoints()
	 * @generated
	 * @ordered
	 */
	protected EList<TCGIntermediateNode> referencedConnectionPoints;

	/**
	 * The cached value of the '{@link #getContainer() <em>Container</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContainer()
	 * @generated
	 * @ordered
	 */
	protected EObject container;

	/**
	 * The default value of the '{@link #getNodeType() <em>Node Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodeType()
	 * @generated
	 * @ordered
	 */
	protected static final TCGNodeType NODE_TYPE_EDEFAULT = TCGNodeType.UNKNOWN;

	/**
	 * The cached value of the '{@link #getNodeType() <em>Node Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodeType()
	 * @generated
	 * @ordered
	 */
	protected TCGNodeType nodeType = NODE_TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TCGIntermediateNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeneratedPackage.Literals.TCG_INTERMEDIATE_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TCGIntermediateNode> getReferencedConnectionPointReferences() {
		if (referencedConnectionPointReferences == null) {
			referencedConnectionPointReferences = new EObjectResolvingEList<TCGIntermediateNode>(TCGIntermediateNode.class, this, GeneratedPackage.TCG_INTERMEDIATE_NODE__REFERENCED_CONNECTION_POINT_REFERENCES);
		}
		return referencedConnectionPointReferences;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TCGIntermediateNode> getReferencedConnectionPoints() {
		if (referencedConnectionPoints == null) {
			referencedConnectionPoints = new EObjectResolvingEList<TCGIntermediateNode>(TCGIntermediateNode.class, this, GeneratedPackage.TCG_INTERMEDIATE_NODE__REFERENCED_CONNECTION_POINTS);
		}
		return referencedConnectionPoints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getContainer() {
		if (container != null && container.eIsProxy()) {
			InternalEObject oldContainer = (InternalEObject)container;
			container = eResolveProxy(oldContainer);
			if (container != oldContainer) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GeneratedPackage.TCG_INTERMEDIATE_NODE__CONTAINER, oldContainer, container));
			}
		}
		return container;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetContainer() {
		return container;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainer(EObject newContainer) {
		EObject oldContainer = container;
		container = newContainer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedPackage.TCG_INTERMEDIATE_NODE__CONTAINER, oldContainer, container));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TCGNodeType getNodeType() {
		return nodeType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNodeType(TCGNodeType newNodeType) {
		TCGNodeType oldNodeType = nodeType;
		nodeType = newNodeType == null ? NODE_TYPE_EDEFAULT : newNodeType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratedPackage.TCG_INTERMEDIATE_NODE__NODE_TYPE, oldNodeType, nodeType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GeneratedPackage.TCG_INTERMEDIATE_NODE__REFERENCED_CONNECTION_POINT_REFERENCES:
				return getReferencedConnectionPointReferences();
			case GeneratedPackage.TCG_INTERMEDIATE_NODE__REFERENCED_CONNECTION_POINTS:
				return getReferencedConnectionPoints();
			case GeneratedPackage.TCG_INTERMEDIATE_NODE__CONTAINER:
				if (resolve) return getContainer();
				return basicGetContainer();
			case GeneratedPackage.TCG_INTERMEDIATE_NODE__NODE_TYPE:
				return getNodeType();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case GeneratedPackage.TCG_INTERMEDIATE_NODE__REFERENCED_CONNECTION_POINT_REFERENCES:
				getReferencedConnectionPointReferences().clear();
				getReferencedConnectionPointReferences().addAll((Collection<? extends TCGIntermediateNode>)newValue);
				return;
			case GeneratedPackage.TCG_INTERMEDIATE_NODE__REFERENCED_CONNECTION_POINTS:
				getReferencedConnectionPoints().clear();
				getReferencedConnectionPoints().addAll((Collection<? extends TCGIntermediateNode>)newValue);
				return;
			case GeneratedPackage.TCG_INTERMEDIATE_NODE__CONTAINER:
				setContainer((EObject)newValue);
				return;
			case GeneratedPackage.TCG_INTERMEDIATE_NODE__NODE_TYPE:
				setNodeType((TCGNodeType)newValue);
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
			case GeneratedPackage.TCG_INTERMEDIATE_NODE__REFERENCED_CONNECTION_POINT_REFERENCES:
				getReferencedConnectionPointReferences().clear();
				return;
			case GeneratedPackage.TCG_INTERMEDIATE_NODE__REFERENCED_CONNECTION_POINTS:
				getReferencedConnectionPoints().clear();
				return;
			case GeneratedPackage.TCG_INTERMEDIATE_NODE__CONTAINER:
				setContainer((EObject)null);
				return;
			case GeneratedPackage.TCG_INTERMEDIATE_NODE__NODE_TYPE:
				setNodeType(NODE_TYPE_EDEFAULT);
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
			case GeneratedPackage.TCG_INTERMEDIATE_NODE__REFERENCED_CONNECTION_POINT_REFERENCES:
				return referencedConnectionPointReferences != null && !referencedConnectionPointReferences.isEmpty();
			case GeneratedPackage.TCG_INTERMEDIATE_NODE__REFERENCED_CONNECTION_POINTS:
				return referencedConnectionPoints != null && !referencedConnectionPoints.isEmpty();
			case GeneratedPackage.TCG_INTERMEDIATE_NODE__CONTAINER:
				return container != null;
			case GeneratedPackage.TCG_INTERMEDIATE_NODE__NODE_TYPE:
				return nodeType != NODE_TYPE_EDEFAULT;
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
		result.append(" (nodeType: ");
		result.append(nodeType);
		result.append(')');
		return result.toString();
	}

} //TCGIntermediateNodeImpl
