/**
 */
package intelligentMobility.impl;

import intelligentMobility.Following;
import intelligentMobility.IntelligentMobilityPackage;
import intelligentMobility.LaneChanging;
import intelligentMobility.Normal_Behaviour;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Normal Behaviour</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.impl.Normal_BehaviourImpl#getFollowing <em>Following</em>}</li>
 *   <li>{@link intelligentMobility.impl.Normal_BehaviourImpl#getLanechanging <em>Lanechanging</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Normal_BehaviourImpl extends MinimalEObjectImpl.Container implements Normal_Behaviour {
	/**
	 * The cached value of the '{@link #getFollowing() <em>Following</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFollowing()
	 * @generated
	 * @ordered
	 */
	protected Following following;

	/**
	 * The cached value of the '{@link #getLanechanging() <em>Lanechanging</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLanechanging()
	 * @generated
	 * @ordered
	 */
	protected LaneChanging lanechanging;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Normal_BehaviourImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return IntelligentMobilityPackage.eINSTANCE.getNormal_Behaviour();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Following getFollowing() {
		return following;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFollowing(Following newFollowing, NotificationChain msgs) {
		Following oldFollowing = following;
		following = newFollowing;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.NORMAL_BEHAVIOUR__FOLLOWING, oldFollowing, newFollowing);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFollowing(Following newFollowing) {
		if (newFollowing != following) {
			NotificationChain msgs = null;
			if (following != null)
				msgs = ((InternalEObject)following).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IntelligentMobilityPackage.NORMAL_BEHAVIOUR__FOLLOWING, null, msgs);
			if (newFollowing != null)
				msgs = ((InternalEObject)newFollowing).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IntelligentMobilityPackage.NORMAL_BEHAVIOUR__FOLLOWING, null, msgs);
			msgs = basicSetFollowing(newFollowing, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.NORMAL_BEHAVIOUR__FOLLOWING, newFollowing, newFollowing));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LaneChanging getLanechanging() {
		return lanechanging;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLanechanging(LaneChanging newLanechanging, NotificationChain msgs) {
		LaneChanging oldLanechanging = lanechanging;
		lanechanging = newLanechanging;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.NORMAL_BEHAVIOUR__LANECHANGING, oldLanechanging, newLanechanging);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLanechanging(LaneChanging newLanechanging) {
		if (newLanechanging != lanechanging) {
			NotificationChain msgs = null;
			if (lanechanging != null)
				msgs = ((InternalEObject)lanechanging).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IntelligentMobilityPackage.NORMAL_BEHAVIOUR__LANECHANGING, null, msgs);
			if (newLanechanging != null)
				msgs = ((InternalEObject)newLanechanging).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IntelligentMobilityPackage.NORMAL_BEHAVIOUR__LANECHANGING, null, msgs);
			msgs = basicSetLanechanging(newLanechanging, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.NORMAL_BEHAVIOUR__LANECHANGING, newLanechanging, newLanechanging));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case IntelligentMobilityPackage.NORMAL_BEHAVIOUR__FOLLOWING:
				return basicSetFollowing(null, msgs);
			case IntelligentMobilityPackage.NORMAL_BEHAVIOUR__LANECHANGING:
				return basicSetLanechanging(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IntelligentMobilityPackage.NORMAL_BEHAVIOUR__FOLLOWING:
				return getFollowing();
			case IntelligentMobilityPackage.NORMAL_BEHAVIOUR__LANECHANGING:
				return getLanechanging();
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
			case IntelligentMobilityPackage.NORMAL_BEHAVIOUR__FOLLOWING:
				setFollowing((Following)newValue);
				return;
			case IntelligentMobilityPackage.NORMAL_BEHAVIOUR__LANECHANGING:
				setLanechanging((LaneChanging)newValue);
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
			case IntelligentMobilityPackage.NORMAL_BEHAVIOUR__FOLLOWING:
				setFollowing((Following)null);
				return;
			case IntelligentMobilityPackage.NORMAL_BEHAVIOUR__LANECHANGING:
				setLanechanging((LaneChanging)null);
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
			case IntelligentMobilityPackage.NORMAL_BEHAVIOUR__FOLLOWING:
				return following != null;
			case IntelligentMobilityPackage.NORMAL_BEHAVIOUR__LANECHANGING:
				return lanechanging != null;
		}
		return super.eIsSet(featureID);
	}

} //Normal_BehaviourImpl
