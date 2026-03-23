/**
 */
package intelligentMobility.impl;

import intelligentMobility.IntelligentMobilityPackage;
import intelligentMobility.Link_NormalVehicle_SafetyRequirements;
import intelligentMobility.Normal_Vehicle;
import intelligentMobility.Safety_Requirement;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Link Normal Vehicle Safety Requirements</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.impl.Link_NormalVehicle_SafetyRequirementsImpl#getName_link_normalVehicle_safetyRequirement <em>Name link normal Vehicle safety Requirement</em>}</li>
 *   <li>{@link intelligentMobility.impl.Link_NormalVehicle_SafetyRequirementsImpl#getLink_normalVehicle <em>Link normal Vehicle</em>}</li>
 *   <li>{@link intelligentMobility.impl.Link_NormalVehicle_SafetyRequirementsImpl#getLink_safetyRequirement <em>Link safety Requirement</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Link_NormalVehicle_SafetyRequirementsImpl extends MinimalEObjectImpl.Container implements Link_NormalVehicle_SafetyRequirements {
	/**
	 * The default value of the '{@link #getName_link_normalVehicle_safetyRequirement() <em>Name link normal Vehicle safety Requirement</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName_link_normalVehicle_safetyRequirement()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_LINK_NORMAL_VEHICLE_SAFETY_REQUIREMENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName_link_normalVehicle_safetyRequirement() <em>Name link normal Vehicle safety Requirement</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName_link_normalVehicle_safetyRequirement()
	 * @generated
	 * @ordered
	 */
	protected String name_link_normalVehicle_safetyRequirement = NAME_LINK_NORMAL_VEHICLE_SAFETY_REQUIREMENT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getLink_normalVehicle() <em>Link normal Vehicle</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_normalVehicle()
	 * @generated
	 * @ordered
	 */
	protected Normal_Vehicle link_normalVehicle;

	/**
	 * The cached value of the '{@link #getLink_safetyRequirement() <em>Link safety Requirement</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_safetyRequirement()
	 * @generated
	 * @ordered
	 */
	protected Safety_Requirement link_safetyRequirement;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Link_NormalVehicle_SafetyRequirementsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return IntelligentMobilityPackage.eINSTANCE.getLink_NormalVehicle_SafetyRequirements();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName_link_normalVehicle_safetyRequirement() {
		return name_link_normalVehicle_safetyRequirement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName_link_normalVehicle_safetyRequirement(String newName_link_normalVehicle_safetyRequirement) {
		String oldName_link_normalVehicle_safetyRequirement = name_link_normalVehicle_safetyRequirement;
		name_link_normalVehicle_safetyRequirement = newName_link_normalVehicle_safetyRequirement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_NORMAL_VEHICLE_SAFETY_REQUIREMENTS__NAME_LINK_NORMAL_VEHICLE_SAFETY_REQUIREMENT, oldName_link_normalVehicle_safetyRequirement, name_link_normalVehicle_safetyRequirement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Normal_Vehicle getLink_normalVehicle() {
		if (link_normalVehicle != null && link_normalVehicle.eIsProxy()) {
			InternalEObject oldLink_normalVehicle = (InternalEObject)link_normalVehicle;
			link_normalVehicle = (Normal_Vehicle)eResolveProxy(oldLink_normalVehicle);
			if (link_normalVehicle != oldLink_normalVehicle) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LINK_NORMAL_VEHICLE_SAFETY_REQUIREMENTS__LINK_NORMAL_VEHICLE, oldLink_normalVehicle, link_normalVehicle));
			}
		}
		return link_normalVehicle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Normal_Vehicle basicGetLink_normalVehicle() {
		return link_normalVehicle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLink_normalVehicle(Normal_Vehicle newLink_normalVehicle) {
		Normal_Vehicle oldLink_normalVehicle = link_normalVehicle;
		link_normalVehicle = newLink_normalVehicle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_NORMAL_VEHICLE_SAFETY_REQUIREMENTS__LINK_NORMAL_VEHICLE, oldLink_normalVehicle, link_normalVehicle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Safety_Requirement getLink_safetyRequirement() {
		if (link_safetyRequirement != null && link_safetyRequirement.eIsProxy()) {
			InternalEObject oldLink_safetyRequirement = (InternalEObject)link_safetyRequirement;
			link_safetyRequirement = (Safety_Requirement)eResolveProxy(oldLink_safetyRequirement);
			if (link_safetyRequirement != oldLink_safetyRequirement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LINK_NORMAL_VEHICLE_SAFETY_REQUIREMENTS__LINK_SAFETY_REQUIREMENT, oldLink_safetyRequirement, link_safetyRequirement));
			}
		}
		return link_safetyRequirement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Safety_Requirement basicGetLink_safetyRequirement() {
		return link_safetyRequirement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLink_safetyRequirement(Safety_Requirement newLink_safetyRequirement) {
		Safety_Requirement oldLink_safetyRequirement = link_safetyRequirement;
		link_safetyRequirement = newLink_safetyRequirement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_NORMAL_VEHICLE_SAFETY_REQUIREMENTS__LINK_SAFETY_REQUIREMENT, oldLink_safetyRequirement, link_safetyRequirement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IntelligentMobilityPackage.LINK_NORMAL_VEHICLE_SAFETY_REQUIREMENTS__NAME_LINK_NORMAL_VEHICLE_SAFETY_REQUIREMENT:
				return getName_link_normalVehicle_safetyRequirement();
			case IntelligentMobilityPackage.LINK_NORMAL_VEHICLE_SAFETY_REQUIREMENTS__LINK_NORMAL_VEHICLE:
				if (resolve) return getLink_normalVehicle();
				return basicGetLink_normalVehicle();
			case IntelligentMobilityPackage.LINK_NORMAL_VEHICLE_SAFETY_REQUIREMENTS__LINK_SAFETY_REQUIREMENT:
				if (resolve) return getLink_safetyRequirement();
				return basicGetLink_safetyRequirement();
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
			case IntelligentMobilityPackage.LINK_NORMAL_VEHICLE_SAFETY_REQUIREMENTS__NAME_LINK_NORMAL_VEHICLE_SAFETY_REQUIREMENT:
				setName_link_normalVehicle_safetyRequirement((String)newValue);
				return;
			case IntelligentMobilityPackage.LINK_NORMAL_VEHICLE_SAFETY_REQUIREMENTS__LINK_NORMAL_VEHICLE:
				setLink_normalVehicle((Normal_Vehicle)newValue);
				return;
			case IntelligentMobilityPackage.LINK_NORMAL_VEHICLE_SAFETY_REQUIREMENTS__LINK_SAFETY_REQUIREMENT:
				setLink_safetyRequirement((Safety_Requirement)newValue);
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
			case IntelligentMobilityPackage.LINK_NORMAL_VEHICLE_SAFETY_REQUIREMENTS__NAME_LINK_NORMAL_VEHICLE_SAFETY_REQUIREMENT:
				setName_link_normalVehicle_safetyRequirement(NAME_LINK_NORMAL_VEHICLE_SAFETY_REQUIREMENT_EDEFAULT);
				return;
			case IntelligentMobilityPackage.LINK_NORMAL_VEHICLE_SAFETY_REQUIREMENTS__LINK_NORMAL_VEHICLE:
				setLink_normalVehicle((Normal_Vehicle)null);
				return;
			case IntelligentMobilityPackage.LINK_NORMAL_VEHICLE_SAFETY_REQUIREMENTS__LINK_SAFETY_REQUIREMENT:
				setLink_safetyRequirement((Safety_Requirement)null);
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
			case IntelligentMobilityPackage.LINK_NORMAL_VEHICLE_SAFETY_REQUIREMENTS__NAME_LINK_NORMAL_VEHICLE_SAFETY_REQUIREMENT:
				return NAME_LINK_NORMAL_VEHICLE_SAFETY_REQUIREMENT_EDEFAULT == null ? name_link_normalVehicle_safetyRequirement != null : !NAME_LINK_NORMAL_VEHICLE_SAFETY_REQUIREMENT_EDEFAULT.equals(name_link_normalVehicle_safetyRequirement);
			case IntelligentMobilityPackage.LINK_NORMAL_VEHICLE_SAFETY_REQUIREMENTS__LINK_NORMAL_VEHICLE:
				return link_normalVehicle != null;
			case IntelligentMobilityPackage.LINK_NORMAL_VEHICLE_SAFETY_REQUIREMENTS__LINK_SAFETY_REQUIREMENT:
				return link_safetyRequirement != null;
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
		result.append(" (name_link_normalVehicle_safetyRequirement: ");
		result.append(name_link_normalVehicle_safetyRequirement);
		result.append(')');
		return result.toString();
	}

} //Link_NormalVehicle_SafetyRequirementsImpl
