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
public class DrivingBehaviourMetamodelModelingAssistantProviderOfDriving_BehaviourEditPart
		extends intelligentMobility.diagram.providers.DrivingBehaviourMetamodelModelingAssistantProvider {

	/**
	* @generated
	*/

	public List<IElementType> getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSource((intelligentMobility.diagram.edit.parts.Driving_BehaviourEditPart) sourceEditPart);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetRelTypesOnSource(
			intelligentMobility.diagram.edit.parts.Driving_BehaviourEditPart source) {
		List<IElementType> types = new ArrayList<IElementType>(3);
		types.add(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_DriverPreference_DrivingBehaviour_4022);
		types.add(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_DrivingBehaviour_NormalBehaviour_4031);
		types.add(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Goal_DrivingBehaviour_4037);
		return types;
	}

	/**
	* @generated
	*/

	public List<IElementType> getRelTypesOnSourceAndTarget(IAdaptable source, IAdaptable target) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSourceAndTarget(
				(intelligentMobility.diagram.edit.parts.Driving_BehaviourEditPart) sourceEditPart, targetEditPart);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetRelTypesOnSourceAndTarget(
			intelligentMobility.diagram.edit.parts.Driving_BehaviourEditPart source,
			IGraphicalEditPart targetEditPart) {
		List<IElementType> types = new LinkedList<IElementType>();
		if (targetEditPart instanceof intelligentMobility.diagram.edit.parts.Driver_PreferenceEditPart) {
			types.add(
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_DriverPreference_DrivingBehaviour_4022);
		}
		if (targetEditPart instanceof intelligentMobility.diagram.edit.parts.Abnormal_BehaviourEditPart) {
			types.add(
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_DrivingBehaviour_NormalBehaviour_4031);
		}
		if (targetEditPart instanceof intelligentMobility.diagram.edit.parts.Normal_BehaviourEditPart) {
			types.add(
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_DrivingBehaviour_NormalBehaviour_4031);
		}
		if (targetEditPart instanceof intelligentMobility.diagram.edit.parts.GoalEditPart) {
			types.add(
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Goal_DrivingBehaviour_4037);
		}
		return types;
	}

	/**
	* @generated
	*/

	public List<IElementType> getTypesForTarget(IAdaptable source, IElementType relationshipType) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		return doGetTypesForTarget((intelligentMobility.diagram.edit.parts.Driving_BehaviourEditPart) sourceEditPart,
				relationshipType);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetTypesForTarget(
			intelligentMobility.diagram.edit.parts.Driving_BehaviourEditPart source, IElementType relationshipType) {
		List<IElementType> types = new ArrayList<IElementType>();
		if (relationshipType == intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_DriverPreference_DrivingBehaviour_4022) {
			types.add(
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Driver_Preference_2006);
		} else if (relationshipType == intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_DrivingBehaviour_NormalBehaviour_4031) {
			types.add(
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Abnormal_Behaviour_2029);
			types.add(
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Normal_Behaviour_2034);
		} else if (relationshipType == intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Goal_DrivingBehaviour_4037) {
			types.add(intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Goal_2033);
		}
		return types;
	}

}
