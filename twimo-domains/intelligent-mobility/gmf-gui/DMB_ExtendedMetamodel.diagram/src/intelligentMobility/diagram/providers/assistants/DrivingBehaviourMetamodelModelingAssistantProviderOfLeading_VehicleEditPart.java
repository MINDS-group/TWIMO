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
public class DrivingBehaviourMetamodelModelingAssistantProviderOfLeading_VehicleEditPart
		extends intelligentMobility.diagram.providers.DrivingBehaviourMetamodelModelingAssistantProvider {

	/**
	* @generated
	*/

	public List<IElementType> getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSource((intelligentMobility.diagram.edit.parts.Leading_VehicleEditPart) sourceEditPart);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetRelTypesOnSource(
			intelligentMobility.diagram.edit.parts.Leading_VehicleEditPart source) {
		List<IElementType> types = new ArrayList<IElementType>(3);
		types.add(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_NormalVehicle_SafetyRequirements_4005);
		types.add(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_VehicleConfiguration_VehicleType_4013);
		types.add(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_FollowingVehicle_FrontVehicle_4023);
		return types;
	}

	/**
	* @generated
	*/

	public List<IElementType> getRelTypesOnSourceAndTarget(IAdaptable source, IAdaptable target) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSourceAndTarget(
				(intelligentMobility.diagram.edit.parts.Leading_VehicleEditPart) sourceEditPart, targetEditPart);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetRelTypesOnSourceAndTarget(
			intelligentMobility.diagram.edit.parts.Leading_VehicleEditPart source, IGraphicalEditPart targetEditPart) {
		List<IElementType> types = new LinkedList<IElementType>();
		if (targetEditPart instanceof intelligentMobility.diagram.edit.parts.Safety_RequirementEditPart) {
			types.add(
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_NormalVehicle_SafetyRequirements_4005);
		}
		if (targetEditPart instanceof intelligentMobility.diagram.edit.parts.Vehicle_ConfigurationEditPart) {
			types.add(
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_VehicleConfiguration_VehicleType_4013);
		}
		if (targetEditPart instanceof intelligentMobility.diagram.edit.parts.Following_VehicleEditPart) {
			types.add(
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_FollowingVehicle_FrontVehicle_4023);
		}
		return types;
	}

	/**
	* @generated
	*/

	public List<IElementType> getTypesForTarget(IAdaptable source, IElementType relationshipType) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		return doGetTypesForTarget((intelligentMobility.diagram.edit.parts.Leading_VehicleEditPart) sourceEditPart,
				relationshipType);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetTypesForTarget(intelligentMobility.diagram.edit.parts.Leading_VehicleEditPart source,
			IElementType relationshipType) {
		List<IElementType> types = new ArrayList<IElementType>();
		if (relationshipType == intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_NormalVehicle_SafetyRequirements_4005) {
			types.add(
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Safety_Requirement_2026);
		} else if (relationshipType == intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_VehicleConfiguration_VehicleType_4013) {
			types.add(
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Vehicle_Configuration_2008);
		} else if (relationshipType == intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_FollowingVehicle_FrontVehicle_4023) {
			types.add(
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Following_Vehicle_2028);
		}
		return types;
	}

	/**
	* @generated
	*/

	public List<IElementType> getRelTypesOnTarget(IAdaptable target) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnTarget((intelligentMobility.diagram.edit.parts.Leading_VehicleEditPart) targetEditPart);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetRelTypesOnTarget(
			intelligentMobility.diagram.edit.parts.Leading_VehicleEditPart target) {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Platoon_LeadingVehicle_4014);
		return types;
	}

	/**
	* @generated
	*/

	public List<IElementType> getTypesForSource(IAdaptable target, IElementType relationshipType) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetTypesForSource((intelligentMobility.diagram.edit.parts.Leading_VehicleEditPart) targetEditPart,
				relationshipType);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetTypesForSource(intelligentMobility.diagram.edit.parts.Leading_VehicleEditPart target,
			IElementType relationshipType) {
		List<IElementType> types = new ArrayList<IElementType>();
		if (relationshipType == intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Platoon_LeadingVehicle_4014) {
			types.add(intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Platoon_2010);
			types.add(intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Platoon_2035);
		}
		return types;
	}

}
