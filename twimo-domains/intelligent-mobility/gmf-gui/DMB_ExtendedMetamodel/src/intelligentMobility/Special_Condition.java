/**
 */
package intelligentMobility;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Special Condition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.Special_Condition#getConditionName <em>Condition Name</em>}</li>
 *   <li>{@link intelligentMobility.Special_Condition#getCollision <em>Collision</em>}</li>
 *   <li>{@link intelligentMobility.Special_Condition#getIntersection <em>Intersection</em>}</li>
 * </ul>
 *
 * @see intelligentMobility.IntelligentMobilityPackage#getSpecial_Condition()
 * @model
 * @generated
 */
public interface Special_Condition extends EObject {
	/**
	 * Returns the value of the '<em><b>Condition Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition Name</em>' attribute.
	 * @see #setConditionName(String)
	 * @see intelligentMobility.IntelligentMobilityPackage#getSpecial_Condition_ConditionName()
	 * @model
	 * @generated
	 */
	String getConditionName();

	/**
	 * Sets the value of the '{@link intelligentMobility.Special_Condition#getConditionName <em>Condition Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition Name</em>' attribute.
	 * @see #getConditionName()
	 * @generated
	 */
	void setConditionName(String value);

	/**
	 * Returns the value of the '<em><b>Collision</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Collision</em>' containment reference.
	 * @see #setCollision(Collision)
	 * @see intelligentMobility.IntelligentMobilityPackage#getSpecial_Condition_Collision()
	 * @model containment="true"
	 * @generated
	 */
	Collision getCollision();

	/**
	 * Sets the value of the '{@link intelligentMobility.Special_Condition#getCollision <em>Collision</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Collision</em>' containment reference.
	 * @see #getCollision()
	 * @generated
	 */
	void setCollision(Collision value);

	/**
	 * Returns the value of the '<em><b>Intersection</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Intersection}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Intersection</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getSpecial_Condition_Intersection()
	 * @model type="intelligentMobility.Intersection" containment="true"
	 * @generated
	 */
	EList getIntersection();

} // Special_Condition
