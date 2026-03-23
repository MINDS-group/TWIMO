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
public class Link_EnvironmentCondition_TrafficConditionEditPart extends ConnectionNodeEditPart
		implements ITreeBranchEditPart {

	/**
	* @generated
	*/
	public static final int VISUAL_ID = 4017;

	/**
	* @generated
	*/
	public Link_EnvironmentCondition_TrafficConditionEditPart(View view) {
		super(view);
	}

	/**
	* @generated
	*/
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new intelligentMobility.diagram.edit.policies.Link_EnvironmentCondition_TrafficConditionItemSemanticEditPolicy());
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
		return new Link_EnvironmentCondition_TrafficConditionFigure();
	}

	/**
	* @generated
	*/
	public Link_EnvironmentCondition_TrafficConditionFigure getPrimaryShape() {
		return (Link_EnvironmentCondition_TrafficConditionFigure) getFigure();
	}

	/**
	 * @generated
	 */
	public class Link_EnvironmentCondition_TrafficConditionFigure extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureLink_EnvironmentCondition_TrafficConditionName_link_environmentCondition_trafficConditionFigure;

		/**
		 * @generated
		 */
		public Link_EnvironmentCondition_TrafficConditionFigure() {

			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureLink_EnvironmentCondition_TrafficConditionName_link_environmentCondition_trafficConditionFigure = new WrappingLabel();

			fFigureLink_EnvironmentCondition_TrafficConditionName_link_environmentCondition_trafficConditionFigure
					.setText("<...>");

			this.add(
					fFigureLink_EnvironmentCondition_TrafficConditionName_link_environmentCondition_trafficConditionFigure);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureLink_EnvironmentCondition_TrafficConditionName_link_environmentCondition_trafficConditionFigure() {
			return fFigureLink_EnvironmentCondition_TrafficConditionName_link_environmentCondition_trafficConditionFigure;
		}

	}

}
