/**
 */
package intelligentMobility.util;

import intelligentMobility.*;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see intelligentMobility.IntelligentMobilityPackage
 * @generated
 */
public class IntelligentMobilitySwitch {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static IntelligentMobilityPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntelligentMobilitySwitch() {
		if (modelPackage == null) {
			modelPackage = IntelligentMobilityPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public Object doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch((EClass)eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case IntelligentMobilityPackage.MOBILITY_SYSTEM: {
				MobilitySystem mobilitySystem = (MobilitySystem)theEObject;
				Object result = caseMobilitySystem(mobilitySystem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntelligentMobilityPackage.DRIVER_PROFILE: {
				Driver_Profile driver_Profile = (Driver_Profile)theEObject;
				Object result = caseDriver_Profile(driver_Profile);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntelligentMobilityPackage.VEHICLE_CONFIGURATION: {
				Vehicle_Configuration vehicle_Configuration = (Vehicle_Configuration)theEObject;
				Object result = caseVehicle_Configuration(vehicle_Configuration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntelligentMobilityPackage.ENVIRONMENT_BACKGROUND: {
				Environment_Background environment_Background = (Environment_Background)theEObject;
				Object result = caseEnvironment_Background(environment_Background);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntelligentMobilityPackage.DRIVER_PREFERENCE: {
				Driver_Preference driver_Preference = (Driver_Preference)theEObject;
				Object result = caseDriver_Preference(driver_Preference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntelligentMobilityPackage.KNOWLEDGE_AND_SKILL: {
				Knowledge_and_Skill knowledge_and_Skill = (Knowledge_and_Skill)theEObject;
				Object result = caseKnowledge_and_Skill(knowledge_and_Skill);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntelligentMobilityPackage.DRIVER_EMOTION: {
				Driver_Emotion driver_Emotion = (Driver_Emotion)theEObject;
				Object result = caseDriver_Emotion(driver_Emotion);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR: {
				Driving_Behaviour driving_Behaviour = (Driving_Behaviour)theEObject;
				Object result = caseDriving_Behaviour(driving_Behaviour);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntelligentMobilityPackage.NORMAL_BEHAVIOUR: {
				Normal_Behaviour normal_Behaviour = (Normal_Behaviour)theEObject;
				Object result = caseNormal_Behaviour(normal_Behaviour);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntelligentMobilityPackage.FOLLOWING: {
				Following following = (Following)theEObject;
				Object result = caseFollowing(following);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntelligentMobilityPackage.LANE_CHANGING: {
				LaneChanging laneChanging = (LaneChanging)theEObject;
				Object result = caseLaneChanging(laneChanging);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntelligentMobilityPackage.ABNORMAL_BEHAVIOUR: {
				Abnormal_Behaviour abnormal_Behaviour = (Abnormal_Behaviour)theEObject;
				Object result = caseAbnormal_Behaviour(abnormal_Behaviour);
				if (result == null) result = caseNormal_Behaviour(abnormal_Behaviour);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntelligentMobilityPackage.FORWARD: {
				Forward forward = (Forward)theEObject;
				Object result = caseForward(forward);
				if (result == null) result = caseAction(forward);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntelligentMobilityPackage.BACKWARD: {
				Backward backward = (Backward)theEObject;
				Object result = caseBackward(backward);
				if (result == null) result = caseAction(backward);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntelligentMobilityPackage.TURN: {
				Turn turn = (Turn)theEObject;
				Object result = caseTurn(turn);
				if (result == null) result = caseAction(turn);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntelligentMobilityPackage.GAP_ACCEPTANCE: {
				GapAcceptance gapAcceptance = (GapAcceptance)theEObject;
				Object result = caseGapAcceptance(gapAcceptance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntelligentMobilityPackage.ACTION: {
				Action action = (Action)theEObject;
				Object result = caseAction(action);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntelligentMobilityPackage.VEHICLE_TYPE: {
				Vehicle_Type vehicle_Type = (Vehicle_Type)theEObject;
				Object result = caseVehicle_Type(vehicle_Type);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntelligentMobilityPackage.PLATOON: {
				Platoon platoon = (Platoon)theEObject;
				Object result = casePlatoon(platoon);
				if (result == null) result = caseVehicle_Type(platoon);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntelligentMobilityPackage.NORMAL_VEHICLE: {
				Normal_Vehicle normal_Vehicle = (Normal_Vehicle)theEObject;
				Object result = caseNormal_Vehicle(normal_Vehicle);
				if (result == null) result = caseVehicle_Type(normal_Vehicle);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntelligentMobilityPackage.LEADING_VEHICLE: {
				Leading_Vehicle leading_Vehicle = (Leading_Vehicle)theEObject;
				Object result = caseLeading_Vehicle(leading_Vehicle);
				if (result == null) result = casePlatoonMember(leading_Vehicle);
				if (result == null) result = caseNormal_Vehicle(leading_Vehicle);
				if (result == null) result = caseVehicle_Type(leading_Vehicle);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntelligentMobilityPackage.FOLLOWING_VEHICLE: {
				Following_Vehicle following_Vehicle = (Following_Vehicle)theEObject;
				Object result = caseFollowing_Vehicle(following_Vehicle);
				if (result == null) result = casePlatoonMember(following_Vehicle);
				if (result == null) result = caseNormal_Vehicle(following_Vehicle);
				if (result == null) result = caseVehicle_Type(following_Vehicle);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntelligentMobilityPackage.PLATOON_MEMBER: {
				PlatoonMember platoonMember = (PlatoonMember)theEObject;
				Object result = casePlatoonMember(platoonMember);
				if (result == null) result = caseNormal_Vehicle(platoonMember);
				if (result == null) result = caseVehicle_Type(platoonMember);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntelligentMobilityPackage.POSSIBLE_VEHICLE: {
				PossibleVehicle possibleVehicle = (PossibleVehicle)theEObject;
				Object result = casePossibleVehicle(possibleVehicle);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntelligentMobilityPackage.ENVIRONMENT_CONDITION: {
				Environment_Condition environment_Condition = (Environment_Condition)theEObject;
				Object result = caseEnvironment_Condition(environment_Condition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntelligentMobilityPackage.LANE_TYPE: {
				Lane_Type lane_Type = (Lane_Type)theEObject;
				Object result = caseLane_Type(lane_Type);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntelligentMobilityPackage.REGULATION: {
				Regulation regulation = (Regulation)theEObject;
				Object result = caseRegulation(regulation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntelligentMobilityPackage.SAFETY_REQUIREMENT: {
				Safety_Requirement safety_Requirement = (Safety_Requirement)theEObject;
				Object result = caseSafety_Requirement(safety_Requirement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntelligentMobilityPackage.WEATHER: {
				Weather weather = (Weather)theEObject;
				Object result = caseWeather(weather);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntelligentMobilityPackage.TRAFFIC_SITUATION: {
				Traffic_Situation traffic_Situation = (Traffic_Situation)theEObject;
				Object result = caseTraffic_Situation(traffic_Situation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntelligentMobilityPackage.SPECIAL_CONDITION: {
				Special_Condition special_Condition = (Special_Condition)theEObject;
				Object result = caseSpecial_Condition(special_Condition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntelligentMobilityPackage.COLLISION: {
				Collision collision = (Collision)theEObject;
				Object result = caseCollision(collision);
				if (result == null) result = caseExceptionCondition(collision);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntelligentMobilityPackage.INTERSECTION: {
				Intersection intersection = (Intersection)theEObject;
				Object result = caseIntersection(intersection);
				if (result == null) result = caseExceptionCondition(intersection);
				if (result == null) result = caseInfrastructure(intersection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntelligentMobilityPackage.OBSTRUCTION: {
				Obstruction obstruction = (Obstruction)theEObject;
				Object result = caseObstruction(obstruction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntelligentMobilityPackage.TRAFFIC_LIGHT: {
				Traffic_Light traffic_Light = (Traffic_Light)theEObject;
				Object result = caseTraffic_Light(traffic_Light);
				if (result == null) result = caseInfrastructure(traffic_Light);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntelligentMobilityPackage.EXCEPTION_CONDITION: {
				ExceptionCondition exceptionCondition = (ExceptionCondition)theEObject;
				Object result = caseExceptionCondition(exceptionCondition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntelligentMobilityPackage.LINK_DRIVER_ENVIRONMENT: {
				Link_Driver_Environment link_Driver_Environment = (Link_Driver_Environment)theEObject;
				Object result = caseLink_Driver_Environment(link_Driver_Environment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntelligentMobilityPackage.LINK_DRIVER_VEHICLE: {
				Link_Driver_Vehicle link_Driver_Vehicle = (Link_Driver_Vehicle)theEObject;
				Object result = caseLink_Driver_Vehicle(link_Driver_Vehicle);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntelligentMobilityPackage.LINK_VEHICLE_ENVIRONMENT: {
				Link_Vehicle_Environment link_Vehicle_Environment = (Link_Vehicle_Environment)theEObject;
				Object result = caseLink_Vehicle_Environment(link_Vehicle_Environment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntelligentMobilityPackage.LINK_DRIVER_PROFILE_DRIVER_PREFERENCE: {
				Link_DriverProfile_DriverPreference link_DriverProfile_DriverPreference = (Link_DriverProfile_DriverPreference)theEObject;
				Object result = caseLink_DriverProfile_DriverPreference(link_DriverProfile_DriverPreference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntelligentMobilityPackage.LINK_VEHICLE_CONFIGURATION_VEHICLE_TYPE: {
				Link_VehicleConfiguration_VehicleType link_VehicleConfiguration_VehicleType = (Link_VehicleConfiguration_VehicleType)theEObject;
				Object result = caseLink_VehicleConfiguration_VehicleType(link_VehicleConfiguration_VehicleType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntelligentMobilityPackage.LINK_ENVIRONMENT_BACKGROUND_POSSIBLE_VEHICLE: {
				Link_EnvironmentBackground_PossibleVehicle link_EnvironmentBackground_PossibleVehicle = (Link_EnvironmentBackground_PossibleVehicle)theEObject;
				Object result = caseLink_EnvironmentBackground_PossibleVehicle(link_EnvironmentBackground_PossibleVehicle);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntelligentMobilityPackage.LINK_ENVIRONMENT_BACKGROUND_ENVIRONMENT_CONDITION: {
				Link_EnvironmentBackground_EnvironmentCondition link_EnvironmentBackground_EnvironmentCondition = (Link_EnvironmentBackground_EnvironmentCondition)theEObject;
				Object result = caseLink_EnvironmentBackground_EnvironmentCondition(link_EnvironmentBackground_EnvironmentCondition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntelligentMobilityPackage.LINK_DRIVER_PREFERENCE_DRIVER_EMOTION: {
				Link_DriverPreference_DriverEmotion link_DriverPreference_DriverEmotion = (Link_DriverPreference_DriverEmotion)theEObject;
				Object result = caseLink_DriverPreference_DriverEmotion(link_DriverPreference_DriverEmotion);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntelligentMobilityPackage.LINK_DRIVER_PREFERENCE_DRIVING_BEHAVIOUR: {
				Link_DriverPreference_DrivingBehaviour link_DriverPreference_DrivingBehaviour = (Link_DriverPreference_DrivingBehaviour)theEObject;
				Object result = caseLink_DriverPreference_DrivingBehaviour(link_DriverPreference_DrivingBehaviour);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntelligentMobilityPackage.LINK_DRIVER_PREFERENCE_ENVIRONMENT_CONDITION: {
				Link_DriverPreference_EnvironmentCondition link_DriverPreference_EnvironmentCondition = (Link_DriverPreference_EnvironmentCondition)theEObject;
				Object result = caseLink_DriverPreference_EnvironmentCondition(link_DriverPreference_EnvironmentCondition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntelligentMobilityPackage.LINK_DRIVING_BEHAVIOUR_NORMAL_BEHAVIOUR: {
				Link_DrivingBehaviour_NormalBehaviour link_DrivingBehaviour_NormalBehaviour = (Link_DrivingBehaviour_NormalBehaviour)theEObject;
				Object result = caseLink_DrivingBehaviour_NormalBehaviour(link_DrivingBehaviour_NormalBehaviour);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntelligentMobilityPackage.LINK_NORMAL_BEHAVIOUR_FOLLOWING: {
				Link_NormalBehaviour_Following link_NormalBehaviour_Following = (Link_NormalBehaviour_Following)theEObject;
				Object result = caseLink_NormalBehaviour_Following(link_NormalBehaviour_Following);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntelligentMobilityPackage.LINK_NORMAL_BEHAVIOUR_LANE_CHANGING: {
				Link_NormalBehaviour_LaneChanging link_NormalBehaviour_LaneChanging = (Link_NormalBehaviour_LaneChanging)theEObject;
				Object result = caseLink_NormalBehaviour_LaneChanging(link_NormalBehaviour_LaneChanging);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntelligentMobilityPackage.LINK_FOLLOWING_MIN_GAP: {
				Link_Following_MinGap link_Following_MinGap = (Link_Following_MinGap)theEObject;
				Object result = caseLink_Following_MinGap(link_Following_MinGap);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntelligentMobilityPackage.LINK_FOLLOWING_FORWARD: {
				Link_Following_Forward link_Following_Forward = (Link_Following_Forward)theEObject;
				Object result = caseLink_Following_Forward(link_Following_Forward);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntelligentMobilityPackage.LINK_FOLLOWING_BACKWARD: {
				Link_Following_Backward link_Following_Backward = (Link_Following_Backward)theEObject;
				Object result = caseLink_Following_Backward(link_Following_Backward);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntelligentMobilityPackage.LINK_LANE_CHANGING_TURN: {
				Link_LaneChanging_Turn link_LaneChanging_Turn = (Link_LaneChanging_Turn)theEObject;
				Object result = caseLink_LaneChanging_Turn(link_LaneChanging_Turn);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntelligentMobilityPackage.LINK_LANE_CHANGING_GAP_ACCEPTANCE: {
				Link_LaneChanging_GapAcceptance link_LaneChanging_GapAcceptance = (Link_LaneChanging_GapAcceptance)theEObject;
				Object result = caseLink_LaneChanging_GapAcceptance(link_LaneChanging_GapAcceptance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntelligentMobilityPackage.LINK_LANE_CHANGING_ENVIRONMENT_CONDITION: {
				Link_LaneChanging_EnvironmentCondition link_LaneChanging_EnvironmentCondition = (Link_LaneChanging_EnvironmentCondition)theEObject;
				Object result = caseLink_LaneChanging_EnvironmentCondition(link_LaneChanging_EnvironmentCondition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntelligentMobilityPackage.LINK_ABNORMAL_BEHAVIOUR_ACTION: {
				Link_AbnormalBehaviour_Action link_AbnormalBehaviour_Action = (Link_AbnormalBehaviour_Action)theEObject;
				Object result = caseLink_AbnormalBehaviour_Action(link_AbnormalBehaviour_Action);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntelligentMobilityPackage.LINK_PLATOON_LEADING_VEHICLE: {
				Link_Platoon_LeadingVehicle link_Platoon_LeadingVehicle = (Link_Platoon_LeadingVehicle)theEObject;
				Object result = caseLink_Platoon_LeadingVehicle(link_Platoon_LeadingVehicle);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntelligentMobilityPackage.LINK_PLATOON_FOLLOWING_VEHICLE: {
				Link_Platoon_FollowingVehicle link_Platoon_FollowingVehicle = (Link_Platoon_FollowingVehicle)theEObject;
				Object result = caseLink_Platoon_FollowingVehicle(link_Platoon_FollowingVehicle);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntelligentMobilityPackage.LINK_NORMAL_VEHICLE_SAFETY_REQUIREMENTS: {
				Link_NormalVehicle_SafetyRequirements link_NormalVehicle_SafetyRequirements = (Link_NormalVehicle_SafetyRequirements)theEObject;
				Object result = caseLink_NormalVehicle_SafetyRequirements(link_NormalVehicle_SafetyRequirements);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntelligentMobilityPackage.LINK_FOLLOWING_VEHICLE_FRONT_VEHICLE: {
				Link_FollowingVehicle_FrontVehicle link_FollowingVehicle_FrontVehicle = (Link_FollowingVehicle_FrontVehicle)theEObject;
				Object result = caseLink_FollowingVehicle_FrontVehicle(link_FollowingVehicle_FrontVehicle);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntelligentMobilityPackage.LINK_ENVIRONMENT_CONDITION_LANE_TYPE: {
				Link_EnvironmentCondition_LaneType link_EnvironmentCondition_LaneType = (Link_EnvironmentCondition_LaneType)theEObject;
				Object result = caseLink_EnvironmentCondition_LaneType(link_EnvironmentCondition_LaneType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntelligentMobilityPackage.LINK_ENVIRONMENT_CONDITION_REGULATIONS: {
				Link_EnvironmentCondition_Regulations link_EnvironmentCondition_Regulations = (Link_EnvironmentCondition_Regulations)theEObject;
				Object result = caseLink_EnvironmentCondition_Regulations(link_EnvironmentCondition_Regulations);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntelligentMobilityPackage.LINK_ENVIRONMENT_CONDITION_WEATHER: {
				Link_EnvironmentCondition_Weather link_EnvironmentCondition_Weather = (Link_EnvironmentCondition_Weather)theEObject;
				Object result = caseLink_EnvironmentCondition_Weather(link_EnvironmentCondition_Weather);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntelligentMobilityPackage.LINK_ENVIRONMENT_CONDITION_TRAFFIC_CONDITION: {
				Link_EnvironmentCondition_TrafficCondition link_EnvironmentCondition_TrafficCondition = (Link_EnvironmentCondition_TrafficCondition)theEObject;
				Object result = caseLink_EnvironmentCondition_TrafficCondition(link_EnvironmentCondition_TrafficCondition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntelligentMobilityPackage.LINK_ENVIRONMENT_CONDITION_SPECIAL_CONDITION: {
				Link_EnvironmentCondition_SpecialCondition link_EnvironmentCondition_SpecialCondition = (Link_EnvironmentCondition_SpecialCondition)theEObject;
				Object result = caseLink_EnvironmentCondition_SpecialCondition(link_EnvironmentCondition_SpecialCondition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntelligentMobilityPackage.LINK_LANE_TYPE_REGULATION: {
				Link_LaneType_Regulation link_LaneType_Regulation = (Link_LaneType_Regulation)theEObject;
				Object result = caseLink_LaneType_Regulation(link_LaneType_Regulation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntelligentMobilityPackage.LINK_SAFETY_REQUIREMENT_REGULATION: {
				Link_SafetyRequirement_Regulation link_SafetyRequirement_Regulation = (Link_SafetyRequirement_Regulation)theEObject;
				Object result = caseLink_SafetyRequirement_Regulation(link_SafetyRequirement_Regulation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntelligentMobilityPackage.LINK_SPECIAL_CONDITION_INTERSECTION: {
				Link_SpecialCondition_Intersection link_SpecialCondition_Intersection = (Link_SpecialCondition_Intersection)theEObject;
				Object result = caseLink_SpecialCondition_Intersection(link_SpecialCondition_Intersection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntelligentMobilityPackage.LINK_COLLISION_OBSTRUCTION: {
				Link_Collision_Obstruction link_Collision_Obstruction = (Link_Collision_Obstruction)theEObject;
				Object result = caseLink_Collision_Obstruction(link_Collision_Obstruction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntelligentMobilityPackage.LINK_INTERSECTION_TRAFFIC_LIGHT: {
				Link_Intersection_TrafficLight link_Intersection_TrafficLight = (Link_Intersection_TrafficLight)theEObject;
				Object result = caseLink_Intersection_TrafficLight(link_Intersection_TrafficLight);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntelligentMobilityPackage.INFRASTRUCTURE: {
				Infrastructure infrastructure = (Infrastructure)theEObject;
				Object result = caseInfrastructure(infrastructure);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntelligentMobilityPackage.ROAD_SEGMENT: {
				RoadSegment roadSegment = (RoadSegment)theEObject;
				Object result = caseRoadSegment(roadSegment);
				if (result == null) result = caseInfrastructure(roadSegment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntelligentMobilityPackage.SMART_SENSOR: {
				SmartSensor smartSensor = (SmartSensor)theEObject;
				Object result = caseSmartSensor(smartSensor);
				if (result == null) result = caseInfrastructure(smartSensor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntelligentMobilityPackage.ROAD_SIDE_UNIT: {
				Road_Side_Unit road_Side_Unit = (Road_Side_Unit)theEObject;
				Object result = caseRoad_Side_Unit(road_Side_Unit);
				if (result == null) result = caseInfrastructure(road_Side_Unit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntelligentMobilityPackage.CHARGING_STATION: {
				ChargingStation chargingStation = (ChargingStation)theEObject;
				Object result = caseChargingStation(chargingStation);
				if (result == null) result = caseInfrastructure(chargingStation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntelligentMobilityPackage.COMMUNICATION_INTERFACE: {
				CommunicationInterface communicationInterface = (CommunicationInterface)theEObject;
				Object result = caseCommunicationInterface(communicationInterface);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntelligentMobilityPackage.COOPERATIVE_BEHAVIOR: {
				CooperativeBehavior cooperativeBehavior = (CooperativeBehavior)theEObject;
				Object result = caseCooperativeBehavior(cooperativeBehavior);
				if (result == null) result = caseDriving_Behaviour(cooperativeBehavior);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntelligentMobilityPackage.GOAL: {
				Goal goal = (Goal)theEObject;
				Object result = caseGoal(goal);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntelligentMobilityPackage.LINK_INFRASTRUCTURE_VEHICLE_CONFIGURATION: {
				Link_Infrastructure_VehicleConfiguration link_Infrastructure_VehicleConfiguration = (Link_Infrastructure_VehicleConfiguration)theEObject;
				Object result = caseLink_Infrastructure_VehicleConfiguration(link_Infrastructure_VehicleConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntelligentMobilityPackage.LINK_COMMUNICATION_INTERFACE_VEHICLE_CONFIGURATION: {
				Link_CommunicationInterface_VehicleConfiguration link_CommunicationInterface_VehicleConfiguration = (Link_CommunicationInterface_VehicleConfiguration)theEObject;
				Object result = caseLink_CommunicationInterface_VehicleConfiguration(link_CommunicationInterface_VehicleConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntelligentMobilityPackage.LINK_GOAL_DRIVING_BEHAVIOUR: {
				Link_Goal_DrivingBehaviour link_Goal_DrivingBehaviour = (Link_Goal_DrivingBehaviour)theEObject;
				Object result = caseLink_Goal_DrivingBehaviour(link_Goal_DrivingBehaviour);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntelligentMobilityPackage.LINK_COOPERATIVE_BEHAVIOUR_COMMUNICATION_INTERFACE: {
				Link_CooperativeBehaviour_CommunicationInterface link_CooperativeBehaviour_CommunicationInterface = (Link_CooperativeBehaviour_CommunicationInterface)theEObject;
				Object result = caseLink_CooperativeBehaviour_CommunicationInterface(link_CooperativeBehaviour_CommunicationInterface);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntelligentMobilityPackage.LINK_COMMUNICATION_INTERFACE_INFRASTRUCTURE: {
				Link_CommunicationInterface_Infrastructure link_CommunicationInterface_Infrastructure = (Link_CommunicationInterface_Infrastructure)theEObject;
				Object result = caseLink_CommunicationInterface_Infrastructure(link_CommunicationInterface_Infrastructure);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntelligentMobilityPackage.LINK_COOPERATIVE_BEHAVIOUR_VEHICLE_CONFIGURATION: {
				Link_CooperativeBehaviour_VehicleConfiguration link_CooperativeBehaviour_VehicleConfiguration = (Link_CooperativeBehaviour_VehicleConfiguration)theEObject;
				Object result = caseLink_CooperativeBehaviour_VehicleConfiguration(link_CooperativeBehaviour_VehicleConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntelligentMobilityPackage.LINK_TRAFFIC_SITUATION_ENVIRONMENT_CONDITION: {
				Link_TrafficSituation_EnvironmentCondition link_TrafficSituation_EnvironmentCondition = (Link_TrafficSituation_EnvironmentCondition)theEObject;
				Object result = caseLink_TrafficSituation_EnvironmentCondition(link_TrafficSituation_EnvironmentCondition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntelligentMobilityPackage.LINK_FOLLOWING_LANE_CHANGING: {
				Link_Following_LaneChanging link_Following_LaneChanging = (Link_Following_LaneChanging)theEObject;
				Object result = caseLink_Following_LaneChanging(link_Following_LaneChanging);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntelligentMobilityPackage.LINK_COLLISION_SPECIAL_CONDITION: {
				Link_Collision_SpecialCondition link_Collision_SpecialCondition = (Link_Collision_SpecialCondition)theEObject;
				Object result = caseLink_Collision_SpecialCondition(link_Collision_SpecialCondition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntelligentMobilityPackage.LINK_ACTION_BACKWARD: {
				Link_Action_Backward link_Action_Backward = (Link_Action_Backward)theEObject;
				Object result = caseLink_Action_Backward(link_Action_Backward);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntelligentMobilityPackage.LINK_ACTION_FORWARD: {
				Link_Action_Forward link_Action_Forward = (Link_Action_Forward)theEObject;
				Object result = caseLink_Action_Forward(link_Action_Forward);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntelligentMobilityPackage.LINK_ACTION_TURN: {
				Link_Action_Turn link_Action_Turn = (Link_Action_Turn)theEObject;
				Object result = caseLink_Action_Turn(link_Action_Turn);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IntelligentMobilityPackage.LINK_KNOWLEDGE_AND_SKILL_DRIVER_PREFERENCE: {
				Link_KnowledgeAndSkill_DriverPreference link_KnowledgeAndSkill_DriverPreference = (Link_KnowledgeAndSkill_DriverPreference)theEObject;
				Object result = caseLink_KnowledgeAndSkill_DriverPreference(link_KnowledgeAndSkill_DriverPreference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mobility System</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mobility System</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseMobilitySystem(MobilitySystem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Driver Profile</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Driver Profile</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDriver_Profile(Driver_Profile object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Vehicle Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Vehicle Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseVehicle_Configuration(Vehicle_Configuration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Environment Background</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Environment Background</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseEnvironment_Background(Environment_Background object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Driver Preference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Driver Preference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDriver_Preference(Driver_Preference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Knowledge and Skill</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Knowledge and Skill</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseKnowledge_and_Skill(Knowledge_and_Skill object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Driver Emotion</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Driver Emotion</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDriver_Emotion(Driver_Emotion object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Driving Behaviour</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Driving Behaviour</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDriving_Behaviour(Driving_Behaviour object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Normal Behaviour</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Normal Behaviour</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseNormal_Behaviour(Normal_Behaviour object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Following</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Following</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseFollowing(Following object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Lane Changing</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Lane Changing</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLaneChanging(LaneChanging object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abnormal Behaviour</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abnormal Behaviour</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseAbnormal_Behaviour(Abnormal_Behaviour object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Forward</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Forward</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseForward(Forward object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Backward</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Backward</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseBackward(Backward object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Turn</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Turn</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseTurn(Turn object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Gap Acceptance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Gap Acceptance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseGapAcceptance(GapAcceptance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseAction(Action object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Vehicle Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Vehicle Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseVehicle_Type(Vehicle_Type object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Platoon</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Platoon</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object casePlatoon(Platoon object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Normal Vehicle</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Normal Vehicle</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseNormal_Vehicle(Normal_Vehicle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Leading Vehicle</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Leading Vehicle</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLeading_Vehicle(Leading_Vehicle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Following Vehicle</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Following Vehicle</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseFollowing_Vehicle(Following_Vehicle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Platoon Member</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Platoon Member</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object casePlatoonMember(PlatoonMember object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Possible Vehicle</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Possible Vehicle</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object casePossibleVehicle(PossibleVehicle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Environment Condition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Environment Condition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseEnvironment_Condition(Environment_Condition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Lane Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Lane Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLane_Type(Lane_Type object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Regulation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Regulation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseRegulation(Regulation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Safety Requirement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Safety Requirement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSafety_Requirement(Safety_Requirement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Weather</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Weather</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWeather(Weather object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Traffic Situation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Traffic Situation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseTraffic_Situation(Traffic_Situation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Special Condition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Special Condition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSpecial_Condition(Special_Condition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Collision</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Collision</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCollision(Collision object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Intersection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Intersection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseIntersection(Intersection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Obstruction</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Obstruction</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseObstruction(Obstruction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Traffic Light</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Traffic Light</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseTraffic_Light(Traffic_Light object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Exception Condition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Exception Condition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseExceptionCondition(ExceptionCondition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Link Driver Environment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Link Driver Environment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLink_Driver_Environment(Link_Driver_Environment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Link Driver Vehicle</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Link Driver Vehicle</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLink_Driver_Vehicle(Link_Driver_Vehicle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Link Vehicle Environment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Link Vehicle Environment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLink_Vehicle_Environment(Link_Vehicle_Environment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Link Driver Profile Driver Preference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Link Driver Profile Driver Preference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLink_DriverProfile_DriverPreference(Link_DriverProfile_DriverPreference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Link Vehicle Configuration Vehicle Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Link Vehicle Configuration Vehicle Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLink_VehicleConfiguration_VehicleType(Link_VehicleConfiguration_VehicleType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Link Environment Background Possible Vehicle</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Link Environment Background Possible Vehicle</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLink_EnvironmentBackground_PossibleVehicle(Link_EnvironmentBackground_PossibleVehicle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Link Environment Background Environment Condition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Link Environment Background Environment Condition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLink_EnvironmentBackground_EnvironmentCondition(Link_EnvironmentBackground_EnvironmentCondition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Link Driver Preference Driver Emotion</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Link Driver Preference Driver Emotion</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLink_DriverPreference_DriverEmotion(Link_DriverPreference_DriverEmotion object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Link Driver Preference Driving Behaviour</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Link Driver Preference Driving Behaviour</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLink_DriverPreference_DrivingBehaviour(Link_DriverPreference_DrivingBehaviour object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Link Driver Preference Environment Condition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Link Driver Preference Environment Condition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLink_DriverPreference_EnvironmentCondition(Link_DriverPreference_EnvironmentCondition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Link Driving Behaviour Normal Behaviour</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Link Driving Behaviour Normal Behaviour</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLink_DrivingBehaviour_NormalBehaviour(Link_DrivingBehaviour_NormalBehaviour object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Link Normal Behaviour Following</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Link Normal Behaviour Following</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLink_NormalBehaviour_Following(Link_NormalBehaviour_Following object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Link Normal Behaviour Lane Changing</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Link Normal Behaviour Lane Changing</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLink_NormalBehaviour_LaneChanging(Link_NormalBehaviour_LaneChanging object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Link Following Min Gap</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Link Following Min Gap</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLink_Following_MinGap(Link_Following_MinGap object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Link Following Forward</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Link Following Forward</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLink_Following_Forward(Link_Following_Forward object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Link Following Backward</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Link Following Backward</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLink_Following_Backward(Link_Following_Backward object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Link Lane Changing Turn</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Link Lane Changing Turn</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLink_LaneChanging_Turn(Link_LaneChanging_Turn object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Link Lane Changing Gap Acceptance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Link Lane Changing Gap Acceptance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLink_LaneChanging_GapAcceptance(Link_LaneChanging_GapAcceptance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Link Lane Changing Environment Condition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Link Lane Changing Environment Condition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLink_LaneChanging_EnvironmentCondition(Link_LaneChanging_EnvironmentCondition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Link Abnormal Behaviour Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Link Abnormal Behaviour Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLink_AbnormalBehaviour_Action(Link_AbnormalBehaviour_Action object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Link Platoon Leading Vehicle</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Link Platoon Leading Vehicle</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLink_Platoon_LeadingVehicle(Link_Platoon_LeadingVehicle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Link Platoon Following Vehicle</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Link Platoon Following Vehicle</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLink_Platoon_FollowingVehicle(Link_Platoon_FollowingVehicle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Link Normal Vehicle Safety Requirements</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Link Normal Vehicle Safety Requirements</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLink_NormalVehicle_SafetyRequirements(Link_NormalVehicle_SafetyRequirements object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Link Following Vehicle Front Vehicle</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Link Following Vehicle Front Vehicle</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLink_FollowingVehicle_FrontVehicle(Link_FollowingVehicle_FrontVehicle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Link Environment Condition Lane Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Link Environment Condition Lane Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLink_EnvironmentCondition_LaneType(Link_EnvironmentCondition_LaneType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Link Environment Condition Regulations</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Link Environment Condition Regulations</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLink_EnvironmentCondition_Regulations(Link_EnvironmentCondition_Regulations object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Link Environment Condition Weather</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Link Environment Condition Weather</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLink_EnvironmentCondition_Weather(Link_EnvironmentCondition_Weather object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Link Environment Condition Traffic Condition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Link Environment Condition Traffic Condition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLink_EnvironmentCondition_TrafficCondition(Link_EnvironmentCondition_TrafficCondition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Link Environment Condition Special Condition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Link Environment Condition Special Condition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLink_EnvironmentCondition_SpecialCondition(Link_EnvironmentCondition_SpecialCondition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Link Lane Type Regulation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Link Lane Type Regulation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLink_LaneType_Regulation(Link_LaneType_Regulation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Link Safety Requirement Regulation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Link Safety Requirement Regulation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLink_SafetyRequirement_Regulation(Link_SafetyRequirement_Regulation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Link Special Condition Intersection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Link Special Condition Intersection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLink_SpecialCondition_Intersection(Link_SpecialCondition_Intersection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Link Collision Obstruction</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Link Collision Obstruction</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLink_Collision_Obstruction(Link_Collision_Obstruction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Link Intersection Traffic Light</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Link Intersection Traffic Light</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLink_Intersection_TrafficLight(Link_Intersection_TrafficLight object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Infrastructure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Infrastructure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseInfrastructure(Infrastructure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Road Segment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Road Segment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseRoadSegment(RoadSegment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Smart Sensor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Smart Sensor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSmartSensor(SmartSensor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Road Side Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Road Side Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseRoad_Side_Unit(Road_Side_Unit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Charging Station</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Charging Station</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseChargingStation(ChargingStation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Communication Interface</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Communication Interface</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCommunicationInterface(CommunicationInterface object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Cooperative Behavior</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cooperative Behavior</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCooperativeBehavior(CooperativeBehavior object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Goal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Goal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseGoal(Goal object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Link Infrastructure Vehicle Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Link Infrastructure Vehicle Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLink_Infrastructure_VehicleConfiguration(Link_Infrastructure_VehicleConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Link Communication Interface Vehicle Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Link Communication Interface Vehicle Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLink_CommunicationInterface_VehicleConfiguration(Link_CommunicationInterface_VehicleConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Link Goal Driving Behaviour</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Link Goal Driving Behaviour</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLink_Goal_DrivingBehaviour(Link_Goal_DrivingBehaviour object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Link Cooperative Behaviour Communication Interface</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Link Cooperative Behaviour Communication Interface</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLink_CooperativeBehaviour_CommunicationInterface(Link_CooperativeBehaviour_CommunicationInterface object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Link Communication Interface Infrastructure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Link Communication Interface Infrastructure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLink_CommunicationInterface_Infrastructure(Link_CommunicationInterface_Infrastructure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Link Cooperative Behaviour Vehicle Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Link Cooperative Behaviour Vehicle Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLink_CooperativeBehaviour_VehicleConfiguration(Link_CooperativeBehaviour_VehicleConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Link Traffic Situation Environment Condition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Link Traffic Situation Environment Condition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLink_TrafficSituation_EnvironmentCondition(Link_TrafficSituation_EnvironmentCondition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Link Following Lane Changing</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Link Following Lane Changing</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLink_Following_LaneChanging(Link_Following_LaneChanging object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Link Collision Special Condition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Link Collision Special Condition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLink_Collision_SpecialCondition(Link_Collision_SpecialCondition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Link Action Backward</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Link Action Backward</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLink_Action_Backward(Link_Action_Backward object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Link Action Forward</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Link Action Forward</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLink_Action_Forward(Link_Action_Forward object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Link Action Turn</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Link Action Turn</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLink_Action_Turn(Link_Action_Turn object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Link Knowledge And Skill Driver Preference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Link Knowledge And Skill Driver Preference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLink_KnowledgeAndSkill_DriverPreference(Link_KnowledgeAndSkill_DriverPreference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public Object defaultCase(EObject object) {
		return null;
	}

} //IntelligentMobilitySwitch
