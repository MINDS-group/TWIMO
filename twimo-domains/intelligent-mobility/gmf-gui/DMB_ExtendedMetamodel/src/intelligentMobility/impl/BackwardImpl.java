/**
 */
package intelligentMobility.impl;

import intelligentMobility.Backward;
import intelligentMobility.IntelligentMobilityPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Backward</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.impl.BackwardImpl#getBackwardSpeed <em>Backward Speed</em>}</li>
 *   <li>{@link intelligentMobility.impl.BackwardImpl#getBackDistance <em>Back Distance</em>}</li>
 *   <li>{@link intelligentMobility.impl.BackwardImpl#getName <em>Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BackwardImpl extends ActionImpl implements Backward {
	/**
	 * The default value of the '{@link #getBackwardSpeed() <em>Backward Speed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBackwardSpeed()
	 * @generated
	 * @ordered
	 */
	protected static final double BACKWARD_SPEED_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getBackwardSpeed() <em>Backward Speed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBackwardSpeed()
	 * @generated
	 * @ordered
	 */
	protected double backwardSpeed = BACKWARD_SPEED_EDEFAULT;

	/**
	 * The default value of the '{@link #getBackDistance() <em>Back Distance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBackDistance()
	 * @generated
	 * @ordered
	 */
	protected static final double BACK_DISTANCE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getBackDistance() <em>Back Distance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBackDistance()
	 * @generated
	 * @ordered
	 */
	protected double backDistance = BACK_DISTANCE_EDEFAULT;

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
	protected BackwardImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return IntelligentMobilityPackage.eINSTANCE.getBackward();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getBackwardSpeed() {
		return backwardSpeed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBackwardSpeed(double newBackwardSpeed) {
		double oldBackwardSpeed = backwardSpeed;
		backwardSpeed = newBackwardSpeed;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.BACKWARD__BACKWARD_SPEED, oldBackwardSpeed, backwardSpeed));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getBackDistance() {
		return backDistance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBackDistance(double newBackDistance) {
		double oldBackDistance = backDistance;
		backDistance = newBackDistance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.BACKWARD__BACK_DISTANCE, oldBackDistance, backDistance));
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
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.BACKWARD__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IntelligentMobilityPackage.BACKWARD__BACKWARD_SPEED:
				return new Double(getBackwardSpeed());
			case IntelligentMobilityPackage.BACKWARD__BACK_DISTANCE:
				return new Double(getBackDistance());
			case IntelligentMobilityPackage.BACKWARD__NAME:
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
			case IntelligentMobilityPackage.BACKWARD__BACKWARD_SPEED:
				setBackwardSpeed(((Double)newValue).doubleValue());
				return;
			case IntelligentMobilityPackage.BACKWARD__BACK_DISTANCE:
				setBackDistance(((Double)newValue).doubleValue());
				return;
			case IntelligentMobilityPackage.BACKWARD__NAME:
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
			case IntelligentMobilityPackage.BACKWARD__BACKWARD_SPEED:
				setBackwardSpeed(BACKWARD_SPEED_EDEFAULT);
				return;
			case IntelligentMobilityPackage.BACKWARD__BACK_DISTANCE:
				setBackDistance(BACK_DISTANCE_EDEFAULT);
				return;
			case IntelligentMobilityPackage.BACKWARD__NAME:
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
			case IntelligentMobilityPackage.BACKWARD__BACKWARD_SPEED:
				return backwardSpeed != BACKWARD_SPEED_EDEFAULT;
			case IntelligentMobilityPackage.BACKWARD__BACK_DISTANCE:
				return backDistance != BACK_DISTANCE_EDEFAULT;
			case IntelligentMobilityPackage.BACKWARD__NAME:
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
		result.append(" (backwardSpeed: ");
		result.append(backwardSpeed);
		result.append(", backDistance: ");
		result.append(backDistance);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //BackwardImpl
