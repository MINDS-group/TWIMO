/**
 */
package intelligentMobility;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link Intersection Traffic Light</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.Link_Intersection_TrafficLight#getName_link_intersection_trafficLight <em>Name link intersection traffic Light</em>}</li>
 *   <li>{@link intelligentMobility.Link_Intersection_TrafficLight#getLink_intersection <em>Link intersection</em>}</li>
 *   <li>{@link intelligentMobility.Link_Intersection_TrafficLight#getLink_trafficLight <em>Link traffic Light</em>}</li>
 * </ul>
 *
 * @see intelligentMobility.IntelligentMobilityPackage#getLink_Intersection_TrafficLight()
 * @model
 * @generated
 */
public interface Link_Intersection_TrafficLight extends EObject {
	/**
	 * Returns the value of the '<em><b>Name link intersection traffic Light</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name link intersection traffic Light</em>' attribute.
	 * @see #setName_link_intersection_trafficLight(String)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_Intersection_TrafficLight_Name_link_intersection_trafficLight()
	 * @model
	 * @generated
	 */
	String getName_link_intersection_trafficLight();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_Intersection_TrafficLight#getName_link_intersection_trafficLight <em>Name link intersection traffic Light</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name link intersection traffic Light</em>' attribute.
	 * @see #getName_link_intersection_trafficLight()
	 * @generated
	 */
	void setName_link_intersection_trafficLight(String value);

	/**
	 * Returns the value of the '<em><b>Link intersection</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link intersection</em>' reference.
	 * @see #setLink_intersection(Intersection)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_Intersection_TrafficLight_Link_intersection()
	 * @model
	 * @generated
	 */
	Intersection getLink_intersection();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_Intersection_TrafficLight#getLink_intersection <em>Link intersection</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link intersection</em>' reference.
	 * @see #getLink_intersection()
	 * @generated
	 */
	void setLink_intersection(Intersection value);

	/**
	 * Returns the value of the '<em><b>Link traffic Light</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link traffic Light</em>' reference.
	 * @see #setLink_trafficLight(Traffic_Light)
	 * @see intelligentMobility.IntelligentMobilityPackage#getLink_Intersection_TrafficLight_Link_trafficLight()
	 * @model
	 * @generated
	 */
	Traffic_Light getLink_trafficLight();

	/**
	 * Sets the value of the '{@link intelligentMobility.Link_Intersection_TrafficLight#getLink_trafficLight <em>Link traffic Light</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link traffic Light</em>' reference.
	 * @see #getLink_trafficLight()
	 * @generated
	 */
	void setLink_trafficLight(Traffic_Light value);

} // Link_Intersection_TrafficLight
