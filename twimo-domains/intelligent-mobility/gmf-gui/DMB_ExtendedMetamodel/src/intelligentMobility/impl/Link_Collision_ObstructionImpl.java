/**
 */
package intelligentMobility.impl;

import intelligentMobility.Collision;
import intelligentMobility.IntelligentMobilityPackage;
import intelligentMobility.Link_Collision_Obstruction;
import intelligentMobility.Obstruction;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Link Collision Obstruction</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.impl.Link_Collision_ObstructionImpl#getName_link_collision_obstruction <em>Name link collision obstruction</em>}</li>
 *   <li>{@link intelligentMobility.impl.Link_Collision_ObstructionImpl#getLink_collision <em>Link collision</em>}</li>
 *   <li>{@link intelligentMobility.impl.Link_Collision_ObstructionImpl#getLink_obstruction <em>Link obstruction</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Link_Collision_ObstructionImpl extends MinimalEObjectImpl.Container implements Link_Collision_Obstruction {
	/**
	 * The default value of the '{@link #getName_link_collision_obstruction() <em>Name link collision obstruction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName_link_collision_obstruction()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_LINK_COLLISION_OBSTRUCTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName_link_collision_obstruction() <em>Name link collision obstruction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName_link_collision_obstruction()
	 * @generated
	 * @ordered
	 */
	protected String name_link_collision_obstruction = NAME_LINK_COLLISION_OBSTRUCTION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getLink_collision() <em>Link collision</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_collision()
	 * @generated
	 * @ordered
	 */
	protected Collision link_collision;

	/**
	 * The cached value of the '{@link #getLink_obstruction() <em>Link obstruction</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_obstruction()
	 * @generated
	 * @ordered
	 */
	protected Obstruction link_obstruction;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Link_Collision_ObstructionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return IntelligentMobilityPackage.eINSTANCE.getLink_Collision_Obstruction();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName_link_collision_obstruction() {
		return name_link_collision_obstruction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName_link_collision_obstruction(String newName_link_collision_obstruction) {
		String oldName_link_collision_obstruction = name_link_collision_obstruction;
		name_link_collision_obstruction = newName_link_collision_obstruction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_COLLISION_OBSTRUCTION__NAME_LINK_COLLISION_OBSTRUCTION, oldName_link_collision_obstruction, name_link_collision_obstruction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Collision getLink_collision() {
		if (link_collision != null && link_collision.eIsProxy()) {
			InternalEObject oldLink_collision = (InternalEObject)link_collision;
			link_collision = (Collision)eResolveProxy(oldLink_collision);
			if (link_collision != oldLink_collision) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LINK_COLLISION_OBSTRUCTION__LINK_COLLISION, oldLink_collision, link_collision));
			}
		}
		return link_collision;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Collision basicGetLink_collision() {
		return link_collision;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLink_collision(Collision newLink_collision) {
		Collision oldLink_collision = link_collision;
		link_collision = newLink_collision;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_COLLISION_OBSTRUCTION__LINK_COLLISION, oldLink_collision, link_collision));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Obstruction getLink_obstruction() {
		if (link_obstruction != null && link_obstruction.eIsProxy()) {
			InternalEObject oldLink_obstruction = (InternalEObject)link_obstruction;
			link_obstruction = (Obstruction)eResolveProxy(oldLink_obstruction);
			if (link_obstruction != oldLink_obstruction) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LINK_COLLISION_OBSTRUCTION__LINK_OBSTRUCTION, oldLink_obstruction, link_obstruction));
			}
		}
		return link_obstruction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Obstruction basicGetLink_obstruction() {
		return link_obstruction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLink_obstruction(Obstruction newLink_obstruction) {
		Obstruction oldLink_obstruction = link_obstruction;
		link_obstruction = newLink_obstruction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_COLLISION_OBSTRUCTION__LINK_OBSTRUCTION, oldLink_obstruction, link_obstruction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IntelligentMobilityPackage.LINK_COLLISION_OBSTRUCTION__NAME_LINK_COLLISION_OBSTRUCTION:
				return getName_link_collision_obstruction();
			case IntelligentMobilityPackage.LINK_COLLISION_OBSTRUCTION__LINK_COLLISION:
				if (resolve) return getLink_collision();
				return basicGetLink_collision();
			case IntelligentMobilityPackage.LINK_COLLISION_OBSTRUCTION__LINK_OBSTRUCTION:
				if (resolve) return getLink_obstruction();
				return basicGetLink_obstruction();
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
			case IntelligentMobilityPackage.LINK_COLLISION_OBSTRUCTION__NAME_LINK_COLLISION_OBSTRUCTION:
				setName_link_collision_obstruction((String)newValue);
				return;
			case IntelligentMobilityPackage.LINK_COLLISION_OBSTRUCTION__LINK_COLLISION:
				setLink_collision((Collision)newValue);
				return;
			case IntelligentMobilityPackage.LINK_COLLISION_OBSTRUCTION__LINK_OBSTRUCTION:
				setLink_obstruction((Obstruction)newValue);
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
			case IntelligentMobilityPackage.LINK_COLLISION_OBSTRUCTION__NAME_LINK_COLLISION_OBSTRUCTION:
				setName_link_collision_obstruction(NAME_LINK_COLLISION_OBSTRUCTION_EDEFAULT);
				return;
			case IntelligentMobilityPackage.LINK_COLLISION_OBSTRUCTION__LINK_COLLISION:
				setLink_collision((Collision)null);
				return;
			case IntelligentMobilityPackage.LINK_COLLISION_OBSTRUCTION__LINK_OBSTRUCTION:
				setLink_obstruction((Obstruction)null);
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
			case IntelligentMobilityPackage.LINK_COLLISION_OBSTRUCTION__NAME_LINK_COLLISION_OBSTRUCTION:
				return NAME_LINK_COLLISION_OBSTRUCTION_EDEFAULT == null ? name_link_collision_obstruction != null : !NAME_LINK_COLLISION_OBSTRUCTION_EDEFAULT.equals(name_link_collision_obstruction);
			case IntelligentMobilityPackage.LINK_COLLISION_OBSTRUCTION__LINK_COLLISION:
				return link_collision != null;
			case IntelligentMobilityPackage.LINK_COLLISION_OBSTRUCTION__LINK_OBSTRUCTION:
				return link_obstruction != null;
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
		result.append(" (name_link_collision_obstruction: ");
		result.append(name_link_collision_obstruction);
		result.append(')');
		return result.toString();
	}

} //Link_Collision_ObstructionImpl
