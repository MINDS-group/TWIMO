/**
 */
package intelligentMobility;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link Environment Background Possible Vehicle</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.Link_EnvironmentBackground_PossibleVehicle#getName_link_background_possibleVehicle <em>Name link background possible Vehicle</em>}</li>
 *   <li>{@link intelligentMobility.Link_EnvironmentBackground_PossibleVehicle#getLink_environment_background <em>Link environment background</em>}</li>
 *   <li>{@link intelligentMobility.Link_EnvironmentBackground_PossibleVehicle#getLink_possible_vehicle <em>Link possible vehicle</em>}</li>
 * </ul>
 *
 * @see intelligentMobility.IntelligentMobilityPackage#getLink_EnvironmentBackground_PossibleVehicle()
 * @model
 * @generated
 */
public interface Link_EnvironmentBackground_PossibleVehicle extends EObject {
	/**
	 * Returns the value of the '<em><b>Name link background possible Vehicle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name link background possible Vehicle</em>' attribute.
	 * @see #setName_link_background_possibleVehicle(String)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_EnvironmentBackground_PossibleVehicle_Name_link_background_possibleVehicle()
	 * @model
	 * @generated
	 */
	String getName_link_background_possibleVehicle();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_EnvironmentBackground_PossibleVehicle#getName_link_background_possibleVehicle <em>Name link background possible Vehicle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name link background possible Vehicle</em>' attribute.
	 * @see #getName_link_background_possibleVehicle()
	 * @generated
	 */
	void setName_link_background_possibleVehicle(String value);

	/**
	 * Returns the value of the '<em><b>Link environment background</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link environment background</em>' reference.
	 * @see #setLink_environment_background(Environment_Background)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_EnvironmentBackground_PossibleVehicle_Link_environment_background()
	 * @model
	 * @generated
	 */
	Environment_Background getLink_environment_background();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_EnvironmentBackground_PossibleVehicle#getLink_environment_background <em>Link environment background</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link environment background</em>' reference.
	 * @see #getLink_environment_background()
	 * @generated
	 */
	void setLink_environment_background(Environment_Background value);

	/**
	 * Returns the value of the '<em><b>Link possible vehicle</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link possible vehicle</em>' reference.
	 * @see #setLink_possible_vehicle(PossibleVehicle)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_EnvironmentBackground_PossibleVehicle_Link_possible_vehicle()
	 * @model
	 * @generated
	 */
	PossibleVehicle getLink_possible_vehicle();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_EnvironmentBackground_PossibleVehicle#getLink_possible_vehicle <em>Link possible vehicle</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link possible vehicle</em>' reference.
	 * @see #getLink_possible_vehicle()
	 * @generated
	 */
	void setLink_possible_vehicle(PossibleVehicle value);

} // Link_EnvironmentBackground_PossibleVehicle
