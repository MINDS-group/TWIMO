/**
 */
package intelligentMobility;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Direction</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see intelligentMobility.IntelligentMobilityPackage#getDirection()
 * @model
 * @generated
 */
public final class Direction extends AbstractEnumerator {
	/**
	 * The '<em><b>Left</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LEFT_LITERAL
	 * @model name="Left"
	 * @generated
	 * @ordered
	 */
	public static final int LEFT = 0;

	/**
	 * The '<em><b>Right</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RIGHT_LITERAL
	 * @model name="Right"
	 * @generated
	 * @ordered
	 */
	public static final int RIGHT = 1;

	/**
	 * The '<em><b>Straight</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STRAIGHT_LITERAL
	 * @model name="Straight"
	 * @generated
	 * @ordered
	 */
	public static final int STRAIGHT = 2;

	/**
	 * The '<em><b>UTurn</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UTURN_LITERAL
	 * @model name="UTurn"
	 * @generated
	 * @ordered
	 */
	public static final int UTURN = 3;

	/**
	 * The '<em><b>Left</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LEFT
	 * @generated
	 * @ordered
	 */
	public static final Direction LEFT_LITERAL = new Direction(LEFT, "Left", "Left");

	/**
	 * The '<em><b>Right</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RIGHT
	 * @generated
	 * @ordered
	 */
	public static final Direction RIGHT_LITERAL = new Direction(RIGHT, "Right", "Right");

	/**
	 * The '<em><b>Straight</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STRAIGHT
	 * @generated
	 * @ordered
	 */
	public static final Direction STRAIGHT_LITERAL = new Direction(STRAIGHT, "Straight", "Straight");

	/**
	 * The '<em><b>UTurn</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UTURN
	 * @generated
	 * @ordered
	 */
	public static final Direction UTURN_LITERAL = new Direction(UTURN, "UTurn", "UTurn");

	/**
	 * An array of all the '<em><b>Direction</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final Direction[] VALUES_ARRAY =
		new Direction[] {
			LEFT_LITERAL,
			RIGHT_LITERAL,
			STRAIGHT_LITERAL,
			UTURN_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Direction</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Direction</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Direction get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Direction result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Direction</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Direction getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Direction result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Direction</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Direction get(int value) {
		switch (value) {
			case LEFT: return LEFT_LITERAL;
			case RIGHT: return RIGHT_LITERAL;
			case STRAIGHT: return STRAIGHT_LITERAL;
			case UTURN: return UTURN_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private Direction(int value, String name, String literal) {
		super(value, name, literal);
	}

} //Direction
