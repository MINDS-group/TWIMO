/**
 */
package intelligentMobility.impl;

import intelligentMobility.Infrastructure;
import intelligentMobility.IntelligentMobilityPackage;
import intelligentMobility.Intersection;
import intelligentMobility.Traffic_Light;
import intelligentMobility.Vehicle_Configuration;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Intersection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.impl.IntersectionImpl#getCommunicatesWith <em>Communicates With</em>}</li>
 *   <li>{@link intelligentMobility.impl.IntersectionImpl#getName <em>Name</em>}</li>
 *   <li>{@link intelligentMobility.impl.IntersectionImpl#getTraffic_lights <em>Traffic lights</em>}</li>
 *   <li>{@link intelligentMobility.impl.IntersectionImpl#getCrossIntersection <em>Cross Intersection</em>}</li>
 *   <li>{@link intelligentMobility.impl.IntersectionImpl#getCrossRailway <em>Cross Railway</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IntersectionImpl extends ExceptionConditionImpl implements Intersection {
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
	 * The cached value of the '{@link #getTraffic_lights() <em>Traffic lights</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTraffic_lights()
	 * @generated
	 * @ordered
	 */
	protected EList traffic_lights;

	/**
	 * The default value of the '{@link #getCrossIntersection() <em>Cross Intersection</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCrossIntersection()
	 * @generated
	 * @ordered
	 */
	protected static final int CROSS_INTERSECTION_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getCrossIntersection() <em>Cross Intersection</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCrossIntersection()
	 * @generated
	 * @ordered
	 */
	protected int crossIntersection = CROSS_INTERSECTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getCrossRailway() <em>Cross Railway</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCrossRailway()
	 * @generated
	 * @ordered
	 */
	protected static final int CROSS_RAILWAY_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getCrossRailway() <em>Cross Railway</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCrossRailway()
	 * @generated
	 * @ordered
	 */
	protected int crossRailway = CROSS_RAILWAY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IntersectionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return IntelligentMobilityPackage.eINSTANCE.getIntersection();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getCommunicatesWith() {
		if (communicatesWith == null) {
			communicatesWith = new EObjectWithInverseResolvingEList.ManyInverse(Vehicle_Configuration.class, this, IntelligentMobilityPackage.INTERSECTION__COMMUNICATES_WITH, IntelligentMobilityPackage.VEHICLE_CONFIGURATION__CONNECTED_INFRASTRUCTURE);
		}
		return communicatesWith;
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
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.INTERSECTION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getTraffic_lights() {
		if (traffic_lights == null) {
			traffic_lights = new EObjectContainmentEList(Traffic_Light.class, this, IntelligentMobilityPackage.INTERSECTION__TRAFFIC_LIGHTS);
		}
		return traffic_lights;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getCrossIntersection() {
		return crossIntersection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCrossIntersection(int newCrossIntersection) {
		int oldCrossIntersection = crossIntersection;
		crossIntersection = newCrossIntersection;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.INTERSECTION__CROSS_INTERSECTION, oldCrossIntersection, crossIntersection));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getCrossRailway() {
		return crossRailway;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCrossRailway(int newCrossRailway) {
		int oldCrossRailway = crossRailway;
		crossRailway = newCrossRailway;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.INTERSECTION__CROSS_RAILWAY, oldCrossRailway, crossRailway));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case IntelligentMobilityPackage.INTERSECTION__COMMUNICATES_WITH:
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
			case IntelligentMobilityPackage.INTERSECTION__COMMUNICATES_WITH:
				return ((InternalEList)getCommunicatesWith()).basicRemove(otherEnd, msgs);
			case IntelligentMobilityPackage.INTERSECTION__TRAFFIC_LIGHTS:
				return ((InternalEList)getTraffic_lights()).basicRemove(otherEnd, msgs);
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
			case IntelligentMobilityPackage.INTERSECTION__COMMUNICATES_WITH:
				return getCommunicatesWith();
			case IntelligentMobilityPackage.INTERSECTION__NAME:
				return getName();
			case IntelligentMobilityPackage.INTERSECTION__TRAFFIC_LIGHTS:
				return getTraffic_lights();
			case IntelligentMobilityPackage.INTERSECTION__CROSS_INTERSECTION:
				return new Integer(getCrossIntersection());
			case IntelligentMobilityPackage.INTERSECTION__CROSS_RAILWAY:
				return new Integer(getCrossRailway());
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
			case IntelligentMobilityPackage.INTERSECTION__COMMUNICATES_WITH:
				getCommunicatesWith().clear();
				getCommunicatesWith().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.INTERSECTION__NAME:
				setName((String)newValue);
				return;
			case IntelligentMobilityPackage.INTERSECTION__TRAFFIC_LIGHTS:
				getTraffic_lights().clear();
				getTraffic_lights().addAll((Collection)newValue);
				return;
			case IntelligentMobilityPackage.INTERSECTION__CROSS_INTERSECTION:
				setCrossIntersection(((Integer)newValue).intValue());
				return;
			case IntelligentMobilityPackage.INTERSECTION__CROSS_RAILWAY:
				setCrossRailway(((Integer)newValue).intValue());
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
			case IntelligentMobilityPackage.INTERSECTION__COMMUNICATES_WITH:
				getCommunicatesWith().clear();
				return;
			case IntelligentMobilityPackage.INTERSECTION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case IntelligentMobilityPackage.INTERSECTION__TRAFFIC_LIGHTS:
				getTraffic_lights().clear();
				return;
			case IntelligentMobilityPackage.INTERSECTION__CROSS_INTERSECTION:
				setCrossIntersection(CROSS_INTERSECTION_EDEFAULT);
				return;
			case IntelligentMobilityPackage.INTERSECTION__CROSS_RAILWAY:
				setCrossRailway(CROSS_RAILWAY_EDEFAULT);
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
			case IntelligentMobilityPackage.INTERSECTION__COMMUNICATES_WITH:
				return communicatesWith != null && !communicatesWith.isEmpty();
			case IntelligentMobilityPackage.INTERSECTION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case IntelligentMobilityPackage.INTERSECTION__TRAFFIC_LIGHTS:
				return traffic_lights != null && !traffic_lights.isEmpty();
			case IntelligentMobilityPackage.INTERSECTION__CROSS_INTERSECTION:
				return crossIntersection != CROSS_INTERSECTION_EDEFAULT;
			case IntelligentMobilityPackage.INTERSECTION__CROSS_RAILWAY:
				return crossRailway != CROSS_RAILWAY_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class baseClass) {
		if (baseClass == Infrastructure.class) {
			switch (derivedFeatureID) {
				case IntelligentMobilityPackage.INTERSECTION__COMMUNICATES_WITH: return IntelligentMobilityPackage.INFRASTRUCTURE__COMMUNICATES_WITH;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class baseClass) {
		if (baseClass == Infrastructure.class) {
			switch (baseFeatureID) {
				case IntelligentMobilityPackage.INFRASTRUCTURE__COMMUNICATES_WITH: return IntelligentMobilityPackage.INTERSECTION__COMMUNICATES_WITH;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(", crossIntersection: ");
		result.append(crossIntersection);
		result.append(", crossRailway: ");
		result.append(crossRailway);
		result.append(')');
		return result.toString();
	}

} //IntersectionImpl
