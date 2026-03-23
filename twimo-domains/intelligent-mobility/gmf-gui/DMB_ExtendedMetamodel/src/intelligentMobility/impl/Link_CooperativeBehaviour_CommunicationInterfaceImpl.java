/**
 */
package intelligentMobility.impl;

import intelligentMobility.CommunicationInterface;
import intelligentMobility.CooperativeBehavior;
import intelligentMobility.IntelligentMobilityPackage;
import intelligentMobility.Link_CooperativeBehaviour_CommunicationInterface;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Link Cooperative Behaviour Communication Interface</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.impl.Link_CooperativeBehaviour_CommunicationInterfaceImpl#getName_link_cooperativeBehaviour_communicationInterface <em>Name link cooperative Behaviour communication Interface</em>}</li>
 *   <li>{@link intelligentMobility.impl.Link_CooperativeBehaviour_CommunicationInterfaceImpl#getLink_cooperativeBehaviour <em>Link cooperative Behaviour</em>}</li>
 *   <li>{@link intelligentMobility.impl.Link_CooperativeBehaviour_CommunicationInterfaceImpl#getLink_communicationInterface <em>Link communication Interface</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Link_CooperativeBehaviour_CommunicationInterfaceImpl extends MinimalEObjectImpl.Container implements Link_CooperativeBehaviour_CommunicationInterface {
	/**
	 * The default value of the '{@link #getName_link_cooperativeBehaviour_communicationInterface() <em>Name link cooperative Behaviour communication Interface</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName_link_cooperativeBehaviour_communicationInterface()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_LINK_COOPERATIVE_BEHAVIOUR_COMMUNICATION_INTERFACE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName_link_cooperativeBehaviour_communicationInterface() <em>Name link cooperative Behaviour communication Interface</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName_link_cooperativeBehaviour_communicationInterface()
	 * @generated
	 * @ordered
	 */
	protected String name_link_cooperativeBehaviour_communicationInterface = NAME_LINK_COOPERATIVE_BEHAVIOUR_COMMUNICATION_INTERFACE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getLink_cooperativeBehaviour() <em>Link cooperative Behaviour</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_cooperativeBehaviour()
	 * @generated
	 * @ordered
	 */
	protected CooperativeBehavior link_cooperativeBehaviour;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Link_CooperativeBehaviour_CommunicationInterfaceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return IntelligentMobilityPackage.eINSTANCE.getLink_CooperativeBehaviour_CommunicationInterface();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName_link_cooperativeBehaviour_communicationInterface() {
		return name_link_cooperativeBehaviour_communicationInterface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName_link_cooperativeBehaviour_communicationInterface(String newName_link_cooperativeBehaviour_communicationInterface) {
		String oldName_link_cooperativeBehaviour_communicationInterface = name_link_cooperativeBehaviour_communicationInterface;
		name_link_cooperativeBehaviour_communicationInterface = newName_link_cooperativeBehaviour_communicationInterface;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_COOPERATIVE_BEHAVIOUR_COMMUNICATION_INTERFACE__NAME_LINK_COOPERATIVE_BEHAVIOUR_COMMUNICATION_INTERFACE, oldName_link_cooperativeBehaviour_communicationInterface, name_link_cooperativeBehaviour_communicationInterface));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CooperativeBehavior getLink_cooperativeBehaviour() {
		if (link_cooperativeBehaviour != null && link_cooperativeBehaviour.eIsProxy()) {
			InternalEObject oldLink_cooperativeBehaviour = (InternalEObject)link_cooperativeBehaviour;
			link_cooperativeBehaviour = (CooperativeBehavior)eResolveProxy(oldLink_cooperativeBehaviour);
			if (link_cooperativeBehaviour != oldLink_cooperativeBehaviour) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LINK_COOPERATIVE_BEHAVIOUR_COMMUNICATION_INTERFACE__LINK_COOPERATIVE_BEHAVIOUR, oldLink_cooperativeBehaviour, link_cooperativeBehaviour));
			}
		}
		return link_cooperativeBehaviour;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CooperativeBehavior basicGetLink_cooperativeBehaviour() {
		return link_cooperativeBehaviour;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLink_cooperativeBehaviour(CooperativeBehavior newLink_cooperativeBehaviour) {
		CooperativeBehavior oldLink_cooperativeBehaviour = link_cooperativeBehaviour;
		link_cooperativeBehaviour = newLink_cooperativeBehaviour;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_COOPERATIVE_BEHAVIOUR_COMMUNICATION_INTERFACE__LINK_COOPERATIVE_BEHAVIOUR, oldLink_cooperativeBehaviour, link_cooperativeBehaviour));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LINK_COOPERATIVE_BEHAVIOUR_COMMUNICATION_INTERFACE__LINK_COMMUNICATION_INTERFACE, oldLink_communicationInterface, link_communicationInterface));
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
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_COOPERATIVE_BEHAVIOUR_COMMUNICATION_INTERFACE__LINK_COMMUNICATION_INTERFACE, oldLink_communicationInterface, link_communicationInterface));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IntelligentMobilityPackage.LINK_COOPERATIVE_BEHAVIOUR_COMMUNICATION_INTERFACE__NAME_LINK_COOPERATIVE_BEHAVIOUR_COMMUNICATION_INTERFACE:
				return getName_link_cooperativeBehaviour_communicationInterface();
			case IntelligentMobilityPackage.LINK_COOPERATIVE_BEHAVIOUR_COMMUNICATION_INTERFACE__LINK_COOPERATIVE_BEHAVIOUR:
				if (resolve) return getLink_cooperativeBehaviour();
				return basicGetLink_cooperativeBehaviour();
			case IntelligentMobilityPackage.LINK_COOPERATIVE_BEHAVIOUR_COMMUNICATION_INTERFACE__LINK_COMMUNICATION_INTERFACE:
				if (resolve) return getLink_communicationInterface();
				return basicGetLink_communicationInterface();
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
			case IntelligentMobilityPackage.LINK_COOPERATIVE_BEHAVIOUR_COMMUNICATION_INTERFACE__NAME_LINK_COOPERATIVE_BEHAVIOUR_COMMUNICATION_INTERFACE:
				setName_link_cooperativeBehaviour_communicationInterface((String)newValue);
				return;
			case IntelligentMobilityPackage.LINK_COOPERATIVE_BEHAVIOUR_COMMUNICATION_INTERFACE__LINK_COOPERATIVE_BEHAVIOUR:
				setLink_cooperativeBehaviour((CooperativeBehavior)newValue);
				return;
			case IntelligentMobilityPackage.LINK_COOPERATIVE_BEHAVIOUR_COMMUNICATION_INTERFACE__LINK_COMMUNICATION_INTERFACE:
				setLink_communicationInterface((CommunicationInterface)newValue);
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
			case IntelligentMobilityPackage.LINK_COOPERATIVE_BEHAVIOUR_COMMUNICATION_INTERFACE__NAME_LINK_COOPERATIVE_BEHAVIOUR_COMMUNICATION_INTERFACE:
				setName_link_cooperativeBehaviour_communicationInterface(NAME_LINK_COOPERATIVE_BEHAVIOUR_COMMUNICATION_INTERFACE_EDEFAULT);
				return;
			case IntelligentMobilityPackage.LINK_COOPERATIVE_BEHAVIOUR_COMMUNICATION_INTERFACE__LINK_COOPERATIVE_BEHAVIOUR:
				setLink_cooperativeBehaviour((CooperativeBehavior)null);
				return;
			case IntelligentMobilityPackage.LINK_COOPERATIVE_BEHAVIOUR_COMMUNICATION_INTERFACE__LINK_COMMUNICATION_INTERFACE:
				setLink_communicationInterface((CommunicationInterface)null);
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
			case IntelligentMobilityPackage.LINK_COOPERATIVE_BEHAVIOUR_COMMUNICATION_INTERFACE__NAME_LINK_COOPERATIVE_BEHAVIOUR_COMMUNICATION_INTERFACE:
				return NAME_LINK_COOPERATIVE_BEHAVIOUR_COMMUNICATION_INTERFACE_EDEFAULT == null ? name_link_cooperativeBehaviour_communicationInterface != null : !NAME_LINK_COOPERATIVE_BEHAVIOUR_COMMUNICATION_INTERFACE_EDEFAULT.equals(name_link_cooperativeBehaviour_communicationInterface);
			case IntelligentMobilityPackage.LINK_COOPERATIVE_BEHAVIOUR_COMMUNICATION_INTERFACE__LINK_COOPERATIVE_BEHAVIOUR:
				return link_cooperativeBehaviour != null;
			case IntelligentMobilityPackage.LINK_COOPERATIVE_BEHAVIOUR_COMMUNICATION_INTERFACE__LINK_COMMUNICATION_INTERFACE:
				return link_communicationInterface != null;
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
		result.append(" (name_link_cooperativeBehaviour_communicationInterface: ");
		result.append(name_link_cooperativeBehaviour_communicationInterface);
		result.append(')');
		return result.toString();
	}

} //Link_CooperativeBehaviour_CommunicationInterfaceImpl
