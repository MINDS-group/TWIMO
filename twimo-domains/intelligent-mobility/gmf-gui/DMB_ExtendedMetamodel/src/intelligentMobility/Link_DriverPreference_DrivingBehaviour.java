/**
 */
package intelligentMobility;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link Driver Preference Driving Behaviour</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.Link_DriverPreference_DrivingBehaviour#getName_link_preference_behaviour <em>Name link preference behaviour</em>}</li>
 *   <li>{@link intelligentMobility.Link_DriverPreference_DrivingBehaviour#getLink_driver_preference <em>Link driver preference</em>}</li>
 *   <li>{@link intelligentMobility.Link_DriverPreference_DrivingBehaviour#getLink_driving_behaviour <em>Link driving behaviour</em>}</li>
 * </ul>
 *
 * @see intelligentMobility.IntelligentMobilityPackage#getLink_DriverPreference_DrivingBehaviour()
 * @model
 * @generated
 */
public interface Link_DriverPreference_DrivingBehaviour extends EObject {
	/**
	 * Returns the value of the '<em><b>Name link preference behaviour</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name link preference behaviour</em>' attribute.
	 * @see #setName_link_preference_behaviour(String)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_DriverPreference_DrivingBehaviour_Name_link_preference_behaviour()
	 * @model
	 * @generated
	 */
	String getName_link_preference_behaviour();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_DriverPreference_DrivingBehaviour#getName_link_preference_behaviour <em>Name link preference behaviour</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name link preference behaviour</em>' attribute.
	 * @see #getName_link_preference_behaviour()
	 * @generated
	 */
	void setName_link_preference_behaviour(String value);

	/**
	 * Returns the value of the '<em><b>Link driver preference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link driver preference</em>' reference.
	 * @see #setLink_driver_preference(Driver_Preference)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_DriverPreference_DrivingBehaviour_Link_driver_preference()
	 * @model
	 * @generated
	 */
	Driver_Preference getLink_driver_preference();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_DriverPreference_DrivingBehaviour#getLink_driver_preference <em>Link driver preference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link driver preference</em>' reference.
	 * @see #getLink_driver_preference()
	 * @generated
	 */
	void setLink_driver_preference(Driver_Preference value);

	/**
	 * Returns the value of the '<em><b>Link driving behaviour</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link driving behaviour</em>' reference.
	 * @see #setLink_driving_behaviour(Driving_Behaviour)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_DriverPreference_DrivingBehaviour_Link_driving_behaviour()
	 * @model
	 * @generated
	 */
	Driving_Behaviour getLink_driving_behaviour();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_DriverPreference_DrivingBehaviour#getLink_driving_behaviour <em>Link driving behaviour</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link driving behaviour</em>' reference.
	 * @see #getLink_driving_behaviour()
	 * @generated
	 */
	void setLink_driving_behaviour(Driving_Behaviour value);

} // Link_DriverPreference_DrivingBehaviour
