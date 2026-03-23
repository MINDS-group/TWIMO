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
public class Link_Action_TurnEditPart extends ConnectionNodeEditPart implements ITreeBranchEditPart {

	/**
	* @generated
	*/
	public static final int VISUAL_ID = 4046;

	/**
	* @generated
	*/
	public Link_Action_TurnEditPart(View view) {
		super(view);
	}

	/**
	* @generated
	*/
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new intelligentMobility.diagram.edit.policies.Link_Action_TurnItemSemanticEditPolicy());
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
		return new Link_Action_TurnFigure();
	}

	/**
	* @generated
	*/
	public Link_Action_TurnFigure getPrimaryShape() {
		return (Link_Action_TurnFigure) getFigure();
	}

	/**
	 * @generated
	 */
	public class Link_Action_TurnFigure extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureLink_Action_TurnName_link_action_turnFigure;

		/**
		 * @generated
		 */
		public Link_Action_TurnFigure() {

			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureLink_Action_TurnName_link_action_turnFigure = new WrappingLabel();

			fFigureLink_Action_TurnName_link_action_turnFigure.setText("<...>");

			this.add(fFigureLink_Action_TurnName_link_action_turnFigure);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureLink_Action_TurnName_link_action_turnFigure() {
			return fFigureLink_Action_TurnName_link_action_turnFigure;
		}

	}

}
