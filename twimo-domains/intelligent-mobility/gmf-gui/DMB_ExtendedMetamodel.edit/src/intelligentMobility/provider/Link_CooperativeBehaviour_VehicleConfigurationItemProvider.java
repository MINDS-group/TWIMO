/**
 */
package intelligentMobility.provider;


import intelligentMobility.IntelligentMobilityPackage;
import intelligentMobility.Link_CooperativeBehaviour_VehicleConfiguration;

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
 * This is the item provider adapter for a {@link intelligentMobility.Link_CooperativeBehaviour_VehicleConfiguration} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class Link_CooperativeBehaviour_VehicleConfigurationItemProvider 
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
	public Link_CooperativeBehaviour_VehicleConfigurationItemProvider(AdapterFactory adapterFactory) {
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

			addName_link_cooperativeBehaviour_vehicleConfigurationPropertyDescriptor(object);
			addLink_cooperativeBehaviourPropertyDescriptor(object);
			addLink_vehicleConfigurationPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Name link cooperative Behaviour vehicle Configuration feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addName_link_cooperativeBehaviour_vehicleConfigurationPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Link_CooperativeBehaviour_VehicleConfiguration_name_link_cooperativeBehaviour_vehicleConfiguration_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Link_CooperativeBehaviour_VehicleConfiguration_name_link_cooperativeBehaviour_vehicleConfiguration_feature", "_UI_Link_CooperativeBehaviour_VehicleConfiguration_type"),
				 IntelligentMobilityPackage.eINSTANCE.getLink_CooperativeBehaviour_VehicleConfiguration_Name_link_cooperativeBehaviour_vehicleConfiguration(),
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
				 getString("_UI_Link_CooperativeBehaviour_VehicleConfiguration_link_cooperativeBehaviour_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Link_CooperativeBehaviour_VehicleConfiguration_link_cooperativeBehaviour_feature", "_UI_Link_CooperativeBehaviour_VehicleConfiguration_type"),
				 IntelligentMobilityPackage.eINSTANCE.getLink_CooperativeBehaviour_VehicleConfiguration_Link_cooperativeBehaviour(),
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Link vehicle Configuration feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLink_vehicleConfigurationPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Link_CooperativeBehaviour_VehicleConfiguration_link_vehicleConfiguration_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Link_CooperativeBehaviour_VehicleConfiguration_link_vehicleConfiguration_feature", "_UI_Link_CooperativeBehaviour_VehicleConfiguration_type"),
				 IntelligentMobilityPackage.eINSTANCE.getLink_CooperativeBehaviour_VehicleConfiguration_Link_vehicleConfiguration(),
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This returns Link_CooperativeBehaviour_VehicleConfiguration.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Link_CooperativeBehaviour_VehicleConfiguration"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText(Object object) {
		String label = ((Link_CooperativeBehaviour_VehicleConfiguration)object).getName_link_cooperativeBehaviour_vehicleConfiguration();
		return label == null || label.length() == 0 ?
			getString("_UI_Link_CooperativeBehaviour_VehicleConfiguration_type") :
			getString("_UI_Link_CooperativeBehaviour_VehicleConfiguration_type") + " " + label;
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

		switch (notification.getFeatureID(Link_CooperativeBehaviour_VehicleConfiguration.class)) {
			case IntelligentMobilityPackage.LINK_COOPERATIVE_BEHAVIOUR_VEHICLE_CONFIGURATION__NAME_LINK_COOPERATIVE_BEHAVIOUR_VEHICLE_CONFIGURATION:
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
