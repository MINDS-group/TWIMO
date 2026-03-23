/**
 */
package intelligentMobility;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link Normal Vehicle Safety Requirements</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.Link_NormalVehicle_SafetyRequirements#getName_link_normalVehicle_safetyRequirement <em>Name link normal Vehicle safety Requirement</em>}</li>
 *   <li>{@link intelligentMobility.Link_NormalVehicle_SafetyRequirements#getLink_normalVehicle <em>Link normal Vehicle</em>}</li>
 *   <li>{@link intelligentMobility.Link_NormalVehicle_SafetyRequirements#getLink_safetyRequirement <em>Link safety Requirement</em>}</li>
 * </ul>
 *
 * @see intelligentMobility.IntelligentMobilityPackage#getLink_NormalVehicle_SafetyRequirements()
 * @model
 * @generated
 */
public interface Link_NormalVehicle_SafetyRequirements extends EObject {
	/**
	 * Returns the value of the '<em><b>Name link normal Vehicle safety Requirement</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name link normal Vehicle safety Requirement</em>' attribute.
	 * @see #setName_link_normalVehicle_safetyRequirement(String)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_NormalVehicle_SafetyRequirements_Name_link_normalVehicle_safetyRequirement()
	 * @model
	 * @generated
	 */
	String getName_link_normalVehicle_safetyRequirement();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_NormalVehicle_SafetyRequirements#getName_link_normalVehicle_safetyRequirement <em>Name link normal Vehicle safety Requirement</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name link normal Vehicle safety Requirement</em>' attribute.
	 * @see #getName_link_normalVehicle_safetyRequirement()
	 * @generated
	 */
	void setName_link_normalVehicle_safetyRequirement(String value);

	/**
	 * Returns the value of the '<em><b>Link normal Vehicle</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link normal Vehicle</em>' reference.
	 * @see #setLink_normalVehicle(Normal_Vehicle)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_NormalVehicle_SafetyRequirements_Link_normalVehicle()
	 * @model
	 * @generated
	 */
	Normal_Vehicle getLink_normalVehicle();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_NormalVehicle_SafetyRequirements#getLink_normalVehicle <em>Link normal Vehicle</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link normal Vehicle</em>' reference.
	 * @see #getLink_normalVehicle()
	 * @generated
	 */
	void setLink_normalVehicle(Normal_Vehicle value);

	/**
	 * Returns the value of the '<em><b>Link safety Requirement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link safety Requirement</em>' reference.
	 * @see #setLink_safetyRequirement(Safety_Requirement)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_NormalVehicle_SafetyRequirements_Link_safetyRequirement()
	 * @model
	 * @generated
	 */
	Safety_Requirement getLink_safetyRequirement();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_NormalVehicle_SafetyRequirements#getLink_safetyRequirement <em>Link safety Requirement</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link safety Requirement</em>' reference.
	 * @see #getLink_safetyRequirement()
	 * @generated
	 */
	void setLink_safetyRequirement(Safety_Requirement value);

} // Link_NormalVehicle_SafetyRequirements
