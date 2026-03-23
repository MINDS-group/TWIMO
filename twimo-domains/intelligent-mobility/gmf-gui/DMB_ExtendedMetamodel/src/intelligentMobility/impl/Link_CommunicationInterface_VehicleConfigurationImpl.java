/**
 */
package intelligentMobility.impl;

import intelligentMobility.CommunicationInterface;
import intelligentMobility.IntelligentMobilityPackage;
import intelligentMobility.Link_CommunicationInterface_VehicleConfiguration;
import intelligentMobility.Vehicle_Configuration;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Link Communication Interface Vehicle Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.impl.Link_CommunicationInterface_VehicleConfigurationImpl#getName_link_communication_interface_vehicleConfiguration <em>Name link communication interface vehicle Configuration</em>}</li>
 *   <li>{@link intelligentMobility.impl.Link_CommunicationInterface_VehicleConfigurationImpl#getLink_communication_interface <em>Link communication interface</em>}</li>
 *   <li>{@link intelligentMobility.impl.Link_CommunicationInterface_VehicleConfigurationImpl#getLink_vehicle_configuration <em>Link vehicle configuration</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Link_CommunicationInterface_VehicleConfigurationImpl extends MinimalEObjectImpl.Container implements Link_CommunicationInterface_VehicleConfiguration {
	/**
	 * The default value of the '{@link #getName_link_communication_interface_vehicleConfiguration() <em>Name link communication interface vehicle Configuration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName_link_communication_interface_vehicleConfiguration()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_LINK_COMMUNICATION_INTERFACE_VEHICLE_CONFIGURATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName_link_communication_interface_vehicleConfiguration() <em>Name link communication interface vehicle Configuration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName_link_communication_interface_vehicleConfiguration()
	 * @generated
	 * @ordered
	 */
	protected String name_link_communication_interface_vehicleConfiguration = NAME_LINK_COMMUNICATION_INTERFACE_VEHICLE_CONFIGURATION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getLink_communication_interface() <em>Link communication interface</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_communication_interface()
	 * @generated
	 * @ordered
	 */
	protected CommunicationInterface link_communication_interface;

	/**
	 * The cached value of the '{@link #getLink_vehicle_configuration() <em>Link vehicle configuration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_vehicle_configuration()
	 * @generated
	 * @ordered
	 */
	protected Vehicle_Configuration link_vehicle_configuration;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Link_CommunicationInterface_VehicleConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return IntelligentMobilityPackage.eINSTANCE.getLink_CommunicationInterface_VehicleConfiguration();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName_link_communication_interface_vehicleConfiguration() {
		return name_link_communication_interface_vehicleConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName_link_communication_interface_vehicleConfiguration(String newName_link_communication_interface_vehicleConfiguration) {
		String oldName_link_communication_interface_vehicleConfiguration = name_link_communication_interface_vehicleConfiguration;
		name_link_communication_interface_vehicleConfiguration = newName_link_communication_interface_vehicleConfiguration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_COMMUNICATION_INTERFACE_VEHICLE_CONFIGURATION__NAME_LINK_COMMUNICATION_INTERFACE_VEHICLE_CONFIGURATION, oldName_link_communication_interface_vehicleConfiguration, name_link_communication_interface_vehicleConfiguration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CommunicationInterface getLink_communication_interface() {
		if (link_communication_interface != null && link_communication_interface.eIsProxy()) {
			InternalEObject oldLink_communication_interface = (InternalEObject)link_communication_interface;
			link_communication_interface = (CommunicationInterface)eResolveProxy(oldLink_communication_interface);
			if (link_communication_interface != oldLink_communication_interface) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LINK_COMMUNICATION_INTERFACE_VEHICLE_CONFIGURATION__LINK_COMMUNICATION_INTERFACE, oldLink_communication_interface, link_communication_interface));
			}
		}
		return link_communication_interface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CommunicationInterface basicGetLink_communication_interface() {
		return link_communication_interface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLink_communication_interface(CommunicationInterface newLink_communication_interface) {
		CommunicationInterface oldLink_communication_interface = link_communication_interface;
		link_communication_interface = newLink_communication_interface;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_COMMUNICATION_INTERFACE_VEHICLE_CONFIGURATION__LINK_COMMUNICATION_INTERFACE, oldLink_communication_interface, link_communication_interface));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Vehicle_Configuration getLink_vehicle_configuration() {
		if (link_vehicle_configuration != null && link_vehicle_configuration.eIsProxy()) {
			InternalEObject oldLink_vehicle_configuration = (InternalEObject)link_vehicle_configuration;
			link_vehicle_configuration = (Vehicle_Configuration)eResolveProxy(oldLink_vehicle_configuration);
			if (link_vehicle_configuration != oldLink_vehicle_configuration) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LINK_COMMUNICATION_INTERFACE_VEHICLE_CONFIGURATION__LINK_VEHICLE_CONFIGURATION, oldLink_vehicle_configuration, link_vehicle_configuration));
			}
		}
		return link_vehicle_configuration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Vehicle_Configuration basicGetLink_vehicle_configuration() {
		return link_vehicle_configuration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLink_vehicle_configuration(Vehicle_Configuration newLink_vehicle_configuration) {
		Vehicle_Configuration oldLink_vehicle_configuration = link_vehicle_configuration;
		link_vehicle_configuration = newLink_vehicle_configuration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_COMMUNICATION_INTERFACE_VEHICLE_CONFIGURATION__LINK_VEHICLE_CONFIGURATION, oldLink_vehicle_configuration, link_vehicle_configuration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IntelligentMobilityPackage.LINK_COMMUNICATION_INTERFACE_VEHICLE_CONFIGURATION__NAME_LINK_COMMUNICATION_INTERFACE_VEHICLE_CONFIGURATION:
				return getName_link_communication_interface_vehicleConfiguration();
			case IntelligentMobilityPackage.LINK_COMMUNICATION_INTERFACE_VEHICLE_CONFIGURATION__LINK_COMMUNICATION_INTERFACE:
				if (resolve) return getLink_communication_interface();
				return basicGetLink_communication_interface();
			case IntelligentMobilityPackage.LINK_COMMUNICATION_INTERFACE_VEHICLE_CONFIGURATION__LINK_VEHICLE_CONFIGURATION:
				if (resolve) return getLink_vehicle_configuration();
				return basicGetLink_vehicle_configuration();
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
			case IntelligentMobilityPackage.LINK_COMMUNICATION_INTERFACE_VEHICLE_CONFIGURATION__NAME_LINK_COMMUNICATION_INTERFACE_VEHICLE_CONFIGURATION:
				setName_link_communication_interface_vehicleConfiguration((String)newValue);
				return;
			case IntelligentMobilityPackage.LINK_COMMUNICATION_INTERFACE_VEHICLE_CONFIGURATION__LINK_COMMUNICATION_INTERFACE:
				setLink_communication_interface((CommunicationInterface)newValue);
				return;
			case IntelligentMobilityPackage.LINK_COMMUNICATION_INTERFACE_VEHICLE_CONFIGURATION__LINK_VEHICLE_CONFIGURATION:
				setLink_vehicle_configuration((Vehicle_Configuration)newValue);
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
			case IntelligentMobilityPackage.LINK_COMMUNICATION_INTERFACE_VEHICLE_CONFIGURATION__NAME_LINK_COMMUNICATION_INTERFACE_VEHICLE_CONFIGURATION:
				setName_link_communication_interface_vehicleConfiguration(NAME_LINK_COMMUNICATION_INTERFACE_VEHICLE_CONFIGURATION_EDEFAULT);
				return;
			case IntelligentMobilityPackage.LINK_COMMUNICATION_INTERFACE_VEHICLE_CONFIGURATION__LINK_COMMUNICATION_INTERFACE:
				setLink_communication_interface((CommunicationInterface)null);
				return;
			case IntelligentMobilityPackage.LINK_COMMUNICATION_INTERFACE_VEHICLE_CONFIGURATION__LINK_VEHICLE_CONFIGURATION:
				setLink_vehicle_configuration((Vehicle_Configuration)null);
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
			case IntelligentMobilityPackage.LINK_COMMUNICATION_INTERFACE_VEHICLE_CONFIGURATION__NAME_LINK_COMMUNICATION_INTERFACE_VEHICLE_CONFIGURATION:
				return NAME_LINK_COMMUNICATION_INTERFACE_VEHICLE_CONFIGURATION_EDEFAULT == null ? name_link_communication_interface_vehicleConfiguration != null : !NAME_LINK_COMMUNICATION_INTERFACE_VEHICLE_CONFIGURATION_EDEFAULT.equals(name_link_communication_interface_vehicleConfiguration);
			case IntelligentMobilityPackage.LINK_COMMUNICATION_INTERFACE_VEHICLE_CONFIGURATION__LINK_COMMUNICATION_INTERFACE:
				return link_communication_interface != null;
			case IntelligentMobilityPackage.LINK_COMMUNICATION_INTERFACE_VEHICLE_CONFIGURATION__LINK_VEHICLE_CONFIGURATION:
				return link_vehicle_configuration != null;
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
		result.append(" (name_link_communication_interface_vehicleConfiguration: ");
		result.append(name_link_communication_interface_vehicleConfiguration);
		result.append(')');
		return result.toString();
	}

} //Link_CommunicationInterface_VehicleConfigurationImpl
