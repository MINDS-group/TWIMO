package intelligentMobility.diagram.navigator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.emf.core.GMFEditingDomainFactory;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonContentProvider;

/**
 * @generated
 */
public class DrivingBehaviourMetamodelNavigatorContentProvider implements ICommonContentProvider {

	/**
	* @generated
	*/
	private static final Object[] EMPTY_ARRAY = new Object[0];

	/**
	* @generated
	*/
	private Viewer myViewer;

	/**
	* @generated
	*/
	private AdapterFactoryEditingDomain myEditingDomain;

	/**
	* @generated
	*/
	private WorkspaceSynchronizer myWorkspaceSynchronizer;

	/**
	* @generated
	*/
	private Runnable myViewerRefreshRunnable;

	/**
	* @generated
	*/
	public DrivingBehaviourMetamodelNavigatorContentProvider() {
		TransactionalEditingDomain editingDomain = GMFEditingDomainFactory.INSTANCE.createEditingDomain();
		myEditingDomain = (AdapterFactoryEditingDomain) editingDomain;
		myEditingDomain.setResourceToReadOnlyMap(new HashMap() {
			public Object get(Object key) {
				if (!containsKey(key)) {
					put(key, Boolean.TRUE);
				}
				return super.get(key);
			}
		});
		myViewerRefreshRunnable = new Runnable() {
			public void run() {
				if (myViewer != null) {
					myViewer.refresh();
				}
			}
		};
		myWorkspaceSynchronizer = new WorkspaceSynchronizer(editingDomain, new WorkspaceSynchronizer.Delegate() {
			public void dispose() {
			}

			public boolean handleResourceChanged(final Resource resource) {
				unloadAllResources();
				asyncRefresh();
				return true;
			}

			public boolean handleResourceDeleted(Resource resource) {
				unloadAllResources();
				asyncRefresh();
				return true;
			}

			public boolean handleResourceMoved(Resource resource, final URI newURI) {
				unloadAllResources();
				asyncRefresh();
				return true;
			}
		});
	}

	/**
	* @generated
	*/
	public void dispose() {
		myWorkspaceSynchronizer.dispose();
		myWorkspaceSynchronizer = null;
		myViewerRefreshRunnable = null;
		myViewer = null;
		unloadAllResources();
		((TransactionalEditingDomain) myEditingDomain).dispose();
		myEditingDomain = null;
	}

	/**
	* @generated
	*/
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		myViewer = viewer;
	}

	/**
	* @generated
	*/
	void unloadAllResources() {
		for (Iterator /*[org.eclipse.emf.ecore.resource.Resource]*/ it = myEditingDomain.getResourceSet().getResources()
				.iterator(); it.hasNext();) {
			Resource nextResource = (Resource) it.next();
			nextResource.unload();
		}
	}

	/**
	* @generated
	*/
	void asyncRefresh() {
		if (myViewer != null && !myViewer.getControl().isDisposed()) {
			myViewer.getControl().getDisplay().asyncExec(myViewerRefreshRunnable);
		}
	}

	/**
	* @generated
	*/
	public Object[] getElements(Object inputElement) {
		return getChildren(inputElement);
	}

	/**
	* @generated
	*/
	public void restoreState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public void saveState(IMemento aMemento) {
	}

	/**
	* @generated
	*/
	public void init(ICommonContentExtensionSite aConfig) {
	}

	/**
	* @generated
	*/
	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof IFile) {
			IFile file = (IFile) parentElement;
			URI fileURI = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
			Resource resource = myEditingDomain.getResourceSet().getResource(fileURI, true);
			ArrayList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorItem]*/ result = new ArrayList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorItem]*/();
			ArrayList/*[org.eclipse.gmf.runtime.notation.View]*/ topViews = new ArrayList/*[org.eclipse.gmf.runtime.notation.View]*/(
					resource.getContents().size());
			for (Iterator /*[org.eclipse.emf.ecore.EObject]*/ it = resource.getContents().iterator(); it.hasNext();) {
				EObject o = (EObject) it.next();
				if (o instanceof View) {
					topViews.add((View) o);
				}
			}
			result.addAll(createNavigatorItems(
					selectViewsByType(topViews, intelligentMobility.diagram.edit.parts.MobilitySystemEditPart.MODEL_ID),
					file, false));
			return result.toArray();
		}

		if (parentElement instanceof intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup) {
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup group = (intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup) parentElement;
			return group.getChildren();
		}

		if (parentElement instanceof intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorItem) {
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorItem navigatorItem = (intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorItem) parentElement;
			if (navigatorItem.isLeaf() || !isOwnView(navigatorItem.getView())) {
				return EMPTY_ARRAY;
			}
			return getViewChildren(navigatorItem.getView(), parentElement);
		}

		return EMPTY_ARRAY;
	}

	/**
	* @generated
	*/
	private Object[] getViewChildren(View view, Object parentElement) {
		switch (intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getVisualID(view)) {

		case intelligentMobility.diagram.edit.parts.MobilitySystemEditPart.VISUAL_ID: {
			LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/ result = new LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/();
			Diagram sv = (Diagram) view;
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup links = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_MobilitySystem_1000_links,
					"icons/linksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection/*[org.eclipse.gmf.runtime.notation.View]*/ connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Special_ConditionEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.WeatherEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Traffic_LightEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Knowledge_and_SkillEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.ObstructionEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Driver_PreferenceEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.IntersectionEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Vehicle_ConfigurationEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Environment_ConditionEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.PlatoonEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.ForwardEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Lane_TypeEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Environment_BackgroundEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.TurnEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.LaneChangingEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Driver_EmotionEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.CollisionEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.PossibleVehicleEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.FollowingEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.GapAcceptanceEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Leading_VehicleEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.BackwardEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.RegulationEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Traffic_SituationEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Driver_ProfileEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Safety_RequirementEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Driving_BehaviourEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Following_VehicleEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Abnormal_BehaviourEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Backward2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Intersection2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.CommunicationInterfaceEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.GoalEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Normal_BehaviourEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Platoon2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Normal_VehicleEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.CooperativeBehaviorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.ActionEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_LaneType_RegulationEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Link_Driver_VehicleEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_EnvironmentBackground_PossibleVehicleEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_Vehicle_EnvironmentEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_NormalVehicle_SafetyRequirementsEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_DriverProfile_DriverPreferenceEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_Collision_ObstructionEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_Platoon_FollowingVehicleEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_DriverPreference_EnvironmentConditionEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_AbnormalBehaviour_ActionEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Link_Following_ForwardEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_LaneTypeEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_VehicleConfiguration_VehicleTypeEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_Platoon_LeadingVehicleEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Link_Driver_EnvironmentEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Link_LaneChanging_TurnEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_TrafficConditionEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_Intersection_TrafficLightEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Link_Following_MinGapEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_NormalBehaviour_LaneChangingEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_SafetyRequirement_RegulationEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_DriverPreference_DrivingBehaviourEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_FollowingVehicle_FrontVehicleEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_DriverPreference_DriverEmotionEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_EnvironmentBackground_EnvironmentConditionEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_WeatherEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_SpecialConditionEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_SpecialCondition_IntersectionEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Link_Following_BackwardEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_RegulationsEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_DrivingBehaviour_NormalBehaviourEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_LaneChanging_EnvironmentConditionEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_LaneChanging_GapAcceptanceEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_NormalBehaviour_FollowingEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_Infrastructure_VehicleConfigurationEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_CommunicationInterface_VehicleConfigurationEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_Goal_DrivingBehaviourEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_CooperativeBehaviour_CommunicationInterfaceEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_CommunicationInterface_InfrastructureEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_CooperativeBehaviour_VehicleConfigurationEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_TrafficSituation_EnvironmentConditionEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_Collision_SpecialConditionEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_Following_LaneChangingEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Link_Action_BackwardEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Link_Action_ForwardEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Link_Action_TurnEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_KnowledgeAndSkill_DriverPreferenceEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			if (!links.isEmpty()) {
				result.add(links);
			}
			return result.toArray();
		}

		case intelligentMobility.diagram.edit.parts.Special_ConditionEditPart.VISUAL_ID: {
			LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/ result = new LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/();
			Node sv = (Node) view;
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup incominglinks = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Special_Condition_2001_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection/*[org.eclipse.gmf.runtime.notation.View]*/ connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_SpecialConditionEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_SpecialCondition_IntersectionEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_Collision_SpecialConditionEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case intelligentMobility.diagram.edit.parts.WeatherEditPart.VISUAL_ID: {
			LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/ result = new LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/();
			Node sv = (Node) view;
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup incominglinks = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Weather_2002_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection/*[org.eclipse.gmf.runtime.notation.View]*/ connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_WeatherEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case intelligentMobility.diagram.edit.parts.Traffic_LightEditPart.VISUAL_ID: {
			LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/ result = new LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/();
			Node sv = (Node) view;
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup incominglinks = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Traffic_Light_2003_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection/*[org.eclipse.gmf.runtime.notation.View]*/ connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_Intersection_TrafficLightEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_Infrastructure_VehicleConfigurationEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_CommunicationInterface_InfrastructureEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case intelligentMobility.diagram.edit.parts.Knowledge_and_SkillEditPart.VISUAL_ID: {
			LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/ result = new LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/();
			Node sv = (Node) view;
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup incominglinks = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Knowledge_and_Skill_2004_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection/*[org.eclipse.gmf.runtime.notation.View]*/ connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_KnowledgeAndSkill_DriverPreferenceEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case intelligentMobility.diagram.edit.parts.ObstructionEditPart.VISUAL_ID: {
			LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/ result = new LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/();
			Node sv = (Node) view;
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup outgoinglinks = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Obstruction_2005_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection/*[org.eclipse.gmf.runtime.notation.View]*/ connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_Collision_ObstructionEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case intelligentMobility.diagram.edit.parts.Driver_PreferenceEditPart.VISUAL_ID: {
			LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/ result = new LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/();
			Node sv = (Node) view;
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup incominglinks = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Driver_Preference_2006_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup outgoinglinks = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Driver_Preference_2006_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection/*[org.eclipse.gmf.runtime.notation.View]*/ connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_DriverProfile_DriverPreferenceEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_DriverPreference_EnvironmentConditionEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_DriverPreference_DrivingBehaviourEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_DriverPreference_DriverEmotionEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_KnowledgeAndSkill_DriverPreferenceEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case intelligentMobility.diagram.edit.parts.IntersectionEditPart.VISUAL_ID: {
			LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/ result = new LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/();
			Node sv = (Node) view;
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup outgoinglinks = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Intersection_2007_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup incominglinks = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Intersection_2007_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection/*[org.eclipse.gmf.runtime.notation.View]*/ connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_Intersection_TrafficLightEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_SpecialCondition_IntersectionEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_Infrastructure_VehicleConfigurationEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_CommunicationInterface_InfrastructureEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case intelligentMobility.diagram.edit.parts.Vehicle_ConfigurationEditPart.VISUAL_ID: {
			LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/ result = new LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/();
			Node sv = (Node) view;
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup incominglinks = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Vehicle_Configuration_2008_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup outgoinglinks = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Vehicle_Configuration_2008_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection/*[org.eclipse.gmf.runtime.notation.View]*/ connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Link_Driver_VehicleEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_Vehicle_EnvironmentEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_VehicleConfiguration_VehicleTypeEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_Infrastructure_VehicleConfigurationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_CommunicationInterface_VehicleConfigurationEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_CooperativeBehaviour_VehicleConfigurationEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case intelligentMobility.diagram.edit.parts.Environment_ConditionEditPart.VISUAL_ID: {
			LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/ result = new LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/();
			Node sv = (Node) view;
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup incominglinks = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Environment_Condition_2009_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup outgoinglinks = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Environment_Condition_2009_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection/*[org.eclipse.gmf.runtime.notation.View]*/ connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_DriverPreference_EnvironmentConditionEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_LaneTypeEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_TrafficConditionEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_EnvironmentBackground_EnvironmentConditionEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_WeatherEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_SpecialConditionEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_RegulationsEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_LaneChanging_EnvironmentConditionEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_TrafficSituation_EnvironmentConditionEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case intelligentMobility.diagram.edit.parts.PlatoonEditPart.VISUAL_ID: {
			LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/ result = new LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/();
			Node sv = (Node) view;
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup outgoinglinks = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Platoon_2010_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection/*[org.eclipse.gmf.runtime.notation.View]*/ connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_Platoon_FollowingVehicleEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_VehicleConfiguration_VehicleTypeEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_Platoon_LeadingVehicleEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case intelligentMobility.diagram.edit.parts.ForwardEditPart.VISUAL_ID: {
			LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/ result = new LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/();
			Node sv = (Node) view;
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup outgoinglinks = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Forward_2011_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup incominglinks = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Forward_2011_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection/*[org.eclipse.gmf.runtime.notation.View]*/ connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_AbnormalBehaviour_ActionEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Link_Following_ForwardEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Link_Action_BackwardEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Link_Action_ForwardEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Link_Action_ForwardEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Link_Action_TurnEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case intelligentMobility.diagram.edit.parts.Lane_TypeEditPart.VISUAL_ID: {
			LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/ result = new LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/();
			Node sv = (Node) view;
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup outgoinglinks = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Lane_Type_2012_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection/*[org.eclipse.gmf.runtime.notation.View]*/ connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_LaneType_RegulationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_LaneTypeEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case intelligentMobility.diagram.edit.parts.Environment_BackgroundEditPart.VISUAL_ID: {
			LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/ result = new LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/();
			Node sv = (Node) view;
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup incominglinks = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Environment_Background_2013_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup outgoinglinks = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Environment_Background_2013_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection/*[org.eclipse.gmf.runtime.notation.View]*/ connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_EnvironmentBackground_PossibleVehicleEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_Vehicle_EnvironmentEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Link_Driver_EnvironmentEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_EnvironmentBackground_EnvironmentConditionEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case intelligentMobility.diagram.edit.parts.TurnEditPart.VISUAL_ID: {
			LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/ result = new LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/();
			Node sv = (Node) view;
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup outgoinglinks = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Turn_2014_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup incominglinks = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Turn_2014_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection/*[org.eclipse.gmf.runtime.notation.View]*/ connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_AbnormalBehaviour_ActionEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Link_LaneChanging_TurnEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Link_Action_BackwardEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Link_Action_ForwardEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Link_Action_TurnEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Link_Action_TurnEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case intelligentMobility.diagram.edit.parts.LaneChangingEditPart.VISUAL_ID: {
			LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/ result = new LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/();
			Node sv = (Node) view;
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup incominglinks = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_LaneChanging_2015_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup outgoinglinks = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_LaneChanging_2015_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection/*[org.eclipse.gmf.runtime.notation.View]*/ connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Link_LaneChanging_TurnEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Link_Following_MinGapEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_NormalBehaviour_LaneChangingEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_LaneChanging_EnvironmentConditionEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_LaneChanging_GapAcceptanceEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_Following_LaneChangingEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case intelligentMobility.diagram.edit.parts.Driver_EmotionEditPart.VISUAL_ID: {
			LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/ result = new LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/();
			Node sv = (Node) view;
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup incominglinks = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Driver_Emotion_2016_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection/*[org.eclipse.gmf.runtime.notation.View]*/ connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_DriverPreference_DriverEmotionEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case intelligentMobility.diagram.edit.parts.CollisionEditPart.VISUAL_ID: {
			LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/ result = new LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/();
			Node sv = (Node) view;
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup incominglinks = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Collision_2017_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup outgoinglinks = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Collision_2017_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection/*[org.eclipse.gmf.runtime.notation.View]*/ connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_Collision_ObstructionEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_Collision_SpecialConditionEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case intelligentMobility.diagram.edit.parts.PossibleVehicleEditPart.VISUAL_ID: {
			LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/ result = new LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/();
			Node sv = (Node) view;
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup outgoinglinks = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_PossibleVehicle_2018_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection/*[org.eclipse.gmf.runtime.notation.View]*/ connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_EnvironmentBackground_PossibleVehicleEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case intelligentMobility.diagram.edit.parts.FollowingEditPart.VISUAL_ID: {
			LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/ result = new LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/();
			Node sv = (Node) view;
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup outgoinglinks = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Following_2019_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup incominglinks = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Following_2019_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection/*[org.eclipse.gmf.runtime.notation.View]*/ connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Link_Following_ForwardEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Link_Following_MinGapEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Link_Following_BackwardEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_NormalBehaviour_FollowingEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_Following_LaneChangingEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case intelligentMobility.diagram.edit.parts.GapAcceptanceEditPart.VISUAL_ID: {
			LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/ result = new LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/();
			Node sv = (Node) view;
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup incominglinks = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_GapAcceptance_2020_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection/*[org.eclipse.gmf.runtime.notation.View]*/ connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_LaneChanging_GapAcceptanceEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case intelligentMobility.diagram.edit.parts.Leading_VehicleEditPart.VISUAL_ID: {
			LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/ result = new LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/();
			Node sv = (Node) view;
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup outgoinglinks = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Leading_Vehicle_2021_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup incominglinks = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Leading_Vehicle_2021_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection/*[org.eclipse.gmf.runtime.notation.View]*/ connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_NormalVehicle_SafetyRequirementsEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_VehicleConfiguration_VehicleTypeEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_Platoon_LeadingVehicleEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_FollowingVehicle_FrontVehicleEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case intelligentMobility.diagram.edit.parts.BackwardEditPart.VISUAL_ID: {
			LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/ result = new LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/();
			Node sv = (Node) view;
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup outgoinglinks = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Backward_2022_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup incominglinks = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Backward_2022_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection/*[org.eclipse.gmf.runtime.notation.View]*/ connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_AbnormalBehaviour_ActionEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Link_Following_BackwardEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Link_Action_BackwardEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Link_Action_BackwardEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Link_Action_ForwardEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Link_Action_TurnEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case intelligentMobility.diagram.edit.parts.RegulationEditPart.VISUAL_ID: {
			LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/ result = new LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/();
			Node sv = (Node) view;
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup incominglinks = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Regulation_2023_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection/*[org.eclipse.gmf.runtime.notation.View]*/ connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_LaneType_RegulationEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_SafetyRequirement_RegulationEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_RegulationsEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case intelligentMobility.diagram.edit.parts.Traffic_SituationEditPart.VISUAL_ID: {
			LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/ result = new LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/();
			Node sv = (Node) view;
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup outgoinglinks = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Traffic_Situation_2024_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup incominglinks = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Traffic_Situation_2024_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection/*[org.eclipse.gmf.runtime.notation.View]*/ connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_TrafficConditionEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_TrafficSituation_EnvironmentConditionEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case intelligentMobility.diagram.edit.parts.Driver_ProfileEditPart.VISUAL_ID: {
			LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/ result = new LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/();
			Node sv = (Node) view;
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup outgoinglinks = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Driver_Profile_2025_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection/*[org.eclipse.gmf.runtime.notation.View]*/ connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Link_Driver_VehicleEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_DriverProfile_DriverPreferenceEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Link_Driver_EnvironmentEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case intelligentMobility.diagram.edit.parts.Safety_RequirementEditPart.VISUAL_ID: {
			LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/ result = new LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/();
			Node sv = (Node) view;
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup incominglinks = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Safety_Requirement_2026_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup outgoinglinks = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Safety_Requirement_2026_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection/*[org.eclipse.gmf.runtime.notation.View]*/ connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_NormalVehicle_SafetyRequirementsEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_SafetyRequirement_RegulationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case intelligentMobility.diagram.edit.parts.Driving_BehaviourEditPart.VISUAL_ID: {
			LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/ result = new LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/();
			Node sv = (Node) view;
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup outgoinglinks = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Driving_Behaviour_2027_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection/*[org.eclipse.gmf.runtime.notation.View]*/ connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_DriverPreference_DrivingBehaviourEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_DrivingBehaviour_NormalBehaviourEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_Goal_DrivingBehaviourEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case intelligentMobility.diagram.edit.parts.Following_VehicleEditPart.VISUAL_ID: {
			LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/ result = new LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/();
			Node sv = (Node) view;
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup outgoinglinks = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Following_Vehicle_2028_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup incominglinks = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Following_Vehicle_2028_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection/*[org.eclipse.gmf.runtime.notation.View]*/ connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_NormalVehicle_SafetyRequirementsEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_Platoon_FollowingVehicleEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_VehicleConfiguration_VehicleTypeEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_FollowingVehicle_FrontVehicleEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_FollowingVehicle_FrontVehicleEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case intelligentMobility.diagram.edit.parts.Abnormal_BehaviourEditPart.VISUAL_ID: {
			LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/ result = new LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/();
			Node sv = (Node) view;
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup incominglinks = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Abnormal_Behaviour_2029_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup outgoinglinks = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Abnormal_Behaviour_2029_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection/*[org.eclipse.gmf.runtime.notation.View]*/ connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_AbnormalBehaviour_ActionEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_NormalBehaviour_LaneChangingEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_DrivingBehaviour_NormalBehaviourEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_NormalBehaviour_FollowingEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case intelligentMobility.diagram.edit.parts.Backward2EditPart.VISUAL_ID: {
			LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/ result = new LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/();
			Node sv = (Node) view;
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup outgoinglinks = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Backward_2030_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup incominglinks = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Backward_2030_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection/*[org.eclipse.gmf.runtime.notation.View]*/ connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_AbnormalBehaviour_ActionEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Link_Following_BackwardEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Link_Action_BackwardEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Link_Action_BackwardEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Link_Action_ForwardEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Link_Action_TurnEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case intelligentMobility.diagram.edit.parts.Intersection2EditPart.VISUAL_ID: {
			LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/ result = new LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/();
			Node sv = (Node) view;
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup outgoinglinks = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Intersection_2031_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup incominglinks = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Intersection_2031_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection/*[org.eclipse.gmf.runtime.notation.View]*/ connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_Intersection_TrafficLightEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_SpecialCondition_IntersectionEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_Infrastructure_VehicleConfigurationEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_CommunicationInterface_InfrastructureEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case intelligentMobility.diagram.edit.parts.CommunicationInterfaceEditPart.VISUAL_ID: {
			LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/ result = new LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/();
			Node sv = (Node) view;
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup outgoinglinks = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_CommunicationInterface_2032_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup incominglinks = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_CommunicationInterface_2032_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection/*[org.eclipse.gmf.runtime.notation.View]*/ connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_CommunicationInterface_VehicleConfigurationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_CooperativeBehaviour_CommunicationInterfaceEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_CommunicationInterface_InfrastructureEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case intelligentMobility.diagram.edit.parts.GoalEditPart.VISUAL_ID: {
			LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/ result = new LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/();
			Node sv = (Node) view;
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup incominglinks = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Goal_2033_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection/*[org.eclipse.gmf.runtime.notation.View]*/ connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_Goal_DrivingBehaviourEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case intelligentMobility.diagram.edit.parts.Normal_BehaviourEditPart.VISUAL_ID: {
			LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/ result = new LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/();
			Node sv = (Node) view;
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup outgoinglinks = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Normal_Behaviour_2034_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup incominglinks = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Normal_Behaviour_2034_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection/*[org.eclipse.gmf.runtime.notation.View]*/ connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_NormalBehaviour_LaneChangingEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_DrivingBehaviour_NormalBehaviourEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_NormalBehaviour_FollowingEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case intelligentMobility.diagram.edit.parts.Platoon2EditPart.VISUAL_ID: {
			LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/ result = new LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/();
			Node sv = (Node) view;
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup outgoinglinks = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Platoon_2035_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection/*[org.eclipse.gmf.runtime.notation.View]*/ connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_Platoon_FollowingVehicleEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_VehicleConfiguration_VehicleTypeEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_Platoon_LeadingVehicleEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case intelligentMobility.diagram.edit.parts.Normal_VehicleEditPart.VISUAL_ID: {
			LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/ result = new LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/();
			Node sv = (Node) view;
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup outgoinglinks = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Normal_Vehicle_2036_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection/*[org.eclipse.gmf.runtime.notation.View]*/ connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_NormalVehicle_SafetyRequirementsEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_VehicleConfiguration_VehicleTypeEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case intelligentMobility.diagram.edit.parts.CooperativeBehaviorEditPart.VISUAL_ID: {
			LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/ result = new LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/();
			Node sv = (Node) view;
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup outgoinglinks = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_CooperativeBehavior_2037_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection/*[org.eclipse.gmf.runtime.notation.View]*/ connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_DriverPreference_DrivingBehaviourEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_DrivingBehaviour_NormalBehaviourEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_Goal_DrivingBehaviourEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_CooperativeBehaviour_CommunicationInterfaceEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_CooperativeBehaviour_VehicleConfigurationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case intelligentMobility.diagram.edit.parts.ActionEditPart.VISUAL_ID: {
			LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/ result = new LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/();
			Node sv = (Node) view;
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup outgoinglinks = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Action_2039_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection/*[org.eclipse.gmf.runtime.notation.View]*/ connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(
							intelligentMobility.diagram.edit.parts.Link_AbnormalBehaviour_ActionEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Link_Action_BackwardEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Link_Action_ForwardEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Link_Action_TurnEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case intelligentMobility.diagram.edit.parts.Link_LaneType_RegulationEditPart.VISUAL_ID: {
			LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/ result = new LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/();
			Edge sv = (Edge) view;
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup target = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Link_LaneType_Regulation_4001_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup source = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Link_LaneType_Regulation_4001_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection/*[org.eclipse.gmf.runtime.notation.View]*/ connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.RegulationEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Lane_TypeEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case intelligentMobility.diagram.edit.parts.Link_Driver_VehicleEditPart.VISUAL_ID: {
			LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/ result = new LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/();
			Edge sv = (Edge) view;
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup target = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Link_Driver_Vehicle_4002_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup source = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Link_Driver_Vehicle_4002_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection/*[org.eclipse.gmf.runtime.notation.View]*/ connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Vehicle_ConfigurationEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Driver_ProfileEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case intelligentMobility.diagram.edit.parts.Link_EnvironmentBackground_PossibleVehicleEditPart.VISUAL_ID: {
			LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/ result = new LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/();
			Edge sv = (Edge) view;
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup target = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Link_EnvironmentBackground_PossibleVehicle_4003_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup source = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Link_EnvironmentBackground_PossibleVehicle_4003_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection/*[org.eclipse.gmf.runtime.notation.View]*/ connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Environment_BackgroundEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.PossibleVehicleEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case intelligentMobility.diagram.edit.parts.Link_Vehicle_EnvironmentEditPart.VISUAL_ID: {
			LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/ result = new LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/();
			Edge sv = (Edge) view;
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup target = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Link_Vehicle_Environment_4004_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup source = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Link_Vehicle_Environment_4004_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection/*[org.eclipse.gmf.runtime.notation.View]*/ connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Environment_BackgroundEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Vehicle_ConfigurationEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case intelligentMobility.diagram.edit.parts.Link_NormalVehicle_SafetyRequirementsEditPart.VISUAL_ID: {
			LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/ result = new LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/();
			Edge sv = (Edge) view;
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup target = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Link_NormalVehicle_SafetyRequirements_4005_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup source = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Link_NormalVehicle_SafetyRequirements_4005_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection/*[org.eclipse.gmf.runtime.notation.View]*/ connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Safety_RequirementEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Leading_VehicleEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Following_VehicleEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Normal_VehicleEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case intelligentMobility.diagram.edit.parts.Link_DriverProfile_DriverPreferenceEditPart.VISUAL_ID: {
			LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/ result = new LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/();
			Edge sv = (Edge) view;
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup target = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Link_DriverProfile_DriverPreference_4006_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup source = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Link_DriverProfile_DriverPreference_4006_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection/*[org.eclipse.gmf.runtime.notation.View]*/ connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Driver_PreferenceEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Driver_ProfileEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case intelligentMobility.diagram.edit.parts.Link_Collision_ObstructionEditPart.VISUAL_ID: {
			LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/ result = new LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/();
			Edge sv = (Edge) view;
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup target = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Link_Collision_Obstruction_4007_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup source = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Link_Collision_Obstruction_4007_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection/*[org.eclipse.gmf.runtime.notation.View]*/ connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.CollisionEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.ObstructionEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case intelligentMobility.diagram.edit.parts.Link_Platoon_FollowingVehicleEditPart.VISUAL_ID: {
			LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/ result = new LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/();
			Edge sv = (Edge) view;
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup target = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Link_Platoon_FollowingVehicle_4008_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup source = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Link_Platoon_FollowingVehicle_4008_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection/*[org.eclipse.gmf.runtime.notation.View]*/ connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Following_VehicleEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.PlatoonEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Platoon2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case intelligentMobility.diagram.edit.parts.Link_DriverPreference_EnvironmentConditionEditPart.VISUAL_ID: {
			LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/ result = new LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/();
			Edge sv = (Edge) view;
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup target = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Link_DriverPreference_EnvironmentCondition_4009_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup source = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Link_DriverPreference_EnvironmentCondition_4009_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection/*[org.eclipse.gmf.runtime.notation.View]*/ connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Environment_ConditionEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Driver_PreferenceEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case intelligentMobility.diagram.edit.parts.Link_AbnormalBehaviour_ActionEditPart.VISUAL_ID: {
			LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/ result = new LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/();
			Edge sv = (Edge) view;
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup target = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Link_AbnormalBehaviour_Action_4010_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup source = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Link_AbnormalBehaviour_Action_4010_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection/*[org.eclipse.gmf.runtime.notation.View]*/ connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Abnormal_BehaviourEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.ForwardEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.TurnEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.BackwardEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Backward2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.ActionEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case intelligentMobility.diagram.edit.parts.Link_Following_ForwardEditPart.VISUAL_ID: {
			LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/ result = new LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/();
			Edge sv = (Edge) view;
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup target = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Link_Following_Forward_4011_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup source = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Link_Following_Forward_4011_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection/*[org.eclipse.gmf.runtime.notation.View]*/ connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.ForwardEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.FollowingEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_LaneTypeEditPart.VISUAL_ID: {
			LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/ result = new LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/();
			Edge sv = (Edge) view;
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup target = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Link_EnvironmentCondition_LaneType_4012_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup source = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Link_EnvironmentCondition_LaneType_4012_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection/*[org.eclipse.gmf.runtime.notation.View]*/ connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Environment_ConditionEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Lane_TypeEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case intelligentMobility.diagram.edit.parts.Link_VehicleConfiguration_VehicleTypeEditPart.VISUAL_ID: {
			LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/ result = new LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/();
			Edge sv = (Edge) view;
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup target = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Link_VehicleConfiguration_VehicleType_4013_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup source = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Link_VehicleConfiguration_VehicleType_4013_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection/*[org.eclipse.gmf.runtime.notation.View]*/ connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Vehicle_ConfigurationEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.PlatoonEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Leading_VehicleEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Following_VehicleEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Platoon2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Normal_VehicleEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case intelligentMobility.diagram.edit.parts.Link_Platoon_LeadingVehicleEditPart.VISUAL_ID: {
			LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/ result = new LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/();
			Edge sv = (Edge) view;
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup target = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Link_Platoon_LeadingVehicle_4014_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup source = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Link_Platoon_LeadingVehicle_4014_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection/*[org.eclipse.gmf.runtime.notation.View]*/ connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Leading_VehicleEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.PlatoonEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Platoon2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case intelligentMobility.diagram.edit.parts.Link_Driver_EnvironmentEditPart.VISUAL_ID: {
			LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/ result = new LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/();
			Edge sv = (Edge) view;
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup target = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Link_Driver_Environment_4015_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup source = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Link_Driver_Environment_4015_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection/*[org.eclipse.gmf.runtime.notation.View]*/ connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Environment_BackgroundEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Driver_ProfileEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case intelligentMobility.diagram.edit.parts.Link_LaneChanging_TurnEditPart.VISUAL_ID: {
			LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/ result = new LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/();
			Edge sv = (Edge) view;
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup target = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Link_LaneChanging_Turn_4016_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup source = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Link_LaneChanging_Turn_4016_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection/*[org.eclipse.gmf.runtime.notation.View]*/ connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.LaneChangingEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.TurnEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_TrafficConditionEditPart.VISUAL_ID: {
			LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/ result = new LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/();
			Edge sv = (Edge) view;
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup target = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Link_EnvironmentCondition_TrafficCondition_4017_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup source = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Link_EnvironmentCondition_TrafficCondition_4017_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection/*[org.eclipse.gmf.runtime.notation.View]*/ connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Environment_ConditionEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Traffic_SituationEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case intelligentMobility.diagram.edit.parts.Link_Intersection_TrafficLightEditPart.VISUAL_ID: {
			LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/ result = new LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/();
			Edge sv = (Edge) view;
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup target = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Link_Intersection_TrafficLight_4018_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup source = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Link_Intersection_TrafficLight_4018_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection/*[org.eclipse.gmf.runtime.notation.View]*/ connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Traffic_LightEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.IntersectionEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Intersection2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case intelligentMobility.diagram.edit.parts.Link_Following_MinGapEditPart.VISUAL_ID: {
			LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/ result = new LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/();
			Edge sv = (Edge) view;
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup target = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Link_Following_MinGap_4019_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup source = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Link_Following_MinGap_4019_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection/*[org.eclipse.gmf.runtime.notation.View]*/ connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.LaneChangingEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.FollowingEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case intelligentMobility.diagram.edit.parts.Link_NormalBehaviour_LaneChangingEditPart.VISUAL_ID: {
			LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/ result = new LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/();
			Edge sv = (Edge) view;
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup target = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Link_NormalBehaviour_LaneChanging_4020_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup source = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Link_NormalBehaviour_LaneChanging_4020_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection/*[org.eclipse.gmf.runtime.notation.View]*/ connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.LaneChangingEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Abnormal_BehaviourEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Normal_BehaviourEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case intelligentMobility.diagram.edit.parts.Link_SafetyRequirement_RegulationEditPart.VISUAL_ID: {
			LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/ result = new LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/();
			Edge sv = (Edge) view;
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup target = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Link_SafetyRequirement_Regulation_4021_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup source = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Link_SafetyRequirement_Regulation_4021_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection/*[org.eclipse.gmf.runtime.notation.View]*/ connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.RegulationEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Safety_RequirementEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case intelligentMobility.diagram.edit.parts.Link_DriverPreference_DrivingBehaviourEditPart.VISUAL_ID: {
			LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/ result = new LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/();
			Edge sv = (Edge) view;
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup target = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Link_DriverPreference_DrivingBehaviour_4022_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup source = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Link_DriverPreference_DrivingBehaviour_4022_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection/*[org.eclipse.gmf.runtime.notation.View]*/ connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Driver_PreferenceEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Driving_BehaviourEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.CooperativeBehaviorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case intelligentMobility.diagram.edit.parts.Link_FollowingVehicle_FrontVehicleEditPart.VISUAL_ID: {
			LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/ result = new LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/();
			Edge sv = (Edge) view;
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup target = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Link_FollowingVehicle_FrontVehicle_4023_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup source = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Link_FollowingVehicle_FrontVehicle_4023_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection/*[org.eclipse.gmf.runtime.notation.View]*/ connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Following_VehicleEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Leading_VehicleEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Following_VehicleEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case intelligentMobility.diagram.edit.parts.Link_DriverPreference_DriverEmotionEditPart.VISUAL_ID: {
			LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/ result = new LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/();
			Edge sv = (Edge) view;
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup target = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Link_DriverPreference_DriverEmotion_4024_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup source = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Link_DriverPreference_DriverEmotion_4024_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection/*[org.eclipse.gmf.runtime.notation.View]*/ connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Driver_EmotionEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Driver_PreferenceEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case intelligentMobility.diagram.edit.parts.Link_EnvironmentBackground_EnvironmentConditionEditPart.VISUAL_ID: {
			LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/ result = new LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/();
			Edge sv = (Edge) view;
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup target = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Link_EnvironmentBackground_EnvironmentCondition_4025_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup source = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Link_EnvironmentBackground_EnvironmentCondition_4025_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection/*[org.eclipse.gmf.runtime.notation.View]*/ connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Environment_ConditionEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Environment_BackgroundEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_WeatherEditPart.VISUAL_ID: {
			LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/ result = new LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/();
			Edge sv = (Edge) view;
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup target = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Link_EnvironmentCondition_Weather_4026_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup source = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Link_EnvironmentCondition_Weather_4026_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection/*[org.eclipse.gmf.runtime.notation.View]*/ connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.WeatherEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Environment_ConditionEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_SpecialConditionEditPart.VISUAL_ID: {
			LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/ result = new LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/();
			Edge sv = (Edge) view;
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup target = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Link_EnvironmentCondition_SpecialCondition_4027_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup source = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Link_EnvironmentCondition_SpecialCondition_4027_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection/*[org.eclipse.gmf.runtime.notation.View]*/ connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Special_ConditionEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Environment_ConditionEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case intelligentMobility.diagram.edit.parts.Link_SpecialCondition_IntersectionEditPart.VISUAL_ID: {
			LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/ result = new LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/();
			Edge sv = (Edge) view;
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup target = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Link_SpecialCondition_Intersection_4028_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup source = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Link_SpecialCondition_Intersection_4028_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection/*[org.eclipse.gmf.runtime.notation.View]*/ connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Special_ConditionEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.IntersectionEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Intersection2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case intelligentMobility.diagram.edit.parts.Link_Following_BackwardEditPart.VISUAL_ID: {
			LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/ result = new LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/();
			Edge sv = (Edge) view;
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup target = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Link_Following_Backward_4029_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup source = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Link_Following_Backward_4029_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection/*[org.eclipse.gmf.runtime.notation.View]*/ connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.FollowingEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.BackwardEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Backward2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_RegulationsEditPart.VISUAL_ID: {
			LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/ result = new LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/();
			Edge sv = (Edge) view;
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup target = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Link_EnvironmentCondition_Regulations_4030_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup source = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Link_EnvironmentCondition_Regulations_4030_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection/*[org.eclipse.gmf.runtime.notation.View]*/ connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.RegulationEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Environment_ConditionEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case intelligentMobility.diagram.edit.parts.Link_DrivingBehaviour_NormalBehaviourEditPart.VISUAL_ID: {
			LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/ result = new LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/();
			Edge sv = (Edge) view;
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup target = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Link_DrivingBehaviour_NormalBehaviour_4031_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup source = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Link_DrivingBehaviour_NormalBehaviour_4031_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection/*[org.eclipse.gmf.runtime.notation.View]*/ connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Abnormal_BehaviourEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Normal_BehaviourEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Driving_BehaviourEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.CooperativeBehaviorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case intelligentMobility.diagram.edit.parts.Link_LaneChanging_EnvironmentConditionEditPart.VISUAL_ID: {
			LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/ result = new LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/();
			Edge sv = (Edge) view;
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup target = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Link_LaneChanging_EnvironmentCondition_4032_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup source = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Link_LaneChanging_EnvironmentCondition_4032_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection/*[org.eclipse.gmf.runtime.notation.View]*/ connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Environment_ConditionEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.LaneChangingEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case intelligentMobility.diagram.edit.parts.Link_LaneChanging_GapAcceptanceEditPart.VISUAL_ID: {
			LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/ result = new LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/();
			Edge sv = (Edge) view;
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup target = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Link_LaneChanging_GapAcceptance_4033_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup source = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Link_LaneChanging_GapAcceptance_4033_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection/*[org.eclipse.gmf.runtime.notation.View]*/ connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.GapAcceptanceEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.LaneChangingEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case intelligentMobility.diagram.edit.parts.Link_NormalBehaviour_FollowingEditPart.VISUAL_ID: {
			LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/ result = new LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/();
			Edge sv = (Edge) view;
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup target = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Link_NormalBehaviour_Following_4034_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup source = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Link_NormalBehaviour_Following_4034_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection/*[org.eclipse.gmf.runtime.notation.View]*/ connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.FollowingEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Abnormal_BehaviourEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Normal_BehaviourEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case intelligentMobility.diagram.edit.parts.Link_Infrastructure_VehicleConfigurationEditPart.VISUAL_ID: {
			LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/ result = new LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/();
			Edge sv = (Edge) view;
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup target = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Link_Infrastructure_VehicleConfiguration_4035_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup source = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Link_Infrastructure_VehicleConfiguration_4035_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection/*[org.eclipse.gmf.runtime.notation.View]*/ connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Traffic_LightEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.IntersectionEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Intersection2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Vehicle_ConfigurationEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case intelligentMobility.diagram.edit.parts.Link_CommunicationInterface_VehicleConfigurationEditPart.VISUAL_ID: {
			LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/ result = new LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/();
			Edge sv = (Edge) view;
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup target = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Link_CommunicationInterface_VehicleConfiguration_4036_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup source = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Link_CommunicationInterface_VehicleConfiguration_4036_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection/*[org.eclipse.gmf.runtime.notation.View]*/ connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Vehicle_ConfigurationEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.CommunicationInterfaceEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case intelligentMobility.diagram.edit.parts.Link_Goal_DrivingBehaviourEditPart.VISUAL_ID: {
			LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/ result = new LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/();
			Edge sv = (Edge) view;
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup target = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Link_Goal_DrivingBehaviour_4037_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup source = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Link_Goal_DrivingBehaviour_4037_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection/*[org.eclipse.gmf.runtime.notation.View]*/ connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.GoalEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Driving_BehaviourEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.CooperativeBehaviorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case intelligentMobility.diagram.edit.parts.Link_CooperativeBehaviour_CommunicationInterfaceEditPart.VISUAL_ID: {
			LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/ result = new LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/();
			Edge sv = (Edge) view;
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup target = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Link_CooperativeBehaviour_CommunicationInterface_4038_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup source = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Link_CooperativeBehaviour_CommunicationInterface_4038_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection/*[org.eclipse.gmf.runtime.notation.View]*/ connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.CommunicationInterfaceEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.CooperativeBehaviorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case intelligentMobility.diagram.edit.parts.Link_CommunicationInterface_InfrastructureEditPart.VISUAL_ID: {
			LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/ result = new LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/();
			Edge sv = (Edge) view;
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup target = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Link_CommunicationInterface_Infrastructure_4039_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup source = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Link_CommunicationInterface_Infrastructure_4039_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection/*[org.eclipse.gmf.runtime.notation.View]*/ connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Traffic_LightEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.IntersectionEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Intersection2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.CommunicationInterfaceEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case intelligentMobility.diagram.edit.parts.Link_CooperativeBehaviour_VehicleConfigurationEditPart.VISUAL_ID: {
			LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/ result = new LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/();
			Edge sv = (Edge) view;
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup target = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Link_CooperativeBehaviour_VehicleConfiguration_4040_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup source = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Link_CooperativeBehaviour_VehicleConfiguration_4040_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection/*[org.eclipse.gmf.runtime.notation.View]*/ connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Vehicle_ConfigurationEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.CooperativeBehaviorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case intelligentMobility.diagram.edit.parts.Link_TrafficSituation_EnvironmentConditionEditPart.VISUAL_ID: {
			LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/ result = new LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/();
			Edge sv = (Edge) view;
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup target = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Link_TrafficSituation_EnvironmentCondition_4041_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup source = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Link_TrafficSituation_EnvironmentCondition_4041_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection/*[org.eclipse.gmf.runtime.notation.View]*/ connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Traffic_SituationEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Environment_ConditionEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case intelligentMobility.diagram.edit.parts.Link_Collision_SpecialConditionEditPart.VISUAL_ID: {
			LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/ result = new LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/();
			Edge sv = (Edge) view;
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup target = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Link_Collision_SpecialCondition_4042_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup source = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Link_Collision_SpecialCondition_4042_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection/*[org.eclipse.gmf.runtime.notation.View]*/ connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Special_ConditionEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.CollisionEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case intelligentMobility.diagram.edit.parts.Link_Following_LaneChangingEditPart.VISUAL_ID: {
			LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/ result = new LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/();
			Edge sv = (Edge) view;
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup target = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Link_Following_LaneChanging_4043_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup source = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Link_Following_LaneChanging_4043_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection/*[org.eclipse.gmf.runtime.notation.View]*/ connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.LaneChangingEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.FollowingEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case intelligentMobility.diagram.edit.parts.Link_Action_BackwardEditPart.VISUAL_ID: {
			LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/ result = new LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/();
			Edge sv = (Edge) view;
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup target = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Link_Action_Backward_4044_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup source = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Link_Action_Backward_4044_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection/*[org.eclipse.gmf.runtime.notation.View]*/ connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.BackwardEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Backward2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.ForwardEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.TurnEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.BackwardEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Backward2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.ActionEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case intelligentMobility.diagram.edit.parts.Link_Action_ForwardEditPart.VISUAL_ID: {
			LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/ result = new LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/();
			Edge sv = (Edge) view;
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup target = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Link_Action_Forward_4045_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup source = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Link_Action_Forward_4045_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection/*[org.eclipse.gmf.runtime.notation.View]*/ connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.ForwardEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.ForwardEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.TurnEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.BackwardEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Backward2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.ActionEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case intelligentMobility.diagram.edit.parts.Link_Action_TurnEditPart.VISUAL_ID: {
			LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/ result = new LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/();
			Edge sv = (Edge) view;
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup target = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Link_Action_Turn_4046_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup source = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Link_Action_Turn_4046_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection/*[org.eclipse.gmf.runtime.notation.View]*/ connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.TurnEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.ForwardEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.TurnEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.BackwardEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Backward2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.ActionEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case intelligentMobility.diagram.edit.parts.Link_KnowledgeAndSkill_DriverPreferenceEditPart.VISUAL_ID: {
			LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/ result = new LinkedList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem]*/();
			Edge sv = (Edge) view;
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup target = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Link_KnowledgeAndSkill_DriverPreference_4047_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup source = new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorGroup(
					intelligentMobility.diagram.part.Messages.NavigatorGroupName_Link_KnowledgeAndSkill_DriverPreference_4047_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection/*[org.eclipse.gmf.runtime.notation.View]*/ connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Knowledge_and_SkillEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(intelligentMobility.diagram.edit.parts.Driver_PreferenceEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}
		}
		return EMPTY_ARRAY;
	}

	/**
	* @generated
	*/
	private Collection/*[org.eclipse.gmf.runtime.notation.View]*/ getLinksSourceByType(
			Collection/*[org.eclipse.gmf.runtime.notation.Edge]*/ edges, String type) {
		LinkedList/*[org.eclipse.gmf.runtime.notation.View]*/ result = new LinkedList/*[org.eclipse.gmf.runtime.notation.View]*/();
		for (Iterator /*[org.eclipse.gmf.runtime.notation.Edge]*/ it = edges.iterator(); it.hasNext();) {
			Edge nextEdge = (Edge) it.next();
			View nextEdgeSource = nextEdge.getSource();
			if (type.equals(nextEdgeSource.getType()) && isOwnView(nextEdgeSource)) {
				result.add(nextEdgeSource);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection/*[org.eclipse.gmf.runtime.notation.View]*/ getLinksTargetByType(
			Collection/*[org.eclipse.gmf.runtime.notation.Edge]*/ edges, String type) {
		LinkedList/*[org.eclipse.gmf.runtime.notation.View]*/ result = new LinkedList/*[org.eclipse.gmf.runtime.notation.View]*/();
		for (Iterator /*[org.eclipse.gmf.runtime.notation.Edge]*/ it = edges.iterator(); it.hasNext();) {
			Edge nextEdge = (Edge) it.next();
			View nextEdgeTarget = nextEdge.getTarget();
			if (type.equals(nextEdgeTarget.getType()) && isOwnView(nextEdgeTarget)) {
				result.add(nextEdgeTarget);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection/*[org.eclipse.gmf.runtime.notation.View]*/ getOutgoingLinksByType(
			Collection/*[? extends org.eclipse.gmf.runtime.notation.View]*/ nodes, String type) {
		LinkedList/*[org.eclipse.gmf.runtime.notation.View]*/ result = new LinkedList/*[org.eclipse.gmf.runtime.notation.View]*/();
		for (Iterator /*[org.eclipse.gmf.runtime.notation.View]*/ it = nodes.iterator(); it.hasNext();) {
			View nextNode = (View) it.next();
			result.addAll(selectViewsByType(nextNode.getSourceEdges(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection/*[org.eclipse.gmf.runtime.notation.View]*/ getIncomingLinksByType(
			Collection/*[? extends org.eclipse.gmf.runtime.notation.View]*/ nodes, String type) {
		LinkedList/*[org.eclipse.gmf.runtime.notation.View]*/ result = new LinkedList/*[org.eclipse.gmf.runtime.notation.View]*/();
		for (Iterator /*[org.eclipse.gmf.runtime.notation.View]*/ it = nodes.iterator(); it.hasNext();) {
			View nextNode = (View) it.next();
			result.addAll(selectViewsByType(nextNode.getTargetEdges(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection/*[org.eclipse.gmf.runtime.notation.View]*/ getChildrenByType(
			Collection/*[? extends org.eclipse.gmf.runtime.notation.View]*/ nodes, String type) {
		LinkedList/*[org.eclipse.gmf.runtime.notation.View]*/ result = new LinkedList/*[org.eclipse.gmf.runtime.notation.View]*/();
		for (Iterator /*[org.eclipse.gmf.runtime.notation.View]*/ it = nodes.iterator(); it.hasNext();) {
			View nextNode = (View) it.next();
			result.addAll(selectViewsByType(nextNode.getChildren(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection/*[org.eclipse.gmf.runtime.notation.View]*/ getDiagramLinksByType(
			Collection/*[org.eclipse.gmf.runtime.notation.Diagram]*/ diagrams, String type) {
		ArrayList/*[org.eclipse.gmf.runtime.notation.View]*/ result = new ArrayList/*[org.eclipse.gmf.runtime.notation.View]*/();
		for (Iterator /*[org.eclipse.gmf.runtime.notation.Diagram]*/ it = diagrams.iterator(); it.hasNext();) {
			Diagram nextDiagram = (Diagram) it.next();
			result.addAll(selectViewsByType(nextDiagram.getEdges(), type));
		}
		return result;
	}

	// TODO refactor as static method
	/**
	 * @generated
	 */
	private Collection/*[org.eclipse.gmf.runtime.notation.View]*/ selectViewsByType(
			Collection/*[org.eclipse.gmf.runtime.notation.View]*/ views, String type) {
		ArrayList/*[org.eclipse.gmf.runtime.notation.View]*/ result = new ArrayList/*[org.eclipse.gmf.runtime.notation.View]*/();
		for (Iterator /*[org.eclipse.gmf.runtime.notation.View]*/ it = views.iterator(); it.hasNext();) {
			View nextView = (View) it.next();
			if (type.equals(nextView.getType()) && isOwnView(nextView)) {
				result.add(nextView);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isOwnView(View view) {
		return intelligentMobility.diagram.edit.parts.MobilitySystemEditPart.MODEL_ID
				.equals(intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getModelID(view));
	}

	/**
	 * @generated
	 */
	private Collection/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorItem]*/ createNavigatorItems(
			Collection/*[org.eclipse.gmf.runtime.notation.View]*/ views, Object parent, boolean isLeafs) {
		ArrayList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorItem]*/ result = new ArrayList/*[intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorItem]*/(
				views.size());
		for (Iterator /*[org.eclipse.gmf.runtime.notation.View]*/ it = views.iterator(); it.hasNext();) {
			View nextView = (View) it.next();
			result.add(new intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelNavigatorItem(nextView,
					parent, isLeafs));
		}
		return result;
	}

	/**
	* @generated
	*/
	public Object getParent(Object element) {
		if (element instanceof intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem) {
			intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem abstractNavigatorItem = (intelligentMobility.diagram.navigator.DrivingBehaviourMetamodelAbstractNavigatorItem) element;
			return abstractNavigatorItem.getParent();
		}
		return null;
	}

	/**
	* @generated
	*/
	public boolean hasChildren(Object element) {
		return element instanceof IFile || getChildren(element).length > 0;
	}

}
