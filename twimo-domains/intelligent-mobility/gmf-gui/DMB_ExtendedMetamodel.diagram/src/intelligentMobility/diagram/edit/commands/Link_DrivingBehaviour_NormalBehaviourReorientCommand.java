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
public class Link_DrivingBehaviour_NormalBehaviourReorientCommand extends EditElementCommand {

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
	public Link_DrivingBehaviour_NormalBehaviourReorientCommand(ReorientRelationshipRequest request) {
		super(request.getLabel(), request.getRelationship(), request);
		reorientDirection = request.getDirection();
		oldEnd = request.getOldRelationshipEnd();
		newEnd = request.getNewRelationshipEnd();
	}

	/**
	* @generated
	*/
	public boolean canExecute() {
		if (false == getElementToEdit() instanceof intelligentMobility.Link_DrivingBehaviour_NormalBehaviour) {
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
		if (!(oldEnd instanceof intelligentMobility.Driving_Behaviour
				&& newEnd instanceof intelligentMobility.Driving_Behaviour)) {
			return false;
		}
		intelligentMobility.Normal_Behaviour target = getLink().getLink_normal_behaviour();
		if (!(getLink().eContainer() instanceof intelligentMobility.MobilitySystem)) {
			return false;
		}
		intelligentMobility.MobilitySystem container = (intelligentMobility.MobilitySystem) getLink().eContainer();
		return intelligentMobility.diagram.edit.policies.DrivingBehaviourMetamodelBaseItemSemanticEditPolicy
				.getLinkConstraints()
				.canExistLink_DrivingBehaviour_NormalBehaviour_4031(container, getLink(), getNewSource(), target);
	}

	/**
	* @generated
	*/
	protected boolean canReorientTarget() {
		if (!(oldEnd instanceof intelligentMobility.Normal_Behaviour
				&& newEnd instanceof intelligentMobility.Normal_Behaviour)) {
			return false;
		}
		intelligentMobility.Driving_Behaviour source = getLink().getLink_driving_behaviour();
		if (!(getLink().eContainer() instanceof intelligentMobility.MobilitySystem)) {
			return false;
		}
		intelligentMobility.MobilitySystem container = (intelligentMobility.MobilitySystem) getLink().eContainer();
		return intelligentMobility.diagram.edit.policies.DrivingBehaviourMetamodelBaseItemSemanticEditPolicy
				.getLinkConstraints()
				.canExistLink_DrivingBehaviour_NormalBehaviour_4031(container, getLink(), source, getNewTarget());
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
		getLink().setLink_driving_behaviour(getNewSource());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	* @generated
	*/
	protected CommandResult reorientTarget() throws ExecutionException {
		getLink().setLink_normal_behaviour(getNewTarget());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	* @generated
	*/
	protected intelligentMobility.Link_DrivingBehaviour_NormalBehaviour getLink() {
		return (intelligentMobility.Link_DrivingBehaviour_NormalBehaviour) getElementToEdit();
	}

	/**
	* @generated
	*/
	protected intelligentMobility.Driving_Behaviour getOldSource() {
		return (intelligentMobility.Driving_Behaviour) oldEnd;
	}

	/**
	* @generated
	*/
	protected intelligentMobility.Driving_Behaviour getNewSource() {
		return (intelligentMobility.Driving_Behaviour) newEnd;
	}

	/**
	* @generated
	*/
	protected intelligentMobility.Normal_Behaviour getOldTarget() {
		return (intelligentMobility.Normal_Behaviour) oldEnd;
	}

	/**
	* @generated
	*/
	protected intelligentMobility.Normal_Behaviour getNewTarget() {
		return (intelligentMobility.Normal_Behaviour) newEnd;
	}
}
