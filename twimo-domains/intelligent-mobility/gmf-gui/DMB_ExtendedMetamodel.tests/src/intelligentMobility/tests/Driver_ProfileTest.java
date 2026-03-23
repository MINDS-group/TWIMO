/**
 */
package intelligentMobility.tests;

import intelligentMobility.Driver_Profile;
import intelligentMobility.IntelligentMobilityFactory;

import junit.framework.TestCase;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Driver Profile</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class Driver_ProfileTest extends TestCase {

	/**
	 * The fixture for this Driver Profile test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Driver_Profile fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(Driver_ProfileTest.class);
	}

	/**
	 * Constructs a new Driver Profile test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Driver_ProfileTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Driver Profile test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Driver_Profile fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Driver Profile test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private Driver_Profile getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	protected void setUp() throws Exception {
		setFixture(IntelligentMobilityFactory.eINSTANCE.createDriver_Profile());
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

} //Driver_ProfileTest
