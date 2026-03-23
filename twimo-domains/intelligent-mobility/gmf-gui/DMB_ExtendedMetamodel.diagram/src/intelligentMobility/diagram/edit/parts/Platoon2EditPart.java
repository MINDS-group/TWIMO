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
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.FlowLayoutEditPolicy;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;

/**
 * @generated
 */
public class Platoon2EditPart extends ShapeNodeEditPart {

	/**
	* @generated
	*/
	public static final int VISUAL_ID = 2035;

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
	public Platoon2EditPart(View view) {
		super(view);
	}

	/**
	* @generated
	*/
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new intelligentMobility.diagram.edit.policies.Platoon2ItemSemanticEditPolicy());
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
		return primaryShape = new PlatoonFigure();
	}

	/**
	* @generated
	*/
	public PlatoonFigure getPrimaryShape() {
		return (PlatoonFigure) primaryShape;
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
	public class PlatoonFigure extends RectangleFigure {

		/**
		 * @generated
		 */
		private WrappingLabel fFigurePlatoonTypeFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigurePlatoonMaxSpeedFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigurePlatoonVehicleWidth_minFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigurePlatoonVehicleWidth_maxFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigurePlatoonVehicleWidth_precisionFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigurePlatoonVehicleLength_minFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigurePlatoonVehicleLength_maxFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigurePlatoonVehicleLength_precisionFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigurePlatoonVehicleHeight_minFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigurePlatoonVehicleHeight_maxFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigurePlatoonVehicleHeight_precisionFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigurePlatoonSpeedFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigurePlatoonStopFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigurePlatoonNameFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigurePlatoonV2vTimeFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigurePlatoonFollowerCountFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigurePlatoonResetColorFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigurePlatoonColorR_minFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigurePlatoonColorR_maxFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigurePlatoonColorG_minFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigurePlatoonColorG_maxFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigurePlatoonColorB_minFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigurePlatoonColorB_maxFigure;

		/**
		 * @generated
		 */
		public PlatoonFigure() {

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

			fFigurePlatoonTypeFigure = new WrappingLabel();

			fFigurePlatoonTypeFigure.setText("<...>");

			this.add(fFigurePlatoonTypeFigure);

			fFigurePlatoonMaxSpeedFigure = new WrappingLabel();

			fFigurePlatoonMaxSpeedFigure.setText("<...>");

			this.add(fFigurePlatoonMaxSpeedFigure);

			fFigurePlatoonVehicleWidth_minFigure = new WrappingLabel();

			fFigurePlatoonVehicleWidth_minFigure.setText("<...>");

			this.add(fFigurePlatoonVehicleWidth_minFigure);

			fFigurePlatoonVehicleWidth_maxFigure = new WrappingLabel();

			fFigurePlatoonVehicleWidth_maxFigure.setText("<...>");

			this.add(fFigurePlatoonVehicleWidth_maxFigure);

			fFigurePlatoonVehicleWidth_precisionFigure = new WrappingLabel();

			fFigurePlatoonVehicleWidth_precisionFigure.setText("<...>");

			this.add(fFigurePlatoonVehicleWidth_precisionFigure);

			fFigurePlatoonVehicleLength_minFigure = new WrappingLabel();

			fFigurePlatoonVehicleLength_minFigure.setText("<...>");

			this.add(fFigurePlatoonVehicleLength_minFigure);

			fFigurePlatoonVehicleLength_maxFigure = new WrappingLabel();

			fFigurePlatoonVehicleLength_maxFigure.setText("<...>");

			this.add(fFigurePlatoonVehicleLength_maxFigure);

			fFigurePlatoonVehicleLength_precisionFigure = new WrappingLabel();

			fFigurePlatoonVehicleLength_precisionFigure.setText("<...>");

			this.add(fFigurePlatoonVehicleLength_precisionFigure);

			fFigurePlatoonVehicleHeight_minFigure = new WrappingLabel();

			fFigurePlatoonVehicleHeight_minFigure.setText("<...>");

			this.add(fFigurePlatoonVehicleHeight_minFigure);

			fFigurePlatoonVehicleHeight_maxFigure = new WrappingLabel();

			fFigurePlatoonVehicleHeight_maxFigure.setText("<...>");

			this.add(fFigurePlatoonVehicleHeight_maxFigure);

			fFigurePlatoonVehicleHeight_precisionFigure = new WrappingLabel();

			fFigurePlatoonVehicleHeight_precisionFigure.setText("<...>");

			this.add(fFigurePlatoonVehicleHeight_precisionFigure);

			fFigurePlatoonSpeedFigure = new WrappingLabel();

			fFigurePlatoonSpeedFigure.setText("<...>");

			this.add(fFigurePlatoonSpeedFigure);

			fFigurePlatoonStopFigure = new WrappingLabel();

			fFigurePlatoonStopFigure.setText("<...>");

			this.add(fFigurePlatoonStopFigure);

			fFigurePlatoonNameFigure = new WrappingLabel();

			fFigurePlatoonNameFigure.setText("<...>");

			this.add(fFigurePlatoonNameFigure);

			fFigurePlatoonV2vTimeFigure = new WrappingLabel();

			fFigurePlatoonV2vTimeFigure.setText("<...>");

			this.add(fFigurePlatoonV2vTimeFigure);

			fFigurePlatoonFollowerCountFigure = new WrappingLabel();

			fFigurePlatoonFollowerCountFigure.setText("<...>");

			this.add(fFigurePlatoonFollowerCountFigure);

			fFigurePlatoonResetColorFigure = new WrappingLabel();

			fFigurePlatoonResetColorFigure.setText("<...>");

			this.add(fFigurePlatoonResetColorFigure);

			fFigurePlatoonColorR_minFigure = new WrappingLabel();

			fFigurePlatoonColorR_minFigure.setText("<...>");

			this.add(fFigurePlatoonColorR_minFigure);

			fFigurePlatoonColorR_maxFigure = new WrappingLabel();

			fFigurePlatoonColorR_maxFigure.setText("<...>");

			this.add(fFigurePlatoonColorR_maxFigure);

			fFigurePlatoonColorG_minFigure = new WrappingLabel();

			fFigurePlatoonColorG_minFigure.setText("<...>");

			this.add(fFigurePlatoonColorG_minFigure);

			fFigurePlatoonColorG_maxFigure = new WrappingLabel();

			fFigurePlatoonColorG_maxFigure.setText("<...>");

			this.add(fFigurePlatoonColorG_maxFigure);

			fFigurePlatoonColorB_minFigure = new WrappingLabel();

			fFigurePlatoonColorB_minFigure.setText("<...>");

			this.add(fFigurePlatoonColorB_minFigure);

			fFigurePlatoonColorB_maxFigure = new WrappingLabel();

			fFigurePlatoonColorB_maxFigure.setText("<...>");

			this.add(fFigurePlatoonColorB_maxFigure);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigurePlatoonTypeFigure() {
			return fFigurePlatoonTypeFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigurePlatoonMaxSpeedFigure() {
			return fFigurePlatoonMaxSpeedFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigurePlatoonVehicleWidth_minFigure() {
			return fFigurePlatoonVehicleWidth_minFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigurePlatoonVehicleWidth_maxFigure() {
			return fFigurePlatoonVehicleWidth_maxFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigurePlatoonVehicleWidth_precisionFigure() {
			return fFigurePlatoonVehicleWidth_precisionFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigurePlatoonVehicleLength_minFigure() {
			return fFigurePlatoonVehicleLength_minFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigurePlatoonVehicleLength_maxFigure() {
			return fFigurePlatoonVehicleLength_maxFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigurePlatoonVehicleLength_precisionFigure() {
			return fFigurePlatoonVehicleLength_precisionFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigurePlatoonVehicleHeight_minFigure() {
			return fFigurePlatoonVehicleHeight_minFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigurePlatoonVehicleHeight_maxFigure() {
			return fFigurePlatoonVehicleHeight_maxFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigurePlatoonVehicleHeight_precisionFigure() {
			return fFigurePlatoonVehicleHeight_precisionFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigurePlatoonSpeedFigure() {
			return fFigurePlatoonSpeedFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigurePlatoonStopFigure() {
			return fFigurePlatoonStopFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigurePlatoonNameFigure() {
			return fFigurePlatoonNameFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigurePlatoonV2vTimeFigure() {
			return fFigurePlatoonV2vTimeFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigurePlatoonFollowerCountFigure() {
			return fFigurePlatoonFollowerCountFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigurePlatoonResetColorFigure() {
			return fFigurePlatoonResetColorFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigurePlatoonColorR_minFigure() {
			return fFigurePlatoonColorR_minFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigurePlatoonColorR_maxFigure() {
			return fFigurePlatoonColorR_maxFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigurePlatoonColorG_minFigure() {
			return fFigurePlatoonColorG_minFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigurePlatoonColorG_maxFigure() {
			return fFigurePlatoonColorG_maxFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigurePlatoonColorB_minFigure() {
			return fFigurePlatoonColorB_minFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigurePlatoonColorB_maxFigure() {
			return fFigurePlatoonColorB_maxFigure;
		}

	}

}
