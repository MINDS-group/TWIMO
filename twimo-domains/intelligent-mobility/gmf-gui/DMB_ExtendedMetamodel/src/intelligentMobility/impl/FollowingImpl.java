/**
 */
package intelligentMobility.impl;

import intelligentMobility.Backward;
import intelligentMobility.Following;
import intelligentMobility.Forward;
import intelligentMobility.IntelligentMobilityPackage;
import intelligentMobility.LaneChanging;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Following</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.impl.FollowingImpl#getFollowingGap <em>Following Gap</em>}</li>
 *   <li>{@link intelligentMobility.impl.FollowingImpl#getName <em>Name</em>}</li>
 *   <li>{@link intelligentMobility.impl.FollowingImpl#getMinGap <em>Min Gap</em>}</li>
 *   <li>{@link intelligentMobility.impl.FollowingImpl#getForward <em>Forward</em>}</li>
 *   <li>{@link intelligentMobility.impl.FollowingImpl#getBackward <em>Backward</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FollowingImpl extends MinimalEObjectImpl.Container implements Following {
	/**
	 * The default value of the '{@link #getFollowingGap() <em>Following Gap</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFollowingGap()
	 * @generated
	 * @ordered
	 */
	protected static final int FOLLOWING_GAP_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getFollowingGap() <em>Following Gap</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFollowingGap()
	 * @generated
	 * @ordered
	 */
	protected int followingGap = FOLLOWING_GAP_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMinGap() <em>Min Gap</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinGap()
	 * @generated
	 * @ordered
	 */
	protected LaneChanging minGap;

	/**
	 * The cached value of the '{@link #getForward() <em>Forward</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getForward()
	 * @generated
	 * @ordered
	 */
	protected Forward forward;

	/**
	 * The cached value of the '{@link #getBackward() <em>Backward</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBackward()
	 * @generated
	 * @ordered
	 */
	protected Backward backward;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FollowingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return IntelligentMobilityPackage.eINSTANCE.getFollowing();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getFollowingGap() {
		return followingGap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFollowingGap(int newFollowingGap) {
		int oldFollowingGap = followingGap;
		followingGap = newFollowingGap;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.FOLLOWING__FOLLOWING_GAP, oldFollowingGap, followingGap));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.FOLLOWING__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LaneChanging getMinGap() {
		if (minGap != null && minGap.eIsProxy()) {
			InternalEObject oldMinGap = (InternalEObject)minGap;
			minGap = (LaneChanging)eResolveProxy(oldMinGap);
			if (minGap != oldMinGap) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.FOLLOWING__MIN_GAP, oldMinGap, minGap));
			}
		}
		return minGap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LaneChanging basicGetMinGap() {
		return minGap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinGap(LaneChanging newMinGap) {
		LaneChanging oldMinGap = minGap;
		minGap = newMinGap;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.FOLLOWING__MIN_GAP, oldMinGap, minGap));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Forward getForward() {
		return forward;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetForward(Forward newForward, NotificationChain msgs) {
		Forward oldForward = forward;
		forward = newForward;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.FOLLOWING__FORWARD, oldForward, newForward);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setForward(Forward newForward) {
		if (newForward != forward) {
			NotificationChain msgs = null;
			if (forward != null)
				msgs = ((InternalEObject)forward).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IntelligentMobilityPackage.FOLLOWING__FORWARD, null, msgs);
			if (newForward != null)
				msgs = ((InternalEObject)newForward).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IntelligentMobilityPackage.FOLLOWING__FORWARD, null, msgs);
			msgs = basicSetForward(newForward, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.FOLLOWING__FORWARD, newForward, newForward));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Backward getBackward() {
		return backward;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBackward(Backward newBackward, NotificationChain msgs) {
		Backward oldBackward = backward;
		backward = newBackward;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.FOLLOWING__BACKWARD, oldBackward, newBackward);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBackward(Backward newBackward) {
		if (newBackward != backward) {
			NotificationChain msgs = null;
			if (backward != null)
				msgs = ((InternalEObject)backward).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IntelligentMobilityPackage.FOLLOWING__BACKWARD, null, msgs);
			if (newBackward != null)
				msgs = ((InternalEObject)newBackward).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IntelligentMobilityPackage.FOLLOWING__BACKWARD, null, msgs);
			msgs = basicSetBackward(newBackward, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.FOLLOWING__BACKWARD, newBackward, newBackward));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case IntelligentMobilityPackage.FOLLOWING__FORWARD:
				return basicSetForward(null, msgs);
			case IntelligentMobilityPackage.FOLLOWING__BACKWARD:
				return basicSetBackward(null, msgs);
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
			case IntelligentMobilityPackage.FOLLOWING__FOLLOWING_GAP:
				return new Integer(getFollowingGap());
			case IntelligentMobilityPackage.FOLLOWING__NAME:
				return getName();
			case IntelligentMobilityPackage.FOLLOWING__MIN_GAP:
				if (resolve) return getMinGap();
				return basicGetMinGap();
			case IntelligentMobilityPackage.FOLLOWING__FORWARD:
				return getForward();
			case IntelligentMobilityPackage.FOLLOWING__BACKWARD:
				return getBackward();
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
			case IntelligentMobilityPackage.FOLLOWING__FOLLOWING_GAP:
				setFollowingGap(((Integer)newValue).intValue());
				return;
			case IntelligentMobilityPackage.FOLLOWING__NAME:
				setName((String)newValue);
				return;
			case IntelligentMobilityPackage.FOLLOWING__MIN_GAP:
				setMinGap((LaneChanging)newValue);
				return;
			case IntelligentMobilityPackage.FOLLOWING__FORWARD:
				setForward((Forward)newValue);
				return;
			case IntelligentMobilityPackage.FOLLOWING__BACKWARD:
				setBackward((Backward)newValue);
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
			case IntelligentMobilityPackage.FOLLOWING__FOLLOWING_GAP:
				setFollowingGap(FOLLOWING_GAP_EDEFAULT);
				return;
			case IntelligentMobilityPackage.FOLLOWING__NAME:
				setName(NAME_EDEFAULT);
				return;
			case IntelligentMobilityPackage.FOLLOWING__MIN_GAP:
				setMinGap((LaneChanging)null);
				return;
			case IntelligentMobilityPackage.FOLLOWING__FORWARD:
				setForward((Forward)null);
				return;
			case IntelligentMobilityPackage.FOLLOWING__BACKWARD:
				setBackward((Backward)null);
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
			case IntelligentMobilityPackage.FOLLOWING__FOLLOWING_GAP:
				return followingGap != FOLLOWING_GAP_EDEFAULT;
			case IntelligentMobilityPackage.FOLLOWING__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case IntelligentMobilityPackage.FOLLOWING__MIN_GAP:
				return minGap != null;
			case IntelligentMobilityPackage.FOLLOWING__FORWARD:
				return forward != null;
			case IntelligentMobilityPackage.FOLLOWING__BACKWARD:
				return backward != null;
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
		result.append(" (followingGap: ");
		result.append(followingGap);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //FollowingImpl
