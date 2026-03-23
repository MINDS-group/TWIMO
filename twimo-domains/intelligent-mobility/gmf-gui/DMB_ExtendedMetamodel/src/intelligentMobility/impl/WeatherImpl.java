/**
 */
package intelligentMobility.impl;

import intelligentMobility.IntelligentMobilityPackage;
import intelligentMobility.Weather;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Weather</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.impl.WeatherImpl#getSlipperiness <em>Slipperiness</em>}</li>
 *   <li>{@link intelligentMobility.impl.WeatherImpl#getWeatherType <em>Weather Type</em>}</li>
 *   <li>{@link intelligentMobility.impl.WeatherImpl#getName <em>Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class WeatherImpl extends MinimalEObjectImpl.Container implements Weather {
	/**
	 * The default value of the '{@link #getSlipperiness() <em>Slipperiness</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSlipperiness()
	 * @generated
	 * @ordered
	 */
	protected static final int SLIPPERINESS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSlipperiness() <em>Slipperiness</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSlipperiness()
	 * @generated
	 * @ordered
	 */
	protected int slipperiness = SLIPPERINESS_EDEFAULT;

	/**
	 * The default value of the '{@link #getWeatherType() <em>Weather Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWeatherType()
	 * @generated
	 * @ordered
	 */
	protected static final String WEATHER_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getWeatherType() <em>Weather Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWeatherType()
	 * @generated
	 * @ordered
	 */
	protected String weatherType = WEATHER_TYPE_EDEFAULT;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WeatherImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return IntelligentMobilityPackage.eINSTANCE.getWeather();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSlipperiness() {
		return slipperiness;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSlipperiness(int newSlipperiness) {
		int oldSlipperiness = slipperiness;
		slipperiness = newSlipperiness;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.WEATHER__SLIPPERINESS, oldSlipperiness, slipperiness));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getWeatherType() {
		return weatherType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWeatherType(String newWeatherType) {
		String oldWeatherType = weatherType;
		weatherType = newWeatherType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.WEATHER__WEATHER_TYPE, oldWeatherType, weatherType));
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
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.WEATHER__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IntelligentMobilityPackage.WEATHER__SLIPPERINESS:
				return new Integer(getSlipperiness());
			case IntelligentMobilityPackage.WEATHER__WEATHER_TYPE:
				return getWeatherType();
			case IntelligentMobilityPackage.WEATHER__NAME:
				return getName();
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
			case IntelligentMobilityPackage.WEATHER__SLIPPERINESS:
				setSlipperiness(((Integer)newValue).intValue());
				return;
			case IntelligentMobilityPackage.WEATHER__WEATHER_TYPE:
				setWeatherType((String)newValue);
				return;
			case IntelligentMobilityPackage.WEATHER__NAME:
				setName((String)newValue);
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
			case IntelligentMobilityPackage.WEATHER__SLIPPERINESS:
				setSlipperiness(SLIPPERINESS_EDEFAULT);
				return;
			case IntelligentMobilityPackage.WEATHER__WEATHER_TYPE:
				setWeatherType(WEATHER_TYPE_EDEFAULT);
				return;
			case IntelligentMobilityPackage.WEATHER__NAME:
				setName(NAME_EDEFAULT);
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
			case IntelligentMobilityPackage.WEATHER__SLIPPERINESS:
				return slipperiness != SLIPPERINESS_EDEFAULT;
			case IntelligentMobilityPackage.WEATHER__WEATHER_TYPE:
				return WEATHER_TYPE_EDEFAULT == null ? weatherType != null : !WEATHER_TYPE_EDEFAULT.equals(weatherType);
			case IntelligentMobilityPackage.WEATHER__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
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
		result.append(" (slipperiness: ");
		result.append(slipperiness);
		result.append(", weatherType: ");
		result.append(weatherType);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //WeatherImpl
