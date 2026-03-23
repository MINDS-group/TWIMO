/**
 */
package intelligentMobility.impl;

import intelligentMobility.Driving_Behaviour;
import intelligentMobility.Goal;
import intelligentMobility.IntelligentMobilityPackage;
import intelligentMobility.Link_Goal_DrivingBehaviour;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Link Goal Driving Behaviour</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.impl.Link_Goal_DrivingBehaviourImpl#getName_link_goal_drivingBehaviour <em>Name link goal driving Behaviour</em>}</li>
 *   <li>{@link intelligentMobility.impl.Link_Goal_DrivingBehaviourImpl#getLink_goal <em>Link goal</em>}</li>
 *   <li>{@link intelligentMobility.impl.Link_Goal_DrivingBehaviourImpl#getLink_drivingBehaviour <em>Link driving Behaviour</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Link_Goal_DrivingBehaviourImpl extends MinimalEObjectImpl.Container implements Link_Goal_DrivingBehaviour {
	/**
	 * The default value of the '{@link #getName_link_goal_drivingBehaviour() <em>Name link goal driving Behaviour</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName_link_goal_drivingBehaviour()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_LINK_GOAL_DRIVING_BEHAVIOUR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName_link_goal_drivingBehaviour() <em>Name link goal driving Behaviour</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName_link_goal_drivingBehaviour()
	 * @generated
	 * @ordered
	 */
	protected String name_link_goal_drivingBehaviour = NAME_LINK_GOAL_DRIVING_BEHAVIOUR_EDEFAULT;

	/**
	 * The cached value of the '{@link #getLink_goal() <em>Link goal</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_goal()
	 * @generated
	 * @ordered
	 */
	protected Goal link_goal;

	/**
	 * The cached value of the '{@link #getLink_drivingBehaviour() <em>Link driving Behaviour</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_drivingBehaviour()
	 * @generated
	 * @ordered
	 */
	protected Driving_Behaviour link_drivingBehaviour;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Link_Goal_DrivingBehaviourImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return IntelligentMobilityPackage.eINSTANCE.getLink_Goal_DrivingBehaviour();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName_link_goal_drivingBehaviour() {
		return name_link_goal_drivingBehaviour;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName_link_goal_drivingBehaviour(String newName_link_goal_drivingBehaviour) {
		String oldName_link_goal_drivingBehaviour = name_link_goal_drivingBehaviour;
		name_link_goal_drivingBehaviour = newName_link_goal_drivingBehaviour;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_GOAL_DRIVING_BEHAVIOUR__NAME_LINK_GOAL_DRIVING_BEHAVIOUR, oldName_link_goal_drivingBehaviour, name_link_goal_drivingBehaviour));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Goal getLink_goal() {
		if (link_goal != null && link_goal.eIsProxy()) {
			InternalEObject oldLink_goal = (InternalEObject)link_goal;
			link_goal = (Goal)eResolveProxy(oldLink_goal);
			if (link_goal != oldLink_goal) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LINK_GOAL_DRIVING_BEHAVIOUR__LINK_GOAL, oldLink_goal, link_goal));
			}
		}
		return link_goal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Goal basicGetLink_goal() {
		return link_goal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLink_goal(Goal newLink_goal) {
		Goal oldLink_goal = link_goal;
		link_goal = newLink_goal;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_GOAL_DRIVING_BEHAVIOUR__LINK_GOAL, oldLink_goal, link_goal));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Driving_Behaviour getLink_drivingBehaviour() {
		if (link_drivingBehaviour != null && link_drivingBehaviour.eIsProxy()) {
			InternalEObject oldLink_drivingBehaviour = (InternalEObject)link_drivingBehaviour;
			link_drivingBehaviour = (Driving_Behaviour)eResolveProxy(oldLink_drivingBehaviour);
			if (link_drivingBehaviour != oldLink_drivingBehaviour) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LINK_GOAL_DRIVING_BEHAVIOUR__LINK_DRIVING_BEHAVIOUR, oldLink_drivingBehaviour, link_drivingBehaviour));
			}
		}
		return link_drivingBehaviour;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Driving_Behaviour basicGetLink_drivingBehaviour() {
		return link_drivingBehaviour;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLink_drivingBehaviour(Driving_Behaviour newLink_drivingBehaviour) {
		Driving_Behaviour oldLink_drivingBehaviour = link_drivingBehaviour;
		link_drivingBehaviour = newLink_drivingBehaviour;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_GOAL_DRIVING_BEHAVIOUR__LINK_DRIVING_BEHAVIOUR, oldLink_drivingBehaviour, link_drivingBehaviour));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IntelligentMobilityPackage.LINK_GOAL_DRIVING_BEHAVIOUR__NAME_LINK_GOAL_DRIVING_BEHAVIOUR:
				return getName_link_goal_drivingBehaviour();
			case IntelligentMobilityPackage.LINK_GOAL_DRIVING_BEHAVIOUR__LINK_GOAL:
				if (resolve) return getLink_goal();
				return basicGetLink_goal();
			case IntelligentMobilityPackage.LINK_GOAL_DRIVING_BEHAVIOUR__LINK_DRIVING_BEHAVIOUR:
				if (resolve) return getLink_drivingBehaviour();
				return basicGetLink_drivingBehaviour();
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
			case IntelligentMobilityPackage.LINK_GOAL_DRIVING_BEHAVIOUR__NAME_LINK_GOAL_DRIVING_BEHAVIOUR:
				setName_link_goal_drivingBehaviour((String)newValue);
				return;
			case IntelligentMobilityPackage.LINK_GOAL_DRIVING_BEHAVIOUR__LINK_GOAL:
				setLink_goal((Goal)newValue);
				return;
			case IntelligentMobilityPackage.LINK_GOAL_DRIVING_BEHAVIOUR__LINK_DRIVING_BEHAVIOUR:
				setLink_drivingBehaviour((Driving_Behaviour)newValue);
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
			case IntelligentMobilityPackage.LINK_GOAL_DRIVING_BEHAVIOUR__NAME_LINK_GOAL_DRIVING_BEHAVIOUR:
				setName_link_goal_drivingBehaviour(NAME_LINK_GOAL_DRIVING_BEHAVIOUR_EDEFAULT);
				return;
			case IntelligentMobilityPackage.LINK_GOAL_DRIVING_BEHAVIOUR__LINK_GOAL:
				setLink_goal((Goal)null);
				return;
			case IntelligentMobilityPackage.LINK_GOAL_DRIVING_BEHAVIOUR__LINK_DRIVING_BEHAVIOUR:
				setLink_drivingBehaviour((Driving_Behaviour)null);
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
			case IntelligentMobilityPackage.LINK_GOAL_DRIVING_BEHAVIOUR__NAME_LINK_GOAL_DRIVING_BEHAVIOUR:
				return NAME_LINK_GOAL_DRIVING_BEHAVIOUR_EDEFAULT == null ? name_link_goal_drivingBehaviour != null : !NAME_LINK_GOAL_DRIVING_BEHAVIOUR_EDEFAULT.equals(name_link_goal_drivingBehaviour);
			case IntelligentMobilityPackage.LINK_GOAL_DRIVING_BEHAVIOUR__LINK_GOAL:
				return link_goal != null;
			case IntelligentMobilityPackage.LINK_GOAL_DRIVING_BEHAVIOUR__LINK_DRIVING_BEHAVIOUR:
				return link_drivingBehaviour != null;
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
		result.append(" (name_link_goal_drivingBehaviour: ");
		result.append(name_link_goal_drivingBehaviour);
		result.append(')');
		return result.toString();
	}

} //Link_Goal_DrivingBehaviourImpl
