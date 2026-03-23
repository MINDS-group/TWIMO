/**
 */
package intelligentMobility;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collision</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.Collision#getRecoveryTime <em>Recovery Time</em>}</li>
 *   <li>{@link intelligentMobility.Collision#getName <em>Name</em>}</li>
 *   <li>{@link intelligentMobility.Collision#getObstructions <em>Obstructions</em>}</li>
 * </ul>
 *
 * @see intelligentMobility.IntelligentMobilityPackage#getCollision()
 * @model
 * @generated
 */
public interface Collision extends ExceptionCondition {
	/**
	 * Returns the value of the '<em><b>Recovery Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Recovery Time</em>' attribute.
	 * @see #setRecoveryTime(int)
	 * @see intelligentMobility.IntelligentMobilityPackage#getCollision_RecoveryTime()
	 * @model
	 * @generated
	 */
	int getRecoveryTime();

	/**
	 * Sets the value of the '{@link intelligentMobility.Collision#getRecoveryTime <em>Recovery Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Recovery Time</em>' attribute.
	 * @see #getRecoveryTime()
	 * @generated
	 */
	void setRecoveryTime(int value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see intelligentMobility.IntelligentMobilityPackage#getCollision_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link intelligentMobility.Collision#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Obstructions</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Obstruction}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Obstructions</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getCollision_Obstructions()
	 * @model type="intelligentMobility.Obstruction" containment="true"
	 * @generated
	 */
	EList getObstructions();

} // Collision
