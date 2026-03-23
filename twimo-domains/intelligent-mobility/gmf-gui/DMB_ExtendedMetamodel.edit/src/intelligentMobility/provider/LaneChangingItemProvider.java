/**
 */
package intelligentMobility.provider;


import intelligentMobility.IntelligentMobilityFactory;
import intelligentMobility.IntelligentMobilityPackage;
import intelligentMobility.LaneChanging;

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
 * This is the item provider adapter for a {@link intelligentMobility.LaneChanging} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class LaneChangingItemProvider 
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
	public LaneChangingItemProvider(AdapterFactory adapterFactory) {
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

			addLaneSwitchSpeedPropertyDescriptor(object);
			addNamePropertyDescriptor(object);
			addEnvironment_conditionPropertyDescriptor(object);
			addLeftLaneChangePropertyDescriptor(object);
			addRightLaneChangePropertyDescriptor(object);
			addLeftLaneBranchPropertyDescriptor(object);
			addRightLaneBranchPropertyDescriptor(object);
			addActionPropertyDescriptor(object);
			addManeuverTypePropertyDescriptor(object);
			addDurationPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Lane Switch Speed feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLaneSwitchSpeedPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_LaneChanging_laneSwitchSpeed_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_LaneChanging_laneSwitchSpeed_feature", "_UI_LaneChanging_type"),
				 IntelligentMobilityPackage.eINSTANCE.getLaneChanging_LaneSwitchSpeed(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
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
				 getString("_UI_LaneChanging_name_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_LaneChanging_name_feature", "_UI_LaneChanging_type"),
				 IntelligentMobilityPackage.eINSTANCE.getLaneChanging_Name(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Environment condition feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEnvironment_conditionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_LaneChanging_environment_condition_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_LaneChanging_environment_condition_feature", "_UI_LaneChanging_type"),
				 IntelligentMobilityPackage.eINSTANCE.getLaneChanging_Environment_condition(),
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Left Lane Change feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLeftLaneChangePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_LaneChanging_leftLaneChange_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_LaneChanging_leftLaneChange_feature", "_UI_LaneChanging_type"),
				 IntelligentMobilityPackage.eINSTANCE.getLaneChanging_LeftLaneChange(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Right Lane Change feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRightLaneChangePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_LaneChanging_rightLaneChange_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_LaneChanging_rightLaneChange_feature", "_UI_LaneChanging_type"),
				 IntelligentMobilityPackage.eINSTANCE.getLaneChanging_RightLaneChange(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Left Lane Branch feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLeftLaneBranchPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_LaneChanging_leftLaneBranch_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_LaneChanging_leftLaneBranch_feature", "_UI_LaneChanging_type"),
				 IntelligentMobilityPackage.eINSTANCE.getLaneChanging_LeftLaneBranch(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Right Lane Branch feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRightLaneBranchPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_LaneChanging_rightLaneBranch_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_LaneChanging_rightLaneBranch_feature", "_UI_LaneChanging_type"),
				 IntelligentMobilityPackage.eINSTANCE.getLaneChanging_RightLaneBranch(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Action feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addActionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_LaneChanging_action_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_LaneChanging_action_feature", "_UI_LaneChanging_type"),
				 IntelligentMobilityPackage.eINSTANCE.getLaneChanging_Action(),
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Maneuver Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addManeuverTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_LaneChanging_maneuverType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_LaneChanging_maneuverType_feature", "_UI_LaneChanging_type"),
				 IntelligentMobilityPackage.eINSTANCE.getLaneChanging_ManeuverType(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Duration feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDurationPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_LaneChanging_duration_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_LaneChanging_duration_feature", "_UI_LaneChanging_type"),
				 IntelligentMobilityPackage.eINSTANCE.getLaneChanging_Duration(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
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
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getLaneChanging_Turn());
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getLaneChanging_Gapacceptance());
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
	 * This returns LaneChanging.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/LaneChanging"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText(Object object) {
		String label = ((LaneChanging)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_LaneChanging_type") :
			getString("_UI_LaneChanging_type") + " " + label;
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

		switch (notification.getFeatureID(LaneChanging.class)) {
			case IntelligentMobilityPackage.LANE_CHANGING__LANE_SWITCH_SPEED:
			case IntelligentMobilityPackage.LANE_CHANGING__NAME:
			case IntelligentMobilityPackage.LANE_CHANGING__LEFT_LANE_CHANGE:
			case IntelligentMobilityPackage.LANE_CHANGING__RIGHT_LANE_CHANGE:
			case IntelligentMobilityPackage.LANE_CHANGING__LEFT_LANE_BRANCH:
			case IntelligentMobilityPackage.LANE_CHANGING__RIGHT_LANE_BRANCH:
			case IntelligentMobilityPackage.LANE_CHANGING__MANEUVER_TYPE:
			case IntelligentMobilityPackage.LANE_CHANGING__DURATION:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case IntelligentMobilityPackage.LANE_CHANGING__TURN:
			case IntelligentMobilityPackage.LANE_CHANGING__GAPACCEPTANCE:
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
				(IntelligentMobilityPackage.eINSTANCE.getLaneChanging_Turn(),
				 IntelligentMobilityFactory.eINSTANCE.createTurn()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getLaneChanging_Gapacceptance(),
				 IntelligentMobilityFactory.eINSTANCE.createGapAcceptance()));
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
