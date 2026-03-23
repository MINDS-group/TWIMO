/**
 */
package intelligentMobility;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link Following Backward</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.Link_Following_Backward#getName_link_following_backward <em>Name link following backward</em>}</li>
 *   <li>{@link intelligentMobility.Link_Following_Backward#getLink_following <em>Link following</em>}</li>
 *   <li>{@link intelligentMobility.Link_Following_Backward#getLink_backward <em>Link backward</em>}</li>
 * </ul>
 *
 * @see intelligentMobility.IntelligentMobilityPackage#getLink_Following_Backward()
 * @model
 * @generated
 */
public interface Link_Following_Backward extends EObject {
	/**
	 * Returns the value of the '<em><b>Name link following backward</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name link following backward</em>' attribute.
	 * @see #setName_link_following_backward(String)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_Following_Backward_Name_link_following_backward()
	 * @model
	 * @generated
	 */
	String getName_link_following_backward();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_Following_Backward#getName_link_following_backward <em>Name link following backward</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name link following backward</em>' attribute.
	 * @see #getName_link_following_backward()
	 * @generated
	 */
	void setName_link_following_backward(String value);

	/**
	 * Returns the value of the '<em><b>Link following</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link following</em>' reference.
	 * @see #setLink_following(Following)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_Following_Backward_Link_following()
	 * @model
	 * @generated
	 */
	Following getLink_following();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_Following_Backward#getLink_following <em>Link following</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link following</em>' reference.
	 * @see #getLink_following()
	 * @generated
	 */
	void setLink_following(Following value);

	/**
	 * Returns the value of the '<em><b>Link backward</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link backward</em>' reference.
	 * @see #setLink_backward(Backward)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_Following_Backward_Link_backward()
	 * @model
	 * @generated
	 */
	Backward getLink_backward();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_Following_Backward#getLink_backward <em>Link backward</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link backward</em>' reference.
	 * @see #getLink_backward()
	 * @generated
	 */
	void setLink_backward(Backward value);

} // Link_Following_Backward
