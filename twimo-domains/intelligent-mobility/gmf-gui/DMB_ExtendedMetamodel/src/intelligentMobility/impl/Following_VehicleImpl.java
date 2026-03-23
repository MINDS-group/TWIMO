/**
 */
package intelligentMobility.impl;

import intelligentMobility.Following_Vehicle;
import intelligentMobility.IntelligentMobilityPackage;
import intelligentMobility.PlatoonMember;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Following Vehicle</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.impl.Following_VehicleImpl#getHeadwayMin <em>Headway Min</em>}</li>
 *   <li>{@link intelligentMobility.impl.Following_VehicleImpl#getHeadwayMax <em>Headway Max</em>}</li>
 *   <li>{@link intelligentMobility.impl.Following_VehicleImpl#getFrontvehicle <em>Frontvehicle</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Following_VehicleImpl extends PlatoonMemberImpl implements Following_Vehicle {
	/**
	 * The default value of the '{@link #getHeadwayMin() <em>Headway Min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeadwayMin()
	 * @generated
	 * @ordered
	 */
	protected static final double HEADWAY_MIN_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getHeadwayMin() <em>Headway Min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeadwayMin()
	 * @generated
	 * @ordered
	 */
	protected double headwayMin = HEADWAY_MIN_EDEFAULT;

	/**
	 * The default value of the '{@link #getHeadwayMax() <em>Headway Max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeadwayMax()
	 * @generated
	 * @ordered
	 */
	protected static final double HEADWAY_MAX_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getHeadwayMax() <em>Headway Max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeadwayMax()
	 * @generated
	 * @ordered
	 */
	protected double headwayMax = HEADWAY_MAX_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFrontvehicle() <em>Frontvehicle</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFrontvehicle()
	 * @generated
	 * @ordered
	 */
	protected PlatoonMember frontvehicle;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Following_VehicleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return IntelligentMobilityPackage.eINSTANCE.getFollowing_Vehicle();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getHeadwayMin() {
		return headwayMin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHeadwayMin(double newHeadwayMin) {
		double oldHeadwayMin = headwayMin;
		headwayMin = newHeadwayMin;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.FOLLOWING_VEHICLE__HEADWAY_MIN, oldHeadwayMin, headwayMin));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getHeadwayMax() {
		return headwayMax;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHeadwayMax(double newHeadwayMax) {
		double oldHeadwayMax = headwayMax;
		headwayMax = newHeadwayMax;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.FOLLOWING_VEHICLE__HEADWAY_MAX, oldHeadwayMax, headwayMax));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PlatoonMember getFrontvehicle() {
		if (frontvehicle != null && frontvehicle.eIsProxy()) {
			InternalEObject oldFrontvehicle = (InternalEObject)frontvehicle;
			frontvehicle = (PlatoonMember)eResolveProxy(oldFrontvehicle);
			if (frontvehicle != oldFrontvehicle) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.FOLLOWING_VEHICLE__FRONTVEHICLE, oldFrontvehicle, frontvehicle));
			}
		}
		return frontvehicle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PlatoonMember basicGetFrontvehicle() {
		return frontvehicle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFrontvehicle(PlatoonMember newFrontvehicle) {
		PlatoonMember oldFrontvehicle = frontvehicle;
		frontvehicle = newFrontvehicle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.FOLLOWING_VEHICLE__FRONTVEHICLE, oldFrontvehicle, frontvehicle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IntelligentMobilityPackage.FOLLOWING_VEHICLE__HEADWAY_MIN:
				return new Double(getHeadwayMin());
			case IntelligentMobilityPackage.FOLLOWING_VEHICLE__HEADWAY_MAX:
				return new Double(getHeadwayMax());
			case IntelligentMobilityPackage.FOLLOWING_VEHICLE__FRONTVEHICLE:
				if (resolve) return getFrontvehicle();
				return basicGetFrontvehicle();
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
			case IntelligentMobilityPackage.FOLLOWING_VEHICLE__HEADWAY_MIN:
				setHeadwayMin(((Double)newValue).doubleValue());
				return;
			case IntelligentMobilityPackage.FOLLOWING_VEHICLE__HEADWAY_MAX:
				setHeadwayMax(((Double)newValue).doubleValue());
				return;
			case IntelligentMobilityPackage.FOLLOWING_VEHICLE__FRONTVEHICLE:
				setFrontvehicle((PlatoonMember)newValue);
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
			case IntelligentMobilityPackage.FOLLOWING_VEHICLE__HEADWAY_MIN:
				setHeadwayMin(HEADWAY_MIN_EDEFAULT);
				return;
			case IntelligentMobilityPackage.FOLLOWING_VEHICLE__HEADWAY_MAX:
				setHeadwayMax(HEADWAY_MAX_EDEFAULT);
				return;
			case IntelligentMobilityPackage.FOLLOWING_VEHICLE__FRONTVEHICLE:
				setFrontvehicle((PlatoonMember)null);
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
			case IntelligentMobilityPackage.FOLLOWING_VEHICLE__HEADWAY_MIN:
				return headwayMin != HEADWAY_MIN_EDEFAULT;
			case IntelligentMobilityPackage.FOLLOWING_VEHICLE__HEADWAY_MAX:
				return headwayMax != HEADWAY_MAX_EDEFAULT;
			case IntelligentMobilityPackage.FOLLOWING_VEHICLE__FRONTVEHICLE:
				return frontvehicle != null;
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
		result.append(" (headwayMin: ");
		result.append(headwayMin);
		result.append(", headwayMax: ");
		result.append(headwayMax);
		result.append(')');
		return result.toString();
	}

} //Following_VehicleImpl
