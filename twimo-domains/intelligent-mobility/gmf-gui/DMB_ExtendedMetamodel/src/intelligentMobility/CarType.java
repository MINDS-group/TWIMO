/**
 */
package intelligentMobility;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Car Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see intelligentMobility.IntelligentMobilityPackage#getCarType()
 * @model
 * @generated
 */
public final class CarType extends AbstractEnumerator {
	/**
	 * The '<em><b>Normal Car</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NORMAL_CAR_LITERAL
	 * @model name="NormalCar"
	 * @generated
	 * @ordered
	 */
	public static final int NORMAL_CAR = 0;

	/**
	 * The '<em><b>Truck</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRUCK_LITERAL
	 * @model name="Truck"
	 * @generated
	 * @ordered
	 */
	public static final int TRUCK = 1;

	/**
	 * The '<em><b>Scooter</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SCOOTER_LITERAL
	 * @model name="Scooter"
	 * @generated
	 * @ordered
	 */
	public static final int SCOOTER = 2;

	/**
	 * The '<em><b>Motorbike</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MOTORBIKE_LITERAL
	 * @model name="Motorbike"
	 * @generated
	 * @ordered
	 */
	public static final int MOTORBIKE = 3;

	/**
	 * The '<em><b>Normal Car</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NORMAL_CAR
	 * @generated
	 * @ordered
	 */
	public static final CarType NORMAL_CAR_LITERAL = new CarType(NORMAL_CAR, "NormalCar", "NormalCar");

	/**
	 * The '<em><b>Truck</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRUCK
	 * @generated
	 * @ordered
	 */
	public static final CarType TRUCK_LITERAL = new CarType(TRUCK, "Truck", "Truck");

	/**
	 * The '<em><b>Scooter</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SCOOTER
	 * @generated
	 * @ordered
	 */
	public static final CarType SCOOTER_LITERAL = new CarType(SCOOTER, "Scooter", "Scooter");

	/**
	 * The '<em><b>Motorbike</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MOTORBIKE
	 * @generated
	 * @ordered
	 */
	public static final CarType MOTORBIKE_LITERAL = new CarType(MOTORBIKE, "Motorbike", "Motorbike");

	/**
	 * An array of all the '<em><b>Car Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final CarType[] VALUES_ARRAY =
		new CarType[] {
			NORMAL_CAR_LITERAL,
			TRUCK_LITERAL,
			SCOOTER_LITERAL,
			MOTORBIKE_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Car Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Car Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static CarType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CarType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Car Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static CarType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CarType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Car Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static CarType get(int value) {
		switch (value) {
			case NORMAL_CAR: return NORMAL_CAR_LITERAL;
			case TRUCK: return TRUCK_LITERAL;
			case SCOOTER: return SCOOTER_LITERAL;
			case MOTORBIKE: return MOTORBIKE_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private CarType(int value, String name, String literal) {
		super(value, name, literal);
	}

} //CarType
