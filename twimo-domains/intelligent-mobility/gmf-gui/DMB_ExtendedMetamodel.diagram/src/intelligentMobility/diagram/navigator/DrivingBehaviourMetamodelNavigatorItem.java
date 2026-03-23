package intelligentMobility.diagram.navigator;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class DrivingBehaviourMetamodelNavigatorItem
		extends intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem {

	/**
	* @generated
	*/
	static {
		final Class[] supportedTypes = new Class[] { View.class, EObject.class };
		Platform.getAdapterManager().registerAdapters(new IAdapterFactory() {

			public Object getAdapter(Object adaptableObject, Class adapterType) {
				if (adaptableObject instanceof intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorItem
						&& (adapterType == View.class || adapterType == EObject.class)) {
					return ((intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorItem) adaptableObject)
							.getView();
				}
				return null;
			}

			public Class[] getAdapterList() {
				return supportedTypes;
			}
		}, intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorItem.class);
	}

	/**
	* @generated
	*/
	private View myView;

	/**
	* @generated
	*/
	private boolean myLeaf = false;

	/**
	* @generated
	*/
	public DrivingBehaviourMetamodelNavigatorItem(View view, Object parent, boolean isLeaf) {
		super(parent);
		myView = view;
		myLeaf = isLeaf;
	}

	/**
	* @generated
	*/
	public View getView() {
		return myView;
	}

	/**
	* @generated
	*/
	public boolean isLeaf() {
		return myLeaf;
	}

	/**
	* @generated
	*/
	public boolean equals(Object obj) {
		if (obj instanceof intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorItem) {
			return EcoreUtil.getURI(getView()).equals(EcoreUtil.getURI(
					((intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorItem) obj).getView()));
		}
		return super.equals(obj);
	}

	/**
	* @generated
	*/
	public int hashCode() {
		return EcoreUtil.getURI(getView()).hashCode();
	}

}
