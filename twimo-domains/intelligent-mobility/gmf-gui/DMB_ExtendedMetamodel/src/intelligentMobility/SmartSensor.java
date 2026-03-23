/**
 */
package intelligentMobility;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Smart Sensor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link intelligentMobility.SmartSensor#getMonitors <em>Monitors</em>}</li>
 * </ul>
 *
 * @see intelligentMobility.IntelligentMobilityPackage#getSmartSensor()
 * @model
 * @generated
 */
public interface SmartSensor extends Infrastructure {
	/**
	 * Returns the value of the '<em><b>Monitors</b></em>' reference list.
	 * The list contents are of type {@link intelligentMobility.Traffic_Situation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Monitors</em>' reference list.
	 * @see intelligentMobility.IntelligentMobilityPackage#getSmartSensor_Monitors()
	 * @model type="intelligentMobility.Traffic_Situation" required="true"
	 * @generated
	 */
	EList getMonitors();

} // SmartSensor
