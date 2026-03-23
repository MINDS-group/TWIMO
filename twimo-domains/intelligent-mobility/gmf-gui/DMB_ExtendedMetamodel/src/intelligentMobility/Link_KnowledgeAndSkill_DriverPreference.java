/**
 */
package intelligentMobility;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link Knowledge And Skill Driver Preference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.Link_KnowledgeAndSkill_DriverPreference#getName_link_knowledgeAndSkill_driverPreference <em>Name link knowledge And Skill driver Preference</em>}</li>
 *   <li>{@link intelligentMobility.Link_KnowledgeAndSkill_DriverPreference#getLink_knowledgeAndSkill <em>Link knowledge And Skill</em>}</li>
 *   <li>{@link intelligentMobility.Link_KnowledgeAndSkill_DriverPreference#getLink_driverPreference <em>Link driver Preference</em>}</li>
 * </ul>
 *
 * @see intelligentMobility.IntelligentMobilityPackage#getLink_KnowledgeAndSkill_DriverPreference()
 * @model
 * @generated
 */
public interface Link_KnowledgeAndSkill_DriverPreference extends EObject {
	/**
	 * Returns the value of the '<em><b>Name link knowledge And Skill driver Preference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name link knowledge And Skill driver Preference</em>' attribute.
	 * @see #setName_link_knowledgeAndSkill_driverPreference(String)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_KnowledgeAndSkill_DriverPreference_Name_link_knowledgeAndSkill_driverPreference()
	 * @model
	 * @generated
	 */
	String getName_link_knowledgeAndSkill_driverPreference();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_KnowledgeAndSkill_DriverPreference#getName_link_knowledgeAndSkill_driverPreference <em>Name link knowledge And Skill driver Preference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name link knowledge And Skill driver Preference</em>' attribute.
	 * @see #getName_link_knowledgeAndSkill_driverPreference()
	 * @generated
	 */
	void setName_link_knowledgeAndSkill_driverPreference(String value);

	/**
	 * Returns the value of the '<em><b>Link knowledge And Skill</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link knowledge And Skill</em>' reference.
	 * @see #setLink_knowledgeAndSkill(Knowledge_and_Skill)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_KnowledgeAndSkill_DriverPreference_Link_knowledgeAndSkill()
	 * @model
	 * @generated
	 */
	Knowledge_and_Skill getLink_knowledgeAndSkill();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_KnowledgeAndSkill_DriverPreference#getLink_knowledgeAndSkill <em>Link knowledge And Skill</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link knowledge And Skill</em>' reference.
	 * @see #getLink_knowledgeAndSkill()
	 * @generated
	 */
	void setLink_knowledgeAndSkill(Knowledge_and_Skill value);

	/**
	 * Returns the value of the '<em><b>Link driver Preference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link driver Preference</em>' reference.
	 * @see #setLink_driverPreference(Driver_Preference)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_KnowledgeAndSkill_DriverPreference_Link_driverPreference()
	 * @model
	 * @generated
	 */
	Driver_Preference getLink_driverPreference();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_KnowledgeAndSkill_DriverPreference#getLink_driverPreference <em>Link driver Preference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link driver Preference</em>' reference.
	 * @see #getLink_driverPreference()
	 * @generated
	 */
	void setLink_driverPreference(Driver_Preference value);

} // Link_KnowledgeAndSkill_DriverPreference
