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
public class DrivingBehaviourMetamodelModelingAssistantProviderOfVehicle_ConfigurationEditPart
		extends intelligentMobility.diagram.providers.DrivingBehaviourMetamodelModelingAssistantProvider {

	/**
	* @generated
	*/

	public List<IElementType> getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSource(
				(intelligentMobility.diagram.edit.parts.Vehicle_ConfigurationEditPart) sourceEditPart);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetRelTypesOnSource(
			intelligentMobility.diagram.edit.parts.Vehicle_ConfigurationEditPart source) {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Vehicle_Environment_4004);
		types.add(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Infrastructure_VehicleConfiguration_4035);
		return types;
	}

	/**
	* @generated
	*/

	public List<IElementType> getRelTypesOnSourceAndTarget(IAdaptable source, IAdaptable target) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSourceAndTarget(
				(intelligentMobility.diagram.edit.parts.Vehicle_ConfigurationEditPart) sourceEditPart, targetEditPart);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetRelTypesOnSourceAndTarget(
			intelligentMobility.diagram.edit.parts.Vehicle_ConfigurationEditPart source,
			IGraphicalEditPart targetEditPart) {
		List<IElementType> types = new LinkedList<IElementType>();
		if (targetEditPart instanceof intelligentMobility.diagram.edit.parts.Environment_BackgroundEditPart) {
			types.add(
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Vehicle_Environment_4004);
		}
		if (targetEditPart instanceof intelligentMobility.diagram.edit.parts.Traffic_LightEditPart) {
			types.add(
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Infrastructure_VehicleConfiguration_4035);
		}
		if (targetEditPart instanceof intelligentMobility.diagram.edit.parts.IntersectionEditPart) {
			types.add(
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Infrastructure_VehicleConfiguration_4035);
		}
		if (targetEditPart instanceof intelligentMobility.diagram.edit.parts.Intersection2EditPart) {
			types.add(
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Infrastructure_VehicleConfiguration_4035);
		}
		return types;
	}

	/**
	* @generated
	*/

	public List<IElementType> getTypesForTarget(IAdaptable source, IElementType relationshipType) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		return doGetTypesForTarget(
				(intelligentMobility.diagram.edit.parts.Vehicle_ConfigurationEditPart) sourceEditPart,
				relationshipType);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetTypesForTarget(
			intelligentMobility.diagram.edit.parts.Vehicle_ConfigurationEditPart source,
			IElementType relationshipType) {
		List<IElementType> types = new ArrayList<IElementType>();
		if (relationshipType == intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Vehicle_Environment_4004) {
			types.add(
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Environment_Background_2013);
		} else if (relationshipType == intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Infrastructure_VehicleConfiguration_4035) {
			types.add(intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Traffic_Light_2003);
			types.add(intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Intersection_2007);
			types.add(intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Intersection_2031);
		}
		return types;
	}

	/**
	* @generated
	*/

	public List<IElementType> getRelTypesOnTarget(IAdaptable target) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnTarget(
				(intelligentMobility.diagram.edit.parts.Vehicle_ConfigurationEditPart) targetEditPart);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetRelTypesOnTarget(
			intelligentMobility.diagram.edit.parts.Vehicle_ConfigurationEditPart target) {
		List<IElementType> types = new ArrayList<IElementType>(4);
		types.add(intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Driver_Vehicle_4002);
		types.add(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_VehicleConfiguration_VehicleType_4013);
		types.add(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_CommunicationInterface_VehicleConfiguration_4036);
		types.add(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_CooperativeBehaviour_VehicleConfiguration_4040);
		return types;
	}

	/**
	* @generated
	*/

	public List<IElementType> getTypesForSource(IAdaptable target, IElementType relationshipType) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetTypesForSource(
				(intelligentMobility.diagram.edit.parts.Vehicle_ConfigurationEditPart) targetEditPart,
				relationshipType);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetTypesForSource(
			intelligentMobility.diagram.edit.parts.Vehicle_ConfigurationEditPart target,
			IElementType relationshipType) {
		List<IElementType> types = new ArrayList<IElementType>();
		if (relationshipType == intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Driver_Vehicle_4002) {
			types.add(intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Driver_Profile_2025);
		} else if (relationshipType == intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_VehicleConfiguration_VehicleType_4013) {
			types.add(intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Platoon_2010);
			types.add(intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Leading_Vehicle_2021);
			types.add(
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Following_Vehicle_2028);
			types.add(intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Platoon_2035);
			types.add(intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Normal_Vehicle_2036);
		} else if (relationshipType == intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_CommunicationInterface_VehicleConfiguration_4036) {
			types.add(
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.CommunicationInterface_2032);
		} else if (relationshipType == intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_CooperativeBehaviour_VehicleConfiguration_4040) {
			types.add(
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.CooperativeBehavior_2037);
		}
		return types;
	}

}
