/**
 */
package intelligentMobility.impl;

import intelligentMobility.IntelligentMobilityPackage;
import intelligentMobility.Leading_Vehicle;
import intelligentMobility.Link_Platoon_LeadingVehicle;
import intelligentMobility.Platoon;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Link Platoon Leading Vehicle</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.impl.Link_Platoon_LeadingVehicleImpl#getName_link_platoon_leadingVehicle <em>Name link platoon leading Vehicle</em>}</li>
 *   <li>{@link intelligentMobility.impl.Link_Platoon_LeadingVehicleImpl#getLink_platoon <em>Link platoon</em>}</li>
 *   <li>{@link intelligentMobility.impl.Link_Platoon_LeadingVehicleImpl#getLink_leadingVehicle <em>Link leading Vehicle</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Link_Platoon_LeadingVehicleImpl extends MinimalEObjectImpl.Container implements Link_Platoon_LeadingVehicle {
	/**
	 * The default value of the '{@link #getName_link_platoon_leadingVehicle() <em>Name link platoon leading Vehicle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName_link_platoon_leadingVehicle()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_LINK_PLATOON_LEADING_VEHICLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName_link_platoon_leadingVehicle() <em>Name link platoon leading Vehicle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName_link_platoon_leadingVehicle()
	 * @generated
	 * @ordered
	 */
	protected String name_link_platoon_leadingVehicle = NAME_LINK_PLATOON_LEADING_VEHICLE_EDEFAULT;

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
	 * The cached value of the '{@link #getLink_leadingVehicle() <em>Link leading Vehicle</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_leadingVehicle()
	 * @generated
	 * @ordered
	 */
	protected Leading_Vehicle link_leadingVehicle;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Link_Platoon_LeadingVehicleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return IntelligentMobilityPackage.eINSTANCE.getLink_Platoon_LeadingVehicle();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName_link_platoon_leadingVehicle() {
		return name_link_platoon_leadingVehicle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName_link_platoon_leadingVehicle(String newName_link_platoon_leadingVehicle) {
		String oldName_link_platoon_leadingVehicle = name_link_platoon_leadingVehicle;
		name_link_platoon_leadingVehicle = newName_link_platoon_leadingVehicle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_PLATOON_LEADING_VEHICLE__NAME_LINK_PLATOON_LEADING_VEHICLE, oldName_link_platoon_leadingVehicle, name_link_platoon_leadingVehicle));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LINK_PLATOON_LEADING_VEHICLE__LINK_PLATOON, oldLink_platoon, link_platoon));
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
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_PLATOON_LEADING_VEHICLE__LINK_PLATOON, oldLink_platoon, link_platoon));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Leading_Vehicle getLink_leadingVehicle() {
		if (link_leadingVehicle != null && link_leadingVehicle.eIsProxy()) {
			InternalEObject oldLink_leadingVehicle = (InternalEObject)link_leadingVehicle;
			link_leadingVehicle = (Leading_Vehicle)eResolveProxy(oldLink_leadingVehicle);
			if (link_leadingVehicle != oldLink_leadingVehicle) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LINK_PLATOON_LEADING_VEHICLE__LINK_LEADING_VEHICLE, oldLink_leadingVehicle, link_leadingVehicle));
			}
		}
		return link_leadingVehicle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Leading_Vehicle basicGetLink_leadingVehicle() {
		return link_leadingVehicle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLink_leadingVehicle(Leading_Vehicle newLink_leadingVehicle) {
		Leading_Vehicle oldLink_leadingVehicle = link_leadingVehicle;
		link_leadingVehicle = newLink_leadingVehicle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_PLATOON_LEADING_VEHICLE__LINK_LEADING_VEHICLE, oldLink_leadingVehicle, link_leadingVehicle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IntelligentMobilityPackage.LINK_PLATOON_LEADING_VEHICLE__NAME_LINK_PLATOON_LEADING_VEHICLE:
				return getName_link_platoon_leadingVehicle();
			case IntelligentMobilityPackage.LINK_PLATOON_LEADING_VEHICLE__LINK_PLATOON:
				if (resolve) return getLink_platoon();
				return basicGetLink_platoon();
			case IntelligentMobilityPackage.LINK_PLATOON_LEADING_VEHICLE__LINK_LEADING_VEHICLE:
				if (resolve) return getLink_leadingVehicle();
				return basicGetLink_leadingVehicle();
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
			case IntelligentMobilityPackage.LINK_PLATOON_LEADING_VEHICLE__NAME_LINK_PLATOON_LEADING_VEHICLE:
				setName_link_platoon_leadingVehicle((String)newValue);
				return;
			case IntelligentMobilityPackage.LINK_PLATOON_LEADING_VEHICLE__LINK_PLATOON:
				setLink_platoon((Platoon)newValue);
				return;
			case IntelligentMobilityPackage.LINK_PLATOON_LEADING_VEHICLE__LINK_LEADING_VEHICLE:
				setLink_leadingVehicle((Leading_Vehicle)newValue);
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
			case IntelligentMobilityPackage.LINK_PLATOON_LEADING_VEHICLE__NAME_LINK_PLATOON_LEADING_VEHICLE:
				setName_link_platoon_leadingVehicle(NAME_LINK_PLATOON_LEADING_VEHICLE_EDEFAULT);
				return;
			case IntelligentMobilityPackage.LINK_PLATOON_LEADING_VEHICLE__LINK_PLATOON:
				setLink_platoon((Platoon)null);
				return;
			case IntelligentMobilityPackage.LINK_PLATOON_LEADING_VEHICLE__LINK_LEADING_VEHICLE:
				setLink_leadingVehicle((Leading_Vehicle)null);
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
			case IntelligentMobilityPackage.LINK_PLATOON_LEADING_VEHICLE__NAME_LINK_PLATOON_LEADING_VEHICLE:
				return NAME_LINK_PLATOON_LEADING_VEHICLE_EDEFAULT == null ? name_link_platoon_leadingVehicle != null : !NAME_LINK_PLATOON_LEADING_VEHICLE_EDEFAULT.equals(name_link_platoon_leadingVehicle);
			case IntelligentMobilityPackage.LINK_PLATOON_LEADING_VEHICLE__LINK_PLATOON:
				return link_platoon != null;
			case IntelligentMobilityPackage.LINK_PLATOON_LEADING_VEHICLE__LINK_LEADING_VEHICLE:
				return link_leadingVehicle != null;
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
		result.append(" (name_link_platoon_leadingVehicle: ");
		result.append(name_link_platoon_leadingVehicle);
		result.append(')');
		return result.toString();
	}

} //Link_Platoon_LeadingVehicleImpl
