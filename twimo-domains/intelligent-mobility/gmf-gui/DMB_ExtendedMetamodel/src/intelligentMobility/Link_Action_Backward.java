/**
 */
package intelligentMobility;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link Action Backward</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.Link_Action_Backward#getName_link_action_backward <em>Name link action backward</em>}</li>
 *   <li>{@link intelligentMobility.Link_Action_Backward#getLink_action <em>Link action</em>}</li>
 *   <li>{@link intelligentMobility.Link_Action_Backward#getLink_backward <em>Link backward</em>}</li>
 * </ul>
 *
 * @see intelligentMobility.IntelligentMobilityPackage#getLink_Action_Backward()
 * @model
 * @generated
 */
public interface Link_Action_Backward extends EObject {
	/**
	 * Returns the value of the '<em><b>Name link action backward</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name link action backward</em>' attribute.
	 * @see #setName_link_action_backward(String)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_Action_Backward_Name_link_action_backward()
	 * @model
	 * @generated
	 */
	String getName_link_action_backward();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_Action_Backward#getName_link_action_backward <em>Name link action backward</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name link action backward</em>' attribute.
	 * @see #getName_link_action_backward()
	 * @generated
	 */
	void setName_link_action_backward(String value);

	/**
	 * Returns the value of the '<em><b>Link action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link action</em>' reference.
	 * @see #setLink_action(Action)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_Action_Backward_Link_action()
	 * @model
	 * @generated
	 */
	Action getLink_action();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_Action_Backward#getLink_action <em>Link action</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link action</em>' reference.
	 * @see #getLink_action()
	 * @generated
	 */
	void setLink_action(Action value);

	/**
	 * Returns the value of the '<em><b>Link backward</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link backward</em>' reference.
	 * @see #setLink_backward(Backward)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_Action_Backward_Link_backward()
	 * @model
	 * @generated
	 */
	Backward getLink_backward();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_Action_Backward#getLink_backward <em>Link backward</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link backward</em>' reference.
	 * @see #getLink_backward()
	 * @generated
	 */
	void setLink_backward(Backward value);

} // Link_Action_Backward
