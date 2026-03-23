/**
 */
package intelligentMobility.impl;

import intelligentMobility.Collision;
import intelligentMobility.IntelligentMobilityPackage;
import intelligentMobility.Intersection;
import intelligentMobility.Special_Condition;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Special Condition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.impl.Special_ConditionImpl#getConditionName <em>Condition Name</em>}</li>
 *   <li>{@link intelligentMobility.impl.Special_ConditionImpl#getCollision <em>Collision</em>}</li>
 *   <li>{@link intelligentMobility.impl.Special_ConditionImpl#getIntersection <em>Intersection</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Special_ConditionImpl extends MinimalEObjectImpl.Container implements Special_Condition {
	/**
	 * The default value of the '{@link #getConditionName() <em>Condition Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConditionName()
	 * @generated
	 * @ordered
	 */
	protected static final String CONDITION_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getConditionName() <em>Condition Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConditionName()
	 * @generated
	 * @ordered
	 */
	protected String conditionName = CONDITION_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getCollision() <em>Collision</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCollision()
	 * @generated
	 * @ordered
	 */
	protected Collision collision;

	/**
	 * The cached value of the '{@link #getIntersection() <em>Intersection</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntersection()
	 * @generated
	 * @ordered
	 */
	protected EList intersection;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Special_ConditionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return IntelligentMobilityPackage.eINSTANCE.getSpecial_Condition();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getConditionName() {
		return conditionName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConditionName(String newConditionName) {
		String oldConditionName = conditionName;
		conditionName = newConditionName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.SPECIAL_CONDITION__CONDITION_NAME, oldConditionName, conditionName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Collision getCollision() {
		return collision;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCollision(Collision newCollision, NotificationChain msgs) {
		Collision oldCollision = collision;
		collision = newCollision;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.SPECIAL_CONDITION__COLLISION, oldCollision, newCollision);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCollision(Collision newCollision) {
		if (newCollision != collision) {
			NotificationChain msgs = null;
			if (collision != null)
				msgs = ((InternalEObject)collision).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IntelligentMobilityPackage.SPECIAL_CONDITION__COLLISION, null, msgs);
			if (newCollision != null)
				msgs = ((InternalEObject)newCollision).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IntelligentMobilityPackage.SPECIAL_CONDITION__COLLISION, null, msgs);
			msgs = basicSetCollision(newCollision, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.SPECIAL_CONDITION__COLLISION, newCollision, newCollision));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getIntersection() {
		if (intersection == null) {
			intersection = new EObjectContainmentEList(Intersection.class, this, IntelligentMobilityPackage.SPECIAL_CONDITION__INTERSECTION);
		}
		return intersection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case IntelligentMobilityPackage.SPECIAL_CONDITION__COLLISION:
				return basicSetCollision(null, msgs);
			case IntelligentMobilityPackage.SPECIAL_CONDITION__INTERSECTION:
				return ((InternalEList)getIntersection()).basicRemove(otherEnd, msgs);
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
			case IntelligentMobilityPackage.SPECIAL_CONDITION__CONDITION_NAME:
				return getConditionName();
			case IntelligentMobilityPackage.SPECIAL_CONDITION__COLLISION:
				return getCollision();
			case IntelligentMobilityPackage.SPECIAL_CONDITION__INTERSECTION:
				return getIntersection();
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
			case IntelligentMobilityPackage.SPECIAL_CONDITION__CONDITION_NAME:
				setConditionName((String)newValue);
				return;
			case IntelligentMobilityPackage.SPECIAL_CONDITION__COLLISION:
				setCollision((Collision)newValue);
				return;
			case IntelligentMobilityPackage.SPECIAL_CONDITION__INTERSECTION:
				getIntersection().clear();
				getIntersection().addAll((Collection)newValue);
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
			case IntelligentMobilityPackage.SPECIAL_CONDITION__CONDITION_NAME:
				setConditionName(CONDITION_NAME_EDEFAULT);
				return;
			case IntelligentMobilityPackage.SPECIAL_CONDITION__COLLISION:
				setCollision((Collision)null);
				return;
			case IntelligentMobilityPackage.SPECIAL_CONDITION__INTERSECTION:
				getIntersection().clear();
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
			case IntelligentMobilityPackage.SPECIAL_CONDITION__CONDITION_NAME:
				return CONDITION_NAME_EDEFAULT == null ? conditionName != null : !CONDITION_NAME_EDEFAULT.equals(conditionName);
			case IntelligentMobilityPackage.SPECIAL_CONDITION__COLLISION:
				return collision != null;
			case IntelligentMobilityPackage.SPECIAL_CONDITION__INTERSECTION:
				return intersection != null && !intersection.isEmpty();
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
		result.append(" (conditionName: ");
		result.append(conditionName);
		result.append(')');
		return result.toString();
	}

} //Special_ConditionImpl
