/**
 */
package intelligentMobility.provider;


import intelligentMobility.Environment_Condition;
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
 * This is the item provider adapter for a {@link intelligentMobility.Environment_Condition} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class Environment_ConditionItemProvider 
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
	public Environment_ConditionItemProvider(AdapterFactory adapterFactory) {
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

			addRoadTypePropertyDescriptor(object);
			addLaneAmountPropertyDescriptor(object);
			addName_EnvironmentConditionPropertyDescriptor(object);
			addCueTypePropertyDescriptor(object);
			addSaliencePropertyDescriptor(object);
			addPositionPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Road Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRoadTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Environment_Condition_roadType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Environment_Condition_roadType_feature", "_UI_Environment_Condition_type"),
				 IntelligentMobilityPackage.eINSTANCE.getEnvironment_Condition_RoadType(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Lane Amount feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLaneAmountPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Environment_Condition_laneAmount_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Environment_Condition_laneAmount_feature", "_UI_Environment_Condition_type"),
				 IntelligentMobilityPackage.eINSTANCE.getEnvironment_Condition_LaneAmount(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Name Environment Condition feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addName_EnvironmentConditionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Environment_Condition_name_EnvironmentCondition_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Environment_Condition_name_EnvironmentCondition_feature", "_UI_Environment_Condition_type"),
				 IntelligentMobilityPackage.eINSTANCE.getEnvironment_Condition_Name_EnvironmentCondition(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Cue Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCueTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Environment_Condition_cueType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Environment_Condition_cueType_feature", "_UI_Environment_Condition_type"),
				 IntelligentMobilityPackage.eINSTANCE.getEnvironment_Condition_CueType(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Salience feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSaliencePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Environment_Condition_salience_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Environment_Condition_salience_feature", "_UI_Environment_Condition_type"),
				 IntelligentMobilityPackage.eINSTANCE.getEnvironment_Condition_Salience(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Position feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPositionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Environment_Condition_position_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Environment_Condition_position_feature", "_UI_Environment_Condition_type"),
				 IntelligentMobilityPackage.eINSTANCE.getEnvironment_Condition_Position(),
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
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getEnvironment_Condition_Lane_type());
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getEnvironment_Condition_Regulations());
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getEnvironment_Condition_Weather());
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getEnvironment_Condition_Traffic_condition());
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getEnvironment_Condition_Special_condition());
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
	 * This returns Environment_Condition.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Environment_Condition"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText(Object object) {
		String label = ((Environment_Condition)object).getName_EnvironmentCondition();
		return label == null || label.length() == 0 ?
			getString("_UI_Environment_Condition_type") :
			getString("_UI_Environment_Condition_type") + " " + label;
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

		switch (notification.getFeatureID(Environment_Condition.class)) {
			case IntelligentMobilityPackage.ENVIRONMENT_CONDITION__ROAD_TYPE:
			case IntelligentMobilityPackage.ENVIRONMENT_CONDITION__LANE_AMOUNT:
			case IntelligentMobilityPackage.ENVIRONMENT_CONDITION__NAME_ENVIRONMENT_CONDITION:
			case IntelligentMobilityPackage.ENVIRONMENT_CONDITION__CUE_TYPE:
			case IntelligentMobilityPackage.ENVIRONMENT_CONDITION__SALIENCE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case IntelligentMobilityPackage.ENVIRONMENT_CONDITION__LANE_TYPE:
			case IntelligentMobilityPackage.ENVIRONMENT_CONDITION__REGULATIONS:
			case IntelligentMobilityPackage.ENVIRONMENT_CONDITION__WEATHER:
			case IntelligentMobilityPackage.ENVIRONMENT_CONDITION__TRAFFIC_CONDITION:
			case IntelligentMobilityPackage.ENVIRONMENT_CONDITION__SPECIAL_CONDITION:
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
				(IntelligentMobilityPackage.eINSTANCE.getEnvironment_Condition_Lane_type(),
				 IntelligentMobilityFactory.eINSTANCE.createLane_Type()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getEnvironment_Condition_Regulations(),
				 IntelligentMobilityFactory.eINSTANCE.createRegulation()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getEnvironment_Condition_Weather(),
				 IntelligentMobilityFactory.eINSTANCE.createWeather()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getEnvironment_Condition_Traffic_condition(),
				 IntelligentMobilityFactory.eINSTANCE.createTraffic_Situation()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getEnvironment_Condition_Special_condition(),
				 IntelligentMobilityFactory.eINSTANCE.createSpecial_Condition()));
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
