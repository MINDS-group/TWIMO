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
public class Link_DrivingBehaviour_NormalBehaviourEditPart extends ConnectionNodeEditPart
		implements ITreeBranchEditPart {

	/**
	* @generated
	*/
	public static final int VISUAL_ID = 4031;

	/**
	* @generated
	*/
	public Link_DrivingBehaviour_NormalBehaviourEditPart(View view) {
		super(view);
	}

	/**
	* @generated
	*/
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new intelligentMobility.diagram.edit.policies.Link_DrivingBehaviour_NormalBehaviourItemSemanticEditPolicy());
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
		return new Link_DrivingBehaviour_NormalBehaviourFigure();
	}

	/**
	* @generated
	*/
	public Link_DrivingBehaviour_NormalBehaviourFigure getPrimaryShape() {
		return (Link_DrivingBehaviour_NormalBehaviourFigure) getFigure();
	}

	/**
	 * @generated
	 */
	public class Link_DrivingBehaviour_NormalBehaviourFigure extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureLink_DrivingBehaviour_NormalBehaviourName_link_driving_normalFigure;

		/**
		 * @generated
		 */
		public Link_DrivingBehaviour_NormalBehaviourFigure() {

			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureLink_DrivingBehaviour_NormalBehaviourName_link_driving_normalFigure = new WrappingLabel();

			fFigureLink_DrivingBehaviour_NormalBehaviourName_link_driving_normalFigure.setText("<...>");

			this.add(fFigureLink_DrivingBehaviour_NormalBehaviourName_link_driving_normalFigure);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureLink_DrivingBehaviour_NormalBehaviourName_link_driving_normalFigure() {
			return fFigureLink_DrivingBehaviour_NormalBehaviourName_link_driving_normalFigure;
		}

	}

}
