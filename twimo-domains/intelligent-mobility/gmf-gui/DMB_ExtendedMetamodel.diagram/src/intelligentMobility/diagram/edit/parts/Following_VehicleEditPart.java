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
public class Following_VehicleEditPart extends ShapeNodeEditPart {

	/**
	* @generated
	*/
	public static final int VISUAL_ID = 2028;

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
	public Following_VehicleEditPart(View view) {
		super(view);
	}

	/**
	* @generated
	*/
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new intelligentMobility.diagram.edit.policies.Following_VehicleItemSemanticEditPolicy());
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
		return primaryShape = new Following_VehicleFigure();
	}

	/**
	* @generated
	*/
	public Following_VehicleFigure getPrimaryShape() {
		return (Following_VehicleFigure) primaryShape;
	}

	/**
	* @generated
	*/
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof intelligentMobility.diagram.edit.parts.Following_VehicleNameEditPart) {
			((intelligentMobility.diagram.edit.parts.Following_VehicleNameEditPart) childEditPart)
					.setLabel(getPrimaryShape().getFigureFollowing_VehicleTypeFigure());
			return true;
		}
		return false;
	}

	/**
	* @generated
	*/
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof intelligentMobility.diagram.edit.parts.Following_VehicleNameEditPart) {
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
				.getType(intelligentMobility.diagram.edit.parts.Following_VehicleNameEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public class Following_VehicleFigure extends RectangleFigure {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureFollowing_VehicleTypeFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureFollowing_VehicleMaxSpeedFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureFollowing_VehicleVehicleWidth_minFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureFollowing_VehicleVehicleWidth_maxFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureFollowing_VehicleVehicleWidth_precisionFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureFollowing_VehicleVehicleLength_minFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureFollowing_VehicleVehicleLength_maxFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureFollowing_VehicleVehicleLength_precisionFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureFollowing_VehicleVehicleHeight_minFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureFollowing_VehicleVehicleHeight_maxFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureFollowing_VehicleVehicleHeight_precisionFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureFollowing_VehicleSpeedFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureFollowing_VehicleStopFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureFollowing_VehicleNameFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureFollowing_VehicleResetColorFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureFollowing_VehicleColorR_minFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureFollowing_VehicleColorR_maxFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureFollowing_VehicleColorG_minFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureFollowing_VehicleColorG_maxFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureFollowing_VehicleColorB_minFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureFollowing_VehicleColorB_maxFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureFollowing_VehicleHeadwayMinFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureFollowing_VehicleHeadwayMaxFigure;

		/**
		 * @generated
		 */
		public Following_VehicleFigure() {

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

			fFigureFollowing_VehicleTypeFigure = new WrappingLabel();

			fFigureFollowing_VehicleTypeFigure.setText("<...>");

			this.add(fFigureFollowing_VehicleTypeFigure);

			fFigureFollowing_VehicleMaxSpeedFigure = new WrappingLabel();

			fFigureFollowing_VehicleMaxSpeedFigure.setText("<...>");

			this.add(fFigureFollowing_VehicleMaxSpeedFigure);

			fFigureFollowing_VehicleVehicleWidth_minFigure = new WrappingLabel();

			fFigureFollowing_VehicleVehicleWidth_minFigure.setText("<...>");

			this.add(fFigureFollowing_VehicleVehicleWidth_minFigure);

			fFigureFollowing_VehicleVehicleWidth_maxFigure = new WrappingLabel();

			fFigureFollowing_VehicleVehicleWidth_maxFigure.setText("<...>");

			this.add(fFigureFollowing_VehicleVehicleWidth_maxFigure);

			fFigureFollowing_VehicleVehicleWidth_precisionFigure = new WrappingLabel();

			fFigureFollowing_VehicleVehicleWidth_precisionFigure.setText("<...>");

			this.add(fFigureFollowing_VehicleVehicleWidth_precisionFigure);

			fFigureFollowing_VehicleVehicleLength_minFigure = new WrappingLabel();

			fFigureFollowing_VehicleVehicleLength_minFigure.setText("<...>");

			this.add(fFigureFollowing_VehicleVehicleLength_minFigure);

			fFigureFollowing_VehicleVehicleLength_maxFigure = new WrappingLabel();

			fFigureFollowing_VehicleVehicleLength_maxFigure.setText("<...>");

			this.add(fFigureFollowing_VehicleVehicleLength_maxFigure);

			fFigureFollowing_VehicleVehicleLength_precisionFigure = new WrappingLabel();

			fFigureFollowing_VehicleVehicleLength_precisionFigure.setText("<...>");

			this.add(fFigureFollowing_VehicleVehicleLength_precisionFigure);

			fFigureFollowing_VehicleVehicleHeight_minFigure = new WrappingLabel();

			fFigureFollowing_VehicleVehicleHeight_minFigure.setText("<...>");

			this.add(fFigureFollowing_VehicleVehicleHeight_minFigure);

			fFigureFollowing_VehicleVehicleHeight_maxFigure = new WrappingLabel();

			fFigureFollowing_VehicleVehicleHeight_maxFigure.setText("<...>");

			this.add(fFigureFollowing_VehicleVehicleHeight_maxFigure);

			fFigureFollowing_VehicleVehicleHeight_precisionFigure = new WrappingLabel();

			fFigureFollowing_VehicleVehicleHeight_precisionFigure.setText("<...>");

			this.add(fFigureFollowing_VehicleVehicleHeight_precisionFigure);

			fFigureFollowing_VehicleSpeedFigure = new WrappingLabel();

			fFigureFollowing_VehicleSpeedFigure.setText("<...>");

			this.add(fFigureFollowing_VehicleSpeedFigure);

			fFigureFollowing_VehicleStopFigure = new WrappingLabel();

			fFigureFollowing_VehicleStopFigure.setText("<...>");

			this.add(fFigureFollowing_VehicleStopFigure);

			fFigureFollowing_VehicleNameFigure = new WrappingLabel();

			fFigureFollowing_VehicleNameFigure.setText("<...>");

			this.add(fFigureFollowing_VehicleNameFigure);

			fFigureFollowing_VehicleResetColorFigure = new WrappingLabel();

			fFigureFollowing_VehicleResetColorFigure.setText("<...>");

			this.add(fFigureFollowing_VehicleResetColorFigure);

			fFigureFollowing_VehicleColorR_minFigure = new WrappingLabel();

			fFigureFollowing_VehicleColorR_minFigure.setText("<...>");

			this.add(fFigureFollowing_VehicleColorR_minFigure);

			fFigureFollowing_VehicleColorR_maxFigure = new WrappingLabel();

			fFigureFollowing_VehicleColorR_maxFigure.setText("<...>");

			this.add(fFigureFollowing_VehicleColorR_maxFigure);

			fFigureFollowing_VehicleColorG_minFigure = new WrappingLabel();

			fFigureFollowing_VehicleColorG_minFigure.setText("<...>");

			this.add(fFigureFollowing_VehicleColorG_minFigure);

			fFigureFollowing_VehicleColorG_maxFigure = new WrappingLabel();

			fFigureFollowing_VehicleColorG_maxFigure.setText("<...>");

			this.add(fFigureFollowing_VehicleColorG_maxFigure);

			fFigureFollowing_VehicleColorB_minFigure = new WrappingLabel();

			fFigureFollowing_VehicleColorB_minFigure.setText("<...>");

			this.add(fFigureFollowing_VehicleColorB_minFigure);

			fFigureFollowing_VehicleColorB_maxFigure = new WrappingLabel();

			fFigureFollowing_VehicleColorB_maxFigure.setText("<...>");

			this.add(fFigureFollowing_VehicleColorB_maxFigure);

			fFigureFollowing_VehicleHeadwayMinFigure = new WrappingLabel();

			fFigureFollowing_VehicleHeadwayMinFigure.setText("<...>");

			this.add(fFigureFollowing_VehicleHeadwayMinFigure);

			fFigureFollowing_VehicleHeadwayMaxFigure = new WrappingLabel();

			fFigureFollowing_VehicleHeadwayMaxFigure.setText("<...>");

			this.add(fFigureFollowing_VehicleHeadwayMaxFigure);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureFollowing_VehicleTypeFigure() {
			return fFigureFollowing_VehicleTypeFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureFollowing_VehicleMaxSpeedFigure() {
			return fFigureFollowing_VehicleMaxSpeedFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureFollowing_VehicleVehicleWidth_minFigure() {
			return fFigureFollowing_VehicleVehicleWidth_minFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureFollowing_VehicleVehicleWidth_maxFigure() {
			return fFigureFollowing_VehicleVehicleWidth_maxFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureFollowing_VehicleVehicleWidth_precisionFigure() {
			return fFigureFollowing_VehicleVehicleWidth_precisionFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureFollowing_VehicleVehicleLength_minFigure() {
			return fFigureFollowing_VehicleVehicleLength_minFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureFollowing_VehicleVehicleLength_maxFigure() {
			return fFigureFollowing_VehicleVehicleLength_maxFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureFollowing_VehicleVehicleLength_precisionFigure() {
			return fFigureFollowing_VehicleVehicleLength_precisionFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureFollowing_VehicleVehicleHeight_minFigure() {
			return fFigureFollowing_VehicleVehicleHeight_minFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureFollowing_VehicleVehicleHeight_maxFigure() {
			return fFigureFollowing_VehicleVehicleHeight_maxFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureFollowing_VehicleVehicleHeight_precisionFigure() {
			return fFigureFollowing_VehicleVehicleHeight_precisionFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureFollowing_VehicleSpeedFigure() {
			return fFigureFollowing_VehicleSpeedFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureFollowing_VehicleStopFigure() {
			return fFigureFollowing_VehicleStopFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureFollowing_VehicleNameFigure() {
			return fFigureFollowing_VehicleNameFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureFollowing_VehicleResetColorFigure() {
			return fFigureFollowing_VehicleResetColorFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureFollowing_VehicleColorR_minFigure() {
			return fFigureFollowing_VehicleColorR_minFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureFollowing_VehicleColorR_maxFigure() {
			return fFigureFollowing_VehicleColorR_maxFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureFollowing_VehicleColorG_minFigure() {
			return fFigureFollowing_VehicleColorG_minFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureFollowing_VehicleColorG_maxFigure() {
			return fFigureFollowing_VehicleColorG_maxFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureFollowing_VehicleColorB_minFigure() {
			return fFigureFollowing_VehicleColorB_minFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureFollowing_VehicleColorB_maxFigure() {
			return fFigureFollowing_VehicleColorB_maxFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureFollowing_VehicleHeadwayMinFigure() {
			return fFigureFollowing_VehicleHeadwayMinFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureFollowing_VehicleHeadwayMaxFigure() {
			return fFigureFollowing_VehicleHeadwayMaxFigure;
		}

	}

}
