/**
 */
package intelligentMobility.impl;

import intelligentMobility.DriverType;
import intelligentMobility.Driver_Preference;
import intelligentMobility.Driver_Profile;
import intelligentMobility.IntelligentMobilityPackage;
import intelligentMobility.Lanes;

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
 * An implementation of the model object '<em><b>Driver Profile</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.impl.Driver_ProfileImpl#getDriver_preference <em>Driver preference</em>}</li>
 *   <li>{@link intelligentMobility.impl.Driver_ProfileImpl#getDriverName <em>Driver Name</em>}</li>
 *   <li>{@link intelligentMobility.impl.Driver_ProfileImpl#getDriverType <em>Driver Type</em>}</li>
 *   <li>{@link intelligentMobility.impl.Driver_ProfileImpl#getPatienceValue <em>Patience Value</em>}</li>
 *   <li>{@link intelligentMobility.impl.Driver_ProfileImpl#getLanePreference <em>Lane Preference</em>}</li>
 *   <li>{@link intelligentMobility.impl.Driver_ProfileImpl#getEnergySpeedRate <em>Energy Speed Rate</em>}</li>
 *   <li>{@link intelligentMobility.impl.Driver_ProfileImpl#getRiskLevel <em>Risk Level</em>}</li>
 *   <li>{@link intelligentMobility.impl.Driver_ProfileImpl#getReactionTime_min <em>Reaction Time min</em>}</li>
 *   <li>{@link intelligentMobility.impl.Driver_ProfileImpl#getReactionTime_max <em>Reaction Time max</em>}</li>
 *   <li>{@link intelligentMobility.impl.Driver_ProfileImpl#getReactionTime_precision <em>Reaction Time precision</em>}</li>
 *   <li>{@link intelligentMobility.impl.Driver_ProfileImpl#getAge <em>Age</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Driver_ProfileImpl extends MinimalEObjectImpl.Container implements Driver_Profile {
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
	 * The default value of the '{@link #getDriverName() <em>Driver Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDriverName()
	 * @generated
	 * @ordered
	 */
	protected static final String DRIVER_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDriverName() <em>Driver Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDriverName()
	 * @generated
	 * @ordered
	 */
	protected String driverName = DRIVER_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getDriverType() <em>Driver Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDriverType()
	 * @generated
	 * @ordered
	 */
	protected static final DriverType DRIVER_TYPE_EDEFAULT = DriverType.HUMAN_LITERAL;

	/**
	 * The cached value of the '{@link #getDriverType() <em>Driver Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDriverType()
	 * @generated
	 * @ordered
	 */
	protected DriverType driverType = DRIVER_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getPatienceValue() <em>Patience Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPatienceValue()
	 * @generated
	 * @ordered
	 */
	protected static final int PATIENCE_VALUE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getPatienceValue() <em>Patience Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPatienceValue()
	 * @generated
	 * @ordered
	 */
	protected int patienceValue = PATIENCE_VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getLanePreference() <em>Lane Preference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLanePreference()
	 * @generated
	 * @ordered
	 */
	protected static final Lanes LANE_PREFERENCE_EDEFAULT = Lanes.NORMAL_LANE_LITERAL;

	/**
	 * The cached value of the '{@link #getLanePreference() <em>Lane Preference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLanePreference()
	 * @generated
	 * @ordered
	 */
	protected Lanes lanePreference = LANE_PREFERENCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getEnergySpeedRate() <em>Energy Speed Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnergySpeedRate()
	 * @generated
	 * @ordered
	 */
	protected static final double ENERGY_SPEED_RATE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getEnergySpeedRate() <em>Energy Speed Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnergySpeedRate()
	 * @generated
	 * @ordered
	 */
	protected double energySpeedRate = ENERGY_SPEED_RATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getRiskLevel() <em>Risk Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRiskLevel()
	 * @generated
	 * @ordered
	 */
	protected static final int RISK_LEVEL_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getRiskLevel() <em>Risk Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRiskLevel()
	 * @generated
	 * @ordered
	 */
	protected int riskLevel = RISK_LEVEL_EDEFAULT;

	/**
	 * The default value of the '{@link #getReactionTime_min() <em>Reaction Time min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReactionTime_min()
	 * @generated
	 * @ordered
	 */
	protected static final double REACTION_TIME_MIN_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getReactionTime_min() <em>Reaction Time min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReactionTime_min()
	 * @generated
	 * @ordered
	 */
	protected double reactionTime_min = REACTION_TIME_MIN_EDEFAULT;

	/**
	 * The default value of the '{@link #getReactionTime_max() <em>Reaction Time max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReactionTime_max()
	 * @generated
	 * @ordered
	 */
	protected static final double REACTION_TIME_MAX_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getReactionTime_max() <em>Reaction Time max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReactionTime_max()
	 * @generated
	 * @ordered
	 */
	protected double reactionTime_max = REACTION_TIME_MAX_EDEFAULT;

	/**
	 * The default value of the '{@link #getReactionTime_precision() <em>Reaction Time precision</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReactionTime_precision()
	 * @generated
	 * @ordered
	 */
	protected static final int REACTION_TIME_PRECISION_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getReactionTime_precision() <em>Reaction Time precision</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReactionTime_precision()
	 * @generated
	 * @ordered
	 */
	protected int reactionTime_precision = REACTION_TIME_PRECISION_EDEFAULT;

	/**
	 * The default value of the '{@link #getAge() <em>Age</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAge()
	 * @generated
	 * @ordered
	 */
	protected static final int AGE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getAge() <em>Age</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAge()
	 * @generated
	 * @ordered
	 */
	protected int age = AGE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Driver_ProfileImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return IntelligentMobilityPackage.eINSTANCE.getDriver_Profile();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getDriver_preference() {
		if (driver_preference == null) {
			driver_preference = new EObjectContainmentEList(Driver_Preference.class, this, IntelligentMobilityPackage.DRIVER_PROFILE__DRIVER_PREFERENCE);
		}
		return driver_preference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDriverName() {
		return driverName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDriverName(String newDriverName) {
		String oldDriverName = driverName;
		driverName = newDriverName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.DRIVER_PROFILE__DRIVER_NAME, oldDriverName, driverName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DriverType getDriverType() {
		return driverType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDriverType(DriverType newDriverType) {
		DriverType oldDriverType = driverType;
		driverType = newDriverType == null ? DRIVER_TYPE_EDEFAULT : newDriverType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.DRIVER_PROFILE__DRIVER_TYPE, oldDriverType, driverType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getPatienceValue() {
		return patienceValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPatienceValue(int newPatienceValue) {
		int oldPatienceValue = patienceValue;
		patienceValue = newPatienceValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.DRIVER_PROFILE__PATIENCE_VALUE, oldPatienceValue, patienceValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Lanes getLanePreference() {
		return lanePreference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLanePreference(Lanes newLanePreference) {
		Lanes oldLanePreference = lanePreference;
		lanePreference = newLanePreference == null ? LANE_PREFERENCE_EDEFAULT : newLanePreference;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.DRIVER_PROFILE__LANE_PREFERENCE, oldLanePreference, lanePreference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getEnergySpeedRate() {
		return energySpeedRate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnergySpeedRate(double newEnergySpeedRate) {
		double oldEnergySpeedRate = energySpeedRate;
		energySpeedRate = newEnergySpeedRate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.DRIVER_PROFILE__ENERGY_SPEED_RATE, oldEnergySpeedRate, energySpeedRate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getRiskLevel() {
		return riskLevel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRiskLevel(int newRiskLevel) {
		int oldRiskLevel = riskLevel;
		riskLevel = newRiskLevel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.DRIVER_PROFILE__RISK_LEVEL, oldRiskLevel, riskLevel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getReactionTime_min() {
		return reactionTime_min;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReactionTime_min(double newReactionTime_min) {
		double oldReactionTime_min = reactionTime_min;
		reactionTime_min = newReactionTime_min;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.DRIVER_PROFILE__REACTION_TIME_MIN, oldReactionTime_min, reactionTime_min));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getReactionTime_max() {
		return reactionTime_max;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReactionTime_max(double newReactionTime_max) {
		double oldReactionTime_max = reactionTime_max;
		reactionTime_max = newReactionTime_max;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.DRIVER_PROFILE__REACTION_TIME_MAX, oldReactionTime_max, reactionTime_max));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getReactionTime_precision() {
		return reactionTime_precision;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReactionTime_precision(int newReactionTime_precision) {
		int oldReactionTime_precision = reactionTime_precision;
		reactionTime_precision = newReactionTime_precision;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.DRIVER_PROFILE__REACTION_TIME_PRECISION, oldReactionTime_precision, reactionTime_precision));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getAge() {
		return age;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAge(int newAge) {
		int oldAge = age;
		age = newAge;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.DRIVER_PROFILE__AGE, oldAge, age));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case IntelligentMobilityPackage.DRIVER_PROFILE__DRIVER_PREFERENCE:
				return ((InternalEList)getDriver_preference()).basicRemove(otherEnd, msgs);
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
			case IntelligentMobilityPackage.DRIVER_PROFILE__DRIVER_PREFERENCE:
				return getDriver_preference();
			case IntelligentMobilityPackage.DRIVER_PROFILE__DRIVER_NAME:
				return getDriverName();
			case IntelligentMobilityPackage.DRIVER_PROFILE__DRIVER_TYPE:
				return getDriverType();
			case IntelligentMobilityPackage.DRIVER_PROFILE__PATIENCE_VALUE:
				return new Integer(getPatienceValue());
			case IntelligentMobilityPackage.DRIVER_PROFILE__LANE_PREFERENCE:
				return getLanePreference();
			case IntelligentMobilityPackage.DRIVER_PROFILE__ENERGY_SPEED_RATE:
				return new Double(getEnergySpeedRate());
			case IntelligentMobilityPackage.DRIVER_PROFILE__RISK_LEVEL:
				return new Integer(getRiskLevel());
			case IntelligentMobilityPackage.DRIVER_PROFILE__REACTION_TIME_MIN:
				return new Double(getReactionTime_min());
			case IntelligentMobilityPackage.DRIVER_PROFILE__REACTION_TIME_MAX:
				return new Double(getReactionTime_max());
			case IntelligentMobilityPackage.DRIVER_PROFILE__REACTION_TIME_PRECISION:
				return new Integer(getReactionTime_precision());
			case IntelligentMobilityPackage.DRIVER_PROFILE__AGE:
				return new Integer(getAge());
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
			case IntelligentMobilityPackage.DRIVER_PROFILE__DRIVER_PREFERENCE:
				getDriver_preference().clear();
				getDriver_preference().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.DRIVER_PROFILE__DRIVER_NAME:
				setDriverName((String)newValue);
				return;
			case IntelligentMobilityPackage.DRIVER_PROFILE__DRIVER_TYPE:
				setDriverType((DriverType)newValue);
				return;
			case IntelligentMobilityPackage.DRIVER_PROFILE__PATIENCE_VALUE:
				setPatienceValue(((Integer)newValue).intValue());
				return;
			case IntelligentMobilityPackage.DRIVER_PROFILE__LANE_PREFERENCE:
				setLanePreference((Lanes)newValue);
				return;
			case IntelligentMobilityPackage.DRIVER_PROFILE__ENERGY_SPEED_RATE:
				setEnergySpeedRate(((Double)newValue).doubleValue());
				return;
			case IntelligentMobilityPackage.DRIVER_PROFILE__RISK_LEVEL:
				setRiskLevel(((Integer)newValue).intValue());
				return;
			case IntelligentMobilityPackage.DRIVER_PROFILE__REACTION_TIME_MIN:
				setReactionTime_min(((Double)newValue).doubleValue());
				return;
			case IntelligentMobilityPackage.DRIVER_PROFILE__REACTION_TIME_MAX:
				setReactionTime_max(((Double)newValue).doubleValue());
				return;
			case IntelligentMobilityPackage.DRIVER_PROFILE__REACTION_TIME_PRECISION:
				setReactionTime_precision(((Integer)newValue).intValue());
				return;
			case IntelligentMobilityPackage.DRIVER_PROFILE__AGE:
				setAge(((Integer)newValue).intValue());
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
			case IntelligentMobilityPackage.DRIVER_PROFILE__DRIVER_PREFERENCE:
				getDriver_preference().clear();
				return;
			case IntelligentMobilityPackage.DRIVER_PROFILE__DRIVER_NAME:
				setDriverName(DRIVER_NAME_EDEFAULT);
				return;
			case IntelligentMobilityPackage.DRIVER_PROFILE__DRIVER_TYPE:
				setDriverType(DRIVER_TYPE_EDEFAULT);
				return;
			case IntelligentMobilityPackage.DRIVER_PROFILE__PATIENCE_VALUE:
				setPatienceValue(PATIENCE_VALUE_EDEFAULT);
				return;
			case IntelligentMobilityPackage.DRIVER_PROFILE__LANE_PREFERENCE:
				setLanePreference(LANE_PREFERENCE_EDEFAULT);
				return;
			case IntelligentMobilityPackage.DRIVER_PROFILE__ENERGY_SPEED_RATE:
				setEnergySpeedRate(ENERGY_SPEED_RATE_EDEFAULT);
				return;
			case IntelligentMobilityPackage.DRIVER_PROFILE__RISK_LEVEL:
				setRiskLevel(RISK_LEVEL_EDEFAULT);
				return;
			case IntelligentMobilityPackage.DRIVER_PROFILE__REACTION_TIME_MIN:
				setReactionTime_min(REACTION_TIME_MIN_EDEFAULT);
				return;
			case IntelligentMobilityPackage.DRIVER_PROFILE__REACTION_TIME_MAX:
				setReactionTime_max(REACTION_TIME_MAX_EDEFAULT);
				return;
			case IntelligentMobilityPackage.DRIVER_PROFILE__REACTION_TIME_PRECISION:
				setReactionTime_precision(REACTION_TIME_PRECISION_EDEFAULT);
				return;
			case IntelligentMobilityPackage.DRIVER_PROFILE__AGE:
				setAge(AGE_EDEFAULT);
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
			case IntelligentMobilityPackage.DRIVER_PROFILE__DRIVER_PREFERENCE:
				return driver_preference != null && !driver_preference.isEmpty();
			case IntelligentMobilityPackage.DRIVER_PROFILE__DRIVER_NAME:
				return DRIVER_NAME_EDEFAULT == null ? driverName != null : !DRIVER_NAME_EDEFAULT.equals(driverName);
			case IntelligentMobilityPackage.DRIVER_PROFILE__DRIVER_TYPE:
				return driverType != DRIVER_TYPE_EDEFAULT;
			case IntelligentMobilityPackage.DRIVER_PROFILE__PATIENCE_VALUE:
				return patienceValue != PATIENCE_VALUE_EDEFAULT;
			case IntelligentMobilityPackage.DRIVER_PROFILE__LANE_PREFERENCE:
				return lanePreference != LANE_PREFERENCE_EDEFAULT;
			case IntelligentMobilityPackage.DRIVER_PROFILE__ENERGY_SPEED_RATE:
				return energySpeedRate != ENERGY_SPEED_RATE_EDEFAULT;
			case IntelligentMobilityPackage.DRIVER_PROFILE__RISK_LEVEL:
				return riskLevel != RISK_LEVEL_EDEFAULT;
			case IntelligentMobilityPackage.DRIVER_PROFILE__REACTION_TIME_MIN:
				return reactionTime_min != REACTION_TIME_MIN_EDEFAULT;
			case IntelligentMobilityPackage.DRIVER_PROFILE__REACTION_TIME_MAX:
				return reactionTime_max != REACTION_TIME_MAX_EDEFAULT;
			case IntelligentMobilityPackage.DRIVER_PROFILE__REACTION_TIME_PRECISION:
				return reactionTime_precision != REACTION_TIME_PRECISION_EDEFAULT;
			case IntelligentMobilityPackage.DRIVER_PROFILE__AGE:
				return age != AGE_EDEFAULT;
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
		result.append(" (driverName: ");
		result.append(driverName);
		result.append(", driverType: ");
		result.append(driverType);
		result.append(", patienceValue: ");
		result.append(patienceValue);
		result.append(", lanePreference: ");
		result.append(lanePreference);
		result.append(", energySpeedRate: ");
		result.append(energySpeedRate);
		result.append(", riskLevel: ");
		result.append(riskLevel);
		result.append(", reactionTime_min: ");
		result.append(reactionTime_min);
		result.append(", reactionTime_max: ");
		result.append(reactionTime_max);
		result.append(", reactionTime_precision: ");
		result.append(reactionTime_precision);
		result.append(", age: ");
		result.append(age);
		result.append(')');
		return result.toString();
	}

} //Driver_ProfileImpl
