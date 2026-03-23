/**
 */
package intelligentMobility.impl;

import intelligentMobility.GapAcceptance;
import intelligentMobility.IntelligentMobilityPackage;
import intelligentMobility.LaneChanging;
import intelligentMobility.Link_LaneChanging_GapAcceptance;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Link Lane Changing Gap Acceptance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.impl.Link_LaneChanging_GapAcceptanceImpl#getName_link_laneChanging_gapAcceptane <em>Name link lane Changing gap Acceptane</em>}</li>
 *   <li>{@link intelligentMobility.impl.Link_LaneChanging_GapAcceptanceImpl#getLink_laneChanging <em>Link lane Changing</em>}</li>
 *   <li>{@link intelligentMobility.impl.Link_LaneChanging_GapAcceptanceImpl#getLink_gapAcceptance <em>Link gap Acceptance</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Link_LaneChanging_GapAcceptanceImpl extends MinimalEObjectImpl.Container implements Link_LaneChanging_GapAcceptance {
	/**
	 * The default value of the '{@link #getName_link_laneChanging_gapAcceptane() <em>Name link lane Changing gap Acceptane</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName_link_laneChanging_gapAcceptane()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_LINK_LANE_CHANGING_GAP_ACCEPTANE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName_link_laneChanging_gapAcceptane() <em>Name link lane Changing gap Acceptane</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName_link_laneChanging_gapAcceptane()
	 * @generated
	 * @ordered
	 */
	protected String name_link_laneChanging_gapAcceptane = NAME_LINK_LANE_CHANGING_GAP_ACCEPTANE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getLink_laneChanging() <em>Link lane Changing</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_laneChanging()
	 * @generated
	 * @ordered
	 */
	protected LaneChanging link_laneChanging;

	/**
	 * The cached value of the '{@link #getLink_gapAcceptance() <em>Link gap Acceptance</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_gapAcceptance()
	 * @generated
	 * @ordered
	 */
	protected GapAcceptance link_gapAcceptance;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Link_LaneChanging_GapAcceptanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return IntelligentMobilityPackage.eINSTANCE.getLink_LaneChanging_GapAcceptance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName_link_laneChanging_gapAcceptane() {
		return name_link_laneChanging_gapAcceptane;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName_link_laneChanging_gapAcceptane(String newName_link_laneChanging_gapAcceptane) {
		String oldName_link_laneChanging_gapAcceptane = name_link_laneChanging_gapAcceptane;
		name_link_laneChanging_gapAcceptane = newName_link_laneChanging_gapAcceptane;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_LANE_CHANGING_GAP_ACCEPTANCE__NAME_LINK_LANE_CHANGING_GAP_ACCEPTANE, oldName_link_laneChanging_gapAcceptane, name_link_laneChanging_gapAcceptane));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LaneChanging getLink_laneChanging() {
		if (link_laneChanging != null && link_laneChanging.eIsProxy()) {
			InternalEObject oldLink_laneChanging = (InternalEObject)link_laneChanging;
			link_laneChanging = (LaneChanging)eResolveProxy(oldLink_laneChanging);
			if (link_laneChanging != oldLink_laneChanging) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LINK_LANE_CHANGING_GAP_ACCEPTANCE__LINK_LANE_CHANGING, oldLink_laneChanging, link_laneChanging));
			}
		}
		return link_laneChanging;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LaneChanging basicGetLink_laneChanging() {
		return link_laneChanging;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLink_laneChanging(LaneChanging newLink_laneChanging) {
		LaneChanging oldLink_laneChanging = link_laneChanging;
		link_laneChanging = newLink_laneChanging;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_LANE_CHANGING_GAP_ACCEPTANCE__LINK_LANE_CHANGING, oldLink_laneChanging, link_laneChanging));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GapAcceptance getLink_gapAcceptance() {
		if (link_gapAcceptance != null && link_gapAcceptance.eIsProxy()) {
			InternalEObject oldLink_gapAcceptance = (InternalEObject)link_gapAcceptance;
			link_gapAcceptance = (GapAcceptance)eResolveProxy(oldLink_gapAcceptance);
			if (link_gapAcceptance != oldLink_gapAcceptance) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LINK_LANE_CHANGING_GAP_ACCEPTANCE__LINK_GAP_ACCEPTANCE, oldLink_gapAcceptance, link_gapAcceptance));
			}
		}
		return link_gapAcceptance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GapAcceptance basicGetLink_gapAcceptance() {
		return link_gapAcceptance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLink_gapAcceptance(GapAcceptance newLink_gapAcceptance) {
		GapAcceptance oldLink_gapAcceptance = link_gapAcceptance;
		link_gapAcceptance = newLink_gapAcceptance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_LANE_CHANGING_GAP_ACCEPTANCE__LINK_GAP_ACCEPTANCE, oldLink_gapAcceptance, link_gapAcceptance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IntelligentMobilityPackage.LINK_LANE_CHANGING_GAP_ACCEPTANCE__NAME_LINK_LANE_CHANGING_GAP_ACCEPTANE:
				return getName_link_laneChanging_gapAcceptane();
			case IntelligentMobilityPackage.LINK_LANE_CHANGING_GAP_ACCEPTANCE__LINK_LANE_CHANGING:
				if (resolve) return getLink_laneChanging();
				return basicGetLink_laneChanging();
			case IntelligentMobilityPackage.LINK_LANE_CHANGING_GAP_ACCEPTANCE__LINK_GAP_ACCEPTANCE:
				if (resolve) return getLink_gapAcceptance();
				return basicGetLink_gapAcceptance();
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
			case IntelligentMobilityPackage.LINK_LANE_CHANGING_GAP_ACCEPTANCE__NAME_LINK_LANE_CHANGING_GAP_ACCEPTANE:
				setName_link_laneChanging_gapAcceptane((String)newValue);
				return;
			case IntelligentMobilityPackage.LINK_LANE_CHANGING_GAP_ACCEPTANCE__LINK_LANE_CHANGING:
				setLink_laneChanging((LaneChanging)newValue);
				return;
			case IntelligentMobilityPackage.LINK_LANE_CHANGING_GAP_ACCEPTANCE__LINK_GAP_ACCEPTANCE:
				setLink_gapAcceptance((GapAcceptance)newValue);
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
			case IntelligentMobilityPackage.LINK_LANE_CHANGING_GAP_ACCEPTANCE__NAME_LINK_LANE_CHANGING_GAP_ACCEPTANE:
				setName_link_laneChanging_gapAcceptane(NAME_LINK_LANE_CHANGING_GAP_ACCEPTANE_EDEFAULT);
				return;
			case IntelligentMobilityPackage.LINK_LANE_CHANGING_GAP_ACCEPTANCE__LINK_LANE_CHANGING:
				setLink_laneChanging((LaneChanging)null);
				return;
			case IntelligentMobilityPackage.LINK_LANE_CHANGING_GAP_ACCEPTANCE__LINK_GAP_ACCEPTANCE:
				setLink_gapAcceptance((GapAcceptance)null);
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
			case IntelligentMobilityPackage.LINK_LANE_CHANGING_GAP_ACCEPTANCE__NAME_LINK_LANE_CHANGING_GAP_ACCEPTANE:
				return NAME_LINK_LANE_CHANGING_GAP_ACCEPTANE_EDEFAULT == null ? name_link_laneChanging_gapAcceptane != null : !NAME_LINK_LANE_CHANGING_GAP_ACCEPTANE_EDEFAULT.equals(name_link_laneChanging_gapAcceptane);
			case IntelligentMobilityPackage.LINK_LANE_CHANGING_GAP_ACCEPTANCE__LINK_LANE_CHANGING:
				return link_laneChanging != null;
			case IntelligentMobilityPackage.LINK_LANE_CHANGING_GAP_ACCEPTANCE__LINK_GAP_ACCEPTANCE:
				return link_gapAcceptance != null;
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
		result.append(" (name_link_laneChanging_gapAcceptane: ");
		result.append(name_link_laneChanging_gapAcceptane);
		result.append(')');
		return result.toString();
	}

} //Link_LaneChanging_GapAcceptanceImpl
