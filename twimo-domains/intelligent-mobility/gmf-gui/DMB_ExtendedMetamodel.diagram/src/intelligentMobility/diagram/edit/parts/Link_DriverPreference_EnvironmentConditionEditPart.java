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
public class Link_DriverPreference_EnvironmentConditionEditPart extends ConnectionNodeEditPart
		implements ITreeBranchEditPart {

	/**
	* @generated
	*/
	public static final int VISUAL_ID = 4009;

	/**
	* @generated
	*/
	public Link_DriverPreference_EnvironmentConditionEditPart(View view) {
		super(view);
	}

	/**
	* @generated
	*/
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new intelligentMobility.diagram.edit.policies.Link_DriverPreference_EnvironmentConditionItemSemanticEditPolicy());
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
		return new Link_DriverPreference_EnvironmentConditionFigure();
	}

	/**
	* @generated
	*/
	public Link_DriverPreference_EnvironmentConditionFigure getPrimaryShape() {
		return (Link_DriverPreference_EnvironmentConditionFigure) getFigure();
	}

	/**
	 * @generated
	 */
	public class Link_DriverPreference_EnvironmentConditionFigure extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureLink_DriverPreference_EnvironmentConditionName_link_preference_conditionFigure;

		/**
		 * @generated
		 */
		public Link_DriverPreference_EnvironmentConditionFigure() {

			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureLink_DriverPreference_EnvironmentConditionName_link_preference_conditionFigure = new WrappingLabel();

			fFigureLink_DriverPreference_EnvironmentConditionName_link_preference_conditionFigure.setText("<...>");

			this.add(fFigureLink_DriverPreference_EnvironmentConditionName_link_preference_conditionFigure);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureLink_DriverPreference_EnvironmentConditionName_link_preference_conditionFigure() {
			return fFigureLink_DriverPreference_EnvironmentConditionName_link_preference_conditionFigure;
		}

	}

}
