/**
 */
package intelligentMobility;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Traffic Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see intelligentMobility.IntelligentMobilityPackage#getTrafficType()
 * @model
 * @generated
 */
public final class TrafficType extends AbstractEnumerator {
	/**
	 * The '<em><b>Congestion</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONGESTION_LITERAL
	 * @model name="Congestion"
	 * @generated
	 * @ordered
	 */
	public static final int CONGESTION = 0;

	/**
	 * The '<em><b>Rush Hours</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RUSH_HOURS_LITERAL
	 * @model name="RushHours"
	 * @generated
	 * @ordered
	 */
	public static final int RUSH_HOURS = 1;

	/**
	 * The '<em><b>Congestion</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONGESTION
	 * @generated
	 * @ordered
	 */
	public static final TrafficType CONGESTION_LITERAL = new TrafficType(CONGESTION, "Congestion", "Congestion");

	/**
	 * The '<em><b>Rush Hours</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RUSH_HOURS
	 * @generated
	 * @ordered
	 */
	public static final TrafficType RUSH_HOURS_LITERAL = new TrafficType(RUSH_HOURS, "RushHours", "RushHours");

	/**
	 * An array of all the '<em><b>Traffic Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final TrafficType[] VALUES_ARRAY =
		new TrafficType[] {
			CONGESTION_LITERAL,
			RUSH_HOURS_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Traffic Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Traffic Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static TrafficType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TrafficType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Traffic Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static TrafficType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TrafficType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Traffic Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static TrafficType get(int value) {
		switch (value) {
			case CONGESTION: return CONGESTION_LITERAL;
			case RUSH_HOURS: return RUSH_HOURS_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private TrafficType(int value, String name, String literal) {
		super(value, name, literal);
	}

} //TrafficType
