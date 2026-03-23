/**
 */
package intelligentMobility;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link Action Turn</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.Link_Action_Turn#getName_link_action_turn <em>Name link action turn</em>}</li>
 *   <li>{@link intelligentMobility.Link_Action_Turn#getLink_action <em>Link action</em>}</li>
 *   <li>{@link intelligentMobility.Link_Action_Turn#getLink_turn <em>Link turn</em>}</li>
 * </ul>
 *
 * @see intelligentMobility.IntelligentMobilityPackage#getLink_Action_Turn()
 * @model
 * @generated
 */
public interface Link_Action_Turn extends EObject {
	/**
	 * Returns the value of the '<em><b>Name link action turn</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name link action turn</em>' attribute.
	 * @see #setName_link_action_turn(String)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_Action_Turn_Name_link_action_turn()
	 * @model
	 * @generated
	 */
	String getName_link_action_turn();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_Action_Turn#getName_link_action_turn <em>Name link action turn</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name link action turn</em>' attribute.
	 * @see #getName_link_action_turn()
	 * @generated
	 */
	void setName_link_action_turn(String value);

	/**
	 * Returns the value of the '<em><b>Link action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link action</em>' reference.
	 * @see #setLink_action(Action)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_Action_Turn_Link_action()
	 * @model
	 * @generated
	 */
	Action getLink_action();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_Action_Turn#getLink_action <em>Link action</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link action</em>' reference.
	 * @see #getLink_action()
	 * @generated
	 */
	void setLink_action(Action value);

	/**
	 * Returns the value of the '<em><b>Link turn</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link turn</em>' reference.
	 * @see #setLink_turn(Turn)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_Action_Turn_Link_turn()
	 * @model
	 * @generated
	 */
	Turn getLink_turn();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_Action_Turn#getLink_turn <em>Link turn</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link turn</em>' reference.
	 * @see #getLink_turn()
	 * @generated
	 */
	void setLink_turn(Turn value);

} // Link_Action_Turn
