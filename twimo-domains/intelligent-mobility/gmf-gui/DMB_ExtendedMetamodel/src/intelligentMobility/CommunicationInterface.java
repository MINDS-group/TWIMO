/**
 */
package intelligentMobility;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Communication Interface</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.CommunicationInterface#getProtocol <em>Protocol</em>}</li>
 *   <li>{@link intelligentMobility.CommunicationInterface#getLatency <em>Latency</em>}</li>
 *   <li>{@link intelligentMobility.CommunicationInterface#getBandwidth <em>Bandwidth</em>}</li>
 *   <li>{@link intelligentMobility.CommunicationInterface#getReliabilityLevel <em>Reliability Level</em>}</li>
 *   <li>{@link intelligentMobility.CommunicationInterface#getConnects_vehicle <em>Connects vehicle</em>}</li>
 *   <li>{@link intelligentMobility.CommunicationInterface#getConnects_infrastructure <em>Connects infrastructure</em>}</li>
 * </ul>
 *
 * @see intelligentMobility.IntelligentMobilityPackage#getCommunicationInterface()
 * @model
 * @generated
 */
public interface CommunicationInterface extends EObject {
	/**
	 * Returns the value of the '<em><b>Protocol</b></em>' attribute.
	 * The literals are from the enumeration {@link intelligentMobility.ProtocolType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Protocol</em>' attribute.
	 * @see intelligentMobility.ProtocolType
	 * @see #setProtocol(ProtocolType)
	 * @see intelligentMobility.IntelligentMobilityPackage#getCommunicationInterface_Protocol()
	 * @model
	 * @generated
	 */
	ProtocolType getProtocol();

	/**
	 * Sets the value of the '{@link intelligentMobility.CommunicationInterface#getProtocol <em>Protocol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Protocol</em>' attribute.
	 * @see intelligentMobility.ProtocolType
	 * @see #getProtocol()
	 * @generated
	 */
	void setProtocol(ProtocolType value);

	/**
	 * Returns the value of the '<em><b>Latency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Latency</em>' attribute.
	 * @see #setLatency(double)
	 * @see intelligentMobility.IntelligentMobilityPackage#getCommunicationInterface_Latency()
	 * @model
	 * @generated
	 */
	double getLatency();

	/**
	 * Sets the value of the '{@link intelligentMobility.CommunicationInterface#getLatency <em>Latency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Latency</em>' attribute.
	 * @see #getLatency()
	 * @generated
	 */
	void setLatency(double value);

	/**
	 * Returns the value of the '<em><b>Bandwidth</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bandwidth</em>' attribute.
	 * @see #setBandwidth(double)
	 * @see intelligentMobility.IntelligentMobilityPackage#getCommunicationInterface_Bandwidth()
	 * @model
	 * @generated
	 */
	double getBandwidth();

	/**
	 * Sets the value of the '{@link intelligentMobility.CommunicationInterface#getBandwidth <em>Bandwidth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bandwidth</em>' attribute.
	 * @see #getBandwidth()
	 * @generated
	 */
	void setBandwidth(double value);

	/**
	 * Returns the value of the '<em><b>Reliability Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reliability Level</em>' attribute.
	 * @see #setReliabilityLevel(double)
	 * @see intelligentMobility.IntelligentMobilityPackage#getCommunicationInterface_ReliabilityLevel()
	 * @model
	 * @generated
	 */
	double getReliabilityLevel();

	/**
	 * Sets the value of the '{@link intelligentMobility.CommunicationInterface#getReliabilityLevel <em>Reliability Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reliability Level</em>' attribute.
	 * @see #getReliabilityLevel()
	 * @generated
	 */
	void setReliabilityLevel(double value);

	/**
	 * Returns the value of the '<em><b>Connects vehicle</b></em>' reference list.
	 * The list contents are of type {@link intelligentMobility.Vehicle_Configuration}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connects vehicle</em>' reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getCommunicationInterface_Connects_vehicle()
	 * @model type="intelligentMobility.Vehicle_Configuration" required="true"
	 * @generated
	 */
	EList getConnects_vehicle();

	/**
	 * Returns the value of the '<em><b>Connects infrastructure</b></em>' reference list.
	 * The list contents are of type {@link intelligentMobility.Infrastructure}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connects infrastructure</em>' reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getCommunicationInterface_Connects_infrastructure()
	 * @model type="intelligentMobility.Infrastructure" required="true"
	 * @generated
	 */
	EList getConnects_infrastructure();

} // CommunicationInterface
