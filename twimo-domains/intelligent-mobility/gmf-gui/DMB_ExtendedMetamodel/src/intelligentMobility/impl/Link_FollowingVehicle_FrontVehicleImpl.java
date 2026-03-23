/**
 */
package intelligentMobility.impl;

import intelligentMobility.Following_Vehicle;
import intelligentMobility.IntelligentMobilityPackage;
import intelligentMobility.Link_FollowingVehicle_FrontVehicle;
import intelligentMobility.PlatoonMember;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Link Following Vehicle Front Vehicle</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.impl.Link_FollowingVehicle_FrontVehicleImpl#getName_link_followingVehicle_frontVehicle <em>Name link following Vehicle front Vehicle</em>}</li>
 *   <li>{@link intelligentMobility.impl.Link_FollowingVehicle_FrontVehicleImpl#getLink_followingVehicle <em>Link following Vehicle</em>}</li>
 *   <li>{@link intelligentMobility.impl.Link_FollowingVehicle_FrontVehicleImpl#getLink_frontVehicle <em>Link front Vehicle</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Link_FollowingVehicle_FrontVehicleImpl extends MinimalEObjectImpl.Container implements Link_FollowingVehicle_FrontVehicle {
	/**
	 * The default value of the '{@link #getName_link_followingVehicle_frontVehicle() <em>Name link following Vehicle front Vehicle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName_link_followingVehicle_frontVehicle()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_LINK_FOLLOWING_VEHICLE_FRONT_VEHICLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName_link_followingVehicle_frontVehicle() <em>Name link following Vehicle front Vehicle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName_link_followingVehicle_frontVehicle()
	 * @generated
	 * @ordered
	 */
	protected String name_link_followingVehicle_frontVehicle = NAME_LINK_FOLLOWING_VEHICLE_FRONT_VEHICLE_EDEFAULT;

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
	 * The cached value of the '{@link #getLink_frontVehicle() <em>Link front Vehicle</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_frontVehicle()
	 * @generated
	 * @ordered
	 */
	protected PlatoonMember link_frontVehicle;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Link_FollowingVehicle_FrontVehicleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return IntelligentMobilityPackage.eINSTANCE.getLink_FollowingVehicle_FrontVehicle();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName_link_followingVehicle_frontVehicle() {
		return name_link_followingVehicle_frontVehicle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName_link_followingVehicle_frontVehicle(String newName_link_followingVehicle_frontVehicle) {
		String oldName_link_followingVehicle_frontVehicle = name_link_followingVehicle_frontVehicle;
		name_link_followingVehicle_frontVehicle = newName_link_followingVehicle_frontVehicle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_FOLLOWING_VEHICLE_FRONT_VEHICLE__NAME_LINK_FOLLOWING_VEHICLE_FRONT_VEHICLE, oldName_link_followingVehicle_frontVehicle, name_link_followingVehicle_frontVehicle));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LINK_FOLLOWING_VEHICLE_FRONT_VEHICLE__LINK_FOLLOWING_VEHICLE, oldLink_followingVehicle, link_followingVehicle));
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
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_FOLLOWING_VEHICLE_FRONT_VEHICLE__LINK_FOLLOWING_VEHICLE, oldLink_followingVehicle, link_followingVehicle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PlatoonMember getLink_frontVehicle() {
		if (link_frontVehicle != null && link_frontVehicle.eIsProxy()) {
			InternalEObject oldLink_frontVehicle = (InternalEObject)link_frontVehicle;
			link_frontVehicle = (PlatoonMember)eResolveProxy(oldLink_frontVehicle);
			if (link_frontVehicle != oldLink_frontVehicle) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LINK_FOLLOWING_VEHICLE_FRONT_VEHICLE__LINK_FRONT_VEHICLE, oldLink_frontVehicle, link_frontVehicle));
			}
		}
		return link_frontVehicle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PlatoonMember basicGetLink_frontVehicle() {
		return link_frontVehicle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLink_frontVehicle(PlatoonMember newLink_frontVehicle) {
		PlatoonMember oldLink_frontVehicle = link_frontVehicle;
		link_frontVehicle = newLink_frontVehicle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_FOLLOWING_VEHICLE_FRONT_VEHICLE__LINK_FRONT_VEHICLE, oldLink_frontVehicle, link_frontVehicle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IntelligentMobilityPackage.LINK_FOLLOWING_VEHICLE_FRONT_VEHICLE__NAME_LINK_FOLLOWING_VEHICLE_FRONT_VEHICLE:
				return getName_link_followingVehicle_frontVehicle();
			case IntelligentMobilityPackage.LINK_FOLLOWING_VEHICLE_FRONT_VEHICLE__LINK_FOLLOWING_VEHICLE:
				if (resolve) return getLink_followingVehicle();
				return basicGetLink_followingVehicle();
			case IntelligentMobilityPackage.LINK_FOLLOWING_VEHICLE_FRONT_VEHICLE__LINK_FRONT_VEHICLE:
				if (resolve) return getLink_frontVehicle();
				return basicGetLink_frontVehicle();
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
			case IntelligentMobilityPackage.LINK_FOLLOWING_VEHICLE_FRONT_VEHICLE__NAME_LINK_FOLLOWING_VEHICLE_FRONT_VEHICLE:
				setName_link_followingVehicle_frontVehicle((String)newValue);
				return;
			case IntelligentMobilityPackage.LINK_FOLLOWING_VEHICLE_FRONT_VEHICLE__LINK_FOLLOWING_VEHICLE:
				setLink_followingVehicle((Following_Vehicle)newValue);
				return;
			case IntelligentMobilityPackage.LINK_FOLLOWING_VEHICLE_FRONT_VEHICLE__LINK_FRONT_VEHICLE:
				setLink_frontVehicle((PlatoonMember)newValue);
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
			case IntelligentMobilityPackage.LINK_FOLLOWING_VEHICLE_FRONT_VEHICLE__NAME_LINK_FOLLOWING_VEHICLE_FRONT_VEHICLE:
				setName_link_followingVehicle_frontVehicle(NAME_LINK_FOLLOWING_VEHICLE_FRONT_VEHICLE_EDEFAULT);
				return;
			case IntelligentMobilityPackage.LINK_FOLLOWING_VEHICLE_FRONT_VEHICLE__LINK_FOLLOWING_VEHICLE:
				setLink_followingVehicle((Following_Vehicle)null);
				return;
			case IntelligentMobilityPackage.LINK_FOLLOWING_VEHICLE_FRONT_VEHICLE__LINK_FRONT_VEHICLE:
				setLink_frontVehicle((PlatoonMember)null);
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
			case IntelligentMobilityPackage.LINK_FOLLOWING_VEHICLE_FRONT_VEHICLE__NAME_LINK_FOLLOWING_VEHICLE_FRONT_VEHICLE:
				return NAME_LINK_FOLLOWING_VEHICLE_FRONT_VEHICLE_EDEFAULT == null ? name_link_followingVehicle_frontVehicle != null : !NAME_LINK_FOLLOWING_VEHICLE_FRONT_VEHICLE_EDEFAULT.equals(name_link_followingVehicle_frontVehicle);
			case IntelligentMobilityPackage.LINK_FOLLOWING_VEHICLE_FRONT_VEHICLE__LINK_FOLLOWING_VEHICLE:
				return link_followingVehicle != null;
			case IntelligentMobilityPackage.LINK_FOLLOWING_VEHICLE_FRONT_VEHICLE__LINK_FRONT_VEHICLE:
				return link_frontVehicle != null;
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
		result.append(" (name_link_followingVehicle_frontVehicle: ");
		result.append(name_link_followingVehicle_frontVehicle);
		result.append(')');
		return result.toString();
	}

} //Link_FollowingVehicle_FrontVehicleImpl
