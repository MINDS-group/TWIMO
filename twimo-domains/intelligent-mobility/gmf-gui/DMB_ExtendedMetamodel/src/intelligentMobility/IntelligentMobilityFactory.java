/**
 */
package intelligentMobility;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see intelligentMobility.IntelligentMobilityPackage
 * @generated
 */
public interface IntelligentMobilityFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	IntelligentMobilityFactory eINSTANCE = intelligentMobility.impl.IntelligentMobilityFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Mobility System</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mobility System</em>'.
	 * @generated
	 */
	MobilitySystem createMobilitySystem();

	/**
	 * Returns a new object of class '<em>Driver Profile</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Driver Profile</em>'.
	 * @generated
	 */
	Driver_Profile createDriver_Profile();

	/**
	 * Returns a new object of class '<em>Vehicle Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Vehicle Configuration</em>'.
	 * @generated
	 */
	Vehicle_Configuration createVehicle_Configuration();

	/**
	 * Returns a new object of class '<em>Environment Background</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Environment Background</em>'.
	 * @generated
	 */
	Environment_Background createEnvironment_Background();

	/**
	 * Returns a new object of class '<em>Driver Preference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Driver Preference</em>'.
	 * @generated
	 */
	Driver_Preference createDriver_Preference();

	/**
	 * Returns a new object of class '<em>Knowledge and Skill</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Knowledge and Skill</em>'.
	 * @generated
	 */
	Knowledge_and_Skill createKnowledge_and_Skill();

	/**
	 * Returns a new object of class '<em>Driver Emotion</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Driver Emotion</em>'.
	 * @generated
	 */
	Driver_Emotion createDriver_Emotion();

	/**
	 * Returns a new object of class '<em>Driving Behaviour</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Driving Behaviour</em>'.
	 * @generated
	 */
	Driving_Behaviour createDriving_Behaviour();

	/**
	 * Returns a new object of class '<em>Normal Behaviour</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Normal Behaviour</em>'.
	 * @generated
	 */
	Normal_Behaviour createNormal_Behaviour();

	/**
	 * Returns a new object of class '<em>Following</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Following</em>'.
	 * @generated
	 */
	Following createFollowing();

	/**
	 * Returns a new object of class '<em>Lane Changing</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Lane Changing</em>'.
	 * @generated
	 */
	LaneChanging createLaneChanging();

	/**
	 * Returns a new object of class '<em>Abnormal Behaviour</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Abnormal Behaviour</em>'.
	 * @generated
	 */
	Abnormal_Behaviour createAbnormal_Behaviour();

	/**
	 * Returns a new object of class '<em>Forward</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Forward</em>'.
	 * @generated
	 */
	Forward createForward();

	/**
	 * Returns a new object of class '<em>Backward</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Backward</em>'.
	 * @generated
	 */
	Backward createBackward();

	/**
	 * Returns a new object of class '<em>Turn</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Turn</em>'.
	 * @generated
	 */
	Turn createTurn();

	/**
	 * Returns a new object of class '<em>Gap Acceptance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Gap Acceptance</em>'.
	 * @generated
	 */
	GapAcceptance createGapAcceptance();

	/**
	 * Returns a new object of class '<em>Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Action</em>'.
	 * @generated
	 */
	Action createAction();

	/**
	 * Returns a new object of class '<em>Platoon</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Platoon</em>'.
	 * @generated
	 */
	Platoon createPlatoon();

	/**
	 * Returns a new object of class '<em>Normal Vehicle</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Normal Vehicle</em>'.
	 * @generated
	 */
	Normal_Vehicle createNormal_Vehicle();

	/**
	 * Returns a new object of class '<em>Leading Vehicle</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Leading Vehicle</em>'.
	 * @generated
	 */
	Leading_Vehicle createLeading_Vehicle();

	/**
	 * Returns a new object of class '<em>Following Vehicle</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Following Vehicle</em>'.
	 * @generated
	 */
	Following_Vehicle createFollowing_Vehicle();

	/**
	 * Returns a new object of class '<em>Possible Vehicle</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Possible Vehicle</em>'.
	 * @generated
	 */
	PossibleVehicle createPossibleVehicle();

	/**
	 * Returns a new object of class '<em>Environment Condition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Environment Condition</em>'.
	 * @generated
	 */
	Environment_Condition createEnvironment_Condition();

	/**
	 * Returns a new object of class '<em>Lane Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Lane Type</em>'.
	 * @generated
	 */
	Lane_Type createLane_Type();

	/**
	 * Returns a new object of class '<em>Regulation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Regulation</em>'.
	 * @generated
	 */
	Regulation createRegulation();

	/**
	 * Returns a new object of class '<em>Safety Requirement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Safety Requirement</em>'.
	 * @generated
	 */
	Safety_Requirement createSafety_Requirement();

	/**
	 * Returns a new object of class '<em>Weather</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Weather</em>'.
	 * @generated
	 */
	Weather createWeather();

	/**
	 * Returns a new object of class '<em>Traffic Situation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Traffic Situation</em>'.
	 * @generated
	 */
	Traffic_Situation createTraffic_Situation();

	/**
	 * Returns a new object of class '<em>Special Condition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Special Condition</em>'.
	 * @generated
	 */
	Special_Condition createSpecial_Condition();

	/**
	 * Returns a new object of class '<em>Collision</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Collision</em>'.
	 * @generated
	 */
	Collision createCollision();

	/**
	 * Returns a new object of class '<em>Intersection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Intersection</em>'.
	 * @generated
	 */
	Intersection createIntersection();

	/**
	 * Returns a new object of class '<em>Obstruction</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Obstruction</em>'.
	 * @generated
	 */
	Obstruction createObstruction();

	/**
	 * Returns a new object of class '<em>Traffic Light</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Traffic Light</em>'.
	 * @generated
	 */
	Traffic_Light createTraffic_Light();

	/**
	 * Returns a new object of class '<em>Exception Condition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Exception Condition</em>'.
	 * @generated
	 */
	ExceptionCondition createExceptionCondition();

	/**
	 * Returns a new object of class '<em>Link Driver Environment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Link Driver Environment</em>'.
	 * @generated
	 */
	Link_Driver_Environment createLink_Driver_Environment();

	/**
	 * Returns a new object of class '<em>Link Driver Vehicle</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Link Driver Vehicle</em>'.
	 * @generated
	 */
	Link_Driver_Vehicle createLink_Driver_Vehicle();

	/**
	 * Returns a new object of class '<em>Link Vehicle Environment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Link Vehicle Environment</em>'.
	 * @generated
	 */
	Link_Vehicle_Environment createLink_Vehicle_Environment();

	/**
	 * Returns a new object of class '<em>Link Driver Profile Driver Preference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Link Driver Profile Driver Preference</em>'.
	 * @generated
	 */
	Link_DriverProfile_DriverPreference createLink_DriverProfile_DriverPreference();

	/**
	 * Returns a new object of class '<em>Link Vehicle Configuration Vehicle Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Link Vehicle Configuration Vehicle Type</em>'.
	 * @generated
	 */
	Link_VehicleConfiguration_VehicleType createLink_VehicleConfiguration_VehicleType();

	/**
	 * Returns a new object of class '<em>Link Environment Background Possible Vehicle</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Link Environment Background Possible Vehicle</em>'.
	 * @generated
	 */
	Link_EnvironmentBackground_PossibleVehicle createLink_EnvironmentBackground_PossibleVehicle();

	/**
	 * Returns a new object of class '<em>Link Environment Background Environment Condition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Link Environment Background Environment Condition</em>'.
	 * @generated
	 */
	Link_EnvironmentBackground_EnvironmentCondition createLink_EnvironmentBackground_EnvironmentCondition();

	/**
	 * Returns a new object of class '<em>Link Driver Preference Driver Emotion</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Link Driver Preference Driver Emotion</em>'.
	 * @generated
	 */
	Link_DriverPreference_DriverEmotion createLink_DriverPreference_DriverEmotion();

	/**
	 * Returns a new object of class '<em>Link Driver Preference Driving Behaviour</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Link Driver Preference Driving Behaviour</em>'.
	 * @generated
	 */
	Link_DriverPreference_DrivingBehaviour createLink_DriverPreference_DrivingBehaviour();

	/**
	 * Returns a new object of class '<em>Link Driver Preference Environment Condition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Link Driver Preference Environment Condition</em>'.
	 * @generated
	 */
	Link_DriverPreference_EnvironmentCondition createLink_DriverPreference_EnvironmentCondition();

	/**
	 * Returns a new object of class '<em>Link Driving Behaviour Normal Behaviour</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Link Driving Behaviour Normal Behaviour</em>'.
	 * @generated
	 */
	Link_DrivingBehaviour_NormalBehaviour createLink_DrivingBehaviour_NormalBehaviour();

	/**
	 * Returns a new object of class '<em>Link Normal Behaviour Following</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Link Normal Behaviour Following</em>'.
	 * @generated
	 */
	Link_NormalBehaviour_Following createLink_NormalBehaviour_Following();

	/**
	 * Returns a new object of class '<em>Link Normal Behaviour Lane Changing</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Link Normal Behaviour Lane Changing</em>'.
	 * @generated
	 */
	Link_NormalBehaviour_LaneChanging createLink_NormalBehaviour_LaneChanging();

	/**
	 * Returns a new object of class '<em>Link Following Min Gap</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Link Following Min Gap</em>'.
	 * @generated
	 */
	Link_Following_MinGap createLink_Following_MinGap();

	/**
	 * Returns a new object of class '<em>Link Following Forward</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Link Following Forward</em>'.
	 * @generated
	 */
	Link_Following_Forward createLink_Following_Forward();

	/**
	 * Returns a new object of class '<em>Link Following Backward</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Link Following Backward</em>'.
	 * @generated
	 */
	Link_Following_Backward createLink_Following_Backward();

	/**
	 * Returns a new object of class '<em>Link Lane Changing Turn</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Link Lane Changing Turn</em>'.
	 * @generated
	 */
	Link_LaneChanging_Turn createLink_LaneChanging_Turn();

	/**
	 * Returns a new object of class '<em>Link Lane Changing Gap Acceptance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Link Lane Changing Gap Acceptance</em>'.
	 * @generated
	 */
	Link_LaneChanging_GapAcceptance createLink_LaneChanging_GapAcceptance();

	/**
	 * Returns a new object of class '<em>Link Lane Changing Environment Condition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Link Lane Changing Environment Condition</em>'.
	 * @generated
	 */
	Link_LaneChanging_EnvironmentCondition createLink_LaneChanging_EnvironmentCondition();

	/**
	 * Returns a new object of class '<em>Link Abnormal Behaviour Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Link Abnormal Behaviour Action</em>'.
	 * @generated
	 */
	Link_AbnormalBehaviour_Action createLink_AbnormalBehaviour_Action();

	/**
	 * Returns a new object of class '<em>Link Platoon Leading Vehicle</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Link Platoon Leading Vehicle</em>'.
	 * @generated
	 */
	Link_Platoon_LeadingVehicle createLink_Platoon_LeadingVehicle();

	/**
	 * Returns a new object of class '<em>Link Platoon Following Vehicle</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Link Platoon Following Vehicle</em>'.
	 * @generated
	 */
	Link_Platoon_FollowingVehicle createLink_Platoon_FollowingVehicle();

	/**
	 * Returns a new object of class '<em>Link Normal Vehicle Safety Requirements</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Link Normal Vehicle Safety Requirements</em>'.
	 * @generated
	 */
	Link_NormalVehicle_SafetyRequirements createLink_NormalVehicle_SafetyRequirements();

	/**
	 * Returns a new object of class '<em>Link Following Vehicle Front Vehicle</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Link Following Vehicle Front Vehicle</em>'.
	 * @generated
	 */
	Link_FollowingVehicle_FrontVehicle createLink_FollowingVehicle_FrontVehicle();

	/**
	 * Returns a new object of class '<em>Link Environment Condition Lane Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Link Environment Condition Lane Type</em>'.
	 * @generated
	 */
	Link_EnvironmentCondition_LaneType createLink_EnvironmentCondition_LaneType();

	/**
	 * Returns a new object of class '<em>Link Environment Condition Regulations</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Link Environment Condition Regulations</em>'.
	 * @generated
	 */
	Link_EnvironmentCondition_Regulations createLink_EnvironmentCondition_Regulations();

	/**
	 * Returns a new object of class '<em>Link Environment Condition Weather</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Link Environment Condition Weather</em>'.
	 * @generated
	 */
	Link_EnvironmentCondition_Weather createLink_EnvironmentCondition_Weather();

	/**
	 * Returns a new object of class '<em>Link Environment Condition Traffic Condition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Link Environment Condition Traffic Condition</em>'.
	 * @generated
	 */
	Link_EnvironmentCondition_TrafficCondition createLink_EnvironmentCondition_TrafficCondition();

	/**
	 * Returns a new object of class '<em>Link Environment Condition Special Condition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Link Environment Condition Special Condition</em>'.
	 * @generated
	 */
	Link_EnvironmentCondition_SpecialCondition createLink_EnvironmentCondition_SpecialCondition();

	/**
	 * Returns a new object of class '<em>Link Lane Type Regulation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Link Lane Type Regulation</em>'.
	 * @generated
	 */
	Link_LaneType_Regulation createLink_LaneType_Regulation();

	/**
	 * Returns a new object of class '<em>Link Safety Requirement Regulation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Link Safety Requirement Regulation</em>'.
	 * @generated
	 */
	Link_SafetyRequirement_Regulation createLink_SafetyRequirement_Regulation();

	/**
	 * Returns a new object of class '<em>Link Special Condition Intersection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Link Special Condition Intersection</em>'.
	 * @generated
	 */
	Link_SpecialCondition_Intersection createLink_SpecialCondition_Intersection();

	/**
	 * Returns a new object of class '<em>Link Collision Obstruction</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Link Collision Obstruction</em>'.
	 * @generated
	 */
	Link_Collision_Obstruction createLink_Collision_Obstruction();

	/**
	 * Returns a new object of class '<em>Link Intersection Traffic Light</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Link Intersection Traffic Light</em>'.
	 * @generated
	 */
	Link_Intersection_TrafficLight createLink_Intersection_TrafficLight();

	/**
	 * Returns a new object of class '<em>Road Segment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Road Segment</em>'.
	 * @generated
	 */
	RoadSegment createRoadSegment();

	/**
	 * Returns a new object of class '<em>Smart Sensor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Smart Sensor</em>'.
	 * @generated
	 */
	SmartSensor createSmartSensor();

	/**
	 * Returns a new object of class '<em>Road Side Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Road Side Unit</em>'.
	 * @generated
	 */
	Road_Side_Unit createRoad_Side_Unit();

	/**
	 * Returns a new object of class '<em>Charging Station</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Charging Station</em>'.
	 * @generated
	 */
	ChargingStation createChargingStation();

	/**
	 * Returns a new object of class '<em>Communication Interface</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Communication Interface</em>'.
	 * @generated
	 */
	CommunicationInterface createCommunicationInterface();

	/**
	 * Returns a new object of class '<em>Cooperative Behavior</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Cooperative Behavior</em>'.
	 * @generated
	 */
	CooperativeBehavior createCooperativeBehavior();

	/**
	 * Returns a new object of class '<em>Goal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Goal</em>'.
	 * @generated
	 */
	Goal createGoal();

	/**
	 * Returns a new object of class '<em>Link Infrastructure Vehicle Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Link Infrastructure Vehicle Configuration</em>'.
	 * @generated
	 */
	Link_Infrastructure_VehicleConfiguration createLink_Infrastructure_VehicleConfiguration();

	/**
	 * Returns a new object of class '<em>Link Communication Interface Vehicle Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Link Communication Interface Vehicle Configuration</em>'.
	 * @generated
	 */
	Link_CommunicationInterface_VehicleConfiguration createLink_CommunicationInterface_VehicleConfiguration();

	/**
	 * Returns a new object of class '<em>Link Goal Driving Behaviour</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Link Goal Driving Behaviour</em>'.
	 * @generated
	 */
	Link_Goal_DrivingBehaviour createLink_Goal_DrivingBehaviour();

	/**
	 * Returns a new object of class '<em>Link Cooperative Behaviour Communication Interface</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Link Cooperative Behaviour Communication Interface</em>'.
	 * @generated
	 */
	Link_CooperativeBehaviour_CommunicationInterface createLink_CooperativeBehaviour_CommunicationInterface();

	/**
	 * Returns a new object of class '<em>Link Communication Interface Infrastructure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Link Communication Interface Infrastructure</em>'.
	 * @generated
	 */
	Link_CommunicationInterface_Infrastructure createLink_CommunicationInterface_Infrastructure();

	/**
	 * Returns a new object of class '<em>Link Cooperative Behaviour Vehicle Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Link Cooperative Behaviour Vehicle Configuration</em>'.
	 * @generated
	 */
	Link_CooperativeBehaviour_VehicleConfiguration createLink_CooperativeBehaviour_VehicleConfiguration();

	/**
	 * Returns a new object of class '<em>Link Traffic Situation Environment Condition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Link Traffic Situation Environment Condition</em>'.
	 * @generated
	 */
	Link_TrafficSituation_EnvironmentCondition createLink_TrafficSituation_EnvironmentCondition();

	/**
	 * Returns a new object of class '<em>Link Following Lane Changing</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Link Following Lane Changing</em>'.
	 * @generated
	 */
	Link_Following_LaneChanging createLink_Following_LaneChanging();

	/**
	 * Returns a new object of class '<em>Link Collision Special Condition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Link Collision Special Condition</em>'.
	 * @generated
	 */
	Link_Collision_SpecialCondition createLink_Collision_SpecialCondition();

	/**
	 * Returns a new object of class '<em>Link Action Backward</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Link Action Backward</em>'.
	 * @generated
	 */
	Link_Action_Backward createLink_Action_Backward();

	/**
	 * Returns a new object of class '<em>Link Action Forward</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Link Action Forward</em>'.
	 * @generated
	 */
	Link_Action_Forward createLink_Action_Forward();

	/**
	 * Returns a new object of class '<em>Link Action Turn</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Link Action Turn</em>'.
	 * @generated
	 */
	Link_Action_Turn createLink_Action_Turn();

	/**
	 * Returns a new object of class '<em>Link Knowledge And Skill Driver Preference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Link Knowledge And Skill Driver Preference</em>'.
	 * @generated
	 */
	Link_KnowledgeAndSkill_DriverPreference createLink_KnowledgeAndSkill_DriverPreference();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	IntelligentMobilityPackage getIntelligentMobilityPackage();

} //IntelligentMobilityFactory
