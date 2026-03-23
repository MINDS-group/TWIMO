package intelligentMobility.diagram.edit.policies;

import java.util.Iterator;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.ICompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.CommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.SemanticEditPolicy;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.GetEditContextRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.MoveRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.edit.helpers.GeneratedEditHelperBase;

/**
 * @generated
 */
public class DrivingBehaviourMetamodelBaseItemSemanticEditPolicy extends SemanticEditPolicy {

	/**
	* Extended request data key to hold editpart visual id.
	* @generated
	*/
	public static final String VISUAL_ID_KEY = "visual_id"; //$NON-NLS-1$

	/**
	* @generated
	*/
	private final IElementType myElementType;

	/**
	* @generated
	*/
	protected DrivingBehaviourMetamodelBaseItemSemanticEditPolicy(IElementType elementType) {
		myElementType = elementType;
	}

	/**
	* Extended request data key to hold editpart visual id.
	* Add visual id of edited editpart to extended data of the request
	* so command switch can decide what kind of diagram element is being edited.
	* It is done in those cases when it's not possible to deduce diagram
	* element kind from domain element.
	* 
	* @generated
	*/
	public Command getCommand(Request request) {
		if (request instanceof ReconnectRequest) {
			Object view = ((ReconnectRequest) request).getConnectionEditPart().getModel();
			if (view instanceof View) {
				Integer id = new Integer(intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
						.getVisualID((View) view));
				request.getExtendedData().put(VISUAL_ID_KEY, id);
			}
		}
		return super.getCommand(request);
	}

	/**
	* Returns visual id from request parameters.
	* @generated
	*/
	protected int getVisualID(IEditCommandRequest request) {
		Object id = request.getParameter(VISUAL_ID_KEY);
		return id instanceof Integer ? ((Integer) id).intValue() : -1;
	}

	/**
	* @generated
	*/
	protected Command getSemanticCommand(IEditCommandRequest request) {
		IEditCommandRequest completedRequest = completeRequest(request);
		Command semanticCommand = getSemanticCommandSwitch(completedRequest);
		semanticCommand = getEditHelperCommand(completedRequest, semanticCommand);
		if (completedRequest instanceof DestroyRequest) {
			DestroyRequest destroyRequest = (DestroyRequest) completedRequest;
			return shouldProceed(destroyRequest) ? addDeleteViewCommand(semanticCommand, destroyRequest) : null;
		}
		return semanticCommand;
	}

	/**
	* @generated
	*/
	protected Command addDeleteViewCommand(Command mainCommand, DestroyRequest completedRequest) {
		Command deleteViewCommand = getGEFWrapper(new DeleteCommand(getEditingDomain(), (View) getHost().getModel()));
		return mainCommand == null ? deleteViewCommand : mainCommand.chain(deleteViewCommand);
	}

	/**
	* @generated
	*/
	private Command getEditHelperCommand(IEditCommandRequest request, Command editPolicyCommand) {
		if (editPolicyCommand != null) {
			ICommand command = editPolicyCommand instanceof ICommandProxy
					? ((ICommandProxy) editPolicyCommand).getICommand()
					: new CommandProxy(editPolicyCommand);
			request.setParameter(GeneratedEditHelperBase.EDIT_POLICY_COMMAND, command);
		}
		IElementType requestContextElementType = getContextElementType(request);
		request.setParameter(GeneratedEditHelperBase.CONTEXT_ELEMENT_TYPE, requestContextElementType);
		ICommand command = requestContextElementType.getEditCommand(request);
		request.setParameter(GeneratedEditHelperBase.EDIT_POLICY_COMMAND, null);
		request.setParameter(GeneratedEditHelperBase.CONTEXT_ELEMENT_TYPE, null);
		if (command != null) {
			if (!(command instanceof CompositeTransactionalCommand)) {
				command = new CompositeTransactionalCommand(getEditingDomain(), command.getLabel()).compose(command);
			}
			return new ICommandProxy(command);
		}
		return editPolicyCommand;
	}

	/**
	* @generated
	*/
	private IElementType getContextElementType(IEditCommandRequest request) {
		IElementType requestContextElementType = intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes
				.getElementType(getVisualID(request));
		return requestContextElementType != null ? requestContextElementType : myElementType;
	}

	/**
	* @generated
	*/
	protected Command getSemanticCommandSwitch(IEditCommandRequest req) {
		if (req instanceof CreateRelationshipRequest) {
			return getCreateRelationshipCommand((CreateRelationshipRequest) req);
		} else if (req instanceof CreateElementRequest) {
			return getCreateCommand((CreateElementRequest) req);
		} else if (req instanceof ConfigureRequest) {
			return getConfigureCommand((ConfigureRequest) req);
		} else if (req instanceof DestroyElementRequest) {
			return getDestroyElementCommand((DestroyElementRequest) req);
		} else if (req instanceof DestroyReferenceRequest) {
			return getDestroyReferenceCommand((DestroyReferenceRequest) req);
		} else if (req instanceof DuplicateElementsRequest) {
			return getDuplicateCommand((DuplicateElementsRequest) req);
		} else if (req instanceof GetEditContextRequest) {
			return getEditContextCommand((GetEditContextRequest) req);
		} else if (req instanceof MoveRequest) {
			return getMoveCommand((MoveRequest) req);
		} else if (req instanceof ReorientReferenceRelationshipRequest) {
			return getReorientReferenceRelationshipCommand((ReorientReferenceRelationshipRequest) req);
		} else if (req instanceof ReorientRelationshipRequest) {
			return getReorientRelationshipCommand((ReorientRelationshipRequest) req);
		} else if (req instanceof SetRequest) {
			return getSetCommand((SetRequest) req);
		}
		return null;
	}

	/**
	* @generated
	*/
	protected Command getConfigureCommand(ConfigureRequest req) {
		return null;
	}

	/**
	* @generated
	*/
	protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
		return null;
	}

	/**
	* @generated
	*/
	protected Command getCreateCommand(CreateElementRequest req) {
		return null;
	}

	/**
	* @generated
	*/
	protected Command getSetCommand(SetRequest req) {
		return null;
	}

	/**
	* @generated
	*/
	protected Command getEditContextCommand(GetEditContextRequest req) {
		return null;
	}

	/**
	* @generated
	*/
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		return null;
	}

	/**
	* @generated
	*/
	protected Command getDestroyReferenceCommand(DestroyReferenceRequest req) {
		return null;
	}

	/**
	* @generated
	*/
	protected Command getDuplicateCommand(DuplicateElementsRequest req) {
		return null;
	}

	/**
	* @generated
	*/
	protected Command getMoveCommand(MoveRequest req) {
		return null;
	}

	/**
	* @generated
	*/
	protected Command getReorientReferenceRelationshipCommand(ReorientReferenceRelationshipRequest req) {
		return UnexecutableCommand.INSTANCE;
	}

	/**
	* @generated
	*/
	protected Command getReorientRelationshipCommand(ReorientRelationshipRequest req) {
		return UnexecutableCommand.INSTANCE;
	}

	/**
	* @generated
	*/
	protected final Command getGEFWrapper(ICommand cmd) {
		return new ICommandProxy(cmd);
	}

	/**
	* Returns editing domain from the host edit part.
	* @generated
	*/
	protected TransactionalEditingDomain getEditingDomain() {
		return ((IGraphicalEditPart) getHost()).getEditingDomain();
	}

	/**
	* Clean all shortcuts to the host element from the same diagram
	* @generated
	*/
	protected void addDestroyShortcutsCommand(ICompositeCommand cmd, View view) {
		assert view.getEAnnotation("Shortcut") == null; //$NON-NLS-1$
		for (Iterator it = view.getDiagram().getChildren().iterator(); it.hasNext();) {
			View nextView = (View) it.next();
			if (nextView.getEAnnotation("Shortcut") == null || !nextView.isSetElement() //$NON-NLS-1$
					|| nextView.getElement() != view.getElement()) {
				continue;
			}
			cmd.add(new DeleteCommand(getEditingDomain(), nextView));
		}
	}

	/**
	* @generated
	*/
	public static LinkConstraints getLinkConstraints() {
		LinkConstraints cached = intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin
				.getInstance().getLinkConstraints();
		if (cached == null) {
			intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin.getInstance()
					.setLinkConstraints(cached = new LinkConstraints());
		}
		return cached;
	}

	/**
	 * @generated
	 */
	public static class LinkConstraints {

		/**
		* @generated
		*/
		LinkConstraints() {
			// use static method #getLinkConstraints() to access instance
		}

		/**
		 * @generated
		 */
		public boolean canCreateLink_LaneType_Regulation_4001(intelligentMobility.MobilitySystem container,
				intelligentMobility.Lane_Type source, intelligentMobility.Regulation target) {
			return canExistLink_LaneType_Regulation_4001(container, null, source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateLink_Driver_Vehicle_4002(intelligentMobility.MobilitySystem container,
				intelligentMobility.Driver_Profile source, intelligentMobility.Vehicle_Configuration target) {
			return canExistLink_Driver_Vehicle_4002(container, null, source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateLink_EnvironmentBackground_PossibleVehicle_4003(
				intelligentMobility.MobilitySystem container, intelligentMobility.PossibleVehicle source,
				intelligentMobility.Environment_Background target) {
			return canExistLink_EnvironmentBackground_PossibleVehicle_4003(container, null, source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateLink_Vehicle_Environment_4004(intelligentMobility.MobilitySystem container,
				intelligentMobility.Vehicle_Configuration source, intelligentMobility.Environment_Background target) {
			return canExistLink_Vehicle_Environment_4004(container, null, source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateLink_NormalVehicle_SafetyRequirements_4005(intelligentMobility.MobilitySystem container,
				intelligentMobility.Normal_Vehicle source, intelligentMobility.Safety_Requirement target) {
			return canExistLink_NormalVehicle_SafetyRequirements_4005(container, null, source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateLink_DriverProfile_DriverPreference_4006(intelligentMobility.MobilitySystem container,
				intelligentMobility.Driver_Profile source, intelligentMobility.Driver_Preference target) {
			return canExistLink_DriverProfile_DriverPreference_4006(container, null, source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateLink_Collision_Obstruction_4007(intelligentMobility.MobilitySystem container,
				intelligentMobility.Obstruction source, intelligentMobility.Collision target) {
			return canExistLink_Collision_Obstruction_4007(container, null, source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateLink_Platoon_FollowingVehicle_4008(intelligentMobility.MobilitySystem container,
				intelligentMobility.Platoon source, intelligentMobility.Following_Vehicle target) {
			return canExistLink_Platoon_FollowingVehicle_4008(container, null, source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateLink_DriverPreference_EnvironmentCondition_4009(
				intelligentMobility.MobilitySystem container, intelligentMobility.Driver_Preference source,
				intelligentMobility.Environment_Condition target) {
			return canExistLink_DriverPreference_EnvironmentCondition_4009(container, null, source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateLink_AbnormalBehaviour_Action_4010(intelligentMobility.MobilitySystem container,
				intelligentMobility.Action source, intelligentMobility.Abnormal_Behaviour target) {
			return canExistLink_AbnormalBehaviour_Action_4010(container, null, source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateLink_Following_Forward_4011(intelligentMobility.MobilitySystem container,
				intelligentMobility.Following source, intelligentMobility.Forward target) {
			return canExistLink_Following_Forward_4011(container, null, source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateLink_EnvironmentCondition_LaneType_4012(intelligentMobility.MobilitySystem container,
				intelligentMobility.Lane_Type source, intelligentMobility.Environment_Condition target) {
			return canExistLink_EnvironmentCondition_LaneType_4012(container, null, source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateLink_VehicleConfiguration_VehicleType_4013(intelligentMobility.MobilitySystem container,
				intelligentMobility.Vehicle_Type source, intelligentMobility.Vehicle_Configuration target) {
			return canExistLink_VehicleConfiguration_VehicleType_4013(container, null, source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateLink_Platoon_LeadingVehicle_4014(intelligentMobility.MobilitySystem container,
				intelligentMobility.Platoon source, intelligentMobility.Leading_Vehicle target) {
			return canExistLink_Platoon_LeadingVehicle_4014(container, null, source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateLink_Driver_Environment_4015(intelligentMobility.MobilitySystem container,
				intelligentMobility.Driver_Profile source, intelligentMobility.Environment_Background target) {
			return canExistLink_Driver_Environment_4015(container, null, source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateLink_LaneChanging_Turn_4016(intelligentMobility.MobilitySystem container,
				intelligentMobility.Turn source, intelligentMobility.LaneChanging target) {
			return canExistLink_LaneChanging_Turn_4016(container, null, source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateLink_EnvironmentCondition_TrafficCondition_4017(
				intelligentMobility.MobilitySystem container, intelligentMobility.Traffic_Situation source,
				intelligentMobility.Environment_Condition target) {
			return canExistLink_EnvironmentCondition_TrafficCondition_4017(container, null, source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateLink_Intersection_TrafficLight_4018(intelligentMobility.MobilitySystem container,
				intelligentMobility.Intersection source, intelligentMobility.Traffic_Light target) {
			return canExistLink_Intersection_TrafficLight_4018(container, null, source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateLink_Following_MinGap_4019(intelligentMobility.MobilitySystem container,
				intelligentMobility.Following source, intelligentMobility.LaneChanging target) {
			return canExistLink_Following_MinGap_4019(container, null, source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateLink_NormalBehaviour_LaneChanging_4020(intelligentMobility.MobilitySystem container,
				intelligentMobility.Normal_Behaviour source, intelligentMobility.LaneChanging target) {
			return canExistLink_NormalBehaviour_LaneChanging_4020(container, null, source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateLink_SafetyRequirement_Regulation_4021(intelligentMobility.MobilitySystem container,
				intelligentMobility.Safety_Requirement source, intelligentMobility.Regulation target) {
			return canExistLink_SafetyRequirement_Regulation_4021(container, null, source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateLink_DriverPreference_DrivingBehaviour_4022(
				intelligentMobility.MobilitySystem container, intelligentMobility.Driving_Behaviour source,
				intelligentMobility.Driver_Preference target) {
			return canExistLink_DriverPreference_DrivingBehaviour_4022(container, null, source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateLink_FollowingVehicle_FrontVehicle_4023(intelligentMobility.MobilitySystem container,
				intelligentMobility.PlatoonMember source, intelligentMobility.Following_Vehicle target) {
			return canExistLink_FollowingVehicle_FrontVehicle_4023(container, null, source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateLink_DriverPreference_DriverEmotion_4024(intelligentMobility.MobilitySystem container,
				intelligentMobility.Driver_Preference source, intelligentMobility.Driver_Emotion target) {
			return canExistLink_DriverPreference_DriverEmotion_4024(container, null, source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateLink_EnvironmentBackground_EnvironmentCondition_4025(
				intelligentMobility.MobilitySystem container, intelligentMobility.Environment_Background source,
				intelligentMobility.Environment_Condition target) {
			return canExistLink_EnvironmentBackground_EnvironmentCondition_4025(container, null, source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateLink_EnvironmentCondition_Weather_4026(intelligentMobility.MobilitySystem container,
				intelligentMobility.Environment_Condition source, intelligentMobility.Weather target) {
			return canExistLink_EnvironmentCondition_Weather_4026(container, null, source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateLink_EnvironmentCondition_SpecialCondition_4027(
				intelligentMobility.MobilitySystem container, intelligentMobility.Environment_Condition source,
				intelligentMobility.Special_Condition target) {
			return canExistLink_EnvironmentCondition_SpecialCondition_4027(container, null, source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateLink_SpecialCondition_Intersection_4028(intelligentMobility.MobilitySystem container,
				intelligentMobility.Intersection source, intelligentMobility.Special_Condition target) {
			return canExistLink_SpecialCondition_Intersection_4028(container, null, source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateLink_Following_Backward_4029(intelligentMobility.MobilitySystem container,
				intelligentMobility.Backward source, intelligentMobility.Following target) {
			return canExistLink_Following_Backward_4029(container, null, source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateLink_EnvironmentCondition_Regulations_4030(intelligentMobility.MobilitySystem container,
				intelligentMobility.Environment_Condition source, intelligentMobility.Regulation target) {
			return canExistLink_EnvironmentCondition_Regulations_4030(container, null, source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateLink_DrivingBehaviour_NormalBehaviour_4031(intelligentMobility.MobilitySystem container,
				intelligentMobility.Driving_Behaviour source, intelligentMobility.Normal_Behaviour target) {
			return canExistLink_DrivingBehaviour_NormalBehaviour_4031(container, null, source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateLink_LaneChanging_EnvironmentCondition_4032(
				intelligentMobility.MobilitySystem container, intelligentMobility.LaneChanging source,
				intelligentMobility.Environment_Condition target) {
			return canExistLink_LaneChanging_EnvironmentCondition_4032(container, null, source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateLink_LaneChanging_GapAcceptance_4033(intelligentMobility.MobilitySystem container,
				intelligentMobility.LaneChanging source, intelligentMobility.GapAcceptance target) {
			return canExistLink_LaneChanging_GapAcceptance_4033(container, null, source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateLink_NormalBehaviour_Following_4034(intelligentMobility.MobilitySystem container,
				intelligentMobility.Normal_Behaviour source, intelligentMobility.Following target) {
			return canExistLink_NormalBehaviour_Following_4034(container, null, source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateLink_Infrastructure_VehicleConfiguration_4035(
				intelligentMobility.MobilitySystem container, intelligentMobility.Vehicle_Configuration source,
				intelligentMobility.Infrastructure target) {
			return canExistLink_Infrastructure_VehicleConfiguration_4035(container, null, source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateLink_CommunicationInterface_VehicleConfiguration_4036(
				intelligentMobility.MobilitySystem container, intelligentMobility.CommunicationInterface source,
				intelligentMobility.Vehicle_Configuration target) {
			return canExistLink_CommunicationInterface_VehicleConfiguration_4036(container, null, source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateLink_Goal_DrivingBehaviour_4037(intelligentMobility.MobilitySystem container,
				intelligentMobility.Driving_Behaviour source, intelligentMobility.Goal target) {
			return canExistLink_Goal_DrivingBehaviour_4037(container, null, source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateLink_CooperativeBehaviour_CommunicationInterface_4038(
				intelligentMobility.MobilitySystem container, intelligentMobility.CooperativeBehavior source,
				intelligentMobility.CommunicationInterface target) {
			return canExistLink_CooperativeBehaviour_CommunicationInterface_4038(container, null, source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateLink_CommunicationInterface_Infrastructure_4039(
				intelligentMobility.MobilitySystem container, intelligentMobility.CommunicationInterface source,
				intelligentMobility.Infrastructure target) {
			return canExistLink_CommunicationInterface_Infrastructure_4039(container, null, source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateLink_CooperativeBehaviour_VehicleConfiguration_4040(
				intelligentMobility.MobilitySystem container, intelligentMobility.CooperativeBehavior source,
				intelligentMobility.Vehicle_Configuration target) {
			return canExistLink_CooperativeBehaviour_VehicleConfiguration_4040(container, null, source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateLink_TrafficSituation_EnvironmentCondition_4041(
				intelligentMobility.MobilitySystem container, intelligentMobility.Environment_Condition source,
				intelligentMobility.Traffic_Situation target) {
			return canExistLink_TrafficSituation_EnvironmentCondition_4041(container, null, source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateLink_Collision_SpecialCondition_4042(intelligentMobility.MobilitySystem container,
				intelligentMobility.Collision source, intelligentMobility.Special_Condition target) {
			return canExistLink_Collision_SpecialCondition_4042(container, null, source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateLink_Following_LaneChanging_4043(intelligentMobility.MobilitySystem container,
				intelligentMobility.Following source, intelligentMobility.LaneChanging target) {
			return canExistLink_Following_LaneChanging_4043(container, null, source, target);
		}

		/**
		* @generated
		*/
		public boolean canCreateLink_Action_Backward_4044(intelligentMobility.MobilitySystem container,
				intelligentMobility.Action source, intelligentMobility.Backward target) {
			return canExistLink_Action_Backward_4044(container, null, source, target);
		}

		/**
		* @generated
		*/
		public boolean canCreateLink_Action_Forward_4045(intelligentMobility.MobilitySystem container,
				intelligentMobility.Action source, intelligentMobility.Forward target) {
			return canExistLink_Action_Forward_4045(container, null, source, target);
		}

		/**
		* @generated
		*/
		public boolean canCreateLink_Action_Turn_4046(intelligentMobility.MobilitySystem container,
				intelligentMobility.Action source, intelligentMobility.Turn target) {
			return canExistLink_Action_Turn_4046(container, null, source, target);
		}

		/**
		* @generated
		*/
		public boolean canCreateLink_KnowledgeAndSkill_DriverPreference_4047(
				intelligentMobility.MobilitySystem container, intelligentMobility.Driver_Preference source,
				intelligentMobility.Knowledge_and_Skill target) {
			return canExistLink_KnowledgeAndSkill_DriverPreference_4047(container, null, source, target);
		}

		/**
				* @generated
				*/
		public boolean canExistLink_LaneType_Regulation_4001(intelligentMobility.MobilitySystem container,
				intelligentMobility.Link_LaneType_Regulation linkInstance, intelligentMobility.Lane_Type source,
				intelligentMobility.Regulation target) {
			return true;
		}

		/**
		* @generated
		*/
		public boolean canExistLink_Driver_Vehicle_4002(intelligentMobility.MobilitySystem container,
				intelligentMobility.Link_Driver_Vehicle linkInstance, intelligentMobility.Driver_Profile source,
				intelligentMobility.Vehicle_Configuration target) {
			return true;
		}

		/**
		* @generated
		*/
		public boolean canExistLink_EnvironmentBackground_PossibleVehicle_4003(
				intelligentMobility.MobilitySystem container,
				intelligentMobility.Link_EnvironmentBackground_PossibleVehicle linkInstance,
				intelligentMobility.PossibleVehicle source, intelligentMobility.Environment_Background target) {
			return true;
		}

		/**
		* @generated
		*/
		public boolean canExistLink_Vehicle_Environment_4004(intelligentMobility.MobilitySystem container,
				intelligentMobility.Link_Vehicle_Environment linkInstance,
				intelligentMobility.Vehicle_Configuration source, intelligentMobility.Environment_Background target) {
			return true;
		}

		/**
		* @generated
		*/
		public boolean canExistLink_NormalVehicle_SafetyRequirements_4005(intelligentMobility.MobilitySystem container,
				intelligentMobility.Link_NormalVehicle_SafetyRequirements linkInstance,
				intelligentMobility.Normal_Vehicle source, intelligentMobility.Safety_Requirement target) {
			return true;
		}

		/**
		* @generated
		*/
		public boolean canExistLink_DriverProfile_DriverPreference_4006(intelligentMobility.MobilitySystem container,
				intelligentMobility.Link_DriverProfile_DriverPreference linkInstance,
				intelligentMobility.Driver_Profile source, intelligentMobility.Driver_Preference target) {
			return true;
		}

		/**
		* @generated
		*/
		public boolean canExistLink_Collision_Obstruction_4007(intelligentMobility.MobilitySystem container,
				intelligentMobility.Link_Collision_Obstruction linkInstance, intelligentMobility.Obstruction source,
				intelligentMobility.Collision target) {
			return true;
		}

		/**
		* @generated
		*/
		public boolean canExistLink_Platoon_FollowingVehicle_4008(intelligentMobility.MobilitySystem container,
				intelligentMobility.Link_Platoon_FollowingVehicle linkInstance, intelligentMobility.Platoon source,
				intelligentMobility.Following_Vehicle target) {
			return true;
		}

		/**
		* @generated
		*/
		public boolean canExistLink_DriverPreference_EnvironmentCondition_4009(
				intelligentMobility.MobilitySystem container,
				intelligentMobility.Link_DriverPreference_EnvironmentCondition linkInstance,
				intelligentMobility.Driver_Preference source, intelligentMobility.Environment_Condition target) {
			return true;
		}

		/**
		* @generated
		*/
		public boolean canExistLink_AbnormalBehaviour_Action_4010(intelligentMobility.MobilitySystem container,
				intelligentMobility.Link_AbnormalBehaviour_Action linkInstance, intelligentMobility.Action source,
				intelligentMobility.Abnormal_Behaviour target) {
			return true;
		}

		/**
		* @generated
		*/
		public boolean canExistLink_Following_Forward_4011(intelligentMobility.MobilitySystem container,
				intelligentMobility.Link_Following_Forward linkInstance, intelligentMobility.Following source,
				intelligentMobility.Forward target) {
			return true;
		}

		/**
		* @generated
		*/
		public boolean canExistLink_EnvironmentCondition_LaneType_4012(intelligentMobility.MobilitySystem container,
				intelligentMobility.Link_EnvironmentCondition_LaneType linkInstance,
				intelligentMobility.Lane_Type source, intelligentMobility.Environment_Condition target) {
			return true;
		}

		/**
		* @generated
		*/
		public boolean canExistLink_VehicleConfiguration_VehicleType_4013(intelligentMobility.MobilitySystem container,
				intelligentMobility.Link_VehicleConfiguration_VehicleType linkInstance,
				intelligentMobility.Vehicle_Type source, intelligentMobility.Vehicle_Configuration target) {
			return true;
		}

		/**
		* @generated
		*/
		public boolean canExistLink_Platoon_LeadingVehicle_4014(intelligentMobility.MobilitySystem container,
				intelligentMobility.Link_Platoon_LeadingVehicle linkInstance, intelligentMobility.Platoon source,
				intelligentMobility.Leading_Vehicle target) {
			return true;
		}

		/**
		* @generated
		*/
		public boolean canExistLink_Driver_Environment_4015(intelligentMobility.MobilitySystem container,
				intelligentMobility.Link_Driver_Environment linkInstance, intelligentMobility.Driver_Profile source,
				intelligentMobility.Environment_Background target) {
			return true;
		}

		/**
		* @generated
		*/
		public boolean canExistLink_LaneChanging_Turn_4016(intelligentMobility.MobilitySystem container,
				intelligentMobility.Link_LaneChanging_Turn linkInstance, intelligentMobility.Turn source,
				intelligentMobility.LaneChanging target) {
			return true;
		}

		/**
		* @generated
		*/
		public boolean canExistLink_EnvironmentCondition_TrafficCondition_4017(
				intelligentMobility.MobilitySystem container,
				intelligentMobility.Link_EnvironmentCondition_TrafficCondition linkInstance,
				intelligentMobility.Traffic_Situation source, intelligentMobility.Environment_Condition target) {
			return true;
		}

		/**
		* @generated
		*/
		public boolean canExistLink_Intersection_TrafficLight_4018(intelligentMobility.MobilitySystem container,
				intelligentMobility.Link_Intersection_TrafficLight linkInstance,
				intelligentMobility.Intersection source, intelligentMobility.Traffic_Light target) {
			return true;
		}

		/**
		* @generated
		*/
		public boolean canExistLink_Following_MinGap_4019(intelligentMobility.MobilitySystem container,
				intelligentMobility.Link_Following_MinGap linkInstance, intelligentMobility.Following source,
				intelligentMobility.LaneChanging target) {
			return true;
		}

		/**
		* @generated
		*/
		public boolean canExistLink_NormalBehaviour_LaneChanging_4020(intelligentMobility.MobilitySystem container,
				intelligentMobility.Link_NormalBehaviour_LaneChanging linkInstance,
				intelligentMobility.Normal_Behaviour source, intelligentMobility.LaneChanging target) {
			return true;
		}

		/**
		* @generated
		*/
		public boolean canExistLink_SafetyRequirement_Regulation_4021(intelligentMobility.MobilitySystem container,
				intelligentMobility.Link_SafetyRequirement_Regulation linkInstance,
				intelligentMobility.Safety_Requirement source, intelligentMobility.Regulation target) {
			return true;
		}

		/**
		* @generated
		*/
		public boolean canExistLink_DriverPreference_DrivingBehaviour_4022(intelligentMobility.MobilitySystem container,
				intelligentMobility.Link_DriverPreference_DrivingBehaviour linkInstance,
				intelligentMobility.Driving_Behaviour source, intelligentMobility.Driver_Preference target) {
			return true;
		}

		/**
		* @generated
		*/
		public boolean canExistLink_FollowingVehicle_FrontVehicle_4023(intelligentMobility.MobilitySystem container,
				intelligentMobility.Link_FollowingVehicle_FrontVehicle linkInstance,
				intelligentMobility.PlatoonMember source, intelligentMobility.Following_Vehicle target) {
			return true;
		}

		/**
		* @generated
		*/
		public boolean canExistLink_DriverPreference_DriverEmotion_4024(intelligentMobility.MobilitySystem container,
				intelligentMobility.Link_DriverPreference_DriverEmotion linkInstance,
				intelligentMobility.Driver_Preference source, intelligentMobility.Driver_Emotion target) {
			return true;
		}

		/**
		* @generated
		*/
		public boolean canExistLink_EnvironmentBackground_EnvironmentCondition_4025(
				intelligentMobility.MobilitySystem container,
				intelligentMobility.Link_EnvironmentBackground_EnvironmentCondition linkInstance,
				intelligentMobility.Environment_Background source, intelligentMobility.Environment_Condition target) {
			return true;
		}

		/**
		* @generated
		*/
		public boolean canExistLink_EnvironmentCondition_Weather_4026(intelligentMobility.MobilitySystem container,
				intelligentMobility.Link_EnvironmentCondition_Weather linkInstance,
				intelligentMobility.Environment_Condition source, intelligentMobility.Weather target) {
			return true;
		}

		/**
		* @generated
		*/
		public boolean canExistLink_EnvironmentCondition_SpecialCondition_4027(
				intelligentMobility.MobilitySystem container,
				intelligentMobility.Link_EnvironmentCondition_SpecialCondition linkInstance,
				intelligentMobility.Environment_Condition source, intelligentMobility.Special_Condition target) {
			return true;
		}

		/**
		* @generated
		*/
		public boolean canExistLink_SpecialCondition_Intersection_4028(intelligentMobility.MobilitySystem container,
				intelligentMobility.Link_SpecialCondition_Intersection linkInstance,
				intelligentMobility.Intersection source, intelligentMobility.Special_Condition target) {
			return true;
		}

		/**
		* @generated
		*/
		public boolean canExistLink_Following_Backward_4029(intelligentMobility.MobilitySystem container,
				intelligentMobility.Link_Following_Backward linkInstance, intelligentMobility.Backward source,
				intelligentMobility.Following target) {
			return true;
		}

		/**
		* @generated
		*/
		public boolean canExistLink_EnvironmentCondition_Regulations_4030(intelligentMobility.MobilitySystem container,
				intelligentMobility.Link_EnvironmentCondition_Regulations linkInstance,
				intelligentMobility.Environment_Condition source, intelligentMobility.Regulation target) {
			return true;
		}

		/**
		* @generated
		*/
		public boolean canExistLink_DrivingBehaviour_NormalBehaviour_4031(intelligentMobility.MobilitySystem container,
				intelligentMobility.Link_DrivingBehaviour_NormalBehaviour linkInstance,
				intelligentMobility.Driving_Behaviour source, intelligentMobility.Normal_Behaviour target) {
			return true;
		}

		/**
		* @generated
		*/
		public boolean canExistLink_LaneChanging_EnvironmentCondition_4032(intelligentMobility.MobilitySystem container,
				intelligentMobility.Link_LaneChanging_EnvironmentCondition linkInstance,
				intelligentMobility.LaneChanging source, intelligentMobility.Environment_Condition target) {
			return true;
		}

		/**
		* @generated
		*/
		public boolean canExistLink_LaneChanging_GapAcceptance_4033(intelligentMobility.MobilitySystem container,
				intelligentMobility.Link_LaneChanging_GapAcceptance linkInstance,
				intelligentMobility.LaneChanging source, intelligentMobility.GapAcceptance target) {
			return true;
		}

		/**
		* @generated
		*/
		public boolean canExistLink_NormalBehaviour_Following_4034(intelligentMobility.MobilitySystem container,
				intelligentMobility.Link_NormalBehaviour_Following linkInstance,
				intelligentMobility.Normal_Behaviour source, intelligentMobility.Following target) {
			return true;
		}

		/**
		* @generated
		*/
		public boolean canExistLink_Infrastructure_VehicleConfiguration_4035(
				intelligentMobility.MobilitySystem container,
				intelligentMobility.Link_Infrastructure_VehicleConfiguration linkInstance,
				intelligentMobility.Vehicle_Configuration source, intelligentMobility.Infrastructure target) {
			return true;
		}

		/**
		* @generated
		*/
		public boolean canExistLink_CommunicationInterface_VehicleConfiguration_4036(
				intelligentMobility.MobilitySystem container,
				intelligentMobility.Link_CommunicationInterface_VehicleConfiguration linkInstance,
				intelligentMobility.CommunicationInterface source, intelligentMobility.Vehicle_Configuration target) {
			return true;
		}

		/**
		* @generated
		*/
		public boolean canExistLink_Goal_DrivingBehaviour_4037(intelligentMobility.MobilitySystem container,
				intelligentMobility.Link_Goal_DrivingBehaviour linkInstance,
				intelligentMobility.Driving_Behaviour source, intelligentMobility.Goal target) {
			return true;
		}

		/**
		* @generated
		*/
		public boolean canExistLink_CooperativeBehaviour_CommunicationInterface_4038(
				intelligentMobility.MobilitySystem container,
				intelligentMobility.Link_CooperativeBehaviour_CommunicationInterface linkInstance,
				intelligentMobility.CooperativeBehavior source, intelligentMobility.CommunicationInterface target) {
			return true;
		}

		/**
		* @generated
		*/
		public boolean canExistLink_CommunicationInterface_Infrastructure_4039(
				intelligentMobility.MobilitySystem container,
				intelligentMobility.Link_CommunicationInterface_Infrastructure linkInstance,
				intelligentMobility.CommunicationInterface source, intelligentMobility.Infrastructure target) {
			return true;
		}

		/**
		* @generated
		*/
		public boolean canExistLink_CooperativeBehaviour_VehicleConfiguration_4040(
				intelligentMobility.MobilitySystem container,
				intelligentMobility.Link_CooperativeBehaviour_VehicleConfiguration linkInstance,
				intelligentMobility.CooperativeBehavior source, intelligentMobility.Vehicle_Configuration target) {
			return true;
		}

		/**
		* @generated
		*/
		public boolean canExistLink_TrafficSituation_EnvironmentCondition_4041(
				intelligentMobility.MobilitySystem container,
				intelligentMobility.Link_TrafficSituation_EnvironmentCondition linkInstance,
				intelligentMobility.Environment_Condition source, intelligentMobility.Traffic_Situation target) {
			return true;
		}

		/**
		* @generated
		*/
		public boolean canExistLink_Collision_SpecialCondition_4042(intelligentMobility.MobilitySystem container,
				intelligentMobility.Link_Collision_SpecialCondition linkInstance, intelligentMobility.Collision source,
				intelligentMobility.Special_Condition target) {
			return true;
		}

		/**
		* @generated
		*/
		public boolean canExistLink_Following_LaneChanging_4043(intelligentMobility.MobilitySystem container,
				intelligentMobility.Link_Following_LaneChanging linkInstance, intelligentMobility.Following source,
				intelligentMobility.LaneChanging target) {
			return true;
		}

		/**
		* @generated
		*/
		public boolean canExistLink_Action_Backward_4044(intelligentMobility.MobilitySystem container,
				intelligentMobility.Link_Action_Backward linkInstance, intelligentMobility.Action source,
				intelligentMobility.Backward target) {
			return true;
		}

		/**
		* @generated
		*/
		public boolean canExistLink_Action_Forward_4045(intelligentMobility.MobilitySystem container,
				intelligentMobility.Link_Action_Forward linkInstance, intelligentMobility.Action source,
				intelligentMobility.Forward target) {
			return true;
		}

		/**
		* @generated
		*/
		public boolean canExistLink_Action_Turn_4046(intelligentMobility.MobilitySystem container,
				intelligentMobility.Link_Action_Turn linkInstance, intelligentMobility.Action source,
				intelligentMobility.Turn target) {
			return true;
		}

		/**
		* @generated
		*/
		public boolean canExistLink_KnowledgeAndSkill_DriverPreference_4047(
				intelligentMobility.MobilitySystem container,
				intelligentMobility.Link_KnowledgeAndSkill_DriverPreference linkInstance,
				intelligentMobility.Driver_Preference source, intelligentMobility.Knowledge_and_Skill target) {
			return true;
		}
	}

}
