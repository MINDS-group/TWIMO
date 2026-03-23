/**
 */
package intelligentMobility.impl;

import intelligentMobility.Action;
import intelligentMobility.Environment_Condition;
import intelligentMobility.GapAcceptance;
import intelligentMobility.IntelligentMobilityPackage;
import intelligentMobility.LaneChanging;
import intelligentMobility.Turn;

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
 * An implementation of the model object '<em><b>Lane Changing</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.impl.LaneChangingImpl#getLaneSwitchSpeed <em>Lane Switch Speed</em>}</li>
 *   <li>{@link intelligentMobility.impl.LaneChangingImpl#getName <em>Name</em>}</li>
 *   <li>{@link intelligentMobility.impl.LaneChangingImpl#getTurn <em>Turn</em>}</li>
 *   <li>{@link intelligentMobility.impl.LaneChangingImpl#getGapacceptance <em>Gapacceptance</em>}</li>
 *   <li>{@link intelligentMobility.impl.LaneChangingImpl#getEnvironment_condition <em>Environment condition</em>}</li>
 *   <li>{@link intelligentMobility.impl.LaneChangingImpl#getLeftLaneChange <em>Left Lane Change</em>}</li>
 *   <li>{@link intelligentMobility.impl.LaneChangingImpl#getRightLaneChange <em>Right Lane Change</em>}</li>
 *   <li>{@link intelligentMobility.impl.LaneChangingImpl#getLeftLaneBranch <em>Left Lane Branch</em>}</li>
 *   <li>{@link intelligentMobility.impl.LaneChangingImpl#getRightLaneBranch <em>Right Lane Branch</em>}</li>
 *   <li>{@link intelligentMobility.impl.LaneChangingImpl#getAction <em>Action</em>}</li>
 *   <li>{@link intelligentMobility.impl.LaneChangingImpl#getManeuverType <em>Maneuver Type</em>}</li>
 *   <li>{@link intelligentMobility.impl.LaneChangingImpl#getDuration <em>Duration</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LaneChangingImpl extends MinimalEObjectImpl.Container implements LaneChanging {
	/**
	 * The default value of the '{@link #getLaneSwitchSpeed() <em>Lane Switch Speed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLaneSwitchSpeed()
	 * @generated
	 * @ordered
	 */
	protected static final double LANE_SWITCH_SPEED_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getLaneSwitchSpeed() <em>Lane Switch Speed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLaneSwitchSpeed()
	 * @generated
	 * @ordered
	 */
	protected double laneSwitchSpeed = LANE_SWITCH_SPEED_EDEFAULT;

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
	 * The cached value of the '{@link #getTurn() <em>Turn</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTurn()
	 * @generated
	 * @ordered
	 */
	protected EList turn;

	/**
	 * The cached value of the '{@link #getGapacceptance() <em>Gapacceptance</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGapacceptance()
	 * @generated
	 * @ordered
	 */
	protected GapAcceptance gapacceptance;

	/**
	 * The cached value of the '{@link #getEnvironment_condition() <em>Environment condition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnvironment_condition()
	 * @generated
	 * @ordered
	 */
	protected Environment_Condition environment_condition;

	/**
	 * The default value of the '{@link #getLeftLaneChange() <em>Left Lane Change</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLeftLaneChange()
	 * @generated
	 * @ordered
	 */
	protected static final int LEFT_LANE_CHANGE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getLeftLaneChange() <em>Left Lane Change</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLeftLaneChange()
	 * @generated
	 * @ordered
	 */
	protected int leftLaneChange = LEFT_LANE_CHANGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getRightLaneChange() <em>Right Lane Change</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRightLaneChange()
	 * @generated
	 * @ordered
	 */
	protected static final int RIGHT_LANE_CHANGE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getRightLaneChange() <em>Right Lane Change</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRightLaneChange()
	 * @generated
	 * @ordered
	 */
	protected int rightLaneChange = RIGHT_LANE_CHANGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getLeftLaneBranch() <em>Left Lane Branch</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLeftLaneBranch()
	 * @generated
	 * @ordered
	 */
	protected static final int LEFT_LANE_BRANCH_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getLeftLaneBranch() <em>Left Lane Branch</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLeftLaneBranch()
	 * @generated
	 * @ordered
	 */
	protected int leftLaneBranch = LEFT_LANE_BRANCH_EDEFAULT;

	/**
	 * The default value of the '{@link #getRightLaneBranch() <em>Right Lane Branch</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRightLaneBranch()
	 * @generated
	 * @ordered
	 */
	protected static final int RIGHT_LANE_BRANCH_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getRightLaneBranch() <em>Right Lane Branch</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRightLaneBranch()
	 * @generated
	 * @ordered
	 */
	protected int rightLaneBranch = RIGHT_LANE_BRANCH_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAction() <em>Action</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAction()
	 * @generated
	 * @ordered
	 */
	protected Action action;

	/**
	 * The default value of the '{@link #getManeuverType() <em>Maneuver Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getManeuverType()
	 * @generated
	 * @ordered
	 */
	protected static final String MANEUVER_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getManeuverType() <em>Maneuver Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getManeuverType()
	 * @generated
	 * @ordered
	 */
	protected String maneuverType = MANEUVER_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDuration() <em>Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDuration()
	 * @generated
	 * @ordered
	 */
	protected static final float DURATION_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getDuration() <em>Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDuration()
	 * @generated
	 * @ordered
	 */
	protected float duration = DURATION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LaneChangingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return IntelligentMobilityPackage.eINSTANCE.getLaneChanging();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getLaneSwitchSpeed() {
		return laneSwitchSpeed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLaneSwitchSpeed(double newLaneSwitchSpeed) {
		double oldLaneSwitchSpeed = laneSwitchSpeed;
		laneSwitchSpeed = newLaneSwitchSpeed;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LANE_CHANGING__LANE_SWITCH_SPEED, oldLaneSwitchSpeed, laneSwitchSpeed));
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
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LANE_CHANGING__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getTurn() {
		if (turn == null) {
			turn = new EObjectContainmentEList(Turn.class, this, IntelligentMobilityPackage.LANE_CHANGING__TURN);
		}
		return turn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GapAcceptance getGapacceptance() {
		return gapacceptance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGapacceptance(GapAcceptance newGapacceptance, NotificationChain msgs) {
		GapAcceptance oldGapacceptance = gapacceptance;
		gapacceptance = newGapacceptance;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LANE_CHANGING__GAPACCEPTANCE, oldGapacceptance, newGapacceptance);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGapacceptance(GapAcceptance newGapacceptance) {
		if (newGapacceptance != gapacceptance) {
			NotificationChain msgs = null;
			if (gapacceptance != null)
				msgs = ((InternalEObject)gapacceptance).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IntelligentMobilityPackage.LANE_CHANGING__GAPACCEPTANCE, null, msgs);
			if (newGapacceptance != null)
				msgs = ((InternalEObject)newGapacceptance).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IntelligentMobilityPackage.LANE_CHANGING__GAPACCEPTANCE, null, msgs);
			msgs = basicSetGapacceptance(newGapacceptance, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LANE_CHANGING__GAPACCEPTANCE, newGapacceptance, newGapacceptance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Environment_Condition getEnvironment_condition() {
		if (environment_condition != null && environment_condition.eIsProxy()) {
			InternalEObject oldEnvironment_condition = (InternalEObject)environment_condition;
			environment_condition = (Environment_Condition)eResolveProxy(oldEnvironment_condition);
			if (environment_condition != oldEnvironment_condition) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LANE_CHANGING__ENVIRONMENT_CONDITION, oldEnvironment_condition, environment_condition));
			}
		}
		return environment_condition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Environment_Condition basicGetEnvironment_condition() {
		return environment_condition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnvironment_condition(Environment_Condition newEnvironment_condition) {
		Environment_Condition oldEnvironment_condition = environment_condition;
		environment_condition = newEnvironment_condition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LANE_CHANGING__ENVIRONMENT_CONDITION, oldEnvironment_condition, environment_condition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getLeftLaneChange() {
		return leftLaneChange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLeftLaneChange(int newLeftLaneChange) {
		int oldLeftLaneChange = leftLaneChange;
		leftLaneChange = newLeftLaneChange;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LANE_CHANGING__LEFT_LANE_CHANGE, oldLeftLaneChange, leftLaneChange));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getRightLaneChange() {
		return rightLaneChange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRightLaneChange(int newRightLaneChange) {
		int oldRightLaneChange = rightLaneChange;
		rightLaneChange = newRightLaneChange;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LANE_CHANGING__RIGHT_LANE_CHANGE, oldRightLaneChange, rightLaneChange));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getLeftLaneBranch() {
		return leftLaneBranch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLeftLaneBranch(int newLeftLaneBranch) {
		int oldLeftLaneBranch = leftLaneBranch;
		leftLaneBranch = newLeftLaneBranch;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LANE_CHANGING__LEFT_LANE_BRANCH, oldLeftLaneBranch, leftLaneBranch));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getRightLaneBranch() {
		return rightLaneBranch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRightLaneBranch(int newRightLaneBranch) {
		int oldRightLaneBranch = rightLaneBranch;
		rightLaneBranch = newRightLaneBranch;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LANE_CHANGING__RIGHT_LANE_BRANCH, oldRightLaneBranch, rightLaneBranch));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Action getAction() {
		if (action != null && action.eIsProxy()) {
			InternalEObject oldAction = (InternalEObject)action;
			action = (Action)eResolveProxy(oldAction);
			if (action != oldAction) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LANE_CHANGING__ACTION, oldAction, action));
			}
		}
		return action;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Action basicGetAction() {
		return action;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAction(Action newAction) {
		Action oldAction = action;
		action = newAction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LANE_CHANGING__ACTION, oldAction, action));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getManeuverType() {
		return maneuverType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setManeuverType(String newManeuverType) {
		String oldManeuverType = maneuverType;
		maneuverType = newManeuverType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LANE_CHANGING__MANEUVER_TYPE, oldManeuverType, maneuverType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getDuration() {
		return duration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDuration(float newDuration) {
		float oldDuration = duration;
		duration = newDuration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LANE_CHANGING__DURATION, oldDuration, duration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case IntelligentMobilityPackage.LANE_CHANGING__TURN:
				return ((InternalEList)getTurn()).basicRemove(otherEnd, msgs);
			case IntelligentMobilityPackage.LANE_CHANGING__GAPACCEPTANCE:
				return basicSetGapacceptance(null, msgs);
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
			case IntelligentMobilityPackage.LANE_CHANGING__LANE_SWITCH_SPEED:
				return new Double(getLaneSwitchSpeed());
			case IntelligentMobilityPackage.LANE_CHANGING__NAME:
				return getName();
			case IntelligentMobilityPackage.LANE_CHANGING__TURN:
				return getTurn();
			case IntelligentMobilityPackage.LANE_CHANGING__GAPACCEPTANCE:
				return getGapacceptance();
			case IntelligentMobilityPackage.LANE_CHANGING__ENVIRONMENT_CONDITION:
				if (resolve) return getEnvironment_condition();
				return basicGetEnvironment_condition();
			case IntelligentMobilityPackage.LANE_CHANGING__LEFT_LANE_CHANGE:
				return new Integer(getLeftLaneChange());
			case IntelligentMobilityPackage.LANE_CHANGING__RIGHT_LANE_CHANGE:
				return new Integer(getRightLaneChange());
			case IntelligentMobilityPackage.LANE_CHANGING__LEFT_LANE_BRANCH:
				return new Integer(getLeftLaneBranch());
			case IntelligentMobilityPackage.LANE_CHANGING__RIGHT_LANE_BRANCH:
				return new Integer(getRightLaneBranch());
			case IntelligentMobilityPackage.LANE_CHANGING__ACTION:
				if (resolve) return getAction();
				return basicGetAction();
			case IntelligentMobilityPackage.LANE_CHANGING__MANEUVER_TYPE:
				return getManeuverType();
			case IntelligentMobilityPackage.LANE_CHANGING__DURATION:
				return new Float(getDuration());
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
			case IntelligentMobilityPackage.LANE_CHANGING__LANE_SWITCH_SPEED:
				setLaneSwitchSpeed(((Double)newValue).doubleValue());
				return;
			case IntelligentMobilityPackage.LANE_CHANGING__NAME:
				setName((String)newValue);
				return;
			case IntelligentMobilityPackage.LANE_CHANGING__TURN:
				getTurn().clear();
				getTurn().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.LANE_CHANGING__GAPACCEPTANCE:
				setGapacceptance((GapAcceptance)newValue);
				return;
			case IntelligentMobilityPackage.LANE_CHANGING__ENVIRONMENT_CONDITION:
				setEnvironment_condition((Environment_Condition)newValue);
				return;
			case IntelligentMobilityPackage.LANE_CHANGING__LEFT_LANE_CHANGE:
				setLeftLaneChange(((Integer)newValue).intValue());
				return;
			case IntelligentMobilityPackage.LANE_CHANGING__RIGHT_LANE_CHANGE:
				setRightLaneChange(((Integer)newValue).intValue());
				return;
			case IntelligentMobilityPackage.LANE_CHANGING__LEFT_LANE_BRANCH:
				setLeftLaneBranch(((Integer)newValue).intValue());
				return;
			case IntelligentMobilityPackage.LANE_CHANGING__RIGHT_LANE_BRANCH:
				setRightLaneBranch(((Integer)newValue).intValue());
				return;
			case IntelligentMobilityPackage.LANE_CHANGING__ACTION:
				setAction((Action)newValue);
				return;
			case IntelligentMobilityPackage.LANE_CHANGING__MANEUVER_TYPE:
				setManeuverType((String)newValue);
				return;
			case IntelligentMobilityPackage.LANE_CHANGING__DURATION:
				setDuration(((Float)newValue).floatValue());
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
			case IntelligentMobilityPackage.LANE_CHANGING__LANE_SWITCH_SPEED:
				setLaneSwitchSpeed(LANE_SWITCH_SPEED_EDEFAULT);
				return;
			case IntelligentMobilityPackage.LANE_CHANGING__NAME:
				setName(NAME_EDEFAULT);
				return;
			case IntelligentMobilityPackage.LANE_CHANGING__TURN:
				getTurn().clear();
				return;
			case IntelligentMobilityPackage.LANE_CHANGING__GAPACCEPTANCE:
				setGapacceptance((GapAcceptance)null);
				return;
			case IntelligentMobilityPackage.LANE_CHANGING__ENVIRONMENT_CONDITION:
				setEnvironment_condition((Environment_Condition)null);
				return;
			case IntelligentMobilityPackage.LANE_CHANGING__LEFT_LANE_CHANGE:
				setLeftLaneChange(LEFT_LANE_CHANGE_EDEFAULT);
				return;
			case IntelligentMobilityPackage.LANE_CHANGING__RIGHT_LANE_CHANGE:
				setRightLaneChange(RIGHT_LANE_CHANGE_EDEFAULT);
				return;
			case IntelligentMobilityPackage.LANE_CHANGING__LEFT_LANE_BRANCH:
				setLeftLaneBranch(LEFT_LANE_BRANCH_EDEFAULT);
				return;
			case IntelligentMobilityPackage.LANE_CHANGING__RIGHT_LANE_BRANCH:
				setRightLaneBranch(RIGHT_LANE_BRANCH_EDEFAULT);
				return;
			case IntelligentMobilityPackage.LANE_CHANGING__ACTION:
				setAction((Action)null);
				return;
			case IntelligentMobilityPackage.LANE_CHANGING__MANEUVER_TYPE:
				setManeuverType(MANEUVER_TYPE_EDEFAULT);
				return;
			case IntelligentMobilityPackage.LANE_CHANGING__DURATION:
				setDuration(DURATION_EDEFAULT);
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
			case IntelligentMobilityPackage.LANE_CHANGING__LANE_SWITCH_SPEED:
				return laneSwitchSpeed != LANE_SWITCH_SPEED_EDEFAULT;
			case IntelligentMobilityPackage.LANE_CHANGING__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case IntelligentMobilityPackage.LANE_CHANGING__TURN:
				return turn != null && !turn.isEmpty();
			case IntelligentMobilityPackage.LANE_CHANGING__GAPACCEPTANCE:
				return gapacceptance != null;
			case IntelligentMobilityPackage.LANE_CHANGING__ENVIRONMENT_CONDITION:
				return environment_condition != null;
			case IntelligentMobilityPackage.LANE_CHANGING__LEFT_LANE_CHANGE:
				return leftLaneChange != LEFT_LANE_CHANGE_EDEFAULT;
			case IntelligentMobilityPackage.LANE_CHANGING__RIGHT_LANE_CHANGE:
				return rightLaneChange != RIGHT_LANE_CHANGE_EDEFAULT;
			case IntelligentMobilityPackage.LANE_CHANGING__LEFT_LANE_BRANCH:
				return leftLaneBranch != LEFT_LANE_BRANCH_EDEFAULT;
			case IntelligentMobilityPackage.LANE_CHANGING__RIGHT_LANE_BRANCH:
				return rightLaneBranch != RIGHT_LANE_BRANCH_EDEFAULT;
			case IntelligentMobilityPackage.LANE_CHANGING__ACTION:
				return action != null;
			case IntelligentMobilityPackage.LANE_CHANGING__MANEUVER_TYPE:
				return MANEUVER_TYPE_EDEFAULT == null ? maneuverType != null : !MANEUVER_TYPE_EDEFAULT.equals(maneuverType);
			case IntelligentMobilityPackage.LANE_CHANGING__DURATION:
				return duration != DURATION_EDEFAULT;
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
		result.append(" (laneSwitchSpeed: ");
		result.append(laneSwitchSpeed);
		result.append(", name: ");
		result.append(name);
		result.append(", leftLaneChange: ");
		result.append(leftLaneChange);
		result.append(", rightLaneChange: ");
		result.append(rightLaneChange);
		result.append(", leftLaneBranch: ");
		result.append(leftLaneBranch);
		result.append(", rightLaneBranch: ");
		result.append(rightLaneBranch);
		result.append(", maneuverType: ");
		result.append(maneuverType);
		result.append(", duration: ");
		result.append(duration);
		result.append(')');
		return result.toString();
	}

} //LaneChangingImpl
