package intelligentMobility.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;

/**
 * @generated
 */
public class Link_LaneChanging_GapAcceptanceItemSemanticEditPolicy
		extends intelligentMobility.diagram.edit.policies.DrivingBehaviourMetamodelBaseItemSemanticEditPolicy {

	/**
	* @generated
	*/
	public Link_LaneChanging_GapAcceptanceItemSemanticEditPolicy() {
		super(intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_LaneChanging_GapAcceptance_4033);
	}

	/**
	* @generated
	*/
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		return getGEFWrapper(new DestroyElementCommand(req));
	}

}
