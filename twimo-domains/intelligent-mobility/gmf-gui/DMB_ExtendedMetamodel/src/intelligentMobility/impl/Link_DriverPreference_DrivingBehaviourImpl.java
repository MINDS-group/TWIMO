/**
 */
package intelligentMobility.impl;

import intelligentMobility.Driver_Preference;
import intelligentMobility.Driving_Behaviour;
import intelligentMobility.IntelligentMobilityPackage;
import intelligentMobility.Link_DriverPreference_DrivingBehaviour;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Link Driver Preference Driving Behaviour</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.impl.Link_DriverPreference_DrivingBehaviourImpl#getName_link_preference_behaviour <em>Name link preference behaviour</em>}</li>
 *   <li>{@link intelligentMobility.impl.Link_DriverPreference_DrivingBehaviourImpl#getLink_driver_preference <em>Link driver preference</em>}</li>
 *   <li>{@link intelligentMobility.impl.Link_DriverPreference_DrivingBehaviourImpl#getLink_driving_behaviour <em>Link driving behaviour</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Link_DriverPreference_DrivingBehaviourImpl extends MinimalEObjectImpl.Container implements Link_DriverPreference_DrivingBehaviour {
	/**
	 * The default value of the '{@link #getName_link_preference_behaviour() <em>Name link preference behaviour</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName_link_preference_behaviour()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_LINK_PREFERENCE_BEHAVIOUR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName_link_preference_behaviour() <em>Name link preference behaviour</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName_link_preference_behaviour()
	 * @generated
	 * @ordered
	 */
	protected String name_link_preference_behaviour = NAME_LINK_PREFERENCE_BEHAVIOUR_EDEFAULT;

	/**
	 * The cached value of the '{@link #getLink_driver_preference() <em>Link driver preference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_driver_preference()
	 * @generated
	 * @ordered
	 */
	protected Driver_Preference link_driver_preference;

	/**
	 * The cached value of the '{@link #getLink_driving_behaviour() <em>Link driving behaviour</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_driving_behaviour()
	 * @generated
	 * @ordered
	 */
	protected Driving_Behaviour link_driving_behaviour;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Link_DriverPreference_DrivingBehaviourImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return IntelligentMobilityPackage.eINSTANCE.getLink_DriverPreference_DrivingBehaviour();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName_link_preference_behaviour() {
		return name_link_preference_behaviour;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName_link_preference_behaviour(String newName_link_preference_behaviour) {
		String oldName_link_preference_behaviour = name_link_preference_behaviour;
		name_link_preference_behaviour = newName_link_preference_behaviour;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_DRIVER_PREFERENCE_DRIVING_BEHAVIOUR__NAME_LINK_PREFERENCE_BEHAVIOUR, oldName_link_preference_behaviour, name_link_preference_behaviour));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Driver_Preference getLink_driver_preference() {
		if (link_driver_preference != null && link_driver_preference.eIsProxy()) {
			InternalEObject oldLink_driver_preference = (InternalEObject)link_driver_preference;
			link_driver_preference = (Driver_Preference)eResolveProxy(oldLink_driver_preference);
			if (link_driver_preference != oldLink_driver_preference) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LINK_DRIVER_PREFERENCE_DRIVING_BEHAVIOUR__LINK_DRIVER_PREFERENCE, oldLink_driver_preference, link_driver_preference));
			}
		}
		return link_driver_preference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Driver_Preference basicGetLink_driver_preference() {
		return link_driver_preference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLink_driver_preference(Driver_Preference newLink_driver_preference) {
		Driver_Preference oldLink_driver_preference = link_driver_preference;
		link_driver_preference = newLink_driver_preference;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_DRIVER_PREFERENCE_DRIVING_BEHAVIOUR__LINK_DRIVER_PREFERENCE, oldLink_driver_preference, link_driver_preference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Driving_Behaviour getLink_driving_behaviour() {
		if (link_driving_behaviour != null && link_driving_behaviour.eIsProxy()) {
			InternalEObject oldLink_driving_behaviour = (InternalEObject)link_driving_behaviour;
			link_driving_behaviour = (Driving_Behaviour)eResolveProxy(oldLink_driving_behaviour);
			if (link_driving_behaviour != oldLink_driving_behaviour) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LINK_DRIVER_PREFERENCE_DRIVING_BEHAVIOUR__LINK_DRIVING_BEHAVIOUR, oldLink_driving_behaviour, link_driving_behaviour));
			}
		}
		return link_driving_behaviour;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Driving_Behaviour basicGetLink_driving_behaviour() {
		return link_driving_behaviour;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLink_driving_behaviour(Driving_Behaviour newLink_driving_behaviour) {
		Driving_Behaviour oldLink_driving_behaviour = link_driving_behaviour;
		link_driving_behaviour = newLink_driving_behaviour;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_DRIVER_PREFERENCE_DRIVING_BEHAVIOUR__LINK_DRIVING_BEHAVIOUR, oldLink_driving_behaviour, link_driving_behaviour));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IntelligentMobilityPackage.LINK_DRIVER_PREFERENCE_DRIVING_BEHAVIOUR__NAME_LINK_PREFERENCE_BEHAVIOUR:
				return getName_link_preference_behaviour();
			case IntelligentMobilityPackage.LINK_DRIVER_PREFERENCE_DRIVING_BEHAVIOUR__LINK_DRIVER_PREFERENCE:
				if (resolve) return getLink_driver_preference();
				return basicGetLink_driver_preference();
			case IntelligentMobilityPackage.LINK_DRIVER_PREFERENCE_DRIVING_BEHAVIOUR__LINK_DRIVING_BEHAVIOUR:
				if (resolve) return getLink_driving_behaviour();
				return basicGetLink_driving_behaviour();
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
			case IntelligentMobilityPackage.LINK_DRIVER_PREFERENCE_DRIVING_BEHAVIOUR__NAME_LINK_PREFERENCE_BEHAVIOUR:
				setName_link_preference_behaviour((String)newValue);
				return;
			case IntelligentMobilityPackage.LINK_DRIVER_PREFERENCE_DRIVING_BEHAVIOUR__LINK_DRIVER_PREFERENCE:
				setLink_driver_preference((Driver_Preference)newValue);
				return;
			case IntelligentMobilityPackage.LINK_DRIVER_PREFERENCE_DRIVING_BEHAVIOUR__LINK_DRIVING_BEHAVIOUR:
				setLink_driving_behaviour((Driving_Behaviour)newValue);
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
			case IntelligentMobilityPackage.LINK_DRIVER_PREFERENCE_DRIVING_BEHAVIOUR__NAME_LINK_PREFERENCE_BEHAVIOUR:
				setName_link_preference_behaviour(NAME_LINK_PREFERENCE_BEHAVIOUR_EDEFAULT);
				return;
			case IntelligentMobilityPackage.LINK_DRIVER_PREFERENCE_DRIVING_BEHAVIOUR__LINK_DRIVER_PREFERENCE:
				setLink_driver_preference((Driver_Preference)null);
				return;
			case IntelligentMobilityPackage.LINK_DRIVER_PREFERENCE_DRIVING_BEHAVIOUR__LINK_DRIVING_BEHAVIOUR:
				setLink_driving_behaviour((Driving_Behaviour)null);
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
			case IntelligentMobilityPackage.LINK_DRIVER_PREFERENCE_DRIVING_BEHAVIOUR__NAME_LINK_PREFERENCE_BEHAVIOUR:
				return NAME_LINK_PREFERENCE_BEHAVIOUR_EDEFAULT == null ? name_link_preference_behaviour != null : !NAME_LINK_PREFERENCE_BEHAVIOUR_EDEFAULT.equals(name_link_preference_behaviour);
			case IntelligentMobilityPackage.LINK_DRIVER_PREFERENCE_DRIVING_BEHAVIOUR__LINK_DRIVER_PREFERENCE:
				return link_driver_preference != null;
			case IntelligentMobilityPackage.LINK_DRIVER_PREFERENCE_DRIVING_BEHAVIOUR__LINK_DRIVING_BEHAVIOUR:
				return link_driving_behaviour != null;
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
		result.append(" (name_link_preference_behaviour: ");
		result.append(name_link_preference_behaviour);
		result.append(')');
		return result.toString();
	}

} //Link_DriverPreference_DrivingBehaviourImpl
