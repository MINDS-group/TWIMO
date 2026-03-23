/**
 */
package intelligentMobility;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link Platoon Following Vehicle</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.Link_Platoon_FollowingVehicle#getName_link_platoon_followingVehicle <em>Name link platoon following Vehicle</em>}</li>
 *   <li>{@link intelligentMobility.Link_Platoon_FollowingVehicle#getLink_platoon <em>Link platoon</em>}</li>
 *   <li>{@link intelligentMobility.Link_Platoon_FollowingVehicle#getLink_followingVehicle <em>Link following Vehicle</em>}</li>
 * </ul>
 *
 * @see intelligentMobility.IntelligentMobilityPackage#getLink_Platoon_FollowingVehicle()
 * @model
 * @generated
 */
public interface Link_Platoon_FollowingVehicle extends EObject {
	/**
	 * Returns the value of the '<em><b>Name link platoon following Vehicle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name link platoon following Vehicle</em>' attribute.
	 * @see #setName_link_platoon_followingVehicle(String)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_Platoon_FollowingVehicle_Name_link_platoon_followingVehicle()
	 * @model
	 * @generated
	 */
	String getName_link_platoon_followingVehicle();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_Platoon_FollowingVehicle#getName_link_platoon_followingVehicle <em>Name link platoon following Vehicle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name link platoon following Vehicle</em>' attribute.
	 * @see #getName_link_platoon_followingVehicle()
	 * @generated
	 */
	void setName_link_platoon_followingVehicle(String value);

	/**
	 * Returns the value of the '<em><b>Link platoon</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link platoon</em>' reference.
	 * @see #setLink_platoon(Platoon)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_Platoon_FollowingVehicle_Link_platoon()
	 * @model
	 * @generated
	 */
	Platoon getLink_platoon();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_Platoon_FollowingVehicle#getLink_platoon <em>Link platoon</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link platoon</em>' reference.
	 * @see #getLink_platoon()
	 * @generated
	 */
	void setLink_platoon(Platoon value);

	/**
	 * Returns the value of the '<em><b>Link following Vehicle</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link following Vehicle</em>' reference.
	 * @see #setLink_followingVehicle(Following_Vehicle)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_Platoon_FollowingVehicle_Link_followingVehicle()
	 * @model
	 * @generated
	 */
	Following_Vehicle getLink_followingVehicle();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_Platoon_FollowingVehicle#getLink_followingVehicle <em>Link following Vehicle</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link following Vehicle</em>' reference.
	 * @see #getLink_followingVehicle()
	 * @generated
	 */
	void setLink_followingVehicle(Following_Vehicle value);

} // Link_Platoon_FollowingVehicle
