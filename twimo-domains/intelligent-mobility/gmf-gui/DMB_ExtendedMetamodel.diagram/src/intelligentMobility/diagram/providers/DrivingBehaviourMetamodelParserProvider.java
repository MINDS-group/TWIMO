package intelligentMobility.diagram.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserService;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ParserHintAdapter;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.parsers.EnumParser;

/**
 * @generated
 */
public class DrivingBehaviourMetamodelParserProvider extends AbstractProvider implements IParserProvider {

	/**
	* @generated
	*/
	private IParser special_ConditionConditionName_5001Parser;

	/**
	* @generated
	*/
	private IParser getSpecial_ConditionConditionName_5001Parser() {
		if (special_ConditionConditionName_5001Parser == null) {
			EAttribute[] features = new EAttribute[] {
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getSpecial_Condition_ConditionName() };
			intelligentMobility.diagram.parsers.MessageFormatParser parser = new intelligentMobility.diagram.parsers.MessageFormatParser(
					features);
			special_ConditionConditionName_5001Parser = parser;
		}
		return special_ConditionConditionName_5001Parser;
	}

	/**
	* @generated
	*/
	private IParser weatherWeatherType_5002Parser;

	/**
	* @generated
	*/
	private IParser getWeatherWeatherType_5002Parser() {
		if (weatherWeatherType_5002Parser == null) {
			EAttribute[] features = new EAttribute[] {
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getWeather_WeatherType() };
			intelligentMobility.diagram.parsers.MessageFormatParser parser = new intelligentMobility.diagram.parsers.MessageFormatParser(
					features);
			weatherWeatherType_5002Parser = parser;
		}
		return weatherWeatherType_5002Parser;
	}

	/**
	* @generated
	*/
	private IParser traffic_LightName_5031Parser;

	/**
	* @generated
	*/
	private IParser getTraffic_LightName_5031Parser() {
		if (traffic_LightName_5031Parser == null) {
			EAttribute[] features = new EAttribute[] {
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getTraffic_Light_Name() };
			intelligentMobility.diagram.parsers.MessageFormatParser parser = new intelligentMobility.diagram.parsers.MessageFormatParser(
					features);
			traffic_LightName_5031Parser = parser;
		}
		return traffic_LightName_5031Parser;
	}

	/**
	* @generated
	*/
	private IParser knowledge_and_SkillName_5003Parser;

	/**
	* @generated
	*/
	private IParser getKnowledge_and_SkillName_5003Parser() {
		if (knowledge_and_SkillName_5003Parser == null) {
			EAttribute[] features = new EAttribute[] {
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getKnowledge_and_Skill_Name() };
			intelligentMobility.diagram.parsers.MessageFormatParser parser = new intelligentMobility.diagram.parsers.MessageFormatParser(
					features);
			knowledge_and_SkillName_5003Parser = parser;
		}
		return knowledge_and_SkillName_5003Parser;
	}

	/**
	* @generated
	*/
	private IParser obstructionName_5004Parser;

	/**
	* @generated
	*/
	private IParser getObstructionName_5004Parser() {
		if (obstructionName_5004Parser == null) {
			EAttribute[] features = new EAttribute[] {
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getObstruction_Name() };
			intelligentMobility.diagram.parsers.MessageFormatParser parser = new intelligentMobility.diagram.parsers.MessageFormatParser(
					features);
			obstructionName_5004Parser = parser;
		}
		return obstructionName_5004Parser;
	}

	/**
	* @generated
	*/
	private IParser driver_PreferenceName_PreferenceSet_5005Parser;

	/**
	* @generated
	*/
	private IParser getDriver_PreferenceName_PreferenceSet_5005Parser() {
		if (driver_PreferenceName_PreferenceSet_5005Parser == null) {
			EAttribute[] features = new EAttribute[] { intelligentMobility.IntelligentMobilityPackage.eINSTANCE
					.getDriver_Preference_Name_PreferenceSet() };
			intelligentMobility.diagram.parsers.MessageFormatParser parser = new intelligentMobility.diagram.parsers.MessageFormatParser(
					features);
			driver_PreferenceName_PreferenceSet_5005Parser = parser;
		}
		return driver_PreferenceName_PreferenceSet_5005Parser;
	}

	/**
	* @generated
	*/
	private IParser intersectionName_5006Parser;

	/**
	* @generated
	*/
	private IParser getIntersectionName_5006Parser() {
		if (intersectionName_5006Parser == null) {
			EAttribute[] features = new EAttribute[] {
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getIntersection_Name() };
			intelligentMobility.diagram.parsers.MessageFormatParser parser = new intelligentMobility.diagram.parsers.MessageFormatParser(
					features);
			intersectionName_5006Parser = parser;
		}
		return intersectionName_5006Parser;
	}

	/**
	* @generated
	*/
	private IParser vehicle_ConfigurationBrandName_5007Parser;

	/**
	* @generated
	*/
	private IParser getVehicle_ConfigurationBrandName_5007Parser() {
		if (vehicle_ConfigurationBrandName_5007Parser == null) {
			EAttribute[] features = new EAttribute[] {
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getVehicle_Configuration_BrandName() };
			intelligentMobility.diagram.parsers.MessageFormatParser parser = new intelligentMobility.diagram.parsers.MessageFormatParser(
					features);
			vehicle_ConfigurationBrandName_5007Parser = parser;
		}
		return vehicle_ConfigurationBrandName_5007Parser;
	}

	/**
	* @generated
	*/
	private IParser environment_ConditionName_EnvironmentCondition_5008Parser;

	/**
	* @generated
	*/
	private IParser getEnvironment_ConditionName_EnvironmentCondition_5008Parser() {
		if (environment_ConditionName_EnvironmentCondition_5008Parser == null) {
			EAttribute[] features = new EAttribute[] { intelligentMobility.IntelligentMobilityPackage.eINSTANCE
					.getEnvironment_Condition_Name_EnvironmentCondition() };
			intelligentMobility.diagram.parsers.MessageFormatParser parser = new intelligentMobility.diagram.parsers.MessageFormatParser(
					features);
			environment_ConditionName_EnvironmentCondition_5008Parser = parser;
		}
		return environment_ConditionName_EnvironmentCondition_5008Parser;
	}

	/**
	* @generated
	*/
	private IParser platoonName_5009Parser;

	/**
	* @generated
	*/
	private IParser getPlatoonName_5009Parser() {
		if (platoonName_5009Parser == null) {
			EAttribute[] features = new EAttribute[] {
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getPlatoon_Name() };
			intelligentMobility.diagram.parsers.MessageFormatParser parser = new intelligentMobility.diagram.parsers.MessageFormatParser(
					features);
			platoonName_5009Parser = parser;
		}
		return platoonName_5009Parser;
	}

	/**
	* @generated
	*/
	private IParser forwardName_5010Parser;

	/**
	* @generated
	*/
	private IParser getForwardName_5010Parser() {
		if (forwardName_5010Parser == null) {
			EAttribute[] features = new EAttribute[] {
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getForward_Name() };
			intelligentMobility.diagram.parsers.MessageFormatParser parser = new intelligentMobility.diagram.parsers.MessageFormatParser(
					features);
			forwardName_5010Parser = parser;
		}
		return forwardName_5010Parser;
	}

	/**
	* @generated
	*/
	private IParser lane_TypeName_5011Parser;

	/**
	* @generated
	*/
	private IParser getLane_TypeName_5011Parser() {
		if (lane_TypeName_5011Parser == null) {
			EAttribute[] features = new EAttribute[] {
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getLane_Type_Name() };
			intelligentMobility.diagram.parsers.MessageFormatParser parser = new intelligentMobility.diagram.parsers.MessageFormatParser(
					features);
			lane_TypeName_5011Parser = parser;
		}
		return lane_TypeName_5011Parser;
	}

	/**
	* @generated
	*/
	private IParser environment_BackgroundName_5012Parser;

	/**
	* @generated
	*/
	private IParser getEnvironment_BackgroundName_5012Parser() {
		if (environment_BackgroundName_5012Parser == null) {
			EAttribute[] features = new EAttribute[] {
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getEnvironment_Background_Name() };
			intelligentMobility.diagram.parsers.MessageFormatParser parser = new intelligentMobility.diagram.parsers.MessageFormatParser(
					features);
			environment_BackgroundName_5012Parser = parser;
		}
		return environment_BackgroundName_5012Parser;
	}

	/**
	* @generated
	*/
	private IParser turnName_5028Parser;

	/**
	* @generated
	*/
	private IParser getTurnName_5028Parser() {
		if (turnName_5028Parser == null) {
			EAttribute[] features = new EAttribute[] {
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getTurn_Name() };
			intelligentMobility.diagram.parsers.MessageFormatParser parser = new intelligentMobility.diagram.parsers.MessageFormatParser(
					features);
			turnName_5028Parser = parser;
		}
		return turnName_5028Parser;
	}

	/**
	* @generated
	*/
	private IParser laneChangingName_5013Parser;

	/**
	* @generated
	*/
	private IParser getLaneChangingName_5013Parser() {
		if (laneChangingName_5013Parser == null) {
			EAttribute[] features = new EAttribute[] {
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getLaneChanging_Name() };
			intelligentMobility.diagram.parsers.MessageFormatParser parser = new intelligentMobility.diagram.parsers.MessageFormatParser(
					features);
			laneChangingName_5013Parser = parser;
		}
		return laneChangingName_5013Parser;
	}

	/**
	* @generated
	*/
	private IParser driver_EmotionMetanlCondition_5014Parser;

	/**
	* @generated
	*/
	private IParser getDriver_EmotionMetanlCondition_5014Parser() {
		if (driver_EmotionMetanlCondition_5014Parser == null) {
			EAttribute[] features = new EAttribute[] {
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getDriver_Emotion_MetanlCondition() };
			intelligentMobility.diagram.parsers.MessageFormatParser parser = new intelligentMobility.diagram.parsers.MessageFormatParser(
					features);
			driver_EmotionMetanlCondition_5014Parser = parser;
		}
		return driver_EmotionMetanlCondition_5014Parser;
	}

	/**
	* @generated
	*/
	private IParser collisionName_5015Parser;

	/**
	* @generated
	*/
	private IParser getCollisionName_5015Parser() {
		if (collisionName_5015Parser == null) {
			EAttribute[] features = new EAttribute[] {
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getCollision_Name() };
			intelligentMobility.diagram.parsers.MessageFormatParser parser = new intelligentMobility.diagram.parsers.MessageFormatParser(
					features);
			collisionName_5015Parser = parser;
		}
		return collisionName_5015Parser;
	}

	/**
	* @generated
	*/
	private IParser followingName_5016Parser;

	/**
	* @generated
	*/
	private IParser getFollowingName_5016Parser() {
		if (followingName_5016Parser == null) {
			EAttribute[] features = new EAttribute[] {
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getFollowing_Name() };
			intelligentMobility.diagram.parsers.MessageFormatParser parser = new intelligentMobility.diagram.parsers.MessageFormatParser(
					features);
			followingName_5016Parser = parser;
		}
		return followingName_5016Parser;
	}

	/**
	* @generated
	*/
	private IParser gapAcceptanceName_5017Parser;

	/**
	* @generated
	*/
	private IParser getGapAcceptanceName_5017Parser() {
		if (gapAcceptanceName_5017Parser == null) {
			EAttribute[] features = new EAttribute[] {
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getGapAcceptance_Name() };
			intelligentMobility.diagram.parsers.MessageFormatParser parser = new intelligentMobility.diagram.parsers.MessageFormatParser(
					features);
			gapAcceptanceName_5017Parser = parser;
		}
		return gapAcceptanceName_5017Parser;
	}

	/**
	* @generated
	*/
	private IParser leading_VehicleName_5018Parser;

	/**
	* @generated
	*/
	private IParser getLeading_VehicleName_5018Parser() {
		if (leading_VehicleName_5018Parser == null) {
			EAttribute[] features = new EAttribute[] {
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getNormal_Vehicle_Name() };
			intelligentMobility.diagram.parsers.MessageFormatParser parser = new intelligentMobility.diagram.parsers.MessageFormatParser(
					features);
			leading_VehicleName_5018Parser = parser;
		}
		return leading_VehicleName_5018Parser;
	}

	/**
	* @generated
	*/
	private IParser backwardName_5019Parser;

	/**
	* @generated
	*/
	private IParser getBackwardName_5019Parser() {
		if (backwardName_5019Parser == null) {
			EAttribute[] features = new EAttribute[] {
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getBackward_Name() };
			intelligentMobility.diagram.parsers.MessageFormatParser parser = new intelligentMobility.diagram.parsers.MessageFormatParser(
					features);
			backwardName_5019Parser = parser;
		}
		return backwardName_5019Parser;
	}

	/**
	* @generated
	*/
	private IParser regulationLegislation_5020Parser;

	/**
	* @generated
	*/
	private IParser getRegulationLegislation_5020Parser() {
		if (regulationLegislation_5020Parser == null) {
			EAttribute[] features = new EAttribute[] {
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getRegulation_Legislation() };
			intelligentMobility.diagram.parsers.MessageFormatParser parser = new intelligentMobility.diagram.parsers.MessageFormatParser(
					features);
			regulationLegislation_5020Parser = parser;
		}
		return regulationLegislation_5020Parser;
	}

	/**
	* @generated
	*/
	private IParser traffic_SituationName_5021Parser;

	/**
	* @generated
	*/
	private IParser getTraffic_SituationName_5021Parser() {
		if (traffic_SituationName_5021Parser == null) {
			EAttribute[] features = new EAttribute[] {
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getTraffic_Situation_Name() };
			intelligentMobility.diagram.parsers.MessageFormatParser parser = new intelligentMobility.diagram.parsers.MessageFormatParser(
					features);
			traffic_SituationName_5021Parser = parser;
		}
		return traffic_SituationName_5021Parser;
	}

	/**
	* @generated
	*/
	private IParser driver_ProfileDriverName_5022Parser;

	/**
	* @generated
	*/
	private IParser getDriver_ProfileDriverName_5022Parser() {
		if (driver_ProfileDriverName_5022Parser == null) {
			EAttribute[] features = new EAttribute[] {
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getDriver_Profile_DriverName() };
			intelligentMobility.diagram.parsers.MessageFormatParser parser = new intelligentMobility.diagram.parsers.MessageFormatParser(
					features);
			driver_ProfileDriverName_5022Parser = parser;
		}
		return driver_ProfileDriverName_5022Parser;
	}

	/**
	* @generated
	*/
	private IParser safety_RequirementName_5023Parser;

	/**
	* @generated
	*/
	private IParser getSafety_RequirementName_5023Parser() {
		if (safety_RequirementName_5023Parser == null) {
			EAttribute[] features = new EAttribute[] {
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getSafety_Requirement_Name() };
			intelligentMobility.diagram.parsers.MessageFormatParser parser = new intelligentMobility.diagram.parsers.MessageFormatParser(
					features);
			safety_RequirementName_5023Parser = parser;
		}
		return safety_RequirementName_5023Parser;
	}

	/**
	* @generated
	*/
	private IParser driving_BehaviourName_5024Parser;

	/**
	* @generated
	*/
	private IParser getDriving_BehaviourName_5024Parser() {
		if (driving_BehaviourName_5024Parser == null) {
			EAttribute[] features = new EAttribute[] {
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getDriving_Behaviour_Name() };
			intelligentMobility.diagram.parsers.MessageFormatParser parser = new intelligentMobility.diagram.parsers.MessageFormatParser(
					features);
			driving_BehaviourName_5024Parser = parser;
		}
		return driving_BehaviourName_5024Parser;
	}

	/**
	* @generated
	*/
	private IParser following_VehicleName_5025Parser;

	/**
	* @generated
	*/
	private IParser getFollowing_VehicleName_5025Parser() {
		if (following_VehicleName_5025Parser == null) {
			EAttribute[] features = new EAttribute[] {
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getNormal_Vehicle_Name() };
			intelligentMobility.diagram.parsers.MessageFormatParser parser = new intelligentMobility.diagram.parsers.MessageFormatParser(
					features);
			following_VehicleName_5025Parser = parser;
		}
		return following_VehicleName_5025Parser;
	}

	/**
	* @generated
	*/
	private IParser abnormal_BehaviourName_5026Parser;

	/**
	* @generated
	*/
	private IParser getAbnormal_BehaviourName_5026Parser() {
		if (abnormal_BehaviourName_5026Parser == null) {
			EAttribute[] features = new EAttribute[] {
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getAbnormal_Behaviour_Name() };
			intelligentMobility.diagram.parsers.MessageFormatParser parser = new intelligentMobility.diagram.parsers.MessageFormatParser(
					features);
			abnormal_BehaviourName_5026Parser = parser;
		}
		return abnormal_BehaviourName_5026Parser;
	}

	/**
	* @generated
	*/
	private IParser goalGoalType_5027Parser;

	/**
	* @generated
	*/
	private IParser getGoalGoalType_5027Parser() {
		if (goalGoalType_5027Parser == null) {
			EAttribute[] features = new EAttribute[] {
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getGoal_GoalType() };
			intelligentMobility.diagram.parsers.MessageFormatParser parser = new intelligentMobility.diagram.parsers.MessageFormatParser(
					features);
			goalGoalType_5027Parser = parser;
		}
		return goalGoalType_5027Parser;
	}

	/**
	* @generated
	*/
	private IParser actionActionType_5030Parser;

	/**
	* @generated
	*/
	private IParser getActionActionType_5030Parser() {
		if (actionActionType_5030Parser == null) {
			EAttribute[] features = new EAttribute[] {
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getAction_ActionType() };
			intelligentMobility.diagram.parsers.MessageFormatParser parser = new intelligentMobility.diagram.parsers.MessageFormatParser(
					features);
			actionActionType_5030Parser = parser;
		}
		return actionActionType_5030Parser;
	}

	/**
	* @generated
	*/
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case intelligentMobility.diagram.edit.parts.Special_ConditionConditionNameEditPart.VISUAL_ID:
			return getSpecial_ConditionConditionName_5001Parser();
		case intelligentMobility.diagram.edit.parts.WeatherWeatherTypeEditPart.VISUAL_ID:
			return getWeatherWeatherType_5002Parser();
		case intelligentMobility.diagram.edit.parts.Traffic_LightNameEditPart.VISUAL_ID:
			return getTraffic_LightName_5031Parser();
		case intelligentMobility.diagram.edit.parts.Knowledge_and_SkillNameEditPart.VISUAL_ID:
			return getKnowledge_and_SkillName_5003Parser();
		case intelligentMobility.diagram.edit.parts.ObstructionNameEditPart.VISUAL_ID:
			return getObstructionName_5004Parser();
		case intelligentMobility.diagram.edit.parts.Driver_PreferenceName_PreferenceSetEditPart.VISUAL_ID:
			return getDriver_PreferenceName_PreferenceSet_5005Parser();
		case intelligentMobility.diagram.edit.parts.IntersectionNameEditPart.VISUAL_ID:
			return getIntersectionName_5006Parser();
		case intelligentMobility.diagram.edit.parts.Vehicle_ConfigurationBrandNameEditPart.VISUAL_ID:
			return getVehicle_ConfigurationBrandName_5007Parser();
		case intelligentMobility.diagram.edit.parts.Environment_ConditionName_EnvironmentConditiEditPart.VISUAL_ID:
			return getEnvironment_ConditionName_EnvironmentCondition_5008Parser();
		case intelligentMobility.diagram.edit.parts.PlatoonNameEditPart.VISUAL_ID:
			return getPlatoonName_5009Parser();
		case intelligentMobility.diagram.edit.parts.ForwardNameEditPart.VISUAL_ID:
			return getForwardName_5010Parser();
		case intelligentMobility.diagram.edit.parts.Lane_TypeNameEditPart.VISUAL_ID:
			return getLane_TypeName_5011Parser();
		case intelligentMobility.diagram.edit.parts.Environment_BackgroundNameEditPart.VISUAL_ID:
			return getEnvironment_BackgroundName_5012Parser();
		case intelligentMobility.diagram.edit.parts.TurnNameEditPart.VISUAL_ID:
			return getTurnName_5028Parser();
		case intelligentMobility.diagram.edit.parts.LaneChangingNameEditPart.VISUAL_ID:
			return getLaneChangingName_5013Parser();
		case intelligentMobility.diagram.edit.parts.Driver_EmotionMetanlConditionEditPart.VISUAL_ID:
			return getDriver_EmotionMetanlCondition_5014Parser();
		case intelligentMobility.diagram.edit.parts.CollisionNameEditPart.VISUAL_ID:
			return getCollisionName_5015Parser();
		case intelligentMobility.diagram.edit.parts.FollowingNameEditPart.VISUAL_ID:
			return getFollowingName_5016Parser();
		case intelligentMobility.diagram.edit.parts.GapAcceptanceNameEditPart.VISUAL_ID:
			return getGapAcceptanceName_5017Parser();
		case intelligentMobility.diagram.edit.parts.Leading_VehicleNameEditPart.VISUAL_ID:
			return getLeading_VehicleName_5018Parser();
		case intelligentMobility.diagram.edit.parts.BackwardNameEditPart.VISUAL_ID:
			return getBackwardName_5019Parser();
		case intelligentMobility.diagram.edit.parts.RegulationLegislationEditPart.VISUAL_ID:
			return getRegulationLegislation_5020Parser();
		case intelligentMobility.diagram.edit.parts.Traffic_SituationNameEditPart.VISUAL_ID:
			return getTraffic_SituationName_5021Parser();
		case intelligentMobility.diagram.edit.parts.Driver_ProfileDriverNameEditPart.VISUAL_ID:
			return getDriver_ProfileDriverName_5022Parser();
		case intelligentMobility.diagram.edit.parts.Safety_RequirementNameEditPart.VISUAL_ID:
			return getSafety_RequirementName_5023Parser();
		case intelligentMobility.diagram.edit.parts.Driving_BehaviourNameEditPart.VISUAL_ID:
			return getDriving_BehaviourName_5024Parser();
		case intelligentMobility.diagram.edit.parts.Following_VehicleNameEditPart.VISUAL_ID:
			return getFollowing_VehicleName_5025Parser();
		case intelligentMobility.diagram.edit.parts.Abnormal_BehaviourNameEditPart.VISUAL_ID:
			return getAbnormal_BehaviourName_5026Parser();
		case intelligentMobility.diagram.edit.parts.GoalGoalTypeEditPart.VISUAL_ID:
			return getGoalGoalType_5027Parser();
		case intelligentMobility.diagram.edit.parts.ActionActionTypeEditPart.VISUAL_ID:
			return getActionActionType_5030Parser();
		}
		return null;
	}

	/**
	* Utility method that consults ParserService
	* @generated
	*/
	public static IParser getParser(IElementType type, EObject object, String parserHint) {
		return ParserService.getInstance().getParser(new HintAdapter(type, object, parserHint));
	}

	/**
	* @generated
	*/
	public IParser getParser(IAdaptable hint) {
		String vid = (String) hint.getAdapter(String.class);
		if (vid != null) {
			return getParser(
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getVisualID(vid));
		}
		View view = (View) hint.getAdapter(View.class);
		if (view != null) {
			return getParser(
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getVisualID(view));
		}
		return null;
	}

	/**
	* @generated
	*/
	public boolean provides(IOperation operation) {
		if (operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation) operation).getHint();
			if (intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.getElement(hint) == null) {
				return false;
			}
			return getParser(hint) != null;
		}
		return false;
	}

	/**
	* @generated
	*/
	private static class HintAdapter extends ParserHintAdapter {

		/**
		* @generated
		*/
		private final IElementType elementType;

		/**
		* @generated
		*/
		public HintAdapter(IElementType type, EObject object, String parserHint) {
			super(object, parserHint);
			assert type != null;
			elementType = type;
		}

		/**
		* @generated
		*/
		public Object getAdapter(Class adapter) {
			if (IElementType.class.equals(adapter)) {
				return elementType;
			}
			return super.getAdapter(adapter);
		}
	}

}
