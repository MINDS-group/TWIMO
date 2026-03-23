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
public class ForwardItemSemanticEditPolicy
		extends intelligentMobility.diagram.edit.policies.DrivingBehaviourMetamodelBaseItemSemanticEditPolicy {

	/**
	* @generated
	*/
	public ForwardItemSemanticEditPolicy() {
		super(intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Forward_2011);
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
					incomingLink) == intelligentMobility.diagram.edit.parts.Link_Following_ForwardEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getVisualID(
					incomingLink) == intelligentMobility.diagram.edit.parts.Link_Action_ForwardEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
		}
		for (Iterator /*[?]*/ it = view.getSourceEdges().iterator(); it.hasNext();) {
			Edge outgoingLink = (Edge) it.next();
			if (intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getVisualID(
					outgoingLink) == intelligentMobility.diagram.edit.parts.Link_AbnormalBehaviour_ActionEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getVisualID(
					outgoingLink) == intelligentMobility.diagram.edit.parts.Link_Action_BackwardEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getVisualID(
					outgoingLink) == intelligentMobility.diagram.edit.parts.Link_Action_ForwardEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getVisualID(
					outgoingLink) == intelligentMobility.diagram.edit.parts.Link_Action_TurnEditPart.VISUAL_ID) {
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
		if (intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_AbnormalBehaviour_Action_4010 == req
				.getElementType()) {
			return getGEFWrapper(
					new intelligentMobility.diagram.edit.commands.Link_AbnormalBehaviour_ActionCreateCommand(req,
							req.getSource(), req.getTarget()));
		}
		if (intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Following_Forward_4011 == req
				.getElementType()) {
			return null;
		}
		if (intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Action_Backward_4044 == req
				.getElementType()) {
			return getGEFWrapper(new intelligentMobility.diagram.edit.commands.Link_Action_BackwardCreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Action_Forward_4045 == req
				.getElementType()) {
			return getGEFWrapper(new intelligentMobility.diagram.edit.commands.Link_Action_ForwardCreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Action_Turn_4046 == req
				.getElementType()) {
			return getGEFWrapper(new intelligentMobility.diagram.edit.commands.Link_Action_TurnCreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_AbnormalBehaviour_Action_4010 == req
				.getElementType()) {
			return null;
		}
		if (intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Following_Forward_4011 == req
				.getElementType()) {
			return getGEFWrapper(new intelligentMobility.diagram.edit.commands.Link_Following_ForwardCreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Action_Backward_4044 == req
				.getElementType()) {
			return null;
		}
		if (intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Action_Forward_4045 == req
				.getElementType()) {
			return getGEFWrapper(new intelligentMobility.diagram.edit.commands.Link_Action_ForwardCreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Action_Turn_4046 == req
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
		case intelligentMobility.diagram.edit.parts.Link_AbnormalBehaviour_ActionEditPart.VISUAL_ID:
			return getGEFWrapper(
					new intelligentMobility.diagram.edit.commands.Link_AbnormalBehaviour_ActionReorientCommand(req));
		case intelligentMobility.diagram.edit.parts.Link_Following_ForwardEditPart.VISUAL_ID:
			return getGEFWrapper(
					new intelligentMobility.diagram.edit.commands.Link_Following_ForwardReorientCommand(req));
		case intelligentMobility.diagram.edit.parts.Link_Action_BackwardEditPart.VISUAL_ID:
			return getGEFWrapper(
					new intelligentMobility.diagram.edit.commands.Link_Action_BackwardReorientCommand(req));
		case intelligentMobility.diagram.edit.parts.Link_Action_ForwardEditPart.VISUAL_ID:
			return getGEFWrapper(new intelligentMobility.diagram.edit.commands.Link_Action_ForwardReorientCommand(req));
		case intelligentMobility.diagram.edit.parts.Link_Action_TurnEditPart.VISUAL_ID:
			return getGEFWrapper(new intelligentMobility.diagram.edit.commands.Link_Action_TurnReorientCommand(req));
		}
		return super.getReorientRelationshipCommand(req);
	}

}
