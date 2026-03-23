/**
 */
package intelligentMobility.impl;

import intelligentMobility.IntelligentMobilityPackage;
import intelligentMobility.Lane_Type;
import intelligentMobility.Lanes;
import intelligentMobility.Regulation;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Lane Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.impl.Lane_TypeImpl#getLaneType <em>Lane Type</em>}</li>
 *   <li>{@link intelligentMobility.impl.Lane_TypeImpl#getLaneCount <em>Lane Count</em>}</li>
 *   <li>{@link intelligentMobility.impl.Lane_TypeImpl#getLaneWidth <em>Lane Width</em>}</li>
 *   <li>{@link intelligentMobility.impl.Lane_TypeImpl#getLaneLength <em>Lane Length</em>}</li>
 *   <li>{@link intelligentMobility.impl.Lane_TypeImpl#getMaxSpeedLimitation <em>Max Speed Limitation</em>}</li>
 *   <li>{@link intelligentMobility.impl.Lane_TypeImpl#getName <em>Name</em>}</li>
 *   <li>{@link intelligentMobility.impl.Lane_TypeImpl#getRegulations <em>Regulations</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Lane_TypeImpl extends MinimalEObjectImpl.Container implements Lane_Type {
	/**
	 * The default value of the '{@link #getLaneType() <em>Lane Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLaneType()
	 * @generated
	 * @ordered
	 */
	protected static final Lanes LANE_TYPE_EDEFAULT = Lanes.NORMAL_LANE_LITERAL;

	/**
	 * The cached value of the '{@link #getLaneType() <em>Lane Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLaneType()
	 * @generated
	 * @ordered
	 */
	protected Lanes laneType = LANE_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getLaneCount() <em>Lane Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLaneCount()
	 * @generated
	 * @ordered
	 */
	protected static final int LANE_COUNT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getLaneCount() <em>Lane Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLaneCount()
	 * @generated
	 * @ordered
	 */
	protected int laneCount = LANE_COUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #getLaneWidth() <em>Lane Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLaneWidth()
	 * @generated
	 * @ordered
	 */
	protected static final double LANE_WIDTH_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getLaneWidth() <em>Lane Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLaneWidth()
	 * @generated
	 * @ordered
	 */
	protected double laneWidth = LANE_WIDTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getLaneLength() <em>Lane Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLaneLength()
	 * @generated
	 * @ordered
	 */
	protected static final double LANE_LENGTH_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getLaneLength() <em>Lane Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLaneLength()
	 * @generated
	 * @ordered
	 */
	protected double laneLength = LANE_LENGTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxSpeedLimitation() <em>Max Speed Limitation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxSpeedLimitation()
	 * @generated
	 * @ordered
	 */
	protected static final int MAX_SPEED_LIMITATION_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMaxSpeedLimitation() <em>Max Speed Limitation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxSpeedLimitation()
	 * @generated
	 * @ordered
	 */
	protected int maxSpeedLimitation = MAX_SPEED_LIMITATION_EDEFAULT;

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
	 * The cached value of the '{@link #getRegulations() <em>Regulations</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRegulations()
	 * @generated
	 * @ordered
	 */
	protected Regulation regulations;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Lane_TypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return IntelligentMobilityPackage.eINSTANCE.getLane_Type();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Lanes getLaneType() {
		return laneType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLaneType(Lanes newLaneType) {
		Lanes oldLaneType = laneType;
		laneType = newLaneType == null ? LANE_TYPE_EDEFAULT : newLaneType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LANE_TYPE__LANE_TYPE, oldLaneType, laneType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getLaneCount() {
		return laneCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLaneCount(int newLaneCount) {
		int oldLaneCount = laneCount;
		laneCount = newLaneCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LANE_TYPE__LANE_COUNT, oldLaneCount, laneCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getLaneWidth() {
		return laneWidth;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLaneWidth(double newLaneWidth) {
		double oldLaneWidth = laneWidth;
		laneWidth = newLaneWidth;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LANE_TYPE__LANE_WIDTH, oldLaneWidth, laneWidth));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getLaneLength() {
		return laneLength;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLaneLength(double newLaneLength) {
		double oldLaneLength = laneLength;
		laneLength = newLaneLength;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LANE_TYPE__LANE_LENGTH, oldLaneLength, laneLength));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMaxSpeedLimitation() {
		return maxSpeedLimitation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxSpeedLimitation(int newMaxSpeedLimitation) {
		int oldMaxSpeedLimitation = maxSpeedLimitation;
		maxSpeedLimitation = newMaxSpeedLimitation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LANE_TYPE__MAX_SPEED_LIMITATION, oldMaxSpeedLimitation, maxSpeedLimitation));
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
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LANE_TYPE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Regulation getRegulations() {
		if (regulations != null && regulations.eIsProxy()) {
			InternalEObject oldRegulations = (InternalEObject)regulations;
			regulations = (Regulation)eResolveProxy(oldRegulations);
			if (regulations != oldRegulations) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LANE_TYPE__REGULATIONS, oldRegulations, regulations));
			}
		}
		return regulations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Regulation basicGetRegulations() {
		return regulations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRegulations(Regulation newRegulations) {
		Regulation oldRegulations = regulations;
		regulations = newRegulations;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LANE_TYPE__REGULATIONS, oldRegulations, regulations));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IntelligentMobilityPackage.LANE_TYPE__LANE_TYPE:
				return getLaneType();
			case IntelligentMobilityPackage.LANE_TYPE__LANE_COUNT:
				return new Integer(getLaneCount());
			case IntelligentMobilityPackage.LANE_TYPE__LANE_WIDTH:
				return new Double(getLaneWidth());
			case IntelligentMobilityPackage.LANE_TYPE__LANE_LENGTH:
				return new Double(getLaneLength());
			case IntelligentMobilityPackage.LANE_TYPE__MAX_SPEED_LIMITATION:
				return new Integer(getMaxSpeedLimitation());
			case IntelligentMobilityPackage.LANE_TYPE__NAME:
				return getName();
			case IntelligentMobilityPackage.LANE_TYPE__REGULATIONS:
				if (resolve) return getRegulations();
				return basicGetRegulations();
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
			case IntelligentMobilityPackage.LANE_TYPE__LANE_TYPE:
				setLaneType((Lanes)newValue);
				return;
			case IntelligentMobilityPackage.LANE_TYPE__LANE_COUNT:
				setLaneCount(((Integer)newValue).intValue());
				return;
			case IntelligentMobilityPackage.LANE_TYPE__LANE_WIDTH:
				setLaneWidth(((Double)newValue).doubleValue());
				return;
			case IntelligentMobilityPackage.LANE_TYPE__LANE_LENGTH:
				setLaneLength(((Double)newValue).doubleValue());
				return;
			case IntelligentMobilityPackage.LANE_TYPE__MAX_SPEED_LIMITATION:
				setMaxSpeedLimitation(((Integer)newValue).intValue());
				return;
			case IntelligentMobilityPackage.LANE_TYPE__NAME:
				setName((String)newValue);
				return;
			case IntelligentMobilityPackage.LANE_TYPE__REGULATIONS:
				setRegulations((Regulation)newValue);
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
			case IntelligentMobilityPackage.LANE_TYPE__LANE_TYPE:
				setLaneType(LANE_TYPE_EDEFAULT);
				return;
			case IntelligentMobilityPackage.LANE_TYPE__LANE_COUNT:
				setLaneCount(LANE_COUNT_EDEFAULT);
				return;
			case IntelligentMobilityPackage.LANE_TYPE__LANE_WIDTH:
				setLaneWidth(LANE_WIDTH_EDEFAULT);
				return;
			case IntelligentMobilityPackage.LANE_TYPE__LANE_LENGTH:
				setLaneLength(LANE_LENGTH_EDEFAULT);
				return;
			case IntelligentMobilityPackage.LANE_TYPE__MAX_SPEED_LIMITATION:
				setMaxSpeedLimitation(MAX_SPEED_LIMITATION_EDEFAULT);
				return;
			case IntelligentMobilityPackage.LANE_TYPE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case IntelligentMobilityPackage.LANE_TYPE__REGULATIONS:
				setRegulations((Regulation)null);
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
			case IntelligentMobilityPackage.LANE_TYPE__LANE_TYPE:
				return laneType != LANE_TYPE_EDEFAULT;
			case IntelligentMobilityPackage.LANE_TYPE__LANE_COUNT:
				return laneCount != LANE_COUNT_EDEFAULT;
			case IntelligentMobilityPackage.LANE_TYPE__LANE_WIDTH:
				return laneWidth != LANE_WIDTH_EDEFAULT;
			case IntelligentMobilityPackage.LANE_TYPE__LANE_LENGTH:
				return laneLength != LANE_LENGTH_EDEFAULT;
			case IntelligentMobilityPackage.LANE_TYPE__MAX_SPEED_LIMITATION:
				return maxSpeedLimitation != MAX_SPEED_LIMITATION_EDEFAULT;
			case IntelligentMobilityPackage.LANE_TYPE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case IntelligentMobilityPackage.LANE_TYPE__REGULATIONS:
				return regulations != null;
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
		result.append(" (laneType: ");
		result.append(laneType);
		result.append(", laneCount: ");
		result.append(laneCount);
		result.append(", laneWidth: ");
		result.append(laneWidth);
		result.append(", laneLength: ");
		result.append(laneLength);
		result.append(", maxSpeedLimitation: ");
		result.append(maxSpeedLimitation);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //Lane_TypeImpl
