/**
 */
package intelligentMobility.provider;


import intelligentMobility.IntelligentMobilityFactory;
import intelligentMobility.IntelligentMobilityPackage;
import intelligentMobility.MobilitySystem;

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
 * This is the item provider adapter for a {@link intelligentMobility.MobilitySystem} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class MobilitySystemItemProvider 
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
	public MobilitySystemItemProvider(AdapterFactory adapterFactory) {
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

			addSystemIDPropertyDescriptor(object);
			addGeographicalScopePropertyDescriptor(object);
			addInfrastructureTypePropertyDescriptor(object);
			addGoalPropertyDescriptor(object);
			addLink_infrastructure_vehicle_configurationPropertyDescriptor(object);
			addLink_communicationInterface_vehicleConfigurationPropertyDescriptor(object);
			addLink_communicationInterface_infrastructurePropertyDescriptor(object);
			addCooperativeBehaviourPropertyDescriptor(object);
			addLink_cooperativeBehaviour_vehicleConfigurationPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the System ID feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSystemIDPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MobilitySystem_systemID_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_MobilitySystem_systemID_feature", "_UI_MobilitySystem_type"),
				 IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_SystemID(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Geographical Scope feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addGeographicalScopePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MobilitySystem_geographicalScope_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_MobilitySystem_geographicalScope_feature", "_UI_MobilitySystem_type"),
				 IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_GeographicalScope(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Infrastructure Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addInfrastructureTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MobilitySystem_infrastructureType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_MobilitySystem_infrastructureType_feature", "_UI_MobilitySystem_type"),
				 IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_InfrastructureType(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Goal feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addGoalPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MobilitySystem_goal_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_MobilitySystem_goal_feature", "_UI_MobilitySystem_type"),
				 IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Goal(),
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Link infrastructure vehicle configuration feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLink_infrastructure_vehicle_configurationPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MobilitySystem_link_infrastructure_vehicle_configuration_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_MobilitySystem_link_infrastructure_vehicle_configuration_feature", "_UI_MobilitySystem_type"),
				 IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Link_infrastructure_vehicle_configuration(),
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Link communication Interface vehicle Configuration feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLink_communicationInterface_vehicleConfigurationPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MobilitySystem_link_communicationInterface_vehicleConfiguration_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_MobilitySystem_link_communicationInterface_vehicleConfiguration_feature", "_UI_MobilitySystem_type"),
				 IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Link_communicationInterface_vehicleConfiguration(),
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Link communication Interface infrastructure feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLink_communicationInterface_infrastructurePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MobilitySystem_link_communicationInterface_infrastructure_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_MobilitySystem_link_communicationInterface_infrastructure_feature", "_UI_MobilitySystem_type"),
				 IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Link_communicationInterface_infrastructure(),
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Cooperative Behaviour feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCooperativeBehaviourPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MobilitySystem_cooperativeBehaviour_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_MobilitySystem_cooperativeBehaviour_feature", "_UI_MobilitySystem_type"),
				 IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_CooperativeBehaviour(),
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Link cooperative Behaviour vehicle Configuration feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLink_cooperativeBehaviour_vehicleConfigurationPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MobilitySystem_link_cooperativeBehaviour_vehicleConfiguration_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_MobilitySystem_link_cooperativeBehaviour_vehicleConfiguration_feature", "_UI_MobilitySystem_type"),
				 IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Link_cooperativeBehaviour_vehicleConfiguration(),
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
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Driver_profile());
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Vehicle_configuration());
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Environment_background());
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Driver_preference());
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Knowledge_and_skill());
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Driver_emotion());
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Driving_behaviour());
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Normal_behaviour());
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Following());
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Lane_changing());
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Abnormal_behaviour());
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Forward());
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Backward());
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Turn());
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Gap_acceptance());
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Action());
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Vehicle_type());
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Platoon());
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Normal_vehicle());
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Leading_vehicle());
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Following_vehicle());
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Platoon_member());
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Possible_vehicle());
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Environment_condition());
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Lane_type());
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Regulation());
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Safety_requirement());
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Weather());
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Traffic_situation());
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Special_condition());
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Collision());
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Intersection());
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Obstruction());
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Traffic_light());
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Execption_condition());
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Link_driver_vehicle());
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Link_driver_environment());
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Link_vehicle_environment());
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Link_driverProfile_driverPreference());
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Link_vehicleConfiguration_vehicleType());
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Link_environmentBackground_possibleVehicle());
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Link_environmentBackground_environmentCondition());
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Link_driverPreference_driverEmotion());
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Link_driverPreference_drivingBehaviour());
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Link_driverPreference_environmentCondition());
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Link_drivingBehaviour_normalBehaviour());
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Link_normalBehaviour_following());
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Link_normalBehaviour_laneChanging());
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Link_following_minGap());
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Link_following_forward());
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Link_following_backward());
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Link_laneChanging_turn());
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Link_laneChanging_gapAcceptance());
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Link_laneChanging_environmentCondition());
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Link_abnormalBehaviour_action());
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Link_platoon_leadingVehicle());
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Link_platoon_followingVehicle());
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Link_normalVehicle_safetyRequirement());
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Link_followingVehicle_frontVehicle());
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Link_environmentCondition_laneType());
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Link_environmentCondition_regulation());
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Link_environmentCondition_weather());
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Link_environmentCondition_trafficCondition());
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Link_environmentCondition_specialCondition());
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Link_laneType_regulation());
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Link_safetyRequirement_regulation());
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Link_specialCondition_intersection());
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Link_collision_obstruction());
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Link_intersection_trafficLight());
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Infrastructure());
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_CommunicationInterfaces());
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Link_goal_drivingBehaviour());
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Link_cooperativeBehaviour_communicationInterface());
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Link_trafficSituation_environmentCondition());
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Link_following_laneChanging());
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Link_collision_specialCondition());
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Link_action_backward());
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Link_action_forward());
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Link_action_turn());
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Link_knowledgeAndSkill_driverPreference());
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
	 * This returns MobilitySystem.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/MobilitySystem"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText(Object object) {
		MobilitySystem mobilitySystem = (MobilitySystem)object;
		return getString("_UI_MobilitySystem_type") + " " + mobilitySystem.getSystemID();
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

		switch (notification.getFeatureID(MobilitySystem.class)) {
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__SYSTEM_ID:
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__GEOGRAPHICAL_SCOPE:
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__INFRASTRUCTURE_TYPE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__DRIVER_PROFILE:
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__VEHICLE_CONFIGURATION:
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__ENVIRONMENT_BACKGROUND:
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__DRIVER_PREFERENCE:
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__KNOWLEDGE_AND_SKILL:
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__DRIVER_EMOTION:
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__DRIVING_BEHAVIOUR:
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__NORMAL_BEHAVIOUR:
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__FOLLOWING:
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LANE_CHANGING:
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__ABNORMAL_BEHAVIOUR:
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__FORWARD:
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__BACKWARD:
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__TURN:
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__GAP_ACCEPTANCE:
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__ACTION:
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__VEHICLE_TYPE:
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__PLATOON:
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__NORMAL_VEHICLE:
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LEADING_VEHICLE:
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__FOLLOWING_VEHICLE:
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__PLATOON_MEMBER:
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__POSSIBLE_VEHICLE:
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__ENVIRONMENT_CONDITION:
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LANE_TYPE:
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__REGULATION:
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__SAFETY_REQUIREMENT:
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__WEATHER:
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__TRAFFIC_SITUATION:
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__SPECIAL_CONDITION:
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__COLLISION:
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__INTERSECTION:
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__OBSTRUCTION:
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__TRAFFIC_LIGHT:
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__EXECPTION_CONDITION:
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_DRIVER_VEHICLE:
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_DRIVER_ENVIRONMENT:
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_VEHICLE_ENVIRONMENT:
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_DRIVER_PROFILE_DRIVER_PREFERENCE:
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_VEHICLE_CONFIGURATION_VEHICLE_TYPE:
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_ENVIRONMENT_BACKGROUND_POSSIBLE_VEHICLE:
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_ENVIRONMENT_BACKGROUND_ENVIRONMENT_CONDITION:
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_DRIVER_PREFERENCE_DRIVER_EMOTION:
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_DRIVER_PREFERENCE_DRIVING_BEHAVIOUR:
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_DRIVER_PREFERENCE_ENVIRONMENT_CONDITION:
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_DRIVING_BEHAVIOUR_NORMAL_BEHAVIOUR:
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_NORMAL_BEHAVIOUR_FOLLOWING:
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_NORMAL_BEHAVIOUR_LANE_CHANGING:
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_FOLLOWING_MIN_GAP:
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_FOLLOWING_FORWARD:
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_FOLLOWING_BACKWARD:
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_LANE_CHANGING_TURN:
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_LANE_CHANGING_GAP_ACCEPTANCE:
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_LANE_CHANGING_ENVIRONMENT_CONDITION:
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_ABNORMAL_BEHAVIOUR_ACTION:
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_PLATOON_LEADING_VEHICLE:
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_PLATOON_FOLLOWING_VEHICLE:
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_NORMAL_VEHICLE_SAFETY_REQUIREMENT:
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_FOLLOWING_VEHICLE_FRONT_VEHICLE:
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_ENVIRONMENT_CONDITION_LANE_TYPE:
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_ENVIRONMENT_CONDITION_REGULATION:
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_ENVIRONMENT_CONDITION_WEATHER:
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_ENVIRONMENT_CONDITION_TRAFFIC_CONDITION:
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_ENVIRONMENT_CONDITION_SPECIAL_CONDITION:
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_LANE_TYPE_REGULATION:
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_SAFETY_REQUIREMENT_REGULATION:
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_SPECIAL_CONDITION_INTERSECTION:
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_COLLISION_OBSTRUCTION:
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_INTERSECTION_TRAFFIC_LIGHT:
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__INFRASTRUCTURE:
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__COMMUNICATION_INTERFACES:
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_GOAL_DRIVING_BEHAVIOUR:
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_COOPERATIVE_BEHAVIOUR_COMMUNICATION_INTERFACE:
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_TRAFFIC_SITUATION_ENVIRONMENT_CONDITION:
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_FOLLOWING_LANE_CHANGING:
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_COLLISION_SPECIAL_CONDITION:
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_ACTION_BACKWARD:
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_ACTION_FORWARD:
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_ACTION_TURN:
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_KNOWLEDGE_AND_SKILL_DRIVER_PREFERENCE:
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
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Driver_profile(),
				 IntelligentMobilityFactory.eINSTANCE.createDriver_Profile()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Vehicle_configuration(),
				 IntelligentMobilityFactory.eINSTANCE.createVehicle_Configuration()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Environment_background(),
				 IntelligentMobilityFactory.eINSTANCE.createEnvironment_Background()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Driver_preference(),
				 IntelligentMobilityFactory.eINSTANCE.createDriver_Preference()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Knowledge_and_skill(),
				 IntelligentMobilityFactory.eINSTANCE.createKnowledge_and_Skill()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Driver_emotion(),
				 IntelligentMobilityFactory.eINSTANCE.createDriver_Emotion()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Driving_behaviour(),
				 IntelligentMobilityFactory.eINSTANCE.createDriving_Behaviour()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Driving_behaviour(),
				 IntelligentMobilityFactory.eINSTANCE.createCooperativeBehavior()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Normal_behaviour(),
				 IntelligentMobilityFactory.eINSTANCE.createNormal_Behaviour()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Normal_behaviour(),
				 IntelligentMobilityFactory.eINSTANCE.createAbnormal_Behaviour()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Following(),
				 IntelligentMobilityFactory.eINSTANCE.createFollowing()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Lane_changing(),
				 IntelligentMobilityFactory.eINSTANCE.createLaneChanging()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Abnormal_behaviour(),
				 IntelligentMobilityFactory.eINSTANCE.createAbnormal_Behaviour()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Forward(),
				 IntelligentMobilityFactory.eINSTANCE.createForward()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Backward(),
				 IntelligentMobilityFactory.eINSTANCE.createBackward()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Turn(),
				 IntelligentMobilityFactory.eINSTANCE.createTurn()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Gap_acceptance(),
				 IntelligentMobilityFactory.eINSTANCE.createGapAcceptance()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Action(),
				 IntelligentMobilityFactory.eINSTANCE.createAction()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Action(),
				 IntelligentMobilityFactory.eINSTANCE.createForward()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Action(),
				 IntelligentMobilityFactory.eINSTANCE.createBackward()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Action(),
				 IntelligentMobilityFactory.eINSTANCE.createTurn()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Vehicle_type(),
				 IntelligentMobilityFactory.eINSTANCE.createPlatoon()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Vehicle_type(),
				 IntelligentMobilityFactory.eINSTANCE.createNormal_Vehicle()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Vehicle_type(),
				 IntelligentMobilityFactory.eINSTANCE.createLeading_Vehicle()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Vehicle_type(),
				 IntelligentMobilityFactory.eINSTANCE.createFollowing_Vehicle()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Platoon(),
				 IntelligentMobilityFactory.eINSTANCE.createPlatoon()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Normal_vehicle(),
				 IntelligentMobilityFactory.eINSTANCE.createNormal_Vehicle()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Normal_vehicle(),
				 IntelligentMobilityFactory.eINSTANCE.createLeading_Vehicle()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Normal_vehicle(),
				 IntelligentMobilityFactory.eINSTANCE.createFollowing_Vehicle()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Leading_vehicle(),
				 IntelligentMobilityFactory.eINSTANCE.createLeading_Vehicle()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Following_vehicle(),
				 IntelligentMobilityFactory.eINSTANCE.createFollowing_Vehicle()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Platoon_member(),
				 IntelligentMobilityFactory.eINSTANCE.createLeading_Vehicle()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Platoon_member(),
				 IntelligentMobilityFactory.eINSTANCE.createFollowing_Vehicle()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Possible_vehicle(),
				 IntelligentMobilityFactory.eINSTANCE.createPossibleVehicle()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Environment_condition(),
				 IntelligentMobilityFactory.eINSTANCE.createEnvironment_Condition()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Lane_type(),
				 IntelligentMobilityFactory.eINSTANCE.createLane_Type()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Regulation(),
				 IntelligentMobilityFactory.eINSTANCE.createRegulation()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Safety_requirement(),
				 IntelligentMobilityFactory.eINSTANCE.createSafety_Requirement()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Weather(),
				 IntelligentMobilityFactory.eINSTANCE.createWeather()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Traffic_situation(),
				 IntelligentMobilityFactory.eINSTANCE.createTraffic_Situation()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Special_condition(),
				 IntelligentMobilityFactory.eINSTANCE.createSpecial_Condition()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Collision(),
				 IntelligentMobilityFactory.eINSTANCE.createCollision()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Intersection(),
				 IntelligentMobilityFactory.eINSTANCE.createIntersection()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Obstruction(),
				 IntelligentMobilityFactory.eINSTANCE.createObstruction()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Traffic_light(),
				 IntelligentMobilityFactory.eINSTANCE.createTraffic_Light()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Execption_condition(),
				 IntelligentMobilityFactory.eINSTANCE.createExceptionCondition()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Execption_condition(),
				 IntelligentMobilityFactory.eINSTANCE.createCollision()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Execption_condition(),
				 IntelligentMobilityFactory.eINSTANCE.createIntersection()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Link_driver_vehicle(),
				 IntelligentMobilityFactory.eINSTANCE.createLink_Driver_Vehicle()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Link_driver_environment(),
				 IntelligentMobilityFactory.eINSTANCE.createLink_Driver_Environment()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Link_vehicle_environment(),
				 IntelligentMobilityFactory.eINSTANCE.createLink_Vehicle_Environment()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Link_driverProfile_driverPreference(),
				 IntelligentMobilityFactory.eINSTANCE.createLink_DriverProfile_DriverPreference()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Link_vehicleConfiguration_vehicleType(),
				 IntelligentMobilityFactory.eINSTANCE.createLink_VehicleConfiguration_VehicleType()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Link_environmentBackground_possibleVehicle(),
				 IntelligentMobilityFactory.eINSTANCE.createLink_EnvironmentBackground_PossibleVehicle()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Link_environmentBackground_environmentCondition(),
				 IntelligentMobilityFactory.eINSTANCE.createLink_EnvironmentBackground_EnvironmentCondition()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Link_driverPreference_driverEmotion(),
				 IntelligentMobilityFactory.eINSTANCE.createLink_DriverPreference_DriverEmotion()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Link_driverPreference_drivingBehaviour(),
				 IntelligentMobilityFactory.eINSTANCE.createLink_DriverPreference_DrivingBehaviour()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Link_driverPreference_environmentCondition(),
				 IntelligentMobilityFactory.eINSTANCE.createLink_DriverPreference_EnvironmentCondition()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Link_drivingBehaviour_normalBehaviour(),
				 IntelligentMobilityFactory.eINSTANCE.createLink_DrivingBehaviour_NormalBehaviour()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Link_normalBehaviour_following(),
				 IntelligentMobilityFactory.eINSTANCE.createLink_NormalBehaviour_Following()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Link_normalBehaviour_laneChanging(),
				 IntelligentMobilityFactory.eINSTANCE.createLink_NormalBehaviour_LaneChanging()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Link_following_minGap(),
				 IntelligentMobilityFactory.eINSTANCE.createLink_Following_MinGap()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Link_following_forward(),
				 IntelligentMobilityFactory.eINSTANCE.createLink_Following_Forward()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Link_following_backward(),
				 IntelligentMobilityFactory.eINSTANCE.createLink_Following_Backward()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Link_laneChanging_turn(),
				 IntelligentMobilityFactory.eINSTANCE.createLink_LaneChanging_Turn()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Link_laneChanging_gapAcceptance(),
				 IntelligentMobilityFactory.eINSTANCE.createLink_LaneChanging_GapAcceptance()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Link_laneChanging_environmentCondition(),
				 IntelligentMobilityFactory.eINSTANCE.createLink_LaneChanging_EnvironmentCondition()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Link_abnormalBehaviour_action(),
				 IntelligentMobilityFactory.eINSTANCE.createLink_AbnormalBehaviour_Action()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Link_platoon_leadingVehicle(),
				 IntelligentMobilityFactory.eINSTANCE.createLink_Platoon_LeadingVehicle()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Link_platoon_followingVehicle(),
				 IntelligentMobilityFactory.eINSTANCE.createLink_Platoon_FollowingVehicle()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Link_normalVehicle_safetyRequirement(),
				 IntelligentMobilityFactory.eINSTANCE.createLink_NormalVehicle_SafetyRequirements()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Link_followingVehicle_frontVehicle(),
				 IntelligentMobilityFactory.eINSTANCE.createLink_FollowingVehicle_FrontVehicle()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Link_environmentCondition_laneType(),
				 IntelligentMobilityFactory.eINSTANCE.createLink_EnvironmentCondition_LaneType()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Link_environmentCondition_regulation(),
				 IntelligentMobilityFactory.eINSTANCE.createLink_EnvironmentCondition_Regulations()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Link_environmentCondition_weather(),
				 IntelligentMobilityFactory.eINSTANCE.createLink_EnvironmentCondition_Weather()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Link_environmentCondition_trafficCondition(),
				 IntelligentMobilityFactory.eINSTANCE.createLink_EnvironmentCondition_TrafficCondition()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Link_environmentCondition_specialCondition(),
				 IntelligentMobilityFactory.eINSTANCE.createLink_EnvironmentCondition_SpecialCondition()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Link_laneType_regulation(),
				 IntelligentMobilityFactory.eINSTANCE.createLink_LaneType_Regulation()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Link_safetyRequirement_regulation(),
				 IntelligentMobilityFactory.eINSTANCE.createLink_SafetyRequirement_Regulation()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Link_specialCondition_intersection(),
				 IntelligentMobilityFactory.eINSTANCE.createLink_SpecialCondition_Intersection()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Link_collision_obstruction(),
				 IntelligentMobilityFactory.eINSTANCE.createLink_Collision_Obstruction()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Link_intersection_trafficLight(),
				 IntelligentMobilityFactory.eINSTANCE.createLink_Intersection_TrafficLight()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Infrastructure(),
				 IntelligentMobilityFactory.eINSTANCE.createIntersection()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Infrastructure(),
				 IntelligentMobilityFactory.eINSTANCE.createTraffic_Light()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Infrastructure(),
				 IntelligentMobilityFactory.eINSTANCE.createRoadSegment()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Infrastructure(),
				 IntelligentMobilityFactory.eINSTANCE.createSmartSensor()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Infrastructure(),
				 IntelligentMobilityFactory.eINSTANCE.createRoad_Side_Unit()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Infrastructure(),
				 IntelligentMobilityFactory.eINSTANCE.createChargingStation()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_CommunicationInterfaces(),
				 IntelligentMobilityFactory.eINSTANCE.createCommunicationInterface()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Link_goal_drivingBehaviour(),
				 IntelligentMobilityFactory.eINSTANCE.createLink_Goal_DrivingBehaviour()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Link_cooperativeBehaviour_communicationInterface(),
				 IntelligentMobilityFactory.eINSTANCE.createLink_CooperativeBehaviour_CommunicationInterface()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Link_trafficSituation_environmentCondition(),
				 IntelligentMobilityFactory.eINSTANCE.createLink_TrafficSituation_EnvironmentCondition()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Link_following_laneChanging(),
				 IntelligentMobilityFactory.eINSTANCE.createLink_Following_LaneChanging()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Link_collision_specialCondition(),
				 IntelligentMobilityFactory.eINSTANCE.createLink_Collision_SpecialCondition()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Link_action_backward(),
				 IntelligentMobilityFactory.eINSTANCE.createLink_Action_Backward()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Link_action_forward(),
				 IntelligentMobilityFactory.eINSTANCE.createLink_Action_Forward()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Link_action_turn(),
				 IntelligentMobilityFactory.eINSTANCE.createLink_Action_Turn()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Link_knowledgeAndSkill_driverPreference(),
				 IntelligentMobilityFactory.eINSTANCE.createLink_KnowledgeAndSkill_DriverPreference()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCreateChildText(Object owner, Object feature, Object child, Collection selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify =
			childFeature == IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Normal_behaviour() ||
			childFeature == IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Abnormal_behaviour() ||
			childFeature == IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Forward() ||
			childFeature == IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Action() ||
			childFeature == IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Backward() ||
			childFeature == IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Turn() ||
			childFeature == IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Vehicle_type() ||
			childFeature == IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Platoon() ||
			childFeature == IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Normal_vehicle() ||
			childFeature == IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Leading_vehicle() ||
			childFeature == IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Platoon_member() ||
			childFeature == IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Following_vehicle() ||
			childFeature == IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Collision() ||
			childFeature == IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Execption_condition() ||
			childFeature == IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Intersection() ||
			childFeature == IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Infrastructure() ||
			childFeature == IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Traffic_light();

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
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
