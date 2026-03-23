/**
 */
package intelligentMobility;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link Driving Behaviour Normal Behaviour</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.Link_DrivingBehaviour_NormalBehaviour#getName_link_driving_normal <em>Name link driving normal</em>}</li>
 *   <li>{@link intelligentMobility.Link_DrivingBehaviour_NormalBehaviour#getLink_driving_behaviour <em>Link driving behaviour</em>}</li>
 *   <li>{@link intelligentMobility.Link_DrivingBehaviour_NormalBehaviour#getLink_normal_behaviour <em>Link normal behaviour</em>}</li>
 * </ul>
 *
 * @see intelligentMobility.IntelligentMobilityPackage#getLink_DrivingBehaviour_NormalBehaviour()
 * @model
 * @generated
 */
public interface Link_DrivingBehaviour_NormalBehaviour extends EObject {
	/**
	 * Returns the value of the '<em><b>Name link driving normal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name link driving normal</em>' attribute.
	 * @see #setName_link_driving_normal(String)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_DrivingBehaviour_NormalBehaviour_Name_link_driving_normal()
	 * @model
	 * @generated
	 */
	String getName_link_driving_normal();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_DrivingBehaviour_NormalBehaviour#getName_link_driving_normal <em>Name link driving normal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name link driving normal</em>' attribute.
	 * @see #getName_link_driving_normal()
	 * @generated
	 */
	void setName_link_driving_normal(String value);

	/**
	 * Returns the value of the '<em><b>Link driving behaviour</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link driving behaviour</em>' reference.
	 * @see #setLink_driving_behaviour(Driving_Behaviour)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_DrivingBehaviour_NormalBehaviour_Link_driving_behaviour()
	 * @model
	 * @generated
	 */
	Driving_Behaviour getLink_driving_behaviour();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_DrivingBehaviour_NormalBehaviour#getLink_driving_behaviour <em>Link driving behaviour</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link driving behaviour</em>' reference.
	 * @see #getLink_driving_behaviour()
	 * @generated
	 */
	void setLink_driving_behaviour(Driving_Behaviour value);

	/**
	 * Returns the value of the '<em><b>Link normal behaviour</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link normal behaviour</em>' reference.
	 * @see #setLink_normal_behaviour(Normal_Behaviour)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_DrivingBehaviour_NormalBehaviour_Link_normal_behaviour()
	 * @model
	 * @generated
	 */
	Normal_Behaviour getLink_normal_behaviour();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_DrivingBehaviour_NormalBehaviour#getLink_normal_behaviour <em>Link normal behaviour</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link normal behaviour</em>' reference.
	 * @see #getLink_normal_behaviour()
	 * @generated
	 */
	void setLink_normal_behaviour(Normal_Behaviour value);

} // Link_DrivingBehaviour_NormalBehaviour
