/**
 */
package intelligentMobility.impl;

import intelligentMobility.IntelligentMobilityPackage;
import intelligentMobility.Normal_Vehicle;
import intelligentMobility.Safety_Requirement;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Normal Vehicle</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.impl.Normal_VehicleImpl#getName <em>Name</em>}</li>
 *   <li>{@link intelligentMobility.impl.Normal_VehicleImpl#isResetColor <em>Reset Color</em>}</li>
 *   <li>{@link intelligentMobility.impl.Normal_VehicleImpl#getColorR_min <em>Color Rmin</em>}</li>
 *   <li>{@link intelligentMobility.impl.Normal_VehicleImpl#getColorR_max <em>Color Rmax</em>}</li>
 *   <li>{@link intelligentMobility.impl.Normal_VehicleImpl#getColorG_min <em>Color Gmin</em>}</li>
 *   <li>{@link intelligentMobility.impl.Normal_VehicleImpl#getColorG_max <em>Color Gmax</em>}</li>
 *   <li>{@link intelligentMobility.impl.Normal_VehicleImpl#getColorB_min <em>Color Bmin</em>}</li>
 *   <li>{@link intelligentMobility.impl.Normal_VehicleImpl#getColorB_max <em>Color Bmax</em>}</li>
 *   <li>{@link intelligentMobility.impl.Normal_VehicleImpl#getSafety_requirements <em>Safety requirements</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Normal_VehicleImpl extends Vehicle_TypeImpl implements Normal_Vehicle {
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
	 * The cached value of the '{@link #getSafety_requirements() <em>Safety requirements</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSafety_requirements()
	 * @generated
	 * @ordered
	 */
	protected Safety_Requirement safety_requirements;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Normal_VehicleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return IntelligentMobilityPackage.eINSTANCE.getNormal_Vehicle();
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
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.NORMAL_VEHICLE__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.NORMAL_VEHICLE__RESET_COLOR, oldResetColor, resetColor));
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
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.NORMAL_VEHICLE__COLOR_RMIN, oldColorR_min, colorR_min));
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
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.NORMAL_VEHICLE__COLOR_RMAX, oldColorR_max, colorR_max));
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
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.NORMAL_VEHICLE__COLOR_GMIN, oldColorG_min, colorG_min));
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
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.NORMAL_VEHICLE__COLOR_GMAX, oldColorG_max, colorG_max));
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
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.NORMAL_VEHICLE__COLOR_BMIN, oldColorB_min, colorB_min));
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
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.NORMAL_VEHICLE__COLOR_BMAX, oldColorB_max, colorB_max));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Safety_Requirement getSafety_requirements() {
		return safety_requirements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSafety_requirements(Safety_Requirement newSafety_requirements, NotificationChain msgs) {
		Safety_Requirement oldSafety_requirements = safety_requirements;
		safety_requirements = newSafety_requirements;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.NORMAL_VEHICLE__SAFETY_REQUIREMENTS, oldSafety_requirements, newSafety_requirements);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSafety_requirements(Safety_Requirement newSafety_requirements) {
		if (newSafety_requirements != safety_requirements) {
			NotificationChain msgs = null;
			if (safety_requirements != null)
				msgs = ((InternalEObject)safety_requirements).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IntelligentMobilityPackage.NORMAL_VEHICLE__SAFETY_REQUIREMENTS, null, msgs);
			if (newSafety_requirements != null)
				msgs = ((InternalEObject)newSafety_requirements).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IntelligentMobilityPackage.NORMAL_VEHICLE__SAFETY_REQUIREMENTS, null, msgs);
			msgs = basicSetSafety_requirements(newSafety_requirements, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.NORMAL_VEHICLE__SAFETY_REQUIREMENTS, newSafety_requirements, newSafety_requirements));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case IntelligentMobilityPackage.NORMAL_VEHICLE__SAFETY_REQUIREMENTS:
				return basicSetSafety_requirements(null, msgs);
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
			case IntelligentMobilityPackage.NORMAL_VEHICLE__NAME:
				return getName();
			case IntelligentMobilityPackage.NORMAL_VEHICLE__RESET_COLOR:
				return isResetColor() ? Boolean.TRUE : Boolean.FALSE;
			case IntelligentMobilityPackage.NORMAL_VEHICLE__COLOR_RMIN:
				return new Integer(getColorR_min());
			case IntelligentMobilityPackage.NORMAL_VEHICLE__COLOR_RMAX:
				return new Integer(getColorR_max());
			case IntelligentMobilityPackage.NORMAL_VEHICLE__COLOR_GMIN:
				return new Integer(getColorG_min());
			case IntelligentMobilityPackage.NORMAL_VEHICLE__COLOR_GMAX:
				return new Integer(getColorG_max());
			case IntelligentMobilityPackage.NORMAL_VEHICLE__COLOR_BMIN:
				return new Integer(getColorB_min());
			case IntelligentMobilityPackage.NORMAL_VEHICLE__COLOR_BMAX:
				return new Integer(getColorB_max());
			case IntelligentMobilityPackage.NORMAL_VEHICLE__SAFETY_REQUIREMENTS:
				return getSafety_requirements();
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
			case IntelligentMobilityPackage.NORMAL_VEHICLE__NAME:
				setName((String)newValue);
				return;
			case IntelligentMobilityPackage.NORMAL_VEHICLE__RESET_COLOR:
				setResetColor(((Boolean)newValue).booleanValue());
				return;
			case IntelligentMobilityPackage.NORMAL_VEHICLE__COLOR_RMIN:
				setColorR_min(((Integer)newValue).intValue());
				return;
			case IntelligentMobilityPackage.NORMAL_VEHICLE__COLOR_RMAX:
				setColorR_max(((Integer)newValue).intValue());
				return;
			case IntelligentMobilityPackage.NORMAL_VEHICLE__COLOR_GMIN:
				setColorG_min(((Integer)newValue).intValue());
				return;
			case IntelligentMobilityPackage.NORMAL_VEHICLE__COLOR_GMAX:
				setColorG_max(((Integer)newValue).intValue());
				return;
			case IntelligentMobilityPackage.NORMAL_VEHICLE__COLOR_BMIN:
				setColorB_min(((Integer)newValue).intValue());
				return;
			case IntelligentMobilityPackage.NORMAL_VEHICLE__COLOR_BMAX:
				setColorB_max(((Integer)newValue).intValue());
				return;
			case IntelligentMobilityPackage.NORMAL_VEHICLE__SAFETY_REQUIREMENTS:
				setSafety_requirements((Safety_Requirement)newValue);
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
			case IntelligentMobilityPackage.NORMAL_VEHICLE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case IntelligentMobilityPackage.NORMAL_VEHICLE__RESET_COLOR:
				setResetColor(RESET_COLOR_EDEFAULT);
				return;
			case IntelligentMobilityPackage.NORMAL_VEHICLE__COLOR_RMIN:
				setColorR_min(COLOR_RMIN_EDEFAULT);
				return;
			case IntelligentMobilityPackage.NORMAL_VEHICLE__COLOR_RMAX:
				setColorR_max(COLOR_RMAX_EDEFAULT);
				return;
			case IntelligentMobilityPackage.NORMAL_VEHICLE__COLOR_GMIN:
				setColorG_min(COLOR_GMIN_EDEFAULT);
				return;
			case IntelligentMobilityPackage.NORMAL_VEHICLE__COLOR_GMAX:
				setColorG_max(COLOR_GMAX_EDEFAULT);
				return;
			case IntelligentMobilityPackage.NORMAL_VEHICLE__COLOR_BMIN:
				setColorB_min(COLOR_BMIN_EDEFAULT);
				return;
			case IntelligentMobilityPackage.NORMAL_VEHICLE__COLOR_BMAX:
				setColorB_max(COLOR_BMAX_EDEFAULT);
				return;
			case IntelligentMobilityPackage.NORMAL_VEHICLE__SAFETY_REQUIREMENTS:
				setSafety_requirements((Safety_Requirement)null);
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
			case IntelligentMobilityPackage.NORMAL_VEHICLE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case IntelligentMobilityPackage.NORMAL_VEHICLE__RESET_COLOR:
				return resetColor != RESET_COLOR_EDEFAULT;
			case IntelligentMobilityPackage.NORMAL_VEHICLE__COLOR_RMIN:
				return colorR_min != COLOR_RMIN_EDEFAULT;
			case IntelligentMobilityPackage.NORMAL_VEHICLE__COLOR_RMAX:
				return colorR_max != COLOR_RMAX_EDEFAULT;
			case IntelligentMobilityPackage.NORMAL_VEHICLE__COLOR_GMIN:
				return colorG_min != COLOR_GMIN_EDEFAULT;
			case IntelligentMobilityPackage.NORMAL_VEHICLE__COLOR_GMAX:
				return colorG_max != COLOR_GMAX_EDEFAULT;
			case IntelligentMobilityPackage.NORMAL_VEHICLE__COLOR_BMIN:
				return colorB_min != COLOR_BMIN_EDEFAULT;
			case IntelligentMobilityPackage.NORMAL_VEHICLE__COLOR_BMAX:
				return colorB_max != COLOR_BMAX_EDEFAULT;
			case IntelligentMobilityPackage.NORMAL_VEHICLE__SAFETY_REQUIREMENTS:
				return safety_requirements != null;
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

} //Normal_VehicleImpl
