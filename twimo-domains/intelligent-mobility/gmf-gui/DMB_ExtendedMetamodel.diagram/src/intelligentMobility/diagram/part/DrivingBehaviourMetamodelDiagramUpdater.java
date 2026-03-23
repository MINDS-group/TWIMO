package intelligentMobility.diagram.part;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class DrivingBehaviourMetamodelDiagramUpdater {

	/**
	* @generated
	*/
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelNodeDescriptor]*/ getSemanticChildren(
			View view) {
		switch (intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getVisualID(view)) {
		case intelligentMobility.diagram.edit.parts.MobilitySystemEditPart.VISUAL_ID:
			return getMobilitySystem_1000SemanticChildren(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	* @generated
	*/
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelNodeDescriptor]*/ getMobilitySystem_1000SemanticChildren(
			View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		intelligentMobility.MobilitySystem modelElement = (intelligentMobility.MobilitySystem) view.getElement();
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelNodeDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelNodeDescriptor]*/();
		for (Iterator /*[?]*/ it = modelElement.getSpecial_condition().iterator(); it.hasNext();) {
			intelligentMobility.Special_Condition childElement = (intelligentMobility.Special_Condition) it.next();
			int visualID = intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == intelligentMobility.diagram.edit.parts.Special_ConditionEditPart.VISUAL_ID) {
				result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelNodeDescriptor(childElement,
						visualID));
				continue;
			}
		}
		for (Iterator /*[?]*/ it = modelElement.getWeather().iterator(); it.hasNext();) {
			intelligentMobility.Weather childElement = (intelligentMobility.Weather) it.next();
			int visualID = intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == intelligentMobility.diagram.edit.parts.WeatherEditPart.VISUAL_ID) {
				result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelNodeDescriptor(childElement,
						visualID));
				continue;
			}
		}
		for (Iterator /*[?]*/ it = modelElement.getTraffic_light().iterator(); it.hasNext();) {
			intelligentMobility.Traffic_Light childElement = (intelligentMobility.Traffic_Light) it.next();
			int visualID = intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == intelligentMobility.diagram.edit.parts.Traffic_LightEditPart.VISUAL_ID) {
				result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelNodeDescriptor(childElement,
						visualID));
				continue;
			}
		}
		for (Iterator /*[?]*/ it = modelElement.getKnowledge_and_skill().iterator(); it.hasNext();) {
			intelligentMobility.Knowledge_and_Skill childElement = (intelligentMobility.Knowledge_and_Skill) it.next();
			int visualID = intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == intelligentMobility.diagram.edit.parts.Knowledge_and_SkillEditPart.VISUAL_ID) {
				result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelNodeDescriptor(childElement,
						visualID));
				continue;
			}
		}
		for (Iterator /*[?]*/ it = modelElement.getObstruction().iterator(); it.hasNext();) {
			intelligentMobility.Obstruction childElement = (intelligentMobility.Obstruction) it.next();
			int visualID = intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == intelligentMobility.diagram.edit.parts.ObstructionEditPart.VISUAL_ID) {
				result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelNodeDescriptor(childElement,
						visualID));
				continue;
			}
		}
		for (Iterator /*[?]*/ it = modelElement.getDriver_preference().iterator(); it.hasNext();) {
			intelligentMobility.Driver_Preference childElement = (intelligentMobility.Driver_Preference) it.next();
			int visualID = intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == intelligentMobility.diagram.edit.parts.Driver_PreferenceEditPart.VISUAL_ID) {
				result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelNodeDescriptor(childElement,
						visualID));
				continue;
			}
		}
		for (Iterator /*[?]*/ it = modelElement.getIntersection().iterator(); it.hasNext();) {
			intelligentMobility.Intersection childElement = (intelligentMobility.Intersection) it.next();
			int visualID = intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == intelligentMobility.diagram.edit.parts.IntersectionEditPart.VISUAL_ID) {
				result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelNodeDescriptor(childElement,
						visualID));
				continue;
			}
		}
		for (Iterator /*[?]*/ it = modelElement.getVehicle_configuration().iterator(); it.hasNext();) {
			intelligentMobility.Vehicle_Configuration childElement = (intelligentMobility.Vehicle_Configuration) it
					.next();
			int visualID = intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == intelligentMobility.diagram.edit.parts.Vehicle_ConfigurationEditPart.VISUAL_ID) {
				result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelNodeDescriptor(childElement,
						visualID));
				continue;
			}
		}
		for (Iterator /*[?]*/ it = modelElement.getEnvironment_condition().iterator(); it.hasNext();) {
			intelligentMobility.Environment_Condition childElement = (intelligentMobility.Environment_Condition) it
					.next();
			int visualID = intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == intelligentMobility.diagram.edit.parts.Environment_ConditionEditPart.VISUAL_ID) {
				result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelNodeDescriptor(childElement,
						visualID));
				continue;
			}
		}
		for (Iterator /*[?]*/ it = modelElement.getPlatoon().iterator(); it.hasNext();) {
			intelligentMobility.Platoon childElement = (intelligentMobility.Platoon) it.next();
			int visualID = intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == intelligentMobility.diagram.edit.parts.PlatoonEditPart.VISUAL_ID) {
				result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelNodeDescriptor(childElement,
						visualID));
				continue;
			}
		}
		for (Iterator /*[?]*/ it = modelElement.getForward().iterator(); it.hasNext();) {
			intelligentMobility.Forward childElement = (intelligentMobility.Forward) it.next();
			int visualID = intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == intelligentMobility.diagram.edit.parts.ForwardEditPart.VISUAL_ID) {
				result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelNodeDescriptor(childElement,
						visualID));
				continue;
			}
		}
		for (Iterator /*[?]*/ it = modelElement.getLane_type().iterator(); it.hasNext();) {
			intelligentMobility.Lane_Type childElement = (intelligentMobility.Lane_Type) it.next();
			int visualID = intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == intelligentMobility.diagram.edit.parts.Lane_TypeEditPart.VISUAL_ID) {
				result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelNodeDescriptor(childElement,
						visualID));
				continue;
			}
		}
		for (Iterator /*[?]*/ it = modelElement.getEnvironment_background().iterator(); it.hasNext();) {
			intelligentMobility.Environment_Background childElement = (intelligentMobility.Environment_Background) it
					.next();
			int visualID = intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == intelligentMobility.diagram.edit.parts.Environment_BackgroundEditPart.VISUAL_ID) {
				result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelNodeDescriptor(childElement,
						visualID));
				continue;
			}
		}
		for (Iterator /*[?]*/ it = modelElement.getTurn().iterator(); it.hasNext();) {
			intelligentMobility.Turn childElement = (intelligentMobility.Turn) it.next();
			int visualID = intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == intelligentMobility.diagram.edit.parts.TurnEditPart.VISUAL_ID) {
				result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelNodeDescriptor(childElement,
						visualID));
				continue;
			}
		}
		for (Iterator /*[?]*/ it = modelElement.getLane_changing().iterator(); it.hasNext();) {
			intelligentMobility.LaneChanging childElement = (intelligentMobility.LaneChanging) it.next();
			int visualID = intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == intelligentMobility.diagram.edit.parts.LaneChangingEditPart.VISUAL_ID) {
				result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelNodeDescriptor(childElement,
						visualID));
				continue;
			}
		}
		for (Iterator /*[?]*/ it = modelElement.getDriver_emotion().iterator(); it.hasNext();) {
			intelligentMobility.Driver_Emotion childElement = (intelligentMobility.Driver_Emotion) it.next();
			int visualID = intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == intelligentMobility.diagram.edit.parts.Driver_EmotionEditPart.VISUAL_ID) {
				result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelNodeDescriptor(childElement,
						visualID));
				continue;
			}
		}
		for (Iterator /*[?]*/ it = modelElement.getCollision().iterator(); it.hasNext();) {
			intelligentMobility.Collision childElement = (intelligentMobility.Collision) it.next();
			int visualID = intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == intelligentMobility.diagram.edit.parts.CollisionEditPart.VISUAL_ID) {
				result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelNodeDescriptor(childElement,
						visualID));
				continue;
			}
		}
		for (Iterator /*[?]*/ it = modelElement.getPossible_vehicle().iterator(); it.hasNext();) {
			intelligentMobility.PossibleVehicle childElement = (intelligentMobility.PossibleVehicle) it.next();
			int visualID = intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == intelligentMobility.diagram.edit.parts.PossibleVehicleEditPart.VISUAL_ID) {
				result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelNodeDescriptor(childElement,
						visualID));
				continue;
			}
		}
		for (Iterator /*[?]*/ it = modelElement.getFollowing().iterator(); it.hasNext();) {
			intelligentMobility.Following childElement = (intelligentMobility.Following) it.next();
			int visualID = intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == intelligentMobility.diagram.edit.parts.FollowingEditPart.VISUAL_ID) {
				result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelNodeDescriptor(childElement,
						visualID));
				continue;
			}
		}
		for (Iterator /*[?]*/ it = modelElement.getGap_acceptance().iterator(); it.hasNext();) {
			intelligentMobility.GapAcceptance childElement = (intelligentMobility.GapAcceptance) it.next();
			int visualID = intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == intelligentMobility.diagram.edit.parts.GapAcceptanceEditPart.VISUAL_ID) {
				result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelNodeDescriptor(childElement,
						visualID));
				continue;
			}
		}
		for (Iterator /*[?]*/ it = modelElement.getLeading_vehicle().iterator(); it.hasNext();) {
			intelligentMobility.Leading_Vehicle childElement = (intelligentMobility.Leading_Vehicle) it.next();
			int visualID = intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == intelligentMobility.diagram.edit.parts.Leading_VehicleEditPart.VISUAL_ID) {
				result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelNodeDescriptor(childElement,
						visualID));
				continue;
			}
		}
		for (Iterator /*[?]*/ it = modelElement.getBackward().iterator(); it.hasNext();) {
			intelligentMobility.Backward childElement = (intelligentMobility.Backward) it.next();
			int visualID = intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == intelligentMobility.diagram.edit.parts.BackwardEditPart.VISUAL_ID) {
				result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelNodeDescriptor(childElement,
						visualID));
				continue;
			}
		}
		for (Iterator /*[?]*/ it = modelElement.getRegulation().iterator(); it.hasNext();) {
			intelligentMobility.Regulation childElement = (intelligentMobility.Regulation) it.next();
			int visualID = intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == intelligentMobility.diagram.edit.parts.RegulationEditPart.VISUAL_ID) {
				result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelNodeDescriptor(childElement,
						visualID));
				continue;
			}
		}
		for (Iterator /*[?]*/ it = modelElement.getTraffic_situation().iterator(); it.hasNext();) {
			intelligentMobility.Traffic_Situation childElement = (intelligentMobility.Traffic_Situation) it.next();
			int visualID = intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == intelligentMobility.diagram.edit.parts.Traffic_SituationEditPart.VISUAL_ID) {
				result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelNodeDescriptor(childElement,
						visualID));
				continue;
			}
		}
		for (Iterator /*[?]*/ it = modelElement.getDriver_profile().iterator(); it.hasNext();) {
			intelligentMobility.Driver_Profile childElement = (intelligentMobility.Driver_Profile) it.next();
			int visualID = intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == intelligentMobility.diagram.edit.parts.Driver_ProfileEditPart.VISUAL_ID) {
				result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelNodeDescriptor(childElement,
						visualID));
				continue;
			}
		}
		for (Iterator /*[?]*/ it = modelElement.getSafety_requirement().iterator(); it.hasNext();) {
			intelligentMobility.Safety_Requirement childElement = (intelligentMobility.Safety_Requirement) it.next();
			int visualID = intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == intelligentMobility.diagram.edit.parts.Safety_RequirementEditPart.VISUAL_ID) {
				result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelNodeDescriptor(childElement,
						visualID));
				continue;
			}
		}
		for (Iterator /*[?]*/ it = modelElement.getDriving_behaviour().iterator(); it.hasNext();) {
			intelligentMobility.Driving_Behaviour childElement = (intelligentMobility.Driving_Behaviour) it.next();
			int visualID = intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == intelligentMobility.diagram.edit.parts.Driving_BehaviourEditPart.VISUAL_ID) {
				result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelNodeDescriptor(childElement,
						visualID));
				continue;
			}
		}
		for (Iterator /*[?]*/ it = modelElement.getFollowing_vehicle().iterator(); it.hasNext();) {
			intelligentMobility.Following_Vehicle childElement = (intelligentMobility.Following_Vehicle) it.next();
			int visualID = intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == intelligentMobility.diagram.edit.parts.Following_VehicleEditPart.VISUAL_ID) {
				result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelNodeDescriptor(childElement,
						visualID));
				continue;
			}
		}
		for (Iterator /*[?]*/ it = modelElement.getAbnormal_behaviour().iterator(); it.hasNext();) {
			intelligentMobility.Abnormal_Behaviour childElement = (intelligentMobility.Abnormal_Behaviour) it.next();
			int visualID = intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == intelligentMobility.diagram.edit.parts.Abnormal_BehaviourEditPart.VISUAL_ID) {
				result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelNodeDescriptor(childElement,
						visualID));
				continue;
			}
		}
		for (Iterator /*[?]*/ it = modelElement.getAction().iterator(); it.hasNext();) {
			intelligentMobility.Action childElement = (intelligentMobility.Action) it.next();
			int visualID = intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == intelligentMobility.diagram.edit.parts.Backward2EditPart.VISUAL_ID) {
				result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelNodeDescriptor(childElement,
						visualID));
				continue;
			}
			if (visualID == intelligentMobility.diagram.edit.parts.ActionEditPart.VISUAL_ID) {
				result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelNodeDescriptor(childElement,
						visualID));
				continue;
			}
		}
		for (Iterator /*[?]*/ it = modelElement.getInfrastructure().iterator(); it.hasNext();) {
			intelligentMobility.Infrastructure childElement = (intelligentMobility.Infrastructure) it.next();
			int visualID = intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == intelligentMobility.diagram.edit.parts.Intersection2EditPart.VISUAL_ID) {
				result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelNodeDescriptor(childElement,
						visualID));
				continue;
			}
		}
		for (Iterator /*[?]*/ it = modelElement.getCommunicationInterfaces().iterator(); it.hasNext();) {
			intelligentMobility.CommunicationInterface childElement = (intelligentMobility.CommunicationInterface) it
					.next();
			int visualID = intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == intelligentMobility.diagram.edit.parts.CommunicationInterfaceEditPart.VISUAL_ID) {
				result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelNodeDescriptor(childElement,
						visualID));
				continue;
			}
		}
		for (Iterator /*[?]*/ it = modelElement.getGoal().iterator(); it.hasNext();) {
			intelligentMobility.Goal childElement = (intelligentMobility.Goal) it.next();
			int visualID = intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == intelligentMobility.diagram.edit.parts.GoalEditPart.VISUAL_ID) {
				result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelNodeDescriptor(childElement,
						visualID));
				continue;
			}
		}
		for (Iterator /*[?]*/ it = modelElement.getNormal_behaviour().iterator(); it.hasNext();) {
			intelligentMobility.Normal_Behaviour childElement = (intelligentMobility.Normal_Behaviour) it.next();
			int visualID = intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == intelligentMobility.diagram.edit.parts.Normal_BehaviourEditPart.VISUAL_ID) {
				result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelNodeDescriptor(childElement,
						visualID));
				continue;
			}
		}
		for (Iterator /*[?]*/ it = modelElement.getVehicle_type().iterator(); it.hasNext();) {
			intelligentMobility.Vehicle_Type childElement = (intelligentMobility.Vehicle_Type) it.next();
			int visualID = intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == intelligentMobility.diagram.edit.parts.Platoon2EditPart.VISUAL_ID) {
				result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelNodeDescriptor(childElement,
						visualID));
				continue;
			}
		}
		for (Iterator /*[?]*/ it = modelElement.getNormal_vehicle().iterator(); it.hasNext();) {
			intelligentMobility.Normal_Vehicle childElement = (intelligentMobility.Normal_Vehicle) it.next();
			int visualID = intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == intelligentMobility.diagram.edit.parts.Normal_VehicleEditPart.VISUAL_ID) {
				result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelNodeDescriptor(childElement,
						visualID));
				continue;
			}
		}
		for (Iterator /*[?]*/ it = modelElement.getCooperativeBehaviour().iterator(); it.hasNext();) {
			intelligentMobility.CooperativeBehavior childElement = (intelligentMobility.CooperativeBehavior) it.next();
			int visualID = intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == intelligentMobility.diagram.edit.parts.CooperativeBehaviorEditPart.VISUAL_ID) {
				result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelNodeDescriptor(childElement,
						visualID));
				continue;
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getContainedLinks(
			View view) {
		switch (intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getVisualID(view)) {
		case intelligentMobility.diagram.edit.parts.MobilitySystemEditPart.VISUAL_ID:
			return getMobilitySystem_1000ContainedLinks(view);
		case intelligentMobility.diagram.edit.parts.Special_ConditionEditPart.VISUAL_ID:
			return getSpecial_Condition_2001ContainedLinks(view);
		case intelligentMobility.diagram.edit.parts.WeatherEditPart.VISUAL_ID:
			return getWeather_2002ContainedLinks(view);
		case intelligentMobility.diagram.edit.parts.Traffic_LightEditPart.VISUAL_ID:
			return getTraffic_Light_2003ContainedLinks(view);
		case intelligentMobility.diagram.edit.parts.Knowledge_and_SkillEditPart.VISUAL_ID:
			return getKnowledge_and_Skill_2004ContainedLinks(view);
		case intelligentMobility.diagram.edit.parts.ObstructionEditPart.VISUAL_ID:
			return getObstruction_2005ContainedLinks(view);
		case intelligentMobility.diagram.edit.parts.Driver_PreferenceEditPart.VISUAL_ID:
			return getDriver_Preference_2006ContainedLinks(view);
		case intelligentMobility.diagram.edit.parts.IntersectionEditPart.VISUAL_ID:
			return getIntersection_2007ContainedLinks(view);
		case intelligentMobility.diagram.edit.parts.Vehicle_ConfigurationEditPart.VISUAL_ID:
			return getVehicle_Configuration_2008ContainedLinks(view);
		case intelligentMobility.diagram.edit.parts.Environment_ConditionEditPart.VISUAL_ID:
			return getEnvironment_Condition_2009ContainedLinks(view);
		case intelligentMobility.diagram.edit.parts.PlatoonEditPart.VISUAL_ID:
			return getPlatoon_2010ContainedLinks(view);
		case intelligentMobility.diagram.edit.parts.ForwardEditPart.VISUAL_ID:
			return getForward_2011ContainedLinks(view);
		case intelligentMobility.diagram.edit.parts.Lane_TypeEditPart.VISUAL_ID:
			return getLane_Type_2012ContainedLinks(view);
		case intelligentMobility.diagram.edit.parts.Environment_BackgroundEditPart.VISUAL_ID:
			return getEnvironment_Background_2013ContainedLinks(view);
		case intelligentMobility.diagram.edit.parts.TurnEditPart.VISUAL_ID:
			return getTurn_2014ContainedLinks(view);
		case intelligentMobility.diagram.edit.parts.LaneChangingEditPart.VISUAL_ID:
			return getLaneChanging_2015ContainedLinks(view);
		case intelligentMobility.diagram.edit.parts.Driver_EmotionEditPart.VISUAL_ID:
			return getDriver_Emotion_2016ContainedLinks(view);
		case intelligentMobility.diagram.edit.parts.CollisionEditPart.VISUAL_ID:
			return getCollision_2017ContainedLinks(view);
		case intelligentMobility.diagram.edit.parts.PossibleVehicleEditPart.VISUAL_ID:
			return getPossibleVehicle_2018ContainedLinks(view);
		case intelligentMobility.diagram.edit.parts.FollowingEditPart.VISUAL_ID:
			return getFollowing_2019ContainedLinks(view);
		case intelligentMobility.diagram.edit.parts.GapAcceptanceEditPart.VISUAL_ID:
			return getGapAcceptance_2020ContainedLinks(view);
		case intelligentMobility.diagram.edit.parts.Leading_VehicleEditPart.VISUAL_ID:
			return getLeading_Vehicle_2021ContainedLinks(view);
		case intelligentMobility.diagram.edit.parts.BackwardEditPart.VISUAL_ID:
			return getBackward_2022ContainedLinks(view);
		case intelligentMobility.diagram.edit.parts.RegulationEditPart.VISUAL_ID:
			return getRegulation_2023ContainedLinks(view);
		case intelligentMobility.diagram.edit.parts.Traffic_SituationEditPart.VISUAL_ID:
			return getTraffic_Situation_2024ContainedLinks(view);
		case intelligentMobility.diagram.edit.parts.Driver_ProfileEditPart.VISUAL_ID:
			return getDriver_Profile_2025ContainedLinks(view);
		case intelligentMobility.diagram.edit.parts.Safety_RequirementEditPart.VISUAL_ID:
			return getSafety_Requirement_2026ContainedLinks(view);
		case intelligentMobility.diagram.edit.parts.Driving_BehaviourEditPart.VISUAL_ID:
			return getDriving_Behaviour_2027ContainedLinks(view);
		case intelligentMobility.diagram.edit.parts.Following_VehicleEditPart.VISUAL_ID:
			return getFollowing_Vehicle_2028ContainedLinks(view);
		case intelligentMobility.diagram.edit.parts.Abnormal_BehaviourEditPart.VISUAL_ID:
			return getAbnormal_Behaviour_2029ContainedLinks(view);
		case intelligentMobility.diagram.edit.parts.Backward2EditPart.VISUAL_ID:
			return getBackward_2030ContainedLinks(view);
		case intelligentMobility.diagram.edit.parts.Intersection2EditPart.VISUAL_ID:
			return getIntersection_2031ContainedLinks(view);
		case intelligentMobility.diagram.edit.parts.CommunicationInterfaceEditPart.VISUAL_ID:
			return getCommunicationInterface_2032ContainedLinks(view);
		case intelligentMobility.diagram.edit.parts.GoalEditPart.VISUAL_ID:
			return getGoal_2033ContainedLinks(view);
		case intelligentMobility.diagram.edit.parts.Normal_BehaviourEditPart.VISUAL_ID:
			return getNormal_Behaviour_2034ContainedLinks(view);
		case intelligentMobility.diagram.edit.parts.Platoon2EditPart.VISUAL_ID:
			return getPlatoon_2035ContainedLinks(view);
		case intelligentMobility.diagram.edit.parts.Normal_VehicleEditPart.VISUAL_ID:
			return getNormal_Vehicle_2036ContainedLinks(view);
		case intelligentMobility.diagram.edit.parts.CooperativeBehaviorEditPart.VISUAL_ID:
			return getCooperativeBehavior_2037ContainedLinks(view);
		case intelligentMobility.diagram.edit.parts.ActionEditPart.VISUAL_ID:
			return getAction_2039ContainedLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_LaneType_RegulationEditPart.VISUAL_ID:
			return getLink_LaneType_Regulation_4001ContainedLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_Driver_VehicleEditPart.VISUAL_ID:
			return getLink_Driver_Vehicle_4002ContainedLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_EnvironmentBackground_PossibleVehicleEditPart.VISUAL_ID:
			return getLink_EnvironmentBackground_PossibleVehicle_4003ContainedLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_Vehicle_EnvironmentEditPart.VISUAL_ID:
			return getLink_Vehicle_Environment_4004ContainedLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_NormalVehicle_SafetyRequirementsEditPart.VISUAL_ID:
			return getLink_NormalVehicle_SafetyRequirements_4005ContainedLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_DriverProfile_DriverPreferenceEditPart.VISUAL_ID:
			return getLink_DriverProfile_DriverPreference_4006ContainedLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_Collision_ObstructionEditPart.VISUAL_ID:
			return getLink_Collision_Obstruction_4007ContainedLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_Platoon_FollowingVehicleEditPart.VISUAL_ID:
			return getLink_Platoon_FollowingVehicle_4008ContainedLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_DriverPreference_EnvironmentConditionEditPart.VISUAL_ID:
			return getLink_DriverPreference_EnvironmentCondition_4009ContainedLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_AbnormalBehaviour_ActionEditPart.VISUAL_ID:
			return getLink_AbnormalBehaviour_Action_4010ContainedLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_Following_ForwardEditPart.VISUAL_ID:
			return getLink_Following_Forward_4011ContainedLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_LaneTypeEditPart.VISUAL_ID:
			return getLink_EnvironmentCondition_LaneType_4012ContainedLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_VehicleConfiguration_VehicleTypeEditPart.VISUAL_ID:
			return getLink_VehicleConfiguration_VehicleType_4013ContainedLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_Platoon_LeadingVehicleEditPart.VISUAL_ID:
			return getLink_Platoon_LeadingVehicle_4014ContainedLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_Driver_EnvironmentEditPart.VISUAL_ID:
			return getLink_Driver_Environment_4015ContainedLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_LaneChanging_TurnEditPart.VISUAL_ID:
			return getLink_LaneChanging_Turn_4016ContainedLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_TrafficConditionEditPart.VISUAL_ID:
			return getLink_EnvironmentCondition_TrafficCondition_4017ContainedLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_Intersection_TrafficLightEditPart.VISUAL_ID:
			return getLink_Intersection_TrafficLight_4018ContainedLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_Following_MinGapEditPart.VISUAL_ID:
			return getLink_Following_MinGap_4019ContainedLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_NormalBehaviour_LaneChangingEditPart.VISUAL_ID:
			return getLink_NormalBehaviour_LaneChanging_4020ContainedLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_SafetyRequirement_RegulationEditPart.VISUAL_ID:
			return getLink_SafetyRequirement_Regulation_4021ContainedLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_DriverPreference_DrivingBehaviourEditPart.VISUAL_ID:
			return getLink_DriverPreference_DrivingBehaviour_4022ContainedLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_FollowingVehicle_FrontVehicleEditPart.VISUAL_ID:
			return getLink_FollowingVehicle_FrontVehicle_4023ContainedLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_DriverPreference_DriverEmotionEditPart.VISUAL_ID:
			return getLink_DriverPreference_DriverEmotion_4024ContainedLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_EnvironmentBackground_EnvironmentConditionEditPart.VISUAL_ID:
			return getLink_EnvironmentBackground_EnvironmentCondition_4025ContainedLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_WeatherEditPart.VISUAL_ID:
			return getLink_EnvironmentCondition_Weather_4026ContainedLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_SpecialConditionEditPart.VISUAL_ID:
			return getLink_EnvironmentCondition_SpecialCondition_4027ContainedLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_SpecialCondition_IntersectionEditPart.VISUAL_ID:
			return getLink_SpecialCondition_Intersection_4028ContainedLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_Following_BackwardEditPart.VISUAL_ID:
			return getLink_Following_Backward_4029ContainedLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_RegulationsEditPart.VISUAL_ID:
			return getLink_EnvironmentCondition_Regulations_4030ContainedLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_DrivingBehaviour_NormalBehaviourEditPart.VISUAL_ID:
			return getLink_DrivingBehaviour_NormalBehaviour_4031ContainedLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_LaneChanging_EnvironmentConditionEditPart.VISUAL_ID:
			return getLink_LaneChanging_EnvironmentCondition_4032ContainedLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_LaneChanging_GapAcceptanceEditPart.VISUAL_ID:
			return getLink_LaneChanging_GapAcceptance_4033ContainedLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_NormalBehaviour_FollowingEditPart.VISUAL_ID:
			return getLink_NormalBehaviour_Following_4034ContainedLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_Infrastructure_VehicleConfigurationEditPart.VISUAL_ID:
			return getLink_Infrastructure_VehicleConfiguration_4035ContainedLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_CommunicationInterface_VehicleConfigurationEditPart.VISUAL_ID:
			return getLink_CommunicationInterface_VehicleConfiguration_4036ContainedLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_Goal_DrivingBehaviourEditPart.VISUAL_ID:
			return getLink_Goal_DrivingBehaviour_4037ContainedLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_CooperativeBehaviour_CommunicationInterfaceEditPart.VISUAL_ID:
			return getLink_CooperativeBehaviour_CommunicationInterface_4038ContainedLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_CommunicationInterface_InfrastructureEditPart.VISUAL_ID:
			return getLink_CommunicationInterface_Infrastructure_4039ContainedLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_CooperativeBehaviour_VehicleConfigurationEditPart.VISUAL_ID:
			return getLink_CooperativeBehaviour_VehicleConfiguration_4040ContainedLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_TrafficSituation_EnvironmentConditionEditPart.VISUAL_ID:
			return getLink_TrafficSituation_EnvironmentCondition_4041ContainedLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_Collision_SpecialConditionEditPart.VISUAL_ID:
			return getLink_Collision_SpecialCondition_4042ContainedLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_Following_LaneChangingEditPart.VISUAL_ID:
			return getLink_Following_LaneChanging_4043ContainedLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_Action_BackwardEditPart.VISUAL_ID:
			return getLink_Action_Backward_4044ContainedLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_Action_ForwardEditPart.VISUAL_ID:
			return getLink_Action_Forward_4045ContainedLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_Action_TurnEditPart.VISUAL_ID:
			return getLink_Action_Turn_4046ContainedLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_KnowledgeAndSkill_DriverPreferenceEditPart.VISUAL_ID:
			return getLink_KnowledgeAndSkill_DriverPreference_4047ContainedLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	* @generated
	*/
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getIncomingLinks(
			View view) {
		switch (intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getVisualID(view)) {
		case intelligentMobility.diagram.edit.parts.Special_ConditionEditPart.VISUAL_ID:
			return getSpecial_Condition_2001IncomingLinks(view);
		case intelligentMobility.diagram.edit.parts.WeatherEditPart.VISUAL_ID:
			return getWeather_2002IncomingLinks(view);
		case intelligentMobility.diagram.edit.parts.Traffic_LightEditPart.VISUAL_ID:
			return getTraffic_Light_2003IncomingLinks(view);
		case intelligentMobility.diagram.edit.parts.Knowledge_and_SkillEditPart.VISUAL_ID:
			return getKnowledge_and_Skill_2004IncomingLinks(view);
		case intelligentMobility.diagram.edit.parts.ObstructionEditPart.VISUAL_ID:
			return getObstruction_2005IncomingLinks(view);
		case intelligentMobility.diagram.edit.parts.Driver_PreferenceEditPart.VISUAL_ID:
			return getDriver_Preference_2006IncomingLinks(view);
		case intelligentMobility.diagram.edit.parts.IntersectionEditPart.VISUAL_ID:
			return getIntersection_2007IncomingLinks(view);
		case intelligentMobility.diagram.edit.parts.Vehicle_ConfigurationEditPart.VISUAL_ID:
			return getVehicle_Configuration_2008IncomingLinks(view);
		case intelligentMobility.diagram.edit.parts.Environment_ConditionEditPart.VISUAL_ID:
			return getEnvironment_Condition_2009IncomingLinks(view);
		case intelligentMobility.diagram.edit.parts.PlatoonEditPart.VISUAL_ID:
			return getPlatoon_2010IncomingLinks(view);
		case intelligentMobility.diagram.edit.parts.ForwardEditPart.VISUAL_ID:
			return getForward_2011IncomingLinks(view);
		case intelligentMobility.diagram.edit.parts.Lane_TypeEditPart.VISUAL_ID:
			return getLane_Type_2012IncomingLinks(view);
		case intelligentMobility.diagram.edit.parts.Environment_BackgroundEditPart.VISUAL_ID:
			return getEnvironment_Background_2013IncomingLinks(view);
		case intelligentMobility.diagram.edit.parts.TurnEditPart.VISUAL_ID:
			return getTurn_2014IncomingLinks(view);
		case intelligentMobility.diagram.edit.parts.LaneChangingEditPart.VISUAL_ID:
			return getLaneChanging_2015IncomingLinks(view);
		case intelligentMobility.diagram.edit.parts.Driver_EmotionEditPart.VISUAL_ID:
			return getDriver_Emotion_2016IncomingLinks(view);
		case intelligentMobility.diagram.edit.parts.CollisionEditPart.VISUAL_ID:
			return getCollision_2017IncomingLinks(view);
		case intelligentMobility.diagram.edit.parts.PossibleVehicleEditPart.VISUAL_ID:
			return getPossibleVehicle_2018IncomingLinks(view);
		case intelligentMobility.diagram.edit.parts.FollowingEditPart.VISUAL_ID:
			return getFollowing_2019IncomingLinks(view);
		case intelligentMobility.diagram.edit.parts.GapAcceptanceEditPart.VISUAL_ID:
			return getGapAcceptance_2020IncomingLinks(view);
		case intelligentMobility.diagram.edit.parts.Leading_VehicleEditPart.VISUAL_ID:
			return getLeading_Vehicle_2021IncomingLinks(view);
		case intelligentMobility.diagram.edit.parts.BackwardEditPart.VISUAL_ID:
			return getBackward_2022IncomingLinks(view);
		case intelligentMobility.diagram.edit.parts.RegulationEditPart.VISUAL_ID:
			return getRegulation_2023IncomingLinks(view);
		case intelligentMobility.diagram.edit.parts.Traffic_SituationEditPart.VISUAL_ID:
			return getTraffic_Situation_2024IncomingLinks(view);
		case intelligentMobility.diagram.edit.parts.Driver_ProfileEditPart.VISUAL_ID:
			return getDriver_Profile_2025IncomingLinks(view);
		case intelligentMobility.diagram.edit.parts.Safety_RequirementEditPart.VISUAL_ID:
			return getSafety_Requirement_2026IncomingLinks(view);
		case intelligentMobility.diagram.edit.parts.Driving_BehaviourEditPart.VISUAL_ID:
			return getDriving_Behaviour_2027IncomingLinks(view);
		case intelligentMobility.diagram.edit.parts.Following_VehicleEditPart.VISUAL_ID:
			return getFollowing_Vehicle_2028IncomingLinks(view);
		case intelligentMobility.diagram.edit.parts.Abnormal_BehaviourEditPart.VISUAL_ID:
			return getAbnormal_Behaviour_2029IncomingLinks(view);
		case intelligentMobility.diagram.edit.parts.Backward2EditPart.VISUAL_ID:
			return getBackward_2030IncomingLinks(view);
		case intelligentMobility.diagram.edit.parts.Intersection2EditPart.VISUAL_ID:
			return getIntersection_2031IncomingLinks(view);
		case intelligentMobility.diagram.edit.parts.CommunicationInterfaceEditPart.VISUAL_ID:
			return getCommunicationInterface_2032IncomingLinks(view);
		case intelligentMobility.diagram.edit.parts.GoalEditPart.VISUAL_ID:
			return getGoal_2033IncomingLinks(view);
		case intelligentMobility.diagram.edit.parts.Normal_BehaviourEditPart.VISUAL_ID:
			return getNormal_Behaviour_2034IncomingLinks(view);
		case intelligentMobility.diagram.edit.parts.Platoon2EditPart.VISUAL_ID:
			return getPlatoon_2035IncomingLinks(view);
		case intelligentMobility.diagram.edit.parts.Normal_VehicleEditPart.VISUAL_ID:
			return getNormal_Vehicle_2036IncomingLinks(view);
		case intelligentMobility.diagram.edit.parts.CooperativeBehaviorEditPart.VISUAL_ID:
			return getCooperativeBehavior_2037IncomingLinks(view);
		case intelligentMobility.diagram.edit.parts.ActionEditPart.VISUAL_ID:
			return getAction_2039IncomingLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_LaneType_RegulationEditPart.VISUAL_ID:
			return getLink_LaneType_Regulation_4001IncomingLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_Driver_VehicleEditPart.VISUAL_ID:
			return getLink_Driver_Vehicle_4002IncomingLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_EnvironmentBackground_PossibleVehicleEditPart.VISUAL_ID:
			return getLink_EnvironmentBackground_PossibleVehicle_4003IncomingLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_Vehicle_EnvironmentEditPart.VISUAL_ID:
			return getLink_Vehicle_Environment_4004IncomingLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_NormalVehicle_SafetyRequirementsEditPart.VISUAL_ID:
			return getLink_NormalVehicle_SafetyRequirements_4005IncomingLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_DriverProfile_DriverPreferenceEditPart.VISUAL_ID:
			return getLink_DriverProfile_DriverPreference_4006IncomingLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_Collision_ObstructionEditPart.VISUAL_ID:
			return getLink_Collision_Obstruction_4007IncomingLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_Platoon_FollowingVehicleEditPart.VISUAL_ID:
			return getLink_Platoon_FollowingVehicle_4008IncomingLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_DriverPreference_EnvironmentConditionEditPart.VISUAL_ID:
			return getLink_DriverPreference_EnvironmentCondition_4009IncomingLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_AbnormalBehaviour_ActionEditPart.VISUAL_ID:
			return getLink_AbnormalBehaviour_Action_4010IncomingLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_Following_ForwardEditPart.VISUAL_ID:
			return getLink_Following_Forward_4011IncomingLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_LaneTypeEditPart.VISUAL_ID:
			return getLink_EnvironmentCondition_LaneType_4012IncomingLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_VehicleConfiguration_VehicleTypeEditPart.VISUAL_ID:
			return getLink_VehicleConfiguration_VehicleType_4013IncomingLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_Platoon_LeadingVehicleEditPart.VISUAL_ID:
			return getLink_Platoon_LeadingVehicle_4014IncomingLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_Driver_EnvironmentEditPart.VISUAL_ID:
			return getLink_Driver_Environment_4015IncomingLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_LaneChanging_TurnEditPart.VISUAL_ID:
			return getLink_LaneChanging_Turn_4016IncomingLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_TrafficConditionEditPart.VISUAL_ID:
			return getLink_EnvironmentCondition_TrafficCondition_4017IncomingLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_Intersection_TrafficLightEditPart.VISUAL_ID:
			return getLink_Intersection_TrafficLight_4018IncomingLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_Following_MinGapEditPart.VISUAL_ID:
			return getLink_Following_MinGap_4019IncomingLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_NormalBehaviour_LaneChangingEditPart.VISUAL_ID:
			return getLink_NormalBehaviour_LaneChanging_4020IncomingLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_SafetyRequirement_RegulationEditPart.VISUAL_ID:
			return getLink_SafetyRequirement_Regulation_4021IncomingLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_DriverPreference_DrivingBehaviourEditPart.VISUAL_ID:
			return getLink_DriverPreference_DrivingBehaviour_4022IncomingLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_FollowingVehicle_FrontVehicleEditPart.VISUAL_ID:
			return getLink_FollowingVehicle_FrontVehicle_4023IncomingLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_DriverPreference_DriverEmotionEditPart.VISUAL_ID:
			return getLink_DriverPreference_DriverEmotion_4024IncomingLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_EnvironmentBackground_EnvironmentConditionEditPart.VISUAL_ID:
			return getLink_EnvironmentBackground_EnvironmentCondition_4025IncomingLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_WeatherEditPart.VISUAL_ID:
			return getLink_EnvironmentCondition_Weather_4026IncomingLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_SpecialConditionEditPart.VISUAL_ID:
			return getLink_EnvironmentCondition_SpecialCondition_4027IncomingLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_SpecialCondition_IntersectionEditPart.VISUAL_ID:
			return getLink_SpecialCondition_Intersection_4028IncomingLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_Following_BackwardEditPart.VISUAL_ID:
			return getLink_Following_Backward_4029IncomingLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_RegulationsEditPart.VISUAL_ID:
			return getLink_EnvironmentCondition_Regulations_4030IncomingLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_DrivingBehaviour_NormalBehaviourEditPart.VISUAL_ID:
			return getLink_DrivingBehaviour_NormalBehaviour_4031IncomingLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_LaneChanging_EnvironmentConditionEditPart.VISUAL_ID:
			return getLink_LaneChanging_EnvironmentCondition_4032IncomingLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_LaneChanging_GapAcceptanceEditPart.VISUAL_ID:
			return getLink_LaneChanging_GapAcceptance_4033IncomingLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_NormalBehaviour_FollowingEditPart.VISUAL_ID:
			return getLink_NormalBehaviour_Following_4034IncomingLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_Infrastructure_VehicleConfigurationEditPart.VISUAL_ID:
			return getLink_Infrastructure_VehicleConfiguration_4035IncomingLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_CommunicationInterface_VehicleConfigurationEditPart.VISUAL_ID:
			return getLink_CommunicationInterface_VehicleConfiguration_4036IncomingLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_Goal_DrivingBehaviourEditPart.VISUAL_ID:
			return getLink_Goal_DrivingBehaviour_4037IncomingLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_CooperativeBehaviour_CommunicationInterfaceEditPart.VISUAL_ID:
			return getLink_CooperativeBehaviour_CommunicationInterface_4038IncomingLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_CommunicationInterface_InfrastructureEditPart.VISUAL_ID:
			return getLink_CommunicationInterface_Infrastructure_4039IncomingLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_CooperativeBehaviour_VehicleConfigurationEditPart.VISUAL_ID:
			return getLink_CooperativeBehaviour_VehicleConfiguration_4040IncomingLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_TrafficSituation_EnvironmentConditionEditPart.VISUAL_ID:
			return getLink_TrafficSituation_EnvironmentCondition_4041IncomingLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_Collision_SpecialConditionEditPart.VISUAL_ID:
			return getLink_Collision_SpecialCondition_4042IncomingLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_Following_LaneChangingEditPart.VISUAL_ID:
			return getLink_Following_LaneChanging_4043IncomingLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_Action_BackwardEditPart.VISUAL_ID:
			return getLink_Action_Backward_4044IncomingLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_Action_ForwardEditPart.VISUAL_ID:
			return getLink_Action_Forward_4045IncomingLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_Action_TurnEditPart.VISUAL_ID:
			return getLink_Action_Turn_4046IncomingLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_KnowledgeAndSkill_DriverPreferenceEditPart.VISUAL_ID:
			return getLink_KnowledgeAndSkill_DriverPreference_4047IncomingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	* @generated
	*/
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getOutgoingLinks(
			View view) {
		switch (intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getVisualID(view)) {
		case intelligentMobility.diagram.edit.parts.Special_ConditionEditPart.VISUAL_ID:
			return getSpecial_Condition_2001OutgoingLinks(view);
		case intelligentMobility.diagram.edit.parts.WeatherEditPart.VISUAL_ID:
			return getWeather_2002OutgoingLinks(view);
		case intelligentMobility.diagram.edit.parts.Traffic_LightEditPart.VISUAL_ID:
			return getTraffic_Light_2003OutgoingLinks(view);
		case intelligentMobility.diagram.edit.parts.Knowledge_and_SkillEditPart.VISUAL_ID:
			return getKnowledge_and_Skill_2004OutgoingLinks(view);
		case intelligentMobility.diagram.edit.parts.ObstructionEditPart.VISUAL_ID:
			return getObstruction_2005OutgoingLinks(view);
		case intelligentMobility.diagram.edit.parts.Driver_PreferenceEditPart.VISUAL_ID:
			return getDriver_Preference_2006OutgoingLinks(view);
		case intelligentMobility.diagram.edit.parts.IntersectionEditPart.VISUAL_ID:
			return getIntersection_2007OutgoingLinks(view);
		case intelligentMobility.diagram.edit.parts.Vehicle_ConfigurationEditPart.VISUAL_ID:
			return getVehicle_Configuration_2008OutgoingLinks(view);
		case intelligentMobility.diagram.edit.parts.Environment_ConditionEditPart.VISUAL_ID:
			return getEnvironment_Condition_2009OutgoingLinks(view);
		case intelligentMobility.diagram.edit.parts.PlatoonEditPart.VISUAL_ID:
			return getPlatoon_2010OutgoingLinks(view);
		case intelligentMobility.diagram.edit.parts.ForwardEditPart.VISUAL_ID:
			return getForward_2011OutgoingLinks(view);
		case intelligentMobility.diagram.edit.parts.Lane_TypeEditPart.VISUAL_ID:
			return getLane_Type_2012OutgoingLinks(view);
		case intelligentMobility.diagram.edit.parts.Environment_BackgroundEditPart.VISUAL_ID:
			return getEnvironment_Background_2013OutgoingLinks(view);
		case intelligentMobility.diagram.edit.parts.TurnEditPart.VISUAL_ID:
			return getTurn_2014OutgoingLinks(view);
		case intelligentMobility.diagram.edit.parts.LaneChangingEditPart.VISUAL_ID:
			return getLaneChanging_2015OutgoingLinks(view);
		case intelligentMobility.diagram.edit.parts.Driver_EmotionEditPart.VISUAL_ID:
			return getDriver_Emotion_2016OutgoingLinks(view);
		case intelligentMobility.diagram.edit.parts.CollisionEditPart.VISUAL_ID:
			return getCollision_2017OutgoingLinks(view);
		case intelligentMobility.diagram.edit.parts.PossibleVehicleEditPart.VISUAL_ID:
			return getPossibleVehicle_2018OutgoingLinks(view);
		case intelligentMobility.diagram.edit.parts.FollowingEditPart.VISUAL_ID:
			return getFollowing_2019OutgoingLinks(view);
		case intelligentMobility.diagram.edit.parts.GapAcceptanceEditPart.VISUAL_ID:
			return getGapAcceptance_2020OutgoingLinks(view);
		case intelligentMobility.diagram.edit.parts.Leading_VehicleEditPart.VISUAL_ID:
			return getLeading_Vehicle_2021OutgoingLinks(view);
		case intelligentMobility.diagram.edit.parts.BackwardEditPart.VISUAL_ID:
			return getBackward_2022OutgoingLinks(view);
		case intelligentMobility.diagram.edit.parts.RegulationEditPart.VISUAL_ID:
			return getRegulation_2023OutgoingLinks(view);
		case intelligentMobility.diagram.edit.parts.Traffic_SituationEditPart.VISUAL_ID:
			return getTraffic_Situation_2024OutgoingLinks(view);
		case intelligentMobility.diagram.edit.parts.Driver_ProfileEditPart.VISUAL_ID:
			return getDriver_Profile_2025OutgoingLinks(view);
		case intelligentMobility.diagram.edit.parts.Safety_RequirementEditPart.VISUAL_ID:
			return getSafety_Requirement_2026OutgoingLinks(view);
		case intelligentMobility.diagram.edit.parts.Driving_BehaviourEditPart.VISUAL_ID:
			return getDriving_Behaviour_2027OutgoingLinks(view);
		case intelligentMobility.diagram.edit.parts.Following_VehicleEditPart.VISUAL_ID:
			return getFollowing_Vehicle_2028OutgoingLinks(view);
		case intelligentMobility.diagram.edit.parts.Abnormal_BehaviourEditPart.VISUAL_ID:
			return getAbnormal_Behaviour_2029OutgoingLinks(view);
		case intelligentMobility.diagram.edit.parts.Backward2EditPart.VISUAL_ID:
			return getBackward_2030OutgoingLinks(view);
		case intelligentMobility.diagram.edit.parts.Intersection2EditPart.VISUAL_ID:
			return getIntersection_2031OutgoingLinks(view);
		case intelligentMobility.diagram.edit.parts.CommunicationInterfaceEditPart.VISUAL_ID:
			return getCommunicationInterface_2032OutgoingLinks(view);
		case intelligentMobility.diagram.edit.parts.GoalEditPart.VISUAL_ID:
			return getGoal_2033OutgoingLinks(view);
		case intelligentMobility.diagram.edit.parts.Normal_BehaviourEditPart.VISUAL_ID:
			return getNormal_Behaviour_2034OutgoingLinks(view);
		case intelligentMobility.diagram.edit.parts.Platoon2EditPart.VISUAL_ID:
			return getPlatoon_2035OutgoingLinks(view);
		case intelligentMobility.diagram.edit.parts.Normal_VehicleEditPart.VISUAL_ID:
			return getNormal_Vehicle_2036OutgoingLinks(view);
		case intelligentMobility.diagram.edit.parts.CooperativeBehaviorEditPart.VISUAL_ID:
			return getCooperativeBehavior_2037OutgoingLinks(view);
		case intelligentMobility.diagram.edit.parts.ActionEditPart.VISUAL_ID:
			return getAction_2039OutgoingLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_LaneType_RegulationEditPart.VISUAL_ID:
			return getLink_LaneType_Regulation_4001OutgoingLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_Driver_VehicleEditPart.VISUAL_ID:
			return getLink_Driver_Vehicle_4002OutgoingLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_EnvironmentBackground_PossibleVehicleEditPart.VISUAL_ID:
			return getLink_EnvironmentBackground_PossibleVehicle_4003OutgoingLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_Vehicle_EnvironmentEditPart.VISUAL_ID:
			return getLink_Vehicle_Environment_4004OutgoingLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_NormalVehicle_SafetyRequirementsEditPart.VISUAL_ID:
			return getLink_NormalVehicle_SafetyRequirements_4005OutgoingLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_DriverProfile_DriverPreferenceEditPart.VISUAL_ID:
			return getLink_DriverProfile_DriverPreference_4006OutgoingLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_Collision_ObstructionEditPart.VISUAL_ID:
			return getLink_Collision_Obstruction_4007OutgoingLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_Platoon_FollowingVehicleEditPart.VISUAL_ID:
			return getLink_Platoon_FollowingVehicle_4008OutgoingLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_DriverPreference_EnvironmentConditionEditPart.VISUAL_ID:
			return getLink_DriverPreference_EnvironmentCondition_4009OutgoingLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_AbnormalBehaviour_ActionEditPart.VISUAL_ID:
			return getLink_AbnormalBehaviour_Action_4010OutgoingLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_Following_ForwardEditPart.VISUAL_ID:
			return getLink_Following_Forward_4011OutgoingLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_LaneTypeEditPart.VISUAL_ID:
			return getLink_EnvironmentCondition_LaneType_4012OutgoingLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_VehicleConfiguration_VehicleTypeEditPart.VISUAL_ID:
			return getLink_VehicleConfiguration_VehicleType_4013OutgoingLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_Platoon_LeadingVehicleEditPart.VISUAL_ID:
			return getLink_Platoon_LeadingVehicle_4014OutgoingLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_Driver_EnvironmentEditPart.VISUAL_ID:
			return getLink_Driver_Environment_4015OutgoingLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_LaneChanging_TurnEditPart.VISUAL_ID:
			return getLink_LaneChanging_Turn_4016OutgoingLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_TrafficConditionEditPart.VISUAL_ID:
			return getLink_EnvironmentCondition_TrafficCondition_4017OutgoingLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_Intersection_TrafficLightEditPart.VISUAL_ID:
			return getLink_Intersection_TrafficLight_4018OutgoingLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_Following_MinGapEditPart.VISUAL_ID:
			return getLink_Following_MinGap_4019OutgoingLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_NormalBehaviour_LaneChangingEditPart.VISUAL_ID:
			return getLink_NormalBehaviour_LaneChanging_4020OutgoingLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_SafetyRequirement_RegulationEditPart.VISUAL_ID:
			return getLink_SafetyRequirement_Regulation_4021OutgoingLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_DriverPreference_DrivingBehaviourEditPart.VISUAL_ID:
			return getLink_DriverPreference_DrivingBehaviour_4022OutgoingLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_FollowingVehicle_FrontVehicleEditPart.VISUAL_ID:
			return getLink_FollowingVehicle_FrontVehicle_4023OutgoingLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_DriverPreference_DriverEmotionEditPart.VISUAL_ID:
			return getLink_DriverPreference_DriverEmotion_4024OutgoingLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_EnvironmentBackground_EnvironmentConditionEditPart.VISUAL_ID:
			return getLink_EnvironmentBackground_EnvironmentCondition_4025OutgoingLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_WeatherEditPart.VISUAL_ID:
			return getLink_EnvironmentCondition_Weather_4026OutgoingLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_SpecialConditionEditPart.VISUAL_ID:
			return getLink_EnvironmentCondition_SpecialCondition_4027OutgoingLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_SpecialCondition_IntersectionEditPart.VISUAL_ID:
			return getLink_SpecialCondition_Intersection_4028OutgoingLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_Following_BackwardEditPart.VISUAL_ID:
			return getLink_Following_Backward_4029OutgoingLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_RegulationsEditPart.VISUAL_ID:
			return getLink_EnvironmentCondition_Regulations_4030OutgoingLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_DrivingBehaviour_NormalBehaviourEditPart.VISUAL_ID:
			return getLink_DrivingBehaviour_NormalBehaviour_4031OutgoingLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_LaneChanging_EnvironmentConditionEditPart.VISUAL_ID:
			return getLink_LaneChanging_EnvironmentCondition_4032OutgoingLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_LaneChanging_GapAcceptanceEditPart.VISUAL_ID:
			return getLink_LaneChanging_GapAcceptance_4033OutgoingLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_NormalBehaviour_FollowingEditPart.VISUAL_ID:
			return getLink_NormalBehaviour_Following_4034OutgoingLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_Infrastructure_VehicleConfigurationEditPart.VISUAL_ID:
			return getLink_Infrastructure_VehicleConfiguration_4035OutgoingLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_CommunicationInterface_VehicleConfigurationEditPart.VISUAL_ID:
			return getLink_CommunicationInterface_VehicleConfiguration_4036OutgoingLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_Goal_DrivingBehaviourEditPart.VISUAL_ID:
			return getLink_Goal_DrivingBehaviour_4037OutgoingLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_CooperativeBehaviour_CommunicationInterfaceEditPart.VISUAL_ID:
			return getLink_CooperativeBehaviour_CommunicationInterface_4038OutgoingLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_CommunicationInterface_InfrastructureEditPart.VISUAL_ID:
			return getLink_CommunicationInterface_Infrastructure_4039OutgoingLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_CooperativeBehaviour_VehicleConfigurationEditPart.VISUAL_ID:
			return getLink_CooperativeBehaviour_VehicleConfiguration_4040OutgoingLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_TrafficSituation_EnvironmentConditionEditPart.VISUAL_ID:
			return getLink_TrafficSituation_EnvironmentCondition_4041OutgoingLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_Collision_SpecialConditionEditPart.VISUAL_ID:
			return getLink_Collision_SpecialCondition_4042OutgoingLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_Following_LaneChangingEditPart.VISUAL_ID:
			return getLink_Following_LaneChanging_4043OutgoingLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_Action_BackwardEditPart.VISUAL_ID:
			return getLink_Action_Backward_4044OutgoingLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_Action_ForwardEditPart.VISUAL_ID:
			return getLink_Action_Forward_4045OutgoingLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_Action_TurnEditPart.VISUAL_ID:
			return getLink_Action_Turn_4046OutgoingLinks(view);
		case intelligentMobility.diagram.edit.parts.Link_KnowledgeAndSkill_DriverPreferenceEditPart.VISUAL_ID:
			return getLink_KnowledgeAndSkill_DriverPreference_4047OutgoingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getMobilitySystem_1000ContainedLinks(
			View view) {
		intelligentMobility.MobilitySystem modelElement = (intelligentMobility.MobilitySystem) view.getElement();
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		result.addAll(getContainedTypeModelFacetLinks_Link_LaneType_Regulation_4001(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Link_Driver_Vehicle_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Link_EnvironmentBackground_PossibleVehicle_4003(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Link_Vehicle_Environment_4004(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Link_NormalVehicle_SafetyRequirements_4005(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Link_DriverProfile_DriverPreference_4006(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Link_Collision_Obstruction_4007(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Link_Platoon_FollowingVehicle_4008(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Link_DriverPreference_EnvironmentCondition_4009(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Link_AbnormalBehaviour_Action_4010(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Link_Following_Forward_4011(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Link_EnvironmentCondition_LaneType_4012(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Link_VehicleConfiguration_VehicleType_4013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Link_Platoon_LeadingVehicle_4014(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Link_Driver_Environment_4015(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Link_LaneChanging_Turn_4016(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Link_EnvironmentCondition_TrafficCondition_4017(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Link_Intersection_TrafficLight_4018(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Link_Following_MinGap_4019(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Link_NormalBehaviour_LaneChanging_4020(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Link_SafetyRequirement_Regulation_4021(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Link_DriverPreference_DrivingBehaviour_4022(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Link_FollowingVehicle_FrontVehicle_4023(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Link_DriverPreference_DriverEmotion_4024(modelElement));
		result.addAll(
				getContainedTypeModelFacetLinks_Link_EnvironmentBackground_EnvironmentCondition_4025(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Link_EnvironmentCondition_Weather_4026(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Link_EnvironmentCondition_SpecialCondition_4027(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Link_SpecialCondition_Intersection_4028(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Link_Following_Backward_4029(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Link_EnvironmentCondition_Regulations_4030(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Link_DrivingBehaviour_NormalBehaviour_4031(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Link_LaneChanging_EnvironmentCondition_4032(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Link_LaneChanging_GapAcceptance_4033(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Link_NormalBehaviour_Following_4034(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Link_Infrastructure_VehicleConfiguration_4035(modelElement));
		result.addAll(
				getContainedTypeModelFacetLinks_Link_CommunicationInterface_VehicleConfiguration_4036(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Link_Goal_DrivingBehaviour_4037(modelElement));
		result.addAll(
				getContainedTypeModelFacetLinks_Link_CooperativeBehaviour_CommunicationInterface_4038(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Link_CommunicationInterface_Infrastructure_4039(modelElement));
		result.addAll(
				getContainedTypeModelFacetLinks_Link_CooperativeBehaviour_VehicleConfiguration_4040(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Link_TrafficSituation_EnvironmentCondition_4041(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Link_Collision_SpecialCondition_4042(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Link_Following_LaneChanging_4043(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Link_Action_Backward_4044(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Link_Action_Forward_4045(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Link_Action_Turn_4046(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Link_KnowledgeAndSkill_DriverPreference_4047(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getSpecial_Condition_2001ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getWeather_2002ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getTraffic_Light_2003ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getKnowledge_and_Skill_2004ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getObstruction_2005ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getDriver_Preference_2006ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getIntersection_2007ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getVehicle_Configuration_2008ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getEnvironment_Condition_2009ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getPlatoon_2010ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getForward_2011ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLane_Type_2012ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getEnvironment_Background_2013ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getTurn_2014ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLaneChanging_2015ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getDriver_Emotion_2016ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getCollision_2017ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getPossibleVehicle_2018ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getFollowing_2019ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getGapAcceptance_2020ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLeading_Vehicle_2021ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getBackward_2022ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getRegulation_2023ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getTraffic_Situation_2024ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getDriver_Profile_2025ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getSafety_Requirement_2026ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getDriving_Behaviour_2027ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getFollowing_Vehicle_2028ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getAbnormal_Behaviour_2029ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getBackward_2030ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getIntersection_2031ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getCommunicationInterface_2032ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getGoal_2033ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getNormal_Behaviour_2034ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getPlatoon_2035ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getNormal_Vehicle_2036ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getCooperativeBehavior_2037ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getAction_2039ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_LaneType_Regulation_4001ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_Driver_Vehicle_4002ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_EnvironmentBackground_PossibleVehicle_4003ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_Vehicle_Environment_4004ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_NormalVehicle_SafetyRequirements_4005ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_DriverProfile_DriverPreference_4006ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_Collision_Obstruction_4007ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_Platoon_FollowingVehicle_4008ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_DriverPreference_EnvironmentCondition_4009ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_AbnormalBehaviour_Action_4010ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_Following_Forward_4011ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_EnvironmentCondition_LaneType_4012ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_VehicleConfiguration_VehicleType_4013ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_Platoon_LeadingVehicle_4014ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_Driver_Environment_4015ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_LaneChanging_Turn_4016ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_EnvironmentCondition_TrafficCondition_4017ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_Intersection_TrafficLight_4018ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_Following_MinGap_4019ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_NormalBehaviour_LaneChanging_4020ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_SafetyRequirement_Regulation_4021ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_DriverPreference_DrivingBehaviour_4022ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_FollowingVehicle_FrontVehicle_4023ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_DriverPreference_DriverEmotion_4024ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_EnvironmentBackground_EnvironmentCondition_4025ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_EnvironmentCondition_Weather_4026ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_EnvironmentCondition_SpecialCondition_4027ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_SpecialCondition_Intersection_4028ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_Following_Backward_4029ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_EnvironmentCondition_Regulations_4030ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_DrivingBehaviour_NormalBehaviour_4031ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_LaneChanging_EnvironmentCondition_4032ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_LaneChanging_GapAcceptance_4033ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_NormalBehaviour_Following_4034ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_Infrastructure_VehicleConfiguration_4035ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_CommunicationInterface_VehicleConfiguration_4036ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_Goal_DrivingBehaviour_4037ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_CooperativeBehaviour_CommunicationInterface_4038ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_CommunicationInterface_Infrastructure_4039ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_CooperativeBehaviour_VehicleConfiguration_4040ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_TrafficSituation_EnvironmentCondition_4041ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_Collision_SpecialCondition_4042ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_Following_LaneChanging_4043ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	* @generated
	*/
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_Action_Backward_4044ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	* @generated
	*/
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_Action_Forward_4045ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	* @generated
	*/
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_Action_Turn_4046ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	* @generated
	*/
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_KnowledgeAndSkill_DriverPreference_4047ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getSpecial_Condition_2001IncomingLinks(
			View view) {
		intelligentMobility.Special_Condition modelElement = (intelligentMobility.Special_Condition) view.getElement();
		Map/*[org.eclipse.emf.ecore.EObject, java.util.Collection<org.eclipse.emf.ecore.EStructuralFeature.Setting>]*/ crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		result.addAll(getIncomingTypeModelFacetLinks_Link_EnvironmentCondition_SpecialCondition_4027(modelElement,
				crossReferences));
		result.addAll(
				getIncomingTypeModelFacetLinks_Link_SpecialCondition_Intersection_4028(modelElement, crossReferences));
		result.addAll(
				getIncomingTypeModelFacetLinks_Link_Collision_SpecialCondition_4042(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getWeather_2002IncomingLinks(
			View view) {
		intelligentMobility.Weather modelElement = (intelligentMobility.Weather) view.getElement();
		Map/*[org.eclipse.emf.ecore.EObject, java.util.Collection<org.eclipse.emf.ecore.EStructuralFeature.Setting>]*/ crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		result.addAll(
				getIncomingTypeModelFacetLinks_Link_EnvironmentCondition_Weather_4026(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getTraffic_Light_2003IncomingLinks(
			View view) {
		intelligentMobility.Traffic_Light modelElement = (intelligentMobility.Traffic_Light) view.getElement();
		Map/*[org.eclipse.emf.ecore.EObject, java.util.Collection<org.eclipse.emf.ecore.EStructuralFeature.Setting>]*/ crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		result.addAll(
				getIncomingTypeModelFacetLinks_Link_Intersection_TrafficLight_4018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Link_Infrastructure_VehicleConfiguration_4035(modelElement,
				crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Link_CommunicationInterface_Infrastructure_4039(modelElement,
				crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getKnowledge_and_Skill_2004IncomingLinks(
			View view) {
		intelligentMobility.Knowledge_and_Skill modelElement = (intelligentMobility.Knowledge_and_Skill) view
				.getElement();
		Map/*[org.eclipse.emf.ecore.EObject, java.util.Collection<org.eclipse.emf.ecore.EStructuralFeature.Setting>]*/ crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		result.addAll(getIncomingTypeModelFacetLinks_Link_KnowledgeAndSkill_DriverPreference_4047(modelElement,
				crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getObstruction_2005IncomingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getDriver_Preference_2006IncomingLinks(
			View view) {
		intelligentMobility.Driver_Preference modelElement = (intelligentMobility.Driver_Preference) view.getElement();
		Map/*[org.eclipse.emf.ecore.EObject, java.util.Collection<org.eclipse.emf.ecore.EStructuralFeature.Setting>]*/ crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		result.addAll(
				getIncomingTypeModelFacetLinks_Link_DriverProfile_DriverPreference_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Link_DriverPreference_DrivingBehaviour_4022(modelElement,
				crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getIntersection_2007IncomingLinks(
			View view) {
		intelligentMobility.Intersection modelElement = (intelligentMobility.Intersection) view.getElement();
		Map/*[org.eclipse.emf.ecore.EObject, java.util.Collection<org.eclipse.emf.ecore.EStructuralFeature.Setting>]*/ crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		result.addAll(getIncomingTypeModelFacetLinks_Link_Infrastructure_VehicleConfiguration_4035(modelElement,
				crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Link_CommunicationInterface_Infrastructure_4039(modelElement,
				crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getVehicle_Configuration_2008IncomingLinks(
			View view) {
		intelligentMobility.Vehicle_Configuration modelElement = (intelligentMobility.Vehicle_Configuration) view
				.getElement();
		Map/*[org.eclipse.emf.ecore.EObject, java.util.Collection<org.eclipse.emf.ecore.EStructuralFeature.Setting>]*/ crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		result.addAll(getIncomingTypeModelFacetLinks_Link_Driver_Vehicle_4002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Link_VehicleConfiguration_VehicleType_4013(modelElement,
				crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Link_CommunicationInterface_VehicleConfiguration_4036(modelElement,
				crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Link_CooperativeBehaviour_VehicleConfiguration_4040(modelElement,
				crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getEnvironment_Condition_2009IncomingLinks(
			View view) {
		intelligentMobility.Environment_Condition modelElement = (intelligentMobility.Environment_Condition) view
				.getElement();
		Map/*[org.eclipse.emf.ecore.EObject, java.util.Collection<org.eclipse.emf.ecore.EStructuralFeature.Setting>]*/ crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		result.addAll(getIncomingTypeModelFacetLinks_Link_DriverPreference_EnvironmentCondition_4009(modelElement,
				crossReferences));
		result.addAll(
				getIncomingTypeModelFacetLinks_Link_EnvironmentCondition_LaneType_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Link_EnvironmentCondition_TrafficCondition_4017(modelElement,
				crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Link_EnvironmentBackground_EnvironmentCondition_4025(modelElement,
				crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Link_LaneChanging_EnvironmentCondition_4032(modelElement,
				crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getPlatoon_2010IncomingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getForward_2011IncomingLinks(
			View view) {
		intelligentMobility.Forward modelElement = (intelligentMobility.Forward) view.getElement();
		Map/*[org.eclipse.emf.ecore.EObject, java.util.Collection<org.eclipse.emf.ecore.EStructuralFeature.Setting>]*/ crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		result.addAll(getIncomingTypeModelFacetLinks_Link_Following_Forward_4011(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Link_Action_Forward_4045(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLane_Type_2012IncomingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getEnvironment_Background_2013IncomingLinks(
			View view) {
		intelligentMobility.Environment_Background modelElement = (intelligentMobility.Environment_Background) view
				.getElement();
		Map/*[org.eclipse.emf.ecore.EObject, java.util.Collection<org.eclipse.emf.ecore.EStructuralFeature.Setting>]*/ crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		result.addAll(getIncomingTypeModelFacetLinks_Link_EnvironmentBackground_PossibleVehicle_4003(modelElement,
				crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Link_Vehicle_Environment_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Link_Driver_Environment_4015(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getTurn_2014IncomingLinks(
			View view) {
		intelligentMobility.Turn modelElement = (intelligentMobility.Turn) view.getElement();
		Map/*[org.eclipse.emf.ecore.EObject, java.util.Collection<org.eclipse.emf.ecore.EStructuralFeature.Setting>]*/ crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		result.addAll(getIncomingTypeModelFacetLinks_Link_Action_Turn_4046(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLaneChanging_2015IncomingLinks(
			View view) {
		intelligentMobility.LaneChanging modelElement = (intelligentMobility.LaneChanging) view.getElement();
		Map/*[org.eclipse.emf.ecore.EObject, java.util.Collection<org.eclipse.emf.ecore.EStructuralFeature.Setting>]*/ crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		result.addAll(getIncomingTypeModelFacetLinks_Link_LaneChanging_Turn_4016(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Link_Following_MinGap_4019(modelElement, crossReferences));
		result.addAll(
				getIncomingTypeModelFacetLinks_Link_NormalBehaviour_LaneChanging_4020(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Link_Following_LaneChanging_4043(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getDriver_Emotion_2016IncomingLinks(
			View view) {
		intelligentMobility.Driver_Emotion modelElement = (intelligentMobility.Driver_Emotion) view.getElement();
		Map/*[org.eclipse.emf.ecore.EObject, java.util.Collection<org.eclipse.emf.ecore.EStructuralFeature.Setting>]*/ crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		result.addAll(
				getIncomingTypeModelFacetLinks_Link_DriverPreference_DriverEmotion_4024(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getCollision_2017IncomingLinks(
			View view) {
		intelligentMobility.Collision modelElement = (intelligentMobility.Collision) view.getElement();
		Map/*[org.eclipse.emf.ecore.EObject, java.util.Collection<org.eclipse.emf.ecore.EStructuralFeature.Setting>]*/ crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		result.addAll(getIncomingTypeModelFacetLinks_Link_Collision_Obstruction_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getPossibleVehicle_2018IncomingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getFollowing_2019IncomingLinks(
			View view) {
		intelligentMobility.Following modelElement = (intelligentMobility.Following) view.getElement();
		Map/*[org.eclipse.emf.ecore.EObject, java.util.Collection<org.eclipse.emf.ecore.EStructuralFeature.Setting>]*/ crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		result.addAll(getIncomingTypeModelFacetLinks_Link_Following_Backward_4029(modelElement, crossReferences));
		result.addAll(
				getIncomingTypeModelFacetLinks_Link_NormalBehaviour_Following_4034(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getGapAcceptance_2020IncomingLinks(
			View view) {
		intelligentMobility.GapAcceptance modelElement = (intelligentMobility.GapAcceptance) view.getElement();
		Map/*[org.eclipse.emf.ecore.EObject, java.util.Collection<org.eclipse.emf.ecore.EStructuralFeature.Setting>]*/ crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		result.addAll(
				getIncomingTypeModelFacetLinks_Link_LaneChanging_GapAcceptance_4033(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLeading_Vehicle_2021IncomingLinks(
			View view) {
		intelligentMobility.Leading_Vehicle modelElement = (intelligentMobility.Leading_Vehicle) view.getElement();
		Map/*[org.eclipse.emf.ecore.EObject, java.util.Collection<org.eclipse.emf.ecore.EStructuralFeature.Setting>]*/ crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		result.addAll(getIncomingTypeModelFacetLinks_Link_Platoon_LeadingVehicle_4014(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getBackward_2022IncomingLinks(
			View view) {
		intelligentMobility.Backward modelElement = (intelligentMobility.Backward) view.getElement();
		Map/*[org.eclipse.emf.ecore.EObject, java.util.Collection<org.eclipse.emf.ecore.EStructuralFeature.Setting>]*/ crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		result.addAll(getIncomingTypeModelFacetLinks_Link_Action_Backward_4044(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getRegulation_2023IncomingLinks(
			View view) {
		intelligentMobility.Regulation modelElement = (intelligentMobility.Regulation) view.getElement();
		Map/*[org.eclipse.emf.ecore.EObject, java.util.Collection<org.eclipse.emf.ecore.EStructuralFeature.Setting>]*/ crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		result.addAll(getIncomingTypeModelFacetLinks_Link_LaneType_Regulation_4001(modelElement, crossReferences));
		result.addAll(
				getIncomingTypeModelFacetLinks_Link_SafetyRequirement_Regulation_4021(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Link_EnvironmentCondition_Regulations_4030(modelElement,
				crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getTraffic_Situation_2024IncomingLinks(
			View view) {
		intelligentMobility.Traffic_Situation modelElement = (intelligentMobility.Traffic_Situation) view.getElement();
		Map/*[org.eclipse.emf.ecore.EObject, java.util.Collection<org.eclipse.emf.ecore.EStructuralFeature.Setting>]*/ crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		result.addAll(getIncomingTypeModelFacetLinks_Link_TrafficSituation_EnvironmentCondition_4041(modelElement,
				crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getDriver_Profile_2025IncomingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getSafety_Requirement_2026IncomingLinks(
			View view) {
		intelligentMobility.Safety_Requirement modelElement = (intelligentMobility.Safety_Requirement) view
				.getElement();
		Map/*[org.eclipse.emf.ecore.EObject, java.util.Collection<org.eclipse.emf.ecore.EStructuralFeature.Setting>]*/ crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		result.addAll(getIncomingTypeModelFacetLinks_Link_NormalVehicle_SafetyRequirements_4005(modelElement,
				crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getDriving_Behaviour_2027IncomingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getFollowing_Vehicle_2028IncomingLinks(
			View view) {
		intelligentMobility.Following_Vehicle modelElement = (intelligentMobility.Following_Vehicle) view.getElement();
		Map/*[org.eclipse.emf.ecore.EObject, java.util.Collection<org.eclipse.emf.ecore.EStructuralFeature.Setting>]*/ crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		result.addAll(getIncomingTypeModelFacetLinks_Link_Platoon_FollowingVehicle_4008(modelElement, crossReferences));
		result.addAll(
				getIncomingTypeModelFacetLinks_Link_FollowingVehicle_FrontVehicle_4023(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getAbnormal_Behaviour_2029IncomingLinks(
			View view) {
		intelligentMobility.Abnormal_Behaviour modelElement = (intelligentMobility.Abnormal_Behaviour) view
				.getElement();
		Map/*[org.eclipse.emf.ecore.EObject, java.util.Collection<org.eclipse.emf.ecore.EStructuralFeature.Setting>]*/ crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		result.addAll(getIncomingTypeModelFacetLinks_Link_AbnormalBehaviour_Action_4010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Link_DrivingBehaviour_NormalBehaviour_4031(modelElement,
				crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getBackward_2030IncomingLinks(
			View view) {
		intelligentMobility.Backward modelElement = (intelligentMobility.Backward) view.getElement();
		Map/*[org.eclipse.emf.ecore.EObject, java.util.Collection<org.eclipse.emf.ecore.EStructuralFeature.Setting>]*/ crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		result.addAll(getIncomingTypeModelFacetLinks_Link_Action_Backward_4044(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getIntersection_2031IncomingLinks(
			View view) {
		intelligentMobility.Intersection modelElement = (intelligentMobility.Intersection) view.getElement();
		Map/*[org.eclipse.emf.ecore.EObject, java.util.Collection<org.eclipse.emf.ecore.EStructuralFeature.Setting>]*/ crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		result.addAll(getIncomingTypeModelFacetLinks_Link_Infrastructure_VehicleConfiguration_4035(modelElement,
				crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Link_CommunicationInterface_Infrastructure_4039(modelElement,
				crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getCommunicationInterface_2032IncomingLinks(
			View view) {
		intelligentMobility.CommunicationInterface modelElement = (intelligentMobility.CommunicationInterface) view
				.getElement();
		Map/*[org.eclipse.emf.ecore.EObject, java.util.Collection<org.eclipse.emf.ecore.EStructuralFeature.Setting>]*/ crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		result.addAll(getIncomingTypeModelFacetLinks_Link_CooperativeBehaviour_CommunicationInterface_4038(modelElement,
				crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getGoal_2033IncomingLinks(
			View view) {
		intelligentMobility.Goal modelElement = (intelligentMobility.Goal) view.getElement();
		Map/*[org.eclipse.emf.ecore.EObject, java.util.Collection<org.eclipse.emf.ecore.EStructuralFeature.Setting>]*/ crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		result.addAll(getIncomingTypeModelFacetLinks_Link_Goal_DrivingBehaviour_4037(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getNormal_Behaviour_2034IncomingLinks(
			View view) {
		intelligentMobility.Normal_Behaviour modelElement = (intelligentMobility.Normal_Behaviour) view.getElement();
		Map/*[org.eclipse.emf.ecore.EObject, java.util.Collection<org.eclipse.emf.ecore.EStructuralFeature.Setting>]*/ crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		result.addAll(getIncomingTypeModelFacetLinks_Link_DrivingBehaviour_NormalBehaviour_4031(modelElement,
				crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getPlatoon_2035IncomingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getNormal_Vehicle_2036IncomingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getCooperativeBehavior_2037IncomingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getAction_2039IncomingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_LaneType_Regulation_4001IncomingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_Driver_Vehicle_4002IncomingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_EnvironmentBackground_PossibleVehicle_4003IncomingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_Vehicle_Environment_4004IncomingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_NormalVehicle_SafetyRequirements_4005IncomingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_DriverProfile_DriverPreference_4006IncomingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_Collision_Obstruction_4007IncomingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_Platoon_FollowingVehicle_4008IncomingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_DriverPreference_EnvironmentCondition_4009IncomingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_AbnormalBehaviour_Action_4010IncomingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_Following_Forward_4011IncomingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_EnvironmentCondition_LaneType_4012IncomingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_VehicleConfiguration_VehicleType_4013IncomingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_Platoon_LeadingVehicle_4014IncomingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_Driver_Environment_4015IncomingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_LaneChanging_Turn_4016IncomingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_EnvironmentCondition_TrafficCondition_4017IncomingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_Intersection_TrafficLight_4018IncomingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_Following_MinGap_4019IncomingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_NormalBehaviour_LaneChanging_4020IncomingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_SafetyRequirement_Regulation_4021IncomingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_DriverPreference_DrivingBehaviour_4022IncomingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_FollowingVehicle_FrontVehicle_4023IncomingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_DriverPreference_DriverEmotion_4024IncomingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_EnvironmentBackground_EnvironmentCondition_4025IncomingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_EnvironmentCondition_Weather_4026IncomingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_EnvironmentCondition_SpecialCondition_4027IncomingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_SpecialCondition_Intersection_4028IncomingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_Following_Backward_4029IncomingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_EnvironmentCondition_Regulations_4030IncomingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_DrivingBehaviour_NormalBehaviour_4031IncomingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_LaneChanging_EnvironmentCondition_4032IncomingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_LaneChanging_GapAcceptance_4033IncomingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_NormalBehaviour_Following_4034IncomingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_Infrastructure_VehicleConfiguration_4035IncomingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_CommunicationInterface_VehicleConfiguration_4036IncomingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_Goal_DrivingBehaviour_4037IncomingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_CooperativeBehaviour_CommunicationInterface_4038IncomingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_CommunicationInterface_Infrastructure_4039IncomingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_CooperativeBehaviour_VehicleConfiguration_4040IncomingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_TrafficSituation_EnvironmentCondition_4041IncomingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_Collision_SpecialCondition_4042IncomingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_Following_LaneChanging_4043IncomingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	* @generated
	*/
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_Action_Backward_4044IncomingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	* @generated
	*/
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_Action_Forward_4045IncomingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	* @generated
	*/
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_Action_Turn_4046IncomingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	* @generated
	*/
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_KnowledgeAndSkill_DriverPreference_4047IncomingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getSpecial_Condition_2001OutgoingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getWeather_2002OutgoingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getTraffic_Light_2003OutgoingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getKnowledge_and_Skill_2004OutgoingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getObstruction_2005OutgoingLinks(
			View view) {
		intelligentMobility.Obstruction modelElement = (intelligentMobility.Obstruction) view.getElement();
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		result.addAll(getOutgoingTypeModelFacetLinks_Link_Collision_Obstruction_4007(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getDriver_Preference_2006OutgoingLinks(
			View view) {
		intelligentMobility.Driver_Preference modelElement = (intelligentMobility.Driver_Preference) view.getElement();
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		result.addAll(getOutgoingTypeModelFacetLinks_Link_DriverPreference_EnvironmentCondition_4009(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Link_DriverPreference_DriverEmotion_4024(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Link_KnowledgeAndSkill_DriverPreference_4047(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getIntersection_2007OutgoingLinks(
			View view) {
		intelligentMobility.Intersection modelElement = (intelligentMobility.Intersection) view.getElement();
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		result.addAll(getOutgoingTypeModelFacetLinks_Link_Intersection_TrafficLight_4018(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Link_SpecialCondition_Intersection_4028(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getVehicle_Configuration_2008OutgoingLinks(
			View view) {
		intelligentMobility.Vehicle_Configuration modelElement = (intelligentMobility.Vehicle_Configuration) view
				.getElement();
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		result.addAll(getOutgoingTypeModelFacetLinks_Link_Vehicle_Environment_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Link_Infrastructure_VehicleConfiguration_4035(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getEnvironment_Condition_2009OutgoingLinks(
			View view) {
		intelligentMobility.Environment_Condition modelElement = (intelligentMobility.Environment_Condition) view
				.getElement();
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		result.addAll(getOutgoingTypeModelFacetLinks_Link_EnvironmentCondition_Weather_4026(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Link_EnvironmentCondition_SpecialCondition_4027(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Link_EnvironmentCondition_Regulations_4030(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Link_TrafficSituation_EnvironmentCondition_4041(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getPlatoon_2010OutgoingLinks(
			View view) {
		intelligentMobility.Platoon modelElement = (intelligentMobility.Platoon) view.getElement();
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		result.addAll(getOutgoingTypeModelFacetLinks_Link_Platoon_FollowingVehicle_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Link_VehicleConfiguration_VehicleType_4013(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Link_Platoon_LeadingVehicle_4014(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getForward_2011OutgoingLinks(
			View view) {
		intelligentMobility.Forward modelElement = (intelligentMobility.Forward) view.getElement();
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		result.addAll(getOutgoingTypeModelFacetLinks_Link_AbnormalBehaviour_Action_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Link_Action_Backward_4044(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Link_Action_Forward_4045(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Link_Action_Turn_4046(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLane_Type_2012OutgoingLinks(
			View view) {
		intelligentMobility.Lane_Type modelElement = (intelligentMobility.Lane_Type) view.getElement();
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		result.addAll(getOutgoingTypeModelFacetLinks_Link_LaneType_Regulation_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Link_EnvironmentCondition_LaneType_4012(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getEnvironment_Background_2013OutgoingLinks(
			View view) {
		intelligentMobility.Environment_Background modelElement = (intelligentMobility.Environment_Background) view
				.getElement();
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		result.addAll(
				getOutgoingTypeModelFacetLinks_Link_EnvironmentBackground_EnvironmentCondition_4025(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getTurn_2014OutgoingLinks(
			View view) {
		intelligentMobility.Turn modelElement = (intelligentMobility.Turn) view.getElement();
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		result.addAll(getOutgoingTypeModelFacetLinks_Link_AbnormalBehaviour_Action_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Link_LaneChanging_Turn_4016(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Link_Action_Backward_4044(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Link_Action_Forward_4045(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Link_Action_Turn_4046(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLaneChanging_2015OutgoingLinks(
			View view) {
		intelligentMobility.LaneChanging modelElement = (intelligentMobility.LaneChanging) view.getElement();
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		result.addAll(getOutgoingTypeModelFacetLinks_Link_LaneChanging_EnvironmentCondition_4032(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Link_LaneChanging_GapAcceptance_4033(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getDriver_Emotion_2016OutgoingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getCollision_2017OutgoingLinks(
			View view) {
		intelligentMobility.Collision modelElement = (intelligentMobility.Collision) view.getElement();
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		result.addAll(getOutgoingTypeModelFacetLinks_Link_Collision_SpecialCondition_4042(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getPossibleVehicle_2018OutgoingLinks(
			View view) {
		intelligentMobility.PossibleVehicle modelElement = (intelligentMobility.PossibleVehicle) view.getElement();
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		result.addAll(getOutgoingTypeModelFacetLinks_Link_EnvironmentBackground_PossibleVehicle_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getFollowing_2019OutgoingLinks(
			View view) {
		intelligentMobility.Following modelElement = (intelligentMobility.Following) view.getElement();
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		result.addAll(getOutgoingTypeModelFacetLinks_Link_Following_Forward_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Link_Following_MinGap_4019(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Link_Following_LaneChanging_4043(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getGapAcceptance_2020OutgoingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLeading_Vehicle_2021OutgoingLinks(
			View view) {
		intelligentMobility.Leading_Vehicle modelElement = (intelligentMobility.Leading_Vehicle) view.getElement();
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		result.addAll(getOutgoingTypeModelFacetLinks_Link_NormalVehicle_SafetyRequirements_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Link_VehicleConfiguration_VehicleType_4013(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Link_FollowingVehicle_FrontVehicle_4023(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getBackward_2022OutgoingLinks(
			View view) {
		intelligentMobility.Backward modelElement = (intelligentMobility.Backward) view.getElement();
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		result.addAll(getOutgoingTypeModelFacetLinks_Link_AbnormalBehaviour_Action_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Link_Following_Backward_4029(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Link_Action_Backward_4044(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Link_Action_Forward_4045(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Link_Action_Turn_4046(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getRegulation_2023OutgoingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getTraffic_Situation_2024OutgoingLinks(
			View view) {
		intelligentMobility.Traffic_Situation modelElement = (intelligentMobility.Traffic_Situation) view.getElement();
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		result.addAll(getOutgoingTypeModelFacetLinks_Link_EnvironmentCondition_TrafficCondition_4017(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getDriver_Profile_2025OutgoingLinks(
			View view) {
		intelligentMobility.Driver_Profile modelElement = (intelligentMobility.Driver_Profile) view.getElement();
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		result.addAll(getOutgoingTypeModelFacetLinks_Link_Driver_Vehicle_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Link_DriverProfile_DriverPreference_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Link_Driver_Environment_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getSafety_Requirement_2026OutgoingLinks(
			View view) {
		intelligentMobility.Safety_Requirement modelElement = (intelligentMobility.Safety_Requirement) view
				.getElement();
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		result.addAll(getOutgoingTypeModelFacetLinks_Link_SafetyRequirement_Regulation_4021(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getDriving_Behaviour_2027OutgoingLinks(
			View view) {
		intelligentMobility.Driving_Behaviour modelElement = (intelligentMobility.Driving_Behaviour) view.getElement();
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		result.addAll(getOutgoingTypeModelFacetLinks_Link_DriverPreference_DrivingBehaviour_4022(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Link_DrivingBehaviour_NormalBehaviour_4031(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Link_Goal_DrivingBehaviour_4037(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getFollowing_Vehicle_2028OutgoingLinks(
			View view) {
		intelligentMobility.Following_Vehicle modelElement = (intelligentMobility.Following_Vehicle) view.getElement();
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		result.addAll(getOutgoingTypeModelFacetLinks_Link_NormalVehicle_SafetyRequirements_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Link_VehicleConfiguration_VehicleType_4013(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Link_FollowingVehicle_FrontVehicle_4023(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getAbnormal_Behaviour_2029OutgoingLinks(
			View view) {
		intelligentMobility.Abnormal_Behaviour modelElement = (intelligentMobility.Abnormal_Behaviour) view
				.getElement();
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		result.addAll(getOutgoingTypeModelFacetLinks_Link_NormalBehaviour_LaneChanging_4020(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Link_NormalBehaviour_Following_4034(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getBackward_2030OutgoingLinks(
			View view) {
		intelligentMobility.Backward modelElement = (intelligentMobility.Backward) view.getElement();
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		result.addAll(getOutgoingTypeModelFacetLinks_Link_AbnormalBehaviour_Action_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Link_Following_Backward_4029(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Link_Action_Backward_4044(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Link_Action_Forward_4045(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Link_Action_Turn_4046(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getIntersection_2031OutgoingLinks(
			View view) {
		intelligentMobility.Intersection modelElement = (intelligentMobility.Intersection) view.getElement();
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		result.addAll(getOutgoingTypeModelFacetLinks_Link_Intersection_TrafficLight_4018(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Link_SpecialCondition_Intersection_4028(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getCommunicationInterface_2032OutgoingLinks(
			View view) {
		intelligentMobility.CommunicationInterface modelElement = (intelligentMobility.CommunicationInterface) view
				.getElement();
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		result.addAll(
				getOutgoingTypeModelFacetLinks_Link_CommunicationInterface_VehicleConfiguration_4036(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Link_CommunicationInterface_Infrastructure_4039(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getGoal_2033OutgoingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getNormal_Behaviour_2034OutgoingLinks(
			View view) {
		intelligentMobility.Normal_Behaviour modelElement = (intelligentMobility.Normal_Behaviour) view.getElement();
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		result.addAll(getOutgoingTypeModelFacetLinks_Link_NormalBehaviour_LaneChanging_4020(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Link_NormalBehaviour_Following_4034(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getPlatoon_2035OutgoingLinks(
			View view) {
		intelligentMobility.Platoon modelElement = (intelligentMobility.Platoon) view.getElement();
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		result.addAll(getOutgoingTypeModelFacetLinks_Link_Platoon_FollowingVehicle_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Link_VehicleConfiguration_VehicleType_4013(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Link_Platoon_LeadingVehicle_4014(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getNormal_Vehicle_2036OutgoingLinks(
			View view) {
		intelligentMobility.Normal_Vehicle modelElement = (intelligentMobility.Normal_Vehicle) view.getElement();
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		result.addAll(getOutgoingTypeModelFacetLinks_Link_NormalVehicle_SafetyRequirements_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Link_VehicleConfiguration_VehicleType_4013(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getCooperativeBehavior_2037OutgoingLinks(
			View view) {
		intelligentMobility.CooperativeBehavior modelElement = (intelligentMobility.CooperativeBehavior) view
				.getElement();
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		result.addAll(getOutgoingTypeModelFacetLinks_Link_DriverPreference_DrivingBehaviour_4022(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Link_DrivingBehaviour_NormalBehaviour_4031(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Link_Goal_DrivingBehaviour_4037(modelElement));
		result.addAll(
				getOutgoingTypeModelFacetLinks_Link_CooperativeBehaviour_CommunicationInterface_4038(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Link_CooperativeBehaviour_VehicleConfiguration_4040(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getAction_2039OutgoingLinks(
			View view) {
		intelligentMobility.Action modelElement = (intelligentMobility.Action) view.getElement();
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		result.addAll(getOutgoingTypeModelFacetLinks_Link_AbnormalBehaviour_Action_4010(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Link_Action_Backward_4044(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Link_Action_Forward_4045(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Link_Action_Turn_4046(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_LaneType_Regulation_4001OutgoingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_Driver_Vehicle_4002OutgoingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_EnvironmentBackground_PossibleVehicle_4003OutgoingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_Vehicle_Environment_4004OutgoingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_NormalVehicle_SafetyRequirements_4005OutgoingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_DriverProfile_DriverPreference_4006OutgoingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_Collision_Obstruction_4007OutgoingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_Platoon_FollowingVehicle_4008OutgoingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_DriverPreference_EnvironmentCondition_4009OutgoingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_AbnormalBehaviour_Action_4010OutgoingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_Following_Forward_4011OutgoingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_EnvironmentCondition_LaneType_4012OutgoingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_VehicleConfiguration_VehicleType_4013OutgoingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_Platoon_LeadingVehicle_4014OutgoingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_Driver_Environment_4015OutgoingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_LaneChanging_Turn_4016OutgoingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_EnvironmentCondition_TrafficCondition_4017OutgoingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_Intersection_TrafficLight_4018OutgoingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_Following_MinGap_4019OutgoingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_NormalBehaviour_LaneChanging_4020OutgoingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_SafetyRequirement_Regulation_4021OutgoingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_DriverPreference_DrivingBehaviour_4022OutgoingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_FollowingVehicle_FrontVehicle_4023OutgoingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_DriverPreference_DriverEmotion_4024OutgoingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_EnvironmentBackground_EnvironmentCondition_4025OutgoingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_EnvironmentCondition_Weather_4026OutgoingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_EnvironmentCondition_SpecialCondition_4027OutgoingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_SpecialCondition_Intersection_4028OutgoingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_Following_Backward_4029OutgoingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_EnvironmentCondition_Regulations_4030OutgoingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_DrivingBehaviour_NormalBehaviour_4031OutgoingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_LaneChanging_EnvironmentCondition_4032OutgoingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_LaneChanging_GapAcceptance_4033OutgoingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_NormalBehaviour_Following_4034OutgoingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_Infrastructure_VehicleConfiguration_4035OutgoingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_CommunicationInterface_VehicleConfiguration_4036OutgoingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_Goal_DrivingBehaviour_4037OutgoingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_CooperativeBehaviour_CommunicationInterface_4038OutgoingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_CommunicationInterface_Infrastructure_4039OutgoingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_CooperativeBehaviour_VehicleConfiguration_4040OutgoingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_TrafficSituation_EnvironmentCondition_4041OutgoingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_Collision_SpecialCondition_4042OutgoingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_Following_LaneChanging_4043OutgoingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	* @generated
	*/
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_Action_Backward_4044OutgoingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	* @generated
	*/
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_Action_Forward_4045OutgoingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	* @generated
	*/
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_Action_Turn_4046OutgoingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	* @generated
	*/
	public static List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getLink_KnowledgeAndSkill_DriverPreference_4047OutgoingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getContainedTypeModelFacetLinks_Link_LaneType_Regulation_4001(
			intelligentMobility.MobilitySystem container) {
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		for (Iterator /*[?]*/ links = container.getLink_laneType_regulation().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof intelligentMobility.Link_LaneType_Regulation) {
				continue;
			}
			intelligentMobility.Link_LaneType_Regulation link = (intelligentMobility.Link_LaneType_Regulation) linkObject;
			if (intelligentMobility.diagram.edit.parts.Link_LaneType_RegulationEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Regulation dst = link.getLink_regulation();
			intelligentMobility.Lane_Type src = link.getLink_laneType();
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, dst, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_LaneType_Regulation_4001,
					intelligentMobility.diagram.edit.parts.Link_LaneType_RegulationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getContainedTypeModelFacetLinks_Link_Driver_Vehicle_4002(
			intelligentMobility.MobilitySystem container) {
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		for (Iterator /*[?]*/ links = container.getLink_driver_vehicle().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof intelligentMobility.Link_Driver_Vehicle) {
				continue;
			}
			intelligentMobility.Link_Driver_Vehicle link = (intelligentMobility.Link_Driver_Vehicle) linkObject;
			if (intelligentMobility.diagram.edit.parts.Link_Driver_VehicleEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Vehicle_Configuration dst = link.getLink_vehicle_configuration();
			intelligentMobility.Driver_Profile src = link.getLink_driver_profile();
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, dst, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Driver_Vehicle_4002,
					intelligentMobility.diagram.edit.parts.Link_Driver_VehicleEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getContainedTypeModelFacetLinks_Link_EnvironmentBackground_PossibleVehicle_4003(
			intelligentMobility.MobilitySystem container) {
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		for (Iterator /*[?]*/ links = container.getLink_environmentBackground_possibleVehicle().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof intelligentMobility.Link_EnvironmentBackground_PossibleVehicle) {
				continue;
			}
			intelligentMobility.Link_EnvironmentBackground_PossibleVehicle link = (intelligentMobility.Link_EnvironmentBackground_PossibleVehicle) linkObject;
			if (intelligentMobility.diagram.edit.parts.Link_EnvironmentBackground_PossibleVehicleEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Environment_Background dst = link.getLink_environment_background();
			intelligentMobility.PossibleVehicle src = link.getLink_possible_vehicle();
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, dst, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_EnvironmentBackground_PossibleVehicle_4003,
					intelligentMobility.diagram.edit.parts.Link_EnvironmentBackground_PossibleVehicleEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getContainedTypeModelFacetLinks_Link_Vehicle_Environment_4004(
			intelligentMobility.MobilitySystem container) {
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		for (Iterator /*[?]*/ links = container.getLink_vehicle_environment().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof intelligentMobility.Link_Vehicle_Environment) {
				continue;
			}
			intelligentMobility.Link_Vehicle_Environment link = (intelligentMobility.Link_Vehicle_Environment) linkObject;
			if (intelligentMobility.diagram.edit.parts.Link_Vehicle_EnvironmentEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Environment_Background dst = link.getLink_environment_background();
			intelligentMobility.Vehicle_Configuration src = link.getLink_vehicle_configuration();
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, dst, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Vehicle_Environment_4004,
					intelligentMobility.diagram.edit.parts.Link_Vehicle_EnvironmentEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getContainedTypeModelFacetLinks_Link_NormalVehicle_SafetyRequirements_4005(
			intelligentMobility.MobilitySystem container) {
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		for (Iterator /*[?]*/ links = container.getLink_normalVehicle_safetyRequirement().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof intelligentMobility.Link_NormalVehicle_SafetyRequirements) {
				continue;
			}
			intelligentMobility.Link_NormalVehicle_SafetyRequirements link = (intelligentMobility.Link_NormalVehicle_SafetyRequirements) linkObject;
			if (intelligentMobility.diagram.edit.parts.Link_NormalVehicle_SafetyRequirementsEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Safety_Requirement dst = link.getLink_safetyRequirement();
			intelligentMobility.Normal_Vehicle src = link.getLink_normalVehicle();
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, dst, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_NormalVehicle_SafetyRequirements_4005,
					intelligentMobility.diagram.edit.parts.Link_NormalVehicle_SafetyRequirementsEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getContainedTypeModelFacetLinks_Link_DriverProfile_DriverPreference_4006(
			intelligentMobility.MobilitySystem container) {
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		for (Iterator /*[?]*/ links = container.getLink_driverProfile_driverPreference().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof intelligentMobility.Link_DriverProfile_DriverPreference) {
				continue;
			}
			intelligentMobility.Link_DriverProfile_DriverPreference link = (intelligentMobility.Link_DriverProfile_DriverPreference) linkObject;
			if (intelligentMobility.diagram.edit.parts.Link_DriverProfile_DriverPreferenceEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Driver_Preference dst = link.getLink_driver_preference();
			intelligentMobility.Driver_Profile src = link.getLink_driver_profile();
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, dst, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_DriverProfile_DriverPreference_4006,
					intelligentMobility.diagram.edit.parts.Link_DriverProfile_DriverPreferenceEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getContainedTypeModelFacetLinks_Link_Collision_Obstruction_4007(
			intelligentMobility.MobilitySystem container) {
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		for (Iterator /*[?]*/ links = container.getLink_collision_obstruction().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof intelligentMobility.Link_Collision_Obstruction) {
				continue;
			}
			intelligentMobility.Link_Collision_Obstruction link = (intelligentMobility.Link_Collision_Obstruction) linkObject;
			if (intelligentMobility.diagram.edit.parts.Link_Collision_ObstructionEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Collision dst = link.getLink_collision();
			intelligentMobility.Obstruction src = link.getLink_obstruction();
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, dst, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Collision_Obstruction_4007,
					intelligentMobility.diagram.edit.parts.Link_Collision_ObstructionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getContainedTypeModelFacetLinks_Link_Platoon_FollowingVehicle_4008(
			intelligentMobility.MobilitySystem container) {
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		for (Iterator /*[?]*/ links = container.getLink_platoon_followingVehicle().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof intelligentMobility.Link_Platoon_FollowingVehicle) {
				continue;
			}
			intelligentMobility.Link_Platoon_FollowingVehicle link = (intelligentMobility.Link_Platoon_FollowingVehicle) linkObject;
			if (intelligentMobility.diagram.edit.parts.Link_Platoon_FollowingVehicleEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Following_Vehicle dst = link.getLink_followingVehicle();
			intelligentMobility.Platoon src = link.getLink_platoon();
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, dst, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Platoon_FollowingVehicle_4008,
					intelligentMobility.diagram.edit.parts.Link_Platoon_FollowingVehicleEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getContainedTypeModelFacetLinks_Link_DriverPreference_EnvironmentCondition_4009(
			intelligentMobility.MobilitySystem container) {
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		for (Iterator /*[?]*/ links = container.getLink_driverPreference_environmentCondition().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof intelligentMobility.Link_DriverPreference_EnvironmentCondition) {
				continue;
			}
			intelligentMobility.Link_DriverPreference_EnvironmentCondition link = (intelligentMobility.Link_DriverPreference_EnvironmentCondition) linkObject;
			if (intelligentMobility.diagram.edit.parts.Link_DriverPreference_EnvironmentConditionEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Environment_Condition dst = link.getLink_environment_condition();
			intelligentMobility.Driver_Preference src = link.getLink_driver_preference();
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, dst, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_DriverPreference_EnvironmentCondition_4009,
					intelligentMobility.diagram.edit.parts.Link_DriverPreference_EnvironmentConditionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getContainedTypeModelFacetLinks_Link_AbnormalBehaviour_Action_4010(
			intelligentMobility.MobilitySystem container) {
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		for (Iterator /*[?]*/ links = container.getLink_abnormalBehaviour_action().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof intelligentMobility.Link_AbnormalBehaviour_Action) {
				continue;
			}
			intelligentMobility.Link_AbnormalBehaviour_Action link = (intelligentMobility.Link_AbnormalBehaviour_Action) linkObject;
			if (intelligentMobility.diagram.edit.parts.Link_AbnormalBehaviour_ActionEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Abnormal_Behaviour dst = link.getLink_abnormalBehaviour();
			intelligentMobility.Action src = link.getLink_action();
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, dst, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_AbnormalBehaviour_Action_4010,
					intelligentMobility.diagram.edit.parts.Link_AbnormalBehaviour_ActionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getContainedTypeModelFacetLinks_Link_Following_Forward_4011(
			intelligentMobility.MobilitySystem container) {
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		for (Iterator /*[?]*/ links = container.getLink_following_forward().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof intelligentMobility.Link_Following_Forward) {
				continue;
			}
			intelligentMobility.Link_Following_Forward link = (intelligentMobility.Link_Following_Forward) linkObject;
			if (intelligentMobility.diagram.edit.parts.Link_Following_ForwardEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Forward dst = link.getLink_forward();
			intelligentMobility.Following src = link.getLink_following();
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, dst, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Following_Forward_4011,
					intelligentMobility.diagram.edit.parts.Link_Following_ForwardEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getContainedTypeModelFacetLinks_Link_EnvironmentCondition_LaneType_4012(
			intelligentMobility.MobilitySystem container) {
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		for (Iterator /*[?]*/ links = container.getLink_environmentCondition_laneType().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof intelligentMobility.Link_EnvironmentCondition_LaneType) {
				continue;
			}
			intelligentMobility.Link_EnvironmentCondition_LaneType link = (intelligentMobility.Link_EnvironmentCondition_LaneType) linkObject;
			if (intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_LaneTypeEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Environment_Condition dst = link.getLink_environmentCondition();
			intelligentMobility.Lane_Type src = link.getLink_laneType();
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, dst, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_EnvironmentCondition_LaneType_4012,
					intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_LaneTypeEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getContainedTypeModelFacetLinks_Link_VehicleConfiguration_VehicleType_4013(
			intelligentMobility.MobilitySystem container) {
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		for (Iterator /*[?]*/ links = container.getLink_vehicleConfiguration_vehicleType().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof intelligentMobility.Link_VehicleConfiguration_VehicleType) {
				continue;
			}
			intelligentMobility.Link_VehicleConfiguration_VehicleType link = (intelligentMobility.Link_VehicleConfiguration_VehicleType) linkObject;
			if (intelligentMobility.diagram.edit.parts.Link_VehicleConfiguration_VehicleTypeEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Vehicle_Configuration dst = link.getLink_vehicle_configuration();
			intelligentMobility.Vehicle_Type src = link.getLink_vehicle_type();
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, dst, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_VehicleConfiguration_VehicleType_4013,
					intelligentMobility.diagram.edit.parts.Link_VehicleConfiguration_VehicleTypeEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getContainedTypeModelFacetLinks_Link_Platoon_LeadingVehicle_4014(
			intelligentMobility.MobilitySystem container) {
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		for (Iterator /*[?]*/ links = container.getLink_platoon_leadingVehicle().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof intelligentMobility.Link_Platoon_LeadingVehicle) {
				continue;
			}
			intelligentMobility.Link_Platoon_LeadingVehicle link = (intelligentMobility.Link_Platoon_LeadingVehicle) linkObject;
			if (intelligentMobility.diagram.edit.parts.Link_Platoon_LeadingVehicleEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Leading_Vehicle dst = link.getLink_leadingVehicle();
			intelligentMobility.Platoon src = link.getLink_platoon();
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, dst, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Platoon_LeadingVehicle_4014,
					intelligentMobility.diagram.edit.parts.Link_Platoon_LeadingVehicleEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getContainedTypeModelFacetLinks_Link_Driver_Environment_4015(
			intelligentMobility.MobilitySystem container) {
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		for (Iterator /*[?]*/ links = container.getLink_driver_environment().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof intelligentMobility.Link_Driver_Environment) {
				continue;
			}
			intelligentMobility.Link_Driver_Environment link = (intelligentMobility.Link_Driver_Environment) linkObject;
			if (intelligentMobility.diagram.edit.parts.Link_Driver_EnvironmentEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Environment_Background dst = link.getLink_environment_background();
			intelligentMobility.Driver_Profile src = link.getLink_driver_profile();
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, dst, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Driver_Environment_4015,
					intelligentMobility.diagram.edit.parts.Link_Driver_EnvironmentEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getContainedTypeModelFacetLinks_Link_LaneChanging_Turn_4016(
			intelligentMobility.MobilitySystem container) {
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		for (Iterator /*[?]*/ links = container.getLink_laneChanging_turn().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof intelligentMobility.Link_LaneChanging_Turn) {
				continue;
			}
			intelligentMobility.Link_LaneChanging_Turn link = (intelligentMobility.Link_LaneChanging_Turn) linkObject;
			if (intelligentMobility.diagram.edit.parts.Link_LaneChanging_TurnEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.LaneChanging dst = link.getLink_laneChanging();
			intelligentMobility.Turn src = link.getLink_turn();
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, dst, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_LaneChanging_Turn_4016,
					intelligentMobility.diagram.edit.parts.Link_LaneChanging_TurnEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getContainedTypeModelFacetLinks_Link_EnvironmentCondition_TrafficCondition_4017(
			intelligentMobility.MobilitySystem container) {
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		for (Iterator /*[?]*/ links = container.getLink_environmentCondition_trafficCondition().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof intelligentMobility.Link_EnvironmentCondition_TrafficCondition) {
				continue;
			}
			intelligentMobility.Link_EnvironmentCondition_TrafficCondition link = (intelligentMobility.Link_EnvironmentCondition_TrafficCondition) linkObject;
			if (intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_TrafficConditionEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Environment_Condition dst = link.getLink_environmentCondition();
			intelligentMobility.Traffic_Situation src = link.getLink_trafficCondition();
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, dst, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_EnvironmentCondition_TrafficCondition_4017,
					intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_TrafficConditionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getContainedTypeModelFacetLinks_Link_Intersection_TrafficLight_4018(
			intelligentMobility.MobilitySystem container) {
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		for (Iterator /*[?]*/ links = container.getLink_intersection_trafficLight().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof intelligentMobility.Link_Intersection_TrafficLight) {
				continue;
			}
			intelligentMobility.Link_Intersection_TrafficLight link = (intelligentMobility.Link_Intersection_TrafficLight) linkObject;
			if (intelligentMobility.diagram.edit.parts.Link_Intersection_TrafficLightEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Traffic_Light dst = link.getLink_trafficLight();
			intelligentMobility.Intersection src = link.getLink_intersection();
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, dst, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Intersection_TrafficLight_4018,
					intelligentMobility.diagram.edit.parts.Link_Intersection_TrafficLightEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getContainedTypeModelFacetLinks_Link_Following_MinGap_4019(
			intelligentMobility.MobilitySystem container) {
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		for (Iterator /*[?]*/ links = container.getLink_following_minGap().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof intelligentMobility.Link_Following_MinGap) {
				continue;
			}
			intelligentMobility.Link_Following_MinGap link = (intelligentMobility.Link_Following_MinGap) linkObject;
			if (intelligentMobility.diagram.edit.parts.Link_Following_MinGapEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.LaneChanging dst = link.getLink_minGap();
			intelligentMobility.Following src = link.getLink_following();
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, dst, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Following_MinGap_4019,
					intelligentMobility.diagram.edit.parts.Link_Following_MinGapEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getContainedTypeModelFacetLinks_Link_NormalBehaviour_LaneChanging_4020(
			intelligentMobility.MobilitySystem container) {
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		for (Iterator /*[?]*/ links = container.getLink_normalBehaviour_laneChanging().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof intelligentMobility.Link_NormalBehaviour_LaneChanging) {
				continue;
			}
			intelligentMobility.Link_NormalBehaviour_LaneChanging link = (intelligentMobility.Link_NormalBehaviour_LaneChanging) linkObject;
			if (intelligentMobility.diagram.edit.parts.Link_NormalBehaviour_LaneChangingEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.LaneChanging dst = link.getLink_lane_changing();
			intelligentMobility.Normal_Behaviour src = link.getLink_normal_behaviour();
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, dst, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_NormalBehaviour_LaneChanging_4020,
					intelligentMobility.diagram.edit.parts.Link_NormalBehaviour_LaneChangingEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getContainedTypeModelFacetLinks_Link_SafetyRequirement_Regulation_4021(
			intelligentMobility.MobilitySystem container) {
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		for (Iterator /*[?]*/ links = container.getLink_safetyRequirement_regulation().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof intelligentMobility.Link_SafetyRequirement_Regulation) {
				continue;
			}
			intelligentMobility.Link_SafetyRequirement_Regulation link = (intelligentMobility.Link_SafetyRequirement_Regulation) linkObject;
			if (intelligentMobility.diagram.edit.parts.Link_SafetyRequirement_RegulationEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Regulation dst = link.getLink_regulation();
			intelligentMobility.Safety_Requirement src = link.getLink_safetyRequirement();
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, dst, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_SafetyRequirement_Regulation_4021,
					intelligentMobility.diagram.edit.parts.Link_SafetyRequirement_RegulationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getContainedTypeModelFacetLinks_Link_DriverPreference_DrivingBehaviour_4022(
			intelligentMobility.MobilitySystem container) {
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		for (Iterator /*[?]*/ links = container.getLink_driverPreference_drivingBehaviour().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof intelligentMobility.Link_DriverPreference_DrivingBehaviour) {
				continue;
			}
			intelligentMobility.Link_DriverPreference_DrivingBehaviour link = (intelligentMobility.Link_DriverPreference_DrivingBehaviour) linkObject;
			if (intelligentMobility.diagram.edit.parts.Link_DriverPreference_DrivingBehaviourEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Driver_Preference dst = link.getLink_driver_preference();
			intelligentMobility.Driving_Behaviour src = link.getLink_driving_behaviour();
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, dst, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_DriverPreference_DrivingBehaviour_4022,
					intelligentMobility.diagram.edit.parts.Link_DriverPreference_DrivingBehaviourEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getContainedTypeModelFacetLinks_Link_FollowingVehicle_FrontVehicle_4023(
			intelligentMobility.MobilitySystem container) {
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		for (Iterator /*[?]*/ links = container.getLink_followingVehicle_frontVehicle().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof intelligentMobility.Link_FollowingVehicle_FrontVehicle) {
				continue;
			}
			intelligentMobility.Link_FollowingVehicle_FrontVehicle link = (intelligentMobility.Link_FollowingVehicle_FrontVehicle) linkObject;
			if (intelligentMobility.diagram.edit.parts.Link_FollowingVehicle_FrontVehicleEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Following_Vehicle dst = link.getLink_followingVehicle();
			intelligentMobility.PlatoonMember src = link.getLink_frontVehicle();
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, dst, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_FollowingVehicle_FrontVehicle_4023,
					intelligentMobility.diagram.edit.parts.Link_FollowingVehicle_FrontVehicleEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getContainedTypeModelFacetLinks_Link_DriverPreference_DriverEmotion_4024(
			intelligentMobility.MobilitySystem container) {
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		for (Iterator /*[?]*/ links = container.getLink_driverPreference_driverEmotion().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof intelligentMobility.Link_DriverPreference_DriverEmotion) {
				continue;
			}
			intelligentMobility.Link_DriverPreference_DriverEmotion link = (intelligentMobility.Link_DriverPreference_DriverEmotion) linkObject;
			if (intelligentMobility.diagram.edit.parts.Link_DriverPreference_DriverEmotionEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Driver_Emotion dst = link.getLink_driver_emotion();
			intelligentMobility.Driver_Preference src = link.getLink_driver_preference();
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, dst, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_DriverPreference_DriverEmotion_4024,
					intelligentMobility.diagram.edit.parts.Link_DriverPreference_DriverEmotionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getContainedTypeModelFacetLinks_Link_EnvironmentBackground_EnvironmentCondition_4025(
			intelligentMobility.MobilitySystem container) {
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		for (Iterator /*[?]*/ links = container.getLink_environmentBackground_environmentCondition().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof intelligentMobility.Link_EnvironmentBackground_EnvironmentCondition) {
				continue;
			}
			intelligentMobility.Link_EnvironmentBackground_EnvironmentCondition link = (intelligentMobility.Link_EnvironmentBackground_EnvironmentCondition) linkObject;
			if (intelligentMobility.diagram.edit.parts.Link_EnvironmentBackground_EnvironmentConditionEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Environment_Condition dst = link.getLink_environment_condition();
			intelligentMobility.Environment_Background src = link.getLink_environment_background();
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, dst, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_EnvironmentBackground_EnvironmentCondition_4025,
					intelligentMobility.diagram.edit.parts.Link_EnvironmentBackground_EnvironmentConditionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getContainedTypeModelFacetLinks_Link_EnvironmentCondition_Weather_4026(
			intelligentMobility.MobilitySystem container) {
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		for (Iterator /*[?]*/ links = container.getLink_environmentCondition_weather().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof intelligentMobility.Link_EnvironmentCondition_Weather) {
				continue;
			}
			intelligentMobility.Link_EnvironmentCondition_Weather link = (intelligentMobility.Link_EnvironmentCondition_Weather) linkObject;
			if (intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_WeatherEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Weather dst = link.getLink_weather();
			intelligentMobility.Environment_Condition src = link.getLink_environmentCondition();
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, dst, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_EnvironmentCondition_Weather_4026,
					intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_WeatherEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getContainedTypeModelFacetLinks_Link_EnvironmentCondition_SpecialCondition_4027(
			intelligentMobility.MobilitySystem container) {
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		for (Iterator /*[?]*/ links = container.getLink_environmentCondition_specialCondition().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof intelligentMobility.Link_EnvironmentCondition_SpecialCondition) {
				continue;
			}
			intelligentMobility.Link_EnvironmentCondition_SpecialCondition link = (intelligentMobility.Link_EnvironmentCondition_SpecialCondition) linkObject;
			if (intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_SpecialConditionEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Special_Condition dst = link.getLink_specialCondition();
			intelligentMobility.Environment_Condition src = link.getLink_environmentCondition();
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, dst, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_EnvironmentCondition_SpecialCondition_4027,
					intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_SpecialConditionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getContainedTypeModelFacetLinks_Link_SpecialCondition_Intersection_4028(
			intelligentMobility.MobilitySystem container) {
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		for (Iterator /*[?]*/ links = container.getLink_specialCondition_intersection().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof intelligentMobility.Link_SpecialCondition_Intersection) {
				continue;
			}
			intelligentMobility.Link_SpecialCondition_Intersection link = (intelligentMobility.Link_SpecialCondition_Intersection) linkObject;
			if (intelligentMobility.diagram.edit.parts.Link_SpecialCondition_IntersectionEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Special_Condition dst = link.getLink_specialCondition();
			intelligentMobility.Intersection src = link.getLink_intersection();
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, dst, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_SpecialCondition_Intersection_4028,
					intelligentMobility.diagram.edit.parts.Link_SpecialCondition_IntersectionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getContainedTypeModelFacetLinks_Link_Following_Backward_4029(
			intelligentMobility.MobilitySystem container) {
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		for (Iterator /*[?]*/ links = container.getLink_following_backward().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof intelligentMobility.Link_Following_Backward) {
				continue;
			}
			intelligentMobility.Link_Following_Backward link = (intelligentMobility.Link_Following_Backward) linkObject;
			if (intelligentMobility.diagram.edit.parts.Link_Following_BackwardEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Following dst = link.getLink_following();
			intelligentMobility.Backward src = link.getLink_backward();
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, dst, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Following_Backward_4029,
					intelligentMobility.diagram.edit.parts.Link_Following_BackwardEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getContainedTypeModelFacetLinks_Link_EnvironmentCondition_Regulations_4030(
			intelligentMobility.MobilitySystem container) {
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		for (Iterator /*[?]*/ links = container.getLink_environmentCondition_regulation().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof intelligentMobility.Link_EnvironmentCondition_Regulations) {
				continue;
			}
			intelligentMobility.Link_EnvironmentCondition_Regulations link = (intelligentMobility.Link_EnvironmentCondition_Regulations) linkObject;
			if (intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_RegulationsEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Regulation dst = link.getLink_regulation();
			intelligentMobility.Environment_Condition src = link.getLink_environmentCondition();
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, dst, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_EnvironmentCondition_Regulations_4030,
					intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_RegulationsEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getContainedTypeModelFacetLinks_Link_DrivingBehaviour_NormalBehaviour_4031(
			intelligentMobility.MobilitySystem container) {
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		for (Iterator /*[?]*/ links = container.getLink_drivingBehaviour_normalBehaviour().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof intelligentMobility.Link_DrivingBehaviour_NormalBehaviour) {
				continue;
			}
			intelligentMobility.Link_DrivingBehaviour_NormalBehaviour link = (intelligentMobility.Link_DrivingBehaviour_NormalBehaviour) linkObject;
			if (intelligentMobility.diagram.edit.parts.Link_DrivingBehaviour_NormalBehaviourEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Normal_Behaviour dst = link.getLink_normal_behaviour();
			intelligentMobility.Driving_Behaviour src = link.getLink_driving_behaviour();
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, dst, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_DrivingBehaviour_NormalBehaviour_4031,
					intelligentMobility.diagram.edit.parts.Link_DrivingBehaviour_NormalBehaviourEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getContainedTypeModelFacetLinks_Link_LaneChanging_EnvironmentCondition_4032(
			intelligentMobility.MobilitySystem container) {
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		for (Iterator /*[?]*/ links = container.getLink_laneChanging_environmentCondition().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof intelligentMobility.Link_LaneChanging_EnvironmentCondition) {
				continue;
			}
			intelligentMobility.Link_LaneChanging_EnvironmentCondition link = (intelligentMobility.Link_LaneChanging_EnvironmentCondition) linkObject;
			if (intelligentMobility.diagram.edit.parts.Link_LaneChanging_EnvironmentConditionEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Environment_Condition dst = link.getLink_environmentCondition();
			intelligentMobility.LaneChanging src = link.getLink_laneChanging();
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, dst, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_LaneChanging_EnvironmentCondition_4032,
					intelligentMobility.diagram.edit.parts.Link_LaneChanging_EnvironmentConditionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getContainedTypeModelFacetLinks_Link_LaneChanging_GapAcceptance_4033(
			intelligentMobility.MobilitySystem container) {
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		for (Iterator /*[?]*/ links = container.getLink_laneChanging_gapAcceptance().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof intelligentMobility.Link_LaneChanging_GapAcceptance) {
				continue;
			}
			intelligentMobility.Link_LaneChanging_GapAcceptance link = (intelligentMobility.Link_LaneChanging_GapAcceptance) linkObject;
			if (intelligentMobility.diagram.edit.parts.Link_LaneChanging_GapAcceptanceEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.GapAcceptance dst = link.getLink_gapAcceptance();
			intelligentMobility.LaneChanging src = link.getLink_laneChanging();
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, dst, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_LaneChanging_GapAcceptance_4033,
					intelligentMobility.diagram.edit.parts.Link_LaneChanging_GapAcceptanceEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getContainedTypeModelFacetLinks_Link_NormalBehaviour_Following_4034(
			intelligentMobility.MobilitySystem container) {
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		for (Iterator /*[?]*/ links = container.getLink_normalBehaviour_following().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof intelligentMobility.Link_NormalBehaviour_Following) {
				continue;
			}
			intelligentMobility.Link_NormalBehaviour_Following link = (intelligentMobility.Link_NormalBehaviour_Following) linkObject;
			if (intelligentMobility.diagram.edit.parts.Link_NormalBehaviour_FollowingEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Following dst = link.getLink_following();
			intelligentMobility.Normal_Behaviour src = link.getLink_normal_behaviour();
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, dst, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_NormalBehaviour_Following_4034,
					intelligentMobility.diagram.edit.parts.Link_NormalBehaviour_FollowingEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getContainedTypeModelFacetLinks_Link_Infrastructure_VehicleConfiguration_4035(
			intelligentMobility.MobilitySystem container) {
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		for (Iterator /*[?]*/ links = container.getLink_infrastructure_vehicle_configuration().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof intelligentMobility.Link_Infrastructure_VehicleConfiguration) {
				continue;
			}
			intelligentMobility.Link_Infrastructure_VehicleConfiguration link = (intelligentMobility.Link_Infrastructure_VehicleConfiguration) linkObject;
			if (intelligentMobility.diagram.edit.parts.Link_Infrastructure_VehicleConfigurationEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Infrastructure dst = link.getLink_infrastructure();
			intelligentMobility.Vehicle_Configuration src = link.getLink_vehicle_configuration();
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, dst, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Infrastructure_VehicleConfiguration_4035,
					intelligentMobility.diagram.edit.parts.Link_Infrastructure_VehicleConfigurationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getContainedTypeModelFacetLinks_Link_CommunicationInterface_VehicleConfiguration_4036(
			intelligentMobility.MobilitySystem container) {
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		for (Iterator /*[?]*/ links = container.getLink_communicationInterface_vehicleConfiguration().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof intelligentMobility.Link_CommunicationInterface_VehicleConfiguration) {
				continue;
			}
			intelligentMobility.Link_CommunicationInterface_VehicleConfiguration link = (intelligentMobility.Link_CommunicationInterface_VehicleConfiguration) linkObject;
			if (intelligentMobility.diagram.edit.parts.Link_CommunicationInterface_VehicleConfigurationEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Vehicle_Configuration dst = link.getLink_vehicle_configuration();
			intelligentMobility.CommunicationInterface src = link.getLink_communication_interface();
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, dst, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_CommunicationInterface_VehicleConfiguration_4036,
					intelligentMobility.diagram.edit.parts.Link_CommunicationInterface_VehicleConfigurationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getContainedTypeModelFacetLinks_Link_Goal_DrivingBehaviour_4037(
			intelligentMobility.MobilitySystem container) {
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		for (Iterator /*[?]*/ links = container.getLink_goal_drivingBehaviour().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof intelligentMobility.Link_Goal_DrivingBehaviour) {
				continue;
			}
			intelligentMobility.Link_Goal_DrivingBehaviour link = (intelligentMobility.Link_Goal_DrivingBehaviour) linkObject;
			if (intelligentMobility.diagram.edit.parts.Link_Goal_DrivingBehaviourEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Goal dst = link.getLink_goal();
			intelligentMobility.Driving_Behaviour src = link.getLink_drivingBehaviour();
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, dst, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Goal_DrivingBehaviour_4037,
					intelligentMobility.diagram.edit.parts.Link_Goal_DrivingBehaviourEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getContainedTypeModelFacetLinks_Link_CooperativeBehaviour_CommunicationInterface_4038(
			intelligentMobility.MobilitySystem container) {
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		for (Iterator /*[?]*/ links = container.getLink_cooperativeBehaviour_communicationInterface().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof intelligentMobility.Link_CooperativeBehaviour_CommunicationInterface) {
				continue;
			}
			intelligentMobility.Link_CooperativeBehaviour_CommunicationInterface link = (intelligentMobility.Link_CooperativeBehaviour_CommunicationInterface) linkObject;
			if (intelligentMobility.diagram.edit.parts.Link_CooperativeBehaviour_CommunicationInterfaceEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.CommunicationInterface dst = link.getLink_communicationInterface();
			intelligentMobility.CooperativeBehavior src = link.getLink_cooperativeBehaviour();
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, dst, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_CooperativeBehaviour_CommunicationInterface_4038,
					intelligentMobility.diagram.edit.parts.Link_CooperativeBehaviour_CommunicationInterfaceEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getContainedTypeModelFacetLinks_Link_CommunicationInterface_Infrastructure_4039(
			intelligentMobility.MobilitySystem container) {
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		for (Iterator /*[?]*/ links = container.getLink_communicationInterface_infrastructure().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof intelligentMobility.Link_CommunicationInterface_Infrastructure) {
				continue;
			}
			intelligentMobility.Link_CommunicationInterface_Infrastructure link = (intelligentMobility.Link_CommunicationInterface_Infrastructure) linkObject;
			if (intelligentMobility.diagram.edit.parts.Link_CommunicationInterface_InfrastructureEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Infrastructure dst = link.getLink_infrastructure();
			intelligentMobility.CommunicationInterface src = link.getLink_communicationInterface();
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, dst, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_CommunicationInterface_Infrastructure_4039,
					intelligentMobility.diagram.edit.parts.Link_CommunicationInterface_InfrastructureEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getContainedTypeModelFacetLinks_Link_CooperativeBehaviour_VehicleConfiguration_4040(
			intelligentMobility.MobilitySystem container) {
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		for (Iterator /*[?]*/ links = container.getLink_cooperativeBehaviour_vehicleConfiguration().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof intelligentMobility.Link_CooperativeBehaviour_VehicleConfiguration) {
				continue;
			}
			intelligentMobility.Link_CooperativeBehaviour_VehicleConfiguration link = (intelligentMobility.Link_CooperativeBehaviour_VehicleConfiguration) linkObject;
			if (intelligentMobility.diagram.edit.parts.Link_CooperativeBehaviour_VehicleConfigurationEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Vehicle_Configuration dst = link.getLink_vehicleConfiguration();
			intelligentMobility.CooperativeBehavior src = link.getLink_cooperativeBehaviour();
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, dst, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_CooperativeBehaviour_VehicleConfiguration_4040,
					intelligentMobility.diagram.edit.parts.Link_CooperativeBehaviour_VehicleConfigurationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getContainedTypeModelFacetLinks_Link_TrafficSituation_EnvironmentCondition_4041(
			intelligentMobility.MobilitySystem container) {
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		for (Iterator /*[?]*/ links = container.getLink_trafficSituation_environmentCondition().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof intelligentMobility.Link_TrafficSituation_EnvironmentCondition) {
				continue;
			}
			intelligentMobility.Link_TrafficSituation_EnvironmentCondition link = (intelligentMobility.Link_TrafficSituation_EnvironmentCondition) linkObject;
			if (intelligentMobility.diagram.edit.parts.Link_TrafficSituation_EnvironmentConditionEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Traffic_Situation dst = link.getLink_trafficSituation();
			intelligentMobility.Environment_Condition src = link.getLink_environmentCondition();
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, dst, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_TrafficSituation_EnvironmentCondition_4041,
					intelligentMobility.diagram.edit.parts.Link_TrafficSituation_EnvironmentConditionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getContainedTypeModelFacetLinks_Link_Collision_SpecialCondition_4042(
			intelligentMobility.MobilitySystem container) {
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		for (Iterator /*[?]*/ links = container.getLink_collision_specialCondition().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof intelligentMobility.Link_Collision_SpecialCondition) {
				continue;
			}
			intelligentMobility.Link_Collision_SpecialCondition link = (intelligentMobility.Link_Collision_SpecialCondition) linkObject;
			if (intelligentMobility.diagram.edit.parts.Link_Collision_SpecialConditionEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Special_Condition dst = link.getLink_specialCondition();
			intelligentMobility.Collision src = link.getLink_collision();
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, dst, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Collision_SpecialCondition_4042,
					intelligentMobility.diagram.edit.parts.Link_Collision_SpecialConditionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getContainedTypeModelFacetLinks_Link_Following_LaneChanging_4043(
			intelligentMobility.MobilitySystem container) {
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		for (Iterator /*[?]*/ links = container.getLink_following_laneChanging().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof intelligentMobility.Link_Following_LaneChanging) {
				continue;
			}
			intelligentMobility.Link_Following_LaneChanging link = (intelligentMobility.Link_Following_LaneChanging) linkObject;
			if (intelligentMobility.diagram.edit.parts.Link_Following_LaneChangingEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.LaneChanging dst = link.getLink_laneChanging();
			intelligentMobility.Following src = link.getLink_following();
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, dst, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Following_LaneChanging_4043,
					intelligentMobility.diagram.edit.parts.Link_Following_LaneChangingEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getContainedTypeModelFacetLinks_Link_Action_Backward_4044(
			intelligentMobility.MobilitySystem container) {
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		for (Iterator /*[?]*/ links = container.getLink_action_backward().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof intelligentMobility.Link_Action_Backward) {
				continue;
			}
			intelligentMobility.Link_Action_Backward link = (intelligentMobility.Link_Action_Backward) linkObject;
			if (intelligentMobility.diagram.edit.parts.Link_Action_BackwardEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Backward dst = link.getLink_backward();
			intelligentMobility.Action src = link.getLink_action();
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, dst, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Action_Backward_4044,
					intelligentMobility.diagram.edit.parts.Link_Action_BackwardEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getContainedTypeModelFacetLinks_Link_Action_Forward_4045(
			intelligentMobility.MobilitySystem container) {
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		for (Iterator /*[?]*/ links = container.getLink_action_forward().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof intelligentMobility.Link_Action_Forward) {
				continue;
			}
			intelligentMobility.Link_Action_Forward link = (intelligentMobility.Link_Action_Forward) linkObject;
			if (intelligentMobility.diagram.edit.parts.Link_Action_ForwardEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Forward dst = link.getLink_forward();
			intelligentMobility.Action src = link.getLink_action();
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, dst, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Action_Forward_4045,
					intelligentMobility.diagram.edit.parts.Link_Action_ForwardEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getContainedTypeModelFacetLinks_Link_Action_Turn_4046(
			intelligentMobility.MobilitySystem container) {
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		for (Iterator /*[?]*/ links = container.getLink_action_turn().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof intelligentMobility.Link_Action_Turn) {
				continue;
			}
			intelligentMobility.Link_Action_Turn link = (intelligentMobility.Link_Action_Turn) linkObject;
			if (intelligentMobility.diagram.edit.parts.Link_Action_TurnEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Turn dst = link.getLink_turn();
			intelligentMobility.Action src = link.getLink_action();
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, dst, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Action_Turn_4046,
					intelligentMobility.diagram.edit.parts.Link_Action_TurnEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getContainedTypeModelFacetLinks_Link_KnowledgeAndSkill_DriverPreference_4047(
			intelligentMobility.MobilitySystem container) {
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		for (Iterator /*[?]*/ links = container.getLink_knowledgeAndSkill_driverPreference().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof intelligentMobility.Link_KnowledgeAndSkill_DriverPreference) {
				continue;
			}
			intelligentMobility.Link_KnowledgeAndSkill_DriverPreference link = (intelligentMobility.Link_KnowledgeAndSkill_DriverPreference) linkObject;
			if (intelligentMobility.diagram.edit.parts.Link_KnowledgeAndSkill_DriverPreferenceEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Knowledge_and_Skill dst = link.getLink_knowledgeAndSkill();
			intelligentMobility.Driver_Preference src = link.getLink_driverPreference();
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, dst, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_KnowledgeAndSkill_DriverPreference_4047,
					intelligentMobility.diagram.edit.parts.Link_KnowledgeAndSkill_DriverPreferenceEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getIncomingTypeModelFacetLinks_Link_LaneType_Regulation_4001(
			intelligentMobility.Regulation target,
			Map/*[org.eclipse.emf.ecore.EObject, java.util.Collection<org.eclipse.emf.ecore.EStructuralFeature.Setting>]*/ crossReferences) {
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		Collection/*[org.eclipse.emf.ecore.EStructuralFeature.Setting]*/ settings = (Collection) crossReferences
				.get(target);
		for (Iterator /*[org.eclipse.emf.ecore.EStructuralFeature.Setting]*/ it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() != intelligentMobility.IntelligentMobilityPackage.eINSTANCE
					.getLink_LaneType_Regulation_Link_regulation()
					|| false == setting.getEObject() instanceof intelligentMobility.Link_LaneType_Regulation) {
				continue;
			}
			intelligentMobility.Link_LaneType_Regulation link = (intelligentMobility.Link_LaneType_Regulation) setting
					.getEObject();
			if (intelligentMobility.diagram.edit.parts.Link_LaneType_RegulationEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Lane_Type src = link.getLink_laneType();
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, target, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_LaneType_Regulation_4001,
					intelligentMobility.diagram.edit.parts.Link_LaneType_RegulationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getIncomingTypeModelFacetLinks_Link_Driver_Vehicle_4002(
			intelligentMobility.Vehicle_Configuration target,
			Map/*[org.eclipse.emf.ecore.EObject, java.util.Collection<org.eclipse.emf.ecore.EStructuralFeature.Setting>]*/ crossReferences) {
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		Collection/*[org.eclipse.emf.ecore.EStructuralFeature.Setting]*/ settings = (Collection) crossReferences
				.get(target);
		for (Iterator /*[org.eclipse.emf.ecore.EStructuralFeature.Setting]*/ it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() != intelligentMobility.IntelligentMobilityPackage.eINSTANCE
					.getLink_Driver_Vehicle_Link_vehicle_configuration()
					|| false == setting.getEObject() instanceof intelligentMobility.Link_Driver_Vehicle) {
				continue;
			}
			intelligentMobility.Link_Driver_Vehicle link = (intelligentMobility.Link_Driver_Vehicle) setting
					.getEObject();
			if (intelligentMobility.diagram.edit.parts.Link_Driver_VehicleEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Driver_Profile src = link.getLink_driver_profile();
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, target, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Driver_Vehicle_4002,
					intelligentMobility.diagram.edit.parts.Link_Driver_VehicleEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getIncomingTypeModelFacetLinks_Link_EnvironmentBackground_PossibleVehicle_4003(
			intelligentMobility.Environment_Background target,
			Map/*[org.eclipse.emf.ecore.EObject, java.util.Collection<org.eclipse.emf.ecore.EStructuralFeature.Setting>]*/ crossReferences) {
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		Collection/*[org.eclipse.emf.ecore.EStructuralFeature.Setting]*/ settings = (Collection) crossReferences
				.get(target);
		for (Iterator /*[org.eclipse.emf.ecore.EStructuralFeature.Setting]*/ it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() != intelligentMobility.IntelligentMobilityPackage.eINSTANCE
					.getLink_EnvironmentBackground_PossibleVehicle_Link_environment_background()
					|| false == setting
							.getEObject() instanceof intelligentMobility.Link_EnvironmentBackground_PossibleVehicle) {
				continue;
			}
			intelligentMobility.Link_EnvironmentBackground_PossibleVehicle link = (intelligentMobility.Link_EnvironmentBackground_PossibleVehicle) setting
					.getEObject();
			if (intelligentMobility.diagram.edit.parts.Link_EnvironmentBackground_PossibleVehicleEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.PossibleVehicle src = link.getLink_possible_vehicle();
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, target, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_EnvironmentBackground_PossibleVehicle_4003,
					intelligentMobility.diagram.edit.parts.Link_EnvironmentBackground_PossibleVehicleEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getIncomingTypeModelFacetLinks_Link_Vehicle_Environment_4004(
			intelligentMobility.Environment_Background target,
			Map/*[org.eclipse.emf.ecore.EObject, java.util.Collection<org.eclipse.emf.ecore.EStructuralFeature.Setting>]*/ crossReferences) {
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		Collection/*[org.eclipse.emf.ecore.EStructuralFeature.Setting]*/ settings = (Collection) crossReferences
				.get(target);
		for (Iterator /*[org.eclipse.emf.ecore.EStructuralFeature.Setting]*/ it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() != intelligentMobility.IntelligentMobilityPackage.eINSTANCE
					.getLink_Vehicle_Environment_Link_environment_background()
					|| false == setting.getEObject() instanceof intelligentMobility.Link_Vehicle_Environment) {
				continue;
			}
			intelligentMobility.Link_Vehicle_Environment link = (intelligentMobility.Link_Vehicle_Environment) setting
					.getEObject();
			if (intelligentMobility.diagram.edit.parts.Link_Vehicle_EnvironmentEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Vehicle_Configuration src = link.getLink_vehicle_configuration();
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, target, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Vehicle_Environment_4004,
					intelligentMobility.diagram.edit.parts.Link_Vehicle_EnvironmentEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getIncomingTypeModelFacetLinks_Link_NormalVehicle_SafetyRequirements_4005(
			intelligentMobility.Safety_Requirement target,
			Map/*[org.eclipse.emf.ecore.EObject, java.util.Collection<org.eclipse.emf.ecore.EStructuralFeature.Setting>]*/ crossReferences) {
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		Collection/*[org.eclipse.emf.ecore.EStructuralFeature.Setting]*/ settings = (Collection) crossReferences
				.get(target);
		for (Iterator /*[org.eclipse.emf.ecore.EStructuralFeature.Setting]*/ it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() != intelligentMobility.IntelligentMobilityPackage.eINSTANCE
					.getLink_NormalVehicle_SafetyRequirements_Link_safetyRequirement()
					|| false == setting
							.getEObject() instanceof intelligentMobility.Link_NormalVehicle_SafetyRequirements) {
				continue;
			}
			intelligentMobility.Link_NormalVehicle_SafetyRequirements link = (intelligentMobility.Link_NormalVehicle_SafetyRequirements) setting
					.getEObject();
			if (intelligentMobility.diagram.edit.parts.Link_NormalVehicle_SafetyRequirementsEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Normal_Vehicle src = link.getLink_normalVehicle();
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, target, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_NormalVehicle_SafetyRequirements_4005,
					intelligentMobility.diagram.edit.parts.Link_NormalVehicle_SafetyRequirementsEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getIncomingTypeModelFacetLinks_Link_DriverProfile_DriverPreference_4006(
			intelligentMobility.Driver_Preference target,
			Map/*[org.eclipse.emf.ecore.EObject, java.util.Collection<org.eclipse.emf.ecore.EStructuralFeature.Setting>]*/ crossReferences) {
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		Collection/*[org.eclipse.emf.ecore.EStructuralFeature.Setting]*/ settings = (Collection) crossReferences
				.get(target);
		for (Iterator /*[org.eclipse.emf.ecore.EStructuralFeature.Setting]*/ it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() != intelligentMobility.IntelligentMobilityPackage.eINSTANCE
					.getLink_DriverProfile_DriverPreference_Link_driver_preference()
					|| false == setting
							.getEObject() instanceof intelligentMobility.Link_DriverProfile_DriverPreference) {
				continue;
			}
			intelligentMobility.Link_DriverProfile_DriverPreference link = (intelligentMobility.Link_DriverProfile_DriverPreference) setting
					.getEObject();
			if (intelligentMobility.diagram.edit.parts.Link_DriverProfile_DriverPreferenceEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Driver_Profile src = link.getLink_driver_profile();
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, target, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_DriverProfile_DriverPreference_4006,
					intelligentMobility.diagram.edit.parts.Link_DriverProfile_DriverPreferenceEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getIncomingTypeModelFacetLinks_Link_Collision_Obstruction_4007(
			intelligentMobility.Collision target,
			Map/*[org.eclipse.emf.ecore.EObject, java.util.Collection<org.eclipse.emf.ecore.EStructuralFeature.Setting>]*/ crossReferences) {
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		Collection/*[org.eclipse.emf.ecore.EStructuralFeature.Setting]*/ settings = (Collection) crossReferences
				.get(target);
		for (Iterator /*[org.eclipse.emf.ecore.EStructuralFeature.Setting]*/ it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() != intelligentMobility.IntelligentMobilityPackage.eINSTANCE
					.getLink_Collision_Obstruction_Link_collision()
					|| false == setting.getEObject() instanceof intelligentMobility.Link_Collision_Obstruction) {
				continue;
			}
			intelligentMobility.Link_Collision_Obstruction link = (intelligentMobility.Link_Collision_Obstruction) setting
					.getEObject();
			if (intelligentMobility.diagram.edit.parts.Link_Collision_ObstructionEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Obstruction src = link.getLink_obstruction();
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, target, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Collision_Obstruction_4007,
					intelligentMobility.diagram.edit.parts.Link_Collision_ObstructionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getIncomingTypeModelFacetLinks_Link_Platoon_FollowingVehicle_4008(
			intelligentMobility.Following_Vehicle target,
			Map/*[org.eclipse.emf.ecore.EObject, java.util.Collection<org.eclipse.emf.ecore.EStructuralFeature.Setting>]*/ crossReferences) {
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		Collection/*[org.eclipse.emf.ecore.EStructuralFeature.Setting]*/ settings = (Collection) crossReferences
				.get(target);
		for (Iterator /*[org.eclipse.emf.ecore.EStructuralFeature.Setting]*/ it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() != intelligentMobility.IntelligentMobilityPackage.eINSTANCE
					.getLink_Platoon_FollowingVehicle_Link_followingVehicle()
					|| false == setting.getEObject() instanceof intelligentMobility.Link_Platoon_FollowingVehicle) {
				continue;
			}
			intelligentMobility.Link_Platoon_FollowingVehicle link = (intelligentMobility.Link_Platoon_FollowingVehicle) setting
					.getEObject();
			if (intelligentMobility.diagram.edit.parts.Link_Platoon_FollowingVehicleEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Platoon src = link.getLink_platoon();
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, target, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Platoon_FollowingVehicle_4008,
					intelligentMobility.diagram.edit.parts.Link_Platoon_FollowingVehicleEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getIncomingTypeModelFacetLinks_Link_DriverPreference_EnvironmentCondition_4009(
			intelligentMobility.Environment_Condition target,
			Map/*[org.eclipse.emf.ecore.EObject, java.util.Collection<org.eclipse.emf.ecore.EStructuralFeature.Setting>]*/ crossReferences) {
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		Collection/*[org.eclipse.emf.ecore.EStructuralFeature.Setting]*/ settings = (Collection) crossReferences
				.get(target);
		for (Iterator /*[org.eclipse.emf.ecore.EStructuralFeature.Setting]*/ it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() != intelligentMobility.IntelligentMobilityPackage.eINSTANCE
					.getLink_DriverPreference_EnvironmentCondition_Link_environment_condition()
					|| false == setting
							.getEObject() instanceof intelligentMobility.Link_DriverPreference_EnvironmentCondition) {
				continue;
			}
			intelligentMobility.Link_DriverPreference_EnvironmentCondition link = (intelligentMobility.Link_DriverPreference_EnvironmentCondition) setting
					.getEObject();
			if (intelligentMobility.diagram.edit.parts.Link_DriverPreference_EnvironmentConditionEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Driver_Preference src = link.getLink_driver_preference();
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, target, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_DriverPreference_EnvironmentCondition_4009,
					intelligentMobility.diagram.edit.parts.Link_DriverPreference_EnvironmentConditionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getIncomingTypeModelFacetLinks_Link_AbnormalBehaviour_Action_4010(
			intelligentMobility.Abnormal_Behaviour target,
			Map/*[org.eclipse.emf.ecore.EObject, java.util.Collection<org.eclipse.emf.ecore.EStructuralFeature.Setting>]*/ crossReferences) {
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		Collection/*[org.eclipse.emf.ecore.EStructuralFeature.Setting]*/ settings = (Collection) crossReferences
				.get(target);
		for (Iterator /*[org.eclipse.emf.ecore.EStructuralFeature.Setting]*/ it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() != intelligentMobility.IntelligentMobilityPackage.eINSTANCE
					.getLink_AbnormalBehaviour_Action_Link_abnormalBehaviour()
					|| false == setting.getEObject() instanceof intelligentMobility.Link_AbnormalBehaviour_Action) {
				continue;
			}
			intelligentMobility.Link_AbnormalBehaviour_Action link = (intelligentMobility.Link_AbnormalBehaviour_Action) setting
					.getEObject();
			if (intelligentMobility.diagram.edit.parts.Link_AbnormalBehaviour_ActionEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Action src = link.getLink_action();
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, target, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_AbnormalBehaviour_Action_4010,
					intelligentMobility.diagram.edit.parts.Link_AbnormalBehaviour_ActionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getIncomingTypeModelFacetLinks_Link_Following_Forward_4011(
			intelligentMobility.Forward target,
			Map/*[org.eclipse.emf.ecore.EObject, java.util.Collection<org.eclipse.emf.ecore.EStructuralFeature.Setting>]*/ crossReferences) {
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		Collection/*[org.eclipse.emf.ecore.EStructuralFeature.Setting]*/ settings = (Collection) crossReferences
				.get(target);
		for (Iterator /*[org.eclipse.emf.ecore.EStructuralFeature.Setting]*/ it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() != intelligentMobility.IntelligentMobilityPackage.eINSTANCE
					.getLink_Following_Forward_Link_forward()
					|| false == setting.getEObject() instanceof intelligentMobility.Link_Following_Forward) {
				continue;
			}
			intelligentMobility.Link_Following_Forward link = (intelligentMobility.Link_Following_Forward) setting
					.getEObject();
			if (intelligentMobility.diagram.edit.parts.Link_Following_ForwardEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Following src = link.getLink_following();
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, target, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Following_Forward_4011,
					intelligentMobility.diagram.edit.parts.Link_Following_ForwardEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getIncomingTypeModelFacetLinks_Link_EnvironmentCondition_LaneType_4012(
			intelligentMobility.Environment_Condition target,
			Map/*[org.eclipse.emf.ecore.EObject, java.util.Collection<org.eclipse.emf.ecore.EStructuralFeature.Setting>]*/ crossReferences) {
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		Collection/*[org.eclipse.emf.ecore.EStructuralFeature.Setting]*/ settings = (Collection) crossReferences
				.get(target);
		for (Iterator /*[org.eclipse.emf.ecore.EStructuralFeature.Setting]*/ it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() != intelligentMobility.IntelligentMobilityPackage.eINSTANCE
					.getLink_EnvironmentCondition_LaneType_Link_environmentCondition()
					|| false == setting
							.getEObject() instanceof intelligentMobility.Link_EnvironmentCondition_LaneType) {
				continue;
			}
			intelligentMobility.Link_EnvironmentCondition_LaneType link = (intelligentMobility.Link_EnvironmentCondition_LaneType) setting
					.getEObject();
			if (intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_LaneTypeEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Lane_Type src = link.getLink_laneType();
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, target, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_EnvironmentCondition_LaneType_4012,
					intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_LaneTypeEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getIncomingTypeModelFacetLinks_Link_VehicleConfiguration_VehicleType_4013(
			intelligentMobility.Vehicle_Configuration target,
			Map/*[org.eclipse.emf.ecore.EObject, java.util.Collection<org.eclipse.emf.ecore.EStructuralFeature.Setting>]*/ crossReferences) {
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		Collection/*[org.eclipse.emf.ecore.EStructuralFeature.Setting]*/ settings = (Collection) crossReferences
				.get(target);
		for (Iterator /*[org.eclipse.emf.ecore.EStructuralFeature.Setting]*/ it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() != intelligentMobility.IntelligentMobilityPackage.eINSTANCE
					.getLink_VehicleConfiguration_VehicleType_Link_vehicle_configuration()
					|| false == setting
							.getEObject() instanceof intelligentMobility.Link_VehicleConfiguration_VehicleType) {
				continue;
			}
			intelligentMobility.Link_VehicleConfiguration_VehicleType link = (intelligentMobility.Link_VehicleConfiguration_VehicleType) setting
					.getEObject();
			if (intelligentMobility.diagram.edit.parts.Link_VehicleConfiguration_VehicleTypeEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Vehicle_Type src = link.getLink_vehicle_type();
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, target, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_VehicleConfiguration_VehicleType_4013,
					intelligentMobility.diagram.edit.parts.Link_VehicleConfiguration_VehicleTypeEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getIncomingTypeModelFacetLinks_Link_Platoon_LeadingVehicle_4014(
			intelligentMobility.Leading_Vehicle target,
			Map/*[org.eclipse.emf.ecore.EObject, java.util.Collection<org.eclipse.emf.ecore.EStructuralFeature.Setting>]*/ crossReferences) {
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		Collection/*[org.eclipse.emf.ecore.EStructuralFeature.Setting]*/ settings = (Collection) crossReferences
				.get(target);
		for (Iterator /*[org.eclipse.emf.ecore.EStructuralFeature.Setting]*/ it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() != intelligentMobility.IntelligentMobilityPackage.eINSTANCE
					.getLink_Platoon_LeadingVehicle_Link_leadingVehicle()
					|| false == setting.getEObject() instanceof intelligentMobility.Link_Platoon_LeadingVehicle) {
				continue;
			}
			intelligentMobility.Link_Platoon_LeadingVehicle link = (intelligentMobility.Link_Platoon_LeadingVehicle) setting
					.getEObject();
			if (intelligentMobility.diagram.edit.parts.Link_Platoon_LeadingVehicleEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Platoon src = link.getLink_platoon();
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, target, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Platoon_LeadingVehicle_4014,
					intelligentMobility.diagram.edit.parts.Link_Platoon_LeadingVehicleEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getIncomingTypeModelFacetLinks_Link_Driver_Environment_4015(
			intelligentMobility.Environment_Background target,
			Map/*[org.eclipse.emf.ecore.EObject, java.util.Collection<org.eclipse.emf.ecore.EStructuralFeature.Setting>]*/ crossReferences) {
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		Collection/*[org.eclipse.emf.ecore.EStructuralFeature.Setting]*/ settings = (Collection) crossReferences
				.get(target);
		for (Iterator /*[org.eclipse.emf.ecore.EStructuralFeature.Setting]*/ it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() != intelligentMobility.IntelligentMobilityPackage.eINSTANCE
					.getLink_Driver_Environment_Link_environment_background()
					|| false == setting.getEObject() instanceof intelligentMobility.Link_Driver_Environment) {
				continue;
			}
			intelligentMobility.Link_Driver_Environment link = (intelligentMobility.Link_Driver_Environment) setting
					.getEObject();
			if (intelligentMobility.diagram.edit.parts.Link_Driver_EnvironmentEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Driver_Profile src = link.getLink_driver_profile();
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, target, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Driver_Environment_4015,
					intelligentMobility.diagram.edit.parts.Link_Driver_EnvironmentEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getIncomingTypeModelFacetLinks_Link_LaneChanging_Turn_4016(
			intelligentMobility.LaneChanging target,
			Map/*[org.eclipse.emf.ecore.EObject, java.util.Collection<org.eclipse.emf.ecore.EStructuralFeature.Setting>]*/ crossReferences) {
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		Collection/*[org.eclipse.emf.ecore.EStructuralFeature.Setting]*/ settings = (Collection) crossReferences
				.get(target);
		for (Iterator /*[org.eclipse.emf.ecore.EStructuralFeature.Setting]*/ it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() != intelligentMobility.IntelligentMobilityPackage.eINSTANCE
					.getLink_LaneChanging_Turn_Link_laneChanging()
					|| false == setting.getEObject() instanceof intelligentMobility.Link_LaneChanging_Turn) {
				continue;
			}
			intelligentMobility.Link_LaneChanging_Turn link = (intelligentMobility.Link_LaneChanging_Turn) setting
					.getEObject();
			if (intelligentMobility.diagram.edit.parts.Link_LaneChanging_TurnEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Turn src = link.getLink_turn();
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, target, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_LaneChanging_Turn_4016,
					intelligentMobility.diagram.edit.parts.Link_LaneChanging_TurnEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getIncomingTypeModelFacetLinks_Link_EnvironmentCondition_TrafficCondition_4017(
			intelligentMobility.Environment_Condition target,
			Map/*[org.eclipse.emf.ecore.EObject, java.util.Collection<org.eclipse.emf.ecore.EStructuralFeature.Setting>]*/ crossReferences) {
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		Collection/*[org.eclipse.emf.ecore.EStructuralFeature.Setting]*/ settings = (Collection) crossReferences
				.get(target);
		for (Iterator /*[org.eclipse.emf.ecore.EStructuralFeature.Setting]*/ it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() != intelligentMobility.IntelligentMobilityPackage.eINSTANCE
					.getLink_EnvironmentCondition_TrafficCondition_Link_environmentCondition()
					|| false == setting
							.getEObject() instanceof intelligentMobility.Link_EnvironmentCondition_TrafficCondition) {
				continue;
			}
			intelligentMobility.Link_EnvironmentCondition_TrafficCondition link = (intelligentMobility.Link_EnvironmentCondition_TrafficCondition) setting
					.getEObject();
			if (intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_TrafficConditionEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Traffic_Situation src = link.getLink_trafficCondition();
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, target, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_EnvironmentCondition_TrafficCondition_4017,
					intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_TrafficConditionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getIncomingTypeModelFacetLinks_Link_Intersection_TrafficLight_4018(
			intelligentMobility.Traffic_Light target,
			Map/*[org.eclipse.emf.ecore.EObject, java.util.Collection<org.eclipse.emf.ecore.EStructuralFeature.Setting>]*/ crossReferences) {
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		Collection/*[org.eclipse.emf.ecore.EStructuralFeature.Setting]*/ settings = (Collection) crossReferences
				.get(target);
		for (Iterator /*[org.eclipse.emf.ecore.EStructuralFeature.Setting]*/ it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() != intelligentMobility.IntelligentMobilityPackage.eINSTANCE
					.getLink_Intersection_TrafficLight_Link_trafficLight()
					|| false == setting.getEObject() instanceof intelligentMobility.Link_Intersection_TrafficLight) {
				continue;
			}
			intelligentMobility.Link_Intersection_TrafficLight link = (intelligentMobility.Link_Intersection_TrafficLight) setting
					.getEObject();
			if (intelligentMobility.diagram.edit.parts.Link_Intersection_TrafficLightEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Intersection src = link.getLink_intersection();
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, target, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Intersection_TrafficLight_4018,
					intelligentMobility.diagram.edit.parts.Link_Intersection_TrafficLightEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getIncomingTypeModelFacetLinks_Link_Following_MinGap_4019(
			intelligentMobility.LaneChanging target,
			Map/*[org.eclipse.emf.ecore.EObject, java.util.Collection<org.eclipse.emf.ecore.EStructuralFeature.Setting>]*/ crossReferences) {
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		Collection/*[org.eclipse.emf.ecore.EStructuralFeature.Setting]*/ settings = (Collection) crossReferences
				.get(target);
		for (Iterator /*[org.eclipse.emf.ecore.EStructuralFeature.Setting]*/ it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() != intelligentMobility.IntelligentMobilityPackage.eINSTANCE
					.getLink_Following_MinGap_Link_minGap()
					|| false == setting.getEObject() instanceof intelligentMobility.Link_Following_MinGap) {
				continue;
			}
			intelligentMobility.Link_Following_MinGap link = (intelligentMobility.Link_Following_MinGap) setting
					.getEObject();
			if (intelligentMobility.diagram.edit.parts.Link_Following_MinGapEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Following src = link.getLink_following();
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, target, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Following_MinGap_4019,
					intelligentMobility.diagram.edit.parts.Link_Following_MinGapEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getIncomingTypeModelFacetLinks_Link_NormalBehaviour_LaneChanging_4020(
			intelligentMobility.LaneChanging target,
			Map/*[org.eclipse.emf.ecore.EObject, java.util.Collection<org.eclipse.emf.ecore.EStructuralFeature.Setting>]*/ crossReferences) {
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		Collection/*[org.eclipse.emf.ecore.EStructuralFeature.Setting]*/ settings = (Collection) crossReferences
				.get(target);
		for (Iterator /*[org.eclipse.emf.ecore.EStructuralFeature.Setting]*/ it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() != intelligentMobility.IntelligentMobilityPackage.eINSTANCE
					.getLink_NormalBehaviour_LaneChanging_Link_lane_changing()
					|| false == setting.getEObject() instanceof intelligentMobility.Link_NormalBehaviour_LaneChanging) {
				continue;
			}
			intelligentMobility.Link_NormalBehaviour_LaneChanging link = (intelligentMobility.Link_NormalBehaviour_LaneChanging) setting
					.getEObject();
			if (intelligentMobility.diagram.edit.parts.Link_NormalBehaviour_LaneChangingEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Normal_Behaviour src = link.getLink_normal_behaviour();
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, target, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_NormalBehaviour_LaneChanging_4020,
					intelligentMobility.diagram.edit.parts.Link_NormalBehaviour_LaneChangingEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getIncomingTypeModelFacetLinks_Link_SafetyRequirement_Regulation_4021(
			intelligentMobility.Regulation target,
			Map/*[org.eclipse.emf.ecore.EObject, java.util.Collection<org.eclipse.emf.ecore.EStructuralFeature.Setting>]*/ crossReferences) {
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		Collection/*[org.eclipse.emf.ecore.EStructuralFeature.Setting]*/ settings = (Collection) crossReferences
				.get(target);
		for (Iterator /*[org.eclipse.emf.ecore.EStructuralFeature.Setting]*/ it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() != intelligentMobility.IntelligentMobilityPackage.eINSTANCE
					.getLink_SafetyRequirement_Regulation_Link_regulation()
					|| false == setting.getEObject() instanceof intelligentMobility.Link_SafetyRequirement_Regulation) {
				continue;
			}
			intelligentMobility.Link_SafetyRequirement_Regulation link = (intelligentMobility.Link_SafetyRequirement_Regulation) setting
					.getEObject();
			if (intelligentMobility.diagram.edit.parts.Link_SafetyRequirement_RegulationEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Safety_Requirement src = link.getLink_safetyRequirement();
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, target, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_SafetyRequirement_Regulation_4021,
					intelligentMobility.diagram.edit.parts.Link_SafetyRequirement_RegulationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getIncomingTypeModelFacetLinks_Link_DriverPreference_DrivingBehaviour_4022(
			intelligentMobility.Driver_Preference target,
			Map/*[org.eclipse.emf.ecore.EObject, java.util.Collection<org.eclipse.emf.ecore.EStructuralFeature.Setting>]*/ crossReferences) {
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		Collection/*[org.eclipse.emf.ecore.EStructuralFeature.Setting]*/ settings = (Collection) crossReferences
				.get(target);
		for (Iterator /*[org.eclipse.emf.ecore.EStructuralFeature.Setting]*/ it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() != intelligentMobility.IntelligentMobilityPackage.eINSTANCE
					.getLink_DriverPreference_DrivingBehaviour_Link_driver_preference()
					|| false == setting
							.getEObject() instanceof intelligentMobility.Link_DriverPreference_DrivingBehaviour) {
				continue;
			}
			intelligentMobility.Link_DriverPreference_DrivingBehaviour link = (intelligentMobility.Link_DriverPreference_DrivingBehaviour) setting
					.getEObject();
			if (intelligentMobility.diagram.edit.parts.Link_DriverPreference_DrivingBehaviourEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Driving_Behaviour src = link.getLink_driving_behaviour();
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, target, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_DriverPreference_DrivingBehaviour_4022,
					intelligentMobility.diagram.edit.parts.Link_DriverPreference_DrivingBehaviourEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getIncomingTypeModelFacetLinks_Link_FollowingVehicle_FrontVehicle_4023(
			intelligentMobility.Following_Vehicle target,
			Map/*[org.eclipse.emf.ecore.EObject, java.util.Collection<org.eclipse.emf.ecore.EStructuralFeature.Setting>]*/ crossReferences) {
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		Collection/*[org.eclipse.emf.ecore.EStructuralFeature.Setting]*/ settings = (Collection) crossReferences
				.get(target);
		for (Iterator /*[org.eclipse.emf.ecore.EStructuralFeature.Setting]*/ it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() != intelligentMobility.IntelligentMobilityPackage.eINSTANCE
					.getLink_FollowingVehicle_FrontVehicle_Link_followingVehicle()
					|| false == setting
							.getEObject() instanceof intelligentMobility.Link_FollowingVehicle_FrontVehicle) {
				continue;
			}
			intelligentMobility.Link_FollowingVehicle_FrontVehicle link = (intelligentMobility.Link_FollowingVehicle_FrontVehicle) setting
					.getEObject();
			if (intelligentMobility.diagram.edit.parts.Link_FollowingVehicle_FrontVehicleEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.PlatoonMember src = link.getLink_frontVehicle();
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, target, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_FollowingVehicle_FrontVehicle_4023,
					intelligentMobility.diagram.edit.parts.Link_FollowingVehicle_FrontVehicleEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getIncomingTypeModelFacetLinks_Link_DriverPreference_DriverEmotion_4024(
			intelligentMobility.Driver_Emotion target,
			Map/*[org.eclipse.emf.ecore.EObject, java.util.Collection<org.eclipse.emf.ecore.EStructuralFeature.Setting>]*/ crossReferences) {
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		Collection/*[org.eclipse.emf.ecore.EStructuralFeature.Setting]*/ settings = (Collection) crossReferences
				.get(target);
		for (Iterator /*[org.eclipse.emf.ecore.EStructuralFeature.Setting]*/ it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() != intelligentMobility.IntelligentMobilityPackage.eINSTANCE
					.getLink_DriverPreference_DriverEmotion_Link_driver_emotion()
					|| false == setting
							.getEObject() instanceof intelligentMobility.Link_DriverPreference_DriverEmotion) {
				continue;
			}
			intelligentMobility.Link_DriverPreference_DriverEmotion link = (intelligentMobility.Link_DriverPreference_DriverEmotion) setting
					.getEObject();
			if (intelligentMobility.diagram.edit.parts.Link_DriverPreference_DriverEmotionEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Driver_Preference src = link.getLink_driver_preference();
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, target, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_DriverPreference_DriverEmotion_4024,
					intelligentMobility.diagram.edit.parts.Link_DriverPreference_DriverEmotionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getIncomingTypeModelFacetLinks_Link_EnvironmentBackground_EnvironmentCondition_4025(
			intelligentMobility.Environment_Condition target,
			Map/*[org.eclipse.emf.ecore.EObject, java.util.Collection<org.eclipse.emf.ecore.EStructuralFeature.Setting>]*/ crossReferences) {
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		Collection/*[org.eclipse.emf.ecore.EStructuralFeature.Setting]*/ settings = (Collection) crossReferences
				.get(target);
		for (Iterator /*[org.eclipse.emf.ecore.EStructuralFeature.Setting]*/ it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() != intelligentMobility.IntelligentMobilityPackage.eINSTANCE
					.getLink_EnvironmentBackground_EnvironmentCondition_Link_environment_condition()
					|| false == setting
							.getEObject() instanceof intelligentMobility.Link_EnvironmentBackground_EnvironmentCondition) {
				continue;
			}
			intelligentMobility.Link_EnvironmentBackground_EnvironmentCondition link = (intelligentMobility.Link_EnvironmentBackground_EnvironmentCondition) setting
					.getEObject();
			if (intelligentMobility.diagram.edit.parts.Link_EnvironmentBackground_EnvironmentConditionEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Environment_Background src = link.getLink_environment_background();
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, target, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_EnvironmentBackground_EnvironmentCondition_4025,
					intelligentMobility.diagram.edit.parts.Link_EnvironmentBackground_EnvironmentConditionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getIncomingTypeModelFacetLinks_Link_EnvironmentCondition_Weather_4026(
			intelligentMobility.Weather target,
			Map/*[org.eclipse.emf.ecore.EObject, java.util.Collection<org.eclipse.emf.ecore.EStructuralFeature.Setting>]*/ crossReferences) {
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		Collection/*[org.eclipse.emf.ecore.EStructuralFeature.Setting]*/ settings = (Collection) crossReferences
				.get(target);
		for (Iterator /*[org.eclipse.emf.ecore.EStructuralFeature.Setting]*/ it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() != intelligentMobility.IntelligentMobilityPackage.eINSTANCE
					.getLink_EnvironmentCondition_Weather_Link_weather()
					|| false == setting.getEObject() instanceof intelligentMobility.Link_EnvironmentCondition_Weather) {
				continue;
			}
			intelligentMobility.Link_EnvironmentCondition_Weather link = (intelligentMobility.Link_EnvironmentCondition_Weather) setting
					.getEObject();
			if (intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_WeatherEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Environment_Condition src = link.getLink_environmentCondition();
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, target, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_EnvironmentCondition_Weather_4026,
					intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_WeatherEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getIncomingTypeModelFacetLinks_Link_EnvironmentCondition_SpecialCondition_4027(
			intelligentMobility.Special_Condition target,
			Map/*[org.eclipse.emf.ecore.EObject, java.util.Collection<org.eclipse.emf.ecore.EStructuralFeature.Setting>]*/ crossReferences) {
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		Collection/*[org.eclipse.emf.ecore.EStructuralFeature.Setting]*/ settings = (Collection) crossReferences
				.get(target);
		for (Iterator /*[org.eclipse.emf.ecore.EStructuralFeature.Setting]*/ it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() != intelligentMobility.IntelligentMobilityPackage.eINSTANCE
					.getLink_EnvironmentCondition_SpecialCondition_Link_specialCondition()
					|| false == setting
							.getEObject() instanceof intelligentMobility.Link_EnvironmentCondition_SpecialCondition) {
				continue;
			}
			intelligentMobility.Link_EnvironmentCondition_SpecialCondition link = (intelligentMobility.Link_EnvironmentCondition_SpecialCondition) setting
					.getEObject();
			if (intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_SpecialConditionEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Environment_Condition src = link.getLink_environmentCondition();
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, target, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_EnvironmentCondition_SpecialCondition_4027,
					intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_SpecialConditionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getIncomingTypeModelFacetLinks_Link_SpecialCondition_Intersection_4028(
			intelligentMobility.Special_Condition target,
			Map/*[org.eclipse.emf.ecore.EObject, java.util.Collection<org.eclipse.emf.ecore.EStructuralFeature.Setting>]*/ crossReferences) {
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		Collection/*[org.eclipse.emf.ecore.EStructuralFeature.Setting]*/ settings = (Collection) crossReferences
				.get(target);
		for (Iterator /*[org.eclipse.emf.ecore.EStructuralFeature.Setting]*/ it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() != intelligentMobility.IntelligentMobilityPackage.eINSTANCE
					.getLink_SpecialCondition_Intersection_Link_specialCondition()
					|| false == setting
							.getEObject() instanceof intelligentMobility.Link_SpecialCondition_Intersection) {
				continue;
			}
			intelligentMobility.Link_SpecialCondition_Intersection link = (intelligentMobility.Link_SpecialCondition_Intersection) setting
					.getEObject();
			if (intelligentMobility.diagram.edit.parts.Link_SpecialCondition_IntersectionEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Intersection src = link.getLink_intersection();
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, target, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_SpecialCondition_Intersection_4028,
					intelligentMobility.diagram.edit.parts.Link_SpecialCondition_IntersectionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getIncomingTypeModelFacetLinks_Link_Following_Backward_4029(
			intelligentMobility.Following target,
			Map/*[org.eclipse.emf.ecore.EObject, java.util.Collection<org.eclipse.emf.ecore.EStructuralFeature.Setting>]*/ crossReferences) {
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		Collection/*[org.eclipse.emf.ecore.EStructuralFeature.Setting]*/ settings = (Collection) crossReferences
				.get(target);
		for (Iterator /*[org.eclipse.emf.ecore.EStructuralFeature.Setting]*/ it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() != intelligentMobility.IntelligentMobilityPackage.eINSTANCE
					.getLink_Following_Backward_Link_following()
					|| false == setting.getEObject() instanceof intelligentMobility.Link_Following_Backward) {
				continue;
			}
			intelligentMobility.Link_Following_Backward link = (intelligentMobility.Link_Following_Backward) setting
					.getEObject();
			if (intelligentMobility.diagram.edit.parts.Link_Following_BackwardEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Backward src = link.getLink_backward();
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, target, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Following_Backward_4029,
					intelligentMobility.diagram.edit.parts.Link_Following_BackwardEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getIncomingTypeModelFacetLinks_Link_EnvironmentCondition_Regulations_4030(
			intelligentMobility.Regulation target,
			Map/*[org.eclipse.emf.ecore.EObject, java.util.Collection<org.eclipse.emf.ecore.EStructuralFeature.Setting>]*/ crossReferences) {
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		Collection/*[org.eclipse.emf.ecore.EStructuralFeature.Setting]*/ settings = (Collection) crossReferences
				.get(target);
		for (Iterator /*[org.eclipse.emf.ecore.EStructuralFeature.Setting]*/ it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() != intelligentMobility.IntelligentMobilityPackage.eINSTANCE
					.getLink_EnvironmentCondition_Regulations_Link_regulation()
					|| false == setting
							.getEObject() instanceof intelligentMobility.Link_EnvironmentCondition_Regulations) {
				continue;
			}
			intelligentMobility.Link_EnvironmentCondition_Regulations link = (intelligentMobility.Link_EnvironmentCondition_Regulations) setting
					.getEObject();
			if (intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_RegulationsEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Environment_Condition src = link.getLink_environmentCondition();
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, target, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_EnvironmentCondition_Regulations_4030,
					intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_RegulationsEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getIncomingTypeModelFacetLinks_Link_DrivingBehaviour_NormalBehaviour_4031(
			intelligentMobility.Normal_Behaviour target,
			Map/*[org.eclipse.emf.ecore.EObject, java.util.Collection<org.eclipse.emf.ecore.EStructuralFeature.Setting>]*/ crossReferences) {
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		Collection/*[org.eclipse.emf.ecore.EStructuralFeature.Setting]*/ settings = (Collection) crossReferences
				.get(target);
		for (Iterator /*[org.eclipse.emf.ecore.EStructuralFeature.Setting]*/ it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() != intelligentMobility.IntelligentMobilityPackage.eINSTANCE
					.getLink_DrivingBehaviour_NormalBehaviour_Link_normal_behaviour()
					|| false == setting
							.getEObject() instanceof intelligentMobility.Link_DrivingBehaviour_NormalBehaviour) {
				continue;
			}
			intelligentMobility.Link_DrivingBehaviour_NormalBehaviour link = (intelligentMobility.Link_DrivingBehaviour_NormalBehaviour) setting
					.getEObject();
			if (intelligentMobility.diagram.edit.parts.Link_DrivingBehaviour_NormalBehaviourEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Driving_Behaviour src = link.getLink_driving_behaviour();
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, target, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_DrivingBehaviour_NormalBehaviour_4031,
					intelligentMobility.diagram.edit.parts.Link_DrivingBehaviour_NormalBehaviourEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getIncomingTypeModelFacetLinks_Link_LaneChanging_EnvironmentCondition_4032(
			intelligentMobility.Environment_Condition target,
			Map/*[org.eclipse.emf.ecore.EObject, java.util.Collection<org.eclipse.emf.ecore.EStructuralFeature.Setting>]*/ crossReferences) {
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		Collection/*[org.eclipse.emf.ecore.EStructuralFeature.Setting]*/ settings = (Collection) crossReferences
				.get(target);
		for (Iterator /*[org.eclipse.emf.ecore.EStructuralFeature.Setting]*/ it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() != intelligentMobility.IntelligentMobilityPackage.eINSTANCE
					.getLink_LaneChanging_EnvironmentCondition_Link_environmentCondition()
					|| false == setting
							.getEObject() instanceof intelligentMobility.Link_LaneChanging_EnvironmentCondition) {
				continue;
			}
			intelligentMobility.Link_LaneChanging_EnvironmentCondition link = (intelligentMobility.Link_LaneChanging_EnvironmentCondition) setting
					.getEObject();
			if (intelligentMobility.diagram.edit.parts.Link_LaneChanging_EnvironmentConditionEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.LaneChanging src = link.getLink_laneChanging();
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, target, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_LaneChanging_EnvironmentCondition_4032,
					intelligentMobility.diagram.edit.parts.Link_LaneChanging_EnvironmentConditionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getIncomingTypeModelFacetLinks_Link_LaneChanging_GapAcceptance_4033(
			intelligentMobility.GapAcceptance target,
			Map/*[org.eclipse.emf.ecore.EObject, java.util.Collection<org.eclipse.emf.ecore.EStructuralFeature.Setting>]*/ crossReferences) {
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		Collection/*[org.eclipse.emf.ecore.EStructuralFeature.Setting]*/ settings = (Collection) crossReferences
				.get(target);
		for (Iterator /*[org.eclipse.emf.ecore.EStructuralFeature.Setting]*/ it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() != intelligentMobility.IntelligentMobilityPackage.eINSTANCE
					.getLink_LaneChanging_GapAcceptance_Link_gapAcceptance()
					|| false == setting.getEObject() instanceof intelligentMobility.Link_LaneChanging_GapAcceptance) {
				continue;
			}
			intelligentMobility.Link_LaneChanging_GapAcceptance link = (intelligentMobility.Link_LaneChanging_GapAcceptance) setting
					.getEObject();
			if (intelligentMobility.diagram.edit.parts.Link_LaneChanging_GapAcceptanceEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.LaneChanging src = link.getLink_laneChanging();
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, target, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_LaneChanging_GapAcceptance_4033,
					intelligentMobility.diagram.edit.parts.Link_LaneChanging_GapAcceptanceEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getIncomingTypeModelFacetLinks_Link_NormalBehaviour_Following_4034(
			intelligentMobility.Following target,
			Map/*[org.eclipse.emf.ecore.EObject, java.util.Collection<org.eclipse.emf.ecore.EStructuralFeature.Setting>]*/ crossReferences) {
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		Collection/*[org.eclipse.emf.ecore.EStructuralFeature.Setting]*/ settings = (Collection) crossReferences
				.get(target);
		for (Iterator /*[org.eclipse.emf.ecore.EStructuralFeature.Setting]*/ it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() != intelligentMobility.IntelligentMobilityPackage.eINSTANCE
					.getLink_NormalBehaviour_Following_Link_following()
					|| false == setting.getEObject() instanceof intelligentMobility.Link_NormalBehaviour_Following) {
				continue;
			}
			intelligentMobility.Link_NormalBehaviour_Following link = (intelligentMobility.Link_NormalBehaviour_Following) setting
					.getEObject();
			if (intelligentMobility.diagram.edit.parts.Link_NormalBehaviour_FollowingEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Normal_Behaviour src = link.getLink_normal_behaviour();
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, target, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_NormalBehaviour_Following_4034,
					intelligentMobility.diagram.edit.parts.Link_NormalBehaviour_FollowingEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getIncomingTypeModelFacetLinks_Link_Infrastructure_VehicleConfiguration_4035(
			intelligentMobility.Infrastructure target,
			Map/*[org.eclipse.emf.ecore.EObject, java.util.Collection<org.eclipse.emf.ecore.EStructuralFeature.Setting>]*/ crossReferences) {
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		Collection/*[org.eclipse.emf.ecore.EStructuralFeature.Setting]*/ settings = (Collection) crossReferences
				.get(target);
		for (Iterator /*[org.eclipse.emf.ecore.EStructuralFeature.Setting]*/ it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() != intelligentMobility.IntelligentMobilityPackage.eINSTANCE
					.getLink_Infrastructure_VehicleConfiguration_Link_infrastructure()
					|| false == setting
							.getEObject() instanceof intelligentMobility.Link_Infrastructure_VehicleConfiguration) {
				continue;
			}
			intelligentMobility.Link_Infrastructure_VehicleConfiguration link = (intelligentMobility.Link_Infrastructure_VehicleConfiguration) setting
					.getEObject();
			if (intelligentMobility.diagram.edit.parts.Link_Infrastructure_VehicleConfigurationEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Vehicle_Configuration src = link.getLink_vehicle_configuration();
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, target, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Infrastructure_VehicleConfiguration_4035,
					intelligentMobility.diagram.edit.parts.Link_Infrastructure_VehicleConfigurationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getIncomingTypeModelFacetLinks_Link_CommunicationInterface_VehicleConfiguration_4036(
			intelligentMobility.Vehicle_Configuration target,
			Map/*[org.eclipse.emf.ecore.EObject, java.util.Collection<org.eclipse.emf.ecore.EStructuralFeature.Setting>]*/ crossReferences) {
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		Collection/*[org.eclipse.emf.ecore.EStructuralFeature.Setting]*/ settings = (Collection) crossReferences
				.get(target);
		for (Iterator /*[org.eclipse.emf.ecore.EStructuralFeature.Setting]*/ it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() != intelligentMobility.IntelligentMobilityPackage.eINSTANCE
					.getLink_CommunicationInterface_VehicleConfiguration_Link_vehicle_configuration()
					|| false == setting
							.getEObject() instanceof intelligentMobility.Link_CommunicationInterface_VehicleConfiguration) {
				continue;
			}
			intelligentMobility.Link_CommunicationInterface_VehicleConfiguration link = (intelligentMobility.Link_CommunicationInterface_VehicleConfiguration) setting
					.getEObject();
			if (intelligentMobility.diagram.edit.parts.Link_CommunicationInterface_VehicleConfigurationEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.CommunicationInterface src = link.getLink_communication_interface();
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, target, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_CommunicationInterface_VehicleConfiguration_4036,
					intelligentMobility.diagram.edit.parts.Link_CommunicationInterface_VehicleConfigurationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getIncomingTypeModelFacetLinks_Link_Goal_DrivingBehaviour_4037(
			intelligentMobility.Goal target,
			Map/*[org.eclipse.emf.ecore.EObject, java.util.Collection<org.eclipse.emf.ecore.EStructuralFeature.Setting>]*/ crossReferences) {
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		Collection/*[org.eclipse.emf.ecore.EStructuralFeature.Setting]*/ settings = (Collection) crossReferences
				.get(target);
		for (Iterator /*[org.eclipse.emf.ecore.EStructuralFeature.Setting]*/ it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() != intelligentMobility.IntelligentMobilityPackage.eINSTANCE
					.getLink_Goal_DrivingBehaviour_Link_goal()
					|| false == setting.getEObject() instanceof intelligentMobility.Link_Goal_DrivingBehaviour) {
				continue;
			}
			intelligentMobility.Link_Goal_DrivingBehaviour link = (intelligentMobility.Link_Goal_DrivingBehaviour) setting
					.getEObject();
			if (intelligentMobility.diagram.edit.parts.Link_Goal_DrivingBehaviourEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Driving_Behaviour src = link.getLink_drivingBehaviour();
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, target, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Goal_DrivingBehaviour_4037,
					intelligentMobility.diagram.edit.parts.Link_Goal_DrivingBehaviourEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getIncomingTypeModelFacetLinks_Link_CooperativeBehaviour_CommunicationInterface_4038(
			intelligentMobility.CommunicationInterface target,
			Map/*[org.eclipse.emf.ecore.EObject, java.util.Collection<org.eclipse.emf.ecore.EStructuralFeature.Setting>]*/ crossReferences) {
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		Collection/*[org.eclipse.emf.ecore.EStructuralFeature.Setting]*/ settings = (Collection) crossReferences
				.get(target);
		for (Iterator /*[org.eclipse.emf.ecore.EStructuralFeature.Setting]*/ it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() != intelligentMobility.IntelligentMobilityPackage.eINSTANCE
					.getLink_CooperativeBehaviour_CommunicationInterface_Link_communicationInterface()
					|| false == setting
							.getEObject() instanceof intelligentMobility.Link_CooperativeBehaviour_CommunicationInterface) {
				continue;
			}
			intelligentMobility.Link_CooperativeBehaviour_CommunicationInterface link = (intelligentMobility.Link_CooperativeBehaviour_CommunicationInterface) setting
					.getEObject();
			if (intelligentMobility.diagram.edit.parts.Link_CooperativeBehaviour_CommunicationInterfaceEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.CooperativeBehavior src = link.getLink_cooperativeBehaviour();
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, target, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_CooperativeBehaviour_CommunicationInterface_4038,
					intelligentMobility.diagram.edit.parts.Link_CooperativeBehaviour_CommunicationInterfaceEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getIncomingTypeModelFacetLinks_Link_CommunicationInterface_Infrastructure_4039(
			intelligentMobility.Infrastructure target,
			Map/*[org.eclipse.emf.ecore.EObject, java.util.Collection<org.eclipse.emf.ecore.EStructuralFeature.Setting>]*/ crossReferences) {
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		Collection/*[org.eclipse.emf.ecore.EStructuralFeature.Setting]*/ settings = (Collection) crossReferences
				.get(target);
		for (Iterator /*[org.eclipse.emf.ecore.EStructuralFeature.Setting]*/ it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() != intelligentMobility.IntelligentMobilityPackage.eINSTANCE
					.getLink_CommunicationInterface_Infrastructure_Link_infrastructure()
					|| false == setting
							.getEObject() instanceof intelligentMobility.Link_CommunicationInterface_Infrastructure) {
				continue;
			}
			intelligentMobility.Link_CommunicationInterface_Infrastructure link = (intelligentMobility.Link_CommunicationInterface_Infrastructure) setting
					.getEObject();
			if (intelligentMobility.diagram.edit.parts.Link_CommunicationInterface_InfrastructureEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.CommunicationInterface src = link.getLink_communicationInterface();
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, target, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_CommunicationInterface_Infrastructure_4039,
					intelligentMobility.diagram.edit.parts.Link_CommunicationInterface_InfrastructureEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getIncomingTypeModelFacetLinks_Link_CooperativeBehaviour_VehicleConfiguration_4040(
			intelligentMobility.Vehicle_Configuration target,
			Map/*[org.eclipse.emf.ecore.EObject, java.util.Collection<org.eclipse.emf.ecore.EStructuralFeature.Setting>]*/ crossReferences) {
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		Collection/*[org.eclipse.emf.ecore.EStructuralFeature.Setting]*/ settings = (Collection) crossReferences
				.get(target);
		for (Iterator /*[org.eclipse.emf.ecore.EStructuralFeature.Setting]*/ it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() != intelligentMobility.IntelligentMobilityPackage.eINSTANCE
					.getLink_CooperativeBehaviour_VehicleConfiguration_Link_vehicleConfiguration()
					|| false == setting
							.getEObject() instanceof intelligentMobility.Link_CooperativeBehaviour_VehicleConfiguration) {
				continue;
			}
			intelligentMobility.Link_CooperativeBehaviour_VehicleConfiguration link = (intelligentMobility.Link_CooperativeBehaviour_VehicleConfiguration) setting
					.getEObject();
			if (intelligentMobility.diagram.edit.parts.Link_CooperativeBehaviour_VehicleConfigurationEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.CooperativeBehavior src = link.getLink_cooperativeBehaviour();
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, target, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_CooperativeBehaviour_VehicleConfiguration_4040,
					intelligentMobility.diagram.edit.parts.Link_CooperativeBehaviour_VehicleConfigurationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getIncomingTypeModelFacetLinks_Link_TrafficSituation_EnvironmentCondition_4041(
			intelligentMobility.Traffic_Situation target,
			Map/*[org.eclipse.emf.ecore.EObject, java.util.Collection<org.eclipse.emf.ecore.EStructuralFeature.Setting>]*/ crossReferences) {
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		Collection/*[org.eclipse.emf.ecore.EStructuralFeature.Setting]*/ settings = (Collection) crossReferences
				.get(target);
		for (Iterator /*[org.eclipse.emf.ecore.EStructuralFeature.Setting]*/ it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() != intelligentMobility.IntelligentMobilityPackage.eINSTANCE
					.getLink_TrafficSituation_EnvironmentCondition_Link_trafficSituation()
					|| false == setting
							.getEObject() instanceof intelligentMobility.Link_TrafficSituation_EnvironmentCondition) {
				continue;
			}
			intelligentMobility.Link_TrafficSituation_EnvironmentCondition link = (intelligentMobility.Link_TrafficSituation_EnvironmentCondition) setting
					.getEObject();
			if (intelligentMobility.diagram.edit.parts.Link_TrafficSituation_EnvironmentConditionEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Environment_Condition src = link.getLink_environmentCondition();
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, target, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_TrafficSituation_EnvironmentCondition_4041,
					intelligentMobility.diagram.edit.parts.Link_TrafficSituation_EnvironmentConditionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getIncomingTypeModelFacetLinks_Link_Collision_SpecialCondition_4042(
			intelligentMobility.Special_Condition target,
			Map/*[org.eclipse.emf.ecore.EObject, java.util.Collection<org.eclipse.emf.ecore.EStructuralFeature.Setting>]*/ crossReferences) {
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		Collection/*[org.eclipse.emf.ecore.EStructuralFeature.Setting]*/ settings = (Collection) crossReferences
				.get(target);
		for (Iterator /*[org.eclipse.emf.ecore.EStructuralFeature.Setting]*/ it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() != intelligentMobility.IntelligentMobilityPackage.eINSTANCE
					.getLink_Collision_SpecialCondition_Link_specialCondition()
					|| false == setting.getEObject() instanceof intelligentMobility.Link_Collision_SpecialCondition) {
				continue;
			}
			intelligentMobility.Link_Collision_SpecialCondition link = (intelligentMobility.Link_Collision_SpecialCondition) setting
					.getEObject();
			if (intelligentMobility.diagram.edit.parts.Link_Collision_SpecialConditionEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Collision src = link.getLink_collision();
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, target, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Collision_SpecialCondition_4042,
					intelligentMobility.diagram.edit.parts.Link_Collision_SpecialConditionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getIncomingTypeModelFacetLinks_Link_Following_LaneChanging_4043(
			intelligentMobility.LaneChanging target,
			Map/*[org.eclipse.emf.ecore.EObject, java.util.Collection<org.eclipse.emf.ecore.EStructuralFeature.Setting>]*/ crossReferences) {
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		Collection/*[org.eclipse.emf.ecore.EStructuralFeature.Setting]*/ settings = (Collection) crossReferences
				.get(target);
		for (Iterator /*[org.eclipse.emf.ecore.EStructuralFeature.Setting]*/ it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() != intelligentMobility.IntelligentMobilityPackage.eINSTANCE
					.getLink_Following_LaneChanging_Link_laneChanging()
					|| false == setting.getEObject() instanceof intelligentMobility.Link_Following_LaneChanging) {
				continue;
			}
			intelligentMobility.Link_Following_LaneChanging link = (intelligentMobility.Link_Following_LaneChanging) setting
					.getEObject();
			if (intelligentMobility.diagram.edit.parts.Link_Following_LaneChangingEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Following src = link.getLink_following();
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, target, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Following_LaneChanging_4043,
					intelligentMobility.diagram.edit.parts.Link_Following_LaneChangingEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getIncomingTypeModelFacetLinks_Link_Action_Backward_4044(
			intelligentMobility.Backward target,
			Map/*[org.eclipse.emf.ecore.EObject, java.util.Collection<org.eclipse.emf.ecore.EStructuralFeature.Setting>]*/ crossReferences) {
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		Collection/*[org.eclipse.emf.ecore.EStructuralFeature.Setting]*/ settings = (Collection) crossReferences
				.get(target);
		for (Iterator /*[org.eclipse.emf.ecore.EStructuralFeature.Setting]*/ it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() != intelligentMobility.IntelligentMobilityPackage.eINSTANCE
					.getLink_Action_Backward_Link_backward()
					|| false == setting.getEObject() instanceof intelligentMobility.Link_Action_Backward) {
				continue;
			}
			intelligentMobility.Link_Action_Backward link = (intelligentMobility.Link_Action_Backward) setting
					.getEObject();
			if (intelligentMobility.diagram.edit.parts.Link_Action_BackwardEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Action src = link.getLink_action();
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, target, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Action_Backward_4044,
					intelligentMobility.diagram.edit.parts.Link_Action_BackwardEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getIncomingTypeModelFacetLinks_Link_Action_Forward_4045(
			intelligentMobility.Forward target,
			Map/*[org.eclipse.emf.ecore.EObject, java.util.Collection<org.eclipse.emf.ecore.EStructuralFeature.Setting>]*/ crossReferences) {
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		Collection/*[org.eclipse.emf.ecore.EStructuralFeature.Setting]*/ settings = (Collection) crossReferences
				.get(target);
		for (Iterator /*[org.eclipse.emf.ecore.EStructuralFeature.Setting]*/ it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() != intelligentMobility.IntelligentMobilityPackage.eINSTANCE
					.getLink_Action_Forward_Link_forward()
					|| false == setting.getEObject() instanceof intelligentMobility.Link_Action_Forward) {
				continue;
			}
			intelligentMobility.Link_Action_Forward link = (intelligentMobility.Link_Action_Forward) setting
					.getEObject();
			if (intelligentMobility.diagram.edit.parts.Link_Action_ForwardEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Action src = link.getLink_action();
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, target, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Action_Forward_4045,
					intelligentMobility.diagram.edit.parts.Link_Action_ForwardEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getIncomingTypeModelFacetLinks_Link_Action_Turn_4046(
			intelligentMobility.Turn target,
			Map/*[org.eclipse.emf.ecore.EObject, java.util.Collection<org.eclipse.emf.ecore.EStructuralFeature.Setting>]*/ crossReferences) {
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		Collection/*[org.eclipse.emf.ecore.EStructuralFeature.Setting]*/ settings = (Collection) crossReferences
				.get(target);
		for (Iterator /*[org.eclipse.emf.ecore.EStructuralFeature.Setting]*/ it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() != intelligentMobility.IntelligentMobilityPackage.eINSTANCE
					.getLink_Action_Turn_Link_turn()
					|| false == setting.getEObject() instanceof intelligentMobility.Link_Action_Turn) {
				continue;
			}
			intelligentMobility.Link_Action_Turn link = (intelligentMobility.Link_Action_Turn) setting.getEObject();
			if (intelligentMobility.diagram.edit.parts.Link_Action_TurnEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Action src = link.getLink_action();
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, target, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Action_Turn_4046,
					intelligentMobility.diagram.edit.parts.Link_Action_TurnEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getIncomingTypeModelFacetLinks_Link_KnowledgeAndSkill_DriverPreference_4047(
			intelligentMobility.Knowledge_and_Skill target,
			Map/*[org.eclipse.emf.ecore.EObject, java.util.Collection<org.eclipse.emf.ecore.EStructuralFeature.Setting>]*/ crossReferences) {
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		Collection/*[org.eclipse.emf.ecore.EStructuralFeature.Setting]*/ settings = (Collection) crossReferences
				.get(target);
		for (Iterator /*[org.eclipse.emf.ecore.EStructuralFeature.Setting]*/ it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() != intelligentMobility.IntelligentMobilityPackage.eINSTANCE
					.getLink_KnowledgeAndSkill_DriverPreference_Link_knowledgeAndSkill()
					|| false == setting
							.getEObject() instanceof intelligentMobility.Link_KnowledgeAndSkill_DriverPreference) {
				continue;
			}
			intelligentMobility.Link_KnowledgeAndSkill_DriverPreference link = (intelligentMobility.Link_KnowledgeAndSkill_DriverPreference) setting
					.getEObject();
			if (intelligentMobility.diagram.edit.parts.Link_KnowledgeAndSkill_DriverPreferenceEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Driver_Preference src = link.getLink_driverPreference();
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, target, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_KnowledgeAndSkill_DriverPreference_4047,
					intelligentMobility.diagram.edit.parts.Link_KnowledgeAndSkill_DriverPreferenceEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getOutgoingTypeModelFacetLinks_Link_LaneType_Regulation_4001(
			intelligentMobility.Lane_Type source) {
		intelligentMobility.MobilitySystem container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof intelligentMobility.MobilitySystem) {
				container = (intelligentMobility.MobilitySystem) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		for (Iterator /*[?]*/ links = container.getLink_laneType_regulation().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof intelligentMobility.Link_LaneType_Regulation) {
				continue;
			}
			intelligentMobility.Link_LaneType_Regulation link = (intelligentMobility.Link_LaneType_Regulation) linkObject;
			if (intelligentMobility.diagram.edit.parts.Link_LaneType_RegulationEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Regulation dst = link.getLink_regulation();
			intelligentMobility.Lane_Type src = link.getLink_laneType();
			if (src != source) {
				continue;
			}
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, dst, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_LaneType_Regulation_4001,
					intelligentMobility.diagram.edit.parts.Link_LaneType_RegulationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getOutgoingTypeModelFacetLinks_Link_Driver_Vehicle_4002(
			intelligentMobility.Driver_Profile source) {
		intelligentMobility.MobilitySystem container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof intelligentMobility.MobilitySystem) {
				container = (intelligentMobility.MobilitySystem) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		for (Iterator /*[?]*/ links = container.getLink_driver_vehicle().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof intelligentMobility.Link_Driver_Vehicle) {
				continue;
			}
			intelligentMobility.Link_Driver_Vehicle link = (intelligentMobility.Link_Driver_Vehicle) linkObject;
			if (intelligentMobility.diagram.edit.parts.Link_Driver_VehicleEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Vehicle_Configuration dst = link.getLink_vehicle_configuration();
			intelligentMobility.Driver_Profile src = link.getLink_driver_profile();
			if (src != source) {
				continue;
			}
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, dst, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Driver_Vehicle_4002,
					intelligentMobility.diagram.edit.parts.Link_Driver_VehicleEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getOutgoingTypeModelFacetLinks_Link_EnvironmentBackground_PossibleVehicle_4003(
			intelligentMobility.PossibleVehicle source) {
		intelligentMobility.MobilitySystem container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof intelligentMobility.MobilitySystem) {
				container = (intelligentMobility.MobilitySystem) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		for (Iterator /*[?]*/ links = container.getLink_environmentBackground_possibleVehicle().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof intelligentMobility.Link_EnvironmentBackground_PossibleVehicle) {
				continue;
			}
			intelligentMobility.Link_EnvironmentBackground_PossibleVehicle link = (intelligentMobility.Link_EnvironmentBackground_PossibleVehicle) linkObject;
			if (intelligentMobility.diagram.edit.parts.Link_EnvironmentBackground_PossibleVehicleEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Environment_Background dst = link.getLink_environment_background();
			intelligentMobility.PossibleVehicle src = link.getLink_possible_vehicle();
			if (src != source) {
				continue;
			}
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, dst, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_EnvironmentBackground_PossibleVehicle_4003,
					intelligentMobility.diagram.edit.parts.Link_EnvironmentBackground_PossibleVehicleEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getOutgoingTypeModelFacetLinks_Link_Vehicle_Environment_4004(
			intelligentMobility.Vehicle_Configuration source) {
		intelligentMobility.MobilitySystem container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof intelligentMobility.MobilitySystem) {
				container = (intelligentMobility.MobilitySystem) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		for (Iterator /*[?]*/ links = container.getLink_vehicle_environment().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof intelligentMobility.Link_Vehicle_Environment) {
				continue;
			}
			intelligentMobility.Link_Vehicle_Environment link = (intelligentMobility.Link_Vehicle_Environment) linkObject;
			if (intelligentMobility.diagram.edit.parts.Link_Vehicle_EnvironmentEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Environment_Background dst = link.getLink_environment_background();
			intelligentMobility.Vehicle_Configuration src = link.getLink_vehicle_configuration();
			if (src != source) {
				continue;
			}
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, dst, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Vehicle_Environment_4004,
					intelligentMobility.diagram.edit.parts.Link_Vehicle_EnvironmentEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getOutgoingTypeModelFacetLinks_Link_NormalVehicle_SafetyRequirements_4005(
			intelligentMobility.Normal_Vehicle source) {
		intelligentMobility.MobilitySystem container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof intelligentMobility.MobilitySystem) {
				container = (intelligentMobility.MobilitySystem) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		for (Iterator /*[?]*/ links = container.getLink_normalVehicle_safetyRequirement().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof intelligentMobility.Link_NormalVehicle_SafetyRequirements) {
				continue;
			}
			intelligentMobility.Link_NormalVehicle_SafetyRequirements link = (intelligentMobility.Link_NormalVehicle_SafetyRequirements) linkObject;
			if (intelligentMobility.diagram.edit.parts.Link_NormalVehicle_SafetyRequirementsEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Safety_Requirement dst = link.getLink_safetyRequirement();
			intelligentMobility.Normal_Vehicle src = link.getLink_normalVehicle();
			if (src != source) {
				continue;
			}
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, dst, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_NormalVehicle_SafetyRequirements_4005,
					intelligentMobility.diagram.edit.parts.Link_NormalVehicle_SafetyRequirementsEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getOutgoingTypeModelFacetLinks_Link_DriverProfile_DriverPreference_4006(
			intelligentMobility.Driver_Profile source) {
		intelligentMobility.MobilitySystem container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof intelligentMobility.MobilitySystem) {
				container = (intelligentMobility.MobilitySystem) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		for (Iterator /*[?]*/ links = container.getLink_driverProfile_driverPreference().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof intelligentMobility.Link_DriverProfile_DriverPreference) {
				continue;
			}
			intelligentMobility.Link_DriverProfile_DriverPreference link = (intelligentMobility.Link_DriverProfile_DriverPreference) linkObject;
			if (intelligentMobility.diagram.edit.parts.Link_DriverProfile_DriverPreferenceEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Driver_Preference dst = link.getLink_driver_preference();
			intelligentMobility.Driver_Profile src = link.getLink_driver_profile();
			if (src != source) {
				continue;
			}
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, dst, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_DriverProfile_DriverPreference_4006,
					intelligentMobility.diagram.edit.parts.Link_DriverProfile_DriverPreferenceEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getOutgoingTypeModelFacetLinks_Link_Collision_Obstruction_4007(
			intelligentMobility.Obstruction source) {
		intelligentMobility.MobilitySystem container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof intelligentMobility.MobilitySystem) {
				container = (intelligentMobility.MobilitySystem) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		for (Iterator /*[?]*/ links = container.getLink_collision_obstruction().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof intelligentMobility.Link_Collision_Obstruction) {
				continue;
			}
			intelligentMobility.Link_Collision_Obstruction link = (intelligentMobility.Link_Collision_Obstruction) linkObject;
			if (intelligentMobility.diagram.edit.parts.Link_Collision_ObstructionEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Collision dst = link.getLink_collision();
			intelligentMobility.Obstruction src = link.getLink_obstruction();
			if (src != source) {
				continue;
			}
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, dst, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Collision_Obstruction_4007,
					intelligentMobility.diagram.edit.parts.Link_Collision_ObstructionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getOutgoingTypeModelFacetLinks_Link_Platoon_FollowingVehicle_4008(
			intelligentMobility.Platoon source) {
		intelligentMobility.MobilitySystem container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof intelligentMobility.MobilitySystem) {
				container = (intelligentMobility.MobilitySystem) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		for (Iterator /*[?]*/ links = container.getLink_platoon_followingVehicle().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof intelligentMobility.Link_Platoon_FollowingVehicle) {
				continue;
			}
			intelligentMobility.Link_Platoon_FollowingVehicle link = (intelligentMobility.Link_Platoon_FollowingVehicle) linkObject;
			if (intelligentMobility.diagram.edit.parts.Link_Platoon_FollowingVehicleEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Following_Vehicle dst = link.getLink_followingVehicle();
			intelligentMobility.Platoon src = link.getLink_platoon();
			if (src != source) {
				continue;
			}
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, dst, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Platoon_FollowingVehicle_4008,
					intelligentMobility.diagram.edit.parts.Link_Platoon_FollowingVehicleEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getOutgoingTypeModelFacetLinks_Link_DriverPreference_EnvironmentCondition_4009(
			intelligentMobility.Driver_Preference source) {
		intelligentMobility.MobilitySystem container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof intelligentMobility.MobilitySystem) {
				container = (intelligentMobility.MobilitySystem) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		for (Iterator /*[?]*/ links = container.getLink_driverPreference_environmentCondition().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof intelligentMobility.Link_DriverPreference_EnvironmentCondition) {
				continue;
			}
			intelligentMobility.Link_DriverPreference_EnvironmentCondition link = (intelligentMobility.Link_DriverPreference_EnvironmentCondition) linkObject;
			if (intelligentMobility.diagram.edit.parts.Link_DriverPreference_EnvironmentConditionEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Environment_Condition dst = link.getLink_environment_condition();
			intelligentMobility.Driver_Preference src = link.getLink_driver_preference();
			if (src != source) {
				continue;
			}
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, dst, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_DriverPreference_EnvironmentCondition_4009,
					intelligentMobility.diagram.edit.parts.Link_DriverPreference_EnvironmentConditionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getOutgoingTypeModelFacetLinks_Link_AbnormalBehaviour_Action_4010(
			intelligentMobility.Action source) {
		intelligentMobility.MobilitySystem container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof intelligentMobility.MobilitySystem) {
				container = (intelligentMobility.MobilitySystem) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		for (Iterator /*[?]*/ links = container.getLink_abnormalBehaviour_action().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof intelligentMobility.Link_AbnormalBehaviour_Action) {
				continue;
			}
			intelligentMobility.Link_AbnormalBehaviour_Action link = (intelligentMobility.Link_AbnormalBehaviour_Action) linkObject;
			if (intelligentMobility.diagram.edit.parts.Link_AbnormalBehaviour_ActionEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Abnormal_Behaviour dst = link.getLink_abnormalBehaviour();
			intelligentMobility.Action src = link.getLink_action();
			if (src != source) {
				continue;
			}
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, dst, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_AbnormalBehaviour_Action_4010,
					intelligentMobility.diagram.edit.parts.Link_AbnormalBehaviour_ActionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getOutgoingTypeModelFacetLinks_Link_Following_Forward_4011(
			intelligentMobility.Following source) {
		intelligentMobility.MobilitySystem container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof intelligentMobility.MobilitySystem) {
				container = (intelligentMobility.MobilitySystem) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		for (Iterator /*[?]*/ links = container.getLink_following_forward().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof intelligentMobility.Link_Following_Forward) {
				continue;
			}
			intelligentMobility.Link_Following_Forward link = (intelligentMobility.Link_Following_Forward) linkObject;
			if (intelligentMobility.diagram.edit.parts.Link_Following_ForwardEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Forward dst = link.getLink_forward();
			intelligentMobility.Following src = link.getLink_following();
			if (src != source) {
				continue;
			}
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, dst, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Following_Forward_4011,
					intelligentMobility.diagram.edit.parts.Link_Following_ForwardEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getOutgoingTypeModelFacetLinks_Link_EnvironmentCondition_LaneType_4012(
			intelligentMobility.Lane_Type source) {
		intelligentMobility.MobilitySystem container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof intelligentMobility.MobilitySystem) {
				container = (intelligentMobility.MobilitySystem) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		for (Iterator /*[?]*/ links = container.getLink_environmentCondition_laneType().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof intelligentMobility.Link_EnvironmentCondition_LaneType) {
				continue;
			}
			intelligentMobility.Link_EnvironmentCondition_LaneType link = (intelligentMobility.Link_EnvironmentCondition_LaneType) linkObject;
			if (intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_LaneTypeEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Environment_Condition dst = link.getLink_environmentCondition();
			intelligentMobility.Lane_Type src = link.getLink_laneType();
			if (src != source) {
				continue;
			}
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, dst, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_EnvironmentCondition_LaneType_4012,
					intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_LaneTypeEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getOutgoingTypeModelFacetLinks_Link_VehicleConfiguration_VehicleType_4013(
			intelligentMobility.Vehicle_Type source) {
		intelligentMobility.MobilitySystem container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof intelligentMobility.MobilitySystem) {
				container = (intelligentMobility.MobilitySystem) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		for (Iterator /*[?]*/ links = container.getLink_vehicleConfiguration_vehicleType().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof intelligentMobility.Link_VehicleConfiguration_VehicleType) {
				continue;
			}
			intelligentMobility.Link_VehicleConfiguration_VehicleType link = (intelligentMobility.Link_VehicleConfiguration_VehicleType) linkObject;
			if (intelligentMobility.diagram.edit.parts.Link_VehicleConfiguration_VehicleTypeEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Vehicle_Configuration dst = link.getLink_vehicle_configuration();
			intelligentMobility.Vehicle_Type src = link.getLink_vehicle_type();
			if (src != source) {
				continue;
			}
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, dst, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_VehicleConfiguration_VehicleType_4013,
					intelligentMobility.diagram.edit.parts.Link_VehicleConfiguration_VehicleTypeEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getOutgoingTypeModelFacetLinks_Link_Platoon_LeadingVehicle_4014(
			intelligentMobility.Platoon source) {
		intelligentMobility.MobilitySystem container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof intelligentMobility.MobilitySystem) {
				container = (intelligentMobility.MobilitySystem) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		for (Iterator /*[?]*/ links = container.getLink_platoon_leadingVehicle().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof intelligentMobility.Link_Platoon_LeadingVehicle) {
				continue;
			}
			intelligentMobility.Link_Platoon_LeadingVehicle link = (intelligentMobility.Link_Platoon_LeadingVehicle) linkObject;
			if (intelligentMobility.diagram.edit.parts.Link_Platoon_LeadingVehicleEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Leading_Vehicle dst = link.getLink_leadingVehicle();
			intelligentMobility.Platoon src = link.getLink_platoon();
			if (src != source) {
				continue;
			}
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, dst, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Platoon_LeadingVehicle_4014,
					intelligentMobility.diagram.edit.parts.Link_Platoon_LeadingVehicleEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getOutgoingTypeModelFacetLinks_Link_Driver_Environment_4015(
			intelligentMobility.Driver_Profile source) {
		intelligentMobility.MobilitySystem container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof intelligentMobility.MobilitySystem) {
				container = (intelligentMobility.MobilitySystem) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		for (Iterator /*[?]*/ links = container.getLink_driver_environment().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof intelligentMobility.Link_Driver_Environment) {
				continue;
			}
			intelligentMobility.Link_Driver_Environment link = (intelligentMobility.Link_Driver_Environment) linkObject;
			if (intelligentMobility.diagram.edit.parts.Link_Driver_EnvironmentEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Environment_Background dst = link.getLink_environment_background();
			intelligentMobility.Driver_Profile src = link.getLink_driver_profile();
			if (src != source) {
				continue;
			}
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, dst, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Driver_Environment_4015,
					intelligentMobility.diagram.edit.parts.Link_Driver_EnvironmentEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getOutgoingTypeModelFacetLinks_Link_LaneChanging_Turn_4016(
			intelligentMobility.Turn source) {
		intelligentMobility.MobilitySystem container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof intelligentMobility.MobilitySystem) {
				container = (intelligentMobility.MobilitySystem) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		for (Iterator /*[?]*/ links = container.getLink_laneChanging_turn().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof intelligentMobility.Link_LaneChanging_Turn) {
				continue;
			}
			intelligentMobility.Link_LaneChanging_Turn link = (intelligentMobility.Link_LaneChanging_Turn) linkObject;
			if (intelligentMobility.diagram.edit.parts.Link_LaneChanging_TurnEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.LaneChanging dst = link.getLink_laneChanging();
			intelligentMobility.Turn src = link.getLink_turn();
			if (src != source) {
				continue;
			}
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, dst, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_LaneChanging_Turn_4016,
					intelligentMobility.diagram.edit.parts.Link_LaneChanging_TurnEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getOutgoingTypeModelFacetLinks_Link_EnvironmentCondition_TrafficCondition_4017(
			intelligentMobility.Traffic_Situation source) {
		intelligentMobility.MobilitySystem container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof intelligentMobility.MobilitySystem) {
				container = (intelligentMobility.MobilitySystem) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		for (Iterator /*[?]*/ links = container.getLink_environmentCondition_trafficCondition().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof intelligentMobility.Link_EnvironmentCondition_TrafficCondition) {
				continue;
			}
			intelligentMobility.Link_EnvironmentCondition_TrafficCondition link = (intelligentMobility.Link_EnvironmentCondition_TrafficCondition) linkObject;
			if (intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_TrafficConditionEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Environment_Condition dst = link.getLink_environmentCondition();
			intelligentMobility.Traffic_Situation src = link.getLink_trafficCondition();
			if (src != source) {
				continue;
			}
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, dst, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_EnvironmentCondition_TrafficCondition_4017,
					intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_TrafficConditionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getOutgoingTypeModelFacetLinks_Link_Intersection_TrafficLight_4018(
			intelligentMobility.Intersection source) {
		intelligentMobility.MobilitySystem container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof intelligentMobility.MobilitySystem) {
				container = (intelligentMobility.MobilitySystem) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		for (Iterator /*[?]*/ links = container.getLink_intersection_trafficLight().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof intelligentMobility.Link_Intersection_TrafficLight) {
				continue;
			}
			intelligentMobility.Link_Intersection_TrafficLight link = (intelligentMobility.Link_Intersection_TrafficLight) linkObject;
			if (intelligentMobility.diagram.edit.parts.Link_Intersection_TrafficLightEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Traffic_Light dst = link.getLink_trafficLight();
			intelligentMobility.Intersection src = link.getLink_intersection();
			if (src != source) {
				continue;
			}
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, dst, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Intersection_TrafficLight_4018,
					intelligentMobility.diagram.edit.parts.Link_Intersection_TrafficLightEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getOutgoingTypeModelFacetLinks_Link_Following_MinGap_4019(
			intelligentMobility.Following source) {
		intelligentMobility.MobilitySystem container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof intelligentMobility.MobilitySystem) {
				container = (intelligentMobility.MobilitySystem) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		for (Iterator /*[?]*/ links = container.getLink_following_minGap().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof intelligentMobility.Link_Following_MinGap) {
				continue;
			}
			intelligentMobility.Link_Following_MinGap link = (intelligentMobility.Link_Following_MinGap) linkObject;
			if (intelligentMobility.diagram.edit.parts.Link_Following_MinGapEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.LaneChanging dst = link.getLink_minGap();
			intelligentMobility.Following src = link.getLink_following();
			if (src != source) {
				continue;
			}
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, dst, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Following_MinGap_4019,
					intelligentMobility.diagram.edit.parts.Link_Following_MinGapEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getOutgoingTypeModelFacetLinks_Link_NormalBehaviour_LaneChanging_4020(
			intelligentMobility.Normal_Behaviour source) {
		intelligentMobility.MobilitySystem container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof intelligentMobility.MobilitySystem) {
				container = (intelligentMobility.MobilitySystem) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		for (Iterator /*[?]*/ links = container.getLink_normalBehaviour_laneChanging().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof intelligentMobility.Link_NormalBehaviour_LaneChanging) {
				continue;
			}
			intelligentMobility.Link_NormalBehaviour_LaneChanging link = (intelligentMobility.Link_NormalBehaviour_LaneChanging) linkObject;
			if (intelligentMobility.diagram.edit.parts.Link_NormalBehaviour_LaneChangingEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.LaneChanging dst = link.getLink_lane_changing();
			intelligentMobility.Normal_Behaviour src = link.getLink_normal_behaviour();
			if (src != source) {
				continue;
			}
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, dst, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_NormalBehaviour_LaneChanging_4020,
					intelligentMobility.diagram.edit.parts.Link_NormalBehaviour_LaneChangingEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getOutgoingTypeModelFacetLinks_Link_SafetyRequirement_Regulation_4021(
			intelligentMobility.Safety_Requirement source) {
		intelligentMobility.MobilitySystem container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof intelligentMobility.MobilitySystem) {
				container = (intelligentMobility.MobilitySystem) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		for (Iterator /*[?]*/ links = container.getLink_safetyRequirement_regulation().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof intelligentMobility.Link_SafetyRequirement_Regulation) {
				continue;
			}
			intelligentMobility.Link_SafetyRequirement_Regulation link = (intelligentMobility.Link_SafetyRequirement_Regulation) linkObject;
			if (intelligentMobility.diagram.edit.parts.Link_SafetyRequirement_RegulationEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Regulation dst = link.getLink_regulation();
			intelligentMobility.Safety_Requirement src = link.getLink_safetyRequirement();
			if (src != source) {
				continue;
			}
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, dst, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_SafetyRequirement_Regulation_4021,
					intelligentMobility.diagram.edit.parts.Link_SafetyRequirement_RegulationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getOutgoingTypeModelFacetLinks_Link_DriverPreference_DrivingBehaviour_4022(
			intelligentMobility.Driving_Behaviour source) {
		intelligentMobility.MobilitySystem container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof intelligentMobility.MobilitySystem) {
				container = (intelligentMobility.MobilitySystem) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		for (Iterator /*[?]*/ links = container.getLink_driverPreference_drivingBehaviour().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof intelligentMobility.Link_DriverPreference_DrivingBehaviour) {
				continue;
			}
			intelligentMobility.Link_DriverPreference_DrivingBehaviour link = (intelligentMobility.Link_DriverPreference_DrivingBehaviour) linkObject;
			if (intelligentMobility.diagram.edit.parts.Link_DriverPreference_DrivingBehaviourEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Driver_Preference dst = link.getLink_driver_preference();
			intelligentMobility.Driving_Behaviour src = link.getLink_driving_behaviour();
			if (src != source) {
				continue;
			}
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, dst, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_DriverPreference_DrivingBehaviour_4022,
					intelligentMobility.diagram.edit.parts.Link_DriverPreference_DrivingBehaviourEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getOutgoingTypeModelFacetLinks_Link_FollowingVehicle_FrontVehicle_4023(
			intelligentMobility.PlatoonMember source) {
		intelligentMobility.MobilitySystem container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof intelligentMobility.MobilitySystem) {
				container = (intelligentMobility.MobilitySystem) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		for (Iterator /*[?]*/ links = container.getLink_followingVehicle_frontVehicle().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof intelligentMobility.Link_FollowingVehicle_FrontVehicle) {
				continue;
			}
			intelligentMobility.Link_FollowingVehicle_FrontVehicle link = (intelligentMobility.Link_FollowingVehicle_FrontVehicle) linkObject;
			if (intelligentMobility.diagram.edit.parts.Link_FollowingVehicle_FrontVehicleEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Following_Vehicle dst = link.getLink_followingVehicle();
			intelligentMobility.PlatoonMember src = link.getLink_frontVehicle();
			if (src != source) {
				continue;
			}
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, dst, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_FollowingVehicle_FrontVehicle_4023,
					intelligentMobility.diagram.edit.parts.Link_FollowingVehicle_FrontVehicleEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getOutgoingTypeModelFacetLinks_Link_DriverPreference_DriverEmotion_4024(
			intelligentMobility.Driver_Preference source) {
		intelligentMobility.MobilitySystem container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof intelligentMobility.MobilitySystem) {
				container = (intelligentMobility.MobilitySystem) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		for (Iterator /*[?]*/ links = container.getLink_driverPreference_driverEmotion().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof intelligentMobility.Link_DriverPreference_DriverEmotion) {
				continue;
			}
			intelligentMobility.Link_DriverPreference_DriverEmotion link = (intelligentMobility.Link_DriverPreference_DriverEmotion) linkObject;
			if (intelligentMobility.diagram.edit.parts.Link_DriverPreference_DriverEmotionEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Driver_Emotion dst = link.getLink_driver_emotion();
			intelligentMobility.Driver_Preference src = link.getLink_driver_preference();
			if (src != source) {
				continue;
			}
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, dst, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_DriverPreference_DriverEmotion_4024,
					intelligentMobility.diagram.edit.parts.Link_DriverPreference_DriverEmotionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getOutgoingTypeModelFacetLinks_Link_EnvironmentBackground_EnvironmentCondition_4025(
			intelligentMobility.Environment_Background source) {
		intelligentMobility.MobilitySystem container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof intelligentMobility.MobilitySystem) {
				container = (intelligentMobility.MobilitySystem) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		for (Iterator /*[?]*/ links = container.getLink_environmentBackground_environmentCondition().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof intelligentMobility.Link_EnvironmentBackground_EnvironmentCondition) {
				continue;
			}
			intelligentMobility.Link_EnvironmentBackground_EnvironmentCondition link = (intelligentMobility.Link_EnvironmentBackground_EnvironmentCondition) linkObject;
			if (intelligentMobility.diagram.edit.parts.Link_EnvironmentBackground_EnvironmentConditionEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Environment_Condition dst = link.getLink_environment_condition();
			intelligentMobility.Environment_Background src = link.getLink_environment_background();
			if (src != source) {
				continue;
			}
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, dst, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_EnvironmentBackground_EnvironmentCondition_4025,
					intelligentMobility.diagram.edit.parts.Link_EnvironmentBackground_EnvironmentConditionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getOutgoingTypeModelFacetLinks_Link_EnvironmentCondition_Weather_4026(
			intelligentMobility.Environment_Condition source) {
		intelligentMobility.MobilitySystem container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof intelligentMobility.MobilitySystem) {
				container = (intelligentMobility.MobilitySystem) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		for (Iterator /*[?]*/ links = container.getLink_environmentCondition_weather().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof intelligentMobility.Link_EnvironmentCondition_Weather) {
				continue;
			}
			intelligentMobility.Link_EnvironmentCondition_Weather link = (intelligentMobility.Link_EnvironmentCondition_Weather) linkObject;
			if (intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_WeatherEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Weather dst = link.getLink_weather();
			intelligentMobility.Environment_Condition src = link.getLink_environmentCondition();
			if (src != source) {
				continue;
			}
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, dst, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_EnvironmentCondition_Weather_4026,
					intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_WeatherEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getOutgoingTypeModelFacetLinks_Link_EnvironmentCondition_SpecialCondition_4027(
			intelligentMobility.Environment_Condition source) {
		intelligentMobility.MobilitySystem container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof intelligentMobility.MobilitySystem) {
				container = (intelligentMobility.MobilitySystem) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		for (Iterator /*[?]*/ links = container.getLink_environmentCondition_specialCondition().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof intelligentMobility.Link_EnvironmentCondition_SpecialCondition) {
				continue;
			}
			intelligentMobility.Link_EnvironmentCondition_SpecialCondition link = (intelligentMobility.Link_EnvironmentCondition_SpecialCondition) linkObject;
			if (intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_SpecialConditionEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Special_Condition dst = link.getLink_specialCondition();
			intelligentMobility.Environment_Condition src = link.getLink_environmentCondition();
			if (src != source) {
				continue;
			}
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, dst, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_EnvironmentCondition_SpecialCondition_4027,
					intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_SpecialConditionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getOutgoingTypeModelFacetLinks_Link_SpecialCondition_Intersection_4028(
			intelligentMobility.Intersection source) {
		intelligentMobility.MobilitySystem container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof intelligentMobility.MobilitySystem) {
				container = (intelligentMobility.MobilitySystem) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		for (Iterator /*[?]*/ links = container.getLink_specialCondition_intersection().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof intelligentMobility.Link_SpecialCondition_Intersection) {
				continue;
			}
			intelligentMobility.Link_SpecialCondition_Intersection link = (intelligentMobility.Link_SpecialCondition_Intersection) linkObject;
			if (intelligentMobility.diagram.edit.parts.Link_SpecialCondition_IntersectionEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Special_Condition dst = link.getLink_specialCondition();
			intelligentMobility.Intersection src = link.getLink_intersection();
			if (src != source) {
				continue;
			}
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, dst, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_SpecialCondition_Intersection_4028,
					intelligentMobility.diagram.edit.parts.Link_SpecialCondition_IntersectionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getOutgoingTypeModelFacetLinks_Link_Following_Backward_4029(
			intelligentMobility.Backward source) {
		intelligentMobility.MobilitySystem container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof intelligentMobility.MobilitySystem) {
				container = (intelligentMobility.MobilitySystem) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		for (Iterator /*[?]*/ links = container.getLink_following_backward().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof intelligentMobility.Link_Following_Backward) {
				continue;
			}
			intelligentMobility.Link_Following_Backward link = (intelligentMobility.Link_Following_Backward) linkObject;
			if (intelligentMobility.diagram.edit.parts.Link_Following_BackwardEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Following dst = link.getLink_following();
			intelligentMobility.Backward src = link.getLink_backward();
			if (src != source) {
				continue;
			}
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, dst, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Following_Backward_4029,
					intelligentMobility.diagram.edit.parts.Link_Following_BackwardEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getOutgoingTypeModelFacetLinks_Link_EnvironmentCondition_Regulations_4030(
			intelligentMobility.Environment_Condition source) {
		intelligentMobility.MobilitySystem container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof intelligentMobility.MobilitySystem) {
				container = (intelligentMobility.MobilitySystem) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		for (Iterator /*[?]*/ links = container.getLink_environmentCondition_regulation().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof intelligentMobility.Link_EnvironmentCondition_Regulations) {
				continue;
			}
			intelligentMobility.Link_EnvironmentCondition_Regulations link = (intelligentMobility.Link_EnvironmentCondition_Regulations) linkObject;
			if (intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_RegulationsEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Regulation dst = link.getLink_regulation();
			intelligentMobility.Environment_Condition src = link.getLink_environmentCondition();
			if (src != source) {
				continue;
			}
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, dst, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_EnvironmentCondition_Regulations_4030,
					intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_RegulationsEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getOutgoingTypeModelFacetLinks_Link_DrivingBehaviour_NormalBehaviour_4031(
			intelligentMobility.Driving_Behaviour source) {
		intelligentMobility.MobilitySystem container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof intelligentMobility.MobilitySystem) {
				container = (intelligentMobility.MobilitySystem) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		for (Iterator /*[?]*/ links = container.getLink_drivingBehaviour_normalBehaviour().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof intelligentMobility.Link_DrivingBehaviour_NormalBehaviour) {
				continue;
			}
			intelligentMobility.Link_DrivingBehaviour_NormalBehaviour link = (intelligentMobility.Link_DrivingBehaviour_NormalBehaviour) linkObject;
			if (intelligentMobility.diagram.edit.parts.Link_DrivingBehaviour_NormalBehaviourEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Normal_Behaviour dst = link.getLink_normal_behaviour();
			intelligentMobility.Driving_Behaviour src = link.getLink_driving_behaviour();
			if (src != source) {
				continue;
			}
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, dst, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_DrivingBehaviour_NormalBehaviour_4031,
					intelligentMobility.diagram.edit.parts.Link_DrivingBehaviour_NormalBehaviourEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getOutgoingTypeModelFacetLinks_Link_LaneChanging_EnvironmentCondition_4032(
			intelligentMobility.LaneChanging source) {
		intelligentMobility.MobilitySystem container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof intelligentMobility.MobilitySystem) {
				container = (intelligentMobility.MobilitySystem) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		for (Iterator /*[?]*/ links = container.getLink_laneChanging_environmentCondition().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof intelligentMobility.Link_LaneChanging_EnvironmentCondition) {
				continue;
			}
			intelligentMobility.Link_LaneChanging_EnvironmentCondition link = (intelligentMobility.Link_LaneChanging_EnvironmentCondition) linkObject;
			if (intelligentMobility.diagram.edit.parts.Link_LaneChanging_EnvironmentConditionEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Environment_Condition dst = link.getLink_environmentCondition();
			intelligentMobility.LaneChanging src = link.getLink_laneChanging();
			if (src != source) {
				continue;
			}
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, dst, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_LaneChanging_EnvironmentCondition_4032,
					intelligentMobility.diagram.edit.parts.Link_LaneChanging_EnvironmentConditionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getOutgoingTypeModelFacetLinks_Link_LaneChanging_GapAcceptance_4033(
			intelligentMobility.LaneChanging source) {
		intelligentMobility.MobilitySystem container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof intelligentMobility.MobilitySystem) {
				container = (intelligentMobility.MobilitySystem) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		for (Iterator /*[?]*/ links = container.getLink_laneChanging_gapAcceptance().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof intelligentMobility.Link_LaneChanging_GapAcceptance) {
				continue;
			}
			intelligentMobility.Link_LaneChanging_GapAcceptance link = (intelligentMobility.Link_LaneChanging_GapAcceptance) linkObject;
			if (intelligentMobility.diagram.edit.parts.Link_LaneChanging_GapAcceptanceEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.GapAcceptance dst = link.getLink_gapAcceptance();
			intelligentMobility.LaneChanging src = link.getLink_laneChanging();
			if (src != source) {
				continue;
			}
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, dst, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_LaneChanging_GapAcceptance_4033,
					intelligentMobility.diagram.edit.parts.Link_LaneChanging_GapAcceptanceEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getOutgoingTypeModelFacetLinks_Link_NormalBehaviour_Following_4034(
			intelligentMobility.Normal_Behaviour source) {
		intelligentMobility.MobilitySystem container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof intelligentMobility.MobilitySystem) {
				container = (intelligentMobility.MobilitySystem) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		for (Iterator /*[?]*/ links = container.getLink_normalBehaviour_following().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof intelligentMobility.Link_NormalBehaviour_Following) {
				continue;
			}
			intelligentMobility.Link_NormalBehaviour_Following link = (intelligentMobility.Link_NormalBehaviour_Following) linkObject;
			if (intelligentMobility.diagram.edit.parts.Link_NormalBehaviour_FollowingEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Following dst = link.getLink_following();
			intelligentMobility.Normal_Behaviour src = link.getLink_normal_behaviour();
			if (src != source) {
				continue;
			}
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, dst, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_NormalBehaviour_Following_4034,
					intelligentMobility.diagram.edit.parts.Link_NormalBehaviour_FollowingEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getOutgoingTypeModelFacetLinks_Link_Infrastructure_VehicleConfiguration_4035(
			intelligentMobility.Vehicle_Configuration source) {
		intelligentMobility.MobilitySystem container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof intelligentMobility.MobilitySystem) {
				container = (intelligentMobility.MobilitySystem) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		for (Iterator /*[?]*/ links = container.getLink_infrastructure_vehicle_configuration().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof intelligentMobility.Link_Infrastructure_VehicleConfiguration) {
				continue;
			}
			intelligentMobility.Link_Infrastructure_VehicleConfiguration link = (intelligentMobility.Link_Infrastructure_VehicleConfiguration) linkObject;
			if (intelligentMobility.diagram.edit.parts.Link_Infrastructure_VehicleConfigurationEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Infrastructure dst = link.getLink_infrastructure();
			intelligentMobility.Vehicle_Configuration src = link.getLink_vehicle_configuration();
			if (src != source) {
				continue;
			}
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, dst, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Infrastructure_VehicleConfiguration_4035,
					intelligentMobility.diagram.edit.parts.Link_Infrastructure_VehicleConfigurationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getOutgoingTypeModelFacetLinks_Link_CommunicationInterface_VehicleConfiguration_4036(
			intelligentMobility.CommunicationInterface source) {
		intelligentMobility.MobilitySystem container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof intelligentMobility.MobilitySystem) {
				container = (intelligentMobility.MobilitySystem) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		for (Iterator /*[?]*/ links = container.getLink_communicationInterface_vehicleConfiguration().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof intelligentMobility.Link_CommunicationInterface_VehicleConfiguration) {
				continue;
			}
			intelligentMobility.Link_CommunicationInterface_VehicleConfiguration link = (intelligentMobility.Link_CommunicationInterface_VehicleConfiguration) linkObject;
			if (intelligentMobility.diagram.edit.parts.Link_CommunicationInterface_VehicleConfigurationEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Vehicle_Configuration dst = link.getLink_vehicle_configuration();
			intelligentMobility.CommunicationInterface src = link.getLink_communication_interface();
			if (src != source) {
				continue;
			}
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, dst, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_CommunicationInterface_VehicleConfiguration_4036,
					intelligentMobility.diagram.edit.parts.Link_CommunicationInterface_VehicleConfigurationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getOutgoingTypeModelFacetLinks_Link_Goal_DrivingBehaviour_4037(
			intelligentMobility.Driving_Behaviour source) {
		intelligentMobility.MobilitySystem container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof intelligentMobility.MobilitySystem) {
				container = (intelligentMobility.MobilitySystem) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		for (Iterator /*[?]*/ links = container.getLink_goal_drivingBehaviour().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof intelligentMobility.Link_Goal_DrivingBehaviour) {
				continue;
			}
			intelligentMobility.Link_Goal_DrivingBehaviour link = (intelligentMobility.Link_Goal_DrivingBehaviour) linkObject;
			if (intelligentMobility.diagram.edit.parts.Link_Goal_DrivingBehaviourEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Goal dst = link.getLink_goal();
			intelligentMobility.Driving_Behaviour src = link.getLink_drivingBehaviour();
			if (src != source) {
				continue;
			}
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, dst, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Goal_DrivingBehaviour_4037,
					intelligentMobility.diagram.edit.parts.Link_Goal_DrivingBehaviourEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getOutgoingTypeModelFacetLinks_Link_CooperativeBehaviour_CommunicationInterface_4038(
			intelligentMobility.CooperativeBehavior source) {
		intelligentMobility.MobilitySystem container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof intelligentMobility.MobilitySystem) {
				container = (intelligentMobility.MobilitySystem) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		for (Iterator /*[?]*/ links = container.getLink_cooperativeBehaviour_communicationInterface().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof intelligentMobility.Link_CooperativeBehaviour_CommunicationInterface) {
				continue;
			}
			intelligentMobility.Link_CooperativeBehaviour_CommunicationInterface link = (intelligentMobility.Link_CooperativeBehaviour_CommunicationInterface) linkObject;
			if (intelligentMobility.diagram.edit.parts.Link_CooperativeBehaviour_CommunicationInterfaceEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.CommunicationInterface dst = link.getLink_communicationInterface();
			intelligentMobility.CooperativeBehavior src = link.getLink_cooperativeBehaviour();
			if (src != source) {
				continue;
			}
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, dst, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_CooperativeBehaviour_CommunicationInterface_4038,
					intelligentMobility.diagram.edit.parts.Link_CooperativeBehaviour_CommunicationInterfaceEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getOutgoingTypeModelFacetLinks_Link_CommunicationInterface_Infrastructure_4039(
			intelligentMobility.CommunicationInterface source) {
		intelligentMobility.MobilitySystem container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof intelligentMobility.MobilitySystem) {
				container = (intelligentMobility.MobilitySystem) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		for (Iterator /*[?]*/ links = container.getLink_communicationInterface_infrastructure().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof intelligentMobility.Link_CommunicationInterface_Infrastructure) {
				continue;
			}
			intelligentMobility.Link_CommunicationInterface_Infrastructure link = (intelligentMobility.Link_CommunicationInterface_Infrastructure) linkObject;
			if (intelligentMobility.diagram.edit.parts.Link_CommunicationInterface_InfrastructureEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Infrastructure dst = link.getLink_infrastructure();
			intelligentMobility.CommunicationInterface src = link.getLink_communicationInterface();
			if (src != source) {
				continue;
			}
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, dst, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_CommunicationInterface_Infrastructure_4039,
					intelligentMobility.diagram.edit.parts.Link_CommunicationInterface_InfrastructureEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getOutgoingTypeModelFacetLinks_Link_CooperativeBehaviour_VehicleConfiguration_4040(
			intelligentMobility.CooperativeBehavior source) {
		intelligentMobility.MobilitySystem container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof intelligentMobility.MobilitySystem) {
				container = (intelligentMobility.MobilitySystem) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		for (Iterator /*[?]*/ links = container.getLink_cooperativeBehaviour_vehicleConfiguration().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof intelligentMobility.Link_CooperativeBehaviour_VehicleConfiguration) {
				continue;
			}
			intelligentMobility.Link_CooperativeBehaviour_VehicleConfiguration link = (intelligentMobility.Link_CooperativeBehaviour_VehicleConfiguration) linkObject;
			if (intelligentMobility.diagram.edit.parts.Link_CooperativeBehaviour_VehicleConfigurationEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Vehicle_Configuration dst = link.getLink_vehicleConfiguration();
			intelligentMobility.CooperativeBehavior src = link.getLink_cooperativeBehaviour();
			if (src != source) {
				continue;
			}
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, dst, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_CooperativeBehaviour_VehicleConfiguration_4040,
					intelligentMobility.diagram.edit.parts.Link_CooperativeBehaviour_VehicleConfigurationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getOutgoingTypeModelFacetLinks_Link_TrafficSituation_EnvironmentCondition_4041(
			intelligentMobility.Environment_Condition source) {
		intelligentMobility.MobilitySystem container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof intelligentMobility.MobilitySystem) {
				container = (intelligentMobility.MobilitySystem) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		for (Iterator /*[?]*/ links = container.getLink_trafficSituation_environmentCondition().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof intelligentMobility.Link_TrafficSituation_EnvironmentCondition) {
				continue;
			}
			intelligentMobility.Link_TrafficSituation_EnvironmentCondition link = (intelligentMobility.Link_TrafficSituation_EnvironmentCondition) linkObject;
			if (intelligentMobility.diagram.edit.parts.Link_TrafficSituation_EnvironmentConditionEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Traffic_Situation dst = link.getLink_trafficSituation();
			intelligentMobility.Environment_Condition src = link.getLink_environmentCondition();
			if (src != source) {
				continue;
			}
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, dst, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_TrafficSituation_EnvironmentCondition_4041,
					intelligentMobility.diagram.edit.parts.Link_TrafficSituation_EnvironmentConditionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getOutgoingTypeModelFacetLinks_Link_Collision_SpecialCondition_4042(
			intelligentMobility.Collision source) {
		intelligentMobility.MobilitySystem container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof intelligentMobility.MobilitySystem) {
				container = (intelligentMobility.MobilitySystem) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		for (Iterator /*[?]*/ links = container.getLink_collision_specialCondition().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof intelligentMobility.Link_Collision_SpecialCondition) {
				continue;
			}
			intelligentMobility.Link_Collision_SpecialCondition link = (intelligentMobility.Link_Collision_SpecialCondition) linkObject;
			if (intelligentMobility.diagram.edit.parts.Link_Collision_SpecialConditionEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Special_Condition dst = link.getLink_specialCondition();
			intelligentMobility.Collision src = link.getLink_collision();
			if (src != source) {
				continue;
			}
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, dst, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Collision_SpecialCondition_4042,
					intelligentMobility.diagram.edit.parts.Link_Collision_SpecialConditionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getOutgoingTypeModelFacetLinks_Link_Following_LaneChanging_4043(
			intelligentMobility.Following source) {
		intelligentMobility.MobilitySystem container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof intelligentMobility.MobilitySystem) {
				container = (intelligentMobility.MobilitySystem) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		for (Iterator /*[?]*/ links = container.getLink_following_laneChanging().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof intelligentMobility.Link_Following_LaneChanging) {
				continue;
			}
			intelligentMobility.Link_Following_LaneChanging link = (intelligentMobility.Link_Following_LaneChanging) linkObject;
			if (intelligentMobility.diagram.edit.parts.Link_Following_LaneChangingEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.LaneChanging dst = link.getLink_laneChanging();
			intelligentMobility.Following src = link.getLink_following();
			if (src != source) {
				continue;
			}
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, dst, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Following_LaneChanging_4043,
					intelligentMobility.diagram.edit.parts.Link_Following_LaneChangingEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getOutgoingTypeModelFacetLinks_Link_Action_Backward_4044(
			intelligentMobility.Action source) {
		intelligentMobility.MobilitySystem container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof intelligentMobility.MobilitySystem) {
				container = (intelligentMobility.MobilitySystem) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		for (Iterator /*[?]*/ links = container.getLink_action_backward().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof intelligentMobility.Link_Action_Backward) {
				continue;
			}
			intelligentMobility.Link_Action_Backward link = (intelligentMobility.Link_Action_Backward) linkObject;
			if (intelligentMobility.diagram.edit.parts.Link_Action_BackwardEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Backward dst = link.getLink_backward();
			intelligentMobility.Action src = link.getLink_action();
			if (src != source) {
				continue;
			}
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, dst, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Action_Backward_4044,
					intelligentMobility.diagram.edit.parts.Link_Action_BackwardEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getOutgoingTypeModelFacetLinks_Link_Action_Forward_4045(
			intelligentMobility.Action source) {
		intelligentMobility.MobilitySystem container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof intelligentMobility.MobilitySystem) {
				container = (intelligentMobility.MobilitySystem) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		for (Iterator /*[?]*/ links = container.getLink_action_forward().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof intelligentMobility.Link_Action_Forward) {
				continue;
			}
			intelligentMobility.Link_Action_Forward link = (intelligentMobility.Link_Action_Forward) linkObject;
			if (intelligentMobility.diagram.edit.parts.Link_Action_ForwardEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Forward dst = link.getLink_forward();
			intelligentMobility.Action src = link.getLink_action();
			if (src != source) {
				continue;
			}
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, dst, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Action_Forward_4045,
					intelligentMobility.diagram.edit.parts.Link_Action_ForwardEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getOutgoingTypeModelFacetLinks_Link_Action_Turn_4046(
			intelligentMobility.Action source) {
		intelligentMobility.MobilitySystem container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof intelligentMobility.MobilitySystem) {
				container = (intelligentMobility.MobilitySystem) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		for (Iterator /*[?]*/ links = container.getLink_action_turn().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof intelligentMobility.Link_Action_Turn) {
				continue;
			}
			intelligentMobility.Link_Action_Turn link = (intelligentMobility.Link_Action_Turn) linkObject;
			if (intelligentMobility.diagram.edit.parts.Link_Action_TurnEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Turn dst = link.getLink_turn();
			intelligentMobility.Action src = link.getLink_action();
			if (src != source) {
				continue;
			}
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, dst, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Action_Turn_4046,
					intelligentMobility.diagram.edit.parts.Link_Action_TurnEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ getOutgoingTypeModelFacetLinks_Link_KnowledgeAndSkill_DriverPreference_4047(
			intelligentMobility.Driver_Preference source) {
		intelligentMobility.MobilitySystem container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof intelligentMobility.MobilitySystem) {
				container = (intelligentMobility.MobilitySystem) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		for (Iterator /*[?]*/ links = container.getLink_knowledgeAndSkill_driverPreference().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof intelligentMobility.Link_KnowledgeAndSkill_DriverPreference) {
				continue;
			}
			intelligentMobility.Link_KnowledgeAndSkill_DriverPreference link = (intelligentMobility.Link_KnowledgeAndSkill_DriverPreference) linkObject;
			if (intelligentMobility.diagram.edit.parts.Link_KnowledgeAndSkill_DriverPreferenceEditPart.VISUAL_ID != intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			intelligentMobility.Knowledge_and_Skill dst = link.getLink_knowledgeAndSkill();
			intelligentMobility.Driver_Preference src = link.getLink_driverPreference();
			if (src != source) {
				continue;
			}
			result.add(new intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor(src, dst, link,
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_KnowledgeAndSkill_DriverPreference_4047,
					intelligentMobility.diagram.edit.parts.Link_KnowledgeAndSkill_DriverPreferenceEditPart.VISUAL_ID));
		}
		return result;
	}

}
