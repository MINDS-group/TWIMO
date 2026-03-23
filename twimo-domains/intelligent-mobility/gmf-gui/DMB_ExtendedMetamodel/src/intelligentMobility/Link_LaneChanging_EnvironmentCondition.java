/**
 */
package intelligentMobility;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link Lane Changing Environment Condition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.Link_LaneChanging_EnvironmentCondition#getName_link_laneChanging_environmentCondition <em>Name link lane Changing environment Condition</em>}</li>
 *   <li>{@link intelligentMobility.Link_LaneChanging_EnvironmentCondition#getLink_laneChanging <em>Link lane Changing</em>}</li>
 *   <li>{@link intelligentMobility.Link_LaneChanging_EnvironmentCondition#getLink_environmentCondition <em>Link environment Condition</em>}</li>
 * </ul>
 *
 * @see intelligentMobility.IntelligentMobilityPackage#getLink_LaneChanging_EnvironmentCondition()
 * @model
 * @generated
 */
public interface Link_LaneChanging_EnvironmentCondition extends EObject {
	/**
	 * Returns the value of the '<em><b>Name link lane Changing environment Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name link lane Changing environment Condition</em>' attribute.
	 * @see #setName_link_laneChanging_environmentCondition(String)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_LaneChanging_EnvironmentCondition_Name_link_laneChanging_environmentCondition()
	 * @model
	 * @generated
	 */
	String getName_link_laneChanging_environmentCondition();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_LaneChanging_EnvironmentCondition#getName_link_laneChanging_environmentCondition <em>Name link lane Changing environment Condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name link lane Changing environment Condition</em>' attribute.
	 * @see #getName_link_laneChanging_environmentCondition()
	 * @generated
	 */
	void setName_link_laneChanging_environmentCondition(String value);

	/**
	 * Returns the value of the '<em><b>Link lane Changing</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link lane Changing</em>' reference.
	 * @see #setLink_laneChanging(LaneChanging)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_LaneChanging_EnvironmentCondition_Link_laneChanging()
	 * @model
	 * @generated
	 */
	LaneChanging getLink_laneChanging();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_LaneChanging_EnvironmentCondition#getLink_laneChanging <em>Link lane Changing</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link lane Changing</em>' reference.
	 * @see #getLink_laneChanging()
	 * @generated
	 */
	void setLink_laneChanging(LaneChanging value);

	/**
	 * Returns the value of the '<em><b>Link environment Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link environment Condition</em>' reference.
	 * @see #setLink_environmentCondition(Environment_Condition)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_LaneChanging_EnvironmentCondition_Link_environmentCondition()
	 * @model
	 * @generated
	 */
	Environment_Condition getLink_environmentCondition();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_LaneChanging_EnvironmentCondition#getLink_environmentCondition <em>Link environment Condition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link environment Condition</em>' reference.
	 * @see #getLink_environmentCondition()
	 * @generated
	 */
	void setLink_environmentCondition(Environment_Condition value);

} // Link_LaneChanging_EnvironmentCondition
