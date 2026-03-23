/**
 */
package intelligentMobility;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link Cooperative Behaviour Communication Interface</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.Link_CooperativeBehaviour_CommunicationInterface#getName_link_cooperativeBehaviour_communicationInterface <em>Name link cooperative Behaviour communication Interface</em>}</li>
 *   <li>{@link intelligentMobility.Link_CooperativeBehaviour_CommunicationInterface#getLink_cooperativeBehaviour <em>Link cooperative Behaviour</em>}</li>
 *   <li>{@link intelligentMobility.Link_CooperativeBehaviour_CommunicationInterface#getLink_communicationInterface <em>Link communication Interface</em>}</li>
 * </ul>
 *
 * @see intelligentMobility.IntelligentMobilityPackage#getLink_CooperativeBehaviour_CommunicationInterface()
 * @model
 * @generated
 */
public interface Link_CooperativeBehaviour_CommunicationInterface extends EObject {
	/**
	 * Returns the value of the '<em><b>Name link cooperative Behaviour communication Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name link cooperative Behaviour communication Interface</em>' attribute.
	 * @see #setName_link_cooperativeBehaviour_communicationInterface(String)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_CooperativeBehaviour_CommunicationInterface_Name_link_cooperativeBehaviour_communicationInterface()
	 * @model
	 * @generated
	 */
	String getName_link_cooperativeBehaviour_communicationInterface();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_CooperativeBehaviour_CommunicationInterface#getName_link_cooperativeBehaviour_communicationInterface <em>Name link cooperative Behaviour communication Interface</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name link cooperative Behaviour communication Interface</em>' attribute.
	 * @see #getName_link_cooperativeBehaviour_communicationInterface()
	 * @generated
	 */
	void setName_link_cooperativeBehaviour_communicationInterface(String value);

	/**
	 * Returns the value of the '<em><b>Link cooperative Behaviour</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link cooperative Behaviour</em>' reference.
	 * @see #setLink_cooperativeBehaviour(CooperativeBehavior)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_CooperativeBehaviour_CommunicationInterface_Link_cooperativeBehaviour()
	 * @model
	 * @generated
	 */
	CooperativeBehavior getLink_cooperativeBehaviour();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_CooperativeBehaviour_CommunicationInterface#getLink_cooperativeBehaviour <em>Link cooperative Behaviour</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link cooperative Behaviour</em>' reference.
	 * @see #getLink_cooperativeBehaviour()
	 * @generated
	 */
	void setLink_cooperativeBehaviour(CooperativeBehavior value);

	/**
	 * Returns the value of the '<em><b>Link communication Interface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link communication Interface</em>' reference.
	 * @see #setLink_communicationInterface(CommunicationInterface)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_CooperativeBehaviour_CommunicationInterface_Link_communicationInterface()
	 * @model
	 * @generated
	 */
	CommunicationInterface getLink_communicationInterface();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_CooperativeBehaviour_CommunicationInterface#getLink_communicationInterface <em>Link communication Interface</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link communication Interface</em>' reference.
	 * @see #getLink_communicationInterface()
	 * @generated
	 */
	void setLink_communicationInterface(CommunicationInterface value);

} // Link_CooperativeBehaviour_CommunicationInterface
