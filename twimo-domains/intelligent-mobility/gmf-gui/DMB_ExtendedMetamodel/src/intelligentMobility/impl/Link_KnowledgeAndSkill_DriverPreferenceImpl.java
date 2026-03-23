/**
 */
package intelligentMobility.impl;

import intelligentMobility.Driver_Preference;
import intelligentMobility.IntelligentMobilityPackage;
import intelligentMobility.Knowledge_and_Skill;
import intelligentMobility.Link_KnowledgeAndSkill_DriverPreference;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Link Knowledge And Skill Driver Preference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.impl.Link_KnowledgeAndSkill_DriverPreferenceImpl#getName_link_knowledgeAndSkill_driverPreference <em>Name link knowledge And Skill driver Preference</em>}</li>
 *   <li>{@link intelligentMobility.impl.Link_KnowledgeAndSkill_DriverPreferenceImpl#getLink_knowledgeAndSkill <em>Link knowledge And Skill</em>}</li>
 *   <li>{@link intelligentMobility.impl.Link_KnowledgeAndSkill_DriverPreferenceImpl#getLink_driverPreference <em>Link driver Preference</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Link_KnowledgeAndSkill_DriverPreferenceImpl extends MinimalEObjectImpl.Container implements Link_KnowledgeAndSkill_DriverPreference {
	/**
	 * The default value of the '{@link #getName_link_knowledgeAndSkill_driverPreference() <em>Name link knowledge And Skill driver Preference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName_link_knowledgeAndSkill_driverPreference()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_LINK_KNOWLEDGE_AND_SKILL_DRIVER_PREFERENCE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName_link_knowledgeAndSkill_driverPreference() <em>Name link knowledge And Skill driver Preference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName_link_knowledgeAndSkill_driverPreference()
	 * @generated
	 * @ordered
	 */
	protected String name_link_knowledgeAndSkill_driverPreference = NAME_LINK_KNOWLEDGE_AND_SKILL_DRIVER_PREFERENCE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getLink_knowledgeAndSkill() <em>Link knowledge And Skill</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_knowledgeAndSkill()
	 * @generated
	 * @ordered
	 */
	protected Knowledge_and_Skill link_knowledgeAndSkill;

	/**
	 * The cached value of the '{@link #getLink_driverPreference() <em>Link driver Preference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_driverPreference()
	 * @generated
	 * @ordered
	 */
	protected Driver_Preference link_driverPreference;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Link_KnowledgeAndSkill_DriverPreferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return IntelligentMobilityPackage.eINSTANCE.getLink_KnowledgeAndSkill_DriverPreference();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName_link_knowledgeAndSkill_driverPreference() {
		return name_link_knowledgeAndSkill_driverPreference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName_link_knowledgeAndSkill_driverPreference(String newName_link_knowledgeAndSkill_driverPreference) {
		String oldName_link_knowledgeAndSkill_driverPreference = name_link_knowledgeAndSkill_driverPreference;
		name_link_knowledgeAndSkill_driverPreference = newName_link_knowledgeAndSkill_driverPreference;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_KNOWLEDGE_AND_SKILL_DRIVER_PREFERENCE__NAME_LINK_KNOWLEDGE_AND_SKILL_DRIVER_PREFERENCE, oldName_link_knowledgeAndSkill_driverPreference, name_link_knowledgeAndSkill_driverPreference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Knowledge_and_Skill getLink_knowledgeAndSkill() {
		if (link_knowledgeAndSkill != null && link_knowledgeAndSkill.eIsProxy()) {
			InternalEObject oldLink_knowledgeAndSkill = (InternalEObject)link_knowledgeAndSkill;
			link_knowledgeAndSkill = (Knowledge_and_Skill)eResolveProxy(oldLink_knowledgeAndSkill);
			if (link_knowledgeAndSkill != oldLink_knowledgeAndSkill) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LINK_KNOWLEDGE_AND_SKILL_DRIVER_PREFERENCE__LINK_KNOWLEDGE_AND_SKILL, oldLink_knowledgeAndSkill, link_knowledgeAndSkill));
			}
		}
		return link_knowledgeAndSkill;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Knowledge_and_Skill basicGetLink_knowledgeAndSkill() {
		return link_knowledgeAndSkill;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLink_knowledgeAndSkill(Knowledge_and_Skill newLink_knowledgeAndSkill) {
		Knowledge_and_Skill oldLink_knowledgeAndSkill = link_knowledgeAndSkill;
		link_knowledgeAndSkill = newLink_knowledgeAndSkill;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_KNOWLEDGE_AND_SKILL_DRIVER_PREFERENCE__LINK_KNOWLEDGE_AND_SKILL, oldLink_knowledgeAndSkill, link_knowledgeAndSkill));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Driver_Preference getLink_driverPreference() {
		if (link_driverPreference != null && link_driverPreference.eIsProxy()) {
			InternalEObject oldLink_driverPreference = (InternalEObject)link_driverPreference;
			link_driverPreference = (Driver_Preference)eResolveProxy(oldLink_driverPreference);
			if (link_driverPreference != oldLink_driverPreference) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LINK_KNOWLEDGE_AND_SKILL_DRIVER_PREFERENCE__LINK_DRIVER_PREFERENCE, oldLink_driverPreference, link_driverPreference));
			}
		}
		return link_driverPreference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Driver_Preference basicGetLink_driverPreference() {
		return link_driverPreference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLink_driverPreference(Driver_Preference newLink_driverPreference) {
		Driver_Preference oldLink_driverPreference = link_driverPreference;
		link_driverPreference = newLink_driverPreference;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_KNOWLEDGE_AND_SKILL_DRIVER_PREFERENCE__LINK_DRIVER_PREFERENCE, oldLink_driverPreference, link_driverPreference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IntelligentMobilityPackage.LINK_KNOWLEDGE_AND_SKILL_DRIVER_PREFERENCE__NAME_LINK_KNOWLEDGE_AND_SKILL_DRIVER_PREFERENCE:
				return getName_link_knowledgeAndSkill_driverPreference();
			case IntelligentMobilityPackage.LINK_KNOWLEDGE_AND_SKILL_DRIVER_PREFERENCE__LINK_KNOWLEDGE_AND_SKILL:
				if (resolve) return getLink_knowledgeAndSkill();
				return basicGetLink_knowledgeAndSkill();
			case IntelligentMobilityPackage.LINK_KNOWLEDGE_AND_SKILL_DRIVER_PREFERENCE__LINK_DRIVER_PREFERENCE:
				if (resolve) return getLink_driverPreference();
				return basicGetLink_driverPreference();
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
			case IntelligentMobilityPackage.LINK_KNOWLEDGE_AND_SKILL_DRIVER_PREFERENCE__NAME_LINK_KNOWLEDGE_AND_SKILL_DRIVER_PREFERENCE:
				setName_link_knowledgeAndSkill_driverPreference((String)newValue);
				return;
			case IntelligentMobilityPackage.LINK_KNOWLEDGE_AND_SKILL_DRIVER_PREFERENCE__LINK_KNOWLEDGE_AND_SKILL:
				setLink_knowledgeAndSkill((Knowledge_and_Skill)newValue);
				return;
			case IntelligentMobilityPackage.LINK_KNOWLEDGE_AND_SKILL_DRIVER_PREFERENCE__LINK_DRIVER_PREFERENCE:
				setLink_driverPreference((Driver_Preference)newValue);
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
			case IntelligentMobilityPackage.LINK_KNOWLEDGE_AND_SKILL_DRIVER_PREFERENCE__NAME_LINK_KNOWLEDGE_AND_SKILL_DRIVER_PREFERENCE:
				setName_link_knowledgeAndSkill_driverPreference(NAME_LINK_KNOWLEDGE_AND_SKILL_DRIVER_PREFERENCE_EDEFAULT);
				return;
			case IntelligentMobilityPackage.LINK_KNOWLEDGE_AND_SKILL_DRIVER_PREFERENCE__LINK_KNOWLEDGE_AND_SKILL:
				setLink_knowledgeAndSkill((Knowledge_and_Skill)null);
				return;
			case IntelligentMobilityPackage.LINK_KNOWLEDGE_AND_SKILL_DRIVER_PREFERENCE__LINK_DRIVER_PREFERENCE:
				setLink_driverPreference((Driver_Preference)null);
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
			case IntelligentMobilityPackage.LINK_KNOWLEDGE_AND_SKILL_DRIVER_PREFERENCE__NAME_LINK_KNOWLEDGE_AND_SKILL_DRIVER_PREFERENCE:
				return NAME_LINK_KNOWLEDGE_AND_SKILL_DRIVER_PREFERENCE_EDEFAULT == null ? name_link_knowledgeAndSkill_driverPreference != null : !NAME_LINK_KNOWLEDGE_AND_SKILL_DRIVER_PREFERENCE_EDEFAULT.equals(name_link_knowledgeAndSkill_driverPreference);
			case IntelligentMobilityPackage.LINK_KNOWLEDGE_AND_SKILL_DRIVER_PREFERENCE__LINK_KNOWLEDGE_AND_SKILL:
				return link_knowledgeAndSkill != null;
			case IntelligentMobilityPackage.LINK_KNOWLEDGE_AND_SKILL_DRIVER_PREFERENCE__LINK_DRIVER_PREFERENCE:
				return link_driverPreference != null;
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
		result.append(" (name_link_knowledgeAndSkill_driverPreference: ");
		result.append(name_link_knowledgeAndSkill_driverPreference);
		result.append(')');
		return result.toString();
	}

} //Link_KnowledgeAndSkill_DriverPreferenceImpl
