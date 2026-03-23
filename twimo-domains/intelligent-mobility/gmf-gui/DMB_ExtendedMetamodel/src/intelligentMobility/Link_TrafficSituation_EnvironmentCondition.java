/**
 */
package intelligentMobility;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link Traffic Situation Environment Condition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.Link_TrafficSituation_EnvironmentCondition#getName_link_trafficSituation_environmentCondition <em>Name link traffic Situation environment Condition</em>}</li>
 *   <li>{@link intelligentMobility.Link_TrafficSituation_EnvironmentCondition#getLink_trafficSituation <em>Link traffic Situation</em>}</li>
 *   <li>{@link intelligentMobility.Link_TrafficSituation_EnvironmentCondition#getLink_environmentCondition <em>Link environment Condition</em>}</li>
 * </ul>
 *
 * @see intelligentMobility.IntelligentMobilityPackage#getLink_TrafficSituation_EnvironmentCondition()
 * @model
 * @generated
 */
public interface Link_TrafficSituation_EnvironmentCondition extends EObject {
	/**
	 * Returns the value of the '<em><b>Name link traffic Situation environment Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name link traffic Situation environment Condition</em>' attribute.
	 * @see #setName_link_trafficSituation_environmentCondition(String)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_TrafficSituation_EnvironmentCondition_Name_link_trafficSituation_environmentCondition()
	 * @model
	 * @generated
	 */
	String getName_link_trafficSituation_environmentCondition();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_TrafficSituation_EnvironmentCondition#getName_link_trafficSituation_environmentCondition <em>Name link traffic Situation environment Condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name link traffic Situation environment Condition</em>' attribute.
	 * @see #getName_link_trafficSituation_environmentCondition()
	 * @generated
	 */
	void setName_link_trafficSituation_environmentCondition(String value);

	/**
	 * Returns the value of the '<em><b>Link traffic Situation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link traffic Situation</em>' reference.
	 * @see #setLink_trafficSituation(Traffic_Situation)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_TrafficSituation_EnvironmentCondition_Link_trafficSituation()
	 * @model
	 * @generated
	 */
	Traffic_Situation getLink_trafficSituation();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_TrafficSituation_EnvironmentCondition#getLink_trafficSituation <em>Link traffic Situation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link traffic Situation</em>' reference.
	 * @see #getLink_trafficSituation()
	 * @generated
	 */
	void setLink_trafficSituation(Traffic_Situation value);

	/**
	 * Returns the value of the '<em><b>Link environment Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link environment Condition</em>' reference.
	 * @see #setLink_environmentCondition(Environment_Condition)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_TrafficSituation_EnvironmentCondition_Link_environmentCondition()
	 * @model
	 * @generated
	 */
	Environment_Condition getLink_environmentCondition();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_TrafficSituation_EnvironmentCondition#getLink_environmentCondition <em>Link environment Condition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link environment Condition</em>' reference.
	 * @see #getLink_environmentCondition()
	 * @generated
	 */
	void setLink_environmentCondition(Environment_Condition value);

} // Link_TrafficSituation_EnvironmentCondition
