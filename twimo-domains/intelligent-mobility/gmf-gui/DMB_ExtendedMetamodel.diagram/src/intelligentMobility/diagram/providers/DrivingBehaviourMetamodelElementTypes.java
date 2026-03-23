package intelligentMobility.diagram.providers;

import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.tooling.runtime.providers.DiagramElementTypeImages;
import org.eclipse.gmf.tooling.runtime.providers.DiagramElementTypes;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;

/**
 * @generated
 */
public class DrivingBehaviourMetamodelElementTypes {

	/**
	* @generated
	*/
	private DrivingBehaviourMetamodelElementTypes() {
	}

	/**
	* @generated
	*/
	private static Map/*[org.eclipse.gmf.runtime.emf.type.core.IElementType, org.eclipse.emf.ecore.ENamedElement]*/ elements;

	/**
	* @generated
	*/
	private static DiagramElementTypeImages elementTypeImages = new DiagramElementTypeImages(
			intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin.getInstance()
					.getItemProvidersAdapterFactory());

	/**
	* @generated
	*/
	private static Set/*[org.eclipse.gmf.runtime.emf.type.core.IElementType]*/ KNOWN_ELEMENT_TYPES;

	/**
	* @generated
	*/
	public static final IElementType MobilitySystem_1000 = getElementType(
			"DMB_ExtendedMetamodel.diagram.MobilitySystem_1000"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Special_Condition_2001 = getElementType(
			"DMB_ExtendedMetamodel.diagram.Special_Condition_2001"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Weather_2002 = getElementType("DMB_ExtendedMetamodel.diagram.Weather_2002"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Traffic_Light_2003 = getElementType(
			"DMB_ExtendedMetamodel.diagram.Traffic_Light_2003"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Knowledge_and_Skill_2004 = getElementType(
			"DMB_ExtendedMetamodel.diagram.Knowledge_and_Skill_2004"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Obstruction_2005 = getElementType(
			"DMB_ExtendedMetamodel.diagram.Obstruction_2005"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Driver_Preference_2006 = getElementType(
			"DMB_ExtendedMetamodel.diagram.Driver_Preference_2006"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Intersection_2007 = getElementType(
			"DMB_ExtendedMetamodel.diagram.Intersection_2007"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Vehicle_Configuration_2008 = getElementType(
			"DMB_ExtendedMetamodel.diagram.Vehicle_Configuration_2008"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Environment_Condition_2009 = getElementType(
			"DMB_ExtendedMetamodel.diagram.Environment_Condition_2009"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Platoon_2010 = getElementType("DMB_ExtendedMetamodel.diagram.Platoon_2010"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Forward_2011 = getElementType("DMB_ExtendedMetamodel.diagram.Forward_2011"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Lane_Type_2012 = getElementType("DMB_ExtendedMetamodel.diagram.Lane_Type_2012"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Environment_Background_2013 = getElementType(
			"DMB_ExtendedMetamodel.diagram.Environment_Background_2013"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Turn_2014 = getElementType("DMB_ExtendedMetamodel.diagram.Turn_2014"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType LaneChanging_2015 = getElementType(
			"DMB_ExtendedMetamodel.diagram.LaneChanging_2015"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Driver_Emotion_2016 = getElementType(
			"DMB_ExtendedMetamodel.diagram.Driver_Emotion_2016"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Collision_2017 = getElementType("DMB_ExtendedMetamodel.diagram.Collision_2017"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType PossibleVehicle_2018 = getElementType(
			"DMB_ExtendedMetamodel.diagram.PossibleVehicle_2018"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Following_2019 = getElementType("DMB_ExtendedMetamodel.diagram.Following_2019"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType GapAcceptance_2020 = getElementType(
			"DMB_ExtendedMetamodel.diagram.GapAcceptance_2020"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Leading_Vehicle_2021 = getElementType(
			"DMB_ExtendedMetamodel.diagram.Leading_Vehicle_2021"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Backward_2022 = getElementType("DMB_ExtendedMetamodel.diagram.Backward_2022"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Regulation_2023 = getElementType("DMB_ExtendedMetamodel.diagram.Regulation_2023"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Traffic_Situation_2024 = getElementType(
			"DMB_ExtendedMetamodel.diagram.Traffic_Situation_2024"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Driver_Profile_2025 = getElementType(
			"DMB_ExtendedMetamodel.diagram.Driver_Profile_2025"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Safety_Requirement_2026 = getElementType(
			"DMB_ExtendedMetamodel.diagram.Safety_Requirement_2026"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Driving_Behaviour_2027 = getElementType(
			"DMB_ExtendedMetamodel.diagram.Driving_Behaviour_2027"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Following_Vehicle_2028 = getElementType(
			"DMB_ExtendedMetamodel.diagram.Following_Vehicle_2028"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Abnormal_Behaviour_2029 = getElementType(
			"DMB_ExtendedMetamodel.diagram.Abnormal_Behaviour_2029"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Backward_2030 = getElementType("DMB_ExtendedMetamodel.diagram.Backward_2030"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Intersection_2031 = getElementType(
			"DMB_ExtendedMetamodel.diagram.Intersection_2031"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType CommunicationInterface_2032 = getElementType(
			"DMB_ExtendedMetamodel.diagram.CommunicationInterface_2032"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Goal_2033 = getElementType("DMB_ExtendedMetamodel.diagram.Goal_2033"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Normal_Behaviour_2034 = getElementType(
			"DMB_ExtendedMetamodel.diagram.Normal_Behaviour_2034"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Platoon_2035 = getElementType("DMB_ExtendedMetamodel.diagram.Platoon_2035"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Normal_Vehicle_2036 = getElementType(
			"DMB_ExtendedMetamodel.diagram.Normal_Vehicle_2036"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType CooperativeBehavior_2037 = getElementType(
			"DMB_ExtendedMetamodel.diagram.CooperativeBehavior_2037"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Action_2039 = getElementType("DMB_ExtendedMetamodel.diagram.Action_2039"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Link_LaneType_Regulation_4001 = getElementType(
			"DMB_ExtendedMetamodel.diagram.Link_LaneType_Regulation_4001"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Link_Driver_Vehicle_4002 = getElementType(
			"DMB_ExtendedMetamodel.diagram.Link_Driver_Vehicle_4002"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Link_EnvironmentBackground_PossibleVehicle_4003 = getElementType(
			"DMB_ExtendedMetamodel.diagram.Link_EnvironmentBackground_PossibleVehicle_4003"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Link_Vehicle_Environment_4004 = getElementType(
			"DMB_ExtendedMetamodel.diagram.Link_Vehicle_Environment_4004"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Link_NormalVehicle_SafetyRequirements_4005 = getElementType(
			"DMB_ExtendedMetamodel.diagram.Link_NormalVehicle_SafetyRequirements_4005"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Link_DriverProfile_DriverPreference_4006 = getElementType(
			"DMB_ExtendedMetamodel.diagram.Link_DriverProfile_DriverPreference_4006"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Link_Collision_Obstruction_4007 = getElementType(
			"DMB_ExtendedMetamodel.diagram.Link_Collision_Obstruction_4007"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Link_Platoon_FollowingVehicle_4008 = getElementType(
			"DMB_ExtendedMetamodel.diagram.Link_Platoon_FollowingVehicle_4008"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Link_DriverPreference_EnvironmentCondition_4009 = getElementType(
			"DMB_ExtendedMetamodel.diagram.Link_DriverPreference_EnvironmentCondition_4009"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Link_AbnormalBehaviour_Action_4010 = getElementType(
			"DMB_ExtendedMetamodel.diagram.Link_AbnormalBehaviour_Action_4010"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Link_Following_Forward_4011 = getElementType(
			"DMB_ExtendedMetamodel.diagram.Link_Following_Forward_4011"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Link_EnvironmentCondition_LaneType_4012 = getElementType(
			"DMB_ExtendedMetamodel.diagram.Link_EnvironmentCondition_LaneType_4012"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Link_VehicleConfiguration_VehicleType_4013 = getElementType(
			"DMB_ExtendedMetamodel.diagram.Link_VehicleConfiguration_VehicleType_4013"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Link_Platoon_LeadingVehicle_4014 = getElementType(
			"DMB_ExtendedMetamodel.diagram.Link_Platoon_LeadingVehicle_4014"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Link_Driver_Environment_4015 = getElementType(
			"DMB_ExtendedMetamodel.diagram.Link_Driver_Environment_4015"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Link_LaneChanging_Turn_4016 = getElementType(
			"DMB_ExtendedMetamodel.diagram.Link_LaneChanging_Turn_4016"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Link_EnvironmentCondition_TrafficCondition_4017 = getElementType(
			"DMB_ExtendedMetamodel.diagram.Link_EnvironmentCondition_TrafficCondition_4017"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Link_Intersection_TrafficLight_4018 = getElementType(
			"DMB_ExtendedMetamodel.diagram.Link_Intersection_TrafficLight_4018"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Link_Following_MinGap_4019 = getElementType(
			"DMB_ExtendedMetamodel.diagram.Link_Following_MinGap_4019"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Link_NormalBehaviour_LaneChanging_4020 = getElementType(
			"DMB_ExtendedMetamodel.diagram.Link_NormalBehaviour_LaneChanging_4020"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Link_SafetyRequirement_Regulation_4021 = getElementType(
			"DMB_ExtendedMetamodel.diagram.Link_SafetyRequirement_Regulation_4021"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Link_DriverPreference_DrivingBehaviour_4022 = getElementType(
			"DMB_ExtendedMetamodel.diagram.Link_DriverPreference_DrivingBehaviour_4022"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Link_FollowingVehicle_FrontVehicle_4023 = getElementType(
			"DMB_ExtendedMetamodel.diagram.Link_FollowingVehicle_FrontVehicle_4023"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Link_DriverPreference_DriverEmotion_4024 = getElementType(
			"DMB_ExtendedMetamodel.diagram.Link_DriverPreference_DriverEmotion_4024"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Link_EnvironmentBackground_EnvironmentCondition_4025 = getElementType(
			"DMB_ExtendedMetamodel.diagram.Link_EnvironmentBackground_EnvironmentCondition_4025"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Link_EnvironmentCondition_Weather_4026 = getElementType(
			"DMB_ExtendedMetamodel.diagram.Link_EnvironmentCondition_Weather_4026"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Link_EnvironmentCondition_SpecialCondition_4027 = getElementType(
			"DMB_ExtendedMetamodel.diagram.Link_EnvironmentCondition_SpecialCondition_4027"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Link_SpecialCondition_Intersection_4028 = getElementType(
			"DMB_ExtendedMetamodel.diagram.Link_SpecialCondition_Intersection_4028"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Link_Following_Backward_4029 = getElementType(
			"DMB_ExtendedMetamodel.diagram.Link_Following_Backward_4029"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Link_EnvironmentCondition_Regulations_4030 = getElementType(
			"DMB_ExtendedMetamodel.diagram.Link_EnvironmentCondition_Regulations_4030"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Link_DrivingBehaviour_NormalBehaviour_4031 = getElementType(
			"DMB_ExtendedMetamodel.diagram.Link_DrivingBehaviour_NormalBehaviour_4031"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Link_LaneChanging_EnvironmentCondition_4032 = getElementType(
			"DMB_ExtendedMetamodel.diagram.Link_LaneChanging_EnvironmentCondition_4032"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Link_LaneChanging_GapAcceptance_4033 = getElementType(
			"DMB_ExtendedMetamodel.diagram.Link_LaneChanging_GapAcceptance_4033"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Link_NormalBehaviour_Following_4034 = getElementType(
			"DMB_ExtendedMetamodel.diagram.Link_NormalBehaviour_Following_4034"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Link_Infrastructure_VehicleConfiguration_4035 = getElementType(
			"DMB_ExtendedMetamodel.diagram.Link_Infrastructure_VehicleConfiguration_4035"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Link_CommunicationInterface_VehicleConfiguration_4036 = getElementType(
			"DMB_ExtendedMetamodel.diagram.Link_CommunicationInterface_VehicleConfiguration_4036"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Link_Goal_DrivingBehaviour_4037 = getElementType(
			"DMB_ExtendedMetamodel.diagram.Link_Goal_DrivingBehaviour_4037"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Link_CooperativeBehaviour_CommunicationInterface_4038 = getElementType(
			"DMB_ExtendedMetamodel.diagram.Link_CooperativeBehaviour_CommunicationInterface_4038"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Link_CommunicationInterface_Infrastructure_4039 = getElementType(
			"DMB_ExtendedMetamodel.diagram.Link_CommunicationInterface_Infrastructure_4039"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Link_CooperativeBehaviour_VehicleConfiguration_4040 = getElementType(
			"DMB_ExtendedMetamodel.diagram.Link_CooperativeBehaviour_VehicleConfiguration_4040"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Link_TrafficSituation_EnvironmentCondition_4041 = getElementType(
			"DMB_ExtendedMetamodel.diagram.Link_TrafficSituation_EnvironmentCondition_4041"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Link_Collision_SpecialCondition_4042 = getElementType(
			"DMB_ExtendedMetamodel.diagram.Link_Collision_SpecialCondition_4042"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Link_Following_LaneChanging_4043 = getElementType(
			"DMB_ExtendedMetamodel.diagram.Link_Following_LaneChanging_4043"); //$NON-NLS-1$

	/**
	* @generated
	*/
	public static final IElementType Link_Action_Backward_4044 = getElementType(
			"DMB_ExtendedMetamodel.diagram.Link_Action_Backward_4044"); //$NON-NLS-1$

	/**
	* @generated
	*/
	public static final IElementType Link_Action_Forward_4045 = getElementType(
			"DMB_ExtendedMetamodel.diagram.Link_Action_Forward_4045"); //$NON-NLS-1$

	/**
	* @generated
	*/
	public static final IElementType Link_Action_Turn_4046 = getElementType(
			"DMB_ExtendedMetamodel.diagram.Link_Action_Turn_4046"); //$NON-NLS-1$

	/**
	* @generated
	*/
	public static final IElementType Link_KnowledgeAndSkill_DriverPreference_4047 = getElementType(
			"DMB_ExtendedMetamodel.diagram.Link_KnowledgeAndSkill_DriverPreference_4047"); //$NON-NLS-1$

	/**
	* @generated
	*/
	public static ImageDescriptor getImageDescriptor(ENamedElement element) {
		return elementTypeImages.getImageDescriptor(element);
	}

	/**
	* @generated
	*/
	public static Image getImage(ENamedElement element) {
		return elementTypeImages.getImage(element);
	}

	/**
	* @generated
	*/
	public static ImageDescriptor getImageDescriptor(IAdaptable hint) {
		return getImageDescriptor(getElement(hint));
	}

	/**
	* @generated
	*/
	public static Image getImage(IAdaptable hint) {
		return getImage(getElement(hint));
	}

	/**
	* Returns 'type' of the ecore object associated with the hint.
	* 
	* @generated
	*/
	public static ENamedElement getElement(IAdaptable hint) {
		Object type = hint.getAdapter(IElementType.class);
		if (elements == null) {
			elements = new IdentityHashMap/*[org.eclipse.gmf.runtime.emf.type.core.IElementType, org.eclipse.emf.ecore.ENamedElement]*/();

			elements.put(MobilitySystem_1000,
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getMobilitySystem());

			elements.put(Special_Condition_2001,
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getSpecial_Condition());

			elements.put(Weather_2002, intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getWeather());

			elements.put(Traffic_Light_2003,
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getTraffic_Light());

			elements.put(Knowledge_and_Skill_2004,
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getKnowledge_and_Skill());

			elements.put(Obstruction_2005, intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getObstruction());

			elements.put(Driver_Preference_2006,
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getDriver_Preference());

			elements.put(Intersection_2007, intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getIntersection());

			elements.put(Vehicle_Configuration_2008,
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getVehicle_Configuration());

			elements.put(Environment_Condition_2009,
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getEnvironment_Condition());

			elements.put(Platoon_2010, intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getPlatoon());

			elements.put(Forward_2011, intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getForward());

			elements.put(Lane_Type_2012, intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getLane_Type());

			elements.put(Environment_Background_2013,
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getEnvironment_Background());

			elements.put(Turn_2014, intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getTurn());

			elements.put(LaneChanging_2015, intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getLaneChanging());

			elements.put(Driver_Emotion_2016,
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getDriver_Emotion());

			elements.put(Collision_2017, intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getCollision());

			elements.put(PossibleVehicle_2018,
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getPossibleVehicle());

			elements.put(Following_2019, intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getFollowing());

			elements.put(GapAcceptance_2020,
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getGapAcceptance());

			elements.put(Leading_Vehicle_2021,
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getLeading_Vehicle());

			elements.put(Backward_2022, intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getBackward());

			elements.put(Regulation_2023, intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getRegulation());

			elements.put(Traffic_Situation_2024,
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getTraffic_Situation());

			elements.put(Driver_Profile_2025,
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getDriver_Profile());

			elements.put(Safety_Requirement_2026,
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getSafety_Requirement());

			elements.put(Driving_Behaviour_2027,
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getDriving_Behaviour());

			elements.put(Following_Vehicle_2028,
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getFollowing_Vehicle());

			elements.put(Abnormal_Behaviour_2029,
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getAbnormal_Behaviour());

			elements.put(Backward_2030, intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getBackward());

			elements.put(Intersection_2031, intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getIntersection());

			elements.put(CommunicationInterface_2032,
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getCommunicationInterface());

			elements.put(Goal_2033, intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getGoal());

			elements.put(Normal_Behaviour_2034,
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getNormal_Behaviour());

			elements.put(Platoon_2035, intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getPlatoon());

			elements.put(Normal_Vehicle_2036,
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getNormal_Vehicle());

			elements.put(CooperativeBehavior_2037,
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getCooperativeBehavior());

			elements.put(Action_2039, intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getAction());

			elements.put(Link_LaneType_Regulation_4001,
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getLink_LaneType_Regulation());

			elements.put(Link_Driver_Vehicle_4002,
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getLink_Driver_Vehicle());

			elements.put(Link_EnvironmentBackground_PossibleVehicle_4003,
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE
							.getLink_EnvironmentBackground_PossibleVehicle());

			elements.put(Link_Vehicle_Environment_4004,
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getLink_Vehicle_Environment());

			elements.put(Link_NormalVehicle_SafetyRequirements_4005,
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE
							.getLink_NormalVehicle_SafetyRequirements());

			elements.put(Link_DriverProfile_DriverPreference_4006,
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getLink_DriverProfile_DriverPreference());

			elements.put(Link_Collision_Obstruction_4007,
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getLink_Collision_Obstruction());

			elements.put(Link_Platoon_FollowingVehicle_4008,
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getLink_Platoon_FollowingVehicle());

			elements.put(Link_DriverPreference_EnvironmentCondition_4009,
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE
							.getLink_DriverPreference_EnvironmentCondition());

			elements.put(Link_AbnormalBehaviour_Action_4010,
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getLink_AbnormalBehaviour_Action());

			elements.put(Link_Following_Forward_4011,
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getLink_Following_Forward());

			elements.put(Link_EnvironmentCondition_LaneType_4012,
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getLink_EnvironmentCondition_LaneType());

			elements.put(Link_VehicleConfiguration_VehicleType_4013,
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE
							.getLink_VehicleConfiguration_VehicleType());

			elements.put(Link_Platoon_LeadingVehicle_4014,
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getLink_Platoon_LeadingVehicle());

			elements.put(Link_Driver_Environment_4015,
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getLink_Driver_Environment());

			elements.put(Link_LaneChanging_Turn_4016,
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getLink_LaneChanging_Turn());

			elements.put(Link_EnvironmentCondition_TrafficCondition_4017,
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE
							.getLink_EnvironmentCondition_TrafficCondition());

			elements.put(Link_Intersection_TrafficLight_4018,
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getLink_Intersection_TrafficLight());

			elements.put(Link_Following_MinGap_4019,
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getLink_Following_MinGap());

			elements.put(Link_NormalBehaviour_LaneChanging_4020,
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getLink_NormalBehaviour_LaneChanging());

			elements.put(Link_SafetyRequirement_Regulation_4021,
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getLink_SafetyRequirement_Regulation());

			elements.put(Link_DriverPreference_DrivingBehaviour_4022,
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE
							.getLink_DriverPreference_DrivingBehaviour());

			elements.put(Link_FollowingVehicle_FrontVehicle_4023,
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getLink_FollowingVehicle_FrontVehicle());

			elements.put(Link_DriverPreference_DriverEmotion_4024,
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getLink_DriverPreference_DriverEmotion());

			elements.put(Link_EnvironmentBackground_EnvironmentCondition_4025,
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE
							.getLink_EnvironmentBackground_EnvironmentCondition());

			elements.put(Link_EnvironmentCondition_Weather_4026,
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getLink_EnvironmentCondition_Weather());

			elements.put(Link_EnvironmentCondition_SpecialCondition_4027,
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE
							.getLink_EnvironmentCondition_SpecialCondition());

			elements.put(Link_SpecialCondition_Intersection_4028,
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getLink_SpecialCondition_Intersection());

			elements.put(Link_Following_Backward_4029,
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getLink_Following_Backward());

			elements.put(Link_EnvironmentCondition_Regulations_4030,
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE
							.getLink_EnvironmentCondition_Regulations());

			elements.put(Link_DrivingBehaviour_NormalBehaviour_4031,
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE
							.getLink_DrivingBehaviour_NormalBehaviour());

			elements.put(Link_LaneChanging_EnvironmentCondition_4032,
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE
							.getLink_LaneChanging_EnvironmentCondition());

			elements.put(Link_LaneChanging_GapAcceptance_4033,
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getLink_LaneChanging_GapAcceptance());

			elements.put(Link_NormalBehaviour_Following_4034,
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getLink_NormalBehaviour_Following());

			elements.put(Link_Infrastructure_VehicleConfiguration_4035,
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE
							.getLink_Infrastructure_VehicleConfiguration());

			elements.put(Link_CommunicationInterface_VehicleConfiguration_4036,
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE
							.getLink_CommunicationInterface_VehicleConfiguration());

			elements.put(Link_Goal_DrivingBehaviour_4037,
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getLink_Goal_DrivingBehaviour());

			elements.put(Link_CooperativeBehaviour_CommunicationInterface_4038,
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE
							.getLink_CooperativeBehaviour_CommunicationInterface());

			elements.put(Link_CommunicationInterface_Infrastructure_4039,
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE
							.getLink_CommunicationInterface_Infrastructure());

			elements.put(Link_CooperativeBehaviour_VehicleConfiguration_4040,
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE
							.getLink_CooperativeBehaviour_VehicleConfiguration());

			elements.put(Link_TrafficSituation_EnvironmentCondition_4041,
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE
							.getLink_TrafficSituation_EnvironmentCondition());

			elements.put(Link_Collision_SpecialCondition_4042,
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getLink_Collision_SpecialCondition());

			elements.put(Link_Following_LaneChanging_4043,
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getLink_Following_LaneChanging());

			elements.put(Link_Action_Backward_4044,
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getLink_Action_Backward());

			elements.put(Link_Action_Forward_4045,
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getLink_Action_Forward());

			elements.put(Link_Action_Turn_4046,
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getLink_Action_Turn());

			elements.put(Link_KnowledgeAndSkill_DriverPreference_4047,
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE
							.getLink_KnowledgeAndSkill_DriverPreference());
		}
		return (ENamedElement) elements.get(type);
	}

	/**
	* @generated
	*/
	private static IElementType getElementType(String id) {
		return ElementTypeRegistry.getInstance().getType(id);
	}

	/**
	* @generated
	*/
	public static boolean isKnownElementType(IElementType elementType) {
		if (KNOWN_ELEMENT_TYPES == null) {
			KNOWN_ELEMENT_TYPES = new HashSet/*[org.eclipse.gmf.runtime.emf.type.core.IElementType]*/();
			KNOWN_ELEMENT_TYPES.add(MobilitySystem_1000);
			KNOWN_ELEMENT_TYPES.add(Special_Condition_2001);
			KNOWN_ELEMENT_TYPES.add(Weather_2002);
			KNOWN_ELEMENT_TYPES.add(Traffic_Light_2003);
			KNOWN_ELEMENT_TYPES.add(Knowledge_and_Skill_2004);
			KNOWN_ELEMENT_TYPES.add(Obstruction_2005);
			KNOWN_ELEMENT_TYPES.add(Driver_Preference_2006);
			KNOWN_ELEMENT_TYPES.add(Intersection_2007);
			KNOWN_ELEMENT_TYPES.add(Vehicle_Configuration_2008);
			KNOWN_ELEMENT_TYPES.add(Environment_Condition_2009);
			KNOWN_ELEMENT_TYPES.add(Platoon_2010);
			KNOWN_ELEMENT_TYPES.add(Forward_2011);
			KNOWN_ELEMENT_TYPES.add(Lane_Type_2012);
			KNOWN_ELEMENT_TYPES.add(Environment_Background_2013);
			KNOWN_ELEMENT_TYPES.add(Turn_2014);
			KNOWN_ELEMENT_TYPES.add(LaneChanging_2015);
			KNOWN_ELEMENT_TYPES.add(Driver_Emotion_2016);
			KNOWN_ELEMENT_TYPES.add(Collision_2017);
			KNOWN_ELEMENT_TYPES.add(PossibleVehicle_2018);
			KNOWN_ELEMENT_TYPES.add(Following_2019);
			KNOWN_ELEMENT_TYPES.add(GapAcceptance_2020);
			KNOWN_ELEMENT_TYPES.add(Leading_Vehicle_2021);
			KNOWN_ELEMENT_TYPES.add(Backward_2022);
			KNOWN_ELEMENT_TYPES.add(Regulation_2023);
			KNOWN_ELEMENT_TYPES.add(Traffic_Situation_2024);
			KNOWN_ELEMENT_TYPES.add(Driver_Profile_2025);
			KNOWN_ELEMENT_TYPES.add(Safety_Requirement_2026);
			KNOWN_ELEMENT_TYPES.add(Driving_Behaviour_2027);
			KNOWN_ELEMENT_TYPES.add(Following_Vehicle_2028);
			KNOWN_ELEMENT_TYPES.add(Abnormal_Behaviour_2029);
			KNOWN_ELEMENT_TYPES.add(Backward_2030);
			KNOWN_ELEMENT_TYPES.add(Intersection_2031);
			KNOWN_ELEMENT_TYPES.add(CommunicationInterface_2032);
			KNOWN_ELEMENT_TYPES.add(Goal_2033);
			KNOWN_ELEMENT_TYPES.add(Normal_Behaviour_2034);
			KNOWN_ELEMENT_TYPES.add(Platoon_2035);
			KNOWN_ELEMENT_TYPES.add(Normal_Vehicle_2036);
			KNOWN_ELEMENT_TYPES.add(CooperativeBehavior_2037);
			KNOWN_ELEMENT_TYPES.add(Action_2039);
			KNOWN_ELEMENT_TYPES.add(Link_LaneType_Regulation_4001);
			KNOWN_ELEMENT_TYPES.add(Link_Driver_Vehicle_4002);
			KNOWN_ELEMENT_TYPES.add(Link_EnvironmentBackground_PossibleVehicle_4003);
			KNOWN_ELEMENT_TYPES.add(Link_Vehicle_Environment_4004);
			KNOWN_ELEMENT_TYPES.add(Link_NormalVehicle_SafetyRequirements_4005);
			KNOWN_ELEMENT_TYPES.add(Link_DriverProfile_DriverPreference_4006);
			KNOWN_ELEMENT_TYPES.add(Link_Collision_Obstruction_4007);
			KNOWN_ELEMENT_TYPES.add(Link_Platoon_FollowingVehicle_4008);
			KNOWN_ELEMENT_TYPES.add(Link_DriverPreference_EnvironmentCondition_4009);
			KNOWN_ELEMENT_TYPES.add(Link_AbnormalBehaviour_Action_4010);
			KNOWN_ELEMENT_TYPES.add(Link_Following_Forward_4011);
			KNOWN_ELEMENT_TYPES.add(Link_EnvironmentCondition_LaneType_4012);
			KNOWN_ELEMENT_TYPES.add(Link_VehicleConfiguration_VehicleType_4013);
			KNOWN_ELEMENT_TYPES.add(Link_Platoon_LeadingVehicle_4014);
			KNOWN_ELEMENT_TYPES.add(Link_Driver_Environment_4015);
			KNOWN_ELEMENT_TYPES.add(Link_LaneChanging_Turn_4016);
			KNOWN_ELEMENT_TYPES.add(Link_EnvironmentCondition_TrafficCondition_4017);
			KNOWN_ELEMENT_TYPES.add(Link_Intersection_TrafficLight_4018);
			KNOWN_ELEMENT_TYPES.add(Link_Following_MinGap_4019);
			KNOWN_ELEMENT_TYPES.add(Link_NormalBehaviour_LaneChanging_4020);
			KNOWN_ELEMENT_TYPES.add(Link_SafetyRequirement_Regulation_4021);
			KNOWN_ELEMENT_TYPES.add(Link_DriverPreference_DrivingBehaviour_4022);
			KNOWN_ELEMENT_TYPES.add(Link_FollowingVehicle_FrontVehicle_4023);
			KNOWN_ELEMENT_TYPES.add(Link_DriverPreference_DriverEmotion_4024);
			KNOWN_ELEMENT_TYPES.add(Link_EnvironmentBackground_EnvironmentCondition_4025);
			KNOWN_ELEMENT_TYPES.add(Link_EnvironmentCondition_Weather_4026);
			KNOWN_ELEMENT_TYPES.add(Link_EnvironmentCondition_SpecialCondition_4027);
			KNOWN_ELEMENT_TYPES.add(Link_SpecialCondition_Intersection_4028);
			KNOWN_ELEMENT_TYPES.add(Link_Following_Backward_4029);
			KNOWN_ELEMENT_TYPES.add(Link_EnvironmentCondition_Regulations_4030);
			KNOWN_ELEMENT_TYPES.add(Link_DrivingBehaviour_NormalBehaviour_4031);
			KNOWN_ELEMENT_TYPES.add(Link_LaneChanging_EnvironmentCondition_4032);
			KNOWN_ELEMENT_TYPES.add(Link_LaneChanging_GapAcceptance_4033);
			KNOWN_ELEMENT_TYPES.add(Link_NormalBehaviour_Following_4034);
			KNOWN_ELEMENT_TYPES.add(Link_Infrastructure_VehicleConfiguration_4035);
			KNOWN_ELEMENT_TYPES.add(Link_CommunicationInterface_VehicleConfiguration_4036);
			KNOWN_ELEMENT_TYPES.add(Link_Goal_DrivingBehaviour_4037);
			KNOWN_ELEMENT_TYPES.add(Link_CooperativeBehaviour_CommunicationInterface_4038);
			KNOWN_ELEMENT_TYPES.add(Link_CommunicationInterface_Infrastructure_4039);
			KNOWN_ELEMENT_TYPES.add(Link_CooperativeBehaviour_VehicleConfiguration_4040);
			KNOWN_ELEMENT_TYPES.add(Link_TrafficSituation_EnvironmentCondition_4041);
			KNOWN_ELEMENT_TYPES.add(Link_Collision_SpecialCondition_4042);
			KNOWN_ELEMENT_TYPES.add(Link_Following_LaneChanging_4043);
			KNOWN_ELEMENT_TYPES.add(Link_Action_Backward_4044);
			KNOWN_ELEMENT_TYPES.add(Link_Action_Forward_4045);
			KNOWN_ELEMENT_TYPES.add(Link_Action_Turn_4046);
			KNOWN_ELEMENT_TYPES.add(Link_KnowledgeAndSkill_DriverPreference_4047);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	* @generated
	*/
	public static IElementType getElementType(int visualID) {
		switch (visualID) {
		case intelligentMobility.diagram.edit.parts.MobilitySystemEditPart.VISUAL_ID:
			return MobilitySystem_1000;
		case intelligentMobility.diagram.edit.parts.Special_ConditionEditPart.VISUAL_ID:
			return Special_Condition_2001;
		case intelligentMobility.diagram.edit.parts.WeatherEditPart.VISUAL_ID:
			return Weather_2002;
		case intelligentMobility.diagram.edit.parts.Traffic_LightEditPart.VISUAL_ID:
			return Traffic_Light_2003;
		case intelligentMobility.diagram.edit.parts.Knowledge_and_SkillEditPart.VISUAL_ID:
			return Knowledge_and_Skill_2004;
		case intelligentMobility.diagram.edit.parts.ObstructionEditPart.VISUAL_ID:
			return Obstruction_2005;
		case intelligentMobility.diagram.edit.parts.Driver_PreferenceEditPart.VISUAL_ID:
			return Driver_Preference_2006;
		case intelligentMobility.diagram.edit.parts.IntersectionEditPart.VISUAL_ID:
			return Intersection_2007;
		case intelligentMobility.diagram.edit.parts.Vehicle_ConfigurationEditPart.VISUAL_ID:
			return Vehicle_Configuration_2008;
		case intelligentMobility.diagram.edit.parts.Environment_ConditionEditPart.VISUAL_ID:
			return Environment_Condition_2009;
		case intelligentMobility.diagram.edit.parts.PlatoonEditPart.VISUAL_ID:
			return Platoon_2010;
		case intelligentMobility.diagram.edit.parts.ForwardEditPart.VISUAL_ID:
			return Forward_2011;
		case intelligentMobility.diagram.edit.parts.Lane_TypeEditPart.VISUAL_ID:
			return Lane_Type_2012;
		case intelligentMobility.diagram.edit.parts.Environment_BackgroundEditPart.VISUAL_ID:
			return Environment_Background_2013;
		case intelligentMobility.diagram.edit.parts.TurnEditPart.VISUAL_ID:
			return Turn_2014;
		case intelligentMobility.diagram.edit.parts.LaneChangingEditPart.VISUAL_ID:
			return LaneChanging_2015;
		case intelligentMobility.diagram.edit.parts.Driver_EmotionEditPart.VISUAL_ID:
			return Driver_Emotion_2016;
		case intelligentMobility.diagram.edit.parts.CollisionEditPart.VISUAL_ID:
			return Collision_2017;
		case intelligentMobility.diagram.edit.parts.PossibleVehicleEditPart.VISUAL_ID:
			return PossibleVehicle_2018;
		case intelligentMobility.diagram.edit.parts.FollowingEditPart.VISUAL_ID:
			return Following_2019;
		case intelligentMobility.diagram.edit.parts.GapAcceptanceEditPart.VISUAL_ID:
			return GapAcceptance_2020;
		case intelligentMobility.diagram.edit.parts.Leading_VehicleEditPart.VISUAL_ID:
			return Leading_Vehicle_2021;
		case intelligentMobility.diagram.edit.parts.BackwardEditPart.VISUAL_ID:
			return Backward_2022;
		case intelligentMobility.diagram.edit.parts.RegulationEditPart.VISUAL_ID:
			return Regulation_2023;
		case intelligentMobility.diagram.edit.parts.Traffic_SituationEditPart.VISUAL_ID:
			return Traffic_Situation_2024;
		case intelligentMobility.diagram.edit.parts.Driver_ProfileEditPart.VISUAL_ID:
			return Driver_Profile_2025;
		case intelligentMobility.diagram.edit.parts.Safety_RequirementEditPart.VISUAL_ID:
			return Safety_Requirement_2026;
		case intelligentMobility.diagram.edit.parts.Driving_BehaviourEditPart.VISUAL_ID:
			return Driving_Behaviour_2027;
		case intelligentMobility.diagram.edit.parts.Following_VehicleEditPart.VISUAL_ID:
			return Following_Vehicle_2028;
		case intelligentMobility.diagram.edit.parts.Abnormal_BehaviourEditPart.VISUAL_ID:
			return Abnormal_Behaviour_2029;
		case intelligentMobility.diagram.edit.parts.Backward2EditPart.VISUAL_ID:
			return Backward_2030;
		case intelligentMobility.diagram.edit.parts.Intersection2EditPart.VISUAL_ID:
			return Intersection_2031;
		case intelligentMobility.diagram.edit.parts.CommunicationInterfaceEditPart.VISUAL_ID:
			return CommunicationInterface_2032;
		case intelligentMobility.diagram.edit.parts.GoalEditPart.VISUAL_ID:
			return Goal_2033;
		case intelligentMobility.diagram.edit.parts.Normal_BehaviourEditPart.VISUAL_ID:
			return Normal_Behaviour_2034;
		case intelligentMobility.diagram.edit.parts.Platoon2EditPart.VISUAL_ID:
			return Platoon_2035;
		case intelligentMobility.diagram.edit.parts.Normal_VehicleEditPart.VISUAL_ID:
			return Normal_Vehicle_2036;
		case intelligentMobility.diagram.edit.parts.CooperativeBehaviorEditPart.VISUAL_ID:
			return CooperativeBehavior_2037;
		case intelligentMobility.diagram.edit.parts.ActionEditPart.VISUAL_ID:
			return Action_2039;
		case intelligentMobility.diagram.edit.parts.Link_LaneType_RegulationEditPart.VISUAL_ID:
			return Link_LaneType_Regulation_4001;
		case intelligentMobility.diagram.edit.parts.Link_Driver_VehicleEditPart.VISUAL_ID:
			return Link_Driver_Vehicle_4002;
		case intelligentMobility.diagram.edit.parts.Link_EnvironmentBackground_PossibleVehicleEditPart.VISUAL_ID:
			return Link_EnvironmentBackground_PossibleVehicle_4003;
		case intelligentMobility.diagram.edit.parts.Link_Vehicle_EnvironmentEditPart.VISUAL_ID:
			return Link_Vehicle_Environment_4004;
		case intelligentMobility.diagram.edit.parts.Link_NormalVehicle_SafetyRequirementsEditPart.VISUAL_ID:
			return Link_NormalVehicle_SafetyRequirements_4005;
		case intelligentMobility.diagram.edit.parts.Link_DriverProfile_DriverPreferenceEditPart.VISUAL_ID:
			return Link_DriverProfile_DriverPreference_4006;
		case intelligentMobility.diagram.edit.parts.Link_Collision_ObstructionEditPart.VISUAL_ID:
			return Link_Collision_Obstruction_4007;
		case intelligentMobility.diagram.edit.parts.Link_Platoon_FollowingVehicleEditPart.VISUAL_ID:
			return Link_Platoon_FollowingVehicle_4008;
		case intelligentMobility.diagram.edit.parts.Link_DriverPreference_EnvironmentConditionEditPart.VISUAL_ID:
			return Link_DriverPreference_EnvironmentCondition_4009;
		case intelligentMobility.diagram.edit.parts.Link_AbnormalBehaviour_ActionEditPart.VISUAL_ID:
			return Link_AbnormalBehaviour_Action_4010;
		case intelligentMobility.diagram.edit.parts.Link_Following_ForwardEditPart.VISUAL_ID:
			return Link_Following_Forward_4011;
		case intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_LaneTypeEditPart.VISUAL_ID:
			return Link_EnvironmentCondition_LaneType_4012;
		case intelligentMobility.diagram.edit.parts.Link_VehicleConfiguration_VehicleTypeEditPart.VISUAL_ID:
			return Link_VehicleConfiguration_VehicleType_4013;
		case intelligentMobility.diagram.edit.parts.Link_Platoon_LeadingVehicleEditPart.VISUAL_ID:
			return Link_Platoon_LeadingVehicle_4014;
		case intelligentMobility.diagram.edit.parts.Link_Driver_EnvironmentEditPart.VISUAL_ID:
			return Link_Driver_Environment_4015;
		case intelligentMobility.diagram.edit.parts.Link_LaneChanging_TurnEditPart.VISUAL_ID:
			return Link_LaneChanging_Turn_4016;
		case intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_TrafficConditionEditPart.VISUAL_ID:
			return Link_EnvironmentCondition_TrafficCondition_4017;
		case intelligentMobility.diagram.edit.parts.Link_Intersection_TrafficLightEditPart.VISUAL_ID:
			return Link_Intersection_TrafficLight_4018;
		case intelligentMobility.diagram.edit.parts.Link_Following_MinGapEditPart.VISUAL_ID:
			return Link_Following_MinGap_4019;
		case intelligentMobility.diagram.edit.parts.Link_NormalBehaviour_LaneChangingEditPart.VISUAL_ID:
			return Link_NormalBehaviour_LaneChanging_4020;
		case intelligentMobility.diagram.edit.parts.Link_SafetyRequirement_RegulationEditPart.VISUAL_ID:
			return Link_SafetyRequirement_Regulation_4021;
		case intelligentMobility.diagram.edit.parts.Link_DriverPreference_DrivingBehaviourEditPart.VISUAL_ID:
			return Link_DriverPreference_DrivingBehaviour_4022;
		case intelligentMobility.diagram.edit.parts.Link_FollowingVehicle_FrontVehicleEditPart.VISUAL_ID:
			return Link_FollowingVehicle_FrontVehicle_4023;
		case intelligentMobility.diagram.edit.parts.Link_DriverPreference_DriverEmotionEditPart.VISUAL_ID:
			return Link_DriverPreference_DriverEmotion_4024;
		case intelligentMobility.diagram.edit.parts.Link_EnvironmentBackground_EnvironmentConditionEditPart.VISUAL_ID:
			return Link_EnvironmentBackground_EnvironmentCondition_4025;
		case intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_WeatherEditPart.VISUAL_ID:
			return Link_EnvironmentCondition_Weather_4026;
		case intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_SpecialConditionEditPart.VISUAL_ID:
			return Link_EnvironmentCondition_SpecialCondition_4027;
		case intelligentMobility.diagram.edit.parts.Link_SpecialCondition_IntersectionEditPart.VISUAL_ID:
			return Link_SpecialCondition_Intersection_4028;
		case intelligentMobility.diagram.edit.parts.Link_Following_BackwardEditPart.VISUAL_ID:
			return Link_Following_Backward_4029;
		case intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_RegulationsEditPart.VISUAL_ID:
			return Link_EnvironmentCondition_Regulations_4030;
		case intelligentMobility.diagram.edit.parts.Link_DrivingBehaviour_NormalBehaviourEditPart.VISUAL_ID:
			return Link_DrivingBehaviour_NormalBehaviour_4031;
		case intelligentMobility.diagram.edit.parts.Link_LaneChanging_EnvironmentConditionEditPart.VISUAL_ID:
			return Link_LaneChanging_EnvironmentCondition_4032;
		case intelligentMobility.diagram.edit.parts.Link_LaneChanging_GapAcceptanceEditPart.VISUAL_ID:
			return Link_LaneChanging_GapAcceptance_4033;
		case intelligentMobility.diagram.edit.parts.Link_NormalBehaviour_FollowingEditPart.VISUAL_ID:
			return Link_NormalBehaviour_Following_4034;
		case intelligentMobility.diagram.edit.parts.Link_Infrastructure_VehicleConfigurationEditPart.VISUAL_ID:
			return Link_Infrastructure_VehicleConfiguration_4035;
		case intelligentMobility.diagram.edit.parts.Link_CommunicationInterface_VehicleConfigurationEditPart.VISUAL_ID:
			return Link_CommunicationInterface_VehicleConfiguration_4036;
		case intelligentMobility.diagram.edit.parts.Link_Goal_DrivingBehaviourEditPart.VISUAL_ID:
			return Link_Goal_DrivingBehaviour_4037;
		case intelligentMobility.diagram.edit.parts.Link_CooperativeBehaviour_CommunicationInterfaceEditPart.VISUAL_ID:
			return Link_CooperativeBehaviour_CommunicationInterface_4038;
		case intelligentMobility.diagram.edit.parts.Link_CommunicationInterface_InfrastructureEditPart.VISUAL_ID:
			return Link_CommunicationInterface_Infrastructure_4039;
		case intelligentMobility.diagram.edit.parts.Link_CooperativeBehaviour_VehicleConfigurationEditPart.VISUAL_ID:
			return Link_CooperativeBehaviour_VehicleConfiguration_4040;
		case intelligentMobility.diagram.edit.parts.Link_TrafficSituation_EnvironmentConditionEditPart.VISUAL_ID:
			return Link_TrafficSituation_EnvironmentCondition_4041;
		case intelligentMobility.diagram.edit.parts.Link_Collision_SpecialConditionEditPart.VISUAL_ID:
			return Link_Collision_SpecialCondition_4042;
		case intelligentMobility.diagram.edit.parts.Link_Following_LaneChangingEditPart.VISUAL_ID:
			return Link_Following_LaneChanging_4043;
		case intelligentMobility.diagram.edit.parts.Link_Action_BackwardEditPart.VISUAL_ID:
			return Link_Action_Backward_4044;
		case intelligentMobility.diagram.edit.parts.Link_Action_ForwardEditPart.VISUAL_ID:
			return Link_Action_Forward_4045;
		case intelligentMobility.diagram.edit.parts.Link_Action_TurnEditPart.VISUAL_ID:
			return Link_Action_Turn_4046;
		case intelligentMobility.diagram.edit.parts.Link_KnowledgeAndSkill_DriverPreferenceEditPart.VISUAL_ID:
			return Link_KnowledgeAndSkill_DriverPreference_4047;
		}
		return null;
	}

	/**
	* @generated
	*/
	public static final DiagramElementTypes TYPED_INSTANCE = new DiagramElementTypes(elementTypeImages) {

		/**
		* @generated
		*/

		public boolean isKnownElementType(IElementType elementType) {
			return intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes
					.isKnownElementType(elementType);
		}

		/**
		* @generated
		*/

		public IElementType getElementTypeForVisualId(int visualID) {
			return intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.getElementType(visualID);
		}

		/**
		* @generated
		*/

		public ENamedElement getDefiningNamedElement(IAdaptable elementTypeAdapter) {
			return intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes
					.getElement(elementTypeAdapter);
		}
	};

}
