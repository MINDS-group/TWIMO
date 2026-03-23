/**
 */
package intelligentMobility.tests;

import intelligentMobility.Following_Vehicle;
import intelligentMobility.IntelligentMobilityFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Following Vehicle</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class Following_VehicleTest extends PlatoonMemberTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(Following_VehicleTest.class);
	}

	/**
	 * Constructs a new Following Vehicle test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Following_VehicleTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Following Vehicle test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private Following_Vehicle getFixture() {
		return (Following_Vehicle)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	protected void setUp() throws Exception {
		setFixture(IntelligentMobilityFactory.eINSTANCE.createFollowing_Vehicle());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //Following_VehicleTest
