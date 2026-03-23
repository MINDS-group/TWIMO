/**
 */
package intelligentMobility.tests;

import intelligentMobility.IntelligentMobilityFactory;
import intelligentMobility.Platoon;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Platoon</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class PlatoonTest extends Vehicle_TypeTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(PlatoonTest.class);
	}

	/**
	 * Constructs a new Platoon test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PlatoonTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Platoon test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private Platoon getFixture() {
		return (Platoon)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	protected void setUp() throws Exception {
		setFixture(IntelligentMobilityFactory.eINSTANCE.createPlatoon());
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

} //PlatoonTest
