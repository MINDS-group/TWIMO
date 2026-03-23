/**
 */
package intelligentMobility;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link Environment Condition Special Condition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.Link_EnvironmentCondition_SpecialCondition#getName_link_environmentCondition_specialCondition <em>Name link environment Condition special Condition</em>}</li>
 *   <li>{@link intelligentMobility.Link_EnvironmentCondition_SpecialCondition#getLink_environmentCondition <em>Link environment Condition</em>}</li>
 *   <li>{@link intelligentMobility.Link_EnvironmentCondition_SpecialCondition#getLink_specialCondition <em>Link special Condition</em>}</li>
 * </ul>
 *
 * @see intelligentMobility.IntelligentMobilityPackage#getLink_EnvironmentCondition_SpecialCondition()
 * @model
 * @generated
 */
public interface Link_EnvironmentCondition_SpecialCondition extends EObject {
	/**
	 * Returns the value of the '<em><b>Name link environment Condition special Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name link environment Condition special Condition</em>' attribute.
	 * @see #setName_link_environmentCondition_specialCondition(String)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_EnvironmentCondition_SpecialCondition_Name_link_environmentCondition_specialCondition()
	 * @model
	 * @generated
	 */
	String getName_link_environmentCondition_specialCondition();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_EnvironmentCondition_SpecialCondition#getName_link_environmentCondition_specialCondition <em>Name link environment Condition special Condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name link environment Condition special Condition</em>' attribute.
	 * @see #getName_link_environmentCondition_specialCondition()
	 * @generated
	 */
	void setName_link_environmentCondition_specialCondition(String value);

	/**
	 * Returns the value of the '<em><b>Link environment Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link environment Condition</em>' reference.
	 * @see #setLink_environmentCondition(Environment_Condition)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_EnvironmentCondition_SpecialCondition_Link_environmentCondition()
	 * @model
	 * @generated
	 */
	Environment_Condition getLink_environmentCondition();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_EnvironmentCondition_SpecialCondition#getLink_environmentCondition <em>Link environment Condition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link environment Condition</em>' reference.
	 * @see #getLink_environmentCondition()
	 * @generated
	 */
	void setLink_environmentCondition(Environment_Condition value);

	/**
	 * Returns the value of the '<em><b>Link special Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link special Condition</em>' reference.
	 * @see #setLink_specialCondition(Special_Condition)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_EnvironmentCondition_SpecialCondition_Link_specialCondition()
	 * @model
	 * @generated
	 */
	Special_Condition getLink_specialCondition();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_EnvironmentCondition_SpecialCondition#getLink_specialCondition <em>Link special Condition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link special Condition</em>' reference.
	 * @see #getLink_specialCondition()
	 * @generated
	 */
	void setLink_specialCondition(Special_Condition value);

} // Link_EnvironmentCondition_SpecialCondition
