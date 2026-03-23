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
public class Link_CooperativeBehaviour_VehicleConfigurationEditPart extends ConnectionNodeEditPart
		implements ITreeBranchEditPart {

	/**
	* @generated
	*/
	public static final int VISUAL_ID = 4040;

	/**
	* @generated
	*/
	public Link_CooperativeBehaviour_VehicleConfigurationEditPart(View view) {
		super(view);
	}

	/**
	* @generated
	*/
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new intelligentMobility.diagram.edit.policies.Link_CooperativeBehaviour_VehicleConfigurationItemSemanticEditPolicy());
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
		return new Link_CooperativeBehaviour_VehicleConfigurationFigure();
	}

	/**
	* @generated
	*/
	public Link_CooperativeBehaviour_VehicleConfigurationFigure getPrimaryShape() {
		return (Link_CooperativeBehaviour_VehicleConfigurationFigure) getFigure();
	}

	/**
	 * @generated
	 */
	public class Link_CooperativeBehaviour_VehicleConfigurationFigure extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureLink_CooperativeBehaviour_VehicleConfigurationName_link_cooperativeBehaviour_vehicleConfigurationFigure;

		/**
		 * @generated
		 */
		public Link_CooperativeBehaviour_VehicleConfigurationFigure() {

			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureLink_CooperativeBehaviour_VehicleConfigurationName_link_cooperativeBehaviour_vehicleConfigurationFigure = new WrappingLabel();

			fFigureLink_CooperativeBehaviour_VehicleConfigurationName_link_cooperativeBehaviour_vehicleConfigurationFigure
					.setText("");

			this.add(
					fFigureLink_CooperativeBehaviour_VehicleConfigurationName_link_cooperativeBehaviour_vehicleConfigurationFigure);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureLink_CooperativeBehaviour_VehicleConfigurationName_link_cooperativeBehaviour_vehicleConfigurationFigure() {
			return fFigureLink_CooperativeBehaviour_VehicleConfigurationName_link_cooperativeBehaviour_vehicleConfigurationFigure;
		}

	}

}
