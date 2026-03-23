/**
 */
package intelligentMobility.impl;

import intelligentMobility.Environment_Background;
import intelligentMobility.Environment_Condition;
import intelligentMobility.IntelligentMobilityPackage;
import intelligentMobility.PossibleVehicle;
import intelligentMobility.RoadShape;

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
 * An implementation of the model object '<em><b>Environment Background</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.impl.Environment_BackgroundImpl#getName <em>Name</em>}</li>
 *   <li>{@link intelligentMobility.impl.Environment_BackgroundImpl#getRoadLength <em>Road Length</em>}</li>
 *   <li>{@link intelligentMobility.impl.Environment_BackgroundImpl#getRoadShape <em>Road Shape</em>}</li>
 *   <li>{@link intelligentMobility.impl.Environment_BackgroundImpl#getTotalVehiclePerFrame <em>Total Vehicle Per Frame</em>}</li>
 *   <li>{@link intelligentMobility.impl.Environment_BackgroundImpl#getTrafficDensity <em>Traffic Density</em>}</li>
 *   <li>{@link intelligentMobility.impl.Environment_BackgroundImpl#getSimulationFrameTime <em>Simulation Frame Time</em>}</li>
 *   <li>{@link intelligentMobility.impl.Environment_BackgroundImpl#getSimulationSleepTime <em>Simulation Sleep Time</em>}</li>
 *   <li>{@link intelligentMobility.impl.Environment_BackgroundImpl#getPossiblevehicles <em>Possiblevehicles</em>}</li>
 *   <li>{@link intelligentMobility.impl.Environment_BackgroundImpl#getEnvironment_condition <em>Environment condition</em>}</li>
 *   <li>{@link intelligentMobility.impl.Environment_BackgroundImpl#getRoadIncline <em>Road Incline</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Environment_BackgroundImpl extends MinimalEObjectImpl.Container implements Environment_Background {
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
	 * The default value of the '{@link #getRoadLength() <em>Road Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoadLength()
	 * @generated
	 * @ordered
	 */
	protected static final int ROAD_LENGTH_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getRoadLength() <em>Road Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoadLength()
	 * @generated
	 * @ordered
	 */
	protected int roadLength = ROAD_LENGTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getRoadShape() <em>Road Shape</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoadShape()
	 * @generated
	 * @ordered
	 */
	protected static final RoadShape ROAD_SHAPE_EDEFAULT = RoadShape.ROUND_LITERAL;

	/**
	 * The cached value of the '{@link #getRoadShape() <em>Road Shape</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoadShape()
	 * @generated
	 * @ordered
	 */
	protected RoadShape roadShape = ROAD_SHAPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getTotalVehiclePerFrame() <em>Total Vehicle Per Frame</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTotalVehiclePerFrame()
	 * @generated
	 * @ordered
	 */
	protected static final int TOTAL_VEHICLE_PER_FRAME_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getTotalVehiclePerFrame() <em>Total Vehicle Per Frame</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTotalVehiclePerFrame()
	 * @generated
	 * @ordered
	 */
	protected int totalVehiclePerFrame = TOTAL_VEHICLE_PER_FRAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getTrafficDensity() <em>Traffic Density</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTrafficDensity()
	 * @generated
	 * @ordered
	 */
	protected static final double TRAFFIC_DENSITY_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getTrafficDensity() <em>Traffic Density</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTrafficDensity()
	 * @generated
	 * @ordered
	 */
	protected double trafficDensity = TRAFFIC_DENSITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getSimulationFrameTime() <em>Simulation Frame Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSimulationFrameTime()
	 * @generated
	 * @ordered
	 */
	protected static final double SIMULATION_FRAME_TIME_EDEFAULT = 0.5;

	/**
	 * The cached value of the '{@link #getSimulationFrameTime() <em>Simulation Frame Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSimulationFrameTime()
	 * @generated
	 * @ordered
	 */
	protected double simulationFrameTime = SIMULATION_FRAME_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getSimulationSleepTime() <em>Simulation Sleep Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSimulationSleepTime()
	 * @generated
	 * @ordered
	 */
	protected static final int SIMULATION_SLEEP_TIME_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSimulationSleepTime() <em>Simulation Sleep Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSimulationSleepTime()
	 * @generated
	 * @ordered
	 */
	protected int simulationSleepTime = SIMULATION_SLEEP_TIME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPossiblevehicles() <em>Possiblevehicles</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPossiblevehicles()
	 * @generated
	 * @ordered
	 */
	protected EList possiblevehicles;

	/**
	 * The cached value of the '{@link #getEnvironment_condition() <em>Environment condition</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnvironment_condition()
	 * @generated
	 * @ordered
	 */
	protected EList environment_condition;

	/**
	 * The default value of the '{@link #getRoadIncline() <em>Road Incline</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoadIncline()
	 * @generated
	 * @ordered
	 */
	protected static final double ROAD_INCLINE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getRoadIncline() <em>Road Incline</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoadIncline()
	 * @generated
	 * @ordered
	 */
	protected double roadIncline = ROAD_INCLINE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Environment_BackgroundImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return IntelligentMobilityPackage.eINSTANCE.getEnvironment_Background();
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
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.ENVIRONMENT_BACKGROUND__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getRoadLength() {
		return roadLength;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRoadLength(int newRoadLength) {
		int oldRoadLength = roadLength;
		roadLength = newRoadLength;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.ENVIRONMENT_BACKGROUND__ROAD_LENGTH, oldRoadLength, roadLength));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RoadShape getRoadShape() {
		return roadShape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRoadShape(RoadShape newRoadShape) {
		RoadShape oldRoadShape = roadShape;
		roadShape = newRoadShape == null ? ROAD_SHAPE_EDEFAULT : newRoadShape;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.ENVIRONMENT_BACKGROUND__ROAD_SHAPE, oldRoadShape, roadShape));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getTotalVehiclePerFrame() {
		return totalVehiclePerFrame;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTotalVehiclePerFrame(int newTotalVehiclePerFrame) {
		int oldTotalVehiclePerFrame = totalVehiclePerFrame;
		totalVehiclePerFrame = newTotalVehiclePerFrame;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.ENVIRONMENT_BACKGROUND__TOTAL_VEHICLE_PER_FRAME, oldTotalVehiclePerFrame, totalVehiclePerFrame));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getTrafficDensity() {
		return trafficDensity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTrafficDensity(double newTrafficDensity) {
		double oldTrafficDensity = trafficDensity;
		trafficDensity = newTrafficDensity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.ENVIRONMENT_BACKGROUND__TRAFFIC_DENSITY, oldTrafficDensity, trafficDensity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getSimulationFrameTime() {
		return simulationFrameTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSimulationFrameTime(double newSimulationFrameTime) {
		double oldSimulationFrameTime = simulationFrameTime;
		simulationFrameTime = newSimulationFrameTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.ENVIRONMENT_BACKGROUND__SIMULATION_FRAME_TIME, oldSimulationFrameTime, simulationFrameTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSimulationSleepTime() {
		return simulationSleepTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSimulationSleepTime(int newSimulationSleepTime) {
		int oldSimulationSleepTime = simulationSleepTime;
		simulationSleepTime = newSimulationSleepTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.ENVIRONMENT_BACKGROUND__SIMULATION_SLEEP_TIME, oldSimulationSleepTime, simulationSleepTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getPossiblevehicles() {
		if (possiblevehicles == null) {
			possiblevehicles = new EObjectContainmentEList(PossibleVehicle.class, this, IntelligentMobilityPackage.ENVIRONMENT_BACKGROUND__POSSIBLEVEHICLES);
		}
		return possiblevehicles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getEnvironment_condition() {
		if (environment_condition == null) {
			environment_condition = new EObjectContainmentEList(Environment_Condition.class, this, IntelligentMobilityPackage.ENVIRONMENT_BACKGROUND__ENVIRONMENT_CONDITION);
		}
		return environment_condition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getRoadIncline() {
		return roadIncline;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRoadIncline(double newRoadIncline) {
		double oldRoadIncline = roadIncline;
		roadIncline = newRoadIncline;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.ENVIRONMENT_BACKGROUND__ROAD_INCLINE, oldRoadIncline, roadIncline));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case IntelligentMobilityPackage.ENVIRONMENT_BACKGROUND__POSSIBLEVEHICLES:
				return ((InternalEList)getPossiblevehicles()).basicRemove(otherEnd, msgs);
			case IntelligentMobilityPackage.ENVIRONMENT_BACKGROUND__ENVIRONMENT_CONDITION:
				return ((InternalEList)getEnvironment_condition()).basicRemove(otherEnd, msgs);
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
			case IntelligentMobilityPackage.ENVIRONMENT_BACKGROUND__NAME:
				return getName();
			case IntelligentMobilityPackage.ENVIRONMENT_BACKGROUND__ROAD_LENGTH:
				return new Integer(getRoadLength());
			case IntelligentMobilityPackage.ENVIRONMENT_BACKGROUND__ROAD_SHAPE:
				return getRoadShape();
			case IntelligentMobilityPackage.ENVIRONMENT_BACKGROUND__TOTAL_VEHICLE_PER_FRAME:
				return new Integer(getTotalVehiclePerFrame());
			case IntelligentMobilityPackage.ENVIRONMENT_BACKGROUND__TRAFFIC_DENSITY:
				return new Double(getTrafficDensity());
			case IntelligentMobilityPackage.ENVIRONMENT_BACKGROUND__SIMULATION_FRAME_TIME:
				return new Double(getSimulationFrameTime());
			case IntelligentMobilityPackage.ENVIRONMENT_BACKGROUND__SIMULATION_SLEEP_TIME:
				return new Integer(getSimulationSleepTime());
			case IntelligentMobilityPackage.ENVIRONMENT_BACKGROUND__POSSIBLEVEHICLES:
				return getPossiblevehicles();
			case IntelligentMobilityPackage.ENVIRONMENT_BACKGROUND__ENVIRONMENT_CONDITION:
				return getEnvironment_condition();
			case IntelligentMobilityPackage.ENVIRONMENT_BACKGROUND__ROAD_INCLINE:
				return new Double(getRoadIncline());
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
			case IntelligentMobilityPackage.ENVIRONMENT_BACKGROUND__NAME:
				setName((String)newValue);
				return;
			case IntelligentMobilityPackage.ENVIRONMENT_BACKGROUND__ROAD_LENGTH:
				setRoadLength(((Integer)newValue).intValue());
				return;
			case IntelligentMobilityPackage.ENVIRONMENT_BACKGROUND__ROAD_SHAPE:
				setRoadShape((RoadShape)newValue);
				return;
			case IntelligentMobilityPackage.ENVIRONMENT_BACKGROUND__TOTAL_VEHICLE_PER_FRAME:
				setTotalVehiclePerFrame(((Integer)newValue).intValue());
				return;
			case IntelligentMobilityPackage.ENVIRONMENT_BACKGROUND__TRAFFIC_DENSITY:
				setTrafficDensity(((Double)newValue).doubleValue());
				return;
			case IntelligentMobilityPackage.ENVIRONMENT_BACKGROUND__SIMULATION_FRAME_TIME:
				setSimulationFrameTime(((Double)newValue).doubleValue());
				return;
			case IntelligentMobilityPackage.ENVIRONMENT_BACKGROUND__SIMULATION_SLEEP_TIME:
				setSimulationSleepTime(((Integer)newValue).intValue());
				return;
			case IntelligentMobilityPackage.ENVIRONMENT_BACKGROUND__POSSIBLEVEHICLES:
				getPossiblevehicles().clear();
				getPossiblevehicles().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.ENVIRONMENT_BACKGROUND__ENVIRONMENT_CONDITION:
				getEnvironment_condition().clear();
				getEnvironment_condition().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.ENVIRONMENT_BACKGROUND__ROAD_INCLINE:
				setRoadIncline(((Double)newValue).doubleValue());
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
			case IntelligentMobilityPackage.ENVIRONMENT_BACKGROUND__NAME:
				setName(NAME_EDEFAULT);
				return;
			case IntelligentMobilityPackage.ENVIRONMENT_BACKGROUND__ROAD_LENGTH:
				setRoadLength(ROAD_LENGTH_EDEFAULT);
				return;
			case IntelligentMobilityPackage.ENVIRONMENT_BACKGROUND__ROAD_SHAPE:
				setRoadShape(ROAD_SHAPE_EDEFAULT);
				return;
			case IntelligentMobilityPackage.ENVIRONMENT_BACKGROUND__TOTAL_VEHICLE_PER_FRAME:
				setTotalVehiclePerFrame(TOTAL_VEHICLE_PER_FRAME_EDEFAULT);
				return;
			case IntelligentMobilityPackage.ENVIRONMENT_BACKGROUND__TRAFFIC_DENSITY:
				setTrafficDensity(TRAFFIC_DENSITY_EDEFAULT);
				return;
			case IntelligentMobilityPackage.ENVIRONMENT_BACKGROUND__SIMULATION_FRAME_TIME:
				setSimulationFrameTime(SIMULATION_FRAME_TIME_EDEFAULT);
				return;
			case IntelligentMobilityPackage.ENVIRONMENT_BACKGROUND__SIMULATION_SLEEP_TIME:
				setSimulationSleepTime(SIMULATION_SLEEP_TIME_EDEFAULT);
				return;
			case IntelligentMobilityPackage.ENVIRONMENT_BACKGROUND__POSSIBLEVEHICLES:
				getPossiblevehicles().clear();
				return;
			case IntelligentMobilityPackage.ENVIRONMENT_BACKGROUND__ENVIRONMENT_CONDITION:
				getEnvironment_condition().clear();
				return;
			case IntelligentMobilityPackage.ENVIRONMENT_BACKGROUND__ROAD_INCLINE:
				setRoadIncline(ROAD_INCLINE_EDEFAULT);
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
			case IntelligentMobilityPackage.ENVIRONMENT_BACKGROUND__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case IntelligentMobilityPackage.ENVIRONMENT_BACKGROUND__ROAD_LENGTH:
				return roadLength != ROAD_LENGTH_EDEFAULT;
			case IntelligentMobilityPackage.ENVIRONMENT_BACKGROUND__ROAD_SHAPE:
				return roadShape != ROAD_SHAPE_EDEFAULT;
			case IntelligentMobilityPackage.ENVIRONMENT_BACKGROUND__TOTAL_VEHICLE_PER_FRAME:
				return totalVehiclePerFrame != TOTAL_VEHICLE_PER_FRAME_EDEFAULT;
			case IntelligentMobilityPackage.ENVIRONMENT_BACKGROUND__TRAFFIC_DENSITY:
				return trafficDensity != TRAFFIC_DENSITY_EDEFAULT;
			case IntelligentMobilityPackage.ENVIRONMENT_BACKGROUND__SIMULATION_FRAME_TIME:
				return simulationFrameTime != SIMULATION_FRAME_TIME_EDEFAULT;
			case IntelligentMobilityPackage.ENVIRONMENT_BACKGROUND__SIMULATION_SLEEP_TIME:
				return simulationSleepTime != SIMULATION_SLEEP_TIME_EDEFAULT;
			case IntelligentMobilityPackage.ENVIRONMENT_BACKGROUND__POSSIBLEVEHICLES:
				return possiblevehicles != null && !possiblevehicles.isEmpty();
			case IntelligentMobilityPackage.ENVIRONMENT_BACKGROUND__ENVIRONMENT_CONDITION:
				return environment_condition != null && !environment_condition.isEmpty();
			case IntelligentMobilityPackage.ENVIRONMENT_BACKGROUND__ROAD_INCLINE:
				return roadIncline != ROAD_INCLINE_EDEFAULT;
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
		result.append(" (name: ");
		result.append(name);
		result.append(", roadLength: ");
		result.append(roadLength);
		result.append(", roadShape: ");
		result.append(roadShape);
		result.append(", totalVehiclePerFrame: ");
		result.append(totalVehiclePerFrame);
		result.append(", trafficDensity: ");
		result.append(trafficDensity);
		result.append(", simulationFrameTime: ");
		result.append(simulationFrameTime);
		result.append(", simulationSleepTime: ");
		result.append(simulationSleepTime);
		result.append(", roadIncline: ");
		result.append(roadIncline);
		result.append(')');
		return result.toString();
	}

} //Environment_BackgroundImpl
