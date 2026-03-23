/**
 */
package intelligentMobility;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link Environment Condition Weather</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.Link_EnvironmentCondition_Weather#getName_link_environmentCondition_weather <em>Name link environment Condition weather</em>}</li>
 *   <li>{@link intelligentMobility.Link_EnvironmentCondition_Weather#getLink_environmentCondition <em>Link environment Condition</em>}</li>
 *   <li>{@link intelligentMobility.Link_EnvironmentCondition_Weather#getLink_weather <em>Link weather</em>}</li>
 * </ul>
 *
 * @see intelligentMobility.IntelligentMobilityPackage#getLink_EnvironmentCondition_Weather()
 * @model
 * @generated
 */
public interface Link_EnvironmentCondition_Weather extends EObject {
	/**
	 * Returns the value of the '<em><b>Name link environment Condition weather</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name link environment Condition weather</em>' attribute.
	 * @see #setName_link_environmentCondition_weather(String)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_EnvironmentCondition_Weather_Name_link_environmentCondition_weather()
	 * @model
	 * @generated
	 */
	String getName_link_environmentCondition_weather();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_EnvironmentCondition_Weather#getName_link_environmentCondition_weather <em>Name link environment Condition weather</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name link environment Condition weather</em>' attribute.
	 * @see #getName_link_environmentCondition_weather()
	 * @generated
	 */
	void setName_link_environmentCondition_weather(String value);

	/**
	 * Returns the value of the '<em><b>Link environment Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link environment Condition</em>' reference.
	 * @see #setLink_environmentCondition(Environment_Condition)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_EnvironmentCondition_Weather_Link_environmentCondition()
	 * @model
	 * @generated
	 */
	Environment_Condition getLink_environmentCondition();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_EnvironmentCondition_Weather#getLink_environmentCondition <em>Link environment Condition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link environment Condition</em>' reference.
	 * @see #getLink_environmentCondition()
	 * @generated
	 */
	void setLink_environmentCondition(Environment_Condition value);

	/**
	 * Returns the value of the '<em><b>Link weather</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link weather</em>' reference.
	 * @see #setLink_weather(Weather)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_EnvironmentCondition_Weather_Link_weather()
	 * @model
	 * @generated
	 */
	Weather getLink_weather();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_EnvironmentCondition_Weather#getLink_weather <em>Link weather</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link weather</em>' reference.
	 * @see #getLink_weather()
	 * @generated
	 */
	void setLink_weather(Weather value);

} // Link_EnvironmentCondition_Weather
