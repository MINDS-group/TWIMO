/**
 */
package intelligentMobility.impl;

import intelligentMobility.Following_Vehicle;
import intelligentMobility.IntelligentMobilityPackage;
import intelligentMobility.Link_Platoon_FollowingVehicle;
import intelligentMobility.Platoon;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Link Platoon Following Vehicle</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.impl.Link_Platoon_FollowingVehicleImpl#getName_link_platoon_followingVehicle <em>Name link platoon following Vehicle</em>}</li>
 *   <li>{@link intelligentMobility.impl.Link_Platoon_FollowingVehicleImpl#getLink_platoon <em>Link platoon</em>}</li>
 *   <li>{@link intelligentMobility.impl.Link_Platoon_FollowingVehicleImpl#getLink_followingVehicle <em>Link following Vehicle</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Link_Platoon_FollowingVehicleImpl extends MinimalEObjectImpl.Container implements Link_Platoon_FollowingVehicle {
	/**
	 * The default value of the '{@link #getName_link_platoon_followingVehicle() <em>Name link platoon following Vehicle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName_link_platoon_followingVehicle()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_LINK_PLATOON_FOLLOWING_VEHICLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName_link_platoon_followingVehicle() <em>Name link platoon following Vehicle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName_link_platoon_followingVehicle()
	 * @generated
	 * @ordered
	 */
	protected String name_link_platoon_followingVehicle = NAME_LINK_PLATOON_FOLLOWING_VEHICLE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getLink_platoon() <em>Link platoon</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_platoon()
	 * @generated
	 * @ordered
	 */
	protected Platoon link_platoon;

	/**
	 * The cached value of the '{@link #getLink_followingVehicle() <em>Link following Vehicle</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_followingVehicle()
	 * @generated
	 * @ordered
	 */
	protected Following_Vehicle link_followingVehicle;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Link_Platoon_FollowingVehicleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return IntelligentMobilityPackage.eINSTANCE.getLink_Platoon_FollowingVehicle();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName_link_platoon_followingVehicle() {
		return name_link_platoon_followingVehicle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName_link_platoon_followingVehicle(String newName_link_platoon_followingVehicle) {
		String oldName_link_platoon_followingVehicle = name_link_platoon_followingVehicle;
		name_link_platoon_followingVehicle = newName_link_platoon_followingVehicle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_PLATOON_FOLLOWING_VEHICLE__NAME_LINK_PLATOON_FOLLOWING_VEHICLE, oldName_link_platoon_followingVehicle, name_link_platoon_followingVehicle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Platoon getLink_platoon() {
		if (link_platoon != null && link_platoon.eIsProxy()) {
			InternalEObject oldLink_platoon = (InternalEObject)link_platoon;
			link_platoon = (Platoon)eResolveProxy(oldLink_platoon);
			if (link_platoon != oldLink_platoon) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LINK_PLATOON_FOLLOWING_VEHICLE__LINK_PLATOON, oldLink_platoon, link_platoon));
			}
		}
		return link_platoon;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Platoon basicGetLink_platoon() {
		return link_platoon;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLink_platoon(Platoon newLink_platoon) {
		Platoon oldLink_platoon = link_platoon;
		link_platoon = newLink_platoon;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_PLATOON_FOLLOWING_VEHICLE__LINK_PLATOON, oldLink_platoon, link_platoon));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Following_Vehicle getLink_followingVehicle() {
		if (link_followingVehicle != null && link_followingVehicle.eIsProxy()) {
			InternalEObject oldLink_followingVehicle = (InternalEObject)link_followingVehicle;
			link_followingVehicle = (Following_Vehicle)eResolveProxy(oldLink_followingVehicle);
			if (link_followingVehicle != oldLink_followingVehicle) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LINK_PLATOON_FOLLOWING_VEHICLE__LINK_FOLLOWING_VEHICLE, oldLink_followingVehicle, link_followingVehicle));
			}
		}
		return link_followingVehicle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Following_Vehicle basicGetLink_followingVehicle() {
		return link_followingVehicle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLink_followingVehicle(Following_Vehicle newLink_followingVehicle) {
		Following_Vehicle oldLink_followingVehicle = link_followingVehicle;
		link_followingVehicle = newLink_followingVehicle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_PLATOON_FOLLOWING_VEHICLE__LINK_FOLLOWING_VEHICLE, oldLink_followingVehicle, link_followingVehicle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IntelligentMobilityPackage.LINK_PLATOON_FOLLOWING_VEHICLE__NAME_LINK_PLATOON_FOLLOWING_VEHICLE:
				return getName_link_platoon_followingVehicle();
			case IntelligentMobilityPackage.LINK_PLATOON_FOLLOWING_VEHICLE__LINK_PLATOON:
				if (resolve) return getLink_platoon();
				return basicGetLink_platoon();
			case IntelligentMobilityPackage.LINK_PLATOON_FOLLOWING_VEHICLE__LINK_FOLLOWING_VEHICLE:
				if (resolve) return getLink_followingVehicle();
				return basicGetLink_followingVehicle();
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
			case IntelligentMobilityPackage.LINK_PLATOON_FOLLOWING_VEHICLE__NAME_LINK_PLATOON_FOLLOWING_VEHICLE:
				setName_link_platoon_followingVehicle((String)newValue);
				return;
			case IntelligentMobilityPackage.LINK_PLATOON_FOLLOWING_VEHICLE__LINK_PLATOON:
				setLink_platoon((Platoon)newValue);
				return;
			case IntelligentMobilityPackage.LINK_PLATOON_FOLLOWING_VEHICLE__LINK_FOLLOWING_VEHICLE:
				setLink_followingVehicle((Following_Vehicle)newValue);
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
			case IntelligentMobilityPackage.LINK_PLATOON_FOLLOWING_VEHICLE__NAME_LINK_PLATOON_FOLLOWING_VEHICLE:
				setName_link_platoon_followingVehicle(NAME_LINK_PLATOON_FOLLOWING_VEHICLE_EDEFAULT);
				return;
			case IntelligentMobilityPackage.LINK_PLATOON_FOLLOWING_VEHICLE__LINK_PLATOON:
				setLink_platoon((Platoon)null);
				return;
			case IntelligentMobilityPackage.LINK_PLATOON_FOLLOWING_VEHICLE__LINK_FOLLOWING_VEHICLE:
				setLink_followingVehicle((Following_Vehicle)null);
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
			case IntelligentMobilityPackage.LINK_PLATOON_FOLLOWING_VEHICLE__NAME_LINK_PLATOON_FOLLOWING_VEHICLE:
				return NAME_LINK_PLATOON_FOLLOWING_VEHICLE_EDEFAULT == null ? name_link_platoon_followingVehicle != null : !NAME_LINK_PLATOON_FOLLOWING_VEHICLE_EDEFAULT.equals(name_link_platoon_followingVehicle);
			case IntelligentMobilityPackage.LINK_PLATOON_FOLLOWING_VEHICLE__LINK_PLATOON:
				return link_platoon != null;
			case IntelligentMobilityPackage.LINK_PLATOON_FOLLOWING_VEHICLE__LINK_FOLLOWING_VEHICLE:
				return link_followingVehicle != null;
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
		result.append(" (name_link_platoon_followingVehicle: ");
		result.append(name_link_platoon_followingVehicle);
		result.append(')');
		return result.toString();
	}

} //Link_Platoon_FollowingVehicleImpl
