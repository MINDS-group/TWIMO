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
public class Environment_BackgroundEditPart extends ShapeNodeEditPart {

	/**
	* @generated
	*/
	public static final int VISUAL_ID = 2013;

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
	public Environment_BackgroundEditPart(View view) {
		super(view);
	}

	/**
	* @generated
	*/
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new intelligentMobility.diagram.edit.policies.Environment_BackgroundItemSemanticEditPolicy());
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
		return primaryShape = new Environment_BackgroundFigure();
	}

	/**
	* @generated
	*/
	public Environment_BackgroundFigure getPrimaryShape() {
		return (Environment_BackgroundFigure) primaryShape;
	}

	/**
	* @generated
	*/
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof intelligentMobility.diagram.edit.parts.Environment_BackgroundNameEditPart) {
			((intelligentMobility.diagram.edit.parts.Environment_BackgroundNameEditPart) childEditPart)
					.setLabel(getPrimaryShape().getFigureEnvironment_BackgroundNameFigure());
			return true;
		}
		return false;
	}

	/**
	* @generated
	*/
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof intelligentMobility.diagram.edit.parts.Environment_BackgroundNameEditPart) {
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
				.getType(intelligentMobility.diagram.edit.parts.Environment_BackgroundNameEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public class Environment_BackgroundFigure extends RectangleFigure {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureEnvironment_BackgroundNameFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureEnvironment_BackgroundRoadLengthFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureEnvironment_BackgroundRoadShapeFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureEnvironment_BackgroundTotalVehiclePerFrameFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureEnvironment_BackgroundTrafficDensityFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureEnvironment_BackgroundSimulationFrameTimeFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureEnvironment_BackgroundSimulationSleepTimeFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureEnvironment_BackgroundRoadInclineFigure;

		/**
		 * @generated
		 */
		public Environment_BackgroundFigure() {

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

			fFigureEnvironment_BackgroundNameFigure = new WrappingLabel();

			fFigureEnvironment_BackgroundNameFigure.setText("<...>");

			this.add(fFigureEnvironment_BackgroundNameFigure);

			fFigureEnvironment_BackgroundRoadLengthFigure = new WrappingLabel();

			fFigureEnvironment_BackgroundRoadLengthFigure.setText("<...>");

			this.add(fFigureEnvironment_BackgroundRoadLengthFigure);

			fFigureEnvironment_BackgroundRoadShapeFigure = new WrappingLabel();

			fFigureEnvironment_BackgroundRoadShapeFigure.setText("<...>");

			this.add(fFigureEnvironment_BackgroundRoadShapeFigure);

			fFigureEnvironment_BackgroundTotalVehiclePerFrameFigure = new WrappingLabel();

			fFigureEnvironment_BackgroundTotalVehiclePerFrameFigure.setText("<...>");

			this.add(fFigureEnvironment_BackgroundTotalVehiclePerFrameFigure);

			fFigureEnvironment_BackgroundTrafficDensityFigure = new WrappingLabel();

			fFigureEnvironment_BackgroundTrafficDensityFigure.setText("<...>");

			this.add(fFigureEnvironment_BackgroundTrafficDensityFigure);

			fFigureEnvironment_BackgroundSimulationFrameTimeFigure = new WrappingLabel();

			fFigureEnvironment_BackgroundSimulationFrameTimeFigure.setText("<...>");

			this.add(fFigureEnvironment_BackgroundSimulationFrameTimeFigure);

			fFigureEnvironment_BackgroundSimulationSleepTimeFigure = new WrappingLabel();

			fFigureEnvironment_BackgroundSimulationSleepTimeFigure.setText("<...>");

			this.add(fFigureEnvironment_BackgroundSimulationSleepTimeFigure);

			fFigureEnvironment_BackgroundRoadInclineFigure = new WrappingLabel();

			fFigureEnvironment_BackgroundRoadInclineFigure.setText("<...>");

			this.add(fFigureEnvironment_BackgroundRoadInclineFigure);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureEnvironment_BackgroundNameFigure() {
			return fFigureEnvironment_BackgroundNameFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureEnvironment_BackgroundRoadLengthFigure() {
			return fFigureEnvironment_BackgroundRoadLengthFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureEnvironment_BackgroundRoadShapeFigure() {
			return fFigureEnvironment_BackgroundRoadShapeFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureEnvironment_BackgroundTotalVehiclePerFrameFigure() {
			return fFigureEnvironment_BackgroundTotalVehiclePerFrameFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureEnvironment_BackgroundTrafficDensityFigure() {
			return fFigureEnvironment_BackgroundTrafficDensityFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureEnvironment_BackgroundSimulationFrameTimeFigure() {
			return fFigureEnvironment_BackgroundSimulationFrameTimeFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureEnvironment_BackgroundSimulationSleepTimeFigure() {
			return fFigureEnvironment_BackgroundSimulationSleepTimeFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureEnvironment_BackgroundRoadInclineFigure() {
			return fFigureEnvironment_BackgroundRoadInclineFigure;
		}

	}

}
