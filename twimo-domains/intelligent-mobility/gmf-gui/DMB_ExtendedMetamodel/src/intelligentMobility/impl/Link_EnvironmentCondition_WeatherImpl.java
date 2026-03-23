/**
 */
package intelligentMobility.impl;

import intelligentMobility.Environment_Condition;
import intelligentMobility.IntelligentMobilityPackage;
import intelligentMobility.Link_EnvironmentCondition_Weather;
import intelligentMobility.Weather;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Link Environment Condition Weather</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.impl.Link_EnvironmentCondition_WeatherImpl#getName_link_environmentCondition_weather <em>Name link environment Condition weather</em>}</li>
 *   <li>{@link intelligentMobility.impl.Link_EnvironmentCondition_WeatherImpl#getLink_environmentCondition <em>Link environment Condition</em>}</li>
 *   <li>{@link intelligentMobility.impl.Link_EnvironmentCondition_WeatherImpl#getLink_weather <em>Link weather</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Link_EnvironmentCondition_WeatherImpl extends MinimalEObjectImpl.Container implements Link_EnvironmentCondition_Weather {
	/**
	 * The default value of the '{@link #getName_link_environmentCondition_weather() <em>Name link environment Condition weather</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName_link_environmentCondition_weather()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_LINK_ENVIRONMENT_CONDITION_WEATHER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName_link_environmentCondition_weather() <em>Name link environment Condition weather</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName_link_environmentCondition_weather()
	 * @generated
	 * @ordered
	 */
	protected String name_link_environmentCondition_weather = NAME_LINK_ENVIRONMENT_CONDITION_WEATHER_EDEFAULT;

	/**
	 * The cached value of the '{@link #getLink_environmentCondition() <em>Link environment Condition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_environmentCondition()
	 * @generated
	 * @ordered
	 */
	protected Environment_Condition link_environmentCondition;

	/**
	 * The cached value of the '{@link #getLink_weather() <em>Link weather</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_weather()
	 * @generated
	 * @ordered
	 */
	protected Weather link_weather;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Link_EnvironmentCondition_WeatherImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return IntelligentMobilityPackage.eINSTANCE.getLink_EnvironmentCondition_Weather();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName_link_environmentCondition_weather() {
		return name_link_environmentCondition_weather;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName_link_environmentCondition_weather(String newName_link_environmentCondition_weather) {
		String oldName_link_environmentCondition_weather = name_link_environmentCondition_weather;
		name_link_environmentCondition_weather = newName_link_environmentCondition_weather;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_ENVIRONMENT_CONDITION_WEATHER__NAME_LINK_ENVIRONMENT_CONDITION_WEATHER, oldName_link_environmentCondition_weather, name_link_environmentCondition_weather));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Environment_Condition getLink_environmentCondition() {
		if (link_environmentCondition != null && link_environmentCondition.eIsProxy()) {
			InternalEObject oldLink_environmentCondition = (InternalEObject)link_environmentCondition;
			link_environmentCondition = (Environment_Condition)eResolveProxy(oldLink_environmentCondition);
			if (link_environmentCondition != oldLink_environmentCondition) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LINK_ENVIRONMENT_CONDITION_WEATHER__LINK_ENVIRONMENT_CONDITION, oldLink_environmentCondition, link_environmentCondition));
			}
		}
		return link_environmentCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Environment_Condition basicGetLink_environmentCondition() {
		return link_environmentCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLink_environmentCondition(Environment_Condition newLink_environmentCondition) {
		Environment_Condition oldLink_environmentCondition = link_environmentCondition;
		link_environmentCondition = newLink_environmentCondition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_ENVIRONMENT_CONDITION_WEATHER__LINK_ENVIRONMENT_CONDITION, oldLink_environmentCondition, link_environmentCondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Weather getLink_weather() {
		if (link_weather != null && link_weather.eIsProxy()) {
			InternalEObject oldLink_weather = (InternalEObject)link_weather;
			link_weather = (Weather)eResolveProxy(oldLink_weather);
			if (link_weather != oldLink_weather) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LINK_ENVIRONMENT_CONDITION_WEATHER__LINK_WEATHER, oldLink_weather, link_weather));
			}
		}
		return link_weather;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Weather basicGetLink_weather() {
		return link_weather;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLink_weather(Weather newLink_weather) {
		Weather oldLink_weather = link_weather;
		link_weather = newLink_weather;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_ENVIRONMENT_CONDITION_WEATHER__LINK_WEATHER, oldLink_weather, link_weather));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IntelligentMobilityPackage.LINK_ENVIRONMENT_CONDITION_WEATHER__NAME_LINK_ENVIRONMENT_CONDITION_WEATHER:
				return getName_link_environmentCondition_weather();
			case IntelligentMobilityPackage.LINK_ENVIRONMENT_CONDITION_WEATHER__LINK_ENVIRONMENT_CONDITION:
				if (resolve) return getLink_environmentCondition();
				return basicGetLink_environmentCondition();
			case IntelligentMobilityPackage.LINK_ENVIRONMENT_CONDITION_WEATHER__LINK_WEATHER:
				if (resolve) return getLink_weather();
				return basicGetLink_weather();
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
			case IntelligentMobilityPackage.LINK_ENVIRONMENT_CONDITION_WEATHER__NAME_LINK_ENVIRONMENT_CONDITION_WEATHER:
				setName_link_environmentCondition_weather((String)newValue);
				return;
			case IntelligentMobilityPackage.LINK_ENVIRONMENT_CONDITION_WEATHER__LINK_ENVIRONMENT_CONDITION:
				setLink_environmentCondition((Environment_Condition)newValue);
				return;
			case IntelligentMobilityPackage.LINK_ENVIRONMENT_CONDITION_WEATHER__LINK_WEATHER:
				setLink_weather((Weather)newValue);
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
			case IntelligentMobilityPackage.LINK_ENVIRONMENT_CONDITION_WEATHER__NAME_LINK_ENVIRONMENT_CONDITION_WEATHER:
				setName_link_environmentCondition_weather(NAME_LINK_ENVIRONMENT_CONDITION_WEATHER_EDEFAULT);
				return;
			case IntelligentMobilityPackage.LINK_ENVIRONMENT_CONDITION_WEATHER__LINK_ENVIRONMENT_CONDITION:
				setLink_environmentCondition((Environment_Condition)null);
				return;
			case IntelligentMobilityPackage.LINK_ENVIRONMENT_CONDITION_WEATHER__LINK_WEATHER:
				setLink_weather((Weather)null);
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
			case IntelligentMobilityPackage.LINK_ENVIRONMENT_CONDITION_WEATHER__NAME_LINK_ENVIRONMENT_CONDITION_WEATHER:
				return NAME_LINK_ENVIRONMENT_CONDITION_WEATHER_EDEFAULT == null ? name_link_environmentCondition_weather != null : !NAME_LINK_ENVIRONMENT_CONDITION_WEATHER_EDEFAULT.equals(name_link_environmentCondition_weather);
			case IntelligentMobilityPackage.LINK_ENVIRONMENT_CONDITION_WEATHER__LINK_ENVIRONMENT_CONDITION:
				return link_environmentCondition != null;
			case IntelligentMobilityPackage.LINK_ENVIRONMENT_CONDITION_WEATHER__LINK_WEATHER:
				return link_weather != null;
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
		result.append(" (name_link_environmentCondition_weather: ");
		result.append(name_link_environmentCondition_weather);
		result.append(')');
		return result.toString();
	}

} //Link_EnvironmentCondition_WeatherImpl
