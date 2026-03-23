/**
 */
package intelligentMobility.impl;

import intelligentMobility.Goal;
import intelligentMobility.IntelligentMobilityPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Goal</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.impl.GoalImpl#getGoalType <em>Goal Type</em>}</li>
 *   <li>{@link intelligentMobility.impl.GoalImpl#getPriority <em>Priority</em>}</li>
 *   <li>{@link intelligentMobility.impl.GoalImpl#isIsGoalDriven <em>Is Goal Driven</em>}</li>
 *   <li>{@link intelligentMobility.impl.GoalImpl#isIsStimulusDriven <em>Is Stimulus Driven</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GoalImpl extends MinimalEObjectImpl.Container implements Goal {
	/**
	 * The default value of the '{@link #getGoalType() <em>Goal Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGoalType()
	 * @generated
	 * @ordered
	 */
	protected static final String GOAL_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getGoalType() <em>Goal Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGoalType()
	 * @generated
	 * @ordered
	 */
	protected String goalType = GOAL_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getPriority() <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPriority()
	 * @generated
	 * @ordered
	 */
	protected static final int PRIORITY_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getPriority() <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPriority()
	 * @generated
	 * @ordered
	 */
	protected int priority = PRIORITY_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsGoalDriven() <em>Is Goal Driven</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsGoalDriven()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_GOAL_DRIVEN_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsGoalDriven() <em>Is Goal Driven</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsGoalDriven()
	 * @generated
	 * @ordered
	 */
	protected boolean isGoalDriven = IS_GOAL_DRIVEN_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsStimulusDriven() <em>Is Stimulus Driven</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsStimulusDriven()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_STIMULUS_DRIVEN_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsStimulusDriven() <em>Is Stimulus Driven</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsStimulusDriven()
	 * @generated
	 * @ordered
	 */
	protected boolean isStimulusDriven = IS_STIMULUS_DRIVEN_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GoalImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return IntelligentMobilityPackage.eINSTANCE.getGoal();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getGoalType() {
		return goalType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGoalType(String newGoalType) {
		String oldGoalType = goalType;
		goalType = newGoalType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.GOAL__GOAL_TYPE, oldGoalType, goalType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getPriority() {
		return priority;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPriority(int newPriority) {
		int oldPriority = priority;
		priority = newPriority;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.GOAL__PRIORITY, oldPriority, priority));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsGoalDriven() {
		return isGoalDriven;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsGoalDriven(boolean newIsGoalDriven) {
		boolean oldIsGoalDriven = isGoalDriven;
		isGoalDriven = newIsGoalDriven;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.GOAL__IS_GOAL_DRIVEN, oldIsGoalDriven, isGoalDriven));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsStimulusDriven() {
		return isStimulusDriven;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsStimulusDriven(boolean newIsStimulusDriven) {
		boolean oldIsStimulusDriven = isStimulusDriven;
		isStimulusDriven = newIsStimulusDriven;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.GOAL__IS_STIMULUS_DRIVEN, oldIsStimulusDriven, isStimulusDriven));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IntelligentMobilityPackage.GOAL__GOAL_TYPE:
				return getGoalType();
			case IntelligentMobilityPackage.GOAL__PRIORITY:
				return new Integer(getPriority());
			case IntelligentMobilityPackage.GOAL__IS_GOAL_DRIVEN:
				return isIsGoalDriven() ? Boolean.TRUE : Boolean.FALSE;
			case IntelligentMobilityPackage.GOAL__IS_STIMULUS_DRIVEN:
				return isIsStimulusDriven() ? Boolean.TRUE : Boolean.FALSE;
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
			case IntelligentMobilityPackage.GOAL__GOAL_TYPE:
				setGoalType((String)newValue);
				return;
			case IntelligentMobilityPackage.GOAL__PRIORITY:
				setPriority(((Integer)newValue).intValue());
				return;
			case IntelligentMobilityPackage.GOAL__IS_GOAL_DRIVEN:
				setIsGoalDriven(((Boolean)newValue).booleanValue());
				return;
			case IntelligentMobilityPackage.GOAL__IS_STIMULUS_DRIVEN:
				setIsStimulusDriven(((Boolean)newValue).booleanValue());
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
			case IntelligentMobilityPackage.GOAL__GOAL_TYPE:
				setGoalType(GOAL_TYPE_EDEFAULT);
				return;
			case IntelligentMobilityPackage.GOAL__PRIORITY:
				setPriority(PRIORITY_EDEFAULT);
				return;
			case IntelligentMobilityPackage.GOAL__IS_GOAL_DRIVEN:
				setIsGoalDriven(IS_GOAL_DRIVEN_EDEFAULT);
				return;
			case IntelligentMobilityPackage.GOAL__IS_STIMULUS_DRIVEN:
				setIsStimulusDriven(IS_STIMULUS_DRIVEN_EDEFAULT);
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
			case IntelligentMobilityPackage.GOAL__GOAL_TYPE:
				return GOAL_TYPE_EDEFAULT == null ? goalType != null : !GOAL_TYPE_EDEFAULT.equals(goalType);
			case IntelligentMobilityPackage.GOAL__PRIORITY:
				return priority != PRIORITY_EDEFAULT;
			case IntelligentMobilityPackage.GOAL__IS_GOAL_DRIVEN:
				return isGoalDriven != IS_GOAL_DRIVEN_EDEFAULT;
			case IntelligentMobilityPackage.GOAL__IS_STIMULUS_DRIVEN:
				return isStimulusDriven != IS_STIMULUS_DRIVEN_EDEFAULT;
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
		result.append(" (goalType: ");
		result.append(goalType);
		result.append(", priority: ");
		result.append(priority);
		result.append(", isGoalDriven: ");
		result.append(isGoalDriven);
		result.append(", isStimulusDriven: ");
		result.append(isStimulusDriven);
		result.append(')');
		return result.toString();
	}

} //GoalImpl
