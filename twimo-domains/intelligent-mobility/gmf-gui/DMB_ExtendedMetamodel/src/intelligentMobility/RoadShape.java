/**
 */
package intelligentMobility;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Road Shape</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see intelligentMobility.IntelligentMobilityPackage#getRoadShape()
 * @model
 * @generated
 */
public final class RoadShape extends AbstractEnumerator {
	/**
	 * The '<em><b>Round</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ROUND_LITERAL
	 * @model name="Round"
	 * @generated
	 * @ordered
	 */
	public static final int ROUND = 0;

	/**
	 * The '<em><b>Straight</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STRAIGHT_LITERAL
	 * @model name="Straight"
	 * @generated
	 * @ordered
	 */
	public static final int STRAIGHT = 1;

	/**
	 * The '<em><b>Round</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ROUND
	 * @generated
	 * @ordered
	 */
	public static final RoadShape ROUND_LITERAL = new RoadShape(ROUND, "Round", "Round");

	/**
	 * The '<em><b>Straight</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STRAIGHT
	 * @generated
	 * @ordered
	 */
	public static final RoadShape STRAIGHT_LITERAL = new RoadShape(STRAIGHT, "Straight", "Straight");

	/**
	 * An array of all the '<em><b>Road Shape</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final RoadShape[] VALUES_ARRAY =
		new RoadShape[] {
			ROUND_LITERAL,
			STRAIGHT_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Road Shape</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Road Shape</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static RoadShape get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			RoadShape result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Road Shape</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static RoadShape getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			RoadShape result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Road Shape</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static RoadShape get(int value) {
		switch (value) {
			case ROUND: return ROUND_LITERAL;
			case STRAIGHT: return STRAIGHT_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private RoadShape(int value, String name, String literal) {
		super(value, name, literal);
	}

} //RoadShape
