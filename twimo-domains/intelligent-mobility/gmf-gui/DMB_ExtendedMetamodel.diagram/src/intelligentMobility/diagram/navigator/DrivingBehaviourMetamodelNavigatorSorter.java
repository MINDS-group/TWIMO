package intelligentMobility.diagram.navigator;

import org.eclipse.jface.viewers.ViewerSorter;

/**
 * @generated
 */
public class DrivingBehaviourMetamodelNavigatorSorter extends ViewerSorter {

	/**
	* @generated
	*/
	private static final int GROUP_CATEGORY = 4049;

	/**
	* @generated
	*/
	public int category(Object element) {
		if (element instanceof intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorItem) {
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorItem item = (intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorItem) element;
			return intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getVisualID(item.getView());
		}
		return GROUP_CATEGORY;
	}

}
