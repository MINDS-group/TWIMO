/**
 */
package intelligentMobility.impl;

import intelligentMobility.CarType;
import intelligentMobility.IntelligentMobilityPackage;
import intelligentMobility.PossibleVehicle;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Possible Vehicle</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.impl.PossibleVehicleImpl#getVehicleType <em>Vehicle Type</em>}</li>
 *   <li>{@link intelligentMobility.impl.PossibleVehicleImpl#getAmountPercentage <em>Amount Percentage</em>}</li>
 *   <li>{@link intelligentMobility.impl.PossibleVehicleImpl#getSimulationOrderIndex <em>Simulation Order Index</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PossibleVehicleImpl extends MinimalEObjectImpl.Container implements PossibleVehicle {
	/**
	 * The default value of the '{@link #getVehicleType() <em>Vehicle Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVehicleType()
	 * @generated
	 * @ordered
	 */
	protected static final CarType VEHICLE_TYPE_EDEFAULT = CarType.NORMAL_CAR_LITERAL;

	/**
	 * The cached value of the '{@link #getVehicleType() <em>Vehicle Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVehicleType()
	 * @generated
	 * @ordered
	 */
	protected CarType vehicleType = VEHICLE_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getAmountPercentage() <em>Amount Percentage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAmountPercentage()
	 * @generated
	 * @ordered
	 */
	protected static final int AMOUNT_PERCENTAGE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getAmountPercentage() <em>Amount Percentage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAmountPercentage()
	 * @generated
	 * @ordered
	 */
	protected int amountPercentage = AMOUNT_PERCENTAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getSimulationOrderIndex() <em>Simulation Order Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSimulationOrderIndex()
	 * @generated
	 * @ordered
	 */
	protected static final int SIMULATION_ORDER_INDEX_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSimulationOrderIndex() <em>Simulation Order Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSimulationOrderIndex()
	 * @generated
	 * @ordered
	 */
	protected int simulationOrderIndex = SIMULATION_ORDER_INDEX_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PossibleVehicleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return IntelligentMobilityPackage.eINSTANCE.getPossibleVehicle();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CarType getVehicleType() {
		return vehicleType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVehicleType(CarType newVehicleType) {
		CarType oldVehicleType = vehicleType;
		vehicleType = newVehicleType == null ? VEHICLE_TYPE_EDEFAULT : newVehicleType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.POSSIBLE_VEHICLE__VEHICLE_TYPE, oldVehicleType, vehicleType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getAmountPercentage() {
		return amountPercentage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAmountPercentage(int newAmountPercentage) {
		int oldAmountPercentage = amountPercentage;
		amountPercentage = newAmountPercentage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.POSSIBLE_VEHICLE__AMOUNT_PERCENTAGE, oldAmountPercentage, amountPercentage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSimulationOrderIndex() {
		return simulationOrderIndex;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSimulationOrderIndex(int newSimulationOrderIndex) {
		int oldSimulationOrderIndex = simulationOrderIndex;
		simulationOrderIndex = newSimulationOrderIndex;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.POSSIBLE_VEHICLE__SIMULATION_ORDER_INDEX, oldSimulationOrderIndex, simulationOrderIndex));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IntelligentMobilityPackage.POSSIBLE_VEHICLE__VEHICLE_TYPE:
				return getVehicleType();
			case IntelligentMobilityPackage.POSSIBLE_VEHICLE__AMOUNT_PERCENTAGE:
				return new Integer(getAmountPercentage());
			case IntelligentMobilityPackage.POSSIBLE_VEHICLE__SIMULATION_ORDER_INDEX:
				return new Integer(getSimulationOrderIndex());
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
			case IntelligentMobilityPackage.POSSIBLE_VEHICLE__VEHICLE_TYPE:
				setVehicleType((CarType)newValue);
				return;
			case IntelligentMobilityPackage.POSSIBLE_VEHICLE__AMOUNT_PERCENTAGE:
				setAmountPercentage(((Integer)newValue).intValue());
				return;
			case IntelligentMobilityPackage.POSSIBLE_VEHICLE__SIMULATION_ORDER_INDEX:
				setSimulationOrderIndex(((Integer)newValue).intValue());
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
			case IntelligentMobilityPackage.POSSIBLE_VEHICLE__VEHICLE_TYPE:
				setVehicleType(VEHICLE_TYPE_EDEFAULT);
				return;
			case IntelligentMobilityPackage.POSSIBLE_VEHICLE__AMOUNT_PERCENTAGE:
				setAmountPercentage(AMOUNT_PERCENTAGE_EDEFAULT);
				return;
			case IntelligentMobilityPackage.POSSIBLE_VEHICLE__SIMULATION_ORDER_INDEX:
				setSimulationOrderIndex(SIMULATION_ORDER_INDEX_EDEFAULT);
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
			case IntelligentMobilityPackage.POSSIBLE_VEHICLE__VEHICLE_TYPE:
				return vehicleType != VEHICLE_TYPE_EDEFAULT;
			case IntelligentMobilityPackage.POSSIBLE_VEHICLE__AMOUNT_PERCENTAGE:
				return amountPercentage != AMOUNT_PERCENTAGE_EDEFAULT;
			case IntelligentMobilityPackage.POSSIBLE_VEHICLE__SIMULATION_ORDER_INDEX:
				return simulationOrderIndex != SIMULATION_ORDER_INDEX_EDEFAULT;
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
		result.append(" (vehicleType: ");
		result.append(vehicleType);
		result.append(", amountPercentage: ");
		result.append(amountPercentage);
		result.append(", simulationOrderIndex: ");
		result.append(simulationOrderIndex);
		result.append(')');
		return result.toString();
	}

} //PossibleVehicleImpl
