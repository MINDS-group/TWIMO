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
public class Link_Vehicle_EnvironmentEditPart extends ConnectionNodeEditPart implements ITreeBranchEditPart {

	/**
	* @generated
	*/
	public static final int VISUAL_ID = 4004;

	/**
	* @generated
	*/
	public Link_Vehicle_EnvironmentEditPart(View view) {
		super(view);
	}

	/**
	* @generated
	*/
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new intelligentMobility.diagram.edit.policies.Link_Vehicle_EnvironmentItemSemanticEditPolicy());
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
		return new Link_Vehicle_EnvironmentFigure();
	}

	/**
	* @generated
	*/
	public Link_Vehicle_EnvironmentFigure getPrimaryShape() {
		return (Link_Vehicle_EnvironmentFigure) getFigure();
	}

	/**
	 * @generated
	 */
	public class Link_Vehicle_EnvironmentFigure extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureLink_Vehicle_EnvironmentLink_name_vehicle_environmentFigure;

		/**
		 * @generated
		 */
		public Link_Vehicle_EnvironmentFigure() {

			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureLink_Vehicle_EnvironmentLink_name_vehicle_environmentFigure = new WrappingLabel();

			fFigureLink_Vehicle_EnvironmentLink_name_vehicle_environmentFigure.setText("<...>");

			this.add(fFigureLink_Vehicle_EnvironmentLink_name_vehicle_environmentFigure);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureLink_Vehicle_EnvironmentLink_name_vehicle_environmentFigure() {
			return fFigureLink_Vehicle_EnvironmentLink_name_vehicle_environmentFigure;
		}

	}

}
