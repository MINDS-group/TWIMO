/**
 */
package intelligentMobility.impl;

import intelligentMobility.Following;
import intelligentMobility.IntelligentMobilityPackage;
import intelligentMobility.LaneChanging;
import intelligentMobility.Link_Following_LaneChanging;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Link Following Lane Changing</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.impl.Link_Following_LaneChangingImpl#getName_link_following_laneChanging <em>Name link following lane Changing</em>}</li>
 *   <li>{@link intelligentMobility.impl.Link_Following_LaneChangingImpl#getLink_following <em>Link following</em>}</li>
 *   <li>{@link intelligentMobility.impl.Link_Following_LaneChangingImpl#getLink_laneChanging <em>Link lane Changing</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Link_Following_LaneChangingImpl extends MinimalEObjectImpl.Container implements Link_Following_LaneChanging {
	/**
	 * The default value of the '{@link #getName_link_following_laneChanging() <em>Name link following lane Changing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName_link_following_laneChanging()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_LINK_FOLLOWING_LANE_CHANGING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName_link_following_laneChanging() <em>Name link following lane Changing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName_link_following_laneChanging()
	 * @generated
	 * @ordered
	 */
	protected String name_link_following_laneChanging = NAME_LINK_FOLLOWING_LANE_CHANGING_EDEFAULT;

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
	 * The cached value of the '{@link #getLink_laneChanging() <em>Link lane Changing</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_laneChanging()
	 * @generated
	 * @ordered
	 */
	protected LaneChanging link_laneChanging;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Link_Following_LaneChangingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return IntelligentMobilityPackage.eINSTANCE.getLink_Following_LaneChanging();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName_link_following_laneChanging() {
		return name_link_following_laneChanging;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName_link_following_laneChanging(String newName_link_following_laneChanging) {
		String oldName_link_following_laneChanging = name_link_following_laneChanging;
		name_link_following_laneChanging = newName_link_following_laneChanging;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_FOLLOWING_LANE_CHANGING__NAME_LINK_FOLLOWING_LANE_CHANGING, oldName_link_following_laneChanging, name_link_following_laneChanging));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LINK_FOLLOWING_LANE_CHANGING__LINK_FOLLOWING, oldLink_following, link_following));
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
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_FOLLOWING_LANE_CHANGING__LINK_FOLLOWING, oldLink_following, link_following));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LINK_FOLLOWING_LANE_CHANGING__LINK_LANE_CHANGING, oldLink_laneChanging, link_laneChanging));
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
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_FOLLOWING_LANE_CHANGING__LINK_LANE_CHANGING, oldLink_laneChanging, link_laneChanging));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IntelligentMobilityPackage.LINK_FOLLOWING_LANE_CHANGING__NAME_LINK_FOLLOWING_LANE_CHANGING:
				return getName_link_following_laneChanging();
			case IntelligentMobilityPackage.LINK_FOLLOWING_LANE_CHANGING__LINK_FOLLOWING:
				if (resolve) return getLink_following();
				return basicGetLink_following();
			case IntelligentMobilityPackage.LINK_FOLLOWING_LANE_CHANGING__LINK_LANE_CHANGING:
				if (resolve) return getLink_laneChanging();
				return basicGetLink_laneChanging();
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
			case IntelligentMobilityPackage.LINK_FOLLOWING_LANE_CHANGING__NAME_LINK_FOLLOWING_LANE_CHANGING:
				setName_link_following_laneChanging((String)newValue);
				return;
			case IntelligentMobilityPackage.LINK_FOLLOWING_LANE_CHANGING__LINK_FOLLOWING:
				setLink_following((Following)newValue);
				return;
			case IntelligentMobilityPackage.LINK_FOLLOWING_LANE_CHANGING__LINK_LANE_CHANGING:
				setLink_laneChanging((LaneChanging)newValue);
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
			case IntelligentMobilityPackage.LINK_FOLLOWING_LANE_CHANGING__NAME_LINK_FOLLOWING_LANE_CHANGING:
				setName_link_following_laneChanging(NAME_LINK_FOLLOWING_LANE_CHANGING_EDEFAULT);
				return;
			case IntelligentMobilityPackage.LINK_FOLLOWING_LANE_CHANGING__LINK_FOLLOWING:
				setLink_following((Following)null);
				return;
			case IntelligentMobilityPackage.LINK_FOLLOWING_LANE_CHANGING__LINK_LANE_CHANGING:
				setLink_laneChanging((LaneChanging)null);
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
			case IntelligentMobilityPackage.LINK_FOLLOWING_LANE_CHANGING__NAME_LINK_FOLLOWING_LANE_CHANGING:
				return NAME_LINK_FOLLOWING_LANE_CHANGING_EDEFAULT == null ? name_link_following_laneChanging != null : !NAME_LINK_FOLLOWING_LANE_CHANGING_EDEFAULT.equals(name_link_following_laneChanging);
			case IntelligentMobilityPackage.LINK_FOLLOWING_LANE_CHANGING__LINK_FOLLOWING:
				return link_following != null;
			case IntelligentMobilityPackage.LINK_FOLLOWING_LANE_CHANGING__LINK_LANE_CHANGING:
				return link_laneChanging != null;
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
		result.append(" (name_link_following_laneChanging: ");
		result.append(name_link_following_laneChanging);
		result.append(')');
		return result.toString();
	}

} //Link_Following_LaneChangingImpl
