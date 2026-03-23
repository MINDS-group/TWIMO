/**
 */
package intelligentMobility.impl;

import intelligentMobility.Action;
import intelligentMobility.Backward;
import intelligentMobility.IntelligentMobilityPackage;
import intelligentMobility.Link_Action_Backward;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Link Action Backward</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.impl.Link_Action_BackwardImpl#getName_link_action_backward <em>Name link action backward</em>}</li>
 *   <li>{@link intelligentMobility.impl.Link_Action_BackwardImpl#getLink_action <em>Link action</em>}</li>
 *   <li>{@link intelligentMobility.impl.Link_Action_BackwardImpl#getLink_backward <em>Link backward</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Link_Action_BackwardImpl extends MinimalEObjectImpl.Container implements Link_Action_Backward {
	/**
	 * The default value of the '{@link #getName_link_action_backward() <em>Name link action backward</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName_link_action_backward()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_LINK_ACTION_BACKWARD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName_link_action_backward() <em>Name link action backward</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName_link_action_backward()
	 * @generated
	 * @ordered
	 */
	protected String name_link_action_backward = NAME_LINK_ACTION_BACKWARD_EDEFAULT;

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
	 * The cached value of the '{@link #getLink_backward() <em>Link backward</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_backward()
	 * @generated
	 * @ordered
	 */
	protected Backward link_backward;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Link_Action_BackwardImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return IntelligentMobilityPackage.eINSTANCE.getLink_Action_Backward();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName_link_action_backward() {
		return name_link_action_backward;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName_link_action_backward(String newName_link_action_backward) {
		String oldName_link_action_backward = name_link_action_backward;
		name_link_action_backward = newName_link_action_backward;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_ACTION_BACKWARD__NAME_LINK_ACTION_BACKWARD, oldName_link_action_backward, name_link_action_backward));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LINK_ACTION_BACKWARD__LINK_ACTION, oldLink_action, link_action));
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
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_ACTION_BACKWARD__LINK_ACTION, oldLink_action, link_action));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Backward getLink_backward() {
		if (link_backward != null && link_backward.eIsProxy()) {
			InternalEObject oldLink_backward = (InternalEObject)link_backward;
			link_backward = (Backward)eResolveProxy(oldLink_backward);
			if (link_backward != oldLink_backward) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LINK_ACTION_BACKWARD__LINK_BACKWARD, oldLink_backward, link_backward));
			}
		}
		return link_backward;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Backward basicGetLink_backward() {
		return link_backward;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLink_backward(Backward newLink_backward) {
		Backward oldLink_backward = link_backward;
		link_backward = newLink_backward;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_ACTION_BACKWARD__LINK_BACKWARD, oldLink_backward, link_backward));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IntelligentMobilityPackage.LINK_ACTION_BACKWARD__NAME_LINK_ACTION_BACKWARD:
				return getName_link_action_backward();
			case IntelligentMobilityPackage.LINK_ACTION_BACKWARD__LINK_ACTION:
				if (resolve) return getLink_action();
				return basicGetLink_action();
			case IntelligentMobilityPackage.LINK_ACTION_BACKWARD__LINK_BACKWARD:
				if (resolve) return getLink_backward();
				return basicGetLink_backward();
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
			case IntelligentMobilityPackage.LINK_ACTION_BACKWARD__NAME_LINK_ACTION_BACKWARD:
				setName_link_action_backward((String)newValue);
				return;
			case IntelligentMobilityPackage.LINK_ACTION_BACKWARD__LINK_ACTION:
				setLink_action((Action)newValue);
				return;
			case IntelligentMobilityPackage.LINK_ACTION_BACKWARD__LINK_BACKWARD:
				setLink_backward((Backward)newValue);
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
			case IntelligentMobilityPackage.LINK_ACTION_BACKWARD__NAME_LINK_ACTION_BACKWARD:
				setName_link_action_backward(NAME_LINK_ACTION_BACKWARD_EDEFAULT);
				return;
			case IntelligentMobilityPackage.LINK_ACTION_BACKWARD__LINK_ACTION:
				setLink_action((Action)null);
				return;
			case IntelligentMobilityPackage.LINK_ACTION_BACKWARD__LINK_BACKWARD:
				setLink_backward((Backward)null);
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
			case IntelligentMobilityPackage.LINK_ACTION_BACKWARD__NAME_LINK_ACTION_BACKWARD:
				return NAME_LINK_ACTION_BACKWARD_EDEFAULT == null ? name_link_action_backward != null : !NAME_LINK_ACTION_BACKWARD_EDEFAULT.equals(name_link_action_backward);
			case IntelligentMobilityPackage.LINK_ACTION_BACKWARD__LINK_ACTION:
				return link_action != null;
			case IntelligentMobilityPackage.LINK_ACTION_BACKWARD__LINK_BACKWARD:
				return link_backward != null;
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
		result.append(" (name_link_action_backward: ");
		result.append(name_link_action_backward);
		result.append(')');
		return result.toString();
	}

} //Link_Action_BackwardImpl
