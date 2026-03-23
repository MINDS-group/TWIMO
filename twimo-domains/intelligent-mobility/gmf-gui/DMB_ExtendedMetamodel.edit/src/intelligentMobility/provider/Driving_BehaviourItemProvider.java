/**
 */
package intelligentMobility.provider;


import intelligentMobility.Driving_Behaviour;
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
 * This is the item provider adapter for a {@link intelligentMobility.Driving_Behaviour} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class Driving_BehaviourItemProvider 
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
	public Driving_BehaviourItemProvider(AdapterFactory adapterFactory) {
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

			addPrepDistanceForDestinationPropertyDescriptor(object);
			addPrepDistanceForTurnPropertyDescriptor(object);
			addInitialSpeed_minPropertyDescriptor(object);
			addInitialSpeed_maxPropertyDescriptor(object);
			addInitialSpeed_precisionPropertyDescriptor(object);
			addDesiredSpeed_minPropertyDescriptor(object);
			addDesiredSpeed_maxPropertyDescriptor(object);
			addNamePropertyDescriptor(object);
			addSteeringAnglePropertyDescriptor(object);
			addThrottlePropertyDescriptor(object);
			addBrakePropertyDescriptor(object);
			addGearPropertyDescriptor(object);
			addHandbrakePropertyDescriptor(object);
			addRpmPropertyDescriptor(object);
			addKeyEventPropertyDescriptor(object);
			addPedalAnglePropertyDescriptor(object);
			addPedalPressurePropertyDescriptor(object);
			addSteerSpeedPropertyDescriptor(object);
			addIntentTypePropertyDescriptor(object);
			addConfidencePropertyDescriptor(object);
			addGoalPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Prep Distance For Destination feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPrepDistanceForDestinationPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Driving_Behaviour_prepDistanceForDestination_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Driving_Behaviour_prepDistanceForDestination_feature", "_UI_Driving_Behaviour_type"),
				 IntelligentMobilityPackage.eINSTANCE.getDriving_Behaviour_PrepDistanceForDestination(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Prep Distance For Turn feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPrepDistanceForTurnPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Driving_Behaviour_prepDistanceForTurn_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Driving_Behaviour_prepDistanceForTurn_feature", "_UI_Driving_Behaviour_type"),
				 IntelligentMobilityPackage.eINSTANCE.getDriving_Behaviour_PrepDistanceForTurn(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Initial Speed min feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addInitialSpeed_minPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Driving_Behaviour_initialSpeed_min_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Driving_Behaviour_initialSpeed_min_feature", "_UI_Driving_Behaviour_type"),
				 IntelligentMobilityPackage.eINSTANCE.getDriving_Behaviour_InitialSpeed_min(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Initial Speed max feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addInitialSpeed_maxPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Driving_Behaviour_initialSpeed_max_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Driving_Behaviour_initialSpeed_max_feature", "_UI_Driving_Behaviour_type"),
				 IntelligentMobilityPackage.eINSTANCE.getDriving_Behaviour_InitialSpeed_max(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Initial Speed precision feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addInitialSpeed_precisionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Driving_Behaviour_initialSpeed_precision_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Driving_Behaviour_initialSpeed_precision_feature", "_UI_Driving_Behaviour_type"),
				 IntelligentMobilityPackage.eINSTANCE.getDriving_Behaviour_InitialSpeed_precision(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Desired Speed min feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDesiredSpeed_minPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Driving_Behaviour_desiredSpeed_min_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Driving_Behaviour_desiredSpeed_min_feature", "_UI_Driving_Behaviour_type"),
				 IntelligentMobilityPackage.eINSTANCE.getDriving_Behaviour_DesiredSpeed_min(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Desired Speed max feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDesiredSpeed_maxPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Driving_Behaviour_desiredSpeed_max_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Driving_Behaviour_desiredSpeed_max_feature", "_UI_Driving_Behaviour_type"),
				 IntelligentMobilityPackage.eINSTANCE.getDriving_Behaviour_DesiredSpeed_max(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Driving_Behaviour_name_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Driving_Behaviour_name_feature", "_UI_Driving_Behaviour_type"),
				 IntelligentMobilityPackage.eINSTANCE.getDriving_Behaviour_Name(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Steering Angle feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSteeringAnglePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Driving_Behaviour_steeringAngle_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Driving_Behaviour_steeringAngle_feature", "_UI_Driving_Behaviour_type"),
				 IntelligentMobilityPackage.eINSTANCE.getDriving_Behaviour_SteeringAngle(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Throttle feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addThrottlePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Driving_Behaviour_throttle_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Driving_Behaviour_throttle_feature", "_UI_Driving_Behaviour_type"),
				 IntelligentMobilityPackage.eINSTANCE.getDriving_Behaviour_Throttle(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Brake feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addBrakePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Driving_Behaviour_brake_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Driving_Behaviour_brake_feature", "_UI_Driving_Behaviour_type"),
				 IntelligentMobilityPackage.eINSTANCE.getDriving_Behaviour_Brake(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Gear feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addGearPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Driving_Behaviour_gear_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Driving_Behaviour_gear_feature", "_UI_Driving_Behaviour_type"),
				 IntelligentMobilityPackage.eINSTANCE.getDriving_Behaviour_Gear(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Handbrake feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addHandbrakePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Driving_Behaviour_handbrake_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Driving_Behaviour_handbrake_feature", "_UI_Driving_Behaviour_type"),
				 IntelligentMobilityPackage.eINSTANCE.getDriving_Behaviour_Handbrake(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Rpm feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRpmPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Driving_Behaviour_rpm_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Driving_Behaviour_rpm_feature", "_UI_Driving_Behaviour_type"),
				 IntelligentMobilityPackage.eINSTANCE.getDriving_Behaviour_Rpm(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Key Event feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addKeyEventPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Driving_Behaviour_keyEvent_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Driving_Behaviour_keyEvent_feature", "_UI_Driving_Behaviour_type"),
				 IntelligentMobilityPackage.eINSTANCE.getDriving_Behaviour_KeyEvent(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Pedal Angle feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPedalAnglePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Driving_Behaviour_pedalAngle_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Driving_Behaviour_pedalAngle_feature", "_UI_Driving_Behaviour_type"),
				 IntelligentMobilityPackage.eINSTANCE.getDriving_Behaviour_PedalAngle(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Pedal Pressure feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPedalPressurePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Driving_Behaviour_pedalPressure_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Driving_Behaviour_pedalPressure_feature", "_UI_Driving_Behaviour_type"),
				 IntelligentMobilityPackage.eINSTANCE.getDriving_Behaviour_PedalPressure(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Steer Speed feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSteerSpeedPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Driving_Behaviour_steerSpeed_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Driving_Behaviour_steerSpeed_feature", "_UI_Driving_Behaviour_type"),
				 IntelligentMobilityPackage.eINSTANCE.getDriving_Behaviour_SteerSpeed(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Intent Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIntentTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Driving_Behaviour_intentType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Driving_Behaviour_intentType_feature", "_UI_Driving_Behaviour_type"),
				 IntelligentMobilityPackage.eINSTANCE.getDriving_Behaviour_IntentType(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Confidence feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addConfidencePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Driving_Behaviour_confidence_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Driving_Behaviour_confidence_feature", "_UI_Driving_Behaviour_type"),
				 IntelligentMobilityPackage.eINSTANCE.getDriving_Behaviour_Confidence(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
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
				 getString("_UI_Driving_Behaviour_goal_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Driving_Behaviour_goal_feature", "_UI_Driving_Behaviour_type"),
				 IntelligentMobilityPackage.eINSTANCE.getDriving_Behaviour_Goal(),
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
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getDriving_Behaviour_Normal_behaviour());
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
	 * This returns Driving_Behaviour.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Driving_Behaviour"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText(Object object) {
		String label = ((Driving_Behaviour)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_Driving_Behaviour_type") :
			getString("_UI_Driving_Behaviour_type") + " " + label;
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

		switch (notification.getFeatureID(Driving_Behaviour.class)) {
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__PREP_DISTANCE_FOR_DESTINATION:
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__PREP_DISTANCE_FOR_TURN:
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__INITIAL_SPEED_MIN:
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__INITIAL_SPEED_MAX:
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__INITIAL_SPEED_PRECISION:
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__DESIRED_SPEED_MIN:
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__DESIRED_SPEED_MAX:
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__NAME:
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__STEERING_ANGLE:
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__THROTTLE:
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__BRAKE:
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__GEAR:
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__HANDBRAKE:
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__RPM:
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__KEY_EVENT:
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__PEDAL_ANGLE:
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__PEDAL_PRESSURE:
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__STEER_SPEED:
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__INTENT_TYPE:
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__CONFIDENCE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__NORMAL_BEHAVIOUR:
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
				(IntelligentMobilityPackage.eINSTANCE.getDriving_Behaviour_Normal_behaviour(),
				 IntelligentMobilityFactory.eINSTANCE.createNormal_Behaviour()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getDriving_Behaviour_Normal_behaviour(),
				 IntelligentMobilityFactory.eINSTANCE.createAbnormal_Behaviour()));
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
