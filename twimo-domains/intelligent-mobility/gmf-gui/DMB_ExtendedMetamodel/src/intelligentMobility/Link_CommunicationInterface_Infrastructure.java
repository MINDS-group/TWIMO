/**
 */
package intelligentMobility;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link Communication Interface Infrastructure</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.Link_CommunicationInterface_Infrastructure#getName_link_communication_interface_infrastructure <em>Name link communication interface infrastructure</em>}</li>
 *   <li>{@link intelligentMobility.Link_CommunicationInterface_Infrastructure#getLink_communicationInterface <em>Link communication Interface</em>}</li>
 *   <li>{@link intelligentMobility.Link_CommunicationInterface_Infrastructure#getLink_infrastructure <em>Link infrastructure</em>}</li>
 * </ul>
 *
 * @see intelligentMobility.IntelligentMobilityPackage#getLink_CommunicationInterface_Infrastructure()
 * @model
 * @generated
 */
public interface Link_CommunicationInterface_Infrastructure extends EObject {
	/**
	 * Returns the value of the '<em><b>Name link communication interface infrastructure</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name link communication interface infrastructure</em>' attribute.
	 * @see #setName_link_communication_interface_infrastructure(String)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_CommunicationInterface_Infrastructure_Name_link_communication_interface_infrastructure()
	 * @model
	 * @generated
	 */
	String getName_link_communication_interface_infrastructure();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_CommunicationInterface_Infrastructure#getName_link_communication_interface_infrastructure <em>Name link communication interface infrastructure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name link communication interface infrastructure</em>' attribute.
	 * @see #getName_link_communication_interface_infrastructure()
	 * @generated
	 */
	void setName_link_communication_interface_infrastructure(String value);

	/**
	 * Returns the value of the '<em><b>Link communication Interface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link communication Interface</em>' reference.
	 * @see #setLink_communicationInterface(CommunicationInterface)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_CommunicationInterface_Infrastructure_Link_communicationInterface()
	 * @model
	 * @generated
	 */
	CommunicationInterface getLink_communicationInterface();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_CommunicationInterface_Infrastructure#getLink_communicationInterface <em>Link communication Interface</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link communication Interface</em>' reference.
	 * @see #getLink_communicationInterface()
	 * @generated
	 */
	void setLink_communicationInterface(CommunicationInterface value);

	/**
	 * Returns the value of the '<em><b>Link infrastructure</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link infrastructure</em>' reference.
	 * @see #setLink_infrastructure(Infrastructure)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_CommunicationInterface_Infrastructure_Link_infrastructure()
	 * @model
	 * @generated
	 */
	Infrastructure getLink_infrastructure();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_CommunicationInterface_Infrastructure#getLink_infrastructure <em>Link infrastructure</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link infrastructure</em>' reference.
	 * @see #getLink_infrastructure()
	 * @generated
	 */
	void setLink_infrastructure(Infrastructure value);

} // Link_CommunicationInterface_Infrastructure
