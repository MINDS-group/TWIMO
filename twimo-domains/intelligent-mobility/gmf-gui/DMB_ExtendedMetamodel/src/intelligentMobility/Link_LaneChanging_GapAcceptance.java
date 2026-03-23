/**
 */
package intelligentMobility;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link Lane Changing Gap Acceptance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.Link_LaneChanging_GapAcceptance#getName_link_laneChanging_gapAcceptane <em>Name link lane Changing gap Acceptane</em>}</li>
 *   <li>{@link intelligentMobility.Link_LaneChanging_GapAcceptance#getLink_laneChanging <em>Link lane Changing</em>}</li>
 *   <li>{@link intelligentMobility.Link_LaneChanging_GapAcceptance#getLink_gapAcceptance <em>Link gap Acceptance</em>}</li>
 * </ul>
 *
 * @see intelligentMobility.IntelligentMobilityPackage#getLink_LaneChanging_GapAcceptance()
 * @model
 * @generated
 */
public interface Link_LaneChanging_GapAcceptance extends EObject {
	/**
	 * Returns the value of the '<em><b>Name link lane Changing gap Acceptane</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name link lane Changing gap Acceptane</em>' attribute.
	 * @see #setName_link_laneChanging_gapAcceptane(String)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_LaneChanging_GapAcceptance_Name_link_laneChanging_gapAcceptane()
	 * @model
	 * @generated
	 */
	String getName_link_laneChanging_gapAcceptane();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_LaneChanging_GapAcceptance#getName_link_laneChanging_gapAcceptane <em>Name link lane Changing gap Acceptane</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name link lane Changing gap Acceptane</em>' attribute.
	 * @see #getName_link_laneChanging_gapAcceptane()
	 * @generated
	 */
	void setName_link_laneChanging_gapAcceptane(String value);

	/**
	 * Returns the value of the '<em><b>Link lane Changing</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link lane Changing</em>' reference.
	 * @see #setLink_laneChanging(LaneChanging)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_LaneChanging_GapAcceptance_Link_laneChanging()
	 * @model
	 * @generated
	 */
	LaneChanging getLink_laneChanging();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_LaneChanging_GapAcceptance#getLink_laneChanging <em>Link lane Changing</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link lane Changing</em>' reference.
	 * @see #getLink_laneChanging()
	 * @generated
	 */
	void setLink_laneChanging(LaneChanging value);

	/**
	 * Returns the value of the '<em><b>Link gap Acceptance</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link gap Acceptance</em>' reference.
	 * @see #setLink_gapAcceptance(GapAcceptance)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_LaneChanging_GapAcceptance_Link_gapAcceptance()
	 * @model
	 * @generated
	 */
	GapAcceptance getLink_gapAcceptance();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_LaneChanging_GapAcceptance#getLink_gapAcceptance <em>Link gap Acceptance</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link gap Acceptance</em>' reference.
	 * @see #getLink_gapAcceptance()
	 * @generated
	 */
	void setLink_gapAcceptance(GapAcceptance value);

} // Link_LaneChanging_GapAcceptance
