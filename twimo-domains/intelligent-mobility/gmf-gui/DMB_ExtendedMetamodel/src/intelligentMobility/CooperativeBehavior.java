/**
 */
package intelligentMobility;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cooperative Behavior</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.CooperativeBehavior#getDependsOn <em>Depends On</em>}</li>
 *   <li>{@link intelligentMobility.CooperativeBehavior#getCoordinatedWith <em>Coordinated With</em>}</li>
 * </ul>
 *
 * @see intelligentMobility.IntelligentMobilityPackage#getCooperativeBehavior()
 * @model
 * @generated
 */
public interface CooperativeBehavior extends Driving_Behaviour {
	/**
	 * Returns the value of the '<em><b>Depends On</b></em>' reference list.
	 * The list contents are of type {@link intelligentMobility.CommunicationInterface}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Depends On</em>' reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getCooperativeBehavior_DependsOn()
	 * @model type="intelligentMobility.CommunicationInterface" required="true"
	 * @generated
	 */
	EList getDependsOn();

	/**
	 * Returns the value of the '<em><b>Coordinated With</b></em>' reference list.
	 * The list contents are of type {@link intelligentMobility.Vehicle_Configuration}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Coordinated With</em>' reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getCooperativeBehavior_CoordinatedWith()
	 * @model type="intelligentMobility.Vehicle_Configuration" required="true"
	 * @generated
	 */
	EList getCoordinatedWith();

} // CooperativeBehavior
