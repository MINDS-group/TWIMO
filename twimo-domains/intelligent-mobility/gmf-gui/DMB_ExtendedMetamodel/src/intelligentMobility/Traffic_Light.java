/**
 */
package intelligentMobility;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Traffic Light</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.Traffic_Light#getEnforces <em>Enforces</em>}</li>
 *   <li>{@link intelligentMobility.Traffic_Light#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see intelligentMobility.IntelligentMobilityPackage#getTraffic_Light()
 * @model
 * @generated
 */
public interface Traffic_Light extends Infrastructure {
	/**
	 * Returns the value of the '<em><b>Enforces</b></em>' reference list.
	 * The list contents are of type {@link intelligentMobility.Traffic_Situation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enforces</em>' reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getTraffic_Light_Enforces()
	 * @model type="intelligentMobility.Traffic_Situation" required="true"
	 * @generated
	 */
	EList getEnforces();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see intelligentMobility.IntelligentMobilityPackage#getTraffic_Light_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link intelligentMobility.Traffic_Light#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // Traffic_Light
