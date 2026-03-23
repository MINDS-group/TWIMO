/**
 */
package intelligentMobility;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link Driver Preference Driver Emotion</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.Link_DriverPreference_DriverEmotion#getName_link_preference_emotion <em>Name link preference emotion</em>}</li>
 *   <li>{@link intelligentMobility.Link_DriverPreference_DriverEmotion#getLink_driver_preference <em>Link driver preference</em>}</li>
 *   <li>{@link intelligentMobility.Link_DriverPreference_DriverEmotion#getLink_driver_emotion <em>Link driver emotion</em>}</li>
 * </ul>
 *
 * @see intelligentMobility.IntelligentMobilityPackage#getLink_DriverPreference_DriverEmotion()
 * @model
 * @generated
 */
public interface Link_DriverPreference_DriverEmotion extends EObject {
	/**
	 * Returns the value of the '<em><b>Name link preference emotion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name link preference emotion</em>' attribute.
	 * @see #setName_link_preference_emotion(String)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_DriverPreference_DriverEmotion_Name_link_preference_emotion()
	 * @model
	 * @generated
	 */
	String getName_link_preference_emotion();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_DriverPreference_DriverEmotion#getName_link_preference_emotion <em>Name link preference emotion</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name link preference emotion</em>' attribute.
	 * @see #getName_link_preference_emotion()
	 * @generated
	 */
	void setName_link_preference_emotion(String value);

	/**
	 * Returns the value of the '<em><b>Link driver preference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link driver preference</em>' reference.
	 * @see #setLink_driver_preference(Driver_Preference)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_DriverPreference_DriverEmotion_Link_driver_preference()
	 * @model
	 * @generated
	 */
	Driver_Preference getLink_driver_preference();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_DriverPreference_DriverEmotion#getLink_driver_preference <em>Link driver preference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link driver preference</em>' reference.
	 * @see #getLink_driver_preference()
	 * @generated
	 */
	void setLink_driver_preference(Driver_Preference value);

	/**
	 * Returns the value of the '<em><b>Link driver emotion</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link driver emotion</em>' reference.
	 * @see #setLink_driver_emotion(Driver_Emotion)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_DriverPreference_DriverEmotion_Link_driver_emotion()
	 * @model
	 * @generated
	 */
	Driver_Emotion getLink_driver_emotion();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_DriverPreference_DriverEmotion#getLink_driver_emotion <em>Link driver emotion</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link driver emotion</em>' reference.
	 * @see #getLink_driver_emotion()
	 * @generated
	 */
	void setLink_driver_emotion(Driver_Emotion value);

} // Link_DriverPreference_DriverEmotion
