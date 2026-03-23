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
public class Link_EnvironmentCondition_SpecialConditionEditPart extends ConnectionNodeEditPart
		implements ITreeBranchEditPart {

	/**
	* @generated
	*/
	public static final int VISUAL_ID = 4027;

	/**
	* @generated
	*/
	public Link_EnvironmentCondition_SpecialConditionEditPart(View view) {
		super(view);
	}

	/**
	* @generated
	*/
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new intelligentMobility.diagram.edit.policies.Link_EnvironmentCondition_SpecialConditionItemSemanticEditPolicy());
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
		return new Link_EnvironmentCondition_SpecialConditionFigure();
	}

	/**
	* @generated
	*/
	public Link_EnvironmentCondition_SpecialConditionFigure getPrimaryShape() {
		return (Link_EnvironmentCondition_SpecialConditionFigure) getFigure();
	}

	/**
	 * @generated
	 */
	public class Link_EnvironmentCondition_SpecialConditionFigure extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureLink_EnvironmentCondition_SpecialConditionName_link_environmentCondition_specialConditionFigure;

		/**
		 * @generated
		 */
		public Link_EnvironmentCondition_SpecialConditionFigure() {

			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureLink_EnvironmentCondition_SpecialConditionName_link_environmentCondition_specialConditionFigure = new WrappingLabel();

			fFigureLink_EnvironmentCondition_SpecialConditionName_link_environmentCondition_specialConditionFigure
					.setText("<...>");

			this.add(
					fFigureLink_EnvironmentCondition_SpecialConditionName_link_environmentCondition_specialConditionFigure);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureLink_EnvironmentCondition_SpecialConditionName_link_environmentCondition_specialConditionFigure() {
			return fFigureLink_EnvironmentCondition_SpecialConditionName_link_environmentCondition_specialConditionFigure;
		}

	}

}
