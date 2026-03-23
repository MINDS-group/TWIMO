/**
 */
package intelligentMobility;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Goal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.Goal#getGoalType <em>Goal Type</em>}</li>
 *   <li>{@link intelligentMobility.Goal#getPriority <em>Priority</em>}</li>
 *   <li>{@link intelligentMobility.Goal#isIsGoalDriven <em>Is Goal Driven</em>}</li>
 *   <li>{@link intelligentMobility.Goal#isIsStimulusDriven <em>Is Stimulus Driven</em>}</li>
 * </ul>
 *
 * @see intelligentMobility.IntelligentMobilityPackage#getGoal()
 * @model
 * @generated
 */
public interface Goal extends EObject {
	/**
	 * Returns the value of the '<em><b>Goal Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Goal Type</em>' attribute.
	 * @see #setGoalType(String)
	 * @see intelligentMobility.IntelligentMobilityPackage#getGoal_GoalType()
	 * @model
	 * @generated
	 */
	String getGoalType();

	/**
	 * Sets the value of the '{@link intelligentMobility.Goal#getGoalType <em>Goal Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Goal Type</em>' attribute.
	 * @see #getGoalType()
	 * @generated
	 */
	void setGoalType(String value);

	/**
	 * Returns the value of the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Priority</em>' attribute.
	 * @see #setPriority(int)
	 * @see intelligentMobility.IntelligentMobilityPackage#getGoal_Priority()
	 * @model
	 * @generated
	 */
	int getPriority();

	/**
	 * Sets the value of the '{@link intelligentMobility.Goal#getPriority <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Priority</em>' attribute.
	 * @see #getPriority()
	 * @generated
	 */
	void setPriority(int value);

	/**
	 * Returns the value of the '<em><b>Is Goal Driven</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Goal Driven</em>' attribute.
	 * @see #setIsGoalDriven(boolean)
	 * @see intelligentMobility.IntelligentMobilityPackage#getGoal_IsGoalDriven()
	 * @model
	 * @generated
	 */
	boolean isIsGoalDriven();

	/**
	 * Sets the value of the '{@link intelligentMobility.Goal#isIsGoalDriven <em>Is Goal Driven</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Goal Driven</em>' attribute.
	 * @see #isIsGoalDriven()
	 * @generated
	 */
	void setIsGoalDriven(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Stimulus Driven</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Stimulus Driven</em>' attribute.
	 * @see #setIsStimulusDriven(boolean)
	 * @see intelligentMobility.IntelligentMobilityPackage#getGoal_IsStimulusDriven()
	 * @model
	 * @generated
	 */
	boolean isIsStimulusDriven();

	/**
	 * Sets the value of the '{@link intelligentMobility.Goal#isIsStimulusDriven <em>Is Stimulus Driven</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Stimulus Driven</em>' attribute.
	 * @see #isIsStimulusDriven()
	 * @generated
	 */
	void setIsStimulusDriven(boolean value);

} // Goal
