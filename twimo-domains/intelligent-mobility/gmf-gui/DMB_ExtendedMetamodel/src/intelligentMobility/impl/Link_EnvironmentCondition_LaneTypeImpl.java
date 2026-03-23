/**
 */
package intelligentMobility.impl;

import intelligentMobility.Environment_Condition;
import intelligentMobility.IntelligentMobilityPackage;
import intelligentMobility.Lane_Type;
import intelligentMobility.Link_EnvironmentCondition_LaneType;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Link Environment Condition Lane Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.impl.Link_EnvironmentCondition_LaneTypeImpl#getName_link_environmentCondition_laneType <em>Name link environment Condition lane Type</em>}</li>
 *   <li>{@link intelligentMobility.impl.Link_EnvironmentCondition_LaneTypeImpl#getLink_environmentCondition <em>Link environment Condition</em>}</li>
 *   <li>{@link intelligentMobility.impl.Link_EnvironmentCondition_LaneTypeImpl#getLink_laneType <em>Link lane Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Link_EnvironmentCondition_LaneTypeImpl extends MinimalEObjectImpl.Container implements Link_EnvironmentCondition_LaneType {
	/**
	 * The default value of the '{@link #getName_link_environmentCondition_laneType() <em>Name link environment Condition lane Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName_link_environmentCondition_laneType()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_LINK_ENVIRONMENT_CONDITION_LANE_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName_link_environmentCondition_laneType() <em>Name link environment Condition lane Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName_link_environmentCondition_laneType()
	 * @generated
	 * @ordered
	 */
	protected String name_link_environmentCondition_laneType = NAME_LINK_ENVIRONMENT_CONDITION_LANE_TYPE_EDEFAULT;

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
	 * The cached value of the '{@link #getLink_laneType() <em>Link lane Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_laneType()
	 * @generated
	 * @ordered
	 */
	protected Lane_Type link_laneType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Link_EnvironmentCondition_LaneTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return IntelligentMobilityPackage.eINSTANCE.getLink_EnvironmentCondition_LaneType();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName_link_environmentCondition_laneType() {
		return name_link_environmentCondition_laneType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName_link_environmentCondition_laneType(String newName_link_environmentCondition_laneType) {
		String oldName_link_environmentCondition_laneType = name_link_environmentCondition_laneType;
		name_link_environmentCondition_laneType = newName_link_environmentCondition_laneType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_ENVIRONMENT_CONDITION_LANE_TYPE__NAME_LINK_ENVIRONMENT_CONDITION_LANE_TYPE, oldName_link_environmentCondition_laneType, name_link_environmentCondition_laneType));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LINK_ENVIRONMENT_CONDITION_LANE_TYPE__LINK_ENVIRONMENT_CONDITION, oldLink_environmentCondition, link_environmentCondition));
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
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_ENVIRONMENT_CONDITION_LANE_TYPE__LINK_ENVIRONMENT_CONDITION, oldLink_environmentCondition, link_environmentCondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Lane_Type getLink_laneType() {
		if (link_laneType != null && link_laneType.eIsProxy()) {
			InternalEObject oldLink_laneType = (InternalEObject)link_laneType;
			link_laneType = (Lane_Type)eResolveProxy(oldLink_laneType);
			if (link_laneType != oldLink_laneType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LINK_ENVIRONMENT_CONDITION_LANE_TYPE__LINK_LANE_TYPE, oldLink_laneType, link_laneType));
			}
		}
		return link_laneType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Lane_Type basicGetLink_laneType() {
		return link_laneType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLink_laneType(Lane_Type newLink_laneType) {
		Lane_Type oldLink_laneType = link_laneType;
		link_laneType = newLink_laneType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_ENVIRONMENT_CONDITION_LANE_TYPE__LINK_LANE_TYPE, oldLink_laneType, link_laneType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IntelligentMobilityPackage.LINK_ENVIRONMENT_CONDITION_LANE_TYPE__NAME_LINK_ENVIRONMENT_CONDITION_LANE_TYPE:
				return getName_link_environmentCondition_laneType();
			case IntelligentMobilityPackage.LINK_ENVIRONMENT_CONDITION_LANE_TYPE__LINK_ENVIRONMENT_CONDITION:
				if (resolve) return getLink_environmentCondition();
				return basicGetLink_environmentCondition();
			case IntelligentMobilityPackage.LINK_ENVIRONMENT_CONDITION_LANE_TYPE__LINK_LANE_TYPE:
				if (resolve) return getLink_laneType();
				return basicGetLink_laneType();
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
			case IntelligentMobilityPackage.LINK_ENVIRONMENT_CONDITION_LANE_TYPE__NAME_LINK_ENVIRONMENT_CONDITION_LANE_TYPE:
				setName_link_environmentCondition_laneType((String)newValue);
				return;
			case IntelligentMobilityPackage.LINK_ENVIRONMENT_CONDITION_LANE_TYPE__LINK_ENVIRONMENT_CONDITION:
				setLink_environmentCondition((Environment_Condition)newValue);
				return;
			case IntelligentMobilityPackage.LINK_ENVIRONMENT_CONDITION_LANE_TYPE__LINK_LANE_TYPE:
				setLink_laneType((Lane_Type)newValue);
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
			case IntelligentMobilityPackage.LINK_ENVIRONMENT_CONDITION_LANE_TYPE__NAME_LINK_ENVIRONMENT_CONDITION_LANE_TYPE:
				setName_link_environmentCondition_laneType(NAME_LINK_ENVIRONMENT_CONDITION_LANE_TYPE_EDEFAULT);
				return;
			case IntelligentMobilityPackage.LINK_ENVIRONMENT_CONDITION_LANE_TYPE__LINK_ENVIRONMENT_CONDITION:
				setLink_environmentCondition((Environment_Condition)null);
				return;
			case IntelligentMobilityPackage.LINK_ENVIRONMENT_CONDITION_LANE_TYPE__LINK_LANE_TYPE:
				setLink_laneType((Lane_Type)null);
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
			case IntelligentMobilityPackage.LINK_ENVIRONMENT_CONDITION_LANE_TYPE__NAME_LINK_ENVIRONMENT_CONDITION_LANE_TYPE:
				return NAME_LINK_ENVIRONMENT_CONDITION_LANE_TYPE_EDEFAULT == null ? name_link_environmentCondition_laneType != null : !NAME_LINK_ENVIRONMENT_CONDITION_LANE_TYPE_EDEFAULT.equals(name_link_environmentCondition_laneType);
			case IntelligentMobilityPackage.LINK_ENVIRONMENT_CONDITION_LANE_TYPE__LINK_ENVIRONMENT_CONDITION:
				return link_environmentCondition != null;
			case IntelligentMobilityPackage.LINK_ENVIRONMENT_CONDITION_LANE_TYPE__LINK_LANE_TYPE:
				return link_laneType != null;
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
		result.append(" (name_link_environmentCondition_laneType: ");
		result.append(name_link_environmentCondition_laneType);
		result.append(')');
		return result.toString();
	}

} //Link_EnvironmentCondition_LaneTypeImpl
