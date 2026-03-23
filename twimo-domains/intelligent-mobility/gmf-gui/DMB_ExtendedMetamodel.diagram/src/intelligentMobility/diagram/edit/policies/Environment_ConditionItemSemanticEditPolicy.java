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
public class Environment_ConditionItemSemanticEditPolicy
		extends intelligentMobility.diagram.edit.policies.DrivingBehaviourMetamodelBaseItemSemanticEditPolicy {

	/**
	* @generated
	*/
	public Environment_ConditionItemSemanticEditPolicy() {
		super(intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Environment_Condition_2009);
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
					incomingLink) == intelligentMobility.diagram.edit.parts.Link_DriverPreference_EnvironmentConditionEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getVisualID(
					incomingLink) == intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_LaneTypeEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getVisualID(
					incomingLink) == intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_TrafficConditionEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getVisualID(
					incomingLink) == intelligentMobility.diagram.edit.parts.Link_EnvironmentBackground_EnvironmentConditionEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getVisualID(
					incomingLink) == intelligentMobility.diagram.edit.parts.Link_LaneChanging_EnvironmentConditionEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
		}
		for (Iterator /*[?]*/ it = view.getSourceEdges().iterator(); it.hasNext();) {
			Edge outgoingLink = (Edge) it.next();
			if (intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getVisualID(
					outgoingLink) == intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_WeatherEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getVisualID(
					outgoingLink) == intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_SpecialConditionEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getVisualID(
					outgoingLink) == intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_RegulationsEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getVisualID(
					outgoingLink) == intelligentMobility.diagram.edit.parts.Link_TrafficSituation_EnvironmentConditionEditPart.VISUAL_ID) {
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
		if (intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_DriverPreference_EnvironmentCondition_4009 == req
				.getElementType()) {
			return null;
		}
		if (intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_EnvironmentCondition_LaneType_4012 == req
				.getElementType()) {
			return null;
		}
		if (intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_EnvironmentCondition_TrafficCondition_4017 == req
				.getElementType()) {
			return null;
		}
		if (intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_EnvironmentBackground_EnvironmentCondition_4025 == req
				.getElementType()) {
			return null;
		}
		if (intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_EnvironmentCondition_Weather_4026 == req
				.getElementType()) {
			return getGEFWrapper(
					new intelligentMobility.diagram.edit.commands.Link_EnvironmentCondition_WeatherCreateCommand(req,
							req.getSource(), req.getTarget()));
		}
		if (intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_EnvironmentCondition_SpecialCondition_4027 == req
				.getElementType()) {
			return getGEFWrapper(
					new intelligentMobility.diagram.edit.commands.Link_EnvironmentCondition_SpecialConditionCreateCommand(
							req, req.getSource(), req.getTarget()));
		}
		if (intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_EnvironmentCondition_Regulations_4030 == req
				.getElementType()) {
			return getGEFWrapper(
					new intelligentMobility.diagram.edit.commands.Link_EnvironmentCondition_RegulationsCreateCommand(
							req, req.getSource(), req.getTarget()));
		}
		if (intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_LaneChanging_EnvironmentCondition_4032 == req
				.getElementType()) {
			return null;
		}
		if (intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_TrafficSituation_EnvironmentCondition_4041 == req
				.getElementType()) {
			return getGEFWrapper(
					new intelligentMobility.diagram.edit.commands.Link_TrafficSituation_EnvironmentConditionCreateCommand(
							req, req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_DriverPreference_EnvironmentCondition_4009 == req
				.getElementType()) {
			return getGEFWrapper(
					new intelligentMobility.diagram.edit.commands.Link_DriverPreference_EnvironmentConditionCreateCommand(
							req, req.getSource(), req.getTarget()));
		}
		if (intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_EnvironmentCondition_LaneType_4012 == req
				.getElementType()) {
			return getGEFWrapper(
					new intelligentMobility.diagram.edit.commands.Link_EnvironmentCondition_LaneTypeCreateCommand(req,
							req.getSource(), req.getTarget()));
		}
		if (intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_EnvironmentCondition_TrafficCondition_4017 == req
				.getElementType()) {
			return getGEFWrapper(
					new intelligentMobility.diagram.edit.commands.Link_EnvironmentCondition_TrafficConditionCreateCommand(
							req, req.getSource(), req.getTarget()));
		}
		if (intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_EnvironmentBackground_EnvironmentCondition_4025 == req
				.getElementType()) {
			return getGEFWrapper(
					new intelligentMobility.diagram.edit.commands.Link_EnvironmentBackground_EnvironmentConditionCreateCommand(
							req, req.getSource(), req.getTarget()));
		}
		if (intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_EnvironmentCondition_Weather_4026 == req
				.getElementType()) {
			return null;
		}
		if (intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_EnvironmentCondition_SpecialCondition_4027 == req
				.getElementType()) {
			return null;
		}
		if (intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_EnvironmentCondition_Regulations_4030 == req
				.getElementType()) {
			return null;
		}
		if (intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_LaneChanging_EnvironmentCondition_4032 == req
				.getElementType()) {
			return getGEFWrapper(
					new intelligentMobility.diagram.edit.commands.Link_LaneChanging_EnvironmentConditionCreateCommand(
							req, req.getSource(), req.getTarget()));
		}
		if (intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_TrafficSituation_EnvironmentCondition_4041 == req
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
		case intelligentMobility.diagram.edit.parts.Link_DriverPreference_EnvironmentConditionEditPart.VISUAL_ID:
			return getGEFWrapper(
					new intelligentMobility.diagram.edit.commands.Link_DriverPreference_EnvironmentConditionReorientCommand(
							req));
		case intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_LaneTypeEditPart.VISUAL_ID:
			return getGEFWrapper(
					new intelligentMobility.diagram.edit.commands.Link_EnvironmentCondition_LaneTypeReorientCommand(
							req));
		case intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_TrafficConditionEditPart.VISUAL_ID:
			return getGEFWrapper(
					new intelligentMobility.diagram.edit.commands.Link_EnvironmentCondition_TrafficConditionReorientCommand(
							req));
		case intelligentMobility.diagram.edit.parts.Link_EnvironmentBackground_EnvironmentConditionEditPart.VISUAL_ID:
			return getGEFWrapper(
					new intelligentMobility.diagram.edit.commands.Link_EnvironmentBackground_EnvironmentConditionReorientCommand(
							req));
		case intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_WeatherEditPart.VISUAL_ID:
			return getGEFWrapper(
					new intelligentMobility.diagram.edit.commands.Link_EnvironmentCondition_WeatherReorientCommand(
							req));
		case intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_SpecialConditionEditPart.VISUAL_ID:
			return getGEFWrapper(
					new intelligentMobility.diagram.edit.commands.Link_EnvironmentCondition_SpecialConditionReorientCommand(
							req));
		case intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_RegulationsEditPart.VISUAL_ID:
			return getGEFWrapper(
					new intelligentMobility.diagram.edit.commands.Link_EnvironmentCondition_RegulationsReorientCommand(
							req));
		case intelligentMobility.diagram.edit.parts.Link_LaneChanging_EnvironmentConditionEditPart.VISUAL_ID:
			return getGEFWrapper(
					new intelligentMobility.diagram.edit.commands.Link_LaneChanging_EnvironmentConditionReorientCommand(
							req));
		case intelligentMobility.diagram.edit.parts.Link_TrafficSituation_EnvironmentConditionEditPart.VISUAL_ID:
			return getGEFWrapper(
					new intelligentMobility.diagram.edit.commands.Link_TrafficSituation_EnvironmentConditionReorientCommand(
							req));
		}
		return super.getReorientRelationshipCommand(req);
	}

}
