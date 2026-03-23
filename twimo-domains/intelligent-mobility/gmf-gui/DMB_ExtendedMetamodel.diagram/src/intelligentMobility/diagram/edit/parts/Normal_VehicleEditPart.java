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
public class Normal_VehicleEditPart extends ShapeNodeEditPart {

	/**
	* @generated
	*/
	public static final int VISUAL_ID = 2036;

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
	public Normal_VehicleEditPart(View view) {
		super(view);
	}

	/**
	* @generated
	*/
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new intelligentMobility.diagram.edit.policies.Normal_VehicleItemSemanticEditPolicy());
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
		return primaryShape = new Normal_VehicleFigure();
	}

	/**
	* @generated
	*/
	public Normal_VehicleFigure getPrimaryShape() {
		return (Normal_VehicleFigure) primaryShape;
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
	public class Normal_VehicleFigure extends RectangleFigure {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureNormal_VehicleTypeFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureNormal_VehicleMaxSpeedFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureNormal_VehicleVehicleWidth_minFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureNormal_VehicleVehicleWidth_maxFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureNormal_VehicleVehicleWidth_precisionFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureNormal_VehicleVehicleLength_minFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureNormal_VehicleVehicleLength_maxFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureNormal_VehicleVehicleLength_precisionFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureNormal_VehicleVehicleHeight_minFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureNormal_VehicleVehicleHeight_maxFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureNormal_VehicleVehicleHeight_precisionFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureNormal_VehicleSpeedFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureNormal_VehicleStopFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureNormal_VehicleNameFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureNormal_VehicleResetColorFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureNormal_VehicleColorR_minFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureNormal_VehicleColorR_maxFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureNormal_VehicleColorG_minFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureNormal_VehicleColorG_maxFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureNormal_VehicleColorB_minFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureNormal_VehicleColorB_maxFigure;

		/**
		 * @generated
		 */
		public Normal_VehicleFigure() {

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

			fFigureNormal_VehicleTypeFigure = new WrappingLabel();

			fFigureNormal_VehicleTypeFigure.setText("<...>");

			this.add(fFigureNormal_VehicleTypeFigure);

			fFigureNormal_VehicleMaxSpeedFigure = new WrappingLabel();

			fFigureNormal_VehicleMaxSpeedFigure.setText("<...>");

			this.add(fFigureNormal_VehicleMaxSpeedFigure);

			fFigureNormal_VehicleVehicleWidth_minFigure = new WrappingLabel();

			fFigureNormal_VehicleVehicleWidth_minFigure.setText("<...>");

			this.add(fFigureNormal_VehicleVehicleWidth_minFigure);

			fFigureNormal_VehicleVehicleWidth_maxFigure = new WrappingLabel();

			fFigureNormal_VehicleVehicleWidth_maxFigure.setText("<...>");

			this.add(fFigureNormal_VehicleVehicleWidth_maxFigure);

			fFigureNormal_VehicleVehicleWidth_precisionFigure = new WrappingLabel();

			fFigureNormal_VehicleVehicleWidth_precisionFigure.setText("<...>");

			this.add(fFigureNormal_VehicleVehicleWidth_precisionFigure);

			fFigureNormal_VehicleVehicleLength_minFigure = new WrappingLabel();

			fFigureNormal_VehicleVehicleLength_minFigure.setText("<...>");

			this.add(fFigureNormal_VehicleVehicleLength_minFigure);

			fFigureNormal_VehicleVehicleLength_maxFigure = new WrappingLabel();

			fFigureNormal_VehicleVehicleLength_maxFigure.setText("<...>");

			this.add(fFigureNormal_VehicleVehicleLength_maxFigure);

			fFigureNormal_VehicleVehicleLength_precisionFigure = new WrappingLabel();

			fFigureNormal_VehicleVehicleLength_precisionFigure.setText("<...>");

			this.add(fFigureNormal_VehicleVehicleLength_precisionFigure);

			fFigureNormal_VehicleVehicleHeight_minFigure = new WrappingLabel();

			fFigureNormal_VehicleVehicleHeight_minFigure.setText("<...>");

			this.add(fFigureNormal_VehicleVehicleHeight_minFigure);

			fFigureNormal_VehicleVehicleHeight_maxFigure = new WrappingLabel();

			fFigureNormal_VehicleVehicleHeight_maxFigure.setText("<...>");

			this.add(fFigureNormal_VehicleVehicleHeight_maxFigure);

			fFigureNormal_VehicleVehicleHeight_precisionFigure = new WrappingLabel();

			fFigureNormal_VehicleVehicleHeight_precisionFigure.setText("<...>");

			this.add(fFigureNormal_VehicleVehicleHeight_precisionFigure);

			fFigureNormal_VehicleSpeedFigure = new WrappingLabel();

			fFigureNormal_VehicleSpeedFigure.setText("<...>");

			this.add(fFigureNormal_VehicleSpeedFigure);

			fFigureNormal_VehicleStopFigure = new WrappingLabel();

			fFigureNormal_VehicleStopFigure.setText("<...>");

			this.add(fFigureNormal_VehicleStopFigure);

			fFigureNormal_VehicleNameFigure = new WrappingLabel();

			fFigureNormal_VehicleNameFigure.setText("<...>");

			this.add(fFigureNormal_VehicleNameFigure);

			fFigureNormal_VehicleResetColorFigure = new WrappingLabel();

			fFigureNormal_VehicleResetColorFigure.setText("<...>");

			this.add(fFigureNormal_VehicleResetColorFigure);

			fFigureNormal_VehicleColorR_minFigure = new WrappingLabel();

			fFigureNormal_VehicleColorR_minFigure.setText("<...>");

			this.add(fFigureNormal_VehicleColorR_minFigure);

			fFigureNormal_VehicleColorR_maxFigure = new WrappingLabel();

			fFigureNormal_VehicleColorR_maxFigure.setText("<...>");

			this.add(fFigureNormal_VehicleColorR_maxFigure);

			fFigureNormal_VehicleColorG_minFigure = new WrappingLabel();

			fFigureNormal_VehicleColorG_minFigure.setText("<...>");

			this.add(fFigureNormal_VehicleColorG_minFigure);

			fFigureNormal_VehicleColorG_maxFigure = new WrappingLabel();

			fFigureNormal_VehicleColorG_maxFigure.setText("<...>");

			this.add(fFigureNormal_VehicleColorG_maxFigure);

			fFigureNormal_VehicleColorB_minFigure = new WrappingLabel();

			fFigureNormal_VehicleColorB_minFigure.setText("<...>");

			this.add(fFigureNormal_VehicleColorB_minFigure);

			fFigureNormal_VehicleColorB_maxFigure = new WrappingLabel();

			fFigureNormal_VehicleColorB_maxFigure.setText("<...>");

			this.add(fFigureNormal_VehicleColorB_maxFigure);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureNormal_VehicleTypeFigure() {
			return fFigureNormal_VehicleTypeFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureNormal_VehicleMaxSpeedFigure() {
			return fFigureNormal_VehicleMaxSpeedFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureNormal_VehicleVehicleWidth_minFigure() {
			return fFigureNormal_VehicleVehicleWidth_minFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureNormal_VehicleVehicleWidth_maxFigure() {
			return fFigureNormal_VehicleVehicleWidth_maxFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureNormal_VehicleVehicleWidth_precisionFigure() {
			return fFigureNormal_VehicleVehicleWidth_precisionFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureNormal_VehicleVehicleLength_minFigure() {
			return fFigureNormal_VehicleVehicleLength_minFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureNormal_VehicleVehicleLength_maxFigure() {
			return fFigureNormal_VehicleVehicleLength_maxFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureNormal_VehicleVehicleLength_precisionFigure() {
			return fFigureNormal_VehicleVehicleLength_precisionFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureNormal_VehicleVehicleHeight_minFigure() {
			return fFigureNormal_VehicleVehicleHeight_minFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureNormal_VehicleVehicleHeight_maxFigure() {
			return fFigureNormal_VehicleVehicleHeight_maxFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureNormal_VehicleVehicleHeight_precisionFigure() {
			return fFigureNormal_VehicleVehicleHeight_precisionFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureNormal_VehicleSpeedFigure() {
			return fFigureNormal_VehicleSpeedFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureNormal_VehicleStopFigure() {
			return fFigureNormal_VehicleStopFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureNormal_VehicleNameFigure() {
			return fFigureNormal_VehicleNameFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureNormal_VehicleResetColorFigure() {
			return fFigureNormal_VehicleResetColorFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureNormal_VehicleColorR_minFigure() {
			return fFigureNormal_VehicleColorR_minFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureNormal_VehicleColorR_maxFigure() {
			return fFigureNormal_VehicleColorR_maxFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureNormal_VehicleColorG_minFigure() {
			return fFigureNormal_VehicleColorG_minFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureNormal_VehicleColorG_maxFigure() {
			return fFigureNormal_VehicleColorG_maxFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureNormal_VehicleColorB_minFigure() {
			return fFigureNormal_VehicleColorB_minFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureNormal_VehicleColorB_maxFigure() {
			return fFigureNormal_VehicleColorB_maxFigure;
		}

	}

}
