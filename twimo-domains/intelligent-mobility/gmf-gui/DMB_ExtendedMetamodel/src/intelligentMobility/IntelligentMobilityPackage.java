/**
 */
package intelligentMobility;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see intelligentMobility.IntelligentMobilityFactory
 * @model kind="package"
 * @generated
 */
public interface IntelligentMobilityPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "intelligentMobility";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.example.org/intelligentMobility";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "intelligentMobility";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	IntelligentMobilityPackage eINSTANCE = intelligentMobility.impl.IntelligentMobilityPackageImpl.init();

	/**
	 * The meta object id for the '{@link intelligentMobility.impl.MobilitySystemImpl <em>Mobility System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.impl.MobilitySystemImpl
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getMobilitySystem()
	 * @generated
	 */
	int MOBILITY_SYSTEM = 0;

	/**
	 * The feature id for the '<em><b>Driver profile</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILITY_SYSTEM__DRIVER_PROFILE = 0;

	/**
	 * The feature id for the '<em><b>Vehicle configuration</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILITY_SYSTEM__VEHICLE_CONFIGURATION = 1;

	/**
	 * The feature id for the '<em><b>Environment background</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILITY_SYSTEM__ENVIRONMENT_BACKGROUND = 2;

	/**
	 * The feature id for the '<em><b>Driver preference</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILITY_SYSTEM__DRIVER_PREFERENCE = 3;

	/**
	 * The feature id for the '<em><b>Knowledge and skill</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILITY_SYSTEM__KNOWLEDGE_AND_SKILL = 4;

	/**
	 * The feature id for the '<em><b>Driver emotion</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILITY_SYSTEM__DRIVER_EMOTION = 5;

	/**
	 * The feature id for the '<em><b>Driving behaviour</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILITY_SYSTEM__DRIVING_BEHAVIOUR = 6;

	/**
	 * The feature id for the '<em><b>Normal behaviour</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILITY_SYSTEM__NORMAL_BEHAVIOUR = 7;

	/**
	 * The feature id for the '<em><b>Following</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILITY_SYSTEM__FOLLOWING = 8;

	/**
	 * The feature id for the '<em><b>Lane changing</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILITY_SYSTEM__LANE_CHANGING = 9;

	/**
	 * The feature id for the '<em><b>Abnormal behaviour</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILITY_SYSTEM__ABNORMAL_BEHAVIOUR = 10;

	/**
	 * The feature id for the '<em><b>Forward</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILITY_SYSTEM__FORWARD = 11;

	/**
	 * The feature id for the '<em><b>Backward</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILITY_SYSTEM__BACKWARD = 12;

	/**
	 * The feature id for the '<em><b>Turn</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILITY_SYSTEM__TURN = 13;

	/**
	 * The feature id for the '<em><b>Gap acceptance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILITY_SYSTEM__GAP_ACCEPTANCE = 14;

	/**
	 * The feature id for the '<em><b>Action</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILITY_SYSTEM__ACTION = 15;

	/**
	 * The feature id for the '<em><b>Vehicle type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILITY_SYSTEM__VEHICLE_TYPE = 16;

	/**
	 * The feature id for the '<em><b>Platoon</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILITY_SYSTEM__PLATOON = 17;

	/**
	 * The feature id for the '<em><b>Normal vehicle</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILITY_SYSTEM__NORMAL_VEHICLE = 18;

	/**
	 * The feature id for the '<em><b>Leading vehicle</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILITY_SYSTEM__LEADING_VEHICLE = 19;

	/**
	 * The feature id for the '<em><b>Following vehicle</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILITY_SYSTEM__FOLLOWING_VEHICLE = 20;

	/**
	 * The feature id for the '<em><b>Platoon member</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILITY_SYSTEM__PLATOON_MEMBER = 21;

	/**
	 * The feature id for the '<em><b>Possible vehicle</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILITY_SYSTEM__POSSIBLE_VEHICLE = 22;

	/**
	 * The feature id for the '<em><b>Environment condition</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILITY_SYSTEM__ENVIRONMENT_CONDITION = 23;

	/**
	 * The feature id for the '<em><b>Lane type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILITY_SYSTEM__LANE_TYPE = 24;

	/**
	 * The feature id for the '<em><b>Regulation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILITY_SYSTEM__REGULATION = 25;

	/**
	 * The feature id for the '<em><b>Safety requirement</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILITY_SYSTEM__SAFETY_REQUIREMENT = 26;

	/**
	 * The feature id for the '<em><b>Weather</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILITY_SYSTEM__WEATHER = 27;

	/**
	 * The feature id for the '<em><b>Traffic situation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILITY_SYSTEM__TRAFFIC_SITUATION = 28;

	/**
	 * The feature id for the '<em><b>Special condition</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILITY_SYSTEM__SPECIAL_CONDITION = 29;

	/**
	 * The feature id for the '<em><b>Collision</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILITY_SYSTEM__COLLISION = 30;

	/**
	 * The feature id for the '<em><b>Intersection</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILITY_SYSTEM__INTERSECTION = 31;

	/**
	 * The feature id for the '<em><b>Obstruction</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILITY_SYSTEM__OBSTRUCTION = 32;

	/**
	 * The feature id for the '<em><b>Traffic light</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILITY_SYSTEM__TRAFFIC_LIGHT = 33;

	/**
	 * The feature id for the '<em><b>Execption condition</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILITY_SYSTEM__EXECPTION_CONDITION = 34;

	/**
	 * The feature id for the '<em><b>Link driver vehicle</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILITY_SYSTEM__LINK_DRIVER_VEHICLE = 35;

	/**
	 * The feature id for the '<em><b>Link driver environment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILITY_SYSTEM__LINK_DRIVER_ENVIRONMENT = 36;

	/**
	 * The feature id for the '<em><b>Link vehicle environment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILITY_SYSTEM__LINK_VEHICLE_ENVIRONMENT = 37;

	/**
	 * The feature id for the '<em><b>Link driver Profile driver Preference</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILITY_SYSTEM__LINK_DRIVER_PROFILE_DRIVER_PREFERENCE = 38;

	/**
	 * The feature id for the '<em><b>Link vehicle Configuration vehicle Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILITY_SYSTEM__LINK_VEHICLE_CONFIGURATION_VEHICLE_TYPE = 39;

	/**
	 * The feature id for the '<em><b>Link environment Background possible Vehicle</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILITY_SYSTEM__LINK_ENVIRONMENT_BACKGROUND_POSSIBLE_VEHICLE = 40;

	/**
	 * The feature id for the '<em><b>Link environment Background environment Condition</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILITY_SYSTEM__LINK_ENVIRONMENT_BACKGROUND_ENVIRONMENT_CONDITION = 41;

	/**
	 * The feature id for the '<em><b>Link driver Preference driver Emotion</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILITY_SYSTEM__LINK_DRIVER_PREFERENCE_DRIVER_EMOTION = 42;

	/**
	 * The feature id for the '<em><b>Link driver Preference driving Behaviour</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILITY_SYSTEM__LINK_DRIVER_PREFERENCE_DRIVING_BEHAVIOUR = 43;

	/**
	 * The feature id for the '<em><b>Link driver Preference environment Condition</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILITY_SYSTEM__LINK_DRIVER_PREFERENCE_ENVIRONMENT_CONDITION = 44;

	/**
	 * The feature id for the '<em><b>Link driving Behaviour normal Behaviour</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILITY_SYSTEM__LINK_DRIVING_BEHAVIOUR_NORMAL_BEHAVIOUR = 45;

	/**
	 * The feature id for the '<em><b>Link normal Behaviour following</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILITY_SYSTEM__LINK_NORMAL_BEHAVIOUR_FOLLOWING = 46;

	/**
	 * The feature id for the '<em><b>Link normal Behaviour lane Changing</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILITY_SYSTEM__LINK_NORMAL_BEHAVIOUR_LANE_CHANGING = 47;

	/**
	 * The feature id for the '<em><b>Link following min Gap</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILITY_SYSTEM__LINK_FOLLOWING_MIN_GAP = 48;

	/**
	 * The feature id for the '<em><b>Link following forward</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILITY_SYSTEM__LINK_FOLLOWING_FORWARD = 49;

	/**
	 * The feature id for the '<em><b>Link following backward</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILITY_SYSTEM__LINK_FOLLOWING_BACKWARD = 50;

	/**
	 * The feature id for the '<em><b>Link lane Changing turn</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILITY_SYSTEM__LINK_LANE_CHANGING_TURN = 51;

	/**
	 * The feature id for the '<em><b>Link lane Changing gap Acceptance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILITY_SYSTEM__LINK_LANE_CHANGING_GAP_ACCEPTANCE = 52;

	/**
	 * The feature id for the '<em><b>Link lane Changing environment Condition</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILITY_SYSTEM__LINK_LANE_CHANGING_ENVIRONMENT_CONDITION = 53;

	/**
	 * The feature id for the '<em><b>Link abnormal Behaviour action</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILITY_SYSTEM__LINK_ABNORMAL_BEHAVIOUR_ACTION = 54;

	/**
	 * The feature id for the '<em><b>Link platoon leading Vehicle</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILITY_SYSTEM__LINK_PLATOON_LEADING_VEHICLE = 55;

	/**
	 * The feature id for the '<em><b>Link platoon following Vehicle</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILITY_SYSTEM__LINK_PLATOON_FOLLOWING_VEHICLE = 56;

	/**
	 * The feature id for the '<em><b>Link normal Vehicle safety Requirement</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILITY_SYSTEM__LINK_NORMAL_VEHICLE_SAFETY_REQUIREMENT = 57;

	/**
	 * The feature id for the '<em><b>Link following Vehicle front Vehicle</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILITY_SYSTEM__LINK_FOLLOWING_VEHICLE_FRONT_VEHICLE = 58;

	/**
	 * The feature id for the '<em><b>Link environment Condition lane Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILITY_SYSTEM__LINK_ENVIRONMENT_CONDITION_LANE_TYPE = 59;

	/**
	 * The feature id for the '<em><b>Link environment Condition regulation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILITY_SYSTEM__LINK_ENVIRONMENT_CONDITION_REGULATION = 60;

	/**
	 * The feature id for the '<em><b>Link environment Condition weather</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILITY_SYSTEM__LINK_ENVIRONMENT_CONDITION_WEATHER = 61;

	/**
	 * The feature id for the '<em><b>Link environment Condition traffic Condition</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILITY_SYSTEM__LINK_ENVIRONMENT_CONDITION_TRAFFIC_CONDITION = 62;

	/**
	 * The feature id for the '<em><b>Link environment Condition special Condition</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILITY_SYSTEM__LINK_ENVIRONMENT_CONDITION_SPECIAL_CONDITION = 63;

	/**
	 * The feature id for the '<em><b>Link lane Type regulation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILITY_SYSTEM__LINK_LANE_TYPE_REGULATION = 64;

	/**
	 * The feature id for the '<em><b>Link safety Requirement regulation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILITY_SYSTEM__LINK_SAFETY_REQUIREMENT_REGULATION = 65;

	/**
	 * The feature id for the '<em><b>Link special Condition intersection</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILITY_SYSTEM__LINK_SPECIAL_CONDITION_INTERSECTION = 66;

	/**
	 * The feature id for the '<em><b>Link collision obstruction</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILITY_SYSTEM__LINK_COLLISION_OBSTRUCTION = 67;

	/**
	 * The feature id for the '<em><b>Link intersection traffic Light</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILITY_SYSTEM__LINK_INTERSECTION_TRAFFIC_LIGHT = 68;

	/**
	 * The feature id for the '<em><b>System ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILITY_SYSTEM__SYSTEM_ID = 69;

	/**
	 * The feature id for the '<em><b>Geographical Scope</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILITY_SYSTEM__GEOGRAPHICAL_SCOPE = 70;

	/**
	 * The feature id for the '<em><b>Infrastructure Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILITY_SYSTEM__INFRASTRUCTURE_TYPE = 71;

	/**
	 * The feature id for the '<em><b>Infrastructure</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILITY_SYSTEM__INFRASTRUCTURE = 72;

	/**
	 * The feature id for the '<em><b>Communication Interfaces</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILITY_SYSTEM__COMMUNICATION_INTERFACES = 73;

	/**
	 * The feature id for the '<em><b>Goal</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILITY_SYSTEM__GOAL = 74;

	/**
	 * The feature id for the '<em><b>Link infrastructure vehicle configuration</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILITY_SYSTEM__LINK_INFRASTRUCTURE_VEHICLE_CONFIGURATION = 75;

	/**
	 * The feature id for the '<em><b>Link communication Interface vehicle Configuration</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILITY_SYSTEM__LINK_COMMUNICATION_INTERFACE_VEHICLE_CONFIGURATION = 76;

	/**
	 * The feature id for the '<em><b>Link communication Interface infrastructure</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILITY_SYSTEM__LINK_COMMUNICATION_INTERFACE_INFRASTRUCTURE = 77;

	/**
	 * The feature id for the '<em><b>Link goal driving Behaviour</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILITY_SYSTEM__LINK_GOAL_DRIVING_BEHAVIOUR = 78;

	/**
	 * The feature id for the '<em><b>Cooperative Behaviour</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILITY_SYSTEM__COOPERATIVE_BEHAVIOUR = 79;

	/**
	 * The feature id for the '<em><b>Link cooperative Behaviour communication Interface</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILITY_SYSTEM__LINK_COOPERATIVE_BEHAVIOUR_COMMUNICATION_INTERFACE = 80;

	/**
	 * The feature id for the '<em><b>Link cooperative Behaviour vehicle Configuration</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILITY_SYSTEM__LINK_COOPERATIVE_BEHAVIOUR_VEHICLE_CONFIGURATION = 81;

	/**
	 * The feature id for the '<em><b>Link traffic Situation environment Condition</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILITY_SYSTEM__LINK_TRAFFIC_SITUATION_ENVIRONMENT_CONDITION = 82;

	/**
	 * The feature id for the '<em><b>Link following lane Changing</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILITY_SYSTEM__LINK_FOLLOWING_LANE_CHANGING = 83;

	/**
	 * The feature id for the '<em><b>Link collision special Condition</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILITY_SYSTEM__LINK_COLLISION_SPECIAL_CONDITION = 84;

	/**
	 * The feature id for the '<em><b>Link action backward</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILITY_SYSTEM__LINK_ACTION_BACKWARD = 85;

	/**
	 * The feature id for the '<em><b>Link action forward</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILITY_SYSTEM__LINK_ACTION_FORWARD = 86;

	/**
	 * The feature id for the '<em><b>Link action turn</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILITY_SYSTEM__LINK_ACTION_TURN = 87;

	/**
	 * The feature id for the '<em><b>Link knowledge And Skill driver Preference</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILITY_SYSTEM__LINK_KNOWLEDGE_AND_SKILL_DRIVER_PREFERENCE = 88;

	/**
	 * The number of structural features of the '<em>Mobility System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILITY_SYSTEM_FEATURE_COUNT = 89;

	/**
	 * The meta object id for the '{@link intelligentMobility.impl.Driver_ProfileImpl <em>Driver Profile</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.impl.Driver_ProfileImpl
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getDriver_Profile()
	 * @generated
	 */
	int DRIVER_PROFILE = 1;

	/**
	 * The feature id for the '<em><b>Driver preference</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRIVER_PROFILE__DRIVER_PREFERENCE = 0;

	/**
	 * The feature id for the '<em><b>Driver Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRIVER_PROFILE__DRIVER_NAME = 1;

	/**
	 * The feature id for the '<em><b>Driver Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRIVER_PROFILE__DRIVER_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Patience Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRIVER_PROFILE__PATIENCE_VALUE = 3;

	/**
	 * The feature id for the '<em><b>Lane Preference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRIVER_PROFILE__LANE_PREFERENCE = 4;

	/**
	 * The feature id for the '<em><b>Energy Speed Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRIVER_PROFILE__ENERGY_SPEED_RATE = 5;

	/**
	 * The feature id for the '<em><b>Risk Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRIVER_PROFILE__RISK_LEVEL = 6;

	/**
	 * The feature id for the '<em><b>Reaction Time min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRIVER_PROFILE__REACTION_TIME_MIN = 7;

	/**
	 * The feature id for the '<em><b>Reaction Time max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRIVER_PROFILE__REACTION_TIME_MAX = 8;

	/**
	 * The feature id for the '<em><b>Reaction Time precision</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRIVER_PROFILE__REACTION_TIME_PRECISION = 9;

	/**
	 * The feature id for the '<em><b>Age</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRIVER_PROFILE__AGE = 10;

	/**
	 * The number of structural features of the '<em>Driver Profile</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRIVER_PROFILE_FEATURE_COUNT = 11;

	/**
	 * The meta object id for the '{@link intelligentMobility.impl.Vehicle_ConfigurationImpl <em>Vehicle Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.impl.Vehicle_ConfigurationImpl
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getVehicle_Configuration()
	 * @generated
	 */
	int VEHICLE_CONFIGURATION = 2;

	/**
	 * The feature id for the '<em><b>Brand Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE_CONFIGURATION__BRAND_NAME = 0;

	/**
	 * The feature id for the '<em><b>Color Rmin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE_CONFIGURATION__COLOR_RMIN = 1;

	/**
	 * The feature id for the '<em><b>Color Rmax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE_CONFIGURATION__COLOR_RMAX = 2;

	/**
	 * The feature id for the '<em><b>Color Gmin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE_CONFIGURATION__COLOR_GMIN = 3;

	/**
	 * The feature id for the '<em><b>Color Gmax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE_CONFIGURATION__COLOR_GMAX = 4;

	/**
	 * The feature id for the '<em><b>Color Bmin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE_CONFIGURATION__COLOR_BMIN = 5;

	/**
	 * The feature id for the '<em><b>Color Bmax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE_CONFIGURATION__COLOR_BMAX = 6;

	/**
	 * The feature id for the '<em><b>Vehicle type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE_CONFIGURATION__VEHICLE_TYPE = 7;

	/**
	 * The feature id for the '<em><b>Gps Yaw</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE_CONFIGURATION__GPS_YAW = 8;

	/**
	 * The feature id for the '<em><b>Gps Pitch</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE_CONFIGURATION__GPS_PITCH = 9;

	/**
	 * The feature id for the '<em><b>Gps Roll</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE_CONFIGURATION__GPS_ROLL = 10;

	/**
	 * The feature id for the '<em><b>Latitude</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE_CONFIGURATION__LATITUDE = 11;

	/**
	 * The feature id for the '<em><b>Longitude</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE_CONFIGURATION__LONGITUDE = 12;

	/**
	 * The feature id for the '<em><b>Connected Infrastructure</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE_CONFIGURATION__CONNECTED_INFRASTRUCTURE = 13;

	/**
	 * The number of structural features of the '<em>Vehicle Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE_CONFIGURATION_FEATURE_COUNT = 14;

	/**
	 * The meta object id for the '{@link intelligentMobility.impl.Environment_BackgroundImpl <em>Environment Background</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.impl.Environment_BackgroundImpl
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getEnvironment_Background()
	 * @generated
	 */
	int ENVIRONMENT_BACKGROUND = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT_BACKGROUND__NAME = 0;

	/**
	 * The feature id for the '<em><b>Road Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT_BACKGROUND__ROAD_LENGTH = 1;

	/**
	 * The feature id for the '<em><b>Road Shape</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT_BACKGROUND__ROAD_SHAPE = 2;

	/**
	 * The feature id for the '<em><b>Total Vehicle Per Frame</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT_BACKGROUND__TOTAL_VEHICLE_PER_FRAME = 3;

	/**
	 * The feature id for the '<em><b>Traffic Density</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT_BACKGROUND__TRAFFIC_DENSITY = 4;

	/**
	 * The feature id for the '<em><b>Simulation Frame Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT_BACKGROUND__SIMULATION_FRAME_TIME = 5;

	/**
	 * The feature id for the '<em><b>Simulation Sleep Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT_BACKGROUND__SIMULATION_SLEEP_TIME = 6;

	/**
	 * The feature id for the '<em><b>Possiblevehicles</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT_BACKGROUND__POSSIBLEVEHICLES = 7;

	/**
	 * The feature id for the '<em><b>Environment condition</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT_BACKGROUND__ENVIRONMENT_CONDITION = 8;

	/**
	 * The feature id for the '<em><b>Road Incline</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT_BACKGROUND__ROAD_INCLINE = 9;

	/**
	 * The number of structural features of the '<em>Environment Background</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT_BACKGROUND_FEATURE_COUNT = 10;

	/**
	 * The meta object id for the '{@link intelligentMobility.impl.Driver_PreferenceImpl <em>Driver Preference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.impl.Driver_PreferenceImpl
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getDriver_Preference()
	 * @generated
	 */
	int DRIVER_PREFERENCE = 4;

	/**
	 * The feature id for the '<em><b>Driver emotions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRIVER_PREFERENCE__DRIVER_EMOTIONS = 0;

	/**
	 * The feature id for the '<em><b>Knowledge and skills</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRIVER_PREFERENCE__KNOWLEDGE_AND_SKILLS = 1;

	/**
	 * The feature id for the '<em><b>Name Preference Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRIVER_PREFERENCE__NAME_PREFERENCE_SET = 2;

	/**
	 * The feature id for the '<em><b>Driving behaviour</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRIVER_PREFERENCE__DRIVING_BEHAVIOUR = 3;

	/**
	 * The feature id for the '<em><b>Environment condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRIVER_PREFERENCE__ENVIRONMENT_CONDITION = 4;

	/**
	 * The number of structural features of the '<em>Driver Preference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRIVER_PREFERENCE_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link intelligentMobility.impl.Knowledge_and_SkillImpl <em>Knowledge and Skill</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.impl.Knowledge_and_SkillImpl
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getKnowledge_and_Skill()
	 * @generated
	 */
	int KNOWLEDGE_AND_SKILL = 5;

	/**
	 * The feature id for the '<em><b>Driving Skill</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KNOWLEDGE_AND_SKILL__DRIVING_SKILL = 0;

	/**
	 * The feature id for the '<em><b>Traffic Sign Awareness</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KNOWLEDGE_AND_SKILL__TRAFFIC_SIGN_AWARENESS = 1;

	/**
	 * The feature id for the '<em><b>Regulation Awareness</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KNOWLEDGE_AND_SKILL__REGULATION_AWARENESS = 2;

	/**
	 * The feature id for the '<em><b>Lane Switch Preference Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KNOWLEDGE_AND_SKILL__LANE_SWITCH_PREFERENCE_LEVEL = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KNOWLEDGE_AND_SKILL__NAME = 4;

	/**
	 * The number of structural features of the '<em>Knowledge and Skill</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KNOWLEDGE_AND_SKILL_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link intelligentMobility.impl.Driver_EmotionImpl <em>Driver Emotion</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.impl.Driver_EmotionImpl
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getDriver_Emotion()
	 * @generated
	 */
	int DRIVER_EMOTION = 6;

	/**
	 * The feature id for the '<em><b>Drowsiness Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRIVER_EMOTION__DROWSINESS_LEVEL = 0;

	/**
	 * The feature id for the '<em><b>Impulse Control Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRIVER_EMOTION__IMPULSE_CONTROL_LEVEL = 1;

	/**
	 * The feature id for the '<em><b>Metanl Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRIVER_EMOTION__METANL_CONDITION = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRIVER_EMOTION__NAME = 3;

	/**
	 * The feature id for the '<em><b>Ecg Hr</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRIVER_EMOTION__ECG_HR = 4;

	/**
	 * The feature id for the '<em><b>Gsr</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRIVER_EMOTION__GSR = 5;

	/**
	 * The number of structural features of the '<em>Driver Emotion</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRIVER_EMOTION_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link intelligentMobility.impl.Driving_BehaviourImpl <em>Driving Behaviour</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.impl.Driving_BehaviourImpl
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getDriving_Behaviour()
	 * @generated
	 */
	int DRIVING_BEHAVIOUR = 7;

	/**
	 * The feature id for the '<em><b>Prep Distance For Destination</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRIVING_BEHAVIOUR__PREP_DISTANCE_FOR_DESTINATION = 0;

	/**
	 * The feature id for the '<em><b>Prep Distance For Turn</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRIVING_BEHAVIOUR__PREP_DISTANCE_FOR_TURN = 1;

	/**
	 * The feature id for the '<em><b>Initial Speed min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRIVING_BEHAVIOUR__INITIAL_SPEED_MIN = 2;

	/**
	 * The feature id for the '<em><b>Initial Speed max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRIVING_BEHAVIOUR__INITIAL_SPEED_MAX = 3;

	/**
	 * The feature id for the '<em><b>Initial Speed precision</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRIVING_BEHAVIOUR__INITIAL_SPEED_PRECISION = 4;

	/**
	 * The feature id for the '<em><b>Desired Speed min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRIVING_BEHAVIOUR__DESIRED_SPEED_MIN = 5;

	/**
	 * The feature id for the '<em><b>Desired Speed max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRIVING_BEHAVIOUR__DESIRED_SPEED_MAX = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRIVING_BEHAVIOUR__NAME = 7;

	/**
	 * The feature id for the '<em><b>Normal behaviour</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRIVING_BEHAVIOUR__NORMAL_BEHAVIOUR = 8;

	/**
	 * The feature id for the '<em><b>Steering Angle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRIVING_BEHAVIOUR__STEERING_ANGLE = 9;

	/**
	 * The feature id for the '<em><b>Throttle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRIVING_BEHAVIOUR__THROTTLE = 10;

	/**
	 * The feature id for the '<em><b>Brake</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRIVING_BEHAVIOUR__BRAKE = 11;

	/**
	 * The feature id for the '<em><b>Gear</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRIVING_BEHAVIOUR__GEAR = 12;

	/**
	 * The feature id for the '<em><b>Handbrake</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRIVING_BEHAVIOUR__HANDBRAKE = 13;

	/**
	 * The feature id for the '<em><b>Rpm</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRIVING_BEHAVIOUR__RPM = 14;

	/**
	 * The feature id for the '<em><b>Key Event</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRIVING_BEHAVIOUR__KEY_EVENT = 15;

	/**
	 * The feature id for the '<em><b>Pedal Angle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRIVING_BEHAVIOUR__PEDAL_ANGLE = 16;

	/**
	 * The feature id for the '<em><b>Pedal Pressure</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRIVING_BEHAVIOUR__PEDAL_PRESSURE = 17;

	/**
	 * The feature id for the '<em><b>Steer Speed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRIVING_BEHAVIOUR__STEER_SPEED = 18;

	/**
	 * The feature id for the '<em><b>Intent Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRIVING_BEHAVIOUR__INTENT_TYPE = 19;

	/**
	 * The feature id for the '<em><b>Confidence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRIVING_BEHAVIOUR__CONFIDENCE = 20;

	/**
	 * The feature id for the '<em><b>Goal</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRIVING_BEHAVIOUR__GOAL = 21;

	/**
	 * The number of structural features of the '<em>Driving Behaviour</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRIVING_BEHAVIOUR_FEATURE_COUNT = 22;

	/**
	 * The meta object id for the '{@link intelligentMobility.impl.Normal_BehaviourImpl <em>Normal Behaviour</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.impl.Normal_BehaviourImpl
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getNormal_Behaviour()
	 * @generated
	 */
	int NORMAL_BEHAVIOUR = 8;

	/**
	 * The feature id for the '<em><b>Following</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NORMAL_BEHAVIOUR__FOLLOWING = 0;

	/**
	 * The feature id for the '<em><b>Lanechanging</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NORMAL_BEHAVIOUR__LANECHANGING = 1;

	/**
	 * The number of structural features of the '<em>Normal Behaviour</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NORMAL_BEHAVIOUR_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link intelligentMobility.impl.FollowingImpl <em>Following</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.impl.FollowingImpl
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getFollowing()
	 * @generated
	 */
	int FOLLOWING = 9;

	/**
	 * The feature id for the '<em><b>Following Gap</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLLOWING__FOLLOWING_GAP = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLLOWING__NAME = 1;

	/**
	 * The feature id for the '<em><b>Min Gap</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLLOWING__MIN_GAP = 2;

	/**
	 * The feature id for the '<em><b>Forward</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLLOWING__FORWARD = 3;

	/**
	 * The feature id for the '<em><b>Backward</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLLOWING__BACKWARD = 4;

	/**
	 * The number of structural features of the '<em>Following</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLLOWING_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link intelligentMobility.impl.LaneChangingImpl <em>Lane Changing</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.impl.LaneChangingImpl
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getLaneChanging()
	 * @generated
	 */
	int LANE_CHANGING = 10;

	/**
	 * The feature id for the '<em><b>Lane Switch Speed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANE_CHANGING__LANE_SWITCH_SPEED = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANE_CHANGING__NAME = 1;

	/**
	 * The feature id for the '<em><b>Turn</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANE_CHANGING__TURN = 2;

	/**
	 * The feature id for the '<em><b>Gapacceptance</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANE_CHANGING__GAPACCEPTANCE = 3;

	/**
	 * The feature id for the '<em><b>Environment condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANE_CHANGING__ENVIRONMENT_CONDITION = 4;

	/**
	 * The feature id for the '<em><b>Left Lane Change</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANE_CHANGING__LEFT_LANE_CHANGE = 5;

	/**
	 * The feature id for the '<em><b>Right Lane Change</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANE_CHANGING__RIGHT_LANE_CHANGE = 6;

	/**
	 * The feature id for the '<em><b>Left Lane Branch</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANE_CHANGING__LEFT_LANE_BRANCH = 7;

	/**
	 * The feature id for the '<em><b>Right Lane Branch</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANE_CHANGING__RIGHT_LANE_BRANCH = 8;

	/**
	 * The feature id for the '<em><b>Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANE_CHANGING__ACTION = 9;

	/**
	 * The feature id for the '<em><b>Maneuver Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANE_CHANGING__MANEUVER_TYPE = 10;

	/**
	 * The feature id for the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANE_CHANGING__DURATION = 11;

	/**
	 * The number of structural features of the '<em>Lane Changing</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANE_CHANGING_FEATURE_COUNT = 12;

	/**
	 * The meta object id for the '{@link intelligentMobility.impl.Abnormal_BehaviourImpl <em>Abnormal Behaviour</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.impl.Abnormal_BehaviourImpl
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getAbnormal_Behaviour()
	 * @generated
	 */
	int ABNORMAL_BEHAVIOUR = 11;

	/**
	 * The feature id for the '<em><b>Following</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABNORMAL_BEHAVIOUR__FOLLOWING = NORMAL_BEHAVIOUR__FOLLOWING;

	/**
	 * The feature id for the '<em><b>Lanechanging</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABNORMAL_BEHAVIOUR__LANECHANGING = NORMAL_BEHAVIOUR__LANECHANGING;

	/**
	 * The feature id for the '<em><b>Zigzag Driving</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABNORMAL_BEHAVIOUR__ZIGZAG_DRIVING = NORMAL_BEHAVIOUR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Risky Acceleration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABNORMAL_BEHAVIOUR__RISKY_ACCELERATION = NORMAL_BEHAVIOUR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Risky Lanechanging</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABNORMAL_BEHAVIOUR__RISKY_LANECHANGING = NORMAL_BEHAVIOUR_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABNORMAL_BEHAVIOUR__NAME = NORMAL_BEHAVIOUR_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Actions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABNORMAL_BEHAVIOUR__ACTIONS = NORMAL_BEHAVIOUR_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Abnormal Behaviour</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABNORMAL_BEHAVIOUR_FEATURE_COUNT = NORMAL_BEHAVIOUR_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link intelligentMobility.impl.ActionImpl <em>Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.impl.ActionImpl
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getAction()
	 * @generated
	 */
	int ACTION = 16;

	/**
	 * The feature id for the '<em><b>Action Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__ACTION_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Timestamp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__TIMESTAMP = 1;

	/**
	 * The number of structural features of the '<em>Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link intelligentMobility.impl.ForwardImpl <em>Forward</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.impl.ForwardImpl
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getForward()
	 * @generated
	 */
	int FORWARD = 12;

	/**
	 * The feature id for the '<em><b>Action Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORWARD__ACTION_TYPE = ACTION__ACTION_TYPE;

	/**
	 * The feature id for the '<em><b>Timestamp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORWARD__TIMESTAMP = ACTION__TIMESTAMP;

	/**
	 * The feature id for the '<em><b>Acceleration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORWARD__ACCELERATION = ACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Deceleration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORWARD__DECELERATION = ACTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORWARD__NAME = ACTION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Forward</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORWARD_FEATURE_COUNT = ACTION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link intelligentMobility.impl.BackwardImpl <em>Backward</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.impl.BackwardImpl
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getBackward()
	 * @generated
	 */
	int BACKWARD = 13;

	/**
	 * The feature id for the '<em><b>Action Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BACKWARD__ACTION_TYPE = ACTION__ACTION_TYPE;

	/**
	 * The feature id for the '<em><b>Timestamp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BACKWARD__TIMESTAMP = ACTION__TIMESTAMP;

	/**
	 * The feature id for the '<em><b>Backward Speed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BACKWARD__BACKWARD_SPEED = ACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Back Distance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BACKWARD__BACK_DISTANCE = ACTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BACKWARD__NAME = ACTION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Backward</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BACKWARD_FEATURE_COUNT = ACTION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link intelligentMobility.impl.TurnImpl <em>Turn</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.impl.TurnImpl
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getTurn()
	 * @generated
	 */
	int TURN = 14;

	/**
	 * The feature id for the '<em><b>Action Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TURN__ACTION_TYPE = ACTION__ACTION_TYPE;

	/**
	 * The feature id for the '<em><b>Timestamp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TURN__TIMESTAMP = ACTION__TIMESTAMP;

	/**
	 * The feature id for the '<em><b>Turn Side</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TURN__TURN_SIDE = ACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TURN__NAME = ACTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Turn</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TURN_FEATURE_COUNT = ACTION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link intelligentMobility.impl.GapAcceptanceImpl <em>Gap Acceptance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.impl.GapAcceptanceImpl
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getGapAcceptance()
	 * @generated
	 */
	int GAP_ACCEPTANCE = 15;

	/**
	 * The feature id for the '<em><b>Lag Gap</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAP_ACCEPTANCE__LAG_GAP = 0;

	/**
	 * The feature id for the '<em><b>Lead Gap</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAP_ACCEPTANCE__LEAD_GAP = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAP_ACCEPTANCE__NAME = 2;

	/**
	 * The number of structural features of the '<em>Gap Acceptance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAP_ACCEPTANCE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link intelligentMobility.impl.Vehicle_TypeImpl <em>Vehicle Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.impl.Vehicle_TypeImpl
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getVehicle_Type()
	 * @generated
	 */
	int VEHICLE_TYPE = 17;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE_TYPE__TYPE = 0;

	/**
	 * The feature id for the '<em><b>Max Speed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE_TYPE__MAX_SPEED = 1;

	/**
	 * The feature id for the '<em><b>Vehicle Width min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE_TYPE__VEHICLE_WIDTH_MIN = 2;

	/**
	 * The feature id for the '<em><b>Vehicle Width max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE_TYPE__VEHICLE_WIDTH_MAX = 3;

	/**
	 * The feature id for the '<em><b>Vehicle Width precision</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE_TYPE__VEHICLE_WIDTH_PRECISION = 4;

	/**
	 * The feature id for the '<em><b>Vehicle Length min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE_TYPE__VEHICLE_LENGTH_MIN = 5;

	/**
	 * The feature id for the '<em><b>Vehicle Length max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE_TYPE__VEHICLE_LENGTH_MAX = 6;

	/**
	 * The feature id for the '<em><b>Vehicle Length precision</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE_TYPE__VEHICLE_LENGTH_PRECISION = 7;

	/**
	 * The feature id for the '<em><b>Vehicle Height min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE_TYPE__VEHICLE_HEIGHT_MIN = 8;

	/**
	 * The feature id for the '<em><b>Vehicle Height max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE_TYPE__VEHICLE_HEIGHT_MAX = 9;

	/**
	 * The feature id for the '<em><b>Vehicle Height precision</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE_TYPE__VEHICLE_HEIGHT_PRECISION = 10;

	/**
	 * The feature id for the '<em><b>Speed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE_TYPE__SPEED = 11;

	/**
	 * The feature id for the '<em><b>Stop</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE_TYPE__STOP = 12;

	/**
	 * The number of structural features of the '<em>Vehicle Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE_TYPE_FEATURE_COUNT = 13;

	/**
	 * The meta object id for the '{@link intelligentMobility.impl.PlatoonImpl <em>Platoon</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.impl.PlatoonImpl
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getPlatoon()
	 * @generated
	 */
	int PLATOON = 18;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATOON__TYPE = VEHICLE_TYPE__TYPE;

	/**
	 * The feature id for the '<em><b>Max Speed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATOON__MAX_SPEED = VEHICLE_TYPE__MAX_SPEED;

	/**
	 * The feature id for the '<em><b>Vehicle Width min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATOON__VEHICLE_WIDTH_MIN = VEHICLE_TYPE__VEHICLE_WIDTH_MIN;

	/**
	 * The feature id for the '<em><b>Vehicle Width max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATOON__VEHICLE_WIDTH_MAX = VEHICLE_TYPE__VEHICLE_WIDTH_MAX;

	/**
	 * The feature id for the '<em><b>Vehicle Width precision</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATOON__VEHICLE_WIDTH_PRECISION = VEHICLE_TYPE__VEHICLE_WIDTH_PRECISION;

	/**
	 * The feature id for the '<em><b>Vehicle Length min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATOON__VEHICLE_LENGTH_MIN = VEHICLE_TYPE__VEHICLE_LENGTH_MIN;

	/**
	 * The feature id for the '<em><b>Vehicle Length max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATOON__VEHICLE_LENGTH_MAX = VEHICLE_TYPE__VEHICLE_LENGTH_MAX;

	/**
	 * The feature id for the '<em><b>Vehicle Length precision</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATOON__VEHICLE_LENGTH_PRECISION = VEHICLE_TYPE__VEHICLE_LENGTH_PRECISION;

	/**
	 * The feature id for the '<em><b>Vehicle Height min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATOON__VEHICLE_HEIGHT_MIN = VEHICLE_TYPE__VEHICLE_HEIGHT_MIN;

	/**
	 * The feature id for the '<em><b>Vehicle Height max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATOON__VEHICLE_HEIGHT_MAX = VEHICLE_TYPE__VEHICLE_HEIGHT_MAX;

	/**
	 * The feature id for the '<em><b>Vehicle Height precision</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATOON__VEHICLE_HEIGHT_PRECISION = VEHICLE_TYPE__VEHICLE_HEIGHT_PRECISION;

	/**
	 * The feature id for the '<em><b>Speed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATOON__SPEED = VEHICLE_TYPE__SPEED;

	/**
	 * The feature id for the '<em><b>Stop</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATOON__STOP = VEHICLE_TYPE__STOP;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATOON__NAME = VEHICLE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>V2v Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATOON__V2V_TIME = VEHICLE_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Follower Count</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATOON__FOLLOWER_COUNT = VEHICLE_TYPE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Reset Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATOON__RESET_COLOR = VEHICLE_TYPE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Color Rmin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATOON__COLOR_RMIN = VEHICLE_TYPE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Color Rmax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATOON__COLOR_RMAX = VEHICLE_TYPE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Color Gmin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATOON__COLOR_GMIN = VEHICLE_TYPE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Color Gmax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATOON__COLOR_GMAX = VEHICLE_TYPE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Color Bmin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATOON__COLOR_BMIN = VEHICLE_TYPE_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Color Bmax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATOON__COLOR_BMAX = VEHICLE_TYPE_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Leading vehicle</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATOON__LEADING_VEHICLE = VEHICLE_TYPE_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Following vehicle</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATOON__FOLLOWING_VEHICLE = VEHICLE_TYPE_FEATURE_COUNT + 11;

	/**
	 * The number of structural features of the '<em>Platoon</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATOON_FEATURE_COUNT = VEHICLE_TYPE_FEATURE_COUNT + 12;

	/**
	 * The meta object id for the '{@link intelligentMobility.impl.Normal_VehicleImpl <em>Normal Vehicle</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.impl.Normal_VehicleImpl
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getNormal_Vehicle()
	 * @generated
	 */
	int NORMAL_VEHICLE = 19;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NORMAL_VEHICLE__TYPE = VEHICLE_TYPE__TYPE;

	/**
	 * The feature id for the '<em><b>Max Speed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NORMAL_VEHICLE__MAX_SPEED = VEHICLE_TYPE__MAX_SPEED;

	/**
	 * The feature id for the '<em><b>Vehicle Width min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NORMAL_VEHICLE__VEHICLE_WIDTH_MIN = VEHICLE_TYPE__VEHICLE_WIDTH_MIN;

	/**
	 * The feature id for the '<em><b>Vehicle Width max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NORMAL_VEHICLE__VEHICLE_WIDTH_MAX = VEHICLE_TYPE__VEHICLE_WIDTH_MAX;

	/**
	 * The feature id for the '<em><b>Vehicle Width precision</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NORMAL_VEHICLE__VEHICLE_WIDTH_PRECISION = VEHICLE_TYPE__VEHICLE_WIDTH_PRECISION;

	/**
	 * The feature id for the '<em><b>Vehicle Length min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NORMAL_VEHICLE__VEHICLE_LENGTH_MIN = VEHICLE_TYPE__VEHICLE_LENGTH_MIN;

	/**
	 * The feature id for the '<em><b>Vehicle Length max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NORMAL_VEHICLE__VEHICLE_LENGTH_MAX = VEHICLE_TYPE__VEHICLE_LENGTH_MAX;

	/**
	 * The feature id for the '<em><b>Vehicle Length precision</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NORMAL_VEHICLE__VEHICLE_LENGTH_PRECISION = VEHICLE_TYPE__VEHICLE_LENGTH_PRECISION;

	/**
	 * The feature id for the '<em><b>Vehicle Height min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NORMAL_VEHICLE__VEHICLE_HEIGHT_MIN = VEHICLE_TYPE__VEHICLE_HEIGHT_MIN;

	/**
	 * The feature id for the '<em><b>Vehicle Height max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NORMAL_VEHICLE__VEHICLE_HEIGHT_MAX = VEHICLE_TYPE__VEHICLE_HEIGHT_MAX;

	/**
	 * The feature id for the '<em><b>Vehicle Height precision</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NORMAL_VEHICLE__VEHICLE_HEIGHT_PRECISION = VEHICLE_TYPE__VEHICLE_HEIGHT_PRECISION;

	/**
	 * The feature id for the '<em><b>Speed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NORMAL_VEHICLE__SPEED = VEHICLE_TYPE__SPEED;

	/**
	 * The feature id for the '<em><b>Stop</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NORMAL_VEHICLE__STOP = VEHICLE_TYPE__STOP;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NORMAL_VEHICLE__NAME = VEHICLE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Reset Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NORMAL_VEHICLE__RESET_COLOR = VEHICLE_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Color Rmin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NORMAL_VEHICLE__COLOR_RMIN = VEHICLE_TYPE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Color Rmax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NORMAL_VEHICLE__COLOR_RMAX = VEHICLE_TYPE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Color Gmin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NORMAL_VEHICLE__COLOR_GMIN = VEHICLE_TYPE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Color Gmax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NORMAL_VEHICLE__COLOR_GMAX = VEHICLE_TYPE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Color Bmin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NORMAL_VEHICLE__COLOR_BMIN = VEHICLE_TYPE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Color Bmax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NORMAL_VEHICLE__COLOR_BMAX = VEHICLE_TYPE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Safety requirements</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NORMAL_VEHICLE__SAFETY_REQUIREMENTS = VEHICLE_TYPE_FEATURE_COUNT + 8;

	/**
	 * The number of structural features of the '<em>Normal Vehicle</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NORMAL_VEHICLE_FEATURE_COUNT = VEHICLE_TYPE_FEATURE_COUNT + 9;

	/**
	 * The meta object id for the '{@link intelligentMobility.impl.PlatoonMemberImpl <em>Platoon Member</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.impl.PlatoonMemberImpl
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getPlatoonMember()
	 * @generated
	 */
	int PLATOON_MEMBER = 22;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATOON_MEMBER__TYPE = NORMAL_VEHICLE__TYPE;

	/**
	 * The feature id for the '<em><b>Max Speed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATOON_MEMBER__MAX_SPEED = NORMAL_VEHICLE__MAX_SPEED;

	/**
	 * The feature id for the '<em><b>Vehicle Width min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATOON_MEMBER__VEHICLE_WIDTH_MIN = NORMAL_VEHICLE__VEHICLE_WIDTH_MIN;

	/**
	 * The feature id for the '<em><b>Vehicle Width max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATOON_MEMBER__VEHICLE_WIDTH_MAX = NORMAL_VEHICLE__VEHICLE_WIDTH_MAX;

	/**
	 * The feature id for the '<em><b>Vehicle Width precision</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATOON_MEMBER__VEHICLE_WIDTH_PRECISION = NORMAL_VEHICLE__VEHICLE_WIDTH_PRECISION;

	/**
	 * The feature id for the '<em><b>Vehicle Length min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATOON_MEMBER__VEHICLE_LENGTH_MIN = NORMAL_VEHICLE__VEHICLE_LENGTH_MIN;

	/**
	 * The feature id for the '<em><b>Vehicle Length max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATOON_MEMBER__VEHICLE_LENGTH_MAX = NORMAL_VEHICLE__VEHICLE_LENGTH_MAX;

	/**
	 * The feature id for the '<em><b>Vehicle Length precision</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATOON_MEMBER__VEHICLE_LENGTH_PRECISION = NORMAL_VEHICLE__VEHICLE_LENGTH_PRECISION;

	/**
	 * The feature id for the '<em><b>Vehicle Height min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATOON_MEMBER__VEHICLE_HEIGHT_MIN = NORMAL_VEHICLE__VEHICLE_HEIGHT_MIN;

	/**
	 * The feature id for the '<em><b>Vehicle Height max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATOON_MEMBER__VEHICLE_HEIGHT_MAX = NORMAL_VEHICLE__VEHICLE_HEIGHT_MAX;

	/**
	 * The feature id for the '<em><b>Vehicle Height precision</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATOON_MEMBER__VEHICLE_HEIGHT_PRECISION = NORMAL_VEHICLE__VEHICLE_HEIGHT_PRECISION;

	/**
	 * The feature id for the '<em><b>Speed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATOON_MEMBER__SPEED = NORMAL_VEHICLE__SPEED;

	/**
	 * The feature id for the '<em><b>Stop</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATOON_MEMBER__STOP = NORMAL_VEHICLE__STOP;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATOON_MEMBER__NAME = NORMAL_VEHICLE__NAME;

	/**
	 * The feature id for the '<em><b>Reset Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATOON_MEMBER__RESET_COLOR = NORMAL_VEHICLE__RESET_COLOR;

	/**
	 * The feature id for the '<em><b>Color Rmin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATOON_MEMBER__COLOR_RMIN = NORMAL_VEHICLE__COLOR_RMIN;

	/**
	 * The feature id for the '<em><b>Color Rmax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATOON_MEMBER__COLOR_RMAX = NORMAL_VEHICLE__COLOR_RMAX;

	/**
	 * The feature id for the '<em><b>Color Gmin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATOON_MEMBER__COLOR_GMIN = NORMAL_VEHICLE__COLOR_GMIN;

	/**
	 * The feature id for the '<em><b>Color Gmax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATOON_MEMBER__COLOR_GMAX = NORMAL_VEHICLE__COLOR_GMAX;

	/**
	 * The feature id for the '<em><b>Color Bmin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATOON_MEMBER__COLOR_BMIN = NORMAL_VEHICLE__COLOR_BMIN;

	/**
	 * The feature id for the '<em><b>Color Bmax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATOON_MEMBER__COLOR_BMAX = NORMAL_VEHICLE__COLOR_BMAX;

	/**
	 * The feature id for the '<em><b>Safety requirements</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATOON_MEMBER__SAFETY_REQUIREMENTS = NORMAL_VEHICLE__SAFETY_REQUIREMENTS;

	/**
	 * The number of structural features of the '<em>Platoon Member</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATOON_MEMBER_FEATURE_COUNT = NORMAL_VEHICLE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link intelligentMobility.impl.Leading_VehicleImpl <em>Leading Vehicle</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.impl.Leading_VehicleImpl
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getLeading_Vehicle()
	 * @generated
	 */
	int LEADING_VEHICLE = 20;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEADING_VEHICLE__TYPE = PLATOON_MEMBER__TYPE;

	/**
	 * The feature id for the '<em><b>Max Speed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEADING_VEHICLE__MAX_SPEED = PLATOON_MEMBER__MAX_SPEED;

	/**
	 * The feature id for the '<em><b>Vehicle Width min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEADING_VEHICLE__VEHICLE_WIDTH_MIN = PLATOON_MEMBER__VEHICLE_WIDTH_MIN;

	/**
	 * The feature id for the '<em><b>Vehicle Width max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEADING_VEHICLE__VEHICLE_WIDTH_MAX = PLATOON_MEMBER__VEHICLE_WIDTH_MAX;

	/**
	 * The feature id for the '<em><b>Vehicle Width precision</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEADING_VEHICLE__VEHICLE_WIDTH_PRECISION = PLATOON_MEMBER__VEHICLE_WIDTH_PRECISION;

	/**
	 * The feature id for the '<em><b>Vehicle Length min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEADING_VEHICLE__VEHICLE_LENGTH_MIN = PLATOON_MEMBER__VEHICLE_LENGTH_MIN;

	/**
	 * The feature id for the '<em><b>Vehicle Length max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEADING_VEHICLE__VEHICLE_LENGTH_MAX = PLATOON_MEMBER__VEHICLE_LENGTH_MAX;

	/**
	 * The feature id for the '<em><b>Vehicle Length precision</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEADING_VEHICLE__VEHICLE_LENGTH_PRECISION = PLATOON_MEMBER__VEHICLE_LENGTH_PRECISION;

	/**
	 * The feature id for the '<em><b>Vehicle Height min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEADING_VEHICLE__VEHICLE_HEIGHT_MIN = PLATOON_MEMBER__VEHICLE_HEIGHT_MIN;

	/**
	 * The feature id for the '<em><b>Vehicle Height max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEADING_VEHICLE__VEHICLE_HEIGHT_MAX = PLATOON_MEMBER__VEHICLE_HEIGHT_MAX;

	/**
	 * The feature id for the '<em><b>Vehicle Height precision</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEADING_VEHICLE__VEHICLE_HEIGHT_PRECISION = PLATOON_MEMBER__VEHICLE_HEIGHT_PRECISION;

	/**
	 * The feature id for the '<em><b>Speed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEADING_VEHICLE__SPEED = PLATOON_MEMBER__SPEED;

	/**
	 * The feature id for the '<em><b>Stop</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEADING_VEHICLE__STOP = PLATOON_MEMBER__STOP;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEADING_VEHICLE__NAME = PLATOON_MEMBER__NAME;

	/**
	 * The feature id for the '<em><b>Reset Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEADING_VEHICLE__RESET_COLOR = PLATOON_MEMBER__RESET_COLOR;

	/**
	 * The feature id for the '<em><b>Color Rmin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEADING_VEHICLE__COLOR_RMIN = PLATOON_MEMBER__COLOR_RMIN;

	/**
	 * The feature id for the '<em><b>Color Rmax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEADING_VEHICLE__COLOR_RMAX = PLATOON_MEMBER__COLOR_RMAX;

	/**
	 * The feature id for the '<em><b>Color Gmin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEADING_VEHICLE__COLOR_GMIN = PLATOON_MEMBER__COLOR_GMIN;

	/**
	 * The feature id for the '<em><b>Color Gmax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEADING_VEHICLE__COLOR_GMAX = PLATOON_MEMBER__COLOR_GMAX;

	/**
	 * The feature id for the '<em><b>Color Bmin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEADING_VEHICLE__COLOR_BMIN = PLATOON_MEMBER__COLOR_BMIN;

	/**
	 * The feature id for the '<em><b>Color Bmax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEADING_VEHICLE__COLOR_BMAX = PLATOON_MEMBER__COLOR_BMAX;

	/**
	 * The feature id for the '<em><b>Safety requirements</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEADING_VEHICLE__SAFETY_REQUIREMENTS = PLATOON_MEMBER__SAFETY_REQUIREMENTS;

	/**
	 * The number of structural features of the '<em>Leading Vehicle</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEADING_VEHICLE_FEATURE_COUNT = PLATOON_MEMBER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link intelligentMobility.impl.Following_VehicleImpl <em>Following Vehicle</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.impl.Following_VehicleImpl
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getFollowing_Vehicle()
	 * @generated
	 */
	int FOLLOWING_VEHICLE = 21;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLLOWING_VEHICLE__TYPE = PLATOON_MEMBER__TYPE;

	/**
	 * The feature id for the '<em><b>Max Speed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLLOWING_VEHICLE__MAX_SPEED = PLATOON_MEMBER__MAX_SPEED;

	/**
	 * The feature id for the '<em><b>Vehicle Width min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLLOWING_VEHICLE__VEHICLE_WIDTH_MIN = PLATOON_MEMBER__VEHICLE_WIDTH_MIN;

	/**
	 * The feature id for the '<em><b>Vehicle Width max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLLOWING_VEHICLE__VEHICLE_WIDTH_MAX = PLATOON_MEMBER__VEHICLE_WIDTH_MAX;

	/**
	 * The feature id for the '<em><b>Vehicle Width precision</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLLOWING_VEHICLE__VEHICLE_WIDTH_PRECISION = PLATOON_MEMBER__VEHICLE_WIDTH_PRECISION;

	/**
	 * The feature id for the '<em><b>Vehicle Length min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLLOWING_VEHICLE__VEHICLE_LENGTH_MIN = PLATOON_MEMBER__VEHICLE_LENGTH_MIN;

	/**
	 * The feature id for the '<em><b>Vehicle Length max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLLOWING_VEHICLE__VEHICLE_LENGTH_MAX = PLATOON_MEMBER__VEHICLE_LENGTH_MAX;

	/**
	 * The feature id for the '<em><b>Vehicle Length precision</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLLOWING_VEHICLE__VEHICLE_LENGTH_PRECISION = PLATOON_MEMBER__VEHICLE_LENGTH_PRECISION;

	/**
	 * The feature id for the '<em><b>Vehicle Height min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLLOWING_VEHICLE__VEHICLE_HEIGHT_MIN = PLATOON_MEMBER__VEHICLE_HEIGHT_MIN;

	/**
	 * The feature id for the '<em><b>Vehicle Height max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLLOWING_VEHICLE__VEHICLE_HEIGHT_MAX = PLATOON_MEMBER__VEHICLE_HEIGHT_MAX;

	/**
	 * The feature id for the '<em><b>Vehicle Height precision</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLLOWING_VEHICLE__VEHICLE_HEIGHT_PRECISION = PLATOON_MEMBER__VEHICLE_HEIGHT_PRECISION;

	/**
	 * The feature id for the '<em><b>Speed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLLOWING_VEHICLE__SPEED = PLATOON_MEMBER__SPEED;

	/**
	 * The feature id for the '<em><b>Stop</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLLOWING_VEHICLE__STOP = PLATOON_MEMBER__STOP;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLLOWING_VEHICLE__NAME = PLATOON_MEMBER__NAME;

	/**
	 * The feature id for the '<em><b>Reset Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLLOWING_VEHICLE__RESET_COLOR = PLATOON_MEMBER__RESET_COLOR;

	/**
	 * The feature id for the '<em><b>Color Rmin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLLOWING_VEHICLE__COLOR_RMIN = PLATOON_MEMBER__COLOR_RMIN;

	/**
	 * The feature id for the '<em><b>Color Rmax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLLOWING_VEHICLE__COLOR_RMAX = PLATOON_MEMBER__COLOR_RMAX;

	/**
	 * The feature id for the '<em><b>Color Gmin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLLOWING_VEHICLE__COLOR_GMIN = PLATOON_MEMBER__COLOR_GMIN;

	/**
	 * The feature id for the '<em><b>Color Gmax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLLOWING_VEHICLE__COLOR_GMAX = PLATOON_MEMBER__COLOR_GMAX;

	/**
	 * The feature id for the '<em><b>Color Bmin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLLOWING_VEHICLE__COLOR_BMIN = PLATOON_MEMBER__COLOR_BMIN;

	/**
	 * The feature id for the '<em><b>Color Bmax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLLOWING_VEHICLE__COLOR_BMAX = PLATOON_MEMBER__COLOR_BMAX;

	/**
	 * The feature id for the '<em><b>Safety requirements</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLLOWING_VEHICLE__SAFETY_REQUIREMENTS = PLATOON_MEMBER__SAFETY_REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Headway Min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLLOWING_VEHICLE__HEADWAY_MIN = PLATOON_MEMBER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Headway Max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLLOWING_VEHICLE__HEADWAY_MAX = PLATOON_MEMBER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Frontvehicle</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLLOWING_VEHICLE__FRONTVEHICLE = PLATOON_MEMBER_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Following Vehicle</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLLOWING_VEHICLE_FEATURE_COUNT = PLATOON_MEMBER_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link intelligentMobility.impl.PossibleVehicleImpl <em>Possible Vehicle</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.impl.PossibleVehicleImpl
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getPossibleVehicle()
	 * @generated
	 */
	int POSSIBLE_VEHICLE = 23;

	/**
	 * The feature id for the '<em><b>Vehicle Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSSIBLE_VEHICLE__VEHICLE_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Amount Percentage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSSIBLE_VEHICLE__AMOUNT_PERCENTAGE = 1;

	/**
	 * The feature id for the '<em><b>Simulation Order Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSSIBLE_VEHICLE__SIMULATION_ORDER_INDEX = 2;

	/**
	 * The number of structural features of the '<em>Possible Vehicle</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSSIBLE_VEHICLE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link intelligentMobility.impl.Environment_ConditionImpl <em>Environment Condition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.impl.Environment_ConditionImpl
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getEnvironment_Condition()
	 * @generated
	 */
	int ENVIRONMENT_CONDITION = 24;

	/**
	 * The feature id for the '<em><b>Road Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT_CONDITION__ROAD_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Lane Amount</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT_CONDITION__LANE_AMOUNT = 1;

	/**
	 * The feature id for the '<em><b>Name Environment Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT_CONDITION__NAME_ENVIRONMENT_CONDITION = 2;

	/**
	 * The feature id for the '<em><b>Lane type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT_CONDITION__LANE_TYPE = 3;

	/**
	 * The feature id for the '<em><b>Regulations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT_CONDITION__REGULATIONS = 4;

	/**
	 * The feature id for the '<em><b>Weather</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT_CONDITION__WEATHER = 5;

	/**
	 * The feature id for the '<em><b>Traffic condition</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT_CONDITION__TRAFFIC_CONDITION = 6;

	/**
	 * The feature id for the '<em><b>Special condition</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT_CONDITION__SPECIAL_CONDITION = 7;

	/**
	 * The feature id for the '<em><b>Cue Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT_CONDITION__CUE_TYPE = 8;

	/**
	 * The feature id for the '<em><b>Salience</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT_CONDITION__SALIENCE = 9;

	/**
	 * The feature id for the '<em><b>Position</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT_CONDITION__POSITION = 10;

	/**
	 * The number of structural features of the '<em>Environment Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT_CONDITION_FEATURE_COUNT = 11;

	/**
	 * The meta object id for the '{@link intelligentMobility.impl.Lane_TypeImpl <em>Lane Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.impl.Lane_TypeImpl
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getLane_Type()
	 * @generated
	 */
	int LANE_TYPE = 25;

	/**
	 * The feature id for the '<em><b>Lane Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANE_TYPE__LANE_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Lane Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANE_TYPE__LANE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Lane Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANE_TYPE__LANE_WIDTH = 2;

	/**
	 * The feature id for the '<em><b>Lane Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANE_TYPE__LANE_LENGTH = 3;

	/**
	 * The feature id for the '<em><b>Max Speed Limitation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANE_TYPE__MAX_SPEED_LIMITATION = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANE_TYPE__NAME = 5;

	/**
	 * The feature id for the '<em><b>Regulations</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANE_TYPE__REGULATIONS = 6;

	/**
	 * The number of structural features of the '<em>Lane Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANE_TYPE_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the '{@link intelligentMobility.impl.RegulationImpl <em>Regulation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.impl.RegulationImpl
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getRegulation()
	 * @generated
	 */
	int REGULATION = 26;

	/**
	 * The feature id for the '<em><b>Legislation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGULATION__LEGISLATION = 0;

	/**
	 * The feature id for the '<em><b>Courtesy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGULATION__COURTESY = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGULATION__NAME = 2;

	/**
	 * The number of structural features of the '<em>Regulation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGULATION_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link intelligentMobility.impl.Safety_RequirementImpl <em>Safety Requirement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.impl.Safety_RequirementImpl
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getSafety_Requirement()
	 * @generated
	 */
	int SAFETY_REQUIREMENT = 27;

	/**
	 * The feature id for the '<em><b>Safe Second</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAFETY_REQUIREMENT__SAFE_SECOND = 0;

	/**
	 * The feature id for the '<em><b>Safezone Length default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAFETY_REQUIREMENT__SAFEZONE_LENGTH_DEFAULT = 1;

	/**
	 * The feature id for the '<em><b>Safe Front Min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAFETY_REQUIREMENT__SAFE_FRONT_MIN = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAFETY_REQUIREMENT__NAME = 3;

	/**
	 * The feature id for the '<em><b>Regulations</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAFETY_REQUIREMENT__REGULATIONS = 4;

	/**
	 * The number of structural features of the '<em>Safety Requirement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAFETY_REQUIREMENT_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link intelligentMobility.impl.WeatherImpl <em>Weather</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.impl.WeatherImpl
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getWeather()
	 * @generated
	 */
	int WEATHER = 28;

	/**
	 * The feature id for the '<em><b>Slipperiness</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEATHER__SLIPPERINESS = 0;

	/**
	 * The feature id for the '<em><b>Weather Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEATHER__WEATHER_TYPE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEATHER__NAME = 2;

	/**
	 * The number of structural features of the '<em>Weather</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEATHER_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link intelligentMobility.impl.Traffic_SituationImpl <em>Traffic Situation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.impl.Traffic_SituationImpl
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getTraffic_Situation()
	 * @generated
	 */
	int TRAFFIC_SITUATION = 29;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRAFFIC_SITUATION__NAME = 0;

	/**
	 * The feature id for the '<em><b>Traffic Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRAFFIC_SITUATION__TRAFFIC_TYPE = 1;

	/**
	 * The feature id for the '<em><b>Stimulus Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRAFFIC_SITUATION__STIMULUS_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Intensity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRAFFIC_SITUATION__INTENSITY = 3;

	/**
	 * The number of structural features of the '<em>Traffic Situation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRAFFIC_SITUATION_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link intelligentMobility.impl.Special_ConditionImpl <em>Special Condition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.impl.Special_ConditionImpl
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getSpecial_Condition()
	 * @generated
	 */
	int SPECIAL_CONDITION = 30;

	/**
	 * The feature id for the '<em><b>Condition Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIAL_CONDITION__CONDITION_NAME = 0;

	/**
	 * The feature id for the '<em><b>Collision</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIAL_CONDITION__COLLISION = 1;

	/**
	 * The feature id for the '<em><b>Intersection</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIAL_CONDITION__INTERSECTION = 2;

	/**
	 * The number of structural features of the '<em>Special Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIAL_CONDITION_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link intelligentMobility.impl.ExceptionConditionImpl <em>Exception Condition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.impl.ExceptionConditionImpl
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getExceptionCondition()
	 * @generated
	 */
	int EXCEPTION_CONDITION = 35;

	/**
	 * The number of structural features of the '<em>Exception Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCEPTION_CONDITION_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link intelligentMobility.impl.CollisionImpl <em>Collision</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.impl.CollisionImpl
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getCollision()
	 * @generated
	 */
	int COLLISION = 31;

	/**
	 * The feature id for the '<em><b>Recovery Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLISION__RECOVERY_TIME = EXCEPTION_CONDITION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLISION__NAME = EXCEPTION_CONDITION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Obstructions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLISION__OBSTRUCTIONS = EXCEPTION_CONDITION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Collision</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLISION_FEATURE_COUNT = EXCEPTION_CONDITION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link intelligentMobility.impl.IntersectionImpl <em>Intersection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.impl.IntersectionImpl
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getIntersection()
	 * @generated
	 */
	int INTERSECTION = 32;

	/**
	 * The feature id for the '<em><b>Communicates With</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERSECTION__COMMUNICATES_WITH = EXCEPTION_CONDITION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERSECTION__NAME = EXCEPTION_CONDITION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Traffic lights</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERSECTION__TRAFFIC_LIGHTS = EXCEPTION_CONDITION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Cross Intersection</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERSECTION__CROSS_INTERSECTION = EXCEPTION_CONDITION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Cross Railway</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERSECTION__CROSS_RAILWAY = EXCEPTION_CONDITION_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Intersection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERSECTION_FEATURE_COUNT = EXCEPTION_CONDITION_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link intelligentMobility.impl.ObstructionImpl <em>Obstruction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.impl.ObstructionImpl
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getObstruction()
	 * @generated
	 */
	int OBSTRUCTION = 33;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBSTRUCTION__NAME = 0;

	/**
	 * The feature id for the '<em><b>Obstacle Location X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBSTRUCTION__OBSTACLE_LOCATION_X = 1;

	/**
	 * The feature id for the '<em><b>Obstacle Location Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBSTRUCTION__OBSTACLE_LOCATION_Y = 2;

	/**
	 * The number of structural features of the '<em>Obstruction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBSTRUCTION_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link intelligentMobility.impl.InfrastructureImpl <em>Infrastructure</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.impl.InfrastructureImpl
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getInfrastructure()
	 * @generated
	 */
	int INFRASTRUCTURE = 70;

	/**
	 * The feature id for the '<em><b>Communicates With</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFRASTRUCTURE__COMMUNICATES_WITH = 0;

	/**
	 * The number of structural features of the '<em>Infrastructure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFRASTRUCTURE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link intelligentMobility.impl.Traffic_LightImpl <em>Traffic Light</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.impl.Traffic_LightImpl
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getTraffic_Light()
	 * @generated
	 */
	int TRAFFIC_LIGHT = 34;

	/**
	 * The feature id for the '<em><b>Communicates With</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRAFFIC_LIGHT__COMMUNICATES_WITH = INFRASTRUCTURE__COMMUNICATES_WITH;

	/**
	 * The feature id for the '<em><b>Enforces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRAFFIC_LIGHT__ENFORCES = INFRASTRUCTURE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRAFFIC_LIGHT__NAME = INFRASTRUCTURE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Traffic Light</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRAFFIC_LIGHT_FEATURE_COUNT = INFRASTRUCTURE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link intelligentMobility.impl.Link_Driver_EnvironmentImpl <em>Link Driver Environment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.impl.Link_Driver_EnvironmentImpl
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getLink_Driver_Environment()
	 * @generated
	 */
	int LINK_DRIVER_ENVIRONMENT = 36;

	/**
	 * The feature id for the '<em><b>Link name driver environment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_DRIVER_ENVIRONMENT__LINK_NAME_DRIVER_ENVIRONMENT = 0;

	/**
	 * The feature id for the '<em><b>Link driver profile</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_DRIVER_ENVIRONMENT__LINK_DRIVER_PROFILE = 1;

	/**
	 * The feature id for the '<em><b>Link environment background</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_DRIVER_ENVIRONMENT__LINK_ENVIRONMENT_BACKGROUND = 2;

	/**
	 * The number of structural features of the '<em>Link Driver Environment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_DRIVER_ENVIRONMENT_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link intelligentMobility.impl.Link_Driver_VehicleImpl <em>Link Driver Vehicle</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.impl.Link_Driver_VehicleImpl
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getLink_Driver_Vehicle()
	 * @generated
	 */
	int LINK_DRIVER_VEHICLE = 37;

	/**
	 * The feature id for the '<em><b>Link name driver vehicle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_DRIVER_VEHICLE__LINK_NAME_DRIVER_VEHICLE = 0;

	/**
	 * The feature id for the '<em><b>Link driver profile</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_DRIVER_VEHICLE__LINK_DRIVER_PROFILE = 1;

	/**
	 * The feature id for the '<em><b>Link vehicle configuration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_DRIVER_VEHICLE__LINK_VEHICLE_CONFIGURATION = 2;

	/**
	 * The number of structural features of the '<em>Link Driver Vehicle</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_DRIVER_VEHICLE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link intelligentMobility.impl.Link_Vehicle_EnvironmentImpl <em>Link Vehicle Environment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.impl.Link_Vehicle_EnvironmentImpl
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getLink_Vehicle_Environment()
	 * @generated
	 */
	int LINK_VEHICLE_ENVIRONMENT = 38;

	/**
	 * The feature id for the '<em><b>Link name vehicle environment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_VEHICLE_ENVIRONMENT__LINK_NAME_VEHICLE_ENVIRONMENT = 0;

	/**
	 * The feature id for the '<em><b>Link vehicle configuration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_VEHICLE_ENVIRONMENT__LINK_VEHICLE_CONFIGURATION = 1;

	/**
	 * The feature id for the '<em><b>Link environment background</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_VEHICLE_ENVIRONMENT__LINK_ENVIRONMENT_BACKGROUND = 2;

	/**
	 * The number of structural features of the '<em>Link Vehicle Environment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_VEHICLE_ENVIRONMENT_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link intelligentMobility.impl.Link_DriverProfile_DriverPreferenceImpl <em>Link Driver Profile Driver Preference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.impl.Link_DriverProfile_DriverPreferenceImpl
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getLink_DriverProfile_DriverPreference()
	 * @generated
	 */
	int LINK_DRIVER_PROFILE_DRIVER_PREFERENCE = 39;

	/**
	 * The feature id for the '<em><b>Name link profile preference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_DRIVER_PROFILE_DRIVER_PREFERENCE__NAME_LINK_PROFILE_PREFERENCE = 0;

	/**
	 * The feature id for the '<em><b>Link driver profile</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_DRIVER_PROFILE_DRIVER_PREFERENCE__LINK_DRIVER_PROFILE = 1;

	/**
	 * The feature id for the '<em><b>Link driver preference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_DRIVER_PROFILE_DRIVER_PREFERENCE__LINK_DRIVER_PREFERENCE = 2;

	/**
	 * The number of structural features of the '<em>Link Driver Profile Driver Preference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_DRIVER_PROFILE_DRIVER_PREFERENCE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link intelligentMobility.impl.Link_VehicleConfiguration_VehicleTypeImpl <em>Link Vehicle Configuration Vehicle Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.impl.Link_VehicleConfiguration_VehicleTypeImpl
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getLink_VehicleConfiguration_VehicleType()
	 * @generated
	 */
	int LINK_VEHICLE_CONFIGURATION_VEHICLE_TYPE = 40;

	/**
	 * The feature id for the '<em><b>Name link configuration type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_VEHICLE_CONFIGURATION_VEHICLE_TYPE__NAME_LINK_CONFIGURATION_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Link vehicle configuration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_VEHICLE_CONFIGURATION_VEHICLE_TYPE__LINK_VEHICLE_CONFIGURATION = 1;

	/**
	 * The feature id for the '<em><b>Link vehicle type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_VEHICLE_CONFIGURATION_VEHICLE_TYPE__LINK_VEHICLE_TYPE = 2;

	/**
	 * The number of structural features of the '<em>Link Vehicle Configuration Vehicle Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_VEHICLE_CONFIGURATION_VEHICLE_TYPE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link intelligentMobility.impl.Link_EnvironmentBackground_PossibleVehicleImpl <em>Link Environment Background Possible Vehicle</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.impl.Link_EnvironmentBackground_PossibleVehicleImpl
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getLink_EnvironmentBackground_PossibleVehicle()
	 * @generated
	 */
	int LINK_ENVIRONMENT_BACKGROUND_POSSIBLE_VEHICLE = 41;

	/**
	 * The feature id for the '<em><b>Name link background possible Vehicle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_ENVIRONMENT_BACKGROUND_POSSIBLE_VEHICLE__NAME_LINK_BACKGROUND_POSSIBLE_VEHICLE = 0;

	/**
	 * The feature id for the '<em><b>Link environment background</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_ENVIRONMENT_BACKGROUND_POSSIBLE_VEHICLE__LINK_ENVIRONMENT_BACKGROUND = 1;

	/**
	 * The feature id for the '<em><b>Link possible vehicle</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_ENVIRONMENT_BACKGROUND_POSSIBLE_VEHICLE__LINK_POSSIBLE_VEHICLE = 2;

	/**
	 * The number of structural features of the '<em>Link Environment Background Possible Vehicle</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_ENVIRONMENT_BACKGROUND_POSSIBLE_VEHICLE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link intelligentMobility.impl.Link_EnvironmentBackground_EnvironmentConditionImpl <em>Link Environment Background Environment Condition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.impl.Link_EnvironmentBackground_EnvironmentConditionImpl
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getLink_EnvironmentBackground_EnvironmentCondition()
	 * @generated
	 */
	int LINK_ENVIRONMENT_BACKGROUND_ENVIRONMENT_CONDITION = 42;

	/**
	 * The feature id for the '<em><b>Name link background condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_ENVIRONMENT_BACKGROUND_ENVIRONMENT_CONDITION__NAME_LINK_BACKGROUND_CONDITION = 0;

	/**
	 * The feature id for the '<em><b>Link environment background</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_ENVIRONMENT_BACKGROUND_ENVIRONMENT_CONDITION__LINK_ENVIRONMENT_BACKGROUND = 1;

	/**
	 * The feature id for the '<em><b>Link environment condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_ENVIRONMENT_BACKGROUND_ENVIRONMENT_CONDITION__LINK_ENVIRONMENT_CONDITION = 2;

	/**
	 * The number of structural features of the '<em>Link Environment Background Environment Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_ENVIRONMENT_BACKGROUND_ENVIRONMENT_CONDITION_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link intelligentMobility.impl.Link_DriverPreference_DriverEmotionImpl <em>Link Driver Preference Driver Emotion</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.impl.Link_DriverPreference_DriverEmotionImpl
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getLink_DriverPreference_DriverEmotion()
	 * @generated
	 */
	int LINK_DRIVER_PREFERENCE_DRIVER_EMOTION = 43;

	/**
	 * The feature id for the '<em><b>Name link preference emotion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_DRIVER_PREFERENCE_DRIVER_EMOTION__NAME_LINK_PREFERENCE_EMOTION = 0;

	/**
	 * The feature id for the '<em><b>Link driver preference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_DRIVER_PREFERENCE_DRIVER_EMOTION__LINK_DRIVER_PREFERENCE = 1;

	/**
	 * The feature id for the '<em><b>Link driver emotion</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_DRIVER_PREFERENCE_DRIVER_EMOTION__LINK_DRIVER_EMOTION = 2;

	/**
	 * The number of structural features of the '<em>Link Driver Preference Driver Emotion</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_DRIVER_PREFERENCE_DRIVER_EMOTION_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link intelligentMobility.impl.Link_DriverPreference_DrivingBehaviourImpl <em>Link Driver Preference Driving Behaviour</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.impl.Link_DriverPreference_DrivingBehaviourImpl
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getLink_DriverPreference_DrivingBehaviour()
	 * @generated
	 */
	int LINK_DRIVER_PREFERENCE_DRIVING_BEHAVIOUR = 44;

	/**
	 * The feature id for the '<em><b>Name link preference behaviour</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_DRIVER_PREFERENCE_DRIVING_BEHAVIOUR__NAME_LINK_PREFERENCE_BEHAVIOUR = 0;

	/**
	 * The feature id for the '<em><b>Link driver preference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_DRIVER_PREFERENCE_DRIVING_BEHAVIOUR__LINK_DRIVER_PREFERENCE = 1;

	/**
	 * The feature id for the '<em><b>Link driving behaviour</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_DRIVER_PREFERENCE_DRIVING_BEHAVIOUR__LINK_DRIVING_BEHAVIOUR = 2;

	/**
	 * The number of structural features of the '<em>Link Driver Preference Driving Behaviour</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_DRIVER_PREFERENCE_DRIVING_BEHAVIOUR_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link intelligentMobility.impl.Link_DriverPreference_EnvironmentConditionImpl <em>Link Driver Preference Environment Condition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.impl.Link_DriverPreference_EnvironmentConditionImpl
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getLink_DriverPreference_EnvironmentCondition()
	 * @generated
	 */
	int LINK_DRIVER_PREFERENCE_ENVIRONMENT_CONDITION = 45;

	/**
	 * The feature id for the '<em><b>Name link preference condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_DRIVER_PREFERENCE_ENVIRONMENT_CONDITION__NAME_LINK_PREFERENCE_CONDITION = 0;

	/**
	 * The feature id for the '<em><b>Link driver preference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_DRIVER_PREFERENCE_ENVIRONMENT_CONDITION__LINK_DRIVER_PREFERENCE = 1;

	/**
	 * The feature id for the '<em><b>Link environment condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_DRIVER_PREFERENCE_ENVIRONMENT_CONDITION__LINK_ENVIRONMENT_CONDITION = 2;

	/**
	 * The number of structural features of the '<em>Link Driver Preference Environment Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_DRIVER_PREFERENCE_ENVIRONMENT_CONDITION_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link intelligentMobility.impl.Link_DrivingBehaviour_NormalBehaviourImpl <em>Link Driving Behaviour Normal Behaviour</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.impl.Link_DrivingBehaviour_NormalBehaviourImpl
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getLink_DrivingBehaviour_NormalBehaviour()
	 * @generated
	 */
	int LINK_DRIVING_BEHAVIOUR_NORMAL_BEHAVIOUR = 46;

	/**
	 * The feature id for the '<em><b>Name link driving normal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_DRIVING_BEHAVIOUR_NORMAL_BEHAVIOUR__NAME_LINK_DRIVING_NORMAL = 0;

	/**
	 * The feature id for the '<em><b>Link driving behaviour</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_DRIVING_BEHAVIOUR_NORMAL_BEHAVIOUR__LINK_DRIVING_BEHAVIOUR = 1;

	/**
	 * The feature id for the '<em><b>Link normal behaviour</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_DRIVING_BEHAVIOUR_NORMAL_BEHAVIOUR__LINK_NORMAL_BEHAVIOUR = 2;

	/**
	 * The number of structural features of the '<em>Link Driving Behaviour Normal Behaviour</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_DRIVING_BEHAVIOUR_NORMAL_BEHAVIOUR_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link intelligentMobility.impl.Link_NormalBehaviour_FollowingImpl <em>Link Normal Behaviour Following</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.impl.Link_NormalBehaviour_FollowingImpl
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getLink_NormalBehaviour_Following()
	 * @generated
	 */
	int LINK_NORMAL_BEHAVIOUR_FOLLOWING = 47;

	/**
	 * The feature id for the '<em><b>Name link behaviour following</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_NORMAL_BEHAVIOUR_FOLLOWING__NAME_LINK_BEHAVIOUR_FOLLOWING = 0;

	/**
	 * The feature id for the '<em><b>Link normal behaviour</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_NORMAL_BEHAVIOUR_FOLLOWING__LINK_NORMAL_BEHAVIOUR = 1;

	/**
	 * The feature id for the '<em><b>Link following</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_NORMAL_BEHAVIOUR_FOLLOWING__LINK_FOLLOWING = 2;

	/**
	 * The number of structural features of the '<em>Link Normal Behaviour Following</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_NORMAL_BEHAVIOUR_FOLLOWING_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link intelligentMobility.impl.Link_NormalBehaviour_LaneChangingImpl <em>Link Normal Behaviour Lane Changing</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.impl.Link_NormalBehaviour_LaneChangingImpl
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getLink_NormalBehaviour_LaneChanging()
	 * @generated
	 */
	int LINK_NORMAL_BEHAVIOUR_LANE_CHANGING = 48;

	/**
	 * The feature id for the '<em><b>Name link behaviour lane Changing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_NORMAL_BEHAVIOUR_LANE_CHANGING__NAME_LINK_BEHAVIOUR_LANE_CHANGING = 0;

	/**
	 * The feature id for the '<em><b>Link normal behaviour</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_NORMAL_BEHAVIOUR_LANE_CHANGING__LINK_NORMAL_BEHAVIOUR = 1;

	/**
	 * The feature id for the '<em><b>Link lane changing</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_NORMAL_BEHAVIOUR_LANE_CHANGING__LINK_LANE_CHANGING = 2;

	/**
	 * The number of structural features of the '<em>Link Normal Behaviour Lane Changing</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_NORMAL_BEHAVIOUR_LANE_CHANGING_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link intelligentMobility.impl.Link_Following_MinGapImpl <em>Link Following Min Gap</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.impl.Link_Following_MinGapImpl
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getLink_Following_MinGap()
	 * @generated
	 */
	int LINK_FOLLOWING_MIN_GAP = 49;

	/**
	 * The feature id for the '<em><b>Name link following min Gap</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_FOLLOWING_MIN_GAP__NAME_LINK_FOLLOWING_MIN_GAP = 0;

	/**
	 * The feature id for the '<em><b>Link following</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_FOLLOWING_MIN_GAP__LINK_FOLLOWING = 1;

	/**
	 * The feature id for the '<em><b>Link min Gap</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_FOLLOWING_MIN_GAP__LINK_MIN_GAP = 2;

	/**
	 * The number of structural features of the '<em>Link Following Min Gap</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_FOLLOWING_MIN_GAP_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link intelligentMobility.impl.Link_Following_ForwardImpl <em>Link Following Forward</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.impl.Link_Following_ForwardImpl
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getLink_Following_Forward()
	 * @generated
	 */
	int LINK_FOLLOWING_FORWARD = 50;

	/**
	 * The feature id for the '<em><b>Name link following forward</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_FOLLOWING_FORWARD__NAME_LINK_FOLLOWING_FORWARD = 0;

	/**
	 * The feature id for the '<em><b>Link following</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_FOLLOWING_FORWARD__LINK_FOLLOWING = 1;

	/**
	 * The feature id for the '<em><b>Link forward</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_FOLLOWING_FORWARD__LINK_FORWARD = 2;

	/**
	 * The number of structural features of the '<em>Link Following Forward</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_FOLLOWING_FORWARD_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link intelligentMobility.impl.Link_Following_BackwardImpl <em>Link Following Backward</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.impl.Link_Following_BackwardImpl
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getLink_Following_Backward()
	 * @generated
	 */
	int LINK_FOLLOWING_BACKWARD = 51;

	/**
	 * The feature id for the '<em><b>Name link following backward</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_FOLLOWING_BACKWARD__NAME_LINK_FOLLOWING_BACKWARD = 0;

	/**
	 * The feature id for the '<em><b>Link following</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_FOLLOWING_BACKWARD__LINK_FOLLOWING = 1;

	/**
	 * The feature id for the '<em><b>Link backward</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_FOLLOWING_BACKWARD__LINK_BACKWARD = 2;

	/**
	 * The number of structural features of the '<em>Link Following Backward</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_FOLLOWING_BACKWARD_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link intelligentMobility.impl.Link_LaneChanging_TurnImpl <em>Link Lane Changing Turn</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.impl.Link_LaneChanging_TurnImpl
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getLink_LaneChanging_Turn()
	 * @generated
	 */
	int LINK_LANE_CHANGING_TURN = 52;

	/**
	 * The feature id for the '<em><b>Name link lane Changing turn</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_LANE_CHANGING_TURN__NAME_LINK_LANE_CHANGING_TURN = 0;

	/**
	 * The feature id for the '<em><b>Link lane Changing</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_LANE_CHANGING_TURN__LINK_LANE_CHANGING = 1;

	/**
	 * The feature id for the '<em><b>Link turn</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_LANE_CHANGING_TURN__LINK_TURN = 2;

	/**
	 * The number of structural features of the '<em>Link Lane Changing Turn</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_LANE_CHANGING_TURN_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link intelligentMobility.impl.Link_LaneChanging_GapAcceptanceImpl <em>Link Lane Changing Gap Acceptance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.impl.Link_LaneChanging_GapAcceptanceImpl
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getLink_LaneChanging_GapAcceptance()
	 * @generated
	 */
	int LINK_LANE_CHANGING_GAP_ACCEPTANCE = 53;

	/**
	 * The feature id for the '<em><b>Name link lane Changing gap Acceptane</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_LANE_CHANGING_GAP_ACCEPTANCE__NAME_LINK_LANE_CHANGING_GAP_ACCEPTANE = 0;

	/**
	 * The feature id for the '<em><b>Link lane Changing</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_LANE_CHANGING_GAP_ACCEPTANCE__LINK_LANE_CHANGING = 1;

	/**
	 * The feature id for the '<em><b>Link gap Acceptance</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_LANE_CHANGING_GAP_ACCEPTANCE__LINK_GAP_ACCEPTANCE = 2;

	/**
	 * The number of structural features of the '<em>Link Lane Changing Gap Acceptance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_LANE_CHANGING_GAP_ACCEPTANCE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link intelligentMobility.impl.Link_LaneChanging_EnvironmentConditionImpl <em>Link Lane Changing Environment Condition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.impl.Link_LaneChanging_EnvironmentConditionImpl
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getLink_LaneChanging_EnvironmentCondition()
	 * @generated
	 */
	int LINK_LANE_CHANGING_ENVIRONMENT_CONDITION = 54;

	/**
	 * The feature id for the '<em><b>Name link lane Changing environment Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_LANE_CHANGING_ENVIRONMENT_CONDITION__NAME_LINK_LANE_CHANGING_ENVIRONMENT_CONDITION = 0;

	/**
	 * The feature id for the '<em><b>Link lane Changing</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_LANE_CHANGING_ENVIRONMENT_CONDITION__LINK_LANE_CHANGING = 1;

	/**
	 * The feature id for the '<em><b>Link environment Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_LANE_CHANGING_ENVIRONMENT_CONDITION__LINK_ENVIRONMENT_CONDITION = 2;

	/**
	 * The number of structural features of the '<em>Link Lane Changing Environment Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_LANE_CHANGING_ENVIRONMENT_CONDITION_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link intelligentMobility.impl.Link_AbnormalBehaviour_ActionImpl <em>Link Abnormal Behaviour Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.impl.Link_AbnormalBehaviour_ActionImpl
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getLink_AbnormalBehaviour_Action()
	 * @generated
	 */
	int LINK_ABNORMAL_BEHAVIOUR_ACTION = 55;

	/**
	 * The feature id for the '<em><b>Name link abnormal Behaviour action</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_ABNORMAL_BEHAVIOUR_ACTION__NAME_LINK_ABNORMAL_BEHAVIOUR_ACTION = 0;

	/**
	 * The feature id for the '<em><b>Link abnormal Behaviour</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_ABNORMAL_BEHAVIOUR_ACTION__LINK_ABNORMAL_BEHAVIOUR = 1;

	/**
	 * The feature id for the '<em><b>Link action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_ABNORMAL_BEHAVIOUR_ACTION__LINK_ACTION = 2;

	/**
	 * The number of structural features of the '<em>Link Abnormal Behaviour Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_ABNORMAL_BEHAVIOUR_ACTION_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link intelligentMobility.impl.Link_Platoon_LeadingVehicleImpl <em>Link Platoon Leading Vehicle</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.impl.Link_Platoon_LeadingVehicleImpl
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getLink_Platoon_LeadingVehicle()
	 * @generated
	 */
	int LINK_PLATOON_LEADING_VEHICLE = 56;

	/**
	 * The feature id for the '<em><b>Name link platoon leading Vehicle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_PLATOON_LEADING_VEHICLE__NAME_LINK_PLATOON_LEADING_VEHICLE = 0;

	/**
	 * The feature id for the '<em><b>Link platoon</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_PLATOON_LEADING_VEHICLE__LINK_PLATOON = 1;

	/**
	 * The feature id for the '<em><b>Link leading Vehicle</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_PLATOON_LEADING_VEHICLE__LINK_LEADING_VEHICLE = 2;

	/**
	 * The number of structural features of the '<em>Link Platoon Leading Vehicle</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_PLATOON_LEADING_VEHICLE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link intelligentMobility.impl.Link_Platoon_FollowingVehicleImpl <em>Link Platoon Following Vehicle</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.impl.Link_Platoon_FollowingVehicleImpl
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getLink_Platoon_FollowingVehicle()
	 * @generated
	 */
	int LINK_PLATOON_FOLLOWING_VEHICLE = 57;

	/**
	 * The feature id for the '<em><b>Name link platoon following Vehicle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_PLATOON_FOLLOWING_VEHICLE__NAME_LINK_PLATOON_FOLLOWING_VEHICLE = 0;

	/**
	 * The feature id for the '<em><b>Link platoon</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_PLATOON_FOLLOWING_VEHICLE__LINK_PLATOON = 1;

	/**
	 * The feature id for the '<em><b>Link following Vehicle</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_PLATOON_FOLLOWING_VEHICLE__LINK_FOLLOWING_VEHICLE = 2;

	/**
	 * The number of structural features of the '<em>Link Platoon Following Vehicle</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_PLATOON_FOLLOWING_VEHICLE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link intelligentMobility.impl.Link_NormalVehicle_SafetyRequirementsImpl <em>Link Normal Vehicle Safety Requirements</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.impl.Link_NormalVehicle_SafetyRequirementsImpl
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getLink_NormalVehicle_SafetyRequirements()
	 * @generated
	 */
	int LINK_NORMAL_VEHICLE_SAFETY_REQUIREMENTS = 58;

	/**
	 * The feature id for the '<em><b>Name link normal Vehicle safety Requirement</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_NORMAL_VEHICLE_SAFETY_REQUIREMENTS__NAME_LINK_NORMAL_VEHICLE_SAFETY_REQUIREMENT = 0;

	/**
	 * The feature id for the '<em><b>Link normal Vehicle</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_NORMAL_VEHICLE_SAFETY_REQUIREMENTS__LINK_NORMAL_VEHICLE = 1;

	/**
	 * The feature id for the '<em><b>Link safety Requirement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_NORMAL_VEHICLE_SAFETY_REQUIREMENTS__LINK_SAFETY_REQUIREMENT = 2;

	/**
	 * The number of structural features of the '<em>Link Normal Vehicle Safety Requirements</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_NORMAL_VEHICLE_SAFETY_REQUIREMENTS_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link intelligentMobility.impl.Link_FollowingVehicle_FrontVehicleImpl <em>Link Following Vehicle Front Vehicle</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.impl.Link_FollowingVehicle_FrontVehicleImpl
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getLink_FollowingVehicle_FrontVehicle()
	 * @generated
	 */
	int LINK_FOLLOWING_VEHICLE_FRONT_VEHICLE = 59;

	/**
	 * The feature id for the '<em><b>Name link following Vehicle front Vehicle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_FOLLOWING_VEHICLE_FRONT_VEHICLE__NAME_LINK_FOLLOWING_VEHICLE_FRONT_VEHICLE = 0;

	/**
	 * The feature id for the '<em><b>Link following Vehicle</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_FOLLOWING_VEHICLE_FRONT_VEHICLE__LINK_FOLLOWING_VEHICLE = 1;

	/**
	 * The feature id for the '<em><b>Link front Vehicle</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_FOLLOWING_VEHICLE_FRONT_VEHICLE__LINK_FRONT_VEHICLE = 2;

	/**
	 * The number of structural features of the '<em>Link Following Vehicle Front Vehicle</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_FOLLOWING_VEHICLE_FRONT_VEHICLE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link intelligentMobility.impl.Link_EnvironmentCondition_LaneTypeImpl <em>Link Environment Condition Lane Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.impl.Link_EnvironmentCondition_LaneTypeImpl
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getLink_EnvironmentCondition_LaneType()
	 * @generated
	 */
	int LINK_ENVIRONMENT_CONDITION_LANE_TYPE = 60;

	/**
	 * The feature id for the '<em><b>Name link environment Condition lane Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_ENVIRONMENT_CONDITION_LANE_TYPE__NAME_LINK_ENVIRONMENT_CONDITION_LANE_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Link environment Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_ENVIRONMENT_CONDITION_LANE_TYPE__LINK_ENVIRONMENT_CONDITION = 1;

	/**
	 * The feature id for the '<em><b>Link lane Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_ENVIRONMENT_CONDITION_LANE_TYPE__LINK_LANE_TYPE = 2;

	/**
	 * The number of structural features of the '<em>Link Environment Condition Lane Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_ENVIRONMENT_CONDITION_LANE_TYPE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link intelligentMobility.impl.Link_EnvironmentCondition_RegulationsImpl <em>Link Environment Condition Regulations</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.impl.Link_EnvironmentCondition_RegulationsImpl
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getLink_EnvironmentCondition_Regulations()
	 * @generated
	 */
	int LINK_ENVIRONMENT_CONDITION_REGULATIONS = 61;

	/**
	 * The feature id for the '<em><b>Name link environment Condition regulation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_ENVIRONMENT_CONDITION_REGULATIONS__NAME_LINK_ENVIRONMENT_CONDITION_REGULATION = 0;

	/**
	 * The feature id for the '<em><b>Link environment Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_ENVIRONMENT_CONDITION_REGULATIONS__LINK_ENVIRONMENT_CONDITION = 1;

	/**
	 * The feature id for the '<em><b>Link regulation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_ENVIRONMENT_CONDITION_REGULATIONS__LINK_REGULATION = 2;

	/**
	 * The number of structural features of the '<em>Link Environment Condition Regulations</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_ENVIRONMENT_CONDITION_REGULATIONS_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link intelligentMobility.impl.Link_EnvironmentCondition_WeatherImpl <em>Link Environment Condition Weather</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.impl.Link_EnvironmentCondition_WeatherImpl
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getLink_EnvironmentCondition_Weather()
	 * @generated
	 */
	int LINK_ENVIRONMENT_CONDITION_WEATHER = 62;

	/**
	 * The feature id for the '<em><b>Name link environment Condition weather</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_ENVIRONMENT_CONDITION_WEATHER__NAME_LINK_ENVIRONMENT_CONDITION_WEATHER = 0;

	/**
	 * The feature id for the '<em><b>Link environment Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_ENVIRONMENT_CONDITION_WEATHER__LINK_ENVIRONMENT_CONDITION = 1;

	/**
	 * The feature id for the '<em><b>Link weather</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_ENVIRONMENT_CONDITION_WEATHER__LINK_WEATHER = 2;

	/**
	 * The number of structural features of the '<em>Link Environment Condition Weather</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_ENVIRONMENT_CONDITION_WEATHER_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link intelligentMobility.impl.Link_EnvironmentCondition_TrafficConditionImpl <em>Link Environment Condition Traffic Condition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.impl.Link_EnvironmentCondition_TrafficConditionImpl
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getLink_EnvironmentCondition_TrafficCondition()
	 * @generated
	 */
	int LINK_ENVIRONMENT_CONDITION_TRAFFIC_CONDITION = 63;

	/**
	 * The feature id for the '<em><b>Name link environment Condition traffic Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_ENVIRONMENT_CONDITION_TRAFFIC_CONDITION__NAME_LINK_ENVIRONMENT_CONDITION_TRAFFIC_CONDITION = 0;

	/**
	 * The feature id for the '<em><b>Link environment Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_ENVIRONMENT_CONDITION_TRAFFIC_CONDITION__LINK_ENVIRONMENT_CONDITION = 1;

	/**
	 * The feature id for the '<em><b>Link traffic Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_ENVIRONMENT_CONDITION_TRAFFIC_CONDITION__LINK_TRAFFIC_CONDITION = 2;

	/**
	 * The number of structural features of the '<em>Link Environment Condition Traffic Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_ENVIRONMENT_CONDITION_TRAFFIC_CONDITION_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link intelligentMobility.impl.Link_EnvironmentCondition_SpecialConditionImpl <em>Link Environment Condition Special Condition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.impl.Link_EnvironmentCondition_SpecialConditionImpl
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getLink_EnvironmentCondition_SpecialCondition()
	 * @generated
	 */
	int LINK_ENVIRONMENT_CONDITION_SPECIAL_CONDITION = 64;

	/**
	 * The feature id for the '<em><b>Name link environment Condition special Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_ENVIRONMENT_CONDITION_SPECIAL_CONDITION__NAME_LINK_ENVIRONMENT_CONDITION_SPECIAL_CONDITION = 0;

	/**
	 * The feature id for the '<em><b>Link environment Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_ENVIRONMENT_CONDITION_SPECIAL_CONDITION__LINK_ENVIRONMENT_CONDITION = 1;

	/**
	 * The feature id for the '<em><b>Link special Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_ENVIRONMENT_CONDITION_SPECIAL_CONDITION__LINK_SPECIAL_CONDITION = 2;

	/**
	 * The number of structural features of the '<em>Link Environment Condition Special Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_ENVIRONMENT_CONDITION_SPECIAL_CONDITION_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link intelligentMobility.impl.Link_LaneType_RegulationImpl <em>Link Lane Type Regulation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.impl.Link_LaneType_RegulationImpl
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getLink_LaneType_Regulation()
	 * @generated
	 */
	int LINK_LANE_TYPE_REGULATION = 65;

	/**
	 * The feature id for the '<em><b>Name link lane Type regulation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_LANE_TYPE_REGULATION__NAME_LINK_LANE_TYPE_REGULATION = 0;

	/**
	 * The feature id for the '<em><b>Link lane Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_LANE_TYPE_REGULATION__LINK_LANE_TYPE = 1;

	/**
	 * The feature id for the '<em><b>Link regulation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_LANE_TYPE_REGULATION__LINK_REGULATION = 2;

	/**
	 * The number of structural features of the '<em>Link Lane Type Regulation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_LANE_TYPE_REGULATION_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link intelligentMobility.impl.Link_SafetyRequirement_RegulationImpl <em>Link Safety Requirement Regulation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.impl.Link_SafetyRequirement_RegulationImpl
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getLink_SafetyRequirement_Regulation()
	 * @generated
	 */
	int LINK_SAFETY_REQUIREMENT_REGULATION = 66;

	/**
	 * The feature id for the '<em><b>Name link safety Requirement regulation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_SAFETY_REQUIREMENT_REGULATION__NAME_LINK_SAFETY_REQUIREMENT_REGULATION = 0;

	/**
	 * The feature id for the '<em><b>Link safety Requirement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_SAFETY_REQUIREMENT_REGULATION__LINK_SAFETY_REQUIREMENT = 1;

	/**
	 * The feature id for the '<em><b>Link regulation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_SAFETY_REQUIREMENT_REGULATION__LINK_REGULATION = 2;

	/**
	 * The number of structural features of the '<em>Link Safety Requirement Regulation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_SAFETY_REQUIREMENT_REGULATION_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link intelligentMobility.impl.Link_SpecialCondition_IntersectionImpl <em>Link Special Condition Intersection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.impl.Link_SpecialCondition_IntersectionImpl
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getLink_SpecialCondition_Intersection()
	 * @generated
	 */
	int LINK_SPECIAL_CONDITION_INTERSECTION = 67;

	/**
	 * The feature id for the '<em><b>Name link special Condition intersection</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_SPECIAL_CONDITION_INTERSECTION__NAME_LINK_SPECIAL_CONDITION_INTERSECTION = 0;

	/**
	 * The feature id for the '<em><b>Link special Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_SPECIAL_CONDITION_INTERSECTION__LINK_SPECIAL_CONDITION = 1;

	/**
	 * The feature id for the '<em><b>Link intersection</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_SPECIAL_CONDITION_INTERSECTION__LINK_INTERSECTION = 2;

	/**
	 * The number of structural features of the '<em>Link Special Condition Intersection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_SPECIAL_CONDITION_INTERSECTION_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link intelligentMobility.impl.Link_Collision_ObstructionImpl <em>Link Collision Obstruction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.impl.Link_Collision_ObstructionImpl
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getLink_Collision_Obstruction()
	 * @generated
	 */
	int LINK_COLLISION_OBSTRUCTION = 68;

	/**
	 * The feature id for the '<em><b>Name link collision obstruction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_COLLISION_OBSTRUCTION__NAME_LINK_COLLISION_OBSTRUCTION = 0;

	/**
	 * The feature id for the '<em><b>Link collision</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_COLLISION_OBSTRUCTION__LINK_COLLISION = 1;

	/**
	 * The feature id for the '<em><b>Link obstruction</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_COLLISION_OBSTRUCTION__LINK_OBSTRUCTION = 2;

	/**
	 * The number of structural features of the '<em>Link Collision Obstruction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_COLLISION_OBSTRUCTION_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link intelligentMobility.impl.Link_Intersection_TrafficLightImpl <em>Link Intersection Traffic Light</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.impl.Link_Intersection_TrafficLightImpl
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getLink_Intersection_TrafficLight()
	 * @generated
	 */
	int LINK_INTERSECTION_TRAFFIC_LIGHT = 69;

	/**
	 * The feature id for the '<em><b>Name link intersection traffic Light</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_INTERSECTION_TRAFFIC_LIGHT__NAME_LINK_INTERSECTION_TRAFFIC_LIGHT = 0;

	/**
	 * The feature id for the '<em><b>Link intersection</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_INTERSECTION_TRAFFIC_LIGHT__LINK_INTERSECTION = 1;

	/**
	 * The feature id for the '<em><b>Link traffic Light</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_INTERSECTION_TRAFFIC_LIGHT__LINK_TRAFFIC_LIGHT = 2;

	/**
	 * The number of structural features of the '<em>Link Intersection Traffic Light</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_INTERSECTION_TRAFFIC_LIGHT_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link intelligentMobility.impl.RoadSegmentImpl <em>Road Segment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.impl.RoadSegmentImpl
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getRoadSegment()
	 * @generated
	 */
	int ROAD_SEGMENT = 71;

	/**
	 * The feature id for the '<em><b>Communicates With</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROAD_SEGMENT__COMMUNICATES_WITH = INFRASTRUCTURE__COMMUNICATES_WITH;

	/**
	 * The number of structural features of the '<em>Road Segment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROAD_SEGMENT_FEATURE_COUNT = INFRASTRUCTURE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link intelligentMobility.impl.SmartSensorImpl <em>Smart Sensor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.impl.SmartSensorImpl
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getSmartSensor()
	 * @generated
	 */
	int SMART_SENSOR = 72;

	/**
	 * The feature id for the '<em><b>Communicates With</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMART_SENSOR__COMMUNICATES_WITH = INFRASTRUCTURE__COMMUNICATES_WITH;

	/**
	 * The feature id for the '<em><b>Monitors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMART_SENSOR__MONITORS = INFRASTRUCTURE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Smart Sensor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMART_SENSOR_FEATURE_COUNT = INFRASTRUCTURE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link intelligentMobility.impl.Road_Side_UnitImpl <em>Road Side Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.impl.Road_Side_UnitImpl
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getRoad_Side_Unit()
	 * @generated
	 */
	int ROAD_SIDE_UNIT = 73;

	/**
	 * The feature id for the '<em><b>Communicates With</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROAD_SIDE_UNIT__COMMUNICATES_WITH = INFRASTRUCTURE__COMMUNICATES_WITH;

	/**
	 * The number of structural features of the '<em>Road Side Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROAD_SIDE_UNIT_FEATURE_COUNT = INFRASTRUCTURE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link intelligentMobility.impl.ChargingStationImpl <em>Charging Station</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.impl.ChargingStationImpl
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getChargingStation()
	 * @generated
	 */
	int CHARGING_STATION = 74;

	/**
	 * The feature id for the '<em><b>Communicates With</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARGING_STATION__COMMUNICATES_WITH = INFRASTRUCTURE__COMMUNICATES_WITH;

	/**
	 * The number of structural features of the '<em>Charging Station</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARGING_STATION_FEATURE_COUNT = INFRASTRUCTURE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link intelligentMobility.impl.CommunicationInterfaceImpl <em>Communication Interface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.impl.CommunicationInterfaceImpl
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getCommunicationInterface()
	 * @generated
	 */
	int COMMUNICATION_INTERFACE = 75;

	/**
	 * The feature id for the '<em><b>Protocol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_INTERFACE__PROTOCOL = 0;

	/**
	 * The feature id for the '<em><b>Latency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_INTERFACE__LATENCY = 1;

	/**
	 * The feature id for the '<em><b>Bandwidth</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_INTERFACE__BANDWIDTH = 2;

	/**
	 * The feature id for the '<em><b>Reliability Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_INTERFACE__RELIABILITY_LEVEL = 3;

	/**
	 * The feature id for the '<em><b>Connects vehicle</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_INTERFACE__CONNECTS_VEHICLE = 4;

	/**
	 * The feature id for the '<em><b>Connects infrastructure</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_INTERFACE__CONNECTS_INFRASTRUCTURE = 5;

	/**
	 * The number of structural features of the '<em>Communication Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_INTERFACE_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link intelligentMobility.impl.CooperativeBehaviorImpl <em>Cooperative Behavior</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.impl.CooperativeBehaviorImpl
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getCooperativeBehavior()
	 * @generated
	 */
	int COOPERATIVE_BEHAVIOR = 76;

	/**
	 * The feature id for the '<em><b>Prep Distance For Destination</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COOPERATIVE_BEHAVIOR__PREP_DISTANCE_FOR_DESTINATION = DRIVING_BEHAVIOUR__PREP_DISTANCE_FOR_DESTINATION;

	/**
	 * The feature id for the '<em><b>Prep Distance For Turn</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COOPERATIVE_BEHAVIOR__PREP_DISTANCE_FOR_TURN = DRIVING_BEHAVIOUR__PREP_DISTANCE_FOR_TURN;

	/**
	 * The feature id for the '<em><b>Initial Speed min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COOPERATIVE_BEHAVIOR__INITIAL_SPEED_MIN = DRIVING_BEHAVIOUR__INITIAL_SPEED_MIN;

	/**
	 * The feature id for the '<em><b>Initial Speed max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COOPERATIVE_BEHAVIOR__INITIAL_SPEED_MAX = DRIVING_BEHAVIOUR__INITIAL_SPEED_MAX;

	/**
	 * The feature id for the '<em><b>Initial Speed precision</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COOPERATIVE_BEHAVIOR__INITIAL_SPEED_PRECISION = DRIVING_BEHAVIOUR__INITIAL_SPEED_PRECISION;

	/**
	 * The feature id for the '<em><b>Desired Speed min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COOPERATIVE_BEHAVIOR__DESIRED_SPEED_MIN = DRIVING_BEHAVIOUR__DESIRED_SPEED_MIN;

	/**
	 * The feature id for the '<em><b>Desired Speed max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COOPERATIVE_BEHAVIOR__DESIRED_SPEED_MAX = DRIVING_BEHAVIOUR__DESIRED_SPEED_MAX;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COOPERATIVE_BEHAVIOR__NAME = DRIVING_BEHAVIOUR__NAME;

	/**
	 * The feature id for the '<em><b>Normal behaviour</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COOPERATIVE_BEHAVIOR__NORMAL_BEHAVIOUR = DRIVING_BEHAVIOUR__NORMAL_BEHAVIOUR;

	/**
	 * The feature id for the '<em><b>Steering Angle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COOPERATIVE_BEHAVIOR__STEERING_ANGLE = DRIVING_BEHAVIOUR__STEERING_ANGLE;

	/**
	 * The feature id for the '<em><b>Throttle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COOPERATIVE_BEHAVIOR__THROTTLE = DRIVING_BEHAVIOUR__THROTTLE;

	/**
	 * The feature id for the '<em><b>Brake</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COOPERATIVE_BEHAVIOR__BRAKE = DRIVING_BEHAVIOUR__BRAKE;

	/**
	 * The feature id for the '<em><b>Gear</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COOPERATIVE_BEHAVIOR__GEAR = DRIVING_BEHAVIOUR__GEAR;

	/**
	 * The feature id for the '<em><b>Handbrake</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COOPERATIVE_BEHAVIOR__HANDBRAKE = DRIVING_BEHAVIOUR__HANDBRAKE;

	/**
	 * The feature id for the '<em><b>Rpm</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COOPERATIVE_BEHAVIOR__RPM = DRIVING_BEHAVIOUR__RPM;

	/**
	 * The feature id for the '<em><b>Key Event</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COOPERATIVE_BEHAVIOR__KEY_EVENT = DRIVING_BEHAVIOUR__KEY_EVENT;

	/**
	 * The feature id for the '<em><b>Pedal Angle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COOPERATIVE_BEHAVIOR__PEDAL_ANGLE = DRIVING_BEHAVIOUR__PEDAL_ANGLE;

	/**
	 * The feature id for the '<em><b>Pedal Pressure</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COOPERATIVE_BEHAVIOR__PEDAL_PRESSURE = DRIVING_BEHAVIOUR__PEDAL_PRESSURE;

	/**
	 * The feature id for the '<em><b>Steer Speed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COOPERATIVE_BEHAVIOR__STEER_SPEED = DRIVING_BEHAVIOUR__STEER_SPEED;

	/**
	 * The feature id for the '<em><b>Intent Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COOPERATIVE_BEHAVIOR__INTENT_TYPE = DRIVING_BEHAVIOUR__INTENT_TYPE;

	/**
	 * The feature id for the '<em><b>Confidence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COOPERATIVE_BEHAVIOR__CONFIDENCE = DRIVING_BEHAVIOUR__CONFIDENCE;

	/**
	 * The feature id for the '<em><b>Goal</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COOPERATIVE_BEHAVIOR__GOAL = DRIVING_BEHAVIOUR__GOAL;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COOPERATIVE_BEHAVIOR__DEPENDS_ON = DRIVING_BEHAVIOUR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Coordinated With</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COOPERATIVE_BEHAVIOR__COORDINATED_WITH = DRIVING_BEHAVIOUR_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Cooperative Behavior</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COOPERATIVE_BEHAVIOR_FEATURE_COUNT = DRIVING_BEHAVIOUR_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link intelligentMobility.impl.GoalImpl <em>Goal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.impl.GoalImpl
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getGoal()
	 * @generated
	 */
	int GOAL = 77;

	/**
	 * The feature id for the '<em><b>Goal Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__GOAL_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__PRIORITY = 1;

	/**
	 * The feature id for the '<em><b>Is Goal Driven</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__IS_GOAL_DRIVEN = 2;

	/**
	 * The feature id for the '<em><b>Is Stimulus Driven</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__IS_STIMULUS_DRIVEN = 3;

	/**
	 * The number of structural features of the '<em>Goal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link intelligentMobility.impl.Link_Infrastructure_VehicleConfigurationImpl <em>Link Infrastructure Vehicle Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.impl.Link_Infrastructure_VehicleConfigurationImpl
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getLink_Infrastructure_VehicleConfiguration()
	 * @generated
	 */
	int LINK_INFRASTRUCTURE_VEHICLE_CONFIGURATION = 78;

	/**
	 * The feature id for the '<em><b>Name link infrastructure vehicle Configuration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_INFRASTRUCTURE_VEHICLE_CONFIGURATION__NAME_LINK_INFRASTRUCTURE_VEHICLE_CONFIGURATION = 0;

	/**
	 * The feature id for the '<em><b>Link infrastructure</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_INFRASTRUCTURE_VEHICLE_CONFIGURATION__LINK_INFRASTRUCTURE = 1;

	/**
	 * The feature id for the '<em><b>Link vehicle configuration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_INFRASTRUCTURE_VEHICLE_CONFIGURATION__LINK_VEHICLE_CONFIGURATION = 2;

	/**
	 * The number of structural features of the '<em>Link Infrastructure Vehicle Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_INFRASTRUCTURE_VEHICLE_CONFIGURATION_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link intelligentMobility.impl.Link_CommunicationInterface_VehicleConfigurationImpl <em>Link Communication Interface Vehicle Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.impl.Link_CommunicationInterface_VehicleConfigurationImpl
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getLink_CommunicationInterface_VehicleConfiguration()
	 * @generated
	 */
	int LINK_COMMUNICATION_INTERFACE_VEHICLE_CONFIGURATION = 79;

	/**
	 * The feature id for the '<em><b>Name link communication interface vehicle Configuration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_COMMUNICATION_INTERFACE_VEHICLE_CONFIGURATION__NAME_LINK_COMMUNICATION_INTERFACE_VEHICLE_CONFIGURATION = 0;

	/**
	 * The feature id for the '<em><b>Link communication interface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_COMMUNICATION_INTERFACE_VEHICLE_CONFIGURATION__LINK_COMMUNICATION_INTERFACE = 1;

	/**
	 * The feature id for the '<em><b>Link vehicle configuration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_COMMUNICATION_INTERFACE_VEHICLE_CONFIGURATION__LINK_VEHICLE_CONFIGURATION = 2;

	/**
	 * The number of structural features of the '<em>Link Communication Interface Vehicle Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_COMMUNICATION_INTERFACE_VEHICLE_CONFIGURATION_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link intelligentMobility.impl.Link_Goal_DrivingBehaviourImpl <em>Link Goal Driving Behaviour</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.impl.Link_Goal_DrivingBehaviourImpl
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getLink_Goal_DrivingBehaviour()
	 * @generated
	 */
	int LINK_GOAL_DRIVING_BEHAVIOUR = 80;

	/**
	 * The feature id for the '<em><b>Name link goal driving Behaviour</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_GOAL_DRIVING_BEHAVIOUR__NAME_LINK_GOAL_DRIVING_BEHAVIOUR = 0;

	/**
	 * The feature id for the '<em><b>Link goal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_GOAL_DRIVING_BEHAVIOUR__LINK_GOAL = 1;

	/**
	 * The feature id for the '<em><b>Link driving Behaviour</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_GOAL_DRIVING_BEHAVIOUR__LINK_DRIVING_BEHAVIOUR = 2;

	/**
	 * The number of structural features of the '<em>Link Goal Driving Behaviour</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_GOAL_DRIVING_BEHAVIOUR_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link intelligentMobility.impl.Link_CooperativeBehaviour_CommunicationInterfaceImpl <em>Link Cooperative Behaviour Communication Interface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.impl.Link_CooperativeBehaviour_CommunicationInterfaceImpl
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getLink_CooperativeBehaviour_CommunicationInterface()
	 * @generated
	 */
	int LINK_COOPERATIVE_BEHAVIOUR_COMMUNICATION_INTERFACE = 81;

	/**
	 * The feature id for the '<em><b>Name link cooperative Behaviour communication Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_COOPERATIVE_BEHAVIOUR_COMMUNICATION_INTERFACE__NAME_LINK_COOPERATIVE_BEHAVIOUR_COMMUNICATION_INTERFACE = 0;

	/**
	 * The feature id for the '<em><b>Link cooperative Behaviour</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_COOPERATIVE_BEHAVIOUR_COMMUNICATION_INTERFACE__LINK_COOPERATIVE_BEHAVIOUR = 1;

	/**
	 * The feature id for the '<em><b>Link communication Interface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_COOPERATIVE_BEHAVIOUR_COMMUNICATION_INTERFACE__LINK_COMMUNICATION_INTERFACE = 2;

	/**
	 * The number of structural features of the '<em>Link Cooperative Behaviour Communication Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_COOPERATIVE_BEHAVIOUR_COMMUNICATION_INTERFACE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link intelligentMobility.impl.Link_CommunicationInterface_InfrastructureImpl <em>Link Communication Interface Infrastructure</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.impl.Link_CommunicationInterface_InfrastructureImpl
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getLink_CommunicationInterface_Infrastructure()
	 * @generated
	 */
	int LINK_COMMUNICATION_INTERFACE_INFRASTRUCTURE = 82;

	/**
	 * The feature id for the '<em><b>Name link communication interface infrastructure</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_COMMUNICATION_INTERFACE_INFRASTRUCTURE__NAME_LINK_COMMUNICATION_INTERFACE_INFRASTRUCTURE = 0;

	/**
	 * The feature id for the '<em><b>Link communication Interface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_COMMUNICATION_INTERFACE_INFRASTRUCTURE__LINK_COMMUNICATION_INTERFACE = 1;

	/**
	 * The feature id for the '<em><b>Link infrastructure</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_COMMUNICATION_INTERFACE_INFRASTRUCTURE__LINK_INFRASTRUCTURE = 2;

	/**
	 * The number of structural features of the '<em>Link Communication Interface Infrastructure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_COMMUNICATION_INTERFACE_INFRASTRUCTURE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link intelligentMobility.impl.Link_CooperativeBehaviour_VehicleConfigurationImpl <em>Link Cooperative Behaviour Vehicle Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.impl.Link_CooperativeBehaviour_VehicleConfigurationImpl
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getLink_CooperativeBehaviour_VehicleConfiguration()
	 * @generated
	 */
	int LINK_COOPERATIVE_BEHAVIOUR_VEHICLE_CONFIGURATION = 83;

	/**
	 * The feature id for the '<em><b>Name link cooperative Behaviour vehicle Configuration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_COOPERATIVE_BEHAVIOUR_VEHICLE_CONFIGURATION__NAME_LINK_COOPERATIVE_BEHAVIOUR_VEHICLE_CONFIGURATION = 0;

	/**
	 * The feature id for the '<em><b>Link cooperative Behaviour</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_COOPERATIVE_BEHAVIOUR_VEHICLE_CONFIGURATION__LINK_COOPERATIVE_BEHAVIOUR = 1;

	/**
	 * The feature id for the '<em><b>Link vehicle Configuration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_COOPERATIVE_BEHAVIOUR_VEHICLE_CONFIGURATION__LINK_VEHICLE_CONFIGURATION = 2;

	/**
	 * The number of structural features of the '<em>Link Cooperative Behaviour Vehicle Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_COOPERATIVE_BEHAVIOUR_VEHICLE_CONFIGURATION_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link intelligentMobility.impl.Link_TrafficSituation_EnvironmentConditionImpl <em>Link Traffic Situation Environment Condition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.impl.Link_TrafficSituation_EnvironmentConditionImpl
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getLink_TrafficSituation_EnvironmentCondition()
	 * @generated
	 */
	int LINK_TRAFFIC_SITUATION_ENVIRONMENT_CONDITION = 84;

	/**
	 * The feature id for the '<em><b>Name link traffic Situation environment Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_TRAFFIC_SITUATION_ENVIRONMENT_CONDITION__NAME_LINK_TRAFFIC_SITUATION_ENVIRONMENT_CONDITION = 0;

	/**
	 * The feature id for the '<em><b>Link traffic Situation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_TRAFFIC_SITUATION_ENVIRONMENT_CONDITION__LINK_TRAFFIC_SITUATION = 1;

	/**
	 * The feature id for the '<em><b>Link environment Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_TRAFFIC_SITUATION_ENVIRONMENT_CONDITION__LINK_ENVIRONMENT_CONDITION = 2;

	/**
	 * The number of structural features of the '<em>Link Traffic Situation Environment Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_TRAFFIC_SITUATION_ENVIRONMENT_CONDITION_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link intelligentMobility.impl.Link_Following_LaneChangingImpl <em>Link Following Lane Changing</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.impl.Link_Following_LaneChangingImpl
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getLink_Following_LaneChanging()
	 * @generated
	 */
	int LINK_FOLLOWING_LANE_CHANGING = 85;

	/**
	 * The feature id for the '<em><b>Name link following lane Changing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_FOLLOWING_LANE_CHANGING__NAME_LINK_FOLLOWING_LANE_CHANGING = 0;

	/**
	 * The feature id for the '<em><b>Link following</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_FOLLOWING_LANE_CHANGING__LINK_FOLLOWING = 1;

	/**
	 * The feature id for the '<em><b>Link lane Changing</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_FOLLOWING_LANE_CHANGING__LINK_LANE_CHANGING = 2;

	/**
	 * The number of structural features of the '<em>Link Following Lane Changing</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_FOLLOWING_LANE_CHANGING_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link intelligentMobility.impl.Link_Collision_SpecialConditionImpl <em>Link Collision Special Condition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.impl.Link_Collision_SpecialConditionImpl
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getLink_Collision_SpecialCondition()
	 * @generated
	 */
	int LINK_COLLISION_SPECIAL_CONDITION = 86;

	/**
	 * The feature id for the '<em><b>Name link collision special Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_COLLISION_SPECIAL_CONDITION__NAME_LINK_COLLISION_SPECIAL_CONDITION = 0;

	/**
	 * The feature id for the '<em><b>Link collision</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_COLLISION_SPECIAL_CONDITION__LINK_COLLISION = 1;

	/**
	 * The feature id for the '<em><b>Link special Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_COLLISION_SPECIAL_CONDITION__LINK_SPECIAL_CONDITION = 2;

	/**
	 * The number of structural features of the '<em>Link Collision Special Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_COLLISION_SPECIAL_CONDITION_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link intelligentMobility.impl.Link_Action_BackwardImpl <em>Link Action Backward</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.impl.Link_Action_BackwardImpl
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getLink_Action_Backward()
	 * @generated
	 */
	int LINK_ACTION_BACKWARD = 87;

	/**
	 * The feature id for the '<em><b>Name link action backward</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_ACTION_BACKWARD__NAME_LINK_ACTION_BACKWARD = 0;

	/**
	 * The feature id for the '<em><b>Link action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_ACTION_BACKWARD__LINK_ACTION = 1;

	/**
	 * The feature id for the '<em><b>Link backward</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_ACTION_BACKWARD__LINK_BACKWARD = 2;

	/**
	 * The number of structural features of the '<em>Link Action Backward</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_ACTION_BACKWARD_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link intelligentMobility.impl.Link_Action_ForwardImpl <em>Link Action Forward</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.impl.Link_Action_ForwardImpl
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getLink_Action_Forward()
	 * @generated
	 */
	int LINK_ACTION_FORWARD = 88;

	/**
	 * The feature id for the '<em><b>Name link action forward</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_ACTION_FORWARD__NAME_LINK_ACTION_FORWARD = 0;

	/**
	 * The feature id for the '<em><b>Link action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_ACTION_FORWARD__LINK_ACTION = 1;

	/**
	 * The feature id for the '<em><b>Link forward</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_ACTION_FORWARD__LINK_FORWARD = 2;

	/**
	 * The number of structural features of the '<em>Link Action Forward</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_ACTION_FORWARD_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link intelligentMobility.impl.Link_Action_TurnImpl <em>Link Action Turn</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.impl.Link_Action_TurnImpl
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getLink_Action_Turn()
	 * @generated
	 */
	int LINK_ACTION_TURN = 89;

	/**
	 * The feature id for the '<em><b>Name link action turn</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_ACTION_TURN__NAME_LINK_ACTION_TURN = 0;

	/**
	 * The feature id for the '<em><b>Link action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_ACTION_TURN__LINK_ACTION = 1;

	/**
	 * The feature id for the '<em><b>Link turn</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_ACTION_TURN__LINK_TURN = 2;

	/**
	 * The number of structural features of the '<em>Link Action Turn</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_ACTION_TURN_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link intelligentMobility.impl.Link_KnowledgeAndSkill_DriverPreferenceImpl <em>Link Knowledge And Skill Driver Preference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.impl.Link_KnowledgeAndSkill_DriverPreferenceImpl
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getLink_KnowledgeAndSkill_DriverPreference()
	 * @generated
	 */
	int LINK_KNOWLEDGE_AND_SKILL_DRIVER_PREFERENCE = 90;

	/**
	 * The feature id for the '<em><b>Name link knowledge And Skill driver Preference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_KNOWLEDGE_AND_SKILL_DRIVER_PREFERENCE__NAME_LINK_KNOWLEDGE_AND_SKILL_DRIVER_PREFERENCE = 0;

	/**
	 * The feature id for the '<em><b>Link knowledge And Skill</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_KNOWLEDGE_AND_SKILL_DRIVER_PREFERENCE__LINK_KNOWLEDGE_AND_SKILL = 1;

	/**
	 * The feature id for the '<em><b>Link driver Preference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_KNOWLEDGE_AND_SKILL_DRIVER_PREFERENCE__LINK_DRIVER_PREFERENCE = 2;

	/**
	 * The number of structural features of the '<em>Link Knowledge And Skill Driver Preference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_KNOWLEDGE_AND_SKILL_DRIVER_PREFERENCE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link intelligentMobility.DriverType <em>Driver Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.DriverType
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getDriverType()
	 * @generated
	 */
	int DRIVER_TYPE = 91;

	/**
	 * The meta object id for the '{@link intelligentMobility.Lanes <em>Lanes</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.Lanes
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getLanes()
	 * @generated
	 */
	int LANES = 92;

	/**
	 * The meta object id for the '{@link intelligentMobility.Direction <em>Direction</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.Direction
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getDirection()
	 * @generated
	 */
	int DIRECTION = 93;

	/**
	 * The meta object id for the '{@link intelligentMobility.CarType <em>Car Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.CarType
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getCarType()
	 * @generated
	 */
	int CAR_TYPE = 94;

	/**
	 * The meta object id for the '{@link intelligentMobility.RoadShape <em>Road Shape</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.RoadShape
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getRoadShape()
	 * @generated
	 */
	int ROAD_SHAPE = 95;

	/**
	 * The meta object id for the '{@link intelligentMobility.RoadType <em>Road Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.RoadType
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getRoadType()
	 * @generated
	 */
	int ROAD_TYPE = 96;

	/**
	 * The meta object id for the '{@link intelligentMobility.TrafficType <em>Traffic Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.TrafficType
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getTrafficType()
	 * @generated
	 */
	int TRAFFIC_TYPE = 97;

	/**
	 * The meta object id for the '{@link intelligentMobility.ProtocolType <em>Protocol Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see intelligentMobility.ProtocolType
	 * @see intelligentMobility.impl.IntelligentMobilityPackageImpl#getProtocolType()
	 * @generated
	 */
	int PROTOCOL_TYPE = 98;


	/**
	 * Returns the meta object for class '{@link intelligentMobility.MobilitySystem <em>Mobility System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mobility System</em>'.
	 * @see intelligentMobility.MobilitySystem
	 * @generated
	 */
	EClass getMobilitySystem();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.MobilitySystem#getDriver_profile <em>Driver profile</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Driver profile</em>'.
	 * @see intelligentMobility.MobilitySystem#getDriver_profile()
	 * @see #getMobilitySystem()
	 * @generated
	 */
	EReference getMobilitySystem_Driver_profile();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.MobilitySystem#getVehicle_configuration <em>Vehicle configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Vehicle configuration</em>'.
	 * @see intelligentMobility.MobilitySystem#getVehicle_configuration()
	 * @see #getMobilitySystem()
	 * @generated
	 */
	EReference getMobilitySystem_Vehicle_configuration();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.MobilitySystem#getEnvironment_background <em>Environment background</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Environment background</em>'.
	 * @see intelligentMobility.MobilitySystem#getEnvironment_background()
	 * @see #getMobilitySystem()
	 * @generated
	 */
	EReference getMobilitySystem_Environment_background();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.MobilitySystem#getDriver_preference <em>Driver preference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Driver preference</em>'.
	 * @see intelligentMobility.MobilitySystem#getDriver_preference()
	 * @see #getMobilitySystem()
	 * @generated
	 */
	EReference getMobilitySystem_Driver_preference();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.MobilitySystem#getKnowledge_and_skill <em>Knowledge and skill</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Knowledge and skill</em>'.
	 * @see intelligentMobility.MobilitySystem#getKnowledge_and_skill()
	 * @see #getMobilitySystem()
	 * @generated
	 */
	EReference getMobilitySystem_Knowledge_and_skill();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.MobilitySystem#getDriver_emotion <em>Driver emotion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Driver emotion</em>'.
	 * @see intelligentMobility.MobilitySystem#getDriver_emotion()
	 * @see #getMobilitySystem()
	 * @generated
	 */
	EReference getMobilitySystem_Driver_emotion();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.MobilitySystem#getDriving_behaviour <em>Driving behaviour</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Driving behaviour</em>'.
	 * @see intelligentMobility.MobilitySystem#getDriving_behaviour()
	 * @see #getMobilitySystem()
	 * @generated
	 */
	EReference getMobilitySystem_Driving_behaviour();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.MobilitySystem#getNormal_behaviour <em>Normal behaviour</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Normal behaviour</em>'.
	 * @see intelligentMobility.MobilitySystem#getNormal_behaviour()
	 * @see #getMobilitySystem()
	 * @generated
	 */
	EReference getMobilitySystem_Normal_behaviour();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.MobilitySystem#getFollowing <em>Following</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Following</em>'.
	 * @see intelligentMobility.MobilitySystem#getFollowing()
	 * @see #getMobilitySystem()
	 * @generated
	 */
	EReference getMobilitySystem_Following();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.MobilitySystem#getLane_changing <em>Lane changing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Lane changing</em>'.
	 * @see intelligentMobility.MobilitySystem#getLane_changing()
	 * @see #getMobilitySystem()
	 * @generated
	 */
	EReference getMobilitySystem_Lane_changing();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.MobilitySystem#getAbnormal_behaviour <em>Abnormal behaviour</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Abnormal behaviour</em>'.
	 * @see intelligentMobility.MobilitySystem#getAbnormal_behaviour()
	 * @see #getMobilitySystem()
	 * @generated
	 */
	EReference getMobilitySystem_Abnormal_behaviour();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.MobilitySystem#getForward <em>Forward</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Forward</em>'.
	 * @see intelligentMobility.MobilitySystem#getForward()
	 * @see #getMobilitySystem()
	 * @generated
	 */
	EReference getMobilitySystem_Forward();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.MobilitySystem#getBackward <em>Backward</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Backward</em>'.
	 * @see intelligentMobility.MobilitySystem#getBackward()
	 * @see #getMobilitySystem()
	 * @generated
	 */
	EReference getMobilitySystem_Backward();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.MobilitySystem#getTurn <em>Turn</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Turn</em>'.
	 * @see intelligentMobility.MobilitySystem#getTurn()
	 * @see #getMobilitySystem()
	 * @generated
	 */
	EReference getMobilitySystem_Turn();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.MobilitySystem#getGap_acceptance <em>Gap acceptance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Gap acceptance</em>'.
	 * @see intelligentMobility.MobilitySystem#getGap_acceptance()
	 * @see #getMobilitySystem()
	 * @generated
	 */
	EReference getMobilitySystem_Gap_acceptance();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.MobilitySystem#getAction <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Action</em>'.
	 * @see intelligentMobility.MobilitySystem#getAction()
	 * @see #getMobilitySystem()
	 * @generated
	 */
	EReference getMobilitySystem_Action();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.MobilitySystem#getVehicle_type <em>Vehicle type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Vehicle type</em>'.
	 * @see intelligentMobility.MobilitySystem#getVehicle_type()
	 * @see #getMobilitySystem()
	 * @generated
	 */
	EReference getMobilitySystem_Vehicle_type();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.MobilitySystem#getPlatoon <em>Platoon</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Platoon</em>'.
	 * @see intelligentMobility.MobilitySystem#getPlatoon()
	 * @see #getMobilitySystem()
	 * @generated
	 */
	EReference getMobilitySystem_Platoon();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.MobilitySystem#getNormal_vehicle <em>Normal vehicle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Normal vehicle</em>'.
	 * @see intelligentMobility.MobilitySystem#getNormal_vehicle()
	 * @see #getMobilitySystem()
	 * @generated
	 */
	EReference getMobilitySystem_Normal_vehicle();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.MobilitySystem#getLeading_vehicle <em>Leading vehicle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Leading vehicle</em>'.
	 * @see intelligentMobility.MobilitySystem#getLeading_vehicle()
	 * @see #getMobilitySystem()
	 * @generated
	 */
	EReference getMobilitySystem_Leading_vehicle();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.MobilitySystem#getFollowing_vehicle <em>Following vehicle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Following vehicle</em>'.
	 * @see intelligentMobility.MobilitySystem#getFollowing_vehicle()
	 * @see #getMobilitySystem()
	 * @generated
	 */
	EReference getMobilitySystem_Following_vehicle();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.MobilitySystem#getPlatoon_member <em>Platoon member</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Platoon member</em>'.
	 * @see intelligentMobility.MobilitySystem#getPlatoon_member()
	 * @see #getMobilitySystem()
	 * @generated
	 */
	EReference getMobilitySystem_Platoon_member();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.MobilitySystem#getPossible_vehicle <em>Possible vehicle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Possible vehicle</em>'.
	 * @see intelligentMobility.MobilitySystem#getPossible_vehicle()
	 * @see #getMobilitySystem()
	 * @generated
	 */
	EReference getMobilitySystem_Possible_vehicle();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.MobilitySystem#getEnvironment_condition <em>Environment condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Environment condition</em>'.
	 * @see intelligentMobility.MobilitySystem#getEnvironment_condition()
	 * @see #getMobilitySystem()
	 * @generated
	 */
	EReference getMobilitySystem_Environment_condition();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.MobilitySystem#getLane_type <em>Lane type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Lane type</em>'.
	 * @see intelligentMobility.MobilitySystem#getLane_type()
	 * @see #getMobilitySystem()
	 * @generated
	 */
	EReference getMobilitySystem_Lane_type();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.MobilitySystem#getRegulation <em>Regulation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Regulation</em>'.
	 * @see intelligentMobility.MobilitySystem#getRegulation()
	 * @see #getMobilitySystem()
	 * @generated
	 */
	EReference getMobilitySystem_Regulation();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.MobilitySystem#getSafety_requirement <em>Safety requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Safety requirement</em>'.
	 * @see intelligentMobility.MobilitySystem#getSafety_requirement()
	 * @see #getMobilitySystem()
	 * @generated
	 */
	EReference getMobilitySystem_Safety_requirement();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.MobilitySystem#getWeather <em>Weather</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Weather</em>'.
	 * @see intelligentMobility.MobilitySystem#getWeather()
	 * @see #getMobilitySystem()
	 * @generated
	 */
	EReference getMobilitySystem_Weather();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.MobilitySystem#getTraffic_situation <em>Traffic situation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Traffic situation</em>'.
	 * @see intelligentMobility.MobilitySystem#getTraffic_situation()
	 * @see #getMobilitySystem()
	 * @generated
	 */
	EReference getMobilitySystem_Traffic_situation();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.MobilitySystem#getSpecial_condition <em>Special condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Special condition</em>'.
	 * @see intelligentMobility.MobilitySystem#getSpecial_condition()
	 * @see #getMobilitySystem()
	 * @generated
	 */
	EReference getMobilitySystem_Special_condition();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.MobilitySystem#getCollision <em>Collision</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Collision</em>'.
	 * @see intelligentMobility.MobilitySystem#getCollision()
	 * @see #getMobilitySystem()
	 * @generated
	 */
	EReference getMobilitySystem_Collision();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.MobilitySystem#getIntersection <em>Intersection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Intersection</em>'.
	 * @see intelligentMobility.MobilitySystem#getIntersection()
	 * @see #getMobilitySystem()
	 * @generated
	 */
	EReference getMobilitySystem_Intersection();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.MobilitySystem#getObstruction <em>Obstruction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Obstruction</em>'.
	 * @see intelligentMobility.MobilitySystem#getObstruction()
	 * @see #getMobilitySystem()
	 * @generated
	 */
	EReference getMobilitySystem_Obstruction();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.MobilitySystem#getTraffic_light <em>Traffic light</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Traffic light</em>'.
	 * @see intelligentMobility.MobilitySystem#getTraffic_light()
	 * @see #getMobilitySystem()
	 * @generated
	 */
	EReference getMobilitySystem_Traffic_light();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.MobilitySystem#getExecption_condition <em>Execption condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Execption condition</em>'.
	 * @see intelligentMobility.MobilitySystem#getExecption_condition()
	 * @see #getMobilitySystem()
	 * @generated
	 */
	EReference getMobilitySystem_Execption_condition();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.MobilitySystem#getLink_driver_vehicle <em>Link driver vehicle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Link driver vehicle</em>'.
	 * @see intelligentMobility.MobilitySystem#getLink_driver_vehicle()
	 * @see #getMobilitySystem()
	 * @generated
	 */
	EReference getMobilitySystem_Link_driver_vehicle();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.MobilitySystem#getLink_driver_environment <em>Link driver environment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Link driver environment</em>'.
	 * @see intelligentMobility.MobilitySystem#getLink_driver_environment()
	 * @see #getMobilitySystem()
	 * @generated
	 */
	EReference getMobilitySystem_Link_driver_environment();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.MobilitySystem#getLink_vehicle_environment <em>Link vehicle environment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Link vehicle environment</em>'.
	 * @see intelligentMobility.MobilitySystem#getLink_vehicle_environment()
	 * @see #getMobilitySystem()
	 * @generated
	 */
	EReference getMobilitySystem_Link_vehicle_environment();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.MobilitySystem#getLink_driverProfile_driverPreference <em>Link driver Profile driver Preference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Link driver Profile driver Preference</em>'.
	 * @see intelligentMobility.MobilitySystem#getLink_driverProfile_driverPreference()
	 * @see #getMobilitySystem()
	 * @generated
	 */
	EReference getMobilitySystem_Link_driverProfile_driverPreference();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.MobilitySystem#getLink_vehicleConfiguration_vehicleType <em>Link vehicle Configuration vehicle Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Link vehicle Configuration vehicle Type</em>'.
	 * @see intelligentMobility.MobilitySystem#getLink_vehicleConfiguration_vehicleType()
	 * @see #getMobilitySystem()
	 * @generated
	 */
	EReference getMobilitySystem_Link_vehicleConfiguration_vehicleType();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.MobilitySystem#getLink_environmentBackground_possibleVehicle <em>Link environment Background possible Vehicle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Link environment Background possible Vehicle</em>'.
	 * @see intelligentMobility.MobilitySystem#getLink_environmentBackground_possibleVehicle()
	 * @see #getMobilitySystem()
	 * @generated
	 */
	EReference getMobilitySystem_Link_environmentBackground_possibleVehicle();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.MobilitySystem#getLink_environmentBackground_environmentCondition <em>Link environment Background environment Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Link environment Background environment Condition</em>'.
	 * @see intelligentMobility.MobilitySystem#getLink_environmentBackground_environmentCondition()
	 * @see #getMobilitySystem()
	 * @generated
	 */
	EReference getMobilitySystem_Link_environmentBackground_environmentCondition();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.MobilitySystem#getLink_driverPreference_driverEmotion <em>Link driver Preference driver Emotion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Link driver Preference driver Emotion</em>'.
	 * @see intelligentMobility.MobilitySystem#getLink_driverPreference_driverEmotion()
	 * @see #getMobilitySystem()
	 * @generated
	 */
	EReference getMobilitySystem_Link_driverPreference_driverEmotion();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.MobilitySystem#getLink_driverPreference_drivingBehaviour <em>Link driver Preference driving Behaviour</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Link driver Preference driving Behaviour</em>'.
	 * @see intelligentMobility.MobilitySystem#getLink_driverPreference_drivingBehaviour()
	 * @see #getMobilitySystem()
	 * @generated
	 */
	EReference getMobilitySystem_Link_driverPreference_drivingBehaviour();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.MobilitySystem#getLink_driverPreference_environmentCondition <em>Link driver Preference environment Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Link driver Preference environment Condition</em>'.
	 * @see intelligentMobility.MobilitySystem#getLink_driverPreference_environmentCondition()
	 * @see #getMobilitySystem()
	 * @generated
	 */
	EReference getMobilitySystem_Link_driverPreference_environmentCondition();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.MobilitySystem#getLink_drivingBehaviour_normalBehaviour <em>Link driving Behaviour normal Behaviour</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Link driving Behaviour normal Behaviour</em>'.
	 * @see intelligentMobility.MobilitySystem#getLink_drivingBehaviour_normalBehaviour()
	 * @see #getMobilitySystem()
	 * @generated
	 */
	EReference getMobilitySystem_Link_drivingBehaviour_normalBehaviour();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.MobilitySystem#getLink_normalBehaviour_following <em>Link normal Behaviour following</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Link normal Behaviour following</em>'.
	 * @see intelligentMobility.MobilitySystem#getLink_normalBehaviour_following()
	 * @see #getMobilitySystem()
	 * @generated
	 */
	EReference getMobilitySystem_Link_normalBehaviour_following();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.MobilitySystem#getLink_normalBehaviour_laneChanging <em>Link normal Behaviour lane Changing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Link normal Behaviour lane Changing</em>'.
	 * @see intelligentMobility.MobilitySystem#getLink_normalBehaviour_laneChanging()
	 * @see #getMobilitySystem()
	 * @generated
	 */
	EReference getMobilitySystem_Link_normalBehaviour_laneChanging();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.MobilitySystem#getLink_following_minGap <em>Link following min Gap</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Link following min Gap</em>'.
	 * @see intelligentMobility.MobilitySystem#getLink_following_minGap()
	 * @see #getMobilitySystem()
	 * @generated
	 */
	EReference getMobilitySystem_Link_following_minGap();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.MobilitySystem#getLink_following_forward <em>Link following forward</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Link following forward</em>'.
	 * @see intelligentMobility.MobilitySystem#getLink_following_forward()
	 * @see #getMobilitySystem()
	 * @generated
	 */
	EReference getMobilitySystem_Link_following_forward();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.MobilitySystem#getLink_following_backward <em>Link following backward</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Link following backward</em>'.
	 * @see intelligentMobility.MobilitySystem#getLink_following_backward()
	 * @see #getMobilitySystem()
	 * @generated
	 */
	EReference getMobilitySystem_Link_following_backward();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.MobilitySystem#getLink_laneChanging_turn <em>Link lane Changing turn</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Link lane Changing turn</em>'.
	 * @see intelligentMobility.MobilitySystem#getLink_laneChanging_turn()
	 * @see #getMobilitySystem()
	 * @generated
	 */
	EReference getMobilitySystem_Link_laneChanging_turn();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.MobilitySystem#getLink_laneChanging_gapAcceptance <em>Link lane Changing gap Acceptance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Link lane Changing gap Acceptance</em>'.
	 * @see intelligentMobility.MobilitySystem#getLink_laneChanging_gapAcceptance()
	 * @see #getMobilitySystem()
	 * @generated
	 */
	EReference getMobilitySystem_Link_laneChanging_gapAcceptance();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.MobilitySystem#getLink_laneChanging_environmentCondition <em>Link lane Changing environment Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Link lane Changing environment Condition</em>'.
	 * @see intelligentMobility.MobilitySystem#getLink_laneChanging_environmentCondition()
	 * @see #getMobilitySystem()
	 * @generated
	 */
	EReference getMobilitySystem_Link_laneChanging_environmentCondition();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.MobilitySystem#getLink_abnormalBehaviour_action <em>Link abnormal Behaviour action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Link abnormal Behaviour action</em>'.
	 * @see intelligentMobility.MobilitySystem#getLink_abnormalBehaviour_action()
	 * @see #getMobilitySystem()
	 * @generated
	 */
	EReference getMobilitySystem_Link_abnormalBehaviour_action();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.MobilitySystem#getLink_platoon_leadingVehicle <em>Link platoon leading Vehicle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Link platoon leading Vehicle</em>'.
	 * @see intelligentMobility.MobilitySystem#getLink_platoon_leadingVehicle()
	 * @see #getMobilitySystem()
	 * @generated
	 */
	EReference getMobilitySystem_Link_platoon_leadingVehicle();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.MobilitySystem#getLink_platoon_followingVehicle <em>Link platoon following Vehicle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Link platoon following Vehicle</em>'.
	 * @see intelligentMobility.MobilitySystem#getLink_platoon_followingVehicle()
	 * @see #getMobilitySystem()
	 * @generated
	 */
	EReference getMobilitySystem_Link_platoon_followingVehicle();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.MobilitySystem#getLink_normalVehicle_safetyRequirement <em>Link normal Vehicle safety Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Link normal Vehicle safety Requirement</em>'.
	 * @see intelligentMobility.MobilitySystem#getLink_normalVehicle_safetyRequirement()
	 * @see #getMobilitySystem()
	 * @generated
	 */
	EReference getMobilitySystem_Link_normalVehicle_safetyRequirement();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.MobilitySystem#getLink_followingVehicle_frontVehicle <em>Link following Vehicle front Vehicle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Link following Vehicle front Vehicle</em>'.
	 * @see intelligentMobility.MobilitySystem#getLink_followingVehicle_frontVehicle()
	 * @see #getMobilitySystem()
	 * @generated
	 */
	EReference getMobilitySystem_Link_followingVehicle_frontVehicle();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.MobilitySystem#getLink_environmentCondition_laneType <em>Link environment Condition lane Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Link environment Condition lane Type</em>'.
	 * @see intelligentMobility.MobilitySystem#getLink_environmentCondition_laneType()
	 * @see #getMobilitySystem()
	 * @generated
	 */
	EReference getMobilitySystem_Link_environmentCondition_laneType();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.MobilitySystem#getLink_environmentCondition_regulation <em>Link environment Condition regulation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Link environment Condition regulation</em>'.
	 * @see intelligentMobility.MobilitySystem#getLink_environmentCondition_regulation()
	 * @see #getMobilitySystem()
	 * @generated
	 */
	EReference getMobilitySystem_Link_environmentCondition_regulation();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.MobilitySystem#getLink_environmentCondition_weather <em>Link environment Condition weather</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Link environment Condition weather</em>'.
	 * @see intelligentMobility.MobilitySystem#getLink_environmentCondition_weather()
	 * @see #getMobilitySystem()
	 * @generated
	 */
	EReference getMobilitySystem_Link_environmentCondition_weather();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.MobilitySystem#getLink_environmentCondition_trafficCondition <em>Link environment Condition traffic Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Link environment Condition traffic Condition</em>'.
	 * @see intelligentMobility.MobilitySystem#getLink_environmentCondition_trafficCondition()
	 * @see #getMobilitySystem()
	 * @generated
	 */
	EReference getMobilitySystem_Link_environmentCondition_trafficCondition();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.MobilitySystem#getLink_environmentCondition_specialCondition <em>Link environment Condition special Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Link environment Condition special Condition</em>'.
	 * @see intelligentMobility.MobilitySystem#getLink_environmentCondition_specialCondition()
	 * @see #getMobilitySystem()
	 * @generated
	 */
	EReference getMobilitySystem_Link_environmentCondition_specialCondition();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.MobilitySystem#getLink_laneType_regulation <em>Link lane Type regulation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Link lane Type regulation</em>'.
	 * @see intelligentMobility.MobilitySystem#getLink_laneType_regulation()
	 * @see #getMobilitySystem()
	 * @generated
	 */
	EReference getMobilitySystem_Link_laneType_regulation();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.MobilitySystem#getLink_safetyRequirement_regulation <em>Link safety Requirement regulation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Link safety Requirement regulation</em>'.
	 * @see intelligentMobility.MobilitySystem#getLink_safetyRequirement_regulation()
	 * @see #getMobilitySystem()
	 * @generated
	 */
	EReference getMobilitySystem_Link_safetyRequirement_regulation();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.MobilitySystem#getLink_specialCondition_intersection <em>Link special Condition intersection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Link special Condition intersection</em>'.
	 * @see intelligentMobility.MobilitySystem#getLink_specialCondition_intersection()
	 * @see #getMobilitySystem()
	 * @generated
	 */
	EReference getMobilitySystem_Link_specialCondition_intersection();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.MobilitySystem#getLink_collision_obstruction <em>Link collision obstruction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Link collision obstruction</em>'.
	 * @see intelligentMobility.MobilitySystem#getLink_collision_obstruction()
	 * @see #getMobilitySystem()
	 * @generated
	 */
	EReference getMobilitySystem_Link_collision_obstruction();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.MobilitySystem#getLink_intersection_trafficLight <em>Link intersection traffic Light</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Link intersection traffic Light</em>'.
	 * @see intelligentMobility.MobilitySystem#getLink_intersection_trafficLight()
	 * @see #getMobilitySystem()
	 * @generated
	 */
	EReference getMobilitySystem_Link_intersection_trafficLight();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.MobilitySystem#getSystemID <em>System ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>System ID</em>'.
	 * @see intelligentMobility.MobilitySystem#getSystemID()
	 * @see #getMobilitySystem()
	 * @generated
	 */
	EAttribute getMobilitySystem_SystemID();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.MobilitySystem#getGeographicalScope <em>Geographical Scope</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Geographical Scope</em>'.
	 * @see intelligentMobility.MobilitySystem#getGeographicalScope()
	 * @see #getMobilitySystem()
	 * @generated
	 */
	EAttribute getMobilitySystem_GeographicalScope();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.MobilitySystem#getInfrastructureType <em>Infrastructure Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Infrastructure Type</em>'.
	 * @see intelligentMobility.MobilitySystem#getInfrastructureType()
	 * @see #getMobilitySystem()
	 * @generated
	 */
	EAttribute getMobilitySystem_InfrastructureType();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.MobilitySystem#getInfrastructure <em>Infrastructure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Infrastructure</em>'.
	 * @see intelligentMobility.MobilitySystem#getInfrastructure()
	 * @see #getMobilitySystem()
	 * @generated
	 */
	EReference getMobilitySystem_Infrastructure();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.MobilitySystem#getCommunicationInterfaces <em>Communication Interfaces</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Communication Interfaces</em>'.
	 * @see intelligentMobility.MobilitySystem#getCommunicationInterfaces()
	 * @see #getMobilitySystem()
	 * @generated
	 */
	EReference getMobilitySystem_CommunicationInterfaces();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.MobilitySystem#getGoal <em>Goal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Goal</em>'.
	 * @see intelligentMobility.MobilitySystem#getGoal()
	 * @see #getMobilitySystem()
	 * @generated
	 */
	EReference getMobilitySystem_Goal();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.MobilitySystem#getLink_infrastructure_vehicle_configuration <em>Link infrastructure vehicle configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Link infrastructure vehicle configuration</em>'.
	 * @see intelligentMobility.MobilitySystem#getLink_infrastructure_vehicle_configuration()
	 * @see #getMobilitySystem()
	 * @generated
	 */
	EReference getMobilitySystem_Link_infrastructure_vehicle_configuration();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.MobilitySystem#getLink_communicationInterface_vehicleConfiguration <em>Link communication Interface vehicle Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Link communication Interface vehicle Configuration</em>'.
	 * @see intelligentMobility.MobilitySystem#getLink_communicationInterface_vehicleConfiguration()
	 * @see #getMobilitySystem()
	 * @generated
	 */
	EReference getMobilitySystem_Link_communicationInterface_vehicleConfiguration();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.MobilitySystem#getLink_communicationInterface_infrastructure <em>Link communication Interface infrastructure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Link communication Interface infrastructure</em>'.
	 * @see intelligentMobility.MobilitySystem#getLink_communicationInterface_infrastructure()
	 * @see #getMobilitySystem()
	 * @generated
	 */
	EReference getMobilitySystem_Link_communicationInterface_infrastructure();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.MobilitySystem#getLink_goal_drivingBehaviour <em>Link goal driving Behaviour</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Link goal driving Behaviour</em>'.
	 * @see intelligentMobility.MobilitySystem#getLink_goal_drivingBehaviour()
	 * @see #getMobilitySystem()
	 * @generated
	 */
	EReference getMobilitySystem_Link_goal_drivingBehaviour();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.MobilitySystem#getCooperativeBehaviour <em>Cooperative Behaviour</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Cooperative Behaviour</em>'.
	 * @see intelligentMobility.MobilitySystem#getCooperativeBehaviour()
	 * @see #getMobilitySystem()
	 * @generated
	 */
	EReference getMobilitySystem_CooperativeBehaviour();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.MobilitySystem#getLink_cooperativeBehaviour_communicationInterface <em>Link cooperative Behaviour communication Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Link cooperative Behaviour communication Interface</em>'.
	 * @see intelligentMobility.MobilitySystem#getLink_cooperativeBehaviour_communicationInterface()
	 * @see #getMobilitySystem()
	 * @generated
	 */
	EReference getMobilitySystem_Link_cooperativeBehaviour_communicationInterface();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.MobilitySystem#getLink_cooperativeBehaviour_vehicleConfiguration <em>Link cooperative Behaviour vehicle Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Link cooperative Behaviour vehicle Configuration</em>'.
	 * @see intelligentMobility.MobilitySystem#getLink_cooperativeBehaviour_vehicleConfiguration()
	 * @see #getMobilitySystem()
	 * @generated
	 */
	EReference getMobilitySystem_Link_cooperativeBehaviour_vehicleConfiguration();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.MobilitySystem#getLink_trafficSituation_environmentCondition <em>Link traffic Situation environment Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Link traffic Situation environment Condition</em>'.
	 * @see intelligentMobility.MobilitySystem#getLink_trafficSituation_environmentCondition()
	 * @see #getMobilitySystem()
	 * @generated
	 */
	EReference getMobilitySystem_Link_trafficSituation_environmentCondition();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.MobilitySystem#getLink_following_laneChanging <em>Link following lane Changing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Link following lane Changing</em>'.
	 * @see intelligentMobility.MobilitySystem#getLink_following_laneChanging()
	 * @see #getMobilitySystem()
	 * @generated
	 */
	EReference getMobilitySystem_Link_following_laneChanging();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.MobilitySystem#getLink_collision_specialCondition <em>Link collision special Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Link collision special Condition</em>'.
	 * @see intelligentMobility.MobilitySystem#getLink_collision_specialCondition()
	 * @see #getMobilitySystem()
	 * @generated
	 */
	EReference getMobilitySystem_Link_collision_specialCondition();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.MobilitySystem#getLink_action_backward <em>Link action backward</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Link action backward</em>'.
	 * @see intelligentMobility.MobilitySystem#getLink_action_backward()
	 * @see #getMobilitySystem()
	 * @generated
	 */
	EReference getMobilitySystem_Link_action_backward();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.MobilitySystem#getLink_action_forward <em>Link action forward</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Link action forward</em>'.
	 * @see intelligentMobility.MobilitySystem#getLink_action_forward()
	 * @see #getMobilitySystem()
	 * @generated
	 */
	EReference getMobilitySystem_Link_action_forward();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.MobilitySystem#getLink_action_turn <em>Link action turn</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Link action turn</em>'.
	 * @see intelligentMobility.MobilitySystem#getLink_action_turn()
	 * @see #getMobilitySystem()
	 * @generated
	 */
	EReference getMobilitySystem_Link_action_turn();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.MobilitySystem#getLink_knowledgeAndSkill_driverPreference <em>Link knowledge And Skill driver Preference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Link knowledge And Skill driver Preference</em>'.
	 * @see intelligentMobility.MobilitySystem#getLink_knowledgeAndSkill_driverPreference()
	 * @see #getMobilitySystem()
	 * @generated
	 */
	EReference getMobilitySystem_Link_knowledgeAndSkill_driverPreference();

	/**
	 * Returns the meta object for class '{@link intelligentMobility.Driver_Profile <em>Driver Profile</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Driver Profile</em>'.
	 * @see intelligentMobility.Driver_Profile
	 * @generated
	 */
	EClass getDriver_Profile();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.Driver_Profile#getDriver_preference <em>Driver preference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Driver preference</em>'.
	 * @see intelligentMobility.Driver_Profile#getDriver_preference()
	 * @see #getDriver_Profile()
	 * @generated
	 */
	EReference getDriver_Profile_Driver_preference();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Driver_Profile#getDriverName <em>Driver Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Driver Name</em>'.
	 * @see intelligentMobility.Driver_Profile#getDriverName()
	 * @see #getDriver_Profile()
	 * @generated
	 */
	EAttribute getDriver_Profile_DriverName();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Driver_Profile#getDriverType <em>Driver Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Driver Type</em>'.
	 * @see intelligentMobility.Driver_Profile#getDriverType()
	 * @see #getDriver_Profile()
	 * @generated
	 */
	EAttribute getDriver_Profile_DriverType();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Driver_Profile#getPatienceValue <em>Patience Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Patience Value</em>'.
	 * @see intelligentMobility.Driver_Profile#getPatienceValue()
	 * @see #getDriver_Profile()
	 * @generated
	 */
	EAttribute getDriver_Profile_PatienceValue();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Driver_Profile#getLanePreference <em>Lane Preference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lane Preference</em>'.
	 * @see intelligentMobility.Driver_Profile#getLanePreference()
	 * @see #getDriver_Profile()
	 * @generated
	 */
	EAttribute getDriver_Profile_LanePreference();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Driver_Profile#getEnergySpeedRate <em>Energy Speed Rate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Energy Speed Rate</em>'.
	 * @see intelligentMobility.Driver_Profile#getEnergySpeedRate()
	 * @see #getDriver_Profile()
	 * @generated
	 */
	EAttribute getDriver_Profile_EnergySpeedRate();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Driver_Profile#getRiskLevel <em>Risk Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Risk Level</em>'.
	 * @see intelligentMobility.Driver_Profile#getRiskLevel()
	 * @see #getDriver_Profile()
	 * @generated
	 */
	EAttribute getDriver_Profile_RiskLevel();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Driver_Profile#getReactionTime_min <em>Reaction Time min</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Reaction Time min</em>'.
	 * @see intelligentMobility.Driver_Profile#getReactionTime_min()
	 * @see #getDriver_Profile()
	 * @generated
	 */
	EAttribute getDriver_Profile_ReactionTime_min();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Driver_Profile#getReactionTime_max <em>Reaction Time max</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Reaction Time max</em>'.
	 * @see intelligentMobility.Driver_Profile#getReactionTime_max()
	 * @see #getDriver_Profile()
	 * @generated
	 */
	EAttribute getDriver_Profile_ReactionTime_max();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Driver_Profile#getReactionTime_precision <em>Reaction Time precision</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Reaction Time precision</em>'.
	 * @see intelligentMobility.Driver_Profile#getReactionTime_precision()
	 * @see #getDriver_Profile()
	 * @generated
	 */
	EAttribute getDriver_Profile_ReactionTime_precision();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Driver_Profile#getAge <em>Age</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Age</em>'.
	 * @see intelligentMobility.Driver_Profile#getAge()
	 * @see #getDriver_Profile()
	 * @generated
	 */
	EAttribute getDriver_Profile_Age();

	/**
	 * Returns the meta object for class '{@link intelligentMobility.Vehicle_Configuration <em>Vehicle Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Vehicle Configuration</em>'.
	 * @see intelligentMobility.Vehicle_Configuration
	 * @generated
	 */
	EClass getVehicle_Configuration();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Vehicle_Configuration#getBrandName <em>Brand Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Brand Name</em>'.
	 * @see intelligentMobility.Vehicle_Configuration#getBrandName()
	 * @see #getVehicle_Configuration()
	 * @generated
	 */
	EAttribute getVehicle_Configuration_BrandName();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Vehicle_Configuration#getColorR_min <em>Color Rmin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Color Rmin</em>'.
	 * @see intelligentMobility.Vehicle_Configuration#getColorR_min()
	 * @see #getVehicle_Configuration()
	 * @generated
	 */
	EAttribute getVehicle_Configuration_ColorR_min();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Vehicle_Configuration#getColorR_max <em>Color Rmax</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Color Rmax</em>'.
	 * @see intelligentMobility.Vehicle_Configuration#getColorR_max()
	 * @see #getVehicle_Configuration()
	 * @generated
	 */
	EAttribute getVehicle_Configuration_ColorR_max();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Vehicle_Configuration#getColorG_min <em>Color Gmin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Color Gmin</em>'.
	 * @see intelligentMobility.Vehicle_Configuration#getColorG_min()
	 * @see #getVehicle_Configuration()
	 * @generated
	 */
	EAttribute getVehicle_Configuration_ColorG_min();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Vehicle_Configuration#getColorG_max <em>Color Gmax</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Color Gmax</em>'.
	 * @see intelligentMobility.Vehicle_Configuration#getColorG_max()
	 * @see #getVehicle_Configuration()
	 * @generated
	 */
	EAttribute getVehicle_Configuration_ColorG_max();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Vehicle_Configuration#getColorB_min <em>Color Bmin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Color Bmin</em>'.
	 * @see intelligentMobility.Vehicle_Configuration#getColorB_min()
	 * @see #getVehicle_Configuration()
	 * @generated
	 */
	EAttribute getVehicle_Configuration_ColorB_min();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Vehicle_Configuration#getColorB_max <em>Color Bmax</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Color Bmax</em>'.
	 * @see intelligentMobility.Vehicle_Configuration#getColorB_max()
	 * @see #getVehicle_Configuration()
	 * @generated
	 */
	EAttribute getVehicle_Configuration_ColorB_max();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.Vehicle_Configuration#getVehicle_type <em>Vehicle type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Vehicle type</em>'.
	 * @see intelligentMobility.Vehicle_Configuration#getVehicle_type()
	 * @see #getVehicle_Configuration()
	 * @generated
	 */
	EReference getVehicle_Configuration_Vehicle_type();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Vehicle_Configuration#getGpsYaw <em>Gps Yaw</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Gps Yaw</em>'.
	 * @see intelligentMobility.Vehicle_Configuration#getGpsYaw()
	 * @see #getVehicle_Configuration()
	 * @generated
	 */
	EAttribute getVehicle_Configuration_GpsYaw();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Vehicle_Configuration#getGpsPitch <em>Gps Pitch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Gps Pitch</em>'.
	 * @see intelligentMobility.Vehicle_Configuration#getGpsPitch()
	 * @see #getVehicle_Configuration()
	 * @generated
	 */
	EAttribute getVehicle_Configuration_GpsPitch();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Vehicle_Configuration#getGpsRoll <em>Gps Roll</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Gps Roll</em>'.
	 * @see intelligentMobility.Vehicle_Configuration#getGpsRoll()
	 * @see #getVehicle_Configuration()
	 * @generated
	 */
	EAttribute getVehicle_Configuration_GpsRoll();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Vehicle_Configuration#getLatitude <em>Latitude</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Latitude</em>'.
	 * @see intelligentMobility.Vehicle_Configuration#getLatitude()
	 * @see #getVehicle_Configuration()
	 * @generated
	 */
	EAttribute getVehicle_Configuration_Latitude();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Vehicle_Configuration#getLongitude <em>Longitude</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Longitude</em>'.
	 * @see intelligentMobility.Vehicle_Configuration#getLongitude()
	 * @see #getVehicle_Configuration()
	 * @generated
	 */
	EAttribute getVehicle_Configuration_Longitude();

	/**
	 * Returns the meta object for the reference list '{@link intelligentMobility.Vehicle_Configuration#getConnectedInfrastructure <em>Connected Infrastructure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Connected Infrastructure</em>'.
	 * @see intelligentMobility.Vehicle_Configuration#getConnectedInfrastructure()
	 * @see #getVehicle_Configuration()
	 * @generated
	 */
	EReference getVehicle_Configuration_ConnectedInfrastructure();

	/**
	 * Returns the meta object for class '{@link intelligentMobility.Environment_Background <em>Environment Background</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Environment Background</em>'.
	 * @see intelligentMobility.Environment_Background
	 * @generated
	 */
	EClass getEnvironment_Background();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Environment_Background#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see intelligentMobility.Environment_Background#getName()
	 * @see #getEnvironment_Background()
	 * @generated
	 */
	EAttribute getEnvironment_Background_Name();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Environment_Background#getRoadLength <em>Road Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Road Length</em>'.
	 * @see intelligentMobility.Environment_Background#getRoadLength()
	 * @see #getEnvironment_Background()
	 * @generated
	 */
	EAttribute getEnvironment_Background_RoadLength();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Environment_Background#getRoadShape <em>Road Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Road Shape</em>'.
	 * @see intelligentMobility.Environment_Background#getRoadShape()
	 * @see #getEnvironment_Background()
	 * @generated
	 */
	EAttribute getEnvironment_Background_RoadShape();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Environment_Background#getTotalVehiclePerFrame <em>Total Vehicle Per Frame</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Total Vehicle Per Frame</em>'.
	 * @see intelligentMobility.Environment_Background#getTotalVehiclePerFrame()
	 * @see #getEnvironment_Background()
	 * @generated
	 */
	EAttribute getEnvironment_Background_TotalVehiclePerFrame();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Environment_Background#getTrafficDensity <em>Traffic Density</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Traffic Density</em>'.
	 * @see intelligentMobility.Environment_Background#getTrafficDensity()
	 * @see #getEnvironment_Background()
	 * @generated
	 */
	EAttribute getEnvironment_Background_TrafficDensity();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Environment_Background#getSimulationFrameTime <em>Simulation Frame Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Simulation Frame Time</em>'.
	 * @see intelligentMobility.Environment_Background#getSimulationFrameTime()
	 * @see #getEnvironment_Background()
	 * @generated
	 */
	EAttribute getEnvironment_Background_SimulationFrameTime();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Environment_Background#getSimulationSleepTime <em>Simulation Sleep Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Simulation Sleep Time</em>'.
	 * @see intelligentMobility.Environment_Background#getSimulationSleepTime()
	 * @see #getEnvironment_Background()
	 * @generated
	 */
	EAttribute getEnvironment_Background_SimulationSleepTime();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.Environment_Background#getPossiblevehicles <em>Possiblevehicles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Possiblevehicles</em>'.
	 * @see intelligentMobility.Environment_Background#getPossiblevehicles()
	 * @see #getEnvironment_Background()
	 * @generated
	 */
	EReference getEnvironment_Background_Possiblevehicles();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.Environment_Background#getEnvironment_condition <em>Environment condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Environment condition</em>'.
	 * @see intelligentMobility.Environment_Background#getEnvironment_condition()
	 * @see #getEnvironment_Background()
	 * @generated
	 */
	EReference getEnvironment_Background_Environment_condition();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Environment_Background#getRoadIncline <em>Road Incline</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Road Incline</em>'.
	 * @see intelligentMobility.Environment_Background#getRoadIncline()
	 * @see #getEnvironment_Background()
	 * @generated
	 */
	EAttribute getEnvironment_Background_RoadIncline();

	/**
	 * Returns the meta object for class '{@link intelligentMobility.Driver_Preference <em>Driver Preference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Driver Preference</em>'.
	 * @see intelligentMobility.Driver_Preference
	 * @generated
	 */
	EClass getDriver_Preference();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.Driver_Preference#getDriver_emotions <em>Driver emotions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Driver emotions</em>'.
	 * @see intelligentMobility.Driver_Preference#getDriver_emotions()
	 * @see #getDriver_Preference()
	 * @generated
	 */
	EReference getDriver_Preference_Driver_emotions();

	/**
	 * Returns the meta object for the containment reference '{@link intelligentMobility.Driver_Preference#getKnowledge_and_skills <em>Knowledge and skills</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Knowledge and skills</em>'.
	 * @see intelligentMobility.Driver_Preference#getKnowledge_and_skills()
	 * @see #getDriver_Preference()
	 * @generated
	 */
	EReference getDriver_Preference_Knowledge_and_skills();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Driver_Preference#getName_PreferenceSet <em>Name Preference Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name Preference Set</em>'.
	 * @see intelligentMobility.Driver_Preference#getName_PreferenceSet()
	 * @see #getDriver_Preference()
	 * @generated
	 */
	EAttribute getDriver_Preference_Name_PreferenceSet();

	/**
	 * Returns the meta object for the containment reference '{@link intelligentMobility.Driver_Preference#getDriving_behaviour <em>Driving behaviour</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Driving behaviour</em>'.
	 * @see intelligentMobility.Driver_Preference#getDriving_behaviour()
	 * @see #getDriver_Preference()
	 * @generated
	 */
	EReference getDriver_Preference_Driving_behaviour();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Driver_Preference#getEnvironment_condition <em>Environment condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Environment condition</em>'.
	 * @see intelligentMobility.Driver_Preference#getEnvironment_condition()
	 * @see #getDriver_Preference()
	 * @generated
	 */
	EReference getDriver_Preference_Environment_condition();

	/**
	 * Returns the meta object for class '{@link intelligentMobility.Knowledge_and_Skill <em>Knowledge and Skill</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Knowledge and Skill</em>'.
	 * @see intelligentMobility.Knowledge_and_Skill
	 * @generated
	 */
	EClass getKnowledge_and_Skill();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Knowledge_and_Skill#getDrivingSkill <em>Driving Skill</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Driving Skill</em>'.
	 * @see intelligentMobility.Knowledge_and_Skill#getDrivingSkill()
	 * @see #getKnowledge_and_Skill()
	 * @generated
	 */
	EAttribute getKnowledge_and_Skill_DrivingSkill();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Knowledge_and_Skill#getTrafficSignAwareness <em>Traffic Sign Awareness</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Traffic Sign Awareness</em>'.
	 * @see intelligentMobility.Knowledge_and_Skill#getTrafficSignAwareness()
	 * @see #getKnowledge_and_Skill()
	 * @generated
	 */
	EAttribute getKnowledge_and_Skill_TrafficSignAwareness();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Knowledge_and_Skill#getRegulationAwareness <em>Regulation Awareness</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Regulation Awareness</em>'.
	 * @see intelligentMobility.Knowledge_and_Skill#getRegulationAwareness()
	 * @see #getKnowledge_and_Skill()
	 * @generated
	 */
	EAttribute getKnowledge_and_Skill_RegulationAwareness();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Knowledge_and_Skill#getLaneSwitchPreferenceLevel <em>Lane Switch Preference Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lane Switch Preference Level</em>'.
	 * @see intelligentMobility.Knowledge_and_Skill#getLaneSwitchPreferenceLevel()
	 * @see #getKnowledge_and_Skill()
	 * @generated
	 */
	EAttribute getKnowledge_and_Skill_LaneSwitchPreferenceLevel();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Knowledge_and_Skill#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see intelligentMobility.Knowledge_and_Skill#getName()
	 * @see #getKnowledge_and_Skill()
	 * @generated
	 */
	EAttribute getKnowledge_and_Skill_Name();

	/**
	 * Returns the meta object for class '{@link intelligentMobility.Driver_Emotion <em>Driver Emotion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Driver Emotion</em>'.
	 * @see intelligentMobility.Driver_Emotion
	 * @generated
	 */
	EClass getDriver_Emotion();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Driver_Emotion#getDrowsinessLevel <em>Drowsiness Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Drowsiness Level</em>'.
	 * @see intelligentMobility.Driver_Emotion#getDrowsinessLevel()
	 * @see #getDriver_Emotion()
	 * @generated
	 */
	EAttribute getDriver_Emotion_DrowsinessLevel();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Driver_Emotion#getImpulseControlLevel <em>Impulse Control Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Impulse Control Level</em>'.
	 * @see intelligentMobility.Driver_Emotion#getImpulseControlLevel()
	 * @see #getDriver_Emotion()
	 * @generated
	 */
	EAttribute getDriver_Emotion_ImpulseControlLevel();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Driver_Emotion#getMetanlCondition <em>Metanl Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Metanl Condition</em>'.
	 * @see intelligentMobility.Driver_Emotion#getMetanlCondition()
	 * @see #getDriver_Emotion()
	 * @generated
	 */
	EAttribute getDriver_Emotion_MetanlCondition();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Driver_Emotion#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see intelligentMobility.Driver_Emotion#getName()
	 * @see #getDriver_Emotion()
	 * @generated
	 */
	EAttribute getDriver_Emotion_Name();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Driver_Emotion#getEcgHr <em>Ecg Hr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ecg Hr</em>'.
	 * @see intelligentMobility.Driver_Emotion#getEcgHr()
	 * @see #getDriver_Emotion()
	 * @generated
	 */
	EAttribute getDriver_Emotion_EcgHr();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Driver_Emotion#getGsr <em>Gsr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Gsr</em>'.
	 * @see intelligentMobility.Driver_Emotion#getGsr()
	 * @see #getDriver_Emotion()
	 * @generated
	 */
	EAttribute getDriver_Emotion_Gsr();

	/**
	 * Returns the meta object for class '{@link intelligentMobility.Driving_Behaviour <em>Driving Behaviour</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Driving Behaviour</em>'.
	 * @see intelligentMobility.Driving_Behaviour
	 * @generated
	 */
	EClass getDriving_Behaviour();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Driving_Behaviour#getPrepDistanceForDestination <em>Prep Distance For Destination</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Prep Distance For Destination</em>'.
	 * @see intelligentMobility.Driving_Behaviour#getPrepDistanceForDestination()
	 * @see #getDriving_Behaviour()
	 * @generated
	 */
	EAttribute getDriving_Behaviour_PrepDistanceForDestination();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Driving_Behaviour#getPrepDistanceForTurn <em>Prep Distance For Turn</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Prep Distance For Turn</em>'.
	 * @see intelligentMobility.Driving_Behaviour#getPrepDistanceForTurn()
	 * @see #getDriving_Behaviour()
	 * @generated
	 */
	EAttribute getDriving_Behaviour_PrepDistanceForTurn();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Driving_Behaviour#getInitialSpeed_min <em>Initial Speed min</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Initial Speed min</em>'.
	 * @see intelligentMobility.Driving_Behaviour#getInitialSpeed_min()
	 * @see #getDriving_Behaviour()
	 * @generated
	 */
	EAttribute getDriving_Behaviour_InitialSpeed_min();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Driving_Behaviour#getInitialSpeed_max <em>Initial Speed max</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Initial Speed max</em>'.
	 * @see intelligentMobility.Driving_Behaviour#getInitialSpeed_max()
	 * @see #getDriving_Behaviour()
	 * @generated
	 */
	EAttribute getDriving_Behaviour_InitialSpeed_max();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Driving_Behaviour#getInitialSpeed_precision <em>Initial Speed precision</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Initial Speed precision</em>'.
	 * @see intelligentMobility.Driving_Behaviour#getInitialSpeed_precision()
	 * @see #getDriving_Behaviour()
	 * @generated
	 */
	EAttribute getDriving_Behaviour_InitialSpeed_precision();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Driving_Behaviour#getDesiredSpeed_min <em>Desired Speed min</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Desired Speed min</em>'.
	 * @see intelligentMobility.Driving_Behaviour#getDesiredSpeed_min()
	 * @see #getDriving_Behaviour()
	 * @generated
	 */
	EAttribute getDriving_Behaviour_DesiredSpeed_min();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Driving_Behaviour#getDesiredSpeed_max <em>Desired Speed max</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Desired Speed max</em>'.
	 * @see intelligentMobility.Driving_Behaviour#getDesiredSpeed_max()
	 * @see #getDriving_Behaviour()
	 * @generated
	 */
	EAttribute getDriving_Behaviour_DesiredSpeed_max();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Driving_Behaviour#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see intelligentMobility.Driving_Behaviour#getName()
	 * @see #getDriving_Behaviour()
	 * @generated
	 */
	EAttribute getDriving_Behaviour_Name();

	/**
	 * Returns the meta object for the containment reference '{@link intelligentMobility.Driving_Behaviour#getNormal_behaviour <em>Normal behaviour</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Normal behaviour</em>'.
	 * @see intelligentMobility.Driving_Behaviour#getNormal_behaviour()
	 * @see #getDriving_Behaviour()
	 * @generated
	 */
	EReference getDriving_Behaviour_Normal_behaviour();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Driving_Behaviour#getSteeringAngle <em>Steering Angle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Steering Angle</em>'.
	 * @see intelligentMobility.Driving_Behaviour#getSteeringAngle()
	 * @see #getDriving_Behaviour()
	 * @generated
	 */
	EAttribute getDriving_Behaviour_SteeringAngle();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Driving_Behaviour#getThrottle <em>Throttle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Throttle</em>'.
	 * @see intelligentMobility.Driving_Behaviour#getThrottle()
	 * @see #getDriving_Behaviour()
	 * @generated
	 */
	EAttribute getDriving_Behaviour_Throttle();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Driving_Behaviour#getBrake <em>Brake</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Brake</em>'.
	 * @see intelligentMobility.Driving_Behaviour#getBrake()
	 * @see #getDriving_Behaviour()
	 * @generated
	 */
	EAttribute getDriving_Behaviour_Brake();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Driving_Behaviour#getGear <em>Gear</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Gear</em>'.
	 * @see intelligentMobility.Driving_Behaviour#getGear()
	 * @see #getDriving_Behaviour()
	 * @generated
	 */
	EAttribute getDriving_Behaviour_Gear();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Driving_Behaviour#getHandbrake <em>Handbrake</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Handbrake</em>'.
	 * @see intelligentMobility.Driving_Behaviour#getHandbrake()
	 * @see #getDriving_Behaviour()
	 * @generated
	 */
	EAttribute getDriving_Behaviour_Handbrake();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Driving_Behaviour#getRpm <em>Rpm</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rpm</em>'.
	 * @see intelligentMobility.Driving_Behaviour#getRpm()
	 * @see #getDriving_Behaviour()
	 * @generated
	 */
	EAttribute getDriving_Behaviour_Rpm();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Driving_Behaviour#getKeyEvent <em>Key Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key Event</em>'.
	 * @see intelligentMobility.Driving_Behaviour#getKeyEvent()
	 * @see #getDriving_Behaviour()
	 * @generated
	 */
	EAttribute getDriving_Behaviour_KeyEvent();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Driving_Behaviour#getPedalAngle <em>Pedal Angle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pedal Angle</em>'.
	 * @see intelligentMobility.Driving_Behaviour#getPedalAngle()
	 * @see #getDriving_Behaviour()
	 * @generated
	 */
	EAttribute getDriving_Behaviour_PedalAngle();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Driving_Behaviour#getPedalPressure <em>Pedal Pressure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pedal Pressure</em>'.
	 * @see intelligentMobility.Driving_Behaviour#getPedalPressure()
	 * @see #getDriving_Behaviour()
	 * @generated
	 */
	EAttribute getDriving_Behaviour_PedalPressure();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Driving_Behaviour#getSteerSpeed <em>Steer Speed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Steer Speed</em>'.
	 * @see intelligentMobility.Driving_Behaviour#getSteerSpeed()
	 * @see #getDriving_Behaviour()
	 * @generated
	 */
	EAttribute getDriving_Behaviour_SteerSpeed();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Driving_Behaviour#getIntentType <em>Intent Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Intent Type</em>'.
	 * @see intelligentMobility.Driving_Behaviour#getIntentType()
	 * @see #getDriving_Behaviour()
	 * @generated
	 */
	EAttribute getDriving_Behaviour_IntentType();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Driving_Behaviour#getConfidence <em>Confidence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Confidence</em>'.
	 * @see intelligentMobility.Driving_Behaviour#getConfidence()
	 * @see #getDriving_Behaviour()
	 * @generated
	 */
	EAttribute getDriving_Behaviour_Confidence();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.Driving_Behaviour#getGoal <em>Goal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Goal</em>'.
	 * @see intelligentMobility.Driving_Behaviour#getGoal()
	 * @see #getDriving_Behaviour()
	 * @generated
	 */
	EReference getDriving_Behaviour_Goal();

	/**
	 * Returns the meta object for class '{@link intelligentMobility.Normal_Behaviour <em>Normal Behaviour</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Normal Behaviour</em>'.
	 * @see intelligentMobility.Normal_Behaviour
	 * @generated
	 */
	EClass getNormal_Behaviour();

	/**
	 * Returns the meta object for the containment reference '{@link intelligentMobility.Normal_Behaviour#getFollowing <em>Following</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Following</em>'.
	 * @see intelligentMobility.Normal_Behaviour#getFollowing()
	 * @see #getNormal_Behaviour()
	 * @generated
	 */
	EReference getNormal_Behaviour_Following();

	/**
	 * Returns the meta object for the containment reference '{@link intelligentMobility.Normal_Behaviour#getLanechanging <em>Lanechanging</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Lanechanging</em>'.
	 * @see intelligentMobility.Normal_Behaviour#getLanechanging()
	 * @see #getNormal_Behaviour()
	 * @generated
	 */
	EReference getNormal_Behaviour_Lanechanging();

	/**
	 * Returns the meta object for class '{@link intelligentMobility.Following <em>Following</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Following</em>'.
	 * @see intelligentMobility.Following
	 * @generated
	 */
	EClass getFollowing();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Following#getFollowingGap <em>Following Gap</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Following Gap</em>'.
	 * @see intelligentMobility.Following#getFollowingGap()
	 * @see #getFollowing()
	 * @generated
	 */
	EAttribute getFollowing_FollowingGap();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Following#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see intelligentMobility.Following#getName()
	 * @see #getFollowing()
	 * @generated
	 */
	EAttribute getFollowing_Name();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Following#getMinGap <em>Min Gap</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Min Gap</em>'.
	 * @see intelligentMobility.Following#getMinGap()
	 * @see #getFollowing()
	 * @generated
	 */
	EReference getFollowing_MinGap();

	/**
	 * Returns the meta object for the containment reference '{@link intelligentMobility.Following#getForward <em>Forward</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Forward</em>'.
	 * @see intelligentMobility.Following#getForward()
	 * @see #getFollowing()
	 * @generated
	 */
	EReference getFollowing_Forward();

	/**
	 * Returns the meta object for the containment reference '{@link intelligentMobility.Following#getBackward <em>Backward</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Backward</em>'.
	 * @see intelligentMobility.Following#getBackward()
	 * @see #getFollowing()
	 * @generated
	 */
	EReference getFollowing_Backward();

	/**
	 * Returns the meta object for class '{@link intelligentMobility.LaneChanging <em>Lane Changing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Lane Changing</em>'.
	 * @see intelligentMobility.LaneChanging
	 * @generated
	 */
	EClass getLaneChanging();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.LaneChanging#getLaneSwitchSpeed <em>Lane Switch Speed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lane Switch Speed</em>'.
	 * @see intelligentMobility.LaneChanging#getLaneSwitchSpeed()
	 * @see #getLaneChanging()
	 * @generated
	 */
	EAttribute getLaneChanging_LaneSwitchSpeed();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.LaneChanging#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see intelligentMobility.LaneChanging#getName()
	 * @see #getLaneChanging()
	 * @generated
	 */
	EAttribute getLaneChanging_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.LaneChanging#getTurn <em>Turn</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Turn</em>'.
	 * @see intelligentMobility.LaneChanging#getTurn()
	 * @see #getLaneChanging()
	 * @generated
	 */
	EReference getLaneChanging_Turn();

	/**
	 * Returns the meta object for the containment reference '{@link intelligentMobility.LaneChanging#getGapacceptance <em>Gapacceptance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Gapacceptance</em>'.
	 * @see intelligentMobility.LaneChanging#getGapacceptance()
	 * @see #getLaneChanging()
	 * @generated
	 */
	EReference getLaneChanging_Gapacceptance();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.LaneChanging#getEnvironment_condition <em>Environment condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Environment condition</em>'.
	 * @see intelligentMobility.LaneChanging#getEnvironment_condition()
	 * @see #getLaneChanging()
	 * @generated
	 */
	EReference getLaneChanging_Environment_condition();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.LaneChanging#getLeftLaneChange <em>Left Lane Change</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Left Lane Change</em>'.
	 * @see intelligentMobility.LaneChanging#getLeftLaneChange()
	 * @see #getLaneChanging()
	 * @generated
	 */
	EAttribute getLaneChanging_LeftLaneChange();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.LaneChanging#getRightLaneChange <em>Right Lane Change</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Right Lane Change</em>'.
	 * @see intelligentMobility.LaneChanging#getRightLaneChange()
	 * @see #getLaneChanging()
	 * @generated
	 */
	EAttribute getLaneChanging_RightLaneChange();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.LaneChanging#getLeftLaneBranch <em>Left Lane Branch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Left Lane Branch</em>'.
	 * @see intelligentMobility.LaneChanging#getLeftLaneBranch()
	 * @see #getLaneChanging()
	 * @generated
	 */
	EAttribute getLaneChanging_LeftLaneBranch();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.LaneChanging#getRightLaneBranch <em>Right Lane Branch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Right Lane Branch</em>'.
	 * @see intelligentMobility.LaneChanging#getRightLaneBranch()
	 * @see #getLaneChanging()
	 * @generated
	 */
	EAttribute getLaneChanging_RightLaneBranch();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.LaneChanging#getAction <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Action</em>'.
	 * @see intelligentMobility.LaneChanging#getAction()
	 * @see #getLaneChanging()
	 * @generated
	 */
	EReference getLaneChanging_Action();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.LaneChanging#getManeuverType <em>Maneuver Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Maneuver Type</em>'.
	 * @see intelligentMobility.LaneChanging#getManeuverType()
	 * @see #getLaneChanging()
	 * @generated
	 */
	EAttribute getLaneChanging_ManeuverType();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.LaneChanging#getDuration <em>Duration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Duration</em>'.
	 * @see intelligentMobility.LaneChanging#getDuration()
	 * @see #getLaneChanging()
	 * @generated
	 */
	EAttribute getLaneChanging_Duration();

	/**
	 * Returns the meta object for class '{@link intelligentMobility.Abnormal_Behaviour <em>Abnormal Behaviour</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abnormal Behaviour</em>'.
	 * @see intelligentMobility.Abnormal_Behaviour
	 * @generated
	 */
	EClass getAbnormal_Behaviour();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Abnormal_Behaviour#isZigzag_Driving <em>Zigzag Driving</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Zigzag Driving</em>'.
	 * @see intelligentMobility.Abnormal_Behaviour#isZigzag_Driving()
	 * @see #getAbnormal_Behaviour()
	 * @generated
	 */
	EAttribute getAbnormal_Behaviour_Zigzag_Driving();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Abnormal_Behaviour#isRisky_Acceleration <em>Risky Acceleration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Risky Acceleration</em>'.
	 * @see intelligentMobility.Abnormal_Behaviour#isRisky_Acceleration()
	 * @see #getAbnormal_Behaviour()
	 * @generated
	 */
	EAttribute getAbnormal_Behaviour_Risky_Acceleration();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Abnormal_Behaviour#isRisky_Lanechanging <em>Risky Lanechanging</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Risky Lanechanging</em>'.
	 * @see intelligentMobility.Abnormal_Behaviour#isRisky_Lanechanging()
	 * @see #getAbnormal_Behaviour()
	 * @generated
	 */
	EAttribute getAbnormal_Behaviour_Risky_Lanechanging();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Abnormal_Behaviour#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see intelligentMobility.Abnormal_Behaviour#getName()
	 * @see #getAbnormal_Behaviour()
	 * @generated
	 */
	EAttribute getAbnormal_Behaviour_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.Abnormal_Behaviour#getActions <em>Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Actions</em>'.
	 * @see intelligentMobility.Abnormal_Behaviour#getActions()
	 * @see #getAbnormal_Behaviour()
	 * @generated
	 */
	EReference getAbnormal_Behaviour_Actions();

	/**
	 * Returns the meta object for class '{@link intelligentMobility.Forward <em>Forward</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Forward</em>'.
	 * @see intelligentMobility.Forward
	 * @generated
	 */
	EClass getForward();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Forward#getAcceleration <em>Acceleration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Acceleration</em>'.
	 * @see intelligentMobility.Forward#getAcceleration()
	 * @see #getForward()
	 * @generated
	 */
	EAttribute getForward_Acceleration();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Forward#getDeceleration <em>Deceleration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Deceleration</em>'.
	 * @see intelligentMobility.Forward#getDeceleration()
	 * @see #getForward()
	 * @generated
	 */
	EAttribute getForward_Deceleration();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Forward#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see intelligentMobility.Forward#getName()
	 * @see #getForward()
	 * @generated
	 */
	EAttribute getForward_Name();

	/**
	 * Returns the meta object for class '{@link intelligentMobility.Backward <em>Backward</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Backward</em>'.
	 * @see intelligentMobility.Backward
	 * @generated
	 */
	EClass getBackward();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Backward#getBackwardSpeed <em>Backward Speed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Backward Speed</em>'.
	 * @see intelligentMobility.Backward#getBackwardSpeed()
	 * @see #getBackward()
	 * @generated
	 */
	EAttribute getBackward_BackwardSpeed();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Backward#getBackDistance <em>Back Distance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Back Distance</em>'.
	 * @see intelligentMobility.Backward#getBackDistance()
	 * @see #getBackward()
	 * @generated
	 */
	EAttribute getBackward_BackDistance();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Backward#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see intelligentMobility.Backward#getName()
	 * @see #getBackward()
	 * @generated
	 */
	EAttribute getBackward_Name();

	/**
	 * Returns the meta object for class '{@link intelligentMobility.Turn <em>Turn</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Turn</em>'.
	 * @see intelligentMobility.Turn
	 * @generated
	 */
	EClass getTurn();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Turn#getTurnSide <em>Turn Side</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Turn Side</em>'.
	 * @see intelligentMobility.Turn#getTurnSide()
	 * @see #getTurn()
	 * @generated
	 */
	EAttribute getTurn_TurnSide();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Turn#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see intelligentMobility.Turn#getName()
	 * @see #getTurn()
	 * @generated
	 */
	EAttribute getTurn_Name();

	/**
	 * Returns the meta object for class '{@link intelligentMobility.GapAcceptance <em>Gap Acceptance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Gap Acceptance</em>'.
	 * @see intelligentMobility.GapAcceptance
	 * @generated
	 */
	EClass getGapAcceptance();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.GapAcceptance#getLagGap <em>Lag Gap</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lag Gap</em>'.
	 * @see intelligentMobility.GapAcceptance#getLagGap()
	 * @see #getGapAcceptance()
	 * @generated
	 */
	EAttribute getGapAcceptance_LagGap();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.GapAcceptance#getLeadGap <em>Lead Gap</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lead Gap</em>'.
	 * @see intelligentMobility.GapAcceptance#getLeadGap()
	 * @see #getGapAcceptance()
	 * @generated
	 */
	EAttribute getGapAcceptance_LeadGap();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.GapAcceptance#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see intelligentMobility.GapAcceptance#getName()
	 * @see #getGapAcceptance()
	 * @generated
	 */
	EAttribute getGapAcceptance_Name();

	/**
	 * Returns the meta object for class '{@link intelligentMobility.Action <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action</em>'.
	 * @see intelligentMobility.Action
	 * @generated
	 */
	EClass getAction();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Action#getActionType <em>Action Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Action Type</em>'.
	 * @see intelligentMobility.Action#getActionType()
	 * @see #getAction()
	 * @generated
	 */
	EAttribute getAction_ActionType();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Action#getTimestamp <em>Timestamp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Timestamp</em>'.
	 * @see intelligentMobility.Action#getTimestamp()
	 * @see #getAction()
	 * @generated
	 */
	EAttribute getAction_Timestamp();

	/**
	 * Returns the meta object for class '{@link intelligentMobility.Vehicle_Type <em>Vehicle Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Vehicle Type</em>'.
	 * @see intelligentMobility.Vehicle_Type
	 * @generated
	 */
	EClass getVehicle_Type();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Vehicle_Type#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see intelligentMobility.Vehicle_Type#getType()
	 * @see #getVehicle_Type()
	 * @generated
	 */
	EAttribute getVehicle_Type_Type();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Vehicle_Type#getMaxSpeed <em>Max Speed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Speed</em>'.
	 * @see intelligentMobility.Vehicle_Type#getMaxSpeed()
	 * @see #getVehicle_Type()
	 * @generated
	 */
	EAttribute getVehicle_Type_MaxSpeed();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Vehicle_Type#getVehicleWidth_min <em>Vehicle Width min</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Vehicle Width min</em>'.
	 * @see intelligentMobility.Vehicle_Type#getVehicleWidth_min()
	 * @see #getVehicle_Type()
	 * @generated
	 */
	EAttribute getVehicle_Type_VehicleWidth_min();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Vehicle_Type#getVehicleWidth_max <em>Vehicle Width max</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Vehicle Width max</em>'.
	 * @see intelligentMobility.Vehicle_Type#getVehicleWidth_max()
	 * @see #getVehicle_Type()
	 * @generated
	 */
	EAttribute getVehicle_Type_VehicleWidth_max();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Vehicle_Type#getVehicleWidth_precision <em>Vehicle Width precision</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Vehicle Width precision</em>'.
	 * @see intelligentMobility.Vehicle_Type#getVehicleWidth_precision()
	 * @see #getVehicle_Type()
	 * @generated
	 */
	EAttribute getVehicle_Type_VehicleWidth_precision();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Vehicle_Type#getVehicleLength_min <em>Vehicle Length min</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Vehicle Length min</em>'.
	 * @see intelligentMobility.Vehicle_Type#getVehicleLength_min()
	 * @see #getVehicle_Type()
	 * @generated
	 */
	EAttribute getVehicle_Type_VehicleLength_min();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Vehicle_Type#getVehicleLength_max <em>Vehicle Length max</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Vehicle Length max</em>'.
	 * @see intelligentMobility.Vehicle_Type#getVehicleLength_max()
	 * @see #getVehicle_Type()
	 * @generated
	 */
	EAttribute getVehicle_Type_VehicleLength_max();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Vehicle_Type#getVehicleLength_precision <em>Vehicle Length precision</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Vehicle Length precision</em>'.
	 * @see intelligentMobility.Vehicle_Type#getVehicleLength_precision()
	 * @see #getVehicle_Type()
	 * @generated
	 */
	EAttribute getVehicle_Type_VehicleLength_precision();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Vehicle_Type#getVehicleHeight_min <em>Vehicle Height min</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Vehicle Height min</em>'.
	 * @see intelligentMobility.Vehicle_Type#getVehicleHeight_min()
	 * @see #getVehicle_Type()
	 * @generated
	 */
	EAttribute getVehicle_Type_VehicleHeight_min();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Vehicle_Type#getVehicleHeight_max <em>Vehicle Height max</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Vehicle Height max</em>'.
	 * @see intelligentMobility.Vehicle_Type#getVehicleHeight_max()
	 * @see #getVehicle_Type()
	 * @generated
	 */
	EAttribute getVehicle_Type_VehicleHeight_max();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Vehicle_Type#getVehicleHeight_precision <em>Vehicle Height precision</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Vehicle Height precision</em>'.
	 * @see intelligentMobility.Vehicle_Type#getVehicleHeight_precision()
	 * @see #getVehicle_Type()
	 * @generated
	 */
	EAttribute getVehicle_Type_VehicleHeight_precision();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Vehicle_Type#getSpeed <em>Speed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Speed</em>'.
	 * @see intelligentMobility.Vehicle_Type#getSpeed()
	 * @see #getVehicle_Type()
	 * @generated
	 */
	EAttribute getVehicle_Type_Speed();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Vehicle_Type#getStop <em>Stop</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stop</em>'.
	 * @see intelligentMobility.Vehicle_Type#getStop()
	 * @see #getVehicle_Type()
	 * @generated
	 */
	EAttribute getVehicle_Type_Stop();

	/**
	 * Returns the meta object for class '{@link intelligentMobility.Platoon <em>Platoon</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Platoon</em>'.
	 * @see intelligentMobility.Platoon
	 * @generated
	 */
	EClass getPlatoon();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Platoon#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see intelligentMobility.Platoon#getName()
	 * @see #getPlatoon()
	 * @generated
	 */
	EAttribute getPlatoon_Name();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Platoon#getV2vTime <em>V2v Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>V2v Time</em>'.
	 * @see intelligentMobility.Platoon#getV2vTime()
	 * @see #getPlatoon()
	 * @generated
	 */
	EAttribute getPlatoon_V2vTime();

	/**
	 * Returns the meta object for the attribute list '{@link intelligentMobility.Platoon#getFollowerCount <em>Follower Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Follower Count</em>'.
	 * @see intelligentMobility.Platoon#getFollowerCount()
	 * @see #getPlatoon()
	 * @generated
	 */
	EAttribute getPlatoon_FollowerCount();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Platoon#isResetColor <em>Reset Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Reset Color</em>'.
	 * @see intelligentMobility.Platoon#isResetColor()
	 * @see #getPlatoon()
	 * @generated
	 */
	EAttribute getPlatoon_ResetColor();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Platoon#getColorR_min <em>Color Rmin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Color Rmin</em>'.
	 * @see intelligentMobility.Platoon#getColorR_min()
	 * @see #getPlatoon()
	 * @generated
	 */
	EAttribute getPlatoon_ColorR_min();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Platoon#getColorR_max <em>Color Rmax</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Color Rmax</em>'.
	 * @see intelligentMobility.Platoon#getColorR_max()
	 * @see #getPlatoon()
	 * @generated
	 */
	EAttribute getPlatoon_ColorR_max();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Platoon#getColorG_min <em>Color Gmin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Color Gmin</em>'.
	 * @see intelligentMobility.Platoon#getColorG_min()
	 * @see #getPlatoon()
	 * @generated
	 */
	EAttribute getPlatoon_ColorG_min();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Platoon#getColorG_max <em>Color Gmax</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Color Gmax</em>'.
	 * @see intelligentMobility.Platoon#getColorG_max()
	 * @see #getPlatoon()
	 * @generated
	 */
	EAttribute getPlatoon_ColorG_max();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Platoon#getColorB_min <em>Color Bmin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Color Bmin</em>'.
	 * @see intelligentMobility.Platoon#getColorB_min()
	 * @see #getPlatoon()
	 * @generated
	 */
	EAttribute getPlatoon_ColorB_min();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Platoon#getColorB_max <em>Color Bmax</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Color Bmax</em>'.
	 * @see intelligentMobility.Platoon#getColorB_max()
	 * @see #getPlatoon()
	 * @generated
	 */
	EAttribute getPlatoon_ColorB_max();

	/**
	 * Returns the meta object for the containment reference '{@link intelligentMobility.Platoon#getLeading_vehicle <em>Leading vehicle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Leading vehicle</em>'.
	 * @see intelligentMobility.Platoon#getLeading_vehicle()
	 * @see #getPlatoon()
	 * @generated
	 */
	EReference getPlatoon_Leading_vehicle();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.Platoon#getFollowing_vehicle <em>Following vehicle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Following vehicle</em>'.
	 * @see intelligentMobility.Platoon#getFollowing_vehicle()
	 * @see #getPlatoon()
	 * @generated
	 */
	EReference getPlatoon_Following_vehicle();

	/**
	 * Returns the meta object for class '{@link intelligentMobility.Normal_Vehicle <em>Normal Vehicle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Normal Vehicle</em>'.
	 * @see intelligentMobility.Normal_Vehicle
	 * @generated
	 */
	EClass getNormal_Vehicle();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Normal_Vehicle#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see intelligentMobility.Normal_Vehicle#getName()
	 * @see #getNormal_Vehicle()
	 * @generated
	 */
	EAttribute getNormal_Vehicle_Name();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Normal_Vehicle#isResetColor <em>Reset Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Reset Color</em>'.
	 * @see intelligentMobility.Normal_Vehicle#isResetColor()
	 * @see #getNormal_Vehicle()
	 * @generated
	 */
	EAttribute getNormal_Vehicle_ResetColor();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Normal_Vehicle#getColorR_min <em>Color Rmin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Color Rmin</em>'.
	 * @see intelligentMobility.Normal_Vehicle#getColorR_min()
	 * @see #getNormal_Vehicle()
	 * @generated
	 */
	EAttribute getNormal_Vehicle_ColorR_min();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Normal_Vehicle#getColorR_max <em>Color Rmax</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Color Rmax</em>'.
	 * @see intelligentMobility.Normal_Vehicle#getColorR_max()
	 * @see #getNormal_Vehicle()
	 * @generated
	 */
	EAttribute getNormal_Vehicle_ColorR_max();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Normal_Vehicle#getColorG_min <em>Color Gmin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Color Gmin</em>'.
	 * @see intelligentMobility.Normal_Vehicle#getColorG_min()
	 * @see #getNormal_Vehicle()
	 * @generated
	 */
	EAttribute getNormal_Vehicle_ColorG_min();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Normal_Vehicle#getColorG_max <em>Color Gmax</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Color Gmax</em>'.
	 * @see intelligentMobility.Normal_Vehicle#getColorG_max()
	 * @see #getNormal_Vehicle()
	 * @generated
	 */
	EAttribute getNormal_Vehicle_ColorG_max();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Normal_Vehicle#getColorB_min <em>Color Bmin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Color Bmin</em>'.
	 * @see intelligentMobility.Normal_Vehicle#getColorB_min()
	 * @see #getNormal_Vehicle()
	 * @generated
	 */
	EAttribute getNormal_Vehicle_ColorB_min();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Normal_Vehicle#getColorB_max <em>Color Bmax</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Color Bmax</em>'.
	 * @see intelligentMobility.Normal_Vehicle#getColorB_max()
	 * @see #getNormal_Vehicle()
	 * @generated
	 */
	EAttribute getNormal_Vehicle_ColorB_max();

	/**
	 * Returns the meta object for the containment reference '{@link intelligentMobility.Normal_Vehicle#getSafety_requirements <em>Safety requirements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Safety requirements</em>'.
	 * @see intelligentMobility.Normal_Vehicle#getSafety_requirements()
	 * @see #getNormal_Vehicle()
	 * @generated
	 */
	EReference getNormal_Vehicle_Safety_requirements();

	/**
	 * Returns the meta object for class '{@link intelligentMobility.Leading_Vehicle <em>Leading Vehicle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Leading Vehicle</em>'.
	 * @see intelligentMobility.Leading_Vehicle
	 * @generated
	 */
	EClass getLeading_Vehicle();

	/**
	 * Returns the meta object for class '{@link intelligentMobility.Following_Vehicle <em>Following Vehicle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Following Vehicle</em>'.
	 * @see intelligentMobility.Following_Vehicle
	 * @generated
	 */
	EClass getFollowing_Vehicle();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Following_Vehicle#getHeadwayMin <em>Headway Min</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Headway Min</em>'.
	 * @see intelligentMobility.Following_Vehicle#getHeadwayMin()
	 * @see #getFollowing_Vehicle()
	 * @generated
	 */
	EAttribute getFollowing_Vehicle_HeadwayMin();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Following_Vehicle#getHeadwayMax <em>Headway Max</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Headway Max</em>'.
	 * @see intelligentMobility.Following_Vehicle#getHeadwayMax()
	 * @see #getFollowing_Vehicle()
	 * @generated
	 */
	EAttribute getFollowing_Vehicle_HeadwayMax();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Following_Vehicle#getFrontvehicle <em>Frontvehicle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Frontvehicle</em>'.
	 * @see intelligentMobility.Following_Vehicle#getFrontvehicle()
	 * @see #getFollowing_Vehicle()
	 * @generated
	 */
	EReference getFollowing_Vehicle_Frontvehicle();

	/**
	 * Returns the meta object for class '{@link intelligentMobility.PlatoonMember <em>Platoon Member</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Platoon Member</em>'.
	 * @see intelligentMobility.PlatoonMember
	 * @generated
	 */
	EClass getPlatoonMember();

	/**
	 * Returns the meta object for class '{@link intelligentMobility.PossibleVehicle <em>Possible Vehicle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Possible Vehicle</em>'.
	 * @see intelligentMobility.PossibleVehicle
	 * @generated
	 */
	EClass getPossibleVehicle();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.PossibleVehicle#getVehicleType <em>Vehicle Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Vehicle Type</em>'.
	 * @see intelligentMobility.PossibleVehicle#getVehicleType()
	 * @see #getPossibleVehicle()
	 * @generated
	 */
	EAttribute getPossibleVehicle_VehicleType();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.PossibleVehicle#getAmountPercentage <em>Amount Percentage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Amount Percentage</em>'.
	 * @see intelligentMobility.PossibleVehicle#getAmountPercentage()
	 * @see #getPossibleVehicle()
	 * @generated
	 */
	EAttribute getPossibleVehicle_AmountPercentage();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.PossibleVehicle#getSimulationOrderIndex <em>Simulation Order Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Simulation Order Index</em>'.
	 * @see intelligentMobility.PossibleVehicle#getSimulationOrderIndex()
	 * @see #getPossibleVehicle()
	 * @generated
	 */
	EAttribute getPossibleVehicle_SimulationOrderIndex();

	/**
	 * Returns the meta object for class '{@link intelligentMobility.Environment_Condition <em>Environment Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Environment Condition</em>'.
	 * @see intelligentMobility.Environment_Condition
	 * @generated
	 */
	EClass getEnvironment_Condition();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Environment_Condition#getRoadType <em>Road Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Road Type</em>'.
	 * @see intelligentMobility.Environment_Condition#getRoadType()
	 * @see #getEnvironment_Condition()
	 * @generated
	 */
	EAttribute getEnvironment_Condition_RoadType();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Environment_Condition#getLaneAmount <em>Lane Amount</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lane Amount</em>'.
	 * @see intelligentMobility.Environment_Condition#getLaneAmount()
	 * @see #getEnvironment_Condition()
	 * @generated
	 */
	EAttribute getEnvironment_Condition_LaneAmount();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Environment_Condition#getName_EnvironmentCondition <em>Name Environment Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name Environment Condition</em>'.
	 * @see intelligentMobility.Environment_Condition#getName_EnvironmentCondition()
	 * @see #getEnvironment_Condition()
	 * @generated
	 */
	EAttribute getEnvironment_Condition_Name_EnvironmentCondition();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.Environment_Condition#getLane_type <em>Lane type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Lane type</em>'.
	 * @see intelligentMobility.Environment_Condition#getLane_type()
	 * @see #getEnvironment_Condition()
	 * @generated
	 */
	EReference getEnvironment_Condition_Lane_type();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.Environment_Condition#getRegulations <em>Regulations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Regulations</em>'.
	 * @see intelligentMobility.Environment_Condition#getRegulations()
	 * @see #getEnvironment_Condition()
	 * @generated
	 */
	EReference getEnvironment_Condition_Regulations();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.Environment_Condition#getWeather <em>Weather</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Weather</em>'.
	 * @see intelligentMobility.Environment_Condition#getWeather()
	 * @see #getEnvironment_Condition()
	 * @generated
	 */
	EReference getEnvironment_Condition_Weather();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.Environment_Condition#getTraffic_condition <em>Traffic condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Traffic condition</em>'.
	 * @see intelligentMobility.Environment_Condition#getTraffic_condition()
	 * @see #getEnvironment_Condition()
	 * @generated
	 */
	EReference getEnvironment_Condition_Traffic_condition();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.Environment_Condition#getSpecial_condition <em>Special condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Special condition</em>'.
	 * @see intelligentMobility.Environment_Condition#getSpecial_condition()
	 * @see #getEnvironment_Condition()
	 * @generated
	 */
	EReference getEnvironment_Condition_Special_condition();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Environment_Condition#getCueType <em>Cue Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cue Type</em>'.
	 * @see intelligentMobility.Environment_Condition#getCueType()
	 * @see #getEnvironment_Condition()
	 * @generated
	 */
	EAttribute getEnvironment_Condition_CueType();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Environment_Condition#getSalience <em>Salience</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Salience</em>'.
	 * @see intelligentMobility.Environment_Condition#getSalience()
	 * @see #getEnvironment_Condition()
	 * @generated
	 */
	EAttribute getEnvironment_Condition_Salience();

	/**
	 * Returns the meta object for the reference list '{@link intelligentMobility.Environment_Condition#getPosition <em>Position</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Position</em>'.
	 * @see intelligentMobility.Environment_Condition#getPosition()
	 * @see #getEnvironment_Condition()
	 * @generated
	 */
	EReference getEnvironment_Condition_Position();

	/**
	 * Returns the meta object for class '{@link intelligentMobility.Lane_Type <em>Lane Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Lane Type</em>'.
	 * @see intelligentMobility.Lane_Type
	 * @generated
	 */
	EClass getLane_Type();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Lane_Type#getLaneType <em>Lane Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lane Type</em>'.
	 * @see intelligentMobility.Lane_Type#getLaneType()
	 * @see #getLane_Type()
	 * @generated
	 */
	EAttribute getLane_Type_LaneType();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Lane_Type#getLaneCount <em>Lane Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lane Count</em>'.
	 * @see intelligentMobility.Lane_Type#getLaneCount()
	 * @see #getLane_Type()
	 * @generated
	 */
	EAttribute getLane_Type_LaneCount();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Lane_Type#getLaneWidth <em>Lane Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lane Width</em>'.
	 * @see intelligentMobility.Lane_Type#getLaneWidth()
	 * @see #getLane_Type()
	 * @generated
	 */
	EAttribute getLane_Type_LaneWidth();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Lane_Type#getLaneLength <em>Lane Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lane Length</em>'.
	 * @see intelligentMobility.Lane_Type#getLaneLength()
	 * @see #getLane_Type()
	 * @generated
	 */
	EAttribute getLane_Type_LaneLength();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Lane_Type#getMaxSpeedLimitation <em>Max Speed Limitation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Speed Limitation</em>'.
	 * @see intelligentMobility.Lane_Type#getMaxSpeedLimitation()
	 * @see #getLane_Type()
	 * @generated
	 */
	EAttribute getLane_Type_MaxSpeedLimitation();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Lane_Type#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see intelligentMobility.Lane_Type#getName()
	 * @see #getLane_Type()
	 * @generated
	 */
	EAttribute getLane_Type_Name();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Lane_Type#getRegulations <em>Regulations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Regulations</em>'.
	 * @see intelligentMobility.Lane_Type#getRegulations()
	 * @see #getLane_Type()
	 * @generated
	 */
	EReference getLane_Type_Regulations();

	/**
	 * Returns the meta object for class '{@link intelligentMobility.Regulation <em>Regulation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Regulation</em>'.
	 * @see intelligentMobility.Regulation
	 * @generated
	 */
	EClass getRegulation();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Regulation#getLegislation <em>Legislation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Legislation</em>'.
	 * @see intelligentMobility.Regulation#getLegislation()
	 * @see #getRegulation()
	 * @generated
	 */
	EAttribute getRegulation_Legislation();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Regulation#getCourtesy <em>Courtesy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Courtesy</em>'.
	 * @see intelligentMobility.Regulation#getCourtesy()
	 * @see #getRegulation()
	 * @generated
	 */
	EAttribute getRegulation_Courtesy();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Regulation#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see intelligentMobility.Regulation#getName()
	 * @see #getRegulation()
	 * @generated
	 */
	EAttribute getRegulation_Name();

	/**
	 * Returns the meta object for class '{@link intelligentMobility.Safety_Requirement <em>Safety Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Safety Requirement</em>'.
	 * @see intelligentMobility.Safety_Requirement
	 * @generated
	 */
	EClass getSafety_Requirement();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Safety_Requirement#getSafeSecond <em>Safe Second</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Safe Second</em>'.
	 * @see intelligentMobility.Safety_Requirement#getSafeSecond()
	 * @see #getSafety_Requirement()
	 * @generated
	 */
	EAttribute getSafety_Requirement_SafeSecond();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Safety_Requirement#getSafezoneLength_default <em>Safezone Length default</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Safezone Length default</em>'.
	 * @see intelligentMobility.Safety_Requirement#getSafezoneLength_default()
	 * @see #getSafety_Requirement()
	 * @generated
	 */
	EAttribute getSafety_Requirement_SafezoneLength_default();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Safety_Requirement#getSafeFrontMin <em>Safe Front Min</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Safe Front Min</em>'.
	 * @see intelligentMobility.Safety_Requirement#getSafeFrontMin()
	 * @see #getSafety_Requirement()
	 * @generated
	 */
	EAttribute getSafety_Requirement_SafeFrontMin();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Safety_Requirement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see intelligentMobility.Safety_Requirement#getName()
	 * @see #getSafety_Requirement()
	 * @generated
	 */
	EAttribute getSafety_Requirement_Name();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Safety_Requirement#getRegulations <em>Regulations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Regulations</em>'.
	 * @see intelligentMobility.Safety_Requirement#getRegulations()
	 * @see #getSafety_Requirement()
	 * @generated
	 */
	EReference getSafety_Requirement_Regulations();

	/**
	 * Returns the meta object for class '{@link intelligentMobility.Weather <em>Weather</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Weather</em>'.
	 * @see intelligentMobility.Weather
	 * @generated
	 */
	EClass getWeather();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Weather#getSlipperiness <em>Slipperiness</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Slipperiness</em>'.
	 * @see intelligentMobility.Weather#getSlipperiness()
	 * @see #getWeather()
	 * @generated
	 */
	EAttribute getWeather_Slipperiness();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Weather#getWeatherType <em>Weather Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Weather Type</em>'.
	 * @see intelligentMobility.Weather#getWeatherType()
	 * @see #getWeather()
	 * @generated
	 */
	EAttribute getWeather_WeatherType();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Weather#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see intelligentMobility.Weather#getName()
	 * @see #getWeather()
	 * @generated
	 */
	EAttribute getWeather_Name();

	/**
	 * Returns the meta object for class '{@link intelligentMobility.Traffic_Situation <em>Traffic Situation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Traffic Situation</em>'.
	 * @see intelligentMobility.Traffic_Situation
	 * @generated
	 */
	EClass getTraffic_Situation();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Traffic_Situation#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see intelligentMobility.Traffic_Situation#getName()
	 * @see #getTraffic_Situation()
	 * @generated
	 */
	EAttribute getTraffic_Situation_Name();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Traffic_Situation#getTrafficType <em>Traffic Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Traffic Type</em>'.
	 * @see intelligentMobility.Traffic_Situation#getTrafficType()
	 * @see #getTraffic_Situation()
	 * @generated
	 */
	EAttribute getTraffic_Situation_TrafficType();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Traffic_Situation#getStimulusType <em>Stimulus Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stimulus Type</em>'.
	 * @see intelligentMobility.Traffic_Situation#getStimulusType()
	 * @see #getTraffic_Situation()
	 * @generated
	 */
	EAttribute getTraffic_Situation_StimulusType();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Traffic_Situation#getIntensity <em>Intensity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Intensity</em>'.
	 * @see intelligentMobility.Traffic_Situation#getIntensity()
	 * @see #getTraffic_Situation()
	 * @generated
	 */
	EAttribute getTraffic_Situation_Intensity();

	/**
	 * Returns the meta object for class '{@link intelligentMobility.Special_Condition <em>Special Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Special Condition</em>'.
	 * @see intelligentMobility.Special_Condition
	 * @generated
	 */
	EClass getSpecial_Condition();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Special_Condition#getConditionName <em>Condition Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Condition Name</em>'.
	 * @see intelligentMobility.Special_Condition#getConditionName()
	 * @see #getSpecial_Condition()
	 * @generated
	 */
	EAttribute getSpecial_Condition_ConditionName();

	/**
	 * Returns the meta object for the containment reference '{@link intelligentMobility.Special_Condition#getCollision <em>Collision</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Collision</em>'.
	 * @see intelligentMobility.Special_Condition#getCollision()
	 * @see #getSpecial_Condition()
	 * @generated
	 */
	EReference getSpecial_Condition_Collision();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.Special_Condition#getIntersection <em>Intersection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Intersection</em>'.
	 * @see intelligentMobility.Special_Condition#getIntersection()
	 * @see #getSpecial_Condition()
	 * @generated
	 */
	EReference getSpecial_Condition_Intersection();

	/**
	 * Returns the meta object for class '{@link intelligentMobility.Collision <em>Collision</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collision</em>'.
	 * @see intelligentMobility.Collision
	 * @generated
	 */
	EClass getCollision();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Collision#getRecoveryTime <em>Recovery Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Recovery Time</em>'.
	 * @see intelligentMobility.Collision#getRecoveryTime()
	 * @see #getCollision()
	 * @generated
	 */
	EAttribute getCollision_RecoveryTime();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Collision#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see intelligentMobility.Collision#getName()
	 * @see #getCollision()
	 * @generated
	 */
	EAttribute getCollision_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.Collision#getObstructions <em>Obstructions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Obstructions</em>'.
	 * @see intelligentMobility.Collision#getObstructions()
	 * @see #getCollision()
	 * @generated
	 */
	EReference getCollision_Obstructions();

	/**
	 * Returns the meta object for class '{@link intelligentMobility.Intersection <em>Intersection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Intersection</em>'.
	 * @see intelligentMobility.Intersection
	 * @generated
	 */
	EClass getIntersection();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Intersection#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see intelligentMobility.Intersection#getName()
	 * @see #getIntersection()
	 * @generated
	 */
	EAttribute getIntersection_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link intelligentMobility.Intersection#getTraffic_lights <em>Traffic lights</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Traffic lights</em>'.
	 * @see intelligentMobility.Intersection#getTraffic_lights()
	 * @see #getIntersection()
	 * @generated
	 */
	EReference getIntersection_Traffic_lights();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Intersection#getCrossIntersection <em>Cross Intersection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cross Intersection</em>'.
	 * @see intelligentMobility.Intersection#getCrossIntersection()
	 * @see #getIntersection()
	 * @generated
	 */
	EAttribute getIntersection_CrossIntersection();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Intersection#getCrossRailway <em>Cross Railway</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cross Railway</em>'.
	 * @see intelligentMobility.Intersection#getCrossRailway()
	 * @see #getIntersection()
	 * @generated
	 */
	EAttribute getIntersection_CrossRailway();

	/**
	 * Returns the meta object for class '{@link intelligentMobility.Obstruction <em>Obstruction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Obstruction</em>'.
	 * @see intelligentMobility.Obstruction
	 * @generated
	 */
	EClass getObstruction();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Obstruction#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see intelligentMobility.Obstruction#getName()
	 * @see #getObstruction()
	 * @generated
	 */
	EAttribute getObstruction_Name();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Obstruction#getObstacleLocationX <em>Obstacle Location X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Obstacle Location X</em>'.
	 * @see intelligentMobility.Obstruction#getObstacleLocationX()
	 * @see #getObstruction()
	 * @generated
	 */
	EAttribute getObstruction_ObstacleLocationX();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Obstruction#getObstacleLocationY <em>Obstacle Location Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Obstacle Location Y</em>'.
	 * @see intelligentMobility.Obstruction#getObstacleLocationY()
	 * @see #getObstruction()
	 * @generated
	 */
	EAttribute getObstruction_ObstacleLocationY();

	/**
	 * Returns the meta object for class '{@link intelligentMobility.Traffic_Light <em>Traffic Light</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Traffic Light</em>'.
	 * @see intelligentMobility.Traffic_Light
	 * @generated
	 */
	EClass getTraffic_Light();

	/**
	 * Returns the meta object for the reference list '{@link intelligentMobility.Traffic_Light#getEnforces <em>Enforces</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Enforces</em>'.
	 * @see intelligentMobility.Traffic_Light#getEnforces()
	 * @see #getTraffic_Light()
	 * @generated
	 */
	EReference getTraffic_Light_Enforces();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Traffic_Light#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see intelligentMobility.Traffic_Light#getName()
	 * @see #getTraffic_Light()
	 * @generated
	 */
	EAttribute getTraffic_Light_Name();

	/**
	 * Returns the meta object for class '{@link intelligentMobility.ExceptionCondition <em>Exception Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Exception Condition</em>'.
	 * @see intelligentMobility.ExceptionCondition
	 * @generated
	 */
	EClass getExceptionCondition();

	/**
	 * Returns the meta object for class '{@link intelligentMobility.Link_Driver_Environment <em>Link Driver Environment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link Driver Environment</em>'.
	 * @see intelligentMobility.Link_Driver_Environment
	 * @generated
	 */
	EClass getLink_Driver_Environment();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Link_Driver_Environment#getLink_name_driver_environment <em>Link name driver environment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Link name driver environment</em>'.
	 * @see intelligentMobility.Link_Driver_Environment#getLink_name_driver_environment()
	 * @see #getLink_Driver_Environment()
	 * @generated
	 */
	EAttribute getLink_Driver_Environment_Link_name_driver_environment();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Link_Driver_Environment#getLink_driver_profile <em>Link driver profile</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link driver profile</em>'.
	 * @see intelligentMobility.Link_Driver_Environment#getLink_driver_profile()
	 * @see #getLink_Driver_Environment()
	 * @generated
	 */
	EReference getLink_Driver_Environment_Link_driver_profile();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Link_Driver_Environment#getLink_environment_background <em>Link environment background</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link environment background</em>'.
	 * @see intelligentMobility.Link_Driver_Environment#getLink_environment_background()
	 * @see #getLink_Driver_Environment()
	 * @generated
	 */
	EReference getLink_Driver_Environment_Link_environment_background();

	/**
	 * Returns the meta object for class '{@link intelligentMobility.Link_Driver_Vehicle <em>Link Driver Vehicle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link Driver Vehicle</em>'.
	 * @see intelligentMobility.Link_Driver_Vehicle
	 * @generated
	 */
	EClass getLink_Driver_Vehicle();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Link_Driver_Vehicle#getLink_name_driver_vehicle <em>Link name driver vehicle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Link name driver vehicle</em>'.
	 * @see intelligentMobility.Link_Driver_Vehicle#getLink_name_driver_vehicle()
	 * @see #getLink_Driver_Vehicle()
	 * @generated
	 */
	EAttribute getLink_Driver_Vehicle_Link_name_driver_vehicle();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Link_Driver_Vehicle#getLink_driver_profile <em>Link driver profile</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link driver profile</em>'.
	 * @see intelligentMobility.Link_Driver_Vehicle#getLink_driver_profile()
	 * @see #getLink_Driver_Vehicle()
	 * @generated
	 */
	EReference getLink_Driver_Vehicle_Link_driver_profile();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Link_Driver_Vehicle#getLink_vehicle_configuration <em>Link vehicle configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link vehicle configuration</em>'.
	 * @see intelligentMobility.Link_Driver_Vehicle#getLink_vehicle_configuration()
	 * @see #getLink_Driver_Vehicle()
	 * @generated
	 */
	EReference getLink_Driver_Vehicle_Link_vehicle_configuration();

	/**
	 * Returns the meta object for class '{@link intelligentMobility.Link_Vehicle_Environment <em>Link Vehicle Environment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link Vehicle Environment</em>'.
	 * @see intelligentMobility.Link_Vehicle_Environment
	 * @generated
	 */
	EClass getLink_Vehicle_Environment();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Link_Vehicle_Environment#getLink_name_vehicle_environment <em>Link name vehicle environment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Link name vehicle environment</em>'.
	 * @see intelligentMobility.Link_Vehicle_Environment#getLink_name_vehicle_environment()
	 * @see #getLink_Vehicle_Environment()
	 * @generated
	 */
	EAttribute getLink_Vehicle_Environment_Link_name_vehicle_environment();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Link_Vehicle_Environment#getLink_vehicle_configuration <em>Link vehicle configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link vehicle configuration</em>'.
	 * @see intelligentMobility.Link_Vehicle_Environment#getLink_vehicle_configuration()
	 * @see #getLink_Vehicle_Environment()
	 * @generated
	 */
	EReference getLink_Vehicle_Environment_Link_vehicle_configuration();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Link_Vehicle_Environment#getLink_environment_background <em>Link environment background</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link environment background</em>'.
	 * @see intelligentMobility.Link_Vehicle_Environment#getLink_environment_background()
	 * @see #getLink_Vehicle_Environment()
	 * @generated
	 */
	EReference getLink_Vehicle_Environment_Link_environment_background();

	/**
	 * Returns the meta object for class '{@link intelligentMobility.Link_DriverProfile_DriverPreference <em>Link Driver Profile Driver Preference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link Driver Profile Driver Preference</em>'.
	 * @see intelligentMobility.Link_DriverProfile_DriverPreference
	 * @generated
	 */
	EClass getLink_DriverProfile_DriverPreference();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Link_DriverProfile_DriverPreference#getName_link_profile_preference <em>Name link profile preference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name link profile preference</em>'.
	 * @see intelligentMobility.Link_DriverProfile_DriverPreference#getName_link_profile_preference()
	 * @see #getLink_DriverProfile_DriverPreference()
	 * @generated
	 */
	EAttribute getLink_DriverProfile_DriverPreference_Name_link_profile_preference();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Link_DriverProfile_DriverPreference#getLink_driver_profile <em>Link driver profile</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link driver profile</em>'.
	 * @see intelligentMobility.Link_DriverProfile_DriverPreference#getLink_driver_profile()
	 * @see #getLink_DriverProfile_DriverPreference()
	 * @generated
	 */
	EReference getLink_DriverProfile_DriverPreference_Link_driver_profile();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Link_DriverProfile_DriverPreference#getLink_driver_preference <em>Link driver preference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link driver preference</em>'.
	 * @see intelligentMobility.Link_DriverProfile_DriverPreference#getLink_driver_preference()
	 * @see #getLink_DriverProfile_DriverPreference()
	 * @generated
	 */
	EReference getLink_DriverProfile_DriverPreference_Link_driver_preference();

	/**
	 * Returns the meta object for class '{@link intelligentMobility.Link_VehicleConfiguration_VehicleType <em>Link Vehicle Configuration Vehicle Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link Vehicle Configuration Vehicle Type</em>'.
	 * @see intelligentMobility.Link_VehicleConfiguration_VehicleType
	 * @generated
	 */
	EClass getLink_VehicleConfiguration_VehicleType();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Link_VehicleConfiguration_VehicleType#getName_link_configuration_type <em>Name link configuration type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name link configuration type</em>'.
	 * @see intelligentMobility.Link_VehicleConfiguration_VehicleType#getName_link_configuration_type()
	 * @see #getLink_VehicleConfiguration_VehicleType()
	 * @generated
	 */
	EAttribute getLink_VehicleConfiguration_VehicleType_Name_link_configuration_type();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Link_VehicleConfiguration_VehicleType#getLink_vehicle_configuration <em>Link vehicle configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link vehicle configuration</em>'.
	 * @see intelligentMobility.Link_VehicleConfiguration_VehicleType#getLink_vehicle_configuration()
	 * @see #getLink_VehicleConfiguration_VehicleType()
	 * @generated
	 */
	EReference getLink_VehicleConfiguration_VehicleType_Link_vehicle_configuration();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Link_VehicleConfiguration_VehicleType#getLink_vehicle_type <em>Link vehicle type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link vehicle type</em>'.
	 * @see intelligentMobility.Link_VehicleConfiguration_VehicleType#getLink_vehicle_type()
	 * @see #getLink_VehicleConfiguration_VehicleType()
	 * @generated
	 */
	EReference getLink_VehicleConfiguration_VehicleType_Link_vehicle_type();

	/**
	 * Returns the meta object for class '{@link intelligentMobility.Link_EnvironmentBackground_PossibleVehicle <em>Link Environment Background Possible Vehicle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link Environment Background Possible Vehicle</em>'.
	 * @see intelligentMobility.Link_EnvironmentBackground_PossibleVehicle
	 * @generated
	 */
	EClass getLink_EnvironmentBackground_PossibleVehicle();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Link_EnvironmentBackground_PossibleVehicle#getName_link_background_possibleVehicle <em>Name link background possible Vehicle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name link background possible Vehicle</em>'.
	 * @see intelligentMobility.Link_EnvironmentBackground_PossibleVehicle#getName_link_background_possibleVehicle()
	 * @see #getLink_EnvironmentBackground_PossibleVehicle()
	 * @generated
	 */
	EAttribute getLink_EnvironmentBackground_PossibleVehicle_Name_link_background_possibleVehicle();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Link_EnvironmentBackground_PossibleVehicle#getLink_environment_background <em>Link environment background</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link environment background</em>'.
	 * @see intelligentMobility.Link_EnvironmentBackground_PossibleVehicle#getLink_environment_background()
	 * @see #getLink_EnvironmentBackground_PossibleVehicle()
	 * @generated
	 */
	EReference getLink_EnvironmentBackground_PossibleVehicle_Link_environment_background();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Link_EnvironmentBackground_PossibleVehicle#getLink_possible_vehicle <em>Link possible vehicle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link possible vehicle</em>'.
	 * @see intelligentMobility.Link_EnvironmentBackground_PossibleVehicle#getLink_possible_vehicle()
	 * @see #getLink_EnvironmentBackground_PossibleVehicle()
	 * @generated
	 */
	EReference getLink_EnvironmentBackground_PossibleVehicle_Link_possible_vehicle();

	/**
	 * Returns the meta object for class '{@link intelligentMobility.Link_EnvironmentBackground_EnvironmentCondition <em>Link Environment Background Environment Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link Environment Background Environment Condition</em>'.
	 * @see intelligentMobility.Link_EnvironmentBackground_EnvironmentCondition
	 * @generated
	 */
	EClass getLink_EnvironmentBackground_EnvironmentCondition();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Link_EnvironmentBackground_EnvironmentCondition#getName_link_background_condition <em>Name link background condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name link background condition</em>'.
	 * @see intelligentMobility.Link_EnvironmentBackground_EnvironmentCondition#getName_link_background_condition()
	 * @see #getLink_EnvironmentBackground_EnvironmentCondition()
	 * @generated
	 */
	EAttribute getLink_EnvironmentBackground_EnvironmentCondition_Name_link_background_condition();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Link_EnvironmentBackground_EnvironmentCondition#getLink_environment_background <em>Link environment background</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link environment background</em>'.
	 * @see intelligentMobility.Link_EnvironmentBackground_EnvironmentCondition#getLink_environment_background()
	 * @see #getLink_EnvironmentBackground_EnvironmentCondition()
	 * @generated
	 */
	EReference getLink_EnvironmentBackground_EnvironmentCondition_Link_environment_background();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Link_EnvironmentBackground_EnvironmentCondition#getLink_environment_condition <em>Link environment condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link environment condition</em>'.
	 * @see intelligentMobility.Link_EnvironmentBackground_EnvironmentCondition#getLink_environment_condition()
	 * @see #getLink_EnvironmentBackground_EnvironmentCondition()
	 * @generated
	 */
	EReference getLink_EnvironmentBackground_EnvironmentCondition_Link_environment_condition();

	/**
	 * Returns the meta object for class '{@link intelligentMobility.Link_DriverPreference_DriverEmotion <em>Link Driver Preference Driver Emotion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link Driver Preference Driver Emotion</em>'.
	 * @see intelligentMobility.Link_DriverPreference_DriverEmotion
	 * @generated
	 */
	EClass getLink_DriverPreference_DriverEmotion();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Link_DriverPreference_DriverEmotion#getName_link_preference_emotion <em>Name link preference emotion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name link preference emotion</em>'.
	 * @see intelligentMobility.Link_DriverPreference_DriverEmotion#getName_link_preference_emotion()
	 * @see #getLink_DriverPreference_DriverEmotion()
	 * @generated
	 */
	EAttribute getLink_DriverPreference_DriverEmotion_Name_link_preference_emotion();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Link_DriverPreference_DriverEmotion#getLink_driver_preference <em>Link driver preference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link driver preference</em>'.
	 * @see intelligentMobility.Link_DriverPreference_DriverEmotion#getLink_driver_preference()
	 * @see #getLink_DriverPreference_DriverEmotion()
	 * @generated
	 */
	EReference getLink_DriverPreference_DriverEmotion_Link_driver_preference();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Link_DriverPreference_DriverEmotion#getLink_driver_emotion <em>Link driver emotion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link driver emotion</em>'.
	 * @see intelligentMobility.Link_DriverPreference_DriverEmotion#getLink_driver_emotion()
	 * @see #getLink_DriverPreference_DriverEmotion()
	 * @generated
	 */
	EReference getLink_DriverPreference_DriverEmotion_Link_driver_emotion();

	/**
	 * Returns the meta object for class '{@link intelligentMobility.Link_DriverPreference_DrivingBehaviour <em>Link Driver Preference Driving Behaviour</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link Driver Preference Driving Behaviour</em>'.
	 * @see intelligentMobility.Link_DriverPreference_DrivingBehaviour
	 * @generated
	 */
	EClass getLink_DriverPreference_DrivingBehaviour();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Link_DriverPreference_DrivingBehaviour#getName_link_preference_behaviour <em>Name link preference behaviour</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name link preference behaviour</em>'.
	 * @see intelligentMobility.Link_DriverPreference_DrivingBehaviour#getName_link_preference_behaviour()
	 * @see #getLink_DriverPreference_DrivingBehaviour()
	 * @generated
	 */
	EAttribute getLink_DriverPreference_DrivingBehaviour_Name_link_preference_behaviour();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Link_DriverPreference_DrivingBehaviour#getLink_driver_preference <em>Link driver preference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link driver preference</em>'.
	 * @see intelligentMobility.Link_DriverPreference_DrivingBehaviour#getLink_driver_preference()
	 * @see #getLink_DriverPreference_DrivingBehaviour()
	 * @generated
	 */
	EReference getLink_DriverPreference_DrivingBehaviour_Link_driver_preference();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Link_DriverPreference_DrivingBehaviour#getLink_driving_behaviour <em>Link driving behaviour</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link driving behaviour</em>'.
	 * @see intelligentMobility.Link_DriverPreference_DrivingBehaviour#getLink_driving_behaviour()
	 * @see #getLink_DriverPreference_DrivingBehaviour()
	 * @generated
	 */
	EReference getLink_DriverPreference_DrivingBehaviour_Link_driving_behaviour();

	/**
	 * Returns the meta object for class '{@link intelligentMobility.Link_DriverPreference_EnvironmentCondition <em>Link Driver Preference Environment Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link Driver Preference Environment Condition</em>'.
	 * @see intelligentMobility.Link_DriverPreference_EnvironmentCondition
	 * @generated
	 */
	EClass getLink_DriverPreference_EnvironmentCondition();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Link_DriverPreference_EnvironmentCondition#getName_link_preference_condition <em>Name link preference condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name link preference condition</em>'.
	 * @see intelligentMobility.Link_DriverPreference_EnvironmentCondition#getName_link_preference_condition()
	 * @see #getLink_DriverPreference_EnvironmentCondition()
	 * @generated
	 */
	EAttribute getLink_DriverPreference_EnvironmentCondition_Name_link_preference_condition();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Link_DriverPreference_EnvironmentCondition#getLink_driver_preference <em>Link driver preference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link driver preference</em>'.
	 * @see intelligentMobility.Link_DriverPreference_EnvironmentCondition#getLink_driver_preference()
	 * @see #getLink_DriverPreference_EnvironmentCondition()
	 * @generated
	 */
	EReference getLink_DriverPreference_EnvironmentCondition_Link_driver_preference();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Link_DriverPreference_EnvironmentCondition#getLink_environment_condition <em>Link environment condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link environment condition</em>'.
	 * @see intelligentMobility.Link_DriverPreference_EnvironmentCondition#getLink_environment_condition()
	 * @see #getLink_DriverPreference_EnvironmentCondition()
	 * @generated
	 */
	EReference getLink_DriverPreference_EnvironmentCondition_Link_environment_condition();

	/**
	 * Returns the meta object for class '{@link intelligentMobility.Link_DrivingBehaviour_NormalBehaviour <em>Link Driving Behaviour Normal Behaviour</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link Driving Behaviour Normal Behaviour</em>'.
	 * @see intelligentMobility.Link_DrivingBehaviour_NormalBehaviour
	 * @generated
	 */
	EClass getLink_DrivingBehaviour_NormalBehaviour();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Link_DrivingBehaviour_NormalBehaviour#getName_link_driving_normal <em>Name link driving normal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name link driving normal</em>'.
	 * @see intelligentMobility.Link_DrivingBehaviour_NormalBehaviour#getName_link_driving_normal()
	 * @see #getLink_DrivingBehaviour_NormalBehaviour()
	 * @generated
	 */
	EAttribute getLink_DrivingBehaviour_NormalBehaviour_Name_link_driving_normal();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Link_DrivingBehaviour_NormalBehaviour#getLink_driving_behaviour <em>Link driving behaviour</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link driving behaviour</em>'.
	 * @see intelligentMobility.Link_DrivingBehaviour_NormalBehaviour#getLink_driving_behaviour()
	 * @see #getLink_DrivingBehaviour_NormalBehaviour()
	 * @generated
	 */
	EReference getLink_DrivingBehaviour_NormalBehaviour_Link_driving_behaviour();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Link_DrivingBehaviour_NormalBehaviour#getLink_normal_behaviour <em>Link normal behaviour</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link normal behaviour</em>'.
	 * @see intelligentMobility.Link_DrivingBehaviour_NormalBehaviour#getLink_normal_behaviour()
	 * @see #getLink_DrivingBehaviour_NormalBehaviour()
	 * @generated
	 */
	EReference getLink_DrivingBehaviour_NormalBehaviour_Link_normal_behaviour();

	/**
	 * Returns the meta object for class '{@link intelligentMobility.Link_NormalBehaviour_Following <em>Link Normal Behaviour Following</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link Normal Behaviour Following</em>'.
	 * @see intelligentMobility.Link_NormalBehaviour_Following
	 * @generated
	 */
	EClass getLink_NormalBehaviour_Following();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Link_NormalBehaviour_Following#getName_link_behaviour_following <em>Name link behaviour following</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name link behaviour following</em>'.
	 * @see intelligentMobility.Link_NormalBehaviour_Following#getName_link_behaviour_following()
	 * @see #getLink_NormalBehaviour_Following()
	 * @generated
	 */
	EAttribute getLink_NormalBehaviour_Following_Name_link_behaviour_following();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Link_NormalBehaviour_Following#getLink_normal_behaviour <em>Link normal behaviour</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link normal behaviour</em>'.
	 * @see intelligentMobility.Link_NormalBehaviour_Following#getLink_normal_behaviour()
	 * @see #getLink_NormalBehaviour_Following()
	 * @generated
	 */
	EReference getLink_NormalBehaviour_Following_Link_normal_behaviour();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Link_NormalBehaviour_Following#getLink_following <em>Link following</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link following</em>'.
	 * @see intelligentMobility.Link_NormalBehaviour_Following#getLink_following()
	 * @see #getLink_NormalBehaviour_Following()
	 * @generated
	 */
	EReference getLink_NormalBehaviour_Following_Link_following();

	/**
	 * Returns the meta object for class '{@link intelligentMobility.Link_NormalBehaviour_LaneChanging <em>Link Normal Behaviour Lane Changing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link Normal Behaviour Lane Changing</em>'.
	 * @see intelligentMobility.Link_NormalBehaviour_LaneChanging
	 * @generated
	 */
	EClass getLink_NormalBehaviour_LaneChanging();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Link_NormalBehaviour_LaneChanging#getName_link_behaviour_laneChanging <em>Name link behaviour lane Changing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name link behaviour lane Changing</em>'.
	 * @see intelligentMobility.Link_NormalBehaviour_LaneChanging#getName_link_behaviour_laneChanging()
	 * @see #getLink_NormalBehaviour_LaneChanging()
	 * @generated
	 */
	EAttribute getLink_NormalBehaviour_LaneChanging_Name_link_behaviour_laneChanging();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Link_NormalBehaviour_LaneChanging#getLink_normal_behaviour <em>Link normal behaviour</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link normal behaviour</em>'.
	 * @see intelligentMobility.Link_NormalBehaviour_LaneChanging#getLink_normal_behaviour()
	 * @see #getLink_NormalBehaviour_LaneChanging()
	 * @generated
	 */
	EReference getLink_NormalBehaviour_LaneChanging_Link_normal_behaviour();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Link_NormalBehaviour_LaneChanging#getLink_lane_changing <em>Link lane changing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link lane changing</em>'.
	 * @see intelligentMobility.Link_NormalBehaviour_LaneChanging#getLink_lane_changing()
	 * @see #getLink_NormalBehaviour_LaneChanging()
	 * @generated
	 */
	EReference getLink_NormalBehaviour_LaneChanging_Link_lane_changing();

	/**
	 * Returns the meta object for class '{@link intelligentMobility.Link_Following_MinGap <em>Link Following Min Gap</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link Following Min Gap</em>'.
	 * @see intelligentMobility.Link_Following_MinGap
	 * @generated
	 */
	EClass getLink_Following_MinGap();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Link_Following_MinGap#getName_link_following_minGap <em>Name link following min Gap</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name link following min Gap</em>'.
	 * @see intelligentMobility.Link_Following_MinGap#getName_link_following_minGap()
	 * @see #getLink_Following_MinGap()
	 * @generated
	 */
	EAttribute getLink_Following_MinGap_Name_link_following_minGap();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Link_Following_MinGap#getLink_following <em>Link following</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link following</em>'.
	 * @see intelligentMobility.Link_Following_MinGap#getLink_following()
	 * @see #getLink_Following_MinGap()
	 * @generated
	 */
	EReference getLink_Following_MinGap_Link_following();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Link_Following_MinGap#getLink_minGap <em>Link min Gap</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link min Gap</em>'.
	 * @see intelligentMobility.Link_Following_MinGap#getLink_minGap()
	 * @see #getLink_Following_MinGap()
	 * @generated
	 */
	EReference getLink_Following_MinGap_Link_minGap();

	/**
	 * Returns the meta object for class '{@link intelligentMobility.Link_Following_Forward <em>Link Following Forward</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link Following Forward</em>'.
	 * @see intelligentMobility.Link_Following_Forward
	 * @generated
	 */
	EClass getLink_Following_Forward();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Link_Following_Forward#getName_link_following_forward <em>Name link following forward</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name link following forward</em>'.
	 * @see intelligentMobility.Link_Following_Forward#getName_link_following_forward()
	 * @see #getLink_Following_Forward()
	 * @generated
	 */
	EAttribute getLink_Following_Forward_Name_link_following_forward();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Link_Following_Forward#getLink_following <em>Link following</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link following</em>'.
	 * @see intelligentMobility.Link_Following_Forward#getLink_following()
	 * @see #getLink_Following_Forward()
	 * @generated
	 */
	EReference getLink_Following_Forward_Link_following();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Link_Following_Forward#getLink_forward <em>Link forward</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link forward</em>'.
	 * @see intelligentMobility.Link_Following_Forward#getLink_forward()
	 * @see #getLink_Following_Forward()
	 * @generated
	 */
	EReference getLink_Following_Forward_Link_forward();

	/**
	 * Returns the meta object for class '{@link intelligentMobility.Link_Following_Backward <em>Link Following Backward</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link Following Backward</em>'.
	 * @see intelligentMobility.Link_Following_Backward
	 * @generated
	 */
	EClass getLink_Following_Backward();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Link_Following_Backward#getName_link_following_backward <em>Name link following backward</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name link following backward</em>'.
	 * @see intelligentMobility.Link_Following_Backward#getName_link_following_backward()
	 * @see #getLink_Following_Backward()
	 * @generated
	 */
	EAttribute getLink_Following_Backward_Name_link_following_backward();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Link_Following_Backward#getLink_following <em>Link following</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link following</em>'.
	 * @see intelligentMobility.Link_Following_Backward#getLink_following()
	 * @see #getLink_Following_Backward()
	 * @generated
	 */
	EReference getLink_Following_Backward_Link_following();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Link_Following_Backward#getLink_backward <em>Link backward</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link backward</em>'.
	 * @see intelligentMobility.Link_Following_Backward#getLink_backward()
	 * @see #getLink_Following_Backward()
	 * @generated
	 */
	EReference getLink_Following_Backward_Link_backward();

	/**
	 * Returns the meta object for class '{@link intelligentMobility.Link_LaneChanging_Turn <em>Link Lane Changing Turn</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link Lane Changing Turn</em>'.
	 * @see intelligentMobility.Link_LaneChanging_Turn
	 * @generated
	 */
	EClass getLink_LaneChanging_Turn();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Link_LaneChanging_Turn#getName_link_laneChanging_turn <em>Name link lane Changing turn</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name link lane Changing turn</em>'.
	 * @see intelligentMobility.Link_LaneChanging_Turn#getName_link_laneChanging_turn()
	 * @see #getLink_LaneChanging_Turn()
	 * @generated
	 */
	EAttribute getLink_LaneChanging_Turn_Name_link_laneChanging_turn();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Link_LaneChanging_Turn#getLink_laneChanging <em>Link lane Changing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link lane Changing</em>'.
	 * @see intelligentMobility.Link_LaneChanging_Turn#getLink_laneChanging()
	 * @see #getLink_LaneChanging_Turn()
	 * @generated
	 */
	EReference getLink_LaneChanging_Turn_Link_laneChanging();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Link_LaneChanging_Turn#getLink_turn <em>Link turn</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link turn</em>'.
	 * @see intelligentMobility.Link_LaneChanging_Turn#getLink_turn()
	 * @see #getLink_LaneChanging_Turn()
	 * @generated
	 */
	EReference getLink_LaneChanging_Turn_Link_turn();

	/**
	 * Returns the meta object for class '{@link intelligentMobility.Link_LaneChanging_GapAcceptance <em>Link Lane Changing Gap Acceptance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link Lane Changing Gap Acceptance</em>'.
	 * @see intelligentMobility.Link_LaneChanging_GapAcceptance
	 * @generated
	 */
	EClass getLink_LaneChanging_GapAcceptance();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Link_LaneChanging_GapAcceptance#getName_link_laneChanging_gapAcceptane <em>Name link lane Changing gap Acceptane</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name link lane Changing gap Acceptane</em>'.
	 * @see intelligentMobility.Link_LaneChanging_GapAcceptance#getName_link_laneChanging_gapAcceptane()
	 * @see #getLink_LaneChanging_GapAcceptance()
	 * @generated
	 */
	EAttribute getLink_LaneChanging_GapAcceptance_Name_link_laneChanging_gapAcceptane();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Link_LaneChanging_GapAcceptance#getLink_laneChanging <em>Link lane Changing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link lane Changing</em>'.
	 * @see intelligentMobility.Link_LaneChanging_GapAcceptance#getLink_laneChanging()
	 * @see #getLink_LaneChanging_GapAcceptance()
	 * @generated
	 */
	EReference getLink_LaneChanging_GapAcceptance_Link_laneChanging();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Link_LaneChanging_GapAcceptance#getLink_gapAcceptance <em>Link gap Acceptance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link gap Acceptance</em>'.
	 * @see intelligentMobility.Link_LaneChanging_GapAcceptance#getLink_gapAcceptance()
	 * @see #getLink_LaneChanging_GapAcceptance()
	 * @generated
	 */
	EReference getLink_LaneChanging_GapAcceptance_Link_gapAcceptance();

	/**
	 * Returns the meta object for class '{@link intelligentMobility.Link_LaneChanging_EnvironmentCondition <em>Link Lane Changing Environment Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link Lane Changing Environment Condition</em>'.
	 * @see intelligentMobility.Link_LaneChanging_EnvironmentCondition
	 * @generated
	 */
	EClass getLink_LaneChanging_EnvironmentCondition();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Link_LaneChanging_EnvironmentCondition#getName_link_laneChanging_environmentCondition <em>Name link lane Changing environment Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name link lane Changing environment Condition</em>'.
	 * @see intelligentMobility.Link_LaneChanging_EnvironmentCondition#getName_link_laneChanging_environmentCondition()
	 * @see #getLink_LaneChanging_EnvironmentCondition()
	 * @generated
	 */
	EAttribute getLink_LaneChanging_EnvironmentCondition_Name_link_laneChanging_environmentCondition();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Link_LaneChanging_EnvironmentCondition#getLink_laneChanging <em>Link lane Changing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link lane Changing</em>'.
	 * @see intelligentMobility.Link_LaneChanging_EnvironmentCondition#getLink_laneChanging()
	 * @see #getLink_LaneChanging_EnvironmentCondition()
	 * @generated
	 */
	EReference getLink_LaneChanging_EnvironmentCondition_Link_laneChanging();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Link_LaneChanging_EnvironmentCondition#getLink_environmentCondition <em>Link environment Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link environment Condition</em>'.
	 * @see intelligentMobility.Link_LaneChanging_EnvironmentCondition#getLink_environmentCondition()
	 * @see #getLink_LaneChanging_EnvironmentCondition()
	 * @generated
	 */
	EReference getLink_LaneChanging_EnvironmentCondition_Link_environmentCondition();

	/**
	 * Returns the meta object for class '{@link intelligentMobility.Link_AbnormalBehaviour_Action <em>Link Abnormal Behaviour Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link Abnormal Behaviour Action</em>'.
	 * @see intelligentMobility.Link_AbnormalBehaviour_Action
	 * @generated
	 */
	EClass getLink_AbnormalBehaviour_Action();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Link_AbnormalBehaviour_Action#getName_link_abnormalBehaviour_action <em>Name link abnormal Behaviour action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name link abnormal Behaviour action</em>'.
	 * @see intelligentMobility.Link_AbnormalBehaviour_Action#getName_link_abnormalBehaviour_action()
	 * @see #getLink_AbnormalBehaviour_Action()
	 * @generated
	 */
	EAttribute getLink_AbnormalBehaviour_Action_Name_link_abnormalBehaviour_action();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Link_AbnormalBehaviour_Action#getLink_abnormalBehaviour <em>Link abnormal Behaviour</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link abnormal Behaviour</em>'.
	 * @see intelligentMobility.Link_AbnormalBehaviour_Action#getLink_abnormalBehaviour()
	 * @see #getLink_AbnormalBehaviour_Action()
	 * @generated
	 */
	EReference getLink_AbnormalBehaviour_Action_Link_abnormalBehaviour();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Link_AbnormalBehaviour_Action#getLink_action <em>Link action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link action</em>'.
	 * @see intelligentMobility.Link_AbnormalBehaviour_Action#getLink_action()
	 * @see #getLink_AbnormalBehaviour_Action()
	 * @generated
	 */
	EReference getLink_AbnormalBehaviour_Action_Link_action();

	/**
	 * Returns the meta object for class '{@link intelligentMobility.Link_Platoon_LeadingVehicle <em>Link Platoon Leading Vehicle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link Platoon Leading Vehicle</em>'.
	 * @see intelligentMobility.Link_Platoon_LeadingVehicle
	 * @generated
	 */
	EClass getLink_Platoon_LeadingVehicle();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Link_Platoon_LeadingVehicle#getName_link_platoon_leadingVehicle <em>Name link platoon leading Vehicle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name link platoon leading Vehicle</em>'.
	 * @see intelligentMobility.Link_Platoon_LeadingVehicle#getName_link_platoon_leadingVehicle()
	 * @see #getLink_Platoon_LeadingVehicle()
	 * @generated
	 */
	EAttribute getLink_Platoon_LeadingVehicle_Name_link_platoon_leadingVehicle();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Link_Platoon_LeadingVehicle#getLink_platoon <em>Link platoon</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link platoon</em>'.
	 * @see intelligentMobility.Link_Platoon_LeadingVehicle#getLink_platoon()
	 * @see #getLink_Platoon_LeadingVehicle()
	 * @generated
	 */
	EReference getLink_Platoon_LeadingVehicle_Link_platoon();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Link_Platoon_LeadingVehicle#getLink_leadingVehicle <em>Link leading Vehicle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link leading Vehicle</em>'.
	 * @see intelligentMobility.Link_Platoon_LeadingVehicle#getLink_leadingVehicle()
	 * @see #getLink_Platoon_LeadingVehicle()
	 * @generated
	 */
	EReference getLink_Platoon_LeadingVehicle_Link_leadingVehicle();

	/**
	 * Returns the meta object for class '{@link intelligentMobility.Link_Platoon_FollowingVehicle <em>Link Platoon Following Vehicle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link Platoon Following Vehicle</em>'.
	 * @see intelligentMobility.Link_Platoon_FollowingVehicle
	 * @generated
	 */
	EClass getLink_Platoon_FollowingVehicle();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Link_Platoon_FollowingVehicle#getName_link_platoon_followingVehicle <em>Name link platoon following Vehicle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name link platoon following Vehicle</em>'.
	 * @see intelligentMobility.Link_Platoon_FollowingVehicle#getName_link_platoon_followingVehicle()
	 * @see #getLink_Platoon_FollowingVehicle()
	 * @generated
	 */
	EAttribute getLink_Platoon_FollowingVehicle_Name_link_platoon_followingVehicle();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Link_Platoon_FollowingVehicle#getLink_platoon <em>Link platoon</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link platoon</em>'.
	 * @see intelligentMobility.Link_Platoon_FollowingVehicle#getLink_platoon()
	 * @see #getLink_Platoon_FollowingVehicle()
	 * @generated
	 */
	EReference getLink_Platoon_FollowingVehicle_Link_platoon();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Link_Platoon_FollowingVehicle#getLink_followingVehicle <em>Link following Vehicle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link following Vehicle</em>'.
	 * @see intelligentMobility.Link_Platoon_FollowingVehicle#getLink_followingVehicle()
	 * @see #getLink_Platoon_FollowingVehicle()
	 * @generated
	 */
	EReference getLink_Platoon_FollowingVehicle_Link_followingVehicle();

	/**
	 * Returns the meta object for class '{@link intelligentMobility.Link_NormalVehicle_SafetyRequirements <em>Link Normal Vehicle Safety Requirements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link Normal Vehicle Safety Requirements</em>'.
	 * @see intelligentMobility.Link_NormalVehicle_SafetyRequirements
	 * @generated
	 */
	EClass getLink_NormalVehicle_SafetyRequirements();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Link_NormalVehicle_SafetyRequirements#getName_link_normalVehicle_safetyRequirement <em>Name link normal Vehicle safety Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name link normal Vehicle safety Requirement</em>'.
	 * @see intelligentMobility.Link_NormalVehicle_SafetyRequirements#getName_link_normalVehicle_safetyRequirement()
	 * @see #getLink_NormalVehicle_SafetyRequirements()
	 * @generated
	 */
	EAttribute getLink_NormalVehicle_SafetyRequirements_Name_link_normalVehicle_safetyRequirement();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Link_NormalVehicle_SafetyRequirements#getLink_normalVehicle <em>Link normal Vehicle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link normal Vehicle</em>'.
	 * @see intelligentMobility.Link_NormalVehicle_SafetyRequirements#getLink_normalVehicle()
	 * @see #getLink_NormalVehicle_SafetyRequirements()
	 * @generated
	 */
	EReference getLink_NormalVehicle_SafetyRequirements_Link_normalVehicle();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Link_NormalVehicle_SafetyRequirements#getLink_safetyRequirement <em>Link safety Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link safety Requirement</em>'.
	 * @see intelligentMobility.Link_NormalVehicle_SafetyRequirements#getLink_safetyRequirement()
	 * @see #getLink_NormalVehicle_SafetyRequirements()
	 * @generated
	 */
	EReference getLink_NormalVehicle_SafetyRequirements_Link_safetyRequirement();

	/**
	 * Returns the meta object for class '{@link intelligentMobility.Link_FollowingVehicle_FrontVehicle <em>Link Following Vehicle Front Vehicle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link Following Vehicle Front Vehicle</em>'.
	 * @see intelligentMobility.Link_FollowingVehicle_FrontVehicle
	 * @generated
	 */
	EClass getLink_FollowingVehicle_FrontVehicle();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Link_FollowingVehicle_FrontVehicle#getName_link_followingVehicle_frontVehicle <em>Name link following Vehicle front Vehicle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name link following Vehicle front Vehicle</em>'.
	 * @see intelligentMobility.Link_FollowingVehicle_FrontVehicle#getName_link_followingVehicle_frontVehicle()
	 * @see #getLink_FollowingVehicle_FrontVehicle()
	 * @generated
	 */
	EAttribute getLink_FollowingVehicle_FrontVehicle_Name_link_followingVehicle_frontVehicle();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Link_FollowingVehicle_FrontVehicle#getLink_followingVehicle <em>Link following Vehicle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link following Vehicle</em>'.
	 * @see intelligentMobility.Link_FollowingVehicle_FrontVehicle#getLink_followingVehicle()
	 * @see #getLink_FollowingVehicle_FrontVehicle()
	 * @generated
	 */
	EReference getLink_FollowingVehicle_FrontVehicle_Link_followingVehicle();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Link_FollowingVehicle_FrontVehicle#getLink_frontVehicle <em>Link front Vehicle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link front Vehicle</em>'.
	 * @see intelligentMobility.Link_FollowingVehicle_FrontVehicle#getLink_frontVehicle()
	 * @see #getLink_FollowingVehicle_FrontVehicle()
	 * @generated
	 */
	EReference getLink_FollowingVehicle_FrontVehicle_Link_frontVehicle();

	/**
	 * Returns the meta object for class '{@link intelligentMobility.Link_EnvironmentCondition_LaneType <em>Link Environment Condition Lane Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link Environment Condition Lane Type</em>'.
	 * @see intelligentMobility.Link_EnvironmentCondition_LaneType
	 * @generated
	 */
	EClass getLink_EnvironmentCondition_LaneType();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Link_EnvironmentCondition_LaneType#getName_link_environmentCondition_laneType <em>Name link environment Condition lane Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name link environment Condition lane Type</em>'.
	 * @see intelligentMobility.Link_EnvironmentCondition_LaneType#getName_link_environmentCondition_laneType()
	 * @see #getLink_EnvironmentCondition_LaneType()
	 * @generated
	 */
	EAttribute getLink_EnvironmentCondition_LaneType_Name_link_environmentCondition_laneType();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Link_EnvironmentCondition_LaneType#getLink_environmentCondition <em>Link environment Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link environment Condition</em>'.
	 * @see intelligentMobility.Link_EnvironmentCondition_LaneType#getLink_environmentCondition()
	 * @see #getLink_EnvironmentCondition_LaneType()
	 * @generated
	 */
	EReference getLink_EnvironmentCondition_LaneType_Link_environmentCondition();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Link_EnvironmentCondition_LaneType#getLink_laneType <em>Link lane Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link lane Type</em>'.
	 * @see intelligentMobility.Link_EnvironmentCondition_LaneType#getLink_laneType()
	 * @see #getLink_EnvironmentCondition_LaneType()
	 * @generated
	 */
	EReference getLink_EnvironmentCondition_LaneType_Link_laneType();

	/**
	 * Returns the meta object for class '{@link intelligentMobility.Link_EnvironmentCondition_Regulations <em>Link Environment Condition Regulations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link Environment Condition Regulations</em>'.
	 * @see intelligentMobility.Link_EnvironmentCondition_Regulations
	 * @generated
	 */
	EClass getLink_EnvironmentCondition_Regulations();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Link_EnvironmentCondition_Regulations#getName_link_environmentCondition_regulation <em>Name link environment Condition regulation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name link environment Condition regulation</em>'.
	 * @see intelligentMobility.Link_EnvironmentCondition_Regulations#getName_link_environmentCondition_regulation()
	 * @see #getLink_EnvironmentCondition_Regulations()
	 * @generated
	 */
	EAttribute getLink_EnvironmentCondition_Regulations_Name_link_environmentCondition_regulation();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Link_EnvironmentCondition_Regulations#getLink_environmentCondition <em>Link environment Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link environment Condition</em>'.
	 * @see intelligentMobility.Link_EnvironmentCondition_Regulations#getLink_environmentCondition()
	 * @see #getLink_EnvironmentCondition_Regulations()
	 * @generated
	 */
	EReference getLink_EnvironmentCondition_Regulations_Link_environmentCondition();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Link_EnvironmentCondition_Regulations#getLink_regulation <em>Link regulation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link regulation</em>'.
	 * @see intelligentMobility.Link_EnvironmentCondition_Regulations#getLink_regulation()
	 * @see #getLink_EnvironmentCondition_Regulations()
	 * @generated
	 */
	EReference getLink_EnvironmentCondition_Regulations_Link_regulation();

	/**
	 * Returns the meta object for class '{@link intelligentMobility.Link_EnvironmentCondition_Weather <em>Link Environment Condition Weather</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link Environment Condition Weather</em>'.
	 * @see intelligentMobility.Link_EnvironmentCondition_Weather
	 * @generated
	 */
	EClass getLink_EnvironmentCondition_Weather();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Link_EnvironmentCondition_Weather#getName_link_environmentCondition_weather <em>Name link environment Condition weather</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name link environment Condition weather</em>'.
	 * @see intelligentMobility.Link_EnvironmentCondition_Weather#getName_link_environmentCondition_weather()
	 * @see #getLink_EnvironmentCondition_Weather()
	 * @generated
	 */
	EAttribute getLink_EnvironmentCondition_Weather_Name_link_environmentCondition_weather();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Link_EnvironmentCondition_Weather#getLink_environmentCondition <em>Link environment Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link environment Condition</em>'.
	 * @see intelligentMobility.Link_EnvironmentCondition_Weather#getLink_environmentCondition()
	 * @see #getLink_EnvironmentCondition_Weather()
	 * @generated
	 */
	EReference getLink_EnvironmentCondition_Weather_Link_environmentCondition();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Link_EnvironmentCondition_Weather#getLink_weather <em>Link weather</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link weather</em>'.
	 * @see intelligentMobility.Link_EnvironmentCondition_Weather#getLink_weather()
	 * @see #getLink_EnvironmentCondition_Weather()
	 * @generated
	 */
	EReference getLink_EnvironmentCondition_Weather_Link_weather();

	/**
	 * Returns the meta object for class '{@link intelligentMobility.Link_EnvironmentCondition_TrafficCondition <em>Link Environment Condition Traffic Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link Environment Condition Traffic Condition</em>'.
	 * @see intelligentMobility.Link_EnvironmentCondition_TrafficCondition
	 * @generated
	 */
	EClass getLink_EnvironmentCondition_TrafficCondition();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Link_EnvironmentCondition_TrafficCondition#getName_link_environmentCondition_trafficCondition <em>Name link environment Condition traffic Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name link environment Condition traffic Condition</em>'.
	 * @see intelligentMobility.Link_EnvironmentCondition_TrafficCondition#getName_link_environmentCondition_trafficCondition()
	 * @see #getLink_EnvironmentCondition_TrafficCondition()
	 * @generated
	 */
	EAttribute getLink_EnvironmentCondition_TrafficCondition_Name_link_environmentCondition_trafficCondition();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Link_EnvironmentCondition_TrafficCondition#getLink_environmentCondition <em>Link environment Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link environment Condition</em>'.
	 * @see intelligentMobility.Link_EnvironmentCondition_TrafficCondition#getLink_environmentCondition()
	 * @see #getLink_EnvironmentCondition_TrafficCondition()
	 * @generated
	 */
	EReference getLink_EnvironmentCondition_TrafficCondition_Link_environmentCondition();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Link_EnvironmentCondition_TrafficCondition#getLink_trafficCondition <em>Link traffic Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link traffic Condition</em>'.
	 * @see intelligentMobility.Link_EnvironmentCondition_TrafficCondition#getLink_trafficCondition()
	 * @see #getLink_EnvironmentCondition_TrafficCondition()
	 * @generated
	 */
	EReference getLink_EnvironmentCondition_TrafficCondition_Link_trafficCondition();

	/**
	 * Returns the meta object for class '{@link intelligentMobility.Link_EnvironmentCondition_SpecialCondition <em>Link Environment Condition Special Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link Environment Condition Special Condition</em>'.
	 * @see intelligentMobility.Link_EnvironmentCondition_SpecialCondition
	 * @generated
	 */
	EClass getLink_EnvironmentCondition_SpecialCondition();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Link_EnvironmentCondition_SpecialCondition#getName_link_environmentCondition_specialCondition <em>Name link environment Condition special Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name link environment Condition special Condition</em>'.
	 * @see intelligentMobility.Link_EnvironmentCondition_SpecialCondition#getName_link_environmentCondition_specialCondition()
	 * @see #getLink_EnvironmentCondition_SpecialCondition()
	 * @generated
	 */
	EAttribute getLink_EnvironmentCondition_SpecialCondition_Name_link_environmentCondition_specialCondition();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Link_EnvironmentCondition_SpecialCondition#getLink_environmentCondition <em>Link environment Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link environment Condition</em>'.
	 * @see intelligentMobility.Link_EnvironmentCondition_SpecialCondition#getLink_environmentCondition()
	 * @see #getLink_EnvironmentCondition_SpecialCondition()
	 * @generated
	 */
	EReference getLink_EnvironmentCondition_SpecialCondition_Link_environmentCondition();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Link_EnvironmentCondition_SpecialCondition#getLink_specialCondition <em>Link special Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link special Condition</em>'.
	 * @see intelligentMobility.Link_EnvironmentCondition_SpecialCondition#getLink_specialCondition()
	 * @see #getLink_EnvironmentCondition_SpecialCondition()
	 * @generated
	 */
	EReference getLink_EnvironmentCondition_SpecialCondition_Link_specialCondition();

	/**
	 * Returns the meta object for class '{@link intelligentMobility.Link_LaneType_Regulation <em>Link Lane Type Regulation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link Lane Type Regulation</em>'.
	 * @see intelligentMobility.Link_LaneType_Regulation
	 * @generated
	 */
	EClass getLink_LaneType_Regulation();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Link_LaneType_Regulation#getName_link_laneType_regulation <em>Name link lane Type regulation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name link lane Type regulation</em>'.
	 * @see intelligentMobility.Link_LaneType_Regulation#getName_link_laneType_regulation()
	 * @see #getLink_LaneType_Regulation()
	 * @generated
	 */
	EAttribute getLink_LaneType_Regulation_Name_link_laneType_regulation();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Link_LaneType_Regulation#getLink_laneType <em>Link lane Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link lane Type</em>'.
	 * @see intelligentMobility.Link_LaneType_Regulation#getLink_laneType()
	 * @see #getLink_LaneType_Regulation()
	 * @generated
	 */
	EReference getLink_LaneType_Regulation_Link_laneType();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Link_LaneType_Regulation#getLink_regulation <em>Link regulation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link regulation</em>'.
	 * @see intelligentMobility.Link_LaneType_Regulation#getLink_regulation()
	 * @see #getLink_LaneType_Regulation()
	 * @generated
	 */
	EReference getLink_LaneType_Regulation_Link_regulation();

	/**
	 * Returns the meta object for class '{@link intelligentMobility.Link_SafetyRequirement_Regulation <em>Link Safety Requirement Regulation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link Safety Requirement Regulation</em>'.
	 * @see intelligentMobility.Link_SafetyRequirement_Regulation
	 * @generated
	 */
	EClass getLink_SafetyRequirement_Regulation();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Link_SafetyRequirement_Regulation#getName_link_safetyRequirement_regulation <em>Name link safety Requirement regulation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name link safety Requirement regulation</em>'.
	 * @see intelligentMobility.Link_SafetyRequirement_Regulation#getName_link_safetyRequirement_regulation()
	 * @see #getLink_SafetyRequirement_Regulation()
	 * @generated
	 */
	EAttribute getLink_SafetyRequirement_Regulation_Name_link_safetyRequirement_regulation();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Link_SafetyRequirement_Regulation#getLink_safetyRequirement <em>Link safety Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link safety Requirement</em>'.
	 * @see intelligentMobility.Link_SafetyRequirement_Regulation#getLink_safetyRequirement()
	 * @see #getLink_SafetyRequirement_Regulation()
	 * @generated
	 */
	EReference getLink_SafetyRequirement_Regulation_Link_safetyRequirement();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Link_SafetyRequirement_Regulation#getLink_regulation <em>Link regulation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link regulation</em>'.
	 * @see intelligentMobility.Link_SafetyRequirement_Regulation#getLink_regulation()
	 * @see #getLink_SafetyRequirement_Regulation()
	 * @generated
	 */
	EReference getLink_SafetyRequirement_Regulation_Link_regulation();

	/**
	 * Returns the meta object for class '{@link intelligentMobility.Link_SpecialCondition_Intersection <em>Link Special Condition Intersection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link Special Condition Intersection</em>'.
	 * @see intelligentMobility.Link_SpecialCondition_Intersection
	 * @generated
	 */
	EClass getLink_SpecialCondition_Intersection();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Link_SpecialCondition_Intersection#getName_link_specialCondition_intersection <em>Name link special Condition intersection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name link special Condition intersection</em>'.
	 * @see intelligentMobility.Link_SpecialCondition_Intersection#getName_link_specialCondition_intersection()
	 * @see #getLink_SpecialCondition_Intersection()
	 * @generated
	 */
	EAttribute getLink_SpecialCondition_Intersection_Name_link_specialCondition_intersection();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Link_SpecialCondition_Intersection#getLink_specialCondition <em>Link special Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link special Condition</em>'.
	 * @see intelligentMobility.Link_SpecialCondition_Intersection#getLink_specialCondition()
	 * @see #getLink_SpecialCondition_Intersection()
	 * @generated
	 */
	EReference getLink_SpecialCondition_Intersection_Link_specialCondition();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Link_SpecialCondition_Intersection#getLink_intersection <em>Link intersection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link intersection</em>'.
	 * @see intelligentMobility.Link_SpecialCondition_Intersection#getLink_intersection()
	 * @see #getLink_SpecialCondition_Intersection()
	 * @generated
	 */
	EReference getLink_SpecialCondition_Intersection_Link_intersection();

	/**
	 * Returns the meta object for class '{@link intelligentMobility.Link_Collision_Obstruction <em>Link Collision Obstruction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link Collision Obstruction</em>'.
	 * @see intelligentMobility.Link_Collision_Obstruction
	 * @generated
	 */
	EClass getLink_Collision_Obstruction();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Link_Collision_Obstruction#getName_link_collision_obstruction <em>Name link collision obstruction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name link collision obstruction</em>'.
	 * @see intelligentMobility.Link_Collision_Obstruction#getName_link_collision_obstruction()
	 * @see #getLink_Collision_Obstruction()
	 * @generated
	 */
	EAttribute getLink_Collision_Obstruction_Name_link_collision_obstruction();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Link_Collision_Obstruction#getLink_collision <em>Link collision</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link collision</em>'.
	 * @see intelligentMobility.Link_Collision_Obstruction#getLink_collision()
	 * @see #getLink_Collision_Obstruction()
	 * @generated
	 */
	EReference getLink_Collision_Obstruction_Link_collision();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Link_Collision_Obstruction#getLink_obstruction <em>Link obstruction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link obstruction</em>'.
	 * @see intelligentMobility.Link_Collision_Obstruction#getLink_obstruction()
	 * @see #getLink_Collision_Obstruction()
	 * @generated
	 */
	EReference getLink_Collision_Obstruction_Link_obstruction();

	/**
	 * Returns the meta object for class '{@link intelligentMobility.Link_Intersection_TrafficLight <em>Link Intersection Traffic Light</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link Intersection Traffic Light</em>'.
	 * @see intelligentMobility.Link_Intersection_TrafficLight
	 * @generated
	 */
	EClass getLink_Intersection_TrafficLight();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Link_Intersection_TrafficLight#getName_link_intersection_trafficLight <em>Name link intersection traffic Light</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name link intersection traffic Light</em>'.
	 * @see intelligentMobility.Link_Intersection_TrafficLight#getName_link_intersection_trafficLight()
	 * @see #getLink_Intersection_TrafficLight()
	 * @generated
	 */
	EAttribute getLink_Intersection_TrafficLight_Name_link_intersection_trafficLight();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Link_Intersection_TrafficLight#getLink_intersection <em>Link intersection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link intersection</em>'.
	 * @see intelligentMobility.Link_Intersection_TrafficLight#getLink_intersection()
	 * @see #getLink_Intersection_TrafficLight()
	 * @generated
	 */
	EReference getLink_Intersection_TrafficLight_Link_intersection();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Link_Intersection_TrafficLight#getLink_trafficLight <em>Link traffic Light</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link traffic Light</em>'.
	 * @see intelligentMobility.Link_Intersection_TrafficLight#getLink_trafficLight()
	 * @see #getLink_Intersection_TrafficLight()
	 * @generated
	 */
	EReference getLink_Intersection_TrafficLight_Link_trafficLight();

	/**
	 * Returns the meta object for class '{@link intelligentMobility.Infrastructure <em>Infrastructure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Infrastructure</em>'.
	 * @see intelligentMobility.Infrastructure
	 * @generated
	 */
	EClass getInfrastructure();

	/**
	 * Returns the meta object for the reference list '{@link intelligentMobility.Infrastructure#getCommunicatesWith <em>Communicates With</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Communicates With</em>'.
	 * @see intelligentMobility.Infrastructure#getCommunicatesWith()
	 * @see #getInfrastructure()
	 * @generated
	 */
	EReference getInfrastructure_CommunicatesWith();

	/**
	 * Returns the meta object for class '{@link intelligentMobility.RoadSegment <em>Road Segment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Road Segment</em>'.
	 * @see intelligentMobility.RoadSegment
	 * @generated
	 */
	EClass getRoadSegment();

	/**
	 * Returns the meta object for class '{@link intelligentMobility.SmartSensor <em>Smart Sensor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Smart Sensor</em>'.
	 * @see intelligentMobility.SmartSensor
	 * @generated
	 */
	EClass getSmartSensor();

	/**
	 * Returns the meta object for the reference list '{@link intelligentMobility.SmartSensor#getMonitors <em>Monitors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Monitors</em>'.
	 * @see intelligentMobility.SmartSensor#getMonitors()
	 * @see #getSmartSensor()
	 * @generated
	 */
	EReference getSmartSensor_Monitors();

	/**
	 * Returns the meta object for class '{@link intelligentMobility.Road_Side_Unit <em>Road Side Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Road Side Unit</em>'.
	 * @see intelligentMobility.Road_Side_Unit
	 * @generated
	 */
	EClass getRoad_Side_Unit();

	/**
	 * Returns the meta object for class '{@link intelligentMobility.ChargingStation <em>Charging Station</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Charging Station</em>'.
	 * @see intelligentMobility.ChargingStation
	 * @generated
	 */
	EClass getChargingStation();

	/**
	 * Returns the meta object for class '{@link intelligentMobility.CommunicationInterface <em>Communication Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Communication Interface</em>'.
	 * @see intelligentMobility.CommunicationInterface
	 * @generated
	 */
	EClass getCommunicationInterface();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.CommunicationInterface#getProtocol <em>Protocol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Protocol</em>'.
	 * @see intelligentMobility.CommunicationInterface#getProtocol()
	 * @see #getCommunicationInterface()
	 * @generated
	 */
	EAttribute getCommunicationInterface_Protocol();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.CommunicationInterface#getLatency <em>Latency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Latency</em>'.
	 * @see intelligentMobility.CommunicationInterface#getLatency()
	 * @see #getCommunicationInterface()
	 * @generated
	 */
	EAttribute getCommunicationInterface_Latency();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.CommunicationInterface#getBandwidth <em>Bandwidth</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bandwidth</em>'.
	 * @see intelligentMobility.CommunicationInterface#getBandwidth()
	 * @see #getCommunicationInterface()
	 * @generated
	 */
	EAttribute getCommunicationInterface_Bandwidth();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.CommunicationInterface#getReliabilityLevel <em>Reliability Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Reliability Level</em>'.
	 * @see intelligentMobility.CommunicationInterface#getReliabilityLevel()
	 * @see #getCommunicationInterface()
	 * @generated
	 */
	EAttribute getCommunicationInterface_ReliabilityLevel();

	/**
	 * Returns the meta object for the reference list '{@link intelligentMobility.CommunicationInterface#getConnects_vehicle <em>Connects vehicle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Connects vehicle</em>'.
	 * @see intelligentMobility.CommunicationInterface#getConnects_vehicle()
	 * @see #getCommunicationInterface()
	 * @generated
	 */
	EReference getCommunicationInterface_Connects_vehicle();

	/**
	 * Returns the meta object for the reference list '{@link intelligentMobility.CommunicationInterface#getConnects_infrastructure <em>Connects infrastructure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Connects infrastructure</em>'.
	 * @see intelligentMobility.CommunicationInterface#getConnects_infrastructure()
	 * @see #getCommunicationInterface()
	 * @generated
	 */
	EReference getCommunicationInterface_Connects_infrastructure();

	/**
	 * Returns the meta object for class '{@link intelligentMobility.CooperativeBehavior <em>Cooperative Behavior</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cooperative Behavior</em>'.
	 * @see intelligentMobility.CooperativeBehavior
	 * @generated
	 */
	EClass getCooperativeBehavior();

	/**
	 * Returns the meta object for the reference list '{@link intelligentMobility.CooperativeBehavior#getDependsOn <em>Depends On</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Depends On</em>'.
	 * @see intelligentMobility.CooperativeBehavior#getDependsOn()
	 * @see #getCooperativeBehavior()
	 * @generated
	 */
	EReference getCooperativeBehavior_DependsOn();

	/**
	 * Returns the meta object for the reference list '{@link intelligentMobility.CooperativeBehavior#getCoordinatedWith <em>Coordinated With</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Coordinated With</em>'.
	 * @see intelligentMobility.CooperativeBehavior#getCoordinatedWith()
	 * @see #getCooperativeBehavior()
	 * @generated
	 */
	EReference getCooperativeBehavior_CoordinatedWith();

	/**
	 * Returns the meta object for class '{@link intelligentMobility.Goal <em>Goal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Goal</em>'.
	 * @see intelligentMobility.Goal
	 * @generated
	 */
	EClass getGoal();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Goal#getGoalType <em>Goal Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Goal Type</em>'.
	 * @see intelligentMobility.Goal#getGoalType()
	 * @see #getGoal()
	 * @generated
	 */
	EAttribute getGoal_GoalType();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Goal#getPriority <em>Priority</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Priority</em>'.
	 * @see intelligentMobility.Goal#getPriority()
	 * @see #getGoal()
	 * @generated
	 */
	EAttribute getGoal_Priority();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Goal#isIsGoalDriven <em>Is Goal Driven</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Goal Driven</em>'.
	 * @see intelligentMobility.Goal#isIsGoalDriven()
	 * @see #getGoal()
	 * @generated
	 */
	EAttribute getGoal_IsGoalDriven();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Goal#isIsStimulusDriven <em>Is Stimulus Driven</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Stimulus Driven</em>'.
	 * @see intelligentMobility.Goal#isIsStimulusDriven()
	 * @see #getGoal()
	 * @generated
	 */
	EAttribute getGoal_IsStimulusDriven();

	/**
	 * Returns the meta object for class '{@link intelligentMobility.Link_Infrastructure_VehicleConfiguration <em>Link Infrastructure Vehicle Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link Infrastructure Vehicle Configuration</em>'.
	 * @see intelligentMobility.Link_Infrastructure_VehicleConfiguration
	 * @generated
	 */
	EClass getLink_Infrastructure_VehicleConfiguration();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Link_Infrastructure_VehicleConfiguration#getName_link_infrastructure_vehicleConfiguration <em>Name link infrastructure vehicle Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name link infrastructure vehicle Configuration</em>'.
	 * @see intelligentMobility.Link_Infrastructure_VehicleConfiguration#getName_link_infrastructure_vehicleConfiguration()
	 * @see #getLink_Infrastructure_VehicleConfiguration()
	 * @generated
	 */
	EAttribute getLink_Infrastructure_VehicleConfiguration_Name_link_infrastructure_vehicleConfiguration();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Link_Infrastructure_VehicleConfiguration#getLink_infrastructure <em>Link infrastructure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link infrastructure</em>'.
	 * @see intelligentMobility.Link_Infrastructure_VehicleConfiguration#getLink_infrastructure()
	 * @see #getLink_Infrastructure_VehicleConfiguration()
	 * @generated
	 */
	EReference getLink_Infrastructure_VehicleConfiguration_Link_infrastructure();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Link_Infrastructure_VehicleConfiguration#getLink_vehicle_configuration <em>Link vehicle configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link vehicle configuration</em>'.
	 * @see intelligentMobility.Link_Infrastructure_VehicleConfiguration#getLink_vehicle_configuration()
	 * @see #getLink_Infrastructure_VehicleConfiguration()
	 * @generated
	 */
	EReference getLink_Infrastructure_VehicleConfiguration_Link_vehicle_configuration();

	/**
	 * Returns the meta object for class '{@link intelligentMobility.Link_CommunicationInterface_VehicleConfiguration <em>Link Communication Interface Vehicle Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link Communication Interface Vehicle Configuration</em>'.
	 * @see intelligentMobility.Link_CommunicationInterface_VehicleConfiguration
	 * @generated
	 */
	EClass getLink_CommunicationInterface_VehicleConfiguration();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Link_CommunicationInterface_VehicleConfiguration#getName_link_communication_interface_vehicleConfiguration <em>Name link communication interface vehicle Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name link communication interface vehicle Configuration</em>'.
	 * @see intelligentMobility.Link_CommunicationInterface_VehicleConfiguration#getName_link_communication_interface_vehicleConfiguration()
	 * @see #getLink_CommunicationInterface_VehicleConfiguration()
	 * @generated
	 */
	EAttribute getLink_CommunicationInterface_VehicleConfiguration_Name_link_communication_interface_vehicleConfiguration();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Link_CommunicationInterface_VehicleConfiguration#getLink_communication_interface <em>Link communication interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link communication interface</em>'.
	 * @see intelligentMobility.Link_CommunicationInterface_VehicleConfiguration#getLink_communication_interface()
	 * @see #getLink_CommunicationInterface_VehicleConfiguration()
	 * @generated
	 */
	EReference getLink_CommunicationInterface_VehicleConfiguration_Link_communication_interface();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Link_CommunicationInterface_VehicleConfiguration#getLink_vehicle_configuration <em>Link vehicle configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link vehicle configuration</em>'.
	 * @see intelligentMobility.Link_CommunicationInterface_VehicleConfiguration#getLink_vehicle_configuration()
	 * @see #getLink_CommunicationInterface_VehicleConfiguration()
	 * @generated
	 */
	EReference getLink_CommunicationInterface_VehicleConfiguration_Link_vehicle_configuration();

	/**
	 * Returns the meta object for class '{@link intelligentMobility.Link_Goal_DrivingBehaviour <em>Link Goal Driving Behaviour</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link Goal Driving Behaviour</em>'.
	 * @see intelligentMobility.Link_Goal_DrivingBehaviour
	 * @generated
	 */
	EClass getLink_Goal_DrivingBehaviour();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Link_Goal_DrivingBehaviour#getName_link_goal_drivingBehaviour <em>Name link goal driving Behaviour</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name link goal driving Behaviour</em>'.
	 * @see intelligentMobility.Link_Goal_DrivingBehaviour#getName_link_goal_drivingBehaviour()
	 * @see #getLink_Goal_DrivingBehaviour()
	 * @generated
	 */
	EAttribute getLink_Goal_DrivingBehaviour_Name_link_goal_drivingBehaviour();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Link_Goal_DrivingBehaviour#getLink_goal <em>Link goal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link goal</em>'.
	 * @see intelligentMobility.Link_Goal_DrivingBehaviour#getLink_goal()
	 * @see #getLink_Goal_DrivingBehaviour()
	 * @generated
	 */
	EReference getLink_Goal_DrivingBehaviour_Link_goal();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Link_Goal_DrivingBehaviour#getLink_drivingBehaviour <em>Link driving Behaviour</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link driving Behaviour</em>'.
	 * @see intelligentMobility.Link_Goal_DrivingBehaviour#getLink_drivingBehaviour()
	 * @see #getLink_Goal_DrivingBehaviour()
	 * @generated
	 */
	EReference getLink_Goal_DrivingBehaviour_Link_drivingBehaviour();

	/**
	 * Returns the meta object for class '{@link intelligentMobility.Link_CooperativeBehaviour_CommunicationInterface <em>Link Cooperative Behaviour Communication Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link Cooperative Behaviour Communication Interface</em>'.
	 * @see intelligentMobility.Link_CooperativeBehaviour_CommunicationInterface
	 * @generated
	 */
	EClass getLink_CooperativeBehaviour_CommunicationInterface();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Link_CooperativeBehaviour_CommunicationInterface#getName_link_cooperativeBehaviour_communicationInterface <em>Name link cooperative Behaviour communication Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name link cooperative Behaviour communication Interface</em>'.
	 * @see intelligentMobility.Link_CooperativeBehaviour_CommunicationInterface#getName_link_cooperativeBehaviour_communicationInterface()
	 * @see #getLink_CooperativeBehaviour_CommunicationInterface()
	 * @generated
	 */
	EAttribute getLink_CooperativeBehaviour_CommunicationInterface_Name_link_cooperativeBehaviour_communicationInterface();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Link_CooperativeBehaviour_CommunicationInterface#getLink_cooperativeBehaviour <em>Link cooperative Behaviour</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link cooperative Behaviour</em>'.
	 * @see intelligentMobility.Link_CooperativeBehaviour_CommunicationInterface#getLink_cooperativeBehaviour()
	 * @see #getLink_CooperativeBehaviour_CommunicationInterface()
	 * @generated
	 */
	EReference getLink_CooperativeBehaviour_CommunicationInterface_Link_cooperativeBehaviour();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Link_CooperativeBehaviour_CommunicationInterface#getLink_communicationInterface <em>Link communication Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link communication Interface</em>'.
	 * @see intelligentMobility.Link_CooperativeBehaviour_CommunicationInterface#getLink_communicationInterface()
	 * @see #getLink_CooperativeBehaviour_CommunicationInterface()
	 * @generated
	 */
	EReference getLink_CooperativeBehaviour_CommunicationInterface_Link_communicationInterface();

	/**
	 * Returns the meta object for class '{@link intelligentMobility.Link_CommunicationInterface_Infrastructure <em>Link Communication Interface Infrastructure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link Communication Interface Infrastructure</em>'.
	 * @see intelligentMobility.Link_CommunicationInterface_Infrastructure
	 * @generated
	 */
	EClass getLink_CommunicationInterface_Infrastructure();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Link_CommunicationInterface_Infrastructure#getName_link_communication_interface_infrastructure <em>Name link communication interface infrastructure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name link communication interface infrastructure</em>'.
	 * @see intelligentMobility.Link_CommunicationInterface_Infrastructure#getName_link_communication_interface_infrastructure()
	 * @see #getLink_CommunicationInterface_Infrastructure()
	 * @generated
	 */
	EAttribute getLink_CommunicationInterface_Infrastructure_Name_link_communication_interface_infrastructure();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Link_CommunicationInterface_Infrastructure#getLink_communicationInterface <em>Link communication Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link communication Interface</em>'.
	 * @see intelligentMobility.Link_CommunicationInterface_Infrastructure#getLink_communicationInterface()
	 * @see #getLink_CommunicationInterface_Infrastructure()
	 * @generated
	 */
	EReference getLink_CommunicationInterface_Infrastructure_Link_communicationInterface();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Link_CommunicationInterface_Infrastructure#getLink_infrastructure <em>Link infrastructure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link infrastructure</em>'.
	 * @see intelligentMobility.Link_CommunicationInterface_Infrastructure#getLink_infrastructure()
	 * @see #getLink_CommunicationInterface_Infrastructure()
	 * @generated
	 */
	EReference getLink_CommunicationInterface_Infrastructure_Link_infrastructure();

	/**
	 * Returns the meta object for class '{@link intelligentMobility.Link_CooperativeBehaviour_VehicleConfiguration <em>Link Cooperative Behaviour Vehicle Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link Cooperative Behaviour Vehicle Configuration</em>'.
	 * @see intelligentMobility.Link_CooperativeBehaviour_VehicleConfiguration
	 * @generated
	 */
	EClass getLink_CooperativeBehaviour_VehicleConfiguration();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Link_CooperativeBehaviour_VehicleConfiguration#getName_link_cooperativeBehaviour_vehicleConfiguration <em>Name link cooperative Behaviour vehicle Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name link cooperative Behaviour vehicle Configuration</em>'.
	 * @see intelligentMobility.Link_CooperativeBehaviour_VehicleConfiguration#getName_link_cooperativeBehaviour_vehicleConfiguration()
	 * @see #getLink_CooperativeBehaviour_VehicleConfiguration()
	 * @generated
	 */
	EAttribute getLink_CooperativeBehaviour_VehicleConfiguration_Name_link_cooperativeBehaviour_vehicleConfiguration();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Link_CooperativeBehaviour_VehicleConfiguration#getLink_cooperativeBehaviour <em>Link cooperative Behaviour</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link cooperative Behaviour</em>'.
	 * @see intelligentMobility.Link_CooperativeBehaviour_VehicleConfiguration#getLink_cooperativeBehaviour()
	 * @see #getLink_CooperativeBehaviour_VehicleConfiguration()
	 * @generated
	 */
	EReference getLink_CooperativeBehaviour_VehicleConfiguration_Link_cooperativeBehaviour();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Link_CooperativeBehaviour_VehicleConfiguration#getLink_vehicleConfiguration <em>Link vehicle Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link vehicle Configuration</em>'.
	 * @see intelligentMobility.Link_CooperativeBehaviour_VehicleConfiguration#getLink_vehicleConfiguration()
	 * @see #getLink_CooperativeBehaviour_VehicleConfiguration()
	 * @generated
	 */
	EReference getLink_CooperativeBehaviour_VehicleConfiguration_Link_vehicleConfiguration();

	/**
	 * Returns the meta object for class '{@link intelligentMobility.Link_TrafficSituation_EnvironmentCondition <em>Link Traffic Situation Environment Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link Traffic Situation Environment Condition</em>'.
	 * @see intelligentMobility.Link_TrafficSituation_EnvironmentCondition
	 * @generated
	 */
	EClass getLink_TrafficSituation_EnvironmentCondition();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Link_TrafficSituation_EnvironmentCondition#getName_link_trafficSituation_environmentCondition <em>Name link traffic Situation environment Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name link traffic Situation environment Condition</em>'.
	 * @see intelligentMobility.Link_TrafficSituation_EnvironmentCondition#getName_link_trafficSituation_environmentCondition()
	 * @see #getLink_TrafficSituation_EnvironmentCondition()
	 * @generated
	 */
	EAttribute getLink_TrafficSituation_EnvironmentCondition_Name_link_trafficSituation_environmentCondition();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Link_TrafficSituation_EnvironmentCondition#getLink_trafficSituation <em>Link traffic Situation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link traffic Situation</em>'.
	 * @see intelligentMobility.Link_TrafficSituation_EnvironmentCondition#getLink_trafficSituation()
	 * @see #getLink_TrafficSituation_EnvironmentCondition()
	 * @generated
	 */
	EReference getLink_TrafficSituation_EnvironmentCondition_Link_trafficSituation();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Link_TrafficSituation_EnvironmentCondition#getLink_environmentCondition <em>Link environment Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link environment Condition</em>'.
	 * @see intelligentMobility.Link_TrafficSituation_EnvironmentCondition#getLink_environmentCondition()
	 * @see #getLink_TrafficSituation_EnvironmentCondition()
	 * @generated
	 */
	EReference getLink_TrafficSituation_EnvironmentCondition_Link_environmentCondition();

	/**
	 * Returns the meta object for class '{@link intelligentMobility.Link_Following_LaneChanging <em>Link Following Lane Changing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link Following Lane Changing</em>'.
	 * @see intelligentMobility.Link_Following_LaneChanging
	 * @generated
	 */
	EClass getLink_Following_LaneChanging();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Link_Following_LaneChanging#getName_link_following_laneChanging <em>Name link following lane Changing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name link following lane Changing</em>'.
	 * @see intelligentMobility.Link_Following_LaneChanging#getName_link_following_laneChanging()
	 * @see #getLink_Following_LaneChanging()
	 * @generated
	 */
	EAttribute getLink_Following_LaneChanging_Name_link_following_laneChanging();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Link_Following_LaneChanging#getLink_following <em>Link following</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link following</em>'.
	 * @see intelligentMobility.Link_Following_LaneChanging#getLink_following()
	 * @see #getLink_Following_LaneChanging()
	 * @generated
	 */
	EReference getLink_Following_LaneChanging_Link_following();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Link_Following_LaneChanging#getLink_laneChanging <em>Link lane Changing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link lane Changing</em>'.
	 * @see intelligentMobility.Link_Following_LaneChanging#getLink_laneChanging()
	 * @see #getLink_Following_LaneChanging()
	 * @generated
	 */
	EReference getLink_Following_LaneChanging_Link_laneChanging();

	/**
	 * Returns the meta object for class '{@link intelligentMobility.Link_Collision_SpecialCondition <em>Link Collision Special Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link Collision Special Condition</em>'.
	 * @see intelligentMobility.Link_Collision_SpecialCondition
	 * @generated
	 */
	EClass getLink_Collision_SpecialCondition();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Link_Collision_SpecialCondition#getName_link_collision_specialCondition <em>Name link collision special Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name link collision special Condition</em>'.
	 * @see intelligentMobility.Link_Collision_SpecialCondition#getName_link_collision_specialCondition()
	 * @see #getLink_Collision_SpecialCondition()
	 * @generated
	 */
	EAttribute getLink_Collision_SpecialCondition_Name_link_collision_specialCondition();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Link_Collision_SpecialCondition#getLink_collision <em>Link collision</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link collision</em>'.
	 * @see intelligentMobility.Link_Collision_SpecialCondition#getLink_collision()
	 * @see #getLink_Collision_SpecialCondition()
	 * @generated
	 */
	EReference getLink_Collision_SpecialCondition_Link_collision();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Link_Collision_SpecialCondition#getLink_specialCondition <em>Link special Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link special Condition</em>'.
	 * @see intelligentMobility.Link_Collision_SpecialCondition#getLink_specialCondition()
	 * @see #getLink_Collision_SpecialCondition()
	 * @generated
	 */
	EReference getLink_Collision_SpecialCondition_Link_specialCondition();

	/**
	 * Returns the meta object for class '{@link intelligentMobility.Link_Action_Backward <em>Link Action Backward</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link Action Backward</em>'.
	 * @see intelligentMobility.Link_Action_Backward
	 * @generated
	 */
	EClass getLink_Action_Backward();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Link_Action_Backward#getName_link_action_backward <em>Name link action backward</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name link action backward</em>'.
	 * @see intelligentMobility.Link_Action_Backward#getName_link_action_backward()
	 * @see #getLink_Action_Backward()
	 * @generated
	 */
	EAttribute getLink_Action_Backward_Name_link_action_backward();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Link_Action_Backward#getLink_action <em>Link action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link action</em>'.
	 * @see intelligentMobility.Link_Action_Backward#getLink_action()
	 * @see #getLink_Action_Backward()
	 * @generated
	 */
	EReference getLink_Action_Backward_Link_action();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Link_Action_Backward#getLink_backward <em>Link backward</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link backward</em>'.
	 * @see intelligentMobility.Link_Action_Backward#getLink_backward()
	 * @see #getLink_Action_Backward()
	 * @generated
	 */
	EReference getLink_Action_Backward_Link_backward();

	/**
	 * Returns the meta object for class '{@link intelligentMobility.Link_Action_Forward <em>Link Action Forward</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link Action Forward</em>'.
	 * @see intelligentMobility.Link_Action_Forward
	 * @generated
	 */
	EClass getLink_Action_Forward();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Link_Action_Forward#getName_link_action_forward <em>Name link action forward</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name link action forward</em>'.
	 * @see intelligentMobility.Link_Action_Forward#getName_link_action_forward()
	 * @see #getLink_Action_Forward()
	 * @generated
	 */
	EAttribute getLink_Action_Forward_Name_link_action_forward();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Link_Action_Forward#getLink_action <em>Link action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link action</em>'.
	 * @see intelligentMobility.Link_Action_Forward#getLink_action()
	 * @see #getLink_Action_Forward()
	 * @generated
	 */
	EReference getLink_Action_Forward_Link_action();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Link_Action_Forward#getLink_forward <em>Link forward</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link forward</em>'.
	 * @see intelligentMobility.Link_Action_Forward#getLink_forward()
	 * @see #getLink_Action_Forward()
	 * @generated
	 */
	EReference getLink_Action_Forward_Link_forward();

	/**
	 * Returns the meta object for class '{@link intelligentMobility.Link_Action_Turn <em>Link Action Turn</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link Action Turn</em>'.
	 * @see intelligentMobility.Link_Action_Turn
	 * @generated
	 */
	EClass getLink_Action_Turn();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Link_Action_Turn#getName_link_action_turn <em>Name link action turn</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name link action turn</em>'.
	 * @see intelligentMobility.Link_Action_Turn#getName_link_action_turn()
	 * @see #getLink_Action_Turn()
	 * @generated
	 */
	EAttribute getLink_Action_Turn_Name_link_action_turn();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Link_Action_Turn#getLink_action <em>Link action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link action</em>'.
	 * @see intelligentMobility.Link_Action_Turn#getLink_action()
	 * @see #getLink_Action_Turn()
	 * @generated
	 */
	EReference getLink_Action_Turn_Link_action();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Link_Action_Turn#getLink_turn <em>Link turn</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link turn</em>'.
	 * @see intelligentMobility.Link_Action_Turn#getLink_turn()
	 * @see #getLink_Action_Turn()
	 * @generated
	 */
	EReference getLink_Action_Turn_Link_turn();

	/**
	 * Returns the meta object for class '{@link intelligentMobility.Link_KnowledgeAndSkill_DriverPreference <em>Link Knowledge And Skill Driver Preference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link Knowledge And Skill Driver Preference</em>'.
	 * @see intelligentMobility.Link_KnowledgeAndSkill_DriverPreference
	 * @generated
	 */
	EClass getLink_KnowledgeAndSkill_DriverPreference();

	/**
	 * Returns the meta object for the attribute '{@link intelligentMobility.Link_KnowledgeAndSkill_DriverPreference#getName_link_knowledgeAndSkill_driverPreference <em>Name link knowledge And Skill driver Preference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name link knowledge And Skill driver Preference</em>'.
	 * @see intelligentMobility.Link_KnowledgeAndSkill_DriverPreference#getName_link_knowledgeAndSkill_driverPreference()
	 * @see #getLink_KnowledgeAndSkill_DriverPreference()
	 * @generated
	 */
	EAttribute getLink_KnowledgeAndSkill_DriverPreference_Name_link_knowledgeAndSkill_driverPreference();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Link_KnowledgeAndSkill_DriverPreference#getLink_knowledgeAndSkill <em>Link knowledge And Skill</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link knowledge And Skill</em>'.
	 * @see intelligentMobility.Link_KnowledgeAndSkill_DriverPreference#getLink_knowledgeAndSkill()
	 * @see #getLink_KnowledgeAndSkill_DriverPreference()
	 * @generated
	 */
	EReference getLink_KnowledgeAndSkill_DriverPreference_Link_knowledgeAndSkill();

	/**
	 * Returns the meta object for the reference '{@link intelligentMobility.Link_KnowledgeAndSkill_DriverPreference#getLink_driverPreference <em>Link driver Preference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link driver Preference</em>'.
	 * @see intelligentMobility.Link_KnowledgeAndSkill_DriverPreference#getLink_driverPreference()
	 * @see #getLink_KnowledgeAndSkill_DriverPreference()
	 * @generated
	 */
	EReference getLink_KnowledgeAndSkill_DriverPreference_Link_driverPreference();

	/**
	 * Returns the meta object for enum '{@link intelligentMobility.DriverType <em>Driver Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Driver Type</em>'.
	 * @see intelligentMobility.DriverType
	 * @generated
	 */
	EEnum getDriverType();

	/**
	 * Returns the meta object for enum '{@link intelligentMobility.Lanes <em>Lanes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Lanes</em>'.
	 * @see intelligentMobility.Lanes
	 * @generated
	 */
	EEnum getLanes();

	/**
	 * Returns the meta object for enum '{@link intelligentMobility.Direction <em>Direction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Direction</em>'.
	 * @see intelligentMobility.Direction
	 * @generated
	 */
	EEnum getDirection();

	/**
	 * Returns the meta object for enum '{@link intelligentMobility.CarType <em>Car Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Car Type</em>'.
	 * @see intelligentMobility.CarType
	 * @generated
	 */
	EEnum getCarType();

	/**
	 * Returns the meta object for enum '{@link intelligentMobility.RoadShape <em>Road Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Road Shape</em>'.
	 * @see intelligentMobility.RoadShape
	 * @generated
	 */
	EEnum getRoadShape();

	/**
	 * Returns the meta object for enum '{@link intelligentMobility.RoadType <em>Road Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Road Type</em>'.
	 * @see intelligentMobility.RoadType
	 * @generated
	 */
	EEnum getRoadType();

	/**
	 * Returns the meta object for enum '{@link intelligentMobility.TrafficType <em>Traffic Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Traffic Type</em>'.
	 * @see intelligentMobility.TrafficType
	 * @generated
	 */
	EEnum getTrafficType();

	/**
	 * Returns the meta object for enum '{@link intelligentMobility.ProtocolType <em>Protocol Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Protocol Type</em>'.
	 * @see intelligentMobility.ProtocolType
	 * @generated
	 */
	EEnum getProtocolType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	IntelligentMobilityFactory getIntelligentMobilityFactory();

} //IntelligentMobilityPackage
