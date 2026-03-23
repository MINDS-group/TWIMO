/**
 */
package intelligentMobility.impl;

import intelligentMobility.Backward;
import intelligentMobility.Following;
import intelligentMobility.IntelligentMobilityPackage;
import intelligentMobility.Link_Following_Backward;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Link Following Backward</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.impl.Link_Following_BackwardImpl#getName_link_following_backward <em>Name link following backward</em>}</li>
 *   <li>{@link intelligentMobility.impl.Link_Following_BackwardImpl#getLink_following <em>Link following</em>}</li>
 *   <li>{@link intelligentMobility.impl.Link_Following_BackwardImpl#getLink_backward <em>Link backward</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Link_Following_BackwardImpl extends MinimalEObjectImpl.Container implements Link_Following_Backward {
	/**
	 * The default value of the '{@link #getName_link_following_backward() <em>Name link following backward</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName_link_following_backward()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_LINK_FOLLOWING_BACKWARD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName_link_following_backward() <em>Name link following backward</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName_link_following_backward()
	 * @generated
	 * @ordered
	 */
	protected String name_link_following_backward = NAME_LINK_FOLLOWING_BACKWARD_EDEFAULT;

	/**
	 * The cached value of the '{@link #getLink_following() <em>Link following</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_following()
	 * @generated
	 * @ordered
	 */
	protected Following link_following;

	/**
	 * The cached value of the '{@link #getLink_backward() <em>Link backward</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink_backward()
	 * @generated
	 * @ordered
	 */
	protected Backward link_backward;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Link_Following_BackwardImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return IntelligentMobilityPackage.eINSTANCE.getLink_Following_Backward();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName_link_following_backward() {
		return name_link_following_backward;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName_link_following_backward(String newName_link_following_backward) {
		String oldName_link_following_backward = name_link_following_backward;
		name_link_following_backward = newName_link_following_backward;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_FOLLOWING_BACKWARD__NAME_LINK_FOLLOWING_BACKWARD, oldName_link_following_backward, name_link_following_backward));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Following getLink_following() {
		if (link_following != null && link_following.eIsProxy()) {
			InternalEObject oldLink_following = (InternalEObject)link_following;
			link_following = (Following)eResolveProxy(oldLink_following);
			if (link_following != oldLink_following) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LINK_FOLLOWING_BACKWARD__LINK_FOLLOWING, oldLink_following, link_following));
			}
		}
		return link_following;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Following basicGetLink_following() {
		return link_following;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLink_following(Following newLink_following) {
		Following oldLink_following = link_following;
		link_following = newLink_following;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_FOLLOWING_BACKWARD__LINK_FOLLOWING, oldLink_following, link_following));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Backward getLink_backward() {
		if (link_backward != null && link_backward.eIsProxy()) {
			InternalEObject oldLink_backward = (InternalEObject)link_backward;
			link_backward = (Backward)eResolveProxy(oldLink_backward);
			if (link_backward != oldLink_backward) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntelligentMobilityPackage.LINK_FOLLOWING_BACKWARD__LINK_BACKWARD, oldLink_backward, link_backward));
			}
		}
		return link_backward;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Backward basicGetLink_backward() {
		return link_backward;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLink_backward(Backward newLink_backward) {
		Backward oldLink_backward = link_backward;
		link_backward = newLink_backward;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntelligentMobilityPackage.LINK_FOLLOWING_BACKWARD__LINK_BACKWARD, oldLink_backward, link_backward));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IntelligentMobilityPackage.LINK_FOLLOWING_BACKWARD__NAME_LINK_FOLLOWING_BACKWARD:
				return getName_link_following_backward();
			case IntelligentMobilityPackage.LINK_FOLLOWING_BACKWARD__LINK_FOLLOWING:
				if (resolve) return getLink_following();
				return basicGetLink_following();
			case IntelligentMobilityPackage.LINK_FOLLOWING_BACKWARD__LINK_BACKWARD:
				if (resolve) return getLink_backward();
				return basicGetLink_backward();
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
			case IntelligentMobilityPackage.LINK_FOLLOWING_BACKWARD__NAME_LINK_FOLLOWING_BACKWARD:
				setName_link_following_backward((String)newValue);
				return;
			case IntelligentMobilityPackage.LINK_FOLLOWING_BACKWARD__LINK_FOLLOWING:
				setLink_following((Following)newValue);
				return;
			case IntelligentMobilityPackage.LINK_FOLLOWING_BACKWARD__LINK_BACKWARD:
				setLink_backward((Backward)newValue);
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
			case IntelligentMobilityPackage.LINK_FOLLOWING_BACKWARD__NAME_LINK_FOLLOWING_BACKWARD:
				setName_link_following_backward(NAME_LINK_FOLLOWING_BACKWARD_EDEFAULT);
				return;
			case IntelligentMobilityPackage.LINK_FOLLOWING_BACKWARD__LINK_FOLLOWING:
				setLink_following((Following)null);
				return;
			case IntelligentMobilityPackage.LINK_FOLLOWING_BACKWARD__LINK_BACKWARD:
				setLink_backward((Backward)null);
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
			case IntelligentMobilityPackage.LINK_FOLLOWING_BACKWARD__NAME_LINK_FOLLOWING_BACKWARD:
				return NAME_LINK_FOLLOWING_BACKWARD_EDEFAULT == null ? name_link_following_backward != null : !NAME_LINK_FOLLOWING_BACKWARD_EDEFAULT.equals(name_link_following_backward);
			case IntelligentMobilityPackage.LINK_FOLLOWING_BACKWARD__LINK_FOLLOWING:
				return link_following != null;
			case IntelligentMobilityPackage.LINK_FOLLOWING_BACKWARD__LINK_BACKWARD:
				return link_backward != null;
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
		result.append(" (name_link_following_backward: ");
		result.append(name_link_following_backward);
		result.append(')');
		return result.toString();
	}

} //Link_Following_BackwardImpl
