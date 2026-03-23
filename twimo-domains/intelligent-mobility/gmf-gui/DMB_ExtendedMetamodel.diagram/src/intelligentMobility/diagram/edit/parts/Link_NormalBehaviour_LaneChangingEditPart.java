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
public class Link_NormalBehaviour_LaneChangingEditPart extends ConnectionNodeEditPart implements ITreeBranchEditPart {

	/**
	* @generated
	*/
	public static final int VISUAL_ID = 4020;

	/**
	* @generated
	*/
	public Link_NormalBehaviour_LaneChangingEditPart(View view) {
		super(view);
	}

	/**
	* @generated
	*/
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new intelligentMobility.diagram.edit.policies.Link_NormalBehaviour_LaneChangingItemSemanticEditPolicy());
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
		return new Link_NormalBehaviour_LaneChangingFigure();
	}

	/**
	* @generated
	*/
	public Link_NormalBehaviour_LaneChangingFigure getPrimaryShape() {
		return (Link_NormalBehaviour_LaneChangingFigure) getFigure();
	}

	/**
	 * @generated
	 */
	public class Link_NormalBehaviour_LaneChangingFigure extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureLink_NormalBehaviour_LaneChangingName_link_behaviour_laneChangingFigure;

		/**
		 * @generated
		 */
		public Link_NormalBehaviour_LaneChangingFigure() {

			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureLink_NormalBehaviour_LaneChangingName_link_behaviour_laneChangingFigure = new WrappingLabel();

			fFigureLink_NormalBehaviour_LaneChangingName_link_behaviour_laneChangingFigure.setText("<...>");

			this.add(fFigureLink_NormalBehaviour_LaneChangingName_link_behaviour_laneChangingFigure);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureLink_NormalBehaviour_LaneChangingName_link_behaviour_laneChangingFigure() {
			return fFigureLink_NormalBehaviour_LaneChangingName_link_behaviour_laneChangingFigure;
		}

	}

}
