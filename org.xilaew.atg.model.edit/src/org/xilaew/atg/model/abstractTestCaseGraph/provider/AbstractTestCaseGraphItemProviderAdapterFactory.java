/**
 */
package org.xilaew.atg.model.abstractTestCaseGraph.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.edit.domain.EditingDomain;

import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ChildCreationExtenderManager;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IChildCreationExtender;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

import org.xilaew.atg.model.abstractTestCaseGraph.AbstractTestCaseGraphPackage;

import org.xilaew.atg.model.abstractTestCaseGraph.util.AbstractTestCaseGraphAdapterFactory;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class AbstractTestCaseGraphItemProviderAdapterFactory extends AbstractTestCaseGraphAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable, IChildCreationExtender {
	/**
	 * This keeps track of the root adapter factory that delegates to this adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This helps manage the child creation extenders.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ChildCreationExtenderManager childCreationExtenderManager = new ChildCreationExtenderManager(AbstractTestCaseGraphEditPlugin.INSTANCE, AbstractTestCaseGraphPackage.eNS_URI);

	/**
	 * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<Object> supportedTypes = new ArrayList<Object>();

	/**
	 * This constructs an instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractTestCaseGraphItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGElement} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractTCGElementItemProvider abstractTCGElementItemProvider;

	/**
	 * This creates an adapter for a {@link org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGElement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createAbstractTCGElementAdapter() {
		if (abstractTCGElementItemProvider == null) {
			abstractTCGElementItemProvider = new AbstractTCGElementItemProvider(this);
		}

		return abstractTCGElementItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGContainer} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractTCGContainerItemProvider abstractTCGContainerItemProvider;

	/**
	 * This creates an adapter for a {@link org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGContainer}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createAbstractTCGContainerAdapter() {
		if (abstractTCGContainerItemProvider == null) {
			abstractTCGContainerItemProvider = new AbstractTCGContainerItemProvider(this);
		}

		return abstractTCGContainerItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGNode} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractTCGNodeItemProvider abstractTCGNodeItemProvider;

	/**
	 * This creates an adapter for a {@link org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGNode}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createAbstractTCGNodeAdapter() {
		if (abstractTCGNodeItemProvider == null) {
			abstractTCGNodeItemProvider = new AbstractTCGNodeItemProvider(this);
		}

		return abstractTCGNodeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGEdge} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractTCGEdgeItemProvider abstractTCGEdgeItemProvider;

	/**
	 * This creates an adapter for a {@link org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGEdge}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createAbstractTCGEdgeAdapter() {
		if (abstractTCGEdgeItemProvider == null) {
			abstractTCGEdgeItemProvider = new AbstractTCGEdgeItemProvider(this);
		}

		return abstractTCGEdgeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGRealNode} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractTCGRealNodeItemProvider abstractTCGRealNodeItemProvider;

	/**
	 * This creates an adapter for a {@link org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGRealNode}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createAbstractTCGRealNodeAdapter() {
		if (abstractTCGRealNodeItemProvider == null) {
			abstractTCGRealNodeItemProvider = new AbstractTCGRealNodeItemProvider(this);
		}

		return abstractTCGRealNodeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGPseudoNode} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractTCGPseudoNodeItemProvider abstractTCGPseudoNodeItemProvider;

	/**
	 * This creates an adapter for a {@link org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGPseudoNode}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createAbstractTCGPseudoNodeAdapter() {
		if (abstractTCGPseudoNodeItemProvider == null) {
			abstractTCGPseudoNodeItemProvider = new AbstractTCGPseudoNodeItemProvider(this);
		}

		return abstractTCGPseudoNodeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGConstraint} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractTCGConstraintItemProvider abstractTCGConstraintItemProvider;

	/**
	 * This creates an adapter for a {@link org.xilaew.atg.model.abstractTestCaseGraph.AbstractTCGConstraint}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createAbstractTCGConstraintAdapter() {
		if (abstractTCGConstraintItemProvider == null) {
			abstractTCGConstraintItemProvider = new AbstractTCGConstraintItemProvider(this);
		}

		return abstractTCGConstraintItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComposeableAdapterFactory getRootAdapterFactory() {
		return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
	}

	/**
	 * This sets the composed adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter adapt(Notifier notifier, Object type) {
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object adapt(Object object, Object type) {
		if (isFactoryForType(type)) {
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class<?>) || (((Class<?>)type).isInstance(adapter))) {
				return adapter;
			}
		}

		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<IChildCreationExtender> getChildCreationExtenders() {
		return childCreationExtenderManager.getChildCreationExtenders();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Collection<?> getNewChildDescriptors(Object object, EditingDomain editingDomain) {
		return childCreationExtenderManager.getNewChildDescriptors(object, editingDomain);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceLocator getResourceLocator() {
		return childCreationExtenderManager;
	}

	/**
	 * This adds a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void removeListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void fireNotifyChanged(Notification notification) {
		changeNotifier.fireNotifyChanged(notification);

		if (parentAdapterFactory != null) {
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * This disposes all of the item providers created by this factory. 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void dispose() {
		if (abstractTCGElementItemProvider != null) abstractTCGElementItemProvider.dispose();
		if (abstractTCGContainerItemProvider != null) abstractTCGContainerItemProvider.dispose();
		if (abstractTCGNodeItemProvider != null) abstractTCGNodeItemProvider.dispose();
		if (abstractTCGEdgeItemProvider != null) abstractTCGEdgeItemProvider.dispose();
		if (abstractTCGRealNodeItemProvider != null) abstractTCGRealNodeItemProvider.dispose();
		if (abstractTCGPseudoNodeItemProvider != null) abstractTCGPseudoNodeItemProvider.dispose();
		if (abstractTCGConstraintItemProvider != null) abstractTCGConstraintItemProvider.dispose();
	}

}