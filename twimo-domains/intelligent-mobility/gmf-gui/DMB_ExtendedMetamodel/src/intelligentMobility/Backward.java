/**
 */
package intelligentMobility;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Backward</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.Backward#getBackwardSpeed <em>Backward Speed</em>}</li>
 *   <li>{@link intelligentMobility.Backward#getBackDistance <em>Back Distance</em>}</li>
 *   <li>{@link intelligentMobility.Backward#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see intelligentMobility.IntelligentMobilityPackage#getBackward()
 * @model
 * @generated
 */
public interface Backward extends Action {
	/**
	 * Returns the value of the '<em><b>Backward Speed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Backward Speed</em>' attribute.
	 * @see #setBackwardSpeed(double)
	 * @see intelligentMobility.IntelligentMobilityPackage#getBackward_BackwardSpeed()
	 * @model
	 * @generated
	 */
	double getBackwardSpeed();

	/**
	 * Sets the value of the '{@link intelligentMobility.Backward#getBackwardSpeed <em>Backward Speed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Backward Speed</em>' attribute.
	 * @see #getBackwardSpeed()
	 * @generated
	 */
	void setBackwardSpeed(double value);

	/**
	 * Returns the value of the '<em><b>Back Distance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Back Distance</em>' attribute.
	 * @see #setBackDistance(double)
	 * @see intelligentMobility.IntelligentMobilityPackage#getBackward_BackDistance()
	 * @model
	 * @generated
	 */
	double getBackDistance();

	/**
	 * Sets the value of the '{@link intelligentMobility.Backward#getBackDistance <em>Back Distance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Back Distance</em>' attribute.
	 * @see #getBackDistance()
	 * @generated
	 */
	void setBackDistance(double value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see intelligentMobility.IntelligentMobilityPackage#getBackward_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link intelligentMobility.Backward#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // Backward
