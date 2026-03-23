/**
 */
package intelligentMobility.provider;


import intelligentMobility.Driver_Profile;
import intelligentMobility.IntelligentMobilityFactory;
import intelligentMobility.IntelligentMobilityPackage;

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
 * This is the item provider adapter for a {@link intelligentMobility.Driver_Profile} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class Driver_ProfileItemProvider 
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
	public Driver_ProfileItemProvider(AdapterFactory adapterFactory) {
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

			addDriverNamePropertyDescriptor(object);
			addDriverTypePropertyDescriptor(object);
			addPatienceValuePropertyDescriptor(object);
			addLanePreferencePropertyDescriptor(object);
			addEnergySpeedRatePropertyDescriptor(object);
			addRiskLevelPropertyDescriptor(object);
			addReactionTime_minPropertyDescriptor(object);
			addReactionTime_maxPropertyDescriptor(object);
			addReactionTime_precisionPropertyDescriptor(object);
			addAgePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Driver Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDriverNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Driver_Profile_driverName_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Driver_Profile_driverName_feature", "_UI_Driver_Profile_type"),
				 IntelligentMobilityPackage.eINSTANCE.getDriver_Profile_DriverName(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Driver Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDriverTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Driver_Profile_driverType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Driver_Profile_driverType_feature", "_UI_Driver_Profile_type"),
				 IntelligentMobilityPackage.eINSTANCE.getDriver_Profile_DriverType(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Patience Value feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPatienceValuePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Driver_Profile_patienceValue_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Driver_Profile_patienceValue_feature", "_UI_Driver_Profile_type"),
				 IntelligentMobilityPackage.eINSTANCE.getDriver_Profile_PatienceValue(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Lane Preference feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLanePreferencePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Driver_Profile_lanePreference_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Driver_Profile_lanePreference_feature", "_UI_Driver_Profile_type"),
				 IntelligentMobilityPackage.eINSTANCE.getDriver_Profile_LanePreference(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Energy Speed Rate feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEnergySpeedRatePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Driver_Profile_energySpeedRate_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Driver_Profile_energySpeedRate_feature", "_UI_Driver_Profile_type"),
				 IntelligentMobilityPackage.eINSTANCE.getDriver_Profile_EnergySpeedRate(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Risk Level feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRiskLevelPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Driver_Profile_riskLevel_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Driver_Profile_riskLevel_feature", "_UI_Driver_Profile_type"),
				 IntelligentMobilityPackage.eINSTANCE.getDriver_Profile_RiskLevel(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Reaction Time min feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addReactionTime_minPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Driver_Profile_reactionTime_min_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Driver_Profile_reactionTime_min_feature", "_UI_Driver_Profile_type"),
				 IntelligentMobilityPackage.eINSTANCE.getDriver_Profile_ReactionTime_min(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Reaction Time max feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addReactionTime_maxPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Driver_Profile_reactionTime_max_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Driver_Profile_reactionTime_max_feature", "_UI_Driver_Profile_type"),
				 IntelligentMobilityPackage.eINSTANCE.getDriver_Profile_ReactionTime_max(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Reaction Time precision feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addReactionTime_precisionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Driver_Profile_reactionTime_precision_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Driver_Profile_reactionTime_precision_feature", "_UI_Driver_Profile_type"),
				 IntelligentMobilityPackage.eINSTANCE.getDriver_Profile_ReactionTime_precision(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Age feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAgePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Driver_Profile_age_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Driver_Profile_age_feature", "_UI_Driver_Profile_type"),
				 IntelligentMobilityPackage.eINSTANCE.getDriver_Profile_Age(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
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
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getDriver_Profile_Driver_preference());
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
	 * This returns Driver_Profile.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Driver_Profile"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText(Object object) {
		String label = ((Driver_Profile)object).getDriverName();
		return label == null || label.length() == 0 ?
			getString("_UI_Driver_Profile_type") :
			getString("_UI_Driver_Profile_type") + " " + label;
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

		switch (notification.getFeatureID(Driver_Profile.class)) {
			case IntelligentMobilityPackage.DRIVER_PROFILE__DRIVER_NAME:
			case IntelligentMobilityPackage.DRIVER_PROFILE__DRIVER_TYPE:
			case IntelligentMobilityPackage.DRIVER_PROFILE__PATIENCE_VALUE:
			case IntelligentMobilityPackage.DRIVER_PROFILE__LANE_PREFERENCE:
			case IntelligentMobilityPackage.DRIVER_PROFILE__ENERGY_SPEED_RATE:
			case IntelligentMobilityPackage.DRIVER_PROFILE__RISK_LEVEL:
			case IntelligentMobilityPackage.DRIVER_PROFILE__REACTION_TIME_MIN:
			case IntelligentMobilityPackage.DRIVER_PROFILE__REACTION_TIME_MAX:
			case IntelligentMobilityPackage.DRIVER_PROFILE__REACTION_TIME_PRECISION:
			case IntelligentMobilityPackage.DRIVER_PROFILE__AGE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case IntelligentMobilityPackage.DRIVER_PROFILE__DRIVER_PREFERENCE:
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
				(IntelligentMobilityPackage.eINSTANCE.getDriver_Profile_Driver_preference(),
				 IntelligentMobilityFactory.eINSTANCE.createDriver_Preference()));
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
