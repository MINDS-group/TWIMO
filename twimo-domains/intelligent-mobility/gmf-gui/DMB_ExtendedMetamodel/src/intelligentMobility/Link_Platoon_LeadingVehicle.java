/**
 */
package intelligentMobility;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link Platoon Leading Vehicle</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.Link_Platoon_LeadingVehicle#getName_link_platoon_leadingVehicle <em>Name link platoon leading Vehicle</em>}</li>
 *   <li>{@link intelligentMobility.Link_Platoon_LeadingVehicle#getLink_platoon <em>Link platoon</em>}</li>
 *   <li>{@link intelligentMobility.Link_Platoon_LeadingVehicle#getLink_leadingVehicle <em>Link leading Vehicle</em>}</li>
 * </ul>
 *
 * @see intelligentMobility.IntelligentMobilityPackage#getLink_Platoon_LeadingVehicle()
 * @model
 * @generated
 */
public interface Link_Platoon_LeadingVehicle extends EObject {
	/**
	 * Returns the value of the '<em><b>Name link platoon leading Vehicle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name link platoon leading Vehicle</em>' attribute.
	 * @see #setName_link_platoon_leadingVehicle(String)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_Platoon_LeadingVehicle_Name_link_platoon_leadingVehicle()
	 * @model
	 * @generated
	 */
	String getName_link_platoon_leadingVehicle();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_Platoon_LeadingVehicle#getName_link_platoon_leadingVehicle <em>Name link platoon leading Vehicle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name link platoon leading Vehicle</em>' attribute.
	 * @see #getName_link_platoon_leadingVehicle()
	 * @generated
	 */
	void setName_link_platoon_leadingVehicle(String value);

	/**
	 * Returns the value of the '<em><b>Link platoon</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link platoon</em>' reference.
	 * @see #setLink_platoon(Platoon)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_Platoon_LeadingVehicle_Link_platoon()
	 * @model
	 * @generated
	 */
	Platoon getLink_platoon();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_Platoon_LeadingVehicle#getLink_platoon <em>Link platoon</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link platoon</em>' reference.
	 * @see #getLink_platoon()
	 * @generated
	 */
	void setLink_platoon(Platoon value);

	/**
	 * Returns the value of the '<em><b>Link leading Vehicle</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link leading Vehicle</em>' reference.
	 * @see #setLink_leadingVehicle(Leading_Vehicle)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_Platoon_LeadingVehicle_Link_leadingVehicle()
	 * @model
	 * @generated
	 */
	Leading_Vehicle getLink_leadingVehicle();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_Platoon_LeadingVehicle#getLink_leadingVehicle <em>Link leading Vehicle</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link leading Vehicle</em>' reference.
	 * @see #getLink_leadingVehicle()
	 * @generated
	 */
	void setLink_leadingVehicle(Leading_Vehicle value);

} // Link_Platoon_LeadingVehicle
