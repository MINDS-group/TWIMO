/**
 */
package intelligentMobility;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Intersection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.Intersection#getName <em>Name</em>}</li>
 *   <li>{@link intelligentMobility.Intersection#getTraffic_lights <em>Traffic lights</em>}</li>
 *   <li>{@link intelligentMobility.Intersection#getCrossIntersection <em>Cross Intersection</em>}</li>
 *   <li>{@link intelligentMobility.Intersection#getCrossRailway <em>Cross Railway</em>}</li>
 * </ul>
 *
 * @see intelligentMobility.IntelligentMobilityPackage#getIntersection()
 * @model
 * @generated
 */
public interface Intersection extends ExceptionCondition, Infrastructure {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see intelligentMobility.IntelligentMobilityPackage#getIntersection_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link intelligentMobility.Intersection#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Traffic lights</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Traffic_Light}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Traffic lights</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getIntersection_Traffic_lights()
	 * @model type="intelligentMobility.Traffic_Light" containment="true"
	 * @generated
	 */
	EList getTraffic_lights();

	/**
	 * Returns the value of the '<em><b>Cross Intersection</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cross Intersection</em>' attribute.
	 * @see #setCrossIntersection(int)
	 * @see intelligentMobility.IntelligentMobilityPackage#getIntersection_CrossIntersection()
	 * @model
	 * @generated
	 */
	int getCrossIntersection();

	/**
	 * Sets the value of the '{@link intelligentMobility.Intersection#getCrossIntersection <em>Cross Intersection</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cross Intersection</em>' attribute.
	 * @see #getCrossIntersection()
	 * @generated
	 */
	void setCrossIntersection(int value);

	/**
	 * Returns the value of the '<em><b>Cross Railway</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cross Railway</em>' attribute.
	 * @see #setCrossRailway(int)
	 * @see intelligentMobility.IntelligentMobilityPackage#getIntersection_CrossRailway()
	 * @model
	 * @generated
	 */
	int getCrossRailway();

	/**
	 * Sets the value of the '{@link intelligentMobility.Intersection#getCrossRailway <em>Cross Railway</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cross Railway</em>' attribute.
	 * @see #getCrossRailway()
	 * @generated
	 */
	void setCrossRailway(int value);

} // Intersection
