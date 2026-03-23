/**
 */
package intelligentMobility.provider;


import intelligentMobility.IntelligentMobilityPackage;
import intelligentMobility.Link_CooperativeBehaviour_CommunicationInterface;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link intelligentMobility.Link_CooperativeBehaviour_CommunicationInterface} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class Link_CooperativeBehaviour_CommunicationInterfaceItemProvider 
	extends ItemProviderAdapter
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
	public Link_CooperativeBehaviour_CommunicationInterfaceItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addName_link_cooperativeBehaviour_communicationInterfacePropertyDescriptor(object);
			addLink_cooperativeBehaviourPropertyDescriptor(object);
			addLink_communicationInterfacePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Name link cooperative Behaviour communication Interface feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addName_link_cooperativeBehaviour_communicationInterfacePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Link_CooperativeBehaviour_CommunicationInterface_name_link_cooperativeBehaviour_communicationInterface_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Link_CooperativeBehaviour_CommunicationInterface_name_link_cooperativeBehaviour_communicationInterface_feature", "_UI_Link_CooperativeBehaviour_CommunicationInterface_type"),
				 IntelligentMobilityPackage.eINSTANCE.getLink_CooperativeBehaviour_CommunicationInterface_Name_link_cooperativeBehaviour_communicationInterface(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Link cooperative Behaviour feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLink_cooperativeBehaviourPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Link_CooperativeBehaviour_CommunicationInterface_link_cooperativeBehaviour_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Link_CooperativeBehaviour_CommunicationInterface_link_cooperativeBehaviour_feature", "_UI_Link_CooperativeBehaviour_CommunicationInterface_type"),
				 IntelligentMobilityPackage.eINSTANCE.getLink_CooperativeBehaviour_CommunicationInterface_Link_cooperativeBehaviour(),
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Link communication Interface feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLink_communicationInterfacePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Link_CooperativeBehaviour_CommunicationInterface_link_communicationInterface_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Link_CooperativeBehaviour_CommunicationInterface_link_communicationInterface_feature", "_UI_Link_CooperativeBehaviour_CommunicationInterface_type"),
				 IntelligentMobilityPackage.eINSTANCE.getLink_CooperativeBehaviour_CommunicationInterface_Link_communicationInterface(),
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This returns Link_CooperativeBehaviour_CommunicationInterface.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Link_CooperativeBehaviour_CommunicationInterface"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText(Object object) {
		String label = ((Link_CooperativeBehaviour_CommunicationInterface)object).getName_link_cooperativeBehaviour_communicationInterface();
		return label == null || label.length() == 0 ?
			getString("_UI_Link_CooperativeBehaviour_CommunicationInterface_type") :
			getString("_UI_Link_CooperativeBehaviour_CommunicationInterface_type") + " " + label;
	}


	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(Link_CooperativeBehaviour_CommunicationInterface.class)) {
			case IntelligentMobilityPackage.LINK_COOPERATIVE_BEHAVIOUR_COMMUNICATION_INTERFACE__NAME_LINK_COOPERATIVE_BEHAVIOUR_COMMUNICATION_INTERFACE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
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
	protected void collectNewChildDescriptors(Collection newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceLocator getResourceLocator() {
		return DrivingBehaviourMetamodelEditPlugin.INSTANCE;
	}

}
