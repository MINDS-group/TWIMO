/**
 */
package intelligentMobility.impl;

import intelligentMobility.Driver_Preference;
import intelligentMobility.Environment_Condition;
import intelligentMobility.IntelligentMobilityPackage;
import intelligentMobility.Link_DriverPreference_EnvironmentCondition;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Link Driver Preference Environment Condition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.impl.Link_DriverPreference_EnvironmentConditionImpl#getName_link_preference_condition <em>Name link preference condition</em>}</li>
 *   <li>{@link intelligentMobility.impl.Link_DriverPreference_EnvironmentConditionImpl#getLink_driver_preference <em>Link driver preference</em>}</li>
 *   <li>{@link intelligentMobility.impl.Link_DriverPreference_EnvironmentConditionImpl#getLink_environment_condition <em>Link environment condition</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Link_DriverPreference_EnvironmentConditionImpl extends MinimalEObjectImpl.Container implements Link_DriverPreference_EnvironmentCondition {
	/**
	 * The default value of the '{@link #getName_link_preference_condition() <em>Name link preference condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName_link_preference_condition()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_LINK_PREFERENCE_CONDITION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName_link_preference_condition() <em>Name link preference condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName_link_preference_condition()
	 * @generated
	 * @ordered
	 */
	protected String name_link_preference_condition = NAME_LINK_PREFERENCE_CONDITION_EDEFAULT;

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
	 * The cached value of the '{@link #getLink_environment_condition() <em>Link environment condition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_environment_condition()
	 * @generated
	 * @ordered
	 */
	protected Environment_Condition link_environment_condition;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Link_DriverPreference_EnvironmentConditionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return IntelligentMobilityPackage.eINSTANCE.getLink_DriverPreference_EnvironmentCondition();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName_link_preference_condition() {
		return name_link_preference_condition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName_link_preference_condition(String newName_link_preference_condition) {
		String oldName_link_preference_condition = name_link_preference_condition;
		name_link_preference_condition = newName_link_preference_condition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_DRIVER_PREFERENCE_ENVIRONMENT_CONDITION__NAME_LINK_PREFERENCE_CONDITION, oldName_link_preference_condition, name_link_preference_condition));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LINK_DRIVER_PREFERENCE_ENVIRONMENT_CONDITION__LINK_DRIVER_PREFERENCE, oldLink_driver_preference, link_driver_preference));
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
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_DRIVER_PREFERENCE_ENVIRONMENT_CONDITION__LINK_DRIVER_PREFERENCE, oldLink_driver_preference, link_driver_preference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Environment_Condition getLink_environment_condition() {
		if (link_environment_condition != null && link_environment_condition.eIsProxy()) {
			InternalEObject oldLink_environment_condition = (InternalEObject)link_environment_condition;
			link_environment_condition = (Environment_Condition)eResolveProxy(oldLink_environment_condition);
			if (link_environment_condition != oldLink_environment_condition) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LINK_DRIVER_PREFERENCE_ENVIRONMENT_CONDITION__LINK_ENVIRONMENT_CONDITION, oldLink_environment_condition, link_environment_condition));
			}
		}
		return link_environment_condition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Environment_Condition basicGetLink_environment_condition() {
		return link_environment_condition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLink_environment_condition(Environment_Condition newLink_environment_condition) {
		Environment_Condition oldLink_environment_condition = link_environment_condition;
		link_environment_condition = newLink_environment_condition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_DRIVER_PREFERENCE_ENVIRONMENT_CONDITION__LINK_ENVIRONMENT_CONDITION, oldLink_environment_condition, link_environment_condition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IntelligentMobilityPackage.LINK_DRIVER_PREFERENCE_ENVIRONMENT_CONDITION__NAME_LINK_PREFERENCE_CONDITION:
				return getName_link_preference_condition();
			case IntelligentMobilityPackage.LINK_DRIVER_PREFERENCE_ENVIRONMENT_CONDITION__LINK_DRIVER_PREFERENCE:
				if (resolve) return getLink_driver_preference();
				return basicGetLink_driver_preference();
			case IntelligentMobilityPackage.LINK_DRIVER_PREFERENCE_ENVIRONMENT_CONDITION__LINK_ENVIRONMENT_CONDITION:
				if (resolve) return getLink_environment_condition();
				return basicGetLink_environment_condition();
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
			case IntelligentMobilityPackage.LINK_DRIVER_PREFERENCE_ENVIRONMENT_CONDITION__NAME_LINK_PREFERENCE_CONDITION:
				setName_link_preference_condition((String)newValue);
				return;
			case IntelligentMobilityPackage.LINK_DRIVER_PREFERENCE_ENVIRONMENT_CONDITION__LINK_DRIVER_PREFERENCE:
				setLink_driver_preference((Driver_Preference)newValue);
				return;
			case IntelligentMobilityPackage.LINK_DRIVER_PREFERENCE_ENVIRONMENT_CONDITION__LINK_ENVIRONMENT_CONDITION:
				setLink_environment_condition((Environment_Condition)newValue);
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
			case IntelligentMobilityPackage.LINK_DRIVER_PREFERENCE_ENVIRONMENT_CONDITION__NAME_LINK_PREFERENCE_CONDITION:
				setName_link_preference_condition(NAME_LINK_PREFERENCE_CONDITION_EDEFAULT);
				return;
			case IntelligentMobilityPackage.LINK_DRIVER_PREFERENCE_ENVIRONMENT_CONDITION__LINK_DRIVER_PREFERENCE:
				setLink_driver_preference((Driver_Preference)null);
				return;
			case IntelligentMobilityPackage.LINK_DRIVER_PREFERENCE_ENVIRONMENT_CONDITION__LINK_ENVIRONMENT_CONDITION:
				setLink_environment_condition((Environment_Condition)null);
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
			case IntelligentMobilityPackage.LINK_DRIVER_PREFERENCE_ENVIRONMENT_CONDITION__NAME_LINK_PREFERENCE_CONDITION:
				return NAME_LINK_PREFERENCE_CONDITION_EDEFAULT == null ? name_link_preference_condition != null : !NAME_LINK_PREFERENCE_CONDITION_EDEFAULT.equals(name_link_preference_condition);
			case IntelligentMobilityPackage.LINK_DRIVER_PREFERENCE_ENVIRONMENT_CONDITION__LINK_DRIVER_PREFERENCE:
				return link_driver_preference != null;
			case IntelligentMobilityPackage.LINK_DRIVER_PREFERENCE_ENVIRONMENT_CONDITION__LINK_ENVIRONMENT_CONDITION:
				return link_environment_condition != null;
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
		result.append(" (name_link_preference_condition: ");
		result.append(name_link_preference_condition);
		result.append(')');
		return result.toString();
	}

} //Link_DriverPreference_EnvironmentConditionImpl
