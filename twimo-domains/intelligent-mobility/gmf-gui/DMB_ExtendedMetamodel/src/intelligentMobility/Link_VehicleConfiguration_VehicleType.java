/**
 */
package intelligentMobility;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link Vehicle Configuration Vehicle Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.Link_VehicleConfiguration_VehicleType#getName_link_configuration_type <em>Name link configuration type</em>}</li>
 *   <li>{@link intelligentMobility.Link_VehicleConfiguration_VehicleType#getLink_vehicle_configuration <em>Link vehicle configuration</em>}</li>
 *   <li>{@link intelligentMobility.Link_VehicleConfiguration_VehicleType#getLink_vehicle_type <em>Link vehicle type</em>}</li>
 * </ul>
 *
 * @see intelligentMobility.IntelligentMobilityPackage#getLink_VehicleConfiguration_VehicleType()
 * @model
 * @generated
 */
public interface Link_VehicleConfiguration_VehicleType extends EObject {
	/**
	 * Returns the value of the '<em><b>Name link configuration type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name link configuration type</em>' attribute.
	 * @see #setName_link_configuration_type(String)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_VehicleConfiguration_VehicleType_Name_link_configuration_type()
	 * @model
	 * @generated
	 */
	String getName_link_configuration_type();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_VehicleConfiguration_VehicleType#getName_link_configuration_type <em>Name link configuration type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name link configuration type</em>' attribute.
	 * @see #getName_link_configuration_type()
	 * @generated
	 */
	void setName_link_configuration_type(String value);

	/**
	 * Returns the value of the '<em><b>Link vehicle configuration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link vehicle configuration</em>' reference.
	 * @see #setLink_vehicle_configuration(Vehicle_Configuration)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_VehicleConfiguration_VehicleType_Link_vehicle_configuration()
	 * @model
	 * @generated
	 */
	Vehicle_Configuration getLink_vehicle_configuration();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_VehicleConfiguration_VehicleType#getLink_vehicle_configuration <em>Link vehicle configuration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link vehicle configuration</em>' reference.
	 * @see #getLink_vehicle_configuration()
	 * @generated
	 */
	void setLink_vehicle_configuration(Vehicle_Configuration value);

	/**
	 * Returns the value of the '<em><b>Link vehicle type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link vehicle type</em>' reference.
	 * @see #setLink_vehicle_type(Vehicle_Type)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_VehicleConfiguration_VehicleType_Link_vehicle_type()
	 * @model
	 * @generated
	 */
	Vehicle_Type getLink_vehicle_type();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_VehicleConfiguration_VehicleType#getLink_vehicle_type <em>Link vehicle type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link vehicle type</em>' reference.
	 * @see #getLink_vehicle_type()
	 * @generated
	 */
	void setLink_vehicle_type(Vehicle_Type value);

} // Link_VehicleConfiguration_VehicleType
