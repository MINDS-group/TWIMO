/**
 */
package intelligentMobility.impl;

import intelligentMobility.Following;
import intelligentMobility.Forward;
import intelligentMobility.IntelligentMobilityPackage;
import intelligentMobility.Link_Following_Forward;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Link Following Forward</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.impl.Link_Following_ForwardImpl#getName_link_following_forward <em>Name link following forward</em>}</li>
 *   <li>{@link intelligentMobility.impl.Link_Following_ForwardImpl#getLink_following <em>Link following</em>}</li>
 *   <li>{@link intelligentMobility.impl.Link_Following_ForwardImpl#getLink_forward <em>Link forward</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Link_Following_ForwardImpl extends MinimalEObjectImpl.Container implements Link_Following_Forward {
	/**
	 * The default value of the '{@link #getName_link_following_forward() <em>Name link following forward</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName_link_following_forward()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_LINK_FOLLOWING_FORWARD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName_link_following_forward() <em>Name link following forward</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName_link_following_forward()
	 * @generated
	 * @ordered
	 */
	protected String name_link_following_forward = NAME_LINK_FOLLOWING_FORWARD_EDEFAULT;

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
	protected Link_Following_ForwardImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return IntelligentMobilityPackage.eINSTANCE.getLink_Following_Forward();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName_link_following_forward() {
		return name_link_following_forward;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName_link_following_forward(String newName_link_following_forward) {
		String oldName_link_following_forward = name_link_following_forward;
		name_link_following_forward = newName_link_following_forward;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_FOLLOWING_FORWARD__NAME_LINK_FOLLOWING_FORWARD, oldName_link_following_forward, name_link_following_forward));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LINK_FOLLOWING_FORWARD__LINK_FOLLOWING, oldLink_following, link_following));
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
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_FOLLOWING_FORWARD__LINK_FOLLOWING, oldLink_following, link_following));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LINK_FOLLOWING_FORWARD__LINK_FORWARD, oldLink_forward, link_forward));
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
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_FOLLOWING_FORWARD__LINK_FORWARD, oldLink_forward, link_forward));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IntelligentMobilityPackage.LINK_FOLLOWING_FORWARD__NAME_LINK_FOLLOWING_FORWARD:
				return getName_link_following_forward();
			case IntelligentMobilityPackage.LINK_FOLLOWING_FORWARD__LINK_FOLLOWING:
				if (resolve) return getLink_following();
				return basicGetLink_following();
			case IntelligentMobilityPackage.LINK_FOLLOWING_FORWARD__LINK_FORWARD:
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
			case IntelligentMobilityPackage.LINK_FOLLOWING_FORWARD__NAME_LINK_FOLLOWING_FORWARD:
				setName_link_following_forward((String)newValue);
				return;
			case IntelligentMobilityPackage.LINK_FOLLOWING_FORWARD__LINK_FOLLOWING:
				setLink_following((Following)newValue);
				return;
			case IntelligentMobilityPackage.LINK_FOLLOWING_FORWARD__LINK_FORWARD:
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
			case IntelligentMobilityPackage.LINK_FOLLOWING_FORWARD__NAME_LINK_FOLLOWING_FORWARD:
				setName_link_following_forward(NAME_LINK_FOLLOWING_FORWARD_EDEFAULT);
				return;
			case IntelligentMobilityPackage.LINK_FOLLOWING_FORWARD__LINK_FOLLOWING:
				setLink_following((Following)null);
				return;
			case IntelligentMobilityPackage.LINK_FOLLOWING_FORWARD__LINK_FORWARD:
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
			case IntelligentMobilityPackage.LINK_FOLLOWING_FORWARD__NAME_LINK_FOLLOWING_FORWARD:
				return NAME_LINK_FOLLOWING_FORWARD_EDEFAULT == null ? name_link_following_forward != null : !NAME_LINK_FOLLOWING_FORWARD_EDEFAULT.equals(name_link_following_forward);
			case IntelligentMobilityPackage.LINK_FOLLOWING_FORWARD__LINK_FOLLOWING:
				return link_following != null;
			case IntelligentMobilityPackage.LINK_FOLLOWING_FORWARD__LINK_FORWARD:
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
		result.append(" (name_link_following_forward: ");
		result.append(name_link_following_forward);
		result.append(')');
		return result.toString();
	}

} //Link_Following_ForwardImpl
