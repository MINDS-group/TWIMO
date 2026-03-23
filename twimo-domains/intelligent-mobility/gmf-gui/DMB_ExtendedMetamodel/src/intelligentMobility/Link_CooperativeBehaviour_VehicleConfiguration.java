/**
 */
package intelligentMobility;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link Cooperative Behaviour Vehicle Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.Link_CooperativeBehaviour_VehicleConfiguration#getName_link_cooperativeBehaviour_vehicleConfiguration <em>Name link cooperative Behaviour vehicle Configuration</em>}</li>
 *   <li>{@link intelligentMobility.Link_CooperativeBehaviour_VehicleConfiguration#getLink_cooperativeBehaviour <em>Link cooperative Behaviour</em>}</li>
 *   <li>{@link intelligentMobility.Link_CooperativeBehaviour_VehicleConfiguration#getLink_vehicleConfiguration <em>Link vehicle Configuration</em>}</li>
 * </ul>
 *
 * @see intelligentMobility.IntelligentMobilityPackage#getLink_CooperativeBehaviour_VehicleConfiguration()
 * @model
 * @generated
 */
public interface Link_CooperativeBehaviour_VehicleConfiguration extends EObject {
	/**
	 * Returns the value of the '<em><b>Name link cooperative Behaviour vehicle Configuration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name link cooperative Behaviour vehicle Configuration</em>' attribute.
	 * @see #setName_link_cooperativeBehaviour_vehicleConfiguration(String)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_CooperativeBehaviour_VehicleConfiguration_Name_link_cooperativeBehaviour_vehicleConfiguration()
	 * @model
	 * @generated
	 */
	String getName_link_cooperativeBehaviour_vehicleConfiguration();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_CooperativeBehaviour_VehicleConfiguration#getName_link_cooperativeBehaviour_vehicleConfiguration <em>Name link cooperative Behaviour vehicle Configuration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name link cooperative Behaviour vehicle Configuration</em>' attribute.
	 * @see #getName_link_cooperativeBehaviour_vehicleConfiguration()
	 * @generated
	 */
	void setName_link_cooperativeBehaviour_vehicleConfiguration(String value);

	/**
	 * Returns the value of the '<em><b>Link cooperative Behaviour</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link cooperative Behaviour</em>' reference.
	 * @see #setLink_cooperativeBehaviour(CooperativeBehavior)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_CooperativeBehaviour_VehicleConfiguration_Link_cooperativeBehaviour()
	 * @model
	 * @generated
	 */
	CooperativeBehavior getLink_cooperativeBehaviour();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_CooperativeBehaviour_VehicleConfiguration#getLink_cooperativeBehaviour <em>Link cooperative Behaviour</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link cooperative Behaviour</em>' reference.
	 * @see #getLink_cooperativeBehaviour()
	 * @generated
	 */
	void setLink_cooperativeBehaviour(CooperativeBehavior value);

	/**
	 * Returns the value of the '<em><b>Link vehicle Configuration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link vehicle Configuration</em>' reference.
	 * @see #setLink_vehicleConfiguration(Vehicle_Configuration)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_CooperativeBehaviour_VehicleConfiguration_Link_vehicleConfiguration()
	 * @model
	 * @generated
	 */
	Vehicle_Configuration getLink_vehicleConfiguration();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_CooperativeBehaviour_VehicleConfiguration#getLink_vehicleConfiguration <em>Link vehicle Configuration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link vehicle Configuration</em>' reference.
	 * @see #getLink_vehicleConfiguration()
	 * @generated
	 */
	void setLink_vehicleConfiguration(Vehicle_Configuration value);

} // Link_CooperativeBehaviour_VehicleConfiguration
