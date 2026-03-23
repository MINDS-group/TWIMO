/**
 */
package intelligentMobility.tests;

import intelligentMobility.IntelligentMobilityFactory;
import intelligentMobility.RoadSegment;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Road Segment</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class RoadSegmentTest extends InfrastructureTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(RoadSegmentTest.class);
	}

	/**
	 * Constructs a new Road Segment test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RoadSegmentTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Road Segment test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private RoadSegment getFixture() {
		return (RoadSegment)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	protected void setUp() throws Exception {
		setFixture(IntelligentMobilityFactory.eINSTANCE.createRoadSegment());
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

} //RoadSegmentTest
