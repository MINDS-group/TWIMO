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
public class Link_Platoon_FollowingVehicleReorientCommand extends EditElementCommand {

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
	public Link_Platoon_FollowingVehicleReorientCommand(ReorientRelationshipRequest request) {
		super(request.getLabel(), request.getRelationship(), request);
		reorientDirection = request.getDirection();
		oldEnd = request.getOldRelationshipEnd();
		newEnd = request.getNewRelationshipEnd();
	}

	/**
	* @generated
	*/
	public boolean canExecute() {
		if (false == getElementToEdit() instanceof intelligentMobility.Link_Platoon_FollowingVehicle) {
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
		if (!(oldEnd instanceof intelligentMobility.Platoon && newEnd instanceof intelligentMobility.Platoon)) {
			return false;
		}
		intelligentMobility.Following_Vehicle target = getLink().getLink_followingVehicle();
		if (!(getLink().eContainer() instanceof intelligentMobility.MobilitySystem)) {
			return false;
		}
		intelligentMobility.MobilitySystem container = (intelligentMobility.MobilitySystem) getLink().eContainer();
		return intelligentMobility.diagram.edit.policies.DrivingBehaviourMetamodelBaseItemSemanticEditPolicy
				.getLinkConstraints()
				.canExistLink_Platoon_FollowingVehicle_4008(container, getLink(), getNewSource(), target);
	}

	/**
	* @generated
	*/
	protected boolean canReorientTarget() {
		if (!(oldEnd instanceof intelligentMobility.Following_Vehicle
				&& newEnd instanceof intelligentMobility.Following_Vehicle)) {
			return false;
		}
		intelligentMobility.Platoon source = getLink().getLink_platoon();
		if (!(getLink().eContainer() instanceof intelligentMobility.MobilitySystem)) {
			return false;
		}
		intelligentMobility.MobilitySystem container = (intelligentMobility.MobilitySystem) getLink().eContainer();
		return intelligentMobility.diagram.edit.policies.DrivingBehaviourMetamodelBaseItemSemanticEditPolicy
				.getLinkConstraints()
				.canExistLink_Platoon_FollowingVehicle_4008(container, getLink(), source, getNewTarget());
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
		getLink().setLink_platoon(getNewSource());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	* @generated
	*/
	protected CommandResult reorientTarget() throws ExecutionException {
		getLink().setLink_followingVehicle(getNewTarget());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	* @generated
	*/
	protected intelligentMobility.Link_Platoon_FollowingVehicle getLink() {
		return (intelligentMobility.Link_Platoon_FollowingVehicle) getElementToEdit();
	}

	/**
	* @generated
	*/
	protected intelligentMobility.Platoon getOldSource() {
		return (intelligentMobility.Platoon) oldEnd;
	}

	/**
	* @generated
	*/
	protected intelligentMobility.Platoon getNewSource() {
		return (intelligentMobility.Platoon) newEnd;
	}

	/**
	* @generated
	*/
	protected intelligentMobility.Following_Vehicle getOldTarget() {
		return (intelligentMobility.Following_Vehicle) oldEnd;
	}

	/**
	* @generated
	*/
	protected intelligentMobility.Following_Vehicle getNewTarget() {
		return (intelligentMobility.Following_Vehicle) newEnd;
	}
}
