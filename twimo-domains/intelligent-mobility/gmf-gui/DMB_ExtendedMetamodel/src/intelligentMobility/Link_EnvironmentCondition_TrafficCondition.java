/**
 */
package intelligentMobility;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link Environment Condition Traffic Condition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.Link_EnvironmentCondition_TrafficCondition#getName_link_environmentCondition_trafficCondition <em>Name link environment Condition traffic Condition</em>}</li>
 *   <li>{@link intelligentMobility.Link_EnvironmentCondition_TrafficCondition#getLink_environmentCondition <em>Link environment Condition</em>}</li>
 *   <li>{@link intelligentMobility.Link_EnvironmentCondition_TrafficCondition#getLink_trafficCondition <em>Link traffic Condition</em>}</li>
 * </ul>
 *
 * @see intelligentMobility.IntelligentMobilityPackage#getLink_EnvironmentCondition_TrafficCondition()
 * @model
 * @generated
 */
public interface Link_EnvironmentCondition_TrafficCondition extends EObject {
	/**
	 * Returns the value of the '<em><b>Name link environment Condition traffic Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name link environment Condition traffic Condition</em>' attribute.
	 * @see #setName_link_environmentCondition_trafficCondition(String)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_EnvironmentCondition_TrafficCondition_Name_link_environmentCondition_trafficCondition()
	 * @model
	 * @generated
	 */
	String getName_link_environmentCondition_trafficCondition();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_EnvironmentCondition_TrafficCondition#getName_link_environmentCondition_trafficCondition <em>Name link environment Condition traffic Condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name link environment Condition traffic Condition</em>' attribute.
	 * @see #getName_link_environmentCondition_trafficCondition()
	 * @generated
	 */
	void setName_link_environmentCondition_trafficCondition(String value);

	/**
	 * Returns the value of the '<em><b>Link environment Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link environment Condition</em>' reference.
	 * @see #setLink_environmentCondition(Environment_Condition)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_EnvironmentCondition_TrafficCondition_Link_environmentCondition()
	 * @model
	 * @generated
	 */
	Environment_Condition getLink_environmentCondition();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_EnvironmentCondition_TrafficCondition#getLink_environmentCondition <em>Link environment Condition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link environment Condition</em>' reference.
	 * @see #getLink_environmentCondition()
	 * @generated
	 */
	void setLink_environmentCondition(Environment_Condition value);

	/**
	 * Returns the value of the '<em><b>Link traffic Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link traffic Condition</em>' reference.
	 * @see #setLink_trafficCondition(Traffic_Situation)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_EnvironmentCondition_TrafficCondition_Link_trafficCondition()
	 * @model
	 * @generated
	 */
	Traffic_Situation getLink_trafficCondition();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_EnvironmentCondition_TrafficCondition#getLink_trafficCondition <em>Link traffic Condition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link traffic Condition</em>' reference.
	 * @see #getLink_trafficCondition()
	 * @generated
	 */
	void setLink_trafficCondition(Traffic_Situation value);

} // Link_EnvironmentCondition_TrafficCondition
