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
public class DrivingBehaviourMetamodelModelingAssistantProviderOfPossibleVehicleEditPart
		extends intelligentMobility.diagram.providers.DrivingBehaviourMetamodelModelingAssistantProvider {

	/**
	* @generated
	*/

	public List<IElementType> getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSource((intelligentMobility.diagram.edit.parts.PossibleVehicleEditPart) sourceEditPart);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetRelTypesOnSource(
			intelligentMobility.diagram.edit.parts.PossibleVehicleEditPart source) {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_EnvironmentBackground_PossibleVehicle_4003);
		return types;
	}

	/**
	* @generated
	*/

	public List<IElementType> getRelTypesOnSourceAndTarget(IAdaptable source, IAdaptable target) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSourceAndTarget(
				(intelligentMobility.diagram.edit.parts.PossibleVehicleEditPart) sourceEditPart, targetEditPart);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetRelTypesOnSourceAndTarget(
			intelligentMobility.diagram.edit.parts.PossibleVehicleEditPart source, IGraphicalEditPart targetEditPart) {
		List<IElementType> types = new LinkedList<IElementType>();
		if (targetEditPart instanceof intelligentMobility.diagram.edit.parts.Environment_BackgroundEditPart) {
			types.add(
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_EnvironmentBackground_PossibleVehicle_4003);
		}
		return types;
	}

	/**
	* @generated
	*/

	public List<IElementType> getTypesForTarget(IAdaptable source, IElementType relationshipType) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		return doGetTypesForTarget((intelligentMobility.diagram.edit.parts.PossibleVehicleEditPart) sourceEditPart,
				relationshipType);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetTypesForTarget(intelligentMobility.diagram.edit.parts.PossibleVehicleEditPart source,
			IElementType relationshipType) {
		List<IElementType> types = new ArrayList<IElementType>();
		if (relationshipType == intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_EnvironmentBackground_PossibleVehicle_4003) {
			types.add(
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Environment_Background_2013);
		}
		return types;
	}

}
