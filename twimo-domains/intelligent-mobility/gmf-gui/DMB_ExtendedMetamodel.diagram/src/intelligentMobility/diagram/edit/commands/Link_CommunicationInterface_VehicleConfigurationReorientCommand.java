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
public class Link_CommunicationInterface_VehicleConfigurationReorientCommand extends EditElementCommand {

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
	public Link_CommunicationInterface_VehicleConfigurationReorientCommand(ReorientRelationshipRequest request) {
		super(request.getLabel(), request.getRelationship(), request);
		reorientDirection = request.getDirection();
		oldEnd = request.getOldRelationshipEnd();
		newEnd = request.getNewRelationshipEnd();
	}

	/**
	* @generated
	*/
	public boolean canExecute() {
		if (false == getElementToEdit() instanceof intelligentMobility.Link_CommunicationInterface_VehicleConfiguration) {
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
		if (!(oldEnd instanceof intelligentMobility.CommunicationInterface
				&& newEnd instanceof intelligentMobility.CommunicationInterface)) {
			return false;
		}
		intelligentMobility.Vehicle_Configuration target = getLink().getLink_vehicle_configuration();
		if (!(getLink().eContainer() instanceof intelligentMobility.MobilitySystem)) {
			return false;
		}
		intelligentMobility.MobilitySystem container = (intelligentMobility.MobilitySystem) getLink().eContainer();
		return intelligentMobility.diagram.edit.policies.DrivingBehaviourMetamodelBaseItemSemanticEditPolicy
				.getLinkConstraints().canExistLink_CommunicationInterface_VehicleConfiguration_4036(container,
						getLink(), getNewSource(), target);
	}

	/**
	* @generated
	*/
	protected boolean canReorientTarget() {
		if (!(oldEnd instanceof intelligentMobility.Vehicle_Configuration
				&& newEnd instanceof intelligentMobility.Vehicle_Configuration)) {
			return false;
		}
		intelligentMobility.CommunicationInterface source = getLink().getLink_communication_interface();
		if (!(getLink().eContainer() instanceof intelligentMobility.MobilitySystem)) {
			return false;
		}
		intelligentMobility.MobilitySystem container = (intelligentMobility.MobilitySystem) getLink().eContainer();
		return intelligentMobility.diagram.edit.policies.DrivingBehaviourMetamodelBaseItemSemanticEditPolicy
				.getLinkConstraints().canExistLink_CommunicationInterface_VehicleConfiguration_4036(container,
						getLink(), source, getNewTarget());
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
		getLink().setLink_communication_interface(getNewSource());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	* @generated
	*/
	protected CommandResult reorientTarget() throws ExecutionException {
		getLink().setLink_vehicle_configuration(getNewTarget());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	* @generated
	*/
	protected intelligentMobility.Link_CommunicationInterface_VehicleConfiguration getLink() {
		return (intelligentMobility.Link_CommunicationInterface_VehicleConfiguration) getElementToEdit();
	}

	/**
	* @generated
	*/
	protected intelligentMobility.CommunicationInterface getOldSource() {
		return (intelligentMobility.CommunicationInterface) oldEnd;
	}

	/**
	* @generated
	*/
	protected intelligentMobility.CommunicationInterface getNewSource() {
		return (intelligentMobility.CommunicationInterface) newEnd;
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
