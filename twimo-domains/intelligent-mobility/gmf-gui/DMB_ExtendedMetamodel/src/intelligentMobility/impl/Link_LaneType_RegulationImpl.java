/**
 */
package intelligentMobility.impl;

import intelligentMobility.IntelligentMobilityPackage;
import intelligentMobility.Lane_Type;
import intelligentMobility.Link_LaneType_Regulation;
import intelligentMobility.Regulation;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Link Lane Type Regulation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.impl.Link_LaneType_RegulationImpl#getName_link_laneType_regulation <em>Name link lane Type regulation</em>}</li>
 *   <li>{@link intelligentMobility.impl.Link_LaneType_RegulationImpl#getLink_laneType <em>Link lane Type</em>}</li>
 *   <li>{@link intelligentMobility.impl.Link_LaneType_RegulationImpl#getLink_regulation <em>Link regulation</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Link_LaneType_RegulationImpl extends MinimalEObjectImpl.Container implements Link_LaneType_Regulation {
	/**
	 * The default value of the '{@link #getName_link_laneType_regulation() <em>Name link lane Type regulation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName_link_laneType_regulation()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_LINK_LANE_TYPE_REGULATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName_link_laneType_regulation() <em>Name link lane Type regulation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName_link_laneType_regulation()
	 * @generated
	 * @ordered
	 */
	protected String name_link_laneType_regulation = NAME_LINK_LANE_TYPE_REGULATION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getLink_laneType() <em>Link lane Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_laneType()
	 * @generated
	 * @ordered
	 */
	protected Lane_Type link_laneType;

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
	protected Link_LaneType_RegulationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return IntelligentMobilityPackage.eINSTANCE.getLink_LaneType_Regulation();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName_link_laneType_regulation() {
		return name_link_laneType_regulation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName_link_laneType_regulation(String newName_link_laneType_regulation) {
		String oldName_link_laneType_regulation = name_link_laneType_regulation;
		name_link_laneType_regulation = newName_link_laneType_regulation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_LANE_TYPE_REGULATION__NAME_LINK_LANE_TYPE_REGULATION, oldName_link_laneType_regulation, name_link_laneType_regulation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Lane_Type getLink_laneType() {
		if (link_laneType != null && link_laneType.eIsProxy()) {
			InternalEObject oldLink_laneType = (InternalEObject)link_laneType;
			link_laneType = (Lane_Type)eResolveProxy(oldLink_laneType);
			if (link_laneType != oldLink_laneType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LINK_LANE_TYPE_REGULATION__LINK_LANE_TYPE, oldLink_laneType, link_laneType));
			}
		}
		return link_laneType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Lane_Type basicGetLink_laneType() {
		return link_laneType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLink_laneType(Lane_Type newLink_laneType) {
		Lane_Type oldLink_laneType = link_laneType;
		link_laneType = newLink_laneType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_LANE_TYPE_REGULATION__LINK_LANE_TYPE, oldLink_laneType, link_laneType));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LINK_LANE_TYPE_REGULATION__LINK_REGULATION, oldLink_regulation, link_regulation));
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
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_LANE_TYPE_REGULATION__LINK_REGULATION, oldLink_regulation, link_regulation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IntelligentMobilityPackage.LINK_LANE_TYPE_REGULATION__NAME_LINK_LANE_TYPE_REGULATION:
				return getName_link_laneType_regulation();
			case IntelligentMobilityPackage.LINK_LANE_TYPE_REGULATION__LINK_LANE_TYPE:
				if (resolve) return getLink_laneType();
				return basicGetLink_laneType();
			case IntelligentMobilityPackage.LINK_LANE_TYPE_REGULATION__LINK_REGULATION:
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
			case IntelligentMobilityPackage.LINK_LANE_TYPE_REGULATION__NAME_LINK_LANE_TYPE_REGULATION:
				setName_link_laneType_regulation((String)newValue);
				return;
			case IntelligentMobilityPackage.LINK_LANE_TYPE_REGULATION__LINK_LANE_TYPE:
				setLink_laneType((Lane_Type)newValue);
				return;
			case IntelligentMobilityPackage.LINK_LANE_TYPE_REGULATION__LINK_REGULATION:
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
			case IntelligentMobilityPackage.LINK_LANE_TYPE_REGULATION__NAME_LINK_LANE_TYPE_REGULATION:
				setName_link_laneType_regulation(NAME_LINK_LANE_TYPE_REGULATION_EDEFAULT);
				return;
			case IntelligentMobilityPackage.LINK_LANE_TYPE_REGULATION__LINK_LANE_TYPE:
				setLink_laneType((Lane_Type)null);
				return;
			case IntelligentMobilityPackage.LINK_LANE_TYPE_REGULATION__LINK_REGULATION:
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
			case IntelligentMobilityPackage.LINK_LANE_TYPE_REGULATION__NAME_LINK_LANE_TYPE_REGULATION:
				return NAME_LINK_LANE_TYPE_REGULATION_EDEFAULT == null ? name_link_laneType_regulation != null : !NAME_LINK_LANE_TYPE_REGULATION_EDEFAULT.equals(name_link_laneType_regulation);
			case IntelligentMobilityPackage.LINK_LANE_TYPE_REGULATION__LINK_LANE_TYPE:
				return link_laneType != null;
			case IntelligentMobilityPackage.LINK_LANE_TYPE_REGULATION__LINK_REGULATION:
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
		result.append(" (name_link_laneType_regulation: ");
		result.append(name_link_laneType_regulation);
		result.append(')');
		return result.toString();
	}

} //Link_LaneType_RegulationImpl
