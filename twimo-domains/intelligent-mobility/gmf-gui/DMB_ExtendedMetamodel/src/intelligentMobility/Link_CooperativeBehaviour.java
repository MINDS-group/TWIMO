/**
 */
package intelligentMobility;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link Cooperative Behaviour</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.Link_CooperativeBehaviour#getName_link_cooperativeBehaviour <em>Name link cooperative Behaviour</em>}</li>
 *   <li>{@link intelligentMobility.Link_CooperativeBehaviour#getLink_cooperativeBehaviour <em>Link cooperative Behaviour</em>}</li>
 * </ul>
 *
 * @see intelligentMobility.IntelligentMobilityPackage#getLink_CooperativeBehaviour()
 * @model
 * @generated
 */
public interface Link_CooperativeBehaviour extends EObject {
	/**
	 * Returns the value of the '<em><b>Name link cooperative Behaviour</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name link cooperative Behaviour</em>' attribute.
	 * @see #setName_link_cooperativeBehaviour(String)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_CooperativeBehaviour_Name_link_cooperativeBehaviour()
	 * @model
	 * @generated
	 */
	String getName_link_cooperativeBehaviour();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_CooperativeBehaviour#getName_link_cooperativeBehaviour <em>Name link cooperative Behaviour</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name link cooperative Behaviour</em>' attribute.
	 * @see #getName_link_cooperativeBehaviour()
	 * @generated
	 */
	void setName_link_cooperativeBehaviour(String value);

	/**
	 * Returns the value of the '<em><b>Link cooperative Behaviour</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link cooperative Behaviour</em>' reference.
	 * @see #setLink_cooperativeBehaviour(Link_CooperativeBehaviour)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_CooperativeBehaviour_Link_cooperativeBehaviour()
	 * @model
	 * @generated
	 */
	Link_CooperativeBehaviour getLink_cooperativeBehaviour();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_CooperativeBehaviour#getLink_cooperativeBehaviour <em>Link cooperative Behaviour</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link cooperative Behaviour</em>' reference.
	 * @see #getLink_cooperativeBehaviour()
	 * @generated
	 */
	void setLink_cooperativeBehaviour(Link_CooperativeBehaviour value);

} // Link_CooperativeBehaviour
