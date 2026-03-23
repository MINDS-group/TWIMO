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
public class DrivingBehaviourMetamodelModelingAssistantProviderOfForwardEditPart
		extends intelligentMobility.diagram.providers.DrivingBehaviourMetamodelModelingAssistantProvider {

	/**
	* @generated
	*/

	public List<IElementType> getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSource((intelligentMobility.diagram.edit.parts.ForwardEditPart) sourceEditPart);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetRelTypesOnSource(intelligentMobility.diagram.edit.parts.ForwardEditPart source) {
		List<IElementType> types = new ArrayList<IElementType>(4);
		types.add(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_AbnormalBehaviour_Action_4010);
		types.add(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Action_Backward_4044);
		types.add(intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Action_Forward_4045);
		types.add(intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Action_Turn_4046);
		return types;
	}

	/**
	* @generated
	*/

	public List<IElementType> getRelTypesOnSourceAndTarget(IAdaptable source, IAdaptable target) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSourceAndTarget((intelligentMobility.diagram.edit.parts.ForwardEditPart) sourceEditPart,
				targetEditPart);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetRelTypesOnSourceAndTarget(
			intelligentMobility.diagram.edit.parts.ForwardEditPart source, IGraphicalEditPart targetEditPart) {
		List<IElementType> types = new LinkedList<IElementType>();
		if (targetEditPart instanceof intelligentMobility.diagram.edit.parts.Abnormal_BehaviourEditPart) {
			types.add(
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_AbnormalBehaviour_Action_4010);
		}
		if (targetEditPart instanceof intelligentMobility.diagram.edit.parts.BackwardEditPart) {
			types.add(
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Action_Backward_4044);
		}
		if (targetEditPart instanceof intelligentMobility.diagram.edit.parts.Backward2EditPart) {
			types.add(
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Action_Backward_4044);
		}
		if (targetEditPart instanceof intelligentMobility.diagram.edit.parts.ForwardEditPart) {
			types.add(
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Action_Forward_4045);
		}
		if (targetEditPart instanceof intelligentMobility.diagram.edit.parts.TurnEditPart) {
			types.add(
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Action_Turn_4046);
		}
		return types;
	}

	/**
	* @generated
	*/

	public List<IElementType> getTypesForTarget(IAdaptable source, IElementType relationshipType) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		return doGetTypesForTarget((intelligentMobility.diagram.edit.parts.ForwardEditPart) sourceEditPart,
				relationshipType);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetTypesForTarget(intelligentMobility.diagram.edit.parts.ForwardEditPart source,
			IElementType relationshipType) {
		List<IElementType> types = new ArrayList<IElementType>();
		if (relationshipType == intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_AbnormalBehaviour_Action_4010) {
			types.add(
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Abnormal_Behaviour_2029);
		} else if (relationshipType == intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Action_Backward_4044) {
			types.add(intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Backward_2022);
			types.add(intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Backward_2030);
		} else if (relationshipType == intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Action_Forward_4045) {
			types.add(intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Forward_2011);
		} else if (relationshipType == intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Action_Turn_4046) {
			types.add(intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Turn_2014);
		}
		return types;
	}

	/**
	* @generated
	*/

	public List<IElementType> getRelTypesOnTarget(IAdaptable target) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnTarget((intelligentMobility.diagram.edit.parts.ForwardEditPart) targetEditPart);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetRelTypesOnTarget(intelligentMobility.diagram.edit.parts.ForwardEditPart target) {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Following_Forward_4011);
		types.add(intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Action_Forward_4045);
		return types;
	}

	/**
	* @generated
	*/

	public List<IElementType> getTypesForSource(IAdaptable target, IElementType relationshipType) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetTypesForSource((intelligentMobility.diagram.edit.parts.ForwardEditPart) targetEditPart,
				relationshipType);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetTypesForSource(intelligentMobility.diagram.edit.parts.ForwardEditPart target,
			IElementType relationshipType) {
		List<IElementType> types = new ArrayList<IElementType>();
		if (relationshipType == intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Following_Forward_4011) {
			types.add(intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Following_2019);
		} else if (relationshipType == intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Action_Forward_4045) {
			types.add(intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Forward_2011);
			types.add(intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Turn_2014);
			types.add(intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Backward_2022);
			types.add(intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Backward_2030);
			types.add(intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Action_2039);
		}
		return types;
	}

}
