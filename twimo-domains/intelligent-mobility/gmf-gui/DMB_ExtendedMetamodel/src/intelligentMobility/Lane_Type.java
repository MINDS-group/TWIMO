/**
 */
package intelligentMobility;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Lane Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.Lane_Type#getLaneType <em>Lane Type</em>}</li>
 *   <li>{@link intelligentMobility.Lane_Type#getLaneCount <em>Lane Count</em>}</li>
 *   <li>{@link intelligentMobility.Lane_Type#getLaneWidth <em>Lane Width</em>}</li>
 *   <li>{@link intelligentMobility.Lane_Type#getLaneLength <em>Lane Length</em>}</li>
 *   <li>{@link intelligentMobility.Lane_Type#getMaxSpeedLimitation <em>Max Speed Limitation</em>}</li>
 *   <li>{@link intelligentMobility.Lane_Type#getName <em>Name</em>}</li>
 *   <li>{@link intelligentMobility.Lane_Type#getRegulations <em>Regulations</em>}</li>
 * </ul>
 *
 * @see intelligentMobility.IntelligentMobilityPackage#getLane_Type()
 * @model
 * @generated
 */
public interface Lane_Type extends EObject {
	/**
	 * Returns the value of the '<em><b>Lane Type</b></em>' attribute.
	 * The literals are from the enumeration {@link intelligentMobility.Lanes}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lane Type</em>' attribute.
	 * @see intelligentMobility.Lanes
	 * @see #setLaneType(Lanes)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLane_Type_LaneType()
	 * @model
	 * @generated
	 */
	Lanes getLaneType();

	/**
	 * Sets the value of the '{@link intelligentMobility.Lane_Type#getLaneType <em>Lane Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lane Type</em>' attribute.
	 * @see intelligentMobility.Lanes
	 * @see #getLaneType()
	 * @generated
	 */
	void setLaneType(Lanes value);

	/**
	 * Returns the value of the '<em><b>Lane Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lane Count</em>' attribute.
	 * @see #setLaneCount(int)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLane_Type_LaneCount()
	 * @model
	 * @generated
	 */
	int getLaneCount();

	/**
	 * Sets the value of the '{@link intelligentMobility.Lane_Type#getLaneCount <em>Lane Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lane Count</em>' attribute.
	 * @see #getLaneCount()
	 * @generated
	 */
	void setLaneCount(int value);

	/**
	 * Returns the value of the '<em><b>Lane Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lane Width</em>' attribute.
	 * @see #setLaneWidth(double)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLane_Type_LaneWidth()
	 * @model
	 * @generated
	 */
	double getLaneWidth();

	/**
	 * Sets the value of the '{@link intelligentMobility.Lane_Type#getLaneWidth <em>Lane Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lane Width</em>' attribute.
	 * @see #getLaneWidth()
	 * @generated
	 */
	void setLaneWidth(double value);

	/**
	 * Returns the value of the '<em><b>Lane Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lane Length</em>' attribute.
	 * @see #setLaneLength(double)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLane_Type_LaneLength()
	 * @model
	 * @generated
	 */
	double getLaneLength();

	/**
	 * Sets the value of the '{@link intelligentMobility.Lane_Type#getLaneLength <em>Lane Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lane Length</em>' attribute.
	 * @see #getLaneLength()
	 * @generated
	 */
	void setLaneLength(double value);

	/**
	 * Returns the value of the '<em><b>Max Speed Limitation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Speed Limitation</em>' attribute.
	 * @see #setMaxSpeedLimitation(int)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLane_Type_MaxSpeedLimitation()
	 * @model
	 * @generated
	 */
	int getMaxSpeedLimitation();

	/**
	 * Sets the value of the '{@link intelligentMobility.Lane_Type#getMaxSpeedLimitation <em>Max Speed Limitation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Speed Limitation</em>' attribute.
	 * @see #getMaxSpeedLimitation()
	 * @generated
	 */
	void setMaxSpeedLimitation(int value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLane_Type_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link intelligentMobility.Lane_Type#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Regulations</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Regulations</em>' reference.
	 * @see #setRegulations(Regulation)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLane_Type_Regulations()
	 * @model
	 * @generated
	 */
	Regulation getRegulations();

	/**
	 * Sets the value of the '{@link intelligentMobility.Lane_Type#getRegulations <em>Regulations</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Regulations</em>' reference.
	 * @see #getRegulations()
	 * @generated
	 */
	void setRegulations(Regulation value);

} // Lane_Type
