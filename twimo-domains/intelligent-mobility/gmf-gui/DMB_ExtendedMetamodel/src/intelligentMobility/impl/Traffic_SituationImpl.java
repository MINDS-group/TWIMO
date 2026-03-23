/**
 */
package intelligentMobility.impl;

import intelligentMobility.IntelligentMobilityPackage;
import intelligentMobility.TrafficType;
import intelligentMobility.Traffic_Situation;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Traffic Situation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.impl.Traffic_SituationImpl#getName <em>Name</em>}</li>
 *   <li>{@link intelligentMobility.impl.Traffic_SituationImpl#getTrafficType <em>Traffic Type</em>}</li>
 *   <li>{@link intelligentMobility.impl.Traffic_SituationImpl#getStimulusType <em>Stimulus Type</em>}</li>
 *   <li>{@link intelligentMobility.impl.Traffic_SituationImpl#getIntensity <em>Intensity</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Traffic_SituationImpl extends MinimalEObjectImpl.Container implements Traffic_Situation {
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
	 * The default value of the '{@link #getTrafficType() <em>Traffic Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTrafficType()
	 * @generated
	 * @ordered
	 */
	protected static final TrafficType TRAFFIC_TYPE_EDEFAULT = TrafficType.CONGESTION_LITERAL;

	/**
	 * The cached value of the '{@link #getTrafficType() <em>Traffic Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTrafficType()
	 * @generated
	 * @ordered
	 */
	protected TrafficType trafficType = TRAFFIC_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getStimulusType() <em>Stimulus Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStimulusType()
	 * @generated
	 * @ordered
	 */
	protected static final String STIMULUS_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStimulusType() <em>Stimulus Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStimulusType()
	 * @generated
	 * @ordered
	 */
	protected String stimulusType = STIMULUS_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getIntensity() <em>Intensity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntensity()
	 * @generated
	 * @ordered
	 */
	protected static final float INTENSITY_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getIntensity() <em>Intensity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntensity()
	 * @generated
	 * @ordered
	 */
	protected float intensity = INTENSITY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Traffic_SituationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return IntelligentMobilityPackage.eINSTANCE.getTraffic_Situation();
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
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.TRAFFIC_SITUATION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TrafficType getTrafficType() {
		return trafficType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTrafficType(TrafficType newTrafficType) {
		TrafficType oldTrafficType = trafficType;
		trafficType = newTrafficType == null ? TRAFFIC_TYPE_EDEFAULT : newTrafficType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.TRAFFIC_SITUATION__TRAFFIC_TYPE, oldTrafficType, trafficType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStimulusType() {
		return stimulusType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStimulusType(String newStimulusType) {
		String oldStimulusType = stimulusType;
		stimulusType = newStimulusType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.TRAFFIC_SITUATION__STIMULUS_TYPE, oldStimulusType, stimulusType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getIntensity() {
		return intensity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIntensity(float newIntensity) {
		float oldIntensity = intensity;
		intensity = newIntensity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.TRAFFIC_SITUATION__INTENSITY, oldIntensity, intensity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IntelligentMobilityPackage.TRAFFIC_SITUATION__NAME:
				return getName();
			case IntelligentMobilityPackage.TRAFFIC_SITUATION__TRAFFIC_TYPE:
				return getTrafficType();
			case IntelligentMobilityPackage.TRAFFIC_SITUATION__STIMULUS_TYPE:
				return getStimulusType();
			case IntelligentMobilityPackage.TRAFFIC_SITUATION__INTENSITY:
				return new Float(getIntensity());
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
			case IntelligentMobilityPackage.TRAFFIC_SITUATION__NAME:
				setName((String)newValue);
				return;
			case IntelligentMobilityPackage.TRAFFIC_SITUATION__TRAFFIC_TYPE:
				setTrafficType((TrafficType)newValue);
				return;
			case IntelligentMobilityPackage.TRAFFIC_SITUATION__STIMULUS_TYPE:
				setStimulusType((String)newValue);
				return;
			case IntelligentMobilityPackage.TRAFFIC_SITUATION__INTENSITY:
				setIntensity(((Float)newValue).floatValue());
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
			case IntelligentMobilityPackage.TRAFFIC_SITUATION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case IntelligentMobilityPackage.TRAFFIC_SITUATION__TRAFFIC_TYPE:
				setTrafficType(TRAFFIC_TYPE_EDEFAULT);
				return;
			case IntelligentMobilityPackage.TRAFFIC_SITUATION__STIMULUS_TYPE:
				setStimulusType(STIMULUS_TYPE_EDEFAULT);
				return;
			case IntelligentMobilityPackage.TRAFFIC_SITUATION__INTENSITY:
				setIntensity(INTENSITY_EDEFAULT);
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
			case IntelligentMobilityPackage.TRAFFIC_SITUATION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case IntelligentMobilityPackage.TRAFFIC_SITUATION__TRAFFIC_TYPE:
				return trafficType != TRAFFIC_TYPE_EDEFAULT;
			case IntelligentMobilityPackage.TRAFFIC_SITUATION__STIMULUS_TYPE:
				return STIMULUS_TYPE_EDEFAULT == null ? stimulusType != null : !STIMULUS_TYPE_EDEFAULT.equals(stimulusType);
			case IntelligentMobilityPackage.TRAFFIC_SITUATION__INTENSITY:
				return intensity != INTENSITY_EDEFAULT;
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
		result.append(" (name: ");
		result.append(name);
		result.append(", trafficType: ");
		result.append(trafficType);
		result.append(", stimulusType: ");
		result.append(stimulusType);
		result.append(", intensity: ");
		result.append(intensity);
		result.append(')');
		return result.toString();
	}

} //Traffic_SituationImpl
