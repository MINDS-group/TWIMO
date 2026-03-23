/**
 */
package intelligentMobility;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link Normal Behaviour Following</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.Link_NormalBehaviour_Following#getName_link_behaviour_following <em>Name link behaviour following</em>}</li>
 *   <li>{@link intelligentMobility.Link_NormalBehaviour_Following#getLink_normal_behaviour <em>Link normal behaviour</em>}</li>
 *   <li>{@link intelligentMobility.Link_NormalBehaviour_Following#getLink_following <em>Link following</em>}</li>
 * </ul>
 *
 * @see intelligentMobility.IntelligentMobilityPackage#getLink_NormalBehaviour_Following()
 * @model
 * @generated
 */
public interface Link_NormalBehaviour_Following extends EObject {
	/**
	 * Returns the value of the '<em><b>Name link behaviour following</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name link behaviour following</em>' attribute.
	 * @see #setName_link_behaviour_following(String)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_NormalBehaviour_Following_Name_link_behaviour_following()
	 * @model
	 * @generated
	 */
	String getName_link_behaviour_following();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_NormalBehaviour_Following#getName_link_behaviour_following <em>Name link behaviour following</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name link behaviour following</em>' attribute.
	 * @see #getName_link_behaviour_following()
	 * @generated
	 */
	void setName_link_behaviour_following(String value);

	/**
	 * Returns the value of the '<em><b>Link normal behaviour</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link normal behaviour</em>' reference.
	 * @see #setLink_normal_behaviour(Normal_Behaviour)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_NormalBehaviour_Following_Link_normal_behaviour()
	 * @model
	 * @generated
	 */
	Normal_Behaviour getLink_normal_behaviour();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_NormalBehaviour_Following#getLink_normal_behaviour <em>Link normal behaviour</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link normal behaviour</em>' reference.
	 * @see #getLink_normal_behaviour()
	 * @generated
	 */
	void setLink_normal_behaviour(Normal_Behaviour value);

	/**
	 * Returns the value of the '<em><b>Link following</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link following</em>' reference.
	 * @see #setLink_following(Following)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_NormalBehaviour_Following_Link_following()
	 * @model
	 * @generated
	 */
	Following getLink_following();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_NormalBehaviour_Following#getLink_following <em>Link following</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link following</em>' reference.
	 * @see #getLink_following()
	 * @generated
	 */
	void setLink_following(Following value);

} // Link_NormalBehaviour_Following
