/**
 */
package intelligentMobility.tests;

import intelligentMobility.CooperativeBehavior;
import intelligentMobility.IntelligentMobilityFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Cooperative Behavior</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class CooperativeBehaviorTest extends Driving_BehaviourTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(CooperativeBehaviorTest.class);
	}

	/**
	 * Constructs a new Cooperative Behavior test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CooperativeBehaviorTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Cooperative Behavior test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private CooperativeBehavior getFixture() {
		return (CooperativeBehavior)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	protected void setUp() throws Exception {
		setFixture(IntelligentMobilityFactory.eINSTANCE.createCooperativeBehavior());
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

} //CooperativeBehaviorTest
