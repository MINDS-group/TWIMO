/**
 */
package intelligentMobility.impl;

import intelligentMobility.Infrastructure;
import intelligentMobility.IntelligentMobilityPackage;
import intelligentMobility.Link_Infrastructure_VehicleConfiguration;
import intelligentMobility.Vehicle_Configuration;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Link Infrastructure Vehicle Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.impl.Link_Infrastructure_VehicleConfigurationImpl#getName_link_infrastructure_vehicleConfiguration <em>Name link infrastructure vehicle Configuration</em>}</li>
 *   <li>{@link intelligentMobility.impl.Link_Infrastructure_VehicleConfigurationImpl#getLink_infrastructure <em>Link infrastructure</em>}</li>
 *   <li>{@link intelligentMobility.impl.Link_Infrastructure_VehicleConfigurationImpl#getLink_vehicle_configuration <em>Link vehicle configuration</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Link_Infrastructure_VehicleConfigurationImpl extends MinimalEObjectImpl.Container implements Link_Infrastructure_VehicleConfiguration {
	/**
	 * The default value of the '{@link #getName_link_infrastructure_vehicleConfiguration() <em>Name link infrastructure vehicle Configuration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName_link_infrastructure_vehicleConfiguration()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_LINK_INFRASTRUCTURE_VEHICLE_CONFIGURATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName_link_infrastructure_vehicleConfiguration() <em>Name link infrastructure vehicle Configuration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName_link_infrastructure_vehicleConfiguration()
	 * @generated
	 * @ordered
	 */
	protected String name_link_infrastructure_vehicleConfiguration = NAME_LINK_INFRASTRUCTURE_VEHICLE_CONFIGURATION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getLink_infrastructure() <em>Link infrastructure</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_infrastructure()
	 * @generated
	 * @ordered
	 */
	protected Infrastructure link_infrastructure;

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
	protected Link_Infrastructure_VehicleConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return IntelligentMobilityPackage.eINSTANCE.getLink_Infrastructure_VehicleConfiguration();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName_link_infrastructure_vehicleConfiguration() {
		return name_link_infrastructure_vehicleConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName_link_infrastructure_vehicleConfiguration(String newName_link_infrastructure_vehicleConfiguration) {
		String oldName_link_infrastructure_vehicleConfiguration = name_link_infrastructure_vehicleConfiguration;
		name_link_infrastructure_vehicleConfiguration = newName_link_infrastructure_vehicleConfiguration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_INFRASTRUCTURE_VEHICLE_CONFIGURATION__NAME_LINK_INFRASTRUCTURE_VEHICLE_CONFIGURATION, oldName_link_infrastructure_vehicleConfiguration, name_link_infrastructure_vehicleConfiguration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Infrastructure getLink_infrastructure() {
		if (link_infrastructure != null && link_infrastructure.eIsProxy()) {
			InternalEObject oldLink_infrastructure = (InternalEObject)link_infrastructure;
			link_infrastructure = (Infrastructure)eResolveProxy(oldLink_infrastructure);
			if (link_infrastructure != oldLink_infrastructure) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LINK_INFRASTRUCTURE_VEHICLE_CONFIGURATION__LINK_INFRASTRUCTURE, oldLink_infrastructure, link_infrastructure));
			}
		}
		return link_infrastructure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Infrastructure basicGetLink_infrastructure() {
		return link_infrastructure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLink_infrastructure(Infrastructure newLink_infrastructure) {
		Infrastructure oldLink_infrastructure = link_infrastructure;
		link_infrastructure = newLink_infrastructure;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_INFRASTRUCTURE_VEHICLE_CONFIGURATION__LINK_INFRASTRUCTURE, oldLink_infrastructure, link_infrastructure));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LINK_INFRASTRUCTURE_VEHICLE_CONFIGURATION__LINK_VEHICLE_CONFIGURATION, oldLink_vehicle_configuration, link_vehicle_configuration));
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
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_INFRASTRUCTURE_VEHICLE_CONFIGURATION__LINK_VEHICLE_CONFIGURATION, oldLink_vehicle_configuration, link_vehicle_configuration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IntelligentMobilityPackage.LINK_INFRASTRUCTURE_VEHICLE_CONFIGURATION__NAME_LINK_INFRASTRUCTURE_VEHICLE_CONFIGURATION:
				return getName_link_infrastructure_vehicleConfiguration();
			case IntelligentMobilityPackage.LINK_INFRASTRUCTURE_VEHICLE_CONFIGURATION__LINK_INFRASTRUCTURE:
				if (resolve) return getLink_infrastructure();
				return basicGetLink_infrastructure();
			case IntelligentMobilityPackage.LINK_INFRASTRUCTURE_VEHICLE_CONFIGURATION__LINK_VEHICLE_CONFIGURATION:
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
			case IntelligentMobilityPackage.LINK_INFRASTRUCTURE_VEHICLE_CONFIGURATION__NAME_LINK_INFRASTRUCTURE_VEHICLE_CONFIGURATION:
				setName_link_infrastructure_vehicleConfiguration((String)newValue);
				return;
			case IntelligentMobilityPackage.LINK_INFRASTRUCTURE_VEHICLE_CONFIGURATION__LINK_INFRASTRUCTURE:
				setLink_infrastructure((Infrastructure)newValue);
				return;
			case IntelligentMobilityPackage.LINK_INFRASTRUCTURE_VEHICLE_CONFIGURATION__LINK_VEHICLE_CONFIGURATION:
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
			case IntelligentMobilityPackage.LINK_INFRASTRUCTURE_VEHICLE_CONFIGURATION__NAME_LINK_INFRASTRUCTURE_VEHICLE_CONFIGURATION:
				setName_link_infrastructure_vehicleConfiguration(NAME_LINK_INFRASTRUCTURE_VEHICLE_CONFIGURATION_EDEFAULT);
				return;
			case IntelligentMobilityPackage.LINK_INFRASTRUCTURE_VEHICLE_CONFIGURATION__LINK_INFRASTRUCTURE:
				setLink_infrastructure((Infrastructure)null);
				return;
			case IntelligentMobilityPackage.LINK_INFRASTRUCTURE_VEHICLE_CONFIGURATION__LINK_VEHICLE_CONFIGURATION:
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
			case IntelligentMobilityPackage.LINK_INFRASTRUCTURE_VEHICLE_CONFIGURATION__NAME_LINK_INFRASTRUCTURE_VEHICLE_CONFIGURATION:
				return NAME_LINK_INFRASTRUCTURE_VEHICLE_CONFIGURATION_EDEFAULT == null ? name_link_infrastructure_vehicleConfiguration != null : !NAME_LINK_INFRASTRUCTURE_VEHICLE_CONFIGURATION_EDEFAULT.equals(name_link_infrastructure_vehicleConfiguration);
			case IntelligentMobilityPackage.LINK_INFRASTRUCTURE_VEHICLE_CONFIGURATION__LINK_INFRASTRUCTURE:
				return link_infrastructure != null;
			case IntelligentMobilityPackage.LINK_INFRASTRUCTURE_VEHICLE_CONFIGURATION__LINK_VEHICLE_CONFIGURATION:
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
		result.append(" (name_link_infrastructure_vehicleConfiguration: ");
		result.append(name_link_infrastructure_vehicleConfiguration);
		result.append(')');
		return result.toString();
	}

} //Link_Infrastructure_VehicleConfigurationImpl
