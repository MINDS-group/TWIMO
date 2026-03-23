/**
 */
package intelligentMobility;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Driving Behaviour</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.Driving_Behaviour#getPrepDistanceForDestination <em>Prep Distance For Destination</em>}</li>
 *   <li>{@link intelligentMobility.Driving_Behaviour#getPrepDistanceForTurn <em>Prep Distance For Turn</em>}</li>
 *   <li>{@link intelligentMobility.Driving_Behaviour#getInitialSpeed_min <em>Initial Speed min</em>}</li>
 *   <li>{@link intelligentMobility.Driving_Behaviour#getInitialSpeed_max <em>Initial Speed max</em>}</li>
 *   <li>{@link intelligentMobility.Driving_Behaviour#getInitialSpeed_precision <em>Initial Speed precision</em>}</li>
 *   <li>{@link intelligentMobility.Driving_Behaviour#getDesiredSpeed_min <em>Desired Speed min</em>}</li>
 *   <li>{@link intelligentMobility.Driving_Behaviour#getDesiredSpeed_max <em>Desired Speed max</em>}</li>
 *   <li>{@link intelligentMobility.Driving_Behaviour#getName <em>Name</em>}</li>
 *   <li>{@link intelligentMobility.Driving_Behaviour#getNormal_behaviour <em>Normal behaviour</em>}</li>
 *   <li>{@link intelligentMobility.Driving_Behaviour#getSteeringAngle <em>Steering Angle</em>}</li>
 *   <li>{@link intelligentMobility.Driving_Behaviour#getThrottle <em>Throttle</em>}</li>
 *   <li>{@link intelligentMobility.Driving_Behaviour#getBrake <em>Brake</em>}</li>
 *   <li>{@link intelligentMobility.Driving_Behaviour#getGear <em>Gear</em>}</li>
 *   <li>{@link intelligentMobility.Driving_Behaviour#getHandbrake <em>Handbrake</em>}</li>
 *   <li>{@link intelligentMobility.Driving_Behaviour#getRpm <em>Rpm</em>}</li>
 *   <li>{@link intelligentMobility.Driving_Behaviour#getKeyEvent <em>Key Event</em>}</li>
 *   <li>{@link intelligentMobility.Driving_Behaviour#getPedalAngle <em>Pedal Angle</em>}</li>
 *   <li>{@link intelligentMobility.Driving_Behaviour#getPedalPressure <em>Pedal Pressure</em>}</li>
 *   <li>{@link intelligentMobility.Driving_Behaviour#getSteerSpeed <em>Steer Speed</em>}</li>
 *   <li>{@link intelligentMobility.Driving_Behaviour#getIntentType <em>Intent Type</em>}</li>
 *   <li>{@link intelligentMobility.Driving_Behaviour#getConfidence <em>Confidence</em>}</li>
 *   <li>{@link intelligentMobility.Driving_Behaviour#getGoal <em>Goal</em>}</li>
 * </ul>
 *
 * @see intelligentMobility.IntelligentMobilityPackage#getDriving_Behaviour()
 * @model
 * @generated
 */
public interface Driving_Behaviour extends EObject {
	/**
	 * Returns the value of the '<em><b>Prep Distance For Destination</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Prep Distance For Destination</em>' attribute.
	 * @see #setPrepDistanceForDestination(double)
	 * @see intelligentMobility.IntelligentMobilityPackage#getDriving_Behaviour_PrepDistanceForDestination()
	 * @model
	 * @generated
	 */
	double getPrepDistanceForDestination();

	/**
	 * Sets the value of the '{@link intelligentMobility.Driving_Behaviour#getPrepDistanceForDestination <em>Prep Distance For Destination</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Prep Distance For Destination</em>' attribute.
	 * @see #getPrepDistanceForDestination()
	 * @generated
	 */
	void setPrepDistanceForDestination(double value);

	/**
	 * Returns the value of the '<em><b>Prep Distance For Turn</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Prep Distance For Turn</em>' attribute.
	 * @see #setPrepDistanceForTurn(double)
	 * @see intelligentMobility.IntelligentMobilityPackage#getDriving_Behaviour_PrepDistanceForTurn()
	 * @model
	 * @generated
	 */
	double getPrepDistanceForTurn();

	/**
	 * Sets the value of the '{@link intelligentMobility.Driving_Behaviour#getPrepDistanceForTurn <em>Prep Distance For Turn</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Prep Distance For Turn</em>' attribute.
	 * @see #getPrepDistanceForTurn()
	 * @generated
	 */
	void setPrepDistanceForTurn(double value);

	/**
	 * Returns the value of the '<em><b>Initial Speed min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initial Speed min</em>' attribute.
	 * @see #setInitialSpeed_min(double)
	 * @see intelligentMobility.IntelligentMobilityPackage#getDriving_Behaviour_InitialSpeed_min()
	 * @model
	 * @generated
	 */
	double getInitialSpeed_min();

	/**
	 * Sets the value of the '{@link intelligentMobility.Driving_Behaviour#getInitialSpeed_min <em>Initial Speed min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initial Speed min</em>' attribute.
	 * @see #getInitialSpeed_min()
	 * @generated
	 */
	void setInitialSpeed_min(double value);

	/**
	 * Returns the value of the '<em><b>Initial Speed max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initial Speed max</em>' attribute.
	 * @see #setInitialSpeed_max(double)
	 * @see intelligentMobility.IntelligentMobilityPackage#getDriving_Behaviour_InitialSpeed_max()
	 * @model
	 * @generated
	 */
	double getInitialSpeed_max();

	/**
	 * Sets the value of the '{@link intelligentMobility.Driving_Behaviour#getInitialSpeed_max <em>Initial Speed max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initial Speed max</em>' attribute.
	 * @see #getInitialSpeed_max()
	 * @generated
	 */
	void setInitialSpeed_max(double value);

	/**
	 * Returns the value of the '<em><b>Initial Speed precision</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initial Speed precision</em>' attribute.
	 * @see #setInitialSpeed_precision(int)
	 * @see intelligentMobility.IntelligentMobilityPackage#getDriving_Behaviour_InitialSpeed_precision()
	 * @model
	 * @generated
	 */
	int getInitialSpeed_precision();

	/**
	 * Sets the value of the '{@link intelligentMobility.Driving_Behaviour#getInitialSpeed_precision <em>Initial Speed precision</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initial Speed precision</em>' attribute.
	 * @see #getInitialSpeed_precision()
	 * @generated
	 */
	void setInitialSpeed_precision(int value);

	/**
	 * Returns the value of the '<em><b>Desired Speed min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Desired Speed min</em>' attribute.
	 * @see #setDesiredSpeed_min(int)
	 * @see intelligentMobility.IntelligentMobilityPackage#getDriving_Behaviour_DesiredSpeed_min()
	 * @model
	 * @generated
	 */
	int getDesiredSpeed_min();

	/**
	 * Sets the value of the '{@link intelligentMobility.Driving_Behaviour#getDesiredSpeed_min <em>Desired Speed min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Desired Speed min</em>' attribute.
	 * @see #getDesiredSpeed_min()
	 * @generated
	 */
	void setDesiredSpeed_min(int value);

	/**
	 * Returns the value of the '<em><b>Desired Speed max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Desired Speed max</em>' attribute.
	 * @see #setDesiredSpeed_max(int)
	 * @see intelligentMobility.IntelligentMobilityPackage#getDriving_Behaviour_DesiredSpeed_max()
	 * @model
	 * @generated
	 */
	int getDesiredSpeed_max();

	/**
	 * Sets the value of the '{@link intelligentMobility.Driving_Behaviour#getDesiredSpeed_max <em>Desired Speed max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Desired Speed max</em>' attribute.
	 * @see #getDesiredSpeed_max()
	 * @generated
	 */
	void setDesiredSpeed_max(int value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see intelligentMobility.IntelligentMobilityPackage#getDriving_Behaviour_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link intelligentMobility.Driving_Behaviour#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Normal behaviour</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Normal behaviour</em>' containment reference.
	 * @see #setNormal_behaviour(Normal_Behaviour)
	 * @see intelligentMobility.IntelligentMobilityPackage#getDriving_Behaviour_Normal_behaviour()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Normal_Behaviour getNormal_behaviour();

	/**
	 * Sets the value of the '{@link intelligentMobility.Driving_Behaviour#getNormal_behaviour <em>Normal behaviour</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Normal behaviour</em>' containment reference.
	 * @see #getNormal_behaviour()
	 * @generated
	 */
	void setNormal_behaviour(Normal_Behaviour value);

	/**
	 * Returns the value of the '<em><b>Steering Angle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Steering Angle</em>' attribute.
	 * @see #setSteeringAngle(double)
	 * @see intelligentMobility.IntelligentMobilityPackage#getDriving_Behaviour_SteeringAngle()
	 * @model
	 * @generated
	 */
	double getSteeringAngle();

	/**
	 * Sets the value of the '{@link intelligentMobility.Driving_Behaviour#getSteeringAngle <em>Steering Angle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Steering Angle</em>' attribute.
	 * @see #getSteeringAngle()
	 * @generated
	 */
	void setSteeringAngle(double value);

	/**
	 * Returns the value of the '<em><b>Throttle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Throttle</em>' attribute.
	 * @see #setThrottle(int)
	 * @see intelligentMobility.IntelligentMobilityPackage#getDriving_Behaviour_Throttle()
	 * @model
	 * @generated
	 */
	int getThrottle();

	/**
	 * Sets the value of the '{@link intelligentMobility.Driving_Behaviour#getThrottle <em>Throttle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Throttle</em>' attribute.
	 * @see #getThrottle()
	 * @generated
	 */
	void setThrottle(int value);

	/**
	 * Returns the value of the '<em><b>Brake</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Brake</em>' attribute.
	 * @see #setBrake(int)
	 * @see intelligentMobility.IntelligentMobilityPackage#getDriving_Behaviour_Brake()
	 * @model
	 * @generated
	 */
	int getBrake();

	/**
	 * Sets the value of the '{@link intelligentMobility.Driving_Behaviour#getBrake <em>Brake</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Brake</em>' attribute.
	 * @see #getBrake()
	 * @generated
	 */
	void setBrake(int value);

	/**
	 * Returns the value of the '<em><b>Gear</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gear</em>' attribute.
	 * @see #setGear(int)
	 * @see intelligentMobility.IntelligentMobilityPackage#getDriving_Behaviour_Gear()
	 * @model
	 * @generated
	 */
	int getGear();

	/**
	 * Sets the value of the '{@link intelligentMobility.Driving_Behaviour#getGear <em>Gear</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Gear</em>' attribute.
	 * @see #getGear()
	 * @generated
	 */
	void setGear(int value);

	/**
	 * Returns the value of the '<em><b>Handbrake</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Handbrake</em>' attribute.
	 * @see #setHandbrake(int)
	 * @see intelligentMobility.IntelligentMobilityPackage#getDriving_Behaviour_Handbrake()
	 * @model
	 * @generated
	 */
	int getHandbrake();

	/**
	 * Sets the value of the '{@link intelligentMobility.Driving_Behaviour#getHandbrake <em>Handbrake</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Handbrake</em>' attribute.
	 * @see #getHandbrake()
	 * @generated
	 */
	void setHandbrake(int value);

	/**
	 * Returns the value of the '<em><b>Rpm</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rpm</em>' attribute.
	 * @see #setRpm(double)
	 * @see intelligentMobility.IntelligentMobilityPackage#getDriving_Behaviour_Rpm()
	 * @model
	 * @generated
	 */
	double getRpm();

	/**
	 * Sets the value of the '{@link intelligentMobility.Driving_Behaviour#getRpm <em>Rpm</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rpm</em>' attribute.
	 * @see #getRpm()
	 * @generated
	 */
	void setRpm(double value);

	/**
	 * Returns the value of the '<em><b>Key Event</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Key Event</em>' attribute.
	 * @see #setKeyEvent(int)
	 * @see intelligentMobility.IntelligentMobilityPackage#getDriving_Behaviour_KeyEvent()
	 * @model
	 * @generated
	 */
	int getKeyEvent();

	/**
	 * Sets the value of the '{@link intelligentMobility.Driving_Behaviour#getKeyEvent <em>Key Event</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Key Event</em>' attribute.
	 * @see #getKeyEvent()
	 * @generated
	 */
	void setKeyEvent(int value);

	/**
	 * Returns the value of the '<em><b>Pedal Angle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pedal Angle</em>' attribute.
	 * @see #setPedalAngle(double)
	 * @see intelligentMobility.IntelligentMobilityPackage#getDriving_Behaviour_PedalAngle()
	 * @model
	 * @generated
	 */
	double getPedalAngle();

	/**
	 * Sets the value of the '{@link intelligentMobility.Driving_Behaviour#getPedalAngle <em>Pedal Angle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pedal Angle</em>' attribute.
	 * @see #getPedalAngle()
	 * @generated
	 */
	void setPedalAngle(double value);

	/**
	 * Returns the value of the '<em><b>Pedal Pressure</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pedal Pressure</em>' attribute.
	 * @see #setPedalPressure(double)
	 * @see intelligentMobility.IntelligentMobilityPackage#getDriving_Behaviour_PedalPressure()
	 * @model
	 * @generated
	 */
	double getPedalPressure();

	/**
	 * Sets the value of the '{@link intelligentMobility.Driving_Behaviour#getPedalPressure <em>Pedal Pressure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pedal Pressure</em>' attribute.
	 * @see #getPedalPressure()
	 * @generated
	 */
	void setPedalPressure(double value);

	/**
	 * Returns the value of the '<em><b>Steer Speed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Steer Speed</em>' attribute.
	 * @see #setSteerSpeed(int)
	 * @see intelligentMobility.IntelligentMobilityPackage#getDriving_Behaviour_SteerSpeed()
	 * @model
	 * @generated
	 */
	int getSteerSpeed();

	/**
	 * Sets the value of the '{@link intelligentMobility.Driving_Behaviour#getSteerSpeed <em>Steer Speed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Steer Speed</em>' attribute.
	 * @see #getSteerSpeed()
	 * @generated
	 */
	void setSteerSpeed(int value);

	/**
	 * Returns the value of the '<em><b>Intent Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Intent Type</em>' attribute.
	 * @see #setIntentType(String)
	 * @see intelligentMobility.IntelligentMobilityPackage#getDriving_Behaviour_IntentType()
	 * @model
	 * @generated
	 */
	String getIntentType();

	/**
	 * Sets the value of the '{@link intelligentMobility.Driving_Behaviour#getIntentType <em>Intent Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Intent Type</em>' attribute.
	 * @see #getIntentType()
	 * @generated
	 */
	void setIntentType(String value);

	/**
	 * Returns the value of the '<em><b>Confidence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Confidence</em>' attribute.
	 * @see #setConfidence(float)
	 * @see intelligentMobility.IntelligentMobilityPackage#getDriving_Behaviour_Confidence()
	 * @model
	 * @generated
	 */
	float getConfidence();

	/**
	 * Sets the value of the '{@link intelligentMobility.Driving_Behaviour#getConfidence <em>Confidence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Confidence</em>' attribute.
	 * @see #getConfidence()
	 * @generated
	 */
	void setConfidence(float value);

	/**
	 * Returns the value of the '<em><b>Goal</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Goal}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Goal</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getDriving_Behaviour_Goal()
	 * @model type="intelligentMobility.Goal" containment="true"
	 * @generated
	 */
	EList getGoal();

} // Driving_Behaviour
