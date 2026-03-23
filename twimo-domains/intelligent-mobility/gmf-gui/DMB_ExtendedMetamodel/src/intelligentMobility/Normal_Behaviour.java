/**
 */
package intelligentMobility;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Normal Behaviour</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.Normal_Behaviour#getFollowing <em>Following</em>}</li>
 *   <li>{@link intelligentMobility.Normal_Behaviour#getLanechanging <em>Lanechanging</em>}</li>
 * </ul>
 *
 * @see intelligentMobility.IntelligentMobilityPackage#getNormal_Behaviour()
 * @model
 * @generated
 */
public interface Normal_Behaviour extends EObject {
	/**
	 * Returns the value of the '<em><b>Following</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Following</em>' containment reference.
	 * @see #setFollowing(Following)
	 * @see intelligentMobility.IntelligentMobilityPackage#getNormal_Behaviour_Following()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Following getFollowing();

	/**
	 * Sets the value of the '{@link intelligentMobility.Normal_Behaviour#getFollowing <em>Following</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Following</em>' containment reference.
	 * @see #getFollowing()
	 * @generated
	 */
	void setFollowing(Following value);

	/**
	 * Returns the value of the '<em><b>Lanechanging</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lanechanging</em>' containment reference.
	 * @see #setLanechanging(LaneChanging)
	 * @see intelligentMobility.IntelligentMobilityPackage#getNormal_Behaviour_Lanechanging()
	 * @model containment="true" required="true"
	 * @generated
	 */
	LaneChanging getLanechanging();

	/**
	 * Sets the value of the '{@link intelligentMobility.Normal_Behaviour#getLanechanging <em>Lanechanging</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lanechanging</em>' containment reference.
	 * @see #getLanechanging()
	 * @generated
	 */
	void setLanechanging(LaneChanging value);

} // Normal_Behaviour
