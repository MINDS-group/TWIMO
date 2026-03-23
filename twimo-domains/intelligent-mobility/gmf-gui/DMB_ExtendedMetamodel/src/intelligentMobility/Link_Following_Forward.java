/**
 */
package intelligentMobility;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link Following Forward</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.Link_Following_Forward#getName_link_following_forward <em>Name link following forward</em>}</li>
 *   <li>{@link intelligentMobility.Link_Following_Forward#getLink_following <em>Link following</em>}</li>
 *   <li>{@link intelligentMobility.Link_Following_Forward#getLink_forward <em>Link forward</em>}</li>
 * </ul>
 *
 * @see intelligentMobility.IntelligentMobilityPackage#getLink_Following_Forward()
 * @model
 * @generated
 */
public interface Link_Following_Forward extends EObject {
	/**
	 * Returns the value of the '<em><b>Name link following forward</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name link following forward</em>' attribute.
	 * @see #setName_link_following_forward(String)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_Following_Forward_Name_link_following_forward()
	 * @model
	 * @generated
	 */
	String getName_link_following_forward();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_Following_Forward#getName_link_following_forward <em>Name link following forward</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name link following forward</em>' attribute.
	 * @see #getName_link_following_forward()
	 * @generated
	 */
	void setName_link_following_forward(String value);

	/**
	 * Returns the value of the '<em><b>Link following</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link following</em>' reference.
	 * @see #setLink_following(Following)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_Following_Forward_Link_following()
	 * @model
	 * @generated
	 */
	Following getLink_following();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_Following_Forward#getLink_following <em>Link following</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link following</em>' reference.
	 * @see #getLink_following()
	 * @generated
	 */
	void setLink_following(Following value);

	/**
	 * Returns the value of the '<em><b>Link forward</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link forward</em>' reference.
	 * @see #setLink_forward(Forward)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_Following_Forward_Link_forward()
	 * @model
	 * @generated
	 */
	Forward getLink_forward();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_Following_Forward#getLink_forward <em>Link forward</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link forward</em>' reference.
	 * @see #getLink_forward()
	 * @generated
	 */
	void setLink_forward(Forward value);

} // Link_Following_Forward
