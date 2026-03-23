/**
 */
package intelligentMobility;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Lanes</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see intelligentMobility.IntelligentMobilityPackage#getLanes()
 * @model
 * @generated
 */
public final class Lanes extends AbstractEnumerator {
	/**
	 * The '<em><b>Normal Lane</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NORMAL_LANE_LITERAL
	 * @model name="NormalLane"
	 * @generated
	 * @ordered
	 */
	public static final int NORMAL_LANE = 0;

	/**
	 * The '<em><b>Entry</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ENTRY_LITERAL
	 * @model name="Entry"
	 * @generated
	 * @ordered
	 */
	public static final int ENTRY = 1;

	/**
	 * The '<em><b>Exit</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EXIT_LITERAL
	 * @model name="Exit"
	 * @generated
	 * @ordered
	 */
	public static final int EXIT = 2;

	/**
	 * The '<em><b>Exit Section</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EXIT_SECTION_LITERAL
	 * @model name="ExitSection"
	 * @generated
	 * @ordered
	 */
	public static final int EXIT_SECTION = 3;

	/**
	 * The '<em><b>Emergency Lane</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EMERGENCY_LANE_LITERAL
	 * @model name="EmergencyLane"
	 * @generated
	 * @ordered
	 */
	public static final int EMERGENCY_LANE = 4;

	/**
	 * The '<em><b>Rush Hour Lane</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RUSH_HOUR_LANE_LITERAL
	 * @model name="RushHourLane"
	 * @generated
	 * @ordered
	 */
	public static final int RUSH_HOUR_LANE = 5;

	/**
	 * The '<em><b>Secondary Road</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SECONDARY_ROAD_LITERAL
	 * @model name="SecondaryRoad"
	 * @generated
	 * @ordered
	 */
	public static final int SECONDARY_ROAD = 6;

	/**
	 * The '<em><b>Zebra Crossings</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ZEBRA_CROSSINGS_LITERAL
	 * @model name="ZebraCrossings"
	 * @generated
	 * @ordered
	 */
	public static final int ZEBRA_CROSSINGS = 7;

	/**
	 * The '<em><b>Confluence</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONFLUENCE_LITERAL
	 * @model name="Confluence"
	 * @generated
	 * @ordered
	 */
	public static final int CONFLUENCE = 8;

	/**
	 * The '<em><b>Normal Lane</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NORMAL_LANE
	 * @generated
	 * @ordered
	 */
	public static final Lanes NORMAL_LANE_LITERAL = new Lanes(NORMAL_LANE, "NormalLane", "NormalLane");

	/**
	 * The '<em><b>Entry</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ENTRY
	 * @generated
	 * @ordered
	 */
	public static final Lanes ENTRY_LITERAL = new Lanes(ENTRY, "Entry", "Entry");

	/**
	 * The '<em><b>Exit</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EXIT
	 * @generated
	 * @ordered
	 */
	public static final Lanes EXIT_LITERAL = new Lanes(EXIT, "Exit", "Exit");

	/**
	 * The '<em><b>Exit Section</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EXIT_SECTION
	 * @generated
	 * @ordered
	 */
	public static final Lanes EXIT_SECTION_LITERAL = new Lanes(EXIT_SECTION, "ExitSection", "ExitSection");

	/**
	 * The '<em><b>Emergency Lane</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EMERGENCY_LANE
	 * @generated
	 * @ordered
	 */
	public static final Lanes EMERGENCY_LANE_LITERAL = new Lanes(EMERGENCY_LANE, "EmergencyLane", "EmergencyLane");

	/**
	 * The '<em><b>Rush Hour Lane</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RUSH_HOUR_LANE
	 * @generated
	 * @ordered
	 */
	public static final Lanes RUSH_HOUR_LANE_LITERAL = new Lanes(RUSH_HOUR_LANE, "RushHourLane", "RushHourLane");

	/**
	 * The '<em><b>Secondary Road</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SECONDARY_ROAD
	 * @generated
	 * @ordered
	 */
	public static final Lanes SECONDARY_ROAD_LITERAL = new Lanes(SECONDARY_ROAD, "SecondaryRoad", "SecondaryRoad");

	/**
	 * The '<em><b>Zebra Crossings</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ZEBRA_CROSSINGS
	 * @generated
	 * @ordered
	 */
	public static final Lanes ZEBRA_CROSSINGS_LITERAL = new Lanes(ZEBRA_CROSSINGS, "ZebraCrossings", "ZebraCrossings");

	/**
	 * The '<em><b>Confluence</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONFLUENCE
	 * @generated
	 * @ordered
	 */
	public static final Lanes CONFLUENCE_LITERAL = new Lanes(CONFLUENCE, "Confluence", "Confluence");

	/**
	 * An array of all the '<em><b>Lanes</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final Lanes[] VALUES_ARRAY =
		new Lanes[] {
			NORMAL_LANE_LITERAL,
			ENTRY_LITERAL,
			EXIT_LITERAL,
			EXIT_SECTION_LITERAL,
			EMERGENCY_LANE_LITERAL,
			RUSH_HOUR_LANE_LITERAL,
			SECONDARY_ROAD_LITERAL,
			ZEBRA_CROSSINGS_LITERAL,
			CONFLUENCE_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Lanes</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Lanes</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Lanes get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Lanes result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Lanes</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Lanes getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Lanes result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Lanes</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Lanes get(int value) {
		switch (value) {
			case NORMAL_LANE: return NORMAL_LANE_LITERAL;
			case ENTRY: return ENTRY_LITERAL;
			case EXIT: return EXIT_LITERAL;
			case EXIT_SECTION: return EXIT_SECTION_LITERAL;
			case EMERGENCY_LANE: return EMERGENCY_LANE_LITERAL;
			case RUSH_HOUR_LANE: return RUSH_HOUR_LANE_LITERAL;
			case SECONDARY_ROAD: return SECONDARY_ROAD_LITERAL;
			case ZEBRA_CROSSINGS: return ZEBRA_CROSSINGS_LITERAL;
			case CONFLUENCE: return CONFLUENCE_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private Lanes(int value, String name, String literal) {
		super(value, name, literal);
	}

} //Lanes
