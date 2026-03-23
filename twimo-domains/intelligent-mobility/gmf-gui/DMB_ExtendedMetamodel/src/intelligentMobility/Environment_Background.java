/**
 */
package intelligentMobility;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Environment Background</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.Environment_Background#getName <em>Name</em>}</li>
 *   <li>{@link intelligentMobility.Environment_Background#getRoadLength <em>Road Length</em>}</li>
 *   <li>{@link intelligentMobility.Environment_Background#getRoadShape <em>Road Shape</em>}</li>
 *   <li>{@link intelligentMobility.Environment_Background#getTotalVehiclePerFrame <em>Total Vehicle Per Frame</em>}</li>
 *   <li>{@link intelligentMobility.Environment_Background#getTrafficDensity <em>Traffic Density</em>}</li>
 *   <li>{@link intelligentMobility.Environment_Background#getSimulationFrameTime <em>Simulation Frame Time</em>}</li>
 *   <li>{@link intelligentMobility.Environment_Background#getSimulationSleepTime <em>Simulation Sleep Time</em>}</li>
 *   <li>{@link intelligentMobility.Environment_Background#getPossiblevehicles <em>Possiblevehicles</em>}</li>
 *   <li>{@link intelligentMobility.Environment_Background#getEnvironment_condition <em>Environment condition</em>}</li>
 *   <li>{@link intelligentMobility.Environment_Background#getRoadIncline <em>Road Incline</em>}</li>
 * </ul>
 *
 * @see intelligentMobility.IntelligentMobilityPackage#getEnvironment_Background()
 * @model
 * @generated
 */
public interface Environment_Background extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see intelligentMobility.IntelligentMobilityPackage#getEnvironment_Background_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link intelligentMobility.Environment_Background#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Road Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Road Length</em>' attribute.
	 * @see #setRoadLength(int)
	 * @see intelligentMobility.IntelligentMobilityPackage#getEnvironment_Background_RoadLength()
	 * @model
	 * @generated
	 */
	int getRoadLength();

	/**
	 * Sets the value of the '{@link intelligentMobility.Environment_Background#getRoadLength <em>Road Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Road Length</em>' attribute.
	 * @see #getRoadLength()
	 * @generated
	 */
	void setRoadLength(int value);

	/**
	 * Returns the value of the '<em><b>Road Shape</b></em>' attribute.
	 * The literals are from the enumeration {@link intelligentMobility.RoadShape}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Road Shape</em>' attribute.
	 * @see intelligentMobility.RoadShape
	 * @see #setRoadShape(RoadShape)
	 * @see intelligentMobility.IntelligentMobilityPackage#getEnvironment_Background_RoadShape()
	 * @model
	 * @generated
	 */
	RoadShape getRoadShape();

	/**
	 * Sets the value of the '{@link intelligentMobility.Environment_Background#getRoadShape <em>Road Shape</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Road Shape</em>' attribute.
	 * @see intelligentMobility.RoadShape
	 * @see #getRoadShape()
	 * @generated
	 */
	void setRoadShape(RoadShape value);

	/**
	 * Returns the value of the '<em><b>Total Vehicle Per Frame</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Total Vehicle Per Frame</em>' attribute.
	 * @see #setTotalVehiclePerFrame(int)
	 * @see intelligentMobility.IntelligentMobilityPackage#getEnvironment_Background_TotalVehiclePerFrame()
	 * @model
	 * @generated
	 */
	int getTotalVehiclePerFrame();

	/**
	 * Sets the value of the '{@link intelligentMobility.Environment_Background#getTotalVehiclePerFrame <em>Total Vehicle Per Frame</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Total Vehicle Per Frame</em>' attribute.
	 * @see #getTotalVehiclePerFrame()
	 * @generated
	 */
	void setTotalVehiclePerFrame(int value);

	/**
	 * Returns the value of the '<em><b>Traffic Density</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Traffic Density</em>' attribute.
	 * @see #setTrafficDensity(double)
	 * @see intelligentMobility.IntelligentMobilityPackage#getEnvironment_Background_TrafficDensity()
	 * @model
	 * @generated
	 */
	double getTrafficDensity();

	/**
	 * Sets the value of the '{@link intelligentMobility.Environment_Background#getTrafficDensity <em>Traffic Density</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Traffic Density</em>' attribute.
	 * @see #getTrafficDensity()
	 * @generated
	 */
	void setTrafficDensity(double value);

	/**
	 * Returns the value of the '<em><b>Simulation Frame Time</b></em>' attribute.
	 * The default value is <code>"0.5"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Simulation Frame Time</em>' attribute.
	 * @see #setSimulationFrameTime(double)
	 * @see intelligentMobility.IntelligentMobilityPackage#getEnvironment_Background_SimulationFrameTime()
	 * @model default="0.5"
	 * @generated
	 */
	double getSimulationFrameTime();

	/**
	 * Sets the value of the '{@link intelligentMobility.Environment_Background#getSimulationFrameTime <em>Simulation Frame Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Simulation Frame Time</em>' attribute.
	 * @see #getSimulationFrameTime()
	 * @generated
	 */
	void setSimulationFrameTime(double value);

	/**
	 * Returns the value of the '<em><b>Simulation Sleep Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Simulation Sleep Time</em>' attribute.
	 * @see #setSimulationSleepTime(int)
	 * @see intelligentMobility.IntelligentMobilityPackage#getEnvironment_Background_SimulationSleepTime()
	 * @model
	 * @generated
	 */
	int getSimulationSleepTime();

	/**
	 * Sets the value of the '{@link intelligentMobility.Environment_Background#getSimulationSleepTime <em>Simulation Sleep Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Simulation Sleep Time</em>' attribute.
	 * @see #getSimulationSleepTime()
	 * @generated
	 */
	void setSimulationSleepTime(int value);

	/**
	 * Returns the value of the '<em><b>Possiblevehicles</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.PossibleVehicle}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Possiblevehicles</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getEnvironment_Background_Possiblevehicles()
	 * @model type="intelligentMobility.PossibleVehicle" containment="true" required="true"
	 * @generated
	 */
	EList getPossiblevehicles();

	/**
	 * Returns the value of the '<em><b>Environment condition</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Environment_Condition}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Environment condition</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getEnvironment_Background_Environment_condition()
	 * @model type="intelligentMobility.Environment_Condition" containment="true" required="true"
	 * @generated
	 */
	EList getEnvironment_condition();

	/**
	 * Returns the value of the '<em><b>Road Incline</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Road Incline</em>' attribute.
	 * @see #setRoadIncline(double)
	 * @see intelligentMobility.IntelligentMobilityPackage#getEnvironment_Background_RoadIncline()
	 * @model
	 * @generated
	 */
	double getRoadIncline();

	/**
	 * Sets the value of the '{@link intelligentMobility.Environment_Background#getRoadIncline <em>Road Incline</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Road Incline</em>' attribute.
	 * @see #getRoadIncline()
	 * @generated
	 */
	void setRoadIncline(double value);

} // Environment_Background
