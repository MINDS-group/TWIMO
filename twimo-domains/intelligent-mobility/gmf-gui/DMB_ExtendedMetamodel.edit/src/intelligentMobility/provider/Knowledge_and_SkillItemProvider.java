/**
 */
package intelligentMobility.provider;


import intelligentMobility.IntelligentMobilityPackage;
import intelligentMobility.Knowledge_and_Skill;

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
 * This is the item provider adapter for a {@link intelligentMobility.Knowledge_and_Skill} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class Knowledge_and_SkillItemProvider 
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
	public Knowledge_and_SkillItemProvider(AdapterFactory adapterFactory) {
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

			addDrivingSkillPropertyDescriptor(object);
			addTrafficSignAwarenessPropertyDescriptor(object);
			addRegulationAwarenessPropertyDescriptor(object);
			addLaneSwitchPreferenceLevelPropertyDescriptor(object);
			addNamePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Driving Skill feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDrivingSkillPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Knowledge_and_Skill_drivingSkill_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Knowledge_and_Skill_drivingSkill_feature", "_UI_Knowledge_and_Skill_type"),
				 IntelligentMobilityPackage.eINSTANCE.getKnowledge_and_Skill_DrivingSkill(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Traffic Sign Awareness feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTrafficSignAwarenessPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Knowledge_and_Skill_trafficSignAwareness_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Knowledge_and_Skill_trafficSignAwareness_feature", "_UI_Knowledge_and_Skill_type"),
				 IntelligentMobilityPackage.eINSTANCE.getKnowledge_and_Skill_TrafficSignAwareness(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Regulation Awareness feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRegulationAwarenessPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Knowledge_and_Skill_regulationAwareness_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Knowledge_and_Skill_regulationAwareness_feature", "_UI_Knowledge_and_Skill_type"),
				 IntelligentMobilityPackage.eINSTANCE.getKnowledge_and_Skill_RegulationAwareness(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Lane Switch Preference Level feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLaneSwitchPreferenceLevelPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Knowledge_and_Skill_laneSwitchPreferenceLevel_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Knowledge_and_Skill_laneSwitchPreferenceLevel_feature", "_UI_Knowledge_and_Skill_type"),
				 IntelligentMobilityPackage.eINSTANCE.getKnowledge_and_Skill_LaneSwitchPreferenceLevel(),
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
				 getString("_UI_Knowledge_and_Skill_name_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Knowledge_and_Skill_name_feature", "_UI_Knowledge_and_Skill_type"),
				 IntelligentMobilityPackage.eINSTANCE.getKnowledge_and_Skill_Name(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns Knowledge_and_Skill.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Knowledge_and_Skill"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText(Object object) {
		String label = ((Knowledge_and_Skill)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_Knowledge_and_Skill_type") :
			getString("_UI_Knowledge_and_Skill_type") + " " + label;
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

		switch (notification.getFeatureID(Knowledge_and_Skill.class)) {
			case IntelligentMobilityPackage.KNOWLEDGE_AND_SKILL__DRIVING_SKILL:
			case IntelligentMobilityPackage.KNOWLEDGE_AND_SKILL__TRAFFIC_SIGN_AWARENESS:
			case IntelligentMobilityPackage.KNOWLEDGE_AND_SKILL__REGULATION_AWARENESS:
			case IntelligentMobilityPackage.KNOWLEDGE_AND_SKILL__LANE_SWITCH_PREFERENCE_LEVEL:
			case IntelligentMobilityPackage.KNOWLEDGE_AND_SKILL__NAME:
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
