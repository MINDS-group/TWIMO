/**
 */
package intelligentMobility;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Vehicle Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.Vehicle_Type#getType <em>Type</em>}</li>
 *   <li>{@link intelligentMobility.Vehicle_Type#getMaxSpeed <em>Max Speed</em>}</li>
 *   <li>{@link intelligentMobility.Vehicle_Type#getVehicleWidth_min <em>Vehicle Width min</em>}</li>
 *   <li>{@link intelligentMobility.Vehicle_Type#getVehicleWidth_max <em>Vehicle Width max</em>}</li>
 *   <li>{@link intelligentMobility.Vehicle_Type#getVehicleWidth_precision <em>Vehicle Width precision</em>}</li>
 *   <li>{@link intelligentMobility.Vehicle_Type#getVehicleLength_min <em>Vehicle Length min</em>}</li>
 *   <li>{@link intelligentMobility.Vehicle_Type#getVehicleLength_max <em>Vehicle Length max</em>}</li>
 *   <li>{@link intelligentMobility.Vehicle_Type#getVehicleLength_precision <em>Vehicle Length precision</em>}</li>
 *   <li>{@link intelligentMobility.Vehicle_Type#getVehicleHeight_min <em>Vehicle Height min</em>}</li>
 *   <li>{@link intelligentMobility.Vehicle_Type#getVehicleHeight_max <em>Vehicle Height max</em>}</li>
 *   <li>{@link intelligentMobility.Vehicle_Type#getVehicleHeight_precision <em>Vehicle Height precision</em>}</li>
 *   <li>{@link intelligentMobility.Vehicle_Type#getSpeed <em>Speed</em>}</li>
 *   <li>{@link intelligentMobility.Vehicle_Type#getStop <em>Stop</em>}</li>
 * </ul>
 *
 * @see intelligentMobility.IntelligentMobilityPackage#getVehicle_Type()
 * @model abstract="true"
 * @generated
 */
public interface Vehicle_Type extends EObject {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link intelligentMobility.CarType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see intelligentMobility.CarType
	 * @see #setType(CarType)
	 * @see intelligentMobility.IntelligentMobilityPackage#getVehicle_Type_Type()
	 * @model
	 * @generated
	 */
	CarType getType();

	/**
	 * Sets the value of the '{@link intelligentMobility.Vehicle_Type#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see intelligentMobility.CarType
	 * @see #getType()
	 * @generated
	 */
	void setType(CarType value);

	/**
	 * Returns the value of the '<em><b>Max Speed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Speed</em>' attribute.
	 * @see #setMaxSpeed(double)
	 * @see intelligentMobility.IntelligentMobilityPackage#getVehicle_Type_MaxSpeed()
	 * @model
	 * @generated
	 */
	double getMaxSpeed();

	/**
	 * Sets the value of the '{@link intelligentMobility.Vehicle_Type#getMaxSpeed <em>Max Speed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Speed</em>' attribute.
	 * @see #getMaxSpeed()
	 * @generated
	 */
	void setMaxSpeed(double value);

	/**
	 * Returns the value of the '<em><b>Vehicle Width min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vehicle Width min</em>' attribute.
	 * @see #setVehicleWidth_min(double)
	 * @see intelligentMobility.IntelligentMobilityPackage#getVehicle_Type_VehicleWidth_min()
	 * @model
	 * @generated
	 */
	double getVehicleWidth_min();

	/**
	 * Sets the value of the '{@link intelligentMobility.Vehicle_Type#getVehicleWidth_min <em>Vehicle Width min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Vehicle Width min</em>' attribute.
	 * @see #getVehicleWidth_min()
	 * @generated
	 */
	void setVehicleWidth_min(double value);

	/**
	 * Returns the value of the '<em><b>Vehicle Width max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vehicle Width max</em>' attribute.
	 * @see #setVehicleWidth_max(double)
	 * @see intelligentMobility.IntelligentMobilityPackage#getVehicle_Type_VehicleWidth_max()
	 * @model
	 * @generated
	 */
	double getVehicleWidth_max();

	/**
	 * Sets the value of the '{@link intelligentMobility.Vehicle_Type#getVehicleWidth_max <em>Vehicle Width max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Vehicle Width max</em>' attribute.
	 * @see #getVehicleWidth_max()
	 * @generated
	 */
	void setVehicleWidth_max(double value);

	/**
	 * Returns the value of the '<em><b>Vehicle Width precision</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vehicle Width precision</em>' attribute.
	 * @see #setVehicleWidth_precision(int)
	 * @see intelligentMobility.IntelligentMobilityPackage#getVehicle_Type_VehicleWidth_precision()
	 * @model
	 * @generated
	 */
	int getVehicleWidth_precision();

	/**
	 * Sets the value of the '{@link intelligentMobility.Vehicle_Type#getVehicleWidth_precision <em>Vehicle Width precision</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Vehicle Width precision</em>' attribute.
	 * @see #getVehicleWidth_precision()
	 * @generated
	 */
	void setVehicleWidth_precision(int value);

	/**
	 * Returns the value of the '<em><b>Vehicle Length min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vehicle Length min</em>' attribute.
	 * @see #setVehicleLength_min(double)
	 * @see intelligentMobility.IntelligentMobilityPackage#getVehicle_Type_VehicleLength_min()
	 * @model
	 * @generated
	 */
	double getVehicleLength_min();

	/**
	 * Sets the value of the '{@link intelligentMobility.Vehicle_Type#getVehicleLength_min <em>Vehicle Length min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Vehicle Length min</em>' attribute.
	 * @see #getVehicleLength_min()
	 * @generated
	 */
	void setVehicleLength_min(double value);

	/**
	 * Returns the value of the '<em><b>Vehicle Length max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vehicle Length max</em>' attribute.
	 * @see #setVehicleLength_max(double)
	 * @see intelligentMobility.IntelligentMobilityPackage#getVehicle_Type_VehicleLength_max()
	 * @model
	 * @generated
	 */
	double getVehicleLength_max();

	/**
	 * Sets the value of the '{@link intelligentMobility.Vehicle_Type#getVehicleLength_max <em>Vehicle Length max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Vehicle Length max</em>' attribute.
	 * @see #getVehicleLength_max()
	 * @generated
	 */
	void setVehicleLength_max(double value);

	/**
	 * Returns the value of the '<em><b>Vehicle Length precision</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vehicle Length precision</em>' attribute.
	 * @see #setVehicleLength_precision(int)
	 * @see intelligentMobility.IntelligentMobilityPackage#getVehicle_Type_VehicleLength_precision()
	 * @model
	 * @generated
	 */
	int getVehicleLength_precision();

	/**
	 * Sets the value of the '{@link intelligentMobility.Vehicle_Type#getVehicleLength_precision <em>Vehicle Length precision</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Vehicle Length precision</em>' attribute.
	 * @see #getVehicleLength_precision()
	 * @generated
	 */
	void setVehicleLength_precision(int value);

	/**
	 * Returns the value of the '<em><b>Vehicle Height min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vehicle Height min</em>' attribute.
	 * @see #setVehicleHeight_min(double)
	 * @see intelligentMobility.IntelligentMobilityPackage#getVehicle_Type_VehicleHeight_min()
	 * @model
	 * @generated
	 */
	double getVehicleHeight_min();

	/**
	 * Sets the value of the '{@link intelligentMobility.Vehicle_Type#getVehicleHeight_min <em>Vehicle Height min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Vehicle Height min</em>' attribute.
	 * @see #getVehicleHeight_min()
	 * @generated
	 */
	void setVehicleHeight_min(double value);

	/**
	 * Returns the value of the '<em><b>Vehicle Height max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vehicle Height max</em>' attribute.
	 * @see #setVehicleHeight_max(double)
	 * @see intelligentMobility.IntelligentMobilityPackage#getVehicle_Type_VehicleHeight_max()
	 * @model
	 * @generated
	 */
	double getVehicleHeight_max();

	/**
	 * Sets the value of the '{@link intelligentMobility.Vehicle_Type#getVehicleHeight_max <em>Vehicle Height max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Vehicle Height max</em>' attribute.
	 * @see #getVehicleHeight_max()
	 * @generated
	 */
	void setVehicleHeight_max(double value);

	/**
	 * Returns the value of the '<em><b>Vehicle Height precision</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vehicle Height precision</em>' attribute.
	 * @see #setVehicleHeight_precision(int)
	 * @see intelligentMobility.IntelligentMobilityPackage#getVehicle_Type_VehicleHeight_precision()
	 * @model
	 * @generated
	 */
	int getVehicleHeight_precision();

	/**
	 * Sets the value of the '{@link intelligentMobility.Vehicle_Type#getVehicleHeight_precision <em>Vehicle Height precision</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Vehicle Height precision</em>' attribute.
	 * @see #getVehicleHeight_precision()
	 * @generated
	 */
	void setVehicleHeight_precision(int value);

	/**
	 * Returns the value of the '<em><b>Speed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Speed</em>' attribute.
	 * @see #setSpeed(int)
	 * @see intelligentMobility.IntelligentMobilityPackage#getVehicle_Type_Speed()
	 * @model
	 * @generated
	 */
	int getSpeed();

	/**
	 * Sets the value of the '{@link intelligentMobility.Vehicle_Type#getSpeed <em>Speed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Speed</em>' attribute.
	 * @see #getSpeed()
	 * @generated
	 */
	void setSpeed(int value);

	/**
	 * Returns the value of the '<em><b>Stop</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stop</em>' attribute.
	 * @see #setStop(int)
	 * @see intelligentMobility.IntelligentMobilityPackage#getVehicle_Type_Stop()
	 * @model
	 * @generated
	 */
	int getStop();

	/**
	 * Sets the value of the '{@link intelligentMobility.Vehicle_Type#getStop <em>Stop</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stop</em>' attribute.
	 * @see #getStop()
	 * @generated
	 */
	void setStop(int value);

} // Vehicle_Type
