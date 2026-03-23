/**
 */
package intelligentMobility.provider;


import intelligentMobility.Driver_Preference;
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
 * This is the item provider adapter for a {@link intelligentMobility.Driver_Preference} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class Driver_PreferenceItemProvider 
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
	public Driver_PreferenceItemProvider(AdapterFactory adapterFactory) {
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

			addName_PreferenceSetPropertyDescriptor(object);
			addEnvironment_conditionPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Name Preference Set feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addName_PreferenceSetPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Driver_Preference_name_PreferenceSet_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Driver_Preference_name_PreferenceSet_feature", "_UI_Driver_Preference_type"),
				 IntelligentMobilityPackage.eINSTANCE.getDriver_Preference_Name_PreferenceSet(),
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
				 getString("_UI_Driver_Preference_environment_condition_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Driver_Preference_environment_condition_feature", "_UI_Driver_Preference_type"),
				 IntelligentMobilityPackage.eINSTANCE.getDriver_Preference_Environment_condition(),
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
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getDriver_Preference_Driver_emotions());
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getDriver_Preference_Knowledge_and_skills());
			childrenFeatures.add(IntelligentMobilityPackage.eINSTANCE.getDriver_Preference_Driving_behaviour());
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
	 * This returns Driver_Preference.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Driver_Preference"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText(Object object) {
		String label = ((Driver_Preference)object).getName_PreferenceSet();
		return label == null || label.length() == 0 ?
			getString("_UI_Driver_Preference_type") :
			getString("_UI_Driver_Preference_type") + " " + label;
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

		switch (notification.getFeatureID(Driver_Preference.class)) {
			case IntelligentMobilityPackage.DRIVER_PREFERENCE__NAME_PREFERENCE_SET:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case IntelligentMobilityPackage.DRIVER_PREFERENCE__DRIVER_EMOTIONS:
			case IntelligentMobilityPackage.DRIVER_PREFERENCE__KNOWLEDGE_AND_SKILLS:
			case IntelligentMobilityPackage.DRIVER_PREFERENCE__DRIVING_BEHAVIOUR:
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
				(IntelligentMobilityPackage.eINSTANCE.getDriver_Preference_Driver_emotions(),
				 IntelligentMobilityFactory.eINSTANCE.createDriver_Emotion()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getDriver_Preference_Knowledge_and_skills(),
				 IntelligentMobilityFactory.eINSTANCE.createKnowledge_and_Skill()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getDriver_Preference_Driving_behaviour(),
				 IntelligentMobilityFactory.eINSTANCE.createDriving_Behaviour()));

		newChildDescriptors.add
			(createChildParameter
				(IntelligentMobilityPackage.eINSTANCE.getDriver_Preference_Driving_behaviour(),
				 IntelligentMobilityFactory.eINSTANCE.createCooperativeBehavior()));
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
