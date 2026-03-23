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
public class Link_EnvironmentBackground_PossibleVehicleEditPart extends ConnectionNodeEditPart
		implements ITreeBranchEditPart {

	/**
	* @generated
	*/
	public static final int VISUAL_ID = 4003;

	/**
	* @generated
	*/
	public Link_EnvironmentBackground_PossibleVehicleEditPart(View view) {
		super(view);
	}

	/**
	* @generated
	*/
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new intelligentMobility.diagram.edit.policies.Link_EnvironmentBackground_PossibleVehicleItemSemanticEditPolicy());
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
		return new Link_EnvironmentBackground_PossibleVehicleFigure();
	}

	/**
	* @generated
	*/
	public Link_EnvironmentBackground_PossibleVehicleFigure getPrimaryShape() {
		return (Link_EnvironmentBackground_PossibleVehicleFigure) getFigure();
	}

	/**
	 * @generated
	 */
	public class Link_EnvironmentBackground_PossibleVehicleFigure extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureLink_EnvironmentBackground_PossibleVehicleName_link_background_possibleVehicleFigure;

		/**
		 * @generated
		 */
		public Link_EnvironmentBackground_PossibleVehicleFigure() {

			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureLink_EnvironmentBackground_PossibleVehicleName_link_background_possibleVehicleFigure = new WrappingLabel();

			fFigureLink_EnvironmentBackground_PossibleVehicleName_link_background_possibleVehicleFigure
					.setText("<...>");

			this.add(fFigureLink_EnvironmentBackground_PossibleVehicleName_link_background_possibleVehicleFigure);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureLink_EnvironmentBackground_PossibleVehicleName_link_background_possibleVehicleFigure() {
			return fFigureLink_EnvironmentBackground_PossibleVehicleName_link_background_possibleVehicleFigure;
		}

	}

}
