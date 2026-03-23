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
public class Link_VehicleConfiguration_VehicleTypeEditPart extends ConnectionNodeEditPart
		implements ITreeBranchEditPart {

	/**
	* @generated
	*/
	public static final int VISUAL_ID = 4013;

	/**
	* @generated
	*/
	public Link_VehicleConfiguration_VehicleTypeEditPart(View view) {
		super(view);
	}

	/**
	* @generated
	*/
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new intelligentMobility.diagram.edit.policies.Link_VehicleConfiguration_VehicleTypeItemSemanticEditPolicy());
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
		return new Link_VehicleConfiguration_VehicleTypeFigure();
	}

	/**
	* @generated
	*/
	public Link_VehicleConfiguration_VehicleTypeFigure getPrimaryShape() {
		return (Link_VehicleConfiguration_VehicleTypeFigure) getFigure();
	}

	/**
	 * @generated
	 */
	public class Link_VehicleConfiguration_VehicleTypeFigure extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureLink_VehicleConfiguration_VehicleTypeName_link_configuration_typeFigure;

		/**
		 * @generated
		 */
		public Link_VehicleConfiguration_VehicleTypeFigure() {

			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureLink_VehicleConfiguration_VehicleTypeName_link_configuration_typeFigure = new WrappingLabel();

			fFigureLink_VehicleConfiguration_VehicleTypeName_link_configuration_typeFigure.setText("<...>");

			this.add(fFigureLink_VehicleConfiguration_VehicleTypeName_link_configuration_typeFigure);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureLink_VehicleConfiguration_VehicleTypeName_link_configuration_typeFigure() {
			return fFigureLink_VehicleConfiguration_VehicleTypeName_link_configuration_typeFigure;
		}

	}

}
