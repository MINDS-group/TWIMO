/**
 */
package intelligentMobility;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Vehicle Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.Vehicle_Configuration#getBrandName <em>Brand Name</em>}</li>
 *   <li>{@link intelligentMobility.Vehicle_Configuration#getColorR_min <em>Color Rmin</em>}</li>
 *   <li>{@link intelligentMobility.Vehicle_Configuration#getColorR_max <em>Color Rmax</em>}</li>
 *   <li>{@link intelligentMobility.Vehicle_Configuration#getColorG_min <em>Color Gmin</em>}</li>
 *   <li>{@link intelligentMobility.Vehicle_Configuration#getColorG_max <em>Color Gmax</em>}</li>
 *   <li>{@link intelligentMobility.Vehicle_Configuration#getColorB_min <em>Color Bmin</em>}</li>
 *   <li>{@link intelligentMobility.Vehicle_Configuration#getColorB_max <em>Color Bmax</em>}</li>
 *   <li>{@link intelligentMobility.Vehicle_Configuration#getVehicle_type <em>Vehicle type</em>}</li>
 *   <li>{@link intelligentMobility.Vehicle_Configuration#getGpsYaw <em>Gps Yaw</em>}</li>
 *   <li>{@link intelligentMobility.Vehicle_Configuration#getGpsPitch <em>Gps Pitch</em>}</li>
 *   <li>{@link intelligentMobility.Vehicle_Configuration#getGpsRoll <em>Gps Roll</em>}</li>
 *   <li>{@link intelligentMobility.Vehicle_Configuration#getLatitude <em>Latitude</em>}</li>
 *   <li>{@link intelligentMobility.Vehicle_Configuration#getLongitude <em>Longitude</em>}</li>
 *   <li>{@link intelligentMobility.Vehicle_Configuration#getConnectedInfrastructure <em>Connected Infrastructure</em>}</li>
 * </ul>
 *
 * @see intelligentMobility.IntelligentMobilityPackage#getVehicle_Configuration()
 * @model
 * @generated
 */
public interface Vehicle_Configuration extends EObject {
	/**
	 * Returns the value of the '<em><b>Brand Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Brand Name</em>' attribute.
	 * @see #setBrandName(String)
	 * @see intelligentMobility.IntelligentMobilityPackage#getVehicle_Configuration_BrandName()
	 * @model
	 * @generated
	 */
	String getBrandName();

	/**
	 * Sets the value of the '{@link intelligentMobility.Vehicle_Configuration#getBrandName <em>Brand Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Brand Name</em>' attribute.
	 * @see #getBrandName()
	 * @generated
	 */
	void setBrandName(String value);

	/**
	 * Returns the value of the '<em><b>Color Rmin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Color Rmin</em>' attribute.
	 * @see #setColorR_min(int)
	 * @see intelligentMobility.IntelligentMobilityPackage#getVehicle_Configuration_ColorR_min()
	 * @model
	 * @generated
	 */
	int getColorR_min();

	/**
	 * Sets the value of the '{@link intelligentMobility.Vehicle_Configuration#getColorR_min <em>Color Rmin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Color Rmin</em>' attribute.
	 * @see #getColorR_min()
	 * @generated
	 */
	void setColorR_min(int value);

	/**
	 * Returns the value of the '<em><b>Color Rmax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Color Rmax</em>' attribute.
	 * @see #setColorR_max(int)
	 * @see intelligentMobility.IntelligentMobilityPackage#getVehicle_Configuration_ColorR_max()
	 * @model
	 * @generated
	 */
	int getColorR_max();

	/**
	 * Sets the value of the '{@link intelligentMobility.Vehicle_Configuration#getColorR_max <em>Color Rmax</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Color Rmax</em>' attribute.
	 * @see #getColorR_max()
	 * @generated
	 */
	void setColorR_max(int value);

	/**
	 * Returns the value of the '<em><b>Color Gmin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Color Gmin</em>' attribute.
	 * @see #setColorG_min(int)
	 * @see intelligentMobility.IntelligentMobilityPackage#getVehicle_Configuration_ColorG_min()
	 * @model
	 * @generated
	 */
	int getColorG_min();

	/**
	 * Sets the value of the '{@link intelligentMobility.Vehicle_Configuration#getColorG_min <em>Color Gmin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Color Gmin</em>' attribute.
	 * @see #getColorG_min()
	 * @generated
	 */
	void setColorG_min(int value);

	/**
	 * Returns the value of the '<em><b>Color Gmax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Color Gmax</em>' attribute.
	 * @see #setColorG_max(int)
	 * @see intelligentMobility.IntelligentMobilityPackage#getVehicle_Configuration_ColorG_max()
	 * @model
	 * @generated
	 */
	int getColorG_max();

	/**
	 * Sets the value of the '{@link intelligentMobility.Vehicle_Configuration#getColorG_max <em>Color Gmax</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Color Gmax</em>' attribute.
	 * @see #getColorG_max()
	 * @generated
	 */
	void setColorG_max(int value);

	/**
	 * Returns the value of the '<em><b>Color Bmin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Color Bmin</em>' attribute.
	 * @see #setColorB_min(int)
	 * @see intelligentMobility.IntelligentMobilityPackage#getVehicle_Configuration_ColorB_min()
	 * @model
	 * @generated
	 */
	int getColorB_min();

	/**
	 * Sets the value of the '{@link intelligentMobility.Vehicle_Configuration#getColorB_min <em>Color Bmin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Color Bmin</em>' attribute.
	 * @see #getColorB_min()
	 * @generated
	 */
	void setColorB_min(int value);

	/**
	 * Returns the value of the '<em><b>Color Bmax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Color Bmax</em>' attribute.
	 * @see #setColorB_max(int)
	 * @see intelligentMobility.IntelligentMobilityPackage#getVehicle_Configuration_ColorB_max()
	 * @model
	 * @generated
	 */
	int getColorB_max();

	/**
	 * Sets the value of the '{@link intelligentMobility.Vehicle_Configuration#getColorB_max <em>Color Bmax</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Color Bmax</em>' attribute.
	 * @see #getColorB_max()
	 * @generated
	 */
	void setColorB_max(int value);

	/**
	 * Returns the value of the '<em><b>Vehicle type</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Vehicle_Type}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vehicle type</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getVehicle_Configuration_Vehicle_type()
	 * @model type="intelligentMobility.Vehicle_Type" containment="true" required="true"
	 * @generated
	 */
	EList getVehicle_type();

	/**
	 * Returns the value of the '<em><b>Gps Yaw</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gps Yaw</em>' attribute.
	 * @see #setGpsYaw(double)
	 * @see intelligentMobility.IntelligentMobilityPackage#getVehicle_Configuration_GpsYaw()
	 * @model
	 * @generated
	 */
	double getGpsYaw();

	/**
	 * Sets the value of the '{@link intelligentMobility.Vehicle_Configuration#getGpsYaw <em>Gps Yaw</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Gps Yaw</em>' attribute.
	 * @see #getGpsYaw()
	 * @generated
	 */
	void setGpsYaw(double value);

	/**
	 * Returns the value of the '<em><b>Gps Pitch</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gps Pitch</em>' attribute.
	 * @see #setGpsPitch(double)
	 * @see intelligentMobility.IntelligentMobilityPackage#getVehicle_Configuration_GpsPitch()
	 * @model
	 * @generated
	 */
	double getGpsPitch();

	/**
	 * Sets the value of the '{@link intelligentMobility.Vehicle_Configuration#getGpsPitch <em>Gps Pitch</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Gps Pitch</em>' attribute.
	 * @see #getGpsPitch()
	 * @generated
	 */
	void setGpsPitch(double value);

	/**
	 * Returns the value of the '<em><b>Gps Roll</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gps Roll</em>' attribute.
	 * @see #setGpsRoll(double)
	 * @see intelligentMobility.IntelligentMobilityPackage#getVehicle_Configuration_GpsRoll()
	 * @model
	 * @generated
	 */
	double getGpsRoll();

	/**
	 * Sets the value of the '{@link intelligentMobility.Vehicle_Configuration#getGpsRoll <em>Gps Roll</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Gps Roll</em>' attribute.
	 * @see #getGpsRoll()
	 * @generated
	 */
	void setGpsRoll(double value);

	/**
	 * Returns the value of the '<em><b>Latitude</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Latitude</em>' attribute.
	 * @see #setLatitude(double)
	 * @see intelligentMobility.IntelligentMobilityPackage#getVehicle_Configuration_Latitude()
	 * @model
	 * @generated
	 */
	double getLatitude();

	/**
	 * Sets the value of the '{@link intelligentMobility.Vehicle_Configuration#getLatitude <em>Latitude</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Latitude</em>' attribute.
	 * @see #getLatitude()
	 * @generated
	 */
	void setLatitude(double value);

	/**
	 * Returns the value of the '<em><b>Longitude</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Longitude</em>' attribute.
	 * @see #setLongitude(double)
	 * @see intelligentMobility.IntelligentMobilityPackage#getVehicle_Configuration_Longitude()
	 * @model
	 * @generated
	 */
	double getLongitude();

	/**
	 * Sets the value of the '{@link intelligentMobility.Vehicle_Configuration#getLongitude <em>Longitude</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Longitude</em>' attribute.
	 * @see #getLongitude()
	 * @generated
	 */
	void setLongitude(double value);

	/**
	 * Returns the value of the '<em><b>Connected Infrastructure</b></em>' reference list.
	 * The list contents are of type {@link intelligentMobility.Infrastructure}.
	 * It is bidirectional and its opposite is '{@link intelligentMobility.Infrastructure#getCommunicatesWith <em>Communicates With</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connected Infrastructure</em>' reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getVehicle_Configuration_ConnectedInfrastructure()
	 * @see intelligentMobility.Infrastructure#getCommunicatesWith
	 * @model type="intelligentMobility.Infrastructure" opposite="communicatesWith" required="true"
	 * @generated
	 */
	EList getConnectedInfrastructure();

} // Vehicle_Configuration
