/**
 */
package intelligentMobility;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link Collision Special Condition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.Link_Collision_SpecialCondition#getName_link_collision_specialCondition <em>Name link collision special Condition</em>}</li>
 *   <li>{@link intelligentMobility.Link_Collision_SpecialCondition#getLink_collision <em>Link collision</em>}</li>
 *   <li>{@link intelligentMobility.Link_Collision_SpecialCondition#getLink_specialCondition <em>Link special Condition</em>}</li>
 * </ul>
 *
 * @see intelligentMobility.IntelligentMobilityPackage#getLink_Collision_SpecialCondition()
 * @model
 * @generated
 */
public interface Link_Collision_SpecialCondition extends EObject {
	/**
	 * Returns the value of the '<em><b>Name link collision special Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name link collision special Condition</em>' attribute.
	 * @see #setName_link_collision_specialCondition(String)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_Collision_SpecialCondition_Name_link_collision_specialCondition()
	 * @model
	 * @generated
	 */
	String getName_link_collision_specialCondition();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_Collision_SpecialCondition#getName_link_collision_specialCondition <em>Name link collision special Condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name link collision special Condition</em>' attribute.
	 * @see #getName_link_collision_specialCondition()
	 * @generated
	 */
	void setName_link_collision_specialCondition(String value);

	/**
	 * Returns the value of the '<em><b>Link collision</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link collision</em>' reference.
	 * @see #setLink_collision(Collision)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_Collision_SpecialCondition_Link_collision()
	 * @model
	 * @generated
	 */
	Collision getLink_collision();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_Collision_SpecialCondition#getLink_collision <em>Link collision</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link collision</em>' reference.
	 * @see #getLink_collision()
	 * @generated
	 */
	void setLink_collision(Collision value);

	/**
	 * Returns the value of the '<em><b>Link special Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link special Condition</em>' reference.
	 * @see #setLink_specialCondition(Special_Condition)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_Collision_SpecialCondition_Link_specialCondition()
	 * @model
	 * @generated
	 */
	Special_Condition getLink_specialCondition();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_Collision_SpecialCondition#getLink_specialCondition <em>Link special Condition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link special Condition</em>' reference.
	 * @see #getLink_specialCondition()
	 * @generated
	 */
	void setLink_specialCondition(Special_Condition value);

} // Link_Collision_SpecialCondition
