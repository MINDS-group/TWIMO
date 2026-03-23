/**
 */
package intelligentMobility;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Infrastructure</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.Infrastructure#getCommunicatesWith <em>Communicates With</em>}</li>
 * </ul>
 *
 * @see intelligentMobility.IntelligentMobilityPackage#getInfrastructure()
 * @model abstract="true"
 * @generated
 */
public interface Infrastructure extends EObject {
	/**
	 * Returns the value of the '<em><b>Communicates With</b></em>' reference list.
	 * The list contents are of type {@link intelligentMobility.Vehicle_Configuration}.
	 * It is bidirectional and its opposite is '{@link intelligentMobility.Vehicle_Configuration#getConnectedInfrastructure <em>Connected Infrastructure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Communicates With</em>' reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getInfrastructure_CommunicatesWith()
	 * @see intelligentMobility.Vehicle_Configuration#getConnectedInfrastructure
	 * @model type="intelligentMobility.Vehicle_Configuration" opposite="connectedInfrastructure" required="true"
	 * @generated
	 */
	EList getCommunicatesWith();

} // Infrastructure
