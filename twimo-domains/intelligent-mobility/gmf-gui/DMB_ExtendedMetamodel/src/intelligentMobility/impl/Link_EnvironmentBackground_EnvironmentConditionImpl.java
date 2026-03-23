/**
 */
package intelligentMobility.impl;

import intelligentMobility.Environment_Background;
import intelligentMobility.Environment_Condition;
import intelligentMobility.IntelligentMobilityPackage;
import intelligentMobility.Link_EnvironmentBackground_EnvironmentCondition;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Link Environment Background Environment Condition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.impl.Link_EnvironmentBackground_EnvironmentConditionImpl#getName_link_background_condition <em>Name link background condition</em>}</li>
 *   <li>{@link intelligentMobility.impl.Link_EnvironmentBackground_EnvironmentConditionImpl#getLink_environment_background <em>Link environment background</em>}</li>
 *   <li>{@link intelligentMobility.impl.Link_EnvironmentBackground_EnvironmentConditionImpl#getLink_environment_condition <em>Link environment condition</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Link_EnvironmentBackground_EnvironmentConditionImpl extends MinimalEObjectImpl.Container implements Link_EnvironmentBackground_EnvironmentCondition {
	/**
	 * The default value of the '{@link #getName_link_background_condition() <em>Name link background condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName_link_background_condition()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_LINK_BACKGROUND_CONDITION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName_link_background_condition() <em>Name link background condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName_link_background_condition()
	 * @generated
	 * @ordered
	 */
	protected String name_link_background_condition = NAME_LINK_BACKGROUND_CONDITION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getLink_environment_background() <em>Link environment background</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_environment_background()
	 * @generated
	 * @ordered
	 */
	protected Environment_Background link_environment_background;

	/**
	 * The cached value of the '{@link #getLink_environment_condition() <em>Link environment condition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_environment_condition()
	 * @generated
	 * @ordered
	 */
	protected Environment_Condition link_environment_condition;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Link_EnvironmentBackground_EnvironmentConditionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return IntelligentMobilityPackage.eINSTANCE.getLink_EnvironmentBackground_EnvironmentCondition();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName_link_background_condition() {
		return name_link_background_condition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName_link_background_condition(String newName_link_background_condition) {
		String oldName_link_background_condition = name_link_background_condition;
		name_link_background_condition = newName_link_background_condition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_ENVIRONMENT_BACKGROUND_ENVIRONMENT_CONDITION__NAME_LINK_BACKGROUND_CONDITION, oldName_link_background_condition, name_link_background_condition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Environment_Background getLink_environment_background() {
		if (link_environment_background != null && link_environment_background.eIsProxy()) {
			InternalEObject oldLink_environment_background = (InternalEObject)link_environment_background;
			link_environment_background = (Environment_Background)eResolveProxy(oldLink_environment_background);
			if (link_environment_background != oldLink_environment_background) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LINK_ENVIRONMENT_BACKGROUND_ENVIRONMENT_CONDITION__LINK_ENVIRONMENT_BACKGROUND, oldLink_environment_background, link_environment_background));
			}
		}
		return link_environment_background;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Environment_Background basicGetLink_environment_background() {
		return link_environment_background;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLink_environment_background(Environment_Background newLink_environment_background) {
		Environment_Background oldLink_environment_background = link_environment_background;
		link_environment_background = newLink_environment_background;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_ENVIRONMENT_BACKGROUND_ENVIRONMENT_CONDITION__LINK_ENVIRONMENT_BACKGROUND, oldLink_environment_background, link_environment_background));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Environment_Condition getLink_environment_condition() {
		if (link_environment_condition != null && link_environment_condition.eIsProxy()) {
			InternalEObject oldLink_environment_condition = (InternalEObject)link_environment_condition;
			link_environment_condition = (Environment_Condition)eResolveProxy(oldLink_environment_condition);
			if (link_environment_condition != oldLink_environment_condition) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LINK_ENVIRONMENT_BACKGROUND_ENVIRONMENT_CONDITION__LINK_ENVIRONMENT_CONDITION, oldLink_environment_condition, link_environment_condition));
			}
		}
		return link_environment_condition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Environment_Condition basicGetLink_environment_condition() {
		return link_environment_condition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLink_environment_condition(Environment_Condition newLink_environment_condition) {
		Environment_Condition oldLink_environment_condition = link_environment_condition;
		link_environment_condition = newLink_environment_condition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_ENVIRONMENT_BACKGROUND_ENVIRONMENT_CONDITION__LINK_ENVIRONMENT_CONDITION, oldLink_environment_condition, link_environment_condition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IntelligentMobilityPackage.LINK_ENVIRONMENT_BACKGROUND_ENVIRONMENT_CONDITION__NAME_LINK_BACKGROUND_CONDITION:
				return getName_link_background_condition();
			case IntelligentMobilityPackage.LINK_ENVIRONMENT_BACKGROUND_ENVIRONMENT_CONDITION__LINK_ENVIRONMENT_BACKGROUND:
				if (resolve) return getLink_environment_background();
				return basicGetLink_environment_background();
			case IntelligentMobilityPackage.LINK_ENVIRONMENT_BACKGROUND_ENVIRONMENT_CONDITION__LINK_ENVIRONMENT_CONDITION:
				if (resolve) return getLink_environment_condition();
				return basicGetLink_environment_condition();
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
			case IntelligentMobilityPackage.LINK_ENVIRONMENT_BACKGROUND_ENVIRONMENT_CONDITION__NAME_LINK_BACKGROUND_CONDITION:
				setName_link_background_condition((String)newValue);
				return;
			case IntelligentMobilityPackage.LINK_ENVIRONMENT_BACKGROUND_ENVIRONMENT_CONDITION__LINK_ENVIRONMENT_BACKGROUND:
				setLink_environment_background((Environment_Background)newValue);
				return;
			case IntelligentMobilityPackage.LINK_ENVIRONMENT_BACKGROUND_ENVIRONMENT_CONDITION__LINK_ENVIRONMENT_CONDITION:
				setLink_environment_condition((Environment_Condition)newValue);
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
			case IntelligentMobilityPackage.LINK_ENVIRONMENT_BACKGROUND_ENVIRONMENT_CONDITION__NAME_LINK_BACKGROUND_CONDITION:
				setName_link_background_condition(NAME_LINK_BACKGROUND_CONDITION_EDEFAULT);
				return;
			case IntelligentMobilityPackage.LINK_ENVIRONMENT_BACKGROUND_ENVIRONMENT_CONDITION__LINK_ENVIRONMENT_BACKGROUND:
				setLink_environment_background((Environment_Background)null);
				return;
			case IntelligentMobilityPackage.LINK_ENVIRONMENT_BACKGROUND_ENVIRONMENT_CONDITION__LINK_ENVIRONMENT_CONDITION:
				setLink_environment_condition((Environment_Condition)null);
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
			case IntelligentMobilityPackage.LINK_ENVIRONMENT_BACKGROUND_ENVIRONMENT_CONDITION__NAME_LINK_BACKGROUND_CONDITION:
				return NAME_LINK_BACKGROUND_CONDITION_EDEFAULT == null ? name_link_background_condition != null : !NAME_LINK_BACKGROUND_CONDITION_EDEFAULT.equals(name_link_background_condition);
			case IntelligentMobilityPackage.LINK_ENVIRONMENT_BACKGROUND_ENVIRONMENT_CONDITION__LINK_ENVIRONMENT_BACKGROUND:
				return link_environment_background != null;
			case IntelligentMobilityPackage.LINK_ENVIRONMENT_BACKGROUND_ENVIRONMENT_CONDITION__LINK_ENVIRONMENT_CONDITION:
				return link_environment_condition != null;
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
		result.append(" (name_link_background_condition: ");
		result.append(name_link_background_condition);
		result.append(')');
		return result.toString();
	}

} //Link_EnvironmentBackground_EnvironmentConditionImpl
