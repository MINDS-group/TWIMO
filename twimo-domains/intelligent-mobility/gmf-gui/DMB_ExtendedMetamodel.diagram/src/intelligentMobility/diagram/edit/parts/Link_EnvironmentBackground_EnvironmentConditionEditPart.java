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
public class Link_EnvironmentBackground_EnvironmentConditionEditPart extends ConnectionNodeEditPart
		implements ITreeBranchEditPart {

	/**
	* @generated
	*/
	public static final int VISUAL_ID = 4025;

	/**
	* @generated
	*/
	public Link_EnvironmentBackground_EnvironmentConditionEditPart(View view) {
		super(view);
	}

	/**
	* @generated
	*/
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new intelligentMobility.diagram.edit.policies.Link_EnvironmentBackground_EnvironmentConditionItemSemanticEditPolicy());
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
		return new Link_EnvironmentBackground_EnvironmentConditionFigure();
	}

	/**
	* @generated
	*/
	public Link_EnvironmentBackground_EnvironmentConditionFigure getPrimaryShape() {
		return (Link_EnvironmentBackground_EnvironmentConditionFigure) getFigure();
	}

	/**
	 * @generated
	 */
	public class Link_EnvironmentBackground_EnvironmentConditionFigure extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureLink_EnvironmentBackground_EnvironmentConditionName_link_background_conditionFigure;

		/**
		 * @generated
		 */
		public Link_EnvironmentBackground_EnvironmentConditionFigure() {

			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureLink_EnvironmentBackground_EnvironmentConditionName_link_background_conditionFigure = new WrappingLabel();

			fFigureLink_EnvironmentBackground_EnvironmentConditionName_link_background_conditionFigure.setText("<...>");

			this.add(fFigureLink_EnvironmentBackground_EnvironmentConditionName_link_background_conditionFigure);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureLink_EnvironmentBackground_EnvironmentConditionName_link_background_conditionFigure() {
			return fFigureLink_EnvironmentBackground_EnvironmentConditionName_link_background_conditionFigure;
		}

	}

}
