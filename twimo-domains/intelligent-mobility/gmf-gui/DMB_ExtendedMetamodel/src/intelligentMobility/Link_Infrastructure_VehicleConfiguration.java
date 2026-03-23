/**
 */
package intelligentMobility;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link Infrastructure Vehicle Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.Link_Infrastructure_VehicleConfiguration#getName_link_infrastructure_vehicleConfiguration <em>Name link infrastructure vehicle Configuration</em>}</li>
 *   <li>{@link intelligentMobility.Link_Infrastructure_VehicleConfiguration#getLink_infrastructure <em>Link infrastructure</em>}</li>
 *   <li>{@link intelligentMobility.Link_Infrastructure_VehicleConfiguration#getLink_vehicle_configuration <em>Link vehicle configuration</em>}</li>
 * </ul>
 *
 * @see intelligentMobility.IntelligentMobilityPackage#getLink_Infrastructure_VehicleConfiguration()
 * @model
 * @generated
 */
public interface Link_Infrastructure_VehicleConfiguration extends EObject {
	/**
	 * Returns the value of the '<em><b>Name link infrastructure vehicle Configuration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name link infrastructure vehicle Configuration</em>' attribute.
	 * @see #setName_link_infrastructure_vehicleConfiguration(String)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_Infrastructure_VehicleConfiguration_Name_link_infrastructure_vehicleConfiguration()
	 * @model
	 * @generated
	 */
	String getName_link_infrastructure_vehicleConfiguration();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_Infrastructure_VehicleConfiguration#getName_link_infrastructure_vehicleConfiguration <em>Name link infrastructure vehicle Configuration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name link infrastructure vehicle Configuration</em>' attribute.
	 * @see #getName_link_infrastructure_vehicleConfiguration()
	 * @generated
	 */
	void setName_link_infrastructure_vehicleConfiguration(String value);

	/**
	 * Returns the value of the '<em><b>Link infrastructure</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link infrastructure</em>' reference.
	 * @see #setLink_infrastructure(Infrastructure)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_Infrastructure_VehicleConfiguration_Link_infrastructure()
	 * @model
	 * @generated
	 */
	Infrastructure getLink_infrastructure();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_Infrastructure_VehicleConfiguration#getLink_infrastructure <em>Link infrastructure</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link infrastructure</em>' reference.
	 * @see #getLink_infrastructure()
	 * @generated
	 */
	void setLink_infrastructure(Infrastructure value);

	/**
	 * Returns the value of the '<em><b>Link vehicle configuration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link vehicle configuration</em>' reference.
	 * @see #setLink_vehicle_configuration(Vehicle_Configuration)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_Infrastructure_VehicleConfiguration_Link_vehicle_configuration()
	 * @model
	 * @generated
	 */
	Vehicle_Configuration getLink_vehicle_configuration();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_Infrastructure_VehicleConfiguration#getLink_vehicle_configuration <em>Link vehicle configuration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link vehicle configuration</em>' reference.
	 * @see #getLink_vehicle_configuration()
	 * @generated
	 */
	void setLink_vehicle_configuration(Vehicle_Configuration value);

} // Link_Infrastructure_VehicleConfiguration
