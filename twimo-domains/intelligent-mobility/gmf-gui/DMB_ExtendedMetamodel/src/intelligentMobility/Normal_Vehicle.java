/**
 */
package intelligentMobility;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Normal Vehicle</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.Normal_Vehicle#getName <em>Name</em>}</li>
 *   <li>{@link intelligentMobility.Normal_Vehicle#isResetColor <em>Reset Color</em>}</li>
 *   <li>{@link intelligentMobility.Normal_Vehicle#getColorR_min <em>Color Rmin</em>}</li>
 *   <li>{@link intelligentMobility.Normal_Vehicle#getColorR_max <em>Color Rmax</em>}</li>
 *   <li>{@link intelligentMobility.Normal_Vehicle#getColorG_min <em>Color Gmin</em>}</li>
 *   <li>{@link intelligentMobility.Normal_Vehicle#getColorG_max <em>Color Gmax</em>}</li>
 *   <li>{@link intelligentMobility.Normal_Vehicle#getColorB_min <em>Color Bmin</em>}</li>
 *   <li>{@link intelligentMobility.Normal_Vehicle#getColorB_max <em>Color Bmax</em>}</li>
 *   <li>{@link intelligentMobility.Normal_Vehicle#getSafety_requirements <em>Safety requirements</em>}</li>
 * </ul>
 *
 * @see intelligentMobility.IntelligentMobilityPackage#getNormal_Vehicle()
 * @model
 * @generated
 */
public interface Normal_Vehicle extends Vehicle_Type {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see intelligentMobility.IntelligentMobilityPackage#getNormal_Vehicle_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link intelligentMobility.Normal_Vehicle#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Reset Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reset Color</em>' attribute.
	 * @see #setResetColor(boolean)
	 * @see intelligentMobility.IntelligentMobilityPackage#getNormal_Vehicle_ResetColor()
	 * @model
	 * @generated
	 */
	boolean isResetColor();

	/**
	 * Sets the value of the '{@link intelligentMobility.Normal_Vehicle#isResetColor <em>Reset Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reset Color</em>' attribute.
	 * @see #isResetColor()
	 * @generated
	 */
	void setResetColor(boolean value);

	/**
	 * Returns the value of the '<em><b>Color Rmin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Color Rmin</em>' attribute.
	 * @see #setColorR_min(int)
	 * @see intelligentMobility.IntelligentMobilityPackage#getNormal_Vehicle_ColorR_min()
	 * @model
	 * @generated
	 */
	int getColorR_min();

	/**
	 * Sets the value of the '{@link intelligentMobility.Normal_Vehicle#getColorR_min <em>Color Rmin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Color Rmin</em>' attribute.
	 * @see #getColorR_min()
	 * @generated
	 */
	void setColorR_min(int value);

	/**
	 * Returns the value of the '<em><b>Color Rmax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Color Rmax</em>' attribute.
	 * @see #setColorR_max(int)
	 * @see intelligentMobility.IntelligentMobilityPackage#getNormal_Vehicle_ColorR_max()
	 * @model
	 * @generated
	 */
	int getColorR_max();

	/**
	 * Sets the value of the '{@link intelligentMobility.Normal_Vehicle#getColorR_max <em>Color Rmax</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Color Rmax</em>' attribute.
	 * @see #getColorR_max()
	 * @generated
	 */
	void setColorR_max(int value);

	/**
	 * Returns the value of the '<em><b>Color Gmin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Color Gmin</em>' attribute.
	 * @see #setColorG_min(int)
	 * @see intelligentMobility.IntelligentMobilityPackage#getNormal_Vehicle_ColorG_min()
	 * @model
	 * @generated
	 */
	int getColorG_min();

	/**
	 * Sets the value of the '{@link intelligentMobility.Normal_Vehicle#getColorG_min <em>Color Gmin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Color Gmin</em>' attribute.
	 * @see #getColorG_min()
	 * @generated
	 */
	void setColorG_min(int value);

	/**
	 * Returns the value of the '<em><b>Color Gmax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Color Gmax</em>' attribute.
	 * @see #setColorG_max(int)
	 * @see intelligentMobility.IntelligentMobilityPackage#getNormal_Vehicle_ColorG_max()
	 * @model
	 * @generated
	 */
	int getColorG_max();

	/**
	 * Sets the value of the '{@link intelligentMobility.Normal_Vehicle#getColorG_max <em>Color Gmax</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Color Gmax</em>' attribute.
	 * @see #getColorG_max()
	 * @generated
	 */
	void setColorG_max(int value);

	/**
	 * Returns the value of the '<em><b>Color Bmin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Color Bmin</em>' attribute.
	 * @see #setColorB_min(int)
	 * @see intelligentMobility.IntelligentMobilityPackage#getNormal_Vehicle_ColorB_min()
	 * @model
	 * @generated
	 */
	int getColorB_min();

	/**
	 * Sets the value of the '{@link intelligentMobility.Normal_Vehicle#getColorB_min <em>Color Bmin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Color Bmin</em>' attribute.
	 * @see #getColorB_min()
	 * @generated
	 */
	void setColorB_min(int value);

	/**
	 * Returns the value of the '<em><b>Color Bmax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Color Bmax</em>' attribute.
	 * @see #setColorB_max(int)
	 * @see intelligentMobility.IntelligentMobilityPackage#getNormal_Vehicle_ColorB_max()
	 * @model
	 * @generated
	 */
	int getColorB_max();

	/**
	 * Sets the value of the '{@link intelligentMobility.Normal_Vehicle#getColorB_max <em>Color Bmax</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Color Bmax</em>' attribute.
	 * @see #getColorB_max()
	 * @generated
	 */
	void setColorB_max(int value);

	/**
	 * Returns the value of the '<em><b>Safety requirements</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Safety requirements</em>' containment reference.
	 * @see #setSafety_requirements(Safety_Requirement)
	 * @see intelligentMobility.IntelligentMobilityPackage#getNormal_Vehicle_Safety_requirements()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Safety_Requirement getSafety_requirements();

	/**
	 * Sets the value of the '{@link intelligentMobility.Normal_Vehicle#getSafety_requirements <em>Safety requirements</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Safety requirements</em>' containment reference.
	 * @see #getSafety_requirements()
	 * @generated
	 */
	void setSafety_requirements(Safety_Requirement value);

} // Normal_Vehicle
