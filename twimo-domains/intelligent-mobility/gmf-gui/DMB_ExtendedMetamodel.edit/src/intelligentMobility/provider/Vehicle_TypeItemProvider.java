/**
 */
package intelligentMobility.provider;


import intelligentMobility.CarType;
import intelligentMobility.IntelligentMobilityPackage;
import intelligentMobility.Vehicle_Type;

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
 * This is the item provider adapter for a {@link intelligentMobility.Vehicle_Type} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class Vehicle_TypeItemProvider 
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
	public Vehicle_TypeItemProvider(AdapterFactory adapterFactory) {
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

			addTypePropertyDescriptor(object);
			addMaxSpeedPropertyDescriptor(object);
			addVehicleWidth_minPropertyDescriptor(object);
			addVehicleWidth_maxPropertyDescriptor(object);
			addVehicleWidth_precisionPropertyDescriptor(object);
			addVehicleLength_minPropertyDescriptor(object);
			addVehicleLength_maxPropertyDescriptor(object);
			addVehicleLength_precisionPropertyDescriptor(object);
			addVehicleHeight_minPropertyDescriptor(object);
			addVehicleHeight_maxPropertyDescriptor(object);
			addVehicleHeight_precisionPropertyDescriptor(object);
			addSpeedPropertyDescriptor(object);
			addStopPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Vehicle_Type_type_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Vehicle_Type_type_feature", "_UI_Vehicle_Type_type"),
				 IntelligentMobilityPackage.eINSTANCE.getVehicle_Type_Type(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Max Speed feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMaxSpeedPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Vehicle_Type_maxSpeed_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Vehicle_Type_maxSpeed_feature", "_UI_Vehicle_Type_type"),
				 IntelligentMobilityPackage.eINSTANCE.getVehicle_Type_MaxSpeed(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Vehicle Width min feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addVehicleWidth_minPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Vehicle_Type_vehicleWidth_min_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Vehicle_Type_vehicleWidth_min_feature", "_UI_Vehicle_Type_type"),
				 IntelligentMobilityPackage.eINSTANCE.getVehicle_Type_VehicleWidth_min(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Vehicle Width max feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addVehicleWidth_maxPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Vehicle_Type_vehicleWidth_max_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Vehicle_Type_vehicleWidth_max_feature", "_UI_Vehicle_Type_type"),
				 IntelligentMobilityPackage.eINSTANCE.getVehicle_Type_VehicleWidth_max(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Vehicle Width precision feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addVehicleWidth_precisionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Vehicle_Type_vehicleWidth_precision_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Vehicle_Type_vehicleWidth_precision_feature", "_UI_Vehicle_Type_type"),
				 IntelligentMobilityPackage.eINSTANCE.getVehicle_Type_VehicleWidth_precision(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Vehicle Length min feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addVehicleLength_minPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Vehicle_Type_vehicleLength_min_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Vehicle_Type_vehicleLength_min_feature", "_UI_Vehicle_Type_type"),
				 IntelligentMobilityPackage.eINSTANCE.getVehicle_Type_VehicleLength_min(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Vehicle Length max feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addVehicleLength_maxPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Vehicle_Type_vehicleLength_max_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Vehicle_Type_vehicleLength_max_feature", "_UI_Vehicle_Type_type"),
				 IntelligentMobilityPackage.eINSTANCE.getVehicle_Type_VehicleLength_max(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Vehicle Length precision feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addVehicleLength_precisionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Vehicle_Type_vehicleLength_precision_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Vehicle_Type_vehicleLength_precision_feature", "_UI_Vehicle_Type_type"),
				 IntelligentMobilityPackage.eINSTANCE.getVehicle_Type_VehicleLength_precision(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Vehicle Height min feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addVehicleHeight_minPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Vehicle_Type_vehicleHeight_min_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Vehicle_Type_vehicleHeight_min_feature", "_UI_Vehicle_Type_type"),
				 IntelligentMobilityPackage.eINSTANCE.getVehicle_Type_VehicleHeight_min(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Vehicle Height max feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addVehicleHeight_maxPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Vehicle_Type_vehicleHeight_max_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Vehicle_Type_vehicleHeight_max_feature", "_UI_Vehicle_Type_type"),
				 IntelligentMobilityPackage.eINSTANCE.getVehicle_Type_VehicleHeight_max(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Vehicle Height precision feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addVehicleHeight_precisionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Vehicle_Type_vehicleHeight_precision_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Vehicle_Type_vehicleHeight_precision_feature", "_UI_Vehicle_Type_type"),
				 IntelligentMobilityPackage.eINSTANCE.getVehicle_Type_VehicleHeight_precision(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Speed feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSpeedPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Vehicle_Type_speed_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Vehicle_Type_speed_feature", "_UI_Vehicle_Type_type"),
				 IntelligentMobilityPackage.eINSTANCE.getVehicle_Type_Speed(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Stop feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addStopPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Vehicle_Type_stop_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Vehicle_Type_stop_feature", "_UI_Vehicle_Type_type"),
				 IntelligentMobilityPackage.eINSTANCE.getVehicle_Type_Stop(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText(Object object) {
		CarType labelValue = ((Vehicle_Type)object).getType();
		String label = labelValue == null ? null : labelValue.toString();
		return label == null || label.length() == 0 ?
			getString("_UI_Vehicle_Type_type") :
			getString("_UI_Vehicle_Type_type") + " " + label;
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

		switch (notification.getFeatureID(Vehicle_Type.class)) {
			case IntelligentMobilityPackage.VEHICLE_TYPE__TYPE:
			case IntelligentMobilityPackage.VEHICLE_TYPE__MAX_SPEED:
			case IntelligentMobilityPackage.VEHICLE_TYPE__VEHICLE_WIDTH_MIN:
			case IntelligentMobilityPackage.VEHICLE_TYPE__VEHICLE_WIDTH_MAX:
			case IntelligentMobilityPackage.VEHICLE_TYPE__VEHICLE_WIDTH_PRECISION:
			case IntelligentMobilityPackage.VEHICLE_TYPE__VEHICLE_LENGTH_MIN:
			case IntelligentMobilityPackage.VEHICLE_TYPE__VEHICLE_LENGTH_MAX:
			case IntelligentMobilityPackage.VEHICLE_TYPE__VEHICLE_LENGTH_PRECISION:
			case IntelligentMobilityPackage.VEHICLE_TYPE__VEHICLE_HEIGHT_MIN:
			case IntelligentMobilityPackage.VEHICLE_TYPE__VEHICLE_HEIGHT_MAX:
			case IntelligentMobilityPackage.VEHICLE_TYPE__VEHICLE_HEIGHT_PRECISION:
			case IntelligentMobilityPackage.VEHICLE_TYPE__SPEED:
			case IntelligentMobilityPackage.VEHICLE_TYPE__STOP:
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
