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
public class Link_Following_LaneChangingEditPart extends ConnectionNodeEditPart implements ITreeBranchEditPart {

	/**
	* @generated
	*/
	public static final int VISUAL_ID = 4043;

	/**
	* @generated
	*/
	public Link_Following_LaneChangingEditPart(View view) {
		super(view);
	}

	/**
	* @generated
	*/
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new intelligentMobility.diagram.edit.policies.Link_Following_LaneChangingItemSemanticEditPolicy());
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
		return new Link_Following_LaneChangingFigure();
	}

	/**
	* @generated
	*/
	public Link_Following_LaneChangingFigure getPrimaryShape() {
		return (Link_Following_LaneChangingFigure) getFigure();
	}

	/**
	 * @generated
	 */
	public class Link_Following_LaneChangingFigure extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureLink_Following_LaneChangingName_link_following_laneChangingFigure;

		/**
		 * @generated
		 */
		public Link_Following_LaneChangingFigure() {

			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureLink_Following_LaneChangingName_link_following_laneChangingFigure = new WrappingLabel();

			fFigureLink_Following_LaneChangingName_link_following_laneChangingFigure.setText("<...>");

			this.add(fFigureLink_Following_LaneChangingName_link_following_laneChangingFigure);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureLink_Following_LaneChangingName_link_following_laneChangingFigure() {
			return fFigureLink_Following_LaneChangingName_link_following_laneChangingFigure;
		}

	}

}
