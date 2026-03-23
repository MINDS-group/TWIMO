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
public class Link_Driver_EnvironmentEditPart extends ConnectionNodeEditPart implements ITreeBranchEditPart {

	/**
	* @generated
	*/
	public static final int VISUAL_ID = 4015;

	/**
	* @generated
	*/
	public Link_Driver_EnvironmentEditPart(View view) {
		super(view);
	}

	/**
	* @generated
	*/
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new intelligentMobility.diagram.edit.policies.Link_Driver_EnvironmentItemSemanticEditPolicy());
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
		return new Link_Driver_EnvironmentFigure();
	}

	/**
	* @generated
	*/
	public Link_Driver_EnvironmentFigure getPrimaryShape() {
		return (Link_Driver_EnvironmentFigure) getFigure();
	}

	/**
	 * @generated
	 */
	public class Link_Driver_EnvironmentFigure extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureLink_Driver_EnvironmentLink_name_driver_environmentFigure;

		/**
		 * @generated
		 */
		public Link_Driver_EnvironmentFigure() {

			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureLink_Driver_EnvironmentLink_name_driver_environmentFigure = new WrappingLabel();

			fFigureLink_Driver_EnvironmentLink_name_driver_environmentFigure.setText("<...>");

			this.add(fFigureLink_Driver_EnvironmentLink_name_driver_environmentFigure);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureLink_Driver_EnvironmentLink_name_driver_environmentFigure() {
			return fFigureLink_Driver_EnvironmentLink_name_driver_environmentFigure;
		}

	}

}
