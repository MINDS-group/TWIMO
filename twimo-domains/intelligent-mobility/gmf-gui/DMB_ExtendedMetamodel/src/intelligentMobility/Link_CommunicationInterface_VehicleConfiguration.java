/**
 */
package intelligentMobility;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link Communication Interface Vehicle Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.Link_CommunicationInterface_VehicleConfiguration#getName_link_communication_interface_vehicleConfiguration <em>Name link communication interface vehicle Configuration</em>}</li>
 *   <li>{@link intelligentMobility.Link_CommunicationInterface_VehicleConfiguration#getLink_communication_interface <em>Link communication interface</em>}</li>
 *   <li>{@link intelligentMobility.Link_CommunicationInterface_VehicleConfiguration#getLink_vehicle_configuration <em>Link vehicle configuration</em>}</li>
 * </ul>
 *
 * @see intelligentMobility.IntelligentMobilityPackage#getLink_CommunicationInterface_VehicleConfiguration()
 * @model
 * @generated
 */
public interface Link_CommunicationInterface_VehicleConfiguration extends EObject {
	/**
	 * Returns the value of the '<em><b>Name link communication interface vehicle Configuration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name link communication interface vehicle Configuration</em>' attribute.
	 * @see #setName_link_communication_interface_vehicleConfiguration(String)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_CommunicationInterface_VehicleConfiguration_Name_link_communication_interface_vehicleConfiguration()
	 * @model
	 * @generated
	 */
	String getName_link_communication_interface_vehicleConfiguration();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_CommunicationInterface_VehicleConfiguration#getName_link_communication_interface_vehicleConfiguration <em>Name link communication interface vehicle Configuration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name link communication interface vehicle Configuration</em>' attribute.
	 * @see #getName_link_communication_interface_vehicleConfiguration()
	 * @generated
	 */
	void setName_link_communication_interface_vehicleConfiguration(String value);

	/**
	 * Returns the value of the '<em><b>Link communication interface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link communication interface</em>' reference.
	 * @see #setLink_communication_interface(CommunicationInterface)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_CommunicationInterface_VehicleConfiguration_Link_communication_interface()
	 * @model
	 * @generated
	 */
	CommunicationInterface getLink_communication_interface();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_CommunicationInterface_VehicleConfiguration#getLink_communication_interface <em>Link communication interface</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link communication interface</em>' reference.
	 * @see #getLink_communication_interface()
	 * @generated
	 */
	void setLink_communication_interface(CommunicationInterface value);

	/**
	 * Returns the value of the '<em><b>Link vehicle configuration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link vehicle configuration</em>' reference.
	 * @see #setLink_vehicle_configuration(Vehicle_Configuration)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_CommunicationInterface_VehicleConfiguration_Link_vehicle_configuration()
	 * @model
	 * @generated
	 */
	Vehicle_Configuration getLink_vehicle_configuration();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_CommunicationInterface_VehicleConfiguration#getLink_vehicle_configuration <em>Link vehicle configuration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link vehicle configuration</em>' reference.
	 * @see #getLink_vehicle_configuration()
	 * @generated
	 */
	void setLink_vehicle_configuration(Vehicle_Configuration value);

} // Link_CommunicationInterface_VehicleConfiguration
