/**
 */
package intelligentMobility;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link Lane Changing Turn</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.Link_LaneChanging_Turn#getName_link_laneChanging_turn <em>Name link lane Changing turn</em>}</li>
 *   <li>{@link intelligentMobility.Link_LaneChanging_Turn#getLink_laneChanging <em>Link lane Changing</em>}</li>
 *   <li>{@link intelligentMobility.Link_LaneChanging_Turn#getLink_turn <em>Link turn</em>}</li>
 * </ul>
 *
 * @see intelligentMobility.IntelligentMobilityPackage#getLink_LaneChanging_Turn()
 * @model
 * @generated
 */
public interface Link_LaneChanging_Turn extends EObject {
	/**
	 * Returns the value of the '<em><b>Name link lane Changing turn</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name link lane Changing turn</em>' attribute.
	 * @see #setName_link_laneChanging_turn(String)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_LaneChanging_Turn_Name_link_laneChanging_turn()
	 * @model
	 * @generated
	 */
	String getName_link_laneChanging_turn();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_LaneChanging_Turn#getName_link_laneChanging_turn <em>Name link lane Changing turn</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name link lane Changing turn</em>' attribute.
	 * @see #getName_link_laneChanging_turn()
	 * @generated
	 */
	void setName_link_laneChanging_turn(String value);

	/**
	 * Returns the value of the '<em><b>Link lane Changing</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link lane Changing</em>' reference.
	 * @see #setLink_laneChanging(LaneChanging)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_LaneChanging_Turn_Link_laneChanging()
	 * @model
	 * @generated
	 */
	LaneChanging getLink_laneChanging();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_LaneChanging_Turn#getLink_laneChanging <em>Link lane Changing</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link lane Changing</em>' reference.
	 * @see #getLink_laneChanging()
	 * @generated
	 */
	void setLink_laneChanging(LaneChanging value);

	/**
	 * Returns the value of the '<em><b>Link turn</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link turn</em>' reference.
	 * @see #setLink_turn(Turn)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_LaneChanging_Turn_Link_turn()
	 * @model
	 * @generated
	 */
	Turn getLink_turn();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_LaneChanging_Turn#getLink_turn <em>Link turn</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link turn</em>' reference.
	 * @see #getLink_turn()
	 * @generated
	 */
	void setLink_turn(Turn value);

} // Link_LaneChanging_Turn
