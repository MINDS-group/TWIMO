package intelligentMobility.diagram.edit.policies;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.DeferredLayoutCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetViewMutabilityCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.Size;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.update.UpdaterLinkDescriptor;

/**
 * @generated
 */
public class MobilitySystemCanonicalEditPolicy extends CanonicalEditPolicy {

	/**
	* @generated
	*/
	private Set/*[org.eclipse.emf.ecore.EStructuralFeature]*/ myFeaturesToSynchronize;

	/**
	* @generated
	*/
	protected void refreshOnActivate() {
		// Need to activate editpart children before invoking the canonical refresh for EditParts to add event listeners
		List/*[?]*/ c = getHost().getChildren();
		for (int i = 0; i < c.size(); i++) {
			((EditPart) c.get(i)).activate();
		}
		super.refreshOnActivate();
	}

	/**
	* @generated
	*/
	protected Set getFeaturesToSynchronize() {
		if (myFeaturesToSynchronize == null) {
			myFeaturesToSynchronize = new HashSet/*[org.eclipse.emf.ecore.EStructuralFeature]*/();
			myFeaturesToSynchronize.add(
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Special_condition());
			myFeaturesToSynchronize
					.add(intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Weather());
			myFeaturesToSynchronize
					.add(intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Traffic_light());
			myFeaturesToSynchronize.add(
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Knowledge_and_skill());
			myFeaturesToSynchronize
					.add(intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Obstruction());
			myFeaturesToSynchronize.add(
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Driver_preference());
			myFeaturesToSynchronize
					.add(intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Intersection());
			myFeaturesToSynchronize.add(
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Vehicle_configuration());
			myFeaturesToSynchronize.add(
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Environment_condition());
			myFeaturesToSynchronize
					.add(intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Platoon());
			myFeaturesToSynchronize
					.add(intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Forward());
			myFeaturesToSynchronize
					.add(intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Lane_type());
			myFeaturesToSynchronize.add(intelligentMobility.IntelligentMobilityPackage.eINSTANCE
					.getMobilitySystem_Environment_background());
			myFeaturesToSynchronize
					.add(intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Turn());
			myFeaturesToSynchronize
					.add(intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Lane_changing());
			myFeaturesToSynchronize
					.add(intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Driver_emotion());
			myFeaturesToSynchronize
					.add(intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Collision());
			myFeaturesToSynchronize
					.add(intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Possible_vehicle());
			myFeaturesToSynchronize
					.add(intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Following());
			myFeaturesToSynchronize
					.add(intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Gap_acceptance());
			myFeaturesToSynchronize
					.add(intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Leading_vehicle());
			myFeaturesToSynchronize
					.add(intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Backward());
			myFeaturesToSynchronize
					.add(intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Regulation());
			myFeaturesToSynchronize.add(
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Traffic_situation());
			myFeaturesToSynchronize
					.add(intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Driver_profile());
			myFeaturesToSynchronize.add(
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Safety_requirement());
			myFeaturesToSynchronize.add(
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Driving_behaviour());
			myFeaturesToSynchronize.add(
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Following_vehicle());
			myFeaturesToSynchronize.add(
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Abnormal_behaviour());
			myFeaturesToSynchronize
					.add(intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Action());
			myFeaturesToSynchronize
					.add(intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Infrastructure());
			myFeaturesToSynchronize.add(intelligentMobility.IntelligentMobilityPackage.eINSTANCE
					.getMobilitySystem_CommunicationInterfaces());
			myFeaturesToSynchronize
					.add(intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Goal());
			myFeaturesToSynchronize
					.add(intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Normal_behaviour());
			myFeaturesToSynchronize
					.add(intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Vehicle_type());
			myFeaturesToSynchronize
					.add(intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_Normal_vehicle());
			myFeaturesToSynchronize.add(
					intelligentMobility.IntelligentMobilityPackage.eINSTANCE.getMobilitySystem_CooperativeBehaviour());
		}
		return myFeaturesToSynchronize;
	}

	/**
	* @generated
	*/

	protected List getSemanticChildrenList() {
		View viewObject = (View) getHost().getModel();
		LinkedList/*[org.eclipse.emf.ecore.EObject]*/ result = new LinkedList/*[org.eclipse.emf.ecore.EObject]*/();
		List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelNodeDescriptor]*/ childDescriptors = intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramUpdater
				.getMobilitySystem_1000SemanticChildren(viewObject);
		for (Iterator /*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelNodeDescriptor]*/ it = childDescriptors
				.iterator(); it.hasNext();) {
			intelligentMobility.diagram.part.DrivingBehaviourMetamodelNodeDescriptor d = (intelligentMobility.diagram.part.DrivingBehaviourMetamodelNodeDescriptor) it
					.next();
			result.add(d.getModelElement());
		}
		return result;
	}

	/**
	* @generated
	*/
	protected boolean isOrphaned(Collection/*[org.eclipse.emf.ecore.EObject]*/ semanticChildren, final View view) {
		return isMyDiagramElement(view) && !semanticChildren.contains(view.getElement());
	}

	/**
	* @generated
	*/
	private boolean isMyDiagramElement(View view) {
		int visualID = intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getVisualID(view);
		switch (visualID) {
		case intelligentMobility.diagram.edit.parts.Special_ConditionEditPart.VISUAL_ID:
		case intelligentMobility.diagram.edit.parts.WeatherEditPart.VISUAL_ID:
		case intelligentMobility.diagram.edit.parts.Traffic_LightEditPart.VISUAL_ID:
		case intelligentMobility.diagram.edit.parts.Knowledge_and_SkillEditPart.VISUAL_ID:
		case intelligentMobility.diagram.edit.parts.ObstructionEditPart.VISUAL_ID:
		case intelligentMobility.diagram.edit.parts.Driver_PreferenceEditPart.VISUAL_ID:
		case intelligentMobility.diagram.edit.parts.IntersectionEditPart.VISUAL_ID:
		case intelligentMobility.diagram.edit.parts.Vehicle_ConfigurationEditPart.VISUAL_ID:
		case intelligentMobility.diagram.edit.parts.Environment_ConditionEditPart.VISUAL_ID:
		case intelligentMobility.diagram.edit.parts.PlatoonEditPart.VISUAL_ID:
		case intelligentMobility.diagram.edit.parts.ForwardEditPart.VISUAL_ID:
		case intelligentMobility.diagram.edit.parts.Lane_TypeEditPart.VISUAL_ID:
		case intelligentMobility.diagram.edit.parts.Environment_BackgroundEditPart.VISUAL_ID:
		case intelligentMobility.diagram.edit.parts.TurnEditPart.VISUAL_ID:
		case intelligentMobility.diagram.edit.parts.LaneChangingEditPart.VISUAL_ID:
		case intelligentMobility.diagram.edit.parts.Driver_EmotionEditPart.VISUAL_ID:
		case intelligentMobility.diagram.edit.parts.CollisionEditPart.VISUAL_ID:
		case intelligentMobility.diagram.edit.parts.PossibleVehicleEditPart.VISUAL_ID:
		case intelligentMobility.diagram.edit.parts.FollowingEditPart.VISUAL_ID:
		case intelligentMobility.diagram.edit.parts.GapAcceptanceEditPart.VISUAL_ID:
		case intelligentMobility.diagram.edit.parts.Leading_VehicleEditPart.VISUAL_ID:
		case intelligentMobility.diagram.edit.parts.BackwardEditPart.VISUAL_ID:
		case intelligentMobility.diagram.edit.parts.RegulationEditPart.VISUAL_ID:
		case intelligentMobility.diagram.edit.parts.Traffic_SituationEditPart.VISUAL_ID:
		case intelligentMobility.diagram.edit.parts.Driver_ProfileEditPart.VISUAL_ID:
		case intelligentMobility.diagram.edit.parts.Safety_RequirementEditPart.VISUAL_ID:
		case intelligentMobility.diagram.edit.parts.Driving_BehaviourEditPart.VISUAL_ID:
		case intelligentMobility.diagram.edit.parts.Following_VehicleEditPart.VISUAL_ID:
		case intelligentMobility.diagram.edit.parts.Abnormal_BehaviourEditPart.VISUAL_ID:
		case intelligentMobility.diagram.edit.parts.Backward2EditPart.VISUAL_ID:
		case intelligentMobility.diagram.edit.parts.Intersection2EditPart.VISUAL_ID:
		case intelligentMobility.diagram.edit.parts.CommunicationInterfaceEditPart.VISUAL_ID:
		case intelligentMobility.diagram.edit.parts.GoalEditPart.VISUAL_ID:
		case intelligentMobility.diagram.edit.parts.Normal_BehaviourEditPart.VISUAL_ID:
		case intelligentMobility.diagram.edit.parts.Platoon2EditPart.VISUAL_ID:
		case intelligentMobility.diagram.edit.parts.Normal_VehicleEditPart.VISUAL_ID:
		case intelligentMobility.diagram.edit.parts.CooperativeBehaviorEditPart.VISUAL_ID:
		case intelligentMobility.diagram.edit.parts.ActionEditPart.VISUAL_ID:
			return true;
		}
		return false;
	}

	/**
	* @generated
	*/
	protected void refreshSemantic() {
		if (resolveSemanticElement() == null) {
			return;
		}
		LinkedList/*[org.eclipse.core.runtime.IAdaptable]*/ createdViews = new LinkedList/*[org.eclipse.core.runtime.IAdaptable]*/();
		List/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelNodeDescriptor]*/ childDescriptors = intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramUpdater
				.getMobilitySystem_1000SemanticChildren((View) getHost().getModel());
		LinkedList/*[org.eclipse.gmf.runtime.notation.View]*/ orphaned = new LinkedList/*[org.eclipse.gmf.runtime.notation.View]*/();
		// we care to check only views we recognize as ours
		LinkedList/*[org.eclipse.gmf.runtime.notation.View]*/ knownViewChildren = new LinkedList/*[org.eclipse.gmf.runtime.notation.View]*/();
		for (Iterator /*[org.eclipse.gmf.runtime.notation.View]*/ it = getViewChildren().iterator(); it.hasNext();) {
			View v = (View) it.next();
			if (isMyDiagramElement(v)) {
				knownViewChildren.add(v);
			}
		}
		// alternative to #cleanCanonicalSemanticChildren(getViewChildren(), semanticChildren)
		HashMap/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelNodeDescriptor, java.util.LinkedList[org.eclipse.gmf.runtime.notation.View]]*/ potentialViews = new HashMap/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelNodeDescriptor, java.util.LinkedList[org.eclipse.gmf.runtime.notation.View]]*/();
		//
		// iteration happens over list of desired semantic elements, trying to find best matching View, while original CEP
		// iterates views, potentially losing view (size/bounds) information - i.e. if there are few views to reference same EObject, only last one 
		// to answer isOrphaned == true will be used for the domain element representation, see #cleanCanonicalSemanticChildren()
		for (Iterator /*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelNodeDescriptor]*/ descriptorsIterator = childDescriptors
				.iterator(); descriptorsIterator.hasNext();) {
			intelligentMobility.diagram.part.DrivingBehaviourMetamodelNodeDescriptor next = (intelligentMobility.diagram.part.DrivingBehaviourMetamodelNodeDescriptor) descriptorsIterator
					.next();
			String hint = intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getType(next.getVisualID());
			LinkedList/*[org.eclipse.gmf.runtime.notation.View]*/ perfectMatch = new LinkedList/*[org.eclipse.gmf.runtime.notation.View]*/(); // both semanticElement and hint match that of NodeDescriptor
			LinkedList/*[org.eclipse.gmf.runtime.notation.View]*/ potentialMatch = new LinkedList/*[org.eclipse.gmf.runtime.notation.View]*/(); // semanticElement matches, hint does not
			for (Iterator /*[org.eclipse.gmf.runtime.notation.View]*/ it = getViewChildren().iterator(); it
					.hasNext();) {
				View childView = (View) it.next();
				EObject semanticElement = childView.getElement();
				if (next.getModelElement().equals(semanticElement)) {
					if (hint.equals(childView.getType())) {
						perfectMatch.add(childView);
						// actually, can stop iteration over view children here, but
						// may want to use not the first view but last one as a 'real' match (the way original CEP does
						// with its trick with viewToSemanticMap inside #cleanCanonicalSemanticChildren
					} else {
						potentialMatch.add(childView);
					}
				}
			}
			if (perfectMatch.size() > 0) {
				descriptorsIterator.remove(); // precise match found no need to create anything for the NodeDescriptor
				// use only one view (first or last?), keep rest as orphaned for further consideration
				knownViewChildren.remove(perfectMatch.getFirst());
			} else if (potentialMatch.size() > 0) {
				potentialViews.put(next, potentialMatch);
			}
		}
		// those left in knownViewChildren are subject to removal - they are our diagram elements we didn't find match to,
		// or those we have potential matches to, and thus need to be recreated, preserving size/location information.
		orphaned.addAll(knownViewChildren);
		//
		CompositeTransactionalCommand boundsCommand = new CompositeTransactionalCommand(host().getEditingDomain(),
				DiagramUIMessages.SetLocationCommand_Label_Resize);
		ArrayList/*[org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor]*/ viewDescriptors = new ArrayList/*[org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor]*/(
				childDescriptors.size());
		for (Iterator /*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelNodeDescriptor]*/ it = childDescriptors
				.iterator(); it.hasNext();) {
			intelligentMobility.diagram.part.DrivingBehaviourMetamodelNodeDescriptor next = (intelligentMobility.diagram.part.DrivingBehaviourMetamodelNodeDescriptor) it
					.next();
			String hint = intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getType(next.getVisualID());
			IAdaptable elementAdapter = new CanonicalElementAdapter(next.getModelElement(), hint);
			CreateViewRequest.ViewDescriptor descriptor = new CreateViewRequest.ViewDescriptor(elementAdapter,
					Node.class, hint, ViewUtil.APPEND, false, host().getDiagramPreferencesHint());
			viewDescriptors.add(descriptor);

			LinkedList/*[org.eclipse.gmf.runtime.notation.View]*/ possibleMatches = (LinkedList) potentialViews
					.get(next);
			if (possibleMatches != null) {
				// from potential matches, leave those that were not eventually used for some other NodeDescriptor (i.e. those left as orphaned)
				possibleMatches.retainAll(knownViewChildren);
			}
			if (possibleMatches != null && !possibleMatches.isEmpty()) {
				View originalView = (View) possibleMatches.getFirst();
				knownViewChildren.remove(originalView); // remove not to copy properties of the same view again and again
				// add command to copy properties
				if (originalView instanceof Node) {
					if (((Node) originalView).getLayoutConstraint() instanceof Bounds) {
						Bounds b = (Bounds) ((Node) originalView).getLayoutConstraint();
						boundsCommand
								.add(new SetBoundsCommand(boundsCommand.getEditingDomain(), boundsCommand.getLabel(),
										descriptor, new Rectangle(b.getX(), b.getY(), b.getWidth(), b.getHeight())));
					} else if (((Node) originalView).getLayoutConstraint() instanceof Location) {
						Location l = (Location) ((Node) originalView).getLayoutConstraint();
						boundsCommand.add(new SetBoundsCommand(boundsCommand.getEditingDomain(),
								boundsCommand.getLabel(), descriptor, new Point(l.getX(), l.getY())));
					} else if (((Node) originalView).getLayoutConstraint() instanceof Size) {
						Size s = (Size) ((Node) originalView).getLayoutConstraint();
						boundsCommand.add(new SetBoundsCommand(boundsCommand.getEditingDomain(),
								boundsCommand.getLabel(), descriptor, new Dimension(s.getWidth(), s.getHeight())));
					}
				}
			}
		}

		boolean changed = deleteViews(orphaned.iterator());
		//
		CreateViewRequest request = getCreateViewRequest(viewDescriptors);
		Command cmd = getCreateViewCommand(request);
		if (cmd != null && cmd.canExecute()) {
			SetViewMutabilityCommand.makeMutable(new EObjectAdapter(host().getNotationView())).execute();
			executeCommand(cmd);
			if (boundsCommand.canExecute()) {
				executeCommand(new ICommandProxy(boundsCommand.reduce()));
			}

			List/*[org.eclipse.core.runtime.IAdaptable]*/ nl = (List/*[org.eclipse.core.runtime.IAdaptable]*/) request
					.getNewObject();
			createdViews.addAll(nl);
		}
		if (changed || createdViews.size() > 0) {
			postProcessRefreshSemantic(createdViews);
		}

		Collection/*[org.eclipse.core.runtime.IAdaptable]*/ createdConnectionViews = refreshConnections();

		if (createdViews.size() > 1) {
			// perform a layout of the container
			DeferredLayoutCommand layoutCmd = new DeferredLayoutCommand(host().getEditingDomain(), createdViews,
					host());
			executeCommand(new ICommandProxy(layoutCmd));
		}

		createdViews.addAll(createdConnectionViews);

		makeViewsImmutable(createdViews);
	}

	/**
	* @generated
	*/
	private Collection/*[org.eclipse.core.runtime.IAdaptable]*/ refreshConnections() {
		Domain2Notation domain2NotationMap = new Domain2Notation();
		Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ linkDescriptors = collectAllLinks(
				getDiagram(), domain2NotationMap);
		Collection existingLinks = new LinkedList(getDiagram().getEdges());
		for (Iterator linksIterator = existingLinks.iterator(); linksIterator.hasNext();) {
			Edge nextDiagramLink = (Edge) linksIterator.next();
			int diagramLinkVisualID = intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
					.getVisualID(nextDiagramLink);
			if (diagramLinkVisualID == -1) {
				if (nextDiagramLink.getSource() != null && nextDiagramLink.getTarget() != null) {
					linksIterator.remove();
				}
				continue;
			}
			EObject diagramLinkObject = nextDiagramLink.getElement();
			EObject diagramLinkSrc = nextDiagramLink.getSource().getElement();
			EObject diagramLinkDst = nextDiagramLink.getTarget().getElement();
			for (Iterator /*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ linkDescriptorsIterator = linkDescriptors
					.iterator(); linkDescriptorsIterator.hasNext();) {
				intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor nextLinkDescriptor = (intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor) linkDescriptorsIterator
						.next();
				if (diagramLinkObject == nextLinkDescriptor.getModelElement()
						&& diagramLinkSrc == nextLinkDescriptor.getSource()
						&& diagramLinkDst == nextLinkDescriptor.getDestination()
						&& diagramLinkVisualID == nextLinkDescriptor.getVisualID()) {
					linksIterator.remove();
					linkDescriptorsIterator.remove();
					break;
				}
			}
		}
		deleteViews(existingLinks.iterator());
		return createConnections(linkDescriptors, domain2NotationMap);
	}

	/**
	* @generated
	*/
	private Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ collectAllLinks(
			View view, Domain2Notation domain2NotationMap) {
		if (!intelligentMobility.diagram.edit.parts.MobilitySystemEditPart.MODEL_ID
				.equals(intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getModelID(view))) {
			return Collections.EMPTY_LIST;
		}
		LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ result = new LinkedList/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/();
		switch (intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getVisualID(view)) {
		case intelligentMobility.diagram.edit.parts.MobilitySystemEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramUpdater
						.getMobilitySystem_1000ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case intelligentMobility.diagram.edit.parts.Special_ConditionEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramUpdater
						.getSpecial_Condition_2001ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case intelligentMobility.diagram.edit.parts.WeatherEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramUpdater
						.getWeather_2002ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case intelligentMobility.diagram.edit.parts.Traffic_LightEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramUpdater
						.getTraffic_Light_2003ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case intelligentMobility.diagram.edit.parts.Knowledge_and_SkillEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramUpdater
						.getKnowledge_and_Skill_2004ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case intelligentMobility.diagram.edit.parts.ObstructionEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramUpdater
						.getObstruction_2005ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case intelligentMobility.diagram.edit.parts.Driver_PreferenceEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramUpdater
						.getDriver_Preference_2006ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case intelligentMobility.diagram.edit.parts.IntersectionEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramUpdater
						.getIntersection_2007ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case intelligentMobility.diagram.edit.parts.Vehicle_ConfigurationEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramUpdater
						.getVehicle_Configuration_2008ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case intelligentMobility.diagram.edit.parts.Environment_ConditionEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramUpdater
						.getEnvironment_Condition_2009ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case intelligentMobility.diagram.edit.parts.PlatoonEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramUpdater
						.getPlatoon_2010ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case intelligentMobility.diagram.edit.parts.ForwardEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramUpdater
						.getForward_2011ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case intelligentMobility.diagram.edit.parts.Lane_TypeEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramUpdater
						.getLane_Type_2012ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case intelligentMobility.diagram.edit.parts.Environment_BackgroundEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramUpdater
						.getEnvironment_Background_2013ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case intelligentMobility.diagram.edit.parts.TurnEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramUpdater
						.getTurn_2014ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case intelligentMobility.diagram.edit.parts.LaneChangingEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramUpdater
						.getLaneChanging_2015ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case intelligentMobility.diagram.edit.parts.Driver_EmotionEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramUpdater
						.getDriver_Emotion_2016ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case intelligentMobility.diagram.edit.parts.CollisionEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramUpdater
						.getCollision_2017ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case intelligentMobility.diagram.edit.parts.PossibleVehicleEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramUpdater
						.getPossibleVehicle_2018ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case intelligentMobility.diagram.edit.parts.FollowingEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramUpdater
						.getFollowing_2019ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case intelligentMobility.diagram.edit.parts.GapAcceptanceEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramUpdater
						.getGapAcceptance_2020ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case intelligentMobility.diagram.edit.parts.Leading_VehicleEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramUpdater
						.getLeading_Vehicle_2021ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case intelligentMobility.diagram.edit.parts.BackwardEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramUpdater
						.getBackward_2022ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case intelligentMobility.diagram.edit.parts.RegulationEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramUpdater
						.getRegulation_2023ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case intelligentMobility.diagram.edit.parts.Traffic_SituationEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramUpdater
						.getTraffic_Situation_2024ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case intelligentMobility.diagram.edit.parts.Driver_ProfileEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramUpdater
						.getDriver_Profile_2025ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case intelligentMobility.diagram.edit.parts.Safety_RequirementEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramUpdater
						.getSafety_Requirement_2026ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case intelligentMobility.diagram.edit.parts.Driving_BehaviourEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramUpdater
						.getDriving_Behaviour_2027ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case intelligentMobility.diagram.edit.parts.Following_VehicleEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramUpdater
						.getFollowing_Vehicle_2028ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case intelligentMobility.diagram.edit.parts.Abnormal_BehaviourEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramUpdater
						.getAbnormal_Behaviour_2029ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case intelligentMobility.diagram.edit.parts.Backward2EditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramUpdater
						.getBackward_2030ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case intelligentMobility.diagram.edit.parts.Intersection2EditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramUpdater
						.getIntersection_2031ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case intelligentMobility.diagram.edit.parts.CommunicationInterfaceEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramUpdater
						.getCommunicationInterface_2032ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case intelligentMobility.diagram.edit.parts.GoalEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramUpdater
						.getGoal_2033ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case intelligentMobility.diagram.edit.parts.Normal_BehaviourEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramUpdater
						.getNormal_Behaviour_2034ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case intelligentMobility.diagram.edit.parts.Platoon2EditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramUpdater
						.getPlatoon_2035ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case intelligentMobility.diagram.edit.parts.Normal_VehicleEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramUpdater
						.getNormal_Vehicle_2036ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case intelligentMobility.diagram.edit.parts.CooperativeBehaviorEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramUpdater
						.getCooperativeBehavior_2037ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case intelligentMobility.diagram.edit.parts.ActionEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramUpdater
						.getAction_2039ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case intelligentMobility.diagram.edit.parts.Link_LaneType_RegulationEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramUpdater
						.getLink_LaneType_Regulation_4001ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case intelligentMobility.diagram.edit.parts.Link_Driver_VehicleEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramUpdater
						.getLink_Driver_Vehicle_4002ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case intelligentMobility.diagram.edit.parts.Link_EnvironmentBackground_PossibleVehicleEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramUpdater
						.getLink_EnvironmentBackground_PossibleVehicle_4003ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case intelligentMobility.diagram.edit.parts.Link_Vehicle_EnvironmentEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramUpdater
						.getLink_Vehicle_Environment_4004ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case intelligentMobility.diagram.edit.parts.Link_NormalVehicle_SafetyRequirementsEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramUpdater
						.getLink_NormalVehicle_SafetyRequirements_4005ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case intelligentMobility.diagram.edit.parts.Link_DriverProfile_DriverPreferenceEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramUpdater
						.getLink_DriverProfile_DriverPreference_4006ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case intelligentMobility.diagram.edit.parts.Link_Collision_ObstructionEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramUpdater
						.getLink_Collision_Obstruction_4007ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case intelligentMobility.diagram.edit.parts.Link_Platoon_FollowingVehicleEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramUpdater
						.getLink_Platoon_FollowingVehicle_4008ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case intelligentMobility.diagram.edit.parts.Link_DriverPreference_EnvironmentConditionEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramUpdater
						.getLink_DriverPreference_EnvironmentCondition_4009ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case intelligentMobility.diagram.edit.parts.Link_AbnormalBehaviour_ActionEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramUpdater
						.getLink_AbnormalBehaviour_Action_4010ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case intelligentMobility.diagram.edit.parts.Link_Following_ForwardEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramUpdater
						.getLink_Following_Forward_4011ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_LaneTypeEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramUpdater
						.getLink_EnvironmentCondition_LaneType_4012ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case intelligentMobility.diagram.edit.parts.Link_VehicleConfiguration_VehicleTypeEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramUpdater
						.getLink_VehicleConfiguration_VehicleType_4013ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case intelligentMobility.diagram.edit.parts.Link_Platoon_LeadingVehicleEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramUpdater
						.getLink_Platoon_LeadingVehicle_4014ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case intelligentMobility.diagram.edit.parts.Link_Driver_EnvironmentEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramUpdater
						.getLink_Driver_Environment_4015ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case intelligentMobility.diagram.edit.parts.Link_LaneChanging_TurnEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramUpdater
						.getLink_LaneChanging_Turn_4016ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_TrafficConditionEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramUpdater
						.getLink_EnvironmentCondition_TrafficCondition_4017ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case intelligentMobility.diagram.edit.parts.Link_Intersection_TrafficLightEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramUpdater
						.getLink_Intersection_TrafficLight_4018ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case intelligentMobility.diagram.edit.parts.Link_Following_MinGapEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramUpdater
						.getLink_Following_MinGap_4019ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case intelligentMobility.diagram.edit.parts.Link_NormalBehaviour_LaneChangingEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramUpdater
						.getLink_NormalBehaviour_LaneChanging_4020ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case intelligentMobility.diagram.edit.parts.Link_SafetyRequirement_RegulationEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramUpdater
						.getLink_SafetyRequirement_Regulation_4021ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case intelligentMobility.diagram.edit.parts.Link_DriverPreference_DrivingBehaviourEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramUpdater
						.getLink_DriverPreference_DrivingBehaviour_4022ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case intelligentMobility.diagram.edit.parts.Link_FollowingVehicle_FrontVehicleEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramUpdater
						.getLink_FollowingVehicle_FrontVehicle_4023ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case intelligentMobility.diagram.edit.parts.Link_DriverPreference_DriverEmotionEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramUpdater
						.getLink_DriverPreference_DriverEmotion_4024ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case intelligentMobility.diagram.edit.parts.Link_EnvironmentBackground_EnvironmentConditionEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramUpdater
						.getLink_EnvironmentBackground_EnvironmentCondition_4025ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_WeatherEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramUpdater
						.getLink_EnvironmentCondition_Weather_4026ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_SpecialConditionEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramUpdater
						.getLink_EnvironmentCondition_SpecialCondition_4027ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case intelligentMobility.diagram.edit.parts.Link_SpecialCondition_IntersectionEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramUpdater
						.getLink_SpecialCondition_Intersection_4028ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case intelligentMobility.diagram.edit.parts.Link_Following_BackwardEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramUpdater
						.getLink_Following_Backward_4029ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case intelligentMobility.diagram.edit.parts.Link_EnvironmentCondition_RegulationsEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramUpdater
						.getLink_EnvironmentCondition_Regulations_4030ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case intelligentMobility.diagram.edit.parts.Link_DrivingBehaviour_NormalBehaviourEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramUpdater
						.getLink_DrivingBehaviour_NormalBehaviour_4031ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case intelligentMobility.diagram.edit.parts.Link_LaneChanging_EnvironmentConditionEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramUpdater
						.getLink_LaneChanging_EnvironmentCondition_4032ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case intelligentMobility.diagram.edit.parts.Link_LaneChanging_GapAcceptanceEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramUpdater
						.getLink_LaneChanging_GapAcceptance_4033ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case intelligentMobility.diagram.edit.parts.Link_NormalBehaviour_FollowingEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramUpdater
						.getLink_NormalBehaviour_Following_4034ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case intelligentMobility.diagram.edit.parts.Link_Infrastructure_VehicleConfigurationEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramUpdater
						.getLink_Infrastructure_VehicleConfiguration_4035ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case intelligentMobility.diagram.edit.parts.Link_CommunicationInterface_VehicleConfigurationEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramUpdater
						.getLink_CommunicationInterface_VehicleConfiguration_4036ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case intelligentMobility.diagram.edit.parts.Link_Goal_DrivingBehaviourEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramUpdater
						.getLink_Goal_DrivingBehaviour_4037ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case intelligentMobility.diagram.edit.parts.Link_CooperativeBehaviour_CommunicationInterfaceEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramUpdater
						.getLink_CooperativeBehaviour_CommunicationInterface_4038ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case intelligentMobility.diagram.edit.parts.Link_CommunicationInterface_InfrastructureEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramUpdater
						.getLink_CommunicationInterface_Infrastructure_4039ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case intelligentMobility.diagram.edit.parts.Link_CooperativeBehaviour_VehicleConfigurationEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramUpdater
						.getLink_CooperativeBehaviour_VehicleConfiguration_4040ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case intelligentMobility.diagram.edit.parts.Link_TrafficSituation_EnvironmentConditionEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramUpdater
						.getLink_TrafficSituation_EnvironmentCondition_4041ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case intelligentMobility.diagram.edit.parts.Link_Collision_SpecialConditionEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramUpdater
						.getLink_Collision_SpecialCondition_4042ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case intelligentMobility.diagram.edit.parts.Link_Following_LaneChangingEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramUpdater
						.getLink_Following_LaneChanging_4043ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case intelligentMobility.diagram.edit.parts.Link_Action_BackwardEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramUpdater
						.getLink_Action_Backward_4044ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case intelligentMobility.diagram.edit.parts.Link_Action_ForwardEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramUpdater
						.getLink_Action_Forward_4045ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case intelligentMobility.diagram.edit.parts.Link_Action_TurnEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramUpdater
						.getLink_Action_Turn_4046ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case intelligentMobility.diagram.edit.parts.Link_KnowledgeAndSkill_DriverPreferenceEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramUpdater
						.getLink_KnowledgeAndSkill_DriverPreference_4047ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		}
		for (Iterator children = view.getChildren().iterator(); children.hasNext();) {
			result.addAll(collectAllLinks((View) children.next(), domain2NotationMap));
		}
		for (Iterator edges = view.getSourceEdges().iterator(); edges.hasNext();) {
			result.addAll(collectAllLinks((View) edges.next(), domain2NotationMap));
		}
		return result;
	}

	/**
	* @generated
	*/
	private Collection/*[org.eclipse.core.runtime.IAdaptable]*/ createConnections(
			Collection/*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ linkDescriptors,
			Domain2Notation domain2NotationMap) {
		LinkedList/*[org.eclipse.core.runtime.IAdaptable]*/ adapters = new LinkedList/*[org.eclipse.core.runtime.IAdaptable]*/();
		for (Iterator /*[intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor]*/ it = linkDescriptors
				.iterator(); it.hasNext();) {
			intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor nextLinkDescriptor = (intelligentMobility.diagram.part.DrivingBehaviourMetamodelLinkDescriptor) it
					.next();
			EditPart sourceEditPart = getSourceEditPart(nextLinkDescriptor, domain2NotationMap);
			EditPart targetEditPart = getTargetEditPart(nextLinkDescriptor, domain2NotationMap);
			if (sourceEditPart == null || targetEditPart == null) {
				continue;
			}
			CreateConnectionViewRequest.ConnectionViewDescriptor descriptor = new CreateConnectionViewRequest.ConnectionViewDescriptor(
					nextLinkDescriptor.getSemanticAdapter(),
					intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry
							.getType(nextLinkDescriptor.getVisualID()),
					ViewUtil.APPEND, false, ((IGraphicalEditPart) getHost()).getDiagramPreferencesHint());
			CreateConnectionViewRequest ccr = new CreateConnectionViewRequest(descriptor);
			ccr.setType(RequestConstants.REQ_CONNECTION_START);
			ccr.setSourceEditPart(sourceEditPart);
			sourceEditPart.getCommand(ccr);
			ccr.setTargetEditPart(targetEditPart);
			ccr.setType(RequestConstants.REQ_CONNECTION_END);
			Command cmd = targetEditPart.getCommand(ccr);
			if (cmd != null && cmd.canExecute()) {
				executeCommand(cmd);
				IAdaptable viewAdapter = (IAdaptable) ccr.getNewObject();
				if (viewAdapter != null) {
					adapters.add(viewAdapter);
				}
			}
		}
		return adapters;
	}

	/**
	* @generated
	*/
	private EditPart getEditPart(EObject domainModelElement, Domain2Notation domain2NotationMap) {
		View view = (View) domain2NotationMap.get(domainModelElement);
		if (view != null) {
			return (EditPart) getHost().getViewer().getEditPartRegistry().get(view);
		}
		return null;
	}

	/**
	* @generated
	*/
	private Diagram getDiagram() {
		return ((View) getHost().getModel()).getDiagram();
	}

	/**
	* @generated
	*/
	private EditPart getSourceEditPart(UpdaterLinkDescriptor descriptor, Domain2Notation domain2NotationMap) {
		return getEditPart(descriptor.getSource(), domain2NotationMap);
	}

	/**
	* @generated
	*/
	private EditPart getTargetEditPart(UpdaterLinkDescriptor descriptor, Domain2Notation domain2NotationMap) {
		return getEditPart(descriptor.getDestination(), domain2NotationMap);
	}

	/**
	* @generated
	*/
	protected final EditPart getHintedEditPart(EObject domainModelElement, Domain2Notation domain2NotationMap,
			int hintVisualId) {
		View view = (View) domain2NotationMap.getHinted(domainModelElement,
				intelligentMobility.diagram.part.DrivingBehaviourMetamodelVisualIDRegistry.getType(hintVisualId));
		if (view != null) {
			return (EditPart) getHost().getViewer().getEditPartRegistry().get(view);
		}
		return null;
	}

	/**
	* @generated
	*/
	@SuppressWarnings("serial")
	protected static class Domain2Notation
			extends HashMap/*[org.eclipse.emf.ecore.EObject, org.eclipse.gmf.runtime.notation.View]*/ {
		/**
		* @generated
		*/
		public boolean containsDomainElement(EObject domainElement) {
			return this.containsKey(domainElement);
		}

		/**
		* @generated
		*/
		public View getHinted(EObject domainEObject, String hint) {
			return (View) this.get(domainEObject);
		}

		/**
		* @generated
		*/
		public void putView(EObject domainElement, View view) {
			if (!containsKey(view.getElement())) {
				this.put(domainElement, view);
			}
		}

	}
}
