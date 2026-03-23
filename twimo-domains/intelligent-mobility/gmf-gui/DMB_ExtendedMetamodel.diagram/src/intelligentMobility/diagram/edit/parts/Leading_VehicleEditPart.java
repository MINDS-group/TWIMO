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
public class Leading_VehicleEditPart extends ShapeNodeEditPart {

	/**
	* @generated
	*/
	public static final int VISUAL_ID = 2021;

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
	public Leading_VehicleEditPart(View view) {
		super(view);
	}

	/**
	* @generated
	*/
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new intelligentMobility.diagram.edit.policies.Leading_VehicleItemSemanticEditPolicy());
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
		return primaryShape = new Leading_VehicleFigure();
	}

	/**
	* @generated
	*/
	public Leading_VehicleFigure getPrimaryShape() {
		return (Leading_VehicleFigure) primaryShape;
	}

	/**
	* @generated
	*/
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof intelligentMobility.diagram.edit.parts.Leading_VehicleNameEditPart) {
			((intelligentMobility.diagram.edit.parts.Leading_VehicleNameEditPart) childEditPart)
					.setLabel(getPrimaryShape().getFigureLeading_VehicleTypeFigure());
			return true;
		}
		return false;
	}

	/**
	* @generated
	*/
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof intelligentMobility.diagram.edit.parts.Leading_VehicleNameEditPart) {
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
				.getType(intelligentMobility.diagram.edit.parts.Leading_VehicleNameEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public class Leading_VehicleFigure extends RectangleFigure {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureLeading_VehicleTypeFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureLeading_VehicleMaxSpeedFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureLeading_VehicleVehicleWidth_minFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureLeading_VehicleVehicleWidth_maxFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureLeading_VehicleVehicleWidth_precisionFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureLeading_VehicleVehicleLength_minFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureLeading_VehicleVehicleLength_maxFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureLeading_VehicleVehicleLength_precisionFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureLeading_VehicleVehicleHeight_minFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureLeading_VehicleVehicleHeight_maxFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureLeading_VehicleVehicleHeight_precisionFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureLeading_VehicleSpeedFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureLeading_VehicleStopFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureLeading_VehicleNameFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureLeading_VehicleResetColorFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureLeading_VehicleColorR_minFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureLeading_VehicleColorR_maxFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureLeading_VehicleColorG_minFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureLeading_VehicleColorG_maxFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureLeading_VehicleColorB_minFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureLeading_VehicleColorB_maxFigure;

		/**
		 * @generated
		 */
		public Leading_VehicleFigure() {

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

			fFigureLeading_VehicleTypeFigure = new WrappingLabel();

			fFigureLeading_VehicleTypeFigure.setText("<...>");

			this.add(fFigureLeading_VehicleTypeFigure);

			fFigureLeading_VehicleMaxSpeedFigure = new WrappingLabel();

			fFigureLeading_VehicleMaxSpeedFigure.setText("<...>");

			this.add(fFigureLeading_VehicleMaxSpeedFigure);

			fFigureLeading_VehicleVehicleWidth_minFigure = new WrappingLabel();

			fFigureLeading_VehicleVehicleWidth_minFigure.setText("<...>");

			this.add(fFigureLeading_VehicleVehicleWidth_minFigure);

			fFigureLeading_VehicleVehicleWidth_maxFigure = new WrappingLabel();

			fFigureLeading_VehicleVehicleWidth_maxFigure.setText("<...>");

			this.add(fFigureLeading_VehicleVehicleWidth_maxFigure);

			fFigureLeading_VehicleVehicleWidth_precisionFigure = new WrappingLabel();

			fFigureLeading_VehicleVehicleWidth_precisionFigure.setText("<...>");

			this.add(fFigureLeading_VehicleVehicleWidth_precisionFigure);

			fFigureLeading_VehicleVehicleLength_minFigure = new WrappingLabel();

			fFigureLeading_VehicleVehicleLength_minFigure.setText("<...>");

			this.add(fFigureLeading_VehicleVehicleLength_minFigure);

			fFigureLeading_VehicleVehicleLength_maxFigure = new WrappingLabel();

			fFigureLeading_VehicleVehicleLength_maxFigure.setText("<...>");

			this.add(fFigureLeading_VehicleVehicleLength_maxFigure);

			fFigureLeading_VehicleVehicleLength_precisionFigure = new WrappingLabel();

			fFigureLeading_VehicleVehicleLength_precisionFigure.setText("<...>");

			this.add(fFigureLeading_VehicleVehicleLength_precisionFigure);

			fFigureLeading_VehicleVehicleHeight_minFigure = new WrappingLabel();

			fFigureLeading_VehicleVehicleHeight_minFigure.setText("<...>");

			this.add(fFigureLeading_VehicleVehicleHeight_minFigure);

			fFigureLeading_VehicleVehicleHeight_maxFigure = new WrappingLabel();

			fFigureLeading_VehicleVehicleHeight_maxFigure.setText("<...>");

			this.add(fFigureLeading_VehicleVehicleHeight_maxFigure);

			fFigureLeading_VehicleVehicleHeight_precisionFigure = new WrappingLabel();

			fFigureLeading_VehicleVehicleHeight_precisionFigure.setText("<...>");

			this.add(fFigureLeading_VehicleVehicleHeight_precisionFigure);

			fFigureLeading_VehicleSpeedFigure = new WrappingLabel();

			fFigureLeading_VehicleSpeedFigure.setText("<...>");

			this.add(fFigureLeading_VehicleSpeedFigure);

			fFigureLeading_VehicleStopFigure = new WrappingLabel();

			fFigureLeading_VehicleStopFigure.setText("<...>");

			this.add(fFigureLeading_VehicleStopFigure);

			fFigureLeading_VehicleNameFigure = new WrappingLabel();

			fFigureLeading_VehicleNameFigure.setText("<...>");

			this.add(fFigureLeading_VehicleNameFigure);

			fFigureLeading_VehicleResetColorFigure = new WrappingLabel();

			fFigureLeading_VehicleResetColorFigure.setText("<...>");

			this.add(fFigureLeading_VehicleResetColorFigure);

			fFigureLeading_VehicleColorR_minFigure = new WrappingLabel();

			fFigureLeading_VehicleColorR_minFigure.setText("<...>");

			this.add(fFigureLeading_VehicleColorR_minFigure);

			fFigureLeading_VehicleColorR_maxFigure = new WrappingLabel();

			fFigureLeading_VehicleColorR_maxFigure.setText("<...>");

			this.add(fFigureLeading_VehicleColorR_maxFigure);

			fFigureLeading_VehicleColorG_minFigure = new WrappingLabel();

			fFigureLeading_VehicleColorG_minFigure.setText("<...>");

			this.add(fFigureLeading_VehicleColorG_minFigure);

			fFigureLeading_VehicleColorG_maxFigure = new WrappingLabel();

			fFigureLeading_VehicleColorG_maxFigure.setText("<...>");

			this.add(fFigureLeading_VehicleColorG_maxFigure);

			fFigureLeading_VehicleColorB_minFigure = new WrappingLabel();

			fFigureLeading_VehicleColorB_minFigure.setText("<...>");

			this.add(fFigureLeading_VehicleColorB_minFigure);

			fFigureLeading_VehicleColorB_maxFigure = new WrappingLabel();

			fFigureLeading_VehicleColorB_maxFigure.setText("<...>");

			this.add(fFigureLeading_VehicleColorB_maxFigure);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureLeading_VehicleTypeFigure() {
			return fFigureLeading_VehicleTypeFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureLeading_VehicleMaxSpeedFigure() {
			return fFigureLeading_VehicleMaxSpeedFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureLeading_VehicleVehicleWidth_minFigure() {
			return fFigureLeading_VehicleVehicleWidth_minFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureLeading_VehicleVehicleWidth_maxFigure() {
			return fFigureLeading_VehicleVehicleWidth_maxFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureLeading_VehicleVehicleWidth_precisionFigure() {
			return fFigureLeading_VehicleVehicleWidth_precisionFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureLeading_VehicleVehicleLength_minFigure() {
			return fFigureLeading_VehicleVehicleLength_minFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureLeading_VehicleVehicleLength_maxFigure() {
			return fFigureLeading_VehicleVehicleLength_maxFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureLeading_VehicleVehicleLength_precisionFigure() {
			return fFigureLeading_VehicleVehicleLength_precisionFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureLeading_VehicleVehicleHeight_minFigure() {
			return fFigureLeading_VehicleVehicleHeight_minFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureLeading_VehicleVehicleHeight_maxFigure() {
			return fFigureLeading_VehicleVehicleHeight_maxFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureLeading_VehicleVehicleHeight_precisionFigure() {
			return fFigureLeading_VehicleVehicleHeight_precisionFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureLeading_VehicleSpeedFigure() {
			return fFigureLeading_VehicleSpeedFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureLeading_VehicleStopFigure() {
			return fFigureLeading_VehicleStopFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureLeading_VehicleNameFigure() {
			return fFigureLeading_VehicleNameFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureLeading_VehicleResetColorFigure() {
			return fFigureLeading_VehicleResetColorFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureLeading_VehicleColorR_minFigure() {
			return fFigureLeading_VehicleColorR_minFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureLeading_VehicleColorR_maxFigure() {
			return fFigureLeading_VehicleColorR_maxFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureLeading_VehicleColorG_minFigure() {
			return fFigureLeading_VehicleColorG_minFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureLeading_VehicleColorG_maxFigure() {
			return fFigureLeading_VehicleColorG_maxFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureLeading_VehicleColorB_minFigure() {
			return fFigureLeading_VehicleColorB_minFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureLeading_VehicleColorB_maxFigure() {
			return fFigureLeading_VehicleColorB_maxFigure;
		}

	}

}
