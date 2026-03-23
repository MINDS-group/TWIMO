/**
 */
package intelligentMobility.impl;

import intelligentMobility.Abnormal_Behaviour;
import intelligentMobility.Action;
import intelligentMobility.IntelligentMobilityPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abnormal Behaviour</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.impl.Abnormal_BehaviourImpl#isZigzag_Driving <em>Zigzag Driving</em>}</li>
 *   <li>{@link intelligentMobility.impl.Abnormal_BehaviourImpl#isRisky_Acceleration <em>Risky Acceleration</em>}</li>
 *   <li>{@link intelligentMobility.impl.Abnormal_BehaviourImpl#isRisky_Lanechanging <em>Risky Lanechanging</em>}</li>
 *   <li>{@link intelligentMobility.impl.Abnormal_BehaviourImpl#getName <em>Name</em>}</li>
 *   <li>{@link intelligentMobility.impl.Abnormal_BehaviourImpl#getActions <em>Actions</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Abnormal_BehaviourImpl extends Normal_BehaviourImpl implements Abnormal_Behaviour {
	/**
	 * The default value of the '{@link #isZigzag_Driving() <em>Zigzag Driving</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isZigzag_Driving()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ZIGZAG_DRIVING_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isZigzag_Driving() <em>Zigzag Driving</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isZigzag_Driving()
	 * @generated
	 * @ordered
	 */
	protected boolean zigzag_Driving = ZIGZAG_DRIVING_EDEFAULT;

	/**
	 * The default value of the '{@link #isRisky_Acceleration() <em>Risky Acceleration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRisky_Acceleration()
	 * @generated
	 * @ordered
	 */
	protected static final boolean RISKY_ACCELERATION_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isRisky_Acceleration() <em>Risky Acceleration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRisky_Acceleration()
	 * @generated
	 * @ordered
	 */
	protected boolean risky_Acceleration = RISKY_ACCELERATION_EDEFAULT;

	/**
	 * The default value of the '{@link #isRisky_Lanechanging() <em>Risky Lanechanging</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRisky_Lanechanging()
	 * @generated
	 * @ordered
	 */
	protected static final boolean RISKY_LANECHANGING_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isRisky_Lanechanging() <em>Risky Lanechanging</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRisky_Lanechanging()
	 * @generated
	 * @ordered
	 */
	protected boolean risky_Lanechanging = RISKY_LANECHANGING_EDEFAULT;

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
	 * The cached value of the '{@link #getActions() <em>Actions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActions()
	 * @generated
	 * @ordered
	 */
	protected EList actions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Abnormal_BehaviourImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return IntelligentMobilityPackage.eINSTANCE.getAbnormal_Behaviour();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isZigzag_Driving() {
		return zigzag_Driving;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setZigzag_Driving(boolean newZigzag_Driving) {
		boolean oldZigzag_Driving = zigzag_Driving;
		zigzag_Driving = newZigzag_Driving;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.ABNORMAL_BEHAVIOUR__ZIGZAG_DRIVING, oldZigzag_Driving, zigzag_Driving));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRisky_Acceleration() {
		return risky_Acceleration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRisky_Acceleration(boolean newRisky_Acceleration) {
		boolean oldRisky_Acceleration = risky_Acceleration;
		risky_Acceleration = newRisky_Acceleration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.ABNORMAL_BEHAVIOUR__RISKY_ACCELERATION, oldRisky_Acceleration, risky_Acceleration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRisky_Lanechanging() {
		return risky_Lanechanging;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRisky_Lanechanging(boolean newRisky_Lanechanging) {
		boolean oldRisky_Lanechanging = risky_Lanechanging;
		risky_Lanechanging = newRisky_Lanechanging;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.ABNORMAL_BEHAVIOUR__RISKY_LANECHANGING, oldRisky_Lanechanging, risky_Lanechanging));
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
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.ABNORMAL_BEHAVIOUR__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getActions() {
		if (actions == null) {
			actions = new EObjectContainmentEList(Action.class, this, IntelligentMobilityPackage.ABNORMAL_BEHAVIOUR__ACTIONS);
		}
		return actions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case IntelligentMobilityPackage.ABNORMAL_BEHAVIOUR__ACTIONS:
				return ((InternalEList)getActions()).basicRemove(otherEnd, msgs);
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
			case IntelligentMobilityPackage.ABNORMAL_BEHAVIOUR__ZIGZAG_DRIVING:
				return isZigzag_Driving() ? Boolean.TRUE : Boolean.FALSE;
			case IntelligentMobilityPackage.ABNORMAL_BEHAVIOUR__RISKY_ACCELERATION:
				return isRisky_Acceleration() ? Boolean.TRUE : Boolean.FALSE;
			case IntelligentMobilityPackage.ABNORMAL_BEHAVIOUR__RISKY_LANECHANGING:
				return isRisky_Lanechanging() ? Boolean.TRUE : Boolean.FALSE;
			case IntelligentMobilityPackage.ABNORMAL_BEHAVIOUR__NAME:
				return getName();
			case IntelligentMobilityPackage.ABNORMAL_BEHAVIOUR__ACTIONS:
				return getActions();
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
			case IntelligentMobilityPackage.ABNORMAL_BEHAVIOUR__ZIGZAG_DRIVING:
				setZigzag_Driving(((Boolean)newValue).booleanValue());
				return;
			case IntelligentMobilityPackage.ABNORMAL_BEHAVIOUR__RISKY_ACCELERATION:
				setRisky_Acceleration(((Boolean)newValue).booleanValue());
				return;
			case IntelligentMobilityPackage.ABNORMAL_BEHAVIOUR__RISKY_LANECHANGING:
				setRisky_Lanechanging(((Boolean)newValue).booleanValue());
				return;
			case IntelligentMobilityPackage.ABNORMAL_BEHAVIOUR__NAME:
				setName((String)newValue);
				return;
			case IntelligentMobilityPackage.ABNORMAL_BEHAVIOUR__ACTIONS:
				getActions().clear();
				getActions().addAll((Collection)newValue);
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
			case IntelligentMobilityPackage.ABNORMAL_BEHAVIOUR__ZIGZAG_DRIVING:
				setZigzag_Driving(ZIGZAG_DRIVING_EDEFAULT);
				return;
			case IntelligentMobilityPackage.ABNORMAL_BEHAVIOUR__RISKY_ACCELERATION:
				setRisky_Acceleration(RISKY_ACCELERATION_EDEFAULT);
				return;
			case IntelligentMobilityPackage.ABNORMAL_BEHAVIOUR__RISKY_LANECHANGING:
				setRisky_Lanechanging(RISKY_LANECHANGING_EDEFAULT);
				return;
			case IntelligentMobilityPackage.ABNORMAL_BEHAVIOUR__NAME:
				setName(NAME_EDEFAULT);
				return;
			case IntelligentMobilityPackage.ABNORMAL_BEHAVIOUR__ACTIONS:
				getActions().clear();
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
			case IntelligentMobilityPackage.ABNORMAL_BEHAVIOUR__ZIGZAG_DRIVING:
				return zigzag_Driving != ZIGZAG_DRIVING_EDEFAULT;
			case IntelligentMobilityPackage.ABNORMAL_BEHAVIOUR__RISKY_ACCELERATION:
				return risky_Acceleration != RISKY_ACCELERATION_EDEFAULT;
			case IntelligentMobilityPackage.ABNORMAL_BEHAVIOUR__RISKY_LANECHANGING:
				return risky_Lanechanging != RISKY_LANECHANGING_EDEFAULT;
			case IntelligentMobilityPackage.ABNORMAL_BEHAVIOUR__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case IntelligentMobilityPackage.ABNORMAL_BEHAVIOUR__ACTIONS:
				return actions != null && !actions.isEmpty();
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
		result.append(" (zigzag_Driving: ");
		result.append(zigzag_Driving);
		result.append(", risky_Acceleration: ");
		result.append(risky_Acceleration);
		result.append(", risky_Lanechanging: ");
		result.append(risky_Lanechanging);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //Abnormal_BehaviourImpl
