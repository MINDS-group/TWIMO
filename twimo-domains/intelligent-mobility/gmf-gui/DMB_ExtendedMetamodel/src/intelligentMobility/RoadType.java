/**
 */
package intelligentMobility;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Road Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see intelligentMobility.IntelligentMobilityPackage#getRoadType()
 * @model
 * @generated
 */
public final class RoadType extends AbstractEnumerator {
	/**
	 * The '<em><b>Highway</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HIGHWAY_LITERAL
	 * @model name="Highway"
	 * @generated
	 * @ordered
	 */
	public static final int HIGHWAY = 0;

	/**
	 * The '<em><b>Urban Road</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #URBAN_ROAD_LITERAL
	 * @model name="UrbanRoad"
	 * @generated
	 * @ordered
	 */
	public static final int URBAN_ROAD = 1;

	/**
	 * The '<em><b>Mountain Road</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MOUNTAIN_ROAD_LITERAL
	 * @model name="MountainRoad"
	 * @generated
	 * @ordered
	 */
	public static final int MOUNTAIN_ROAD = 2;

	/**
	 * The '<em><b>Highway</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HIGHWAY
	 * @generated
	 * @ordered
	 */
	public static final RoadType HIGHWAY_LITERAL = new RoadType(HIGHWAY, "Highway", "Highway");

	/**
	 * The '<em><b>Urban Road</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #URBAN_ROAD
	 * @generated
	 * @ordered
	 */
	public static final RoadType URBAN_ROAD_LITERAL = new RoadType(URBAN_ROAD, "UrbanRoad", "UrbanRoad");

	/**
	 * The '<em><b>Mountain Road</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MOUNTAIN_ROAD
	 * @generated
	 * @ordered
	 */
	public static final RoadType MOUNTAIN_ROAD_LITERAL = new RoadType(MOUNTAIN_ROAD, "MountainRoad", "MountainRoad");

	/**
	 * An array of all the '<em><b>Road Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final RoadType[] VALUES_ARRAY =
		new RoadType[] {
			HIGHWAY_LITERAL,
			URBAN_ROAD_LITERAL,
			MOUNTAIN_ROAD_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Road Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Road Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static RoadType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			RoadType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Road Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static RoadType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			RoadType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Road Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static RoadType get(int value) {
		switch (value) {
			case HIGHWAY: return HIGHWAY_LITERAL;
			case URBAN_ROAD: return URBAN_ROAD_LITERAL;
			case MOUNTAIN_ROAD: return MOUNTAIN_ROAD_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private RoadType(int value, String name, String literal) {
		super(value, name, literal);
	}

} //RoadType
