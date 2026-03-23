/**
 */
package intelligentMobility;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link Following Min Gap</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.Link_Following_MinGap#getName_link_following_minGap <em>Name link following min Gap</em>}</li>
 *   <li>{@link intelligentMobility.Link_Following_MinGap#getLink_following <em>Link following</em>}</li>
 *   <li>{@link intelligentMobility.Link_Following_MinGap#getLink_minGap <em>Link min Gap</em>}</li>
 * </ul>
 *
 * @see intelligentMobility.IntelligentMobilityPackage#getLink_Following_MinGap()
 * @model
 * @generated
 */
public interface Link_Following_MinGap extends EObject {
	/**
	 * Returns the value of the '<em><b>Name link following min Gap</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name link following min Gap</em>' attribute.
	 * @see #setName_link_following_minGap(String)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_Following_MinGap_Name_link_following_minGap()
	 * @model
	 * @generated
	 */
	String getName_link_following_minGap();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_Following_MinGap#getName_link_following_minGap <em>Name link following min Gap</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name link following min Gap</em>' attribute.
	 * @see #getName_link_following_minGap()
	 * @generated
	 */
	void setName_link_following_minGap(String value);

	/**
	 * Returns the value of the '<em><b>Link following</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link following</em>' reference.
	 * @see #setLink_following(Following)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_Following_MinGap_Link_following()
	 * @model
	 * @generated
	 */
	Following getLink_following();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_Following_MinGap#getLink_following <em>Link following</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link following</em>' reference.
	 * @see #getLink_following()
	 * @generated
	 */
	void setLink_following(Following value);

	/**
	 * Returns the value of the '<em><b>Link min Gap</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link min Gap</em>' reference.
	 * @see #setLink_minGap(LaneChanging)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_Following_MinGap_Link_minGap()
	 * @model
	 * @generated
	 */
	LaneChanging getLink_minGap();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_Following_MinGap#getLink_minGap <em>Link min Gap</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link min Gap</em>' reference.
	 * @see #getLink_minGap()
	 * @generated
	 */
	void setLink_minGap(LaneChanging value);

} // Link_Following_MinGap
