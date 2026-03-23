/**
 */
package intelligentMobility.impl;

import intelligentMobility.CommunicationInterface;
import intelligentMobility.Infrastructure;
import intelligentMobility.IntelligentMobilityPackage;
import intelligentMobility.Link_CommunicationInterface_Infrastructure;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Link Communication Interface Infrastructure</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.impl.Link_CommunicationInterface_InfrastructureImpl#getName_link_communication_interface_infrastructure <em>Name link communication interface infrastructure</em>}</li>
 *   <li>{@link intelligentMobility.impl.Link_CommunicationInterface_InfrastructureImpl#getLink_communicationInterface <em>Link communication Interface</em>}</li>
 *   <li>{@link intelligentMobility.impl.Link_CommunicationInterface_InfrastructureImpl#getLink_infrastructure <em>Link infrastructure</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Link_CommunicationInterface_InfrastructureImpl extends MinimalEObjectImpl.Container implements Link_CommunicationInterface_Infrastructure {
	/**
	 * The default value of the '{@link #getName_link_communication_interface_infrastructure() <em>Name link communication interface infrastructure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName_link_communication_interface_infrastructure()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_LINK_COMMUNICATION_INTERFACE_INFRASTRUCTURE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName_link_communication_interface_infrastructure() <em>Name link communication interface infrastructure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName_link_communication_interface_infrastructure()
	 * @generated
	 * @ordered
	 */
	protected String name_link_communication_interface_infrastructure = NAME_LINK_COMMUNICATION_INTERFACE_INFRASTRUCTURE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getLink_communicationInterface() <em>Link communication Interface</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_communicationInterface()
	 * @generated
	 * @ordered
	 */
	protected CommunicationInterface link_communicationInterface;

	/**
	 * The cached value of the '{@link #getLink_infrastructure() <em>Link infrastructure</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_infrastructure()
	 * @generated
	 * @ordered
	 */
	protected Infrastructure link_infrastructure;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Link_CommunicationInterface_InfrastructureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return IntelligentMobilityPackage.eINSTANCE.getLink_CommunicationInterface_Infrastructure();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName_link_communication_interface_infrastructure() {
		return name_link_communication_interface_infrastructure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName_link_communication_interface_infrastructure(String newName_link_communication_interface_infrastructure) {
		String oldName_link_communication_interface_infrastructure = name_link_communication_interface_infrastructure;
		name_link_communication_interface_infrastructure = newName_link_communication_interface_infrastructure;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_COMMUNICATION_INTERFACE_INFRASTRUCTURE__NAME_LINK_COMMUNICATION_INTERFACE_INFRASTRUCTURE, oldName_link_communication_interface_infrastructure, name_link_communication_interface_infrastructure));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CommunicationInterface getLink_communicationInterface() {
		if (link_communicationInterface != null && link_communicationInterface.eIsProxy()) {
			InternalEObject oldLink_communicationInterface = (InternalEObject)link_communicationInterface;
			link_communicationInterface = (CommunicationInterface)eResolveProxy(oldLink_communicationInterface);
			if (link_communicationInterface != oldLink_communicationInterface) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LINK_COMMUNICATION_INTERFACE_INFRASTRUCTURE__LINK_COMMUNICATION_INTERFACE, oldLink_communicationInterface, link_communicationInterface));
			}
		}
		return link_communicationInterface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CommunicationInterface basicGetLink_communicationInterface() {
		return link_communicationInterface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLink_communicationInterface(CommunicationInterface newLink_communicationInterface) {
		CommunicationInterface oldLink_communicationInterface = link_communicationInterface;
		link_communicationInterface = newLink_communicationInterface;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_COMMUNICATION_INTERFACE_INFRASTRUCTURE__LINK_COMMUNICATION_INTERFACE, oldLink_communicationInterface, link_communicationInterface));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Infrastructure getLink_infrastructure() {
		if (link_infrastructure != null && link_infrastructure.eIsProxy()) {
			InternalEObject oldLink_infrastructure = (InternalEObject)link_infrastructure;
			link_infrastructure = (Infrastructure)eResolveProxy(oldLink_infrastructure);
			if (link_infrastructure != oldLink_infrastructure) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LINK_COMMUNICATION_INTERFACE_INFRASTRUCTURE__LINK_INFRASTRUCTURE, oldLink_infrastructure, link_infrastructure));
			}
		}
		return link_infrastructure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Infrastructure basicGetLink_infrastructure() {
		return link_infrastructure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLink_infrastructure(Infrastructure newLink_infrastructure) {
		Infrastructure oldLink_infrastructure = link_infrastructure;
		link_infrastructure = newLink_infrastructure;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_COMMUNICATION_INTERFACE_INFRASTRUCTURE__LINK_INFRASTRUCTURE, oldLink_infrastructure, link_infrastructure));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IntelligentMobilityPackage.LINK_COMMUNICATION_INTERFACE_INFRASTRUCTURE__NAME_LINK_COMMUNICATION_INTERFACE_INFRASTRUCTURE:
				return getName_link_communication_interface_infrastructure();
			case IntelligentMobilityPackage.LINK_COMMUNICATION_INTERFACE_INFRASTRUCTURE__LINK_COMMUNICATION_INTERFACE:
				if (resolve) return getLink_communicationInterface();
				return basicGetLink_communicationInterface();
			case IntelligentMobilityPackage.LINK_COMMUNICATION_INTERFACE_INFRASTRUCTURE__LINK_INFRASTRUCTURE:
				if (resolve) return getLink_infrastructure();
				return basicGetLink_infrastructure();
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
			case IntelligentMobilityPackage.LINK_COMMUNICATION_INTERFACE_INFRASTRUCTURE__NAME_LINK_COMMUNICATION_INTERFACE_INFRASTRUCTURE:
				setName_link_communication_interface_infrastructure((String)newValue);
				return;
			case IntelligentMobilityPackage.LINK_COMMUNICATION_INTERFACE_INFRASTRUCTURE__LINK_COMMUNICATION_INTERFACE:
				setLink_communicationInterface((CommunicationInterface)newValue);
				return;
			case IntelligentMobilityPackage.LINK_COMMUNICATION_INTERFACE_INFRASTRUCTURE__LINK_INFRASTRUCTURE:
				setLink_infrastructure((Infrastructure)newValue);
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
			case IntelligentMobilityPackage.LINK_COMMUNICATION_INTERFACE_INFRASTRUCTURE__NAME_LINK_COMMUNICATION_INTERFACE_INFRASTRUCTURE:
				setName_link_communication_interface_infrastructure(NAME_LINK_COMMUNICATION_INTERFACE_INFRASTRUCTURE_EDEFAULT);
				return;
			case IntelligentMobilityPackage.LINK_COMMUNICATION_INTERFACE_INFRASTRUCTURE__LINK_COMMUNICATION_INTERFACE:
				setLink_communicationInterface((CommunicationInterface)null);
				return;
			case IntelligentMobilityPackage.LINK_COMMUNICATION_INTERFACE_INFRASTRUCTURE__LINK_INFRASTRUCTURE:
				setLink_infrastructure((Infrastructure)null);
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
			case IntelligentMobilityPackage.LINK_COMMUNICATION_INTERFACE_INFRASTRUCTURE__NAME_LINK_COMMUNICATION_INTERFACE_INFRASTRUCTURE:
				return NAME_LINK_COMMUNICATION_INTERFACE_INFRASTRUCTURE_EDEFAULT == null ? name_link_communication_interface_infrastructure != null : !NAME_LINK_COMMUNICATION_INTERFACE_INFRASTRUCTURE_EDEFAULT.equals(name_link_communication_interface_infrastructure);
			case IntelligentMobilityPackage.LINK_COMMUNICATION_INTERFACE_INFRASTRUCTURE__LINK_COMMUNICATION_INTERFACE:
				return link_communicationInterface != null;
			case IntelligentMobilityPackage.LINK_COMMUNICATION_INTERFACE_INFRASTRUCTURE__LINK_INFRASTRUCTURE:
				return link_infrastructure != null;
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
		result.append(" (name_link_communication_interface_infrastructure: ");
		result.append(name_link_communication_interface_infrastructure);
		result.append(')');
		return result.toString();
	}

} //Link_CommunicationInterface_InfrastructureImpl
