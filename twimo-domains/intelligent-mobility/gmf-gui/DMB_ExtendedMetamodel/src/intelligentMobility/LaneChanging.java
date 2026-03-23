/**
 */
package intelligentMobility;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Lane Changing</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.LaneChanging#getLaneSwitchSpeed <em>Lane Switch Speed</em>}</li>
 *   <li>{@link intelligentMobility.LaneChanging#getName <em>Name</em>}</li>
 *   <li>{@link intelligentMobility.LaneChanging#getTurn <em>Turn</em>}</li>
 *   <li>{@link intelligentMobility.LaneChanging#getGapacceptance <em>Gapacceptance</em>}</li>
 *   <li>{@link intelligentMobility.LaneChanging#getEnvironment_condition <em>Environment condition</em>}</li>
 *   <li>{@link intelligentMobility.LaneChanging#getLeftLaneChange <em>Left Lane Change</em>}</li>
 *   <li>{@link intelligentMobility.LaneChanging#getRightLaneChange <em>Right Lane Change</em>}</li>
 *   <li>{@link intelligentMobility.LaneChanging#getLeftLaneBranch <em>Left Lane Branch</em>}</li>
 *   <li>{@link intelligentMobility.LaneChanging#getRightLaneBranch <em>Right Lane Branch</em>}</li>
 *   <li>{@link intelligentMobility.LaneChanging#getAction <em>Action</em>}</li>
 *   <li>{@link intelligentMobility.LaneChanging#getManeuverType <em>Maneuver Type</em>}</li>
 *   <li>{@link intelligentMobility.LaneChanging#getDuration <em>Duration</em>}</li>
 * </ul>
 *
 * @see intelligentMobility.IntelligentMobilityPackage#getLaneChanging()
 * @model
 * @generated
 */
public interface LaneChanging extends EObject {
	/**
	 * Returns the value of the '<em><b>Lane Switch Speed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lane Switch Speed</em>' attribute.
	 * @see #setLaneSwitchSpeed(double)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLaneChanging_LaneSwitchSpeed()
	 * @model
	 * @generated
	 */
	double getLaneSwitchSpeed();

	/**
	 * Sets the value of the '{@link intelligentMobility.LaneChanging#getLaneSwitchSpeed <em>Lane Switch Speed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lane Switch Speed</em>' attribute.
	 * @see #getLaneSwitchSpeed()
	 * @generated
	 */
	void setLaneSwitchSpeed(double value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLaneChanging_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link intelligentMobility.LaneChanging#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Turn</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Turn}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Turn</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getLaneChanging_Turn()
	 * @model type="intelligentMobility.Turn" containment="true" required="true" upper="2"
	 * @generated
	 */
	EList getTurn();

	/**
	 * Returns the value of the '<em><b>Gapacceptance</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gapacceptance</em>' containment reference.
	 * @see #setGapacceptance(GapAcceptance)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLaneChanging_Gapacceptance()
	 * @model containment="true" required="true"
	 * @generated
	 */
	GapAcceptance getGapacceptance();

	/**
	 * Sets the value of the '{@link intelligentMobility.LaneChanging#getGapacceptance <em>Gapacceptance</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Gapacceptance</em>' containment reference.
	 * @see #getGapacceptance()
	 * @generated
	 */
	void setGapacceptance(GapAcceptance value);

	/**
	 * Returns the value of the '<em><b>Environment condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Environment condition</em>' reference.
	 * @see #setEnvironment_condition(Environment_Condition)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLaneChanging_Environment_condition()
	 * @model
	 * @generated
	 */
	Environment_Condition getEnvironment_condition();

	/**
	 * Sets the value of the '{@link intelligentMobility.LaneChanging#getEnvironment_condition <em>Environment condition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Environment condition</em>' reference.
	 * @see #getEnvironment_condition()
	 * @generated
	 */
	void setEnvironment_condition(Environment_Condition value);

	/**
	 * Returns the value of the '<em><b>Left Lane Change</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left Lane Change</em>' attribute.
	 * @see #setLeftLaneChange(int)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLaneChanging_LeftLaneChange()
	 * @model
	 * @generated
	 */
	int getLeftLaneChange();

	/**
	 * Sets the value of the '{@link intelligentMobility.LaneChanging#getLeftLaneChange <em>Left Lane Change</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left Lane Change</em>' attribute.
	 * @see #getLeftLaneChange()
	 * @generated
	 */
	void setLeftLaneChange(int value);

	/**
	 * Returns the value of the '<em><b>Right Lane Change</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right Lane Change</em>' attribute.
	 * @see #setRightLaneChange(int)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLaneChanging_RightLaneChange()
	 * @model
	 * @generated
	 */
	int getRightLaneChange();

	/**
	 * Sets the value of the '{@link intelligentMobility.LaneChanging#getRightLaneChange <em>Right Lane Change</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right Lane Change</em>' attribute.
	 * @see #getRightLaneChange()
	 * @generated
	 */
	void setRightLaneChange(int value);

	/**
	 * Returns the value of the '<em><b>Left Lane Branch</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left Lane Branch</em>' attribute.
	 * @see #setLeftLaneBranch(int)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLaneChanging_LeftLaneBranch()
	 * @model
	 * @generated
	 */
	int getLeftLaneBranch();

	/**
	 * Sets the value of the '{@link intelligentMobility.LaneChanging#getLeftLaneBranch <em>Left Lane Branch</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left Lane Branch</em>' attribute.
	 * @see #getLeftLaneBranch()
	 * @generated
	 */
	void setLeftLaneBranch(int value);

	/**
	 * Returns the value of the '<em><b>Right Lane Branch</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right Lane Branch</em>' attribute.
	 * @see #setRightLaneBranch(int)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLaneChanging_RightLaneBranch()
	 * @model
	 * @generated
	 */
	int getRightLaneBranch();

	/**
	 * Sets the value of the '{@link intelligentMobility.LaneChanging#getRightLaneBranch <em>Right Lane Branch</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right Lane Branch</em>' attribute.
	 * @see #getRightLaneBranch()
	 * @generated
	 */
	void setRightLaneBranch(int value);

	/**
	 * Returns the value of the '<em><b>Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action</em>' reference.
	 * @see #setAction(Action)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLaneChanging_Action()
	 * @model
	 * @generated
	 */
	Action getAction();

	/**
	 * Sets the value of the '{@link intelligentMobility.LaneChanging#getAction <em>Action</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Action</em>' reference.
	 * @see #getAction()
	 * @generated
	 */
	void setAction(Action value);

	/**
	 * Returns the value of the '<em><b>Maneuver Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Maneuver Type</em>' attribute.
	 * @see #setManeuverType(String)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLaneChanging_ManeuverType()
	 * @model
	 * @generated
	 */
	String getManeuverType();

	/**
	 * Sets the value of the '{@link intelligentMobility.LaneChanging#getManeuverType <em>Maneuver Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Maneuver Type</em>' attribute.
	 * @see #getManeuverType()
	 * @generated
	 */
	void setManeuverType(String value);

	/**
	 * Returns the value of the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Duration</em>' attribute.
	 * @see #setDuration(float)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLaneChanging_Duration()
	 * @model
	 * @generated
	 */
	float getDuration();

	/**
	 * Sets the value of the '{@link intelligentMobility.LaneChanging#getDuration <em>Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Duration</em>' attribute.
	 * @see #getDuration()
	 * @generated
	 */
	void setDuration(float value);

} // LaneChanging
