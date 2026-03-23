/**
 */
package intelligentMobility.impl;

import intelligentMobility.CommunicationInterface;
import intelligentMobility.Infrastructure;
import intelligentMobility.IntelligentMobilityPackage;
import intelligentMobility.ProtocolType;
import intelligentMobility.Vehicle_Configuration;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Communication Interface</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.impl.CommunicationInterfaceImpl#getProtocol <em>Protocol</em>}</li>
 *   <li>{@link intelligentMobility.impl.CommunicationInterfaceImpl#getLatency <em>Latency</em>}</li>
 *   <li>{@link intelligentMobility.impl.CommunicationInterfaceImpl#getBandwidth <em>Bandwidth</em>}</li>
 *   <li>{@link intelligentMobility.impl.CommunicationInterfaceImpl#getReliabilityLevel <em>Reliability Level</em>}</li>
 *   <li>{@link intelligentMobility.impl.CommunicationInterfaceImpl#getConnects_vehicle <em>Connects vehicle</em>}</li>
 *   <li>{@link intelligentMobility.impl.CommunicationInterfaceImpl#getConnects_infrastructure <em>Connects infrastructure</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CommunicationInterfaceImpl extends MinimalEObjectImpl.Container implements CommunicationInterface {
	/**
	 * The default value of the '{@link #getProtocol() <em>Protocol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProtocol()
	 * @generated
	 * @ordered
	 */
	protected static final ProtocolType PROTOCOL_EDEFAULT = ProtocolType.CINQUE_G_LITERAL;

	/**
	 * The cached value of the '{@link #getProtocol() <em>Protocol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProtocol()
	 * @generated
	 * @ordered
	 */
	protected ProtocolType protocol = PROTOCOL_EDEFAULT;

	/**
	 * The default value of the '{@link #getLatency() <em>Latency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLatency()
	 * @generated
	 * @ordered
	 */
	protected static final double LATENCY_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getLatency() <em>Latency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLatency()
	 * @generated
	 * @ordered
	 */
	protected double latency = LATENCY_EDEFAULT;

	/**
	 * The default value of the '{@link #getBandwidth() <em>Bandwidth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBandwidth()
	 * @generated
	 * @ordered
	 */
	protected static final double BANDWIDTH_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getBandwidth() <em>Bandwidth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBandwidth()
	 * @generated
	 * @ordered
	 */
	protected double bandwidth = BANDWIDTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getReliabilityLevel() <em>Reliability Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReliabilityLevel()
	 * @generated
	 * @ordered
	 */
	protected static final double RELIABILITY_LEVEL_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getReliabilityLevel() <em>Reliability Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReliabilityLevel()
	 * @generated
	 * @ordered
	 */
	protected double reliabilityLevel = RELIABILITY_LEVEL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getConnects_vehicle() <em>Connects vehicle</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnects_vehicle()
	 * @generated
	 * @ordered
	 */
	protected EList connects_vehicle;

	/**
	 * The cached value of the '{@link #getConnects_infrastructure() <em>Connects infrastructure</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnects_infrastructure()
	 * @generated
	 * @ordered
	 */
	protected EList connects_infrastructure;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CommunicationInterfaceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return IntelligentMobilityPackage.eINSTANCE.getCommunicationInterface();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProtocolType getProtocol() {
		return protocol;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProtocol(ProtocolType newProtocol) {
		ProtocolType oldProtocol = protocol;
		protocol = newProtocol == null ? PROTOCOL_EDEFAULT : newProtocol;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.COMMUNICATION_INTERFACE__PROTOCOL, oldProtocol, protocol));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getLatency() {
		return latency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLatency(double newLatency) {
		double oldLatency = latency;
		latency = newLatency;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.COMMUNICATION_INTERFACE__LATENCY, oldLatency, latency));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getBandwidth() {
		return bandwidth;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBandwidth(double newBandwidth) {
		double oldBandwidth = bandwidth;
		bandwidth = newBandwidth;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.COMMUNICATION_INTERFACE__BANDWIDTH, oldBandwidth, bandwidth));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getReliabilityLevel() {
		return reliabilityLevel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReliabilityLevel(double newReliabilityLevel) {
		double oldReliabilityLevel = reliabilityLevel;
		reliabilityLevel = newReliabilityLevel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.COMMUNICATION_INTERFACE__RELIABILITY_LEVEL, oldReliabilityLevel, reliabilityLevel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getConnects_vehicle() {
		if (connects_vehicle == null) {
			connects_vehicle = new EObjectResolvingEList(Vehicle_Configuration.class, this, IntelligentMobilityPackage.COMMUNICATION_INTERFACE__CONNECTS_VEHICLE);
		}
		return connects_vehicle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getConnects_infrastructure() {
		if (connects_infrastructure == null) {
			connects_infrastructure = new EObjectResolvingEList(Infrastructure.class, this, IntelligentMobilityPackage.COMMUNICATION_INTERFACE__CONNECTS_INFRASTRUCTURE);
		}
		return connects_infrastructure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IntelligentMobilityPackage.COMMUNICATION_INTERFACE__PROTOCOL:
				return getProtocol();
			case IntelligentMobilityPackage.COMMUNICATION_INTERFACE__LATENCY:
				return new Double(getLatency());
			case IntelligentMobilityPackage.COMMUNICATION_INTERFACE__BANDWIDTH:
				return new Double(getBandwidth());
			case IntelligentMobilityPackage.COMMUNICATION_INTERFACE__RELIABILITY_LEVEL:
				return new Double(getReliabilityLevel());
			case IntelligentMobilityPackage.COMMUNICATION_INTERFACE__CONNECTS_VEHICLE:
				return getConnects_vehicle();
			case IntelligentMobilityPackage.COMMUNICATION_INTERFACE__CONNECTS_INFRASTRUCTURE:
				return getConnects_infrastructure();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case IntelligentMobilityPackage.COMMUNICATION_INTERFACE__PROTOCOL:
				setProtocol((ProtocolType)newValue);
				return;
			case IntelligentMobilityPackage.COMMUNICATION_INTERFACE__LATENCY:
				setLatency(((Double)newValue).doubleValue());
				return;
			case IntelligentMobilityPackage.COMMUNICATION_INTERFACE__BANDWIDTH:
				setBandwidth(((Double)newValue).doubleValue());
				return;
			case IntelligentMobilityPackage.COMMUNICATION_INTERFACE__RELIABILITY_LEVEL:
				setReliabilityLevel(((Double)newValue).doubleValue());
				return;
			case IntelligentMobilityPackage.COMMUNICATION_INTERFACE__CONNECTS_VEHICLE:
				getConnects_vehicle().clear();
				getConnects_vehicle().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.COMMUNICATION_INTERFACE__CONNECTS_INFRASTRUCTURE:
				getConnects_infrastructure().clear();
				getConnects_infrastructure().addAll((Collection)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case IntelligentMobilityPackage.COMMUNICATION_INTERFACE__PROTOCOL:
				setProtocol(PROTOCOL_EDEFAULT);
				return;
			case IntelligentMobilityPackage.COMMUNICATION_INTERFACE__LATENCY:
				setLatency(LATENCY_EDEFAULT);
				return;
			case IntelligentMobilityPackage.COMMUNICATION_INTERFACE__BANDWIDTH:
				setBandwidth(BANDWIDTH_EDEFAULT);
				return;
			case IntelligentMobilityPackage.COMMUNICATION_INTERFACE__RELIABILITY_LEVEL:
				setReliabilityLevel(RELIABILITY_LEVEL_EDEFAULT);
				return;
			case IntelligentMobilityPackage.COMMUNICATION_INTERFACE__CONNECTS_VEHICLE:
				getConnects_vehicle().clear();
				return;
			case IntelligentMobilityPackage.COMMUNICATION_INTERFACE__CONNECTS_INFRASTRUCTURE:
				getConnects_infrastructure().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case IntelligentMobilityPackage.COMMUNICATION_INTERFACE__PROTOCOL:
				return protocol != PROTOCOL_EDEFAULT;
			case IntelligentMobilityPackage.COMMUNICATION_INTERFACE__LATENCY:
				return latency != LATENCY_EDEFAULT;
			case IntelligentMobilityPackage.COMMUNICATION_INTERFACE__BANDWIDTH:
				return bandwidth != BANDWIDTH_EDEFAULT;
			case IntelligentMobilityPackage.COMMUNICATION_INTERFACE__RELIABILITY_LEVEL:
				return reliabilityLevel != RELIABILITY_LEVEL_EDEFAULT;
			case IntelligentMobilityPackage.COMMUNICATION_INTERFACE__CONNECTS_VEHICLE:
				return connects_vehicle != null && !connects_vehicle.isEmpty();
			case IntelligentMobilityPackage.COMMUNICATION_INTERFACE__CONNECTS_INFRASTRUCTURE:
				return connects_infrastructure != null && !connects_infrastructure.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (protocol: ");
		result.append(protocol);
		result.append(", latency: ");
		result.append(latency);
		result.append(", bandwidth: ");
		result.append(bandwidth);
		result.append(", reliabilityLevel: ");
		result.append(reliabilityLevel);
		result.append(')');
		return result.toString();
	}

} //CommunicationInterfaceImpl
