/**
 */
package intelligentMobility.impl;

import intelligentMobility.Driver_Preference;
import intelligentMobility.Driver_Profile;
import intelligentMobility.IntelligentMobilityPackage;
import intelligentMobility.Link_DriverProfile_DriverPreference;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Link Driver Profile Driver Preference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.impl.Link_DriverProfile_DriverPreferenceImpl#getName_link_profile_preference <em>Name link profile preference</em>}</li>
 *   <li>{@link intelligentMobility.impl.Link_DriverProfile_DriverPreferenceImpl#getLink_driver_profile <em>Link driver profile</em>}</li>
 *   <li>{@link intelligentMobility.impl.Link_DriverProfile_DriverPreferenceImpl#getLink_driver_preference <em>Link driver preference</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Link_DriverProfile_DriverPreferenceImpl extends MinimalEObjectImpl.Container implements Link_DriverProfile_DriverPreference {
	/**
	 * The default value of the '{@link #getName_link_profile_preference() <em>Name link profile preference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName_link_profile_preference()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_LINK_PROFILE_PREFERENCE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName_link_profile_preference() <em>Name link profile preference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName_link_profile_preference()
	 * @generated
	 * @ordered
	 */
	protected String name_link_profile_preference = NAME_LINK_PROFILE_PREFERENCE_EDEFAULT;

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
	 * The cached value of the '{@link #getLink_driver_preference() <em>Link driver preference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_driver_preference()
	 * @generated
	 * @ordered
	 */
	protected Driver_Preference link_driver_preference;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Link_DriverProfile_DriverPreferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return IntelligentMobilityPackage.eINSTANCE.getLink_DriverProfile_DriverPreference();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName_link_profile_preference() {
		return name_link_profile_preference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName_link_profile_preference(String newName_link_profile_preference) {
		String oldName_link_profile_preference = name_link_profile_preference;
		name_link_profile_preference = newName_link_profile_preference;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_DRIVER_PROFILE_DRIVER_PREFERENCE__NAME_LINK_PROFILE_PREFERENCE, oldName_link_profile_preference, name_link_profile_preference));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LINK_DRIVER_PROFILE_DRIVER_PREFERENCE__LINK_DRIVER_PROFILE, oldLink_driver_profile, link_driver_profile));
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
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_DRIVER_PROFILE_DRIVER_PREFERENCE__LINK_DRIVER_PROFILE, oldLink_driver_profile, link_driver_profile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Driver_Preference getLink_driver_preference() {
		if (link_driver_preference != null && link_driver_preference.eIsProxy()) {
			InternalEObject oldLink_driver_preference = (InternalEObject)link_driver_preference;
			link_driver_preference = (Driver_Preference)eResolveProxy(oldLink_driver_preference);
			if (link_driver_preference != oldLink_driver_preference) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LINK_DRIVER_PROFILE_DRIVER_PREFERENCE__LINK_DRIVER_PREFERENCE, oldLink_driver_preference, link_driver_preference));
			}
		}
		return link_driver_preference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Driver_Preference basicGetLink_driver_preference() {
		return link_driver_preference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLink_driver_preference(Driver_Preference newLink_driver_preference) {
		Driver_Preference oldLink_driver_preference = link_driver_preference;
		link_driver_preference = newLink_driver_preference;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_DRIVER_PROFILE_DRIVER_PREFERENCE__LINK_DRIVER_PREFERENCE, oldLink_driver_preference, link_driver_preference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IntelligentMobilityPackage.LINK_DRIVER_PROFILE_DRIVER_PREFERENCE__NAME_LINK_PROFILE_PREFERENCE:
				return getName_link_profile_preference();
			case IntelligentMobilityPackage.LINK_DRIVER_PROFILE_DRIVER_PREFERENCE__LINK_DRIVER_PROFILE:
				if (resolve) return getLink_driver_profile();
				return basicGetLink_driver_profile();
			case IntelligentMobilityPackage.LINK_DRIVER_PROFILE_DRIVER_PREFERENCE__LINK_DRIVER_PREFERENCE:
				if (resolve) return getLink_driver_preference();
				return basicGetLink_driver_preference();
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
			case IntelligentMobilityPackage.LINK_DRIVER_PROFILE_DRIVER_PREFERENCE__NAME_LINK_PROFILE_PREFERENCE:
				setName_link_profile_preference((String)newValue);
				return;
			case IntelligentMobilityPackage.LINK_DRIVER_PROFILE_DRIVER_PREFERENCE__LINK_DRIVER_PROFILE:
				setLink_driver_profile((Driver_Profile)newValue);
				return;
			case IntelligentMobilityPackage.LINK_DRIVER_PROFILE_DRIVER_PREFERENCE__LINK_DRIVER_PREFERENCE:
				setLink_driver_preference((Driver_Preference)newValue);
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
			case IntelligentMobilityPackage.LINK_DRIVER_PROFILE_DRIVER_PREFERENCE__NAME_LINK_PROFILE_PREFERENCE:
				setName_link_profile_preference(NAME_LINK_PROFILE_PREFERENCE_EDEFAULT);
				return;
			case IntelligentMobilityPackage.LINK_DRIVER_PROFILE_DRIVER_PREFERENCE__LINK_DRIVER_PROFILE:
				setLink_driver_profile((Driver_Profile)null);
				return;
			case IntelligentMobilityPackage.LINK_DRIVER_PROFILE_DRIVER_PREFERENCE__LINK_DRIVER_PREFERENCE:
				setLink_driver_preference((Driver_Preference)null);
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
			case IntelligentMobilityPackage.LINK_DRIVER_PROFILE_DRIVER_PREFERENCE__NAME_LINK_PROFILE_PREFERENCE:
				return NAME_LINK_PROFILE_PREFERENCE_EDEFAULT == null ? name_link_profile_preference != null : !NAME_LINK_PROFILE_PREFERENCE_EDEFAULT.equals(name_link_profile_preference);
			case IntelligentMobilityPackage.LINK_DRIVER_PROFILE_DRIVER_PREFERENCE__LINK_DRIVER_PROFILE:
				return link_driver_profile != null;
			case IntelligentMobilityPackage.LINK_DRIVER_PROFILE_DRIVER_PREFERENCE__LINK_DRIVER_PREFERENCE:
				return link_driver_preference != null;
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
		result.append(" (name_link_profile_preference: ");
		result.append(name_link_profile_preference);
		result.append(')');
		return result.toString();
	}

} //Link_DriverProfile_DriverPreferenceImpl
