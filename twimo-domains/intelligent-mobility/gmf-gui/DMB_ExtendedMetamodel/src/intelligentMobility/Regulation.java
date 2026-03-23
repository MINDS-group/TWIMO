/**
 */
package intelligentMobility;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Regulation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.Regulation#getLegislation <em>Legislation</em>}</li>
 *   <li>{@link intelligentMobility.Regulation#getCourtesy <em>Courtesy</em>}</li>
 *   <li>{@link intelligentMobility.Regulation#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see intelligentMobility.IntelligentMobilityPackage#getRegulation()
 * @model
 * @generated
 */
public interface Regulation extends EObject {
	/**
	 * Returns the value of the '<em><b>Legislation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Legislation</em>' attribute.
	 * @see #setLegislation(String)
	 * @see intelligentMobility.IntelligentMobilityPackage#getRegulation_Legislation()
	 * @model
	 * @generated
	 */
	String getLegislation();

	/**
	 * Sets the value of the '{@link intelligentMobility.Regulation#getLegislation <em>Legislation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Legislation</em>' attribute.
	 * @see #getLegislation()
	 * @generated
	 */
	void setLegislation(String value);

	/**
	 * Returns the value of the '<em><b>Courtesy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Courtesy</em>' attribute.
	 * @see #setCourtesy(String)
	 * @see intelligentMobility.IntelligentMobilityPackage#getRegulation_Courtesy()
	 * @model
	 * @generated
	 */
	String getCourtesy();

	/**
	 * Sets the value of the '{@link intelligentMobility.Regulation#getCourtesy <em>Courtesy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Courtesy</em>' attribute.
	 * @see #getCourtesy()
	 * @generated
	 */
	void setCourtesy(String value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see intelligentMobility.IntelligentMobilityPackage#getRegulation_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link intelligentMobility.Regulation#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // Regulation
