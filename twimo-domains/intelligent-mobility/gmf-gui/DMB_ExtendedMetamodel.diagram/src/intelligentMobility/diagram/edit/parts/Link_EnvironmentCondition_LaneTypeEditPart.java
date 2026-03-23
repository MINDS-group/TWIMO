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
public class Link_EnvironmentCondition_LaneTypeEditPart extends ConnectionNodeEditPart implements ITreeBranchEditPart {

	/**
	* @generated
	*/
	public static final int VISUAL_ID = 4012;

	/**
	* @generated
	*/
	public Link_EnvironmentCondition_LaneTypeEditPart(View view) {
		super(view);
	}

	/**
	* @generated
	*/
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new intelligentMobility.diagram.edit.policies.Link_EnvironmentCondition_LaneTypeItemSemanticEditPolicy());
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
		return new Link_EnvironmentCondition_LaneTypeFigure();
	}

	/**
	* @generated
	*/
	public Link_EnvironmentCondition_LaneTypeFigure getPrimaryShape() {
		return (Link_EnvironmentCondition_LaneTypeFigure) getFigure();
	}

	/**
	 * @generated
	 */
	public class Link_EnvironmentCondition_LaneTypeFigure extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureLink_EnvironmentCondition_LaneTypeName_link_environmentCondition_laneTypeFigure;

		/**
		 * @generated
		 */
		public Link_EnvironmentCondition_LaneTypeFigure() {

			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureLink_EnvironmentCondition_LaneTypeName_link_environmentCondition_laneTypeFigure = new WrappingLabel();

			fFigureLink_EnvironmentCondition_LaneTypeName_link_environmentCondition_laneTypeFigure.setText("<...>");

			this.add(fFigureLink_EnvironmentCondition_LaneTypeName_link_environmentCondition_laneTypeFigure);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureLink_EnvironmentCondition_LaneTypeName_link_environmentCondition_laneTypeFigure() {
			return fFigureLink_EnvironmentCondition_LaneTypeName_link_environmentCondition_laneTypeFigure;
		}

	}

}
