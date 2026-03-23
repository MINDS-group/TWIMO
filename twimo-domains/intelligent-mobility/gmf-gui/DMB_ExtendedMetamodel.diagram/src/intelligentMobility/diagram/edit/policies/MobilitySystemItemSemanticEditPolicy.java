package intelligentMobility.diagram.edit.policies;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.commands.DuplicateEObjectsCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;

/**
 * @generated
 */
public class MobilitySystemItemSemanticEditPolicy
		extends intelligentMobility.diagram.edit.policies.DrivingBehaviourMetamodelBaseItemSemanticEditPolicy {

	/**
	* @generated
	*/
	public MobilitySystemItemSemanticEditPolicy() {
		super(intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.MobilitySystem_1000);
	}

	/**
	* @generated
	*/
	protected Command getCreateCommand(CreateElementRequest req) {
		if (intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Special_Condition_2001 == req
				.getElementType()) {
			return getGEFWrapper(new intelligentMobility.diagram.edit.commands.Special_ConditionCreateCommand(req));
		}
		if (intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Weather_2002 == req
				.getElementType()) {
			return getGEFWrapper(new intelligentMobility.diagram.edit.commands.WeatherCreateCommand(req));
		}
		if (intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Traffic_Light_2003 == req
				.getElementType()) {
			return getGEFWrapper(new intelligentMobility.diagram.edit.commands.Traffic_LightCreateCommand(req));
		}
		if (intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Knowledge_and_Skill_2004 == req
				.getElementType()) {
			return getGEFWrapper(new intelligentMobility.diagram.edit.commands.Knowledge_and_SkillCreateCommand(req));
		}
		if (intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Obstruction_2005 == req
				.getElementType()) {
			return getGEFWrapper(new intelligentMobility.diagram.edit.commands.ObstructionCreateCommand(req));
		}
		if (intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Driver_Preference_2006 == req
				.getElementType()) {
			return getGEFWrapper(new intelligentMobility.diagram.edit.commands.Driver_PreferenceCreateCommand(req));
		}
		if (intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Intersection_2007 == req
				.getElementType()) {
			return getGEFWrapper(new intelligentMobility.diagram.edit.commands.IntersectionCreateCommand(req));
		}
		if (intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Vehicle_Configuration_2008 == req
				.getElementType()) {
			return getGEFWrapper(new intelligentMobility.diagram.edit.commands.Vehicle_ConfigurationCreateCommand(req));
		}
		if (intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Environment_Condition_2009 == req
				.getElementType()) {
			return getGEFWrapper(new intelligentMobility.diagram.edit.commands.Environment_ConditionCreateCommand(req));
		}
		if (intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Platoon_2010 == req
				.getElementType()) {
			return getGEFWrapper(new intelligentMobility.diagram.edit.commands.PlatoonCreateCommand(req));
		}
		if (intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Forward_2011 == req
				.getElementType()) {
			return getGEFWrapper(new intelligentMobility.diagram.edit.commands.ForwardCreateCommand(req));
		}
		if (intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Lane_Type_2012 == req
				.getElementType()) {
			return getGEFWrapper(new intelligentMobility.diagram.edit.commands.Lane_TypeCreateCommand(req));
		}
		if (intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Environment_Background_2013 == req
				.getElementType()) {
			return getGEFWrapper(
					new intelligentMobility.diagram.edit.commands.Environment_BackgroundCreateCommand(req));
		}
		if (intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Turn_2014 == req
				.getElementType()) {
			return getGEFWrapper(new intelligentMobility.diagram.edit.commands.TurnCreateCommand(req));
		}
		if (intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.LaneChanging_2015 == req
				.getElementType()) {
			return getGEFWrapper(new intelligentMobility.diagram.edit.commands.LaneChangingCreateCommand(req));
		}
		if (intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Driver_Emotion_2016 == req
				.getElementType()) {
			return getGEFWrapper(new intelligentMobility.diagram.edit.commands.Driver_EmotionCreateCommand(req));
		}
		if (intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Collision_2017 == req
				.getElementType()) {
			return getGEFWrapper(new intelligentMobility.diagram.edit.commands.CollisionCreateCommand(req));
		}
		if (intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.PossibleVehicle_2018 == req
				.getElementType()) {
			return getGEFWrapper(new intelligentMobility.diagram.edit.commands.PossibleVehicleCreateCommand(req));
		}
		if (intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Following_2019 == req
				.getElementType()) {
			return getGEFWrapper(new intelligentMobility.diagram.edit.commands.FollowingCreateCommand(req));
		}
		if (intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.GapAcceptance_2020 == req
				.getElementType()) {
			return getGEFWrapper(new intelligentMobility.diagram.edit.commands.GapAcceptanceCreateCommand(req));
		}
		if (intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Leading_Vehicle_2021 == req
				.getElementType()) {
			return getGEFWrapper(new intelligentMobility.diagram.edit.commands.Leading_VehicleCreateCommand(req));
		}
		if (intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Backward_2022 == req
				.getElementType()) {
			return getGEFWrapper(new intelligentMobility.diagram.edit.commands.BackwardCreateCommand(req));
		}
		if (intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Regulation_2023 == req
				.getElementType()) {
			return getGEFWrapper(new intelligentMobility.diagram.edit.commands.RegulationCreateCommand(req));
		}
		if (intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Traffic_Situation_2024 == req
				.getElementType()) {
			return getGEFWrapper(new intelligentMobility.diagram.edit.commands.Traffic_SituationCreateCommand(req));
		}
		if (intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Driver_Profile_2025 == req
				.getElementType()) {
			return getGEFWrapper(new intelligentMobility.diagram.edit.commands.Driver_ProfileCreateCommand(req));
		}
		if (intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Safety_Requirement_2026 == req
				.getElementType()) {
			return getGEFWrapper(new intelligentMobility.diagram.edit.commands.Safety_RequirementCreateCommand(req));
		}
		if (intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Driving_Behaviour_2027 == req
				.getElementType()) {
			return getGEFWrapper(new intelligentMobility.diagram.edit.commands.Driving_BehaviourCreateCommand(req));
		}
		if (intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Following_Vehicle_2028 == req
				.getElementType()) {
			return getGEFWrapper(new intelligentMobility.diagram.edit.commands.Following_VehicleCreateCommand(req));
		}
		if (intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Abnormal_Behaviour_2029 == req
				.getElementType()) {
			return getGEFWrapper(new intelligentMobility.diagram.edit.commands.Abnormal_BehaviourCreateCommand(req));
		}
		if (intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Backward_2030 == req
				.getElementType()) {
			return getGEFWrapper(new intelligentMobility.diagram.edit.commands.Backward2CreateCommand(req));
		}
		if (intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Intersection_2031 == req
				.getElementType()) {
			return getGEFWrapper(new intelligentMobility.diagram.edit.commands.Intersection2CreateCommand(req));
		}
		if (intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.CommunicationInterface_2032 == req
				.getElementType()) {
			return getGEFWrapper(
					new intelligentMobility.diagram.edit.commands.CommunicationInterfaceCreateCommand(req));
		}
		if (intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Goal_2033 == req
				.getElementType()) {
			return getGEFWrapper(new intelligentMobility.diagram.edit.commands.GoalCreateCommand(req));
		}
		if (intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Normal_Behaviour_2034 == req
				.getElementType()) {
			return getGEFWrapper(new intelligentMobility.diagram.edit.commands.Normal_BehaviourCreateCommand(req));
		}
		if (intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Platoon_2035 == req
				.getElementType()) {
			return getGEFWrapper(new intelligentMobility.diagram.edit.commands.Platoon2CreateCommand(req));
		}
		if (intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Normal_Vehicle_2036 == req
				.getElementType()) {
			return getGEFWrapper(new intelligentMobility.diagram.edit.commands.Normal_VehicleCreateCommand(req));
		}
		if (intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.CooperativeBehavior_2037 == req
				.getElementType()) {
			return getGEFWrapper(new intelligentMobility.diagram.edit.commands.CooperativeBehaviorCreateCommand(req));
		}
		if (intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Action_2039 == req
				.getElementType()) {
			return getGEFWrapper(new intelligentMobility.diagram.edit.commands.ActionCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

	/**
	* @generated
	*/
	protected Command getDuplicateCommand(DuplicateElementsRequest req) {
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost()).getEditingDomain();
		return getGEFWrapper(new DuplicateAnythingCommand(editingDomain, req));
	}

	/**
	* @generated
	*/
	private static class DuplicateAnythingCommand extends DuplicateEObjectsCommand {

		/**
		* @generated
		*/
		public DuplicateAnythingCommand(TransactionalEditingDomain editingDomain, DuplicateElementsRequest req) {
			super(editingDomain, req.getLabel(), req.getElementsToBeDuplicated(), req.getAllDuplicatedElementsMap());
		}

	}

}
