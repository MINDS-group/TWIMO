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
public class DrivingBehaviourMetamodelModelingAssistantProviderOfFollowingEditPart
		extends intelligentMobility.diagram.providers.DrivingBehaviourMetamodelModelingAssistantProvider {

	/**
	* @generated
	*/

	public List<IElementType> getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSource((intelligentMobility.diagram.edit.parts.FollowingEditPart) sourceEditPart);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetRelTypesOnSource(intelligentMobility.diagram.edit.parts.FollowingEditPart source) {
		List<IElementType> types = new ArrayList<IElementType>(3);
		types.add(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Following_Forward_4011);
		types.add(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Following_MinGap_4019);
		types.add(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Following_LaneChanging_4043);
		return types;
	}

	/**
	* @generated
	*/

	public List<IElementType> getRelTypesOnSourceAndTarget(IAdaptable source, IAdaptable target) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSourceAndTarget((intelligentMobility.diagram.edit.parts.FollowingEditPart) sourceEditPart,
				targetEditPart);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetRelTypesOnSourceAndTarget(
			intelligentMobility.diagram.edit.parts.FollowingEditPart source, IGraphicalEditPart targetEditPart) {
		List<IElementType> types = new LinkedList<IElementType>();
		if (targetEditPart instanceof intelligentMobility.diagram.edit.parts.ForwardEditPart) {
			types.add(
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Following_Forward_4011);
		}
		if (targetEditPart instanceof intelligentMobility.diagram.edit.parts.LaneChangingEditPart) {
			types.add(
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Following_MinGap_4019);
		}
		if (targetEditPart instanceof intelligentMobility.diagram.edit.parts.LaneChangingEditPart) {
			types.add(
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Following_LaneChanging_4043);
		}
		return types;
	}

	/**
	* @generated
	*/

	public List<IElementType> getTypesForTarget(IAdaptable source, IElementType relationshipType) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		return doGetTypesForTarget((intelligentMobility.diagram.edit.parts.FollowingEditPart) sourceEditPart,
				relationshipType);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetTypesForTarget(intelligentMobility.diagram.edit.parts.FollowingEditPart source,
			IElementType relationshipType) {
		List<IElementType> types = new ArrayList<IElementType>();
		if (relationshipType == intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Following_Forward_4011) {
			types.add(intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Forward_2011);
		} else if (relationshipType == intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Following_MinGap_4019) {
			types.add(intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.LaneChanging_2015);
		} else if (relationshipType == intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Following_LaneChanging_4043) {
			types.add(intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.LaneChanging_2015);
		}
		return types;
	}

	/**
	* @generated
	*/

	public List<IElementType> getRelTypesOnTarget(IAdaptable target) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnTarget((intelligentMobility.diagram.edit.parts.FollowingEditPart) targetEditPart);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetRelTypesOnTarget(intelligentMobility.diagram.edit.parts.FollowingEditPart target) {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Following_Backward_4029);
		types.add(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_NormalBehaviour_Following_4034);
		return types;
	}

	/**
	* @generated
	*/

	public List<IElementType> getTypesForSource(IAdaptable target, IElementType relationshipType) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetTypesForSource((intelligentMobility.diagram.edit.parts.FollowingEditPart) targetEditPart,
				relationshipType);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetTypesForSource(intelligentMobility.diagram.edit.parts.FollowingEditPart target,
			IElementType relationshipType) {
		List<IElementType> types = new ArrayList<IElementType>();
		if (relationshipType == intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Following_Backward_4029) {
			types.add(intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Backward_2022);
			types.add(intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Backward_2030);
		} else if (relationshipType == intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_NormalBehaviour_Following_4034) {
			types.add(
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Abnormal_Behaviour_2029);
			types.add(
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Normal_Behaviour_2034);
		}
		return types;
	}

}
