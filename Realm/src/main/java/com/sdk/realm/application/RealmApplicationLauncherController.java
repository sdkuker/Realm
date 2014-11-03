package com.sdk.realm.application;

import javax.swing.JOptionPane;

import com.sdk.realm.character.ui.CharacterListFrameController;
import com.sdk.realm.character.ui.CharacterListJFrame;
import com.sdk.realm.combat.ui.CombatListFrameController;
import com.sdk.realm.combat.ui.CombatListJFrame;
import com.sdk.realm.criticalhit.ui.CriticalHitFrameController;
import com.sdk.realm.criticalhit.ui.CriticalHitJFrame;
import com.sdk.realm.dieroller.ui.DieRollerFrameController;
import com.sdk.realm.dieroller.ui.DieRollerJFrame;
import com.sdk.realm.herblore.ui.HerbLoreFrameController;
import com.sdk.realm.herblore.ui.HerbLoreJFrame;
import com.sdk.realm.item.ui.ItemListFrameController;
import com.sdk.realm.item.ui.ItemListJFrame;
import com.sdk.realm.movement.maneuver.ui.MovementManeuverFrameController;
import com.sdk.realm.movement.maneuver.ui.MovementManeuverJFrame;
import com.sdk.realm.player.ui.PlayerFrameController;
import com.sdk.realm.player.ui.PlayerJFrame;
import com.sdk.realm.resistancetable.domain.ResistanceTableCalculator;
import com.sdk.realm.resistancetable.ui.ResistanceTableFrame;
import com.sdk.realm.resistancetable.ui.ResistanceTableFrameController;
import com.sdk.realm.ui.Controller;
import com.sdk.realm.util.PropertyWarehouse;
import com.sdk.realm.util.RealmPropertyNames;
import com.sdk.realm.willcontest.ui.WillContestListFrameController;
import com.sdk.realm.willcontest.ui.WillContestListJFrame;

public class RealmApplicationLauncherController extends Controller {

	private RealmApplicationLauncherJFrame _realmApplicationLauncherFrame = null;
	
	// controllers for all the different applications
	private ResistanceTableFrameController _resistanceTableFrameController = null;
	private CriticalHitFrameController _criticalHitFrameController = null;
	private DieRollerFrameController _dieRollerFrameController = null;
	private PlayerFrameController _playerFrameController = null;
	private CharacterListFrameController _characterListFrameController = null;
	private HerbLoreFrameController _herbLoreFrameController = null;
	private CombatListFrameController _combatListFrameController = null;
	private ItemListFrameController _itemListFrameController = null;
	private WillContestListFrameController _willContestListFrameController = null;
	private MovementManeuverFrameController _movementManeuverFrameController = null;
	
	private static final String TEMP_CHARACTER_UUID_STRING = "2bb4f86e-0a14-414f-bf71-5332af2d7036";
	
	public RealmApplicationLauncherController(RealmApplicationLauncherJFrame aFrame) {
		_realmApplicationLauncherFrame  = aFrame;
	}
	
	void launchResistanceTableApplication() {
		if (_resistanceTableFrameController == null) {
			initializeResistanceTableFrameController();
		}
		_resistanceTableFrameController.makeFrameVisable();
	}
		
	private void initializeResistanceTableFrameController() {
		
		ResistanceTableFrame aFrame = new ResistanceTableFrame();
		aFrame.setTitle("Realm - Resistance Table");
		ResistanceTableCalculator aCalculator = new ResistanceTableCalculator();
		ResistanceTableFrameController aController = new ResistanceTableFrameController(aFrame, aCalculator);
		aFrame.setController(aController);
		_resistanceTableFrameController = aController;

	}
	
	void launchPlayerApplication() {
		if (_playerFrameController == null) {
			initializePlayerFrameController();
		}
		_playerFrameController.makeFrameVisable();
	}

	private void initializePlayerFrameController() {
		
		PlayerJFrame aFrame = new PlayerJFrame();
		aFrame.setTitle("Realm - Players");
		PlayerFrameController aController = new PlayerFrameController(aFrame);
		aFrame.setController(aController);
		_playerFrameController = aController;

	}
	
	void launchCombatApplication() {
		if (_combatListFrameController == null) {
			initializeCombatListFrameController();
		}
		_combatListFrameController.makeFrameVisable();
	}

	private void initializeCombatListFrameController() {
		
		CombatListJFrame aFrame = new CombatListJFrame();
		aFrame.setTitle("Realm - Combat Encounter List");
		CombatListFrameController aController = new CombatListFrameController(aFrame);
		aFrame.setController(aController);
		_combatListFrameController = aController;

	}

	
	void launchCharacterListApplication() {
		if (_characterListFrameController == null) {
			initializeCharacterListFrameController();
		}
		_characterListFrameController.makeFrameVisable();
	}

	private void initializeCharacterListFrameController() {
		
		CharacterListJFrame aFrame = new CharacterListJFrame();
		aFrame.setTitle("Realm - Characters");
		CharacterListFrameController aController = new CharacterListFrameController(aFrame);
		aFrame.setController(aController);
		_characterListFrameController = aController;

	}

	void launchItemListApplication() {
		if (_itemListFrameController == null) {
			initializeItemListFrameController();
		}
		_itemListFrameController.makeFrameVisable();
	}

	private void initializeItemListFrameController() {
		
		ItemListJFrame aFrame = new ItemListJFrame();
		aFrame.setTitle("Realm - Items");
		ItemListFrameController aController = new ItemListFrameController(aFrame);
		aFrame.setController(aController);
		_itemListFrameController = aController;

	}
	
	void launchWillContestListApplication() {
		if (_willContestListFrameController == null) {
			initializeWillContestListFrameController();
		}
		_willContestListFrameController.makeFrameVisable();
	}

	private void initializeWillContestListFrameController() {
		
		WillContestListJFrame aFrame = new WillContestListJFrame();
		aFrame.setTitle("Realm - Will Contests");
		WillContestListFrameController aController = new WillContestListFrameController(aFrame);
		aFrame.setController(aController);
		_willContestListFrameController = aController;
	}

	void launchMovementManeuverApplication() {
		if (_movementManeuverFrameController == null) {
			initializeMovementManeuverFrameController();
		}
		_movementManeuverFrameController.makeFrameVisable();
	}
	
	private void initializeMovementManeuverFrameController() {
		
		MovementManeuverFrameController aController = new MovementManeuverFrameController();
		MovementManeuverJFrame aFrame = new MovementManeuverJFrame(aController);
		aFrame.setTitle("Realm - Movement Maneuver");
		aController.setFrame(aFrame);
		_movementManeuverFrameController = aController;
	}
	
	void displayVersion() {
		String currentVersion = PropertyWarehouse.getCurrent().getProperty(RealmPropertyNames.VERSION);
		if (currentVersion == null) {
			currentVersion = "Unable to determine";
		}
		JOptionPane.showMessageDialog(_realmApplicationLauncherFrame, "Version: " + currentVersion);
	}

	void launchCriticalHitsApplication() {
		if (_criticalHitFrameController == null) {
			initializeCriticalHitFrameController();
		}
		_criticalHitFrameController.makeFrameVisable();
	}
	
	private void initializeCriticalHitFrameController() {
		
		CriticalHitFrameController aController = new CriticalHitFrameController();
		CriticalHitJFrame aFrame = new CriticalHitJFrame(aController);
		aFrame.setTitle("Realm - Critical Hits");
		aController.setFrame(aFrame);
		_criticalHitFrameController = aController;

	}
	
	void launchHerbLoreApplication() {
		if (_herbLoreFrameController == null) {
			initializeHerbLoreFrameController();
		}
		_herbLoreFrameController.makeFrameVisable();
	}
	
	private void initializeHerbLoreFrameController() {
		
		HerbLoreFrameController aController = new HerbLoreFrameController();
		HerbLoreJFrame aFrame = new HerbLoreJFrame(aController);
		aFrame.setTitle("Realm - Herb Lore");
		aController.setFrame(aFrame);
		_herbLoreFrameController = aController;

	}
	
	void launchDieRollerApplication() {
		if (_dieRollerFrameController == null) {
			initializeDieRollerFrameController();
		}
		_dieRollerFrameController.makeFrameVisable();
	}
	
	private void initializeDieRollerFrameController() {
		
		DieRollerFrameController aController = new DieRollerFrameController();
		DieRollerJFrame aFrame = new DieRollerJFrame(aController);
		aFrame.setTitle("Realm - Die Roller");
		aController.setFrame(aFrame);
		_dieRollerFrameController = aController;

	}


	public void makeFrameVisable() {
		_realmApplicationLauncherFrame.pack();
		_realmApplicationLauncherFrame.setVisible(true);
	}

}
