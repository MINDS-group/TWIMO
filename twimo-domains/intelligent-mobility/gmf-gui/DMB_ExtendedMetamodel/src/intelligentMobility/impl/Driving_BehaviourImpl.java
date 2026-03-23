/**
 */
package intelligentMobility.impl;

import intelligentMobility.Driving_Behaviour;
import intelligentMobility.Goal;
import intelligentMobility.IntelligentMobilityPackage;
import intelligentMobility.Normal_Behaviour;

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
 * An implementation of the model object '<em><b>Driving Behaviour</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.impl.Driving_BehaviourImpl#getPrepDistanceForDestination <em>Prep Distance For Destination</em>}</li>
 *   <li>{@link intelligentMobility.impl.Driving_BehaviourImpl#getPrepDistanceForTurn <em>Prep Distance For Turn</em>}</li>
 *   <li>{@link intelligentMobility.impl.Driving_BehaviourImpl#getInitialSpeed_min <em>Initial Speed min</em>}</li>
 *   <li>{@link intelligentMobility.impl.Driving_BehaviourImpl#getInitialSpeed_max <em>Initial Speed max</em>}</li>
 *   <li>{@link intelligentMobility.impl.Driving_BehaviourImpl#getInitialSpeed_precision <em>Initial Speed precision</em>}</li>
 *   <li>{@link intelligentMobility.impl.Driving_BehaviourImpl#getDesiredSpeed_min <em>Desired Speed min</em>}</li>
 *   <li>{@link intelligentMobility.impl.Driving_BehaviourImpl#getDesiredSpeed_max <em>Desired Speed max</em>}</li>
 *   <li>{@link intelligentMobility.impl.Driving_BehaviourImpl#getName <em>Name</em>}</li>
 *   <li>{@link intelligentMobility.impl.Driving_BehaviourImpl#getNormal_behaviour <em>Normal behaviour</em>}</li>
 *   <li>{@link intelligentMobility.impl.Driving_BehaviourImpl#getSteeringAngle <em>Steering Angle</em>}</li>
 *   <li>{@link intelligentMobility.impl.Driving_BehaviourImpl#getThrottle <em>Throttle</em>}</li>
 *   <li>{@link intelligentMobility.impl.Driving_BehaviourImpl#getBrake <em>Brake</em>}</li>
 *   <li>{@link intelligentMobility.impl.Driving_BehaviourImpl#getGear <em>Gear</em>}</li>
 *   <li>{@link intelligentMobility.impl.Driving_BehaviourImpl#getHandbrake <em>Handbrake</em>}</li>
 *   <li>{@link intelligentMobility.impl.Driving_BehaviourImpl#getRpm <em>Rpm</em>}</li>
 *   <li>{@link intelligentMobility.impl.Driving_BehaviourImpl#getKeyEvent <em>Key Event</em>}</li>
 *   <li>{@link intelligentMobility.impl.Driving_BehaviourImpl#getPedalAngle <em>Pedal Angle</em>}</li>
 *   <li>{@link intelligentMobility.impl.Driving_BehaviourImpl#getPedalPressure <em>Pedal Pressure</em>}</li>
 *   <li>{@link intelligentMobility.impl.Driving_BehaviourImpl#getSteerSpeed <em>Steer Speed</em>}</li>
 *   <li>{@link intelligentMobility.impl.Driving_BehaviourImpl#getIntentType <em>Intent Type</em>}</li>
 *   <li>{@link intelligentMobility.impl.Driving_BehaviourImpl#getConfidence <em>Confidence</em>}</li>
 *   <li>{@link intelligentMobility.impl.Driving_BehaviourImpl#getGoal <em>Goal</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Driving_BehaviourImpl extends MinimalEObjectImpl.Container implements Driving_Behaviour {
	/**
	 * The default value of the '{@link #getPrepDistanceForDestination() <em>Prep Distance For Destination</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrepDistanceForDestination()
	 * @generated
	 * @ordered
	 */
	protected static final double PREP_DISTANCE_FOR_DESTINATION_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getPrepDistanceForDestination() <em>Prep Distance For Destination</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrepDistanceForDestination()
	 * @generated
	 * @ordered
	 */
	protected double prepDistanceForDestination = PREP_DISTANCE_FOR_DESTINATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getPrepDistanceForTurn() <em>Prep Distance For Turn</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrepDistanceForTurn()
	 * @generated
	 * @ordered
	 */
	protected static final double PREP_DISTANCE_FOR_TURN_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getPrepDistanceForTurn() <em>Prep Distance For Turn</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrepDistanceForTurn()
	 * @generated
	 * @ordered
	 */
	protected double prepDistanceForTurn = PREP_DISTANCE_FOR_TURN_EDEFAULT;

	/**
	 * The default value of the '{@link #getInitialSpeed_min() <em>Initial Speed min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialSpeed_min()
	 * @generated
	 * @ordered
	 */
	protected static final double INITIAL_SPEED_MIN_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getInitialSpeed_min() <em>Initial Speed min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialSpeed_min()
	 * @generated
	 * @ordered
	 */
	protected double initialSpeed_min = INITIAL_SPEED_MIN_EDEFAULT;

	/**
	 * The default value of the '{@link #getInitialSpeed_max() <em>Initial Speed max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialSpeed_max()
	 * @generated
	 * @ordered
	 */
	protected static final double INITIAL_SPEED_MAX_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getInitialSpeed_max() <em>Initial Speed max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialSpeed_max()
	 * @generated
	 * @ordered
	 */
	protected double initialSpeed_max = INITIAL_SPEED_MAX_EDEFAULT;

	/**
	 * The default value of the '{@link #getInitialSpeed_precision() <em>Initial Speed precision</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialSpeed_precision()
	 * @generated
	 * @ordered
	 */
	protected static final int INITIAL_SPEED_PRECISION_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getInitialSpeed_precision() <em>Initial Speed precision</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialSpeed_precision()
	 * @generated
	 * @ordered
	 */
	protected int initialSpeed_precision = INITIAL_SPEED_PRECISION_EDEFAULT;

	/**
	 * The default value of the '{@link #getDesiredSpeed_min() <em>Desired Speed min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDesiredSpeed_min()
	 * @generated
	 * @ordered
	 */
	protected static final int DESIRED_SPEED_MIN_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getDesiredSpeed_min() <em>Desired Speed min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDesiredSpeed_min()
	 * @generated
	 * @ordered
	 */
	protected int desiredSpeed_min = DESIRED_SPEED_MIN_EDEFAULT;

	/**
	 * The default value of the '{@link #getDesiredSpeed_max() <em>Desired Speed max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDesiredSpeed_max()
	 * @generated
	 * @ordered
	 */
	protected static final int DESIRED_SPEED_MAX_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getDesiredSpeed_max() <em>Desired Speed max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDesiredSpeed_max()
	 * @generated
	 * @ordered
	 */
	protected int desiredSpeed_max = DESIRED_SPEED_MAX_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getNormal_behaviour() <em>Normal behaviour</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNormal_behaviour()
	 * @generated
	 * @ordered
	 */
	protected Normal_Behaviour normal_behaviour;

	/**
	 * The default value of the '{@link #getSteeringAngle() <em>Steering Angle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSteeringAngle()
	 * @generated
	 * @ordered
	 */
	protected static final double STEERING_ANGLE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getSteeringAngle() <em>Steering Angle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSteeringAngle()
	 * @generated
	 * @ordered
	 */
	protected double steeringAngle = STEERING_ANGLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getThrottle() <em>Throttle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThrottle()
	 * @generated
	 * @ordered
	 */
	protected static final int THROTTLE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getThrottle() <em>Throttle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThrottle()
	 * @generated
	 * @ordered
	 */
	protected int throttle = THROTTLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getBrake() <em>Brake</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBrake()
	 * @generated
	 * @ordered
	 */
	protected static final int BRAKE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getBrake() <em>Brake</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBrake()
	 * @generated
	 * @ordered
	 */
	protected int brake = BRAKE_EDEFAULT;

	/**
	 * The default value of the '{@link #getGear() <em>Gear</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGear()
	 * @generated
	 * @ordered
	 */
	protected static final int GEAR_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getGear() <em>Gear</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGear()
	 * @generated
	 * @ordered
	 */
	protected int gear = GEAR_EDEFAULT;

	/**
	 * The default value of the '{@link #getHandbrake() <em>Handbrake</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHandbrake()
	 * @generated
	 * @ordered
	 */
	protected static final int HANDBRAKE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getHandbrake() <em>Handbrake</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHandbrake()
	 * @generated
	 * @ordered
	 */
	protected int handbrake = HANDBRAKE_EDEFAULT;

	/**
	 * The default value of the '{@link #getRpm() <em>Rpm</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRpm()
	 * @generated
	 * @ordered
	 */
	protected static final double RPM_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getRpm() <em>Rpm</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRpm()
	 * @generated
	 * @ordered
	 */
	protected double rpm = RPM_EDEFAULT;

	/**
	 * The default value of the '{@link #getKeyEvent() <em>Key Event</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKeyEvent()
	 * @generated
	 * @ordered
	 */
	protected static final int KEY_EVENT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getKeyEvent() <em>Key Event</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKeyEvent()
	 * @generated
	 * @ordered
	 */
	protected int keyEvent = KEY_EVENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getPedalAngle() <em>Pedal Angle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPedalAngle()
	 * @generated
	 * @ordered
	 */
	protected static final double PEDAL_ANGLE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getPedalAngle() <em>Pedal Angle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPedalAngle()
	 * @generated
	 * @ordered
	 */
	protected double pedalAngle = PEDAL_ANGLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getPedalPressure() <em>Pedal Pressure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPedalPressure()
	 * @generated
	 * @ordered
	 */
	protected static final double PEDAL_PRESSURE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getPedalPressure() <em>Pedal Pressure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPedalPressure()
	 * @generated
	 * @ordered
	 */
	protected double pedalPressure = PEDAL_PRESSURE_EDEFAULT;

	/**
	 * The default value of the '{@link #getSteerSpeed() <em>Steer Speed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSteerSpeed()
	 * @generated
	 * @ordered
	 */
	protected static final int STEER_SPEED_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSteerSpeed() <em>Steer Speed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSteerSpeed()
	 * @generated
	 * @ordered
	 */
	protected int steerSpeed = STEER_SPEED_EDEFAULT;

	/**
	 * The default value of the '{@link #getIntentType() <em>Intent Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntentType()
	 * @generated
	 * @ordered
	 */
	protected static final String INTENT_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIntentType() <em>Intent Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntentType()
	 * @generated
	 * @ordered
	 */
	protected String intentType = INTENT_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getConfidence() <em>Confidence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfidence()
	 * @generated
	 * @ordered
	 */
	protected static final float CONFIDENCE_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getConfidence() <em>Confidence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfidence()
	 * @generated
	 * @ordered
	 */
	protected float confidence = CONFIDENCE_EDEFAULT;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Driving_BehaviourImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return IntelligentMobilityPackage.eINSTANCE.getDriving_Behaviour();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getPrepDistanceForDestination() {
		return prepDistanceForDestination;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrepDistanceForDestination(double newPrepDistanceForDestination) {
		double oldPrepDistanceForDestination = prepDistanceForDestination;
		prepDistanceForDestination = newPrepDistanceForDestination;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.DRIVING_BEHAVIOUR__PREP_DISTANCE_FOR_DESTINATION, oldPrepDistanceForDestination, prepDistanceForDestination));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getPrepDistanceForTurn() {
		return prepDistanceForTurn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrepDistanceForTurn(double newPrepDistanceForTurn) {
		double oldPrepDistanceForTurn = prepDistanceForTurn;
		prepDistanceForTurn = newPrepDistanceForTurn;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.DRIVING_BEHAVIOUR__PREP_DISTANCE_FOR_TURN, oldPrepDistanceForTurn, prepDistanceForTurn));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getInitialSpeed_min() {
		return initialSpeed_min;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitialSpeed_min(double newInitialSpeed_min) {
		double oldInitialSpeed_min = initialSpeed_min;
		initialSpeed_min = newInitialSpeed_min;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.DRIVING_BEHAVIOUR__INITIAL_SPEED_MIN, oldInitialSpeed_min, initialSpeed_min));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getInitialSpeed_max() {
		return initialSpeed_max;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitialSpeed_max(double newInitialSpeed_max) {
		double oldInitialSpeed_max = initialSpeed_max;
		initialSpeed_max = newInitialSpeed_max;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.DRIVING_BEHAVIOUR__INITIAL_SPEED_MAX, oldInitialSpeed_max, initialSpeed_max));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getInitialSpeed_precision() {
		return initialSpeed_precision;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitialSpeed_precision(int newInitialSpeed_precision) {
		int oldInitialSpeed_precision = initialSpeed_precision;
		initialSpeed_precision = newInitialSpeed_precision;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.DRIVING_BEHAVIOUR__INITIAL_SPEED_PRECISION, oldInitialSpeed_precision, initialSpeed_precision));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getDesiredSpeed_min() {
		return desiredSpeed_min;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDesiredSpeed_min(int newDesiredSpeed_min) {
		int oldDesiredSpeed_min = desiredSpeed_min;
		desiredSpeed_min = newDesiredSpeed_min;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.DRIVING_BEHAVIOUR__DESIRED_SPEED_MIN, oldDesiredSpeed_min, desiredSpeed_min));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getDesiredSpeed_max() {
		return desiredSpeed_max;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDesiredSpeed_max(int newDesiredSpeed_max) {
		int oldDesiredSpeed_max = desiredSpeed_max;
		desiredSpeed_max = newDesiredSpeed_max;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.DRIVING_BEHAVIOUR__DESIRED_SPEED_MAX, oldDesiredSpeed_max, desiredSpeed_max));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.DRIVING_BEHAVIOUR__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Normal_Behaviour getNormal_behaviour() {
		return normal_behaviour;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNormal_behaviour(Normal_Behaviour newNormal_behaviour, NotificationChain msgs) {
		Normal_Behaviour oldNormal_behaviour = normal_behaviour;
		normal_behaviour = newNormal_behaviour;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.DRIVING_BEHAVIOUR__NORMAL_BEHAVIOUR, oldNormal_behaviour, newNormal_behaviour);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNormal_behaviour(Normal_Behaviour newNormal_behaviour) {
		if (newNormal_behaviour != normal_behaviour) {
			NotificationChain msgs = null;
			if (normal_behaviour != null)
				msgs = ((InternalEObject)normal_behaviour).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IntelligentMobilityPackage.DRIVING_BEHAVIOUR__NORMAL_BEHAVIOUR, null, msgs);
			if (newNormal_behaviour != null)
				msgs = ((InternalEObject)newNormal_behaviour).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IntelligentMobilityPackage.DRIVING_BEHAVIOUR__NORMAL_BEHAVIOUR, null, msgs);
			msgs = basicSetNormal_behaviour(newNormal_behaviour, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.DRIVING_BEHAVIOUR__NORMAL_BEHAVIOUR, newNormal_behaviour, newNormal_behaviour));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getSteeringAngle() {
		return steeringAngle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSteeringAngle(double newSteeringAngle) {
		double oldSteeringAngle = steeringAngle;
		steeringAngle = newSteeringAngle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.DRIVING_BEHAVIOUR__STEERING_ANGLE, oldSteeringAngle, steeringAngle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getThrottle() {
		return throttle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThrottle(int newThrottle) {
		int oldThrottle = throttle;
		throttle = newThrottle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.DRIVING_BEHAVIOUR__THROTTLE, oldThrottle, throttle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getBrake() {
		return brake;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBrake(int newBrake) {
		int oldBrake = brake;
		brake = newBrake;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.DRIVING_BEHAVIOUR__BRAKE, oldBrake, brake));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getGear() {
		return gear;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGear(int newGear) {
		int oldGear = gear;
		gear = newGear;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.DRIVING_BEHAVIOUR__GEAR, oldGear, gear));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getHandbrake() {
		return handbrake;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHandbrake(int newHandbrake) {
		int oldHandbrake = handbrake;
		handbrake = newHandbrake;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.DRIVING_BEHAVIOUR__HANDBRAKE, oldHandbrake, handbrake));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getRpm() {
		return rpm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRpm(double newRpm) {
		double oldRpm = rpm;
		rpm = newRpm;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.DRIVING_BEHAVIOUR__RPM, oldRpm, rpm));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getKeyEvent() {
		return keyEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKeyEvent(int newKeyEvent) {
		int oldKeyEvent = keyEvent;
		keyEvent = newKeyEvent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.DRIVING_BEHAVIOUR__KEY_EVENT, oldKeyEvent, keyEvent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getPedalAngle() {
		return pedalAngle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPedalAngle(double newPedalAngle) {
		double oldPedalAngle = pedalAngle;
		pedalAngle = newPedalAngle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.DRIVING_BEHAVIOUR__PEDAL_ANGLE, oldPedalAngle, pedalAngle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getPedalPressure() {
		return pedalPressure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPedalPressure(double newPedalPressure) {
		double oldPedalPressure = pedalPressure;
		pedalPressure = newPedalPressure;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.DRIVING_BEHAVIOUR__PEDAL_PRESSURE, oldPedalPressure, pedalPressure));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSteerSpeed() {
		return steerSpeed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSteerSpeed(int newSteerSpeed) {
		int oldSteerSpeed = steerSpeed;
		steerSpeed = newSteerSpeed;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.DRIVING_BEHAVIOUR__STEER_SPEED, oldSteerSpeed, steerSpeed));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIntentType() {
		return intentType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIntentType(String newIntentType) {
		String oldIntentType = intentType;
		intentType = newIntentType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.DRIVING_BEHAVIOUR__INTENT_TYPE, oldIntentType, intentType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getConfidence() {
		return confidence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConfidence(float newConfidence) {
		float oldConfidence = confidence;
		confidence = newConfidence;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.DRIVING_BEHAVIOUR__CONFIDENCE, oldConfidence, confidence));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getGoal() {
		if (goal == null) {
			goal = new EObjectContainmentEList(Goal.class, this, IntelligentMobilityPackage.DRIVING_BEHAVIOUR__GOAL);
		}
		return goal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__NORMAL_BEHAVIOUR:
				return basicSetNormal_behaviour(null, msgs);
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__GOAL:
				return ((InternalEList)getGoal()).basicRemove(otherEnd, msgs);
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
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__PREP_DISTANCE_FOR_DESTINATION:
				return new Double(getPrepDistanceForDestination());
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__PREP_DISTANCE_FOR_TURN:
				return new Double(getPrepDistanceForTurn());
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__INITIAL_SPEED_MIN:
				return new Double(getInitialSpeed_min());
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__INITIAL_SPEED_MAX:
				return new Double(getInitialSpeed_max());
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__INITIAL_SPEED_PRECISION:
				return new Integer(getInitialSpeed_precision());
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__DESIRED_SPEED_MIN:
				return new Integer(getDesiredSpeed_min());
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__DESIRED_SPEED_MAX:
				return new Integer(getDesiredSpeed_max());
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__NAME:
				return getName();
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__NORMAL_BEHAVIOUR:
				return getNormal_behaviour();
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__STEERING_ANGLE:
				return new Double(getSteeringAngle());
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__THROTTLE:
				return new Integer(getThrottle());
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__BRAKE:
				return new Integer(getBrake());
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__GEAR:
				return new Integer(getGear());
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__HANDBRAKE:
				return new Integer(getHandbrake());
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__RPM:
				return new Double(getRpm());
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__KEY_EVENT:
				return new Integer(getKeyEvent());
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__PEDAL_ANGLE:
				return new Double(getPedalAngle());
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__PEDAL_PRESSURE:
				return new Double(getPedalPressure());
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__STEER_SPEED:
				return new Integer(getSteerSpeed());
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__INTENT_TYPE:
				return getIntentType();
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__CONFIDENCE:
				return new Float(getConfidence());
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__GOAL:
				return getGoal();
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
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__PREP_DISTANCE_FOR_DESTINATION:
				setPrepDistanceForDestination(((Double)newValue).doubleValue());
				return;
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__PREP_DISTANCE_FOR_TURN:
				setPrepDistanceForTurn(((Double)newValue).doubleValue());
				return;
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__INITIAL_SPEED_MIN:
				setInitialSpeed_min(((Double)newValue).doubleValue());
				return;
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__INITIAL_SPEED_MAX:
				setInitialSpeed_max(((Double)newValue).doubleValue());
				return;
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__INITIAL_SPEED_PRECISION:
				setInitialSpeed_precision(((Integer)newValue).intValue());
				return;
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__DESIRED_SPEED_MIN:
				setDesiredSpeed_min(((Integer)newValue).intValue());
				return;
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__DESIRED_SPEED_MAX:
				setDesiredSpeed_max(((Integer)newValue).intValue());
				return;
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__NAME:
				setName((String)newValue);
				return;
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__NORMAL_BEHAVIOUR:
				setNormal_behaviour((Normal_Behaviour)newValue);
				return;
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__STEERING_ANGLE:
				setSteeringAngle(((Double)newValue).doubleValue());
				return;
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__THROTTLE:
				setThrottle(((Integer)newValue).intValue());
				return;
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__BRAKE:
				setBrake(((Integer)newValue).intValue());
				return;
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__GEAR:
				setGear(((Integer)newValue).intValue());
				return;
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__HANDBRAKE:
				setHandbrake(((Integer)newValue).intValue());
				return;
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__RPM:
				setRpm(((Double)newValue).doubleValue());
				return;
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__KEY_EVENT:
				setKeyEvent(((Integer)newValue).intValue());
				return;
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__PEDAL_ANGLE:
				setPedalAngle(((Double)newValue).doubleValue());
				return;
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__PEDAL_PRESSURE:
				setPedalPressure(((Double)newValue).doubleValue());
				return;
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__STEER_SPEED:
				setSteerSpeed(((Integer)newValue).intValue());
				return;
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__INTENT_TYPE:
				setIntentType((String)newValue);
				return;
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__CONFIDENCE:
				setConfidence(((Float)newValue).floatValue());
				return;
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__GOAL:
				getGoal().clear();
				getGoal().addAll((Collection)newValue);
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
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__PREP_DISTANCE_FOR_DESTINATION:
				setPrepDistanceForDestination(PREP_DISTANCE_FOR_DESTINATION_EDEFAULT);
				return;
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__PREP_DISTANCE_FOR_TURN:
				setPrepDistanceForTurn(PREP_DISTANCE_FOR_TURN_EDEFAULT);
				return;
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__INITIAL_SPEED_MIN:
				setInitialSpeed_min(INITIAL_SPEED_MIN_EDEFAULT);
				return;
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__INITIAL_SPEED_MAX:
				setInitialSpeed_max(INITIAL_SPEED_MAX_EDEFAULT);
				return;
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__INITIAL_SPEED_PRECISION:
				setInitialSpeed_precision(INITIAL_SPEED_PRECISION_EDEFAULT);
				return;
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__DESIRED_SPEED_MIN:
				setDesiredSpeed_min(DESIRED_SPEED_MIN_EDEFAULT);
				return;
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__DESIRED_SPEED_MAX:
				setDesiredSpeed_max(DESIRED_SPEED_MAX_EDEFAULT);
				return;
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__NAME:
				setName(NAME_EDEFAULT);
				return;
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__NORMAL_BEHAVIOUR:
				setNormal_behaviour((Normal_Behaviour)null);
				return;
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__STEERING_ANGLE:
				setSteeringAngle(STEERING_ANGLE_EDEFAULT);
				return;
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__THROTTLE:
				setThrottle(THROTTLE_EDEFAULT);
				return;
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__BRAKE:
				setBrake(BRAKE_EDEFAULT);
				return;
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__GEAR:
				setGear(GEAR_EDEFAULT);
				return;
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__HANDBRAKE:
				setHandbrake(HANDBRAKE_EDEFAULT);
				return;
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__RPM:
				setRpm(RPM_EDEFAULT);
				return;
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__KEY_EVENT:
				setKeyEvent(KEY_EVENT_EDEFAULT);
				return;
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__PEDAL_ANGLE:
				setPedalAngle(PEDAL_ANGLE_EDEFAULT);
				return;
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__PEDAL_PRESSURE:
				setPedalPressure(PEDAL_PRESSURE_EDEFAULT);
				return;
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__STEER_SPEED:
				setSteerSpeed(STEER_SPEED_EDEFAULT);
				return;
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__INTENT_TYPE:
				setIntentType(INTENT_TYPE_EDEFAULT);
				return;
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__CONFIDENCE:
				setConfidence(CONFIDENCE_EDEFAULT);
				return;
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__GOAL:
				getGoal().clear();
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
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__PREP_DISTANCE_FOR_DESTINATION:
				return prepDistanceForDestination != PREP_DISTANCE_FOR_DESTINATION_EDEFAULT;
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__PREP_DISTANCE_FOR_TURN:
				return prepDistanceForTurn != PREP_DISTANCE_FOR_TURN_EDEFAULT;
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__INITIAL_SPEED_MIN:
				return initialSpeed_min != INITIAL_SPEED_MIN_EDEFAULT;
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__INITIAL_SPEED_MAX:
				return initialSpeed_max != INITIAL_SPEED_MAX_EDEFAULT;
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__INITIAL_SPEED_PRECISION:
				return initialSpeed_precision != INITIAL_SPEED_PRECISION_EDEFAULT;
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__DESIRED_SPEED_MIN:
				return desiredSpeed_min != DESIRED_SPEED_MIN_EDEFAULT;
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__DESIRED_SPEED_MAX:
				return desiredSpeed_max != DESIRED_SPEED_MAX_EDEFAULT;
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__NORMAL_BEHAVIOUR:
				return normal_behaviour != null;
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__STEERING_ANGLE:
				return steeringAngle != STEERING_ANGLE_EDEFAULT;
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__THROTTLE:
				return throttle != THROTTLE_EDEFAULT;
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__BRAKE:
				return brake != BRAKE_EDEFAULT;
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__GEAR:
				return gear != GEAR_EDEFAULT;
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__HANDBRAKE:
				return handbrake != HANDBRAKE_EDEFAULT;
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__RPM:
				return rpm != RPM_EDEFAULT;
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__KEY_EVENT:
				return keyEvent != KEY_EVENT_EDEFAULT;
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__PEDAL_ANGLE:
				return pedalAngle != PEDAL_ANGLE_EDEFAULT;
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__PEDAL_PRESSURE:
				return pedalPressure != PEDAL_PRESSURE_EDEFAULT;
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__STEER_SPEED:
				return steerSpeed != STEER_SPEED_EDEFAULT;
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__INTENT_TYPE:
				return INTENT_TYPE_EDEFAULT == null ? intentType != null : !INTENT_TYPE_EDEFAULT.equals(intentType);
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__CONFIDENCE:
				return confidence != CONFIDENCE_EDEFAULT;
			case IntelligentMobilityPackage.DRIVING_BEHAVIOUR__GOAL:
				return goal != null && !goal.isEmpty();
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
		result.append(" (prepDistanceForDestination: ");
		result.append(prepDistanceForDestination);
		result.append(", prepDistanceForTurn: ");
		result.append(prepDistanceForTurn);
		result.append(", initialSpeed_min: ");
		result.append(initialSpeed_min);
		result.append(", initialSpeed_max: ");
		result.append(initialSpeed_max);
		result.append(", initialSpeed_precision: ");
		result.append(initialSpeed_precision);
		result.append(", desiredSpeed_min: ");
		result.append(desiredSpeed_min);
		result.append(", desiredSpeed_max: ");
		result.append(desiredSpeed_max);
		result.append(", name: ");
		result.append(name);
		result.append(", steeringAngle: ");
		result.append(steeringAngle);
		result.append(", throttle: ");
		result.append(throttle);
		result.append(", brake: ");
		result.append(brake);
		result.append(", gear: ");
		result.append(gear);
		result.append(", handbrake: ");
		result.append(handbrake);
		result.append(", rpm: ");
		result.append(rpm);
		result.append(", keyEvent: ");
		result.append(keyEvent);
		result.append(", pedalAngle: ");
		result.append(pedalAngle);
		result.append(", pedalPressure: ");
		result.append(pedalPressure);
		result.append(", steerSpeed: ");
		result.append(steerSpeed);
		result.append(", intentType: ");
		result.append(intentType);
		result.append(", confidence: ");
		result.append(confidence);
		result.append(')');
		return result.toString();
	}

} //Driving_BehaviourImpl
