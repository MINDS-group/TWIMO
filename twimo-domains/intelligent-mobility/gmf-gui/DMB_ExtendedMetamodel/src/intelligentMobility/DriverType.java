/**
 */
package intelligentMobility;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Driver Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see intelligentMobility.IntelligentMobilityPackage#getDriverType()
 * @model
 * @generated
 */
public final class DriverType extends AbstractEnumerator {
	/**
	 * The '<em><b>Human</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HUMAN_LITERAL
	 * @model name="Human"
	 * @generated
	 * @ordered
	 */
	public static final int HUMAN = 0;

	/**
	 * The '<em><b>Selfdriving</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SELFDRIVING_LITERAL
	 * @model name="Selfdriving"
	 * @generated
	 * @ordered
	 */
	public static final int SELFDRIVING = 1;

	/**
	 * The '<em><b>Human</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HUMAN
	 * @generated
	 * @ordered
	 */
	public static final DriverType HUMAN_LITERAL = new DriverType(HUMAN, "Human", "Human");

	/**
	 * The '<em><b>Selfdriving</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SELFDRIVING
	 * @generated
	 * @ordered
	 */
	public static final DriverType SELFDRIVING_LITERAL = new DriverType(SELFDRIVING, "Selfdriving", "Selfdriving");

	/**
	 * An array of all the '<em><b>Driver Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final DriverType[] VALUES_ARRAY =
		new DriverType[] {
			HUMAN_LITERAL,
			SELFDRIVING_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Driver Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Driver Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static DriverType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			DriverType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Driver Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static DriverType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			DriverType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Driver Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static DriverType get(int value) {
		switch (value) {
			case HUMAN: return HUMAN_LITERAL;
			case SELFDRIVING: return SELFDRIVING_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private DriverType(int value, String name, String literal) {
		super(value, name, literal);
	}

} //DriverType
