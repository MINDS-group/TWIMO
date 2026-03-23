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
public class Vehicle_ConfigurationEditPart extends ShapeNodeEditPart {

	/**
	* @generated
	*/
	public static final int VISUAL_ID = 2008;

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
	public Vehicle_ConfigurationEditPart(View view) {
		super(view);
	}

	/**
	* @generated
	*/
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new intelligentMobility.diagram.edit.policies.Vehicle_ConfigurationItemSemanticEditPolicy());
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
		return primaryShape = new Vehicle_ConfigurationFigure();
	}

	/**
	* @generated
	*/
	public Vehicle_ConfigurationFigure getPrimaryShape() {
		return (Vehicle_ConfigurationFigure) primaryShape;
	}

	/**
	* @generated
	*/
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof intelligentMobility.diagram.edit.parts.Vehicle_ConfigurationBrandNameEditPart) {
			((intelligentMobility.diagram.edit.parts.Vehicle_ConfigurationBrandNameEditPart) childEditPart)
					.setLabel(getPrimaryShape().getFigureVehicle_ConfigurationBrandNameFigure());
			return true;
		}
		return false;
	}

	/**
	* @generated
	*/
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof intelligentMobility.diagram.edit.parts.Vehicle_ConfigurationBrandNameEditPart) {
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
				.getType(intelligentMobility.diagram.edit.parts.Vehicle_ConfigurationBrandNameEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public class Vehicle_ConfigurationFigure extends RectangleFigure {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureVehicle_ConfigurationBrandNameFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureVehicle_ConfigurationColorR_minFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureVehicle_ConfigurationColorR_maxFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureVehicle_ConfigurationColorG_minFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureVehicle_ConfigurationColorG_maxFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureVehicle_ConfigurationColorB_minFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureVehicle_ConfigurationColorB_maxFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureVehicle_ConfigurationGpsYawFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureVehicle_ConfigurationGpsPitchFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureVehicle_ConfigurationGpsRollFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureVehicle_ConfigurationLatitudeFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureVehicle_ConfigurationLongitudeFigure;

		/**
		 * @generated
		 */
		public Vehicle_ConfigurationFigure() {

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

			fFigureVehicle_ConfigurationBrandNameFigure = new WrappingLabel();

			fFigureVehicle_ConfigurationBrandNameFigure.setText("<...>");

			this.add(fFigureVehicle_ConfigurationBrandNameFigure);

			fFigureVehicle_ConfigurationColorR_minFigure = new WrappingLabel();

			fFigureVehicle_ConfigurationColorR_minFigure.setText("<...>");

			this.add(fFigureVehicle_ConfigurationColorR_minFigure);

			fFigureVehicle_ConfigurationColorR_maxFigure = new WrappingLabel();

			fFigureVehicle_ConfigurationColorR_maxFigure.setText("<...>");

			this.add(fFigureVehicle_ConfigurationColorR_maxFigure);

			fFigureVehicle_ConfigurationColorG_minFigure = new WrappingLabel();

			fFigureVehicle_ConfigurationColorG_minFigure.setText("<...>");

			this.add(fFigureVehicle_ConfigurationColorG_minFigure);

			fFigureVehicle_ConfigurationColorG_maxFigure = new WrappingLabel();

			fFigureVehicle_ConfigurationColorG_maxFigure.setText("<...>");

			this.add(fFigureVehicle_ConfigurationColorG_maxFigure);

			fFigureVehicle_ConfigurationColorB_minFigure = new WrappingLabel();

			fFigureVehicle_ConfigurationColorB_minFigure.setText("<...>");

			this.add(fFigureVehicle_ConfigurationColorB_minFigure);

			fFigureVehicle_ConfigurationColorB_maxFigure = new WrappingLabel();

			fFigureVehicle_ConfigurationColorB_maxFigure.setText("<...>");

			this.add(fFigureVehicle_ConfigurationColorB_maxFigure);

			fFigureVehicle_ConfigurationGpsYawFigure = new WrappingLabel();

			fFigureVehicle_ConfigurationGpsYawFigure.setText("<...>");

			this.add(fFigureVehicle_ConfigurationGpsYawFigure);

			fFigureVehicle_ConfigurationGpsPitchFigure = new WrappingLabel();

			fFigureVehicle_ConfigurationGpsPitchFigure.setText("<...>");

			this.add(fFigureVehicle_ConfigurationGpsPitchFigure);

			fFigureVehicle_ConfigurationGpsRollFigure = new WrappingLabel();

			fFigureVehicle_ConfigurationGpsRollFigure.setText("<...>");

			this.add(fFigureVehicle_ConfigurationGpsRollFigure);

			fFigureVehicle_ConfigurationLatitudeFigure = new WrappingLabel();

			fFigureVehicle_ConfigurationLatitudeFigure.setText("<...>");

			this.add(fFigureVehicle_ConfigurationLatitudeFigure);

			fFigureVehicle_ConfigurationLongitudeFigure = new WrappingLabel();

			fFigureVehicle_ConfigurationLongitudeFigure.setText("<...>");

			this.add(fFigureVehicle_ConfigurationLongitudeFigure);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureVehicle_ConfigurationBrandNameFigure() {
			return fFigureVehicle_ConfigurationBrandNameFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureVehicle_ConfigurationColorR_minFigure() {
			return fFigureVehicle_ConfigurationColorR_minFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureVehicle_ConfigurationColorR_maxFigure() {
			return fFigureVehicle_ConfigurationColorR_maxFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureVehicle_ConfigurationColorG_minFigure() {
			return fFigureVehicle_ConfigurationColorG_minFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureVehicle_ConfigurationColorG_maxFigure() {
			return fFigureVehicle_ConfigurationColorG_maxFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureVehicle_ConfigurationColorB_minFigure() {
			return fFigureVehicle_ConfigurationColorB_minFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureVehicle_ConfigurationColorB_maxFigure() {
			return fFigureVehicle_ConfigurationColorB_maxFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureVehicle_ConfigurationGpsYawFigure() {
			return fFigureVehicle_ConfigurationGpsYawFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureVehicle_ConfigurationGpsPitchFigure() {
			return fFigureVehicle_ConfigurationGpsPitchFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureVehicle_ConfigurationGpsRollFigure() {
			return fFigureVehicle_ConfigurationGpsRollFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureVehicle_ConfigurationLatitudeFigure() {
			return fFigureVehicle_ConfigurationLatitudeFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureVehicle_ConfigurationLongitudeFigure() {
			return fFigureVehicle_ConfigurationLongitudeFigure;
		}

	}

}
