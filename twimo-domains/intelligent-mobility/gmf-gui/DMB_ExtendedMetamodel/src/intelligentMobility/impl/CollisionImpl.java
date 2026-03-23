/**
 */
package intelligentMobility.impl;

import intelligentMobility.Collision;
import intelligentMobility.IntelligentMobilityPackage;
import intelligentMobility.Obstruction;

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
 * An implementation of the model object '<em><b>Collision</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.impl.CollisionImpl#getRecoveryTime <em>Recovery Time</em>}</li>
 *   <li>{@link intelligentMobility.impl.CollisionImpl#getName <em>Name</em>}</li>
 *   <li>{@link intelligentMobility.impl.CollisionImpl#getObstructions <em>Obstructions</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CollisionImpl extends ExceptionConditionImpl implements Collision {
	/**
	 * The default value of the '{@link #getRecoveryTime() <em>Recovery Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRecoveryTime()
	 * @generated
	 * @ordered
	 */
	protected static final int RECOVERY_TIME_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getRecoveryTime() <em>Recovery Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRecoveryTime()
	 * @generated
	 * @ordered
	 */
	protected int recoveryTime = RECOVERY_TIME_EDEFAULT;

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
	 * The cached value of the '{@link #getObstructions() <em>Obstructions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObstructions()
	 * @generated
	 * @ordered
	 */
	protected EList obstructions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CollisionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return IntelligentMobilityPackage.eINSTANCE.getCollision();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getRecoveryTime() {
		return recoveryTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRecoveryTime(int newRecoveryTime) {
		int oldRecoveryTime = recoveryTime;
		recoveryTime = newRecoveryTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.COLLISION__RECOVERY_TIME, oldRecoveryTime, recoveryTime));
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
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.COLLISION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getObstructions() {
		if (obstructions == null) {
			obstructions = new EObjectContainmentEList(Obstruction.class, this, IntelligentMobilityPackage.COLLISION__OBSTRUCTIONS);
		}
		return obstructions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case IntelligentMobilityPackage.COLLISION__OBSTRUCTIONS:
				return ((InternalEList)getObstructions()).basicRemove(otherEnd, msgs);
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
			case IntelligentMobilityPackage.COLLISION__RECOVERY_TIME:
				return new Integer(getRecoveryTime());
			case IntelligentMobilityPackage.COLLISION__NAME:
				return getName();
			case IntelligentMobilityPackage.COLLISION__OBSTRUCTIONS:
				return getObstructions();
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
			case IntelligentMobilityPackage.COLLISION__RECOVERY_TIME:
				setRecoveryTime(((Integer)newValue).intValue());
				return;
			case IntelligentMobilityPackage.COLLISION__NAME:
				setName((String)newValue);
				return;
			case IntelligentMobilityPackage.COLLISION__OBSTRUCTIONS:
				getObstructions().clear();
				getObstructions().addAll((Collection)newValue);
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
			case IntelligentMobilityPackage.COLLISION__RECOVERY_TIME:
				setRecoveryTime(RECOVERY_TIME_EDEFAULT);
				return;
			case IntelligentMobilityPackage.COLLISION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case IntelligentMobilityPackage.COLLISION__OBSTRUCTIONS:
				getObstructions().clear();
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
			case IntelligentMobilityPackage.COLLISION__RECOVERY_TIME:
				return recoveryTime != RECOVERY_TIME_EDEFAULT;
			case IntelligentMobilityPackage.COLLISION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case IntelligentMobilityPackage.COLLISION__OBSTRUCTIONS:
				return obstructions != null && !obstructions.isEmpty();
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
		result.append(" (recoveryTime: ");
		result.append(recoveryTime);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //CollisionImpl
