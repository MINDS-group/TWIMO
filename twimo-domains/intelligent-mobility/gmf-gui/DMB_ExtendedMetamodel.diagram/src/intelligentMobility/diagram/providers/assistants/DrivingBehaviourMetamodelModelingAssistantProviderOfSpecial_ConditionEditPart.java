package intelligentMobility.diagram.providers.assistants;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

/**
 * @generated
 */
public class DrivingBehaviourMetamodelModelingAssistantProviderOfSpecial_ConditionEditPart
		extends intelligentMobility.diagram.providers.DrivingBehaviourMetamodelModelingAssistantProvider {

	/**
	* @generated
	*/

	public List<IElementType> getRelTypesOnTarget(IAdaptable target) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnTarget((intelligentMobility.diagram.edit.parts.Special_ConditionEditPart) targetEditPart);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetRelTypesOnTarget(
			intelligentMobility.diagram.edit.parts.Special_ConditionEditPart target) {
		List<IElementType> types = new ArrayList<IElementType>(3);
		types.add(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_EnvironmentCondition_SpecialCondition_4027);
		types.add(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_SpecialCondition_Intersection_4028);
		types.add(
				intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Collision_SpecialCondition_4042);
		return types;
	}

	/**
	* @generated
	*/

	public List<IElementType> getTypesForSource(IAdaptable target, IElementType relationshipType) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetTypesForSource((intelligentMobility.diagram.edit.parts.Special_ConditionEditPart) targetEditPart,
				relationshipType);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetTypesForSource(
			intelligentMobility.diagram.edit.parts.Special_ConditionEditPart target, IElementType relationshipType) {
		List<IElementType> types = new ArrayList<IElementType>();
		if (relationshipType == intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_EnvironmentCondition_SpecialCondition_4027) {
			types.add(
					intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Environment_Condition_2009);
		} else if (relationshipType == intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_SpecialCondition_Intersection_4028) {
			types.add(intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Intersection_2007);
			types.add(intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Intersection_2031);
		} else if (relationshipType == intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Link_Collision_SpecialCondition_4042) {
			types.add(intelligentMobility.diagram.providers.DrivingBehaviourMetamodelElementTypes.Collision_2017);
		}
		return types;
	}

}
