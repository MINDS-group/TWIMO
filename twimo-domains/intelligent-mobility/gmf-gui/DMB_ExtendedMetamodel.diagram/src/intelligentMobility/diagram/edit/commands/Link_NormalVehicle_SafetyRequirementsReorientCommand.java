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
public class Link_NormalVehicle_SafetyRequirementsReorientCommand extends EditElementCommand {

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
	public Link_NormalVehicle_SafetyRequirementsReorientCommand(ReorientRelationshipRequest request) {
		super(request.getLabel(), request.getRelationship(), request);
		reorientDirection = request.getDirection();
		oldEnd = request.getOldRelationshipEnd();
		newEnd = request.getNewRelationshipEnd();
	}

	/**
	* @generated
	*/
	public boolean canExecute() {
		if (false == getElementToEdit() instanceof intelligentMobility.Link_NormalVehicle_SafetyRequirements) {
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
		if (!(oldEnd instanceof intelligentMobility.Normal_Vehicle
				&& newEnd instanceof intelligentMobility.Normal_Vehicle)) {
			return false;
		}
		intelligentMobility.Safety_Requirement target = getLink().getLink_safetyRequirement();
		if (!(getLink().eContainer() instanceof intelligentMobility.MobilitySystem)) {
			return false;
		}
		intelligentMobility.MobilitySystem container = (intelligentMobility.MobilitySystem) getLink().eContainer();
		return intelligentMobility.diagram.edit.policies.DrivingBehaviourMetamodelBaseItemSemanticEditPolicy
				.getLinkConstraints()
				.canExistLink_NormalVehicle_SafetyRequirements_4005(container, getLink(), getNewSource(), target);
	}

	/**
	* @generated
	*/
	protected boolean canReorientTarget() {
		if (!(oldEnd instanceof intelligentMobility.Safety_Requirement
				&& newEnd instanceof intelligentMobility.Safety_Requirement)) {
			return false;
		}
		intelligentMobility.Normal_Vehicle source = getLink().getLink_normalVehicle();
		if (!(getLink().eContainer() instanceof intelligentMobility.MobilitySystem)) {
			return false;
		}
		intelligentMobility.MobilitySystem container = (intelligentMobility.MobilitySystem) getLink().eContainer();
		return intelligentMobility.diagram.edit.policies.DrivingBehaviourMetamodelBaseItemSemanticEditPolicy
				.getLinkConstraints()
				.canExistLink_NormalVehicle_SafetyRequirements_4005(container, getLink(), source, getNewTarget());
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
		getLink().setLink_normalVehicle(getNewSource());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	* @generated
	*/
	protected CommandResult reorientTarget() throws ExecutionException {
		getLink().setLink_safetyRequirement(getNewTarget());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	* @generated
	*/
	protected intelligentMobility.Link_NormalVehicle_SafetyRequirements getLink() {
		return (intelligentMobility.Link_NormalVehicle_SafetyRequirements) getElementToEdit();
	}

	/**
	* @generated
	*/
	protected intelligentMobility.Normal_Vehicle getOldSource() {
		return (intelligentMobility.Normal_Vehicle) oldEnd;
	}

	/**
	* @generated
	*/
	protected intelligentMobility.Normal_Vehicle getNewSource() {
		return (intelligentMobility.Normal_Vehicle) newEnd;
	}

	/**
	* @generated
	*/
	protected intelligentMobility.Safety_Requirement getOldTarget() {
		return (intelligentMobility.Safety_Requirement) oldEnd;
	}

	/**
	* @generated
	*/
	protected intelligentMobility.Safety_Requirement getNewTarget() {
		return (intelligentMobility.Safety_Requirement) newEnd;
	}
}
