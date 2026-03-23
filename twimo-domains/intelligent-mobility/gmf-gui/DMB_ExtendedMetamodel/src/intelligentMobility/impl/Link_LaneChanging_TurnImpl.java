/**
 */
package intelligentMobility.impl;

import intelligentMobility.IntelligentMobilityPackage;
import intelligentMobility.LaneChanging;
import intelligentMobility.Link_LaneChanging_Turn;
import intelligentMobility.Turn;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Link Lane Changing Turn</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.impl.Link_LaneChanging_TurnImpl#getName_link_laneChanging_turn <em>Name link lane Changing turn</em>}</li>
 *   <li>{@link intelligentMobility.impl.Link_LaneChanging_TurnImpl#getLink_laneChanging <em>Link lane Changing</em>}</li>
 *   <li>{@link intelligentMobility.impl.Link_LaneChanging_TurnImpl#getLink_turn <em>Link turn</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Link_LaneChanging_TurnImpl extends MinimalEObjectImpl.Container implements Link_LaneChanging_Turn {
	/**
	 * The default value of the '{@link #getName_link_laneChanging_turn() <em>Name link lane Changing turn</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName_link_laneChanging_turn()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_LINK_LANE_CHANGING_TURN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName_link_laneChanging_turn() <em>Name link lane Changing turn</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName_link_laneChanging_turn()
	 * @generated
	 * @ordered
	 */
	protected String name_link_laneChanging_turn = NAME_LINK_LANE_CHANGING_TURN_EDEFAULT;

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
	 * The cached value of the '{@link #getLink_turn() <em>Link turn</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_turn()
	 * @generated
	 * @ordered
	 */
	protected Turn link_turn;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Link_LaneChanging_TurnImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return IntelligentMobilityPackage.eINSTANCE.getLink_LaneChanging_Turn();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName_link_laneChanging_turn() {
		return name_link_laneChanging_turn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName_link_laneChanging_turn(String newName_link_laneChanging_turn) {
		String oldName_link_laneChanging_turn = name_link_laneChanging_turn;
		name_link_laneChanging_turn = newName_link_laneChanging_turn;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_LANE_CHANGING_TURN__NAME_LINK_LANE_CHANGING_TURN, oldName_link_laneChanging_turn, name_link_laneChanging_turn));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LINK_LANE_CHANGING_TURN__LINK_LANE_CHANGING, oldLink_laneChanging, link_laneChanging));
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
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_LANE_CHANGING_TURN__LINK_LANE_CHANGING, oldLink_laneChanging, link_laneChanging));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Turn getLink_turn() {
		if (link_turn != null && link_turn.eIsProxy()) {
			InternalEObject oldLink_turn = (InternalEObject)link_turn;
			link_turn = (Turn)eResolveProxy(oldLink_turn);
			if (link_turn != oldLink_turn) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LINK_LANE_CHANGING_TURN__LINK_TURN, oldLink_turn, link_turn));
			}
		}
		return link_turn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Turn basicGetLink_turn() {
		return link_turn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLink_turn(Turn newLink_turn) {
		Turn oldLink_turn = link_turn;
		link_turn = newLink_turn;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_LANE_CHANGING_TURN__LINK_TURN, oldLink_turn, link_turn));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IntelligentMobilityPackage.LINK_LANE_CHANGING_TURN__NAME_LINK_LANE_CHANGING_TURN:
				return getName_link_laneChanging_turn();
			case IntelligentMobilityPackage.LINK_LANE_CHANGING_TURN__LINK_LANE_CHANGING:
				if (resolve) return getLink_laneChanging();
				return basicGetLink_laneChanging();
			case IntelligentMobilityPackage.LINK_LANE_CHANGING_TURN__LINK_TURN:
				if (resolve) return getLink_turn();
				return basicGetLink_turn();
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
			case IntelligentMobilityPackage.LINK_LANE_CHANGING_TURN__NAME_LINK_LANE_CHANGING_TURN:
				setName_link_laneChanging_turn((String)newValue);
				return;
			case IntelligentMobilityPackage.LINK_LANE_CHANGING_TURN__LINK_LANE_CHANGING:
				setLink_laneChanging((LaneChanging)newValue);
				return;
			case IntelligentMobilityPackage.LINK_LANE_CHANGING_TURN__LINK_TURN:
				setLink_turn((Turn)newValue);
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
			case IntelligentMobilityPackage.LINK_LANE_CHANGING_TURN__NAME_LINK_LANE_CHANGING_TURN:
				setName_link_laneChanging_turn(NAME_LINK_LANE_CHANGING_TURN_EDEFAULT);
				return;
			case IntelligentMobilityPackage.LINK_LANE_CHANGING_TURN__LINK_LANE_CHANGING:
				setLink_laneChanging((LaneChanging)null);
				return;
			case IntelligentMobilityPackage.LINK_LANE_CHANGING_TURN__LINK_TURN:
				setLink_turn((Turn)null);
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
			case IntelligentMobilityPackage.LINK_LANE_CHANGING_TURN__NAME_LINK_LANE_CHANGING_TURN:
				return NAME_LINK_LANE_CHANGING_TURN_EDEFAULT == null ? name_link_laneChanging_turn != null : !NAME_LINK_LANE_CHANGING_TURN_EDEFAULT.equals(name_link_laneChanging_turn);
			case IntelligentMobilityPackage.LINK_LANE_CHANGING_TURN__LINK_LANE_CHANGING:
				return link_laneChanging != null;
			case IntelligentMobilityPackage.LINK_LANE_CHANGING_TURN__LINK_TURN:
				return link_turn != null;
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
		result.append(" (name_link_laneChanging_turn: ");
		result.append(name_link_laneChanging_turn);
		result.append(')');
		return result.toString();
	}

} //Link_LaneChanging_TurnImpl
