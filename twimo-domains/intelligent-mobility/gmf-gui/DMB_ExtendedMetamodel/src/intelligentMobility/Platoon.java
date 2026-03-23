/**
 */
package intelligentMobility;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Platoon</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.Platoon#getName <em>Name</em>}</li>
 *   <li>{@link intelligentMobility.Platoon#getV2vTime <em>V2v Time</em>}</li>
 *   <li>{@link intelligentMobility.Platoon#getFollowerCount <em>Follower Count</em>}</li>
 *   <li>{@link intelligentMobility.Platoon#isResetColor <em>Reset Color</em>}</li>
 *   <li>{@link intelligentMobility.Platoon#getColorR_min <em>Color Rmin</em>}</li>
 *   <li>{@link intelligentMobility.Platoon#getColorR_max <em>Color Rmax</em>}</li>
 *   <li>{@link intelligentMobility.Platoon#getColorG_min <em>Color Gmin</em>}</li>
 *   <li>{@link intelligentMobility.Platoon#getColorG_max <em>Color Gmax</em>}</li>
 *   <li>{@link intelligentMobility.Platoon#getColorB_min <em>Color Bmin</em>}</li>
 *   <li>{@link intelligentMobility.Platoon#getColorB_max <em>Color Bmax</em>}</li>
 *   <li>{@link intelligentMobility.Platoon#getLeading_vehicle <em>Leading vehicle</em>}</li>
 *   <li>{@link intelligentMobility.Platoon#getFollowing_vehicle <em>Following vehicle</em>}</li>
 * </ul>
 *
 * @see intelligentMobility.IntelligentMobilityPackage#getPlatoon()
 * @model
 * @generated
 */
public interface Platoon extends Vehicle_Type {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see intelligentMobility.IntelligentMobilityPackage#getPlatoon_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link intelligentMobility.Platoon#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>V2v Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>V2v Time</em>' attribute.
	 * @see #setV2vTime(double)
	 * @see intelligentMobility.IntelligentMobilityPackage#getPlatoon_V2vTime()
	 * @model
	 * @generated
	 */
	double getV2vTime();

	/**
	 * Sets the value of the '{@link intelligentMobility.Platoon#getV2vTime <em>V2v Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>V2v Time</em>' attribute.
	 * @see #getV2vTime()
	 * @generated
	 */
	void setV2vTime(double value);

	/**
	 * Returns the value of the '<em><b>Follower Count</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Integer}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Follower Count</em>' attribute list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getPlatoon_FollowerCount()
	 * @model required="true"
	 * @generated
	 */
	EList getFollowerCount();

	/**
	 * Returns the value of the '<em><b>Reset Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reset Color</em>' attribute.
	 * @see #setResetColor(boolean)
	 * @see intelligentMobility.IntelligentMobilityPackage#getPlatoon_ResetColor()
	 * @model
	 * @generated
	 */
	boolean isResetColor();

	/**
	 * Sets the value of the '{@link intelligentMobility.Platoon#isResetColor <em>Reset Color</em>}' attribute.
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
	 * @see intelligentMobility.IntelligentMobilityPackage#getPlatoon_ColorR_min()
	 * @model
	 * @generated
	 */
	int getColorR_min();

	/**
	 * Sets the value of the '{@link intelligentMobility.Platoon#getColorR_min <em>Color Rmin</em>}' attribute.
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
	 * @see intelligentMobility.IntelligentMobilityPackage#getPlatoon_ColorR_max()
	 * @model
	 * @generated
	 */
	int getColorR_max();

	/**
	 * Sets the value of the '{@link intelligentMobility.Platoon#getColorR_max <em>Color Rmax</em>}' attribute.
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
	 * @see intelligentMobility.IntelligentMobilityPackage#getPlatoon_ColorG_min()
	 * @model
	 * @generated
	 */
	int getColorG_min();

	/**
	 * Sets the value of the '{@link intelligentMobility.Platoon#getColorG_min <em>Color Gmin</em>}' attribute.
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
	 * @see intelligentMobility.IntelligentMobilityPackage#getPlatoon_ColorG_max()
	 * @model
	 * @generated
	 */
	int getColorG_max();

	/**
	 * Sets the value of the '{@link intelligentMobility.Platoon#getColorG_max <em>Color Gmax</em>}' attribute.
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
	 * @see intelligentMobility.IntelligentMobilityPackage#getPlatoon_ColorB_min()
	 * @model
	 * @generated
	 */
	int getColorB_min();

	/**
	 * Sets the value of the '{@link intelligentMobility.Platoon#getColorB_min <em>Color Bmin</em>}' attribute.
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
	 * @see intelligentMobility.IntelligentMobilityPackage#getPlatoon_ColorB_max()
	 * @model
	 * @generated
	 */
	int getColorB_max();

	/**
	 * Sets the value of the '{@link intelligentMobility.Platoon#getColorB_max <em>Color Bmax</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Color Bmax</em>' attribute.
	 * @see #getColorB_max()
	 * @generated
	 */
	void setColorB_max(int value);

	/**
	 * Returns the value of the '<em><b>Leading vehicle</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Leading vehicle</em>' containment reference.
	 * @see #setLeading_vehicle(Leading_Vehicle)
	 * @see intelligentMobility.IntelligentMobilityPackage#getPlatoon_Leading_vehicle()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Leading_Vehicle getLeading_vehicle();

	/**
	 * Sets the value of the '{@link intelligentMobility.Platoon#getLeading_vehicle <em>Leading vehicle</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Leading vehicle</em>' containment reference.
	 * @see #getLeading_vehicle()
	 * @generated
	 */
	void setLeading_vehicle(Leading_Vehicle value);

	/**
	 * Returns the value of the '<em><b>Following vehicle</b></em>' containment reference list.
	 * The list contents are of type {@link intelligentMobility.Following_Vehicle}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Following vehicle</em>' containment reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getPlatoon_Following_vehicle()
	 * @model type="intelligentMobility.Following_Vehicle" containment="true" required="true"
	 * @generated
	 */
	EList getFollowing_vehicle();

} // Platoon
