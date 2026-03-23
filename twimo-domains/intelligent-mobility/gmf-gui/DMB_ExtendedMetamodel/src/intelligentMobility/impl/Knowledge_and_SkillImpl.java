/**
 */
package intelligentMobility.impl;

import intelligentMobility.IntelligentMobilityPackage;
import intelligentMobility.Knowledge_and_Skill;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Knowledge and Skill</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.impl.Knowledge_and_SkillImpl#getDrivingSkill <em>Driving Skill</em>}</li>
 *   <li>{@link intelligentMobility.impl.Knowledge_and_SkillImpl#getTrafficSignAwareness <em>Traffic Sign Awareness</em>}</li>
 *   <li>{@link intelligentMobility.impl.Knowledge_and_SkillImpl#getRegulationAwareness <em>Regulation Awareness</em>}</li>
 *   <li>{@link intelligentMobility.impl.Knowledge_and_SkillImpl#getLaneSwitchPreferenceLevel <em>Lane Switch Preference Level</em>}</li>
 *   <li>{@link intelligentMobility.impl.Knowledge_and_SkillImpl#getName <em>Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Knowledge_and_SkillImpl extends MinimalEObjectImpl.Container implements Knowledge_and_Skill {
	/**
	 * The default value of the '{@link #getDrivingSkill() <em>Driving Skill</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDrivingSkill()
	 * @generated
	 * @ordered
	 */
	protected static final int DRIVING_SKILL_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getDrivingSkill() <em>Driving Skill</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDrivingSkill()
	 * @generated
	 * @ordered
	 */
	protected int drivingSkill = DRIVING_SKILL_EDEFAULT;

	/**
	 * The default value of the '{@link #getTrafficSignAwareness() <em>Traffic Sign Awareness</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTrafficSignAwareness()
	 * @generated
	 * @ordered
	 */
	protected static final int TRAFFIC_SIGN_AWARENESS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getTrafficSignAwareness() <em>Traffic Sign Awareness</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTrafficSignAwareness()
	 * @generated
	 * @ordered
	 */
	protected int trafficSignAwareness = TRAFFIC_SIGN_AWARENESS_EDEFAULT;

	/**
	 * The default value of the '{@link #getRegulationAwareness() <em>Regulation Awareness</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRegulationAwareness()
	 * @generated
	 * @ordered
	 */
	protected static final int REGULATION_AWARENESS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getRegulationAwareness() <em>Regulation Awareness</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRegulationAwareness()
	 * @generated
	 * @ordered
	 */
	protected int regulationAwareness = REGULATION_AWARENESS_EDEFAULT;

	/**
	 * The default value of the '{@link #getLaneSwitchPreferenceLevel() <em>Lane Switch Preference Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLaneSwitchPreferenceLevel()
	 * @generated
	 * @ordered
	 */
	protected static final int LANE_SWITCH_PREFERENCE_LEVEL_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getLaneSwitchPreferenceLevel() <em>Lane Switch Preference Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLaneSwitchPreferenceLevel()
	 * @generated
	 * @ordered
	 */
	protected int laneSwitchPreferenceLevel = LANE_SWITCH_PREFERENCE_LEVEL_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Knowledge_and_SkillImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return IntelligentMobilityPackage.eINSTANCE.getKnowledge_and_Skill();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getDrivingSkill() {
		return drivingSkill;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDrivingSkill(int newDrivingSkill) {
		int oldDrivingSkill = drivingSkill;
		drivingSkill = newDrivingSkill;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.KNOWLEDGE_AND_SKILL__DRIVING_SKILL, oldDrivingSkill, drivingSkill));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getTrafficSignAwareness() {
		return trafficSignAwareness;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTrafficSignAwareness(int newTrafficSignAwareness) {
		int oldTrafficSignAwareness = trafficSignAwareness;
		trafficSignAwareness = newTrafficSignAwareness;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.KNOWLEDGE_AND_SKILL__TRAFFIC_SIGN_AWARENESS, oldTrafficSignAwareness, trafficSignAwareness));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getRegulationAwareness() {
		return regulationAwareness;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRegulationAwareness(int newRegulationAwareness) {
		int oldRegulationAwareness = regulationAwareness;
		regulationAwareness = newRegulationAwareness;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.KNOWLEDGE_AND_SKILL__REGULATION_AWARENESS, oldRegulationAwareness, regulationAwareness));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getLaneSwitchPreferenceLevel() {
		return laneSwitchPreferenceLevel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLaneSwitchPreferenceLevel(int newLaneSwitchPreferenceLevel) {
		int oldLaneSwitchPreferenceLevel = laneSwitchPreferenceLevel;
		laneSwitchPreferenceLevel = newLaneSwitchPreferenceLevel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.KNOWLEDGE_AND_SKILL__LANE_SWITCH_PREFERENCE_LEVEL, oldLaneSwitchPreferenceLevel, laneSwitchPreferenceLevel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.KNOWLEDGE_AND_SKILL__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IntelligentMobilityPackage.KNOWLEDGE_AND_SKILL__DRIVING_SKILL:
				return new Integer(getDrivingSkill());
			case IntelligentMobilityPackage.KNOWLEDGE_AND_SKILL__TRAFFIC_SIGN_AWARENESS:
				return new Integer(getTrafficSignAwareness());
			case IntelligentMobilityPackage.KNOWLEDGE_AND_SKILL__REGULATION_AWARENESS:
				return new Integer(getRegulationAwareness());
			case IntelligentMobilityPackage.KNOWLEDGE_AND_SKILL__LANE_SWITCH_PREFERENCE_LEVEL:
				return new Integer(getLaneSwitchPreferenceLevel());
			case IntelligentMobilityPackage.KNOWLEDGE_AND_SKILL__NAME:
				return getName();
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
			case IntelligentMobilityPackage.KNOWLEDGE_AND_SKILL__DRIVING_SKILL:
				setDrivingSkill(((Integer)newValue).intValue());
				return;
			case IntelligentMobilityPackage.KNOWLEDGE_AND_SKILL__TRAFFIC_SIGN_AWARENESS:
				setTrafficSignAwareness(((Integer)newValue).intValue());
				return;
			case IntelligentMobilityPackage.KNOWLEDGE_AND_SKILL__REGULATION_AWARENESS:
				setRegulationAwareness(((Integer)newValue).intValue());
				return;
			case IntelligentMobilityPackage.KNOWLEDGE_AND_SKILL__LANE_SWITCH_PREFERENCE_LEVEL:
				setLaneSwitchPreferenceLevel(((Integer)newValue).intValue());
				return;
			case IntelligentMobilityPackage.KNOWLEDGE_AND_SKILL__NAME:
				setName((String)newValue);
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
			case IntelligentMobilityPackage.KNOWLEDGE_AND_SKILL__DRIVING_SKILL:
				setDrivingSkill(DRIVING_SKILL_EDEFAULT);
				return;
			case IntelligentMobilityPackage.KNOWLEDGE_AND_SKILL__TRAFFIC_SIGN_AWARENESS:
				setTrafficSignAwareness(TRAFFIC_SIGN_AWARENESS_EDEFAULT);
				return;
			case IntelligentMobilityPackage.KNOWLEDGE_AND_SKILL__REGULATION_AWARENESS:
				setRegulationAwareness(REGULATION_AWARENESS_EDEFAULT);
				return;
			case IntelligentMobilityPackage.KNOWLEDGE_AND_SKILL__LANE_SWITCH_PREFERENCE_LEVEL:
				setLaneSwitchPreferenceLevel(LANE_SWITCH_PREFERENCE_LEVEL_EDEFAULT);
				return;
			case IntelligentMobilityPackage.KNOWLEDGE_AND_SKILL__NAME:
				setName(NAME_EDEFAULT);
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
			case IntelligentMobilityPackage.KNOWLEDGE_AND_SKILL__DRIVING_SKILL:
				return drivingSkill != DRIVING_SKILL_EDEFAULT;
			case IntelligentMobilityPackage.KNOWLEDGE_AND_SKILL__TRAFFIC_SIGN_AWARENESS:
				return trafficSignAwareness != TRAFFIC_SIGN_AWARENESS_EDEFAULT;
			case IntelligentMobilityPackage.KNOWLEDGE_AND_SKILL__REGULATION_AWARENESS:
				return regulationAwareness != REGULATION_AWARENESS_EDEFAULT;
			case IntelligentMobilityPackage.KNOWLEDGE_AND_SKILL__LANE_SWITCH_PREFERENCE_LEVEL:
				return laneSwitchPreferenceLevel != LANE_SWITCH_PREFERENCE_LEVEL_EDEFAULT;
			case IntelligentMobilityPackage.KNOWLEDGE_AND_SKILL__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
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
		result.append(" (drivingSkill: ");
		result.append(drivingSkill);
		result.append(", trafficSignAwareness: ");
		result.append(trafficSignAwareness);
		result.append(", regulationAwareness: ");
		result.append(regulationAwareness);
		result.append(", laneSwitchPreferenceLevel: ");
		result.append(laneSwitchPreferenceLevel);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //Knowledge_and_SkillImpl
