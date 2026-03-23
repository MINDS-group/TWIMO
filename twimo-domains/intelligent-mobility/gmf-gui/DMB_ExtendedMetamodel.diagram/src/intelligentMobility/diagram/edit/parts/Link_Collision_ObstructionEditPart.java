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
public class Link_Collision_ObstructionEditPart extends ConnectionNodeEditPart implements ITreeBranchEditPart {

	/**
	* @generated
	*/
	public static final int VISUAL_ID = 4007;

	/**
	* @generated
	*/
	public Link_Collision_ObstructionEditPart(View view) {
		super(view);
	}

	/**
	* @generated
	*/
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new intelligentMobility.diagram.edit.policies.Link_Collision_ObstructionItemSemanticEditPolicy());
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
		return new Link_Collision_ObstructionFigure();
	}

	/**
	* @generated
	*/
	public Link_Collision_ObstructionFigure getPrimaryShape() {
		return (Link_Collision_ObstructionFigure) getFigure();
	}

	/**
	 * @generated
	 */
	public class Link_Collision_ObstructionFigure extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureLink_Collision_ObstructionName_link_collision_obstructionFigure;

		/**
		 * @generated
		 */
		public Link_Collision_ObstructionFigure() {

			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureLink_Collision_ObstructionName_link_collision_obstructionFigure = new WrappingLabel();

			fFigureLink_Collision_ObstructionName_link_collision_obstructionFigure.setText("<...>");

			this.add(fFigureLink_Collision_ObstructionName_link_collision_obstructionFigure);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureLink_Collision_ObstructionName_link_collision_obstructionFigure() {
			return fFigureLink_Collision_ObstructionName_link_collision_obstructionFigure;
		}

	}

}
