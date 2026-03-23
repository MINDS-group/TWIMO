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
public class Link_CommunicationInterface_InfrastructureEditPart extends ConnectionNodeEditPart
		implements ITreeBranchEditPart {

	/**
	* @generated
	*/
	public static final int VISUAL_ID = 4039;

	/**
	* @generated
	*/
	public Link_CommunicationInterface_InfrastructureEditPart(View view) {
		super(view);
	}

	/**
	* @generated
	*/
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new intelligentMobility.diagram.edit.policies.Link_CommunicationInterface_InfrastructureItemSemanticEditPolicy());
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
		return new Link_CommunicationInterface_InfrastructureFigure();
	}

	/**
	* @generated
	*/
	public Link_CommunicationInterface_InfrastructureFigure getPrimaryShape() {
		return (Link_CommunicationInterface_InfrastructureFigure) getFigure();
	}

	/**
	 * @generated
	 */
	public class Link_CommunicationInterface_InfrastructureFigure extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureLink_CommunicationInterface_InfrastructureName_link_communication_interface_infrastructureFigure;

		/**
		 * @generated
		 */
		public Link_CommunicationInterface_InfrastructureFigure() {

			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureLink_CommunicationInterface_InfrastructureName_link_communication_interface_infrastructureFigure = new WrappingLabel();

			fFigureLink_CommunicationInterface_InfrastructureName_link_communication_interface_infrastructureFigure
					.setText("");

			this.add(
					fFigureLink_CommunicationInterface_InfrastructureName_link_communication_interface_infrastructureFigure);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureLink_CommunicationInterface_InfrastructureName_link_communication_interface_infrastructureFigure() {
			return fFigureLink_CommunicationInterface_InfrastructureName_link_communication_interface_infrastructureFigure;
		}

	}

}
