/**
 */
package intelligentMobility;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Environment Condition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.Environment_Condition#getRoadType <em>Road Type</em>}</li>
 *   <li>{@link intelligentMobility.Environment_Condition#getLaneAmount <em>Lane Amount</em>}</li>
 *   <li>{@link intelligentMobility.Environment_Condition#getName_EnvironmentCondition <em>Name Environment Condition</em>}</li>
 *   <li>{@link intelligentMobility.Environment_Condition#getLane_type <em>Lane type</em>}</li>
 *   <li>{@link intelligentMobility.Environment_Condition#getRegulations <em>Regulations</em>}</li>
 *   <li>{@link intelligentMobility.Environment_Condition#getWeather <em>Weather</em>}</li>
 *   <li>{@link intelligentMobility.Environment_Condition#getTraffic_condition <em>Traffic condition</em>}</li>
 *   <li>{@link intelligentMobility.Environment_Condition#getSpecial_condition <em>Special condition</em>}</li>
 *   <li>{@link intelligentMobility.Environment_Condition#getCueType <em>Cue Type</em>}</li>
 *   <li>{@link intelligentMobility.Environment_Condition#getSalience <em>Salience</em>}</li>
 *   <li>{@link intelligentMobility.Environment_Condition#getPosition <em>Position</em>}</li>
 * </ul>
 *
 * @see intelligentMobility.IntelligentMobilityPackage#getEnvironment_Condition()
 * @model
 * @generated
 */
public interface Environment_Condition extends EObject {
	/**
	 * Returns the value of the '<em><b>Road Type</b></em>' attribute.
	 * The literals are from the enumeration {@link intelligentMobility.RoadType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Road Type</em>' attribute.
	 * @see intelligentMobility.RoadType
	 * @see #setRoadType(RoadType)
	 * @see intelligentMobility.IntelligentMobilityPackage#getEnvironment_Condition_RoadType()
	 * @model
	 * @generated
	 */
	RoadType getRoadType();

	/**
	 * Sets the value of the '{@link intelligentMobility.Environment_Condition#getRoadType <em>Road Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Road Type</em>' attribute.
	 * @see intelligentMobility.RoadType
	 * @see #getRoadType()
	 * @generated
	 */
	void setRoadType(RoadType value);

	/**
	 * Returns the value of the '<em><b>Lane Amount</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lane Amount</em>' attribute.
	 * @see #setLaneAmount(int)
	 * @see intelligentMobility.IntelligentMobilityPackage#getEnvironment_Condition_LaneAmount()
	 * @model
	 * @generated
	 */
	int getLaneAmount();

	/**
	 * Sets the value of the '{@link intelligentMobility.Environment_Condition#getLaneAmount <em>Lane Amount</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lane Amount</em>' attribute.
	 * @see #getLaneAmount()
	 * @generated
	 */
	void setLaneAmount(int value);

	/**
	 * Returns the value of the '<em><b>Name Environment Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name Environment Condition</em>' attribute.
	 * @see #setName_EnvironmentCondition(String)
	 * @see intelligentMobility.IntelligentMobilityPackage#getEnvironment_Condition_Name_EnvironmentCondition()
	 * @model
	 * @generated
	 */
	String getName_EnvironmentCondition();

	/**
	 * Sets the value of the '{@link intelligentMobility.Environment_Condition#getName_EnvironmentCondition <em>Name Environment Condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name Environment Condition</em>' attribute.
	 * @see #getName_EnvironmentCondition()
	 * @generated
	 */
	void setName_EnvironmentCondition(String value);

	/**
	 * Returns the value of the '<em><b>Lane type</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Lane_Type}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lane type</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getEnvironment_Condition_Lane_type()
	 * @model type="intelligentMobility.Lane_Type" containment="true" required="true"
	 * @generated
	 */
	EList getLane_type();

	/**
	 * Returns the value of the '<em><b>Regulations</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Regulation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Regulations</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getEnvironment_Condition_Regulations()
	 * @model type="intelligentMobility.Regulation" containment="true"
	 * @generated
	 */
	EList getRegulations();

	/**
	 * Returns the value of the '<em><b>Weather</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Weather}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Weather</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getEnvironment_Condition_Weather()
	 * @model type="intelligentMobility.Weather" containment="true"
	 * @generated
	 */
	EList getWeather();

	/**
	 * Returns the value of the '<em><b>Traffic condition</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Traffic_Situation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Traffic condition</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getEnvironment_Condition_Traffic_condition()
	 * @model type="intelligentMobility.Traffic_Situation" containment="true"
	 * @generated
	 */
	EList getTraffic_condition();

	/**
	 * Returns the value of the '<em><b>Special condition</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Special_Condition}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Special condition</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getEnvironment_Condition_Special_condition()
	 * @model type="intelligentMobility.Special_Condition" containment="true"
	 * @generated
	 */
	EList getSpecial_condition();

	/**
	 * Returns the value of the '<em><b>Cue Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cue Type</em>' attribute.
	 * @see #setCueType(String)
	 * @see intelligentMobility.IntelligentMobilityPackage#getEnvironment_Condition_CueType()
	 * @model
	 * @generated
	 */
	String getCueType();

	/**
	 * Sets the value of the '{@link intelligentMobility.Environment_Condition#getCueType <em>Cue Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cue Type</em>' attribute.
	 * @see #getCueType()
	 * @generated
	 */
	void setCueType(String value);

	/**
	 * Returns the value of the '<em><b>Salience</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Salience</em>' attribute.
	 * @see #setSalience(float)
	 * @see intelligentMobility.IntelligentMobilityPackage#getEnvironment_Condition_Salience()
	 * @model
	 * @generated
	 */
	float getSalience();

	/**
	 * Sets the value of the '{@link intelligentMobility.Environment_Condition#getSalience <em>Salience</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Salience</em>' attribute.
	 * @see #getSalience()
	 * @generated
	 */
	void setSalience(float value);

	/**
	 * Returns the value of the '<em><b>Position</b></em>' reference list.
	 * The list contents are of type {@link intelligentMobility.Vehicle_Configuration}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Position</em>' reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getEnvironment_Condition_Position()
	 * @model type="intelligentMobility.Vehicle_Configuration"
	 * @generated
	 */
	EList getPosition();

} // Environment_Condition
