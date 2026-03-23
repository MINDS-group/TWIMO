/**
 */
package intelligentMobility;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Possible Vehicle</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.PossibleVehicle#getVehicleType <em>Vehicle Type</em>}</li>
 *   <li>{@link intelligentMobility.PossibleVehicle#getAmountPercentage <em>Amount Percentage</em>}</li>
 *   <li>{@link intelligentMobility.PossibleVehicle#getSimulationOrderIndex <em>Simulation Order Index</em>}</li>
 * </ul>
 *
 * @see intelligentMobility.IntelligentMobilityPackage#getPossibleVehicle()
 * @model
 * @generated
 */
public interface PossibleVehicle extends EObject {
	/**
	 * Returns the value of the '<em><b>Vehicle Type</b></em>' attribute.
	 * The literals are from the enumeration {@link intelligentMobility.CarType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vehicle Type</em>' attribute.
	 * @see intelligentMobility.CarType
	 * @see #setVehicleType(CarType)
	 * @see intelligentMobility.IntelligentMobilityPackage#getPossibleVehicle_VehicleType()
	 * @model
	 * @generated
	 */
	CarType getVehicleType();

	/**
	 * Sets the value of the '{@link intelligentMobility.PossibleVehicle#getVehicleType <em>Vehicle Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Vehicle Type</em>' attribute.
	 * @see intelligentMobility.CarType
	 * @see #getVehicleType()
	 * @generated
	 */
	void setVehicleType(CarType value);

	/**
	 * Returns the value of the '<em><b>Amount Percentage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Amount Percentage</em>' attribute.
	 * @see #setAmountPercentage(int)
	 * @see intelligentMobility.IntelligentMobilityPackage#getPossibleVehicle_AmountPercentage()
	 * @model
	 * @generated
	 */
	int getAmountPercentage();

	/**
	 * Sets the value of the '{@link intelligentMobility.PossibleVehicle#getAmountPercentage <em>Amount Percentage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Amount Percentage</em>' attribute.
	 * @see #getAmountPercentage()
	 * @generated
	 */
	void setAmountPercentage(int value);

	/**
	 * Returns the value of the '<em><b>Simulation Order Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Simulation Order Index</em>' attribute.
	 * @see #setSimulationOrderIndex(int)
	 * @see intelligentMobility.IntelligentMobilityPackage#getPossibleVehicle_SimulationOrderIndex()
	 * @model
	 * @generated
	 */
	int getSimulationOrderIndex();

	/**
	 * Sets the value of the '{@link intelligentMobility.PossibleVehicle#getSimulationOrderIndex <em>Simulation Order Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Simulation Order Index</em>' attribute.
	 * @see #getSimulationOrderIndex()
	 * @generated
	 */
	void setSimulationOrderIndex(int value);

} // PossibleVehicle
