/**
 */
package intelligentMobility;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Forward</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.Forward#getAcceleration <em>Acceleration</em>}</li>
 *   <li>{@link intelligentMobility.Forward#getDeceleration <em>Deceleration</em>}</li>
 *   <li>{@link intelligentMobility.Forward#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see intelligentMobility.IntelligentMobilityPackage#getForward()
 * @model
 * @generated
 */
public interface Forward extends Action {
	/**
	 * Returns the value of the '<em><b>Acceleration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Acceleration</em>' attribute.
	 * @see #setAcceleration(double)
	 * @see intelligentMobility.IntelligentMobilityPackage#getForward_Acceleration()
	 * @model
	 * @generated
	 */
	double getAcceleration();

	/**
	 * Sets the value of the '{@link intelligentMobility.Forward#getAcceleration <em>Acceleration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Acceleration</em>' attribute.
	 * @see #getAcceleration()
	 * @generated
	 */
	void setAcceleration(double value);

	/**
	 * Returns the value of the '<em><b>Deceleration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Deceleration</em>' attribute.
	 * @see #setDeceleration(double)
	 * @see intelligentMobility.IntelligentMobilityPackage#getForward_Deceleration()
	 * @model
	 * @generated
	 */
	double getDeceleration();

	/**
	 * Sets the value of the '{@link intelligentMobility.Forward#getDeceleration <em>Deceleration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Deceleration</em>' attribute.
	 * @see #getDeceleration()
	 * @generated
	 */
	void setDeceleration(double value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see intelligentMobility.IntelligentMobilityPackage#getForward_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link intelligentMobility.Forward#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // Forward
