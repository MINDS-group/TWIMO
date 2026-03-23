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
public class Link_Action_ForwardEditPart extends ConnectionNodeEditPart implements ITreeBranchEditPart {

	/**
	* @generated
	*/
	public static final int VISUAL_ID = 4045;

	/**
	* @generated
	*/
	public Link_Action_ForwardEditPart(View view) {
		super(view);
	}

	/**
	* @generated
	*/
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new intelligentMobility.diagram.edit.policies.Link_Action_ForwardItemSemanticEditPolicy());
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
		return new Link_Action_ForwardFigure();
	}

	/**
	* @generated
	*/
	public Link_Action_ForwardFigure getPrimaryShape() {
		return (Link_Action_ForwardFigure) getFigure();
	}

	/**
	 * @generated
	 */
	public class Link_Action_ForwardFigure extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureLink_Action_ForwardName_link_action_forwardFigure;

		/**
		 * @generated
		 */
		public Link_Action_ForwardFigure() {

			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureLink_Action_ForwardName_link_action_forwardFigure = new WrappingLabel();

			fFigureLink_Action_ForwardName_link_action_forwardFigure.setText("<...>");

			this.add(fFigureLink_Action_ForwardName_link_action_forwardFigure);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureLink_Action_ForwardName_link_action_forwardFigure() {
			return fFigureLink_Action_ForwardName_link_action_forwardFigure;
		}

	}

}
