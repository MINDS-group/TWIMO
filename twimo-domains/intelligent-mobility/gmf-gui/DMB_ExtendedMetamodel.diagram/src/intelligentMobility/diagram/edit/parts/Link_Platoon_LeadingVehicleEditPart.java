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
public class Link_Platoon_LeadingVehicleEditPart extends ConnectionNodeEditPart implements ITreeBranchEditPart {

	/**
	* @generated
	*/
	public static final int VISUAL_ID = 4014;

	/**
	* @generated
	*/
	public Link_Platoon_LeadingVehicleEditPart(View view) {
		super(view);
	}

	/**
	* @generated
	*/
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new intelligentMobility.diagram.edit.policies.Link_Platoon_LeadingVehicleItemSemanticEditPolicy());
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
		return new Link_Platoon_LeadingVehicleFigure();
	}

	/**
	* @generated
	*/
	public Link_Platoon_LeadingVehicleFigure getPrimaryShape() {
		return (Link_Platoon_LeadingVehicleFigure) getFigure();
	}

	/**
	 * @generated
	 */
	public class Link_Platoon_LeadingVehicleFigure extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureLink_Platoon_LeadingVehicleName_link_platoon_leadingVehicleFigure;

		/**
		 * @generated
		 */
		public Link_Platoon_LeadingVehicleFigure() {

			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureLink_Platoon_LeadingVehicleName_link_platoon_leadingVehicleFigure = new WrappingLabel();

			fFigureLink_Platoon_LeadingVehicleName_link_platoon_leadingVehicleFigure.setText("<...>");

			this.add(fFigureLink_Platoon_LeadingVehicleName_link_platoon_leadingVehicleFigure);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureLink_Platoon_LeadingVehicleName_link_platoon_leadingVehicleFigure() {
			return fFigureLink_Platoon_LeadingVehicleName_link_platoon_leadingVehicleFigure;
		}

	}

}
