/**
 */
package intelligentMobility;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link Abnormal Behaviour Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.Link_AbnormalBehaviour_Action#getName_link_abnormalBehaviour_action <em>Name link abnormal Behaviour action</em>}</li>
 *   <li>{@link intelligentMobility.Link_AbnormalBehaviour_Action#getLink_abnormalBehaviour <em>Link abnormal Behaviour</em>}</li>
 *   <li>{@link intelligentMobility.Link_AbnormalBehaviour_Action#getLink_action <em>Link action</em>}</li>
 * </ul>
 *
 * @see intelligentMobility.IntelligentMobilityPackage#getLink_AbnormalBehaviour_Action()
 * @model
 * @generated
 */
public interface Link_AbnormalBehaviour_Action extends EObject {
	/**
	 * Returns the value of the '<em><b>Name link abnormal Behaviour action</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name link abnormal Behaviour action</em>' attribute.
	 * @see #setName_link_abnormalBehaviour_action(String)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_AbnormalBehaviour_Action_Name_link_abnormalBehaviour_action()
	 * @model
	 * @generated
	 */
	String getName_link_abnormalBehaviour_action();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_AbnormalBehaviour_Action#getName_link_abnormalBehaviour_action <em>Name link abnormal Behaviour action</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name link abnormal Behaviour action</em>' attribute.
	 * @see #getName_link_abnormalBehaviour_action()
	 * @generated
	 */
	void setName_link_abnormalBehaviour_action(String value);

	/**
	 * Returns the value of the '<em><b>Link abnormal Behaviour</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link abnormal Behaviour</em>' reference.
	 * @see #setLink_abnormalBehaviour(Abnormal_Behaviour)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_AbnormalBehaviour_Action_Link_abnormalBehaviour()
	 * @model
	 * @generated
	 */
	Abnormal_Behaviour getLink_abnormalBehaviour();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_AbnormalBehaviour_Action#getLink_abnormalBehaviour <em>Link abnormal Behaviour</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link abnormal Behaviour</em>' reference.
	 * @see #getLink_abnormalBehaviour()
	 * @generated
	 */
	void setLink_abnormalBehaviour(Abnormal_Behaviour value);

	/**
	 * Returns the value of the '<em><b>Link action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link action</em>' reference.
	 * @see #setLink_action(Action)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_AbnormalBehaviour_Action_Link_action()
	 * @model
	 * @generated
	 */
	Action getLink_action();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_AbnormalBehaviour_Action#getLink_action <em>Link action</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link action</em>' reference.
	 * @see #getLink_action()
	 * @generated
	 */
	void setLink_action(Action value);

} // Link_AbnormalBehaviour_Action
