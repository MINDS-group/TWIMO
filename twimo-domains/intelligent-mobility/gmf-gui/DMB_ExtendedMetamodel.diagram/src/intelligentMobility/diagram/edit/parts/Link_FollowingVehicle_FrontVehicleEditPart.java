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
public class Link_FollowingVehicle_FrontVehicleEditPart extends ConnectionNodeEditPart implements ITreeBranchEditPart {

	/**
	* @generated
	*/
	public static final int VISUAL_ID = 4023;

	/**
	* @generated
	*/
	public Link_FollowingVehicle_FrontVehicleEditPart(View view) {
		super(view);
	}

	/**
	* @generated
	*/
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new intelligentMobility.diagram.edit.policies.Link_FollowingVehicle_FrontVehicleItemSemanticEditPolicy());
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
		return new Link_FollowingVehicle_FrontVehicleFigure();
	}

	/**
	* @generated
	*/
	public Link_FollowingVehicle_FrontVehicleFigure getPrimaryShape() {
		return (Link_FollowingVehicle_FrontVehicleFigure) getFigure();
	}

	/**
	 * @generated
	 */
	public class Link_FollowingVehicle_FrontVehicleFigure extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureLink_FollowingVehicle_FrontVehicleName_link_followingVehicle_frontVehicleFigure;

		/**
		 * @generated
		 */
		public Link_FollowingVehicle_FrontVehicleFigure() {

			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureLink_FollowingVehicle_FrontVehicleName_link_followingVehicle_frontVehicleFigure = new WrappingLabel();

			fFigureLink_FollowingVehicle_FrontVehicleName_link_followingVehicle_frontVehicleFigure.setText("<...>");

			this.add(fFigureLink_FollowingVehicle_FrontVehicleName_link_followingVehicle_frontVehicleFigure);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureLink_FollowingVehicle_FrontVehicleName_link_followingVehicle_frontVehicleFigure() {
			return fFigureLink_FollowingVehicle_FrontVehicleName_link_followingVehicle_frontVehicleFigure;
		}

	}

}
