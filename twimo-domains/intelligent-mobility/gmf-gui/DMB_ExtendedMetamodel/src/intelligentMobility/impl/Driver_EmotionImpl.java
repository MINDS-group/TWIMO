/**
 */
package intelligentMobility.impl;

import intelligentMobility.Driver_Emotion;
import intelligentMobility.IntelligentMobilityPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Driver Emotion</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.impl.Driver_EmotionImpl#getDrowsinessLevel <em>Drowsiness Level</em>}</li>
 *   <li>{@link intelligentMobility.impl.Driver_EmotionImpl#getImpulseControlLevel <em>Impulse Control Level</em>}</li>
 *   <li>{@link intelligentMobility.impl.Driver_EmotionImpl#getMetanlCondition <em>Metanl Condition</em>}</li>
 *   <li>{@link intelligentMobility.impl.Driver_EmotionImpl#getName <em>Name</em>}</li>
 *   <li>{@link intelligentMobility.impl.Driver_EmotionImpl#getEcgHr <em>Ecg Hr</em>}</li>
 *   <li>{@link intelligentMobility.impl.Driver_EmotionImpl#getGsr <em>Gsr</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Driver_EmotionImpl extends MinimalEObjectImpl.Container implements Driver_Emotion {
	/**
	 * The default value of the '{@link #getDrowsinessLevel() <em>Drowsiness Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDrowsinessLevel()
	 * @generated
	 * @ordered
	 */
	protected static final int DROWSINESS_LEVEL_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getDrowsinessLevel() <em>Drowsiness Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDrowsinessLevel()
	 * @generated
	 * @ordered
	 */
	protected int drowsinessLevel = DROWSINESS_LEVEL_EDEFAULT;

	/**
	 * The default value of the '{@link #getImpulseControlLevel() <em>Impulse Control Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImpulseControlLevel()
	 * @generated
	 * @ordered
	 */
	protected static final int IMPULSE_CONTROL_LEVEL_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getImpulseControlLevel() <em>Impulse Control Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImpulseControlLevel()
	 * @generated
	 * @ordered
	 */
	protected int impulseControlLevel = IMPULSE_CONTROL_LEVEL_EDEFAULT;

	/**
	 * The default value of the '{@link #getMetanlCondition() <em>Metanl Condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetanlCondition()
	 * @generated
	 * @ordered
	 */
	protected static final String METANL_CONDITION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMetanlCondition() <em>Metanl Condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetanlCondition()
	 * @generated
	 * @ordered
	 */
	protected String metanlCondition = METANL_CONDITION_EDEFAULT;

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
	 * The default value of the '{@link #getEcgHr() <em>Ecg Hr</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEcgHr()
	 * @generated
	 * @ordered
	 */
	protected static final int ECG_HR_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getEcgHr() <em>Ecg Hr</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEcgHr()
	 * @generated
	 * @ordered
	 */
	protected int ecgHr = ECG_HR_EDEFAULT;

	/**
	 * The default value of the '{@link #getGsr() <em>Gsr</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGsr()
	 * @generated
	 * @ordered
	 */
	protected static final int GSR_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getGsr() <em>Gsr</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGsr()
	 * @generated
	 * @ordered
	 */
	protected int gsr = GSR_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Driver_EmotionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return IntelligentMobilityPackage.eINSTANCE.getDriver_Emotion();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getDrowsinessLevel() {
		return drowsinessLevel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDrowsinessLevel(int newDrowsinessLevel) {
		int oldDrowsinessLevel = drowsinessLevel;
		drowsinessLevel = newDrowsinessLevel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.DRIVER_EMOTION__DROWSINESS_LEVEL, oldDrowsinessLevel, drowsinessLevel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getImpulseControlLevel() {
		return impulseControlLevel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImpulseControlLevel(int newImpulseControlLevel) {
		int oldImpulseControlLevel = impulseControlLevel;
		impulseControlLevel = newImpulseControlLevel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.DRIVER_EMOTION__IMPULSE_CONTROL_LEVEL, oldImpulseControlLevel, impulseControlLevel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMetanlCondition() {
		return metanlCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMetanlCondition(String newMetanlCondition) {
		String oldMetanlCondition = metanlCondition;
		metanlCondition = newMetanlCondition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.DRIVER_EMOTION__METANL_CONDITION, oldMetanlCondition, metanlCondition));
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
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.DRIVER_EMOTION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getEcgHr() {
		return ecgHr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEcgHr(int newEcgHr) {
		int oldEcgHr = ecgHr;
		ecgHr = newEcgHr;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.DRIVER_EMOTION__ECG_HR, oldEcgHr, ecgHr));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getGsr() {
		return gsr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGsr(int newGsr) {
		int oldGsr = gsr;
		gsr = newGsr;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.DRIVER_EMOTION__GSR, oldGsr, gsr));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IntelligentMobilityPackage.DRIVER_EMOTION__DROWSINESS_LEVEL:
				return new Integer(getDrowsinessLevel());
			case IntelligentMobilityPackage.DRIVER_EMOTION__IMPULSE_CONTROL_LEVEL:
				return new Integer(getImpulseControlLevel());
			case IntelligentMobilityPackage.DRIVER_EMOTION__METANL_CONDITION:
				return getMetanlCondition();
			case IntelligentMobilityPackage.DRIVER_EMOTION__NAME:
				return getName();
			case IntelligentMobilityPackage.DRIVER_EMOTION__ECG_HR:
				return new Integer(getEcgHr());
			case IntelligentMobilityPackage.DRIVER_EMOTION__GSR:
				return new Integer(getGsr());
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
			case IntelligentMobilityPackage.DRIVER_EMOTION__DROWSINESS_LEVEL:
				setDrowsinessLevel(((Integer)newValue).intValue());
				return;
			case IntelligentMobilityPackage.DRIVER_EMOTION__IMPULSE_CONTROL_LEVEL:
				setImpulseControlLevel(((Integer)newValue).intValue());
				return;
			case IntelligentMobilityPackage.DRIVER_EMOTION__METANL_CONDITION:
				setMetanlCondition((String)newValue);
				return;
			case IntelligentMobilityPackage.DRIVER_EMOTION__NAME:
				setName((String)newValue);
				return;
			case IntelligentMobilityPackage.DRIVER_EMOTION__ECG_HR:
				setEcgHr(((Integer)newValue).intValue());
				return;
			case IntelligentMobilityPackage.DRIVER_EMOTION__GSR:
				setGsr(((Integer)newValue).intValue());
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
			case IntelligentMobilityPackage.DRIVER_EMOTION__DROWSINESS_LEVEL:
				setDrowsinessLevel(DROWSINESS_LEVEL_EDEFAULT);
				return;
			case IntelligentMobilityPackage.DRIVER_EMOTION__IMPULSE_CONTROL_LEVEL:
				setImpulseControlLevel(IMPULSE_CONTROL_LEVEL_EDEFAULT);
				return;
			case IntelligentMobilityPackage.DRIVER_EMOTION__METANL_CONDITION:
				setMetanlCondition(METANL_CONDITION_EDEFAULT);
				return;
			case IntelligentMobilityPackage.DRIVER_EMOTION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case IntelligentMobilityPackage.DRIVER_EMOTION__ECG_HR:
				setEcgHr(ECG_HR_EDEFAULT);
				return;
			case IntelligentMobilityPackage.DRIVER_EMOTION__GSR:
				setGsr(GSR_EDEFAULT);
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
			case IntelligentMobilityPackage.DRIVER_EMOTION__DROWSINESS_LEVEL:
				return drowsinessLevel != DROWSINESS_LEVEL_EDEFAULT;
			case IntelligentMobilityPackage.DRIVER_EMOTION__IMPULSE_CONTROL_LEVEL:
				return impulseControlLevel != IMPULSE_CONTROL_LEVEL_EDEFAULT;
			case IntelligentMobilityPackage.DRIVER_EMOTION__METANL_CONDITION:
				return METANL_CONDITION_EDEFAULT == null ? metanlCondition != null : !METANL_CONDITION_EDEFAULT.equals(metanlCondition);
			case IntelligentMobilityPackage.DRIVER_EMOTION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case IntelligentMobilityPackage.DRIVER_EMOTION__ECG_HR:
				return ecgHr != ECG_HR_EDEFAULT;
			case IntelligentMobilityPackage.DRIVER_EMOTION__GSR:
				return gsr != GSR_EDEFAULT;
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
		result.append(" (drowsinessLevel: ");
		result.append(drowsinessLevel);
		result.append(", impulseControlLevel: ");
		result.append(impulseControlLevel);
		result.append(", metanlCondition: ");
		result.append(metanlCondition);
		result.append(", name: ");
		result.append(name);
		result.append(", ecgHr: ");
		result.append(ecgHr);
		result.append(", gsr: ");
		result.append(gsr);
		result.append(')');
		return result.toString();
	}

} //Driver_EmotionImpl
