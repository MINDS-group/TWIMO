/**
 */
package intelligentMobility;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Driver Preference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.Driver_Preference#getDriver_emotions <em>Driver emotions</em>}</li>
 *   <li>{@link intelligentMobility.Driver_Preference#getKnowledge_and_skills <em>Knowledge and skills</em>}</li>
 *   <li>{@link intelligentMobility.Driver_Preference#getName_PreferenceSet <em>Name Preference Set</em>}</li>
 *   <li>{@link intelligentMobility.Driver_Preference#getDriving_behaviour <em>Driving behaviour</em>}</li>
 *   <li>{@link intelligentMobility.Driver_Preference#getEnvironment_condition <em>Environment condition</em>}</li>
 * </ul>
 *
 * @see intelligentMobility.IntelligentMobilityPackage#getDriver_Preference()
 * @model
 * @generated
 */
public interface Driver_Preference extends EObject {
	/**
	 * Returns the value of the '<em><b>Driver emotions</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Driver_Emotion}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Driver emotions</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getDriver_Preference_Driver_emotions()
	 * @model type="intelligentMobility.Driver_Emotion" containment="true"
	 * @generated
	 */
	EList getDriver_emotions();

	/**
	 * Returns the value of the '<em><b>Knowledge and skills</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Knowledge and skills</em>' containment reference.
	 * @see #setKnowledge_and_skills(Knowledge_and_Skill)
	 * @see intelligentMobility.IntelligentMobilityPackage#getDriver_Preference_Knowledge_and_skills()
	 * @model containment="true"
	 * @generated
	 */
	Knowledge_and_Skill getKnowledge_and_skills();

	/**
	 * Sets the value of the '{@link intelligentMobility.Driver_Preference#getKnowledge_and_skills <em>Knowledge and skills</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Knowledge and skills</em>' containment reference.
	 * @see #getKnowledge_and_skills()
	 * @generated
	 */
	void setKnowledge_and_skills(Knowledge_and_Skill value);

	/**
	 * Returns the value of the '<em><b>Name Preference Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name Preference Set</em>' attribute.
	 * @see #setName_PreferenceSet(String)
	 * @see intelligentMobility.IntelligentMobilityPackage#getDriver_Preference_Name_PreferenceSet()
	 * @model
	 * @generated
	 */
	String getName_PreferenceSet();

	/**
	 * Sets the value of the '{@link intelligentMobility.Driver_Preference#getName_PreferenceSet <em>Name Preference Set</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name Preference Set</em>' attribute.
	 * @see #getName_PreferenceSet()
	 * @generated
	 */
	void setName_PreferenceSet(String value);

	/**
	 * Returns the value of the '<em><b>Driving behaviour</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Driving behaviour</em>' containment reference.
	 * @see #setDriving_behaviour(Driving_Behaviour)
	 * @see intelligentMobility.IntelligentMobilityPackage#getDriver_Preference_Driving_behaviour()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Driving_Behaviour getDriving_behaviour();

	/**
	 * Sets the value of the '{@link intelligentMobility.Driver_Preference#getDriving_behaviour <em>Driving behaviour</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Driving behaviour</em>' containment reference.
	 * @see #getDriving_behaviour()
	 * @generated
	 */
	void setDriving_behaviour(Driving_Behaviour value);

	/**
	 * Returns the value of the '<em><b>Environment condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Environment condition</em>' reference.
	 * @see #setEnvironment_condition(Environment_Condition)
	 * @see intelligentMobility.IntelligentMobilityPackage#getDriver_Preference_Environment_condition()
	 * @model required="true"
	 * @generated
	 */
	Environment_Condition getEnvironment_condition();

	/**
	 * Sets the value of the '{@link intelligentMobility.Driver_Preference#getEnvironment_condition <em>Environment condition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Environment condition</em>' reference.
	 * @see #getEnvironment_condition()
	 * @generated
	 */
	void setEnvironment_condition(Environment_Condition value);

} // Driver_Preference
