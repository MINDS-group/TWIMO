package intelligentMobility.diagram.part;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.WorkspaceModifyOperation;

/**
 * @generated
 */
public class DrivingBehaviourMetamodelCreationWizard extends Wizard implements INewWizard {

	/**
	* @generated
	*/
	private IWorkbench workbench;

	/**
	* @generated
	*/
	protected IStructuredSelection selection;

	/**
	* @generated
	*/
	protected intelligentMobility.diagram.part.DrivingBehaviourMetamodelCreationWizardPage diagramModelFilePage;

	/**
	* @generated
	*/
	protected intelligentMobility.diagram.part.DrivingBehaviourMetamodelCreationWizardPage domainModelFilePage;

	/**
	* @generated
	*/
	protected Resource diagram;

	/**
	* @generated
	*/
	private boolean openNewlyCreatedDiagramEditor = true;

	/**
	* @generated
	*/
	public IWorkbench getWorkbench() {
		return workbench;
	}

	/**
	* @generated
	*/
	public IStructuredSelection getSelection() {
		return selection;
	}

	/**
	* @generated
	*/
	public final Resource getDiagram() {
		return diagram;
	}

	/**
	* @generated
	*/
	public final boolean isOpenNewlyCreatedDiagramEditor() {
		return openNewlyCreatedDiagramEditor;
	}

	/**
	* @generated
	*/
	public void setOpenNewlyCreatedDiagramEditor(boolean openNewlyCreatedDiagramEditor) {
		this.openNewlyCreatedDiagramEditor = openNewlyCreatedDiagramEditor;
	}

	/**
	* @generated
	*/
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		this.selection = selection;
		setWindowTitle(intelligentMobility.diagram.part.Messages.DrivingBehaviourMetamodelCreationWizardTitle);
		setDefaultPageImageDescriptor(intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin
				.getBundledImageDescriptor("icons/wizban/NewIntelligentMobilityWizard.gif")); //$NON-NLS-1$
		setNeedsProgressMonitor(true);
	}

	/**
	* @generated
	*/
	public void addPages() {
		diagramModelFilePage = new intelligentMobility.diagram.part.DrivingBehaviourMetamodelCreationWizardPage(
				"DiagramModelFile", getSelection(), "intelligentmobility_diagram"); //$NON-NLS-1$ //$NON-NLS-2$
		diagramModelFilePage.setTitle(
				intelligentMobility.diagram.part.Messages.DrivingBehaviourMetamodelCreationWizard_DiagramModelFilePageTitle);
		diagramModelFilePage.setDescription(
				intelligentMobility.diagram.part.Messages.DrivingBehaviourMetamodelCreationWizard_DiagramModelFilePageDescription);
		addPage(diagramModelFilePage);

		domainModelFilePage = new intelligentMobility.diagram.part.DrivingBehaviourMetamodelCreationWizardPage(
				"DomainModelFile", getSelection(), "intelligentmobility") { //$NON-NLS-1$ //$NON-NLS-2$

			public void setVisible(boolean visible) {
				if (visible) {
					String fileName = diagramModelFilePage.getFileName();
					fileName = fileName.substring(0, fileName.length() - ".intelligentmobility_diagram".length()); //$NON-NLS-1$
					setFileName(intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorUtil
							.getUniqueFileName(getContainerFullPath(), fileName, "intelligentmobility")); //$NON-NLS-1$
				}
				super.setVisible(visible);
			}
		};
		domainModelFilePage.setTitle(
				intelligentMobility.diagram.part.Messages.DrivingBehaviourMetamodelCreationWizard_DomainModelFilePageTitle);
		domainModelFilePage.setDescription(
				intelligentMobility.diagram.part.Messages.DrivingBehaviourMetamodelCreationWizard_DomainModelFilePageDescription);
		addPage(domainModelFilePage);
	}

	/**
	* @generated
	*/
	public boolean performFinish() {
		IRunnableWithProgress op = new WorkspaceModifyOperation(null) {

			protected void execute(IProgressMonitor monitor) throws CoreException, InterruptedException {
				diagram = intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorUtil
						.createDiagram(diagramModelFilePage.getURI(), domainModelFilePage.getURI(), monitor);
				if (isOpenNewlyCreatedDiagramEditor() && diagram != null) {
					try {
						intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorUtil
								.openDiagram(diagram);
					} catch (PartInitException e) {
						ErrorDialog.openError(getContainer().getShell(),
								intelligentMobility.diagram.part.Messages.DrivingBehaviourMetamodelCreationWizardOpenEditorError,
								null, e.getStatus());
					}
				}
			}
		};
		try {
			getContainer().run(false, true, op);
		} catch (InterruptedException e) {
			return false;
		} catch (InvocationTargetException e) {
			if (e.getTargetException() instanceof CoreException) {
				ErrorDialog.openError(getContainer().getShell(),
						intelligentMobility.diagram.part.Messages.DrivingBehaviourMetamodelCreationWizardCreationError,
						null, ((CoreException) e.getTargetException()).getStatus());
			} else {
				intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin.getInstance()
						.logError("Error creating diagram", e.getTargetException()); //$NON-NLS-1$
			}
			return false;
		}
		return diagram != null;
	}
}
