/**
 */
package intelligentMobility.impl;

import intelligentMobility.CooperativeBehavior;
import intelligentMobility.IntelligentMobilityPackage;
import intelligentMobility.Link_CooperativeBehaviour_VehicleConfiguration;
import intelligentMobility.Vehicle_Configuration;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Link Cooperative Behaviour Vehicle Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.impl.Link_CooperativeBehaviour_VehicleConfigurationImpl#getName_link_cooperativeBehaviour_vehicleConfiguration <em>Name link cooperative Behaviour vehicle Configuration</em>}</li>
 *   <li>{@link intelligentMobility.impl.Link_CooperativeBehaviour_VehicleConfigurationImpl#getLink_cooperativeBehaviour <em>Link cooperative Behaviour</em>}</li>
 *   <li>{@link intelligentMobility.impl.Link_CooperativeBehaviour_VehicleConfigurationImpl#getLink_vehicleConfiguration <em>Link vehicle Configuration</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Link_CooperativeBehaviour_VehicleConfigurationImpl extends MinimalEObjectImpl.Container implements Link_CooperativeBehaviour_VehicleConfiguration {
	/**
	 * The default value of the '{@link #getName_link_cooperativeBehaviour_vehicleConfiguration() <em>Name link cooperative Behaviour vehicle Configuration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName_link_cooperativeBehaviour_vehicleConfiguration()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_LINK_COOPERATIVE_BEHAVIOUR_VEHICLE_CONFIGURATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName_link_cooperativeBehaviour_vehicleConfiguration() <em>Name link cooperative Behaviour vehicle Configuration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName_link_cooperativeBehaviour_vehicleConfiguration()
	 * @generated
	 * @ordered
	 */
	protected String name_link_cooperativeBehaviour_vehicleConfiguration = NAME_LINK_COOPERATIVE_BEHAVIOUR_VEHICLE_CONFIGURATION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getLink_cooperativeBehaviour() <em>Link cooperative Behaviour</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_cooperativeBehaviour()
	 * @generated
	 * @ordered
	 */
	protected CooperativeBehavior link_cooperativeBehaviour;

	/**
	 * The cached value of the '{@link #getLink_vehicleConfiguration() <em>Link vehicle Configuration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_vehicleConfiguration()
	 * @generated
	 * @ordered
	 */
	protected Vehicle_Configuration link_vehicleConfiguration;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Link_CooperativeBehaviour_VehicleConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return IntelligentMobilityPackage.eINSTANCE.getLink_CooperativeBehaviour_VehicleConfiguration();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName_link_cooperativeBehaviour_vehicleConfiguration() {
		return name_link_cooperativeBehaviour_vehicleConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName_link_cooperativeBehaviour_vehicleConfiguration(String newName_link_cooperativeBehaviour_vehicleConfiguration) {
		String oldName_link_cooperativeBehaviour_vehicleConfiguration = name_link_cooperativeBehaviour_vehicleConfiguration;
		name_link_cooperativeBehaviour_vehicleConfiguration = newName_link_cooperativeBehaviour_vehicleConfiguration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_COOPERATIVE_BEHAVIOUR_VEHICLE_CONFIGURATION__NAME_LINK_COOPERATIVE_BEHAVIOUR_VEHICLE_CONFIGURATION, oldName_link_cooperativeBehaviour_vehicleConfiguration, name_link_cooperativeBehaviour_vehicleConfiguration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CooperativeBehavior getLink_cooperativeBehaviour() {
		if (link_cooperativeBehaviour != null && link_cooperativeBehaviour.eIsProxy()) {
			InternalEObject oldLink_cooperativeBehaviour = (InternalEObject)link_cooperativeBehaviour;
			link_cooperativeBehaviour = (CooperativeBehavior)eResolveProxy(oldLink_cooperativeBehaviour);
			if (link_cooperativeBehaviour != oldLink_cooperativeBehaviour) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LINK_COOPERATIVE_BEHAVIOUR_VEHICLE_CONFIGURATION__LINK_COOPERATIVE_BEHAVIOUR, oldLink_cooperativeBehaviour, link_cooperativeBehaviour));
			}
		}
		return link_cooperativeBehaviour;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CooperativeBehavior basicGetLink_cooperativeBehaviour() {
		return link_cooperativeBehaviour;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLink_cooperativeBehaviour(CooperativeBehavior newLink_cooperativeBehaviour) {
		CooperativeBehavior oldLink_cooperativeBehaviour = link_cooperativeBehaviour;
		link_cooperativeBehaviour = newLink_cooperativeBehaviour;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_COOPERATIVE_BEHAVIOUR_VEHICLE_CONFIGURATION__LINK_COOPERATIVE_BEHAVIOUR, oldLink_cooperativeBehaviour, link_cooperativeBehaviour));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Vehicle_Configuration getLink_vehicleConfiguration() {
		if (link_vehicleConfiguration != null && link_vehicleConfiguration.eIsProxy()) {
			InternalEObject oldLink_vehicleConfiguration = (InternalEObject)link_vehicleConfiguration;
			link_vehicleConfiguration = (Vehicle_Configuration)eResolveProxy(oldLink_vehicleConfiguration);
			if (link_vehicleConfiguration != oldLink_vehicleConfiguration) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LINK_COOPERATIVE_BEHAVIOUR_VEHICLE_CONFIGURATION__LINK_VEHICLE_CONFIGURATION, oldLink_vehicleConfiguration, link_vehicleConfiguration));
			}
		}
		return link_vehicleConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Vehicle_Configuration basicGetLink_vehicleConfiguration() {
		return link_vehicleConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLink_vehicleConfiguration(Vehicle_Configuration newLink_vehicleConfiguration) {
		Vehicle_Configuration oldLink_vehicleConfiguration = link_vehicleConfiguration;
		link_vehicleConfiguration = newLink_vehicleConfiguration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_COOPERATIVE_BEHAVIOUR_VEHICLE_CONFIGURATION__LINK_VEHICLE_CONFIGURATION, oldLink_vehicleConfiguration, link_vehicleConfiguration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IntelligentMobilityPackage.LINK_COOPERATIVE_BEHAVIOUR_VEHICLE_CONFIGURATION__NAME_LINK_COOPERATIVE_BEHAVIOUR_VEHICLE_CONFIGURATION:
				return getName_link_cooperativeBehaviour_vehicleConfiguration();
			case IntelligentMobilityPackage.LINK_COOPERATIVE_BEHAVIOUR_VEHICLE_CONFIGURATION__LINK_COOPERATIVE_BEHAVIOUR:
				if (resolve) return getLink_cooperativeBehaviour();
				return basicGetLink_cooperativeBehaviour();
			case IntelligentMobilityPackage.LINK_COOPERATIVE_BEHAVIOUR_VEHICLE_CONFIGURATION__LINK_VEHICLE_CONFIGURATION:
				if (resolve) return getLink_vehicleConfiguration();
				return basicGetLink_vehicleConfiguration();
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
			case IntelligentMobilityPackage.LINK_COOPERATIVE_BEHAVIOUR_VEHICLE_CONFIGURATION__NAME_LINK_COOPERATIVE_BEHAVIOUR_VEHICLE_CONFIGURATION:
				setName_link_cooperativeBehaviour_vehicleConfiguration((String)newValue);
				return;
			case IntelligentMobilityPackage.LINK_COOPERATIVE_BEHAVIOUR_VEHICLE_CONFIGURATION__LINK_COOPERATIVE_BEHAVIOUR:
				setLink_cooperativeBehaviour((CooperativeBehavior)newValue);
				return;
			case IntelligentMobilityPackage.LINK_COOPERATIVE_BEHAVIOUR_VEHICLE_CONFIGURATION__LINK_VEHICLE_CONFIGURATION:
				setLink_vehicleConfiguration((Vehicle_Configuration)newValue);
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
			case IntelligentMobilityPackage.LINK_COOPERATIVE_BEHAVIOUR_VEHICLE_CONFIGURATION__NAME_LINK_COOPERATIVE_BEHAVIOUR_VEHICLE_CONFIGURATION:
				setName_link_cooperativeBehaviour_vehicleConfiguration(NAME_LINK_COOPERATIVE_BEHAVIOUR_VEHICLE_CONFIGURATION_EDEFAULT);
				return;
			case IntelligentMobilityPackage.LINK_COOPERATIVE_BEHAVIOUR_VEHICLE_CONFIGURATION__LINK_COOPERATIVE_BEHAVIOUR:
				setLink_cooperativeBehaviour((CooperativeBehavior)null);
				return;
			case IntelligentMobilityPackage.LINK_COOPERATIVE_BEHAVIOUR_VEHICLE_CONFIGURATION__LINK_VEHICLE_CONFIGURATION:
				setLink_vehicleConfiguration((Vehicle_Configuration)null);
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
			case IntelligentMobilityPackage.LINK_COOPERATIVE_BEHAVIOUR_VEHICLE_CONFIGURATION__NAME_LINK_COOPERATIVE_BEHAVIOUR_VEHICLE_CONFIGURATION:
				return NAME_LINK_COOPERATIVE_BEHAVIOUR_VEHICLE_CONFIGURATION_EDEFAULT == null ? name_link_cooperativeBehaviour_vehicleConfiguration != null : !NAME_LINK_COOPERATIVE_BEHAVIOUR_VEHICLE_CONFIGURATION_EDEFAULT.equals(name_link_cooperativeBehaviour_vehicleConfiguration);
			case IntelligentMobilityPackage.LINK_COOPERATIVE_BEHAVIOUR_VEHICLE_CONFIGURATION__LINK_COOPERATIVE_BEHAVIOUR:
				return link_cooperativeBehaviour != null;
			case IntelligentMobilityPackage.LINK_COOPERATIVE_BEHAVIOUR_VEHICLE_CONFIGURATION__LINK_VEHICLE_CONFIGURATION:
				return link_vehicleConfiguration != null;
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
		result.append(" (name_link_cooperativeBehaviour_vehicleConfiguration: ");
		result.append(name_link_cooperativeBehaviour_vehicleConfiguration);
		result.append(')');
		return result.toString();
	}

} //Link_CooperativeBehaviour_VehicleConfigurationImpl
