/**
 */
package intelligentMobility;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link Driver Preference Environment Condition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.Link_DriverPreference_EnvironmentCondition#getName_link_preference_condition <em>Name link preference condition</em>}</li>
 *   <li>{@link intelligentMobility.Link_DriverPreference_EnvironmentCondition#getLink_driver_preference <em>Link driver preference</em>}</li>
 *   <li>{@link intelligentMobility.Link_DriverPreference_EnvironmentCondition#getLink_environment_condition <em>Link environment condition</em>}</li>
 * </ul>
 *
 * @see intelligentMobility.IntelligentMobilityPackage#getLink_DriverPreference_EnvironmentCondition()
 * @model
 * @generated
 */
public interface Link_DriverPreference_EnvironmentCondition extends EObject {
	/**
	 * Returns the value of the '<em><b>Name link preference condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name link preference condition</em>' attribute.
	 * @see #setName_link_preference_condition(String)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_DriverPreference_EnvironmentCondition_Name_link_preference_condition()
	 * @model
	 * @generated
	 */
	String getName_link_preference_condition();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_DriverPreference_EnvironmentCondition#getName_link_preference_condition <em>Name link preference condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name link preference condition</em>' attribute.
	 * @see #getName_link_preference_condition()
	 * @generated
	 */
	void setName_link_preference_condition(String value);

	/**
	 * Returns the value of the '<em><b>Link driver preference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link driver preference</em>' reference.
	 * @see #setLink_driver_preference(Driver_Preference)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_DriverPreference_EnvironmentCondition_Link_driver_preference()
	 * @model
	 * @generated
	 */
	Driver_Preference getLink_driver_preference();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_DriverPreference_EnvironmentCondition#getLink_driver_preference <em>Link driver preference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link driver preference</em>' reference.
	 * @see #getLink_driver_preference()
	 * @generated
	 */
	void setLink_driver_preference(Driver_Preference value);

	/**
	 * Returns the value of the '<em><b>Link environment condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link environment condition</em>' reference.
	 * @see #setLink_environment_condition(Environment_Condition)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_DriverPreference_EnvironmentCondition_Link_environment_condition()
	 * @model
	 * @generated
	 */
	Environment_Condition getLink_environment_condition();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_DriverPreference_EnvironmentCondition#getLink_environment_condition <em>Link environment condition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link environment condition</em>' reference.
	 * @see #getLink_environment_condition()
	 * @generated
	 */
	void setLink_environment_condition(Environment_Condition value);

} // Link_DriverPreference_EnvironmentCondition
