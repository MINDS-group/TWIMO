/**
 */
package intelligentMobility.provider;


import intelligentMobility.Abnormal_Behaviour;
import intelligentMobility.IntelligentMobilityFactory;
import intelligentMobility.IntelligentMobilityPackage;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link intelligentMobility.Abnormal_Behaviour} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class Abnormal_BehaviourItemProvider extends Normal_BehaviourItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Abnormal_BehaviourItemProvider(AdapterFactory adapterFactory) {
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

			addZigzag_DrivingPropertyDescriptor(object);
			addRisky_AccelerationPropertyDescriptor(object);
			addRisky_LanechangingPropertyDescriptor(object);
			addNamePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Zigzag Driving feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addZigzag_DrivingPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Abnormal_Behaviour_zigzag_Driving_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Abnormal_Behaviour_zigzag_Driving_feature", "_UI_Abnormal_Behaviour_type"),
				 IntelligentMobilityPackage.eINSTANCE.getAbnormal_Behaviour_Zigzag_Driving(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Risky Acceleration feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRisky_AccelerationPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Abnormal_Behaviour_risky_Acceleration_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Abnormal_Behaviour_risky_Acceleration_feature", "_UI_Abnormal_Behaviour_type"),
				 IntelligentMobilityPackage.eINSTANCE.getAbnormal_Behaviour_Risky_Acceleration(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Risky Lanechanging feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRisky_LanechangingPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Abnormal_Behaviour_risky_Lanechanging_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Abnormal_Behaviour_risky_Lanechanging_feature", "_UI_Abnormal_Behaviour_type"),
				 IntelligentMobilityPackage.eINSTANCE.getAbnormal_Behaviour_Risky_Lanechanging(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
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
				 getString("_UI_Abnormal_Behaviour_name_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Abnormal_Behaviour_name_feature", "_UI_Abnormal_Behaviour_type"),
				 IntelligentMobilityPackage.eINSTANCE.getAbnormal_Behaviour_Name(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
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
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getAbnormal_Behaviour_Actions());
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
	 * This returns Abnormal_Behaviour.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Abnormal_Behaviour"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText(Object object) {
		String label = ((Abnormal_Behaviour)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_Abnormal_Behaviour_type") :
			getString("_UI_Abnormal_Behaviour_type") + " " + label;
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

		switch (notification.getFeatureID(Abnormal_Behaviour.class)) {
			case IntelligentMobilityPackage.ABNORMAL_BEHAVIOUR__ZIGZAG_DRIVING:
			case IntelligentMobilityPackage.ABNORMAL_BEHAVIOUR__RISKY_ACCELERATION:
			case IntelligentMobilityPackage.ABNORMAL_BEHAVIOUR__RISKY_LANECHANGING:
			case IntelligentMobilityPackage.ABNORMAL_BEHAVIOUR__NAME:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case IntelligentMobilityPackage.ABNORMAL_BEHAVIOUR__ACTIONS:
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
				(IntelligentMobilityPackage.eINSTANCE.getAbnormal_Behaviour_Actions(),
				 IntelligentMobilityFactory.eINSTANCE.createAction()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getAbnormal_Behaviour_Actions(),
				 IntelligentMobilityFactory.eINSTANCE.createForward()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getAbnormal_Behaviour_Actions(),
				 IntelligentMobilityFactory.eINSTANCE.createBackward()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getAbnormal_Behaviour_Actions(),
				 IntelligentMobilityFactory.eINSTANCE.createTurn()));
	}

}
