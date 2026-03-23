/**
 */
package intelligentMobility.impl;

import intelligentMobility.Driver_Emotion;
import intelligentMobility.Driver_Preference;
import intelligentMobility.IntelligentMobilityPackage;
import intelligentMobility.Link_DriverPreference_DriverEmotion;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Link Driver Preference Driver Emotion</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.impl.Link_DriverPreference_DriverEmotionImpl#getName_link_preference_emotion <em>Name link preference emotion</em>}</li>
 *   <li>{@link intelligentMobility.impl.Link_DriverPreference_DriverEmotionImpl#getLink_driver_preference <em>Link driver preference</em>}</li>
 *   <li>{@link intelligentMobility.impl.Link_DriverPreference_DriverEmotionImpl#getLink_driver_emotion <em>Link driver emotion</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Link_DriverPreference_DriverEmotionImpl extends MinimalEObjectImpl.Container implements Link_DriverPreference_DriverEmotion {
	/**
	 * The default value of the '{@link #getName_link_preference_emotion() <em>Name link preference emotion</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName_link_preference_emotion()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_LINK_PREFERENCE_EMOTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName_link_preference_emotion() <em>Name link preference emotion</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName_link_preference_emotion()
	 * @generated
	 * @ordered
	 */
	protected String name_link_preference_emotion = NAME_LINK_PREFERENCE_EMOTION_EDEFAULT;

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
	 * The cached value of the '{@link #getLink_driver_emotion() <em>Link driver emotion</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_driver_emotion()
	 * @generated
	 * @ordered
	 */
	protected Driver_Emotion link_driver_emotion;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Link_DriverPreference_DriverEmotionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return IntelligentMobilityPackage.eINSTANCE.getLink_DriverPreference_DriverEmotion();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName_link_preference_emotion() {
		return name_link_preference_emotion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName_link_preference_emotion(String newName_link_preference_emotion) {
		String oldName_link_preference_emotion = name_link_preference_emotion;
		name_link_preference_emotion = newName_link_preference_emotion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_DRIVER_PREFERENCE_DRIVER_EMOTION__NAME_LINK_PREFERENCE_EMOTION, oldName_link_preference_emotion, name_link_preference_emotion));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LINK_DRIVER_PREFERENCE_DRIVER_EMOTION__LINK_DRIVER_PREFERENCE, oldLink_driver_preference, link_driver_preference));
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
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_DRIVER_PREFERENCE_DRIVER_EMOTION__LINK_DRIVER_PREFERENCE, oldLink_driver_preference, link_driver_preference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Driver_Emotion getLink_driver_emotion() {
		if (link_driver_emotion != null && link_driver_emotion.eIsProxy()) {
			InternalEObject oldLink_driver_emotion = (InternalEObject)link_driver_emotion;
			link_driver_emotion = (Driver_Emotion)eResolveProxy(oldLink_driver_emotion);
			if (link_driver_emotion != oldLink_driver_emotion) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LINK_DRIVER_PREFERENCE_DRIVER_EMOTION__LINK_DRIVER_EMOTION, oldLink_driver_emotion, link_driver_emotion));
			}
		}
		return link_driver_emotion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Driver_Emotion basicGetLink_driver_emotion() {
		return link_driver_emotion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLink_driver_emotion(Driver_Emotion newLink_driver_emotion) {
		Driver_Emotion oldLink_driver_emotion = link_driver_emotion;
		link_driver_emotion = newLink_driver_emotion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_DRIVER_PREFERENCE_DRIVER_EMOTION__LINK_DRIVER_EMOTION, oldLink_driver_emotion, link_driver_emotion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IntelligentMobilityPackage.LINK_DRIVER_PREFERENCE_DRIVER_EMOTION__NAME_LINK_PREFERENCE_EMOTION:
				return getName_link_preference_emotion();
			case IntelligentMobilityPackage.LINK_DRIVER_PREFERENCE_DRIVER_EMOTION__LINK_DRIVER_PREFERENCE:
				if (resolve) return getLink_driver_preference();
				return basicGetLink_driver_preference();
			case IntelligentMobilityPackage.LINK_DRIVER_PREFERENCE_DRIVER_EMOTION__LINK_DRIVER_EMOTION:
				if (resolve) return getLink_driver_emotion();
				return basicGetLink_driver_emotion();
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
			case IntelligentMobilityPackage.LINK_DRIVER_PREFERENCE_DRIVER_EMOTION__NAME_LINK_PREFERENCE_EMOTION:
				setName_link_preference_emotion((String)newValue);
				return;
			case IntelligentMobilityPackage.LINK_DRIVER_PREFERENCE_DRIVER_EMOTION__LINK_DRIVER_PREFERENCE:
				setLink_driver_preference((Driver_Preference)newValue);
				return;
			case IntelligentMobilityPackage.LINK_DRIVER_PREFERENCE_DRIVER_EMOTION__LINK_DRIVER_EMOTION:
				setLink_driver_emotion((Driver_Emotion)newValue);
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
			case IntelligentMobilityPackage.LINK_DRIVER_PREFERENCE_DRIVER_EMOTION__NAME_LINK_PREFERENCE_EMOTION:
				setName_link_preference_emotion(NAME_LINK_PREFERENCE_EMOTION_EDEFAULT);
				return;
			case IntelligentMobilityPackage.LINK_DRIVER_PREFERENCE_DRIVER_EMOTION__LINK_DRIVER_PREFERENCE:
				setLink_driver_preference((Driver_Preference)null);
				return;
			case IntelligentMobilityPackage.LINK_DRIVER_PREFERENCE_DRIVER_EMOTION__LINK_DRIVER_EMOTION:
				setLink_driver_emotion((Driver_Emotion)null);
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
			case IntelligentMobilityPackage.LINK_DRIVER_PREFERENCE_DRIVER_EMOTION__NAME_LINK_PREFERENCE_EMOTION:
				return NAME_LINK_PREFERENCE_EMOTION_EDEFAULT == null ? name_link_preference_emotion != null : !NAME_LINK_PREFERENCE_EMOTION_EDEFAULT.equals(name_link_preference_emotion);
			case IntelligentMobilityPackage.LINK_DRIVER_PREFERENCE_DRIVER_EMOTION__LINK_DRIVER_PREFERENCE:
				return link_driver_preference != null;
			case IntelligentMobilityPackage.LINK_DRIVER_PREFERENCE_DRIVER_EMOTION__LINK_DRIVER_EMOTION:
				return link_driver_emotion != null;
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
		result.append(" (name_link_preference_emotion: ");
		result.append(name_link_preference_emotion);
		result.append(')');
		return result.toString();
	}

} //Link_DriverPreference_DriverEmotionImpl
