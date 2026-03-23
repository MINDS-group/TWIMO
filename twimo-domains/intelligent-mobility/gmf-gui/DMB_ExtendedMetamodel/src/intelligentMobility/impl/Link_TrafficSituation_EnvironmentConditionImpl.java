/**
 */
package intelligentMobility.impl;

import intelligentMobility.Environment_Condition;
import intelligentMobility.IntelligentMobilityPackage;
import intelligentMobility.Link_TrafficSituation_EnvironmentCondition;
import intelligentMobility.Traffic_Situation;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Link Traffic Situation Environment Condition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.impl.Link_TrafficSituation_EnvironmentConditionImpl#getName_link_trafficSituation_environmentCondition <em>Name link traffic Situation environment Condition</em>}</li>
 *   <li>{@link intelligentMobility.impl.Link_TrafficSituation_EnvironmentConditionImpl#getLink_trafficSituation <em>Link traffic Situation</em>}</li>
 *   <li>{@link intelligentMobility.impl.Link_TrafficSituation_EnvironmentConditionImpl#getLink_environmentCondition <em>Link environment Condition</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Link_TrafficSituation_EnvironmentConditionImpl extends MinimalEObjectImpl.Container implements Link_TrafficSituation_EnvironmentCondition {
	/**
	 * The default value of the '{@link #getName_link_trafficSituation_environmentCondition() <em>Name link traffic Situation environment Condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName_link_trafficSituation_environmentCondition()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_LINK_TRAFFIC_SITUATION_ENVIRONMENT_CONDITION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName_link_trafficSituation_environmentCondition() <em>Name link traffic Situation environment Condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName_link_trafficSituation_environmentCondition()
	 * @generated
	 * @ordered
	 */
	protected String name_link_trafficSituation_environmentCondition = NAME_LINK_TRAFFIC_SITUATION_ENVIRONMENT_CONDITION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getLink_trafficSituation() <em>Link traffic Situation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_trafficSituation()
	 * @generated
	 * @ordered
	 */
	protected Traffic_Situation link_trafficSituation;

	/**
	 * The cached value of the '{@link #getLink_environmentCondition() <em>Link environment Condition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_environmentCondition()
	 * @generated
	 * @ordered
	 */
	protected Environment_Condition link_environmentCondition;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Link_TrafficSituation_EnvironmentConditionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return IntelligentMobilityPackage.eINSTANCE.getLink_TrafficSituation_EnvironmentCondition();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName_link_trafficSituation_environmentCondition() {
		return name_link_trafficSituation_environmentCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName_link_trafficSituation_environmentCondition(String newName_link_trafficSituation_environmentCondition) {
		String oldName_link_trafficSituation_environmentCondition = name_link_trafficSituation_environmentCondition;
		name_link_trafficSituation_environmentCondition = newName_link_trafficSituation_environmentCondition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_TRAFFIC_SITUATION_ENVIRONMENT_CONDITION__NAME_LINK_TRAFFIC_SITUATION_ENVIRONMENT_CONDITION, oldName_link_trafficSituation_environmentCondition, name_link_trafficSituation_environmentCondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Traffic_Situation getLink_trafficSituation() {
		if (link_trafficSituation != null && link_trafficSituation.eIsProxy()) {
			InternalEObject oldLink_trafficSituation = (InternalEObject)link_trafficSituation;
			link_trafficSituation = (Traffic_Situation)eResolveProxy(oldLink_trafficSituation);
			if (link_trafficSituation != oldLink_trafficSituation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LINK_TRAFFIC_SITUATION_ENVIRONMENT_CONDITION__LINK_TRAFFIC_SITUATION, oldLink_trafficSituation, link_trafficSituation));
			}
		}
		return link_trafficSituation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Traffic_Situation basicGetLink_trafficSituation() {
		return link_trafficSituation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLink_trafficSituation(Traffic_Situation newLink_trafficSituation) {
		Traffic_Situation oldLink_trafficSituation = link_trafficSituation;
		link_trafficSituation = newLink_trafficSituation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_TRAFFIC_SITUATION_ENVIRONMENT_CONDITION__LINK_TRAFFIC_SITUATION, oldLink_trafficSituation, link_trafficSituation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Environment_Condition getLink_environmentCondition() {
		if (link_environmentCondition != null && link_environmentCondition.eIsProxy()) {
			InternalEObject oldLink_environmentCondition = (InternalEObject)link_environmentCondition;
			link_environmentCondition = (Environment_Condition)eResolveProxy(oldLink_environmentCondition);
			if (link_environmentCondition != oldLink_environmentCondition) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LINK_TRAFFIC_SITUATION_ENVIRONMENT_CONDITION__LINK_ENVIRONMENT_CONDITION, oldLink_environmentCondition, link_environmentCondition));
			}
		}
		return link_environmentCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Environment_Condition basicGetLink_environmentCondition() {
		return link_environmentCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLink_environmentCondition(Environment_Condition newLink_environmentCondition) {
		Environment_Condition oldLink_environmentCondition = link_environmentCondition;
		link_environmentCondition = newLink_environmentCondition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_TRAFFIC_SITUATION_ENVIRONMENT_CONDITION__LINK_ENVIRONMENT_CONDITION, oldLink_environmentCondition, link_environmentCondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IntelligentMobilityPackage.LINK_TRAFFIC_SITUATION_ENVIRONMENT_CONDITION__NAME_LINK_TRAFFIC_SITUATION_ENVIRONMENT_CONDITION:
				return getName_link_trafficSituation_environmentCondition();
			case IntelligentMobilityPackage.LINK_TRAFFIC_SITUATION_ENVIRONMENT_CONDITION__LINK_TRAFFIC_SITUATION:
				if (resolve) return getLink_trafficSituation();
				return basicGetLink_trafficSituation();
			case IntelligentMobilityPackage.LINK_TRAFFIC_SITUATION_ENVIRONMENT_CONDITION__LINK_ENVIRONMENT_CONDITION:
				if (resolve) return getLink_environmentCondition();
				return basicGetLink_environmentCondition();
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
			case IntelligentMobilityPackage.LINK_TRAFFIC_SITUATION_ENVIRONMENT_CONDITION__NAME_LINK_TRAFFIC_SITUATION_ENVIRONMENT_CONDITION:
				setName_link_trafficSituation_environmentCondition((String)newValue);
				return;
			case IntelligentMobilityPackage.LINK_TRAFFIC_SITUATION_ENVIRONMENT_CONDITION__LINK_TRAFFIC_SITUATION:
				setLink_trafficSituation((Traffic_Situation)newValue);
				return;
			case IntelligentMobilityPackage.LINK_TRAFFIC_SITUATION_ENVIRONMENT_CONDITION__LINK_ENVIRONMENT_CONDITION:
				setLink_environmentCondition((Environment_Condition)newValue);
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
			case IntelligentMobilityPackage.LINK_TRAFFIC_SITUATION_ENVIRONMENT_CONDITION__NAME_LINK_TRAFFIC_SITUATION_ENVIRONMENT_CONDITION:
				setName_link_trafficSituation_environmentCondition(NAME_LINK_TRAFFIC_SITUATION_ENVIRONMENT_CONDITION_EDEFAULT);
				return;
			case IntelligentMobilityPackage.LINK_TRAFFIC_SITUATION_ENVIRONMENT_CONDITION__LINK_TRAFFIC_SITUATION:
				setLink_trafficSituation((Traffic_Situation)null);
				return;
			case IntelligentMobilityPackage.LINK_TRAFFIC_SITUATION_ENVIRONMENT_CONDITION__LINK_ENVIRONMENT_CONDITION:
				setLink_environmentCondition((Environment_Condition)null);
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
			case IntelligentMobilityPackage.LINK_TRAFFIC_SITUATION_ENVIRONMENT_CONDITION__NAME_LINK_TRAFFIC_SITUATION_ENVIRONMENT_CONDITION:
				return NAME_LINK_TRAFFIC_SITUATION_ENVIRONMENT_CONDITION_EDEFAULT == null ? name_link_trafficSituation_environmentCondition != null : !NAME_LINK_TRAFFIC_SITUATION_ENVIRONMENT_CONDITION_EDEFAULT.equals(name_link_trafficSituation_environmentCondition);
			case IntelligentMobilityPackage.LINK_TRAFFIC_SITUATION_ENVIRONMENT_CONDITION__LINK_TRAFFIC_SITUATION:
				return link_trafficSituation != null;
			case IntelligentMobilityPackage.LINK_TRAFFIC_SITUATION_ENVIRONMENT_CONDITION__LINK_ENVIRONMENT_CONDITION:
				return link_environmentCondition != null;
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
		result.append(" (name_link_trafficSituation_environmentCondition: ");
		result.append(name_link_trafficSituation_environmentCondition);
		result.append(')');
		return result.toString();
	}

} //Link_TrafficSituation_EnvironmentConditionImpl
