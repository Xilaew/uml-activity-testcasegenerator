/**
 */
package org.xilaew.atg.model.activityTestCaseGraph.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.xilaew.atg.model.abstractTestCaseGraph.AbstractTestCaseGraphPackage;

import org.xilaew.atg.model.abstractTestCaseGraph.provider.AbstractTCGContainerItemProvider;

import org.xilaew.atg.model.activityTestCaseGraph.ActivityTestCaseGraphFactory;
import org.xilaew.atg.model.activityTestCaseGraph.ActivityTestCaseGraphPackage;
import org.xilaew.atg.model.activityTestCaseGraph.TCGActivity;

/**
 * This is the item provider adapter for a {@link org.xilaew.atg.model.activityTestCaseGraph.TCGActivity} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class TCGActivityItemProvider
	extends AbstractTCGContainerItemProvider
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
	public TCGActivityItemProvider(AdapterFactory adapterFactory) {
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

		}
		return itemPropertyDescriptors;
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
			childrenFeatures.add(ActivityTestCaseGraphPackage.Literals.TCG_ACTIVITY__VARIABLES);
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
	 * This returns TCGActivity.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/TCGActivity"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((TCGActivity)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_TCGActivity_type") :
			getString("_UI_TCGActivity_type") + " " + label;
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

		switch (notification.getFeatureID(TCGActivity.class)) {
			case ActivityTestCaseGraphPackage.TCG_ACTIVITY__VARIABLES:
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
				 ActivityTestCaseGraphFactory.eINSTANCE.createTCGAction()));

		newChildDescriptors.add
			(createChildParameter
				(AbstractTestCaseGraphPackage.Literals.ABSTRACT_TCG_CONTAINER__NODES,
				 ActivityTestCaseGraphFactory.eINSTANCE.createTCGControlNode()));

		newChildDescriptors.add
			(createChildParameter
				(AbstractTestCaseGraphPackage.Literals.ABSTRACT_TCG_CONTAINER__NODES,
				 ActivityTestCaseGraphFactory.eINSTANCE.createTCGStructuredActivityNode()));

		newChildDescriptors.add
			(createChildParameter
				(AbstractTestCaseGraphPackage.Literals.ABSTRACT_TCG_CONTAINER__EDGES,
				 ActivityTestCaseGraphFactory.eINSTANCE.createTCGControlFlow()));

		newChildDescriptors.add
			(createChildParameter
				(ActivityTestCaseGraphPackage.Literals.TCG_ACTIVITY__VARIABLES,
				 ActivityTestCaseGraphFactory.eINSTANCE.createTCGVariable()));

		newChildDescriptors.add
			(createChildParameter
				(ActivityTestCaseGraphPackage.Literals.TCG_ACTIVITY__VARIABLES,
				 ActivityTestCaseGraphFactory.eINSTANCE.createTCGObjectVariable()));

		newChildDescriptors.add
			(createChildParameter
				(ActivityTestCaseGraphPackage.Literals.TCG_ACTIVITY__VARIABLES,
				 ActivityTestCaseGraphFactory.eINSTANCE.createTCGBasicVariable()));
	}

}
