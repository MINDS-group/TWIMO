/**
 */
package intelligentMobility;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link Environment Background Environment Condition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.Link_EnvironmentBackground_EnvironmentCondition#getName_link_background_condition <em>Name link background condition</em>}</li>
 *   <li>{@link intelligentMobility.Link_EnvironmentBackground_EnvironmentCondition#getLink_environment_background <em>Link environment background</em>}</li>
 *   <li>{@link intelligentMobility.Link_EnvironmentBackground_EnvironmentCondition#getLink_environment_condition <em>Link environment condition</em>}</li>
 * </ul>
 *
 * @see intelligentMobility.IntelligentMobilityPackage#getLink_EnvironmentBackground_EnvironmentCondition()
 * @model
 * @generated
 */
public interface Link_EnvironmentBackground_EnvironmentCondition extends EObject {
	/**
	 * Returns the value of the '<em><b>Name link background condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name link background condition</em>' attribute.
	 * @see #setName_link_background_condition(String)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_EnvironmentBackground_EnvironmentCondition_Name_link_background_condition()
	 * @model
	 * @generated
	 */
	String getName_link_background_condition();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_EnvironmentBackground_EnvironmentCondition#getName_link_background_condition <em>Name link background condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name link background condition</em>' attribute.
	 * @see #getName_link_background_condition()
	 * @generated
	 */
	void setName_link_background_condition(String value);

	/**
	 * Returns the value of the '<em><b>Link environment background</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link environment background</em>' reference.
	 * @see #setLink_environment_background(Environment_Background)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_EnvironmentBackground_EnvironmentCondition_Link_environment_background()
	 * @model
	 * @generated
	 */
	Environment_Background getLink_environment_background();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_EnvironmentBackground_EnvironmentCondition#getLink_environment_background <em>Link environment background</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link environment background</em>' reference.
	 * @see #getLink_environment_background()
	 * @generated
	 */
	void setLink_environment_background(Environment_Background value);

	/**
	 * Returns the value of the '<em><b>Link environment condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link environment condition</em>' reference.
	 * @see #setLink_environment_condition(Environment_Condition)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_EnvironmentBackground_EnvironmentCondition_Link_environment_condition()
	 * @model
	 * @generated
	 */
	Environment_Condition getLink_environment_condition();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_EnvironmentBackground_EnvironmentCondition#getLink_environment_condition <em>Link environment condition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link environment condition</em>' reference.
	 * @see #getLink_environment_condition()
	 * @generated
	 */
	void setLink_environment_condition(Environment_Condition value);

} // Link_EnvironmentBackground_EnvironmentCondition
