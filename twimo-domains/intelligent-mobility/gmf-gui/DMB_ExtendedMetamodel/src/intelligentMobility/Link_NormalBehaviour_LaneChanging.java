/**
 */
package intelligentMobility;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link Normal Behaviour Lane Changing</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.Link_NormalBehaviour_LaneChanging#getName_link_behaviour_laneChanging <em>Name link behaviour lane Changing</em>}</li>
 *   <li>{@link intelligentMobility.Link_NormalBehaviour_LaneChanging#getLink_normal_behaviour <em>Link normal behaviour</em>}</li>
 *   <li>{@link intelligentMobility.Link_NormalBehaviour_LaneChanging#getLink_lane_changing <em>Link lane changing</em>}</li>
 * </ul>
 *
 * @see intelligentMobility.IntelligentMobilityPackage#getLink_NormalBehaviour_LaneChanging()
 * @model
 * @generated
 */
public interface Link_NormalBehaviour_LaneChanging extends EObject {
	/**
	 * Returns the value of the '<em><b>Name link behaviour lane Changing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name link behaviour lane Changing</em>' attribute.
	 * @see #setName_link_behaviour_laneChanging(String)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_NormalBehaviour_LaneChanging_Name_link_behaviour_laneChanging()
	 * @model
	 * @generated
	 */
	String getName_link_behaviour_laneChanging();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_NormalBehaviour_LaneChanging#getName_link_behaviour_laneChanging <em>Name link behaviour lane Changing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name link behaviour lane Changing</em>' attribute.
	 * @see #getName_link_behaviour_laneChanging()
	 * @generated
	 */
	void setName_link_behaviour_laneChanging(String value);

	/**
	 * Returns the value of the '<em><b>Link normal behaviour</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link normal behaviour</em>' reference.
	 * @see #setLink_normal_behaviour(Normal_Behaviour)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_NormalBehaviour_LaneChanging_Link_normal_behaviour()
	 * @model
	 * @generated
	 */
	Normal_Behaviour getLink_normal_behaviour();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_NormalBehaviour_LaneChanging#getLink_normal_behaviour <em>Link normal behaviour</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link normal behaviour</em>' reference.
	 * @see #getLink_normal_behaviour()
	 * @generated
	 */
	void setLink_normal_behaviour(Normal_Behaviour value);

	/**
	 * Returns the value of the '<em><b>Link lane changing</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link lane changing</em>' reference.
	 * @see #setLink_lane_changing(LaneChanging)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_NormalBehaviour_LaneChanging_Link_lane_changing()
	 * @model
	 * @generated
	 */
	LaneChanging getLink_lane_changing();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_NormalBehaviour_LaneChanging#getLink_lane_changing <em>Link lane changing</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link lane changing</em>' reference.
	 * @see #getLink_lane_changing()
	 * @generated
	 */
	void setLink_lane_changing(LaneChanging value);

} // Link_NormalBehaviour_LaneChanging
