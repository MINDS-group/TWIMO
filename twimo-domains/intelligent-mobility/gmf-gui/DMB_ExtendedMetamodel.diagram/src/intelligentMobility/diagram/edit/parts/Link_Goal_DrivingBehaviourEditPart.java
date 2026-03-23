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
public class Link_Goal_DrivingBehaviourEditPart extends ConnectionNodeEditPart implements ITreeBranchEditPart {

	/**
	* @generated
	*/
	public static final int VISUAL_ID = 4037;

	/**
	* @generated
	*/
	public Link_Goal_DrivingBehaviourEditPart(View view) {
		super(view);
	}

	/**
	* @generated
	*/
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new intelligentMobility.diagram.edit.policies.Link_Goal_DrivingBehaviourItemSemanticEditPolicy());
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
		return new Link_Goal_DrivingBehaviourFigure();
	}

	/**
	* @generated
	*/
	public Link_Goal_DrivingBehaviourFigure getPrimaryShape() {
		return (Link_Goal_DrivingBehaviourFigure) getFigure();
	}

	/**
	 * @generated
	 */
	public class Link_Goal_DrivingBehaviourFigure extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureLink_Goal_DrivingBehaviourName_link_goal_drivingBehaviourFigure;

		/**
		 * @generated
		 */
		public Link_Goal_DrivingBehaviourFigure() {

			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureLink_Goal_DrivingBehaviourName_link_goal_drivingBehaviourFigure = new WrappingLabel();

			fFigureLink_Goal_DrivingBehaviourName_link_goal_drivingBehaviourFigure.setText("");

			this.add(fFigureLink_Goal_DrivingBehaviourName_link_goal_drivingBehaviourFigure);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureLink_Goal_DrivingBehaviourName_link_goal_drivingBehaviourFigure() {
			return fFigureLink_Goal_DrivingBehaviourName_link_goal_drivingBehaviourFigure;
		}

	}

}
