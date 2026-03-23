/**
 */
package intelligentMobility;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link Environment Condition Regulations</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.Link_EnvironmentCondition_Regulations#getName_link_environmentCondition_regulation <em>Name link environment Condition regulation</em>}</li>
 *   <li>{@link intelligentMobility.Link_EnvironmentCondition_Regulations#getLink_environmentCondition <em>Link environment Condition</em>}</li>
 *   <li>{@link intelligentMobility.Link_EnvironmentCondition_Regulations#getLink_regulation <em>Link regulation</em>}</li>
 * </ul>
 *
 * @see intelligentMobility.IntelligentMobilityPackage#getLink_EnvironmentCondition_Regulations()
 * @model
 * @generated
 */
public interface Link_EnvironmentCondition_Regulations extends EObject {
	/**
	 * Returns the value of the '<em><b>Name link environment Condition regulation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name link environment Condition regulation</em>' attribute.
	 * @see #setName_link_environmentCondition_regulation(String)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_EnvironmentCondition_Regulations_Name_link_environmentCondition_regulation()
	 * @model
	 * @generated
	 */
	String getName_link_environmentCondition_regulation();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_EnvironmentCondition_Regulations#getName_link_environmentCondition_regulation <em>Name link environment Condition regulation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name link environment Condition regulation</em>' attribute.
	 * @see #getName_link_environmentCondition_regulation()
	 * @generated
	 */
	void setName_link_environmentCondition_regulation(String value);

	/**
	 * Returns the value of the '<em><b>Link environment Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link environment Condition</em>' reference.
	 * @see #setLink_environmentCondition(Environment_Condition)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_EnvironmentCondition_Regulations_Link_environmentCondition()
	 * @model
	 * @generated
	 */
	Environment_Condition getLink_environmentCondition();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_EnvironmentCondition_Regulations#getLink_environmentCondition <em>Link environment Condition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link environment Condition</em>' reference.
	 * @see #getLink_environmentCondition()
	 * @generated
	 */
	void setLink_environmentCondition(Environment_Condition value);

	/**
	 * Returns the value of the '<em><b>Link regulation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link regulation</em>' reference.
	 * @see #setLink_regulation(Regulation)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_EnvironmentCondition_Regulations_Link_regulation()
	 * @model
	 * @generated
	 */
	Regulation getLink_regulation();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_EnvironmentCondition_Regulations#getLink_regulation <em>Link regulation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link regulation</em>' reference.
	 * @see #getLink_regulation()
	 * @generated
	 */
	void setLink_regulation(Regulation value);

} // Link_EnvironmentCondition_Regulations
