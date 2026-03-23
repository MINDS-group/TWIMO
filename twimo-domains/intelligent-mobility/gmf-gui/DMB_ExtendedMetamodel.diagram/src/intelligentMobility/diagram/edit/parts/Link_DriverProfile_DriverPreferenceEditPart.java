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
public class Link_DriverProfile_DriverPreferenceEditPart extends ConnectionNodeEditPart implements ITreeBranchEditPart {

	/**
	* @generated
	*/
	public static final int VISUAL_ID = 4006;

	/**
	* @generated
	*/
	public Link_DriverProfile_DriverPreferenceEditPart(View view) {
		super(view);
	}

	/**
	* @generated
	*/
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new intelligentMobility.diagram.edit.policies.Link_DriverProfile_DriverPreferenceItemSemanticEditPolicy());
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
		return new Link_DriverProfile_DriverPreferenceFigure();
	}

	/**
	* @generated
	*/
	public Link_DriverProfile_DriverPreferenceFigure getPrimaryShape() {
		return (Link_DriverProfile_DriverPreferenceFigure) getFigure();
	}

	/**
	 * @generated
	 */
	public class Link_DriverProfile_DriverPreferenceFigure extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureLink_DriverProfile_DriverPreferenceName_link_profile_preferenceFigure;

		/**
		 * @generated
		 */
		public Link_DriverProfile_DriverPreferenceFigure() {

			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureLink_DriverProfile_DriverPreferenceName_link_profile_preferenceFigure = new WrappingLabel();

			fFigureLink_DriverProfile_DriverPreferenceName_link_profile_preferenceFigure.setText("<...>");

			this.add(fFigureLink_DriverProfile_DriverPreferenceName_link_profile_preferenceFigure);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureLink_DriverProfile_DriverPreferenceName_link_profile_preferenceFigure() {
			return fFigureLink_DriverProfile_DriverPreferenceName_link_profile_preferenceFigure;
		}

	}

}
