/**
 */
package intelligentMobility.impl;

import intelligentMobility.IntelligentMobilityPackage;
import intelligentMobility.LaneChanging;
import intelligentMobility.Link_NormalBehaviour_LaneChanging;
import intelligentMobility.Normal_Behaviour;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Link Normal Behaviour Lane Changing</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.impl.Link_NormalBehaviour_LaneChangingImpl#getName_link_behaviour_laneChanging <em>Name link behaviour lane Changing</em>}</li>
 *   <li>{@link intelligentMobility.impl.Link_NormalBehaviour_LaneChangingImpl#getLink_normal_behaviour <em>Link normal behaviour</em>}</li>
 *   <li>{@link intelligentMobility.impl.Link_NormalBehaviour_LaneChangingImpl#getLink_lane_changing <em>Link lane changing</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Link_NormalBehaviour_LaneChangingImpl extends MinimalEObjectImpl.Container implements Link_NormalBehaviour_LaneChanging {
	/**
	 * The default value of the '{@link #getName_link_behaviour_laneChanging() <em>Name link behaviour lane Changing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName_link_behaviour_laneChanging()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_LINK_BEHAVIOUR_LANE_CHANGING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName_link_behaviour_laneChanging() <em>Name link behaviour lane Changing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName_link_behaviour_laneChanging()
	 * @generated
	 * @ordered
	 */
	protected String name_link_behaviour_laneChanging = NAME_LINK_BEHAVIOUR_LANE_CHANGING_EDEFAULT;

	/**
	 * The cached value of the '{@link #getLink_normal_behaviour() <em>Link normal behaviour</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_normal_behaviour()
	 * @generated
	 * @ordered
	 */
	protected Normal_Behaviour link_normal_behaviour;

	/**
	 * The cached value of the '{@link #getLink_lane_changing() <em>Link lane changing</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_lane_changing()
	 * @generated
	 * @ordered
	 */
	protected LaneChanging link_lane_changing;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Link_NormalBehaviour_LaneChangingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return IntelligentMobilityPackage.eINSTANCE.getLink_NormalBehaviour_LaneChanging();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName_link_behaviour_laneChanging() {
		return name_link_behaviour_laneChanging;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName_link_behaviour_laneChanging(String newName_link_behaviour_laneChanging) {
		String oldName_link_behaviour_laneChanging = name_link_behaviour_laneChanging;
		name_link_behaviour_laneChanging = newName_link_behaviour_laneChanging;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_NORMAL_BEHAVIOUR_LANE_CHANGING__NAME_LINK_BEHAVIOUR_LANE_CHANGING, oldName_link_behaviour_laneChanging, name_link_behaviour_laneChanging));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Normal_Behaviour getLink_normal_behaviour() {
		if (link_normal_behaviour != null && link_normal_behaviour.eIsProxy()) {
			InternalEObject oldLink_normal_behaviour = (InternalEObject)link_normal_behaviour;
			link_normal_behaviour = (Normal_Behaviour)eResolveProxy(oldLink_normal_behaviour);
			if (link_normal_behaviour != oldLink_normal_behaviour) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LINK_NORMAL_BEHAVIOUR_LANE_CHANGING__LINK_NORMAL_BEHAVIOUR, oldLink_normal_behaviour, link_normal_behaviour));
			}
		}
		return link_normal_behaviour;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Normal_Behaviour basicGetLink_normal_behaviour() {
		return link_normal_behaviour;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLink_normal_behaviour(Normal_Behaviour newLink_normal_behaviour) {
		Normal_Behaviour oldLink_normal_behaviour = link_normal_behaviour;
		link_normal_behaviour = newLink_normal_behaviour;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_NORMAL_BEHAVIOUR_LANE_CHANGING__LINK_NORMAL_BEHAVIOUR, oldLink_normal_behaviour, link_normal_behaviour));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LaneChanging getLink_lane_changing() {
		if (link_lane_changing != null && link_lane_changing.eIsProxy()) {
			InternalEObject oldLink_lane_changing = (InternalEObject)link_lane_changing;
			link_lane_changing = (LaneChanging)eResolveProxy(oldLink_lane_changing);
			if (link_lane_changing != oldLink_lane_changing) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LINK_NORMAL_BEHAVIOUR_LANE_CHANGING__LINK_LANE_CHANGING, oldLink_lane_changing, link_lane_changing));
			}
		}
		return link_lane_changing;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LaneChanging basicGetLink_lane_changing() {
		return link_lane_changing;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLink_lane_changing(LaneChanging newLink_lane_changing) {
		LaneChanging oldLink_lane_changing = link_lane_changing;
		link_lane_changing = newLink_lane_changing;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_NORMAL_BEHAVIOUR_LANE_CHANGING__LINK_LANE_CHANGING, oldLink_lane_changing, link_lane_changing));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IntelligentMobilityPackage.LINK_NORMAL_BEHAVIOUR_LANE_CHANGING__NAME_LINK_BEHAVIOUR_LANE_CHANGING:
				return getName_link_behaviour_laneChanging();
			case IntelligentMobilityPackage.LINK_NORMAL_BEHAVIOUR_LANE_CHANGING__LINK_NORMAL_BEHAVIOUR:
				if (resolve) return getLink_normal_behaviour();
				return basicGetLink_normal_behaviour();
			case IntelligentMobilityPackage.LINK_NORMAL_BEHAVIOUR_LANE_CHANGING__LINK_LANE_CHANGING:
				if (resolve) return getLink_lane_changing();
				return basicGetLink_lane_changing();
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
			case IntelligentMobilityPackage.LINK_NORMAL_BEHAVIOUR_LANE_CHANGING__NAME_LINK_BEHAVIOUR_LANE_CHANGING:
				setName_link_behaviour_laneChanging((String)newValue);
				return;
			case IntelligentMobilityPackage.LINK_NORMAL_BEHAVIOUR_LANE_CHANGING__LINK_NORMAL_BEHAVIOUR:
				setLink_normal_behaviour((Normal_Behaviour)newValue);
				return;
			case IntelligentMobilityPackage.LINK_NORMAL_BEHAVIOUR_LANE_CHANGING__LINK_LANE_CHANGING:
				setLink_lane_changing((LaneChanging)newValue);
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
			case IntelligentMobilityPackage.LINK_NORMAL_BEHAVIOUR_LANE_CHANGING__NAME_LINK_BEHAVIOUR_LANE_CHANGING:
				setName_link_behaviour_laneChanging(NAME_LINK_BEHAVIOUR_LANE_CHANGING_EDEFAULT);
				return;
			case IntelligentMobilityPackage.LINK_NORMAL_BEHAVIOUR_LANE_CHANGING__LINK_NORMAL_BEHAVIOUR:
				setLink_normal_behaviour((Normal_Behaviour)null);
				return;
			case IntelligentMobilityPackage.LINK_NORMAL_BEHAVIOUR_LANE_CHANGING__LINK_LANE_CHANGING:
				setLink_lane_changing((LaneChanging)null);
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
			case IntelligentMobilityPackage.LINK_NORMAL_BEHAVIOUR_LANE_CHANGING__NAME_LINK_BEHAVIOUR_LANE_CHANGING:
				return NAME_LINK_BEHAVIOUR_LANE_CHANGING_EDEFAULT == null ? name_link_behaviour_laneChanging != null : !NAME_LINK_BEHAVIOUR_LANE_CHANGING_EDEFAULT.equals(name_link_behaviour_laneChanging);
			case IntelligentMobilityPackage.LINK_NORMAL_BEHAVIOUR_LANE_CHANGING__LINK_NORMAL_BEHAVIOUR:
				return link_normal_behaviour != null;
			case IntelligentMobilityPackage.LINK_NORMAL_BEHAVIOUR_LANE_CHANGING__LINK_LANE_CHANGING:
				return link_lane_changing != null;
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
		result.append(" (name_link_behaviour_laneChanging: ");
		result.append(name_link_behaviour_laneChanging);
		result.append(')');
		return result.toString();
	}

} //Link_NormalBehaviour_LaneChangingImpl
