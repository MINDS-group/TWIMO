/**
 */
package intelligentMobility.impl;

import intelligentMobility.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class IntelligentMobilityFactoryImpl extends EFactoryImpl implements IntelligentMobilityFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IntelligentMobilityFactory init() {
		try {
			IntelligentMobilityFactory theIntelligentMobilityFactory = (IntelligentMobilityFactory)EPackage.Registry.INSTANCE.getEFactory(IntelligentMobilityPackage.eNS_URI);
			if (theIntelligentMobilityFactory != null) {
				return theIntelligentMobilityFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new IntelligentMobilityFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntelligentMobilityFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case IntelligentMobilityPackage.MOBILITY_SYSTEM: return createMobilitySystem();
			case IntelligentMobilityPackage.DRIVER_PROFILE: return createDriver_Profile();
			case IntelligentMobilityPackage.VEHICLE_CONFIGURATION: return createVehicle_Configuration();
			case IntelligentMobilityPackage.ENVIRONMENT_BACKGROUND: return createEnvironment_Background();
			case IntelligentMobilityPackage.DRIVER_PREFERENCE: return createDriver_Preference();
			case IntelligentMobilityPackage.KNOWLEDGE_AND_SKILL: return createKnowledge_and_Skill();
			case IntelligentMobilityPackage.DRIVER_EMOTION: return createDriver_Emotion();
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR: return createDriving_Behaviour();
			case IntelligentMobilityPackage.NORMAL_BEHAVIOUR: return createNormal_Behaviour();
			case IntelligentMobilityPackage.FOLLOWING: return createFollowing();
			case IntelligentMobilityPackage.LANE_CHANGING: return createLaneChanging();
			case IntelligentMobilityPackage.ABNORMAL_BEHAVIOUR: return createAbnormal_Behaviour();
			case IntelligentMobilityPackage.FORWARD: return createForward();
			case IntelligentMobilityPackage.BACKWARD: return createBackward();
			case IntelligentMobilityPackage.TURN: return createTurn();
			case IntelligentMobilityPackage.GAP_ACCEPTANCE: return createGapAcceptance();
			case IntelligentMobilityPackage.ACTION: return createAction();
			case IntelligentMobilityPackage.PLATOON: return createPlatoon();
			case IntelligentMobilityPackage.NORMAL_VEHICLE: return createNormal_Vehicle();
			case IntelligentMobilityPackage.LEADING_VEHICLE: return createLeading_Vehicle();
			case IntelligentMobilityPackage.FOLLOWING_VEHICLE: return createFollowing_Vehicle();
			case IntelligentMobilityPackage.POSSIBLE_VEHICLE: return createPossibleVehicle();
			case IntelligentMobilityPackage.ENVIRONMENT_CONDITION: return createEnvironment_Condition();
			case IntelligentMobilityPackage.LANE_TYPE: return createLane_Type();
			case IntelligentMobilityPackage.REGULATION: return createRegulation();
			case IntelligentMobilityPackage.SAFETY_REQUIREMENT: return createSafety_Requirement();
			case IntelligentMobilityPackage.WEATHER: return createWeather();
			case IntelligentMobilityPackage.TRAFFIC_SITUATION: return createTraffic_Situation();
			case IntelligentMobilityPackage.SPECIAL_CONDITION: return createSpecial_Condition();
			case IntelligentMobilityPackage.COLLISION: return createCollision();
			case IntelligentMobilityPackage.INTERSECTION: return createIntersection();
			case IntelligentMobilityPackage.OBSTRUCTION: return createObstruction();
			case IntelligentMobilityPackage.TRAFFIC_LIGHT: return createTraffic_Light();
			case IntelligentMobilityPackage.EXCEPTION_CONDITION: return createExceptionCondition();
			case IntelligentMobilityPackage.LINK_DRIVER_ENVIRONMENT: return createLink_Driver_Environment();
			case IntelligentMobilityPackage.LINK_DRIVER_VEHICLE: return createLink_Driver_Vehicle();
			case IntelligentMobilityPackage.LINK_VEHICLE_ENVIRONMENT: return createLink_Vehicle_Environment();
			case IntelligentMobilityPackage.LINK_DRIVER_PROFILE_DRIVER_PREFERENCE: return createLink_DriverProfile_DriverPreference();
			case IntelligentMobilityPackage.LINK_VEHICLE_CONFIGURATION_VEHICLE_TYPE: return createLink_VehicleConfiguration_VehicleType();
			case IntelligentMobilityPackage.LINK_ENVIRONMENT_BACKGROUND_POSSIBLE_VEHICLE: return createLink_EnvironmentBackground_PossibleVehicle();
			case IntelligentMobilityPackage.LINK_ENVIRONMENT_BACKGROUND_ENVIRONMENT_CONDITION: return createLink_EnvironmentBackground_EnvironmentCondition();
			case IntelligentMobilityPackage.LINK_DRIVER_PREFERENCE_DRIVER_EMOTION: return createLink_DriverPreference_DriverEmotion();
			case IntelligentMobilityPackage.LINK_DRIVER_PREFERENCE_DRIVING_BEHAVIOUR: return createLink_DriverPreference_DrivingBehaviour();
			case IntelligentMobilityPackage.LINK_DRIVER_PREFERENCE_ENVIRONMENT_CONDITION: return createLink_DriverPreference_EnvironmentCondition();
			case IntelligentMobilityPackage.LINK_DRIVING_BEHAVIOUR_NORMAL_BEHAVIOUR: return createLink_DrivingBehaviour_NormalBehaviour();
			case IntelligentMobilityPackage.LINK_NORMAL_BEHAVIOUR_FOLLOWING: return createLink_NormalBehaviour_Following();
			case IntelligentMobilityPackage.LINK_NORMAL_BEHAVIOUR_LANE_CHANGING: return createLink_NormalBehaviour_LaneChanging();
			case IntelligentMobilityPackage.LINK_FOLLOWING_MIN_GAP: return createLink_Following_MinGap();
			case IntelligentMobilityPackage.LINK_FOLLOWING_FORWARD: return createLink_Following_Forward();
			case IntelligentMobilityPackage.LINK_FOLLOWING_BACKWARD: return createLink_Following_Backward();
			case IntelligentMobilityPackage.LINK_LANE_CHANGING_TURN: return createLink_LaneChanging_Turn();
			case IntelligentMobilityPackage.LINK_LANE_CHANGING_GAP_ACCEPTANCE: return createLink_LaneChanging_GapAcceptance();
			case IntelligentMobilityPackage.LINK_LANE_CHANGING_ENVIRONMENT_CONDITION: return createLink_LaneChanging_EnvironmentCondition();
			case IntelligentMobilityPackage.LINK_ABNORMAL_BEHAVIOUR_ACTION: return createLink_AbnormalBehaviour_Action();
			case IntelligentMobilityPackage.LINK_PLATOON_LEADING_VEHICLE: return createLink_Platoon_LeadingVehicle();
			case IntelligentMobilityPackage.LINK_PLATOON_FOLLOWING_VEHICLE: return createLink_Platoon_FollowingVehicle();
			case IntelligentMobilityPackage.LINK_NORMAL_VEHICLE_SAFETY_REQUIREMENTS: return createLink_NormalVehicle_SafetyRequirements();
			case IntelligentMobilityPackage.LINK_FOLLOWING_VEHICLE_FRONT_VEHICLE: return createLink_FollowingVehicle_FrontVehicle();
			case IntelligentMobilityPackage.LINK_ENVIRONMENT_CONDITION_LANE_TYPE: return createLink_EnvironmentCondition_LaneType();
			case IntelligentMobilityPackage.LINK_ENVIRONMENT_CONDITION_REGULATIONS: return createLink_EnvironmentCondition_Regulations();
			case IntelligentMobilityPackage.LINK_ENVIRONMENT_CONDITION_WEATHER: return createLink_EnvironmentCondition_Weather();
			case IntelligentMobilityPackage.LINK_ENVIRONMENT_CONDITION_TRAFFIC_CONDITION: return createLink_EnvironmentCondition_TrafficCondition();
			case IntelligentMobilityPackage.LINK_ENVIRONMENT_CONDITION_SPECIAL_CONDITION: return createLink_EnvironmentCondition_SpecialCondition();
			case IntelligentMobilityPackage.LINK_LANE_TYPE_REGULATION: return createLink_LaneType_Regulation();
			case IntelligentMobilityPackage.LINK_SAFETY_REQUIREMENT_REGULATION: return createLink_SafetyRequirement_Regulation();
			case IntelligentMobilityPackage.LINK_SPECIAL_CONDITION_INTERSECTION: return createLink_SpecialCondition_Intersection();
			case IntelligentMobilityPackage.LINK_COLLISION_OBSTRUCTION: return createLink_Collision_Obstruction();
			case IntelligentMobilityPackage.LINK_INTERSECTION_TRAFFIC_LIGHT: return createLink_Intersection_TrafficLight();
			case IntelligentMobilityPackage.ROAD_SEGMENT: return createRoadSegment();
			case IntelligentMobilityPackage.SMART_SENSOR: return createSmartSensor();
			case IntelligentMobilityPackage.ROAD_SIDE_UNIT: return createRoad_Side_Unit();
			case IntelligentMobilityPackage.CHARGING_STATION: return createChargingStation();
			case IntelligentMobilityPackage.COMMUNICATION_INTERFACE: return createCommunicationInterface();
			case IntelligentMobilityPackage.COOPERATIVE_BEHAVIOR: return createCooperativeBehavior();
			case IntelligentMobilityPackage.GOAL: return createGoal();
			case IntelligentMobilityPackage.LINK_INFRASTRUCTURE_VEHICLE_CONFIGURATION: return createLink_Infrastructure_VehicleConfiguration();
			case IntelligentMobilityPackage.LINK_COMMUNICATION_INTERFACE_VEHICLE_CONFIGURATION: return createLink_CommunicationInterface_VehicleConfiguration();
			case IntelligentMobilityPackage.LINK_GOAL_DRIVING_BEHAVIOUR: return createLink_Goal_DrivingBehaviour();
			case IntelligentMobilityPackage.LINK_COOPERATIVE_BEHAVIOUR_COMMUNICATION_INTERFACE: return createLink_CooperativeBehaviour_CommunicationInterface();
			case IntelligentMobilityPackage.LINK_COMMUNICATION_INTERFACE_INFRASTRUCTURE: return createLink_CommunicationInterface_Infrastructure();
			case IntelligentMobilityPackage.LINK_COOPERATIVE_BEHAVIOUR_VEHICLE_CONFIGURATION: return createLink_CooperativeBehaviour_VehicleConfiguration();
			case IntelligentMobilityPackage.LINK_TRAFFIC_SITUATION_ENVIRONMENT_CONDITION: return createLink_TrafficSituation_EnvironmentCondition();
			case IntelligentMobilityPackage.LINK_FOLLOWING_LANE_CHANGING: return createLink_Following_LaneChanging();
			case IntelligentMobilityPackage.LINK_COLLISION_SPECIAL_CONDITION: return createLink_Collision_SpecialCondition();
			case IntelligentMobilityPackage.LINK_ACTION_BACKWARD: return createLink_Action_Backward();
			case IntelligentMobilityPackage.LINK_ACTION_FORWARD: return createLink_Action_Forward();
			case IntelligentMobilityPackage.LINK_ACTION_TURN: return createLink_Action_Turn();
			case IntelligentMobilityPackage.LINK_KNOWLEDGE_AND_SKILL_DRIVER_PREFERENCE: return createLink_KnowledgeAndSkill_DriverPreference();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case IntelligentMobilityPackage.DRIVER_TYPE:
				return createDriverTypeFromString(eDataType, initialValue);
			case IntelligentMobilityPackage.LANES:
				return createLanesFromString(eDataType, initialValue);
			case IntelligentMobilityPackage.DIRECTION:
				return createDirectionFromString(eDataType, initialValue);
			case IntelligentMobilityPackage.CAR_TYPE:
				return createCarTypeFromString(eDataType, initialValue);
			case IntelligentMobilityPackage.ROAD_SHAPE:
				return createRoadShapeFromString(eDataType, initialValue);
			case IntelligentMobilityPackage.ROAD_TYPE:
				return createRoadTypeFromString(eDataType, initialValue);
			case IntelligentMobilityPackage.TRAFFIC_TYPE:
				return createTrafficTypeFromString(eDataType, initialValue);
			case IntelligentMobilityPackage.PROTOCOL_TYPE:
				return createProtocolTypeFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case IntelligentMobilityPackage.DRIVER_TYPE:
				return convertDriverTypeToString(eDataType, instanceValue);
			case IntelligentMobilityPackage.LANES:
				return convertLanesToString(eDataType, instanceValue);
			case IntelligentMobilityPackage.DIRECTION:
				return convertDirectionToString(eDataType, instanceValue);
			case IntelligentMobilityPackage.CAR_TYPE:
				return convertCarTypeToString(eDataType, instanceValue);
			case IntelligentMobilityPackage.ROAD_SHAPE:
				return convertRoadShapeToString(eDataType, instanceValue);
			case IntelligentMobilityPackage.ROAD_TYPE:
				return convertRoadTypeToString(eDataType, instanceValue);
			case IntelligentMobilityPackage.TRAFFIC_TYPE:
				return convertTrafficTypeToString(eDataType, instanceValue);
			case IntelligentMobilityPackage.PROTOCOL_TYPE:
				return convertProtocolTypeToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MobilitySystem createMobilitySystem() {
		MobilitySystemImpl mobilitySystem = new MobilitySystemImpl();
		return mobilitySystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Driver_Profile createDriver_Profile() {
		Driver_ProfileImpl driver_Profile = new Driver_ProfileImpl();
		return driver_Profile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Vehicle_Configuration createVehicle_Configuration() {
		Vehicle_ConfigurationImpl vehicle_Configuration = new Vehicle_ConfigurationImpl();
		return vehicle_Configuration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Environment_Background createEnvironment_Background() {
		Environment_BackgroundImpl environment_Background = new Environment_BackgroundImpl();
		return environment_Background;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Driver_Preference createDriver_Preference() {
		Driver_PreferenceImpl driver_Preference = new Driver_PreferenceImpl();
		return driver_Preference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Knowledge_and_Skill createKnowledge_and_Skill() {
		Knowledge_and_SkillImpl knowledge_and_Skill = new Knowledge_and_SkillImpl();
		return knowledge_and_Skill;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Driver_Emotion createDriver_Emotion() {
		Driver_EmotionImpl driver_Emotion = new Driver_EmotionImpl();
		return driver_Emotion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Driving_Behaviour createDriving_Behaviour() {
		Driving_BehaviourImpl driving_Behaviour = new Driving_BehaviourImpl();
		return driving_Behaviour;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Normal_Behaviour createNormal_Behaviour() {
		Normal_BehaviourImpl normal_Behaviour = new Normal_BehaviourImpl();
		return normal_Behaviour;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Following createFollowing() {
		FollowingImpl following = new FollowingImpl();
		return following;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LaneChanging createLaneChanging() {
		LaneChangingImpl laneChanging = new LaneChangingImpl();
		return laneChanging;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Abnormal_Behaviour createAbnormal_Behaviour() {
		Abnormal_BehaviourImpl abnormal_Behaviour = new Abnormal_BehaviourImpl();
		return abnormal_Behaviour;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Forward createForward() {
		ForwardImpl forward = new ForwardImpl();
		return forward;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Backward createBackward() {
		BackwardImpl backward = new BackwardImpl();
		return backward;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Turn createTurn() {
		TurnImpl turn = new TurnImpl();
		return turn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GapAcceptance createGapAcceptance() {
		GapAcceptanceImpl gapAcceptance = new GapAcceptanceImpl();
		return gapAcceptance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Action createAction() {
		ActionImpl action = new ActionImpl();
		return action;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Platoon createPlatoon() {
		PlatoonImpl platoon = new PlatoonImpl();
		return platoon;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Normal_Vehicle createNormal_Vehicle() {
		Normal_VehicleImpl normal_Vehicle = new Normal_VehicleImpl();
		return normal_Vehicle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Leading_Vehicle createLeading_Vehicle() {
		Leading_VehicleImpl leading_Vehicle = new Leading_VehicleImpl();
		return leading_Vehicle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Following_Vehicle createFollowing_Vehicle() {
		Following_VehicleImpl following_Vehicle = new Following_VehicleImpl();
		return following_Vehicle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PossibleVehicle createPossibleVehicle() {
		PossibleVehicleImpl possibleVehicle = new PossibleVehicleImpl();
		return possibleVehicle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Environment_Condition createEnvironment_Condition() {
		Environment_ConditionImpl environment_Condition = new Environment_ConditionImpl();
		return environment_Condition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Lane_Type createLane_Type() {
		Lane_TypeImpl lane_Type = new Lane_TypeImpl();
		return lane_Type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Regulation createRegulation() {
		RegulationImpl regulation = new RegulationImpl();
		return regulation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Safety_Requirement createSafety_Requirement() {
		Safety_RequirementImpl safety_Requirement = new Safety_RequirementImpl();
		return safety_Requirement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Weather createWeather() {
		WeatherImpl weather = new WeatherImpl();
		return weather;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Traffic_Situation createTraffic_Situation() {
		Traffic_SituationImpl traffic_Situation = new Traffic_SituationImpl();
		return traffic_Situation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Special_Condition createSpecial_Condition() {
		Special_ConditionImpl special_Condition = new Special_ConditionImpl();
		return special_Condition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Collision createCollision() {
		CollisionImpl collision = new CollisionImpl();
		return collision;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Intersection createIntersection() {
		IntersectionImpl intersection = new IntersectionImpl();
		return intersection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Obstruction createObstruction() {
		ObstructionImpl obstruction = new ObstructionImpl();
		return obstruction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Traffic_Light createTraffic_Light() {
		Traffic_LightImpl traffic_Light = new Traffic_LightImpl();
		return traffic_Light;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExceptionCondition createExceptionCondition() {
		ExceptionConditionImpl exceptionCondition = new ExceptionConditionImpl();
		return exceptionCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Link_Driver_Environment createLink_Driver_Environment() {
		Link_Driver_EnvironmentImpl link_Driver_Environment = new Link_Driver_EnvironmentImpl();
		return link_Driver_Environment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Link_Driver_Vehicle createLink_Driver_Vehicle() {
		Link_Driver_VehicleImpl link_Driver_Vehicle = new Link_Driver_VehicleImpl();
		return link_Driver_Vehicle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Link_Vehicle_Environment createLink_Vehicle_Environment() {
		Link_Vehicle_EnvironmentImpl link_Vehicle_Environment = new Link_Vehicle_EnvironmentImpl();
		return link_Vehicle_Environment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Link_DriverProfile_DriverPreference createLink_DriverProfile_DriverPreference() {
		Link_DriverProfile_DriverPreferenceImpl link_DriverProfile_DriverPreference = new Link_DriverProfile_DriverPreferenceImpl();
		return link_DriverProfile_DriverPreference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Link_VehicleConfiguration_VehicleType createLink_VehicleConfiguration_VehicleType() {
		Link_VehicleConfiguration_VehicleTypeImpl link_VehicleConfiguration_VehicleType = new Link_VehicleConfiguration_VehicleTypeImpl();
		return link_VehicleConfiguration_VehicleType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Link_EnvironmentBackground_PossibleVehicle createLink_EnvironmentBackground_PossibleVehicle() {
		Link_EnvironmentBackground_PossibleVehicleImpl link_EnvironmentBackground_PossibleVehicle = new Link_EnvironmentBackground_PossibleVehicleImpl();
		return link_EnvironmentBackground_PossibleVehicle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Link_EnvironmentBackground_EnvironmentCondition createLink_EnvironmentBackground_EnvironmentCondition() {
		Link_EnvironmentBackground_EnvironmentConditionImpl link_EnvironmentBackground_EnvironmentCondition = new Link_EnvironmentBackground_EnvironmentConditionImpl();
		return link_EnvironmentBackground_EnvironmentCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Link_DriverPreference_DriverEmotion createLink_DriverPreference_DriverEmotion() {
		Link_DriverPreference_DriverEmotionImpl link_DriverPreference_DriverEmotion = new Link_DriverPreference_DriverEmotionImpl();
		return link_DriverPreference_DriverEmotion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Link_DriverPreference_DrivingBehaviour createLink_DriverPreference_DrivingBehaviour() {
		Link_DriverPreference_DrivingBehaviourImpl link_DriverPreference_DrivingBehaviour = new Link_DriverPreference_DrivingBehaviourImpl();
		return link_DriverPreference_DrivingBehaviour;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Link_DriverPreference_EnvironmentCondition createLink_DriverPreference_EnvironmentCondition() {
		Link_DriverPreference_EnvironmentConditionImpl link_DriverPreference_EnvironmentCondition = new Link_DriverPreference_EnvironmentConditionImpl();
		return link_DriverPreference_EnvironmentCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Link_DrivingBehaviour_NormalBehaviour createLink_DrivingBehaviour_NormalBehaviour() {
		Link_DrivingBehaviour_NormalBehaviourImpl link_DrivingBehaviour_NormalBehaviour = new Link_DrivingBehaviour_NormalBehaviourImpl();
		return link_DrivingBehaviour_NormalBehaviour;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Link_NormalBehaviour_Following createLink_NormalBehaviour_Following() {
		Link_NormalBehaviour_FollowingImpl link_NormalBehaviour_Following = new Link_NormalBehaviour_FollowingImpl();
		return link_NormalBehaviour_Following;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Link_NormalBehaviour_LaneChanging createLink_NormalBehaviour_LaneChanging() {
		Link_NormalBehaviour_LaneChangingImpl link_NormalBehaviour_LaneChanging = new Link_NormalBehaviour_LaneChangingImpl();
		return link_NormalBehaviour_LaneChanging;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Link_Following_MinGap createLink_Following_MinGap() {
		Link_Following_MinGapImpl link_Following_MinGap = new Link_Following_MinGapImpl();
		return link_Following_MinGap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Link_Following_Forward createLink_Following_Forward() {
		Link_Following_ForwardImpl link_Following_Forward = new Link_Following_ForwardImpl();
		return link_Following_Forward;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Link_Following_Backward createLink_Following_Backward() {
		Link_Following_BackwardImpl link_Following_Backward = new Link_Following_BackwardImpl();
		return link_Following_Backward;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Link_LaneChanging_Turn createLink_LaneChanging_Turn() {
		Link_LaneChanging_TurnImpl link_LaneChanging_Turn = new Link_LaneChanging_TurnImpl();
		return link_LaneChanging_Turn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Link_LaneChanging_GapAcceptance createLink_LaneChanging_GapAcceptance() {
		Link_LaneChanging_GapAcceptanceImpl link_LaneChanging_GapAcceptance = new Link_LaneChanging_GapAcceptanceImpl();
		return link_LaneChanging_GapAcceptance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Link_LaneChanging_EnvironmentCondition createLink_LaneChanging_EnvironmentCondition() {
		Link_LaneChanging_EnvironmentConditionImpl link_LaneChanging_EnvironmentCondition = new Link_LaneChanging_EnvironmentConditionImpl();
		return link_LaneChanging_EnvironmentCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Link_AbnormalBehaviour_Action createLink_AbnormalBehaviour_Action() {
		Link_AbnormalBehaviour_ActionImpl link_AbnormalBehaviour_Action = new Link_AbnormalBehaviour_ActionImpl();
		return link_AbnormalBehaviour_Action;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Link_Platoon_LeadingVehicle createLink_Platoon_LeadingVehicle() {
		Link_Platoon_LeadingVehicleImpl link_Platoon_LeadingVehicle = new Link_Platoon_LeadingVehicleImpl();
		return link_Platoon_LeadingVehicle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Link_Platoon_FollowingVehicle createLink_Platoon_FollowingVehicle() {
		Link_Platoon_FollowingVehicleImpl link_Platoon_FollowingVehicle = new Link_Platoon_FollowingVehicleImpl();
		return link_Platoon_FollowingVehicle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Link_NormalVehicle_SafetyRequirements createLink_NormalVehicle_SafetyRequirements() {
		Link_NormalVehicle_SafetyRequirementsImpl link_NormalVehicle_SafetyRequirements = new Link_NormalVehicle_SafetyRequirementsImpl();
		return link_NormalVehicle_SafetyRequirements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Link_FollowingVehicle_FrontVehicle createLink_FollowingVehicle_FrontVehicle() {
		Link_FollowingVehicle_FrontVehicleImpl link_FollowingVehicle_FrontVehicle = new Link_FollowingVehicle_FrontVehicleImpl();
		return link_FollowingVehicle_FrontVehicle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Link_EnvironmentCondition_LaneType createLink_EnvironmentCondition_LaneType() {
		Link_EnvironmentCondition_LaneTypeImpl link_EnvironmentCondition_LaneType = new Link_EnvironmentCondition_LaneTypeImpl();
		return link_EnvironmentCondition_LaneType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Link_EnvironmentCondition_Regulations createLink_EnvironmentCondition_Regulations() {
		Link_EnvironmentCondition_RegulationsImpl link_EnvironmentCondition_Regulations = new Link_EnvironmentCondition_RegulationsImpl();
		return link_EnvironmentCondition_Regulations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Link_EnvironmentCondition_Weather createLink_EnvironmentCondition_Weather() {
		Link_EnvironmentCondition_WeatherImpl link_EnvironmentCondition_Weather = new Link_EnvironmentCondition_WeatherImpl();
		return link_EnvironmentCondition_Weather;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Link_EnvironmentCondition_TrafficCondition createLink_EnvironmentCondition_TrafficCondition() {
		Link_EnvironmentCondition_TrafficConditionImpl link_EnvironmentCondition_TrafficCondition = new Link_EnvironmentCondition_TrafficConditionImpl();
		return link_EnvironmentCondition_TrafficCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Link_EnvironmentCondition_SpecialCondition createLink_EnvironmentCondition_SpecialCondition() {
		Link_EnvironmentCondition_SpecialConditionImpl link_EnvironmentCondition_SpecialCondition = new Link_EnvironmentCondition_SpecialConditionImpl();
		return link_EnvironmentCondition_SpecialCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Link_LaneType_Regulation createLink_LaneType_Regulation() {
		Link_LaneType_RegulationImpl link_LaneType_Regulation = new Link_LaneType_RegulationImpl();
		return link_LaneType_Regulation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Link_SafetyRequirement_Regulation createLink_SafetyRequirement_Regulation() {
		Link_SafetyRequirement_RegulationImpl link_SafetyRequirement_Regulation = new Link_SafetyRequirement_RegulationImpl();
		return link_SafetyRequirement_Regulation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Link_SpecialCondition_Intersection createLink_SpecialCondition_Intersection() {
		Link_SpecialCondition_IntersectionImpl link_SpecialCondition_Intersection = new Link_SpecialCondition_IntersectionImpl();
		return link_SpecialCondition_Intersection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Link_Collision_Obstruction createLink_Collision_Obstruction() {
		Link_Collision_ObstructionImpl link_Collision_Obstruction = new Link_Collision_ObstructionImpl();
		return link_Collision_Obstruction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Link_Intersection_TrafficLight createLink_Intersection_TrafficLight() {
		Link_Intersection_TrafficLightImpl link_Intersection_TrafficLight = new Link_Intersection_TrafficLightImpl();
		return link_Intersection_TrafficLight;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RoadSegment createRoadSegment() {
		RoadSegmentImpl roadSegment = new RoadSegmentImpl();
		return roadSegment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SmartSensor createSmartSensor() {
		SmartSensorImpl smartSensor = new SmartSensorImpl();
		return smartSensor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Road_Side_Unit createRoad_Side_Unit() {
		Road_Side_UnitImpl road_Side_Unit = new Road_Side_UnitImpl();
		return road_Side_Unit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChargingStation createChargingStation() {
		ChargingStationImpl chargingStation = new ChargingStationImpl();
		return chargingStation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CommunicationInterface createCommunicationInterface() {
		CommunicationInterfaceImpl communicationInterface = new CommunicationInterfaceImpl();
		return communicationInterface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CooperativeBehavior createCooperativeBehavior() {
		CooperativeBehaviorImpl cooperativeBehavior = new CooperativeBehaviorImpl();
		return cooperativeBehavior;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Goal createGoal() {
		GoalImpl goal = new GoalImpl();
		return goal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Link_Infrastructure_VehicleConfiguration createLink_Infrastructure_VehicleConfiguration() {
		Link_Infrastructure_VehicleConfigurationImpl link_Infrastructure_VehicleConfiguration = new Link_Infrastructure_VehicleConfigurationImpl();
		return link_Infrastructure_VehicleConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Link_CommunicationInterface_VehicleConfiguration createLink_CommunicationInterface_VehicleConfiguration() {
		Link_CommunicationInterface_VehicleConfigurationImpl link_CommunicationInterface_VehicleConfiguration = new Link_CommunicationInterface_VehicleConfigurationImpl();
		return link_CommunicationInterface_VehicleConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Link_Goal_DrivingBehaviour createLink_Goal_DrivingBehaviour() {
		Link_Goal_DrivingBehaviourImpl link_Goal_DrivingBehaviour = new Link_Goal_DrivingBehaviourImpl();
		return link_Goal_DrivingBehaviour;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Link_CooperativeBehaviour_CommunicationInterface createLink_CooperativeBehaviour_CommunicationInterface() {
		Link_CooperativeBehaviour_CommunicationInterfaceImpl link_CooperativeBehaviour_CommunicationInterface = new Link_CooperativeBehaviour_CommunicationInterfaceImpl();
		return link_CooperativeBehaviour_CommunicationInterface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Link_CommunicationInterface_Infrastructure createLink_CommunicationInterface_Infrastructure() {
		Link_CommunicationInterface_InfrastructureImpl link_CommunicationInterface_Infrastructure = new Link_CommunicationInterface_InfrastructureImpl();
		return link_CommunicationInterface_Infrastructure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Link_CooperativeBehaviour_VehicleConfiguration createLink_CooperativeBehaviour_VehicleConfiguration() {
		Link_CooperativeBehaviour_VehicleConfigurationImpl link_CooperativeBehaviour_VehicleConfiguration = new Link_CooperativeBehaviour_VehicleConfigurationImpl();
		return link_CooperativeBehaviour_VehicleConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Link_TrafficSituation_EnvironmentCondition createLink_TrafficSituation_EnvironmentCondition() {
		Link_TrafficSituation_EnvironmentConditionImpl link_TrafficSituation_EnvironmentCondition = new Link_TrafficSituation_EnvironmentConditionImpl();
		return link_TrafficSituation_EnvironmentCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Link_Following_LaneChanging createLink_Following_LaneChanging() {
		Link_Following_LaneChangingImpl link_Following_LaneChanging = new Link_Following_LaneChangingImpl();
		return link_Following_LaneChanging;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Link_Collision_SpecialCondition createLink_Collision_SpecialCondition() {
		Link_Collision_SpecialConditionImpl link_Collision_SpecialCondition = new Link_Collision_SpecialConditionImpl();
		return link_Collision_SpecialCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Link_Action_Backward createLink_Action_Backward() {
		Link_Action_BackwardImpl link_Action_Backward = new Link_Action_BackwardImpl();
		return link_Action_Backward;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Link_Action_Forward createLink_Action_Forward() {
		Link_Action_ForwardImpl link_Action_Forward = new Link_Action_ForwardImpl();
		return link_Action_Forward;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Link_Action_Turn createLink_Action_Turn() {
		Link_Action_TurnImpl link_Action_Turn = new Link_Action_TurnImpl();
		return link_Action_Turn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Link_KnowledgeAndSkill_DriverPreference createLink_KnowledgeAndSkill_DriverPreference() {
		Link_KnowledgeAndSkill_DriverPreferenceImpl link_KnowledgeAndSkill_DriverPreference = new Link_KnowledgeAndSkill_DriverPreferenceImpl();
		return link_KnowledgeAndSkill_DriverPreference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DriverType createDriverTypeFromString(EDataType eDataType, String initialValue) {
		DriverType result = DriverType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDriverTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Lanes createLanesFromString(EDataType eDataType, String initialValue) {
		Lanes result = Lanes.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLanesToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Direction createDirectionFromString(EDataType eDataType, String initialValue) {
		Direction result = Direction.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDirectionToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CarType createCarTypeFromString(EDataType eDataType, String initialValue) {
		CarType result = CarType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCarTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RoadShape createRoadShapeFromString(EDataType eDataType, String initialValue) {
		RoadShape result = RoadShape.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRoadShapeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RoadType createRoadTypeFromString(EDataType eDataType, String initialValue) {
		RoadType result = RoadType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRoadTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TrafficType createTrafficTypeFromString(EDataType eDataType, String initialValue) {
		TrafficType result = TrafficType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTrafficTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProtocolType createProtocolTypeFromString(EDataType eDataType, String initialValue) {
		ProtocolType result = ProtocolType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertProtocolTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntelligentMobilityPackage getIntelligentMobilityPackage() {
		return (IntelligentMobilityPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	public static IntelligentMobilityPackage getPackage() {
		return IntelligentMobilityPackage.eINSTANCE;
	}

} //IntelligentMobilityFactoryImpl
