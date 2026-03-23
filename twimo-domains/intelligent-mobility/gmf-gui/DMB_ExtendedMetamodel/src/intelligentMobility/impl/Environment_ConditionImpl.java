/**
 */
package intelligentMobility.impl;

import intelligentMobility.Environment_Condition;
import intelligentMobility.IntelligentMobilityPackage;
import intelligentMobility.Lane_Type;
import intelligentMobility.Regulation;
import intelligentMobility.RoadType;
import intelligentMobility.Special_Condition;
import intelligentMobility.Traffic_Situation;
import intelligentMobility.Vehicle_Configuration;
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
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Environment Condition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.impl.Environment_ConditionImpl#getRoadType <em>Road Type</em>}</li>
 *   <li>{@link intelligentMobility.impl.Environment_ConditionImpl#getLaneAmount <em>Lane Amount</em>}</li>
 *   <li>{@link intelligentMobility.impl.Environment_ConditionImpl#getName_EnvironmentCondition <em>Name Environment Condition</em>}</li>
 *   <li>{@link intelligentMobility.impl.Environment_ConditionImpl#getLane_type <em>Lane type</em>}</li>
 *   <li>{@link intelligentMobility.impl.Environment_ConditionImpl#getRegulations <em>Regulations</em>}</li>
 *   <li>{@link intelligentMobility.impl.Environment_ConditionImpl#getWeather <em>Weather</em>}</li>
 *   <li>{@link intelligentMobility.impl.Environment_ConditionImpl#getTraffic_condition <em>Traffic condition</em>}</li>
 *   <li>{@link intelligentMobility.impl.Environment_ConditionImpl#getSpecial_condition <em>Special condition</em>}</li>
 *   <li>{@link intelligentMobility.impl.Environment_ConditionImpl#getCueType <em>Cue Type</em>}</li>
 *   <li>{@link intelligentMobility.impl.Environment_ConditionImpl#getSalience <em>Salience</em>}</li>
 *   <li>{@link intelligentMobility.impl.Environment_ConditionImpl#getPosition <em>Position</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Environment_ConditionImpl extends MinimalEObjectImpl.Container implements Environment_Condition {
	/**
	 * The default value of the '{@link #getRoadType() <em>Road Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoadType()
	 * @generated
	 * @ordered
	 */
	protected static final RoadType ROAD_TYPE_EDEFAULT = RoadType.HIGHWAY_LITERAL;

	/**
	 * The cached value of the '{@link #getRoadType() <em>Road Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoadType()
	 * @generated
	 * @ordered
	 */
	protected RoadType roadType = ROAD_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getLaneAmount() <em>Lane Amount</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLaneAmount()
	 * @generated
	 * @ordered
	 */
	protected static final int LANE_AMOUNT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getLaneAmount() <em>Lane Amount</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLaneAmount()
	 * @generated
	 * @ordered
	 */
	protected int laneAmount = LANE_AMOUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #getName_EnvironmentCondition() <em>Name Environment Condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName_EnvironmentCondition()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_ENVIRONMENT_CONDITION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName_EnvironmentCondition() <em>Name Environment Condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName_EnvironmentCondition()
	 * @generated
	 * @ordered
	 */
	protected String name_EnvironmentCondition = NAME_ENVIRONMENT_CONDITION_EDEFAULT;

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
	 * The cached value of the '{@link #getRegulations() <em>Regulations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRegulations()
	 * @generated
	 * @ordered
	 */
	protected EList regulations;

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
	 * The cached value of the '{@link #getTraffic_condition() <em>Traffic condition</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTraffic_condition()
	 * @generated
	 * @ordered
	 */
	protected EList traffic_condition;

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
	 * The default value of the '{@link #getCueType() <em>Cue Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCueType()
	 * @generated
	 * @ordered
	 */
	protected static final String CUE_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCueType() <em>Cue Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCueType()
	 * @generated
	 * @ordered
	 */
	protected String cueType = CUE_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getSalience() <em>Salience</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSalience()
	 * @generated
	 * @ordered
	 */
	protected static final float SALIENCE_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getSalience() <em>Salience</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSalience()
	 * @generated
	 * @ordered
	 */
	protected float salience = SALIENCE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPosition() <em>Position</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPosition()
	 * @generated
	 * @ordered
	 */
	protected EList position;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Environment_ConditionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return IntelligentMobilityPackage.eINSTANCE.getEnvironment_Condition();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RoadType getRoadType() {
		return roadType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRoadType(RoadType newRoadType) {
		RoadType oldRoadType = roadType;
		roadType = newRoadType == null ? ROAD_TYPE_EDEFAULT : newRoadType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.ENVIRONMENT_CONDITION__ROAD_TYPE, oldRoadType, roadType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getLaneAmount() {
		return laneAmount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLaneAmount(int newLaneAmount) {
		int oldLaneAmount = laneAmount;
		laneAmount = newLaneAmount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.ENVIRONMENT_CONDITION__LANE_AMOUNT, oldLaneAmount, laneAmount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName_EnvironmentCondition() {
		return name_EnvironmentCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName_EnvironmentCondition(String newName_EnvironmentCondition) {
		String oldName_EnvironmentCondition = name_EnvironmentCondition;
		name_EnvironmentCondition = newName_EnvironmentCondition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.ENVIRONMENT_CONDITION__NAME_ENVIRONMENT_CONDITION, oldName_EnvironmentCondition, name_EnvironmentCondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getLane_type() {
		if (lane_type == null) {
			lane_type = new EObjectContainmentEList(Lane_Type.class, this, IntelligentMobilityPackage.ENVIRONMENT_CONDITION__LANE_TYPE);
		}
		return lane_type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getRegulations() {
		if (regulations == null) {
			regulations = new EObjectContainmentEList(Regulation.class, this, IntelligentMobilityPackage.ENVIRONMENT_CONDITION__REGULATIONS);
		}
		return regulations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getWeather() {
		if (weather == null) {
			weather = new EObjectContainmentEList(Weather.class, this, IntelligentMobilityPackage.ENVIRONMENT_CONDITION__WEATHER);
		}
		return weather;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getTraffic_condition() {
		if (traffic_condition == null) {
			traffic_condition = new EObjectContainmentEList(Traffic_Situation.class, this, IntelligentMobilityPackage.ENVIRONMENT_CONDITION__TRAFFIC_CONDITION);
		}
		return traffic_condition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getSpecial_condition() {
		if (special_condition == null) {
			special_condition = new EObjectContainmentEList(Special_Condition.class, this, IntelligentMobilityPackage.ENVIRONMENT_CONDITION__SPECIAL_CONDITION);
		}
		return special_condition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCueType() {
		return cueType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCueType(String newCueType) {
		String oldCueType = cueType;
		cueType = newCueType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.ENVIRONMENT_CONDITION__CUE_TYPE, oldCueType, cueType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getSalience() {
		return salience;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSalience(float newSalience) {
		float oldSalience = salience;
		salience = newSalience;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.ENVIRONMENT_CONDITION__SALIENCE, oldSalience, salience));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getPosition() {
		if (position == null) {
			position = new EObjectResolvingEList(Vehicle_Configuration.class, this, IntelligentMobilityPackage.ENVIRONMENT_CONDITION__POSITION);
		}
		return position;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case IntelligentMobilityPackage.ENVIRONMENT_CONDITION__LANE_TYPE:
				return ((InternalEList)getLane_type()).basicRemove(otherEnd, msgs);
			case IntelligentMobilityPackage.ENVIRONMENT_CONDITION__REGULATIONS:
				return ((InternalEList)getRegulations()).basicRemove(otherEnd, msgs);
			case IntelligentMobilityPackage.ENVIRONMENT_CONDITION__WEATHER:
				return ((InternalEList)getWeather()).basicRemove(otherEnd, msgs);
			case IntelligentMobilityPackage.ENVIRONMENT_CONDITION__TRAFFIC_CONDITION:
				return ((InternalEList)getTraffic_condition()).basicRemove(otherEnd, msgs);
			case IntelligentMobilityPackage.ENVIRONMENT_CONDITION__SPECIAL_CONDITION:
				return ((InternalEList)getSpecial_condition()).basicRemove(otherEnd, msgs);
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
			case IntelligentMobilityPackage.ENVIRONMENT_CONDITION__ROAD_TYPE:
				return getRoadType();
			case IntelligentMobilityPackage.ENVIRONMENT_CONDITION__LANE_AMOUNT:
				return new Integer(getLaneAmount());
			case IntelligentMobilityPackage.ENVIRONMENT_CONDITION__NAME_ENVIRONMENT_CONDITION:
				return getName_EnvironmentCondition();
			case IntelligentMobilityPackage.ENVIRONMENT_CONDITION__LANE_TYPE:
				return getLane_type();
			case IntelligentMobilityPackage.ENVIRONMENT_CONDITION__REGULATIONS:
				return getRegulations();
			case IntelligentMobilityPackage.ENVIRONMENT_CONDITION__WEATHER:
				return getWeather();
			case IntelligentMobilityPackage.ENVIRONMENT_CONDITION__TRAFFIC_CONDITION:
				return getTraffic_condition();
			case IntelligentMobilityPackage.ENVIRONMENT_CONDITION__SPECIAL_CONDITION:
				return getSpecial_condition();
			case IntelligentMobilityPackage.ENVIRONMENT_CONDITION__CUE_TYPE:
				return getCueType();
			case IntelligentMobilityPackage.ENVIRONMENT_CONDITION__SALIENCE:
				return new Float(getSalience());
			case IntelligentMobilityPackage.ENVIRONMENT_CONDITION__POSITION:
				return getPosition();
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
			case IntelligentMobilityPackage.ENVIRONMENT_CONDITION__ROAD_TYPE:
				setRoadType((RoadType)newValue);
				return;
			case IntelligentMobilityPackage.ENVIRONMENT_CONDITION__LANE_AMOUNT:
				setLaneAmount(((Integer)newValue).intValue());
				return;
			case IntelligentMobilityPackage.ENVIRONMENT_CONDITION__NAME_ENVIRONMENT_CONDITION:
				setName_EnvironmentCondition((String)newValue);
				return;
			case IntelligentMobilityPackage.ENVIRONMENT_CONDITION__LANE_TYPE:
				getLane_type().clear();
				getLane_type().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.ENVIRONMENT_CONDITION__REGULATIONS:
				getRegulations().clear();
				getRegulations().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.ENVIRONMENT_CONDITION__WEATHER:
				getWeather().clear();
				getWeather().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.ENVIRONMENT_CONDITION__TRAFFIC_CONDITION:
				getTraffic_condition().clear();
				getTraffic_condition().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.ENVIRONMENT_CONDITION__SPECIAL_CONDITION:
				getSpecial_condition().clear();
				getSpecial_condition().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.ENVIRONMENT_CONDITION__CUE_TYPE:
				setCueType((String)newValue);
				return;
			case IntelligentMobilityPackage.ENVIRONMENT_CONDITION__SALIENCE:
				setSalience(((Float)newValue).floatValue());
				return;
			case IntelligentMobilityPackage.ENVIRONMENT_CONDITION__POSITION:
				getPosition().clear();
				getPosition().addAll((Collection)newValue);
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
			case IntelligentMobilityPackage.ENVIRONMENT_CONDITION__ROAD_TYPE:
				setRoadType(ROAD_TYPE_EDEFAULT);
				return;
			case IntelligentMobilityPackage.ENVIRONMENT_CONDITION__LANE_AMOUNT:
				setLaneAmount(LANE_AMOUNT_EDEFAULT);
				return;
			case IntelligentMobilityPackage.ENVIRONMENT_CONDITION__NAME_ENVIRONMENT_CONDITION:
				setName_EnvironmentCondition(NAME_ENVIRONMENT_CONDITION_EDEFAULT);
				return;
			case IntelligentMobilityPackage.ENVIRONMENT_CONDITION__LANE_TYPE:
				getLane_type().clear();
				return;
			case IntelligentMobilityPackage.ENVIRONMENT_CONDITION__REGULATIONS:
				getRegulations().clear();
				return;
			case IntelligentMobilityPackage.ENVIRONMENT_CONDITION__WEATHER:
				getWeather().clear();
				return;
			case IntelligentMobilityPackage.ENVIRONMENT_CONDITION__TRAFFIC_CONDITION:
				getTraffic_condition().clear();
				return;
			case IntelligentMobilityPackage.ENVIRONMENT_CONDITION__SPECIAL_CONDITION:
				getSpecial_condition().clear();
				return;
			case IntelligentMobilityPackage.ENVIRONMENT_CONDITION__CUE_TYPE:
				setCueType(CUE_TYPE_EDEFAULT);
				return;
			case IntelligentMobilityPackage.ENVIRONMENT_CONDITION__SALIENCE:
				setSalience(SALIENCE_EDEFAULT);
				return;
			case IntelligentMobilityPackage.ENVIRONMENT_CONDITION__POSITION:
				getPosition().clear();
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
			case IntelligentMobilityPackage.ENVIRONMENT_CONDITION__ROAD_TYPE:
				return roadType != ROAD_TYPE_EDEFAULT;
			case IntelligentMobilityPackage.ENVIRONMENT_CONDITION__LANE_AMOUNT:
				return laneAmount != LANE_AMOUNT_EDEFAULT;
			case IntelligentMobilityPackage.ENVIRONMENT_CONDITION__NAME_ENVIRONMENT_CONDITION:
				return NAME_ENVIRONMENT_CONDITION_EDEFAULT == null ? name_EnvironmentCondition != null : !NAME_ENVIRONMENT_CONDITION_EDEFAULT.equals(name_EnvironmentCondition);
			case IntelligentMobilityPackage.ENVIRONMENT_CONDITION__LANE_TYPE:
				return lane_type != null && !lane_type.isEmpty();
			case IntelligentMobilityPackage.ENVIRONMENT_CONDITION__REGULATIONS:
				return regulations != null && !regulations.isEmpty();
			case IntelligentMobilityPackage.ENVIRONMENT_CONDITION__WEATHER:
				return weather != null && !weather.isEmpty();
			case IntelligentMobilityPackage.ENVIRONMENT_CONDITION__TRAFFIC_CONDITION:
				return traffic_condition != null && !traffic_condition.isEmpty();
			case IntelligentMobilityPackage.ENVIRONMENT_CONDITION__SPECIAL_CONDITION:
				return special_condition != null && !special_condition.isEmpty();
			case IntelligentMobilityPackage.ENVIRONMENT_CONDITION__CUE_TYPE:
				return CUE_TYPE_EDEFAULT == null ? cueType != null : !CUE_TYPE_EDEFAULT.equals(cueType);
			case IntelligentMobilityPackage.ENVIRONMENT_CONDITION__SALIENCE:
				return salience != SALIENCE_EDEFAULT;
			case IntelligentMobilityPackage.ENVIRONMENT_CONDITION__POSITION:
				return position != null && !position.isEmpty();
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
		result.append(" (roadType: ");
		result.append(roadType);
		result.append(", laneAmount: ");
		result.append(laneAmount);
		result.append(", name_EnvironmentCondition: ");
		result.append(name_EnvironmentCondition);
		result.append(", cueType: ");
		result.append(cueType);
		result.append(", salience: ");
		result.append(salience);
		result.append(')');
		return result.toString();
	}

} //Environment_ConditionImpl
