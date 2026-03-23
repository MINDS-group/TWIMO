/**
 */
package intelligentMobility.impl;

import intelligentMobility.GapAcceptance;
import intelligentMobility.IntelligentMobilityPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Gap Acceptance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.impl.GapAcceptanceImpl#getLagGap <em>Lag Gap</em>}</li>
 *   <li>{@link intelligentMobility.impl.GapAcceptanceImpl#getLeadGap <em>Lead Gap</em>}</li>
 *   <li>{@link intelligentMobility.impl.GapAcceptanceImpl#getName <em>Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GapAcceptanceImpl extends MinimalEObjectImpl.Container implements GapAcceptance {
	/**
	 * The default value of the '{@link #getLagGap() <em>Lag Gap</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLagGap()
	 * @generated
	 * @ordered
	 */
	protected static final double LAG_GAP_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getLagGap() <em>Lag Gap</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLagGap()
	 * @generated
	 * @ordered
	 */
	protected double lagGap = LAG_GAP_EDEFAULT;

	/**
	 * The default value of the '{@link #getLeadGap() <em>Lead Gap</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLeadGap()
	 * @generated
	 * @ordered
	 */
	protected static final double LEAD_GAP_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getLeadGap() <em>Lead Gap</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLeadGap()
	 * @generated
	 * @ordered
	 */
	protected double leadGap = LEAD_GAP_EDEFAULT;

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
	protected GapAcceptanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return IntelligentMobilityPackage.eINSTANCE.getGapAcceptance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getLagGap() {
		return lagGap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLagGap(double newLagGap) {
		double oldLagGap = lagGap;
		lagGap = newLagGap;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.GAP_ACCEPTANCE__LAG_GAP, oldLagGap, lagGap));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getLeadGap() {
		return leadGap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLeadGap(double newLeadGap) {
		double oldLeadGap = leadGap;
		leadGap = newLeadGap;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.GAP_ACCEPTANCE__LEAD_GAP, oldLeadGap, leadGap));
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
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.GAP_ACCEPTANCE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IntelligentMobilityPackage.GAP_ACCEPTANCE__LAG_GAP:
				return new Double(getLagGap());
			case IntelligentMobilityPackage.GAP_ACCEPTANCE__LEAD_GAP:
				return new Double(getLeadGap());
			case IntelligentMobilityPackage.GAP_ACCEPTANCE__NAME:
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
			case IntelligentMobilityPackage.GAP_ACCEPTANCE__LAG_GAP:
				setLagGap(((Double)newValue).doubleValue());
				return;
			case IntelligentMobilityPackage.GAP_ACCEPTANCE__LEAD_GAP:
				setLeadGap(((Double)newValue).doubleValue());
				return;
			case IntelligentMobilityPackage.GAP_ACCEPTANCE__NAME:
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
			case IntelligentMobilityPackage.GAP_ACCEPTANCE__LAG_GAP:
				setLagGap(LAG_GAP_EDEFAULT);
				return;
			case IntelligentMobilityPackage.GAP_ACCEPTANCE__LEAD_GAP:
				setLeadGap(LEAD_GAP_EDEFAULT);
				return;
			case IntelligentMobilityPackage.GAP_ACCEPTANCE__NAME:
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
			case IntelligentMobilityPackage.GAP_ACCEPTANCE__LAG_GAP:
				return lagGap != LAG_GAP_EDEFAULT;
			case IntelligentMobilityPackage.GAP_ACCEPTANCE__LEAD_GAP:
				return leadGap != LEAD_GAP_EDEFAULT;
			case IntelligentMobilityPackage.GAP_ACCEPTANCE__NAME:
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
		result.append(" (lagGap: ");
		result.append(lagGap);
		result.append(", leadGap: ");
		result.append(leadGap);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //GapAcceptanceImpl
