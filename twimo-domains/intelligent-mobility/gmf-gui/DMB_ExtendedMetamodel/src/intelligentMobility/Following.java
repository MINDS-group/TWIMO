/**
 */
package intelligentMobility;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Following</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.Following#getFollowingGap <em>Following Gap</em>}</li>
 *   <li>{@link intelligentMobility.Following#getName <em>Name</em>}</li>
 *   <li>{@link intelligentMobility.Following#getMinGap <em>Min Gap</em>}</li>
 *   <li>{@link intelligentMobility.Following#getForward <em>Forward</em>}</li>
 *   <li>{@link intelligentMobility.Following#getBackward <em>Backward</em>}</li>
 * </ul>
 *
 * @see intelligentMobility.IntelligentMobilityPackage#getFollowing()
 * @model
 * @generated
 */
public interface Following extends EObject {
	/**
	 * Returns the value of the '<em><b>Following Gap</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Following Gap</em>' attribute.
	 * @see #setFollowingGap(int)
	 * @see intelligentMobility.IntelligentMobilityPackage#getFollowing_FollowingGap()
	 * @model
	 * @generated
	 */
	int getFollowingGap();

	/**
	 * Sets the value of the '{@link intelligentMobility.Following#getFollowingGap <em>Following Gap</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Following Gap</em>' attribute.
	 * @see #getFollowingGap()
	 * @generated
	 */
	void setFollowingGap(int value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see intelligentMobility.IntelligentMobilityPackage#getFollowing_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link intelligentMobility.Following#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Min Gap</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Min Gap</em>' reference.
	 * @see #setMinGap(LaneChanging)
	 * @see intelligentMobility.IntelligentMobilityPackage#getFollowing_MinGap()
	 * @model
	 * @generated
	 */
	LaneChanging getMinGap();

	/**
	 * Sets the value of the '{@link intelligentMobility.Following#getMinGap <em>Min Gap</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Gap</em>' reference.
	 * @see #getMinGap()
	 * @generated
	 */
	void setMinGap(LaneChanging value);

	/**
	 * Returns the value of the '<em><b>Forward</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Forward</em>' containment reference.
	 * @see #setForward(Forward)
	 * @see intelligentMobility.IntelligentMobilityPackage#getFollowing_Forward()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Forward getForward();

	/**
	 * Sets the value of the '{@link intelligentMobility.Following#getForward <em>Forward</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Forward</em>' containment reference.
	 * @see #getForward()
	 * @generated
	 */
	void setForward(Forward value);

	/**
	 * Returns the value of the '<em><b>Backward</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Backward</em>' containment reference.
	 * @see #setBackward(Backward)
	 * @see intelligentMobility.IntelligentMobilityPackage#getFollowing_Backward()
	 * @model containment="true"
	 * @generated
	 */
	Backward getBackward();

	/**
	 * Sets the value of the '{@link intelligentMobility.Following#getBackward <em>Backward</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Backward</em>' containment reference.
	 * @see #getBackward()
	 * @generated
	 */
	void setBackward(Backward value);

} // Following
