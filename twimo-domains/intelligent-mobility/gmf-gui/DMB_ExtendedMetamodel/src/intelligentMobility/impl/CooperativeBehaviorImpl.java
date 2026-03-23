/**
 */
package intelligentMobility.impl;

import intelligentMobility.CommunicationInterface;
import intelligentMobility.CooperativeBehavior;
import intelligentMobility.IntelligentMobilityPackage;
import intelligentMobility.Vehicle_Configuration;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Cooperative Behavior</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.impl.CooperativeBehaviorImpl#getDependsOn <em>Depends On</em>}</li>
 *   <li>{@link intelligentMobility.impl.CooperativeBehaviorImpl#getCoordinatedWith <em>Coordinated With</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CooperativeBehaviorImpl extends Driving_BehaviourImpl implements CooperativeBehavior {
	/**
	 * The cached value of the '{@link #getDependsOn() <em>Depends On</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDependsOn()
	 * @generated
	 * @ordered
	 */
	protected EList dependsOn;

	/**
	 * The cached value of the '{@link #getCoordinatedWith() <em>Coordinated With</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCoordinatedWith()
	 * @generated
	 * @ordered
	 */
	protected EList coordinatedWith;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CooperativeBehaviorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return IntelligentMobilityPackage.eINSTANCE.getCooperativeBehavior();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getDependsOn() {
		if (dependsOn == null) {
			dependsOn = new EObjectResolvingEList(CommunicationInterface.class, this, IntelligentMobilityPackage.COOPERATIVE_BEHAVIOR__DEPENDS_ON);
		}
		return dependsOn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getCoordinatedWith() {
		if (coordinatedWith == null) {
			coordinatedWith = new EObjectResolvingEList(Vehicle_Configuration.class, this, IntelligentMobilityPackage.COOPERATIVE_BEHAVIOR__COORDINATED_WITH);
		}
		return coordinatedWith;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IntelligentMobilityPackage.COOPERATIVE_BEHAVIOR__DEPENDS_ON:
				return getDependsOn();
			case IntelligentMobilityPackage.COOPERATIVE_BEHAVIOR__COORDINATED_WITH:
				return getCoordinatedWith();
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
			case IntelligentMobilityPackage.COOPERATIVE_BEHAVIOR__DEPENDS_ON:
				getDependsOn().clear();
				getDependsOn().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.COOPERATIVE_BEHAVIOR__COORDINATED_WITH:
				getCoordinatedWith().clear();
				getCoordinatedWith().addAll((Collection)newValue);
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
			case IntelligentMobilityPackage.COOPERATIVE_BEHAVIOR__DEPENDS_ON:
				getDependsOn().clear();
				return;
			case IntelligentMobilityPackage.COOPERATIVE_BEHAVIOR__COORDINATED_WITH:
				getCoordinatedWith().clear();
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
			case IntelligentMobilityPackage.COOPERATIVE_BEHAVIOR__DEPENDS_ON:
				return dependsOn != null && !dependsOn.isEmpty();
			case IntelligentMobilityPackage.COOPERATIVE_BEHAVIOR__COORDINATED_WITH:
				return coordinatedWith != null && !coordinatedWith.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //CooperativeBehaviorImpl
