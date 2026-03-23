package intelligentMobility.diagram.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.structure.DiagramStructure;

/**
 * This registry is used to determine which type of visual object should be
 * created for the corresponding Diagram, Node, ChildNode or Link represented
 * by a domain model object.
 * 
 * @generated
 */
public class DrivingBehaviourMetamodelVisualIDRegistry {

	/**
	* @generated
	*/
	private static final String DEBUG_KEY = "DMB_ExtendedMetamodel.diagram/debug/visualID"; //$NON-NLS-1$

	/**
	* @generated
	*/
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (intelligentMobility.diagram.edit.parts.MobilitySystemEditPart.MODEL_ID.equals(view.getType())) {
				return intelligentMobility.diagram.edit.parts.MobilitySystemEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getVisualID(view.getType());
	}

	/**
	* @generated
	*/
	public static String getModelID(View view) {
		View diagram = view.getDiagram();
		while (view != diagram) {
			EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
			if (annotation != null) {
				return (String) annotation.getDetails().get("modelID"); //$NON-NLS-1$
			}
			view = (View) view.eContainer();
		}
		return diagram != null ? diagram.getType() : null;
	}

	/**
	* @generated
	*/
	public static int getVisualID(String type) {
		try {
			return Integer.parseInt(type);
		} catch (NumberFormatException e) {
			if (Boolean.TRUE.toString().equalsIgnoreCase(Platform.getDebugOption(DEBUG_KEY))) {
				intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin.getInstance()
						.logError("Unable to parse view type as a visualID number: " + type);
			}
		}
		return -1;
	}

	/**
	* @generated
	*/
	public static String getType(int visualID) {
		return Integer.toString(visualID);
	}

	/**
	* @generated
	*/
	public static int getDiagramVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getMobilitySystem().isSuperTypeOf(
				domainElement.eClass()) && isDiagram((intelligentMobility.MobilitySystem) domainElement)) {
			return intelligentMobility.diagram.edit.parts.MobilitySystemEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	* @generated
	*/
	public static int getNodeVisualID(View containerView, EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		String containerModelID = intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
				.getModelID(containerView);
		if (!intelligentMobility.diagram.edit.parts.MobilitySystemEditPart.MODEL_ID.equals(containerModelID)) {
			return -1;
		}
		int containerVisualID;
		if (intelligentMobility.diagram.edit.parts.MobilitySystemEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = intelligentMobility.diagram.edit.parts.MobilitySystemEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
		case intelligentMobility.diagram.edit.parts.MobilitySystemEditPart.VISUAL_ID:
			if (intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getSpecial_Condition()
					.isSuperTypeOf(domainElement.eClass())) {
				return intelligentMobility.diagram.edit.parts.Special_ConditionEditPart.VISUAL_ID;
			}
			if (intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getWeather()
					.isSuperTypeOf(domainElement.eClass())) {
				return intelligentMobility.diagram.edit.parts.WeatherEditPart.VISUAL_ID;
			}
			if (intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getTraffic_Light()
					.isSuperTypeOf(domainElement.eClass())) {
				return intelligentMobility.diagram.edit.parts.Traffic_LightEditPart.VISUAL_ID;
			}
			if (intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getKnowledge_and_Skill()
					.isSuperTypeOf(domainElement.eClass())) {
				return intelligentMobility.diagram.edit.parts.Knowledge_and_SkillEditPart.VISUAL_ID;
			}
			if (intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getObstruction()
					.isSuperTypeOf(domainElement.eClass())) {
				return intelligentMobility.diagram.edit.parts.ObstructionEditPart.VISUAL_ID;
			}
			if (intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getDriver_Preference()
					.isSuperTypeOf(domainElement.eClass())) {
				return intelligentMobility.diagram.edit.parts.Driver_PreferenceEditPart.VISUAL_ID;
			}
			if (intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getIntersection()
					.isSuperTypeOf(domainElement.eClass())) {
				return intelligentMobility.diagram.edit.parts.IntersectionEditPart.VISUAL_ID;
			}
			if (intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getVehicle_Configuration()
					.isSuperTypeOf(domainElement.eClass())) {
				return intelligentMobility.diagram.edit.parts.Vehicle_ConfigurationEditPart.VISUAL_ID;
			}
			if (intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getEnvironment_Condition()
					.isSuperTypeOf(domainElement.eClass())) {
				return intelligentMobility.diagram.edit.parts.Environment_ConditionEditPart.VISUAL_ID;
			}
			if (intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getPlatoon()
					.isSuperTypeOf(domainElement.eClass())) {
				return intelligentMobility.diagram.edit.parts.PlatoonEditPart.VISUAL_ID;
			}
			if (intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getForward()
					.isSuperTypeOf(domainElement.eClass())) {
				return intelligentMobility.diagram.edit.parts.ForwardEditPart.VISUAL_ID;
			}
			if (intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getLane_Type()
					.isSuperTypeOf(domainElement.eClass())) {
				return intelligentMobility.diagram.edit.parts.Lane_TypeEditPart.VISUAL_ID;
			}
			if (intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getEnvironment_Background()
					.isSuperTypeOf(domainElement.eClass())) {
				return intelligentMobility.diagram.edit.parts.Environment_BackgroundEditPart.VISUAL_ID;
			}
			if (intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getTurn()
					.isSuperTypeOf(domainElement.eClass())) {
				return intelligentMobility.diagram.edit.parts.TurnEditPart.VISUAL_ID;
			}
			if (intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getLaneChanging()
					.isSuperTypeOf(domainElement.eClass())) {
				return intelligentMobility.diagram.edit.parts.LaneChangingEditPart.VISUAL_ID;
			}
			if (intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getDriver_Emotion()
					.isSuperTypeOf(domainElement.eClass())) {
				return intelligentMobility.diagram.edit.parts.Driver_EmotionEditPart.VISUAL_ID;
			}
			if (intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getCollision()
					.isSuperTypeOf(domainElement.eClass())) {
				return intelligentMobility.diagram.edit.parts.CollisionEditPart.VISUAL_ID;
			}
			if (intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getPossibleVehicle()
					.isSuperTypeOf(domainElement.eClass())) {
				return intelligentMobility.diagram.edit.parts.PossibleVehicleEditPart.VISUAL_ID;
			}
			if (intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getFollowing()
					.isSuperTypeOf(domainElement.eClass())) {
				return intelligentMobility.diagram.edit.parts.FollowingEditPart.VISUAL_ID;
			}
			if (intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getGapAcceptance()
					.isSuperTypeOf(domainElement.eClass())) {
				return intelligentMobility.diagram.edit.parts.GapAcceptanceEditPart.VISUAL_ID;
			}
			if (intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getLeading_Vehicle()
					.isSuperTypeOf(domainElement.eClass())) {
				return intelligentMobility.diagram.edit.parts.Leading_VehicleEditPart.VISUAL_ID;
			}
			if (intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getBackward()
					.isSuperTypeOf(domainElement.eClass())) {
				return intelligentMobility.diagram.edit.parts.BackwardEditPart.VISUAL_ID;
			}
			if (intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getRegulation()
					.isSuperTypeOf(domainElement.eClass())) {
				return intelligentMobility.diagram.edit.parts.RegulationEditPart.VISUAL_ID;
			}
			if (intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getTraffic_Situation()
					.isSuperTypeOf(domainElement.eClass())) {
				return intelligentMobility.diagram.edit.parts.Traffic_SituationEditPart.VISUAL_ID;
			}
			if (intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getDriver_Profile()
					.isSuperTypeOf(domainElement.eClass())) {
				return intelligentMobility.diagram.edit.parts.Driver_ProfileEditPart.VISUAL_ID;
			}
			if (intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getSafety_Requirement()
					.isSuperTypeOf(domainElement.eClass())) {
				return intelligentMobility.diagram.edit.parts.Safety_RequirementEditPart.VISUAL_ID;
			}
			if (intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getDriving_Behaviour()
					.isSuperTypeOf(domainElement.eClass())) {
				return intelligentMobility.diagram.edit.parts.Driving_BehaviourEditPart.VISUAL_ID;
			}
			if (intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getFollowing_Vehicle()
					.isSuperTypeOf(domainElement.eClass())) {
				return intelligentMobility.diagram.edit.parts.Following_VehicleEditPart.VISUAL_ID;
			}
			if (intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getAbnormal_Behaviour()
					.isSuperTypeOf(domainElement.eClass())) {
				return intelligentMobility.diagram.edit.parts.Abnormal_BehaviourEditPart.VISUAL_ID;
			}
			if (intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getBackward()
					.isSuperTypeOf(domainElement.eClass())) {
				return intelligentMobility.diagram.edit.parts.Backward2EditPart.VISUAL_ID;
			}
			if (intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getIntersection()
					.isSuperTypeOf(domainElement.eClass())) {
				return intelligentMobility.diagram.edit.parts.Intersection2EditPart.VISUAL_ID;
			}
			if (intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getCommunicationInterface()
					.isSuperTypeOf(domainElement.eClass())) {
				return intelligentMobility.diagram.edit.parts.CommunicationInterfaceEditPart.VISUAL_ID;
			}
			if (intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getGoal()
					.isSuperTypeOf(domainElement.eClass())) {
				return intelligentMobility.diagram.edit.parts.GoalEditPart.VISUAL_ID;
			}
			if (intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getNormal_Behaviour()
					.isSuperTypeOf(domainElement.eClass())) {
				return intelligentMobility.diagram.edit.parts.Normal_BehaviourEditPart.VISUAL_ID;
			}
			if (intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getPlatoon()
					.isSuperTypeOf(domainElement.eClass())) {
				return intelligentMobility.diagram.edit.parts.Platoon2EditPart.VISUAL_ID;
			}
			if (intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getNormal_Vehicle()
					.isSuperTypeOf(domainElement.eClass())) {
				return intelligentMobility.diagram.edit.parts.Normal_VehicleEditPart.VISUAL_ID;
			}
			if (intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getCooperativeBehavior()
					.isSuperTypeOf(domainElement.eClass())) {
				return intelligentMobility.diagram.edit.parts.CooperativeBehaviorEditPart.VISUAL_ID;
			}
			if (intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getAction()
					.isSuperTypeOf(domainElement.eClass())) {
				return intelligentMobility.diagram.edit.parts.ActionEditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	* @generated
	*/
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
				.getModelID(containerView);
		if (!intelligentMobility.diagram.edit.parts.MobilitySystemEditPart.MODEL_ID.equals(containerModelID)) {
			return false;
		}
		int containerVisualID;
		if (intelligentMobility.diagram.edit.parts.MobilitySystemEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = intelligentMobility.diagram.edit.parts.MobilitySystemEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch (containerVisualID) {
		case intelligentMobility.diagram.edit.parts.MobilitySystemEditPart.VISUAL_ID:
			if (intelligentMobility.diagram.edit.parts.Special_ConditionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (intelligentMobility.diagram.edit.parts.WeatherEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (intelligentMobility.diagram.edit.parts.Traffic_LightEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (intelligentMobility.diagram.edit.parts.Knowledge_and_SkillEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (intelligentMobility.diagram.edit.parts.ObstructionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (intelligentMobility.diagram.edit.parts.Driver_PreferenceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (intelligentMobility.diagram.edit.parts.IntersectionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (intelligentMobility.diagram.edit.parts.Vehicle_ConfigurationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (intelligentMobility.diagram.edit.parts.Environment_ConditionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (intelligentMobility.diagram.edit.parts.PlatoonEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (intelligentMobility.diagram.edit.parts.ForwardEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (intelligentMobility.diagram.edit.parts.Lane_TypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (intelligentMobility.diagram.edit.parts.Environment_BackgroundEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (intelligentMobility.diagram.edit.parts.TurnEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (intelligentMobility.diagram.edit.parts.LaneChangingEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (intelligentMobility.diagram.edit.parts.Driver_EmotionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (intelligentMobility.diagram.edit.parts.CollisionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (intelligentMobility.diagram.edit.parts.PossibleVehicleEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (intelligentMobility.diagram.edit.parts.FollowingEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (intelligentMobility.diagram.edit.parts.GapAcceptanceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (intelligentMobility.diagram.edit.parts.Leading_VehicleEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (intelligentMobility.diagram.edit.parts.BackwardEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (intelligentMobility.diagram.edit.parts.RegulationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (intelligentMobility.diagram.edit.parts.Traffic_SituationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (intelligentMobility.diagram.edit.parts.Driver_ProfileEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (intelligentMobility.diagram.edit.parts.Safety_RequirementEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (intelligentMobility.diagram.edit.parts.Driving_BehaviourEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (intelligentMobility.diagram.edit.parts.Following_VehicleEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (intelligentMobility.diagram.edit.parts.Abnormal_BehaviourEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (intelligentMobility.diagram.edit.parts.Backward2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (intelligentMobility.diagram.edit.parts.Intersection2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (intelligentMobility.diagram.edit.parts.CommunicationInterfaceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (intelligentMobility.diagram.edit.parts.GoalEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (intelligentMobility.diagram.edit.parts.Normal_BehaviourEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (intelligentMobility.diagram.edit.parts.Platoon2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (intelligentMobility.diagram.edit.parts.Normal_VehicleEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (intelligentMobility.diagram.edit.parts.CooperativeBehaviorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (intelligentMobility.diagram.edit.parts.ActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case intelligentMobility.diagram.edit.parts.Special_ConditionEditPart.VISUAL_ID:
			if (intelligentMobility.diagram.edit.parts.Special_ConditionConditionNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case intelligentMobility.diagram.edit.parts.WeatherEditPart.VISUAL_ID:
			if (intelligentMobility.diagram.edit.parts.WeatherWeatherTypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case intelligentMobility.diagram.edit.parts.Traffic_LightEditPart.VISUAL_ID:
			if (intelligentMobility.diagram.edit.parts.Traffic_LightNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case intelligentMobility.diagram.edit.parts.Knowledge_and_SkillEditPart.VISUAL_ID:
			if (intelligentMobility.diagram.edit.parts.Knowledge_and_SkillNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case intelligentMobility.diagram.edit.parts.ObstructionEditPart.VISUAL_ID:
			if (intelligentMobility.diagram.edit.parts.ObstructionNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case intelligentMobility.diagram.edit.parts.Driver_PreferenceEditPart.VISUAL_ID:
			if (intelligentMobility.diagram.edit.parts.Driver_PreferenceName_PreferenceSetEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case intelligentMobility.diagram.edit.parts.IntersectionEditPart.VISUAL_ID:
			if (intelligentMobility.diagram.edit.parts.IntersectionNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case intelligentMobility.diagram.edit.parts.Vehicle_ConfigurationEditPart.VISUAL_ID:
			if (intelligentMobility.diagram.edit.parts.Vehicle_ConfigurationBrandNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case intelligentMobility.diagram.edit.parts.Environment_ConditionEditPart.VISUAL_ID:
			if (intelligentMobility.diagram.edit.parts.Environment_ConditionName_EnvironmentConditiEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case intelligentMobility.diagram.edit.parts.PlatoonEditPart.VISUAL_ID:
			if (intelligentMobility.diagram.edit.parts.PlatoonNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case intelligentMobility.diagram.edit.parts.ForwardEditPart.VISUAL_ID:
			if (intelligentMobility.diagram.edit.parts.ForwardNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case intelligentMobility.diagram.edit.parts.Lane_TypeEditPart.VISUAL_ID:
			if (intelligentMobility.diagram.edit.parts.Lane_TypeNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case intelligentMobility.diagram.edit.parts.Environment_BackgroundEditPart.VISUAL_ID:
			if (intelligentMobility.diagram.edit.parts.Environment_BackgroundNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case intelligentMobility.diagram.edit.parts.TurnEditPart.VISUAL_ID:
			if (intelligentMobility.diagram.edit.parts.TurnNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case intelligentMobility.diagram.edit.parts.LaneChangingEditPart.VISUAL_ID:
			if (intelligentMobility.diagram.edit.parts.LaneChangingNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case intelligentMobility.diagram.edit.parts.Driver_EmotionEditPart.VISUAL_ID:
			if (intelligentMobility.diagram.edit.parts.Driver_EmotionMetanlConditionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case intelligentMobility.diagram.edit.parts.CollisionEditPart.VISUAL_ID:
			if (intelligentMobility.diagram.edit.parts.CollisionNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case intelligentMobility.diagram.edit.parts.FollowingEditPart.VISUAL_ID:
			if (intelligentMobility.diagram.edit.parts.FollowingNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case intelligentMobility.diagram.edit.parts.GapAcceptanceEditPart.VISUAL_ID:
			if (intelligentMobility.diagram.edit.parts.GapAcceptanceNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case intelligentMobility.diagram.edit.parts.Leading_VehicleEditPart.VISUAL_ID:
			if (intelligentMobility.diagram.edit.parts.Leading_VehicleNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case intelligentMobility.diagram.edit.parts.BackwardEditPart.VISUAL_ID:
			if (intelligentMobility.diagram.edit.parts.BackwardNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case intelligentMobility.diagram.edit.parts.RegulationEditPart.VISUAL_ID:
			if (intelligentMobility.diagram.edit.parts.RegulationLegislationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case intelligentMobility.diagram.edit.parts.Traffic_SituationEditPart.VISUAL_ID:
			if (intelligentMobility.diagram.edit.parts.Traffic_SituationNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case intelligentMobility.diagram.edit.parts.Driver_ProfileEditPart.VISUAL_ID:
			if (intelligentMobility.diagram.edit.parts.Driver_ProfileDriverNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case intelligentMobility.diagram.edit.parts.Safety_RequirementEditPart.VISUAL_ID:
			if (intelligentMobility.diagram.edit.parts.Safety_RequirementNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case intelligentMobility.diagram.edit.parts.Driving_BehaviourEditPart.VISUAL_ID:
			if (intelligentMobility.diagram.edit.parts.Driving_BehaviourNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case intelligentMobility.diagram.edit.parts.Following_VehicleEditPart.VISUAL_ID:
			if (intelligentMobility.diagram.edit.parts.Following_VehicleNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case intelligentMobility.diagram.edit.parts.Abnormal_BehaviourEditPart.VISUAL_ID:
			if (intelligentMobility.diagram.edit.parts.Abnormal_BehaviourNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case intelligentMobility.diagram.edit.parts.GoalEditPart.VISUAL_ID:
			if (intelligentMobility.diagram.edit.parts.GoalGoalTypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case intelligentMobility.diagram.edit.parts.ActionEditPart.VISUAL_ID:
			if (intelligentMobility.diagram.edit.parts.ActionActionTypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		}
		return false;
	}

	/**
	* @generated
	*/
	public static int getLinkWithClassVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getLink_LaneType_Regulation()
				.isSuperTypeOf(domainElement.eClass())) {
			return intelligentMobility.diagram.edit.parts.Link_LaneType_RegulationEditPart.VISUAL_ID;
		}
		if (intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getLink_Driver_Vehicle()
				.isSuperTypeOf(domainElement.eClass())) {
			return intelligentMobility.diagram.edit.parts.Link_Driver_VehicleEditPart.VISUAL_ID;
		}
		if (intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getLink_EnvironmentBackground_PossibleVehicle()
				.isSuperTypeOf(domainElement.eClass())) {
			return intelligentMobility.diagram.edit.parts.Link_EnvironmentBackground_PossibleVehicleEditPart.VISUAL_ID;
		}
		if (intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getLink_Vehicle_Environment()
				.isSuperTypeOf(domainElement.eClass())) {
			return intelligentMobility.diagram.edit.parts.Link_Vehicle_EnvironmentEditPart.VISUAL_ID;
		}
		if (intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getLink_NormalVehicle_SafetyRequirements()
				.isSuperTypeOf(domainElement.eClass())) {
			return intelligentMobility.diagram.edit.parts.Link_NormalVehicle_SafetyRequirementsEditPart.VISUAL_ID;
		}
		if (intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getLink_DriverProfile_DriverPreference()
				.isSuperTypeOf(domainElement.eClass())) {
			return intelligentMobility.diagram.edit.parts.Link_DriverProfile_DriverPreferenceEditPart.VISUAL_ID;
		}
		if (intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getLink_Collision_Obstruction()
				.isSuperTypeOf(domainElement.eClass())) {
			return intelligentMobility.diagram.edit.parts.Link_Collision_ObstructionEditPart.VISUAL_ID;
		}
		if (intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getLink_Platoon_FollowingVehicle()
				.isSuperTypeOf(domainElement.eClass())) {
			return intelligentMobility.diagram.edit.parts.Link_Platoon_FollowingVehicleEditPart.VISUAL_ID;
		}
		if (intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getLink_DriverPreference_EnvironmentCondition()
				.isSuperTypeOf(domainElement.eClass())) {
			return intelligentMobility.diagram.edit.parts.Link_DriverPreference_EnvironmentConditionEditPart.VISUAL_ID;
		}
		if (intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getLink_AbnormalBehaviour_Action()
				.isSuperTypeOf(domainElement.eClass())) {
			return intelligentMobility.diagram.edit.parts.Link_AbnormalBehaviour_ActionEditPart.VISUAL_ID;
		}
		if (intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getLink_Following_Forward()
				.isSuperTypeOf(domainElement.eClass())) {
			return intelligentMobility.diagram.edit.parts.Link_Following_ForwardEditPart.VISUAL_ID;
		}
		if (intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getLink_EnvironmentCondition_LaneType()
				.isSuperTypeOf(domainElement.eClass())) {
			return intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_LaneTypeEditPart.VISUAL_ID;
		}
		if (intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getLink_VehicleConfiguration_VehicleType()
				.isSuperTypeOf(domainElement.eClass())) {
			return intelligentMobility.diagram.edit.parts.Link_VehicleConfiguration_VehicleTypeEditPart.VISUAL_ID;
		}
		if (intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getLink_Platoon_LeadingVehicle()
				.isSuperTypeOf(domainElement.eClass())) {
			return intelligentMobility.diagram.edit.parts.Link_Platoon_LeadingVehicleEditPart.VISUAL_ID;
		}
		if (intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getLink_Driver_Environment()
				.isSuperTypeOf(domainElement.eClass())) {
			return intelligentMobility.diagram.edit.parts.Link_Driver_EnvironmentEditPart.VISUAL_ID;
		}
		if (intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getLink_LaneChanging_Turn()
				.isSuperTypeOf(domainElement.eClass())) {
			return intelligentMobility.diagram.edit.parts.Link_LaneChanging_TurnEditPart.VISUAL_ID;
		}
		if (intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getLink_EnvironmentCondition_TrafficCondition()
				.isSuperTypeOf(domainElement.eClass())) {
			return intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_TrafficConditionEditPart.VISUAL_ID;
		}
		if (intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getLink_Intersection_TrafficLight()
				.isSuperTypeOf(domainElement.eClass())) {
			return intelligentMobility.diagram.edit.parts.Link_Intersection_TrafficLightEditPart.VISUAL_ID;
		}
		if (intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getLink_Following_MinGap()
				.isSuperTypeOf(domainElement.eClass())) {
			return intelligentMobility.diagram.edit.parts.Link_Following_MinGapEditPart.VISUAL_ID;
		}
		if (intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getLink_NormalBehaviour_LaneChanging()
				.isSuperTypeOf(domainElement.eClass())) {
			return intelligentMobility.diagram.edit.parts.Link_NormalBehaviour_LaneChangingEditPart.VISUAL_ID;
		}
		if (intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getLink_SafetyRequirement_Regulation()
				.isSuperTypeOf(domainElement.eClass())) {
			return intelligentMobility.diagram.edit.parts.Link_SafetyRequirement_RegulationEditPart.VISUAL_ID;
		}
		if (intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getLink_DriverPreference_DrivingBehaviour()
				.isSuperTypeOf(domainElement.eClass())) {
			return intelligentMobility.diagram.edit.parts.Link_DriverPreference_DrivingBehaviourEditPart.VISUAL_ID;
		}
		if (intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getLink_FollowingVehicle_FrontVehicle()
				.isSuperTypeOf(domainElement.eClass())) {
			return intelligentMobility.diagram.edit.parts.Link_FollowingVehicle_FrontVehicleEditPart.VISUAL_ID;
		}
		if (intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getLink_DriverPreference_DriverEmotion()
				.isSuperTypeOf(domainElement.eClass())) {
			return intelligentMobility.diagram.edit.parts.Link_DriverPreference_DriverEmotionEditPart.VISUAL_ID;
		}
		if (intelligentMobility.IntelligentMobilityPackage.eINSTANCE
				.getLink_EnvironmentBackground_EnvironmentCondition().isSuperTypeOf(domainElement.eClass())) {
			return intelligentMobility.diagram.edit.parts.Link_EnvironmentBackground_EnvironmentConditionEditPart.VISUAL_ID;
		}
		if (intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getLink_EnvironmentCondition_Weather()
				.isSuperTypeOf(domainElement.eClass())) {
			return intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_WeatherEditPart.VISUAL_ID;
		}
		if (intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getLink_EnvironmentCondition_SpecialCondition()
				.isSuperTypeOf(domainElement.eClass())) {
			return intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_SpecialConditionEditPart.VISUAL_ID;
		}
		if (intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getLink_SpecialCondition_Intersection()
				.isSuperTypeOf(domainElement.eClass())) {
			return intelligentMobility.diagram.edit.parts.Link_SpecialCondition_IntersectionEditPart.VISUAL_ID;
		}
		if (intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getLink_Following_Backward()
				.isSuperTypeOf(domainElement.eClass())) {
			return intelligentMobility.diagram.edit.parts.Link_Following_BackwardEditPart.VISUAL_ID;
		}
		if (intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getLink_EnvironmentCondition_Regulations()
				.isSuperTypeOf(domainElement.eClass())) {
			return intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_RegulationsEditPart.VISUAL_ID;
		}
		if (intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getLink_DrivingBehaviour_NormalBehaviour()
				.isSuperTypeOf(domainElement.eClass())) {
			return intelligentMobility.diagram.edit.parts.Link_DrivingBehaviour_NormalBehaviourEditPart.VISUAL_ID;
		}
		if (intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getLink_LaneChanging_EnvironmentCondition()
				.isSuperTypeOf(domainElement.eClass())) {
			return intelligentMobility.diagram.edit.parts.Link_LaneChanging_EnvironmentConditionEditPart.VISUAL_ID;
		}
		if (intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getLink_LaneChanging_GapAcceptance()
				.isSuperTypeOf(domainElement.eClass())) {
			return intelligentMobility.diagram.edit.parts.Link_LaneChanging_GapAcceptanceEditPart.VISUAL_ID;
		}
		if (intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getLink_NormalBehaviour_Following()
				.isSuperTypeOf(domainElement.eClass())) {
			return intelligentMobility.diagram.edit.parts.Link_NormalBehaviour_FollowingEditPart.VISUAL_ID;
		}
		if (intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getLink_Infrastructure_VehicleConfiguration()
				.isSuperTypeOf(domainElement.eClass())) {
			return intelligentMobility.diagram.edit.parts.Link_Infrastructure_VehicleConfigurationEditPart.VISUAL_ID;
		}
		if (intelligentMobility.IntelligentMobilityPackage.eINSTANCE
				.getLink_CommunicationInterface_VehicleConfiguration().isSuperTypeOf(domainElement.eClass())) {
			return intelligentMobility.diagram.edit.parts.Link_CommunicationInterface_VehicleConfigurationEditPart.VISUAL_ID;
		}
		if (intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getLink_Goal_DrivingBehaviour()
				.isSuperTypeOf(domainElement.eClass())) {
			return intelligentMobility.diagram.edit.parts.Link_Goal_DrivingBehaviourEditPart.VISUAL_ID;
		}
		if (intelligentMobility.IntelligentMobilityPackage.eINSTANCE
				.getLink_CooperativeBehaviour_CommunicationInterface().isSuperTypeOf(domainElement.eClass())) {
			return intelligentMobility.diagram.edit.parts.Link_CooperativeBehaviour_CommunicationInterfaceEditPart.VISUAL_ID;
		}
		if (intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getLink_CommunicationInterface_Infrastructure()
				.isSuperTypeOf(domainElement.eClass())) {
			return intelligentMobility.diagram.edit.parts.Link_CommunicationInterface_InfrastructureEditPart.VISUAL_ID;
		}
		if (intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getLink_CooperativeBehaviour_VehicleConfiguration()
				.isSuperTypeOf(domainElement.eClass())) {
			return intelligentMobility.diagram.edit.parts.Link_CooperativeBehaviour_VehicleConfigurationEditPart.VISUAL_ID;
		}
		if (intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getLink_TrafficSituation_EnvironmentCondition()
				.isSuperTypeOf(domainElement.eClass())) {
			return intelligentMobility.diagram.edit.parts.Link_TrafficSituation_EnvironmentConditionEditPart.VISUAL_ID;
		}
		if (intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getLink_Collision_SpecialCondition()
				.isSuperTypeOf(domainElement.eClass())) {
			return intelligentMobility.diagram.edit.parts.Link_Collision_SpecialConditionEditPart.VISUAL_ID;
		}
		if (intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getLink_Following_LaneChanging()
				.isSuperTypeOf(domainElement.eClass())) {
			return intelligentMobility.diagram.edit.parts.Link_Following_LaneChangingEditPart.VISUAL_ID;
		}
		if (intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getLink_Action_Backward()
				.isSuperTypeOf(domainElement.eClass())) {
			return intelligentMobility.diagram.edit.parts.Link_Action_BackwardEditPart.VISUAL_ID;
		}
		if (intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getLink_Action_Forward()
				.isSuperTypeOf(domainElement.eClass())) {
			return intelligentMobility.diagram.edit.parts.Link_Action_ForwardEditPart.VISUAL_ID;
		}
		if (intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getLink_Action_Turn()
				.isSuperTypeOf(domainElement.eClass())) {
			return intelligentMobility.diagram.edit.parts.Link_Action_TurnEditPart.VISUAL_ID;
		}
		if (intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getLink_KnowledgeAndSkill_DriverPreference()
				.isSuperTypeOf(domainElement.eClass())) {
			return intelligentMobility.diagram.edit.parts.Link_KnowledgeAndSkill_DriverPreferenceEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	* User can change implementation of this method to handle some specific
	* situations not covered by default logic.
	* 
	* @generated
	*/
	private static boolean isDiagram(intelligentMobility.MobilitySystem element) {
		return true;
	}

	/**
	* @generated
	*/
	public static boolean checkNodeVisualID(View containerView, EObject domainElement, int candidate) {
		if (candidate == -1) {
			//unrecognized id is always bad
			return false;
		}
		int basic = getNodeVisualID(containerView, domainElement);
		return basic == candidate;
	}

	/**
	* @generated
	*/
	public static boolean isCompartmentVisualID(int visualID) {
		return false;
	}

	/**
	* @generated
	*/
	public static boolean isSemanticLeafVisualID(int visualID) {
		switch (visualID) {
		case intelligentMobility.diagram.edit.parts.MobilitySystemEditPart.VISUAL_ID:
			return false;
		case intelligentMobility.diagram.edit.parts.Special_ConditionEditPart.VISUAL_ID:
		case intelligentMobility.diagram.edit.parts.WeatherEditPart.VISUAL_ID:
		case intelligentMobility.diagram.edit.parts.Traffic_LightEditPart.VISUAL_ID:
		case intelligentMobility.diagram.edit.parts.Knowledge_and_SkillEditPart.VISUAL_ID:
		case intelligentMobility.diagram.edit.parts.ObstructionEditPart.VISUAL_ID:
		case intelligentMobility.diagram.edit.parts.Driver_PreferenceEditPart.VISUAL_ID:
		case intelligentMobility.diagram.edit.parts.IntersectionEditPart.VISUAL_ID:
		case intelligentMobility.diagram.edit.parts.Vehicle_ConfigurationEditPart.VISUAL_ID:
		case intelligentMobility.diagram.edit.parts.Environment_ConditionEditPart.VISUAL_ID:
		case intelligentMobility.diagram.edit.parts.PlatoonEditPart.VISUAL_ID:
		case intelligentMobility.diagram.edit.parts.ForwardEditPart.VISUAL_ID:
		case intelligentMobility.diagram.edit.parts.Lane_TypeEditPart.VISUAL_ID:
		case intelligentMobility.diagram.edit.parts.Environment_BackgroundEditPart.VISUAL_ID:
		case intelligentMobility.diagram.edit.parts.TurnEditPart.VISUAL_ID:
		case intelligentMobility.diagram.edit.parts.LaneChangingEditPart.VISUAL_ID:
		case intelligentMobility.diagram.edit.parts.Driver_EmotionEditPart.VISUAL_ID:
		case intelligentMobility.diagram.edit.parts.CollisionEditPart.VISUAL_ID:
		case intelligentMobility.diagram.edit.parts.PossibleVehicleEditPart.VISUAL_ID:
		case intelligentMobility.diagram.edit.parts.FollowingEditPart.VISUAL_ID:
		case intelligentMobility.diagram.edit.parts.GapAcceptanceEditPart.VISUAL_ID:
		case intelligentMobility.diagram.edit.parts.Leading_VehicleEditPart.VISUAL_ID:
		case intelligentMobility.diagram.edit.parts.BackwardEditPart.VISUAL_ID:
		case intelligentMobility.diagram.edit.parts.RegulationEditPart.VISUAL_ID:
		case intelligentMobility.diagram.edit.parts.Traffic_SituationEditPart.VISUAL_ID:
		case intelligentMobility.diagram.edit.parts.Driver_ProfileEditPart.VISUAL_ID:
		case intelligentMobility.diagram.edit.parts.Safety_RequirementEditPart.VISUAL_ID:
		case intelligentMobility.diagram.edit.parts.Driving_BehaviourEditPart.VISUAL_ID:
		case intelligentMobility.diagram.edit.parts.Following_VehicleEditPart.VISUAL_ID:
		case intelligentMobility.diagram.edit.parts.Abnormal_BehaviourEditPart.VISUAL_ID:
		case intelligentMobility.diagram.edit.parts.Backward2EditPart.VISUAL_ID:
		case intelligentMobility.diagram.edit.parts.Intersection2EditPart.VISUAL_ID:
		case intelligentMobility.diagram.edit.parts.CommunicationInterfaceEditPart.VISUAL_ID:
		case intelligentMobility.diagram.edit.parts.GoalEditPart.VISUAL_ID:
		case intelligentMobility.diagram.edit.parts.Normal_BehaviourEditPart.VISUAL_ID:
		case intelligentMobility.diagram.edit.parts.Platoon2EditPart.VISUAL_ID:
		case intelligentMobility.diagram.edit.parts.Normal_VehicleEditPart.VISUAL_ID:
		case intelligentMobility.diagram.edit.parts.CooperativeBehaviorEditPart.VISUAL_ID:
		case intelligentMobility.diagram.edit.parts.ActionEditPart.VISUAL_ID:
			return true;
		default:
			break;
		}
		return false;
	}

	/**
	* @generated
	*/
	public static final DiagramStructure TYPED_INSTANCE = new DiagramStructure() {
		/**
		* @generated
		*/

		public int getVisualID(View view) {
			return intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getVisualID(view);
		}

		/**
		* @generated
		*/

		public String getModelID(View view) {
			return intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getModelID(view);
		}

		/**
		* @generated
		*/

		public int getNodeVisualID(View containerView, EObject domainElement) {
			return intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getNodeVisualID(containerView, domainElement);
		}

		/**
		* @generated
		*/

		public boolean checkNodeVisualID(View containerView, EObject domainElement, int candidate) {
			return intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.checkNodeVisualID(containerView, domainElement, candidate);
		}

		/**
		* @generated
		*/

		public boolean isCompartmentVisualID(int visualID) {
			return intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.isCompartmentVisualID(visualID);
		}

		/**
		* @generated
		*/

		public boolean isSemanticLeafVisualID(int visualID) {
			return intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.isSemanticLeafVisualID(visualID);
		}
	};

}
