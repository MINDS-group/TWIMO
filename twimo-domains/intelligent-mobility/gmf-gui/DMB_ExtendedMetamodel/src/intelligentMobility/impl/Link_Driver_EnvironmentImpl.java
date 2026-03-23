/**
 */
package intelligentMobility.impl;

import intelligentMobility.Driver_Profile;
import intelligentMobility.Environment_Background;
import intelligentMobility.IntelligentMobilityPackage;
import intelligentMobility.Link_Driver_Environment;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Link Driver Environment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.impl.Link_Driver_EnvironmentImpl#getLink_name_driver_environment <em>Link name driver environment</em>}</li>
 *   <li>{@link intelligentMobility.impl.Link_Driver_EnvironmentImpl#getLink_driver_profile <em>Link driver profile</em>}</li>
 *   <li>{@link intelligentMobility.impl.Link_Driver_EnvironmentImpl#getLink_environment_background <em>Link environment background</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Link_Driver_EnvironmentImpl extends MinimalEObjectImpl.Container implements Link_Driver_Environment {
	/**
	 * The default value of the '{@link #getLink_name_driver_environment() <em>Link name driver environment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_name_driver_environment()
	 * @generated
	 * @ordered
	 */
	protected static final String LINK_NAME_DRIVER_ENVIRONMENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLink_name_driver_environment() <em>Link name driver environment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_name_driver_environment()
	 * @generated
	 * @ordered
	 */
	protected String link_name_driver_environment = LINK_NAME_DRIVER_ENVIRONMENT_EDEFAULT;

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
	protected Link_Driver_EnvironmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return IntelligentMobilityPackage.eINSTANCE.getLink_Driver_Environment();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLink_name_driver_environment() {
		return link_name_driver_environment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLink_name_driver_environment(String newLink_name_driver_environment) {
		String oldLink_name_driver_environment = link_name_driver_environment;
		link_name_driver_environment = newLink_name_driver_environment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_DRIVER_ENVIRONMENT__LINK_NAME_DRIVER_ENVIRONMENT, oldLink_name_driver_environment, link_name_driver_environment));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LINK_DRIVER_ENVIRONMENT__LINK_DRIVER_PROFILE, oldLink_driver_profile, link_driver_profile));
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
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_DRIVER_ENVIRONMENT__LINK_DRIVER_PROFILE, oldLink_driver_profile, link_driver_profile));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LINK_DRIVER_ENVIRONMENT__LINK_ENVIRONMENT_BACKGROUND, oldLink_environment_background, link_environment_background));
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
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_DRIVER_ENVIRONMENT__LINK_ENVIRONMENT_BACKGROUND, oldLink_environment_background, link_environment_background));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IntelligentMobilityPackage.LINK_DRIVER_ENVIRONMENT__LINK_NAME_DRIVER_ENVIRONMENT:
				return getLink_name_driver_environment();
			case IntelligentMobilityPackage.LINK_DRIVER_ENVIRONMENT__LINK_DRIVER_PROFILE:
				if (resolve) return getLink_driver_profile();
				return basicGetLink_driver_profile();
			case IntelligentMobilityPackage.LINK_DRIVER_ENVIRONMENT__LINK_ENVIRONMENT_BACKGROUND:
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
			case IntelligentMobilityPackage.LINK_DRIVER_ENVIRONMENT__LINK_NAME_DRIVER_ENVIRONMENT:
				setLink_name_driver_environment((String)newValue);
				return;
			case IntelligentMobilityPackage.LINK_DRIVER_ENVIRONMENT__LINK_DRIVER_PROFILE:
				setLink_driver_profile((Driver_Profile)newValue);
				return;
			case IntelligentMobilityPackage.LINK_DRIVER_ENVIRONMENT__LINK_ENVIRONMENT_BACKGROUND:
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
			case IntelligentMobilityPackage.LINK_DRIVER_ENVIRONMENT__LINK_NAME_DRIVER_ENVIRONMENT:
				setLink_name_driver_environment(LINK_NAME_DRIVER_ENVIRONMENT_EDEFAULT);
				return;
			case IntelligentMobilityPackage.LINK_DRIVER_ENVIRONMENT__LINK_DRIVER_PROFILE:
				setLink_driver_profile((Driver_Profile)null);
				return;
			case IntelligentMobilityPackage.LINK_DRIVER_ENVIRONMENT__LINK_ENVIRONMENT_BACKGROUND:
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
			case IntelligentMobilityPackage.LINK_DRIVER_ENVIRONMENT__LINK_NAME_DRIVER_ENVIRONMENT:
				return LINK_NAME_DRIVER_ENVIRONMENT_EDEFAULT == null ? link_name_driver_environment != null : !LINK_NAME_DRIVER_ENVIRONMENT_EDEFAULT.equals(link_name_driver_environment);
			case IntelligentMobilityPackage.LINK_DRIVER_ENVIRONMENT__LINK_DRIVER_PROFILE:
				return link_driver_profile != null;
			case IntelligentMobilityPackage.LINK_DRIVER_ENVIRONMENT__LINK_ENVIRONMENT_BACKGROUND:
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
		result.append(" (link_name_driver_environment: ");
		result.append(link_name_driver_environment);
		result.append(')');
		return result.toString();
	}

} //Link_Driver_EnvironmentImpl
