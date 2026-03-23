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
public class Link_Following_ForwardEditPart extends ConnectionNodeEditPart implements ITreeBranchEditPart {

	/**
	* @generated
	*/
	public static final int VISUAL_ID = 4011;

	/**
	* @generated
	*/
	public Link_Following_ForwardEditPart(View view) {
		super(view);
	}

	/**
	* @generated
	*/
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new intelligentMobility.diagram.edit.policies.Link_Following_ForwardItemSemanticEditPolicy());
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
		return new Link_Following_ForwardFigure();
	}

	/**
	* @generated
	*/
	public Link_Following_ForwardFigure getPrimaryShape() {
		return (Link_Following_ForwardFigure) getFigure();
	}

	/**
	 * @generated
	 */
	public class Link_Following_ForwardFigure extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureLink_Following_ForwardName_link_following_forwardFigure;

		/**
		 * @generated
		 */
		public Link_Following_ForwardFigure() {

			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureLink_Following_ForwardName_link_following_forwardFigure = new WrappingLabel();

			fFigureLink_Following_ForwardName_link_following_forwardFigure.setText("<...>");

			this.add(fFigureLink_Following_ForwardName_link_following_forwardFigure);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureLink_Following_ForwardName_link_following_forwardFigure() {
			return fFigureLink_Following_ForwardName_link_following_forwardFigure;
		}

	}

}
