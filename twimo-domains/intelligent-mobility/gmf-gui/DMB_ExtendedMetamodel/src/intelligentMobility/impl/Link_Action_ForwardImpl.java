/**
 */
package intelligentMobility.impl;

import intelligentMobility.Action;
import intelligentMobility.Forward;
import intelligentMobility.IntelligentMobilityPackage;
import intelligentMobility.Link_Action_Forward;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Link Action Forward</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.impl.Link_Action_ForwardImpl#getName_link_action_forward <em>Name link action forward</em>}</li>
 *   <li>{@link intelligentMobility.impl.Link_Action_ForwardImpl#getLink_action <em>Link action</em>}</li>
 *   <li>{@link intelligentMobility.impl.Link_Action_ForwardImpl#getLink_forward <em>Link forward</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Link_Action_ForwardImpl extends MinimalEObjectImpl.Container implements Link_Action_Forward {
	/**
	 * The default value of the '{@link #getName_link_action_forward() <em>Name link action forward</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName_link_action_forward()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_LINK_ACTION_FORWARD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName_link_action_forward() <em>Name link action forward</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName_link_action_forward()
	 * @generated
	 * @ordered
	 */
	protected String name_link_action_forward = NAME_LINK_ACTION_FORWARD_EDEFAULT;

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
	 * The cached value of the '{@link #getLink_forward() <em>Link forward</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_forward()
	 * @generated
	 * @ordered
	 */
	protected Forward link_forward;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Link_Action_ForwardImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return IntelligentMobilityPackage.eINSTANCE.getLink_Action_Forward();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName_link_action_forward() {
		return name_link_action_forward;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName_link_action_forward(String newName_link_action_forward) {
		String oldName_link_action_forward = name_link_action_forward;
		name_link_action_forward = newName_link_action_forward;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_ACTION_FORWARD__NAME_LINK_ACTION_FORWARD, oldName_link_action_forward, name_link_action_forward));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LINK_ACTION_FORWARD__LINK_ACTION, oldLink_action, link_action));
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
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_ACTION_FORWARD__LINK_ACTION, oldLink_action, link_action));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Forward getLink_forward() {
		if (link_forward != null && link_forward.eIsProxy()) {
			InternalEObject oldLink_forward = (InternalEObject)link_forward;
			link_forward = (Forward)eResolveProxy(oldLink_forward);
			if (link_forward != oldLink_forward) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LINK_ACTION_FORWARD__LINK_FORWARD, oldLink_forward, link_forward));
			}
		}
		return link_forward;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Forward basicGetLink_forward() {
		return link_forward;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLink_forward(Forward newLink_forward) {
		Forward oldLink_forward = link_forward;
		link_forward = newLink_forward;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_ACTION_FORWARD__LINK_FORWARD, oldLink_forward, link_forward));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IntelligentMobilityPackage.LINK_ACTION_FORWARD__NAME_LINK_ACTION_FORWARD:
				return getName_link_action_forward();
			case IntelligentMobilityPackage.LINK_ACTION_FORWARD__LINK_ACTION:
				if (resolve) return getLink_action();
				return basicGetLink_action();
			case IntelligentMobilityPackage.LINK_ACTION_FORWARD__LINK_FORWARD:
				if (resolve) return getLink_forward();
				return basicGetLink_forward();
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
			case IntelligentMobilityPackage.LINK_ACTION_FORWARD__NAME_LINK_ACTION_FORWARD:
				setName_link_action_forward((String)newValue);
				return;
			case IntelligentMobilityPackage.LINK_ACTION_FORWARD__LINK_ACTION:
				setLink_action((Action)newValue);
				return;
			case IntelligentMobilityPackage.LINK_ACTION_FORWARD__LINK_FORWARD:
				setLink_forward((Forward)newValue);
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
			case IntelligentMobilityPackage.LINK_ACTION_FORWARD__NAME_LINK_ACTION_FORWARD:
				setName_link_action_forward(NAME_LINK_ACTION_FORWARD_EDEFAULT);
				return;
			case IntelligentMobilityPackage.LINK_ACTION_FORWARD__LINK_ACTION:
				setLink_action((Action)null);
				return;
			case IntelligentMobilityPackage.LINK_ACTION_FORWARD__LINK_FORWARD:
				setLink_forward((Forward)null);
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
			case IntelligentMobilityPackage.LINK_ACTION_FORWARD__NAME_LINK_ACTION_FORWARD:
				return NAME_LINK_ACTION_FORWARD_EDEFAULT == null ? name_link_action_forward != null : !NAME_LINK_ACTION_FORWARD_EDEFAULT.equals(name_link_action_forward);
			case IntelligentMobilityPackage.LINK_ACTION_FORWARD__LINK_ACTION:
				return link_action != null;
			case IntelligentMobilityPackage.LINK_ACTION_FORWARD__LINK_FORWARD:
				return link_forward != null;
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
		result.append(" (name_link_action_forward: ");
		result.append(name_link_action_forward);
		result.append(')');
		return result.toString();
	}

} //Link_Action_ForwardImpl
