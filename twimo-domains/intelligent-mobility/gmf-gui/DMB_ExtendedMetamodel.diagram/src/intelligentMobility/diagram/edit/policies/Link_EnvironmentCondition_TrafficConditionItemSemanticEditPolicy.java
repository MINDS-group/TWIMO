package intelligentMobility.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;

/**
 * @generated
 */
public class Link_EnvironmentCondition_TrafficConditionItemSemanticEditPolicy
		extends intelligentMobility.diagram.edit.policies.DrivingBehaviourMetamodelBaseItemSemanticEditPolicy {

	/**
	* @generated
	*/
	public Link_EnvironmentCondition_TrafficConditionItemSemanticEditPolicy() {
		super(intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_EnvironmentCondition_TrafficCondition_4017);
	}

	/**
	* @generated
	*/
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		return getGEFWrapper(new DestroyElementCommand(req));
	}

}
