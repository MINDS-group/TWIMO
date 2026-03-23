/**
 */
package intelligentMobility;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link Driver Environment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.Link_Driver_Environment#getLink_name_driver_environment <em>Link name driver environment</em>}</li>
 *   <li>{@link intelligentMobility.Link_Driver_Environment#getLink_driver_profile <em>Link driver profile</em>}</li>
 *   <li>{@link intelligentMobility.Link_Driver_Environment#getLink_environment_background <em>Link environment background</em>}</li>
 * </ul>
 *
 * @see intelligentMobility.IntelligentMobilityPackage#getLink_Driver_Environment()
 * @model
 * @generated
 */
public interface Link_Driver_Environment extends EObject {
	/**
	 * Returns the value of the '<em><b>Link name driver environment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link name driver environment</em>' attribute.
	 * @see #setLink_name_driver_environment(String)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_Driver_Environment_Link_name_driver_environment()
	 * @model
	 * @generated
	 */
	String getLink_name_driver_environment();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_Driver_Environment#getLink_name_driver_environment <em>Link name driver environment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link name driver environment</em>' attribute.
	 * @see #getLink_name_driver_environment()
	 * @generated
	 */
	void setLink_name_driver_environment(String value);

	/**
	 * Returns the value of the '<em><b>Link driver profile</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link driver profile</em>' reference.
	 * @see #setLink_driver_profile(Driver_Profile)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_Driver_Environment_Link_driver_profile()
	 * @model
	 * @generated
	 */
	Driver_Profile getLink_driver_profile();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_Driver_Environment#getLink_driver_profile <em>Link driver profile</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link driver profile</em>' reference.
	 * @see #getLink_driver_profile()
	 * @generated
	 */
	void setLink_driver_profile(Driver_Profile value);

	/**
	 * Returns the value of the '<em><b>Link environment background</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link environment background</em>' reference.
	 * @see #setLink_environment_background(Environment_Background)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_Driver_Environment_Link_environment_background()
	 * @model
	 * @generated
	 */
	Environment_Background getLink_environment_background();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_Driver_Environment#getLink_environment_background <em>Link environment background</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link environment background</em>' reference.
	 * @see #getLink_environment_background()
	 * @generated
	 */
	void setLink_environment_background(Environment_Background value);

} // Link_Driver_Environment
