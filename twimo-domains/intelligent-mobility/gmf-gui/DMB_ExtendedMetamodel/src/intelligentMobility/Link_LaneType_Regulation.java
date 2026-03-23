/**
 */
package intelligentMobility;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link Lane Type Regulation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.Link_LaneType_Regulation#getName_link_laneType_regulation <em>Name link lane Type regulation</em>}</li>
 *   <li>{@link intelligentMobility.Link_LaneType_Regulation#getLink_laneType <em>Link lane Type</em>}</li>
 *   <li>{@link intelligentMobility.Link_LaneType_Regulation#getLink_regulation <em>Link regulation</em>}</li>
 * </ul>
 *
 * @see intelligentMobility.IntelligentMobilityPackage#getLink_LaneType_Regulation()
 * @model
 * @generated
 */
public interface Link_LaneType_Regulation extends EObject {
	/**
	 * Returns the value of the '<em><b>Name link lane Type regulation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name link lane Type regulation</em>' attribute.
	 * @see #setName_link_laneType_regulation(String)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_LaneType_Regulation_Name_link_laneType_regulation()
	 * @model
	 * @generated
	 */
	String getName_link_laneType_regulation();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_LaneType_Regulation#getName_link_laneType_regulation <em>Name link lane Type regulation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name link lane Type regulation</em>' attribute.
	 * @see #getName_link_laneType_regulation()
	 * @generated
	 */
	void setName_link_laneType_regulation(String value);

	/**
	 * Returns the value of the '<em><b>Link lane Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link lane Type</em>' reference.
	 * @see #setLink_laneType(Lane_Type)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_LaneType_Regulation_Link_laneType()
	 * @model
	 * @generated
	 */
	Lane_Type getLink_laneType();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_LaneType_Regulation#getLink_laneType <em>Link lane Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link lane Type</em>' reference.
	 * @see #getLink_laneType()
	 * @generated
	 */
	void setLink_laneType(Lane_Type value);

	/**
	 * Returns the value of the '<em><b>Link regulation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link regulation</em>' reference.
	 * @see #setLink_regulation(Regulation)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_LaneType_Regulation_Link_regulation()
	 * @model
	 * @generated
	 */
	Regulation getLink_regulation();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_LaneType_Regulation#getLink_regulation <em>Link regulation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link regulation</em>' reference.
	 * @see #getLink_regulation()
	 * @generated
	 */
	void setLink_regulation(Regulation value);

} // Link_LaneType_Regulation
