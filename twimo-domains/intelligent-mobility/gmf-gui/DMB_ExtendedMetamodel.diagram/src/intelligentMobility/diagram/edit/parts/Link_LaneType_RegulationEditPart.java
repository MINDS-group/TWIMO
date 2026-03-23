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
public class Link_LaneType_RegulationEditPart extends ConnectionNodeEditPart implements ITreeBranchEditPart {

	/**
	* @generated
	*/
	public static final int VISUAL_ID = 4001;

	/**
	* @generated
	*/
	public Link_LaneType_RegulationEditPart(View view) {
		super(view);
	}

	/**
	* @generated
	*/
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new intelligentMobility.diagram.edit.policies.Link_LaneType_RegulationItemSemanticEditPolicy());
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
		return new Link_LaneType_RegulationFigure();
	}

	/**
	* @generated
	*/
	public Link_LaneType_RegulationFigure getPrimaryShape() {
		return (Link_LaneType_RegulationFigure) getFigure();
	}

	/**
	 * @generated
	 */
	public class Link_LaneType_RegulationFigure extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureLink_LaneType_RegulationName_link_laneType_regulationFigure;

		/**
		 * @generated
		 */
		public Link_LaneType_RegulationFigure() {

			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureLink_LaneType_RegulationName_link_laneType_regulationFigure = new WrappingLabel();

			fFigureLink_LaneType_RegulationName_link_laneType_regulationFigure.setText("<...>");

			this.add(fFigureLink_LaneType_RegulationName_link_laneType_regulationFigure);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureLink_LaneType_RegulationName_link_laneType_regulationFigure() {
			return fFigureLink_LaneType_RegulationName_link_laneType_regulationFigure;
		}

	}

}
