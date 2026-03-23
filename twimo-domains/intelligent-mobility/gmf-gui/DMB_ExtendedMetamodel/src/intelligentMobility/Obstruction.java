/**
 */
package intelligentMobility;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Obstruction</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.Obstruction#getName <em>Name</em>}</li>
 *   <li>{@link intelligentMobility.Obstruction#getObstacleLocationX <em>Obstacle Location X</em>}</li>
 *   <li>{@link intelligentMobility.Obstruction#getObstacleLocationY <em>Obstacle Location Y</em>}</li>
 * </ul>
 *
 * @see intelligentMobility.IntelligentMobilityPackage#getObstruction()
 * @model
 * @generated
 */
public interface Obstruction extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see intelligentMobility.IntelligentMobilityPackage#getObstruction_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link intelligentMobility.Obstruction#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Obstacle Location X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Obstacle Location X</em>' attribute.
	 * @see #setObstacleLocationX(double)
	 * @see intelligentMobility.IntelligentMobilityPackage#getObstruction_ObstacleLocationX()
	 * @model
	 * @generated
	 */
	double getObstacleLocationX();

	/**
	 * Sets the value of the '{@link intelligentMobility.Obstruction#getObstacleLocationX <em>Obstacle Location X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Obstacle Location X</em>' attribute.
	 * @see #getObstacleLocationX()
	 * @generated
	 */
	void setObstacleLocationX(double value);

	/**
	 * Returns the value of the '<em><b>Obstacle Location Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Obstacle Location Y</em>' attribute.
	 * @see #setObstacleLocationY(double)
	 * @see intelligentMobility.IntelligentMobilityPackage#getObstruction_ObstacleLocationY()
	 * @model
	 * @generated
	 */
	double getObstacleLocationY();

	/**
	 * Sets the value of the '{@link intelligentMobility.Obstruction#getObstacleLocationY <em>Obstacle Location Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Obstacle Location Y</em>' attribute.
	 * @see #getObstacleLocationY()
	 * @generated
	 */
	void setObstacleLocationY(double value);

} // Obstruction
