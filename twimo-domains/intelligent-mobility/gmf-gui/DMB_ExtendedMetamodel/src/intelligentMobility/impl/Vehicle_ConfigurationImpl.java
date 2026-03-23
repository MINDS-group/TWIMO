/**
 */
package intelligentMobility.impl;

import intelligentMobility.Infrastructure;
import intelligentMobility.IntelligentMobilityPackage;
import intelligentMobility.Vehicle_Configuration;
import intelligentMobility.Vehicle_Type;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Vehicle Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.impl.Vehicle_ConfigurationImpl#getBrandName <em>Brand Name</em>}</li>
 *   <li>{@link intelligentMobility.impl.Vehicle_ConfigurationImpl#getColorR_min <em>Color Rmin</em>}</li>
 *   <li>{@link intelligentMobility.impl.Vehicle_ConfigurationImpl#getColorR_max <em>Color Rmax</em>}</li>
 *   <li>{@link intelligentMobility.impl.Vehicle_ConfigurationImpl#getColorG_min <em>Color Gmin</em>}</li>
 *   <li>{@link intelligentMobility.impl.Vehicle_ConfigurationImpl#getColorG_max <em>Color Gmax</em>}</li>
 *   <li>{@link intelligentMobility.impl.Vehicle_ConfigurationImpl#getColorB_min <em>Color Bmin</em>}</li>
 *   <li>{@link intelligentMobility.impl.Vehicle_ConfigurationImpl#getColorB_max <em>Color Bmax</em>}</li>
 *   <li>{@link intelligentMobility.impl.Vehicle_ConfigurationImpl#getVehicle_type <em>Vehicle type</em>}</li>
 *   <li>{@link intelligentMobility.impl.Vehicle_ConfigurationImpl#getGpsYaw <em>Gps Yaw</em>}</li>
 *   <li>{@link intelligentMobility.impl.Vehicle_ConfigurationImpl#getGpsPitch <em>Gps Pitch</em>}</li>
 *   <li>{@link intelligentMobility.impl.Vehicle_ConfigurationImpl#getGpsRoll <em>Gps Roll</em>}</li>
 *   <li>{@link intelligentMobility.impl.Vehicle_ConfigurationImpl#getLatitude <em>Latitude</em>}</li>
 *   <li>{@link intelligentMobility.impl.Vehicle_ConfigurationImpl#getLongitude <em>Longitude</em>}</li>
 *   <li>{@link intelligentMobility.impl.Vehicle_ConfigurationImpl#getConnectedInfrastructure <em>Connected Infrastructure</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Vehicle_ConfigurationImpl extends MinimalEObjectImpl.Container implements Vehicle_Configuration {
	/**
	 * The default value of the '{@link #getBrandName() <em>Brand Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBrandName()
	 * @generated
	 * @ordered
	 */
	protected static final String BRAND_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBrandName() <em>Brand Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBrandName()
	 * @generated
	 * @ordered
	 */
	protected String brandName = BRAND_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getColorR_min() <em>Color Rmin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColorR_min()
	 * @generated
	 * @ordered
	 */
	protected static final int COLOR_RMIN_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getColorR_min() <em>Color Rmin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColorR_min()
	 * @generated
	 * @ordered
	 */
	protected int colorR_min = COLOR_RMIN_EDEFAULT;

	/**
	 * The default value of the '{@link #getColorR_max() <em>Color Rmax</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColorR_max()
	 * @generated
	 * @ordered
	 */
	protected static final int COLOR_RMAX_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getColorR_max() <em>Color Rmax</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColorR_max()
	 * @generated
	 * @ordered
	 */
	protected int colorR_max = COLOR_RMAX_EDEFAULT;

	/**
	 * The default value of the '{@link #getColorG_min() <em>Color Gmin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColorG_min()
	 * @generated
	 * @ordered
	 */
	protected static final int COLOR_GMIN_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getColorG_min() <em>Color Gmin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColorG_min()
	 * @generated
	 * @ordered
	 */
	protected int colorG_min = COLOR_GMIN_EDEFAULT;

	/**
	 * The default value of the '{@link #getColorG_max() <em>Color Gmax</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColorG_max()
	 * @generated
	 * @ordered
	 */
	protected static final int COLOR_GMAX_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getColorG_max() <em>Color Gmax</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColorG_max()
	 * @generated
	 * @ordered
	 */
	protected int colorG_max = COLOR_GMAX_EDEFAULT;

	/**
	 * The default value of the '{@link #getColorB_min() <em>Color Bmin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColorB_min()
	 * @generated
	 * @ordered
	 */
	protected static final int COLOR_BMIN_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getColorB_min() <em>Color Bmin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColorB_min()
	 * @generated
	 * @ordered
	 */
	protected int colorB_min = COLOR_BMIN_EDEFAULT;

	/**
	 * The default value of the '{@link #getColorB_max() <em>Color Bmax</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColorB_max()
	 * @generated
	 * @ordered
	 */
	protected static final int COLOR_BMAX_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getColorB_max() <em>Color Bmax</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColorB_max()
	 * @generated
	 * @ordered
	 */
	protected int colorB_max = COLOR_BMAX_EDEFAULT;

	/**
	 * The cached value of the '{@link #getVehicle_type() <em>Vehicle type</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVehicle_type()
	 * @generated
	 * @ordered
	 */
	protected EList vehicle_type;

	/**
	 * The default value of the '{@link #getGpsYaw() <em>Gps Yaw</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGpsYaw()
	 * @generated
	 * @ordered
	 */
	protected static final double GPS_YAW_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getGpsYaw() <em>Gps Yaw</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGpsYaw()
	 * @generated
	 * @ordered
	 */
	protected double gpsYaw = GPS_YAW_EDEFAULT;

	/**
	 * The default value of the '{@link #getGpsPitch() <em>Gps Pitch</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGpsPitch()
	 * @generated
	 * @ordered
	 */
	protected static final double GPS_PITCH_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getGpsPitch() <em>Gps Pitch</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGpsPitch()
	 * @generated
	 * @ordered
	 */
	protected double gpsPitch = GPS_PITCH_EDEFAULT;

	/**
	 * The default value of the '{@link #getGpsRoll() <em>Gps Roll</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGpsRoll()
	 * @generated
	 * @ordered
	 */
	protected static final double GPS_ROLL_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getGpsRoll() <em>Gps Roll</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGpsRoll()
	 * @generated
	 * @ordered
	 */
	protected double gpsRoll = GPS_ROLL_EDEFAULT;

	/**
	 * The default value of the '{@link #getLatitude() <em>Latitude</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLatitude()
	 * @generated
	 * @ordered
	 */
	protected static final double LATITUDE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getLatitude() <em>Latitude</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLatitude()
	 * @generated
	 * @ordered
	 */
	protected double latitude = LATITUDE_EDEFAULT;

	/**
	 * The default value of the '{@link #getLongitude() <em>Longitude</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLongitude()
	 * @generated
	 * @ordered
	 */
	protected static final double LONGITUDE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getLongitude() <em>Longitude</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLongitude()
	 * @generated
	 * @ordered
	 */
	protected double longitude = LONGITUDE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getConnectedInfrastructure() <em>Connected Infrastructure</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectedInfrastructure()
	 * @generated
	 * @ordered
	 */
	protected EList connectedInfrastructure;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Vehicle_ConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return IntelligentMobilityPackage.eINSTANCE.getVehicle_Configuration();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBrandName() {
		return brandName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBrandName(String newBrandName) {
		String oldBrandName = brandName;
		brandName = newBrandName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.VEHICLE_CONFIGURATION__BRAND_NAME, oldBrandName, brandName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getColorR_min() {
		return colorR_min;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setColorR_min(int newColorR_min) {
		int oldColorR_min = colorR_min;
		colorR_min = newColorR_min;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.VEHICLE_CONFIGURATION__COLOR_RMIN, oldColorR_min, colorR_min));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getColorR_max() {
		return colorR_max;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setColorR_max(int newColorR_max) {
		int oldColorR_max = colorR_max;
		colorR_max = newColorR_max;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.VEHICLE_CONFIGURATION__COLOR_RMAX, oldColorR_max, colorR_max));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getColorG_min() {
		return colorG_min;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setColorG_min(int newColorG_min) {
		int oldColorG_min = colorG_min;
		colorG_min = newColorG_min;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.VEHICLE_CONFIGURATION__COLOR_GMIN, oldColorG_min, colorG_min));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getColorG_max() {
		return colorG_max;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setColorG_max(int newColorG_max) {
		int oldColorG_max = colorG_max;
		colorG_max = newColorG_max;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.VEHICLE_CONFIGURATION__COLOR_GMAX, oldColorG_max, colorG_max));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getColorB_min() {
		return colorB_min;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setColorB_min(int newColorB_min) {
		int oldColorB_min = colorB_min;
		colorB_min = newColorB_min;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.VEHICLE_CONFIGURATION__COLOR_BMIN, oldColorB_min, colorB_min));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getColorB_max() {
		return colorB_max;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setColorB_max(int newColorB_max) {
		int oldColorB_max = colorB_max;
		colorB_max = newColorB_max;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.VEHICLE_CONFIGURATION__COLOR_BMAX, oldColorB_max, colorB_max));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getVehicle_type() {
		if (vehicle_type == null) {
			vehicle_type = new EObjectContainmentEList(Vehicle_Type.class, this, IntelligentMobilityPackage.VEHICLE_CONFIGURATION__VEHICLE_TYPE);
		}
		return vehicle_type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getGpsYaw() {
		return gpsYaw;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGpsYaw(double newGpsYaw) {
		double oldGpsYaw = gpsYaw;
		gpsYaw = newGpsYaw;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.VEHICLE_CONFIGURATION__GPS_YAW, oldGpsYaw, gpsYaw));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getGpsPitch() {
		return gpsPitch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGpsPitch(double newGpsPitch) {
		double oldGpsPitch = gpsPitch;
		gpsPitch = newGpsPitch;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.VEHICLE_CONFIGURATION__GPS_PITCH, oldGpsPitch, gpsPitch));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getGpsRoll() {
		return gpsRoll;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGpsRoll(double newGpsRoll) {
		double oldGpsRoll = gpsRoll;
		gpsRoll = newGpsRoll;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.VEHICLE_CONFIGURATION__GPS_ROLL, oldGpsRoll, gpsRoll));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLatitude(double newLatitude) {
		double oldLatitude = latitude;
		latitude = newLatitude;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.VEHICLE_CONFIGURATION__LATITUDE, oldLatitude, latitude));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLongitude(double newLongitude) {
		double oldLongitude = longitude;
		longitude = newLongitude;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.VEHICLE_CONFIGURATION__LONGITUDE, oldLongitude, longitude));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getConnectedInfrastructure() {
		if (connectedInfrastructure == null) {
			connectedInfrastructure = new EObjectWithInverseResolvingEList.ManyInverse(Infrastructure.class, this, IntelligentMobilityPackage.VEHICLE_CONFIGURATION__CONNECTED_INFRASTRUCTURE, IntelligentMobilityPackage.INFRASTRUCTURE__COMMUNICATES_WITH);
		}
		return connectedInfrastructure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case IntelligentMobilityPackage.VEHICLE_CONFIGURATION__CONNECTED_INFRASTRUCTURE:
				return ((InternalEList)getConnectedInfrastructure()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case IntelligentMobilityPackage.VEHICLE_CONFIGURATION__VEHICLE_TYPE:
				return ((InternalEList)getVehicle_type()).basicRemove(otherEnd, msgs);
			case IntelligentMobilityPackage.VEHICLE_CONFIGURATION__CONNECTED_INFRASTRUCTURE:
				return ((InternalEList)getConnectedInfrastructure()).basicRemove(otherEnd, msgs);
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
			case IntelligentMobilityPackage.VEHICLE_CONFIGURATION__BRAND_NAME:
				return getBrandName();
			case IntelligentMobilityPackage.VEHICLE_CONFIGURATION__COLOR_RMIN:
				return new Integer(getColorR_min());
			case IntelligentMobilityPackage.VEHICLE_CONFIGURATION__COLOR_RMAX:
				return new Integer(getColorR_max());
			case IntelligentMobilityPackage.VEHICLE_CONFIGURATION__COLOR_GMIN:
				return new Integer(getColorG_min());
			case IntelligentMobilityPackage.VEHICLE_CONFIGURATION__COLOR_GMAX:
				return new Integer(getColorG_max());
			case IntelligentMobilityPackage.VEHICLE_CONFIGURATION__COLOR_BMIN:
				return new Integer(getColorB_min());
			case IntelligentMobilityPackage.VEHICLE_CONFIGURATION__COLOR_BMAX:
				return new Integer(getColorB_max());
			case IntelligentMobilityPackage.VEHICLE_CONFIGURATION__VEHICLE_TYPE:
				return getVehicle_type();
			case IntelligentMobilityPackage.VEHICLE_CONFIGURATION__GPS_YAW:
				return new Double(getGpsYaw());
			case IntelligentMobilityPackage.VEHICLE_CONFIGURATION__GPS_PITCH:
				return new Double(getGpsPitch());
			case IntelligentMobilityPackage.VEHICLE_CONFIGURATION__GPS_ROLL:
				return new Double(getGpsRoll());
			case IntelligentMobilityPackage.VEHICLE_CONFIGURATION__LATITUDE:
				return new Double(getLatitude());
			case IntelligentMobilityPackage.VEHICLE_CONFIGURATION__LONGITUDE:
				return new Double(getLongitude());
			case IntelligentMobilityPackage.VEHICLE_CONFIGURATION__CONNECTED_INFRASTRUCTURE:
				return getConnectedInfrastructure();
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
			case IntelligentMobilityPackage.VEHICLE_CONFIGURATION__BRAND_NAME:
				setBrandName((String)newValue);
				return;
			case IntelligentMobilityPackage.VEHICLE_CONFIGURATION__COLOR_RMIN:
				setColorR_min(((Integer)newValue).intValue());
				return;
			case IntelligentMobilityPackage.VEHICLE_CONFIGURATION__COLOR_RMAX:
				setColorR_max(((Integer)newValue).intValue());
				return;
			case IntelligentMobilityPackage.VEHICLE_CONFIGURATION__COLOR_GMIN:
				setColorG_min(((Integer)newValue).intValue());
				return;
			case IntelligentMobilityPackage.VEHICLE_CONFIGURATION__COLOR_GMAX:
				setColorG_max(((Integer)newValue).intValue());
				return;
			case IntelligentMobilityPackage.VEHICLE_CONFIGURATION__COLOR_BMIN:
				setColorB_min(((Integer)newValue).intValue());
				return;
			case IntelligentMobilityPackage.VEHICLE_CONFIGURATION__COLOR_BMAX:
				setColorB_max(((Integer)newValue).intValue());
				return;
			case IntelligentMobilityPackage.VEHICLE_CONFIGURATION__VEHICLE_TYPE:
				getVehicle_type().clear();
				getVehicle_type().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.VEHICLE_CONFIGURATION__GPS_YAW:
				setGpsYaw(((Double)newValue).doubleValue());
				return;
			case IntelligentMobilityPackage.VEHICLE_CONFIGURATION__GPS_PITCH:
				setGpsPitch(((Double)newValue).doubleValue());
				return;
			case IntelligentMobilityPackage.VEHICLE_CONFIGURATION__GPS_ROLL:
				setGpsRoll(((Double)newValue).doubleValue());
				return;
			case IntelligentMobilityPackage.VEHICLE_CONFIGURATION__LATITUDE:
				setLatitude(((Double)newValue).doubleValue());
				return;
			case IntelligentMobilityPackage.VEHICLE_CONFIGURATION__LONGITUDE:
				setLongitude(((Double)newValue).doubleValue());
				return;
			case IntelligentMobilityPackage.VEHICLE_CONFIGURATION__CONNECTED_INFRASTRUCTURE:
				getConnectedInfrastructure().clear();
				getConnectedInfrastructure().addAll((Collection)newValue);
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
			case IntelligentMobilityPackage.VEHICLE_CONFIGURATION__BRAND_NAME:
				setBrandName(BRAND_NAME_EDEFAULT);
				return;
			case IntelligentMobilityPackage.VEHICLE_CONFIGURATION__COLOR_RMIN:
				setColorR_min(COLOR_RMIN_EDEFAULT);
				return;
			case IntelligentMobilityPackage.VEHICLE_CONFIGURATION__COLOR_RMAX:
				setColorR_max(COLOR_RMAX_EDEFAULT);
				return;
			case IntelligentMobilityPackage.VEHICLE_CONFIGURATION__COLOR_GMIN:
				setColorG_min(COLOR_GMIN_EDEFAULT);
				return;
			case IntelligentMobilityPackage.VEHICLE_CONFIGURATION__COLOR_GMAX:
				setColorG_max(COLOR_GMAX_EDEFAULT);
				return;
			case IntelligentMobilityPackage.VEHICLE_CONFIGURATION__COLOR_BMIN:
				setColorB_min(COLOR_BMIN_EDEFAULT);
				return;
			case IntelligentMobilityPackage.VEHICLE_CONFIGURATION__COLOR_BMAX:
				setColorB_max(COLOR_BMAX_EDEFAULT);
				return;
			case IntelligentMobilityPackage.VEHICLE_CONFIGURATION__VEHICLE_TYPE:
				getVehicle_type().clear();
				return;
			case IntelligentMobilityPackage.VEHICLE_CONFIGURATION__GPS_YAW:
				setGpsYaw(GPS_YAW_EDEFAULT);
				return;
			case IntelligentMobilityPackage.VEHICLE_CONFIGURATION__GPS_PITCH:
				setGpsPitch(GPS_PITCH_EDEFAULT);
				return;
			case IntelligentMobilityPackage.VEHICLE_CONFIGURATION__GPS_ROLL:
				setGpsRoll(GPS_ROLL_EDEFAULT);
				return;
			case IntelligentMobilityPackage.VEHICLE_CONFIGURATION__LATITUDE:
				setLatitude(LATITUDE_EDEFAULT);
				return;
			case IntelligentMobilityPackage.VEHICLE_CONFIGURATION__LONGITUDE:
				setLongitude(LONGITUDE_EDEFAULT);
				return;
			case IntelligentMobilityPackage.VEHICLE_CONFIGURATION__CONNECTED_INFRASTRUCTURE:
				getConnectedInfrastructure().clear();
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
			case IntelligentMobilityPackage.VEHICLE_CONFIGURATION__BRAND_NAME:
				return BRAND_NAME_EDEFAULT == null ? brandName != null : !BRAND_NAME_EDEFAULT.equals(brandName);
			case IntelligentMobilityPackage.VEHICLE_CONFIGURATION__COLOR_RMIN:
				return colorR_min != COLOR_RMIN_EDEFAULT;
			case IntelligentMobilityPackage.VEHICLE_CONFIGURATION__COLOR_RMAX:
				return colorR_max != COLOR_RMAX_EDEFAULT;
			case IntelligentMobilityPackage.VEHICLE_CONFIGURATION__COLOR_GMIN:
				return colorG_min != COLOR_GMIN_EDEFAULT;
			case IntelligentMobilityPackage.VEHICLE_CONFIGURATION__COLOR_GMAX:
				return colorG_max != COLOR_GMAX_EDEFAULT;
			case IntelligentMobilityPackage.VEHICLE_CONFIGURATION__COLOR_BMIN:
				return colorB_min != COLOR_BMIN_EDEFAULT;
			case IntelligentMobilityPackage.VEHICLE_CONFIGURATION__COLOR_BMAX:
				return colorB_max != COLOR_BMAX_EDEFAULT;
			case IntelligentMobilityPackage.VEHICLE_CONFIGURATION__VEHICLE_TYPE:
				return vehicle_type != null && !vehicle_type.isEmpty();
			case IntelligentMobilityPackage.VEHICLE_CONFIGURATION__GPS_YAW:
				return gpsYaw != GPS_YAW_EDEFAULT;
			case IntelligentMobilityPackage.VEHICLE_CONFIGURATION__GPS_PITCH:
				return gpsPitch != GPS_PITCH_EDEFAULT;
			case IntelligentMobilityPackage.VEHICLE_CONFIGURATION__GPS_ROLL:
				return gpsRoll != GPS_ROLL_EDEFAULT;
			case IntelligentMobilityPackage.VEHICLE_CONFIGURATION__LATITUDE:
				return latitude != LATITUDE_EDEFAULT;
			case IntelligentMobilityPackage.VEHICLE_CONFIGURATION__LONGITUDE:
				return longitude != LONGITUDE_EDEFAULT;
			case IntelligentMobilityPackage.VEHICLE_CONFIGURATION__CONNECTED_INFRASTRUCTURE:
				return connectedInfrastructure != null && !connectedInfrastructure.isEmpty();
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
		result.append(" (brandName: ");
		result.append(brandName);
		result.append(", colorR_min: ");
		result.append(colorR_min);
		result.append(", colorR_max: ");
		result.append(colorR_max);
		result.append(", colorG_min: ");
		result.append(colorG_min);
		result.append(", colorG_max: ");
		result.append(colorG_max);
		result.append(", colorB_min: ");
		result.append(colorB_min);
		result.append(", colorB_max: ");
		result.append(colorB_max);
		result.append(", gpsYaw: ");
		result.append(gpsYaw);
		result.append(", gpsPitch: ");
		result.append(gpsPitch);
		result.append(", gpsRoll: ");
		result.append(gpsRoll);
		result.append(", latitude: ");
		result.append(latitude);
		result.append(", longitude: ");
		result.append(longitude);
		result.append(')');
		return result.toString();
	}

} //Vehicle_ConfigurationImpl
