/**
 */
package intelligentMobility;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Weather</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.Weather#getSlipperiness <em>Slipperiness</em>}</li>
 *   <li>{@link intelligentMobility.Weather#getWeatherType <em>Weather Type</em>}</li>
 *   <li>{@link intelligentMobility.Weather#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see intelligentMobility.IntelligentMobilityPackage#getWeather()
 * @model
 * @generated
 */
public interface Weather extends EObject {
	/**
	 * Returns the value of the '<em><b>Slipperiness</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Slipperiness</em>' attribute.
	 * @see #setSlipperiness(int)
	 * @see intelligentMobility.IntelligentMobilityPackage#getWeather_Slipperiness()
	 * @model
	 * @generated
	 */
	int getSlipperiness();

	/**
	 * Sets the value of the '{@link intelligentMobility.Weather#getSlipperiness <em>Slipperiness</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Slipperiness</em>' attribute.
	 * @see #getSlipperiness()
	 * @generated
	 */
	void setSlipperiness(int value);

	/**
	 * Returns the value of the '<em><b>Weather Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Weather Type</em>' attribute.
	 * @see #setWeatherType(String)
	 * @see intelligentMobility.IntelligentMobilityPackage#getWeather_WeatherType()
	 * @model
	 * @generated
	 */
	String getWeatherType();

	/**
	 * Sets the value of the '{@link intelligentMobility.Weather#getWeatherType <em>Weather Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Weather Type</em>' attribute.
	 * @see #getWeatherType()
	 * @generated
	 */
	void setWeatherType(String value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see intelligentMobility.IntelligentMobilityPackage#getWeather_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link intelligentMobility.Weather#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // Weather
