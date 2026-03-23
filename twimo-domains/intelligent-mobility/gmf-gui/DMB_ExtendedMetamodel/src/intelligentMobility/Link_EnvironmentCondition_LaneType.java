/**
 */
package intelligentMobility;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link Environment Condition Lane Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.Link_EnvironmentCondition_LaneType#getName_link_environmentCondition_laneType <em>Name link environment Condition lane Type</em>}</li>
 *   <li>{@link intelligentMobility.Link_EnvironmentCondition_LaneType#getLink_environmentCondition <em>Link environment Condition</em>}</li>
 *   <li>{@link intelligentMobility.Link_EnvironmentCondition_LaneType#getLink_laneType <em>Link lane Type</em>}</li>
 * </ul>
 *
 * @see intelligentMobility.IntelligentMobilityPackage#getLink_EnvironmentCondition_LaneType()
 * @model
 * @generated
 */
public interface Link_EnvironmentCondition_LaneType extends EObject {
	/**
	 * Returns the value of the '<em><b>Name link environment Condition lane Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name link environment Condition lane Type</em>' attribute.
	 * @see #setName_link_environmentCondition_laneType(String)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_EnvironmentCondition_LaneType_Name_link_environmentCondition_laneType()
	 * @model
	 * @generated
	 */
	String getName_link_environmentCondition_laneType();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_EnvironmentCondition_LaneType#getName_link_environmentCondition_laneType <em>Name link environment Condition lane Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name link environment Condition lane Type</em>' attribute.
	 * @see #getName_link_environmentCondition_laneType()
	 * @generated
	 */
	void setName_link_environmentCondition_laneType(String value);

	/**
	 * Returns the value of the '<em><b>Link environment Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link environment Condition</em>' reference.
	 * @see #setLink_environmentCondition(Environment_Condition)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_EnvironmentCondition_LaneType_Link_environmentCondition()
	 * @model
	 * @generated
	 */
	Environment_Condition getLink_environmentCondition();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_EnvironmentCondition_LaneType#getLink_environmentCondition <em>Link environment Condition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link environment Condition</em>' reference.
	 * @see #getLink_environmentCondition()
	 * @generated
	 */
	void setLink_environmentCondition(Environment_Condition value);

	/**
	 * Returns the value of the '<em><b>Link lane Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link lane Type</em>' reference.
	 * @see #setLink_laneType(Lane_Type)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_EnvironmentCondition_LaneType_Link_laneType()
	 * @model
	 * @generated
	 */
	Lane_Type getLink_laneType();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_EnvironmentCondition_LaneType#getLink_laneType <em>Link lane Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link lane Type</em>' reference.
	 * @see #getLink_laneType()
	 * @generated
	 */
	void setLink_laneType(Lane_Type value);

} // Link_EnvironmentCondition_LaneType
