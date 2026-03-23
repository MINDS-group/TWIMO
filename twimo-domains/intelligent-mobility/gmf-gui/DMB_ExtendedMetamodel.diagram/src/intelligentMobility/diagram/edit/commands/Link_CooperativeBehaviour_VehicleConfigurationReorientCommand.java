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
public class Link_CooperativeBehaviour_VehicleConfigurationReorientCommand extends EditElementCommand {

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
	public Link_CooperativeBehaviour_VehicleConfigurationReorientCommand(ReorientRelationshipRequest request) {
		super(request.getLabel(), request.getRelationship(), request);
		reorientDirection = request.getDirection();
		oldEnd = request.getOldRelationshipEnd();
		newEnd = request.getNewRelationshipEnd();
	}

	/**
	* @generated
	*/
	public boolean canExecute() {
		if (false == getElementToEdit() instanceof intelligentMobility.Link_CooperativeBehaviour_VehicleConfiguration) {
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
		if (!(oldEnd instanceof intelligentMobility.CooperativeBehavior
				&& newEnd instanceof intelligentMobility.CooperativeBehavior)) {
			return false;
		}
		intelligentMobility.Vehicle_Configuration target = getLink().getLink_vehicleConfiguration();
		if (!(getLink().eContainer() instanceof intelligentMobility.MobilitySystem)) {
			return false;
		}
		intelligentMobility.MobilitySystem container = (intelligentMobility.MobilitySystem) getLink().eContainer();
		return intelligentMobility.diagram.edit.policies.DrivingBehaviourMetamodelBaseItemSemanticEditPolicy
				.getLinkConstraints().canExistLink_CooperativeBehaviour_VehicleConfiguration_4040(container, getLink(),
						getNewSource(), target);
	}

	/**
	* @generated
	*/
	protected boolean canReorientTarget() {
		if (!(oldEnd instanceof intelligentMobility.Vehicle_Configuration
				&& newEnd instanceof intelligentMobility.Vehicle_Configuration)) {
			return false;
		}
		intelligentMobility.CooperativeBehavior source = getLink().getLink_cooperativeBehaviour();
		if (!(getLink().eContainer() instanceof intelligentMobility.MobilitySystem)) {
			return false;
		}
		intelligentMobility.MobilitySystem container = (intelligentMobility.MobilitySystem) getLink().eContainer();
		return intelligentMobility.diagram.edit.policies.DrivingBehaviourMetamodelBaseItemSemanticEditPolicy
				.getLinkConstraints().canExistLink_CooperativeBehaviour_VehicleConfiguration_4040(container, getLink(),
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
		getLink().setLink_cooperativeBehaviour(getNewSource());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	* @generated
	*/
	protected CommandResult reorientTarget() throws ExecutionException {
		getLink().setLink_vehicleConfiguration(getNewTarget());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	* @generated
	*/
	protected intelligentMobility.Link_CooperativeBehaviour_VehicleConfiguration getLink() {
		return (intelligentMobility.Link_CooperativeBehaviour_VehicleConfiguration) getElementToEdit();
	}

	/**
	* @generated
	*/
	protected intelligentMobility.CooperativeBehavior getOldSource() {
		return (intelligentMobility.CooperativeBehavior) oldEnd;
	}

	/**
	* @generated
	*/
	protected intelligentMobility.CooperativeBehavior getNewSource() {
		return (intelligentMobility.CooperativeBehavior) newEnd;
	}

	/**
	* @generated
	*/
	protected intelligentMobility.Vehicle_Configuration getOldTarget() {
		return (intelligentMobility.Vehicle_Configuration) oldEnd;
	}

	/**
	* @generated
	*/
	protected intelligentMobility.Vehicle_Configuration getNewTarget() {
		return (intelligentMobility.Vehicle_Configuration) newEnd;
	}
}
