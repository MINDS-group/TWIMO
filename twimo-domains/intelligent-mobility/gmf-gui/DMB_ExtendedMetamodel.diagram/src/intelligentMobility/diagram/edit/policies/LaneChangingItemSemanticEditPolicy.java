package intelligentMobility.diagram.edit.policies;

import java.util.Iterator;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class LaneChangingItemSemanticEditPolicy
		extends intelligentMobility.diagram.edit.policies.DrivingBehaviourMetamodelBaseItemSemanticEditPolicy {

	/**
	* @generated
	*/
	public LaneChangingItemSemanticEditPolicy() {
		super(intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.LaneChanging_2015);
	}

	/**
	* @generated
	*/
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		View view = (View) getHost().getModel();
		CompositeTransactionalCommand cmd = new CompositeTransactionalCommand(getEditingDomain(), null);
		cmd.setTransactionNestingEnabled(false);
		for (Iterator /*[?]*/ it = view.getTargetEdges().iterator(); it.hasNext();) {
			Edge incomingLink = (Edge) it.next();
			if (intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getVisualID(
					incomingLink) == intelligentMobility.diagram.edit.parts.Link_LaneChanging_TurnEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getVisualID(
					incomingLink) == intelligentMobility.diagram.edit.parts.Link_Following_MinGapEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getVisualID(
					incomingLink) == intelligentMobility.diagram.edit.parts.Link_NormalBehaviour_LaneChangingEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getVisualID(
					incomingLink) == intelligentMobility.diagram.edit.parts.Link_Following_LaneChangingEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
		}
		for (Iterator /*[?]*/ it = view.getSourceEdges().iterator(); it.hasNext();) {
			Edge outgoingLink = (Edge) it.next();
			if (intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getVisualID(
					outgoingLink) == intelligentMobility.diagram.edit.parts.Link_LaneChanging_EnvironmentConditionEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getVisualID(
					outgoingLink) == intelligentMobility.diagram.edit.parts.Link_LaneChanging_GapAcceptanceEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
		}
		EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
		if (annotation == null) {
			// there are indirectly referenced children, need extra commands: false
			addDestroyShortcutsCommand(cmd, view);
			// delete host element
			cmd.add(new DestroyElementCommand(req));
		} else {
			cmd.add(new DeleteCommand(getEditingDomain(), view));
		}
		return getGEFWrapper(cmd.reduce());
	}

	/**
	 * @generated
	 */
	protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
		Command command = req.getTarget() == null ? getStartCreateRelationshipCommand(req)
				: getCompleteCreateRelationshipCommand(req);
		return command != null ? command : super.getCreateRelationshipCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getStartCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_LaneChanging_Turn_4016 == req
				.getElementType()) {
			return null;
		}
		if (intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Following_MinGap_4019 == req
				.getElementType()) {
			return null;
		}
		if (intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_NormalBehaviour_LaneChanging_4020 == req
				.getElementType()) {
			return null;
		}
		if (intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_LaneChanging_EnvironmentCondition_4032 == req
				.getElementType()) {
			return getGEFWrapper(
					new intelligentMobility.diagram.edit.commands.Link_LaneChanging_EnvironmentConditionCreateCommand(
							req, req.getSource(), req.getTarget()));
		}
		if (intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_LaneChanging_GapAcceptance_4033 == req
				.getElementType()) {
			return getGEFWrapper(
					new intelligentMobility.diagram.edit.commands.Link_LaneChanging_GapAcceptanceCreateCommand(req,
							req.getSource(), req.getTarget()));
		}
		if (intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Following_LaneChanging_4043 == req
				.getElementType()) {
			return null;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_LaneChanging_Turn_4016 == req
				.getElementType()) {
			return getGEFWrapper(new intelligentMobility.diagram.edit.commands.Link_LaneChanging_TurnCreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Following_MinGap_4019 == req
				.getElementType()) {
			return getGEFWrapper(new intelligentMobility.diagram.edit.commands.Link_Following_MinGapCreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_NormalBehaviour_LaneChanging_4020 == req
				.getElementType()) {
			return getGEFWrapper(
					new intelligentMobility.diagram.edit.commands.Link_NormalBehaviour_LaneChangingCreateCommand(req,
							req.getSource(), req.getTarget()));
		}
		if (intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_LaneChanging_EnvironmentCondition_4032 == req
				.getElementType()) {
			return null;
		}
		if (intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_LaneChanging_GapAcceptance_4033 == req
				.getElementType()) {
			return null;
		}
		if (intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Following_LaneChanging_4043 == req
				.getElementType()) {
			return getGEFWrapper(new intelligentMobility.diagram.edit.commands.Link_Following_LaneChangingCreateCommand(
					req, req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * Returns command to reorient EClass based link. New link target or source
	 * should be the domain model element associated with this node.
	 * 
	 * @generated
	 */
	protected Command getReorientRelationshipCommand(ReorientRelationshipRequest req) {
		switch (getVisualID(req)) {
		case intelligentMobility.diagram.edit.parts.Link_LaneChanging_TurnEditPart.VISUAL_ID:
			return getGEFWrapper(
					new intelligentMobility.diagram.edit.commands.Link_LaneChanging_TurnReorientCommand(req));
		case intelligentMobility.diagram.edit.parts.Link_Following_MinGapEditPart.VISUAL_ID:
			return getGEFWrapper(
					new intelligentMobility.diagram.edit.commands.Link_Following_MinGapReorientCommand(req));
		case intelligentMobility.diagram.edit.parts.Link_NormalBehaviour_LaneChangingEditPart.VISUAL_ID:
			return getGEFWrapper(
					new intelligentMobility.diagram.edit.commands.Link_NormalBehaviour_LaneChangingReorientCommand(
							req));
		case intelligentMobility.diagram.edit.parts.Link_LaneChanging_EnvironmentConditionEditPart.VISUAL_ID:
			return getGEFWrapper(
					new intelligentMobility.diagram.edit.commands.Link_LaneChanging_EnvironmentConditionReorientCommand(
							req));
		case intelligentMobility.diagram.edit.parts.Link_LaneChanging_GapAcceptanceEditPart.VISUAL_ID:
			return getGEFWrapper(
					new intelligentMobility.diagram.edit.commands.Link_LaneChanging_GapAcceptanceReorientCommand(req));
		case intelligentMobility.diagram.edit.parts.Link_Following_LaneChangingEditPart.VISUAL_ID:
			return getGEFWrapper(
					new intelligentMobility.diagram.edit.commands.Link_Following_LaneChangingReorientCommand(req));
		}
		return super.getReorientRelationshipCommand(req);
	}

}
