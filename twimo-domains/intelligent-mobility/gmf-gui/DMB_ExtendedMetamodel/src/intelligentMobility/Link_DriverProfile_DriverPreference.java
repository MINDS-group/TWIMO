/**
 */
package intelligentMobility;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link Driver Profile Driver Preference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.Link_DriverProfile_DriverPreference#getName_link_profile_preference <em>Name link profile preference</em>}</li>
 *   <li>{@link intelligentMobility.Link_DriverProfile_DriverPreference#getLink_driver_profile <em>Link driver profile</em>}</li>
 *   <li>{@link intelligentMobility.Link_DriverProfile_DriverPreference#getLink_driver_preference <em>Link driver preference</em>}</li>
 * </ul>
 *
 * @see intelligentMobility.IntelligentMobilityPackage#getLink_DriverProfile_DriverPreference()
 * @model
 * @generated
 */
public interface Link_DriverProfile_DriverPreference extends EObject {
	/**
	 * Returns the value of the '<em><b>Name link profile preference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name link profile preference</em>' attribute.
	 * @see #setName_link_profile_preference(String)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_DriverProfile_DriverPreference_Name_link_profile_preference()
	 * @model
	 * @generated
	 */
	String getName_link_profile_preference();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_DriverProfile_DriverPreference#getName_link_profile_preference <em>Name link profile preference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name link profile preference</em>' attribute.
	 * @see #getName_link_profile_preference()
	 * @generated
	 */
	void setName_link_profile_preference(String value);

	/**
	 * Returns the value of the '<em><b>Link driver profile</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link driver profile</em>' reference.
	 * @see #setLink_driver_profile(Driver_Profile)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_DriverProfile_DriverPreference_Link_driver_profile()
	 * @model
	 * @generated
	 */
	Driver_Profile getLink_driver_profile();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_DriverProfile_DriverPreference#getLink_driver_profile <em>Link driver profile</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link driver profile</em>' reference.
	 * @see #getLink_driver_profile()
	 * @generated
	 */
	void setLink_driver_profile(Driver_Profile value);

	/**
	 * Returns the value of the '<em><b>Link driver preference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link driver preference</em>' reference.
	 * @see #setLink_driver_preference(Driver_Preference)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_DriverProfile_DriverPreference_Link_driver_preference()
	 * @model
	 * @generated
	 */
	Driver_Preference getLink_driver_preference();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_DriverProfile_DriverPreference#getLink_driver_preference <em>Link driver preference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link driver preference</em>' reference.
	 * @see #getLink_driver_preference()
	 * @generated
	 */
	void setLink_driver_preference(Driver_Preference value);

} // Link_DriverProfile_DriverPreference
