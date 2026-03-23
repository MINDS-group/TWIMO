/**
 */
package intelligentMobility;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Driver Emotion</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.Driver_Emotion#getDrowsinessLevel <em>Drowsiness Level</em>}</li>
 *   <li>{@link intelligentMobility.Driver_Emotion#getImpulseControlLevel <em>Impulse Control Level</em>}</li>
 *   <li>{@link intelligentMobility.Driver_Emotion#getMetanlCondition <em>Metanl Condition</em>}</li>
 *   <li>{@link intelligentMobility.Driver_Emotion#getName <em>Name</em>}</li>
 *   <li>{@link intelligentMobility.Driver_Emotion#getEcgHr <em>Ecg Hr</em>}</li>
 *   <li>{@link intelligentMobility.Driver_Emotion#getGsr <em>Gsr</em>}</li>
 * </ul>
 *
 * @see intelligentMobility.IntelligentMobilityPackage#getDriver_Emotion()
 * @model
 * @generated
 */
public interface Driver_Emotion extends EObject {
	/**
	 * Returns the value of the '<em><b>Drowsiness Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Drowsiness Level</em>' attribute.
	 * @see #setDrowsinessLevel(int)
	 * @see intelligentMobility.IntelligentMobilityPackage#getDriver_Emotion_DrowsinessLevel()
	 * @model
	 * @generated
	 */
	int getDrowsinessLevel();

	/**
	 * Sets the value of the '{@link intelligentMobility.Driver_Emotion#getDrowsinessLevel <em>Drowsiness Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Drowsiness Level</em>' attribute.
	 * @see #getDrowsinessLevel()
	 * @generated
	 */
	void setDrowsinessLevel(int value);

	/**
	 * Returns the value of the '<em><b>Impulse Control Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Impulse Control Level</em>' attribute.
	 * @see #setImpulseControlLevel(int)
	 * @see intelligentMobility.IntelligentMobilityPackage#getDriver_Emotion_ImpulseControlLevel()
	 * @model
	 * @generated
	 */
	int getImpulseControlLevel();

	/**
	 * Sets the value of the '{@link intelligentMobility.Driver_Emotion#getImpulseControlLevel <em>Impulse Control Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Impulse Control Level</em>' attribute.
	 * @see #getImpulseControlLevel()
	 * @generated
	 */
	void setImpulseControlLevel(int value);

	/**
	 * Returns the value of the '<em><b>Metanl Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Metanl Condition</em>' attribute.
	 * @see #setMetanlCondition(String)
	 * @see intelligentMobility.IntelligentMobilityPackage#getDriver_Emotion_MetanlCondition()
	 * @model
	 * @generated
	 */
	String getMetanlCondition();

	/**
	 * Sets the value of the '{@link intelligentMobility.Driver_Emotion#getMetanlCondition <em>Metanl Condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Metanl Condition</em>' attribute.
	 * @see #getMetanlCondition()
	 * @generated
	 */
	void setMetanlCondition(String value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see intelligentMobility.IntelligentMobilityPackage#getDriver_Emotion_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link intelligentMobility.Driver_Emotion#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Ecg Hr</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ecg Hr</em>' attribute.
	 * @see #setEcgHr(int)
	 * @see intelligentMobility.IntelligentMobilityPackage#getDriver_Emotion_EcgHr()
	 * @model
	 * @generated
	 */
	int getEcgHr();

	/**
	 * Sets the value of the '{@link intelligentMobility.Driver_Emotion#getEcgHr <em>Ecg Hr</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ecg Hr</em>' attribute.
	 * @see #getEcgHr()
	 * @generated
	 */
	void setEcgHr(int value);

	/**
	 * Returns the value of the '<em><b>Gsr</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gsr</em>' attribute.
	 * @see #setGsr(int)
	 * @see intelligentMobility.IntelligentMobilityPackage#getDriver_Emotion_Gsr()
	 * @model
	 * @generated
	 */
	int getGsr();

	/**
	 * Sets the value of the '{@link intelligentMobility.Driver_Emotion#getGsr <em>Gsr</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Gsr</em>' attribute.
	 * @see #getGsr()
	 * @generated
	 */
	void setGsr(int value);

} // Driver_Emotion
