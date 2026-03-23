/**
 */
package intelligentMobility;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Gap Acceptance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.GapAcceptance#getLagGap <em>Lag Gap</em>}</li>
 *   <li>{@link intelligentMobility.GapAcceptance#getLeadGap <em>Lead Gap</em>}</li>
 *   <li>{@link intelligentMobility.GapAcceptance#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see intelligentMobility.IntelligentMobilityPackage#getGapAcceptance()
 * @model
 * @generated
 */
public interface GapAcceptance extends EObject {
	/**
	 * Returns the value of the '<em><b>Lag Gap</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lag Gap</em>' attribute.
	 * @see #setLagGap(double)
	 * @see intelligentMobility.IntelligentMobilityPackage#getGapAcceptance_LagGap()
	 * @model
	 * @generated
	 */
	double getLagGap();

	/**
	 * Sets the value of the '{@link intelligentMobility.GapAcceptance#getLagGap <em>Lag Gap</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lag Gap</em>' attribute.
	 * @see #getLagGap()
	 * @generated
	 */
	void setLagGap(double value);

	/**
	 * Returns the value of the '<em><b>Lead Gap</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lead Gap</em>' attribute.
	 * @see #setLeadGap(double)
	 * @see intelligentMobility.IntelligentMobilityPackage#getGapAcceptance_LeadGap()
	 * @model
	 * @generated
	 */
	double getLeadGap();

	/**
	 * Sets the value of the '{@link intelligentMobility.GapAcceptance#getLeadGap <em>Lead Gap</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lead Gap</em>' attribute.
	 * @see #getLeadGap()
	 * @generated
	 */
	void setLeadGap(double value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see intelligentMobility.IntelligentMobilityPackage#getGapAcceptance_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link intelligentMobility.GapAcceptance#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // GapAcceptance
