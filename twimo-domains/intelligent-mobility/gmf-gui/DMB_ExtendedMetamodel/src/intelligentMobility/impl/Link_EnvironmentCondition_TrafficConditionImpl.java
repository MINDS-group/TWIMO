/**
 */
package intelligentMobility.impl;

import intelligentMobility.Environment_Condition;
import intelligentMobility.IntelligentMobilityPackage;
import intelligentMobility.Link_EnvironmentCondition_TrafficCondition;
import intelligentMobility.Traffic_Situation;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Link Environment Condition Traffic Condition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.impl.Link_EnvironmentCondition_TrafficConditionImpl#getName_link_environmentCondition_trafficCondition <em>Name link environment Condition traffic Condition</em>}</li>
 *   <li>{@link intelligentMobility.impl.Link_EnvironmentCondition_TrafficConditionImpl#getLink_environmentCondition <em>Link environment Condition</em>}</li>
 *   <li>{@link intelligentMobility.impl.Link_EnvironmentCondition_TrafficConditionImpl#getLink_trafficCondition <em>Link traffic Condition</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Link_EnvironmentCondition_TrafficConditionImpl extends MinimalEObjectImpl.Container implements Link_EnvironmentCondition_TrafficCondition {
	/**
	 * The default value of the '{@link #getName_link_environmentCondition_trafficCondition() <em>Name link environment Condition traffic Condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName_link_environmentCondition_trafficCondition()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_LINK_ENVIRONMENT_CONDITION_TRAFFIC_CONDITION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName_link_environmentCondition_trafficCondition() <em>Name link environment Condition traffic Condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName_link_environmentCondition_trafficCondition()
	 * @generated
	 * @ordered
	 */
	protected String name_link_environmentCondition_trafficCondition = NAME_LINK_ENVIRONMENT_CONDITION_TRAFFIC_CONDITION_EDEFAULT;

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
	 * The cached value of the '{@link #getLink_trafficCondition() <em>Link traffic Condition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_trafficCondition()
	 * @generated
	 * @ordered
	 */
	protected Traffic_Situation link_trafficCondition;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Link_EnvironmentCondition_TrafficConditionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return IntelligentMobilityPackage.eINSTANCE.getLink_EnvironmentCondition_TrafficCondition();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName_link_environmentCondition_trafficCondition() {
		return name_link_environmentCondition_trafficCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName_link_environmentCondition_trafficCondition(String newName_link_environmentCondition_trafficCondition) {
		String oldName_link_environmentCondition_trafficCondition = name_link_environmentCondition_trafficCondition;
		name_link_environmentCondition_trafficCondition = newName_link_environmentCondition_trafficCondition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_ENVIRONMENT_CONDITION_TRAFFIC_CONDITION__NAME_LINK_ENVIRONMENT_CONDITION_TRAFFIC_CONDITION, oldName_link_environmentCondition_trafficCondition, name_link_environmentCondition_trafficCondition));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LINK_ENVIRONMENT_CONDITION_TRAFFIC_CONDITION__LINK_ENVIRONMENT_CONDITION, oldLink_environmentCondition, link_environmentCondition));
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
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_ENVIRONMENT_CONDITION_TRAFFIC_CONDITION__LINK_ENVIRONMENT_CONDITION, oldLink_environmentCondition, link_environmentCondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Traffic_Situation getLink_trafficCondition() {
		if (link_trafficCondition != null && link_trafficCondition.eIsProxy()) {
			InternalEObject oldLink_trafficCondition = (InternalEObject)link_trafficCondition;
			link_trafficCondition = (Traffic_Situation)eResolveProxy(oldLink_trafficCondition);
			if (link_trafficCondition != oldLink_trafficCondition) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LINK_ENVIRONMENT_CONDITION_TRAFFIC_CONDITION__LINK_TRAFFIC_CONDITION, oldLink_trafficCondition, link_trafficCondition));
			}
		}
		return link_trafficCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Traffic_Situation basicGetLink_trafficCondition() {
		return link_trafficCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLink_trafficCondition(Traffic_Situation newLink_trafficCondition) {
		Traffic_Situation oldLink_trafficCondition = link_trafficCondition;
		link_trafficCondition = newLink_trafficCondition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_ENVIRONMENT_CONDITION_TRAFFIC_CONDITION__LINK_TRAFFIC_CONDITION, oldLink_trafficCondition, link_trafficCondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IntelligentMobilityPackage.LINK_ENVIRONMENT_CONDITION_TRAFFIC_CONDITION__NAME_LINK_ENVIRONMENT_CONDITION_TRAFFIC_CONDITION:
				return getName_link_environmentCondition_trafficCondition();
			case IntelligentMobilityPackage.LINK_ENVIRONMENT_CONDITION_TRAFFIC_CONDITION__LINK_ENVIRONMENT_CONDITION:
				if (resolve) return getLink_environmentCondition();
				return basicGetLink_environmentCondition();
			case IntelligentMobilityPackage.LINK_ENVIRONMENT_CONDITION_TRAFFIC_CONDITION__LINK_TRAFFIC_CONDITION:
				if (resolve) return getLink_trafficCondition();
				return basicGetLink_trafficCondition();
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
			case IntelligentMobilityPackage.LINK_ENVIRONMENT_CONDITION_TRAFFIC_CONDITION__NAME_LINK_ENVIRONMENT_CONDITION_TRAFFIC_CONDITION:
				setName_link_environmentCondition_trafficCondition((String)newValue);
				return;
			case IntelligentMobilityPackage.LINK_ENVIRONMENT_CONDITION_TRAFFIC_CONDITION__LINK_ENVIRONMENT_CONDITION:
				setLink_environmentCondition((Environment_Condition)newValue);
				return;
			case IntelligentMobilityPackage.LINK_ENVIRONMENT_CONDITION_TRAFFIC_CONDITION__LINK_TRAFFIC_CONDITION:
				setLink_trafficCondition((Traffic_Situation)newValue);
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
			case IntelligentMobilityPackage.LINK_ENVIRONMENT_CONDITION_TRAFFIC_CONDITION__NAME_LINK_ENVIRONMENT_CONDITION_TRAFFIC_CONDITION:
				setName_link_environmentCondition_trafficCondition(NAME_LINK_ENVIRONMENT_CONDITION_TRAFFIC_CONDITION_EDEFAULT);
				return;
			case IntelligentMobilityPackage.LINK_ENVIRONMENT_CONDITION_TRAFFIC_CONDITION__LINK_ENVIRONMENT_CONDITION:
				setLink_environmentCondition((Environment_Condition)null);
				return;
			case IntelligentMobilityPackage.LINK_ENVIRONMENT_CONDITION_TRAFFIC_CONDITION__LINK_TRAFFIC_CONDITION:
				setLink_trafficCondition((Traffic_Situation)null);
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
			case IntelligentMobilityPackage.LINK_ENVIRONMENT_CONDITION_TRAFFIC_CONDITION__NAME_LINK_ENVIRONMENT_CONDITION_TRAFFIC_CONDITION:
				return NAME_LINK_ENVIRONMENT_CONDITION_TRAFFIC_CONDITION_EDEFAULT == null ? name_link_environmentCondition_trafficCondition != null : !NAME_LINK_ENVIRONMENT_CONDITION_TRAFFIC_CONDITION_EDEFAULT.equals(name_link_environmentCondition_trafficCondition);
			case IntelligentMobilityPackage.LINK_ENVIRONMENT_CONDITION_TRAFFIC_CONDITION__LINK_ENVIRONMENT_CONDITION:
				return link_environmentCondition != null;
			case IntelligentMobilityPackage.LINK_ENVIRONMENT_CONDITION_TRAFFIC_CONDITION__LINK_TRAFFIC_CONDITION:
				return link_trafficCondition != null;
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
		result.append(" (name_link_environmentCondition_trafficCondition: ");
		result.append(name_link_environmentCondition_trafficCondition);
		result.append(')');
		return result.toString();
	}

} //Link_EnvironmentCondition_TrafficConditionImpl
