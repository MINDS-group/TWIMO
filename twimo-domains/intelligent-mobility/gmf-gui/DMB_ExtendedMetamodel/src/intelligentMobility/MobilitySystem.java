/**
 */
package intelligentMobility;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mobility System</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.MobilitySystem#getDriver_profile <em>Driver profile</em>}</li>
 *   <li>{@link intelligentMobility.MobilitySystem#getVehicle_configuration <em>Vehicle configuration</em>}</li>
 *   <li>{@link intelligentMobility.MobilitySystem#getEnvironment_background <em>Environment background</em>}</li>
 *   <li>{@link intelligentMobility.MobilitySystem#getDriver_preference <em>Driver preference</em>}</li>
 *   <li>{@link intelligentMobility.MobilitySystem#getKnowledge_and_skill <em>Knowledge and skill</em>}</li>
 *   <li>{@link intelligentMobility.MobilitySystem#getDriver_emotion <em>Driver emotion</em>}</li>
 *   <li>{@link intelligentMobility.MobilitySystem#getDriving_behaviour <em>Driving behaviour</em>}</li>
 *   <li>{@link intelligentMobility.MobilitySystem#getNormal_behaviour <em>Normal behaviour</em>}</li>
 *   <li>{@link intelligentMobility.MobilitySystem#getFollowing <em>Following</em>}</li>
 *   <li>{@link intelligentMobility.MobilitySystem#getLane_changing <em>Lane changing</em>}</li>
 *   <li>{@link intelligentMobility.MobilitySystem#getAbnormal_behaviour <em>Abnormal behaviour</em>}</li>
 *   <li>{@link intelligentMobility.MobilitySystem#getForward <em>Forward</em>}</li>
 *   <li>{@link intelligentMobility.MobilitySystem#getBackward <em>Backward</em>}</li>
 *   <li>{@link intelligentMobility.MobilitySystem#getTurn <em>Turn</em>}</li>
 *   <li>{@link intelligentMobility.MobilitySystem#getGap_acceptance <em>Gap acceptance</em>}</li>
 *   <li>{@link intelligentMobility.MobilitySystem#getAction <em>Action</em>}</li>
 *   <li>{@link intelligentMobility.MobilitySystem#getVehicle_type <em>Vehicle type</em>}</li>
 *   <li>{@link intelligentMobility.MobilitySystem#getPlatoon <em>Platoon</em>}</li>
 *   <li>{@link intelligentMobility.MobilitySystem#getNormal_vehicle <em>Normal vehicle</em>}</li>
 *   <li>{@link intelligentMobility.MobilitySystem#getLeading_vehicle <em>Leading vehicle</em>}</li>
 *   <li>{@link intelligentMobility.MobilitySystem#getFollowing_vehicle <em>Following vehicle</em>}</li>
 *   <li>{@link intelligentMobility.MobilitySystem#getPlatoon_member <em>Platoon member</em>}</li>
 *   <li>{@link intelligentMobility.MobilitySystem#getPossible_vehicle <em>Possible vehicle</em>}</li>
 *   <li>{@link intelligentMobility.MobilitySystem#getEnvironment_condition <em>Environment condition</em>}</li>
 *   <li>{@link intelligentMobility.MobilitySystem#getLane_type <em>Lane type</em>}</li>
 *   <li>{@link intelligentMobility.MobilitySystem#getRegulation <em>Regulation</em>}</li>
 *   <li>{@link intelligentMobility.MobilitySystem#getSafety_requirement <em>Safety requirement</em>}</li>
 *   <li>{@link intelligentMobility.MobilitySystem#getWeather <em>Weather</em>}</li>
 *   <li>{@link intelligentMobility.MobilitySystem#getTraffic_situation <em>Traffic situation</em>}</li>
 *   <li>{@link intelligentMobility.MobilitySystem#getSpecial_condition <em>Special condition</em>}</li>
 *   <li>{@link intelligentMobility.MobilitySystem#getCollision <em>Collision</em>}</li>
 *   <li>{@link intelligentMobility.MobilitySystem#getIntersection <em>Intersection</em>}</li>
 *   <li>{@link intelligentMobility.MobilitySystem#getObstruction <em>Obstruction</em>}</li>
 *   <li>{@link intelligentMobility.MobilitySystem#getTraffic_light <em>Traffic light</em>}</li>
 *   <li>{@link intelligentMobility.MobilitySystem#getExecption_condition <em>Execption condition</em>}</li>
 *   <li>{@link intelligentMobility.MobilitySystem#getLink_driver_vehicle <em>Link driver vehicle</em>}</li>
 *   <li>{@link intelligentMobility.MobilitySystem#getLink_driver_environment <em>Link driver environment</em>}</li>
 *   <li>{@link intelligentMobility.MobilitySystem#getLink_vehicle_environment <em>Link vehicle environment</em>}</li>
 *   <li>{@link intelligentMobility.MobilitySystem#getLink_driverProfile_driverPreference <em>Link driver Profile driver Preference</em>}</li>
 *   <li>{@link intelligentMobility.MobilitySystem#getLink_vehicleConfiguration_vehicleType <em>Link vehicle Configuration vehicle Type</em>}</li>
 *   <li>{@link intelligentMobility.MobilitySystem#getLink_environmentBackground_possibleVehicle <em>Link environment Background possible Vehicle</em>}</li>
 *   <li>{@link intelligentMobility.MobilitySystem#getLink_environmentBackground_environmentCondition <em>Link environment Background environment Condition</em>}</li>
 *   <li>{@link intelligentMobility.MobilitySystem#getLink_driverPreference_driverEmotion <em>Link driver Preference driver Emotion</em>}</li>
 *   <li>{@link intelligentMobility.MobilitySystem#getLink_driverPreference_drivingBehaviour <em>Link driver Preference driving Behaviour</em>}</li>
 *   <li>{@link intelligentMobility.MobilitySystem#getLink_driverPreference_environmentCondition <em>Link driver Preference environment Condition</em>}</li>
 *   <li>{@link intelligentMobility.MobilitySystem#getLink_drivingBehaviour_normalBehaviour <em>Link driving Behaviour normal Behaviour</em>}</li>
 *   <li>{@link intelligentMobility.MobilitySystem#getLink_normalBehaviour_following <em>Link normal Behaviour following</em>}</li>
 *   <li>{@link intelligentMobility.MobilitySystem#getLink_normalBehaviour_laneChanging <em>Link normal Behaviour lane Changing</em>}</li>
 *   <li>{@link intelligentMobility.MobilitySystem#getLink_following_minGap <em>Link following min Gap</em>}</li>
 *   <li>{@link intelligentMobility.MobilitySystem#getLink_following_forward <em>Link following forward</em>}</li>
 *   <li>{@link intelligentMobility.MobilitySystem#getLink_following_backward <em>Link following backward</em>}</li>
 *   <li>{@link intelligentMobility.MobilitySystem#getLink_laneChanging_turn <em>Link lane Changing turn</em>}</li>
 *   <li>{@link intelligentMobility.MobilitySystem#getLink_laneChanging_gapAcceptance <em>Link lane Changing gap Acceptance</em>}</li>
 *   <li>{@link intelligentMobility.MobilitySystem#getLink_laneChanging_environmentCondition <em>Link lane Changing environment Condition</em>}</li>
 *   <li>{@link intelligentMobility.MobilitySystem#getLink_abnormalBehaviour_action <em>Link abnormal Behaviour action</em>}</li>
 *   <li>{@link intelligentMobility.MobilitySystem#getLink_platoon_leadingVehicle <em>Link platoon leading Vehicle</em>}</li>
 *   <li>{@link intelligentMobility.MobilitySystem#getLink_platoon_followingVehicle <em>Link platoon following Vehicle</em>}</li>
 *   <li>{@link intelligentMobility.MobilitySystem#getLink_normalVehicle_safetyRequirement <em>Link normal Vehicle safety Requirement</em>}</li>
 *   <li>{@link intelligentMobility.MobilitySystem#getLink_followingVehicle_frontVehicle <em>Link following Vehicle front Vehicle</em>}</li>
 *   <li>{@link intelligentMobility.MobilitySystem#getLink_environmentCondition_laneType <em>Link environment Condition lane Type</em>}</li>
 *   <li>{@link intelligentMobility.MobilitySystem#getLink_environmentCondition_regulation <em>Link environment Condition regulation</em>}</li>
 *   <li>{@link intelligentMobility.MobilitySystem#getLink_environmentCondition_weather <em>Link environment Condition weather</em>}</li>
 *   <li>{@link intelligentMobility.MobilitySystem#getLink_environmentCondition_trafficCondition <em>Link environment Condition traffic Condition</em>}</li>
 *   <li>{@link intelligentMobility.MobilitySystem#getLink_environmentCondition_specialCondition <em>Link environment Condition special Condition</em>}</li>
 *   <li>{@link intelligentMobility.MobilitySystem#getLink_laneType_regulation <em>Link lane Type regulation</em>}</li>
 *   <li>{@link intelligentMobility.MobilitySystem#getLink_safetyRequirement_regulation <em>Link safety Requirement regulation</em>}</li>
 *   <li>{@link intelligentMobility.MobilitySystem#getLink_specialCondition_intersection <em>Link special Condition intersection</em>}</li>
 *   <li>{@link intelligentMobility.MobilitySystem#getLink_collision_obstruction <em>Link collision obstruction</em>}</li>
 *   <li>{@link intelligentMobility.MobilitySystem#getLink_intersection_trafficLight <em>Link intersection traffic Light</em>}</li>
 *   <li>{@link intelligentMobility.MobilitySystem#getSystemID <em>System ID</em>}</li>
 *   <li>{@link intelligentMobility.MobilitySystem#getGeographicalScope <em>Geographical Scope</em>}</li>
 *   <li>{@link intelligentMobility.MobilitySystem#getInfrastructureType <em>Infrastructure Type</em>}</li>
 *   <li>{@link intelligentMobility.MobilitySystem#getInfrastructure <em>Infrastructure</em>}</li>
 *   <li>{@link intelligentMobility.MobilitySystem#getCommunicationInterfaces <em>Communication Interfaces</em>}</li>
 *   <li>{@link intelligentMobility.MobilitySystem#getGoal <em>Goal</em>}</li>
 *   <li>{@link intelligentMobility.MobilitySystem#getLink_infrastructure_vehicle_configuration <em>Link infrastructure vehicle configuration</em>}</li>
 *   <li>{@link intelligentMobility.MobilitySystem#getLink_communicationInterface_vehicleConfiguration <em>Link communication Interface vehicle Configuration</em>}</li>
 *   <li>{@link intelligentMobility.MobilitySystem#getLink_communicationInterface_infrastructure <em>Link communication Interface infrastructure</em>}</li>
 *   <li>{@link intelligentMobility.MobilitySystem#getLink_goal_drivingBehaviour <em>Link goal driving Behaviour</em>}</li>
 *   <li>{@link intelligentMobility.MobilitySystem#getCooperativeBehaviour <em>Cooperative Behaviour</em>}</li>
 *   <li>{@link intelligentMobility.MobilitySystem#getLink_cooperativeBehaviour_communicationInterface <em>Link cooperative Behaviour communication Interface</em>}</li>
 *   <li>{@link intelligentMobility.MobilitySystem#getLink_cooperativeBehaviour_vehicleConfiguration <em>Link cooperative Behaviour vehicle Configuration</em>}</li>
 *   <li>{@link intelligentMobility.MobilitySystem#getLink_trafficSituation_environmentCondition <em>Link traffic Situation environment Condition</em>}</li>
 *   <li>{@link intelligentMobility.MobilitySystem#getLink_following_laneChanging <em>Link following lane Changing</em>}</li>
 *   <li>{@link intelligentMobility.MobilitySystem#getLink_collision_specialCondition <em>Link collision special Condition</em>}</li>
 *   <li>{@link intelligentMobility.MobilitySystem#getLink_action_backward <em>Link action backward</em>}</li>
 *   <li>{@link intelligentMobility.MobilitySystem#getLink_action_forward <em>Link action forward</em>}</li>
 *   <li>{@link intelligentMobility.MobilitySystem#getLink_action_turn <em>Link action turn</em>}</li>
 *   <li>{@link intelligentMobility.MobilitySystem#getLink_knowledgeAndSkill_driverPreference <em>Link knowledge And Skill driver Preference</em>}</li>
 * </ul>
 *
 * @see intelligentMobility.IntelligentMobilityPackage#getMobilitySystem()
 * @model
 * @generated
 */
public interface MobilitySystem extends EObject {
	/**
	 * Returns the value of the '<em><b>Driver profile</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Driver_Profile}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Driver profile</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getMobilitySystem_Driver_profile()
	 * @model type="intelligentMobility.Driver_Profile" containment="true" required="true"
	 * @generated
	 */
	EList getDriver_profile();

	/**
	 * Returns the value of the '<em><b>Vehicle configuration</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Vehicle_Configuration}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vehicle configuration</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getMobilitySystem_Vehicle_configuration()
	 * @model type="intelligentMobility.Vehicle_Configuration" containment="true" required="true"
	 * @generated
	 */
	EList getVehicle_configuration();

	/**
	 * Returns the value of the '<em><b>Environment background</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Environment_Background}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Environment background</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getMobilitySystem_Environment_background()
	 * @model type="intelligentMobility.Environment_Background" containment="true" required="true"
	 * @generated
	 */
	EList getEnvironment_background();

	/**
	 * Returns the value of the '<em><b>Driver preference</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Driver_Preference}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Driver preference</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getMobilitySystem_Driver_preference()
	 * @model type="intelligentMobility.Driver_Preference" containment="true" required="true"
	 * @generated
	 */
	EList getDriver_preference();

	/**
	 * Returns the value of the '<em><b>Knowledge and skill</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Knowledge_and_Skill}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Knowledge and skill</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getMobilitySystem_Knowledge_and_skill()
	 * @model type="intelligentMobility.Knowledge_and_Skill" containment="true" required="true"
	 * @generated
	 */
	EList getKnowledge_and_skill();

	/**
	 * Returns the value of the '<em><b>Driver emotion</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Driver_Emotion}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Driver emotion</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getMobilitySystem_Driver_emotion()
	 * @model type="intelligentMobility.Driver_Emotion" containment="true" required="true"
	 * @generated
	 */
	EList getDriver_emotion();

	/**
	 * Returns the value of the '<em><b>Driving behaviour</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Driving_Behaviour}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Driving behaviour</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getMobilitySystem_Driving_behaviour()
	 * @model type="intelligentMobility.Driving_Behaviour" containment="true" required="true"
	 * @generated
	 */
	EList getDriving_behaviour();

	/**
	 * Returns the value of the '<em><b>Normal behaviour</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Normal_Behaviour}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Normal behaviour</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getMobilitySystem_Normal_behaviour()
	 * @model type="intelligentMobility.Normal_Behaviour" containment="true" required="true"
	 * @generated
	 */
	EList getNormal_behaviour();

	/**
	 * Returns the value of the '<em><b>Following</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Following}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Following</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getMobilitySystem_Following()
	 * @model type="intelligentMobility.Following" containment="true" required="true"
	 * @generated
	 */
	EList getFollowing();

	/**
	 * Returns the value of the '<em><b>Lane changing</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.LaneChanging}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lane changing</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getMobilitySystem_Lane_changing()
	 * @model type="intelligentMobility.LaneChanging" containment="true" required="true"
	 * @generated
	 */
	EList getLane_changing();

	/**
	 * Returns the value of the '<em><b>Abnormal behaviour</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Abnormal_Behaviour}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Abnormal behaviour</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getMobilitySystem_Abnormal_behaviour()
	 * @model type="intelligentMobility.Abnormal_Behaviour" containment="true" required="true"
	 * @generated
	 */
	EList getAbnormal_behaviour();

	/**
	 * Returns the value of the '<em><b>Forward</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Forward}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Forward</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getMobilitySystem_Forward()
	 * @model type="intelligentMobility.Forward" containment="true" required="true"
	 * @generated
	 */
	EList getForward();

	/**
	 * Returns the value of the '<em><b>Backward</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Backward}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Backward</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getMobilitySystem_Backward()
	 * @model type="intelligentMobility.Backward" containment="true" required="true"
	 * @generated
	 */
	EList getBackward();

	/**
	 * Returns the value of the '<em><b>Turn</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Turn}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Turn</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getMobilitySystem_Turn()
	 * @model type="intelligentMobility.Turn" containment="true" required="true"
	 * @generated
	 */
	EList getTurn();

	/**
	 * Returns the value of the '<em><b>Gap acceptance</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.GapAcceptance}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gap acceptance</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getMobilitySystem_Gap_acceptance()
	 * @model type="intelligentMobility.GapAcceptance" containment="true" required="true"
	 * @generated
	 */
	EList getGap_acceptance();

	/**
	 * Returns the value of the '<em><b>Action</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Action}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getMobilitySystem_Action()
	 * @model type="intelligentMobility.Action" containment="true" required="true"
	 * @generated
	 */
	EList getAction();

	/**
	 * Returns the value of the '<em><b>Vehicle type</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Vehicle_Type}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vehicle type</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getMobilitySystem_Vehicle_type()
	 * @model type="intelligentMobility.Vehicle_Type" containment="true" required="true"
	 * @generated
	 */
	EList getVehicle_type();

	/**
	 * Returns the value of the '<em><b>Platoon</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Platoon}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Platoon</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getMobilitySystem_Platoon()
	 * @model type="intelligentMobility.Platoon" containment="true" required="true"
	 * @generated
	 */
	EList getPlatoon();

	/**
	 * Returns the value of the '<em><b>Normal vehicle</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Normal_Vehicle}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Normal vehicle</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getMobilitySystem_Normal_vehicle()
	 * @model type="intelligentMobility.Normal_Vehicle" containment="true" required="true"
	 * @generated
	 */
	EList getNormal_vehicle();

	/**
	 * Returns the value of the '<em><b>Leading vehicle</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Leading_Vehicle}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Leading vehicle</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getMobilitySystem_Leading_vehicle()
	 * @model type="intelligentMobility.Leading_Vehicle" containment="true" required="true"
	 * @generated
	 */
	EList getLeading_vehicle();

	/**
	 * Returns the value of the '<em><b>Following vehicle</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Following_Vehicle}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Following vehicle</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getMobilitySystem_Following_vehicle()
	 * @model type="intelligentMobility.Following_Vehicle" containment="true" required="true"
	 * @generated
	 */
	EList getFollowing_vehicle();

	/**
	 * Returns the value of the '<em><b>Platoon member</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.PlatoonMember}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Platoon member</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getMobilitySystem_Platoon_member()
	 * @model type="intelligentMobility.PlatoonMember" containment="true" required="true"
	 * @generated
	 */
	EList getPlatoon_member();

	/**
	 * Returns the value of the '<em><b>Possible vehicle</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.PossibleVehicle}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Possible vehicle</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getMobilitySystem_Possible_vehicle()
	 * @model type="intelligentMobility.PossibleVehicle" containment="true" required="true"
	 * @generated
	 */
	EList getPossible_vehicle();

	/**
	 * Returns the value of the '<em><b>Environment condition</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Environment_Condition}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Environment condition</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getMobilitySystem_Environment_condition()
	 * @model type="intelligentMobility.Environment_Condition" containment="true" required="true"
	 * @generated
	 */
	EList getEnvironment_condition();

	/**
	 * Returns the value of the '<em><b>Lane type</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Lane_Type}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lane type</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getMobilitySystem_Lane_type()
	 * @model type="intelligentMobility.Lane_Type" containment="true" required="true"
	 * @generated
	 */
	EList getLane_type();

	/**
	 * Returns the value of the '<em><b>Regulation</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Regulation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Regulation</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getMobilitySystem_Regulation()
	 * @model type="intelligentMobility.Regulation" containment="true" required="true"
	 * @generated
	 */
	EList getRegulation();

	/**
	 * Returns the value of the '<em><b>Safety requirement</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Safety_Requirement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Safety requirement</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getMobilitySystem_Safety_requirement()
	 * @model type="intelligentMobility.Safety_Requirement" containment="true" required="true"
	 * @generated
	 */
	EList getSafety_requirement();

	/**
	 * Returns the value of the '<em><b>Weather</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Weather}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Weather</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getMobilitySystem_Weather()
	 * @model type="intelligentMobility.Weather" containment="true" required="true"
	 * @generated
	 */
	EList getWeather();

	/**
	 * Returns the value of the '<em><b>Traffic situation</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Traffic_Situation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Traffic situation</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getMobilitySystem_Traffic_situation()
	 * @model type="intelligentMobility.Traffic_Situation" containment="true" required="true"
	 * @generated
	 */
	EList getTraffic_situation();

	/**
	 * Returns the value of the '<em><b>Special condition</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Special_Condition}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Special condition</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getMobilitySystem_Special_condition()
	 * @model type="intelligentMobility.Special_Condition" containment="true" required="true"
	 * @generated
	 */
	EList getSpecial_condition();

	/**
	 * Returns the value of the '<em><b>Collision</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Collision}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Collision</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getMobilitySystem_Collision()
	 * @model type="intelligentMobility.Collision" containment="true" required="true"
	 * @generated
	 */
	EList getCollision();

	/**
	 * Returns the value of the '<em><b>Intersection</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Intersection}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Intersection</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getMobilitySystem_Intersection()
	 * @model type="intelligentMobility.Intersection" containment="true" required="true"
	 * @generated
	 */
	EList getIntersection();

	/**
	 * Returns the value of the '<em><b>Obstruction</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Obstruction}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Obstruction</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getMobilitySystem_Obstruction()
	 * @model type="intelligentMobility.Obstruction" containment="true" required="true"
	 * @generated
	 */
	EList getObstruction();

	/**
	 * Returns the value of the '<em><b>Traffic light</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Traffic_Light}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Traffic light</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getMobilitySystem_Traffic_light()
	 * @model type="intelligentMobility.Traffic_Light" containment="true" required="true"
	 * @generated
	 */
	EList getTraffic_light();

	/**
	 * Returns the value of the '<em><b>Execption condition</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.ExceptionCondition}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Execption condition</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getMobilitySystem_Execption_condition()
	 * @model type="intelligentMobility.ExceptionCondition" containment="true" required="true"
	 * @generated
	 */
	EList getExecption_condition();

	/**
	 * Returns the value of the '<em><b>Link driver vehicle</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Link_Driver_Vehicle}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link driver vehicle</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getMobilitySystem_Link_driver_vehicle()
	 * @model type="intelligentMobility.Link_Driver_Vehicle" containment="true"
	 * @generated
	 */
	EList getLink_driver_vehicle();

	/**
	 * Returns the value of the '<em><b>Link driver environment</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Link_Driver_Environment}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link driver environment</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getMobilitySystem_Link_driver_environment()
	 * @model type="intelligentMobility.Link_Driver_Environment" containment="true"
	 * @generated
	 */
	EList getLink_driver_environment();

	/**
	 * Returns the value of the '<em><b>Link vehicle environment</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Link_Vehicle_Environment}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link vehicle environment</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getMobilitySystem_Link_vehicle_environment()
	 * @model type="intelligentMobility.Link_Vehicle_Environment" containment="true"
	 * @generated
	 */
	EList getLink_vehicle_environment();

	/**
	 * Returns the value of the '<em><b>Link driver Profile driver Preference</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Link_DriverProfile_DriverPreference}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link driver Profile driver Preference</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getMobilitySystem_Link_driverProfile_driverPreference()
	 * @model type="intelligentMobility.Link_DriverProfile_DriverPreference" containment="true"
	 * @generated
	 */
	EList getLink_driverProfile_driverPreference();

	/**
	 * Returns the value of the '<em><b>Link vehicle Configuration vehicle Type</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Link_VehicleConfiguration_VehicleType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link vehicle Configuration vehicle Type</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getMobilitySystem_Link_vehicleConfiguration_vehicleType()
	 * @model type="intelligentMobility.Link_VehicleConfiguration_VehicleType" containment="true"
	 * @generated
	 */
	EList getLink_vehicleConfiguration_vehicleType();

	/**
	 * Returns the value of the '<em><b>Link environment Background possible Vehicle</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Link_EnvironmentBackground_PossibleVehicle}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link environment Background possible Vehicle</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getMobilitySystem_Link_environmentBackground_possibleVehicle()
	 * @model type="intelligentMobility.Link_EnvironmentBackground_PossibleVehicle" containment="true"
	 * @generated
	 */
	EList getLink_environmentBackground_possibleVehicle();

	/**
	 * Returns the value of the '<em><b>Link environment Background environment Condition</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Link_EnvironmentBackground_EnvironmentCondition}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link environment Background environment Condition</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getMobilitySystem_Link_environmentBackground_environmentCondition()
	 * @model type="intelligentMobility.Link_EnvironmentBackground_EnvironmentCondition" containment="true"
	 * @generated
	 */
	EList getLink_environmentBackground_environmentCondition();

	/**
	 * Returns the value of the '<em><b>Link driver Preference driver Emotion</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Link_DriverPreference_DriverEmotion}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link driver Preference driver Emotion</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getMobilitySystem_Link_driverPreference_driverEmotion()
	 * @model type="intelligentMobility.Link_DriverPreference_DriverEmotion" containment="true"
	 * @generated
	 */
	EList getLink_driverPreference_driverEmotion();

	/**
	 * Returns the value of the '<em><b>Link driver Preference driving Behaviour</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Link_DriverPreference_DrivingBehaviour}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link driver Preference driving Behaviour</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getMobilitySystem_Link_driverPreference_drivingBehaviour()
	 * @model type="intelligentMobility.Link_DriverPreference_DrivingBehaviour" containment="true"
	 * @generated
	 */
	EList getLink_driverPreference_drivingBehaviour();

	/**
	 * Returns the value of the '<em><b>Link driver Preference environment Condition</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Link_DriverPreference_EnvironmentCondition}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link driver Preference environment Condition</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getMobilitySystem_Link_driverPreference_environmentCondition()
	 * @model type="intelligentMobility.Link_DriverPreference_EnvironmentCondition" containment="true"
	 * @generated
	 */
	EList getLink_driverPreference_environmentCondition();

	/**
	 * Returns the value of the '<em><b>Link driving Behaviour normal Behaviour</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Link_DrivingBehaviour_NormalBehaviour}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link driving Behaviour normal Behaviour</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getMobilitySystem_Link_drivingBehaviour_normalBehaviour()
	 * @model type="intelligentMobility.Link_DrivingBehaviour_NormalBehaviour" containment="true"
	 * @generated
	 */
	EList getLink_drivingBehaviour_normalBehaviour();

	/**
	 * Returns the value of the '<em><b>Link normal Behaviour following</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Link_NormalBehaviour_Following}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link normal Behaviour following</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getMobilitySystem_Link_normalBehaviour_following()
	 * @model type="intelligentMobility.Link_NormalBehaviour_Following" containment="true"
	 * @generated
	 */
	EList getLink_normalBehaviour_following();

	/**
	 * Returns the value of the '<em><b>Link normal Behaviour lane Changing</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Link_NormalBehaviour_LaneChanging}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link normal Behaviour lane Changing</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getMobilitySystem_Link_normalBehaviour_laneChanging()
	 * @model type="intelligentMobility.Link_NormalBehaviour_LaneChanging" containment="true"
	 * @generated
	 */
	EList getLink_normalBehaviour_laneChanging();

	/**
	 * Returns the value of the '<em><b>Link following min Gap</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Link_Following_MinGap}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link following min Gap</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getMobilitySystem_Link_following_minGap()
	 * @model type="intelligentMobility.Link_Following_MinGap" containment="true"
	 * @generated
	 */
	EList getLink_following_minGap();

	/**
	 * Returns the value of the '<em><b>Link following forward</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Link_Following_Forward}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link following forward</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getMobilitySystem_Link_following_forward()
	 * @model type="intelligentMobility.Link_Following_Forward" containment="true"
	 * @generated
	 */
	EList getLink_following_forward();

	/**
	 * Returns the value of the '<em><b>Link following backward</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Link_Following_Backward}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link following backward</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getMobilitySystem_Link_following_backward()
	 * @model type="intelligentMobility.Link_Following_Backward" containment="true"
	 * @generated
	 */
	EList getLink_following_backward();

	/**
	 * Returns the value of the '<em><b>Link lane Changing turn</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Link_LaneChanging_Turn}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link lane Changing turn</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getMobilitySystem_Link_laneChanging_turn()
	 * @model type="intelligentMobility.Link_LaneChanging_Turn" containment="true"
	 * @generated
	 */
	EList getLink_laneChanging_turn();

	/**
	 * Returns the value of the '<em><b>Link lane Changing gap Acceptance</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Link_LaneChanging_GapAcceptance}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link lane Changing gap Acceptance</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getMobilitySystem_Link_laneChanging_gapAcceptance()
	 * @model type="intelligentMobility.Link_LaneChanging_GapAcceptance" containment="true"
	 * @generated
	 */
	EList getLink_laneChanging_gapAcceptance();

	/**
	 * Returns the value of the '<em><b>Link lane Changing environment Condition</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Link_LaneChanging_EnvironmentCondition}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link lane Changing environment Condition</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getMobilitySystem_Link_laneChanging_environmentCondition()
	 * @model type="intelligentMobility.Link_LaneChanging_EnvironmentCondition" containment="true"
	 * @generated
	 */
	EList getLink_laneChanging_environmentCondition();

	/**
	 * Returns the value of the '<em><b>Link abnormal Behaviour action</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Link_AbnormalBehaviour_Action}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link abnormal Behaviour action</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getMobilitySystem_Link_abnormalBehaviour_action()
	 * @model type="intelligentMobility.Link_AbnormalBehaviour_Action" containment="true"
	 * @generated
	 */
	EList getLink_abnormalBehaviour_action();

	/**
	 * Returns the value of the '<em><b>Link platoon leading Vehicle</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Link_Platoon_LeadingVehicle}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link platoon leading Vehicle</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getMobilitySystem_Link_platoon_leadingVehicle()
	 * @model type="intelligentMobility.Link_Platoon_LeadingVehicle" containment="true"
	 * @generated
	 */
	EList getLink_platoon_leadingVehicle();

	/**
	 * Returns the value of the '<em><b>Link platoon following Vehicle</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Link_Platoon_FollowingVehicle}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link platoon following Vehicle</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getMobilitySystem_Link_platoon_followingVehicle()
	 * @model type="intelligentMobility.Link_Platoon_FollowingVehicle" containment="true"
	 * @generated
	 */
	EList getLink_platoon_followingVehicle();

	/**
	 * Returns the value of the '<em><b>Link normal Vehicle safety Requirement</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Link_NormalVehicle_SafetyRequirements}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link normal Vehicle safety Requirement</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getMobilitySystem_Link_normalVehicle_safetyRequirement()
	 * @model type="intelligentMobility.Link_NormalVehicle_SafetyRequirements" containment="true"
	 * @generated
	 */
	EList getLink_normalVehicle_safetyRequirement();

	/**
	 * Returns the value of the '<em><b>Link following Vehicle front Vehicle</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Link_FollowingVehicle_FrontVehicle}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link following Vehicle front Vehicle</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getMobilitySystem_Link_followingVehicle_frontVehicle()
	 * @model type="intelligentMobility.Link_FollowingVehicle_FrontVehicle" containment="true"
	 * @generated
	 */
	EList getLink_followingVehicle_frontVehicle();

	/**
	 * Returns the value of the '<em><b>Link environment Condition lane Type</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Link_EnvironmentCondition_LaneType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link environment Condition lane Type</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getMobilitySystem_Link_environmentCondition_laneType()
	 * @model type="intelligentMobility.Link_EnvironmentCondition_LaneType" containment="true"
	 * @generated
	 */
	EList getLink_environmentCondition_laneType();

	/**
	 * Returns the value of the '<em><b>Link environment Condition regulation</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Link_EnvironmentCondition_Regulations}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link environment Condition regulation</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getMobilitySystem_Link_environmentCondition_regulation()
	 * @model type="intelligentMobility.Link_EnvironmentCondition_Regulations" containment="true"
	 * @generated
	 */
	EList getLink_environmentCondition_regulation();

	/**
	 * Returns the value of the '<em><b>Link environment Condition weather</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Link_EnvironmentCondition_Weather}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link environment Condition weather</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getMobilitySystem_Link_environmentCondition_weather()
	 * @model type="intelligentMobility.Link_EnvironmentCondition_Weather" containment="true"
	 * @generated
	 */
	EList getLink_environmentCondition_weather();

	/**
	 * Returns the value of the '<em><b>Link environment Condition traffic Condition</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Link_EnvironmentCondition_TrafficCondition}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link environment Condition traffic Condition</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getMobilitySystem_Link_environmentCondition_trafficCondition()
	 * @model type="intelligentMobility.Link_EnvironmentCondition_TrafficCondition" containment="true"
	 * @generated
	 */
	EList getLink_environmentCondition_trafficCondition();

	/**
	 * Returns the value of the '<em><b>Link environment Condition special Condition</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Link_EnvironmentCondition_SpecialCondition}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link environment Condition special Condition</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getMobilitySystem_Link_environmentCondition_specialCondition()
	 * @model type="intelligentMobility.Link_EnvironmentCondition_SpecialCondition" containment="true"
	 * @generated
	 */
	EList getLink_environmentCondition_specialCondition();

	/**
	 * Returns the value of the '<em><b>Link lane Type regulation</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Link_LaneType_Regulation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link lane Type regulation</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getMobilitySystem_Link_laneType_regulation()
	 * @model type="intelligentMobility.Link_LaneType_Regulation" containment="true"
	 * @generated
	 */
	EList getLink_laneType_regulation();

	/**
	 * Returns the value of the '<em><b>Link safety Requirement regulation</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Link_SafetyRequirement_Regulation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link safety Requirement regulation</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getMobilitySystem_Link_safetyRequirement_regulation()
	 * @model type="intelligentMobility.Link_SafetyRequirement_Regulation" containment="true"
	 * @generated
	 */
	EList getLink_safetyRequirement_regulation();

	/**
	 * Returns the value of the '<em><b>Link special Condition intersection</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Link_SpecialCondition_Intersection}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link special Condition intersection</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getMobilitySystem_Link_specialCondition_intersection()
	 * @model type="intelligentMobility.Link_SpecialCondition_Intersection" containment="true"
	 * @generated
	 */
	EList getLink_specialCondition_intersection();

	/**
	 * Returns the value of the '<em><b>Link collision obstruction</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Link_Collision_Obstruction}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link collision obstruction</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getMobilitySystem_Link_collision_obstruction()
	 * @model type="intelligentMobility.Link_Collision_Obstruction" containment="true"
	 * @generated
	 */
	EList getLink_collision_obstruction();

	/**
	 * Returns the value of the '<em><b>Link intersection traffic Light</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Link_Intersection_TrafficLight}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link intersection traffic Light</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getMobilitySystem_Link_intersection_trafficLight()
	 * @model type="intelligentMobility.Link_Intersection_TrafficLight" containment="true"
	 * @generated
	 */
	EList getLink_intersection_trafficLight();

	/**
	 * Returns the value of the '<em><b>System ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>System ID</em>' attribute.
	 * @see #setSystemID(int)
	 * @see intelligentMobility.IntelligentMobilityPackage#getMobilitySystem_SystemID()
	 * @model
	 * @generated
	 */
	int getSystemID();

	/**
	 * Sets the value of the '{@link intelligentMobility.MobilitySystem#getSystemID <em>System ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>System ID</em>' attribute.
	 * @see #getSystemID()
	 * @generated
	 */
	void setSystemID(int value);

	/**
	 * Returns the value of the '<em><b>Geographical Scope</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Geographical Scope</em>' attribute.
	 * @see #setGeographicalScope(String)
	 * @see intelligentMobility.IntelligentMobilityPackage#getMobilitySystem_GeographicalScope()
	 * @model
	 * @generated
	 */
	String getGeographicalScope();

	/**
	 * Sets the value of the '{@link intelligentMobility.MobilitySystem#getGeographicalScope <em>Geographical Scope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Geographical Scope</em>' attribute.
	 * @see #getGeographicalScope()
	 * @generated
	 */
	void setGeographicalScope(String value);

	/**
	 * Returns the value of the '<em><b>Infrastructure Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Infrastructure Type</em>' attribute.
	 * @see #setInfrastructureType(String)
	 * @see intelligentMobility.IntelligentMobilityPackage#getMobilitySystem_InfrastructureType()
	 * @model
	 * @generated
	 */
	String getInfrastructureType();

	/**
	 * Sets the value of the '{@link intelligentMobility.MobilitySystem#getInfrastructureType <em>Infrastructure Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Infrastructure Type</em>' attribute.
	 * @see #getInfrastructureType()
	 * @generated
	 */
	void setInfrastructureType(String value);

	/**
	 * Returns the value of the '<em><b>Infrastructure</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Infrastructure}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Infrastructure</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getMobilitySystem_Infrastructure()
	 * @model type="intelligentMobility.Infrastructure" containment="true" required="true"
	 * @generated
	 */
	EList getInfrastructure();

	/**
	 * Returns the value of the '<em><b>Communication Interfaces</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.CommunicationInterface}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Communication Interfaces</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getMobilitySystem_CommunicationInterfaces()
	 * @model type="intelligentMobility.CommunicationInterface" containment="true" required="true"
	 * @generated
	 */
	EList getCommunicationInterfaces();

	/**
	 * Returns the value of the '<em><b>Goal</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Goal}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Goal</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getMobilitySystem_Goal()
	 * @model type="intelligentMobility.Goal" containment="true" required="true"
	 * @generated
	 */
	EList getGoal();

	/**
	 * Returns the value of the '<em><b>Link infrastructure vehicle configuration</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Link_Infrastructure_VehicleConfiguration}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link infrastructure vehicle configuration</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getMobilitySystem_Link_infrastructure_vehicle_configuration()
	 * @model type="intelligentMobility.Link_Infrastructure_VehicleConfiguration" containment="true"
	 * @generated
	 */
	EList getLink_infrastructure_vehicle_configuration();

	/**
	 * Returns the value of the '<em><b>Link communication Interface vehicle Configuration</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Link_CommunicationInterface_VehicleConfiguration}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link communication Interface vehicle Configuration</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getMobilitySystem_Link_communicationInterface_vehicleConfiguration()
	 * @model type="intelligentMobility.Link_CommunicationInterface_VehicleConfiguration" containment="true"
	 * @generated
	 */
	EList getLink_communicationInterface_vehicleConfiguration();

	/**
	 * Returns the value of the '<em><b>Link communication Interface infrastructure</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Link_CommunicationInterface_Infrastructure}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link communication Interface infrastructure</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getMobilitySystem_Link_communicationInterface_infrastructure()
	 * @model type="intelligentMobility.Link_CommunicationInterface_Infrastructure" containment="true"
	 * @generated
	 */
	EList getLink_communicationInterface_infrastructure();

	/**
	 * Returns the value of the '<em><b>Link goal driving Behaviour</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Link_Goal_DrivingBehaviour}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link goal driving Behaviour</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getMobilitySystem_Link_goal_drivingBehaviour()
	 * @model type="intelligentMobility.Link_Goal_DrivingBehaviour" containment="true"
	 * @generated
	 */
	EList getLink_goal_drivingBehaviour();

	/**
	 * Returns the value of the '<em><b>Cooperative Behaviour</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.CooperativeBehavior}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cooperative Behaviour</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getMobilitySystem_CooperativeBehaviour()
	 * @model type="intelligentMobility.CooperativeBehavior" containment="true" required="true"
	 * @generated
	 */
	EList getCooperativeBehaviour();

	/**
	 * Returns the value of the '<em><b>Link cooperative Behaviour communication Interface</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Link_CooperativeBehaviour_CommunicationInterface}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link cooperative Behaviour communication Interface</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getMobilitySystem_Link_cooperativeBehaviour_communicationInterface()
	 * @model type="intelligentMobility.Link_CooperativeBehaviour_CommunicationInterface" containment="true"
	 * @generated
	 */
	EList getLink_cooperativeBehaviour_communicationInterface();

	/**
	 * Returns the value of the '<em><b>Link cooperative Behaviour vehicle Configuration</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Link_CooperativeBehaviour_VehicleConfiguration}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link cooperative Behaviour vehicle Configuration</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getMobilitySystem_Link_cooperativeBehaviour_vehicleConfiguration()
	 * @model type="intelligentMobility.Link_CooperativeBehaviour_VehicleConfiguration" containment="true"
	 * @generated
	 */
	EList getLink_cooperativeBehaviour_vehicleConfiguration();

	/**
	 * Returns the value of the '<em><b>Link traffic Situation environment Condition</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Link_TrafficSituation_EnvironmentCondition}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link traffic Situation environment Condition</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getMobilitySystem_Link_trafficSituation_environmentCondition()
	 * @model type="intelligentMobility.Link_TrafficSituation_EnvironmentCondition" containment="true"
	 * @generated
	 */
	EList getLink_trafficSituation_environmentCondition();

	/**
	 * Returns the value of the '<em><b>Link following lane Changing</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Link_Following_LaneChanging}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link following lane Changing</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getMobilitySystem_Link_following_laneChanging()
	 * @model type="intelligentMobility.Link_Following_LaneChanging" containment="true"
	 * @generated
	 */
	EList getLink_following_laneChanging();

	/**
	 * Returns the value of the '<em><b>Link collision special Condition</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Link_Collision_SpecialCondition}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link collision special Condition</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getMobilitySystem_Link_collision_specialCondition()
	 * @model type="intelligentMobility.Link_Collision_SpecialCondition" containment="true"
	 * @generated
	 */
	EList getLink_collision_specialCondition();

	/**
	 * Returns the value of the '<em><b>Link action backward</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Link_Action_Backward}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link action backward</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getMobilitySystem_Link_action_backward()
	 * @model type="intelligentMobility.Link_Action_Backward" containment="true"
	 * @generated
	 */
	EList getLink_action_backward();

	/**
	 * Returns the value of the '<em><b>Link action forward</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Link_Action_Forward}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link action forward</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getMobilitySystem_Link_action_forward()
	 * @model type="intelligentMobility.Link_Action_Forward" containment="true"
	 * @generated
	 */
	EList getLink_action_forward();

	/**
	 * Returns the value of the '<em><b>Link action turn</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Link_Action_Turn}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link action turn</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getMobilitySystem_Link_action_turn()
	 * @model type="intelligentMobility.Link_Action_Turn" containment="true"
	 * @generated
	 */
	EList getLink_action_turn();

	/**
	 * Returns the value of the '<em><b>Link knowledge And Skill driver Preference</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Link_KnowledgeAndSkill_DriverPreference}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link knowledge And Skill driver Preference</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getMobilitySystem_Link_knowledgeAndSkill_driverPreference()
	 * @model type="intelligentMobility.Link_KnowledgeAndSkill_DriverPreference" containment="true"
	 * @generated
	 */
	EList getLink_knowledgeAndSkill_driverPreference();

} // MobilitySystem
