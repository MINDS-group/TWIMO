/**
 */
package intelligentMobility.impl;

import intelligentMobility.Following;
import intelligentMobility.IntelligentMobilityPackage;
import intelligentMobility.LaneChanging;
import intelligentMobility.Link_Following_MinGap;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Link Following Min Gap</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.impl.Link_Following_MinGapImpl#getName_link_following_minGap <em>Name link following min Gap</em>}</li>
 *   <li>{@link intelligentMobility.impl.Link_Following_MinGapImpl#getLink_following <em>Link following</em>}</li>
 *   <li>{@link intelligentMobility.impl.Link_Following_MinGapImpl#getLink_minGap <em>Link min Gap</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Link_Following_MinGapImpl extends MinimalEObjectImpl.Container implements Link_Following_MinGap {
	/**
	 * The default value of the '{@link #getName_link_following_minGap() <em>Name link following min Gap</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName_link_following_minGap()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_LINK_FOLLOWING_MIN_GAP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName_link_following_minGap() <em>Name link following min Gap</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName_link_following_minGap()
	 * @generated
	 * @ordered
	 */
	protected String name_link_following_minGap = NAME_LINK_FOLLOWING_MIN_GAP_EDEFAULT;

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
	 * The cached value of the '{@link #getLink_minGap() <em>Link min Gap</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_minGap()
	 * @generated
	 * @ordered
	 */
	protected LaneChanging link_minGap;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Link_Following_MinGapImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return IntelligentMobilityPackage.eINSTANCE.getLink_Following_MinGap();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName_link_following_minGap() {
		return name_link_following_minGap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName_link_following_minGap(String newName_link_following_minGap) {
		String oldName_link_following_minGap = name_link_following_minGap;
		name_link_following_minGap = newName_link_following_minGap;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_FOLLOWING_MIN_GAP__NAME_LINK_FOLLOWING_MIN_GAP, oldName_link_following_minGap, name_link_following_minGap));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LINK_FOLLOWING_MIN_GAP__LINK_FOLLOWING, oldLink_following, link_following));
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
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_FOLLOWING_MIN_GAP__LINK_FOLLOWING, oldLink_following, link_following));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LaneChanging getLink_minGap() {
		if (link_minGap != null && link_minGap.eIsProxy()) {
			InternalEObject oldLink_minGap = (InternalEObject)link_minGap;
			link_minGap = (LaneChanging)eResolveProxy(oldLink_minGap);
			if (link_minGap != oldLink_minGap) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LINK_FOLLOWING_MIN_GAP__LINK_MIN_GAP, oldLink_minGap, link_minGap));
			}
		}
		return link_minGap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LaneChanging basicGetLink_minGap() {
		return link_minGap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLink_minGap(LaneChanging newLink_minGap) {
		LaneChanging oldLink_minGap = link_minGap;
		link_minGap = newLink_minGap;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_FOLLOWING_MIN_GAP__LINK_MIN_GAP, oldLink_minGap, link_minGap));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IntelligentMobilityPackage.LINK_FOLLOWING_MIN_GAP__NAME_LINK_FOLLOWING_MIN_GAP:
				return getName_link_following_minGap();
			case IntelligentMobilityPackage.LINK_FOLLOWING_MIN_GAP__LINK_FOLLOWING:
				if (resolve) return getLink_following();
				return basicGetLink_following();
			case IntelligentMobilityPackage.LINK_FOLLOWING_MIN_GAP__LINK_MIN_GAP:
				if (resolve) return getLink_minGap();
				return basicGetLink_minGap();
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
			case IntelligentMobilityPackage.LINK_FOLLOWING_MIN_GAP__NAME_LINK_FOLLOWING_MIN_GAP:
				setName_link_following_minGap((String)newValue);
				return;
			case IntelligentMobilityPackage.LINK_FOLLOWING_MIN_GAP__LINK_FOLLOWING:
				setLink_following((Following)newValue);
				return;
			case IntelligentMobilityPackage.LINK_FOLLOWING_MIN_GAP__LINK_MIN_GAP:
				setLink_minGap((LaneChanging)newValue);
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
			case IntelligentMobilityPackage.LINK_FOLLOWING_MIN_GAP__NAME_LINK_FOLLOWING_MIN_GAP:
				setName_link_following_minGap(NAME_LINK_FOLLOWING_MIN_GAP_EDEFAULT);
				return;
			case IntelligentMobilityPackage.LINK_FOLLOWING_MIN_GAP__LINK_FOLLOWING:
				setLink_following((Following)null);
				return;
			case IntelligentMobilityPackage.LINK_FOLLOWING_MIN_GAP__LINK_MIN_GAP:
				setLink_minGap((LaneChanging)null);
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
			case IntelligentMobilityPackage.LINK_FOLLOWING_MIN_GAP__NAME_LINK_FOLLOWING_MIN_GAP:
				return NAME_LINK_FOLLOWING_MIN_GAP_EDEFAULT == null ? name_link_following_minGap != null : !NAME_LINK_FOLLOWING_MIN_GAP_EDEFAULT.equals(name_link_following_minGap);
			case IntelligentMobilityPackage.LINK_FOLLOWING_MIN_GAP__LINK_FOLLOWING:
				return link_following != null;
			case IntelligentMobilityPackage.LINK_FOLLOWING_MIN_GAP__LINK_MIN_GAP:
				return link_minGap != null;
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
		result.append(" (name_link_following_minGap: ");
		result.append(name_link_following_minGap);
		result.append(')');
		return result.toString();
	}

} //Link_Following_MinGapImpl
