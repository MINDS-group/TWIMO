package intelligentMobility.diagram.edit.parts;

import org.eclipse.draw2d.Connection;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class Link_DriverPreference_DrivingBehaviourEditPart extends ConnectionNodeEditPart
		implements ITreeBranchEditPart {

	/**
	* @generated
	*/
	public static final int VISUAL_ID = 4022;

	/**
	* @generated
	*/
	public Link_DriverPreference_DrivingBehaviourEditPart(View view) {
		super(view);
	}

	/**
	* @generated
	*/
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new intelligentMobility.diagram.edit.policies.Link_DriverPreference_DrivingBehaviourItemSemanticEditPolicy());
	}

	/**
	* Creates figure for this edit part.
	* 
	* Body of this method does not depend on settings in generation model
	* so you may safely remove <i>generated</i> tag and modify it.
	* 
	* @generated
	*/

	protected Connection createConnectionFigure() {
		return new Link_DriverPreference_DrivingBehaviourFigure();
	}

	/**
	* @generated
	*/
	public Link_DriverPreference_DrivingBehaviourFigure getPrimaryShape() {
		return (Link_DriverPreference_DrivingBehaviourFigure) getFigure();
	}

	/**
	 * @generated
	 */
	public class Link_DriverPreference_DrivingBehaviourFigure extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureLink_DriverPreference_DrivingBehaviourName_link_preference_behaviourFigure;

		/**
		 * @generated
		 */
		public Link_DriverPreference_DrivingBehaviourFigure() {

			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureLink_DriverPreference_DrivingBehaviourName_link_preference_behaviourFigure = new WrappingLabel();

			fFigureLink_DriverPreference_DrivingBehaviourName_link_preference_behaviourFigure.setText("<...>");

			this.add(fFigureLink_DriverPreference_DrivingBehaviourName_link_preference_behaviourFigure);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureLink_DriverPreference_DrivingBehaviourName_link_preference_behaviourFigure() {
			return fFigureLink_DriverPreference_DrivingBehaviourName_link_preference_behaviourFigure;
		}

	}

}
