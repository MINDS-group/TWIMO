/**
 */
package intelligentMobility;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abnormal Behaviour</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.Abnormal_Behaviour#isZigzag_Driving <em>Zigzag Driving</em>}</li>
 *   <li>{@link intelligentMobility.Abnormal_Behaviour#isRisky_Acceleration <em>Risky Acceleration</em>}</li>
 *   <li>{@link intelligentMobility.Abnormal_Behaviour#isRisky_Lanechanging <em>Risky Lanechanging</em>}</li>
 *   <li>{@link intelligentMobility.Abnormal_Behaviour#getName <em>Name</em>}</li>
 *   <li>{@link intelligentMobility.Abnormal_Behaviour#getActions <em>Actions</em>}</li>
 * </ul>
 *
 * @see intelligentMobility.IntelligentMobilityPackage#getAbnormal_Behaviour()
 * @model
 * @generated
 */
public interface Abnormal_Behaviour extends Normal_Behaviour {
	/**
	 * Returns the value of the '<em><b>Zigzag Driving</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Zigzag Driving</em>' attribute.
	 * @see #setZigzag_Driving(boolean)
	 * @see intelligentMobility.IntelligentMobilityPackage#getAbnormal_Behaviour_Zigzag_Driving()
	 * @model
	 * @generated
	 */
	boolean isZigzag_Driving();

	/**
	 * Sets the value of the '{@link intelligentMobility.Abnormal_Behaviour#isZigzag_Driving <em>Zigzag Driving</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Zigzag Driving</em>' attribute.
	 * @see #isZigzag_Driving()
	 * @generated
	 */
	void setZigzag_Driving(boolean value);

	/**
	 * Returns the value of the '<em><b>Risky Acceleration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Risky Acceleration</em>' attribute.
	 * @see #setRisky_Acceleration(boolean)
	 * @see intelligentMobility.IntelligentMobilityPackage#getAbnormal_Behaviour_Risky_Acceleration()
	 * @model
	 * @generated
	 */
	boolean isRisky_Acceleration();

	/**
	 * Sets the value of the '{@link intelligentMobility.Abnormal_Behaviour#isRisky_Acceleration <em>Risky Acceleration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Risky Acceleration</em>' attribute.
	 * @see #isRisky_Acceleration()
	 * @generated
	 */
	void setRisky_Acceleration(boolean value);

	/**
	 * Returns the value of the '<em><b>Risky Lanechanging</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Risky Lanechanging</em>' attribute.
	 * @see #setRisky_Lanechanging(boolean)
	 * @see intelligentMobility.IntelligentMobilityPackage#getAbnormal_Behaviour_Risky_Lanechanging()
	 * @model
	 * @generated
	 */
	boolean isRisky_Lanechanging();

	/**
	 * Sets the value of the '{@link intelligentMobility.Abnormal_Behaviour#isRisky_Lanechanging <em>Risky Lanechanging</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Risky Lanechanging</em>' attribute.
	 * @see #isRisky_Lanechanging()
	 * @generated
	 */
	void setRisky_Lanechanging(boolean value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see intelligentMobility.IntelligentMobilityPackage#getAbnormal_Behaviour_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link intelligentMobility.Abnormal_Behaviour#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Actions</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Action}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actions</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getAbnormal_Behaviour_Actions()
	 * @model type="intelligentMobility.Action" containment="true"
	 * @generated
	 */
	EList getActions();

} // Abnormal_Behaviour
