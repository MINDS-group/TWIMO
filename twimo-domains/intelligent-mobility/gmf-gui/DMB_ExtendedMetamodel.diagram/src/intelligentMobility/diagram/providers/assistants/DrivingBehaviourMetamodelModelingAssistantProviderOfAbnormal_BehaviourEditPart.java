package intelligentMobility.diagram.providers.assistants;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

/**
 * @generated
 */
public class DrivingBehaviourMetamodelModelingAssistantProviderOfAbnormal_BehaviourEditPart
		extends intelligentMobility.diagram.providers.DrivingBehaviourMetamodelModelingAssistantProvider {

	/**
	* @generated
	*/

	public List<IElementType> getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSource(
				(intelligentMobility.diagram.edit.parts.Abnormal_BehaviourEditPart) sourceEditPart);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetRelTypesOnSource(
			intelligentMobility.diagram.edit.parts.Abnormal_BehaviourEditPart source) {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_NormalBehaviour_LaneChanging_4020);
		types.add(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_NormalBehaviour_Following_4034);
		return types;
	}

	/**
	* @generated
	*/

	public List<IElementType> getRelTypesOnSourceAndTarget(IAdaptable source, IAdaptable target) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSourceAndTarget(
				(intelligentMobility.diagram.edit.parts.Abnormal_BehaviourEditPart) sourceEditPart, targetEditPart);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetRelTypesOnSourceAndTarget(
			intelligentMobility.diagram.edit.parts.Abnormal_BehaviourEditPart source,
			IGraphicalEditPart targetEditPart) {
		List<IElementType> types = new LinkedList<IElementType>();
		if (targetEditPart instanceof intelligentMobility.diagram.edit.parts.LaneChangingEditPart) {
			types.add(
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_NormalBehaviour_LaneChanging_4020);
		}
		if (targetEditPart instanceof intelligentMobility.diagram.edit.parts.FollowingEditPart) {
			types.add(
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_NormalBehaviour_Following_4034);
		}
		return types;
	}

	/**
	* @generated
	*/

	public List<IElementType> getTypesForTarget(IAdaptable source, IElementType relationshipType) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		return doGetTypesForTarget((intelligentMobility.diagram.edit.parts.Abnormal_BehaviourEditPart) sourceEditPart,
				relationshipType);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetTypesForTarget(
			intelligentMobility.diagram.edit.parts.Abnormal_BehaviourEditPart source, IElementType relationshipType) {
		List<IElementType> types = new ArrayList<IElementType>();
		if (relationshipType == intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_NormalBehaviour_LaneChanging_4020) {
			types.add(intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.LaneChanging_2015);
		} else if (relationshipType == intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_NormalBehaviour_Following_4034) {
			types.add(intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Following_2019);
		}
		return types;
	}

	/**
	* @generated
	*/

	public List<IElementType> getRelTypesOnTarget(IAdaptable target) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnTarget(
				(intelligentMobility.diagram.edit.parts.Abnormal_BehaviourEditPart) targetEditPart);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetRelTypesOnTarget(
			intelligentMobility.diagram.edit.parts.Abnormal_BehaviourEditPart target) {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_AbnormalBehaviour_Action_4010);
		types.add(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_DrivingBehaviour_NormalBehaviour_4031);
		return types;
	}

	/**
	* @generated
	*/

	public List<IElementType> getTypesForSource(IAdaptable target, IElementType relationshipType) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetTypesForSource((intelligentMobility.diagram.edit.parts.Abnormal_BehaviourEditPart) targetEditPart,
				relationshipType);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetTypesForSource(
			intelligentMobility.diagram.edit.parts.Abnormal_BehaviourEditPart target, IElementType relationshipType) {
		List<IElementType> types = new ArrayList<IElementType>();
		if (relationshipType == intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_AbnormalBehaviour_Action_4010) {
			types.add(intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Forward_2011);
			types.add(intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Turn_2014);
			types.add(intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Backward_2022);
			types.add(intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Backward_2030);
			types.add(intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Action_2039);
		} else if (relationshipType == intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_DrivingBehaviour_NormalBehaviour_4031) {
			types.add(
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Driving_Behaviour_2027);
			types.add(
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.CooperativeBehavior_2037);
		}
		return types;
	}

}
