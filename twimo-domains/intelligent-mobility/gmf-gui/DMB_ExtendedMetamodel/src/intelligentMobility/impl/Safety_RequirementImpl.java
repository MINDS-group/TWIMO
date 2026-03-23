/**
 */
package intelligentMobility.impl;

import intelligentMobility.IntelligentMobilityPackage;
import intelligentMobility.Regulation;
import intelligentMobility.Safety_Requirement;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Safety Requirement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.impl.Safety_RequirementImpl#getSafeSecond <em>Safe Second</em>}</li>
 *   <li>{@link intelligentMobility.impl.Safety_RequirementImpl#getSafezoneLength_default <em>Safezone Length default</em>}</li>
 *   <li>{@link intelligentMobility.impl.Safety_RequirementImpl#getSafeFrontMin <em>Safe Front Min</em>}</li>
 *   <li>{@link intelligentMobility.impl.Safety_RequirementImpl#getName <em>Name</em>}</li>
 *   <li>{@link intelligentMobility.impl.Safety_RequirementImpl#getRegulations <em>Regulations</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Safety_RequirementImpl extends MinimalEObjectImpl.Container implements Safety_Requirement {
	/**
	 * The default value of the '{@link #getSafeSecond() <em>Safe Second</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSafeSecond()
	 * @generated
	 * @ordered
	 */
	protected static final int SAFE_SECOND_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSafeSecond() <em>Safe Second</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSafeSecond()
	 * @generated
	 * @ordered
	 */
	protected int safeSecond = SAFE_SECOND_EDEFAULT;

	/**
	 * The default value of the '{@link #getSafezoneLength_default() <em>Safezone Length default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSafezoneLength_default()
	 * @generated
	 * @ordered
	 */
	protected static final double SAFEZONE_LENGTH_DEFAULT_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getSafezoneLength_default() <em>Safezone Length default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSafezoneLength_default()
	 * @generated
	 * @ordered
	 */
	protected double safezoneLength_default = SAFEZONE_LENGTH_DEFAULT_EDEFAULT;

	/**
	 * The default value of the '{@link #getSafeFrontMin() <em>Safe Front Min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSafeFrontMin()
	 * @generated
	 * @ordered
	 */
	protected static final double SAFE_FRONT_MIN_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getSafeFrontMin() <em>Safe Front Min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSafeFrontMin()
	 * @generated
	 * @ordered
	 */
	protected double safeFrontMin = SAFE_FRONT_MIN_EDEFAULT;

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
	 * The cached value of the '{@link #getRegulations() <em>Regulations</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRegulations()
	 * @generated
	 * @ordered
	 */
	protected Regulation regulations;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Safety_RequirementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return IntelligentMobilityPackage.eINSTANCE.getSafety_Requirement();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSafeSecond() {
		return safeSecond;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSafeSecond(int newSafeSecond) {
		int oldSafeSecond = safeSecond;
		safeSecond = newSafeSecond;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.SAFETY_REQUIREMENT__SAFE_SECOND, oldSafeSecond, safeSecond));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getSafezoneLength_default() {
		return safezoneLength_default;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSafezoneLength_default(double newSafezoneLength_default) {
		double oldSafezoneLength_default = safezoneLength_default;
		safezoneLength_default = newSafezoneLength_default;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.SAFETY_REQUIREMENT__SAFEZONE_LENGTH_DEFAULT, oldSafezoneLength_default, safezoneLength_default));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getSafeFrontMin() {
		return safeFrontMin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSafeFrontMin(double newSafeFrontMin) {
		double oldSafeFrontMin = safeFrontMin;
		safeFrontMin = newSafeFrontMin;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.SAFETY_REQUIREMENT__SAFE_FRONT_MIN, oldSafeFrontMin, safeFrontMin));
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
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.SAFETY_REQUIREMENT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Regulation getRegulations() {
		if (regulations != null && regulations.eIsProxy()) {
			InternalEObject oldRegulations = (InternalEObject)regulations;
			regulations = (Regulation)eResolveProxy(oldRegulations);
			if (regulations != oldRegulations) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.SAFETY_REQUIREMENT__REGULATIONS, oldRegulations, regulations));
			}
		}
		return regulations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Regulation basicGetRegulations() {
		return regulations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRegulations(Regulation newRegulations) {
		Regulation oldRegulations = regulations;
		regulations = newRegulations;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.SAFETY_REQUIREMENT__REGULATIONS, oldRegulations, regulations));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IntelligentMobilityPackage.SAFETY_REQUIREMENT__SAFE_SECOND:
				return new Integer(getSafeSecond());
			case IntelligentMobilityPackage.SAFETY_REQUIREMENT__SAFEZONE_LENGTH_DEFAULT:
				return new Double(getSafezoneLength_default());
			case IntelligentMobilityPackage.SAFETY_REQUIREMENT__SAFE_FRONT_MIN:
				return new Double(getSafeFrontMin());
			case IntelligentMobilityPackage.SAFETY_REQUIREMENT__NAME:
				return getName();
			case IntelligentMobilityPackage.SAFETY_REQUIREMENT__REGULATIONS:
				if (resolve) return getRegulations();
				return basicGetRegulations();
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
			case IntelligentMobilityPackage.SAFETY_REQUIREMENT__SAFE_SECOND:
				setSafeSecond(((Integer)newValue).intValue());
				return;
			case IntelligentMobilityPackage.SAFETY_REQUIREMENT__SAFEZONE_LENGTH_DEFAULT:
				setSafezoneLength_default(((Double)newValue).doubleValue());
				return;
			case IntelligentMobilityPackage.SAFETY_REQUIREMENT__SAFE_FRONT_MIN:
				setSafeFrontMin(((Double)newValue).doubleValue());
				return;
			case IntelligentMobilityPackage.SAFETY_REQUIREMENT__NAME:
				setName((String)newValue);
				return;
			case IntelligentMobilityPackage.SAFETY_REQUIREMENT__REGULATIONS:
				setRegulations((Regulation)newValue);
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
			case IntelligentMobilityPackage.SAFETY_REQUIREMENT__SAFE_SECOND:
				setSafeSecond(SAFE_SECOND_EDEFAULT);
				return;
			case IntelligentMobilityPackage.SAFETY_REQUIREMENT__SAFEZONE_LENGTH_DEFAULT:
				setSafezoneLength_default(SAFEZONE_LENGTH_DEFAULT_EDEFAULT);
				return;
			case IntelligentMobilityPackage.SAFETY_REQUIREMENT__SAFE_FRONT_MIN:
				setSafeFrontMin(SAFE_FRONT_MIN_EDEFAULT);
				return;
			case IntelligentMobilityPackage.SAFETY_REQUIREMENT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case IntelligentMobilityPackage.SAFETY_REQUIREMENT__REGULATIONS:
				setRegulations((Regulation)null);
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
			case IntelligentMobilityPackage.SAFETY_REQUIREMENT__SAFE_SECOND:
				return safeSecond != SAFE_SECOND_EDEFAULT;
			case IntelligentMobilityPackage.SAFETY_REQUIREMENT__SAFEZONE_LENGTH_DEFAULT:
				return safezoneLength_default != SAFEZONE_LENGTH_DEFAULT_EDEFAULT;
			case IntelligentMobilityPackage.SAFETY_REQUIREMENT__SAFE_FRONT_MIN:
				return safeFrontMin != SAFE_FRONT_MIN_EDEFAULT;
			case IntelligentMobilityPackage.SAFETY_REQUIREMENT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case IntelligentMobilityPackage.SAFETY_REQUIREMENT__REGULATIONS:
				return regulations != null;
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
		result.append(" (safeSecond: ");
		result.append(safeSecond);
		result.append(", safezoneLength_default: ");
		result.append(safezoneLength_default);
		result.append(", safeFrontMin: ");
		result.append(safeFrontMin);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //Safety_RequirementImpl
