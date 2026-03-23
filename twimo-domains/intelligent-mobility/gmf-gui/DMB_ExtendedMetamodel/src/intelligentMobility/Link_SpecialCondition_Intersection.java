/**
 */
package intelligentMobility;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link Special Condition Intersection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.Link_SpecialCondition_Intersection#getName_link_specialCondition_intersection <em>Name link special Condition intersection</em>}</li>
 *   <li>{@link intelligentMobility.Link_SpecialCondition_Intersection#getLink_specialCondition <em>Link special Condition</em>}</li>
 *   <li>{@link intelligentMobility.Link_SpecialCondition_Intersection#getLink_intersection <em>Link intersection</em>}</li>
 * </ul>
 *
 * @see intelligentMobility.IntelligentMobilityPackage#getLink_SpecialCondition_Intersection()
 * @model
 * @generated
 */
public interface Link_SpecialCondition_Intersection extends EObject {
	/**
	 * Returns the value of the '<em><b>Name link special Condition intersection</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name link special Condition intersection</em>' attribute.
	 * @see #setName_link_specialCondition_intersection(String)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_SpecialCondition_Intersection_Name_link_specialCondition_intersection()
	 * @model
	 * @generated
	 */
	String getName_link_specialCondition_intersection();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_SpecialCondition_Intersection#getName_link_specialCondition_intersection <em>Name link special Condition intersection</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name link special Condition intersection</em>' attribute.
	 * @see #getName_link_specialCondition_intersection()
	 * @generated
	 */
	void setName_link_specialCondition_intersection(String value);

	/**
	 * Returns the value of the '<em><b>Link special Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link special Condition</em>' reference.
	 * @see #setLink_specialCondition(Special_Condition)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_SpecialCondition_Intersection_Link_specialCondition()
	 * @model
	 * @generated
	 */
	Special_Condition getLink_specialCondition();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_SpecialCondition_Intersection#getLink_specialCondition <em>Link special Condition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link special Condition</em>' reference.
	 * @see #getLink_specialCondition()
	 * @generated
	 */
	void setLink_specialCondition(Special_Condition value);

	/**
	 * Returns the value of the '<em><b>Link intersection</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link intersection</em>' reference.
	 * @see #setLink_intersection(Intersection)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_SpecialCondition_Intersection_Link_intersection()
	 * @model
	 * @generated
	 */
	Intersection getLink_intersection();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_SpecialCondition_Intersection#getLink_intersection <em>Link intersection</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link intersection</em>' reference.
	 * @see #getLink_intersection()
	 * @generated
	 */
	void setLink_intersection(Intersection value);

} // Link_SpecialCondition_Intersection
