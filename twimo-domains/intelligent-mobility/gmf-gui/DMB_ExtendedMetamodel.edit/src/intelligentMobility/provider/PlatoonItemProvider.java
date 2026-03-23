/**
 */
package intelligentMobility.provider;


import intelligentMobility.IntelligentMobilityFactory;
import intelligentMobility.IntelligentMobilityPackage;
import intelligentMobility.Platoon;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link intelligentMobility.Platoon} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class PlatoonItemProvider extends Vehicle_TypeItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PlatoonItemProvider(AdapterFactory adapterFactory) {
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
			addV2vTimePropertyDescriptor(object);
			addFollowerCountPropertyDescriptor(object);
			addResetColorPropertyDescriptor(object);
			addColorR_minPropertyDescriptor(object);
			addColorR_maxPropertyDescriptor(object);
			addColorG_minPropertyDescriptor(object);
			addColorG_maxPropertyDescriptor(object);
			addColorB_minPropertyDescriptor(object);
			addColorB_maxPropertyDescriptor(object);
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
				 getString("_UI_Platoon_name_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Platoon_name_feature", "_UI_Platoon_type"),
				 IntelligentMobilityPackage.eINSTANCE.getPlatoon_Name(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the V2v Time feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addV2vTimePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Platoon_v2vTime_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Platoon_v2vTime_feature", "_UI_Platoon_type"),
				 IntelligentMobilityPackage.eINSTANCE.getPlatoon_V2vTime(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Follower Count feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFollowerCountPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Platoon_followerCount_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Platoon_followerCount_feature", "_UI_Platoon_type"),
				 IntelligentMobilityPackage.eINSTANCE.getPlatoon_FollowerCount(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Reset Color feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addResetColorPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Platoon_resetColor_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Platoon_resetColor_feature", "_UI_Platoon_type"),
				 IntelligentMobilityPackage.eINSTANCE.getPlatoon_ResetColor(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
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
				 getString("_UI_Platoon_colorR_min_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Platoon_colorR_min_feature", "_UI_Platoon_type"),
				 IntelligentMobilityPackage.eINSTANCE.getPlatoon_ColorR_min(),
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
				 getString("_UI_Platoon_colorR_max_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Platoon_colorR_max_feature", "_UI_Platoon_type"),
				 IntelligentMobilityPackage.eINSTANCE.getPlatoon_ColorR_max(),
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
				 getString("_UI_Platoon_colorG_min_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Platoon_colorG_min_feature", "_UI_Platoon_type"),
				 IntelligentMobilityPackage.eINSTANCE.getPlatoon_ColorG_min(),
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
				 getString("_UI_Platoon_colorG_max_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Platoon_colorG_max_feature", "_UI_Platoon_type"),
				 IntelligentMobilityPackage.eINSTANCE.getPlatoon_ColorG_max(),
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
				 getString("_UI_Platoon_colorB_min_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Platoon_colorB_min_feature", "_UI_Platoon_type"),
				 IntelligentMobilityPackage.eINSTANCE.getPlatoon_ColorB_min(),
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
				 getString("_UI_Platoon_colorB_max_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Platoon_colorB_max_feature", "_UI_Platoon_type"),
				 IntelligentMobilityPackage.eINSTANCE.getPlatoon_ColorB_max(),
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
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getPlatoon_Leading_vehicle());
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getPlatoon_Following_vehicle());
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
	 * This returns Platoon.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Platoon"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText(Object object) {
		String label = ((Platoon)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_Platoon_type") :
			getString("_UI_Platoon_type") + " " + label;
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

		switch (notification.getFeatureID(Platoon.class)) {
			case IntelligentMobilityPackage.PLATOON__NAME:
			case IntelligentMobilityPackage.PLATOON__V2V_TIME:
			case IntelligentMobilityPackage.PLATOON__FOLLOWER_COUNT:
			case IntelligentMobilityPackage.PLATOON__RESET_COLOR:
			case IntelligentMobilityPackage.PLATOON__COLOR_RMIN:
			case IntelligentMobilityPackage.PLATOON__COLOR_RMAX:
			case IntelligentMobilityPackage.PLATOON__COLOR_GMIN:
			case IntelligentMobilityPackage.PLATOON__COLOR_GMAX:
			case IntelligentMobilityPackage.PLATOON__COLOR_BMIN:
			case IntelligentMobilityPackage.PLATOON__COLOR_BMAX:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case IntelligentMobilityPackage.PLATOON__LEADING_VEHICLE:
			case IntelligentMobilityPackage.PLATOON__FOLLOWING_VEHICLE:
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
				(IntelligentMobilityPackage.eINSTANCE.getPlatoon_Leading_vehicle(),
				 IntelligentMobilityFactory.eINSTANCE.createLeading_Vehicle()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getPlatoon_Following_vehicle(),
				 IntelligentMobilityFactory.eINSTANCE.createFollowing_Vehicle()));
	}

}
