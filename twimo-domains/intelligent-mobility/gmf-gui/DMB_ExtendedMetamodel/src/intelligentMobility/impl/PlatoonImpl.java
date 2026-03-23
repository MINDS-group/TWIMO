/**
 */
package intelligentMobility.impl;

import intelligentMobility.Following_Vehicle;
import intelligentMobility.IntelligentMobilityPackage;
import intelligentMobility.Leading_Vehicle;
import intelligentMobility.Platoon;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Platoon</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.impl.PlatoonImpl#getName <em>Name</em>}</li>
 *   <li>{@link intelligentMobility.impl.PlatoonImpl#getV2vTime <em>V2v Time</em>}</li>
 *   <li>{@link intelligentMobility.impl.PlatoonImpl#getFollowerCount <em>Follower Count</em>}</li>
 *   <li>{@link intelligentMobility.impl.PlatoonImpl#isResetColor <em>Reset Color</em>}</li>
 *   <li>{@link intelligentMobility.impl.PlatoonImpl#getColorR_min <em>Color Rmin</em>}</li>
 *   <li>{@link intelligentMobility.impl.PlatoonImpl#getColorR_max <em>Color Rmax</em>}</li>
 *   <li>{@link intelligentMobility.impl.PlatoonImpl#getColorG_min <em>Color Gmin</em>}</li>
 *   <li>{@link intelligentMobility.impl.PlatoonImpl#getColorG_max <em>Color Gmax</em>}</li>
 *   <li>{@link intelligentMobility.impl.PlatoonImpl#getColorB_min <em>Color Bmin</em>}</li>
 *   <li>{@link intelligentMobility.impl.PlatoonImpl#getColorB_max <em>Color Bmax</em>}</li>
 *   <li>{@link intelligentMobility.impl.PlatoonImpl#getLeading_vehicle <em>Leading vehicle</em>}</li>
 *   <li>{@link intelligentMobility.impl.PlatoonImpl#getFollowing_vehicle <em>Following vehicle</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PlatoonImpl extends Vehicle_TypeImpl implements Platoon {
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
	 * The default value of the '{@link #getV2vTime() <em>V2v Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getV2vTime()
	 * @generated
	 * @ordered
	 */
	protected static final double V2V_TIME_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getV2vTime() <em>V2v Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getV2vTime()
	 * @generated
	 * @ordered
	 */
	protected double v2vTime = V2V_TIME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFollowerCount() <em>Follower Count</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFollowerCount()
	 * @generated
	 * @ordered
	 */
	protected EList followerCount;

	/**
	 * The default value of the '{@link #isResetColor() <em>Reset Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isResetColor()
	 * @generated
	 * @ordered
	 */
	protected static final boolean RESET_COLOR_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isResetColor() <em>Reset Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isResetColor()
	 * @generated
	 * @ordered
	 */
	protected boolean resetColor = RESET_COLOR_EDEFAULT;

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
	 * The cached value of the '{@link #getLeading_vehicle() <em>Leading vehicle</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLeading_vehicle()
	 * @generated
	 * @ordered
	 */
	protected Leading_Vehicle leading_vehicle;

	/**
	 * The cached value of the '{@link #getFollowing_vehicle() <em>Following vehicle</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFollowing_vehicle()
	 * @generated
	 * @ordered
	 */
	protected EList following_vehicle;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PlatoonImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return IntelligentMobilityPackage.eINSTANCE.getPlatoon();
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
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.PLATOON__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getV2vTime() {
		return v2vTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setV2vTime(double newV2vTime) {
		double oldV2vTime = v2vTime;
		v2vTime = newV2vTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.PLATOON__V2V_TIME, oldV2vTime, v2vTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getFollowerCount() {
		if (followerCount == null) {
			followerCount = new EDataTypeUniqueEList(Integer.class, this, IntelligentMobilityPackage.PLATOON__FOLLOWER_COUNT);
		}
		return followerCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isResetColor() {
		return resetColor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResetColor(boolean newResetColor) {
		boolean oldResetColor = resetColor;
		resetColor = newResetColor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.PLATOON__RESET_COLOR, oldResetColor, resetColor));
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
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.PLATOON__COLOR_RMIN, oldColorR_min, colorR_min));
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
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.PLATOON__COLOR_RMAX, oldColorR_max, colorR_max));
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
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.PLATOON__COLOR_GMIN, oldColorG_min, colorG_min));
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
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.PLATOON__COLOR_GMAX, oldColorG_max, colorG_max));
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
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.PLATOON__COLOR_BMIN, oldColorB_min, colorB_min));
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
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.PLATOON__COLOR_BMAX, oldColorB_max, colorB_max));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Leading_Vehicle getLeading_vehicle() {
		return leading_vehicle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLeading_vehicle(Leading_Vehicle newLeading_vehicle, NotificationChain msgs) {
		Leading_Vehicle oldLeading_vehicle = leading_vehicle;
		leading_vehicle = newLeading_vehicle;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.PLATOON__LEADING_VEHICLE, oldLeading_vehicle, newLeading_vehicle);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLeading_vehicle(Leading_Vehicle newLeading_vehicle) {
		if (newLeading_vehicle != leading_vehicle) {
			NotificationChain msgs = null;
			if (leading_vehicle != null)
				msgs = ((InternalEObject)leading_vehicle).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IntelligentMobilityPackage.PLATOON__LEADING_VEHICLE, null, msgs);
			if (newLeading_vehicle != null)
				msgs = ((InternalEObject)newLeading_vehicle).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IntelligentMobilityPackage.PLATOON__LEADING_VEHICLE, null, msgs);
			msgs = basicSetLeading_vehicle(newLeading_vehicle, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.PLATOON__LEADING_VEHICLE, newLeading_vehicle, newLeading_vehicle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getFollowing_vehicle() {
		if (following_vehicle == null) {
			following_vehicle = new EObjectContainmentEList(Following_Vehicle.class, this, IntelligentMobilityPackage.PLATOON__FOLLOWING_VEHICLE);
		}
		return following_vehicle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case IntelligentMobilityPackage.PLATOON__LEADING_VEHICLE:
				return basicSetLeading_vehicle(null, msgs);
			case IntelligentMobilityPackage.PLATOON__FOLLOWING_VEHICLE:
				return ((InternalEList)getFollowing_vehicle()).basicRemove(otherEnd, msgs);
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
			case IntelligentMobilityPackage.PLATOON__NAME:
				return getName();
			case IntelligentMobilityPackage.PLATOON__V2V_TIME:
				return new Double(getV2vTime());
			case IntelligentMobilityPackage.PLATOON__FOLLOWER_COUNT:
				return getFollowerCount();
			case IntelligentMobilityPackage.PLATOON__RESET_COLOR:
				return isResetColor() ? Boolean.TRUE : Boolean.FALSE;
			case IntelligentMobilityPackage.PLATOON__COLOR_RMIN:
				return new Integer(getColorR_min());
			case IntelligentMobilityPackage.PLATOON__COLOR_RMAX:
				return new Integer(getColorR_max());
			case IntelligentMobilityPackage.PLATOON__COLOR_GMIN:
				return new Integer(getColorG_min());
			case IntelligentMobilityPackage.PLATOON__COLOR_GMAX:
				return new Integer(getColorG_max());
			case IntelligentMobilityPackage.PLATOON__COLOR_BMIN:
				return new Integer(getColorB_min());
			case IntelligentMobilityPackage.PLATOON__COLOR_BMAX:
				return new Integer(getColorB_max());
			case IntelligentMobilityPackage.PLATOON__LEADING_VEHICLE:
				return getLeading_vehicle();
			case IntelligentMobilityPackage.PLATOON__FOLLOWING_VEHICLE:
				return getFollowing_vehicle();
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
			case IntelligentMobilityPackage.PLATOON__NAME:
				setName((String)newValue);
				return;
			case IntelligentMobilityPackage.PLATOON__V2V_TIME:
				setV2vTime(((Double)newValue).doubleValue());
				return;
			case IntelligentMobilityPackage.PLATOON__FOLLOWER_COUNT:
				getFollowerCount().clear();
				getFollowerCount().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.PLATOON__RESET_COLOR:
				setResetColor(((Boolean)newValue).booleanValue());
				return;
			case IntelligentMobilityPackage.PLATOON__COLOR_RMIN:
				setColorR_min(((Integer)newValue).intValue());
				return;
			case IntelligentMobilityPackage.PLATOON__COLOR_RMAX:
				setColorR_max(((Integer)newValue).intValue());
				return;
			case IntelligentMobilityPackage.PLATOON__COLOR_GMIN:
				setColorG_min(((Integer)newValue).intValue());
				return;
			case IntelligentMobilityPackage.PLATOON__COLOR_GMAX:
				setColorG_max(((Integer)newValue).intValue());
				return;
			case IntelligentMobilityPackage.PLATOON__COLOR_BMIN:
				setColorB_min(((Integer)newValue).intValue());
				return;
			case IntelligentMobilityPackage.PLATOON__COLOR_BMAX:
				setColorB_max(((Integer)newValue).intValue());
				return;
			case IntelligentMobilityPackage.PLATOON__LEADING_VEHICLE:
				setLeading_vehicle((Leading_Vehicle)newValue);
				return;
			case IntelligentMobilityPackage.PLATOON__FOLLOWING_VEHICLE:
				getFollowing_vehicle().clear();
				getFollowing_vehicle().addAll((Collection)newValue);
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
			case IntelligentMobilityPackage.PLATOON__NAME:
				setName(NAME_EDEFAULT);
				return;
			case IntelligentMobilityPackage.PLATOON__V2V_TIME:
				setV2vTime(V2V_TIME_EDEFAULT);
				return;
			case IntelligentMobilityPackage.PLATOON__FOLLOWER_COUNT:
				getFollowerCount().clear();
				return;
			case IntelligentMobilityPackage.PLATOON__RESET_COLOR:
				setResetColor(RESET_COLOR_EDEFAULT);
				return;
			case IntelligentMobilityPackage.PLATOON__COLOR_RMIN:
				setColorR_min(COLOR_RMIN_EDEFAULT);
				return;
			case IntelligentMobilityPackage.PLATOON__COLOR_RMAX:
				setColorR_max(COLOR_RMAX_EDEFAULT);
				return;
			case IntelligentMobilityPackage.PLATOON__COLOR_GMIN:
				setColorG_min(COLOR_GMIN_EDEFAULT);
				return;
			case IntelligentMobilityPackage.PLATOON__COLOR_GMAX:
				setColorG_max(COLOR_GMAX_EDEFAULT);
				return;
			case IntelligentMobilityPackage.PLATOON__COLOR_BMIN:
				setColorB_min(COLOR_BMIN_EDEFAULT);
				return;
			case IntelligentMobilityPackage.PLATOON__COLOR_BMAX:
				setColorB_max(COLOR_BMAX_EDEFAULT);
				return;
			case IntelligentMobilityPackage.PLATOON__LEADING_VEHICLE:
				setLeading_vehicle((Leading_Vehicle)null);
				return;
			case IntelligentMobilityPackage.PLATOON__FOLLOWING_VEHICLE:
				getFollowing_vehicle().clear();
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
			case IntelligentMobilityPackage.PLATOON__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case IntelligentMobilityPackage.PLATOON__V2V_TIME:
				return v2vTime != V2V_TIME_EDEFAULT;
			case IntelligentMobilityPackage.PLATOON__FOLLOWER_COUNT:
				return followerCount != null && !followerCount.isEmpty();
			case IntelligentMobilityPackage.PLATOON__RESET_COLOR:
				return resetColor != RESET_COLOR_EDEFAULT;
			case IntelligentMobilityPackage.PLATOON__COLOR_RMIN:
				return colorR_min != COLOR_RMIN_EDEFAULT;
			case IntelligentMobilityPackage.PLATOON__COLOR_RMAX:
				return colorR_max != COLOR_RMAX_EDEFAULT;
			case IntelligentMobilityPackage.PLATOON__COLOR_GMIN:
				return colorG_min != COLOR_GMIN_EDEFAULT;
			case IntelligentMobilityPackage.PLATOON__COLOR_GMAX:
				return colorG_max != COLOR_GMAX_EDEFAULT;
			case IntelligentMobilityPackage.PLATOON__COLOR_BMIN:
				return colorB_min != COLOR_BMIN_EDEFAULT;
			case IntelligentMobilityPackage.PLATOON__COLOR_BMAX:
				return colorB_max != COLOR_BMAX_EDEFAULT;
			case IntelligentMobilityPackage.PLATOON__LEADING_VEHICLE:
				return leading_vehicle != null;
			case IntelligentMobilityPackage.PLATOON__FOLLOWING_VEHICLE:
				return following_vehicle != null && !following_vehicle.isEmpty();
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
		result.append(", v2vTime: ");
		result.append(v2vTime);
		result.append(", followerCount: ");
		result.append(followerCount);
		result.append(", resetColor: ");
		result.append(resetColor);
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
		result.append(')');
		return result.toString();
	}

} //PlatoonImpl
