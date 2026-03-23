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
public class Link_AbnormalBehaviour_ActionEditPart extends ConnectionNodeEditPart implements ITreeBranchEditPart {

	/**
	* @generated
	*/
	public static final int VISUAL_ID = 4010;

	/**
	* @generated
	*/
	public Link_AbnormalBehaviour_ActionEditPart(View view) {
		super(view);
	}

	/**
	* @generated
	*/
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new intelligentMobility.diagram.edit.policies.Link_AbnormalBehaviour_ActionItemSemanticEditPolicy());
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
		return new Link_AbnormalBehaviour_ActionFigure();
	}

	/**
	* @generated
	*/
	public Link_AbnormalBehaviour_ActionFigure getPrimaryShape() {
		return (Link_AbnormalBehaviour_ActionFigure) getFigure();
	}

	/**
	 * @generated
	 */
	public class Link_AbnormalBehaviour_ActionFigure extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureLink_AbnormalBehaviour_ActionName_link_abnormalBehaviour_actionFigure;

		/**
		 * @generated
		 */
		public Link_AbnormalBehaviour_ActionFigure() {

			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureLink_AbnormalBehaviour_ActionName_link_abnormalBehaviour_actionFigure = new WrappingLabel();

			fFigureLink_AbnormalBehaviour_ActionName_link_abnormalBehaviour_actionFigure.setText("<...>");

			this.add(fFigureLink_AbnormalBehaviour_ActionName_link_abnormalBehaviour_actionFigure);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureLink_AbnormalBehaviour_ActionName_link_abnormalBehaviour_actionFigure() {
			return fFigureLink_AbnormalBehaviour_ActionName_link_abnormalBehaviour_actionFigure;
		}

	}

}
