/**
 */
package intelligentMobility.impl;

import intelligentMobility.Environment_Background;
import intelligentMobility.IntelligentMobilityPackage;
import intelligentMobility.Link_EnvironmentBackground_PossibleVehicle;
import intelligentMobility.PossibleVehicle;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Link Environment Background Possible Vehicle</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.impl.Link_EnvironmentBackground_PossibleVehicleImpl#getName_link_background_possibleVehicle <em>Name link background possible Vehicle</em>}</li>
 *   <li>{@link intelligentMobility.impl.Link_EnvironmentBackground_PossibleVehicleImpl#getLink_environment_background <em>Link environment background</em>}</li>
 *   <li>{@link intelligentMobility.impl.Link_EnvironmentBackground_PossibleVehicleImpl#getLink_possible_vehicle <em>Link possible vehicle</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Link_EnvironmentBackground_PossibleVehicleImpl extends MinimalEObjectImpl.Container implements Link_EnvironmentBackground_PossibleVehicle {
	/**
	 * The default value of the '{@link #getName_link_background_possibleVehicle() <em>Name link background possible Vehicle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName_link_background_possibleVehicle()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_LINK_BACKGROUND_POSSIBLE_VEHICLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName_link_background_possibleVehicle() <em>Name link background possible Vehicle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName_link_background_possibleVehicle()
	 * @generated
	 * @ordered
	 */
	protected String name_link_background_possibleVehicle = NAME_LINK_BACKGROUND_POSSIBLE_VEHICLE_EDEFAULT;

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
	 * The cached value of the '{@link #getLink_possible_vehicle() <em>Link possible vehicle</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_possible_vehicle()
	 * @generated
	 * @ordered
	 */
	protected PossibleVehicle link_possible_vehicle;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Link_EnvironmentBackground_PossibleVehicleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return IntelligentMobilityPackage.eINSTANCE.getLink_EnvironmentBackground_PossibleVehicle();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName_link_background_possibleVehicle() {
		return name_link_background_possibleVehicle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName_link_background_possibleVehicle(String newName_link_background_possibleVehicle) {
		String oldName_link_background_possibleVehicle = name_link_background_possibleVehicle;
		name_link_background_possibleVehicle = newName_link_background_possibleVehicle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_ENVIRONMENT_BACKGROUND_POSSIBLE_VEHICLE__NAME_LINK_BACKGROUND_POSSIBLE_VEHICLE, oldName_link_background_possibleVehicle, name_link_background_possibleVehicle));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LINK_ENVIRONMENT_BACKGROUND_POSSIBLE_VEHICLE__LINK_ENVIRONMENT_BACKGROUND, oldLink_environment_background, link_environment_background));
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
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_ENVIRONMENT_BACKGROUND_POSSIBLE_VEHICLE__LINK_ENVIRONMENT_BACKGROUND, oldLink_environment_background, link_environment_background));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PossibleVehicle getLink_possible_vehicle() {
		if (link_possible_vehicle != null && link_possible_vehicle.eIsProxy()) {
			InternalEObject oldLink_possible_vehicle = (InternalEObject)link_possible_vehicle;
			link_possible_vehicle = (PossibleVehicle)eResolveProxy(oldLink_possible_vehicle);
			if (link_possible_vehicle != oldLink_possible_vehicle) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LINK_ENVIRONMENT_BACKGROUND_POSSIBLE_VEHICLE__LINK_POSSIBLE_VEHICLE, oldLink_possible_vehicle, link_possible_vehicle));
			}
		}
		return link_possible_vehicle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PossibleVehicle basicGetLink_possible_vehicle() {
		return link_possible_vehicle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLink_possible_vehicle(PossibleVehicle newLink_possible_vehicle) {
		PossibleVehicle oldLink_possible_vehicle = link_possible_vehicle;
		link_possible_vehicle = newLink_possible_vehicle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_ENVIRONMENT_BACKGROUND_POSSIBLE_VEHICLE__LINK_POSSIBLE_VEHICLE, oldLink_possible_vehicle, link_possible_vehicle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IntelligentMobilityPackage.LINK_ENVIRONMENT_BACKGROUND_POSSIBLE_VEHICLE__NAME_LINK_BACKGROUND_POSSIBLE_VEHICLE:
				return getName_link_background_possibleVehicle();
			case IntelligentMobilityPackage.LINK_ENVIRONMENT_BACKGROUND_POSSIBLE_VEHICLE__LINK_ENVIRONMENT_BACKGROUND:
				if (resolve) return getLink_environment_background();
				return basicGetLink_environment_background();
			case IntelligentMobilityPackage.LINK_ENVIRONMENT_BACKGROUND_POSSIBLE_VEHICLE__LINK_POSSIBLE_VEHICLE:
				if (resolve) return getLink_possible_vehicle();
				return basicGetLink_possible_vehicle();
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
			case IntelligentMobilityPackage.LINK_ENVIRONMENT_BACKGROUND_POSSIBLE_VEHICLE__NAME_LINK_BACKGROUND_POSSIBLE_VEHICLE:
				setName_link_background_possibleVehicle((String)newValue);
				return;
			case IntelligentMobilityPackage.LINK_ENVIRONMENT_BACKGROUND_POSSIBLE_VEHICLE__LINK_ENVIRONMENT_BACKGROUND:
				setLink_environment_background((Environment_Background)newValue);
				return;
			case IntelligentMobilityPackage.LINK_ENVIRONMENT_BACKGROUND_POSSIBLE_VEHICLE__LINK_POSSIBLE_VEHICLE:
				setLink_possible_vehicle((PossibleVehicle)newValue);
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
			case IntelligentMobilityPackage.LINK_ENVIRONMENT_BACKGROUND_POSSIBLE_VEHICLE__NAME_LINK_BACKGROUND_POSSIBLE_VEHICLE:
				setName_link_background_possibleVehicle(NAME_LINK_BACKGROUND_POSSIBLE_VEHICLE_EDEFAULT);
				return;
			case IntelligentMobilityPackage.LINK_ENVIRONMENT_BACKGROUND_POSSIBLE_VEHICLE__LINK_ENVIRONMENT_BACKGROUND:
				setLink_environment_background((Environment_Background)null);
				return;
			case IntelligentMobilityPackage.LINK_ENVIRONMENT_BACKGROUND_POSSIBLE_VEHICLE__LINK_POSSIBLE_VEHICLE:
				setLink_possible_vehicle((PossibleVehicle)null);
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
			case IntelligentMobilityPackage.LINK_ENVIRONMENT_BACKGROUND_POSSIBLE_VEHICLE__NAME_LINK_BACKGROUND_POSSIBLE_VEHICLE:
				return NAME_LINK_BACKGROUND_POSSIBLE_VEHICLE_EDEFAULT == null ? name_link_background_possibleVehicle != null : !NAME_LINK_BACKGROUND_POSSIBLE_VEHICLE_EDEFAULT.equals(name_link_background_possibleVehicle);
			case IntelligentMobilityPackage.LINK_ENVIRONMENT_BACKGROUND_POSSIBLE_VEHICLE__LINK_ENVIRONMENT_BACKGROUND:
				return link_environment_background != null;
			case IntelligentMobilityPackage.LINK_ENVIRONMENT_BACKGROUND_POSSIBLE_VEHICLE__LINK_POSSIBLE_VEHICLE:
				return link_possible_vehicle != null;
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
		result.append(" (name_link_background_possibleVehicle: ");
		result.append(name_link_background_possibleVehicle);
		result.append(')');
		return result.toString();
	}

} //Link_EnvironmentBackground_PossibleVehicleImpl
