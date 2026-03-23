/**
 */
package intelligentMobility.impl;

import intelligentMobility.IntelligentMobilityPackage;
import intelligentMobility.Obstruction;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Obstruction</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.impl.ObstructionImpl#getName <em>Name</em>}</li>
 *   <li>{@link intelligentMobility.impl.ObstructionImpl#getObstacleLocationX <em>Obstacle Location X</em>}</li>
 *   <li>{@link intelligentMobility.impl.ObstructionImpl#getObstacleLocationY <em>Obstacle Location Y</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ObstructionImpl extends MinimalEObjectImpl.Container implements Obstruction {
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
	 * The default value of the '{@link #getObstacleLocationX() <em>Obstacle Location X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObstacleLocationX()
	 * @generated
	 * @ordered
	 */
	protected static final double OBSTACLE_LOCATION_X_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getObstacleLocationX() <em>Obstacle Location X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObstacleLocationX()
	 * @generated
	 * @ordered
	 */
	protected double obstacleLocationX = OBSTACLE_LOCATION_X_EDEFAULT;

	/**
	 * The default value of the '{@link #getObstacleLocationY() <em>Obstacle Location Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObstacleLocationY()
	 * @generated
	 * @ordered
	 */
	protected static final double OBSTACLE_LOCATION_Y_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getObstacleLocationY() <em>Obstacle Location Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObstacleLocationY()
	 * @generated
	 * @ordered
	 */
	protected double obstacleLocationY = OBSTACLE_LOCATION_Y_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ObstructionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return IntelligentMobilityPackage.eINSTANCE.getObstruction();
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
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.OBSTRUCTION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getObstacleLocationX() {
		return obstacleLocationX;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setObstacleLocationX(double newObstacleLocationX) {
		double oldObstacleLocationX = obstacleLocationX;
		obstacleLocationX = newObstacleLocationX;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.OBSTRUCTION__OBSTACLE_LOCATION_X, oldObstacleLocationX, obstacleLocationX));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getObstacleLocationY() {
		return obstacleLocationY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setObstacleLocationY(double newObstacleLocationY) {
		double oldObstacleLocationY = obstacleLocationY;
		obstacleLocationY = newObstacleLocationY;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.OBSTRUCTION__OBSTACLE_LOCATION_Y, oldObstacleLocationY, obstacleLocationY));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IntelligentMobilityPackage.OBSTRUCTION__NAME:
				return getName();
			case IntelligentMobilityPackage.OBSTRUCTION__OBSTACLE_LOCATION_X:
				return new Double(getObstacleLocationX());
			case IntelligentMobilityPackage.OBSTRUCTION__OBSTACLE_LOCATION_Y:
				return new Double(getObstacleLocationY());
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
			case IntelligentMobilityPackage.OBSTRUCTION__NAME:
				setName((String)newValue);
				return;
			case IntelligentMobilityPackage.OBSTRUCTION__OBSTACLE_LOCATION_X:
				setObstacleLocationX(((Double)newValue).doubleValue());
				return;
			case IntelligentMobilityPackage.OBSTRUCTION__OBSTACLE_LOCATION_Y:
				setObstacleLocationY(((Double)newValue).doubleValue());
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
			case IntelligentMobilityPackage.OBSTRUCTION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case IntelligentMobilityPackage.OBSTRUCTION__OBSTACLE_LOCATION_X:
				setObstacleLocationX(OBSTACLE_LOCATION_X_EDEFAULT);
				return;
			case IntelligentMobilityPackage.OBSTRUCTION__OBSTACLE_LOCATION_Y:
				setObstacleLocationY(OBSTACLE_LOCATION_Y_EDEFAULT);
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
			case IntelligentMobilityPackage.OBSTRUCTION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case IntelligentMobilityPackage.OBSTRUCTION__OBSTACLE_LOCATION_X:
				return obstacleLocationX != OBSTACLE_LOCATION_X_EDEFAULT;
			case IntelligentMobilityPackage.OBSTRUCTION__OBSTACLE_LOCATION_Y:
				return obstacleLocationY != OBSTACLE_LOCATION_Y_EDEFAULT;
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
		result.append(", obstacleLocationX: ");
		result.append(obstacleLocationX);
		result.append(", obstacleLocationY: ");
		result.append(obstacleLocationY);
		result.append(')');
		return result.toString();
	}

} //ObstructionImpl
