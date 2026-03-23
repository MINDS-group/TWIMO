/**
 */
package intelligentMobility;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link Communication Interface</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.Link_CommunicationInterface#getName_link_communication_interface <em>Name link communication interface</em>}</li>
 *   <li>{@link intelligentMobility.Link_CommunicationInterface#getLink_communication_interface <em>Link communication interface</em>}</li>
 *   <li>{@link intelligentMobility.Link_CommunicationInterface#getLink_vehicle_configuration <em>Link vehicle configuration</em>}</li>
 *   <li>{@link intelligentMobility.Link_CommunicationInterface#getLink_infrastructure <em>Link infrastructure</em>}</li>
 * </ul>
 *
 * @see intelligentMobility.IntelligentMobilityPackage#getLink_CommunicationInterface()
 * @model
 * @generated
 */
public interface Link_CommunicationInterface extends EObject {
	/**
	 * Returns the value of the '<em><b>Name link communication interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name link communication interface</em>' attribute.
	 * @see #setName_link_communication_interface(String)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_CommunicationInterface_Name_link_communication_interface()
	 * @model
	 * @generated
	 */
	String getName_link_communication_interface();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_CommunicationInterface#getName_link_communication_interface <em>Name link communication interface</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name link communication interface</em>' attribute.
	 * @see #getName_link_communication_interface()
	 * @generated
	 */
	void setName_link_communication_interface(String value);

	/**
	 * Returns the value of the '<em><b>Link communication interface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link communication interface</em>' reference.
	 * @see #setLink_communication_interface(CommunicationInterface)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_CommunicationInterface_Link_communication_interface()
	 * @model
	 * @generated
	 */
	CommunicationInterface getLink_communication_interface();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_CommunicationInterface#getLink_communication_interface <em>Link communication interface</em>}' reference.
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
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_CommunicationInterface_Link_vehicle_configuration()
	 * @model
	 * @generated
	 */
	Vehicle_Configuration getLink_vehicle_configuration();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_CommunicationInterface#getLink_vehicle_configuration <em>Link vehicle configuration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link vehicle configuration</em>' reference.
	 * @see #getLink_vehicle_configuration()
	 * @generated
	 */
	void setLink_vehicle_configuration(Vehicle_Configuration value);

	/**
	 * Returns the value of the '<em><b>Link infrastructure</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link infrastructure</em>' reference.
	 * @see #setLink_infrastructure(Link_Infrastructure)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_CommunicationInterface_Link_infrastructure()
	 * @model
	 * @generated
	 */
	Link_Infrastructure getLink_infrastructure();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_CommunicationInterface#getLink_infrastructure <em>Link infrastructure</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link infrastructure</em>' reference.
	 * @see #getLink_infrastructure()
	 * @generated
	 */
	void setLink_infrastructure(Link_Infrastructure value);

} // Link_CommunicationInterface
