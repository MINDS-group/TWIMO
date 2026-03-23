/**
 */
package intelligentMobility;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Turn</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.Turn#getTurnSide <em>Turn Side</em>}</li>
 *   <li>{@link intelligentMobility.Turn#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see intelligentMobility.IntelligentMobilityPackage#getTurn()
 * @model
 * @generated
 */
public interface Turn extends Action {
	/**
	 * Returns the value of the '<em><b>Turn Side</b></em>' attribute.
	 * The literals are from the enumeration {@link intelligentMobility.Direction}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Turn Side</em>' attribute.
	 * @see intelligentMobility.Direction
	 * @see #setTurnSide(Direction)
	 * @see intelligentMobility.IntelligentMobilityPackage#getTurn_TurnSide()
	 * @model
	 * @generated
	 */
	Direction getTurnSide();

	/**
	 * Sets the value of the '{@link intelligentMobility.Turn#getTurnSide <em>Turn Side</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Turn Side</em>' attribute.
	 * @see intelligentMobility.Direction
	 * @see #getTurnSide()
	 * @generated
	 */
	void setTurnSide(Direction value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see intelligentMobility.IntelligentMobilityPackage#getTurn_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link intelligentMobility.Turn#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // Turn
