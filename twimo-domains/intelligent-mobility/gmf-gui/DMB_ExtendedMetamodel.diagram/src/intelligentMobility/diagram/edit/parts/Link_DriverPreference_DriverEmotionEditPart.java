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
public class Link_DriverPreference_DriverEmotionEditPart extends ConnectionNodeEditPart implements ITreeBranchEditPart {

	/**
	* @generated
	*/
	public static final int VISUAL_ID = 4024;

	/**
	* @generated
	*/
	public Link_DriverPreference_DriverEmotionEditPart(View view) {
		super(view);
	}

	/**
	* @generated
	*/
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new intelligentMobility.diagram.edit.policies.Link_DriverPreference_DriverEmotionItemSemanticEditPolicy());
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
		return new Link_DriverPreference_DriverEmotionFigure();
	}

	/**
	* @generated
	*/
	public Link_DriverPreference_DriverEmotionFigure getPrimaryShape() {
		return (Link_DriverPreference_DriverEmotionFigure) getFigure();
	}

	/**
	 * @generated
	 */
	public class Link_DriverPreference_DriverEmotionFigure extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureLink_DriverPreference_DriverEmotionName_link_preference_emotionFigure;

		/**
		 * @generated
		 */
		public Link_DriverPreference_DriverEmotionFigure() {

			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureLink_DriverPreference_DriverEmotionName_link_preference_emotionFigure = new WrappingLabel();

			fFigureLink_DriverPreference_DriverEmotionName_link_preference_emotionFigure.setText("<...>");

			this.add(fFigureLink_DriverPreference_DriverEmotionName_link_preference_emotionFigure);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureLink_DriverPreference_DriverEmotionName_link_preference_emotionFigure() {
			return fFigureLink_DriverPreference_DriverEmotionName_link_preference_emotionFigure;
		}

	}

}
