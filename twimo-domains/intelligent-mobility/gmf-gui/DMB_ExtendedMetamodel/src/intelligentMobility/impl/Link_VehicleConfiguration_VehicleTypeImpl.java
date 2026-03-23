/**
 */
package intelligentMobility.impl;

import intelligentMobility.IntelligentMobilityPackage;
import intelligentMobility.Link_VehicleConfiguration_VehicleType;
import intelligentMobility.Vehicle_Configuration;
import intelligentMobility.Vehicle_Type;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Link Vehicle Configuration Vehicle Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.impl.Link_VehicleConfiguration_VehicleTypeImpl#getName_link_configuration_type <em>Name link configuration type</em>}</li>
 *   <li>{@link intelligentMobility.impl.Link_VehicleConfiguration_VehicleTypeImpl#getLink_vehicle_configuration <em>Link vehicle configuration</em>}</li>
 *   <li>{@link intelligentMobility.impl.Link_VehicleConfiguration_VehicleTypeImpl#getLink_vehicle_type <em>Link vehicle type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Link_VehicleConfiguration_VehicleTypeImpl extends MinimalEObjectImpl.Container implements Link_VehicleConfiguration_VehicleType {
	/**
	 * The default value of the '{@link #getName_link_configuration_type() <em>Name link configuration type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName_link_configuration_type()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_LINK_CONFIGURATION_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName_link_configuration_type() <em>Name link configuration type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName_link_configuration_type()
	 * @generated
	 * @ordered
	 */
	protected String name_link_configuration_type = NAME_LINK_CONFIGURATION_TYPE_EDEFAULT;

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
	 * The cached value of the '{@link #getLink_vehicle_type() <em>Link vehicle type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_vehicle_type()
	 * @generated
	 * @ordered
	 */
	protected Vehicle_Type link_vehicle_type;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Link_VehicleConfiguration_VehicleTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return IntelligentMobilityPackage.eINSTANCE.getLink_VehicleConfiguration_VehicleType();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName_link_configuration_type() {
		return name_link_configuration_type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName_link_configuration_type(String newName_link_configuration_type) {
		String oldName_link_configuration_type = name_link_configuration_type;
		name_link_configuration_type = newName_link_configuration_type;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_VEHICLE_CONFIGURATION_VEHICLE_TYPE__NAME_LINK_CONFIGURATION_TYPE, oldName_link_configuration_type, name_link_configuration_type));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LINK_VEHICLE_CONFIGURATION_VEHICLE_TYPE__LINK_VEHICLE_CONFIGURATION, oldLink_vehicle_configuration, link_vehicle_configuration));
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
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_VEHICLE_CONFIGURATION_VEHICLE_TYPE__LINK_VEHICLE_CONFIGURATION, oldLink_vehicle_configuration, link_vehicle_configuration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Vehicle_Type getLink_vehicle_type() {
		if (link_vehicle_type != null && link_vehicle_type.eIsProxy()) {
			InternalEObject oldLink_vehicle_type = (InternalEObject)link_vehicle_type;
			link_vehicle_type = (Vehicle_Type)eResolveProxy(oldLink_vehicle_type);
			if (link_vehicle_type != oldLink_vehicle_type) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LINK_VEHICLE_CONFIGURATION_VEHICLE_TYPE__LINK_VEHICLE_TYPE, oldLink_vehicle_type, link_vehicle_type));
			}
		}
		return link_vehicle_type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Vehicle_Type basicGetLink_vehicle_type() {
		return link_vehicle_type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLink_vehicle_type(Vehicle_Type newLink_vehicle_type) {
		Vehicle_Type oldLink_vehicle_type = link_vehicle_type;
		link_vehicle_type = newLink_vehicle_type;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_VEHICLE_CONFIGURATION_VEHICLE_TYPE__LINK_VEHICLE_TYPE, oldLink_vehicle_type, link_vehicle_type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IntelligentMobilityPackage.LINK_VEHICLE_CONFIGURATION_VEHICLE_TYPE__NAME_LINK_CONFIGURATION_TYPE:
				return getName_link_configuration_type();
			case IntelligentMobilityPackage.LINK_VEHICLE_CONFIGURATION_VEHICLE_TYPE__LINK_VEHICLE_CONFIGURATION:
				if (resolve) return getLink_vehicle_configuration();
				return basicGetLink_vehicle_configuration();
			case IntelligentMobilityPackage.LINK_VEHICLE_CONFIGURATION_VEHICLE_TYPE__LINK_VEHICLE_TYPE:
				if (resolve) return getLink_vehicle_type();
				return basicGetLink_vehicle_type();
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
			case IntelligentMobilityPackage.LINK_VEHICLE_CONFIGURATION_VEHICLE_TYPE__NAME_LINK_CONFIGURATION_TYPE:
				setName_link_configuration_type((String)newValue);
				return;
			case IntelligentMobilityPackage.LINK_VEHICLE_CONFIGURATION_VEHICLE_TYPE__LINK_VEHICLE_CONFIGURATION:
				setLink_vehicle_configuration((Vehicle_Configuration)newValue);
				return;
			case IntelligentMobilityPackage.LINK_VEHICLE_CONFIGURATION_VEHICLE_TYPE__LINK_VEHICLE_TYPE:
				setLink_vehicle_type((Vehicle_Type)newValue);
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
			case IntelligentMobilityPackage.LINK_VEHICLE_CONFIGURATION_VEHICLE_TYPE__NAME_LINK_CONFIGURATION_TYPE:
				setName_link_configuration_type(NAME_LINK_CONFIGURATION_TYPE_EDEFAULT);
				return;
			case IntelligentMobilityPackage.LINK_VEHICLE_CONFIGURATION_VEHICLE_TYPE__LINK_VEHICLE_CONFIGURATION:
				setLink_vehicle_configuration((Vehicle_Configuration)null);
				return;
			case IntelligentMobilityPackage.LINK_VEHICLE_CONFIGURATION_VEHICLE_TYPE__LINK_VEHICLE_TYPE:
				setLink_vehicle_type((Vehicle_Type)null);
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
			case IntelligentMobilityPackage.LINK_VEHICLE_CONFIGURATION_VEHICLE_TYPE__NAME_LINK_CONFIGURATION_TYPE:
				return NAME_LINK_CONFIGURATION_TYPE_EDEFAULT == null ? name_link_configuration_type != null : !NAME_LINK_CONFIGURATION_TYPE_EDEFAULT.equals(name_link_configuration_type);
			case IntelligentMobilityPackage.LINK_VEHICLE_CONFIGURATION_VEHICLE_TYPE__LINK_VEHICLE_CONFIGURATION:
				return link_vehicle_configuration != null;
			case IntelligentMobilityPackage.LINK_VEHICLE_CONFIGURATION_VEHICLE_TYPE__LINK_VEHICLE_TYPE:
				return link_vehicle_type != null;
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
		result.append(" (name_link_configuration_type: ");
		result.append(name_link_configuration_type);
		result.append(')');
		return result.toString();
	}

} //Link_VehicleConfiguration_VehicleTypeImpl
