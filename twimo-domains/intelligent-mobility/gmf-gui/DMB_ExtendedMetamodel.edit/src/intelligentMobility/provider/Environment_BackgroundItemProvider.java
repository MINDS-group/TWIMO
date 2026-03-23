/**
 */
package intelligentMobility.provider;


import intelligentMobility.Environment_Background;
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
 * This is the item provider adapter for a {@link intelligentMobility.Environment_Background} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class Environment_BackgroundItemProvider 
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
	public Environment_BackgroundItemProvider(AdapterFactory adapterFactory) {
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

			addNamePropertyDescriptor(object);
			addRoadLengthPropertyDescriptor(object);
			addRoadShapePropertyDescriptor(object);
			addTotalVehiclePerFramePropertyDescriptor(object);
			addTrafficDensityPropertyDescriptor(object);
			addSimulationFrameTimePropertyDescriptor(object);
			addSimulationSleepTimePropertyDescriptor(object);
			addRoadInclinePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
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
				 getString("_UI_Environment_Background_name_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Environment_Background_name_feature", "_UI_Environment_Background_type"),
				 IntelligentMobilityPackage.eINSTANCE.getEnvironment_Background_Name(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Road Length feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRoadLengthPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Environment_Background_roadLength_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Environment_Background_roadLength_feature", "_UI_Environment_Background_type"),
				 IntelligentMobilityPackage.eINSTANCE.getEnvironment_Background_RoadLength(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Road Shape feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRoadShapePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Environment_Background_roadShape_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Environment_Background_roadShape_feature", "_UI_Environment_Background_type"),
				 IntelligentMobilityPackage.eINSTANCE.getEnvironment_Background_RoadShape(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Total Vehicle Per Frame feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTotalVehiclePerFramePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Environment_Background_totalVehiclePerFrame_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Environment_Background_totalVehiclePerFrame_feature", "_UI_Environment_Background_type"),
				 IntelligentMobilityPackage.eINSTANCE.getEnvironment_Background_TotalVehiclePerFrame(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Traffic Density feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTrafficDensityPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Environment_Background_trafficDensity_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Environment_Background_trafficDensity_feature", "_UI_Environment_Background_type"),
				 IntelligentMobilityPackage.eINSTANCE.getEnvironment_Background_TrafficDensity(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Simulation Frame Time feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSimulationFrameTimePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Environment_Background_simulationFrameTime_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Environment_Background_simulationFrameTime_feature", "_UI_Environment_Background_type"),
				 IntelligentMobilityPackage.eINSTANCE.getEnvironment_Background_SimulationFrameTime(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Simulation Sleep Time feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSimulationSleepTimePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Environment_Background_simulationSleepTime_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Environment_Background_simulationSleepTime_feature", "_UI_Environment_Background_type"),
				 IntelligentMobilityPackage.eINSTANCE.getEnvironment_Background_SimulationSleepTime(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Road Incline feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRoadInclinePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Environment_Background_roadIncline_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Environment_Background_roadIncline_feature", "_UI_Environment_Background_type"),
				 IntelligentMobilityPackage.eINSTANCE.getEnvironment_Background_RoadIncline(),
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
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getEnvironment_Background_Possiblevehicles());
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getEnvironment_Background_Environment_condition());
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
	 * This returns Environment_Background.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Environment_Background"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText(Object object) {
		String label = ((Environment_Background)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_Environment_Background_type") :
			getString("_UI_Environment_Background_type") + " " + label;
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

		switch (notification.getFeatureID(Environment_Background.class)) {
			case IntelligentMobilityPackage.ENVIRONMENT_BACKGROUND__NAME:
			case IntelligentMobilityPackage.ENVIRONMENT_BACKGROUND__ROAD_LENGTH:
			case IntelligentMobilityPackage.ENVIRONMENT_BACKGROUND__ROAD_SHAPE:
			case IntelligentMobilityPackage.ENVIRONMENT_BACKGROUND__TOTAL_VEHICLE_PER_FRAME:
			case IntelligentMobilityPackage.ENVIRONMENT_BACKGROUND__TRAFFIC_DENSITY:
			case IntelligentMobilityPackage.ENVIRONMENT_BACKGROUND__SIMULATION_FRAME_TIME:
			case IntelligentMobilityPackage.ENVIRONMENT_BACKGROUND__SIMULATION_SLEEP_TIME:
			case IntelligentMobilityPackage.ENVIRONMENT_BACKGROUND__ROAD_INCLINE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case IntelligentMobilityPackage.ENVIRONMENT_BACKGROUND__POSSIBLEVEHICLES:
			case IntelligentMobilityPackage.ENVIRONMENT_BACKGROUND__ENVIRONMENT_CONDITION:
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
				(IntelligentMobilityPackage.eINSTANCE.getEnvironment_Background_Possiblevehicles(),
				 IntelligentMobilityFactory.eINSTANCE.createPossibleVehicle()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getEnvironment_Background_Environment_condition(),
				 IntelligentMobilityFactory.eINSTANCE.createEnvironment_Condition()));
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
