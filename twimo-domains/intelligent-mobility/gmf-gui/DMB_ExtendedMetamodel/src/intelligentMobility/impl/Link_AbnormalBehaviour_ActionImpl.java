/**
 */
package intelligentMobility.impl;

import intelligentMobility.Abnormal_Behaviour;
import intelligentMobility.Action;
import intelligentMobility.IntelligentMobilityPackage;
import intelligentMobility.Link_AbnormalBehaviour_Action;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Link Abnormal Behaviour Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.impl.Link_AbnormalBehaviour_ActionImpl#getName_link_abnormalBehaviour_action <em>Name link abnormal Behaviour action</em>}</li>
 *   <li>{@link intelligentMobility.impl.Link_AbnormalBehaviour_ActionImpl#getLink_abnormalBehaviour <em>Link abnormal Behaviour</em>}</li>
 *   <li>{@link intelligentMobility.impl.Link_AbnormalBehaviour_ActionImpl#getLink_action <em>Link action</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Link_AbnormalBehaviour_ActionImpl extends MinimalEObjectImpl.Container implements Link_AbnormalBehaviour_Action {
	/**
	 * The default value of the '{@link #getName_link_abnormalBehaviour_action() <em>Name link abnormal Behaviour action</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName_link_abnormalBehaviour_action()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_LINK_ABNORMAL_BEHAVIOUR_ACTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName_link_abnormalBehaviour_action() <em>Name link abnormal Behaviour action</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName_link_abnormalBehaviour_action()
	 * @generated
	 * @ordered
	 */
	protected String name_link_abnormalBehaviour_action = NAME_LINK_ABNORMAL_BEHAVIOUR_ACTION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getLink_abnormalBehaviour() <em>Link abnormal Behaviour</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_abnormalBehaviour()
	 * @generated
	 * @ordered
	 */
	protected Abnormal_Behaviour link_abnormalBehaviour;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Link_AbnormalBehaviour_ActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return IntelligentMobilityPackage.eINSTANCE.getLink_AbnormalBehaviour_Action();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName_link_abnormalBehaviour_action() {
		return name_link_abnormalBehaviour_action;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName_link_abnormalBehaviour_action(String newName_link_abnormalBehaviour_action) {
		String oldName_link_abnormalBehaviour_action = name_link_abnormalBehaviour_action;
		name_link_abnormalBehaviour_action = newName_link_abnormalBehaviour_action;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_ABNORMAL_BEHAVIOUR_ACTION__NAME_LINK_ABNORMAL_BEHAVIOUR_ACTION, oldName_link_abnormalBehaviour_action, name_link_abnormalBehaviour_action));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Abnormal_Behaviour getLink_abnormalBehaviour() {
		if (link_abnormalBehaviour != null && link_abnormalBehaviour.eIsProxy()) {
			InternalEObject oldLink_abnormalBehaviour = (InternalEObject)link_abnormalBehaviour;
			link_abnormalBehaviour = (Abnormal_Behaviour)eResolveProxy(oldLink_abnormalBehaviour);
			if (link_abnormalBehaviour != oldLink_abnormalBehaviour) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LINK_ABNORMAL_BEHAVIOUR_ACTION__LINK_ABNORMAL_BEHAVIOUR, oldLink_abnormalBehaviour, link_abnormalBehaviour));
			}
		}
		return link_abnormalBehaviour;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Abnormal_Behaviour basicGetLink_abnormalBehaviour() {
		return link_abnormalBehaviour;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLink_abnormalBehaviour(Abnormal_Behaviour newLink_abnormalBehaviour) {
		Abnormal_Behaviour oldLink_abnormalBehaviour = link_abnormalBehaviour;
		link_abnormalBehaviour = newLink_abnormalBehaviour;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_ABNORMAL_BEHAVIOUR_ACTION__LINK_ABNORMAL_BEHAVIOUR, oldLink_abnormalBehaviour, link_abnormalBehaviour));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LINK_ABNORMAL_BEHAVIOUR_ACTION__LINK_ACTION, oldLink_action, link_action));
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
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_ABNORMAL_BEHAVIOUR_ACTION__LINK_ACTION, oldLink_action, link_action));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IntelligentMobilityPackage.LINK_ABNORMAL_BEHAVIOUR_ACTION__NAME_LINK_ABNORMAL_BEHAVIOUR_ACTION:
				return getName_link_abnormalBehaviour_action();
			case IntelligentMobilityPackage.LINK_ABNORMAL_BEHAVIOUR_ACTION__LINK_ABNORMAL_BEHAVIOUR:
				if (resolve) return getLink_abnormalBehaviour();
				return basicGetLink_abnormalBehaviour();
			case IntelligentMobilityPackage.LINK_ABNORMAL_BEHAVIOUR_ACTION__LINK_ACTION:
				if (resolve) return getLink_action();
				return basicGetLink_action();
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
			case IntelligentMobilityPackage.LINK_ABNORMAL_BEHAVIOUR_ACTION__NAME_LINK_ABNORMAL_BEHAVIOUR_ACTION:
				setName_link_abnormalBehaviour_action((String)newValue);
				return;
			case IntelligentMobilityPackage.LINK_ABNORMAL_BEHAVIOUR_ACTION__LINK_ABNORMAL_BEHAVIOUR:
				setLink_abnormalBehaviour((Abnormal_Behaviour)newValue);
				return;
			case IntelligentMobilityPackage.LINK_ABNORMAL_BEHAVIOUR_ACTION__LINK_ACTION:
				setLink_action((Action)newValue);
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
			case IntelligentMobilityPackage.LINK_ABNORMAL_BEHAVIOUR_ACTION__NAME_LINK_ABNORMAL_BEHAVIOUR_ACTION:
				setName_link_abnormalBehaviour_action(NAME_LINK_ABNORMAL_BEHAVIOUR_ACTION_EDEFAULT);
				return;
			case IntelligentMobilityPackage.LINK_ABNORMAL_BEHAVIOUR_ACTION__LINK_ABNORMAL_BEHAVIOUR:
				setLink_abnormalBehaviour((Abnormal_Behaviour)null);
				return;
			case IntelligentMobilityPackage.LINK_ABNORMAL_BEHAVIOUR_ACTION__LINK_ACTION:
				setLink_action((Action)null);
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
			case IntelligentMobilityPackage.LINK_ABNORMAL_BEHAVIOUR_ACTION__NAME_LINK_ABNORMAL_BEHAVIOUR_ACTION:
				return NAME_LINK_ABNORMAL_BEHAVIOUR_ACTION_EDEFAULT == null ? name_link_abnormalBehaviour_action != null : !NAME_LINK_ABNORMAL_BEHAVIOUR_ACTION_EDEFAULT.equals(name_link_abnormalBehaviour_action);
			case IntelligentMobilityPackage.LINK_ABNORMAL_BEHAVIOUR_ACTION__LINK_ABNORMAL_BEHAVIOUR:
				return link_abnormalBehaviour != null;
			case IntelligentMobilityPackage.LINK_ABNORMAL_BEHAVIOUR_ACTION__LINK_ACTION:
				return link_action != null;
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
		result.append(" (name_link_abnormalBehaviour_action: ");
		result.append(name_link_abnormalBehaviour_action);
		result.append(')');
		return result.toString();
	}

} //Link_AbnormalBehaviour_ActionImpl
