/**
 */
package intelligentMobility;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link Vehicle Environment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.Link_Vehicle_Environment#getLink_name_vehicle_environment <em>Link name vehicle environment</em>}</li>
 *   <li>{@link intelligentMobility.Link_Vehicle_Environment#getLink_vehicle_configuration <em>Link vehicle configuration</em>}</li>
 *   <li>{@link intelligentMobility.Link_Vehicle_Environment#getLink_environment_background <em>Link environment background</em>}</li>
 * </ul>
 *
 * @see intelligentMobility.IntelligentMobilityPackage#getLink_Vehicle_Environment()
 * @model
 * @generated
 */
public interface Link_Vehicle_Environment extends EObject {
	/**
	 * Returns the value of the '<em><b>Link name vehicle environment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link name vehicle environment</em>' attribute.
	 * @see #setLink_name_vehicle_environment(String)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_Vehicle_Environment_Link_name_vehicle_environment()
	 * @model
	 * @generated
	 */
	String getLink_name_vehicle_environment();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_Vehicle_Environment#getLink_name_vehicle_environment <em>Link name vehicle environment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link name vehicle environment</em>' attribute.
	 * @see #getLink_name_vehicle_environment()
	 * @generated
	 */
	void setLink_name_vehicle_environment(String value);

	/**
	 * Returns the value of the '<em><b>Link vehicle configuration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link vehicle configuration</em>' reference.
	 * @see #setLink_vehicle_configuration(Vehicle_Configuration)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_Vehicle_Environment_Link_vehicle_configuration()
	 * @model
	 * @generated
	 */
	Vehicle_Configuration getLink_vehicle_configuration();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_Vehicle_Environment#getLink_vehicle_configuration <em>Link vehicle configuration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link vehicle configuration</em>' reference.
	 * @see #getLink_vehicle_configuration()
	 * @generated
	 */
	void setLink_vehicle_configuration(Vehicle_Configuration value);

	/**
	 * Returns the value of the '<em><b>Link environment background</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link environment background</em>' reference.
	 * @see #setLink_environment_background(Environment_Background)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_Vehicle_Environment_Link_environment_background()
	 * @model
	 * @generated
	 */
	Environment_Background getLink_environment_background();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_Vehicle_Environment#getLink_environment_background <em>Link environment background</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link environment background</em>' reference.
	 * @see #getLink_environment_background()
	 * @generated
	 */
	void setLink_environment_background(Environment_Background value);

} // Link_Vehicle_Environment
