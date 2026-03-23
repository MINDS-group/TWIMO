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
public class Link_SpecialCondition_IntersectionEditPart extends ConnectionNodeEditPart implements ITreeBranchEditPart {

	/**
	* @generated
	*/
	public static final int VISUAL_ID = 4028;

	/**
	* @generated
	*/
	public Link_SpecialCondition_IntersectionEditPart(View view) {
		super(view);
	}

	/**
	* @generated
	*/
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new intelligentMobility.diagram.edit.policies.Link_SpecialCondition_IntersectionItemSemanticEditPolicy());
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
		return new Link_SpecialCondition_IntersectionFigure();
	}

	/**
	* @generated
	*/
	public Link_SpecialCondition_IntersectionFigure getPrimaryShape() {
		return (Link_SpecialCondition_IntersectionFigure) getFigure();
	}

	/**
	 * @generated
	 */
	public class Link_SpecialCondition_IntersectionFigure extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureLink_SpecialCondition_IntersectionName_link_specialCondition_intersectionFigure;

		/**
		 * @generated
		 */
		public Link_SpecialCondition_IntersectionFigure() {

			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureLink_SpecialCondition_IntersectionName_link_specialCondition_intersectionFigure = new WrappingLabel();

			fFigureLink_SpecialCondition_IntersectionName_link_specialCondition_intersectionFigure.setText("<...>");

			this.add(fFigureLink_SpecialCondition_IntersectionName_link_specialCondition_intersectionFigure);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureLink_SpecialCondition_IntersectionName_link_specialCondition_intersectionFigure() {
			return fFigureLink_SpecialCondition_IntersectionName_link_specialCondition_intersectionFigure;
		}

	}

}
