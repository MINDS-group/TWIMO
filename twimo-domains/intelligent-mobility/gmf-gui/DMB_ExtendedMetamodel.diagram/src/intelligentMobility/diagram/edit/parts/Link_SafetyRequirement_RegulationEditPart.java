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
public class Link_SafetyRequirement_RegulationEditPart extends ConnectionNodeEditPart implements ITreeBranchEditPart {

	/**
	* @generated
	*/
	public static final int VISUAL_ID = 4021;

	/**
	* @generated
	*/
	public Link_SafetyRequirement_RegulationEditPart(View view) {
		super(view);
	}

	/**
	* @generated
	*/
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new intelligentMobility.diagram.edit.policies.Link_SafetyRequirement_RegulationItemSemanticEditPolicy());
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
		return new Link_SafetyRequirement_RegulationFigure();
	}

	/**
	* @generated
	*/
	public Link_SafetyRequirement_RegulationFigure getPrimaryShape() {
		return (Link_SafetyRequirement_RegulationFigure) getFigure();
	}

	/**
	 * @generated
	 */
	public class Link_SafetyRequirement_RegulationFigure extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureLink_SafetyRequirement_RegulationName_link_safetyRequirement_regulationFigure;

		/**
		 * @generated
		 */
		public Link_SafetyRequirement_RegulationFigure() {

			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureLink_SafetyRequirement_RegulationName_link_safetyRequirement_regulationFigure = new WrappingLabel();

			fFigureLink_SafetyRequirement_RegulationName_link_safetyRequirement_regulationFigure.setText("<...>");

			this.add(fFigureLink_SafetyRequirement_RegulationName_link_safetyRequirement_regulationFigure);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureLink_SafetyRequirement_RegulationName_link_safetyRequirement_regulationFigure() {
			return fFigureLink_SafetyRequirement_RegulationName_link_safetyRequirement_regulationFigure;
		}

	}

}
