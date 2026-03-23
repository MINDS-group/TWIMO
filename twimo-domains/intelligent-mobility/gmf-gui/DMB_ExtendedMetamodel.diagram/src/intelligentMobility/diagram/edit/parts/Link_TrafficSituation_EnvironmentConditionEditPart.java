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
public class Link_TrafficSituation_EnvironmentConditionEditPart extends ConnectionNodeEditPart
		implements ITreeBranchEditPart {

	/**
	* @generated
	*/
	public static final int VISUAL_ID = 4041;

	/**
	* @generated
	*/
	public Link_TrafficSituation_EnvironmentConditionEditPart(View view) {
		super(view);
	}

	/**
	* @generated
	*/
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new intelligentMobility.diagram.edit.policies.Link_TrafficSituation_EnvironmentConditionItemSemanticEditPolicy());
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
		return new Link_TrafficSituation_EnvironmentConditionFigure();
	}

	/**
	* @generated
	*/
	public Link_TrafficSituation_EnvironmentConditionFigure getPrimaryShape() {
		return (Link_TrafficSituation_EnvironmentConditionFigure) getFigure();
	}

	/**
	 * @generated
	 */
	public class Link_TrafficSituation_EnvironmentConditionFigure extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		private PolylineConnectionEx fFigureLink_TrafficSituation_EnvironmentConditionFigure;

		/**
		 * @generated
		 */
		public Link_TrafficSituation_EnvironmentConditionFigure() {

			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			WrappingLabel link_TrafficSituation_EnvironmentConditionName_link_trafficSituation_environmentConditionFigure0 = new WrappingLabel();

			link_TrafficSituation_EnvironmentConditionName_link_trafficSituation_environmentConditionFigure0
					.setText("<...>");

			this.add(link_TrafficSituation_EnvironmentConditionName_link_trafficSituation_environmentConditionFigure0);

		}

		/**
		 * @generated
		 */
		public PolylineConnectionEx getFigureLink_TrafficSituation_EnvironmentConditionFigure() {
			return fFigureLink_TrafficSituation_EnvironmentConditionFigure;
		}

	}

}
