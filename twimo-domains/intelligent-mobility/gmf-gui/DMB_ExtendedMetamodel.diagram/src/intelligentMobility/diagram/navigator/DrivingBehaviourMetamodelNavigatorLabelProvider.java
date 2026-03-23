package intelligentMobility.diagram.navigator;

import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.ITreePathLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.ViewerLabel;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonLabelProvider;

/**
 * @generated
 */
public class DrivingBehaviourMetamodelNavigatorLabelProvider extends LabelProvider
		implements ICommonLabelProvider, ITreePathLabelProvider {

	/**
	* @generated
	*/
	static {
		intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin.getInstance().getImageRegistry()
				.put("Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin.getInstance().getImageRegistry()
				.put("Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
	}

	/**
	* @generated
	*/
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorItem
				&& !isOwnView(((intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorItem) element)
						.getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	* @generated
	*/
	public Image getImage(Object element) {
		if (element instanceof intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup) {
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup group = (intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup) element;
			return intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin.getInstance()
					.getBundledImage(group.getIcon());
		}

		if (element instanceof intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorItem) {
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorItem navigatorItem = (intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return super.getImage(element);
			}
			return getImage(navigatorItem.getView());
		}

		return super.getImage(element);
	}

	/**
	* @generated
	*/
	public Image getImage(View view) {
		switch (intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getVisualID(view)) {
		case intelligentMobility.diagram.edit.parts.MobilitySystemEditPart.VISUAL_ID:
			return getImage("Navigator?Diagram?http://www.example.org/intelligentMobility?MobilitySystem", //$NON-NLS-1$
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.MobilitySystem_1000);
		case intelligentMobility.diagram.edit.parts.Special_ConditionEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.example.org/intelligentMobility?Special_Condition", //$NON-NLS-1$
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Special_Condition_2001);
		case intelligentMobility.diagram.edit.parts.WeatherEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.example.org/intelligentMobility?Weather", //$NON-NLS-1$
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Weather_2002);
		case intelligentMobility.diagram.edit.parts.Traffic_LightEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.example.org/intelligentMobility?Traffic_Light", //$NON-NLS-1$
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Traffic_Light_2003);
		case intelligentMobility.diagram.edit.parts.Knowledge_and_SkillEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.example.org/intelligentMobility?Knowledge_and_Skill", //$NON-NLS-1$
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Knowledge_and_Skill_2004);
		case intelligentMobility.diagram.edit.parts.ObstructionEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.example.org/intelligentMobility?Obstruction", //$NON-NLS-1$
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Obstruction_2005);
		case intelligentMobility.diagram.edit.parts.Driver_PreferenceEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.example.org/intelligentMobility?Driver_Preference", //$NON-NLS-1$
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Driver_Preference_2006);
		case intelligentMobility.diagram.edit.parts.IntersectionEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.example.org/intelligentMobility?Intersection", //$NON-NLS-1$
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Intersection_2007);
		case intelligentMobility.diagram.edit.parts.Vehicle_ConfigurationEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.example.org/intelligentMobility?Vehicle_Configuration", //$NON-NLS-1$
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Vehicle_Configuration_2008);
		case intelligentMobility.diagram.edit.parts.Environment_ConditionEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.example.org/intelligentMobility?Environment_Condition", //$NON-NLS-1$
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Environment_Condition_2009);
		case intelligentMobility.diagram.edit.parts.PlatoonEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.example.org/intelligentMobility?Platoon", //$NON-NLS-1$
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Platoon_2010);
		case intelligentMobility.diagram.edit.parts.ForwardEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.example.org/intelligentMobility?Forward", //$NON-NLS-1$
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Forward_2011);
		case intelligentMobility.diagram.edit.parts.Lane_TypeEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.example.org/intelligentMobility?Lane_Type", //$NON-NLS-1$
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Lane_Type_2012);
		case intelligentMobility.diagram.edit.parts.Environment_BackgroundEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.example.org/intelligentMobility?Environment_Background", //$NON-NLS-1$
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Environment_Background_2013);
		case intelligentMobility.diagram.edit.parts.TurnEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.example.org/intelligentMobility?Turn", //$NON-NLS-1$
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Turn_2014);
		case intelligentMobility.diagram.edit.parts.LaneChangingEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.example.org/intelligentMobility?LaneChanging", //$NON-NLS-1$
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.LaneChanging_2015);
		case intelligentMobility.diagram.edit.parts.Driver_EmotionEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.example.org/intelligentMobility?Driver_Emotion", //$NON-NLS-1$
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Driver_Emotion_2016);
		case intelligentMobility.diagram.edit.parts.CollisionEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.example.org/intelligentMobility?Collision", //$NON-NLS-1$
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Collision_2017);
		case intelligentMobility.diagram.edit.parts.PossibleVehicleEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.example.org/intelligentMobility?PossibleVehicle", //$NON-NLS-1$
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.PossibleVehicle_2018);
		case intelligentMobility.diagram.edit.parts.FollowingEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.example.org/intelligentMobility?Following", //$NON-NLS-1$
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Following_2019);
		case intelligentMobility.diagram.edit.parts.GapAcceptanceEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.example.org/intelligentMobility?GapAcceptance", //$NON-NLS-1$
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.GapAcceptance_2020);
		case intelligentMobility.diagram.edit.parts.Leading_VehicleEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.example.org/intelligentMobility?Leading_Vehicle", //$NON-NLS-1$
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Leading_Vehicle_2021);
		case intelligentMobility.diagram.edit.parts.BackwardEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.example.org/intelligentMobility?Backward", //$NON-NLS-1$
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Backward_2022);
		case intelligentMobility.diagram.edit.parts.RegulationEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.example.org/intelligentMobility?Regulation", //$NON-NLS-1$
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Regulation_2023);
		case intelligentMobility.diagram.edit.parts.Traffic_SituationEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.example.org/intelligentMobility?Traffic_Situation", //$NON-NLS-1$
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Traffic_Situation_2024);
		case intelligentMobility.diagram.edit.parts.Driver_ProfileEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.example.org/intelligentMobility?Driver_Profile", //$NON-NLS-1$
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Driver_Profile_2025);
		case intelligentMobility.diagram.edit.parts.Safety_RequirementEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.example.org/intelligentMobility?Safety_Requirement", //$NON-NLS-1$
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Safety_Requirement_2026);
		case intelligentMobility.diagram.edit.parts.Driving_BehaviourEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.example.org/intelligentMobility?Driving_Behaviour", //$NON-NLS-1$
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Driving_Behaviour_2027);
		case intelligentMobility.diagram.edit.parts.Following_VehicleEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.example.org/intelligentMobility?Following_Vehicle", //$NON-NLS-1$
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Following_Vehicle_2028);
		case intelligentMobility.diagram.edit.parts.Abnormal_BehaviourEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.example.org/intelligentMobility?Abnormal_Behaviour", //$NON-NLS-1$
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Abnormal_Behaviour_2029);
		case intelligentMobility.diagram.edit.parts.Backward2EditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.example.org/intelligentMobility?Backward", //$NON-NLS-1$
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Backward_2030);
		case intelligentMobility.diagram.edit.parts.Intersection2EditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.example.org/intelligentMobility?Intersection", //$NON-NLS-1$
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Intersection_2031);
		case intelligentMobility.diagram.edit.parts.CommunicationInterfaceEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.example.org/intelligentMobility?CommunicationInterface", //$NON-NLS-1$
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.CommunicationInterface_2032);
		case intelligentMobility.diagram.edit.parts.GoalEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.example.org/intelligentMobility?Goal", //$NON-NLS-1$
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Goal_2033);
		case intelligentMobility.diagram.edit.parts.Normal_BehaviourEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.example.org/intelligentMobility?Normal_Behaviour", //$NON-NLS-1$
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Normal_Behaviour_2034);
		case intelligentMobility.diagram.edit.parts.Platoon2EditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.example.org/intelligentMobility?Platoon", //$NON-NLS-1$
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Platoon_2035);
		case intelligentMobility.diagram.edit.parts.Normal_VehicleEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.example.org/intelligentMobility?Normal_Vehicle", //$NON-NLS-1$
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Normal_Vehicle_2036);
		case intelligentMobility.diagram.edit.parts.CooperativeBehaviorEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.example.org/intelligentMobility?CooperativeBehavior", //$NON-NLS-1$
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.CooperativeBehavior_2037);
		case intelligentMobility.diagram.edit.parts.ActionEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.example.org/intelligentMobility?Action", //$NON-NLS-1$
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Action_2039);
		case intelligentMobility.diagram.edit.parts.Link_LaneType_RegulationEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.example.org/intelligentMobility?Link_LaneType_Regulation", //$NON-NLS-1$
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_LaneType_Regulation_4001);
		case intelligentMobility.diagram.edit.parts.Link_Driver_VehicleEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.example.org/intelligentMobility?Link_Driver_Vehicle", //$NON-NLS-1$
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Driver_Vehicle_4002);
		case intelligentMobility.diagram.edit.parts.Link_EnvironmentBackground_PossibleVehicleEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://www.example.org/intelligentMobility?Link_EnvironmentBackground_PossibleVehicle", //$NON-NLS-1$
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_EnvironmentBackground_PossibleVehicle_4003);
		case intelligentMobility.diagram.edit.parts.Link_Vehicle_EnvironmentEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.example.org/intelligentMobility?Link_Vehicle_Environment", //$NON-NLS-1$
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Vehicle_Environment_4004);
		case intelligentMobility.diagram.edit.parts.Link_NormalVehicle_SafetyRequirementsEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://www.example.org/intelligentMobility?Link_NormalVehicle_SafetyRequirements", //$NON-NLS-1$
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_NormalVehicle_SafetyRequirements_4005);
		case intelligentMobility.diagram.edit.parts.Link_DriverProfile_DriverPreferenceEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://www.example.org/intelligentMobility?Link_DriverProfile_DriverPreference", //$NON-NLS-1$
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_DriverProfile_DriverPreference_4006);
		case intelligentMobility.diagram.edit.parts.Link_Collision_ObstructionEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.example.org/intelligentMobility?Link_Collision_Obstruction", //$NON-NLS-1$
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Collision_Obstruction_4007);
		case intelligentMobility.diagram.edit.parts.Link_Platoon_FollowingVehicleEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.example.org/intelligentMobility?Link_Platoon_FollowingVehicle", //$NON-NLS-1$
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Platoon_FollowingVehicle_4008);
		case intelligentMobility.diagram.edit.parts.Link_DriverPreference_EnvironmentConditionEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://www.example.org/intelligentMobility?Link_DriverPreference_EnvironmentCondition", //$NON-NLS-1$
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_DriverPreference_EnvironmentCondition_4009);
		case intelligentMobility.diagram.edit.parts.Link_AbnormalBehaviour_ActionEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.example.org/intelligentMobility?Link_AbnormalBehaviour_Action", //$NON-NLS-1$
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_AbnormalBehaviour_Action_4010);
		case intelligentMobility.diagram.edit.parts.Link_Following_ForwardEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.example.org/intelligentMobility?Link_Following_Forward", //$NON-NLS-1$
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Following_Forward_4011);
		case intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_LaneTypeEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://www.example.org/intelligentMobility?Link_EnvironmentCondition_LaneType", //$NON-NLS-1$
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_EnvironmentCondition_LaneType_4012);
		case intelligentMobility.diagram.edit.parts.Link_VehicleConfiguration_VehicleTypeEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://www.example.org/intelligentMobility?Link_VehicleConfiguration_VehicleType", //$NON-NLS-1$
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_VehicleConfiguration_VehicleType_4013);
		case intelligentMobility.diagram.edit.parts.Link_Platoon_LeadingVehicleEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.example.org/intelligentMobility?Link_Platoon_LeadingVehicle", //$NON-NLS-1$
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Platoon_LeadingVehicle_4014);
		case intelligentMobility.diagram.edit.parts.Link_Driver_EnvironmentEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.example.org/intelligentMobility?Link_Driver_Environment", //$NON-NLS-1$
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Driver_Environment_4015);
		case intelligentMobility.diagram.edit.parts.Link_LaneChanging_TurnEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.example.org/intelligentMobility?Link_LaneChanging_Turn", //$NON-NLS-1$
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_LaneChanging_Turn_4016);
		case intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_TrafficConditionEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://www.example.org/intelligentMobility?Link_EnvironmentCondition_TrafficCondition", //$NON-NLS-1$
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_EnvironmentCondition_TrafficCondition_4017);
		case intelligentMobility.diagram.edit.parts.Link_Intersection_TrafficLightEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.example.org/intelligentMobility?Link_Intersection_TrafficLight", //$NON-NLS-1$
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Intersection_TrafficLight_4018);
		case intelligentMobility.diagram.edit.parts.Link_Following_MinGapEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.example.org/intelligentMobility?Link_Following_MinGap", //$NON-NLS-1$
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Following_MinGap_4019);
		case intelligentMobility.diagram.edit.parts.Link_NormalBehaviour_LaneChangingEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://www.example.org/intelligentMobility?Link_NormalBehaviour_LaneChanging", //$NON-NLS-1$
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_NormalBehaviour_LaneChanging_4020);
		case intelligentMobility.diagram.edit.parts.Link_SafetyRequirement_RegulationEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://www.example.org/intelligentMobility?Link_SafetyRequirement_Regulation", //$NON-NLS-1$
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_SafetyRequirement_Regulation_4021);
		case intelligentMobility.diagram.edit.parts.Link_DriverPreference_DrivingBehaviourEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://www.example.org/intelligentMobility?Link_DriverPreference_DrivingBehaviour", //$NON-NLS-1$
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_DriverPreference_DrivingBehaviour_4022);
		case intelligentMobility.diagram.edit.parts.Link_FollowingVehicle_FrontVehicleEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://www.example.org/intelligentMobility?Link_FollowingVehicle_FrontVehicle", //$NON-NLS-1$
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_FollowingVehicle_FrontVehicle_4023);
		case intelligentMobility.diagram.edit.parts.Link_DriverPreference_DriverEmotionEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://www.example.org/intelligentMobility?Link_DriverPreference_DriverEmotion", //$NON-NLS-1$
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_DriverPreference_DriverEmotion_4024);
		case intelligentMobility.diagram.edit.parts.Link_EnvironmentBackground_EnvironmentConditionEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://www.example.org/intelligentMobility?Link_EnvironmentBackground_EnvironmentCondition", //$NON-NLS-1$
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_EnvironmentBackground_EnvironmentCondition_4025);
		case intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_WeatherEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://www.example.org/intelligentMobility?Link_EnvironmentCondition_Weather", //$NON-NLS-1$
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_EnvironmentCondition_Weather_4026);
		case intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_SpecialConditionEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://www.example.org/intelligentMobility?Link_EnvironmentCondition_SpecialCondition", //$NON-NLS-1$
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_EnvironmentCondition_SpecialCondition_4027);
		case intelligentMobility.diagram.edit.parts.Link_SpecialCondition_IntersectionEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://www.example.org/intelligentMobility?Link_SpecialCondition_Intersection", //$NON-NLS-1$
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_SpecialCondition_Intersection_4028);
		case intelligentMobility.diagram.edit.parts.Link_Following_BackwardEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.example.org/intelligentMobility?Link_Following_Backward", //$NON-NLS-1$
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Following_Backward_4029);
		case intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_RegulationsEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://www.example.org/intelligentMobility?Link_EnvironmentCondition_Regulations", //$NON-NLS-1$
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_EnvironmentCondition_Regulations_4030);
		case intelligentMobility.diagram.edit.parts.Link_DrivingBehaviour_NormalBehaviourEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://www.example.org/intelligentMobility?Link_DrivingBehaviour_NormalBehaviour", //$NON-NLS-1$
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_DrivingBehaviour_NormalBehaviour_4031);
		case intelligentMobility.diagram.edit.parts.Link_LaneChanging_EnvironmentConditionEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://www.example.org/intelligentMobility?Link_LaneChanging_EnvironmentCondition", //$NON-NLS-1$
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_LaneChanging_EnvironmentCondition_4032);
		case intelligentMobility.diagram.edit.parts.Link_LaneChanging_GapAcceptanceEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.example.org/intelligentMobility?Link_LaneChanging_GapAcceptance", //$NON-NLS-1$
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_LaneChanging_GapAcceptance_4033);
		case intelligentMobility.diagram.edit.parts.Link_NormalBehaviour_FollowingEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.example.org/intelligentMobility?Link_NormalBehaviour_Following", //$NON-NLS-1$
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_NormalBehaviour_Following_4034);
		case intelligentMobility.diagram.edit.parts.Link_Infrastructure_VehicleConfigurationEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://www.example.org/intelligentMobility?Link_Infrastructure_VehicleConfiguration", //$NON-NLS-1$
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Infrastructure_VehicleConfiguration_4035);
		case intelligentMobility.diagram.edit.parts.Link_CommunicationInterface_VehicleConfigurationEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://www.example.org/intelligentMobility?Link_CommunicationInterface_VehicleConfiguration", //$NON-NLS-1$
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_CommunicationInterface_VehicleConfiguration_4036);
		case intelligentMobility.diagram.edit.parts.Link_Goal_DrivingBehaviourEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.example.org/intelligentMobility?Link_Goal_DrivingBehaviour", //$NON-NLS-1$
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Goal_DrivingBehaviour_4037);
		case intelligentMobility.diagram.edit.parts.Link_CooperativeBehaviour_CommunicationInterfaceEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://www.example.org/intelligentMobility?Link_CooperativeBehaviour_CommunicationInterface", //$NON-NLS-1$
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_CooperativeBehaviour_CommunicationInterface_4038);
		case intelligentMobility.diagram.edit.parts.Link_CommunicationInterface_InfrastructureEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://www.example.org/intelligentMobility?Link_CommunicationInterface_Infrastructure", //$NON-NLS-1$
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_CommunicationInterface_Infrastructure_4039);
		case intelligentMobility.diagram.edit.parts.Link_CooperativeBehaviour_VehicleConfigurationEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://www.example.org/intelligentMobility?Link_CooperativeBehaviour_VehicleConfiguration", //$NON-NLS-1$
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_CooperativeBehaviour_VehicleConfiguration_4040);
		case intelligentMobility.diagram.edit.parts.Link_TrafficSituation_EnvironmentConditionEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://www.example.org/intelligentMobility?Link_TrafficSituation_EnvironmentCondition", //$NON-NLS-1$
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_TrafficSituation_EnvironmentCondition_4041);
		case intelligentMobility.diagram.edit.parts.Link_Collision_SpecialConditionEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.example.org/intelligentMobility?Link_Collision_SpecialCondition", //$NON-NLS-1$
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Collision_SpecialCondition_4042);
		case intelligentMobility.diagram.edit.parts.Link_Following_LaneChangingEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.example.org/intelligentMobility?Link_Following_LaneChanging", //$NON-NLS-1$
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Following_LaneChanging_4043);
		case intelligentMobility.diagram.edit.parts.Link_Action_BackwardEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.example.org/intelligentMobility?Link_Action_Backward", //$NON-NLS-1$
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Action_Backward_4044);
		case intelligentMobility.diagram.edit.parts.Link_Action_ForwardEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.example.org/intelligentMobility?Link_Action_Forward", //$NON-NLS-1$
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Action_Forward_4045);
		case intelligentMobility.diagram.edit.parts.Link_Action_TurnEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.example.org/intelligentMobility?Link_Action_Turn", //$NON-NLS-1$
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Action_Turn_4046);
		case intelligentMobility.diagram.edit.parts.Link_KnowledgeAndSkill_DriverPreferenceEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://www.example.org/intelligentMobility?Link_KnowledgeAndSkill_DriverPreference", //$NON-NLS-1$
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_KnowledgeAndSkill_DriverPreference_4047);
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	* @generated
	*/
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin
				.getInstance().getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null && elementType != null
				&& intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes
						.isKnownElementType(elementType)) {
			image = intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.getImage(elementType);
			imageRegistry.put(key, image);
		}

		if (image == null) {
			image = imageRegistry.get("Navigator?ImageNotFound"); //$NON-NLS-1$
			imageRegistry.put(key, image);
		}
		return image;
	}

	/**
	* @generated
	*/
	public String getText(Object element) {
		if (element instanceof intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup) {
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup group = (intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorItem) {
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorItem navigatorItem = (intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return null;
			}
			return getText(navigatorItem.getView());
		}

		return super.getText(element);
	}

	/**
	* @generated
	*/
	public String getText(View view) {
		if (view.getElement() != null && view.getElement().eIsProxy()) {
			return getUnresolvedDomainElementProxyText(view);
		}
		switch (intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getVisualID(view)) {
		case intelligentMobility.diagram.edit.parts.MobilitySystemEditPart.VISUAL_ID:
			return getMobilitySystem_1000Text(view);
		case intelligentMobility.diagram.edit.parts.Special_ConditionEditPart.VISUAL_ID:
			return getSpecial_Condition_2001Text(view);
		case intelligentMobility.diagram.edit.parts.WeatherEditPart.VISUAL_ID:
			return getWeather_2002Text(view);
		case intelligentMobility.diagram.edit.parts.Traffic_LightEditPart.VISUAL_ID:
			return getTraffic_Light_2003Text(view);
		case intelligentMobility.diagram.edit.parts.Knowledge_and_SkillEditPart.VISUAL_ID:
			return getKnowledge_and_Skill_2004Text(view);
		case intelligentMobility.diagram.edit.parts.ObstructionEditPart.VISUAL_ID:
			return getObstruction_2005Text(view);
		case intelligentMobility.diagram.edit.parts.Driver_PreferenceEditPart.VISUAL_ID:
			return getDriver_Preference_2006Text(view);
		case intelligentMobility.diagram.edit.parts.IntersectionEditPart.VISUAL_ID:
			return getIntersection_2007Text(view);
		case intelligentMobility.diagram.edit.parts.Vehicle_ConfigurationEditPart.VISUAL_ID:
			return getVehicle_Configuration_2008Text(view);
		case intelligentMobility.diagram.edit.parts.Environment_ConditionEditPart.VISUAL_ID:
			return getEnvironment_Condition_2009Text(view);
		case intelligentMobility.diagram.edit.parts.PlatoonEditPart.VISUAL_ID:
			return getPlatoon_2010Text(view);
		case intelligentMobility.diagram.edit.parts.ForwardEditPart.VISUAL_ID:
			return getForward_2011Text(view);
		case intelligentMobility.diagram.edit.parts.Lane_TypeEditPart.VISUAL_ID:
			return getLane_Type_2012Text(view);
		case intelligentMobility.diagram.edit.parts.Environment_BackgroundEditPart.VISUAL_ID:
			return getEnvironment_Background_2013Text(view);
		case intelligentMobility.diagram.edit.parts.TurnEditPart.VISUAL_ID:
			return getTurn_2014Text(view);
		case intelligentMobility.diagram.edit.parts.LaneChangingEditPart.VISUAL_ID:
			return getLaneChanging_2015Text(view);
		case intelligentMobility.diagram.edit.parts.Driver_EmotionEditPart.VISUAL_ID:
			return getDriver_Emotion_2016Text(view);
		case intelligentMobility.diagram.edit.parts.CollisionEditPart.VISUAL_ID:
			return getCollision_2017Text(view);
		case intelligentMobility.diagram.edit.parts.PossibleVehicleEditPart.VISUAL_ID:
			return getPossibleVehicle_2018Text(view);
		case intelligentMobility.diagram.edit.parts.FollowingEditPart.VISUAL_ID:
			return getFollowing_2019Text(view);
		case intelligentMobility.diagram.edit.parts.GapAcceptanceEditPart.VISUAL_ID:
			return getGapAcceptance_2020Text(view);
		case intelligentMobility.diagram.edit.parts.Leading_VehicleEditPart.VISUAL_ID:
			return getLeading_Vehicle_2021Text(view);
		case intelligentMobility.diagram.edit.parts.BackwardEditPart.VISUAL_ID:
			return getBackward_2022Text(view);
		case intelligentMobility.diagram.edit.parts.RegulationEditPart.VISUAL_ID:
			return getRegulation_2023Text(view);
		case intelligentMobility.diagram.edit.parts.Traffic_SituationEditPart.VISUAL_ID:
			return getTraffic_Situation_2024Text(view);
		case intelligentMobility.diagram.edit.parts.Driver_ProfileEditPart.VISUAL_ID:
			return getDriver_Profile_2025Text(view);
		case intelligentMobility.diagram.edit.parts.Safety_RequirementEditPart.VISUAL_ID:
			return getSafety_Requirement_2026Text(view);
		case intelligentMobility.diagram.edit.parts.Driving_BehaviourEditPart.VISUAL_ID:
			return getDriving_Behaviour_2027Text(view);
		case intelligentMobility.diagram.edit.parts.Following_VehicleEditPart.VISUAL_ID:
			return getFollowing_Vehicle_2028Text(view);
		case intelligentMobility.diagram.edit.parts.Abnormal_BehaviourEditPart.VISUAL_ID:
			return getAbnormal_Behaviour_2029Text(view);
		case intelligentMobility.diagram.edit.parts.Backward2EditPart.VISUAL_ID:
			return getBackward_2030Text(view);
		case intelligentMobility.diagram.edit.parts.Intersection2EditPart.VISUAL_ID:
			return getIntersection_2031Text(view);
		case intelligentMobility.diagram.edit.parts.CommunicationInterfaceEditPart.VISUAL_ID:
			return getCommunicationInterface_2032Text(view);
		case intelligentMobility.diagram.edit.parts.GoalEditPart.VISUAL_ID:
			return getGoal_2033Text(view);
		case intelligentMobility.diagram.edit.parts.Normal_BehaviourEditPart.VISUAL_ID:
			return getNormal_Behaviour_2034Text(view);
		case intelligentMobility.diagram.edit.parts.Platoon2EditPart.VISUAL_ID:
			return getPlatoon_2035Text(view);
		case intelligentMobility.diagram.edit.parts.Normal_VehicleEditPart.VISUAL_ID:
			return getNormal_Vehicle_2036Text(view);
		case intelligentMobility.diagram.edit.parts.CooperativeBehaviorEditPart.VISUAL_ID:
			return getCooperativeBehavior_2037Text(view);
		case intelligentMobility.diagram.edit.parts.ActionEditPart.VISUAL_ID:
			return getAction_2039Text(view);
		case intelligentMobility.diagram.edit.parts.Link_LaneType_RegulationEditPart.VISUAL_ID:
			return getLink_LaneType_Regulation_4001Text(view);
		case intelligentMobility.diagram.edit.parts.Link_Driver_VehicleEditPart.VISUAL_ID:
			return getLink_Driver_Vehicle_4002Text(view);
		case intelligentMobility.diagram.edit.parts.Link_EnvironmentBackground_PossibleVehicleEditPart.VISUAL_ID:
			return getLink_EnvironmentBackground_PossibleVehicle_4003Text(view);
		case intelligentMobility.diagram.edit.parts.Link_Vehicle_EnvironmentEditPart.VISUAL_ID:
			return getLink_Vehicle_Environment_4004Text(view);
		case intelligentMobility.diagram.edit.parts.Link_NormalVehicle_SafetyRequirementsEditPart.VISUAL_ID:
			return getLink_NormalVehicle_SafetyRequirements_4005Text(view);
		case intelligentMobility.diagram.edit.parts.Link_DriverProfile_DriverPreferenceEditPart.VISUAL_ID:
			return getLink_DriverProfile_DriverPreference_4006Text(view);
		case intelligentMobility.diagram.edit.parts.Link_Collision_ObstructionEditPart.VISUAL_ID:
			return getLink_Collision_Obstruction_4007Text(view);
		case intelligentMobility.diagram.edit.parts.Link_Platoon_FollowingVehicleEditPart.VISUAL_ID:
			return getLink_Platoon_FollowingVehicle_4008Text(view);
		case intelligentMobility.diagram.edit.parts.Link_DriverPreference_EnvironmentConditionEditPart.VISUAL_ID:
			return getLink_DriverPreference_EnvironmentCondition_4009Text(view);
		case intelligentMobility.diagram.edit.parts.Link_AbnormalBehaviour_ActionEditPart.VISUAL_ID:
			return getLink_AbnormalBehaviour_Action_4010Text(view);
		case intelligentMobility.diagram.edit.parts.Link_Following_ForwardEditPart.VISUAL_ID:
			return getLink_Following_Forward_4011Text(view);
		case intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_LaneTypeEditPart.VISUAL_ID:
			return getLink_EnvironmentCondition_LaneType_4012Text(view);
		case intelligentMobility.diagram.edit.parts.Link_VehicleConfiguration_VehicleTypeEditPart.VISUAL_ID:
			return getLink_VehicleConfiguration_VehicleType_4013Text(view);
		case intelligentMobility.diagram.edit.parts.Link_Platoon_LeadingVehicleEditPart.VISUAL_ID:
			return getLink_Platoon_LeadingVehicle_4014Text(view);
		case intelligentMobility.diagram.edit.parts.Link_Driver_EnvironmentEditPart.VISUAL_ID:
			return getLink_Driver_Environment_4015Text(view);
		case intelligentMobility.diagram.edit.parts.Link_LaneChanging_TurnEditPart.VISUAL_ID:
			return getLink_LaneChanging_Turn_4016Text(view);
		case intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_TrafficConditionEditPart.VISUAL_ID:
			return getLink_EnvironmentCondition_TrafficCondition_4017Text(view);
		case intelligentMobility.diagram.edit.parts.Link_Intersection_TrafficLightEditPart.VISUAL_ID:
			return getLink_Intersection_TrafficLight_4018Text(view);
		case intelligentMobility.diagram.edit.parts.Link_Following_MinGapEditPart.VISUAL_ID:
			return getLink_Following_MinGap_4019Text(view);
		case intelligentMobility.diagram.edit.parts.Link_NormalBehaviour_LaneChangingEditPart.VISUAL_ID:
			return getLink_NormalBehaviour_LaneChanging_4020Text(view);
		case intelligentMobility.diagram.edit.parts.Link_SafetyRequirement_RegulationEditPart.VISUAL_ID:
			return getLink_SafetyRequirement_Regulation_4021Text(view);
		case intelligentMobility.diagram.edit.parts.Link_DriverPreference_DrivingBehaviourEditPart.VISUAL_ID:
			return getLink_DriverPreference_DrivingBehaviour_4022Text(view);
		case intelligentMobility.diagram.edit.parts.Link_FollowingVehicle_FrontVehicleEditPart.VISUAL_ID:
			return getLink_FollowingVehicle_FrontVehicle_4023Text(view);
		case intelligentMobility.diagram.edit.parts.Link_DriverPreference_DriverEmotionEditPart.VISUAL_ID:
			return getLink_DriverPreference_DriverEmotion_4024Text(view);
		case intelligentMobility.diagram.edit.parts.Link_EnvironmentBackground_EnvironmentConditionEditPart.VISUAL_ID:
			return getLink_EnvironmentBackground_EnvironmentCondition_4025Text(view);
		case intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_WeatherEditPart.VISUAL_ID:
			return getLink_EnvironmentCondition_Weather_4026Text(view);
		case intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_SpecialConditionEditPart.VISUAL_ID:
			return getLink_EnvironmentCondition_SpecialCondition_4027Text(view);
		case intelligentMobility.diagram.edit.parts.Link_SpecialCondition_IntersectionEditPart.VISUAL_ID:
			return getLink_SpecialCondition_Intersection_4028Text(view);
		case intelligentMobility.diagram.edit.parts.Link_Following_BackwardEditPart.VISUAL_ID:
			return getLink_Following_Backward_4029Text(view);
		case intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_RegulationsEditPart.VISUAL_ID:
			return getLink_EnvironmentCondition_Regulations_4030Text(view);
		case intelligentMobility.diagram.edit.parts.Link_DrivingBehaviour_NormalBehaviourEditPart.VISUAL_ID:
			return getLink_DrivingBehaviour_NormalBehaviour_4031Text(view);
		case intelligentMobility.diagram.edit.parts.Link_LaneChanging_EnvironmentConditionEditPart.VISUAL_ID:
			return getLink_LaneChanging_EnvironmentCondition_4032Text(view);
		case intelligentMobility.diagram.edit.parts.Link_LaneChanging_GapAcceptanceEditPart.VISUAL_ID:
			return getLink_LaneChanging_GapAcceptance_4033Text(view);
		case intelligentMobility.diagram.edit.parts.Link_NormalBehaviour_FollowingEditPart.VISUAL_ID:
			return getLink_NormalBehaviour_Following_4034Text(view);
		case intelligentMobility.diagram.edit.parts.Link_Infrastructure_VehicleConfigurationEditPart.VISUAL_ID:
			return getLink_Infrastructure_VehicleConfiguration_4035Text(view);
		case intelligentMobility.diagram.edit.parts.Link_CommunicationInterface_VehicleConfigurationEditPart.VISUAL_ID:
			return getLink_CommunicationInterface_VehicleConfiguration_4036Text(view);
		case intelligentMobility.diagram.edit.parts.Link_Goal_DrivingBehaviourEditPart.VISUAL_ID:
			return getLink_Goal_DrivingBehaviour_4037Text(view);
		case intelligentMobility.diagram.edit.parts.Link_CooperativeBehaviour_CommunicationInterfaceEditPart.VISUAL_ID:
			return getLink_CooperativeBehaviour_CommunicationInterface_4038Text(view);
		case intelligentMobility.diagram.edit.parts.Link_CommunicationInterface_InfrastructureEditPart.VISUAL_ID:
			return getLink_CommunicationInterface_Infrastructure_4039Text(view);
		case intelligentMobility.diagram.edit.parts.Link_CooperativeBehaviour_VehicleConfigurationEditPart.VISUAL_ID:
			return getLink_CooperativeBehaviour_VehicleConfiguration_4040Text(view);
		case intelligentMobility.diagram.edit.parts.Link_TrafficSituation_EnvironmentConditionEditPart.VISUAL_ID:
			return getLink_TrafficSituation_EnvironmentCondition_4041Text(view);
		case intelligentMobility.diagram.edit.parts.Link_Collision_SpecialConditionEditPart.VISUAL_ID:
			return getLink_Collision_SpecialCondition_4042Text(view);
		case intelligentMobility.diagram.edit.parts.Link_Following_LaneChangingEditPart.VISUAL_ID:
			return getLink_Following_LaneChanging_4043Text(view);
		case intelligentMobility.diagram.edit.parts.Link_Action_BackwardEditPart.VISUAL_ID:
			return getLink_Action_Backward_4044Text(view);
		case intelligentMobility.diagram.edit.parts.Link_Action_ForwardEditPart.VISUAL_ID:
			return getLink_Action_Forward_4045Text(view);
		case intelligentMobility.diagram.edit.parts.Link_Action_TurnEditPart.VISUAL_ID:
			return getLink_Action_Turn_4046Text(view);
		case intelligentMobility.diagram.edit.parts.Link_KnowledgeAndSkill_DriverPreferenceEditPart.VISUAL_ID:
			return getLink_KnowledgeAndSkill_DriverPreference_4047Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	* @generated
	*/
	private String getMobilitySystem_1000Text(View view) {
		intelligentMobility.MobilitySystem domainModelElement = (intelligentMobility.MobilitySystem) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.getSystemID());
		} else {
			intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin.getInstance()
					.logError("No domain element for view with visualID = " + 1000); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getSpecial_Condition_2001Text(View view) {
		IParser parser = intelligentMobility.diagram.providers.DrivingBehaviourMetamodelParserProvider.getParser(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Special_Condition_2001,
				view.getElement() != null ? view.getElement() : view,
				intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
						intelligentMobility.diagram.edit.parts.Special_ConditionConditionNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label " + 5001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getWeather_2002Text(View view) {
		IParser parser = intelligentMobility.diagram.providers.DrivingBehaviourMetamodelParserProvider.getParser(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Weather_2002,
				view.getElement() != null ? view.getElement() : view,
				intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
						.getType(intelligentMobility.diagram.edit.parts.WeatherWeatherTypeEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label " + 5002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getTraffic_Light_2003Text(View view) {
		IParser parser = intelligentMobility.diagram.providers.DrivingBehaviourMetamodelParserProvider.getParser(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Traffic_Light_2003,
				view.getElement() != null ? view.getElement() : view,
				intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
						.getType(intelligentMobility.diagram.edit.parts.Traffic_LightNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label " + 5031); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getKnowledge_and_Skill_2004Text(View view) {
		IParser parser = intelligentMobility.diagram.providers.DrivingBehaviourMetamodelParserProvider.getParser(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Knowledge_and_Skill_2004,
				view.getElement() != null ? view.getElement() : view,
				intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
						.getType(intelligentMobility.diagram.edit.parts.Knowledge_and_SkillNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label " + 5003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getObstruction_2005Text(View view) {
		IParser parser = intelligentMobility.diagram.providers.DrivingBehaviourMetamodelParserProvider.getParser(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Obstruction_2005,
				view.getElement() != null ? view.getElement() : view,
				intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
						.getType(intelligentMobility.diagram.edit.parts.ObstructionNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label " + 5004); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getDriver_Preference_2006Text(View view) {
		IParser parser = intelligentMobility.diagram.providers.DrivingBehaviourMetamodelParserProvider.getParser(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Driver_Preference_2006,
				view.getElement() != null ? view.getElement() : view,
				intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
						intelligentMobility.diagram.edit.parts.Driver_PreferenceName_PreferenceSetEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label " + 5005); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getIntersection_2007Text(View view) {
		IParser parser = intelligentMobility.diagram.providers.DrivingBehaviourMetamodelParserProvider.getParser(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Intersection_2007,
				view.getElement() != null ? view.getElement() : view,
				intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
						.getType(intelligentMobility.diagram.edit.parts.IntersectionNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label " + 5006); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getVehicle_Configuration_2008Text(View view) {
		IParser parser = intelligentMobility.diagram.providers.DrivingBehaviourMetamodelParserProvider.getParser(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Vehicle_Configuration_2008,
				view.getElement() != null ? view.getElement() : view,
				intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
						intelligentMobility.diagram.edit.parts.Vehicle_ConfigurationBrandNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label " + 5007); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getEnvironment_Condition_2009Text(View view) {
		IParser parser = intelligentMobility.diagram.providers.DrivingBehaviourMetamodelParserProvider.getParser(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Environment_Condition_2009,
				view.getElement() != null ? view.getElement() : view,
				intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
						intelligentMobility.diagram.edit.parts.Environment_ConditionName_EnvironmentConditiEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label " + 5008); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getPlatoon_2010Text(View view) {
		IParser parser = intelligentMobility.diagram.providers.DrivingBehaviourMetamodelParserProvider.getParser(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Platoon_2010,
				view.getElement() != null ? view.getElement() : view,
				intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
						.getType(intelligentMobility.diagram.edit.parts.PlatoonNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label " + 5009); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getForward_2011Text(View view) {
		IParser parser = intelligentMobility.diagram.providers.DrivingBehaviourMetamodelParserProvider.getParser(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Forward_2011,
				view.getElement() != null ? view.getElement() : view,
				intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
						.getType(intelligentMobility.diagram.edit.parts.ForwardNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label " + 5010); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getLane_Type_2012Text(View view) {
		IParser parser = intelligentMobility.diagram.providers.DrivingBehaviourMetamodelParserProvider.getParser(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Lane_Type_2012,
				view.getElement() != null ? view.getElement() : view,
				intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
						.getType(intelligentMobility.diagram.edit.parts.Lane_TypeNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label " + 5011); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getEnvironment_Background_2013Text(View view) {
		IParser parser = intelligentMobility.diagram.providers.DrivingBehaviourMetamodelParserProvider.getParser(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Environment_Background_2013,
				view.getElement() != null ? view.getElement() : view,
				intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
						.getType(intelligentMobility.diagram.edit.parts.Environment_BackgroundNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label " + 5012); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getTurn_2014Text(View view) {
		IParser parser = intelligentMobility.diagram.providers.DrivingBehaviourMetamodelParserProvider.getParser(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Turn_2014,
				view.getElement() != null ? view.getElement() : view,
				intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
						.getType(intelligentMobility.diagram.edit.parts.TurnNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label " + 5028); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getLaneChanging_2015Text(View view) {
		IParser parser = intelligentMobility.diagram.providers.DrivingBehaviourMetamodelParserProvider.getParser(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.LaneChanging_2015,
				view.getElement() != null ? view.getElement() : view,
				intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
						.getType(intelligentMobility.diagram.edit.parts.LaneChangingNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label " + 5013); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getDriver_Emotion_2016Text(View view) {
		IParser parser = intelligentMobility.diagram.providers.DrivingBehaviourMetamodelParserProvider.getParser(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Driver_Emotion_2016,
				view.getElement() != null ? view.getElement() : view,
				intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
						intelligentMobility.diagram.edit.parts.Driver_EmotionMetanlConditionEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label " + 5014); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getCollision_2017Text(View view) {
		IParser parser = intelligentMobility.diagram.providers.DrivingBehaviourMetamodelParserProvider.getParser(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Collision_2017,
				view.getElement() != null ? view.getElement() : view,
				intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
						.getType(intelligentMobility.diagram.edit.parts.CollisionNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label " + 5015); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getPossibleVehicle_2018Text(View view) {
		intelligentMobility.PossibleVehicle domainModelElement = (intelligentMobility.PossibleVehicle) view
				.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.getVehicleType());
		} else {
			intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin.getInstance()
					.logError("No domain element for view with visualID = " + 2018); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getFollowing_2019Text(View view) {
		IParser parser = intelligentMobility.diagram.providers.DrivingBehaviourMetamodelParserProvider.getParser(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Following_2019,
				view.getElement() != null ? view.getElement() : view,
				intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
						.getType(intelligentMobility.diagram.edit.parts.FollowingNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label " + 5016); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getGapAcceptance_2020Text(View view) {
		IParser parser = intelligentMobility.diagram.providers.DrivingBehaviourMetamodelParserProvider.getParser(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.GapAcceptance_2020,
				view.getElement() != null ? view.getElement() : view,
				intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
						.getType(intelligentMobility.diagram.edit.parts.GapAcceptanceNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label " + 5017); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getLeading_Vehicle_2021Text(View view) {
		IParser parser = intelligentMobility.diagram.providers.DrivingBehaviourMetamodelParserProvider.getParser(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Leading_Vehicle_2021,
				view.getElement() != null ? view.getElement() : view,
				intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
						.getType(intelligentMobility.diagram.edit.parts.Leading_VehicleNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label " + 5018); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getBackward_2022Text(View view) {
		IParser parser = intelligentMobility.diagram.providers.DrivingBehaviourMetamodelParserProvider.getParser(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Backward_2022,
				view.getElement() != null ? view.getElement() : view,
				intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
						.getType(intelligentMobility.diagram.edit.parts.BackwardNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label " + 5019); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getRegulation_2023Text(View view) {
		IParser parser = intelligentMobility.diagram.providers.DrivingBehaviourMetamodelParserProvider.getParser(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Regulation_2023,
				view.getElement() != null ? view.getElement() : view,
				intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
						.getType(intelligentMobility.diagram.edit.parts.RegulationLegislationEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label " + 5020); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getTraffic_Situation_2024Text(View view) {
		IParser parser = intelligentMobility.diagram.providers.DrivingBehaviourMetamodelParserProvider.getParser(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Traffic_Situation_2024,
				view.getElement() != null ? view.getElement() : view,
				intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
						.getType(intelligentMobility.diagram.edit.parts.Traffic_SituationNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label " + 5021); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getDriver_Profile_2025Text(View view) {
		IParser parser = intelligentMobility.diagram.providers.DrivingBehaviourMetamodelParserProvider.getParser(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Driver_Profile_2025,
				view.getElement() != null ? view.getElement() : view,
				intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
						.getType(intelligentMobility.diagram.edit.parts.Driver_ProfileDriverNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label " + 5022); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getSafety_Requirement_2026Text(View view) {
		IParser parser = intelligentMobility.diagram.providers.DrivingBehaviourMetamodelParserProvider.getParser(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Safety_Requirement_2026,
				view.getElement() != null ? view.getElement() : view,
				intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
						.getType(intelligentMobility.diagram.edit.parts.Safety_RequirementNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label " + 5023); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getDriving_Behaviour_2027Text(View view) {
		IParser parser = intelligentMobility.diagram.providers.DrivingBehaviourMetamodelParserProvider.getParser(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Driving_Behaviour_2027,
				view.getElement() != null ? view.getElement() : view,
				intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
						.getType(intelligentMobility.diagram.edit.parts.Driving_BehaviourNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label " + 5024); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getFollowing_Vehicle_2028Text(View view) {
		IParser parser = intelligentMobility.diagram.providers.DrivingBehaviourMetamodelParserProvider.getParser(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Following_Vehicle_2028,
				view.getElement() != null ? view.getElement() : view,
				intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
						.getType(intelligentMobility.diagram.edit.parts.Following_VehicleNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label " + 5025); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getAbnormal_Behaviour_2029Text(View view) {
		IParser parser = intelligentMobility.diagram.providers.DrivingBehaviourMetamodelParserProvider.getParser(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Abnormal_Behaviour_2029,
				view.getElement() != null ? view.getElement() : view,
				intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
						.getType(intelligentMobility.diagram.edit.parts.Abnormal_BehaviourNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label " + 5026); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getBackward_2030Text(View view) {
		intelligentMobility.Backward domainModelElement = (intelligentMobility.Backward) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin.getInstance()
					.logError("No domain element for view with visualID = " + 2030); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getIntersection_2031Text(View view) {
		intelligentMobility.Intersection domainModelElement = (intelligentMobility.Intersection) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin.getInstance()
					.logError("No domain element for view with visualID = " + 2031); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getCommunicationInterface_2032Text(View view) {
		intelligentMobility.CommunicationInterface domainModelElement = (intelligentMobility.CommunicationInterface) view
				.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.getProtocol());
		} else {
			intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin.getInstance()
					.logError("No domain element for view with visualID = " + 2032); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getGoal_2033Text(View view) {
		IParser parser = intelligentMobility.diagram.providers.DrivingBehaviourMetamodelParserProvider.getParser(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Goal_2033,
				view.getElement() != null ? view.getElement() : view,
				intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
						.getType(intelligentMobility.diagram.edit.parts.GoalGoalTypeEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label " + 5027); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getNormal_Behaviour_2034Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	* @generated
	*/
	private String getPlatoon_2035Text(View view) {
		intelligentMobility.Platoon domainModelElement = (intelligentMobility.Platoon) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin.getInstance()
					.logError("No domain element for view with visualID = " + 2035); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getNormal_Vehicle_2036Text(View view) {
		intelligentMobility.Normal_Vehicle domainModelElement = (intelligentMobility.Normal_Vehicle) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin.getInstance()
					.logError("No domain element for view with visualID = " + 2036); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getCooperativeBehavior_2037Text(View view) {
		intelligentMobility.CooperativeBehavior domainModelElement = (intelligentMobility.CooperativeBehavior) view
				.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin.getInstance()
					.logError("No domain element for view with visualID = " + 2037); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getAction_2039Text(View view) {
		IParser parser = intelligentMobility.diagram.providers.DrivingBehaviourMetamodelParserProvider.getParser(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Action_2039,
				view.getElement() != null ? view.getElement() : view,
				intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
						.getType(intelligentMobility.diagram.edit.parts.ActionActionTypeEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label " + 5030); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getLink_LaneType_Regulation_4001Text(View view) {
		intelligentMobility.Link_LaneType_Regulation domainModelElement = (intelligentMobility.Link_LaneType_Regulation) view
				.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName_link_laneType_regulation();
		} else {
			intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin.getInstance()
					.logError("No domain element for view with visualID = " + 4001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getLink_Driver_Vehicle_4002Text(View view) {
		intelligentMobility.Link_Driver_Vehicle domainModelElement = (intelligentMobility.Link_Driver_Vehicle) view
				.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getLink_name_driver_vehicle();
		} else {
			intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin.getInstance()
					.logError("No domain element for view with visualID = " + 4002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getLink_EnvironmentBackground_PossibleVehicle_4003Text(View view) {
		intelligentMobility.Link_EnvironmentBackground_PossibleVehicle domainModelElement = (intelligentMobility.Link_EnvironmentBackground_PossibleVehicle) view
				.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName_link_background_possibleVehicle();
		} else {
			intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin.getInstance()
					.logError("No domain element for view with visualID = " + 4003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getLink_Vehicle_Environment_4004Text(View view) {
		intelligentMobility.Link_Vehicle_Environment domainModelElement = (intelligentMobility.Link_Vehicle_Environment) view
				.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getLink_name_vehicle_environment();
		} else {
			intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin.getInstance()
					.logError("No domain element for view with visualID = " + 4004); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getLink_NormalVehicle_SafetyRequirements_4005Text(View view) {
		intelligentMobility.Link_NormalVehicle_SafetyRequirements domainModelElement = (intelligentMobility.Link_NormalVehicle_SafetyRequirements) view
				.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName_link_normalVehicle_safetyRequirement();
		} else {
			intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin.getInstance()
					.logError("No domain element for view with visualID = " + 4005); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getLink_DriverProfile_DriverPreference_4006Text(View view) {
		intelligentMobility.Link_DriverProfile_DriverPreference domainModelElement = (intelligentMobility.Link_DriverProfile_DriverPreference) view
				.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName_link_profile_preference();
		} else {
			intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin.getInstance()
					.logError("No domain element for view with visualID = " + 4006); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getLink_Collision_Obstruction_4007Text(View view) {
		intelligentMobility.Link_Collision_Obstruction domainModelElement = (intelligentMobility.Link_Collision_Obstruction) view
				.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName_link_collision_obstruction();
		} else {
			intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin.getInstance()
					.logError("No domain element for view with visualID = " + 4007); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getLink_Platoon_FollowingVehicle_4008Text(View view) {
		intelligentMobility.Link_Platoon_FollowingVehicle domainModelElement = (intelligentMobility.Link_Platoon_FollowingVehicle) view
				.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName_link_platoon_followingVehicle();
		} else {
			intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin.getInstance()
					.logError("No domain element for view with visualID = " + 4008); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getLink_DriverPreference_EnvironmentCondition_4009Text(View view) {
		intelligentMobility.Link_DriverPreference_EnvironmentCondition domainModelElement = (intelligentMobility.Link_DriverPreference_EnvironmentCondition) view
				.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName_link_preference_condition();
		} else {
			intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin.getInstance()
					.logError("No domain element for view with visualID = " + 4009); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getLink_AbnormalBehaviour_Action_4010Text(View view) {
		intelligentMobility.Link_AbnormalBehaviour_Action domainModelElement = (intelligentMobility.Link_AbnormalBehaviour_Action) view
				.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName_link_abnormalBehaviour_action();
		} else {
			intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin.getInstance()
					.logError("No domain element for view with visualID = " + 4010); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getLink_Following_Forward_4011Text(View view) {
		intelligentMobility.Link_Following_Forward domainModelElement = (intelligentMobility.Link_Following_Forward) view
				.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName_link_following_forward();
		} else {
			intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin.getInstance()
					.logError("No domain element for view with visualID = " + 4011); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getLink_EnvironmentCondition_LaneType_4012Text(View view) {
		intelligentMobility.Link_EnvironmentCondition_LaneType domainModelElement = (intelligentMobility.Link_EnvironmentCondition_LaneType) view
				.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName_link_environmentCondition_laneType();
		} else {
			intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin.getInstance()
					.logError("No domain element for view with visualID = " + 4012); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getLink_VehicleConfiguration_VehicleType_4013Text(View view) {
		intelligentMobility.Link_VehicleConfiguration_VehicleType domainModelElement = (intelligentMobility.Link_VehicleConfiguration_VehicleType) view
				.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName_link_configuration_type();
		} else {
			intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin.getInstance()
					.logError("No domain element for view with visualID = " + 4013); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getLink_Platoon_LeadingVehicle_4014Text(View view) {
		intelligentMobility.Link_Platoon_LeadingVehicle domainModelElement = (intelligentMobility.Link_Platoon_LeadingVehicle) view
				.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName_link_platoon_leadingVehicle();
		} else {
			intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin.getInstance()
					.logError("No domain element for view with visualID = " + 4014); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getLink_Driver_Environment_4015Text(View view) {
		intelligentMobility.Link_Driver_Environment domainModelElement = (intelligentMobility.Link_Driver_Environment) view
				.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getLink_name_driver_environment();
		} else {
			intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin.getInstance()
					.logError("No domain element for view with visualID = " + 4015); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getLink_LaneChanging_Turn_4016Text(View view) {
		intelligentMobility.Link_LaneChanging_Turn domainModelElement = (intelligentMobility.Link_LaneChanging_Turn) view
				.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName_link_laneChanging_turn();
		} else {
			intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin.getInstance()
					.logError("No domain element for view with visualID = " + 4016); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getLink_EnvironmentCondition_TrafficCondition_4017Text(View view) {
		intelligentMobility.Link_EnvironmentCondition_TrafficCondition domainModelElement = (intelligentMobility.Link_EnvironmentCondition_TrafficCondition) view
				.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName_link_environmentCondition_trafficCondition();
		} else {
			intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin.getInstance()
					.logError("No domain element for view with visualID = " + 4017); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getLink_Intersection_TrafficLight_4018Text(View view) {
		intelligentMobility.Link_Intersection_TrafficLight domainModelElement = (intelligentMobility.Link_Intersection_TrafficLight) view
				.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName_link_intersection_trafficLight();
		} else {
			intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin.getInstance()
					.logError("No domain element for view with visualID = " + 4018); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getLink_Following_MinGap_4019Text(View view) {
		intelligentMobility.Link_Following_MinGap domainModelElement = (intelligentMobility.Link_Following_MinGap) view
				.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName_link_following_minGap();
		} else {
			intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin.getInstance()
					.logError("No domain element for view with visualID = " + 4019); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getLink_NormalBehaviour_LaneChanging_4020Text(View view) {
		intelligentMobility.Link_NormalBehaviour_LaneChanging domainModelElement = (intelligentMobility.Link_NormalBehaviour_LaneChanging) view
				.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName_link_behaviour_laneChanging();
		} else {
			intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin.getInstance()
					.logError("No domain element for view with visualID = " + 4020); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getLink_SafetyRequirement_Regulation_4021Text(View view) {
		intelligentMobility.Link_SafetyRequirement_Regulation domainModelElement = (intelligentMobility.Link_SafetyRequirement_Regulation) view
				.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName_link_safetyRequirement_regulation();
		} else {
			intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin.getInstance()
					.logError("No domain element for view with visualID = " + 4021); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getLink_DriverPreference_DrivingBehaviour_4022Text(View view) {
		intelligentMobility.Link_DriverPreference_DrivingBehaviour domainModelElement = (intelligentMobility.Link_DriverPreference_DrivingBehaviour) view
				.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName_link_preference_behaviour();
		} else {
			intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin.getInstance()
					.logError("No domain element for view with visualID = " + 4022); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getLink_FollowingVehicle_FrontVehicle_4023Text(View view) {
		intelligentMobility.Link_FollowingVehicle_FrontVehicle domainModelElement = (intelligentMobility.Link_FollowingVehicle_FrontVehicle) view
				.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName_link_followingVehicle_frontVehicle();
		} else {
			intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin.getInstance()
					.logError("No domain element for view with visualID = " + 4023); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getLink_DriverPreference_DriverEmotion_4024Text(View view) {
		intelligentMobility.Link_DriverPreference_DriverEmotion domainModelElement = (intelligentMobility.Link_DriverPreference_DriverEmotion) view
				.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName_link_preference_emotion();
		} else {
			intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin.getInstance()
					.logError("No domain element for view with visualID = " + 4024); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getLink_EnvironmentBackground_EnvironmentCondition_4025Text(View view) {
		intelligentMobility.Link_EnvironmentBackground_EnvironmentCondition domainModelElement = (intelligentMobility.Link_EnvironmentBackground_EnvironmentCondition) view
				.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName_link_background_condition();
		} else {
			intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin.getInstance()
					.logError("No domain element for view with visualID = " + 4025); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getLink_EnvironmentCondition_Weather_4026Text(View view) {
		intelligentMobility.Link_EnvironmentCondition_Weather domainModelElement = (intelligentMobility.Link_EnvironmentCondition_Weather) view
				.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName_link_environmentCondition_weather();
		} else {
			intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin.getInstance()
					.logError("No domain element for view with visualID = " + 4026); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getLink_EnvironmentCondition_SpecialCondition_4027Text(View view) {
		intelligentMobility.Link_EnvironmentCondition_SpecialCondition domainModelElement = (intelligentMobility.Link_EnvironmentCondition_SpecialCondition) view
				.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName_link_environmentCondition_specialCondition();
		} else {
			intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin.getInstance()
					.logError("No domain element for view with visualID = " + 4027); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getLink_SpecialCondition_Intersection_4028Text(View view) {
		intelligentMobility.Link_SpecialCondition_Intersection domainModelElement = (intelligentMobility.Link_SpecialCondition_Intersection) view
				.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName_link_specialCondition_intersection();
		} else {
			intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin.getInstance()
					.logError("No domain element for view with visualID = " + 4028); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getLink_Following_Backward_4029Text(View view) {
		intelligentMobility.Link_Following_Backward domainModelElement = (intelligentMobility.Link_Following_Backward) view
				.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName_link_following_backward();
		} else {
			intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin.getInstance()
					.logError("No domain element for view with visualID = " + 4029); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getLink_EnvironmentCondition_Regulations_4030Text(View view) {
		intelligentMobility.Link_EnvironmentCondition_Regulations domainModelElement = (intelligentMobility.Link_EnvironmentCondition_Regulations) view
				.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName_link_environmentCondition_regulation();
		} else {
			intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin.getInstance()
					.logError("No domain element for view with visualID = " + 4030); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getLink_DrivingBehaviour_NormalBehaviour_4031Text(View view) {
		intelligentMobility.Link_DrivingBehaviour_NormalBehaviour domainModelElement = (intelligentMobility.Link_DrivingBehaviour_NormalBehaviour) view
				.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName_link_driving_normal();
		} else {
			intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin.getInstance()
					.logError("No domain element for view with visualID = " + 4031); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getLink_LaneChanging_EnvironmentCondition_4032Text(View view) {
		intelligentMobility.Link_LaneChanging_EnvironmentCondition domainModelElement = (intelligentMobility.Link_LaneChanging_EnvironmentCondition) view
				.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName_link_laneChanging_environmentCondition();
		} else {
			intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin.getInstance()
					.logError("No domain element for view with visualID = " + 4032); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getLink_LaneChanging_GapAcceptance_4033Text(View view) {
		intelligentMobility.Link_LaneChanging_GapAcceptance domainModelElement = (intelligentMobility.Link_LaneChanging_GapAcceptance) view
				.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName_link_laneChanging_gapAcceptane();
		} else {
			intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin.getInstance()
					.logError("No domain element for view with visualID = " + 4033); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getLink_NormalBehaviour_Following_4034Text(View view) {
		intelligentMobility.Link_NormalBehaviour_Following domainModelElement = (intelligentMobility.Link_NormalBehaviour_Following) view
				.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName_link_behaviour_following();
		} else {
			intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin.getInstance()
					.logError("No domain element for view with visualID = " + 4034); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getLink_Infrastructure_VehicleConfiguration_4035Text(View view) {
		intelligentMobility.Link_Infrastructure_VehicleConfiguration domainModelElement = (intelligentMobility.Link_Infrastructure_VehicleConfiguration) view
				.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName_link_infrastructure_vehicleConfiguration();
		} else {
			intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin.getInstance()
					.logError("No domain element for view with visualID = " + 4035); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getLink_CommunicationInterface_VehicleConfiguration_4036Text(View view) {
		intelligentMobility.Link_CommunicationInterface_VehicleConfiguration domainModelElement = (intelligentMobility.Link_CommunicationInterface_VehicleConfiguration) view
				.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName_link_communication_interface_vehicleConfiguration();
		} else {
			intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin.getInstance()
					.logError("No domain element for view with visualID = " + 4036); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getLink_Goal_DrivingBehaviour_4037Text(View view) {
		intelligentMobility.Link_Goal_DrivingBehaviour domainModelElement = (intelligentMobility.Link_Goal_DrivingBehaviour) view
				.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName_link_goal_drivingBehaviour();
		} else {
			intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin.getInstance()
					.logError("No domain element for view with visualID = " + 4037); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getLink_CooperativeBehaviour_CommunicationInterface_4038Text(View view) {
		intelligentMobility.Link_CooperativeBehaviour_CommunicationInterface domainModelElement = (intelligentMobility.Link_CooperativeBehaviour_CommunicationInterface) view
				.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName_link_cooperativeBehaviour_communicationInterface();
		} else {
			intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin.getInstance()
					.logError("No domain element for view with visualID = " + 4038); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getLink_CommunicationInterface_Infrastructure_4039Text(View view) {
		intelligentMobility.Link_CommunicationInterface_Infrastructure domainModelElement = (intelligentMobility.Link_CommunicationInterface_Infrastructure) view
				.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName_link_communication_interface_infrastructure();
		} else {
			intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin.getInstance()
					.logError("No domain element for view with visualID = " + 4039); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getLink_CooperativeBehaviour_VehicleConfiguration_4040Text(View view) {
		intelligentMobility.Link_CooperativeBehaviour_VehicleConfiguration domainModelElement = (intelligentMobility.Link_CooperativeBehaviour_VehicleConfiguration) view
				.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName_link_cooperativeBehaviour_vehicleConfiguration();
		} else {
			intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin.getInstance()
					.logError("No domain element for view with visualID = " + 4040); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getLink_TrafficSituation_EnvironmentCondition_4041Text(View view) {
		intelligentMobility.Link_TrafficSituation_EnvironmentCondition domainModelElement = (intelligentMobility.Link_TrafficSituation_EnvironmentCondition) view
				.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName_link_trafficSituation_environmentCondition();
		} else {
			intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin.getInstance()
					.logError("No domain element for view with visualID = " + 4041); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getLink_Collision_SpecialCondition_4042Text(View view) {
		intelligentMobility.Link_Collision_SpecialCondition domainModelElement = (intelligentMobility.Link_Collision_SpecialCondition) view
				.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName_link_collision_specialCondition();
		} else {
			intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin.getInstance()
					.logError("No domain element for view with visualID = " + 4042); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getLink_Following_LaneChanging_4043Text(View view) {
		intelligentMobility.Link_Following_LaneChanging domainModelElement = (intelligentMobility.Link_Following_LaneChanging) view
				.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName_link_following_laneChanging();
		} else {
			intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin.getInstance()
					.logError("No domain element for view with visualID = " + 4043); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getLink_Action_Backward_4044Text(View view) {
		intelligentMobility.Link_Action_Backward domainModelElement = (intelligentMobility.Link_Action_Backward) view
				.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName_link_action_backward();
		} else {
			intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin.getInstance()
					.logError("No domain element for view with visualID = " + 4044); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getLink_Action_Forward_4045Text(View view) {
		intelligentMobility.Link_Action_Forward domainModelElement = (intelligentMobility.Link_Action_Forward) view
				.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName_link_action_forward();
		} else {
			intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin.getInstance()
					.logError("No domain element for view with visualID = " + 4045); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getLink_Action_Turn_4046Text(View view) {
		intelligentMobility.Link_Action_Turn domainModelElement = (intelligentMobility.Link_Action_Turn) view
				.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName_link_action_turn();
		} else {
			intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin.getInstance()
					.logError("No domain element for view with visualID = " + 4046); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getLink_KnowledgeAndSkill_DriverPreference_4047Text(View view) {
		intelligentMobility.Link_KnowledgeAndSkill_DriverPreference domainModelElement = (intelligentMobility.Link_KnowledgeAndSkill_DriverPreference) view
				.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName_link_knowledgeAndSkill_driverPreference();
		} else {
			intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin.getInstance()
					.logError("No domain element for view with visualID = " + 4047); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getUnknownElementText(View view) {
		return "<UnknownElement Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	* @generated
	*/
	private String getUnresolvedDomainElementProxyText(View view) {
		return "<Unresolved domain element Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	* @generated
	*/
	public void init(ICommonContentExtensionSite aConfig) {
	}

	/**
	* @generated
	*/
	public void restoreState(IMemento aMemento) {
	}

	/**
	* @generated
	*/
	public void saveState(IMemento aMemento) {
	}

	/**
	* @generated
	*/
	public String getDescription(Object anElement) {
		return null;
	}

	/**
	* @generated
	*/
	private boolean isOwnView(View view) {
		return intelligentMobility.diagram.edit.parts.MobilitySystemEditPart.MODEL_ID
				.equals(intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getModelID(view));
	}

}
