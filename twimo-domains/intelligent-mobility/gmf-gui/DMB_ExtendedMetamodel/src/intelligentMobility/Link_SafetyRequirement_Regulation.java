/**
 */
package intelligentMobility;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link Safety Requirement Regulation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.Link_SafetyRequirement_Regulation#getName_link_safetyRequirement_regulation <em>Name link safety Requirement regulation</em>}</li>
 *   <li>{@link intelligentMobility.Link_SafetyRequirement_Regulation#getLink_safetyRequirement <em>Link safety Requirement</em>}</li>
 *   <li>{@link intelligentMobility.Link_SafetyRequirement_Regulation#getLink_regulation <em>Link regulation</em>}</li>
 * </ul>
 *
 * @see intelligentMobility.IntelligentMobilityPackage#getLink_SafetyRequirement_Regulation()
 * @model
 * @generated
 */
public interface Link_SafetyRequirement_Regulation extends EObject {
	/**
	 * Returns the value of the '<em><b>Name link safety Requirement regulation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name link safety Requirement regulation</em>' attribute.
	 * @see #setName_link_safetyRequirement_regulation(String)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_SafetyRequirement_Regulation_Name_link_safetyRequirement_regulation()
	 * @model
	 * @generated
	 */
	String getName_link_safetyRequirement_regulation();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_SafetyRequirement_Regulation#getName_link_safetyRequirement_regulation <em>Name link safety Requirement regulation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name link safety Requirement regulation</em>' attribute.
	 * @see #getName_link_safetyRequirement_regulation()
	 * @generated
	 */
	void setName_link_safetyRequirement_regulation(String value);

	/**
	 * Returns the value of the '<em><b>Link safety Requirement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link safety Requirement</em>' reference.
	 * @see #setLink_safetyRequirement(Safety_Requirement)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_SafetyRequirement_Regulation_Link_safetyRequirement()
	 * @model
	 * @generated
	 */
	Safety_Requirement getLink_safetyRequirement();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_SafetyRequirement_Regulation#getLink_safetyRequirement <em>Link safety Requirement</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link safety Requirement</em>' reference.
	 * @see #getLink_safetyRequirement()
	 * @generated
	 */
	void setLink_safetyRequirement(Safety_Requirement value);

	/**
	 * Returns the value of the '<em><b>Link regulation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link regulation</em>' reference.
	 * @see #setLink_regulation(Regulation)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_SafetyRequirement_Regulation_Link_regulation()
	 * @model
	 * @generated
	 */
	Regulation getLink_regulation();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_SafetyRequirement_Regulation#getLink_regulation <em>Link regulation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link regulation</em>' reference.
	 * @see #getLink_regulation()
	 * @generated
	 */
	void setLink_regulation(Regulation value);

} // Link_SafetyRequirement_Regulation
