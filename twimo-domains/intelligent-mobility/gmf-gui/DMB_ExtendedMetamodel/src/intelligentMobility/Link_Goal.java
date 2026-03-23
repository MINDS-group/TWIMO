/**
 */
package intelligentMobility;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link Goal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.Link_Goal#getName_link_goal <em>Name link goal</em>}</li>
 *   <li>{@link intelligentMobility.Link_Goal#getLink_goal <em>Link goal</em>}</li>
 * </ul>
 *
 * @see intelligentMobility.IntelligentMobilityPackage#getLink_Goal()
 * @model
 * @generated
 */
public interface Link_Goal extends EObject {
	/**
	 * Returns the value of the '<em><b>Name link goal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name link goal</em>' attribute.
	 * @see #setName_link_goal(String)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_Goal_Name_link_goal()
	 * @model
	 * @generated
	 */
	String getName_link_goal();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_Goal#getName_link_goal <em>Name link goal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name link goal</em>' attribute.
	 * @see #getName_link_goal()
	 * @generated
	 */
	void setName_link_goal(String value);

	/**
	 * Returns the value of the '<em><b>Link goal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link goal</em>' reference.
	 * @see #setLink_goal(Goal)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_Goal_Link_goal()
	 * @model
	 * @generated
	 */
	Goal getLink_goal();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_Goal#getLink_goal <em>Link goal</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link goal</em>' reference.
	 * @see #getLink_goal()
	 * @generated
	 */
	void setLink_goal(Goal value);

} // Link_Goal
