/**
 */
package intelligentMobility.impl;

import intelligentMobility.CarType;
import intelligentMobility.IntelligentMobilityPackage;
import intelligentMobility.Vehicle_Type;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Vehicle Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.impl.Vehicle_TypeImpl#getType <em>Type</em>}</li>
 *   <li>{@link intelligentMobility.impl.Vehicle_TypeImpl#getMaxSpeed <em>Max Speed</em>}</li>
 *   <li>{@link intelligentMobility.impl.Vehicle_TypeImpl#getVehicleWidth_min <em>Vehicle Width min</em>}</li>
 *   <li>{@link intelligentMobility.impl.Vehicle_TypeImpl#getVehicleWidth_max <em>Vehicle Width max</em>}</li>
 *   <li>{@link intelligentMobility.impl.Vehicle_TypeImpl#getVehicleWidth_precision <em>Vehicle Width precision</em>}</li>
 *   <li>{@link intelligentMobility.impl.Vehicle_TypeImpl#getVehicleLength_min <em>Vehicle Length min</em>}</li>
 *   <li>{@link intelligentMobility.impl.Vehicle_TypeImpl#getVehicleLength_max <em>Vehicle Length max</em>}</li>
 *   <li>{@link intelligentMobility.impl.Vehicle_TypeImpl#getVehicleLength_precision <em>Vehicle Length precision</em>}</li>
 *   <li>{@link intelligentMobility.impl.Vehicle_TypeImpl#getVehicleHeight_min <em>Vehicle Height min</em>}</li>
 *   <li>{@link intelligentMobility.impl.Vehicle_TypeImpl#getVehicleHeight_max <em>Vehicle Height max</em>}</li>
 *   <li>{@link intelligentMobility.impl.Vehicle_TypeImpl#getVehicleHeight_precision <em>Vehicle Height precision</em>}</li>
 *   <li>{@link intelligentMobility.impl.Vehicle_TypeImpl#getSpeed <em>Speed</em>}</li>
 *   <li>{@link intelligentMobility.impl.Vehicle_TypeImpl#getStop <em>Stop</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class Vehicle_TypeImpl extends MinimalEObjectImpl.Container implements Vehicle_Type {
	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final CarType TYPE_EDEFAULT = CarType.NORMAL_CAR_LITERAL;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected CarType type = TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxSpeed() <em>Max Speed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxSpeed()
	 * @generated
	 * @ordered
	 */
	protected static final double MAX_SPEED_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getMaxSpeed() <em>Max Speed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxSpeed()
	 * @generated
	 * @ordered
	 */
	protected double maxSpeed = MAX_SPEED_EDEFAULT;

	/**
	 * The default value of the '{@link #getVehicleWidth_min() <em>Vehicle Width min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVehicleWidth_min()
	 * @generated
	 * @ordered
	 */
	protected static final double VEHICLE_WIDTH_MIN_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getVehicleWidth_min() <em>Vehicle Width min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVehicleWidth_min()
	 * @generated
	 * @ordered
	 */
	protected double vehicleWidth_min = VEHICLE_WIDTH_MIN_EDEFAULT;

	/**
	 * The default value of the '{@link #getVehicleWidth_max() <em>Vehicle Width max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVehicleWidth_max()
	 * @generated
	 * @ordered
	 */
	protected static final double VEHICLE_WIDTH_MAX_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getVehicleWidth_max() <em>Vehicle Width max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVehicleWidth_max()
	 * @generated
	 * @ordered
	 */
	protected double vehicleWidth_max = VEHICLE_WIDTH_MAX_EDEFAULT;

	/**
	 * The default value of the '{@link #getVehicleWidth_precision() <em>Vehicle Width precision</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVehicleWidth_precision()
	 * @generated
	 * @ordered
	 */
	protected static final int VEHICLE_WIDTH_PRECISION_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getVehicleWidth_precision() <em>Vehicle Width precision</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVehicleWidth_precision()
	 * @generated
	 * @ordered
	 */
	protected int vehicleWidth_precision = VEHICLE_WIDTH_PRECISION_EDEFAULT;

	/**
	 * The default value of the '{@link #getVehicleLength_min() <em>Vehicle Length min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVehicleLength_min()
	 * @generated
	 * @ordered
	 */
	protected static final double VEHICLE_LENGTH_MIN_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getVehicleLength_min() <em>Vehicle Length min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVehicleLength_min()
	 * @generated
	 * @ordered
	 */
	protected double vehicleLength_min = VEHICLE_LENGTH_MIN_EDEFAULT;

	/**
	 * The default value of the '{@link #getVehicleLength_max() <em>Vehicle Length max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVehicleLength_max()
	 * @generated
	 * @ordered
	 */
	protected static final double VEHICLE_LENGTH_MAX_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getVehicleLength_max() <em>Vehicle Length max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVehicleLength_max()
	 * @generated
	 * @ordered
	 */
	protected double vehicleLength_max = VEHICLE_LENGTH_MAX_EDEFAULT;

	/**
	 * The default value of the '{@link #getVehicleLength_precision() <em>Vehicle Length precision</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVehicleLength_precision()
	 * @generated
	 * @ordered
	 */
	protected static final int VEHICLE_LENGTH_PRECISION_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getVehicleLength_precision() <em>Vehicle Length precision</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVehicleLength_precision()
	 * @generated
	 * @ordered
	 */
	protected int vehicleLength_precision = VEHICLE_LENGTH_PRECISION_EDEFAULT;

	/**
	 * The default value of the '{@link #getVehicleHeight_min() <em>Vehicle Height min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVehicleHeight_min()
	 * @generated
	 * @ordered
	 */
	protected static final double VEHICLE_HEIGHT_MIN_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getVehicleHeight_min() <em>Vehicle Height min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVehicleHeight_min()
	 * @generated
	 * @ordered
	 */
	protected double vehicleHeight_min = VEHICLE_HEIGHT_MIN_EDEFAULT;

	/**
	 * The default value of the '{@link #getVehicleHeight_max() <em>Vehicle Height max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVehicleHeight_max()
	 * @generated
	 * @ordered
	 */
	protected static final double VEHICLE_HEIGHT_MAX_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getVehicleHeight_max() <em>Vehicle Height max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVehicleHeight_max()
	 * @generated
	 * @ordered
	 */
	protected double vehicleHeight_max = VEHICLE_HEIGHT_MAX_EDEFAULT;

	/**
	 * The default value of the '{@link #getVehicleHeight_precision() <em>Vehicle Height precision</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVehicleHeight_precision()
	 * @generated
	 * @ordered
	 */
	protected static final int VEHICLE_HEIGHT_PRECISION_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getVehicleHeight_precision() <em>Vehicle Height precision</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVehicleHeight_precision()
	 * @generated
	 * @ordered
	 */
	protected int vehicleHeight_precision = VEHICLE_HEIGHT_PRECISION_EDEFAULT;

	/**
	 * The default value of the '{@link #getSpeed() <em>Speed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpeed()
	 * @generated
	 * @ordered
	 */
	protected static final int SPEED_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSpeed() <em>Speed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpeed()
	 * @generated
	 * @ordered
	 */
	protected int speed = SPEED_EDEFAULT;

	/**
	 * The default value of the '{@link #getStop() <em>Stop</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStop()
	 * @generated
	 * @ordered
	 */
	protected static final int STOP_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getStop() <em>Stop</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStop()
	 * @generated
	 * @ordered
	 */
	protected int stop = STOP_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Vehicle_TypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return IntelligentMobilityPackage.eINSTANCE.getVehicle_Type();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CarType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(CarType newType) {
		CarType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.VEHICLE_TYPE__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getMaxSpeed() {
		return maxSpeed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxSpeed(double newMaxSpeed) {
		double oldMaxSpeed = maxSpeed;
		maxSpeed = newMaxSpeed;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.VEHICLE_TYPE__MAX_SPEED, oldMaxSpeed, maxSpeed));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getVehicleWidth_min() {
		return vehicleWidth_min;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVehicleWidth_min(double newVehicleWidth_min) {
		double oldVehicleWidth_min = vehicleWidth_min;
		vehicleWidth_min = newVehicleWidth_min;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.VEHICLE_TYPE__VEHICLE_WIDTH_MIN, oldVehicleWidth_min, vehicleWidth_min));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getVehicleWidth_max() {
		return vehicleWidth_max;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVehicleWidth_max(double newVehicleWidth_max) {
		double oldVehicleWidth_max = vehicleWidth_max;
		vehicleWidth_max = newVehicleWidth_max;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.VEHICLE_TYPE__VEHICLE_WIDTH_MAX, oldVehicleWidth_max, vehicleWidth_max));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getVehicleWidth_precision() {
		return vehicleWidth_precision;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVehicleWidth_precision(int newVehicleWidth_precision) {
		int oldVehicleWidth_precision = vehicleWidth_precision;
		vehicleWidth_precision = newVehicleWidth_precision;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.VEHICLE_TYPE__VEHICLE_WIDTH_PRECISION, oldVehicleWidth_precision, vehicleWidth_precision));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getVehicleLength_min() {
		return vehicleLength_min;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVehicleLength_min(double newVehicleLength_min) {
		double oldVehicleLength_min = vehicleLength_min;
		vehicleLength_min = newVehicleLength_min;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.VEHICLE_TYPE__VEHICLE_LENGTH_MIN, oldVehicleLength_min, vehicleLength_min));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getVehicleLength_max() {
		return vehicleLength_max;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVehicleLength_max(double newVehicleLength_max) {
		double oldVehicleLength_max = vehicleLength_max;
		vehicleLength_max = newVehicleLength_max;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.VEHICLE_TYPE__VEHICLE_LENGTH_MAX, oldVehicleLength_max, vehicleLength_max));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getVehicleLength_precision() {
		return vehicleLength_precision;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVehicleLength_precision(int newVehicleLength_precision) {
		int oldVehicleLength_precision = vehicleLength_precision;
		vehicleLength_precision = newVehicleLength_precision;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.VEHICLE_TYPE__VEHICLE_LENGTH_PRECISION, oldVehicleLength_precision, vehicleLength_precision));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getVehicleHeight_min() {
		return vehicleHeight_min;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVehicleHeight_min(double newVehicleHeight_min) {
		double oldVehicleHeight_min = vehicleHeight_min;
		vehicleHeight_min = newVehicleHeight_min;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.VEHICLE_TYPE__VEHICLE_HEIGHT_MIN, oldVehicleHeight_min, vehicleHeight_min));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getVehicleHeight_max() {
		return vehicleHeight_max;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVehicleHeight_max(double newVehicleHeight_max) {
		double oldVehicleHeight_max = vehicleHeight_max;
		vehicleHeight_max = newVehicleHeight_max;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.VEHICLE_TYPE__VEHICLE_HEIGHT_MAX, oldVehicleHeight_max, vehicleHeight_max));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getVehicleHeight_precision() {
		return vehicleHeight_precision;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVehicleHeight_precision(int newVehicleHeight_precision) {
		int oldVehicleHeight_precision = vehicleHeight_precision;
		vehicleHeight_precision = newVehicleHeight_precision;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.VEHICLE_TYPE__VEHICLE_HEIGHT_PRECISION, oldVehicleHeight_precision, vehicleHeight_precision));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSpeed() {
		return speed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpeed(int newSpeed) {
		int oldSpeed = speed;
		speed = newSpeed;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.VEHICLE_TYPE__SPEED, oldSpeed, speed));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getStop() {
		return stop;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStop(int newStop) {
		int oldStop = stop;
		stop = newStop;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.VEHICLE_TYPE__STOP, oldStop, stop));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IntelligentMobilityPackage.VEHICLE_TYPE__TYPE:
				return getType();
			case IntelligentMobilityPackage.VEHICLE_TYPE__MAX_SPEED:
				return new Double(getMaxSpeed());
			case IntelligentMobilityPackage.VEHICLE_TYPE__VEHICLE_WIDTH_MIN:
				return new Double(getVehicleWidth_min());
			case IntelligentMobilityPackage.VEHICLE_TYPE__VEHICLE_WIDTH_MAX:
				return new Double(getVehicleWidth_max());
			case IntelligentMobilityPackage.VEHICLE_TYPE__VEHICLE_WIDTH_PRECISION:
				return new Integer(getVehicleWidth_precision());
			case IntelligentMobilityPackage.VEHICLE_TYPE__VEHICLE_LENGTH_MIN:
				return new Double(getVehicleLength_min());
			case IntelligentMobilityPackage.VEHICLE_TYPE__VEHICLE_LENGTH_MAX:
				return new Double(getVehicleLength_max());
			case IntelligentMobilityPackage.VEHICLE_TYPE__VEHICLE_LENGTH_PRECISION:
				return new Integer(getVehicleLength_precision());
			case IntelligentMobilityPackage.VEHICLE_TYPE__VEHICLE_HEIGHT_MIN:
				return new Double(getVehicleHeight_min());
			case IntelligentMobilityPackage.VEHICLE_TYPE__VEHICLE_HEIGHT_MAX:
				return new Double(getVehicleHeight_max());
			case IntelligentMobilityPackage.VEHICLE_TYPE__VEHICLE_HEIGHT_PRECISION:
				return new Integer(getVehicleHeight_precision());
			case IntelligentMobilityPackage.VEHICLE_TYPE__SPEED:
				return new Integer(getSpeed());
			case IntelligentMobilityPackage.VEHICLE_TYPE__STOP:
				return new Integer(getStop());
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
			case IntelligentMobilityPackage.VEHICLE_TYPE__TYPE:
				setType((CarType)newValue);
				return;
			case IntelligentMobilityPackage.VEHICLE_TYPE__MAX_SPEED:
				setMaxSpeed(((Double)newValue).doubleValue());
				return;
			case IntelligentMobilityPackage.VEHICLE_TYPE__VEHICLE_WIDTH_MIN:
				setVehicleWidth_min(((Double)newValue).doubleValue());
				return;
			case IntelligentMobilityPackage.VEHICLE_TYPE__VEHICLE_WIDTH_MAX:
				setVehicleWidth_max(((Double)newValue).doubleValue());
				return;
			case IntelligentMobilityPackage.VEHICLE_TYPE__VEHICLE_WIDTH_PRECISION:
				setVehicleWidth_precision(((Integer)newValue).intValue());
				return;
			case IntelligentMobilityPackage.VEHICLE_TYPE__VEHICLE_LENGTH_MIN:
				setVehicleLength_min(((Double)newValue).doubleValue());
				return;
			case IntelligentMobilityPackage.VEHICLE_TYPE__VEHICLE_LENGTH_MAX:
				setVehicleLength_max(((Double)newValue).doubleValue());
				return;
			case IntelligentMobilityPackage.VEHICLE_TYPE__VEHICLE_LENGTH_PRECISION:
				setVehicleLength_precision(((Integer)newValue).intValue());
				return;
			case IntelligentMobilityPackage.VEHICLE_TYPE__VEHICLE_HEIGHT_MIN:
				setVehicleHeight_min(((Double)newValue).doubleValue());
				return;
			case IntelligentMobilityPackage.VEHICLE_TYPE__VEHICLE_HEIGHT_MAX:
				setVehicleHeight_max(((Double)newValue).doubleValue());
				return;
			case IntelligentMobilityPackage.VEHICLE_TYPE__VEHICLE_HEIGHT_PRECISION:
				setVehicleHeight_precision(((Integer)newValue).intValue());
				return;
			case IntelligentMobilityPackage.VEHICLE_TYPE__SPEED:
				setSpeed(((Integer)newValue).intValue());
				return;
			case IntelligentMobilityPackage.VEHICLE_TYPE__STOP:
				setStop(((Integer)newValue).intValue());
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
			case IntelligentMobilityPackage.VEHICLE_TYPE__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case IntelligentMobilityPackage.VEHICLE_TYPE__MAX_SPEED:
				setMaxSpeed(MAX_SPEED_EDEFAULT);
				return;
			case IntelligentMobilityPackage.VEHICLE_TYPE__VEHICLE_WIDTH_MIN:
				setVehicleWidth_min(VEHICLE_WIDTH_MIN_EDEFAULT);
				return;
			case IntelligentMobilityPackage.VEHICLE_TYPE__VEHICLE_WIDTH_MAX:
				setVehicleWidth_max(VEHICLE_WIDTH_MAX_EDEFAULT);
				return;
			case IntelligentMobilityPackage.VEHICLE_TYPE__VEHICLE_WIDTH_PRECISION:
				setVehicleWidth_precision(VEHICLE_WIDTH_PRECISION_EDEFAULT);
				return;
			case IntelligentMobilityPackage.VEHICLE_TYPE__VEHICLE_LENGTH_MIN:
				setVehicleLength_min(VEHICLE_LENGTH_MIN_EDEFAULT);
				return;
			case IntelligentMobilityPackage.VEHICLE_TYPE__VEHICLE_LENGTH_MAX:
				setVehicleLength_max(VEHICLE_LENGTH_MAX_EDEFAULT);
				return;
			case IntelligentMobilityPackage.VEHICLE_TYPE__VEHICLE_LENGTH_PRECISION:
				setVehicleLength_precision(VEHICLE_LENGTH_PRECISION_EDEFAULT);
				return;
			case IntelligentMobilityPackage.VEHICLE_TYPE__VEHICLE_HEIGHT_MIN:
				setVehicleHeight_min(VEHICLE_HEIGHT_MIN_EDEFAULT);
				return;
			case IntelligentMobilityPackage.VEHICLE_TYPE__VEHICLE_HEIGHT_MAX:
				setVehicleHeight_max(VEHICLE_HEIGHT_MAX_EDEFAULT);
				return;
			case IntelligentMobilityPackage.VEHICLE_TYPE__VEHICLE_HEIGHT_PRECISION:
				setVehicleHeight_precision(VEHICLE_HEIGHT_PRECISION_EDEFAULT);
				return;
			case IntelligentMobilityPackage.VEHICLE_TYPE__SPEED:
				setSpeed(SPEED_EDEFAULT);
				return;
			case IntelligentMobilityPackage.VEHICLE_TYPE__STOP:
				setStop(STOP_EDEFAULT);
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
			case IntelligentMobilityPackage.VEHICLE_TYPE__TYPE:
				return type != TYPE_EDEFAULT;
			case IntelligentMobilityPackage.VEHICLE_TYPE__MAX_SPEED:
				return maxSpeed != MAX_SPEED_EDEFAULT;
			case IntelligentMobilityPackage.VEHICLE_TYPE__VEHICLE_WIDTH_MIN:
				return vehicleWidth_min != VEHICLE_WIDTH_MIN_EDEFAULT;
			case IntelligentMobilityPackage.VEHICLE_TYPE__VEHICLE_WIDTH_MAX:
				return vehicleWidth_max != VEHICLE_WIDTH_MAX_EDEFAULT;
			case IntelligentMobilityPackage.VEHICLE_TYPE__VEHICLE_WIDTH_PRECISION:
				return vehicleWidth_precision != VEHICLE_WIDTH_PRECISION_EDEFAULT;
			case IntelligentMobilityPackage.VEHICLE_TYPE__VEHICLE_LENGTH_MIN:
				return vehicleLength_min != VEHICLE_LENGTH_MIN_EDEFAULT;
			case IntelligentMobilityPackage.VEHICLE_TYPE__VEHICLE_LENGTH_MAX:
				return vehicleLength_max != VEHICLE_LENGTH_MAX_EDEFAULT;
			case IntelligentMobilityPackage.VEHICLE_TYPE__VEHICLE_LENGTH_PRECISION:
				return vehicleLength_precision != VEHICLE_LENGTH_PRECISION_EDEFAULT;
			case IntelligentMobilityPackage.VEHICLE_TYPE__VEHICLE_HEIGHT_MIN:
				return vehicleHeight_min != VEHICLE_HEIGHT_MIN_EDEFAULT;
			case IntelligentMobilityPackage.VEHICLE_TYPE__VEHICLE_HEIGHT_MAX:
				return vehicleHeight_max != VEHICLE_HEIGHT_MAX_EDEFAULT;
			case IntelligentMobilityPackage.VEHICLE_TYPE__VEHICLE_HEIGHT_PRECISION:
				return vehicleHeight_precision != VEHICLE_HEIGHT_PRECISION_EDEFAULT;
			case IntelligentMobilityPackage.VEHICLE_TYPE__SPEED:
				return speed != SPEED_EDEFAULT;
			case IntelligentMobilityPackage.VEHICLE_TYPE__STOP:
				return stop != STOP_EDEFAULT;
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
		result.append(" (type: ");
		result.append(type);
		result.append(", maxSpeed: ");
		result.append(maxSpeed);
		result.append(", vehicleWidth_min: ");
		result.append(vehicleWidth_min);
		result.append(", vehicleWidth_max: ");
		result.append(vehicleWidth_max);
		result.append(", vehicleWidth_precision: ");
		result.append(vehicleWidth_precision);
		result.append(", vehicleLength_min: ");
		result.append(vehicleLength_min);
		result.append(", vehicleLength_max: ");
		result.append(vehicleLength_max);
		result.append(", vehicleLength_precision: ");
		result.append(vehicleLength_precision);
		result.append(", vehicleHeight_min: ");
		result.append(vehicleHeight_min);
		result.append(", vehicleHeight_max: ");
		result.append(vehicleHeight_max);
		result.append(", vehicleHeight_precision: ");
		result.append(vehicleHeight_precision);
		result.append(", speed: ");
		result.append(speed);
		result.append(", stop: ");
		result.append(stop);
		result.append(')');
		return result.toString();
	}

} //Vehicle_TypeImpl
