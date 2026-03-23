/**
 */
package intelligentMobility;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link Collision Obstruction</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.Link_Collision_Obstruction#getName_link_collision_obstruction <em>Name link collision obstruction</em>}</li>
 *   <li>{@link intelligentMobility.Link_Collision_Obstruction#getLink_collision <em>Link collision</em>}</li>
 *   <li>{@link intelligentMobility.Link_Collision_Obstruction#getLink_obstruction <em>Link obstruction</em>}</li>
 * </ul>
 *
 * @see intelligentMobility.IntelligentMobilityPackage#getLink_Collision_Obstruction()
 * @model
 * @generated
 */
public interface Link_Collision_Obstruction extends EObject {
	/**
	 * Returns the value of the '<em><b>Name link collision obstruction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name link collision obstruction</em>' attribute.
	 * @see #setName_link_collision_obstruction(String)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_Collision_Obstruction_Name_link_collision_obstruction()
	 * @model
	 * @generated
	 */
	String getName_link_collision_obstruction();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_Collision_Obstruction#getName_link_collision_obstruction <em>Name link collision obstruction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name link collision obstruction</em>' attribute.
	 * @see #getName_link_collision_obstruction()
	 * @generated
	 */
	void setName_link_collision_obstruction(String value);

	/**
	 * Returns the value of the '<em><b>Link collision</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link collision</em>' reference.
	 * @see #setLink_collision(Collision)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_Collision_Obstruction_Link_collision()
	 * @model
	 * @generated
	 */
	Collision getLink_collision();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_Collision_Obstruction#getLink_collision <em>Link collision</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link collision</em>' reference.
	 * @see #getLink_collision()
	 * @generated
	 */
	void setLink_collision(Collision value);

	/**
	 * Returns the value of the '<em><b>Link obstruction</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link obstruction</em>' reference.
	 * @see #setLink_obstruction(Obstruction)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_Collision_Obstruction_Link_obstruction()
	 * @model
	 * @generated
	 */
	Obstruction getLink_obstruction();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_Collision_Obstruction#getLink_obstruction <em>Link obstruction</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link obstruction</em>' reference.
	 * @see #getLink_obstruction()
	 * @generated
	 */
	void setLink_obstruction(Obstruction value);

} // Link_Collision_Obstruction
