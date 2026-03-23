/**
 */
package intelligentMobility.impl;

import intelligentMobility.Driver_Profile;
import intelligentMobility.IntelligentMobilityPackage;
import intelligentMobility.Link_Driver_Vehicle;
import intelligentMobility.Vehicle_Configuration;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Link Driver Vehicle</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.impl.Link_Driver_VehicleImpl#getLink_name_driver_vehicle <em>Link name driver vehicle</em>}</li>
 *   <li>{@link intelligentMobility.impl.Link_Driver_VehicleImpl#getLink_driver_profile <em>Link driver profile</em>}</li>
 *   <li>{@link intelligentMobility.impl.Link_Driver_VehicleImpl#getLink_vehicle_configuration <em>Link vehicle configuration</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Link_Driver_VehicleImpl extends MinimalEObjectImpl.Container implements Link_Driver_Vehicle {
	/**
	 * The default value of the '{@link #getLink_name_driver_vehicle() <em>Link name driver vehicle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_name_driver_vehicle()
	 * @generated
	 * @ordered
	 */
	protected static final String LINK_NAME_DRIVER_VEHICLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLink_name_driver_vehicle() <em>Link name driver vehicle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_name_driver_vehicle()
	 * @generated
	 * @ordered
	 */
	protected String link_name_driver_vehicle = LINK_NAME_DRIVER_VEHICLE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getLink_driver_profile() <em>Link driver profile</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_driver_profile()
	 * @generated
	 * @ordered
	 */
	protected Driver_Profile link_driver_profile;

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
	protected Link_Driver_VehicleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return IntelligentMobilityPackage.eINSTANCE.getLink_Driver_Vehicle();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLink_name_driver_vehicle() {
		return link_name_driver_vehicle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLink_name_driver_vehicle(String newLink_name_driver_vehicle) {
		String oldLink_name_driver_vehicle = link_name_driver_vehicle;
		link_name_driver_vehicle = newLink_name_driver_vehicle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_DRIVER_VEHICLE__LINK_NAME_DRIVER_VEHICLE, oldLink_name_driver_vehicle, link_name_driver_vehicle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Driver_Profile getLink_driver_profile() {
		if (link_driver_profile != null && link_driver_profile.eIsProxy()) {
			InternalEObject oldLink_driver_profile = (InternalEObject)link_driver_profile;
			link_driver_profile = (Driver_Profile)eResolveProxy(oldLink_driver_profile);
			if (link_driver_profile != oldLink_driver_profile) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LINK_DRIVER_VEHICLE__LINK_DRIVER_PROFILE, oldLink_driver_profile, link_driver_profile));
			}
		}
		return link_driver_profile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Driver_Profile basicGetLink_driver_profile() {
		return link_driver_profile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLink_driver_profile(Driver_Profile newLink_driver_profile) {
		Driver_Profile oldLink_driver_profile = link_driver_profile;
		link_driver_profile = newLink_driver_profile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_DRIVER_VEHICLE__LINK_DRIVER_PROFILE, oldLink_driver_profile, link_driver_profile));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LINK_DRIVER_VEHICLE__LINK_VEHICLE_CONFIGURATION, oldLink_vehicle_configuration, link_vehicle_configuration));
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
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_DRIVER_VEHICLE__LINK_VEHICLE_CONFIGURATION, oldLink_vehicle_configuration, link_vehicle_configuration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IntelligentMobilityPackage.LINK_DRIVER_VEHICLE__LINK_NAME_DRIVER_VEHICLE:
				return getLink_name_driver_vehicle();
			case IntelligentMobilityPackage.LINK_DRIVER_VEHICLE__LINK_DRIVER_PROFILE:
				if (resolve) return getLink_driver_profile();
				return basicGetLink_driver_profile();
			case IntelligentMobilityPackage.LINK_DRIVER_VEHICLE__LINK_VEHICLE_CONFIGURATION:
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
			case IntelligentMobilityPackage.LINK_DRIVER_VEHICLE__LINK_NAME_DRIVER_VEHICLE:
				setLink_name_driver_vehicle((String)newValue);
				return;
			case IntelligentMobilityPackage.LINK_DRIVER_VEHICLE__LINK_DRIVER_PROFILE:
				setLink_driver_profile((Driver_Profile)newValue);
				return;
			case IntelligentMobilityPackage.LINK_DRIVER_VEHICLE__LINK_VEHICLE_CONFIGURATION:
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
			case IntelligentMobilityPackage.LINK_DRIVER_VEHICLE__LINK_NAME_DRIVER_VEHICLE:
				setLink_name_driver_vehicle(LINK_NAME_DRIVER_VEHICLE_EDEFAULT);
				return;
			case IntelligentMobilityPackage.LINK_DRIVER_VEHICLE__LINK_DRIVER_PROFILE:
				setLink_driver_profile((Driver_Profile)null);
				return;
			case IntelligentMobilityPackage.LINK_DRIVER_VEHICLE__LINK_VEHICLE_CONFIGURATION:
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
			case IntelligentMobilityPackage.LINK_DRIVER_VEHICLE__LINK_NAME_DRIVER_VEHICLE:
				return LINK_NAME_DRIVER_VEHICLE_EDEFAULT == null ? link_name_driver_vehicle != null : !LINK_NAME_DRIVER_VEHICLE_EDEFAULT.equals(link_name_driver_vehicle);
			case IntelligentMobilityPackage.LINK_DRIVER_VEHICLE__LINK_DRIVER_PROFILE:
				return link_driver_profile != null;
			case IntelligentMobilityPackage.LINK_DRIVER_VEHICLE__LINK_VEHICLE_CONFIGURATION:
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
		result.append(" (link_name_driver_vehicle: ");
		result.append(link_name_driver_vehicle);
		result.append(')');
		return result.toString();
	}

} //Link_Driver_VehicleImpl
