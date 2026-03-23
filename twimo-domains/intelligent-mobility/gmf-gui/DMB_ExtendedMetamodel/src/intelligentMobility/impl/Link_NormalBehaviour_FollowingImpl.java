/**
 */
package intelligentMobility.impl;

import intelligentMobility.Following;
import intelligentMobility.IntelligentMobilityPackage;
import intelligentMobility.Link_NormalBehaviour_Following;
import intelligentMobility.Normal_Behaviour;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Link Normal Behaviour Following</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.impl.Link_NormalBehaviour_FollowingImpl#getName_link_behaviour_following <em>Name link behaviour following</em>}</li>
 *   <li>{@link intelligentMobility.impl.Link_NormalBehaviour_FollowingImpl#getLink_normal_behaviour <em>Link normal behaviour</em>}</li>
 *   <li>{@link intelligentMobility.impl.Link_NormalBehaviour_FollowingImpl#getLink_following <em>Link following</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Link_NormalBehaviour_FollowingImpl extends MinimalEObjectImpl.Container implements Link_NormalBehaviour_Following {
	/**
	 * The default value of the '{@link #getName_link_behaviour_following() <em>Name link behaviour following</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName_link_behaviour_following()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_LINK_BEHAVIOUR_FOLLOWING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName_link_behaviour_following() <em>Name link behaviour following</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName_link_behaviour_following()
	 * @generated
	 * @ordered
	 */
	protected String name_link_behaviour_following = NAME_LINK_BEHAVIOUR_FOLLOWING_EDEFAULT;

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
	 * The cached value of the '{@link #getLink_following() <em>Link following</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_following()
	 * @generated
	 * @ordered
	 */
	protected Following link_following;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Link_NormalBehaviour_FollowingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return IntelligentMobilityPackage.eINSTANCE.getLink_NormalBehaviour_Following();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName_link_behaviour_following() {
		return name_link_behaviour_following;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName_link_behaviour_following(String newName_link_behaviour_following) {
		String oldName_link_behaviour_following = name_link_behaviour_following;
		name_link_behaviour_following = newName_link_behaviour_following;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_NORMAL_BEHAVIOUR_FOLLOWING__NAME_LINK_BEHAVIOUR_FOLLOWING, oldName_link_behaviour_following, name_link_behaviour_following));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LINK_NORMAL_BEHAVIOUR_FOLLOWING__LINK_NORMAL_BEHAVIOUR, oldLink_normal_behaviour, link_normal_behaviour));
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
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_NORMAL_BEHAVIOUR_FOLLOWING__LINK_NORMAL_BEHAVIOUR, oldLink_normal_behaviour, link_normal_behaviour));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Following getLink_following() {
		if (link_following != null && link_following.eIsProxy()) {
			InternalEObject oldLink_following = (InternalEObject)link_following;
			link_following = (Following)eResolveProxy(oldLink_following);
			if (link_following != oldLink_following) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LINK_NORMAL_BEHAVIOUR_FOLLOWING__LINK_FOLLOWING, oldLink_following, link_following));
			}
		}
		return link_following;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Following basicGetLink_following() {
		return link_following;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLink_following(Following newLink_following) {
		Following oldLink_following = link_following;
		link_following = newLink_following;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_NORMAL_BEHAVIOUR_FOLLOWING__LINK_FOLLOWING, oldLink_following, link_following));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IntelligentMobilityPackage.LINK_NORMAL_BEHAVIOUR_FOLLOWING__NAME_LINK_BEHAVIOUR_FOLLOWING:
				return getName_link_behaviour_following();
			case IntelligentMobilityPackage.LINK_NORMAL_BEHAVIOUR_FOLLOWING__LINK_NORMAL_BEHAVIOUR:
				if (resolve) return getLink_normal_behaviour();
				return basicGetLink_normal_behaviour();
			case IntelligentMobilityPackage.LINK_NORMAL_BEHAVIOUR_FOLLOWING__LINK_FOLLOWING:
				if (resolve) return getLink_following();
				return basicGetLink_following();
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
			case IntelligentMobilityPackage.LINK_NORMAL_BEHAVIOUR_FOLLOWING__NAME_LINK_BEHAVIOUR_FOLLOWING:
				setName_link_behaviour_following((String)newValue);
				return;
			case IntelligentMobilityPackage.LINK_NORMAL_BEHAVIOUR_FOLLOWING__LINK_NORMAL_BEHAVIOUR:
				setLink_normal_behaviour((Normal_Behaviour)newValue);
				return;
			case IntelligentMobilityPackage.LINK_NORMAL_BEHAVIOUR_FOLLOWING__LINK_FOLLOWING:
				setLink_following((Following)newValue);
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
			case IntelligentMobilityPackage.LINK_NORMAL_BEHAVIOUR_FOLLOWING__NAME_LINK_BEHAVIOUR_FOLLOWING:
				setName_link_behaviour_following(NAME_LINK_BEHAVIOUR_FOLLOWING_EDEFAULT);
				return;
			case IntelligentMobilityPackage.LINK_NORMAL_BEHAVIOUR_FOLLOWING__LINK_NORMAL_BEHAVIOUR:
				setLink_normal_behaviour((Normal_Behaviour)null);
				return;
			case IntelligentMobilityPackage.LINK_NORMAL_BEHAVIOUR_FOLLOWING__LINK_FOLLOWING:
				setLink_following((Following)null);
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
			case IntelligentMobilityPackage.LINK_NORMAL_BEHAVIOUR_FOLLOWING__NAME_LINK_BEHAVIOUR_FOLLOWING:
				return NAME_LINK_BEHAVIOUR_FOLLOWING_EDEFAULT == null ? name_link_behaviour_following != null : !NAME_LINK_BEHAVIOUR_FOLLOWING_EDEFAULT.equals(name_link_behaviour_following);
			case IntelligentMobilityPackage.LINK_NORMAL_BEHAVIOUR_FOLLOWING__LINK_NORMAL_BEHAVIOUR:
				return link_normal_behaviour != null;
			case IntelligentMobilityPackage.LINK_NORMAL_BEHAVIOUR_FOLLOWING__LINK_FOLLOWING:
				return link_following != null;
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
		result.append(" (name_link_behaviour_following: ");
		result.append(name_link_behaviour_following);
		result.append(')');
		return result.toString();
	}

} //Link_NormalBehaviour_FollowingImpl
