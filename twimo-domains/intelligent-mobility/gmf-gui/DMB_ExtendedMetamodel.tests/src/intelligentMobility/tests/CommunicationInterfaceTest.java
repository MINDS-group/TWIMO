/**
 */
package intelligentMobility.tests;

import intelligentMobility.CommunicationInterface;
import intelligentMobility.IntelligentMobilityFactory;

import junit.framework.TestCase;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Communication Interface</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class CommunicationInterfaceTest extends TestCase {

	/**
	 * The fixture for this Communication Interface test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CommunicationInterface fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(CommunicationInterfaceTest.class);
	}

	/**
	 * Constructs a new Communication Interface test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CommunicationInterfaceTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Communication Interface test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(CommunicationInterface fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Communication Interface test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private CommunicationInterface getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	protected void setUp() throws Exception {
		setFixture(IntelligentMobilityFactory.eINSTANCE.createCommunicationInterface());
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

} //CommunicationInterfaceTest
