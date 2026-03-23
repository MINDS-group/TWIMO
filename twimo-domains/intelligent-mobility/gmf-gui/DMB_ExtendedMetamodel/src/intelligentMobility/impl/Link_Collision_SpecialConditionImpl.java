/**
 */
package intelligentMobility.impl;

import intelligentMobility.Collision;
import intelligentMobility.IntelligentMobilityPackage;
import intelligentMobility.Link_Collision_SpecialCondition;
import intelligentMobility.Special_Condition;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Link Collision Special Condition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.impl.Link_Collision_SpecialConditionImpl#getName_link_collision_specialCondition <em>Name link collision special Condition</em>}</li>
 *   <li>{@link intelligentMobility.impl.Link_Collision_SpecialConditionImpl#getLink_collision <em>Link collision</em>}</li>
 *   <li>{@link intelligentMobility.impl.Link_Collision_SpecialConditionImpl#getLink_specialCondition <em>Link special Condition</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Link_Collision_SpecialConditionImpl extends MinimalEObjectImpl.Container implements Link_Collision_SpecialCondition {
	/**
	 * The default value of the '{@link #getName_link_collision_specialCondition() <em>Name link collision special Condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName_link_collision_specialCondition()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_LINK_COLLISION_SPECIAL_CONDITION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName_link_collision_specialCondition() <em>Name link collision special Condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName_link_collision_specialCondition()
	 * @generated
	 * @ordered
	 */
	protected String name_link_collision_specialCondition = NAME_LINK_COLLISION_SPECIAL_CONDITION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getLink_collision() <em>Link collision</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_collision()
	 * @generated
	 * @ordered
	 */
	protected Collision link_collision;

	/**
	 * The cached value of the '{@link #getLink_specialCondition() <em>Link special Condition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_specialCondition()
	 * @generated
	 * @ordered
	 */
	protected Special_Condition link_specialCondition;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Link_Collision_SpecialConditionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return IntelligentMobilityPackage.eINSTANCE.getLink_Collision_SpecialCondition();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName_link_collision_specialCondition() {
		return name_link_collision_specialCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName_link_collision_specialCondition(String newName_link_collision_specialCondition) {
		String oldName_link_collision_specialCondition = name_link_collision_specialCondition;
		name_link_collision_specialCondition = newName_link_collision_specialCondition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_COLLISION_SPECIAL_CONDITION__NAME_LINK_COLLISION_SPECIAL_CONDITION, oldName_link_collision_specialCondition, name_link_collision_specialCondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Collision getLink_collision() {
		if (link_collision != null && link_collision.eIsProxy()) {
			InternalEObject oldLink_collision = (InternalEObject)link_collision;
			link_collision = (Collision)eResolveProxy(oldLink_collision);
			if (link_collision != oldLink_collision) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LINK_COLLISION_SPECIAL_CONDITION__LINK_COLLISION, oldLink_collision, link_collision));
			}
		}
		return link_collision;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Collision basicGetLink_collision() {
		return link_collision;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLink_collision(Collision newLink_collision) {
		Collision oldLink_collision = link_collision;
		link_collision = newLink_collision;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_COLLISION_SPECIAL_CONDITION__LINK_COLLISION, oldLink_collision, link_collision));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Special_Condition getLink_specialCondition() {
		if (link_specialCondition != null && link_specialCondition.eIsProxy()) {
			InternalEObject oldLink_specialCondition = (InternalEObject)link_specialCondition;
			link_specialCondition = (Special_Condition)eResolveProxy(oldLink_specialCondition);
			if (link_specialCondition != oldLink_specialCondition) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LINK_COLLISION_SPECIAL_CONDITION__LINK_SPECIAL_CONDITION, oldLink_specialCondition, link_specialCondition));
			}
		}
		return link_specialCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Special_Condition basicGetLink_specialCondition() {
		return link_specialCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLink_specialCondition(Special_Condition newLink_specialCondition) {
		Special_Condition oldLink_specialCondition = link_specialCondition;
		link_specialCondition = newLink_specialCondition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_COLLISION_SPECIAL_CONDITION__LINK_SPECIAL_CONDITION, oldLink_specialCondition, link_specialCondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IntelligentMobilityPackage.LINK_COLLISION_SPECIAL_CONDITION__NAME_LINK_COLLISION_SPECIAL_CONDITION:
				return getName_link_collision_specialCondition();
			case IntelligentMobilityPackage.LINK_COLLISION_SPECIAL_CONDITION__LINK_COLLISION:
				if (resolve) return getLink_collision();
				return basicGetLink_collision();
			case IntelligentMobilityPackage.LINK_COLLISION_SPECIAL_CONDITION__LINK_SPECIAL_CONDITION:
				if (resolve) return getLink_specialCondition();
				return basicGetLink_specialCondition();
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
			case IntelligentMobilityPackage.LINK_COLLISION_SPECIAL_CONDITION__NAME_LINK_COLLISION_SPECIAL_CONDITION:
				setName_link_collision_specialCondition((String)newValue);
				return;
			case IntelligentMobilityPackage.LINK_COLLISION_SPECIAL_CONDITION__LINK_COLLISION:
				setLink_collision((Collision)newValue);
				return;
			case IntelligentMobilityPackage.LINK_COLLISION_SPECIAL_CONDITION__LINK_SPECIAL_CONDITION:
				setLink_specialCondition((Special_Condition)newValue);
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
			case IntelligentMobilityPackage.LINK_COLLISION_SPECIAL_CONDITION__NAME_LINK_COLLISION_SPECIAL_CONDITION:
				setName_link_collision_specialCondition(NAME_LINK_COLLISION_SPECIAL_CONDITION_EDEFAULT);
				return;
			case IntelligentMobilityPackage.LINK_COLLISION_SPECIAL_CONDITION__LINK_COLLISION:
				setLink_collision((Collision)null);
				return;
			case IntelligentMobilityPackage.LINK_COLLISION_SPECIAL_CONDITION__LINK_SPECIAL_CONDITION:
				setLink_specialCondition((Special_Condition)null);
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
			case IntelligentMobilityPackage.LINK_COLLISION_SPECIAL_CONDITION__NAME_LINK_COLLISION_SPECIAL_CONDITION:
				return NAME_LINK_COLLISION_SPECIAL_CONDITION_EDEFAULT == null ? name_link_collision_specialCondition != null : !NAME_LINK_COLLISION_SPECIAL_CONDITION_EDEFAULT.equals(name_link_collision_specialCondition);
			case IntelligentMobilityPackage.LINK_COLLISION_SPECIAL_CONDITION__LINK_COLLISION:
				return link_collision != null;
			case IntelligentMobilityPackage.LINK_COLLISION_SPECIAL_CONDITION__LINK_SPECIAL_CONDITION:
				return link_specialCondition != null;
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
		result.append(" (name_link_collision_specialCondition: ");
		result.append(name_link_collision_specialCondition);
		result.append(')');
		return result.toString();
	}

} //Link_Collision_SpecialConditionImpl
