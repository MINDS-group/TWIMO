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
public class Link_NormalVehicle_SafetyRequirementsEditPart extends ConnectionNodeEditPart
		implements ITreeBranchEditPart {

	/**
	* @generated
	*/
	public static final int VISUAL_ID = 4005;

	/**
	* @generated
	*/
	public Link_NormalVehicle_SafetyRequirementsEditPart(View view) {
		super(view);
	}

	/**
	* @generated
	*/
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new intelligentMobility.diagram.edit.policies.Link_NormalVehicle_SafetyRequirementsItemSemanticEditPolicy());
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
		return new Link_NormalVehicle_SafetyRequirementsFigure();
	}

	/**
	* @generated
	*/
	public Link_NormalVehicle_SafetyRequirementsFigure getPrimaryShape() {
		return (Link_NormalVehicle_SafetyRequirementsFigure) getFigure();
	}

	/**
	 * @generated
	 */
	public class Link_NormalVehicle_SafetyRequirementsFigure extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureLink_NormalVehicle_SafetyRequirementsName_link_normalVehicle_safetyRequirementFigure;

		/**
		 * @generated
		 */
		public Link_NormalVehicle_SafetyRequirementsFigure() {

			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureLink_NormalVehicle_SafetyRequirementsName_link_normalVehicle_safetyRequirementFigure = new WrappingLabel();

			fFigureLink_NormalVehicle_SafetyRequirementsName_link_normalVehicle_safetyRequirementFigure
					.setText("<...>");

			this.add(fFigureLink_NormalVehicle_SafetyRequirementsName_link_normalVehicle_safetyRequirementFigure);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureLink_NormalVehicle_SafetyRequirementsName_link_normalVehicle_safetyRequirementFigure() {
			return fFigureLink_NormalVehicle_SafetyRequirementsName_link_normalVehicle_safetyRequirementFigure;
		}

	}

}
