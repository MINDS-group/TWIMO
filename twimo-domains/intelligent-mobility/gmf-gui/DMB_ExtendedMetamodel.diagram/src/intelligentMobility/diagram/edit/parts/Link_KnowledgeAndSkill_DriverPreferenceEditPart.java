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
public class Link_KnowledgeAndSkill_DriverPreferenceEditPart extends ConnectionNodeEditPart
		implements ITreeBranchEditPart {

	/**
	* @generated
	*/
	public static final int VISUAL_ID = 4047;

	/**
	* @generated
	*/
	public Link_KnowledgeAndSkill_DriverPreferenceEditPart(View view) {
		super(view);
	}

	/**
	* @generated
	*/
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new intelligentMobility.diagram.edit.policies.Link_KnowledgeAndSkill_DriverPreferenceItemSemanticEditPolicy());
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
		return new Link_KnowledgeAndSkill_DriverPreferenceFigure();
	}

	/**
	* @generated
	*/
	public Link_KnowledgeAndSkill_DriverPreferenceFigure getPrimaryShape() {
		return (Link_KnowledgeAndSkill_DriverPreferenceFigure) getFigure();
	}

	/**
	 * @generated
	 */
	public class Link_KnowledgeAndSkill_DriverPreferenceFigure extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureLink_KnowledgeAndSkill_DriverPreferenceName_link_knowledgeAndSkill_driverPreferenceFigure;

		/**
		 * @generated
		 */
		public Link_KnowledgeAndSkill_DriverPreferenceFigure() {

			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureLink_KnowledgeAndSkill_DriverPreferenceName_link_knowledgeAndSkill_driverPreferenceFigure = new WrappingLabel();

			fFigureLink_KnowledgeAndSkill_DriverPreferenceName_link_knowledgeAndSkill_driverPreferenceFigure
					.setText("<...>");

			this.add(fFigureLink_KnowledgeAndSkill_DriverPreferenceName_link_knowledgeAndSkill_driverPreferenceFigure);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureLink_KnowledgeAndSkill_DriverPreferenceName_link_knowledgeAndSkill_driverPreferenceFigure() {
			return fFigureLink_KnowledgeAndSkill_DriverPreferenceName_link_knowledgeAndSkill_driverPreferenceFigure;
		}

	}

}
