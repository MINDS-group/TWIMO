/**
 */
package intelligentMobility.impl;

import intelligentMobility.IntelligentMobilityPackage;
import intelligentMobility.Link_SafetyRequirement_Regulation;
import intelligentMobility.Regulation;
import intelligentMobility.Safety_Requirement;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Link Safety Requirement Regulation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.impl.Link_SafetyRequirement_RegulationImpl#getName_link_safetyRequirement_regulation <em>Name link safety Requirement regulation</em>}</li>
 *   <li>{@link intelligentMobility.impl.Link_SafetyRequirement_RegulationImpl#getLink_safetyRequirement <em>Link safety Requirement</em>}</li>
 *   <li>{@link intelligentMobility.impl.Link_SafetyRequirement_RegulationImpl#getLink_regulation <em>Link regulation</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Link_SafetyRequirement_RegulationImpl extends MinimalEObjectImpl.Container implements Link_SafetyRequirement_Regulation {
	/**
	 * The default value of the '{@link #getName_link_safetyRequirement_regulation() <em>Name link safety Requirement regulation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName_link_safetyRequirement_regulation()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_LINK_SAFETY_REQUIREMENT_REGULATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName_link_safetyRequirement_regulation() <em>Name link safety Requirement regulation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName_link_safetyRequirement_regulation()
	 * @generated
	 * @ordered
	 */
	protected String name_link_safetyRequirement_regulation = NAME_LINK_SAFETY_REQUIREMENT_REGULATION_EDEFAULT;

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
	 * The cached value of the '{@link #getLink_regulation() <em>Link regulation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_regulation()
	 * @generated
	 * @ordered
	 */
	protected Regulation link_regulation;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Link_SafetyRequirement_RegulationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return IntelligentMobilityPackage.eINSTANCE.getLink_SafetyRequirement_Regulation();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName_link_safetyRequirement_regulation() {
		return name_link_safetyRequirement_regulation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName_link_safetyRequirement_regulation(String newName_link_safetyRequirement_regulation) {
		String oldName_link_safetyRequirement_regulation = name_link_safetyRequirement_regulation;
		name_link_safetyRequirement_regulation = newName_link_safetyRequirement_regulation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_SAFETY_REQUIREMENT_REGULATION__NAME_LINK_SAFETY_REQUIREMENT_REGULATION, oldName_link_safetyRequirement_regulation, name_link_safetyRequirement_regulation));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LINK_SAFETY_REQUIREMENT_REGULATION__LINK_SAFETY_REQUIREMENT, oldLink_safetyRequirement, link_safetyRequirement));
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
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_SAFETY_REQUIREMENT_REGULATION__LINK_SAFETY_REQUIREMENT, oldLink_safetyRequirement, link_safetyRequirement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Regulation getLink_regulation() {
		if (link_regulation != null && link_regulation.eIsProxy()) {
			InternalEObject oldLink_regulation = (InternalEObject)link_regulation;
			link_regulation = (Regulation)eResolveProxy(oldLink_regulation);
			if (link_regulation != oldLink_regulation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LINK_SAFETY_REQUIREMENT_REGULATION__LINK_REGULATION, oldLink_regulation, link_regulation));
			}
		}
		return link_regulation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Regulation basicGetLink_regulation() {
		return link_regulation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLink_regulation(Regulation newLink_regulation) {
		Regulation oldLink_regulation = link_regulation;
		link_regulation = newLink_regulation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_SAFETY_REQUIREMENT_REGULATION__LINK_REGULATION, oldLink_regulation, link_regulation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IntelligentMobilityPackage.LINK_SAFETY_REQUIREMENT_REGULATION__NAME_LINK_SAFETY_REQUIREMENT_REGULATION:
				return getName_link_safetyRequirement_regulation();
			case IntelligentMobilityPackage.LINK_SAFETY_REQUIREMENT_REGULATION__LINK_SAFETY_REQUIREMENT:
				if (resolve) return getLink_safetyRequirement();
				return basicGetLink_safetyRequirement();
			case IntelligentMobilityPackage.LINK_SAFETY_REQUIREMENT_REGULATION__LINK_REGULATION:
				if (resolve) return getLink_regulation();
				return basicGetLink_regulation();
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
			case IntelligentMobilityPackage.LINK_SAFETY_REQUIREMENT_REGULATION__NAME_LINK_SAFETY_REQUIREMENT_REGULATION:
				setName_link_safetyRequirement_regulation((String)newValue);
				return;
			case IntelligentMobilityPackage.LINK_SAFETY_REQUIREMENT_REGULATION__LINK_SAFETY_REQUIREMENT:
				setLink_safetyRequirement((Safety_Requirement)newValue);
				return;
			case IntelligentMobilityPackage.LINK_SAFETY_REQUIREMENT_REGULATION__LINK_REGULATION:
				setLink_regulation((Regulation)newValue);
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
			case IntelligentMobilityPackage.LINK_SAFETY_REQUIREMENT_REGULATION__NAME_LINK_SAFETY_REQUIREMENT_REGULATION:
				setName_link_safetyRequirement_regulation(NAME_LINK_SAFETY_REQUIREMENT_REGULATION_EDEFAULT);
				return;
			case IntelligentMobilityPackage.LINK_SAFETY_REQUIREMENT_REGULATION__LINK_SAFETY_REQUIREMENT:
				setLink_safetyRequirement((Safety_Requirement)null);
				return;
			case IntelligentMobilityPackage.LINK_SAFETY_REQUIREMENT_REGULATION__LINK_REGULATION:
				setLink_regulation((Regulation)null);
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
			case IntelligentMobilityPackage.LINK_SAFETY_REQUIREMENT_REGULATION__NAME_LINK_SAFETY_REQUIREMENT_REGULATION:
				return NAME_LINK_SAFETY_REQUIREMENT_REGULATION_EDEFAULT == null ? name_link_safetyRequirement_regulation != null : !NAME_LINK_SAFETY_REQUIREMENT_REGULATION_EDEFAULT.equals(name_link_safetyRequirement_regulation);
			case IntelligentMobilityPackage.LINK_SAFETY_REQUIREMENT_REGULATION__LINK_SAFETY_REQUIREMENT:
				return link_safetyRequirement != null;
			case IntelligentMobilityPackage.LINK_SAFETY_REQUIREMENT_REGULATION__LINK_REGULATION:
				return link_regulation != null;
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
		result.append(" (name_link_safetyRequirement_regulation: ");
		result.append(name_link_safetyRequirement_regulation);
		result.append(')');
		return result.toString();
	}

} //Link_SafetyRequirement_RegulationImpl
