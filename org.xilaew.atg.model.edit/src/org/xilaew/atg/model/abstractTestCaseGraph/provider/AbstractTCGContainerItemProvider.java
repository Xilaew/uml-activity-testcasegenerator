/**
 */
package org.xilaew.atg.model.abstractTestCaseGraph.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGContainer;
import org.xilaew.atg.model.abstractTestCaseGraph.AbstractTestCaseGraphFactory;
import org.xilaew.atg.model.abstractTestCaseGraph.AbstractTestCaseGraphPackage;

/**
 * This is the item provider adapter for a {@link org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGContainer} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class AbstractTCGContainerItemProvider
	extends AbstractTCGElementItemProvider
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractTCGContainerItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addInitialNodePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Initial Node feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addInitialNodePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractTCGContainer_initialNode_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractTCGContainer_initialNode_feature", "_UI_AbstractTCGContainer_type"),
				 AbstractTestCaseGraphPackage.Literals.ABSTRACT_TCG_CONTAINER__INITIAL_NODE,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(AbstractTestCaseGraphPackage.Literals.ABSTRACT_TCG_CONTAINER__NODES);
			childrenFeatures.add(AbstractTestCaseGraphPackage.Literals.ABSTRACT_TCG_CONTAINER__EDGES);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns AbstractTCGContainer.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/AbstractTCGContainer"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((AbstractTCGContainer)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_AbstractTCGContainer_type") :
			getString("_UI_AbstractTCGContainer_type") + " " + label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(AbstractTCGContainer.class)) {
			case AbstractTestCaseGraphPackage.ABSTRACT_TCG_CONTAINER__NODES:
			case AbstractTestCaseGraphPackage.ABSTRACT_TCG_CONTAINER__EDGES:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(AbstractTestCaseGraphPackage.Literals.ABSTRACT_TCG_CONTAINER__NODES,
				 AbstractTestCaseGraphFactory.eINSTANCE.createAbstractTCGNode()));

		newChildDescriptors.add
			(createChildParameter
				(AbstractTestCaseGraphPackage.Literals.ABSTRACT_TCG_CONTAINER__NODES,
				 AbstractTestCaseGraphFactory.eINSTANCE.createAbstractTCGRealNode()));

		newChildDescriptors.add
			(createChildParameter
				(AbstractTestCaseGraphPackage.Literals.ABSTRACT_TCG_CONTAINER__NODES,
				 AbstractTestCaseGraphFactory.eINSTANCE.createAbstractTCGPseudoNode()));

		newChildDescriptors.add
			(createChildParameter
				(AbstractTestCaseGraphPackage.Literals.ABSTRACT_TCG_CONTAINER__EDGES,
				 AbstractTestCaseGraphFactory.eINSTANCE.createAbstractTCGEdge()));
	}

}
