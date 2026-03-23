package intelligentMobility.diagram.edit.parts;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.directedit.locator.CellEditorLocatorAccess;

/**
 * @generated
 */
public class DrivingBehaviourMetamodelEditPartFactory implements EditPartFactory {

	/**
	* @generated
	*/
	public EditPart createEditPart(EditPart context, Object model) {
		if (model instanceof View) {
			View view = (View) model;
			switch (intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getVisualID(view)) {

			case intelligentMobility.diagram.edit.parts.MobilitySystemEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.MobilitySystemEditPart(view);

			case intelligentMobility.diagram.edit.parts.Special_ConditionEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.Special_ConditionEditPart(view);

			case intelligentMobility.diagram.edit.parts.Special_ConditionConditionNameEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.Special_ConditionConditionNameEditPart(view);

			case intelligentMobility.diagram.edit.parts.WeatherEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.WeatherEditPart(view);

			case intelligentMobility.diagram.edit.parts.WeatherWeatherTypeEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.WeatherWeatherTypeEditPart(view);

			case intelligentMobility.diagram.edit.parts.Traffic_LightEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.Traffic_LightEditPart(view);

			case intelligentMobility.diagram.edit.parts.Traffic_LightNameEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.Traffic_LightNameEditPart(view);

			case intelligentMobility.diagram.edit.parts.Knowledge_and_SkillEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.Knowledge_and_SkillEditPart(view);

			case intelligentMobility.diagram.edit.parts.Knowledge_and_SkillNameEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.Knowledge_and_SkillNameEditPart(view);

			case intelligentMobility.diagram.edit.parts.ObstructionEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.ObstructionEditPart(view);

			case intelligentMobility.diagram.edit.parts.ObstructionNameEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.ObstructionNameEditPart(view);

			case intelligentMobility.diagram.edit.parts.Driver_PreferenceEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.Driver_PreferenceEditPart(view);

			case intelligentMobility.diagram.edit.parts.Driver_PreferenceName_PreferenceSetEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.Driver_PreferenceName_PreferenceSetEditPart(view);

			case intelligentMobility.diagram.edit.parts.IntersectionEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.IntersectionEditPart(view);

			case intelligentMobility.diagram.edit.parts.IntersectionNameEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.IntersectionNameEditPart(view);

			case intelligentMobility.diagram.edit.parts.Vehicle_ConfigurationEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.Vehicle_ConfigurationEditPart(view);

			case intelligentMobility.diagram.edit.parts.Vehicle_ConfigurationBrandNameEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.Vehicle_ConfigurationBrandNameEditPart(view);

			case intelligentMobility.diagram.edit.parts.Environment_ConditionEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.Environment_ConditionEditPart(view);

			case intelligentMobility.diagram.edit.parts.Environment_ConditionName_EnvironmentConditiEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.Environment_ConditionName_EnvironmentConditiEditPart(
						view);

			case intelligentMobility.diagram.edit.parts.PlatoonEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.PlatoonEditPart(view);

			case intelligentMobility.diagram.edit.parts.PlatoonNameEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.PlatoonNameEditPart(view);

			case intelligentMobility.diagram.edit.parts.ForwardEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.ForwardEditPart(view);

			case intelligentMobility.diagram.edit.parts.ForwardNameEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.ForwardNameEditPart(view);

			case intelligentMobility.diagram.edit.parts.Lane_TypeEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.Lane_TypeEditPart(view);

			case intelligentMobility.diagram.edit.parts.Lane_TypeNameEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.Lane_TypeNameEditPart(view);

			case intelligentMobility.diagram.edit.parts.Environment_BackgroundEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.Environment_BackgroundEditPart(view);

			case intelligentMobility.diagram.edit.parts.Environment_BackgroundNameEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.Environment_BackgroundNameEditPart(view);

			case intelligentMobility.diagram.edit.parts.TurnEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.TurnEditPart(view);

			case intelligentMobility.diagram.edit.parts.TurnNameEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.TurnNameEditPart(view);

			case intelligentMobility.diagram.edit.parts.LaneChangingEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.LaneChangingEditPart(view);

			case intelligentMobility.diagram.edit.parts.LaneChangingNameEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.LaneChangingNameEditPart(view);

			case intelligentMobility.diagram.edit.parts.Driver_EmotionEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.Driver_EmotionEditPart(view);

			case intelligentMobility.diagram.edit.parts.Driver_EmotionMetanlConditionEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.Driver_EmotionMetanlConditionEditPart(view);

			case intelligentMobility.diagram.edit.parts.CollisionEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.CollisionEditPart(view);

			case intelligentMobility.diagram.edit.parts.CollisionNameEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.CollisionNameEditPart(view);

			case intelligentMobility.diagram.edit.parts.PossibleVehicleEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.PossibleVehicleEditPart(view);

			case intelligentMobility.diagram.edit.parts.FollowingEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.FollowingEditPart(view);

			case intelligentMobility.diagram.edit.parts.FollowingNameEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.FollowingNameEditPart(view);

			case intelligentMobility.diagram.edit.parts.GapAcceptanceEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.GapAcceptanceEditPart(view);

			case intelligentMobility.diagram.edit.parts.GapAcceptanceNameEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.GapAcceptanceNameEditPart(view);

			case intelligentMobility.diagram.edit.parts.Leading_VehicleEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.Leading_VehicleEditPart(view);

			case intelligentMobility.diagram.edit.parts.Leading_VehicleNameEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.Leading_VehicleNameEditPart(view);

			case intelligentMobility.diagram.edit.parts.BackwardEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.BackwardEditPart(view);

			case intelligentMobility.diagram.edit.parts.BackwardNameEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.BackwardNameEditPart(view);

			case intelligentMobility.diagram.edit.parts.RegulationEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.RegulationEditPart(view);

			case intelligentMobility.diagram.edit.parts.RegulationLegislationEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.RegulationLegislationEditPart(view);

			case intelligentMobility.diagram.edit.parts.Traffic_SituationEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.Traffic_SituationEditPart(view);

			case intelligentMobility.diagram.edit.parts.Traffic_SituationNameEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.Traffic_SituationNameEditPart(view);

			case intelligentMobility.diagram.edit.parts.Driver_ProfileEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.Driver_ProfileEditPart(view);

			case intelligentMobility.diagram.edit.parts.Driver_ProfileDriverNameEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.Driver_ProfileDriverNameEditPart(view);

			case intelligentMobility.diagram.edit.parts.Safety_RequirementEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.Safety_RequirementEditPart(view);

			case intelligentMobility.diagram.edit.parts.Safety_RequirementNameEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.Safety_RequirementNameEditPart(view);

			case intelligentMobility.diagram.edit.parts.Driving_BehaviourEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.Driving_BehaviourEditPart(view);

			case intelligentMobility.diagram.edit.parts.Driving_BehaviourNameEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.Driving_BehaviourNameEditPart(view);

			case intelligentMobility.diagram.edit.parts.Following_VehicleEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.Following_VehicleEditPart(view);

			case intelligentMobility.diagram.edit.parts.Following_VehicleNameEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.Following_VehicleNameEditPart(view);

			case intelligentMobility.diagram.edit.parts.Abnormal_BehaviourEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.Abnormal_BehaviourEditPart(view);

			case intelligentMobility.diagram.edit.parts.Abnormal_BehaviourNameEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.Abnormal_BehaviourNameEditPart(view);

			case intelligentMobility.diagram.edit.parts.Backward2EditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.Backward2EditPart(view);

			case intelligentMobility.diagram.edit.parts.Intersection2EditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.Intersection2EditPart(view);

			case intelligentMobility.diagram.edit.parts.CommunicationInterfaceEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.CommunicationInterfaceEditPart(view);

			case intelligentMobility.diagram.edit.parts.GoalEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.GoalEditPart(view);

			case intelligentMobility.diagram.edit.parts.GoalGoalTypeEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.GoalGoalTypeEditPart(view);

			case intelligentMobility.diagram.edit.parts.Normal_BehaviourEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.Normal_BehaviourEditPart(view);

			case intelligentMobility.diagram.edit.parts.Platoon2EditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.Platoon2EditPart(view);

			case intelligentMobility.diagram.edit.parts.Normal_VehicleEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.Normal_VehicleEditPart(view);

			case intelligentMobility.diagram.edit.parts.CooperativeBehaviorEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.CooperativeBehaviorEditPart(view);

			case intelligentMobility.diagram.edit.parts.ActionEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.ActionEditPart(view);

			case intelligentMobility.diagram.edit.parts.ActionActionTypeEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.ActionActionTypeEditPart(view);

			case intelligentMobility.diagram.edit.parts.Link_LaneType_RegulationEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.Link_LaneType_RegulationEditPart(view);

			case intelligentMobility.diagram.edit.parts.Link_Driver_VehicleEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.Link_Driver_VehicleEditPart(view);

			case intelligentMobility.diagram.edit.parts.Link_EnvironmentBackground_PossibleVehicleEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.Link_EnvironmentBackground_PossibleVehicleEditPart(
						view);

			case intelligentMobility.diagram.edit.parts.Link_Vehicle_EnvironmentEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.Link_Vehicle_EnvironmentEditPart(view);

			case intelligentMobility.diagram.edit.parts.Link_NormalVehicle_SafetyRequirementsEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.Link_NormalVehicle_SafetyRequirementsEditPart(view);

			case intelligentMobility.diagram.edit.parts.Link_DriverProfile_DriverPreferenceEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.Link_DriverProfile_DriverPreferenceEditPart(view);

			case intelligentMobility.diagram.edit.parts.Link_Collision_ObstructionEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.Link_Collision_ObstructionEditPart(view);

			case intelligentMobility.diagram.edit.parts.Link_Platoon_FollowingVehicleEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.Link_Platoon_FollowingVehicleEditPart(view);

			case intelligentMobility.diagram.edit.parts.Link_DriverPreference_EnvironmentConditionEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.Link_DriverPreference_EnvironmentConditionEditPart(
						view);

			case intelligentMobility.diagram.edit.parts.Link_AbnormalBehaviour_ActionEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.Link_AbnormalBehaviour_ActionEditPart(view);

			case intelligentMobility.diagram.edit.parts.Link_Following_ForwardEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.Link_Following_ForwardEditPart(view);

			case intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_LaneTypeEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_LaneTypeEditPart(view);

			case intelligentMobility.diagram.edit.parts.Link_VehicleConfiguration_VehicleTypeEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.Link_VehicleConfiguration_VehicleTypeEditPart(view);

			case intelligentMobility.diagram.edit.parts.Link_Platoon_LeadingVehicleEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.Link_Platoon_LeadingVehicleEditPart(view);

			case intelligentMobility.diagram.edit.parts.Link_Driver_EnvironmentEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.Link_Driver_EnvironmentEditPart(view);

			case intelligentMobility.diagram.edit.parts.Link_LaneChanging_TurnEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.Link_LaneChanging_TurnEditPart(view);

			case intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_TrafficConditionEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_TrafficConditionEditPart(
						view);

			case intelligentMobility.diagram.edit.parts.Link_Intersection_TrafficLightEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.Link_Intersection_TrafficLightEditPart(view);

			case intelligentMobility.diagram.edit.parts.Link_Following_MinGapEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.Link_Following_MinGapEditPart(view);

			case intelligentMobility.diagram.edit.parts.Link_NormalBehaviour_LaneChangingEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.Link_NormalBehaviour_LaneChangingEditPart(view);

			case intelligentMobility.diagram.edit.parts.Link_SafetyRequirement_RegulationEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.Link_SafetyRequirement_RegulationEditPart(view);

			case intelligentMobility.diagram.edit.parts.Link_DriverPreference_DrivingBehaviourEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.Link_DriverPreference_DrivingBehaviourEditPart(view);

			case intelligentMobility.diagram.edit.parts.Link_FollowingVehicle_FrontVehicleEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.Link_FollowingVehicle_FrontVehicleEditPart(view);

			case intelligentMobility.diagram.edit.parts.Link_DriverPreference_DriverEmotionEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.Link_DriverPreference_DriverEmotionEditPart(view);

			case intelligentMobility.diagram.edit.parts.Link_EnvironmentBackground_EnvironmentConditionEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.Link_EnvironmentBackground_EnvironmentConditionEditPart(
						view);

			case intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_WeatherEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_WeatherEditPart(view);

			case intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_SpecialConditionEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_SpecialConditionEditPart(
						view);

			case intelligentMobility.diagram.edit.parts.Link_SpecialCondition_IntersectionEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.Link_SpecialCondition_IntersectionEditPart(view);

			case intelligentMobility.diagram.edit.parts.Link_Following_BackwardEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.Link_Following_BackwardEditPart(view);

			case intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_RegulationsEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_RegulationsEditPart(view);

			case intelligentMobility.diagram.edit.parts.Link_DrivingBehaviour_NormalBehaviourEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.Link_DrivingBehaviour_NormalBehaviourEditPart(view);

			case intelligentMobility.diagram.edit.parts.Link_LaneChanging_EnvironmentConditionEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.Link_LaneChanging_EnvironmentConditionEditPart(view);

			case intelligentMobility.diagram.edit.parts.Link_LaneChanging_GapAcceptanceEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.Link_LaneChanging_GapAcceptanceEditPart(view);

			case intelligentMobility.diagram.edit.parts.Link_NormalBehaviour_FollowingEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.Link_NormalBehaviour_FollowingEditPart(view);

			case intelligentMobility.diagram.edit.parts.Link_Infrastructure_VehicleConfigurationEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.Link_Infrastructure_VehicleConfigurationEditPart(
						view);

			case intelligentMobility.diagram.edit.parts.Link_CommunicationInterface_VehicleConfigurationEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.Link_CommunicationInterface_VehicleConfigurationEditPart(
						view);

			case intelligentMobility.diagram.edit.parts.Link_Goal_DrivingBehaviourEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.Link_Goal_DrivingBehaviourEditPart(view);

			case intelligentMobility.diagram.edit.parts.Link_CooperativeBehaviour_CommunicationInterfaceEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.Link_CooperativeBehaviour_CommunicationInterfaceEditPart(
						view);

			case intelligentMobility.diagram.edit.parts.Link_CommunicationInterface_InfrastructureEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.Link_CommunicationInterface_InfrastructureEditPart(
						view);

			case intelligentMobility.diagram.edit.parts.Link_CooperativeBehaviour_VehicleConfigurationEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.Link_CooperativeBehaviour_VehicleConfigurationEditPart(
						view);

			case intelligentMobility.diagram.edit.parts.Link_TrafficSituation_EnvironmentConditionEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.Link_TrafficSituation_EnvironmentConditionEditPart(
						view);

			case intelligentMobility.diagram.edit.parts.Link_Collision_SpecialConditionEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.Link_Collision_SpecialConditionEditPart(view);

			case intelligentMobility.diagram.edit.parts.Link_Following_LaneChangingEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.Link_Following_LaneChangingEditPart(view);

			case intelligentMobility.diagram.edit.parts.Link_Action_BackwardEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.Link_Action_BackwardEditPart(view);

			case intelligentMobility.diagram.edit.parts.Link_Action_ForwardEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.Link_Action_ForwardEditPart(view);

			case intelligentMobility.diagram.edit.parts.Link_Action_TurnEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.Link_Action_TurnEditPart(view);

			case intelligentMobility.diagram.edit.parts.Link_KnowledgeAndSkill_DriverPreferenceEditPart.VISUAL_ID:
				return new intelligentMobility.diagram.edit.parts.Link_KnowledgeAndSkill_DriverPreferenceEditPart(view);

			}
		}
		return createUnrecognizedEditPart(context, model);
	}

	/**
	* @generated
	*/
	private EditPart createUnrecognizedEditPart(EditPart context, Object model) {
		// Handle creation of unrecognized child node EditParts here
		return null;
	}

	/**
	* @generated
	*/
	public static CellEditorLocator getTextCellEditorLocator(ITextAwareEditPart source) {
		return CellEditorLocatorAccess.INSTANCE.getTextCellEditorLocator(source);
	}

}
