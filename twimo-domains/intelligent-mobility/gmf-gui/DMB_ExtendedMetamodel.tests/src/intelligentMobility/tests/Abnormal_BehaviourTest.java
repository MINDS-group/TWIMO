/**
 */
package intelligentMobility.tests;

import intelligentMobility.Abnormal_Behaviour;
import intelligentMobility.IntelligentMobilityFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Abnormal Behaviour</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class Abnormal_BehaviourTest extends Normal_BehaviourTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(Abnormal_BehaviourTest.class);
	}

	/**
	 * Constructs a new Abnormal Behaviour test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Abnormal_BehaviourTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Abnormal Behaviour test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private Abnormal_Behaviour getFixture() {
		return (Abnormal_Behaviour)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	protected void setUp() throws Exception {
		setFixture(IntelligentMobilityFactory.eINSTANCE.createAbnormal_Behaviour());
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

} //Abnormal_BehaviourTest
