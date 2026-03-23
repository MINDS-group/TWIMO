/**
 */
package intelligentMobility.util;

import intelligentMobility.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see intelligentMobility.IntelligentMobilityPackage
 * @generated
 */
public class IntelligentMobilityAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static IntelligentMobilityPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntelligentMobilityAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = IntelligentMobilityPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IntelligentMobilitySwitch modelSwitch =
		new IntelligentMobilitySwitch() {
			public Object caseMobilitySystem(MobilitySystem object) {
				return createMobilitySystemAdapter();
			}
			public Object caseDriver_Profile(Driver_Profile object) {
				return createDriver_ProfileAdapter();
			}
			public Object caseVehicle_Configuration(Vehicle_Configuration object) {
				return createVehicle_ConfigurationAdapter();
			}
			public Object caseEnvironment_Background(Environment_Background object) {
				return createEnvironment_BackgroundAdapter();
			}
			public Object caseDriver_Preference(Driver_Preference object) {
				return createDriver_PreferenceAdapter();
			}
			public Object caseKnowledge_and_Skill(Knowledge_and_Skill object) {
				return createKnowledge_and_SkillAdapter();
			}
			public Object caseDriver_Emotion(Driver_Emotion object) {
				return createDriver_EmotionAdapter();
			}
			public Object caseDriving_Behaviour(Driving_Behaviour object) {
				return createDriving_BehaviourAdapter();
			}
			public Object caseNormal_Behaviour(Normal_Behaviour object) {
				return createNormal_BehaviourAdapter();
			}
			public Object caseFollowing(Following object) {
				return createFollowingAdapter();
			}
			public Object caseLaneChanging(LaneChanging object) {
				return createLaneChangingAdapter();
			}
			public Object caseAbnormal_Behaviour(Abnormal_Behaviour object) {
				return createAbnormal_BehaviourAdapter();
			}
			public Object caseForward(Forward object) {
				return createForwardAdapter();
			}
			public Object caseBackward(Backward object) {
				return createBackwardAdapter();
			}
			public Object caseTurn(Turn object) {
				return createTurnAdapter();
			}
			public Object caseGapAcceptance(GapAcceptance object) {
				return createGapAcceptanceAdapter();
			}
			public Object caseAction(Action object) {
				return createActionAdapter();
			}
			public Object caseVehicle_Type(Vehicle_Type object) {
				return createVehicle_TypeAdapter();
			}
			public Object casePlatoon(Platoon object) {
				return createPlatoonAdapter();
			}
			public Object caseNormal_Vehicle(Normal_Vehicle object) {
				return createNormal_VehicleAdapter();
			}
			public Object caseLeading_Vehicle(Leading_Vehicle object) {
				return createLeading_VehicleAdapter();
			}
			public Object caseFollowing_Vehicle(Following_Vehicle object) {
				return createFollowing_VehicleAdapter();
			}
			public Object casePlatoonMember(PlatoonMember object) {
				return createPlatoonMemberAdapter();
			}
			public Object casePossibleVehicle(PossibleVehicle object) {
				return createPossibleVehicleAdapter();
			}
			public Object caseEnvironment_Condition(Environment_Condition object) {
				return createEnvironment_ConditionAdapter();
			}
			public Object caseLane_Type(Lane_Type object) {
				return createLane_TypeAdapter();
			}
			public Object caseRegulation(Regulation object) {
				return createRegulationAdapter();
			}
			public Object caseSafety_Requirement(Safety_Requirement object) {
				return createSafety_RequirementAdapter();
			}
			public Object caseWeather(Weather object) {
				return createWeatherAdapter();
			}
			public Object caseTraffic_Situation(Traffic_Situation object) {
				return createTraffic_SituationAdapter();
			}
			public Object caseSpecial_Condition(Special_Condition object) {
				return createSpecial_ConditionAdapter();
			}
			public Object caseCollision(Collision object) {
				return createCollisionAdapter();
			}
			public Object caseIntersection(Intersection object) {
				return createIntersectionAdapter();
			}
			public Object caseObstruction(Obstruction object) {
				return createObstructionAdapter();
			}
			public Object caseTraffic_Light(Traffic_Light object) {
				return createTraffic_LightAdapter();
			}
			public Object caseExceptionCondition(ExceptionCondition object) {
				return createExceptionConditionAdapter();
			}
			public Object caseLink_Driver_Environment(Link_Driver_Environment object) {
				return createLink_Driver_EnvironmentAdapter();
			}
			public Object caseLink_Driver_Vehicle(Link_Driver_Vehicle object) {
				return createLink_Driver_VehicleAdapter();
			}
			public Object caseLink_Vehicle_Environment(Link_Vehicle_Environment object) {
				return createLink_Vehicle_EnvironmentAdapter();
			}
			public Object caseLink_DriverProfile_DriverPreference(Link_DriverProfile_DriverPreference object) {
				return createLink_DriverProfile_DriverPreferenceAdapter();
			}
			public Object caseLink_VehicleConfiguration_VehicleType(Link_VehicleConfiguration_VehicleType object) {
				return createLink_VehicleConfiguration_VehicleTypeAdapter();
			}
			public Object caseLink_EnvironmentBackground_PossibleVehicle(Link_EnvironmentBackground_PossibleVehicle object) {
				return createLink_EnvironmentBackground_PossibleVehicleAdapter();
			}
			public Object caseLink_EnvironmentBackground_EnvironmentCondition(Link_EnvironmentBackground_EnvironmentCondition object) {
				return createLink_EnvironmentBackground_EnvironmentConditionAdapter();
			}
			public Object caseLink_DriverPreference_DriverEmotion(Link_DriverPreference_DriverEmotion object) {
				return createLink_DriverPreference_DriverEmotionAdapter();
			}
			public Object caseLink_DriverPreference_DrivingBehaviour(Link_DriverPreference_DrivingBehaviour object) {
				return createLink_DriverPreference_DrivingBehaviourAdapter();
			}
			public Object caseLink_DriverPreference_EnvironmentCondition(Link_DriverPreference_EnvironmentCondition object) {
				return createLink_DriverPreference_EnvironmentConditionAdapter();
			}
			public Object caseLink_DrivingBehaviour_NormalBehaviour(Link_DrivingBehaviour_NormalBehaviour object) {
				return createLink_DrivingBehaviour_NormalBehaviourAdapter();
			}
			public Object caseLink_NormalBehaviour_Following(Link_NormalBehaviour_Following object) {
				return createLink_NormalBehaviour_FollowingAdapter();
			}
			public Object caseLink_NormalBehaviour_LaneChanging(Link_NormalBehaviour_LaneChanging object) {
				return createLink_NormalBehaviour_LaneChangingAdapter();
			}
			public Object caseLink_Following_MinGap(Link_Following_MinGap object) {
				return createLink_Following_MinGapAdapter();
			}
			public Object caseLink_Following_Forward(Link_Following_Forward object) {
				return createLink_Following_ForwardAdapter();
			}
			public Object caseLink_Following_Backward(Link_Following_Backward object) {
				return createLink_Following_BackwardAdapter();
			}
			public Object caseLink_LaneChanging_Turn(Link_LaneChanging_Turn object) {
				return createLink_LaneChanging_TurnAdapter();
			}
			public Object caseLink_LaneChanging_GapAcceptance(Link_LaneChanging_GapAcceptance object) {
				return createLink_LaneChanging_GapAcceptanceAdapter();
			}
			public Object caseLink_LaneChanging_EnvironmentCondition(Link_LaneChanging_EnvironmentCondition object) {
				return createLink_LaneChanging_EnvironmentConditionAdapter();
			}
			public Object caseLink_AbnormalBehaviour_Action(Link_AbnormalBehaviour_Action object) {
				return createLink_AbnormalBehaviour_ActionAdapter();
			}
			public Object caseLink_Platoon_LeadingVehicle(Link_Platoon_LeadingVehicle object) {
				return createLink_Platoon_LeadingVehicleAdapter();
			}
			public Object caseLink_Platoon_FollowingVehicle(Link_Platoon_FollowingVehicle object) {
				return createLink_Platoon_FollowingVehicleAdapter();
			}
			public Object caseLink_NormalVehicle_SafetyRequirements(Link_NormalVehicle_SafetyRequirements object) {
				return createLink_NormalVehicle_SafetyRequirementsAdapter();
			}
			public Object caseLink_FollowingVehicle_FrontVehicle(Link_FollowingVehicle_FrontVehicle object) {
				return createLink_FollowingVehicle_FrontVehicleAdapter();
			}
			public Object caseLink_EnvironmentCondition_LaneType(Link_EnvironmentCondition_LaneType object) {
				return createLink_EnvironmentCondition_LaneTypeAdapter();
			}
			public Object caseLink_EnvironmentCondition_Regulations(Link_EnvironmentCondition_Regulations object) {
				return createLink_EnvironmentCondition_RegulationsAdapter();
			}
			public Object caseLink_EnvironmentCondition_Weather(Link_EnvironmentCondition_Weather object) {
				return createLink_EnvironmentCondition_WeatherAdapter();
			}
			public Object caseLink_EnvironmentCondition_TrafficCondition(Link_EnvironmentCondition_TrafficCondition object) {
				return createLink_EnvironmentCondition_TrafficConditionAdapter();
			}
			public Object caseLink_EnvironmentCondition_SpecialCondition(Link_EnvironmentCondition_SpecialCondition object) {
				return createLink_EnvironmentCondition_SpecialConditionAdapter();
			}
			public Object caseLink_LaneType_Regulation(Link_LaneType_Regulation object) {
				return createLink_LaneType_RegulationAdapter();
			}
			public Object caseLink_SafetyRequirement_Regulation(Link_SafetyRequirement_Regulation object) {
				return createLink_SafetyRequirement_RegulationAdapter();
			}
			public Object caseLink_SpecialCondition_Intersection(Link_SpecialCondition_Intersection object) {
				return createLink_SpecialCondition_IntersectionAdapter();
			}
			public Object caseLink_Collision_Obstruction(Link_Collision_Obstruction object) {
				return createLink_Collision_ObstructionAdapter();
			}
			public Object caseLink_Intersection_TrafficLight(Link_Intersection_TrafficLight object) {
				return createLink_Intersection_TrafficLightAdapter();
			}
			public Object caseInfrastructure(Infrastructure object) {
				return createInfrastructureAdapter();
			}
			public Object caseRoadSegment(RoadSegment object) {
				return createRoadSegmentAdapter();
			}
			public Object caseSmartSensor(SmartSensor object) {
				return createSmartSensorAdapter();
			}
			public Object caseRoad_Side_Unit(Road_Side_Unit object) {
				return createRoad_Side_UnitAdapter();
			}
			public Object caseChargingStation(ChargingStation object) {
				return createChargingStationAdapter();
			}
			public Object caseCommunicationInterface(CommunicationInterface object) {
				return createCommunicationInterfaceAdapter();
			}
			public Object caseCooperativeBehavior(CooperativeBehavior object) {
				return createCooperativeBehaviorAdapter();
			}
			public Object caseGoal(Goal object) {
				return createGoalAdapter();
			}
			public Object caseLink_Infrastructure_VehicleConfiguration(Link_Infrastructure_VehicleConfiguration object) {
				return createLink_Infrastructure_VehicleConfigurationAdapter();
			}
			public Object caseLink_CommunicationInterface_VehicleConfiguration(Link_CommunicationInterface_VehicleConfiguration object) {
				return createLink_CommunicationInterface_VehicleConfigurationAdapter();
			}
			public Object caseLink_Goal_DrivingBehaviour(Link_Goal_DrivingBehaviour object) {
				return createLink_Goal_DrivingBehaviourAdapter();
			}
			public Object caseLink_CooperativeBehaviour_CommunicationInterface(Link_CooperativeBehaviour_CommunicationInterface object) {
				return createLink_CooperativeBehaviour_CommunicationInterfaceAdapter();
			}
			public Object caseLink_CommunicationInterface_Infrastructure(Link_CommunicationInterface_Infrastructure object) {
				return createLink_CommunicationInterface_InfrastructureAdapter();
			}
			public Object caseLink_CooperativeBehaviour_VehicleConfiguration(Link_CooperativeBehaviour_VehicleConfiguration object) {
				return createLink_CooperativeBehaviour_VehicleConfigurationAdapter();
			}
			public Object caseLink_TrafficSituation_EnvironmentCondition(Link_TrafficSituation_EnvironmentCondition object) {
				return createLink_TrafficSituation_EnvironmentConditionAdapter();
			}
			public Object caseLink_Following_LaneChanging(Link_Following_LaneChanging object) {
				return createLink_Following_LaneChangingAdapter();
			}
			public Object caseLink_Collision_SpecialCondition(Link_Collision_SpecialCondition object) {
				return createLink_Collision_SpecialConditionAdapter();
			}
			public Object caseLink_Action_Backward(Link_Action_Backward object) {
				return createLink_Action_BackwardAdapter();
			}
			public Object caseLink_Action_Forward(Link_Action_Forward object) {
				return createLink_Action_ForwardAdapter();
			}
			public Object caseLink_Action_Turn(Link_Action_Turn object) {
				return createLink_Action_TurnAdapter();
			}
			public Object caseLink_KnowledgeAndSkill_DriverPreference(Link_KnowledgeAndSkill_DriverPreference object) {
				return createLink_KnowledgeAndSkill_DriverPreferenceAdapter();
			}
			public Object defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	public Adapter createAdapter(Notifier target) {
		return (Adapter)modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link intelligentMobility.MobilitySystem <em>Mobility System</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see intelligentMobility.MobilitySystem
	 * @generated
	 */
	public Adapter createMobilitySystemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link intelligentMobility.Driver_Profile <em>Driver Profile</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see intelligentMobility.Driver_Profile
	 * @generated
	 */
	public Adapter createDriver_ProfileAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link intelligentMobility.Vehicle_Configuration <em>Vehicle Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see intelligentMobility.Vehicle_Configuration
	 * @generated
	 */
	public Adapter createVehicle_ConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link intelligentMobility.Environment_Background <em>Environment Background</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see intelligentMobility.Environment_Background
	 * @generated
	 */
	public Adapter createEnvironment_BackgroundAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link intelligentMobility.Driver_Preference <em>Driver Preference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see intelligentMobility.Driver_Preference
	 * @generated
	 */
	public Adapter createDriver_PreferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link intelligentMobility.Knowledge_and_Skill <em>Knowledge and Skill</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see intelligentMobility.Knowledge_and_Skill
	 * @generated
	 */
	public Adapter createKnowledge_and_SkillAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link intelligentMobility.Driver_Emotion <em>Driver Emotion</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see intelligentMobility.Driver_Emotion
	 * @generated
	 */
	public Adapter createDriver_EmotionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link intelligentMobility.Driving_Behaviour <em>Driving Behaviour</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see intelligentMobility.Driving_Behaviour
	 * @generated
	 */
	public Adapter createDriving_BehaviourAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link intelligentMobility.Normal_Behaviour <em>Normal Behaviour</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see intelligentMobility.Normal_Behaviour
	 * @generated
	 */
	public Adapter createNormal_BehaviourAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link intelligentMobility.Following <em>Following</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see intelligentMobility.Following
	 * @generated
	 */
	public Adapter createFollowingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link intelligentMobility.LaneChanging <em>Lane Changing</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see intelligentMobility.LaneChanging
	 * @generated
	 */
	public Adapter createLaneChangingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link intelligentMobility.Abnormal_Behaviour <em>Abnormal Behaviour</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see intelligentMobility.Abnormal_Behaviour
	 * @generated
	 */
	public Adapter createAbnormal_BehaviourAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link intelligentMobility.Forward <em>Forward</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see intelligentMobility.Forward
	 * @generated
	 */
	public Adapter createForwardAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link intelligentMobility.Backward <em>Backward</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see intelligentMobility.Backward
	 * @generated
	 */
	public Adapter createBackwardAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link intelligentMobility.Turn <em>Turn</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see intelligentMobility.Turn
	 * @generated
	 */
	public Adapter createTurnAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link intelligentMobility.GapAcceptance <em>Gap Acceptance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see intelligentMobility.GapAcceptance
	 * @generated
	 */
	public Adapter createGapAcceptanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link intelligentMobility.Action <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see intelligentMobility.Action
	 * @generated
	 */
	public Adapter createActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link intelligentMobility.Vehicle_Type <em>Vehicle Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see intelligentMobility.Vehicle_Type
	 * @generated
	 */
	public Adapter createVehicle_TypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link intelligentMobility.Platoon <em>Platoon</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see intelligentMobility.Platoon
	 * @generated
	 */
	public Adapter createPlatoonAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link intelligentMobility.Normal_Vehicle <em>Normal Vehicle</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see intelligentMobility.Normal_Vehicle
	 * @generated
	 */
	public Adapter createNormal_VehicleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link intelligentMobility.Leading_Vehicle <em>Leading Vehicle</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see intelligentMobility.Leading_Vehicle
	 * @generated
	 */
	public Adapter createLeading_VehicleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link intelligentMobility.Following_Vehicle <em>Following Vehicle</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see intelligentMobility.Following_Vehicle
	 * @generated
	 */
	public Adapter createFollowing_VehicleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link intelligentMobility.PlatoonMember <em>Platoon Member</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see intelligentMobility.PlatoonMember
	 * @generated
	 */
	public Adapter createPlatoonMemberAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link intelligentMobility.PossibleVehicle <em>Possible Vehicle</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see intelligentMobility.PossibleVehicle
	 * @generated
	 */
	public Adapter createPossibleVehicleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link intelligentMobility.Environment_Condition <em>Environment Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see intelligentMobility.Environment_Condition
	 * @generated
	 */
	public Adapter createEnvironment_ConditionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link intelligentMobility.Lane_Type <em>Lane Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see intelligentMobility.Lane_Type
	 * @generated
	 */
	public Adapter createLane_TypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link intelligentMobility.Regulation <em>Regulation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see intelligentMobility.Regulation
	 * @generated
	 */
	public Adapter createRegulationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link intelligentMobility.Safety_Requirement <em>Safety Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see intelligentMobility.Safety_Requirement
	 * @generated
	 */
	public Adapter createSafety_RequirementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link intelligentMobility.Weather <em>Weather</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see intelligentMobility.Weather
	 * @generated
	 */
	public Adapter createWeatherAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link intelligentMobility.Traffic_Situation <em>Traffic Situation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see intelligentMobility.Traffic_Situation
	 * @generated
	 */
	public Adapter createTraffic_SituationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link intelligentMobility.Special_Condition <em>Special Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see intelligentMobility.Special_Condition
	 * @generated
	 */
	public Adapter createSpecial_ConditionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link intelligentMobility.Collision <em>Collision</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see intelligentMobility.Collision
	 * @generated
	 */
	public Adapter createCollisionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link intelligentMobility.Intersection <em>Intersection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see intelligentMobility.Intersection
	 * @generated
	 */
	public Adapter createIntersectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link intelligentMobility.Obstruction <em>Obstruction</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see intelligentMobility.Obstruction
	 * @generated
	 */
	public Adapter createObstructionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link intelligentMobility.Traffic_Light <em>Traffic Light</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see intelligentMobility.Traffic_Light
	 * @generated
	 */
	public Adapter createTraffic_LightAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link intelligentMobility.ExceptionCondition <em>Exception Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see intelligentMobility.ExceptionCondition
	 * @generated
	 */
	public Adapter createExceptionConditionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link intelligentMobility.Link_Driver_Environment <em>Link Driver Environment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see intelligentMobility.Link_Driver_Environment
	 * @generated
	 */
	public Adapter createLink_Driver_EnvironmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link intelligentMobility.Link_Driver_Vehicle <em>Link Driver Vehicle</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see intelligentMobility.Link_Driver_Vehicle
	 * @generated
	 */
	public Adapter createLink_Driver_VehicleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link intelligentMobility.Link_Vehicle_Environment <em>Link Vehicle Environment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see intelligentMobility.Link_Vehicle_Environment
	 * @generated
	 */
	public Adapter createLink_Vehicle_EnvironmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link intelligentMobility.Link_DriverProfile_DriverPreference <em>Link Driver Profile Driver Preference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see intelligentMobility.Link_DriverProfile_DriverPreference
	 * @generated
	 */
	public Adapter createLink_DriverProfile_DriverPreferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link intelligentMobility.Link_VehicleConfiguration_VehicleType <em>Link Vehicle Configuration Vehicle Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see intelligentMobility.Link_VehicleConfiguration_VehicleType
	 * @generated
	 */
	public Adapter createLink_VehicleConfiguration_VehicleTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link intelligentMobility.Link_EnvironmentBackground_PossibleVehicle <em>Link Environment Background Possible Vehicle</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see intelligentMobility.Link_EnvironmentBackground_PossibleVehicle
	 * @generated
	 */
	public Adapter createLink_EnvironmentBackground_PossibleVehicleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link intelligentMobility.Link_EnvironmentBackground_EnvironmentCondition <em>Link Environment Background Environment Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see intelligentMobility.Link_EnvironmentBackground_EnvironmentCondition
	 * @generated
	 */
	public Adapter createLink_EnvironmentBackground_EnvironmentConditionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link intelligentMobility.Link_DriverPreference_DriverEmotion <em>Link Driver Preference Driver Emotion</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see intelligentMobility.Link_DriverPreference_DriverEmotion
	 * @generated
	 */
	public Adapter createLink_DriverPreference_DriverEmotionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link intelligentMobility.Link_DriverPreference_DrivingBehaviour <em>Link Driver Preference Driving Behaviour</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see intelligentMobility.Link_DriverPreference_DrivingBehaviour
	 * @generated
	 */
	public Adapter createLink_DriverPreference_DrivingBehaviourAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link intelligentMobility.Link_DriverPreference_EnvironmentCondition <em>Link Driver Preference Environment Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see intelligentMobility.Link_DriverPreference_EnvironmentCondition
	 * @generated
	 */
	public Adapter createLink_DriverPreference_EnvironmentConditionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link intelligentMobility.Link_DrivingBehaviour_NormalBehaviour <em>Link Driving Behaviour Normal Behaviour</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see intelligentMobility.Link_DrivingBehaviour_NormalBehaviour
	 * @generated
	 */
	public Adapter createLink_DrivingBehaviour_NormalBehaviourAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link intelligentMobility.Link_NormalBehaviour_Following <em>Link Normal Behaviour Following</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see intelligentMobility.Link_NormalBehaviour_Following
	 * @generated
	 */
	public Adapter createLink_NormalBehaviour_FollowingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link intelligentMobility.Link_NormalBehaviour_LaneChanging <em>Link Normal Behaviour Lane Changing</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see intelligentMobility.Link_NormalBehaviour_LaneChanging
	 * @generated
	 */
	public Adapter createLink_NormalBehaviour_LaneChangingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link intelligentMobility.Link_Following_MinGap <em>Link Following Min Gap</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see intelligentMobility.Link_Following_MinGap
	 * @generated
	 */
	public Adapter createLink_Following_MinGapAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link intelligentMobility.Link_Following_Forward <em>Link Following Forward</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see intelligentMobility.Link_Following_Forward
	 * @generated
	 */
	public Adapter createLink_Following_ForwardAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link intelligentMobility.Link_Following_Backward <em>Link Following Backward</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see intelligentMobility.Link_Following_Backward
	 * @generated
	 */
	public Adapter createLink_Following_BackwardAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link intelligentMobility.Link_LaneChanging_Turn <em>Link Lane Changing Turn</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see intelligentMobility.Link_LaneChanging_Turn
	 * @generated
	 */
	public Adapter createLink_LaneChanging_TurnAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link intelligentMobility.Link_LaneChanging_GapAcceptance <em>Link Lane Changing Gap Acceptance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see intelligentMobility.Link_LaneChanging_GapAcceptance
	 * @generated
	 */
	public Adapter createLink_LaneChanging_GapAcceptanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link intelligentMobility.Link_LaneChanging_EnvironmentCondition <em>Link Lane Changing Environment Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see intelligentMobility.Link_LaneChanging_EnvironmentCondition
	 * @generated
	 */
	public Adapter createLink_LaneChanging_EnvironmentConditionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link intelligentMobility.Link_AbnormalBehaviour_Action <em>Link Abnormal Behaviour Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see intelligentMobility.Link_AbnormalBehaviour_Action
	 * @generated
	 */
	public Adapter createLink_AbnormalBehaviour_ActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link intelligentMobility.Link_Platoon_LeadingVehicle <em>Link Platoon Leading Vehicle</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see intelligentMobility.Link_Platoon_LeadingVehicle
	 * @generated
	 */
	public Adapter createLink_Platoon_LeadingVehicleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link intelligentMobility.Link_Platoon_FollowingVehicle <em>Link Platoon Following Vehicle</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see intelligentMobility.Link_Platoon_FollowingVehicle
	 * @generated
	 */
	public Adapter createLink_Platoon_FollowingVehicleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link intelligentMobility.Link_NormalVehicle_SafetyRequirements <em>Link Normal Vehicle Safety Requirements</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see intelligentMobility.Link_NormalVehicle_SafetyRequirements
	 * @generated
	 */
	public Adapter createLink_NormalVehicle_SafetyRequirementsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link intelligentMobility.Link_FollowingVehicle_FrontVehicle <em>Link Following Vehicle Front Vehicle</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see intelligentMobility.Link_FollowingVehicle_FrontVehicle
	 * @generated
	 */
	public Adapter createLink_FollowingVehicle_FrontVehicleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link intelligentMobility.Link_EnvironmentCondition_LaneType <em>Link Environment Condition Lane Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see intelligentMobility.Link_EnvironmentCondition_LaneType
	 * @generated
	 */
	public Adapter createLink_EnvironmentCondition_LaneTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link intelligentMobility.Link_EnvironmentCondition_Regulations <em>Link Environment Condition Regulations</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see intelligentMobility.Link_EnvironmentCondition_Regulations
	 * @generated
	 */
	public Adapter createLink_EnvironmentCondition_RegulationsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link intelligentMobility.Link_EnvironmentCondition_Weather <em>Link Environment Condition Weather</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see intelligentMobility.Link_EnvironmentCondition_Weather
	 * @generated
	 */
	public Adapter createLink_EnvironmentCondition_WeatherAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link intelligentMobility.Link_EnvironmentCondition_TrafficCondition <em>Link Environment Condition Traffic Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see intelligentMobility.Link_EnvironmentCondition_TrafficCondition
	 * @generated
	 */
	public Adapter createLink_EnvironmentCondition_TrafficConditionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link intelligentMobility.Link_EnvironmentCondition_SpecialCondition <em>Link Environment Condition Special Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see intelligentMobility.Link_EnvironmentCondition_SpecialCondition
	 * @generated
	 */
	public Adapter createLink_EnvironmentCondition_SpecialConditionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link intelligentMobility.Link_LaneType_Regulation <em>Link Lane Type Regulation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see intelligentMobility.Link_LaneType_Regulation
	 * @generated
	 */
	public Adapter createLink_LaneType_RegulationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link intelligentMobility.Link_SafetyRequirement_Regulation <em>Link Safety Requirement Regulation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see intelligentMobility.Link_SafetyRequirement_Regulation
	 * @generated
	 */
	public Adapter createLink_SafetyRequirement_RegulationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link intelligentMobility.Link_SpecialCondition_Intersection <em>Link Special Condition Intersection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see intelligentMobility.Link_SpecialCondition_Intersection
	 * @generated
	 */
	public Adapter createLink_SpecialCondition_IntersectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link intelligentMobility.Link_Collision_Obstruction <em>Link Collision Obstruction</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see intelligentMobility.Link_Collision_Obstruction
	 * @generated
	 */
	public Adapter createLink_Collision_ObstructionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link intelligentMobility.Link_Intersection_TrafficLight <em>Link Intersection Traffic Light</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see intelligentMobility.Link_Intersection_TrafficLight
	 * @generated
	 */
	public Adapter createLink_Intersection_TrafficLightAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link intelligentMobility.Infrastructure <em>Infrastructure</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see intelligentMobility.Infrastructure
	 * @generated
	 */
	public Adapter createInfrastructureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link intelligentMobility.RoadSegment <em>Road Segment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see intelligentMobility.RoadSegment
	 * @generated
	 */
	public Adapter createRoadSegmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link intelligentMobility.SmartSensor <em>Smart Sensor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see intelligentMobility.SmartSensor
	 * @generated
	 */
	public Adapter createSmartSensorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link intelligentMobility.Road_Side_Unit <em>Road Side Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see intelligentMobility.Road_Side_Unit
	 * @generated
	 */
	public Adapter createRoad_Side_UnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link intelligentMobility.ChargingStation <em>Charging Station</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see intelligentMobility.ChargingStation
	 * @generated
	 */
	public Adapter createChargingStationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link intelligentMobility.CommunicationInterface <em>Communication Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see intelligentMobility.CommunicationInterface
	 * @generated
	 */
	public Adapter createCommunicationInterfaceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link intelligentMobility.CooperativeBehavior <em>Cooperative Behavior</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see intelligentMobility.CooperativeBehavior
	 * @generated
	 */
	public Adapter createCooperativeBehaviorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link intelligentMobility.Goal <em>Goal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see intelligentMobility.Goal
	 * @generated
	 */
	public Adapter createGoalAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link intelligentMobility.Link_Infrastructure_VehicleConfiguration <em>Link Infrastructure Vehicle Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see intelligentMobility.Link_Infrastructure_VehicleConfiguration
	 * @generated
	 */
	public Adapter createLink_Infrastructure_VehicleConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link intelligentMobility.Link_CommunicationInterface_VehicleConfiguration <em>Link Communication Interface Vehicle Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see intelligentMobility.Link_CommunicationInterface_VehicleConfiguration
	 * @generated
	 */
	public Adapter createLink_CommunicationInterface_VehicleConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link intelligentMobility.Link_Goal_DrivingBehaviour <em>Link Goal Driving Behaviour</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see intelligentMobility.Link_Goal_DrivingBehaviour
	 * @generated
	 */
	public Adapter createLink_Goal_DrivingBehaviourAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link intelligentMobility.Link_CooperativeBehaviour_CommunicationInterface <em>Link Cooperative Behaviour Communication Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see intelligentMobility.Link_CooperativeBehaviour_CommunicationInterface
	 * @generated
	 */
	public Adapter createLink_CooperativeBehaviour_CommunicationInterfaceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link intelligentMobility.Link_CommunicationInterface_Infrastructure <em>Link Communication Interface Infrastructure</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see intelligentMobility.Link_CommunicationInterface_Infrastructure
	 * @generated
	 */
	public Adapter createLink_CommunicationInterface_InfrastructureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link intelligentMobility.Link_CooperativeBehaviour_VehicleConfiguration <em>Link Cooperative Behaviour Vehicle Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see intelligentMobility.Link_CooperativeBehaviour_VehicleConfiguration
	 * @generated
	 */
	public Adapter createLink_CooperativeBehaviour_VehicleConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link intelligentMobility.Link_TrafficSituation_EnvironmentCondition <em>Link Traffic Situation Environment Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see intelligentMobility.Link_TrafficSituation_EnvironmentCondition
	 * @generated
	 */
	public Adapter createLink_TrafficSituation_EnvironmentConditionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link intelligentMobility.Link_Following_LaneChanging <em>Link Following Lane Changing</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see intelligentMobility.Link_Following_LaneChanging
	 * @generated
	 */
	public Adapter createLink_Following_LaneChangingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link intelligentMobility.Link_Collision_SpecialCondition <em>Link Collision Special Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see intelligentMobility.Link_Collision_SpecialCondition
	 * @generated
	 */
	public Adapter createLink_Collision_SpecialConditionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link intelligentMobility.Link_Action_Backward <em>Link Action Backward</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see intelligentMobility.Link_Action_Backward
	 * @generated
	 */
	public Adapter createLink_Action_BackwardAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link intelligentMobility.Link_Action_Forward <em>Link Action Forward</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see intelligentMobility.Link_Action_Forward
	 * @generated
	 */
	public Adapter createLink_Action_ForwardAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link intelligentMobility.Link_Action_Turn <em>Link Action Turn</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see intelligentMobility.Link_Action_Turn
	 * @generated
	 */
	public Adapter createLink_Action_TurnAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link intelligentMobility.Link_KnowledgeAndSkill_DriverPreference <em>Link Knowledge And Skill Driver Preference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see intelligentMobility.Link_KnowledgeAndSkill_DriverPreference
	 * @generated
	 */
	public Adapter createLink_KnowledgeAndSkill_DriverPreferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //IntelligentMobilityAdapterFactory
