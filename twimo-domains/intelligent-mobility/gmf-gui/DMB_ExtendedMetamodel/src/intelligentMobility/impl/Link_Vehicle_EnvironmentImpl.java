/**
 */
package intelligentMobility.impl;

import intelligentMobility.Environment_Background;
import intelligentMobility.IntelligentMobilityPackage;
import intelligentMobility.Link_Vehicle_Environment;
import intelligentMobility.Vehicle_Configuration;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Link Vehicle Environment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.impl.Link_Vehicle_EnvironmentImpl#getLink_name_vehicle_environment <em>Link name vehicle environment</em>}</li>
 *   <li>{@link intelligentMobility.impl.Link_Vehicle_EnvironmentImpl#getLink_vehicle_configuration <em>Link vehicle configuration</em>}</li>
 *   <li>{@link intelligentMobility.impl.Link_Vehicle_EnvironmentImpl#getLink_environment_background <em>Link environment background</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Link_Vehicle_EnvironmentImpl extends MinimalEObjectImpl.Container implements Link_Vehicle_Environment {
	/**
	 * The default value of the '{@link #getLink_name_vehicle_environment() <em>Link name vehicle environment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_name_vehicle_environment()
	 * @generated
	 * @ordered
	 */
	protected static final String LINK_NAME_VEHICLE_ENVIRONMENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLink_name_vehicle_environment() <em>Link name vehicle environment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_name_vehicle_environment()
	 * @generated
	 * @ordered
	 */
	protected String link_name_vehicle_environment = LINK_NAME_VEHICLE_ENVIRONMENT_EDEFAULT;

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
	 * The cached value of the '{@link #getLink_environment_background() <em>Link environment background</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_environment_background()
	 * @generated
	 * @ordered
	 */
	protected Environment_Background link_environment_background;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Link_Vehicle_EnvironmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return IntelligentMobilityPackage.eINSTANCE.getLink_Vehicle_Environment();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLink_name_vehicle_environment() {
		return link_name_vehicle_environment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLink_name_vehicle_environment(String newLink_name_vehicle_environment) {
		String oldLink_name_vehicle_environment = link_name_vehicle_environment;
		link_name_vehicle_environment = newLink_name_vehicle_environment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_VEHICLE_ENVIRONMENT__LINK_NAME_VEHICLE_ENVIRONMENT, oldLink_name_vehicle_environment, link_name_vehicle_environment));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LINK_VEHICLE_ENVIRONMENT__LINK_VEHICLE_CONFIGURATION, oldLink_vehicle_configuration, link_vehicle_configuration));
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
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_VEHICLE_ENVIRONMENT__LINK_VEHICLE_CONFIGURATION, oldLink_vehicle_configuration, link_vehicle_configuration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Environment_Background getLink_environment_background() {
		if (link_environment_background != null && link_environment_background.eIsProxy()) {
			InternalEObject oldLink_environment_background = (InternalEObject)link_environment_background;
			link_environment_background = (Environment_Background)eResolveProxy(oldLink_environment_background);
			if (link_environment_background != oldLink_environment_background) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LINK_VEHICLE_ENVIRONMENT__LINK_ENVIRONMENT_BACKGROUND, oldLink_environment_background, link_environment_background));
			}
		}
		return link_environment_background;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Environment_Background basicGetLink_environment_background() {
		return link_environment_background;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLink_environment_background(Environment_Background newLink_environment_background) {
		Environment_Background oldLink_environment_background = link_environment_background;
		link_environment_background = newLink_environment_background;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_VEHICLE_ENVIRONMENT__LINK_ENVIRONMENT_BACKGROUND, oldLink_environment_background, link_environment_background));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IntelligentMobilityPackage.LINK_VEHICLE_ENVIRONMENT__LINK_NAME_VEHICLE_ENVIRONMENT:
				return getLink_name_vehicle_environment();
			case IntelligentMobilityPackage.LINK_VEHICLE_ENVIRONMENT__LINK_VEHICLE_CONFIGURATION:
				if (resolve) return getLink_vehicle_configuration();
				return basicGetLink_vehicle_configuration();
			case IntelligentMobilityPackage.LINK_VEHICLE_ENVIRONMENT__LINK_ENVIRONMENT_BACKGROUND:
				if (resolve) return getLink_environment_background();
				return basicGetLink_environment_background();
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
			case IntelligentMobilityPackage.LINK_VEHICLE_ENVIRONMENT__LINK_NAME_VEHICLE_ENVIRONMENT:
				setLink_name_vehicle_environment((String)newValue);
				return;
			case IntelligentMobilityPackage.LINK_VEHICLE_ENVIRONMENT__LINK_VEHICLE_CONFIGURATION:
				setLink_vehicle_configuration((Vehicle_Configuration)newValue);
				return;
			case IntelligentMobilityPackage.LINK_VEHICLE_ENVIRONMENT__LINK_ENVIRONMENT_BACKGROUND:
				setLink_environment_background((Environment_Background)newValue);
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
			case IntelligentMobilityPackage.LINK_VEHICLE_ENVIRONMENT__LINK_NAME_VEHICLE_ENVIRONMENT:
				setLink_name_vehicle_environment(LINK_NAME_VEHICLE_ENVIRONMENT_EDEFAULT);
				return;
			case IntelligentMobilityPackage.LINK_VEHICLE_ENVIRONMENT__LINK_VEHICLE_CONFIGURATION:
				setLink_vehicle_configuration((Vehicle_Configuration)null);
				return;
			case IntelligentMobilityPackage.LINK_VEHICLE_ENVIRONMENT__LINK_ENVIRONMENT_BACKGROUND:
				setLink_environment_background((Environment_Background)null);
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
			case IntelligentMobilityPackage.LINK_VEHICLE_ENVIRONMENT__LINK_NAME_VEHICLE_ENVIRONMENT:
				return LINK_NAME_VEHICLE_ENVIRONMENT_EDEFAULT == null ? link_name_vehicle_environment != null : !LINK_NAME_VEHICLE_ENVIRONMENT_EDEFAULT.equals(link_name_vehicle_environment);
			case IntelligentMobilityPackage.LINK_VEHICLE_ENVIRONMENT__LINK_VEHICLE_CONFIGURATION:
				return link_vehicle_configuration != null;
			case IntelligentMobilityPackage.LINK_VEHICLE_ENVIRONMENT__LINK_ENVIRONMENT_BACKGROUND:
				return link_environment_background != null;
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
		result.append(" (link_name_vehicle_environment: ");
		result.append(link_name_vehicle_environment);
		result.append(')');
		return result.toString();
	}

} //Link_Vehicle_EnvironmentImpl
