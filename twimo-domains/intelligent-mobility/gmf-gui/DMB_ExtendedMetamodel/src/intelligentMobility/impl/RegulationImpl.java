/**
 */
package intelligentMobility.impl;

import intelligentMobility.IntelligentMobilityPackage;
import intelligentMobility.Regulation;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Regulation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.impl.RegulationImpl#getLegislation <em>Legislation</em>}</li>
 *   <li>{@link intelligentMobility.impl.RegulationImpl#getCourtesy <em>Courtesy</em>}</li>
 *   <li>{@link intelligentMobility.impl.RegulationImpl#getName <em>Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RegulationImpl extends MinimalEObjectImpl.Container implements Regulation {
	/**
	 * The default value of the '{@link #getLegislation() <em>Legislation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLegislation()
	 * @generated
	 * @ordered
	 */
	protected static final String LEGISLATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLegislation() <em>Legislation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLegislation()
	 * @generated
	 * @ordered
	 */
	protected String legislation = LEGISLATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getCourtesy() <em>Courtesy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCourtesy()
	 * @generated
	 * @ordered
	 */
	protected static final String COURTESY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCourtesy() <em>Courtesy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCourtesy()
	 * @generated
	 * @ordered
	 */
	protected String courtesy = COURTESY_EDEFAULT;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RegulationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return IntelligentMobilityPackage.eINSTANCE.getRegulation();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLegislation() {
		return legislation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLegislation(String newLegislation) {
		String oldLegislation = legislation;
		legislation = newLegislation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.REGULATION__LEGISLATION, oldLegislation, legislation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCourtesy() {
		return courtesy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCourtesy(String newCourtesy) {
		String oldCourtesy = courtesy;
		courtesy = newCourtesy;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.REGULATION__COURTESY, oldCourtesy, courtesy));
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
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.REGULATION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IntelligentMobilityPackage.REGULATION__LEGISLATION:
				return getLegislation();
			case IntelligentMobilityPackage.REGULATION__COURTESY:
				return getCourtesy();
			case IntelligentMobilityPackage.REGULATION__NAME:
				return getName();
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
			case IntelligentMobilityPackage.REGULATION__LEGISLATION:
				setLegislation((String)newValue);
				return;
			case IntelligentMobilityPackage.REGULATION__COURTESY:
				setCourtesy((String)newValue);
				return;
			case IntelligentMobilityPackage.REGULATION__NAME:
				setName((String)newValue);
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
			case IntelligentMobilityPackage.REGULATION__LEGISLATION:
				setLegislation(LEGISLATION_EDEFAULT);
				return;
			case IntelligentMobilityPackage.REGULATION__COURTESY:
				setCourtesy(COURTESY_EDEFAULT);
				return;
			case IntelligentMobilityPackage.REGULATION__NAME:
				setName(NAME_EDEFAULT);
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
			case IntelligentMobilityPackage.REGULATION__LEGISLATION:
				return LEGISLATION_EDEFAULT == null ? legislation != null : !LEGISLATION_EDEFAULT.equals(legislation);
			case IntelligentMobilityPackage.REGULATION__COURTESY:
				return COURTESY_EDEFAULT == null ? courtesy != null : !COURTESY_EDEFAULT.equals(courtesy);
			case IntelligentMobilityPackage.REGULATION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
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
		result.append(" (legislation: ");
		result.append(legislation);
		result.append(", courtesy: ");
		result.append(courtesy);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //RegulationImpl
