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
public class Driving_BehaviourEditPart extends ShapeNodeEditPart {

	/**
	* @generated
	*/
	public static final int VISUAL_ID = 2027;

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
	public Driving_BehaviourEditPart(View view) {
		super(view);
	}

	/**
	* @generated
	*/
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new intelligentMobility.diagram.edit.policies.Driving_BehaviourItemSemanticEditPolicy());
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
		return primaryShape = new Driving_BehaviourFigure();
	}

	/**
	* @generated
	*/
	public Driving_BehaviourFigure getPrimaryShape() {
		return (Driving_BehaviourFigure) primaryShape;
	}

	/**
	* @generated
	*/
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof intelligentMobility.diagram.edit.parts.Driving_BehaviourNameEditPart) {
			((intelligentMobility.diagram.edit.parts.Driving_BehaviourNameEditPart) childEditPart)
					.setLabel(getPrimaryShape().getFigureDriving_BehaviourPrepDistanceForDestinationFigure());
			return true;
		}
		return false;
	}

	/**
	* @generated
	*/
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof intelligentMobility.diagram.edit.parts.Driving_BehaviourNameEditPart) {
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
				.getType(intelligentMobility.diagram.edit.parts.Driving_BehaviourNameEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public class Driving_BehaviourFigure extends RectangleFigure {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureDriving_BehaviourPrepDistanceForDestinationFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureDriving_BehaviourPrepDistanceForTurnFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureDriving_BehaviourInitialSpeed_minFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureDriving_BehaviourInitialSpeed_maxFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureDriving_BehaviourInitialSpeed_precisionFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureDriving_BehaviourDesiredSpeed_minFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureDriving_BehaviourDesiredSpeed_maxFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureDriving_BehaviourNameFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureDriving_BehaviourSteeringAngleFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureDriving_BehaviourThrottleFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureDriving_BehaviourBrakeFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureDriving_BehaviourGearFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureDriving_BehaviourHandbrakeFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureDriving_BehaviourRpmFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureDriving_BehaviourKeyEventFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureDriving_BehaviourPedalAngleFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureDriving_BehaviourPedalPressureFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureDriving_BehaviourSteerSpeedFigure;

		/**
		 * @generated
		 */
		public Driving_BehaviourFigure() {

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

			fFigureDriving_BehaviourPrepDistanceForDestinationFigure = new WrappingLabel();

			fFigureDriving_BehaviourPrepDistanceForDestinationFigure.setText("<...>");

			this.add(fFigureDriving_BehaviourPrepDistanceForDestinationFigure);

			fFigureDriving_BehaviourPrepDistanceForTurnFigure = new WrappingLabel();

			fFigureDriving_BehaviourPrepDistanceForTurnFigure.setText("<...>");

			this.add(fFigureDriving_BehaviourPrepDistanceForTurnFigure);

			fFigureDriving_BehaviourInitialSpeed_minFigure = new WrappingLabel();

			fFigureDriving_BehaviourInitialSpeed_minFigure.setText("<...>");

			this.add(fFigureDriving_BehaviourInitialSpeed_minFigure);

			fFigureDriving_BehaviourInitialSpeed_maxFigure = new WrappingLabel();

			fFigureDriving_BehaviourInitialSpeed_maxFigure.setText("<...>");

			this.add(fFigureDriving_BehaviourInitialSpeed_maxFigure);

			fFigureDriving_BehaviourInitialSpeed_precisionFigure = new WrappingLabel();

			fFigureDriving_BehaviourInitialSpeed_precisionFigure.setText("<...>");

			this.add(fFigureDriving_BehaviourInitialSpeed_precisionFigure);

			fFigureDriving_BehaviourDesiredSpeed_minFigure = new WrappingLabel();

			fFigureDriving_BehaviourDesiredSpeed_minFigure.setText("<...>");

			this.add(fFigureDriving_BehaviourDesiredSpeed_minFigure);

			fFigureDriving_BehaviourDesiredSpeed_maxFigure = new WrappingLabel();

			fFigureDriving_BehaviourDesiredSpeed_maxFigure.setText("<...>");

			this.add(fFigureDriving_BehaviourDesiredSpeed_maxFigure);

			fFigureDriving_BehaviourNameFigure = new WrappingLabel();

			fFigureDriving_BehaviourNameFigure.setText("<...>");

			this.add(fFigureDriving_BehaviourNameFigure);

			fFigureDriving_BehaviourSteeringAngleFigure = new WrappingLabel();

			fFigureDriving_BehaviourSteeringAngleFigure.setText("<...>");

			this.add(fFigureDriving_BehaviourSteeringAngleFigure);

			fFigureDriving_BehaviourThrottleFigure = new WrappingLabel();

			fFigureDriving_BehaviourThrottleFigure.setText("<...>");

			this.add(fFigureDriving_BehaviourThrottleFigure);

			fFigureDriving_BehaviourBrakeFigure = new WrappingLabel();

			fFigureDriving_BehaviourBrakeFigure.setText("<...>");

			this.add(fFigureDriving_BehaviourBrakeFigure);

			fFigureDriving_BehaviourGearFigure = new WrappingLabel();

			fFigureDriving_BehaviourGearFigure.setText("<...>");

			this.add(fFigureDriving_BehaviourGearFigure);

			fFigureDriving_BehaviourHandbrakeFigure = new WrappingLabel();

			fFigureDriving_BehaviourHandbrakeFigure.setText("<...>");

			this.add(fFigureDriving_BehaviourHandbrakeFigure);

			fFigureDriving_BehaviourRpmFigure = new WrappingLabel();

			fFigureDriving_BehaviourRpmFigure.setText("<...>");

			this.add(fFigureDriving_BehaviourRpmFigure);

			fFigureDriving_BehaviourKeyEventFigure = new WrappingLabel();

			fFigureDriving_BehaviourKeyEventFigure.setText("<...>");

			this.add(fFigureDriving_BehaviourKeyEventFigure);

			fFigureDriving_BehaviourPedalAngleFigure = new WrappingLabel();

			fFigureDriving_BehaviourPedalAngleFigure.setText("<...>");

			this.add(fFigureDriving_BehaviourPedalAngleFigure);

			fFigureDriving_BehaviourPedalPressureFigure = new WrappingLabel();

			fFigureDriving_BehaviourPedalPressureFigure.setText("<...>");

			this.add(fFigureDriving_BehaviourPedalPressureFigure);

			fFigureDriving_BehaviourSteerSpeedFigure = new WrappingLabel();

			fFigureDriving_BehaviourSteerSpeedFigure.setText("<...>");

			this.add(fFigureDriving_BehaviourSteerSpeedFigure);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureDriving_BehaviourPrepDistanceForDestinationFigure() {
			return fFigureDriving_BehaviourPrepDistanceForDestinationFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureDriving_BehaviourPrepDistanceForTurnFigure() {
			return fFigureDriving_BehaviourPrepDistanceForTurnFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureDriving_BehaviourInitialSpeed_minFigure() {
			return fFigureDriving_BehaviourInitialSpeed_minFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureDriving_BehaviourInitialSpeed_maxFigure() {
			return fFigureDriving_BehaviourInitialSpeed_maxFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureDriving_BehaviourInitialSpeed_precisionFigure() {
			return fFigureDriving_BehaviourInitialSpeed_precisionFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureDriving_BehaviourDesiredSpeed_minFigure() {
			return fFigureDriving_BehaviourDesiredSpeed_minFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureDriving_BehaviourDesiredSpeed_maxFigure() {
			return fFigureDriving_BehaviourDesiredSpeed_maxFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureDriving_BehaviourNameFigure() {
			return fFigureDriving_BehaviourNameFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureDriving_BehaviourSteeringAngleFigure() {
			return fFigureDriving_BehaviourSteeringAngleFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureDriving_BehaviourThrottleFigure() {
			return fFigureDriving_BehaviourThrottleFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureDriving_BehaviourBrakeFigure() {
			return fFigureDriving_BehaviourBrakeFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureDriving_BehaviourGearFigure() {
			return fFigureDriving_BehaviourGearFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureDriving_BehaviourHandbrakeFigure() {
			return fFigureDriving_BehaviourHandbrakeFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureDriving_BehaviourRpmFigure() {
			return fFigureDriving_BehaviourRpmFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureDriving_BehaviourKeyEventFigure() {
			return fFigureDriving_BehaviourKeyEventFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureDriving_BehaviourPedalAngleFigure() {
			return fFigureDriving_BehaviourPedalAngleFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureDriving_BehaviourPedalPressureFigure() {
			return fFigureDriving_BehaviourPedalPressureFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureDriving_BehaviourSteerSpeedFigure() {
			return fFigureDriving_BehaviourSteerSpeedFigure;
		}

	}

}
