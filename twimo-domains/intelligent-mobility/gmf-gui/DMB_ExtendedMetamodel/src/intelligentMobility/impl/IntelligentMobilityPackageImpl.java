/**
 */
package intelligentMobility.impl;

import intelligentMobility.IntelligentMobilityFactory;
import intelligentMobility.IntelligentMobilityPackage;

import java.io.IOException;

import java.net.URL;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class IntelligentMobilityPackageImpl extends EPackageImpl implements IntelligentMobilityPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected String packageFilename = "intelligentMobility.ecore";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mobilitySystemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass driver_ProfileEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vehicle_ConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass environment_BackgroundEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass driver_PreferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass knowledge_and_SkillEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass driver_EmotionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass driving_BehaviourEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass normal_BehaviourEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass followingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass laneChangingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abnormal_BehaviourEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass forwardEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass backwardEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass turnEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass gapAcceptanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass actionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vehicle_TypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass platoonEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass normal_VehicleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass leading_VehicleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass following_VehicleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass platoonMemberEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass possibleVehicleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass environment_ConditionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lane_TypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass regulationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass safety_RequirementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass weatherEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass traffic_SituationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass special_ConditionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass collisionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass intersectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass obstructionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass traffic_LightEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass exceptionConditionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass link_Driver_EnvironmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass link_Driver_VehicleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass link_Vehicle_EnvironmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass link_DriverProfile_DriverPreferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass link_VehicleConfiguration_VehicleTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass link_EnvironmentBackground_PossibleVehicleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass link_EnvironmentBackground_EnvironmentConditionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass link_DriverPreference_DriverEmotionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass link_DriverPreference_DrivingBehaviourEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass link_DriverPreference_EnvironmentConditionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass link_DrivingBehaviour_NormalBehaviourEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass link_NormalBehaviour_FollowingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass link_NormalBehaviour_LaneChangingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass link_Following_MinGapEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass link_Following_ForwardEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass link_Following_BackwardEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass link_LaneChanging_TurnEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass link_LaneChanging_GapAcceptanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass link_LaneChanging_EnvironmentConditionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass link_AbnormalBehaviour_ActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass link_Platoon_LeadingVehicleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass link_Platoon_FollowingVehicleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass link_NormalVehicle_SafetyRequirementsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass link_FollowingVehicle_FrontVehicleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass link_EnvironmentCondition_LaneTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass link_EnvironmentCondition_RegulationsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass link_EnvironmentCondition_WeatherEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass link_EnvironmentCondition_TrafficConditionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass link_EnvironmentCondition_SpecialConditionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass link_LaneType_RegulationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass link_SafetyRequirement_RegulationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass link_SpecialCondition_IntersectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass link_Collision_ObstructionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass link_Intersection_TrafficLightEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass infrastructureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass roadSegmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass smartSensorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass road_Side_UnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass chargingStationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass communicationInterfaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cooperativeBehaviorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass goalEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass link_Infrastructure_VehicleConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass link_CommunicationInterface_VehicleConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass link_Goal_DrivingBehaviourEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass link_CooperativeBehaviour_CommunicationInterfaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass link_CommunicationInterface_InfrastructureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass link_CooperativeBehaviour_VehicleConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass link_TrafficSituation_EnvironmentConditionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass link_Following_LaneChangingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass link_Collision_SpecialConditionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass link_Action_BackwardEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass link_Action_ForwardEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass link_Action_TurnEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass link_KnowledgeAndSkill_DriverPreferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum driverTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum lanesEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum directionEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum carTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum roadShapeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum roadTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum trafficTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum protocolTypeEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see intelligentMobility.IntelligentMobilityPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private IntelligentMobilityPackageImpl() {
		super(eNS_URI, IntelligentMobilityFactory.eINSTANCE);
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link IntelligentMobilityPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @generated
	 */
	public static IntelligentMobilityPackage init() {
		if (isInited) return (IntelligentMobilityPackage)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredIntelligentMobilityPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		IntelligentMobilityPackageImpl theIntelligentMobilityPackage = registeredIntelligentMobilityPackage instanceof IntelligentMobilityPackageImpl ? (IntelligentMobilityPackageImpl)registeredIntelligentMobilityPackage : new IntelligentMobilityPackageImpl();

		isInited = true;

		// Load packages
		theIntelligentMobilityPackage.loadPackage();

		// Fix loaded packages
		theIntelligentMobilityPackage.fixPackageContents();

		// Mark meta-data to indicate it can't be changed
		theIntelligentMobilityPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(IntelligentMobilityPackage.eNS_URI, theIntelligentMobilityPackage);
		return theIntelligentMobilityPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMobilitySystem() {
		if (mobilitySystemEClass == null) {
			mobilitySystemEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(0);
		}
		return mobilitySystemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMobilitySystem_Driver_profile() {
        return (EReference)getMobilitySystem().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMobilitySystem_Vehicle_configuration() {
        return (EReference)getMobilitySystem().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMobilitySystem_Environment_background() {
        return (EReference)getMobilitySystem().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMobilitySystem_Driver_preference() {
        return (EReference)getMobilitySystem().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMobilitySystem_Knowledge_and_skill() {
        return (EReference)getMobilitySystem().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMobilitySystem_Driver_emotion() {
        return (EReference)getMobilitySystem().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMobilitySystem_Driving_behaviour() {
        return (EReference)getMobilitySystem().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMobilitySystem_Normal_behaviour() {
        return (EReference)getMobilitySystem().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMobilitySystem_Following() {
        return (EReference)getMobilitySystem().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMobilitySystem_Lane_changing() {
        return (EReference)getMobilitySystem().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMobilitySystem_Abnormal_behaviour() {
        return (EReference)getMobilitySystem().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMobilitySystem_Forward() {
        return (EReference)getMobilitySystem().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMobilitySystem_Backward() {
        return (EReference)getMobilitySystem().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMobilitySystem_Turn() {
        return (EReference)getMobilitySystem().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMobilitySystem_Gap_acceptance() {
        return (EReference)getMobilitySystem().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMobilitySystem_Action() {
        return (EReference)getMobilitySystem().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMobilitySystem_Vehicle_type() {
        return (EReference)getMobilitySystem().getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMobilitySystem_Platoon() {
        return (EReference)getMobilitySystem().getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMobilitySystem_Normal_vehicle() {
        return (EReference)getMobilitySystem().getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMobilitySystem_Leading_vehicle() {
        return (EReference)getMobilitySystem().getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMobilitySystem_Following_vehicle() {
        return (EReference)getMobilitySystem().getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMobilitySystem_Platoon_member() {
        return (EReference)getMobilitySystem().getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMobilitySystem_Possible_vehicle() {
        return (EReference)getMobilitySystem().getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMobilitySystem_Environment_condition() {
        return (EReference)getMobilitySystem().getEStructuralFeatures().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMobilitySystem_Lane_type() {
        return (EReference)getMobilitySystem().getEStructuralFeatures().get(24);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMobilitySystem_Regulation() {
        return (EReference)getMobilitySystem().getEStructuralFeatures().get(25);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMobilitySystem_Safety_requirement() {
        return (EReference)getMobilitySystem().getEStructuralFeatures().get(26);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMobilitySystem_Weather() {
        return (EReference)getMobilitySystem().getEStructuralFeatures().get(27);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMobilitySystem_Traffic_situation() {
        return (EReference)getMobilitySystem().getEStructuralFeatures().get(28);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMobilitySystem_Special_condition() {
        return (EReference)getMobilitySystem().getEStructuralFeatures().get(29);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMobilitySystem_Collision() {
        return (EReference)getMobilitySystem().getEStructuralFeatures().get(30);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMobilitySystem_Intersection() {
        return (EReference)getMobilitySystem().getEStructuralFeatures().get(31);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMobilitySystem_Obstruction() {
        return (EReference)getMobilitySystem().getEStructuralFeatures().get(32);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMobilitySystem_Traffic_light() {
        return (EReference)getMobilitySystem().getEStructuralFeatures().get(33);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMobilitySystem_Execption_condition() {
        return (EReference)getMobilitySystem().getEStructuralFeatures().get(34);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMobilitySystem_Link_driver_vehicle() {
        return (EReference)getMobilitySystem().getEStructuralFeatures().get(35);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMobilitySystem_Link_driver_environment() {
        return (EReference)getMobilitySystem().getEStructuralFeatures().get(36);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMobilitySystem_Link_vehicle_environment() {
        return (EReference)getMobilitySystem().getEStructuralFeatures().get(37);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMobilitySystem_Link_driverProfile_driverPreference() {
        return (EReference)getMobilitySystem().getEStructuralFeatures().get(38);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMobilitySystem_Link_vehicleConfiguration_vehicleType() {
        return (EReference)getMobilitySystem().getEStructuralFeatures().get(39);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMobilitySystem_Link_environmentBackground_possibleVehicle() {
        return (EReference)getMobilitySystem().getEStructuralFeatures().get(40);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMobilitySystem_Link_environmentBackground_environmentCondition() {
        return (EReference)getMobilitySystem().getEStructuralFeatures().get(41);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMobilitySystem_Link_driverPreference_driverEmotion() {
        return (EReference)getMobilitySystem().getEStructuralFeatures().get(42);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMobilitySystem_Link_driverPreference_drivingBehaviour() {
        return (EReference)getMobilitySystem().getEStructuralFeatures().get(43);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMobilitySystem_Link_driverPreference_environmentCondition() {
        return (EReference)getMobilitySystem().getEStructuralFeatures().get(44);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMobilitySystem_Link_drivingBehaviour_normalBehaviour() {
        return (EReference)getMobilitySystem().getEStructuralFeatures().get(45);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMobilitySystem_Link_normalBehaviour_following() {
        return (EReference)getMobilitySystem().getEStructuralFeatures().get(46);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMobilitySystem_Link_normalBehaviour_laneChanging() {
        return (EReference)getMobilitySystem().getEStructuralFeatures().get(47);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMobilitySystem_Link_following_minGap() {
        return (EReference)getMobilitySystem().getEStructuralFeatures().get(48);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMobilitySystem_Link_following_forward() {
        return (EReference)getMobilitySystem().getEStructuralFeatures().get(49);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMobilitySystem_Link_following_backward() {
        return (EReference)getMobilitySystem().getEStructuralFeatures().get(50);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMobilitySystem_Link_laneChanging_turn() {
        return (EReference)getMobilitySystem().getEStructuralFeatures().get(51);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMobilitySystem_Link_laneChanging_gapAcceptance() {
        return (EReference)getMobilitySystem().getEStructuralFeatures().get(52);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMobilitySystem_Link_laneChanging_environmentCondition() {
        return (EReference)getMobilitySystem().getEStructuralFeatures().get(53);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMobilitySystem_Link_abnormalBehaviour_action() {
        return (EReference)getMobilitySystem().getEStructuralFeatures().get(54);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMobilitySystem_Link_platoon_leadingVehicle() {
        return (EReference)getMobilitySystem().getEStructuralFeatures().get(55);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMobilitySystem_Link_platoon_followingVehicle() {
        return (EReference)getMobilitySystem().getEStructuralFeatures().get(56);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMobilitySystem_Link_normalVehicle_safetyRequirement() {
        return (EReference)getMobilitySystem().getEStructuralFeatures().get(57);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMobilitySystem_Link_followingVehicle_frontVehicle() {
        return (EReference)getMobilitySystem().getEStructuralFeatures().get(58);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMobilitySystem_Link_environmentCondition_laneType() {
        return (EReference)getMobilitySystem().getEStructuralFeatures().get(59);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMobilitySystem_Link_environmentCondition_regulation() {
        return (EReference)getMobilitySystem().getEStructuralFeatures().get(60);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMobilitySystem_Link_environmentCondition_weather() {
        return (EReference)getMobilitySystem().getEStructuralFeatures().get(61);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMobilitySystem_Link_environmentCondition_trafficCondition() {
        return (EReference)getMobilitySystem().getEStructuralFeatures().get(62);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMobilitySystem_Link_environmentCondition_specialCondition() {
        return (EReference)getMobilitySystem().getEStructuralFeatures().get(63);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMobilitySystem_Link_laneType_regulation() {
        return (EReference)getMobilitySystem().getEStructuralFeatures().get(64);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMobilitySystem_Link_safetyRequirement_regulation() {
        return (EReference)getMobilitySystem().getEStructuralFeatures().get(65);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMobilitySystem_Link_specialCondition_intersection() {
        return (EReference)getMobilitySystem().getEStructuralFeatures().get(66);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMobilitySystem_Link_collision_obstruction() {
        return (EReference)getMobilitySystem().getEStructuralFeatures().get(67);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMobilitySystem_Link_intersection_trafficLight() {
        return (EReference)getMobilitySystem().getEStructuralFeatures().get(68);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMobilitySystem_SystemID() {
        return (EAttribute)getMobilitySystem().getEStructuralFeatures().get(69);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMobilitySystem_GeographicalScope() {
        return (EAttribute)getMobilitySystem().getEStructuralFeatures().get(70);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMobilitySystem_InfrastructureType() {
        return (EAttribute)getMobilitySystem().getEStructuralFeatures().get(71);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMobilitySystem_Infrastructure() {
        return (EReference)getMobilitySystem().getEStructuralFeatures().get(72);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMobilitySystem_CommunicationInterfaces() {
        return (EReference)getMobilitySystem().getEStructuralFeatures().get(73);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMobilitySystem_Goal() {
        return (EReference)getMobilitySystem().getEStructuralFeatures().get(74);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMobilitySystem_Link_infrastructure_vehicle_configuration() {
        return (EReference)getMobilitySystem().getEStructuralFeatures().get(75);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMobilitySystem_Link_communicationInterface_vehicleConfiguration() {
        return (EReference)getMobilitySystem().getEStructuralFeatures().get(76);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMobilitySystem_Link_communicationInterface_infrastructure() {
        return (EReference)getMobilitySystem().getEStructuralFeatures().get(77);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMobilitySystem_Link_goal_drivingBehaviour() {
        return (EReference)getMobilitySystem().getEStructuralFeatures().get(78);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMobilitySystem_CooperativeBehaviour() {
        return (EReference)getMobilitySystem().getEStructuralFeatures().get(79);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMobilitySystem_Link_cooperativeBehaviour_communicationInterface() {
        return (EReference)getMobilitySystem().getEStructuralFeatures().get(80);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMobilitySystem_Link_cooperativeBehaviour_vehicleConfiguration() {
        return (EReference)getMobilitySystem().getEStructuralFeatures().get(81);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMobilitySystem_Link_trafficSituation_environmentCondition() {
        return (EReference)getMobilitySystem().getEStructuralFeatures().get(82);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMobilitySystem_Link_following_laneChanging() {
        return (EReference)getMobilitySystem().getEStructuralFeatures().get(83);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMobilitySystem_Link_collision_specialCondition() {
        return (EReference)getMobilitySystem().getEStructuralFeatures().get(84);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMobilitySystem_Link_action_backward() {
        return (EReference)getMobilitySystem().getEStructuralFeatures().get(85);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMobilitySystem_Link_action_forward() {
        return (EReference)getMobilitySystem().getEStructuralFeatures().get(86);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMobilitySystem_Link_action_turn() {
        return (EReference)getMobilitySystem().getEStructuralFeatures().get(87);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMobilitySystem_Link_knowledgeAndSkill_driverPreference() {
        return (EReference)getMobilitySystem().getEStructuralFeatures().get(88);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDriver_Profile() {
		if (driver_ProfileEClass == null) {
			driver_ProfileEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(1);
		}
		return driver_ProfileEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDriver_Profile_Driver_preference() {
        return (EReference)getDriver_Profile().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDriver_Profile_DriverName() {
        return (EAttribute)getDriver_Profile().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDriver_Profile_DriverType() {
        return (EAttribute)getDriver_Profile().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDriver_Profile_PatienceValue() {
        return (EAttribute)getDriver_Profile().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDriver_Profile_LanePreference() {
        return (EAttribute)getDriver_Profile().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDriver_Profile_EnergySpeedRate() {
        return (EAttribute)getDriver_Profile().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDriver_Profile_RiskLevel() {
        return (EAttribute)getDriver_Profile().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDriver_Profile_ReactionTime_min() {
        return (EAttribute)getDriver_Profile().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDriver_Profile_ReactionTime_max() {
        return (EAttribute)getDriver_Profile().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDriver_Profile_ReactionTime_precision() {
        return (EAttribute)getDriver_Profile().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDriver_Profile_Age() {
        return (EAttribute)getDriver_Profile().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVehicle_Configuration() {
		if (vehicle_ConfigurationEClass == null) {
			vehicle_ConfigurationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(2);
		}
		return vehicle_ConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVehicle_Configuration_BrandName() {
        return (EAttribute)getVehicle_Configuration().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVehicle_Configuration_ColorR_min() {
        return (EAttribute)getVehicle_Configuration().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVehicle_Configuration_ColorR_max() {
        return (EAttribute)getVehicle_Configuration().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVehicle_Configuration_ColorG_min() {
        return (EAttribute)getVehicle_Configuration().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVehicle_Configuration_ColorG_max() {
        return (EAttribute)getVehicle_Configuration().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVehicle_Configuration_ColorB_min() {
        return (EAttribute)getVehicle_Configuration().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVehicle_Configuration_ColorB_max() {
        return (EAttribute)getVehicle_Configuration().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVehicle_Configuration_Vehicle_type() {
        return (EReference)getVehicle_Configuration().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVehicle_Configuration_GpsYaw() {
        return (EAttribute)getVehicle_Configuration().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVehicle_Configuration_GpsPitch() {
        return (EAttribute)getVehicle_Configuration().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVehicle_Configuration_GpsRoll() {
        return (EAttribute)getVehicle_Configuration().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVehicle_Configuration_Latitude() {
        return (EAttribute)getVehicle_Configuration().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVehicle_Configuration_Longitude() {
        return (EAttribute)getVehicle_Configuration().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVehicle_Configuration_ConnectedInfrastructure() {
        return (EReference)getVehicle_Configuration().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnvironment_Background() {
		if (environment_BackgroundEClass == null) {
			environment_BackgroundEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(3);
		}
		return environment_BackgroundEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnvironment_Background_Name() {
        return (EAttribute)getEnvironment_Background().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnvironment_Background_RoadLength() {
        return (EAttribute)getEnvironment_Background().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnvironment_Background_RoadShape() {
        return (EAttribute)getEnvironment_Background().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnvironment_Background_TotalVehiclePerFrame() {
        return (EAttribute)getEnvironment_Background().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnvironment_Background_TrafficDensity() {
        return (EAttribute)getEnvironment_Background().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnvironment_Background_SimulationFrameTime() {
        return (EAttribute)getEnvironment_Background().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnvironment_Background_SimulationSleepTime() {
        return (EAttribute)getEnvironment_Background().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnvironment_Background_Possiblevehicles() {
        return (EReference)getEnvironment_Background().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnvironment_Background_Environment_condition() {
        return (EReference)getEnvironment_Background().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnvironment_Background_RoadIncline() {
        return (EAttribute)getEnvironment_Background().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDriver_Preference() {
		if (driver_PreferenceEClass == null) {
			driver_PreferenceEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(4);
		}
		return driver_PreferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDriver_Preference_Driver_emotions() {
        return (EReference)getDriver_Preference().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDriver_Preference_Knowledge_and_skills() {
        return (EReference)getDriver_Preference().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDriver_Preference_Name_PreferenceSet() {
        return (EAttribute)getDriver_Preference().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDriver_Preference_Driving_behaviour() {
        return (EReference)getDriver_Preference().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDriver_Preference_Environment_condition() {
        return (EReference)getDriver_Preference().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getKnowledge_and_Skill() {
		if (knowledge_and_SkillEClass == null) {
			knowledge_and_SkillEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(5);
		}
		return knowledge_and_SkillEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getKnowledge_and_Skill_DrivingSkill() {
        return (EAttribute)getKnowledge_and_Skill().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getKnowledge_and_Skill_TrafficSignAwareness() {
        return (EAttribute)getKnowledge_and_Skill().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getKnowledge_and_Skill_RegulationAwareness() {
        return (EAttribute)getKnowledge_and_Skill().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getKnowledge_and_Skill_LaneSwitchPreferenceLevel() {
        return (EAttribute)getKnowledge_and_Skill().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getKnowledge_and_Skill_Name() {
        return (EAttribute)getKnowledge_and_Skill().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDriver_Emotion() {
		if (driver_EmotionEClass == null) {
			driver_EmotionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(6);
		}
		return driver_EmotionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDriver_Emotion_DrowsinessLevel() {
        return (EAttribute)getDriver_Emotion().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDriver_Emotion_ImpulseControlLevel() {
        return (EAttribute)getDriver_Emotion().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDriver_Emotion_MetanlCondition() {
        return (EAttribute)getDriver_Emotion().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDriver_Emotion_Name() {
        return (EAttribute)getDriver_Emotion().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDriver_Emotion_EcgHr() {
        return (EAttribute)getDriver_Emotion().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDriver_Emotion_Gsr() {
        return (EAttribute)getDriver_Emotion().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDriving_Behaviour() {
		if (driving_BehaviourEClass == null) {
			driving_BehaviourEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(9);
		}
		return driving_BehaviourEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDriving_Behaviour_PrepDistanceForDestination() {
        return (EAttribute)getDriving_Behaviour().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDriving_Behaviour_PrepDistanceForTurn() {
        return (EAttribute)getDriving_Behaviour().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDriving_Behaviour_InitialSpeed_min() {
        return (EAttribute)getDriving_Behaviour().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDriving_Behaviour_InitialSpeed_max() {
        return (EAttribute)getDriving_Behaviour().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDriving_Behaviour_InitialSpeed_precision() {
        return (EAttribute)getDriving_Behaviour().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDriving_Behaviour_DesiredSpeed_min() {
        return (EAttribute)getDriving_Behaviour().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDriving_Behaviour_DesiredSpeed_max() {
        return (EAttribute)getDriving_Behaviour().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDriving_Behaviour_Name() {
        return (EAttribute)getDriving_Behaviour().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDriving_Behaviour_Normal_behaviour() {
        return (EReference)getDriving_Behaviour().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDriving_Behaviour_SteeringAngle() {
        return (EAttribute)getDriving_Behaviour().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDriving_Behaviour_Throttle() {
        return (EAttribute)getDriving_Behaviour().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDriving_Behaviour_Brake() {
        return (EAttribute)getDriving_Behaviour().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDriving_Behaviour_Gear() {
        return (EAttribute)getDriving_Behaviour().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDriving_Behaviour_Handbrake() {
        return (EAttribute)getDriving_Behaviour().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDriving_Behaviour_Rpm() {
        return (EAttribute)getDriving_Behaviour().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDriving_Behaviour_KeyEvent() {
        return (EAttribute)getDriving_Behaviour().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDriving_Behaviour_PedalAngle() {
        return (EAttribute)getDriving_Behaviour().getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDriving_Behaviour_PedalPressure() {
        return (EAttribute)getDriving_Behaviour().getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDriving_Behaviour_SteerSpeed() {
        return (EAttribute)getDriving_Behaviour().getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDriving_Behaviour_IntentType() {
        return (EAttribute)getDriving_Behaviour().getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDriving_Behaviour_Confidence() {
        return (EAttribute)getDriving_Behaviour().getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDriving_Behaviour_Goal() {
        return (EReference)getDriving_Behaviour().getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNormal_Behaviour() {
		if (normal_BehaviourEClass == null) {
			normal_BehaviourEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(10);
		}
		return normal_BehaviourEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNormal_Behaviour_Following() {
        return (EReference)getNormal_Behaviour().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNormal_Behaviour_Lanechanging() {
        return (EReference)getNormal_Behaviour().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFollowing() {
		if (followingEClass == null) {
			followingEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(11);
		}
		return followingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFollowing_FollowingGap() {
        return (EAttribute)getFollowing().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFollowing_Name() {
        return (EAttribute)getFollowing().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFollowing_MinGap() {
        return (EReference)getFollowing().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFollowing_Forward() {
        return (EReference)getFollowing().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFollowing_Backward() {
        return (EReference)getFollowing().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLaneChanging() {
		if (laneChangingEClass == null) {
			laneChangingEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(12);
		}
		return laneChangingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLaneChanging_LaneSwitchSpeed() {
        return (EAttribute)getLaneChanging().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLaneChanging_Name() {
        return (EAttribute)getLaneChanging().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLaneChanging_Turn() {
        return (EReference)getLaneChanging().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLaneChanging_Gapacceptance() {
        return (EReference)getLaneChanging().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLaneChanging_Environment_condition() {
        return (EReference)getLaneChanging().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLaneChanging_LeftLaneChange() {
        return (EAttribute)getLaneChanging().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLaneChanging_RightLaneChange() {
        return (EAttribute)getLaneChanging().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLaneChanging_LeftLaneBranch() {
        return (EAttribute)getLaneChanging().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLaneChanging_RightLaneBranch() {
        return (EAttribute)getLaneChanging().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLaneChanging_Action() {
        return (EReference)getLaneChanging().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLaneChanging_ManeuverType() {
        return (EAttribute)getLaneChanging().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLaneChanging_Duration() {
        return (EAttribute)getLaneChanging().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbnormal_Behaviour() {
		if (abnormal_BehaviourEClass == null) {
			abnormal_BehaviourEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(13);
		}
		return abnormal_BehaviourEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbnormal_Behaviour_Zigzag_Driving() {
        return (EAttribute)getAbnormal_Behaviour().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbnormal_Behaviour_Risky_Acceleration() {
        return (EAttribute)getAbnormal_Behaviour().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbnormal_Behaviour_Risky_Lanechanging() {
        return (EAttribute)getAbnormal_Behaviour().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbnormal_Behaviour_Name() {
        return (EAttribute)getAbnormal_Behaviour().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbnormal_Behaviour_Actions() {
        return (EReference)getAbnormal_Behaviour().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getForward() {
		if (forwardEClass == null) {
			forwardEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(14);
		}
		return forwardEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getForward_Acceleration() {
        return (EAttribute)getForward().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getForward_Deceleration() {
        return (EAttribute)getForward().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getForward_Name() {
        return (EAttribute)getForward().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBackward() {
		if (backwardEClass == null) {
			backwardEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(15);
		}
		return backwardEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBackward_BackwardSpeed() {
        return (EAttribute)getBackward().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBackward_BackDistance() {
        return (EAttribute)getBackward().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBackward_Name() {
        return (EAttribute)getBackward().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTurn() {
		if (turnEClass == null) {
			turnEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(16);
		}
		return turnEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTurn_TurnSide() {
        return (EAttribute)getTurn().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTurn_Name() {
        return (EAttribute)getTurn().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGapAcceptance() {
		if (gapAcceptanceEClass == null) {
			gapAcceptanceEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(18);
		}
		return gapAcceptanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGapAcceptance_LagGap() {
        return (EAttribute)getGapAcceptance().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGapAcceptance_LeadGap() {
        return (EAttribute)getGapAcceptance().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGapAcceptance_Name() {
        return (EAttribute)getGapAcceptance().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAction() {
		if (actionEClass == null) {
			actionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(19);
		}
		return actionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAction_ActionType() {
        return (EAttribute)getAction().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAction_Timestamp() {
        return (EAttribute)getAction().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVehicle_Type() {
		if (vehicle_TypeEClass == null) {
			vehicle_TypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(20);
		}
		return vehicle_TypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVehicle_Type_Type() {
        return (EAttribute)getVehicle_Type().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVehicle_Type_MaxSpeed() {
        return (EAttribute)getVehicle_Type().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVehicle_Type_VehicleWidth_min() {
        return (EAttribute)getVehicle_Type().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVehicle_Type_VehicleWidth_max() {
        return (EAttribute)getVehicle_Type().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVehicle_Type_VehicleWidth_precision() {
        return (EAttribute)getVehicle_Type().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVehicle_Type_VehicleLength_min() {
        return (EAttribute)getVehicle_Type().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVehicle_Type_VehicleLength_max() {
        return (EAttribute)getVehicle_Type().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVehicle_Type_VehicleLength_precision() {
        return (EAttribute)getVehicle_Type().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVehicle_Type_VehicleHeight_min() {
        return (EAttribute)getVehicle_Type().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVehicle_Type_VehicleHeight_max() {
        return (EAttribute)getVehicle_Type().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVehicle_Type_VehicleHeight_precision() {
        return (EAttribute)getVehicle_Type().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVehicle_Type_Speed() {
        return (EAttribute)getVehicle_Type().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVehicle_Type_Stop() {
        return (EAttribute)getVehicle_Type().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPlatoon() {
		if (platoonEClass == null) {
			platoonEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(22);
		}
		return platoonEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPlatoon_Name() {
        return (EAttribute)getPlatoon().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPlatoon_V2vTime() {
        return (EAttribute)getPlatoon().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPlatoon_FollowerCount() {
        return (EAttribute)getPlatoon().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPlatoon_ResetColor() {
        return (EAttribute)getPlatoon().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPlatoon_ColorR_min() {
        return (EAttribute)getPlatoon().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPlatoon_ColorR_max() {
        return (EAttribute)getPlatoon().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPlatoon_ColorG_min() {
        return (EAttribute)getPlatoon().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPlatoon_ColorG_max() {
        return (EAttribute)getPlatoon().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPlatoon_ColorB_min() {
        return (EAttribute)getPlatoon().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPlatoon_ColorB_max() {
        return (EAttribute)getPlatoon().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPlatoon_Leading_vehicle() {
        return (EReference)getPlatoon().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPlatoon_Following_vehicle() {
        return (EReference)getPlatoon().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNormal_Vehicle() {
		if (normal_VehicleEClass == null) {
			normal_VehicleEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(23);
		}
		return normal_VehicleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNormal_Vehicle_Name() {
        return (EAttribute)getNormal_Vehicle().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNormal_Vehicle_ResetColor() {
        return (EAttribute)getNormal_Vehicle().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNormal_Vehicle_ColorR_min() {
        return (EAttribute)getNormal_Vehicle().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNormal_Vehicle_ColorR_max() {
        return (EAttribute)getNormal_Vehicle().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNormal_Vehicle_ColorG_min() {
        return (EAttribute)getNormal_Vehicle().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNormal_Vehicle_ColorG_max() {
        return (EAttribute)getNormal_Vehicle().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNormal_Vehicle_ColorB_min() {
        return (EAttribute)getNormal_Vehicle().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNormal_Vehicle_ColorB_max() {
        return (EAttribute)getNormal_Vehicle().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNormal_Vehicle_Safety_requirements() {
        return (EReference)getNormal_Vehicle().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLeading_Vehicle() {
		if (leading_VehicleEClass == null) {
			leading_VehicleEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(24);
		}
		return leading_VehicleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFollowing_Vehicle() {
		if (following_VehicleEClass == null) {
			following_VehicleEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(25);
		}
		return following_VehicleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFollowing_Vehicle_HeadwayMin() {
        return (EAttribute)getFollowing_Vehicle().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFollowing_Vehicle_HeadwayMax() {
        return (EAttribute)getFollowing_Vehicle().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFollowing_Vehicle_Frontvehicle() {
        return (EReference)getFollowing_Vehicle().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPlatoonMember() {
		if (platoonMemberEClass == null) {
			platoonMemberEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(26);
		}
		return platoonMemberEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPossibleVehicle() {
		if (possibleVehicleEClass == null) {
			possibleVehicleEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(28);
		}
		return possibleVehicleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPossibleVehicle_VehicleType() {
        return (EAttribute)getPossibleVehicle().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPossibleVehicle_AmountPercentage() {
        return (EAttribute)getPossibleVehicle().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPossibleVehicle_SimulationOrderIndex() {
        return (EAttribute)getPossibleVehicle().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnvironment_Condition() {
		if (environment_ConditionEClass == null) {
			environment_ConditionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(29);
		}
		return environment_ConditionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnvironment_Condition_RoadType() {
        return (EAttribute)getEnvironment_Condition().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnvironment_Condition_LaneAmount() {
        return (EAttribute)getEnvironment_Condition().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnvironment_Condition_Name_EnvironmentCondition() {
        return (EAttribute)getEnvironment_Condition().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnvironment_Condition_Lane_type() {
        return (EReference)getEnvironment_Condition().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnvironment_Condition_Regulations() {
        return (EReference)getEnvironment_Condition().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnvironment_Condition_Weather() {
        return (EReference)getEnvironment_Condition().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnvironment_Condition_Traffic_condition() {
        return (EReference)getEnvironment_Condition().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnvironment_Condition_Special_condition() {
        return (EReference)getEnvironment_Condition().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnvironment_Condition_CueType() {
        return (EAttribute)getEnvironment_Condition().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnvironment_Condition_Salience() {
        return (EAttribute)getEnvironment_Condition().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnvironment_Condition_Position() {
        return (EReference)getEnvironment_Condition().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLane_Type() {
		if (lane_TypeEClass == null) {
			lane_TypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(31);
		}
		return lane_TypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLane_Type_LaneType() {
        return (EAttribute)getLane_Type().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLane_Type_LaneCount() {
        return (EAttribute)getLane_Type().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLane_Type_LaneWidth() {
        return (EAttribute)getLane_Type().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLane_Type_LaneLength() {
        return (EAttribute)getLane_Type().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLane_Type_MaxSpeedLimitation() {
        return (EAttribute)getLane_Type().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLane_Type_Name() {
        return (EAttribute)getLane_Type().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLane_Type_Regulations() {
        return (EReference)getLane_Type().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRegulation() {
		if (regulationEClass == null) {
			regulationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(32);
		}
		return regulationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRegulation_Legislation() {
        return (EAttribute)getRegulation().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRegulation_Courtesy() {
        return (EAttribute)getRegulation().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRegulation_Name() {
        return (EAttribute)getRegulation().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSafety_Requirement() {
		if (safety_RequirementEClass == null) {
			safety_RequirementEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(33);
		}
		return safety_RequirementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSafety_Requirement_SafeSecond() {
        return (EAttribute)getSafety_Requirement().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSafety_Requirement_SafezoneLength_default() {
        return (EAttribute)getSafety_Requirement().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSafety_Requirement_SafeFrontMin() {
        return (EAttribute)getSafety_Requirement().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSafety_Requirement_Name() {
        return (EAttribute)getSafety_Requirement().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSafety_Requirement_Regulations() {
        return (EReference)getSafety_Requirement().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWeather() {
		if (weatherEClass == null) {
			weatherEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(34);
		}
		return weatherEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWeather_Slipperiness() {
        return (EAttribute)getWeather().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWeather_WeatherType() {
        return (EAttribute)getWeather().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWeather_Name() {
        return (EAttribute)getWeather().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTraffic_Situation() {
		if (traffic_SituationEClass == null) {
			traffic_SituationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(35);
		}
		return traffic_SituationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTraffic_Situation_Name() {
        return (EAttribute)getTraffic_Situation().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTraffic_Situation_TrafficType() {
        return (EAttribute)getTraffic_Situation().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTraffic_Situation_StimulusType() {
        return (EAttribute)getTraffic_Situation().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTraffic_Situation_Intensity() {
        return (EAttribute)getTraffic_Situation().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSpecial_Condition() {
		if (special_ConditionEClass == null) {
			special_ConditionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(36);
		}
		return special_ConditionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSpecial_Condition_ConditionName() {
        return (EAttribute)getSpecial_Condition().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSpecial_Condition_Collision() {
        return (EReference)getSpecial_Condition().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSpecial_Condition_Intersection() {
        return (EReference)getSpecial_Condition().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCollision() {
		if (collisionEClass == null) {
			collisionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(38);
		}
		return collisionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCollision_RecoveryTime() {
        return (EAttribute)getCollision().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCollision_Name() {
        return (EAttribute)getCollision().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCollision_Obstructions() {
        return (EReference)getCollision().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntersection() {
		if (intersectionEClass == null) {
			intersectionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(39);
		}
		return intersectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntersection_Name() {
        return (EAttribute)getIntersection().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIntersection_Traffic_lights() {
        return (EReference)getIntersection().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntersection_CrossIntersection() {
        return (EAttribute)getIntersection().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntersection_CrossRailway() {
        return (EAttribute)getIntersection().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getObstruction() {
		if (obstructionEClass == null) {
			obstructionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(40);
		}
		return obstructionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getObstruction_Name() {
        return (EAttribute)getObstruction().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getObstruction_ObstacleLocationX() {
        return (EAttribute)getObstruction().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getObstruction_ObstacleLocationY() {
        return (EAttribute)getObstruction().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTraffic_Light() {
		if (traffic_LightEClass == null) {
			traffic_LightEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(41);
		}
		return traffic_LightEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTraffic_Light_Enforces() {
        return (EReference)getTraffic_Light().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTraffic_Light_Name() {
        return (EAttribute)getTraffic_Light().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExceptionCondition() {
		if (exceptionConditionEClass == null) {
			exceptionConditionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(42);
		}
		return exceptionConditionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLink_Driver_Environment() {
		if (link_Driver_EnvironmentEClass == null) {
			link_Driver_EnvironmentEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(43);
		}
		return link_Driver_EnvironmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLink_Driver_Environment_Link_name_driver_environment() {
        return (EAttribute)getLink_Driver_Environment().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_Driver_Environment_Link_driver_profile() {
        return (EReference)getLink_Driver_Environment().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_Driver_Environment_Link_environment_background() {
        return (EReference)getLink_Driver_Environment().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLink_Driver_Vehicle() {
		if (link_Driver_VehicleEClass == null) {
			link_Driver_VehicleEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(44);
		}
		return link_Driver_VehicleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLink_Driver_Vehicle_Link_name_driver_vehicle() {
        return (EAttribute)getLink_Driver_Vehicle().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_Driver_Vehicle_Link_driver_profile() {
        return (EReference)getLink_Driver_Vehicle().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_Driver_Vehicle_Link_vehicle_configuration() {
        return (EReference)getLink_Driver_Vehicle().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLink_Vehicle_Environment() {
		if (link_Vehicle_EnvironmentEClass == null) {
			link_Vehicle_EnvironmentEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(45);
		}
		return link_Vehicle_EnvironmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLink_Vehicle_Environment_Link_name_vehicle_environment() {
        return (EAttribute)getLink_Vehicle_Environment().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_Vehicle_Environment_Link_vehicle_configuration() {
        return (EReference)getLink_Vehicle_Environment().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_Vehicle_Environment_Link_environment_background() {
        return (EReference)getLink_Vehicle_Environment().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLink_DriverProfile_DriverPreference() {
		if (link_DriverProfile_DriverPreferenceEClass == null) {
			link_DriverProfile_DriverPreferenceEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(46);
		}
		return link_DriverProfile_DriverPreferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLink_DriverProfile_DriverPreference_Name_link_profile_preference() {
        return (EAttribute)getLink_DriverProfile_DriverPreference().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_DriverProfile_DriverPreference_Link_driver_profile() {
        return (EReference)getLink_DriverProfile_DriverPreference().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_DriverProfile_DriverPreference_Link_driver_preference() {
        return (EReference)getLink_DriverProfile_DriverPreference().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLink_VehicleConfiguration_VehicleType() {
		if (link_VehicleConfiguration_VehicleTypeEClass == null) {
			link_VehicleConfiguration_VehicleTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(47);
		}
		return link_VehicleConfiguration_VehicleTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLink_VehicleConfiguration_VehicleType_Name_link_configuration_type() {
        return (EAttribute)getLink_VehicleConfiguration_VehicleType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_VehicleConfiguration_VehicleType_Link_vehicle_configuration() {
        return (EReference)getLink_VehicleConfiguration_VehicleType().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_VehicleConfiguration_VehicleType_Link_vehicle_type() {
        return (EReference)getLink_VehicleConfiguration_VehicleType().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLink_EnvironmentBackground_PossibleVehicle() {
		if (link_EnvironmentBackground_PossibleVehicleEClass == null) {
			link_EnvironmentBackground_PossibleVehicleEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(48);
		}
		return link_EnvironmentBackground_PossibleVehicleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLink_EnvironmentBackground_PossibleVehicle_Name_link_background_possibleVehicle() {
        return (EAttribute)getLink_EnvironmentBackground_PossibleVehicle().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_EnvironmentBackground_PossibleVehicle_Link_environment_background() {
        return (EReference)getLink_EnvironmentBackground_PossibleVehicle().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_EnvironmentBackground_PossibleVehicle_Link_possible_vehicle() {
        return (EReference)getLink_EnvironmentBackground_PossibleVehicle().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLink_EnvironmentBackground_EnvironmentCondition() {
		if (link_EnvironmentBackground_EnvironmentConditionEClass == null) {
			link_EnvironmentBackground_EnvironmentConditionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(49);
		}
		return link_EnvironmentBackground_EnvironmentConditionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLink_EnvironmentBackground_EnvironmentCondition_Name_link_background_condition() {
        return (EAttribute)getLink_EnvironmentBackground_EnvironmentCondition().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_EnvironmentBackground_EnvironmentCondition_Link_environment_background() {
        return (EReference)getLink_EnvironmentBackground_EnvironmentCondition().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_EnvironmentBackground_EnvironmentCondition_Link_environment_condition() {
        return (EReference)getLink_EnvironmentBackground_EnvironmentCondition().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLink_DriverPreference_DriverEmotion() {
		if (link_DriverPreference_DriverEmotionEClass == null) {
			link_DriverPreference_DriverEmotionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(50);
		}
		return link_DriverPreference_DriverEmotionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLink_DriverPreference_DriverEmotion_Name_link_preference_emotion() {
        return (EAttribute)getLink_DriverPreference_DriverEmotion().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_DriverPreference_DriverEmotion_Link_driver_preference() {
        return (EReference)getLink_DriverPreference_DriverEmotion().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_DriverPreference_DriverEmotion_Link_driver_emotion() {
        return (EReference)getLink_DriverPreference_DriverEmotion().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLink_DriverPreference_DrivingBehaviour() {
		if (link_DriverPreference_DrivingBehaviourEClass == null) {
			link_DriverPreference_DrivingBehaviourEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(51);
		}
		return link_DriverPreference_DrivingBehaviourEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLink_DriverPreference_DrivingBehaviour_Name_link_preference_behaviour() {
        return (EAttribute)getLink_DriverPreference_DrivingBehaviour().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_DriverPreference_DrivingBehaviour_Link_driver_preference() {
        return (EReference)getLink_DriverPreference_DrivingBehaviour().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_DriverPreference_DrivingBehaviour_Link_driving_behaviour() {
        return (EReference)getLink_DriverPreference_DrivingBehaviour().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLink_DriverPreference_EnvironmentCondition() {
		if (link_DriverPreference_EnvironmentConditionEClass == null) {
			link_DriverPreference_EnvironmentConditionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(52);
		}
		return link_DriverPreference_EnvironmentConditionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLink_DriverPreference_EnvironmentCondition_Name_link_preference_condition() {
        return (EAttribute)getLink_DriverPreference_EnvironmentCondition().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_DriverPreference_EnvironmentCondition_Link_driver_preference() {
        return (EReference)getLink_DriverPreference_EnvironmentCondition().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_DriverPreference_EnvironmentCondition_Link_environment_condition() {
        return (EReference)getLink_DriverPreference_EnvironmentCondition().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLink_DrivingBehaviour_NormalBehaviour() {
		if (link_DrivingBehaviour_NormalBehaviourEClass == null) {
			link_DrivingBehaviour_NormalBehaviourEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(53);
		}
		return link_DrivingBehaviour_NormalBehaviourEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLink_DrivingBehaviour_NormalBehaviour_Name_link_driving_normal() {
        return (EAttribute)getLink_DrivingBehaviour_NormalBehaviour().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_DrivingBehaviour_NormalBehaviour_Link_driving_behaviour() {
        return (EReference)getLink_DrivingBehaviour_NormalBehaviour().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_DrivingBehaviour_NormalBehaviour_Link_normal_behaviour() {
        return (EReference)getLink_DrivingBehaviour_NormalBehaviour().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLink_NormalBehaviour_Following() {
		if (link_NormalBehaviour_FollowingEClass == null) {
			link_NormalBehaviour_FollowingEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(54);
		}
		return link_NormalBehaviour_FollowingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLink_NormalBehaviour_Following_Name_link_behaviour_following() {
        return (EAttribute)getLink_NormalBehaviour_Following().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_NormalBehaviour_Following_Link_normal_behaviour() {
        return (EReference)getLink_NormalBehaviour_Following().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_NormalBehaviour_Following_Link_following() {
        return (EReference)getLink_NormalBehaviour_Following().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLink_NormalBehaviour_LaneChanging() {
		if (link_NormalBehaviour_LaneChangingEClass == null) {
			link_NormalBehaviour_LaneChangingEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(55);
		}
		return link_NormalBehaviour_LaneChangingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLink_NormalBehaviour_LaneChanging_Name_link_behaviour_laneChanging() {
        return (EAttribute)getLink_NormalBehaviour_LaneChanging().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_NormalBehaviour_LaneChanging_Link_normal_behaviour() {
        return (EReference)getLink_NormalBehaviour_LaneChanging().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_NormalBehaviour_LaneChanging_Link_lane_changing() {
        return (EReference)getLink_NormalBehaviour_LaneChanging().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLink_Following_MinGap() {
		if (link_Following_MinGapEClass == null) {
			link_Following_MinGapEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(56);
		}
		return link_Following_MinGapEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLink_Following_MinGap_Name_link_following_minGap() {
        return (EAttribute)getLink_Following_MinGap().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_Following_MinGap_Link_following() {
        return (EReference)getLink_Following_MinGap().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_Following_MinGap_Link_minGap() {
        return (EReference)getLink_Following_MinGap().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLink_Following_Forward() {
		if (link_Following_ForwardEClass == null) {
			link_Following_ForwardEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(57);
		}
		return link_Following_ForwardEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLink_Following_Forward_Name_link_following_forward() {
        return (EAttribute)getLink_Following_Forward().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_Following_Forward_Link_following() {
        return (EReference)getLink_Following_Forward().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_Following_Forward_Link_forward() {
        return (EReference)getLink_Following_Forward().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLink_Following_Backward() {
		if (link_Following_BackwardEClass == null) {
			link_Following_BackwardEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(58);
		}
		return link_Following_BackwardEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLink_Following_Backward_Name_link_following_backward() {
        return (EAttribute)getLink_Following_Backward().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_Following_Backward_Link_following() {
        return (EReference)getLink_Following_Backward().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_Following_Backward_Link_backward() {
        return (EReference)getLink_Following_Backward().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLink_LaneChanging_Turn() {
		if (link_LaneChanging_TurnEClass == null) {
			link_LaneChanging_TurnEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(59);
		}
		return link_LaneChanging_TurnEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLink_LaneChanging_Turn_Name_link_laneChanging_turn() {
        return (EAttribute)getLink_LaneChanging_Turn().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_LaneChanging_Turn_Link_laneChanging() {
        return (EReference)getLink_LaneChanging_Turn().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_LaneChanging_Turn_Link_turn() {
        return (EReference)getLink_LaneChanging_Turn().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLink_LaneChanging_GapAcceptance() {
		if (link_LaneChanging_GapAcceptanceEClass == null) {
			link_LaneChanging_GapAcceptanceEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(60);
		}
		return link_LaneChanging_GapAcceptanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLink_LaneChanging_GapAcceptance_Name_link_laneChanging_gapAcceptane() {
        return (EAttribute)getLink_LaneChanging_GapAcceptance().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_LaneChanging_GapAcceptance_Link_laneChanging() {
        return (EReference)getLink_LaneChanging_GapAcceptance().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_LaneChanging_GapAcceptance_Link_gapAcceptance() {
        return (EReference)getLink_LaneChanging_GapAcceptance().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLink_LaneChanging_EnvironmentCondition() {
		if (link_LaneChanging_EnvironmentConditionEClass == null) {
			link_LaneChanging_EnvironmentConditionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(61);
		}
		return link_LaneChanging_EnvironmentConditionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLink_LaneChanging_EnvironmentCondition_Name_link_laneChanging_environmentCondition() {
        return (EAttribute)getLink_LaneChanging_EnvironmentCondition().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_LaneChanging_EnvironmentCondition_Link_laneChanging() {
        return (EReference)getLink_LaneChanging_EnvironmentCondition().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_LaneChanging_EnvironmentCondition_Link_environmentCondition() {
        return (EReference)getLink_LaneChanging_EnvironmentCondition().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLink_AbnormalBehaviour_Action() {
		if (link_AbnormalBehaviour_ActionEClass == null) {
			link_AbnormalBehaviour_ActionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(62);
		}
		return link_AbnormalBehaviour_ActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLink_AbnormalBehaviour_Action_Name_link_abnormalBehaviour_action() {
        return (EAttribute)getLink_AbnormalBehaviour_Action().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_AbnormalBehaviour_Action_Link_abnormalBehaviour() {
        return (EReference)getLink_AbnormalBehaviour_Action().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_AbnormalBehaviour_Action_Link_action() {
        return (EReference)getLink_AbnormalBehaviour_Action().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLink_Platoon_LeadingVehicle() {
		if (link_Platoon_LeadingVehicleEClass == null) {
			link_Platoon_LeadingVehicleEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(63);
		}
		return link_Platoon_LeadingVehicleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLink_Platoon_LeadingVehicle_Name_link_platoon_leadingVehicle() {
        return (EAttribute)getLink_Platoon_LeadingVehicle().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_Platoon_LeadingVehicle_Link_platoon() {
        return (EReference)getLink_Platoon_LeadingVehicle().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_Platoon_LeadingVehicle_Link_leadingVehicle() {
        return (EReference)getLink_Platoon_LeadingVehicle().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLink_Platoon_FollowingVehicle() {
		if (link_Platoon_FollowingVehicleEClass == null) {
			link_Platoon_FollowingVehicleEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(64);
		}
		return link_Platoon_FollowingVehicleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLink_Platoon_FollowingVehicle_Name_link_platoon_followingVehicle() {
        return (EAttribute)getLink_Platoon_FollowingVehicle().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_Platoon_FollowingVehicle_Link_platoon() {
        return (EReference)getLink_Platoon_FollowingVehicle().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_Platoon_FollowingVehicle_Link_followingVehicle() {
        return (EReference)getLink_Platoon_FollowingVehicle().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLink_NormalVehicle_SafetyRequirements() {
		if (link_NormalVehicle_SafetyRequirementsEClass == null) {
			link_NormalVehicle_SafetyRequirementsEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(65);
		}
		return link_NormalVehicle_SafetyRequirementsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLink_NormalVehicle_SafetyRequirements_Name_link_normalVehicle_safetyRequirement() {
        return (EAttribute)getLink_NormalVehicle_SafetyRequirements().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_NormalVehicle_SafetyRequirements_Link_normalVehicle() {
        return (EReference)getLink_NormalVehicle_SafetyRequirements().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_NormalVehicle_SafetyRequirements_Link_safetyRequirement() {
        return (EReference)getLink_NormalVehicle_SafetyRequirements().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLink_FollowingVehicle_FrontVehicle() {
		if (link_FollowingVehicle_FrontVehicleEClass == null) {
			link_FollowingVehicle_FrontVehicleEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(66);
		}
		return link_FollowingVehicle_FrontVehicleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLink_FollowingVehicle_FrontVehicle_Name_link_followingVehicle_frontVehicle() {
        return (EAttribute)getLink_FollowingVehicle_FrontVehicle().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_FollowingVehicle_FrontVehicle_Link_followingVehicle() {
        return (EReference)getLink_FollowingVehicle_FrontVehicle().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_FollowingVehicle_FrontVehicle_Link_frontVehicle() {
        return (EReference)getLink_FollowingVehicle_FrontVehicle().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLink_EnvironmentCondition_LaneType() {
		if (link_EnvironmentCondition_LaneTypeEClass == null) {
			link_EnvironmentCondition_LaneTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(67);
		}
		return link_EnvironmentCondition_LaneTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLink_EnvironmentCondition_LaneType_Name_link_environmentCondition_laneType() {
        return (EAttribute)getLink_EnvironmentCondition_LaneType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_EnvironmentCondition_LaneType_Link_environmentCondition() {
        return (EReference)getLink_EnvironmentCondition_LaneType().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_EnvironmentCondition_LaneType_Link_laneType() {
        return (EReference)getLink_EnvironmentCondition_LaneType().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLink_EnvironmentCondition_Regulations() {
		if (link_EnvironmentCondition_RegulationsEClass == null) {
			link_EnvironmentCondition_RegulationsEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(68);
		}
		return link_EnvironmentCondition_RegulationsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLink_EnvironmentCondition_Regulations_Name_link_environmentCondition_regulation() {
        return (EAttribute)getLink_EnvironmentCondition_Regulations().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_EnvironmentCondition_Regulations_Link_environmentCondition() {
        return (EReference)getLink_EnvironmentCondition_Regulations().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_EnvironmentCondition_Regulations_Link_regulation() {
        return (EReference)getLink_EnvironmentCondition_Regulations().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLink_EnvironmentCondition_Weather() {
		if (link_EnvironmentCondition_WeatherEClass == null) {
			link_EnvironmentCondition_WeatherEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(69);
		}
		return link_EnvironmentCondition_WeatherEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLink_EnvironmentCondition_Weather_Name_link_environmentCondition_weather() {
        return (EAttribute)getLink_EnvironmentCondition_Weather().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_EnvironmentCondition_Weather_Link_environmentCondition() {
        return (EReference)getLink_EnvironmentCondition_Weather().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_EnvironmentCondition_Weather_Link_weather() {
        return (EReference)getLink_EnvironmentCondition_Weather().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLink_EnvironmentCondition_TrafficCondition() {
		if (link_EnvironmentCondition_TrafficConditionEClass == null) {
			link_EnvironmentCondition_TrafficConditionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(70);
		}
		return link_EnvironmentCondition_TrafficConditionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLink_EnvironmentCondition_TrafficCondition_Name_link_environmentCondition_trafficCondition() {
        return (EAttribute)getLink_EnvironmentCondition_TrafficCondition().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_EnvironmentCondition_TrafficCondition_Link_environmentCondition() {
        return (EReference)getLink_EnvironmentCondition_TrafficCondition().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_EnvironmentCondition_TrafficCondition_Link_trafficCondition() {
        return (EReference)getLink_EnvironmentCondition_TrafficCondition().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLink_EnvironmentCondition_SpecialCondition() {
		if (link_EnvironmentCondition_SpecialConditionEClass == null) {
			link_EnvironmentCondition_SpecialConditionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(71);
		}
		return link_EnvironmentCondition_SpecialConditionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLink_EnvironmentCondition_SpecialCondition_Name_link_environmentCondition_specialCondition() {
        return (EAttribute)getLink_EnvironmentCondition_SpecialCondition().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_EnvironmentCondition_SpecialCondition_Link_environmentCondition() {
        return (EReference)getLink_EnvironmentCondition_SpecialCondition().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_EnvironmentCondition_SpecialCondition_Link_specialCondition() {
        return (EReference)getLink_EnvironmentCondition_SpecialCondition().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLink_LaneType_Regulation() {
		if (link_LaneType_RegulationEClass == null) {
			link_LaneType_RegulationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(72);
		}
		return link_LaneType_RegulationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLink_LaneType_Regulation_Name_link_laneType_regulation() {
        return (EAttribute)getLink_LaneType_Regulation().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_LaneType_Regulation_Link_laneType() {
        return (EReference)getLink_LaneType_Regulation().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_LaneType_Regulation_Link_regulation() {
        return (EReference)getLink_LaneType_Regulation().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLink_SafetyRequirement_Regulation() {
		if (link_SafetyRequirement_RegulationEClass == null) {
			link_SafetyRequirement_RegulationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(73);
		}
		return link_SafetyRequirement_RegulationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLink_SafetyRequirement_Regulation_Name_link_safetyRequirement_regulation() {
        return (EAttribute)getLink_SafetyRequirement_Regulation().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_SafetyRequirement_Regulation_Link_safetyRequirement() {
        return (EReference)getLink_SafetyRequirement_Regulation().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_SafetyRequirement_Regulation_Link_regulation() {
        return (EReference)getLink_SafetyRequirement_Regulation().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLink_SpecialCondition_Intersection() {
		if (link_SpecialCondition_IntersectionEClass == null) {
			link_SpecialCondition_IntersectionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(74);
		}
		return link_SpecialCondition_IntersectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLink_SpecialCondition_Intersection_Name_link_specialCondition_intersection() {
        return (EAttribute)getLink_SpecialCondition_Intersection().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_SpecialCondition_Intersection_Link_specialCondition() {
        return (EReference)getLink_SpecialCondition_Intersection().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_SpecialCondition_Intersection_Link_intersection() {
        return (EReference)getLink_SpecialCondition_Intersection().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLink_Collision_Obstruction() {
		if (link_Collision_ObstructionEClass == null) {
			link_Collision_ObstructionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(75);
		}
		return link_Collision_ObstructionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLink_Collision_Obstruction_Name_link_collision_obstruction() {
        return (EAttribute)getLink_Collision_Obstruction().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_Collision_Obstruction_Link_collision() {
        return (EReference)getLink_Collision_Obstruction().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_Collision_Obstruction_Link_obstruction() {
        return (EReference)getLink_Collision_Obstruction().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLink_Intersection_TrafficLight() {
		if (link_Intersection_TrafficLightEClass == null) {
			link_Intersection_TrafficLightEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(76);
		}
		return link_Intersection_TrafficLightEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLink_Intersection_TrafficLight_Name_link_intersection_trafficLight() {
        return (EAttribute)getLink_Intersection_TrafficLight().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_Intersection_TrafficLight_Link_intersection() {
        return (EReference)getLink_Intersection_TrafficLight().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_Intersection_TrafficLight_Link_trafficLight() {
        return (EReference)getLink_Intersection_TrafficLight().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInfrastructure() {
		if (infrastructureEClass == null) {
			infrastructureEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(77);
		}
		return infrastructureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInfrastructure_CommunicatesWith() {
        return (EReference)getInfrastructure().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRoadSegment() {
		if (roadSegmentEClass == null) {
			roadSegmentEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(78);
		}
		return roadSegmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSmartSensor() {
		if (smartSensorEClass == null) {
			smartSensorEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(79);
		}
		return smartSensorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSmartSensor_Monitors() {
        return (EReference)getSmartSensor().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRoad_Side_Unit() {
		if (road_Side_UnitEClass == null) {
			road_Side_UnitEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(80);
		}
		return road_Side_UnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getChargingStation() {
		if (chargingStationEClass == null) {
			chargingStationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(81);
		}
		return chargingStationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCommunicationInterface() {
		if (communicationInterfaceEClass == null) {
			communicationInterfaceEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(82);
		}
		return communicationInterfaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCommunicationInterface_Protocol() {
        return (EAttribute)getCommunicationInterface().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCommunicationInterface_Latency() {
        return (EAttribute)getCommunicationInterface().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCommunicationInterface_Bandwidth() {
        return (EAttribute)getCommunicationInterface().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCommunicationInterface_ReliabilityLevel() {
        return (EAttribute)getCommunicationInterface().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCommunicationInterface_Connects_vehicle() {
        return (EReference)getCommunicationInterface().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCommunicationInterface_Connects_infrastructure() {
        return (EReference)getCommunicationInterface().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCooperativeBehavior() {
		if (cooperativeBehaviorEClass == null) {
			cooperativeBehaviorEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(84);
		}
		return cooperativeBehaviorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCooperativeBehavior_DependsOn() {
        return (EReference)getCooperativeBehavior().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCooperativeBehavior_CoordinatedWith() {
        return (EReference)getCooperativeBehavior().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGoal() {
		if (goalEClass == null) {
			goalEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(85);
		}
		return goalEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGoal_GoalType() {
        return (EAttribute)getGoal().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGoal_Priority() {
        return (EAttribute)getGoal().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGoal_IsGoalDriven() {
        return (EAttribute)getGoal().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGoal_IsStimulusDriven() {
        return (EAttribute)getGoal().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLink_Infrastructure_VehicleConfiguration() {
		if (link_Infrastructure_VehicleConfigurationEClass == null) {
			link_Infrastructure_VehicleConfigurationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(86);
		}
		return link_Infrastructure_VehicleConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLink_Infrastructure_VehicleConfiguration_Name_link_infrastructure_vehicleConfiguration() {
        return (EAttribute)getLink_Infrastructure_VehicleConfiguration().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_Infrastructure_VehicleConfiguration_Link_infrastructure() {
        return (EReference)getLink_Infrastructure_VehicleConfiguration().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_Infrastructure_VehicleConfiguration_Link_vehicle_configuration() {
        return (EReference)getLink_Infrastructure_VehicleConfiguration().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLink_CommunicationInterface_VehicleConfiguration() {
		if (link_CommunicationInterface_VehicleConfigurationEClass == null) {
			link_CommunicationInterface_VehicleConfigurationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(87);
		}
		return link_CommunicationInterface_VehicleConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLink_CommunicationInterface_VehicleConfiguration_Name_link_communication_interface_vehicleConfiguration() {
        return (EAttribute)getLink_CommunicationInterface_VehicleConfiguration().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_CommunicationInterface_VehicleConfiguration_Link_communication_interface() {
        return (EReference)getLink_CommunicationInterface_VehicleConfiguration().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_CommunicationInterface_VehicleConfiguration_Link_vehicle_configuration() {
        return (EReference)getLink_CommunicationInterface_VehicleConfiguration().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLink_Goal_DrivingBehaviour() {
		if (link_Goal_DrivingBehaviourEClass == null) {
			link_Goal_DrivingBehaviourEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(88);
		}
		return link_Goal_DrivingBehaviourEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLink_Goal_DrivingBehaviour_Name_link_goal_drivingBehaviour() {
        return (EAttribute)getLink_Goal_DrivingBehaviour().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_Goal_DrivingBehaviour_Link_goal() {
        return (EReference)getLink_Goal_DrivingBehaviour().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_Goal_DrivingBehaviour_Link_drivingBehaviour() {
        return (EReference)getLink_Goal_DrivingBehaviour().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLink_CooperativeBehaviour_CommunicationInterface() {
		if (link_CooperativeBehaviour_CommunicationInterfaceEClass == null) {
			link_CooperativeBehaviour_CommunicationInterfaceEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(89);
		}
		return link_CooperativeBehaviour_CommunicationInterfaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLink_CooperativeBehaviour_CommunicationInterface_Name_link_cooperativeBehaviour_communicationInterface() {
        return (EAttribute)getLink_CooperativeBehaviour_CommunicationInterface().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_CooperativeBehaviour_CommunicationInterface_Link_cooperativeBehaviour() {
        return (EReference)getLink_CooperativeBehaviour_CommunicationInterface().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_CooperativeBehaviour_CommunicationInterface_Link_communicationInterface() {
        return (EReference)getLink_CooperativeBehaviour_CommunicationInterface().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLink_CommunicationInterface_Infrastructure() {
		if (link_CommunicationInterface_InfrastructureEClass == null) {
			link_CommunicationInterface_InfrastructureEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(90);
		}
		return link_CommunicationInterface_InfrastructureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLink_CommunicationInterface_Infrastructure_Name_link_communication_interface_infrastructure() {
        return (EAttribute)getLink_CommunicationInterface_Infrastructure().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_CommunicationInterface_Infrastructure_Link_communicationInterface() {
        return (EReference)getLink_CommunicationInterface_Infrastructure().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_CommunicationInterface_Infrastructure_Link_infrastructure() {
        return (EReference)getLink_CommunicationInterface_Infrastructure().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLink_CooperativeBehaviour_VehicleConfiguration() {
		if (link_CooperativeBehaviour_VehicleConfigurationEClass == null) {
			link_CooperativeBehaviour_VehicleConfigurationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(91);
		}
		return link_CooperativeBehaviour_VehicleConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLink_CooperativeBehaviour_VehicleConfiguration_Name_link_cooperativeBehaviour_vehicleConfiguration() {
        return (EAttribute)getLink_CooperativeBehaviour_VehicleConfiguration().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_CooperativeBehaviour_VehicleConfiguration_Link_cooperativeBehaviour() {
        return (EReference)getLink_CooperativeBehaviour_VehicleConfiguration().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_CooperativeBehaviour_VehicleConfiguration_Link_vehicleConfiguration() {
        return (EReference)getLink_CooperativeBehaviour_VehicleConfiguration().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLink_TrafficSituation_EnvironmentCondition() {
		if (link_TrafficSituation_EnvironmentConditionEClass == null) {
			link_TrafficSituation_EnvironmentConditionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(92);
		}
		return link_TrafficSituation_EnvironmentConditionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLink_TrafficSituation_EnvironmentCondition_Name_link_trafficSituation_environmentCondition() {
        return (EAttribute)getLink_TrafficSituation_EnvironmentCondition().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_TrafficSituation_EnvironmentCondition_Link_trafficSituation() {
        return (EReference)getLink_TrafficSituation_EnvironmentCondition().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_TrafficSituation_EnvironmentCondition_Link_environmentCondition() {
        return (EReference)getLink_TrafficSituation_EnvironmentCondition().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLink_Following_LaneChanging() {
		if (link_Following_LaneChangingEClass == null) {
			link_Following_LaneChangingEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(93);
		}
		return link_Following_LaneChangingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLink_Following_LaneChanging_Name_link_following_laneChanging() {
        return (EAttribute)getLink_Following_LaneChanging().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_Following_LaneChanging_Link_following() {
        return (EReference)getLink_Following_LaneChanging().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_Following_LaneChanging_Link_laneChanging() {
        return (EReference)getLink_Following_LaneChanging().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLink_Collision_SpecialCondition() {
		if (link_Collision_SpecialConditionEClass == null) {
			link_Collision_SpecialConditionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(94);
		}
		return link_Collision_SpecialConditionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLink_Collision_SpecialCondition_Name_link_collision_specialCondition() {
        return (EAttribute)getLink_Collision_SpecialCondition().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_Collision_SpecialCondition_Link_collision() {
        return (EReference)getLink_Collision_SpecialCondition().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_Collision_SpecialCondition_Link_specialCondition() {
        return (EReference)getLink_Collision_SpecialCondition().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLink_Action_Backward() {
		if (link_Action_BackwardEClass == null) {
			link_Action_BackwardEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(95);
		}
		return link_Action_BackwardEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLink_Action_Backward_Name_link_action_backward() {
        return (EAttribute)getLink_Action_Backward().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_Action_Backward_Link_action() {
        return (EReference)getLink_Action_Backward().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_Action_Backward_Link_backward() {
        return (EReference)getLink_Action_Backward().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLink_Action_Forward() {
		if (link_Action_ForwardEClass == null) {
			link_Action_ForwardEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(96);
		}
		return link_Action_ForwardEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLink_Action_Forward_Name_link_action_forward() {
        return (EAttribute)getLink_Action_Forward().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_Action_Forward_Link_action() {
        return (EReference)getLink_Action_Forward().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_Action_Forward_Link_forward() {
        return (EReference)getLink_Action_Forward().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLink_Action_Turn() {
		if (link_Action_TurnEClass == null) {
			link_Action_TurnEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(97);
		}
		return link_Action_TurnEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLink_Action_Turn_Name_link_action_turn() {
        return (EAttribute)getLink_Action_Turn().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_Action_Turn_Link_action() {
        return (EReference)getLink_Action_Turn().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_Action_Turn_Link_turn() {
        return (EReference)getLink_Action_Turn().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLink_KnowledgeAndSkill_DriverPreference() {
		if (link_KnowledgeAndSkill_DriverPreferenceEClass == null) {
			link_KnowledgeAndSkill_DriverPreferenceEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(98);
		}
		return link_KnowledgeAndSkill_DriverPreferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLink_KnowledgeAndSkill_DriverPreference_Name_link_knowledgeAndSkill_driverPreference() {
        return (EAttribute)getLink_KnowledgeAndSkill_DriverPreference().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_KnowledgeAndSkill_DriverPreference_Link_knowledgeAndSkill() {
        return (EReference)getLink_KnowledgeAndSkill_DriverPreference().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_KnowledgeAndSkill_DriverPreference_Link_driverPreference() {
        return (EReference)getLink_KnowledgeAndSkill_DriverPreference().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getDriverType() {
		if (driverTypeEEnum == null) {
			driverTypeEEnum = (EEnum)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(7);
		}
		return driverTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getLanes() {
		if (lanesEEnum == null) {
			lanesEEnum = (EEnum)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(8);
		}
		return lanesEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getDirection() {
		if (directionEEnum == null) {
			directionEEnum = (EEnum)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(17);
		}
		return directionEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getCarType() {
		if (carTypeEEnum == null) {
			carTypeEEnum = (EEnum)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(21);
		}
		return carTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getRoadShape() {
		if (roadShapeEEnum == null) {
			roadShapeEEnum = (EEnum)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(27);
		}
		return roadShapeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getRoadType() {
		if (roadTypeEEnum == null) {
			roadTypeEEnum = (EEnum)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(30);
		}
		return roadTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getTrafficType() {
		if (trafficTypeEEnum == null) {
			trafficTypeEEnum = (EEnum)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(37);
		}
		return trafficTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getProtocolType() {
		if (protocolTypeEEnum == null) {
			protocolTypeEEnum = (EEnum)EPackage.Registry.INSTANCE.getEPackage(IntelligentMobilityPackage.eNS_URI).getEClassifiers().get(83);
		}
		return protocolTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntelligentMobilityFactory getIntelligentMobilityFactory() {
		return (IntelligentMobilityFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isLoaded = false;

	/**
	 * Loads the package and any sub-packages from their serialized form.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void loadPackage() {
		if (isLoaded) return;
		isLoaded = true;

		URL url = getClass().getResource(packageFilename);
		if (url == null) {
			throw new RuntimeException("Missing serialized package: " + packageFilename);
		}
		URI uri = URI.createURI(url.toString());
		Resource resource = new EcoreResourceFactoryImpl().createResource(uri);
		try {
			resource.load(null);
		}
		catch (IOException exception) {
			throw new WrappedException(exception);
		}
		initializeFromLoadedEPackage(this, (EPackage)resource.getContents().get(0));
		createResource(eNS_URI);
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isFixed = false;

	/**
	 * Fixes up the loaded package, to make it appear as if it had been programmatically built.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void fixPackageContents() {
		if (isFixed) return;
		isFixed = true;
		fixEClassifiers();
	}

	/**
	 * Sets the instance class on the given classifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void fixInstanceClass(EClassifier eClassifier) {
		if (eClassifier.getInstanceClassName() == null) {
			eClassifier.setInstanceClassName("intelligentMobility." + eClassifier.getName());
			setGeneratedClassName(eClassifier);
		}
	}

} //IntelligentMobilityPackageImpl
