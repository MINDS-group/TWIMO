/**
 */
package intelligentMobility.impl;

import intelligentMobility.Environment_Condition;
import intelligentMobility.IntelligentMobilityPackage;
import intelligentMobility.Link_EnvironmentCondition_Regulations;
import intelligentMobility.Regulation;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Link Environment Condition Regulations</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.impl.Link_EnvironmentCondition_RegulationsImpl#getName_link_environmentCondition_regulation <em>Name link environment Condition regulation</em>}</li>
 *   <li>{@link intelligentMobility.impl.Link_EnvironmentCondition_RegulationsImpl#getLink_environmentCondition <em>Link environment Condition</em>}</li>
 *   <li>{@link intelligentMobility.impl.Link_EnvironmentCondition_RegulationsImpl#getLink_regulation <em>Link regulation</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Link_EnvironmentCondition_RegulationsImpl extends MinimalEObjectImpl.Container implements Link_EnvironmentCondition_Regulations {
	/**
	 * The default value of the '{@link #getName_link_environmentCondition_regulation() <em>Name link environment Condition regulation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName_link_environmentCondition_regulation()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_LINK_ENVIRONMENT_CONDITION_REGULATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName_link_environmentCondition_regulation() <em>Name link environment Condition regulation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName_link_environmentCondition_regulation()
	 * @generated
	 * @ordered
	 */
	protected String name_link_environmentCondition_regulation = NAME_LINK_ENVIRONMENT_CONDITION_REGULATION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getLink_environmentCondition() <em>Link environment Condition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_environmentCondition()
	 * @generated
	 * @ordered
	 */
	protected Environment_Condition link_environmentCondition;

	/**
	 * The cached value of the '{@link #getLink_regulation() <em>Link regulation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_regulation()
	 * @generated
	 * @ordered
	 */
	protected Regulation link_regulation;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Link_EnvironmentCondition_RegulationsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return IntelligentMobilityPackage.eINSTANCE.getLink_EnvironmentCondition_Regulations();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName_link_environmentCondition_regulation() {
		return name_link_environmentCondition_regulation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName_link_environmentCondition_regulation(String newName_link_environmentCondition_regulation) {
		String oldName_link_environmentCondition_regulation = name_link_environmentCondition_regulation;
		name_link_environmentCondition_regulation = newName_link_environmentCondition_regulation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_ENVIRONMENT_CONDITION_REGULATIONS__NAME_LINK_ENVIRONMENT_CONDITION_REGULATION, oldName_link_environmentCondition_regulation, name_link_environmentCondition_regulation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Environment_Condition getLink_environmentCondition() {
		if (link_environmentCondition != null && link_environmentCondition.eIsProxy()) {
			InternalEObject oldLink_environmentCondition = (InternalEObject)link_environmentCondition;
			link_environmentCondition = (Environment_Condition)eResolveProxy(oldLink_environmentCondition);
			if (link_environmentCondition != oldLink_environmentCondition) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LINK_ENVIRONMENT_CONDITION_REGULATIONS__LINK_ENVIRONMENT_CONDITION, oldLink_environmentCondition, link_environmentCondition));
			}
		}
		return link_environmentCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Environment_Condition basicGetLink_environmentCondition() {
		return link_environmentCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLink_environmentCondition(Environment_Condition newLink_environmentCondition) {
		Environment_Condition oldLink_environmentCondition = link_environmentCondition;
		link_environmentCondition = newLink_environmentCondition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_ENVIRONMENT_CONDITION_REGULATIONS__LINK_ENVIRONMENT_CONDITION, oldLink_environmentCondition, link_environmentCondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Regulation getLink_regulation() {
		if (link_regulation != null && link_regulation.eIsProxy()) {
			InternalEObject oldLink_regulation = (InternalEObject)link_regulation;
			link_regulation = (Regulation)eResolveProxy(oldLink_regulation);
			if (link_regulation != oldLink_regulation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LINK_ENVIRONMENT_CONDITION_REGULATIONS__LINK_REGULATION, oldLink_regulation, link_regulation));
			}
		}
		return link_regulation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Regulation basicGetLink_regulation() {
		return link_regulation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLink_regulation(Regulation newLink_regulation) {
		Regulation oldLink_regulation = link_regulation;
		link_regulation = newLink_regulation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_ENVIRONMENT_CONDITION_REGULATIONS__LINK_REGULATION, oldLink_regulation, link_regulation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IntelligentMobilityPackage.LINK_ENVIRONMENT_CONDITION_REGULATIONS__NAME_LINK_ENVIRONMENT_CONDITION_REGULATION:
				return getName_link_environmentCondition_regulation();
			case IntelligentMobilityPackage.LINK_ENVIRONMENT_CONDITION_REGULATIONS__LINK_ENVIRONMENT_CONDITION:
				if (resolve) return getLink_environmentCondition();
				return basicGetLink_environmentCondition();
			case IntelligentMobilityPackage.LINK_ENVIRONMENT_CONDITION_REGULATIONS__LINK_REGULATION:
				if (resolve) return getLink_regulation();
				return basicGetLink_regulation();
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
			case IntelligentMobilityPackage.LINK_ENVIRONMENT_CONDITION_REGULATIONS__NAME_LINK_ENVIRONMENT_CONDITION_REGULATION:
				setName_link_environmentCondition_regulation((String)newValue);
				return;
			case IntelligentMobilityPackage.LINK_ENVIRONMENT_CONDITION_REGULATIONS__LINK_ENVIRONMENT_CONDITION:
				setLink_environmentCondition((Environment_Condition)newValue);
				return;
			case IntelligentMobilityPackage.LINK_ENVIRONMENT_CONDITION_REGULATIONS__LINK_REGULATION:
				setLink_regulation((Regulation)newValue);
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
			case IntelligentMobilityPackage.LINK_ENVIRONMENT_CONDITION_REGULATIONS__NAME_LINK_ENVIRONMENT_CONDITION_REGULATION:
				setName_link_environmentCondition_regulation(NAME_LINK_ENVIRONMENT_CONDITION_REGULATION_EDEFAULT);
				return;
			case IntelligentMobilityPackage.LINK_ENVIRONMENT_CONDITION_REGULATIONS__LINK_ENVIRONMENT_CONDITION:
				setLink_environmentCondition((Environment_Condition)null);
				return;
			case IntelligentMobilityPackage.LINK_ENVIRONMENT_CONDITION_REGULATIONS__LINK_REGULATION:
				setLink_regulation((Regulation)null);
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
			case IntelligentMobilityPackage.LINK_ENVIRONMENT_CONDITION_REGULATIONS__NAME_LINK_ENVIRONMENT_CONDITION_REGULATION:
				return NAME_LINK_ENVIRONMENT_CONDITION_REGULATION_EDEFAULT == null ? name_link_environmentCondition_regulation != null : !NAME_LINK_ENVIRONMENT_CONDITION_REGULATION_EDEFAULT.equals(name_link_environmentCondition_regulation);
			case IntelligentMobilityPackage.LINK_ENVIRONMENT_CONDITION_REGULATIONS__LINK_ENVIRONMENT_CONDITION:
				return link_environmentCondition != null;
			case IntelligentMobilityPackage.LINK_ENVIRONMENT_CONDITION_REGULATIONS__LINK_REGULATION:
				return link_regulation != null;
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
		result.append(" (name_link_environmentCondition_regulation: ");
		result.append(name_link_environmentCondition_regulation);
		result.append(')');
		return result.toString();
	}

} //Link_EnvironmentCondition_RegulationsImpl
