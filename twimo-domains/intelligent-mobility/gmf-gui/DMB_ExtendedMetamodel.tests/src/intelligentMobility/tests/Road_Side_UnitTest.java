/**
 */
package intelligentMobility.tests;

import intelligentMobility.IntelligentMobilityFactory;
import intelligentMobility.Road_Side_Unit;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Road Side Unit</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class Road_Side_UnitTest extends InfrastructureTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(Road_Side_UnitTest.class);
	}

	/**
	 * Constructs a new Road Side Unit test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Road_Side_UnitTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Road Side Unit test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private Road_Side_Unit getFixture() {
		return (Road_Side_Unit)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	protected void setUp() throws Exception {
		setFixture(IntelligentMobilityFactory.eINSTANCE.createRoad_Side_Unit());
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

} //Road_Side_UnitTest
