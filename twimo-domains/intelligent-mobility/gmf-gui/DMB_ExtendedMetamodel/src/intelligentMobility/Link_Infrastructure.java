/**
 */
package intelligentMobility;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link Infrastructure</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.Link_Infrastructure#getName_link_infrastructure <em>Name link infrastructure</em>}</li>
 *   <li>{@link intelligentMobility.Link_Infrastructure#getLink_infrastructure <em>Link infrastructure</em>}</li>
 *   <li>{@link intelligentMobility.Link_Infrastructure#getLink_vehicle_configuration <em>Link vehicle configuration</em>}</li>
 * </ul>
 *
 * @see intelligentMobility.IntelligentMobilityPackage#getLink_Infrastructure()
 * @model
 * @generated
 */
public interface Link_Infrastructure extends EObject {
	/**
	 * Returns the value of the '<em><b>Name link infrastructure</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name link infrastructure</em>' attribute.
	 * @see #setName_link_infrastructure(String)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_Infrastructure_Name_link_infrastructure()
	 * @model
	 * @generated
	 */
	String getName_link_infrastructure();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_Infrastructure#getName_link_infrastructure <em>Name link infrastructure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name link infrastructure</em>' attribute.
	 * @see #getName_link_infrastructure()
	 * @generated
	 */
	void setName_link_infrastructure(String value);

	/**
	 * Returns the value of the '<em><b>Link infrastructure</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link infrastructure</em>' reference.
	 * @see #setLink_infrastructure(Infrastructure)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_Infrastructure_Link_infrastructure()
	 * @model
	 * @generated
	 */
	Infrastructure getLink_infrastructure();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_Infrastructure#getLink_infrastructure <em>Link infrastructure</em>}' reference.
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
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_Infrastructure_Link_vehicle_configuration()
	 * @model
	 * @generated
	 */
	Vehicle_Configuration getLink_vehicle_configuration();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_Infrastructure#getLink_vehicle_configuration <em>Link vehicle configuration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link vehicle configuration</em>' reference.
	 * @see #getLink_vehicle_configuration()
	 * @generated
	 */
	void setLink_vehicle_configuration(Vehicle_Configuration value);

} // Link_Infrastructure
