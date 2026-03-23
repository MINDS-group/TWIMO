/**
 */
package intelligentMobility.provider;


import intelligentMobility.IntelligentMobilityFactory;
import intelligentMobility.IntelligentMobilityPackage;
import intelligentMobility.Normal_Vehicle;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link intelligentMobility.Normal_Vehicle} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class Normal_VehicleItemProvider extends Vehicle_TypeItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Normal_VehicleItemProvider(AdapterFactory adapterFactory) {
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
				 getString("_UI_Normal_Vehicle_name_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Normal_Vehicle_name_feature", "_UI_Normal_Vehicle_type"),
				 IntelligentMobilityPackage.eINSTANCE.getNormal_Vehicle_Name(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
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
				 getString("_UI_Normal_Vehicle_resetColor_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Normal_Vehicle_resetColor_feature", "_UI_Normal_Vehicle_type"),
				 IntelligentMobilityPackage.eINSTANCE.getNormal_Vehicle_ResetColor(),
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
				 getString("_UI_Normal_Vehicle_colorR_min_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Normal_Vehicle_colorR_min_feature", "_UI_Normal_Vehicle_type"),
				 IntelligentMobilityPackage.eINSTANCE.getNormal_Vehicle_ColorR_min(),
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
				 getString("_UI_Normal_Vehicle_colorR_max_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Normal_Vehicle_colorR_max_feature", "_UI_Normal_Vehicle_type"),
				 IntelligentMobilityPackage.eINSTANCE.getNormal_Vehicle_ColorR_max(),
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
				 getString("_UI_Normal_Vehicle_colorG_min_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Normal_Vehicle_colorG_min_feature", "_UI_Normal_Vehicle_type"),
				 IntelligentMobilityPackage.eINSTANCE.getNormal_Vehicle_ColorG_min(),
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
				 getString("_UI_Normal_Vehicle_colorG_max_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Normal_Vehicle_colorG_max_feature", "_UI_Normal_Vehicle_type"),
				 IntelligentMobilityPackage.eINSTANCE.getNormal_Vehicle_ColorG_max(),
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
				 getString("_UI_Normal_Vehicle_colorB_min_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Normal_Vehicle_colorB_min_feature", "_UI_Normal_Vehicle_type"),
				 IntelligentMobilityPackage.eINSTANCE.getNormal_Vehicle_ColorB_min(),
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
				 getString("_UI_Normal_Vehicle_colorB_max_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Normal_Vehicle_colorB_max_feature", "_UI_Normal_Vehicle_type"),
				 IntelligentMobilityPackage.eINSTANCE.getNormal_Vehicle_ColorB_max(),
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
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getNormal_Vehicle_Safety_requirements());
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
	 * This returns Normal_Vehicle.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Normal_Vehicle"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText(Object object) {
		String label = ((Normal_Vehicle)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_Normal_Vehicle_type") :
			getString("_UI_Normal_Vehicle_type") + " " + label;
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

		switch (notification.getFeatureID(Normal_Vehicle.class)) {
			case IntelligentMobilityPackage.NORMAL_VEHICLE__NAME:
			case IntelligentMobilityPackage.NORMAL_VEHICLE__RESET_COLOR:
			case IntelligentMobilityPackage.NORMAL_VEHICLE__COLOR_RMIN:
			case IntelligentMobilityPackage.NORMAL_VEHICLE__COLOR_RMAX:
			case IntelligentMobilityPackage.NORMAL_VEHICLE__COLOR_GMIN:
			case IntelligentMobilityPackage.NORMAL_VEHICLE__COLOR_GMAX:
			case IntelligentMobilityPackage.NORMAL_VEHICLE__COLOR_BMIN:
			case IntelligentMobilityPackage.NORMAL_VEHICLE__COLOR_BMAX:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case IntelligentMobilityPackage.NORMAL_VEHICLE__SAFETY_REQUIREMENTS:
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
				(IntelligentMobilityPackage.eINSTANCE.getNormal_Vehicle_Safety_requirements(),
				 IntelligentMobilityFactory.eINSTANCE.createSafety_Requirement()));
	}

}
