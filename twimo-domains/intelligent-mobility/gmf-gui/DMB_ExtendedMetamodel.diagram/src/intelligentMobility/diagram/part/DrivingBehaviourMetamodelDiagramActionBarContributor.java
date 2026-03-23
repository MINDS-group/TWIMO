package intelligentMobility.diagram.part;

import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramActionBarContributor;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchPage;

/**
 * @generated
 */
public class DrivingBehaviourMetamodelDiagramActionBarContributor extends DiagramActionBarContributor {

	/**
	* @generated
	*/
	protected Class getEditorClass() {
		return intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditor.class;
	}

	/**
	* @generated
	*/
	protected String getEditorId() {
		return intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditor.ID;
	}

	/**
	* @generated
	*/
	public void init(IActionBars bars, IWorkbenchPage page) {
		super.init(bars, page);
		// print preview
		IMenuManager fileMenu = bars.getMenuManager().findMenuUsingPath(IWorkbenchActionConstants.M_FILE);
		assert fileMenu != null;
		fileMenu.remove("pageSetupAction"); //$NON-NLS-1$
	}
}
