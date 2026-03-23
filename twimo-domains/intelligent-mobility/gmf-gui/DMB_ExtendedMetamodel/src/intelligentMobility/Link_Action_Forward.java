/**
 */
package intelligentMobility;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link Action Forward</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.Link_Action_Forward#getName_link_action_forward <em>Name link action forward</em>}</li>
 *   <li>{@link intelligentMobility.Link_Action_Forward#getLink_action <em>Link action</em>}</li>
 *   <li>{@link intelligentMobility.Link_Action_Forward#getLink_forward <em>Link forward</em>}</li>
 * </ul>
 *
 * @see intelligentMobility.IntelligentMobilityPackage#getLink_Action_Forward()
 * @model
 * @generated
 */
public interface Link_Action_Forward extends EObject {
	/**
	 * Returns the value of the '<em><b>Name link action forward</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name link action forward</em>' attribute.
	 * @see #setName_link_action_forward(String)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_Action_Forward_Name_link_action_forward()
	 * @model
	 * @generated
	 */
	String getName_link_action_forward();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_Action_Forward#getName_link_action_forward <em>Name link action forward</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name link action forward</em>' attribute.
	 * @see #getName_link_action_forward()
	 * @generated
	 */
	void setName_link_action_forward(String value);

	/**
	 * Returns the value of the '<em><b>Link action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link action</em>' reference.
	 * @see #setLink_action(Action)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_Action_Forward_Link_action()
	 * @model
	 * @generated
	 */
	Action getLink_action();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_Action_Forward#getLink_action <em>Link action</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link action</em>' reference.
	 * @see #getLink_action()
	 * @generated
	 */
	void setLink_action(Action value);

	/**
	 * Returns the value of the '<em><b>Link forward</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link forward</em>' reference.
	 * @see #setLink_forward(Forward)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_Action_Forward_Link_forward()
	 * @model
	 * @generated
	 */
	Forward getLink_forward();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_Action_Forward#getLink_forward <em>Link forward</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link forward</em>' reference.
	 * @see #getLink_forward()
	 * @generated
	 */
	void setLink_forward(Forward value);

} // Link_Action_Forward
