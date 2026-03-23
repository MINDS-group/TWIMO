package intelligentMobility.diagram.edit.parts;

import org.eclipse.draw2d.FlowLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.FlowLayoutEditPolicy;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;

/**
 * @generated
 */
public class Driver_ProfileEditPart extends ShapeNodeEditPart {

	/**
	* @generated
	*/
	public static final int VISUAL_ID = 2025;

	/**
	* @generated
	*/
	protected IFigure contentPane;

	/**
	* @generated
	*/
	protected IFigure primaryShape;

	/**
	* @generated
	*/
	public Driver_ProfileEditPart(View view) {
		super(view);
	}

	/**
	* @generated
	*/
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new intelligentMobility.diagram.edit.policies.Driver_ProfileItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	}

	/**
	* @generated
	*/
	protected LayoutEditPolicy createLayoutEditPolicy() {

		FlowLayoutEditPolicy lep = new FlowLayoutEditPolicy() {

			protected Command createAddCommand(EditPart child, EditPart after) {
				return null;
			}

			protected Command createMoveChildCommand(EditPart child, EditPart after) {
				return null;
			}

			protected Command getCreateCommand(CreateRequest request) {
				return null;
			}
		};
		return lep;
	}

	/**
	* @generated
	*/
	protected IFigure createNodeShape() {
		return primaryShape = new Driver_ProfileFigure();
	}

	/**
	* @generated
	*/
	public Driver_ProfileFigure getPrimaryShape() {
		return (Driver_ProfileFigure) primaryShape;
	}

	/**
	* @generated
	*/
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof intelligentMobility.diagram.edit.parts.Driver_ProfileDriverNameEditPart) {
			((intelligentMobility.diagram.edit.parts.Driver_ProfileDriverNameEditPart) childEditPart)
					.setLabel(getPrimaryShape().getFigureDriver_ProfileDriverNameFigure());
			return true;
		}
		return false;
	}

	/**
	* @generated
	*/
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof intelligentMobility.diagram.edit.parts.Driver_ProfileDriverNameEditPart) {
			return true;
		}
		return false;
	}

	/**
	* @generated
	*/
	protected void addChildVisual(EditPart childEditPart, int index) {
		if (addFixedChild(childEditPart)) {
			return;
		}
		super.addChildVisual(childEditPart, -1);
	}

	/**
	* @generated
	*/
	protected void removeChildVisual(EditPart childEditPart) {
		if (removeFixedChild(childEditPart)) {
			return;
		}
		super.removeChildVisual(childEditPart);
	}

	/**
	* @generated
	*/
	protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {
		return getContentPane();
	}

	/**
	* @generated
	*/
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(40, 40);
		return result;
	}

	/**
	* Creates figure for this edit part.
	* 
	* Body of this method does not depend on settings in generation model
	* so you may safely remove <i>generated</i> tag and modify it.
	* 
	* @generated
	*/
	protected NodeFigure createNodeFigure() {
		NodeFigure figure = createNodePlate();
		figure.setLayoutManager(new StackLayout());
		IFigure shape = createNodeShape();
		figure.add(shape);
		contentPane = setupContentPane(shape);
		return figure;
	}

	/**
	* Default implementation treats passed figure as content pane.
	* Respects layout one may have set for generated figure.
	* @param nodeShape instance of generated figure class
	* @generated
	*/
	protected IFigure setupContentPane(IFigure nodeShape) {
		if (nodeShape.getLayoutManager() == null) {
			ConstrainedToolbarLayout layout = new ConstrainedToolbarLayout();
			layout.setSpacing(5);
			nodeShape.setLayoutManager(layout);
		}
		return nodeShape; // use nodeShape itself as contentPane
	}

	/**
	* @generated
	*/
	public IFigure getContentPane() {
		if (contentPane != null) {
			return contentPane;
		}
		return super.getContentPane();
	}

	/**
	* @generated
	*/
	protected void setForegroundColor(Color color) {
		if (primaryShape != null) {
			primaryShape.setForegroundColor(color);
		}
	}

	/**
	* @generated
	*/
	protected void setBackgroundColor(Color color) {
		if (primaryShape != null) {
			primaryShape.setBackgroundColor(color);
		}
	}

	/**
	* @generated
	*/
	protected void setLineWidth(int width) {
		if (primaryShape instanceof Shape) {
			((Shape) primaryShape).setLineWidth(width);
		}
	}

	/**
	* @generated
	*/
	protected void setLineType(int style) {
		if (primaryShape instanceof Shape) {
			((Shape) primaryShape).setLineStyle(style);
		}
	}

	/**
	* @generated
	*/
	public EditPart getPrimaryChildEditPart() {
		return getChildBySemanticHint(intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
				.getType(intelligentMobility.diagram.edit.parts.Driver_ProfileDriverNameEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public class Driver_ProfileFigure extends RectangleFigure {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureDriver_ProfileDriverNameFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureDriver_ProfileDriverTypeFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureDriver_ProfilePatienceValueFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureDriver_ProfileLanePreferenceFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureDriver_ProfileEnergySpeedRateFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureDriver_ProfileRiskLevelFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureDriver_ProfileReactionTime_minFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureDriver_ProfileReactionTime_maxFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureDriver_ProfileReactionTime_precisionFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureDriver_ProfileAgeFigure;

		/**
		 * @generated
		 */
		public Driver_ProfileFigure() {

			FlowLayout layoutThis = new FlowLayout();
			layoutThis.setStretchMinorAxis(false);
			layoutThis.setMinorAlignment(FlowLayout.ALIGN_LEFTTOP);

			layoutThis.setMajorAlignment(FlowLayout.ALIGN_LEFTTOP);
			layoutThis.setMajorSpacing(5);
			layoutThis.setMinorSpacing(5);
			layoutThis.setHorizontal(true);

			this.setLayoutManager(layoutThis);

			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureDriver_ProfileDriverNameFigure = new WrappingLabel();

			fFigureDriver_ProfileDriverNameFigure.setText("<...>");

			this.add(fFigureDriver_ProfileDriverNameFigure);

			fFigureDriver_ProfileDriverTypeFigure = new WrappingLabel();

			fFigureDriver_ProfileDriverTypeFigure.setText("<...>");

			this.add(fFigureDriver_ProfileDriverTypeFigure);

			fFigureDriver_ProfilePatienceValueFigure = new WrappingLabel();

			fFigureDriver_ProfilePatienceValueFigure.setText("<...>");

			this.add(fFigureDriver_ProfilePatienceValueFigure);

			fFigureDriver_ProfileLanePreferenceFigure = new WrappingLabel();

			fFigureDriver_ProfileLanePreferenceFigure.setText("<...>");

			this.add(fFigureDriver_ProfileLanePreferenceFigure);

			fFigureDriver_ProfileEnergySpeedRateFigure = new WrappingLabel();

			fFigureDriver_ProfileEnergySpeedRateFigure.setText("<...>");

			this.add(fFigureDriver_ProfileEnergySpeedRateFigure);

			fFigureDriver_ProfileRiskLevelFigure = new WrappingLabel();

			fFigureDriver_ProfileRiskLevelFigure.setText("<...>");

			this.add(fFigureDriver_ProfileRiskLevelFigure);

			fFigureDriver_ProfileReactionTime_minFigure = new WrappingLabel();

			fFigureDriver_ProfileReactionTime_minFigure.setText("<...>");

			this.add(fFigureDriver_ProfileReactionTime_minFigure);

			fFigureDriver_ProfileReactionTime_maxFigure = new WrappingLabel();

			fFigureDriver_ProfileReactionTime_maxFigure.setText("<...>");

			this.add(fFigureDriver_ProfileReactionTime_maxFigure);

			fFigureDriver_ProfileReactionTime_precisionFigure = new WrappingLabel();

			fFigureDriver_ProfileReactionTime_precisionFigure.setText("<...>");

			this.add(fFigureDriver_ProfileReactionTime_precisionFigure);

			fFigureDriver_ProfileAgeFigure = new WrappingLabel();

			fFigureDriver_ProfileAgeFigure.setText("<...>");

			this.add(fFigureDriver_ProfileAgeFigure);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureDriver_ProfileDriverNameFigure() {
			return fFigureDriver_ProfileDriverNameFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureDriver_ProfileDriverTypeFigure() {
			return fFigureDriver_ProfileDriverTypeFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureDriver_ProfilePatienceValueFigure() {
			return fFigureDriver_ProfilePatienceValueFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureDriver_ProfileLanePreferenceFigure() {
			return fFigureDriver_ProfileLanePreferenceFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureDriver_ProfileEnergySpeedRateFigure() {
			return fFigureDriver_ProfileEnergySpeedRateFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureDriver_ProfileRiskLevelFigure() {
			return fFigureDriver_ProfileRiskLevelFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureDriver_ProfileReactionTime_minFigure() {
			return fFigureDriver_ProfileReactionTime_minFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureDriver_ProfileReactionTime_maxFigure() {
			return fFigureDriver_ProfileReactionTime_maxFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureDriver_ProfileReactionTime_precisionFigure() {
			return fFigureDriver_ProfileReactionTime_precisionFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureDriver_ProfileAgeFigure() {
			return fFigureDriver_ProfileAgeFigure;
		}

	}

}
