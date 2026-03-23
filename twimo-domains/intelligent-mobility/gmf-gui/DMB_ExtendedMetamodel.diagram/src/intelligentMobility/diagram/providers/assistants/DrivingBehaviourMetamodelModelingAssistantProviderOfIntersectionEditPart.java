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
public class DrivingBehaviourMetamodelModelingAssistantProviderOfIntersectionEditPart
		extends intelligentMobility.diagram.providers.DrivingBehaviourMetamodelModelingAssistantProvider {

	/**
	* @generated
	*/

	public List<IElementType> getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSource((intelligentMobility.diagram.edit.parts.IntersectionEditPart) sourceEditPart);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetRelTypesOnSource(
			intelligentMobility.diagram.edit.parts.IntersectionEditPart source) {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Intersection_TrafficLight_4018);
		types.add(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_SpecialCondition_Intersection_4028);
		return types;
	}

	/**
	* @generated
	*/

	public List<IElementType> getRelTypesOnSourceAndTarget(IAdaptable source, IAdaptable target) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSourceAndTarget(
				(intelligentMobility.diagram.edit.parts.IntersectionEditPart) sourceEditPart, targetEditPart);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetRelTypesOnSourceAndTarget(
			intelligentMobility.diagram.edit.parts.IntersectionEditPart source, IGraphicalEditPart targetEditPart) {
		List<IElementType> types = new LinkedList<IElementType>();
		if (targetEditPart instanceof intelligentMobility.diagram.edit.parts.Traffic_LightEditPart) {
			types.add(
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Intersection_TrafficLight_4018);
		}
		if (targetEditPart instanceof intelligentMobility.diagram.edit.parts.Special_ConditionEditPart) {
			types.add(
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_SpecialCondition_Intersection_4028);
		}
		return types;
	}

	/**
	* @generated
	*/

	public List<IElementType> getTypesForTarget(IAdaptable source, IElementType relationshipType) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		return doGetTypesForTarget((intelligentMobility.diagram.edit.parts.IntersectionEditPart) sourceEditPart,
				relationshipType);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetTypesForTarget(intelligentMobility.diagram.edit.parts.IntersectionEditPart source,
			IElementType relationshipType) {
		List<IElementType> types = new ArrayList<IElementType>();
		if (relationshipType == intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Intersection_TrafficLight_4018) {
			types.add(intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Traffic_Light_2003);
		} else if (relationshipType == intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_SpecialCondition_Intersection_4028) {
			types.add(
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Special_Condition_2001);
		}
		return types;
	}

	/**
	* @generated
	*/

	public List<IElementType> getRelTypesOnTarget(IAdaptable target) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnTarget((intelligentMobility.diagram.edit.parts.IntersectionEditPart) targetEditPart);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetRelTypesOnTarget(
			intelligentMobility.diagram.edit.parts.IntersectionEditPart target) {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Infrastructure_VehicleConfiguration_4035);
		types.add(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_CommunicationInterface_Infrastructure_4039);
		return types;
	}

	/**
	* @generated
	*/

	public List<IElementType> getTypesForSource(IAdaptable target, IElementType relationshipType) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetTypesForSource((intelligentMobility.diagram.edit.parts.IntersectionEditPart) targetEditPart,
				relationshipType);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetTypesForSource(intelligentMobility.diagram.edit.parts.IntersectionEditPart target,
			IElementType relationshipType) {
		List<IElementType> types = new ArrayList<IElementType>();
		if (relationshipType == intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Infrastructure_VehicleConfiguration_4035) {
			types.add(
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Vehicle_Configuration_2008);
		} else if (relationshipType == intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_CommunicationInterface_Infrastructure_4039) {
			types.add(
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.CommunicationInterface_2032);
		}
		return types;
	}

}
