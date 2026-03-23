/**
 */
package intelligentMobility.impl;

import intelligentMobility.IntelligentMobilityPackage;
import intelligentMobility.Intersection;
import intelligentMobility.Link_SpecialCondition_Intersection;
import intelligentMobility.Special_Condition;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Link Special Condition Intersection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.impl.Link_SpecialCondition_IntersectionImpl#getName_link_specialCondition_intersection <em>Name link special Condition intersection</em>}</li>
 *   <li>{@link intelligentMobility.impl.Link_SpecialCondition_IntersectionImpl#getLink_specialCondition <em>Link special Condition</em>}</li>
 *   <li>{@link intelligentMobility.impl.Link_SpecialCondition_IntersectionImpl#getLink_intersection <em>Link intersection</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Link_SpecialCondition_IntersectionImpl extends MinimalEObjectImpl.Container implements Link_SpecialCondition_Intersection {
	/**
	 * The default value of the '{@link #getName_link_specialCondition_intersection() <em>Name link special Condition intersection</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName_link_specialCondition_intersection()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_LINK_SPECIAL_CONDITION_INTERSECTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName_link_specialCondition_intersection() <em>Name link special Condition intersection</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName_link_specialCondition_intersection()
	 * @generated
	 * @ordered
	 */
	protected String name_link_specialCondition_intersection = NAME_LINK_SPECIAL_CONDITION_INTERSECTION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getLink_specialCondition() <em>Link special Condition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_specialCondition()
	 * @generated
	 * @ordered
	 */
	protected Special_Condition link_specialCondition;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Link_SpecialCondition_IntersectionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return IntelligentMobilityPackage.eINSTANCE.getLink_SpecialCondition_Intersection();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName_link_specialCondition_intersection() {
		return name_link_specialCondition_intersection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName_link_specialCondition_intersection(String newName_link_specialCondition_intersection) {
		String oldName_link_specialCondition_intersection = name_link_specialCondition_intersection;
		name_link_specialCondition_intersection = newName_link_specialCondition_intersection;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_SPECIAL_CONDITION_INTERSECTION__NAME_LINK_SPECIAL_CONDITION_INTERSECTION, oldName_link_specialCondition_intersection, name_link_specialCondition_intersection));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Special_Condition getLink_specialCondition() {
		if (link_specialCondition != null && link_specialCondition.eIsProxy()) {
			InternalEObject oldLink_specialCondition = (InternalEObject)link_specialCondition;
			link_specialCondition = (Special_Condition)eResolveProxy(oldLink_specialCondition);
			if (link_specialCondition != oldLink_specialCondition) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LINK_SPECIAL_CONDITION_INTERSECTION__LINK_SPECIAL_CONDITION, oldLink_specialCondition, link_specialCondition));
			}
		}
		return link_specialCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Special_Condition basicGetLink_specialCondition() {
		return link_specialCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLink_specialCondition(Special_Condition newLink_specialCondition) {
		Special_Condition oldLink_specialCondition = link_specialCondition;
		link_specialCondition = newLink_specialCondition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_SPECIAL_CONDITION_INTERSECTION__LINK_SPECIAL_CONDITION, oldLink_specialCondition, link_specialCondition));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LINK_SPECIAL_CONDITION_INTERSECTION__LINK_INTERSECTION, oldLink_intersection, link_intersection));
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
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_SPECIAL_CONDITION_INTERSECTION__LINK_INTERSECTION, oldLink_intersection, link_intersection));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IntelligentMobilityPackage.LINK_SPECIAL_CONDITION_INTERSECTION__NAME_LINK_SPECIAL_CONDITION_INTERSECTION:
				return getName_link_specialCondition_intersection();
			case IntelligentMobilityPackage.LINK_SPECIAL_CONDITION_INTERSECTION__LINK_SPECIAL_CONDITION:
				if (resolve) return getLink_specialCondition();
				return basicGetLink_specialCondition();
			case IntelligentMobilityPackage.LINK_SPECIAL_CONDITION_INTERSECTION__LINK_INTERSECTION:
				if (resolve) return getLink_intersection();
				return basicGetLink_intersection();
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
			case IntelligentMobilityPackage.LINK_SPECIAL_CONDITION_INTERSECTION__NAME_LINK_SPECIAL_CONDITION_INTERSECTION:
				setName_link_specialCondition_intersection((String)newValue);
				return;
			case IntelligentMobilityPackage.LINK_SPECIAL_CONDITION_INTERSECTION__LINK_SPECIAL_CONDITION:
				setLink_specialCondition((Special_Condition)newValue);
				return;
			case IntelligentMobilityPackage.LINK_SPECIAL_CONDITION_INTERSECTION__LINK_INTERSECTION:
				setLink_intersection((Intersection)newValue);
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
			case IntelligentMobilityPackage.LINK_SPECIAL_CONDITION_INTERSECTION__NAME_LINK_SPECIAL_CONDITION_INTERSECTION:
				setName_link_specialCondition_intersection(NAME_LINK_SPECIAL_CONDITION_INTERSECTION_EDEFAULT);
				return;
			case IntelligentMobilityPackage.LINK_SPECIAL_CONDITION_INTERSECTION__LINK_SPECIAL_CONDITION:
				setLink_specialCondition((Special_Condition)null);
				return;
			case IntelligentMobilityPackage.LINK_SPECIAL_CONDITION_INTERSECTION__LINK_INTERSECTION:
				setLink_intersection((Intersection)null);
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
			case IntelligentMobilityPackage.LINK_SPECIAL_CONDITION_INTERSECTION__NAME_LINK_SPECIAL_CONDITION_INTERSECTION:
				return NAME_LINK_SPECIAL_CONDITION_INTERSECTION_EDEFAULT == null ? name_link_specialCondition_intersection != null : !NAME_LINK_SPECIAL_CONDITION_INTERSECTION_EDEFAULT.equals(name_link_specialCondition_intersection);
			case IntelligentMobilityPackage.LINK_SPECIAL_CONDITION_INTERSECTION__LINK_SPECIAL_CONDITION:
				return link_specialCondition != null;
			case IntelligentMobilityPackage.LINK_SPECIAL_CONDITION_INTERSECTION__LINK_INTERSECTION:
				return link_intersection != null;
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
		result.append(" (name_link_specialCondition_intersection: ");
		result.append(name_link_specialCondition_intersection);
		result.append(')');
		return result.toString();
	}

} //Link_SpecialCondition_IntersectionImpl
