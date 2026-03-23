/**
 */
package intelligentMobility.impl;

import intelligentMobility.Infrastructure;
import intelligentMobility.IntelligentMobilityPackage;
import intelligentMobility.Vehicle_Configuration;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Infrastructure</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.impl.InfrastructureImpl#getCommunicatesWith <em>Communicates With</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class InfrastructureImpl extends MinimalEObjectImpl.Container implements Infrastructure {
	/**
	 * The cached value of the '{@link #getCommunicatesWith() <em>Communicates With</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommunicatesWith()
	 * @generated
	 * @ordered
	 */
	protected EList communicatesWith;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InfrastructureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return IntelligentMobilityPackage.eINSTANCE.getInfrastructure();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getCommunicatesWith() {
		if (communicatesWith == null) {
			communicatesWith = new EObjectWithInverseResolvingEList.ManyInverse(Vehicle_Configuration.class, this, IntelligentMobilityPackage.INFRASTRUCTURE__COMMUNICATES_WITH, IntelligentMobilityPackage.VEHICLE_CONFIGURATION__CONNECTED_INFRASTRUCTURE);
		}
		return communicatesWith;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case IntelligentMobilityPackage.INFRASTRUCTURE__COMMUNICATES_WITH:
				return ((InternalEList)getCommunicatesWith()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case IntelligentMobilityPackage.INFRASTRUCTURE__COMMUNICATES_WITH:
				return ((InternalEList)getCommunicatesWith()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IntelligentMobilityPackage.INFRASTRUCTURE__COMMUNICATES_WITH:
				return getCommunicatesWith();
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
			case IntelligentMobilityPackage.INFRASTRUCTURE__COMMUNICATES_WITH:
				getCommunicatesWith().clear();
				getCommunicatesWith().addAll((Collection)newValue);
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
			case IntelligentMobilityPackage.INFRASTRUCTURE__COMMUNICATES_WITH:
				getCommunicatesWith().clear();
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
			case IntelligentMobilityPackage.INFRASTRUCTURE__COMMUNICATES_WITH:
				return communicatesWith != null && !communicatesWith.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //InfrastructureImpl
