/**
 */
package intelligentMobility;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Knowledge and Skill</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.Knowledge_and_Skill#getDrivingSkill <em>Driving Skill</em>}</li>
 *   <li>{@link intelligentMobility.Knowledge_and_Skill#getTrafficSignAwareness <em>Traffic Sign Awareness</em>}</li>
 *   <li>{@link intelligentMobility.Knowledge_and_Skill#getRegulationAwareness <em>Regulation Awareness</em>}</li>
 *   <li>{@link intelligentMobility.Knowledge_and_Skill#getLaneSwitchPreferenceLevel <em>Lane Switch Preference Level</em>}</li>
 *   <li>{@link intelligentMobility.Knowledge_and_Skill#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see intelligentMobility.IntelligentMobilityPackage#getKnowledge_and_Skill()
 * @model
 * @generated
 */
public interface Knowledge_and_Skill extends EObject {
	/**
	 * Returns the value of the '<em><b>Driving Skill</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Driving Skill</em>' attribute.
	 * @see #setDrivingSkill(int)
	 * @see intelligentMobility.IntelligentMobilityPackage#getKnowledge_and_Skill_DrivingSkill()
	 * @model
	 * @generated
	 */
	int getDrivingSkill();

	/**
	 * Sets the value of the '{@link intelligentMobility.Knowledge_and_Skill#getDrivingSkill <em>Driving Skill</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Driving Skill</em>' attribute.
	 * @see #getDrivingSkill()
	 * @generated
	 */
	void setDrivingSkill(int value);

	/**
	 * Returns the value of the '<em><b>Traffic Sign Awareness</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Traffic Sign Awareness</em>' attribute.
	 * @see #setTrafficSignAwareness(int)
	 * @see intelligentMobility.IntelligentMobilityPackage#getKnowledge_and_Skill_TrafficSignAwareness()
	 * @model
	 * @generated
	 */
	int getTrafficSignAwareness();

	/**
	 * Sets the value of the '{@link intelligentMobility.Knowledge_and_Skill#getTrafficSignAwareness <em>Traffic Sign Awareness</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Traffic Sign Awareness</em>' attribute.
	 * @see #getTrafficSignAwareness()
	 * @generated
	 */
	void setTrafficSignAwareness(int value);

	/**
	 * Returns the value of the '<em><b>Regulation Awareness</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Regulation Awareness</em>' attribute.
	 * @see #setRegulationAwareness(int)
	 * @see intelligentMobility.IntelligentMobilityPackage#getKnowledge_and_Skill_RegulationAwareness()
	 * @model
	 * @generated
	 */
	int getRegulationAwareness();

	/**
	 * Sets the value of the '{@link intelligentMobility.Knowledge_and_Skill#getRegulationAwareness <em>Regulation Awareness</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Regulation Awareness</em>' attribute.
	 * @see #getRegulationAwareness()
	 * @generated
	 */
	void setRegulationAwareness(int value);

	/**
	 * Returns the value of the '<em><b>Lane Switch Preference Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lane Switch Preference Level</em>' attribute.
	 * @see #setLaneSwitchPreferenceLevel(int)
	 * @see intelligentMobility.IntelligentMobilityPackage#getKnowledge_and_Skill_LaneSwitchPreferenceLevel()
	 * @model
	 * @generated
	 */
	int getLaneSwitchPreferenceLevel();

	/**
	 * Sets the value of the '{@link intelligentMobility.Knowledge_and_Skill#getLaneSwitchPreferenceLevel <em>Lane Switch Preference Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lane Switch Preference Level</em>' attribute.
	 * @see #getLaneSwitchPreferenceLevel()
	 * @generated
	 */
	void setLaneSwitchPreferenceLevel(int value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see intelligentMobility.IntelligentMobilityPackage#getKnowledge_and_Skill_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link intelligentMobility.Knowledge_and_Skill#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // Knowledge_and_Skill
