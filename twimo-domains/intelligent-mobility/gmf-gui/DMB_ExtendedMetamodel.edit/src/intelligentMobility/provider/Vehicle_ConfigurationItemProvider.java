/**
 */
package intelligentMobility.provider;


import intelligentMobility.IntelligentMobilityFactory;
import intelligentMobility.IntelligentMobilityPackage;
import intelligentMobility.Vehicle_Configuration;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

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
 * This is the item provider adapter for a {@link intelligentMobility.Vehicle_Configuration} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class Vehicle_ConfigurationItemProvider 
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
	public Vehicle_ConfigurationItemProvider(AdapterFactory adapterFactory) {
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

			addBrandNamePropertyDescriptor(object);
			addColorR_minPropertyDescriptor(object);
			addColorR_maxPropertyDescriptor(object);
			addColorG_minPropertyDescriptor(object);
			addColorG_maxPropertyDescriptor(object);
			addColorB_minPropertyDescriptor(object);
			addColorB_maxPropertyDescriptor(object);
			addGpsYawPropertyDescriptor(object);
			addGpsPitchPropertyDescriptor(object);
			addGpsRollPropertyDescriptor(object);
			addLatitudePropertyDescriptor(object);
			addLongitudePropertyDescriptor(object);
			addConnectedInfrastructurePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Brand Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addBrandNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Vehicle_Configuration_brandName_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Vehicle_Configuration_brandName_feature", "_UI_Vehicle_Configuration_type"),
				 IntelligentMobilityPackage.eINSTANCE.getVehicle_Configuration_BrandName(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Color Rmin feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addColorR_minPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Vehicle_Configuration_colorR_min_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Vehicle_Configuration_colorR_min_feature", "_UI_Vehicle_Configuration_type"),
				 IntelligentMobilityPackage.eINSTANCE.getVehicle_Configuration_ColorR_min(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Color Rmax feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addColorR_maxPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Vehicle_Configuration_colorR_max_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Vehicle_Configuration_colorR_max_feature", "_UI_Vehicle_Configuration_type"),
				 IntelligentMobilityPackage.eINSTANCE.getVehicle_Configuration_ColorR_max(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Color Gmin feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addColorG_minPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Vehicle_Configuration_colorG_min_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Vehicle_Configuration_colorG_min_feature", "_UI_Vehicle_Configuration_type"),
				 IntelligentMobilityPackage.eINSTANCE.getVehicle_Configuration_ColorG_min(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Color Gmax feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addColorG_maxPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Vehicle_Configuration_colorG_max_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Vehicle_Configuration_colorG_max_feature", "_UI_Vehicle_Configuration_type"),
				 IntelligentMobilityPackage.eINSTANCE.getVehicle_Configuration_ColorG_max(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Color Bmin feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addColorB_minPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Vehicle_Configuration_colorB_min_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Vehicle_Configuration_colorB_min_feature", "_UI_Vehicle_Configuration_type"),
				 IntelligentMobilityPackage.eINSTANCE.getVehicle_Configuration_ColorB_min(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Color Bmax feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addColorB_maxPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Vehicle_Configuration_colorB_max_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Vehicle_Configuration_colorB_max_feature", "_UI_Vehicle_Configuration_type"),
				 IntelligentMobilityPackage.eINSTANCE.getVehicle_Configuration_ColorB_max(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Gps Yaw feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addGpsYawPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Vehicle_Configuration_gpsYaw_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Vehicle_Configuration_gpsYaw_feature", "_UI_Vehicle_Configuration_type"),
				 IntelligentMobilityPackage.eINSTANCE.getVehicle_Configuration_GpsYaw(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Gps Pitch feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addGpsPitchPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Vehicle_Configuration_gpsPitch_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Vehicle_Configuration_gpsPitch_feature", "_UI_Vehicle_Configuration_type"),
				 IntelligentMobilityPackage.eINSTANCE.getVehicle_Configuration_GpsPitch(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Gps Roll feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addGpsRollPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Vehicle_Configuration_gpsRoll_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Vehicle_Configuration_gpsRoll_feature", "_UI_Vehicle_Configuration_type"),
				 IntelligentMobilityPackage.eINSTANCE.getVehicle_Configuration_GpsRoll(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Latitude feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLatitudePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Vehicle_Configuration_latitude_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Vehicle_Configuration_latitude_feature", "_UI_Vehicle_Configuration_type"),
				 IntelligentMobilityPackage.eINSTANCE.getVehicle_Configuration_Latitude(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Longitude feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLongitudePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Vehicle_Configuration_longitude_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Vehicle_Configuration_longitude_feature", "_UI_Vehicle_Configuration_type"),
				 IntelligentMobilityPackage.eINSTANCE.getVehicle_Configuration_Longitude(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Connected Infrastructure feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addConnectedInfrastructurePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Vehicle_Configuration_connectedInfrastructure_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Vehicle_Configuration_connectedInfrastructure_feature", "_UI_Vehicle_Configuration_type"),
				 IntelligentMobilityPackage.eINSTANCE.getVehicle_Configuration_ConnectedInfrastructure(),
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
	public Collection getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getVehicle_Configuration_Vehicle_type());
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns Vehicle_Configuration.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Vehicle_Configuration"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText(Object object) {
		String label = ((Vehicle_Configuration)object).getBrandName();
		return label == null || label.length() == 0 ?
			getString("_UI_Vehicle_Configuration_type") :
			getString("_UI_Vehicle_Configuration_type") + " " + label;
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

		switch (notification.getFeatureID(Vehicle_Configuration.class)) {
			case IntelligentMobilityPackage.VEHICLE_CONFIGURATION__BRAND_NAME:
			case IntelligentMobilityPackage.VEHICLE_CONFIGURATION__COLOR_RMIN:
			case IntelligentMobilityPackage.VEHICLE_CONFIGURATION__COLOR_RMAX:
			case IntelligentMobilityPackage.VEHICLE_CONFIGURATION__COLOR_GMIN:
			case IntelligentMobilityPackage.VEHICLE_CONFIGURATION__COLOR_GMAX:
			case IntelligentMobilityPackage.VEHICLE_CONFIGURATION__COLOR_BMIN:
			case IntelligentMobilityPackage.VEHICLE_CONFIGURATION__COLOR_BMAX:
			case IntelligentMobilityPackage.VEHICLE_CONFIGURATION__GPS_YAW:
			case IntelligentMobilityPackage.VEHICLE_CONFIGURATION__GPS_PITCH:
			case IntelligentMobilityPackage.VEHICLE_CONFIGURATION__GPS_ROLL:
			case IntelligentMobilityPackage.VEHICLE_CONFIGURATION__LATITUDE:
			case IntelligentMobilityPackage.VEHICLE_CONFIGURATION__LONGITUDE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case IntelligentMobilityPackage.VEHICLE_CONFIGURATION__VEHICLE_TYPE:
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
	protected void collectNewChildDescriptors(Collection newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getVehicle_Configuration_Vehicle_type(),
				 IntelligentMobilityFactory.eINSTANCE.createPlatoon()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getVehicle_Configuration_Vehicle_type(),
				 IntelligentMobilityFactory.eINSTANCE.createNormal_Vehicle()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getVehicle_Configuration_Vehicle_type(),
				 IntelligentMobilityFactory.eINSTANCE.createLeading_Vehicle()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getVehicle_Configuration_Vehicle_type(),
				 IntelligentMobilityFactory.eINSTANCE.createFollowing_Vehicle()));
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
