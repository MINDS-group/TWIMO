package intelligentMobility.diagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;

/**
 * @generated
 */
public class Link_EnvironmentBackground_EnvironmentConditionReorientCommand extends EditElementCommand {

	/**
	* @generated
	*/
	private final int reorientDirection;

	/**
	* @generated
	*/
	private final EObject oldEnd;

	/**
	* @generated
	*/
	private final EObject newEnd;

	/**
	* @generated
	*/
	public Link_EnvironmentBackground_EnvironmentConditionReorientCommand(ReorientRelationshipRequest request) {
		super(request.getLabel(), request.getRelationship(), request);
		reorientDirection = request.getDirection();
		oldEnd = request.getOldRelationshipEnd();
		newEnd = request.getNewRelationshipEnd();
	}

	/**
	* @generated
	*/
	public boolean canExecute() {
		if (false == getElementToEdit() instanceof intelligentMobility.Link_EnvironmentBackground_EnvironmentCondition) {
			return false;
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) {
			return canReorientSource();
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_TARGET) {
			return canReorientTarget();
		}
		return false;
	}

	/**
	* @generated
	*/
	protected boolean canReorientSource() {
		if (!(oldEnd instanceof intelligentMobility.Environment_Background
				&& newEnd instanceof intelligentMobility.Environment_Background)) {
			return false;
		}
		intelligentMobility.Environment_Condition target = getLink().getLink_environment_condition();
		if (!(getLink().eContainer() instanceof intelligentMobility.MobilitySystem)) {
			return false;
		}
		intelligentMobility.MobilitySystem container = (intelligentMobility.MobilitySystem) getLink().eContainer();
		return intelligentMobility.diagram.edit.policies.DrivingBehaviourMetamodelBaseItemSemanticEditPolicy
				.getLinkConstraints().canExistLink_EnvironmentBackground_EnvironmentCondition_4025(container, getLink(),
						getNewSource(), target);
	}

	/**
	* @generated
	*/
	protected boolean canReorientTarget() {
		if (!(oldEnd instanceof intelligentMobility.Environment_Condition
				&& newEnd instanceof intelligentMobility.Environment_Condition)) {
			return false;
		}
		intelligentMobility.Environment_Background source = getLink().getLink_environment_background();
		if (!(getLink().eContainer() instanceof intelligentMobility.MobilitySystem)) {
			return false;
		}
		intelligentMobility.MobilitySystem container = (intelligentMobility.MobilitySystem) getLink().eContainer();
		return intelligentMobility.diagram.edit.policies.DrivingBehaviourMetamodelBaseItemSemanticEditPolicy
				.getLinkConstraints().canExistLink_EnvironmentBackground_EnvironmentCondition_4025(container, getLink(),
						source, getNewTarget());
	}

	/**
	* @generated
	*/
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		if (!canExecute()) {
			throw new ExecutionException("Invalid arguments in reorient link command"); //$NON-NLS-1$
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) {
			return reorientSource();
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_TARGET) {
			return reorientTarget();
		}
		throw new IllegalStateException();
	}

	/**
	* @generated
	*/
	protected CommandResult reorientSource() throws ExecutionException {
		getLink().setLink_environment_background(getNewSource());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	* @generated
	*/
	protected CommandResult reorientTarget() throws ExecutionException {
		getLink().setLink_environment_condition(getNewTarget());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	* @generated
	*/
	protected intelligentMobility.Link_EnvironmentBackground_EnvironmentCondition getLink() {
		return (intelligentMobility.Link_EnvironmentBackground_EnvironmentCondition) getElementToEdit();
	}

	/**
	* @generated
	*/
	protected intelligentMobility.Environment_Background getOldSource() {
		return (intelligentMobility.Environment_Background) oldEnd;
	}

	/**
	* @generated
	*/
	protected intelligentMobility.Environment_Background getNewSource() {
		return (intelligentMobility.Environment_Background) newEnd;
	}

	/**
	* @generated
	*/
	protected intelligentMobility.Environment_Condition getOldTarget() {
		return (intelligentMobility.Environment_Condition) oldEnd;
	}

	/**
	* @generated
	*/
	protected intelligentMobility.Environment_Condition getNewTarget() {
		return (intelligentMobility.Environment_Condition) newEnd;
	}
}
