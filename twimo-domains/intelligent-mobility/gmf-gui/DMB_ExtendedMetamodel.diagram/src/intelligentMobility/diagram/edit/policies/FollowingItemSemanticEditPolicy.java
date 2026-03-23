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
public class FollowingItemSemanticEditPolicy
		extends intelligentMobility.diagram.edit.policies.DrivingBehaviourMetamodelBaseItemSemanticEditPolicy {

	/**
	* @generated
	*/
	public FollowingItemSemanticEditPolicy() {
		super(intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Following_2019);
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
					incomingLink) == intelligentMobility.diagram.edit.parts.Link_Following_BackwardEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getVisualID(
					incomingLink) == intelligentMobility.diagram.edit.parts.Link_NormalBehaviour_FollowingEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
		}
		for (Iterator /*[?]*/ it = view.getSourceEdges().iterator(); it.hasNext();) {
			Edge outgoingLink = (Edge) it.next();
			if (intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getVisualID(
					outgoingLink) == intelligentMobility.diagram.edit.parts.Link_Following_ForwardEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getVisualID(
					outgoingLink) == intelligentMobility.diagram.edit.parts.Link_Following_MinGapEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getVisualID(
					outgoingLink) == intelligentMobility.diagram.edit.parts.Link_Following_LaneChangingEditPart.VISUAL_ID) {
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
		if (intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Following_Forward_4011 == req
				.getElementType()) {
			return getGEFWrapper(new intelligentMobility.diagram.edit.commands.Link_Following_ForwardCreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Following_MinGap_4019 == req
				.getElementType()) {
			return getGEFWrapper(new intelligentMobility.diagram.edit.commands.Link_Following_MinGapCreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Following_Backward_4029 == req
				.getElementType()) {
			return null;
		}
		if (intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_NormalBehaviour_Following_4034 == req
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
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Following_Forward_4011 == req
				.getElementType()) {
			return null;
		}
		if (intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Following_MinGap_4019 == req
				.getElementType()) {
			return null;
		}
		if (intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Following_Backward_4029 == req
				.getElementType()) {
			return getGEFWrapper(new intelligentMobility.diagram.edit.commands.Link_Following_BackwardCreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_NormalBehaviour_Following_4034 == req
				.getElementType()) {
			return getGEFWrapper(
					new intelligentMobility.diagram.edit.commands.Link_NormalBehaviour_FollowingCreateCommand(req,
							req.getSource(), req.getTarget()));
		}
		if (intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Following_LaneChanging_4043 == req
				.getElementType()) {
			return null;
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
		case intelligentMobility.diagram.edit.parts.Link_Following_ForwardEditPart.VISUAL_ID:
			return getGEFWrapper(
					new intelligentMobility.diagram.edit.commands.Link_Following_ForwardReorientCommand(req));
		case intelligentMobility.diagram.edit.parts.Link_Following_MinGapEditPart.VISUAL_ID:
			return getGEFWrapper(
					new intelligentMobility.diagram.edit.commands.Link_Following_MinGapReorientCommand(req));
		case intelligentMobility.diagram.edit.parts.Link_Following_BackwardEditPart.VISUAL_ID:
			return getGEFWrapper(
					new intelligentMobility.diagram.edit.commands.Link_Following_BackwardReorientCommand(req));
		case intelligentMobility.diagram.edit.parts.Link_NormalBehaviour_FollowingEditPart.VISUAL_ID:
			return getGEFWrapper(
					new intelligentMobility.diagram.edit.commands.Link_NormalBehaviour_FollowingReorientCommand(req));
		case intelligentMobility.diagram.edit.parts.Link_Following_LaneChangingEditPart.VISUAL_ID:
			return getGEFWrapper(
					new intelligentMobility.diagram.edit.commands.Link_Following_LaneChangingReorientCommand(req));
		}
		return super.getReorientRelationshipCommand(req);
	}

}
