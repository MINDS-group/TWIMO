/**
 */
package intelligentMobility;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link Following Lane Changing</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.Link_Following_LaneChanging#getName_link_following_laneChanging <em>Name link following lane Changing</em>}</li>
 *   <li>{@link intelligentMobility.Link_Following_LaneChanging#getLink_following <em>Link following</em>}</li>
 *   <li>{@link intelligentMobility.Link_Following_LaneChanging#getLink_laneChanging <em>Link lane Changing</em>}</li>
 * </ul>
 *
 * @see intelligentMobility.IntelligentMobilityPackage#getLink_Following_LaneChanging()
 * @model
 * @generated
 */
public interface Link_Following_LaneChanging extends EObject {
	/**
	 * Returns the value of the '<em><b>Name link following lane Changing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name link following lane Changing</em>' attribute.
	 * @see #setName_link_following_laneChanging(String)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_Following_LaneChanging_Name_link_following_laneChanging()
	 * @model
	 * @generated
	 */
	String getName_link_following_laneChanging();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_Following_LaneChanging#getName_link_following_laneChanging <em>Name link following lane Changing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name link following lane Changing</em>' attribute.
	 * @see #getName_link_following_laneChanging()
	 * @generated
	 */
	void setName_link_following_laneChanging(String value);

	/**
	 * Returns the value of the '<em><b>Link following</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link following</em>' reference.
	 * @see #setLink_following(Following)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_Following_LaneChanging_Link_following()
	 * @model
	 * @generated
	 */
	Following getLink_following();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_Following_LaneChanging#getLink_following <em>Link following</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link following</em>' reference.
	 * @see #getLink_following()
	 * @generated
	 */
	void setLink_following(Following value);

	/**
	 * Returns the value of the '<em><b>Link lane Changing</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link lane Changing</em>' reference.
	 * @see #setLink_laneChanging(LaneChanging)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_Following_LaneChanging_Link_laneChanging()
	 * @model
	 * @generated
	 */
	LaneChanging getLink_laneChanging();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_Following_LaneChanging#getLink_laneChanging <em>Link lane Changing</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link lane Changing</em>' reference.
	 * @see #getLink_laneChanging()
	 * @generated
	 */
	void setLink_laneChanging(LaneChanging value);

} // Link_Following_LaneChanging
