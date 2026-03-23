/**
 */
package intelligentMobility.impl;

import intelligentMobility.IntelligentMobilityPackage;
import intelligentMobility.Intersection;
import intelligentMobility.Link_Intersection_TrafficLight;
import intelligentMobility.Traffic_Light;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Link Intersection Traffic Light</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.impl.Link_Intersection_TrafficLightImpl#getName_link_intersection_trafficLight <em>Name link intersection traffic Light</em>}</li>
 *   <li>{@link intelligentMobility.impl.Link_Intersection_TrafficLightImpl#getLink_intersection <em>Link intersection</em>}</li>
 *   <li>{@link intelligentMobility.impl.Link_Intersection_TrafficLightImpl#getLink_trafficLight <em>Link traffic Light</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Link_Intersection_TrafficLightImpl extends MinimalEObjectImpl.Container implements Link_Intersection_TrafficLight {
	/**
	 * The default value of the '{@link #getName_link_intersection_trafficLight() <em>Name link intersection traffic Light</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName_link_intersection_trafficLight()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_LINK_INTERSECTION_TRAFFIC_LIGHT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName_link_intersection_trafficLight() <em>Name link intersection traffic Light</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName_link_intersection_trafficLight()
	 * @generated
	 * @ordered
	 */
	protected String name_link_intersection_trafficLight = NAME_LINK_INTERSECTION_TRAFFIC_LIGHT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getLink_intersection() <em>Link intersection</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_intersection()
	 * @generated
	 * @ordered
	 */
	protected Intersection link_intersection;

	/**
	 * The cached value of the '{@link #getLink_trafficLight() <em>Link traffic Light</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_trafficLight()
	 * @generated
	 * @ordered
	 */
	protected Traffic_Light link_trafficLight;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Link_Intersection_TrafficLightImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return IntelligentMobilityPackage.eINSTANCE.getLink_Intersection_TrafficLight();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName_link_intersection_trafficLight() {
		return name_link_intersection_trafficLight;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName_link_intersection_trafficLight(String newName_link_intersection_trafficLight) {
		String oldName_link_intersection_trafficLight = name_link_intersection_trafficLight;
		name_link_intersection_trafficLight = newName_link_intersection_trafficLight;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_INTERSECTION_TRAFFIC_LIGHT__NAME_LINK_INTERSECTION_TRAFFIC_LIGHT, oldName_link_intersection_trafficLight, name_link_intersection_trafficLight));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Intersection getLink_intersection() {
		if (link_intersection != null && link_intersection.eIsProxy()) {
			InternalEObject oldLink_intersection = (InternalEObject)link_intersection;
			link_intersection = (Intersection)eResolveProxy(oldLink_intersection);
			if (link_intersection != oldLink_intersection) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LINK_INTERSECTION_TRAFFIC_LIGHT__LINK_INTERSECTION, oldLink_intersection, link_intersection));
			}
		}
		return link_intersection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Intersection basicGetLink_intersection() {
		return link_intersection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLink_intersection(Intersection newLink_intersection) {
		Intersection oldLink_intersection = link_intersection;
		link_intersection = newLink_intersection;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_INTERSECTION_TRAFFIC_LIGHT__LINK_INTERSECTION, oldLink_intersection, link_intersection));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Traffic_Light getLink_trafficLight() {
		if (link_trafficLight != null && link_trafficLight.eIsProxy()) {
			InternalEObject oldLink_trafficLight = (InternalEObject)link_trafficLight;
			link_trafficLight = (Traffic_Light)eResolveProxy(oldLink_trafficLight);
			if (link_trafficLight != oldLink_trafficLight) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LINK_INTERSECTION_TRAFFIC_LIGHT__LINK_TRAFFIC_LIGHT, oldLink_trafficLight, link_trafficLight));
			}
		}
		return link_trafficLight;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Traffic_Light basicGetLink_trafficLight() {
		return link_trafficLight;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLink_trafficLight(Traffic_Light newLink_trafficLight) {
		Traffic_Light oldLink_trafficLight = link_trafficLight;
		link_trafficLight = newLink_trafficLight;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_INTERSECTION_TRAFFIC_LIGHT__LINK_TRAFFIC_LIGHT, oldLink_trafficLight, link_trafficLight));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IntelligentMobilityPackage.LINK_INTERSECTION_TRAFFIC_LIGHT__NAME_LINK_INTERSECTION_TRAFFIC_LIGHT:
				return getName_link_intersection_trafficLight();
			case IntelligentMobilityPackage.LINK_INTERSECTION_TRAFFIC_LIGHT__LINK_INTERSECTION:
				if (resolve) return getLink_intersection();
				return basicGetLink_intersection();
			case IntelligentMobilityPackage.LINK_INTERSECTION_TRAFFIC_LIGHT__LINK_TRAFFIC_LIGHT:
				if (resolve) return getLink_trafficLight();
				return basicGetLink_trafficLight();
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
			case IntelligentMobilityPackage.LINK_INTERSECTION_TRAFFIC_LIGHT__NAME_LINK_INTERSECTION_TRAFFIC_LIGHT:
				setName_link_intersection_trafficLight((String)newValue);
				return;
			case IntelligentMobilityPackage.LINK_INTERSECTION_TRAFFIC_LIGHT__LINK_INTERSECTION:
				setLink_intersection((Intersection)newValue);
				return;
			case IntelligentMobilityPackage.LINK_INTERSECTION_TRAFFIC_LIGHT__LINK_TRAFFIC_LIGHT:
				setLink_trafficLight((Traffic_Light)newValue);
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
			case IntelligentMobilityPackage.LINK_INTERSECTION_TRAFFIC_LIGHT__NAME_LINK_INTERSECTION_TRAFFIC_LIGHT:
				setName_link_intersection_trafficLight(NAME_LINK_INTERSECTION_TRAFFIC_LIGHT_EDEFAULT);
				return;
			case IntelligentMobilityPackage.LINK_INTERSECTION_TRAFFIC_LIGHT__LINK_INTERSECTION:
				setLink_intersection((Intersection)null);
				return;
			case IntelligentMobilityPackage.LINK_INTERSECTION_TRAFFIC_LIGHT__LINK_TRAFFIC_LIGHT:
				setLink_trafficLight((Traffic_Light)null);
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
			case IntelligentMobilityPackage.LINK_INTERSECTION_TRAFFIC_LIGHT__NAME_LINK_INTERSECTION_TRAFFIC_LIGHT:
				return NAME_LINK_INTERSECTION_TRAFFIC_LIGHT_EDEFAULT == null ? name_link_intersection_trafficLight != null : !NAME_LINK_INTERSECTION_TRAFFIC_LIGHT_EDEFAULT.equals(name_link_intersection_trafficLight);
			case IntelligentMobilityPackage.LINK_INTERSECTION_TRAFFIC_LIGHT__LINK_INTERSECTION:
				return link_intersection != null;
			case IntelligentMobilityPackage.LINK_INTERSECTION_TRAFFIC_LIGHT__LINK_TRAFFIC_LIGHT:
				return link_trafficLight != null;
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
		result.append(" (name_link_intersection_trafficLight: ");
		result.append(name_link_intersection_trafficLight);
		result.append(')');
		return result.toString();
	}

} //Link_Intersection_TrafficLightImpl
