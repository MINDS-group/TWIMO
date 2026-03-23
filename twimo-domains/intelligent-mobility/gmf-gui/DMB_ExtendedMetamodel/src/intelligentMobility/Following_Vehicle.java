/**
 */
package intelligentMobility;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Following Vehicle</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.Following_Vehicle#getHeadwayMin <em>Headway Min</em>}</li>
 *   <li>{@link intelligentMobility.Following_Vehicle#getHeadwayMax <em>Headway Max</em>}</li>
 *   <li>{@link intelligentMobility.Following_Vehicle#getFrontvehicle <em>Frontvehicle</em>}</li>
 * </ul>
 *
 * @see intelligentMobility.IntelligentMobilityPackage#getFollowing_Vehicle()
 * @model
 * @generated
 */
public interface Following_Vehicle extends PlatoonMember {
	/**
	 * Returns the value of the '<em><b>Headway Min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Headway Min</em>' attribute.
	 * @see #setHeadwayMin(double)
	 * @see intelligentMobility.IntelligentMobilityPackage#getFollowing_Vehicle_HeadwayMin()
	 * @model
	 * @generated
	 */
	double getHeadwayMin();

	/**
	 * Sets the value of the '{@link intelligentMobility.Following_Vehicle#getHeadwayMin <em>Headway Min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Headway Min</em>' attribute.
	 * @see #getHeadwayMin()
	 * @generated
	 */
	void setHeadwayMin(double value);

	/**
	 * Returns the value of the '<em><b>Headway Max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Headway Max</em>' attribute.
	 * @see #setHeadwayMax(double)
	 * @see intelligentMobility.IntelligentMobilityPackage#getFollowing_Vehicle_HeadwayMax()
	 * @model
	 * @generated
	 */
	double getHeadwayMax();

	/**
	 * Sets the value of the '{@link intelligentMobility.Following_Vehicle#getHeadwayMax <em>Headway Max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Headway Max</em>' attribute.
	 * @see #getHeadwayMax()
	 * @generated
	 */
	void setHeadwayMax(double value);

	/**
	 * Returns the value of the '<em><b>Frontvehicle</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Frontvehicle</em>' reference.
	 * @see #setFrontvehicle(PlatoonMember)
	 * @see intelligentMobility.IntelligentMobilityPackage#getFollowing_Vehicle_Frontvehicle()
	 * @model required="true"
	 * @generated
	 */
	PlatoonMember getFrontvehicle();

	/**
	 * Sets the value of the '{@link intelligentMobility.Following_Vehicle#getFrontvehicle <em>Frontvehicle</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Frontvehicle</em>' reference.
	 * @see #getFrontvehicle()
	 * @generated
	 */
	void setFrontvehicle(PlatoonMember value);

} // Following_Vehicle
