/**
 */
package intelligentMobility.impl;

import intelligentMobility.Action;
import intelligentMobility.IntelligentMobilityPackage;
import intelligentMobility.Link_Action_Turn;
import intelligentMobility.Turn;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Link Action Turn</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.impl.Link_Action_TurnImpl#getName_link_action_turn <em>Name link action turn</em>}</li>
 *   <li>{@link intelligentMobility.impl.Link_Action_TurnImpl#getLink_action <em>Link action</em>}</li>
 *   <li>{@link intelligentMobility.impl.Link_Action_TurnImpl#getLink_turn <em>Link turn</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Link_Action_TurnImpl extends MinimalEObjectImpl.Container implements Link_Action_Turn {
	/**
	 * The default value of the '{@link #getName_link_action_turn() <em>Name link action turn</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName_link_action_turn()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_LINK_ACTION_TURN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName_link_action_turn() <em>Name link action turn</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName_link_action_turn()
	 * @generated
	 * @ordered
	 */
	protected String name_link_action_turn = NAME_LINK_ACTION_TURN_EDEFAULT;

	/**
	 * The cached value of the '{@link #getLink_action() <em>Link action</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_action()
	 * @generated
	 * @ordered
	 */
	protected Action link_action;

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
	protected Link_Action_TurnImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return IntelligentMobilityPackage.eINSTANCE.getLink_Action_Turn();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName_link_action_turn() {
		return name_link_action_turn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName_link_action_turn(String newName_link_action_turn) {
		String oldName_link_action_turn = name_link_action_turn;
		name_link_action_turn = newName_link_action_turn;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_ACTION_TURN__NAME_LINK_ACTION_TURN, oldName_link_action_turn, name_link_action_turn));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Action getLink_action() {
		if (link_action != null && link_action.eIsProxy()) {
			InternalEObject oldLink_action = (InternalEObject)link_action;
			link_action = (Action)eResolveProxy(oldLink_action);
			if (link_action != oldLink_action) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LINK_ACTION_TURN__LINK_ACTION, oldLink_action, link_action));
			}
		}
		return link_action;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Action basicGetLink_action() {
		return link_action;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLink_action(Action newLink_action) {
		Action oldLink_action = link_action;
		link_action = newLink_action;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_ACTION_TURN__LINK_ACTION, oldLink_action, link_action));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LINK_ACTION_TURN__LINK_TURN, oldLink_turn, link_turn));
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
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_ACTION_TURN__LINK_TURN, oldLink_turn, link_turn));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IntelligentMobilityPackage.LINK_ACTION_TURN__NAME_LINK_ACTION_TURN:
				return getName_link_action_turn();
			case IntelligentMobilityPackage.LINK_ACTION_TURN__LINK_ACTION:
				if (resolve) return getLink_action();
				return basicGetLink_action();
			case IntelligentMobilityPackage.LINK_ACTION_TURN__LINK_TURN:
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
			case IntelligentMobilityPackage.LINK_ACTION_TURN__NAME_LINK_ACTION_TURN:
				setName_link_action_turn((String)newValue);
				return;
			case IntelligentMobilityPackage.LINK_ACTION_TURN__LINK_ACTION:
				setLink_action((Action)newValue);
				return;
			case IntelligentMobilityPackage.LINK_ACTION_TURN__LINK_TURN:
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
			case IntelligentMobilityPackage.LINK_ACTION_TURN__NAME_LINK_ACTION_TURN:
				setName_link_action_turn(NAME_LINK_ACTION_TURN_EDEFAULT);
				return;
			case IntelligentMobilityPackage.LINK_ACTION_TURN__LINK_ACTION:
				setLink_action((Action)null);
				return;
			case IntelligentMobilityPackage.LINK_ACTION_TURN__LINK_TURN:
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
			case IntelligentMobilityPackage.LINK_ACTION_TURN__NAME_LINK_ACTION_TURN:
				return NAME_LINK_ACTION_TURN_EDEFAULT == null ? name_link_action_turn != null : !NAME_LINK_ACTION_TURN_EDEFAULT.equals(name_link_action_turn);
			case IntelligentMobilityPackage.LINK_ACTION_TURN__LINK_ACTION:
				return link_action != null;
			case IntelligentMobilityPackage.LINK_ACTION_TURN__LINK_TURN:
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
		result.append(" (name_link_action_turn: ");
		result.append(name_link_action_turn);
		result.append(')');
		return result.toString();
	}

} //Link_Action_TurnImpl
