/**
 */
package intelligentMobility.tests;

import intelligentMobility.IntelligentMobilityFactory;
import intelligentMobility.MobilitySystem;

import junit.framework.TestCase;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Mobility System</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class MobilitySystemTest extends TestCase {

	/**
	 * The fixture for this Mobility System test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MobilitySystem fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(MobilitySystemTest.class);
	}

	/**
	 * Constructs a new Mobility System test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MobilitySystemTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Mobility System test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(MobilitySystem fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Mobility System test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private MobilitySystem getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	protected void setUp() throws Exception {
		setFixture(IntelligentMobilityFactory.eINSTANCE.createMobilitySystem());
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

} //MobilitySystemTest
