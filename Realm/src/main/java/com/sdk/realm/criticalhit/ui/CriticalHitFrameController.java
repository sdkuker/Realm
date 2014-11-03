package com.sdk.realm.criticalhit.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListModel;

import com.sdk.realm.character.domain.GameCharacter;
import com.sdk.realm.combat.domain.CombatEncounter;
import com.sdk.realm.combat.domain.CombatEncounterWarehouse;
import com.sdk.realm.combat.domain.Round;
import com.sdk.realm.criticalhit.domain.CriticalHit;
import com.sdk.realm.criticalhit.domain.CriticalHitLibrary;
import com.sdk.realm.domain.common.Die;
import com.sdk.realm.ui.Controller;

public class CriticalHitFrameController extends Controller {

	private CriticalHitJFrame _criticalHitFrame = null;
	private DefaultComboBoxModel _typeComboBoxModel = null;
	private DefaultComboBoxModel _defenderComboBoxModel = null;
	private DefaultComboBoxModel _severityComboBoxModel = null;
	private DefaultListModel _criticalsListModel = null;
	private Die _oneHundredSidedDie = null;
	private int _mostRecentRollValue = 0;
	private CombatEncounter _combatEncounter;
	private Map<String, GameCharacter> _charactersByName = new HashMap<String, GameCharacter>();
	private Map<Integer, CriticalHitAssociation> _criticalHitsByListModelPosition = new HashMap<Integer, CriticalHitAssociation>();
	
	public CriticalHitFrameController() {
		this(null);
	}
	
	public CriticalHitFrameController(CombatEncounter aCombatEncounter) {
		super();
		_oneHundredSidedDie = new Die(100);
		if (aCombatEncounter != null) {
			_combatEncounter = aCombatEncounter;
		}
	}

	public void setFrame(CriticalHitJFrame aFrame) {
		_criticalHitFrame = aFrame;
		aFrame.setLocation(20,20);
	}
	public void makeFrameVisable() {
		_criticalHitFrame.pack();
		_criticalHitFrame.setVisible(true);
		updateCriticalsListModel();
	}

	void normalRollButtonClicked() {
		_mostRecentRollValue = _oneHundredSidedDie.roll();
		updateAttackTotal();
	}
	
	void typeJComboBoxItemSelected() {
		//clearCriticalHitDescriptionJTextArea();
		setSeverityForSelectedType((String) _criticalHitFrame.getTypeJComboBox().getSelectedItem());
	}
	
	void severityJComboBoxItemSelected() {
		//clearCriticalHitDescriptionJTextArea();
	}

	private void setSeverityForSelectedType(String aType) {
		
		Object[] typeSeverities = CriticalHitLibrary.getCurrent().getCriticalHitSeveritiesForType(aType).toArray();
		Arrays.sort(typeSeverities);
		_severityComboBoxModel.removeAllElements();
		for (int index = 0; index < typeSeverities.length; index++) {
			_severityComboBoxModel.addElement(typeSeverities[index]);
		}
	}
	void listCriticalsButtonClicked() {
		
		String type = (String) _criticalHitFrame.getTypeJComboBox().getSelectedItem();
		String severity = (String) _criticalHitFrame.getSeverityJComboBox().getSelectedItem();
		List<CriticalHit> criticalHits = CriticalHitLibrary.getCurrent().getCriticalHits(type, severity);
		_criticalsListModel.clear();
		for (CriticalHit aHit: criticalHits) {
			_criticalsListModel.addElement(aHit.getDescription());
		}
		_criticalHitFrame.getDefenderJComboBox().setSelectedItem(null);
	}
	
	
	void getCriticalButtonClicked() {
		String type = (String) _criticalHitFrame.getTypeJComboBox().getSelectedItem();
		String severity = (String) _criticalHitFrame.getSeverityJComboBox().getSelectedItem();
		int attackValue = new Integer((Integer)_criticalHitFrame.getAttackTotalJSpinner().getModel().getValue()).intValue();
		CriticalHit selectedHit = CriticalHitLibrary.getCurrent().getCriticalHit(type, severity, attackValue);
		if (selectedHit == null) {
			String displayText = "No critical hit was found that matches the type, value, and roll";
			_criticalsListModel.addElement(displayText);
		}
		else {
			_combatEncounter.getOpenRound().addCriticalHitSufferedForCharacter(getDefenderCharacter(), selectedHit);
			CombatEncounterWarehouse.getCurrent().updateCombatEncounter(_combatEncounter);
			updateCriticalsListModel();
		}
	}
	
	void deleteCriticalJButtonClicked() {
		
		if (_criticalHitFrame.getCriticalsJList().getSelectedIndex() < 0) {
			JOptionPane.showMessageDialog(_criticalHitFrame, "Must select a critical hit to delete");
		} else {
			int selectedIndex = _criticalHitFrame.getCriticalsJList().getSelectedIndex();
			CriticalHitAssociation selectedAssociation = _criticalHitsByListModelPosition.get(Integer.valueOf(selectedIndex));
			_combatEncounter.getRound(selectedAssociation.getRoundNumber()).
				removeCriticalHitSufferedForCharacter(getDefenderCharacter(), selectedAssociation.getCriticalHit());
			CombatEncounterWarehouse.getCurrent().updateCombatEncounter(_combatEncounter);
			updateCriticalsListModel();
		}
	}
	
	private GameCharacter getDefenderCharacter() {
		
		String characterName = (String) _criticalHitFrame.getDefenderJComboBox().getSelectedItem();
		return _charactersByName.get(characterName);
	}
	
	void defenderSelected() {
		updateCriticalsListModel();
	}
	
	private void updateCriticalsListModel() {
		
		List<CriticalHitAssociation> allCriticalHitAssociations = new ArrayList<CriticalHitAssociation>();
		GameCharacter defender = getDefenderCharacter();
		if (defender != null) {
			for (Round aRound: _combatEncounter.getRounds()) {
				allCriticalHitAssociations.addAll( 
						createCriticalHitAssociationList(aRound.getRoundNumber(), aRound.getAllCriticalHitsForCharacter(defender)));
			}
		} else {
			String type = (String) _criticalHitFrame.getTypeJComboBox().getSelectedItem();
			String severity = (String) _criticalHitFrame.getSeverityJComboBox().getSelectedItem();
			allCriticalHitAssociations.addAll( 
					createCriticalHitAssociationList(0, CriticalHitLibrary.getCurrent().getCriticalHits(type, severity)));
		}

		
		_criticalsListModel.clear();
		_criticalHitsByListModelPosition.clear();
		Integer roundNumberBeingAdded = 0;
		for (CriticalHitAssociation aCriticalHitAssociation : allCriticalHitAssociations) {
			if (aCriticalHitAssociation.getRoundNumber() != roundNumberBeingAdded ) {
				roundNumberBeingAdded = aCriticalHitAssociation.getRoundNumber();
				StringBuilder prefix = new StringBuilder();
				prefix.append("Round: ");
				prefix.append(roundNumberBeingAdded); 
				_criticalsListModel.addElement(prefix.toString());
			}
			_criticalsListModel.addElement(aCriticalHitAssociation.getCriticalHit().getDescription());
			_criticalHitsByListModelPosition.put(_criticalsListModel.size() - 1, aCriticalHitAssociation);
		}
	}
	
	private  List<CriticalHitAssociation> createCriticalHitAssociationList(Integer roundNumber, List<CriticalHit> listOfCriticalHits) {
		
		List<CriticalHitAssociation> theReturn = new ArrayList<CriticalHitAssociation>();
		for (CriticalHit aCriticalHit : listOfCriticalHits) {
			theReturn.add(new CriticalHitAssociation(aCriticalHit, roundNumber));
		}
		return theReturn;
	}
	
	void openEndedRollButtonClicked() {
		_mostRecentRollValue = _oneHundredSidedDie.rollOpenEnded();
		updateAttackTotal();

	}
	
	private void updateAttackTotal() {
	
		int attackerBonus = ((Integer)_criticalHitFrame.getAttackerBonusJSpinner().getModel().getValue()).intValue();
		int defenderBonus = ((Integer)_criticalHitFrame.getDefenderBonusJSpinner().getModel().getValue()).intValue();
		int attackTotal = _mostRecentRollValue + attackerBonus - defenderBonus;
		_criticalHitFrame.getAttackTotalJSpinner().getModel().setValue(attackTotal);
	}
	

	
	ComboBoxModel getTypeComboBoxModel() {
		if (_typeComboBoxModel == null) {
			initializeTypeComboBoxModel();
		}
		return _typeComboBoxModel;
	}
	private void initializeTypeComboBoxModel() {
		Object[] allTypes = CriticalHitLibrary.getCurrent().getAllCriticalHitTypes().toArray();
		Arrays.sort(allTypes);
		_typeComboBoxModel = new DefaultComboBoxModel(allTypes);

	}
	
	ComboBoxModel getDefenderComboBoxModel() {
		if (_defenderComboBoxModel == null) {
			initializeDefenderComboBoxModel();
		}
		return _defenderComboBoxModel;
	}
	private void initializeDefenderComboBoxModel() {
	
		if (_combatEncounter != null) {
			List<GameCharacter> allCharacters = _combatEncounter.getOpenRound().getAllCharacters();
			List<String> allCharacterNames = new ArrayList<String>();
			for (GameCharacter aCharacter : allCharacters) {
				allCharacterNames.add(aCharacter.getName());
				_charactersByName.put(aCharacter.getName(), aCharacter);
			}
			Object[] allDefenders = allCharacterNames.toArray();
			Arrays.sort(allDefenders);
			_defenderComboBoxModel = new DefaultComboBoxModel(allDefenders);
		} else {
			_defenderComboBoxModel = new DefaultComboBoxModel();
		}
	}
	
	ListModel getCriticalsListModel() {
		if (_criticalsListModel == null) {
			initializeCriticalsListModel();
		}
		return _criticalsListModel;
	}
	private void initializeCriticalsListModel() {
		_criticalsListModel = new DefaultListModel();
		_criticalsListModel.capacity();
	}

	ComboBoxModel getSeverityComboBoxModel() {
		if (_severityComboBoxModel == null) {
			initializeSeverityComboBoxModel();
		}
		return _severityComboBoxModel;
	}
	private void initializeSeverityComboBoxModel() {
		Object[] allSeverities = CriticalHitLibrary.getCurrent().getAllCriticalHitSeverities().toArray();
		Arrays.sort(allSeverities);
		_severityComboBoxModel = new DefaultComboBoxModel(allSeverities);
	}
	
	void attackTotalSpinnerStateChanged() {
		//clearCriticalHitDescriptionJTextArea();
	}
	
	void attackerBonusSpinnerStateChanged() {
		updateAttackTotal();
	}
	
	void defenderBonusSpinnerStateChanged() {
		updateAttackTotal();
	}

	private class CriticalHitAssociation {
		private CriticalHit criticalHit;
		private Integer roundNumber;
		
		public CriticalHitAssociation(CriticalHit aCriticalHit, Integer aRoundNumber) {
			super();
			criticalHit = aCriticalHit;
			roundNumber = aRoundNumber;
		}
		public CriticalHit getCriticalHit() {
			return criticalHit;
		}
		public Integer getRoundNumber() {
			return roundNumber;
		}
		
	}
}
