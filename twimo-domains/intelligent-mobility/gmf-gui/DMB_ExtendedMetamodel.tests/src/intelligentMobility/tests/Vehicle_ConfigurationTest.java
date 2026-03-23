/**
 */
package intelligentMobility.tests;

import intelligentMobility.IntelligentMobilityFactory;
import intelligentMobility.Vehicle_Configuration;

import junit.framework.TestCase;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Vehicle Configuration</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class Vehicle_ConfigurationTest extends TestCase {

	/**
	 * The fixture for this Vehicle Configuration test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Vehicle_Configuration fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(Vehicle_ConfigurationTest.class);
	}

	/**
	 * Constructs a new Vehicle Configuration test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Vehicle_ConfigurationTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Vehicle Configuration test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Vehicle_Configuration fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Vehicle Configuration test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private Vehicle_Configuration getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	protected void setUp() throws Exception {
		setFixture(IntelligentMobilityFactory.eINSTANCE.createVehicle_Configuration());
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

} //Vehicle_ConfigurationTest
