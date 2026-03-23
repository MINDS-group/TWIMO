/**
 */
package intelligentMobility;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link Goal Driving Behaviour</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.Link_Goal_DrivingBehaviour#getName_link_goal_drivingBehaviour <em>Name link goal driving Behaviour</em>}</li>
 *   <li>{@link intelligentMobility.Link_Goal_DrivingBehaviour#getLink_goal <em>Link goal</em>}</li>
 *   <li>{@link intelligentMobility.Link_Goal_DrivingBehaviour#getLink_drivingBehaviour <em>Link driving Behaviour</em>}</li>
 * </ul>
 *
 * @see intelligentMobility.IntelligentMobilityPackage#getLink_Goal_DrivingBehaviour()
 * @model
 * @generated
 */
public interface Link_Goal_DrivingBehaviour extends EObject {
	/**
	 * Returns the value of the '<em><b>Name link goal driving Behaviour</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name link goal driving Behaviour</em>' attribute.
	 * @see #setName_link_goal_drivingBehaviour(String)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_Goal_DrivingBehaviour_Name_link_goal_drivingBehaviour()
	 * @model
	 * @generated
	 */
	String getName_link_goal_drivingBehaviour();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_Goal_DrivingBehaviour#getName_link_goal_drivingBehaviour <em>Name link goal driving Behaviour</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name link goal driving Behaviour</em>' attribute.
	 * @see #getName_link_goal_drivingBehaviour()
	 * @generated
	 */
	void setName_link_goal_drivingBehaviour(String value);

	/**
	 * Returns the value of the '<em><b>Link goal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link goal</em>' reference.
	 * @see #setLink_goal(Goal)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_Goal_DrivingBehaviour_Link_goal()
	 * @model
	 * @generated
	 */
	Goal getLink_goal();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_Goal_DrivingBehaviour#getLink_goal <em>Link goal</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link goal</em>' reference.
	 * @see #getLink_goal()
	 * @generated
	 */
	void setLink_goal(Goal value);

	/**
	 * Returns the value of the '<em><b>Link driving Behaviour</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link driving Behaviour</em>' reference.
	 * @see #setLink_drivingBehaviour(Driving_Behaviour)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_Goal_DrivingBehaviour_Link_drivingBehaviour()
	 * @model
	 * @generated
	 */
	Driving_Behaviour getLink_drivingBehaviour();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_Goal_DrivingBehaviour#getLink_drivingBehaviour <em>Link driving Behaviour</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link driving Behaviour</em>' reference.
	 * @see #getLink_drivingBehaviour()
	 * @generated
	 */
	void setLink_drivingBehaviour(Driving_Behaviour value);

} // Link_Goal_DrivingBehaviour
