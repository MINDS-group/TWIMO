/**
 */
package intelligentMobility.impl;

import intelligentMobility.Abnormal_Behaviour;
import intelligentMobility.Action;
import intelligentMobility.Backward;
import intelligentMobility.Collision;
import intelligentMobility.CommunicationInterface;
import intelligentMobility.CooperativeBehavior;
import intelligentMobility.Driver_Emotion;
import intelligentMobility.Driver_Preference;
import intelligentMobility.Driver_Profile;
import intelligentMobility.Driving_Behaviour;
import intelligentMobility.Environment_Background;
import intelligentMobility.Environment_Condition;
import intelligentMobility.ExceptionCondition;
import intelligentMobility.Following;
import intelligentMobility.Following_Vehicle;
import intelligentMobility.Forward;
import intelligentMobility.GapAcceptance;
import intelligentMobility.Goal;
import intelligentMobility.Infrastructure;
import intelligentMobility.IntelligentMobilityPackage;
import intelligentMobility.Intersection;
import intelligentMobility.Knowledge_and_Skill;
import intelligentMobility.LaneChanging;
import intelligentMobility.Lane_Type;
import intelligentMobility.Leading_Vehicle;
import intelligentMobility.Link_AbnormalBehaviour_Action;
import intelligentMobility.Link_Action_Backward;
import intelligentMobility.Link_Action_Forward;
import intelligentMobility.Link_Action_Turn;
import intelligentMobility.Link_Collision_Obstruction;
import intelligentMobility.Link_Collision_SpecialCondition;
import intelligentMobility.Link_CommunicationInterface_Infrastructure;
import intelligentMobility.Link_CommunicationInterface_VehicleConfiguration;
import intelligentMobility.Link_CooperativeBehaviour_CommunicationInterface;
import intelligentMobility.Link_CooperativeBehaviour_VehicleConfiguration;
import intelligentMobility.Link_DriverPreference_DriverEmotion;
import intelligentMobility.Link_DriverPreference_DrivingBehaviour;
import intelligentMobility.Link_DriverPreference_EnvironmentCondition;
import intelligentMobility.Link_DriverProfile_DriverPreference;
import intelligentMobility.Link_Driver_Environment;
import intelligentMobility.Link_Driver_Vehicle;
import intelligentMobility.Link_DrivingBehaviour_NormalBehaviour;
import intelligentMobility.Link_EnvironmentBackground_EnvironmentCondition;
import intelligentMobility.Link_EnvironmentBackground_PossibleVehicle;
import intelligentMobility.Link_EnvironmentCondition_LaneType;
import intelligentMobility.Link_EnvironmentCondition_Regulations;
import intelligentMobility.Link_EnvironmentCondition_SpecialCondition;
import intelligentMobility.Link_EnvironmentCondition_TrafficCondition;
import intelligentMobility.Link_EnvironmentCondition_Weather;
import intelligentMobility.Link_FollowingVehicle_FrontVehicle;
import intelligentMobility.Link_Following_Backward;
import intelligentMobility.Link_Following_Forward;
import intelligentMobility.Link_Following_LaneChanging;
import intelligentMobility.Link_Following_MinGap;
import intelligentMobility.Link_Goal_DrivingBehaviour;
import intelligentMobility.Link_Infrastructure_VehicleConfiguration;
import intelligentMobility.Link_Intersection_TrafficLight;
import intelligentMobility.Link_KnowledgeAndSkill_DriverPreference;
import intelligentMobility.Link_LaneChanging_EnvironmentCondition;
import intelligentMobility.Link_LaneChanging_GapAcceptance;
import intelligentMobility.Link_LaneChanging_Turn;
import intelligentMobility.Link_LaneType_Regulation;
import intelligentMobility.Link_NormalBehaviour_Following;
import intelligentMobility.Link_NormalBehaviour_LaneChanging;
import intelligentMobility.Link_NormalVehicle_SafetyRequirements;
import intelligentMobility.Link_Platoon_FollowingVehicle;
import intelligentMobility.Link_Platoon_LeadingVehicle;
import intelligentMobility.Link_SafetyRequirement_Regulation;
import intelligentMobility.Link_SpecialCondition_Intersection;
import intelligentMobility.Link_TrafficSituation_EnvironmentCondition;
import intelligentMobility.Link_VehicleConfiguration_VehicleType;
import intelligentMobility.Link_Vehicle_Environment;
import intelligentMobility.MobilitySystem;
import intelligentMobility.Normal_Behaviour;
import intelligentMobility.Normal_Vehicle;
import intelligentMobility.Obstruction;
import intelligentMobility.Platoon;
import intelligentMobility.PlatoonMember;
import intelligentMobility.PossibleVehicle;
import intelligentMobility.Regulation;
import intelligentMobility.Safety_Requirement;
import intelligentMobility.Special_Condition;
import intelligentMobility.Traffic_Light;
import intelligentMobility.Traffic_Situation;
import intelligentMobility.Turn;
import intelligentMobility.Vehicle_Configuration;
import intelligentMobility.Vehicle_Type;
import intelligentMobility.Weather;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mobility System</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.impl.MobilitySystemImpl#getDriver_profile <em>Driver profile</em>}</li>
 *   <li>{@link intelligentMobility.impl.MobilitySystemImpl#getVehicle_configuration <em>Vehicle configuration</em>}</li>
 *   <li>{@link intelligentMobility.impl.MobilitySystemImpl#getEnvironment_background <em>Environment background</em>}</li>
 *   <li>{@link intelligentMobility.impl.MobilitySystemImpl#getDriver_preference <em>Driver preference</em>}</li>
 *   <li>{@link intelligentMobility.impl.MobilitySystemImpl#getKnowledge_and_skill <em>Knowledge and skill</em>}</li>
 *   <li>{@link intelligentMobility.impl.MobilitySystemImpl#getDriver_emotion <em>Driver emotion</em>}</li>
 *   <li>{@link intelligentMobility.impl.MobilitySystemImpl#getDriving_behaviour <em>Driving behaviour</em>}</li>
 *   <li>{@link intelligentMobility.impl.MobilitySystemImpl#getNormal_behaviour <em>Normal behaviour</em>}</li>
 *   <li>{@link intelligentMobility.impl.MobilitySystemImpl#getFollowing <em>Following</em>}</li>
 *   <li>{@link intelligentMobility.impl.MobilitySystemImpl#getLane_changing <em>Lane changing</em>}</li>
 *   <li>{@link intelligentMobility.impl.MobilitySystemImpl#getAbnormal_behaviour <em>Abnormal behaviour</em>}</li>
 *   <li>{@link intelligentMobility.impl.MobilitySystemImpl#getForward <em>Forward</em>}</li>
 *   <li>{@link intelligentMobility.impl.MobilitySystemImpl#getBackward <em>Backward</em>}</li>
 *   <li>{@link intelligentMobility.impl.MobilitySystemImpl#getTurn <em>Turn</em>}</li>
 *   <li>{@link intelligentMobility.impl.MobilitySystemImpl#getGap_acceptance <em>Gap acceptance</em>}</li>
 *   <li>{@link intelligentMobility.impl.MobilitySystemImpl#getAction <em>Action</em>}</li>
 *   <li>{@link intelligentMobility.impl.MobilitySystemImpl#getVehicle_type <em>Vehicle type</em>}</li>
 *   <li>{@link intelligentMobility.impl.MobilitySystemImpl#getPlatoon <em>Platoon</em>}</li>
 *   <li>{@link intelligentMobility.impl.MobilitySystemImpl#getNormal_vehicle <em>Normal vehicle</em>}</li>
 *   <li>{@link intelligentMobility.impl.MobilitySystemImpl#getLeading_vehicle <em>Leading vehicle</em>}</li>
 *   <li>{@link intelligentMobility.impl.MobilitySystemImpl#getFollowing_vehicle <em>Following vehicle</em>}</li>
 *   <li>{@link intelligentMobility.impl.MobilitySystemImpl#getPlatoon_member <em>Platoon member</em>}</li>
 *   <li>{@link intelligentMobility.impl.MobilitySystemImpl#getPossible_vehicle <em>Possible vehicle</em>}</li>
 *   <li>{@link intelligentMobility.impl.MobilitySystemImpl#getEnvironment_condition <em>Environment condition</em>}</li>
 *   <li>{@link intelligentMobility.impl.MobilitySystemImpl#getLane_type <em>Lane type</em>}</li>
 *   <li>{@link intelligentMobility.impl.MobilitySystemImpl#getRegulation <em>Regulation</em>}</li>
 *   <li>{@link intelligentMobility.impl.MobilitySystemImpl#getSafety_requirement <em>Safety requirement</em>}</li>
 *   <li>{@link intelligentMobility.impl.MobilitySystemImpl#getWeather <em>Weather</em>}</li>
 *   <li>{@link intelligentMobility.impl.MobilitySystemImpl#getTraffic_situation <em>Traffic situation</em>}</li>
 *   <li>{@link intelligentMobility.impl.MobilitySystemImpl#getSpecial_condition <em>Special condition</em>}</li>
 *   <li>{@link intelligentMobility.impl.MobilitySystemImpl#getCollision <em>Collision</em>}</li>
 *   <li>{@link intelligentMobility.impl.MobilitySystemImpl#getIntersection <em>Intersection</em>}</li>
 *   <li>{@link intelligentMobility.impl.MobilitySystemImpl#getObstruction <em>Obstruction</em>}</li>
 *   <li>{@link intelligentMobility.impl.MobilitySystemImpl#getTraffic_light <em>Traffic light</em>}</li>
 *   <li>{@link intelligentMobility.impl.MobilitySystemImpl#getExecption_condition <em>Execption condition</em>}</li>
 *   <li>{@link intelligentMobility.impl.MobilitySystemImpl#getLink_driver_vehicle <em>Link driver vehicle</em>}</li>
 *   <li>{@link intelligentMobility.impl.MobilitySystemImpl#getLink_driver_environment <em>Link driver environment</em>}</li>
 *   <li>{@link intelligentMobility.impl.MobilitySystemImpl#getLink_vehicle_environment <em>Link vehicle environment</em>}</li>
 *   <li>{@link intelligentMobility.impl.MobilitySystemImpl#getLink_driverProfile_driverPreference <em>Link driver Profile driver Preference</em>}</li>
 *   <li>{@link intelligentMobility.impl.MobilitySystemImpl#getLink_vehicleConfiguration_vehicleType <em>Link vehicle Configuration vehicle Type</em>}</li>
 *   <li>{@link intelligentMobility.impl.MobilitySystemImpl#getLink_environmentBackground_possibleVehicle <em>Link environment Background possible Vehicle</em>}</li>
 *   <li>{@link intelligentMobility.impl.MobilitySystemImpl#getLink_environmentBackground_environmentCondition <em>Link environment Background environment Condition</em>}</li>
 *   <li>{@link intelligentMobility.impl.MobilitySystemImpl#getLink_driverPreference_driverEmotion <em>Link driver Preference driver Emotion</em>}</li>
 *   <li>{@link intelligentMobility.impl.MobilitySystemImpl#getLink_driverPreference_drivingBehaviour <em>Link driver Preference driving Behaviour</em>}</li>
 *   <li>{@link intelligentMobility.impl.MobilitySystemImpl#getLink_driverPreference_environmentCondition <em>Link driver Preference environment Condition</em>}</li>
 *   <li>{@link intelligentMobility.impl.MobilitySystemImpl#getLink_drivingBehaviour_normalBehaviour <em>Link driving Behaviour normal Behaviour</em>}</li>
 *   <li>{@link intelligentMobility.impl.MobilitySystemImpl#getLink_normalBehaviour_following <em>Link normal Behaviour following</em>}</li>
 *   <li>{@link intelligentMobility.impl.MobilitySystemImpl#getLink_normalBehaviour_laneChanging <em>Link normal Behaviour lane Changing</em>}</li>
 *   <li>{@link intelligentMobility.impl.MobilitySystemImpl#getLink_following_minGap <em>Link following min Gap</em>}</li>
 *   <li>{@link intelligentMobility.impl.MobilitySystemImpl#getLink_following_forward <em>Link following forward</em>}</li>
 *   <li>{@link intelligentMobility.impl.MobilitySystemImpl#getLink_following_backward <em>Link following backward</em>}</li>
 *   <li>{@link intelligentMobility.impl.MobilitySystemImpl#getLink_laneChanging_turn <em>Link lane Changing turn</em>}</li>
 *   <li>{@link intelligentMobility.impl.MobilitySystemImpl#getLink_laneChanging_gapAcceptance <em>Link lane Changing gap Acceptance</em>}</li>
 *   <li>{@link intelligentMobility.impl.MobilitySystemImpl#getLink_laneChanging_environmentCondition <em>Link lane Changing environment Condition</em>}</li>
 *   <li>{@link intelligentMobility.impl.MobilitySystemImpl#getLink_abnormalBehaviour_action <em>Link abnormal Behaviour action</em>}</li>
 *   <li>{@link intelligentMobility.impl.MobilitySystemImpl#getLink_platoon_leadingVehicle <em>Link platoon leading Vehicle</em>}</li>
 *   <li>{@link intelligentMobility.impl.MobilitySystemImpl#getLink_platoon_followingVehicle <em>Link platoon following Vehicle</em>}</li>
 *   <li>{@link intelligentMobility.impl.MobilitySystemImpl#getLink_normalVehicle_safetyRequirement <em>Link normal Vehicle safety Requirement</em>}</li>
 *   <li>{@link intelligentMobility.impl.MobilitySystemImpl#getLink_followingVehicle_frontVehicle <em>Link following Vehicle front Vehicle</em>}</li>
 *   <li>{@link intelligentMobility.impl.MobilitySystemImpl#getLink_environmentCondition_laneType <em>Link environment Condition lane Type</em>}</li>
 *   <li>{@link intelligentMobility.impl.MobilitySystemImpl#getLink_environmentCondition_regulation <em>Link environment Condition regulation</em>}</li>
 *   <li>{@link intelligentMobility.impl.MobilitySystemImpl#getLink_environmentCondition_weather <em>Link environment Condition weather</em>}</li>
 *   <li>{@link intelligentMobility.impl.MobilitySystemImpl#getLink_environmentCondition_trafficCondition <em>Link environment Condition traffic Condition</em>}</li>
 *   <li>{@link intelligentMobility.impl.MobilitySystemImpl#getLink_environmentCondition_specialCondition <em>Link environment Condition special Condition</em>}</li>
 *   <li>{@link intelligentMobility.impl.MobilitySystemImpl#getLink_laneType_regulation <em>Link lane Type regulation</em>}</li>
 *   <li>{@link intelligentMobility.impl.MobilitySystemImpl#getLink_safetyRequirement_regulation <em>Link safety Requirement regulation</em>}</li>
 *   <li>{@link intelligentMobility.impl.MobilitySystemImpl#getLink_specialCondition_intersection <em>Link special Condition intersection</em>}</li>
 *   <li>{@link intelligentMobility.impl.MobilitySystemImpl#getLink_collision_obstruction <em>Link collision obstruction</em>}</li>
 *   <li>{@link intelligentMobility.impl.MobilitySystemImpl#getLink_intersection_trafficLight <em>Link intersection traffic Light</em>}</li>
 *   <li>{@link intelligentMobility.impl.MobilitySystemImpl#getSystemID <em>System ID</em>}</li>
 *   <li>{@link intelligentMobility.impl.MobilitySystemImpl#getGeographicalScope <em>Geographical Scope</em>}</li>
 *   <li>{@link intelligentMobility.impl.MobilitySystemImpl#getInfrastructureType <em>Infrastructure Type</em>}</li>
 *   <li>{@link intelligentMobility.impl.MobilitySystemImpl#getInfrastructure <em>Infrastructure</em>}</li>
 *   <li>{@link intelligentMobility.impl.MobilitySystemImpl#getCommunicationInterfaces <em>Communication Interfaces</em>}</li>
 *   <li>{@link intelligentMobility.impl.MobilitySystemImpl#getGoal <em>Goal</em>}</li>
 *   <li>{@link intelligentMobility.impl.MobilitySystemImpl#getLink_infrastructure_vehicle_configuration <em>Link infrastructure vehicle configuration</em>}</li>
 *   <li>{@link intelligentMobility.impl.MobilitySystemImpl#getLink_communicationInterface_vehicleConfiguration <em>Link communication Interface vehicle Configuration</em>}</li>
 *   <li>{@link intelligentMobility.impl.MobilitySystemImpl#getLink_communicationInterface_infrastructure <em>Link communication Interface infrastructure</em>}</li>
 *   <li>{@link intelligentMobility.impl.MobilitySystemImpl#getLink_goal_drivingBehaviour <em>Link goal driving Behaviour</em>}</li>
 *   <li>{@link intelligentMobility.impl.MobilitySystemImpl#getCooperativeBehaviour <em>Cooperative Behaviour</em>}</li>
 *   <li>{@link intelligentMobility.impl.MobilitySystemImpl#getLink_cooperativeBehaviour_communicationInterface <em>Link cooperative Behaviour communication Interface</em>}</li>
 *   <li>{@link intelligentMobility.impl.MobilitySystemImpl#getLink_cooperativeBehaviour_vehicleConfiguration <em>Link cooperative Behaviour vehicle Configuration</em>}</li>
 *   <li>{@link intelligentMobility.impl.MobilitySystemImpl#getLink_trafficSituation_environmentCondition <em>Link traffic Situation environment Condition</em>}</li>
 *   <li>{@link intelligentMobility.impl.MobilitySystemImpl#getLink_following_laneChanging <em>Link following lane Changing</em>}</li>
 *   <li>{@link intelligentMobility.impl.MobilitySystemImpl#getLink_collision_specialCondition <em>Link collision special Condition</em>}</li>
 *   <li>{@link intelligentMobility.impl.MobilitySystemImpl#getLink_action_backward <em>Link action backward</em>}</li>
 *   <li>{@link intelligentMobility.impl.MobilitySystemImpl#getLink_action_forward <em>Link action forward</em>}</li>
 *   <li>{@link intelligentMobility.impl.MobilitySystemImpl#getLink_action_turn <em>Link action turn</em>}</li>
 *   <li>{@link intelligentMobility.impl.MobilitySystemImpl#getLink_knowledgeAndSkill_driverPreference <em>Link knowledge And Skill driver Preference</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MobilitySystemImpl extends MinimalEObjectImpl.Container implements MobilitySystem {
	/**
	 * The cached value of the '{@link #getDriver_profile() <em>Driver profile</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDriver_profile()
	 * @generated
	 * @ordered
	 */
	protected EList driver_profile;

	/**
	 * The cached value of the '{@link #getVehicle_configuration() <em>Vehicle configuration</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVehicle_configuration()
	 * @generated
	 * @ordered
	 */
	protected EList vehicle_configuration;

	/**
	 * The cached value of the '{@link #getEnvironment_background() <em>Environment background</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnvironment_background()
	 * @generated
	 * @ordered
	 */
	protected EList environment_background;

	/**
	 * The cached value of the '{@link #getDriver_preference() <em>Driver preference</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDriver_preference()
	 * @generated
	 * @ordered
	 */
	protected EList driver_preference;

	/**
	 * The cached value of the '{@link #getKnowledge_and_skill() <em>Knowledge and skill</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKnowledge_and_skill()
	 * @generated
	 * @ordered
	 */
	protected EList knowledge_and_skill;

	/**
	 * The cached value of the '{@link #getDriver_emotion() <em>Driver emotion</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDriver_emotion()
	 * @generated
	 * @ordered
	 */
	protected EList driver_emotion;

	/**
	 * The cached value of the '{@link #getDriving_behaviour() <em>Driving behaviour</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDriving_behaviour()
	 * @generated
	 * @ordered
	 */
	protected EList driving_behaviour;

	/**
	 * The cached value of the '{@link #getNormal_behaviour() <em>Normal behaviour</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNormal_behaviour()
	 * @generated
	 * @ordered
	 */
	protected EList normal_behaviour;

	/**
	 * The cached value of the '{@link #getFollowing() <em>Following</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFollowing()
	 * @generated
	 * @ordered
	 */
	protected EList following;

	/**
	 * The cached value of the '{@link #getLane_changing() <em>Lane changing</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLane_changing()
	 * @generated
	 * @ordered
	 */
	protected EList lane_changing;

	/**
	 * The cached value of the '{@link #getAbnormal_behaviour() <em>Abnormal behaviour</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAbnormal_behaviour()
	 * @generated
	 * @ordered
	 */
	protected EList abnormal_behaviour;

	/**
	 * The cached value of the '{@link #getForward() <em>Forward</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getForward()
	 * @generated
	 * @ordered
	 */
	protected EList forward;

	/**
	 * The cached value of the '{@link #getBackward() <em>Backward</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBackward()
	 * @generated
	 * @ordered
	 */
	protected EList backward;

	/**
	 * The cached value of the '{@link #getTurn() <em>Turn</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTurn()
	 * @generated
	 * @ordered
	 */
	protected EList turn;

	/**
	 * The cached value of the '{@link #getGap_acceptance() <em>Gap acceptance</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGap_acceptance()
	 * @generated
	 * @ordered
	 */
	protected EList gap_acceptance;

	/**
	 * The cached value of the '{@link #getAction() <em>Action</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAction()
	 * @generated
	 * @ordered
	 */
	protected EList action;

	/**
	 * The cached value of the '{@link #getVehicle_type() <em>Vehicle type</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVehicle_type()
	 * @generated
	 * @ordered
	 */
	protected EList vehicle_type;

	/**
	 * The cached value of the '{@link #getPlatoon() <em>Platoon</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlatoon()
	 * @generated
	 * @ordered
	 */
	protected EList platoon;

	/**
	 * The cached value of the '{@link #getNormal_vehicle() <em>Normal vehicle</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNormal_vehicle()
	 * @generated
	 * @ordered
	 */
	protected EList normal_vehicle;

	/**
	 * The cached value of the '{@link #getLeading_vehicle() <em>Leading vehicle</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLeading_vehicle()
	 * @generated
	 * @ordered
	 */
	protected EList leading_vehicle;

	/**
	 * The cached value of the '{@link #getFollowing_vehicle() <em>Following vehicle</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFollowing_vehicle()
	 * @generated
	 * @ordered
	 */
	protected EList following_vehicle;

	/**
	 * The cached value of the '{@link #getPlatoon_member() <em>Platoon member</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlatoon_member()
	 * @generated
	 * @ordered
	 */
	protected EList platoon_member;

	/**
	 * The cached value of the '{@link #getPossible_vehicle() <em>Possible vehicle</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPossible_vehicle()
	 * @generated
	 * @ordered
	 */
	protected EList possible_vehicle;

	/**
	 * The cached value of the '{@link #getEnvironment_condition() <em>Environment condition</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnvironment_condition()
	 * @generated
	 * @ordered
	 */
	protected EList environment_condition;

	/**
	 * The cached value of the '{@link #getLane_type() <em>Lane type</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLane_type()
	 * @generated
	 * @ordered
	 */
	protected EList lane_type;

	/**
	 * The cached value of the '{@link #getRegulation() <em>Regulation</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRegulation()
	 * @generated
	 * @ordered
	 */
	protected EList regulation;

	/**
	 * The cached value of the '{@link #getSafety_requirement() <em>Safety requirement</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSafety_requirement()
	 * @generated
	 * @ordered
	 */
	protected EList safety_requirement;

	/**
	 * The cached value of the '{@link #getWeather() <em>Weather</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWeather()
	 * @generated
	 * @ordered
	 */
	protected EList weather;

	/**
	 * The cached value of the '{@link #getTraffic_situation() <em>Traffic situation</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTraffic_situation()
	 * @generated
	 * @ordered
	 */
	protected EList traffic_situation;

	/**
	 * The cached value of the '{@link #getSpecial_condition() <em>Special condition</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpecial_condition()
	 * @generated
	 * @ordered
	 */
	protected EList special_condition;

	/**
	 * The cached value of the '{@link #getCollision() <em>Collision</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCollision()
	 * @generated
	 * @ordered
	 */
	protected EList collision;

	/**
	 * The cached value of the '{@link #getIntersection() <em>Intersection</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntersection()
	 * @generated
	 * @ordered
	 */
	protected EList intersection;

	/**
	 * The cached value of the '{@link #getObstruction() <em>Obstruction</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObstruction()
	 * @generated
	 * @ordered
	 */
	protected EList obstruction;

	/**
	 * The cached value of the '{@link #getTraffic_light() <em>Traffic light</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTraffic_light()
	 * @generated
	 * @ordered
	 */
	protected EList traffic_light;

	/**
	 * The cached value of the '{@link #getExecption_condition() <em>Execption condition</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExecption_condition()
	 * @generated
	 * @ordered
	 */
	protected EList execption_condition;

	/**
	 * The cached value of the '{@link #getLink_driver_vehicle() <em>Link driver vehicle</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_driver_vehicle()
	 * @generated
	 * @ordered
	 */
	protected EList link_driver_vehicle;

	/**
	 * The cached value of the '{@link #getLink_driver_environment() <em>Link driver environment</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_driver_environment()
	 * @generated
	 * @ordered
	 */
	protected EList link_driver_environment;

	/**
	 * The cached value of the '{@link #getLink_vehicle_environment() <em>Link vehicle environment</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_vehicle_environment()
	 * @generated
	 * @ordered
	 */
	protected EList link_vehicle_environment;

	/**
	 * The cached value of the '{@link #getLink_driverProfile_driverPreference() <em>Link driver Profile driver Preference</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_driverProfile_driverPreference()
	 * @generated
	 * @ordered
	 */
	protected EList link_driverProfile_driverPreference;

	/**
	 * The cached value of the '{@link #getLink_vehicleConfiguration_vehicleType() <em>Link vehicle Configuration vehicle Type</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_vehicleConfiguration_vehicleType()
	 * @generated
	 * @ordered
	 */
	protected EList link_vehicleConfiguration_vehicleType;

	/**
	 * The cached value of the '{@link #getLink_environmentBackground_possibleVehicle() <em>Link environment Background possible Vehicle</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_environmentBackground_possibleVehicle()
	 * @generated
	 * @ordered
	 */
	protected EList link_environmentBackground_possibleVehicle;

	/**
	 * The cached value of the '{@link #getLink_environmentBackground_environmentCondition() <em>Link environment Background environment Condition</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_environmentBackground_environmentCondition()
	 * @generated
	 * @ordered
	 */
	protected EList link_environmentBackground_environmentCondition;

	/**
	 * The cached value of the '{@link #getLink_driverPreference_driverEmotion() <em>Link driver Preference driver Emotion</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_driverPreference_driverEmotion()
	 * @generated
	 * @ordered
	 */
	protected EList link_driverPreference_driverEmotion;

	/**
	 * The cached value of the '{@link #getLink_driverPreference_drivingBehaviour() <em>Link driver Preference driving Behaviour</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_driverPreference_drivingBehaviour()
	 * @generated
	 * @ordered
	 */
	protected EList link_driverPreference_drivingBehaviour;

	/**
	 * The cached value of the '{@link #getLink_driverPreference_environmentCondition() <em>Link driver Preference environment Condition</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_driverPreference_environmentCondition()
	 * @generated
	 * @ordered
	 */
	protected EList link_driverPreference_environmentCondition;

	/**
	 * The cached value of the '{@link #getLink_drivingBehaviour_normalBehaviour() <em>Link driving Behaviour normal Behaviour</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_drivingBehaviour_normalBehaviour()
	 * @generated
	 * @ordered
	 */
	protected EList link_drivingBehaviour_normalBehaviour;

	/**
	 * The cached value of the '{@link #getLink_normalBehaviour_following() <em>Link normal Behaviour following</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_normalBehaviour_following()
	 * @generated
	 * @ordered
	 */
	protected EList link_normalBehaviour_following;

	/**
	 * The cached value of the '{@link #getLink_normalBehaviour_laneChanging() <em>Link normal Behaviour lane Changing</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_normalBehaviour_laneChanging()
	 * @generated
	 * @ordered
	 */
	protected EList link_normalBehaviour_laneChanging;

	/**
	 * The cached value of the '{@link #getLink_following_minGap() <em>Link following min Gap</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_following_minGap()
	 * @generated
	 * @ordered
	 */
	protected EList link_following_minGap;

	/**
	 * The cached value of the '{@link #getLink_following_forward() <em>Link following forward</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_following_forward()
	 * @generated
	 * @ordered
	 */
	protected EList link_following_forward;

	/**
	 * The cached value of the '{@link #getLink_following_backward() <em>Link following backward</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_following_backward()
	 * @generated
	 * @ordered
	 */
	protected EList link_following_backward;

	/**
	 * The cached value of the '{@link #getLink_laneChanging_turn() <em>Link lane Changing turn</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_laneChanging_turn()
	 * @generated
	 * @ordered
	 */
	protected EList link_laneChanging_turn;

	/**
	 * The cached value of the '{@link #getLink_laneChanging_gapAcceptance() <em>Link lane Changing gap Acceptance</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_laneChanging_gapAcceptance()
	 * @generated
	 * @ordered
	 */
	protected EList link_laneChanging_gapAcceptance;

	/**
	 * The cached value of the '{@link #getLink_laneChanging_environmentCondition() <em>Link lane Changing environment Condition</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_laneChanging_environmentCondition()
	 * @generated
	 * @ordered
	 */
	protected EList link_laneChanging_environmentCondition;

	/**
	 * The cached value of the '{@link #getLink_abnormalBehaviour_action() <em>Link abnormal Behaviour action</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_abnormalBehaviour_action()
	 * @generated
	 * @ordered
	 */
	protected EList link_abnormalBehaviour_action;

	/**
	 * The cached value of the '{@link #getLink_platoon_leadingVehicle() <em>Link platoon leading Vehicle</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_platoon_leadingVehicle()
	 * @generated
	 * @ordered
	 */
	protected EList link_platoon_leadingVehicle;

	/**
	 * The cached value of the '{@link #getLink_platoon_followingVehicle() <em>Link platoon following Vehicle</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_platoon_followingVehicle()
	 * @generated
	 * @ordered
	 */
	protected EList link_platoon_followingVehicle;

	/**
	 * The cached value of the '{@link #getLink_normalVehicle_safetyRequirement() <em>Link normal Vehicle safety Requirement</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_normalVehicle_safetyRequirement()
	 * @generated
	 * @ordered
	 */
	protected EList link_normalVehicle_safetyRequirement;

	/**
	 * The cached value of the '{@link #getLink_followingVehicle_frontVehicle() <em>Link following Vehicle front Vehicle</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_followingVehicle_frontVehicle()
	 * @generated
	 * @ordered
	 */
	protected EList link_followingVehicle_frontVehicle;

	/**
	 * The cached value of the '{@link #getLink_environmentCondition_laneType() <em>Link environment Condition lane Type</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_environmentCondition_laneType()
	 * @generated
	 * @ordered
	 */
	protected EList link_environmentCondition_laneType;

	/**
	 * The cached value of the '{@link #getLink_environmentCondition_regulation() <em>Link environment Condition regulation</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_environmentCondition_regulation()
	 * @generated
	 * @ordered
	 */
	protected EList link_environmentCondition_regulation;

	/**
	 * The cached value of the '{@link #getLink_environmentCondition_weather() <em>Link environment Condition weather</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_environmentCondition_weather()
	 * @generated
	 * @ordered
	 */
	protected EList link_environmentCondition_weather;

	/**
	 * The cached value of the '{@link #getLink_environmentCondition_trafficCondition() <em>Link environment Condition traffic Condition</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_environmentCondition_trafficCondition()
	 * @generated
	 * @ordered
	 */
	protected EList link_environmentCondition_trafficCondition;

	/**
	 * The cached value of the '{@link #getLink_environmentCondition_specialCondition() <em>Link environment Condition special Condition</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_environmentCondition_specialCondition()
	 * @generated
	 * @ordered
	 */
	protected EList link_environmentCondition_specialCondition;

	/**
	 * The cached value of the '{@link #getLink_laneType_regulation() <em>Link lane Type regulation</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_laneType_regulation()
	 * @generated
	 * @ordered
	 */
	protected EList link_laneType_regulation;

	/**
	 * The cached value of the '{@link #getLink_safetyRequirement_regulation() <em>Link safety Requirement regulation</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_safetyRequirement_regulation()
	 * @generated
	 * @ordered
	 */
	protected EList link_safetyRequirement_regulation;

	/**
	 * The cached value of the '{@link #getLink_specialCondition_intersection() <em>Link special Condition intersection</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_specialCondition_intersection()
	 * @generated
	 * @ordered
	 */
	protected EList link_specialCondition_intersection;

	/**
	 * The cached value of the '{@link #getLink_collision_obstruction() <em>Link collision obstruction</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_collision_obstruction()
	 * @generated
	 * @ordered
	 */
	protected EList link_collision_obstruction;

	/**
	 * The cached value of the '{@link #getLink_intersection_trafficLight() <em>Link intersection traffic Light</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_intersection_trafficLight()
	 * @generated
	 * @ordered
	 */
	protected EList link_intersection_trafficLight;

	/**
	 * The default value of the '{@link #getSystemID() <em>System ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSystemID()
	 * @generated
	 * @ordered
	 */
	protected static final int SYSTEM_ID_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSystemID() <em>System ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSystemID()
	 * @generated
	 * @ordered
	 */
	protected int systemID = SYSTEM_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getGeographicalScope() <em>Geographical Scope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGeographicalScope()
	 * @generated
	 * @ordered
	 */
	protected static final String GEOGRAPHICAL_SCOPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getGeographicalScope() <em>Geographical Scope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGeographicalScope()
	 * @generated
	 * @ordered
	 */
	protected String geographicalScope = GEOGRAPHICAL_SCOPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getInfrastructureType() <em>Infrastructure Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInfrastructureType()
	 * @generated
	 * @ordered
	 */
	protected static final String INFRASTRUCTURE_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInfrastructureType() <em>Infrastructure Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInfrastructureType()
	 * @generated
	 * @ordered
	 */
	protected String infrastructureType = INFRASTRUCTURE_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getInfrastructure() <em>Infrastructure</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInfrastructure()
	 * @generated
	 * @ordered
	 */
	protected EList infrastructure;

	/**
	 * The cached value of the '{@link #getCommunicationInterfaces() <em>Communication Interfaces</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommunicationInterfaces()
	 * @generated
	 * @ordered
	 */
	protected EList communicationInterfaces;

	/**
	 * The cached value of the '{@link #getGoal() <em>Goal</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGoal()
	 * @generated
	 * @ordered
	 */
	protected EList goal;

	/**
	 * The cached value of the '{@link #getLink_infrastructure_vehicle_configuration() <em>Link infrastructure vehicle configuration</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_infrastructure_vehicle_configuration()
	 * @generated
	 * @ordered
	 */
	protected EList link_infrastructure_vehicle_configuration;

	/**
	 * The cached value of the '{@link #getLink_communicationInterface_vehicleConfiguration() <em>Link communication Interface vehicle Configuration</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_communicationInterface_vehicleConfiguration()
	 * @generated
	 * @ordered
	 */
	protected EList link_communicationInterface_vehicleConfiguration;

	/**
	 * The cached value of the '{@link #getLink_communicationInterface_infrastructure() <em>Link communication Interface infrastructure</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_communicationInterface_infrastructure()
	 * @generated
	 * @ordered
	 */
	protected EList link_communicationInterface_infrastructure;

	/**
	 * The cached value of the '{@link #getLink_goal_drivingBehaviour() <em>Link goal driving Behaviour</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_goal_drivingBehaviour()
	 * @generated
	 * @ordered
	 */
	protected EList link_goal_drivingBehaviour;

	/**
	 * The cached value of the '{@link #getCooperativeBehaviour() <em>Cooperative Behaviour</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCooperativeBehaviour()
	 * @generated
	 * @ordered
	 */
	protected EList cooperativeBehaviour;

	/**
	 * The cached value of the '{@link #getLink_cooperativeBehaviour_communicationInterface() <em>Link cooperative Behaviour communication Interface</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_cooperativeBehaviour_communicationInterface()
	 * @generated
	 * @ordered
	 */
	protected EList link_cooperativeBehaviour_communicationInterface;

	/**
	 * The cached value of the '{@link #getLink_cooperativeBehaviour_vehicleConfiguration() <em>Link cooperative Behaviour vehicle Configuration</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_cooperativeBehaviour_vehicleConfiguration()
	 * @generated
	 * @ordered
	 */
	protected EList link_cooperativeBehaviour_vehicleConfiguration;

	/**
	 * The cached value of the '{@link #getLink_trafficSituation_environmentCondition() <em>Link traffic Situation environment Condition</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_trafficSituation_environmentCondition()
	 * @generated
	 * @ordered
	 */
	protected EList link_trafficSituation_environmentCondition;

	/**
	 * The cached value of the '{@link #getLink_following_laneChanging() <em>Link following lane Changing</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_following_laneChanging()
	 * @generated
	 * @ordered
	 */
	protected EList link_following_laneChanging;

	/**
	 * The cached value of the '{@link #getLink_collision_specialCondition() <em>Link collision special Condition</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_collision_specialCondition()
	 * @generated
	 * @ordered
	 */
	protected EList link_collision_specialCondition;

	/**
	 * The cached value of the '{@link #getLink_action_backward() <em>Link action backward</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_action_backward()
	 * @generated
	 * @ordered
	 */
	protected EList link_action_backward;

	/**
	 * The cached value of the '{@link #getLink_action_forward() <em>Link action forward</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_action_forward()
	 * @generated
	 * @ordered
	 */
	protected EList link_action_forward;

	/**
	 * The cached value of the '{@link #getLink_action_turn() <em>Link action turn</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_action_turn()
	 * @generated
	 * @ordered
	 */
	protected EList link_action_turn;

	/**
	 * The cached value of the '{@link #getLink_knowledgeAndSkill_driverPreference() <em>Link knowledge And Skill driver Preference</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_knowledgeAndSkill_driverPreference()
	 * @generated
	 * @ordered
	 */
	protected EList link_knowledgeAndSkill_driverPreference;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MobilitySystemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return IntelligentMobilityPackage.eINSTANCE.getMobilitySystem();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getDriver_profile() {
		if (driver_profile == null) {
			driver_profile = new EObjectContainmentEList(Driver_Profile.class, this, IntelligentMobilityPackage.MOBILITY_SYSTEM__DRIVER_PROFILE);
		}
		return driver_profile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getVehicle_configuration() {
		if (vehicle_configuration == null) {
			vehicle_configuration = new EObjectContainmentEList(Vehicle_Configuration.class, this, IntelligentMobilityPackage.MOBILITY_SYSTEM__VEHICLE_CONFIGURATION);
		}
		return vehicle_configuration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getEnvironment_background() {
		if (environment_background == null) {
			environment_background = new EObjectContainmentEList(Environment_Background.class, this, IntelligentMobilityPackage.MOBILITY_SYSTEM__ENVIRONMENT_BACKGROUND);
		}
		return environment_background;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getDriver_preference() {
		if (driver_preference == null) {
			driver_preference = new EObjectContainmentEList(Driver_Preference.class, this, IntelligentMobilityPackage.MOBILITY_SYSTEM__DRIVER_PREFERENCE);
		}
		return driver_preference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getKnowledge_and_skill() {
		if (knowledge_and_skill == null) {
			knowledge_and_skill = new EObjectContainmentEList(Knowledge_and_Skill.class, this, IntelligentMobilityPackage.MOBILITY_SYSTEM__KNOWLEDGE_AND_SKILL);
		}
		return knowledge_and_skill;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getDriver_emotion() {
		if (driver_emotion == null) {
			driver_emotion = new EObjectContainmentEList(Driver_Emotion.class, this, IntelligentMobilityPackage.MOBILITY_SYSTEM__DRIVER_EMOTION);
		}
		return driver_emotion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getDriving_behaviour() {
		if (driving_behaviour == null) {
			driving_behaviour = new EObjectContainmentEList(Driving_Behaviour.class, this, IntelligentMobilityPackage.MOBILITY_SYSTEM__DRIVING_BEHAVIOUR);
		}
		return driving_behaviour;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getNormal_behaviour() {
		if (normal_behaviour == null) {
			normal_behaviour = new EObjectContainmentEList(Normal_Behaviour.class, this, IntelligentMobilityPackage.MOBILITY_SYSTEM__NORMAL_BEHAVIOUR);
		}
		return normal_behaviour;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getFollowing() {
		if (following == null) {
			following = new EObjectContainmentEList(Following.class, this, IntelligentMobilityPackage.MOBILITY_SYSTEM__FOLLOWING);
		}
		return following;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getLane_changing() {
		if (lane_changing == null) {
			lane_changing = new EObjectContainmentEList(LaneChanging.class, this, IntelligentMobilityPackage.MOBILITY_SYSTEM__LANE_CHANGING);
		}
		return lane_changing;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getAbnormal_behaviour() {
		if (abnormal_behaviour == null) {
			abnormal_behaviour = new EObjectContainmentEList(Abnormal_Behaviour.class, this, IntelligentMobilityPackage.MOBILITY_SYSTEM__ABNORMAL_BEHAVIOUR);
		}
		return abnormal_behaviour;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getForward() {
		if (forward == null) {
			forward = new EObjectContainmentEList(Forward.class, this, IntelligentMobilityPackage.MOBILITY_SYSTEM__FORWARD);
		}
		return forward;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getBackward() {
		if (backward == null) {
			backward = new EObjectContainmentEList(Backward.class, this, IntelligentMobilityPackage.MOBILITY_SYSTEM__BACKWARD);
		}
		return backward;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getTurn() {
		if (turn == null) {
			turn = new EObjectContainmentEList(Turn.class, this, IntelligentMobilityPackage.MOBILITY_SYSTEM__TURN);
		}
		return turn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getGap_acceptance() {
		if (gap_acceptance == null) {
			gap_acceptance = new EObjectContainmentEList(GapAcceptance.class, this, IntelligentMobilityPackage.MOBILITY_SYSTEM__GAP_ACCEPTANCE);
		}
		return gap_acceptance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getAction() {
		if (action == null) {
			action = new EObjectContainmentEList(Action.class, this, IntelligentMobilityPackage.MOBILITY_SYSTEM__ACTION);
		}
		return action;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getVehicle_type() {
		if (vehicle_type == null) {
			vehicle_type = new EObjectContainmentEList(Vehicle_Type.class, this, IntelligentMobilityPackage.MOBILITY_SYSTEM__VEHICLE_TYPE);
		}
		return vehicle_type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getPlatoon() {
		if (platoon == null) {
			platoon = new EObjectContainmentEList(Platoon.class, this, IntelligentMobilityPackage.MOBILITY_SYSTEM__PLATOON);
		}
		return platoon;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getNormal_vehicle() {
		if (normal_vehicle == null) {
			normal_vehicle = new EObjectContainmentEList(Normal_Vehicle.class, this, IntelligentMobilityPackage.MOBILITY_SYSTEM__NORMAL_VEHICLE);
		}
		return normal_vehicle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getLeading_vehicle() {
		if (leading_vehicle == null) {
			leading_vehicle = new EObjectContainmentEList(Leading_Vehicle.class, this, IntelligentMobilityPackage.MOBILITY_SYSTEM__LEADING_VEHICLE);
		}
		return leading_vehicle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getFollowing_vehicle() {
		if (following_vehicle == null) {
			following_vehicle = new EObjectContainmentEList(Following_Vehicle.class, this, IntelligentMobilityPackage.MOBILITY_SYSTEM__FOLLOWING_VEHICLE);
		}
		return following_vehicle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getPlatoon_member() {
		if (platoon_member == null) {
			platoon_member = new EObjectContainmentEList(PlatoonMember.class, this, IntelligentMobilityPackage.MOBILITY_SYSTEM__PLATOON_MEMBER);
		}
		return platoon_member;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getPossible_vehicle() {
		if (possible_vehicle == null) {
			possible_vehicle = new EObjectContainmentEList(PossibleVehicle.class, this, IntelligentMobilityPackage.MOBILITY_SYSTEM__POSSIBLE_VEHICLE);
		}
		return possible_vehicle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getEnvironment_condition() {
		if (environment_condition == null) {
			environment_condition = new EObjectContainmentEList(Environment_Condition.class, this, IntelligentMobilityPackage.MOBILITY_SYSTEM__ENVIRONMENT_CONDITION);
		}
		return environment_condition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getLane_type() {
		if (lane_type == null) {
			lane_type = new EObjectContainmentEList(Lane_Type.class, this, IntelligentMobilityPackage.MOBILITY_SYSTEM__LANE_TYPE);
		}
		return lane_type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getRegulation() {
		if (regulation == null) {
			regulation = new EObjectContainmentEList(Regulation.class, this, IntelligentMobilityPackage.MOBILITY_SYSTEM__REGULATION);
		}
		return regulation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getSafety_requirement() {
		if (safety_requirement == null) {
			safety_requirement = new EObjectContainmentEList(Safety_Requirement.class, this, IntelligentMobilityPackage.MOBILITY_SYSTEM__SAFETY_REQUIREMENT);
		}
		return safety_requirement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getWeather() {
		if (weather == null) {
			weather = new EObjectContainmentEList(Weather.class, this, IntelligentMobilityPackage.MOBILITY_SYSTEM__WEATHER);
		}
		return weather;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getTraffic_situation() {
		if (traffic_situation == null) {
			traffic_situation = new EObjectContainmentEList(Traffic_Situation.class, this, IntelligentMobilityPackage.MOBILITY_SYSTEM__TRAFFIC_SITUATION);
		}
		return traffic_situation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getSpecial_condition() {
		if (special_condition == null) {
			special_condition = new EObjectContainmentEList(Special_Condition.class, this, IntelligentMobilityPackage.MOBILITY_SYSTEM__SPECIAL_CONDITION);
		}
		return special_condition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getCollision() {
		if (collision == null) {
			collision = new EObjectContainmentEList(Collision.class, this, IntelligentMobilityPackage.MOBILITY_SYSTEM__COLLISION);
		}
		return collision;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getIntersection() {
		if (intersection == null) {
			intersection = new EObjectContainmentEList(Intersection.class, this, IntelligentMobilityPackage.MOBILITY_SYSTEM__INTERSECTION);
		}
		return intersection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getObstruction() {
		if (obstruction == null) {
			obstruction = new EObjectContainmentEList(Obstruction.class, this, IntelligentMobilityPackage.MOBILITY_SYSTEM__OBSTRUCTION);
		}
		return obstruction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getTraffic_light() {
		if (traffic_light == null) {
			traffic_light = new EObjectContainmentEList(Traffic_Light.class, this, IntelligentMobilityPackage.MOBILITY_SYSTEM__TRAFFIC_LIGHT);
		}
		return traffic_light;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getExecption_condition() {
		if (execption_condition == null) {
			execption_condition = new EObjectContainmentEList(ExceptionCondition.class, this, IntelligentMobilityPackage.MOBILITY_SYSTEM__EXECPTION_CONDITION);
		}
		return execption_condition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getLink_driver_vehicle() {
		if (link_driver_vehicle == null) {
			link_driver_vehicle = new EObjectContainmentEList(Link_Driver_Vehicle.class, this, IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_DRIVER_VEHICLE);
		}
		return link_driver_vehicle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getLink_driver_environment() {
		if (link_driver_environment == null) {
			link_driver_environment = new EObjectContainmentEList(Link_Driver_Environment.class, this, IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_DRIVER_ENVIRONMENT);
		}
		return link_driver_environment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getLink_vehicle_environment() {
		if (link_vehicle_environment == null) {
			link_vehicle_environment = new EObjectContainmentEList(Link_Vehicle_Environment.class, this, IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_VEHICLE_ENVIRONMENT);
		}
		return link_vehicle_environment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getLink_driverProfile_driverPreference() {
		if (link_driverProfile_driverPreference == null) {
			link_driverProfile_driverPreference = new EObjectContainmentEList(Link_DriverProfile_DriverPreference.class, this, IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_DRIVER_PROFILE_DRIVER_PREFERENCE);
		}
		return link_driverProfile_driverPreference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getLink_vehicleConfiguration_vehicleType() {
		if (link_vehicleConfiguration_vehicleType == null) {
			link_vehicleConfiguration_vehicleType = new EObjectContainmentEList(Link_VehicleConfiguration_VehicleType.class, this, IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_VEHICLE_CONFIGURATION_VEHICLE_TYPE);
		}
		return link_vehicleConfiguration_vehicleType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getLink_environmentBackground_possibleVehicle() {
		if (link_environmentBackground_possibleVehicle == null) {
			link_environmentBackground_possibleVehicle = new EObjectContainmentEList(Link_EnvironmentBackground_PossibleVehicle.class, this, IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_ENVIRONMENT_BACKGROUND_POSSIBLE_VEHICLE);
		}
		return link_environmentBackground_possibleVehicle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getLink_environmentBackground_environmentCondition() {
		if (link_environmentBackground_environmentCondition == null) {
			link_environmentBackground_environmentCondition = new EObjectContainmentEList(Link_EnvironmentBackground_EnvironmentCondition.class, this, IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_ENVIRONMENT_BACKGROUND_ENVIRONMENT_CONDITION);
		}
		return link_environmentBackground_environmentCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getLink_driverPreference_driverEmotion() {
		if (link_driverPreference_driverEmotion == null) {
			link_driverPreference_driverEmotion = new EObjectContainmentEList(Link_DriverPreference_DriverEmotion.class, this, IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_DRIVER_PREFERENCE_DRIVER_EMOTION);
		}
		return link_driverPreference_driverEmotion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getLink_driverPreference_drivingBehaviour() {
		if (link_driverPreference_drivingBehaviour == null) {
			link_driverPreference_drivingBehaviour = new EObjectContainmentEList(Link_DriverPreference_DrivingBehaviour.class, this, IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_DRIVER_PREFERENCE_DRIVING_BEHAVIOUR);
		}
		return link_driverPreference_drivingBehaviour;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getLink_driverPreference_environmentCondition() {
		if (link_driverPreference_environmentCondition == null) {
			link_driverPreference_environmentCondition = new EObjectContainmentEList(Link_DriverPreference_EnvironmentCondition.class, this, IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_DRIVER_PREFERENCE_ENVIRONMENT_CONDITION);
		}
		return link_driverPreference_environmentCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getLink_drivingBehaviour_normalBehaviour() {
		if (link_drivingBehaviour_normalBehaviour == null) {
			link_drivingBehaviour_normalBehaviour = new EObjectContainmentEList(Link_DrivingBehaviour_NormalBehaviour.class, this, IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_DRIVING_BEHAVIOUR_NORMAL_BEHAVIOUR);
		}
		return link_drivingBehaviour_normalBehaviour;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getLink_normalBehaviour_following() {
		if (link_normalBehaviour_following == null) {
			link_normalBehaviour_following = new EObjectContainmentEList(Link_NormalBehaviour_Following.class, this, IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_NORMAL_BEHAVIOUR_FOLLOWING);
		}
		return link_normalBehaviour_following;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getLink_normalBehaviour_laneChanging() {
		if (link_normalBehaviour_laneChanging == null) {
			link_normalBehaviour_laneChanging = new EObjectContainmentEList(Link_NormalBehaviour_LaneChanging.class, this, IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_NORMAL_BEHAVIOUR_LANE_CHANGING);
		}
		return link_normalBehaviour_laneChanging;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getLink_following_minGap() {
		if (link_following_minGap == null) {
			link_following_minGap = new EObjectContainmentEList(Link_Following_MinGap.class, this, IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_FOLLOWING_MIN_GAP);
		}
		return link_following_minGap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getLink_following_forward() {
		if (link_following_forward == null) {
			link_following_forward = new EObjectContainmentEList(Link_Following_Forward.class, this, IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_FOLLOWING_FORWARD);
		}
		return link_following_forward;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getLink_following_backward() {
		if (link_following_backward == null) {
			link_following_backward = new EObjectContainmentEList(Link_Following_Backward.class, this, IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_FOLLOWING_BACKWARD);
		}
		return link_following_backward;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getLink_laneChanging_turn() {
		if (link_laneChanging_turn == null) {
			link_laneChanging_turn = new EObjectContainmentEList(Link_LaneChanging_Turn.class, this, IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_LANE_CHANGING_TURN);
		}
		return link_laneChanging_turn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getLink_laneChanging_gapAcceptance() {
		if (link_laneChanging_gapAcceptance == null) {
			link_laneChanging_gapAcceptance = new EObjectContainmentEList(Link_LaneChanging_GapAcceptance.class, this, IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_LANE_CHANGING_GAP_ACCEPTANCE);
		}
		return link_laneChanging_gapAcceptance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getLink_laneChanging_environmentCondition() {
		if (link_laneChanging_environmentCondition == null) {
			link_laneChanging_environmentCondition = new EObjectContainmentEList(Link_LaneChanging_EnvironmentCondition.class, this, IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_LANE_CHANGING_ENVIRONMENT_CONDITION);
		}
		return link_laneChanging_environmentCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getLink_abnormalBehaviour_action() {
		if (link_abnormalBehaviour_action == null) {
			link_abnormalBehaviour_action = new EObjectContainmentEList(Link_AbnormalBehaviour_Action.class, this, IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_ABNORMAL_BEHAVIOUR_ACTION);
		}
		return link_abnormalBehaviour_action;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getLink_platoon_leadingVehicle() {
		if (link_platoon_leadingVehicle == null) {
			link_platoon_leadingVehicle = new EObjectContainmentEList(Link_Platoon_LeadingVehicle.class, this, IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_PLATOON_LEADING_VEHICLE);
		}
		return link_platoon_leadingVehicle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getLink_platoon_followingVehicle() {
		if (link_platoon_followingVehicle == null) {
			link_platoon_followingVehicle = new EObjectContainmentEList(Link_Platoon_FollowingVehicle.class, this, IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_PLATOON_FOLLOWING_VEHICLE);
		}
		return link_platoon_followingVehicle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getLink_normalVehicle_safetyRequirement() {
		if (link_normalVehicle_safetyRequirement == null) {
			link_normalVehicle_safetyRequirement = new EObjectContainmentEList(Link_NormalVehicle_SafetyRequirements.class, this, IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_NORMAL_VEHICLE_SAFETY_REQUIREMENT);
		}
		return link_normalVehicle_safetyRequirement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getLink_followingVehicle_frontVehicle() {
		if (link_followingVehicle_frontVehicle == null) {
			link_followingVehicle_frontVehicle = new EObjectContainmentEList(Link_FollowingVehicle_FrontVehicle.class, this, IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_FOLLOWING_VEHICLE_FRONT_VEHICLE);
		}
		return link_followingVehicle_frontVehicle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getLink_environmentCondition_laneType() {
		if (link_environmentCondition_laneType == null) {
			link_environmentCondition_laneType = new EObjectContainmentEList(Link_EnvironmentCondition_LaneType.class, this, IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_ENVIRONMENT_CONDITION_LANE_TYPE);
		}
		return link_environmentCondition_laneType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getLink_environmentCondition_regulation() {
		if (link_environmentCondition_regulation == null) {
			link_environmentCondition_regulation = new EObjectContainmentEList(Link_EnvironmentCondition_Regulations.class, this, IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_ENVIRONMENT_CONDITION_REGULATION);
		}
		return link_environmentCondition_regulation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getLink_environmentCondition_weather() {
		if (link_environmentCondition_weather == null) {
			link_environmentCondition_weather = new EObjectContainmentEList(Link_EnvironmentCondition_Weather.class, this, IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_ENVIRONMENT_CONDITION_WEATHER);
		}
		return link_environmentCondition_weather;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getLink_environmentCondition_trafficCondition() {
		if (link_environmentCondition_trafficCondition == null) {
			link_environmentCondition_trafficCondition = new EObjectContainmentEList(Link_EnvironmentCondition_TrafficCondition.class, this, IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_ENVIRONMENT_CONDITION_TRAFFIC_CONDITION);
		}
		return link_environmentCondition_trafficCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getLink_environmentCondition_specialCondition() {
		if (link_environmentCondition_specialCondition == null) {
			link_environmentCondition_specialCondition = new EObjectContainmentEList(Link_EnvironmentCondition_SpecialCondition.class, this, IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_ENVIRONMENT_CONDITION_SPECIAL_CONDITION);
		}
		return link_environmentCondition_specialCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getLink_laneType_regulation() {
		if (link_laneType_regulation == null) {
			link_laneType_regulation = new EObjectContainmentEList(Link_LaneType_Regulation.class, this, IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_LANE_TYPE_REGULATION);
		}
		return link_laneType_regulation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getLink_safetyRequirement_regulation() {
		if (link_safetyRequirement_regulation == null) {
			link_safetyRequirement_regulation = new EObjectContainmentEList(Link_SafetyRequirement_Regulation.class, this, IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_SAFETY_REQUIREMENT_REGULATION);
		}
		return link_safetyRequirement_regulation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getLink_specialCondition_intersection() {
		if (link_specialCondition_intersection == null) {
			link_specialCondition_intersection = new EObjectContainmentEList(Link_SpecialCondition_Intersection.class, this, IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_SPECIAL_CONDITION_INTERSECTION);
		}
		return link_specialCondition_intersection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getLink_collision_obstruction() {
		if (link_collision_obstruction == null) {
			link_collision_obstruction = new EObjectContainmentEList(Link_Collision_Obstruction.class, this, IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_COLLISION_OBSTRUCTION);
		}
		return link_collision_obstruction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getLink_intersection_trafficLight() {
		if (link_intersection_trafficLight == null) {
			link_intersection_trafficLight = new EObjectContainmentEList(Link_Intersection_TrafficLight.class, this, IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_INTERSECTION_TRAFFIC_LIGHT);
		}
		return link_intersection_trafficLight;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSystemID() {
		return systemID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSystemID(int newSystemID) {
		int oldSystemID = systemID;
		systemID = newSystemID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.MOBILITY_SYSTEM__SYSTEM_ID, oldSystemID, systemID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getGeographicalScope() {
		return geographicalScope;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGeographicalScope(String newGeographicalScope) {
		String oldGeographicalScope = geographicalScope;
		geographicalScope = newGeographicalScope;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.MOBILITY_SYSTEM__GEOGRAPHICAL_SCOPE, oldGeographicalScope, geographicalScope));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInfrastructureType() {
		return infrastructureType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInfrastructureType(String newInfrastructureType) {
		String oldInfrastructureType = infrastructureType;
		infrastructureType = newInfrastructureType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.MOBILITY_SYSTEM__INFRASTRUCTURE_TYPE, oldInfrastructureType, infrastructureType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getInfrastructure() {
		if (infrastructure == null) {
			infrastructure = new EObjectContainmentEList(Infrastructure.class, this, IntelligentMobilityPackage.MOBILITY_SYSTEM__INFRASTRUCTURE);
		}
		return infrastructure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getCommunicationInterfaces() {
		if (communicationInterfaces == null) {
			communicationInterfaces = new EObjectContainmentEList(CommunicationInterface.class, this, IntelligentMobilityPackage.MOBILITY_SYSTEM__COMMUNICATION_INTERFACES);
		}
		return communicationInterfaces;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getGoal() {
		if (goal == null) {
			goal = new EObjectContainmentEList(Goal.class, this, IntelligentMobilityPackage.MOBILITY_SYSTEM__GOAL);
		}
		return goal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getLink_infrastructure_vehicle_configuration() {
		if (link_infrastructure_vehicle_configuration == null) {
			link_infrastructure_vehicle_configuration = new EObjectContainmentEList(Link_Infrastructure_VehicleConfiguration.class, this, IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_INFRASTRUCTURE_VEHICLE_CONFIGURATION);
		}
		return link_infrastructure_vehicle_configuration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getLink_communicationInterface_vehicleConfiguration() {
		if (link_communicationInterface_vehicleConfiguration == null) {
			link_communicationInterface_vehicleConfiguration = new EObjectContainmentEList(Link_CommunicationInterface_VehicleConfiguration.class, this, IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_COMMUNICATION_INTERFACE_VEHICLE_CONFIGURATION);
		}
		return link_communicationInterface_vehicleConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getLink_communicationInterface_infrastructure() {
		if (link_communicationInterface_infrastructure == null) {
			link_communicationInterface_infrastructure = new EObjectContainmentEList(Link_CommunicationInterface_Infrastructure.class, this, IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_COMMUNICATION_INTERFACE_INFRASTRUCTURE);
		}
		return link_communicationInterface_infrastructure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getLink_goal_drivingBehaviour() {
		if (link_goal_drivingBehaviour == null) {
			link_goal_drivingBehaviour = new EObjectContainmentEList(Link_Goal_DrivingBehaviour.class, this, IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_GOAL_DRIVING_BEHAVIOUR);
		}
		return link_goal_drivingBehaviour;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getCooperativeBehaviour() {
		if (cooperativeBehaviour == null) {
			cooperativeBehaviour = new EObjectContainmentEList(CooperativeBehavior.class, this, IntelligentMobilityPackage.MOBILITY_SYSTEM__COOPERATIVE_BEHAVIOUR);
		}
		return cooperativeBehaviour;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getLink_cooperativeBehaviour_communicationInterface() {
		if (link_cooperativeBehaviour_communicationInterface == null) {
			link_cooperativeBehaviour_communicationInterface = new EObjectContainmentEList(Link_CooperativeBehaviour_CommunicationInterface.class, this, IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_COOPERATIVE_BEHAVIOUR_COMMUNICATION_INTERFACE);
		}
		return link_cooperativeBehaviour_communicationInterface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getLink_cooperativeBehaviour_vehicleConfiguration() {
		if (link_cooperativeBehaviour_vehicleConfiguration == null) {
			link_cooperativeBehaviour_vehicleConfiguration = new EObjectContainmentEList(Link_CooperativeBehaviour_VehicleConfiguration.class, this, IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_COOPERATIVE_BEHAVIOUR_VEHICLE_CONFIGURATION);
		}
		return link_cooperativeBehaviour_vehicleConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getLink_trafficSituation_environmentCondition() {
		if (link_trafficSituation_environmentCondition == null) {
			link_trafficSituation_environmentCondition = new EObjectContainmentEList(Link_TrafficSituation_EnvironmentCondition.class, this, IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_TRAFFIC_SITUATION_ENVIRONMENT_CONDITION);
		}
		return link_trafficSituation_environmentCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getLink_following_laneChanging() {
		if (link_following_laneChanging == null) {
			link_following_laneChanging = new EObjectContainmentEList(Link_Following_LaneChanging.class, this, IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_FOLLOWING_LANE_CHANGING);
		}
		return link_following_laneChanging;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getLink_collision_specialCondition() {
		if (link_collision_specialCondition == null) {
			link_collision_specialCondition = new EObjectContainmentEList(Link_Collision_SpecialCondition.class, this, IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_COLLISION_SPECIAL_CONDITION);
		}
		return link_collision_specialCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getLink_action_backward() {
		if (link_action_backward == null) {
			link_action_backward = new EObjectContainmentEList(Link_Action_Backward.class, this, IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_ACTION_BACKWARD);
		}
		return link_action_backward;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getLink_action_forward() {
		if (link_action_forward == null) {
			link_action_forward = new EObjectContainmentEList(Link_Action_Forward.class, this, IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_ACTION_FORWARD);
		}
		return link_action_forward;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getLink_action_turn() {
		if (link_action_turn == null) {
			link_action_turn = new EObjectContainmentEList(Link_Action_Turn.class, this, IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_ACTION_TURN);
		}
		return link_action_turn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getLink_knowledgeAndSkill_driverPreference() {
		if (link_knowledgeAndSkill_driverPreference == null) {
			link_knowledgeAndSkill_driverPreference = new EObjectContainmentEList(Link_KnowledgeAndSkill_DriverPreference.class, this, IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_KNOWLEDGE_AND_SKILL_DRIVER_PREFERENCE);
		}
		return link_knowledgeAndSkill_driverPreference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__DRIVER_PROFILE:
				return ((InternalEList)getDriver_profile()).basicRemove(otherEnd, msgs);
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__VEHICLE_CONFIGURATION:
				return ((InternalEList)getVehicle_configuration()).basicRemove(otherEnd, msgs);
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__ENVIRONMENT_BACKGROUND:
				return ((InternalEList)getEnvironment_background()).basicRemove(otherEnd, msgs);
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__DRIVER_PREFERENCE:
				return ((InternalEList)getDriver_preference()).basicRemove(otherEnd, msgs);
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__KNOWLEDGE_AND_SKILL:
				return ((InternalEList)getKnowledge_and_skill()).basicRemove(otherEnd, msgs);
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__DRIVER_EMOTION:
				return ((InternalEList)getDriver_emotion()).basicRemove(otherEnd, msgs);
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__DRIVING_BEHAVIOUR:
				return ((InternalEList)getDriving_behaviour()).basicRemove(otherEnd, msgs);
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__NORMAL_BEHAVIOUR:
				return ((InternalEList)getNormal_behaviour()).basicRemove(otherEnd, msgs);
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__FOLLOWING:
				return ((InternalEList)getFollowing()).basicRemove(otherEnd, msgs);
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LANE_CHANGING:
				return ((InternalEList)getLane_changing()).basicRemove(otherEnd, msgs);
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__ABNORMAL_BEHAVIOUR:
				return ((InternalEList)getAbnormal_behaviour()).basicRemove(otherEnd, msgs);
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__FORWARD:
				return ((InternalEList)getForward()).basicRemove(otherEnd, msgs);
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__BACKWARD:
				return ((InternalEList)getBackward()).basicRemove(otherEnd, msgs);
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__TURN:
				return ((InternalEList)getTurn()).basicRemove(otherEnd, msgs);
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__GAP_ACCEPTANCE:
				return ((InternalEList)getGap_acceptance()).basicRemove(otherEnd, msgs);
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__ACTION:
				return ((InternalEList)getAction()).basicRemove(otherEnd, msgs);
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__VEHICLE_TYPE:
				return ((InternalEList)getVehicle_type()).basicRemove(otherEnd, msgs);
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__PLATOON:
				return ((InternalEList)getPlatoon()).basicRemove(otherEnd, msgs);
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__NORMAL_VEHICLE:
				return ((InternalEList)getNormal_vehicle()).basicRemove(otherEnd, msgs);
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LEADING_VEHICLE:
				return ((InternalEList)getLeading_vehicle()).basicRemove(otherEnd, msgs);
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__FOLLOWING_VEHICLE:
				return ((InternalEList)getFollowing_vehicle()).basicRemove(otherEnd, msgs);
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__PLATOON_MEMBER:
				return ((InternalEList)getPlatoon_member()).basicRemove(otherEnd, msgs);
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__POSSIBLE_VEHICLE:
				return ((InternalEList)getPossible_vehicle()).basicRemove(otherEnd, msgs);
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__ENVIRONMENT_CONDITION:
				return ((InternalEList)getEnvironment_condition()).basicRemove(otherEnd, msgs);
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LANE_TYPE:
				return ((InternalEList)getLane_type()).basicRemove(otherEnd, msgs);
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__REGULATION:
				return ((InternalEList)getRegulation()).basicRemove(otherEnd, msgs);
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__SAFETY_REQUIREMENT:
				return ((InternalEList)getSafety_requirement()).basicRemove(otherEnd, msgs);
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__WEATHER:
				return ((InternalEList)getWeather()).basicRemove(otherEnd, msgs);
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__TRAFFIC_SITUATION:
				return ((InternalEList)getTraffic_situation()).basicRemove(otherEnd, msgs);
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__SPECIAL_CONDITION:
				return ((InternalEList)getSpecial_condition()).basicRemove(otherEnd, msgs);
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__COLLISION:
				return ((InternalEList)getCollision()).basicRemove(otherEnd, msgs);
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__INTERSECTION:
				return ((InternalEList)getIntersection()).basicRemove(otherEnd, msgs);
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__OBSTRUCTION:
				return ((InternalEList)getObstruction()).basicRemove(otherEnd, msgs);
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__TRAFFIC_LIGHT:
				return ((InternalEList)getTraffic_light()).basicRemove(otherEnd, msgs);
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__EXECPTION_CONDITION:
				return ((InternalEList)getExecption_condition()).basicRemove(otherEnd, msgs);
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_DRIVER_VEHICLE:
				return ((InternalEList)getLink_driver_vehicle()).basicRemove(otherEnd, msgs);
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_DRIVER_ENVIRONMENT:
				return ((InternalEList)getLink_driver_environment()).basicRemove(otherEnd, msgs);
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_VEHICLE_ENVIRONMENT:
				return ((InternalEList)getLink_vehicle_environment()).basicRemove(otherEnd, msgs);
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_DRIVER_PROFILE_DRIVER_PREFERENCE:
				return ((InternalEList)getLink_driverProfile_driverPreference()).basicRemove(otherEnd, msgs);
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_VEHICLE_CONFIGURATION_VEHICLE_TYPE:
				return ((InternalEList)getLink_vehicleConfiguration_vehicleType()).basicRemove(otherEnd, msgs);
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_ENVIRONMENT_BACKGROUND_POSSIBLE_VEHICLE:
				return ((InternalEList)getLink_environmentBackground_possibleVehicle()).basicRemove(otherEnd, msgs);
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_ENVIRONMENT_BACKGROUND_ENVIRONMENT_CONDITION:
				return ((InternalEList)getLink_environmentBackground_environmentCondition()).basicRemove(otherEnd, msgs);
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_DRIVER_PREFERENCE_DRIVER_EMOTION:
				return ((InternalEList)getLink_driverPreference_driverEmotion()).basicRemove(otherEnd, msgs);
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_DRIVER_PREFERENCE_DRIVING_BEHAVIOUR:
				return ((InternalEList)getLink_driverPreference_drivingBehaviour()).basicRemove(otherEnd, msgs);
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_DRIVER_PREFERENCE_ENVIRONMENT_CONDITION:
				return ((InternalEList)getLink_driverPreference_environmentCondition()).basicRemove(otherEnd, msgs);
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_DRIVING_BEHAVIOUR_NORMAL_BEHAVIOUR:
				return ((InternalEList)getLink_drivingBehaviour_normalBehaviour()).basicRemove(otherEnd, msgs);
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_NORMAL_BEHAVIOUR_FOLLOWING:
				return ((InternalEList)getLink_normalBehaviour_following()).basicRemove(otherEnd, msgs);
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_NORMAL_BEHAVIOUR_LANE_CHANGING:
				return ((InternalEList)getLink_normalBehaviour_laneChanging()).basicRemove(otherEnd, msgs);
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_FOLLOWING_MIN_GAP:
				return ((InternalEList)getLink_following_minGap()).basicRemove(otherEnd, msgs);
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_FOLLOWING_FORWARD:
				return ((InternalEList)getLink_following_forward()).basicRemove(otherEnd, msgs);
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_FOLLOWING_BACKWARD:
				return ((InternalEList)getLink_following_backward()).basicRemove(otherEnd, msgs);
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_LANE_CHANGING_TURN:
				return ((InternalEList)getLink_laneChanging_turn()).basicRemove(otherEnd, msgs);
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_LANE_CHANGING_GAP_ACCEPTANCE:
				return ((InternalEList)getLink_laneChanging_gapAcceptance()).basicRemove(otherEnd, msgs);
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_LANE_CHANGING_ENVIRONMENT_CONDITION:
				return ((InternalEList)getLink_laneChanging_environmentCondition()).basicRemove(otherEnd, msgs);
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_ABNORMAL_BEHAVIOUR_ACTION:
				return ((InternalEList)getLink_abnormalBehaviour_action()).basicRemove(otherEnd, msgs);
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_PLATOON_LEADING_VEHICLE:
				return ((InternalEList)getLink_platoon_leadingVehicle()).basicRemove(otherEnd, msgs);
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_PLATOON_FOLLOWING_VEHICLE:
				return ((InternalEList)getLink_platoon_followingVehicle()).basicRemove(otherEnd, msgs);
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_NORMAL_VEHICLE_SAFETY_REQUIREMENT:
				return ((InternalEList)getLink_normalVehicle_safetyRequirement()).basicRemove(otherEnd, msgs);
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_FOLLOWING_VEHICLE_FRONT_VEHICLE:
				return ((InternalEList)getLink_followingVehicle_frontVehicle()).basicRemove(otherEnd, msgs);
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_ENVIRONMENT_CONDITION_LANE_TYPE:
				return ((InternalEList)getLink_environmentCondition_laneType()).basicRemove(otherEnd, msgs);
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_ENVIRONMENT_CONDITION_REGULATION:
				return ((InternalEList)getLink_environmentCondition_regulation()).basicRemove(otherEnd, msgs);
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_ENVIRONMENT_CONDITION_WEATHER:
				return ((InternalEList)getLink_environmentCondition_weather()).basicRemove(otherEnd, msgs);
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_ENVIRONMENT_CONDITION_TRAFFIC_CONDITION:
				return ((InternalEList)getLink_environmentCondition_trafficCondition()).basicRemove(otherEnd, msgs);
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_ENVIRONMENT_CONDITION_SPECIAL_CONDITION:
				return ((InternalEList)getLink_environmentCondition_specialCondition()).basicRemove(otherEnd, msgs);
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_LANE_TYPE_REGULATION:
				return ((InternalEList)getLink_laneType_regulation()).basicRemove(otherEnd, msgs);
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_SAFETY_REQUIREMENT_REGULATION:
				return ((InternalEList)getLink_safetyRequirement_regulation()).basicRemove(otherEnd, msgs);
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_SPECIAL_CONDITION_INTERSECTION:
				return ((InternalEList)getLink_specialCondition_intersection()).basicRemove(otherEnd, msgs);
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_COLLISION_OBSTRUCTION:
				return ((InternalEList)getLink_collision_obstruction()).basicRemove(otherEnd, msgs);
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_INTERSECTION_TRAFFIC_LIGHT:
				return ((InternalEList)getLink_intersection_trafficLight()).basicRemove(otherEnd, msgs);
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__INFRASTRUCTURE:
				return ((InternalEList)getInfrastructure()).basicRemove(otherEnd, msgs);
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__COMMUNICATION_INTERFACES:
				return ((InternalEList)getCommunicationInterfaces()).basicRemove(otherEnd, msgs);
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__GOAL:
				return ((InternalEList)getGoal()).basicRemove(otherEnd, msgs);
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_INFRASTRUCTURE_VEHICLE_CONFIGURATION:
				return ((InternalEList)getLink_infrastructure_vehicle_configuration()).basicRemove(otherEnd, msgs);
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_COMMUNICATION_INTERFACE_VEHICLE_CONFIGURATION:
				return ((InternalEList)getLink_communicationInterface_vehicleConfiguration()).basicRemove(otherEnd, msgs);
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_COMMUNICATION_INTERFACE_INFRASTRUCTURE:
				return ((InternalEList)getLink_communicationInterface_infrastructure()).basicRemove(otherEnd, msgs);
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_GOAL_DRIVING_BEHAVIOUR:
				return ((InternalEList)getLink_goal_drivingBehaviour()).basicRemove(otherEnd, msgs);
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__COOPERATIVE_BEHAVIOUR:
				return ((InternalEList)getCooperativeBehaviour()).basicRemove(otherEnd, msgs);
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_COOPERATIVE_BEHAVIOUR_COMMUNICATION_INTERFACE:
				return ((InternalEList)getLink_cooperativeBehaviour_communicationInterface()).basicRemove(otherEnd, msgs);
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_COOPERATIVE_BEHAVIOUR_VEHICLE_CONFIGURATION:
				return ((InternalEList)getLink_cooperativeBehaviour_vehicleConfiguration()).basicRemove(otherEnd, msgs);
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_TRAFFIC_SITUATION_ENVIRONMENT_CONDITION:
				return ((InternalEList)getLink_trafficSituation_environmentCondition()).basicRemove(otherEnd, msgs);
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_FOLLOWING_LANE_CHANGING:
				return ((InternalEList)getLink_following_laneChanging()).basicRemove(otherEnd, msgs);
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_COLLISION_SPECIAL_CONDITION:
				return ((InternalEList)getLink_collision_specialCondition()).basicRemove(otherEnd, msgs);
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_ACTION_BACKWARD:
				return ((InternalEList)getLink_action_backward()).basicRemove(otherEnd, msgs);
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_ACTION_FORWARD:
				return ((InternalEList)getLink_action_forward()).basicRemove(otherEnd, msgs);
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_ACTION_TURN:
				return ((InternalEList)getLink_action_turn()).basicRemove(otherEnd, msgs);
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_KNOWLEDGE_AND_SKILL_DRIVER_PREFERENCE:
				return ((InternalEList)getLink_knowledgeAndSkill_driverPreference()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__DRIVER_PROFILE:
				return getDriver_profile();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__VEHICLE_CONFIGURATION:
				return getVehicle_configuration();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__ENVIRONMENT_BACKGROUND:
				return getEnvironment_background();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__DRIVER_PREFERENCE:
				return getDriver_preference();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__KNOWLEDGE_AND_SKILL:
				return getKnowledge_and_skill();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__DRIVER_EMOTION:
				return getDriver_emotion();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__DRIVING_BEHAVIOUR:
				return getDriving_behaviour();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__NORMAL_BEHAVIOUR:
				return getNormal_behaviour();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__FOLLOWING:
				return getFollowing();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LANE_CHANGING:
				return getLane_changing();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__ABNORMAL_BEHAVIOUR:
				return getAbnormal_behaviour();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__FORWARD:
				return getForward();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__BACKWARD:
				return getBackward();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__TURN:
				return getTurn();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__GAP_ACCEPTANCE:
				return getGap_acceptance();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__ACTION:
				return getAction();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__VEHICLE_TYPE:
				return getVehicle_type();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__PLATOON:
				return getPlatoon();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__NORMAL_VEHICLE:
				return getNormal_vehicle();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LEADING_VEHICLE:
				return getLeading_vehicle();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__FOLLOWING_VEHICLE:
				return getFollowing_vehicle();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__PLATOON_MEMBER:
				return getPlatoon_member();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__POSSIBLE_VEHICLE:
				return getPossible_vehicle();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__ENVIRONMENT_CONDITION:
				return getEnvironment_condition();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LANE_TYPE:
				return getLane_type();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__REGULATION:
				return getRegulation();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__SAFETY_REQUIREMENT:
				return getSafety_requirement();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__WEATHER:
				return getWeather();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__TRAFFIC_SITUATION:
				return getTraffic_situation();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__SPECIAL_CONDITION:
				return getSpecial_condition();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__COLLISION:
				return getCollision();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__INTERSECTION:
				return getIntersection();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__OBSTRUCTION:
				return getObstruction();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__TRAFFIC_LIGHT:
				return getTraffic_light();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__EXECPTION_CONDITION:
				return getExecption_condition();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_DRIVER_VEHICLE:
				return getLink_driver_vehicle();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_DRIVER_ENVIRONMENT:
				return getLink_driver_environment();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_VEHICLE_ENVIRONMENT:
				return getLink_vehicle_environment();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_DRIVER_PROFILE_DRIVER_PREFERENCE:
				return getLink_driverProfile_driverPreference();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_VEHICLE_CONFIGURATION_VEHICLE_TYPE:
				return getLink_vehicleConfiguration_vehicleType();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_ENVIRONMENT_BACKGROUND_POSSIBLE_VEHICLE:
				return getLink_environmentBackground_possibleVehicle();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_ENVIRONMENT_BACKGROUND_ENVIRONMENT_CONDITION:
				return getLink_environmentBackground_environmentCondition();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_DRIVER_PREFERENCE_DRIVER_EMOTION:
				return getLink_driverPreference_driverEmotion();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_DRIVER_PREFERENCE_DRIVING_BEHAVIOUR:
				return getLink_driverPreference_drivingBehaviour();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_DRIVER_PREFERENCE_ENVIRONMENT_CONDITION:
				return getLink_driverPreference_environmentCondition();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_DRIVING_BEHAVIOUR_NORMAL_BEHAVIOUR:
				return getLink_drivingBehaviour_normalBehaviour();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_NORMAL_BEHAVIOUR_FOLLOWING:
				return getLink_normalBehaviour_following();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_NORMAL_BEHAVIOUR_LANE_CHANGING:
				return getLink_normalBehaviour_laneChanging();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_FOLLOWING_MIN_GAP:
				return getLink_following_minGap();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_FOLLOWING_FORWARD:
				return getLink_following_forward();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_FOLLOWING_BACKWARD:
				return getLink_following_backward();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_LANE_CHANGING_TURN:
				return getLink_laneChanging_turn();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_LANE_CHANGING_GAP_ACCEPTANCE:
				return getLink_laneChanging_gapAcceptance();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_LANE_CHANGING_ENVIRONMENT_CONDITION:
				return getLink_laneChanging_environmentCondition();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_ABNORMAL_BEHAVIOUR_ACTION:
				return getLink_abnormalBehaviour_action();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_PLATOON_LEADING_VEHICLE:
				return getLink_platoon_leadingVehicle();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_PLATOON_FOLLOWING_VEHICLE:
				return getLink_platoon_followingVehicle();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_NORMAL_VEHICLE_SAFETY_REQUIREMENT:
				return getLink_normalVehicle_safetyRequirement();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_FOLLOWING_VEHICLE_FRONT_VEHICLE:
				return getLink_followingVehicle_frontVehicle();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_ENVIRONMENT_CONDITION_LANE_TYPE:
				return getLink_environmentCondition_laneType();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_ENVIRONMENT_CONDITION_REGULATION:
				return getLink_environmentCondition_regulation();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_ENVIRONMENT_CONDITION_WEATHER:
				return getLink_environmentCondition_weather();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_ENVIRONMENT_CONDITION_TRAFFIC_CONDITION:
				return getLink_environmentCondition_trafficCondition();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_ENVIRONMENT_CONDITION_SPECIAL_CONDITION:
				return getLink_environmentCondition_specialCondition();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_LANE_TYPE_REGULATION:
				return getLink_laneType_regulation();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_SAFETY_REQUIREMENT_REGULATION:
				return getLink_safetyRequirement_regulation();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_SPECIAL_CONDITION_INTERSECTION:
				return getLink_specialCondition_intersection();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_COLLISION_OBSTRUCTION:
				return getLink_collision_obstruction();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_INTERSECTION_TRAFFIC_LIGHT:
				return getLink_intersection_trafficLight();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__SYSTEM_ID:
				return new Integer(getSystemID());
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__GEOGRAPHICAL_SCOPE:
				return getGeographicalScope();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__INFRASTRUCTURE_TYPE:
				return getInfrastructureType();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__INFRASTRUCTURE:
				return getInfrastructure();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__COMMUNICATION_INTERFACES:
				return getCommunicationInterfaces();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__GOAL:
				return getGoal();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_INFRASTRUCTURE_VEHICLE_CONFIGURATION:
				return getLink_infrastructure_vehicle_configuration();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_COMMUNICATION_INTERFACE_VEHICLE_CONFIGURATION:
				return getLink_communicationInterface_vehicleConfiguration();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_COMMUNICATION_INTERFACE_INFRASTRUCTURE:
				return getLink_communicationInterface_infrastructure();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_GOAL_DRIVING_BEHAVIOUR:
				return getLink_goal_drivingBehaviour();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__COOPERATIVE_BEHAVIOUR:
				return getCooperativeBehaviour();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_COOPERATIVE_BEHAVIOUR_COMMUNICATION_INTERFACE:
				return getLink_cooperativeBehaviour_communicationInterface();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_COOPERATIVE_BEHAVIOUR_VEHICLE_CONFIGURATION:
				return getLink_cooperativeBehaviour_vehicleConfiguration();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_TRAFFIC_SITUATION_ENVIRONMENT_CONDITION:
				return getLink_trafficSituation_environmentCondition();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_FOLLOWING_LANE_CHANGING:
				return getLink_following_laneChanging();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_COLLISION_SPECIAL_CONDITION:
				return getLink_collision_specialCondition();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_ACTION_BACKWARD:
				return getLink_action_backward();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_ACTION_FORWARD:
				return getLink_action_forward();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_ACTION_TURN:
				return getLink_action_turn();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_KNOWLEDGE_AND_SKILL_DRIVER_PREFERENCE:
				return getLink_knowledgeAndSkill_driverPreference();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__DRIVER_PROFILE:
				getDriver_profile().clear();
				getDriver_profile().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__VEHICLE_CONFIGURATION:
				getVehicle_configuration().clear();
				getVehicle_configuration().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__ENVIRONMENT_BACKGROUND:
				getEnvironment_background().clear();
				getEnvironment_background().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__DRIVER_PREFERENCE:
				getDriver_preference().clear();
				getDriver_preference().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__KNOWLEDGE_AND_SKILL:
				getKnowledge_and_skill().clear();
				getKnowledge_and_skill().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__DRIVER_EMOTION:
				getDriver_emotion().clear();
				getDriver_emotion().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__DRIVING_BEHAVIOUR:
				getDriving_behaviour().clear();
				getDriving_behaviour().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__NORMAL_BEHAVIOUR:
				getNormal_behaviour().clear();
				getNormal_behaviour().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__FOLLOWING:
				getFollowing().clear();
				getFollowing().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LANE_CHANGING:
				getLane_changing().clear();
				getLane_changing().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__ABNORMAL_BEHAVIOUR:
				getAbnormal_behaviour().clear();
				getAbnormal_behaviour().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__FORWARD:
				getForward().clear();
				getForward().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__BACKWARD:
				getBackward().clear();
				getBackward().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__TURN:
				getTurn().clear();
				getTurn().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__GAP_ACCEPTANCE:
				getGap_acceptance().clear();
				getGap_acceptance().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__ACTION:
				getAction().clear();
				getAction().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__VEHICLE_TYPE:
				getVehicle_type().clear();
				getVehicle_type().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__PLATOON:
				getPlatoon().clear();
				getPlatoon().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__NORMAL_VEHICLE:
				getNormal_vehicle().clear();
				getNormal_vehicle().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LEADING_VEHICLE:
				getLeading_vehicle().clear();
				getLeading_vehicle().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__FOLLOWING_VEHICLE:
				getFollowing_vehicle().clear();
				getFollowing_vehicle().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__PLATOON_MEMBER:
				getPlatoon_member().clear();
				getPlatoon_member().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__POSSIBLE_VEHICLE:
				getPossible_vehicle().clear();
				getPossible_vehicle().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__ENVIRONMENT_CONDITION:
				getEnvironment_condition().clear();
				getEnvironment_condition().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LANE_TYPE:
				getLane_type().clear();
				getLane_type().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__REGULATION:
				getRegulation().clear();
				getRegulation().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__SAFETY_REQUIREMENT:
				getSafety_requirement().clear();
				getSafety_requirement().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__WEATHER:
				getWeather().clear();
				getWeather().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__TRAFFIC_SITUATION:
				getTraffic_situation().clear();
				getTraffic_situation().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__SPECIAL_CONDITION:
				getSpecial_condition().clear();
				getSpecial_condition().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__COLLISION:
				getCollision().clear();
				getCollision().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__INTERSECTION:
				getIntersection().clear();
				getIntersection().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__OBSTRUCTION:
				getObstruction().clear();
				getObstruction().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__TRAFFIC_LIGHT:
				getTraffic_light().clear();
				getTraffic_light().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__EXECPTION_CONDITION:
				getExecption_condition().clear();
				getExecption_condition().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_DRIVER_VEHICLE:
				getLink_driver_vehicle().clear();
				getLink_driver_vehicle().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_DRIVER_ENVIRONMENT:
				getLink_driver_environment().clear();
				getLink_driver_environment().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_VEHICLE_ENVIRONMENT:
				getLink_vehicle_environment().clear();
				getLink_vehicle_environment().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_DRIVER_PROFILE_DRIVER_PREFERENCE:
				getLink_driverProfile_driverPreference().clear();
				getLink_driverProfile_driverPreference().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_VEHICLE_CONFIGURATION_VEHICLE_TYPE:
				getLink_vehicleConfiguration_vehicleType().clear();
				getLink_vehicleConfiguration_vehicleType().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_ENVIRONMENT_BACKGROUND_POSSIBLE_VEHICLE:
				getLink_environmentBackground_possibleVehicle().clear();
				getLink_environmentBackground_possibleVehicle().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_ENVIRONMENT_BACKGROUND_ENVIRONMENT_CONDITION:
				getLink_environmentBackground_environmentCondition().clear();
				getLink_environmentBackground_environmentCondition().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_DRIVER_PREFERENCE_DRIVER_EMOTION:
				getLink_driverPreference_driverEmotion().clear();
				getLink_driverPreference_driverEmotion().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_DRIVER_PREFERENCE_DRIVING_BEHAVIOUR:
				getLink_driverPreference_drivingBehaviour().clear();
				getLink_driverPreference_drivingBehaviour().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_DRIVER_PREFERENCE_ENVIRONMENT_CONDITION:
				getLink_driverPreference_environmentCondition().clear();
				getLink_driverPreference_environmentCondition().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_DRIVING_BEHAVIOUR_NORMAL_BEHAVIOUR:
				getLink_drivingBehaviour_normalBehaviour().clear();
				getLink_drivingBehaviour_normalBehaviour().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_NORMAL_BEHAVIOUR_FOLLOWING:
				getLink_normalBehaviour_following().clear();
				getLink_normalBehaviour_following().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_NORMAL_BEHAVIOUR_LANE_CHANGING:
				getLink_normalBehaviour_laneChanging().clear();
				getLink_normalBehaviour_laneChanging().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_FOLLOWING_MIN_GAP:
				getLink_following_minGap().clear();
				getLink_following_minGap().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_FOLLOWING_FORWARD:
				getLink_following_forward().clear();
				getLink_following_forward().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_FOLLOWING_BACKWARD:
				getLink_following_backward().clear();
				getLink_following_backward().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_LANE_CHANGING_TURN:
				getLink_laneChanging_turn().clear();
				getLink_laneChanging_turn().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_LANE_CHANGING_GAP_ACCEPTANCE:
				getLink_laneChanging_gapAcceptance().clear();
				getLink_laneChanging_gapAcceptance().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_LANE_CHANGING_ENVIRONMENT_CONDITION:
				getLink_laneChanging_environmentCondition().clear();
				getLink_laneChanging_environmentCondition().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_ABNORMAL_BEHAVIOUR_ACTION:
				getLink_abnormalBehaviour_action().clear();
				getLink_abnormalBehaviour_action().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_PLATOON_LEADING_VEHICLE:
				getLink_platoon_leadingVehicle().clear();
				getLink_platoon_leadingVehicle().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_PLATOON_FOLLOWING_VEHICLE:
				getLink_platoon_followingVehicle().clear();
				getLink_platoon_followingVehicle().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_NORMAL_VEHICLE_SAFETY_REQUIREMENT:
				getLink_normalVehicle_safetyRequirement().clear();
				getLink_normalVehicle_safetyRequirement().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_FOLLOWING_VEHICLE_FRONT_VEHICLE:
				getLink_followingVehicle_frontVehicle().clear();
				getLink_followingVehicle_frontVehicle().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_ENVIRONMENT_CONDITION_LANE_TYPE:
				getLink_environmentCondition_laneType().clear();
				getLink_environmentCondition_laneType().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_ENVIRONMENT_CONDITION_REGULATION:
				getLink_environmentCondition_regulation().clear();
				getLink_environmentCondition_regulation().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_ENVIRONMENT_CONDITION_WEATHER:
				getLink_environmentCondition_weather().clear();
				getLink_environmentCondition_weather().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_ENVIRONMENT_CONDITION_TRAFFIC_CONDITION:
				getLink_environmentCondition_trafficCondition().clear();
				getLink_environmentCondition_trafficCondition().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_ENVIRONMENT_CONDITION_SPECIAL_CONDITION:
				getLink_environmentCondition_specialCondition().clear();
				getLink_environmentCondition_specialCondition().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_LANE_TYPE_REGULATION:
				getLink_laneType_regulation().clear();
				getLink_laneType_regulation().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_SAFETY_REQUIREMENT_REGULATION:
				getLink_safetyRequirement_regulation().clear();
				getLink_safetyRequirement_regulation().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_SPECIAL_CONDITION_INTERSECTION:
				getLink_specialCondition_intersection().clear();
				getLink_specialCondition_intersection().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_COLLISION_OBSTRUCTION:
				getLink_collision_obstruction().clear();
				getLink_collision_obstruction().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_INTERSECTION_TRAFFIC_LIGHT:
				getLink_intersection_trafficLight().clear();
				getLink_intersection_trafficLight().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__SYSTEM_ID:
				setSystemID(((Integer)newValue).intValue());
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__GEOGRAPHICAL_SCOPE:
				setGeographicalScope((String)newValue);
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__INFRASTRUCTURE_TYPE:
				setInfrastructureType((String)newValue);
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__INFRASTRUCTURE:
				getInfrastructure().clear();
				getInfrastructure().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__COMMUNICATION_INTERFACES:
				getCommunicationInterfaces().clear();
				getCommunicationInterfaces().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__GOAL:
				getGoal().clear();
				getGoal().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_INFRASTRUCTURE_VEHICLE_CONFIGURATION:
				getLink_infrastructure_vehicle_configuration().clear();
				getLink_infrastructure_vehicle_configuration().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_COMMUNICATION_INTERFACE_VEHICLE_CONFIGURATION:
				getLink_communicationInterface_vehicleConfiguration().clear();
				getLink_communicationInterface_vehicleConfiguration().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_COMMUNICATION_INTERFACE_INFRASTRUCTURE:
				getLink_communicationInterface_infrastructure().clear();
				getLink_communicationInterface_infrastructure().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_GOAL_DRIVING_BEHAVIOUR:
				getLink_goal_drivingBehaviour().clear();
				getLink_goal_drivingBehaviour().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__COOPERATIVE_BEHAVIOUR:
				getCooperativeBehaviour().clear();
				getCooperativeBehaviour().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_COOPERATIVE_BEHAVIOUR_COMMUNICATION_INTERFACE:
				getLink_cooperativeBehaviour_communicationInterface().clear();
				getLink_cooperativeBehaviour_communicationInterface().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_COOPERATIVE_BEHAVIOUR_VEHICLE_CONFIGURATION:
				getLink_cooperativeBehaviour_vehicleConfiguration().clear();
				getLink_cooperativeBehaviour_vehicleConfiguration().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_TRAFFIC_SITUATION_ENVIRONMENT_CONDITION:
				getLink_trafficSituation_environmentCondition().clear();
				getLink_trafficSituation_environmentCondition().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_FOLLOWING_LANE_CHANGING:
				getLink_following_laneChanging().clear();
				getLink_following_laneChanging().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_COLLISION_SPECIAL_CONDITION:
				getLink_collision_specialCondition().clear();
				getLink_collision_specialCondition().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_ACTION_BACKWARD:
				getLink_action_backward().clear();
				getLink_action_backward().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_ACTION_FORWARD:
				getLink_action_forward().clear();
				getLink_action_forward().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_ACTION_TURN:
				getLink_action_turn().clear();
				getLink_action_turn().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_KNOWLEDGE_AND_SKILL_DRIVER_PREFERENCE:
				getLink_knowledgeAndSkill_driverPreference().clear();
				getLink_knowledgeAndSkill_driverPreference().addAll((Collection)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__DRIVER_PROFILE:
				getDriver_profile().clear();
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__VEHICLE_CONFIGURATION:
				getVehicle_configuration().clear();
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__ENVIRONMENT_BACKGROUND:
				getEnvironment_background().clear();
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__DRIVER_PREFERENCE:
				getDriver_preference().clear();
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__KNOWLEDGE_AND_SKILL:
				getKnowledge_and_skill().clear();
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__DRIVER_EMOTION:
				getDriver_emotion().clear();
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__DRIVING_BEHAVIOUR:
				getDriving_behaviour().clear();
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__NORMAL_BEHAVIOUR:
				getNormal_behaviour().clear();
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__FOLLOWING:
				getFollowing().clear();
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LANE_CHANGING:
				getLane_changing().clear();
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__ABNORMAL_BEHAVIOUR:
				getAbnormal_behaviour().clear();
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__FORWARD:
				getForward().clear();
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__BACKWARD:
				getBackward().clear();
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__TURN:
				getTurn().clear();
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__GAP_ACCEPTANCE:
				getGap_acceptance().clear();
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__ACTION:
				getAction().clear();
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__VEHICLE_TYPE:
				getVehicle_type().clear();
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__PLATOON:
				getPlatoon().clear();
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__NORMAL_VEHICLE:
				getNormal_vehicle().clear();
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LEADING_VEHICLE:
				getLeading_vehicle().clear();
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__FOLLOWING_VEHICLE:
				getFollowing_vehicle().clear();
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__PLATOON_MEMBER:
				getPlatoon_member().clear();
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__POSSIBLE_VEHICLE:
				getPossible_vehicle().clear();
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__ENVIRONMENT_CONDITION:
				getEnvironment_condition().clear();
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LANE_TYPE:
				getLane_type().clear();
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__REGULATION:
				getRegulation().clear();
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__SAFETY_REQUIREMENT:
				getSafety_requirement().clear();
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__WEATHER:
				getWeather().clear();
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__TRAFFIC_SITUATION:
				getTraffic_situation().clear();
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__SPECIAL_CONDITION:
				getSpecial_condition().clear();
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__COLLISION:
				getCollision().clear();
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__INTERSECTION:
				getIntersection().clear();
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__OBSTRUCTION:
				getObstruction().clear();
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__TRAFFIC_LIGHT:
				getTraffic_light().clear();
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__EXECPTION_CONDITION:
				getExecption_condition().clear();
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_DRIVER_VEHICLE:
				getLink_driver_vehicle().clear();
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_DRIVER_ENVIRONMENT:
				getLink_driver_environment().clear();
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_VEHICLE_ENVIRONMENT:
				getLink_vehicle_environment().clear();
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_DRIVER_PROFILE_DRIVER_PREFERENCE:
				getLink_driverProfile_driverPreference().clear();
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_VEHICLE_CONFIGURATION_VEHICLE_TYPE:
				getLink_vehicleConfiguration_vehicleType().clear();
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_ENVIRONMENT_BACKGROUND_POSSIBLE_VEHICLE:
				getLink_environmentBackground_possibleVehicle().clear();
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_ENVIRONMENT_BACKGROUND_ENVIRONMENT_CONDITION:
				getLink_environmentBackground_environmentCondition().clear();
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_DRIVER_PREFERENCE_DRIVER_EMOTION:
				getLink_driverPreference_driverEmotion().clear();
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_DRIVER_PREFERENCE_DRIVING_BEHAVIOUR:
				getLink_driverPreference_drivingBehaviour().clear();
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_DRIVER_PREFERENCE_ENVIRONMENT_CONDITION:
				getLink_driverPreference_environmentCondition().clear();
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_DRIVING_BEHAVIOUR_NORMAL_BEHAVIOUR:
				getLink_drivingBehaviour_normalBehaviour().clear();
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_NORMAL_BEHAVIOUR_FOLLOWING:
				getLink_normalBehaviour_following().clear();
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_NORMAL_BEHAVIOUR_LANE_CHANGING:
				getLink_normalBehaviour_laneChanging().clear();
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_FOLLOWING_MIN_GAP:
				getLink_following_minGap().clear();
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_FOLLOWING_FORWARD:
				getLink_following_forward().clear();
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_FOLLOWING_BACKWARD:
				getLink_following_backward().clear();
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_LANE_CHANGING_TURN:
				getLink_laneChanging_turn().clear();
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_LANE_CHANGING_GAP_ACCEPTANCE:
				getLink_laneChanging_gapAcceptance().clear();
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_LANE_CHANGING_ENVIRONMENT_CONDITION:
				getLink_laneChanging_environmentCondition().clear();
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_ABNORMAL_BEHAVIOUR_ACTION:
				getLink_abnormalBehaviour_action().clear();
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_PLATOON_LEADING_VEHICLE:
				getLink_platoon_leadingVehicle().clear();
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_PLATOON_FOLLOWING_VEHICLE:
				getLink_platoon_followingVehicle().clear();
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_NORMAL_VEHICLE_SAFETY_REQUIREMENT:
				getLink_normalVehicle_safetyRequirement().clear();
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_FOLLOWING_VEHICLE_FRONT_VEHICLE:
				getLink_followingVehicle_frontVehicle().clear();
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_ENVIRONMENT_CONDITION_LANE_TYPE:
				getLink_environmentCondition_laneType().clear();
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_ENVIRONMENT_CONDITION_REGULATION:
				getLink_environmentCondition_regulation().clear();
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_ENVIRONMENT_CONDITION_WEATHER:
				getLink_environmentCondition_weather().clear();
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_ENVIRONMENT_CONDITION_TRAFFIC_CONDITION:
				getLink_environmentCondition_trafficCondition().clear();
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_ENVIRONMENT_CONDITION_SPECIAL_CONDITION:
				getLink_environmentCondition_specialCondition().clear();
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_LANE_TYPE_REGULATION:
				getLink_laneType_regulation().clear();
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_SAFETY_REQUIREMENT_REGULATION:
				getLink_safetyRequirement_regulation().clear();
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_SPECIAL_CONDITION_INTERSECTION:
				getLink_specialCondition_intersection().clear();
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_COLLISION_OBSTRUCTION:
				getLink_collision_obstruction().clear();
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_INTERSECTION_TRAFFIC_LIGHT:
				getLink_intersection_trafficLight().clear();
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__SYSTEM_ID:
				setSystemID(SYSTEM_ID_EDEFAULT);
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__GEOGRAPHICAL_SCOPE:
				setGeographicalScope(GEOGRAPHICAL_SCOPE_EDEFAULT);
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__INFRASTRUCTURE_TYPE:
				setInfrastructureType(INFRASTRUCTURE_TYPE_EDEFAULT);
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__INFRASTRUCTURE:
				getInfrastructure().clear();
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__COMMUNICATION_INTERFACES:
				getCommunicationInterfaces().clear();
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__GOAL:
				getGoal().clear();
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_INFRASTRUCTURE_VEHICLE_CONFIGURATION:
				getLink_infrastructure_vehicle_configuration().clear();
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_COMMUNICATION_INTERFACE_VEHICLE_CONFIGURATION:
				getLink_communicationInterface_vehicleConfiguration().clear();
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_COMMUNICATION_INTERFACE_INFRASTRUCTURE:
				getLink_communicationInterface_infrastructure().clear();
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_GOAL_DRIVING_BEHAVIOUR:
				getLink_goal_drivingBehaviour().clear();
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__COOPERATIVE_BEHAVIOUR:
				getCooperativeBehaviour().clear();
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_COOPERATIVE_BEHAVIOUR_COMMUNICATION_INTERFACE:
				getLink_cooperativeBehaviour_communicationInterface().clear();
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_COOPERATIVE_BEHAVIOUR_VEHICLE_CONFIGURATION:
				getLink_cooperativeBehaviour_vehicleConfiguration().clear();
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_TRAFFIC_SITUATION_ENVIRONMENT_CONDITION:
				getLink_trafficSituation_environmentCondition().clear();
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_FOLLOWING_LANE_CHANGING:
				getLink_following_laneChanging().clear();
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_COLLISION_SPECIAL_CONDITION:
				getLink_collision_specialCondition().clear();
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_ACTION_BACKWARD:
				getLink_action_backward().clear();
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_ACTION_FORWARD:
				getLink_action_forward().clear();
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_ACTION_TURN:
				getLink_action_turn().clear();
				return;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_KNOWLEDGE_AND_SKILL_DRIVER_PREFERENCE:
				getLink_knowledgeAndSkill_driverPreference().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__DRIVER_PROFILE:
				return driver_profile != null && !driver_profile.isEmpty();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__VEHICLE_CONFIGURATION:
				return vehicle_configuration != null && !vehicle_configuration.isEmpty();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__ENVIRONMENT_BACKGROUND:
				return environment_background != null && !environment_background.isEmpty();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__DRIVER_PREFERENCE:
				return driver_preference != null && !driver_preference.isEmpty();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__KNOWLEDGE_AND_SKILL:
				return knowledge_and_skill != null && !knowledge_and_skill.isEmpty();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__DRIVER_EMOTION:
				return driver_emotion != null && !driver_emotion.isEmpty();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__DRIVING_BEHAVIOUR:
				return driving_behaviour != null && !driving_behaviour.isEmpty();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__NORMAL_BEHAVIOUR:
				return normal_behaviour != null && !normal_behaviour.isEmpty();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__FOLLOWING:
				return following != null && !following.isEmpty();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LANE_CHANGING:
				return lane_changing != null && !lane_changing.isEmpty();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__ABNORMAL_BEHAVIOUR:
				return abnormal_behaviour != null && !abnormal_behaviour.isEmpty();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__FORWARD:
				return forward != null && !forward.isEmpty();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__BACKWARD:
				return backward != null && !backward.isEmpty();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__TURN:
				return turn != null && !turn.isEmpty();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__GAP_ACCEPTANCE:
				return gap_acceptance != null && !gap_acceptance.isEmpty();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__ACTION:
				return action != null && !action.isEmpty();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__VEHICLE_TYPE:
				return vehicle_type != null && !vehicle_type.isEmpty();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__PLATOON:
				return platoon != null && !platoon.isEmpty();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__NORMAL_VEHICLE:
				return normal_vehicle != null && !normal_vehicle.isEmpty();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LEADING_VEHICLE:
				return leading_vehicle != null && !leading_vehicle.isEmpty();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__FOLLOWING_VEHICLE:
				return following_vehicle != null && !following_vehicle.isEmpty();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__PLATOON_MEMBER:
				return platoon_member != null && !platoon_member.isEmpty();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__POSSIBLE_VEHICLE:
				return possible_vehicle != null && !possible_vehicle.isEmpty();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__ENVIRONMENT_CONDITION:
				return environment_condition != null && !environment_condition.isEmpty();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LANE_TYPE:
				return lane_type != null && !lane_type.isEmpty();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__REGULATION:
				return regulation != null && !regulation.isEmpty();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__SAFETY_REQUIREMENT:
				return safety_requirement != null && !safety_requirement.isEmpty();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__WEATHER:
				return weather != null && !weather.isEmpty();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__TRAFFIC_SITUATION:
				return traffic_situation != null && !traffic_situation.isEmpty();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__SPECIAL_CONDITION:
				return special_condition != null && !special_condition.isEmpty();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__COLLISION:
				return collision != null && !collision.isEmpty();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__INTERSECTION:
				return intersection != null && !intersection.isEmpty();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__OBSTRUCTION:
				return obstruction != null && !obstruction.isEmpty();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__TRAFFIC_LIGHT:
				return traffic_light != null && !traffic_light.isEmpty();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__EXECPTION_CONDITION:
				return execption_condition != null && !execption_condition.isEmpty();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_DRIVER_VEHICLE:
				return link_driver_vehicle != null && !link_driver_vehicle.isEmpty();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_DRIVER_ENVIRONMENT:
				return link_driver_environment != null && !link_driver_environment.isEmpty();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_VEHICLE_ENVIRONMENT:
				return link_vehicle_environment != null && !link_vehicle_environment.isEmpty();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_DRIVER_PROFILE_DRIVER_PREFERENCE:
				return link_driverProfile_driverPreference != null && !link_driverProfile_driverPreference.isEmpty();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_VEHICLE_CONFIGURATION_VEHICLE_TYPE:
				return link_vehicleConfiguration_vehicleType != null && !link_vehicleConfiguration_vehicleType.isEmpty();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_ENVIRONMENT_BACKGROUND_POSSIBLE_VEHICLE:
				return link_environmentBackground_possibleVehicle != null && !link_environmentBackground_possibleVehicle.isEmpty();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_ENVIRONMENT_BACKGROUND_ENVIRONMENT_CONDITION:
				return link_environmentBackground_environmentCondition != null && !link_environmentBackground_environmentCondition.isEmpty();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_DRIVER_PREFERENCE_DRIVER_EMOTION:
				return link_driverPreference_driverEmotion != null && !link_driverPreference_driverEmotion.isEmpty();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_DRIVER_PREFERENCE_DRIVING_BEHAVIOUR:
				return link_driverPreference_drivingBehaviour != null && !link_driverPreference_drivingBehaviour.isEmpty();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_DRIVER_PREFERENCE_ENVIRONMENT_CONDITION:
				return link_driverPreference_environmentCondition != null && !link_driverPreference_environmentCondition.isEmpty();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_DRIVING_BEHAVIOUR_NORMAL_BEHAVIOUR:
				return link_drivingBehaviour_normalBehaviour != null && !link_drivingBehaviour_normalBehaviour.isEmpty();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_NORMAL_BEHAVIOUR_FOLLOWING:
				return link_normalBehaviour_following != null && !link_normalBehaviour_following.isEmpty();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_NORMAL_BEHAVIOUR_LANE_CHANGING:
				return link_normalBehaviour_laneChanging != null && !link_normalBehaviour_laneChanging.isEmpty();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_FOLLOWING_MIN_GAP:
				return link_following_minGap != null && !link_following_minGap.isEmpty();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_FOLLOWING_FORWARD:
				return link_following_forward != null && !link_following_forward.isEmpty();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_FOLLOWING_BACKWARD:
				return link_following_backward != null && !link_following_backward.isEmpty();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_LANE_CHANGING_TURN:
				return link_laneChanging_turn != null && !link_laneChanging_turn.isEmpty();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_LANE_CHANGING_GAP_ACCEPTANCE:
				return link_laneChanging_gapAcceptance != null && !link_laneChanging_gapAcceptance.isEmpty();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_LANE_CHANGING_ENVIRONMENT_CONDITION:
				return link_laneChanging_environmentCondition != null && !link_laneChanging_environmentCondition.isEmpty();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_ABNORMAL_BEHAVIOUR_ACTION:
				return link_abnormalBehaviour_action != null && !link_abnormalBehaviour_action.isEmpty();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_PLATOON_LEADING_VEHICLE:
				return link_platoon_leadingVehicle != null && !link_platoon_leadingVehicle.isEmpty();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_PLATOON_FOLLOWING_VEHICLE:
				return link_platoon_followingVehicle != null && !link_platoon_followingVehicle.isEmpty();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_NORMAL_VEHICLE_SAFETY_REQUIREMENT:
				return link_normalVehicle_safetyRequirement != null && !link_normalVehicle_safetyRequirement.isEmpty();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_FOLLOWING_VEHICLE_FRONT_VEHICLE:
				return link_followingVehicle_frontVehicle != null && !link_followingVehicle_frontVehicle.isEmpty();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_ENVIRONMENT_CONDITION_LANE_TYPE:
				return link_environmentCondition_laneType != null && !link_environmentCondition_laneType.isEmpty();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_ENVIRONMENT_CONDITION_REGULATION:
				return link_environmentCondition_regulation != null && !link_environmentCondition_regulation.isEmpty();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_ENVIRONMENT_CONDITION_WEATHER:
				return link_environmentCondition_weather != null && !link_environmentCondition_weather.isEmpty();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_ENVIRONMENT_CONDITION_TRAFFIC_CONDITION:
				return link_environmentCondition_trafficCondition != null && !link_environmentCondition_trafficCondition.isEmpty();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_ENVIRONMENT_CONDITION_SPECIAL_CONDITION:
				return link_environmentCondition_specialCondition != null && !link_environmentCondition_specialCondition.isEmpty();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_LANE_TYPE_REGULATION:
				return link_laneType_regulation != null && !link_laneType_regulation.isEmpty();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_SAFETY_REQUIREMENT_REGULATION:
				return link_safetyRequirement_regulation != null && !link_safetyRequirement_regulation.isEmpty();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_SPECIAL_CONDITION_INTERSECTION:
				return link_specialCondition_intersection != null && !link_specialCondition_intersection.isEmpty();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_COLLISION_OBSTRUCTION:
				return link_collision_obstruction != null && !link_collision_obstruction.isEmpty();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_INTERSECTION_TRAFFIC_LIGHT:
				return link_intersection_trafficLight != null && !link_intersection_trafficLight.isEmpty();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__SYSTEM_ID:
				return systemID != SYSTEM_ID_EDEFAULT;
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__GEOGRAPHICAL_SCOPE:
				return GEOGRAPHICAL_SCOPE_EDEFAULT == null ? geographicalScope != null : !GEOGRAPHICAL_SCOPE_EDEFAULT.equals(geographicalScope);
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__INFRASTRUCTURE_TYPE:
				return INFRASTRUCTURE_TYPE_EDEFAULT == null ? infrastructureType != null : !INFRASTRUCTURE_TYPE_EDEFAULT.equals(infrastructureType);
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__INFRASTRUCTURE:
				return infrastructure != null && !infrastructure.isEmpty();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__COMMUNICATION_INTERFACES:
				return communicationInterfaces != null && !communicationInterfaces.isEmpty();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__GOAL:
				return goal != null && !goal.isEmpty();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_INFRASTRUCTURE_VEHICLE_CONFIGURATION:
				return link_infrastructure_vehicle_configuration != null && !link_infrastructure_vehicle_configuration.isEmpty();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_COMMUNICATION_INTERFACE_VEHICLE_CONFIGURATION:
				return link_communicationInterface_vehicleConfiguration != null && !link_communicationInterface_vehicleConfiguration.isEmpty();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_COMMUNICATION_INTERFACE_INFRASTRUCTURE:
				return link_communicationInterface_infrastructure != null && !link_communicationInterface_infrastructure.isEmpty();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_GOAL_DRIVING_BEHAVIOUR:
				return link_goal_drivingBehaviour != null && !link_goal_drivingBehaviour.isEmpty();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__COOPERATIVE_BEHAVIOUR:
				return cooperativeBehaviour != null && !cooperativeBehaviour.isEmpty();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_COOPERATIVE_BEHAVIOUR_COMMUNICATION_INTERFACE:
				return link_cooperativeBehaviour_communicationInterface != null && !link_cooperativeBehaviour_communicationInterface.isEmpty();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_COOPERATIVE_BEHAVIOUR_VEHICLE_CONFIGURATION:
				return link_cooperativeBehaviour_vehicleConfiguration != null && !link_cooperativeBehaviour_vehicleConfiguration.isEmpty();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_TRAFFIC_SITUATION_ENVIRONMENT_CONDITION:
				return link_trafficSituation_environmentCondition != null && !link_trafficSituation_environmentCondition.isEmpty();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_FOLLOWING_LANE_CHANGING:
				return link_following_laneChanging != null && !link_following_laneChanging.isEmpty();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_COLLISION_SPECIAL_CONDITION:
				return link_collision_specialCondition != null && !link_collision_specialCondition.isEmpty();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_ACTION_BACKWARD:
				return link_action_backward != null && !link_action_backward.isEmpty();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_ACTION_FORWARD:
				return link_action_forward != null && !link_action_forward.isEmpty();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_ACTION_TURN:
				return link_action_turn != null && !link_action_turn.isEmpty();
			case IntelligentMobilityPackage.MOBILITY_SYSTEM__LINK_KNOWLEDGE_AND_SKILL_DRIVER_PREFERENCE:
				return link_knowledgeAndSkill_driverPreference != null && !link_knowledgeAndSkill_driverPreference.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (systemID: ");
		result.append(systemID);
		result.append(", geographicalScope: ");
		result.append(geographicalScope);
		result.append(", infrastructureType: ");
		result.append(infrastructureType);
		result.append(')');
		return result.toString();
	}

} //MobilitySystemImpl
