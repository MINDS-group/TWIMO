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
public class Link_Infrastructure_VehicleConfigurationEditPart extends ConnectionNodeEditPart
		implements ITreeBranchEditPart {

	/**
	* @generated
	*/
	public static final int VISUAL_ID = 4035;

	/**
	* @generated
	*/
	public Link_Infrastructure_VehicleConfigurationEditPart(View view) {
		super(view);
	}

	/**
	* @generated
	*/
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new intelligentMobility.diagram.edit.policies.Link_Infrastructure_VehicleConfigurationItemSemanticEditPolicy());
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
		return new Link_Infrastructure_VehicleConfigurationFigure();
	}

	/**
	* @generated
	*/
	public Link_Infrastructure_VehicleConfigurationFigure getPrimaryShape() {
		return (Link_Infrastructure_VehicleConfigurationFigure) getFigure();
	}

	/**
	 * @generated
	 */
	public class Link_Infrastructure_VehicleConfigurationFigure extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		private WrappingLabel fLink_Infrastructure_VehicleConfigurationName_link_infrastructure_vehicleConfigurationFigure;

		/**
		 * @generated
		 */
		public Link_Infrastructure_VehicleConfigurationFigure() {

			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fLink_Infrastructure_VehicleConfigurationName_link_infrastructure_vehicleConfigurationFigure = new WrappingLabel();

			fLink_Infrastructure_VehicleConfigurationName_link_infrastructure_vehicleConfigurationFigure.setText("");

			this.add(fLink_Infrastructure_VehicleConfigurationName_link_infrastructure_vehicleConfigurationFigure);

		}

		/**
		 * @generated
		 */
		public WrappingLabel Link_Infrastructure_VehicleConfigurationName_link_infrastructure_vehicleConfigurationFigure() {
			return fLink_Infrastructure_VehicleConfigurationName_link_infrastructure_vehicleConfigurationFigure;
		}

	}

}
