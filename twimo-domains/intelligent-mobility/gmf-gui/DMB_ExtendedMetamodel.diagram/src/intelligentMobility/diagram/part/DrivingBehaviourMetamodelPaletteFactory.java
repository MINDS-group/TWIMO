
package intelligentMobility.diagram.part;

import java.util.ArrayList;
import java.util.Collections;

import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.tooling.runtime.part.DefaultLinkToolEntry;
import org.eclipse.gmf.tooling.runtime.part.DefaultNodeToolEntry;

/**
 * @generated
 */
public class DrivingBehaviourMetamodelPaletteFactory {

	/**
	* @generated
	*/
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createDrivingBehaviourMetamodel1Group());
	}

	/**
	* Creates "drivingBehaviourMetamodel" palette tool group
	* @generated
	*/
	private PaletteContainer createDrivingBehaviourMetamodel1Group() {
		PaletteGroup paletteContainer = new PaletteGroup(
				intelligentMobility.diagram.part.Messages.DrivingBehaviourMetamodel1Group_title);
		paletteContainer.setId("createDrivingBehaviourMetamodel1Group"); //$NON-NLS-1$
		paletteContainer.add(createDriver_Profile1CreationTool());
		paletteContainer.add(createVehicle_Configuration2CreationTool());
		paletteContainer.add(createEnvironment_Background3CreationTool());
		paletteContainer.add(createDriver_Preference4CreationTool());
		paletteContainer.add(createDriver_PreferenceEnvironment_condition5CreationTool());
		paletteContainer.add(createKnowledge_and_Skill6CreationTool());
		paletteContainer.add(createDriver_Emotion7CreationTool());
		paletteContainer.add(createDriving_Behaviour8CreationTool());
		paletteContainer.add(createNormal_Behaviour9CreationTool());
		paletteContainer.add(createFollowing10CreationTool());
		paletteContainer.add(createFollowingMinGap11CreationTool());
		paletteContainer.add(createLaneChanging12CreationTool());
		paletteContainer.add(createLaneChangingEnvironment_condition13CreationTool());
		paletteContainer.add(createAbnormal_Behaviour14CreationTool());
		paletteContainer.add(createForward15CreationTool());
		paletteContainer.add(createBackward16CreationTool());
		paletteContainer.add(createTurn17CreationTool());
		paletteContainer.add(createGapAcceptance18CreationTool());
		paletteContainer.add(createPlatoon19CreationTool());
		paletteContainer.add(createNormal_Vehicle20CreationTool());
		paletteContainer.add(createLeading_Vehicle21CreationTool());
		paletteContainer.add(createFollowing_Vehicle22CreationTool());
		paletteContainer.add(createFollowing_VehicleFrontvehicle23CreationTool());
		paletteContainer.add(createPossibleVehicle24CreationTool());
		paletteContainer.add(createEnvironment_Condition25CreationTool());
		paletteContainer.add(createLane_Type26CreationTool());
		paletteContainer.add(createRegulation27CreationTool());
		paletteContainer.add(createSafety_Requirement28CreationTool());
		paletteContainer.add(createWeather29CreationTool());
		paletteContainer.add(createTraffic_Situation30CreationTool());
		paletteContainer.add(createSpecial_Condition31CreationTool());
		paletteContainer.add(createCollision32CreationTool());
		paletteContainer.add(createIntersection33CreationTool());
		paletteContainer.add(createObstruction34CreationTool());
		paletteContainer.add(createTraffic_Light35CreationTool());
		paletteContainer.add(createExceptionCondition36CreationTool());
		paletteContainer.add(createLink_Driver_Environment37CreationTool());
		paletteContainer.add(createLink_Driver_Vehicle38CreationTool());
		paletteContainer.add(createLink_Vehicle_Environment39CreationTool());
		paletteContainer.add(createLink_DriverProfile_DriverPreference40CreationTool());
		paletteContainer.add(createLink_VehicleConfiguration_VehicleType41CreationTool());
		paletteContainer.add(createLink_EnvironmentBackground_PossibleVehicle42CreationTool());
		paletteContainer.add(createLink_EnvironmentBackground_EnvironmentCondition43CreationTool());
		paletteContainer.add(createLink_DriverPreference_DriverEmotion44CreationTool());
		paletteContainer.add(createLink_DriverPreference_DrivingBehaviour45CreationTool());
		paletteContainer.add(createLink_DriverPreference_EnvironmentCondition46CreationTool());
		paletteContainer.add(createLink_DrivingBehaviour_NormalBehaviour47CreationTool());
		paletteContainer.add(createLink_NormalBehaviour_Following48CreationTool());
		paletteContainer.add(createLink_NormalBehaviour_LaneChanging49CreationTool());
		paletteContainer.add(createLink_Following_MinGap50CreationTool());
		paletteContainer.add(createLink_Following_Forward51CreationTool());
		paletteContainer.add(createLink_Following_Backward52CreationTool());
		paletteContainer.add(createLink_LaneChanging_Turn53CreationTool());
		paletteContainer.add(createLink_LaneChanging_GapAcceptance54CreationTool());
		paletteContainer.add(createLink_LaneChanging_EnvironmentCondition55CreationTool());
		paletteContainer.add(createLink_AbnormalBehaviour_Action56CreationTool());
		paletteContainer.add(createLink_Platoon_LeadingVehicle57CreationTool());
		paletteContainer.add(createLink_Platoon_FollowingVehicle58CreationTool());
		paletteContainer.add(createLink_NormalVehicle_SafetyRequirements59CreationTool());
		paletteContainer.add(createLink_FollowingVehicle_FrontVehicle60CreationTool());
		paletteContainer.add(createLink_EnvironmentCondition_LaneType61CreationTool());
		paletteContainer.add(createLink_EnvironmentCondition_Regulations62CreationTool());
		paletteContainer.add(createLink_EnvironmentCondition_Weather63CreationTool());
		paletteContainer.add(createLink_EnvironmentCondition_TrafficCondition64CreationTool());
		paletteContainer.add(createLink_EnvironmentCondition_SpecialCondition65CreationTool());
		paletteContainer.add(createLink_LaneType_Regulation66CreationTool());
		paletteContainer.add(createLink_SafetyRequirement_Regulation67CreationTool());
		paletteContainer.add(createLink_SpecialCondition_Intersection68CreationTool());
		paletteContainer.add(createLink_Collision_Obstruction69CreationTool());
		paletteContainer.add(createLink_Intersection_TrafficLight70CreationTool());
		paletteContainer.add(createCommunicationInterface71CreationTool());
		paletteContainer.add(createGoal72CreationTool());
		paletteContainer.add(createCooperativeBehaviour73CreationTool());
		paletteContainer.add(createLink_Infrastructure_VehicleConfiguration74CreationTool());
		paletteContainer.add(createLink_CommunicationInterface_VehicleConfiguration75CreationTool());
		paletteContainer.add(createLink_Goal_DrivingBehaviour76CreationTool());
		paletteContainer.add(createLink_CooperativeBehaviour_CommunicationInterface77CreationTool());
		paletteContainer.add(createLink_CommunicationInterface_Infrastructure78CreationTool());
		paletteContainer.add(createLink_CooperativeBehaviour_VehicleConfiguration79CreationTool());
		paletteContainer.add(createAction80CreationTool());
		paletteContainer.add(createLink_TrafficSituation_EnvironmentCondition81CreationTool());
		paletteContainer.add(createLink_Collision_SpecialCondition82CreationTool());
		paletteContainer.add(createLink_Following_LaneChanging83CreationTool());
		paletteContainer.add(createLink_Action_Backward84CreationTool());
		paletteContainer.add(createLink_Action_Forward85CreationTool());
		paletteContainer.add(createLink_Action_Turn86CreationTool());
		paletteContainer.add(createLink_KnowledgeAndSkill_DriverPreference87CreationTool());
		return paletteContainer;
	}

	/**
	* @generated
	*/
	private ToolEntry createDriver_Profile1CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(
				intelligentMobility.diagram.part.Messages.Driver_Profile1CreationTool_title,
				intelligentMobility.diagram.part.Messages.Driver_Profile1CreationTool_desc, Collections.singletonList(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Driver_Profile_2025));
		entry.setId("createDriver_Profile1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.getImageDescriptor(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Driver_Profile_2025));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createVehicle_Configuration2CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(
				intelligentMobility.diagram.part.Messages.Vehicle_Configuration2CreationTool_title,
				intelligentMobility.diagram.part.Messages.Vehicle_Configuration2CreationTool_desc,
				Collections.singletonList(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Vehicle_Configuration_2008));
		entry.setId("createVehicle_Configuration2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.getImageDescriptor(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Vehicle_Configuration_2008));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createEnvironment_Background3CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(
				intelligentMobility.diagram.part.Messages.Environment_Background3CreationTool_title,
				intelligentMobility.diagram.part.Messages.Environment_Background3CreationTool_desc,
				Collections.singletonList(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Environment_Background_2013));
		entry.setId("createEnvironment_Background3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.getImageDescriptor(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Environment_Background_2013));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createDriver_Preference4CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(
				intelligentMobility.diagram.part.Messages.Driver_Preference4CreationTool_title,
				intelligentMobility.diagram.part.Messages.Driver_Preference4CreationTool_desc,
				Collections.singletonList(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Driver_Preference_2006));
		entry.setId("createDriver_Preference4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.getImageDescriptor(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Driver_Preference_2006));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createDriver_PreferenceEnvironment_condition5CreationTool() {
		ToolEntry entry = new ToolEntry(
				intelligentMobility.diagram.part.Messages.Driver_PreferenceEnvironment_condition5CreationTool_title,
				intelligentMobility.diagram.part.Messages.Driver_PreferenceEnvironment_condition5CreationTool_desc,
				null, null) {
		};
		entry.setId("createDriver_PreferenceEnvironment_condition5CreationTool"); //$NON-NLS-1$
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createKnowledge_and_Skill6CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(
				intelligentMobility.diagram.part.Messages.Knowledge_and_Skill6CreationTool_title,
				intelligentMobility.diagram.part.Messages.Knowledge_and_Skill6CreationTool_desc,
				Collections.singletonList(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Knowledge_and_Skill_2004));
		entry.setId("createKnowledge_and_Skill6CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.getImageDescriptor(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Knowledge_and_Skill_2004));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createDriver_Emotion7CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(
				intelligentMobility.diagram.part.Messages.Driver_Emotion7CreationTool_title,
				intelligentMobility.diagram.part.Messages.Driver_Emotion7CreationTool_desc, Collections.singletonList(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Driver_Emotion_2016));
		entry.setId("createDriver_Emotion7CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.getImageDescriptor(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Driver_Emotion_2016));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createDriving_Behaviour8CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(
				intelligentMobility.diagram.part.Messages.Driving_Behaviour8CreationTool_title,
				intelligentMobility.diagram.part.Messages.Driving_Behaviour8CreationTool_desc,
				Collections.singletonList(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Driving_Behaviour_2027));
		entry.setId("createDriving_Behaviour8CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.getImageDescriptor(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Driving_Behaviour_2027));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createNormal_Behaviour9CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(
				intelligentMobility.diagram.part.Messages.Normal_Behaviour9CreationTool_title,
				intelligentMobility.diagram.part.Messages.Normal_Behaviour9CreationTool_desc, Collections.singletonList(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Normal_Behaviour_2034));
		entry.setId("createNormal_Behaviour9CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.getImageDescriptor(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Normal_Behaviour_2034));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createFollowing10CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(
				intelligentMobility.diagram.part.Messages.Following10CreationTool_title,
				intelligentMobility.diagram.part.Messages.Following10CreationTool_desc, Collections.singletonList(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Following_2019));
		entry.setId("createFollowing10CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.getImageDescriptor(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Following_2019));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createFollowingMinGap11CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(
				intelligentMobility.diagram.part.Messages.FollowingMinGap11CreationTool_title,
				intelligentMobility.diagram.part.Messages.FollowingMinGap11CreationTool_desc, Collections.singletonList(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Following_MinGap_4019));
		entry.setId("createFollowingMinGap11CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.getImageDescriptor(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Following_MinGap_4019));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createLaneChanging12CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(
				intelligentMobility.diagram.part.Messages.LaneChanging12CreationTool_title,
				intelligentMobility.diagram.part.Messages.LaneChanging12CreationTool_desc, Collections.singletonList(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.LaneChanging_2015));
		entry.setId("createLaneChanging12CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.getImageDescriptor(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.LaneChanging_2015));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createLaneChangingEnvironment_condition13CreationTool() {
		ToolEntry entry = new ToolEntry(
				intelligentMobility.diagram.part.Messages.LaneChangingEnvironment_condition13CreationTool_title,
				intelligentMobility.diagram.part.Messages.LaneChangingEnvironment_condition13CreationTool_desc, null,
				null) {
		};
		entry.setId("createLaneChangingEnvironment_condition13CreationTool"); //$NON-NLS-1$
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createAbnormal_Behaviour14CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(
				intelligentMobility.diagram.part.Messages.Abnormal_Behaviour14CreationTool_title,
				intelligentMobility.diagram.part.Messages.Abnormal_Behaviour14CreationTool_desc,
				Collections.singletonList(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Abnormal_Behaviour_2029));
		entry.setId("createAbnormal_Behaviour14CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.getImageDescriptor(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Abnormal_Behaviour_2029));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createForward15CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(
				intelligentMobility.diagram.part.Messages.Forward15CreationTool_title,
				intelligentMobility.diagram.part.Messages.Forward15CreationTool_desc, Collections.singletonList(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Forward_2011));
		entry.setId("createForward15CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.getImageDescriptor(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Forward_2011));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createBackward16CreationTool() {
		ArrayList/*[org.eclipse.gmf.runtime.emf.type.core.IElementType]*/ types = new ArrayList/*[org.eclipse.gmf.runtime.emf.type.core.IElementType]*/(
				2);
		types.add(intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Backward_2022);
		types.add(intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Backward_2030);
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(
				intelligentMobility.diagram.part.Messages.Backward16CreationTool_title,
				intelligentMobility.diagram.part.Messages.Backward16CreationTool_desc, types);
		entry.setId("createBackward16CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.getImageDescriptor(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Backward_2022));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createTurn17CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(
				intelligentMobility.diagram.part.Messages.Turn17CreationTool_title,
				intelligentMobility.diagram.part.Messages.Turn17CreationTool_desc, Collections.singletonList(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Turn_2014));
		entry.setId("createTurn17CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.getImageDescriptor(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Turn_2014));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createGapAcceptance18CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(
				intelligentMobility.diagram.part.Messages.GapAcceptance18CreationTool_title,
				intelligentMobility.diagram.part.Messages.GapAcceptance18CreationTool_desc, Collections.singletonList(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.GapAcceptance_2020));
		entry.setId("createGapAcceptance18CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.getImageDescriptor(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.GapAcceptance_2020));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createPlatoon19CreationTool() {
		ArrayList/*[org.eclipse.gmf.runtime.emf.type.core.IElementType]*/ types = new ArrayList/*[org.eclipse.gmf.runtime.emf.type.core.IElementType]*/(
				2);
		types.add(intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Platoon_2010);
		types.add(intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Platoon_2035);
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(
				intelligentMobility.diagram.part.Messages.Platoon19CreationTool_title,
				intelligentMobility.diagram.part.Messages.Platoon19CreationTool_desc, types);
		entry.setId("createPlatoon19CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.getImageDescriptor(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Platoon_2010));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createNormal_Vehicle20CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(
				intelligentMobility.diagram.part.Messages.Normal_Vehicle20CreationTool_title,
				intelligentMobility.diagram.part.Messages.Normal_Vehicle20CreationTool_desc, Collections.singletonList(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Normal_Vehicle_2036));
		entry.setId("createNormal_Vehicle20CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.getImageDescriptor(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Normal_Vehicle_2036));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createLeading_Vehicle21CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(
				intelligentMobility.diagram.part.Messages.Leading_Vehicle21CreationTool_title,
				intelligentMobility.diagram.part.Messages.Leading_Vehicle21CreationTool_desc, Collections.singletonList(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Leading_Vehicle_2021));
		entry.setId("createLeading_Vehicle21CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.getImageDescriptor(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Leading_Vehicle_2021));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createFollowing_Vehicle22CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(
				intelligentMobility.diagram.part.Messages.Following_Vehicle22CreationTool_title,
				intelligentMobility.diagram.part.Messages.Following_Vehicle22CreationTool_desc,
				Collections.singletonList(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Following_Vehicle_2028));
		entry.setId("createFollowing_Vehicle22CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.getImageDescriptor(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Following_Vehicle_2028));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createFollowing_VehicleFrontvehicle23CreationTool() {
		ToolEntry entry = new ToolEntry(
				intelligentMobility.diagram.part.Messages.Following_VehicleFrontvehicle23CreationTool_title,
				intelligentMobility.diagram.part.Messages.Following_VehicleFrontvehicle23CreationTool_desc, null,
				null) {
		};
		entry.setId("createFollowing_VehicleFrontvehicle23CreationTool"); //$NON-NLS-1$
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createPossibleVehicle24CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(
				intelligentMobility.diagram.part.Messages.PossibleVehicle24CreationTool_title,
				intelligentMobility.diagram.part.Messages.PossibleVehicle24CreationTool_desc, Collections.singletonList(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.PossibleVehicle_2018));
		entry.setId("createPossibleVehicle24CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.getImageDescriptor(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.PossibleVehicle_2018));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createEnvironment_Condition25CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(
				intelligentMobility.diagram.part.Messages.Environment_Condition25CreationTool_title,
				intelligentMobility.diagram.part.Messages.Environment_Condition25CreationTool_desc,
				Collections.singletonList(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Environment_Condition_2009));
		entry.setId("createEnvironment_Condition25CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.getImageDescriptor(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Environment_Condition_2009));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createLane_Type26CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(
				intelligentMobility.diagram.part.Messages.Lane_Type26CreationTool_title,
				intelligentMobility.diagram.part.Messages.Lane_Type26CreationTool_desc, Collections.singletonList(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Lane_Type_2012));
		entry.setId("createLane_Type26CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.getImageDescriptor(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Lane_Type_2012));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createRegulation27CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(
				intelligentMobility.diagram.part.Messages.Regulation27CreationTool_title,
				intelligentMobility.diagram.part.Messages.Regulation27CreationTool_desc, Collections.singletonList(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Regulation_2023));
		entry.setId("createRegulation27CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.getImageDescriptor(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Regulation_2023));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createSafety_Requirement28CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(
				intelligentMobility.diagram.part.Messages.Safety_Requirement28CreationTool_title,
				intelligentMobility.diagram.part.Messages.Safety_Requirement28CreationTool_desc,
				Collections.singletonList(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Safety_Requirement_2026));
		entry.setId("createSafety_Requirement28CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.getImageDescriptor(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Safety_Requirement_2026));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createWeather29CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(
				intelligentMobility.diagram.part.Messages.Weather29CreationTool_title,
				intelligentMobility.diagram.part.Messages.Weather29CreationTool_desc, Collections.singletonList(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Weather_2002));
		entry.setId("createWeather29CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.getImageDescriptor(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Weather_2002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createTraffic_Situation30CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(
				intelligentMobility.diagram.part.Messages.Traffic_Situation30CreationTool_title,
				intelligentMobility.diagram.part.Messages.Traffic_Situation30CreationTool_desc,
				Collections.singletonList(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Traffic_Situation_2024));
		entry.setId("createTraffic_Situation30CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.getImageDescriptor(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Traffic_Situation_2024));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createSpecial_Condition31CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(
				intelligentMobility.diagram.part.Messages.Special_Condition31CreationTool_title,
				intelligentMobility.diagram.part.Messages.Special_Condition31CreationTool_desc,
				Collections.singletonList(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Special_Condition_2001));
		entry.setId("createSpecial_Condition31CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.getImageDescriptor(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Special_Condition_2001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createCollision32CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(
				intelligentMobility.diagram.part.Messages.Collision32CreationTool_title,
				intelligentMobility.diagram.part.Messages.Collision32CreationTool_desc, Collections.singletonList(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Collision_2017));
		entry.setId("createCollision32CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.getImageDescriptor(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Collision_2017));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createIntersection33CreationTool() {
		ArrayList/*[org.eclipse.gmf.runtime.emf.type.core.IElementType]*/ types = new ArrayList/*[org.eclipse.gmf.runtime.emf.type.core.IElementType]*/(
				2);
		types.add(intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Intersection_2007);
		types.add(intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Intersection_2031);
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(
				intelligentMobility.diagram.part.Messages.Intersection33CreationTool_title,
				intelligentMobility.diagram.part.Messages.Intersection33CreationTool_desc, types);
		entry.setId("createIntersection33CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.getImageDescriptor(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Intersection_2007));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createObstruction34CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(
				intelligentMobility.diagram.part.Messages.Obstruction34CreationTool_title,
				intelligentMobility.diagram.part.Messages.Obstruction34CreationTool_desc, Collections.singletonList(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Obstruction_2005));
		entry.setId("createObstruction34CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.getImageDescriptor(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Obstruction_2005));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createTraffic_Light35CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(
				intelligentMobility.diagram.part.Messages.Traffic_Light35CreationTool_title,
				intelligentMobility.diagram.part.Messages.Traffic_Light35CreationTool_desc, Collections.singletonList(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Traffic_Light_2003));
		entry.setId("createTraffic_Light35CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.getImageDescriptor(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Traffic_Light_2003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createExceptionCondition36CreationTool() {
		ToolEntry entry = new ToolEntry(
				intelligentMobility.diagram.part.Messages.ExceptionCondition36CreationTool_title,
				intelligentMobility.diagram.part.Messages.ExceptionCondition36CreationTool_desc, null, null) {
		};
		entry.setId("createExceptionCondition36CreationTool"); //$NON-NLS-1$
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createLink_Driver_Environment37CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(
				intelligentMobility.diagram.part.Messages.Link_Driver_Environment37CreationTool_title,
				intelligentMobility.diagram.part.Messages.Link_Driver_Environment37CreationTool_desc,
				Collections.singletonList(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Driver_Environment_4015));
		entry.setId("createLink_Driver_Environment37CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.getImageDescriptor(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Driver_Environment_4015));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createLink_Driver_Vehicle38CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(
				intelligentMobility.diagram.part.Messages.Link_Driver_Vehicle38CreationTool_title,
				intelligentMobility.diagram.part.Messages.Link_Driver_Vehicle38CreationTool_desc,
				Collections.singletonList(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Driver_Vehicle_4002));
		entry.setId("createLink_Driver_Vehicle38CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.getImageDescriptor(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Driver_Vehicle_4002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createLink_Vehicle_Environment39CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(
				intelligentMobility.diagram.part.Messages.Link_Vehicle_Environment39CreationTool_title,
				intelligentMobility.diagram.part.Messages.Link_Vehicle_Environment39CreationTool_desc,
				Collections.singletonList(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Vehicle_Environment_4004));
		entry.setId("createLink_Vehicle_Environment39CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.getImageDescriptor(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Vehicle_Environment_4004));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createLink_DriverProfile_DriverPreference40CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(
				intelligentMobility.diagram.part.Messages.Link_DriverProfile_DriverPreference40CreationTool_title,
				intelligentMobility.diagram.part.Messages.Link_DriverProfile_DriverPreference40CreationTool_desc,
				Collections.singletonList(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_DriverProfile_DriverPreference_4006));
		entry.setId("createLink_DriverProfile_DriverPreference40CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.getImageDescriptor(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_DriverProfile_DriverPreference_4006));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createLink_VehicleConfiguration_VehicleType41CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(
				intelligentMobility.diagram.part.Messages.Link_VehicleConfiguration_VehicleType41CreationTool_title,
				intelligentMobility.diagram.part.Messages.Link_VehicleConfiguration_VehicleType41CreationTool_desc,
				Collections.singletonList(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_VehicleConfiguration_VehicleType_4013));
		entry.setId("createLink_VehicleConfiguration_VehicleType41CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.getImageDescriptor(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_VehicleConfiguration_VehicleType_4013));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createLink_EnvironmentBackground_PossibleVehicle42CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(
				intelligentMobility.diagram.part.Messages.Link_EnvironmentBackground_PossibleVehicle42CreationTool_title,
				intelligentMobility.diagram.part.Messages.Link_EnvironmentBackground_PossibleVehicle42CreationTool_desc,
				Collections.singletonList(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_EnvironmentBackground_PossibleVehicle_4003));
		entry.setId("createLink_EnvironmentBackground_PossibleVehicle42CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.getImageDescriptor(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_EnvironmentBackground_PossibleVehicle_4003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createLink_EnvironmentBackground_EnvironmentCondition43CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(
				intelligentMobility.diagram.part.Messages.Link_EnvironmentBackground_EnvironmentCondition43CreationTool_title,
				intelligentMobility.diagram.part.Messages.Link_EnvironmentBackground_EnvironmentCondition43CreationTool_desc,
				Collections.singletonList(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_EnvironmentBackground_EnvironmentCondition_4025));
		entry.setId("createLink_EnvironmentBackground_EnvironmentCondition43CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.getImageDescriptor(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_EnvironmentBackground_EnvironmentCondition_4025));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createLink_DriverPreference_DriverEmotion44CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(
				intelligentMobility.diagram.part.Messages.Link_DriverPreference_DriverEmotion44CreationTool_title,
				intelligentMobility.diagram.part.Messages.Link_DriverPreference_DriverEmotion44CreationTool_desc,
				Collections.singletonList(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_DriverPreference_DriverEmotion_4024));
		entry.setId("createLink_DriverPreference_DriverEmotion44CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.getImageDescriptor(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_DriverPreference_DriverEmotion_4024));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createLink_DriverPreference_DrivingBehaviour45CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(
				intelligentMobility.diagram.part.Messages.Link_DriverPreference_DrivingBehaviour45CreationTool_title,
				intelligentMobility.diagram.part.Messages.Link_DriverPreference_DrivingBehaviour45CreationTool_desc,
				Collections.singletonList(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_DriverPreference_DrivingBehaviour_4022));
		entry.setId("createLink_DriverPreference_DrivingBehaviour45CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.getImageDescriptor(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_DriverPreference_DrivingBehaviour_4022));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createLink_DriverPreference_EnvironmentCondition46CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(
				intelligentMobility.diagram.part.Messages.Link_DriverPreference_EnvironmentCondition46CreationTool_title,
				intelligentMobility.diagram.part.Messages.Link_DriverPreference_EnvironmentCondition46CreationTool_desc,
				Collections.singletonList(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_DriverPreference_EnvironmentCondition_4009));
		entry.setId("createLink_DriverPreference_EnvironmentCondition46CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.getImageDescriptor(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_DriverPreference_EnvironmentCondition_4009));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createLink_DrivingBehaviour_NormalBehaviour47CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(
				intelligentMobility.diagram.part.Messages.Link_DrivingBehaviour_NormalBehaviour47CreationTool_title,
				intelligentMobility.diagram.part.Messages.Link_DrivingBehaviour_NormalBehaviour47CreationTool_desc,
				Collections.singletonList(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_DrivingBehaviour_NormalBehaviour_4031));
		entry.setId("createLink_DrivingBehaviour_NormalBehaviour47CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.getImageDescriptor(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_DrivingBehaviour_NormalBehaviour_4031));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createLink_NormalBehaviour_Following48CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(
				intelligentMobility.diagram.part.Messages.Link_NormalBehaviour_Following48CreationTool_title,
				intelligentMobility.diagram.part.Messages.Link_NormalBehaviour_Following48CreationTool_desc,
				Collections.singletonList(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_NormalBehaviour_Following_4034));
		entry.setId("createLink_NormalBehaviour_Following48CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.getImageDescriptor(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_NormalBehaviour_Following_4034));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createLink_NormalBehaviour_LaneChanging49CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(
				intelligentMobility.diagram.part.Messages.Link_NormalBehaviour_LaneChanging49CreationTool_title,
				intelligentMobility.diagram.part.Messages.Link_NormalBehaviour_LaneChanging49CreationTool_desc,
				Collections.singletonList(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_NormalBehaviour_LaneChanging_4020));
		entry.setId("createLink_NormalBehaviour_LaneChanging49CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.getImageDescriptor(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_NormalBehaviour_LaneChanging_4020));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createLink_Following_MinGap50CreationTool() {
		ToolEntry entry = new ToolEntry(
				intelligentMobility.diagram.part.Messages.Link_Following_MinGap50CreationTool_title,
				intelligentMobility.diagram.part.Messages.Link_Following_MinGap50CreationTool_desc, null, null) {
		};
		entry.setId("createLink_Following_MinGap50CreationTool"); //$NON-NLS-1$
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createLink_Following_Forward51CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(
				intelligentMobility.diagram.part.Messages.Link_Following_Forward51CreationTool_title,
				intelligentMobility.diagram.part.Messages.Link_Following_Forward51CreationTool_desc,
				Collections.singletonList(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Following_Forward_4011));
		entry.setId("createLink_Following_Forward51CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.getImageDescriptor(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Following_Forward_4011));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createLink_Following_Backward52CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(
				intelligentMobility.diagram.part.Messages.Link_Following_Backward52CreationTool_title,
				intelligentMobility.diagram.part.Messages.Link_Following_Backward52CreationTool_desc,
				Collections.singletonList(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Following_Backward_4029));
		entry.setId("createLink_Following_Backward52CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.getImageDescriptor(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Following_Backward_4029));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createLink_LaneChanging_Turn53CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(
				intelligentMobility.diagram.part.Messages.Link_LaneChanging_Turn53CreationTool_title,
				intelligentMobility.diagram.part.Messages.Link_LaneChanging_Turn53CreationTool_desc,
				Collections.singletonList(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_LaneChanging_Turn_4016));
		entry.setId("createLink_LaneChanging_Turn53CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.getImageDescriptor(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_LaneChanging_Turn_4016));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createLink_LaneChanging_GapAcceptance54CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(
				intelligentMobility.diagram.part.Messages.Link_LaneChanging_GapAcceptance54CreationTool_title,
				intelligentMobility.diagram.part.Messages.Link_LaneChanging_GapAcceptance54CreationTool_desc,
				Collections.singletonList(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_LaneChanging_GapAcceptance_4033));
		entry.setId("createLink_LaneChanging_GapAcceptance54CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.getImageDescriptor(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_LaneChanging_GapAcceptance_4033));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createLink_LaneChanging_EnvironmentCondition55CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(
				intelligentMobility.diagram.part.Messages.Link_LaneChanging_EnvironmentCondition55CreationTool_title,
				intelligentMobility.diagram.part.Messages.Link_LaneChanging_EnvironmentCondition55CreationTool_desc,
				Collections.singletonList(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_LaneChanging_EnvironmentCondition_4032));
		entry.setId("createLink_LaneChanging_EnvironmentCondition55CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.getImageDescriptor(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_LaneChanging_EnvironmentCondition_4032));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createLink_AbnormalBehaviour_Action56CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(
				intelligentMobility.diagram.part.Messages.Link_AbnormalBehaviour_Action56CreationTool_title,
				intelligentMobility.diagram.part.Messages.Link_AbnormalBehaviour_Action56CreationTool_desc,
				Collections.singletonList(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_AbnormalBehaviour_Action_4010));
		entry.setId("createLink_AbnormalBehaviour_Action56CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.getImageDescriptor(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_AbnormalBehaviour_Action_4010));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createLink_Platoon_LeadingVehicle57CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(
				intelligentMobility.diagram.part.Messages.Link_Platoon_LeadingVehicle57CreationTool_title,
				intelligentMobility.diagram.part.Messages.Link_Platoon_LeadingVehicle57CreationTool_desc,
				Collections.singletonList(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Platoon_LeadingVehicle_4014));
		entry.setId("createLink_Platoon_LeadingVehicle57CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.getImageDescriptor(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Platoon_LeadingVehicle_4014));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createLink_Platoon_FollowingVehicle58CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(
				intelligentMobility.diagram.part.Messages.Link_Platoon_FollowingVehicle58CreationTool_title,
				intelligentMobility.diagram.part.Messages.Link_Platoon_FollowingVehicle58CreationTool_desc,
				Collections.singletonList(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Platoon_FollowingVehicle_4008));
		entry.setId("createLink_Platoon_FollowingVehicle58CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.getImageDescriptor(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Platoon_FollowingVehicle_4008));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createLink_NormalVehicle_SafetyRequirements59CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(
				intelligentMobility.diagram.part.Messages.Link_NormalVehicle_SafetyRequirements59CreationTool_title,
				intelligentMobility.diagram.part.Messages.Link_NormalVehicle_SafetyRequirements59CreationTool_desc,
				Collections.singletonList(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_NormalVehicle_SafetyRequirements_4005));
		entry.setId("createLink_NormalVehicle_SafetyRequirements59CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.getImageDescriptor(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_NormalVehicle_SafetyRequirements_4005));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createLink_FollowingVehicle_FrontVehicle60CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(
				intelligentMobility.diagram.part.Messages.Link_FollowingVehicle_FrontVehicle60CreationTool_title,
				intelligentMobility.diagram.part.Messages.Link_FollowingVehicle_FrontVehicle60CreationTool_desc,
				Collections.singletonList(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_FollowingVehicle_FrontVehicle_4023));
		entry.setId("createLink_FollowingVehicle_FrontVehicle60CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.getImageDescriptor(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_FollowingVehicle_FrontVehicle_4023));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createLink_EnvironmentCondition_LaneType61CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(
				intelligentMobility.diagram.part.Messages.Link_EnvironmentCondition_LaneType61CreationTool_title,
				intelligentMobility.diagram.part.Messages.Link_EnvironmentCondition_LaneType61CreationTool_desc,
				Collections.singletonList(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_EnvironmentCondition_LaneType_4012));
		entry.setId("createLink_EnvironmentCondition_LaneType61CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.getImageDescriptor(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_EnvironmentCondition_LaneType_4012));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createLink_EnvironmentCondition_Regulations62CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(
				intelligentMobility.diagram.part.Messages.Link_EnvironmentCondition_Regulations62CreationTool_title,
				intelligentMobility.diagram.part.Messages.Link_EnvironmentCondition_Regulations62CreationTool_desc,
				Collections.singletonList(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_EnvironmentCondition_Regulations_4030));
		entry.setId("createLink_EnvironmentCondition_Regulations62CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.getImageDescriptor(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_EnvironmentCondition_Regulations_4030));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createLink_EnvironmentCondition_Weather63CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(
				intelligentMobility.diagram.part.Messages.Link_EnvironmentCondition_Weather63CreationTool_title,
				intelligentMobility.diagram.part.Messages.Link_EnvironmentCondition_Weather63CreationTool_desc,
				Collections.singletonList(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_EnvironmentCondition_Weather_4026));
		entry.setId("createLink_EnvironmentCondition_Weather63CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.getImageDescriptor(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_EnvironmentCondition_Weather_4026));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createLink_EnvironmentCondition_TrafficCondition64CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(
				intelligentMobility.diagram.part.Messages.Link_EnvironmentCondition_TrafficCondition64CreationTool_title,
				intelligentMobility.diagram.part.Messages.Link_EnvironmentCondition_TrafficCondition64CreationTool_desc,
				Collections.singletonList(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_EnvironmentCondition_TrafficCondition_4017));
		entry.setId("createLink_EnvironmentCondition_TrafficCondition64CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.getImageDescriptor(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_EnvironmentCondition_TrafficCondition_4017));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createLink_EnvironmentCondition_SpecialCondition65CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(
				intelligentMobility.diagram.part.Messages.Link_EnvironmentCondition_SpecialCondition65CreationTool_title,
				intelligentMobility.diagram.part.Messages.Link_EnvironmentCondition_SpecialCondition65CreationTool_desc,
				Collections.singletonList(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_EnvironmentCondition_SpecialCondition_4027));
		entry.setId("createLink_EnvironmentCondition_SpecialCondition65CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.getImageDescriptor(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_EnvironmentCondition_SpecialCondition_4027));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createLink_LaneType_Regulation66CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(
				intelligentMobility.diagram.part.Messages.Link_LaneType_Regulation66CreationTool_title,
				intelligentMobility.diagram.part.Messages.Link_LaneType_Regulation66CreationTool_desc,
				Collections.singletonList(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_LaneType_Regulation_4001));
		entry.setId("createLink_LaneType_Regulation66CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.getImageDescriptor(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_LaneType_Regulation_4001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createLink_SafetyRequirement_Regulation67CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(
				intelligentMobility.diagram.part.Messages.Link_SafetyRequirement_Regulation67CreationTool_title,
				intelligentMobility.diagram.part.Messages.Link_SafetyRequirement_Regulation67CreationTool_desc,
				Collections.singletonList(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_SafetyRequirement_Regulation_4021));
		entry.setId("createLink_SafetyRequirement_Regulation67CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.getImageDescriptor(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_SafetyRequirement_Regulation_4021));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createLink_SpecialCondition_Intersection68CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(
				intelligentMobility.diagram.part.Messages.Link_SpecialCondition_Intersection68CreationTool_title,
				intelligentMobility.diagram.part.Messages.Link_SpecialCondition_Intersection68CreationTool_desc,
				Collections.singletonList(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_SpecialCondition_Intersection_4028));
		entry.setId("createLink_SpecialCondition_Intersection68CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.getImageDescriptor(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_SpecialCondition_Intersection_4028));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createLink_Collision_Obstruction69CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(
				intelligentMobility.diagram.part.Messages.Link_Collision_Obstruction69CreationTool_title,
				intelligentMobility.diagram.part.Messages.Link_Collision_Obstruction69CreationTool_desc,
				Collections.singletonList(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Collision_Obstruction_4007));
		entry.setId("createLink_Collision_Obstruction69CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.getImageDescriptor(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Collision_Obstruction_4007));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createLink_Intersection_TrafficLight70CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(
				intelligentMobility.diagram.part.Messages.Link_Intersection_TrafficLight70CreationTool_title,
				intelligentMobility.diagram.part.Messages.Link_Intersection_TrafficLight70CreationTool_desc,
				Collections.singletonList(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Intersection_TrafficLight_4018));
		entry.setId("createLink_Intersection_TrafficLight70CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.getImageDescriptor(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Intersection_TrafficLight_4018));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createCommunicationInterface71CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(
				intelligentMobility.diagram.part.Messages.CommunicationInterface71CreationTool_title,
				intelligentMobility.diagram.part.Messages.CommunicationInterface71CreationTool_desc,
				Collections.singletonList(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.CommunicationInterface_2032));
		entry.setId("createCommunicationInterface71CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.getImageDescriptor(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.CommunicationInterface_2032));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createGoal72CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(
				intelligentMobility.diagram.part.Messages.Goal72CreationTool_title,
				intelligentMobility.diagram.part.Messages.Goal72CreationTool_desc, Collections.singletonList(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Goal_2033));
		entry.setId("createGoal72CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.getImageDescriptor(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Goal_2033));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createCooperativeBehaviour73CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(
				intelligentMobility.diagram.part.Messages.CooperativeBehaviour73CreationTool_title,
				intelligentMobility.diagram.part.Messages.CooperativeBehaviour73CreationTool_desc,
				Collections.singletonList(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.CooperativeBehavior_2037));
		entry.setId("createCooperativeBehaviour73CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.getImageDescriptor(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.CooperativeBehavior_2037));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createLink_Infrastructure_VehicleConfiguration74CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(
				intelligentMobility.diagram.part.Messages.Link_Infrastructure_VehicleConfiguration74CreationTool_title,
				intelligentMobility.diagram.part.Messages.Link_Infrastructure_VehicleConfiguration74CreationTool_desc,
				Collections.singletonList(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Infrastructure_VehicleConfiguration_4035));
		entry.setId("createLink_Infrastructure_VehicleConfiguration74CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.getImageDescriptor(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Infrastructure_VehicleConfiguration_4035));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createLink_CommunicationInterface_VehicleConfiguration75CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(
				intelligentMobility.diagram.part.Messages.Link_CommunicationInterface_VehicleConfiguration75CreationTool_title,
				intelligentMobility.diagram.part.Messages.Link_CommunicationInterface_VehicleConfiguration75CreationTool_desc,
				Collections.singletonList(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_CommunicationInterface_VehicleConfiguration_4036));
		entry.setId("createLink_CommunicationInterface_VehicleConfiguration75CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.getImageDescriptor(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_CommunicationInterface_VehicleConfiguration_4036));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createLink_Goal_DrivingBehaviour76CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(
				intelligentMobility.diagram.part.Messages.Link_Goal_DrivingBehaviour76CreationTool_title,
				intelligentMobility.diagram.part.Messages.Link_Goal_DrivingBehaviour76CreationTool_desc,
				Collections.singletonList(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Goal_DrivingBehaviour_4037));
		entry.setId("createLink_Goal_DrivingBehaviour76CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.getImageDescriptor(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Goal_DrivingBehaviour_4037));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createLink_CooperativeBehaviour_CommunicationInterface77CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(
				intelligentMobility.diagram.part.Messages.Link_CooperativeBehaviour_CommunicationInterface77CreationTool_title,
				intelligentMobility.diagram.part.Messages.Link_CooperativeBehaviour_CommunicationInterface77CreationTool_desc,
				Collections.singletonList(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_CooperativeBehaviour_CommunicationInterface_4038));
		entry.setId("createLink_CooperativeBehaviour_CommunicationInterface77CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.getImageDescriptor(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_CooperativeBehaviour_CommunicationInterface_4038));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createLink_CommunicationInterface_Infrastructure78CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(
				intelligentMobility.diagram.part.Messages.Link_CommunicationInterface_Infrastructure78CreationTool_title,
				intelligentMobility.diagram.part.Messages.Link_CommunicationInterface_Infrastructure78CreationTool_desc,
				Collections.singletonList(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_CommunicationInterface_Infrastructure_4039));
		entry.setId("createLink_CommunicationInterface_Infrastructure78CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.getImageDescriptor(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_CommunicationInterface_Infrastructure_4039));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createLink_CooperativeBehaviour_VehicleConfiguration79CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(
				intelligentMobility.diagram.part.Messages.Link_CooperativeBehaviour_VehicleConfiguration79CreationTool_title,
				intelligentMobility.diagram.part.Messages.Link_CooperativeBehaviour_VehicleConfiguration79CreationTool_desc,
				Collections.singletonList(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_CooperativeBehaviour_VehicleConfiguration_4040));
		entry.setId("createLink_CooperativeBehaviour_VehicleConfiguration79CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.getImageDescriptor(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_CooperativeBehaviour_VehicleConfiguration_4040));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createAction80CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(
				intelligentMobility.diagram.part.Messages.Action80CreationTool_title,
				intelligentMobility.diagram.part.Messages.Action80CreationTool_desc, Collections.singletonList(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Action_2039));
		entry.setId("createAction80CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.getImageDescriptor(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Action_2039));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createLink_TrafficSituation_EnvironmentCondition81CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(
				intelligentMobility.diagram.part.Messages.Link_TrafficSituation_EnvironmentCondition81CreationTool_title,
				intelligentMobility.diagram.part.Messages.Link_TrafficSituation_EnvironmentCondition81CreationTool_desc,
				Collections.singletonList(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_TrafficSituation_EnvironmentCondition_4041));
		entry.setId("createLink_TrafficSituation_EnvironmentCondition81CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.getImageDescriptor(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_TrafficSituation_EnvironmentCondition_4041));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createLink_Collision_SpecialCondition82CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(
				intelligentMobility.diagram.part.Messages.Link_Collision_SpecialCondition82CreationTool_title,
				intelligentMobility.diagram.part.Messages.Link_Collision_SpecialCondition82CreationTool_desc,
				Collections.singletonList(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Collision_SpecialCondition_4042));
		entry.setId("createLink_Collision_SpecialCondition82CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.getImageDescriptor(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Collision_SpecialCondition_4042));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createLink_Following_LaneChanging83CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(
				intelligentMobility.diagram.part.Messages.Link_Following_LaneChanging83CreationTool_title,
				intelligentMobility.diagram.part.Messages.Link_Following_LaneChanging83CreationTool_desc,
				Collections.singletonList(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Following_LaneChanging_4043));
		entry.setId("createLink_Following_LaneChanging83CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.getImageDescriptor(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Following_LaneChanging_4043));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createLink_Action_Backward84CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(
				intelligentMobility.diagram.part.Messages.Link_Action_Backward84CreationTool_title,
				intelligentMobility.diagram.part.Messages.Link_Action_Backward84CreationTool_desc,
				Collections.singletonList(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Action_Backward_4044));
		entry.setId("createLink_Action_Backward84CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.getImageDescriptor(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Action_Backward_4044));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createLink_Action_Forward85CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(
				intelligentMobility.diagram.part.Messages.Link_Action_Forward85CreationTool_title,
				intelligentMobility.diagram.part.Messages.Link_Action_Forward85CreationTool_desc,
				Collections.singletonList(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Action_Forward_4045));
		entry.setId("createLink_Action_Forward85CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.getImageDescriptor(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Action_Forward_4045));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createLink_Action_Turn86CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(
				intelligentMobility.diagram.part.Messages.Link_Action_Turn86CreationTool_title,
				intelligentMobility.diagram.part.Messages.Link_Action_Turn86CreationTool_desc,
				Collections.singletonList(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Action_Turn_4046));
		entry.setId("createLink_Action_Turn86CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.getImageDescriptor(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Action_Turn_4046));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createLink_KnowledgeAndSkill_DriverPreference87CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(
				intelligentMobility.diagram.part.Messages.Link_KnowledgeAndSkill_DriverPreference87CreationTool_title,
				intelligentMobility.diagram.part.Messages.Link_KnowledgeAndSkill_DriverPreference87CreationTool_desc,
				Collections.singletonList(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_KnowledgeAndSkill_DriverPreference_4047));
		entry.setId("createLink_KnowledgeAndSkill_DriverPreference87CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.getImageDescriptor(
						intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_KnowledgeAndSkill_DriverPreference_4047));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

}
