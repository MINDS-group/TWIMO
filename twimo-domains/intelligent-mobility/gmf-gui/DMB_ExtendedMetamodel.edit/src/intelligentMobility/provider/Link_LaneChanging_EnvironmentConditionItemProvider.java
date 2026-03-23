/**
 */
package intelligentMobility.provider;


import intelligentMobility.IntelligentMobilityPackage;
import intelligentMobility.Link_LaneChanging_EnvironmentCondition;

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
 * This is the item provider adapter for a {@link intelligentMobility.Link_LaneChanging_EnvironmentCondition} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class Link_LaneChanging_EnvironmentConditionItemProvider 
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
	public Link_LaneChanging_EnvironmentConditionItemProvider(AdapterFactory adapterFactory) {
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

			addName_link_laneChanging_environmentConditionPropertyDescriptor(object);
			addLink_laneChangingPropertyDescriptor(object);
			addLink_environmentConditionPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Name link lane Changing environment Condition feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addName_link_laneChanging_environmentConditionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Link_LaneChanging_EnvironmentCondition_name_link_laneChanging_environmentCondition_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Link_LaneChanging_EnvironmentCondition_name_link_laneChanging_environmentCondition_feature", "_UI_Link_LaneChanging_EnvironmentCondition_type"),
				 IntelligentMobilityPackage.eINSTANCE.getLink_LaneChanging_EnvironmentCondition_Name_link_laneChanging_environmentCondition(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Link lane Changing feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLink_laneChangingPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Link_LaneChanging_EnvironmentCondition_link_laneChanging_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Link_LaneChanging_EnvironmentCondition_link_laneChanging_feature", "_UI_Link_LaneChanging_EnvironmentCondition_type"),
				 IntelligentMobilityPackage.eINSTANCE.getLink_LaneChanging_EnvironmentCondition_Link_laneChanging(),
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Link environment Condition feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLink_environmentConditionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Link_LaneChanging_EnvironmentCondition_link_environmentCondition_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Link_LaneChanging_EnvironmentCondition_link_environmentCondition_feature", "_UI_Link_LaneChanging_EnvironmentCondition_type"),
				 IntelligentMobilityPackage.eINSTANCE.getLink_LaneChanging_EnvironmentCondition_Link_environmentCondition(),
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This returns Link_LaneChanging_EnvironmentCondition.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Link_LaneChanging_EnvironmentCondition"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText(Object object) {
		String label = ((Link_LaneChanging_EnvironmentCondition)object).getName_link_laneChanging_environmentCondition();
		return label == null || label.length() == 0 ?
			getString("_UI_Link_LaneChanging_EnvironmentCondition_type") :
			getString("_UI_Link_LaneChanging_EnvironmentCondition_type") + " " + label;
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

		switch (notification.getFeatureID(Link_LaneChanging_EnvironmentCondition.class)) {
			case IntelligentMobilityPackage.LINK_LANE_CHANGING_ENVIRONMENT_CONDITION__NAME_LINK_LANE_CHANGING_ENVIRONMENT_CONDITION:
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
