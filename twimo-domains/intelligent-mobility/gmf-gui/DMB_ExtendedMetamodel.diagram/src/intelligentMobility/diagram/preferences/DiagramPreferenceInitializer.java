package intelligentMobility.diagram.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

/**
 * @generated
 */
public class DiagramPreferenceInitializer extends AbstractPreferenceInitializer {

	/**
	* @generated
	*/
	public void initializeDefaultPreferences() {
		IPreferenceStore store = getPreferenceStore();
		intelligentMobility.diagram.preferences.DiagramGeneralPreferencePage.initDefaults(store);
		intelligentMobility.diagram.preferences.DiagramAppearancePreferencePage.initDefaults(store);
		intelligentMobility.diagram.preferences.DiagramConnectionsPreferencePage.initDefaults(store);
		intelligentMobility.diagram.preferences.DiagramPrintingPreferencePage.initDefaults(store);
		intelligentMobility.diagram.preferences.DiagramRulersAndGridPreferencePage.initDefaults(store);

	}

	/**
	* @generated
	*/
	protected IPreferenceStore getPreferenceStore() {
		return intelligentMobility.diagram.part.DrivingBehaviourMetamodelDiagramEditorPlugin.getInstance()
				.getPreferenceStore();
	}
}
