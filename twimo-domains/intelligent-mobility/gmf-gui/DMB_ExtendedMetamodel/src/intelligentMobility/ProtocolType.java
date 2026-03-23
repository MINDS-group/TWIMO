/**
 */
package intelligentMobility;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Protocol Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see intelligentMobility.IntelligentMobilityPackage#getProtocolType()
 * @model
 * @generated
 */
public final class ProtocolType extends AbstractEnumerator {
	/**
	 * The '<em><b>Cinque G</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CINQUE_G_LITERAL
	 * @model name="CinqueG"
	 * @generated
	 * @ordered
	 */
	public static final int CINQUE_G = 0;

	/**
	 * The '<em><b>CV2X</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CV2X_LITERAL
	 * @model name="C_V2X"
	 * @generated
	 * @ordered
	 */
	public static final int CV2X = 2;

	/**
	 * The '<em><b>DSRC</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DSRC_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DSRC = 0;

	/**
	 * The '<em><b>Cinque G</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CINQUE_G
	 * @generated
	 * @ordered
	 */
	public static final ProtocolType CINQUE_G_LITERAL = new ProtocolType(CINQUE_G, "CinqueG", "CinqueG");

	/**
	 * The '<em><b>CV2X</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CV2X
	 * @generated
	 * @ordered
	 */
	public static final ProtocolType CV2X_LITERAL = new ProtocolType(CV2X, "C_V2X", "C_V2X");

	/**
	 * The '<em><b>DSRC</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DSRC
	 * @generated
	 * @ordered
	 */
	public static final ProtocolType DSRC_LITERAL = new ProtocolType(DSRC, "DSRC", "DSRC");

	/**
	 * An array of all the '<em><b>Protocol Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ProtocolType[] VALUES_ARRAY =
		new ProtocolType[] {
			CINQUE_G_LITERAL,
			CV2X_LITERAL,
			DSRC_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Protocol Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Protocol Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ProtocolType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ProtocolType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Protocol Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ProtocolType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ProtocolType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Protocol Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ProtocolType get(int value) {
		switch (value) {
			case CINQUE_G: return CINQUE_G_LITERAL;
			case CV2X: return CV2X_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private ProtocolType(int value, String name, String literal) {
		super(value, name, literal);
	}

} //ProtocolType
