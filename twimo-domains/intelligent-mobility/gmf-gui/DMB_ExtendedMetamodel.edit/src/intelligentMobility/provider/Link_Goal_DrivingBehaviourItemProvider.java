/**
 */
package intelligentMobility.provider;


import intelligentMobility.IntelligentMobilityPackage;
import intelligentMobility.Link_Goal_DrivingBehaviour;

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
 * This is the item provider adapter for a {@link intelligentMobility.Link_Goal_DrivingBehaviour} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class Link_Goal_DrivingBehaviourItemProvider 
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
	public Link_Goal_DrivingBehaviourItemProvider(AdapterFactory adapterFactory) {
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

			addName_link_goal_drivingBehaviourPropertyDescriptor(object);
			addLink_goalPropertyDescriptor(object);
			addLink_drivingBehaviourPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Name link goal driving Behaviour feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addName_link_goal_drivingBehaviourPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Link_Goal_DrivingBehaviour_name_link_goal_drivingBehaviour_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Link_Goal_DrivingBehaviour_name_link_goal_drivingBehaviour_feature", "_UI_Link_Goal_DrivingBehaviour_type"),
				 IntelligentMobilityPackage.eINSTANCE.getLink_Goal_DrivingBehaviour_Name_link_goal_drivingBehaviour(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Link goal feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLink_goalPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Link_Goal_DrivingBehaviour_link_goal_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Link_Goal_DrivingBehaviour_link_goal_feature", "_UI_Link_Goal_DrivingBehaviour_type"),
				 IntelligentMobilityPackage.eINSTANCE.getLink_Goal_DrivingBehaviour_Link_goal(),
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Link driving Behaviour feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLink_drivingBehaviourPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Link_Goal_DrivingBehaviour_link_drivingBehaviour_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Link_Goal_DrivingBehaviour_link_drivingBehaviour_feature", "_UI_Link_Goal_DrivingBehaviour_type"),
				 IntelligentMobilityPackage.eINSTANCE.getLink_Goal_DrivingBehaviour_Link_drivingBehaviour(),
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This returns Link_Goal_DrivingBehaviour.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Link_Goal_DrivingBehaviour"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText(Object object) {
		String label = ((Link_Goal_DrivingBehaviour)object).getName_link_goal_drivingBehaviour();
		return label == null || label.length() == 0 ?
			getString("_UI_Link_Goal_DrivingBehaviour_type") :
			getString("_UI_Link_Goal_DrivingBehaviour_type") + " " + label;
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

		switch (notification.getFeatureID(Link_Goal_DrivingBehaviour.class)) {
			case IntelligentMobilityPackage.LINK_GOAL_DRIVING_BEHAVIOUR__NAME_LINK_GOAL_DRIVING_BEHAVIOUR:
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
