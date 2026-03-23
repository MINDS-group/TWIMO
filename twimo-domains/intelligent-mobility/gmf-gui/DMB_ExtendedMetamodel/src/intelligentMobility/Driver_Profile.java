/**
 */
package intelligentMobility;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Driver Profile</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.Driver_Profile#getDriver_preference <em>Driver preference</em>}</li>
 *   <li>{@link intelligentMobility.Driver_Profile#getDriverName <em>Driver Name</em>}</li>
 *   <li>{@link intelligentMobility.Driver_Profile#getDriverType <em>Driver Type</em>}</li>
 *   <li>{@link intelligentMobility.Driver_Profile#getPatienceValue <em>Patience Value</em>}</li>
 *   <li>{@link intelligentMobility.Driver_Profile#getLanePreference <em>Lane Preference</em>}</li>
 *   <li>{@link intelligentMobility.Driver_Profile#getEnergySpeedRate <em>Energy Speed Rate</em>}</li>
 *   <li>{@link intelligentMobility.Driver_Profile#getRiskLevel <em>Risk Level</em>}</li>
 *   <li>{@link intelligentMobility.Driver_Profile#getReactionTime_min <em>Reaction Time min</em>}</li>
 *   <li>{@link intelligentMobility.Driver_Profile#getReactionTime_max <em>Reaction Time max</em>}</li>
 *   <li>{@link intelligentMobility.Driver_Profile#getReactionTime_precision <em>Reaction Time precision</em>}</li>
 *   <li>{@link intelligentMobility.Driver_Profile#getAge <em>Age</em>}</li>
 * </ul>
 *
 * @see intelligentMobility.IntelligentMobilityPackage#getDriver_Profile()
 * @model
 * @generated
 */
public interface Driver_Profile extends EObject {
	/**
	 * Returns the value of the '<em><b>Driver preference</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Driver_Preference}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Driver preference</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getDriver_Profile_Driver_preference()
	 * @model type="intelligentMobility.Driver_Preference" containment="true" required="true"
	 * @generated
	 */
	EList getDriver_preference();

	/**
	 * Returns the value of the '<em><b>Driver Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Driver Name</em>' attribute.
	 * @see #setDriverName(String)
	 * @see intelligentMobility.IntelligentMobilityPackage#getDriver_Profile_DriverName()
	 * @model
	 * @generated
	 */
	String getDriverName();

	/**
	 * Sets the value of the '{@link intelligentMobility.Driver_Profile#getDriverName <em>Driver Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Driver Name</em>' attribute.
	 * @see #getDriverName()
	 * @generated
	 */
	void setDriverName(String value);

	/**
	 * Returns the value of the '<em><b>Driver Type</b></em>' attribute.
	 * The literals are from the enumeration {@link intelligentMobility.DriverType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Driver Type</em>' attribute.
	 * @see intelligentMobility.DriverType
	 * @see #setDriverType(DriverType)
	 * @see intelligentMobility.IntelligentMobilityPackage#getDriver_Profile_DriverType()
	 * @model
	 * @generated
	 */
	DriverType getDriverType();

	/**
	 * Sets the value of the '{@link intelligentMobility.Driver_Profile#getDriverType <em>Driver Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Driver Type</em>' attribute.
	 * @see intelligentMobility.DriverType
	 * @see #getDriverType()
	 * @generated
	 */
	void setDriverType(DriverType value);

	/**
	 * Returns the value of the '<em><b>Patience Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Patience Value</em>' attribute.
	 * @see #setPatienceValue(int)
	 * @see intelligentMobility.IntelligentMobilityPackage#getDriver_Profile_PatienceValue()
	 * @model
	 * @generated
	 */
	int getPatienceValue();

	/**
	 * Sets the value of the '{@link intelligentMobility.Driver_Profile#getPatienceValue <em>Patience Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Patience Value</em>' attribute.
	 * @see #getPatienceValue()
	 * @generated
	 */
	void setPatienceValue(int value);

	/**
	 * Returns the value of the '<em><b>Lane Preference</b></em>' attribute.
	 * The literals are from the enumeration {@link intelligentMobility.Lanes}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lane Preference</em>' attribute.
	 * @see intelligentMobility.Lanes
	 * @see #setLanePreference(Lanes)
	 * @see intelligentMobility.IntelligentMobilityPackage#getDriver_Profile_LanePreference()
	 * @model
	 * @generated
	 */
	Lanes getLanePreference();

	/**
	 * Sets the value of the '{@link intelligentMobility.Driver_Profile#getLanePreference <em>Lane Preference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lane Preference</em>' attribute.
	 * @see intelligentMobility.Lanes
	 * @see #getLanePreference()
	 * @generated
	 */
	void setLanePreference(Lanes value);

	/**
	 * Returns the value of the '<em><b>Energy Speed Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Energy Speed Rate</em>' attribute.
	 * @see #setEnergySpeedRate(double)
	 * @see intelligentMobility.IntelligentMobilityPackage#getDriver_Profile_EnergySpeedRate()
	 * @model
	 * @generated
	 */
	double getEnergySpeedRate();

	/**
	 * Sets the value of the '{@link intelligentMobility.Driver_Profile#getEnergySpeedRate <em>Energy Speed Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Energy Speed Rate</em>' attribute.
	 * @see #getEnergySpeedRate()
	 * @generated
	 */
	void setEnergySpeedRate(double value);

	/**
	 * Returns the value of the '<em><b>Risk Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Risk Level</em>' attribute.
	 * @see #setRiskLevel(int)
	 * @see intelligentMobility.IntelligentMobilityPackage#getDriver_Profile_RiskLevel()
	 * @model
	 * @generated
	 */
	int getRiskLevel();

	/**
	 * Sets the value of the '{@link intelligentMobility.Driver_Profile#getRiskLevel <em>Risk Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Risk Level</em>' attribute.
	 * @see #getRiskLevel()
	 * @generated
	 */
	void setRiskLevel(int value);

	/**
	 * Returns the value of the '<em><b>Reaction Time min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reaction Time min</em>' attribute.
	 * @see #setReactionTime_min(double)
	 * @see intelligentMobility.IntelligentMobilityPackage#getDriver_Profile_ReactionTime_min()
	 * @model
	 * @generated
	 */
	double getReactionTime_min();

	/**
	 * Sets the value of the '{@link intelligentMobility.Driver_Profile#getReactionTime_min <em>Reaction Time min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reaction Time min</em>' attribute.
	 * @see #getReactionTime_min()
	 * @generated
	 */
	void setReactionTime_min(double value);

	/**
	 * Returns the value of the '<em><b>Reaction Time max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reaction Time max</em>' attribute.
	 * @see #setReactionTime_max(double)
	 * @see intelligentMobility.IntelligentMobilityPackage#getDriver_Profile_ReactionTime_max()
	 * @model
	 * @generated
	 */
	double getReactionTime_max();

	/**
	 * Sets the value of the '{@link intelligentMobility.Driver_Profile#getReactionTime_max <em>Reaction Time max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reaction Time max</em>' attribute.
	 * @see #getReactionTime_max()
	 * @generated
	 */
	void setReactionTime_max(double value);

	/**
	 * Returns the value of the '<em><b>Reaction Time precision</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reaction Time precision</em>' attribute.
	 * @see #setReactionTime_precision(int)
	 * @see intelligentMobility.IntelligentMobilityPackage#getDriver_Profile_ReactionTime_precision()
	 * @model
	 * @generated
	 */
	int getReactionTime_precision();

	/**
	 * Sets the value of the '{@link intelligentMobility.Driver_Profile#getReactionTime_precision <em>Reaction Time precision</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reaction Time precision</em>' attribute.
	 * @see #getReactionTime_precision()
	 * @generated
	 */
	void setReactionTime_precision(int value);

	/**
	 * Returns the value of the '<em><b>Age</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Age</em>' attribute.
	 * @see #setAge(int)
	 * @see intelligentMobility.IntelligentMobilityPackage#getDriver_Profile_Age()
	 * @model
	 * @generated
	 */
	int getAge();

	/**
	 * Sets the value of the '{@link intelligentMobility.Driver_Profile#getAge <em>Age</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Age</em>' attribute.
	 * @see #getAge()
	 * @generated
	 */
	void setAge(int value);

} // Driver_Profile
