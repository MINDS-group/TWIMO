/**
 */
package intelligentMobility.impl;

import intelligentMobility.Environment_Condition;
import intelligentMobility.IntelligentMobilityPackage;
import intelligentMobility.LaneChanging;
import intelligentMobility.Link_LaneChanging_EnvironmentCondition;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Link Lane Changing Environment Condition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.impl.Link_LaneChanging_EnvironmentConditionImpl#getName_link_laneChanging_environmentCondition <em>Name link lane Changing environment Condition</em>}</li>
 *   <li>{@link intelligentMobility.impl.Link_LaneChanging_EnvironmentConditionImpl#getLink_laneChanging <em>Link lane Changing</em>}</li>
 *   <li>{@link intelligentMobility.impl.Link_LaneChanging_EnvironmentConditionImpl#getLink_environmentCondition <em>Link environment Condition</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Link_LaneChanging_EnvironmentConditionImpl extends MinimalEObjectImpl.Container implements Link_LaneChanging_EnvironmentCondition {
	/**
	 * The default value of the '{@link #getName_link_laneChanging_environmentCondition() <em>Name link lane Changing environment Condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName_link_laneChanging_environmentCondition()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_LINK_LANE_CHANGING_ENVIRONMENT_CONDITION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName_link_laneChanging_environmentCondition() <em>Name link lane Changing environment Condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName_link_laneChanging_environmentCondition()
	 * @generated
	 * @ordered
	 */
	protected String name_link_laneChanging_environmentCondition = NAME_LINK_LANE_CHANGING_ENVIRONMENT_CONDITION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getLink_laneChanging() <em>Link lane Changing</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_laneChanging()
	 * @generated
	 * @ordered
	 */
	protected LaneChanging link_laneChanging;

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
	protected Link_LaneChanging_EnvironmentConditionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return IntelligentMobilityPackage.eINSTANCE.getLink_LaneChanging_EnvironmentCondition();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName_link_laneChanging_environmentCondition() {
		return name_link_laneChanging_environmentCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName_link_laneChanging_environmentCondition(String newName_link_laneChanging_environmentCondition) {
		String oldName_link_laneChanging_environmentCondition = name_link_laneChanging_environmentCondition;
		name_link_laneChanging_environmentCondition = newName_link_laneChanging_environmentCondition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_LANE_CHANGING_ENVIRONMENT_CONDITION__NAME_LINK_LANE_CHANGING_ENVIRONMENT_CONDITION, oldName_link_laneChanging_environmentCondition, name_link_laneChanging_environmentCondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LaneChanging getLink_laneChanging() {
		if (link_laneChanging != null && link_laneChanging.eIsProxy()) {
			InternalEObject oldLink_laneChanging = (InternalEObject)link_laneChanging;
			link_laneChanging = (LaneChanging)eResolveProxy(oldLink_laneChanging);
			if (link_laneChanging != oldLink_laneChanging) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LINK_LANE_CHANGING_ENVIRONMENT_CONDITION__LINK_LANE_CHANGING, oldLink_laneChanging, link_laneChanging));
			}
		}
		return link_laneChanging;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LaneChanging basicGetLink_laneChanging() {
		return link_laneChanging;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLink_laneChanging(LaneChanging newLink_laneChanging) {
		LaneChanging oldLink_laneChanging = link_laneChanging;
		link_laneChanging = newLink_laneChanging;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_LANE_CHANGING_ENVIRONMENT_CONDITION__LINK_LANE_CHANGING, oldLink_laneChanging, link_laneChanging));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LINK_LANE_CHANGING_ENVIRONMENT_CONDITION__LINK_ENVIRONMENT_CONDITION, oldLink_environmentCondition, link_environmentCondition));
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
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_LANE_CHANGING_ENVIRONMENT_CONDITION__LINK_ENVIRONMENT_CONDITION, oldLink_environmentCondition, link_environmentCondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IntelligentMobilityPackage.LINK_LANE_CHANGING_ENVIRONMENT_CONDITION__NAME_LINK_LANE_CHANGING_ENVIRONMENT_CONDITION:
				return getName_link_laneChanging_environmentCondition();
			case IntelligentMobilityPackage.LINK_LANE_CHANGING_ENVIRONMENT_CONDITION__LINK_LANE_CHANGING:
				if (resolve) return getLink_laneChanging();
				return basicGetLink_laneChanging();
			case IntelligentMobilityPackage.LINK_LANE_CHANGING_ENVIRONMENT_CONDITION__LINK_ENVIRONMENT_CONDITION:
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
			case IntelligentMobilityPackage.LINK_LANE_CHANGING_ENVIRONMENT_CONDITION__NAME_LINK_LANE_CHANGING_ENVIRONMENT_CONDITION:
				setName_link_laneChanging_environmentCondition((String)newValue);
				return;
			case IntelligentMobilityPackage.LINK_LANE_CHANGING_ENVIRONMENT_CONDITION__LINK_LANE_CHANGING:
				setLink_laneChanging((LaneChanging)newValue);
				return;
			case IntelligentMobilityPackage.LINK_LANE_CHANGING_ENVIRONMENT_CONDITION__LINK_ENVIRONMENT_CONDITION:
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
			case IntelligentMobilityPackage.LINK_LANE_CHANGING_ENVIRONMENT_CONDITION__NAME_LINK_LANE_CHANGING_ENVIRONMENT_CONDITION:
				setName_link_laneChanging_environmentCondition(NAME_LINK_LANE_CHANGING_ENVIRONMENT_CONDITION_EDEFAULT);
				return;
			case IntelligentMobilityPackage.LINK_LANE_CHANGING_ENVIRONMENT_CONDITION__LINK_LANE_CHANGING:
				setLink_laneChanging((LaneChanging)null);
				return;
			case IntelligentMobilityPackage.LINK_LANE_CHANGING_ENVIRONMENT_CONDITION__LINK_ENVIRONMENT_CONDITION:
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
			case IntelligentMobilityPackage.LINK_LANE_CHANGING_ENVIRONMENT_CONDITION__NAME_LINK_LANE_CHANGING_ENVIRONMENT_CONDITION:
				return NAME_LINK_LANE_CHANGING_ENVIRONMENT_CONDITION_EDEFAULT == null ? name_link_laneChanging_environmentCondition != null : !NAME_LINK_LANE_CHANGING_ENVIRONMENT_CONDITION_EDEFAULT.equals(name_link_laneChanging_environmentCondition);
			case IntelligentMobilityPackage.LINK_LANE_CHANGING_ENVIRONMENT_CONDITION__LINK_LANE_CHANGING:
				return link_laneChanging != null;
			case IntelligentMobilityPackage.LINK_LANE_CHANGING_ENVIRONMENT_CONDITION__LINK_ENVIRONMENT_CONDITION:
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
		result.append(" (name_link_laneChanging_environmentCondition: ");
		result.append(name_link_laneChanging_environmentCondition);
		result.append(')');
		return result.toString();
	}

} //Link_LaneChanging_EnvironmentConditionImpl
