/**
 */
package intelligentMobility.impl;

import intelligentMobility.Driver_Emotion;
import intelligentMobility.Driver_Preference;
import intelligentMobility.Driving_Behaviour;
import intelligentMobility.Environment_Condition;
import intelligentMobility.IntelligentMobilityPackage;
import intelligentMobility.Knowledge_and_Skill;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Driver Preference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.impl.Driver_PreferenceImpl#getDriver_emotions <em>Driver emotions</em>}</li>
 *   <li>{@link intelligentMobility.impl.Driver_PreferenceImpl#getKnowledge_and_skills <em>Knowledge and skills</em>}</li>
 *   <li>{@link intelligentMobility.impl.Driver_PreferenceImpl#getName_PreferenceSet <em>Name Preference Set</em>}</li>
 *   <li>{@link intelligentMobility.impl.Driver_PreferenceImpl#getDriving_behaviour <em>Driving behaviour</em>}</li>
 *   <li>{@link intelligentMobility.impl.Driver_PreferenceImpl#getEnvironment_condition <em>Environment condition</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Driver_PreferenceImpl extends MinimalEObjectImpl.Container implements Driver_Preference {
	/**
	 * The cached value of the '{@link #getDriver_emotions() <em>Driver emotions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDriver_emotions()
	 * @generated
	 * @ordered
	 */
	protected EList driver_emotions;

	/**
	 * The cached value of the '{@link #getKnowledge_and_skills() <em>Knowledge and skills</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKnowledge_and_skills()
	 * @generated
	 * @ordered
	 */
	protected Knowledge_and_Skill knowledge_and_skills;

	/**
	 * The default value of the '{@link #getName_PreferenceSet() <em>Name Preference Set</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName_PreferenceSet()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_PREFERENCE_SET_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName_PreferenceSet() <em>Name Preference Set</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName_PreferenceSet()
	 * @generated
	 * @ordered
	 */
	protected String name_PreferenceSet = NAME_PREFERENCE_SET_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDriving_behaviour() <em>Driving behaviour</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDriving_behaviour()
	 * @generated
	 * @ordered
	 */
	protected Driving_Behaviour driving_behaviour;

	/**
	 * The cached value of the '{@link #getEnvironment_condition() <em>Environment condition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnvironment_condition()
	 * @generated
	 * @ordered
	 */
	protected Environment_Condition environment_condition;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Driver_PreferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return IntelligentMobilityPackage.eINSTANCE.getDriver_Preference();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getDriver_emotions() {
		if (driver_emotions == null) {
			driver_emotions = new EObjectContainmentEList(Driver_Emotion.class, this, IntelligentMobilityPackage.DRIVER_PREFERENCE__DRIVER_EMOTIONS);
		}
		return driver_emotions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Knowledge_and_Skill getKnowledge_and_skills() {
		return knowledge_and_skills;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetKnowledge_and_skills(Knowledge_and_Skill newKnowledge_and_skills, NotificationChain msgs) {
		Knowledge_and_Skill oldKnowledge_and_skills = knowledge_and_skills;
		knowledge_and_skills = newKnowledge_and_skills;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.DRIVER_PREFERENCE__KNOWLEDGE_AND_SKILLS, oldKnowledge_and_skills, newKnowledge_and_skills);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKnowledge_and_skills(Knowledge_and_Skill newKnowledge_and_skills) {
		if (newKnowledge_and_skills != knowledge_and_skills) {
			NotificationChain msgs = null;
			if (knowledge_and_skills != null)
				msgs = ((InternalEObject)knowledge_and_skills).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IntelligentMobilityPackage.DRIVER_PREFERENCE__KNOWLEDGE_AND_SKILLS, null, msgs);
			if (newKnowledge_and_skills != null)
				msgs = ((InternalEObject)newKnowledge_and_skills).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IntelligentMobilityPackage.DRIVER_PREFERENCE__KNOWLEDGE_AND_SKILLS, null, msgs);
			msgs = basicSetKnowledge_and_skills(newKnowledge_and_skills, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.DRIVER_PREFERENCE__KNOWLEDGE_AND_SKILLS, newKnowledge_and_skills, newKnowledge_and_skills));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName_PreferenceSet() {
		return name_PreferenceSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName_PreferenceSet(String newName_PreferenceSet) {
		String oldName_PreferenceSet = name_PreferenceSet;
		name_PreferenceSet = newName_PreferenceSet;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.DRIVER_PREFERENCE__NAME_PREFERENCE_SET, oldName_PreferenceSet, name_PreferenceSet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Driving_Behaviour getDriving_behaviour() {
		return driving_behaviour;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDriving_behaviour(Driving_Behaviour newDriving_behaviour, NotificationChain msgs) {
		Driving_Behaviour oldDriving_behaviour = driving_behaviour;
		driving_behaviour = newDriving_behaviour;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.DRIVER_PREFERENCE__DRIVING_BEHAVIOUR, oldDriving_behaviour, newDriving_behaviour);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDriving_behaviour(Driving_Behaviour newDriving_behaviour) {
		if (newDriving_behaviour != driving_behaviour) {
			NotificationChain msgs = null;
			if (driving_behaviour != null)
				msgs = ((InternalEObject)driving_behaviour).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IntelligentMobilityPackage.DRIVER_PREFERENCE__DRIVING_BEHAVIOUR, null, msgs);
			if (newDriving_behaviour != null)
				msgs = ((InternalEObject)newDriving_behaviour).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IntelligentMobilityPackage.DRIVER_PREFERENCE__DRIVING_BEHAVIOUR, null, msgs);
			msgs = basicSetDriving_behaviour(newDriving_behaviour, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.DRIVER_PREFERENCE__DRIVING_BEHAVIOUR, newDriving_behaviour, newDriving_behaviour));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Environment_Condition getEnvironment_condition() {
		if (environment_condition != null && environment_condition.eIsProxy()) {
			InternalEObject oldEnvironment_condition = (InternalEObject)environment_condition;
			environment_condition = (Environment_Condition)eResolveProxy(oldEnvironment_condition);
			if (environment_condition != oldEnvironment_condition) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.DRIVER_PREFERENCE__ENVIRONMENT_CONDITION, oldEnvironment_condition, environment_condition));
			}
		}
		return environment_condition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Environment_Condition basicGetEnvironment_condition() {
		return environment_condition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnvironment_condition(Environment_Condition newEnvironment_condition) {
		Environment_Condition oldEnvironment_condition = environment_condition;
		environment_condition = newEnvironment_condition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.DRIVER_PREFERENCE__ENVIRONMENT_CONDITION, oldEnvironment_condition, environment_condition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case IntelligentMobilityPackage.DRIVER_PREFERENCE__DRIVER_EMOTIONS:
				return ((InternalEList)getDriver_emotions()).basicRemove(otherEnd, msgs);
			case IntelligentMobilityPackage.DRIVER_PREFERENCE__KNOWLEDGE_AND_SKILLS:
				return basicSetKnowledge_and_skills(null, msgs);
			case IntelligentMobilityPackage.DRIVER_PREFERENCE__DRIVING_BEHAVIOUR:
				return basicSetDriving_behaviour(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IntelligentMobilityPackage.DRIVER_PREFERENCE__DRIVER_EMOTIONS:
				return getDriver_emotions();
			case IntelligentMobilityPackage.DRIVER_PREFERENCE__KNOWLEDGE_AND_SKILLS:
				return getKnowledge_and_skills();
			case IntelligentMobilityPackage.DRIVER_PREFERENCE__NAME_PREFERENCE_SET:
				return getName_PreferenceSet();
			case IntelligentMobilityPackage.DRIVER_PREFERENCE__DRIVING_BEHAVIOUR:
				return getDriving_behaviour();
			case IntelligentMobilityPackage.DRIVER_PREFERENCE__ENVIRONMENT_CONDITION:
				if (resolve) return getEnvironment_condition();
				return basicGetEnvironment_condition();
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
			case IntelligentMobilityPackage.DRIVER_PREFERENCE__DRIVER_EMOTIONS:
				getDriver_emotions().clear();
				getDriver_emotions().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.DRIVER_PREFERENCE__KNOWLEDGE_AND_SKILLS:
				setKnowledge_and_skills((Knowledge_and_Skill)newValue);
				return;
			case IntelligentMobilityPackage.DRIVER_PREFERENCE__NAME_PREFERENCE_SET:
				setName_PreferenceSet((String)newValue);
				return;
			case IntelligentMobilityPackage.DRIVER_PREFERENCE__DRIVING_BEHAVIOUR:
				setDriving_behaviour((Driving_Behaviour)newValue);
				return;
			case IntelligentMobilityPackage.DRIVER_PREFERENCE__ENVIRONMENT_CONDITION:
				setEnvironment_condition((Environment_Condition)newValue);
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
			case IntelligentMobilityPackage.DRIVER_PREFERENCE__DRIVER_EMOTIONS:
				getDriver_emotions().clear();
				return;
			case IntelligentMobilityPackage.DRIVER_PREFERENCE__KNOWLEDGE_AND_SKILLS:
				setKnowledge_and_skills((Knowledge_and_Skill)null);
				return;
			case IntelligentMobilityPackage.DRIVER_PREFERENCE__NAME_PREFERENCE_SET:
				setName_PreferenceSet(NAME_PREFERENCE_SET_EDEFAULT);
				return;
			case IntelligentMobilityPackage.DRIVER_PREFERENCE__DRIVING_BEHAVIOUR:
				setDriving_behaviour((Driving_Behaviour)null);
				return;
			case IntelligentMobilityPackage.DRIVER_PREFERENCE__ENVIRONMENT_CONDITION:
				setEnvironment_condition((Environment_Condition)null);
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
			case IntelligentMobilityPackage.DRIVER_PREFERENCE__DRIVER_EMOTIONS:
				return driver_emotions != null && !driver_emotions.isEmpty();
			case IntelligentMobilityPackage.DRIVER_PREFERENCE__KNOWLEDGE_AND_SKILLS:
				return knowledge_and_skills != null;
			case IntelligentMobilityPackage.DRIVER_PREFERENCE__NAME_PREFERENCE_SET:
				return NAME_PREFERENCE_SET_EDEFAULT == null ? name_PreferenceSet != null : !NAME_PREFERENCE_SET_EDEFAULT.equals(name_PreferenceSet);
			case IntelligentMobilityPackage.DRIVER_PREFERENCE__DRIVING_BEHAVIOUR:
				return driving_behaviour != null;
			case IntelligentMobilityPackage.DRIVER_PREFERENCE__ENVIRONMENT_CONDITION:
				return environment_condition != null;
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
		result.append(" (name_PreferenceSet: ");
		result.append(name_PreferenceSet);
		result.append(')');
		return result.toString();
	}

} //Driver_PreferenceImpl
