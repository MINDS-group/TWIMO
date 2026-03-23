/**
 */
package intelligentMobility;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Traffic Situation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.Traffic_Situation#getName <em>Name</em>}</li>
 *   <li>{@link intelligentMobility.Traffic_Situation#getTrafficType <em>Traffic Type</em>}</li>
 *   <li>{@link intelligentMobility.Traffic_Situation#getStimulusType <em>Stimulus Type</em>}</li>
 *   <li>{@link intelligentMobility.Traffic_Situation#getIntensity <em>Intensity</em>}</li>
 * </ul>
 *
 * @see intelligentMobility.IntelligentMobilityPackage#getTraffic_Situation()
 * @model
 * @generated
 */
public interface Traffic_Situation extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see intelligentMobility.IntelligentMobilityPackage#getTraffic_Situation_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link intelligentMobility.Traffic_Situation#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Traffic Type</b></em>' attribute.
	 * The literals are from the enumeration {@link intelligentMobility.TrafficType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Traffic Type</em>' attribute.
	 * @see intelligentMobility.TrafficType
	 * @see #setTrafficType(TrafficType)
	 * @see intelligentMobility.IntelligentMobilityPackage#getTraffic_Situation_TrafficType()
	 * @model
	 * @generated
	 */
	TrafficType getTrafficType();

	/**
	 * Sets the value of the '{@link intelligentMobility.Traffic_Situation#getTrafficType <em>Traffic Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Traffic Type</em>' attribute.
	 * @see intelligentMobility.TrafficType
	 * @see #getTrafficType()
	 * @generated
	 */
	void setTrafficType(TrafficType value);

	/**
	 * Returns the value of the '<em><b>Stimulus Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stimulus Type</em>' attribute.
	 * @see #setStimulusType(String)
	 * @see intelligentMobility.IntelligentMobilityPackage#getTraffic_Situation_StimulusType()
	 * @model
	 * @generated
	 */
	String getStimulusType();

	/**
	 * Sets the value of the '{@link intelligentMobility.Traffic_Situation#getStimulusType <em>Stimulus Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stimulus Type</em>' attribute.
	 * @see #getStimulusType()
	 * @generated
	 */
	void setStimulusType(String value);

	/**
	 * Returns the value of the '<em><b>Intensity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Intensity</em>' attribute.
	 * @see #setIntensity(float)
	 * @see intelligentMobility.IntelligentMobilityPackage#getTraffic_Situation_Intensity()
	 * @model
	 * @generated
	 */
	float getIntensity();

	/**
	 * Sets the value of the '{@link intelligentMobility.Traffic_Situation#getIntensity <em>Intensity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Intensity</em>' attribute.
	 * @see #getIntensity()
	 * @generated
	 */
	void setIntensity(float value);

} // Traffic_Situation
