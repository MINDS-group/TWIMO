/**
 */
package intelligentMobility.impl;

import intelligentMobility.Forward;
import intelligentMobility.IntelligentMobilityPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Forward</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.impl.ForwardImpl#getAcceleration <em>Acceleration</em>}</li>
 *   <li>{@link intelligentMobility.impl.ForwardImpl#getDeceleration <em>Deceleration</em>}</li>
 *   <li>{@link intelligentMobility.impl.ForwardImpl#getName <em>Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ForwardImpl extends ActionImpl implements Forward {
	/**
	 * The default value of the '{@link #getAcceleration() <em>Acceleration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAcceleration()
	 * @generated
	 * @ordered
	 */
	protected static final double ACCELERATION_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getAcceleration() <em>Acceleration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAcceleration()
	 * @generated
	 * @ordered
	 */
	protected double acceleration = ACCELERATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getDeceleration() <em>Deceleration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeceleration()
	 * @generated
	 * @ordered
	 */
	protected static final double DECELERATION_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getDeceleration() <em>Deceleration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeceleration()
	 * @generated
	 * @ordered
	 */
	protected double deceleration = DECELERATION_EDEFAULT;

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
	protected ForwardImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return IntelligentMobilityPackage.eINSTANCE.getForward();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getAcceleration() {
		return acceleration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAcceleration(double newAcceleration) {
		double oldAcceleration = acceleration;
		acceleration = newAcceleration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.FORWARD__ACCELERATION, oldAcceleration, acceleration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getDeceleration() {
		return deceleration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeceleration(double newDeceleration) {
		double oldDeceleration = deceleration;
		deceleration = newDeceleration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.FORWARD__DECELERATION, oldDeceleration, deceleration));
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
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.FORWARD__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IntelligentMobilityPackage.FORWARD__ACCELERATION:
				return new Double(getAcceleration());
			case IntelligentMobilityPackage.FORWARD__DECELERATION:
				return new Double(getDeceleration());
			case IntelligentMobilityPackage.FORWARD__NAME:
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
			case IntelligentMobilityPackage.FORWARD__ACCELERATION:
				setAcceleration(((Double)newValue).doubleValue());
				return;
			case IntelligentMobilityPackage.FORWARD__DECELERATION:
				setDeceleration(((Double)newValue).doubleValue());
				return;
			case IntelligentMobilityPackage.FORWARD__NAME:
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
			case IntelligentMobilityPackage.FORWARD__ACCELERATION:
				setAcceleration(ACCELERATION_EDEFAULT);
				return;
			case IntelligentMobilityPackage.FORWARD__DECELERATION:
				setDeceleration(DECELERATION_EDEFAULT);
				return;
			case IntelligentMobilityPackage.FORWARD__NAME:
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
			case IntelligentMobilityPackage.FORWARD__ACCELERATION:
				return acceleration != ACCELERATION_EDEFAULT;
			case IntelligentMobilityPackage.FORWARD__DECELERATION:
				return deceleration != DECELERATION_EDEFAULT;
			case IntelligentMobilityPackage.FORWARD__NAME:
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
		result.append(" (acceleration: ");
		result.append(acceleration);
		result.append(", deceleration: ");
		result.append(deceleration);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //ForwardImpl
