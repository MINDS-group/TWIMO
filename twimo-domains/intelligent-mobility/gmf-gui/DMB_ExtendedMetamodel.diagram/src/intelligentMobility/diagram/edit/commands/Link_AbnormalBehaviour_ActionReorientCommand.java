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
public class Link_AbnormalBehaviour_ActionReorientCommand extends EditElementCommand {

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
	public Link_AbnormalBehaviour_ActionReorientCommand(ReorientRelationshipRequest request) {
		super(request.getLabel(), request.getRelationship(), request);
		reorientDirection = request.getDirection();
		oldEnd = request.getOldRelationshipEnd();
		newEnd = request.getNewRelationshipEnd();
	}

	/**
	* @generated
	*/
	public boolean canExecute() {
		if (false == getElementToEdit() instanceof intelligentMobility.Link_AbnormalBehaviour_Action) {
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
		if (!(oldEnd instanceof intelligentMobility.Action && newEnd instanceof intelligentMobility.Action)) {
			return false;
		}
		intelligentMobility.Abnormal_Behaviour target = getLink().getLink_abnormalBehaviour();
		if (!(getLink().eContainer() instanceof intelligentMobility.MobilitySystem)) {
			return false;
		}
		intelligentMobility.MobilitySystem container = (intelligentMobility.MobilitySystem) getLink().eContainer();
		return intelligentMobility.diagram.edit.policies.DrivingBehaviourMetamodelBaseItemSemanticEditPolicy
				.getLinkConstraints()
				.canExistLink_AbnormalBehaviour_Action_4010(container, getLink(), getNewSource(), target);
	}

	/**
	* @generated
	*/
	protected boolean canReorientTarget() {
		if (!(oldEnd instanceof intelligentMobility.Abnormal_Behaviour
				&& newEnd instanceof intelligentMobility.Abnormal_Behaviour)) {
			return false;
		}
		intelligentMobility.Action source = getLink().getLink_action();
		if (!(getLink().eContainer() instanceof intelligentMobility.MobilitySystem)) {
			return false;
		}
		intelligentMobility.MobilitySystem container = (intelligentMobility.MobilitySystem) getLink().eContainer();
		return intelligentMobility.diagram.edit.policies.DrivingBehaviourMetamodelBaseItemSemanticEditPolicy
				.getLinkConstraints()
				.canExistLink_AbnormalBehaviour_Action_4010(container, getLink(), source, getNewTarget());
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
		getLink().setLink_action(getNewSource());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	* @generated
	*/
	protected CommandResult reorientTarget() throws ExecutionException {
		getLink().setLink_abnormalBehaviour(getNewTarget());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	* @generated
	*/
	protected intelligentMobility.Link_AbnormalBehaviour_Action getLink() {
		return (intelligentMobility.Link_AbnormalBehaviour_Action) getElementToEdit();
	}

	/**
	* @generated
	*/
	protected intelligentMobility.Action getOldSource() {
		return (intelligentMobility.Action) oldEnd;
	}

	/**
	* @generated
	*/
	protected intelligentMobility.Action getNewSource() {
		return (intelligentMobility.Action) newEnd;
	}

	/**
	* @generated
	*/
	protected intelligentMobility.Abnormal_Behaviour getOldTarget() {
		return (intelligentMobility.Abnormal_Behaviour) oldEnd;
	}

	/**
	* @generated
	*/
	protected intelligentMobility.Abnormal_Behaviour getNewTarget() {
		return (intelligentMobility.Abnormal_Behaviour) newEnd;
	}
}
