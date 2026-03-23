/**
 */
package intelligentMobility.impl;

import intelligentMobility.Driving_Behaviour;
import intelligentMobility.IntelligentMobilityPackage;
import intelligentMobility.Link_DrivingBehaviour_NormalBehaviour;
import intelligentMobility.Normal_Behaviour;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Link Driving Behaviour Normal Behaviour</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.impl.Link_DrivingBehaviour_NormalBehaviourImpl#getName_link_driving_normal <em>Name link driving normal</em>}</li>
 *   <li>{@link intelligentMobility.impl.Link_DrivingBehaviour_NormalBehaviourImpl#getLink_driving_behaviour <em>Link driving behaviour</em>}</li>
 *   <li>{@link intelligentMobility.impl.Link_DrivingBehaviour_NormalBehaviourImpl#getLink_normal_behaviour <em>Link normal behaviour</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Link_DrivingBehaviour_NormalBehaviourImpl extends MinimalEObjectImpl.Container implements Link_DrivingBehaviour_NormalBehaviour {
	/**
	 * The default value of the '{@link #getName_link_driving_normal() <em>Name link driving normal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName_link_driving_normal()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_LINK_DRIVING_NORMAL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName_link_driving_normal() <em>Name link driving normal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName_link_driving_normal()
	 * @generated
	 * @ordered
	 */
	protected String name_link_driving_normal = NAME_LINK_DRIVING_NORMAL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getLink_driving_behaviour() <em>Link driving behaviour</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_driving_behaviour()
	 * @generated
	 * @ordered
	 */
	protected Driving_Behaviour link_driving_behaviour;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Link_DrivingBehaviour_NormalBehaviourImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return IntelligentMobilityPackage.eINSTANCE.getLink_DrivingBehaviour_NormalBehaviour();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName_link_driving_normal() {
		return name_link_driving_normal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName_link_driving_normal(String newName_link_driving_normal) {
		String oldName_link_driving_normal = name_link_driving_normal;
		name_link_driving_normal = newName_link_driving_normal;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_DRIVING_BEHAVIOUR_NORMAL_BEHAVIOUR__NAME_LINK_DRIVING_NORMAL, oldName_link_driving_normal, name_link_driving_normal));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Driving_Behaviour getLink_driving_behaviour() {
		if (link_driving_behaviour != null && link_driving_behaviour.eIsProxy()) {
			InternalEObject oldLink_driving_behaviour = (InternalEObject)link_driving_behaviour;
			link_driving_behaviour = (Driving_Behaviour)eResolveProxy(oldLink_driving_behaviour);
			if (link_driving_behaviour != oldLink_driving_behaviour) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LINK_DRIVING_BEHAVIOUR_NORMAL_BEHAVIOUR__LINK_DRIVING_BEHAVIOUR, oldLink_driving_behaviour, link_driving_behaviour));
			}
		}
		return link_driving_behaviour;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Driving_Behaviour basicGetLink_driving_behaviour() {
		return link_driving_behaviour;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLink_driving_behaviour(Driving_Behaviour newLink_driving_behaviour) {
		Driving_Behaviour oldLink_driving_behaviour = link_driving_behaviour;
		link_driving_behaviour = newLink_driving_behaviour;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_DRIVING_BEHAVIOUR_NORMAL_BEHAVIOUR__LINK_DRIVING_BEHAVIOUR, oldLink_driving_behaviour, link_driving_behaviour));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LINK_DRIVING_BEHAVIOUR_NORMAL_BEHAVIOUR__LINK_NORMAL_BEHAVIOUR, oldLink_normal_behaviour, link_normal_behaviour));
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
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_DRIVING_BEHAVIOUR_NORMAL_BEHAVIOUR__LINK_NORMAL_BEHAVIOUR, oldLink_normal_behaviour, link_normal_behaviour));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IntelligentMobilityPackage.LINK_DRIVING_BEHAVIOUR_NORMAL_BEHAVIOUR__NAME_LINK_DRIVING_NORMAL:
				return getName_link_driving_normal();
			case IntelligentMobilityPackage.LINK_DRIVING_BEHAVIOUR_NORMAL_BEHAVIOUR__LINK_DRIVING_BEHAVIOUR:
				if (resolve) return getLink_driving_behaviour();
				return basicGetLink_driving_behaviour();
			case IntelligentMobilityPackage.LINK_DRIVING_BEHAVIOUR_NORMAL_BEHAVIOUR__LINK_NORMAL_BEHAVIOUR:
				if (resolve) return getLink_normal_behaviour();
				return basicGetLink_normal_behaviour();
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
			case IntelligentMobilityPackage.LINK_DRIVING_BEHAVIOUR_NORMAL_BEHAVIOUR__NAME_LINK_DRIVING_NORMAL:
				setName_link_driving_normal((String)newValue);
				return;
			case IntelligentMobilityPackage.LINK_DRIVING_BEHAVIOUR_NORMAL_BEHAVIOUR__LINK_DRIVING_BEHAVIOUR:
				setLink_driving_behaviour((Driving_Behaviour)newValue);
				return;
			case IntelligentMobilityPackage.LINK_DRIVING_BEHAVIOUR_NORMAL_BEHAVIOUR__LINK_NORMAL_BEHAVIOUR:
				setLink_normal_behaviour((Normal_Behaviour)newValue);
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
			case IntelligentMobilityPackage.LINK_DRIVING_BEHAVIOUR_NORMAL_BEHAVIOUR__NAME_LINK_DRIVING_NORMAL:
				setName_link_driving_normal(NAME_LINK_DRIVING_NORMAL_EDEFAULT);
				return;
			case IntelligentMobilityPackage.LINK_DRIVING_BEHAVIOUR_NORMAL_BEHAVIOUR__LINK_DRIVING_BEHAVIOUR:
				setLink_driving_behaviour((Driving_Behaviour)null);
				return;
			case IntelligentMobilityPackage.LINK_DRIVING_BEHAVIOUR_NORMAL_BEHAVIOUR__LINK_NORMAL_BEHAVIOUR:
				setLink_normal_behaviour((Normal_Behaviour)null);
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
			case IntelligentMobilityPackage.LINK_DRIVING_BEHAVIOUR_NORMAL_BEHAVIOUR__NAME_LINK_DRIVING_NORMAL:
				return NAME_LINK_DRIVING_NORMAL_EDEFAULT == null ? name_link_driving_normal != null : !NAME_LINK_DRIVING_NORMAL_EDEFAULT.equals(name_link_driving_normal);
			case IntelligentMobilityPackage.LINK_DRIVING_BEHAVIOUR_NORMAL_BEHAVIOUR__LINK_DRIVING_BEHAVIOUR:
				return link_driving_behaviour != null;
			case IntelligentMobilityPackage.LINK_DRIVING_BEHAVIOUR_NORMAL_BEHAVIOUR__LINK_NORMAL_BEHAVIOUR:
				return link_normal_behaviour != null;
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
		result.append(" (name_link_driving_normal: ");
		result.append(name_link_driving_normal);
		result.append(')');
		return result.toString();
	}

} //Link_DrivingBehaviour_NormalBehaviourImpl
