/**
 */
package intelligentMobility;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link Driver Vehicle</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.Link_Driver_Vehicle#getLink_name_driver_vehicle <em>Link name driver vehicle</em>}</li>
 *   <li>{@link intelligentMobility.Link_Driver_Vehicle#getLink_driver_profile <em>Link driver profile</em>}</li>
 *   <li>{@link intelligentMobility.Link_Driver_Vehicle#getLink_vehicle_configuration <em>Link vehicle configuration</em>}</li>
 * </ul>
 *
 * @see intelligentMobility.IntelligentMobilityPackage#getLink_Driver_Vehicle()
 * @model
 * @generated
 */
public interface Link_Driver_Vehicle extends EObject {
	/**
	 * Returns the value of the '<em><b>Link name driver vehicle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link name driver vehicle</em>' attribute.
	 * @see #setLink_name_driver_vehicle(String)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_Driver_Vehicle_Link_name_driver_vehicle()
	 * @model
	 * @generated
	 */
	String getLink_name_driver_vehicle();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_Driver_Vehicle#getLink_name_driver_vehicle <em>Link name driver vehicle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link name driver vehicle</em>' attribute.
	 * @see #getLink_name_driver_vehicle()
	 * @generated
	 */
	void setLink_name_driver_vehicle(String value);

	/**
	 * Returns the value of the '<em><b>Link driver profile</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link driver profile</em>' reference.
	 * @see #setLink_driver_profile(Driver_Profile)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_Driver_Vehicle_Link_driver_profile()
	 * @model
	 * @generated
	 */
	Driver_Profile getLink_driver_profile();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_Driver_Vehicle#getLink_driver_profile <em>Link driver profile</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link driver profile</em>' reference.
	 * @see #getLink_driver_profile()
	 * @generated
	 */
	void setLink_driver_profile(Driver_Profile value);

	/**
	 * Returns the value of the '<em><b>Link vehicle configuration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link vehicle configuration</em>' reference.
	 * @see #setLink_vehicle_configuration(Vehicle_Configuration)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_Driver_Vehicle_Link_vehicle_configuration()
	 * @model
	 * @generated
	 */
	Vehicle_Configuration getLink_vehicle_configuration();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_Driver_Vehicle#getLink_vehicle_configuration <em>Link vehicle configuration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link vehicle configuration</em>' reference.
	 * @see #getLink_vehicle_configuration()
	 * @generated
	 */
	void setLink_vehicle_configuration(Vehicle_Configuration value);

} // Link_Driver_Vehicle
