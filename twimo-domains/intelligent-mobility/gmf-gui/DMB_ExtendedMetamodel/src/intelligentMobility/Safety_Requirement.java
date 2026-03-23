/**
 */
package intelligentMobility;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Safety Requirement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.Safety_Requirement#getSafeSecond <em>Safe Second</em>}</li>
 *   <li>{@link intelligentMobility.Safety_Requirement#getSafezoneLength_default <em>Safezone Length default</em>}</li>
 *   <li>{@link intelligentMobility.Safety_Requirement#getSafeFrontMin <em>Safe Front Min</em>}</li>
 *   <li>{@link intelligentMobility.Safety_Requirement#getName <em>Name</em>}</li>
 *   <li>{@link intelligentMobility.Safety_Requirement#getRegulations <em>Regulations</em>}</li>
 * </ul>
 *
 * @see intelligentMobility.IntelligentMobilityPackage#getSafety_Requirement()
 * @model
 * @generated
 */
public interface Safety_Requirement extends EObject {
	/**
	 * Returns the value of the '<em><b>Safe Second</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Safe Second</em>' attribute.
	 * @see #setSafeSecond(int)
	 * @see intelligentMobility.IntelligentMobilityPackage#getSafety_Requirement_SafeSecond()
	 * @model
	 * @generated
	 */
	int getSafeSecond();

	/**
	 * Sets the value of the '{@link intelligentMobility.Safety_Requirement#getSafeSecond <em>Safe Second</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Safe Second</em>' attribute.
	 * @see #getSafeSecond()
	 * @generated
	 */
	void setSafeSecond(int value);

	/**
	 * Returns the value of the '<em><b>Safezone Length default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Safezone Length default</em>' attribute.
	 * @see #setSafezoneLength_default(double)
	 * @see intelligentMobility.IntelligentMobilityPackage#getSafety_Requirement_SafezoneLength_default()
	 * @model
	 * @generated
	 */
	double getSafezoneLength_default();

	/**
	 * Sets the value of the '{@link intelligentMobility.Safety_Requirement#getSafezoneLength_default <em>Safezone Length default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Safezone Length default</em>' attribute.
	 * @see #getSafezoneLength_default()
	 * @generated
	 */
	void setSafezoneLength_default(double value);

	/**
	 * Returns the value of the '<em><b>Safe Front Min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Safe Front Min</em>' attribute.
	 * @see #setSafeFrontMin(double)
	 * @see intelligentMobility.IntelligentMobilityPackage#getSafety_Requirement_SafeFrontMin()
	 * @model
	 * @generated
	 */
	double getSafeFrontMin();

	/**
	 * Sets the value of the '{@link intelligentMobility.Safety_Requirement#getSafeFrontMin <em>Safe Front Min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Safe Front Min</em>' attribute.
	 * @see #getSafeFrontMin()
	 * @generated
	 */
	void setSafeFrontMin(double value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see intelligentMobility.IntelligentMobilityPackage#getSafety_Requirement_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link intelligentMobility.Safety_Requirement#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Regulations</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Regulations</em>' reference.
	 * @see #setRegulations(Regulation)
	 * @see intelligentMobility.IntelligentMobilityPackage#getSafety_Requirement_Regulations()
	 * @model
	 * @generated
	 */
	Regulation getRegulations();

	/**
	 * Sets the value of the '{@link intelligentMobility.Safety_Requirement#getRegulations <em>Regulations</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Regulations</em>' reference.
	 * @see #getRegulations()
	 * @generated
	 */
	void setRegulations(Regulation value);

} // Safety_Requirement
