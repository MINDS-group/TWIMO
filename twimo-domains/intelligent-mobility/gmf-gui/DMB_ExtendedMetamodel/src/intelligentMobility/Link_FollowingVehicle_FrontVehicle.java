/**
 */
package intelligentMobility;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link Following Vehicle Front Vehicle</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.Link_FollowingVehicle_FrontVehicle#getName_link_followingVehicle_frontVehicle <em>Name link following Vehicle front Vehicle</em>}</li>
 *   <li>{@link intelligentMobility.Link_FollowingVehicle_FrontVehicle#getLink_followingVehicle <em>Link following Vehicle</em>}</li>
 *   <li>{@link intelligentMobility.Link_FollowingVehicle_FrontVehicle#getLink_frontVehicle <em>Link front Vehicle</em>}</li>
 * </ul>
 *
 * @see intelligentMobility.IntelligentMobilityPackage#getLink_FollowingVehicle_FrontVehicle()
 * @model
 * @generated
 */
public interface Link_FollowingVehicle_FrontVehicle extends EObject {
	/**
	 * Returns the value of the '<em><b>Name link following Vehicle front Vehicle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name link following Vehicle front Vehicle</em>' attribute.
	 * @see #setName_link_followingVehicle_frontVehicle(String)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_FollowingVehicle_FrontVehicle_Name_link_followingVehicle_frontVehicle()
	 * @model
	 * @generated
	 */
	String getName_link_followingVehicle_frontVehicle();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_FollowingVehicle_FrontVehicle#getName_link_followingVehicle_frontVehicle <em>Name link following Vehicle front Vehicle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name link following Vehicle front Vehicle</em>' attribute.
	 * @see #getName_link_followingVehicle_frontVehicle()
	 * @generated
	 */
	void setName_link_followingVehicle_frontVehicle(String value);

	/**
	 * Returns the value of the '<em><b>Link following Vehicle</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link following Vehicle</em>' reference.
	 * @see #setLink_followingVehicle(Following_Vehicle)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_FollowingVehicle_FrontVehicle_Link_followingVehicle()
	 * @model
	 * @generated
	 */
	Following_Vehicle getLink_followingVehicle();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_FollowingVehicle_FrontVehicle#getLink_followingVehicle <em>Link following Vehicle</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link following Vehicle</em>' reference.
	 * @see #getLink_followingVehicle()
	 * @generated
	 */
	void setLink_followingVehicle(Following_Vehicle value);

	/**
	 * Returns the value of the '<em><b>Link front Vehicle</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link front Vehicle</em>' reference.
	 * @see #setLink_frontVehicle(PlatoonMember)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_FollowingVehicle_FrontVehicle_Link_frontVehicle()
	 * @model
	 * @generated
	 */
	PlatoonMember getLink_frontVehicle();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_FollowingVehicle_FrontVehicle#getLink_frontVehicle <em>Link front Vehicle</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link front Vehicle</em>' reference.
	 * @see #getLink_frontVehicle()
	 * @generated
	 */
	void setLink_frontVehicle(PlatoonMember value);

} // Link_FollowingVehicle_FrontVehicle
